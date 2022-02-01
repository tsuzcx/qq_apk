package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pu;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class v
  extends br<i>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(83079);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Log.i("MicroMsg.JsApiOpenGameCenter", "JsonData = %s", new Object[] { paramString });
      paramString = new pu();
      paramString.fOz.fOA = localJSONObject;
      paramString.fOz.context = paramContext;
      EventCenter.instance.publish(paramString);
      parama.i(null, null);
      AppMethodBeat.o(83079);
      return;
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiOpenGameCenter", "json parse exception");
      parama.i("fail", null);
      AppMethodBeat.o(83079);
    }
  }
  
  public final void b(b<i>.a paramb) {}
  
  public final int cDj()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openGameCenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.v
 * JD-Core Version:    0.7.0.1
 */