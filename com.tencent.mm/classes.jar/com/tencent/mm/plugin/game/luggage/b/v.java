package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import org.json.JSONObject;

public class v
  extends bq
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(83083);
    ad.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "invokeInOwn");
    final String str1 = parama.chh.cgn.optString("url");
    if (bt.isNullOrNil(str1))
    {
      ad.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url is null");
      parama.a("fail", null);
      AppMethodBeat.o(83083);
      return;
    }
    ad.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url: %s", new Object[] { str1 });
    Object localObject1 = (s)com.tencent.mm.plugin.webview.luggage.j.ePw().getLast();
    if (localObject1 == null)
    {
      AppMethodBeat.o(83083);
      return;
    }
    String str2 = parama.chh.cgn.optString("html");
    Object localObject2 = Uri.parse(str1);
    if ((bt.nullAsNil(((Uri)localObject2).getQueryParameter("not_in_game_luggage")).equals("1")) || ((((Uri)localObject2).getHost() != null) && (!((Uri)localObject2).getHost().equals("game.weixin.qq.com"))))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", str1);
      d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      parama.a("", null);
      AppMethodBeat.o(83083);
      return;
    }
    localObject2 = parama.chh.cgn.optString("statusBarColor");
    if (!bt.isNullOrNil((String)localObject2)) {}
    for (;;)
    {
      try
      {
        i = Color.parseColor((String)localObject2);
        localObject2 = parama.chh.cgn.optString("statusBarStyle");
        final Bundle localBundle = new Bundle();
        localBundle.putString("rawUrl", str1);
        localBundle.putInt("customize_status_bar_color", i);
        localBundle.putString("status_bar_style", (String)localObject2);
        localBundle.putBoolean("from_find_more_friend", ((s)localObject1).mParams.getBoolean("from_find_more_friend", false));
        if (!bt.isNullOrNil(str2)) {
          localBundle.putString("game_open_html", str2);
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(83082);
            this.tUc.chm.Ce().h(str1, localBundle);
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
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameUrlWithExtraWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.v
 * JD-Core Version:    0.7.0.1
 */