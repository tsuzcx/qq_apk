package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageInitReadyWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiInitReady;", "()V", "invoke", "", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "data", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
public final class o
  extends h
{
  public final String a(ac paramac, JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(50633);
    p.h(paramac, "page");
    String str = super.a(paramac, paramJSONObject);
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("renderingCacheAccepted", false);
    }
    Log.i("MicroMsg.AppBrand.JsApiPageInitReadyWC", "invoke renderingCacheAccepted[" + bool + "] appId[" + paramac.getAppId() + "] url[" + paramac.getURL() + ']');
    if (((paramac instanceof ag)) && (bool))
    {
      paramac = b.aeU(((ag)paramac).getAppId());
      if (paramac != null) {
        paramac.bVi();
      }
    }
    p.g(str, "super.invoke(page, data)…)\n            }\n        }");
    AppMethodBeat.o(50633);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.o
 * JD-Core Version:    0.7.0.1
 */