package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.game.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends ax<d>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiClearGameData", "invokeInMM");
    paramContext = g.EH(paramString);
    if (paramContext == null)
    {
      y.e("MicroMsg.JsApiClearGameData", "data is null");
      parama.e("null_data", null);
      return;
    }
    paramString = paramContext.optString("preVerifyAppId");
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.JsApiClearGameData", "appId is null");
      parama.e("appid_null", null);
      return;
    }
    JSONArray localJSONArray = paramContext.optJSONArray("keys");
    boolean bool = paramContext.optBoolean("clearAllData", false);
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      com.tencent.mm.plugin.webview.b.b.cav().b(paramString, localJSONArray);
      parama.e(null, null);
      return;
    }
    if (bool)
    {
      com.tencent.mm.plugin.webview.b.b.cav().RG(paramString);
      parama.e(null, null);
      return;
    }
    y.i("MicroMsg.JsApiClearGameData", "keys is null");
    parama.e("fail", null);
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(a<d>.a parama) {}
  
  public final String name()
  {
    return "clearGameData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */