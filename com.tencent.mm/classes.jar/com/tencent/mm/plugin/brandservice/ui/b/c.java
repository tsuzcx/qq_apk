package com.tencent.mm.plugin.brandservice.ui.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.q;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.am.ag;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.h;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.protocal.protobuf.dlr;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x.7;
import com.tencent.mm.storage.x.8;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Map<Long, Integer> osm;
  private static LinkedList<Long> osn;
  
  static
  {
    AppMethodBeat.i(6257);
    osm = new HashMap();
    osn = new LinkedList();
    AppMethodBeat.o(6257);
  }
  
  public static boolean Af(int paramInt)
  {
    AppMethodBeat.i(6245);
    if (System.currentTimeMillis() / 1000L - paramInt > a.osg)
    {
      AppMethodBeat.o(6245);
      return true;
    }
    AppMethodBeat.o(6245);
    return false;
  }
  
  private static void K(LinkedList<dlr> paramLinkedList)
  {
    AppMethodBeat.i(6254);
    if (bt.hj(paramLinkedList))
    {
      AppMethodBeat.o(6254);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    synchronized (osn)
    {
      if (bt.hj(osn)) {
        break label160;
      }
      localObject2 = new LinkedList();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        dlr localdlr = (dlr)localIterator.next();
        if (osn.contains(Long.valueOf(localdlr.FJW))) {
          ((LinkedList)localObject2).add(localdlr);
        }
      }
    }
    paramLinkedList.removeAll((Collection)localObject2);
    if (bt.hj(paramLinkedList))
    {
      ad.d("MicroMsg.ConversationAdapter", "doUpdateRecommendCard is doing return %d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
      AppMethodBeat.o(6254);
      return;
    }
    label160:
    Object localObject2 = paramLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      localLinkedList.add(Long.valueOf(((dlr)((Iterator)localObject2).next()).FJW));
    }
    osn.addAll(localLinkedList);
    ??? = new b.a();
    ((b.a)???).hNM = new op();
    ((b.a)???).hNN = new oq();
    ((b.a)???).uri = "/cgi-bin/mmbiz-bin/timeline/bizrecommendcard";
    ((b.a)???).funcId = 2787;
    ??? = ((b.a)???).aDC();
    localObject2 = (op)((com.tencent.mm.al.b)???).hNK.hNQ;
    ((op)localObject2).FJZ = paramLinkedList;
    com.tencent.mm.al.x.a((com.tencent.mm.al.b)???, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6242);
        ad.i("MicroMsg.ConversationAdapter", "[TRACE_BIZRECCARD] doUpdateRecommendCard check result errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ??? });
        synchronized (c.bSk())
        {
          c.bSk().removeAll(this.osp);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            AppMethodBeat.o(6242);
            return 0;
          }
        }
        paramAnonymousb = (oq)paramAnonymousb.hNL.hNQ;
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(6242);
          return 0;
        }
        ax.aQA("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramAnonymousb.FGx));
        if (paramAnonymousb.FJZ == null)
        {
          ad.i("MicroMsg.ConversationAdapter", "response.RecCard is null");
          AppMethodBeat.o(6242);
          return 0;
        }
        ??? = new LinkedList();
        paramAnonymousn = paramAnonymousb.FJZ.iterator();
        while (paramAnonymousn.hasNext())
        {
          dlo localdlo = (dlo)paramAnonymousn.next();
          Iterator localIterator = this.osq.FJZ.iterator();
          while (localIterator.hasNext())
          {
            dlr localdlr = (dlr)localIterator.next();
            if (bt.aA(localdlr.FJW, localdlo.FJW)) {
              if (localdlo.HzY == null)
              {
                ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard BizInfo is null");
              }
              else if ((localdlo.HzY.FuX & 0x1) != 0)
              {
                ag.aGf().Dv(localdlo.FJW);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 5L, 1L, false);
                ad.w("MicroMsg.ConversationAdapter", "doUpdateRecommendCard delete card by flag %d, msgId %d", new Object[] { Integer.valueOf(localdlo.HzY.FuX), Long.valueOf(localdlo.FJW) });
              }
              else if (bt.isNullOrNil(localdlo.HzY.nDo))
              {
                ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserName is null");
              }
              else if ((bt.hj(localdlo.FJV)) || (localdlo.FJV.get(0) == null) || (bt.isNullOrNil(((dlp)localdlo.FJV.get(0)).FFW)))
              {
                ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard ContentUrl is null");
              }
              else if (!bt.lQ(localdlo.GfL, localdlr.GfL))
              {
                ???.add(localdlo);
              }
              else
              {
                ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard VersionInfo isEqual");
                if ((localdlo.HzZ != null) && (!bt.lQ(localdlo.HzZ.GfL, localdlr.HAb)))
                {
                  ???.add(localdlo);
                  ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserVersionInfo update");
                }
              }
            }
          }
        }
        ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard updateList size %d, RecCard.size %d", new Object[] { Integer.valueOf(???.size()), Integer.valueOf(paramAnonymousb.FJZ.size()) });
        if (!bt.hj(???))
        {
          paramAnonymousb = ag.aGf();
          if (!bt.hj(???))
          {
            paramAnonymousn = new LinkedList();
            com.tencent.mm.cn.g.fSm().h(new x.8(paramAnonymousb, ???, paramAnonymousn)).b(new x.7(paramAnonymousb, paramAnonymousn));
          }
        }
        AppMethodBeat.o(6242);
        return 0;
      }
    });
    AppMethodBeat.o(6254);
  }
  
  public static String Ya(String paramString)
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
  
  private static dlr a(dlt paramdlt, w paramw)
  {
    AppMethodBeat.i(6255);
    if ((paramdlt == null) || (paramdlt.HAd == null) || (paramw == null))
    {
      ad.i("MicroMsg.ConversationAdapter", "getTLRecCardLite invalid data");
      AppMethodBeat.o(6255);
      return null;
    }
    dlr localdlr = new dlr();
    if (!bt.hj(paramdlt.HAd.FJV))
    {
      Iterator localIterator = paramdlt.HAd.FJV.iterator();
      while (localIterator.hasNext())
      {
        dlp localdlp = (dlp)localIterator.next();
        localdlr.FIj.add(localdlp.FFW);
      }
    }
    localdlr.FGE = paramw.field_talker;
    localdlr.FJW = paramw.field_msgId;
    localdlr.GfL = paramdlt.HAd.GfL;
    localdlr.FHR = paramdlt.style;
    if (paramdlt.HAd.HzZ != null) {
      localdlr.HAb = paramdlt.HAd.HzZ.GfL;
    }
    AppMethodBeat.o(6255);
    return localdlr;
  }
  
  public static void a(List<w> paramList, final Runnable paramRunnable)
  {
    AppMethodBeat.i(6248);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(209595);
        Looper.myQueue().removeIdleHandler(this);
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209594);
            Iterator localIterator = c.2.this.gtP.iterator();
            while (localIterator.hasNext())
            {
              w localw = (w)localIterator.next();
              if (localw.fpd()) {
                ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localw.field_msgId, localw.field_content);
              }
            }
            c.cx(c.2.this.gtP);
            c.cy(c.2.this.gtP);
            aq.f(c.2.this.val$callback);
            AppMethodBeat.o(209594);
          }
        }, 0L);
        AppMethodBeat.o(209595);
        return false;
      }
    });
    AppMethodBeat.o(6248);
  }
  
  public static boolean b(com.tencent.mm.bx.a parama1, com.tencent.mm.bx.a parama2)
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
      boolean bool = bt.isEqual(parama1.toByteArray(), parama2.toByteArray());
      AppMethodBeat.o(6249);
      return bool;
    }
    catch (IOException parama1)
    {
      ad.i("MicroMsg.ConversationAdapter", "isMsgStatInfoProtoEqual exp %s", new Object[] { parama1.getMessage() });
      AppMethodBeat.o(6249);
    }
    return false;
  }
  
  public static String bSj()
  {
    AppMethodBeat.i(6244);
    Object localObject2 = null;
    com.tencent.mm.az.f localf = com.tencent.mm.az.a.aJJ();
    Object localObject1 = localObject2;
    if (localf != null)
    {
      localObject1 = localObject2;
      if (localf.ihg != null)
      {
        localObject1 = localObject2;
        if (localf.ihe == 0)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.az.a.aJG()) {
            localObject1 = localf.ihg;
          }
        }
      }
    }
    AppMethodBeat.o(6244);
    return localObject1;
  }
  
  public static void cv(List<w> paramList)
  {
    AppMethodBeat.i(6247);
    if (bt.hj(paramList))
    {
      AppMethodBeat.o(6247);
      return;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      w localw = (w)paramList.next();
      if ((!osm.containsKey(Long.valueOf(localw.field_msgId))) || (Af(((Integer)osm.get(Long.valueOf(localw.field_msgId))).intValue()))) {
        if (localw.fpd())
        {
          q localq = new q();
          localq.msgId = localw.field_msgId;
          localq.hDa = localw.field_content;
          localLinkedList1.add(localq);
          osm.put(Long.valueOf(localw.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        }
        else
        {
          osm.put(Long.valueOf(localw.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          localLinkedList2.add(localw);
        }
      }
    }
    if (localLinkedList1.size() > 0) {
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).l(localLinkedList1, 90);
    }
    AppMethodBeat.o(6247);
  }
  
  public static void cw(List<w> paramList)
  {
    AppMethodBeat.i(6251);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6241);
        c.cx(this.gtP);
        AppMethodBeat.o(6241);
      }
    }, 0L);
    AppMethodBeat.o(6251);
  }
  
  public static void cx(List<w> paramList)
  {
    AppMethodBeat.i(6252);
    int i = ax.aQA("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (w)paramList.next();
      if ((((w)localObject).fpe()) && (!h.f((w)localObject)))
      {
        dlt localdlt = ((w)localObject).fpm();
        if ((localdlt != null) && (localdlt.HAd != null) && (Math.abs(l - localdlt.lastUpdateTime) / 1000L > i))
        {
          localObject = a(localdlt, (w)localObject);
          if (localObject != null) {
            localLinkedList.add(localObject);
          }
        }
      }
    }
    if (!bt.hj(localLinkedList)) {
      K(localLinkedList);
    }
    AppMethodBeat.o(6252);
  }
  
  public static void cy(List<w> paramList)
  {
    AppMethodBeat.i(209597);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      w localw = (w)paramList.next();
      p localp = p.InU;
      if ((p.foN()) && (localw.fpf()))
      {
        localLinkedList.add(localw);
        p.InU.n(localw);
      }
      else
      {
        localp = p.InU;
        if ((p.foO()) && (localw.fpe())) {
          p.InU.n(localw);
        }
      }
    }
    if (!bt.hj(localLinkedList))
    {
      paramList = p.InU;
      p.ho(localLinkedList);
    }
    AppMethodBeat.o(209597);
  }
  
  public static void k(w paramw)
  {
    AppMethodBeat.i(6246);
    if ((paramw == null) || (!paramw.fpd()))
    {
      AppMethodBeat.o(6246);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6239);
        if ((c.osm.containsKey(Long.valueOf(this.nOy.field_msgId))) && (!c.Af(((Integer)c.osm.get(Long.valueOf(this.nOy.field_msgId))).intValue())))
        {
          AppMethodBeat.o(6239);
          return;
        }
        List localList1 = ag.aGf().aP(5, this.nOy.field_orderFlag);
        List localList2 = ag.aGf().Do(this.nOy.field_orderFlag);
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.addAll(localList1);
        localLinkedList.add(this.nOy);
        localLinkedList.addAll(localList2);
        c.cv(localLinkedList);
        AppMethodBeat.o(6239);
      }
    }, 0L);
    AppMethodBeat.o(6246);
  }
  
  public static void l(w paramw)
  {
    AppMethodBeat.i(6253);
    if ((paramw == null) || (!paramw.fpe()))
    {
      AppMethodBeat.o(6253);
      return;
    }
    dlt localdlt = paramw.fpm();
    if (h.f(paramw))
    {
      AppMethodBeat.o(6253);
      return;
    }
    int i = ax.aQA("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    if ((localdlt != null) && (localdlt.HAd != null) && (Math.abs(l - localdlt.lastUpdateTime) / 1000L > i))
    {
      paramw = a(localdlt, paramw);
      if (paramw != null) {
        localLinkedList.add(paramw);
      }
    }
    if (!bt.hj(localLinkedList)) {
      K(localLinkedList);
    }
    AppMethodBeat.o(6253);
  }
  
  public static void m(w paramw)
  {
    AppMethodBeat.i(209598);
    if ((paramw == null) || (!paramw.fpe()))
    {
      AppMethodBeat.o(209598);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209596);
        if ((c.osm.containsKey(Long.valueOf(this.nOy.field_msgId))) && (!c.Af(((Integer)c.osm.get(Long.valueOf(this.nOy.field_msgId))).intValue())))
        {
          AppMethodBeat.o(209596);
          return;
        }
        Object localObject1 = ag.aGf().aP(5, this.nOy.field_orderFlag);
        Object localObject3 = ag.aGf().Do(this.nOy.field_orderFlag);
        Object localObject2 = new LinkedList();
        ((List)localObject2).addAll((Collection)localObject1);
        ((List)localObject2).add(this.nOy);
        ((List)localObject2).addAll((Collection)localObject3);
        if (bt.hj((List)localObject2))
        {
          AppMethodBeat.o(209596);
          return;
        }
        localObject1 = new LinkedList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (w)((Iterator)localObject2).next();
          if (((!c.osm.containsKey(Long.valueOf(((w)localObject3).field_msgId))) || (c.Af(((Integer)c.osm.get(Long.valueOf(((w)localObject3).field_msgId))).intValue()))) && (((w)localObject3).Ioq != null) && (((w)localObject3).Ioq.HAd != null) && (!bt.hj(((w)localObject3).Ioq.HAd.FJV)) && (((w)localObject3).fpe()))
          {
            int i = 0;
            while (i < ((w)localObject3).Ioq.HAd.FJV.size())
            {
              dlp localdlp = (dlp)((w)localObject3).Ioq.HAd.FJV.get(i);
              q localq = new q();
              localq.Url = localdlp.FFW;
              localq.hCZ = localdlp.hCZ;
              localq.ReqType = 1;
              ((List)localObject1).add(localq);
              i += 1;
            }
            c.osm.put(Long.valueOf(((w)localObject3).field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
        }
        if (((List)localObject1).size() > 0) {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).cc((List)localObject1);
        }
        AppMethodBeat.o(209596);
      }
    }, 0L);
    AppMethodBeat.o(209598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c
 * JD-Core Version:    0.7.0.1
 */