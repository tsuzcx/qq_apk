package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class ad
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(228573);
    if (!(paramProcessRequest instanceof ShareVideoToConversationRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "handleRequest, request is not ShareVideoToConversationRequest");
      AppMethodBeat.o(228573);
      return;
    }
    if (((CharSequence)((ShareVideoToConversationRequest)paramProcessRequest).videoPath).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "handleRequest, fail since videoPath is empty");
      b((AppBrandProxyUIProcessTask.ProcessResult)new ShareToConversationResult(ab.msV.msX));
      AppMethodBeat.o(228573);
      return;
    }
    Object localObject = ac.mta;
    localObject = bDF();
    p.g(localObject, "activityContext");
    localObject = (Activity)localObject;
    String str = ((ShareVideoToConversationRequest)paramProcessRequest).videoPath;
    paramProcessRequest = ((ShareVideoToConversationRequest)paramProcessRequest).thumbPath;
    b localb = (b)new a(this);
    p.h(localObject, "activity");
    p.h(str, "videoPath");
    p.h(localb, "shareCallBack");
    localb = (b)new ac.a(localb, (Activity)localObject, str, paramProcessRequest);
    paramProcessRequest = new o(str);
    if (paramProcessRequest.exists()) {}
    for (paramProcessRequest = Long.valueOf(paramProcessRequest.length());; paramProcessRequest = null)
    {
      Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", "isVideoLegal2Share, videoSize: ".concat(String.valueOf(paramProcessRequest)));
      if ((paramProcessRequest != null) && (0L < paramProcessRequest.longValue())) {
        break;
      }
      h.a((Context)localObject, ((Activity)localObject).getString(2131761126), "", ((Activity)localObject).getString(2131761757), (DialogInterface.OnClickListener)new ac.c(localb));
      AppMethodBeat.o(228573);
      return;
    }
    if (c.aqq() < paramProcessRequest.longValue())
    {
      h.a((Context)localObject, ((Activity)localObject).getString(2131761146), "", ((Activity)localObject).getString(2131761757), (DialogInterface.OnClickListener)new ac.d(localb));
      AppMethodBeat.o(228573);
      return;
    }
    localb.invoke(Boolean.TRUE);
    AppMethodBeat.o(228573);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "shareResult", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "invoke"})
  static final class a
    extends q
    implements b<ab, x>
  {
    a(ad paramad)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ad
 * JD-Core Version:    0.7.0.1
 */