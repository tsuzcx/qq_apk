package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageInitReadyWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiInitReady;", "()V", "invoke", "", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "data", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
public final class l
  extends g
{
  public final String a(z paramz, JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(50633);
    p.h(paramz, "page");
    String str = super.a(paramz, paramJSONObject);
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("renderingCacheAccepted", false);
    }
    ae.i("MicroMsg.AppBrand.JsApiPageInitReadyWC", "invoke renderingCacheAccepted[" + bool + "] appId[" + paramz.getAppId() + "] url[" + paramz.getURL() + ']');
    if (((paramz instanceof ad)) && (bool))
    {
      paramz = a.Ve(((ad)paramz).getAppId());
      if (paramz != null) {
        paramz.byP();
      }
    }
    p.g(str, "super.invoke(page, data)…)\n            }\n        }");
    AppMethodBeat.o(50633);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.l
 * JD-Core Version:    0.7.0.1
 */