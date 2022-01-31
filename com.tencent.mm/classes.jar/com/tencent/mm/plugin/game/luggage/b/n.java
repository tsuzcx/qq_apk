package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.game.luggage.g;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class n
  extends ax<d>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiSetGameData", "invokeInMM");
    paramContext = g.EH(paramString);
    if (paramContext == null)
    {
      y.e("MicroMsg.JsApiSetGameData", "data is null");
      parama.e("null_data", null);
      return;
    }
    paramString = paramContext.optString("preVerifyAppId");
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.JsApiSetGameData", "appId is null");
      parama.e("appid_null", null);
      return;
    }
    String str1 = paramContext.optString("key");
    String str2 = paramContext.optString("value");
    String str3 = paramContext.optString("weight", "1");
    String str4 = paramContext.optString("expireTime");
    boolean bool = paramContext.optBoolean("autoClean", true);
    if ((bk.bl(str1)) || (bk.bl(str2)))
    {
      y.i("MicroMsg.JsApiSetGameData", "key or value is null");
      parama.e("null_key", null);
      return;
    }
    if (b.cav().a(paramString, str1, str2, str3, str4, bool))
    {
      parama.e(null, null);
      return;
    }
    parama.e("exceed_size", null);
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(a<d>.a parama) {}
  
  public final String name()
  {
    return "setGameData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */