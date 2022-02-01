package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211658);
    if (!paramJSONObject.has("url"))
    {
      AppMethodBeat.o(211658);
      return;
    }
    try
    {
      paramString = new mz();
      paramString.dAU.type = 2;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramJSONObject.getString("url"));
      localIntent.putExtra("nextAnimIn", ay(paramJSONObject));
      localIntent.putExtra("currentAnimOut", az(paramJSONObject));
      paramString.dAU.intent = localIntent;
      com.tencent.mm.sdk.b.a.IbL.l(paramString);
      AppMethodBeat.o(211658);
      return;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("LiteAppJsApiStartGameWebview", paramString, "get url", new Object[0]);
      AppMethodBeat.o(211658);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.l
 * JD-Core Version:    0.7.0.1
 */