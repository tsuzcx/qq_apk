package com.tencent.mm.plugin.game.luggage.h;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.j;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  @JavascriptInterface
  public final void postMessage(String paramString)
  {
    AppMethodBeat.i(193111);
    if (paramString == null)
    {
      AppMethodBeat.o(193111);
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("pageId");
      localObject = ((JSONObject)localObject).optJSONObject("params");
      paramString = j.aIq(paramString);
      localObject = String.format("javascript:WxGameJsCoreBridge.invokeEvent(%s)", new Object[] { ((JSONObject)localObject).toString() });
      ae.i("MicroMsg.GameV8JsInterface", "postMessage, js = %s", new Object[] { localObject });
      paramString.chX.cC((String)localObject);
      AppMethodBeat.o(193111);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(193111);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.c
 * JD-Core Version:    0.7.0.1
 */