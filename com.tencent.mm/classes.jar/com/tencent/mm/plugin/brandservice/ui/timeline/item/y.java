package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.plugin.av.c.a;
import com.tencent.mm.plugin.aw.a.b;
import com.tencent.mm.plugin.aw.c.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.erm;
import com.tencent.mm.protocal.protobuf.ern;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setContext$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "msgIds", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getMsgIds$plugin_brandservice_release", "()Ljava/util/HashMap;", "recFeedIds", "getRecFeedIds$plugin_brandservice_release", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "getRenderJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "tlRenderJsEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine;", "enterHotZone", "", "canvasId", "exitHotZone", "getEngineName", "getLocalData", "key", "initEnv", "onConfigClient", "ct", "data", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "onInvoke", "func", "message", "onScreenShot", "scroll", "setLocalData", "validCgi", "", "cmdId", "", "cgiUrl", "Companion", "plugin-brandservice_release"})
public final class y
  extends com.tencent.mm.plugin.webcanvas.c
{
  static final String TAG = "MicroMsg.BizTLRecCardJsEngine";
  private static final List<String> sFs;
  private static final f sFt;
  private static y.a.a sFu;
  private static y sFv;
  public static final a sFw;
  WeakReference<Context> context;
  private final String mpE;
  z sBt;
  private final MMKVSlotManager sFn;
  private final com.tencent.mm.plugin.webview.d.d sFo;
  final HashMap<String, Long> sFp;
  final HashMap<String, String> sFq;
  ac sFr;
  
  static
  {
    AppMethodBeat.i(263722);
    sFw = new a((byte)0);
    TAG = "MicroMsg.BizTLRecCardJsEngine";
    sFs = n.a((CharSequence)"openUrlWithExtraWebview;openADCanvas;profile;openWeApp;launchMiniProgram", new String[] { ";" });
    sFt = kotlin.g.ar((kotlin.g.a.a)b.sFx);
    AppMethodBeat.o(263722);
  }
  
  public y()
  {
    AppMethodBeat.i(263721);
    Object localObject1 = MultiProcessMMKV.getMMKV("__WebJsEngineLocalData__");
    p.j(localObject1, "MultiProcessMMKV.getMMKV…_WebJsEngineLocalData__\")");
    this.sFn = new MMKVSlotManager((MultiProcessMMKV)localObject1, 15552000L);
    localObject1 = new com.tencent.mm.plugin.aw.a(WebViewStubService.class, "wxCanvas", "wxf337cbaa27790d8e", JsapiPermissionWrapper.RBc);
    int i = ((com.tencent.mm.plugin.aw.a)localObject1).hashCode();
    com.tencent.mm.plugin.webview.d.h localh = new com.tencent.mm.plugin.webview.d.h(null, null, i);
    Object localObject2 = ((com.tencent.mm.plugin.aw.a)localObject1).PvI;
    Bundle localBundle = new Bundle();
    localBundle.putString("name", ((com.tencent.mm.plugin.aw.a)localObject1).name);
    localBundle.putString("appId", ((com.tencent.mm.plugin.aw.a)localObject1).appId);
    localh.a((JsapiPermissionWrapper)localObject2, localBundle);
    localObject2 = m.PJj;
    m.a(true, ((com.tencent.mm.plugin.aw.a)localObject1).PvH, (com.tencent.mm.plugin.webview.core.d)new a.b(localh, i));
    this.sFo = ((com.tencent.mm.plugin.webview.d.d)localh);
    this.mpE = "wxf337cbaa27790d8e";
    this.sFp = new HashMap();
    this.sFq = new HashMap();
    this.context = new WeakReference(MMApplicationContext.getContext());
    AppMethodBeat.o(263721);
  }
  
  public final void a(Context paramContext, final String paramString1, final String paramString2, com.tencent.mm.plugin.appbrand.m.i parami)
  {
    AppMethodBeat.i(263717);
    p.k(paramContext, "ct");
    p.k(paramString1, "canvasId");
    p.k(paramString2, "data");
    p.k(parami, "jsRuntime");
    super.a(paramContext, paramString1, paramString2, parami);
    new com.tencent.mm.plugin.brandservice.ui.c.a((com.tencent.mm.plugin.brandservice.ui.c.b)new c(this, paramString1, paramString2)).h(parami);
    AppMethodBeat.o(263717);
  }
  
  public final boolean aF(int paramInt, String paramString)
  {
    AppMethodBeat.i(263713);
    p.k(paramString, "cgiUrl");
    if (!((List)sFt.getValue()).contains(paramString))
    {
      Log.i(TAG, "do cgi cmdId=" + paramInt + ", cgiUrl=" + paramString + " not allowed!!");
      AppMethodBeat.o(263713);
      return false;
    }
    AppMethodBeat.o(263713);
    return true;
  }
  
  public final void apB(String paramString)
  {
    AppMethodBeat.i(263720);
    p.k(paramString, "canvasId");
    Log.i(TAG, "exitHotZone #".concat(String.valueOf(paramString)));
    ac localac = this.sFr;
    if (localac == null) {
      p.bGy("tlRenderJsEngine");
    }
    p.k(paramString, "canvasId");
    localac.c("exitHotZone", paramString, null);
    paramString = cAK().bij(paramString);
    if (paramString != null)
    {
      paramString.Ptc = false;
      AppMethodBeat.o(263720);
      return;
    }
    AppMethodBeat.o(263720);
  }
  
  public final String bsE()
  {
    return this.mpE;
  }
  
  public final com.tencent.mm.plugin.webview.d.d cAI()
  {
    return this.sFo;
  }
  
  public final String cAJ()
  {
    return "BizLogicJsEngine";
  }
  
  public final k cAK()
  {
    AppMethodBeat.i(263718);
    Object localObject = this.sFr;
    if (localObject == null) {
      p.bGy("tlRenderJsEngine");
    }
    localObject = (k)localObject;
    AppMethodBeat.o(263718);
    return localObject;
  }
  
  public final void cAL()
  {
    AppMethodBeat.i(263719);
    this.sFr = new ac(this, gPj(), gPi(), this.PtJ);
    super.cAL();
    AppMethodBeat.o(263719);
  }
  
  public final void fs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263716);
    p.k(paramString1, "func");
    p.k(paramString2, "message");
    if (sFs.contains(paramString1))
    {
      paramString1 = this.sBt;
      if (paramString1 != null)
      {
        paramString2 = MPVideoPreviewMgr.sSn;
        MPVideoPreviewMgr.a(paramString1, "");
        AppMethodBeat.o(263716);
        return;
      }
    }
    AppMethodBeat.o(263716);
  }
  
  public final String getLocalData(String paramString)
  {
    AppMethodBeat.i(263715);
    p.k(paramString, "key");
    try
    {
      String str = this.sFn.decodeString(paramString, "");
      Log.d(TAG, "getLocalData:" + paramString + ", " + str);
      paramString = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "getLocalData:".concat(String.valueOf(paramString)), new Object[0]);
        paramString = null;
      }
    }
    AppMethodBeat.o(263715);
    return paramString;
  }
  
  public final void setLocalData(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263714);
    p.k(paramString1, "key");
    p.k(paramString2, "data");
    try
    {
      ((MultiProcessMMKV)this.sFn.getSlotForWrite()).encode(paramString1, paramString2);
      Log.d(TAG, "setLocalData:" + paramString1 + ", " + paramString2);
      AppMethodBeat.o(263714);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
      AppMethodBeat.o(263714);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$Companion;", "", "()V", "CLICK_FUNC_LIST", "", "", "TAG", "cgiAllowList", "getCgiAllowList", "()Ljava/util/List;", "cgiAllowList$delegate", "Lkotlin/Lazy;", "engine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "getEngine", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "setEngine", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;)V", "sMMTrimMemoryEvent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$Companion$MMTrimMemoryEventListener;", "getJsEngine", "releaseEngine", "", "MMTrimMemoryEventListener", "plugin-brandservice_release"})
  public static final class a
  {
    public final y cAO()
    {
      try
      {
        AppMethodBeat.i(266460);
        if (y.cAM() == null) {
          y.a(new y());
        }
        if (y.cAN() == null)
        {
          localObject1 = com.tencent.mm.plugin.aw.c.Pwj;
          if (c.b.gPS())
          {
            localObject1 = new a();
            ((a)localObject1).alive();
            y.a((a)localObject1);
          }
        }
        Object localObject1 = y.cAM();
        if (localObject1 == null) {
          p.iCn();
        }
        AppMethodBeat.o(266460);
        return localObject1;
      }
      finally {}
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$Companion$MMTrimMemoryEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MMTrimMemoryEvent;", "()V", "callback", "", "event", "plugin-brandservice_release"})
    static final class a
      extends IListener<mv>
    {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends String>>
  {
    public static final b sFx;
    
    static
    {
      AppMethodBeat.i(257909);
      sFx = new b();
      AppMethodBeat.o(257909);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$onConfigClient$1", "Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;", "adRequest", "", "message", "", "subType", "callback", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getData", "getInfo", "", "key", "onItemClick", "pos", "", "plugin-brandservice_release"})
  public static final class c
    implements com.tencent.mm.plugin.brandservice.ui.c.b
  {
    c(String paramString1, String paramString2) {}
    
    public final void adRequest(String paramString1, String paramString2, final String paramString3)
    {
      AppMethodBeat.i(265790);
      p.k(paramString1, "message");
      p.k(paramString2, "subType");
      p.k(paramString3, "callback");
      Log.d(y.access$getTAG$cp(), "adRequest %s", new Object[] { paramString1 });
      d.a locala = new d.a();
      erm localerm = new erm();
      localerm.RXS = 3;
      localerm.RXT = paramString1;
      localerm.UtC = paramString2;
      localerm.RXN = System.currentTimeMillis();
      locala.c((com.tencent.mm.cd.a)localerm);
      locala.d((com.tencent.mm.cd.a)new ern());
      locala.TW("/cgi-bin/mmbiz-bin/recommend/timelinecard");
      locala.vD(2781);
      locala.vF(0);
      locala.vG(0);
      com.tencent.mm.an.aa.a(locala.bgN(), (aa.a)new a(this, paramString3));
      AppMethodBeat.o(265790);
    }
    
    public final void canvasRequest(Number paramNumber, String paramString1, final String paramString2)
    {
      AppMethodBeat.i(265791);
      p.k(paramNumber, "businessId");
      p.k(paramString1, "reqJson");
      p.k(paramString2, "callback");
      Log.d(y.access$getTAG$cp(), "canvasRequest %s", new Object[] { paramString1 });
      Object localObject1 = new d.a();
      ((d.a)localObject1).c((com.tencent.mm.cd.a)new pm());
      ((d.a)localObject1).d((com.tencent.mm.cd.a)new pn());
      ((d.a)localObject1).TW("/cgi-bin/mmbiz-bin/timeline/bizrecommendtimelinecard");
      ((d.a)localObject1).vD(1085);
      localObject1 = ((d.a)localObject1).bgN();
      Object localObject2 = ((com.tencent.mm.an.d)localObject1).bhX();
      if (localObject2 == null)
      {
        paramNumber = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendTimeLineCardReq");
        AppMethodBeat.o(265791);
        throw paramNumber;
      }
      localObject2 = (pm)localObject2;
      ((pm)localObject2).RXS = paramNumber.intValue();
      ((pm)localObject2).RXT = paramString1;
      ((pm)localObject2).RXN = System.currentTimeMillis();
      com.tencent.mm.an.aa.a((com.tencent.mm.an.d)localObject1, (aa.a)new b(this, paramString2));
      AppMethodBeat.o(265791);
    }
    
    public final void deleteCanvasCard(final String paramString)
    {
      AppMethodBeat.i(265789);
      p.k(paramString, "fieldId");
      Log.i(y.access$getTAG$cp(), "deleteCanvasCard ".concat(String.valueOf(paramString)));
      if (this.sFy.sFq.containsValue(paramString))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramString));
        AppMethodBeat.o(265789);
        return;
      }
      af.bjB().UI(Util.getLong(paramString, -1L));
      AppMethodBeat.o(265789);
    }
    
    public final String getData()
    {
      return paramString2;
    }
    
    public final Object getInfo(String paramString)
    {
      AppMethodBeat.i(265788);
      p.k(paramString, "key");
      switch (paramString.hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    AppMethodBeat.o(265788);
                    return null;
                  } while (!paramString.equals("recFeedId"));
                  localObject = (String)this.sFy.sFq.get(paramString1);
                  paramString = (String)localObject;
                  if (localObject == null) {
                    paramString = Integer.valueOf(0);
                  }
                  paramString = String.valueOf(paramString);
                  Log.d(y.access$getTAG$cp(), "getInfo canvasId=" + paramString1 + ", recFeedId=" + paramString);
                  AppMethodBeat.o(265788);
                  return paramString;
                } while (!paramString.equals("videoChannelIconSize"));
                float f = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.b.eT(MMApplicationContext.getContext()) / com.tencent.mm.plugin.appbrand.ac.g.clS();
                AppMethodBeat.o(265788);
                return Float.valueOf(f);
              } while (!paramString.equals("msgId"));
              Object localObject = (Long)this.sFy.sFp.get(paramString1);
              paramString = (String)localObject;
              if (localObject == null) {
                paramString = Long.valueOf(0L);
              }
              paramString = String.valueOf(paramString);
              Log.d(y.access$getTAG$cp(), "getInfo canvasId=" + paramString1 + ", msgIds=" + paramString);
              AppMethodBeat.o(265788);
              return paramString;
            } while (!paramString.equals("sessionId"));
            paramString = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
            if (paramString == null) {
              break;
            }
            i = paramString.cyE();
            AppMethodBeat.o(265788);
            return Integer.valueOf(i);
          } while (!paramString.equals("videoChannelData"));
          paramString = com.tencent.mm.plugin.brandservice.b.d.swc;
          paramString = com.tencent.mm.plugin.brandservice.b.d.czk();
          AppMethodBeat.o(265788);
          return paramString;
        } while (!paramString.equals("videoChannelItemWidth"));
        paramString = Integer.valueOf(kotlin.h.a.dm(com.tencent.mm.plugin.brandservice.ui.timeline.offenread.b.eS(MMApplicationContext.getContext()) / com.tencent.mm.plugin.appbrand.ac.g.clS()));
        int i = ((Number)paramString).intValue();
        Log.d(y.access$getTAG$cp(), "getInfo canvasId=" + paramString1 + ", videoChannelItemWidth=" + i);
        AppMethodBeat.o(265788);
        return paramString;
      } while (!paramString.equals("feedBackRecycleCardList"));
      paramString = l.cAu();
      AppMethodBeat.o(265788);
      return paramString;
      AppMethodBeat.o(265788);
      return Integer.valueOf(0);
    }
    
    public final void onItemClick(final String paramString, final int paramInt)
    {
      AppMethodBeat.i(265792);
      p.k(paramString, "fieldId");
      final long l = Util.getLong(paramString, 0L);
      Log.i(y.access$getTAG$cp(), "onItemClick fieldId=" + paramString + ", msgId=" + l + ", pos=" + paramInt);
      com.tencent.e.h.ZvG.be((Runnable)new d(this, paramString, paramInt, l));
      AppMethodBeat.o(265792);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class a
      implements aa.a
    {
      a(y.c paramc, String paramString) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
      {
        AppMethodBeat.i(263960);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Log.e(y.access$getTAG$cp(), "adRequest callback errType=" + paramInt1 + ", errCode=" + paramInt2);
          paramString = this.sFz.sFy;
          paramd = paramString3;
          paramq = new JSONObject();
          paramq.put("err_code", paramInt2);
          paramq.put("err_msg", "fail");
          paramq = paramq.toString();
          p.j(paramq, "JSONObject().apply {\n   …             }.toString()");
          c.a.a(paramString, paramd, paramq, null, 4);
          AppMethodBeat.o(263960);
          return 0;
        }
        p.j(paramd, "rr");
        paramd = paramd.bhY();
        paramString = paramd;
        if (!(paramd instanceof ern)) {
          paramString = null;
        }
        paramString = (ern)paramString;
        if (paramString == null)
        {
          Log.e(y.access$getTAG$cp(), "adRequest resp is null");
          AppMethodBeat.o(263960);
          return 0;
        }
        Log.d(y.access$getTAG$cp(), "adRequest resp data: " + paramString.RXT);
        paramq = this.sFz.sFy;
        String str = paramString3;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("err_msg", "ok");
        paramd = paramString.RXT;
        paramString = paramd;
        if (paramd == null) {
          paramString = "";
        }
        localJSONObject.put("data", paramString);
        paramString = localJSONObject.toString();
        p.j(paramString, "JSONObject().apply {\n   …             }.toString()");
        c.a.a(paramq, str, paramString, null, 4);
        AppMethodBeat.o(263960);
        return 0;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class b
      implements aa.a
    {
      b(y.c paramc, String paramString) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
      {
        AppMethodBeat.i(265145);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          paramString = this.sFz.sFy;
          paramd = paramString2;
          paramq = new JSONObject();
          paramq.put("err_code", paramInt2);
          paramq.put("err_msg", "fail");
          paramq = paramq.toString();
          p.j(paramq, "JSONObject().apply {\n   …             }.toString()");
          c.a.a(paramString, paramd, paramq, null, 4);
          AppMethodBeat.o(265145);
          return 0;
        }
        p.j(paramd, "rr");
        paramd = paramd.bhY();
        paramString = paramd;
        if (!(paramd instanceof pn)) {
          paramString = null;
        }
        paramq = (pn)paramString;
        if (paramq != null)
        {
          Log.i(y.access$getTAG$cp(), "canvasRequest resp_json=" + paramq.RXT);
          paramString = this.sFz.sFy;
          paramd = paramString2;
          paramq = paramq.RXT;
          p.j(paramq, "resp.Data");
          c.a.a(paramString, paramd, paramq, null, 4);
        }
        AppMethodBeat.o(265145);
        return 0;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      c(y.c paramc, String paramString)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(y.c paramc, String paramString, int paramInt, long paramLong) {}
      
      public final void run()
      {
        Object localObject2 = null;
        AppMethodBeat.i(264843);
        Object localObject1;
        if (this.sFz.sFy.sFq.containsValue(paramString))
        {
          localObject2 = this.sFz.sFy.context.get();
          localObject1 = localObject2;
          if (!(localObject2 instanceof BizTimeLineUI)) {
            localObject1 = null;
          }
          localObject1 = (BizTimeLineUI)localObject1;
          if (localObject1 != null)
          {
            ((BizTimeLineUI)localObject1).dd(paramString, paramInt);
            AppMethodBeat.o(264843);
            return;
          }
          AppMethodBeat.o(264843);
          return;
        }
        Object localObject4 = af.bjB().Uw(l);
        if (localObject4 != null)
        {
          if (((z)localObject4).hwB())
          {
            Object localObject3 = this.sFz.sFy.context.get();
            localObject1 = localObject3;
            if (!(localObject3 instanceof BizTimeLineUI)) {
              localObject1 = null;
            }
            localObject1 = (BizTimeLineUI)localObject1;
            if (localObject1 != null) {
              ((BizTimeLineUI)localObject1).j((z)localObject4);
            }
            localObject1 = ((z)localObject4).hwL();
            if ((localObject1 != null) && (((eqg)localObject1).style == 1001) && (((eqg)localObject1).UsH != null))
            {
              localObject3 = com.tencent.mm.plugin.report.service.h.IzE;
              long l1 = MMSlotKt.now();
              localObject4 = ((eqg)localObject1).UsH.cardId;
              long l2 = ((eqg)localObject1).Uaw;
              int i = ((eqg)localObject1).style;
              amf localamf = ((eqg)localObject1).UsF;
              localObject1 = localObject2;
              if (localamf != null) {
                localObject1 = localamf.RVm;
              }
              ((com.tencent.mm.plugin.report.service.h)localObject3).a(21064, new Object[] { Long.valueOf(l1), localObject4, Long.valueOf(l2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(i), localObject1 });
            }
          }
          AppMethodBeat.o(264843);
          return;
        }
        AppMethodBeat.o(264843);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.y
 * JD-Core Version:    0.7.0.1
 */