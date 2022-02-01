package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
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
    Object localObject1 = this.fMB;
    Object localObject2 = this.hHu;
    d.g.b.p.h(localObject1, "values");
    d.g.b.p.h(localObject2, "addMsgInfo");
    if ((((e.a)localObject2).gte == null) || (((e.a)localObject2).gte.FNI == null))
    {
      ae.w("MicroMsg.BizTimeLineStorageLogicExKt", "onBizRecommendExpt data invalid");
      AppMethodBeat.o(5547);
      return;
    }
    Object localObject3 = com.tencent.mm.storage.p.IIi;
    if (com.tencent.mm.storage.p.fsH())
    {
      if (!com.tencent.mm.kernel.g.ajM())
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "onBizRecommendExpt acc not ready");
        AppMethodBeat.o(5547);
        return;
      }
      if (!((b)com.tencent.mm.kernel.g.ab(b.class)).zn(1001))
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt style = %s not support", new Object[] { Integer.valueOf(1001) });
        AppMethodBeat.o(5547);
        return;
      }
      localObject3 = aa.bQ((Map)localObject1);
      if (localObject3 == null)
      {
        AppMethodBeat.o(5547);
        return;
      }
      if (!aa.b((dmq)localObject3, null))
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt illegal");
        AppMethodBeat.o(5547);
        return;
      }
      if (((dmq)localObject3).HTU.HDJ <= 0) {
        break label352;
      }
      aa.d((dmq)localObject3);
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.webcanvas.g.DQG;
      com.tencent.mm.plugin.webcanvas.g.CH(81L);
      long l = bu.getLong((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.RecID"), 0L);
      int i = bu.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Pos"), -1);
      int j = bu.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Weight"), -1);
      int k = bu.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.UseServerTime"), 0);
      localObject2 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.CardID");
      localObject3 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.ExpType");
      localObject1 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.ExtraData");
      Object localObject4 = q.IIu;
      q.a(i, j, k, 5, 1001, l, (String)localObject2, (String)localObject3, (String)localObject1);
      AppMethodBeat.o(5547);
      return;
      label352:
      localObject3 = ay.aRX("brandService");
      localObject4 = new StringBuilder("BizLatestRecommendCardInfo");
      d.g.b.p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
      ((ay)localObject3).encode(a.aiF(), z.a(((e.a)localObject2).gte.FNI));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.9.1
 * JD-Core Version:    0.7.0.1
 */