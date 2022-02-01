package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.av.c.a;
import com.tencent.mm.plugin.av.e;
import com.tencent.mm.plugin.av.j;
import com.tencent.mm.plugin.av.k;
import com.tencent.mm.plugin.aw.c;
import com.tencent.mm.plugin.aw.c.b;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import java.io.Closeable;
import java.util.HashMap;
import kotlin.f;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "configPreFetcher", "", "id", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "configWxPrefetcherClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "appId", "dispatchEvent", "", "url", "event", "data", "onConfigClient", "Companion", "plugin-brandservice_release"})
public final class a
  extends com.tencent.mm.plugin.ax.d
{
  private static final f sFt;
  public static final a sKl;
  private String mpE;
  private final MMKVSlotManager sFn;
  
  static
  {
    AppMethodBeat.i(267079);
    sKl = new a((byte)0);
    sFt = kotlin.g.ar((kotlin.g.a.a)b.sKm);
    AppMethodBeat.o(267079);
  }
  
  public a()
  {
    AppMethodBeat.i(267078);
    this.mpE = "wxa06c02b5c00ff39b";
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__WebJsEngineLocalData__");
    kotlin.g.b.p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…_WebJsEngineLocalData__\")");
    this.sFn = new MMKVSlotManager(localMultiProcessMMKV, 15552000L);
    AppMethodBeat.o(267078);
  }
  
  private final void c(i parami, final String paramString)
  {
    AppMethodBeat.i(267074);
    new com.tencent.mm.plugin.av.p((com.tencent.mm.plugin.av.q)new e(this, paramString)).h(parami);
    AppMethodBeat.o(267074);
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.p cBu()
  {
    boolean bool = true;
    AppMethodBeat.i(267072);
    Object localObject = c.Pwj;
    localObject = m.PuL;
    if (m.gPr() == 1) {}
    for (;;)
    {
      localObject = c.Pwj;
      localObject = c.b.a(c.b.a("prefetcher/bizAd.wspkg", bool, c.b.biz(this.mpE), this.mpE), (kotlin.g.a.q)new c(this), null, false, 12);
      AppMethodBeat.o(267072);
      return localObject;
      bool = false;
    }
  }
  
  public final boolean o(final String paramString1, final String paramString2, final String paramString3, String paramString4)
  {
    AppMethodBeat.i(267076);
    kotlin.g.b.p.k(paramString3, "event");
    if (paramString1 == null)
    {
      AppMethodBeat.o(267076);
      return false;
    }
    if (!Util.isEqual(this.mpE, paramString1))
    {
      AppMethodBeat.o(267076);
      return false;
    }
    paramString2 = (CharSequence)paramString4;
    int i;
    if ((paramString2 == null) || (kotlin.n.n.ba(paramString2)))
    {
      i = 1;
      if (i == 0) {
        break label183;
      }
      paramString2 = "";
      label68:
      if (gQc().containsKey(paramString1)) {
        break label388;
      }
      paramString2 = (kotlin.g.a.b)new f(this, paramString3, paramString1, paramString2);
      kotlin.g.b.p.k(paramString1, "id");
      kotlin.g.b.p.k(paramString2, "onCompleted");
    }
    for (;;)
    {
      try
      {
        paramString3 = gQb().bYV();
        kotlin.g.b.p.j(paramString3, "this");
        c((i)paramString3, paramString1);
        c.a(gQb(), paramString3, "AdWebPrefetcherManifest#".concat(String.valueOf(paramString1)), "manifest", null, md("manifest", this.mpE), 8);
        paramString3 = cBu();
        if (paramString3 != null) {
          continue;
        }
      }
      catch (Exception paramString2)
      {
        label183:
        i locali;
        Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", (Throwable)paramString2, "configPreFetcher id=".concat(String.valueOf(paramString1)), new Object[0]);
        continue;
      }
      AppMethodBeat.o(267076);
      return true;
      i = 0;
      break;
      paramString2 = ",".concat(String.valueOf(paramString4));
      break label68;
      paramString4 = gQb().bYV();
      kotlin.g.b.p.j(paramString4, "this");
      locali = (i)paramString4;
      c(locali, paramString1);
      new j((k)new g(this)).h(locali);
      new com.tencent.mm.plugin.av.d((e)new h()).h(locali);
      c.a(gQb(), paramString4, "AdWebPrefetcher#".concat(String.valueOf(paramString1)), "prefetcher", null, md("prefetcher", this.mpE), 8);
      Log.i("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "configPreFetcher ".concat(String.valueOf("/prefetcher.js")));
      paramString4.evaluateJavascript(com.tencent.mm.plugin.webview.l.a.a(paramString3, "/prefetcher.js"), (ValueCallback)new d(paramString4, this, paramString1, paramString3, paramString2));
      continue;
      label388:
      c.a.a(gQb(), paramString3, "{target:'" + paramString1 + '\'' + paramString2 + '}', null, 4);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "TAG", "", "cgiAllowList", "getCgiAllowList", "()Ljava/lang/String;", "cgiAllowList$delegate", "Lkotlin/Lazy;", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    public static final b sKm;
    
    static
    {
      AppMethodBeat.i(257317);
      sKm = new b();
      AppMethodBeat.o(257317);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "assetsVersion", "", "resVersion", "resPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, Integer, com.tencent.mm.plugin.appbrand.appcache.p, Boolean>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$configPreFetcher$2$1"})
  static final class d<T>
    implements ValueCallback<String>
  {
    d(com.tencent.mm.plugin.appbrand.m.g paramg, a parama, String paramString, com.tencent.mm.plugin.appbrand.appcache.p paramp, kotlin.g.a.b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$configWxPrefetcherClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "dispatch", "", "eventType", "event", "cb", "Landroid/webkit/ValueCallback;", "setMinBizPkgVersion", "version", "", "plugin-brandservice_release"})
  public static final class e
    implements com.tencent.mm.plugin.av.q
  {
    private final String id;
    
    e(String paramString)
    {
      this.id = localObject;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(257589);
      kotlin.g.b.p.k(paramString1, "eventType");
      kotlin.g.b.p.k(paramString2, "event");
      this.sKn.gQb().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(257589);
    }
    
    public final String getId()
    {
      return this.id;
    }
    
    public final void setMinBizPkgVersion(int paramInt) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.m.g, x>
  {
    f(a parama, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "plugin-brandservice_release"})
  public static final class g
    implements k
  {
    public final boolean aF(int paramInt, String paramString)
    {
      AppMethodBeat.i(259794);
      kotlin.g.b.p.k(paramString, "cgiUrl");
      Object localObject = a.sKl;
      localObject = a.cBv();
      a.a locala = a.sKl;
      if (!kotlin.n.n.a((CharSequence)((f)localObject).getValue(), (CharSequence)paramString, false))
      {
        Log.i("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "do cgi cmdId=" + paramInt + ", cgiUrl=" + paramString + " not allowed!!");
        AppMethodBeat.o(259794);
        return false;
      }
      AppMethodBeat.o(259794);
      return true;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(259802);
      kotlin.g.b.p.k(paramString1, "eventType");
      kotlin.g.b.p.k(paramString2, "event");
      this.sKn.gQb().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(259802);
    }
    
    public final com.tencent.mm.plugin.webview.d.d cAI()
    {
      AppMethodBeat.i(259798);
      com.tencent.mm.plugin.webview.d.d locald = (com.tencent.mm.plugin.webview.d.d)new a();
      AppMethodBeat.o(259798);
      return locald;
    }
    
    public final void fs(String paramString1, String paramString2)
    {
      AppMethodBeat.i(259799);
      kotlin.g.b.p.k(paramString1, "func");
      kotlin.g.b.p.k(paramString2, "message");
      AppMethodBeat.o(259799);
    }
    
    public final int getBasePkgVersion()
    {
      AppMethodBeat.i(259788);
      int i = com.tencent.mm.plugin.webview.l.a.b(this.sKn.gQb().gPi());
      AppMethodBeat.o(259788);
      return i;
    }
    
    public final int getBizPkgVersion()
    {
      AppMethodBeat.i(259791);
      com.tencent.mm.plugin.appbrand.appcache.p localp2 = this.sKn.cBu();
      if (localp2 != null)
      {
        int i = com.tencent.mm.plugin.webview.l.a.b(localp2);
        com.tencent.mm.plugin.appbrand.appcache.p localp1 = localp2;
        if (!(localp2 instanceof Closeable)) {
          localp1 = null;
        }
        IO.safeClose((Closeable)localp1);
        AppMethodBeat.o(259791);
        return i;
      }
      AppMethodBeat.o(259791);
      return 0;
    }
    
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(259797);
      kotlin.g.b.p.k(paramString, "key");
      try
      {
        String str = a.a(this.sKn).decodeString(paramString, "");
        Log.d("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "getLocalData:" + paramString + ", " + str);
        paramString = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", (Throwable)localException, "getLocalData:".concat(String.valueOf(paramString)), new Object[0]);
          paramString = null;
        }
      }
      AppMethodBeat.o(259797);
      return paramString;
    }
    
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(259796);
      kotlin.g.b.p.k(paramString1, "key");
      kotlin.g.b.p.k(paramString2, "data");
      try
      {
        ((MultiProcessMMKV)a.a(this.sKn).getSlotForWrite()).encode(paramString1, paramString2);
        Log.d("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "setLocalData:" + paramString1 + ", " + paramString2);
        AppMethodBeat.o(259796);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
        AppMethodBeat.o(259796);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$1$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", "ct", "Landroid/content/Context;", "plugin-brandservice_release"})
    public static final class a
      implements com.tencent.mm.plugin.webview.d.d
    {
      public final void a(com.tencent.mm.plugin.webview.d.n paramn, com.tencent.mm.plugin.webview.d.b paramb) {}
      
      public final void eU(Context paramContext) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$2", "Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;", "deleteAd", "", "msgId", "", "forceDelete", "", "getAdContext", "from", "", "getInfo", "key", "replaceAdData", "data", "plugin-brandservice_release"})
  public static final class h
    implements e
  {
    public final void deleteAd(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(259351);
      kotlin.g.b.p.k(paramString, "msgId");
      long l = Util.safeParseLong(paramString);
      if (l == 0L)
      {
        AppMethodBeat.o(259351);
        return;
      }
      if (paramBoolean)
      {
        af.bjB().UI(l);
        AppMethodBeat.o(259351);
        return;
      }
      paramString = af.bjB().Uw(l);
      if (paramString != null)
      {
        if (paramString.field_isRead != 1) {
          af.bjB().UI(l);
        }
        AppMethodBeat.o(259351);
        return;
      }
      AppMethodBeat.o(259351);
    }
    
    public final String getAdContext(int paramInt)
    {
      AppMethodBeat.i(259348);
      Object localObject = r.VcW;
      localObject = r.asl(paramInt);
      AppMethodBeat.o(259348);
      return localObject;
    }
    
    public final void replaceAdData(String paramString)
    {
      AppMethodBeat.i(259346);
      kotlin.g.b.p.k(paramString, "data");
      r localr = r.VcW;
      r.replaceAdData(paramString);
      AppMethodBeat.o(259346);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a
 * JD-Core Version:    0.7.0.1
 */