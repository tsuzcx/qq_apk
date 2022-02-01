package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "errorReturn", "", "reason", "handleRequest", "_req", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class m
  extends AppBrandProxyUIProcessTask
{
  private final String TAG = "MicroMsg.AppBrand.FunctionalDirectApi.ProxyTask";
  
  private final void acy(String paramString)
  {
    AppMethodBeat.i(228930);
    Log.e(this.TAG, "errorReturn reason:".concat(String.valueOf(paramString)));
    b(null);
    AppMethodBeat.o(228930);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(228929);
    if (!(paramProcessRequest instanceof ProxyRequest)) {
      paramProcessRequest = null;
    }
    for (;;)
    {
      paramProcessRequest = (ProxyRequest)paramProcessRequest;
      if (paramProcessRequest == null)
      {
        acy("Invalid ProxyRequest");
        AppMethodBeat.o(228929);
        return;
      }
      Object localObject = a.nbk;
      localObject = a.nbk;
      localObject = (b)a.c(a.bOJ(), paramProcessRequest.nbK);
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (localObject == null)
      {
        acy("Invalid functionHash");
        paramProcessRequest = x.SXb;
      }
      if (paramProcessRequest == null)
      {
        paramProcessRequest = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.ProxyFunction /* = (com.tencent.mm.ui.MMActivity) -> kotlin.Unit */");
        AppMethodBeat.o(228929);
        throw paramProcessRequest;
      }
      paramProcessRequest = (b)af.r(paramProcessRequest, 1);
      localObject = bDF();
      p.g(localObject, "activityContext");
      paramProcessRequest.invoke(localObject);
      AppMethodBeat.o(228929);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.m
 * JD-Core Version:    0.7.0.1
 */