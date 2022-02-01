package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.Intent;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.ik;
import com.tencent.mm.f.a.nl;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.core.e.e;
import com.tencent.mm.live.core.core.e.f;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.live.MiniProgramHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.finder.live.component.aa;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.report.s.bh;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.report.s.v;
import com.tencent.mm.plugin.finder.live.v;
import com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.plugin.finder.utils.ao;
import com.tencent.mm.plugin.finder.utils.ap;
import com.tencent.mm.plugin.finder.utils.ap.a;
import com.tencent.mm.plugin.finder.utils.ap.c;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bas;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
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
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "Lcom/tencent/liteav/audio/TXAudioEffectManager$TXMusicPlayObserver;", "()V", "COMMENT_LIST_SIZE_LIMIT", "", "getCOMMENT_LIST_SIZE_LIMIT", "()I", "setCOMMENT_LIST_SIZE_LIMIT", "(I)V", "INVALID_VISITOR_CORE_KEY", "", "TAG", "", "activateMicLooper", "Lcom/tencent/mm/plugin/finder/live/model/SingleTaskLooper;", "activateMicTask", "Ljava/lang/Runnable;", "anchorVerifyManager", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorVerifyManager;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "battleEndDelayTask", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$BattleDismissTask;", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "getBeautyConfig", "()Lcom/tencent/mm/live/core/render/BeautyConfig;", "setBeautyConfig", "(Lcom/tencent/mm/live/core/render/BeautyConfig;)V", "checkDeviceLsn", "com/tencent/mm/plugin/finder/live/model/FinderLiveService$checkDeviceLsn$1", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$checkDeviceLsn$1;", "comboBatchSize", "getComboBatchSize", "setComboBatchSize", "comboBatchTimeoutMs", "getComboBatchTimeoutMs", "setComboBatchTimeoutMs", "value", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "curLiveContext", "getCurLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setCurLiveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "curLiveIndex", "getCurLiveIndex", "setCurLiveIndex", "curLiveLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getCurLiveLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "setCurLiveLayout", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "defaultFilterValue", "getDefaultFilterValue", "setDefaultFilterValue", "enableGetLiveMsgTest", "", "getEnableGetLiveMsgTest", "()Z", "setEnableGetLiveMsgTest", "(Z)V", "externalHelper", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveExternalHelper;", "filterAnchorExtFlag", "getFilterAnchorExtFlag", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "getFilterConfig", "()Lcom/tencent/mm/live/core/render/FilterConfig;", "setFilterConfig", "(Lcom/tencent/mm/live/core/render/FilterConfig;)V", "filterMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/live/core/util/LiveFilterUtil$FilterInfo;", "getFilterMap", "()Ljava/util/HashMap;", "setFilterMap", "(Ljava/util/HashMap;)V", "filterOutDatedJoinLiveResp", "getFilterOutDatedJoinLiveResp", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "setFinderLiveAssistant", "(Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;)V", "getMessageTask", "giftLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getGiftLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setGiftLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "heartBeatLooper", "heartBeatTimestamp", "isAnchor", "setAnchor", "keepAliveTask", "keepLiveLooper", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;)V", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "liveData", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;)V", "miniView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;", "miniWindowClickListener", "Landroid/view/View$OnClickListener;", "getMiniWindowClickListener", "()Landroid/view/View$OnClickListener;", "setMiniWindowClickListener", "(Landroid/view/View$OnClickListener;)V", "miniWindowCloseClickListener", "multiTalkActionListener", "Lcom/tencent/mm/sdk/event/IListener;", "multiTaskManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "getMultiTaskManager", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "setMultiTaskManager", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;)V", "notSupportDynamicVideoParamDevice", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "refreshMicLooper", "refreshMicTask", "voipCallEvent", "Lcom/tencent/mm/autogen/events/VoipEvent;", "activateMic", "", "delay", "anchorAliveExpiredByLiveExtFlag", "anchorCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "backToFinderLiveAnchorUIOnExternalLive", "context", "Landroid/content/Context;", "isFinish", "needRelaunchWeAppOnLiveFinished", "bindCurLayout", "finderBaseLayout", "bindCurLive", "curIndex", "liveMode", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "bindMiniGameLive", "bindNormalLive", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "callLiveExperimentalAPI", "jsStr", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkAcceptMicType", "micType", "checkAnchorAlive", "curLiveData", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "checkAnchorStatus", "remoteAnchorStatus", "checkAnchorVerifyStateWhenLiveStart", "checkCookiesDeprecated", "errType", "errCode", "checkGiftEnable", "checkLayerShowInfo", "layerShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerShowInfo;", "checkLinkMicEnable", "checkLinkState", "remoteLiveAppMsg", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "checkLiveClose", "checkLiveExtFlag", "checkQosReport", "closeLive", "closeMiniProgram", "purpose", "controlLiveMiniWindowVisibility", "visible", "doActivateMic", "doGetLiveMsg", "doKeepLive", "doRefreshMic", "dumpBattlePlayerInfo", "info", "Lcom/tencent/mm/protocal/protobuf/PlayerInfo;", "enableAudioVolumeEvaluation", "interval", "enableCustomAudioCapture", "enable", "enableDynamicVideoParam", "enableGiftByLiveExtFlag", "enableLinkMicByLiveExtFlag", "enableMicExternalAudioFrame", "enablePublish", "enablePlayout", "enterRoom", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "externalEnterRoom", "Lkotlin/Function5;", "success", "errMsg", "extInfo", "externalPostResult", "result", "filterLiveMsg", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "Lkotlin/collections/ArrayList;", "remote", "typeList", "", "finishHeartBeatTask", "forceStopCurLive", "fullScreen", "getFinderLiveExternalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveExternalInfo;", "getFinderLiveMemberListInfo", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMemberListInfo;", "handleAppMsg", "appMsgList", "handleKeepAliveResp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "handleLiveMsgResp", "reqVisitorRoleType", "handleMsg", "remoteLiveMsg", "selfID", "selfFinderId", "handleRefreshMicResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "handleTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTemplateInfo;", "heartBeat", "liveId", "isAnchorLiving", "isGameAnchorLiving", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback$GameLivingStatus;", "appId", "isInvalidLiveId", "(Ljava/lang/Long;)Z", "isVisitorLiving", "keepAlive", "launchMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "liveFinish", "liveStart", "mirrorMode", "mixExternalAudioFrame", "audioBuffer", "", "sampleRate", "channel", "timestamp", "needMirror", "notifyMiniWindowStatusToExternal", "isShown", "notifyPlayStatus", "isComplete", "onAnchorVerificationRequired", "onComplete", "p0", "p1", "onPlayProgress", "p2", "onStart", "id", "pauseLive", "scene", "playMusic", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "pos", "forcePlay", "playNext", "postExternalLive", "processLiveAudioSdkParam", "audioSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkAudioParams;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveVideoSdkParam", "videoSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkVideoParams;", "refreshMic", "registerExternalLiveCallback", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "release", "isTopApplication", "miniWinPermission", "(ZZLjava/lang/Boolean;)V", "releaseWithMiniWindow", "removeBattleEndDelayTimer", "requestStopMic", "requestStopPkMic", "resumeLive", "sendExternalAudioData", "sendExternalLiveData", "eglContext", "Landroid/opengl/EGLContext;", "texId", "width", "height", "setAnchorPauseMiniView", "setCustomResolution", "isVertical", "setVoiceCaptureVolume", "volume", "setupBeautyAndFilterConfig", "setupSdkParam", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "setupSingleTaskLooper", "share2Friend", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "share2Sns", "showMiniWindow", "showMiniWindowWithoutPermissionCheck", "startBattleEndDelayTimer", "battleId", "startLinkMic", "startLocalAudio", "stopActivateMic", "stopRefreshMic", "transferLiveData", "livecData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "transferState", "roomData", "event", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "unregisterExternalLiveCallback", "updateBeautyConfig", "updateSdkParam", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "validCore", "visitorCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "visitorLiveStart", "BattleDismissTask", "HeartBeatGuardTask", "KeepAliveGuardTask", "plugin-finder_release"})
public final class ah
  implements TXAudioEffectManager.TXMusicPlayObserver, com.tencent.mm.live.core.core.c
{
  public static boolean fFE = false;
  private static HashMap<Integer, com.tencent.mm.live.core.d.a.a> filterMap;
  public static com.tencent.mm.live.core.core.trtc.a kHp;
  private static final com.tencent.mm.model.d kKI;
  private static final IListener<?> kLS;
  private static final PhoneStateListener kiE;
  private static com.tencent.mm.live.core.b.a knC;
  private static com.tencent.mm.live.core.b.b knD;
  private static final Runnable kvx;
  private static final Runnable kvy;
  private static View.OnClickListener kwy;
  private static com.tencent.mm.plugin.finder.live.view.e xWd;
  private static an ybM;
  private static com.tencent.mm.plugin.finder.live.model.context.a yds;
  public static com.tencent.mm.plugin.finder.live.view.a ydt;
  private static as yhA;
  private static final long yhB = 1L;
  public static final ah yhC;
  private static FinderLiveMiniView yhc;
  private static k yhd;
  private static c yhe;
  private static String yhf;
  private static int yhg;
  private static com.tencent.mm.plugin.finder.live.viewmodel.data.g yhh;
  private static int yhi;
  private static int yhj;
  private static long yhk;
  private static com.tencent.mm.cd.b yhl;
  private static int yhm;
  private static int yhn;
  public static boolean yho;
  private static final boolean yhp;
  private static final boolean yhq;
  private static a yhr;
  private static final IListener<aaq> yhs;
  private static final e yht;
  private static final View.OnClickListener yhu;
  private static final Runnable yhv;
  private static final Runnable yhw;
  public static as yhx;
  private static as yhy;
  private static as yhz;
  
  static
  {
    boolean bool2 = true;
    AppMethodBeat.i(283420);
    yhC = new ah();
    yhd = new k();
    yhf = "";
    kKI = com.tencent.mm.model.d.bcs();
    yhg = 40;
    filterMap = new HashMap();
    yhj = 1000;
    yhm = -1;
    yhn = -1;
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.imy().aSr()).intValue() == 0)
    {
      bool1 = true;
      yho = bool1;
      locala = com.tencent.c.a.a.a.a.a.Zlt;
      if (((Number)com.tencent.c.a.a.a.a.a.imz().aSr()).intValue() != 0) {
        break label270;
      }
      bool1 = true;
      label115:
      yhp = bool1;
      locala = com.tencent.c.a.a.a.a.a.Zlt;
      if (((Number)com.tencent.c.a.a.a.a.a.ing().aSr()).intValue() != 0) {
        break label275;
      }
    }
    label270:
    label275:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      yhq = bool1;
      yhs = (IListener)new ag();
      kLS = (IListener)new t();
      yht = new e();
      kwy = (View.OnClickListener)r.yhN;
      yhu = (View.OnClickListener)s.yhO;
      kiE = (PhoneStateListener)new w();
      kvy = (Runnable)n.yhK;
      kvx = (Runnable)q.yhM;
      yhv = (Runnable)x.yhR;
      yhw = (Runnable)d.yhE;
      yht.alive();
      yhB = 1L;
      AppMethodBeat.o(283420);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label115;
    }
  }
  
  public static void Ll(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(283352);
    StringBuilder localStringBuilder = new StringBuilder("refreshMic delay:").append(paramLong).append(" curLive:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
      if (localObject1 == null) {}
    }
    for (localObject1 = Long.valueOf(((bac)localObject1).liveId);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(" curLinkUser:");
      com.tencent.mm.plugin.finder.live.viewmodel.data.business.f localf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.zhl;
      }
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = yhz;
      if (localObject1 == null) {
        break;
      }
      ((as)localObject1).f(Long.valueOf(paramLong));
      AppMethodBeat.o(283352);
      return;
    }
    AppMethodBeat.o(283352);
  }
  
  public static void Lm(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(283354);
    StringBuilder localStringBuilder = new StringBuilder("activateMic delay:").append(paramLong).append(" curLive:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
      if (localObject1 == null) {}
    }
    for (localObject1 = Long.valueOf(((bac)localObject1).liveId);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(" curLinkUser:");
      com.tencent.mm.plugin.finder.live.viewmodel.data.business.f localf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.zhl;
      }
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = yhA;
      if (localObject1 == null) {
        break;
      }
      ((as)localObject1).f(Long.valueOf(paramLong));
      AppMethodBeat.o(283354);
      return;
    }
    AppMethodBeat.o(283354);
  }
  
  public static void Ln(long paramLong)
  {
    AppMethodBeat.i(283357);
    StringBuilder localStringBuilder = new StringBuilder("keepAlive delay:").append(paramLong).append(" curLive:");
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).liveInfo;
      if (localObject == null) {}
    }
    for (localObject = Long.valueOf(((bac)localObject).liveId);; localObject = null)
    {
      Log.i("Finder.FinderLiveService", localObject);
      localObject = yhy;
      if (localObject != null) {
        ((as)localObject).dzV();
      }
      localObject = yhy;
      if (localObject == null) {
        break;
      }
      ((as)localObject).f(Long.valueOf(paramLong));
      AppMethodBeat.o(283357);
      return;
    }
    AppMethodBeat.o(283357);
  }
  
  public static void Lo(long paramLong)
  {
    AppMethodBeat.i(283364);
    kKI.bct();
    S(0L, paramLong);
    ac localac = ac.ygU;
    ac.dyY();
    AppMethodBeat.o(283364);
  }
  
  public static void M(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(283400);
    ??? = yhd.yeR;
    kotlin.g.b.p.j(???, "externalLiveCallbacks");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.c.a.a.a.a locala = (com.tencent.c.a.a.a.a)localIterator.next();
        Log.i(k.TAG, "onPostResult result:" + paramBoolean + " errType:" + paramInt);
        locala.V(paramBoolean, paramInt);
      }
    }
    kotlin.x localx = kotlin.x.aazN;
    AppMethodBeat.o(283400);
  }
  
  public static void Nt(int paramInt)
  {
    yhm = paramInt;
  }
  
  public static void Nu(int paramInt)
  {
    yhn = paramInt;
  }
  
  private static boolean Nv(int paramInt)
  {
    AppMethodBeat.i(283343);
    if ((paramInt != -1) && (com.tencent.mm.ae.d.dr(paramInt, 1)))
    {
      AppMethodBeat.o(283343);
      return true;
    }
    AppMethodBeat.o(283343);
    return false;
  }
  
  public static void S(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(283345);
    StringBuilder localStringBuilder = new StringBuilder("heartBeat liveId:").append(paramLong2).append(" delay:").append(paramLong1).append(" curLive:");
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).liveInfo;
      if (localObject == null) {}
    }
    for (localObject = Long.valueOf(((bac)localObject).liveId);; localObject = null)
    {
      Log.i("Finder.FinderLiveService", localObject + " liveId:" + paramLong2);
      if (paramLong2 <= 0L) {
        break label185;
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject == null) {
        break;
      }
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).liveInfo;
      if (localObject == null) {
        break;
      }
      if (((bac)localObject).liveId != paramLong2) {
        break label185;
      }
      localObject = yhx;
      if (localObject == null) {
        break label185;
      }
      ((as)localObject).f(Long.valueOf(paramLong1));
      AppMethodBeat.o(283345);
      return;
    }
    AppMethodBeat.o(283345);
    return;
    label185:
    AppMethodBeat.o(283345);
  }
  
  public static com.tencent.mm.plugin.finder.live.model.context.a a(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
  {
    Object localObject3 = null;
    AppMethodBeat.i(283361);
    com.tencent.mm.plugin.finder.live.model.context.a locala;
    com.tencent.mm.plugin.finder.live.viewmodel.data.business.c localc;
    Object localObject4;
    Object localObject2;
    int i;
    if (paramf != null)
    {
      locala = paramf.xWR;
      if (locala != null)
      {
        localc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
        if ((localc != null) && (localc.liveInfo.liveId == 0L))
        {
          localc.liveInfo.liveId = paramf.zey.getLiveId();
          localObject4 = localc.liveInfo;
          localObject2 = paramf.zey.aJl();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((bac)localObject4).kih = ((String)localObject1);
          localc.liveInfo.SLN = new bch();
          localObject1 = localc.liveInfo.SLN;
          if (localObject1 != null) {
            ((bch)localObject1).kmi = paramf.zey.aJm();
          }
          localc.xbk = paramf.zey.aJn();
          localObject2 = paramf.zey.getNonceId();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localc.setNonceId((String)localObject1);
          localObject2 = paramf.zey.getSessionBuffer();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localc.setSessionBuffer((String)localObject1);
          localObject1 = paramf.zey.aJs();
          kotlin.g.b.p.j(localObject1, "livecData.staticConfig.nicknameOption");
          kotlin.g.b.p.k(localObject1, "<set-?>");
          localc.kiv = ((String)localObject1);
          localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (localObject4 != null)
          {
            localObject1 = com.tencent.mm.plugin.finder.storage.data.e.AmW;
            localObject1 = e.a.MH(localc.xbk);
            if (localObject1 != null)
            {
              localObject2 = ((FinderItem)localObject1).getFinderObject();
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = new FinderObject();
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).zeZ = ((FinderObject)localObject1);
            localObject2 = paramf.zey.aJk();
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).aCW((String)localObject1);
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).desc = paramf.zey.getDesc();
            if (TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).dGE()))
            {
              localObject1 = paramf.zey.aJi();
              kotlin.g.b.p.j(localObject1, "livecData.staticConfig.thumbUrl");
              kotlin.g.b.p.k(localObject1, "<set-?>");
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).zfA = ((String)localObject1);
            }
            localObject1 = paramf.zey.aiL();
            kotlin.g.b.p.j(localObject1, "livecData.staticConfig.shareUserName");
            kotlin.g.b.p.k(localObject1, "<set-?>");
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).kit = ((String)localObject1);
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).kiu = paramf.zey.aJq();
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).zgF = paramf.zey.aJo();
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).xUD = paramf.xUD;
            localObject1 = aj.AGc;
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
            localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.axM(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).kig);
            if (localObject2 != null)
            {
              if (((CharSequence)localObject2).length() <= 0) {
                break label715;
              }
              i = 1;
              label476:
              if (i == 0) {
                break label720;
              }
            }
          }
        }
      }
    }
    label715:
    label720:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = new JSONObject((String)localObject2).optJSONObject("sns_ad");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optString("uxinfo");
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = null;
        }
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).zgJ = ((String)localObject2);
      StringBuilder localStringBuilder = new StringBuilder("save outSize uxinfo:");
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).zgJ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Log.i("Finder.FinderLiveService", (String)localObject1);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).dGW();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).zfa = ((int)paramf.zey.aJt());
      localObject1 = new StringBuilder("transferLiveData liveId:").append(localc.liveInfo.liveId).append(" objectId:").append(localc.xbk).append(" nicknameOption:").append(localc.kiv).append(" anchorUsername:");
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      paramf = localObject3;
      if (localObject2 != null) {
        paramf = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).kig;
      }
      Log.i("Finder.FinderLiveService", paramf);
      AppMethodBeat.o(283361);
      return locala;
      locala = null;
      break;
      i = 0;
      break label476;
    }
  }
  
  public static void a(EGLContext paramEGLContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(283396);
    kotlin.g.b.p.k(paramEGLContext, "eglContext");
    com.tencent.mm.live.core.core.trtc.a locala = kHp;
    if (locala != null)
    {
      kotlin.g.b.p.k(paramEGLContext, "eglContext");
      locala.knp.eglContext14 = paramEGLContext;
      locala.knp.textureId = paramInt1;
      locala.kno.texture = locala.knp;
      locala.kno.width = paramInt2;
      locala.kno.height = paramInt3;
      locala.kno.pixelFormat = 2;
      locala.kno.bufferType = 3;
      locala.knl.sendCustomVideoData(locala.kno);
      AppMethodBeat.o(283396);
      return;
    }
    AppMethodBeat.o(283396);
  }
  
  private static void a(Bundle paramBundle, Context paramContext)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(283403);
    boolean bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_FORCE_TASK", false);
    int j = paramBundle.getInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0);
    Object localObject2 = new StringBuilder("showMiniWindowWithoutPermissionCheck: forceMoveTask:").append(bool).append(", generateType:").append(j).append(", isFloatMode:");
    paramBundle = kHp;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.knA;
      if (paramBundle == null) {}
    }
    for (paramBundle = Boolean.valueOf(paramBundle.isFloatMode());; paramBundle = null)
    {
      Log.i("Finder.FinderLiveService", paramBundle);
      paramBundle = kHp;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.knA;
        if ((paramBundle != null) && (!paramBundle.isFloatMode()))
        {
          localObject2 = kHp;
          if (localObject2 != null)
          {
            com.tencent.mm.plugin.finder.live.viewmodel.data.business.b localb = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
            paramBundle = localObject1;
            if (localb != null) {
              paramBundle = localb.zgo;
            }
            com.tencent.mm.live.core.core.b.a.a((com.tencent.mm.live.core.core.b)localObject2, paramContext, bool, true, j, 0, paramBundle, 16);
          }
          ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).ld(false);
          paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (paramBundle != null) {
            i = paramBundle.zfu;
          }
          if (com.tencent.mm.ae.d.dr(i, 524288)) {
            dzy();
          }
        }
      }
      paramBundle = com.tencent.mm.plugin.finder.live.report.k.yBj;
      paramBundle = com.tencent.mm.plugin.finder.live.report.k.dDm().yDw;
      paramBundle.yNx += 1L;
      AppMethodBeat.o(283403);
      return;
    }
  }
  
  public static void a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.core.model.g paramg, kotlin.g.a.b<? super Integer, kotlin.x> paramb)
  {
    AppMethodBeat.i(283390);
    kotlin.g.b.p.k(paramg, "liveRoomModel");
    kotlin.g.b.p.k(paramb, "action");
    if ((kHp instanceof com.tencent.mm.live.core.core.c.c))
    {
      paramLivePreviewView = kHp;
      if (paramLivePreviewView != null) {
        paramLivePreviewView.a(paramg);
      }
      paramg = kHp;
      paramLivePreviewView = paramg;
      if (!(paramg instanceof com.tencent.mm.live.core.core.c.c)) {
        paramLivePreviewView = null;
      }
      paramLivePreviewView = (com.tencent.mm.live.core.core.c.c)paramLivePreviewView;
      if (paramLivePreviewView != null)
      {
        paramLivePreviewView.a(null, (com.tencent.mm.live.core.core.c)new m(paramb));
        AppMethodBeat.o(283390);
        return;
      }
    }
    AppMethodBeat.o(283390);
  }
  
  public static void a(aq paramaq, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(283389);
    kotlin.g.b.p.k(paramaq, "musicItem");
    Log.i("Finder.FinderLiveService", "playMusic " + paramaq + ", forcePlay:" + paramBoolean + ", stack:" + Util.getStack());
    String str = paramaq.yin.SMZ;
    int j = paramaq.yin.SMT;
    Object localObject1;
    if (paramaq.yin.playable)
    {
      localObject1 = (CharSequence)str;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label121;
      }
    }
    label121:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(283389);
      return;
    }
    Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    if (localObject2 != null)
    {
      localObject1 = dzB();
      if (localObject1 != null) {}
      for (localObject1 = Boolean.valueOf(((com.tencent.mm.live.core.core.trtc.a)localObject1).knH);; localObject1 = null)
      {
        if ((!paramBoolean) && (!(kotlin.g.b.p.h(localObject1, Boolean.TRUE) ^ true))) {
          break label428;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).zgj;
        if (localObject1 != null) {
          kotlin.g.b.p.k(paramaq, "item");
        }
        try
        {
          localObject2 = ((b)localObject1).dxN();
          Object localObject3 = ((b)localObject1).ydi.get(paramInt);
          kotlin.g.b.p.j(localObject3, "musicList[pos]");
          localObject3 = (aq)localObject3;
          if (((aq)localObject3).yin.SMT == paramaq.yin.SMT)
          {
            if (localObject2 != null) {
              ((aq)localObject2).mfx = 0;
            }
            ((aq)localObject3).mfx = 1;
            ((b)localObject1).fFw = paramInt;
          }
          Log.i("FinderLiveAnchorMusicData", "playMusicItem item:" + paramaq + " songId size:" + ((b)localObject1).ydh.size() + ", musicList id size:" + ((b)localObject1).ydi.size() + ", pos:" + paramInt + " oriMusicItem:" + localObject2 + " newMusicItem:" + localObject3 + ", curPlayPos:" + ((b)localObject1).fFw);
        }
        catch (Exception paramaq)
        {
          for (;;)
          {
            localObject1 = ak.AGL;
            ak.a(paramaq, "FinderLiveAnchorMusicData playMusicItem");
          }
        }
        paramaq = dzB();
        if (paramaq == null) {
          break label428;
        }
        paramaq.a(j, str, (TXAudioEffectManager.TXMusicPlayObserver)yhC);
        AppMethodBeat.o(283389);
        return;
      }
      label428:
      AppMethodBeat.o(283389);
      return;
    }
    Log.e("Finder.FinderLiveService", "playMusic error curLiveRoomData is null!");
    AppMethodBeat.o(283389);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(283369);
    kotlin.g.b.p.k(parama, "liveData");
    Log.i("Finder.FinderLiveService", "checkAcceptMicType micType:2");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn = 4;
    AppMethodBeat.o(283369);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, boolean paramBoolean, b.c paramc, Bundle paramBundle, long paramLong)
  {
    AppMethodBeat.i(283348);
    kotlin.g.b.p.k(parama, "roomData");
    kotlin.g.b.p.k(paramc, "event");
    StringBuilder localStringBuilder = new StringBuilder("transferState before event:").append(paramc).append(" curLive:");
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((bac)localObject).liveId);; localObject = null)
    {
      Log.i("Finder.FinderLiveService", ((Long)localObject).longValue() + " liveState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfv + " uiState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu + ",isAnchor:" + paramBoolean);
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (paramLong == ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId) {
        break;
      }
      Log.w("Finder.FinderLiveService", "invalid liveId:" + paramLong + ", ignore...");
      AppMethodBeat.o(283348);
      return;
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfw = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).lastLiveState = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv;
    switch (ai.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      label914:
      do
      {
        for (;;)
        {
          Log.i("Finder.FinderLiveService", "transferState after  event:" + paramc + " liveState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv + " uiState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu);
          AppMethodBeat.o(283348);
          return;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 1;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu = 1024;
          continue;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 1;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFFFBFF;
          continue;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 0;
          if ((paramBundle == null) || (!paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", false)))
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu = 0;
            continue;
            if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) && (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 96)))
            {
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x10;
              continue;
              if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) && (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 16)))
              {
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFFFFEF;
                continue;
                if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) && (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 96)))
                {
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x2;
                  continue;
                  if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) && (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 2)))
                  {
                    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFFFFFD;
                    continue;
                    if ((!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 32)) && (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 524288)))
                    {
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 3;
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu = 1;
                    }
                    parama = com.tencent.c.a.a.a.a.a.Zlt;
                    yhj = ((Number)com.tencent.c.a.a.a.a.a.imc().aSr()).intValue();
                    continue;
                    if ((!paramBoolean) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).dGN()))
                    {
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 3;
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu = 1;
                      continue;
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 4;
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu = 0;
                    }
                  }
                }
              }
            }
          }
        }
        if (!paramBoolean)
        {
          parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo;
          if (parama == null) {
            break label914;
          }
        }
        for (parama = Long.valueOf(parama.liveId);; parama = null)
        {
          paramLong = parama.longValue();
          parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          if (parama == null) {
            break;
          }
          parama = parama.liveInfo;
          if ((parama == null) || (paramLong != parama.liveId)) {
            break;
          }
          parama = kHp;
          if (parama != null) {
            parama.sV(1);
          }
          if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) || (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 96))) {
            break;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x20;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFFFDFF;
          break;
        }
      } while (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).dGN());
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 3;
      if (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 524288)) {
        break;
      }
    }
    for (int i = 524289;; i = 1)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu = i;
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) || (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 608))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x200;
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) || (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 96))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x40;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFFFDFF;
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) || (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 64))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFFFFBF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 3;
      break;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) {
        break;
      }
      if (paramBundle != null) {}
      for (parama = Boolean.valueOf(paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT", false));; parama = null)
      {
        if (!kotlin.g.b.p.h(parama, Boolean.TRUE)) {
          break label1150;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x8;
        break;
      }
      label1150:
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFFFFF7;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 3;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x80;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 3;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x100;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfv = 3;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x1000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x800;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFFF7FF;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x4000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFFBFFF;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x8000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFF7FFF;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x10000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFEFFFF;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x20000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFDFFFF;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x40000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFFBFFFF;
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) || (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 524288))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu |= 0x80000;
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted()) || (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu, 524288))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfu &= 0xFFF7FFFF;
      parama = kHp;
      if (parama == null) {
        break;
      }
      parama.sW(2);
      break;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.view.a parama)
  {
    ydt = parama;
    c localc = yhe;
    if (localc != null) {
      localc.ydt = parama;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.view.e parame)
  {
    xWd = parame;
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg)
  {
    AppMethodBeat.i(283333);
    Log.i("Finder.FinderLiveService", "FinderLiveDataModel set ".concat(String.valueOf(paramg)));
    yhh = paramg;
    AppMethodBeat.o(283333);
  }
  
  private static void a(cru paramcru)
  {
    AppMethodBeat.i(283341);
    if (paramcru != null)
    {
      if (paramcru.TyN > 0)
      {
        Object localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLK();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().audioConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).setAudioQuality(paramcru.TyN);
      }
      Log.i("Finder.FinderLiveService", "processLiveAudioSdkParam audioQuality:" + paramcru.TyN);
      AppMethodBeat.o(283341);
      return;
    }
    AppMethodBeat.o(283341);
  }
  
  private static void a(crx paramcrx, TRTCCloudDef.TRTCParams paramTRTCParams, com.tencent.mm.live.core.core.model.f paramf)
  {
    AppMethodBeat.i(283342);
    a(paramcrx.Tzt);
    a(paramcrx.Tzu);
    Object localObject1 = paramcrx.Tzv;
    if ((localObject1 != null) && (paramTRTCParams != null) && (paramf != null))
    {
      Log.i("Finder.FinderLiveService", "userDefineRecordId:" + ((crv)localObject1).TyO + ',' + ((crv)localObject1).TyP);
      paramcrx = ((crv)localObject1).TyP;
      String str = ((crv)localObject1).TyO;
      int j = ((crv)localObject1).TyY;
      int i = j;
      if (!com.tencent.mm.modelcontrol.e.vW(5))
      {
        i = j;
        if (j == com.tencent.mm.live.core.core.a.kiQ.value) {
          i = ((crv)localObject1).TyZ;
        }
      }
      paramf.kjr = ((crv)localObject1).TyZ;
      Object localObject2;
      if (i < 100)
      {
        paramf.a(com.tencent.mm.live.core.core.model.a.klz);
        paramf.kjq = i;
        localObject2 = (Collection)((crv)localObject1).TyU;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label323;
        }
      }
      label323:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label328;
        }
        localObject1 = ((crv)localObject1).TyU;
        kotlin.g.b.p.j(localObject1, "channelParams.cdn_trans_info");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (vj)((Iterator)localObject1).next();
          localObject2 = (Map)paramf.kmm;
          i = ((vj)localObject3).SgP;
          localObject3 = ((vj)localObject3).url;
          kotlin.g.b.p.j(localObject3, "it.url");
          ((Map)localObject2).put(Integer.valueOf(i), localObject3);
        }
        if (i == com.tencent.mm.live.core.core.a.kiR.value)
        {
          paramf.a(com.tencent.mm.live.core.core.model.a.klA);
          break;
        }
        if (i != com.tencent.mm.live.core.core.a.kiS.value) {
          break;
        }
        paramf.a(com.tencent.mm.live.core.core.model.a.klB);
        break;
      }
      label328:
      if ((!Util.isNullOrNil(paramcrx)) || (!Util.isNullOrNil(str)))
      {
        localObject1 = new com.tencent.mm.ad.i();
        if (!Util.isNullOrNil(paramcrx)) {
          ((com.tencent.mm.ad.i)localObject1).g("userdefine_streamid_main", paramcrx);
        }
        if (!Util.isNullOrNil(str)) {
          ((com.tencent.mm.ad.i)localObject1).g("userdefine_record_id", str);
        }
        paramcrx = new com.tencent.mm.ad.i();
        paramcrx.g("Str_uc_params", localObject1);
        paramTRTCParams.businessInfo = paramcrx.toString();
      }
      Log.i("Finder.FinderLiveService", "processLiveSdkParams cdnQualitySvrcfg" + paramf.kjq + " cdnSwitchMode:" + paramf.kml + " cdn_quality_h265backcfg:" + paramf.kjr);
    }
    AppMethodBeat.o(283342);
  }
  
  private static void a(cry paramcry)
  {
    AppMethodBeat.i(283340);
    if (paramcry != null)
    {
      Object localObject;
      if (paramcry.Tzw > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).setVideoResolution(paramcry.Tzw);
      }
      if (paramcry.Tzy > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).ta(paramcry.Tzy);
      }
      if (paramcry.Tzz > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).setVideoBitrate(paramcry.Tzz);
      }
      if (paramcry.TzG > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).setMinVideoBitrate(paramcry.TzG);
      }
      if (paramcry.TzI > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).tb(paramcry.TzI);
      }
      if (paramcry.TzJ > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).tc(paramcry.TzJ);
      }
      if (paramcry.TzK > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).td(paramcry.TzK);
      }
      if (paramcry.TzL > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).te(paramcry.TzL);
      }
      if (paramcry.TzB > 0)
      {
        localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
        kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).tf(paramcry.TzB);
      }
      int i = paramcry.TzC;
      if (i < 0) {}
      for (;;)
      {
        Log.i("Finder.FinderLiveService", "processLiveVideoSdkParam encResEnum:" + paramcry.Tzw + ", capFps:" + paramcry.Tzy + ", encBR:" + paramcry.Tzz + ", qosPreferneceEnum:" + paramcry.TzB + ", qosControlModeEnum:" + paramcry.TzC);
        AppMethodBeat.o(283340);
        return;
        if (1 >= i)
        {
          localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
          localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
          kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).sZ(paramcry.TzC);
        }
      }
    }
    AppMethodBeat.o(283340);
  }
  
  public static void a(kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super Bundle, kotlin.x> params)
  {
    AppMethodBeat.i(283395);
    kotlin.g.b.p.k(params, "callback");
    com.tencent.mm.plugin.finder.live.model.context.a locala = yds;
    if (locala != null)
    {
      k localk = yhd;
      an localan = ybM;
      kotlin.g.b.p.k(locala, "liveData");
      kotlin.g.b.p.k(params, "callback");
      if (localan != null)
      {
        localan.a((kotlin.g.a.u)new k.e(localk, locala, localan, params));
        AppMethodBeat.o(283395);
        return;
      }
      AppMethodBeat.o(283395);
      return;
    }
    AppMethodBeat.o(283395);
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(283397);
    kotlin.g.b.p.k(paramArrayOfByte, "audioBuffer");
    Object localObject = kHp;
    if (localObject != null)
    {
      kotlin.g.b.p.k(paramArrayOfByte, "audioBuffer");
      TRTCCloud localTRTCCloud = ((com.tencent.mm.live.core.core.trtc.a)localObject).knl;
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knq;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).data = paramArrayOfByte;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).sampleRate = paramInt1;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).channel = paramInt2;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).timestamp = paramLong;
      localTRTCCloud.sendCustomAudioData((TRTCCloudDef.TRTCAudioFrame)localObject);
      AppMethodBeat.o(283397);
      return;
    }
    AppMethodBeat.o(283397);
  }
  
  private static boolean a(int paramInt1, int paramInt2, awj paramawj)
  {
    long l1 = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(283338);
    Object localObject1;
    Object localObject3;
    boolean bool1;
    if (paramInt1 == -100038)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject1 != null)
      {
        localObject3 = kHp;
        if (localObject3 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject3).sX(4);
        }
        localObject3 = com.tencent.mm.live.b.p.kvF;
        localObject3 = com.tencent.mm.live.b.p.aOe();
        if (localObject3 != null) {
          ((com.tencent.mm.live.b.g)localObject3).onCloseLive(new com.tencent.mm.live.b.e(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo.liveId));
        }
      }
      Log.i("Finder.FinderLiveService", "handleKeepAliveResp live has finished");
      bool1 = false;
    }
    for (;;)
    {
      localObject3 = new StringBuilder("handleKeepAliveResp result:").append(bool1).append(" errCode:").append(paramInt1).append(", errType:").append(paramInt2).append(", curData:");
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
        if (localObject1 == null) {}
      }
      for (localObject1 = Long.valueOf(((bac)localObject1).liveId);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append(", resp.liveId:");
        localObject3 = paramawj.liveInfo;
        paramawj = localObject2;
        if (localObject3 != null) {
          paramawj = Long.valueOf(((bac)localObject3).liveId);
        }
        Log.i("Finder.FinderLiveService", paramawj);
        AppMethodBeat.o(283338);
        return bool1;
        if ((paramInt2 != 0) || (paramInt1 != 0))
        {
          Log.i("Finder.FinderLiveService", "handleKeepAliveResp launch live room failed");
          bool1 = false;
          break;
        }
        if (paramawj == null)
        {
          Log.i("Finder.FinderLiveService", "handleKeepAliveResp invalid live resp");
          bool1 = false;
          break;
        }
        localObject1 = paramawj.liveInfo;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((bac)localObject1).liveId);
          label305:
          if (!d((Long)localObject1)) {
            break label436;
          }
          localObject1 = new StringBuilder("handleKeepAliveResp invalid live id, curData:");
          localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          long l2 = l1;
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject3).liveInfo;
            l2 = l1;
            if (localObject3 != null) {
              l2 = ((bac)localObject3).liveId;
            }
          }
          localObject3 = ((StringBuilder)localObject1).append(l2).append(", resp.liveId:");
          localObject1 = paramawj.liveInfo;
          if (localObject1 == null) {
            break label430;
          }
        }
        label430:
        for (localObject1 = Long.valueOf(((bac)localObject1).liveId);; localObject1 = null)
        {
          Log.i("Finder.FinderLiveService", localObject1);
          bool1 = false;
          break;
          localObject1 = null;
          break label305;
        }
        label436:
        localObject3 = paramawj.kvP;
        if (localObject3 == null) {
          break label908;
        }
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).a((crw)localObject3);
        }
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
        Object localObject4;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
          if (localObject1 != null)
          {
            localObject4 = paramawj.liveInfo;
            if (localObject4 != null) {
              l1 = ((bac)localObject4).liveId;
            }
            ((bac)localObject1).liveId = l1;
          }
        }
        Log.i("Finder.FinderLiveService", "doKeepAlive updatePrivateMapKey");
        localObject1 = com.tencent.mm.live.core.core.a.b.klq;
        if (b.b.aLi())
        {
          localObject1 = com.tencent.mm.live.core.core.a.b.klq;
          localObject1 = b.b.aLh();
          localObject4 = ((crw)localObject3).Tzn.Ap();
          kotlin.g.b.p.j(localObject4, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          ((com.tencent.mm.live.core.core.a.b)localObject1).Nv((String)localObject4);
          label576:
          localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          if (localObject4 != null)
          {
            localObject1 = paramawj.xak;
            if (localObject1 == null) {
              break label872;
            }
            localObject1 = ((com.tencent.mm.cd.b)localObject1).UH;
            label610:
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject4).kvN = ((byte[])localObject1);
          }
          localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          localObject4 = new StringBuilder("KeepAlive write liveCookies to:");
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          if (localObject1 == null) {
            break label878;
          }
        }
        boolean bool2;
        label872:
        label878:
        for (localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).kvN;; localObject1 = null)
        {
          com.tencent.mm.plugin.finder.live.utils.a.ha("Finder.FinderLiveService", Util.encodeHexString((byte[])localObject1));
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).kvS;
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.live.core.core.model.g)localObject1).kmq;
              if (localObject1 != null) {
                ((TRTCCloudDef.TRTCParams)localObject1).privateMapKey = ((crw)localObject3).Tzn.Ap();
              }
            }
          }
          b((crw)localObject3);
          bool2 = true;
          bool1 = bool2;
          if (!(kHp instanceof com.tencent.mm.live.core.core.a.b)) {
            break;
          }
          localObject1 = kHp;
          if (localObject1 != null) {
            break label884;
          }
          paramawj = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
          AppMethodBeat.o(283338);
          throw paramawj;
          localObject1 = com.tencent.mm.live.core.core.b.a.knj;
          if (com.tencent.mm.live.core.core.b.a.a.aLi())
          {
            localObject1 = com.tencent.mm.live.core.core.b.a.knj;
            localObject1 = com.tencent.mm.live.core.core.b.a.a.aLu();
            localObject4 = ((crw)localObject3).Tzn.Ap();
            kotlin.g.b.p.j(localObject4, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            ((com.tencent.mm.live.core.core.b.a)localObject1).Nv((String)localObject4);
            break label576;
          }
          if (dzA() == null) {
            break label576;
          }
          localObject1 = dzA();
          if (localObject1 == null) {
            break label576;
          }
          localObject4 = ((crw)localObject3).Tzn.Ap();
          kotlin.g.b.p.j(localObject4, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          ((com.tencent.mm.live.core.core.c.c)localObject1).Nv((String)localObject4);
          break label576;
          localObject1 = null;
          break label610;
        }
        label884:
        ((com.tencent.mm.live.core.core.a.b)localObject1).eU(needMirror());
        bool1 = bool2;
        break;
      }
      label908:
      bool1 = false;
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, bcb parambcb)
  {
    AppMethodBeat.i(283337);
    Object localObject2 = new StringBuilder("handleRefreshMicResp errCode:").append(paramInt1).append(", errType:").append(paramInt2).append(", curData:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
    boolean bool1;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((bac)localObject1).liveId);
        Log.i("Finder.FinderLiveService", localObject1);
        boolean bool2 = false;
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          bool1 = bool2;
          if (paramInt1 == 0)
          {
            parambcb = parambcb.SJL;
            bool1 = bool2;
            if (parambcb != null)
            {
              localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).a(parambcb);
              }
              Log.i("Finder.FinderLiveService", "handleRefreshMicResp updatePrivateMapKey");
              localObject1 = com.tencent.mm.live.core.core.a.b.klq;
              if (!b.b.aLi()) {
                break label269;
              }
              localObject1 = com.tencent.mm.live.core.core.a.b.klq;
              localObject1 = b.b.aLh();
              localObject2 = parambcb.Tzn.Ap();
              kotlin.g.b.p.j(localObject2, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
              ((com.tencent.mm.live.core.core.a.b)localObject1).Nv((String)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).kvS;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.core.model.g)localObject1).kmq;
          if (localObject1 != null) {
            ((TRTCCloudDef.TRTCParams)localObject1).privateMapKey = parambcb.Tzn.Ap();
          }
        }
      }
      b(parambcb);
      bool1 = true;
      AppMethodBeat.o(283337);
      return bool1;
      localObject1 = null;
      break;
      label269:
      localObject1 = com.tencent.mm.live.core.core.b.a.knj;
      if (com.tencent.mm.live.core.core.b.a.a.aLi())
      {
        localObject1 = com.tencent.mm.live.core.core.b.a.knj;
        localObject1 = com.tencent.mm.live.core.core.b.a.a.aLu();
        localObject2 = parambcb.Tzn.Ap();
        kotlin.g.b.p.j(localObject2, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
        ((com.tencent.mm.live.core.core.b.a)localObject1).Nv((String)localObject2);
      }
      else if (dzA() != null)
      {
        localObject1 = dzA();
        if (localObject1 != null)
        {
          localObject2 = parambcb.Tzn.Ap();
          kotlin.g.b.p.j(localObject2, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          ((com.tencent.mm.live.core.core.c.c)localObject1).Nv((String)localObject2);
        }
      }
    }
  }
  
  public static int aMQ()
  {
    AppMethodBeat.i(283384);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    int i = ((Number)com.tencent.c.a.a.a.a.a.ilH().aSr()).intValue();
    Log.i("Finder.FinderLiveService", "mirroMode:".concat(String.valueOf(i)));
    AppMethodBeat.o(283384);
    return i;
  }
  
  public static com.tencent.mm.live.core.b.a aOk()
  {
    return knC;
  }
  
  public static com.tencent.mm.live.core.b.b aOl()
  {
    return knD;
  }
  
  public static void aPh()
  {
    AppMethodBeat.i(283363);
    Object localObject = o.yfE;
    o.dyF();
    localObject = o.yfE;
    o.dyG();
    kKI.avz();
    localObject = yhx;
    if (localObject != null) {
      ((as)localObject).dzV();
    }
    localObject = yhy;
    if (localObject != null) {
      ((as)localObject).dzV();
    }
    localObject = yhz;
    if (localObject != null) {
      ((as)localObject).dzV();
    }
    localObject = ac.ygU;
    ac.dyZ();
    bwc();
    AppMethodBeat.o(283363);
  }
  
  private static void ak(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(283380);
    kotlin.g.b.p.k(paramContext, "context");
    Object localObject2 = new StringBuilder("closeMiniProgram,purpose:").append(paramInt).append(", shoppingInMiniProgram:");
    Object localObject1 = (j)business(j.class);
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((j)localObject1).ziO);; localObject1 = null)
    {
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = (j)business(j.class);
      if (localObject1 == null) {
        break;
      }
      if (((j)localObject1).ziO == true)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.viewmodel.data.g.zeD;
        com.tencent.mm.plugin.finder.live.viewmodel.data.g.dGB().clear();
        localObject1 = new Intent();
        localObject2 = com.tencent.mm.plugin.findersdk.a.b.BuP;
        ((Intent)localObject1).putExtra(com.tencent.mm.plugin.findersdk.a.b.emQ(), paramInt);
        ((Intent)localObject1).addFlags(335544320);
        localObject2 = com.tencent.mm.plugin.findersdk.e.a.Bxf;
        ((Intent)localObject1).setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.enL());
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "closeMiniProgram", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "closeMiniProgram", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(283380);
      return;
    }
    AppMethodBeat.o(283380);
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(283379);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramg, "bundle");
    int i = paramg.hashCode();
    paramg.nBH = true;
    com.tencent.mm.plugin.finder.live.model.context.a locala = yds;
    Object localObject2 = paramg.nBE.nZG;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof MiniProgramHalfScreenStatusChangeListener)) {
      localObject1 = null;
    }
    paramg.nBG = ((com.tencent.mm.plugin.appbrand.api.i)new v(locala, (MiniProgramHalfScreenStatusChangeListener)localObject1));
    localObject1 = com.tencent.mm.plugin.finder.live.viewmodel.data.g.zeD;
    ((Map)com.tencent.mm.plugin.finder.live.viewmodel.data.g.dGB()).put(Integer.valueOf(i), paramg);
    Log.i("Finder.FinderLiveService", "launchMiniProgram,key:" + i + ",bundle is null:false");
    paramg = new Intent();
    localObject1 = com.tencent.mm.plugin.findersdk.a.b.BuP;
    localObject1 = com.tencent.mm.plugin.findersdk.a.b.emQ();
    localObject2 = com.tencent.mm.plugin.findersdk.a.b.BuP;
    paramg.putExtra((String)localObject1, com.tencent.mm.plugin.findersdk.a.b.emT());
    localObject1 = com.tencent.mm.plugin.findersdk.a.b.BuP;
    paramg.putExtra(com.tencent.mm.plugin.findersdk.a.b.emR(), i);
    paramg.putExtra("MMActivity.OverrideEnterAnimation", -1);
    paramg.putExtra("MMActivity.OverrideExitAnimation", -1);
    paramg.addFlags(335544320);
    localObject1 = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    paramg.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.enL());
    paramg = new com.tencent.mm.hellhoundlib.b.a().bm(paramg);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramg.aFh(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "launchMiniProgram", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramg.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "launchMiniProgram", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(283379);
  }
  
  private static void b(crw paramcrw)
  {
    AppMethodBeat.i(283339);
    if (fFE)
    {
      Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject != null)
      {
        try
        {
          localcrx = new crx();
          paramcrw = paramcrw.Tzo;
          kotlin.g.b.p.j(paramcrw, "liveSdkInfo.sdk_params");
          paramcrw = localcrx.parseFrom(paramcrw.UH);
          if (paramcrw != null) {
            break label112;
          }
          paramcrw = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
          AppMethodBeat.o(283339);
          throw paramcrw;
        }
        catch (Exception paramcrw)
        {
          Log.w("Finder.FinderLiveService", "updateSdkParam fail:" + paramcrw.getMessage());
        }
        AppMethodBeat.o(283339);
        return;
        label112:
        crx localcrx = (crx)paramcrw;
        paramcrw = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).kvS;
        if (paramcrw != null)
        {
          paramcrw = paramcrw.kmq;
          label131:
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).kvS;
          if (localObject == null) {
            break label350;
          }
          localObject = ((com.tencent.mm.live.core.core.model.g)localObject).kjd;
          label145:
          a(localcrx, paramcrw, (com.tencent.mm.live.core.core.model.f)localObject);
          paramcrw = kHp;
          if (paramcrw != null) {
            paramcrw.aLB();
          }
          localObject = new StringBuilder("updateSdkParam lastFps:");
          paramcrw = kHp;
          if (paramcrw == null) {
            break label355;
          }
        }
        label350:
        label355:
        for (paramcrw = Integer.valueOf(paramcrw.knI);; paramcrw = null)
        {
          paramcrw = ((StringBuilder)localObject).append(paramcrw).append(" new Fps:");
          localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
          localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
          kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
          Log.i("Finder.FinderLiveService", ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).aLV());
          if ((kHp == null) || (!(kHp instanceof com.tencent.mm.live.core.core.a.b))) {
            break;
          }
          paramcrw = kHp;
          if (paramcrw != null)
          {
            int i = paramcrw.knI;
            paramcrw = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
            kotlin.g.b.p.j(paramcrw, "ConfigHelper.getInstance()");
            paramcrw = paramcrw.aLJ();
            kotlin.g.b.p.j(paramcrw, "ConfigHelper.getInstance().videoConfig");
            if (i == paramcrw.aLV()) {
              break;
            }
          }
          if (!dzz()) {
            break;
          }
          paramcrw = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if ((paramcrw != null) && (paramcrw.zgy == true)) {
            break;
          }
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)af.yhW);
          AppMethodBeat.o(283339);
          return;
          paramcrw = null;
          break label131;
          localObject = null;
          break label145;
        }
      }
    }
    AppMethodBeat.o(283339);
  }
  
  public static void b(kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super Bundle, kotlin.x> params)
  {
    AppMethodBeat.i(283399);
    kotlin.g.b.p.k(params, "callback");
    k localk = yhd;
    com.tencent.mm.live.core.core.trtc.a locala = kHp;
    com.tencent.mm.plugin.finder.live.model.context.a locala1 = yds;
    an localan = ybM;
    kotlin.g.b.p.k(params, "callback");
    if (locala1 != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)locala1.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).kvS;
        if ((locala == null) || (localObject == null) || (locala1 == null)) {
          break label167;
        }
        locala.a((com.tencent.mm.live.core.core.model.g)localObject);
        localObject = ao.AGX;
        ap.a locala2 = ap.AIh;
        ao.a((ao)localObject, ap.efB().name, null, false, false, 14);
        locala.a((com.tencent.mm.live.core.core.c)new k.b(locala1, localk, localan, params));
      }
    }
    label167:
    for (Object localObject = kotlin.x.aazN;; localObject = null)
    {
      if (localObject == null) {
        params.a(Boolean.FALSE, Integer.valueOf(-1), Integer.valueOf(-1), null, null);
      }
      AppMethodBeat.o(283399);
      return;
      localObject = null;
      break;
    }
  }
  
  /* Error */
  private static boolean b(int paramInt1, int paramInt2, auv paramauv, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 2764
    //   3: invokestatic 535	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 2770	com/tencent/mm/plugin/findersdk/b:BuZ	Lcom/tencent/mm/plugin/findersdk/b;
    //   9: astore 11
    //   11: aload_2
    //   12: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   15: astore 12
    //   17: aload 12
    //   19: ifnull +423 -> 442
    //   22: aload 12
    //   24: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   27: lstore 5
    //   29: lload 5
    //   31: lconst_0
    //   32: lcmp
    //   33: ifeq +415 -> 448
    //   36: iconst_1
    //   37: istore 9
    //   39: aload 11
    //   41: ldc_w 2775
    //   44: iload 9
    //   46: iconst_0
    //   47: new 2777	com/tencent/mm/plugin/finder/live/model/ah$o
    //   50: dup
    //   51: iload_0
    //   52: iload_1
    //   53: invokespecial 2780	com/tencent/mm/plugin/finder/live/model/ah$o:<init>	(II)V
    //   56: checkcast 2720	kotlin/g/a/a
    //   59: bipush 12
    //   61: invokestatic 2785	com/tencent/mm/ae/f$a:a	(Lcom/tencent/mm/ae/f;Ljava/lang/String;ZZLkotlin/g/a/a;I)V
    //   64: getstatic 2770	com/tencent/mm/plugin/findersdk/b:BuZ	Lcom/tencent/mm/plugin/findersdk/b;
    //   67: astore 11
    //   69: ldc_w 696
    //   72: invokestatic 699	com/tencent/mm/plugin/finder/live/model/ah:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   75: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   78: astore 12
    //   80: aload 12
    //   82: ifnull +372 -> 454
    //   85: aload 12
    //   87: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   90: astore 12
    //   92: aload 12
    //   94: ifnull +360 -> 454
    //   97: aload 12
    //   99: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   102: lstore 5
    //   104: lload 5
    //   106: lconst_0
    //   107: lcmp
    //   108: ifeq +352 -> 460
    //   111: iconst_1
    //   112: istore 9
    //   114: aload 11
    //   116: ldc_w 2787
    //   119: iload 9
    //   121: iconst_0
    //   122: new 2789	com/tencent/mm/plugin/finder/live/model/ah$p
    //   125: dup
    //   126: iload_0
    //   127: iload_1
    //   128: aload_2
    //   129: invokespecial 2792	com/tencent/mm/plugin/finder/live/model/ah$p:<init>	(IILcom/tencent/mm/protocal/protobuf/auv;)V
    //   132: checkcast 2720	kotlin/g/a/a
    //   135: bipush 12
    //   137: invokestatic 2785	com/tencent/mm/ae/f$a:a	(Lcom/tencent/mm/ae/f;Ljava/lang/String;ZZLkotlin/g/a/a;I)V
    //   140: new 680	java/lang/StringBuilder
    //   143: dup
    //   144: ldc_w 2794
    //   147: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: iload_0
    //   151: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc_w 2796
    //   157: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: astore 12
    //   162: ldc_w 696
    //   165: invokestatic 699	com/tencent/mm/plugin/finder/live/model/ah:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   168: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   171: astore 11
    //   173: aload 11
    //   175: ifnull +291 -> 466
    //   178: aload 11
    //   180: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   183: astore 11
    //   185: aload 11
    //   187: ifnull +279 -> 466
    //   190: aload 11
    //   192: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   195: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: astore 11
    //   200: aload 12
    //   202: aload 11
    //   204: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: ldc_w 2423
    //   210: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: astore 12
    //   215: aload_2
    //   216: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   219: astore 11
    //   221: aload 11
    //   223: ifnull +249 -> 472
    //   226: aload 11
    //   228: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   231: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   234: astore 11
    //   236: ldc_w 726
    //   239: aload 12
    //   241: aload 11
    //   243: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: ldc_w 2798
    //   249: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload_3
    //   253: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_2
    //   263: ifnull +74 -> 337
    //   266: aload_2
    //   267: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   270: astore 11
    //   272: aload 11
    //   274: ifnull +204 -> 478
    //   277: aload 11
    //   279: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   282: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   285: astore 11
    //   287: ldc_w 696
    //   290: invokestatic 699	com/tencent/mm/plugin/finder/live/model/ah:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   293: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   296: astore 12
    //   298: aload 12
    //   300: ifnull +184 -> 484
    //   303: aload 12
    //   305: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   308: astore 12
    //   310: aload 12
    //   312: ifnull +172 -> 484
    //   315: aload 12
    //   317: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   320: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   323: astore 12
    //   325: aload 11
    //   327: aload 12
    //   329: invokestatic 1546	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   332: iconst_1
    //   333: ixor
    //   334: ifeq +167 -> 501
    //   337: new 680	java/lang/StringBuilder
    //   340: dup
    //   341: ldc_w 2800
    //   344: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   347: astore 12
    //   349: ldc_w 696
    //   352: invokestatic 699	com/tencent/mm/plugin/finder/live/model/ah:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   355: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   358: astore 11
    //   360: aload 11
    //   362: ifnull +128 -> 490
    //   365: aload 11
    //   367: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   370: astore 11
    //   372: aload 11
    //   374: ifnull +116 -> 490
    //   377: aload 11
    //   379: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   382: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   385: astore 11
    //   387: aload 12
    //   389: aload 11
    //   391: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   394: ldc_w 2423
    //   397: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: astore 11
    //   402: aload_2
    //   403: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   406: astore_2
    //   407: aload_2
    //   408: ifnull +88 -> 496
    //   411: aload_2
    //   412: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   415: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   418: astore_2
    //   419: ldc_w 726
    //   422: aload 11
    //   424: aload_2
    //   425: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: ldc_w 2764
    //   437: invokestatic 667	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: iconst_0
    //   441: ireturn
    //   442: lconst_0
    //   443: lstore 5
    //   445: goto -416 -> 29
    //   448: iconst_0
    //   449: istore 9
    //   451: goto -412 -> 39
    //   454: lconst_0
    //   455: lstore 5
    //   457: goto -353 -> 104
    //   460: iconst_0
    //   461: istore 9
    //   463: goto -349 -> 114
    //   466: aconst_null
    //   467: astore 11
    //   469: goto -269 -> 200
    //   472: aconst_null
    //   473: astore 11
    //   475: goto -239 -> 236
    //   478: aconst_null
    //   479: astore 11
    //   481: goto -194 -> 287
    //   484: aconst_null
    //   485: astore 12
    //   487: goto -162 -> 325
    //   490: aconst_null
    //   491: astore 11
    //   493: goto -106 -> 387
    //   496: aconst_null
    //   497: astore_2
    //   498: goto -79 -> 419
    //   501: aload_2
    //   502: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   505: astore 11
    //   507: aload 11
    //   509: ifnull +126 -> 635
    //   512: aload 11
    //   514: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   517: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   520: astore 11
    //   522: aload 11
    //   524: invokestatic 2433	com/tencent/mm/plugin/finder/live/model/ah:d	(Ljava/lang/Long;)Z
    //   527: ifeq +125 -> 652
    //   530: new 680	java/lang/StringBuilder
    //   533: dup
    //   534: ldc_w 2802
    //   537: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   540: astore 12
    //   542: ldc_w 696
    //   545: invokestatic 699	com/tencent/mm/plugin/finder/live/model/ah:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   548: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   551: astore 11
    //   553: aload 11
    //   555: ifnull +86 -> 641
    //   558: aload 11
    //   560: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   563: astore 11
    //   565: aload 11
    //   567: ifnull +74 -> 641
    //   570: aload 11
    //   572: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   575: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   578: astore 11
    //   580: aload 12
    //   582: aload 11
    //   584: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   587: ldc_w 2423
    //   590: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: astore 11
    //   595: aload_2
    //   596: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   599: astore_2
    //   600: aload_2
    //   601: ifnull +46 -> 647
    //   604: aload_2
    //   605: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   608: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   611: astore_2
    //   612: ldc_w 726
    //   615: aload 11
    //   617: aload_2
    //   618: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: ldc_w 2764
    //   630: invokestatic 667	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   633: iconst_0
    //   634: ireturn
    //   635: aconst_null
    //   636: astore 11
    //   638: goto -116 -> 522
    //   641: aconst_null
    //   642: astore 11
    //   644: goto -64 -> 580
    //   647: aconst_null
    //   648: astore_2
    //   649: goto -37 -> 612
    //   652: ldc_w 916
    //   655: invokestatic 699	com/tencent/mm/plugin/finder/live/model/ah:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   658: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   661: astore 11
    //   663: aload 11
    //   665: ifnull +29 -> 694
    //   668: aload 11
    //   670: invokevirtual 1679	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:dGN	()Z
    //   673: iconst_1
    //   674: if_icmpne +20 -> 694
    //   677: ldc_w 726
    //   680: ldc_w 2804
    //   683: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: ldc_w 2764
    //   689: invokestatic 667	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   692: iconst_0
    //   693: ireturn
    //   694: iload_1
    //   695: iconst_4
    //   696: if_icmpne +30 -> 726
    //   699: iload_0
    //   700: ldc_w 2805
    //   703: if_icmpne +23 -> 726
    //   706: iconst_1
    //   707: istore 4
    //   709: iload 4
    //   711: ifeq +21 -> 732
    //   714: lconst_0
    //   715: invokestatic 2807	com/tencent/mm/plugin/finder/live/model/ah:Ln	(J)V
    //   718: ldc_w 2764
    //   721: invokestatic 667	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   724: iconst_0
    //   725: ireturn
    //   726: iconst_0
    //   727: istore 4
    //   729: goto -20 -> 709
    //   732: iload_1
    //   733: ifne +7 -> 740
    //   736: iload_0
    //   737: ifeq +41 -> 778
    //   740: iload_0
    //   741: tableswitch	default:+19 -> 760, -200001:+27->768
    //   761: lconst_1
    //   762: <illegal opcode>
    //   763: invokestatic 667	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   766: iconst_0
    //   767: ireturn
    //   768: getstatic 2813	com/tencent/mm/plugin/finder/live/model/aj:yif	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   771: astore_2
    //   772: invokestatic 2816	com/tencent/mm/plugin/finder/live/model/aj:dzQ	()V
    //   775: goto -15 -> 760
    //   778: ldc_w 916
    //   781: invokestatic 699	com/tencent/mm/plugin/finder/live/model/ah:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   784: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   787: astore 14
    //   789: aload 14
    //   791: ifnull +4235 -> 5026
    //   794: aload_2
    //   795: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   798: astore 11
    //   800: aload 11
    //   802: ifnull +345 -> 1147
    //   805: aload 14
    //   807: ldc_w 916
    //   810: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   813: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   816: aload_2
    //   817: getfield 2819	com/tencent/mm/protocal/protobuf/auv:SHd	J
    //   820: aload 14
    //   822: getfield 2822	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfk	J
    //   825: lsub
    //   826: putfield 2825	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfj	J
    //   829: aload 14
    //   831: aload 14
    //   833: getfield 2822	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfk	J
    //   836: aload_2
    //   837: getfield 2819	com/tencent/mm/protocal/protobuf/auv:SHd	J
    //   840: invokestatic 2831	kotlin/k/i:be	(JJ)J
    //   843: putfield 2822	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfk	J
    //   846: aload 14
    //   848: ldc_w 696
    //   851: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   854: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   857: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   860: aload 11
    //   862: getfield 2834	com/tencent/mm/protocal/protobuf/bac:SHj	J
    //   865: putfield 2834	com/tencent/mm/protocal/protobuf/bac:SHj	J
    //   868: aload 14
    //   870: ldc_w 696
    //   873: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   876: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   879: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   882: aload 11
    //   884: getfield 2837	com/tencent/mm/protocal/protobuf/bac:SHu	J
    //   887: putfield 2837	com/tencent/mm/protocal/protobuf/bac:SHu	J
    //   890: aload 14
    //   892: ldc_w 696
    //   895: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   898: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   901: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   904: aload_2
    //   905: getfield 2840	com/tencent/mm/protocal/protobuf/auv:SGR	I
    //   908: putfield 2843	com/tencent/mm/protocal/protobuf/bac:yYz	I
    //   911: aload 14
    //   913: ldc_w 696
    //   916: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   919: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   922: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   925: aload 11
    //   927: getfield 2847	com/tencent/mm/protocal/protobuf/bac:SLM	Lcom/tencent/mm/protocal/protobuf/bar;
    //   930: putfield 2847	com/tencent/mm/protocal/protobuf/bac:SLM	Lcom/tencent/mm/protocal/protobuf/bar;
    //   933: aload 14
    //   935: aload_2
    //   936: getfield 2850	com/tencent/mm/protocal/protobuf/auv:SGY	I
    //   939: putfield 2853	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfq	I
    //   942: aload_2
    //   943: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   946: astore 12
    //   948: aload 12
    //   950: ifnull +61 -> 1011
    //   953: aload 12
    //   955: getfield 2856	com/tencent/mm/protocal/protobuf/bac:SLO	I
    //   958: istore_0
    //   959: aload 14
    //   961: ldc_w 2858
    //   964: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   967: checkcast 2858	com/tencent/mm/plugin/finder/live/viewmodel/data/business/g
    //   970: getfield 2861	com/tencent/mm/plugin/finder/live/viewmodel/data/business/g:zif	Z
    //   973: ifne +38 -> 1011
    //   976: aload 14
    //   978: ldc_w 2858
    //   981: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   984: checkcast 2858	com/tencent/mm/plugin/finder/live/viewmodel/data/business/g
    //   987: astore 12
    //   989: iload_0
    //   990: iconst_1
    //   991: iand
    //   992: ifgt +9 -> 1001
    //   995: iload_0
    //   996: iconst_2
    //   997: iand
    //   998: ifle +4049 -> 5047
    //   1001: iconst_1
    //   1002: istore 9
    //   1004: aload 12
    //   1006: iload 9
    //   1008: putfield 2861	com/tencent/mm/plugin/finder/live/viewmodel/data/business/g:zif	Z
    //   1011: aload 11
    //   1013: getfield 2865	com/tencent/mm/protocal/protobuf/bac:SLW	Lcom/tencent/mm/protocal/protobuf/bag;
    //   1016: astore 13
    //   1018: aload 13
    //   1020: ifnull +127 -> 1147
    //   1023: aload 13
    //   1025: ldc_w 2867
    //   1028: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1031: getstatic 1273	com/tencent/mm/plugin/finder/live/utils/a:yRm	Lcom/tencent/mm/plugin/finder/live/utils/a;
    //   1034: astore 11
    //   1036: ldc_w 726
    //   1039: new 680	java/lang/StringBuilder
    //   1042: dup
    //   1043: ldc_w 2869
    //   1046: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1049: aload 13
    //   1051: getfield 2874	com/tencent/mm/protocal/protobuf/bag:CKC	I
    //   1054: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1057: ldc_w 2876
    //   1060: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload 13
    //   1065: getfield 2879	com/tencent/mm/protocal/protobuf/bag:SMj	I
    //   1068: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1071: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1074: invokestatic 2477	com/tencent/mm/plugin/finder/live/utils/a:ha	(Ljava/lang/String;Ljava/lang/String;)V
    //   1077: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   1080: ifeq +4285 -> 5365
    //   1083: aload 13
    //   1085: getfield 2874	com/tencent/mm/protocal/protobuf/bag:CKC	I
    //   1088: iconst_3
    //   1089: if_icmpne +4276 -> 5365
    //   1092: new 2881	com/tencent/mm/protocal/protobuf/baf
    //   1095: dup
    //   1096: invokespecial 2882	com/tencent/mm/protocal/protobuf/baf:<init>	()V
    //   1099: checkcast 2884	com/tencent/mm/cd/a
    //   1102: astore 12
    //   1104: aload 13
    //   1106: getfield 2887	com/tencent/mm/protocal/protobuf/bag:SMi	Lcom/tencent/mm/cd/b;
    //   1109: astore 11
    //   1111: aload 11
    //   1113: ifnull +3940 -> 5053
    //   1116: aload 11
    //   1118: invokevirtual 2888	com/tencent/mm/cd/b:toByteArray	()[B
    //   1121: astore 11
    //   1123: aload 12
    //   1125: aload 11
    //   1127: invokevirtual 2889	com/tencent/mm/cd/a:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   1130: pop
    //   1131: aload 12
    //   1133: astore 11
    //   1135: aload 11
    //   1137: checkcast 2881	com/tencent/mm/protocal/protobuf/baf
    //   1140: astore 11
    //   1142: aload 11
    //   1144: ifnonnull +3941 -> 5085
    //   1147: aload_2
    //   1148: getfield 2892	com/tencent/mm/protocal/protobuf/auv:LIS	Ljava/util/LinkedList;
    //   1151: astore 11
    //   1153: aload 11
    //   1155: astore 12
    //   1157: aload 11
    //   1159: ifnonnull +12 -> 1171
    //   1162: new 1585	java/util/LinkedList
    //   1165: dup
    //   1166: invokespecial 2893	java/util/LinkedList:<init>	()V
    //   1169: astore 12
    //   1171: aload_2
    //   1172: getfield 2896	com/tencent/mm/protocal/protobuf/auv:SGZ	Ljava/util/LinkedList;
    //   1175: astore 13
    //   1177: aload 13
    //   1179: astore 11
    //   1181: aload 13
    //   1183: ifnonnull +12 -> 1195
    //   1186: new 1585	java/util/LinkedList
    //   1189: dup
    //   1190: invokespecial 2893	java/util/LinkedList:<init>	()V
    //   1193: astore 11
    //   1195: invokestatic 2899	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   1198: astore 15
    //   1200: invokestatic 1497	com/tencent/mm/model/z:bdh	()Ljava/lang/String;
    //   1203: astore 16
    //   1205: getstatic 1215	com/tencent/mm/plugin/finder/live/model/ah:yds	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   1208: astore 13
    //   1210: aload 13
    //   1212: ifnull +205 -> 1417
    //   1215: getstatic 2905	com/tencent/mm/plugin/finder/live/model/aa:ygK	Lcom/tencent/mm/plugin/finder/live/model/aa;
    //   1218: astore 17
    //   1220: aload 13
    //   1222: aload 12
    //   1224: invokestatic 2908	com/tencent/mm/plugin/finder/live/model/aa:c	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;)V
    //   1227: getstatic 2905	com/tencent/mm/plugin/finder/live/model/aa:ygK	Lcom/tencent/mm/plugin/finder/live/model/aa;
    //   1230: astore 17
    //   1232: aload 13
    //   1234: aload 11
    //   1236: invokestatic 2910	com/tencent/mm/plugin/finder/live/model/aa:d	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;)V
    //   1239: getstatic 2905	com/tencent/mm/plugin/finder/live/model/aa:ygK	Lcom/tencent/mm/plugin/finder/live/model/aa;
    //   1242: astore 17
    //   1244: aload 13
    //   1246: aload 12
    //   1248: aload 11
    //   1250: getstatic 565	com/tencent/mm/plugin/finder/live/model/ah:yhj	I
    //   1253: aload 15
    //   1255: aload 16
    //   1257: invokestatic 2913	com/tencent/mm/plugin/finder/live/model/aa:a	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;Ljava/util/LinkedList;ILjava/lang/String;Ljava/lang/String;)V
    //   1260: getstatic 2905	com/tencent/mm/plugin/finder/live/model/aa:ygK	Lcom/tencent/mm/plugin/finder/live/model/aa;
    //   1263: astore 15
    //   1265: aload 13
    //   1267: aload 12
    //   1269: invokestatic 2915	com/tencent/mm/plugin/finder/live/model/aa:e	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;)V
    //   1272: getstatic 2905	com/tencent/mm/plugin/finder/live/model/aa:ygK	Lcom/tencent/mm/plugin/finder/live/model/aa;
    //   1275: astore 12
    //   1277: aload 13
    //   1279: aload 11
    //   1281: invokestatic 2917	com/tencent/mm/plugin/finder/live/model/aa:f	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;)V
    //   1284: getstatic 2905	com/tencent/mm/plugin/finder/live/model/aa:ygK	Lcom/tencent/mm/plugin/finder/live/model/aa;
    //   1287: astore 12
    //   1289: aload 13
    //   1291: aload 11
    //   1293: invokestatic 2919	com/tencent/mm/plugin/finder/live/model/aa:g	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;)V
    //   1296: getstatic 2905	com/tencent/mm/plugin/finder/live/model/aa:ygK	Lcom/tencent/mm/plugin/finder/live/model/aa;
    //   1299: astore 12
    //   1301: aload 13
    //   1303: aload 11
    //   1305: invokestatic 2921	com/tencent/mm/plugin/finder/live/model/aa:h	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;)V
    //   1308: getstatic 2905	com/tencent/mm/plugin/finder/live/model/aa:ygK	Lcom/tencent/mm/plugin/finder/live/model/aa;
    //   1311: astore 12
    //   1313: aload 13
    //   1315: aload 11
    //   1317: invokestatic 2923	com/tencent/mm/plugin/finder/live/model/aa:i	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;)V
    //   1320: ldc_w 726
    //   1323: new 680	java/lang/StringBuilder
    //   1326: dup
    //   1327: ldc_w 2925
    //   1330: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1333: aload 13
    //   1335: ldc_w 2927
    //   1338: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1341: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   1344: getfield 2930	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:zir	Ljava/util/List;
    //   1347: invokeinterface 2931 1 0
    //   1352: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1355: ldc_w 2933
    //   1358: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: aload 13
    //   1363: ldc_w 2927
    //   1366: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1369: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   1372: getfield 2936	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:ziq	Ljava/util/List;
    //   1375: invokeinterface 2931 1 0
    //   1380: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1383: ldc_w 2938
    //   1386: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: aload 13
    //   1391: ldc_w 2927
    //   1394: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1397: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   1400: getfield 2941	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:zis	Ljava/util/List;
    //   1403: invokeinterface 2931 1 0
    //   1408: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1411: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1414: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1417: aload_2
    //   1418: getfield 2896	com/tencent/mm/protocal/protobuf/auv:SGZ	Ljava/util/LinkedList;
    //   1421: astore 12
    //   1423: getstatic 1215	com/tencent/mm/plugin/finder/live/model/ah:yds	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   1426: astore 13
    //   1428: aload 13
    //   1430: ifnull +153 -> 1583
    //   1433: getstatic 2947	com/tencent/mm/plugin/finder/live/model/d:ydx	Lcom/tencent/mm/plugin/finder/live/model/d;
    //   1436: astore 11
    //   1438: aload 13
    //   1440: aload 12
    //   1442: invokestatic 2949	com/tencent/mm/plugin/finder/live/model/d:a	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;)V
    //   1445: getstatic 2905	com/tencent/mm/plugin/finder/live/model/aa:ygK	Lcom/tencent/mm/plugin/finder/live/model/aa;
    //   1448: astore 11
    //   1450: aload 12
    //   1452: astore 11
    //   1454: aload 12
    //   1456: ifnonnull +12 -> 1468
    //   1459: new 1585	java/util/LinkedList
    //   1462: dup
    //   1463: invokespecial 2893	java/util/LinkedList:<init>	()V
    //   1466: astore 11
    //   1468: aload 13
    //   1470: ldc_w 1626
    //   1473: invokestatic 911	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1476: aload 11
    //   1478: ldc_w 2950
    //   1481: invokestatic 911	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1484: aload 13
    //   1486: ldc_w 916
    //   1489: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1492: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   1495: getfield 2954	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zeW	Lcom/tencent/mm/plugin/finder/live/util/p;
    //   1498: aload 11
    //   1500: checkcast 789	java/lang/Iterable
    //   1503: invokestatic 2958	kotlin/a/j:z	(Ljava/lang/Iterable;)Lkotlin/m/h;
    //   1506: getstatic 2964	com/tencent/mm/plugin/finder/live/model/aa$a:ygL	Lcom/tencent/mm/plugin/finder/live/model/aa$a;
    //   1509: checkcast 2046	kotlin/g/a/b
    //   1512: invokestatic 2969	kotlin/m/i:a	(Lkotlin/m/h;Lkotlin/g/a/b;)Lkotlin/m/h;
    //   1515: new 2971	com/tencent/mm/plugin/finder/live/model/aa$b
    //   1518: dup
    //   1519: aload 13
    //   1521: invokespecial 2972	com/tencent/mm/plugin/finder/live/model/aa$b:<init>	(Lcom/tencent/mm/plugin/finder/live/model/context/a;)V
    //   1524: checkcast 2046	kotlin/g/a/b
    //   1527: invokestatic 2974	kotlin/m/i:d	(Lkotlin/m/h;Lkotlin/g/a/b;)Lkotlin/m/h;
    //   1530: invokestatic 2977	kotlin/m/i:d	(Lkotlin/m/h;)Ljava/util/List;
    //   1533: checkcast 1813	java/util/Collection
    //   1536: invokeinterface 2983 2 0
    //   1541: pop
    //   1542: ldc_w 726
    //   1545: new 680	java/lang/StringBuilder
    //   1548: dup
    //   1549: ldc_w 2985
    //   1552: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1555: aload 13
    //   1557: ldc_w 916
    //   1560: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1563: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   1566: getfield 2954	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zeW	Lcom/tencent/mm/plugin/finder/live/util/p;
    //   1569: invokeinterface 2986 1 0
    //   1574: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1577: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1583: aload_2
    //   1584: getfield 2989	com/tencent/mm/protocal/protobuf/auv:SHa	Ljava/util/LinkedList;
    //   1587: astore 11
    //   1589: getstatic 1215	com/tencent/mm/plugin/finder/live/model/ah:yds	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   1592: astore 12
    //   1594: aload 12
    //   1596: ifnull +15 -> 1611
    //   1599: getstatic 2947	com/tencent/mm/plugin/finder/live/model/d:ydx	Lcom/tencent/mm/plugin/finder/live/model/d;
    //   1602: astore 13
    //   1604: aload 12
    //   1606: aload 11
    //   1608: invokestatic 2991	com/tencent/mm/plugin/finder/live/model/d:b	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;)V
    //   1611: aload_2
    //   1612: getfield 2896	com/tencent/mm/protocal/protobuf/auv:SGZ	Ljava/util/LinkedList;
    //   1615: astore 11
    //   1617: aload 11
    //   1619: ifnonnull +5267 -> 6886
    //   1622: new 1585	java/util/LinkedList
    //   1625: dup
    //   1626: invokespecial 2893	java/util/LinkedList:<init>	()V
    //   1629: astore 11
    //   1631: ldc_w 720
    //   1634: invokestatic 699	com/tencent/mm/plugin/finder/live/model/ah:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1637: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   1640: astore 12
    //   1642: aload 12
    //   1644: ifnull +72 -> 1716
    //   1647: aload 11
    //   1649: ldc_w 2992
    //   1652: invokestatic 911	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1655: aload 12
    //   1657: aload 12
    //   1659: getfield 2997	com/tencent/mm/plugin/finder/live/viewmodel/data/business/a:zeV	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   1662: aload 11
    //   1664: invokevirtual 2999	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:j	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/util/LinkedList;)V
    //   1667: aload 12
    //   1669: aload 11
    //   1671: invokevirtual 3003	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:ay	(Ljava/util/LinkedList;)V
    //   1674: aload 12
    //   1676: aload 11
    //   1678: invokevirtual 3006	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:az	(Ljava/util/LinkedList;)V
    //   1681: aload 12
    //   1683: aload 11
    //   1685: invokevirtual 3009	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:aA	(Ljava/util/LinkedList;)V
    //   1688: aload 12
    //   1690: aload 11
    //   1692: invokevirtual 3012	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:aB	(Ljava/util/LinkedList;)V
    //   1695: aload 12
    //   1697: aload 11
    //   1699: invokevirtual 3015	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:aC	(Ljava/util/LinkedList;)V
    //   1702: aload 12
    //   1704: aload 11
    //   1706: invokevirtual 3018	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:aD	(Ljava/util/LinkedList;)V
    //   1709: aload 12
    //   1711: aload 11
    //   1713: invokevirtual 3021	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:aE	(Ljava/util/LinkedList;)V
    //   1716: aload_2
    //   1717: getfield 3022	com/tencent/mm/protocal/protobuf/auv:xak	Lcom/tencent/mm/cd/b;
    //   1720: astore 12
    //   1722: aload 12
    //   1724: ifnull +74 -> 1798
    //   1727: ldc_w 916
    //   1730: invokestatic 699	com/tencent/mm/plugin/finder/live/model/ah:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1733: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   1736: astore 11
    //   1738: aload 11
    //   1740: ifnull +4013 -> 5753
    //   1743: aload 11
    //   1745: getfield 3026	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfS	Lcom/tencent/mm/protocal/protobuf/axc;
    //   1748: astore 11
    //   1750: aload 11
    //   1752: ifnull +4001 -> 5753
    //   1755: aload 11
    //   1757: getfield 3031	com/tencent/mm/protocal/protobuf/axc:SJy	I
    //   1760: invokestatic 1833	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1763: astore 11
    //   1765: aload 11
    //   1767: ifnull +12 -> 1779
    //   1770: iload_3
    //   1771: aload 11
    //   1773: invokevirtual 1333	java/lang/Integer:intValue	()I
    //   1776: if_icmpne +3983 -> 5759
    //   1779: aload 14
    //   1781: ldc_w 696
    //   1784: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1787: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   1790: aload 12
    //   1792: getfield 2465	com/tencent/mm/cd/b:UH	[B
    //   1795: putfield 2468	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:kvN	[B
    //   1798: aload_2
    //   1799: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   1802: astore 11
    //   1804: aload 11
    //   1806: ifnull +1808 -> 3614
    //   1809: aload 11
    //   1811: getfield 3035	com/tencent/mm/protocal/protobuf/bac:SLL	Lcom/tencent/mm/protocal/protobuf/azf;
    //   1814: astore 11
    //   1816: aload 11
    //   1818: ifnull +1796 -> 3614
    //   1821: aload 11
    //   1823: getfield 3040	com/tencent/mm/protocal/protobuf/azf:SLc	Lcom/tencent/mm/cd/b;
    //   1826: astore 12
    //   1828: aload 12
    //   1830: ifnull +1784 -> 3614
    //   1833: new 3042	com/tencent/mm/protocal/protobuf/crm
    //   1836: dup
    //   1837: invokespecial 3043	com/tencent/mm/protocal/protobuf/crm:<init>	()V
    //   1840: checkcast 2884	com/tencent/mm/cd/a
    //   1843: astore 11
    //   1845: aload 12
    //   1847: ldc_w 2867
    //   1850: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1853: aload 12
    //   1855: getfield 2465	com/tencent/mm/cd/b:UH	[B
    //   1858: astore 12
    //   1860: aload 11
    //   1862: aload 12
    //   1864: invokevirtual 2889	com/tencent/mm/cd/a:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   1867: pop
    //   1868: aload 11
    //   1870: checkcast 3042	com/tencent/mm/protocal/protobuf/crm
    //   1873: astore 12
    //   1875: new 680	java/lang/StringBuilder
    //   1878: dup
    //   1879: ldc_w 3045
    //   1882: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1885: astore 13
    //   1887: aload 12
    //   1889: ifnull +3971 -> 5860
    //   1892: aload 12
    //   1894: getfield 3048	com/tencent/mm/protocal/protobuf/crm:Tyz	J
    //   1897: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1900: astore 11
    //   1902: aload 13
    //   1904: aload 11
    //   1906: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1909: ldc_w 3050
    //   1912: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: astore 13
    //   1917: aload 12
    //   1919: ifnull +3947 -> 5866
    //   1922: aload 12
    //   1924: getfield 3054	com/tencent/mm/protocal/protobuf/crm:SEm	Lcom/tencent/mm/protocal/protobuf/cxh;
    //   1927: astore 11
    //   1929: aload 11
    //   1931: ifnull +3935 -> 5866
    //   1934: aload 11
    //   1936: getfield 3059	com/tencent/mm/protocal/protobuf/cxh:TFP	J
    //   1939: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1942: astore 11
    //   1944: aload 13
    //   1946: aload 11
    //   1948: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1951: ldc_w 3061
    //   1954: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: astore 13
    //   1959: aload 12
    //   1961: ifnull +3911 -> 5872
    //   1964: aload 12
    //   1966: getfield 3054	com/tencent/mm/protocal/protobuf/crm:SEm	Lcom/tencent/mm/protocal/protobuf/cxh;
    //   1969: astore 11
    //   1971: aload 11
    //   1973: ifnull +3899 -> 5872
    //   1976: aload 11
    //   1978: getfield 3064	com/tencent/mm/protocal/protobuf/cxh:TFQ	J
    //   1981: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1984: astore 11
    //   1986: ldc_w 726
    //   1989: aload 13
    //   1991: aload 11
    //   1993: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1996: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1999: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2002: aload 12
    //   2004: ifnull +1610 -> 3614
    //   2007: getstatic 1215	com/tencent/mm/plugin/finder/live/model/ah:yds	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   2010: astore 13
    //   2012: aload 12
    //   2014: getfield 3048	com/tencent/mm/protocal/protobuf/crm:Tyz	J
    //   2017: lstore 5
    //   2019: new 680	java/lang/StringBuilder
    //   2022: dup
    //   2023: ldc_w 3066
    //   2026: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2029: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   2032: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2035: ldc_w 3068
    //   2038: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2041: lload 5
    //   2043: invokevirtual 689	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2046: ldc_w 3070
    //   2049: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2052: astore 15
    //   2054: aload 13
    //   2056: ifnull +3822 -> 5878
    //   2059: aload 13
    //   2061: ldc_w 916
    //   2064: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2067: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   2070: astore 11
    //   2072: aload 11
    //   2074: ifnull +3804 -> 5878
    //   2077: aload 11
    //   2079: getfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   2082: invokestatic 1833	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2085: astore 11
    //   2087: ldc_w 726
    //   2090: aload 15
    //   2092: aload 11
    //   2094: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2097: ldc_w 3072
    //   2100: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2103: getstatic 597	com/tencent/mm/plugin/finder/live/model/ah:yhp	Z
    //   2106: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2109: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2112: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2115: aload 13
    //   2117: ifnull +99 -> 2216
    //   2120: getstatic 597	com/tencent/mm/plugin/finder/live/model/ah:yhp	Z
    //   2123: ifne +93 -> 2216
    //   2126: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   2129: ifne +87 -> 2216
    //   2132: aload 13
    //   2134: ldc_w 916
    //   2137: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2140: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   2143: getfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   2146: i2l
    //   2147: lload 5
    //   2149: lcmp
    //   2150: ifeq +66 -> 2216
    //   2153: aload 13
    //   2155: ldc_w 916
    //   2158: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2161: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   2164: getfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   2167: iconst_2
    //   2168: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   2171: ifne +3713 -> 5884
    //   2174: lload 5
    //   2176: l2i
    //   2177: iconst_2
    //   2178: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   2181: ifeq +3703 -> 5884
    //   2184: ldc_w 726
    //   2187: ldc_w 3074
    //   2190: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2193: getstatic 2397	com/tencent/mm/live/b/p:kvF	Lcom/tencent/mm/live/b/p;
    //   2196: astore 11
    //   2198: invokestatic 2401	com/tencent/mm/live/b/p:aOe	()Lcom/tencent/mm/live/b/g;
    //   2201: astore 11
    //   2203: aload 11
    //   2205: ifnull +11 -> 2216
    //   2208: aload 11
    //   2210: iconst_1
    //   2211: invokeinterface 3077 2 0
    //   2216: aload 12
    //   2218: ldc_w 3079
    //   2221: invokestatic 911	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2224: aload 12
    //   2226: getfield 3048	com/tencent/mm/protocal/protobuf/crm:Tyz	J
    //   2229: lstore 7
    //   2231: aload 14
    //   2233: ldc_w 720
    //   2236: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2239: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2242: astore 13
    //   2244: aload 12
    //   2246: ldc_w 3079
    //   2249: invokestatic 911	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2252: aload 12
    //   2254: getfield 3054	com/tencent/mm/protocal/protobuf/crm:SEm	Lcom/tencent/mm/protocal/protobuf/cxh;
    //   2257: astore 11
    //   2259: aload 13
    //   2261: ldc_w 720
    //   2264: invokevirtual 3080	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2267: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2270: getfield 3083	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhs	Z
    //   2273: ifeq +3688 -> 5961
    //   2276: aload 13
    //   2278: ldc_w 720
    //   2281: invokevirtual 3080	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2284: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2287: getfield 3086	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zht	Z
    //   2290: ifeq +3671 -> 5961
    //   2293: lload 7
    //   2295: l2i
    //   2296: bipush 64
    //   2298: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   2301: istore 10
    //   2303: aload 13
    //   2305: ldc_w 720
    //   2308: invokevirtual 3080	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2311: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2314: getfield 3089	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhq	I
    //   2317: iconst_1
    //   2318: if_icmpne +3632 -> 5950
    //   2321: iconst_1
    //   2322: istore 9
    //   2324: iload 10
    //   2326: iload 9
    //   2328: if_icmpeq +29 -> 2357
    //   2331: aload 13
    //   2333: ldc_w 720
    //   2336: invokevirtual 3080	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2339: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2342: getfield 3089	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhq	I
    //   2345: iconst_m1
    //   2346: if_icmpeq +11 -> 2357
    //   2349: aload 13
    //   2351: getfield 2997	com/tencent/mm/plugin/finder/live/viewmodel/data/business/a:zeV	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   2354: invokestatic 3092	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:p	(Lcom/tencent/mm/plugin/finder/live/model/context/a;)V
    //   2357: aload 13
    //   2359: ldc_w 720
    //   2362: invokevirtual 3080	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2365: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2368: astore 15
    //   2370: iload 10
    //   2372: ifeq +3584 -> 5956
    //   2375: iconst_1
    //   2376: istore_0
    //   2377: aload 15
    //   2379: iload_0
    //   2380: putfield 3089	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhq	I
    //   2383: aload 11
    //   2385: ifnull +3594 -> 5979
    //   2388: aload 11
    //   2390: getfield 3059	com/tencent/mm/protocal/protobuf/cxh:TFP	J
    //   2393: lstore 5
    //   2395: lload 5
    //   2397: aload 13
    //   2399: getfield 3095	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhx	Lcom/tencent/mm/protocal/protobuf/cxh;
    //   2402: getfield 3059	com/tencent/mm/protocal/protobuf/cxh:TFP	J
    //   2405: lcmp
    //   2406: ifeq +38 -> 2444
    //   2409: aload 13
    //   2411: getfield 3095	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhx	Lcom/tencent/mm/protocal/protobuf/cxh;
    //   2414: lload 5
    //   2416: putfield 3059	com/tencent/mm/protocal/protobuf/cxh:TFP	J
    //   2419: aload 13
    //   2421: ldc_w 916
    //   2424: invokevirtual 3080	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2427: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   2430: invokevirtual 3098	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:bvS	()Z
    //   2433: ifne +11 -> 2444
    //   2436: aload 13
    //   2438: getfield 2997	com/tencent/mm/plugin/finder/live/viewmodel/data/business/a:zeV	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   2441: invokestatic 3100	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:g	(Lcom/tencent/mm/plugin/finder/live/model/context/a;)V
    //   2444: new 680	java/lang/StringBuilder
    //   2447: dup
    //   2448: ldc_w 3102
    //   2451: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2454: lload 7
    //   2456: invokevirtual 689	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2459: ldc_w 3050
    //   2462: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2465: astore 13
    //   2467: aload 11
    //   2469: ifnull +3516 -> 5985
    //   2472: aload 11
    //   2474: getfield 3059	com/tencent/mm/protocal/protobuf/cxh:TFP	J
    //   2477: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2480: astore 11
    //   2482: ldc_w 3104
    //   2485: aload 13
    //   2487: aload 11
    //   2489: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2492: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2495: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2498: lload 7
    //   2500: l2i
    //   2501: bipush 8
    //   2503: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   2506: ifne +3485 -> 5991
    //   2509: iconst_1
    //   2510: istore 9
    //   2512: aload 14
    //   2514: iload 9
    //   2516: putfield 3107	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfd	Z
    //   2519: lload 7
    //   2521: l2i
    //   2522: sipush 512
    //   2525: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   2528: ifne +3469 -> 5997
    //   2531: iconst_1
    //   2532: istore 10
    //   2534: iload 10
    //   2536: aload 14
    //   2538: getfield 3110	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zff	Z
    //   2541: if_icmpeq +112 -> 2653
    //   2544: aload 14
    //   2546: ldc_w 2927
    //   2549: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2552: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   2555: astore 13
    //   2557: iload 10
    //   2559: ifeq +3444 -> 6003
    //   2562: invokestatic 1405	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2565: astore 11
    //   2567: aload 11
    //   2569: ldc_w 1407
    //   2572: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2575: aload 11
    //   2577: invokevirtual 3114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2580: getstatic 3119	com/tencent/mm/x/a/a/a$a:finder_live_like_anchor_enable	I
    //   2583: invokevirtual 3124	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2586: astore 11
    //   2588: aload 11
    //   2590: ldc_w 3126
    //   2593: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2596: new 3128	com/tencent/mm/protocal/protobuf/bbd
    //   2599: dup
    //   2600: invokespecial 3129	com/tencent/mm/protocal/protobuf/bbd:<init>	()V
    //   2603: astore 15
    //   2605: aload 15
    //   2607: aload 11
    //   2609: putfield 3132	com/tencent/mm/protocal/protobuf/bbd:content	Ljava/lang/String;
    //   2612: aload 15
    //   2614: sipush 10001
    //   2617: putfield 3135	com/tencent/mm/protocal/protobuf/bbd:type	I
    //   2620: new 3137	com/tencent/mm/plugin/finder/live/model/ak
    //   2623: dup
    //   2624: aload 15
    //   2626: invokespecial 3140	com/tencent/mm/plugin/finder/live/model/ak:<init>	(Lcom/tencent/mm/protocal/protobuf/bbd;)V
    //   2629: astore 11
    //   2631: aload 13
    //   2633: ldc_w 2927
    //   2636: invokevirtual 3141	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2639: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   2642: getfield 2936	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:ziq	Ljava/util/List;
    //   2645: aload 11
    //   2647: invokeinterface 3145 2 0
    //   2652: pop
    //   2653: aload 14
    //   2655: iload 10
    //   2657: putfield 3110	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zff	Z
    //   2660: aload 14
    //   2662: iload 9
    //   2664: invokestatic 1141	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2667: putfield 3148	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfM	Ljava/lang/Boolean;
    //   2670: aload 14
    //   2672: lload 7
    //   2674: l2i
    //   2675: bipush 32
    //   2677: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   2680: putfield 3151	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfl	Z
    //   2683: iload 9
    //   2685: aload 14
    //   2687: getfield 3107	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfd	Z
    //   2690: if_icmpeq +168 -> 2858
    //   2693: aload 14
    //   2695: ldc_w 2927
    //   2698: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2701: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   2704: astore 13
    //   2706: iload 9
    //   2708: ifeq +3324 -> 6032
    //   2711: invokestatic 1405	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2714: astore 11
    //   2716: aload 11
    //   2718: ldc_w 1407
    //   2721: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2724: aload 11
    //   2726: invokevirtual 3114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2729: getstatic 3154	com/tencent/mm/x/a/a/a$a:finder_live_comment_anchor_enable	I
    //   2732: invokevirtual 3124	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2735: astore 11
    //   2737: aload 11
    //   2739: ldc_w 3156
    //   2742: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2745: new 3128	com/tencent/mm/protocal/protobuf/bbd
    //   2748: dup
    //   2749: invokespecial 3129	com/tencent/mm/protocal/protobuf/bbd:<init>	()V
    //   2752: astore 15
    //   2754: new 3158	com/tencent/mm/protocal/protobuf/aza
    //   2757: dup
    //   2758: invokespecial 3159	com/tencent/mm/protocal/protobuf/aza:<init>	()V
    //   2761: astore 16
    //   2763: new 3161	com/tencent/mm/protocal/protobuf/FinderContact
    //   2766: dup
    //   2767: invokespecial 3162	com/tencent/mm/protocal/protobuf/FinderContact:<init>	()V
    //   2770: astore 17
    //   2772: aload 17
    //   2774: ldc_w 546
    //   2777: putfield 3165	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   2780: aload 17
    //   2782: ldc_w 546
    //   2785: putfield 3168	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   2788: aload 17
    //   2790: ldc_w 546
    //   2793: putfield 3171	com/tencent/mm/protocal/protobuf/FinderContact:headUrl	Ljava/lang/String;
    //   2796: aload 16
    //   2798: aload 17
    //   2800: putfield 3175	com/tencent/mm/protocal/protobuf/aza:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   2803: aload 15
    //   2805: aload 16
    //   2807: putfield 3179	com/tencent/mm/protocal/protobuf/bbd:zeL	Lcom/tencent/mm/protocal/protobuf/aza;
    //   2810: aload 15
    //   2812: aload 11
    //   2814: putfield 3132	com/tencent/mm/protocal/protobuf/bbd:content	Ljava/lang/String;
    //   2817: aload 15
    //   2819: sipush 10006
    //   2822: putfield 3135	com/tencent/mm/protocal/protobuf/bbd:type	I
    //   2825: new 3137	com/tencent/mm/plugin/finder/live/model/ak
    //   2828: dup
    //   2829: aload 15
    //   2831: invokespecial 3140	com/tencent/mm/plugin/finder/live/model/ak:<init>	(Lcom/tencent/mm/protocal/protobuf/bbd;)V
    //   2834: astore 11
    //   2836: aload 13
    //   2838: ldc_w 2927
    //   2841: invokevirtual 3141	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2844: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   2847: getfield 2936	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:ziq	Ljava/util/List;
    //   2850: aload 11
    //   2852: invokeinterface 3145 2 0
    //   2857: pop
    //   2858: lload 7
    //   2860: l2i
    //   2861: bipush 16
    //   2863: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   2866: istore 9
    //   2868: aload 14
    //   2870: ldc_w 2568
    //   2873: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2876: checkcast 2568	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2879: aload 14
    //   2881: ldc_w 2568
    //   2884: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2887: checkcast 2568	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2890: getfield 3182	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:ziH	Z
    //   2893: iload 9
    //   2895: ior
    //   2896: putfield 3182	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:ziH	Z
    //   2899: aload 14
    //   2901: getfield 3185	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfH	Z
    //   2904: ifeq +3191 -> 6095
    //   2907: aload 14
    //   2909: getfield 3188	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfJ	Z
    //   2912: ifeq +3183 -> 6095
    //   2915: lload 7
    //   2917: l2i
    //   2918: sipush 128
    //   2921: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   2924: istore 10
    //   2926: iload 10
    //   2928: aload 14
    //   2930: invokevirtual 3191	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:dGF	()Z
    //   2933: if_icmpeq +156 -> 3089
    //   2936: aload 14
    //   2938: getfield 3194	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfG	I
    //   2941: iconst_m1
    //   2942: if_icmpeq +147 -> 3089
    //   2945: aload 14
    //   2947: getfield 2997	com/tencent/mm/plugin/finder/live/viewmodel/data/business/a:zeV	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   2950: astore 13
    //   2952: aload 13
    //   2954: ifnull +135 -> 3089
    //   2957: new 3128	com/tencent/mm/protocal/protobuf/bbd
    //   2960: dup
    //   2961: invokespecial 3129	com/tencent/mm/protocal/protobuf/bbd:<init>	()V
    //   2964: astore 15
    //   2966: aload 15
    //   2968: sipush 10001
    //   2971: putfield 3135	com/tencent/mm/protocal/protobuf/bbd:type	I
    //   2974: aload 13
    //   2976: ldc_w 916
    //   2979: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   2982: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   2985: invokevirtual 3191	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:dGF	()Z
    //   2988: ifne +3073 -> 6061
    //   2991: invokestatic 1405	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2994: astore 11
    //   2996: aload 11
    //   2998: ldc_w 1407
    //   3001: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3004: aload 11
    //   3006: invokevirtual 3114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   3009: getstatic 3197	com/tencent/mm/x/a/a/a$a:finder_live_gift_enable_msg_tip	I
    //   3012: invokevirtual 3124	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   3015: astore 11
    //   3017: aload 15
    //   3019: aload 11
    //   3021: putfield 3132	com/tencent/mm/protocal/protobuf/bbd:content	Ljava/lang/String;
    //   3024: new 3137	com/tencent/mm/plugin/finder/live/model/ak
    //   3027: dup
    //   3028: aload 15
    //   3030: invokespecial 3140	com/tencent/mm/plugin/finder/live/model/ak:<init>	(Lcom/tencent/mm/protocal/protobuf/bbd;)V
    //   3033: astore 11
    //   3035: aload 13
    //   3037: ldc_w 2927
    //   3040: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3043: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   3046: getfield 2936	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:ziq	Ljava/util/List;
    //   3049: aload 11
    //   3051: invokeinterface 3145 2 0
    //   3056: pop
    //   3057: aload 14
    //   3059: getfield 3198	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:TAG	Ljava/lang/String;
    //   3062: new 680	java/lang/StringBuilder
    //   3065: dup
    //   3066: ldc_w 3200
    //   3069: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3072: aload 11
    //   3074: getfield 3204	com/tencent/mm/plugin/finder/live/model/ak:yig	Lcom/tencent/mm/protocal/protobuf/bbd;
    //   3077: getfield 3132	com/tencent/mm/protocal/protobuf/bbd:content	Ljava/lang/String;
    //   3080: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3083: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3086: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3089: iload 10
    //   3091: ifeq +2999 -> 6090
    //   3094: iconst_1
    //   3095: istore_0
    //   3096: aload 14
    //   3098: iload_0
    //   3099: putfield 3194	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfG	I
    //   3102: lload 7
    //   3104: l2i
    //   3105: sipush 256
    //   3108: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   3111: istore 10
    //   3113: iload 10
    //   3115: aload 14
    //   3117: invokevirtual 3207	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:dGH	()Z
    //   3120: if_icmpeq +156 -> 3276
    //   3123: aload 14
    //   3125: getfield 3210	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zgm	I
    //   3128: iconst_m1
    //   3129: if_icmpeq +147 -> 3276
    //   3132: aload 14
    //   3134: getfield 2997	com/tencent/mm/plugin/finder/live/viewmodel/data/business/a:zeV	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   3137: astore 13
    //   3139: aload 13
    //   3141: ifnull +135 -> 3276
    //   3144: new 3128	com/tencent/mm/protocal/protobuf/bbd
    //   3147: dup
    //   3148: invokespecial 3129	com/tencent/mm/protocal/protobuf/bbd:<init>	()V
    //   3151: astore 15
    //   3153: aload 15
    //   3155: sipush 10001
    //   3158: putfield 3135	com/tencent/mm/protocal/protobuf/bbd:type	I
    //   3161: aload 13
    //   3163: ldc_w 916
    //   3166: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3169: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   3172: invokevirtual 3207	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:dGH	()Z
    //   3175: ifne +2929 -> 6104
    //   3178: invokestatic 1405	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3181: astore 11
    //   3183: aload 11
    //   3185: ldc_w 1407
    //   3188: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3191: aload 11
    //   3193: invokevirtual 3114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   3196: getstatic 3213	com/tencent/mm/x/a/a/a$a:finder_live_camera_disable_msg_tip	I
    //   3199: invokevirtual 3124	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   3202: astore 11
    //   3204: aload 15
    //   3206: aload 11
    //   3208: putfield 3132	com/tencent/mm/protocal/protobuf/bbd:content	Ljava/lang/String;
    //   3211: new 3137	com/tencent/mm/plugin/finder/live/model/ak
    //   3214: dup
    //   3215: aload 15
    //   3217: invokespecial 3140	com/tencent/mm/plugin/finder/live/model/ak:<init>	(Lcom/tencent/mm/protocal/protobuf/bbd;)V
    //   3220: astore 11
    //   3222: aload 13
    //   3224: ldc_w 2927
    //   3227: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3230: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   3233: getfield 2936	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:ziq	Ljava/util/List;
    //   3236: aload 11
    //   3238: invokeinterface 3145 2 0
    //   3243: pop
    //   3244: aload 14
    //   3246: getfield 3198	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:TAG	Ljava/lang/String;
    //   3249: new 680	java/lang/StringBuilder
    //   3252: dup
    //   3253: ldc_w 3215
    //   3256: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3259: aload 11
    //   3261: getfield 3204	com/tencent/mm/plugin/finder/live/model/ak:yig	Lcom/tencent/mm/protocal/protobuf/bbd;
    //   3264: getfield 3132	com/tencent/mm/protocal/protobuf/bbd:content	Ljava/lang/String;
    //   3267: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3270: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3273: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3276: iload 10
    //   3278: ifeq +2855 -> 6133
    //   3281: iconst_1
    //   3282: istore_0
    //   3283: aload 14
    //   3285: iload_0
    //   3286: putfield 3210	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zgm	I
    //   3289: aload 12
    //   3291: getfield 3219	com/tencent/mm/protocal/protobuf/crm:TyA	Lcom/tencent/mm/protocal/protobuf/bnp;
    //   3294: ifnull +154 -> 3448
    //   3297: aload 14
    //   3299: getfield 3223	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfD	Lcom/tencent/mm/protocal/protobuf/azh;
    //   3302: ifnull +146 -> 3448
    //   3305: aload 12
    //   3307: getfield 3219	com/tencent/mm/protocal/protobuf/crm:TyA	Lcom/tencent/mm/protocal/protobuf/bnp;
    //   3310: astore 11
    //   3312: aload 11
    //   3314: ifnull +2824 -> 6138
    //   3317: aload 11
    //   3319: getfield 3228	com/tencent/mm/protocal/protobuf/bnp:SYJ	I
    //   3322: invokestatic 1833	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3325: astore 11
    //   3327: aload 14
    //   3329: getfield 3223	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfD	Lcom/tencent/mm/protocal/protobuf/azh;
    //   3332: astore 12
    //   3334: aload 12
    //   3336: ifnull +2808 -> 6144
    //   3339: aload 12
    //   3341: getfield 3233	com/tencent/mm/protocal/protobuf/azh:SLe	I
    //   3344: invokestatic 1833	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3347: astore 12
    //   3349: aload 14
    //   3351: getfield 3198	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:TAG	Ljava/lang/String;
    //   3354: new 680	java/lang/StringBuilder
    //   3357: dup
    //   3358: ldc_w 3235
    //   3361: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3364: aload 12
    //   3366: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3369: ldc_w 3237
    //   3372: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3375: aload 11
    //   3377: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3380: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3383: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3386: aload 12
    //   3388: aload 11
    //   3390: invokestatic 1546	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3393: iconst_1
    //   3394: ixor
    //   3395: ifeq +53 -> 3448
    //   3398: aload 14
    //   3400: getfield 3223	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfD	Lcom/tencent/mm/protocal/protobuf/azh;
    //   3403: astore 13
    //   3405: aload 13
    //   3407: ifnull +13 -> 3420
    //   3410: aload 13
    //   3412: aload 11
    //   3414: invokevirtual 1333	java/lang/Integer:intValue	()I
    //   3417: putfield 3233	com/tencent/mm/protocal/protobuf/azh:SLe	I
    //   3420: aload 14
    //   3422: invokevirtual 3098	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:bvS	()Z
    //   3425: ifne +23 -> 3448
    //   3428: aload 12
    //   3430: ifnonnull +2720 -> 6150
    //   3433: aload 12
    //   3435: ifnonnull +2974 -> 6409
    //   3438: aload 11
    //   3440: ifnonnull +2980 -> 6420
    //   3443: aload 11
    //   3445: ifnonnull +2987 -> 6432
    //   3448: aload 14
    //   3450: lload 7
    //   3452: l2i
    //   3453: putfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   3456: aload 14
    //   3458: getfield 3198	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:TAG	Ljava/lang/String;
    //   3461: new 680	java/lang/StringBuilder
    //   3464: dup
    //   3465: ldc_w 3102
    //   3468: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3471: lload 7
    //   3473: invokevirtual 689	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3476: ldc_w 3239
    //   3479: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3482: aload 14
    //   3484: getfield 3107	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfd	Z
    //   3487: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3490: ldc_w 3241
    //   3493: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3496: aload 14
    //   3498: getfield 3151	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfl	Z
    //   3501: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3504: ldc_w 3243
    //   3507: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3510: iload 9
    //   3512: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3515: ldc_w 3245
    //   3518: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3521: aload 14
    //   3523: ldc_w 2568
    //   3526: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3529: checkcast 2568	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3532: getfield 3182	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:ziH	Z
    //   3535: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3538: ldc_w 3247
    //   3541: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3544: aload 14
    //   3546: ldc_w 720
    //   3549: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3552: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   3555: invokevirtual 3250	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:dHd	()Z
    //   3558: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3561: ldc_w 3252
    //   3564: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3567: aload 14
    //   3569: invokevirtual 3191	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:dGF	()Z
    //   3572: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3575: ldc_w 3254
    //   3578: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3581: aload 14
    //   3583: getfield 3257	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zgq	Z
    //   3586: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3589: ldc_w 3259
    //   3592: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3595: aload 14
    //   3597: getfield 3210	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zgm	I
    //   3600: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3603: bipush 125
    //   3605: invokevirtual 1769	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3608: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3611: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3614: aload 14
    //   3616: ldc_w 2927
    //   3619: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3622: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   3625: astore 11
    //   3627: aload_2
    //   3628: getfield 2892	com/tencent/mm/protocal/protobuf/auv:LIS	Ljava/util/LinkedList;
    //   3631: astore 12
    //   3633: aload 12
    //   3635: ldc_w 3261
    //   3638: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3641: aload 11
    //   3643: aload 12
    //   3645: invokevirtual 3264	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:aH	(Ljava/util/LinkedList;)V
    //   3648: getstatic 3270	com/tencent/mm/live/b/j:kue	Lcom/tencent/mm/live/b/j;
    //   3651: astore 11
    //   3653: invokestatic 3273	com/tencent/mm/live/b/j:aNv	()V
    //   3656: getstatic 1215	com/tencent/mm/plugin/finder/live/model/ah:yds	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   3659: astore 11
    //   3661: aload 11
    //   3663: ifnonnull +2815 -> 6478
    //   3666: ldc_w 726
    //   3669: ldc_w 3275
    //   3672: invokestatic 1649	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   3675: iconst_0
    //   3676: istore_0
    //   3677: iload_0
    //   3678: ifne +935 -> 4613
    //   3681: getstatic 1215	com/tencent/mm/plugin/finder/live/model/ah:yds	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   3684: astore 11
    //   3686: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   3689: ifeq +167 -> 3856
    //   3692: aload 11
    //   3694: ifnull +162 -> 3856
    //   3697: aload 11
    //   3699: ldc_w 916
    //   3702: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3705: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   3708: getfield 3278	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfO	Z
    //   3711: ifeq +145 -> 3856
    //   3714: invokestatic 1723	com/tencent/mm/live/core/core/trtc/sdkadapter/a:aLI	()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/a;
    //   3717: astore 12
    //   3719: aload 12
    //   3721: ldc_w 1725
    //   3724: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3727: aload 12
    //   3729: invokevirtual 1887	com/tencent/mm/live/core/core/trtc/sdkadapter/a:aLJ	()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/feature/e;
    //   3732: invokevirtual 3280	com/tencent/mm/live/core/core/trtc/sdkadapter/feature/e:key	()Ljava/lang/String;
    //   3735: astore 12
    //   3737: aload 11
    //   3739: ldc_w 696
    //   3742: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3745: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   3748: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   3751: getfield 2847	com/tencent/mm/protocal/protobuf/bac:SLM	Lcom/tencent/mm/protocal/protobuf/bar;
    //   3754: astore 11
    //   3756: aload 11
    //   3758: ifnull +2828 -> 6586
    //   3761: aload 11
    //   3763: getfield 3285	com/tencent/mm/protocal/protobuf/bar:SMA	Lcom/tencent/mm/protocal/protobuf/cry;
    //   3766: astore 11
    //   3768: aload 11
    //   3770: invokestatic 1749	com/tencent/mm/plugin/finder/live/model/ah:a	(Lcom/tencent/mm/protocal/protobuf/cry;)V
    //   3773: invokestatic 1723	com/tencent/mm/live/core/core/trtc/sdkadapter/a:aLI	()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/a;
    //   3776: astore 11
    //   3778: aload 11
    //   3780: ldc_w 1725
    //   3783: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3786: aload 11
    //   3788: invokevirtual 1887	com/tencent/mm/live/core/core/trtc/sdkadapter/a:aLJ	()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/feature/e;
    //   3791: invokevirtual 3280	com/tencent/mm/live/core/core/trtc/sdkadapter/feature/e:key	()Ljava/lang/String;
    //   3794: astore 11
    //   3796: aload 12
    //   3798: aload 11
    //   3800: invokestatic 2033	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3803: ifne +18 -> 3821
    //   3806: getstatic 1062	com/tencent/mm/plugin/finder/live/model/ah:kHp	Lcom/tencent/mm/live/core/core/trtc/a;
    //   3809: astore 13
    //   3811: aload 13
    //   3813: ifnull +8 -> 3821
    //   3816: aload 13
    //   3818: invokevirtual 2701	com/tencent/mm/live/core/core/trtc/a:aLB	()V
    //   3821: ldc_w 726
    //   3824: new 680	java/lang/StringBuilder
    //   3827: dup
    //   3828: ldc_w 3287
    //   3831: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3834: aload 12
    //   3836: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3839: ldc_w 3289
    //   3842: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3845: aload 11
    //   3847: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3850: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3853: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3856: getstatic 1215	com/tencent/mm/plugin/finder/live/model/ah:yds	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   3859: astore 11
    //   3861: aload 11
    //   3863: ifnull +750 -> 4613
    //   3866: aload 11
    //   3868: ldc_w 916
    //   3871: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3874: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   3877: getfield 3292	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfp	I
    //   3880: aload_2
    //   3881: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   3884: if_icmpeq +729 -> 4613
    //   3887: ldc_w 726
    //   3890: new 680	java/lang/StringBuilder
    //   3893: dup
    //   3894: ldc_w 3297
    //   3897: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3900: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   3903: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3906: ldc_w 3299
    //   3909: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3912: aload 11
    //   3914: ldc_w 916
    //   3917: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3920: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   3923: getfield 3292	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfp	I
    //   3926: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3929: ldc_w 3301
    //   3932: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3935: aload_2
    //   3936: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   3939: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3942: ldc_w 3072
    //   3945: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3948: getstatic 597	com/tencent/mm/plugin/finder/live/model/ah:yhp	Z
    //   3951: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3954: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3957: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3960: getstatic 597	com/tencent/mm/plugin/finder/live/model/ah:yhp	Z
    //   3963: ifne +71 -> 4034
    //   3966: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   3969: ifne +65 -> 4034
    //   3972: aload 11
    //   3974: ldc_w 916
    //   3977: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   3980: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   3983: getfield 3292	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfp	I
    //   3986: invokestatic 3303	com/tencent/mm/plugin/finder/live/model/ah:Nv	(I)Z
    //   3989: ifne +2603 -> 6592
    //   3992: aload_2
    //   3993: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   3996: invokestatic 3303	com/tencent/mm/plugin/finder/live/model/ah:Nv	(I)Z
    //   3999: ifeq +2593 -> 6592
    //   4002: ldc_w 726
    //   4005: ldc_w 3305
    //   4008: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4011: getstatic 2397	com/tencent/mm/live/b/p:kvF	Lcom/tencent/mm/live/b/p;
    //   4014: astore 12
    //   4016: invokestatic 2401	com/tencent/mm/live/b/p:aOe	()Lcom/tencent/mm/live/b/g;
    //   4019: astore 12
    //   4021: aload 12
    //   4023: ifnull +11 -> 4034
    //   4026: aload 12
    //   4028: iconst_0
    //   4029: invokeinterface 3308 2 0
    //   4034: ldc_w 726
    //   4037: new 680	java/lang/StringBuilder
    //   4040: dup
    //   4041: ldc_w 3310
    //   4044: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4047: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   4050: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4053: ldc_w 3299
    //   4056: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4059: aload 11
    //   4061: ldc_w 916
    //   4064: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4067: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4070: getfield 3292	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfp	I
    //   4073: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4076: ldc_w 3301
    //   4079: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4082: aload_2
    //   4083: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   4086: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4089: ldc_w 3312
    //   4092: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4095: aload 11
    //   4097: ldc_w 720
    //   4100: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4103: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4106: getfield 3083	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhs	Z
    //   4109: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4112: ldc_w 3314
    //   4115: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4118: aload 11
    //   4120: ldc_w 720
    //   4123: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4126: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4129: invokevirtual 3250	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:dHd	()Z
    //   4132: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4135: ldc_w 3316
    //   4138: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4141: aload 11
    //   4143: ldc_w 720
    //   4146: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4149: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4152: getfield 3086	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zht	Z
    //   4155: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4158: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4161: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4164: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   4167: ifeq +2508 -> 6675
    //   4170: aload_2
    //   4171: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   4174: iconst_4
    //   4175: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   4178: ifne +2479 -> 6657
    //   4181: ldc_w 726
    //   4184: ldc_w 3318
    //   4187: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4190: aload 11
    //   4192: ldc_w 720
    //   4195: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4198: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4201: iconst_0
    //   4202: putfield 3086	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zht	Z
    //   4205: aload 11
    //   4207: ldc_w 720
    //   4210: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4213: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4216: iconst_0
    //   4217: putfield 3089	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhq	I
    //   4220: aload 11
    //   4222: ldc_w 916
    //   4225: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4228: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4231: aload 11
    //   4233: ldc_w 916
    //   4236: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4239: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4242: getfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   4245: bipush 191
    //   4247: iand
    //   4248: putfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   4251: getstatic 1267	com/tencent/mm/plugin/finder/live/model/ah:ybM	Lcom/tencent/mm/plugin/finder/live/model/an;
    //   4254: astore 12
    //   4256: aload 12
    //   4258: ifnull +56 -> 4314
    //   4261: aload 12
    //   4263: aload 11
    //   4265: ldc_w 696
    //   4268: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4271: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   4274: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   4277: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   4280: aload 11
    //   4282: ldc_w 696
    //   4285: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4288: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   4291: getfield 889	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:xbk	J
    //   4294: aload 11
    //   4296: ldc_w 916
    //   4299: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4302: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4305: getfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   4308: aconst_null
    //   4309: bipush 24
    //   4311: invokestatic 3321	com/tencent/mm/plugin/finder/live/model/an$a:a	(Lcom/tencent/mm/plugin/finder/live/model/an;JJILcom/tencent/mm/plugin/finder/live/cgi/d$a;I)V
    //   4314: ldc_w 726
    //   4317: new 680	java/lang/StringBuilder
    //   4320: dup
    //   4321: ldc_w 3323
    //   4324: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4327: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   4330: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4333: ldc_w 3299
    //   4336: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4339: aload 11
    //   4341: ldc_w 916
    //   4344: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4347: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4350: getfield 3292	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfp	I
    //   4353: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4356: ldc_w 3301
    //   4359: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4362: aload_2
    //   4363: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   4366: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4369: ldc_w 3325
    //   4372: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4375: aload 11
    //   4377: ldc_w 916
    //   4380: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4383: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4386: getfield 3185	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfH	Z
    //   4389: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4392: ldc_w 3327
    //   4395: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4398: aload 11
    //   4400: ldc_w 916
    //   4403: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4406: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4409: invokevirtual 3191	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:dGF	()Z
    //   4412: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4415: ldc_w 3329
    //   4418: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4421: aload 11
    //   4423: ldc_w 916
    //   4426: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4429: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4432: getfield 3188	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfJ	Z
    //   4435: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4438: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4441: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4444: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   4447: ifeq +2330 -> 6777
    //   4450: aload_2
    //   4451: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   4454: iconst_2
    //   4455: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   4458: ifne +2301 -> 6759
    //   4461: ldc_w 726
    //   4464: ldc_w 3331
    //   4467: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4470: aload 11
    //   4472: ldc_w 916
    //   4475: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4478: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4481: iconst_0
    //   4482: putfield 3188	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfJ	Z
    //   4485: aload 11
    //   4487: ldc_w 916
    //   4490: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4493: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4496: iconst_0
    //   4497: putfield 3194	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfG	I
    //   4500: aload 11
    //   4502: ldc_w 916
    //   4505: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4508: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4511: aload 11
    //   4513: ldc_w 916
    //   4516: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4519: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4522: getfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   4525: sipush -129
    //   4528: iand
    //   4529: putfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   4532: getstatic 1267	com/tencent/mm/plugin/finder/live/model/ah:ybM	Lcom/tencent/mm/plugin/finder/live/model/an;
    //   4535: astore 12
    //   4537: aload 12
    //   4539: ifnull +56 -> 4595
    //   4542: aload 12
    //   4544: aload 11
    //   4546: ldc_w 696
    //   4549: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4552: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   4555: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   4558: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   4561: aload 11
    //   4563: ldc_w 696
    //   4566: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4569: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   4572: getfield 889	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:xbk	J
    //   4575: aload 11
    //   4577: ldc_w 916
    //   4580: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4583: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4586: getfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   4589: aconst_null
    //   4590: bipush 24
    //   4592: invokestatic 3321	com/tencent/mm/plugin/finder/live/model/an$a:a	(Lcom/tencent/mm/plugin/finder/live/model/an;JJILcom/tencent/mm/plugin/finder/live/cgi/d$a;I)V
    //   4595: aload 11
    //   4597: ldc_w 916
    //   4600: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4603: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4606: aload_2
    //   4607: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   4610: putfield 3292	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfp	I
    //   4613: aload 14
    //   4615: aload_2
    //   4616: getfield 3334	com/tencent/mm/protocal/protobuf/auv:SHe	Ljava/util/LinkedList;
    //   4619: invokevirtual 3337	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:ax	(Ljava/util/LinkedList;)V
    //   4622: new 680	java/lang/StringBuilder
    //   4625: dup
    //   4626: ldc_w 3339
    //   4629: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4632: aload 14
    //   4634: ldc_w 696
    //   4637: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4640: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   4643: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   4646: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   4649: invokevirtual 689	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4652: ldc_w 3341
    //   4655: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4658: astore 12
    //   4660: aload_2
    //   4661: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   4664: astore 11
    //   4666: aload 11
    //   4668: ifnull +2194 -> 6862
    //   4671: aload 11
    //   4673: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   4676: invokestatic 713	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4679: astore 11
    //   4681: aload 12
    //   4683: aload 11
    //   4685: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4688: ldc_w 3343
    //   4691: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4694: aload 14
    //   4696: ldc_w 696
    //   4699: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4702: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   4705: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   4708: getfield 3346	com/tencent/mm/protocal/protobuf/bac:BpL	I
    //   4711: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4714: ldc_w 3348
    //   4717: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4720: aload 14
    //   4722: getfield 2822	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfk	J
    //   4725: invokevirtual 689	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4728: ldc_w 3350
    //   4731: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4734: astore 12
    //   4736: aload_2
    //   4737: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   4740: astore 11
    //   4742: aload 11
    //   4744: ifnull +2124 -> 6868
    //   4747: aload 11
    //   4749: getfield 3346	com/tencent/mm/protocal/protobuf/bac:BpL	I
    //   4752: invokestatic 1833	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4755: astore 11
    //   4757: aload 12
    //   4759: aload 11
    //   4761: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4764: ldc_w 3352
    //   4767: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4770: aload 14
    //   4772: ldc_w 696
    //   4775: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4778: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   4781: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   4784: getfield 2843	com/tencent/mm/protocal/protobuf/bac:yYz	I
    //   4787: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4790: ldc_w 3354
    //   4793: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4796: aload 14
    //   4798: ldc_w 696
    //   4801: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4804: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   4807: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   4810: getfield 2834	com/tencent/mm/protocal/protobuf/bac:SHj	J
    //   4813: invokevirtual 689	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4816: ldc_w 3356
    //   4819: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4822: astore 12
    //   4824: aload_2
    //   4825: getfield 2892	com/tencent/mm/protocal/protobuf/auv:LIS	Ljava/util/LinkedList;
    //   4828: astore 11
    //   4830: aload 11
    //   4832: ifnull +2042 -> 6874
    //   4835: aload 11
    //   4837: invokevirtual 1588	java/util/LinkedList:size	()I
    //   4840: invokestatic 1833	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4843: astore 11
    //   4845: aload 12
    //   4847: aload 11
    //   4849: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4852: ldc_w 3358
    //   4855: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4858: aload 14
    //   4860: ldc_w 2927
    //   4863: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4866: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   4869: getfield 2936	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:ziq	Ljava/util/List;
    //   4872: invokeinterface 2931 1 0
    //   4877: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4880: ldc_w 3360
    //   4883: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4886: aload_2
    //   4887: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   4890: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4893: ldc_w 3362
    //   4896: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4899: aload_2
    //   4900: getfield 2850	com/tencent/mm/protocal/protobuf/auv:SGY	I
    //   4903: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4906: ldc_w 3364
    //   4909: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4912: aload 14
    //   4914: getfield 3278	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfO	Z
    //   4917: invokevirtual 810	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4920: ldc_w 3366
    //   4923: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4926: aload 14
    //   4928: ldc_w 916
    //   4931: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4934: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   4937: getfield 3292	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfp	I
    //   4940: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4943: ldc_w 3368
    //   4946: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4949: aload 14
    //   4951: ldc_w 696
    //   4954: invokevirtual 1642	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   4957: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   4960: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   4963: getfield 2837	com/tencent/mm/protocal/protobuf/bac:SHu	J
    //   4966: invokevirtual 689	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4969: ldc_w 3370
    //   4972: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4975: astore 12
    //   4977: aload_2
    //   4978: getfield 2773	com/tencent/mm/protocal/protobuf/auv:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   4981: astore 11
    //   4983: aload 11
    //   4985: ifnull +1895 -> 6880
    //   4988: aload 11
    //   4990: getfield 2865	com/tencent/mm/protocal/protobuf/bac:SLW	Lcom/tencent/mm/protocal/protobuf/bag;
    //   4993: astore 11
    //   4995: aload 11
    //   4997: ifnull +1883 -> 6880
    //   5000: aload 11
    //   5002: getfield 2874	com/tencent/mm/protocal/protobuf/bag:CKC	I
    //   5005: invokestatic 1833	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5008: astore 11
    //   5010: ldc_w 726
    //   5013: aload 12
    //   5015: aload 11
    //   5017: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5020: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5023: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5026: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   5029: ifeq +10 -> 5039
    //   5032: getstatic 545	com/tencent/mm/plugin/finder/live/model/ah:yhd	Lcom/tencent/mm/plugin/finder/live/model/k;
    //   5035: aload_2
    //   5036: invokevirtual 3373	com/tencent/mm/plugin/finder/live/model/k:a	(Lcom/tencent/mm/protocal/protobuf/auv;)V
    //   5039: ldc_w 2764
    //   5042: invokestatic 667	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5045: iconst_1
    //   5046: ireturn
    //   5047: iconst_0
    //   5048: istore 9
    //   5050: goto -4046 -> 1004
    //   5053: aconst_null
    //   5054: astore 11
    //   5056: goto -3933 -> 1123
    //   5059: astore 11
    //   5061: ldc_w 3375
    //   5064: ldc_w 546
    //   5067: iconst_1
    //   5068: anewarray 4	java/lang/Object
    //   5071: dup
    //   5072: iconst_0
    //   5073: aload 11
    //   5075: aastore
    //   5076: invokestatic 3379	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5079: aconst_null
    //   5080: astore 11
    //   5082: goto -3947 -> 1135
    //   5085: ldc_w 726
    //   5088: new 680	java/lang/StringBuilder
    //   5091: dup
    //   5092: ldc_w 3381
    //   5095: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5098: aload 13
    //   5100: getfield 2874	com/tencent/mm/protocal/protobuf/bag:CKC	I
    //   5103: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5106: ldc_w 3383
    //   5109: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5112: aload 11
    //   5114: getfield 3386	com/tencent/mm/protocal/protobuf/baf:SMc	I
    //   5117: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5120: bipush 44
    //   5122: invokevirtual 1769	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   5125: ldc_w 3388
    //   5128: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5131: aload 11
    //   5133: getfield 3391	com/tencent/mm/protocal/protobuf/baf:SMe	Ljava/lang/String;
    //   5136: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5139: ldc_w 3393
    //   5142: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5145: aload 11
    //   5147: getfield 3396	com/tencent/mm/protocal/protobuf/baf:SMf	I
    //   5150: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5153: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5156: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5159: getstatic 1215	com/tencent/mm/plugin/finder/live/model/ah:yds	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   5162: astore 12
    //   5164: aload 12
    //   5166: ifnull -4019 -> 1147
    //   5169: aload 12
    //   5171: ldc_w 3398
    //   5174: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5177: checkcast 3398	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   5180: aload 11
    //   5182: putfield 3402	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:zha	Lcom/tencent/mm/protocal/protobuf/baf;
    //   5185: aload 12
    //   5187: ldc_w 3398
    //   5190: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5193: checkcast 3398	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   5196: getfield 3405	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:ncq	Z
    //   5199: ifeq +62 -> 5261
    //   5202: aload 12
    //   5204: ldc_w 3398
    //   5207: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5210: checkcast 3398	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   5213: getfield 3408	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:zhb	I
    //   5216: aload 11
    //   5218: getfield 3386	com/tencent/mm/protocal/protobuf/baf:SMc	I
    //   5221: if_icmpeq +40 -> 5261
    //   5224: getstatic 1252	com/tencent/mm/plugin/finder/live/model/ah:ydt	Lcom/tencent/mm/plugin/finder/live/view/a;
    //   5227: astore 13
    //   5229: aload 13
    //   5231: ifnull +12 -> 5243
    //   5234: aload 13
    //   5236: invokevirtual 3411	com/tencent/mm/plugin/finder/live/view/a:isDestroyed	()Z
    //   5239: iconst_1
    //   5240: if_icmpeq +21 -> 5261
    //   5243: getstatic 1252	com/tencent/mm/plugin/finder/live/model/ah:ydt	Lcom/tencent/mm/plugin/finder/live/view/a;
    //   5246: astore 13
    //   5248: aload 13
    //   5250: ifnull +11 -> 5261
    //   5253: aload 13
    //   5255: getstatic 3415	com/tencent/mm/live/c/b$c:kBN	Lcom/tencent/mm/live/c/b$c;
    //   5258: invokestatic 3420	com/tencent/mm/live/c/b$b:a	(Lcom/tencent/mm/live/c/b;Lcom/tencent/mm/live/c/b$c;)V
    //   5261: aload 12
    //   5263: ldc_w 3398
    //   5266: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5269: checkcast 3398	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   5272: aload 11
    //   5274: getfield 3386	com/tencent/mm/protocal/protobuf/baf:SMc	I
    //   5277: putfield 3408	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:zhb	I
    //   5280: getstatic 1252	com/tencent/mm/plugin/finder/live/model/ah:ydt	Lcom/tencent/mm/plugin/finder/live/view/a;
    //   5283: astore 11
    //   5285: aload 11
    //   5287: ifnull +12 -> 5299
    //   5290: aload 11
    //   5292: invokevirtual 3411	com/tencent/mm/plugin/finder/live/view/a:isDestroyed	()Z
    //   5295: iconst_1
    //   5296: if_icmpeq +39 -> 5335
    //   5299: getstatic 1252	com/tencent/mm/plugin/finder/live/model/ah:ydt	Lcom/tencent/mm/plugin/finder/live/view/a;
    //   5302: astore 11
    //   5304: aload 11
    //   5306: ifnull +11 -> 5317
    //   5309: aload 11
    //   5311: getstatic 3423	com/tencent/mm/live/c/b$c:kBM	Lcom/tencent/mm/live/c/b$c;
    //   5314: invokestatic 3420	com/tencent/mm/live/c/b$b:a	(Lcom/tencent/mm/live/c/b;Lcom/tencent/mm/live/c/b$c;)V
    //   5317: getstatic 1435	com/tencent/mm/plugin/finder/live/model/ah:yhe	Lcom/tencent/mm/plugin/finder/live/model/c;
    //   5320: astore 11
    //   5322: aload 11
    //   5324: ifnull -4177 -> 1147
    //   5327: aload 11
    //   5329: invokestatic 3426	com/tencent/mm/plugin/finder/live/model/c:a	(Lcom/tencent/mm/plugin/finder/live/model/c;)V
    //   5332: goto -4185 -> 1147
    //   5335: aload 12
    //   5337: iconst_1
    //   5338: getstatic 3423	com/tencent/mm/live/c/b$c:kBM	Lcom/tencent/mm/live/c/b$c;
    //   5341: aconst_null
    //   5342: aload 12
    //   5344: ldc_w 696
    //   5347: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5350: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   5353: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   5356: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   5359: invokestatic 3428	com/tencent/mm/plugin/finder/live/model/ah:a	(Lcom/tencent/mm/plugin/finder/live/model/context/a;ZLcom/tencent/mm/live/c/b$c;Landroid/os/Bundle;J)V
    //   5362: goto -45 -> 5317
    //   5365: getstatic 1215	com/tencent/mm/plugin/finder/live/model/ah:yds	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   5368: astore 11
    //   5370: aload 11
    //   5372: ifnull +369 -> 5741
    //   5375: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   5378: ifeq +241 -> 5619
    //   5381: aload 11
    //   5383: ldc_w 3398
    //   5386: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5389: checkcast 3398	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   5392: getfield 3405	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:ncq	Z
    //   5395: ifeq +224 -> 5619
    //   5398: aload 13
    //   5400: getfield 2874	com/tencent/mm/protocal/protobuf/bag:CKC	I
    //   5403: ifne +216 -> 5619
    //   5406: aload 11
    //   5408: iconst_1
    //   5409: getstatic 3415	com/tencent/mm/live/c/b$c:kBN	Lcom/tencent/mm/live/c/b$c;
    //   5412: aconst_null
    //   5413: aload 11
    //   5415: ldc_w 696
    //   5418: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5421: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   5424: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   5427: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   5430: invokestatic 3428	com/tencent/mm/plugin/finder/live/model/ah:a	(Lcom/tencent/mm/plugin/finder/live/model/context/a;ZLcom/tencent/mm/live/c/b$c;Landroid/os/Bundle;J)V
    //   5433: getstatic 1435	com/tencent/mm/plugin/finder/live/model/ah:yhe	Lcom/tencent/mm/plugin/finder/live/model/c;
    //   5436: astore 12
    //   5438: aload 12
    //   5440: ifnull +165 -> 5605
    //   5443: aload 12
    //   5445: getfield 3429	com/tencent/mm/plugin/finder/live/model/c:yds	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   5448: ldc_w 3398
    //   5451: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5454: checkcast 3398	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   5457: getfield 3405	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:ncq	Z
    //   5460: ifeq +145 -> 5605
    //   5463: ldc_w 3431
    //   5466: new 680	java/lang/StringBuilder
    //   5469: dup
    //   5470: ldc_w 3433
    //   5473: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5476: aload 12
    //   5478: getfield 3436	com/tencent/mm/plugin/finder/live/model/c:ydo	I
    //   5481: invokevirtual 815	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5484: ldc_w 3438
    //   5487: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5490: aload 12
    //   5492: getfield 3441	com/tencent/mm/plugin/finder/live/model/c:ydp	Ljava/lang/String;
    //   5495: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5498: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5501: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5504: aload 12
    //   5506: getfield 3436	com/tencent/mm/plugin/finder/live/model/c:ydo	I
    //   5509: iconst_2
    //   5510: if_icmpne +8 -> 5518
    //   5513: aload 12
    //   5515: invokevirtual 3444	com/tencent/mm/plugin/finder/live/model/c:dxS	()V
    //   5518: aload 12
    //   5520: iconst_0
    //   5521: putfield 3436	com/tencent/mm/plugin/finder/live/model/c:ydo	I
    //   5524: aload 12
    //   5526: aconst_null
    //   5527: putfield 3441	com/tencent/mm/plugin/finder/live/model/c:ydp	Ljava/lang/String;
    //   5530: aload 12
    //   5532: aconst_null
    //   5533: putfield 3447	com/tencent/mm/plugin/finder/live/model/c:ydq	Ljava/lang/String;
    //   5536: aload 12
    //   5538: iconst_0
    //   5539: putfield 3450	com/tencent/mm/plugin/finder/live/model/c:ydr	I
    //   5542: aload 12
    //   5544: getfield 2240	com/tencent/mm/plugin/finder/live/model/c:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   5547: astore 12
    //   5549: aload 12
    //   5551: ifnull +8 -> 5559
    //   5554: aload 12
    //   5556: invokevirtual 2245	com/tencent/mm/sdk/platformtools/MTimerHandler:stopTimer	()V
    //   5559: invokestatic 1536	com/tencent/mm/plugin/finder/live/model/ah:dzB	()Lcom/tencent/mm/live/core/core/a/b;
    //   5562: astore 12
    //   5564: aload 12
    //   5566: ifnull +39 -> 5605
    //   5569: aload 12
    //   5571: getfield 1131	com/tencent/mm/live/core/core/trtc/a:knA	Lcom/tencent/mm/live/core/core/model/h;
    //   5574: astore 12
    //   5576: aload 12
    //   5578: ifnull +27 -> 5605
    //   5581: aload 12
    //   5583: getfield 3453	com/tencent/mm/live/core/core/model/h:pause	Z
    //   5586: iconst_1
    //   5587: if_icmpne +18 -> 5605
    //   5590: invokestatic 1536	com/tencent/mm/plugin/finder/live/model/ah:dzB	()Lcom/tencent/mm/live/core/core/a/b;
    //   5593: astore 12
    //   5595: aload 12
    //   5597: ifnull +8 -> 5605
    //   5600: aload 12
    //   5602: invokevirtual 3456	com/tencent/mm/live/core/core/a/b:aLF	()V
    //   5605: aload 11
    //   5607: ldc_w 3398
    //   5610: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5613: checkcast 3398	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   5616: invokevirtual 3457	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:reset	()V
    //   5619: getstatic 1370	com/tencent/mm/plugin/finder/live/model/ah:fFE	Z
    //   5622: ifeq +32 -> 5654
    //   5625: aload 11
    //   5627: ldc_w 916
    //   5630: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5633: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   5636: getfield 1380	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zgy	Z
    //   5639: ifeq +15 -> 5654
    //   5642: ldc_w 726
    //   5645: ldc_w 3459
    //   5648: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5651: goto -4504 -> 1147
    //   5654: getstatic 1273	com/tencent/mm/plugin/finder/live/utils/a:yRm	Lcom/tencent/mm/plugin/finder/live/utils/a;
    //   5657: astore 12
    //   5659: invokestatic 3462	com/tencent/mm/plugin/finder/live/utils/a:dEA	()Z
    //   5662: ifeq +47 -> 5709
    //   5665: aload 13
    //   5667: getfield 2874	com/tencent/mm/protocal/protobuf/bag:CKC	I
    //   5670: aload 11
    //   5672: ldc_w 916
    //   5675: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5678: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   5681: getfield 3465	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zgv	I
    //   5684: if_icmpne -4537 -> 1147
    //   5687: aload 11
    //   5689: ldc_w 916
    //   5692: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5695: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   5698: aload 13
    //   5700: getfield 2879	com/tencent/mm/protocal/protobuf/bag:SMj	I
    //   5703: putfield 3468	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zgu	I
    //   5706: goto -4559 -> 1147
    //   5709: aload 11
    //   5711: ldc_w 916
    //   5714: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5717: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   5720: aload 13
    //   5722: iconst_0
    //   5723: new 43	com/tencent/mm/plugin/finder/live/model/ah$f
    //   5726: dup
    //   5727: aload 11
    //   5729: invokespecial 3469	com/tencent/mm/plugin/finder/live/model/ah$f:<init>	(Lcom/tencent/mm/plugin/finder/live/model/context/a;)V
    //   5732: checkcast 3471	kotlin/g/a/m
    //   5735: invokevirtual 3474	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:a	(Lcom/tencent/mm/protocal/protobuf/bag;ZLkotlin/g/a/m;)V
    //   5738: goto -4591 -> 1147
    //   5741: ldc_w 726
    //   5744: ldc_w 3476
    //   5747: invokestatic 1284	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5750: goto -4603 -> 1147
    //   5753: aconst_null
    //   5754: astore 11
    //   5756: goto -3991 -> 1765
    //   5759: new 680	java/lang/StringBuilder
    //   5762: dup
    //   5763: ldc_w 3478
    //   5766: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5769: astore 12
    //   5771: ldc_w 916
    //   5774: invokestatic 699	com/tencent/mm/plugin/finder/live/model/ah:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5777: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   5780: astore 11
    //   5782: aload 11
    //   5784: ifnull +44 -> 5828
    //   5787: aload 11
    //   5789: getfield 3026	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfS	Lcom/tencent/mm/protocal/protobuf/axc;
    //   5792: astore 11
    //   5794: aload 11
    //   5796: ifnull +32 -> 5828
    //   5799: aload 11
    //   5801: getfield 3031	com/tencent/mm/protocal/protobuf/axc:SJy	I
    //   5804: invokestatic 1833	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5807: astore 11
    //   5809: ldc_w 726
    //   5812: aload 12
    //   5814: aload 11
    //   5816: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5819: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5822: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5825: goto -4027 -> 1798
    //   5828: aconst_null
    //   5829: astore 11
    //   5831: goto -22 -> 5809
    //   5834: astore 11
    //   5836: ldc_w 3375
    //   5839: ldc_w 546
    //   5842: iconst_1
    //   5843: anewarray 4	java/lang/Object
    //   5846: dup
    //   5847: iconst_0
    //   5848: aload 11
    //   5850: aastore
    //   5851: invokestatic 3379	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5854: aconst_null
    //   5855: astore 11
    //   5857: goto -3989 -> 1868
    //   5860: aconst_null
    //   5861: astore 11
    //   5863: goto -3961 -> 1902
    //   5866: aconst_null
    //   5867: astore 11
    //   5869: goto -3925 -> 1944
    //   5872: aconst_null
    //   5873: astore 11
    //   5875: goto -3889 -> 1986
    //   5878: aconst_null
    //   5879: astore 11
    //   5881: goto -3794 -> 2087
    //   5884: aload 13
    //   5886: ldc_w 916
    //   5889: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5892: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   5895: getfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   5898: iconst_2
    //   5899: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   5902: ifeq -3686 -> 2216
    //   5905: lload 5
    //   5907: l2i
    //   5908: iconst_2
    //   5909: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   5912: ifne -3696 -> 2216
    //   5915: ldc_w 726
    //   5918: ldc_w 3480
    //   5921: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5924: getstatic 2397	com/tencent/mm/live/b/p:kvF	Lcom/tencent/mm/live/b/p;
    //   5927: astore 11
    //   5929: invokestatic 2401	com/tencent/mm/live/b/p:aOe	()Lcom/tencent/mm/live/b/g;
    //   5932: astore 11
    //   5934: aload 11
    //   5936: ifnull -3720 -> 2216
    //   5939: aload 11
    //   5941: iconst_0
    //   5942: invokeinterface 3077 2 0
    //   5947: goto -3731 -> 2216
    //   5950: iconst_0
    //   5951: istore 9
    //   5953: goto -3629 -> 2324
    //   5956: iconst_0
    //   5957: istore_0
    //   5958: goto -3581 -> 2377
    //   5961: aload 13
    //   5963: ldc_w 720
    //   5966: invokevirtual 3080	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   5969: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   5972: iconst_0
    //   5973: putfield 3089	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhq	I
    //   5976: goto -3593 -> 2383
    //   5979: lconst_0
    //   5980: lstore 5
    //   5982: goto -3587 -> 2395
    //   5985: aconst_null
    //   5986: astore 11
    //   5988: goto -3506 -> 2482
    //   5991: iconst_0
    //   5992: istore 9
    //   5994: goto -3482 -> 2512
    //   5997: iconst_0
    //   5998: istore 10
    //   6000: goto -3466 -> 2534
    //   6003: invokestatic 1405	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6006: astore 11
    //   6008: aload 11
    //   6010: ldc_w 1407
    //   6013: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6016: aload 11
    //   6018: invokevirtual 3114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6021: getstatic 3483	com/tencent/mm/x/a/a/a$a:finder_live_like_anchor_disable	I
    //   6024: invokevirtual 3124	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   6027: astore 11
    //   6029: goto -3441 -> 2588
    //   6032: invokestatic 1405	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6035: astore 11
    //   6037: aload 11
    //   6039: ldc_w 1407
    //   6042: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6045: aload 11
    //   6047: invokevirtual 3114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6050: getstatic 3486	com/tencent/mm/x/a/a/a$a:finder_live_comment_anchor_disable	I
    //   6053: invokevirtual 3124	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   6056: astore 11
    //   6058: goto -3321 -> 2737
    //   6061: invokestatic 1405	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6064: astore 11
    //   6066: aload 11
    //   6068: ldc_w 1407
    //   6071: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6074: aload 11
    //   6076: invokevirtual 3114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6079: getstatic 3489	com/tencent/mm/x/a/a/a$a:finder_live_gift_disable_msg_tip	I
    //   6082: invokevirtual 3124	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   6085: astore 11
    //   6087: goto -3070 -> 3017
    //   6090: iconst_0
    //   6091: istore_0
    //   6092: goto -2996 -> 3096
    //   6095: aload 14
    //   6097: iconst_0
    //   6098: putfield 3194	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfG	I
    //   6101: goto -2999 -> 3102
    //   6104: invokestatic 1405	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6107: astore 11
    //   6109: aload 11
    //   6111: ldc_w 1407
    //   6114: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6117: aload 11
    //   6119: invokevirtual 3114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6122: getstatic 3492	com/tencent/mm/x/a/a/a$a:finder_live_camera_enable_msg_tip	I
    //   6125: invokevirtual 3124	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   6128: astore 11
    //   6130: goto -2926 -> 3204
    //   6133: iconst_0
    //   6134: istore_0
    //   6135: goto -2852 -> 3283
    //   6138: aconst_null
    //   6139: astore 11
    //   6141: goto -2814 -> 3327
    //   6144: aconst_null
    //   6145: astore 12
    //   6147: goto -2798 -> 3349
    //   6150: aload 12
    //   6152: invokevirtual 1333	java/lang/Integer:intValue	()I
    //   6155: iconst_1
    //   6156: if_icmpne -2723 -> 3433
    //   6159: aload 14
    //   6161: getfield 2997	com/tencent/mm/plugin/finder/live/viewmodel/data/business/a:zeV	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   6164: astore 12
    //   6166: aload 14
    //   6168: getfield 3198	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:TAG	Ljava/lang/String;
    //   6171: astore 13
    //   6173: new 680	java/lang/StringBuilder
    //   6176: dup
    //   6177: ldc_w 3494
    //   6180: invokespecial 685	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6183: astore 15
    //   6185: aload 12
    //   6187: ifnull +256 -> 6443
    //   6190: aload 12
    //   6192: ldc_w 916
    //   6195: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6198: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6201: astore 11
    //   6203: aload 11
    //   6205: ifnull +238 -> 6443
    //   6208: aload 11
    //   6210: getfield 3223	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfD	Lcom/tencent/mm/protocal/protobuf/azh;
    //   6213: astore 11
    //   6215: aload 11
    //   6217: ifnull +226 -> 6443
    //   6220: aload 11
    //   6222: getfield 3233	com/tencent/mm/protocal/protobuf/azh:SLe	I
    //   6225: invokestatic 1833	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6228: astore 11
    //   6230: aload 13
    //   6232: aload 15
    //   6234: aload 11
    //   6236: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6239: invokevirtual 730	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6242: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6245: aload 12
    //   6247: ifnull +41 -> 6288
    //   6250: aload 12
    //   6252: ldc_w 916
    //   6255: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6258: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6261: astore 11
    //   6263: aload 11
    //   6265: ifnull +23 -> 6288
    //   6268: aload 11
    //   6270: getfield 3223	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfD	Lcom/tencent/mm/protocal/protobuf/azh;
    //   6273: astore 11
    //   6275: aload 11
    //   6277: ifnull +11 -> 6288
    //   6280: aload 11
    //   6282: getfield 3233	com/tencent/mm/protocal/protobuf/azh:SLe	I
    //   6285: ifeq -2837 -> 3448
    //   6288: aload 12
    //   6290: ifnull -2842 -> 3448
    //   6293: new 3128	com/tencent/mm/protocal/protobuf/bbd
    //   6296: dup
    //   6297: invokespecial 3129	com/tencent/mm/protocal/protobuf/bbd:<init>	()V
    //   6300: astore 13
    //   6302: aload 13
    //   6304: sipush 10001
    //   6307: putfield 3135	com/tencent/mm/protocal/protobuf/bbd:type	I
    //   6310: aload 12
    //   6312: ldc_w 916
    //   6315: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6318: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6321: getfield 3223	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfD	Lcom/tencent/mm/protocal/protobuf/azh;
    //   6324: astore 11
    //   6326: aload 11
    //   6328: ifnull +121 -> 6449
    //   6331: aload 11
    //   6333: getfield 3233	com/tencent/mm/protocal/protobuf/azh:SLe	I
    //   6336: iconst_1
    //   6337: if_icmpne +112 -> 6449
    //   6340: invokestatic 1405	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6343: astore 11
    //   6345: aload 11
    //   6347: ldc_w 1407
    //   6350: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6353: aload 11
    //   6355: invokevirtual 3114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6358: getstatic 3497	com/tencent/mm/x/a/a/a$a:finder_game_live_team_join_off	I
    //   6361: invokevirtual 3124	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   6364: astore 11
    //   6366: aload 13
    //   6368: aload 11
    //   6370: putfield 3132	com/tencent/mm/protocal/protobuf/bbd:content	Ljava/lang/String;
    //   6373: new 3137	com/tencent/mm/plugin/finder/live/model/ak
    //   6376: dup
    //   6377: aload 13
    //   6379: invokespecial 3140	com/tencent/mm/plugin/finder/live/model/ak:<init>	(Lcom/tencent/mm/protocal/protobuf/bbd;)V
    //   6382: astore 11
    //   6384: aload 12
    //   6386: ldc_w 2927
    //   6389: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6392: checkcast 2927	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h
    //   6395: getfield 2936	com/tencent/mm/plugin/finder/live/viewmodel/data/business/h:ziq	Ljava/util/List;
    //   6398: aload 11
    //   6400: invokeinterface 3145 2 0
    //   6405: pop
    //   6406: goto -2958 -> 3448
    //   6409: aload 12
    //   6411: invokevirtual 1333	java/lang/Integer:intValue	()I
    //   6414: ifeq -255 -> 6159
    //   6417: goto -2979 -> 3438
    //   6420: aload 11
    //   6422: invokevirtual 1333	java/lang/Integer:intValue	()I
    //   6425: iconst_1
    //   6426: if_icmpeq -267 -> 6159
    //   6429: goto -2986 -> 3443
    //   6432: aload 11
    //   6434: invokevirtual 1333	java/lang/Integer:intValue	()I
    //   6437: ifne -2989 -> 3448
    //   6440: goto -281 -> 6159
    //   6443: aconst_null
    //   6444: astore 11
    //   6446: goto -216 -> 6230
    //   6449: invokestatic 1405	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6452: astore 11
    //   6454: aload 11
    //   6456: ldc_w 1407
    //   6459: invokestatic 787	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6462: aload 11
    //   6464: invokevirtual 3114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6467: getstatic 3500	com/tencent/mm/x/a/a/a$a:finder_game_live_team_join_on	I
    //   6470: invokevirtual 3124	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   6473: astore 11
    //   6475: goto -109 -> 6366
    //   6478: aload_2
    //   6479: getfield 3503	com/tencent/mm/protocal/protobuf/auv:SGT	I
    //   6482: iconst_1
    //   6483: if_icmpne +98 -> 6581
    //   6486: iconst_1
    //   6487: istore_0
    //   6488: iload_0
    //   6489: ifeq +89 -> 6578
    //   6492: ldc_w 726
    //   6495: ldc_w 3505
    //   6498: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6501: aload 11
    //   6503: ldc_w 916
    //   6506: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6509: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6512: iconst_1
    //   6513: invokevirtual 3508	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:pz	(Z)V
    //   6516: getstatic 1062	com/tencent/mm/plugin/finder/live/model/ah:kHp	Lcom/tencent/mm/live/core/core/trtc/a;
    //   6519: astore 12
    //   6521: aload 12
    //   6523: ifnull +9 -> 6532
    //   6526: aload 12
    //   6528: iconst_4
    //   6529: invokevirtual 2391	com/tencent/mm/live/core/core/trtc/a:sX	(I)V
    //   6532: getstatic 2397	com/tencent/mm/live/b/p:kvF	Lcom/tencent/mm/live/b/p;
    //   6535: astore 12
    //   6537: invokestatic 2401	com/tencent/mm/live/b/p:aOe	()Lcom/tencent/mm/live/b/g;
    //   6540: astore 12
    //   6542: aload 12
    //   6544: ifnull +34 -> 6578
    //   6547: aload 12
    //   6549: new 2403	com/tencent/mm/live/b/e
    //   6552: dup
    //   6553: aload 11
    //   6555: ldc_w 696
    //   6558: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6561: checkcast 696	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   6564: getfield 703	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   6567: getfield 707	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   6570: invokespecial 2405	com/tencent/mm/live/b/e:<init>	(J)V
    //   6573: invokeinterface 2411 2 0
    //   6578: goto -2901 -> 3677
    //   6581: iconst_0
    //   6582: istore_0
    //   6583: goto -95 -> 6488
    //   6586: aconst_null
    //   6587: astore 11
    //   6589: goto -2821 -> 3768
    //   6592: aload 11
    //   6594: ldc_w 916
    //   6597: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6600: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6603: getfield 3292	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfp	I
    //   6606: invokestatic 3303	com/tencent/mm/plugin/finder/live/model/ah:Nv	(I)Z
    //   6609: ifeq -2575 -> 4034
    //   6612: aload_2
    //   6613: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   6616: invokestatic 3303	com/tencent/mm/plugin/finder/live/model/ah:Nv	(I)Z
    //   6619: ifne -2585 -> 4034
    //   6622: ldc_w 726
    //   6625: ldc_w 3510
    //   6628: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6631: getstatic 2397	com/tencent/mm/live/b/p:kvF	Lcom/tencent/mm/live/b/p;
    //   6634: astore 12
    //   6636: invokestatic 2401	com/tencent/mm/live/b/p:aOe	()Lcom/tencent/mm/live/b/g;
    //   6639: astore 12
    //   6641: aload 12
    //   6643: ifnull -2609 -> 4034
    //   6646: aload 12
    //   6648: iconst_1
    //   6649: invokeinterface 3308 2 0
    //   6654: goto -2620 -> 4034
    //   6657: aload 11
    //   6659: ldc_w 720
    //   6662: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6665: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   6668: iconst_1
    //   6669: putfield 3086	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zht	Z
    //   6672: goto -2358 -> 4314
    //   6675: aload_2
    //   6676: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   6679: iconst_4
    //   6680: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   6683: ifne -2369 -> 4314
    //   6686: ldc_w 726
    //   6689: ldc_w 3318
    //   6692: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6695: aload 11
    //   6697: ldc_w 720
    //   6700: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6703: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   6706: iconst_0
    //   6707: putfield 3083	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhs	Z
    //   6710: aload 11
    //   6712: ldc_w 916
    //   6715: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6718: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6721: aload 11
    //   6723: ldc_w 916
    //   6726: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6729: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6732: getfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   6735: bipush 191
    //   6737: iand
    //   6738: putfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   6741: aload 11
    //   6743: ldc_w 720
    //   6746: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6749: checkcast 720	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   6752: iconst_0
    //   6753: putfield 3089	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhq	I
    //   6756: goto -2442 -> 4314
    //   6759: aload 11
    //   6761: ldc_w 916
    //   6764: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6767: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6770: iconst_1
    //   6771: putfield 3188	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfJ	Z
    //   6774: goto -2179 -> 4595
    //   6777: aload_2
    //   6778: getfield 3295	com/tencent/mm/protocal/protobuf/auv:SGW	I
    //   6781: iconst_2
    //   6782: invokestatic 835	com/tencent/mm/ae/d:dr	(II)Z
    //   6785: ifne -2190 -> 4595
    //   6788: ldc_w 726
    //   6791: ldc_w 3331
    //   6794: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6797: aload 11
    //   6799: ldc_w 916
    //   6802: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6805: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6808: iconst_0
    //   6809: putfield 3185	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfH	Z
    //   6812: aload 11
    //   6814: ldc_w 916
    //   6817: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6820: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6823: aload 11
    //   6825: ldc_w 916
    //   6828: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6831: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6834: getfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   6837: sipush -129
    //   6840: iand
    //   6841: putfield 1049	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfa	I
    //   6844: aload 11
    //   6846: ldc_w 916
    //   6849: invokevirtual 854	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   6852: checkcast 916	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   6855: iconst_0
    //   6856: putfield 3194	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:zfG	I
    //   6859: goto -2264 -> 4595
    //   6862: aconst_null
    //   6863: astore 11
    //   6865: goto -2184 -> 4681
    //   6868: aconst_null
    //   6869: astore 11
    //   6871: goto -2114 -> 4757
    //   6874: aconst_null
    //   6875: astore 11
    //   6877: goto -2032 -> 4845
    //   6880: aconst_null
    //   6881: astore 11
    //   6883: goto -1873 -> 5010
    //   6886: goto -5255 -> 1631
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6889	0	paramInt1	int
    //   0	6889	1	paramInt2	int
    //   0	6889	2	paramauv	auv
    //   0	6889	3	paramInt3	int
    //   707	21	4	i	int
    //   27	5954	5	l1	long
    //   2229	1243	7	l2	long
    //   37	5956	9	bool1	boolean
    //   2301	3698	10	bool2	boolean
    //   9	5046	11	localObject1	Object
    //   5059	15	11	localException1	Exception
    //   5080	750	11	localObject2	Object
    //   5834	15	11	localException2	Exception
    //   5855	1027	11	localObject3	Object
    //   15	6632	12	localObject4	Object
    //   1016	5362	13	localObject5	Object
    //   787	5380	14	localb	com.tencent.mm.plugin.finder.live.viewmodel.data.business.b
    //   1198	5035	15	localObject6	Object
    //   1203	1603	16	localObject7	Object
    //   1218	1581	17	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   1123	1131	5059	java/lang/Exception
    //   1860	1868	5834	java/lang/Exception
  }
  
  public static <T extends androidx.lifecycle.x> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(283335);
    kotlin.g.b.p.k(paramClass, "bu");
    com.tencent.mm.plugin.finder.live.model.context.a locala = yds;
    if (locala != null)
    {
      paramClass = locala.business(paramClass);
      AppMethodBeat.o(283335);
      return paramClass;
    }
    AppMethodBeat.o(283335);
    return null;
  }
  
  public static boolean bvS()
  {
    return fFE;
  }
  
  public static void bvY()
  {
    Object localObject2 = null;
    AppMethodBeat.i(283371);
    if ((kHp instanceof com.tencent.mm.live.core.core.c.c))
    {
      Object localObject3 = kHp;
      Object localObject1 = localObject3;
      if (!(localObject3 instanceof com.tencent.mm.live.core.core.c.c)) {
        localObject1 = null;
      }
      localObject3 = (com.tencent.mm.live.core.core.c.c)localObject1;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((com.tencent.mm.live.core.core.c.c)localObject3).aMh());
      }
      Log.i("Finder.FinderLiveService", "requestLinkMic ret:".concat(String.valueOf(localObject1)));
    }
    AppMethodBeat.o(283371);
  }
  
  public static void bvZ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(283353);
    StringBuilder localStringBuilder = new StringBuilder("stopRefreshMic curLive:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
      if (localObject1 == null) {}
    }
    for (localObject1 = Long.valueOf(((bac)localObject1).liveId);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(" curLinkUser:");
      com.tencent.mm.plugin.finder.live.viewmodel.data.business.f localf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.zhl;
      }
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = yhz;
      if (localObject1 == null) {
        break;
      }
      ((as)localObject1).dzV();
      AppMethodBeat.o(283353);
      return;
    }
    AppMethodBeat.o(283353);
  }
  
  public static void bwb()
  {
    Object localObject2 = null;
    AppMethodBeat.i(283356);
    StringBuilder localStringBuilder = new StringBuilder("stopActivateMic curLive:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
      if (localObject1 == null) {}
    }
    for (localObject1 = Long.valueOf(((bac)localObject1).liveId);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(" curLinkUser:");
      com.tencent.mm.plugin.finder.live.viewmodel.data.business.f localf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.zhl;
      }
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = yhA;
      if (localObject1 == null) {
        break;
      }
      ((as)localObject1).dzV();
      AppMethodBeat.o(283356);
      return;
    }
    AppMethodBeat.o(283356);
  }
  
  public static void bwc()
  {
    AppMethodBeat.i(283374);
    Log.i("Finder.FinderLiveService", "removeBattleEndDelayTimer");
    MMHandlerThread.removeRunnable((Runnable)yhr);
    AppMethodBeat.o(283374);
  }
  
  public static void bwd()
  {
    AppMethodBeat.i(283372);
    if ((kHp instanceof com.tencent.mm.live.core.core.a.b))
    {
      com.tencent.mm.live.core.core.trtc.a locala = kHp;
      Object localObject = locala;
      if (!(locala instanceof com.tencent.mm.live.core.core.a.b)) {
        localObject = null;
      }
      localObject = (com.tencent.mm.live.core.core.a.b)localObject;
      if (localObject != null)
      {
        ((com.tencent.mm.live.core.core.a.b)localObject).aLf();
        AppMethodBeat.o(283372);
        return;
      }
    }
    AppMethodBeat.o(283372);
  }
  
  public static void c(com.tencent.mm.cd.b paramb)
  {
    yhl = paramb;
  }
  
  public static void callLiveExperimentalAPI(String paramString)
  {
    AppMethodBeat.i(283415);
    com.tencent.mm.live.core.core.trtc.a locala = kHp;
    if (locala != null)
    {
      locala.knl.callExperimentalAPI(paramString);
      AppMethodBeat.o(283415);
      return;
    }
    AppMethodBeat.o(283415);
  }
  
  public static void controlLiveMiniWindowVisibility(boolean paramBoolean, final Context paramContext)
  {
    AppMethodBeat.i(283394);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(paramBoolean, paramContext));
    AppMethodBeat.o(283394);
  }
  
  private static boolean d(Long paramLong)
  {
    AppMethodBeat.i(283376);
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
    long l;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).liveInfo;
      if (localObject != null)
      {
        l = ((bac)localObject).liveId;
        if ((l != 0L) && (paramLong != null)) {
          break label57;
        }
      }
    }
    label57:
    while (l != paramLong.longValue())
    {
      AppMethodBeat.o(283376);
      return true;
      l = 0L;
      break;
    }
    AppMethodBeat.o(283376);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.live.viewmodel.data.g dwh()
  {
    return yhh;
  }
  
  public static com.tencent.mm.live.core.core.c.c dzA()
  {
    AppMethodBeat.i(283387);
    if ((kHp != null) && ((kHp instanceof com.tencent.mm.live.core.core.c.c)))
    {
      localObject = kHp;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.visitor.LiveVisitorTRTCCore");
        AppMethodBeat.o(283387);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.live.core.core.c.c)localObject;
      AppMethodBeat.o(283387);
      return localObject;
    }
    if ((kHp != null) && ((kHp instanceof com.tencent.mm.live.core.core.b.a)))
    {
      localObject = kHp;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.secdevice.LiveSecondaryDeviceTRTCCore");
        AppMethodBeat.o(283387);
        throw ((Throwable)localObject);
      }
    }
    for (Object localObject = (com.tencent.mm.live.core.core.b.a)localObject;; localObject = null)
    {
      localObject = (com.tencent.mm.live.core.core.c.c)localObject;
      AppMethodBeat.o(283387);
      return localObject;
    }
  }
  
  public static com.tencent.mm.live.core.core.a.b dzB()
  {
    AppMethodBeat.i(283388);
    if ((kHp != null) && ((kHp instanceof com.tencent.mm.live.core.core.a.b)))
    {
      Object localObject = kHp;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
        AppMethodBeat.o(283388);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.live.core.core.a.b)localObject;
      AppMethodBeat.o(283388);
      return localObject;
    }
    AppMethodBeat.o(283388);
    return null;
  }
  
  public static void dzC()
  {
    AppMethodBeat.i(283401);
    ??? = yhd;
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zgz;
      localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject3 == null) {
        break label134;
      }
    }
    label134:
    for (Object localObject3 = Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject3).zgA);; localObject3 = null)
    {
      ??? = ((k)???).yeR;
      kotlin.g.b.p.j(???, "externalLiveCallbacks");
      synchronized ((Iterable)???)
      {
        Iterator localIterator = ((Iterable)???).iterator();
        if (!localIterator.hasNext()) {
          break label139;
        }
        com.tencent.c.a.a.a.a locala = (com.tencent.c.a.a.a.a)localIterator.next();
        Log.i(k.TAG, "notifyMiniWindowStatusToExternal isShown:true");
        locala.d((String)localObject1, (Integer)localObject3);
      }
      localx = null;
      break;
    }
    label139:
    kotlin.x localx = kotlin.x.aazN;
    AppMethodBeat.o(283401);
  }
  
  public static void dzD()
  {
    AppMethodBeat.i(283402);
    an localan = ybM;
    if (localan != null)
    {
      an.a.a(localan, (kotlin.g.a.s)ah.g.yhG);
      AppMethodBeat.o(283402);
      return;
    }
    AppMethodBeat.o(283402);
  }
  
  public static void dzE()
  {
    AppMethodBeat.i(283406);
    Object localObject = kHp;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.model.h)localObject).isFloatMode() == true))
      {
        localObject = kHp;
        if (localObject != null)
        {
          ((com.tencent.mm.live.core.core.trtc.a)localObject).aJz();
          AppMethodBeat.o(283406);
          return;
        }
        AppMethodBeat.o(283406);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("fullScreen liveStatus:");
    localObject = kHp;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;; localObject = null)
    {
      Log.i("Finder.FinderLiveService", localObject);
      AppMethodBeat.o(283406);
      return;
    }
  }
  
  public static com.tencent.mm.plugin.finder.live.view.a dzf()
  {
    return ydt;
  }
  
  public static com.tencent.mm.plugin.finder.live.view.e dzg()
  {
    return xWd;
  }
  
  public static int dzh()
  {
    return yhg;
  }
  
  public static HashMap<Integer, com.tencent.mm.live.core.d.a.a> dzi()
  {
    return filterMap;
  }
  
  public static com.tencent.mm.plugin.finder.live.model.context.a dzj()
  {
    return yds;
  }
  
  public static int dzk()
  {
    return yhi;
  }
  
  public static int dzl()
  {
    return yhj;
  }
  
  public static com.tencent.mm.cd.b dzm()
  {
    return yhl;
  }
  
  public static int dzn()
  {
    return yhm;
  }
  
  public static int dzo()
  {
    return yhn;
  }
  
  public static boolean dzp()
  {
    return yho;
  }
  
  public static boolean dzq()
  {
    return yhp;
  }
  
  public static boolean dzr()
  {
    return yhq;
  }
  
  public static void dzs()
  {
    AppMethodBeat.i(283344);
    c localc = yhe;
    if (localc != null)
    {
      localc.oJ(true);
      AppMethodBeat.o(283344);
      return;
    }
    AppMethodBeat.o(283344);
  }
  
  private static void dzt()
  {
    AppMethodBeat.i(283349);
    yhx = new as("heartBeatLooper", kvy, 2);
    yhy = new as("keepLiveLooper", kvx, 2);
    yhz = new as("refreshMicLooper", yhv, 2);
    yhA = new as("activateMicLooper", yhw, 2);
    AppMethodBeat.o(283349);
  }
  
  private static void dzu()
  {
    Object localObject5 = null;
    AppMethodBeat.i(283351);
    Log.i("Finder.FinderLiveService", "setupBeautyAndFilterConfig");
    Object localObject1 = e.f.kkj;
    int i = e.f.aKj();
    localObject1 = com.tencent.mm.live.core.d.a.ksS;
    localObject1 = com.tencent.mm.live.core.d.a.aNl();
    Object localObject2 = e.f.kkj;
    localObject2 = (String)((HashMap)localObject1).get(Integer.valueOf(e.f.aKj()));
    if (localObject2 == null) {
      localObject2 = "";
    }
    for (;;)
    {
      kotlin.g.b.p.j(localObject2, "LiveFilterUtil.filterCac…IVE_FILTER_DEFAULT] ?: \"\"");
      localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
      Object localObject6 = d.a.aAK(z.bdh());
      if ((localObject6 != null) && (((com.tencent.mm.plugin.finder.api.i)localObject6).apt() == 1)) {
        localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vYK, "{\"skin_smooth\":55,\"eye_morph\":20,\"face_morph\":50,\"skin_bright\":55,\"eye_bright\":20,\"filter\":40,\"rosy\":0,\"filterKey\":0}");
      }
      try
      {
        localObject3 = new com.tencent.mm.ad.i((String)localObject1);
        j = ((com.tencent.mm.ad.i)localObject3).getInt("filter");
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            k = ((com.tencent.mm.ad.i)localObject3).getInt("filterKey");
            i = k;
          }
          catch (Exception localException2)
          {
            Object localObject3;
            int j;
            int k;
            Object localObject7;
            int m;
            Object localObject4;
            continue;
          }
          try
          {
            localObject3 = com.tencent.mm.live.core.d.a.ksS;
            localObject3 = (String)com.tencent.mm.live.core.d.a.aNl().get(Integer.valueOf(i));
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject7 = new StringBuilder("self.sex:");
            if (localObject6 == null) {
              continue;
            }
            localObject3 = Integer.valueOf(((com.tencent.mm.plugin.finder.api.i)localObject6).apt());
            Log.i("Finder.FinderLiveService", localObject3 + " expt beautyConfig:[" + j + ", " + (String)localObject2 + ", " + i + "] exptConfig:" + (String)localObject1);
            yhg = j;
            localObject3 = ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveConfigStorage().dDM();
            localObject1 = localObject2;
            m = i;
            k = j;
            if (j != -1)
            {
              localObject1 = localObject2;
              m = i;
              k = j;
              if (localObject3 != null)
              {
                localObject1 = com.tencent.mm.live.core.d.a.ksS;
                localObject1 = localObject2;
                m = i;
                k = j;
                if (com.tencent.mm.vfs.u.agG((String)com.tencent.mm.live.core.d.a.aNl().get(Integer.valueOf(((crp)localObject3).key))))
                {
                  m = ((crp)localObject3).key;
                  localObject1 = com.tencent.mm.live.core.d.a.ksS;
                  localObject2 = (String)com.tencent.mm.live.core.d.a.aNl().get(Integer.valueOf(((crp)localObject3).key));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  k = ((crp)localObject3).value;
                }
              }
            }
            Log.i("Finder.FinderLiveService", "final beautyConfig:[" + k + ", " + (String)localObject1 + ", " + m + ']');
            localObject2 = new com.tencent.mm.live.core.b.a();
            localObject3 = a.ydb;
            i = a.dxL();
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(0), Integer.valueOf(a.gF(i, 0)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(1), Integer.valueOf(a.gF(i, 1)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(4), Integer.valueOf(a.gF(i, 4)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(2), Integer.valueOf(a.gF(i, 2)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(3), Integer.valueOf(a.gF(i, 3)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(6), Integer.valueOf(a.gF(i, 6)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(7), Integer.valueOf(a.gF(i, 7)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(8), Integer.valueOf(a.gF(i, 8)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(9), Integer.valueOf(a.gF(i, 9)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(10), Integer.valueOf(a.gF(i, 10)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(11), Integer.valueOf(a.gF(i, 11)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(12), Integer.valueOf(a.gF(i, 12)));
            ((Map)((com.tencent.mm.live.core.b.a)localObject2).kra).put(Integer.valueOf(13), Integer.valueOf(a.gF(i, 13)));
            knC = (com.tencent.mm.live.core.b.a)localObject2;
            localObject3 = new StringBuilder("#setupBeautyAndFilterConfig beautyConfig=");
            localObject6 = knC;
            localObject2 = localObject5;
            if (localObject6 != null) {
              localObject2 = ((com.tencent.mm.live.core.b.a)localObject6).toString();
            }
            Log.i("Finder.FinderLiveService", (String)localObject2);
            knD = new com.tencent.mm.live.core.b.b(m, (String)localObject1, k);
            filterMap.clear();
            localObject1 = com.tencent.mm.live.core.d.a.ksS;
            localObject1 = ((Map)com.tencent.mm.live.core.d.a.aNl()).entrySet().iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            localObject3 = (Map)filterMap;
            localObject5 = ((Map.Entry)localObject2).getKey();
            i = ((Number)((Map.Entry)localObject2).getKey()).intValue();
            localObject6 = (String)((Map.Entry)localObject2).getValue();
            localObject7 = com.tencent.mm.live.core.d.a.ksS;
            ((Map)localObject3).put(localObject5, new com.tencent.mm.live.core.d.a.a(i, (String)localObject6, com.tencent.mm.live.core.d.a.tB(((Number)((Map.Entry)localObject2).getKey()).intValue()), yhg));
            continue;
            if ((localObject6 != null) && (((com.tencent.mm.plugin.finder.api.i)localObject6).apt() == 2))
            {
              localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vYL, "{\"skin_smooth\":80,\"eye_morph\":40,\"face_morph\":75,\"skin_bright\":80,\"eye_bright\":20,\"filter\":40,\"rosy\":0,\"filterKey\":0}");
              continue;
            }
            localObject3 = z.bdN();
            localObject7 = new StringBuilder("read sex from finder contact fail, try again from contact:");
            if (localObject3 != null)
            {
              localObject1 = Integer.valueOf(((com.tencent.mm.storage.as)localObject3).apt());
              Log.i("Finder.FinderLiveService", localObject1);
              if ((localObject3 != null) && (((com.tencent.mm.storage.as)localObject3).apt() == 1)) {
                localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vYK, "{\"skin_smooth\":55,\"eye_morph\":20,\"face_morph\":50,\"skin_bright\":55,\"eye_bright\":20,\"filter\":40,\"rosy\":0,\"filterKey\":0}");
              }
            }
            else
            {
              localObject1 = null;
              continue;
            }
            if ((localObject3 != null) && (((com.tencent.mm.storage.as)localObject3).apt() == 2))
            {
              localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vYL, "{\"skin_smooth\":80,\"eye_morph\":40,\"face_morph\":75,\"skin_bright\":80,\"eye_bright\":20,\"filter\":40,\"rosy\":0,\"filterKey\":0}");
              continue;
            }
            localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vYK, "{\"skin_smooth\":55,\"eye_morph\":20,\"face_morph\":50,\"skin_bright\":55,\"eye_bright\":20,\"filter\":40,\"rosy\":0,\"filterKey\":0}");
          }
          catch (Exception localException3)
          {
            continue;
          }
          localException1 = localException1;
          j = -1;
          Log.w("Finder.FinderLiveService", "parse clicfg_live_beauty_config fail. " + localException1.getMessage());
          continue;
          localObject4 = null;
          continue;
          AppMethodBeat.o(283351);
          return;
        }
      }
    }
  }
  
  public static void dzw()
  {
    AppMethodBeat.i(283365);
    kKI.bct();
    ac localac = ac.ygU;
    ac.dyY();
    AppMethodBeat.o(283365);
  }
  
  public static void dzy()
  {
    AppMethodBeat.i(283368);
    Log.i("Finder.FinderLiveService", "setAnchorPauseMiniView");
    com.tencent.mm.live.core.core.trtc.a locala = kHp;
    if (locala != null)
    {
      locala.sV(2);
      AppMethodBeat.o(283368);
      return;
    }
    AppMethodBeat.o(283368);
  }
  
  public static boolean dzz()
  {
    AppMethodBeat.i(283386);
    Object localObject = Build.MODEL;
    kotlin.g.b.p.j(localObject, "Build.MODEL");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(283386);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).toLowerCase();
    kotlin.g.b.p.j(localObject, "(this as java.lang.String).toLowerCase()");
    if (!n.a((CharSequence)yhf, (CharSequence)localObject, false)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.FinderLiveService", "enableDynamicVideoParam notSupportDynamicVideoParamDevice:" + yhf + " model:" + (String)localObject + " result:" + bool);
      AppMethodBeat.o(283386);
      return bool;
    }
  }
  
  public static void enableAudioVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(283413);
    com.tencent.mm.live.core.core.trtc.a locala = kHp;
    if (locala != null)
    {
      locala.knl.enableAudioVolumeEvaluation(paramInt);
      AppMethodBeat.o(283413);
      return;
    }
    AppMethodBeat.o(283413);
  }
  
  public static void enableCustomAudioCapture(boolean paramBoolean)
  {
    AppMethodBeat.i(283411);
    com.tencent.mm.live.core.core.trtc.a locala = kHp;
    if (locala != null)
    {
      locala.knl.enableCustomAudioCapture(paramBoolean);
      AppMethodBeat.o(283411);
      return;
    }
    AppMethodBeat.o(283411);
  }
  
  public static void enableMicExternalAudioFrame(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(283412);
    com.tencent.mm.live.core.core.trtc.a locala = kHp;
    if (locala != null)
    {
      locala.knl.enableMixExternalAudioFrame(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(283412);
      return;
    }
    AppMethodBeat.o(283412);
  }
  
  public static an getFinderLiveAssistant()
  {
    return ybM;
  }
  
  public static azg getFinderLiveExternalInfo()
  {
    return yhd.yeS;
  }
  
  public static void getFinderLiveMemberListInfo(com.tencent.mm.plugin.findersdk.a.ag.a<List<bas>> parama)
  {
    AppMethodBeat.i(283393);
    kotlin.g.b.p.k(parama, "callback");
    k.a(ybM, yds, parama);
    AppMethodBeat.o(283393);
  }
  
  public static com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    return kHp;
  }
  
  public static void h(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(283334);
    Log.i("Finder.FinderLiveService", "write curLiveRoomData to :".concat(String.valueOf(parama)));
    yds = parama;
    AppMethodBeat.o(283334);
  }
  
  public static void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(283373);
    Log.i("Finder.FinderLiveService", "startBattleEndDelayTimer delay:" + paramLong + " battleId:" + paramString);
    MMHandlerThread.removeRunnable((Runnable)yhr);
    paramString = new a(paramString);
    yhr = paramString;
    MMHandlerThread.postToMainThreadDelayed((Runnable)paramString, paramLong);
    AppMethodBeat.o(283373);
  }
  
  public static boolean isAnchorLiving()
  {
    AppMethodBeat.i(283382);
    com.tencent.mm.plugin.finder.live.model.context.a locala = yds;
    if ((locala != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId != 0L) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGN()) && (fFE))
    {
      AppMethodBeat.o(283382);
      return true;
    }
    AppMethodBeat.o(283382);
    return false;
  }
  
  public static boolean isVisitorLiving()
  {
    AppMethodBeat.i(283383);
    com.tencent.mm.plugin.finder.live.model.context.a locala = yds;
    if ((locala != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId != 0L) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGN()) && (!fFE))
    {
      AppMethodBeat.o(283383);
      return true;
    }
    AppMethodBeat.o(283383);
    return false;
  }
  
  public static void mixExternalAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(283414);
    com.tencent.mm.live.core.core.trtc.a locala = kHp;
    if (locala != null)
    {
      TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
      localTRTCAudioFrame.data = paramArrayOfByte;
      localTRTCAudioFrame.sampleRate = paramInt1;
      localTRTCAudioFrame.channel = paramInt2;
      localTRTCAudioFrame.timestamp = paramLong;
      locala.knl.mixExternalAudioFrame(localTRTCAudioFrame);
      AppMethodBeat.o(283414);
      return;
    }
    AppMethodBeat.o(283414);
  }
  
  public static boolean needMirror()
  {
    AppMethodBeat.i(283385);
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
    boolean bool;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).kvS;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
        if (localObject == null) {
          break label140;
        }
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).kvS;
        if (localObject == null) {
          break label140;
        }
        localObject = ((com.tencent.mm.live.core.core.model.g)localObject).kmp;
        if ((localObject == null) || (((com.tencent.mm.live.core.core.model.e)localObject).kme != true)) {
          break label140;
        }
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject == null) {
        break label135;
      }
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).kvS;
      if (localObject == null) {
        break label135;
      }
      localObject = ((com.tencent.mm.live.core.core.model.g)localObject).kmp;
      if (localObject == null) {
        break label135;
      }
      bool = ((com.tencent.mm.live.core.core.model.e)localObject).kmh;
      label106:
      Log.i("Finder.FinderLiveService", "use front camera, finalMirror:".concat(String.valueOf(bool)));
    }
    for (;;)
    {
      AppMethodBeat.o(283385);
      return bool;
      localObject = null;
      break;
      label135:
      bool = true;
      break label106;
      label140:
      bool = false;
      Log.i("Finder.FinderLiveService", "use back camera, finalMirror:false");
    }
  }
  
  public static void oN(boolean paramBoolean)
  {
    AppMethodBeat.i(283366);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ab(paramBoolean));
    AppMethodBeat.o(283366);
  }
  
  private static void oO(boolean paramBoolean)
  {
    Object localObject3 = null;
    AppMethodBeat.i(283404);
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    Object localObject4;
    Object localObject5;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zgj;
      if (localObject1 != null)
      {
        localObject1 = ((b)localObject1).dxN();
        localObject4 = yds;
        if ((localObject4 == null) || (localObject1 == null)) {
          break label347;
        }
        localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject4).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
        if (localObject5 == null) {
          break label264;
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject4).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
        if (localObject2 == null) {
          break label259;
        }
        localObject2 = Integer.valueOf(((b)localObject2).fFw);
        label98:
        localObject2 = ((b)localObject5).d((aq)localObject1, ((Integer)localObject2).intValue());
        label109:
        localObject5 = (aq)((kotlin.o)localObject2).Mx;
        if (localObject5 == null) {
          break label269;
        }
        a((aq)localObject5, ((Number)((kotlin.o)localObject2).My).intValue(), true);
        oP(paramBoolean);
      }
    }
    label259:
    label264:
    label269:
    label347:
    for (localObject1 = kotlin.x.aazN;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        oP(paramBoolean);
        localObject1 = dzB();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject1).knH = false;
        }
        localObject2 = new StringBuilder("playNext error curMusicItem:");
        localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject4).zgj;
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = ((b)localObject4).dxN();
          }
        }
        Log.e("Finder.FinderLiveService", localObject1 + ",curLiveRoomData:" + yds);
        localObject1 = kotlin.x.aazN;
      }
      AppMethodBeat.o(283404);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label98;
      localObject2 = null;
      break label109;
      localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject4).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject4).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
      if (localObject2 != null) {}
      for (localObject2 = Integer.valueOf(((b)localObject2).fFw);; localObject2 = null)
      {
        ((b)localObject5).c((aq)localObject1, ((Integer)localObject2).intValue());
        oP(paramBoolean);
        localObject1 = dzB();
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.live.core.core.trtc.a)localObject1).knH = false;
        break;
      }
    }
  }
  
  private static void oP(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(283405);
    Object localObject3 = ydt;
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof com.tencent.mm.plugin.finder.live.view.b)) {
      localObject1 = null;
    }
    localObject3 = (com.tencent.mm.plugin.finder.live.view.b)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = (com.tencent.mm.plugin.finder.live.plugin.u)((com.tencent.mm.plugin.finder.live.view.b)localObject3).getPlugin(com.tencent.mm.plugin.finder.live.plugin.u.class);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.u)localObject3).xYU;
      }
    }
    if (paramBoolean)
    {
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.component.a.a)localObject1).dwY();
        AppMethodBeat.o(283405);
        return;
      }
      AppMethodBeat.o(283405);
      return;
    }
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.finder.live.component.a.a)localObject1).playStart();
      AppMethodBeat.o(283405);
      return;
    }
    AppMethodBeat.o(283405);
  }
  
  public static void pauseLive(int paramInt)
  {
    AppMethodBeat.i(283417);
    StringBuilder localStringBuilder = new StringBuilder("pauseLive: liveStarted:");
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted());; localObject = null)
    {
      Log.i("Finder.FinderLiveService", localObject + ", scene:" + paramInt);
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject == null) {
        break;
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).isLiveStarted() == true) {
        break label104;
      }
      AppMethodBeat.o(283417);
      return;
    }
    AppMethodBeat.o(283417);
    return;
    label104:
    localObject = ybM;
    if (localObject != null)
    {
      ((an)localObject).a(1, paramInt, (ad.a)new v());
      AppMethodBeat.o(283417);
      return;
    }
    AppMethodBeat.o(283417);
  }
  
  public static void registerExternalLiveCallback(com.tencent.c.a.a.a.a parama)
  {
    AppMethodBeat.i(283391);
    kotlin.g.b.p.k(parama, "callback");
    k localk = yhd;
    kotlin.g.b.p.k(parama, "callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new k.f(localk, parama));
    AppMethodBeat.o(283391);
  }
  
  public static void resumeLive(int paramInt)
  {
    AppMethodBeat.i(283418);
    an localan = ybM;
    if (localan != null)
    {
      localan.a(2, paramInt, (ad.a)new ac());
      AppMethodBeat.o(283418);
      return;
    }
    AppMethodBeat.o(283418);
  }
  
  public static void s(LinkedList<dlk> paramLinkedList)
  {
    AppMethodBeat.i(283375);
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        dlk localdlk = (dlk)paramLinkedList.next();
        Log.i("Finder.FinderLiveService", "[Battle] player:[" + localdlk.RLN + ", " + localdlk.TSv + ']');
      }
      AppMethodBeat.o(283375);
      return;
    }
    AppMethodBeat.o(283375);
  }
  
  public static void setCustomResolution(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(283416);
    Object localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
    kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).tg(paramInt1);
    localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
    kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).th(paramInt2);
    localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
    kotlin.g.b.p.j(localObject, "ConfigHelper.getInstance().videoConfig");
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject).fd(paramBoolean);
    localObject = kHp;
    if (localObject != null)
    {
      ((com.tencent.mm.live.core.core.trtc.a)localObject).aLB();
      AppMethodBeat.o(283416);
      return;
    }
    AppMethodBeat.o(283416);
  }
  
  public static void setVoiceCaptureVolume(int paramInt)
  {
    AppMethodBeat.i(283419);
    Object localObject = kHp;
    if (localObject != null)
    {
      Log.i("MicroMsg.LiveCore", "setVoiceCaptureVolume volume:".concat(String.valueOf(paramInt)));
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knl.getAudioEffectManager();
      if (localObject != null)
      {
        ((TXAudioEffectManager)localObject).setVoiceCaptureVolume(paramInt);
        AppMethodBeat.o(283419);
        return;
      }
      AppMethodBeat.o(283419);
      return;
    }
    AppMethodBeat.o(283419);
  }
  
  public static void startLocalAudio(boolean paramBoolean)
  {
    AppMethodBeat.i(283410);
    com.tencent.mm.live.core.core.trtc.a locala = kHp;
    if (locala != null)
    {
      if (paramBoolean)
      {
        locala.knl.startLocalAudio();
        AppMethodBeat.o(283410);
        return;
      }
      locala.knl.stopLocalAudio();
      AppMethodBeat.o(283410);
      return;
    }
    AppMethodBeat.o(283410);
  }
  
  public static void unregisterExternalLiveCallback(com.tencent.c.a.a.a.a parama)
  {
    AppMethodBeat.i(283392);
    kotlin.g.b.p.k(parama, "callback");
    k localk = yhd;
    kotlin.g.b.p.k(parama, "callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new k.g(localk, parama));
    AppMethodBeat.o(283392);
  }
  
  public final void callback(int paramInt, Bundle arg2)
  {
    Object localObject6 = null;
    AppMethodBeat.i(283378);
    Object localObject1 = ydt;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject1).onLiveEventCallback(paramInt, ???);
    }
    if (fFE)
    {
      k localk = yhd;
      localObject1 = kHp;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
        if (localObject1 != null) {
          localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).kmC;
        }
      }
      for (;;)
      {
        ??? = kHp;
        e.e locale = e.e.kjZ;
        if (paramInt != e.e.aKg()) {
          break label330;
        }
        ??? = localObject6;
        if (??? != null)
        {
          ??? = ???.getParcelableArrayList("live_user_volume_info");
          ??? = localObject6;
          if (??? == null) {}
        }
        synchronized ((Iterable)???)
        {
          localObject6 = ((Iterable)???).iterator();
          for (;;)
          {
            if (((Iterator)localObject6).hasNext())
            {
              ??? = ((Iterator)localObject6).next();
              boolean bool = Util.isEqual(((UserVolumeInfo)???).userId, (String)localObject1);
              if (bool)
              {
                ??? = (UserVolumeInfo)???;
                if (??? == null) {
                  break label446;
                }
                ??? = localk.yeR;
                kotlin.g.b.p.j(???, "externalLiveCallbacks");
                synchronized ((Iterable)???)
                {
                  localObject1 = ???.iterator();
                  if (!((Iterator)localObject1).hasNext()) {
                    break label316;
                  }
                  localObject6 = (com.tencent.c.a.a.a.a)((Iterator)localObject1).next();
                  Log.i(k.TAG, "onLiveVoiceVolume user:" + ((UserVolumeInfo)???).userId + " volume:" + ((UserVolumeInfo)???).volume);
                  ((com.tencent.c.a.a.a.a)localObject6).Ud(((UserVolumeInfo)???).volume);
                }
                localObject3 = null;
                break;
              }
            }
          }
          ??? = null;
        }
      }
      label316:
      Object localObject3 = kotlin.x.aazN;
      AppMethodBeat.o(283378);
      return;
      label330:
      ??? = e.e.kjZ;
      if (paramInt == e.e.aJR())
      {
        if (??? == null)
        {
          AppMethodBeat.o(283378);
          return;
        }
        ??? = localk.yeR;
        kotlin.g.b.p.j(???, "externalLiveCallbacks");
        synchronized ((Iterable)???)
        {
          localObject3 = ???.iterator();
          if (((Iterator)localObject3).hasNext()) {
            ((com.tencent.c.a.a.a.a)((Iterator)localObject3).next()).hH(((com.tencent.mm.live.core.core.trtc.a)???).knJ, localk.yeT);
          }
        }
        kotlin.x localx = kotlin.x.aazN;
        AppMethodBeat.o(283378);
        return;
      }
    }
    label446:
    AppMethodBeat.o(283378);
  }
  
  public final void onComplete(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283407);
    oO(true);
    AppMethodBeat.o(283407);
  }
  
  public final void onPlayProgress(int paramInt, long paramLong1, long paramLong2) {}
  
  public final void onStart(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283409);
    Object localObject = ydt;
    com.tencent.mm.plugin.finder.live.model.context.a locala = yds;
    if ((localObject != null) && (locala != null)) {
      if (paramInt2 != 0)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u((com.tencent.mm.plugin.finder.live.view.a)localObject));
        oO(false);
      }
    }
    for (localObject = kotlin.x.aazN;; localObject = null)
    {
      if (localObject == null)
      {
        Log.e("Finder.FinderLiveService", "onStart error curLiveLayout:" + ydt + ",curLiveRoomData:" + yds);
        localObject = kotlin.x.aazN;
      }
      AppMethodBeat.o(283409);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$BattleDismissTask;", "Ljava/lang/Runnable;", "battleId", "", "(Ljava/lang/String;)V", "run", "", "plugin-finder_release"})
  public static final class a
    implements Runnable
  {
    private String yeu;
    
    public a(String paramString)
    {
      this.yeu = paramString;
    }
    
    public final void run()
    {
      AppMethodBeat.i(289442);
      String str = this.yeu;
      Object localObject = ah.yhC;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).zhz;
        if (localObject == null) {}
      }
      for (localObject = ((h)localObject).yeu; Util.isEqual(str, (String)localObject); localObject = null)
      {
        localObject = com.tencent.mm.live.b.p.kvF;
        localObject = com.tencent.mm.live.b.p.aOe();
        if (localObject != null) {
          ((com.tencent.mm.live.b.g)localObject).onBattleDismiss();
        }
        localObject = ah.yhC;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).zhz = null;
        AppMethodBeat.o(289442);
        return;
      }
      AppMethodBeat.o(289442);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$release$4", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class aa
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(234100);
      Log.i("Finder.FinderLiveService", "on exitRoom finish");
      AppMethodBeat.o(234100);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ab
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    ab(boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$resumeLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "plugin-finder_release"})
  public static final class ac
    implements ad.a
  {
    public final void a(int paramInt1, int paramInt2, bgo parambgo)
    {
      AppMethodBeat.i(290872);
      kotlin.g.b.p.k(parambgo, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        parambgo = ah.yhC;
        parambgo = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (parambgo != null)
        {
          bag localbag = new bag();
          localbag.CKC = 0;
          localbag.SMj = 0;
          parambgo.a(localbag, false, (kotlin.g.a.m)a.yhU);
          AppMethodBeat.o(290872);
          return;
        }
      }
      AppMethodBeat.o(290872);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.m<Boolean, Integer, kotlin.x>
    {
      public static final a yhU;
      
      static
      {
        AppMethodBeat.i(288794);
        yhU = new a();
        AppMethodBeat.o(288794);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$showMiniWindow$2", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder_release"})
  public static final class ae
    implements RequestFloatWindowPermissionDialog.a
  {
    ae(Context paramContext) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      boolean bool2 = true;
      AppMethodBeat.i(241245);
      kotlin.g.b.p.k(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      Object localObject = ah.yhC;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfo == true))
      {
        bool1 = true;
        paramRequestFloatWindowPermissionDialog.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", bool1);
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 3);
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
        localObject = ah.yhC;
        ah.b(paramRequestFloatWindowPermissionDialog, this.$context);
        localObject = ah.yhC;
        localObject = ah.dzj();
        if (localObject == null) {
          break label166;
        }
        ah localah = ah.yhC;
        localah = ah.yhC;
        if (ah.dzB() == null) {
          break label161;
        }
      }
      label161:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ah.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject, bool1, b.c.kzi, paramRequestFloatWindowPermissionDialog, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId);
        AppMethodBeat.o(241245);
        return;
        bool1 = false;
        break;
      }
      label166:
      AppMethodBeat.o(241245);
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      boolean bool = true;
      AppMethodBeat.i(241247);
      kotlin.g.b.p.k(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      paramRequestFloatWindowPermissionDialog.putBoolean("PARAM_LIVE_MINI_WINDOW_AUTO", true);
      Object localObject = ah.yhC;
      localObject = ah.dzj();
      if (localObject != null)
      {
        ah localah = ah.yhC;
        localah = ah.yhC;
        if (ah.dzB() != null) {}
        for (;;)
        {
          ah.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject, bool, b.c.kzl, paramRequestFloatWindowPermissionDialog, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId);
          AppMethodBeat.o(241247);
          return;
          bool = false;
        }
      }
      AppMethodBeat.o(241247);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      boolean bool = true;
      AppMethodBeat.i(241249);
      kotlin.g.b.p.k(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog = new Bundle();
      paramRequestFloatWindowPermissionDialog.putBoolean("PARAM_LIVE_MINI_WINDOW_AUTO", true);
      Object localObject = ah.yhC;
      localObject = ah.dzj();
      if (localObject != null)
      {
        ah localah = ah.yhC;
        localah = ah.yhC;
        if (ah.dzB() != null) {}
        for (;;)
        {
          ah.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject, bool, b.c.kzm, paramRequestFloatWindowPermissionDialog, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId);
          AppMethodBeat.o(241249);
          return;
          bool = false;
        }
      }
      AppMethodBeat.o(241249);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class af
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    public static final af yhW;
    
    static
    {
      AppMethodBeat.i(242825);
      yhW = new af();
      AppMethodBeat.o(242825);
    }
    
    af()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$voipCallEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class ag
    extends IListener<aaq>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$HeartBeatGuardTask;", "Ljava/lang/Runnable;", "bindLiveId", "", "(J)V", "run", "", "plugin-finder_release"})
  public static final class b
    implements Runnable
  {
    private long yhD;
    
    public b(long paramLong)
    {
      this.yhD = paramLong;
    }
    
    public final void run()
    {
      AppMethodBeat.i(272033);
      Object localObject1 = ah.yhC;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      long l;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
        if (localObject1 != null)
        {
          l = ((bac)localObject1).liveId;
          localObject1 = ah.yhC;
          if (ah.dzj() != null)
          {
            localObject1 = ah.yhC;
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
            if (((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).dGN() != true)) && (l == this.yhD)) {
              break label185;
            }
          }
          localObject1 = new StringBuilder("heartBeat manual recovery skipped. curLiveRoomData:");
          localObject2 = ah.yhC;
          localObject2 = ((StringBuilder)localObject1).append(ah.dzj()).append(" business(LiveCommonSlice::class.java)?.isLiveFinish():");
          localObject1 = ah.yhC;
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (localObject1 == null) {
            break label180;
          }
        }
      }
      label180:
      for (localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).dGN());; localObject1 = null)
      {
        Log.i("Finder.FinderLiveService", localObject1 + " liveId:" + l + " bindLiveId:" + this.yhD);
        AppMethodBeat.o(272033);
        return;
        l = 0L;
        break;
      }
      label185:
      Log.i("Finder.FinderLiveService", "heartBeat manual recovery liveId:".concat(String.valueOf(l)));
      f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "liveHeartBeatBreak_manualRecovery", false, false, (kotlin.g.a.a)new a(l), 12);
      localObject1 = ah.yhC;
      ah.S(0L, l);
      AppMethodBeat.o(272033);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<String>
    {
      a(long paramLong)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$KeepAliveGuardTask;", "Ljava/lang/Runnable;", "bindLiveId", "", "(J)V", "run", "", "plugin-finder_release"})
  public static final class c
    implements Runnable
  {
    private long yhD;
    
    public c(long paramLong)
    {
      this.yhD = paramLong;
    }
    
    public final void run()
    {
      AppMethodBeat.i(277459);
      Object localObject1 = ah.yhC;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      long l;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
        if (localObject1 != null)
        {
          l = ((bac)localObject1).liveId;
          localObject1 = ah.yhC;
          if (ah.dzj() != null)
          {
            localObject1 = ah.yhC;
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
            if (((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).dGN() != true)) && (l == this.yhD)) {
              break label185;
            }
          }
          localObject1 = new StringBuilder("keepAlive manual recovery skipped. curLiveRoomData:");
          localObject2 = ah.yhC;
          localObject2 = ((StringBuilder)localObject1).append(ah.dzj()).append(" business(LiveCommonSlice::class.java)?.isLiveFinish():");
          localObject1 = ah.yhC;
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (localObject1 == null) {
            break label180;
          }
        }
      }
      label180:
      for (localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).dGN());; localObject1 = null)
      {
        Log.i("Finder.FinderLiveService", localObject1 + " liveId:" + l + " bindLiveId:" + this.yhD);
        AppMethodBeat.o(277459);
        return;
        l = 0L;
        break;
      }
      label185:
      Log.i("Finder.FinderLiveService", "keepAlive manual recovery liveId:".concat(String.valueOf(l)));
      f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "liveKeepAliveBreak_manualRecovery", false, false, (kotlin.g.a.a)new a(l), 12);
      localObject1 = ah.yhC;
      ah.Ln(0L);
      AppMethodBeat.o(277459);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<String>
    {
      a(long paramLong)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d yhE;
    
    static
    {
      AppMethodBeat.i(291574);
      yhE = new d();
      AppMethodBeat.o(291574);
    }
    
    public final void run()
    {
      AppMethodBeat.i(291573);
      ah localah = ah.yhC;
      ah.dzO();
      AppMethodBeat.o(291573);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$checkDeviceLsn$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLiveStateActionEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<ik>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pause", "", "lastPauseTime", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.m<Boolean, Integer, kotlin.x>
  {
    f(com.tencent.mm.plugin.finder.live.model.context.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    h(boolean paramBoolean, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$doActivateMic$1$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicResponse;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.finder.live.model.cgi.c.a
  {
    public final void a(apm paramapm)
    {
      AppMethodBeat.i(277026);
      kotlin.g.b.p.k(paramapm, "resp");
      paramapm = ah.yhC;
      paramapm = ah.dzI();
      if (paramapm != null) {}
      for (boolean bool = paramapm.eYG;; bool = true)
      {
        Log.i("Finder.FinderLiveService", "doActivateMic onCgiBack taskFinished:".concat(String.valueOf(bool)));
        if (!bool)
        {
          paramapm = ah.yhC;
          paramapm = ah.dzI();
          if (paramapm != null) {
            paramapm.dzU();
          }
          paramapm = ah.yhC;
          ah.Lm(20000L);
        }
        AppMethodBeat.o(277026);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$doGetLiveMsg$1$2", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "reqVisitorRoleType", "plugin-finder_release"})
  public static final class j
    implements com.tencent.c.a.a.a.c.a.b
  {
    j(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, auv paramauv, int paramInt3)
    {
      long l2 = 0L;
      boolean bool1 = false;
      Object localObject1 = null;
      StringBuilder localStringBuilder = null;
      AppMethodBeat.i(273352);
      kotlin.g.b.p.k(paramauv, "resp");
      Object localObject2 = ah.yhC;
      if (ah.dzp())
      {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yhI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN != null) {}
        for (int i = 1; i == 0; i = 0)
        {
          Log.i("Finder.FinderLiveService", "handleLiveMsgResp result false, liveCookies is empty!");
          AppMethodBeat.o(273352);
          return;
        }
      }
      localObject2 = ah.yhC;
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class);
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)localObject2).zgZ = paramauv.SGR;
      }
      boolean bool2 = ah.a(ah.yhC, paramInt2, paramInt1, paramauv, paramInt3);
      localObject2 = ah.yhC;
      localObject2 = ah.dzF();
      if ((localObject2 == null) || (((as)localObject2).eYG != true)) {
        bool1 = true;
      }
      localObject2 = ah.yhC;
      localObject2 = ah.dzF();
      if (localObject2 != null) {
        ((as)localObject2).dzU();
      }
      long l1;
      if (paramauv.SHc > 0)
      {
        paramInt1 = paramauv.SHc * 1000;
        if (!bool2) {
          break label282;
        }
        localObject1 = ah.yhC;
        l2 = paramInt1;
        paramauv = paramauv.liveInfo;
        if (paramauv == null) {
          break label276;
        }
        l1 = paramauv.liveId;
        label221:
        ah.S(l2, l1);
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)a.yhJ);
        AppMethodBeat.o(273352);
        return;
        if (bool2)
        {
          localObject2 = com.tencent.c.a.a.a.a.a.Zlt;
          paramInt1 = ((Number)com.tencent.c.a.a.a.a.a.inc().aSr()).intValue();
          break;
        }
        paramInt1 = 5000;
        break;
        label276:
        l1 = 0L;
        break label221;
        label282:
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yhI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGN())
        {
          localObject2 = new StringBuilder("handleLiveMsgResp result false, will retry heartbeat delay:").append(paramInt1).append(". localLiveId:");
          localObject1 = ah.yhC;
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
            if (localObject1 == null) {}
          }
          for (localObject1 = Long.valueOf(((bac)localObject1).liveId);; localObject1 = null)
          {
            Log.i("Finder.FinderLiveService", localObject1 + ", haveHeartTaskRunning:" + bool1);
            localObject1 = ah.yhC;
            if (ah.dzp())
            {
              localObject1 = ah.yhC;
              localObject1 = paramauv.liveInfo;
              paramauv = localStringBuilder;
              if (localObject1 != null) {
                paramauv = Long.valueOf(((bac)localObject1).liveId);
              }
              if ((ah.e(paramauv)) && (bool1)) {
                break;
              }
            }
            paramauv = ah.yhC;
            long l3 = paramInt1;
            paramauv = ah.yhC;
            paramauv = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
            l1 = l2;
            if (paramauv != null)
            {
              paramauv = paramauv.liveInfo;
              l1 = l2;
              if (paramauv != null) {
                l1 = paramauv.liveId;
              }
            }
            ah.S(l3, l1);
            break;
          }
        }
        localStringBuilder = new StringBuilder("handleLiveMsgResp result false and live is finished. localLiveId:");
        paramauv = ah.yhC;
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
        paramauv = (auv)localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject2).liveInfo;
          paramauv = (auv)localObject1;
          if (localObject2 != null) {
            paramauv = Long.valueOf(((bac)localObject2).liveId);
          }
        }
        Log.i("Finder.FinderLiveService", paramauv);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      public static final a yhJ;
      
      static
      {
        AppMethodBeat.i(291409);
        yhJ = new a();
        AppMethodBeat.o(291409);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiCallback", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "kotlin.jvm.PlatformType", "call"})
  static final class k<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    k(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c paramc) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$doRefreshMic$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "plugin-finder_release"})
  public static final class l
    implements com.tencent.mm.plugin.finder.live.model.cgi.ag.a
  {
    l(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c paramc) {}
    
    public final void b(int paramInt1, int paramInt2, bcb parambcb)
    {
      AppMethodBeat.i(279094);
      kotlin.g.b.p.k(parambcb, "resp");
      boolean bool = ah.a(ah.yhC, paramInt2, paramInt1, parambcb);
      parambcb = ah.yhC;
      parambcb = ah.dzH();
      if (parambcb != null) {
        parambcb.dzU();
      }
      if (bool)
      {
        long l = kotlin.k.i.be((this.yhI.kvP.Tzr - 60L) * 1000L, 60000L);
        parambcb = ah.yhC;
        ah.Ll(l);
      }
      AppMethodBeat.o(279094);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.live.core.core.c
  {
    m(kotlin.g.a.b paramb) {}
    
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(287691);
      this.kHb.invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(287691);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    public static final n yhK;
    
    static
    {
      AppMethodBeat.i(288375);
      yhK = new n();
      AppMethodBeat.o(288375);
    }
    
    public final void run()
    {
      AppMethodBeat.i(288374);
      ah localah = ah.yhC;
      ah.dzL();
      AppMethodBeat.o(288374);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    public static final q yhM;
    
    static
    {
      AppMethodBeat.i(286210);
      yhM = new q();
      AppMethodBeat.o(286210);
    }
    
    public final void run()
    {
      AppMethodBeat.i(286209);
      ah localah = ah.yhC;
      ah.dzM();
      AppMethodBeat.o(286209);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    public static final r yhN;
    
    static
    {
      AppMethodBeat.i(291203);
      yhN = new r();
      AppMethodBeat.o(291203);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291201);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new StringBuilder("miniWindowClickListener onClick ");
      localObject = ah.yhC;
      Log.i("Finder.FinderLiveService", ah.dwh());
      paramView = ah.yhC;
      paramView = ah.getLiveCore();
      if (paramView != null) {
        paramView.aJz();
      }
      paramView = ah.yhC;
      boolean bool;
      if (ah.bvS())
      {
        paramView = ah.yhC;
        if ((ah.getLiveCore() instanceof com.tencent.mm.live.core.core.a.b))
        {
          paramView = ah.yhC;
          paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if ((paramView == null) || (paramView.zgy != true))
          {
            paramView = com.tencent.mm.plugin.findersdk.e.a.Bxf;
            paramView = com.tencent.mm.plugin.findersdk.e.a.enE();
            localObject = new Intent(MMApplicationContext.getContext(), paramView);
            ((Intent)localObject).putExtra("route_to_maximize", true);
            ((Intent)localObject).addFlags(872415232);
            paramView = MMApplicationContext.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramView = com.tencent.mm.live.core.mini.a.kqF;
            paramView = com.tencent.mm.live.core.mini.a.b.kqH;
            paramView = com.tencent.mm.live.core.mini.a.b.aMp();
            Log.d("MicroMsg.LiveFloatBallHelper", "clickFloatBall");
            paramView.rYE.rYs.opType = 3;
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).m(paramView.rYE);
            paramView = ah.yhC;
            paramView = ah.dzK();
            if (paramView == null) {
              break label375;
            }
            bool = paramView.fFE;
            label290:
            if (!bool) {
              break label380;
            }
            paramView = com.tencent.mm.plugin.finder.live.report.k.yBj;
            com.tencent.mm.plugin.finder.live.report.k.dDm().yDx = false;
            paramView = com.tencent.mm.plugin.finder.live.report.k.yBj;
            com.tencent.mm.plugin.finder.live.report.k.dDm().yDy = true;
            paramView = com.tencent.mm.plugin.finder.live.report.k.yBj;
            com.tencent.mm.plugin.finder.live.report.k.a(s.c.yEk, String.valueOf(s.v.yHm.type));
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291201);
        return;
        paramView = com.tencent.mm.plugin.findersdk.e.a.Bxf;
        paramView = com.tencent.mm.plugin.findersdk.e.a.enM();
        break;
        paramView = com.tencent.mm.plugin.findersdk.e.a.Bxf;
        paramView = com.tencent.mm.plugin.findersdk.e.a.enD();
        break;
        label375:
        bool = false;
        break label290;
        label380:
        com.tencent.mm.plugin.finder.live.report.m.yCt.a(false, s.v.yHm);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    public static final s yhO;
    
    static
    {
      AppMethodBeat.i(271780);
      yhO = new s();
      AppMethodBeat.o(271780);
    }
    
    public final void onClick(View paramView)
    {
      boolean bool1 = false;
      AppMethodBeat.i(271777);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      boolean bool2 = Util.isTopApplication(MMApplicationContext.getContext());
      localObject = new StringBuilder("mini window close,is top applicaton:").append(bool2).append(",is shopping in MiniPro:");
      paramView = ah.yhC;
      paramView = (j)ah.business(j.class);
      if (paramView != null) {}
      for (paramView = Boolean.valueOf(paramView.ziO);; paramView = null)
      {
        paramView = ((StringBuilder)localObject).append(paramView).append(",isAnchor:");
        localObject = ah.yhC;
        Log.i("Finder.FinderLiveService", ah.bvS());
        paramView = ah.yhC;
        if (ah.bvS()) {
          break;
        }
        paramView = ah.yhC;
        paramView = (j)ah.business(j.class);
        if ((paramView == null) || (paramView.ziO != true)) {
          break;
        }
        paramView = ah.yhC;
        paramView = ah.getLiveCore();
        if (paramView != null) {
          paramView.knr.aMq();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(271777);
        return;
      }
      paramView = aa.ycv;
      paramView = ah.yhC;
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      int i;
      if (paramView != null)
      {
        i = paramView.zgu;
        paramView = ah.yhC;
        paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (paramView == null) {
          break label324;
        }
      }
      label324:
      for (int j = paramView.zfu;; j = 0)
      {
        aa.b(3, i, j, false, 8);
        paramView = ah.yhC;
        ah.oN(bool2);
        paramView = ah.yhC;
        paramView = ah.dzK();
        if (paramView != null) {
          bool1 = paramView.fFE;
        }
        if (!bool1) {
          com.tencent.mm.plugin.finder.live.report.m.yCt.a(s.bh.yLH);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(271777);
        return;
        i = 0;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$multiTalkActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MultiTalkActionEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class t
    extends IListener<nl>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    u(com.tencent.mm.plugin.finder.live.view.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$pauseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "plugin-finder_release"})
  public static final class v
    implements ad.a
  {
    public final void a(int paramInt1, int paramInt2, bgo parambgo)
    {
      AppMethodBeat.i(245462);
      kotlin.g.b.p.k(parambgo, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        parambgo = ah.yhC;
        parambgo = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (parambgo != null)
        {
          bag localbag = new bag();
          localbag.CKC = 2;
          localbag.SMj = 0;
          parambgo.a(localbag, false, (kotlin.g.a.m)a.yhQ);
          AppMethodBeat.o(245462);
          return;
        }
      }
      AppMethodBeat.o(245462);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "lastPauseTime", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.m<Boolean, Integer, kotlin.x>
    {
      public static final a yhQ;
      
      static
      {
        AppMethodBeat.i(226824);
        yhQ = new a();
        AppMethodBeat.o(226824);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-finder_release"})
  public static final class w
    extends PhoneStateListener
  {
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(277516);
      kotlin.g.b.p.k(paramString, "incomingNumber");
      Object localObject = ah.yhC;
      localObject = ah.dzf();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.live.view.a)localObject).onCallStateChanged(paramInt, paramString);
        AppMethodBeat.o(277516);
        return;
      }
      AppMethodBeat.o(277516);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    public static final x yhR;
    
    static
    {
      AppMethodBeat.i(286234);
      yhR = new x();
      AppMethodBeat.o(286234);
    }
    
    public final void run()
    {
      AppMethodBeat.i(286233);
      ah localah = ah.yhC;
      ah.dzN();
      AppMethodBeat.o(286233);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
  static final class y
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final y yhS;
    
    static
    {
      AppMethodBeat.i(283465);
      yhS = new y();
      AppMethodBeat.o(283465);
    }
    
    y()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ah
 * JD-Core Version:    0.7.0.1
 */