package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends bn
{
  public final void a(Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(83052);
    try
    {
      paramString = new JSONObject(paramString);
      o.a(paramContext, a.ao(paramString), new o.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(83051);
          parama.f(paramAnonymousString, paramAnonymousJSONObject);
          AppMethodBeat.o(83051);
        }
      });
      AppMethodBeat.o(83052);
      return;
    }
    catch (JSONException paramContext)
    {
      parama.f("fail", null);
      AppMethodBeat.o(83052);
    }
  }
  
  public final void b(a.a parama) {}
  
  public final int bYk()
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