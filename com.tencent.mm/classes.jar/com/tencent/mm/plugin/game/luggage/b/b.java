package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends bh
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(135867);
    try
    {
      paramString = new JSONObject(paramString);
      o.a(paramContext, a.Y(paramString), new b.1(this, parama));
      AppMethodBeat.o(135867);
      return;
    }
    catch (JSONException paramContext)
    {
      parama.c("fail", null);
      AppMethodBeat.o(135867);
    }
  }
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "addGameDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */