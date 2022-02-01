package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.c.a.b.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "saveSplashScreenshot";
  public static final a kqH;
  
  static
  {
    AppMethodBeat.i(187211);
    kqH = new a((byte)0);
    AppMethodBeat.o(187211);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "checkCanInvoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "data", "Lorg/json/JSONObject;", "callbackId", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static boolean a(c paramc)
    {
      AppMethodBeat.i(187203);
      k.h(paramc, "env");
      b.a locala = com.tencent.mm.plugin.appbrand.ui.c.a.b.mnu;
      if (b.a.bxd())
      {
        paramc = paramc.getRuntime();
        k.g(paramc, "env.runtime");
        if (paramc.aTS().jDy)
        {
          AppMethodBeat.o(187203);
          return true;
        }
      }
      AppMethodBeat.o(187203);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/graphics/Bitmap;", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(e parame, o paramo, c paramc, int paramInt) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bmp", "Landroid/graphics/Bitmap;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(e parame, o paramo, c paramc, int paramInt) {}
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback", "com/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot$invoke$2$1$2"})
    static final class a<T>
      implements d<IPCVoid>
    {
      a(String paramString, e.c paramc, Bitmap paramBitmap) {}
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    static final class b<InputType, ResultType>
      implements com.tencent.mm.ipcinvoker.b<com.tencent.mm.plugin.appbrand.ui.c.a.a, IPCVoid>
    {
      public static final b kqL;
      
      static
      {
        AppMethodBeat.i(187207);
        kqL = new b();
        AppMethodBeat.o(187207);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(e parame, c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.e
 * JD-Core Version:    0.7.0.1
 */