package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.g.b.ae;
import d.g.b.p;
import d.v;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "errorReturn", "", "reason", "handleRequest", "_req", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class l
  extends AppBrandProxyUIProcessTask
{
  private final String TAG = "MicroMsg.AppBrand.FunctionalDirectApi.ProxyTask";
  
  private final void Sh(String paramString)
  {
    AppMethodBeat.i(189447);
    ad.e(this.TAG, "errorReturn reason:".concat(String.valueOf(paramString)));
    b(null);
    AppMethodBeat.o(189447);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(189446);
    if (!(paramProcessRequest instanceof ProxyRequest)) {
      paramProcessRequest = null;
    }
    for (;;)
    {
      paramProcessRequest = (ProxyRequest)paramProcessRequest;
      if (paramProcessRequest == null)
      {
        Sh("Invalid ProxyRequest");
        AppMethodBeat.o(189446);
        return;
      }
      Object localObject = a.lPd;
      localObject = a.lPd;
      localObject = (b)a.c(a.bsr(), paramProcessRequest.lPB);
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (localObject == null)
      {
        Sh("Invalid functionHash");
        paramProcessRequest = z.MKo;
      }
      if (paramProcessRequest == null)
      {
        paramProcessRequest = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.ProxyFunction /* = (com.tencent.mm.ui.MMActivity) -> kotlin.Unit */");
        AppMethodBeat.o(189446);
        throw paramProcessRequest;
      }
      paramProcessRequest = (b)ae.p(paramProcessRequest, 1);
      localObject = bhJ();
      p.g(localObject, "activityContext");
      paramProcessRequest.invoke(localObject);
      AppMethodBeat.o(189446);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.l
 * JD-Core Version:    0.7.0.1
 */