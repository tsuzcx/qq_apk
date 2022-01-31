package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.downloader.h.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends aw
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        y.e("MicroMsg.JsApiLaunchApplication", "data is null");
        parama.e("fail", null);
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiLaunchApplication", "paras data error: " + paramString.getMessage());
        paramString = null;
      }
      paramString = paramString.optString("appID");
      if (bk.bl(paramString))
      {
        y.e("MicroMsg.JsApiLaunchApplication", "appid is null or nil");
        parama.e("fail", null);
        return;
      }
      a.a(paramContext, paramString, new c.1(this, parama));
    }
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(a.a parama) {}
  
  public final String name()
  {
    return "launchApplication";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.c
 * JD-Core Version:    0.7.0.1
 */