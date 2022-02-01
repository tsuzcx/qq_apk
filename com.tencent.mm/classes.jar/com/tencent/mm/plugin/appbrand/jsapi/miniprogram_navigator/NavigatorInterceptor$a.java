package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class NavigatorInterceptor$a
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(274255);
    if (paramProcessRequest == null)
    {
      paramProcessRequest = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.NavigatorInterceptor.MMLaunchEntryProxyRequest");
      AppMethodBeat.o(274255);
      throw paramProcessRequest;
    }
    paramProcessRequest = ((NavigatorInterceptor.MMLaunchEntryProxyRequest)paramProcessRequest).pdr;
    f.pZN.a((Context)bPf(), paramProcessRequest);
    b(null);
    AppMethodBeat.o(274255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.NavigatorInterceptor.a
 * JD-Core Version:    0.7.0.1
 */