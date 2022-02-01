package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.ax.q;
import com.tencent.mm.plugin.ax.r;
import com.tencent.mm.plugin.az.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "localData", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getLocalData", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "localData$delegate", "Lkotlin/Lazy;", "create", "", "id", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "inject", "", "type", "", "script", "onCallback", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "domain", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends d
{
  public static final a vSC;
  private String pjl;
  private final kotlin.j vSD;
  
  static
  {
    AppMethodBeat.i(303218);
    vSC = new a((byte)0);
    AppMethodBeat.o(303218);
  }
  
  public l()
  {
    AppMethodBeat.i(303207);
    this.pjl = "__Mp_Prefetcher_FakeAppId";
    this.vSD = kotlin.k.cm((kotlin.g.a.a)c.vSG);
    AppMethodBeat.o(303207);
  }
  
  private static final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(303210);
    kotlin.g.b.s.u(paramb, "$onCallback");
    Log.d("MicroMsg.MpWebPrefetcherJsEngineInterceptor", kotlin.g.b.s.X("inject callback:", paramString));
    kotlin.g.b.s.s(paramString, "it");
    paramb.invoke(paramString);
    AppMethodBeat.o(303210);
  }
  
  public final boolean a(int paramInt, final com.tencent.mm.plugin.az.a parama, String paramString, final b<? super String, ah> paramb)
  {
    AppMethodBeat.i(303239);
    kotlin.g.b.s.u(parama, "manifest");
    kotlin.g.b.s.u(paramString, "script");
    kotlin.g.b.s.u(paramb, "onCallback");
    Object localObject = com.tencent.mm.plugin.az.e.bim(parama.WmT.oOI + '-' + parama.WmT.aamu);
    if (!ipt().containsKey(localObject))
    {
      paramString = (b)new b(paramString, paramb);
      parama = parama.WmS.aamn;
      Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "create domain:" + parama + '#' + (String)localObject);
    }
    for (;;)
    {
      try
      {
        paramb = ips().sSV.czj();
        kotlin.g.b.s.s(paramb, "this");
        com.tencent.mm.plugin.appbrand.n.i locali = (com.tencent.mm.plugin.appbrand.n.i)paramb;
        kotlin.g.b.s.s(parama, "domain");
        new com.tencent.mm.plugin.ax.p((q)new d((String)localObject, this)).l(locali);
        new r((com.tencent.mm.plugin.ax.s)new e()).l(locali);
        new com.tencent.mm.plugin.ax.j((com.tencent.mm.plugin.ax.k)new f(this, parama)).l(locali);
        new com.tencent.mm.plugin.ax.i((com.tencent.mm.plugin.ax.c)new g(this)).l(locali);
        com.tencent.mm.plugin.ay.c.a(ips(), paramb, kotlin.g.b.s.X("MpWebPrefetcherManifest#", localObject), "manifest", null, nP("manifest", this.pjl), 8);
        ((Map)ipt()).put(localObject, Integer.valueOf(paramb.czh()));
        paramString.invoke(paramb);
        AppMethodBeat.o(303239);
        return true;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("MicroMsg.MpWebPrefetcherJsEngineInterceptor", (Throwable)parama, kotlin.g.b.s.X("create id=", localObject), new Object[0]);
        continue;
      }
      parama = ips();
      localObject = ipt().get(localObject);
      kotlin.g.b.s.checkNotNull(localObject);
      kotlin.g.b.s.s(localObject, "contextMap[id]!!");
      parama.BK(((Number)localObject).intValue()).evaluateJavascript(paramString, new l..ExternalSyntheticLambda0(paramb));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "jsContext", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<g, ah>
  {
    b(String paramString, b<? super String, ah> paramb)
    {
      super();
    }
    
    private static final void b(b paramb, String paramString)
    {
      AppMethodBeat.i(302962);
      kotlin.g.b.s.u(paramb, "$onCallback");
      Log.d("MicroMsg.MpWebPrefetcherJsEngineInterceptor", kotlin.g.b.s.X("inject callback:", paramString));
      kotlin.g.b.s.s(paramString, "it");
      paramb.invoke(paramString);
      AppMethodBeat.o(302962);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<MMKVSlotManager>
  {
    public static final c vSG;
    
    static
    {
      AppMethodBeat.i(302959);
      vSG = new c();
      AppMethodBeat.o(302959);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "dispatch", "", "eventType", "event", "cb", "Landroid/webkit/ValueCallback;", "setMinBizPkgVersion", "version", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements q
  {
    private final String id;
    
    d(String paramString, l paraml)
    {
      AppMethodBeat.i(302955);
      this.id = this.vQo;
      AppMethodBeat.o(302955);
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(302966);
      kotlin.g.b.s.u(paramString1, "eventType");
      kotlin.g.b.s.u(paramString2, "event");
      jdField_this.ips().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(302966);
    }
    
    public final String getId()
    {
      return this.id;
    }
    
    public final void setMinBizPkgVersion(int paramInt) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$2", "Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;", "cacheVideo", "", "data", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.ax.s
  {
    public final void cacheVideo(String paramString)
    {
      AppMethodBeat.i(302971);
      kotlin.g.b.s.u(paramString, "data");
      Log.d("MicroMsg.MpWebPrefetcherJsEngineInterceptor", kotlin.g.b.s.X("[TRACE_VIDEO_PRELOAD] cacheVideo, data = ", paramString));
      e locale = e.vQH;
      kotlin.g.b.s.u(paramString, "data");
      label245:
      for (;;)
      {
        try
        {
          Object localObject = com.tencent.mm.plugin.webview.k.k.Xtc;
          if (com.tencent.mm.plugin.webview.k.k.iCU()) {
            h.OAn.idkeyStat(1379L, 51L, 1L, false);
          }
          localObject = new com.tencent.mm.ad.f(paramString);
          int i = 0;
          int k = ((com.tencent.mm.ad.f)localObject).length();
          int j;
          if (k > 0)
          {
            j = i + 1;
            paramString = ((com.tencent.mm.ad.f)localObject).st(i);
            String str = paramString.optString("url");
            long l1 = paramString.optLong("position");
            i = paramString.optInt("preloadType");
            long l2 = kotlin.k.k.bS(paramString.optLong("length"), 10485760L);
            int m = paramString.optInt("videoType", 0);
            l2 = kotlin.k.k.bR(l2, 512000L);
            if (Util.isNullOrNil(str))
            {
              Log.w("MicroMsg.BizVideoPreloadLogic", "cacheVideo url is null");
              AppMethodBeat.o(302971);
              return;
            }
            if (i == 0)
            {
              paramString = ToolsMpProcessIPCService.PROCESS_NAME;
              kotlin.g.b.s.s(paramString, "processName");
              kotlin.g.b.s.s(str, "url");
              locale.a(paramString, str, l1, l2, m);
              if (j < k) {
                break label245;
              }
              AppMethodBeat.o(302971);
              return;
            }
            paramString = Appbrand0IPCService.PROCESS_NAME;
            continue;
          }
          i = j;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.BizVideoPreloadLogic", kotlin.g.b.s.X("cacheVideo ex ", paramString.getMessage()));
          AppMethodBeat.o(302971);
          return;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$3", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.plugin.ax.k
  {
    private final int vSI;
    
    f(l paraml, String paramString) {}
    
    public final boolean aS(int paramInt, String paramString)
    {
      AppMethodBeat.i(302975);
      kotlin.g.b.s.u(paramString, "cgiUrl");
      AppMethodBeat.o(302975);
      return false;
    }
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(303003);
      kotlin.g.b.s.u(paramString1, "eventType");
      kotlin.g.b.s.u(paramString2, "event");
      this.vSH.ips().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(303003);
    }
    
    public final com.tencent.mm.plugin.webview.jsapi.f ddL()
    {
      AppMethodBeat.i(302994);
      com.tencent.mm.plugin.webview.jsapi.f localf = (com.tencent.mm.plugin.webview.jsapi.f)new a();
      AppMethodBeat.o(302994);
      return localf;
    }
    
    public final void fM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(302997);
      kotlin.g.b.s.u(paramString1, "func");
      kotlin.g.b.s.u(paramString2, "message");
      AppMethodBeat.o(302997);
    }
    
    public final int getBasePkgVersion()
    {
      AppMethodBeat.i(302970);
      int i = com.tencent.mm.plugin.webview.l.a.h(this.vSH.ips().iox());
      AppMethodBeat.o(302970);
      return i;
    }
    
    public final int getBizPkgVersion()
    {
      return this.vSI;
    }
    
    @JavascriptInterface
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(302993);
      kotlin.g.b.s.u(paramString, "key");
      String str2 = MMKVSlotManager.decodeString$default(l.a(this.vSH), parama + ':' + paramString, null, 2, null);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] getLocalData key = " + paramString + ", data = " + str1);
      AppMethodBeat.o(302993);
      return str1;
    }
    
    @JavascriptInterface
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(302984);
      kotlin.g.b.s.u(paramString1, "key");
      kotlin.g.b.s.u(paramString2, "data");
      Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] setLocalData key = " + paramString1 + ", data = " + paramString2);
      ((MultiProcessMMKV)l.a(this.vSH).getSlotForWrite()).encode(parama + ':' + paramString1, paramString2);
      AppMethodBeat.o(302984);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$3$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", "ct", "Landroid/content/Context;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.webview.jsapi.f
    {
      public final void a(com.tencent.mm.plugin.webview.jsapi.p paramp, com.tencent.mm.plugin.webview.jsapi.c paramc) {}
      
      public final void fR(Context paramContext) {}
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$4", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.plugin.ax.c
  {
    g(l paraml) {}
    
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(302917);
      kotlin.g.b.s.u(paramString1, "eventType");
      kotlin.g.b.s.u(paramString2, "event");
      this.vSH.ips().b(paramString1, paramString2, paramValueCallback);
      AppMethodBeat.o(302917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.l
 * JD-Core Version:    0.7.0.1
 */