package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageInitReadyWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiInitReady;", "()V", "invoke", "", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "data", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
public final class k
  extends f
{
  public final String a(aa paramaa, JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(50633);
    d.g.b.k.h(paramaa, "page");
    String str = super.a(paramaa, paramJSONObject);
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("renderingCacheAccepted", false);
    }
    ac.i("MicroMsg.AppBrand.JsApiPageInitReadyWC", "invoke renderingCacheAccepted[" + bool + "] appId[" + paramaa.getAppId() + "] url[" + paramaa.getURL() + ']');
    if (((paramaa instanceof ae)) && (bool))
    {
      paramaa = a.QN(((ae)paramaa).getAppId());
      if (paramaa != null) {
        paramaa.btS();
      }
    }
    d.g.b.k.g(str, "super.invoke(page, data)…)\n            }\n        }");
    AppMethodBeat.o(50633);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.k
 * JD-Core Version:    0.7.0.1
 */