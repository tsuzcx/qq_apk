package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.x;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends c<g>
{
  @Deprecated
  public static final int CTRL_INDEX = -2;
  @Deprecated
  public static final String NAME = "rewriteRoute";
  private static final s.a snY;
  
  static
  {
    AppMethodBeat.i(327721);
    snY = new s.a((byte)0);
    AppMethodBeat.o(327721);
  }
  
  private static final void a(g paramg, int paramInt1, String paramString, int paramInt2, s params)
  {
    AppMethodBeat.i(327719);
    kotlin.g.b.s.u(params, "this$0");
    if (paramg.getRuntime().getPageContainer().aE(paramInt1, paramString)) {}
    for (paramString = "ok";; paramString = "fail")
    {
      paramg.callback(paramInt2, params.ZP(paramString));
      AppMethodBeat.o(327719);
      return;
    }
  }
  
  public final boolean cpE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.s
 * JD-Core Version:    0.7.0.1
 */