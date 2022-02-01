package com.tencent.mm.plugin.ac;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.appbrand.z.p.a;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.q;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineAPI;", "", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AbstractMultiContextJsEngine;", "engine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AbstractMultiContextJsEngine;Lcom/tencent/mm/appbrand/v8/V8ContextEngine;)V", "JSON", "Lcom/eclipsesource/v8/V8Object;", "kotlin.jvm.PlatformType", "getJSON", "()Lcom/eclipsesource/v8/V8Object;", "JSON$delegate", "Lkotlin/Lazy;", "TAG", "", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "getLocalData", "key", "idkey", "", "id", "", "value", "idkeyList", "list", "invoke", "params", "callback", "Lcom/eclipsesource/v8/V8Function;", "kv", "", "data", "reportCgi", "businessId", "", "reqJson", "setContext", "ct", "Landroid/content/Context;", "setLocalData", "userAgent", "asCallbacker", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "parseJSON", "stringify", "use", "R", "T", "block", "Lkotlin/Function1;", "(Lcom/eclipsesource/v8/V8Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "webview-sdk_release"})
public abstract class e
{
  public static final e.a DAg = new e.a((byte)0);
  private final ar DAd;
  private final com.tencent.mm.plugin.appbrand.jsruntime.a DAe;
  private final com.tencent.mm.appbrand.v8.m DAf;
  private final d.f Dyf;
  private final String TAG;
  private final d.f okd;
  
  public e(com.tencent.mm.plugin.appbrand.jsruntime.a parama, com.tencent.mm.appbrand.v8.m paramm)
  {
    this.DAe = parama;
    this.DAf = paramm;
    this.TAG = "MicroMsg.WebJsEngineAPI";
    this.okd = d.g.O((d.g.a.a)e.h.DAo);
    parama = ax.aQz("__WebJsEngineLocalData__");
    d.g.b.p.g(parama, "MultiProcessMMKV.getMMKV…_WebJsEngineLocalData__\")");
    this.DAd = new ar(parama, 15552000L);
    this.Dyf = d.g.O((d.g.a.a)new b(this));
  }
  
  private static <T extends V8Object, R> R a(T paramT, d.g.a.b<? super T, ? extends R> paramb)
  {
    paramb = paramb.invoke(paramT);
    paramT.release();
    return paramb;
  }
  
  private final String a(V8Object paramV8Object)
  {
    paramV8Object = a((V8Object)this.DAf.newV8Array().push((V8Value)paramV8Object), (d.g.a.b)new g(this));
    d.g.b.p.g(paramV8Object, "engine.newV8Array().push…ngify\", parameters)\n    }");
    return (String)paramV8Object;
  }
  
  public abstract com.tencent.mm.plugin.webview.c.f eLg();
  
