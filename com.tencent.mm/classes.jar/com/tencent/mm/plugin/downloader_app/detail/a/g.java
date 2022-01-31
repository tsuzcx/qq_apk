package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends bh
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(136080);
    ab.i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      l = paramString.optLong("download_id");
      if (l <= 0L)
      {
        ab.e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
        parama.c("invalid_downloadid", null);
        AppMethodBeat.o(136080);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.c("fail", null);
      AppMethodBeat.o(136080);
      return;
    }
    paramString = d.iJ(l);
    if (paramString != null)
    {
      b localb = new b();
      localb.i(paramString);
      localb.iHc = 0L;
      a.a(10, localb);
    }
    c.a(paramContext, paramString, null, new g.1(this, parama));
    AppMethodBeat.o(136080);
  }
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "resumeDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.g
 * JD-Core Version:    0.7.0.1
 */