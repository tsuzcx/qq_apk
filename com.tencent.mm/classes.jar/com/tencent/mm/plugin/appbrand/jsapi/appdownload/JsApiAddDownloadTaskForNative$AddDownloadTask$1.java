package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.o.a;
import org.json.JSONObject;

final class JsApiAddDownloadTaskForNative$AddDownloadTask$1
  implements o.a
{
  JsApiAddDownloadTaskForNative$AddDownloadTask$1(JsApiAddDownloadTaskForNative.AddDownloadTask paramAddDownloadTask) {}
  
  public final void c(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143280);
    if (paramJSONObject == null)
    {
      JsApiAddDownloadTaskForNative.AddDownloadTask.a(this.hAY, true);
      AppMethodBeat.o(143280);
      return;
    }
    JsApiAddDownloadTaskForNative.AddDownloadTask.a(this.hAY, paramJSONObject.optInt("download_id", -1));
    if (JsApiAddDownloadTaskForNative.AddDownloadTask.a(this.hAY) <= 0L)
    {
      JsApiAddDownloadTaskForNative.AddDownloadTask.a(this.hAY, true);
      AppMethodBeat.o(143280);
      return;
    }
    JsApiAddDownloadTaskForNative.AddDownloadTask.a(this.hAY, false);
    AppMethodBeat.o(143280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskForNative.AddDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */