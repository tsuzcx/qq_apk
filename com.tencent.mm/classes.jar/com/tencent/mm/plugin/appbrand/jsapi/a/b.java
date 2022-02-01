package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.wexnet.SessionKeeper;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ai/JsApiReleaseInferenceSession;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c<f>
{
  public static final int CTRL_INDEX = 1093;
  public static final String NAME = "releaseInferenceSession";
  public static final b.a rCj;
  
  static
  {
    AppMethodBeat.i(325951);
    rCj = new b.a((byte)0);
    AppMethodBeat.o(325951);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(325955);
    if (paramf == null)
    {
      AppMethodBeat.o(325955);
      return;
    }
    if (paramJSONObject == null) {}
    for (int i = -1;; i = paramJSONObject.optInt("sessionId", -1))
    {
      paramJSONObject = paramf.T(a.class);
      s.checkNotNull(paramJSONObject);
      paramJSONObject = ((a)paramJSONObject).zg(i);
      if (paramJSONObject != null) {
        break;
      }
      paramf.callback(paramInt, a(null, a.a.rUC, null));
      AppMethodBeat.o(325955);
      return;
    }
    paramJSONObject.close();
    paramf.callback(paramInt, a(null, a.e.rVt, null));
    AppMethodBeat.o(325955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.b
 * JD-Core Version:    0.7.0.1
 */