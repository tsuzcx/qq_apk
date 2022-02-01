package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.ui.b.a.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "RemoveParams", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiRemoveSplashScreenshot
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  @Deprecated
  public static final int CTRL_INDEX = -2;
  @Deprecated
  public static final String NAME = "removeSplashScreenshot";
  private static final JsApiRemoveSplashScreenshot.a rWO;
  
  static
  {
    AppMethodBeat.i(326567);
    rWO = new JsApiRemoveSplashScreenshot.a((byte)0);
    AppMethodBeat.o(326567);
  }
  
  private static final void a(JsApiRemoveSplashScreenshot.RemoveParams paramRemoveParams, f paramf)
  {
    AppMethodBeat.i(326566);
    if (paramRemoveParams != null)
    {
      String str = paramRemoveParams.appId;
      int i = paramRemoveParams.euz;
      paramRemoveParams = (b)n.ag(b.class);
      if (paramRemoveParams != null) {
        b.a(paramRemoveParams, str, i, null, 4);
      }
    }
    if (paramf != null) {
      a.b(paramf);
    }
    AppMethodBeat.o(326566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot
 * JD-Core Version:    0.7.0.1
 */