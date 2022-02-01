package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rh;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class z
  extends bv<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(83079);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Log.i("MicroMsg.JsApiOpenGameCenter", "JsonData = %s", new Object[] { paramString });
      paramString = new rh();
      paramString.hUs.hUt = localJSONObject;
      paramString.hUs.context = paramContext;
      paramString.publish();
      parama.j(null, null);
      AppMethodBeat.o(83079);
      return;
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiOpenGameCenter", "json parse exception");
      parama.j("fail", null);
      AppMethodBeat.o(83079);
    }
  }
  
  public final void b(b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openGameCenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.z
 * JD-Core Version:    0.7.0.1
 */