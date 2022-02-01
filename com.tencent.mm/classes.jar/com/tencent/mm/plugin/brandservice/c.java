package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.biz.PluginBiz;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.plugin.brandservice.b.g.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.jo;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "()V", "TAG", "", "bizNativeVideoOpen", "", "getBizNativeVideoOpen", "()Ljava/lang/Boolean;", "setBizNativeVideoOpen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "chatSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "minPreloadTime", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "addReportParamForBizUrl", "url", "scene", "", "subScene", "clickTime", "addToPreload", "", "itemShowType", "openScene", "vals", "", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "appMsgPaySuccess", "canPreloadIn", "dispatchEvent", "appId", "event", "data", "doPreloadTimelineRecCard", "path", "canvasId", "doSendMpShareVideoMsg", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "favMpVideo", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "getAppMsgRelatedInfo", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "reqType", "getAppMsgRelatedInfoForAppMsg", "items", "", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getBizTimeLineSessionId", "getChannelFeeds", "getChatSession", "chatName", "getHardCodeUrl", "getUrlKey", "isBizNativePageOpen", "isBizNativeVideoOpen", "isBizTimeLineOpen", "isMpArticle", "isMpUrl", "isPayReadingOpen", "isShowBigPic", "baseInfo", "baseTopItem", "count", "isSupportStyle", "style", "openWebViewUseFastLoad", "context", "Landroid/content/Context;", "Lorg/json/JSONObject;", "ret", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "preCreateWebView", "preloadByIdAndUrls", "preloadByInfoIdAndBuffer", "preloadTimelineCanvas", "preloadTimelineRecCard", "preloadTimelineVideoChannel", "safeExecute", "block", "Lkotlin/Function0;", "safePreload", "saveChannelFeeds", "channelFeeds", "setChatSession", "shareMpVideoToSns", "activity", "Lcom/tencent/mm/ui/MMActivity;", "currentEnterId", "startPreloadWebView", "isNative", "intent", "Landroid/content/Intent;", "openType", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "tryPreloadTmplWebview", "updateChannelFeeds", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "Companion", "plugin-brandservice_release"})
public final class c
  implements com.tencent.mm.plugin.brandservice.a.b
{
  private static final MMCacheSlotManager pmj;
  private static final MMCacheSlotManager pmk;
  private static final MMCacheSlotManager pml;
  public static final c.a pmm;
  private final String TAG;
  private final kotlin.f iBW;
  private final kotlin.f lhN;
  private Boolean pmg;
  private final ConcurrentHashMap<String, Long> pmh;
  private final long pmi;
  
  static
  {
    AppMethodBeat.i(6487);
    pmm = new c.a((byte)0);
    pmj = new MMCacheSlotManager();
    pmk = new MMCacheSlotManager();
    pml = new MMCacheSlotManager();
    AppMethodBeat.o(6487);
  }
  
  public c()
  {
    AppMethodBeat.i(6486);
    this.TAG = "MicroMsg.BrandServiceImpl";
    this.iBW = kotlin.g.ah((kotlin.g.a.a)new i(this));
    this.pmh = new ConcurrentHashMap();
    this.pmi = 15000L;
    this.lhN = kotlin.g.ah((kotlin.g.a.a)c.h.pmt);
    AppMethodBeat.o(6486);
  }
  
  private final void D(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(195104);
    long l = System.currentTimeMillis() - PluginBiz.startTime;
    if ((l < this.pmi) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG))
    {
      com.tencent.f.h.RTc.o((Runnable)new c.o(parama), Math.max(this.pmi - l, 5000L));
      AppMethodBeat.o(195104);
      return;
    }
    parama.invoke();
    AppMethodBeat.o(195104);
  }
  
  private final void E(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(195108);
    bkj().post((Runnable)new p(this, parama));
    AppMethodBeat.o(195108);
  }
  
  private final MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(195093);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.iBW.getValue();
    AppMethodBeat.o(195093);
    return localMultiProcessMMKV;
  }
  
  private MMHandler bkj()
  {
    AppMethodBeat.i(195107);
    MMHandler localMMHandler = (MMHandler)this.lhN.getValue();
    AppMethodBeat.o(195107);
    return localMMHandler;
  }
  
  public final boolean CQ(int paramInt)
  {
    AppMethodBeat.i(6459);
    if ((paramInt == 5) && (cld()))
    {
      AppMethodBeat.o(6459);
      return true;
    }
    AppMethodBeat.o(6459);
    return false;
  }
  
  public final boolean CR(int paramInt)
  {
    AppMethodBeat.i(6476);
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.CR(paramInt);
    AppMethodBeat.o(6476);
    return bool;
  }
  
  public final void CS(int paramInt)
  {
    AppMethodBeat.i(6479);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.run(paramInt);
    AppMethodBeat.o(6479);
  }
  
  public final boolean CT(int paramInt)
  {
    AppMethodBeat.i(195101);
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.item.l.CT(paramInt);
    AppMethodBeat.o(195101);
    return bool;
  }
  
  public final boolean L(Object paramObject1, Object paramObject2)
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
  
  public final void P(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(195102);
    kotlin.g.b.p.h(paramString2, "event");
    D((kotlin.g.a.a)new c(paramString1, paramString2, paramString3));
    AppMethodBeat.o(195102);
  }
  
  public final void Q(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(195103);
    kotlin.g.b.p.h(paramString1, "path");
    kotlin.g.b.p.h(paramString2, "canvasId");
    kotlin.g.b.p.h(paramString3, "data");
    r localr = r.NPl;
    if (r.gzQ()) {
      D((kotlin.g.a.a)new m(this, paramString1, paramString2, paramString3));
    }
    AppMethodBeat.o(195103);
  }
  
  public final void a(Context paramContext, JSONObject paramJSONObject, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(175450);
    kotlin.g.b.p.h(paramHashMap, "ret");
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(175450);
      return;
    }
    int i = paramJSONObject.optInt("item_show_type");
    Object localObject1 = com.tencent.mm.plugin.webview.h.g.c(i, paramJSONObject);
    if (!Util.isNullOrNil((String)localObject1))
    {
      ((Map)paramHashMap).put("success", Boolean.FALSE);
      ((Map)paramHashMap).put("desc", localObject1);
      AppMethodBeat.o(175450);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((i == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CQ(i)))
    {
      com.tencent.mm.plugin.webview.h.g.a(localBundle, i, paramJSONObject);
      localObject1 = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
      if ((com.tencent.mm.plugin.webview.ui.tools.video.a.gic()) && (paramJSONObject != null))
      {
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "saveVideo openwebviewusefastload");
        localObject1 = paramJSONObject.optString("vid");
        if (!Util.isNullOrNil((String)localObject1)) {
          break label469;
        }
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "saveVideo openwebviewusefastload vid null");
      }
    }
    for (;;)
    {
      Object localObject2 = new com.tencent.mm.plugin.brandservice.a.b.a();
      Intent localIntent = new Intent();
      if ((localBundle.getBoolean("isNativePage")) && (paramContext != null))
      {
        localIntent.putExtras(localBundle);
        float f = com.tencent.mm.cc.a.gvp();
        com.tencent.mm.plugin.webview.h.g.a(paramContext, localBundle.getString("currentInfo"), f, localIntent, false);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1061L, 21L, 1L, false);
      }
      i = localBundle.getInt("scene");
      int j = localBundle.getInt("subscene", 10000);
      localObject1 = localBundle.getString("url");
      paramJSONObject = (JSONObject)localObject1;
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject1))
      {
        k = (int)(System.currentTimeMillis() / 1000L);
        paramJSONObject = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject1, i, j, k);
      }
      localObject1 = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
      int k = localBundle.getInt("item_show_type");
      localBundle.getBoolean("isNativePage");
      boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)localObject1).a(paramContext, paramJSONObject, k, i, j, localIntent, localBundle.getInt("openType"), (com.tencent.mm.plugin.brandservice.a.b.a)localObject2);
      ((Map)paramHashMap).put("success", Boolean.valueOf(bool));
      if ((!((com.tencent.mm.plugin.brandservice.a.b.a)localObject2).success) && (((com.tencent.mm.plugin.brandservice.a.b.a)localObject2).message != null))
      {
        paramContext = (Map)paramHashMap;
        paramJSONObject = ((com.tencent.mm.plugin.brandservice.a.b.a)localObject2).message;
        kotlin.g.b.p.g(paramJSONObject, "result.message");
        paramContext.put("desc", paramJSONObject);
      }
      AppMethodBeat.o(175450);
      return;
      label469:
      i = (int)Util.getFloat(paramJSONObject.optString("videoInitialTime"), 0.0F);
      paramJSONObject = paramJSONObject.optString("videoInitialSnapshot");
      if (Util.isNullOrNil(paramJSONObject))
      {
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "saveVideo openwebviewusefastload bitmap null");
      }
      else
      {
        localObject2 = (MultiProcessMMKV)com.tencent.mm.plugin.webview.ui.tools.video.a.JxM.getSlot();
        ((MultiProcessMMKV)localObject2).encode("MicroMsg.MPVideoPreviewDataMgr_" + (String)localObject1 + "_playTime", i);
        ((MultiProcessMMKV)localObject2).encode("MicroMsg.MPVideoPreviewDataMgr_" + (String)localObject1 + "_expire", System.currentTimeMillis() / 1000L + 600L);
        ((MultiProcessMMKV)localObject2).encode("MicroMsg.MPVideoPreviewDataMgr_" + (String)localObject1 + "_bitmap", paramJSONObject);
        com.tencent.mm.plugin.webview.ui.tools.video.a.bbi((String)localObject1);
        continue;
        localBundle.putString("url", paramJSONObject.optString("url"));
        localBundle.putInt("item_show_type", paramJSONObject.optInt("item_show_type"));
        localBundle.putInt("scene", paramJSONObject.optInt("scene"));
        localBundle.putInt("subscene", paramJSONObject.optInt("subscene"));
        localBundle.putInt("openType", paramJSONObject.optInt("openType"));
        localBundle.putString("biz_video_channel_session_id", paramJSONObject.optString("channelSessionId"));
      }
    }
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(175449);
    com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.pne;
    com.tencent.mm.plugin.brandservice.b.c.b(paramb);
    AppMethodBeat.o(175449);
  }
  
  public final void a(jo paramjo, MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(195097);
    com.tencent.mm.plugin.webview.ui.tools.media.c localc = com.tencent.mm.plugin.webview.ui.tools.media.c.Jwu;
    com.tencent.mm.plugin.webview.ui.tools.media.c.b(paramjo, paramMMActivity, paramInt);
    AppMethodBeat.o(195097);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(6461);
    kotlin.g.b.p.h(paramString, "url");
    kotlin.g.b.p.h(paramVarArgs, "vals");
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW(paramString);
    if (pmj.contains(str))
    {
      AppMethodBeat.o(6461);
      return;
    }
    pmj.add(str);
    Log.v(this.TAG, "preloadData: addToPreload:".concat(String.valueOf(str)));
    com.tencent.f.h.RTc.b((Runnable)new c.b(paramString, paramInt1, paramInt2, paramVarArgs), "tmplPreload");
    AppMethodBeat.o(6461);
  }
  
  public final void a(String paramString1, y paramy, String paramString2, com.tencent.mm.ipcinvoker.d<Bundle> paramd)
  {
    AppMethodBeat.i(6482);
    kotlin.g.b.p.h(paramString1, "toUser");
    kotlin.g.b.p.h(paramy, "msgInfo");
    kotlin.g.b.p.h(paramd, "callback");
    com.tencent.mm.plugin.webview.ui.tools.media.d locald = com.tencent.mm.plugin.webview.ui.tools.media.d.Jwx;
    com.tencent.mm.plugin.webview.ui.tools.media.d.b(paramString1, paramy, paramString2, paramd);
    AppMethodBeat.o(6482);
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(195098);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramString, "url");
    kotlin.g.b.p.h(paramIntent, "intent");
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramIntent, 0, null, false, 896);
    AppMethodBeat.o(195098);
    return bool;
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, com.tencent.mm.plugin.brandservice.a.b.a parama)
  {
    AppMethodBeat.i(195099);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramString, "url");
    kotlin.g.b.p.h(paramIntent, "intent");
    kotlin.g.b.p.h(parama, "result");
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramIntent, paramInt4, parama, false, 512);
    AppMethodBeat.o(195099);
    return bool;
  }
  
  public final void ahA(String paramString)
  {
    AppMethodBeat.i(175448);
    Log.d(this.TAG, "alvinluo saveChannelFeeds %s", new Object[] { paramString });
    aTI().putString("video_channel_feeds_data", paramString);
    AppMethodBeat.o(175448);
  }
  
  public final boolean ahv(String paramString)
  {
    AppMethodBeat.i(195094);
    if (paramString != null)
    {
      boolean bool = UrlExKt.isMpArticleUrl(paramString);
      AppMethodBeat.o(195094);
      return bool;
    }
    AppMethodBeat.o(195094);
    return false;
  }
  
  public final com.tencent.mm.ag.p ahw(String paramString)
  {
    AppMethodBeat.i(6473);
    g.a locala = g.a.pnx;
    paramString = g.a.ahL(paramString);
    AppMethodBeat.o(6473);
    return paramString;
  }
  
  public final void ahx(String paramString)
  {
    AppMethodBeat.i(6483);
    kotlin.g.b.p.h(paramString, "chatName");
    ((Map)this.pmh).put(paramString, Long.valueOf(MMSlotKt.now()));
    AppMethodBeat.o(6483);
  }
  
  public final long ahy(String paramString)
  {
    AppMethodBeat.i(6484);
    kotlin.g.b.p.h(paramString, "chatName");
    paramString = (Long)this.pmh.get(paramString);
    if (paramString != null)
    {
      long l = paramString.longValue();
      AppMethodBeat.o(6484);
      return l;
    }
    AppMethodBeat.o(6484);
    return -1L;
  }
  
  public final String ahz(String paramString)
  {
    AppMethodBeat.i(175443);
    kotlin.g.b.p.h(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aie(paramString);
    AppMethodBeat.o(175443);
    return paramString;
  }
  
  public final void c(jo paramjo)
  {
    AppMethodBeat.i(195096);
    com.tencent.mm.plugin.webview.ui.tools.media.f localf = com.tencent.mm.plugin.webview.ui.tools.media.f.JwB;
    com.tencent.mm.plugin.webview.ui.tools.media.f.d(paramjo);
    AppMethodBeat.o(195096);
  }
  
  public final void cD(String paramString, int paramInt)
  {
    AppMethodBeat.i(175441);
    if (paramString == null)
    {
      AppMethodBeat.o(175441);
      return;
    }
    com.tencent.f.h.RTc.b((Runnable)new c.e(paramString, paramInt), "getAppMsgRelatedInfo");
    AppMethodBeat.o(175441);
  }
  
  public final void cE(String paramString, int paramInt)
  {
    AppMethodBeat.i(6475);
    kotlin.g.b.p.h(paramString, "url");
    com.tencent.mm.plugin.brandservice.b.a.pmT.cE(paramString, paramInt);
    AppMethodBeat.o(6475);
  }
  
  public final boolean clc()
  {
    AppMethodBeat.i(6458);
    boolean bool = ab.clc();
    AppMethodBeat.o(6458);
    return bool;
  }
  
  public final boolean cld()
  {
    AppMethodBeat.i(6460);
    if (this.pmg == null) {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rTT, 1) != 1) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      this.pmg = Boolean.valueOf(bool);
      Log.i(this.TAG, "bizNativeVideoOpen: " + this.pmg);
      Boolean localBoolean = this.pmg;
      if (localBoolean == null) {
        kotlin.g.b.p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(6460);
      return bool;
    }
  }
  
  public final boolean cle()
  {
    AppMethodBeat.i(6474);
    com.tencent.mm.plugin.brandservice.b.a locala = com.tencent.mm.plugin.brandservice.b.a.pmT;
    boolean bool = com.tencent.mm.plugin.brandservice.b.a.cle();
    AppMethodBeat.o(6474);
    return bool;
  }
  
  public final String clf()
  {
    AppMethodBeat.i(6480);
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.coT();
    AppMethodBeat.o(6480);
    return str;
  }
  
  public final void clg()
  {
    AppMethodBeat.i(6481);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.cpJ();
    AppMethodBeat.o(6481);
  }
  
  public final int clh()
  {
    AppMethodBeat.i(195100);
    int i = ab.getSessionId();
    AppMethodBeat.o(195100);
    return i;
  }
  
  public final String cli()
  {
    AppMethodBeat.i(175447);
    String str2 = aTI().getString("video_channel_feeds_data", "");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(175447);
    return str1;
  }
  
  public final void clj()
  {
    AppMethodBeat.i(195105);
    r localr = r.NPl;
    if (r.gzQ()) {
      E((kotlin.g.a.a)new l(this));
    }
    AppMethodBeat.o(195105);
  }
  
  public final void clk()
  {
    AppMethodBeat.i(195106);
    Object localObject = r.NPl;
    if (r.gzQ())
    {
      localObject = com.tencent.mm.plugin.brandservice.b.c.pne;
      if (com.tencent.mm.plugin.brandservice.b.c.clF()) {
        E((kotlin.g.a.a)n.pmw);
      }
    }
    AppMethodBeat.o(195106);
  }
  
  public final void ct(List<? extends com.tencent.mm.ag.q> paramList)
  {
    AppMethodBeat.i(195095);
    kotlin.g.b.p.h(paramList, "items");
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(195095);
      return;
    }
    com.tencent.f.h.RTc.b((Runnable)new c.f(paramList), "getAppMsgRelatedInfo");
    AppMethodBeat.o(195095);
  }
  
  public final String d(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6457);
    paramString = com.tencent.mm.ag.m.d(paramString, paramInt1, paramInt2, paramInt3);
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
    kotlin.g.b.p.h(paramList, "items");
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
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW((String)((List)localObject2).get(0));
      if (pmj.contains((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label117;
        }
        paramList.add(localObject2);
        break;
        pmj.add((String)localObject3);
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
            ((Collection)localObject3).add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW((String)((List)((Iterator)localObject4).next()).get(0)));
            continue;
            i = 0;
            break;
          }
        }
        Log.v((String)localObject1, (List)localObject3);
      }
      com.tencent.f.h.RTc.b((Runnable)new j(paramList, this, paramInt), "tmplPreload");
    }
    AppMethodBeat.o(6469);
  }
  
  public final void k(List<String[]> paramList, final int paramInt)
  {
    AppMethodBeat.i(6470);
    kotlin.g.b.p.h(paramList, "items");
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
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW(((String[])localObject2)[0]);
      if (pmj.contains((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label110;
        }
        paramList.add(localObject2);
        break;
        pmj.add((String)localObject3);
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
            ((Collection)localObject3).add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW(((String[])localObject4.next())[0]));
            continue;
            i = 0;
            break;
          }
        }
        Log.v((String)localObject1, (List)localObject3);
      }
      com.tencent.f.h.RTc.b((Runnable)new k(paramList, this, paramInt), "tmplPreload");
    }
    AppMethodBeat.o(6470);
  }
  
  public final void l(List<? extends com.tencent.mm.ag.q> paramList, int paramInt)
  {
    AppMethodBeat.i(6471);
    kotlin.g.b.p.h(paramList, "items");
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(6471);
      return;
    }
    com.tencent.f.h.RTc.b((Runnable)new c.g(paramList, paramInt), "getAppMsgRelatedInfo");
    AppMethodBeat.o(6471);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/brandservice/BrandServiceImpl$preloadByIdAndUrls$2$2"})
  static final class j
    implements Runnable
  {
    j(List paramList, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(6451);
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.j(this.oaN, paramInt);
      AppMethodBeat.o(6451);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/brandservice/BrandServiceImpl$preloadByInfoIdAndBuffer$2$2"})
  static final class k
    implements Runnable
  {
    k(List paramList, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(6452);
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.k(this.oaN, paramInt);
      AppMethodBeat.o(6452);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    l(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(c paramc, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final n pmw;
    
    static
    {
      AppMethodBeat.i(195090);
      pmw = new n();
      AppMethodBeat.o(195090);
    }
    
    n()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(c paramc, kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(195092);
      com.tencent.mm.plugin.biz.b.c localc = com.tencent.mm.plugin.biz.b.c.pfv;
      int i = com.tencent.mm.plugin.biz.b.c.cks().decodeInt("biz_canvas_card_preload_crash_times", 0);
      localc = com.tencent.mm.plugin.biz.b.c.pfv;
      if (!com.tencent.mm.plugin.biz.b.c.a(i, 0L, "biz_canvas_card_preload_last_time", 10L))
      {
        AppMethodBeat.o(195092);
        return;
      }
      localc = com.tencent.mm.plugin.biz.b.c.pfv;
      com.tencent.mm.plugin.biz.b.c.cks().encode("biz_canvas_card_preload_crash_times", i + 1);
      Log.i(c.a(this.pmu), "safePreload set crash flag");
      parama.invoke();
      localc = com.tencent.mm.plugin.biz.b.c.pfv;
      com.tencent.mm.plugin.biz.b.c.cks().encode("biz_canvas_card_preload_crash_times", 0);
      Log.i(c.a(this.pmu), "safePreload reset crash flag");
      AppMethodBeat.o(195092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c
 * JD-Core Version:    0.7.0.1
 */