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
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.LuggageGameHalfWebViewUI;
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

public class y
  extends br
{
  private void c(b.a parama)
  {
    AppMethodBeat.i(186877);
    Object localObject1 = parama.ctb.csi.optString("url");
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url is null");
      parama.c("fail", null);
      AppMethodBeat.o(186877);
      return;
    }
    Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url: %s", new Object[] { localObject1 });
    Object localObject2 = (s)com.tencent.mm.plugin.webview.luggage.j.gbV().getLast();
    if (localObject2 == null)
    {
      AppMethodBeat.o(186877);
      return;
    }
    String str1 = parama.ctb.csi.optString("html");
    Object localObject3 = Uri.parse((String)localObject1);
    if ((Util.nullAsNil(((Uri)localObject3).getQueryParameter("not_in_game_luggage")).equals("1")) || ((((Uri)localObject3).getHost() != null) && (!((Uri)localObject3).getHost().equals(WeChatHosts.domainString(2131761707)))))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      parama.c("", null);
      AppMethodBeat.o(186877);
      return;
    }
    localObject3 = parama.ctb.csi.optString("statusBarColor");
    if (!Util.isNullOrNil((String)localObject3)) {}
    for (;;)
    {
      try
      {
        i = Color.parseColor((String)localObject3);
        String str2 = parama.ctb.csi.optString("statusBarStyle");
        String str3 = parama.ctb.csi.optString("preInjectData");
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("rawUrl", (String)localObject1);
        ((Bundle)localObject3).putInt("customize_status_bar_color", i);
        ((Bundle)localObject3).putString("status_bar_style", str2);
        ((Bundle)localObject3).putString("game_pre_inject_data", str3);
        ((Bundle)localObject3).putBoolean("from_find_more_friend", ((s)localObject2).mParams.getBoolean("from_find_more_friend", false));
        if (!Util.isNullOrNil(str1)) {
          ((Bundle)localObject3).putString("game_open_html", str1);
        }
        if ((((h)localObject2).mContext instanceof LuggageGameHalfWebViewUI))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras((Bundle)localObject3);
          c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          parama.c("", null);
          AppMethodBeat.o(186877);
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", localIllegalArgumentException.getMessage());
        parama.c("invalid_color", null);
        AppMethodBeat.o(186877);
        return;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186876);
          this.xxc.ctg.Ly().h(localIllegalArgumentException, this.val$bundle);
          AppMethodBeat.o(186876);
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
    Object localObject = parama.ctb.csi.optJSONObject("liteAppInfo");
    if (localObject != null)
    {
      Context localContext = MMApplicationContext.getContext();
      parama = new a.a()
      {
        public final void dTt()
        {
          AppMethodBeat.i(186874);
          Log.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openLiteApp success");
          parama.c("", null);
          String str = d.bcO(parama.ctb.csi.optString("url"));
          if (!Util.isNullOrNil(str))
          {
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(str);
            WepkgVersionUpdater.F(localLinkedList, 4);
          }
          AppMethodBeat.o(186874);
        }
        
        public final void dTu()
        {
          AppMethodBeat.i(186875);
          y.a(y.this, parama);
          AppMethodBeat.o(186875);
        }
      };
      if (localObject == null)
      {
        parama.dTu();
        AppMethodBeat.o(83083);
        return;
      }
      String str1 = ((JSONObject)localObject).optString("appId");
      if (Util.isNullOrNil(str1))
      {
        Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openInLiteApp appId is null");
        parama.dTu();
        AppMethodBeat.o(83083);
        return;
      }
      f.ecC();
      if (f.aCT(str1) == null)
      {
        Log.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "openInLiteApp");
        parama.dTu();
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
      ((a)g.af(a.class)).a(localContext, localBundle, false, parama);
      AppMethodBeat.o(83083);
      return;
    }
    c(parama);
    AppMethodBeat.o(83083);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameUrlWithExtraWebView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.y
 * JD-Core Version:    0.7.0.1
 */