package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.message.q;
import com.tencent.mm.message.v;
import com.tencent.mm.message.y;
import com.tencent.mm.model.p.a;
import com.tencent.mm.plugin.biz.PluginBiz;
import com.tencent.mm.plugin.brandservice.model.d;
import com.tencent.mm.plugin.brandservice.model.h.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine.Companion;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.webview.ui.tools.media.e;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.threadpool.i;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "()V", "TAG", "", "chatSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "minPreloadTime", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "addReportParamForBizUrl", "url", "scene", "", "subScene", "clickTime", "addToPreload", "", "itemShowType", "openScene", "vals", "", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "appMsgPaySuccess", "canPreloadIn", "", "dispatchEvent", "appId", "event", "data", "doPreloadTimelineRecCard", "path", "canvasId", "msgId", "doSendMpShareVideoMsg", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "favMpVideo", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "getAppMsgRelatedInfo", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "reqType", "getAppMsgRelatedInfoForAppMsg", "items", "", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getBizFinderLiveChecker", "Lcom/tencent/mm/plugin/brandservice/api/IBizFinderLiveChecker;", "getBizTimeLineSessionId", "getChannelFeeds", "getChatSession", "chatName", "getFinderLiveExportId", "userName", "getFinderLiveScene", "getHardCodeUrl", "getOfficialAccountPos", "getTimelineCanvasPkgVersion", "getUrlKey", "isBizNativePageOpen", "isBizTimeLineOpen", "isCanvasPreloaded", "isFinderLiveNow", "isMpArticle", "isMpUrl", "isPayReadingOpen", "isShowBigPic", "baseInfo", "baseTopItem", "count", "isSupportStyle", "style", "onFinderLiveClick", "context", "Landroid/content/Context;", "bizUserName", "finderFeedExportId", "liveScene", "bypass", "onResumeCheckFinderLive", "openBizProfileLive", "openWebTopBarLive", "openWebViewUseFastLoad", "Lorg/json/JSONObject;", "ret", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "preCreateWebView", "preloadByIdAndUrls", "preloadByInfoIdAndBuffer", "preloadTimelineCanvas", "preloadTimelineRecCard", "preloadTimelineVideoChannel", "recycleTimelineCanvas", "removeAllBizPreloadData", "safeExecute", "block", "Lkotlin/Function0;", "safePreload", "saveChannelFeeds", "channelFeeds", "setChatSession", "setRecommendReportData", "reportData", "shareMpVideoToSns", "activity", "Lcom/tencent/mm/ui/MMActivity;", "currentEnterId", "startPreloadWebView", "isNative", "intent", "Landroid/content/Intent;", "openType", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "tryPreloadTmplWebview", "updateChannelFeeds", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.plugin.brandservice.api.c
{
  public static final a vAt;
  private static final MMCacheSlotManager vAw;
  private static final MMCacheSlotManager vAx;
  private static final MMCacheSlotManager vAy;
  private final String TAG;
  private final j exj;
  private final j rdm;
  private final ConcurrentHashMap<String, Long> vAu;
  private final long vAv;
  
  static
  {
    AppMethodBeat.i(6487);
    vAt = new a((byte)0);
    vAw = new MMCacheSlotManager();
    vAx = new MMCacheSlotManager();
    vAy = new MMCacheSlotManager();
    AppMethodBeat.o(6487);
  }
  
  public c()
  {
    AppMethodBeat.i(6486);
    this.TAG = "MicroMsg.BrandServiceImpl";
    this.exj = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.vAu = new ConcurrentHashMap();
    this.vAv = 15000L;
    this.rdm = kotlin.k.cm((kotlin.g.a.a)d.vAB);
    AppMethodBeat.o(6486);
  }
  
  private static final void a(c paramc, kotlin.g.a.a parama)
  {
    AppMethodBeat.i(301577);
    s.u(paramc, "this$0");
    s.u(parama, "$block");
    com.tencent.mm.plugin.biz.b.c localc = com.tencent.mm.plugin.biz.b.c.vtp;
    int i = com.tencent.mm.plugin.biz.b.c.daA().decodeInt("biz_canvas_card_preload_crash_times", 0);
    localc = com.tencent.mm.plugin.biz.b.c.vtp;
    if (!com.tencent.mm.plugin.biz.b.c.b(i, 0L, "biz_canvas_card_preload_last_time", 10L))
    {
      AppMethodBeat.o(301577);
      return;
    }
    localc = com.tencent.mm.plugin.biz.b.c.vtp;
    com.tencent.mm.plugin.biz.b.c.daA().encode("biz_canvas_card_preload_crash_times", i + 1);
    Log.i(paramc.TAG, "safePreload set crash flag");
    parama.invoke();
    parama = com.tencent.mm.plugin.biz.b.c.vtp;
    com.tencent.mm.plugin.biz.b.c.daA().encode("biz_canvas_card_preload_crash_times", 0);
    Log.i(paramc.TAG, "safePreload reset crash flag");
    AppMethodBeat.o(301577);
  }
  
  private static final void a(String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject, c paramc)
  {
    AppMethodBeat.i(301551);
    s.u(paramString, "$url");
    s.u(paramArrayOfObject, "$vals");
    s.u(paramc, "this$0");
    try
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(paramString, paramInt1, paramInt2, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      AppMethodBeat.o(301551);
      return;
    }
    catch (Exception paramString)
    {
      Log.w(paramc.TAG, "addToPreload ex %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(301551);
    }
  }
  
  private final void aB(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(301535);
    long l = System.currentTimeMillis() - PluginBiz.startTime;
    if ((l < this.vAv) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG))
    {
      com.tencent.threadpool.h.ahAA.p(new c..ExternalSyntheticLambda7(parama), Math.max(this.vAv - l, 5000L));
      AppMethodBeat.o(301535);
      return;
    }
    parama.invoke();
    AppMethodBeat.o(301535);
  }
  
  private final void aC(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(301547);
    getHandler().post(new c..ExternalSyntheticLambda0(this, parama));
    AppMethodBeat.o(301547);
  }
  
  private static final void aD(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(301572);
    s.u(parama, "$block");
    parama.invoke();
    AppMethodBeat.o(301572);
  }
  
  private final MultiProcessMMKV atj()
  {
    AppMethodBeat.i(301529);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.exj.getValue();
    AppMethodBeat.o(301529);
    return localMultiProcessMMKV;
  }
  
  private MMHandler getHandler()
  {
    AppMethodBeat.i(301541);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(301541);
    return localMMHandler;
  }
  
  private static final void k(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(301566);
    com.tencent.mm.plugin.brandservice.model.h localh = com.tencent.mm.plugin.brandservice.model.h.vCa;
    com.tencent.mm.plugin.brandservice.model.h.l(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(301566);
  }
  
  private static final void v(List paramList, int paramInt)
  {
    AppMethodBeat.i(301553);
    s.u(paramList, "$it");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.s(paramList, paramInt);
    AppMethodBeat.o(301553);
  }
  
  private static final void w(List paramList, int paramInt)
  {
    AppMethodBeat.i(301556);
    s.u(paramList, "$it");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.t(paramList, paramInt);
    AppMethodBeat.o(301556);
  }
  
  private static final void x(List paramList, int paramInt)
  {
    AppMethodBeat.i(301564);
    s.u(paramList, "$items");
    Object localObject1 = com.tencent.mm.plugin.brandservice.model.h.vCa;
    s.u(paramList, "items");
    com.tencent.mm.plugin.brandservice.model.h.vCd = 0L;
    com.tencent.mm.plugin.brandservice.model.h.vCe.clear();
    localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (q)((Iterator)localObject2).next();
      localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(((q)localObject3).msgId, ((q)localObject3).nUB).nUC;
      s.s(localObject3, "service(IAppMsgBizHelper….msgId, it.Content).items");
      kotlin.a.p.a(paramList, (Iterable)localObject3);
    }
    localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    label245:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (v)localObject3;
      if (((v)localObject4).url == null) {}
      for (boolean bool = false;; bool = UrlExKt.isMpArticleUrl((String)localObject4))
      {
        if (!bool) {
          break label245;
        }
        paramList.add(localObject3);
        break;
        localObject4 = ((v)localObject4).url;
        s.s(localObject4, "it.url");
      }
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject3 = (v)paramList.next();
      localObject2 = new go();
      ((go)localObject2).Url = ((v)localObject3).url;
      localObject4 = ((go)localObject2).Url;
      s.s(localObject4, "appMsgUrlInfo.Url");
      ((go)localObject2).nUv = com.tencent.mm.plugin.brandservice.model.h.aiQ((String)localObject4);
      ((go)localObject2).nUA = ((v)localObject3).type;
      ((go)localObject2).YIl = ((v)localObject3).nVh;
      if (paramInt == 0)
      {
        if (((v)localObject3).nQp == 1)
        {
          localObject3 = com.tencent.mm.plugin.brandservice.model.b.vBC;
          if (com.tencent.mm.plugin.brandservice.model.b.dbx())
          {
            ((go)localObject2).nUz = 2;
            ((LinkedList)localObject1).add(localObject2);
          }
        }
      }
      else
      {
        if (((v)localObject3).nQp == 1)
        {
          localObject3 = com.tencent.mm.plugin.brandservice.model.b.vBC;
          if (!com.tencent.mm.plugin.brandservice.model.b.dbx()) {}
        }
        for (((go)localObject2).nUz = 3;; ((go)localObject2).nUz = 1)
        {
          ((LinkedList)localObject1).add(localObject2);
          break;
        }
      }
    }
    Log.v(com.tencent.mm.plugin.brandservice.model.h.TAG, s.X("getAppMsgRelatedInfoForBizMsg size:", Integer.valueOf(((LinkedList)localObject1).size())));
    com.tencent.mm.plugin.brandservice.model.h.b((LinkedList)localObject1, paramInt);
    AppMethodBeat.o(301564);
  }
  
  private static final void y(List paramList, int paramInt)
  {
    AppMethodBeat.i(301571);
    s.u(paramList, "$items");
    Object localObject1 = com.tencent.mm.plugin.brandservice.model.h.vCa;
    s.u(paramList, "items");
    com.tencent.mm.plugin.brandservice.model.h.vCd = 0L;
    com.tencent.mm.plugin.brandservice.model.h.vCe.clear();
    localObject1 = new LinkedList();
    Object localObject3 = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    Object localObject5;
    label146:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (q)localObject4;
      if (((q)localObject5).Url == null) {}
      for (boolean bool = false;; bool = UrlExKt.isMpArticleUrl((String)localObject5))
      {
        if (!bool) {
          break label146;
        }
        ((Collection)localObject2).add(localObject4);
        break;
        localObject5 = ((q)localObject5).Url;
        s.s(localObject5, "it.Url");
      }
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (q)((Iterator)localObject2).next();
      localObject4 = new go();
      ((go)localObject4).Url = ((q)localObject3).Url;
      localObject5 = ((go)localObject4).Url;
      s.s(localObject5, "appMsgUrlInfo.Url");
      ((go)localObject4).nUv = com.tencent.mm.plugin.brandservice.model.h.aiQ((String)localObject5);
      ((go)localObject4).nUA = ((q)localObject3).nUA;
      ((go)localObject4).nUz = ((q)localObject3).nUz;
      if (((go)localObject4).nUz > 0) {
        ((LinkedList)localObject1).add(localObject4);
      }
    }
    Log.v(com.tencent.mm.plugin.brandservice.model.h.TAG, s.X("getAppMsgRelatedInfoForAppMsg size:", Integer.valueOf(paramList.size())));
    com.tencent.mm.plugin.brandservice.model.h.b((LinkedList)localObject1, paramInt);
    AppMethodBeat.o(301571);
  }
  
  public final boolean GU(int paramInt)
  {
    AppMethodBeat.i(6459);
    if (paramInt == 16)
    {
      AppMethodBeat.o(6459);
      return true;
    }
    AppMethodBeat.o(6459);
    return false;
  }
  
  public final boolean GV(int paramInt)
  {
    AppMethodBeat.i(6476);
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.GV(paramInt);
    AppMethodBeat.o(6476);
    return bool;
  }
  
  public final void GW(int paramInt)
  {
    AppMethodBeat.i(6479);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.run(paramInt);
    AppMethodBeat.o(6479);
  }
  
  public final com.tencent.mm.plugin.brandservice.api.a GX(int paramInt)
  {
    AppMethodBeat.i(301760);
    com.tencent.mm.plugin.brandservice.api.a locala = (com.tencent.mm.plugin.brandservice.api.a)new com.tencent.mm.pluginsdk.model.b(paramInt);
    AppMethodBeat.o(301760);
    return locala;
  }
  
  public final boolean GY(int paramInt)
  {
    AppMethodBeat.i(301818);
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.item.k.GY(paramInt);
    AppMethodBeat.o(301818);
    return bool;
  }
  
  public final boolean P(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(6485);
    if ((paramObject1 instanceof ab))
    {
      paramObject1 = (ab)paramObject1;
      if (!(paramObject2 instanceof v)) {
        break label49;
      }
    }
    label49:
    for (paramObject2 = (v)paramObject2;; paramObject2 = null)
    {
      boolean bool = com.tencent.mm.plugin.brandservice.ui.b.b.a(paramObject1, paramObject2);
      AppMethodBeat.o(6485);
      return bool;
      paramObject1 = null;
      break;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(301767);
    s.u(paramContext, "context");
    com.tencent.mm.pluginsdk.model.c.a(com.tencent.mm.pluginsdk.model.c.XPt, paramContext, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(301767);
  }
  
  public final void a(Context paramContext, JSONObject paramJSONObject, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(175450);
    s.u(paramHashMap, "ret");
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
      localObject1 = com.tencent.mm.plugin.webview.ui.tools.video.a.Xok;
      if ((com.tencent.mm.plugin.webview.ui.tools.video.a.iBO()) && (paramJSONObject != null))
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
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1061L, 21L, 1L, false);
      localBundle.putString("url", paramJSONObject.optString("url"));
      localBundle.putInt("item_show_type", paramJSONObject.optInt("item_show_type"));
      localBundle.putInt("scene", paramJSONObject.optInt("scene"));
      localBundle.putInt("subscene", paramJSONObject.optInt("subscene"));
      localBundle.putInt("openType", paramJSONObject.optInt("openType"));
      localBundle.putString("biz_video_channel_session_id", paramJSONObject.optString("channelSessionId"));
      Object localObject2 = new com.tencent.mm.plugin.brandservice.api.c.a();
      Object localObject3 = new Intent();
      i = localBundle.getInt("scene");
      int j = localBundle.getInt("subscene", 10000);
      localObject1 = localBundle.getString("url");
      paramJSONObject = (JSONObject)localObject1;
      if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).isMpUrl((String)localObject1))
      {
        k = (int)(System.currentTimeMillis() / 1000L);
        paramJSONObject = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).e((String)localObject1, i, j, k);
      }
      localObject1 = (com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
      int k = localBundle.getInt("item_show_type");
      localBundle.getBoolean("isNativePage");
      boolean bool = ((com.tencent.mm.plugin.brandservice.api.c)localObject1).a(paramContext, paramJSONObject, k, i, j, (Intent)localObject3, localBundle.getInt("openType"), (com.tencent.mm.plugin.brandservice.api.c.a)localObject2);
      ((Map)paramHashMap).put("success", Boolean.valueOf(bool));
      if ((!((com.tencent.mm.plugin.brandservice.api.c.a)localObject2).success) && (((com.tencent.mm.plugin.brandservice.api.c.a)localObject2).message != null))
      {
        paramContext = (Map)paramHashMap;
        paramJSONObject = ((com.tencent.mm.plugin.brandservice.api.c.a)localObject2).message;
        s.s(paramJSONObject, "result.message");
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
        localObject3 = (MultiProcessMMKV)com.tencent.mm.plugin.webview.ui.tools.video.a.Xom.getSlotForWrite();
        ((MultiProcessMMKV)localObject3).encode("MicroMsg.MPVideoPreviewDataMgr_" + localObject1 + "_playTime", i);
        ((MultiProcessMMKV)localObject3).encode("MicroMsg.MPVideoPreviewDataMgr_" + localObject1 + "_expire", System.currentTimeMillis() / 1000L + 600L);
        ((MultiProcessMMKV)localObject3).encode("MicroMsg.MPVideoPreviewDataMgr_" + localObject1 + "_bitmap", (String)localObject2);
        com.tencent.mm.plugin.webview.ui.tools.video.a.bmO((String)localObject1);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.brandservice.api.c.b paramb)
  {
    AppMethodBeat.i(175449);
    d locald = d.vBI;
    d.b(paramb);
    AppMethodBeat.o(175449);
  }
  
  public final void a(jz paramjz, MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(301695);
    com.tencent.mm.plugin.webview.ui.tools.media.b localb = com.tencent.mm.plugin.webview.ui.tools.media.b.Xmj;
    com.tencent.mm.plugin.webview.ui.tools.media.b.b(paramjz, paramMMActivity, paramInt);
    AppMethodBeat.o(301695);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(6461);
    s.u(paramString, "url");
    s.u(paramVarArgs, "vals");
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajj(paramString);
    if (vAw.contains(str))
    {
      AppMethodBeat.o(6461);
      return;
    }
    vAw.add(str);
    Log.v(this.TAG, s.X("preloadData: addToPreload:", str));
    com.tencent.threadpool.h.ahAA.g(new c..ExternalSyntheticLambda2(paramString, paramInt1, paramInt2, paramVarArgs, this), "tmplPreload");
    AppMethodBeat.o(6461);
  }
  
  public final void a(String paramString1, y paramy, String paramString2, f<Bundle> paramf)
  {
    AppMethodBeat.i(6482);
    s.u(paramString1, "toUser");
    s.u(paramy, "msgInfo");
    s.u(paramf, "callback");
    com.tencent.mm.plugin.webview.ui.tools.media.c localc = com.tencent.mm.plugin.webview.ui.tools.media.c.Xmk;
    com.tencent.mm.plugin.webview.ui.tools.media.c.b(paramString1, paramy, paramString2, paramf);
    AppMethodBeat.o(6482);
  }
  
  public final void a(final String paramString1, final String paramString2, final String paramString3, final long paramLong)
  {
    AppMethodBeat.i(301834);
    s.u(paramString1, "path");
    s.u(paramString2, "canvasId");
    s.u(paramString3, "data");
    r localr = r.acDM;
    if (r.iXx()) {
      aB((kotlin.g.a.a)new g(this, paramString1, paramString2, paramString3, paramLong));
    }
    AppMethodBeat.o(301834);
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(301706);
    s.u(paramContext, "context");
    s.u(paramString, "url");
    s.u(paramIntent, "intent");
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramIntent, 0, null, false, 896);
    AppMethodBeat.o(301706);
    return bool;
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, com.tencent.mm.plugin.brandservice.api.c.a parama)
  {
    AppMethodBeat.i(301708);
    s.u(paramContext, "context");
    s.u(paramString, "url");
    s.u(paramIntent, "intent");
    s.u(parama, "result");
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramIntent, paramInt4, parama, false, 512);
    AppMethodBeat.o(301708);
    return bool;
  }
  
  public final void aiA(String paramString)
  {
    AppMethodBeat.i(6483);
    s.u(paramString, "chatName");
    ((Map)this.vAu).put(paramString, Long.valueOf(MMSlotKt.now()));
    AppMethodBeat.o(6483);
  }
  
  public final long aiB(String paramString)
  {
    AppMethodBeat.i(6484);
    s.u(paramString, "chatName");
    paramString = (Long)this.vAu.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(6484);
      return -1L;
    }
    long l = paramString.longValue();
    AppMethodBeat.o(6484);
    return l;
  }
  
  public final String aiC(String paramString)
  {
    AppMethodBeat.i(175443);
    s.u(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajr(paramString);
    AppMethodBeat.o(175443);
    return paramString;
  }
  
  public final String aiD(String paramString)
  {
    AppMethodBeat.i(301733);
    com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
    paramString = com.tencent.mm.pluginsdk.model.c.bpi(paramString);
    AppMethodBeat.o(301733);
    return paramString;
  }
  
  public final int aiE(String paramString)
  {
    AppMethodBeat.i(301738);
    com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
    int i = com.tencent.mm.pluginsdk.model.c.bpj(paramString);
    AppMethodBeat.o(301738);
    return i;
  }
  
  public final boolean aiF(String paramString)
  {
    AppMethodBeat.i(301754);
    com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
    boolean bool = com.tencent.mm.pluginsdk.model.c.bpf(paramString);
    AppMethodBeat.o(301754);
    return bool;
  }
  
  public final void aiG(String paramString)
  {
    AppMethodBeat.i(175448);
    Log.d(this.TAG, "alvinluo saveChannelFeeds %s", new Object[] { paramString });
    atj().putString("video_channel_feeds_data", paramString);
    AppMethodBeat.o(175448);
  }
  
  public final void aiH(String paramString)
  {
    AppMethodBeat.i(301848);
    s.u(paramString, "canvasId");
    r localr = r.acDM;
    if (r.iXl()) {
      BizTLRecCardJsEngine.vKS.ddS().bhP(paramString);
    }
    AppMethodBeat.o(301848);
  }
  
  public final void aiI(String paramString)
  {
    AppMethodBeat.i(301862);
    p.a locala = com.tencent.mm.model.p.ojc;
    com.tencent.mm.model.p.HY(paramString);
    AppMethodBeat.o(301862);
  }
  
  public final boolean aiy(String paramString)
  {
    AppMethodBeat.i(301624);
    if (paramString == null)
    {
      AppMethodBeat.o(301624);
      return false;
    }
    boolean bool = UrlExKt.isMpArticleUrl(paramString);
    AppMethodBeat.o(301624);
    return bool;
  }
  
  public final com.tencent.mm.message.p aiz(String paramString)
  {
    AppMethodBeat.i(6473);
    h.a locala = h.a.vCf;
    paramString = h.a.aiS(paramString);
    AppMethodBeat.o(6473);
    return paramString;
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(301771);
    s.u(paramContext, "context");
    com.tencent.mm.pluginsdk.model.c.a(com.tencent.mm.pluginsdk.model.c.XPt, paramContext, paramString1, paramString2, paramInt, paramString3);
    AppMethodBeat.o(301771);
  }
  
  public final void c(jz paramjz)
  {
    AppMethodBeat.i(301691);
    e locale = e.Xml;
    e.d(paramjz);
    AppMethodBeat.o(301691);
  }
  
  public final void dA(String paramString, int paramInt)
  {
    AppMethodBeat.i(175441);
    if (paramString == null)
    {
      AppMethodBeat.o(175441);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new c..ExternalSyntheticLambda1(paramString, paramInt, 0, 2), "getAppMsgRelatedInfo");
    AppMethodBeat.o(175441);
  }
  
  public final void dB(String paramString, int paramInt)
  {
    AppMethodBeat.i(6475);
    s.u(paramString, "url");
    com.tencent.mm.plugin.brandservice.model.b.vBC.dB(paramString, paramInt);
    AppMethodBeat.o(6475);
  }
  
  public final int dav()
  {
    AppMethodBeat.i(301630);
    com.tencent.mm.plugin.brandservice.api.b localb = (com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class);
    if (localb == null)
    {
      AppMethodBeat.o(301630);
      return -1;
    }
    int i = localb.dav();
    AppMethodBeat.o(301630);
    return i;
  }
  
  public final void dbA()
  {
    AppMethodBeat.i(6481);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.dhs();
    AppMethodBeat.o(6481);
  }
  
  public final int dbB()
  {
    AppMethodBeat.i(301727);
    int i = ad.getSessionId();
    AppMethodBeat.o(301727);
    return i;
  }
  
  public final boolean dbC()
  {
    AppMethodBeat.i(301744);
    com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
    boolean bool = com.tencent.mm.pluginsdk.model.c.iHa();
    AppMethodBeat.o(301744);
    return bool;
  }
  
  public final boolean dbD()
  {
    AppMethodBeat.i(301749);
    com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
    boolean bool = com.tencent.mm.pluginsdk.model.c.iHb();
    AppMethodBeat.o(301749);
    return bool;
  }
  
  public final void dbE()
  {
    AppMethodBeat.i(301778);
    com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
    com.tencent.mm.pluginsdk.model.c.onResume();
    AppMethodBeat.o(301778);
  }
  
  public final String dbF()
  {
    AppMethodBeat.i(175447);
    String str = atj().getString("video_channel_feeds_data", "");
    if (str == null)
    {
      AppMethodBeat.o(175447);
      return "";
    }
    AppMethodBeat.o(175447);
    return str;
  }
  
  public final int dbG()
  {
    AppMethodBeat.i(301822);
    try
    {
      i = com.tencent.mm.plugin.webview.l.a.h(BizTLRecCardJsEngine.vKS.ddS().ioy());
      AppMethodBeat.o(301822);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w(this.TAG, s.X("getTimelineCanvasPkgVersion ex ", localException.getMessage()));
        int i = 0;
      }
    }
  }
  
  public final void dbH()
  {
    AppMethodBeat.i(301841);
    r localr = r.acDM;
    if (r.iXx()) {
      aC((kotlin.g.a.a)new f(this));
    }
    AppMethodBeat.o(301841);
  }
  
  public final void dbI()
  {
    AppMethodBeat.i(301855);
    Object localObject = r.acDM;
    if (r.iXx())
    {
      localObject = d.vBI;
      if (d.dcd()) {
        aC((kotlin.g.a.a)h.vAE);
      }
    }
    AppMethodBeat.o(301855);
  }
  
  public final boolean dbw()
  {
    AppMethodBeat.i(6458);
    AppMethodBeat.o(6458);
    return true;
  }
  
  public final boolean dbx()
  {
    AppMethodBeat.i(6474);
    com.tencent.mm.plugin.brandservice.model.b localb = com.tencent.mm.plugin.brandservice.model.b.vBC;
    boolean bool = com.tencent.mm.plugin.brandservice.model.b.dbx();
    AppMethodBeat.o(6474);
    return bool;
  }
  
  public final void dby()
  {
    AppMethodBeat.i(301703);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.m localm = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.vSK;
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.dfz();
    AppMethodBeat.o(301703);
  }
  
  public final String dbz()
  {
    AppMethodBeat.i(6480);
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.dgP();
    AppMethodBeat.o(6480);
    return str;
  }
  
  public final String e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6457);
    paramString = com.tencent.mm.message.m.e(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(6457);
    return paramString;
  }
  
  public final void eh(List<? extends q> paramList)
  {
    AppMethodBeat.i(301684);
    s.u(paramList, "items");
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(301684);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new c..ExternalSyntheticLambda6(paramList, 90), "getAppMsgRelatedInfo");
    AppMethodBeat.o(301684);
  }
  
  public final boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(6453);
    if (paramString == null)
    {
      AppMethodBeat.o(6453);
      return false;
    }
    boolean bool = UrlExKt.isMpUrl(paramString);
    AppMethodBeat.o(6453);
    return bool;
  }
  
  public final void m(String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(301828);
    s.u(paramString3, "event");
    aB((kotlin.g.a.a)new b(paramString1, paramString2, paramString3, paramString4));
    AppMethodBeat.o(301828);
  }
  
  public final void s(List<? extends List<String>> paramList, int paramInt)
  {
    AppMethodBeat.i(6469);
    s.u(paramList, "items");
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
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajj((String)((List)localObject2).get(0));
      if (vAw.contains((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label117;
        }
        paramList.add(localObject2);
        break;
        vAw.add((String)localObject3);
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
        localObject3 = (Iterable)paramList;
        localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((Collection)localObject2).add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajj((String)((List)((Iterator)localObject3).next()).get(0)));
            continue;
            i = 0;
            break;
          }
        }
        Log.v((String)localObject1, s.X("preloadData: preloadByIdAndUrls:", (List)localObject2));
      }
      com.tencent.threadpool.h.ahAA.g(new c..ExternalSyntheticLambda5(paramList, paramInt), "tmplPreload");
    }
    AppMethodBeat.o(6469);
  }
  
  public final void t(List<String[]> paramList, int paramInt)
  {
    AppMethodBeat.i(6470);
    s.u(paramList, "items");
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
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajj(((String[])localObject2)[0]);
      if (vAw.contains((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label110;
        }
        paramList.add(localObject2);
        break;
        vAw.add((String)localObject3);
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
        localObject3 = (Iterable)paramList;
        localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((Collection)localObject2).add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajj(((String[])localObject3.next())[0]));
            continue;
            i = 0;
            break;
          }
        }
        Log.v((String)localObject1, s.X("preloadData: preloadByInfoIdAndBuffer:", (List)localObject2));
      }
      com.tencent.threadpool.h.ahAA.g(new c..ExternalSyntheticLambda4(paramList, paramInt), "tmplPreload");
    }
    AppMethodBeat.o(6470);
  }
  
  public final void u(List<? extends q> paramList, int paramInt)
  {
    AppMethodBeat.i(6471);
    s.u(paramList, "items");
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(6471);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new c..ExternalSyntheticLambda3(paramList, paramInt), "getAppMsgRelatedInfo");
    AppMethodBeat.o(6471);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl$Companion;", "", "()V", "KEY_BIZ_CANVAS_PRELOAD_CANVAS_LAST_TIME", "", "KEY_BIZ_CANVAS_PRELOAD_CRASH_TIMES", "preauthLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthLimiter", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "prednsLimiter", "getPrednsLimiter", "preloadLimiter", "getPreloadLimiter", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<MMHandler>
  {
    public static final d vAB;
    
    static
    {
      AppMethodBeat.i(301508);
      vAB = new d();
      AppMethodBeat.o(301508);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(c paramc, String paramString1, String paramString2, String paramString3, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final h vAE;
    
    static
    {
      AppMethodBeat.i(301528);
      vAE = new h();
      AppMethodBeat.o(301528);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c
 * JD-Core Version:    0.7.0.1
 */