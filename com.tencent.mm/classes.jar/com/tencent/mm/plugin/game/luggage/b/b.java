package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends br
{
  public final void a(Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(83052);
    if (com.tencent.mm.plugin.webview.luggage.c.a.gVm())
    {
      Log.i("MicroMsg.JsApiAddGameDownloadTask", "addGameDownloadTask isTeenMode and ignore");
      com.tencent.mm.plugin.webview.luggage.c.a.ja(paramContext);
      parama.i("cancel", null);
      AppMethodBeat.o(83052);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      o.a(paramContext, com.tencent.mm.plugin.downloader_app.a.a.aO(paramString), new o.a()
      {
        public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(83051);
          parama.i(paramAnonymousString, paramAnonymousJSONObject);
          AppMethodBeat.o(83051);
        }
      });
      AppMethodBeat.o(83052);
      return;
    }
    catch (JSONException paramContext)
    {
      parama.i("fail", null);
      AppMethodBeat.o(83052);
    }
  }
  
  public final void b(b.a parama) {}
  
  public final int cDj()
  {
    return 2;
  }
  
  public final String name()
  {
    return "addGameDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */