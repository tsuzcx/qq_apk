package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.dm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class u
  extends AppBrandProxyUIProcessTask
{
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(326379);
    if (!(paramProcessRequest instanceof ShareFileToConversationRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "handleRequest, request is not ShareFileToConversationRequest");
      AppMethodBeat.o(326379);
      return;
    }
    if (((CharSequence)((ShareFileToConversationRequest)paramProcessRequest).filePath).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "handleRequest, fail since filePath is empty");
      finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new ShareToConversationResult(aa.svP.rht));
      AppMethodBeat.o(326379);
      return;
    }
    String str = dm.I(((ShareFileToConversationRequest)paramProcessRequest).filePath, ((ShareFileToConversationRequest)paramProcessRequest).lPJ, ((ShareFileToConversationRequest)paramProcessRequest).fileName);
    Object localObject = t.svt;
    localObject = getActivityContext();
    s.s(localObject, "activityContext");
    t.a((Activity)localObject, ((ShareFileToConversationRequest)paramProcessRequest).filePath, str, (b)new a(this));
    AppMethodBeat.o(326379);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "shareResult", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements b<aa, ah>
  {
    a(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.u
 * JD-Core Version:    0.7.0.1
 */