package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.a.c;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends bn
{
  public final void a(Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(8835);
    ac.i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      l = paramString.optLong("download_id");
      if (l <= 0L)
      {
        ac.e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
        parama.f("invalid_downloadid", null);
        AppMethodBeat.o(8835);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ac.e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.f("fail", null);
      AppMethodBeat.o(8835);
      return;
    }
    paramString = d.sc(l);
    if (paramString != null)
    {
      b localb = new b();
      localb.k(paramString);
      localb.lTa = 0L;
      a.a(10, localb);
    }
    c.a(paramContext, paramString, null, new a.b()
    {
      public final void a(com.tencent.mm.plugin.downloader_app.api.a.a paramAnonymousa, long paramAnonymousLong)
      {
        AppMethodBeat.i(8834);
        if (paramAnonymousa == com.tencent.mm.plugin.downloader_app.api.a.a.oKo)
        {
          parama.f(null, null);
          AppMethodBeat.o(8834);
          return;
        }
        if (paramAnonymousa == com.tencent.mm.plugin.downloader_app.api.a.a.oKp)
        {
          parama.f("fail", null);
          AppMethodBeat.o(8834);
          return;
        }
        if (paramAnonymousa == com.tencent.mm.plugin.downloader_app.api.a.a.oKq) {
          parama.f("wait_for_wifi", null);
        }
        AppMethodBeat.o(8834);
      }
    });
    AppMethodBeat.o(8835);
  }
  
  public final void b(com.tencent.luggage.d.a.a parama) {}
  
  public final int bYk()
  {
    return 2;
  }
  
  public final String name()
  {
    return "resumeDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.g
 * JD-Core Version:    0.7.0.1
 */