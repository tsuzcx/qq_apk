package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.i.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends bn
{
  public final void a(Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(8826);
    ac.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        ac.e("MicroMsg.JsApiLaunchApplication", "data is null");
        parama.f("fail", null);
        AppMethodBeat.o(8826);
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.JsApiLaunchApplication", "paras data error: " + paramString.getMessage());
        paramString = null;
      }
      paramString = paramString.optString("appID");
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.JsApiLaunchApplication", "appid is null or nil");
        parama.f("fail", null);
        AppMethodBeat.o(8826);
        return;
      }
      a.a(paramContext, paramString, new am()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(195681);
          parama.f(null, null);
          AppMethodBeat.o(195681);
        }
      });
      AppMethodBeat.o(8826);
    }
  }
  
  public final void b(a.a parama) {}
  
  public final int bYk()
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