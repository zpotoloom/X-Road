/**
 * The MIT License
 * Copyright (c) 2015 Estonian Information System Authority (RIA), Population Register Centre (VRK)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ee.ria.xroad.common.conf.serverconf.dao;

import static ee.ria.xroad.common.conf.serverconf.ServerConfDatabaseCtx.get;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import ee.ria.xroad.common.identifier.XRoadId;

/**
 * Identifier data access object implementation.
 */
public class IdentifierDAOImpl extends AbstractDAOImpl<XRoadId> {

    /**
     * Returns the identifier.
     * @param example the example type
     * @param <T> the type of the example
     * @return the identifier
     * @throws Exception if an error occurs
     */
    @SuppressWarnings("unchecked")
    public static <T extends XRoadId> T getIdentifier(T example)
            throws Exception {
        Criteria criteria =
                get().getSession().createCriteria(example.getClass());
        criteria.add(Example.create(example));
        return (T) criteria.uniqueResult();
    }
}
