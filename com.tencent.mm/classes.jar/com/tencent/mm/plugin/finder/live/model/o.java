package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f.a;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.e.c;
import com.tencent.mm.live.core.core.e.e;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.mini.a.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveMiniProProxyUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveMiniProProxyUI.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI13;
import com.tencent.mm.plugin.finder.live.model.cgi.d.a;
import com.tencent.mm.plugin.finder.live.model.cgi.h.a;
import com.tencent.mm.plugin.finder.live.model.cgi.u.a;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.aa;
import com.tencent.mm.plugin.finder.report.live.s.at;
import com.tencent.mm.plugin.finder.report.live.s.au;
import com.tencent.mm.plugin.finder.report.live.s.c;
import com.tencent.mm.plugin.finder.report.live.s.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "()V", "COMMENT_LIST_SIZE_LIMIT", "", "getCOMMENT_LIST_SIZE_LIMIT", "()I", "setCOMMENT_LIST_SIZE_LIMIT", "(I)V", "TAG", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "getBeautyConfig", "()Lcom/tencent/mm/live/core/render/BeautyConfig;", "setBeautyConfig", "(Lcom/tencent/mm/live/core/render/BeautyConfig;)V", "checkDeviceLsn", "com/tencent/mm/plugin/finder/live/model/FinderLiveService$checkDeviceLsn$1", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$checkDeviceLsn$1;", "comboBatchSize", "getComboBatchSize", "setComboBatchSize", "comboBatchTimeoutMs", "getComboBatchTimeoutMs", "setComboBatchTimeoutMs", "curLiveIndex", "getCurLiveIndex", "setCurLiveIndex", "curLiveLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "value", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "curLiveRoomData", "getCurLiveRoomData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setCurLiveRoomData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "defaultBeautyConfig", "getDefaultBeautyConfig", "setDefaultBeautyConfig", "defaultFilterValue", "getDefaultFilterValue", "setDefaultFilterValue", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "getFilterConfig", "()Lcom/tencent/mm/live/core/render/FilterConfig;", "setFilterConfig", "(Lcom/tencent/mm/live/core/render/FilterConfig;)V", "filterMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/live/core/util/LiveFilterUtil$FilterInfo;", "getFilterMap", "()Ljava/util/HashMap;", "setFilterMap", "(Ljava/util/HashMap;)V", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "setFinderLiveAssistant", "(Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;)V", "getMessageTask", "Ljava/lang/Runnable;", "giftLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getGiftLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setGiftLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "heartBeatLooper", "Lcom/tencent/mm/plugin/finder/live/model/SingleTaskLooper;", "heartBeatTimestamp", "", "isAnchor", "", "keepAliveTask", "keepLiveLooper", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "liveData", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;)V", "miniView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;", "miniWindowClickListener", "Landroid/view/View$OnClickListener;", "getMiniWindowClickListener", "()Landroid/view/View$OnClickListener;", "setMiniWindowClickListener", "(Landroid/view/View$OnClickListener;)V", "miniWindowCloseClickListener", "multiTalkActionListener", "Lcom/tencent/mm/sdk/event/IListener;", "multiTaskManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "getMultiTaskManager", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "setMultiTaskManager", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;)V", "notSupportDynamicVideoParamDevice", "refreshMicLooper", "refreshMicTask", "voipCallEvent", "Lcom/tencent/mm/autogen/events/VoipEvent;", "anchorAliveExpiredByLiveExtFlag", "bindCurLive", "", "finderBaseLayout", "curIndex", "callback", "errorCode", "param", "Landroid/os/Bundle;", "chcekBadgeDebugInfo", "liveRoomData", "checkAcceptMicType", "acceptInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgAcceptMicInfo;", "checkAnchorAlive", "curLiveData", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "checkCookiesDeprecated", "errType", "errCode", "checkGiftEnable", "checkLinkMicEnable", "checkLinkState", "remoteLiveAppMsg", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "checkLiveClose", "checkLiveExtFlag", "checkQosReport", "closeMiniProgram", "context", "Landroid/content/Context;", "purpose", "doGetLiveMsg", "doKeepLive", "doRefreshMic", "enableDynamicVideoParam", "enableGiftByLiveExtFlag", "enableLinkMicByLiveExtFlag", "filterLiveMsg", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "Lkotlin/collections/ArrayList;", "remote", "typeList", "", "forceStopCurLive", "handleAppMsg", "appMsgList", "handleKeepAliveResp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "handleLiveMsgResp", "handleMsg", "remoteLiveMsg", "selfID", "selfFinderId", "handleRefreshMicResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "handleTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTemplateInfo;", "heartBeat", "delay", "liveId", "isAnchorLiving", "isInvalidLiveId", "(Ljava/lang/Long;)Z", "isVisitorLiving", "keepAlive", "launchMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "liveFinish", "liveStart", "mirrorMode", "needMirror", "processLiveAudioSdkParam", "audioSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkAudioParams;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveVideoSdkParam", "videoSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkVideoParams;", "refreshMic", "release", "isTopApplication", "miniWinPermission", "closeLive", "(ZZLjava/lang/Boolean;)V", "releaseWithMiniWindow", "reportAnchor", "it", "setupBeautyAndFilterConfig", "setupSingleTaskLooper", "stopRefreshMic", "transferLiveData", "livecData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "transferState", "event", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "updateBeautyConfig", "updateSdkParam", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "plugin-finder_release"})
public final class o
  implements com.tencent.mm.live.core.core.c
{
  private static boolean dMz;
  private static HashMap<Integer, com.tencent.mm.live.core.d.a.a> filterMap;
  private static com.tencent.mm.live.core.b.a hDV;
  private static com.tencent.mm.live.core.b.b hDW;
  private static final Runnable hId;
  private static final Runnable hIe;
  private static View.OnClickListener hJe;
  private static com.tencent.mm.live.core.core.trtc.a hSS;
  private static final com.tencent.mm.model.d hWh;
  private static final IListener<?> hXn;
  private static com.tencent.mm.plugin.finder.live.view.i ufF;
  private static int ujA;
  private static int ujB;
  private static long ujC;
  private static com.tencent.mm.bw.b ujD;
  private static int ujE;
  private static int ujF;
  private static final IListener<zj> ujG;
  private static final a ujH;
  private static final View.OnClickListener ujI;
  private static final Runnable ujJ;
  private static w ujK;
  private static w ujL;
  private static w ujM;
  public static final o ujN;
  private static FinderBaseLivePluginLayout ujs;
  private static FinderLiveMiniView ujt;
  private static String uju;
  private static com.tencent.mm.live.core.b.a ujv;
  private static int ujw;
  private static s ujx;
  private static com.tencent.mm.plugin.finder.live.viewmodel.d ujy;
  private static com.tencent.mm.plugin.finder.live.viewmodel.g ujz;
  
  static
  {
    AppMethodBeat.i(246254);
    ujN = new o();
    uju = "";
    hWh = com.tencent.mm.model.d.aTu();
    ujw = 40;
    filterMap = new HashMap();
    ujB = 1000;
    ujE = -1;
    ujF = -1;
    ujG = (IListener)new s();
    hXn = (IListener)new n();
    ujH = new a();
    hJe = (View.OnClickListener)l.ujS;
    ujI = (View.OnClickListener)m.ujT;
    hIe = (Runnable)g.ujP;
    hId = (Runnable)j.ujR;
    ujJ = (Runnable)o.ujU;
    ujH.alive();
    AppMethodBeat.o(246254);
  }
  
  public static void EI(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(246230);
    StringBuilder localStringBuilder = new StringBuilder("refreshMic delay:").append(paramLong).append(" curLive:");
    Object localObject1 = ujz;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo;
      if (localObject1 == null) {}
    }
    for (localObject1 = Long.valueOf(((awe)localObject1).liveId);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(" curLinkUser:");
      com.tencent.mm.plugin.finder.live.viewmodel.g localg = ujz;
      localObject1 = localObject2;
      if (localg != null) {
        localObject1 = localg.uEB;
      }
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = ujM;
      if (localObject1 == null) {
        break;
      }
      ((w)localObject1).f(Long.valueOf(paramLong));
      AppMethodBeat.o(246230);
      return;
    }
    AppMethodBeat.o(246230);
  }
  
  public static void EJ(long paramLong)
  {
    AppMethodBeat.i(246233);
    StringBuilder localStringBuilder = new StringBuilder("keepAlive delay:").append(paramLong).append(" curLive:");
    Object localObject = ujz;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo;
      if (localObject == null) {}
    }
    for (localObject = Long.valueOf(((awe)localObject).liveId);; localObject = null)
    {
      Log.i("Finder.FinderLiveService", localObject);
      localObject = ujL;
      if (localObject == null) {
        break;
      }
      ((w)localObject).f(Long.valueOf(paramLong));
      AppMethodBeat.o(246233);
      return;
    }
    AppMethodBeat.o(246233);
  }
  
  public static void EK(long paramLong)
  {
    AppMethodBeat.i(246238);
    hWh.aTv();
    P(0L, paramLong);
    j localj = j.ujh;
    j.dfL();
    AppMethodBeat.o(246238);
  }
  
  public static void Jg(int paramInt)
  {
    ujE = paramInt;
  }
  
  public static void Jh(int paramInt)
  {
    ujF = paramInt;
  }
  
  private static boolean Ji(int paramInt)
  {
    AppMethodBeat.i(246225);
    if ((paramInt != -1) && (com.tencent.mm.ac.d.cW(paramInt, 1)))
    {
      AppMethodBeat.o(246225);
      return true;
    }
    AppMethodBeat.o(246225);
    return false;
  }
  
  public static void P(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(246226);
    StringBuilder localStringBuilder = new StringBuilder("heartBeat liveId:").append(paramLong2).append(" delay:").append(paramLong1).append(" curLive:");
    Object localObject = ujz;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo;
      if (localObject == null) {}
    }
    for (localObject = Long.valueOf(((awe)localObject).liveId);; localObject = null)
    {
      Log.i("Finder.FinderLiveService", localObject + " liveId:" + paramLong2);
      if (paramLong2 <= 0L) {
        break label173;
      }
      localObject = ujz;
      if (localObject == null) {
        break;
      }
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo;
      if (localObject == null) {
        break;
      }
      if (((awe)localObject).liveId != paramLong2) {
        break label173;
      }
      localObject = ujK;
      if (localObject == null) {
        break label173;
      }
      ((w)localObject).f(Long.valueOf(paramLong1));
      AppMethodBeat.o(246226);
      return;
    }
    AppMethodBeat.o(246226);
    return;
    label173:
    AppMethodBeat.o(246226);
  }
  
  public static com.tencent.mm.plugin.finder.live.viewmodel.g a(com.tencent.mm.plugin.finder.live.viewmodel.c paramc)
  {
    AppMethodBeat.i(246235);
    com.tencent.mm.plugin.finder.live.viewmodel.g localg;
    int i;
    if (paramc != null)
    {
      localg = paramc.uCs;
      if ((localg != null) && (localg.liveInfo.liveId == 0L))
      {
        localg.liveInfo.liveId = paramc.uCr.getLiveId();
        localg.hFK = paramc.uCr.aBH();
        Object localObject = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        localObject = e.a.Fy(localg.hFK);
        if (localObject != null)
        {
          FinderObject localFinderObject = ((FinderItem)localObject).getFinderObject();
          localObject = localFinderObject;
          if (localFinderObject != null) {}
        }
        else
        {
          localObject = new FinderObject();
        }
        localg.uDz = ((FinderObject)localObject);
        localObject = paramc.uCr.aBG();
        p.g(localObject, "livecData.staticConfig.anchorUsername");
        localg.atT((String)localObject);
        localObject = paramc.uCr.aBI();
        p.g(localObject, "livecData.staticConfig.nonceId");
        localg.atS((String)localObject);
        localg.desc = paramc.uCr.getDesc();
        if (TextUtils.isEmpty((CharSequence)localg.uEu))
        {
          localObject = paramc.uCr.aBE();
          p.g(localObject, "livecData.staticConfig.thumbUrl");
          p.h(localObject, "<set-?>");
          localg.uEu = ((String)localObject);
        }
        if (!Util.isNullOrNil(paramc.uCr.aBJ())) {
          localg.uDO = new com.tencent.mm.plugin.finder.live.viewmodel.h(paramc.uCr.aBJ(), paramc.uCr.aBM(), paramc.uCr.aBN(), paramc.uCr.aBK(), paramc.uCr.aBL());
        }
        localObject = paramc.uCr.getSessionBuffer();
        paramc = (com.tencent.mm.plugin.finder.live.viewmodel.c)localObject;
        if (localObject == null) {
          paramc = "";
        }
        p.h(paramc, "<set-?>");
        localg.sessionBuffer = paramc;
        paramc = y.vXH;
        if (y.dCM())
        {
          paramc = com.tencent.mm.plugin.finder.storage.c.vCb;
          i = ((Number)com.tencent.mm.plugin.finder.storage.c.dwd().value()).intValue();
          paramc = new avi();
          switch (i)
          {
          default: 
            paramc.LFV = 1;
            paramc.LFX = i;
          }
        }
      }
    }
    for (;;)
    {
      localg.a(paramc);
      Log.i("Finder.FinderLiveService", "chcekBadgeDebugInfo badgeDebugValue:".concat(String.valueOf(i)));
      Log.i("Finder.FinderLiveService", "transferLiveData liveId:" + localg.liveInfo.liveId + " objectId:" + localg.hFK + " anchorUsername:" + localg.hwd);
      AppMethodBeat.o(246235);
      return localg;
      localg = null;
      break;
      paramc.LFV = 0;
    }
  }
  
  public static void a(b.c paramc, Bundle paramBundle, long paramLong)
  {
    boolean bool = false;
    Object localObject2 = null;
    JSONObject localJSONObject = null;
    AppMethodBeat.i(246227);
    p.h(paramc, "event");
    Object localObject3 = new StringBuilder("transferState before event:").append(paramc).append(" curLive:");
    Object localObject1 = ujz;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((awe)localObject1).liveId);
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" liveState:");
        localObject1 = ujz;
        if (localObject1 == null) {
          break label227;
        }
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEg);
        label111:
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" uiState:");
        localObject1 = ujz;
        if (localObject1 == null) {
          break label233;
        }
      }
    }
    label227:
    label233:
    for (localObject1 = Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEf);; localObject1 = null)
    {
      Log.i("Finder.FinderLiveService", localObject1);
      localObject3 = ujz;
      if (localObject3 == null) {
        break label1945;
      }
      if (paramLong == ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).liveInfo.liveId) {
        break label239;
      }
      Log.w("Finder.FinderLiveService", "invalid liveId:" + paramLong + ", ignore...");
      AppMethodBeat.o(246227);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label111;
    }
    label239:
    switch (p.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      Log.i("Finder.FinderLiveService", "transferState after  event:" + paramc + " liveState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg + " uiState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf);
      AppMethodBeat.o(246227);
      return;
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 1;
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf = 1024;
      continue;
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 1;
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFFBFF;
      continue;
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 0;
      if ((paramBundle == null) || (!paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", false)))
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf = 0;
        continue;
        if ((((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted()) && (!com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 96)))
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x10;
          continue;
          if ((((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted()) && (com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 16)))
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFFFEF;
            continue;
            if ((((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted()) && (!com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 96)))
            {
              ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x2;
              continue;
              if ((((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted()) && (com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 2)))
              {
                ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFFFFD;
                continue;
                if (!com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 32))
                {
                  if (!dMz) {
                    break label747;
                  }
                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 3;
                }
                for (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf = 1;; ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf = 1)
                {
                  paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
                  ujB = ((Number)com.tencent.mm.plugin.finder.storage.c.dwj().value()).intValue();
                  break;
                  label747:
                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 2;
                }
                if ((!dMz) && (!((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).djl()))
                {
                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 3;
                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf = 1;
                  continue;
                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 4;
                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf = 0;
                  continue;
                  paramBundle = hSS;
                  if (paramBundle != null) {
                    paramBundle.a(com.tencent.mm.live.core.mini.d.hCW);
                  }
                  if ((((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted()) && (!com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 96)))
                  {
                    ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x20;
                    ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFFDFF;
                    continue;
                    if (!((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).djl())
                    {
                      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 3;
                      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf = 1;
                      continue;
                      if ((((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted()) && (!com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 608)))
                      {
                        ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x200;
                        continue;
                        if ((((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted()) && (!com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 96)))
                        {
                          ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x40;
                          ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFFDFF;
                          continue;
                          if ((((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted()) && (com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 64)))
                          {
                            ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFFFBF;
                            ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 3;
                            continue;
                            if (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted())
                            {
                              localObject1 = localJSONObject;
                              if (paramBundle != null) {
                                localObject1 = Boolean.valueOf(paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT", false));
                              }
                              if (p.j(localObject1, Boolean.TRUE))
                              {
                                ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x8;
                              }
                              else
                              {
                                ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFFFF7;
                                continue;
                                if (((((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted()) || (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).djk())) && (!com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 96))) {
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x4;
                                }
                                paramBundle = ujt;
                                if (paramBundle != null) {
                                  bool = paramBundle.dMz;
                                }
                                if (bool)
                                {
                                  localJSONObject = new JSONObject();
                                  localJSONObject.put("type", s.aa.vpJ.action);
                                  paramBundle = k.vkd;
                                  localJSONObject.put("sessionid", k.dpl().vlJ);
                                  paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEl;
                                  if (paramBundle != null)
                                  {
                                    localObject1 = paramBundle.vtD;
                                    paramBundle = (Bundle)localObject1;
                                    if (localObject1 != null) {}
                                  }
                                  else
                                  {
                                    paramBundle = "";
                                  }
                                  localJSONObject.put("shopwindowid", paramBundle);
                                  if (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).djk())
                                  {
                                    paramBundle = k.vkd;
                                    k.q(com.tencent.mm.plugin.finder.report.live.s.a.vmz.hlf, localJSONObject.toString());
                                  }
                                  else if (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted())
                                  {
                                    paramBundle = k.vkd;
                                    if (k.dpl().vmn) {
                                      localJSONObject.put("type", s.aa.vpQ.action);
                                    }
                                    localObject1 = ujz;
                                    paramBundle = localObject2;
                                    if (localObject1 != null) {
                                      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEq;
                                    }
                                    localJSONObject.put("appid", paramBundle);
                                    paramBundle = ujz;
                                    if (paramBundle != null)
                                    {
                                      paramBundle = paramBundle.liveInfo;
                                      if (paramBundle != null)
                                      {
                                        paramLong = paramBundle.liveId;
                                        label1357:
                                        if (paramLong >= 0L) {
                                          break label1461;
                                        }
                                        localJSONObject.put("liveid", "");
                                        label1375:
                                        paramBundle = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                        localJSONObject.put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOM());
                                        paramBundle = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                        c.a.apD("");
                                        paramBundle = ujz;
                                        if (paramBundle == null) {
                                          break label1477;
                                        }
                                        paramBundle = paramBundle.uEm;
                                        if (paramBundle == null) {
                                          break label1477;
                                        }
                                      }
                                    }
                                    label1461:
                                    label1477:
                                    for (paramBundle = Long.valueOf(paramBundle.uko);; paramBundle = "")
                                    {
                                      localJSONObject.put("productid", paramBundle);
                                      paramBundle = k.vkd;
                                      k.a(s.c.vmV, localJSONObject.toString());
                                      break;
                                      paramLong = -1L;
                                      break label1357;
                                      localJSONObject.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(paramLong));
                                      break label1375;
                                    }
                                  }
                                }
                                else
                                {
                                  paramBundle = com.tencent.mm.plugin.finder.report.live.m.vli;
                                  com.tencent.mm.plugin.finder.report.live.m.a(s.au.vrS, null, null);
                                  continue;
                                  if (((((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).isLiveStarted()) || (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).djk())) && (com.tencent.mm.ac.d.cW(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf, 4))) {
                                    ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFFFFB;
                                  }
                                  paramBundle = ujt;
                                  if (paramBundle != null) {}
                                  for (bool = paramBundle.dMz; !bool; bool = false)
                                  {
                                    paramBundle = com.tencent.mm.plugin.finder.report.live.m.vli;
                                    com.tencent.mm.plugin.finder.report.live.m.a(s.au.vrZ, null, null);
                                    break;
                                  }
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 3;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x80;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 3;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x100;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEg = 3;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x1000;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x800;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFF7FF;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x2000;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEh = paramBundle;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFDFFF;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEh = paramBundle;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x4000;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEh = paramBundle;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFFBFFF;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEh = paramBundle;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x8000;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFF7FFF;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x10000;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFEFFFF;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x20000;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFDFFFF;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x40000;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFFBFFFF;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf |= 0x80000;
                                  continue;
                                  ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEf &= 0xFFF7FFFF;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1945:
    AppMethodBeat.o(246227);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.view.i parami)
  {
    ufF = parami;
  }
  
  private static void a(ciz paramciz)
  {
    AppMethodBeat.i(246223);
    if (paramciz != null)
    {
      if (paramciz.MnT > 0)
      {
        Object localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDE();
        p.g(localObject, "ConfigHelper.getInstance().audioConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).setAudioQuality(paramciz.MnT);
      }
      Log.i("Finder.FinderLiveService", "processLiveAudioSdkParam audioQuality:" + paramciz.MnT);
      AppMethodBeat.o(246223);
      return;
    }
    AppMethodBeat.o(246223);
  }
  
  private static void a(cjc paramcjc, TRTCCloudDef.TRTCParams paramTRTCParams, com.tencent.mm.live.core.core.b.e parame)
  {
    AppMethodBeat.i(246224);
    a(paramcjc.Mot);
    a(paramcjc.Mou);
    Object localObject1 = paramcjc.Mov;
    if ((localObject1 != null) && (paramTRTCParams != null) && (parame != null))
    {
      Log.i("Finder.FinderLiveService", "userDefineRecordId:" + ((cja)localObject1).MnU);
      paramcjc = ((cja)localObject1).MnV;
      String str = ((cja)localObject1).MnU;
      int j = ((cja)localObject1).Moe;
      int i = j;
      if (!com.tencent.mm.modelcontrol.e.sX(5))
      {
        i = j;
        if (j == com.tencent.mm.live.core.core.a.hwC.value) {
          i = ((cja)localObject1).Mof;
        }
      }
      parame.hzr = ((cja)localObject1).Mof;
      Object localObject2;
      if (i < 100)
      {
        parame.a(com.tencent.mm.live.core.core.b.a.hyD);
        parame.hzq = i;
        localObject2 = (Collection)((cja)localObject1).Moa;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label310;
        }
      }
      label310:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label315;
        }
        localObject1 = ((cja)localObject1).Moa;
        p.g(localObject1, "channelParams.cdn_trans_info");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (vh)((Iterator)localObject1).next();
          localObject2 = (Map)parame.hzs;
          i = ((vh)localObject3).LfB;
          localObject3 = ((vh)localObject3).url;
          p.g(localObject3, "it.url");
          ((Map)localObject2).put(Integer.valueOf(i), localObject3);
        }
        if (i == com.tencent.mm.live.core.core.a.hwD.value)
        {
          parame.a(com.tencent.mm.live.core.core.b.a.hyE);
          break;
        }
        if (i != com.tencent.mm.live.core.core.a.hwE.value) {
          break;
        }
        parame.a(com.tencent.mm.live.core.core.b.a.hyF);
        break;
      }
      label315:
      if ((!Util.isNullOrNil(paramcjc)) || (!Util.isNullOrNil(str)))
      {
        localObject1 = new com.tencent.mm.ab.i();
        if (!Util.isNullOrNil(paramcjc)) {
          ((com.tencent.mm.ab.i)localObject1).h("userdefine_streamid_main", paramcjc);
        }
        if (!Util.isNullOrNil(str)) {
          ((com.tencent.mm.ab.i)localObject1).h("userdefine_record_id", str);
        }
        paramcjc = new com.tencent.mm.ab.i();
        paramcjc.h("Str_uc_params", localObject1);
        paramTRTCParams.businessInfo = paramcjc.toString();
      }
      Log.i("Finder.FinderLiveService", "processLiveSdkParams cdnQualitySvrcfg" + parame.hzq + " cdnSwitchMode:" + parame.hzp + " cdn_quality_h265backcfg:" + parame.hzr);
    }
    AppMethodBeat.o(246224);
  }
  
  private static void a(cjd paramcjd)
  {
    AppMethodBeat.i(246222);
    if (paramcjd != null)
    {
      Object localObject;
      if (paramcjd.Mow > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDD();
        p.g(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).setVideoResolution(paramcjd.Mow);
      }
      if (paramcjd.Moy > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDD();
        p.g(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).qu(paramcjd.Moy);
      }
      if (paramcjd.Moz > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDD();
        p.g(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).setVideoBitrate(paramcjd.Moz);
      }
      if (paramcjd.MoB > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDD();
        p.g(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).qv(paramcjd.MoB);
      }
      int i = paramcjd.MoC;
      if (i < 0) {}
      for (;;)
      {
        Log.i("Finder.FinderLiveService", "processLiveVideoSdkParam encResEnum:" + paramcjd.Mow + ", capFps:" + paramcjd.Moy + ", encBR:" + paramcjd.Moz + ", qosPreferneceEnum:" + paramcjd.MoB + ", qosControlModeEnum:" + paramcjd.MoC);
        AppMethodBeat.o(246222);
        return;
        if (1 >= i)
        {
          localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
          p.g(localObject, "ConfigHelper.getInstance()");
          localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDD();
          p.g(localObject, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).qt(paramcjd.MoC);
        }
      }
    }
    AppMethodBeat.o(246222);
  }
  
  private static boolean a(int paramInt1, int paramInt2, auf paramauf)
  {
    long l1 = 0L;
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(246220);
    Object localObject4 = new StringBuilder("handleKeepAliveResp errCode:").append(paramInt1).append(", errType:").append(paramInt2).append(", curData:");
    Object localObject1 = ujz;
    label114:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((awe)localObject1).liveId);
        localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", resp.liveId:");
        localObject1 = paramauf.liveInfo;
        if (localObject1 == null) {
          break label226;
        }
        localObject1 = Long.valueOf(((awe)localObject1).liveId);
        Log.i("Finder.FinderLiveService", localObject1);
        if (paramInt1 != -100038) {
          break label232;
        }
        paramauf = ujz;
        if (paramauf != null)
        {
          localObject1 = hSS;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.trtc.a)localObject1).a(com.tencent.mm.live.core.mini.d.hCX);
          }
          localObject1 = com.tencent.mm.live.b.s.hIl;
          localObject1 = com.tencent.mm.live.b.s.aGe();
          if (localObject1 != null) {
            ((com.tencent.mm.live.b.j)localObject1).onCloseLive(new com.tencent.mm.live.b.e(paramauf.liveInfo.liveId));
          }
        }
        Log.i("Finder.FinderLiveService", "handleKeepAliveResp live has finished");
        bool = false;
      }
    }
    label415:
    for (;;)
    {
      AppMethodBeat.o(246220);
      return bool;
      localObject1 = null;
      break;
      label226:
      localObject1 = null;
      break label114;
      label232:
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        Log.i("Finder.FinderLiveService", "handleKeepAliveResp launch live room failed");
        bool = false;
      }
      else if (paramauf == null)
      {
        Log.i("Finder.FinderLiveService", "handleKeepAliveResp invalid live resp");
        bool = false;
      }
      else
      {
        localObject1 = paramauf.liveInfo;
        if (localObject1 != null) {}
        for (localObject1 = Long.valueOf(((awe)localObject1).liveId);; localObject1 = null)
        {
          if (!e((Long)localObject1)) {
            break label415;
          }
          localObject1 = new StringBuilder("handleKeepAliveResp invalid live id, curData:");
          localObject2 = ujz;
          long l2 = l1;
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject2).liveInfo;
            l2 = l1;
            if (localObject2 != null) {
              l2 = ((awe)localObject2).liveId;
            }
          }
          localObject1 = ((StringBuilder)localObject1).append(l2).append(", resp.liveId:");
          localObject2 = paramauf.liveInfo;
          paramauf = (auf)localObject3;
          if (localObject2 != null) {
            paramauf = Long.valueOf(((awe)localObject2).liveId);
          }
          Log.i("Finder.FinderLiveService", paramauf);
          bool = false;
          break;
        }
        localObject1 = paramauf.hIv;
        if (localObject1 != null)
        {
          localObject3 = ujz;
          if (localObject3 != null) {
            ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).a((cjb)localObject1);
          }
          localObject3 = ujz;
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).liveInfo;
            if (localObject3 != null)
            {
              localObject4 = paramauf.liveInfo;
              if (localObject4 != null) {
                l1 = ((awe)localObject4).liveId;
              }
              ((awe)localObject3).liveId = l1;
            }
          }
          Log.i("Finder.FinderLiveService", "doKeepAlive updatePrivateMapKey");
          localObject3 = com.tencent.mm.live.core.core.a.b.hyv;
          if (com.tencent.mm.live.core.core.a.b.a.aDp())
          {
            localObject3 = com.tencent.mm.live.core.core.a.b.hyv;
            MMApplicationContext.getContext();
            localObject3 = com.tencent.mm.live.core.core.a.b.a.aDo();
            localObject4 = ((cjb)localObject1).Mon.yO();
            p.g(localObject4, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            ((com.tencent.mm.live.core.core.a.b)localObject3).Go((String)localObject4);
          }
          for (;;)
          {
            localObject3 = ujz;
            if (localObject3 != null)
            {
              localObject4 = paramauf.LDx;
              paramauf = (auf)localObject2;
              if (localObject4 != null) {
                paramauf = ((com.tencent.mm.bw.b)localObject4).zy;
              }
              ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).hIt = paramauf;
            }
            paramauf = ujz;
            if (paramauf != null)
            {
              paramauf = paramauf.hIy;
              if (paramauf != null)
              {
                paramauf = paramauf.hzu;
                if (paramauf != null) {
                  paramauf.privateMapKey = ((cjb)localObject1).Mon.yO();
                }
              }
            }
            b((cjb)localObject1);
            if (!(hSS instanceof com.tencent.mm.live.core.core.a.b)) {
              break label778;
            }
            paramauf = hSS;
            if (paramauf != null) {
              break;
            }
            paramauf = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
            AppMethodBeat.o(246220);
            throw paramauf;
            localObject3 = com.tencent.mm.live.core.core.c.a.hAj;
            if (com.tencent.mm.live.core.core.c.a.a.aDp())
            {
              localObject3 = com.tencent.mm.live.core.core.c.a.hAj;
              MMApplicationContext.getContext();
              localObject3 = com.tencent.mm.live.core.core.c.a.a.aDw();
              localObject4 = ((cjb)localObject1).Mon.yO();
              p.g(localObject4, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
              ((com.tencent.mm.live.core.core.c.a)localObject3).Go((String)localObject4);
            }
            else
            {
              localObject3 = com.tencent.mm.live.core.core.d.b.hCo;
              if (com.tencent.mm.live.core.core.d.b.a.aDp())
              {
                localObject3 = com.tencent.mm.live.core.core.d.b.hCo;
                MMApplicationContext.getContext();
                localObject3 = com.tencent.mm.live.core.core.d.b.a.aEf();
                localObject4 = ((cjb)localObject1).Mon.yO();
                p.g(localObject4, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                ((com.tencent.mm.live.core.core.d.b)localObject3).Go((String)localObject4);
              }
            }
          }
          ((com.tencent.mm.live.core.core.a.b)paramauf).ew(dgl());
          bool = true;
        }
        else
        {
          bool = false;
        }
      }
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, awz paramawz)
  {
    AppMethodBeat.i(246219);
    Object localObject2 = new StringBuilder("handleRefreshMicResp errCode:").append(paramInt1).append(", errType:").append(paramInt2).append(", curData:");
    Object localObject1 = ujz;
    boolean bool1;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((awe)localObject1).liveId);
        Log.i("Finder.FinderLiveService", localObject1);
        boolean bool2 = false;
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          bool1 = bool2;
          if (paramInt1 == 0)
          {
            paramawz = paramawz.LFH;
            bool1 = bool2;
            if (paramawz != null)
            {
              localObject1 = ujz;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).a(paramawz);
              }
              Log.i("Finder.FinderLiveService", "handleRefreshMicResp updatePrivateMapKey");
              localObject1 = com.tencent.mm.live.core.core.a.b.hyv;
              if (!com.tencent.mm.live.core.core.a.b.a.aDp()) {
                break label255;
              }
              localObject1 = com.tencent.mm.live.core.core.a.b.hyv;
              MMApplicationContext.getContext();
              localObject1 = com.tencent.mm.live.core.core.a.b.a.aDo();
              localObject2 = paramawz.Mon.yO();
              p.g(localObject2, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
              ((com.tencent.mm.live.core.core.a.b)localObject1).Go((String)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = ujz;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).hIy;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.core.b.f)localObject1).hzu;
          if (localObject1 != null) {
            ((TRTCCloudDef.TRTCParams)localObject1).privateMapKey = paramawz.Mon.yO();
          }
        }
      }
      b(paramawz);
      bool1 = true;
      AppMethodBeat.o(246219);
      return bool1;
      localObject1 = null;
      break;
      label255:
      localObject1 = com.tencent.mm.live.core.core.c.a.hAj;
      if (com.tencent.mm.live.core.core.c.a.a.aDp())
      {
        localObject1 = com.tencent.mm.live.core.core.c.a.hAj;
        MMApplicationContext.getContext();
        localObject1 = com.tencent.mm.live.core.core.c.a.a.aDw();
        localObject2 = paramawz.Mon.yO();
        p.g(localObject2, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
        ((com.tencent.mm.live.core.core.c.a)localObject1).Go((String)localObject2);
      }
      else
      {
        localObject1 = com.tencent.mm.live.core.core.d.b.hCo;
        if (com.tencent.mm.live.core.core.d.b.a.aDp())
        {
          localObject1 = com.tencent.mm.live.core.core.d.b.hCo;
          MMApplicationContext.getContext();
          localObject1 = com.tencent.mm.live.core.core.d.b.a.aEf();
          localObject2 = paramawz.Mon.yO();
          p.g(localObject2, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          ((com.tencent.mm.live.core.core.d.b)localObject1).Go((String)localObject2);
        }
      }
    }
  }
  
  public static com.tencent.mm.live.core.b.a aGk()
  {
    return hDV;
  }
  
  public static com.tencent.mm.live.core.b.b aGl()
  {
    return hDW;
  }
  
  public static void aHh()
  {
    AppMethodBeat.i(246237);
    hWh.apm();
    Object localObject = ujK;
    if (localObject != null) {
      ((w)localObject).dgE();
    }
    localObject = ujL;
    if (localObject != null) {
      ((w)localObject).dgE();
    }
    localObject = ujM;
    if (localObject != null) {
      ((w)localObject).dgE();
    }
    localObject = j.ujh;
    j.dfM();
    AppMethodBeat.o(246237);
  }
  
  private static void ab(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(246247);
    p.h(paramContext, "context");
    Log.i("Finder.FinderLiveService", "closeMiniProgram,purpose:".concat(String.valueOf(paramInt)));
    Object localObject = com.tencent.mm.plugin.finder.live.viewmodel.d.uCw;
    com.tencent.mm.plugin.finder.live.viewmodel.d.diN().clear();
    localObject = new Intent();
    FinderLiveMiniProProxyUI.a locala = FinderLiveMiniProProxyUI.ubz;
    ((Intent)localObject).putExtra(FinderLiveMiniProProxyUI.dec(), paramInt);
    ((Intent)localObject).addFlags(335544320);
    ((Intent)localObject).setClass(paramContext, FinderLiveMiniProProxyUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "closeMiniProgram", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "closeMiniProgram", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(246247);
  }
  
  private static void al(LinkedList<aut> paramLinkedList)
  {
    AppMethodBeat.i(246242);
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = ujz;
    if (localg != null)
    {
      Object localObject1 = i.uja;
      LinkedList localLinkedList = i.aj(paramLinkedList);
      Object localObject6 = (aut)kotlin.a.j.kt((List)localLinkedList);
      Object localObject5;
      Object localObject2;
      if (localObject6 != null)
      {
        localObject5 = new auu();
        localObject2 = (com.tencent.mm.bw.a)localObject5;
        localObject1 = ((aut)localObject6).LFB;
        if (localObject1 == null) {
          break label902;
        }
        localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();
      }
      try
      {
        for (;;)
        {
          ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
          if (dMz) {
            break label1024;
          }
          localObject1 = ((auu)localObject5).LFH;
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((cjb)localObject1).MnL;
          localObject2 = ((auu)localObject5).LFI;
          if (localObject2 == null) {
            break label937;
          }
          localObject2 = ((avn)localObject2).contact;
          if (localObject2 == null) {
            break label937;
          }
          localObject2 = ((FinderContact)localObject2).headUrl;
          localObject3 = ((auu)localObject5).LFI;
          if (localObject3 == null) {
            break label943;
          }
          localObject3 = ((avn)localObject3).contact;
          if (localObject3 == null) {
            break label943;
          }
          localObject3 = ((FinderContact)localObject3).username;
          localObject4 = ((auu)localObject5).LFI;
          if (localObject4 == null) {
            break label949;
          }
          localObject4 = ((avn)localObject4).contact;
          if (localObject4 == null) {
            break label949;
          }
          localObject4 = ((FinderContact)localObject4).nickname;
          localg.uEB = new com.tencent.mm.plugin.finder.live.viewmodel.e((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, ((auu)localObject5).LFG, ((aut)localObject6).session_id);
          localObject1 = ((auu)localObject5).LFH;
          if (localObject1 == null) {
            break label955;
          }
          localObject1 = ((cjb)localObject1).MnL;
          if (!Util.isEqual((String)localObject1, localg.djq())) {
            break label961;
          }
          Log.i("Finder.FinderLiveService", "visitor receive accept msg, curLinkMicUser is me");
          if (localg.djr()) {
            break label961;
          }
          localg.uEC = 0;
          localg.uEB = null;
          bool = true;
          Log.i("Finder.FinderLiveService", "invalid linkState:" + localg.uEC + ", skip accept!");
          localObject2 = new StringBuilder("skipAccept:").append(bool).append(" receive accept msg:[isAnchor:").append(dMz).append(", username:");
          localObject1 = ((aut)localObject6).LFE;
          if (localObject1 == null) {
            break label1040;
          }
          localObject1 = ((avn)localObject1).contact;
          if (localObject1 == null) {
            break label1040;
          }
          localObject1 = ((FinderContact)localObject1).username;
          localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(", nickname:");
          localObject1 = ((aut)localObject6).LFE;
          if (localObject1 == null) {
            break label1046;
          }
          localObject1 = ((avn)localObject1).contact;
          if (localObject1 == null) {
            break label1046;
          }
          localObject1 = ((FinderContact)localObject1).nickname;
          localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(", sdkUerId:");
          localObject1 = ((auu)localObject5).LFH;
          if (localObject1 == null) {
            break label1052;
          }
          localObject1 = ((cjb)localObject1).MnL;
          Log.i("Finder.FinderLiveService", (String)localObject1 + ", micType:" + ((auu)localObject5).LFG + ", sessionId:" + ((aut)localObject6).session_id + ']');
          if (!bool)
          {
            localObject1 = com.tencent.mm.live.b.s.hIl;
            com.tencent.mm.live.b.j localj = com.tencent.mm.live.b.s.aGe();
            if (localj != null)
            {
              long l2 = localg.liveInfo.liveId;
              localObject6 = ((aut)localObject6).session_id;
              localObject1 = ((auu)localObject5).LFH;
              if (localObject1 == null) {
                break label1058;
              }
              localObject1 = ((cjb)localObject1).MnL;
              localObject2 = ((auu)localObject5).LFH;
              if (localObject2 == null) {
                break label1064;
              }
              i = ((cjb)localObject2).Moj;
              localObject2 = ((auu)localObject5).LFH;
              if (localObject2 == null) {
                break label1069;
              }
              j = ((cjb)localObject2).Mol;
              localObject2 = ((auu)localObject5).LFH;
              if (localObject2 == null) {
                break label1074;
              }
              k = ((cjb)localObject2).Mok;
              localObject2 = ((auu)localObject5).LFH;
              if (localObject2 == null) {
                break label1079;
              }
              localObject2 = ((cjb)localObject2).Mom;
              if (localObject2 == null) {
                break label1079;
              }
              localObject2 = ((com.tencent.mm.bw.b)localObject2).yO();
              localObject3 = ((auu)localObject5).LFH;
              if (localObject3 == null) {
                break label1085;
              }
              localObject3 = ((cjb)localObject3).Mon;
              if (localObject3 == null) {
                break label1085;
              }
              localObject3 = ((com.tencent.mm.bw.b)localObject3).yO();
              localObject4 = ((auu)localObject5).LFH;
              if (localObject4 == null) {
                break label1091;
              }
              l1 = ((cjb)localObject4).Mor;
              localObject4 = ((auu)localObject5).LFH;
              if (localObject4 == null) {
                break label1097;
              }
              localObject4 = ((cjb)localObject4).Moo;
              if (localObject4 == null) {
                break label1097;
              }
              localObject4 = ((com.tencent.mm.bw.b)localObject4).yO();
              localj.onAcceptLiveMic(new com.tencent.mm.live.b.a(l2, (String)localObject6, (String)localObject1, i, j, k, (String)localObject2, (String)localObject3, l1, (String)localObject4, Integer.valueOf(((auu)localObject5).LFG), ((auu)localObject5).seq));
            }
          }
          localObject1 = i.uja;
          paramLinkedList = (Iterable)i.ak(paramLinkedList);
          localObject1 = (Collection)new ArrayList();
          localObject2 = paramLinkedList.iterator();
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label1113;
            }
            localObject3 = ((Iterator)localObject2).next();
            paramLinkedList = ((aut)localObject3).LFE;
            if (paramLinkedList == null) {
              break;
            }
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null) {
              break;
            }
            paramLinkedList = paramLinkedList.username;
            if (Util.isEqual(paramLinkedList, z.aTY())) {
              break label1108;
            }
            i = 1;
            if (i != 0) {
              ((Collection)localObject1).add(localObject3);
            }
          }
          label902:
          localObject1 = null;
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        Object localObject4;
        for (;;)
        {
          boolean bool;
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          continue;
          localList = null;
          continue;
          label937:
          localObject2 = null;
          continue;
          label943:
          localObject3 = null;
          continue;
          label949:
          localObject4 = null;
          continue;
          label955:
          localList = null;
          continue;
          label961:
          Log.i("Finder.FinderLiveService", "checkAcceptMicType micType:" + ((auu)localObject5).LFG);
          switch (((auu)localObject5).LFG)
          {
          default: 
            i = 0;
          }
          for (;;)
          {
            localg.uEC = i;
            label1024:
            bool = false;
            break;
            i = 3;
            continue;
            i = 4;
          }
          label1040:
          localList = null;
          continue;
          label1046:
          localList = null;
          continue;
          label1052:
          localList = null;
          continue;
          label1058:
          localList = null;
          continue;
          label1064:
          int i = 0;
          continue;
          label1069:
          int j = 0;
          continue;
          label1074:
          int k = 0;
          continue;
          label1079:
          localObject2 = null;
          continue;
          label1085:
          localObject3 = null;
          continue;
          label1091:
          l1 = 0L;
          continue;
          label1097:
          localObject4 = null;
          continue;
          paramLinkedList = null;
          continue;
          label1108:
          i = 0;
        }
        label1113:
        List localList = (List)localList;
        localObject2 = ((Iterable)localList).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1609;
          }
          localObject3 = (aut)((Iterator)localObject2).next();
          localObject4 = new aux();
          localObject5 = (com.tencent.mm.bw.a)localObject4;
          paramLinkedList = ((aut)localObject3).LFB;
          if (paramLinkedList != null) {
            paramLinkedList = paramLinkedList.toByteArray();
          }
          try
          {
            for (;;)
            {
              ((com.tencent.mm.bw.a)localObject5).parseFrom(paramLinkedList);
              if (!dMz) {
                break label1499;
              }
              localObject5 = ((aut)localObject3).session_id;
              paramLinkedList = localg.uEB;
              if (paramLinkedList == null) {
                break label1489;
              }
              paramLinkedList = paramLinkedList.sessionId;
              if (Util.isEqual((String)localObject5, paramLinkedList))
              {
                paramLinkedList = com.tencent.mm.live.b.s.hIl;
                localObject5 = com.tencent.mm.live.b.s.aGe();
                if (localObject5 != null)
                {
                  l1 = localg.liveInfo.liveId;
                  paramLinkedList = ((aut)localObject3).LFE;
                  if (paramLinkedList == null) {
                    break label1494;
                  }
                  paramLinkedList = paramLinkedList.contact;
                  if (paramLinkedList == null) {
                    break label1494;
                  }
                  paramLinkedList = paramLinkedList.username;
                  ((com.tencent.mm.live.b.j)localObject5).onCloseLiveMic(new com.tencent.mm.live.b.f(l1, paramLinkedList, ((aut)localObject3).session_id));
                }
                localg.uEC = 0;
                localg.uEB = null;
                Log.i("Finder.FinderLiveService", "anchor receive close msg, [sdkUserId:" + ((aux)localObject4).Lmn + ']');
              }
              kotlin.a.j.c((List)localg.uEz, (kotlin.g.a.b)new b((aut)localObject3));
              kotlin.a.j.c((List)localg.uEA, (kotlin.g.a.b)new c((aut)localObject3));
              Log.i("Finder.FinderLiveService", "receive close msg, [sdkUserId:" + ((aux)localObject4).Lmn + ", sessionId:" + ((aut)localObject3).session_id + "], curLiveUser:" + localg.uEB + ", qpplySessionId:" + localg.uEy);
              break;
              paramLinkedList = null;
            }
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              continue;
              label1489:
              paramLinkedList = null;
              continue;
              label1494:
              paramLinkedList = null;
            }
            label1499:
            paramLinkedList = com.tencent.mm.live.b.s.hIl;
            localObject5 = com.tencent.mm.live.b.s.aGe();
            if (localObject5 == null) {
              break label1569;
            }
          }
        }
        long l1 = localg.liveInfo.liveId;
        paramLinkedList = ((aut)localObject3).LFE;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null) {}
        }
        for (paramLinkedList = paramLinkedList.username;; paramLinkedList = null)
        {
          ((com.tencent.mm.live.b.j)localObject5).onCloseLiveMic(new com.tencent.mm.live.b.f(l1, paramLinkedList, ((aut)localObject3).session_id));
          label1569:
          Log.i("Finder.FinderLiveService", "visitor receive close msg, [sdkUserId:" + ((aux)localObject4).Lmn + ']');
          break;
        }
        label1609:
        Log.i("Finder.FinderLiveService", "checkLinkState acceptMicMsgList:" + localLinkedList.size() + " closeMicMsgList:" + localList.size() + " isAnchor:" + dMz);
        AppMethodBeat.o(246242);
        return;
      }
    }
    AppMethodBeat.o(246242);
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(246245);
    p.h(paramContext, "context");
    p.h(paramg, "bundle");
    int i = paramg.hashCode();
    paramg.kHO = true;
    paramg.kHN = ((com.tencent.mm.plugin.appbrand.api.i)new k());
    Object localObject = com.tencent.mm.plugin.finder.live.viewmodel.d.uCw;
    ((Map)com.tencent.mm.plugin.finder.live.viewmodel.d.diN()).put(Integer.valueOf(i), paramg);
    Log.i("Finder.FinderLiveService", "launchMiniProgram,key:" + i + ",bundle is null:false");
    paramg = new Intent();
    localObject = FinderLiveMiniProProxyUI.ubz;
    localObject = FinderLiveMiniProProxyUI.dec();
    FinderLiveMiniProProxyUI.a locala = FinderLiveMiniProProxyUI.ubz;
    paramg.putExtra((String)localObject, FinderLiveMiniProProxyUI.dee());
    localObject = FinderLiveMiniProProxyUI.ubz;
    paramg.putExtra(FinderLiveMiniProProxyUI.ded(), i);
    paramg.putExtra("MMActivity.OverrideEnterAnimation", -1);
    paramg.putExtra("MMActivity.OverrideExitAnimation", -1);
    paramg.addFlags(335544320);
    paramg.setClass(paramContext, FinderLiveMiniProProxyUI.class);
    paramg = new com.tencent.mm.hellhoundlib.b.a().bl(paramg);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramg.axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "launchMiniProgram", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramg.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "launchMiniProgram", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(246245);
  }
  
  public static void b(com.tencent.mm.bw.b paramb)
  {
    ujD = paramb;
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.viewmodel.d paramd)
  {
    AppMethodBeat.i(246216);
    Log.i("Finder.FinderLiveService", "FinderLiveDataModel set ".concat(String.valueOf(paramd)));
    ujy = paramd;
    AppMethodBeat.o(246216);
  }
  
  private static void b(cjb paramcjb)
  {
    AppMethodBeat.i(246221);
    if (dMz)
    {
      Object localObject = ujz;
      if (localObject != null)
      {
        try
        {
          localcjc = new cjc();
          paramcjb = paramcjb.Moo;
          p.g(paramcjb, "liveSdkInfo.sdk_params");
          paramcjb = localcjc.parseFrom(paramcjb.zy);
          if (paramcjb != null) {
            break label106;
          }
          paramcjb = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
          AppMethodBeat.o(246221);
          throw paramcjb;
        }
        catch (Exception paramcjb)
        {
          Log.w("Finder.FinderLiveService", "updateSdkParam fail:" + paramcjb.getMessage());
        }
        AppMethodBeat.o(246221);
        return;
        label106:
        cjc localcjc = (cjc)paramcjb;
        paramcjb = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).hIy;
        if (paramcjb != null)
        {
          paramcjb = paramcjb.hzu;
          label125:
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).hIy;
          if (localObject == null) {
            break label322;
          }
          localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hwP;
          label139:
          a(localcjc, paramcjb, (com.tencent.mm.live.core.core.b.e)localObject);
          paramcjb = hSS;
          if (paramcjb != null) {
            paramcjb.aDy();
          }
          localObject = new StringBuilder("updateSdkParam lastFps:");
          paramcjb = hSS;
          if (paramcjb == null) {
            break label327;
          }
        }
        label322:
        label327:
        for (paramcjb = Integer.valueOf(paramcjb.hAB);; paramcjb = null)
        {
          paramcjb = ((StringBuilder)localObject).append(paramcjb).append(" new Fps:");
          localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
          p.g(localObject, "ConfigHelper.getInstance()");
          localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDD();
          p.g(localObject, "ConfigHelper.getInstance().videoConfig");
          Log.i("Finder.FinderLiveService", ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).aDR());
          if ((hSS == null) || (!(hSS instanceof com.tencent.mm.live.core.core.a.b))) {
            break;
          }
          paramcjb = hSS;
          if (paramcjb != null)
          {
            int i = paramcjb.hAB;
            paramcjb = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            p.g(paramcjb, "ConfigHelper.getInstance()");
            paramcjb = paramcjb.aDD();
            p.g(paramcjb, "ConfigHelper.getInstance().videoConfig");
            if (i == paramcjb.aDR()) {
              break;
            }
          }
          if (!dgm()) {
            break;
          }
          com.tencent.mm.ac.d.h((kotlin.g.a.a)r.ujV);
          AppMethodBeat.o(246221);
          return;
          paramcjb = null;
          break label125;
          localObject = null;
          break label139;
        }
      }
    }
    AppMethodBeat.o(246221);
  }
  
  private static boolean b(int paramInt1, final int paramInt2, final ass paramass)
  {
    AppMethodBeat.i(246218);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.c.vVc;
    Object localObject3 = paramass.liveInfo;
    long l;
    boolean bool1;
    if (localObject3 != null)
    {
      l = ((awe)localObject3).liveId;
      if (l == 0L) {
        break label414;
      }
      bool1 = true;
      label39:
      f.a.a((com.tencent.mm.ac.f)localObject1, "liveHeartBeatSvrErr", bool1, false, (kotlin.g.a.a)new h(paramInt1, paramInt2), 12);
      localObject1 = com.tencent.mm.plugin.finder.utils.c.vVc;
      localObject3 = ujz;
      if (localObject3 == null) {
        break label420;
      }
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).liveInfo;
      if (localObject3 == null) {
        break label420;
      }
      l = ((awe)localObject3).liveId;
      label98:
      if (l == 0L) {
        break label426;
      }
      bool1 = true;
      label108:
      f.a.a((com.tencent.mm.ac.f)localObject1, "liveHeartBeatLocalErr", bool1, false, (kotlin.g.a.a)new i(paramInt1, paramInt2, paramass), 12);
      localObject3 = new StringBuilder("handleLiveMsgResp errCode:").append(paramInt1).append(" curData:");
      localObject1 = ujz;
      if (localObject1 == null) {
        break label432;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo;
      if (localObject1 == null) {
        break label432;
      }
      localObject1 = Long.valueOf(((awe)localObject1).liveId);
      label188:
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", resp.liveId:");
      localObject1 = paramass.liveInfo;
      if (localObject1 == null) {
        break label438;
      }
      localObject1 = Long.valueOf(((awe)localObject1).liveId);
      label224:
      Log.i("Finder.FinderLiveService", localObject1);
      if (paramass != null)
      {
        localObject1 = paramass.liveInfo;
        if (localObject1 == null) {
          break label444;
        }
        localObject1 = Long.valueOf(((awe)localObject1).liveId);
        label265:
        localObject3 = ujz;
        if (localObject3 == null) {
          break label450;
        }
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).liveInfo;
        if (localObject3 == null) {
          break label450;
        }
        localObject3 = Long.valueOf(((awe)localObject3).liveId);
        label297:
        if (!(p.j(localObject1, localObject3) ^ true)) {
          break label467;
        }
      }
      localObject3 = new StringBuilder("handleLiveMsgResp invalid live resp, curData:");
      localObject1 = ujz;
      if (localObject1 == null) {
        break label456;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo;
      if (localObject1 == null) {
        break label456;
      }
      localObject1 = Long.valueOf(((awe)localObject1).liveId);
      label353:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(", resp.liveId:");
      paramass = paramass.liveInfo;
      if (paramass == null) {
        break label462;
      }
    }
    label414:
    label420:
    label426:
    label432:
    label438:
    label444:
    label450:
    label456:
    label462:
    for (paramass = Long.valueOf(paramass.liveId);; paramass = null)
    {
      Log.i("Finder.FinderLiveService", paramass);
      AppMethodBeat.o(246218);
      return false;
      l = 0L;
      break;
      bool1 = false;
      break label39;
      l = 0L;
      break label98;
      bool1 = false;
      break label108;
      localObject1 = null;
      break label188;
      localObject1 = null;
      break label224;
      localObject1 = null;
      break label265;
      localObject3 = null;
      break label297;
      localObject1 = null;
      break label353;
    }
    label467:
    localObject1 = paramass.liveInfo;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((awe)localObject1).liveId);
      if (!e((Long)localObject1)) {
        break label612;
      }
      localObject3 = new StringBuilder("handleLiveMsgResp invalid live id, curData:");
      localObject1 = ujz;
      if (localObject1 == null) {
        break label601;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo;
      if (localObject1 == null) {
        break label601;
      }
      localObject1 = Long.valueOf(((awe)localObject1).liveId);
      label540:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(", resp.liveId:");
      paramass = paramass.liveInfo;
      if (paramass == null) {
        break label607;
      }
    }
    label601:
    label607:
    for (paramass = Long.valueOf(paramass.liveId);; paramass = null)
    {
      Log.i("Finder.FinderLiveService", paramass);
      AppMethodBeat.o(246218);
      return false;
      localObject1 = null;
      break;
      localObject1 = null;
      break label540;
    }
    label612:
    localObject1 = ujz;
    if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).djl() == true))
    {
      Log.i("Finder.FinderLiveService", "handleLiveMsgResp live has finished");
      AppMethodBeat.o(246218);
      return false;
    }
    int i;
    if ((paramInt2 == 4) && (paramInt1 == -100020))
    {
      i = 1;
      if (i == 0) {
        break label683;
      }
      EJ(0L);
    }
    label2974:
    label2980:
    label3237:
    for (;;)
    {
      AppMethodBeat.o(246218);
      return true;
      i = 0;
      break;
      label683:
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        Log.e("Finder.FinderLiveService", "onGYNetEnd error");
      }
      label3110:
      label3119:
      switch (paramInt1)
      {
      default: 
        break;
      case -200001: 
        paramass = q.ukd;
        q.dgB();
        continue;
        com.tencent.mm.plugin.finder.live.viewmodel.g localg = ujz;
        if (localg == null) {
          continue;
        }
        localObject1 = paramass.liveInfo;
        if (localObject1 != null)
        {
          localg.uDP = (((awe)localObject1).wBG - localg.liveInfo.wBG);
          localg.liveInfo.wBG = Math.max(localg.liveInfo.wBG, ((awe)localObject1).wBG);
          localg.liveInfo.LDN = ((awe)localObject1).LDN;
          localg.liveInfo.uBn = paramass.LDA;
          localg.liveInfo.LGS = ((awe)localObject1).LGS;
          localg.uDV = paramass.LDH;
          localObject1 = paramass.liveInfo;
          if (localObject1 != null)
          {
            paramInt1 = ((awe)localObject1).LGU;
            if (!localg.uEd)
            {
              if (((paramInt1 & 0x1) <= 0) && ((paramInt1 & 0x2) <= 0)) {
                break label2936;
              }
              bool1 = true;
              localg.uEd = bool1;
            }
          }
        }
        localObject3 = paramass.FoQ;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new LinkedList();
        }
        Object localObject4 = paramass.LDI;
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = new LinkedList();
        }
        Object localObject5 = z.aTY();
        String str = z.aUg();
        localObject4 = ujz;
        if (localObject4 != null)
        {
          i locali = i.uja;
          i.c((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4, (LinkedList)localObject1);
          locali = i.uja;
          i.d((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4, (LinkedList)localObject1);
          locali = i.uja;
          i.a((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4, (LinkedList)localObject1, (LinkedList)localObject3, ujB, (String)localObject5, str);
          localObject5 = i.uja;
          i.e((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4, (LinkedList)localObject1);
          localObject1 = i.uja;
          i.f((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4, (LinkedList)localObject3);
          localObject1 = i.uja;
          i.g((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4, (LinkedList)localObject3);
          Log.i("Finder.FinderLiveService", "handleMsg bulletCommetList.size:" + ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4).uDt.size() + ", msgList.size:" + ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4).uDs.size() + ", topMsgList.size:" + ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4).uDu.size());
        }
        localObject3 = paramass.LDI;
        localObject4 = ujz;
        if (localObject4 != null)
        {
          localObject1 = a.uhJ;
          a.a((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4, (LinkedList)localObject3);
          localObject1 = i.uja;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new LinkedList();
          }
          p.h(localObject4, "roomData");
          p.h(localObject1, "remoteLiveMsg");
          ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4).uDw.addAll((Collection)kotlin.m.i.c(kotlin.m.i.d(kotlin.m.i.a(kotlin.a.j.z((Iterable)localObject1), (kotlin.g.a.b)i.a.ujb), (kotlin.g.a.b)i.b.ujc)));
          Log.i("Finder.FinderLiveService", "handleAppMsg giftMsgList.size:" + ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4).uDw.size());
        }
        localObject1 = paramass.LDJ;
        localObject3 = ujz;
        if (localObject3 != null)
        {
          localObject4 = a.uhJ;
          a.b((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3, (LinkedList)localObject1);
        }
        localObject3 = paramass.LDI;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new LinkedList();
        }
        al((LinkedList)localObject1);
        localObject1 = paramass.LDx;
        if (localObject1 != null)
        {
          p.g(localObject1, "cookies");
          localg.hIt = ((com.tencent.mm.bw.b)localObject1).zy;
        }
        localObject1 = paramass.liveInfo;
        if (localObject1 != null)
        {
          localObject1 = ((awe)localObject1).LGR;
          if (localObject1 != null)
          {
            localObject3 = ((avs)localObject1).LGq;
            if (localObject3 != null)
            {
              localObject1 = (com.tencent.mm.bw.a)new ciq();
              p.g(localObject3, "it");
              localObject3 = ((com.tencent.mm.bw.b)localObject3).zy;
            }
          }
        }
        label3009:
        label3015:
        label3020:
        label3029:
        label3034:
        label3167:
        try
        {
          ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
          localObject1 = (ciq)localObject1;
          if (localObject1 != null)
          {
            l = ((ciq)localObject1).MnE;
            if (com.tencent.mm.ac.d.cW((int)l, 8)) {
              break label2974;
            }
            bool1 = true;
            if (bool1 != localg.uDD)
            {
              if (!bool1) {
                break label2980;
              }
              localObject1 = MMApplicationContext.getContext();
              p.g(localObject1, "MMApplicationContext.getContext()");
              localObject1 = ((Context)localObject1).getResources().getString(2131759896);
              p.g(localObject1, "if (liveRoomComment) MMA…e_comment_anchor_disable)");
              localObject3 = new awq();
              localObject4 = new avn();
              localObject5 = new FinderContact();
              ((FinderContact)localObject5).username = "";
              ((FinderContact)localObject5).nickname = "";
              ((FinderContact)localObject5).headUrl = "";
              ((avn)localObject4).contact = ((FinderContact)localObject5);
              ((awq)localObject3).LHp = ((avn)localObject4);
              ((awq)localObject3).content = ((String)localObject1);
              localObject1 = com.tencent.mm.live.b.o.c.hGH;
              ((awq)localObject3).type = com.tencent.mm.live.b.o.c.aFq();
              localObject1 = new r((awq)localObject3);
              localg.uDs.add(localObject1);
            }
            localg.uDD = bool1;
            localg.uES = Boolean.valueOf(bool1);
            localg.uDQ = com.tencent.mm.ac.d.cW((int)l, 32);
            boolean bool2 = com.tencent.mm.ac.d.cW((int)l, 16);
            localg.uEk |= bool2;
            if ((!localg.uEG) || (!localg.uEH)) {
              break label3020;
            }
            boolean bool3 = com.tencent.mm.ac.d.cW((int)l, 64);
            if (localg.uEE != 1) {
              break label3009;
            }
            bool1 = true;
            if ((bool3 != bool1) && (localg.uEE != -1))
            {
              localObject1 = i.uja;
              i.d(localg);
            }
            if (!bool3) {
              break label3015;
            }
            paramInt1 = 1;
            localg.uEE = paramInt1;
            if ((!localg.uEJ) || (!localg.uEL)) {
              break label3034;
            }
            bool1 = com.tencent.mm.ac.d.cW((int)l, 128);
            if ((bool1 != localg.dja()) && (localg.uEI != -1))
            {
              localObject1 = i.uja;
              i.e(localg);
            }
            if (!bool1) {
              break label3029;
            }
            paramInt1 = 1;
            localg.uEI = paramInt1;
            localg.uDA = ((int)l);
            Log.i(localg.TAG, "updateLiveMsg anchorStatusFlag:" + l + ",enableLiveRoomComment:" + localg.uDD + ",liveBreakRule:" + localg.uDQ + ",shoppingAvailableStatus:" + bool2 + ", shoppingAvailable:" + localg.uEk + ", enableLinkMic:" + localg.diZ() + ", enableGift:" + localg.dja());
            localObject1 = paramass.FoQ;
            p.g(localObject1, "it.msgList");
            localg.aq((LinkedList)localObject1);
            localObject1 = com.tencent.mm.live.b.m.hGg;
            com.tencent.mm.live.b.m.aFe();
            if (paramass.LDC != 1) {
              break label3043;
            }
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              Log.i("Finder.FinderLiveService", "get live msg close live!");
              localg.nB(true);
              localObject1 = hSS;
              if (localObject1 != null) {
                ((com.tencent.mm.live.core.core.trtc.a)localObject1).a(com.tencent.mm.live.core.mini.d.hCX);
              }
              localObject1 = com.tencent.mm.live.b.s.hIl;
              localObject1 = com.tencent.mm.live.b.s.aGe();
              if (localObject1 != null) {
                ((com.tencent.mm.live.b.j)localObject1).onCloseLive(new com.tencent.mm.live.b.e(localg.liveInfo.liveId));
              }
            }
            if (paramInt1 == 0)
            {
              if ((dMz) && (localg.uEU))
              {
                localObject1 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(localObject1, "ConfigHelper.getInstance()");
                localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).aDD().Lb();
                localObject1 = localg.liveInfo.LGS;
                if (localObject1 == null) {
                  break label3048;
                }
                localObject1 = ((awl)localObject1).LHh;
                a((cjd)localObject1);
                localObject1 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(localObject1, "ConfigHelper.getInstance()");
                localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).aDD().Lb();
                if (!Util.isEqual((String)localObject3, (String)localObject1))
                {
                  localObject4 = hSS;
                  if (localObject4 != null) {
                    ((com.tencent.mm.live.core.core.trtc.a)localObject4).aDy();
                  }
                }
                Log.i("Finder.FinderLiveService", "check update sdk param while heartbeating, beforeKey:" + (String)localObject3 + " afterKey:" + (String)localObject1);
              }
              if (localg.uDU != paramass.LDF)
              {
                Log.i("Finder.FinderLiveService", "[heartbeat] checkAnchorAlive isAnchor:" + dMz + " localLiveExtFlag:" + localg.uDU + " liveExtFlag:" + paramass.LDF);
                if (!dMz)
                {
                  if ((Ji(localg.uDU)) || (!Ji(paramass.LDF))) {
                    break label3054;
                  }
                  Log.i("Finder.FinderLiveService", "[heartbeat] checkAnchorAlive anchor alive expired:true");
                  localObject1 = com.tencent.mm.live.b.s.hIl;
                  localObject1 = com.tencent.mm.live.b.s.aGe();
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.b.j)localObject1).onAnchorConnectionChange(false);
                  }
                }
                Log.i("Finder.FinderLiveService", "[heartbeat] checkLinkMicEnable isAnchor:" + dMz + " localLiveExtFlag:" + localg.uDU + " liveExtFlag:" + paramass.LDF + " localEnableLinkMicFun:" + localg.uEG + " localEnableLinkMic:" + localg.diZ() + " localEnableLinkMicAntispam:" + localg.uEH);
                if (!dMz) {
                  break label3119;
                }
                if (com.tencent.mm.ac.d.cW(paramass.LDF, 4)) {
                  break label3110;
                }
                Log.i("Finder.FinderLiveService", "[heartbeat] checkLinkMicEnable disableLinkMic");
                localg.uEH = false;
                localg.uEE = 0;
                localg.uDA &= 0xFFFFFFBF;
                localObject1 = ujx;
                if (localObject1 != null) {
                  s.a.a((s)localObject1, localg.liveInfo.liveId, localg.hFK, localg.uDA);
                }
                Log.i("Finder.FinderLiveService", "[heartbeat] checkGiftEnable isAnchor:" + dMz + " localLiveExtFlag:" + localg.uDU + " liveExtFlag:" + paramass.LDF + " localEnableGiftFun:" + localg.uEJ + " localEnableGift:" + localg.dja() + " localEnableGiftAntispam:" + localg.uEL);
                if (!dMz) {
                  break label3176;
                }
                if (com.tencent.mm.ac.d.cW(paramass.LDF, 2)) {
                  break label3167;
                }
                Log.i("Finder.FinderLiveService", "[heartbeat] checkGiftEnable disableGift");
                localg.uEL = false;
                localg.uEI = 0;
                localg.uDA &= 0xFFFFFF7F;
                localObject1 = ujx;
                if (localObject1 != null) {
                  s.a.a((s)localObject1, localg.liveInfo.liveId, localg.hFK, localg.uDA);
                }
                localg.uDU = paramass.LDF;
              }
            }
            localg.a(paramass.LDK);
            localObject3 = new StringBuilder("cur liveId:").append(localg.liveInfo.liveId).append(",remote liveId:");
            localObject1 = paramass.liveInfo;
            if (localObject1 == null) {
              break label3225;
            }
            localObject1 = Long.valueOf(((awe)localObject1).liveId);
            localObject3 = ((StringBuilder)localObject3).append(localObject1).append(",likeCnt:").append(localg.liveInfo.wBG).append(", remoteLikeCnt:");
            localObject1 = paramass.liveInfo;
            if (localObject1 == null) {
              break label3231;
            }
            localObject1 = Integer.valueOf(((awe)localObject1).wBG);
            localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", onlineCount:").append(localg.liveInfo.uBn).append(", reward_total_amount_in_heat:").append(localg.liveInfo.LDN).append(",remoteMsgSize:");
            localObject1 = paramass.FoQ;
            if (localObject1 == null) {
              break label3237;
            }
            localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
            Log.i("Finder.FinderLiveService", localObject1 + ", msgSize:" + localg.uDs.size() + ", remoteExtFlag:" + paramass.LDF + ", participantCnt:" + paramass.LDH + ", qosControl:" + localg.uEU + ", localExtFlag" + localg.uDU);
            continue;
            label2936:
            bool1 = false;
          }
        }
        catch (Exception localException)
        {
          label3043:
          label3176:
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException });
            Object localObject2 = null;
            continue;
            l = 0L;
            continue;
            bool1 = false;
            continue;
            localObject2 = MMApplicationContext.getContext();
            p.g(localObject2, "MMApplicationContext.getContext()");
            localObject2 = ((Context)localObject2).getResources().getString(2131759895);
            continue;
            bool1 = false;
            continue;
            paramInt1 = 0;
            continue;
            localg.uEE = 0;
            continue;
            paramInt1 = 0;
            continue;
            localg.uEI = 0;
            continue;
            paramInt1 = 0;
            continue;
            label3048:
            localObject2 = null;
            continue;
            label3054:
            if ((Ji(localg.uDU)) && (!Ji(paramass.LDF)))
            {
              Log.i("Finder.FinderLiveService", "[heartbeat] checkAnchorAlive anchor alive expired:false");
              localObject2 = com.tencent.mm.live.b.s.hIl;
              localObject2 = com.tencent.mm.live.b.s.aGe();
              if (localObject2 != null)
              {
                ((com.tencent.mm.live.b.j)localObject2).onAnchorConnectionChange(true);
                continue;
                localg.uEH = true;
                continue;
                if (!com.tencent.mm.ac.d.cW(paramass.LDF, 4))
                {
                  Log.i("Finder.FinderLiveService", "[heartbeat] checkLinkMicEnable disableLinkMic");
                  localg.uEG = false;
                  localg.uDA &= 0xFFFFFFBF;
                  localg.uEE = 0;
                  continue;
                  localg.uEL = true;
                  continue;
                  if (!com.tencent.mm.ac.d.cW(paramass.LDF, 2))
                  {
                    Log.i("Finder.FinderLiveService", "[heartbeat] checkGiftEnable disableGift");
                    localg.uEJ = false;
                    localg.uDA &= 0xFFFFFF7F;
                    localg.uEI = 0;
                    continue;
                    localObject2 = null;
                    continue;
                    localObject2 = null;
                    continue;
                    localObject2 = null;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static com.tencent.mm.plugin.finder.live.view.i dfU()
  {
    return ufF;
  }
  
  public static com.tencent.mm.live.core.b.a dfV()
  {
    return ujv;
  }
  
  public static int dfW()
  {
    return ujw;
  }
  
  public static HashMap<Integer, com.tencent.mm.live.core.d.a.a> dfX()
  {
    return filterMap;
  }
  
  public static com.tencent.mm.plugin.finder.live.viewmodel.d dfY()
  {
    return ujy;
  }
  
  public static com.tencent.mm.plugin.finder.live.viewmodel.g dfZ()
  {
    return ujz;
  }
  
  public static void dfk()
  {
    AppMethodBeat.i(246246);
    Object localObject = FinderLiveMiniProProxyUI.ubz;
    int i = FinderLiveMiniProProxyUI.def();
    if (!Util.isTopApplication(MMApplicationContext.getContext()))
    {
      localObject = FinderLiveMiniProProxyUI.ubz;
      i = FinderLiveMiniProProxyUI.deg();
    }
    localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    ab((Context)localObject, i);
    AppMethodBeat.o(246246);
  }
  
  public static int dga()
  {
    return ujA;
  }
  
  public static int dgb()
  {
    return ujB;
  }
  
  public static com.tencent.mm.bw.b dgc()
  {
    return ujD;
  }
  
  public static int dgd()
  {
    return ujE;
  }
  
  public static int dge()
  {
    return ujF;
  }
  
  private static void dgf()
  {
    AppMethodBeat.i(246228);
    ujK = new w("heartBeatLooper", hIe, 2);
    ujL = new w("keepLiveLooper", hId, 2);
    ujM = new w("refreshMicLooper", ujJ, 2);
    AppMethodBeat.o(246228);
  }
  
  private static void dgg()
  {
    AppMethodBeat.i(246229);
    Log.i("Finder.FinderLiveService", "setupBeautyAndFilterConfig");
    i = -1;
    j = -1;
    int m = -1;
    int i1 = -1;
    i3 = -1;
    i7 = -1;
    i5 = -1;
    Object localObject1 = e.e.hxP;
    int i10 = e.e.aCF();
    localObject1 = com.tencent.mm.live.core.d.a.hEN;
    localObject1 = com.tencent.mm.live.core.d.a.aEU();
    Object localObject2 = e.e.hxP;
    localObject1 = (String)((HashMap)localObject1).get(Integer.valueOf(e.e.aCF()));
    if (localObject1 == null)
    {
      localObject1 = "";
      for (;;)
      {
        p.g(localObject1, "LiveFilterUtil.filterCac…IVE_FILTER_DEFAULT] ?: \"\"");
        Object localObject4 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sny, "{\"skin_smooth\":50,\"eye_morph\":10,\"face_morph\":30,\"skin_bright\":30,\"eye_bright\":20,\"filter\":40,\"rosy\":30,\"filterKey\":0}");
        k = i5;
        n = i7;
        i2 = i3;
        i4 = i1;
        int i6 = m;
        i8 = j;
        i9 = i;
        try
        {
          localObject2 = new com.tencent.mm.ab.i((String)localObject4);
          k = i5;
          n = i7;
          i2 = i3;
          i4 = i1;
          i6 = m;
          i8 = j;
          i9 = i;
          i = ((com.tencent.mm.ab.i)localObject2).getInt("skin_smooth");
          k = i5;
          n = i7;
          i2 = i3;
          i4 = i1;
          i6 = m;
          i8 = j;
          i9 = i;
          j = ((com.tencent.mm.ab.i)localObject2).getInt("eye_morph");
          k = i5;
          n = i7;
          i2 = i3;
          i4 = i1;
          i6 = m;
          i8 = j;
          i9 = i;
          m = ((com.tencent.mm.ab.i)localObject2).getInt("face_morph");
          k = i5;
          n = i7;
          i2 = i3;
          i4 = i1;
          i6 = m;
          i8 = j;
          i9 = i;
          i1 = ((com.tencent.mm.ab.i)localObject2).getInt("eye_bright");
          k = i5;
          n = i7;
          i2 = i3;
          i4 = i1;
          i6 = m;
          i8 = j;
          i9 = i;
          i3 = ((com.tencent.mm.ab.i)localObject2).getInt("skin_bright");
          k = i5;
          n = i7;
          i2 = i3;
          i4 = i1;
          i6 = m;
          i8 = j;
          i9 = i;
          i5 = ((com.tencent.mm.ab.i)localObject2).getInt("filter");
          k = i5;
          n = i7;
          i2 = i3;
          i4 = i1;
          i6 = m;
          i8 = j;
          i9 = i;
          i7 = ((com.tencent.mm.ab.i)localObject2).getInt("rosy");
          k = i5;
          n = i7;
          i2 = i3;
          i4 = i1;
          i6 = m;
          i8 = j;
          i9 = i;
          int i11 = ((com.tencent.mm.ab.i)localObject2).getInt("filterKey");
          n = i11;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              localObject2 = com.tencent.mm.live.core.d.a.hEN;
              localObject2 = (String)com.tencent.mm.live.core.d.a.aEU().get(Integer.valueOf(n));
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              i9 = i;
              i8 = j;
              k = i7;
              j = i5;
              i = n;
              Log.i("Finder.FinderLiveService", "expt beautyConfig:[" + i9 + ", " + i8 + ", " + m + ", " + i3 + ", " + i1 + ',' + k + ", " + j + ", " + (String)localObject1 + ", " + i + "] exptConfig:" + (String)localObject4);
              ujw = j;
              localObject2 = new com.tencent.mm.live.core.b.a();
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject2).hDh;
              Object localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCh()), Integer.valueOf(i9));
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject2).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCi()), Integer.valueOf(m));
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject2).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCl()), Integer.valueOf(i8));
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject2).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCj()), Integer.valueOf(i3));
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject2).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCm()), Integer.valueOf(i1));
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject2).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCk()), Integer.valueOf(k));
              ujv = (com.tencent.mm.live.core.b.a)localObject2;
              localObject5 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderLiveConfigStorage().dxK();
              localObject4 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderLiveConfigStorage().dxL();
              Object localObject6 = new StringBuilder("local beautyConfig:[");
              if (localObject5 == null) {
                continue;
              }
              localObject2 = Integer.valueOf(((cir)localObject5).MnF);
              localObject6 = ((StringBuilder)localObject6).append(localObject2).append(", ");
              if (localObject5 == null) {
                continue;
              }
              localObject2 = Integer.valueOf(((cir)localObject5).hDc);
              localObject6 = ((StringBuilder)localObject6).append(localObject2).append(", ");
              if (localObject5 == null) {
                continue;
              }
              localObject2 = Integer.valueOf(((cir)localObject5).hDd);
              localObject6 = ((StringBuilder)localObject6).append(localObject2).append(", ");
              if (localObject5 == null) {
                continue;
              }
              localObject2 = Integer.valueOf(((cir)localObject5).hDe);
              localObject6 = ((StringBuilder)localObject6).append(localObject2).append(", ");
              if (localObject5 == null) {
                continue;
              }
              localObject2 = Integer.valueOf(((cir)localObject5).hDf);
              localObject6 = ((StringBuilder)localObject6).append(localObject2).append(", ");
              if (localObject5 == null) {
                continue;
              }
              localObject2 = Integer.valueOf(((cir)localObject5).hDg);
              localObject6 = ((StringBuilder)localObject6).append(localObject2).append(", ");
              if (localObject4 == null) {
                continue;
              }
              localObject2 = Integer.valueOf(((ciu)localObject4).key);
              localObject6 = ((StringBuilder)localObject6).append(localObject2).append(", ");
              if (localObject4 == null) {
                continue;
              }
              localObject2 = Integer.valueOf(((ciu)localObject4).value);
              Log.i("Finder.FinderLiveService", localObject2 + ']');
              n = i9;
              if (i9 != -1)
              {
                n = i9;
                if (localObject5 != null) {
                  n = ((cir)localObject5).MnF;
                }
              }
              i2 = i8;
              if (i8 != -1)
              {
                i2 = i8;
                if (localObject5 != null) {
                  i2 = ((cir)localObject5).hDc;
                }
              }
              i4 = m;
              if (m != -1)
              {
                i4 = m;
                if (localObject5 != null) {
                  i4 = ((cir)localObject5).hDd;
                }
              }
              m = i1;
              if (i1 != -1)
              {
                m = i1;
                if (localObject5 != null) {
                  m = ((cir)localObject5).hDf;
                }
              }
              i1 = i3;
              if (i3 != -1)
              {
                i1 = i3;
                if (localObject5 != null) {
                  i1 = ((cir)localObject5).hDe;
                }
              }
              i3 = k;
              if (k != -1)
              {
                i3 = k;
                if (localObject5 != null) {
                  i3 = ((cir)localObject5).hDg;
                }
              }
              localObject2 = localObject1;
              i5 = i;
              k = j;
              if (j != -1)
              {
                localObject2 = localObject1;
                i5 = i;
                k = j;
                if (localObject4 != null)
                {
                  localObject2 = com.tencent.mm.live.core.d.a.hEN;
                  localObject2 = localObject1;
                  i5 = i;
                  k = j;
                  if (com.tencent.mm.vfs.s.YS((String)com.tencent.mm.live.core.d.a.aEU().get(Integer.valueOf(((ciu)localObject4).key))))
                  {
                    i5 = ((ciu)localObject4).key;
                    localObject1 = com.tencent.mm.live.core.d.a.hEN;
                    localObject2 = (String)com.tencent.mm.live.core.d.a.aEU().get(Integer.valueOf(((ciu)localObject4).key));
                    localObject1 = localObject2;
                    if (localObject2 == null) {
                      localObject1 = "";
                    }
                    k = ((ciu)localObject4).value;
                    localObject2 = localObject1;
                  }
                }
              }
              Log.i("Finder.FinderLiveService", "final beautyConfig:[" + n + ", " + i2 + ", " + i4 + ", " + i1 + ", " + m + ", " + i3 + ", " + k + ", " + (String)localObject2 + ", " + i5 + ']');
              localObject1 = new com.tencent.mm.live.core.b.a();
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject1).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCh()), Integer.valueOf(n));
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject1).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCi()), Integer.valueOf(i4));
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject1).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCl()), Integer.valueOf(i2));
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject1).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCj()), Integer.valueOf(i1));
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject1).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCm()), Integer.valueOf(m));
              localObject4 = (Map)((com.tencent.mm.live.core.b.a)localObject1).hDh;
              localObject5 = e.c.hxm;
              ((Map)localObject4).put(Integer.valueOf(e.c.aCk()), Integer.valueOf(i3));
              hDV = (com.tencent.mm.live.core.b.a)localObject1;
              hDW = new com.tencent.mm.live.core.b.b(i5, (String)localObject2, k);
              filterMap.clear();
              localObject1 = com.tencent.mm.live.core.d.a.hEN;
              localObject1 = ((Map)com.tencent.mm.live.core.d.a.aEU()).entrySet().iterator();
              if (!((Iterator)localObject1).hasNext()) {
                continue;
              }
              localObject2 = (Map.Entry)((Iterator)localObject1).next();
              localObject4 = (Map)filterMap;
              localObject5 = ((Map.Entry)localObject2).getKey();
              i = ((Number)((Map.Entry)localObject2).getKey()).intValue();
              localObject6 = (String)((Map.Entry)localObject2).getValue();
              com.tencent.mm.live.core.d.a locala = com.tencent.mm.live.core.d.a.hEN;
              ((Map)localObject4).put(localObject5, new com.tencent.mm.live.core.d.a.a(i, (String)localObject6, com.tencent.mm.live.core.d.a.qM(((Number)((Map.Entry)localObject2).getKey()).intValue()), ujw));
              continue;
              localException1 = localException1;
              i = i10;
              m = i6;
              i1 = i4;
              i4 = i;
            }
            catch (Exception localException2)
            {
              Object localObject3;
              i4 = n;
              k = i5;
              n = i7;
              i2 = i3;
              i8 = j;
              i9 = i;
              continue;
            }
            Log.w("Finder.FinderLiveService", "parse clicfg_live_beauty_config fail. " + localException1.getMessage());
            i = i4;
            j = k;
            k = n;
            i3 = i2;
            continue;
            localObject3 = null;
            continue;
            localObject3 = null;
            continue;
            localObject3 = null;
            continue;
            localObject3 = null;
            continue;
            localObject3 = null;
            continue;
            localObject3 = null;
            continue;
            localObject3 = null;
            continue;
            localObject3 = null;
          }
          AppMethodBeat.o(246229);
          return;
        }
      }
    }
  }
  
  public static void dgi()
  {
    AppMethodBeat.i(246232);
    w localw = ujM;
    if (localw != null)
    {
      localw.dgE();
      AppMethodBeat.o(246232);
      return;
    }
    AppMethodBeat.o(246232);
  }
  
  public static void dgj()
  {
    AppMethodBeat.i(246241);
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = ujz;
    if (localg != null)
    {
      Log.i("Finder.FinderLiveService", "receive logoutEvent, liveId:" + localg.liveInfo.liveId);
      ujN.nn(true);
      AppMethodBeat.o(246241);
      return;
    }
    AppMethodBeat.o(246241);
  }
  
  public static int dgk()
  {
    AppMethodBeat.i(246251);
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.c.dwA().value()).intValue();
    Log.i("Finder.FinderLiveService", "mirroMode:".concat(String.valueOf(i)));
    AppMethodBeat.o(246251);
    return i;
  }
  
  public static boolean dgl()
  {
    boolean bool2 = true;
    AppMethodBeat.i(246252);
    Object localObject = ujz;
    boolean bool1;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).hIy;
      if (localObject != null)
      {
        localObject = ujz;
        if (localObject == null) {
          break label125;
        }
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).hIy;
        if (localObject == null) {
          break label125;
        }
        localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
        if ((localObject == null) || (((com.tencent.mm.live.core.core.b.d)localObject).hzh != true)) {
          break label125;
        }
      }
      localObject = ujz;
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).hIy;
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
          bool1 = bool2;
          if (localObject != null) {
            bool1 = ((com.tencent.mm.live.core.core.b.d)localObject).hzk;
          }
        }
      }
      Log.i("Finder.FinderLiveService", "use front camera, finalMirror:".concat(String.valueOf(bool1)));
    }
    for (;;)
    {
      AppMethodBeat.o(246252);
      return bool1;
      localObject = null;
      break;
      label125:
      bool1 = false;
      Log.i("Finder.FinderLiveService", "use back camera, finalMirror:false");
    }
  }
  
  public static boolean dgm()
  {
    AppMethodBeat.i(246253);
    Object localObject = Build.MODEL;
    p.g(localObject, "Build.MODEL");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(246253);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).toLowerCase();
    p.g(localObject, "(this as java.lang.String).toLowerCase()");
    if (!kotlin.n.n.a((CharSequence)uju, (CharSequence)localObject, false)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.FinderLiveService", "enableDynamicVideoParam notSupportDynamicVideoParamDevice:" + uju + " model:" + (String)localObject + " result:" + bool);
      AppMethodBeat.o(246253);
      return bool;
    }
  }
  
  private static boolean e(Long paramLong)
  {
    AppMethodBeat.i(246243);
    Object localObject = ujz;
    long l;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo;
      if (localObject != null)
      {
        l = ((awe)localObject).liveId;
        if ((l != 0L) && (paramLong != null)) {
          break label51;
        }
      }
    }
    label51:
    while (l != paramLong.longValue())
    {
      AppMethodBeat.o(246243);
      return true;
      l = 0L;
      break;
    }
    AppMethodBeat.o(246243);
    return false;
  }
  
  private static void f(com.tencent.mm.plugin.finder.live.viewmodel.g paramg)
  {
    AppMethodBeat.i(246217);
    Log.i("Finder.FinderLiveService", "write curLiveRoomData to :".concat(String.valueOf(paramg)));
    ujz = paramg;
    AppMethodBeat.o(246217);
  }
  
  public static s getFinderLiveAssistant()
  {
    return ujx;
  }
  
  public static boolean isAnchorLiving()
  {
    AppMethodBeat.i(246249);
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = ujz;
    if ((localg != null) && (localg.liveInfo.liveId != 0L) && (!localg.djl()) && (dMz))
    {
      AppMethodBeat.o(246249);
      return true;
    }
    AppMethodBeat.o(246249);
    return false;
  }
  
  public static boolean isVisitorLiving()
  {
    AppMethodBeat.i(246250);
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = ujz;
    if ((localg != null) && (localg.liveInfo.liveId != 0L) && (!localg.djl()) && (!dMz))
    {
      AppMethodBeat.o(246250);
      return true;
    }
    AppMethodBeat.o(246250);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, FinderBaseLivePluginLayout paramFinderBaseLivePluginLayout, int paramInt)
  {
    AppMethodBeat.i(246234);
    p.h(paramg, "liveData");
    p.h(paramFinderBaseLivePluginLayout, "finderBaseLayout");
    Log.i("Finder.FinderLiveService", "bindCurLive " + paramg + " curLiveRoomData:" + ujz);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sdB, "mp1718");
    p.g(localObject, "MMKernel.service(IExptSe…ch_video_param, \"mp1718\")");
    if (localObject == null)
    {
      paramg = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(246234);
      throw paramg;
    }
    localObject = ((String)localObject).toLowerCase();
    p.g(localObject, "(this as java.lang.String).toLowerCase()");
    uju = (String)localObject;
    ujs = paramFinderBaseLivePluginLayout;
    ujx = (s)new b(paramFinderBaseLivePluginLayout);
    boolean bool;
    if (ujz == null)
    {
      dgf();
      ujG.alive();
      hXn.alive();
      f(paramg);
      ujA = paramInt;
      if ((!(paramFinderBaseLivePluginLayout instanceof com.tencent.mm.plugin.finder.live.view.a)) && (!(paramFinderBaseLivePluginLayout instanceof com.tencent.mm.plugin.finder.live.view.c))) {
        break label341;
      }
      bool = true;
      dMz = bool;
      if (!bool) {
        break label367;
      }
      localObject = com.tencent.mm.plugin.finder.utils.m.vVH;
      if (com.tencent.mm.plugin.finder.utils.m.i(paramg)) {
        break label347;
      }
      localObject = com.tencent.mm.live.core.core.a.b.hyv;
      paramFinderBaseLivePluginLayout.getContext();
      paramFinderBaseLivePluginLayout = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.aDo();
    }
    for (;;)
    {
      hSS = paramFinderBaseLivePluginLayout;
      paramFinderBaseLivePluginLayout = MMApplicationContext.getContext();
      p.g(paramFinderBaseLivePluginLayout, "MMApplicationContext.getContext()");
      paramFinderBaseLivePluginLayout = new FinderLiveMiniView(paramFinderBaseLivePluginLayout);
      ujt = paramFinderBaseLivePluginLayout;
      paramFinderBaseLivePluginLayout.a(hJe, ujI);
      paramFinderBaseLivePluginLayout = ujt;
      if (paramFinderBaseLivePluginLayout != null) {
        paramFinderBaseLivePluginLayout.bi(paramg.hwd, dMz);
      }
      paramg = hSS;
      if (paramg != null) {
        paramg.a((AbsLiveMiniView)ujt);
      }
      paramg = hSS;
      if (paramg != null) {
        paramg.hAx = ((com.tencent.mm.live.core.core.c)this);
      }
      if (dMz) {
        dgg();
      }
      AppMethodBeat.o(246234);
      return;
      label341:
      bool = false;
      break;
      label347:
      localObject = com.tencent.mm.live.core.core.c.a.hAj;
      paramFinderBaseLivePluginLayout.getContext();
      paramFinderBaseLivePluginLayout = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.a.a.aDw();
      continue;
      label367:
      localObject = com.tencent.mm.live.core.core.d.b.hCo;
      paramFinderBaseLivePluginLayout.getContext();
      paramFinderBaseLivePluginLayout = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.d.b.a.aEf();
    }
  }
  
  public final void callback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(246244);
    FinderBaseLivePluginLayout localFinderBaseLivePluginLayout = ujs;
    if (localFinderBaseLivePluginLayout != null)
    {
      localFinderBaseLivePluginLayout.onLiveEventCallback(paramInt, paramBundle);
      AppMethodBeat.o(246244);
      return;
    }
    AppMethodBeat.o(246244);
  }
  
  public final void nn(boolean paramBoolean)
  {
    AppMethodBeat.i(246239);
    Object localObject = hSS;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a)localObject).aBW();
    }
    localObject = ujs;
    if (localObject != null) {
      ((FinderBaseLivePluginLayout)localObject).finish();
    }
    a(paramBoolean, false, null, 6);
    AppMethodBeat.o(246239);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$checkDeviceLsn$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLiveStateActionEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<hx>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean>
  {
    b(aut paramaut)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean>
  {
    c(aut paramaut)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$doGetLiveMsg$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "plugin-finder_release"})
  public static final class d
    implements h.a
  {
    public final void a(int paramInt1, int paramInt2, ass paramass)
    {
      long l2 = 0L;
      AppMethodBeat.i(246189);
      p.h(paramass, "resp");
      boolean bool = o.a(o.ujN, paramInt2, paramInt1, paramass);
      Object localObject = o.ujN;
      localObject = o.dgn();
      if (localObject != null) {
        ((w)localObject).dgD();
      }
      long l1;
      if (bool)
      {
        localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
        paramInt1 = ((Number)com.tencent.mm.plugin.finder.storage.c.drI().value()).intValue();
        localObject = o.ujN;
        l2 = paramInt1;
        paramass = paramass.liveInfo;
        if (paramass != null) {}
        for (l1 = paramass.liveId;; l1 = 0L)
        {
          o.P(l2, l1);
          AppMethodBeat.o(246189);
          return;
        }
      }
      localObject = new StringBuilder("handleLiveMsgResp result false, will retry heartbeat delay 5000. localLiveId:");
      paramass = o.ujN;
      paramass = o.dfZ();
      if (paramass != null)
      {
        paramass = paramass.liveInfo;
        if (paramass == null) {}
      }
      for (paramass = Long.valueOf(paramass.liveId);; paramass = null)
      {
        Log.i("Finder.FinderLiveService", paramass);
        paramass = o.ujN;
        paramass = o.ujN;
        paramass = o.dfZ();
        l1 = l2;
        if (paramass != null)
        {
          paramass = paramass.liveInfo;
          l1 = l2;
          if (paramass != null) {
            l1 = paramass.liveId;
          }
        }
        o.P(5000L, l1);
        AppMethodBeat.o(246189);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$doKeepLive$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.plugin.finder.live.model.cgi.i.a
  {
    public final void a(int paramInt1, int paramInt2, String paramString, auf paramauf)
    {
      AppMethodBeat.i(246190);
      p.h(paramauf, "resp");
      paramString = o.ujN;
      boolean bool = o.b(paramInt2, paramInt1, paramauf);
      paramString = o.ujN;
      paramString = o.dgo();
      if (paramString != null) {
        paramString.dgD();
      }
      if (bool)
      {
        paramString = o.ujN;
        paramString = o.dfZ();
        if (paramString == null) {
          break label106;
        }
        paramString = paramString.hIv;
        if (paramString == null) {
          break label106;
        }
      }
      label106:
      for (long l = paramString.Mor;; l = 0L)
      {
        l = kotlin.k.j.aM((l - 60L) * 1000L, 60000L);
        paramString = o.ujN;
        o.EJ(l);
        AppMethodBeat.o(246190);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$doRefreshMic$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "plugin-finder_release"})
  public static final class f
    implements u.a
  {
    public final void c(int paramInt1, int paramInt2, awz paramawz)
    {
      AppMethodBeat.i(246191);
      p.h(paramawz, "resp");
      o localo = o.ujN;
      boolean bool = o.b(paramInt2, paramInt1, paramawz);
      paramawz = o.ujN;
      paramawz = o.dgp();
      if (paramawz != null) {
        paramawz.dgD();
      }
      if (bool)
      {
        paramawz = o.ujN;
        paramawz = o.dfZ();
        if (paramawz == null) {
          break label105;
        }
        paramawz = paramawz.hIv;
        if (paramawz == null) {
          break label105;
        }
      }
      label105:
      for (long l = paramawz.Mor;; l = 0L)
      {
        l = kotlin.k.j.aM((l - 60L) * 1000L, 60000L);
        paramawz = o.ujN;
        o.EI(l);
        AppMethodBeat.o(246191);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    public static final g ujP;
    
    static
    {
      AppMethodBeat.i(246193);
      ujP = new g();
      AppMethodBeat.o(246193);
    }
    
    public final void run()
    {
      AppMethodBeat.i(246192);
      o localo = o.ujN;
      o.dgu();
      AppMethodBeat.o(246192);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    h(int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    i(int paramInt1, int paramInt2, ass paramass)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    public static final j ujR;
    
    static
    {
      AppMethodBeat.i(246197);
      ujR = new j();
      AppMethodBeat.o(246197);
    }
    
    public final void run()
    {
      AppMethodBeat.i(246196);
      o localo = o.ujN;
      o.dgv();
      AppMethodBeat.o(246196);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$launchMiniProgram$1", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "onAppBrandPreconditionError", "", "onAppBrandProcessDied", "onAppBrandUIEnter", "onAppBrandUIExit", "isFinish", "", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.plugin.appbrand.api.i
  {
    public final void bud()
    {
      AppMethodBeat.i(246198);
      StringBuilder localStringBuilder = new StringBuilder("live:");
      Object localObject = o.ujN;
      localObject = o.dfZ();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo;
        if (localObject == null) {}
      }
      for (localObject = Long.valueOf(((awe)localObject).liveId);; localObject = null)
      {
        Log.i("Finder.FinderLiveService", localObject + " luanchMiniProgram error!");
        localObject = o.ujN;
        localObject = o.dfZ();
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uEr = false;
        }
        localObject = o.ujN;
        o.dfk();
        AppMethodBeat.o(246198);
        return;
      }
    }
    
    public final void bue()
    {
      AppMethodBeat.i(246199);
      StringBuilder localStringBuilder = new StringBuilder("live:");
      Object localObject = o.ujN;
      localObject = o.dfZ();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo;
        if (localObject == null) {}
      }
      for (localObject = Long.valueOf(((awe)localObject).liveId);; localObject = null)
      {
        Log.i("Finder.FinderLiveService", localObject + " onAppBrandUIEnter!");
        localObject = o.ujN;
        localObject = o.dfZ();
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uEr = true;
        AppMethodBeat.o(246199);
        return;
      }
      AppMethodBeat.o(246199);
    }
    
    public final void buf()
    {
      AppMethodBeat.i(246201);
      StringBuilder localStringBuilder = new StringBuilder("live:");
      Object localObject = o.ujN;
      localObject = o.dfZ();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo;
        if (localObject == null) {}
      }
      for (localObject = Long.valueOf(((awe)localObject).liveId);; localObject = null)
      {
        Log.i("Finder.FinderLiveService", localObject + " onAppBrandProcessDied!");
        localObject = o.ujN;
        localObject = o.dfZ();
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uEr = false;
        }
        localObject = o.ujN;
        o.dfk();
        AppMethodBeat.o(246201);
        return;
      }
    }
    
    public final void gC(boolean paramBoolean)
    {
      Object localObject2 = null;
      AppMethodBeat.i(246200);
      Object localObject3 = new StringBuilder("live:");
      Object localObject1 = o.ujN;
      localObject1 = o.dfZ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo;
        if (localObject1 == null) {}
      }
      for (localObject1 = Long.valueOf(((awe)localObject1).liveId);; localObject1 = null)
      {
        Log.i("Finder.FinderLiveService", localObject1 + " onAppBrandUIExit!");
        localObject1 = o.ujN;
        localObject1 = o.dfZ();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEr = false;
        }
        localObject1 = com.tencent.mm.plugin.finder.live.h.ufY;
        localObject1 = o.ujN;
        localObject3 = o.dfZ();
        localObject1 = y.vXH;
        localObject1 = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g localg = o.dfZ();
        localObject1 = localObject2;
        if (localg != null) {
          localObject1 = localg.uEl;
        }
        com.tencent.mm.plugin.finder.live.h.a((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3, y.c((awc)localObject1));
        AppMethodBeat.o(246200);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    public static final l ujS;
    
    static
    {
      AppMethodBeat.i(246203);
      ujS = new l();
      AppMethodBeat.o(246203);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(246202);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new StringBuilder("miniWindowClickListener onClick ");
      localObject = o.ujN;
      Log.i("Finder.FinderLiveService", o.dfY());
      paramView = o.ujN;
      paramView = o.dgq();
      if (paramView != null) {
        paramView.aBU();
      }
      paramView = o.ujN;
      boolean bool;
      if (o.dgs())
      {
        paramView = o.ujN;
        if ((o.dgq() instanceof com.tencent.mm.live.core.core.a.b))
        {
          paramView = FinderLiveAnchorWithoutAffinityUI.class;
          localObject = new Intent(MMApplicationContext.getContext(), paramView);
          ((Intent)localObject).putExtra("route_to_maximize", true);
          ((Intent)localObject).addFlags(872415232);
          paramView = MMApplicationContext.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView = com.tencent.mm.live.core.mini.a.hCD;
          paramView = a.b.hCF;
          paramView = a.b.aEi();
          Log.d("MicroMsg.LiveFloatBallHelper", "clickFloatBall");
          paramView.oWE.oWs.opType = 3;
          ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).m(paramView.oWE);
          paramView = o.ujN;
          paramView = o.dgt();
          if (paramView == null) {
            break label337;
          }
          bool = paramView.dMz;
          label260:
          if (!bool) {
            break label342;
          }
          paramView = k.vkd;
          k.dpl().vmk = false;
          paramView = k.vkd;
          k.dpl().vml = true;
          paramView = k.vkd;
          k.a(s.c.vmQ, String.valueOf(s.r.voW.type));
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246202);
        return;
        paramView = OccupyFinderUI13.class;
        break;
        paramView = FinderLiveVisitorWithoutAffinityUI.class;
        break;
        label337:
        bool = false;
        break label260;
        label342:
        paramView = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(false, s.r.voW);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    public static final m ujT;
    
    static
    {
      AppMethodBeat.i(246205);
      ujT = new m();
      AppMethodBeat.o(246205);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(246204);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      boolean bool = Util.isTopApplication(MMApplicationContext.getContext());
      localObject = new StringBuilder("mini window close,is top applicaton:").append(bool).append(",is shopping in MiniPro:");
      paramView = o.ujN;
      paramView = o.dfZ();
      if (paramView != null) {}
      for (paramView = Boolean.valueOf(paramView.uEr);; paramView = null)
      {
        paramView = ((StringBuilder)localObject).append(paramView).append(",isAnchor:");
        localObject = o.ujN;
        Log.i("Finder.FinderLiveService", o.dgs());
        paramView = o.ujN;
        if (o.dgs()) {
          break;
        }
        paramView = o.ujN;
        paramView = o.dfZ();
        if ((paramView == null) || (paramView.uEr != true)) {
          break;
        }
        paramView = o.ujN;
        paramView = o.dgq();
        if (paramView != null) {
          paramView.hAq.aEj();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246204);
        return;
      }
      o.ujN.nn(bool);
      paramView = o.ujN;
      paramView = o.dgt();
      if (paramView != null) {}
      for (bool = paramView.dMz;; bool = false)
      {
        if (!bool) {
          com.tencent.mm.plugin.finder.report.live.m.vli.a(s.at.vrJ);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246204);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$multiTalkActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MultiTalkActionEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class n
    extends IListener<mu>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    public static final o ujU;
    
    static
    {
      AppMethodBeat.i(246208);
      ujU = new o();
      AppMethodBeat.o(246208);
    }
    
    public final void run()
    {
      AppMethodBeat.i(246207);
      o localo = o.ujN;
      o.dgw();
      AppMethodBeat.o(246207);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$release$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder_release"})
  public static final class p
    implements d.a
  {
    public final void onCgiBack(int paramInt1, int paramInt2, String paramString, avm paramavm)
    {
      AppMethodBeat.i(246209);
      p.h(paramavm, "resp");
      Log.i("Finder.FinderLiveService", "closeLinkMic when release live. errCode:" + paramInt2 + ", errType:" + paramInt1);
      AppMethodBeat.o(246209);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$release$3", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class q
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(246210);
      Log.i("Finder.FinderLiveService", "on exitRoom finish");
      AppMethodBeat.o(246210);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final r ujV;
    
    static
    {
      AppMethodBeat.i(246214);
      ujV = new r();
      AppMethodBeat.o(246214);
    }
    
    r()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$voipCallEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class s
    extends IListener<zj>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.o
 * JD-Core Version:    0.7.0.1
 */