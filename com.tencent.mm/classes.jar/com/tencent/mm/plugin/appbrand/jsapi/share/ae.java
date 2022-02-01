package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class ae
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(276841);
    if (!(paramProcessRequest instanceof ShareVideoToConversationRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "handleRequest, request is not ShareVideoToConversationRequest");
      AppMethodBeat.o(276841);
      return;
    }
    if (((CharSequence)((ShareVideoToConversationRequest)paramProcessRequest).videoPath).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "handleRequest, fail since videoPath is empty");
      b((AppBrandProxyUIProcessTask.ProcessResult)new ShareToConversationResult(ac.pre.prg));
      AppMethodBeat.o(276841);
      return;
    }
    Object localObject1 = ad.prj;
    localObject1 = bPf();
    p.j(localObject1, "activityContext");
    localObject1 = (Activity)localObject1;
    String str = ((ShareVideoToConversationRequest)paramProcessRequest).videoPath;
    paramProcessRequest = ((ShareVideoToConversationRequest)paramProcessRequest).thumbPath;
    Object localObject2 = (b)new a(this);
    p.k(localObject1, "activity");
    p.k(str, "videoPath");
    p.k(localObject2, "shareCallBack");
    localObject2 = (m)new ad.b((b)localObject2, (Activity)localObject1, str, paramProcessRequest);
    i = de.agW(str);
    if (i <= 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "isVideoLegal2Share, durationS: ".concat(String.valueOf(i)));
      ((m)localObject2).invoke(Boolean.FALSE, null);
      AppMethodBeat.o(276841);
      return;
    }
    paramProcessRequest = new com.tencent.mm.vfs.q(str);
    if (paramProcessRequest.ifE()) {}
    for (paramProcessRequest = Long.valueOf(paramProcessRequest.length());; paramProcessRequest = null)
    {
      Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", "isVideoLegal2Share, videoSize: ".concat(String.valueOf(paramProcessRequest)));
      if ((paramProcessRequest != null) && (0L < paramProcessRequest.longValue())) {
        break;
      }
      h.a((Context)localObject1, ((Activity)localObject1).getString(au.i.gallery_pic_video_too_short_title), "", ((Activity)localObject1).getString(au.i.i_know_it), (DialogInterface.OnClickListener)new ad.d((m)localObject2));
      AppMethodBeat.o(276841);
      return;
    }
    if (c.awJ() < paramProcessRequest.longValue())
    {
      h.a((Context)localObject1, ((Activity)localObject1).getString(au.i.gallery_send_video_over_size), "", ((Activity)localObject1).getString(au.i.i_know_it), (DialogInterface.OnClickListener)new ad.e((m)localObject2));
      AppMethodBeat.o(276841);
      return;
    }
    ((m)localObject2).invoke(Boolean.TRUE, new ad.a(i));
    AppMethodBeat.o(276841);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "shareResult", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements b<ac, x>
  {
    a(ae paramae)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ae
 * JD-Core Version:    0.7.0.1
 */