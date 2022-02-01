package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186927);
    if (!paramJSONObject.has("url"))
    {
      AppMethodBeat.o(186927);
      return;
    }
    try
    {
      paramString = new nr();
      paramString.dTO.type = 2;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramJSONObject.getString("url"));
      localIntent.putExtra("nextAnimIn", aU(paramJSONObject));
      localIntent.putExtra("currentAnimOut", aV(paramJSONObject));
      paramString.dTO.intent = localIntent;
      EventCenter.instance.publish(paramString);
      AppMethodBeat.o(186927);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("LiteAppJsApiStartGameWebview", paramString, "get url", new Object[0]);
      AppMethodBeat.o(186927);
    }
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.l
 * JD-Core Version:    0.7.0.1
 */