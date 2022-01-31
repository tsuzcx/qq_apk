package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class j
  extends aw<d>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<d>.a parama)
  {
    int i = 0;
    y.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "invokeInOwn");
    String str1 = parama.bih.bhk.optString("url");
    if (bk.bl(str1))
    {
      y.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url is null");
      parama.a("fail", null);
      return;
    }
    y.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url: %s", new Object[] { str1 });
    String str2 = parama.bih.bhk.optString("statusBarColor");
    if (!bk.bl(str2)) {}
    try
    {
      i = Color.parseColor(str2);
      str2 = parama.bih.bhk.optString("statusBarStyle");
      Bundle localBundle = new Bundle();
      localBundle.putString("rawUrl", str1);
      localBundle.putInt("customize_status_bar_color", i);
      localBundle.putString("status_bar_style", str2);
      ai.d(new j.1(this, str1, parama, localBundle));
      parama.a("", null);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      y.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", localIllegalArgumentException.getMessage());
      parama.a("invalid_color", null);
    }
  }
  
  public final String name()
  {
    return "openGameUrlWithExtraWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */