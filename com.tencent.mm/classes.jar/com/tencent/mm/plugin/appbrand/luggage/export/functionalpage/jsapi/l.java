package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import d.g.a.b;
import d.g.b.p;
import d.v;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "errorReturn", "", "reason", "handleRequest", "_req", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class l
  extends AppBrandProxyUIProcessTask
{
  private final String TAG = "MicroMsg.AppBrand.FunctionalDirectApi.ProxyTask";
  
  private final void SQ(String paramString)
  {
    AppMethodBeat.i(223707);
    com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "errorReturn reason:".concat(String.valueOf(paramString)));
    b(null);
    AppMethodBeat.o(223707);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(223706);
    if (!(paramProcessRequest instanceof ProxyRequest)) {
      paramProcessRequest = null;
    }
    for (;;)
    {
      paramProcessRequest = (ProxyRequest)paramProcessRequest;
      if (paramProcessRequest == null)
      {
        SQ("Invalid ProxyRequest");
        AppMethodBeat.o(223706);
        return;
      }
      Object localObject = a.lTE;
      localObject = a.lTE;
      localObject = (b)a.c(a.btc(), paramProcessRequest.lUc);
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (localObject == null)
      {
        SQ("Invalid functionHash");
        paramProcessRequest = z.Nhr;
      }
      if (paramProcessRequest == null)
      {
        paramProcessRequest = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.ProxyFunction /* = (com.tencent.mm.ui.MMActivity) -> kotlin.Unit */");
        AppMethodBeat.o(223706);
        throw paramProcessRequest;
      }
      paramProcessRequest = (b)d.g.b.ae.p(paramProcessRequest, 1);
      localObject = bis();
      p.g(localObject, "activityContext");
      paramProcessRequest.invoke(localObject);
      AppMethodBeat.o(223706);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.l
 * JD-Core Version:    0.7.0.1
 */