  @JavascriptInterface
  public final String getLocalData(String paramString)
  {
    d.g.b.p.h(paramString, "key");
    try
    {
      String str = ((ax)this.DAd.fjV()).decodeString(paramString, "");
      ad.d(this.TAG, "getLocalData:" + paramString + ", " + str);
      return str;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "getLocalData:".concat(String.valueOf(paramString)), new Object[0]);
    }
    return null;
  }
  
  @JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    com.tencent.mm.plugin.report.service.g.yhR.n(paramLong1, paramLong2, paramLong3);
  }
  
  @JavascriptInterface
  public final void idkeyList(V8Object paramV8Object)
  {
    d.g.b.p.h(paramV8Object, "list");
    paramV8Object = com.tencent.mm.plugin.webview.k.a.b(new com.tencent.mm.ac.f(a(paramV8Object)), (d.g.a.m)e.d.DAl);
    com.tencent.mm.plugin.report.service.g.yhR.b(new ArrayList((Collection)paramV8Object), false);
  }
  
  @JavascriptInterface
  public final void invoke(V8Object paramV8Object, final V8Function paramV8Function)
  {
    d.g.b.p.h(paramV8Object, "params");
    d.g.b.p.h(paramV8Function, "callback");
    paramV8Object = a(paramV8Object);
    paramV8Function = paramV8Function.twin();
    ad.d(this.TAG, "invoke: ".concat(String.valueOf(paramV8Object)));
    com.tencent.mm.plugin.webview.c.f localf = eLg();
    d.g.b.p.g(paramV8Function, "callback");
    localf.a(paramV8Object, (com.tencent.mm.plugin.webview.c.b)new c(this, paramV8Function));
  }
  
  @JavascriptInterface
  public final void kv(int paramInt, String paramString)
  {
    d.g.b.p.h(paramString, "data");
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(paramInt, paramString);
  }
  
  @JavascriptInterface
  public final void reportCgi(Number paramNumber, String paramString, final V8Function paramV8Function)
  {
    d.g.b.p.h(paramNumber, "businessId");
    d.g.b.p.h(paramString, "reqJson");
    d.g.b.p.h(paramV8Function, "callback");
    paramV8Function = paramV8Function.twin();
    Object localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bx.a)new ni());
    ((b.a)localObject1).d((com.tencent.mm.bx.a)new nj());
    ((b.a)localObject1).Dl("/cgi-bin/mmbiz-bin/report/bizcommreport");
    ((b.a)localObject1).oP(4779);
    localObject1 = ((b.a)localObject1).aDC();
    Object localObject2 = ((com.tencent.mm.al.b)localObject1).aEE();
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizCommReportReq");
    }
    localObject2 = (ni)localObject2;
    ((ni)localObject2).FHn = paramNumber.intValue();
    ((ni)localObject2).FHo = paramString;
    ad.d(this.TAG, "reportCgi %s", new Object[] { paramString });
    x.a((com.tencent.mm.al.b)localObject1, (x.a)new f(this, paramV8Function));
  }
  
  public final void setContext(Context paramContext)
  {
    d.g.b.p.h(paramContext, "ct");
    eLg().br(paramContext);
  }
  
  @JavascriptInterface
  public final void setLocalData(String paramString1, String paramString2)
  {
    d.g.b.p.h(paramString1, "key");
    d.g.b.p.h(paramString2, "data");
    try
    {
      ((ax)this.DAd.fjV()).encode(paramString1, paramString2);
      ad.d(this.TAG, "setLocalData:" + paramString1 + ", " + paramString2);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
    }
  }
  
  @JavascriptInterface
  public final String userAgent()
  {
    Object localObject = aj.getContext();
    com.tencent.mm.plugin.webview.j.e.a locala = com.tencent.mm.plugin.webview.j.e.Etl;
    localObject = com.tencent.mm.plugin.appbrand.z.p.a((Context)localObject, com.tencent.mm.plugin.webview.j.e.a.eVQ(), (p.a)this.okd.getValue());
    ad.d(this.TAG, "userAgent=".concat(String.valueOf(localObject)));
    d.g.b.p.g(localObject, "userAgent");
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/eclipsesource/v8/V8Object;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<V8Object>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class c
    implements com.tencent.mm.plugin.webview.c.b
  {
    c(e parame, V8Function paramV8Function) {}
    
    public final void i(final String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(214188);
      HashMap localHashMap = new HashMap();
      Map localMap = (Map)localHashMap;
      d.g.b.p.g(paramString2, "ret");
      localMap.put("err_msg", paramString2);
      if (paramMap != null) {
        localHashMap.putAll(paramMap);
      }
      paramString1 = l.a.a(paramString1, (Map)localHashMap, false, "");
      ad.d(e.b(this.DAh), "invoke callback: " + paramString2 + ", " + paramString1);
      e.c(this.DAh).post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214187);
          Object localObject = this.DAj.DAh;
          String str = paramString1;
          d.g.b.p.g(str, "resp");
          localObject = e.a((e)localObject, str).getObject("__params");
          this.DAj.DAi.call(e.d(this.DAj.DAh).getGlobalObject(), e.d(this.DAj.DAh).newV8Array().push((V8Value)localObject));
          AppMethodBeat.o(214187);
        }
      });
      AppMethodBeat.o(214188);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/eclipsesource/v8/V8Object;", "kotlin.jvm.PlatformType", "parameters", "Lcom/eclipsesource/v8/V8Array;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<V8Array, V8Object>
  {
    e(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class f
    implements x.a
  {
    f(e parame, V8Function paramV8Function) {}
    
    public final int a(int paramInt1, final int paramInt2, final String paramString, com.tencent.mm.al.b paramb, n paramn)
    {
      AppMethodBeat.i(214194);
      d.g.b.p.h(paramb, "rr");
      d.g.b.p.h(paramn, "<anonymous parameter 4>");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        e.c(this.DAh).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(214192);
            V8Function localV8Function = this.DAm.oem;
            V8Object localV8Object = e.d(this.DAm.DAh).getGlobalObject();
            V8Array localV8Array = e.d(this.DAm.DAh).newV8Array();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("err_code", paramInt2);
            localJSONObject.put("err_msg", "fail");
            localV8Function.call(localV8Object, localV8Array.push(localJSONObject.toString()));
            AppMethodBeat.o(214192);
          }
        });
        AppMethodBeat.o(214194);
        return 0;
      }
      paramb = paramb.aEF();
      paramString = paramb;
      if (!(paramb instanceof nj)) {
        paramString = null;
      }
      paramString = (nj)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(214194);
        return 0;
      }
      ad.i(e.b(this.DAh), "reportCgi resp_json=" + paramString.FHp);
      e.c(this.DAh).post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214193);
          this.DAm.oem.call(e.d(this.DAm.DAh).getGlobalObject(), e.d(this.DAm.DAh).newV8Array().push(paramString.FHp));
          AppMethodBeat.o(214193);
        }
      });
      AppMethodBeat.o(214194);
      return 0;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "parameters", "Lcom/eclipsesource/v8/V8Array;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<V8Array, String>
  {
    g(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.e
 * JD-Core Version:    0.7.0.1
 */