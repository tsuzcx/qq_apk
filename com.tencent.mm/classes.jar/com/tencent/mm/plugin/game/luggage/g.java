package com.tencent.mm.plugin.game.luggage;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.dl;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class g
{
  public static void a(com.tencent.luggage.d.p paramp, final String paramString)
  {
    AppMethodBeat.i(180130);
    com.tencent.mm.ipcinvoker.p.x(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83011);
        this.uen.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject BP()
          {
            AppMethodBeat.i(83010);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("url", g.2.this.ueo);
              localJSONObject.put("set_cookie", 1);
              AppMethodBeat.o(83010);
              return localJSONObject;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ae.e("MicroMsg.LuggageGetA8KeyUtil", "onGetA8Key, e:" + localException.getMessage());
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
  
  public static void a(final com.tencent.luggage.d.p paramp, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(83012);
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.wP(paramString);
    ae.i("MicroMsg.LuggageGetA8KeyUtil", "getA8Key begin, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    localGameWebPerformanceInfo.gvd = System.currentTimeMillis();
    com.tencent.mm.plugin.webview.e.c localc = new com.tencent.mm.plugin.webview.e.c();
    localc.a(paramString, new com.tencent.mm.plugin.webview.e.a()
    {
      public final void a(int paramAnonymousInt1, String paramAnonymousString1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString2) {}
      
      public final void bl(int paramAnonymousInt, String paramAnonymousString) {}
      
      public final void bm(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(192981);
        this.uem.gvd = System.currentTimeMillis();
        com.tencent.mm.plugin.webview.ui.tools.game.g.bF(paramAnonymousString, System.currentTimeMillis());
        AppMethodBeat.o(192981);
      }
      
      public final void z(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2) {}
    });
    if (paramBoolean) {
      e.a(paramp.hashCode(), localc);
    }
    AppMethodBeat.o(83012);
  }
  
  public static void a(final MMWebView paramMMWebView, String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(180131);
    if ((bu.isNullOrNil(paramString)) || (paramMMWebView == null))
    {
      ae.e("MicroMsg.LuggageGetA8KeyUtil", "url is null");
      AppMethodBeat.o(180131);
      return;
    }
    com.tencent.mm.ipcinvoker.p.x(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(180129);
        com.tencent.xweb.d.lB(ak.getContext());
        Object localObject3 = com.tencent.xweb.c.geY();
        String str2 = "; max-age=" + com.tencent.mm.plugin.game.commlib.a.cZx();
        String str3 = str2 + "; httponly";
        Object localObject4 = Uri.parse(this.val$url);
        Object localObject5 = ((Uri)localObject4).getHost();
        String str1 = ((Uri)localObject4).getScheme();
        Object localObject1 = str1;
        if (bu.isNullOrNil(str1)) {
          localObject1 = "http";
        }
        if (bu.isNullOrNil((String)localObject5))
        {
          ae.e("MicroMsg.LuggageGetA8KeyUtil", "host is null");
          AppMethodBeat.o(180129);
          return;
        }
        if (((String)localObject5).startsWith(".")) {}
        boolean bool1;
        String str4;
        for (str1 = (String)localObject1 + "://" + (String)localObject5;; str1 = (String)localObject1 + "://." + (String)localObject5)
        {
          ae.i("MicroMsg.LuggageGetA8KeyUtil", "domain = %s", new Object[] { str1 });
          ae.i("MicroMsg.LuggageGetA8KeyUtil", "before set cookies:%s", new Object[] { ((com.tencent.xweb.c)localObject3).getCookie(str1) });
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
            str4 = (String)((Iterator)localObject1).next();
            ((com.tencent.xweb.c)localObject3).setCookie((String)localObject5, str4 + "=" + (String)paramMap.get(str4) + "; max-age=0");
            ((com.tencent.xweb.c)localObject3).setCookie(str1, str4 + "=" + (String)paramMap.get(str4) + str3);
          }
        }
        label955:
        label958:
        label964:
        for (;;)
        {
          try
          {
            if (com.tencent.mm.plugin.game.commlib.a.udz != null)
            {
              localObject1 = com.tencent.mm.plugin.game.commlib.a.udz.utg;
              if ((localObject1 == null) || (bu.ht(((com.tencent.mm.plugin.game.d.a)localObject1).uqd))) {
                continue;
              }
              localObject5 = ((com.tencent.mm.plugin.game.d.a)localObject1).uqd.iterator();
              if (!((Iterator)localObject5).hasNext()) {
                break label964;
              }
              localObject1 = (dl)((Iterator)localObject5).next();
              if (bu.isNullOrNil(((dl)localObject1).uuW)) {
                break label955;
              }
              str4 = ((Uri)localObject4).getQueryParameter(((dl)localObject1).uuW);
              if (bu.isNullOrNil(((dl)localObject1).uuX))
              {
                localObject1 = ((dl)localObject1).uuW;
                ae.i("MicroMsg.LuggageGetA8KeyUtil", "key = %s, value = %s", new Object[] { localObject1, str4 });
                if (bu.isNullOrNil(str4)) {
                  break label955;
                }
                ((com.tencent.xweb.c)localObject3).setCookie(str1, (String)localObject1 + "=" + URLEncoder.encode(str4, "utf-8") + str3);
                bool1 = true;
                break label955;
              }
            }
            else
            {
              com.tencent.mm.plugin.game.commlib.a.cZs();
              if (com.tencent.mm.plugin.game.commlib.a.udz == null) {
                break label958;
              }
              localObject1 = com.tencent.mm.plugin.game.commlib.a.udz.utg;
              continue;
            }
            localObject1 = ((dl)localObject1).uuX;
            continue;
            ae.i("MicroMsg.LuggageGetA8KeyUtil", "hasSetCookie=".concat(String.valueOf(bool1)));
            if (bool1) {
              ((com.tencent.xweb.c)localObject3).setCookie(str1, "cookie_passkey=1".concat(String.valueOf(str2)));
            }
            com.tencent.xweb.d.gfa();
            com.tencent.xweb.d.sync();
            str1 = ((com.tencent.xweb.c)localObject3).getCookie(str1);
            ae.i("MicroMsg.LuggageGetA8KeyUtil", "after set cookies:%s", new Object[] { str1 });
            paramMMWebView.evaluateJavascript("javascript:if(window.__GAME_LOGIN_CALLBACK) {window.__GAME_LOGIN_CALLBACK({\"cookie_passkey\":1});}", null);
            localObject3 = com.tencent.mm.game.report.api.a.guC;
            if (bool1)
            {
              localObject1 = "SET_COOKIE_SUCCESS";
              ((com.tencent.mm.game.report.api.a)localObject3).a(10, (String)localObject1, URLEncoder.encode(str1, "utf-8"), 0L);
              AppMethodBeat.o(180129);
              return;
              localObject1 = ((Uri)localObject4).getQueryParameter("uin");
              localObject5 = ((Uri)localObject4).getQueryParameter("key");
              localObject4 = ((Uri)localObject4).getQueryParameter("pass_ticket");
              ae.i("MicroMsg.LuggageGetA8KeyUtil", "uin = %s, key = %s, pass_ticket = %s", new Object[] { localObject1, localObject5, localObject4 });
              if (!bu.isNullOrNil((String)localObject1)) {
                ((com.tencent.xweb.c)localObject3).setCookie(str1, "X-WECHAT-UIN=" + URLEncoder.encode((String)localObject1, "utf-8") + str3);
              }
              if (!bu.isNullOrNil((String)localObject5)) {
                ((com.tencent.xweb.c)localObject3).setCookie(str1, "X-WECHAT-KEY=" + URLEncoder.encode((String)localObject5, "utf-8") + str3);
              }
              if (!bu.isNullOrNil((String)localObject4))
              {
                ((com.tencent.xweb.c)localObject3).setCookie(str1, "pass_ticket=" + URLEncoder.encode((String)localObject4, "utf-8") + str3);
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
            ae.printErrStackTrace("MicroMsg.LuggageGetA8KeyUtil", localException, "", new Object[0]);
            com.tencent.mm.game.report.api.a.guC.a(10, "SET_COOKIE_FAIL", "exception", 0L);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g
 * JD-Core Version:    0.7.0.1
 */