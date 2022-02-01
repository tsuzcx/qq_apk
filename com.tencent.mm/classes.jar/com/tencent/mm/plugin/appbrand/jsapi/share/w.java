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
import com.tencent.mm.plugin.appbrand.jsapi.dc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class w
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(272523);
    if (!(paramProcessRequest instanceof ShareFileToConversationRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "handleRequest, request is not ShareFileToConversationRequest");
      AppMethodBeat.o(272523);
      return;
    }
    if (((CharSequence)((ShareFileToConversationRequest)paramProcessRequest).filePath).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "handleRequest, fail since filePath is empty");
      b((AppBrandProxyUIProcessTask.ProcessResult)new ShareToConversationResult(ac.pre.prg));
      AppMethodBeat.o(272523);
      return;
    }
    Object localObject2 = dc.E(((ShareFileToConversationRequest)paramProcessRequest).filePath, ((ShareFileToConversationRequest)paramProcessRequest).jmx, ((ShareFileToConversationRequest)paramProcessRequest).fileName);
    Object localObject1 = v.pqH;
    localObject1 = bPf();
    p.j(localObject1, "activityContext");
    localObject1 = (Activity)localObject1;
    paramProcessRequest = ((ShareFileToConversationRequest)paramProcessRequest).filePath;
    b localb = (b)new a(this);
    p.k(localObject1, "activity");
    p.k(paramProcessRequest, "filePath");
    p.k(localObject2, "fileName");
    p.k(localb, "shareCallBack");
    localObject2 = (m)new v.a(localb, (Activity)localObject1, paramProcessRequest, (String)localObject2);
    paramProcessRequest = new com.tencent.mm.vfs.q(paramProcessRequest);
    if (paramProcessRequest.ifE()) {}
    for (paramProcessRequest = Long.valueOf(paramProcessRequest.length());; paramProcessRequest = null)
    {
      Log.d("MicroMsg.AppBrand.JsApiShareFileMessage", "isFileLegal2Share, fileSize: ".concat(String.valueOf(paramProcessRequest)));
      if ((paramProcessRequest != null) && (0L < paramProcessRequest.longValue())) {
        break;
      }
      h.a((Context)localObject1, ((Activity)localObject1).getString(au.i.favorite_share_file_not_exists), "", ((Activity)localObject1).getString(au.i.i_know_it), (DialogInterface.OnClickListener)new v.b((m)localObject2));
      AppMethodBeat.o(272523);
      return;
    }
    long l = c.awK();
    if (l < paramProcessRequest.longValue())
    {
      h.a((Context)localObject1, ((Activity)localObject1).getString(au.i.appbrand_file_too_big_to_send, new Object[] { Util.getSizeKB(l) }), "", ((Activity)localObject1).getString(au.i.i_know_it), (DialogInterface.OnClickListener)new v.c((m)localObject2));
      AppMethodBeat.o(272523);
      return;
    }
    ((m)localObject2).invoke(Boolean.TRUE, null);
    AppMethodBeat.o(272523);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "shareResult", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements b<ac, x>
  {
    a(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.w
 * JD-Core Version:    0.7.0.1
 */