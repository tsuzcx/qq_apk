package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.cm.f;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLCardUpdateMgr;", "", "()V", "STATE_IDLE", "", "STATE_UPDATING", "TAG", "", "mgrState", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMgrState", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setMgrState", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "setQueue", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getSetQueue", "()Ljava/util/HashSet;", "updateQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "getUpdateQueue", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "addUpdateQueue", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "checkUpdate", "", "tryUpdate", "plugin-brandservice_release"})
public final class h
{
  private static AtomicInteger oiF;
  private static final ConcurrentLinkedDeque<oo> oiG;
  private static final HashSet<Long> oiH;
  public static final h oiI;
  
  static
  {
    AppMethodBeat.i(208679);
    oiI = new h();
    oiF = new AtomicInteger(2);
    oiG = new ConcurrentLinkedDeque();
    oiH = new HashSet();
    AppMethodBeat.o(208679);
  }
  
  public static AtomicInteger bPw()
  {
    return oiF;
  }
  
  public static HashSet<Long> bPx()
  {
    return oiH;
  }
  
  private final void bPy()
  {
    AppMethodBeat.i(208678);
    if (oiG.size() <= 0)
    {
      ae.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate size <= 0");
      AppMethodBeat.o(208678);
      return;
    }
    try
    {
      int i = oiF.get();
      if (i == 1) {
        return;
      }
      oiF.set(1);
      Object localObject1 = z.Nhr;
      localObject1 = new com.tencent.mm.ak.b.a();
      ((com.tencent.mm.ak.b.a)localObject1).c((com.tencent.mm.bw.a)new op());
      ((com.tencent.mm.ak.b.a)localObject1).d((com.tencent.mm.bw.a)new oq());
      ((com.tencent.mm.ak.b.a)localObject1).DN("/cgi-bin/mmbiz-bin/timeline/bizrecommendarticle");
      ((com.tencent.mm.ak.b.a)localObject1).oS(1084);
      localObject1 = ((com.tencent.mm.ak.b.a)localObject1).aDS();
      localObject2 = ((com.tencent.mm.ak.b)localObject1).aEU();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendArticleReq");
        AppMethodBeat.o(208678);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      AppMethodBeat.o(208678);
    }
    Object localObject2 = (op)localObject2;
    ((op)localObject2).Gcw = ((oo)oiG.removeFirst());
    ae.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate msgId = " + ((op)localObject2).Gcw.Gcv);
    com.tencent.mm.ak.x.a(localb, (x.a)a.oiJ);
    AppMethodBeat.o(208678);
  }
  
  public static final boolean f(w paramw)
  {
    int i = 0;
    AppMethodBeat.i(208677);
    p.h(paramw, "info");
    if ((paramw.ftk() == null) || (!paramw.ftb()))
    {
      AppMethodBeat.o(208677);
      return false;
    }
    switch (paramw.ftk().style)
    {
    default: 
      AppMethodBeat.o(208677);
      return false;
    case 101: 
    case 102: 
    case 103: 
      ae.i("MicroMsg.BizTLCardUpdateMgr", "checkUpdate msgId = " + paramw.field_msgId);
      h localh = oiI;
      p.h(paramw, "info");
      Object localObject;
      if ((paramw.ftb()) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBs, 1) != 0))
      {
        dmq localdmq = paramw.ftk();
        if (localdmq == null) {
          break label258;
        }
        localObject = localdmq.HTQ;
        if ((localObject != null) && (localdmq.HTS != null) && (!bu.ht((List)localdmq.HTS.Gal)))
        {
          p.h(localdmq, "$this$isExpire");
          int j = ay.aRX("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
          if (Math.abs(System.currentTimeMillis() - localdmq.lastUpdateTime) / 1000L > j) {
            i = 1;
          }
          if (i != 0) {
            break label263;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(208677);
        return true;
        label258:
        localObject = null;
        break;
        try
        {
          label263:
          if (!oiH.contains(Long.valueOf(paramw.field_msgId)))
          {
            localObject = i.g(paramw);
            oiH.add(Long.valueOf(((oo)localObject).Gcv));
            oiG.add(localObject);
            ae.i("MicroMsg.BizTLCardUpdateMgr", "addUpdateQueue msgId = " + paramw.field_msgId + ", queue size = " + oiG.size());
          }
          paramw = z.Nhr;
          localh.bPy();
        }
        finally
        {
          AppMethodBeat.o(208677);
        }
      }
    }
    AppMethodBeat.o(208677);
    return true;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    public static final a oiJ;
    
    static
    {
      AppMethodBeat.i(208676);
      oiJ = new a();
      AppMethodBeat.o(208676);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, final n paramn)
    {
      Object localObject = null;
      AppMethodBeat.i(208675);
      p.h(paramb, "rr");
      p.h(paramn, "scene");
      paramString = h.oiI;
      h.bPw().set(2);
      h.a(h.oiI);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(208675);
        return 0;
      }
      paramn = paramb.aEV();
      paramString = paramn;
      if (!(paramn instanceof oq)) {
        paramString = null;
      }
      paramn = (oq)paramString;
      if (paramn == null)
      {
        AppMethodBeat.o(208675);
        return 0;
      }
      paramString = paramb.aEU();
      if (!(paramString instanceof op)) {
        paramString = localObject;
      }
      for (;;)
      {
        paramString = (op)paramString;
        if (paramString == null)
        {
          AppMethodBeat.o(208675);
          return 0;
        }
        if (paramString.Gcw.Gcv != paramn.Gcx.Gcv)
        {
          AppMethodBeat.o(208675);
          return 0;
        }
        paramString = ag.aGv().DM(paramString.Gcw.Gcv);
        if (paramString == null)
        {
          AppMethodBeat.o(208675);
          return 0;
        }
        if ((paramn.Gcx == null) || (bu.ht((List)paramn.Gcx.Gal)))
        {
          AppMethodBeat.o(208675);
          return 0;
        }
        paramb = h.oiI;
        h.bPx().remove(Long.valueOf(paramString.field_msgId));
        ay.aRX("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramn.FYT));
        ae.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate success msgId = " + paramString.field_msgId);
        com.tencent.mm.cm.g.fWL().h((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {}).b((com.tencent.mm.vending.c.a)new h.a.2(paramString));
        AppMethodBeat.o(208675);
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.h
 * JD-Core Version:    0.7.0.1
 */