package com.tencent.mm.plugin.brandservice.ui.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.egc;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.po;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa.6;
import com.tencent.mm.storage.aa.7;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Map<Long, Integer> pMr;
  private static LinkedList<Long> pMs;
  
  static
  {
    AppMethodBeat.i(6257);
    pMr = new HashMap();
    pMs = new LinkedList();
    AppMethodBeat.o(6257);
  }
  
  public static boolean DW(int paramInt)
  {
    AppMethodBeat.i(6245);
    if (System.currentTimeMillis() / 1000L - paramInt > a.pMl)
    {
      AppMethodBeat.o(6245);
      return true;
    }
    AppMethodBeat.o(6245);
    return false;
  }
  
  private static void M(LinkedList<egc> paramLinkedList)
  {
    AppMethodBeat.i(6254);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(6254);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    synchronized (pMs)
    {
      if (Util.isNullOrNil(pMs)) {
        break label160;
      }
      localObject2 = new LinkedList();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        egc localegc = (egc)localIterator.next();
        if (pMs.contains(Long.valueOf(localegc.KWz))) {
          ((LinkedList)localObject2).add(localegc);
        }
      }
    }
    paramLinkedList.removeAll((Collection)localObject2);
    if (Util.isNullOrNil(paramLinkedList))
    {
      Log.d("MicroMsg.ConversationAdapter", "doUpdateRecommendCard is doing return %d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
      AppMethodBeat.o(6254);
      return;
    }
    label160:
    Object localObject2 = paramLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      localLinkedList.add(Long.valueOf(((egc)((Iterator)localObject2).next()).KWz));
    }
    pMs.addAll(localLinkedList);
    ??? = new d.a();
    ((d.a)???).iLN = new po();
    ((d.a)???).iLO = new pp();
    ((d.a)???).uri = "/cgi-bin/mmbiz-bin/timeline/bizrecommendcard";
    ((d.a)???).funcId = 2787;
    ??? = ((d.a)???).aXF();
    localObject2 = (po)((d)???).iLK.iLR;
    ((po)localObject2).KWD = paramLinkedList;
    com.tencent.mm.ak.aa.a((d)???, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, d paramAnonymousd, com.tencent.mm.ak.q paramAnonymousq)
      {
        AppMethodBeat.i(6242);
        Log.i("MicroMsg.ConversationAdapter", "[TRACE_BIZRECCARD] doUpdateRecommendCard check result errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ??? });
        synchronized (c.cri())
        {
          c.cri().removeAll(this.pMu);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            AppMethodBeat.o(6242);
            return 0;
          }
        }
        paramAnonymousd = (pp)paramAnonymousd.iLL.iLR;
        if (paramAnonymousd == null)
        {
          AppMethodBeat.o(6242);
          return 0;
        }
        MultiProcessMMKV.getSingleMMKV("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramAnonymousd.KSO));
        if (paramAnonymousd.KWD == null)
        {
          Log.i("MicroMsg.ConversationAdapter", "response.RecCard is null");
          AppMethodBeat.o(6242);
          return 0;
        }
        ??? = new LinkedList();
        paramAnonymousq = paramAnonymousd.KWD.iterator();
        while (paramAnonymousq.hasNext())
        {
          efz localefz = (efz)paramAnonymousq.next();
          Iterator localIterator = this.pMv.KWD.iterator();
          while (localIterator.hasNext())
          {
            egc localegc = (egc)localIterator.next();
            if (Util.isEqual(localegc.KWz, localefz.KWz)) {
              if (localefz.NfT == null)
              {
                Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard BizInfo is null");
              }
              else if ((localefz.NfT.KHa & 0x1) != 0)
              {
                ag.ban().MX(localefz.KWz);
                h.CyF.idkeyStat(1149L, 5L, 1L, false);
                Log.w("MicroMsg.ConversationAdapter", "doUpdateRecommendCard delete card by flag %d, msgId %d", new Object[] { Integer.valueOf(localefz.NfT.KHa), Long.valueOf(localefz.KWz) });
              }
              else if (Util.isNullOrNil(localefz.NfT.UserName))
              {
                Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserName is null");
              }
              else if ((Util.isNullOrNil(localefz.KWy)) || (localefz.KWy.get(0) == null) || (Util.isNullOrNil(((ega)localefz.KWy.get(0)).KSj)))
              {
                Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard ContentUrl is null");
              }
              else if (!Util.isEqual(localefz.Luh, localegc.Luh))
              {
                ???.add(localefz);
              }
              else
              {
                Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard VersionInfo isEqual");
                if ((localefz.NfU != null) && (!Util.isEqual(localefz.NfU.Luh, localegc.NfW)))
                {
                  ???.add(localefz);
                  Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserVersionInfo update");
                }
              }
            }
          }
        }
        Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard updateList size %d, RecCard.size %d", new Object[] { Integer.valueOf(???.size()), Integer.valueOf(paramAnonymousd.KWD.size()) });
        if (!Util.isNullOrNil(???))
        {
          paramAnonymousd = ag.ban();
          if (!Util.isNullOrNil(???))
          {
            paramAnonymousq = new LinkedList();
            com.tencent.mm.co.g.hio().h(new aa.7(paramAnonymousd, ???, paramAnonymousq)).b(new aa.6(paramAnonymousd, paramAnonymousq));
          }
        }
        AppMethodBeat.o(6242);
        return 0;
      }
    });
    AppMethodBeat.o(6254);
  }
  
  private static egc a(ege paramege, z paramz)
  {
    AppMethodBeat.i(6255);
    if ((paramege == null) || (paramege.NfY == null) || (paramz == null))
    {
      Log.i("MicroMsg.ConversationAdapter", "getTLRecCardLite invalid data");
      AppMethodBeat.o(6255);
      return null;
    }
    egc localegc = new egc();
    if (!Util.isNullOrNil(paramege.NfY.KWy))
    {
      Iterator localIterator = paramege.NfY.KWy.iterator();
      while (localIterator.hasNext())
      {
        ega localega = (ega)localIterator.next();
        localegc.KUB.add(localega.KSj);
      }
    }
    localegc.KSV = paramz.field_talker;
    localegc.KWz = paramz.field_msgId;
    localegc.Luh = paramege.NfY.Luh;
    localegc.KUh = paramege.style;
    if (paramege.NfY.NfU != null) {
      localegc.NfW = paramege.NfY.NfU.Luh;
    }
    AppMethodBeat.o(6255);
    return localegc;
  }
  
  public static void a(List<z> paramList, final Runnable paramRunnable)
  {
    AppMethodBeat.i(6248);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(195062);
        Looper.myQueue().removeIdleHandler(this);
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195061);
            Iterator localIterator = c.2.this.hjk.iterator();
            while (localIterator.hasNext())
            {
              z localz = (z)localIterator.next();
              if (localz.gAt()) {
                ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(localz.field_msgId, localz.field_content);
              }
            }
            c.cN(c.2.this.hjk);
            c.cO(c.2.this.hjk);
            MMHandlerThread.postToMainThread(c.2.this.val$callback);
            AppMethodBeat.o(195061);
          }
        }, 0L);
        AppMethodBeat.o(195062);
        return false;
      }
    });
    AppMethodBeat.o(6248);
  }
  
  public static String aiW(String paramString)
  {
    AppMethodBeat.i(6250);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
      AppMethodBeat.o(6250);
      return paramString;
    }
    AppMethodBeat.o(6250);
    return null;
  }
  
  public static boolean b(com.tencent.mm.bw.a parama1, com.tencent.mm.bw.a parama2)
  {
    AppMethodBeat.i(6249);
    if ((parama1 == null) && (parama2 == null))
    {
      AppMethodBeat.o(6249);
      return true;
    }
    if ((parama1 == null) || (parama2 == null))
    {
      AppMethodBeat.o(6249);
      return false;
    }
    try
    {
      boolean bool = Util.isEqual(parama1.toByteArray(), parama2.toByteArray());
      AppMethodBeat.o(6249);
      return bool;
    }
    catch (IOException parama1)
    {
      Log.i("MicroMsg.ConversationAdapter", "isMsgStatInfoProtoEqual exp %s", new Object[] { parama1.getMessage() });
      AppMethodBeat.o(6249);
    }
    return false;
  }
  
  public static void cL(List<z> paramList)
  {
    AppMethodBeat.i(6247);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(6247);
      return;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      z localz = (z)paramList.next();
      if ((!pMr.containsKey(Long.valueOf(localz.field_msgId))) || (DW(((Integer)pMr.get(Long.valueOf(localz.field_msgId))).intValue()))) {
        if (localz.gAt())
        {
          com.tencent.mm.ag.q localq = new com.tencent.mm.ag.q();
          localq.msgId = localz.field_msgId;
          localq.iAc = localz.field_content;
          localLinkedList1.add(localq);
          pMr.put(Long.valueOf(localz.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        }
        else
        {
          pMr.put(Long.valueOf(localz.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          localLinkedList2.add(localz);
        }
      }
    }
    if (localLinkedList1.size() > 0) {
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).l(localLinkedList1, 90);
    }
    AppMethodBeat.o(6247);
  }
  
  public static void cM(List<z> paramList)
  {
    AppMethodBeat.i(6251);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6241);
        c.cN(this.hjk);
        AppMethodBeat.o(6241);
      }
    }, 0L);
    AppMethodBeat.o(6251);
  }
  
  public static void cN(List<z> paramList)
  {
    AppMethodBeat.i(6252);
    int i = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (z)paramList.next();
      if ((((z)localObject).gAu()) && (!j.k((z)localObject)))
      {
        ege localege = ((z)localObject).gAD();
        if ((localege != null) && (localege.NfY != null) && (Math.abs(l - localege.lastUpdateTime) / 1000L > i))
        {
          localObject = a(localege, (z)localObject);
          if (localObject != null) {
            localLinkedList.add(localObject);
          }
        }
      }
    }
    if (!Util.isNullOrNil(localLinkedList)) {
      M(localLinkedList);
    }
    AppMethodBeat.o(6252);
  }
  
  public static void cO(List<z> paramList)
  {
    AppMethodBeat.i(195064);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      z localz = (z)paramList.next();
      r localr = r.NPl;
      if ((r.gzL()) && (localz.gAv()))
      {
        localLinkedList.add(localz);
        r.NPl.z(localz);
      }
      else
      {
        localr = r.NPl;
        if ((r.gzM()) && (localz.gAu())) {
          r.NPl.z(localz);
        }
      }
    }
    AppMethodBeat.o(195064);
  }
  
  public static void cP(List<z> paramList)
  {
    AppMethodBeat.i(195065);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (z)paramList.next();
      r localr = r.NPl;
      if ((r.gzL()) && (((z)localObject).gAv()))
      {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clj();
        AppMethodBeat.o(195065);
        return;
      }
      localr = r.NPl;
      if ((r.gzM()) && (((z)localObject).gAu()))
      {
        localObject = ((z)localObject).gAD();
        if ((localObject != null) && (((ege)localObject).style == 1001))
        {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clj();
          AppMethodBeat.o(195065);
          return;
        }
      }
    }
    AppMethodBeat.o(195065);
  }
  
  public static String crh()
  {
    AppMethodBeat.i(6244);
    Object localObject2 = null;
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.bef();
    Object localObject1 = localObject2;
    if (localf != null)
    {
      localObject1 = localObject2;
      if (localf.jeV != null)
      {
        localObject1 = localObject2;
        if (localf.jeT == 0)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.ay.a.bec()) {
            localObject1 = localf.jeV;
          }
        }
      }
    }
    AppMethodBeat.o(6244);
    return localObject1;
  }
  
  public static void w(z paramz)
  {
    AppMethodBeat.i(6246);
    if ((paramz == null) || (!paramz.gAt()))
    {
      AppMethodBeat.o(6246);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6239);
        if ((c.pMr.containsKey(Long.valueOf(this.peS.field_msgId))) && (!c.DW(((Integer)c.pMr.get(Long.valueOf(this.peS.field_msgId))).intValue())))
        {
          AppMethodBeat.o(6239);
          return;
        }
        List localList1 = ag.ban().aU(5, this.peS.field_orderFlag);
        List localList2 = ag.ban().MN(this.peS.field_orderFlag);
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.addAll(localList1);
        localLinkedList.add(this.peS);
        localLinkedList.addAll(localList2);
        c.cL(localLinkedList);
        AppMethodBeat.o(6239);
      }
    }, 0L);
    AppMethodBeat.o(6246);
  }
  
  public static void x(z paramz)
  {
    AppMethodBeat.i(6253);
    if ((paramz == null) || (!paramz.gAu()))
    {
      AppMethodBeat.o(6253);
      return;
    }
    ege localege = paramz.gAD();
    if (j.k(paramz))
    {
      AppMethodBeat.o(6253);
      return;
    }
    int i = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    if ((localege != null) && (localege.NfY != null) && (Math.abs(l - localege.lastUpdateTime) / 1000L > i))
    {
      paramz = a(localege, paramz);
      if (paramz != null) {
        localLinkedList.add(paramz);
      }
    }
    if (!Util.isNullOrNil(localLinkedList)) {
      M(localLinkedList);
    }
    AppMethodBeat.o(6253);
  }
  
  public static void y(z paramz)
  {
    AppMethodBeat.i(195066);
    if ((paramz == null) || (!paramz.gAu()))
    {
      AppMethodBeat.o(195066);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195063);
        if ((c.pMr.containsKey(Long.valueOf(this.peS.field_msgId))) && (!c.DW(((Integer)c.pMr.get(Long.valueOf(this.peS.field_msgId))).intValue())))
        {
          AppMethodBeat.o(195063);
          return;
        }
        Object localObject1 = ag.ban().aU(5, this.peS.field_orderFlag);
        Object localObject3 = ag.ban().MN(this.peS.field_orderFlag);
        Object localObject2 = new LinkedList();
        ((List)localObject2).addAll((Collection)localObject1);
        ((List)localObject2).add(this.peS);
        ((List)localObject2).addAll((Collection)localObject3);
        if (Util.isNullOrNil((List)localObject2))
        {
          AppMethodBeat.o(195063);
          return;
        }
        localObject1 = new LinkedList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (z)((Iterator)localObject2).next();
          if (((!c.pMr.containsKey(Long.valueOf(((z)localObject3).field_msgId))) || (c.DW(((Integer)c.pMr.get(Long.valueOf(((z)localObject3).field_msgId))).intValue()))) && (((z)localObject3).NQn != null) && (((z)localObject3).NQn.NfY != null) && (!Util.isNullOrNil(((z)localObject3).NQn.NfY.KWy)) && (((z)localObject3).gAu()) && ((((z)localObject3).NQn.style == 3) || (((z)localObject3).NQn.style == 5)))
          {
            int i = 0;
            while (i < ((z)localObject3).NQn.NfY.KWy.size())
            {
              ega localega = (ega)((z)localObject3).NQn.NfY.KWy.get(i);
              com.tencent.mm.ag.q localq = new com.tencent.mm.ag.q();
              localq.Url = localega.KSj;
              localq.iAb = localega.iAb;
              localq.ReqType = 1;
              ((List)localObject1).add(localq);
              i += 1;
            }
            c.pMr.put(Long.valueOf(((z)localObject3).field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
        }
        if (((List)localObject1).size() > 0) {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ct((List)localObject1);
        }
        AppMethodBeat.o(195063);
      }
    }, 0L);
    AppMethodBeat.o(195066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c
 * JD-Core Version:    0.7.0.1
 */