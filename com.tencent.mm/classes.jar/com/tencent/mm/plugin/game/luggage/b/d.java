package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.mm.plugin.game.luggage.g;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends ax<com.tencent.mm.plugin.game.luggage.d>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiGetGameData", "invokeInMM");
    paramString = g.EH(paramString);
    if (paramString == null)
    {
      y.e("MicroMsg.JsApiGetGameData", "data is null");
      parama.e("null_data", null);
      return;
    }
    paramContext = paramString.optString("preVerifyAppId");
    if (bk.bl(paramContext))
    {
      y.i("MicroMsg.JsApiGetGameData", "appId is null");
      parama.e("appid_null", null);
      return;
    }
    paramString = paramString.optString("key");
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.JsApiGetGameData", "key is null");
      parama.e("null_key", null);
      return;
    }
    paramString = b.cav().fr(paramContext, paramString);
    if (!bk.bl(paramString.field_value)) {
      paramContext = new JSONObject();
    }
    try
    {
      paramContext.put("value", paramString.field_value);
      paramContext.put("weight", paramString.field_weight);
      paramContext.put("expireTime", paramString.field_expireTime - System.currentTimeMillis() / 1000L);
      label157:
      parama.e(null, paramContext);
      return;
      parama.e(null, null);
      return;
    }
    catch (JSONException paramString)
    {
      break label157;
    }
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(com.tencent.luggage.e.a<com.tencent.mm.plugin.game.luggage.d>.a parama) {}
  
  public final String name()
  {
    return "getGameData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */