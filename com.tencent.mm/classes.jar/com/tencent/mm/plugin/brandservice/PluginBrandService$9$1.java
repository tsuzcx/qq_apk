package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.webcanvas.f;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.q;
import java.util.Map;

final class PluginBrandService$9$1
  implements Runnable
{
  PluginBrandService$9$1(PluginBrandService.9 param9, Map paramMap, e.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(5547);
    Object localObject1 = this.fKy;
    Object localObject2 = this.hEC;
    d.g.b.p.h(localObject1, "values");
    d.g.b.p.h(localObject2, "addMsgInfo");
    if ((((e.a)localObject2).gqE == null) || (((e.a)localObject2).gqE.Fvk == null))
    {
      ad.w("MicroMsg.BizTimeLineStorageLogicExKt", "onBizRecommendExpt data invalid");
      AppMethodBeat.o(5547);
      return;
    }
    Object localObject3 = com.tencent.mm.storage.p.InU;
    if (com.tencent.mm.storage.p.foO())
    {
      if (!g.ajx())
      {
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "onBizRecommendExpt acc not ready");
        AppMethodBeat.o(5547);
        return;
      }
      if (!((b)g.ab(b.class)).ze(1001))
      {
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt style = %s not support", new Object[] { Integer.valueOf(1001) });
        AppMethodBeat.o(5547);
        return;
      }
      localObject3 = aa.bK((Map)localObject1);
      if (localObject3 == null)
      {
        AppMethodBeat.o(5547);
        return;
      }
      if (!aa.b((dlt)localObject3, null))
      {
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt illegal");
        AppMethodBeat.o(5547);
        return;
      }
      if (((dlt)localObject3).HAh.Hkj <= 0) {
        break label352;
      }
      aa.d((dlt)localObject3);
    }
    for (;;)
    {
      localObject2 = f.DyX;
      f.Cj(81L);
      long l = bt.getLong((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.RecID"), 0L);
      int i = bt.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Pos"), -1);
      int j = bt.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Weight"), -1);
      int k = bt.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.UseServerTime"), 0);
      localObject2 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.CardID");
      localObject3 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.ExpType");
      localObject1 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.ExtraData");
      Object localObject4 = q.Ioe;
      q.a(i, j, k, 5, 1001, l, (String)localObject2, (String)localObject3, (String)localObject1);
      AppMethodBeat.o(5547);
      return;
      label352:
      localObject3 = ax.aQA("brandService");
      localObject4 = new StringBuilder("BizLatestRecommendCardInfo");
      d.g.b.p.g(g.ajA(), "MMKernel.account()");
      ((ax)localObject3).encode(a.aiq(), z.a(((e.a)localObject2).gqE.Fvk));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.9.1
 * JD-Core Version:    0.7.0.1
 */