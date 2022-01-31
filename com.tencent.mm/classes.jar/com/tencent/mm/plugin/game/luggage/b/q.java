package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class q
  extends bi<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    int i = 0;
    AppMethodBeat.i(135883);
    ab.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "invokeInOwn");
    String str1 = parama.byF.bxK.optString("url");
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url is null");
      parama.a("fail", null);
      AppMethodBeat.o(135883);
      return;
    }
    ab.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url: %s", new Object[] { str1 });
    String str2 = parama.byF.bxK.optString("statusBarColor");
    if (!bo.isNullOrNil(str2)) {}
    try
    {
      i = Color.parseColor(str2);
      str2 = parama.byF.bxK.optString("statusBarStyle");
      Bundle localBundle = new Bundle();
      localBundle.putString("rawUrl", str1);
      localBundle.putInt("customize_status_bar_color", i);
      localBundle.putString("status_bar_style", str2);
      al.d(new q.1(this, parama, str1, localBundle));
      parama.a("", null);
      AppMethodBeat.o(135883);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ab.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", localIllegalArgumentException.getMessage());
      parama.a("invalid_color", null);
      AppMethodBeat.o(135883);
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameUrlWithExtraWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.q
 * JD-Core Version:    0.7.0.1
 */