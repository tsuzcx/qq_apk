package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends AppBrandProxyUIProcessTask
{
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(326382);
    if (!(paramProcessRequest instanceof ShareGifToConversationRequest))
    {
      Log.w("MicroMsg.AppBrand.ShareGifToConversationLogic", "handleRequest, request is not ShareGifToConversationRequest");
      AppMethodBeat.o(326382);
      return;
    }
    if (((CharSequence)((ShareGifToConversationRequest)paramProcessRequest).path).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.ShareGifToConversationLogic", "handleRequest, fail since path is empty");
      finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new ShareToConversationResult(aa.svP.rht));
      AppMethodBeat.o(326382);
      return;
    }
    Object localObject = v.svz;
    localObject = getActivityContext();
    s.s(localObject, "activityContext");
    v.a((Activity)localObject, ((ShareGifToConversationRequest)paramProcessRequest).path, (b)new a(this));
    AppMethodBeat.o(326382);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "shareResult", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<aa, ah>
  {
    a(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.w
 * JD-Core Version:    0.7.0.1
 */