package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.i.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends bq
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(8826);
    ad.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        ad.e("MicroMsg.JsApiLaunchApplication", "data is null");
        parama.f("fail", null);
        AppMethodBeat.o(8826);
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiLaunchApplication", "paras data error: " + paramString.getMessage());
        paramString = null;
      }
      paramString = paramString.optString("appID");
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.JsApiLaunchApplication", "appid is null or nil");
        parama.f("fail", null);
        AppMethodBeat.o(8826);
        return;
      }
      a.a(paramContext, paramString, new al()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(206777);
          parama.f(null, null);
          AppMethodBeat.o(206777);
        }
      });
      AppMethodBeat.o(8826);
    }
  }
  
  public final void b(b.a parama) {}
  
  public final int ccO()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launchApplication";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.c
 * JD-Core Version:    0.7.0.1
 */