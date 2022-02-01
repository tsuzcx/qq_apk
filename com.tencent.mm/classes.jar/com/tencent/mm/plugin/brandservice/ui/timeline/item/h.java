package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.am.ag;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLCardUpdateMgr;", "", "()V", "STATE_IDLE", "", "STATE_UPDATING", "TAG", "", "mgrState", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMgrState", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setMgrState", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "setQueue", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getSetQueue", "()Ljava/util/HashSet;", "updateQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "getUpdateQueue", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "addUpdateQueue", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "checkUpdate", "", "tryUpdate", "plugin-brandservice_release"})
public final class h
{
  private static AtomicInteger ocQ;
  private static final ConcurrentLinkedDeque<om> ocR;
  private static final HashSet<Long> ocS;
  public static final h ocT;
  
  static
  {
    AppMethodBeat.i(209705);
    ocT = new h();
    ocQ = new AtomicInteger(2);
    ocR = new ConcurrentLinkedDeque();
    ocS = new HashSet();
    AppMethodBeat.o(209705);
  }
  
  private final void bOA()
  {
    AppMethodBeat.i(209704);
    if (ocR.size() <= 0)
    {
      ad.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate size <= 0");
      AppMethodBeat.o(209704);
      return;
    }
    try
    {
      int i = ocQ.get();
      if (i == 1) {
        return;
      }
      ocQ.set(1);
      Object localObject1 = z.MKo;
      localObject1 = new com.tencent.mm.al.b.a();
      ((com.tencent.mm.al.b.a)localObject1).c((com.tencent.mm.bx.a)new on());
      ((com.tencent.mm.al.b.a)localObject1).d((com.tencent.mm.bx.a)new oo());
      ((com.tencent.mm.al.b.a)localObject1).Dl("/cgi-bin/mmbiz-bin/timeline/bizrecommendarticle");
      ((com.tencent.mm.al.b.a)localObject1).oP(1084);
      localObject1 = ((com.tencent.mm.al.b.a)localObject1).aDC();
      localObject2 = ((com.tencent.mm.al.b)localObject1).aEE();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendArticleReq");
        AppMethodBeat.o(209704);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      AppMethodBeat.o(209704);
    }
    Object localObject2 = (on)localObject2;
    ((on)localObject2).FJX = ((om)ocR.removeFirst());
    ad.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate msgId = " + ((on)localObject2).FJX.FJW);
    com.tencent.mm.al.x.a(localb, (x.a)a.ocU);
    AppMethodBeat.o(209704);
  }
  
  public static AtomicInteger bOy()
  {
    return ocQ;
  }
  
  public static HashSet<Long> bOz()
  {
    return ocS;
  }
  
  public static final boolean f(w paramw)
  {
    int i = 0;
    AppMethodBeat.i(209703);
    p.h(paramw, "info");
    if ((paramw.fpm() == null) || (!paramw.fpe()))
    {
      AppMethodBeat.o(209703);
      return false;
    }
    switch (paramw.fpm().style)
    {
    default: 
      AppMethodBeat.o(209703);
      return false;
    case 101: 
    case 102: 
      ad.i("MicroMsg.BizTLCardUpdateMgr", "checkUpdate msgId = " + paramw.field_msgId);
      h localh = ocT;
      p.h(paramw, "info");
      Object localObject;
      if ((paramw.fpe()) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.quB, 1) != 0))
      {
        dlt localdlt = paramw.fpm();
        if (localdlt == null) {
          break label250;
        }
        localObject = localdlt.HAd;
        if ((localObject != null) && (localdlt.HAf != null) && (!bt.hj((List)localdlt.HAf.FHP)))
        {
          p.h(localdlt, "$this$isExpire");
          int j = ax.aQA("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
          if (Math.abs(System.currentTimeMillis() - localdlt.lastUpdateTime) / 1000L > j) {
            i = 1;
          }
          if (i != 0) {
            break label255;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(209703);
        return true;
        label250:
        localObject = null;
        break;
        try
        {
          label255:
          if (!ocS.contains(Long.valueOf(paramw.field_msgId)))
          {
            localObject = i.g(paramw);
            ocS.add(Long.valueOf(((om)localObject).FJW));
            ocR.add(localObject);
            ad.i("MicroMsg.BizTLCardUpdateMgr", "addUpdateQueue msgId = " + paramw.field_msgId + ", queue size = " + ocR.size());
          }
          paramw = z.MKo;
          localh.bOA();
        }
        finally
        {
          AppMethodBeat.o(209703);
        }
      }
    }
    AppMethodBeat.o(209703);
    return true;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    public static final a ocU;
    
    static
    {
      AppMethodBeat.i(209702);
      ocU = new a();
      AppMethodBeat.o(209702);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb, final n paramn)
    {
      Object localObject = null;
      AppMethodBeat.i(209701);
      p.h(paramb, "rr");
      p.h(paramn, "scene");
      paramString = h.ocT;
      h.bOy().set(2);
      h.a(h.ocT);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(209701);
        return 0;
      }
      paramn = paramb.aEF();
      paramString = paramn;
      if (!(paramn instanceof oo)) {
        paramString = null;
      }
      paramn = (oo)paramString;
      if (paramn == null)
      {
        AppMethodBeat.o(209701);
        return 0;
      }
      paramString = paramb.aEE();
      if (!(paramString instanceof on)) {
        paramString = localObject;
      }
      for (;;)
      {
        paramString = (on)paramString;
        if (paramString == null)
        {
          AppMethodBeat.o(209701);
          return 0;
        }
        if (paramString.FJX.FJW != paramn.FJY.FJW)
        {
          AppMethodBeat.o(209701);
          return 0;
        }
        paramString = ag.aGf().Dn(paramString.FJX.FJW);
        if (paramString == null)
        {
          AppMethodBeat.o(209701);
          return 0;
        }
        if ((paramn.FJY == null) || (bt.hj((List)paramn.FJY.FHP)))
        {
          AppMethodBeat.o(209701);
          return 0;
        }
        paramb = h.ocT;
        h.bOz().remove(Long.valueOf(paramString.field_msgId));
        ax.aQA("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramn.FGx));
        ad.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate success msgId = " + paramString.field_msgId);
        com.tencent.mm.cn.g.fSm().h((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {}).b((com.tencent.mm.vending.c.a)new h.a.2(paramString));
        AppMethodBeat.o(209701);
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.h
 * JD-Core Version:    0.7.0.1
 */