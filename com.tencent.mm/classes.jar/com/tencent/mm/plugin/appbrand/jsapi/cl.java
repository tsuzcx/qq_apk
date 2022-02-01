package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.task.c;
import com.tencent.mm.plugin.appbrand.task.c.a;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_PreloadNextGame", "PreloadType", "plugin-appbrand-integration_release"})
public final class cl
  extends a<d>
{
  public static final int CTRL_INDEX = 644;
  public static final String NAME = "preloadMiniProgramEnv";
  @Deprecated
  public static final a kuV;
  
  static
  {
    AppMethodBeat.i(50418);
    kuV = new a((byte)0);
    AppMethodBeat.o(50418);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b$a
    extends q
    implements d.g.a.a<z>
  {
    public static final a kuW;
    
    static
    {
      AppMethodBeat.i(50411);
      kuW = new a();
      AppMethodBeat.o(50411);
    }
    
    b$a()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "", "serviceType", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;)V", "getServiceType", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "APP", "GAME", "Companion", "plugin-appbrand-integration_release"})
  static enum c
  {
    public static final a kvb;
    final e kva;
    
    static
    {
      AppMethodBeat.i(50413);
      c localc1 = new c("APP", 0, e.myg);
      kuX = localc1;
      c localc2 = new c("GAME", 1, e.myh);
      kuY = localc2;
      kuZ = new c[] { localc1, localc2 };
      kvb = new a((byte)0);
      AppMethodBeat.o(50413);
    }
    
    private c(e parame)
    {
      this.kva = parame;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType$Companion;", "", "()V", "safeValueOf", "Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "name", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onReady"})
  static final class d
    implements c.a
  {
    d(cl paramcl, d paramd, int paramInt) {}
    
    public final void onReady()
    {
      AppMethodBeat.i(50416);
      if (c.byx() != null) {}
      for (boolean bool = true;; bool = false)
      {
        cl.bix();
        ad.i("MicroMsg.AppBrand.PrivateJSApiPreloadMiniProgramEnv", "onReady, preloaded[" + bool + ']');
        if (!bool) {
          break;
        }
        this.ktS.h(this.krv, this.kvc.Pg("ok"));
        AppMethodBeat.o(50416);
        return;
      }
      this.ktS.h(this.krv, this.kvc.Pg("fail"));
      AppMethodBeat.o(50416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cl
 * JD-Core Version:    0.7.0.1
 */