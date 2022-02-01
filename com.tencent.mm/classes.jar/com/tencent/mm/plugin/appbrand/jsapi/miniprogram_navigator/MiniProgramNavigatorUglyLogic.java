package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "to", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "ProxyRequest", "ProxyTask", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MiniProgramNavigatorUglyLogic
{
  public static final MiniProgramNavigatorUglyLogic siA;
  
  static
  {
    AppMethodBeat.i(50584);
    siA = new MiniProgramNavigatorUglyLogic();
    AppMethodBeat.o(50584);
  }
  
  public static final boolean c(w paramw, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(326227);
    s.u(paramw, "from");
    s.u(paramAppBrandInitConfigWC, "config");
    if ((paramw.aqJ()) && (paramAppBrandInitConfigWC.aqJ()) && (!o.coO()))
    {
      paramw = (Context)AndroidContextUtil.castActivityOrNull(paramw.mContext);
      AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfigWC.epn;
      s.s(localAppBrandStatObject, "config.statObject");
      a.a(paramw, (AppBrandProxyUIProcessTask.ProcessRequest)new MiniProgramNavigatorUglyLogic.ProxyRequest(paramAppBrandInitConfigWC, localAppBrandStatObject), null);
      AppMethodBeat.o(326227);
      return true;
    }
    AppMethodBeat.o(326227);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.MiniProgramNavigatorUglyLogic
 * JD-Core Version:    0.7.0.1
 */