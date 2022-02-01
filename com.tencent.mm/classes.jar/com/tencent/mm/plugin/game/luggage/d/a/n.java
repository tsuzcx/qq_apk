package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.oo;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class n
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(231425);
    if (!paramJSONObject.has("url"))
    {
      AppMethodBeat.o(231425);
      return;
    }
    try
    {
      paramString = new oo();
      paramString.fNq.type = 2;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramJSONObject.getString("url"));
      localIntent.putExtra("nextAnimIn", bb(paramJSONObject));
      localIntent.putExtra("currentAnimOut", bc(paramJSONObject));
      paramString.fNq.intent = localIntent;
      EventCenter.instance.publish(paramString);
      AppMethodBeat.o(231425);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("LiteAppJsApiStartGameWebview", paramString, "get url", new Object[0]);
      AppMethodBeat.o(231425);
    }
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.n
 * JD-Core Version:    0.7.0.1
 */