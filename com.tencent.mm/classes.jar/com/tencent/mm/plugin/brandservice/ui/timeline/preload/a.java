package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ab.c.a;
import com.tencent.mm.plugin.ab.e;
import com.tencent.mm.plugin.ab.j;
import com.tencent.mm.plugin.ab.k;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.ac.c.b;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "configPreFetcher", "", "id", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "dispatchEvent", "", "appId", "url", "event", "data", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "Companion", "plugin-brandservice_release"})
public final class a
  extends com.tencent.mm.plugin.ad.d
{
  public static final a.a pAc;
  private static final f pwa;
  private String jzY;
  private final MMKVSlotManager pvV;
  
  static
  {
    AppMethodBeat.i(195543);
    pAc = new a.a((byte)0);
    pwa = kotlin.g.ah((kotlin.g.a.a)a.b.pAd);
    AppMethodBeat.o(195543);
  }
  
  public a()
  {
    AppMethodBeat.i(195542);
    this.jzY = "wxa06c02b5c00ff39b";
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("__WebJsEngineLocalData__");
    kotlin.g.b.p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…_WebJsEngineLocalData__\")");
    this.pvV = new MMKVSlotManager(localMultiProcessMMKV, 15552000L);
    AppMethodBeat.o(195542);
  }
  
  public final boolean S(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(195541);
    kotlin.g.b.p.h(paramString2, "event");
    if (paramString1 == null)
    {
      AppMethodBeat.o(195541);
      return false;
    }
    if (!Util.isEqual(this.jzY, paramString1))
    {
      AppMethodBeat.o(195541);
      return false;
    }
    Object localObject1 = (CharSequence)paramString3;
    int i;
    if ((localObject1 == null) || (kotlin.n.n.aL((CharSequence)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label229;
      }
      paramString3 = "";
      label70:
      if (fXp().containsKey(paramString1)) {
        break label453;
      }
      paramString2 = (kotlin.g.a.b)new g(this, paramString2, paramString1, paramString3);
      kotlin.g.b.p.h(paramString1, "id");
      kotlin.g.b.p.h(paramString2, "onCompleted");
    }
    for (;;)
    {
      try
      {
        paramString3 = fXo().bME();
        localObject1 = new com.tencent.mm.plugin.ab.p((com.tencent.mm.plugin.ab.q)new e(this, paramString1));
        kotlin.g.b.p.g(paramString3, "this");
        ((com.tencent.mm.plugin.ab.p)localObject1).f((i)paramString3);
        c.a(fXo(), paramString3, "AdWebPrefetcherManifest#".concat(String.valueOf(paramString1)), "manifest", null, lE("manifest", this.jzY), 8);
        ((Map)fXp()).put(paramString1, Integer.valueOf(paramString3.bMC()));
        paramString3 = cnt();
        if (paramString3 != null) {
          continue;
        }
      }
      catch (Exception paramString2)
      {
        label229:
        Object localObject2;
        Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", (Throwable)paramString2, "configPreFetcher id=".concat(String.valueOf(paramString1)), new Object[0]);
        continue;
      }
      AppMethodBeat.o(195541);
      return true;
      i = 0;
      break;
      paramString3 = ",".concat(String.valueOf(paramString3));
      break label70;
      localObject1 = fXo().bME();
      kotlin.g.b.p.g(localObject1, "this");
      localObject2 = (i)localObject1;
      new com.tencent.mm.plugin.ab.p((com.tencent.mm.plugin.ab.q)new h(paramString1)).f((i)localObject2);
      new j((k)new i(this)).f((i)localObject2);
      new com.tencent.mm.plugin.ab.d((e)new a.j()).f((i)localObject2);
      c.a(fXo(), (com.tencent.mm.plugin.appbrand.m.g)localObject1, "AdWebPrefetcher#".concat(String.valueOf(paramString1)), "prefetcher", null, lE("prefetcher", this.jzY), 8);
      Log.i("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "configPreFetcher ".concat(String.valueOf("/prefetcher.js")));
      localObject2 = c.IBU;
      ((com.tencent.mm.plugin.appbrand.m.g)localObject1).evaluateJavascript(c.b.a(paramString3, "/prefetcher.js"), (ValueCallback)new f((com.tencent.mm.plugin.appbrand.m.g)localObject1, this, paramString1, paramString3, paramString2));
      continue;
      label453:
      c.a.a(fXo(), paramString2, "{target:'" + paramString1 + '\'' + paramString3 + '}', null, 4);
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.p cnt()
  {
    AppMethodBeat.i(195540);
    Object localObject = c.IBU;
    localObject = m.IAG;
    boolean bool;
    if (m.fWJ() == 1)
    {
      bool = true;
      localObject = m.IAG;
      if (m.fWJ() != 1) {
        break label93;
      }
      localObject = m.IAG;
    }
    label93:
    for (localObject = m.aWI(this.jzY);; localObject = m.IAG.aWH(this.jzY))
    {
      localObject = c.b.a(c.b.a("prefetcher/bizAd.wspkg", bool, (String)localObject, this.jzY), (kotlin.g.a.q)new c(this), (kotlin.g.a.q)a.d.pAf, true);
      AppMethodBeat.o(195540);
      return localObject;
      bool = false;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "assetsVersion", "", "resVersion", "resPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, Integer, com.tencent.mm.plugin.appbrand.appcache.p, Boolean>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$configPreFetcher$1$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "plugin-brandservice_release"})
  public static final class e
    implements com.tencent.mm.plugin.ab.q
  {
    private final String id;
    
    e(a parama, String paramString)
    {
      AppMethodBeat.i(195525);
      this.id = paramString1;
      AppMethodBeat.o(195525);
    }
    
    public final String getId()
    {
      return this.id;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$configPreFetcher$2$1"})
  static final class f<T>
    implements ValueCallback<String>
  {
    f(com.tencent.mm.plugin.appbrand.m.g paramg, a parama, String paramString, com.tencent.mm.plugin.appbrand.appcache.p paramp, kotlin.g.a.b paramb) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.m.g, x>
  {
    g(a parama, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "plugin-brandservice_release"})
  public static final class h
    implements com.tencent.mm.plugin.ab.q
  {
    private final String id;
    
    h(String paramString)
    {
      this.id = paramString;
    }
    
    public final String getId()
    {
      return this.id;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$2", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "plugin-brandservice_release"})
  public static final class i
    implements k
  {
    public final boolean aD(int paramInt, String paramString)
    {
      AppMethodBeat.i(195530);
      kotlin.g.b.p.h(paramString, "cgiUrl");
      Object localObject = a.pAc;
      localObject = a.cnu();
      a.a locala = a.pAc;
      if (!kotlin.n.n.a((CharSequence)((f)localObject).getValue(), (CharSequence)paramString, false))
      {
        Log.i("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "do cgi cmdId=" + paramInt + ", cgiUrl=" + paramString + " not allowed!!");
        AppMethodBeat.o(195530);
        return false;
      }
      AppMethodBeat.o(195530);
      return true;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(195535);
      kotlin.g.b.p.h(paramString1, "eventType");
      kotlin.g.b.p.h(paramString2, "event");
      this.pAe.fXo().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(195535);
    }
    
    public final com.tencent.mm.plugin.webview.d.d cna()
    {
      AppMethodBeat.i(195533);
      com.tencent.mm.plugin.webview.d.d locald = (com.tencent.mm.plugin.webview.d.d)new a();
      AppMethodBeat.o(195533);
      return locald;
    }
    
    public final void fe(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195534);
      kotlin.g.b.p.h(paramString1, "func");
      kotlin.g.b.p.h(paramString2, "message");
      AppMethodBeat.o(195534);
    }
    
    public final int getBasePkgVersion()
    {
      AppMethodBeat.i(195528);
      int i = this.pAe.fXo().fWz().version();
      AppMethodBeat.o(195528);
      return i;
    }
    
    public final int getBizPkgVersion()
    {
      AppMethodBeat.i(195529);
      com.tencent.mm.plugin.appbrand.appcache.p localp = this.pAe.cnt();
      if (localp != null)
      {
        int i = localp.version();
        AppMethodBeat.o(195529);
        return i;
      }
      AppMethodBeat.o(195529);
      return 0;
    }
    
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(195532);
      kotlin.g.b.p.h(paramString, "key");
      try
      {
        String str = ((MultiProcessMMKV)a.a(this.pAe).getSlot()).decodeString(paramString, "");
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
      AppMethodBeat.o(195532);
      return paramString;
    }
    
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195531);
      kotlin.g.b.p.h(paramString1, "key");
      kotlin.g.b.p.h(paramString2, "data");
      try
      {
        ((MultiProcessMMKV)a.a(this.pAe).getSlot()).encode(paramString1, paramString2);
        Log.d("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "setLocalData:" + paramString1 + ", " + paramString2);
        AppMethodBeat.o(195531);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
        AppMethodBeat.o(195531);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$2$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", "ct", "Landroid/content/Context;", "plugin-brandservice_release"})
    public static final class a
      implements com.tencent.mm.plugin.webview.d.d
    {
      public final void a(com.tencent.mm.plugin.webview.d.n paramn, com.tencent.mm.plugin.webview.d.b paramb) {}
      
      public final void eQ(Context paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a
 * JD-Core Version:    0.7.0.1
 */