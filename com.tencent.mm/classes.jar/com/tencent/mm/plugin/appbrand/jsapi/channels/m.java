package com.tencent.mm.plugin.appbrand.jsapi.channels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.EmptyResult;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class m
  extends AppBrandProxyUIProcessTask
{
  private static final void a(m paramm, Integer paramInteger)
  {
    AppMethodBeat.i(327888);
    s.u(paramm, "this$0");
    paramm.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new EmptyResult());
    AppMethodBeat.o(327888);
  }
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(327903);
    if (!(paramProcessRequest instanceof OpenChannelsCreateContactRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenChannelsCreateContact", "handleRequest#OpenChannelsCreateContactTask, request is not OpenChannelsCreateContactRequest");
      AppMethodBeat.o(327903);
      return;
    }
    try
    {
      ((cn)h.az(cn.class)).createAccount(MMApplicationContext.getContext(), null, ((OpenChannelsCreateContactRequest)paramProcessRequest).rRQ, new m..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(327903);
      return;
    }
    catch (Exception paramProcessRequest)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.JsApiOpenChannelsCreateContact", (Throwable)paramProcessRequest, "OpenFinderCreateAccountTask exception", new Object[0]);
      finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new EmptyResult());
      AppMethodBeat.o(327903);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.m
 * JD-Core Version:    0.7.0.1
 */