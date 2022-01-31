package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.i.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends bh
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(136071);
    ab.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        ab.e("MicroMsg.JsApiLaunchApplication", "data is null");
        parama.c("fail", null);
        AppMethodBeat.o(136071);
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiLaunchApplication", "paras data error: " + paramString.getMessage());
        paramString = null;
      }
      paramString = paramString.optString("appID");
      if (bo.isNullOrNil(paramString))
      {
        ab.e("MicroMsg.JsApiLaunchApplication", "appid is null or nil");
        parama.c("fail", null);
        AppMethodBeat.o(136071);
        return;
      }
      a.a(paramContext, paramString, new c.1(this, parama));
      AppMethodBeat.o(136071);
    }
  }
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launchApplication";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.c
 * JD-Core Version:    0.7.0.1
 */