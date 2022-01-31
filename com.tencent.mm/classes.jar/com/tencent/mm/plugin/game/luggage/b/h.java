package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gv.b;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends bh<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(135871);
    ab.i("MicroMsg.JsApiGetGameCommInfo", "invoke");
    paramString = i.ci(paramString);
    if (paramString == null)
    {
      ab.e("MicroMsg.JsApiGetGameCommInfo", "data is null");
      parama.c("invalid_data", null);
      AppMethodBeat.o(135871);
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
      label81:
      parama.c(null, paramContext);
      AppMethodBeat.o(135871);
      return;
      gv localgv = new gv();
      localgv.cvM.vA = i;
      localgv.cvM.cvO = paramString;
      localgv.cvM.context = paramContext;
      com.tencent.mm.sdk.b.a.ymk.l(localgv);
      try
      {
        parama.c(null, new JSONObject(localgv.cvN.result));
        AppMethodBeat.o(135871);
        return;
      }
      catch (JSONException paramContext)
      {
        parama.c(null, null);
        AppMethodBeat.o(135871);
        return;
      }
    }
    catch (JSONException paramString)
    {
      break label81;
    }
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getGameCommInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */