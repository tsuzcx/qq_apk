package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.a.c;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends bq
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(8835);
    ad.i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      l = paramString.optLong("download_id");
      if (l <= 0L)
      {
        ad.e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
        parama.f("invalid_downloadid", null);
        AppMethodBeat.o(8835);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ad.e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.f("fail", null);
      AppMethodBeat.o(8835);
      return;
    }
    paramString = d.ua(l);
    if (paramString != null)
    {
      b localb = new b();
      localb.k(paramString);
      localb.msQ = 0L;
      a.a(10, localb);
    }
    c.a(paramContext, paramString, null, new a.b()
    {
      public final void a(a.a paramAnonymousa, long paramAnonymousLong)
      {
        AppMethodBeat.i(8834);
        if (paramAnonymousa == a.a.pnV)
        {
          parama.f(null, null);
          AppMethodBeat.o(8834);
          return;
        }
        if (paramAnonymousa == a.a.pnW)
        {
          parama.f("fail", null);
          AppMethodBeat.o(8834);
          return;
        }
        if (paramAnonymousa == a.a.pnX) {
          parama.f("wait_for_wifi", null);
        }
        AppMethodBeat.o(8834);
      }
    });
    AppMethodBeat.o(8835);
  }
  
  public final void b(b.a parama) {}
  
  public final int ccO()
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