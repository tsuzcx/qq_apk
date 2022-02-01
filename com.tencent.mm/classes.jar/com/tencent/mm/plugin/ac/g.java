package com.tencent.mm.plugin.ac;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.appbrand.y.p.a;
import com.tencent.mm.plugin.webcanvas.h;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.j.e;
import com.tencent.mm.plugin.webview.j.e.a;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.q;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineAPI;", "", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AbstractMultiContextJsEngine;", "engine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AbstractMultiContextJsEngine;Lcom/tencent/mm/appbrand/v8/V8ContextEngine;)V", "JSON", "Lcom/eclipsesource/v8/V8Object;", "kotlin.jvm.PlatformType", "getJSON", "()Lcom/eclipsesource/v8/V8Object;", "JSON$delegate", "Lkotlin/Lazy;", "TAG", "", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "getCacheDir", "getLocalData", "key", "getLogLevel", "", "getPlatform", "idkey", "", "id", "", "value", "idkeyList", "list", "invoke", "params", "callback", "Lcom/eclipsesource/v8/V8Function;", "kv", "data", "reportCgi", "businessId", "", "reqJson", "setContext", "ct", "Landroid/content/Context;", "setLocalData", "userAgent", "asCallbacker", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "parseJSON", "stringify", "use", "R", "T", "block", "Lkotlin/Function1;", "(Lcom/eclipsesource/v8/V8Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "webview-sdk_release"})
public abstract class g
{
  public static final g.a DSf = new g.a((byte)0);
  private final d.f DPN;
  private final as DSc;
  private final com.tencent.mm.plugin.appbrand.jsruntime.a DSd;
  private final com.tencent.mm.appbrand.v8.m DSe;
  private final String TAG;
  private final d.f oqe;
  
  public g(com.tencent.mm.plugin.appbrand.jsruntime.a parama, com.tencent.mm.appbrand.v8.m paramm)
  {
    this.DSd = parama;
    this.DSe = paramm;
    this.TAG = "MicroMsg.WebJsEngineAPI";
    this.oqe = d.g.O((d.g.a.a)g.h.DSn);
    parama = ay.aRW("__WebJsEngineLocalData__");
    d.g.b.p.g(parama, "MultiProcessMMKV.getMMKV…_WebJsEngineLocalData__\")");
    this.DSc = new as(parama, 15552000L);
    this.DPN = d.g.O((d.g.a.a)new b(this));
  }
  
  private static <T extends V8Object, R> R a(T paramT, d.g.a.b<? super T, ? extends R> paramb)
  {
    paramb = paramb.invoke(paramT);
    paramT.release();
    return paramb;
  }
  
  private final String a(V8Object paramV8Object)
  {
    paramV8Object = a((V8Object)this.DSe.newV8Array().push((V8Value)paramV8Object), (d.g.a.b)new g(this));
    d.g.b.p.g(paramV8Object, "engine.newV8Array().push…ngify\", parameters)\n    }");
    return (String)paramV8Object;
  }
  
  public abstract com.tencent.mm.plugin.webview.c.f eOO();
  
  @JavascriptInterface
  public final String getCacheDir()
  {
    h localh = h.DQL;
    return h.eOX();
  }
  
