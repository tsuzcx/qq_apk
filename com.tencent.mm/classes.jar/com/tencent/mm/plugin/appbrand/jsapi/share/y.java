package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
public final class y
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(279219);
    if (!(paramProcessRequest instanceof ShareGifToConversationRequest))
    {
      Log.w("MicroMsg.AppBrand.ShareGifToConversationLogic", "handleRequest, request is not ShareGifToConversationRequest");
      AppMethodBeat.o(279219);
      return;
    }
    if (((CharSequence)((ShareGifToConversationRequest)paramProcessRequest).path).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.ShareGifToConversationLogic", "handleRequest, fail since path is empty");
      b((AppBrandProxyUIProcessTask.ProcessResult)new ShareToConversationResult(ac.pre.prg));
      AppMethodBeat.o(279219);
      return;
    }
    Object localObject = x.pqP;
    localObject = bPf();
    p.j(localObject, "activityContext");
    x.a((Activity)localObject, ((ShareGifToConversationRequest)paramProcessRequest).path, (b)new a(this));
    AppMethodBeat.o(279219);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "shareResult", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "invoke"})
  static final class a
    extends q
    implements b<ac, kotlin.x>
  {
    a(y paramy)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.y
 * JD-Core Version:    0.7.0.1
 */