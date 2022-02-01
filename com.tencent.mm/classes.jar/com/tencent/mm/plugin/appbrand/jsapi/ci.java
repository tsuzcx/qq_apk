package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.task.c;
import com.tencent.mm.plugin.appbrand.task.c.a;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_PreloadNextGame", "PreloadType", "plugin-appbrand-integration_release"})
public final class ci
  extends a<d>
{
  public static final int CTRL_INDEX = 644;
  public static final String NAME = "preloadMiniProgramEnv";
  @Deprecated
  public static final a jAd;
  
  static
  {
    AppMethodBeat.i(50418);
    jAd = new a((byte)0);
    AppMethodBeat.o(50418);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b$a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final a jAe;
    
    static
    {
      AppMethodBeat.i(50411);
      jAe = new a();
      AppMethodBeat.o(50411);
    }
    
    b$a()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "", "serviceType", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;)V", "getServiceType", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "APP", "GAME", "Companion", "plugin-appbrand-integration_release"})
  static enum c
  {
    public static final a jAj;
    final e jAi;
    
    static
    {
      AppMethodBeat.i(50413);
      c localc1 = new c("APP", 0, e.lwx);
      jAf = localc1;
      c localc2 = new c("GAME", 1, e.lwy);
      jAg = localc2;
      jAh = new c[] { localc1, localc2 };
      jAj = new a((byte)0);
      AppMethodBeat.o(50413);
    }
    
    private c(e parame)
    {
      this.jAi = parame;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType$Companion;", "", "()V", "safeValueOf", "Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "name", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onReady"})
  static final class d
    implements c.a
  {
    d(ci paramci, d paramd, int paramInt) {}
    
    public final void onReady()
    {
      AppMethodBeat.i(50416);
      if (c.bnv() != null) {}
      for (boolean bool = true;; bool = false)
      {
        ci.aXW();
        ad.i("MicroMsg.AppBrand.PrivateJSApiPreloadMiniProgramEnv", "onReady, preloaded[" + bool + ']');
        if (!bool) {
          break;
        }
        this.jyZ.h(this.jxb, this.jAk.HI("ok"));
        AppMethodBeat.o(50416);
        return;
      }
      this.jyZ.h(this.jxb, this.jAk.HI("fail"));
      AppMethodBeat.o(50416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ci
 * JD-Core Version:    0.7.0.1
 */