package com.tencent.mm.plugin.ax;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.k.d;
import com.tencent.mm.plugin.webview.k.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClient;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;)V", "getId", "", "getUserHash", "", "request", "", "requestUrl", "method", "header", "data", "callback", "setMinBizPkgVersion", "version", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends a<q>
{
  public static final a WlT;
  private static int cEM;
  private static int cEN;
  
  static
  {
    AppMethodBeat.i(260796);
    WlT = new a((byte)0);
    cEM = 30000;
    cEN = 30000;
    AppMethodBeat.o(260796);
  }
  
  public p(q paramq)
  {
    super("wxPrefetcherClient", (b)paramq);
    AppMethodBeat.i(260776);
    AppMethodBeat.o(260776);
  }
  
  private static final void a(ah.f paramf, String paramString1, Map paramMap, String paramString2, p paramp, String paramString3)
  {
    int k = 0;
    AppMethodBeat.i(260788);
    s.u(paramf, "$method");
    s.u(paramString1, "$requestUrl");
    s.u(paramMap, "$headers");
    s.u(paramp, "this$0");
    s.u(paramString3, "$callback");
    paramf = (String)paramf.aqH;
    if (paramf == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(260788);
      throw paramf;
    }
    paramf = paramf.toUpperCase();
    s.s(paramf, "(this as java.lang.String).toUpperCase()");
    int j;
    if (s.p(paramf, "POST"))
    {
      paramf = d.a(paramString1, paramMap, paramString2);
      if (paramf == null) {
        break label365;
      }
      paramString1 = paramp.getTAG();
      j = paramf.statusCode;
      paramMap = paramf.toO;
      if (paramMap != null) {
        break label348;
      }
      i = 0;
      label124:
      Log.i(paramString1, "request response statusCode:%d, header.size:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      Log.v(paramp.getTAG(), "request response header:%s data:%s", new Object[] { paramf.toO, paramf.data });
      paramString1 = new JSONObject();
      paramString1.put("statusCode", paramf.statusCode);
      paramString1.put("data", paramf.data);
      if (paramf.toO != null)
      {
        paramMap = paramf.toO;
        j = k;
        if (paramMap != null) {
          if (paramMap.isEmpty()) {
            break label359;
          }
        }
      }
    }
    label348:
    label359:
    for (int i = 1;; i = 0)
    {
      j = k;
      if (i == 1) {
        j = 1;
      }
      if (j != 0)
      {
        d.cv(paramf.toO);
        paramf = paramf.toO;
        s.s(paramf, "response.header");
        paramString1.put("header", new JSONObject(ak.dv(paramf)));
      }
      Log.i(paramp.getTAG(), "request success");
      paramf = (c)paramp.WlE;
      paramString1 = paramString1.toString();
      s.s(paramString1, "retObject.toString()");
      c.a.a(paramf, paramString3, paramString1, null, 4);
      AppMethodBeat.o(260788);
      return;
      paramf = d.af(paramString1, paramMap);
      break;
      i = paramMap.size();
      break label124;
    }
    label365:
    Log.w(paramp.getTAG(), "request response is null, return");
    c.a.a((c)paramp.WlE, paramString3, "fail:response is null", null, 4);
    AppMethodBeat.o(260788);
  }
  
  @JavascriptInterface
  public final String getId()
  {
    AppMethodBeat.i(260808);
    String str = ((q)this.WlE).getId();
    AppMethodBeat.o(260808);
    return str;
  }
  
  @JavascriptInterface
  public final int getUserHash()
  {
    AppMethodBeat.i(260815);
    int i = com.tencent.mm.kernel.b.aZP();
    i = Math.abs((i + '-' + com.tencent.mm.compatible.deviceinfo.q.aOY()).hashCode() % 10000);
    AppMethodBeat.o(260815);
    return i;
  }
  
  @JavascriptInterface
  public final void request(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(260830);
    s.u(paramString1, "requestUrl");
    s.u(paramString5, "callback");
    ah.f localf = new ah.f();
    Object localObject1 = paramString2;
    if (paramString2 == null) {
      localObject1 = "GET";
    }
    localf.aqH = localObject1;
    paramString2 = (Map)new HashMap();
    for (;;)
    {
      try
      {
        if (!Util.isNullOrNil(paramString3))
        {
          paramString3 = new JSONObject(paramString3);
          localObject1 = paramString3.keys();
          s.s(localObject1, "jsonObject.keys()");
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (localObject2 != null) {
              break label187;
            }
            paramString3 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(260830);
            throw paramString3;
          }
        }
      }
      catch (JSONException paramString3)
      {
        Log.printInfoStack(getTAG(), "", new Object[] { paramString3 });
        h.ahAA.g(new p..ExternalSyntheticLambda0(localf, paramString1, paramString2, paramString4, this, paramString5), "WxPrefetcherRequest");
        AppMethodBeat.o(260830);
        return;
      }
      label187:
      Object localObject2 = (String)localObject2;
      String str = paramString3.optString((String)localObject2);
      s.s(str, "value");
      paramString2.put(localObject2, str);
    }
  }
  
  @JavascriptInterface
  public final void setMinBizPkgVersion(int paramInt)
  {
    AppMethodBeat.i(260824);
    ((q)this.WlE).setMinBizPkgVersion(paramInt);
    AppMethodBeat.o(260824);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClient$Companion;", "", "()V", "connectionTimeoutMs", "", "readTimeoutMs", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.p
 * JD-Core Version:    0.7.0.1
 */