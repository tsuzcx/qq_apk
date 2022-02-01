package com.tencent.mm.plugin.lite.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public class LiteAppJsApiStartGameWebview
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public static final String NAME = "startGameWebview";
  public static final String NAME1 = "startGameWebView";
  private static final String TAG = "LiteAppJsApiStartGameWebview";
  private static final String URL = "url";
  
  public void invoke(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(205697);
    if (!paramJSONObject.has("url"))
    {
      AppMethodBeat.o(205697);
      return;
    }
    try
    {
      paramString = new mr();
      paramString.dph.type = 2;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramJSONObject.getString("url"));
      localIntent.putExtra("nextAnimIn", getAnimIn(paramJSONObject));
      localIntent.putExtra("currentAnimOut", getAnimOut(paramJSONObject));
      paramString.dph.intent = localIntent;
      com.tencent.mm.sdk.b.a.GpY.l(paramString);
      AppMethodBeat.o(205697);
      return;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("LiteAppJsApiStartGameWebview", paramString, "get url", new Object[0]);
      AppMethodBeat.o(205697);
    }
  }
  
  public int runModel()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.game.LiteAppJsApiStartGameWebview
 * JD-Core Version:    0.7.0.1
 */