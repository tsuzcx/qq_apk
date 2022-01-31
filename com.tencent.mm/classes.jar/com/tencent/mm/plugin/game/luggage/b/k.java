package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.mm.h.a.gu;
import com.tencent.mm.h.a.gu.b;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.game.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends aw<d>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiOperateGameCenterMsg", "invokeInMM");
    paramContext = g.EH(paramString);
    if (paramContext == null)
    {
      y.i("MicroMsg.JsApiOperateGameCenterMsg", "data is null");
      parama.e("invalid_data", null);
      return;
    }
    int i = paramContext.optInt("cmd");
    paramString = paramContext.optJSONObject("param");
    paramContext = new gu();
    paramContext.bOC.uC = i;
    paramContext.bOC.bOx = paramString.toString();
    com.tencent.mm.sdk.b.a.udP.m(paramContext);
    paramString = new JSONObject();
    try
    {
      paramString.put("result", bk.pm(paramContext.bOD.bOE));
      label107:
      parama.e(null, paramString);
      return;
    }
    catch (JSONException paramContext)
    {
      break label107;
    }
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(com.tencent.luggage.e.a<d>.a parama) {}
  
  public final String name()
  {
    return "operateGameCenterMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */