package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.downloader_app.a.d;

class JsApiJumpDownloaderWidgetForNative$a
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(143329);
    if (paramProcessRequest != null) {}
    for (paramProcessRequest = ((JsApiJumpDownloaderWidgetForNative.JumpDownloadWidgetRequest)paramProcessRequest).appId;; paramProcessRequest = null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("appId", paramProcessRequest);
      localIntent.putExtra("view_task", true);
      ((d)g.E(d.class)).a(aBf(), localIntent, new JsApiJumpDownloaderWidgetForNative.a.1(this));
      AppMethodBeat.o(143329);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiJumpDownloaderWidgetForNative.a
 * JD-Core Version:    0.7.0.1
 */