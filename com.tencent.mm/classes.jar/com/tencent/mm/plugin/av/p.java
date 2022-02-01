package com.tencent.mm.plugin.av;

import android.webkit.JavascriptInterface;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.aa.f;
import kotlin.l;
import kotlin.t;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClient;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;)V", "getId", "", "getUserHash", "", "request", "", "requestUrl", "method", "header", "data", "callback", "setMinBizPkgVersion", "version", "Companion", "webview-sdk_release"})
public final class p
  extends a<q>
{
  public static final a PvC;
  private static int aKQ;
  private static int aKR;
  
  static
  {
    AppMethodBeat.i(206984);
    PvC = new a((byte)0);
    aKQ = 30000;
    aKR = 30000;
    AppMethodBeat.o(206984);
  }
  
  public p(q paramq)
  {
    super("wxPrefetcherClient", (b)paramq);
    AppMethodBeat.i(206983);
    AppMethodBeat.o(206983);
  }
  
  @JavascriptInterface
  public final String getId()
  {
    AppMethodBeat.i(206978);
    String str = ((q)this.Pvj).getId();
    AppMethodBeat.o(206978);
    return str;
  }
  
  @JavascriptInterface
  public final int getUserHash()
  {
    AppMethodBeat.i(206980);
    int i = com.tencent.mm.kernel.b.aGP();
    i = Math.abs((i + '-' + com.tencent.mm.compatible.deviceinfo.q.auE()).hashCode() % 10000);
    AppMethodBeat.o(206980);
    return i;
  }
  
  @JavascriptInterface
  public final void request(final String paramString1, final String paramString2, String paramString3, final String paramString4, final String paramString5)
  {
    AppMethodBeat.i(206982);
    kotlin.g.b.p.k(paramString1, "requestUrl");
    kotlin.g.b.p.k(paramString5, "callback");
    final aa.f localf = new aa.f();
    Object localObject1 = paramString2;
    if (paramString2 == null) {
      localObject1 = "GET";
    }
    localf.aaBC = localObject1;
    paramString2 = (Map)new HashMap();
    for (;;)
    {
      try
      {
        if (!Util.isNullOrNil(paramString3))
        {
          paramString3 = new JSONObject(paramString3);
          localObject1 = paramString3.keys();
          kotlin.g.b.p.j(localObject1, "jsonObject.keys()");
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (localObject2 != null) {
              break label180;
            }
            paramString3 = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(206982);
            throw paramString3;
          }
        }
      }
      catch (JSONException paramString3)
      {
        Log.printInfoStack(this.TAG, "", new Object[] { paramString3 });
        h.ZvG.d((Runnable)new b(this, localf, paramString1, paramString2, paramString4, paramString5), "WxPrefetcherRequest");
        AppMethodBeat.o(206982);
        return;
      }
      label180:
      Object localObject2 = (String)localObject2;
      String str = paramString3.optString((String)localObject2);
      kotlin.g.b.p.j(str, "value");
      paramString2.put(localObject2, str);
    }
  }
  
  @JavascriptInterface
  public final void setMinBizPkgVersion(int paramInt)
  {
    AppMethodBeat.i(206981);
    ((q)this.Pvj).setMinBizPkgVersion(paramInt);
    AppMethodBeat.o(206981);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClient$Companion;", "", "()V", "connectionTimeoutMs", "", "readTimeoutMs", "webview-sdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(p paramp, aa.f paramf, String paramString1, Map paramMap, String paramString2, String paramString3) {}
    
    public final void run()
    {
      AppMethodBeat.i(206464);
      Object localObject1 = (String)localf.aaBC;
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206464);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((String)localObject1).toUpperCase();
      kotlin.g.b.p.j(localObject1, "(this as java.lang.String).toUpperCase()");
      Object localObject3;
      int i;
      Object localObject2;
      if (kotlin.g.b.p.h(localObject1, "POST"))
      {
        localObject1 = com.tencent.mm.plugin.webview.k.c.a(paramString1, paramString2, paramString4);
        if (localObject1 == null) {
          break label398;
        }
        localObject3 = this.PvD.TAG;
        i = ((com.tencent.mm.plugin.webview.k.c.a)localObject1).statusCode;
        localObject2 = ((com.tencent.mm.plugin.webview.k.c.a)localObject1).qjY;
        if (localObject2 == null) {
          break label370;
        }
        localObject2 = Integer.valueOf(((Map)localObject2).size());
        label110:
        Log.i((String)localObject3, "request response statusCode:%d, header.size:%d", new Object[] { Integer.valueOf(i), localObject2 });
        Log.v(this.PvD.TAG, "request response header:%s data:%s", new Object[] { ((com.tencent.mm.plugin.webview.k.c.a)localObject1).qjY, ((com.tencent.mm.plugin.webview.k.c.a)localObject1).data });
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("statusCode", ((com.tencent.mm.plugin.webview.k.c.a)localObject1).statusCode);
        ((JSONObject)localObject2).put("data", ((com.tencent.mm.plugin.webview.k.c.a)localObject1).data);
        if (((com.tencent.mm.plugin.webview.k.c.a)localObject1).qjY != null)
        {
          localObject3 = ((com.tencent.mm.plugin.webview.k.c.a)localObject1).qjY;
          if (localObject3 != null)
          {
            if (((Map)localObject3).isEmpty()) {
              break label378;
            }
            i = 1;
            label222:
            if (i == 1)
            {
              com.tencent.mm.plugin.webview.k.c.bX(((com.tencent.mm.plugin.webview.k.c.a)localObject1).qjY);
              localObject1 = ((com.tencent.mm.plugin.webview.k.c.a)localObject1).qjY;
              kotlin.g.b.p.j(localObject1, "response.header");
              kotlin.g.b.p.k(localObject1, "$this$toMap");
              switch (((Map)localObject1).size())
              {
              default: 
                localObject1 = ae.cA((Map)localObject1);
              }
            }
          }
        }
      }
      for (;;)
      {
        ((JSONObject)localObject2).put("header", new JSONObject((Map)localObject1));
        Log.i(this.PvD.TAG, "request success");
        localObject1 = (q)this.PvD.Pvj;
        localObject3 = paramString5;
        localObject2 = ((JSONObject)localObject2).toString();
        kotlin.g.b.p.j(localObject2, "retObject.toString()");
        c.a.a((c)localObject1, (String)localObject3, (String)localObject2, null, 4);
        AppMethodBeat.o(206464);
        return;
        localObject1 = com.tencent.mm.plugin.webview.k.c.W(paramString1, paramString2);
        break;
        label370:
        localObject2 = Integer.valueOf(0);
        break label110;
        label378:
        i = 0;
        break label222;
        localObject1 = ae.iBR();
        continue;
        localObject1 = ae.cz((Map)localObject1);
      }
      label398:
      Log.w(this.PvD.TAG, "request response is null, return");
      c.a.a((q)this.PvD.Pvj, paramString5, "fail:response is null", null, 4);
      AppMethodBeat.o(206464);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.p
 * JD-Core Version:    0.7.0.1
 */