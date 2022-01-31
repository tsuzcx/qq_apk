package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.mm.ae.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.av.e;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.ik;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Map<Long, Integer> iiW = new HashMap();
  
  public static void aL(List<q> paramList)
  {
    if (bk.dk(paramList)) {}
    LinkedList localLinkedList;
    do
    {
      return;
      localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        q localq = (q)paramList.next();
        if (((!iiW.containsKey(Long.valueOf(localq.field_msgId))) || (oG(((Integer)iiW.get(Long.valueOf(localq.field_msgId))).intValue()))) && (localq.ctz()))
        {
          Object localObject = ((com.tencent.mm.plugin.biz.a.a)g.r(com.tencent.mm.plugin.biz.a.a.class)).d(localq.field_msgId, localq.field_content);
          if ((localObject != null) && (!bk.dk(((com.tencent.mm.ae.l)localObject).dTx))) {
            try
            {
              localObject = ((com.tencent.mm.ae.l)localObject).dTx.iterator();
              while (((Iterator)localObject).hasNext())
              {
                m localm = (m)((Iterator)localObject).next();
                ik localik = new ik();
                localik.sxi = localq.field_talker;
                localik.sxm = localq.field_msgId;
                if (!bk.bl(localm.url))
                {
                  localik.url = localm.url;
                  localLinkedList.add(localik);
                  iiW.put(Long.valueOf(localq.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
                }
              }
            }
            catch (UnsupportedOperationException localUnsupportedOperationException)
            {
              y.w("MicroMsg.ConversationAdapter", "postDoGetCommentReward exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
            }
            catch (Exception localException)
            {
              y.w("MicroMsg.ConversationAdapter", "postDoGetCommentReward exp %s", new Object[] { localException.getMessage() });
            }
          }
        }
      }
    } while (bk.dk(localLinkedList));
    g.DO().dJT.a(new com.tencent.mm.plugin.brandservice.b.l(localLinkedList), 0);
  }
  
  public static void aM(List<q> paramList)
  {
    g.DS().O(new c.2(paramList));
  }
  
  public static String ayD()
  {
    Object localObject2 = null;
    e locale = com.tencent.mm.av.a.Pw();
    Object localObject1 = localObject2;
    if (locale != null)
    {
      localObject1 = localObject2;
      if (locale.eux != null)
      {
        localObject1 = localObject2;
        if (locale.euv == 0)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.av.a.Pu()) {
            localObject1 = locale.eux;
          }
        }
      }
    }
    return localObject1;
  }
  
  public static void f(q paramq)
  {
    if ((paramq == null) || (!paramq.ctz())) {
      return;
    }
    g.DS().O(new c.1(paramq));
  }
  
  public static boolean oG(int paramInt)
  {
    return System.currentTimeMillis() / 1000L - paramInt > a.iiR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c
 * JD-Core Version:    0.7.0.1
 */