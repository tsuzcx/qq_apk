package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.plugin.appbrand.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = -1;
  public static final String NAME = "hideSplashScreenshot";
  public static final a rWG;
  
  static
  {
    AppMethodBeat.i(326575);
    rWG = new a((byte)0);
    AppMethodBeat.o(326575);
  }
  
  private static final void a(w paramw, com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt, a parama)
  {
    AppMethodBeat.i(326573);
    s.u(paramw, "$runtime");
    s.u(parama, "this$0");
    ah localah = paramw.cbM();
    if (localah == null)
    {
      paramc.callback(paramInt, parama.ZP("fail: timeout"));
      AppMethodBeat.o(326573);
      return;
    }
    if ((localah instanceof ag))
    {
      paramw.cbx();
      paramc.callback(paramInt, parama.ZP("ok"));
      AppMethodBeat.o(326573);
      return;
    }
    paramc.callback(paramInt, parama.ZP("fail: screenshot invalid"));
    AppMethodBeat.o(326573);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot$Constants;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.a
 * JD-Core Version:    0.7.0.1
 */