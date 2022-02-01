package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.webview.luggage.c.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends bv
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(277140);
    if (a.iuX())
    {
      Log.i("MicroMsg.JsApiDownloadGameResource", "downloadGameResource isTeenMode and ignore");
      a.kQ(paramContext);
      parama.j("cancel", null);
      AppMethodBeat.o(277140);
      return;
    }
    try
    {
      paramContext = new JSONObject(paramString);
      paramContext = paramContext.optString("appId", "");
      com.tencent.mm.plugin.game.api.b.a.fCn().aFk(paramContext);
      parama.j(null, null);
      AppMethodBeat.o(277140);
      return;
    }
    catch (JSONException paramContext)
    {
      parama.j("fail", null);
      AppMethodBeat.o(277140);
    }
  }
  
  public final void b(com.tencent.luggage.d.b.a parama) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "downloadGameResource";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */