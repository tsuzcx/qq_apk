package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.h.b;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_PreloadNextGame", "PreloadType", "plugin-appbrand-integration_release"})
public final class da
  extends c<g>
{
  public static final int CTRL_INDEX = 644;
  public static final String NAME = "preloadMiniProgramEnv";
  @Deprecated
  public static final da.a oxX;
  
  static
  {
    AppMethodBeat.i(50418);
    oxX = new da.a((byte)0);
    AppMethodBeat.o(50418);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "", "serviceType", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;)V", "getServiceType", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "APP", "GAME", "Companion", "plugin-appbrand-integration_release"})
  static enum c
  {
    public static final da.c.a oyd;
    final n oyc;
    
    static
    {
      AppMethodBeat.i(50413);
      c localc1 = new c("APP", 0, n.qRS);
      oxZ = localc1;
      c localc2 = new c("GAME", 1, n.qRT);
      oya = localc2;
      oyb = new c[] { localc1, localc2 };
      oyd = new da.c.a((byte)0);
      AppMethodBeat.o(50413);
    }
    
    private c(n paramn)
    {
      this.oyc = paramn;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onReady"})
  static final class d
    implements h.b
  {
    d(da paramda, n paramn, int paramInt1, g paramg, int paramInt2) {}
    
    public final void NR()
    {
      AppMethodBeat.i(50416);
      if (com.tencent.mm.plugin.appbrand.task.h.i(this.oyf) != null) {}
      for (boolean bool = true;; bool = false)
      {
        da.bPU();
        Log.i("MicroMsg.AppBrand.PrivateJSApiPreloadMiniProgramEnv", "onReady, preloaded[" + bool + ']');
        if (!bool) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.IzE.el(this.oyg, z.qOW.qPp);
        this.owL.j(this.otk, this.oye.agS("ok"));
        AppMethodBeat.o(50416);
        return;
      }
      this.owL.j(this.otk, this.oye.agS("fail"));
      AppMethodBeat.o(50416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.da
 * JD-Core Version:    0.7.0.1
 */