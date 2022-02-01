package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.plugin.av.j;
import com.tencent.mm.plugin.av.k;
import com.tencent.mm.plugin.av.r;
import com.tencent.mm.plugin.av.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "localData", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getLocalData", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "localData$delegate", "Lkotlin/Lazy;", "create", "", "id", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "inject", "", "type", "", "script", "onCallback", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "domain", "Companion", "plugin-brandservice_release"})
public final class l
  extends com.tencent.mm.plugin.ax.d
{
  public static final a sMQ;
  private String mpE;
  private final kotlin.f sMP;
  
  static
  {
    AppMethodBeat.i(263845);
    sMQ = new a((byte)0);
    AppMethodBeat.o(263845);
  }
  
  public l()
  {
    AppMethodBeat.i(263844);
    this.mpE = "__Mp_Prefetcher_FakeAppId";
    this.sMP = kotlin.g.ar((kotlin.g.a.a)d.sMU);
    AppMethodBeat.o(263844);
  }
  
  public final boolean a(int paramInt, final com.tencent.mm.plugin.ax.a parama, String paramString, final kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(263843);
    kotlin.g.b.p.k(parama, "manifest");
    kotlin.g.b.p.k(paramString, "script");
    kotlin.g.b.p.k(paramb, "onCallback");
    Object localObject = com.tencent.mm.plugin.ax.e.biE(parama.PwJ.lVG + '-' + parama.PwJ.SZA);
    if (!gQc().containsKey(localObject))
    {
      paramString = (kotlin.g.a.b)new b(paramString, paramb);
      parama = parama.PwI.SZt;
      Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "create domain:" + parama + '#' + (String)localObject);
    }
    for (;;)
    {
      try
      {
        paramb = gQb().bYV();
        kotlin.g.b.p.j(paramb, "this");
        com.tencent.mm.plugin.appbrand.m.i locali = (com.tencent.mm.plugin.appbrand.m.i)paramb;
        kotlin.g.b.p.j(parama, "domain");
        new com.tencent.mm.plugin.av.p((com.tencent.mm.plugin.av.q)new e(this, (String)localObject)).h(locali);
        new r((s)new f()).h(locali);
        new j((k)new g(this, parama)).h(locali);
        new com.tencent.mm.plugin.av.i((com.tencent.mm.plugin.av.c)new h(this)).h(locali);
        com.tencent.mm.plugin.aw.c.a(gQb(), paramb, "MpWebPrefetcherManifest#".concat(String.valueOf(localObject)), "manifest", null, md("manifest", this.mpE), 8);
        ((Map)gQc()).put(localObject, Integer.valueOf(paramb.bYT()));
        paramString.invoke(paramb);
        AppMethodBeat.o(263843);
        return true;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("MicroMsg.MpWebPrefetcherJsEngineInterceptor", (Throwable)parama, "create id=".concat(String.valueOf(localObject)), new Object[0]);
        continue;
      }
      parama = gQb();
      localObject = gQc().get(localObject);
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      kotlin.g.b.p.j(localObject, "contextMap[id]!!");
      parama.Bx(((Number)localObject).intValue()).evaluateJavascript(paramString, (ValueCallback)new c(paramb));
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "jsContext", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.m.g, x>
  {
    b(String paramString, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  static final class c<T>
    implements ValueCallback<String>
  {
    c(kotlin.g.a.b paramb) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MMKVSlotManager>
  {
    public static final d sMU;
    
    static
    {
      AppMethodBeat.i(266793);
      sMU = new d();
      AppMethodBeat.o(266793);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "dispatch", "", "eventType", "event", "cb", "Landroid/webkit/ValueCallback;", "setMinBizPkgVersion", "version", "", "plugin-brandservice_release"})
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
      AppMethodBeat.i(259843);
      kotlin.g.b.p.k(paramString1, "eventType");
      kotlin.g.b.p.k(paramString2, "event");
      this.sMV.gQb().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(259843);
    }
    
    public final String getId()
    {
      return this.id;
    }
    
    public final void setMinBizPkgVersion(int paramInt) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$2", "Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;", "cacheVideo", "", "data", "", "plugin-brandservice_release"})
  public static final class f
    implements s
  {
    public final void cacheVideo(String paramString)
    {
      int i = 0;
      AppMethodBeat.i(265836);
      kotlin.g.b.p.k(paramString, "data");
      Log.d("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] cacheVideo, data = ".concat(String.valueOf(paramString)));
      e locale = e.sKW;
      kotlin.g.b.p.k(paramString, "data");
      try
      {
        if (e.cBL()) {
          h.IzE.idkeyStat(1379L, 51L, 1L, false);
        }
        com.tencent.mm.ad.f localf = new com.tencent.mm.ad.f(paramString);
        int j = localf.length();
        if (i < j)
        {
          paramString = localf.sx(i);
          String str = paramString.optString("url");
          long l1 = paramString.optLong("position");
          int k = paramString.optInt("preloadType");
          long l2 = kotlin.k.i.be(kotlin.k.i.bf(paramString.optLong("length"), 10485760L), 512000L);
          if (Util.isNullOrNil(str))
          {
            Log.w("MicroMsg.BizVideoPreloadLogic", "cacheVideo url is null");
            AppMethodBeat.o(265836);
            return;
          }
          if (k == 0) {}
          for (paramString = ToolsMpProcessIPCService.PROCESS_NAME;; paramString = Appbrand0IPCService.PROCESS_NAME)
          {
            kotlin.g.b.p.j(paramString, "processName");
            kotlin.g.b.p.j(str, "url");
            locale.c(paramString, str, l1, l2);
            i += 1;
            break;
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.BizVideoPreloadLogic", "cacheVideo ex " + paramString.getMessage());
        AppMethodBeat.o(265836);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$3", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "plugin-brandservice_release"})
  public static final class g
    implements k
  {
    private final int sMW;
    
    g(String paramString) {}
    
    public final boolean aF(int paramInt, String paramString)
    {
      AppMethodBeat.i(265706);
      kotlin.g.b.p.k(paramString, "cgiUrl");
      AppMethodBeat.o(265706);
      return false;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(265711);
      kotlin.g.b.p.k(paramString1, "eventType");
      kotlin.g.b.p.k(paramString2, "event");
      this.sMV.gQb().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(265711);
    }
    
    public final com.tencent.mm.plugin.webview.d.d cAI()
    {
      AppMethodBeat.i(265709);
      com.tencent.mm.plugin.webview.d.d locald = (com.tencent.mm.plugin.webview.d.d)new a();
      AppMethodBeat.o(265709);
      return locald;
    }
    
    public final void fs(String paramString1, String paramString2)
    {
      AppMethodBeat.i(265710);
      kotlin.g.b.p.k(paramString1, "func");
      kotlin.g.b.p.k(paramString2, "message");
      AppMethodBeat.o(265710);
    }
    
    public final int getBasePkgVersion()
    {
      AppMethodBeat.i(265705);
      int i = com.tencent.mm.plugin.webview.l.a.b(this.sMV.gQb().gPi());
      AppMethodBeat.o(265705);
      return i;
    }
    
    public final int getBizPkgVersion()
    {
      return this.sMW;
    }
    
    @JavascriptInterface
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(265708);
      kotlin.g.b.p.k(paramString, "key");
      String str2 = MMKVSlotManager.decodeString$default(l.a(this.sMV), parama + ':' + paramString, null, 2, null);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] getLocalData key = " + paramString + ", data = " + str1);
      AppMethodBeat.o(265708);
      return str1;
    }
    
    @JavascriptInterface
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(265707);
      kotlin.g.b.p.k(paramString1, "key");
      kotlin.g.b.p.k(paramString2, "data");
      Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] setLocalData key = " + paramString1 + ", data = " + paramString2);
      ((MultiProcessMMKV)l.a(this.sMV).getSlotForWrite()).encode(parama + ':' + paramString1, paramString2);
      AppMethodBeat.o(265707);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$3$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", "ct", "Landroid/content/Context;", "plugin-brandservice_release"})
    public static final class a
      implements com.tencent.mm.plugin.webview.d.d
    {
      public final void a(n paramn, com.tencent.mm.plugin.webview.d.b paramb) {}
      
      public final void eU(Context paramContext) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$4", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "plugin-brandservice_release"})
  public static final class h
    implements com.tencent.mm.plugin.av.c
  {
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(262221);
      kotlin.g.b.p.k(paramString1, "eventType");
      kotlin.g.b.p.k(paramString2, "event");
      this.sMV.gQb().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(262221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.l
 * JD-Core Version:    0.7.0.1
 */