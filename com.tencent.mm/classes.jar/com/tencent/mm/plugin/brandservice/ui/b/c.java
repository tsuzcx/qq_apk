package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.l;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Map<Long, Integer> kiW;
  
  static
  {
    AppMethodBeat.i(14458);
    kiW = new HashMap();
    AppMethodBeat.o(14458);
  }
  
  public static String Hv(String paramString)
  {
    AppMethodBeat.i(152663);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
      AppMethodBeat.o(152663);
      return paramString;
    }
    AppMethodBeat.o(152663);
    return null;
  }
  
  public static void aU(List<com.tencent.mm.storage.q> paramList)
  {
    AppMethodBeat.i(14456);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new c.2(paramList), 0L);
    AppMethodBeat.o(14456);
  }
  
  public static void aZ(List<com.tencent.mm.storage.q> paramList)
  {
    AppMethodBeat.i(14455);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(14455);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.storage.q localq = (com.tencent.mm.storage.q)paramList.next();
      if (((!kiW.containsKey(Long.valueOf(localq.field_msgId))) || (sN(((Integer)kiW.get(Long.valueOf(localq.field_msgId))).intValue()))) && (localq.dvV()))
      {
        Object localObject = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).b(localq.field_msgId, localq.field_content);
        if ((localObject != null) && (!bo.es(((com.tencent.mm.af.p)localObject).fjy))) {
          try
          {
            localObject = ((com.tencent.mm.af.p)localObject).fjy.iterator();
            while (((Iterator)localObject).hasNext())
            {
              com.tencent.mm.af.q localq1 = (com.tencent.mm.af.q)((Iterator)localObject).next();
              kd localkd = new kd();
              localkd.wqR = localq.field_talker;
              localkd.wqU = localq.field_msgId;
              if (!bo.isNullOrNil(localq1.url))
              {
                localkd.url = localq1.url;
                localLinkedList.add(localkd);
                kiW.put(Long.valueOf(localq.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
              }
            }
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            ab.w("MicroMsg.ConversationAdapter", "postDoGetCommentReward exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
          }
          catch (Exception localException)
          {
            ab.w("MicroMsg.ConversationAdapter", "postDoGetCommentReward exp %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
    if (bo.es(localLinkedList))
    {
      AppMethodBeat.o(14455);
      return;
    }
    g.RK().eHt.a(new l(localLinkedList), 0);
    AppMethodBeat.o(14455);
  }
  
  public static String aZX()
  {
    AppMethodBeat.i(14452);
    Object localObject2 = null;
    e locale = com.tencent.mm.aw.a.aiz();
    Object localObject1 = localObject2;
    if (locale != null)
    {
      localObject1 = localObject2;
      if (locale.fKj != null)
      {
        localObject1 = localObject2;
        if (locale.fKh == 0)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.aw.a.aiw()) {
            localObject1 = locale.fKj;
          }
        }
      }
    }
    AppMethodBeat.o(14452);
    return localObject1;
  }
  
  public static boolean b(com.tencent.mm.bv.a parama1, com.tencent.mm.bv.a parama2)
  {
    AppMethodBeat.i(14457);
    if ((parama1 == null) && (parama2 == null))
    {
      AppMethodBeat.o(14457);
      return true;
    }
    if ((parama1 == null) || (parama2 == null))
    {
      AppMethodBeat.o(14457);
      return false;
    }
    try
    {
      boolean bool = bo.isEqual(parama1.toByteArray(), parama2.toByteArray());
      AppMethodBeat.o(14457);
      return bool;
    }
    catch (IOException parama1)
    {
      ab.i("MicroMsg.ConversationAdapter", "isMsgStatInfoProtoEqual exp %s", new Object[] { parama1.getMessage() });
      AppMethodBeat.o(14457);
    }
    return false;
  }
  
  public static void g(com.tencent.mm.storage.q paramq)
  {
    AppMethodBeat.i(14454);
    if ((paramq == null) || (!paramq.dvV()))
    {
      AppMethodBeat.o(14454);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new c.1(paramq), 0L);
    AppMethodBeat.o(14454);
  }
  
  public static boolean sN(int paramInt)
  {
    AppMethodBeat.i(14453);
    if (System.currentTimeMillis() / 1000L - paramInt > a.kiQ)
    {
      AppMethodBeat.o(14453);
      return true;
    }
    AppMethodBeat.o(14453);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c
 * JD-Core Version:    0.7.0.1
 */