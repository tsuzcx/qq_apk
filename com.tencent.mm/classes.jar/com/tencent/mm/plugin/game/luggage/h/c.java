package com.tencent.mm.plugin.game.luggage.h;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  @JavascriptInterface
  public final void error(String paramString)
  {
    AppMethodBeat.i(276982);
    if (paramString == null)
    {
      AppMethodBeat.o(276982);
      return;
    }
    Log.e("MicroMsg.GameV8JsInterface", "js console error : %s", new Object[] { paramString });
    AppMethodBeat.o(276982);
  }
  
  @JavascriptInterface
  public final void log(String paramString)
  {
    AppMethodBeat.i(276978);
    if (paramString == null)
    {
      AppMethodBeat.o(276978);
      return;
    }
    Log.i("MicroMsg.GameV8JsInterface", "js console log : %s", new Object[] { paramString });
    AppMethodBeat.o(276978);
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString)
  {
    AppMethodBeat.i(276973);
    if (paramString == null)
    {
      AppMethodBeat.o(276973);
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("pageId");
      JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("params");
      localObject = k.bjX(paramString);
      if (localObject == null)
      {
        Log.e("MicroMsg.GameV8JsInterface", "page is null, pageId : %s", new Object[] { paramString });
        AppMethodBeat.o(276973);
        return;
      }
      paramString = String.format("javascript:WxGameJsCoreBridge.invokeEvent(%s)", new Object[] { localJSONObject.toString() });
      Log.i("MicroMsg.GameV8JsInterface", "postMessage, js = %s", new Object[] { paramString });
      ((s)localObject).ejR.eE(paramString);
      AppMethodBeat.o(276973);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(276973);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.c
 * JD-Core Version:    0.7.0.1
 */