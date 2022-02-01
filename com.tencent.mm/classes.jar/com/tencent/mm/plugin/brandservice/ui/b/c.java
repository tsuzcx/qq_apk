package com.tencent.mm.plugin.brandservice.ui.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.q;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.h;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static Map<Long, Integer> oyN;
  private static LinkedList<Long> oyO;
  
  static
  {
    AppMethodBeat.i(6257);
    oyN = new HashMap();
    oyO = new LinkedList();
    AppMethodBeat.o(6257);
  }
  
  public static boolean Ar(int paramInt)
  {
    AppMethodBeat.i(6245);
    if (System.currentTimeMillis() / 1000L - paramInt > a.oyH)
    {
      AppMethodBeat.o(6245);
      return true;
    }
    AppMethodBeat.o(6245);
    return false;
  }
  
  private static void K(LinkedList<dmo> paramLinkedList)
  {
    AppMethodBeat.i(6254);
    if (bu.ht(paramLinkedList))
    {
      AppMethodBeat.o(6254);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    synchronized (oyO)
    {
      if (bu.ht(oyO)) {
        break label160;
      }
      localObject2 = new LinkedList();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        dmo localdmo = (dmo)localIterator.next();
        if (oyO.contains(Long.valueOf(localdmo.Gcv))) {
          ((LinkedList)localObject2).add(localdmo);
        }
      }
    }
    paramLinkedList.removeAll((Collection)localObject2);
    if (bu.ht(paramLinkedList))
    {
      ae.d("MicroMsg.ConversationAdapter", "doUpdateRecommendCard is doing return %d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
      AppMethodBeat.o(6254);
      return;
    }
    label160:
    Object localObject2 = paramLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      localLinkedList.add(Long.valueOf(((dmo)((Iterator)localObject2).next()).Gcv));
    }
    oyO.addAll(localLinkedList);
    ??? = new b.a();
    ((b.a)???).hQF = new or();
    ((b.a)???).hQG = new os();
    ((b.a)???).uri = "/cgi-bin/mmbiz-bin/timeline/bizrecommendcard";
    ((b.a)???).funcId = 2787;
    ??? = ((b.a)???).aDS();
    localObject2 = (or)((com.tencent.mm.ak.b)???).hQD.hQJ;
    ((or)localObject2).Gcy = paramLinkedList;
    com.tencent.mm.ak.x.a((com.tencent.mm.ak.b)???, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6242);
        ae.i("MicroMsg.ConversationAdapter", "[TRACE_BIZRECCARD] doUpdateRecommendCard check result errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ??? });
        synchronized (c.bTx())
        {
          c.bTx().removeAll(this.oyQ);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            AppMethodBeat.o(6242);
            return 0;
          }
        }
        paramAnonymousb = (os)paramAnonymousb.hQE.hQJ;
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(6242);
          return 0;
        }
        ay.aRX("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramAnonymousb.FYT));
        if (paramAnonymousb.Gcy == null)
        {
          ae.i("MicroMsg.ConversationAdapter", "response.RecCard is null");
          AppMethodBeat.o(6242);
          return 0;
        }
        ??? = new LinkedList();
        paramAnonymousn = paramAnonymousb.Gcy.iterator();
        while (paramAnonymousn.hasNext())
        {
          dml localdml = (dml)paramAnonymousn.next();
          Iterator localIterator = this.oyR.Gcy.iterator();
          while (localIterator.hasNext())
          {
            dmo localdmo = (dmo)localIterator.next();
            if (bu.az(localdmo.Gcv, localdml.Gcv)) {
              if (localdml.HTL == null)
              {
                ae.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard BizInfo is null");
              }
              else if ((localdml.HTL.FNv & 0x1) != 0)
              {
                ag.aGv().DU(localdml.Gcv);
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 5L, 1L, false);
                ae.w("MicroMsg.ConversationAdapter", "doUpdateRecommendCard delete card by flag %d, msgId %d", new Object[] { Integer.valueOf(localdml.HTL.FNv), Long.valueOf(localdml.Gcv) });
              }
              else if (bu.isNullOrNil(localdml.HTL.nIJ))
              {
                ae.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserName is null");
              }
              else if ((bu.ht(localdml.Gcu)) || (localdml.Gcu.get(0) == null) || (bu.isNullOrNil(((dmm)localdml.Gcu.get(0)).FYs)))
              {
                ae.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard ContentUrl is null");
              }
              else if (!bu.lX(localdml.Gyt, localdmo.Gyt))
              {
                ???.add(localdml);
              }
              else
              {
                ae.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard VersionInfo isEqual");
                if ((localdml.HTM != null) && (!bu.lX(localdml.HTM.Gyt, localdmo.HTO)))
                {
                  ???.add(localdml);
                  ae.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserVersionInfo update");
                }
              }
            }
          }
        }
        ae.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard updateList size %d, RecCard.size %d", new Object[] { Integer.valueOf(???.size()), Integer.valueOf(paramAnonymousb.Gcy.size()) });
        if (!bu.ht(???))
        {
          paramAnonymousb = ag.aGv();
          if (!bu.ht(???))
          {
            paramAnonymousn = new LinkedList();
            com.tencent.mm.cm.g.fWL().h(new x.8(paramAnonymousb, ???, paramAnonymousn)).b(new x.7(paramAnonymousb, paramAnonymousn));
          }
        }
        AppMethodBeat.o(6242);
        return 0;
      }
    });
    AppMethodBeat.o(6254);
  }
  
  public static String YR(String paramString)
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
  
  private static dmo a(dmq paramdmq, w paramw)
  {
    AppMethodBeat.i(6255);
    if ((paramdmq == null) || (paramdmq.HTQ == null) || (paramw == null))
    {
      ae.i("MicroMsg.ConversationAdapter", "getTLRecCardLite invalid data");
      AppMethodBeat.o(6255);
      return null;
    }
    dmo localdmo = new dmo();
    if (!bu.ht(paramdmq.HTQ.Gcu))
    {
      Iterator localIterator = paramdmq.HTQ.Gcu.iterator();
      while (localIterator.hasNext())
      {
        dmm localdmm = (dmm)localIterator.next();
        localdmo.GaF.add(localdmm.FYs);
      }
    }
    localdmo.FZa = paramw.field_talker;
    localdmo.Gcv = paramw.field_msgId;
    localdmo.Gyt = paramdmq.HTQ.Gyt;
    localdmo.Gan = paramdmq.style;
    if (paramdmq.HTQ.HTM != null) {
      localdmo.HTO = paramdmq.HTQ.HTM.Gyt;
    }
    AppMethodBeat.o(6255);
    return localdmo;
  }
  
  public static void a(List<w> paramList, final Runnable paramRunnable)
  {
    AppMethodBeat.i(6248);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(208551);
        Looper.myQueue().removeIdleHandler(this);
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208550);
            Iterator localIterator = c.2.this.gww.iterator();
            while (localIterator.hasNext())
            {
              w localw = (w)localIterator.next();
              if (localw.fta()) {
                ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localw.field_msgId, localw.field_content);
              }
            }
            c.cz(c.2.this.gww);
            c.cA(c.2.this.gww);
            ar.f(c.2.this.val$callback);
            AppMethodBeat.o(208550);
          }
        }, 0L);
        AppMethodBeat.o(208551);
        return false;
      }
    });
    AppMethodBeat.o(6248);
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
      boolean bool = bu.isEqual(parama1.toByteArray(), parama2.toByteArray());
      AppMethodBeat.o(6249);
      return bool;
    }
    catch (IOException parama1)
    {
      ae.i("MicroMsg.ConversationAdapter", "isMsgStatInfoProtoEqual exp %s", new Object[] { parama1.getMessage() });
      AppMethodBeat.o(6249);
    }
    return false;
  }
  
  public static String bTw()
  {
    AppMethodBeat.i(6244);
    Object localObject2 = null;
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aKc();
    Object localObject1 = localObject2;
    if (localf != null)
    {
      localObject1 = localObject2;
      if (localf.ijZ != null)
      {
        localObject1 = localObject2;
        if (localf.ijX == 0)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.ay.a.aJZ()) {
            localObject1 = localf.ijZ;
          }
        }
      }
    }
    AppMethodBeat.o(6244);
    return localObject1;
  }
  
  public static void cA(List<w> paramList)
  {
    AppMethodBeat.i(208553);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      w localw = (w)paramList.next();
      p localp = p.IIi;
      if ((p.fsG()) && (localw.ftc()))
      {
        localLinkedList.add(localw);
        p.IIi.o(localw);
      }
      else
      {
        localp = p.IIi;
        if ((p.fsH()) && (localw.ftb())) {
          p.IIi.o(localw);
        }
      }
    }
    if (!bu.ht(localLinkedList))
    {
      paramList = p.IIi;
      p.hy(localLinkedList);
    }
    AppMethodBeat.o(208553);
  }
  
  public static void cB(List<w> paramList)
  {
    AppMethodBeat.i(208554);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (w)paramList.next();
      p localp = p.IIi;
      if ((p.fsG()) && (((w)localObject).ftc()))
      {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOk();
        AppMethodBeat.o(208554);
        return;
      }
      localp = p.IIi;
      if ((p.fsH()) && (((w)localObject).ftb()))
      {
        localObject = ((w)localObject).ftk();
        if ((localObject != null) && (((dmq)localObject).style == 1001))
        {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOk();
          AppMethodBeat.o(208554);
          return;
        }
      }
    }
    AppMethodBeat.o(208554);
  }
  
  public static void cx(List<w> paramList)
  {
    AppMethodBeat.i(6247);
    if (bu.ht(paramList))
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
      if ((!oyN.containsKey(Long.valueOf(localw.field_msgId))) || (Ar(((Integer)oyN.get(Long.valueOf(localw.field_msgId))).intValue()))) {
        if (localw.fta())
        {
          q localq = new q();
          localq.msgId = localw.field_msgId;
          localq.hFS = localw.field_content;
          localLinkedList1.add(localq);
          oyN.put(Long.valueOf(localw.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        }
        else
        {
          oyN.put(Long.valueOf(localw.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          localLinkedList2.add(localw);
        }
      }
    }
    if (localLinkedList1.size() > 0) {
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).l(localLinkedList1, 90);
    }
    AppMethodBeat.o(6247);
  }
  
  public static void cy(List<w> paramList)
  {
    AppMethodBeat.i(6251);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6241);
        c.cz(this.gww);
        AppMethodBeat.o(6241);
      }
    }, 0L);
    AppMethodBeat.o(6251);
  }
  
  public static void cz(List<w> paramList)
  {
    AppMethodBeat.i(6252);
    int i = ay.aRX("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (w)paramList.next();
      if ((((w)localObject).ftb()) && (!h.f((w)localObject)))
      {
        dmq localdmq = ((w)localObject).ftk();
        if ((localdmq != null) && (localdmq.HTQ != null) && (Math.abs(l - localdmq.lastUpdateTime) / 1000L > i))
        {
          localObject = a(localdmq, (w)localObject);
          if (localObject != null) {
            localLinkedList.add(localObject);
          }
        }
      }
    }
    if (!bu.ht(localLinkedList)) {
      K(localLinkedList);
    }
    AppMethodBeat.o(6252);
  }
  
  public static void l(w paramw)
  {
    AppMethodBeat.i(6246);
    if ((paramw == null) || (!paramw.fta()))
    {
      AppMethodBeat.o(6246);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6239);
        if ((c.oyN.containsKey(Long.valueOf(this.nUe.field_msgId))) && (!c.Ar(((Integer)c.oyN.get(Long.valueOf(this.nUe.field_msgId))).intValue())))
        {
          AppMethodBeat.o(6239);
          return;
        }
        List localList1 = ag.aGv().aP(5, this.nUe.field_orderFlag);
        List localList2 = ag.aGv().DN(this.nUe.field_orderFlag);
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.addAll(localList1);
        localLinkedList.add(this.nUe);
        localLinkedList.addAll(localList2);
        c.cx(localLinkedList);
        AppMethodBeat.o(6239);
      }
    }, 0L);
    AppMethodBeat.o(6246);
  }
  
  public static void m(w paramw)
  {
    AppMethodBeat.i(6253);
    if ((paramw == null) || (!paramw.ftb()))
    {
      AppMethodBeat.o(6253);
      return;
    }
    dmq localdmq = paramw.ftk();
    if (h.f(paramw))
    {
      AppMethodBeat.o(6253);
      return;
    }
    int i = ay.aRX("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    if ((localdmq != null) && (localdmq.HTQ != null) && (Math.abs(l - localdmq.lastUpdateTime) / 1000L > i))
    {
      paramw = a(localdmq, paramw);
      if (paramw != null) {
        localLinkedList.add(paramw);
      }
    }
    if (!bu.ht(localLinkedList)) {
      K(localLinkedList);
    }
    AppMethodBeat.o(6253);
  }
  
  public static void n(w paramw)
  {
    AppMethodBeat.i(208555);
    if ((paramw == null) || (!paramw.ftb()))
    {
      AppMethodBeat.o(208555);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208552);
        if ((c.oyN.containsKey(Long.valueOf(this.nUe.field_msgId))) && (!c.Ar(((Integer)c.oyN.get(Long.valueOf(this.nUe.field_msgId))).intValue())))
        {
          AppMethodBeat.o(208552);
          return;
        }
        Object localObject1 = ag.aGv().aP(5, this.nUe.field_orderFlag);
        Object localObject3 = ag.aGv().DN(this.nUe.field_orderFlag);
        Object localObject2 = new LinkedList();
        ((List)localObject2).addAll((Collection)localObject1);
        ((List)localObject2).add(this.nUe);
        ((List)localObject2).addAll((Collection)localObject3);
        if (bu.ht((List)localObject2))
        {
          AppMethodBeat.o(208552);
          return;
        }
        localObject1 = new LinkedList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (w)((Iterator)localObject2).next();
          if (((!c.oyN.containsKey(Long.valueOf(((w)localObject3).field_msgId))) || (c.Ar(((Integer)c.oyN.get(Long.valueOf(((w)localObject3).field_msgId))).intValue()))) && (((w)localObject3).IIG != null) && (((w)localObject3).IIG.HTQ != null) && (!bu.ht(((w)localObject3).IIG.HTQ.Gcu)) && (((w)localObject3).ftb()))
          {
            int i = 0;
            while (i < ((w)localObject3).IIG.HTQ.Gcu.size())
            {
              dmm localdmm = (dmm)((w)localObject3).IIG.HTQ.Gcu.get(i);
              q localq = new q();
              localq.Url = localdmm.FYs;
              localq.hFR = localdmm.hFR;
              localq.ReqType = 1;
              ((List)localObject1).add(localq);
              i += 1;
            }
            c.oyN.put(Long.valueOf(((w)localObject3).field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
        }
        if (((List)localObject1).size() > 0) {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ce((List)localObject1);
        }
        AppMethodBeat.o(208552);
      }
    }, 0L);
    AppMethodBeat.o(208555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c
 * JD-Core Version:    0.7.0.1
 */