package com.tencent.mm.plugin.game.luggage;

import android.net.Uri;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.dq;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.plugin.webview.ui.tools.game.h;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ao;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class g
{
  public static void a(final MMWebView paramMMWebView, String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(180131);
    if ((Util.isNullOrNil(paramString)) || (paramMMWebView == null))
    {
      Log.e("MicroMsg.LuggageGetA8KeyUtil", "url is null");
      AppMethodBeat.o(180131);
      return;
    }
    s.D(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(180129);
        ao.oQ(MMApplicationContext.getContext());
        Object localObject3 = "; max-age=" + com.tencent.mm.plugin.game.commlib.a.fDV();
        String str2 = (String)localObject3 + "; httponly";
        Object localObject4 = Uri.parse(g.this);
        Object localObject5 = ((Uri)localObject4).getHost();
        String str1 = ((Uri)localObject4).getScheme();
        Object localObject1 = str1;
        if (Util.isNullOrNil(str1)) {
          localObject1 = "http";
        }
        if (Util.isNullOrNil((String)localObject5))
        {
          Log.e("MicroMsg.LuggageGetA8KeyUtil", "host is null");
          AppMethodBeat.o(180129);
          return;
        }
        if (((String)localObject5).startsWith(".")) {}
        boolean bool1;
        String str3;
        for (str1 = (String)localObject1 + "://" + (String)localObject5;; str1 = (String)localObject1 + "://." + (String)localObject5)
        {
          Log.i("MicroMsg.LuggageGetA8KeyUtil", "domain = %s", new Object[] { str1 });
          Log.i("MicroMsg.LuggageGetA8KeyUtil", "before set cookies:%s", new Object[] { ao.getCookie(str1) });
          boolean bool3 = false;
          boolean bool2 = false;
          bool1 = bool3;
          if (paramMap == null) {
            break;
          }
          bool1 = bool3;
          if (paramMap.size() <= 0) {
            break;
          }
          localObject1 = paramMap.keySet().iterator();
          for (bool1 = bool2; ((Iterator)localObject1).hasNext(); bool1 = true)
          {
            str3 = (String)((Iterator)localObject1).next();
            ao.setCookie((String)localObject5, str3 + "=" + (String)paramMap.get(str3) + "; max-age=0");
            ao.setCookie(str1, str3 + "=" + (String)paramMap.get(str3) + str2);
          }
        }
        label926:
        label929:
        label935:
        for (;;)
        {
          try
          {
            if (com.tencent.mm.plugin.game.commlib.a.IsN != null)
            {
              localObject1 = com.tencent.mm.plugin.game.commlib.a.IsN.A8Key;
              if ((localObject1 == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.game.protobuf.a)localObject1).IGF))) {
                continue;
              }
              localObject5 = ((com.tencent.mm.plugin.game.protobuf.a)localObject1).IGF.iterator();
              if (!((Iterator)localObject5).hasNext()) {
                break label935;
              }
              localObject1 = (dq)((Iterator)localObject5).next();
              if (Util.isNullOrNil(((dq)localObject1).ILw)) {
                break label926;
              }
              str3 = ((Uri)localObject4).getQueryParameter(((dq)localObject1).ILw);
              if (Util.isNullOrNil(((dq)localObject1).ILx))
              {
                localObject1 = ((dq)localObject1).ILw;
                Log.i("MicroMsg.LuggageGetA8KeyUtil", "key = %s, value = %s", new Object[] { localObject1, str3 });
                if (Util.isNullOrNil(str3)) {
                  break label926;
                }
                ao.setCookie(str1, (String)localObject1 + "=" + URLEncoder.encode(str3, "utf-8") + str2);
                bool1 = true;
                break label926;
              }
            }
            else
            {
              com.tencent.mm.plugin.game.commlib.a.fDQ();
              if (com.tencent.mm.plugin.game.commlib.a.IsN == null) {
                break label929;
              }
              localObject1 = com.tencent.mm.plugin.game.commlib.a.IsN.A8Key;
              continue;
            }
            localObject1 = ((dq)localObject1).ILx;
            continue;
            Log.i("MicroMsg.LuggageGetA8KeyUtil", "hasSetCookie=".concat(String.valueOf(bool1)));
            if (bool1) {
              ao.setCookie(str1, "cookie_passkey=1".concat(String.valueOf(localObject3)));
            }
            ao.kgo();
            str1 = ao.getCookie(str1);
            Log.i("MicroMsg.LuggageGetA8KeyUtil", "after set cookies:%s", new Object[] { str1 });
            paramMMWebView.evaluateJavascript("javascript:if(window.__GAME_LOGIN_CALLBACK) {window.__GAME_LOGIN_CALLBACK({\"cookie_passkey\":1});}", null);
            localObject3 = com.tencent.mm.game.report.api.a.mtH;
            if (bool1)
            {
              localObject1 = "SET_COOKIE_SUCCESS";
              ((com.tencent.mm.game.report.api.a)localObject3).a(10, (String)localObject1, URLEncoder.encode(str1, "utf-8"), 0L);
              AppMethodBeat.o(180129);
              return;
              localObject1 = ((Uri)localObject4).getQueryParameter("uin");
              localObject5 = ((Uri)localObject4).getQueryParameter("key");
              localObject4 = ((Uri)localObject4).getQueryParameter("pass_ticket");
              Log.i("MicroMsg.LuggageGetA8KeyUtil", "uin = %s, key = %s, pass_ticket = %s", new Object[] { localObject1, localObject5, localObject4 });
              if (!Util.isNullOrNil((String)localObject1)) {
                ao.setCookie(str1, "X-WECHAT-UIN=" + URLEncoder.encode((String)localObject1, "utf-8") + str2);
              }
              if (!Util.isNullOrNil((String)localObject5)) {
                ao.setCookie(str1, "X-WECHAT-KEY=" + URLEncoder.encode((String)localObject5, "utf-8") + str2);
              }
              if (!Util.isNullOrNil((String)localObject4))
              {
                ao.setCookie(str1, "pass_ticket=" + URLEncoder.encode((String)localObject4, "utf-8") + str2);
                bool1 = true;
              }
            }
            else
            {
              localObject1 = "SET_COOKIE_FAIL";
              continue;
            }
            continue;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.LuggageGetA8KeyUtil", localException, "", new Object[0]);
            com.tencent.mm.game.report.api.a.mtH.a(10, "SET_COOKIE_FAIL", "exception", 0L);
            AppMethodBeat.o(180129);
            return;
          }
          continue;
          Object localObject2 = null;
        }
      }
    });
    AppMethodBeat.o(180131);
  }
  
  public static void b(final p paramp, String paramString)
  {
    AppMethodBeat.i(276946);
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.EI(paramString);
    Log.i("MicroMsg.LuggageGetA8KeyUtil", "getA8Key begin, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    localGameWebPerformanceInfo.mui = System.currentTimeMillis();
    c localc = new c();
    localc.a(paramString, new com.tencent.mm.plugin.webview.e.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void a(int paramAnonymousInt1, String paramAnonymousString1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString2) {}
      
      public final void ca(int paramAnonymousInt, String paramAnonymousString) {}
      
      public final void cb(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(276930);
        g.this.mui = System.currentTimeMillis();
        h.bY(paramAnonymousString, System.currentTimeMillis());
        AppMethodBeat.o(276930);
      }
    });
    e.a(paramp.hashCode(), localc);
    AppMethodBeat.o(276946);
  }
  
  public static void c(p paramp, final String paramString)
  {
    AppMethodBeat.i(180130);
    s.D(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83011);
        g.this.a(new d()
        {
          public final JSONObject aoe()
          {
            AppMethodBeat.i(83010);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("url", g.2.this.ItS);
              localJSONObject.put("set_cookie", 1);
              AppMethodBeat.o(83010);
              return localJSONObject;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.e("MicroMsg.LuggageGetA8KeyUtil", "onGetA8Key, e:" + localException.getMessage());
              }
            }
          }
          
          public final String name()
          {
            return "onGetA8KeyUrl";
          }
        });
        AppMethodBeat.o(83011);
      }
    });
    AppMethodBeat.o(180130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g
 * JD-Core Version:    0.7.0.1
 */