package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import com.tencent.luggage.sdk.processes.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class MiniProgramNavigatorUglyLogic$a
  extends AppBrandProxyUIProcessTask
{
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(326220);
    s.u(paramProcessRequest, "request");
    Object localObject1 = (MiniProgramNavigatorUglyLogic.ProxyRequest)paramProcessRequest;
    paramProcessRequest = ((MiniProgramNavigatorUglyLogic.ProxyRequest)localObject1).initConfig;
    localObject1 = ((MiniProgramNavigatorUglyLogic.ProxyRequest)localObject1).siB;
    Object localObject2 = i.tWq;
    localObject2 = i.a.cJV();
    MMActivity localMMActivity = getActivityContext();
    s.s(localMMActivity, "activityContext");
    ((i)localObject2).a((Context)localMMActivity, (g)new n(paramProcessRequest, (AppBrandStatObject)localObject1));
    finishProcess(null);
    AppMethodBeat.o(326220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.MiniProgramNavigatorUglyLogic.a
 * JD-Core Version:    0.7.0.1
 */