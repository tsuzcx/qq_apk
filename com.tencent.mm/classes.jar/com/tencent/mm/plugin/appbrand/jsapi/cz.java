package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.e.b;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_PreloadNextGame", "PreloadType", "plugin-appbrand-integration_release"})
public final class cz
  extends d<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 644;
  public static final String NAME = "preloadMiniProgramEnv";
  @Deprecated
  public static final a lCx;
  
  static
  {
    AppMethodBeat.i(50418);
    lCx = new a((byte)0);
    AppMethodBeat.o(50418);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b$a
    extends q
    implements a<x>
  {
    public static final a lCy;
    
    static
    {
      AppMethodBeat.i(50411);
      lCy = new a();
      AppMethodBeat.o(50411);
    }
    
    b$a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "", "serviceType", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;)V", "getServiceType", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "APP", "GAME", "Companion", "plugin-appbrand-integration_release"})
  static enum c
  {
    public static final a lCD;
    final g lCC;
    
    static
    {
      AppMethodBeat.i(50413);
      c localc1 = new c("APP", 0, g.nPD);
      lCz = localc1;
      c localc2 = new c("GAME", 1, g.nPE);
      lCA = localc2;
      lCB = new c[] { localc1, localc2 };
      lCD = new a((byte)0);
      AppMethodBeat.o(50413);
    }
    
    private c(g paramg)
    {
      this.lCC = paramg;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType$Companion;", "", "()V", "safeValueOf", "Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "name", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onReady"})
  static final class d
    implements e.b
  {
    d(cz paramcz, g paramg, int paramInt1, com.tencent.mm.plugin.appbrand.d paramd, int paramInt2) {}
    
    public final void onReady()
    {
      AppMethodBeat.i(50416);
      if (e.j(this.lCF) != null) {}
      for (boolean bool = true;; bool = false)
      {
        cz.bEu();
        Log.i("MicroMsg.AppBrand.PrivateJSApiPreloadMiniProgramEnv", "onReady, preloaded[" + bool + ']');
        if (!bool) {
          break;
        }
        h.CyF.dN(this.lCG, z.nME.nMU);
        this.lBv.i(this.lyo, this.lCE.Zf("ok"));
        AppMethodBeat.o(50416);
        return;
      }
      this.lBv.i(this.lyo, this.lCE.Zf("fail"));
      AppMethodBeat.o(50416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cz
 * JD-Core Version:    0.7.0.1
 */