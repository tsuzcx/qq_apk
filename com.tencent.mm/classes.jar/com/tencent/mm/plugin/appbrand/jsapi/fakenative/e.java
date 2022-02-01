package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.c.a.b.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.d<c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "saveSplashScreenshot";
  public static final a lUr;
  
  static
  {
    AppMethodBeat.i(228418);
    lUr = new a((byte)0);
    AppMethodBeat.o(228418);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "checkCanInvoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "data", "Lorg/json/JSONObject;", "callbackId", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static boolean a(c paramc)
    {
      AppMethodBeat.i(228410);
      p.h(paramc, "env");
      b.a locala = com.tencent.mm.plugin.appbrand.ui.c.a.b.ogd;
      if (b.a.bZg())
      {
        paramc = paramc.getRuntime();
        p.g(paramc, "env.runtime");
        if (paramc.bsC().ldN)
        {
          AppMethodBeat.o(228410);
          return true;
        }
      }
      AppMethodBeat.o(228410);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/Bitmap;", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(e parame, com.tencent.mm.plugin.appbrand.q paramq, c paramc, int paramInt) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bmp", "Landroid/graphics/Bitmap;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(e parame, com.tencent.mm.plugin.appbrand.q paramq, c paramc, int paramInt) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback", "com/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot$invoke$2$1$2"})
    static final class a<T>
      implements com.tencent.mm.ipcinvoker.d<IPCVoid>
    {
      a(String paramString, e.c paramc, Bitmap paramBitmap) {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    static final class b<InputType, ResultType>
      implements com.tencent.mm.ipcinvoker.b<com.tencent.mm.plugin.appbrand.ui.c.a.a, IPCVoid>
    {
      public static final b lUv;
      
      static
      {
        AppMethodBeat.i(228414);
        lUv = new b();
        AppMethodBeat.o(228414);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(e parame, c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.e
 * JD-Core Version:    0.7.0.1
 */