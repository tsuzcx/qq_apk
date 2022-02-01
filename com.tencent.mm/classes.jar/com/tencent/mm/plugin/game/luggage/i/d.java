package com.tencent.mm.plugin.game.luggage.i;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private String CDI;
  
  public d(String paramString)
  {
    this.CDI = paramString;
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString)
  {
    AppMethodBeat.i(231399);
    if (paramString == null)
    {
      AppMethodBeat.o(231399);
      return;
    }
    f localf;
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("params");
      paramString = new g(this.CDI, paramString);
      if (a.exd() == null) {
        break label156;
      }
      localf = a.exd().CDs;
      Log.i("MicroMsg.Page2JsCoreMsgDispatch", "evaluateMessage, hasDestroyed = %b, hasReady = %b", new Object[] { Boolean.valueOf(localf.CDM), Boolean.valueOf(localf.CDL) });
      if (localf.CDM) {
        break label156;
      }
      if (!localf.CDL)
      {
        localf.CDO.add(paramString);
        AppMethodBeat.o(231399);
        return;
      }
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(231399);
      return;
    }
    localf.CDt.evaluateJavascript(String.format("WxGameJsCoreBridge.invokeEvent(%s,\"%s\")", new Object[] { paramString.oiG.toString(), paramString.pageId }), null);
    label156:
    AppMethodBeat.o(231399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i.d
 * JD-Core Version:    0.7.0.1
 */