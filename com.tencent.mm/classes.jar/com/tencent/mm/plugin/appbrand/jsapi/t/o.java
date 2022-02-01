package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.dp;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageInitReadyWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiInitReady;", "()V", "invoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends h
{
  private static final void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(327709);
    s.u(paramg, "$env");
    ad localad = dp.j((f)paramg);
    if (localad == null)
    {
      AppMethodBeat.o(327709);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiPageInitReadyWC", "invoke renderingCacheAccepted[" + paramBoolean + "] appId[" + paramg.getAppId() + "] url[" + localad.cgR() + ']');
    if (((localad instanceof ah)) && (paramBoolean))
    {
      paramg = b.afZ(((ah)localad).getAppId());
      if (paramg != null) {
        paramg.cJk();
      }
    }
    AppMethodBeat.o(327709);
  }
  
  public final String a(g paramg, JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(327718);
    s.u(paramg, "env");
    String str = super.a(paramg, paramJSONObject);
    if (paramJSONObject == null) {}
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.bk(new o..ExternalSyntheticLambda0(paramg, bool));
      s.s(str, "super.invoke(env, data).…}\n            }\n        }");
      AppMethodBeat.o(327718);
      return str;
      bool = paramJSONObject.optBoolean("renderingCacheAccepted", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.o
 * JD-Core Version:    0.7.0.1
 */