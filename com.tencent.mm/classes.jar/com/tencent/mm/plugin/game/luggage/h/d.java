package com.tencent.mm.plugin.game.luggage.h;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private String IxN;
  
  public d(String paramString)
  {
    this.IxN = paramString;
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString)
  {
    AppMethodBeat.i(276975);
    if (paramString == null)
    {
      AppMethodBeat.o(276975);
      return;
    }
    f localf;
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("params");
      paramString = new g(this.IxN, paramString);
      if (a.fFa() == null) {
        break label156;
      }
      localf = a.fFa().Ixx;
      Log.i("MicroMsg.Page2JsCoreMsgDispatch", "evaluateMessage, hasDestroyed = %b, hasReady = %b", new Object[] { Boolean.valueOf(localf.IxR), Boolean.valueOf(localf.IxQ) });
      if (localf.IxR) {
        break label156;
      }
      if (!localf.IxQ)
      {
        localf.IxT.add(paramString);
        AppMethodBeat.o(276975);
        return;
      }
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(276975);
      return;
    }
    localf.Ixy.evaluateJavascript(String.format("WxGameJsCoreBridge.invokeEvent(%s,\"%s\")", new Object[] { paramString.rmi.toString(), paramString.hUf }), null);
    label156:
    AppMethodBeat.o(276975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.d
 * JD-Core Version:    0.7.0.1
 */