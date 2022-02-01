package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends br
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(186856);
    try
    {
      paramContext = new JSONObject(paramString);
      paramContext = paramContext.optString("appId", "");
      com.tencent.mm.plugin.game.api.b.a.dSQ().azk(paramContext);
      parama.i(null, null);
      AppMethodBeat.o(186856);
      return;
    }
    catch (JSONException paramContext)
    {
      parama.i("fail", null);
      AppMethodBeat.o(186856);
    }
  }
  
  public final void b(com.tencent.luggage.d.b.a parama) {}
  
  public final int dTs()
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