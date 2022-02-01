package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webcanvas.l;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.s;
import java.util.Map;
import kotlin.g.b.p;

final class PluginBrandService$11$1
  implements Runnable
{
  PluginBrandService$11$1(PluginBrandService.11 param11, h.a parama, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(5547);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.lrj != null) && (this.lrj.jQG != null) && (this.lrj.jQG.RIF != null))
    {
      localObject1 = this.iVZ;
      localObject2 = z.a(this.lrj.jQG.RIF);
      p.k(localObject1, "values");
      p.k(localObject2, "content");
      if (af.hxA())
      {
        localObject3 = af.cc((Map)localObject1);
        if (localObject3 == null)
        {
          AppMethodBeat.o(5547);
          return;
        }
        if (!af.b((eqg)localObject3, null))
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt illegal");
          AppMethodBeat.o(5547);
          return;
        }
        switch (((eqg)localObject3).Uax)
        {
        }
      }
    }
    for (;;)
    {
      localObject2 = l.PuB;
      l.Tt(81L);
      long l = Util.getLong((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.RecID"), 0L);
      int i = Util.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Pos"), -1);
      int j = Util.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.Weight"), -1);
      int k = Util.getInt((String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.UseServerTime"), 0);
      localObject2 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.CardID");
      localObject3 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.ExpType");
      localObject1 = (String)((Map)localObject1).get(".sysmsg.BizRecommendExpt.ExtraData");
      Object localObject4 = s.Vdo;
      s.a(i, j, k, 5, 1001, l, (String)localObject2, (String)localObject3, (String)localObject1);
      AppMethodBeat.o(5547);
      return;
      localObject4 = MultiProcessMMKV.getSingleMMKV("brandService");
      StringBuilder localStringBuilder = new StringBuilder("BizLatestRecommendCardInfo");
      p.j(h.aHE(), "MMKernel.account()");
      ((MultiProcessMMKV)localObject4).encode(b.aGq(), (String)localObject2);
      r.VcW.b((eqg)localObject3);
      continue;
      af.f((eqg)localObject3);
      continue;
      localObject4 = ac.VeT;
      ac.bvw((String)localObject2);
      r.VcW.b((eqg)localObject3);
      localObject2 = ac.VeT;
      ac.UO(2L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.11.1
 * JD-Core Version:    0.7.0.1
 */