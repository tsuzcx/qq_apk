package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ab.j;
import com.tencent.mm.plugin.ab.k;
import com.tencent.mm.plugin.ab.q;
import com.tencent.mm.plugin.ab.r;
import com.tencent.mm.plugin.ab.s;
import com.tencent.mm.plugin.ad.e;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Map;
import kotlin.f;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "localData", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getLocalData", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "localData$delegate", "Lkotlin/Lazy;", "create", "", "id", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "inject", "", "type", "", "script", "onCallback", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "domain", "Companion", "plugin-brandservice_release"})
public final class l
  extends com.tencent.mm.plugin.ad.d
{
  public static final l.a pCE;
  private String jzY;
  private final f pCD;
  
  static
  {
    AppMethodBeat.i(195619);
    pCE = new l.a((byte)0);
    AppMethodBeat.o(195619);
  }
  
  public l()
  {
    AppMethodBeat.i(195618);
    this.jzY = "__Mp_Prefetcher_FakeAppId";
    this.pCD = kotlin.g.ah((kotlin.g.a.a)l.d.pCI);
    AppMethodBeat.o(195618);
  }
  
  public final boolean a(final com.tencent.mm.plugin.ad.a parama, String paramString, kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(195617);
    kotlin.g.b.p.h(parama, "manifest");
    kotlin.g.b.p.h(paramString, "script");
    kotlin.g.b.p.h(paramb, "onCallback");
    Object localObject = parama.ICt.LQV;
    kotlin.g.b.p.g(localObject, "manifest.manifest.ManifestUrl");
    localObject = e.aWU((String)localObject);
    if (!fXp().containsKey(localObject))
    {
      paramString = (kotlin.g.a.b)new l.b(paramString, paramb);
      parama = parama.ICs.LQP;
      Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "create domain:" + parama + '#' + (String)localObject);
    }
    for (;;)
    {
      try
      {
        paramb = fXo().bME();
        kotlin.g.b.p.g(paramb, "this");
        com.tencent.mm.plugin.appbrand.m.i locali = (com.tencent.mm.plugin.appbrand.m.i)paramb;
        kotlin.g.b.p.g(parama, "domain");
        new com.tencent.mm.plugin.ab.p((q)new e((String)localObject)).f(locali);
        new r((s)new l.f()).f(locali);
        new j((k)new g(this, parama)).f(locali);
        new com.tencent.mm.plugin.ab.i((com.tencent.mm.plugin.ab.c)new h(this)).f(locali);
        com.tencent.mm.plugin.ac.c.a(fXo(), paramb, "MpWebPrefetcherManifest#".concat(String.valueOf(localObject)), "manifest", null, lE("manifest", this.jzY), 8);
        ((Map)fXp()).put(localObject, Integer.valueOf(paramb.bMC()));
        paramString.invoke(paramb);
        AppMethodBeat.o(195617);
        return true;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("MicroMsg.MpWebPrefetcherJsEngineInterceptor", (Throwable)parama, "create id=".concat(String.valueOf(localObject)), new Object[0]);
        continue;
      }
      parama = fXo();
      localObject = fXp().get(localObject);
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      kotlin.g.b.p.g(localObject, "contextMap[id]!!");
      parama.xX(((Number)localObject).intValue()).evaluateJavascript(paramString, (ValueCallback)new l.c(paramb));
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "plugin-brandservice_release"})
  public static final class e
    implements q
  {
    private final String id;
    
    e(String paramString)
    {
      this.id = paramString;
    }
    
    public final String getId()
    {
      return this.id;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$3", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "plugin-brandservice_release"})
  public static final class g
    implements k
  {
    private final int pCJ;
    
    g(String paramString) {}
    
    public final boolean aD(int paramInt, String paramString)
    {
      AppMethodBeat.i(195610);
      kotlin.g.b.p.h(paramString, "cgiUrl");
      AppMethodBeat.o(195610);
      return false;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(195615);
      kotlin.g.b.p.h(paramString1, "eventType");
      kotlin.g.b.p.h(paramString2, "event");
      this.pCK.fXo().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(195615);
    }
    
    public final com.tencent.mm.plugin.webview.d.d cna()
    {
      AppMethodBeat.i(195613);
      com.tencent.mm.plugin.webview.d.d locald = (com.tencent.mm.plugin.webview.d.d)new a();
      AppMethodBeat.o(195613);
      return locald;
    }
    
    public final void fe(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195614);
      kotlin.g.b.p.h(paramString1, "func");
      kotlin.g.b.p.h(paramString2, "message");
      AppMethodBeat.o(195614);
    }
    
    public final int getBasePkgVersion()
    {
      AppMethodBeat.i(195609);
      int i = this.pCK.fXo().fWz().version();
      AppMethodBeat.o(195609);
      return i;
    }
    
    public final int getBizPkgVersion()
    {
      return this.pCJ;
    }
    
    @JavascriptInterface
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(195612);
      kotlin.g.b.p.h(paramString, "key");
      String str2 = ((MultiProcessMMKV)l.a(this.pCK).getSlot()).decodeString(parama + ':' + paramString);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] getLocalData key = " + paramString + ", data = " + str1);
      AppMethodBeat.o(195612);
      return str1;
    }
    
    @JavascriptInterface
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195611);
      kotlin.g.b.p.h(paramString1, "key");
      kotlin.g.b.p.h(paramString2, "data");
      Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] setLocalData key = " + paramString1 + ", data = " + paramString2);
      ((MultiProcessMMKV)l.a(this.pCK).getSlot()).encode(parama + ':' + paramString1, paramString2);
      AppMethodBeat.o(195611);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$3$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", "ct", "Landroid/content/Context;", "plugin-brandservice_release"})
    public static final class a
      implements com.tencent.mm.plugin.webview.d.d
    {
      public final void a(n paramn, com.tencent.mm.plugin.webview.d.b paramb) {}
      
      public final void eQ(Context paramContext) {}
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$4", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "plugin-brandservice_release"})
  public static final class h
    implements com.tencent.mm.plugin.ab.c
  {
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(195616);
      kotlin.g.b.p.h(paramString1, "eventType");
      kotlin.g.b.p.h(paramString2, "event");
      this.pCK.fXo().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(195616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.l
 * JD-Core Version:    0.7.0.1
 */