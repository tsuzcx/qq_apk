package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.py;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.lite.api.c;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class n
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277053);
    if (!paramJSONObject.has("url"))
    {
      AppMethodBeat.o(277053);
      return;
    }
    try
    {
      paramString = new py();
      paramString.hTd.type = 2;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramJSONObject.getString("url"));
      localIntent.putExtra("nextAnimIn", ((c)h.ax(c.class)).bo(paramJSONObject));
      localIntent.putExtra("currentAnimOut", ((c)h.ax(c.class)).bp(paramJSONObject));
      if (paramJSONObject.has("extraInfo")) {
        localIntent.putExtra("game_liteapp_pass_data", paramJSONObject.getJSONObject("extraInfo").toString());
      }
      paramString.hTd.intent = localIntent;
      paramString.publish();
      AppMethodBeat.o(277053);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("LiteAppJsApiStartGameWebview", paramString, "get url", new Object[0]);
      AppMethodBeat.o(277053);
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.n
 * JD-Core Version:    0.7.0.1
 */