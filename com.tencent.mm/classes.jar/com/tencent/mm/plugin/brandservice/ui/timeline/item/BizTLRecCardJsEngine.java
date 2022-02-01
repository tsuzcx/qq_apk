package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.q;
import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.ay.a.b;
import com.tencent.mm.plugin.ay.c.b;
import com.tencent.mm.plugin.brandservice.ui.c.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.webview.core.o;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ad;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setContext$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "msgIds", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getMsgIds$plugin_brandservice_release", "()Ljava/util/HashMap;", "recFeedIds", "getRecFeedIds$plugin_brandservice_release", "renderJsEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine;", "getRenderJsEngine", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "tlRenderJsEngine", "clear", "", "enterHotZone", "canvasId", "exitHotZone", "getEngineName", "getLocalData", "key", "initEnv", "onConfigClient", "ct", "data", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "onInvoke", "func", "message", "onScreenShot", "scroll", "setLocalData", "updateMsgIds", "msgId", "validCgi", "", "cmdId", "", "cgiUrl", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizTLRecCardJsEngine
  extends com.tencent.mm.plugin.webcanvas.c
{
  public static final String TAG;
  public static final Companion vKS;
  private static final List<String> vKY;
  private static final kotlin.j<List<String>> vKZ;
  private static BizTLRecCardJsEngine.Companion.MMTrimMemoryEventListener vLa;
  private static BizTLRecCardJsEngine vLb;
  WeakReference<Context> context;
  private final String pjl;
  ab vGS;
  private final MMKVSlotManager vKT;
  private final com.tencent.mm.plugin.webview.jsapi.f vKU;
  public final HashMap<String, Long> vKV;
  final HashMap<String, String> vKW;
  private z vKX;
  
  static
  {
    AppMethodBeat.i(302509);
    vKS = new Companion((byte)0);
    TAG = "MicroMsg.BizTLRecCardJsEngine";
    vKY = n.a((CharSequence)"openUrlWithExtraWebview;openADCanvas;profile;openWeApp;launchMiniProgram", new String[] { ";" });
    vKZ = k.cm((kotlin.g.a.a)a.vLc);
    AppMethodBeat.o(302509);
  }
  
  public BizTLRecCardJsEngine()
  {
    AppMethodBeat.i(302477);
    Object localObject1 = MultiProcessMMKV.getMMKV("__WebJsEngineLocalData__");
    s.s(localObject1, "getMMKV(\"__WebJsEngineLocalData__\")");
    this.vKT = new MMKVSlotManager((MultiProcessMMKV)localObject1, 15552000L);
    localObject1 = new com.tencent.mm.plugin.ay.a(WebViewStubService.class, "wxCanvas", "wxf337cbaa27790d8e", JsapiPermissionWrapper.YxF);
    int i = ((com.tencent.mm.plugin.ay.a)localObject1).hashCode();
    com.tencent.mm.plugin.webview.jsapi.j localj = new com.tencent.mm.plugin.webview.jsapi.j(null, null, i);
    Object localObject2 = ((com.tencent.mm.plugin.ay.a)localObject1).WlV;
    Bundle localBundle = new Bundle();
    localBundle.putString("name", ((com.tencent.mm.plugin.ay.a)localObject1).name);
    localBundle.putString("appId", ((com.tencent.mm.plugin.ay.a)localObject1).appId);
    ah localah = ah.aiuX;
    localj.a((JsapiPermissionWrapper)localObject2, localBundle);
    localObject2 = o.WzA;
    o.a(true, ((com.tencent.mm.plugin.ay.a)localObject1).WlU, (com.tencent.mm.plugin.webview.core.f)new a.b(localj, i, (com.tencent.mm.plugin.ay.a)localObject1));
    this.vKU = ((com.tencent.mm.plugin.webview.jsapi.f)localj);
    this.pjl = "wxf337cbaa27790d8e";
    this.vKV = new HashMap();
    this.vKW = new HashMap();
    this.context = new WeakReference(MMApplicationContext.getContext());
    AppMethodBeat.o(302477);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, i parami)
  {
    AppMethodBeat.i(302550);
    s.u(paramContext, "ct");
    s.u(paramString1, "canvasId");
    s.u(paramString2, "data");
    s.u(parami, "jsRuntime");
    super.a(paramContext, paramString1, paramString2, parami);
    new com.tencent.mm.plugin.brandservice.ui.c.a((b)new BizTLRecCardJsEngine.c(this, paramString1, paramString2)).l(parami);
    AppMethodBeat.o(302550);
  }
  
  public final boolean aS(int paramInt, String paramString)
  {
    AppMethodBeat.i(302516);
    s.u(paramString, "cgiUrl");
    if (!((List)vKZ.getValue()).contains(paramString))
    {
      Log.i(TAG, "do cgi cmdId=" + paramInt + ", cgiUrl=" + paramString + " not allowed!!");
      AppMethodBeat.o(302516);
      return false;
    }
    AppMethodBeat.o(302516);
    return true;
  }
  
  public final void ajb(String paramString)
  {
    AppMethodBeat.i(302577);
    s.u(paramString, "canvasId");
    Log.i(TAG, s.X("exitHotZone #", paramString));
    ddN().ajb(paramString);
    paramString = ddN().bhV(paramString);
    if (paramString != null) {
      paramString.WjU = false;
    }
    AppMethodBeat.o(302577);
  }
  
  public final String bQl()
  {
    return this.pjl;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(302563);
    super.clear();
    if (BuildInfo.DEBUG) {}
    for (long l = 3000L;; l = 30000L)
    {
      d.a(l, (kotlin.g.a.a)new b(this));
      AppMethodBeat.o(302563);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.webview.jsapi.f ddL()
  {
    return this.vKU;
  }
  
  public final String ddM()
  {
    return "BizLogicJsEngine";
  }
  
  public final z ddN()
  {
    AppMethodBeat.i(302558);
    if (this.vKX != null)
    {
      localz = this.vKX;
      s.checkNotNull(localz);
      AppMethodBeat.o(302558);
      return localz;
    }
    this.Wkt.Wmm = System.currentTimeMillis();
    z localz = new z(this, ioy(), iox(), this.Wkt);
    this.vKX = localz;
    AppMethodBeat.o(302558);
    return localz;
  }
  
  public final void ddO()
  {
    AppMethodBeat.i(302561);
    super.ddO();
    AppMethodBeat.o(302561);
  }
  
  public final void fM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(302542);
    s.u(paramString1, "func");
    s.u(paramString2, "message");
    if (vKY.contains(paramString1))
    {
      paramString1 = this.vGS;
      if (paramString1 != null)
      {
        paramString2 = MPVideoPreviewMgr.vXs;
        MPVideoPreviewMgr.a(paramString1, "");
      }
    }
    AppMethodBeat.o(302542);
  }
  
  public final String getLocalData(String paramString)
  {
    AppMethodBeat.i(302530);
    s.u(paramString, "key");
    try
    {
      String str = this.vKT.decodeString(paramString, "");
      Log.d(TAG, "getLocalData:" + paramString + ", " + str);
      paramString = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, s.X("getLocalData:", paramString), new Object[0]);
        paramString = null;
      }
    }
    AppMethodBeat.o(302530);
    return paramString;
  }
  
  public final void setLocalData(String paramString1, String paramString2)
  {
    AppMethodBeat.i(302524);
    s.u(paramString1, "key");
    s.u(paramString2, "data");
    try
    {
      ((MultiProcessMMKV)this.vKT.getSlotForWrite()).encode(paramString1, paramString2);
      Log.d(TAG, "setLocalData:" + paramString1 + ", " + paramString2);
      AppMethodBeat.o(302524);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
      AppMethodBeat.o(302524);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$Companion;", "", "()V", "CLICK_FUNC_LIST", "", "", "TAG", "cgiAllowList", "getCgiAllowList", "()Ljava/util/List;", "cgiAllowList$delegate", "Lkotlin/Lazy;", "engine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "getEngine", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "setEngine", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;)V", "sMMTrimMemoryEvent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$Companion$MMTrimMemoryEventListener;", "getJsEngine", "releaseEngine", "", "releaseRenderJsEngine", "MMTrimMemoryEventListener", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion
  {
    public final BizTLRecCardJsEngine ddS()
    {
      try
      {
        AppMethodBeat.i(302802);
        if (BizTLRecCardJsEngine.ddQ() == null) {
          BizTLRecCardJsEngine.a(new BizTLRecCardJsEngine());
        }
        if (BizTLRecCardJsEngine.ddR() == null)
        {
          localObject1 = com.tencent.mm.plugin.ay.c.Wmq;
          if (c.b.ipi())
          {
            localObject1 = new MMTrimMemoryEventListener();
            ((MMTrimMemoryEventListener)localObject1).alive();
            BizTLRecCardJsEngine.a((MMTrimMemoryEventListener)localObject1);
          }
        }
        Object localObject1 = BizTLRecCardJsEngine.ddQ();
        s.checkNotNull(localObject1);
        AppMethodBeat.o(302802);
        return localObject1;
      }
      finally {}
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$Companion$MMTrimMemoryEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MMTrimMemoryEvent;", "()V", "callback", "", "event", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class MMTrimMemoryEventListener
      extends IListener<oc>
    {
      public MMTrimMemoryEventListener()
      {
        super();
        AppMethodBeat.i(302597);
        AppMethodBeat.o(302597);
      }
      
      private static boolean a(oc paramoc)
      {
        AppMethodBeat.i(302604);
        s.u(paramoc, "event");
        Log.i(BizTLRecCardJsEngine.access$getTAG$cp(), s.X("MMTrimMemoryEvent callback isInTimeLine=", Boolean.valueOf(ad.acGg)));
        if (!ad.acGg)
        {
          paramoc = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(130L);
          paramoc = BizTLRecCardJsEngine.vKS;
          Log.i(BizTLRecCardJsEngine.access$getTAG$cp(), "releaseEngine");
        }
        try
        {
          paramoc = BizTLRecCardJsEngine.ddQ();
          if (paramoc != null) {
            paramoc.clear();
          }
          paramoc = BizTLRecCardJsEngine.ddQ();
          if (paramoc != null) {
            paramoc.destroy();
          }
          paramoc = BizTLRecCardJsEngine.ddQ();
          if (paramoc != null)
          {
            paramoc = BizTLRecCardJsEngine.b(paramoc);
            if (paramoc != null) {
              paramoc.ioG();
            }
          }
          paramoc = BizTLRecCardJsEngine.ddQ();
          if (paramoc != null) {
            break label164;
          }
          paramoc = null;
          if (!(paramoc instanceof Closeable)) {
            break label204;
          }
          paramoc = (Closeable)paramoc;
        }
        catch (Exception paramoc)
        {
          for (;;)
          {
            label137:
            label164:
            label180:
            Log.e(BizTLRecCardJsEngine.access$getTAG$cp(), s.X("releaseEngine ex ", paramoc.getMessage()));
            continue;
            paramoc = null;
          }
        }
        IO.safeClose(paramoc);
        paramoc = BizTLRecCardJsEngine.ddQ();
        if (paramoc == null)
        {
          paramoc = null;
          if (!(paramoc instanceof Closeable)) {
            break label180;
          }
        }
        for (paramoc = (Closeable)paramoc;; paramoc = null)
        {
          IO.safeClose(paramoc);
          BizTLRecCardJsEngine.a(null);
          AppMethodBeat.o(302604);
          return false;
          paramoc = BizTLRecCardJsEngine.c(paramoc);
          break;
          paramoc = paramoc.iox();
          break label137;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<List<? extends String>>
  {
    public static final a vLc;
    
    static
    {
      AppMethodBeat.i(302564);
      vLc = new a();
      AppMethodBeat.o(302564);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(BizTLRecCardJsEngine paramBizTLRecCardJsEngine)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine
 * JD-Core Version:    0.7.0.1
 */