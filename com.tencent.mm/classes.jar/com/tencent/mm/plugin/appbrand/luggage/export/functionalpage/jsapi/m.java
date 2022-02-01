package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "errorReturn", "", "reason", "handleRequest", "_req", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class m
  extends AppBrandProxyUIProcessTask
{
  private final String TAG = "MicroMsg.AppBrand.FunctionalDirectApi.ProxyTask";
  
  private final void ady(String paramString)
  {
    AppMethodBeat.i(320104);
    Log.e(this.TAG, s.X("errorReturn reason:", paramString));
    finishProcess(null);
    AppMethodBeat.o(320104);
  }
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(320110);
    if ((paramProcessRequest instanceof ProxyRequest)) {}
    for (paramProcessRequest = (ProxyRequest)paramProcessRequest; paramProcessRequest == null; paramProcessRequest = null)
    {
      ady("Invalid ProxyRequest");
      AppMethodBeat.o(320110);
      return;
    }
    Object localObject = a.tgy;
    localObject = a.tgy;
    paramProcessRequest = (b)a.d(a.cBs(), paramProcessRequest.tgR);
    if (paramProcessRequest == null)
    {
      ady("Invalid functionHash");
      AppMethodBeat.o(320110);
      return;
    }
    localObject = getActivityContext();
    s.s(localObject, "activityContext");
    paramProcessRequest.invoke(localObject);
    AppMethodBeat.o(320110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.m
 * JD-Core Version:    0.7.0.1
 */