package com.tencent.mm.plugin.game.luggage.h;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private String tWj;
  
  public d(String paramString)
  {
    this.tWj = paramString;
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString)
  {
    AppMethodBeat.i(211713);
    if (paramString == null)
    {
      AppMethodBeat.o(211713);
      return;
    }
    f localf;
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("params");
      paramString = new g(this.tWj, paramString);
      if (a.cXE() == null) {
        break label156;
      }
      localf = a.cXE().tVU;
      ad.i("MicroMsg.Page2JsCoreMsgDispatch", "evaluateMessage, hasDestroyed = %b, hasReady = %b", new Object[] { Boolean.valueOf(localf.tWp), Boolean.valueOf(localf.tWo) });
      if (localf.tWp) {
        break label156;
      }
      if (!localf.tWo)
      {
        localf.tWr.add(paramString);
        AppMethodBeat.o(211713);
        return;
      }
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(211713);
      return;
    }
    localf.tVV.evaluateJavascript(String.format("WxGameJsCoreBridge.invokeEvent(%s,\"%s\")", new Object[] { paramString.kgW.toString(), paramString.pageId }), null);
    label156:
    AppMethodBeat.o(211713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.d
 * JD-Core Version:    0.7.0.1
 */