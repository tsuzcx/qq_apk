package com.tencent.mm.plugin.game.luggage.h;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private String uhh;
  
  public d(String paramString)
  {
    this.uhh = paramString;
  }
  
  @JavascriptInterface
  public final void postMessage(String paramString)
  {
    AppMethodBeat.i(193112);
    if (paramString == null)
    {
      AppMethodBeat.o(193112);
      return;
    }
    f localf;
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("params");
      paramString = new g(this.uhh, paramString);
      if (a.dao() == null) {
        break label156;
      }
      localf = a.dao().ugS;
      ae.i("MicroMsg.Page2JsCoreMsgDispatch", "evaluateMessage, hasDestroyed = %b, hasReady = %b", new Object[] { Boolean.valueOf(localf.uhn), Boolean.valueOf(localf.uhm) });
      if (localf.uhn) {
        break label156;
      }
      if (!localf.uhm)
      {
        localf.uhp.add(paramString);
        AppMethodBeat.o(193112);
        return;
      }
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(193112);
      return;
    }
    localf.ugT.evaluateJavascript(String.format("WxGameJsCoreBridge.invokeEvent(%s,\"%s\")", new Object[] { paramString.kkm.toString(), paramString.pageId }), null);
    label156:
    AppMethodBeat.o(193112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.d
 * JD-Core Version:    0.7.0.1
 */