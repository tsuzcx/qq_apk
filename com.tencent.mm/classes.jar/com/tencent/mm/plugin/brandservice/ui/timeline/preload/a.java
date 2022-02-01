package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.ax.c.a;
import com.tencent.mm.plugin.ay.c.b;
import com.tencent.mm.plugin.webview.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "configPreFetcher", "", "id", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "configWxPrefetcherClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "appId", "dispatchEvent", "", "url", "event", "data", "onConfigClient", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.az.d
{
  private static final kotlin.j<String> vKZ;
  public static final a vQl;
  private String pjl;
  private final MMKVSlotManager vKT;
  
  static
  {
    AppMethodBeat.i(303137);
    vQl = new a((byte)0);
    vKZ = kotlin.k.cm((kotlin.g.a.a)b.vQm);
    AppMethodBeat.o(303137);
  }
  
  public a()
  {
    AppMethodBeat.i(303109);
    this.pjl = "wxa06c02b5c00ff39b";
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__WebJsEngineLocalData__");
    s.s(localMultiProcessMMKV, "getMMKV(\"__WebJsEngineLocalData__\")");
    this.vKT = new MMKVSlotManager(localMultiProcessMMKV, 15552000L);
    AppMethodBeat.o(303109);
  }
  
  private static final void a(a parama, String paramString1, g paramg, b paramb, com.tencent.mm.plugin.appbrand.appcache.q paramq, String paramString2)
  {
    AppMethodBeat.i(303124);
    s.u(parama, "this$0");
    s.u(paramString1, "$id");
    s.u(paramb, "$onCompleted");
    s.u(paramq, "$pkg");
    ((Map)parama.ipt()).put(paramString1, Integer.valueOf(paramg.czh()));
    s.s(paramg, "this@apply");
    paramb.invoke(paramg);
    if ((paramq instanceof Closeable)) {}
    for (parama = (Closeable)paramq;; parama = null)
    {
      IO.safeClose(parama);
      AppMethodBeat.o(303124);
      return;
    }
  }
  
  private final void c(i parami, String paramString)
  {
    AppMethodBeat.i(303114);
    new com.tencent.mm.plugin.ax.p((com.tencent.mm.plugin.ax.q)new d(paramString, this)).l(parami);
    AppMethodBeat.o(303114);
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.q deF()
  {
    boolean bool = true;
    AppMethodBeat.i(303151);
    Object localObject = com.tencent.mm.plugin.ay.c.Wmq;
    localObject = com.tencent.mm.plugin.webcanvas.k.WkZ;
    if (com.tencent.mm.plugin.webcanvas.k.hBF() == 1) {}
    for (;;)
    {
      localObject = com.tencent.mm.plugin.ay.c.Wmq;
      localObject = c.b.a(c.b.b("prefetcher/bizAd.wspkg", bool, c.b.bih(this.pjl), this.pjl), (kotlin.g.a.q)new c(this), null, false, 12);
      AppMethodBeat.o(303151);
      return localObject;
      bool = false;
    }
  }
  
  public final boolean o(final String paramString1, final String paramString2, final String paramString3, String paramString4)
  {
    AppMethodBeat.i(303158);
    s.u(paramString3, "event");
    if (paramString1 == null)
    {
      AppMethodBeat.o(303158);
      return false;
    }
    if (!Util.isEqual(this.pjl, paramString1))
    {
      AppMethodBeat.o(303158);
      return false;
    }
    paramString2 = (CharSequence)paramString4;
    int i;
    if ((paramString2 == null) || (n.bp(paramString2)))
    {
      i = 1;
      if (i == 0) {
        break label344;
      }
      paramString2 = "";
      label69:
      if (ipt().containsKey(paramString1)) {
        break label381;
      }
      paramString2 = (b)new e(this, paramString3, paramString1, paramString2);
      s.u(paramString1, "id");
      s.u(paramString2, "onCompleted");
    }
    for (;;)
    {
      try
      {
        paramString3 = ips().sSV.czj();
        s.s(paramString3, "this");
        c((i)paramString3, paramString1);
        com.tencent.mm.plugin.ay.c.a(ips(), paramString3, s.X("AdWebPrefetcherManifest#", paramString1), "manifest", null, nP("manifest", this.pjl), 8);
        paramString3 = deF();
        if (paramString3 != null)
        {
          paramString4 = ips().sSV.czj();
          s.s(paramString4, "this");
          i locali = (i)paramString4;
          c(locali, paramString1);
          new com.tencent.mm.plugin.ax.j((com.tencent.mm.plugin.ax.k)new f(this)).l(locali);
          new com.tencent.mm.plugin.ax.d((com.tencent.mm.plugin.ax.e)new a.g()).l(locali);
          com.tencent.mm.plugin.ay.c.a(ips(), paramString4, s.X("AdWebPrefetcher#", paramString1), "prefetcher", null, nP("prefetcher", this.pjl), 8);
          Log.i("MicroMsg.AdWebPrefetcherJsEngineInterceptor", s.X("configPreFetcher ", "/prefetcher.js"));
          paramString4.evaluateJavascript(r.a(paramString3, "/prefetcher.js"), new a..ExternalSyntheticLambda0(this, paramString1, paramString4, paramString2, paramString3));
        }
      }
      catch (Exception paramString2)
      {
        label344:
        Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", (Throwable)paramString2, s.X("configPreFetcher id=", paramString1), new Object[0]);
        continue;
      }
      AppMethodBeat.o(303158);
      return true;
      i = 0;
      break;
      paramString2 = s.X(",", paramString4);
      break label69;
      label381:
      c.a.a((com.tencent.mm.plugin.ax.c)ips(), paramString3, "{target:'" + paramString1 + '\'' + paramString2 + '}', null, 4);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "TAG", "", "cgiAllowList", "getCgiAllowList", "()Ljava/lang/String;", "cgiAllowList$delegate", "Lkotlin/Lazy;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final b vQm;
    
    static
    {
      AppMethodBeat.i(302879);
      vQm = new b();
      AppMethodBeat.o(302879);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "assetsVersion", "", "resVersion", "resPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.q<Integer, Integer, com.tencent.mm.plugin.appbrand.appcache.q, Boolean>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$configWxPrefetcherClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "dispatch", "", "eventType", "event", "cb", "Landroid/webkit/ValueCallback;", "setMinBizPkgVersion", "version", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.ax.q
  {
    private final String id;
    
    d(String paramString, a parama)
    {
      AppMethodBeat.i(302881);
      this.id = this.vQo;
      AppMethodBeat.o(302881);
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(302890);
      s.u(paramString1, "eventType");
      s.u(paramString2, "event");
      jdField_this.ips().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(302890);
    }
    
    public final String getId()
    {
      return this.id;
    }
    
    public final void setMinBizPkgVersion(int paramInt) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<g, ah>
  {
    e(a parama, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.plugin.ax.k
  {
    f(a parama) {}
    
    public final boolean aS(int paramInt, String paramString)
    {
      AppMethodBeat.i(302907);
      s.u(paramString, "cgiUrl");
      a.a locala = a.vQl;
      if (!n.a((CharSequence)a.deG().getValue(), (CharSequence)paramString, false))
      {
        Log.i("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "do cgi cmdId=" + paramInt + ", cgiUrl=" + paramString + " not allowed!!");
        AppMethodBeat.o(302907);
        return false;
      }
      AppMethodBeat.o(302907);
      return true;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(302957);
      s.u(paramString1, "eventType");
      s.u(paramString2, "event");
      this.vQn.ips().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(302957);
    }
    
    public final f ddL()
    {
      AppMethodBeat.i(302945);
      f localf = (f)new a();
      AppMethodBeat.o(302945);
      return localf;
    }
    
    public final void fM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(302951);
      s.u(paramString1, "func");
      s.u(paramString2, "message");
      AppMethodBeat.o(302951);
    }
    
    public final int getBasePkgVersion()
    {
      AppMethodBeat.i(302891);
      int i = com.tencent.mm.plugin.webview.l.a.h(this.vQn.ips().iox());
      AppMethodBeat.o(302891);
      return i;
    }
    
    public final int getBizPkgVersion()
    {
      AppMethodBeat.i(302898);
      Object localObject = this.vQn.deF();
      if (localObject == null)
      {
        AppMethodBeat.o(302898);
        return 0;
      }
      int i = com.tencent.mm.plugin.webview.l.a.h((com.tencent.mm.plugin.appbrand.appcache.q)localObject);
      if ((localObject instanceof Closeable)) {}
      for (localObject = (Closeable)localObject;; localObject = null)
      {
        IO.safeClose((Closeable)localObject);
        AppMethodBeat.o(302898);
        return i;
      }
    }
    
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(302926);
      s.u(paramString, "key");
      try
      {
        String str = a.a(this.vQn).decodeString(paramString, "");
        Log.d("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "getLocalData:" + paramString + ", " + str);
        paramString = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", (Throwable)localException, s.X("getLocalData:", paramString), new Object[0]);
          paramString = null;
        }
      }
      AppMethodBeat.o(302926);
      return paramString;
    }
    
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(302916);
      s.u(paramString1, "key");
      s.u(paramString2, "data");
      try
      {
        ((MultiProcessMMKV)a.a(this.vQn).getSlotForWrite()).encode(paramString1, paramString2);
        Log.d("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "setLocalData:" + paramString1 + ", " + paramString2);
        AppMethodBeat.o(302916);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
        AppMethodBeat.o(302916);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$1$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", "ct", "Landroid/content/Context;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements f
    {
      public final void a(com.tencent.mm.plugin.webview.jsapi.p paramp, com.tencent.mm.plugin.webview.jsapi.c paramc) {}
      
      public final void fR(Context paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a
 * JD-Core Version:    0.7.0.1
 */