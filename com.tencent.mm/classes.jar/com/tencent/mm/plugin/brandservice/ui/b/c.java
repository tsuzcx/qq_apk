package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.q;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.am.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.t.7;
import com.tencent.mm.storage.t.8;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Map<Long, Integer> nmG;
  private static LinkedList<Long> nmH;
  
  static
  {
    AppMethodBeat.i(6257);
    nmG = new HashMap();
    nmH = new LinkedList();
    AppMethodBeat.o(6257);
  }
  
  private static void K(LinkedList<das> paramLinkedList)
  {
    AppMethodBeat.i(6254);
    if (bt.gL(paramLinkedList))
    {
      AppMethodBeat.o(6254);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    synchronized (nmH)
    {
      if (bt.gL(nmH)) {
        break label160;
      }
      localObject2 = new LinkedList();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        das localdas = (das)localIterator.next();
        if (nmH.contains(Long.valueOf(localdas.Esq))) {
          ((LinkedList)localObject2).add(localdas);
        }
      }
    }
    paramLinkedList.removeAll((Collection)localObject2);
    if (bt.gL(paramLinkedList))
    {
      ad.d("MicroMsg.ConversationAdapter", "doUpdateRecommendCard is doing return %d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
      AppMethodBeat.o(6254);
      return;
    }
    label160:
    Object localObject2 = paramLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      localLinkedList.add(Long.valueOf(((das)((Iterator)localObject2).next()).Esq));
    }
    nmH.addAll(localLinkedList);
    ??? = new b.a();
    ((b.a)???).gUU = new nf();
    ((b.a)???).gUV = new ng();
    ((b.a)???).uri = "/cgi-bin/mmbiz-bin/timeline/bizrecommendcard";
    ((b.a)???).funcId = 2787;
    ??? = ((b.a)???).atI();
    localObject2 = (nf)((com.tencent.mm.al.b)???).gUS.gUX;
    ((nf)localObject2).CLa = paramLinkedList;
    x.a((com.tencent.mm.al.b)???, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6242);
        ad.i("MicroMsg.ConversationAdapter", "[TRACE_BIZRECCARD] doUpdateRecommendCard check result errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ??? });
        synchronized (c.bGx())
        {
          c.bGx().removeAll(this.nmI);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            AppMethodBeat.o(6242);
            return 0;
          }
        }
        paramAnonymousb = (ng)paramAnonymousb.gUT.gUX;
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(6242);
          return 0;
        }
        ax.aFD("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramAnonymousb.CIm));
        if (paramAnonymousb.CLa == null)
        {
          ad.i("MicroMsg.ConversationAdapter", "response.RecCard is null");
          AppMethodBeat.o(6242);
          return 0;
        }
        ??? = new LinkedList();
        paramAnonymousn = paramAnonymousb.CLa.iterator();
        while (paramAnonymousn.hasNext())
        {
          dap localdap = (dap)paramAnonymousn.next();
          Iterator localIterator = this.nmJ.CLa.iterator();
          while (localIterator.hasNext())
          {
            das localdas = (das)localIterator.next();
            if (bt.aw(localdas.Esq, localdap.Esq)) {
              if (localdap.Esm == null)
              {
                ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard BizInfo is null");
              }
              else if ((localdap.Esm.Cxm & 0x1) != 0)
              {
                af.awk().wc(localdap.Esq);
                h.vKh.idkeyStat(1149L, 5L, 1L, false);
                ad.w("MicroMsg.ConversationAdapter", "doUpdateRecommendCard delete card by flag %d, msgId %d", new Object[] { Integer.valueOf(localdap.Esm.Cxm), Long.valueOf(localdap.Esq) });
              }
              else if (bt.isNullOrNil(localdap.Esm.mAQ))
              {
                ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserName is null");
              }
              else if ((bt.gL(localdap.Eso)) || (localdap.Eso.get(0) == null) || (bt.isNullOrNil(((daq)localdap.Eso.get(0)).CHL)))
              {
                ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard ContentUrl is null");
              }
              else if (!bt.kU(localdap.Esp, localdas.Esp))
              {
                ???.add(localdap);
              }
              else
              {
                ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard VersionInfo isEqual");
                if ((localdap.Esr != null) && (!bt.kU(localdap.Esr.Esp, localdas.Esx)))
                {
                  ???.add(localdap);
                  ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserVersionInfo update");
                }
              }
            }
          }
        }
        ad.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard updateList size %d, RecCard.size %d", new Object[] { Integer.valueOf(???.size()), Integer.valueOf(paramAnonymousb.CLa.size()) });
        if (!bt.gL(???))
        {
          paramAnonymousb = af.awk();
          if (!bt.gL(???))
          {
            paramAnonymousn = new LinkedList();
            com.tencent.mm.co.g.fkM().h(new t.8(paramAnonymousb, ???, paramAnonymousn)).b(new t.7(paramAnonymousb, paramAnonymousn));
          }
        }
        AppMethodBeat.o(6242);
        return 0;
      }
    });
    AppMethodBeat.o(6254);
  }
  
  public static String Qf(String paramString)
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
  
  private static das a(dau paramdau, s params)
  {
    AppMethodBeat.i(6255);
    if ((paramdau == null) || (paramdau.Esz == null) || (params == null))
    {
      ad.i("MicroMsg.ConversationAdapter", "getTLRecCardLite invalid data");
      AppMethodBeat.o(6255);
      return null;
    }
    das localdas = new das();
    if (!bt.gL(paramdau.Esz.Eso))
    {
      Iterator localIterator = paramdau.Esz.Eso.iterator();
      while (localIterator.hasNext())
      {
        daq localdaq = (daq)localIterator.next();
        localdas.Esw.add(localdaq.CHL);
      }
    }
    localdas.CIt = params.field_talker;
    localdas.Esq = params.field_msgId;
    localdas.Esp = paramdau.Esz.Esp;
    localdas.Dxp = paramdau.style;
    if (paramdau.Esz.Esr != null) {
      localdas.Esx = paramdau.Esz.Esr.Esp;
    }
    AppMethodBeat.o(6255);
    return localdas;
  }
  
  public static void a(List<s> paramList, final Runnable paramRunnable)
  {
    AppMethodBeat.i(6248);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6240);
        Iterator localIterator = this.krN.iterator();
        while (localIterator.hasNext())
        {
          s locals = (s)localIterator.next();
          if (locals.eJL()) {
            ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(locals.field_msgId, locals.field_content);
          }
        }
        c.cv(this.krN);
        aq.f(paramRunnable);
        AppMethodBeat.o(6240);
      }
    }, 0L);
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
  
  public static String bGw()
  {
    AppMethodBeat.i(6244);
    Object localObject2 = null;
    com.tencent.mm.az.f localf = com.tencent.mm.az.a.azI();
    Object localObject1 = localObject2;
    if (localf != null)
    {
      localObject1 = localObject2;
      if (localf.hnp != null)
      {
        localObject1 = localObject2;
        if (localf.hnn == 0)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.az.a.azF()) {
            localObject1 = localf.hnp;
          }
        }
      }
    }
    AppMethodBeat.o(6244);
    return localObject1;
  }
  
  public static void ct(List<s> paramList)
  {
    AppMethodBeat.i(6247);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(6247);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      s locals = (s)paramList.next();
      if (((!nmG.containsKey(Long.valueOf(locals.field_msgId))) || (yG(((Integer)nmG.get(Long.valueOf(locals.field_msgId))).intValue()))) && (locals.eJL()))
      {
        q localq = new q();
        localq.msgId = locals.field_msgId;
        localq.gKr = locals.field_content;
        localLinkedList.add(localq);
        nmG.put(Long.valueOf(locals.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
      }
    }
    if (localLinkedList.size() > 0) {
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).k(localLinkedList, 90);
    }
    AppMethodBeat.o(6247);
  }
  
  public static void cu(List<s> paramList)
  {
    AppMethodBeat.i(6251);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6241);
        c.cv(this.krN);
        AppMethodBeat.o(6241);
      }
    }, 0L);
    AppMethodBeat.o(6251);
  }
  
  public static void cv(List<s> paramList)
  {
    AppMethodBeat.i(6252);
    int i = ax.aFD("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (s)paramList.next();
      if (((s)localObject).eJM())
      {
        dau localdau = ((s)localObject).eJS();
        if ((localdau != null) && (localdau.Esz != null) && (Math.abs(l - localdau.lastUpdateTime) / 1000L > i))
        {
          localObject = a(localdau, (s)localObject);
          if (localObject != null) {
            localLinkedList.add(localObject);
          }
        }
      }
    }
    if (!bt.gL(localLinkedList)) {
      K(localLinkedList);
    }
    AppMethodBeat.o(6252);
  }
  
  public static void g(s params)
  {
    AppMethodBeat.i(6246);
    if ((params == null) || (!params.eJL()))
    {
      AppMethodBeat.o(6246);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6239);
        if ((c.nmG.containsKey(Long.valueOf(this.mLB.field_msgId))) && (!c.yG(((Integer)c.nmG.get(Long.valueOf(this.mLB.field_msgId))).intValue())))
        {
          AppMethodBeat.o(6239);
          return;
        }
        List localList1 = af.awk().aF(5, this.mLB.field_orderFlag);
        List localList2 = af.awk().vV(this.mLB.field_orderFlag);
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.addAll(localList1);
        localLinkedList.add(this.mLB);
        localLinkedList.addAll(localList2);
        c.ct(localLinkedList);
        AppMethodBeat.o(6239);
      }
    }, 0L);
    AppMethodBeat.o(6246);
  }
  
  public static void h(s params)
  {
    AppMethodBeat.i(6253);
    if ((params == null) || (!params.eJM()))
    {
      AppMethodBeat.o(6253);
      return;
    }
    int i = ax.aFD("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    dau localdau = params.eJS();
    if ((localdau != null) && (localdau.Esz != null) && (Math.abs(l - localdau.lastUpdateTime) / 1000L > i))
    {
      params = a(localdau, params);
      if (params != null) {
        localLinkedList.add(params);
      }
    }
    if (!bt.gL(localLinkedList)) {
      K(localLinkedList);
    }
    AppMethodBeat.o(6253);
  }
  
  public static void i(s params)
  {
    AppMethodBeat.i(193005);
    if ((params == null) || (!params.eJM()))
    {
      AppMethodBeat.o(193005);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193004);
        if ((c.nmG.containsKey(Long.valueOf(this.mLB.field_msgId))) && (!c.yG(((Integer)c.nmG.get(Long.valueOf(this.mLB.field_msgId))).intValue())))
        {
          AppMethodBeat.o(193004);
          return;
        }
        Object localObject1 = af.awk().aF(5, this.mLB.field_orderFlag);
        Object localObject3 = af.awk().vV(this.mLB.field_orderFlag);
        Object localObject2 = new LinkedList();
        ((List)localObject2).addAll((Collection)localObject1);
        ((List)localObject2).add(this.mLB);
        ((List)localObject2).addAll((Collection)localObject3);
        if (bt.gL((List)localObject2))
        {
          AppMethodBeat.o(193004);
          return;
        }
        localObject1 = new LinkedList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (s)((Iterator)localObject2).next();
          if (((!c.nmG.containsKey(Long.valueOf(((s)localObject3).field_msgId))) || (c.yG(((Integer)c.nmG.get(Long.valueOf(((s)localObject3).field_msgId))).intValue()))) && (((s)localObject3).Fes != null) && (((s)localObject3).Fes.Esz != null) && (!bt.gL(((s)localObject3).Fes.Esz.Eso)) && (((s)localObject3).eJM()))
          {
            int i = 0;
            while (i < ((s)localObject3).Fes.Esz.Eso.size())
            {
              daq localdaq = (daq)((s)localObject3).Fes.Esz.Eso.get(i);
              q localq = new q();
              localq.Url = localdaq.CHL;
              localq.gKq = localdaq.gKq;
              localq.ReqType = 1;
              ((List)localObject1).add(localq);
              i += 1;
            }
            c.nmG.put(Long.valueOf(((s)localObject3).field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
        }
        if (((List)localObject1).size() > 0) {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).cb((List)localObject1);
        }
        AppMethodBeat.o(193004);
      }
    }, 0L);
    AppMethodBeat.o(193005);
  }
  
  public static boolean yG(int paramInt)
  {
    AppMethodBeat.i(6245);
    if (System.currentTimeMillis() / 1000L - paramInt > a.nmA)
    {
      AppMethodBeat.o(6245);
      return true;
    }
    AppMethodBeat.o(6245);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c
 * JD-Core Version:    0.7.0.1
 */