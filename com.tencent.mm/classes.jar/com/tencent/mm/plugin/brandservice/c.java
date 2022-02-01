package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.model.p.a;
import com.tencent.mm.plugin.biz.PluginBiz;
import com.tencent.mm.plugin.brandservice.b.h.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.y.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "()V", "TAG", "", "chatSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "minPreloadTime", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "addReportParamForBizUrl", "url", "scene", "", "subScene", "clickTime", "addToPreload", "", "itemShowType", "openScene", "vals", "", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "appMsgPaySuccess", "canPreloadIn", "", "dispatchEvent", "appId", "event", "data", "doPreloadTimelineRecCard", "path", "canvasId", "doSendMpShareVideoMsg", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "favMpVideo", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "getAppMsgRelatedInfo", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "reqType", "getAppMsgRelatedInfoForAppMsg", "items", "", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getBizFinderLiveChecker", "Lcom/tencent/mm/plugin/brandservice/api/IBizFinderLiveChecker;", "getBizTimeLineSessionId", "getChannelFeeds", "getChatSession", "chatName", "getFinderLiveExportId", "userName", "getFinderLiveScene", "getHardCodeUrl", "getUrlKey", "isBizNativePageOpen", "isBizTimeLineOpen", "isFinderLiveNow", "isMpArticle", "isMpUrl", "isPayReadingOpen", "isShowBigPic", "baseInfo", "baseTopItem", "count", "isSupportStyle", "style", "onFinderLiveClick", "context", "Landroid/content/Context;", "bizUserName", "finderFeedExportId", "liveScene", "onResumeCheckFinderLive", "openBizProfileLive", "openWebTopBarLive", "openWebViewUseFastLoad", "Lorg/json/JSONObject;", "ret", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "preCreateWebView", "preloadByIdAndUrls", "preloadByInfoIdAndBuffer", "preloadTimelineCanvas", "preloadTimelineRecCard", "preloadTimelineVideoChannel", "recycleTimelineCanvas", "safeExecute", "block", "Lkotlin/Function0;", "safePreload", "saveChannelFeeds", "channelFeeds", "setChatSession", "setRecommendReportData", "reportData", "shareMpVideoToSns", "activity", "Lcom/tencent/mm/ui/MMActivity;", "currentEnterId", "startPreloadWebView", "isNative", "intent", "Landroid/content/Intent;", "openType", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "tryPreloadTmplWebview", "updateChannelFeeds", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "Companion", "plugin-brandservice_release"})
public final class c
  implements com.tencent.mm.plugin.brandservice.a.c
{
  private static final MMCacheSlotManager soA;
  private static final MMCacheSlotManager soB;
  private static final MMCacheSlotManager soC;
  public static final a soD;
  private final String TAG;
  private final kotlin.f lrB;
  private final kotlin.f ocu;
  private final ConcurrentHashMap<String, Long> soy;
  private final long soz;
  
  static
  {
    AppMethodBeat.i(6487);
    soD = new a((byte)0);
    soA = new MMCacheSlotManager();
    soB = new MMCacheSlotManager();
    soC = new MMCacheSlotManager();
    AppMethodBeat.o(6487);
  }
  
  public c()
  {
    AppMethodBeat.i(6486);
    this.TAG = "MicroMsg.BrandServiceImpl";
    this.lrB = g.ar((kotlin.g.a.a)new i(this));
    this.soy = new ConcurrentHashMap();
    this.soz = 15000L;
    this.ocu = g.ar((kotlin.g.a.a)h.soL);
    AppMethodBeat.o(6486);
  }
  
  private final void B(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(259558);
    long l = System.currentTimeMillis() - PluginBiz.startTime;
    if ((l < this.soz) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG))
    {
      com.tencent.e.h.ZvG.o((Runnable)new o(parama), Math.max(this.soz - l, 5000L));
      AppMethodBeat.o(259558);
      return;
    }
    parama.invoke();
    AppMethodBeat.o(259558);
  }
  
  private final void C(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(259570);
    btS().post((Runnable)new p(this, parama));
    AppMethodBeat.o(259570);
  }
  
  private final MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(259507);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.lrB.getValue();
    AppMethodBeat.o(259507);
    return localMultiProcessMMKV;
  }
  
  private MMHandler btS()
  {
    AppMethodBeat.i(259569);
    MMHandler localMMHandler = (MMHandler)this.ocu.getValue();
    AppMethodBeat.o(259569);
    return localMMHandler;
  }
  
  public final boolean E(Object paramObject1, Object paramObject2)
  {
    Object localObject = null;
    AppMethodBeat.i(6485);
    if (!(paramObject1 instanceof z)) {
      paramObject1 = null;
    }
    for (;;)
    {
      z localz = (z)paramObject1;
      if (!(paramObject2 instanceof v)) {}
      for (paramObject1 = localObject;; paramObject1 = paramObject2)
      {
        boolean bool = com.tencent.mm.plugin.brandservice.ui.b.a.a(localz, (v)paramObject1);
        AppMethodBeat.o(6485);
        return bool;
      }
    }
  }
  
  public final boolean Gv(int paramInt)
  {
    AppMethodBeat.i(6459);
    if (paramInt == 5)
    {
      AppMethodBeat.o(6459);
      return true;
    }
    AppMethodBeat.o(6459);
    return false;
  }
  
  public final boolean Gw(int paramInt)
  {
    AppMethodBeat.i(6476);
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.Gw(paramInt);
    AppMethodBeat.o(6476);
    return bool;
  }
  
  public final void Gx(int paramInt)
  {
    AppMethodBeat.i(6479);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.run(paramInt);
    AppMethodBeat.o(6479);
  }
  
  public final com.tencent.mm.plugin.brandservice.a.a Gy(int paramInt)
  {
    AppMethodBeat.i(259542);
    com.tencent.mm.plugin.brandservice.a.a locala = (com.tencent.mm.plugin.brandservice.a.a)new com.tencent.mm.pluginsdk.model.a(paramInt);
    AppMethodBeat.o(259542);
    return locala;
  }
  
  public final boolean Gz(int paramInt)
  {
    AppMethodBeat.i(259552);
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.item.l.Gz(paramInt);
    AppMethodBeat.o(259552);
    return bool;
  }
  
  public final void O(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(259556);
    kotlin.g.b.p.k(paramString1, "path");
    kotlin.g.b.p.k(paramString2, "canvasId");
    kotlin.g.b.p.k(paramString3, "data");
    r localr = r.VcW;
    if (r.hvU()) {
      B((kotlin.g.a.a)new m(this, paramString1, paramString2, paramString3));
    }
    AppMethodBeat.o(259556);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259543);
    kotlin.g.b.p.k(paramContext, "context");
    com.tencent.mm.pluginsdk.model.b.QTJ.b(paramContext, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(259543);
  }
  
  public final void a(Context paramContext, JSONObject paramJSONObject, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(175450);
    kotlin.g.b.p.k(paramHashMap, "ret");
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(175450);
      return;
    }
    int i = paramJSONObject.optInt("item_show_type");
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (i == 5)
    {
      localObject1 = com.tencent.mm.plugin.webview.ui.tools.video.a.QvS;
      if ((com.tencent.mm.plugin.webview.ui.tools.video.a.hbB()) && (paramJSONObject != null))
      {
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "saveVideo openwebviewusefastload");
        localObject1 = paramJSONObject.optString("vid");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label434;
        }
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "saveVideo openwebviewusefastload vid null");
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1061L, 21L, 1L, false);
      localBundle.putString("url", paramJSONObject.optString("url"));
      localBundle.putInt("item_show_type", paramJSONObject.optInt("item_show_type"));
      localBundle.putInt("scene", paramJSONObject.optInt("scene"));
      localBundle.putInt("subscene", paramJSONObject.optInt("subscene"));
      localBundle.putInt("openType", paramJSONObject.optInt("openType"));
      localBundle.putString("biz_video_channel_session_id", paramJSONObject.optString("channelSessionId"));
      Object localObject2 = new com.tencent.mm.plugin.brandservice.a.c.a();
      Object localObject3 = new Intent();
      i = localBundle.getInt("scene");
      int j = localBundle.getInt("subscene", 10000);
      localObject1 = localBundle.getString("url");
      paramJSONObject = (JSONObject)localObject1;
      if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).isMpUrl((String)localObject1))
      {
        k = (int)(System.currentTimeMillis() / 1000L);
        paramJSONObject = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).e((String)localObject1, i, j, k);
      }
      localObject1 = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
      int k = localBundle.getInt("item_show_type");
      localBundle.getBoolean("isNativePage");
      boolean bool = ((com.tencent.mm.plugin.brandservice.a.c)localObject1).a(paramContext, paramJSONObject, k, i, j, (Intent)localObject3, localBundle.getInt("openType"), (com.tencent.mm.plugin.brandservice.a.c.a)localObject2);
      ((Map)paramHashMap).put("success", Boolean.valueOf(bool));
      if ((!((com.tencent.mm.plugin.brandservice.a.c.a)localObject2).success) && (((com.tencent.mm.plugin.brandservice.a.c.a)localObject2).message != null))
      {
        paramContext = (Map)paramHashMap;
        paramJSONObject = ((com.tencent.mm.plugin.brandservice.a.c.a)localObject2).message;
        kotlin.g.b.p.j(paramJSONObject, "result.message");
        paramContext.put("desc", paramJSONObject);
      }
      AppMethodBeat.o(175450);
      return;
      label434:
      i = (int)Util.getFloat(paramJSONObject.optString("videoInitialTime"), 0.0F);
      localObject2 = paramJSONObject.optString("videoInitialSnapshot");
      if (Util.isNullOrNil((String)localObject2))
      {
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "saveVideo openwebviewusefastload bitmap null");
      }
      else
      {
        localObject3 = (MultiProcessMMKV)com.tencent.mm.plugin.webview.ui.tools.video.a.QvR.getSlotForWrite();
        ((MultiProcessMMKV)localObject3).encode("MicroMsg.MPVideoPreviewDataMgr_" + (String)localObject1 + "_playTime", i);
        ((MultiProcessMMKV)localObject3).encode("MicroMsg.MPVideoPreviewDataMgr_" + (String)localObject1 + "_expire", System.currentTimeMillis() / 1000L + 600L);
        ((MultiProcessMMKV)localObject3).encode("MicroMsg.MPVideoPreviewDataMgr_" + (String)localObject1 + "_bitmap", (String)localObject2);
        com.tencent.mm.plugin.webview.ui.tools.video.a.bnh((String)localObject1);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.brandservice.a.c.b paramb)
  {
    AppMethodBeat.i(175449);
    com.tencent.mm.plugin.brandservice.b.d locald = com.tencent.mm.plugin.brandservice.b.d.swc;
    com.tencent.mm.plugin.brandservice.b.d.b(paramb);
    AppMethodBeat.o(175449);
  }
  
  public final void a(jd paramjd, MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(259518);
    com.tencent.mm.plugin.webview.ui.tools.media.c localc = com.tencent.mm.plugin.webview.ui.tools.media.c.Qud;
    com.tencent.mm.plugin.webview.ui.tools.media.c.b(paramjd, paramMMActivity, paramInt);
    AppMethodBeat.o(259518);
  }
  
  public final void a(final String paramString, final int paramInt1, final int paramInt2, final Object... paramVarArgs)
  {
    AppMethodBeat.i(6461);
    kotlin.g.b.p.k(paramString, "url");
    kotlin.g.b.p.k(paramVarArgs, "vals");
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apI(paramString);
    if (soA.contains(str))
    {
      AppMethodBeat.o(6461);
      return;
    }
    soA.add(str);
    Log.v(this.TAG, "preloadData: addToPreload:".concat(String.valueOf(str)));
    com.tencent.e.h.ZvG.d((Runnable)new b(this, paramString, paramInt1, paramInt2, paramVarArgs), "tmplPreload");
    AppMethodBeat.o(6461);
  }
  
  public final void a(String paramString1, com.tencent.mm.aj.y paramy, String paramString2, com.tencent.mm.ipcinvoker.f<Bundle> paramf)
  {
    AppMethodBeat.i(6482);
    kotlin.g.b.p.k(paramString1, "toUser");
    kotlin.g.b.p.k(paramy, "msgInfo");
    kotlin.g.b.p.k(paramf, "callback");
    com.tencent.mm.plugin.webview.ui.tools.media.d locald = com.tencent.mm.plugin.webview.ui.tools.media.d.Qug;
    com.tencent.mm.plugin.webview.ui.tools.media.d.b(paramString1, paramy, paramString2, paramf);
    AppMethodBeat.o(6482);
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(259522);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramString, "url");
    kotlin.g.b.p.k(paramIntent, "intent");
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramIntent, 0, null, false, 896);
    AppMethodBeat.o(259522);
    return bool;
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, com.tencent.mm.plugin.brandservice.a.c.a parama)
  {
    AppMethodBeat.i(259523);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramString, "url");
    kotlin.g.b.p.k(paramIntent, "intent");
    kotlin.g.b.p.k(parama, "result");
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramIntent, paramInt4, parama, false, 512);
    AppMethodBeat.o(259523);
    return bool;
  }
  
  public final boolean apb(String paramString)
  {
    AppMethodBeat.i(259508);
    if (paramString != null)
    {
      boolean bool = UrlExKt.isMpArticleUrl(paramString);
      AppMethodBeat.o(259508);
      return bool;
    }
    AppMethodBeat.o(259508);
    return false;
  }
  
  public final com.tencent.mm.aj.p apc(String paramString)
  {
    AppMethodBeat.i(6473);
    h.a locala = h.a.swy;
    paramString = h.a.apx(paramString);
    AppMethodBeat.o(6473);
    return paramString;
  }
  
  public final void apd(String paramString)
  {
    AppMethodBeat.i(6483);
    kotlin.g.b.p.k(paramString, "chatName");
    ((Map)this.soy).put(paramString, Long.valueOf(MMSlotKt.now()));
    AppMethodBeat.o(6483);
  }
  
  public final long ape(String paramString)
  {
    AppMethodBeat.i(6484);
    kotlin.g.b.p.k(paramString, "chatName");
    paramString = (Long)this.soy.get(paramString);
    if (paramString != null)
    {
      long l = paramString.longValue();
      AppMethodBeat.o(6484);
      return l;
    }
    AppMethodBeat.o(6484);
    return -1L;
  }
  
  public final String apf(String paramString)
  {
    AppMethodBeat.i(175443);
    kotlin.g.b.p.k(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apQ(paramString);
    AppMethodBeat.o(175443);
    return paramString;
  }
  
  public final String apg(String paramString)
  {
    AppMethodBeat.i(259534);
    com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
    paramString = com.tencent.mm.pluginsdk.model.b.bpq(paramString);
    AppMethodBeat.o(259534);
    return paramString;
  }
  
  public final int aph(String paramString)
  {
    AppMethodBeat.i(259535);
    com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
    int i = com.tencent.mm.pluginsdk.model.b.bpr(paramString);
    AppMethodBeat.o(259535);
    return i;
  }
  
  public final boolean api(String paramString)
  {
    AppMethodBeat.i(259539);
    com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
    boolean bool = com.tencent.mm.pluginsdk.model.b.bmt(paramString);
    AppMethodBeat.o(259539);
    return bool;
  }
  
  public final void apj(String paramString)
  {
    AppMethodBeat.i(175448);
    Log.d(this.TAG, "alvinluo saveChannelFeeds %s", new Object[] { paramString });
    bcJ().putString("video_channel_feeds_data", paramString);
    AppMethodBeat.o(175448);
  }
  
  public final void apk(String paramString)
  {
    AppMethodBeat.i(259563);
    kotlin.g.b.p.k(paramString, "canvasId");
    Object localObject = r.VcW;
    if (r.hvM())
    {
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.item.y.sFw.cAO();
      kotlin.g.b.p.k(paramString, "canvasId");
      if (((com.tencent.mm.plugin.webcanvas.c)localObject).PtI.containsKey(paramString))
      {
        Integer localInteger = (Integer)((com.tencent.mm.plugin.webcanvas.c)localObject).PtI.get(paramString);
        if (localInteger != null)
        {
          kotlin.g.b.p.j(localInteger, "contextId");
          ((com.tencent.mm.plugin.webcanvas.c)localObject).By(localInteger.intValue());
          Log.i(((com.tencent.mm.plugin.webcanvas.c)localObject).TAG, "recycleContext canvasId=".concat(String.valueOf(paramString)));
        }
        ((com.tencent.mm.plugin.webcanvas.c)localObject).PtI.remove(paramString);
      }
    }
    AppMethodBeat.o(259563);
  }
  
  public final void apl(String paramString)
  {
    AppMethodBeat.i(259567);
    p.a locala = com.tencent.mm.model.p.lrH;
    com.tencent.mm.model.p.Pf(paramString);
    AppMethodBeat.o(259567);
  }
  
  public final void c(jd paramjd)
  {
    AppMethodBeat.i(259517);
    com.tencent.mm.plugin.webview.ui.tools.media.f localf = com.tencent.mm.plugin.webview.ui.tools.media.f.Quk;
    com.tencent.mm.plugin.webview.ui.tools.media.f.d(paramjd);
    AppMethodBeat.o(259517);
  }
  
  public final void cY(String paramString, final int paramInt)
  {
    AppMethodBeat.i(175441);
    if (paramString == null)
    {
      AppMethodBeat.o(175441);
      return;
    }
    com.tencent.e.h.ZvG.d((Runnable)new e(paramString, paramInt), "getAppMsgRelatedInfo");
    AppMethodBeat.o(175441);
  }
  
  public final void cZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(6475);
    kotlin.g.b.p.k(paramString, "url");
    com.tencent.mm.plugin.brandservice.b.b.svR.cZ(paramString, paramInt);
    AppMethodBeat.o(6475);
  }
  
  public final void cp(List<? extends com.tencent.mm.aj.q> paramList)
  {
    AppMethodBeat.i(259515);
    kotlin.g.b.p.k(paramList, "items");
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(259515);
      return;
    }
    com.tencent.e.h.ZvG.d((Runnable)new f(paramList), "getAppMsgRelatedInfo");
    AppMethodBeat.o(259515);
  }
  
  public final boolean cyB()
  {
    AppMethodBeat.i(6474);
    com.tencent.mm.plugin.brandservice.b.b localb = com.tencent.mm.plugin.brandservice.b.b.svR;
    boolean bool = com.tencent.mm.plugin.brandservice.b.b.cyB();
    AppMethodBeat.o(6474);
    return bool;
  }
  
  public final String cyC()
  {
    AppMethodBeat.i(6480);
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.cDp();
    AppMethodBeat.o(6480);
    return str;
  }
  
  public final void cyD()
  {
    AppMethodBeat.i(6481);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.cDO();
    AppMethodBeat.o(6481);
  }
  
  public final int cyE()
  {
    AppMethodBeat.i(259530);
    int i = ab.getSessionId();
    AppMethodBeat.o(259530);
    return i;
  }
  
  public final boolean cyF()
  {
    AppMethodBeat.i(259536);
    com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
    boolean bool = ((Boolean)com.tencent.mm.pluginsdk.model.b.QTz.getValue()).booleanValue();
    AppMethodBeat.o(259536);
    return bool;
  }
  
  public final boolean cyG()
  {
    AppMethodBeat.i(259538);
    com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
    boolean bool = ((Boolean)com.tencent.mm.pluginsdk.model.b.QTA.getValue()).booleanValue();
    AppMethodBeat.o(259538);
    return bool;
  }
  
  public final void cyH()
  {
    AppMethodBeat.i(259544);
    com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
    com.tencent.mm.pluginsdk.model.b.onResume();
    AppMethodBeat.o(259544);
  }
  
  public final String cyI()
  {
    AppMethodBeat.i(175447);
    String str2 = bcJ().getString("video_channel_feeds_data", "");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(175447);
    return str1;
  }
  
  public final void cyJ()
  {
    AppMethodBeat.i(259561);
    r localr = r.VcW;
    if (r.hvU()) {
      C((kotlin.g.a.a)new l(this));
    }
    AppMethodBeat.o(259561);
  }
  
  public final void cyK()
  {
    AppMethodBeat.i(259566);
    Object localObject = r.VcW;
    if (r.hvU())
    {
      localObject = com.tencent.mm.plugin.brandservice.b.d.swc;
      if (com.tencent.mm.plugin.brandservice.b.d.czj()) {
        C((kotlin.g.a.a)n.soN);
      }
    }
    AppMethodBeat.o(259566);
  }
  
  public final String e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6457);
    paramString = com.tencent.mm.aj.m.e(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(6457);
    return paramString;
  }
  
  public final boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(6453);
    if (paramString != null)
    {
      boolean bool = UrlExKt.isMpUrl(paramString);
      AppMethodBeat.o(6453);
      return bool;
    }
    AppMethodBeat.o(6453);
    return false;
  }
  
  public final void j(List<? extends List<String>> paramList, final int paramInt)
  {
    AppMethodBeat.i(6469);
    kotlin.g.b.p.k(paramList, "items");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    int i;
    label117:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apI((String)((List)localObject2).get(0));
      if (soA.contains((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label117;
        }
        paramList.add(localObject2);
        break;
        soA.add((String)localObject3);
      }
    }
    paramList = (List)paramList;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      if (Log.getLogLevel() == 0)
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("preloadData: preloadByIdAndUrls:");
        Object localObject4 = (Iterable)paramList;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            ((Collection)localObject3).add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apI((String)((List)((Iterator)localObject4).next()).get(0)));
            continue;
            i = 0;
            break;
          }
        }
        Log.v((String)localObject1, (List)localObject3);
      }
      com.tencent.e.h.ZvG.d((Runnable)new j(paramList, this, paramInt), "tmplPreload");
    }
    AppMethodBeat.o(6469);
  }
  
  public final void k(List<String[]> paramList, final int paramInt)
  {
    AppMethodBeat.i(6470);
    kotlin.g.b.p.k(paramList, "items");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    int i;
    label110:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apI(((String[])localObject2)[0]);
      if (soA.contains((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label110;
        }
        paramList.add(localObject2);
        break;
        soA.add((String)localObject3);
      }
    }
    paramList = (List)paramList;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      if (Log.getLogLevel() == 0)
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("preloadData: preloadByInfoIdAndBuffer:");
        Object localObject4 = (Iterable)paramList;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            ((Collection)localObject3).add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apI(((String[])localObject4.next())[0]));
            continue;
            i = 0;
            break;
          }
        }
        Log.v((String)localObject1, (List)localObject3);
      }
      com.tencent.e.h.ZvG.d((Runnable)new k(paramList, this, paramInt), "tmplPreload");
    }
    AppMethodBeat.o(6470);
  }
  
  public final void l(List<? extends com.tencent.mm.aj.q> paramList, final int paramInt)
  {
    AppMethodBeat.i(6471);
    kotlin.g.b.p.k(paramList, "items");
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(6471);
      return;
    }
    com.tencent.e.h.ZvG.d((Runnable)new g(paramList, paramInt), "getAppMsgRelatedInfo");
    AppMethodBeat.o(6471);
  }
  
  public final void n(String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(259553);
    kotlin.g.b.p.k(paramString3, "event");
    B((kotlin.g.a.a)new c(paramString1, paramString2, paramString3, paramString4));
    AppMethodBeat.o(259553);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl$Companion;", "", "()V", "KEY_BIZ_CANVAS_PRELOAD_CANVAS_LAST_TIME", "", "KEY_BIZ_CANVAS_PRELOAD_CRASH_TIMES", "preauthLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthLimiter", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "prednsLimiter", "getPrednsLimiter", "preloadLimiter", "getPreloadLimiter", "plugin-brandservice_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc, String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(6448);
      try
      {
        String str = paramString;
        int i = paramInt1;
        int j = paramInt2;
        Object[] arrayOfObject = paramVarArgs;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(str, i, j, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
        AppMethodBeat.o(6448);
        return;
      }
      catch (Exception localException)
      {
        Log.w(c.a(this.soE), "addToPreload ex %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(6448);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(6449);
      com.tencent.mm.plugin.brandservice.b.h localh = com.tencent.mm.plugin.brandservice.b.h.swx;
      com.tencent.mm.plugin.brandservice.b.h.k(this.piM, paramInt, this.soG, this.soK);
      AppMethodBeat.o(6449);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(265214);
      Object localObject1 = com.tencent.mm.plugin.brandservice.b.h.swx;
      localObject1 = this.mpK;
      int i = this.soG;
      kotlin.g.b.p.k(localObject1, "items");
      com.tencent.mm.plugin.brandservice.b.h.swv = 0L;
      com.tencent.mm.plugin.brandservice.b.h.sww.clear();
      LinkedList localLinkedList = new LinkedList();
      Object localObject3 = (Iterable)localObject1;
      Object localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject4;
      Object localObject5;
      label147:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (com.tencent.mm.aj.q)localObject4;
        if (((com.tencent.mm.aj.q)localObject5).Url == null) {}
        for (boolean bool = false;; bool = UrlExKt.isMpArticleUrl((String)localObject5))
        {
          if (!bool) {
            break label147;
          }
          ((Collection)localObject2).add(localObject4);
          break;
          localObject5 = ((com.tencent.mm.aj.q)localObject5).Url;
          kotlin.g.b.p.j(localObject5, "it.Url");
        }
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.aj.q)((Iterator)localObject2).next();
        localObject4 = new fu();
        ((fu)localObject4).Url = ((com.tencent.mm.aj.q)localObject3).Url;
        localObject5 = ((fu)localObject4).Url;
        kotlin.g.b.p.j(localObject5, "appMsgUrlInfo.Url");
        ((fu)localObject4).lps = com.tencent.mm.plugin.brandservice.b.h.apv((String)localObject5);
        ((fu)localObject4).lpx = ((com.tencent.mm.aj.q)localObject3).lpx;
        ((fu)localObject4).lpw = ((com.tencent.mm.aj.q)localObject3).lpw;
        if (((fu)localObject4).lpw > 0) {
          localLinkedList.add(localObject4);
        }
      }
      Log.v(com.tencent.mm.plugin.brandservice.b.h.TAG, "getAppMsgRelatedInfoForAppMsg size:" + ((List)localObject1).size());
      com.tencent.mm.plugin.brandservice.b.h.b(localLinkedList, i);
      AppMethodBeat.o(265214);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(List paramList, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(6450);
      Object localObject1 = com.tencent.mm.plugin.brandservice.b.h.swx;
      Object localObject2 = this.mpK;
      int i = paramInt;
      kotlin.g.b.p.k(localObject2, "items");
      com.tencent.mm.plugin.brandservice.b.h.swv = 0L;
      com.tencent.mm.plugin.brandservice.b.h.sww.clear();
      localObject1 = new LinkedList();
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject4;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.aj.q)((Iterator)localObject3).next();
        j.a((Collection)localObject2, (Iterable)((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(((com.tencent.mm.aj.q)localObject4).msgId, ((com.tencent.mm.aj.q)localObject4).lpy).lpz);
      }
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject5;
      label241:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (v)localObject4;
        if (((v)localObject5).url == null) {}
        for (boolean bool = false;; bool = UrlExKt.isMpArticleUrl((String)localObject5))
        {
          if (!bool) {
            break label241;
          }
          ((Collection)localObject2).add(localObject4);
          break;
          localObject5 = ((v)localObject5).url;
          kotlin.g.b.p.j(localObject5, "it.url");
        }
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (v)((Iterator)localObject2).next();
        localObject3 = new fu();
        ((fu)localObject3).Url = ((v)localObject4).url;
        localObject5 = ((fu)localObject3).Url;
        kotlin.g.b.p.j(localObject5, "appMsgUrlInfo.Url");
        ((fu)localObject3).lps = com.tencent.mm.plugin.brandservice.b.h.apv((String)localObject5);
        ((fu)localObject3).lpx = ((v)localObject4).type;
        ((fu)localObject3).RKR = ((v)localObject4).lqf;
        if (i == 0)
        {
          if (((v)localObject4).lls == 1)
          {
            localObject4 = com.tencent.mm.plugin.brandservice.b.b.svR;
            if (com.tencent.mm.plugin.brandservice.b.b.cyB())
            {
              ((fu)localObject3).lpw = 2;
              ((LinkedList)localObject1).add(localObject3);
            }
          }
        }
        else
        {
          if (((v)localObject4).lls == 1)
          {
            localObject4 = com.tencent.mm.plugin.brandservice.b.b.svR;
            if (!com.tencent.mm.plugin.brandservice.b.b.cyB()) {}
          }
          for (((fu)localObject3).lpw = 3;; ((fu)localObject3).lpw = 1)
          {
            ((LinkedList)localObject1).add(localObject3);
            break;
          }
        }
      }
      Log.v(com.tencent.mm.plugin.brandservice.b.h.TAG, "getAppMsgRelatedInfoForBizMsg size:" + ((LinkedList)localObject1).size());
      com.tencent.mm.plugin.brandservice.b.h.b((LinkedList)localObject1, i);
      AppMethodBeat.o(6450);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MMHandler>
  {
    public static final h soL;
    
    static
    {
      AppMethodBeat.i(265660);
      soL = new h();
      AppMethodBeat.o(265660);
    }
    
    h()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/brandservice/BrandServiceImpl$preloadByIdAndUrls$2$2"})
  static final class j
    implements Runnable
  {
    j(List paramList, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(6451);
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.j(this.rcs, paramInt);
      AppMethodBeat.o(6451);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/brandservice/BrandServiceImpl$preloadByInfoIdAndBuffer$2$2"})
  static final class k
    implements Runnable
  {
    k(List paramList, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(6452);
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.k(this.rcs, paramInt);
      AppMethodBeat.o(6452);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    l(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(c paramc, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final n soN;
    
    static
    {
      AppMethodBeat.i(263956);
      soN = new n();
      AppMethodBeat.o(263956);
    }
    
    n()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(265678);
      this.$block.invoke();
      AppMethodBeat.o(265678);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(c paramc, kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(266999);
      com.tencent.mm.plugin.biz.b.c localc = com.tencent.mm.plugin.biz.b.c.shz;
      int i = com.tencent.mm.plugin.biz.b.c.cxK().decodeInt("biz_canvas_card_preload_crash_times", 0);
      localc = com.tencent.mm.plugin.biz.b.c.shz;
      if (!com.tencent.mm.plugin.biz.b.c.a(i, 0L, "biz_canvas_card_preload_last_time", 10L))
      {
        AppMethodBeat.o(266999);
        return;
      }
      localc = com.tencent.mm.plugin.biz.b.c.shz;
      com.tencent.mm.plugin.biz.b.c.cxK().encode("biz_canvas_card_preload_crash_times", i + 1);
      Log.i(c.a(this.soE), "safePreload set crash flag");
      parama.invoke();
      localc = com.tencent.mm.plugin.biz.b.c.shz;
      com.tencent.mm.plugin.biz.b.c.cxK().encode("biz_canvas_card_preload_crash_times", 0);
      Log.i(c.a(this.soE), "safePreload reset crash flag");
      AppMethodBeat.o(266999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c
 * JD-Core Version:    0.7.0.1
 */