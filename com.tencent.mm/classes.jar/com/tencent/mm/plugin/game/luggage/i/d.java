package com.tencent.mm.plugin.game.luggage.i;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private String xzD;
  
  public d(String paramString)
  {
    this.xzD = paramString;
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString)
  {
    AppMethodBeat.i(187012);
    if (paramString == null)
    {
      AppMethodBeat.o(187012);
      return;
    }
    f localf;
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("params");
      paramString = new g(this.xzD, paramString);
      if (a.dTW() == null) {
        break label156;
      }
      localf = a.dTW().xzn;
      Log.i("MicroMsg.Page2JsCoreMsgDispatch", "evaluateMessage, hasDestroyed = %b, hasReady = %b", new Object[] { Boolean.valueOf(localf.xzH), Boolean.valueOf(localf.xzG) });
      if (localf.xzH) {
        break label156;
      }
      if (!localf.xzG)
      {
        localf.xzJ.add(paramString);
        AppMethodBeat.o(187012);
        return;
      }
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(187012);
      return;
    }
    localf.xzo.evaluateJavascript(String.format("WxGameJsCoreBridge.invokeEvent(%s,\"%s\")", new Object[] { paramString.lnV.toString(), paramString.pageId }), null);
    label156:
    AppMethodBeat.o(187012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i.d
 * JD-Core Version:    0.7.0.1
 */