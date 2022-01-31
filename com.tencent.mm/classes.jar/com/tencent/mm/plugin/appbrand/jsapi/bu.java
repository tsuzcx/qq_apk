package com.tencent.mm.plugin.appbrand.jsapi;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.task.g;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_TriggerNetworkOpt", "PreloadType", "plugin-appbrand-integration_release"})
public final class bu
  extends a<d>
{
  public static final int CTRL_INDEX = 644;
  public static final String NAME = "preloadMiniProgramEnv";
  @Deprecated
  public static final bu.a hAD;
  
  static
  {
    AppMethodBeat.i(143745);
    hAD = new bu.a((byte)0);
    AppMethodBeat.o(143745);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "", "serviceType", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;)V", "getServiceType", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "APP", "GAME", "Companion", "plugin-appbrand-integration_release"})
  static enum c
  {
    public static final bu.c.a hAI;
    final g hAH;
    
    static
    {
      AppMethodBeat.i(143739);
      c localc1 = new c("APP", 0, g.iKS);
      hAE = localc1;
      c localc2 = new c("GAME", 1, g.iKT);
      hAF = localc2;
      hAG = new c[] { localc1, localc2 };
      hAI = new bu.c.a((byte)0);
      AppMethodBeat.o(143739);
    }
    
    private c(g paramg)
    {
      AppMethodBeat.i(143740);
      this.hAH = paramg;
      AppMethodBeat.o(143740);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bu
 * JD-Core Version:    0.7.0.1
 */