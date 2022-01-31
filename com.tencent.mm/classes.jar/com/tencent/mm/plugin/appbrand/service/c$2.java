package com.tencent.mm.plugin.appbrand.service;

import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import org.json.JSONObject;

final class c$2
  extends com.tencent.mm.plugin.appbrand.page.i
{
  c$2(c paramc) {}
  
  public final p w(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(143546);
    paramMap = new JSONObject(paramMap);
    com.tencent.mm.plugin.appbrand.o localo = this.iJq.getRuntime();
    try
    {
      Object localObject = d.i((z)localo.atj().getCurrentPage().getCurrentPageView());
      int i = ((Integer)((Pair)localObject).first).intValue();
      localObject = (String)((Pair)localObject).second;
      paramMap.put("targetAction", i);
      paramMap.put("targetPagePath", localObject);
      paramMap.put("usedState", ((com.tencent.mm.plugin.appbrand.o)localo).wS().bDh.iFX);
      super.BM(paramMap.toString());
      AppMethodBeat.o(143546);
      return this;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", new Object[] { localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c.2
 * JD-Core Version:    0.7.0.1
 */