package com.tencent.mm.plugin.appbrand.jsapi.auth;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "", "execute"})
final class a$b
  implements b
{
  public static final b hDb;
  
  static
  {
    AppMethodBeat.i(134644);
    hDb = new b();
    AppMethodBeat.o(134644);
  }
  
  public final void a(f paramf, h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(134643);
    j.q(paramf, "api");
    j.q(paramh, "component");
    j.q(paramJSONObject, "data");
    a.aBU();
    ab.e("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dummy execute name[" + paramf.getName() + "], callbackId[" + paramInt + "], appId[" + paramh.getAppId() + ']');
    AppMethodBeat.o(134643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.a.b
 * JD-Core Version:    0.7.0.1
 */