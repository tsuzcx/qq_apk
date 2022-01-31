package com.tencent.mm.plugin.appbrand.service;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.model.h.a;
import com.tencent.mm.plugin.appbrand.report.model.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import org.json.JSONObject;

final class c$3
  extends j
{
  c$3(c paramc, boolean paramBoolean) {}
  
  public final p w(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(143548);
    paramMap.put("scene", Integer.valueOf(this.iJq.getRuntime().wS().bDh.scene));
    JSONObject localJSONObject = this.iJq.getRuntime().atS().wa();
    if (localJSONObject != null) {
      paramMap.put("shareInfo", localJSONObject);
    }
    localJSONObject = new JSONObject(paramMap);
    o localo = this.iJq.getRuntime();
    if (this.iJr)
    {
      d.a(localo, localJSONObject);
      super.BM(localJSONObject.toString());
      AppMethodBeat.o(143548);
      return this;
    }
    for (;;)
    {
      try
      {
        d.b(localo, localJSONObject);
        paramMap = localo.atT().getReporter().aHE().aLj().iGT;
        if (paramMap != null) {
          break label182;
        }
        paramMap = null;
        localJSONObject.put("referpagepath", paramMap);
        localJSONObject.put("clickTimestamp", localo.atS().startTime);
      }
      catch (Exception paramMap)
      {
        ab.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterForeground ex = %s", new Object[] { paramMap });
      }
      break;
      label182:
      paramMap = paramMap.path;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c.3
 * JD-Core Version:    0.7.0.1
 */