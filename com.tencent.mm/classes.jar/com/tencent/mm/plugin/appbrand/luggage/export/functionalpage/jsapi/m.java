package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "errorReturn", "", "reason", "handleRequest", "_req", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class m
  extends AppBrandProxyUIProcessTask
{
  private final String TAG = "MicroMsg.AppBrand.FunctionalDirectApi.ProxyTask";
  
  private final void aks(String paramString)
  {
    AppMethodBeat.i(282727);
    Log.e(this.TAG, "errorReturn reason:".concat(String.valueOf(paramString)));
    b(null);
    AppMethodBeat.o(282727);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(282726);
    if (!(paramProcessRequest instanceof ProxyRequest)) {
      paramProcessRequest = null;
    }
    for (;;)
    {
      paramProcessRequest = (ProxyRequest)paramProcessRequest;
      if (paramProcessRequest == null)
      {
        aks("Invalid ProxyRequest");
        AppMethodBeat.o(282726);
        return;
      }
      Object localObject = a.qbz;
      localObject = a.qbz;
      localObject = (b)a.c(a.caZ(), paramProcessRequest.qbY);
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (localObject == null)
      {
        aks("Invalid functionHash");
        paramProcessRequest = x.aazN;
      }
      if (paramProcessRequest == null)
      {
        paramProcessRequest = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.ProxyFunction /* = (com.tencent.mm.ui.MMActivity) -> kotlin.Unit */");
        AppMethodBeat.o(282726);
        throw paramProcessRequest;
      }
      paramProcessRequest = (b)ag.x(paramProcessRequest, 1);
      localObject = bPf();
      p.j(localObject, "activityContext");
      paramProcessRequest.invoke(localObject);
      AppMethodBeat.o(282726);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.m
 * JD-Core Version:    0.7.0.1
 */