package com.tencent.mm.plugin.appbrand.service;

import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;
import org.json.JSONObject;

final class c$2
  extends k
{
  c$2(c paramc) {}
  
  public final p B(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(48279);
    paramMap = new JSONObject(paramMap);
    o localo = this.luG.getRuntime();
    try
    {
      Object localObject = d.r((ae)localo.aLK().getCurrentPage().getCurrentPageView());
      int i = ((Integer)((Pair)localObject).first).intValue();
      localObject = (String)((Pair)localObject).second;
      paramMap.put("targetAction", i);
      paramMap.put("targetPagePath", localObject);
      paramMap.put("usedState", ((o)localo).DZ().cfo.lpL);
      super.HJ(paramMap.toString());
      AppMethodBeat.o(48279);
      return this;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", new Object[] { localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c.2
 * JD-Core Version:    0.7.0.1
 */