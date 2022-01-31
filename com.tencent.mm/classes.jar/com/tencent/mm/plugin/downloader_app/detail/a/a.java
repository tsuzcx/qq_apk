package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends aw
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    try
    {
      paramString = new JSONObject(paramString);
      str1 = paramString.optString("task_url");
      l = paramString.optLong("task_size");
      if (bk.bl(str1))
      {
        y.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
        parama.e("fail", null);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      y.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + paramContext.getMessage());
      parama.e("fail", null);
      return;
    }
    if (!aq.isNetworkConnected(paramContext))
    {
      parama.e("fail_network_not_connected", null);
      com.tencent.mm.cg.a.m(new a.1(this, paramContext));
      y.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
      return;
    }
    if (!f.zF())
    {
      parama.e("sdcard_not_ready", null);
      com.tencent.mm.cg.a.m(new a.2(this, paramContext));
      y.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      return;
    }
    if ((l > 0L) && (!f.bs(l)))
    {
      parama.e("has_not_enough_space", null);
      com.tencent.mm.cg.a.m(new a.3(this, paramContext));
      y.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = " + l);
      return;
    }
    String str1 = paramString.optString("task_name");
    String str2 = paramString.optString("task_url");
    String str3 = paramString.optString("alternative_url");
    long l = paramString.optLong("task_size");
    String str4 = paramString.optString("file_md5");
    String str5 = paramString.optString("extInfo");
    String str6 = paramString.optString("appid");
    String str7 = paramString.optString("packageName");
    int i = paramString.optInt("downloader_type", 1);
    paramString = new com.tencent.mm.plugin.downloader_app.b.a();
    paramString.appName = str1;
    paramString.downloadUrl = str2;
    paramString.iRR = str3;
    paramString.iRS = l;
    paramString.iRT = str4;
    paramString.extInfo = str5;
    paramString.appId = str6;
    paramString.packageName = str7;
    paramString.bOz = i;
    c.a(paramContext, paramString, new a.4(this, str6, parama));
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(a.a parama) {}
  
  public final String name()
  {
    return "addDownloadTaskStraight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.a
 * JD-Core Version:    0.7.0.1
 */