  @JavascriptInterface
  public final String getLocalData(String paramString)
  {
    d.g.b.p.h(paramString, "key");
    try
    {
      String str = ((ay)this.DSc.fnP()).decodeString(paramString, "");
      ae.d(this.TAG, "getLocalData:" + paramString + ", " + str);
      return str;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "getLocalData:".concat(String.valueOf(paramString)), new Object[0]);
    }
    return null;
  }
  
  @JavascriptInterface
  public final int getLogLevel()
  {
    return ae.getLogLevel();
  }
  
  @JavascriptInterface
  public final String getPlatform()
  {
    return "android";
  }
  
  @JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    com.tencent.mm.plugin.report.service.g.yxI.n(paramLong1, paramLong2, paramLong3);
  }
  
  @JavascriptInterface
  public final void idkeyList(V8Object paramV8Object)
  {
    d.g.b.p.h(paramV8Object, "list");
    paramV8Object = com.tencent.mm.plugin.webview.k.a.b(new com.tencent.mm.ab.f(a(paramV8Object)), (d.g.a.m)g.d.DSk);
    com.tencent.mm.plugin.report.service.g.yxI.b(new ArrayList((Collection)paramV8Object), false);
  }
  
  @JavascriptInterface
  public final void invoke(V8Object paramV8Object, final V8Function paramV8Function)
  {
    d.g.b.p.h(paramV8Object, "params");
    d.g.b.p.h(paramV8Function, "callback");
    paramV8Object = a(paramV8Object);
    paramV8Function = paramV8Function.twin();
    ae.d(this.TAG, "invoke: ".concat(String.valueOf(paramV8Object)));
    com.tencent.mm.plugin.webview.c.f localf = eOO();
    d.g.b.p.g(paramV8Function, "callback");
    localf.a(paramV8Object, (com.tencent.mm.plugin.webview.c.b)new c(this, paramV8Function));
  }
  
  @JavascriptInterface
  public final void kv(int paramInt, String paramString)
  {
    d.g.b.p.h(paramString, "data");
    ae.i(this.TAG, "kvStat id=" + paramInt + ", data=" + paramString);
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(paramInt, paramString);
  }
  
  @JavascriptInterface
  public final void reportCgi(Number paramNumber, String paramString, final V8Function paramV8Function)
  {
    d.g.b.p.h(paramNumber, "businessId");
    d.g.b.p.h(paramString, "reqJson");
    d.g.b.p.h(paramV8Function, "callback");
    paramV8Function = paramV8Function.twin();
    Object localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bw.a)new nk());
    ((b.a)localObject1).d((com.tencent.mm.bw.a)new nl());
    ((b.a)localObject1).DN("/cgi-bin/mmbiz-bin/report/bizcommreport");
    ((b.a)localObject1).oS(4779);
    localObject1 = ((b.a)localObject1).aDS();
    Object localObject2 = ((com.tencent.mm.ak.b)localObject1).aEU();
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizCommReportReq");
    }
    localObject2 = (nk)localObject2;
    ((nk)localObject2).FZJ = paramNumber.intValue();
    ((nk)localObject2).FZK = paramString;
    ae.d(this.TAG, "reportCgi %s", new Object[] { paramString });
    ae.i(this.TAG, "reportCgi businessId=".concat(String.valueOf(paramNumber)));
    x.a((com.tencent.mm.ak.b)localObject1, (x.a)new f(this, paramV8Function));
  }
  
  public final void setContext(Context paramContext)
  {
    d.g.b.p.h(paramContext, "ct");
    eOO().gY(paramContext);
  }
  
  @JavascriptInterface
  public final void setLocalData(String paramString1, String paramString2)
  {
    d.g.b.p.h(paramString1, "key");
    d.g.b.p.h(paramString2, "data");
    try
    {
      ((ay)this.DSc.fnP()).encode(paramString1, paramString2);
      ae.d(this.TAG, "setLocalData:" + paramString1 + ", " + paramString2);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
    }
  }
  
  @JavascriptInterface
  public final String userAgent()
  {
    Object localObject = ak.getContext();
    e.a locala = e.ELF;
    localObject = com.tencent.mm.plugin.appbrand.y.p.a((Context)localObject, e.a.eZC(), (p.a)this.oqe.getValue());
    ae.d(this.TAG, "userAgent=".concat(String.valueOf(localObject)));
    d.g.b.p.g(localObject, "userAgent");
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/eclipsesource/v8/V8Object;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<V8Object>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class c
    implements com.tencent.mm.plugin.webview.c.b
  {
    c(g paramg, V8Function paramV8Function) {}
    
    public final void i(final String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(214028);
      HashMap localHashMap = new HashMap();
      Map localMap = (Map)localHashMap;
      d.g.b.p.g(paramString2, "ret");
      localMap.put("err_msg", paramString2);
      if (paramMap != null) {
        localHashMap.putAll(paramMap);
      }
      paramString1 = l.a.a(paramString1, (Map)localHashMap, false, "");
      ae.d(g.b(this.DSg), "invoke callback: " + paramString2 + ", " + paramString1);
      g.c(this.DSg).post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214027);
          Object localObject = this.DSi.DSg;
          String str = paramString1;
          d.g.b.p.g(str, "resp");
          localObject = g.a((g)localObject, str).getObject("__params");
          this.DSi.DSh.call(g.d(this.DSi.DSg).getGlobalObject(), g.d(this.DSi.DSg).newV8Array().push((V8Value)localObject));
          AppMethodBeat.o(214027);
        }
      });
      AppMethodBeat.o(214028);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/eclipsesource/v8/V8Object;", "kotlin.jvm.PlatformType", "parameters", "Lcom/eclipsesource/v8/V8Array;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<V8Array, V8Object>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class f
    implements x.a
  {
    f(g paramg, V8Function paramV8Function) {}
    
    public final int a(int paramInt1, final int paramInt2, final String paramString, com.tencent.mm.ak.b paramb, n paramn)
    {
      AppMethodBeat.i(214034);
      d.g.b.p.h(paramb, "rr");
      d.g.b.p.h(paramn, "<anonymous parameter 4>");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        g.c(this.DSg).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(214032);
            V8Function localV8Function = this.DSl.okc;
            V8Object localV8Object = g.d(this.DSl.DSg).getGlobalObject();
            V8Array localV8Array = g.d(this.DSl.DSg).newV8Array();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("err_code", paramInt2);
            localJSONObject.put("err_msg", "fail");
            localV8Function.call(localV8Object, localV8Array.push(localJSONObject.toString()));
            AppMethodBeat.o(214032);
          }
        });
        AppMethodBeat.o(214034);
        return 0;
      }
      paramb = paramb.aEV();
      paramString = paramb;
      if (!(paramb instanceof nl)) {
        paramString = null;
      }
      paramString = (nl)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(214034);
        return 0;
      }
      ae.i(g.b(this.DSg), "reportCgi resp_json=" + paramString.FZL);
      g.c(this.DSg).post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214033);
          this.DSl.okc.call(g.d(this.DSl.DSg).getGlobalObject(), g.d(this.DSl.DSg).newV8Array().push(paramString.FZL));
          AppMethodBeat.o(214033);
        }
      });
      AppMethodBeat.o(214034);
      return 0;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "parameters", "Lcom/eclipsesource/v8/V8Array;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<V8Array, String>
  {
    g(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.g
 * JD-Core Version:    0.7.0.1
 */