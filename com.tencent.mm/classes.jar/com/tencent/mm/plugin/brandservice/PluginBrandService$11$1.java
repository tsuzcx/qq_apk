package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.webcanvas.j;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.r;
import java.util.Map;

final class PluginBrandService$11$1
  implements Runnable
{
  PluginBrandService$11$1(PluginBrandService.11 param11, g.a parama, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(5547);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.oiK != null) && (this.oiK.mpN != null) && (this.oiK.mpN.YFG != null))
    {
      localObject1 = this.lxX;
      localObject2 = w.a(this.oiK.mpN.YFG);
      kotlin.g.b.s.u(localObject1, "values");
      kotlin.g.b.s.u(localObject2, "content");
      if (ah.iZd())
      {
        localObject3 = ah.cA((Map)localObject1);
        if (localObject3 != null)
        {
          if (!ah.c((flj)localObject3, null))
          {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt illegal");
            AppMethodBeat.o(5547);
            return;
          }
          switch (((flj)localObject3).abrz)
          {
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = j.WkY;
      j.xC(81L);
      long l = Util.getLong((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.RecID"), 0L);
      int i = Util.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Pos"), -1);
      int j = Util.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Weight"), -1);
      int k = Util.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.UseServerTime"), 0);
      localObject2 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.CardID");
      localObject3 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.ExpType");
      localObject1 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.ExtraData");
      Object localObject4 = com.tencent.mm.storage.s.acEH;
      com.tencent.mm.storage.s.a(i, j, k, 5, 1001, l, (String)localObject2, (String)localObject3, (String)localObject1);
      AppMethodBeat.o(5547);
      return;
      ad.bvD((String)localObject2);
      r.a(r.acDM, (flj)localObject3);
      continue;
      ah.d((flj)localObject3);
      continue;
      localObject4 = ae.acGm;
      ae.bvF((String)localObject2);
      r.a(r.acDM, (flj)localObject3);
      localObject2 = ae.acGm;
      ae.yX(2L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.11.1
 * JD-Core Version:    0.7.0.1
 */