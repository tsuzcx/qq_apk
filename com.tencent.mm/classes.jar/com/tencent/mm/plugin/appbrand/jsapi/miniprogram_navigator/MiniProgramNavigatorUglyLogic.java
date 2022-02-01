package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import com.tencent.luggage.sdk.processes.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.a.n;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "to", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "ProxyRequest", "ProxyTask", "plugin-appbrand-integration_release"})
public final class MiniProgramNavigatorUglyLogic
{
  public static final MiniProgramNavigatorUglyLogic pdj;
  
  static
  {
    AppMethodBeat.i(50584);
    pdj = new MiniProgramNavigatorUglyLogic();
    AppMethodBeat.o(50584);
  }
  
  public static final boolean a(t paramt, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(273887);
    kotlin.g.b.p.k(paramt, "from");
    kotlin.g.b.p.k(paramAppBrandInitConfigWC, "config");
    if ((paramt.Qv()) && (paramAppBrandInitConfigWC.Qv()) && (!n.bOz()))
    {
      paramt = (Context)paramt.getContext();
      AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfigWC.Qu();
      kotlin.g.b.p.j(localAppBrandStatObject, "config.statObject");
      a.a(paramt, (AppBrandProxyUIProcessTask.ProcessRequest)new MiniProgramNavigatorUglyLogic.ProxyRequest(paramAppBrandInitConfigWC, localAppBrandStatObject), null);
      AppMethodBeat.o(273887);
      return true;
    }
    AppMethodBeat.o(273887);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(262873);
      kotlin.g.b.p.k(paramProcessRequest, "request");
      Object localObject1 = (MiniProgramNavigatorUglyLogic.ProxyRequest)paramProcessRequest;
      paramProcessRequest = ((MiniProgramNavigatorUglyLogic.ProxyRequest)localObject1).nyg;
      localObject1 = ((MiniProgramNavigatorUglyLogic.ProxyRequest)localObject1).pdk;
      Object localObject2 = i.qRL;
      localObject2 = i.a.cjb();
      MMActivity localMMActivity = bPf();
      kotlin.g.b.p.j(localMMActivity, "activityContext");
      ((i)localObject2).a((Context)localMMActivity, (g)new com.tencent.mm.plugin.appbrand.task.p(paramProcessRequest, (AppBrandStatObject)localObject1));
      b(null);
      AppMethodBeat.o(262873);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.MiniProgramNavigatorUglyLogic
 * JD-Core Version:    0.7.0.1
 */