package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.LuggageGameHalfWebViewUI;
import com.tencent.mm.plugin.game.luggage.j.f;
import com.tencent.mm.plugin.lite.api.c.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.LinkedList;
import org.json.JSONObject;

public class ad
  extends bv
{
  private void c(b.a parama)
  {
    AppMethodBeat.i(277170);
    Object localObject1 = parama.eiZ.eif.optString("url");
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url is null");
      parama.a("fail", null);
      AppMethodBeat.o(277170);
      return;
    }
    Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url: %s", new Object[] { localObject1 });
    Object localObject2 = (s)com.tencent.mm.plugin.webview.luggage.k.iuB().getLast();
    if (localObject2 == null)
    {
      AppMethodBeat.o(277170);
      return;
    }
    String str1 = parama.eiZ.eif.optString("html");
    Object localObject3 = Uri.parse((String)localObject1);
    if ((Util.nullAsNil(((Uri)localObject3).getQueryParameter("not_in_game_luggage")).equals("1")) || ((((Uri)localObject3).getHost() != null) && (!((Uri)localObject3).getHost().equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com)))))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      parama.a("", null);
      AppMethodBeat.o(277170);
      return;
    }
    localObject3 = parama.eiZ.eif.optString("statusBarColor");
    if (!Util.isNullOrNil((String)localObject3)) {}
    for (;;)
    {
      try
      {
        i = Color.parseColor((String)localObject3);
        String str2 = parama.eiZ.eif.optString("statusBarStyle");
        String str3 = parama.eiZ.eif.optString("preInjectData");
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("rawUrl", (String)localObject1);
        ((Bundle)localObject3).putInt("customize_status_bar_color", i);
        ((Bundle)localObject3).putString("status_bar_style", str2);
        ((Bundle)localObject3).putString("game_pre_inject_data", str3);
        ((Bundle)localObject3).putBoolean("from_find_more_friend", ((s)localObject2).ejT.getBoolean("from_find_more_friend", false));
        if (!Util.isNullOrNil(str1)) {
          ((Bundle)localObject3).putString("game_open_html", str1);
        }
        if ((((com.tencent.luggage.d.h)localObject2).mContext instanceof LuggageGameHalfWebViewUI))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras((Bundle)localObject3);
          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          parama.a("", null);
          AppMethodBeat.o(277170);
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", localIllegalArgumentException.getMessage());
        parama.a("invalid_color", null);
        AppMethodBeat.o(277170);
        return;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(277127);
          this.IuZ.eje.aow().m(localIllegalArgumentException, this.val$bundle);
          AppMethodBeat.o(277127);
        }
      });
      continue;
      int i = 0;
    }
  }
  
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b.a parama)
  {
    AppMethodBeat.i(83083);
    Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "invokeInOwn");
    Object localObject = parama.eiZ.eif.optJSONObject("liteAppInfo");
    if (localObject != null)
    {
      Context localContext = MMApplicationContext.getContext();
      parama = new c.a()
      {
        public final void csx()
        {
          AppMethodBeat.i(277121);
          Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openLiteApp success");
          parama.a("", null);
          String str = d.boB(parama.eiZ.eif.optString("url"));
          if (!Util.isNullOrNil(str))
          {
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(str);
            WepkgVersionUpdater.Y(localLinkedList, 4);
          }
          AppMethodBeat.o(277121);
        }
        
        public final void csy()
        {
          AppMethodBeat.i(277124);
          ad.a(ad.this, parama);
          AppMethodBeat.o(277124);
        }
      };
      if (localObject == null)
      {
        parama.csy();
        AppMethodBeat.o(83083);
        return;
      }
      String str1 = ((JSONObject)localObject).optString("appId");
      if (Util.isNullOrNil(str1))
      {
        Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openInLiteApp appId is null");
        parama.csy();
        AppMethodBeat.o(83083);
        return;
      }
      if (((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).et(str1) == null)
      {
        Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openInLiteApp");
        parama.csy();
        AppMethodBeat.o(83083);
        return;
      }
      String str2 = ((JSONObject)localObject).optString("path");
      localObject = ((JSONObject)localObject).optString("query");
      Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openInLiteApp, appId : %s, path : %s, query : %s", new Object[] { str1, str2, localObject });
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", str1);
      localBundle.putString("path", str2);
      localBundle.putString("query", (String)localObject);
      ((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).a(localContext, localBundle, false, true, parama);
      AppMethodBeat.o(83083);
      return;
    }
    c(parama);
    AppMethodBeat.o(83083);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameUrlWithExtraWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ad
 * JD-Core Version:    0.7.0.1
 */