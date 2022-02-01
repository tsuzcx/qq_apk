package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class x
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(228542);
    if (!(paramProcessRequest instanceof ShareFileToConversationRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "handleRequest, request is not ShareFileToConversationRequest");
      AppMethodBeat.o(228542);
      return;
    }
    if (((CharSequence)((ShareFileToConversationRequest)paramProcessRequest).filePath).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "handleRequest, fail since filePath is empty");
      b((AppBrandProxyUIProcessTask.ProcessResult)new ShareToConversationResult(ab.msV.msX));
      AppMethodBeat.o(228542);
      return;
    }
    Object localObject2 = db.D(((ShareFileToConversationRequest)paramProcessRequest).filePath, ((ShareFileToConversationRequest)paramProcessRequest).gCr, ((ShareFileToConversationRequest)paramProcessRequest).fileName);
    Object localObject1 = w.msz;
    localObject1 = bDF();
    p.g(localObject1, "activityContext");
    localObject1 = (Activity)localObject1;
    paramProcessRequest = ((ShareFileToConversationRequest)paramProcessRequest).filePath;
    b localb = (b)new a(this);
    p.h(localObject1, "activity");
    p.h(paramProcessRequest, "filePath");
    p.h(localObject2, "fileName");
    p.h(localb, "shareCallBack");
    localObject2 = (b)new w.a(localb, (Activity)localObject1, paramProcessRequest, (String)localObject2);
    paramProcessRequest = new o(paramProcessRequest);
    if (paramProcessRequest.exists()) {}
    for (paramProcessRequest = Long.valueOf(paramProcessRequest.length());; paramProcessRequest = null)
    {
      Log.d("MicroMsg.AppBrand.JsApiShareFileMessage", "isFileLegal2Share, fileSize: ".concat(String.valueOf(paramProcessRequest)));
      if ((paramProcessRequest != null) && (0L < paramProcessRequest.longValue())) {
        break;
      }
      h.a((Context)localObject1, ((Activity)localObject1).getString(2131759324), "", ((Activity)localObject1).getString(2131761757), (DialogInterface.OnClickListener)new w.c((b)localObject2));
      AppMethodBeat.o(228542);
      return;
    }
    i = c.aqr();
    if (i < paramProcessRequest.longValue())
    {
      h.a((Context)localObject1, ((Activity)localObject1).getString(2131756051, new Object[] { Util.getSizeKB(i) }), "", ((Activity)localObject1).getString(2131761757), (DialogInterface.OnClickListener)new w.d((b)localObject2));
      AppMethodBeat.o(228542);
      return;
    }
    ((b)localObject2).invoke(Boolean.TRUE);
    AppMethodBeat.o(228542);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "shareResult", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "invoke"})
  static final class a
    extends q
    implements b<ab, kotlin.x>
  {
    a(x paramx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.x
 * JD-Core Version:    0.7.0.1
 */