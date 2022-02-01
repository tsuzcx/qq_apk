package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.an.af;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ac.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLCardUpdateMgr;", "", "()V", "STATE_IDLE", "", "STATE_UPDATING", "TAG", "", "hasUpdateQueue", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getHasUpdateQueue", "()Ljava/util/HashSet;", "isUpdateCardOpen", "", "()Z", "isUpdateCardOpen$delegate", "Lkotlin/Lazy;", "mgrState", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMgrState", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setMgrState", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "setQueue", "getSetQueue", "updateQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "getUpdateQueue", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "addUpdateQueue", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "checkUpdate", "clearUpdateQueue", "tryUpdate", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j vJo;
  private static AtomicInteger vJp;
  private static final ConcurrentLinkedDeque<qq> vJq;
  private static final HashSet<Long> vJr;
  private static final HashSet<Long> vJs;
  private static final kotlin.j vJt;
  
  static
  {
    AppMethodBeat.i(302766);
    vJo = new j();
    vJp = new AtomicInteger(2);
    vJq = new ConcurrentLinkedDeque();
    vJr = new HashSet();
    vJs = new HashSet();
    vJt = k.cm((kotlin.g.a.a)a.vJu);
    AppMethodBeat.o(302766);
  }
  
  private static final ah a(ab paramab, qs paramqs, Void paramVoid)
  {
    AppMethodBeat.i(302749);
    s.u(paramab, "$info");
    s.u(paramqs, "$resp");
    paramVoid = paramab.iYp();
    if (paramVoid == null) {}
    for (paramVoid = null; paramVoid == null; paramVoid = paramVoid.abLM)
    {
      paramab = ah.aiuX;
      AppMethodBeat.o(302749);
      return paramab;
    }
    switch (paramab.iYp().style)
    {
    default: 
      paramVoid = paramab.iYp();
      paramVoid.abLM.YFu = paramqs.YVM.YFu;
      paramVoid.abLM.Zxn = paramqs.YVM.hAP;
      paramVoid.abLM.YSB = paramqs.YVM.YSB;
    }
    for (paramVoid.lastUpdateTime = System.currentTimeMillis();; paramVoid.lastUpdateTime = System.currentTimeMillis())
    {
      paramab.b(paramab.iYp());
      af.bHl().updateNotify((IAutoDBItem)paramab, false, new String[] { "msgId" });
      paramab = ah.aiuX;
      AppMethodBeat.o(302749);
      return paramab;
      paramVoid = paramab.iYp();
      paramVoid.abLM.YFu = paramqs.YVM.YFu;
      Object localObject1 = paramVoid.abLM.YSB;
      s.s(localObject1, "extraInfo.BizInfo");
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject2 = (qo)localObject2;
        if ((i < paramqs.YVM.YSB.size()) && (paramqs.YVM.YSB.get(i) != null))
        {
          paramVoid.abLM.YSB.set(i, paramqs.YVM.YSB.get(i));
          ((qo)paramVoid.abLM.YSB.get(i)).YVA = ((qo)localObject2).YVA;
          ((qo)paramVoid.abLM.YSB.get(i)).YVB = ((qo)localObject2).YVB;
          Object localObject3 = ((qo)paramVoid.abLM.YSB.get(i)).YVI;
          s.s(localObject3, "extraInfo.BizInfo[index].AppMsg");
          localObject3 = ((Iterable)localObject3).iterator();
          int j = 0;
          while (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = ((Iterator)localObject3).next();
            if (j < 0) {
              kotlin.a.p.kkW();
            }
            localObject4 = (qn)localObject4;
            if ((((qo)localObject2).YVI != null) && (((qo)localObject2).YVI.get(j) != null))
            {
              qn localqn = (qn)((qo)localObject2).YVI.get(j);
              ((qn)localObject4).YVA = localqn.YVA;
              ((qn)localObject4).YVB = localqn.YVB;
              if (((qn)localObject4).YFu != 1) {
                ((qn)localObject4).YFu = localqn.YFu;
              }
              ((qn)localObject4).YVF = localqn.YVF;
              ((qn)localObject4).YVE = localqn.YVE;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  private static final ah a(ab paramab, ah paramah)
  {
    AppMethodBeat.i(302754);
    s.u(paramab, "$info");
    paramah = new ac.a();
    paramah.acFX = ac.b.acGb;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramab);
    paramab = ah.aiuX;
    paramah.list = ((List)localLinkedList);
    af.bHl().a(paramah);
    paramab = ah.aiuX;
    AppMethodBeat.o(302754);
    return paramab;
  }
  
  private static final int c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(302761);
    s.u(paramc, "rr");
    s.u(paramp, "scene");
    vJp.set(2);
    vJo.ddr();
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(302761);
      return 0;
    }
    paramString = c.c.b(paramc.otC);
    if ((paramString instanceof qs)) {}
    for (paramString = (qs)paramString; paramString == null; paramString = null)
    {
      AppMethodBeat.o(302761);
      return 0;
    }
    paramc = c.b.b(paramc.otB);
    if ((paramc instanceof qr)) {}
    for (paramc = (qr)paramc; paramc == null; paramc = null)
    {
      AppMethodBeat.o(302761);
      return 0;
    }
    if (paramc.YVL.YVJ != paramString.YVM.YVJ)
    {
      AppMethodBeat.o(302761);
      return 0;
    }
    paramc = af.bHl().aq(paramc.YVL.YVJ, "msgId");
    if (paramc == null)
    {
      AppMethodBeat.o(302761);
      return 0;
    }
    if ((paramString.YVM == null) || (Util.isNullOrNil((List)paramString.YVM.YSB)))
    {
      AppMethodBeat.o(302761);
      return 0;
    }
    vJr.remove(Long.valueOf(paramc.field_msgId));
    MultiProcessMMKV.getSingleMMKV("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(60, paramString.YRq));
    Log.i("MicroMsg.BizTLCardUpdateMgr", s.X("tryUpdate success msgId = ", Long.valueOf(paramc.field_msgId)));
    g.jPX().h(new j..ExternalSyntheticLambda2(paramc, paramString)).b(new j..ExternalSyntheticLambda1(paramc));
    AppMethodBeat.o(302761);
    return 0;
  }
  
  public static void ddq()
  {
    AppMethodBeat.i(302712);
    vJs.clear();
    AppMethodBeat.o(302712);
  }
  
  private final void ddr()
  {
    AppMethodBeat.i(302742);
    if (vJq.size() <= 0)
    {
      Log.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate size <= 0");
      AppMethodBeat.o(302742);
      return;
    }
    try
    {
      int i = vJp.get();
      if (i == 1) {
        return;
      }
      vJp.set(1);
      Object localObject1 = ah.aiuX;
      localObject1 = new com.tencent.mm.am.c.a();
      ((com.tencent.mm.am.c.a)localObject1).otE = ((com.tencent.mm.bx.a)new qr());
      ((com.tencent.mm.am.c.a)localObject1).otF = ((com.tencent.mm.bx.a)new qs());
      ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/timeline/bizrecommendarticle";
      ((com.tencent.mm.am.c.a)localObject1).funcId = 1084;
      localObject1 = ((com.tencent.mm.am.c.a)localObject1).bEF();
      localObject2 = c.b.b(((com.tencent.mm.am.c)localObject1).otB);
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendArticleReq");
        AppMethodBeat.o(302742);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      AppMethodBeat.o(302742);
    }
    Object localObject2 = (qr)localObject2;
    ((qr)localObject2).YVL = ((qq)vJq.removeFirst());
    Log.i("MicroMsg.BizTLCardUpdateMgr", s.X("tryUpdate msgId = ", Long.valueOf(((qr)localObject2).YVL.YVJ)));
    z.a(localc, j..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(302742);
  }
  
  public static final boolean j(ab paramab)
  {
    int i = 0;
    AppMethodBeat.i(302726);
    s.u(paramab, "info");
    if ((paramab.iYp() == null) || (!paramab.iYf()))
    {
      AppMethodBeat.o(302726);
      return false;
    }
    switch (paramab.iYp().style)
    {
    default: 
      AppMethodBeat.o(302726);
      return false;
    case 101: 
    case 102: 
    case 103: 
      Log.i("MicroMsg.BizTLCardUpdateMgr", s.X("checkUpdate msgId = ", Long.valueOf(paramab.field_msgId)));
      j localj = vJo;
      s.u(paramab, "info");
      Object localObject2;
      Object localObject1;
      if ((((Boolean)vJt.getValue()).booleanValue()) && (paramab.iYf()) && (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yOv, 1) != 0))
      {
        localObject2 = paramab.iYp();
        if (localObject2 != null) {
          break label222;
        }
        localObject1 = null;
        if ((localObject1 != null) && (((flj)localObject2).abLM != null) && (!Util.isNullOrNil((List)((flj)localObject2).abLM.YSB))) {
          break label231;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(302726);
        return true;
        label222:
        localObject1 = ((flj)localObject2).abLK;
        break;
        label231:
        if (vJs.contains(Long.valueOf(paramab.field_msgId)))
        {
          s.s(localObject2, "wrapper");
          s.u(localObject2, "<this>");
          int j = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
          if (Math.abs(System.currentTimeMillis() - ((flj)localObject2).lastUpdateTime) / 1000L > j) {
            i = 1;
          }
          if (i == 0)
          {
            Log.d("MicroMsg.BizTLCardUpdateMgr", "Has not expired, not to update now.");
            continue;
          }
        }
        vJs.add(Long.valueOf(paramab.field_msgId));
        Object localObject3;
        for (;;)
        {
          pt localpt;
          try
          {
            if (vJr.contains(Long.valueOf(paramab.field_msgId))) {
              break label717;
            }
            s.u(paramab, "<this>");
            localObject1 = new qq();
            ((qq)localObject1).YVJ = paramab.field_msgId;
            ((qq)localObject1).bcb = paramab.acFD.style;
            ((qq)localObject1).YSD = paramab.acFD.event;
            ((qq)localObject1).YVK = paramab.acFD.hRR;
            localObject2 = ((qq)localObject1).YSB;
            localObject3 = paramab.iYp().abLM.YSB;
            s.s(localObject3, "info.tlRecCardWrapper.extraInfo.BizInfo");
            Object localObject4 = (Iterable)localObject3;
            localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
            localObject4 = ((Iterable)localObject4).iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            Object localObject5 = (qo)((Iterator)localObject4).next();
            localpt = new pt();
            localpt.YRs = ((qo)localObject5).UserName;
            LinkedList localLinkedList = localpt.YTk;
            localObject5 = ((qo)localObject5).YVI;
            s.s(localObject5, "info.AppMsg");
            Object localObject6 = (Iterable)localObject5;
            localObject5 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject6, 10));
            localObject6 = ((Iterable)localObject6).iterator();
            if (((Iterator)localObject6).hasNext())
            {
              ((Collection)localObject5).add(((qn)((Iterator)localObject6).next()).YQK);
              continue;
            }
            localLinkedList.addAll((Collection)localObject5);
          }
          finally
          {
            AppMethodBeat.o(302726);
          }
          ((Collection)localObject3).add(localpt);
        }
        ((LinkedList)localObject2).addAll((Collection)localObject3);
        vJr.add(Long.valueOf(((qq)localObject1).YVJ));
        vJq.add(localObject1);
        Log.i("MicroMsg.BizTLCardUpdateMgr", "addUpdateQueue msgId = " + paramab.field_msgId + ", queue size = " + vJq.size());
        label717:
        paramab = ah.aiuX;
        localj.ddr();
      }
    }
    AppMethodBeat.o(302726);
    return true;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final a vJu;
    
    static
    {
      AppMethodBeat.i(302449);
      vJu = new a();
      AppMethodBeat.o(302449);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.j
 * JD-Core Version:    0.7.0.1
 */