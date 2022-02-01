package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class NavigatorInterceptor$a
  extends AppBrandProxyUIProcessTask
{
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(326272);
    if (paramProcessRequest == null)
    {
      paramProcessRequest = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.NavigatorInterceptor.MMLaunchEntryProxyRequest");
      AppMethodBeat.o(326272);
      throw paramProcessRequest;
    }
    paramProcessRequest = ((NavigatorInterceptor.MMLaunchEntryProxyRequest)paramProcessRequest).siI;
    f.teH.a((Context)getActivityContext(), paramProcessRequest);
    finishProcess(null);
    AppMethodBeat.o(326272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.NavigatorInterceptor.a
 * JD-Core Version:    0.7.0.1
 */