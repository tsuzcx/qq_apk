package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.game.luggage.LuggageGameHalfWebViewUI;
import com.tencent.mm.plugin.game.luggage.j.f;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.LinkedList;
import org.json.JSONObject;

public class z
  extends br
{
  private void c(b.a parama)
  {
    AppMethodBeat.i(231885);
    Object localObject1 = parama.crh.cqn.optString("url");
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url is null");
      parama.a("fail", null);
      AppMethodBeat.o(231885);
      return;
    }
    Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url: %s", new Object[] { localObject1 });
    Object localObject2 = (s)com.tencent.mm.plugin.webview.luggage.j.gUQ().getLast();
    if (localObject2 == null)
    {
      AppMethodBeat.o(231885);
      return;
    }
    String str1 = parama.crh.cqn.optString("html");
    Object localObject3 = Uri.parse((String)localObject1);
    if ((Util.nullAsNil(((Uri)localObject3).getQueryParameter("not_in_game_luggage")).equals("1")) || ((((Uri)localObject3).getHost() != null) && (!((Uri)localObject3).getHost().equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com)))))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      parama.a("", null);
      AppMethodBeat.o(231885);
      return;
    }
    localObject3 = parama.crh.cqn.optString("statusBarColor");
    if (!Util.isNullOrNil((String)localObject3)) {}
    for (;;)
    {
      try
      {
        i = Color.parseColor((String)localObject3);
        String str2 = parama.crh.cqn.optString("statusBarStyle");
        String str3 = parama.crh.cqn.optString("preInjectData");
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("rawUrl", (String)localObject1);
        ((Bundle)localObject3).putInt("customize_status_bar_color", i);
        ((Bundle)localObject3).putString("status_bar_style", str2);
        ((Bundle)localObject3).putString("game_pre_inject_data", str3);
        ((Bundle)localObject3).putBoolean("from_find_more_friend", ((s)localObject2).mParams.getBoolean("from_find_more_friend", false));
        if (!Util.isNullOrNil(str1)) {
          ((Bundle)localObject3).putString("game_open_html", str1);
        }
        if ((((com.tencent.luggage.d.h)localObject2).mContext instanceof LuggageGameHalfWebViewUI))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras((Bundle)localObject3);
          c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          parama.a("", null);
          AppMethodBeat.o(231885);
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", localIllegalArgumentException.getMessage());
        parama.a("invalid_color", null);
        AppMethodBeat.o(231885);
        return;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(230999);
          this.CBl.crm.Oo().m(localIllegalArgumentException, this.val$bundle);
          AppMethodBeat.o(230999);
        }
      });
      continue;
      int i = 0;
    }
  }
  
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b.a parama)
  {
    AppMethodBeat.i(83083);
    Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "invokeInOwn");
    Object localObject = parama.crh.cqn.optJSONObject("liteAppInfo");
    if (localObject != null)
    {
      Context localContext = MMApplicationContext.getContext();
      parama = new a.a()
      {
        public final void ewC()
        {
          AppMethodBeat.i(232271);
          Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openLiteApp success");
          parama.a("", null);
          String str = d.boN(parama.crh.cqn.optString("url"));
          if (!Util.isNullOrNil(str))
          {
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(str);
            WepkgVersionUpdater.G(localLinkedList, 4);
          }
          AppMethodBeat.o(232271);
        }
        
        public final void ewD()
        {
          AppMethodBeat.i(232273);
          z.a(z.this, parama);
          AppMethodBeat.o(232273);
        }
      };
      if (localObject == null)
      {
        parama.ewD();
        AppMethodBeat.o(83083);
        return;
      }
      String str1 = ((JSONObject)localObject).optString("appId");
      if (Util.isNullOrNil(str1))
      {
        Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openInLiteApp appId is null");
        parama.ewD();
        AppMethodBeat.o(83083);
        return;
      }
      f.eLH();
      if (f.cY(str1) == null)
      {
        Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openInLiteApp");
        parama.ewD();
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
      ((a)com.tencent.mm.kernel.h.ae(a.class)).a(localContext, localBundle, false, parama);
      AppMethodBeat.o(83083);
      return;
    }
    c(parama);
    AppMethodBeat.o(83083);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameUrlWithExtraWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.z
 * JD-Core Version:    0.7.0.1
 */