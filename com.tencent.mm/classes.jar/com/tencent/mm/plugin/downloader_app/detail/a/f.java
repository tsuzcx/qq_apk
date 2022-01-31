package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends aw
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      l = paramString.optLong("download_id");
      if (l <= 0L)
      {
        y.e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = " + l);
        parama.e("invalid_downloadid", null);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      y.e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.e("fail", null);
      return;
    }
    paramString = com.tencent.mm.plugin.downloader.model.c.dk(l);
    if (paramString != null) {
      b.dCw.a(paramString.field_appId, paramString.field_scene, 10, paramString.field_startSize, paramString.field_downloadedSize - paramString.field_startSize, paramString.field_totalSize, paramString.field_downloadUrl, paramString.field_errCode, paramString.field_downloaderType, paramString.field_channelId, (System.currentTimeMillis() - paramString.field_startTime) / 1000L, paramString.field_startState, paramString.field_downloadId, paramString.field_extInfo);
    }
    com.tencent.mm.plugin.downloader_app.b.c.a(paramContext, paramString, new f.1(this, parama));
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(a.a parama) {}
  
  public final String name()
  {
    return "resumeDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.f
 * JD-Core Version:    0.7.0.1
 */