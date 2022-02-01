package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.ab.c.a;
import com.tencent.mm.plugin.ac.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.dkp;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.protocal.protobuf.ehl;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.protocal.protobuf.pr;
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
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setContext$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "msgIds", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getMsgIds$plugin_brandservice_release", "()Ljava/util/HashMap;", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "getRenderJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "tlRenderJsEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine;", "enterHotZone", "", "canvasId", "exitHotZone", "getLocalData", "key", "initEnv", "onConfigClient", "ct", "data", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "onInvoke", "func", "message", "onScreenShot", "scroll", "setLocalData", "validCgi", "", "cmdId", "", "cgiUrl", "Companion", "plugin-brandservice_release"})
public final class x
  extends com.tencent.mm.plugin.webcanvas.c
{
  static final String TAG = "MicroMsg.BizTLRecCardJsEngine";
  private static final List<String> pvZ;
  private static final f pwa;
  public static final x.a pwb;
  private final String jzY;
  WeakReference<Context> lAM;
  z psm;
  private final MMKVSlotManager pvV;
  private final com.tencent.mm.plugin.webview.d.d pvW;
  final HashMap<String, Long> pvX;
  ab pvY;
  
  static
  {
    AppMethodBeat.i(195420);
    pwb = new x.a((byte)0);
    TAG = "MicroMsg.BizTLRecCardJsEngine";
    pvZ = n.a((CharSequence)"openUrlWithExtraWebview;openADCanvas;profile;openWeApp;launchMiniProgram", new String[] { ";" });
    pwa = kotlin.g.ah((kotlin.g.a.a)x.b.pwc);
    AppMethodBeat.o(195420);
  }
  
  public x()
  {
    AppMethodBeat.i(195419);
    Object localObject1 = MultiProcessMMKV.getMMKV("__WebJsEngineLocalData__");
    p.g(localObject1, "MultiProcessMMKV.getMMKV…_WebJsEngineLocalData__\")");
    this.pvV = new MMKVSlotManager((MultiProcessMMKV)localObject1, 15552000L);
    localObject1 = new com.tencent.mm.plugin.ac.a(WebViewStubService.class, "wxCanvas", "wxf337cbaa27790d8e", JsapiPermissionWrapper.Kzm);
    int i = ((com.tencent.mm.plugin.ac.a)localObject1).hashCode();
    com.tencent.mm.plugin.webview.d.h localh = new com.tencent.mm.plugin.webview.d.h(null, null, i);
    Object localObject2 = ((com.tencent.mm.plugin.ac.a)localObject1).IBv;
    Bundle localBundle = new Bundle();
    localBundle.putString("name", ((com.tencent.mm.plugin.ac.a)localObject1).name);
    localBundle.putString("appId", ((com.tencent.mm.plugin.ac.a)localObject1).appId);
    localh.a((JsapiPermissionWrapper)localObject2, localBundle);
    localObject2 = m.INc;
    m.a(true, ((com.tencent.mm.plugin.ac.a)localObject1).IBu, (com.tencent.mm.plugin.webview.core.d)new a.b(localh, i));
    this.pvW = ((com.tencent.mm.plugin.webview.d.d)localh);
    this.jzY = "wxf337cbaa27790d8e";
    this.pvX = new HashMap();
    this.lAM = new WeakReference(MMApplicationContext.getContext());
    AppMethodBeat.o(195419);
  }
  
  public final void a(Context paramContext, final String paramString1, final String paramString2, com.tencent.mm.plugin.appbrand.m.i parami)
  {
    AppMethodBeat.i(195415);
    p.h(paramContext, "ct");
    p.h(paramString1, "canvasId");
    p.h(paramString2, "data");
    p.h(parami, "jsRuntime");
    super.a(paramContext, paramString1, paramString2, parami);
    new com.tencent.mm.plugin.brandservice.ui.c.a((com.tencent.mm.plugin.brandservice.ui.c.b)new c(this, paramString1, paramString2)).f(parami);
    AppMethodBeat.o(195415);
  }
  
  public final boolean aD(int paramInt, String paramString)
  {
    AppMethodBeat.i(195411);
    p.h(paramString, "cgiUrl");
    if (!((List)pwa.getValue()).contains(paramString))
    {
      Log.i(TAG, "do cgi cmdId=" + paramInt + ", cgiUrl=" + paramString + " not allowed!!");
      AppMethodBeat.o(195411);
      return false;
    }
    AppMethodBeat.o(195411);
    return true;
  }
  
  public final void ahP(String paramString)
  {
    AppMethodBeat.i(195418);
    p.h(paramString, "canvasId");
    Log.i(TAG, "exitHotZone #".concat(String.valueOf(paramString)));
    ab localab = this.pvY;
    if (localab == null) {
      p.btv("tlRenderJsEngine");
    }
    p.h(paramString, "canvasId");
    localab.c("exitHotZone", paramString, null);
    paramString = cnb().aWC(paramString);
    if (paramString != null)
    {
      paramString.IyZ = false;
      AppMethodBeat.o(195418);
      return;
    }
    AppMethodBeat.o(195418);
  }
  
  public final String bje()
  {
    return this.jzY;
  }
  
  public final com.tencent.mm.plugin.webview.d.d cna()
  {
    return this.pvW;
  }
  
  public final k cnb()
  {
    AppMethodBeat.i(195416);
    Object localObject = this.pvY;
    if (localObject == null) {
      p.btv("tlRenderJsEngine");
    }
    localObject = (k)localObject;
    AppMethodBeat.o(195416);
    return localObject;
  }
  
  public final void cnc()
  {
    AppMethodBeat.i(195417);
    this.pvY = new ab(this, fWA(), fWz(), this.IzG);
    super.cnc();
    AppMethodBeat.o(195417);
  }
  
  public final void fe(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195414);
    p.h(paramString1, "func");
    p.h(paramString2, "message");
    if (pvZ.contains(paramString1))
    {
      paramString1 = this.psm;
      if (paramString1 != null)
      {
        paramString2 = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.a(paramString1, "");
        AppMethodBeat.o(195414);
        return;
      }
    }
    AppMethodBeat.o(195414);
  }
  
  public final String getLocalData(String paramString)
  {
    AppMethodBeat.i(195413);
    p.h(paramString, "key");
    try
    {
      String str = ((MultiProcessMMKV)this.pvV.getSlot()).decodeString(paramString, "");
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
    AppMethodBeat.o(195413);
    return paramString;
  }
  
  public final void setLocalData(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195412);
    p.h(paramString1, "key");
    p.h(paramString2, "data");
    try
    {
      ((MultiProcessMMKV)this.pvV.getSlot()).encode(paramString1, paramString2);
      Log.d(TAG, "setLocalData:" + paramString1 + ", " + paramString2);
      AppMethodBeat.o(195412);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
      AppMethodBeat.o(195412);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$onConfigClient$1", "Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;", "adRequest", "", "message", "", "subType", "callback", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getData", "getInfo", "", "key", "onItemClick", "pos", "", "plugin-brandservice_release"})
  public static final class c
    implements com.tencent.mm.plugin.brandservice.ui.c.b
  {
    c(String paramString1, String paramString2) {}
    
    public final void adRequest(String paramString1, String paramString2, final String paramString3)
    {
      AppMethodBeat.i(195408);
      p.h(paramString1, "message");
      p.h(paramString2, "subType");
      p.h(paramString3, "callback");
      Log.d(x.access$getTAG$cp(), "adRequest %s", new Object[] { paramString1 });
      d.a locala = new d.a();
      ehk localehk = new ehk();
      localehk.KWE = 3;
      localehk.KWF = paramString1;
      localehk.NgX = paramString2;
      localehk.KWz = System.currentTimeMillis();
      locala.c((com.tencent.mm.bw.a)localehk);
      locala.d((com.tencent.mm.bw.a)new ehl());
      locala.MB("/cgi-bin/mmbiz-bin/recommend/timelinecard");
      locala.sG(2781);
      locala.sI(0);
      locala.sJ(0);
      com.tencent.mm.ak.aa.a(locala.aXF(), (aa.a)new a(this, paramString3));
      AppMethodBeat.o(195408);
    }
    
    public final void canvasRequest(Number paramNumber, String paramString1, final String paramString2)
    {
      AppMethodBeat.i(195409);
      p.h(paramNumber, "businessId");
      p.h(paramString1, "reqJson");
      p.h(paramString2, "callback");
      Log.d(x.access$getTAG$cp(), "canvasRequest %s", new Object[] { paramString1 });
      Object localObject1 = new d.a();
      ((d.a)localObject1).c((com.tencent.mm.bw.a)new pq());
      ((d.a)localObject1).d((com.tencent.mm.bw.a)new pr());
      ((d.a)localObject1).MB("/cgi-bin/mmbiz-bin/timeline/bizrecommendtimelinecard");
      ((d.a)localObject1).sG(1085);
      localObject1 = ((d.a)localObject1).aXF();
      Object localObject2 = ((com.tencent.mm.ak.d)localObject1).aYJ();
      if (localObject2 == null)
      {
        paramNumber = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendTimeLineCardReq");
        AppMethodBeat.o(195409);
        throw paramNumber;
      }
      localObject2 = (pq)localObject2;
      ((pq)localObject2).KWE = paramNumber.intValue();
      ((pq)localObject2).KWF = paramString1;
      ((pq)localObject2).KWz = System.currentTimeMillis();
      com.tencent.mm.ak.aa.a((com.tencent.mm.ak.d)localObject1, (aa.a)new b(this, paramString2));
      AppMethodBeat.o(195409);
    }
    
    public final void deleteCanvasCard(String paramString)
    {
      AppMethodBeat.i(195407);
      p.h(paramString, "fieldId");
      Log.i(x.access$getTAG$cp(), "deleteCanvasCard ".concat(String.valueOf(paramString)));
      ag.ban().MX(Util.getLong(paramString, -1L));
      AppMethodBeat.o(195407);
    }
    
    public final String getData()
    {
      return paramString2;
    }
    
    public final Object getInfo(String paramString)
    {
      AppMethodBeat.i(195406);
      p.h(paramString, "key");
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
                  AppMethodBeat.o(195406);
                  return null;
                } while (!paramString.equals("videoChannelIconSize"));
                float f = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a.eO(MMApplicationContext.getContext()) / com.tencent.mm.plugin.appbrand.ac.g.bZk();
                AppMethodBeat.o(195406);
                return Float.valueOf(f);
              } while (!paramString.equals("msgId"));
              Long localLong = (Long)this.pwd.pvX.get(paramString1);
              paramString = localLong;
              if (localLong == null) {
                paramString = Long.valueOf(0L);
              }
              paramString = String.valueOf(paramString);
              Log.d(x.access$getTAG$cp(), "getInfo canvasId=" + paramString1 + ", msgIds=" + paramString);
              AppMethodBeat.o(195406);
              return paramString;
            } while (!paramString.equals("sessionId"));
            paramString = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
            if (paramString == null) {
              break;
            }
            i = paramString.clh();
            AppMethodBeat.o(195406);
            return Integer.valueOf(i);
          } while (!paramString.equals("videoChannelData"));
          paramString = com.tencent.mm.plugin.brandservice.b.c.pne;
          paramString = com.tencent.mm.plugin.brandservice.b.c.clG();
          AppMethodBeat.o(195406);
          return paramString;
        } while (!paramString.equals("videoChannelItemWidth"));
        paramString = Integer.valueOf(kotlin.h.a.cR(com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a.eN(MMApplicationContext.getContext()) / com.tencent.mm.plugin.appbrand.ac.g.bZk()));
        int i = ((Number)paramString).intValue();
        Log.d(x.access$getTAG$cp(), "getInfo canvasId=" + paramString1 + ", videoChannelItemWidth=" + i);
        AppMethodBeat.o(195406);
        return paramString;
      } while (!paramString.equals("feedBackRecycleCardList"));
      paramString = l.cmN();
      AppMethodBeat.o(195406);
      return paramString;
      AppMethodBeat.o(195406);
      return Integer.valueOf(0);
    }
    
    public final void onItemClick(String paramString, int paramInt)
    {
      AppMethodBeat.i(195410);
      p.h(paramString, "fieldId");
      final long l = Util.getLong(paramString, 0L);
      Log.i(x.access$getTAG$cp(), "onItemClick msgId=%s, pos=%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
      com.tencent.f.h.RTc.aX((Runnable)new c(this, l));
      AppMethodBeat.o(195410);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class a
      implements aa.a
    {
      a(x.c paramc, String paramString) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, q paramq)
      {
        AppMethodBeat.i(195403);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Log.e(x.access$getTAG$cp(), "adRequest callback errType=" + paramInt1 + ", errCode=" + paramInt2);
          paramString = this.pwe.pwd;
          paramd = paramString3;
          paramq = new JSONObject();
          paramq.put("err_code", paramInt2);
          paramq.put("err_msg", "fail");
          paramq = paramq.toString();
          p.g(paramq, "JSONObject().apply {\n   …             }.toString()");
          c.a.a(paramString, paramd, paramq, null, 4);
          AppMethodBeat.o(195403);
          return 0;
        }
        p.g(paramd, "rr");
        paramd = paramd.aYK();
        paramString = paramd;
        if (!(paramd instanceof ehl)) {
          paramString = null;
        }
        paramString = (ehl)paramString;
        if (paramString == null)
        {
          Log.e(x.access$getTAG$cp(), "adRequest resp is null");
          AppMethodBeat.o(195403);
          return 0;
        }
        Log.d(x.access$getTAG$cp(), "adRequest resp data: " + paramString.KWF);
        paramq = this.pwe.pwd;
        String str = paramString3;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("err_msg", "ok");
        paramd = paramString.KWF;
        paramString = paramd;
        if (paramd == null) {
          paramString = "";
        }
        localJSONObject.put("data", paramString);
        paramString = localJSONObject.toString();
        p.g(paramString, "JSONObject().apply {\n   …             }.toString()");
        c.a.a(paramq, str, paramString, null, 4);
        AppMethodBeat.o(195403);
        return 0;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class b
      implements aa.a
    {
      b(x.c paramc, String paramString) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, q paramq)
      {
        AppMethodBeat.i(195404);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          paramString = this.pwe.pwd;
          paramd = paramString2;
          paramq = new JSONObject();
          paramq.put("err_code", paramInt2);
          paramq.put("err_msg", "fail");
          paramq = paramq.toString();
          p.g(paramq, "JSONObject().apply {\n   …             }.toString()");
          c.a.a(paramString, paramd, paramq, null, 4);
          AppMethodBeat.o(195404);
          return 0;
        }
        p.g(paramd, "rr");
        paramd = paramd.aYK();
        paramString = paramd;
        if (!(paramd instanceof pr)) {
          paramString = null;
        }
        paramq = (pr)paramString;
        if (paramq != null)
        {
          Log.i(x.access$getTAG$cp(), "canvasRequest resp_json=" + paramq.KWF);
          paramString = this.pwe.pwd;
          paramd = paramString2;
          paramq = paramq.KWF;
          p.g(paramq, "resp.Data");
          c.a.a(paramString, paramd, paramq, null, 4);
        }
        AppMethodBeat.o(195404);
        return 0;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(x.c paramc, long paramLong) {}
      
      public final void run()
      {
        Object localObject2 = null;
        AppMethodBeat.i(195405);
        Object localObject4 = ag.ban().MM(l);
        if (localObject4 != null)
        {
          if (((z)localObject4).gAu())
          {
            Object localObject3 = this.pwe.pwd.lAM.get();
            Object localObject1 = localObject3;
            if (!(localObject3 instanceof BizTimeLineUI)) {
              localObject1 = null;
            }
            localObject1 = (BizTimeLineUI)localObject1;
            if (localObject1 != null) {
              ((BizTimeLineUI)localObject1).j((z)localObject4);
            }
            localObject1 = ((z)localObject4).gAD();
            if ((localObject1 != null) && (((ege)localObject1).style == 1001) && (((ege)localObject1).Ngc != null))
            {
              localObject3 = com.tencent.mm.plugin.report.service.h.CyF;
              long l1 = MMSlotKt.now();
              localObject4 = ((ege)localObject1).Ngc.cardId;
              long l2 = ((ege)localObject1).MOC;
              int i = ((ege)localObject1).style;
              ale localale = ((ege)localObject1).Nga;
              localObject1 = localObject2;
              if (localale != null) {
                localObject1 = localale.KUo;
              }
              ((com.tencent.mm.plugin.report.service.h)localObject3).a(21064, new Object[] { Long.valueOf(l1), localObject4, Long.valueOf(l2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(i), localObject1 });
            }
          }
          AppMethodBeat.o(195405);
          return;
        }
        AppMethodBeat.o(195405);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.x
 * JD-Core Version:    0.7.0.1
 */