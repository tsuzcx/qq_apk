package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.q;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dge;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.u.7;
import com.tencent.mm.storage.u.8;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Map<Long, Integer> nPG;
  private static LinkedList<Long> nPH;
  
  static
  {
    AppMethodBeat.i(6257);
    nPG = new HashMap();
    nPH = new LinkedList();
    AppMethodBeat.o(6257);
  }
  
  private static void K(LinkedList<dge> paramLinkedList)
  {
    AppMethodBeat.i(6254);
    if (bs.gY(paramLinkedList))
    {
      AppMethodBeat.o(6254);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    synchronized (nPH)
    {
      if (bs.gY(nPH)) {
        break label160;
      }
      localObject2 = new LinkedList();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        dge localdge = (dge)localIterator.next();
        if (nPH.contains(Long.valueOf(localdge.FPs))) {
          ((LinkedList)localObject2).add(localdge);
        }
      }
    }
    paramLinkedList.removeAll((Collection)localObject2);
    if (bs.gY(paramLinkedList))
    {
      ac.d("MicroMsg.ConversationAdapter", "doUpdateRecommendCard is doing return %d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
      AppMethodBeat.o(6254);
      return;
    }
    label160:
    Object localObject2 = paramLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      localLinkedList.add(Long.valueOf(((dge)((Iterator)localObject2).next()).FPs));
    }
    nPH.addAll(localLinkedList);
    ??? = new b.a();
    ((b.a)???).hvt = new nm();
    ((b.a)???).hvu = new nn();
    ((b.a)???).uri = "/cgi-bin/mmbiz-bin/timeline/bizrecommendcard";
    ((b.a)???).funcId = 2787;
    ??? = ((b.a)???).aAz();
    localObject2 = (nm)((com.tencent.mm.ak.b)???).hvr.hvw;
    ((nm)localObject2).EdC = paramLinkedList;
    x.a((com.tencent.mm.ak.b)???, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(6242);
        ac.i("MicroMsg.ConversationAdapter", "[TRACE_BIZRECCARD] doUpdateRecommendCard check result errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ??? });
        synchronized (c.bNK())
        {
          c.bNK().removeAll(this.nPI);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            AppMethodBeat.o(6242);
            return 0;
          }
        }
        paramAnonymousb = (nn)paramAnonymousb.hvs.hvw;
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(6242);
          return 0;
        }
        aw.aKU("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramAnonymousb.EaO));
        if (paramAnonymousb.EdC == null)
        {
          ac.i("MicroMsg.ConversationAdapter", "response.RecCard is null");
          AppMethodBeat.o(6242);
          return 0;
        }
        ??? = new LinkedList();
        paramAnonymousn = paramAnonymousb.EdC.iterator();
        while (paramAnonymousn.hasNext())
        {
          dgb localdgb = (dgb)paramAnonymousn.next();
          Iterator localIterator = this.nPJ.EdC.iterator();
          while (localIterator.hasNext())
          {
            dge localdge = (dge)localIterator.next();
            if (bs.av(localdge.FPs, localdgb.FPs)) {
              if (localdgb.FPo == null)
              {
                ac.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard BizInfo is null");
              }
              else if ((localdgb.FPo.DPI & 0x1) != 0)
              {
                af.aDc().AF(localdgb.FPs);
                h.wUl.idkeyStat(1149L, 5L, 1L, false);
                ac.w("MicroMsg.ConversationAdapter", "doUpdateRecommendCard delete card by flag %d, msgId %d", new Object[] { Integer.valueOf(localdgb.FPo.DPI), Long.valueOf(localdgb.FPs) });
              }
              else if (bs.isNullOrNil(localdgb.FPo.ncR))
              {
                ac.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserName is null");
              }
              else if ((bs.gY(localdgb.FPq)) || (localdgb.FPq.get(0) == null) || (bs.isNullOrNil(((dgc)localdgb.FPq.get(0)).Ean)))
              {
                ac.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard ContentUrl is null");
              }
              else if (!bs.lr(localdgb.FPr, localdge.FPr))
              {
                ???.add(localdgb);
              }
              else
              {
                ac.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard VersionInfo isEqual");
                if ((localdgb.FPt != null) && (!bs.lr(localdgb.FPt.FPr, localdge.FPz)))
                {
                  ???.add(localdgb);
                  ac.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserVersionInfo update");
                }
              }
            }
          }
        }
        ac.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard updateList size %d, RecCard.size %d", new Object[] { Integer.valueOf(???.size()), Integer.valueOf(paramAnonymousb.EdC.size()) });
        if (!bs.gY(???))
        {
          paramAnonymousb = af.aDc();
          if (!bs.gY(???))
          {
            paramAnonymousn = new LinkedList();
            com.tencent.mm.cn.g.fBc().h(new u.8(paramAnonymousb, ???, paramAnonymousn)).b(new u.7(paramAnonymousb, paramAnonymousn));
          }
        }
        AppMethodBeat.o(6242);
        return 0;
      }
    });
    AppMethodBeat.o(6254);
  }
  
  public static String Ur(String paramString)
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
  
  private static dge a(dgg paramdgg, t paramt)
  {
    AppMethodBeat.i(6255);
    if ((paramdgg == null) || (paramdgg.FPB == null) || (paramt == null))
    {
      ac.i("MicroMsg.ConversationAdapter", "getTLRecCardLite invalid data");
      AppMethodBeat.o(6255);
      return null;
    }
    dge localdge = new dge();
    if (!bs.gY(paramdgg.FPB.FPq))
    {
      Iterator localIterator = paramdgg.FPB.FPq.iterator();
      while (localIterator.hasNext())
      {
        dgc localdgc = (dgc)localIterator.next();
        localdge.FPy.add(localdgc.Ean);
      }
    }
    localdge.EaV = paramt.field_talker;
    localdge.FPs = paramt.field_msgId;
    localdge.FPr = paramdgg.FPB.FPr;
    localdge.ESL = paramdgg.style;
    if (paramdgg.FPB.FPt != null) {
      localdge.FPz = paramdgg.FPB.FPt.FPr;
    }
    AppMethodBeat.o(6255);
    return localdge;
  }
  
  public static void a(List<t> paramList, final Runnable paramRunnable)
  {
    AppMethodBeat.i(6248);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6240);
        Iterator localIterator = this.gan.iterator();
        while (localIterator.hasNext())
        {
          t localt = (t)localIterator.next();
          if (localt.eZj()) {
            ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localt.field_msgId, localt.field_content);
          }
        }
        c.cx(this.gan);
        ap.f(paramRunnable);
        AppMethodBeat.o(6240);
      }
    }, 0L);
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
      boolean bool = bs.isEqual(parama1.toByteArray(), parama2.toByteArray());
      AppMethodBeat.o(6249);
      return bool;
    }
    catch (IOException parama1)
    {
      ac.i("MicroMsg.ConversationAdapter", "isMsgStatInfoProtoEqual exp %s", new Object[] { parama1.getMessage() });
      AppMethodBeat.o(6249);
    }
    return false;
  }
  
  public static String bNJ()
  {
    AppMethodBeat.i(6244);
    Object localObject2 = null;
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aGy();
    Object localObject1 = localObject2;
    if (localf != null)
    {
      localObject1 = localObject2;
      if (localf.hNS != null)
      {
        localObject1 = localObject2;
        if (localf.hNQ == 0)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.ay.a.aGv()) {
            localObject1 = localf.hNS;
          }
        }
      }
    }
    AppMethodBeat.o(6244);
    return localObject1;
  }
  
  public static void cv(List<t> paramList)
  {
    AppMethodBeat.i(6247);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(6247);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      t localt = (t)paramList.next();
      if (((!nPG.containsKey(Long.valueOf(localt.field_msgId))) || (zw(((Integer)nPG.get(Long.valueOf(localt.field_msgId))).intValue()))) && (localt.eZj()))
      {
        q localq = new q();
        localq.msgId = localt.field_msgId;
        localq.hkR = localt.field_content;
        localLinkedList.add(localq);
        nPG.put(Long.valueOf(localt.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
      }
    }
    if (localLinkedList.size() > 0) {
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).k(localLinkedList, 90);
    }
    AppMethodBeat.o(6247);
  }
  
  public static void cw(List<t> paramList)
  {
    AppMethodBeat.i(6251);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6241);
        c.cx(this.gan);
        AppMethodBeat.o(6241);
      }
    }, 0L);
    AppMethodBeat.o(6251);
  }
  
  public static void cx(List<t> paramList)
  {
    AppMethodBeat.i(6252);
    int i = aw.aKU("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (t)paramList.next();
      if (((t)localObject).eZk())
      {
        dgg localdgg = ((t)localObject).eZq();
        if ((localdgg != null) && (localdgg.FPB != null) && (Math.abs(l - localdgg.lastUpdateTime) / 1000L > i))
        {
          localObject = a(localdgg, (t)localObject);
          if (localObject != null) {
            localLinkedList.add(localObject);
          }
        }
      }
    }
    if (!bs.gY(localLinkedList)) {
      K(localLinkedList);
    }
    AppMethodBeat.o(6252);
  }
  
  public static void g(t paramt)
  {
    AppMethodBeat.i(6246);
    if ((paramt == null) || (!paramt.eZj()))
    {
      AppMethodBeat.o(6246);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6239);
        if ((c.nPG.containsKey(Long.valueOf(this.nnK.field_msgId))) && (!c.zw(((Integer)c.nPG.get(Long.valueOf(this.nnK.field_msgId))).intValue())))
        {
          AppMethodBeat.o(6239);
          return;
        }
        List localList1 = af.aDc().aF(5, this.nnK.field_orderFlag);
        List localList2 = af.aDc().Ay(this.nnK.field_orderFlag);
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.addAll(localList1);
        localLinkedList.add(this.nnK);
        localLinkedList.addAll(localList2);
        c.cv(localLinkedList);
        AppMethodBeat.o(6239);
      }
    }, 0L);
    AppMethodBeat.o(6246);
  }
  
  public static void h(t paramt)
  {
    AppMethodBeat.i(6253);
    if ((paramt == null) || (!paramt.eZk()))
    {
      AppMethodBeat.o(6253);
      return;
    }
    int i = aw.aKU("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    dgg localdgg = paramt.eZq();
    if ((localdgg != null) && (localdgg.FPB != null) && (Math.abs(l - localdgg.lastUpdateTime) / 1000L > i))
    {
      paramt = a(localdgg, paramt);
      if (paramt != null) {
        localLinkedList.add(paramt);
      }
    }
    if (!bs.gY(localLinkedList)) {
      K(localLinkedList);
    }
    AppMethodBeat.o(6253);
  }
  
  public static void i(t paramt)
  {
    AppMethodBeat.i(198781);
    if ((paramt == null) || (!paramt.eZk()))
    {
      AppMethodBeat.o(198781);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198780);
        if ((c.nPG.containsKey(Long.valueOf(this.nnK.field_msgId))) && (!c.zw(((Integer)c.nPG.get(Long.valueOf(this.nnK.field_msgId))).intValue())))
        {
          AppMethodBeat.o(198780);
          return;
        }
        Object localObject1 = af.aDc().aF(5, this.nnK.field_orderFlag);
        Object localObject3 = af.aDc().Ay(this.nnK.field_orderFlag);
        Object localObject2 = new LinkedList();
        ((List)localObject2).addAll((Collection)localObject1);
        ((List)localObject2).add(this.nnK);
        ((List)localObject2).addAll((Collection)localObject3);
        if (bs.gY((List)localObject2))
        {
          AppMethodBeat.o(198780);
          return;
        }
        localObject1 = new LinkedList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (t)((Iterator)localObject2).next();
          if (((!c.nPG.containsKey(Long.valueOf(((t)localObject3).field_msgId))) || (c.zw(((Integer)c.nPG.get(Long.valueOf(((t)localObject3).field_msgId))).intValue()))) && (((t)localObject3).GCc != null) && (((t)localObject3).GCc.FPB != null) && (!bs.gY(((t)localObject3).GCc.FPB.FPq)) && (((t)localObject3).eZk()))
          {
            int i = 0;
            while (i < ((t)localObject3).GCc.FPB.FPq.size())
            {
              dgc localdgc = (dgc)((t)localObject3).GCc.FPB.FPq.get(i);
              q localq = new q();
              localq.Url = localdgc.Ean;
              localq.hkQ = localdgc.hkQ;
              localq.ReqType = 1;
              ((List)localObject1).add(localq);
              i += 1;
            }
            c.nPG.put(Long.valueOf(((t)localObject3).field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
        }
        if (((List)localObject1).size() > 0) {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).cb((List)localObject1);
        }
        AppMethodBeat.o(198780);
      }
    }, 0L);
    AppMethodBeat.o(198781);
  }
  
  public static boolean zw(int paramInt)
  {
    AppMethodBeat.i(6245);
    if (System.currentTimeMillis() / 1000L - paramInt > a.nPA)
    {
      AppMethodBeat.o(6245);
      return true;
    }
    AppMethodBeat.o(6245);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c
 * JD-Core Version:    0.7.0.1
 */