package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.mm.h.a.gr;
import com.tencent.mm.h.a.gr.b;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.game.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends aw<d>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiGetGameCommInfo", "invoke");
    paramString = g.EH(paramString);
    if (paramString == null)
    {
      y.e("MicroMsg.JsApiGetGameCommInfo", "data is null");
      parama.e("invalid_data", null);
      return;
    }
    int i = paramString.optInt("cmd", 0);
    paramString = paramString.optString("param");
    if (i == 10002) {
      paramContext = new JSONObject();
    }
    try
    {
      paramContext.put("webpageCount", 1);
      label71:
      parama.e(null, paramContext);
      return;
      gr localgr = new gr();
      localgr.bOv.uC = i;
      localgr.bOv.bOx = paramString;
      localgr.bOv.context = paramContext;
      com.tencent.mm.sdk.b.a.udP.m(localgr);
      try
      {
        parama.e(null, new JSONObject(localgr.bOw.result));
        return;
      }
      catch (JSONException paramContext)
      {
        parama.e(null, null);
        return;
      }
    }
    catch (JSONException paramString)
    {
      break label71;
    }
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(com.tencent.luggage.e.a<d>.a parama) {}
  
  public final String name()
  {
    return "getGameCommInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */