package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.c.a.b.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "saveSplashScreenshot";
  public static final a kMd;
  
  static
  {
    AppMethodBeat.i(189144);
    kMd = new a((byte)0);
    AppMethodBeat.o(189144);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "checkCanInvoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "data", "Lorg/json/JSONObject;", "callbackId", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static boolean a(c paramc)
    {
      AppMethodBeat.i(189136);
      p.h(paramc, "env");
      b.a locala = com.tencent.mm.plugin.appbrand.ui.c.a.b.mNW;
      if (b.a.bBj())
      {
        paramc = paramc.getRuntime();
        p.g(paramc, "env.runtime");
        if (paramc.aXc().jXu)
        {
          AppMethodBeat.o(189136);
          return true;
        }
      }
      AppMethodBeat.o(189136);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/graphics/Bitmap;", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(e parame, o paramo, c paramc, int paramInt) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bmp", "Landroid/graphics/Bitmap;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(e parame, o paramo, c paramc, int paramInt) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback", "com/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot$invoke$2$1$2"})
    static final class a<T>
      implements d<IPCVoid>
    {
      a(String paramString, e.c paramc, Bitmap paramBitmap) {}
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    static final class b<InputType, ResultType>
      implements com.tencent.mm.ipcinvoker.b<com.tencent.mm.plugin.appbrand.ui.c.a.a, IPCVoid>
    {
      public static final b kMh;
      
      static
      {
        AppMethodBeat.i(189140);
        kMh = new b();
        AppMethodBeat.o(189140);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
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