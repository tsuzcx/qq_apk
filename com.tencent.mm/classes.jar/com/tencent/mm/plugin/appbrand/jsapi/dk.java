package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.task.l;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_PreloadNextGame", "PreloadType", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dk
  extends c<g>
{
  @Deprecated
  public static final int CTRL_INDEX = 644;
  @Deprecated
  public static final String NAME = "preloadMiniProgramEnv";
  private static final dk.a rBw;
  
  static
  {
    AppMethodBeat.i(50418);
    rBw = new dk.a((byte)0);
    AppMethodBeat.o(50418);
  }
  
  private static final void a(l paraml, int paramInt1, g paramg, int paramInt2, dk paramdk)
  {
    AppMethodBeat.i(325484);
    s.u(paraml, "$preloadType");
    s.u(paramdk, "this$0");
    if (com.tencent.mm.plugin.appbrand.task.h.i(paraml) != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.PrivateJSApiPreloadMiniProgramEnv", "onReady, preloaded[" + bool + ']');
      if (!bool) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.OAn.kJ(paramInt1, ab.tTN.tTD);
      paramg.callback(paramInt2, paramdk.ZP("ok"));
      AppMethodBeat.o(325484);
      return;
    }
    paramg.callback(paramInt2, paramdk.ZP("fail"));
    AppMethodBeat.o(325484);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "", "serviceType", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;)V", "getServiceType", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "APP", "GAME", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static enum c
  {
    public static final dk.c.a rBy;
    final l rBz;
    
    static
    {
      AppMethodBeat.i(50413);
      rBA = new c("APP", 0, l.tWw);
      rBB = new c("GAME", 1, l.tWx);
      rBC = new c[] { rBA, rBB };
      rBy = new dk.c.a((byte)0);
      AppMethodBeat.o(50413);
    }
    
    private c(l paraml)
    {
      this.rBz = paraml;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dk
 * JD-Core Version:    0.7.0.1
 */