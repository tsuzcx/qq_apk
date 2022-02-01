package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class r
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(83083);
    ad.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "invokeInOwn");
    final String str = parama.bZV.bZb.optString("url");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url is null");
      parama.a("fail", null);
      AppMethodBeat.o(83083);
      return;
    }
    ad.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url: %s", new Object[] { str });
    Object localObject = Uri.parse(str);
    if ((bt.nullAsNil(((Uri)localObject).getQueryParameter("not_in_game_luggage")).equals("1")) || ((((Uri)localObject).getHost() != null) && (!((Uri)localObject).getHost().equals("game.weixin.qq.com"))))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", str);
      d.b(((f)parama.bZU).mContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      parama.a("", null);
      AppMethodBeat.o(83083);
      return;
    }
    localObject = parama.bZV.bZb.optString("statusBarColor");
    if (!bt.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      try
      {
        i = Color.parseColor((String)localObject);
        localObject = parama.bZV.bZb.optString("statusBarStyle");
        final Bundle localBundle = new Bundle();
        localBundle.putString("rawUrl", str);
        localBundle.putInt("customize_status_bar_color", i);
        localBundle.putString("status_bar_style", (String)localObject);
        localBundle.putBoolean("from_find_more_friend", ((f)parama.bZU).mParams.getBoolean("from_find_more_friend", false));
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(83082);
            ((f)parama.bZU).bZZ.Bb().h(str, localBundle);
            AppMethodBeat.o(83082);
          }
        });
        parama.a("", null);
        AppMethodBeat.o(83083);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ad.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", localIllegalArgumentException.getMessage());
        parama.a("invalid_color", null);
        AppMethodBeat.o(83083);
        return;
      }
      int i = 0;
    }
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameUrlWithExtraWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.r
 * JD-Core Version:    0.7.0.1
 */