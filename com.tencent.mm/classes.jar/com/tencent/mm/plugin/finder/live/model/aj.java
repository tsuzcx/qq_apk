package com.tencent.mm.plugin.finder.live.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.x;
import com.tencent.d.a.a.a.b.f;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.core.core.e.t;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.model.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.MiniProgramHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.finder.live.component.j.a;
import com.tencent.mm.plugin.finder.live.model.cgi.al.a;
import com.tencent.mm.plugin.finder.live.plugin.cg;
import com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView;
import com.tencent.mm.plugin.finder.live.view.mini.FinderMiniWindowFloatLayout;
import com.tencent.mm.plugin.finder.live.view.mini.b.d;
import com.tencent.mm.plugin.finder.live.widget.bm;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ba;
import com.tencent.mm.plugin.finder.utils.bb;
import com.tencent.mm.plugin.finder.utils.bb.a;
import com.tencent.mm.plugin.finder.utils.bb.c;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.finder.utils.bk;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.ci;
import com.tencent.mm.plugin.l;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.fxp;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "Lcom/tencent/liteav/audio/TXAudioEffectManager$TXMusicPlayObserver;", "()V", "COMMENT_LIST_SIZE_LIMIT", "", "getCOMMENT_LIST_SIZE_LIMIT", "()I", "setCOMMENT_LIST_SIZE_LIMIT", "(I)V", "INVALID_VISITOR_CORE_KEY", "", "TAG", "", "UNIQUE_ID", "getUNIQUE_ID", "()J", "activateMicLooper", "Lcom/tencent/mm/plugin/finder/live/model/SingleTaskLooper;", "activateMicTask", "Ljava/lang/Runnable;", "anchorVerifyManager", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorVerifyManager;", "getAnchorVerifyManager", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorVerifyManager;", "setAnchorVerifyManager", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorVerifyManager;)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "battleEndDelayTask", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$BattleDismissTask;", "battleStartDelayTask", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$BattleStartTask;", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "getBeautyConfig", "()Lcom/tencent/mm/live/core/render/BeautyConfig;", "setBeautyConfig", "(Lcom/tencent/mm/live/core/render/BeautyConfig;)V", "checkDeviceLsn", "com/tencent/mm/plugin/finder/live/model/FinderLiveService$checkDeviceLsn$1", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$checkDeviceLsn$1;", "comboBatchSize", "getComboBatchSize", "setComboBatchSize", "comboBatchTimeoutMs", "getComboBatchTimeoutMs", "setComboBatchTimeoutMs", "value", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "curLiveContext", "getCurLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setCurLiveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "curLiveIndex", "getCurLiveIndex", "setCurLiveIndex", "curLiveLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getCurLiveLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "setCurLiveLayout", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "defaultFilterValue", "getDefaultFilterValue", "setDefaultFilterValue", "enableGetLiveMsgTest", "", "getEnableGetLiveMsgTest", "()Z", "setEnableGetLiveMsgTest", "(Z)V", "externalHelper", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveExternalHelper;", "getExternalHelper", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveExternalHelper;", "setExternalHelper", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveExternalHelper;)V", "filterAnchorExtFlag", "getFilterAnchorExtFlag", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "getFilterConfig", "()Lcom/tencent/mm/live/core/render/FilterConfig;", "setFilterConfig", "(Lcom/tencent/mm/live/core/render/FilterConfig;)V", "filterMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/live/core/util/LiveFilterUtil$FilterInfo;", "Lkotlin/collections/HashMap;", "getFilterMap", "()Ljava/util/HashMap;", "setFilterMap", "(Ljava/util/HashMap;)V", "filterOutDatedJoinLiveResp", "getFilterOutDatedJoinLiveResp", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "setFinderLiveAssistant", "(Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;)V", "finderLiveMiniWindowManager", "Lcom/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager;", "getMessageTask", "giftLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getGiftLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setGiftLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "heartBeatLooper", "heartBeatTimestamp", "isAnchor", "setAnchor", "keepAliveTask", "keepLiveLooper", "lastQosReportTime", "liveChargeCountDownManager", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager;", "getLiveChargeCountDownManager", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager;", "setLiveChargeCountDownManager", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager;)V", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "setLiveCore", "(Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;)V", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "liveData", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;)V", "multiTalkActionListener", "Lcom/tencent/mm/sdk/event/IListener;", "multiTaskManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "getMultiTaskManager", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "setMultiTaskManager", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;)V", "notSupportDynamicVideoParamDevice", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "pollingService", "Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService;", "getPollingService", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService;", "preloadLiveSdkInfo", "getPreloadLiveSdkInfo", "refreshMicLooper", "refreshMicTask", "voipCallEvent", "Lcom/tencent/mm/autogen/events/VoipEvent;", "activateLiveMic", "", "liveId", "objectId", "objectNonceId", "liveCookie", "", "scene", "sessionId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "activateMic", "delay", "anchorCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "backToFinderLiveAnchorUIOnExternalLive", "context", "Landroid/content/Context;", "isFinish", "needRelaunchWeAppOnLiveFinished", "bindCurLayout", "finderBaseLayout", "bindCurLive", "liveMode", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "bindMiniGameLive", "bindNormalLive", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "callLiveExperimentalAPI", "jsStr", "errorCode", "param", "Landroid/os/Bundle;", "checkAcceptMicType", "micType", "checkAnchorVerifyStateWithForceUpdate", "closeLive", "closeMiniProgram", "purpose", "controlLiveMiniWindowVisibility", "visible", "doActivateMic", "doGetLiveMsg", "doKeepLive", "doRefreshMic", "dumpBattlePlayerInfo", "info", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PlayerInfo;", "enableAudioVolumeEvaluation", "interval", "enableCustomAudioCapture", "enable", "enableDynamicVideoParam", "enableLiveMiniWid", "isEnable", "enableMicExternalAudioFrame", "enablePublish", "enablePlayout", "enterRoom", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "errCode", "externalEnterRoom", "Lkotlin/Function5;", "success", "errType", "errMsg", "extInfo", "externalPostResult", "result", "forceStopCurLive", "fullScreen", "getFinderLiveExternalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveExternalInfo;", "getFinderLiveMemberListInfo", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMemberListInfo;", "getTopic", "handleKeepAliveResp", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "uniqueId", "handleLiveMsgResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "reqVisitorRoleType", "handleRefreshMicResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "heartBeat", "isAnchorLiving", "isFinished", "isGameAnchorLiving", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback$GameLivingStatus;", "appId", "isInvalidLiveId", "isVisitorLiving", "keepAlive", "launchMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "liveEngineReport", "liveFinish", "liveStart", "mirrorMode", "mixExternalAudioFrame", "audioBuffer", "sampleRate", "channel", "timestamp", "needMirror", "notifyMiniWindowStatusToExternal", "isShown", "notifyPlayStatus", "isComplete", "onComplete", "p0", "p1", "onPlayProgress", "p2", "onStart", "id", "pauseLive", "pauseVisitorLive", "playMusic", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "pos", "forcePlay", "playNext", "postExternalLive", "isFromWeApp", "processLiveAudioSdkParam", "audioSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkAudioParams;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveVideoSdkParam", "videoSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkVideoParams;", "refreshLinkMic", "sdkUserId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "refreshMic", "refreshMiniWindow", "registerExternalLiveCallback", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "release", "isTopApplication", "miniWinPermission", "finishActivityNotReleaseLive", "(ZZLjava/lang/Boolean;Z)V", "releaseWithMiniWindow", "removeBattleEndDelayTimer", "removeBattleStartDelayTimer", "removeKeepLive", "requestStopMic", "requestStopPkMic", "resumeLive", "resumeVisitorLive", "sendExternalAudioData", "sendExternalLiveData", "eglContext", "Landroid/opengl/EGLContext;", "texId", "width", "height", "setAnchorPauseMiniView", "setCustomResolution", "isVertical", "setTopic", "topic", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveSetTopicCallback;", "setVoiceCaptureVolume", "volume", "setupBeautyAndFilterConfig", "setupSdkParam", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "setupSingleTaskLooper", "share2Friend", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "share2Sns", "showMiniWindow", "showMiniWindowWithoutPermissionCheck", "startBattleEndDelayTimer", "battleId", "startBattleStartDelayTimer", "startChargeLiveCountDown", "startLinkMic", "startLocalAudio", "startPlayGameAnchorSetting", "jo", "Lorg/json/JSONObject;", "ck", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveActionCallBack;", "stopActivateMic", "stopRefreshMic", "transferLiveData", "livecData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "transferState", "roomData", "event", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "unregisterExternalLiveCallback", "updateBeautyConfig", "updateMiniWindow", "sourceType", "micData", "checkDiff", "updateSdkParam", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "updateVideoParamsByMic", "validCore", "visitorCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "BattleDismissTask", "BattleStartTask", "HeartBeatGuardTask", "KeepAliveGuardTask", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  implements TXAudioEffectManager.TXMusicPlayObserver, com.tencent.mm.live.core.core.c
{
  private static final IListener<acn> BtB;
  private static com.tencent.mm.plugin.finder.live.view.e BwQ;
  private static com.tencent.mm.plugin.finder.live.model.context.a CDN;
  public static com.tencent.mm.plugin.finder.live.view.a CDO;
  public static final aj CGT;
  private static final long CGU;
  private static com.tencent.mm.plugin.finder.live.view.mini.b CGV;
  private static n CGW;
  private static final af CGX;
  private static d CGY;
  private static String CGZ;
  private static int CHa;
  private static com.tencent.mm.plugin.finder.live.viewmodel.data.g CHb;
  private static int CHc;
  private static long CHd;
  private static long CHe;
  private static com.tencent.mm.bx.b CHf;
  private static int CHg;
  private static int CHh;
  private static boolean CHi;
  private static final boolean CHj;
  private static final boolean CHk;
  private static final boolean CHl;
  private static a CHm;
  private static b CHn;
  private static com.tencent.mm.plugin.finder.replay.a CHo;
  private static final FinderLiveService.checkDeviceLsn.1 CHp;
  private static final Runnable CHq;
  private static final Runnable CHr;
  private static ax CHs;
  private static ax CHt;
  private static ax CHu;
  private static ax CHv;
  private static final long CHw;
  private static ap CzZ;
  private static HashMap<Integer, com.tencent.mm.live.core.d.b.a> filterMap;
  public static boolean hKC;
  private static final PhoneStateListener mJl;
  private static com.tencent.mm.live.core.b.a mRD;
  private static com.tencent.mm.live.core.b.b mRE;
  private static final Runnable mZc;
  private static final Runnable mZd;
  public static com.tencent.mm.live.core.core.trtc.a nkg;
  private static final com.tencent.mm.model.d nmW;
  private static final IListener<?> nnP;
  
  static
  {
    boolean bool2 = true;
    AppMethodBeat.i(360317);
    CGT = new aj();
    CGU = SystemClock.elapsedRealtime();
    CGV = new com.tencent.mm.plugin.finder.live.view.mini.b();
    CGW = new n();
    CGX = new af();
    CGZ = "";
    nmW = new com.tencent.mm.model.d();
    CHa = 40;
    filterMap = new HashMap();
    CHc = 1000;
    CHg = -1;
    CHh = -1;
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jTa().bmg()).intValue() == 0)
    {
      bool1 = true;
      CHi = bool1;
      locala = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jTb().bmg()).intValue() != 0) {
        break label303;
      }
      bool1 = true;
      label145:
      CHj = bool1;
      locala = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jTO().bmg()).intValue() != 0) {
        break label308;
      }
      bool1 = true;
      label170:
      CHk = bool1;
      locala = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jUa().bmg()).intValue() != 0) {
        break label313;
      }
    }
    label303:
    label308:
    label313:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      CHl = bool1;
      BtB = (IListener)new FinderLiveService.voipCallEvent.1(com.tencent.mm.app.f.hfK);
      nnP = (IListener)new FinderLiveService.multiTalkActionListener.1(com.tencent.mm.app.f.hfK);
      CHp = new FinderLiveService.checkDeviceLsn.1(com.tencent.mm.app.f.hfK);
      mJl = (PhoneStateListener)new q();
      mZd = aj..ExternalSyntheticLambda4.INSTANCE;
      mZc = aj..ExternalSyntheticLambda3.INSTANCE;
      CHq = aj..ExternalSyntheticLambda1.INSTANCE;
      CHr = aj..ExternalSyntheticLambda2.INSTANCE;
      CHp.alive();
      CHw = 1L;
      AppMethodBeat.o(360317);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label145;
      bool1 = false;
      break label170;
    }
  }
  
  public static void M(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(360044);
    ??? = CGW.CFv;
    kotlin.g.b.s.s(???, "externalLiveCallbacks");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.d.a.a.a.a locala = (com.tencent.d.a.a.a.a)localIterator.next();
        Log.i(n.TAG, "onPostResult result:" + paramBoolean + " errType:" + paramInt);
        locala.X(paramBoolean, paramInt);
      }
    }
    ah localah = ah.aiuX;
    AppMethodBeat.o(360044);
  }
  
  public static void OR(int paramInt)
  {
    CHg = paramInt;
  }
  
  public static void OS(int paramInt)
  {
    CHh = paramInt;
  }
  
  public static com.tencent.mm.plugin.finder.live.model.context.a a(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
  {
    Object localObject3 = null;
    AppMethodBeat.i(359716);
    com.tencent.mm.plugin.finder.live.model.context.a locala;
    Object localObject2;
    Object localObject1;
    if (paramf == null)
    {
      locala = null;
      if (locala != null)
      {
        com.tencent.mm.plugin.finder.live.viewmodel.data.business.f localf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if ((localf != null) && (localf.liveInfo.liveId == 0L))
        {
          localf.liveInfo.liveId = paramf.Ebr.liveId;
          Object localObject4 = localf.liveInfo;
          localObject2 = paramf.Ebr.mIE;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((bip)localObject4).mIE = ((String)localObject1);
          localf.liveInfo.ZRQ = new bmi();
          localObject1 = localf.liveInfo.ZRQ;
          if (localObject1 != null) {
            ((bmi)localObject1).mNn = paramf.Ebr.mIF;
          }
          localObject1 = paramf.Ebr.mIW;
          if (localObject1 != null)
          {
            if (!CHl) {
              break label726;
            }
            label155:
            if (localObject1 != null)
            {
              localObject2 = new dix();
              ((dix)localObject2).parseFrom((byte[])localObject1);
              localObject1 = ah.aiuX;
              localf.a((dix)localObject2);
            }
          }
          localf.hKN = paramf.Ebr.mIH;
          localObject2 = paramf.Ebr.nonceId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localf.setNonceId((String)localObject1);
          localObject2 = paramf.Ebr.sessionBuffer;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localf.setSessionBuffer((String)localObject1);
          localObject1 = paramf.Ebr.mIU;
          kotlin.g.b.s.s(localObject1, "livecData.staticConfig.nicknameOption");
          localf.awv((String)localObject1);
          localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (localObject4 != null)
          {
            localObject1 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
            localObject1 = com.tencent.mm.plugin.finder.storage.data.e.a.jn(localf.hKN);
            if (localObject1 != null) {
              break label731;
            }
            localObject1 = null;
            label301:
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new FinderObject();
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).l((FinderObject)localObject2);
            localObject2 = paramf.Ebr.mIC;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).setAnchorUsername((String)localObject1);
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).desc = paramf.Ebr.desc;
            if (TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).eyo()))
            {
              localObject1 = paramf.Ebr.thumbUrl;
              kotlin.g.b.s.s(localObject1, "livecData.staticConfig.thumbUrl");
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).ayk((String)localObject1);
            }
            localObject1 = paramf.Ebr.mIS;
            kotlin.g.b.s.s(localObject1, "livecData.staticConfig.shareUserName");
            kotlin.g.b.s.u(localObject1, "<set-?>");
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).mIS = ((String)localObject1);
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).mIT = paramf.Ebr.mIT;
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).EeC = paramf.Ebr.mIQ;
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).BvE = paramf.BvE;
            localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
            localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.arQ(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).mIC);
            if (localObject2 != null) {
              break label739;
            }
            localObject1 = null;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = null;
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).EeF = ((String)localObject2);
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).EeF;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            Log.printInfoStack("Finder.FinderLiveService", kotlin.g.b.s.X("save outSize uxinfo:", localObject1), new Object[0]);
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).eyI();
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).Ecp = ((int)paramf.Ebr.mIV);
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).mIX = paramf.Ebr.mIX;
            localObject1 = bj.GlQ;
            localObject1 = bj.b(paramf.Ebr);
            if (localObject1 != null)
            {
              localObject2 = bk.GlT;
              bk.a((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4, "transferLiveData", (bgr)localObject1);
            }
          }
          if (paramf.Ebr.mIJ == 4) {
            com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.a((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class), paramf.Ebr.hUQ, paramf.Ebr.mIK);
          }
          localObject1 = new StringBuilder("transferLiveData liveId:").append(localf.liveInfo.liveId).append(" objectId:").append(localf.hKN).append(" nicknameOption:").append(localf.mIU).append(" anchorUsername:");
          paramf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (paramf != null) {
            break label821;
          }
        }
      }
    }
    label773:
    label778:
    label821:
    for (paramf = localObject3;; paramf = paramf.mIC)
    {
      Log.i("Finder.FinderLiveService", paramf);
      AppMethodBeat.o(359716);
      return locala;
      locala = paramf.BxG;
      break;
      label726:
      localObject1 = null;
      break label155;
      label731:
      localObject1 = ((FinderItem)localObject1).getFinderObject();
      break label301;
      label739:
      int i;
      if (((CharSequence)localObject2).length() > 0)
      {
        i = 1;
        label753:
        if (i == 0) {
          break label773;
        }
      }
      for (localObject1 = localObject2;; localObject1 = null)
      {
        if (localObject1 != null) {
          break label778;
        }
        localObject1 = null;
        break;
        i = 0;
        break label753;
      }
      localObject1 = new JSONObject((String)localObject2).optJSONObject("sns_ad");
      if (localObject1 == null) {}
      for (localObject2 = null;; localObject2 = ((JSONObject)localObject1).optString("uxinfo"))
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = null;
        break;
      }
    }
  }
  
  private static final ah a(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f paramf, com.tencent.mm.am.b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(360251);
    kotlin.g.b.s.u(paramf, "$it");
    int i = parama.errType;
    int j = parama.errCode;
    bca localbca = (bca)parama.ott;
    kotlin.g.b.s.s(localbca, "resp");
    parama = parama.otu;
    label66:
    long l;
    if ((parama instanceof com.tencent.mm.plugin.finder.live.model.cgi.m))
    {
      parama = (com.tencent.mm.plugin.finder.live.model.cgi.m)parama;
      if (parama != null) {
        break label165;
      }
      parama = null;
      boolean bool = a(j, i, localbca, parama);
      parama = CHt;
      if (parama != null) {
        parama.emA();
      }
      parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (parama != null) {
        break label173;
      }
      l = 0L;
      label105:
      l = kotlin.k.k.bR((l - 60L) * 1000L, 60000L);
      if (!bool) {
        break label197;
      }
      of(l);
    }
    for (;;)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new j(l));
      paramf = ah.aiuX;
      AppMethodBeat.o(360251);
      return paramf;
      parama = null;
      break;
      label165:
      parama = parama.hTs;
      break label66;
      label173:
      parama = parama.mZr;
      if (parama == null)
      {
        l = 0L;
        break label105;
      }
      l = parama.aaOy;
      break label105;
      label197:
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA()) {
        break label221;
      }
      of(l);
    }
    label221:
    paramf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if (paramf == null) {
      paramf = localObject;
    }
    for (;;)
    {
      Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("handleKeepAliveResp result false and live is finished. localLiveId:", paramf));
      break;
      parama = paramf.liveInfo;
      paramf = localObject;
      if (parama != null) {
        paramf = Long.valueOf(parama.liveId);
      }
    }
  }
  
  public static void a(EGLContext paramEGLContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(360016);
    kotlin.g.b.s.u(paramEGLContext, "eglContext");
    com.tencent.mm.live.core.core.trtc.a locala = nkg;
    if (locala != null)
    {
      kotlin.g.b.s.u(paramEGLContext, "eglContext");
      locala.mRo.eglContext14 = paramEGLContext;
      locala.mRo.textureId = paramInt1;
      locala.mRn.texture = locala.mRo;
      locala.mRn.width = paramInt2;
      locala.mRn.height = paramInt3;
      locala.mRn.pixelFormat = 2;
      locala.mRn.bufferType = 3;
      locala.beO().sendCustomVideoData(locala.mRn);
    }
    AppMethodBeat.o(360016);
  }
  
  private static void a(Bundle paramBundle, Context paramContext)
  {
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(360064);
    boolean bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_FORCE_TASK", false);
    int k = paramBundle.getInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0);
    Object localObject2 = new StringBuilder("showMiniWindowWithoutPermissionCheck: forceMoveTask:").append(bool).append(", generateType:").append(k).append(", isFloatMode:");
    paramBundle = nkg;
    label158:
    if (paramBundle == null)
    {
      paramBundle = null;
      Log.i("Finder.FinderLiveService", paramBundle);
      paramBundle = nkg;
      if (paramBundle == null) {
        break label272;
      }
      paramBundle = paramBundle.mRB;
      if ((paramBundle == null) || (paramBundle.isFloatMode())) {
        break label272;
      }
      i = 1;
      label116:
      if (i != 0)
      {
        paramBundle = ar.CIh;
        ar.emi();
        paramBundle = nkg;
        if (paramBundle != null)
        {
          localObject2 = (com.tencent.mm.live.core.core.b)paramBundle;
          paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (paramBundle != null) {
            break label277;
          }
          paramBundle = localObject1;
          com.tencent.mm.live.core.core.b.a.a((com.tencent.mm.live.core.core.b)localObject2, paramContext, bool, true, k, 0, paramBundle, false, 80);
        }
        ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(false);
        paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (paramBundle != null) {
          break label285;
        }
      }
    }
    label272:
    label277:
    label285:
    for (int i = j;; i = paramBundle.EcS)
    {
      if (com.tencent.mm.ae.d.ee(i, 524288)) {
        elJ();
      }
      paramBundle = com.tencent.mm.plugin.finder.live.report.j.Dob;
      paramBundle = com.tencent.mm.plugin.finder.live.report.j.Doc.Dqq;
      paramBundle.DFY += 1L;
      AppMethodBeat.o(360064);
      return;
      paramBundle = paramBundle.mRB;
      if (paramBundle == null)
      {
        paramBundle = null;
        break;
      }
      paramBundle = Boolean.valueOf(paramBundle.isFloatMode());
      break;
      i = 0;
      break label116;
      paramBundle = paramBundle.DVR;
      break label158;
    }
  }
  
  public static void a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.core.model.h paramh, kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(359956);
    kotlin.g.b.s.u(paramh, "liveRoomModel");
    kotlin.g.b.s.u(paramb, "action");
    if ((nkg instanceof com.tencent.mm.live.core.core.f.d))
    {
      paramLivePreviewView = nkg;
      if (paramLivePreviewView != null) {
        paramLivePreviewView.a(paramh);
      }
      paramLivePreviewView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.live.core.core.b)nkg);
      paramLivePreviewView = nkg;
      if (!(paramLivePreviewView instanceof com.tencent.mm.live.core.core.f.d)) {
        break label99;
      }
    }
    label99:
    for (paramLivePreviewView = (com.tencent.mm.live.core.core.f.d)paramLivePreviewView;; paramLivePreviewView = null)
    {
      if (paramLivePreviewView != null) {
        paramLivePreviewView.a(null, (com.tencent.mm.live.core.core.c)new aj.l(paramb));
      }
      AppMethodBeat.o(359956);
      return;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, int paramInt)
  {
    AppMethodBeat.i(359826);
    kotlin.g.b.s.u(parama, "liveData");
    Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("checkAcceptMicType micType:", Integer.valueOf(paramInt)));
    parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      parama.Efy = paramInt;
      AppMethodBeat.o(359826);
      return;
      paramInt = 3;
      continue;
      paramInt = 4;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, boolean paramBoolean, b.c paramc, Bundle paramBundle, long paramLong)
  {
    bip localbip = null;
    Object localObject2 = null;
    AppMethodBeat.i(359611);
    kotlin.g.b.s.u(parama, "roomData");
    kotlin.g.b.s.u(paramc, "event");
    StringBuilder localStringBuilder = new StringBuilder("transferState before event:").append(paramc).append(" curLive:");
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Long.valueOf(((bip)localObject1).liveId))
    {
      Log.i("Finder.FinderLiveService", localObject1 + " liveState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcT + " uiState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS + ",isAnchor:" + paramBoolean);
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (paramLong == ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId) {
        break;
      }
      Log.w("Finder.FinderLiveService", "invalid liveId:" + paramLong + ", ignore...");
      AppMethodBeat.o(359611);
      return;
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcU = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).lastLiveState = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT;
    switch (e.$EnumSwitchMapping$0[paramc.ordinal()])
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
      label825:
      do
      {
        for (;;)
        {
          Log.i("Finder.FinderLiveService", "transferState after  event:" + paramc + " liveState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT + " uiState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS);
          AppMethodBeat.o(359611);
          return;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 1;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS = 1024;
          continue;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 1;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFFFBFF;
          continue;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 0;
          if ((paramBundle == null) || (!paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", false)))
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS = 0;
            continue;
            if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) && (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 96)))
            {
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x10;
              continue;
              if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) && (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 16)))
              {
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFFFFEF;
                continue;
                if (((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).eyz()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted())) && (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 96)))
                {
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x2;
                  continue;
                  if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) && (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 2)))
                  {
                    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFFFFFD;
                    continue;
                    if ((!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 32)) && (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 524288)))
                    {
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 2;
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS = 1;
                    }
                    parama = com.tencent.d.a.a.a.a.a.ahiX;
                    CHc = ((Number)com.tencent.d.a.a.a.a.a.jSF().bmg()).intValue();
                    continue;
                    if ((!paramBoolean) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).eyA()))
                    {
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 2;
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS = 1;
                      continue;
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 3;
                      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS = 0;
                    }
                  }
                }
              }
            }
          }
        }
        if (!paramBoolean)
        {
          parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
          if (parama != null) {
            break label914;
          }
          parama = null;
          paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          if (paramBundle != null) {
            break label925;
          }
          paramBundle = localObject2;
        }
        while (kotlin.g.b.s.p(parama, paramBundle))
        {
          parama = nkg;
          if (parama != null) {
            parama.sY(1);
          }
          if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) || (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 96))) {
            break;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x20;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFFFDFF;
          break;
          parama = Long.valueOf(parama.liveId);
          break label825;
          localbip = paramBundle.liveInfo;
          paramBundle = localObject2;
          if (localbip != null) {
            paramBundle = Long.valueOf(localbip.liveId);
          }
        }
      } while (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).eyA());
      label914:
      label925:
      if (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 524288)) {
        break;
      }
    }
    for (int i = 524289;; i = 1)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS = i;
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) || (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 608))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x200;
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) || (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 96))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x40;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFFFDFF;
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) || (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 64))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFFFFBF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 2;
      break;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) {
        break;
      }
      if (paramBundle == null) {}
      for (parama = localbip;; parama = Boolean.valueOf(paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT", false)))
      {
        if (!kotlin.g.b.s.p(parama, Boolean.TRUE)) {
          break label1177;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x8;
        break;
      }
      label1177:
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFFFFF7;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 2;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x80;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 2;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x100;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 2;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x100000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 2;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x1000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x800;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFFF7FF;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x4000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFFBFFF;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x8000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFF7FFF;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x10000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFEFFFF;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x40000;
      break;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFFBFFFF;
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) || (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 524288))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS |= 0x80000;
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) || (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 524288))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFF7FFFF;
      parama = nkg;
      if (parama == null) {
        break;
      }
      parama.sZ(2);
      break;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted()) || (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS, 524288))) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS &= 0xFFF7FFFF;
      break;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).eyB()) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcT = 1;
      break;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.view.a parama)
  {
    CDO = parama;
    d locald = CGY;
    if (locald != null) {
      locald.CDO = parama;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.view.e parame)
  {
    BwQ = parame;
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.data.g paramg)
  {
    AppMethodBeat.i(359395);
    Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("FinderLiveDataModel set ", paramg));
    CHb = paramg;
    AppMethodBeat.o(359395);
  }
  
  private static void a(diy paramdiy, TRTCCloudDef.TRTCParams paramTRTCParams, com.tencent.mm.live.core.core.model.g paramg)
  {
    AppMethodBeat.i(359572);
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).b(paramdiy.aaOA);
    }
    a(paramdiy.aaOA);
    localObject1 = paramdiy.aaOB;
    if (localObject1 != null)
    {
      if (((div)localObject1).aaND > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSP = ((div)localObject1).aaND;
      }
      Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("processLiveAudioSdkParam audioQuality:", Integer.valueOf(((div)localObject1).aaND)));
    }
    Object localObject2 = paramdiy.aaOC;
    if ((localObject2 != null) && (paramTRTCParams != null) && (paramg != null))
    {
      Log.i("Finder.FinderLiveService", "userDefineRecordId:" + ((diw)localObject2).aaNE + ',' + ((diw)localObject2).aaNF);
      paramdiy = ((diw)localObject2).aaNF;
      localObject1 = ((diw)localObject2).aaNE;
      int j = ((diw)localObject2).aaNO;
      String str1 = ((diw)localObject2).aaOl;
      int i = j;
      if (!com.tencent.mm.modelcontrol.e.wb(5))
      {
        i = j;
        if (j == com.tencent.mm.live.core.core.a.mJu.value) {
          i = ((diw)localObject2).aaNP;
        }
      }
      paramg.mJU = ((diw)localObject2).aaNP;
      Object localObject3;
      if (i < 100)
      {
        paramg.a(com.tencent.mm.live.core.core.model.a.mMz);
        paramg.mNr = i;
        localObject3 = (Collection)((diw)localObject2).aaNK;
        if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
          break label418;
        }
      }
      label418:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label423;
        }
        localObject2 = ((diw)localObject2).aaNK;
        kotlin.g.b.s.s(localObject2, "channelParams.cdn_trans_info");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (xb)((Iterator)localObject2).next();
          Map localMap = (Map)paramg.mNt;
          i = ((xb)localObject3).ZeQ;
          String str2 = ((xb)localObject3).url;
          kotlin.g.b.s.s(str2, "it.url");
          localMap.put(Integer.valueOf(i), new com.tencent.mm.live.core.core.model.j(str2, ((xb)localObject3).ZeS, ((xb)localObject3).ZeT));
        }
        if (i == com.tencent.mm.live.core.core.a.mJv.value)
        {
          paramg.a(com.tencent.mm.live.core.core.model.a.mMA);
          break;
        }
        if (i != com.tencent.mm.live.core.core.a.mJw.value) {
          break;
        }
        paramg.a(com.tencent.mm.live.core.core.model.a.mMB);
        break;
      }
      label423:
      if ((!Util.isNullOrNil(paramdiy)) || (!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil(str1)))
      {
        localObject2 = new com.tencent.mm.ad.i();
        if (!Util.isNullOrNil(paramdiy)) {
          ((com.tencent.mm.ad.i)localObject2).m("userdefine_streamid_main", paramdiy);
        }
        if (!Util.isNullOrNil((String)localObject1)) {
          ((com.tencent.mm.ad.i)localObject2).m("userdefine_record_id", localObject1);
        }
        if (!Util.isNullOrNil(str1)) {
          ((com.tencent.mm.ad.i)localObject2).m("userdefine_push_args", str1);
        }
        paramdiy = new com.tencent.mm.ad.i();
        paramdiy.m("Str_uc_params", localObject2);
        paramTRTCParams.businessInfo = paramdiy.toString();
      }
      Log.i("Finder.FinderLiveService", "processLiveSdkParams cdnQualitySvrcfg" + paramg.mNr + " cdnSwitchMode:" + paramg.mNq + " cdn_quality_h265backcfg:" + paramg.mJU);
    }
    AppMethodBeat.o(359572);
  }
  
  public static void a(diz paramdiz)
  {
    AppMethodBeat.i(359554);
    int i3;
    int m;
    int k;
    int j;
    List localList;
    Object localObject1;
    Object localObject2;
    label78:
    Object localObject3;
    Object localObject4;
    label97:
    int i1;
    label116:
    Object localObject5;
    label135:
    label149:
    int n;
    int i4;
    int i;
    if (paramdiz != null)
    {
      i3 = paramdiz.aaOD;
      m = paramdiz.aaOF;
      k = paramdiz.aaOG;
      j = paramdiz.aaON;
      localList = com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().mTz;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null)
      {
        localObject2 = null;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (localObject1 != null) {
          break label268;
        }
        localObject1 = null;
        localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        if (localObject3 != null) {
          break label314;
        }
        localObject4 = null;
        localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        if (localObject3 != null) {
          break label327;
        }
        i1 = 0;
        localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (localObject3 != null) {
          break label357;
        }
        localObject3 = null;
        if (localObject3 != null) {
          break label367;
        }
        localObject5 = new HashMap();
        n = 0;
        i4 = 0;
        i = 0;
        if (!hKC) {
          break label1148;
        }
        if (!kotlin.g.b.s.p(localObject4, Boolean.TRUE)) {
          break label964;
        }
        kotlin.g.b.s.s(localList, "micUserList");
        localObject3 = ((Iterable)localList).iterator();
        i = 0;
        label196:
        if (!((Iterator)localObject3).hasNext()) {
          break label374;
        }
        if (!Util.isEqual((String)localObject2, ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)((Iterator)localObject3).next()).lyn)) {
          break label2016;
        }
        i += 1;
      }
    }
    label268:
    label314:
    label327:
    label463:
    label604:
    label1757:
    label2016:
    for (;;)
    {
      break label196;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).mZr;
      if (localObject1 == null)
      {
        localObject2 = null;
        break;
      }
      localObject2 = Integer.valueOf(((dix)localObject1).aaOr).toString();
      break;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).mZu;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label78;
      }
      localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).mNz;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label78;
      }
      localObject1 = ((TRTCCloudDef.TRTCParams)localObject1).userId;
      break label78;
      localObject4 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject3).EfM);
      break label97;
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject3).Efw;
      if (localObject3 == null)
      {
        i1 = 0;
        break label116;
      }
      i1 = ((List)localObject3).size();
      break label116;
      label357:
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject3).Efa;
      break label135;
      label367:
      localObject5 = localObject3;
      break label149;
      label374:
      int i2;
      if (i > 0)
      {
        localObject2 = e.t.mMh;
        localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bea()));
        if (localObject2 == null)
        {
          j = 0;
          localObject2 = e.t.mMh;
          localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bea()));
          if (localObject2 != null) {
            break label935;
          }
          k = 0;
          localObject2 = e.t.mMh;
          localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bea()));
          if (localObject2 != null) {
            break label944;
          }
          m = 0;
          localObject2 = e.t.mMh;
          localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bea()));
          if (localObject2 != null) {
            break label954;
          }
          i2 = 0;
          label492:
          i3 = m;
          n = j;
          m = k;
          k = i3;
          j = i;
          i = i2;
        }
      }
      for (;;)
      {
        Log.i("Finder.FinderLiveService", "processLiveVideoSdkParam for anchor. isRoomPk:" + localObject4 + " micUserList.size:" + localList.size() + " curAudienceMicCount:" + i1 + " selfAudienceMicCount:" + j + " selfUserId:" + localObject1);
        i1 = k;
        k = m;
        j = n;
        m = i1;
        label627:
        label637:
        boolean bool;
        if (j <= 0)
        {
          j = paramdiz.aaOD;
          n = k;
          if (k <= 0) {
            n = paramdiz.aaOF;
          }
          if (m <= 0)
          {
            k = paramdiz.aaOG;
            if (i <= 0)
            {
              m = paramdiz.aaON;
              if (j > 0) {
                com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mSZ = j;
              }
              if (n > 0) {
                com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTa = n;
              }
              if (k > 0) {
                com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mVideoBitrate = k;
              }
              if (m > 0) {
                com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mMinVideoBitrate = m;
              }
              if (paramdiz.aaOP > 0) {
                com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTb = paramdiz.aaOP;
              }
              if (paramdiz.aaOQ > 0) {
                com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTc = paramdiz.aaOQ;
              }
              if (paramdiz.aaOR > 0) {
                com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTd = paramdiz.aaOR;
              }
              if (paramdiz.aaOS > 0) {
                com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTe = paramdiz.aaOS;
              }
              if (paramdiz.aaOI > 0) {
                com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mQosPreference = paramdiz.aaOI;
              }
              i = paramdiz.aaOJ;
              if (i >= 0) {
                if (i <= 1)
                {
                  i = 1;
                  if (i != 0) {
                    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mQosMode = paramdiz.aaOJ;
                  }
                  Log.i("Finder.FinderLiveService", "processLiveVideoSdkParam encResEnum:" + j + ", capFps:" + n + ", encBR:" + k + ", encBRMin:" + m + ", qosPreferneceEnum:" + paramdiz.aaOI + ", qosControlModeEnum:" + paramdiz.aaOJ);
                  paramdiz = ah.aiuX;
                  paramdiz = ah.aiuX;
                  AppMethodBeat.o(359554);
                  return;
                  j = ((fxp)localObject2).aaOD;
                  break;
                  k = ((fxp)localObject2).aaOF;
                  break label434;
                  m = ((fxp)localObject2).aaOG;
                  break label463;
                  i2 = ((fxp)localObject2).aaON;
                  break label492;
                  if (i1 < 3) {
                    break label1986;
                  }
                  localObject2 = e.t.mMh;
                  localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bea()));
                  if (localObject2 == null)
                  {
                    i = 0;
                    label998:
                    localObject2 = e.t.mMh;
                    localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bea()));
                    if (localObject2 != null) {
                      break label1120;
                    }
                    j = 0;
                    localObject2 = e.t.mMh;
                    localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bea()));
                    if (localObject2 != null) {
                      break label1129;
                    }
                    m = 0;
                    localObject2 = e.t.mMh;
                    localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bea()));
                    if (localObject2 != null) {
                      break label1139;
                    }
                  }
                  label1120:
                  label1129:
                  label1139:
                  for (k = 0;; k = ((fxp)localObject2).aaON)
                  {
                    i3 = 0;
                    n = j;
                    i2 = i;
                    i = k;
                    j = i3;
                    k = m;
                    m = n;
                    n = i2;
                    break;
                    i = ((fxp)localObject2).aaOD;
                    break label998;
                    j = ((fxp)localObject2).aaOF;
                    break label1026;
                    m = ((fxp)localObject2).aaOG;
                    break label1055;
                  }
                  label1148:
                  localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
                  if (localObject3 == null)
                  {
                    localObject3 = null;
                    if (localObject3 == null) {
                      break label1365;
                    }
                  }
                  for (bool = true;; bool = false) {
                    for (;;)
                    {
                      i2 = i4;
                      if (!bool) {
                        break label1964;
                      }
                      if (!kotlin.g.b.s.p(localObject4, Boolean.TRUE)) {
                        break label1776;
                      }
                      kotlin.g.b.s.s(localList, "micUserList");
                      localObject3 = ((Iterable)localList).iterator();
                      n = i;
                      while (((Iterator)localObject3).hasNext()) {
                        if (Util.isEqual((String)localObject2, ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)((Iterator)localObject3).next()).lyn)) {
                          n += 1;
                        }
                      }
                      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject3).Efw;
                      if (localObject3 == null)
                      {
                        localObject3 = null;
                        break;
                      }
                      synchronized ((Iterable)localObject3)
                      {
                        Iterator localIterator = ???.iterator();
                        for (;;)
                        {
                          if (localIterator.hasNext())
                          {
                            localObject3 = localIterator.next();
                            bool = Util.isEqual((String)localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).mXL);
                            if (bool)
                            {
                              localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3;
                              break;
                            }
                          }
                        }
                        localObject3 = null;
                      }
                    }
                  }
                  if (n >= 2)
                  {
                    localObject2 = e.t.mMh;
                    localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bec()));
                    if (localObject2 == null)
                    {
                      j = 0;
                      label1405:
                      localObject2 = e.t.mMh;
                      localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bec()));
                      if (localObject2 != null) {
                        break label1586;
                      }
                      k = 0;
                      localObject2 = e.t.mMh;
                      localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bec()));
                      if (localObject2 != null) {
                        break label1595;
                      }
                      m = 0;
                      localObject2 = e.t.mMh;
                      localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.bec()));
                      if (localObject2 != null) {
                        break label1605;
                      }
                      i = 0;
                    }
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          Log.i("Finder.FinderLiveService", "processLiveVideoSdkParam for visitor. selfInMicing:" + bool + " isRoomPk:" + localObject4 + " micUserList.size:" + localList.size() + " curAudienceMicCount:" + i1 + " selfAudienceMicCount:" + n + " selfUserId:" + localObject1);
          break;
          j = ((fxp)localObject2).aaOD;
          break label1405;
          k = ((fxp)localObject2).aaOF;
          break label1433;
          m = ((fxp)localObject2).aaOG;
          break label1462;
          i = ((fxp)localObject2).aaON;
          continue;
          i2 = n;
          if (n > 0)
          {
            localObject2 = e.t.mMh;
            localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.beb()));
            if (localObject2 == null)
            {
              j = 0;
              label1651:
              localObject2 = e.t.mMh;
              localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.beb()));
              if (localObject2 != null) {
                break label1748;
              }
              k = 0;
              localObject2 = e.t.mMh;
              localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.beb()));
              if (localObject2 != null) {
                break label1757;
              }
            }
            for (m = 0;; m = ((fxp)localObject2).aaOG)
            {
              localObject2 = e.t.mMh;
              localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.beb()));
              if (localObject2 != null) {
                break label1767;
              }
              i = 0;
              break;
              j = ((fxp)localObject2).aaOD;
              break label1651;
              k = ((fxp)localObject2).aaOF;
              break label1679;
            }
            label1767:
            i = ((fxp)localObject2).aaON;
            continue;
            label1776:
            i2 = i4;
            if (i1 >= 2)
            {
              localObject2 = e.t.mMh;
              localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.beb()));
              if (localObject2 == null)
              {
                j = 0;
                localObject2 = e.t.mMh;
                localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.beb()));
                if (localObject2 != null) {
                  break label1911;
                }
                k = 0;
                localObject2 = e.t.mMh;
                localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.beb()));
                if (localObject2 != null) {
                  break label1920;
                }
              }
              for (m = 0;; m = ((fxp)localObject2).aaOG)
              {
                localObject2 = e.t.mMh;
                localObject2 = (fxp)((HashMap)localObject5).get(Integer.valueOf(e.t.beb()));
                if (localObject2 != null) {
                  break label1930;
                }
                i = 0;
                break;
                j = ((fxp)localObject2).aaOD;
                break label1814;
                label1911:
                k = ((fxp)localObject2).aaOF;
                break label1842;
              }
              i = ((fxp)localObject2).aaON;
              continue;
              i = 0;
              break label813;
              i = 0;
              break label813;
              m = i;
              break label637;
              k = m;
              break label627;
              break label604;
            }
          }
          i = j;
          n = k;
          k = m;
          j = i3;
          m = n;
          n = i2;
        }
        n = 0;
        i = j;
        j = n;
        n = i3;
        continue;
        n = i;
        i = j;
        j = n;
        n = i3;
      }
    }
  }
  
  public static void a(kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super Bundle, ah> params)
  {
    AppMethodBeat.i(360036);
    kotlin.g.b.s.u(params, "callback");
    n localn = CGW;
    com.tencent.mm.live.core.core.trtc.a locala = nkg;
    com.tencent.mm.plugin.finder.live.model.context.a locala1 = CDN;
    ap localap = CzZ;
    kotlin.g.b.s.u(params, "callback");
    if (locala1 == null)
    {
      localObject = null;
      if ((locala == null) || (localObject == null) || (locala1 == null)) {
        break label183;
      }
      locala.a((com.tencent.mm.live.core.core.model.h)localObject);
      localObject = ba.Gjt;
      bb.a locala2 = bb.GjM;
      ba.a((ba)localObject, bb.fhy().name, null, false, false, 14);
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.live.core.core.b)locala);
      locala.a((com.tencent.mm.live.core.core.c)new n.b(locala1, localap, params, localn));
    }
    label183:
    for (Object localObject = ah.aiuX;; localObject = null)
    {
      if (localObject == null) {
        params.a(Boolean.FALSE, Integer.valueOf(-1), Integer.valueOf(-1), null, null);
      }
      AppMethodBeat.o(360036);
      return;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)locala1.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).mZu;
      break;
    }
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(360024);
    kotlin.g.b.s.u(paramArrayOfByte, "audioBuffer");
    Object localObject = nkg;
    if (localObject != null)
    {
      kotlin.g.b.s.u(paramArrayOfByte, "audioBuffer");
      TRTCCloud localTRTCCloud = ((com.tencent.mm.live.core.core.trtc.a)localObject).beO();
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRp;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).data = paramArrayOfByte;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).sampleRate = paramInt1;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).channel = paramInt2;
      ((TRTCCloudDef.TRTCAudioFrame)localObject).timestamp = paramLong;
      paramArrayOfByte = ah.aiuX;
      localTRTCCloud.sendCustomAudioData((TRTCCloudDef.TRTCAudioFrame)localObject);
    }
    AppMethodBeat.o(360024);
  }
  
  private static boolean a(int paramInt1, int paramInt2, bca parambca, String paramString)
  {
    long l = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(359520);
    Object localObject1;
    boolean bool1;
    if (paramInt1 == -100038)
    {
      paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (paramString != null)
      {
        localObject1 = nkg;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject1).ta(4);
        }
        localObject1 = p.mZf;
        localObject1 = p.bhS();
        if (localObject1 != null) {
          ((com.tencent.mm.live.model.g)localObject1).onCloseLive(new com.tencent.mm.live.model.e(paramString.liveInfo.liveId));
        }
      }
      Log.i("Finder.FinderLiveService", "handleKeepAliveResp live has finished");
      bool1 = false;
    }
    label156:
    label284:
    label670:
    for (;;)
    {
      localObject1 = new StringBuilder("handleKeepAliveResp result:").append(bool1).append(" errCode:").append(paramInt1).append(", errType:").append(paramInt2).append(", curData:");
      paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (paramString == null)
      {
        paramString = null;
        paramString = ((StringBuilder)localObject1).append(paramString).append(", resp.liveId:");
        parambca = parambca.liveInfo;
        if (parambca != null) {
          break label838;
        }
      }
      label313:
      label576:
      label838:
      for (parambca = localObject2;; parambca = Long.valueOf(parambca.liveId))
      {
        Log.i("Finder.FinderLiveService", parambca);
        AppMethodBeat.o(359520);
        return bool1;
        if ((paramInt2 != 0) || (paramInt1 != 0))
        {
          Log.i("Finder.FinderLiveService", "handleKeepAliveResp launch live room failed");
          bool1 = false;
          break;
        }
        if (parambca == null)
        {
          Log.i("Finder.FinderLiveService", "handleKeepAliveResp invalid live resp");
          bool1 = false;
          break;
        }
        Object localObject3;
        if (awz(paramString))
        {
          localObject1 = new StringBuilder("handleKeepAliveResp invalid live id, curData:");
          localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          if (localObject3 == null)
          {
            l = 0L;
            localObject3 = ((StringBuilder)localObject1).append(l).append(", resp.liveId:");
            localObject1 = parambca.liveInfo;
            if (localObject1 != null) {
              break label407;
            }
            localObject1 = null;
            localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", curUniqueId:");
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
            if (localObject1 != null) {
              break label420;
            }
          }
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).hTs)
          {
            Log.i("Finder.FinderLiveService", localObject1 + ", cgi.uniqueId:" + paramString);
            bool1 = false;
            break;
            localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject3).liveInfo;
            if (localObject3 == null)
            {
              l = 0L;
              break label284;
            }
            l = ((bip)localObject3).liveId;
            break label284;
            localObject1 = Long.valueOf(((bip)localObject1).liveId);
            break label313;
          }
        }
        localObject1 = parambca.mZr;
        if (localObject1 == null) {
          break label849;
        }
        paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (paramString != null) {
          paramString.a((dix)localObject1);
        }
        paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (paramString == null)
        {
          paramString = null;
          label477:
          if (paramString != null)
          {
            localObject3 = parambca.liveInfo;
            if (localObject3 != null) {
              break label670;
            }
            label492:
            paramString.liveId = l;
          }
          Log.i("Finder.FinderLiveService", "doKeepAlive updatePrivateMapKey");
          paramString = com.tencent.mm.live.core.core.a.b.mMo;
          if (!com.tencent.mm.live.core.core.a.b.a.bek()) {
            break label680;
          }
          paramString = com.tencent.mm.live.core.core.a.b.mMo;
          paramString = com.tencent.mm.live.core.core.a.b.a.bej();
          localObject3 = ((dix)localObject1).aaOu.ZV();
          kotlin.g.b.s.s(localObject3, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramString.FO((String)localObject3);
          localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          if (localObject3 != null)
          {
            paramString = parambca.Ayh;
            if (paramString != null) {
              break label766;
            }
            paramString = null;
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject3).mZp = paramString;
          }
          paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          if (paramString != null) {
            break label774;
          }
          paramString = null;
        }
        boolean bool2;
        for (;;)
        {
          if (paramString != null) {
            paramString.privateMapKey = ((dix)localObject1).aaOu.ZV();
          }
          b((dix)localObject1);
          bool2 = true;
          bool1 = bool2;
          if (!(nkg instanceof com.tencent.mm.live.core.core.a.b)) {
            break;
          }
          paramString = nkg;
          if (paramString != null) {
            break label796;
          }
          parambca = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
          AppMethodBeat.o(359520);
          throw parambca;
          paramString = paramString.liveInfo;
          break label477;
          l = ((bip)localObject3).liveId;
          break label492;
          paramString = com.tencent.mm.live.core.core.e.a.mRf;
          if (com.tencent.mm.live.core.core.e.a.a.bek())
          {
            paramString = com.tencent.mm.live.core.core.e.a.mRf;
            paramString = com.tencent.mm.live.core.core.e.a.a.beN();
            localObject3 = ((dix)localObject1).aaOu.ZV();
            kotlin.g.b.s.s(localObject3, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramString.FO((String)localObject3);
            break label549;
          }
          if (elL() == null) {
            break label549;
          }
          paramString = elL();
          if (paramString == null) {
            break label549;
          }
          localObject3 = ((dix)localObject1).aaOu.ZV();
          kotlin.g.b.s.s(localObject3, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
          paramString.FO((String)localObject3);
          break label549;
          label766:
          paramString = paramString.Op;
          break label576;
          paramString = paramString.mZu;
          if (paramString == null) {
            paramString = null;
          } else {
            paramString = paramString.mNz;
          }
        }
        ((com.tencent.mm.live.core.core.a.b)paramString).fE(needMirror());
        bool1 = bool2;
        break;
        paramString = paramString.liveInfo;
        if (paramString == null)
        {
          paramString = null;
          break label156;
        }
        paramString = Long.valueOf(paramString.liveId);
        break label156;
      }
      label420:
      label549:
      label680:
      label849:
      bool1 = false;
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, blw paramblw)
  {
    Object localObject2 = null;
    AppMethodBeat.i(359505);
    Object localObject3 = new StringBuilder("handleRefreshMicResp errCode:").append(paramInt1).append(", errType:").append(paramInt2).append(", curData:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    boolean bool1;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("Finder.FinderLiveService", localObject1);
      boolean bool2 = false;
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        bool1 = bool2;
        if (paramInt1 == 0)
        {
          localObject1 = paramblw.ZOg;
          bool1 = bool2;
          if (localObject1 != null)
          {
            paramblw = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
            if (paramblw != null) {
              paramblw.a((dix)localObject1);
            }
            Log.i("Finder.FinderLiveService", "handleRefreshMicResp updatePrivateMapKey");
            paramblw = com.tencent.mm.live.core.core.a.b.mMo;
            if (!com.tencent.mm.live.core.core.a.b.a.bek()) {
              break label257;
            }
            paramblw = com.tencent.mm.live.core.core.a.b.mMo;
            paramblw = com.tencent.mm.live.core.core.a.b.a.bej();
            localObject3 = ((dix)localObject1).aaOu.ZV();
            kotlin.g.b.s.s(localObject3, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
            paramblw.FO((String)localObject3);
            label178:
            paramblw = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
            if (paramblw != null) {
              break label343;
            }
            paramblw = localObject2;
          }
        }
      }
    }
    for (;;)
    {
      if (paramblw != null) {
        paramblw.privateMapKey = ((dix)localObject1).aaOu.ZV();
      }
      b((dix)localObject1);
      bool1 = true;
      AppMethodBeat.o(359505);
      return bool1;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
      label257:
      paramblw = com.tencent.mm.live.core.core.e.a.mRf;
      if (com.tencent.mm.live.core.core.e.a.a.bek())
      {
        paramblw = com.tencent.mm.live.core.core.e.a.mRf;
        paramblw = com.tencent.mm.live.core.core.e.a.a.beN();
        localObject3 = ((dix)localObject1).aaOu.ZV();
        kotlin.g.b.s.s(localObject3, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
        paramblw.FO((String)localObject3);
        break label178;
      }
      if (elL() == null) {
        break label178;
      }
      paramblw = elL();
      if (paramblw == null) {
        break label178;
      }
      localObject3 = ((dix)localObject1).aaOu.ZV();
      kotlin.g.b.s.s(localObject3, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
      paramblw.FO((String)localObject3);
      break label178;
      label343:
      localObject3 = paramblw.mZu;
      paramblw = localObject2;
      if (localObject3 != null) {
        paramblw = ((com.tencent.mm.live.core.core.model.h)localObject3).mNz;
      }
    }
  }
  
  public static void ap(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(359579);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new m(paramLong2, paramLong1));
    AppMethodBeat.o(359579);
  }
  
  private static void au(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(359899);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject2 = new StringBuilder("closeMiniProgram,purpose:").append(paramInt).append(", shoppingInMiniProgram:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject1).Eij != true)) {
        break label271;
      }
      i = 1;
      label90:
      if (i != 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.viewmodel.data.g.Ebv;
        com.tencent.mm.plugin.finder.live.viewmodel.data.g.exX().clear();
        localObject2 = new Intent();
        localObject1 = com.tencent.mm.plugin.findersdk.a.b.Hbz;
        ((Intent)localObject2).putExtra(com.tencent.mm.plugin.findersdk.a.b.fqZ(), paramInt);
        ((Intent)localObject2).addFlags(335544320);
        if ((!(paramContext instanceof Activity)) || (!((l)com.tencent.mm.kernel.h.ax(l.class)).D((Activity)paramContext))) {
          break label276;
        }
        localObject1 = com.tencent.mm.plugin.findersdk.e.a.HdV;
      }
    }
    for (localObject1 = com.tencent.mm.plugin.findersdk.e.a.fsB();; localObject1 = com.tencent.mm.plugin.findersdk.e.a.fsA())
    {
      ((Intent)localObject2).setClass(paramContext, (Class)localObject1);
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "closeMiniProgram", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "closeMiniProgram", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(359899);
      return;
      localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject1).Eij);
      break;
      label271:
      i = 0;
      break label90;
      label276:
      localObject1 = com.tencent.mm.plugin.findersdk.e.a.HdV;
    }
  }
  
  private static boolean awz(String paramString)
  {
    AppMethodBeat.i(359879);
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if (localObject == null)
    {
      localObject = null;
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label70;
      }
    }
    label70:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (Util.isEqual(paramString, (String)localObject))) {
        break label75;
      }
      AppMethodBeat.o(359879);
      return true;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).hTs;
      break;
    }
    label75:
    AppMethodBeat.o(359879);
    return false;
  }
  
  public static void b(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(360169);
    Object localObject1 = CGV;
    Object localObject2 = nkg;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mRB;
      if ((localObject2 == null) || (((com.tencent.mm.live.core.core.model.i)localObject2).isFloatMode())) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.view.mini.d.DVM;
      com.tencent.mm.plugin.finder.live.view.mini.d.PI(paramInt);
      localObject1 = com.tencent.mm.plugin.finder.live.view.mini.d.DVM;
      com.tencent.mm.plugin.finder.live.view.mini.d.bd(paramJSONObject);
      AppMethodBeat.o(360169);
      return;
    }
    if ((paramInt != 3) || (paramJSONObject != null))
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.view.mini.b)localObject1).DVz;
      localObject2 = CDN;
      if ((localObject1 != null) && (localObject2 != null))
      {
        com.tencent.mm.live.core.core.trtc.a locala = nkg;
        if (locala != null)
        {
          Context localContext = MMApplicationContext.getContext();
          kotlin.g.b.s.s(localContext, "getContext()");
          com.tencent.mm.live.core.core.trtc.a.b(locala.dB(localContext));
        }
        ((com.tencent.mm.plugin.finder.live.view.mini.d)((FinderLiveMiniView)localObject1).getMultiAreaLayout().getAdapter()).a(paramBoolean, (com.tencent.mm.plugin.finder.live.model.context.a)localObject2, paramInt, paramJSONObject);
      }
    }
    AppMethodBeat.o(360169);
  }
  
  public static void b(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(359888);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramg, "bundle");
    int i = paramg.hashCode();
    paramg.qAV = true;
    Object localObject2 = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    com.tencent.mm.plugin.finder.live.model.context.a locala = CDN;
    Object localObject1 = paramg.qAT.qZQ;
    if ((localObject1 instanceof MiniProgramHalfScreenStatusChangeListener)) {}
    for (localObject1 = (MiniProgramHalfScreenStatusChangeListener)localObject1;; localObject1 = null)
    {
      paramg.qAU = ((com.tencent.mm.plugin.h)localObject2).a(locala, (ci)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.viewmodel.data.g.Ebv;
      ((Map)com.tencent.mm.plugin.finder.live.viewmodel.data.g.exX()).put(Integer.valueOf(i), paramg);
      Log.i("Finder.FinderLiveService", "launchMiniProgram,key:" + i + ",bundle is null:false");
      paramg = new Intent();
      localObject1 = com.tencent.mm.plugin.findersdk.a.b.Hbz;
      localObject1 = com.tencent.mm.plugin.findersdk.a.b.fqZ();
      localObject2 = com.tencent.mm.plugin.findersdk.a.b.Hbz;
      paramg.putExtra((String)localObject1, com.tencent.mm.plugin.findersdk.a.b.frc());
      localObject1 = com.tencent.mm.plugin.findersdk.a.b.Hbz;
      paramg.putExtra(com.tencent.mm.plugin.findersdk.a.b.fra(), i);
      paramg.putExtra("MMActivity.OverrideEnterAnimation", -1);
      paramg.putExtra("MMActivity.OverrideExitAnimation", -1);
      paramg.addFlags(335544320);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramg.setClass(paramContext, com.tencent.mm.plugin.finder.live.utils.a.gE(paramContext));
      paramg = new com.tencent.mm.hellhoundlib.b.a().cG(paramg);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramg.aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "launchMiniProgram", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramg.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "launchMiniProgram", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(359888);
      return;
    }
  }
  
  private static void b(dix paramdix)
  {
    AppMethodBeat.i(359530);
    Object localObject;
    if (hKC)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject != null) {
        try
        {
          paramdix = new diy().parseFrom(paramdix.aaOv.Op);
          if (paramdix == null)
          {
            paramdix = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
            AppMethodBeat.o(359530);
            throw paramdix;
          }
        }
        catch (Exception paramdix)
        {
          Log.w("Finder.FinderLiveService", kotlin.g.b.s.X("updateSdkParam fail:", paramdix.getMessage()));
        }
      }
    }
    label157:
    label292:
    label300:
    label313:
    label316:
    label318:
    label321:
    for (;;)
    {
      AppMethodBeat.o(359530);
      return;
      diy localdiy = (diy)paramdix;
      paramdix = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).mZu;
      if (paramdix == null)
      {
        paramdix = null;
        label107:
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).mZu;
        if (localObject != null) {
          break label292;
        }
        localObject = null;
        label118:
        a(localdiy, paramdix, (com.tencent.mm.live.core.core.model.g)localObject);
        paramdix = nkg;
        if (paramdix != null) {
          paramdix.bfa();
        }
        localObject = new StringBuilder("updateSdkParam lastFps:");
        paramdix = nkg;
        if (paramdix != null) {
          break label300;
        }
        paramdix = null;
        Log.i("Finder.FinderLiveService", paramdix + " new Fps:" + com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTa);
        if ((nkg == null) || (!(nkg instanceof com.tencent.mm.live.core.core.a.b))) {
          continue;
        }
        paramdix = nkg;
        if ((paramdix == null) || (paramdix.mRK != com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTa)) {
          break label313;
        }
        i = 1;
        label230:
        if ((i != 0) || (!elK())) {
          break label316;
        }
        paramdix = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if ((paramdix == null) || (paramdix.Eet != true)) {
          break label318;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label321;
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)z.CHH);
        AppMethodBeat.o(359530);
        return;
        paramdix = paramdix.mNz;
        break label107;
        localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mJH;
        break label118;
        i = paramdix.mRK;
        paramdix = Integer.valueOf(i);
        break label157;
        i = 0;
        break label230;
        break;
      }
    }
  }
  
  public static void b(boolean paramBoolean, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super Bundle, ah> params)
  {
    AppMethodBeat.i(360010);
    kotlin.g.b.s.u(params, "callback");
    com.tencent.mm.plugin.finder.live.model.context.a locala = CDN;
    if (locala != null)
    {
      n localn = CGW;
      ap localap = CzZ;
      kotlin.g.b.s.u(locala, "liveData");
      kotlin.g.b.s.u(params, "callback");
      if (localap != null) {
        localap.a((kotlin.g.a.u)new n.d(locala, localap, localn, paramBoolean, params));
      }
    }
    AppMethodBeat.o(360010);
  }
  
  public static boolean bUB()
  {
    return hKC;
  }
  
  public static void bUK()
  {
    AppMethodBeat.i(359830);
    if ((nkg instanceof com.tencent.mm.live.core.core.f.d))
    {
      localObject = nkg;
      if (!(localObject instanceof com.tencent.mm.live.core.core.f.d)) {
        break label57;
      }
      localObject = (com.tencent.mm.live.core.core.f.d)localObject;
      if (localObject != null) {
        break label62;
      }
    }
    label57:
    label62:
    for (Object localObject = null;; localObject = Integer.valueOf(((com.tencent.mm.live.core.core.f.d)localObject).bfG()))
    {
      Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("requestLinkMic ret:", localObject));
      AppMethodBeat.o(359830);
      return;
      localObject = null;
      break;
    }
  }
  
  public static void bUL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(359647);
    StringBuilder localStringBuilder = new StringBuilder("stopRefreshMic curLive:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" curLinkUser:");
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject1 != null) {
        break label173;
      }
      localObject1 = localObject2;
      label63:
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = CHu;
      if (localObject1 != null) {
        ((ax)localObject1).emB();
      }
      localObject1 = nkg;
      if (localObject1 == null) {
        break label181;
      }
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).isFloatMode())) {
        break label181;
      }
    }
    label173:
    label181:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject1 = CDN;
        if (localObject1 != null) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.d((com.tencent.mm.plugin.finder.live.model.context.a)localObject1));
        }
      }
      AppMethodBeat.o(359647);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).Efv;
      break label63;
    }
  }
  
  public static void bUN()
  {
    Object localObject2 = null;
    AppMethodBeat.i(359667);
    StringBuilder localStringBuilder = new StringBuilder("stopActivateMic curLive:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" curLinkUser:");
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject1 != null) {
        break label121;
      }
    }
    label121:
    for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).Efv)
    {
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = CHv;
      if (localObject1 != null) {
        ((ax)localObject1).emB();
      }
      AppMethodBeat.o(359667);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
    }
  }
  
  public static void bUO()
  {
    AppMethodBeat.i(359854);
    Log.i("Finder.FinderLiveService", "removeBattleEndDelayTimer");
    MMHandlerThread.removeRunnable((Runnable)CHm);
    AppMethodBeat.o(359854);
  }
  
  public static void bUP()
  {
    AppMethodBeat.i(359867);
    Log.i("Finder.FinderLiveService", "removeBattleStartDelayTimer");
    MMHandlerThread.removeRunnable((Runnable)CHn);
    AppMethodBeat.o(359867);
  }
  
  public static void bUQ()
  {
    AppMethodBeat.i(359840);
    if ((nkg instanceof com.tencent.mm.live.core.core.a.b))
    {
      boolean bool = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfp().mSV;
      String str1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfp().mSW;
      String str2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfp().mSX;
      Log.i("Finder.FinderLiveService", "requestStopPkMic: isRoomPk:" + bool + ", connectRoomId:" + str1 + ", connectedRoomId:" + str2);
      localObject = nkg;
      if (!(localObject instanceof com.tencent.mm.live.core.core.a.b)) {
        break label159;
      }
      localObject = (com.tencent.mm.live.core.core.a.b)localObject;
      if (localObject != null)
      {
        kotlin.g.b.s.s(str1, "connectRoomId");
        kotlin.g.b.s.s(str2, "connectedRoomId");
        ((com.tencent.mm.live.core.core.a.b)localObject).aG(str1, str2);
      }
      localObject = nkg;
      if (!(localObject instanceof com.tencent.mm.live.core.core.a.b)) {
        break label164;
      }
    }
    label159:
    label164:
    for (Object localObject = (com.tencent.mm.live.core.core.a.b)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.b)localObject).beh();
      }
      AppMethodBeat.o(359840);
      return;
      localObject = null;
      break;
    }
  }
  
  public static int bgA()
  {
    AppMethodBeat.i(359920);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    int i = ((Number)com.tencent.d.a.a.a.a.a.jSj().bmg()).intValue();
    Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("mirroMode:", Integer.valueOf(i)));
    AppMethodBeat.o(359920);
    return i;
  }
  
  public static com.tencent.mm.live.core.b.a bhX()
  {
    return mRD;
  }
  
  public static com.tencent.mm.live.core.b.b bhY()
  {
    return mRE;
  }
  
  public static void biS()
  {
    AppMethodBeat.i(359798);
    nmW.a((com.tencent.mm.model.d.a)new n());
    ag localag = ag.CGN;
    ag.elf();
    AppMethodBeat.o(359798);
  }
  
  public static void biU()
  {
    AppMethodBeat.i(359788);
    Object localObject = s.CGa;
    s.ekT();
    localObject = s.CGa;
    s.ekU();
    nmW.gR(true);
    localObject = CHs;
    if (localObject != null) {
      ((ax)localObject).emB();
    }
    localObject = CHt;
    if (localObject != null) {
      ((ax)localObject).emB();
    }
    localObject = CHu;
    if (localObject != null) {
      ((ax)localObject).emB();
    }
    localObject = ag.CGN;
    ag.elg();
    bUO();
    AppMethodBeat.o(359788);
  }
  
  public static <T extends androidx.lifecycle.af> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(359485);
    kotlin.g.b.s.u(paramClass, "bu");
    com.tencent.mm.plugin.finder.live.model.context.a locala = CDN;
    if (locala == null)
    {
      AppMethodBeat.o(359485);
      return null;
    }
    paramClass = locala.business(paramClass);
    AppMethodBeat.o(359485);
    return paramClass;
  }
  
  public static void callLiveExperimentalAPI(String paramString)
  {
    AppMethodBeat.i(360134);
    com.tencent.mm.live.core.core.trtc.a locala = nkg;
    if (locala != null) {
      locala.callLiveExperimentalAPI(paramString);
    }
    AppMethodBeat.o(360134);
  }
  
  public static void controlLiveMiniWindowVisibility(boolean paramBoolean, final Context paramContext)
  {
    AppMethodBeat.i(359987);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(paramBoolean, paramContext));
    AppMethodBeat.o(359987);
  }
  
  public static void e(com.tencent.mm.bx.b paramb)
  {
    CHf = paramb;
  }
  
  public static com.tencent.mm.plugin.finder.live.viewmodel.data.g egD()
  {
    return CHb;
  }
  
  public static com.tencent.mm.plugin.finder.replay.a elA()
  {
    return CHo;
  }
  
  public static void elB()
  {
    AppMethodBeat.i(359491);
    ax localax = CHt;
    if (localax != null) {
      localax.emA();
    }
    AppMethodBeat.o(359491);
  }
  
  public static void elC()
  {
    AppMethodBeat.i(359576);
    d locald = CGY;
    if (locald != null) {
      locald.qz(true);
    }
    AppMethodBeat.o(359576);
  }
  
  private static void elD()
  {
    AppMethodBeat.i(359616);
    CHs = new ax("heartBeatLooper", mZd, 2);
    CHt = new ax("keepLiveLooper", mZc, 2);
    CHu = new ax("refreshMicLooper", CHq, 2);
    CHv = new ax("activateMicLooper", CHr, 2);
    AppMethodBeat.o(359616);
  }
  
  private static void elE()
  {
    Object localObject4 = null;
    boolean bool2 = true;
    AppMethodBeat.i(359637);
    Log.i("Finder.FinderLiveService", "setupBeautyAndFilterConfig");
    Object localObject1 = com.tencent.mm.live.core.d.b.mWI;
    localObject1 = (String)com.tencent.mm.live.core.d.b.bgW().get(Integer.valueOf(0));
    Object localObject2;
    Object localObject5;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject5 = com.tencent.mm.plugin.finder.api.d.a.auT(z.bAW());
      if ((localObject5 == null) || (((com.tencent.mm.plugin.finder.api.m)localObject5).dUv() != 1)) {
        break label1330;
      }
      i = 1;
      label80:
      if (i != 0) {
        break label1455;
      }
      if ((localObject5 == null) || (((com.tencent.mm.plugin.finder.api.m)localObject5).dUv() != 2)) {
        break label1335;
      }
      i = 1;
      label100:
      if (i == 0) {
        break label1340;
      }
      localObject2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zsf, "{\"skin_smooth\":80,\"eye_morph\":40,\"face_morph\":75,\"skin_bright\":80,\"eye_bright\":20,\"filter\":40,\"rosy\":0,\"filterKey\":0}");
    }
    for (;;)
    {
      for (;;)
      {
        boolean bool1;
        try
        {
          localObject3 = new com.tencent.mm.ad.i((String)localObject2);
          j = ((com.tencent.mm.ad.i)localObject3).getInt("filter");
        }
        catch (Exception localException1)
        {
          Object localObject3;
          Object localObject6;
          int m;
          int k;
          label1330:
          label1335:
          label1340:
          i = 0;
          label1455:
          int j = -1;
        }
        try
        {
          i = ((com.tencent.mm.ad.i)localObject3).getInt("filterKey");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            label1486:
            label1506:
            Integer localInteger;
            label1519:
            label1525:
            label1531:
            i = 0;
          }
        }
        try
        {
          localObject3 = com.tencent.mm.live.core.d.b.mWI;
          localObject3 = (String)com.tencent.mm.live.core.d.b.bgW().get(Integer.valueOf(i));
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          localObject6 = new StringBuilder("self.sex:");
          if (localObject5 != null) {
            break label1506;
          }
          localObject3 = null;
          Log.i("Finder.FinderLiveService", localObject3 + " expt beautyConfig:[" + j + ", " + (String)localObject1 + ", " + i + "] exptConfig:" + localObject2);
          CHa = j;
          localObject3 = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveConfigStorage().etW();
          localObject2 = localObject1;
          m = i;
          k = j;
          if (j != -1)
          {
            localObject2 = localObject1;
            m = i;
            k = j;
            if (localObject3 != null)
            {
              localObject2 = com.tencent.mm.live.core.d.b.mWI;
              localObject2 = localObject1;
              m = i;
              k = j;
              if (y.ZC((String)com.tencent.mm.live.core.d.b.bgW().get(Integer.valueOf(((din)localObject3).key))))
              {
                m = ((din)localObject3).key;
                localObject1 = com.tencent.mm.live.core.d.b.mWI;
                localObject2 = (String)com.tencent.mm.live.core.d.b.bgW().get(Integer.valueOf(((din)localObject3).key));
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                k = ((din)localObject3).value;
                localObject2 = localObject1;
              }
            }
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (localObject1 == null) {
            break label1519;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Eej;
          if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.api.m)localObject1).dUv() != 1)) {
            break label1519;
          }
          bool1 = true;
          Log.i("Finder.FinderLiveService", "final beautyConfig:[" + k + ", " + (String)localObject2 + ", " + m + "], isMale=" + bool1);
          localObject1 = new com.tencent.mm.live.core.b.a();
          localObject3 = a.CDv;
          if (a.ejZ()) {
            break label1525;
          }
          ((com.tencent.mm.live.core.b.a)localObject1).mUW = bool2;
          localObject3 = a.CDv;
          i = a.eka();
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(0), Integer.valueOf(a.a((a)localObject3, i, 0, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(14), Integer.valueOf(a.a((a)localObject3, i, 14, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(2), Integer.valueOf(a.a((a)localObject3, i, 2, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(3), Integer.valueOf(a.a((a)localObject3, i, 3, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(6), Integer.valueOf(a.a((a)localObject3, i, 6, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(7), Integer.valueOf(a.a((a)localObject3, i, 7, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(8), Integer.valueOf(a.a((a)localObject3, i, 8, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(9), Integer.valueOf(a.a((a)localObject3, i, 9, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(10), Integer.valueOf(a.a((a)localObject3, i, 10, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(11), Integer.valueOf(a.a((a)localObject3, i, 11, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(12), Integer.valueOf(a.a((a)localObject3, i, 12, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(13), Integer.valueOf(a.a((a)localObject3, i, 13, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(15), Integer.valueOf(a.a((a)localObject3, i, 15, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(16), Integer.valueOf(a.a((a)localObject3, i, 16, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(17), Integer.valueOf(a.a((a)localObject3, i, 17, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(18), Integer.valueOf(a.a((a)localObject3, i, 18, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(19), Integer.valueOf(a.a((a)localObject3, i, 19, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(20), Integer.valueOf(a.a((a)localObject3, i, 20, bool1)));
          ((Map)((com.tencent.mm.live.core.b.a)localObject1).mUV).put(Integer.valueOf(21), Integer.valueOf(a.a((a)localObject3, i, 21, bool1)));
          mRD = (com.tencent.mm.live.core.b.a)localObject1;
          localObject1 = mRD;
          if (localObject1 != null) {
            break label1531;
          }
          localObject1 = localObject4;
          Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("#setupBeautyAndFilterConfig beautyConfig=", localObject1));
          mRE = new com.tencent.mm.live.core.b.b(m, (String)localObject2, k);
          filterMap.clear();
          localObject1 = com.tencent.mm.live.core.d.b.mWI;
          localObject1 = ((Map)com.tencent.mm.live.core.d.b.bgW()).entrySet().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label1541;
          }
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (Map)filterMap;
          localObject4 = ((Map.Entry)localObject2).getKey();
          i = ((Number)((Map.Entry)localObject2).getKey()).intValue();
          localObject5 = (String)((Map.Entry)localObject2).getValue();
          localObject6 = com.tencent.mm.live.core.d.b.mWI;
          ((Map)localObject3).put(localObject4, new com.tencent.mm.live.core.d.b.a(i, (String)localObject5, com.tencent.mm.live.core.d.b.tw(((Number)((Map.Entry)localObject2).getKey()).intValue()), CHa));
        }
        catch (Exception localException3)
        {
          break label1486;
        }
      }
      i = 0;
      break label80;
      i = 0;
      break label100;
      localObject3 = z.bBF();
      if (localObject3 == null)
      {
        localObject2 = null;
        Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("read sex from finder contact fail, try again from contact:", localObject2));
        if ((localObject3 != null) && (((az)localObject3).sex == 1))
        {
          i = 1;
          if (i != 0) {
            continue;
          }
          if ((localObject3 == null) || (((az)localObject3).sex != 2)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          localObject2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zsf, "{\"skin_smooth\":80,\"eye_morph\":40,\"face_morph\":75,\"skin_bright\":80,\"eye_bright\":20,\"filter\":40,\"rosy\":0,\"filterKey\":0}");
        }
      }
      else
      {
        localObject2 = Integer.valueOf(((az)localObject3).sex);
        continue;
      }
      i = 0;
      continue;
      i = 0;
      continue;
      localObject2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zse, "{\"skin_smooth\":55,\"eye_morph\":20,\"face_morph\":50,\"skin_bright\":55,\"eye_bright\":20,\"filter\":40,\"rosy\":0,\"filterKey\":0}");
      continue;
      Log.w("Finder.FinderLiveService", kotlin.g.b.s.X("parse clicfg_live_beauty_config fail. ", localException1.getMessage()));
      continue;
      localInteger = Integer.valueOf(((com.tencent.mm.plugin.finder.api.m)localObject5).dUv());
      continue;
      bool1 = false;
      continue;
      bool2 = false;
      continue;
      localObject1 = ((com.tencent.mm.live.core.b.a)localObject1).toString();
    }
    label1541:
    AppMethodBeat.o(359637);
  }
  
  private static void elH()
  {
    int j = 0;
    Object localObject1 = null;
    long l6 = 0L;
    AppMethodBeat.i(359723);
    Object localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
    int i;
    label37:
    long l3;
    label61:
    label77:
    long l7;
    label102:
    long l1;
    label115:
    long l4;
    label124:
    long l2;
    label143:
    long l5;
    if (localObject4 == null)
    {
      if (localObject1 == null) {
        break label326;
      }
      i = 1;
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 != null) {
        break label331;
      }
      l3 = 0L;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 != null) {
        break label359;
      }
      l7 = j;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 != null) {
        break label368;
      }
      localObject1 = "";
      localObject4 = com.tencent.mm.live.core.core.a.b.mMo;
      if (!com.tencent.mm.live.core.core.a.b.a.bek()) {
        break label432;
      }
      l1 = 1L;
      if (!hKC) {
        break label473;
      }
      l4 = 0L;
      localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject4 != null) {
        break label491;
      }
      l2 = 0L;
      localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject4 != null) {
        break label537;
      }
      l5 = l6;
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.plugin.finder.live.report.j.a(l3, l7, (String)localObject1, l1, l4, l2, l5);
        AppMethodBeat.o(359723);
        return;
        localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject4).Efw;
        if (localObject4 == null) {
          break;
        }
        synchronized ((Iterable)localObject4)
        {
          Iterator localIterator = ???.iterator();
          label217:
          if (localIterator.hasNext())
          {
            localObject4 = localIterator.next();
            String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).mXL;
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
            if (localObject1 == null) {}
            for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).eyF())
            {
              boolean bool = Util.isEqual(str, (String)localObject1);
              if (!bool) {
                break label217;
              }
              localObject1 = localObject4;
              localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1;
              break;
            }
          }
          localObject1 = null;
        }
      }
      label326:
      i = 0;
      break label37;
      label331:
      Object localObject3 = localObject2.liveInfo;
      if (localObject3 == null)
      {
        l3 = 0L;
        break label61;
      }
      l3 = ((bip)localObject3).liveId;
      break label61;
      label359:
      j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject3).eyG();
      break label77;
      label368:
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject3).mZu;
      if (localObject3 == null)
      {
        localObject3 = "";
        break label102;
      }
      localObject3 = ((com.tencent.mm.live.core.core.model.h)localObject3).mJH;
      if (localObject3 == null)
      {
        localObject3 = "";
        break label102;
      }
      localObject4 = ((com.tencent.mm.live.core.core.model.g)localObject3).mIA;
      localObject3 = localObject4;
      if (localObject4 != null) {
        break label102;
      }
      localObject3 = "";
      break label102;
      label432:
      localObject4 = com.tencent.mm.live.core.core.e.a.mRf;
      if (com.tencent.mm.live.core.core.e.a.a.bek())
      {
        l1 = 2L;
        break label115;
      }
      localObject4 = com.tencent.mm.live.core.core.f.d.mUj;
      if (com.tencent.mm.live.core.core.f.d.a.bek())
      {
        l1 = 3L;
        break label115;
      }
      l1 = 0L;
      break label115;
      label473:
      if (i != 0)
      {
        l4 = 2L;
        break label124;
      }
      l4 = 1L;
      break label124;
      label491:
      localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject4).mZu;
      if (localObject4 == null)
      {
        l2 = 0L;
        break label143;
      }
      localObject4 = ((com.tencent.mm.live.core.core.model.h)localObject4).mJH;
      if (localObject4 == null)
      {
        l2 = 0L;
        break label143;
      }
      l2 = ((com.tencent.mm.live.core.core.model.g)localObject4).mNw;
      break label143;
      label537:
      localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject4).mZu;
      l5 = l6;
      if (localObject4 != null)
      {
        localObject4 = ((com.tencent.mm.live.core.core.model.h)localObject4).mJH;
        l5 = l6;
        if (localObject4 != null) {
          l5 = ((com.tencent.mm.live.core.core.model.g)localObject4).mNx;
        }
      }
    }
  }
  
  public static void elJ()
  {
    AppMethodBeat.i(359821);
    Log.i("Finder.FinderLiveService", "setAnchorPauseMiniView");
    com.tencent.mm.live.core.core.trtc.a locala = nkg;
    if (locala != null) {
      locala.sY(2);
    }
    AppMethodBeat.o(359821);
  }
  
  public static boolean elK()
  {
    AppMethodBeat.i(359934);
    String str = com.tencent.mm.compatible.deviceinfo.q.aPo();
    kotlin.g.b.s.s(str, "getModel()");
    str = str.toLowerCase();
    kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
    if (!kotlin.n.n.a((CharSequence)CGZ, (CharSequence)str, false)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.FinderLiveService", "enableDynamicVideoParam notSupportDynamicVideoParamDevice:" + CGZ + " model:" + str + " result:" + bool);
      AppMethodBeat.o(359934);
      return bool;
    }
  }
  
  public static com.tencent.mm.live.core.core.f.d elL()
  {
    AppMethodBeat.i(359940);
    Object localObject;
    if ((nkg != null) && ((nkg instanceof com.tencent.mm.live.core.core.f.d)))
    {
      localObject = nkg;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.visitor.LiveVisitorTRTCCore");
        AppMethodBeat.o(359940);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.live.core.core.f.d)localObject;
      AppMethodBeat.o(359940);
      return localObject;
    }
    if ((nkg != null) && ((nkg instanceof com.tencent.mm.live.core.core.e.a)))
    {
      localObject = nkg;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.secdevice.LiveSecondaryDeviceTRTCCore");
        AppMethodBeat.o(359940);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.live.core.core.f.d)localObject;
      AppMethodBeat.o(359940);
      return localObject;
    }
    AppMethodBeat.o(359940);
    return null;
  }
  
  public static com.tencent.mm.live.core.core.a.b elM()
  {
    AppMethodBeat.i(359948);
    if ((nkg != null) && ((nkg instanceof com.tencent.mm.live.core.core.a.b)))
    {
      Object localObject = nkg;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
        AppMethodBeat.o(359948);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.live.core.core.a.b)localObject;
      AppMethodBeat.o(359948);
      return localObject;
    }
    AppMethodBeat.o(359948);
    return null;
  }
  
  public static void elN()
  {
    AppMethodBeat.i(360048);
    ??? = CGW;
    com.tencent.mm.plugin.finder.live.viewmodel.data.business.e locale = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if (locale == null)
    {
      locale = null;
      localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject3 != null) {
        break label134;
      }
    }
    label134:
    for (Object localObject3 = null;; localObject3 = Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject3).Eev))
    {
      ??? = ((n)???).CFv;
      kotlin.g.b.s.s(???, "externalLiveCallbacks");
      synchronized ((Iterable)???)
      {
        Iterator localIterator = ((Iterable)???).iterator();
        if (!localIterator.hasNext()) {
          break label145;
        }
        com.tencent.d.a.a.a.a locala = (com.tencent.d.a.a.a.a)localIterator.next();
        Log.i(n.TAG, kotlin.g.b.s.X("notifyMiniWindowStatusToExternal isShown:", Boolean.TRUE));
        locala.c(locale, (Integer)localObject3);
      }
      localObject2 = localObject1.Eeu;
      break;
    }
    label145:
    Object localObject2 = ah.aiuX;
    AppMethodBeat.o(360048);
  }
  
  public static void elO()
  {
    AppMethodBeat.i(360053);
    ap localap = CzZ;
    if (localap != null) {
      ap.a.a(localap, (kotlin.g.a.s)aj.f.CHy);
    }
    AppMethodBeat.o(360053);
  }
  
  public static void elP()
  {
    int i = 1;
    AppMethodBeat.i(360097);
    Object localObject = nkg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).isFloatMode() != true)) {}
    }
    while (i != 0)
    {
      localObject = ar.CIh;
      ar.emj();
      localObject = nkg;
      if (localObject == null) {
        break label91;
      }
      ((com.tencent.mm.live.core.core.trtc.a)localObject).bcg();
      AppMethodBeat.o(360097);
      return;
      i = 0;
    }
    localObject = nkg;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB)
    {
      Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("fullScreen liveStatus:", localObject));
      label91:
      AppMethodBeat.o(360097);
      return;
    }
  }
  
  public static void elQ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(360161);
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).mZr;
      if (localObject3 != null)
      {
        if (((dix)localObject3).aaOv == null)
        {
          Log.i("Finder.FinderLiveService", "updateVideoParamsByMic: sdk_params is null, skip");
          AppMethodBeat.o(360161);
          return;
        }
        localObject1 = (com.tencent.mm.bx.a)new diy();
        localObject3 = ((dix)localObject3).aaOv.Op;
      }
    }
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (diy)localObject1;
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        a((diz)localObject1);
        localObject1 = nkg;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject1).bfa();
        }
        AppMethodBeat.o(360161);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        diz localdiz = null;
        continue;
        localdiz = localdiz.aaOA;
      }
    }
  }
  
  public static void elR()
  {
    int k = 0;
    int j = 1;
    AppMethodBeat.i(360183);
    Object localObject1 = CGV;
    Object localObject3 = ((com.tencent.mm.plugin.finder.live.view.mini.b)localObject1).DVz;
    Object localObject2 = CDN;
    int i;
    if ((localObject3 != null) && (localObject2 != null))
    {
      localObject3 = (com.tencent.mm.plugin.finder.live.view.mini.d)((FinderLiveMiniView)localObject3).getMultiAreaLayout().getAdapter();
      com.tencent.mm.plugin.finder.live.view.mini.d.a locala = com.tencent.mm.plugin.finder.live.view.mini.d.DVM;
      i = com.tencent.mm.plugin.finder.live.view.mini.d.ewh();
      locala = com.tencent.mm.plugin.finder.live.view.mini.d.DVM;
      ((com.tencent.mm.plugin.finder.live.view.mini.d)localObject3).a(false, (com.tencent.mm.plugin.finder.live.model.context.a)localObject2, i, com.tencent.mm.plugin.finder.live.view.mini.d.ewi());
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).bp(((com.tencent.mm.plugin.finder.live.view.mini.b)localObject1).DVB);
      ((com.tencent.mm.plugin.finder.live.view.mini.b)localObject1).ewe();
    }
    if (nkg == null) {}
    for (localObject1 = null;; localObject1 = com.tencent.mm.live.core.core.trtc.a.beW())
    {
      localObject2 = nkg;
      i = k;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mRB;
        i = k;
        if (localObject2 != null)
        {
          i = k;
          if (((com.tencent.mm.live.core.core.model.i)localObject2).bex() == true) {
            i = 1;
          }
        }
      }
      if (i != 0) {
        j = 2;
      }
      localObject3 = CGV.DVA;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Point(200, 100);
      }
      ((com.tencent.mm.plugin.finder.live.view.mini.c)localObject3).b(j, (Point)localObject2);
      AppMethodBeat.o(360183);
      return;
    }
  }
  
  private static final void elS()
  {
    AppMethodBeat.i(360214);
    Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    Object localObject1;
    int j;
    int i;
    label119:
    Object localObject3;
    Object localObject4;
    com.tencent.d.a.a.a.c.a locala;
    atz localatz;
    String str1;
    byte[] arrayOfByte;
    long l1;
    long l2;
    String str2;
    label337:
    String str3;
    label363:
    i locali;
    if (localObject2 != null)
    {
      Log.i("Finder.FinderLiveService", "doGetLiveMsg heartBeatTimestamp:" + CHd + " [" + CDN + "]，test:" + CHi);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
        break label446;
      }
      j = 1;
      localObject1 = null;
      if (CHd - CHe < ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdE * 1000) {
        break label451;
      }
      i = 1;
      localObject3 = localObject1;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdC)
      {
        localObject3 = localObject1;
        if (i != 0)
        {
          localObject1 = ag.CGN;
          localObject1 = ag.e(Long.valueOf(CHd));
          localObject3 = localObject1;
          if (localObject1 != null)
          {
            CHe = CHd;
            localObject3 = localObject1;
          }
        }
      }
      localObject4 = new bui();
      localObject1 = CDO;
      if (localObject1 != null)
      {
        localObject4 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = ((com.tencent.mm.plugin.finder.live.view.a)localObject1).getContext();
        kotlin.g.b.s.s(localObject1, "curLayout.context");
        localObject4 = ((bn)com.tencent.mm.ui.component.k.nq((Context)localObject1).cq(bn.class)).fou();
      }
      locala = (com.tencent.d.a.a.a.c.a)com.tencent.mm.kernel.h.ax(com.tencent.d.a.a.a.c.a.class);
      localObject1 = bi.ABn;
      localatz = bi.a((bui)localObject4);
      str1 = z.bAW();
      arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
      l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).liveInfo.liveId;
      l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      str2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).nonceId;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 != null) {
        break label456;
      }
      i = 4;
      str3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).hTs;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
      if (localObject1 != null) {
        break label482;
      }
      localObject1 = null;
      locali = new i((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2);
      if (CGT != null) {
        break label513;
      }
      localObject2 = null;
    }
    for (;;)
    {
      kotlin.g.b.s.s(locala, "service(ILiveCgiFactoryService::class.java)");
      com.tencent.d.a.a.a.c.a.a.a(locala, localatz, str1, arrayOfByte, l1, l2, str2, j, false, localObject3, i, (bui)localObject4, str3, (com.tencent.d.a.a.a.c.a.b)locali, (String)localObject2, (bfv)localObject1, null, 32896).bFJ();
      CHd = System.currentTimeMillis();
      AppMethodBeat.o(360214);
      return;
      label446:
      j = 2;
      break;
      label451:
      i = 0;
      break label119;
      label456:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EdI;
      if (localObject1 == null)
      {
        i = 4;
        break label337;
      }
      i = ((bcz)localObject1).ZNI;
      break label337;
      label482:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject1).akgQ;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label363;
      }
      localObject1 = (bfv)((x)localObject1).getValue();
      break label363;
      label513:
      localObject2 = nkg;
      if (localObject2 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mSd;
      }
    }
  }
  
  private static final void elT()
  {
    AppMethodBeat.i(360222);
    Log.i("Finder.FinderLiveService", "doKeepLive[" + CDN + ']');
    com.tencent.mm.plugin.finder.live.viewmodel.data.business.f localf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    Object localObject1;
    int j;
    bui localbui;
    int i;
    label86:
    label104:
    label125:
    long l1;
    byte[] arrayOfByte;
    String str1;
    long l2;
    String str2;
    String str3;
    Object localObject2;
    if (localf != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
        break label256;
      }
      j = 1;
      localbui = new bui();
      localObject1 = CHb;
      if (localObject1 != null) {
        break label261;
      }
      i = 0;
      localbui.hLK = i;
      localObject1 = CHb;
      if (localObject1 != null) {
        break label287;
      }
      i = 0;
      localbui.AJo = i;
      localObject1 = CHb;
      if (localObject1 != null) {
        break label313;
      }
      localObject1 = "";
      l1 = localf.liveInfo.liveId;
      arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
      str1 = z.bAW();
      l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      str2 = localf.nonceId;
      str3 = localf.sessionBuffer;
      if (CGT != null) {
        break label357;
      }
      localObject2 = null;
    }
    for (;;)
    {
      new com.tencent.mm.plugin.finder.live.model.cgi.m(l1, arrayOfByte, str1, l2, j, str2, str3, null, 0, localbui, 0, null, (String)localObject2, (String)localObject1, 0, localf.hTs, null, 85376).bFJ().g(new aj..ExternalSyntheticLambda0(localf));
      AppMethodBeat.o(360222);
      return;
      label256:
      j = 2;
      break;
      label261:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Bwy;
      if (localObject1 == null)
      {
        i = 0;
        break label86;
      }
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject1).AJo;
      break label86;
      label287:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Bwy;
      if (localObject1 == null)
      {
        i = 0;
        break label104;
      }
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject1).AJo;
      break label104;
      label313:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Eby;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label125;
      }
      localObject2 = ((FinderLiveBundle)localObject1).ecSource;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label125;
      }
      localObject1 = "";
      break label125;
      label357:
      localObject2 = nkg;
      if (localObject2 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mSd;
      }
    }
  }
  
  private static final void elU()
  {
    AppMethodBeat.i(360235);
    Log.i("Finder.FinderLiveService", "doRefreshMic[" + CDN + ']');
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
        break label218;
      }
    }
    label218:
    for (int i = 1;; i = 2)
    {
      long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo.liveId;
      long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).hKN;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).nonceId;
      byte[] arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).mZp;
      String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF();
      localObject1 = (com.tencent.mm.plugin.finder.live.model.cgi.ap.a)new k((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1);
      Log.i("Finder.FinderLiveService", "refreshLinkMic liveId:" + l1 + ", objectId:" + l2 + ", nonceId:" + localObject2 + ", scene:" + i + ", sdkUserId:" + str);
      new com.tencent.mm.plugin.finder.live.model.cgi.ap(l1, l2, (String)localObject2, arrayOfByte, i, str, (com.tencent.mm.plugin.finder.live.model.cgi.ap.a)localObject1).bFJ();
      AppMethodBeat.o(360235);
      return;
    }
  }
  
  private static final void elV()
  {
    AppMethodBeat.i(360242);
    Log.i("Finder.FinderLiveService", "doActivateMic curLiveRoomData:" + CDN + " isAnchor:" + hKC);
    Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if ((localObject2 != null) && (hKC))
    {
      Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject1 != null)
      {
        Object localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).Efv;
        if (localObject3 != null)
        {
          Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("doActivateMic curLinkUser:", CDN));
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).EbD)
          {
            long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).liveInfo.liveId;
            long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).hKN;
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).nonceId;
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
            localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).sessionId;
            com.tencent.mm.plugin.finder.live.model.cgi.c.a locala = (com.tencent.mm.plugin.finder.live.model.cgi.c.a)new h();
            Log.i("Finder.FinderLiveService", "activateLiveMic liveId:" + l1 + ", objectId:" + l2 + ", nonceId:" + localObject1 + ", scene:1, sessionId:" + localObject3);
            new com.tencent.mm.plugin.finder.live.model.cgi.c(l1, l2, (String)localObject1, (byte[])localObject2, (String)localObject3, locala).bFJ();
          }
        }
      }
    }
    AppMethodBeat.o(360242);
  }
  
  public static long elj()
  {
    return CGU;
  }
  
  public static com.tencent.mm.plugin.finder.live.view.a elk()
  {
    return CDO;
  }
  
  public static n ell()
  {
    return CGW;
  }
  
  public static af elm()
  {
    return CGX;
  }
  
  public static d eln()
  {
    return CGY;
  }
  
  public static com.tencent.mm.plugin.finder.live.view.e elo()
  {
    return BwQ;
  }
  
  public static int elp()
  {
    return CHa;
  }
  
  public static HashMap<Integer, com.tencent.mm.live.core.d.b.a> elq()
  {
    return filterMap;
  }
  
  public static com.tencent.mm.plugin.finder.live.model.context.a elr()
  {
    return CDN;
  }
  
  public static int els()
  {
    return CHc;
  }
  
  public static com.tencent.mm.bx.b elt()
  {
    return CHf;
  }
  
  public static int elu()
  {
    return CHg;
  }
  
  public static int elv()
  {
    return CHh;
  }
  
  public static boolean elw()
  {
    return CHi;
  }
  
  public static boolean elx()
  {
    return CHj;
  }
  
  public static boolean ely()
  {
    return CHk;
  }
  
  public static boolean elz()
  {
    return CHl;
  }
  
  public static void enableAudioVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(360123);
    com.tencent.mm.live.core.core.trtc.a locala = nkg;
    if (locala != null) {
      locala.beO().enableAudioVolumeEvaluation(paramInt);
    }
    AppMethodBeat.o(360123);
  }
  
  public static void enableCustomAudioCapture(boolean paramBoolean)
  {
    AppMethodBeat.i(360113);
    com.tencent.mm.live.core.core.trtc.a locala = nkg;
    if (locala != null) {
      locala.beO().enableCustomAudioCapture(paramBoolean);
    }
    AppMethodBeat.o(360113);
  }
  
  public static void enableMicExternalAudioFrame(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(360119);
    com.tencent.mm.live.core.core.trtc.a locala = nkg;
    if (locala != null) {
      locala.beO().enableMixExternalAudioFrame(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(360119);
  }
  
  public static ap getFinderLiveAssistant()
  {
    return CzZ;
  }
  
  public static bgt getFinderLiveExternalInfo()
  {
    return CGW.CFw;
  }
  
  public static void getFinderLiveMemberListInfo(ca.a<List<bjk>> parama)
  {
    AppMethodBeat.i(359979);
    kotlin.g.b.s.u(parama, "callback");
    n.a(CzZ, CDN, parama);
    AppMethodBeat.o(359979);
  }
  
  public static com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    return nkg;
  }
  
  public static void h(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(359406);
    Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("write curLiveRoomData to :", parama));
    CDN = parama;
    AppMethodBeat.o(359406);
  }
  
  public static boolean isAnchorLiving()
  {
    AppMethodBeat.i(359908);
    com.tencent.mm.plugin.finder.live.model.context.a locala = CDN;
    if ((locala != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId != 0L) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA()) && (hKC))
    {
      AppMethodBeat.o(359908);
      return true;
    }
    AppMethodBeat.o(359908);
    return false;
  }
  
  public static boolean isFinished()
  {
    AppMethodBeat.i(359814);
    Object localObject = CDO;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof Activity)) {
        break label48;
      }
    }
    label48:
    for (localObject = (Activity)localObject;; localObject = null)
    {
      if (localObject != null) {
        break label53;
      }
      AppMethodBeat.o(359814);
      return false;
      localObject = ((com.tencent.mm.plugin.finder.live.view.a)localObject).getContext();
      break;
    }
    label53:
    boolean bool = ((Activity)localObject).isDestroyed();
    AppMethodBeat.o(359814);
    return bool;
  }
  
  public static boolean isVisitorLiving()
  {
    AppMethodBeat.i(359914);
    com.tencent.mm.plugin.finder.live.model.context.a locala = CDN;
    if ((locala != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId != 0L) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA()) && (!hKC))
    {
      AppMethodBeat.o(359914);
      return true;
    }
    AppMethodBeat.o(359914);
    return false;
  }
  
  public static void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(359848);
    Log.i("Finder.FinderLiveService", "startBattleEndDelayTimer delay:" + paramLong + " battleId:" + paramString);
    MMHandlerThread.removeRunnable((Runnable)CHm);
    paramString = new a(paramString);
    CHm = paramString;
    MMHandlerThread.postToMainThreadDelayed((Runnable)paramString, paramLong);
    AppMethodBeat.o(359848);
  }
  
  public static void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(359860);
    Log.i("Finder.FinderLiveService", "startBattleStartDelayTimer delay:" + paramLong + " battleId:" + paramString);
    if (paramString != null)
    {
      MMHandlerThread.removeRunnable((Runnable)CHn);
      paramString = new b(paramString);
      CHn = paramString;
      MMHandlerThread.postToMainThreadDelayed((Runnable)paramString, paramLong);
    }
    AppMethodBeat.o(359860);
  }
  
  public static void mixExternalAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(360128);
    com.tencent.mm.live.core.core.trtc.a locala = nkg;
    if (locala != null)
    {
      TRTCCloudDef.TRTCAudioFrame localTRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
      localTRTCAudioFrame.data = paramArrayOfByte;
      localTRTCAudioFrame.sampleRate = paramInt1;
      localTRTCAudioFrame.channel = paramInt2;
      localTRTCAudioFrame.timestamp = paramLong;
      locala.beO().mixExternalAudioFrame(localTRTCAudioFrame);
    }
    AppMethodBeat.o(360128);
  }
  
  public static boolean needMirror()
  {
    AppMethodBeat.i(359928);
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    int i;
    label68:
    boolean bool;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (localObject == null) {
          break label120;
        }
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).mZu;
        if (localObject == null) {
          break label120;
        }
        localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mNB;
        if ((localObject == null) || (((com.tencent.mm.live.core.core.model.f)localObject).mNj != true)) {
          break label120;
        }
        i = 1;
        if (i == 0) {
          break label161;
        }
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject != null) {
        break label125;
      }
      bool = true;
      label88:
      Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("use front camera, finalMirror:", Boolean.valueOf(bool)));
    }
    for (;;)
    {
      AppMethodBeat.o(359928);
      return bool;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).mZu;
      break;
      label120:
      i = 0;
      break label68;
      label125:
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).mZu;
      if (localObject == null)
      {
        bool = true;
        break label88;
      }
      localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mNB;
      if (localObject == null)
      {
        bool = true;
        break label88;
      }
      bool = ((com.tencent.mm.live.core.core.model.f)localObject).mNm;
      break label88;
      label161:
      Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("use back camera, finalMirror:", Boolean.FALSE));
      bool = false;
    }
  }
  
  public static void od(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(359640);
    StringBuilder localStringBuilder = new StringBuilder("refreshMic delay:").append(paramLong).append(" curLive:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" curLinkUser:");
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject1 != null) {
        break label139;
      }
    }
    label139:
    for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).Efv)
    {
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = CHu;
      if (localObject1 != null) {
        ((ax)localObject1).f(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(359640);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
    }
  }
  
  public static void oe(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(359657);
    StringBuilder localStringBuilder = new StringBuilder("activateMic delay:").append(paramLong).append(" curLive:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" curLinkUser:");
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject1 != null) {
        break label139;
      }
    }
    label139:
    for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).Efv)
    {
      Log.i("Finder.FinderLiveService", localObject1);
      localObject1 = CHv;
      if (localObject1 != null) {
        ((ax)localObject1).f(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(359657);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
    }
  }
  
  public static void of(long paramLong)
  {
    AppMethodBeat.i(359677);
    StringBuilder localStringBuilder = new StringBuilder("keepAlive delay:").append(paramLong).append(" curLive:");
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      Log.i("Finder.FinderLiveService", localObject);
      localObject = CHt;
      if (localObject != null) {
        ((ax)localObject).emB();
      }
      localObject = CHt;
      if (localObject != null) {
        ((ax)localObject).f(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(359677);
      return;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).liveInfo;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Long.valueOf(((bip)localObject).liveId);
      }
    }
  }
  
  public static void og(long paramLong)
  {
    AppMethodBeat.i(360194);
    if (CHo == null)
    {
      CHo = new com.tencent.mm.plugin.finder.replay.a(paramLong, (byte)0);
      localObject = CDO;
      if (localObject != null) {
        break label86;
      }
    }
    label86:
    for (Object localObject = null;; localObject = (com.tencent.mm.plugin.finder.live.plugin.ag)((com.tencent.mm.plugin.finder.live.view.a)localObject).getPlugin(com.tencent.mm.plugin.finder.live.plugin.ag.class))
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ag)localObject).CXD = CHo;
      }
      localObject = CHo;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.replay.a)localObject).FjD = ((com.tencent.mm.plugin.finder.replay.a.a)new y());
      }
      localObject = CHo;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.replay.a)localObject).exT();
      }
      AppMethodBeat.o(360194);
      return;
    }
  }
  
  public static void pauseLive(int paramInt)
  {
    AppMethodBeat.i(360142);
    StringBuilder localStringBuilder = new StringBuilder("pauseLive: liveStarted:");
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if (localObject == null)
    {
      localObject = null;
      Log.i("Finder.FinderLiveService", localObject + ", scene:" + paramInt);
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).isLiveStarted() != true)) {
        break label103;
      }
    }
    label103:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label108;
      }
      AppMethodBeat.o(360142);
      return;
      localObject = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).isLiveStarted());
      break;
    }
    label108:
    localObject = CzZ;
    if (localObject != null) {
      ((ap)localObject).a(1, paramInt, (al.a)new p());
    }
    AppMethodBeat.o(360142);
  }
  
  public static void pauseVisitorLive()
  {
    AppMethodBeat.i(359993);
    Object localObject = nkg;
    if ((localObject instanceof com.tencent.mm.live.core.core.f.d)) {}
    for (localObject = (com.tencent.mm.live.core.core.f.d)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.f.d)localObject).mUn;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.d)localObject).bck();
        }
      }
      AppMethodBeat.o(359993);
      return;
    }
  }
  
  public static void qE(boolean paramBoolean)
  {
    AppMethodBeat.i(359804);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(paramBoolean));
    AppMethodBeat.o(359804);
  }
  
  private static void qF(boolean paramBoolean)
  {
    Object localObject3 = null;
    AppMethodBeat.i(360079);
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    Object localObject4;
    Object localObject5;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject4 = CDN;
      if ((localObject4 == null) || (localObject1 == null)) {
        break label339;
      }
      localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject4).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee;
      if (localObject5 != null) {
        break label252;
      }
      localObject2 = null;
      localObject5 = (at)((kotlin.r)localObject2).bsC;
      if (localObject5 != null) {
        break label298;
      }
      localObject2 = null;
      label77:
      if (localObject2 == null)
      {
        localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject4).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee;
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject4).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee;
        if (localObject2 != null) {
          break label328;
        }
        localObject2 = null;
        label118:
        ((c)localObject5).d((at)localObject1, ((Integer)localObject2).intValue());
        qG(paramBoolean);
        localObject1 = elM();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRI = false;
        }
      }
      localObject1 = ah.aiuX;
      label149:
      if (localObject1 == null)
      {
        qG(paramBoolean);
        localObject1 = elM();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRI = false;
        }
        localObject2 = new StringBuilder("playNext error curMusicItem:");
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject1 != null) {
          break label344;
        }
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      Log.e("Finder.FinderLiveService", localObject1 + ",curLiveRoomData:" + CDN);
      AppMethodBeat.o(360079);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Eee;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((c)localObject1).ekc();
      break;
      label252:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject4).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee;
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = Integer.valueOf(((c)localObject2).hKr))
      {
        localObject2 = ((c)localObject5).e((at)localObject1, ((Integer)localObject2).intValue());
        break;
      }
      label298:
      CGT.a((at)localObject5, ((Number)((kotlin.r)localObject2).bsD).intValue(), true);
      qG(paramBoolean);
      localObject2 = ah.aiuX;
      break label77;
      label328:
      localObject2 = Integer.valueOf(((c)localObject2).hKr);
      break label118;
      label339:
      localObject1 = null;
      break label149;
      label344:
      localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Eee;
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = ((c)localObject4).ekc();
      }
    }
  }
  
  private static void qG(boolean paramBoolean)
  {
    AppMethodBeat.i(360088);
    Object localObject = CDO;
    if (localObject == null) {
      localObject = null;
    }
    while (paramBoolean)
    {
      if (localObject == null) {
        break label75;
      }
      ((j.a)localObject).ehF();
      AppMethodBeat.o(360088);
      return;
      localObject = (com.tencent.mm.plugin.finder.live.plugin.u)((com.tencent.mm.plugin.finder.live.view.a)localObject).getPlugin(com.tencent.mm.plugin.finder.live.plugin.u.class);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((com.tencent.mm.plugin.finder.live.plugin.u)localObject).CwN;
      }
    }
    if (localObject != null) {
      ((j.a)localObject).playStart();
    }
    label75:
    AppMethodBeat.o(360088);
  }
  
  public static void registerExternalLiveCallback(com.tencent.d.a.a.a.a parama)
  {
    AppMethodBeat.i(359961);
    kotlin.g.b.s.u(parama, "callback");
    n localn = CGW;
    kotlin.g.b.s.u(parama, "callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new n.e(localn, parama));
    AppMethodBeat.o(359961);
  }
  
  public static void resumeLive(int paramInt)
  {
    AppMethodBeat.i(360146);
    ap localap = CzZ;
    if (localap != null) {
      localap.a(2, paramInt, (al.a)new v());
    }
    AppMethodBeat.o(360146);
  }
  
  public static void resumeVisitorLive()
  {
    AppMethodBeat.i(360000);
    Object localObject = nkg;
    if ((localObject instanceof com.tencent.mm.live.core.core.f.d)) {}
    for (localObject = (com.tencent.mm.live.core.core.f.d)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.f.d)localObject).mUn;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.d)localObject).bcl();
        }
      }
      AppMethodBeat.o(360000);
      return;
    }
  }
  
  public static void setCustomResolution(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(360139);
    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTu = paramInt1;
    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTv = paramInt2;
    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTf = paramBoolean;
    com.tencent.mm.live.core.core.trtc.a locala = nkg;
    if (locala != null) {
      locala.bfa();
    }
    AppMethodBeat.o(360139);
  }
  
  public static void setTopic(String paramString, b.f paramf)
  {
    AppMethodBeat.i(360204);
    kotlin.g.b.s.u(paramString, "topic");
    kotlin.g.b.s.u(paramf, "callback");
    n.a(CzZ, CDN, paramString, paramf);
    AppMethodBeat.o(360204);
  }
  
  public static void setVoiceCaptureVolume(int paramInt)
  {
    AppMethodBeat.i(360153);
    Object localObject = nkg;
    if (localObject != null)
    {
      Log.i("MicroMsg.LiveCore", kotlin.g.b.s.X("setVoiceCaptureVolume volume:", Integer.valueOf(paramInt)));
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).beO().getAudioEffectManager();
      if (localObject != null) {
        ((TXAudioEffectManager)localObject).setVoiceCaptureVolume(paramInt);
      }
    }
    AppMethodBeat.o(360153);
  }
  
  public static void startLocalAudio(boolean paramBoolean)
  {
    AppMethodBeat.i(360106);
    com.tencent.mm.live.core.core.trtc.a locala = nkg;
    if (locala != null) {
      locala.startLocalAudio(paramBoolean);
    }
    AppMethodBeat.o(360106);
  }
  
  public static void unregisterExternalLiveCallback(com.tencent.d.a.a.a.a parama)
  {
    AppMethodBeat.i(359968);
    kotlin.g.b.s.u(parama, "callback");
    n localn = CGW;
    kotlin.g.b.s.u(parama, "callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new n.g(localn, parama));
    AppMethodBeat.o(359968);
  }
  
  public static void v(LinkedList<edv> paramLinkedList)
  {
    AppMethodBeat.i(359874);
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        edv localedv = (edv)paramLinkedList.next();
        Log.i("Finder.FinderLiveService", "[Battle] player:[" + localedv.YIZ + ", " + localedv.abiU + ']');
      }
    }
    AppMethodBeat.o(359874);
  }
  
  public final void a(at paramat, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    AppMethodBeat.i(360359);
    kotlin.g.b.s.u(paramat, "musicItem");
    Log.i("Finder.FinderLiveService", "playMusic " + paramat + ", forcePlay:" + paramBoolean + ", stack:" + Util.getStack());
    String str = paramat.CIu.ZTB;
    int j = paramat.CIu.ZTv;
    if (paramat.CIu.playable)
    {
      localObject2 = (CharSequence)str;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label126;
      }
    }
    label126:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(360359);
      return;
    }
    Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if (localObject2 == null)
    {
      paramat = null;
      if (paramat == null) {
        Log.e("Finder.FinderLiveService", "playMusic error curLiveRoomData is null!");
      }
      AppMethodBeat.o(360359);
      return;
    }
    com.tencent.mm.live.core.core.a.b localb = elM();
    if (localb == null) {}
    for (;;)
    {
      if ((paramBoolean) || (!kotlin.g.b.s.p(localObject1, Boolean.TRUE)))
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).Eee;
        if (localObject1 != null) {
          ((c)localObject1).c(paramat, paramInt);
        }
        paramat = elM();
        if (paramat != null) {
          com.tencent.mm.live.core.core.b.a.a((com.tencent.mm.live.core.core.b)paramat, j, str, (TXAudioEffectManager.TXMusicPlayObserver)this);
        }
      }
      paramat = ah.aiuX;
      break;
      localObject1 = Boolean.valueOf(localb.mRI);
    }
  }
  
  public final void callback(int paramInt, Bundle arg2)
  {
    ??? = null;
    AppMethodBeat.i(360352);
    ??? = CDO;
    if (??? != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)???).onLiveEventCallback(paramInt, ???);
    }
    if (hKC)
    {
      Object localObject4 = CGW;
      ??? = nkg;
      Object localObject5;
      if (??? == null)
      {
        ??? = null;
        localObject5 = nkg;
        e.g localg = e.g.mKv;
        if (paramInt != e.g.bcZ()) {
          break label340;
        }
        if (??? != null) {
          break label227;
        }
        ??? = (Bundle)???;
      }
      for (;;)
      {
        if (??? == null) {
          break label449;
        }
        ??? = ((n)localObject4).CFv;
        kotlin.g.b.s.s(???, "externalLiveCallbacks");
        synchronized ((Iterable)???)
        {
          ??? = ((Iterable)???).iterator();
          if (!((Iterator)???).hasNext()) {
            break label326;
          }
          localObject4 = (com.tencent.d.a.a.a.a)((Iterator)???).next();
          Log.i(n.TAG, "onLiveVoiceVolume user:" + ???.userId + " volume:" + ???.volume);
          ((com.tencent.d.a.a.a.a)localObject4).XY(???.volume);
        }
        ??? = ((com.tencent.mm.live.core.core.trtc.a)???).mRB;
        if (??? == null)
        {
          ??? = null;
          break;
        }
        ??? = ((com.tencent.mm.live.core.core.model.i)???).mNM;
        break;
        label227:
        localObject5 = ???.getParcelableArrayList("live_user_volume_info");
        ??? = (Bundle)???;
        if (localObject5 != null) {
          synchronized ((Iterable)localObject5)
          {
            localObject5 = ((Iterable)???).iterator();
            for (;;)
            {
              if (((Iterator)localObject5).hasNext())
              {
                ??? = ((Iterator)localObject5).next();
                boolean bool = Util.isEqual(((UserVolumeInfo)???).userId, (String)???);
                if (bool)
                {
                  ??? = (UserVolumeInfo)???;
                  break;
                }
              }
            }
            ??? = null;
          }
        }
      }
      label326:
      ??? = ah.aiuX;
      AppMethodBeat.o(360352);
      return;
      label340:
      ??? = e.g.mKv;
      if ((paramInt == e.g.bcK()) && (localObject5 != null))
      {
        ??? = ((n)localObject4).CFv;
        kotlin.g.b.s.s(???, "externalLiveCallbacks");
        synchronized ((Iterable)???)
        {
          ??? = ???.iterator();
          if (((Iterator)???).hasNext()) {
            ((com.tencent.d.a.a.a.a)((Iterator)???).next()).jk(((com.tencent.mm.live.core.core.trtc.a)localObject5).mRL, ((n)localObject4).CFx);
          }
        }
        ah localah = ah.aiuX;
        AppMethodBeat.o(360352);
        return;
      }
    }
    label449:
    AppMethodBeat.o(360352);
  }
  
  public final void onComplete(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(360366);
    qF(true);
    AppMethodBeat.o(360366);
  }
  
  public final void onPlayProgress(int paramInt, long paramLong1, long paramLong2) {}
  
  public final void onStart(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(360381);
    Object localObject1 = CDO;
    Object localObject2 = CDN;
    if ((localObject1 != null) && (localObject2 != null)) {
      if (paramInt2 != 0)
      {
        if (NetStatusUtil.isConnected(MMApplicationContext.getContext()))
        {
          localObject2 = nkg;
          if (localObject2 == null) {
            break label279;
          }
          localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mRB;
          if (localObject2 == null) {
            break label279;
          }
          paramInt2 = ((com.tencent.mm.live.core.core.model.i)localObject2).mNT;
          localObject2 = e.o.mLz;
          if (paramInt2 != e.o.bdE()) {
            break label279;
          }
          paramInt2 = 1;
          if (paramInt2 == 0)
          {
            localObject2 = nkg;
            if (localObject2 == null) {
              break label284;
            }
            localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mRB;
            if (localObject2 == null) {
              break label284;
            }
            paramInt2 = ((com.tencent.mm.live.core.core.model.i)localObject2).mNT;
            localObject2 = e.o.mLz;
            if (paramInt2 != e.o.bdF()) {
              break label284;
            }
            paramInt2 = i;
            label129:
            if (paramInt2 == 0) {
              break label289;
            }
          }
        }
        localObject2 = CDO;
        if (localObject2 != null)
        {
          localObject2 = (com.tencent.mm.plugin.finder.live.plugin.u)((com.tencent.mm.plugin.finder.live.view.a)localObject2).getPlugin(com.tencent.mm.plugin.finder.live.plugin.u.class);
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.live.plugin.u)localObject2).CwN;
            if (localObject2 != null) {
              ((j.a)localObject2).OB(paramInt1);
            }
          }
        }
        Log.i("Finder.FinderLiveService", "onStart:" + paramInt1 + " error,but network error!");
        label210:
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new o((com.tencent.mm.plugin.finder.live.view.a)localObject1));
      }
    }
    for (localObject1 = ah.aiuX;; localObject1 = null)
    {
      if (localObject1 == null) {
        Log.e("Finder.FinderLiveService", "onStart error curLiveLayout:" + CDO + ",curLiveRoomData:" + CDN);
      }
      AppMethodBeat.o(360381);
      return;
      label279:
      paramInt2 = 0;
      break;
      label284:
      paramInt2 = 0;
      break label129;
      label289:
      qF(false);
      break label210;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$BattleDismissTask;", "Ljava/lang/Runnable;", "battleId", "", "(Ljava/lang/String;)V", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Runnable
  {
    private String CES;
    
    public a(String paramString)
    {
      this.CES = paramString;
    }
    
    public final void run()
    {
      AppMethodBeat.i(360025);
      String str = this.CES;
      Object localObject = aj.CGT;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject == null) {
        localObject = null;
      }
      for (;;)
      {
        if (Util.isEqual(str, (String)localObject))
        {
          localObject = p.mZf;
          localObject = p.bhS();
          if (localObject != null) {
            ((com.tencent.mm.live.model.g)localObject).onBattleDismiss();
          }
          localObject = aj.CGT;
          localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject).EfK = null;
          }
        }
        AppMethodBeat.o(360025);
        return;
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject).EfK;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((i)localObject).CES;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$BattleStartTask;", "Ljava/lang/Runnable;", "battleId", "", "(Ljava/lang/String;)V", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    private String CES;
    
    public b(String paramString)
    {
      AppMethodBeat.i(359790);
      this.CES = paramString;
      AppMethodBeat.o(359790);
    }
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(359806);
      Object localObject3 = new StringBuilder("bindBattleId:").append(this.CES).append(", curBattle:");
      Object localObject1 = aj.CGT;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      label156:
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", liveStart:");
        localObject1 = aj.CGT;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject1 != null) {
          break label263;
        }
        localObject1 = null;
        label81:
        Log.i("Finder.FinderLiveService", localObject1);
        localObject3 = this.CES;
        localObject1 = aj.CGT;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        if (localObject1 != null) {
          break label274;
        }
        localObject1 = localObject2;
        label120:
        if (kotlin.g.b.s.p(localObject3, localObject1))
        {
          localObject1 = aj.CGT;
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted() != true)) {
            break label296;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = aj.CGT;
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
            if (localObject1 == null) {
              break label301;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).EfK;
            if ((localObject1 == null) || (((i)localObject1).ekB() != true)) {
              break label301;
            }
          }
        }
      }
      label263:
      label274:
      label296:
      label301:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject1 = aj.CGT;
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).EfK;
            if (localObject1 != null) {
              ((i)localObject1).CEW = 2;
            }
          }
          localObject1 = p.mZf;
          localObject1 = p.bhS();
          if (localObject1 != null) {
            ((com.tencent.mm.live.model.g)localObject1).onBattleStart();
          }
        }
        AppMethodBeat.o(359806);
        return;
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).EfK;
        break;
        localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).isLiveStarted());
        break label81;
        i locali = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).EfK;
        localObject1 = localObject2;
        if (locali == null) {
          break label120;
        }
        localObject1 = locali.CES;
        break label120;
        i = 0;
        break label156;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$HeartBeatGuardTask;", "Ljava/lang/Runnable;", "bindLiveId", "", "(J)V", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Runnable
  {
    private long CHx;
    
    public c(long paramLong)
    {
      this.CHx = paramLong;
    }
    
    public final void run()
    {
      Object localObject1 = null;
      AppMethodBeat.i(359808);
      Object localObject2 = aj.CGT;
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      long l;
      int i;
      label72:
      Object localObject3;
      if (localObject2 == null)
      {
        l = 0L;
        localObject2 = aj.CGT;
        if (aj.elr() != null)
        {
          localObject2 = aj.CGT;
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).eyA() != true)) {
            break label204;
          }
          i = 1;
          if ((i == 0) && (l == this.CHx)) {
            break label222;
          }
        }
        localObject2 = new StringBuilder("heartBeat manual recovery skipped. curLiveRoomData:");
        localObject3 = aj.CGT;
        localObject2 = ((StringBuilder)localObject2).append(aj.elr()).append(" business(LiveCommonSlice::class.java)?.isLiveFinish():");
        localObject3 = aj.CGT;
        localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject3 != null) {
          break label209;
        }
      }
      for (;;)
      {
        Log.i("Finder.FinderLiveService", localObject1 + " liveId:" + l + " bindLiveId:" + this.CHx);
        AppMethodBeat.o(359808);
        return;
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).liveInfo;
        if (localObject2 == null)
        {
          l = 0L;
          break;
        }
        l = ((bip)localObject2).liveId;
        break;
        label204:
        i = 0;
        break label72;
        label209:
        localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject3).eyA());
      }
      label222:
      Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("heartBeat manual recovery liveId:", Long.valueOf(l)));
      com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "liveHeartBeatBreak_manualRecovery", false, null, false, (kotlin.g.a.a)new a(l), 28);
      localObject1 = aj.CGT;
      aj.ap(0L, l);
      AppMethodBeat.o(359808);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<String>
    {
      a(long paramLong)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveService$KeepAliveGuardTask;", "Ljava/lang/Runnable;", "bindLiveId", "", "(J)V", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Runnable
  {
    private long CHx;
    
    public d(long paramLong)
    {
      this.CHx = paramLong;
    }
    
    public final void run()
    {
      Object localObject1 = null;
      AppMethodBeat.i(359803);
      Object localObject2 = aj.CGT;
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      long l;
      int i;
      label72:
      Object localObject3;
      if (localObject2 == null)
      {
        l = 0L;
        localObject2 = aj.CGT;
        if (aj.elr() != null)
        {
          localObject2 = aj.CGT;
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).eyA() != true)) {
            break label204;
          }
          i = 1;
          if ((i == 0) && (l == this.CHx)) {
            break label222;
          }
        }
        localObject2 = new StringBuilder("keepAlive manual recovery skipped. curLiveRoomData:");
        localObject3 = aj.CGT;
        localObject2 = ((StringBuilder)localObject2).append(aj.elr()).append(" business(LiveCommonSlice::class.java)?.isLiveFinish():");
        localObject3 = aj.CGT;
        localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject3 != null) {
          break label209;
        }
      }
      for (;;)
      {
        Log.i("Finder.FinderLiveService", localObject1 + " liveId:" + l + " bindLiveId:" + this.CHx);
        AppMethodBeat.o(359803);
        return;
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).liveInfo;
        if (localObject2 == null)
        {
          l = 0L;
          break;
        }
        l = ((bip)localObject2).liveId;
        break;
        label204:
        i = 0;
        break label72;
        label209:
        localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject3).eyA());
      }
      label222:
      Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("keepAlive manual recovery liveId:", Long.valueOf(l)));
      com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "liveKeepAliveBreak_manualRecovery", false, null, false, (kotlin.g.a.a)new a(l), 28);
      localObject1 = aj.CGT;
      aj.of(0L);
      AppMethodBeat.o(359803);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<String>
    {
      a(long paramLong)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(boolean paramBoolean, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$doActivateMic$1$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderActivateLiveMicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.plugin.finder.live.model.cgi.c.a
  {
    public final void a(atf paramatf)
    {
      AppMethodBeat.i(359811);
      kotlin.g.b.s.u(paramatf, "resp");
      paramatf = aj.ema();
      if (paramatf == null) {}
      for (boolean bool = true;; bool = paramatf.hcg)
      {
        Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("doActivateMic onCgiBack taskFinished:", Boolean.valueOf(bool)));
        if (!bool)
        {
          paramatf = aj.ema();
          if (paramatf != null) {
            paramatf.emA();
          }
          paramatf = aj.CGT;
          aj.oe(20000L);
        }
        AppMethodBeat.o(359811);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$doGetLiveMsg$1$2", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "reqVisitorRoleType", "uniqueId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements com.tencent.d.a.a.a.c.a.b
  {
    i(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f paramf) {}
    
    public final void a(int paramInt1, int paramInt2, azp paramazp, int paramInt3, String paramString)
    {
      AppMethodBeat.i(359816);
      kotlin.g.b.s.u(paramazp, "resp");
      Object localObject = aj.CGT;
      if (aj.elw())
      {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CHz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp != null) {}
        for (int i = 1; i == 0; i = 0)
        {
          Log.i("Finder.FinderLiveService", "handleLiveMsgResp result false, liveCookies is empty!");
          AppMethodBeat.o(359816);
          return;
        }
      }
      localObject = aj.CGT;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)localObject).Efd = paramazp.ZJN;
      }
      localObject = ar.CIh;
      ar.emh();
      localObject = aj.CGT;
      boolean bool2 = aj.b(paramInt2, paramInt1, paramazp, paramInt3, paramString);
      localObject = aj.elW();
      boolean bool1;
      label157:
      label182:
      long l1;
      if ((localObject != null) && (((ax)localObject).hcg == true))
      {
        paramInt1 = 1;
        if (paramInt1 != 0) {
          break label235;
        }
        bool1 = true;
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)a.CHA);
        if (paramazp.ZJY <= 0) {
          break label241;
        }
        paramInt1 = paramazp.ZJY * 1000;
        if (!bool2) {
          break label283;
        }
        paramString = aj.CGT;
        l2 = paramInt1;
        paramazp = paramazp.liveInfo;
        if (paramazp != null) {
          break label274;
        }
        l1 = 0L;
        label208:
        aj.ap(l2, l1);
      }
      label235:
      label241:
      do
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)b.CHB);
        AppMethodBeat.o(359816);
        return;
        paramInt1 = 0;
        break;
        bool1 = false;
        break label157;
        if (bool2)
        {
          localObject = com.tencent.d.a.a.a.a.a.ahiX;
          paramInt1 = ((Number)com.tencent.d.a.a.a.a.a.jTJ().bmg()).intValue();
          break label182;
        }
        paramInt1 = 5000;
        break label182;
        l1 = paramazp.liveId;
        break label208;
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CHz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA()) {
          break label478;
        }
        localObject = new StringBuilder("handleLiveMsgResp result false, will retry heartbeat delay:").append(paramInt1).append(". localLiveId:");
        paramazp = aj.CGT;
        paramazp = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (paramazp != null) {
          break label429;
        }
        paramazp = null;
        Log.i("Finder.FinderLiveService", paramazp + ", haveHeartTaskRunning:" + bool1);
        paramazp = aj.CGT;
        if (!aj.elw()) {
          break label391;
        }
        paramazp = aj.CGT;
      } while ((aj.awA(paramString)) && (bool1));
      label274:
      label283:
      label340:
      paramazp = aj.CGT;
      label391:
      long l2 = paramInt1;
      paramazp = aj.CGT;
      paramazp = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (paramazp == null) {
        l1 = 0L;
      }
      for (;;)
      {
        aj.ap(l2, l1);
        break;
        label429:
        paramazp = paramazp.liveInfo;
        if (paramazp == null)
        {
          paramazp = null;
          break label340;
        }
        paramazp = Long.valueOf(paramazp.liveId);
        break label340;
        paramazp = paramazp.liveInfo;
        if (paramazp == null) {
          l1 = 0L;
        } else {
          l1 = paramazp.liveId;
        }
      }
      label478:
      paramazp = aj.CGT;
      paramazp = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (paramazp == null) {
        paramazp = null;
      }
      for (;;)
      {
        Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("handleLiveMsgResp result false and live is finished. localLiveId:", paramazp));
        break;
        paramazp = paramazp.liveInfo;
        if (paramazp == null) {
          paramazp = null;
        } else {
          paramazp = Long.valueOf(paramazp.liveId);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      public static final a CHA;
      
      static
      {
        AppMethodBeat.i(360028);
        CHA = new a();
        AppMethodBeat.o(360028);
      }
      
      a()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      public static final b CHB;
      
      static
      {
        AppMethodBeat.i(360026);
        CHB = new b();
        AppMethodBeat.o(360026);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    j(long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$doRefreshMic$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.plugin.finder.live.model.cgi.ap.a
  {
    k(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f paramf) {}
    
    public final void b(int paramInt1, int paramInt2, blw paramblw)
    {
      AppMethodBeat.i(359834);
      kotlin.g.b.s.u(paramblw, "resp");
      boolean bool = aj.a(aj.CGT, paramInt2, paramInt1, paramblw);
      paramblw = aj.elZ();
      if (paramblw != null) {
        paramblw.emA();
      }
      if (bool)
      {
        long l = kotlin.k.k.bR((this.CHz.mZr.aaOy - 60L) * 1000L, 60000L);
        paramblw = aj.CGT;
        aj.od(l);
      }
      AppMethodBeat.o(359834);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    m(long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$liveStart$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements com.tencent.mm.model.d.a
  {
    public final void bAi()
    {
      AppMethodBeat.i(359817);
      Log.i("Finder.FinderLiveService", "AudioFocus gain");
      Object localObject = aj.CGT;
      localObject = aj.getLiveCore();
      if ((localObject instanceof com.tencent.mm.live.core.core.f.d)) {}
      for (localObject = (com.tencent.mm.live.core.core.f.d)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.f.d)localObject).setMute(false);
        }
        AppMethodBeat.o(359817);
        return;
      }
    }
    
    public final void bAj()
    {
      boolean bool = false;
      AppMethodBeat.i(359831);
      Object localObject1 = AppForegroundDelegate.aCe();
      label35:
      label50:
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = aj.CGT;
        localObject2 = aj.elk();
        if (localObject2 != null) {
          break label234;
        }
        localObject2 = null;
        if (!(localObject2 instanceof Activity)) {
          break label244;
        }
        localObject2 = (Activity)localObject2;
        if ((localObject2 == null) || (((Activity)localObject2).isDestroyed() != true)) {
          break label250;
        }
        i = 1;
        label66:
        if (i == 0)
        {
          localObject2 = aj.CGT;
          localObject2 = aj.elk();
          if (localObject2 != null) {
            break label255;
          }
          localObject2 = null;
          label88:
          if (!(localObject2 instanceof Activity)) {
            break label265;
          }
          localObject2 = (Activity)localObject2;
          label103:
          if ((localObject2 == null) || (((Activity)localObject2).isFinishing() != true)) {
            break label271;
          }
          i = 1;
          label119:
          if (i == 0) {}
        }
        else
        {
          bool = true;
        }
        if ((localObject1 != null) && (!(localObject1 instanceof MMFinderUI)) && (bool))
        {
          localObject2 = aj.CGT;
          localObject2 = aj.getLiveCore();
          if (!(localObject2 instanceof com.tencent.mm.live.core.core.f.d)) {
            break label276;
          }
        }
      }
      label265:
      label271:
      label276:
      for (Object localObject2 = (com.tencent.mm.live.core.core.f.d)localObject2;; localObject2 = null)
      {
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.live.core.core.f.d)localObject2).mUn;
          if (localObject2 != null) {
            ((com.tencent.mm.live.core.core.d)localObject2).bcp();
          }
        }
        Log.i("Finder.FinderLiveService", "AudioFocus lossTransient topActivity:" + localObject1 + " curActivityDestroy:" + bool);
        AppMethodBeat.o(359831);
        return;
        localObject1 = (Activity)((WeakReference)localObject1).get();
        break;
        label234:
        localObject2 = ((com.tencent.mm.plugin.finder.live.view.a)localObject2).getContext();
        break label35;
        label244:
        localObject2 = null;
        break label50;
        label250:
        i = 0;
        break label66;
        label255:
        localObject2 = ((com.tencent.mm.plugin.finder.live.view.a)localObject2).getContext();
        break label88;
        localObject2 = null;
        break label103;
        i = 0;
        break label119;
      }
    }
    
    public final void bAk()
    {
      boolean bool = false;
      AppMethodBeat.i(359827);
      Object localObject1 = AppForegroundDelegate.aCe();
      label35:
      label50:
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = aj.CGT;
        localObject2 = aj.elk();
        if (localObject2 != null) {
          break label234;
        }
        localObject2 = null;
        if (!(localObject2 instanceof Activity)) {
          break label244;
        }
        localObject2 = (Activity)localObject2;
        if ((localObject2 == null) || (((Activity)localObject2).isDestroyed() != true)) {
          break label250;
        }
        i = 1;
        label66:
        if (i == 0)
        {
          localObject2 = aj.CGT;
          localObject2 = aj.elk();
          if (localObject2 != null) {
            break label255;
          }
          localObject2 = null;
          label88:
          if (!(localObject2 instanceof Activity)) {
            break label265;
          }
          localObject2 = (Activity)localObject2;
          label103:
          if ((localObject2 == null) || (((Activity)localObject2).isFinishing() != true)) {
            break label271;
          }
          i = 1;
          label119:
          if (i == 0) {}
        }
        else
        {
          bool = true;
        }
        if ((localObject1 != null) && (!(localObject1 instanceof MMFinderUI)) && (bool))
        {
          localObject2 = aj.CGT;
          localObject2 = aj.getLiveCore();
          if (!(localObject2 instanceof com.tencent.mm.live.core.core.f.d)) {
            break label276;
          }
        }
      }
      label265:
      label271:
      label276:
      for (Object localObject2 = (com.tencent.mm.live.core.core.f.d)localObject2;; localObject2 = null)
      {
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.live.core.core.f.d)localObject2).mUn;
          if (localObject2 != null) {
            ((com.tencent.mm.live.core.core.d)localObject2).bcp();
          }
        }
        Log.i("Finder.FinderLiveService", "AudioFocus lossTransient topActivity:" + localObject1 + " curActivityDestroy:" + bool);
        AppMethodBeat.o(359827);
        return;
        localObject1 = (Activity)((WeakReference)localObject1).get();
        break;
        label234:
        localObject2 = ((com.tencent.mm.plugin.finder.live.view.a)localObject2).getContext();
        break label35;
        label244:
        localObject2 = null;
        break label50;
        label250:
        i = 0;
        break label66;
        label255:
        localObject2 = ((com.tencent.mm.plugin.finder.live.view.a)localObject2).getContext();
        break label88;
        localObject2 = null;
        break label103;
        i = 0;
        break label119;
      }
    }
    
    public final void bAl()
    {
      AppMethodBeat.i(359839);
      Log.i("Finder.FinderLiveService", "AudioFocus lossTransientCanDuck");
      AppMethodBeat.o(359839);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    o(com.tencent.mm.plugin.finder.live.view.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$pauseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements al.a
  {
    public final void a(int paramInt1, int paramInt2, bse parambse)
    {
      AppMethodBeat.i(359853);
      kotlin.g.b.s.u(parambse, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        parambse = aj.CGT;
        parambse = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (parambse != null)
        {
          bix localbix = new bix();
          localbix.show_type = 2;
          localbix.ZSF = 0;
          ah localah = ah.aiuX;
          parambse.a(localbix, false, (kotlin.g.a.m)a.CHD);
        }
      }
      AppMethodBeat.o(359853);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "lastPauseTime", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.m<Boolean, Integer, ah>
    {
      public static final a CHD;
      
      static
      {
        AppMethodBeat.i(359483);
        CHD = new a();
        AppMethodBeat.o(359483);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class q
    extends PhoneStateListener
  {
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(359838);
      kotlin.g.b.s.u(paramString, "incomingNumber");
      Object localObject = aj.CGT;
      localObject = aj.elk();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.a)localObject).onCallStateChanged(paramInt, paramString);
      }
      AppMethodBeat.o(359838);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    u(boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$resumeLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class v
    implements al.a
  {
    public final void a(int paramInt1, int paramInt2, bse parambse)
    {
      AppMethodBeat.i(359748);
      kotlin.g.b.s.u(parambse, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        parambse = aj.CGT;
        parambse = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (parambse != null)
        {
          bix localbix = new bix();
          localbix.show_type = 0;
          localbix.ZSF = 0;
          ah localah = ah.aiuX;
          parambse.a(localbix, false, (kotlin.g.a.m)a.CHG);
        }
      }
      AppMethodBeat.o(359748);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.m<Boolean, Integer, ah>
    {
      public static final a CHG;
      
      static
      {
        AppMethodBeat.i(359780);
        CHG = new a();
        AppMethodBeat.o(359780);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "toUsers", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.b<List<? extends String>, ah>
  {
    public w(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$showMiniWindow$2", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class x
    implements RequestFloatWindowPermissionDialog.a
  {
    x(Context paramContext) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      boolean bool2 = true;
      AppMethodBeat.i(359773);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      Object localObject1 = this.$context;
      Object localObject2 = aj.CGT;
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).EcJ == true))
      {
        bool1 = true;
        paramRequestFloatWindowPermissionDialog.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", bool1);
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 3);
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
        localObject2 = aj.CGT;
        aj.b(paramRequestFloatWindowPermissionDialog, (Context)localObject1);
        localObject1 = aj.CGT;
        localObject1 = aj.elr();
        if (localObject1 != null)
        {
          localObject2 = aj.CGT;
          localObject2 = aj.CGT;
          if (aj.elM() == null) {
            break label165;
          }
        }
      }
      label165:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        aj.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, bool1, b.c.ncx, paramRequestFloatWindowPermissionDialog, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
        AppMethodBeat.o(359773);
        return;
        bool1 = false;
        break;
      }
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(359782);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      Object localObject = aj.CGT;
      localObject = aj.elr();
      if (localObject != null)
      {
        aj localaj = aj.CGT;
        localaj = aj.CGT;
        if (aj.elM() == null) {
          break label83;
        }
      }
      label83:
      for (boolean bool = true;; bool = false)
      {
        aj.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject, bool, b.c.ncA, paramRequestFloatWindowPermissionDialog, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
        AppMethodBeat.o(359782);
        return;
      }
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(359792);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog = new Bundle();
      Object localObject = aj.CGT;
      localObject = aj.elr();
      if (localObject != null)
      {
        aj localaj = aj.CGT;
        localaj = aj.CGT;
        if (aj.elM() == null) {
          break label79;
        }
      }
      label79:
      for (boolean bool = true;; bool = false)
      {
        aj.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject, bool, b.c.ncC, paramRequestFloatWindowPermissionDialog, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
        AppMethodBeat.o(359792);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$startChargeLiveCountDown$1", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager$Callback;", "updateTimer", "", "freeTomeToWatch", "", "totalFreeTimeToWatch", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class y
    implements com.tencent.mm.plugin.finder.replay.a.a
  {
    public final void hG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(359772);
      Object localObject = aj.CGT;
      localObject = aj.elk();
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.finder.live.plugin.ag)((com.tencent.mm.plugin.finder.live.view.a)localObject).getPlugin(com.tencent.mm.plugin.finder.live.plugin.ag.class);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.ag)localObject).hG(paramInt1, paramInt2);
        }
      }
      localObject = aj.CGT;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class);
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)localObject).eyl() == true))
      {
        paramInt2 = 1;
        if (paramInt2 != 0) {
          if (paramInt1 <= 0)
          {
            FinderLiveMiniView localFinderLiveMiniView = aj.elY().DVz;
            if (localFinderLiveMiniView != null)
            {
              localObject = aj.CGT;
              localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
              if (localObject != null) {
                break label215;
              }
              localObject = null;
              label104:
              localFinderLiveMiniView.setBgCoverUrl((String)localObject);
              localFinderLiveMiniView.te(8);
            }
            localObject = aj.CGT;
            localObject = aj.getLiveCore();
            if (!(localObject instanceof com.tencent.mm.live.core.core.f.d)) {
              break label223;
            }
          }
        }
      }
      label215:
      label223:
      for (localObject = (com.tencent.mm.live.core.core.f.d)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.f.d)localObject).fO(true);
        }
        localObject = aj.CGT;
        localObject = aj.elk();
        if (localObject != null)
        {
          localObject = (cg)((com.tencent.mm.plugin.finder.live.view.a)localObject).getPlugin(cg.class);
          if (localObject != null) {
            ((cg)localObject).tO(8);
          }
        }
        localObject = aj.CGT;
        localObject = aj.elk();
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.live.view.a)localObject).getWarnningCountWidget();
          if (localObject != null) {
            ((bm)localObject).Qr(paramInt1);
          }
        }
        AppMethodBeat.o(359772);
        return;
        paramInt2 = 0;
        break;
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).eyo();
        break label104;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final z CHH;
    
    static
    {
      AppMethodBeat.i(359769);
      CHH = new z();
      AppMethodBeat.o(359769);
    }
    
    z()
    {
      super();
    }
    
    private static final void emb()
    {
      AppMethodBeat.i(359765);
      Object localObject = aj.CGT;
      localObject = aj.getLiveCore();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
        AppMethodBeat.o(359765);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.live.core.core.a.b)localObject;
      aj localaj = aj.CGT;
      ((com.tencent.mm.live.core.core.a.b)localObject).fE(aj.needMirror());
      AppMethodBeat.o(359765);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.aj
 * JD-Core Version:    0.7.0.1
 */