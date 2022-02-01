package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.webview.luggage.c.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends br
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(231015);
    if (a.gVm())
    {
      Log.i("MicroMsg.JsApiDownloadGameResource", "downloadGameResource isTeenMode and ignore");
      a.ja(paramContext);
      parama.i("cancel", null);
      AppMethodBeat.o(231015);
      return;
    }
    try
    {
      paramContext = new JSONObject(paramString);
      paramContext = paramContext.optString("appId", "");
      com.tencent.mm.plugin.game.api.b.a.evu().aIK(paramContext);
      parama.i(null, null);
      AppMethodBeat.o(231015);
      return;
    }
    catch (JSONException paramContext)
    {
      parama.i("fail", null);
      AppMethodBeat.o(231015);
    }
  }
  
  public final void b(com.tencent.luggage.d.b.a parama) {}
  
  public final int cDj()
  {
    return 2;
  }
  
  public final String name()
  {
    return "downloadGameResource";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */