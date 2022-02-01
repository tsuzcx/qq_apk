package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.na;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193047);
    if (!paramJSONObject.has("url"))
    {
      AppMethodBeat.o(193047);
      return;
    }
    try
    {
      paramString = new na();
      paramString.dBZ.type = 2;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramJSONObject.getString("url"));
      localIntent.putExtra("nextAnimIn", ay(paramJSONObject));
      localIntent.putExtra("currentAnimOut", az(paramJSONObject));
      paramString.dBZ.intent = localIntent;
      com.tencent.mm.sdk.b.a.IvT.l(paramString);
      AppMethodBeat.o(193047);
      return;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("LiteAppJsApiStartGameWebview", paramString, "get url", new Object[0]);
      AppMethodBeat.o(193047);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.l
 * JD-Core Version:    0.7.0.1
 */