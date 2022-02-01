package com.tencent.mm.plugin.finder.live;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.text.style.ImageSpan;
import android.util.Base64;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.d.a.a.a.a.b;
import com.tencent.d.a.a.a.b.d;
import com.tencent.d.a.a.a.b.f;
import com.tencent.d.a.a.a.b.b.e.a;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.d.a.b.a.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.model.l.d;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderLivePostPendingUI;
import com.tencent.mm.plugin.finder.live.cgi.y;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.ag;
import com.tencent.mm.plugin.finder.live.model.aj.w;
import com.tencent.mm.plugin.finder.live.model.cgi.ac;
import com.tencent.mm.plugin.finder.live.report.q.bj;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.live.util.ai;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.model.ap.a;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.report.av;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.finder.utils.bl;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.findersdk.a.at;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.protocal.protobuf.fby;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.PluginSupportUIC;
import com.tencent.mm.ui.f.j.a;
import com.tencent.mm.vfs.af;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/PluginFinderLive;", "Lcom/tencent/mm/ui/component/PluginSupportUIC;", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "activityIconStatusCache", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "appForegroundListener", "com/tencent/mm/plugin/finder/live/PluginFinderLive$appForegroundListener$1", "Lcom/tencent/mm/plugin/finder/live/PluginFinderLive$appForegroundListener$1;", "coroutineScopeRunningJob", "", "", "Lkotlinx/coroutines/CoroutineScope;", "findLiveNotifyRejectService", "Lcom/tencent/mm/plugin/finder/live/cgi/oplog/FinderLiveNotifyRejectService;", "finderLiveChargeInfoStorage", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveChargeInfoStorage;", "getFinderLiveChargeInfoStorage", "()Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveChargeInfoStorage;", "finderLiveChargeInfoStorage$delegate", "Lkotlin/Lazy;", "finderLiveDislikeBannerStorage", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveDislikeBannerStorage;", "getFinderLiveDislikeBannerStorage", "()Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveDislikeBannerStorage;", "finderLiveDislikeBannerStorage$delegate", "finderLiveNotifyFuncMsgExtension", "Lcom/tencent/mm/plugin/finder/extension/FinderLiveNotifyFuncMsgExtension;", "finderLiveNotifyRevokeConsumer", "Lcom/tencent/mm/plugin/finder/newxml/FinderLiveNotifyCloseConsumer;", "finderLiveService", "Lcom/tencent/mm/plugin/finder/MMLiveService;", "finderLiveVideoDefinitionStorage", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveVideoDefinitionStorage;", "getFinderLiveVideoDefinitionStorage", "()Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveVideoDefinitionStorage;", "finderLiveVideoDefinitionStorage$delegate", "isFinderLiveActivityIconEntranceEnable", "", "()Z", "isFinderLiveActivityIconSharedEnable", "isNewLiveEntranceEnable", "liveActionRecordStorage", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveActionRecordStorage;", "getLiveActionRecordStorage", "()Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveActionRecordStorage;", "liveActionRecordStorage$delegate", "liveCgiFactoryService", "Lcom/tencent/mm/plugin/finder/live/cgi/LiveCgiFactoryService;", "liveConfigStorage", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveConfigStorage;", "getLiveConfigStorage", "()Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveConfigStorage;", "liveConfigStorage$delegate", "liveGiftStorage", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveGiftStorage;", "getLiveGiftStorage", "()Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveGiftStorage;", "liveGiftStorage$delegate", "liveInfoHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "liveLastRewardInfoStorage", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLastRewardInfoStorage;", "getLiveLastRewardInfoStorage", "()Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLastRewardInfoStorage;", "liveLastRewardInfoStorage$delegate", "liveLuckyMoneyStorage", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLuckyMoneyStorage;", "getLiveLuckyMoneyStorage", "()Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLuckyMoneyStorage;", "liveLuckyMoneyStorage$delegate", "liveNotifyExposureInfoStorage", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveNotifyExposureInfoStorage;", "getLiveNotifyExposureInfoStorage", "()Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveNotifyExposureInfoStorage;", "liveNotifyExposureInfoStorage$delegate", "liveStatusMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoResp;", "localVideoPathForDebug", "", "logoutEvent", "Lcom/tencent/mm/sdk/event/IListener;", "screenStateReceiver", "Lcom/tencent/mm/plugin/finder/live/PluginFinderLive$ScreenStateReceiver;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "autoOpenFinderLive", "", "extInfo", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "failedCallback", "autoOpenFinderLiveWithFeedId", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "autoOpenFinderLiveWithoutFeedId", "backToFinderLiveAnchorUIOnExternalLive", "isFinish", "needRelaunchWeAppOnLiveFinished", "batchGetLiveStatus", "finderObjectList", "", "Landroid/util/Pair;", "callback", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderBatchLiveStatusCallback;", "keeper", "callLiveExperimentalAPI", "jsStr", "cancelCirculationFillingActivityIconOfSourceType", "source", "cgiGetLiveInfo", "liveId", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "checkInsertLiveNewReddot", "checkLastLiveObject", "Lkotlin/Function1;", "circulationFillingActivityIconInner", "feedId", "nonceId", "iconView", "Landroid/widget/ImageView;", "(Landroid/content/Context;JLjava/lang/String;Landroid/widget/ImageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleatLiveStatusCache", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "controlLiveMiniWindowVisibility", "visible", "createFinderLive", "createLuckyMoneyLive", "chatroom", "createLuckyMoneyLiveImpl", "enableAudioVolumeEvaluation", "interval", "enableCustomAudioCapture", "enable", "enableLiveMiniWid", "isEnable", "enableLocalPushStream", "videoPath", "enableMicExternalAudioFrame", "enablePublish", "enablePlayout", "enterFinderGameLiveAuthUI", "intent", "Landroid/content/Intent;", "enterFinderGameLivePostVerifyUI", "appId", "versionType", "ignoreContinueLive", "developerCustomParam", "reportInfo", "enterFinderLiveAnchorUI", "objectId", "desc", "contextId", "sessionBuffer", "redPacketId", "(Landroid/content/Intent;Landroid/content/Context;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "enterFinderLiveCountDownUI", "enterFinderLiveInvitedUI", "username", "nickname", "avatar", "enterFinderLivePostUI", "i", "enterFinderLiveReplayUI", "anchorUserName", "forceCheckTeenMode", "enterFinderLiveTiger", "launchMode", "(Landroid/content/Intent;Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "enterFinderLiveUIByBiz", "feedExportId", "bizUsername", "fromScene", "feedExportIdList", "bizUsernameList", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "enterFinderLiveVisitorUI", "extFlag", "streamUrl", "audienMode", "(Landroid/content/Intent;Landroid/content/Context;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZ)V", "enterLiveTaskPage", "activity", "Landroid/app/Activity;", "sourceScene", "enterPreloadPlayer", "audienceMode", "liveSdkInfoBytes", "", "execute", "executeCirculationFillingActivityIcon", "(Landroid/content/Context;JLjava/lang/String;Landroid/widget/ImageView;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fillAuthIcon", "finderNickname", "Landroid/widget/TextView;", "finderAuthIcon", "Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;", "iconPadding", "", "forceStopCurLive", "gameLiveShare", "businessType", "appid", "isSameAccount", "genContextId", "enter", "enterType", "toCommentScene", "getDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getFinderLiveActionRecordStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveActionRecordStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveChargeInfoStorage;", "getFinderLiveConfigStorage", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveDislikeBannerStorage;", "getFinderLiveExternalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveExternalInfo;", "getFinderLiveGiftStorage", "getFinderLiveLastRewardInfoStorage", "getFinderLiveLuckyMoneyStorage", "getFinderLiveMemberListInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMemberListInfo;", "getFinderLiveNotifyExposureInfoStorage", "getFinderLivePreviewUrl", "encryptedId", "scene", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "url", "errMsg", "errCode", "getFinderLiveStatusFromTag", "liveTag", "Landroid/view/View;", "liveEndTag", "(Landroid/view/View;Landroid/view/View;)Ljava/lang/Integer;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveVideoDefinitionStorage;", "getImageResFromActivityType", "actType", "getLiveInfo", "forceRefresh", "getLiveSettlementInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSettlementInfo;", "getLiveStatus", "status", "getLocalPushStreamPath", "getTopic", "getViewModelStore", "goToAnchorLiveDirect", "finishCallback", "Lkotlin/Function0;", "isFromScan", "gotoLive", "anchorUsername", "fireAuthorInfo", "Lcom/tencent/mm/protocal/protobuf/FinderOlympicLiveFireAuthorInfo;", "reportData", "Lcom/tencent/mm/protocal/protobuf/OlympicsLiveEntranceReportData;", "initOlympicsReport", "isAnchorLiving", "isChargeLive", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "isChatRoomDisable", "groupId", "isGameAnchorLiving", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback$GameLivingStatus;", "isLiveInfoValid", "isLiveTaskEnable", "entrance", "isReplayLive", "isUnPurchasedChargeLive", "isVisitorLiving", "loadMicInfos", "Lkotlin/Function4;", "errType", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "resp", "loadOlympicsImage", "imageView", "resType", "Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$ResType;", "defaultResId", "loadVisitorCore", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mixExternalAudioFrame", "audioBuffer", "sampleRate", "channel", "timestamp", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "openFinderLive", "parseAllBadgeInfos", "Landroid/text/style/ImageSpan;", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "spanFilter", "", "spanMode", "sizeType", "pauseLive", "pauseVisitorLive", "producingReplay", "registerExternalLiveCallback", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "registerScreenReceiver", "reportFinderLiveReplay", "pageType", "reportPlayGamePanelShowAction", "jo", "requestAndRefreshActivityIcon", "Lcom/tencent/mm/plugin/finder/live/PluginFinderLive$RequestAndRefreshActivityIconResult;", "requestFinderLiveNotify", "json", "requestFinderLiveNotifyOnLiveClose", "funcMsgId", "resumeLive", "resumeVisitorLive", "sendExternalLiveAudioData", "sendExternalLiveData", "eglContext", "Landroid/opengl/EGLContext;", "texId", "width", "height", "setCustomResolution", "isVertical", "setFinderLiveTagText", "chargeFlag", "setTopic", "topic", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveSetTopicCallback;", "setVoiceCaptureVolume", "volume", "shareLiveToFriend", "Landroidx/appcompat/app/AppCompatActivity;", "shareLiveToSns", "startLocalAudio", "startPlayGameAnchorSetting", "ck", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveActionCallBack;", "unregisterExternalLiveCallback", "unregisterScreenReceiver", "Companion", "RequestAndRefreshActivityIconResult", "ScreenStateReceiver", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinderLive
  extends PluginSupportUIC
  implements androidx.lifecycle.ak, com.tencent.d.a.a.a.b, com.tencent.mm.kernel.api.c
{
  public static final PluginFinderLive.a BxI;
  private final ConcurrentHashMap<Long, kotlin.u<Integer, Long, azl>> BxJ;
  private MMHandler BxK;
  private final com.tencent.mm.plugin.finder.newxml.a BxL;
  private final com.tencent.mm.plugin.finder.extension.a BxM;
  private final com.tencent.mm.plugin.finder.live.cgi.oplog.a BxN;
  private final y BxO;
  private final com.tencent.mm.plugin.finder.d BxP;
  private c BxQ;
  private String BxR;
  private final d BxS;
  private final kotlin.j BxT;
  private final kotlin.j BxU;
  private final kotlin.j BxV;
  private final kotlin.j BxW;
  private final kotlin.j BxX;
  private final kotlin.j BxY;
  private final kotlin.j BxZ;
  private final kotlin.j Bya;
  private final kotlin.j Byb;
  private final LinkedHashMap<Long, Integer> Byc;
  private final Map<Integer, Set<kotlinx.coroutines.aq>> Byd;
  private final androidx.lifecycle.aj er;
  private final IListener<?> mIj;
  
  static
  {
    AppMethodBeat.i(351943);
    BxI = new PluginFinderLive.a((byte)0);
    AppMethodBeat.o(351943);
  }
  
  public PluginFinderLive()
  {
    AppMethodBeat.i(351269);
    this.er = new androidx.lifecycle.aj();
    this.BxJ = new ConcurrentHashMap();
    this.BxK = new MMHandler("FinderLiveInfoHandler");
    this.BxL = new com.tencent.mm.plugin.finder.newxml.a();
    this.BxM = new com.tencent.mm.plugin.finder.extension.a();
    this.BxN = new com.tencent.mm.plugin.finder.live.cgi.oplog.a();
    this.BxO = new y();
    this.BxP = new com.tencent.mm.plugin.finder.d();
    this.BxS = new d();
    this.BxT = kotlin.k.cm((kotlin.g.a.a)new x(this));
    this.BxU = kotlin.k.cm((kotlin.g.a.a)new z(this));
    this.BxV = kotlin.k.cm((kotlin.g.a.a)new y(this));
    this.BxW = kotlin.k.cm((kotlin.g.a.a)new w(this));
    this.BxX = kotlin.k.cm((kotlin.g.a.a)new aa(this));
    this.BxY = kotlin.k.cm((kotlin.g.a.a)new v(this));
    this.BxZ = kotlin.k.cm((kotlin.g.a.a)new p(this));
    this.Bya = kotlin.k.cm((kotlin.g.a.a)new q(this));
    this.Byb = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.mIj = ((IListener)new PluginFinderLive.logoutEvent.1(com.tencent.mm.app.f.hfK));
    this.Byc = new LinkedHashMap();
    this.Byd = ((Map)new LinkedHashMap());
    AppMethodBeat.o(351269);
  }
  
  private final void autoOpenFinderLiveWithFeedId(FinderObject paramFinderObject, Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(351538);
    Object localObject1 = paramJSONObject.optString("finderUserName");
    if (localObject1 == null) {
      localObject1 = "";
    }
    int k;
    Object localObject4;
    Object localObject5;
    Object localObject2;
    int j;
    int i;
    for (;;)
    {
      k = paramJSONObject.optInt("commentScene");
      localObject4 = paramJSONObject.optString("reportExtraInfo", "");
      localObject5 = paramJSONObject.optString("chnlExtra", "");
      localObject2 = paramJSONObject.optString("byPass", "");
      paramJSONObject = (JSONObject)localObject2;
      if (localObject2 == null) {
        paramJSONObject = "";
      }
      j = 0;
      i = j;
      try
      {
        paramJSONObject = new com.tencent.mm.ad.i(paramJSONObject);
        i = j;
        j = paramJSONObject.optInt("by_pass_type");
        i = j;
        localObject2 = paramJSONObject.optString("by_pass_info");
        paramJSONObject = (JSONObject)localObject2;
        i = j;
        if (localObject2 == null)
        {
          paramJSONObject = "";
          i = j;
        }
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          Log.w("Plugin.FinderLive", kotlin.g.b.s.X("autoOpenFinderLiveWithFeedId ex:", paramJSONObject.getMessage()));
          paramJSONObject = "";
          continue;
          j = 15;
        }
        str = genContextId(k, j, 65);
        com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(str);
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("key_extra_info", (String)localObject4);
        ((Intent)localObject3).putExtra("key_chnl_extra", (String)localObject5);
        ((Intent)localObject3).putExtra("key_enter_live_param_by_pass_type", i);
        ((Intent)localObject3).putExtra("key_enter_live_param_by_pass_info", paramJSONObject);
        paramJSONObject = (ce)com.tencent.mm.plugin.finder.live.report.j.Dob;
        long l3 = paramFinderObject.id;
        localObject2 = paramFinderObject.liveInfo;
        if (localObject2 != null) {
          break label540;
        }
        l1 = -1L;
        localObject2 = paramFinderObject.username;
        localObject4 = paramFinderObject.liveInfo;
        if (localObject4 != null) {
          break label550;
        }
        for (long l2 = -1L;; l2 = ((bip)localObject4).DSe)
        {
          ce.a.a(paramJSONObject, l3, l1, (String)localObject2, -1L, l2, q.w.DwU, String.valueOf(k));
          if (!Util.isEqual((String)localObject1, com.tencent.mm.model.z.bAW())) {
            break label561;
          }
          paramJSONObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
          kotlin.g.b.s.s(paramJSONObject, "service(IActivityRouter::class.java)");
          localObject3 = (com.tencent.mm.plugin.f)paramJSONObject;
          l1 = paramFinderObject.id;
          localObject1 = paramFinderObject.objectNonceId;
          paramJSONObject = (JSONObject)localObject1;
          if (localObject1 == null) {
            paramJSONObject = "";
          }
          localObject2 = paramFinderObject.liveInfo;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new bip();
          }
          com.tencent.mm.plugin.f.a.a((com.tencent.mm.plugin.f)localObject3, paramContext, l1, paramJSONObject, (bip)localObject1, null, null, null, null, str, paramFinderObject.sessionBuffer, null, null, 6640);
          AppMethodBeat.o(351538);
          return;
          l1 = ((bip)localObject2).liveId;
          break;
        }
        localObject4 = new FinderLiveBundle();
        ((FinderLiveBundle)localObject4).CEY = 0;
        ((FinderLiveBundle)localObject4).AJo = k;
        localObject5 = new ArrayList();
        paramJSONObject = paramFinderObject.liveInfo;
        if (paramJSONObject == null) {
          break label953;
        }
      }
      localObject2 = aw.Gjk;
      if (!aw.aBT((String)localObject4)) {
        break;
      }
      j = 4;
      if (paramFinderObject != null) {
        break label285;
      }
      Log.i("Plugin.FinderLive", "true, false");
      paramFinderObject = new Intent();
      paramFinderObject.putExtra("finder_username", (String)localObject1);
      paramFinderObject.putExtra("key_extra_info", (String)localObject4);
      if (k > 0) {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(k, j, 32, paramFinderObject);
      }
      ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).enterFinderProfileUI(paramContext, paramFinderObject);
      AppMethodBeat.o(351538);
      return;
    }
    label285:
    String str;
    Object localObject3;
    long l1;
    label540:
    label550:
    label561:
    label637:
    LiveConfig.a locala;
    if (paramJSONObject.liveStatus == 1)
    {
      j = 1;
      if (j == 0) {
        break label959;
      }
      paramJSONObject = paramFinderObject.liveInfo;
      if (paramJSONObject == null) {
        break label959;
      }
      localObject1 = paramJSONObject.mIE;
      if (localObject1 == null) {
        break label959;
      }
      if (j == 0) {
        break label1001;
      }
      paramJSONObject = paramFinderObject.liveInfo;
      if (paramJSONObject != null) {
        break label967;
      }
      paramJSONObject = null;
      label653:
      if (paramJSONObject != null) {
        break label992;
      }
      paramJSONObject = e.b.mKf;
      i = e.b.bcu();
      label666:
      if (j == 0) {
        break label1007;
      }
      paramJSONObject = paramFinderObject.liveInfo;
      if (paramJSONObject == null) {
        break label1007;
      }
      paramJSONObject = paramJSONObject.ZOg;
      if (paramJSONObject == null) {
        break label1007;
      }
      localObject2 = paramJSONObject.toByteArray();
      label695:
      locala = new LiveConfig.a();
      locala.mIy = LiveConfig.mIt;
      paramJSONObject = paramFinderObject.liveInfo;
      if (paramJSONObject != null) {
        break label1013;
      }
      l1 = 0L;
      label724:
      locala.liveId = l1;
      locala.nonceId = paramFinderObject.objectNonceId;
      locala.mIH = paramFinderObject.id;
      locala.mIC = paramFinderObject.username;
      paramJSONObject = aw.Gjk;
      paramJSONObject = paramFinderObject.objectDesc;
      if (paramJSONObject != null) {
        break label1022;
      }
      paramJSONObject = null;
      label773:
      locala.thumbUrl = aw.e(paramJSONObject);
      paramJSONObject = paramFinderObject.objectDesc;
      if (paramJSONObject != null) {
        break label1050;
      }
      paramJSONObject = null;
      label793:
      locala.desc = paramJSONObject;
      locala.sessionBuffer = paramFinderObject.sessionBuffer;
      locala.mIE = ((String)localObject1);
      locala.mIF = i;
      locala.mIW = ((byte[])localObject2);
      paramJSONObject = paramFinderObject.liveInfo;
      if (paramJSONObject != null) {
        break label1058;
      }
      i = 0;
      label841:
      locala.mIX = i;
      paramJSONObject = bj.GlQ;
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject != null) {
        break label1067;
      }
    }
    label1050:
    label1058:
    label1067:
    for (paramFinderObject = null;; paramFinderObject = paramFinderObject.ZSn)
    {
      bj.a(locala, "autoOpenFinderLiveWithFeedId", paramFinderObject);
      paramFinderObject = ah.aiuX;
      ((ArrayList)localObject5).add(locala.bcd());
      paramFinderObject = ah.aiuX;
      ((FinderLiveBundle)localObject4).ag((ArrayList)localObject5);
      ((FinderLiveBundle)localObject4).CFf = 1;
      ((FinderLiveBundle)localObject4).av((Intent)localObject3);
      paramFinderObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(paramFinderObject, "service(IActivityRouter::class.java)");
      com.tencent.mm.plugin.f.a.a((com.tencent.mm.plugin.f)paramFinderObject, paramContext, (FinderLiveBundle)localObject4, str, str, (Intent)localObject3, false, 32);
      AppMethodBeat.o(351538);
      return;
      label953:
      j = 0;
      break;
      label959:
      localObject1 = "";
      break label637;
      label967:
      paramJSONObject = paramJSONObject.ZRQ;
      if (paramJSONObject == null)
      {
        paramJSONObject = null;
        break label653;
      }
      paramJSONObject = Integer.valueOf(paramJSONObject.mNn);
      break label653;
      label992:
      i = paramJSONObject.intValue();
      break label666;
      label1001:
      i = 0;
      break label666;
      label1007:
      localObject2 = null;
      break label695;
      label1013:
      l1 = paramJSONObject.liveId;
      break label724;
      label1022:
      paramJSONObject = paramJSONObject.media;
      if (paramJSONObject == null)
      {
        paramJSONObject = null;
        break label773;
      }
      paramJSONObject = (FinderMedia)kotlin.a.p.oL((List)paramJSONObject);
      break label773;
      paramJSONObject = paramJSONObject.description;
      break label793;
      i = paramJSONObject.ZSl;
      break label841;
    }
  }
  
  private final void autoOpenFinderLiveWithoutFeedId(FinderObject paramFinderObject, Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(351575);
    Object localObject1 = paramJSONObject.optString("finderUserName");
    if (localObject1 == null) {
      localObject1 = "";
    }
    int m;
    Object localObject4;
    int j;
    int i;
    for (;;)
    {
      m = paramJSONObject.optInt("commentScene");
      localObject4 = paramJSONObject.optString("reportExtraInfo", "");
      localObject3 = paramJSONObject.optString("chnlExtra", "");
      localObject2 = paramJSONObject.optString("byPass", "");
      paramJSONObject = (JSONObject)localObject2;
      if (localObject2 == null) {
        paramJSONObject = "";
      }
      j = 0;
      i = j;
      try
      {
        paramJSONObject = new com.tencent.mm.ad.i(paramJSONObject);
        i = j;
        j = paramJSONObject.optInt("by_pass_type");
        i = j;
        localObject2 = paramJSONObject.optString("by_pass_info");
        paramJSONObject = (JSONObject)localObject2;
        i = j;
        if (localObject2 == null)
        {
          paramJSONObject = "";
          i = j;
        }
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          Log.w("Plugin.FinderLive", kotlin.g.b.s.X("autoOpenFinderLiveWithoutFeedId ex:", paramJSONObject.getMessage()));
          paramJSONObject = "";
          continue;
          j = 15;
          continue;
          int k = 0;
          continue;
          boolean bool = false;
          continue;
          bool = false;
        }
        str1 = genContextId(m, j, 65);
        com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(str1);
        localIntent = new Intent();
        localIntent.putExtra("key_extra_info", (String)localObject4);
        localIntent.putExtra("key_chnl_extra", (String)localObject3);
        localIntent.putExtra("key_enter_live_param_by_pass_type", i);
        localIntent.putExtra("key_enter_live_param_by_pass_info", paramJSONObject);
        paramJSONObject = paramFinderObject.liveInfo;
        if (paramJSONObject != null) {
          break label709;
        }
        i = 0;
        localIntent.putExtra("KEY_ENTER_LIVE_PARAM_VR_LIVE_TYPE", i);
        paramJSONObject = paramFinderObject.liveInfo;
        if (paramJSONObject == null) {
          break label512;
        }
        paramJSONObject = paramJSONObject.ZSn;
        if (paramJSONObject == null) {
          break label512;
        }
        localIntent.putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO", paramJSONObject.toByteArray());
        paramJSONObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
        long l3 = paramFinderObject.id;
        localObject2 = paramFinderObject.liveInfo;
        if (localObject2 != null) {
          break label718;
        }
        l1 = -1L;
        localObject2 = paramFinderObject.username;
        localObject4 = paramFinderObject.liveInfo;
        if (localObject4 != null) {
          break label728;
        }
        for (l2 = -1L;; l2 = ((bip)localObject4).DSe)
        {
          localObject4 = q.w.DwU;
          kotlin.g.b.s.s(localObject3, "chnlExtra");
          paramJSONObject.a(l3, l1, (String)localObject2, -1L, l2, (q.w)localObject4, String.valueOf(m), (String)localObject3);
          if (!Util.isEqual((String)localObject1, com.tencent.mm.model.z.bAW())) {
            break label739;
          }
          paramJSONObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
          kotlin.g.b.s.s(paramJSONObject, "service(IActivityRouter::class.java)");
          localObject3 = (com.tencent.mm.plugin.f)paramJSONObject;
          l1 = paramFinderObject.id;
          localObject1 = paramFinderObject.objectNonceId;
          paramJSONObject = (JSONObject)localObject1;
          if (localObject1 == null) {
            paramJSONObject = "";
          }
          localObject2 = paramFinderObject.liveInfo;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new bip();
          }
          com.tencent.mm.plugin.f.a.a((com.tencent.mm.plugin.f)localObject3, paramContext, l1, paramJSONObject, (bip)localObject1, null, null, null, null, str1, paramFinderObject.sessionBuffer, null, null, 6640);
          AppMethodBeat.o(351575);
          return;
          i = paramJSONObject.ZSl;
          break;
          l1 = ((bip)localObject2).liveId;
          break label538;
        }
        paramJSONObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
        kotlin.g.b.s.s(paramJSONObject, "service(IActivityRouter::class.java)");
        localf = (com.tencent.mm.plugin.f)paramJSONObject;
        l2 = paramFinderObject.id;
        paramJSONObject = paramFinderObject.liveInfo;
        if (paramJSONObject != null) {
          break label924;
        }
      }
      localObject2 = aw.Gjk;
      if (!aw.aBT((String)localObject4)) {
        break;
      }
      j = 4;
      if (paramFinderObject != null)
      {
        localObject2 = paramFinderObject.liveInfo;
        if ((localObject2 == null) || (((bip)localObject2).liveStatus != 2)) {
          break label371;
        }
        k = 1;
        if (k == 0) {
          break label389;
        }
      }
      paramJSONObject = new StringBuilder();
      if (paramFinderObject != null) {
        break label377;
      }
      bool = true;
      paramJSONObject = paramJSONObject.append(bool).append(", ");
      if (paramFinderObject == null) {
        break label383;
      }
      paramFinderObject = paramFinderObject.liveInfo;
      if ((paramFinderObject == null) || (paramFinderObject.liveStatus != 2)) {
        break label383;
      }
      bool = true;
      Log.i("Plugin.FinderLive", bool);
      paramFinderObject = new Intent();
      paramFinderObject.putExtra("finder_username", (String)localObject1);
      paramFinderObject.putExtra("key_extra_info", (String)localObject4);
      if (m > 0) {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(m, j, 32, paramFinderObject);
      }
      ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).enterFinderProfileUI(paramContext, paramFinderObject);
      AppMethodBeat.o(351575);
      return;
    }
    label371:
    label377:
    label383:
    String str1;
    label389:
    Intent localIntent;
    label512:
    label538:
    long l2;
    label709:
    label718:
    label728:
    label739:
    com.tencent.mm.plugin.f localf;
    long l1 = 0L;
    paramJSONObject = paramFinderObject.username;
    Object localObject2 = paramJSONObject;
    if (paramJSONObject == null) {
      localObject2 = "";
    }
    paramJSONObject = paramFinderObject.objectNonceId;
    Object localObject3 = paramJSONObject;
    if (paramJSONObject == null) {
      localObject3 = "";
    }
    paramJSONObject = paramFinderObject.objectDesc;
    label824:
    label838:
    String str2;
    if (paramJSONObject == null)
    {
      paramJSONObject = "";
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null) {
        break label954;
      }
      i = 0;
      str2 = paramFinderObject.sessionBuffer;
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null) {
        break label964;
      }
      localObject4 = null;
      label858:
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null) {
        break label974;
      }
      localObject1 = null;
      label872:
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject != null) {
        break label1005;
      }
      paramFinderObject = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.f.a.a(localf, localIntent, paramContext, l2, l1, (String)localObject2, (String)localObject3, paramJSONObject, str1, i, str2, null, (String)localObject4, (Integer)localObject1, 0, paramFinderObject, false, 41984);
      AppMethodBeat.o(351575);
      return;
      label924:
      l1 = paramJSONObject.liveId;
      break;
      localObject1 = paramJSONObject.description;
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 != null) {
        break label824;
      }
      paramJSONObject = "";
      break label824;
      label954:
      i = ((bip)localObject1).ZRR;
      break label838;
      label964:
      localObject4 = ((bip)localObject1).mIE;
      break label858;
      label974:
      localObject1 = ((bip)localObject1).ZRQ;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label872;
      }
      localObject1 = Integer.valueOf(((bmi)localObject1).mNn);
      break label872;
      label1005:
      paramFinderObject = paramFinderObject.ZOg;
      if (paramFinderObject == null) {
        paramFinderObject = null;
      } else {
        paramFinderObject = paramFinderObject.toByteArray();
      }
    }
  }
  
  private final void cgiGetLiveInfo(long paramLong, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, b.d paramd)
  {
    AppMethodBeat.i(351471);
    paramd = new com.tencent.mm.plugin.finder.live.model.cgi.l(paramLong).bFJ().g(new PluginFinderLive..ExternalSyntheticLambda0(this, paramLong, paramd));
    if (paramb != null) {
      paramd.a(paramb);
    }
    AppMethodBeat.o(351471);
  }
  
  private static final Boolean cgiGetLiveInfo$lambda-3(PluginFinderLive paramPluginFinderLive, long paramLong, b.d paramd, b.a parama)
  {
    AppMethodBeat.i(371148);
    kotlin.g.b.s.u(paramPluginFinderLive, "this$0");
    boolean bool = paramPluginFinderLive.BxK.post(new PluginFinderLive..ExternalSyntheticLambda5(parama, paramPluginFinderLive, paramLong, paramd));
    AppMethodBeat.o(371148);
    return Boolean.valueOf(bool);
  }
  
  private static final void cgiGetLiveInfo$lambda-3$lambda-2(final b.a parama, PluginFinderLive paramPluginFinderLive, final long paramLong, b.d paramd)
  {
    AppMethodBeat.i(371142);
    kotlin.g.b.s.u(paramPluginFinderLive, "this$0");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      bip localbip = ((azl)parama.ott).liveInfo;
      if (localbip == null) {}
      for (int i = 1;; i = localbip.liveStatus)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(paramd, paramLong, i, parama));
        ((Map)paramPluginFinderLive.BxJ).put(Long.valueOf(paramLong), new kotlin.u(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()), parama.ott));
        com.tencent.mm.plugin.findersdk.a.k.Hca = ((azl)parama.ott).refreshInterval;
        AppMethodBeat.o(371142);
        return;
      }
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new PluginFinderLive.ad(paramd, paramLong));
    AppMethodBeat.o(371142);
  }
  
  private final Object circulationFillingActivityIconInner(final Context paramContext, long paramLong, final String paramString, final ImageView paramImageView, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(351634);
    paramContext = kotlinx.coroutines.l.a((kotlin.d.f)bg.kCh(), (kotlin.g.a.m)new j(paramLong, this, paramContext, paramString, paramImageView, null), paramd);
    if (paramContext == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(351634);
      return paramContext;
    }
    paramContext = ah.aiuX;
    AppMethodBeat.o(351634);
    return paramContext;
  }
  
  private static final void cleatLiveStatusCache$lambda-0(long paramLong, PluginFinderLive paramPluginFinderLive)
  {
    AppMethodBeat.i(351667);
    kotlin.g.b.s.u(paramPluginFinderLive, "this$0");
    Log.i("Plugin.FinderLive", "cleatLiveStatusCache liveID:" + paramLong + ",thread:" + Thread.currentThread());
    paramPluginFinderLive.BxJ.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(351667);
  }
  
  private final void createLuckyMoneyLiveImpl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(351615);
    Log.i("Plugin.FinderLive", "createLuckyMoneyLiveImpl");
    Intent localIntent = new Intent();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localIntent.putExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", str);
    if (!(paramContext instanceof Activity)) {}
    for (paramString = localIntent;; paramString = null)
    {
      if (paramString != null) {
        paramString.addFlags(268435456);
      }
      paramString = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(paramString, "service(IFinderCommonService::class.java)");
      h.a.a((com.tencent.mm.plugin.h)paramString, paramContext, localIntent, 0, 124);
      localIntent.setClass(paramContext, FinderLivePostPendingUI.class);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/finder/live/PluginFinderLive", "createLuckyMoneyLiveImpl", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/PluginFinderLive", "createLuckyMoneyLiveImpl", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(351615);
      return;
    }
  }
  
  private static final void enterFinderLiveReplayUI$enterReplayUIImpl(PluginFinderLive paramPluginFinderLive, Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, bip parambip, Intent paramIntent)
  {
    AppMethodBeat.i(351836);
    Object localObject1;
    Object localObject2;
    if (paramPluginFinderLive.isReplayLive(parambip))
    {
      paramPluginFinderLive = paramIntent;
      if (paramIntent == null) {
        paramPluginFinderLive = new Intent();
      }
      paramIntent = ap.ECZ;
      paramIntent = new LinkedList();
      localObject1 = ap.ECZ;
      localObject2 = Long.valueOf(paramLong2);
      kotlin.g.b.s.u(paramString1, "anchorUserName");
      kotlin.g.b.s.u(paramString2, "nonceId");
      localObject1 = new FinderObject();
      if (parambip != null) {
        break label299;
      }
      parambip = new bip();
      if (localObject2 == null)
      {
        paramLong2 = 0L;
        parambip.liveId = paramLong2;
        localObject2 = ah.aiuX;
      }
    }
    label299:
    for (;;)
    {
      ((FinderObject)localObject1).liveInfo = parambip;
      ((FinderObject)localObject1).objectNonceId = paramString2;
      ((FinderObject)localObject1).id = paramLong1;
      ((FinderObject)localObject1).username = paramString1;
      paramString1 = new FinderObjectDesc();
      paramString1.description = paramString3;
      paramString2 = ah.aiuX;
      ((FinderObject)localObject1).objectDesc = paramString1;
      paramIntent.add(new ap((FinderObject)localObject1));
      paramString1 = ah.aiuX;
      paramPluginFinderLive.putExtra("KEY_PARAMS_KEY_VALUE", ap.a.a((List)paramIntent, null, 0, 0).toByteArray());
      paramString2 = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      paramString1 = paramContext;
      if (paramContext == null) {
        paramString1 = MMApplicationContext.getContext();
      }
      kotlin.g.b.s.s(paramString1, "context ?: MMApplicationContext.getContext()");
      paramString2.k(paramString1, paramPluginFinderLive);
      AppMethodBeat.o(351836);
      return;
      paramLong2 = ((Long)localObject2).longValue();
      break;
      paramPluginFinderLive = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      Log.e("Plugin.FinderLive", kotlin.g.b.s.X("enterFinderLiveReplayUI liveInfo:", com.tencent.mm.plugin.finder.live.view.convert.a.c(parambip)));
      AppMethodBeat.o(351836);
      return;
    }
  }
  
  private static final void enterFinderLiveTiger$jump(String paramString, Intent paramIntent, Context paramContext, FinderObject paramFinderObject, boolean paramBoolean)
  {
    AppMethodBeat.i(371171);
    Intent localIntent;
    label74:
    String str1;
    label136:
    label161:
    label177:
    Object localObject1;
    label212:
    Object localObject3;
    Object localObject2;
    label238:
    com.tencent.mm.plugin.f localf;
    label267:
    long l2;
    long l1;
    if (paramFinderObject == null)
    {
      Log.e("Plugin.FinderLive", "enterFinderLiveTiger requestFinderObject null");
      if (paramBoolean)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new PluginFinderLive.af(paramContext));
        AppMethodBeat.o(371171);
      }
    }
    else
    {
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(paramString);
      if (paramIntent != null) {
        break label419;
      }
      localIntent = new Intent();
      paramIntent = paramFinderObject.liveInfo;
      if (paramIntent != null) {
        break label425;
      }
      i = 0;
      localIntent.putExtra("KEY_ENTER_LIVE_PARAM_VR_LIVE_TYPE", i);
      paramIntent = paramFinderObject.liveInfo;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.ZSn;
        if (paramIntent != null) {
          localIntent.putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO", paramIntent.toByteArray());
        }
      }
      paramIntent = paramFinderObject.liveInfo;
      if ((paramIntent == null) || (paramIntent.liveStatus != 1)) {
        break label434;
      }
      i = 1;
      if (i == 0) {
        break label440;
      }
      paramIntent = paramFinderObject.liveInfo;
      if (paramIntent == null) {
        break label440;
      }
      str1 = paramIntent.mIE;
      if (str1 == null) {
        break label440;
      }
      if (i == 0) {
        break label473;
      }
      paramIntent = paramFinderObject.liveInfo;
      if (paramIntent != null) {
        break label448;
      }
      paramIntent = null;
      if (i == 0) {
        break label481;
      }
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 == null) {
        break label481;
      }
      localObject1 = ((bip)localObject1).ZOg;
      if (localObject1 == null) {
        break label481;
      }
      localObject1 = ((dix)localObject1).toByteArray();
      localObject3 = new StringBuilder("enterFinderLiveTiger liveId:");
      localObject2 = paramFinderObject.liveInfo;
      if (localObject2 != null) {
        break label487;
      }
      localObject2 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject2).append(",liveStatus:");
      localObject2 = paramFinderObject.contact;
      if (localObject2 != null) {
        break label500;
      }
      localObject2 = null;
      Log.i("Plugin.FinderLive", localObject2);
      localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(localObject2, "service(IActivityRouter::class.java)");
      localf = (com.tencent.mm.plugin.f)localObject2;
      l2 = paramFinderObject.id;
      localObject2 = paramFinderObject.liveInfo;
      if (localObject2 != null) {
        break label513;
      }
      l1 = 0L;
      label326:
      localObject3 = paramFinderObject.username;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      String str2 = paramFinderObject.objectNonceId;
      localObject3 = str2;
      if (str2 == null) {
        localObject3 = "";
      }
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject != null) {
        break label523;
      }
    }
    label513:
    label523:
    for (int i = 0;; i = paramFinderObject.ZRR)
    {
      com.tencent.mm.plugin.f.a.a(localf, localIntent, paramContext, l2, l1, (String)localObject2, (String)localObject3, "", paramString, i, null, null, str1, paramIntent, 0, (byte[])localObject1, false, 42496);
      AppMethodBeat.o(371171);
      return;
      label419:
      localIntent = paramIntent;
      break;
      label425:
      i = paramIntent.ZSl;
      break label74;
      label434:
      i = 0;
      break label136;
      label440:
      str1 = "";
      break label161;
      label448:
      paramIntent = paramIntent.ZRQ;
      if (paramIntent == null)
      {
        paramIntent = null;
        break label177;
      }
      paramIntent = Integer.valueOf(paramIntent.mNn);
      break label177;
      label473:
      paramIntent = Integer.valueOf(0);
      break label177;
      label481:
      localObject1 = null;
      break label212;
      label487:
      localObject2 = Long.valueOf(((bip)localObject2).liveId);
      break label238;
      label500:
      localObject2 = Integer.valueOf(((FinderContact)localObject2).liveStatus);
      break label267;
      l1 = ((bip)localObject2).liveId;
      break label326;
    }
  }
  
  private static final ah enterFinderLiveUIByBiz$lambda-18(com.tencent.mm.plugin.findersdk.b.e parame, Integer paramInteger, List paramList, String paramString1, String paramString2, b.a parama)
  {
    AppMethodBeat.i(371185);
    kotlin.g.b.s.u(parame, "$loadingDialog");
    parame.dismiss();
    FinderObject localFinderObject = ((ayl)parama.ott).feedObject;
    if ((parama.errType == 0) && (parama.errCode == 0) && (localFinderObject != null))
    {
      parame = new StringBuilder("enterFinderLiveUIByBiz liveId: ");
      parama = localFinderObject.liveInfo;
      long l1;
      Object localObject1;
      if (parama == null)
      {
        l1 = 0L;
        localObject1 = parame.append(l1).append(", username:");
        parama = localFinderObject.username;
        parame = parama;
        if (parama == null) {
          parame = "";
        }
        Log.i("Plugin.FinderLive", parame);
        parame = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        l1 = localFinderObject.id;
        parame = FinderItem.Companion;
        e.a.b(l1, FinderItem.a.e(localFinderObject, 0));
        if (paramInteger != null) {
          break label287;
        }
        label156:
        if (paramInteger != null) {
          break label302;
        }
        label160:
        if (paramInteger != null) {
          break label317;
        }
        label164:
        if (paramInteger != null) {
          break label332;
        }
        label168:
        if (paramInteger != null) {
          break label347;
        }
        label172:
        if (paramInteger != null) {
          break label363;
        }
        label176:
        parame = "";
        label180:
        if (paramInteger != null) {
          break label379;
        }
        label184:
        if (paramInteger != null) {
          break label410;
        }
        if (paramInteger != null) {
          break label421;
        }
        label192:
        if (paramInteger != null) {
          break label432;
        }
        label196:
        paramInteger = "";
      }
      label200:
      Object localObject2;
      for (;;)
      {
        localObject1 = new StringBuilder();
        localObject2 = new ArrayList();
        if (paramList == null) {
          break label463;
        }
        paramList = ((Iterable)paramList).iterator();
        while (paramList.hasNext())
        {
          parama = (String)paramList.next();
          ((StringBuilder)localObject1).append(parama).append(",");
          ((ArrayList)localObject2).add(parama);
        }
        l1 = parama.liveId;
        break;
        label287:
        if (paramInteger.intValue() != 1) {
          break label156;
        }
        parame = "mmbiz_oftenread_bar";
        break label180;
        label302:
        if (paramInteger.intValue() != 2) {
          break label160;
        }
        parame = "mmbiz_live_bar";
        break label180;
        label317:
        if (paramInteger.intValue() != 3) {
          break label164;
        }
        parame = "mmbiz_tl";
        break label180;
        label332:
        if (paramInteger.intValue() != 4) {
          break label168;
        }
        parame = "mmbiz_message";
        break label180;
        label347:
        if (paramInteger.intValue() != 8) {
          break label172;
        }
        parame = "mmbiz_profile";
        break label180;
        label363:
        if (paramInteger.intValue() != 9) {
          break label176;
        }
        parame = "mmbiz_article";
        break label180;
        label379:
        if (paramInteger.intValue() != 1) {
          break label184;
        }
        for (;;)
        {
          paramInteger = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(26, 2, 65);
          break label200;
          label410:
          if (paramInteger.intValue() != 2)
          {
            break;
            label421:
            if (paramInteger.intValue() != 3) {
              break label192;
            }
          }
        }
        label432:
        if (paramInteger.intValue() != 4) {
          break label196;
        }
        paramInteger = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(27, 2, 65);
      }
      label463:
      parama = new Intent();
      paramList = paramString1;
      if (paramString1 == null) {
        paramList = "";
      }
      parama.putExtra("key_enter_live_export_id", paramList);
      parama.putExtra("key_enter_live_param_visitor_enter_scene", 4);
      parama.putStringArrayListExtra("key_enter_live_export_id_list", (ArrayList)localObject2);
      int i;
      if (((CharSequence)localObject1).length() == 0) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          parama.putExtra("key_enter_live_param_by_pass_type", 3);
          parama.putExtra("key_enter_live_param_by_pass_info", ((StringBuilder)localObject1).toString());
        }
        com.tencent.mm.plugin.expt.hellhound.a.aqz(q.n.DtD.scene);
        paramList = new com.tencent.mm.ad.i();
        try
        {
          paramList.n("bizusername", paramString2);
          paramList.n("exposeType", parame);
          parama.putExtra("key_chnl_extra", paramList.toString());
          parame = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
          kotlin.g.b.s.s(parame, "plugin(IPluginFinderLive::class.java)");
          paramString2 = (com.tencent.d.a.a.a.b)parame;
          localObject1 = MMApplicationContext.getContext();
          long l2 = localFinderObject.id;
          parame = localFinderObject.liveInfo;
          if (parame == null)
          {
            l1 = 0L;
            parame = localFinderObject.objectNonceId;
            paramString1 = parame;
            if (parame == null) {
              paramString1 = "";
            }
            kotlin.g.b.s.s(paramInteger, "contextId");
            localObject2 = localFinderObject.sessionBuffer;
            parame = localFinderObject.liveInfo;
            if (parame != null) {
              break label799;
            }
            parame = "";
            paramList = localFinderObject.liveInfo;
            if (paramList != null) {
              break label817;
            }
            paramList = null;
            if (paramList != null) {
              break label842;
            }
            paramList = e.b.mKf;
            i = e.b.bcu();
            com.tencent.d.a.a.a.b.b.a(paramString2, parama, (Context)localObject1, l2, Long.valueOf(l1), "", paramString1, "", paramInteger, (String)localObject2, "", parame, i);
            parame = ah.aiuX;
            AppMethodBeat.o(371185);
            return parame;
            i = 0;
          }
        }
        catch (Exception parame)
        {
          for (;;)
          {
            Log.w("Plugin.FinderLive", kotlin.g.b.s.X("err:", parame.getMessage()));
            continue;
            l1 = parame.liveId;
            continue;
            label799:
            paramList = parame.mIE;
            parame = paramList;
            if (paramList == null)
            {
              parame = "";
              continue;
              label817:
              paramList = paramList.ZRQ;
              if (paramList == null)
              {
                paramList = null;
              }
              else
              {
                paramList = Integer.valueOf(paramList.mNn);
                continue;
                label842:
                i = paramList.intValue();
              }
            }
          }
        }
      }
    }
    parame = new StringBuilder("enterFinderLiveUIByBiz failed. ").append(parama.errType).append(", ").append(parama.errCode).append(", ");
    if (localFinderObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.w("Plugin.FinderLive", bool);
      parame = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_permission_title);
      kotlin.g.b.s.s(parame, "getContext().resources.g…er_live_permission_title)");
      if (parama.errCode == -4036)
      {
        parame = MMApplicationContext.getContext().getResources().getString(p.h.finder_private_feed_can_not_see_live);
        kotlin.g.b.s.s(parame, "getContext().resources.g…te_feed_can_not_see_live)");
      }
      aa.makeText(MMApplicationContext.getContext(), (CharSequence)parame, 0).show();
      break;
    }
  }
  
  private static final void fillAuthIcon$setNicknamePaddingEnd(TextView paramTextView, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(351817);
    if (paramTextView != null) {
      if (!paramBoolean) {
        break label38;
      }
    }
    label38:
    for (int i = com.tencent.mm.cd.a.fromDPToPix(paramTextView.getContext(), paramFloat);; i = 0)
    {
      paramTextView.setPaddingRelative(0, 0, i, 0);
      AppMethodBeat.o(351817);
      return;
    }
  }
  
  private final String genContextId(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(351492);
    String str = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(paramInt1, paramInt2, paramInt3);
    kotlin.g.b.s.s(str, "plugin(IPluginFinder::cl…nterType, toCommentScene)");
    AppMethodBeat.o(351492);
    return str;
  }
  
  private final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(351441);
    com.tencent.mm.storagebase.h localh = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getDB();
    kotlin.g.b.s.s(localh, "plugin(IPluginFinder::class.java).getDB()");
    AppMethodBeat.o(351441);
    return localh;
  }
  
  private final com.tencent.mm.plugin.finder.live.storage.b getFinderLiveChargeInfoStorage()
  {
    AppMethodBeat.i(351386);
    com.tencent.mm.plugin.finder.live.storage.b localb = (com.tencent.mm.plugin.finder.live.storage.b)this.Byb.getValue();
    AppMethodBeat.o(351386);
    return localb;
  }
  
  private final com.tencent.mm.plugin.finder.live.storage.d getFinderLiveDislikeBannerStorage()
  {
    AppMethodBeat.i(351354);
    com.tencent.mm.plugin.finder.live.storage.d locald = (com.tencent.mm.plugin.finder.live.storage.d)this.BxZ.getValue();
    AppMethodBeat.o(351354);
    return locald;
  }
  
  private static final ah getFinderLivePreviewUrl$lambda-29(kotlin.g.a.q paramq, b.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(371191);
    kotlin.g.b.s.u(paramq, "$callback");
    Object localObject3 = new StringBuilder("getFinderLivePreviewUrl errCode:").append(parama.errCode).append(" errType:").append(parama.errType).append(" url:");
    Object localObject1 = ((ayl)parama.ott).feedObject;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("Plugin.FinderLive", localObject1);
      if ((parama.errType != 0) || (parama.errCode != 0)) {
        break label191;
      }
      localObject1 = ((ayl)parama.ott).feedObject;
      if (localObject1 != null) {
        break label169;
      }
      localObject1 = localObject2;
      label116:
      paramq.invoke(localObject1, parama.errMsg, Integer.valueOf(parama.errCode));
    }
    for (;;)
    {
      paramq = ah.aiuX;
      AppMethodBeat.o(371191);
      return paramq;
      localObject1 = ((FinderObject)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bip)localObject1).mIE;
      break;
      label169:
      localObject3 = ((FinderObject)localObject1).liveInfo;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label116;
      }
      localObject1 = ((bip)localObject3).mIE;
      break label116;
      label191:
      paramq.invoke("", parama.errMsg, Integer.valueOf(-1));
    }
  }
  
  private final com.tencent.mm.plugin.finder.live.storage.i getFinderLiveVideoDefinitionStorage()
  {
    AppMethodBeat.i(351366);
    com.tencent.mm.plugin.finder.live.storage.i locali = (com.tencent.mm.plugin.finder.live.storage.i)this.Bya.getValue();
    AppMethodBeat.o(351366);
    return locali;
  }
  
  private final com.tencent.mm.plugin.finder.live.storage.a getLiveActionRecordStorage()
  {
    AppMethodBeat.i(351342);
    com.tencent.mm.plugin.finder.live.storage.a locala = (com.tencent.mm.plugin.finder.live.storage.a)this.BxY.getValue();
    AppMethodBeat.o(351342);
    return locala;
  }
  
  private final com.tencent.mm.plugin.finder.live.storage.c getLiveConfigStorage()
  {
    AppMethodBeat.i(351317);
    com.tencent.mm.plugin.finder.live.storage.c localc = (com.tencent.mm.plugin.finder.live.storage.c)this.BxW.getValue();
    AppMethodBeat.o(351317);
    return localc;
  }
  
  private final com.tencent.mm.plugin.finder.live.storage.e getLiveGiftStorage()
  {
    AppMethodBeat.i(351276);
    com.tencent.mm.plugin.finder.live.storage.e locale = (com.tencent.mm.plugin.finder.live.storage.e)this.BxT.getValue();
    AppMethodBeat.o(351276);
    return locale;
  }
  
  private static final void getLiveInfo$lambda-1(PluginFinderLive paramPluginFinderLive, final long paramLong, boolean paramBoolean, com.tencent.mm.vending.e.b paramb, b.d paramd)
  {
    AppMethodBeat.i(351689);
    kotlin.g.b.s.u(paramPluginFinderLive, "this$0");
    kotlin.u localu = (kotlin.u)paramPluginFinderLive.BxJ.get(Long.valueOf(paramLong));
    Log.i("Plugin.FinderLive", "getLiveInfo cache: liveID:" + paramLong + ",forceRefresh:" + paramBoolean + ",status:" + paramPluginFinderLive.getLiveStatus(localu));
    if (paramBoolean) {
      paramPluginFinderLive.BxJ.remove(Long.valueOf(paramLong));
    }
    if ((!paramBoolean) && (localu != null) && (paramPluginFinderLive.isLiveInfoValid(localu)))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new r(paramd, paramLong, localu));
      AppMethodBeat.o(351689);
      return;
    }
    if (com.tencent.mm.kernel.h.aZW().oun != null)
    {
      paramPluginFinderLive.cgiGetLiveInfo(paramLong, paramb, paramd);
      AppMethodBeat.o(351689);
      return;
    }
    Log.i("Plugin.FinderLive", "getLiveInfo dispatcher is null!");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new s(paramd, paramLong));
    AppMethodBeat.o(351689);
  }
  
  private final com.tencent.mm.plugin.finder.live.storage.f getLiveLastRewardInfoStorage()
  {
    AppMethodBeat.i(351300);
    com.tencent.mm.plugin.finder.live.storage.f localf = (com.tencent.mm.plugin.finder.live.storage.f)this.BxV.getValue();
    AppMethodBeat.o(351300);
    return localf;
  }
  
  private final com.tencent.mm.plugin.finder.live.storage.g getLiveLuckyMoneyStorage()
  {
    AppMethodBeat.i(351288);
    com.tencent.mm.plugin.finder.live.storage.g localg = (com.tencent.mm.plugin.finder.live.storage.g)this.BxU.getValue();
    AppMethodBeat.o(351288);
    return localg;
  }
  
  private final com.tencent.mm.plugin.finder.live.storage.h getLiveNotifyExposureInfoStorage()
  {
    AppMethodBeat.i(351329);
    com.tencent.mm.plugin.finder.live.storage.h localh = (com.tencent.mm.plugin.finder.live.storage.h)this.BxX.getValue();
    AppMethodBeat.o(351329);
    return localh;
  }
  
  private final String getLiveStatus(kotlin.u<Integer, Long, ? extends azl> paramu)
  {
    Object localObject2 = null;
    AppMethodBeat.i(351461);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramu == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      if (paramu != null) {
        break label109;
      }
      localObject1 = null;
      label46:
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      if (paramu != null) {
        break label121;
      }
    }
    label109:
    label121:
    for (paramu = null;; paramu = (azl)paramu.aiuN)
    {
      if (paramu != null) {
        break label132;
      }
      paramu = "";
      paramu = paramu;
      AppMethodBeat.o(351461);
      return paramu;
      localObject1 = (Integer)paramu.bsC;
      break;
      localObject1 = (Long)paramu.bsD;
      break label46;
    }
    label132:
    Object localObject1 = new StringBuilder("liveId:");
    Object localObject3 = paramu.liveInfo;
    long l;
    if (localObject3 == null)
    {
      l = 0L;
      label157:
      localObject3 = ((StringBuilder)localObject1).append(com.tencent.mm.ae.d.hF(l)).append(" refreshInterval:").append(paramu.refreshInterval).append(" replay_status:");
      localObject1 = paramu.liveInfo;
      if (localObject1 != null) {
        break label252;
      }
      localObject1 = null;
      label201:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(' ');
      paramu = paramu.liveInfo;
      if (paramu != null) {
        break label265;
      }
    }
    label265:
    for (paramu = localObject2;; paramu = paramu.ZSc)
    {
      paramu = com.tencent.mm.plugin.finder.live.view.convert.a.a(paramu);
      break;
      l = ((bip)localObject3).liveId;
      break label157;
      label252:
      localObject1 = Integer.valueOf(((bip)localObject1).replay_status);
      break label201;
    }
  }
  
  private final boolean isLiveInfoValid(kotlin.u<Integer, Long, ? extends azl> paramu)
  {
    AppMethodBeat.i(351595);
    if (!isLiveInfoValid$isLiveInfoOnTime(this, paramu))
    {
      if ((paramu == null) || (2 != ((Number)paramu.bsC).intValue())) {
        break label75;
      }
      i = 1;
      if (i == 0) {
        break label85;
      }
      paramu = ((azl)paramu.aiuN).liveInfo;
      if ((paramu == null) || (paramu.replay_status != 1)) {
        break label80;
      }
    }
    label75:
    label80:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label85;
      }
      AppMethodBeat.o(351595);
      return true;
      i = 0;
      break;
    }
    label85:
    AppMethodBeat.o(351595);
    return false;
  }
  
  private static final boolean isLiveInfoValid$isLiveInfoOnTime(PluginFinderLive paramPluginFinderLive, kotlin.u<Integer, Long, ? extends azl> paramu)
  {
    AppMethodBeat.i(351777);
    long l2;
    long l1;
    if (com.tencent.mm.plugin.findersdk.a.k.Hca > 0)
    {
      l2 = com.tencent.mm.plugin.findersdk.a.k.Hca * 1000;
      long l3 = System.currentTimeMillis();
      if (paramu != null) {
        break label134;
      }
      l1 = 0L;
      label33:
      if (l3 - l1 >= l2) {
        break label162;
      }
    }
    label134:
    label162:
    for (boolean bool = true;; bool = false)
    {
      Log.i("Plugin.FinderLive", "isLiveInfoOnTime:" + bool + " status:" + paramPluginFinderLive.getLiveStatus(paramu) + ",refreshDuration:" + l2 + ",thread:" + Thread.currentThread());
      AppMethodBeat.o(351777);
      return bool;
      Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
      l2 = com.tencent.d.a.a.a.a.a.jTz() * 1000;
      break;
      localObject = (Long)paramu.bsD;
      if (localObject == null)
      {
        l1 = 0L;
        break label33;
      }
      l1 = ((Long)localObject).longValue();
      break label33;
    }
  }
  
  private static final ah loadMicInfos$lambda-45(String paramString1, String paramString2, kotlin.g.a.r paramr, b.a parama)
  {
    int j = 0;
    Object localObject2 = null;
    AppMethodBeat.i(371208);
    kotlin.g.b.s.u(paramString1, "$encryptedId");
    kotlin.g.b.s.u(paramString2, "$nonceId");
    kotlin.g.b.s.u(paramr, "$callback");
    StringBuilder localStringBuilder = new StringBuilder("loadMicInfos errType:");
    Object localObject1;
    label74:
    label114:
    int i;
    if (parama == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" errCode:");
      if (parama != null) {
        break label197;
      }
      localObject1 = null;
      paramString2 = localStringBuilder.append(localObject1).append(" encryptedId:").append(paramString1).append(" nonceId:").append(paramString2).append(" result:");
      if (parama != null) {
        break label209;
      }
      paramString1 = null;
      Log.i("Plugin.FinderLive", paramString1);
      if (parama != null) {
        break label251;
      }
      i = 0;
      label135:
      if (parama != null) {
        break label260;
      }
      label139:
      if (parama != null) {
        break label269;
      }
      paramString1 = "";
      label147:
      if (parama != null) {
        break label288;
      }
    }
    label260:
    label269:
    label288:
    for (paramString2 = localObject2;; paramString2 = (aub)parama.ott)
    {
      paramr.a(Integer.valueOf(i), Integer.valueOf(j), paramString1, paramString2);
      paramString1 = ah.aiuX;
      AppMethodBeat.o(371208);
      return paramString1;
      localObject1 = Integer.valueOf(parama.errType);
      break;
      label197:
      localObject1 = Integer.valueOf(parama.errCode);
      break label74;
      label209:
      paramString1 = (aub)parama.ott;
      if (paramString1 == null)
      {
        paramString1 = null;
        break label114;
      }
      paramString1 = paramString1.ZEz;
      if (paramString1 == null)
      {
        paramString1 = null;
        break label114;
      }
      paramString1 = Integer.valueOf(paramString1.size());
      break label114;
      label251:
      i = parama.errType;
      break label135;
      j = parama.errCode;
      break label139;
      paramString1 = parama.errMsg;
      if (paramString1 == null)
      {
        paramString1 = "";
        break label147;
      }
      break label147;
    }
  }
  
  private final void registerScreenReceiver()
  {
    AppMethodBeat.i(351424);
    if (this.BxQ == null) {
      this.BxQ = new c();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    MMApplicationContext.getContext().registerReceiver((BroadcastReceiver)this.BxQ, localIntentFilter);
    AppMethodBeat.o(351424);
  }
  
  private final Object requestAndRefreshActivityIcon(Context paramContext, long paramLong, String paramString, ImageView paramImageView, kotlin.d.d<? super PluginFinderLive.b> paramd)
  {
    AppMethodBeat.i(351654);
    paramImageView = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    kotlin.d.d locald = (kotlin.d.d)paramImageView;
    String str = com.tencent.mm.ae.d.hF(paramLong);
    Log.i("Plugin.FinderLive", "#requestAndRefreshActivityIcon feedId=" + str + " nonceId=" + paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new kotlin.r(kotlin.d.b.a.b.BF(paramLong), paramString));
    paramString = ah.aiuX;
    paramString = com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)new com.tencent.mm.plugin.finder.cgi.g((List)localArrayList, 5, null, null, 28).bFJ(), (kotlin.g.a.b)new PluginFinderLive.ac(str, locald));
    if ((paramContext instanceof MMActivity)) {
      paramString.b((com.tencent.mm.vending.e.b)paramContext);
    }
    paramContext = paramImageView.kli();
    if (paramContext == kotlin.d.a.a.aiwj) {
      kotlin.g.b.s.u(paramd, "frame");
    }
    AppMethodBeat.o(351654);
    return paramContext;
  }
  
  private final void unregisterScreenReceiver()
  {
    AppMethodBeat.i(351406);
    if (this.BxQ != null) {
      MMApplicationContext.getContext().unregisterReceiver((BroadcastReceiver)this.BxQ);
    }
    this.BxQ = null;
    AppMethodBeat.o(351406);
  }
  
  public final void autoOpenFinderLive(final JSONObject paramJSONObject, final Context paramContext, final ca.a<Object> parama, ca.a<Integer> parama1)
  {
    AppMethodBeat.i(352196);
    kotlin.g.b.s.u(paramJSONObject, "extInfo");
    kotlin.g.b.s.u(paramContext, "context");
    String str1 = paramJSONObject.optString("finderUserName");
    if (str1 == null) {
      str1 = "";
    }
    for (;;)
    {
      int i = paramJSONObject.optInt("commentScene");
      String str2 = paramJSONObject.optString("reportExtraInfo", "");
      String str3 = paramJSONObject.optString("feedID", "");
      final String str4 = paramJSONObject.optString("nonceID", "");
      Object localObject = com.tencent.mm.plugin.finder.live.report.k.Doi;
      kotlin.g.b.s.s(str2, "extraInfo");
      com.tencent.mm.plugin.finder.live.report.k.axs(str2);
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      c.a.hm(str2, str1);
      if (Util.isNullOrNil(str1)) {
        break;
      }
      Log.i("Plugin.FinderLive", "autoOpenFinderLive anchorUsername:" + str1 + ", commentScene:" + i);
      new ac(str1, (com.tencent.mm.plugin.findersdk.a.t)new e(str3, str4, this, paramContext, paramJSONObject, parama)).bFJ();
      AppMethodBeat.o(352196);
      return;
    }
    Log.w("Plugin.FinderLive", "autoOpenFinderLive anchorUsername empty");
    if (parama1 != null) {
      parama1.onCallback(Integer.valueOf(-1000));
    }
    AppMethodBeat.o(352196);
  }
  
  public final void backToFinderLiveAnchorUIOnExternalLive(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(352373);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    if ((!com.tencent.mm.plugin.finder.live.model.aj.hKC) || (paramContext == null))
    {
      AppMethodBeat.o(352373);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.live.model.ar.CIh;
    com.tencent.mm.plugin.finder.live.model.ar.emj();
    localObject1 = com.tencent.mm.plugin.finder.live.model.aj.nkg;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.trtc.a)localObject1).bcg();
    }
    localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CDO;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof MMFinderUI)) {
        break label323;
      }
      localObject1 = (MMFinderUI)localObject1;
      label79:
      if (localObject1 != null) {
        break label329;
      }
      localObject1 = null;
      label87:
      if (localObject1 != null) {
        break label409;
      }
      localObject1 = com.tencent.mm.plugin.findersdk.e.a.HdV;
      localObject1 = com.tencent.mm.plugin.findersdk.e.a.fsC();
    }
    label407:
    label409:
    for (;;)
    {
      if (paramBoolean1)
      {
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).sk(true);
        }
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).Eey = paramBoolean2;
        }
        localObject2 = com.tencent.mm.plugin.finder.live.model.aj.CDO;
        if (localObject2 != null) {
          com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject2, com.tencent.mm.live.b.b.c.ncD);
        }
      }
      Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).Eeo = 0;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setClass(paramContext, (Class)localObject1);
      ((Intent)localObject2).putExtra("route_to_maximize", true);
      ((Intent)localObject2).addFlags(872415232);
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "backToFinderLiveAnchorUIOnExternalLive", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "backToFinderLiveAnchorUIOnExternalLive", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(352373);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.view.a)localObject1).getContext();
      break;
      label323:
      localObject1 = null;
      break label79;
      label329:
      localObject1 = localObject1.getClass();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label87;
      }
      localObject2 = com.tencent.mm.plugin.findersdk.e.a.HdV;
      kotlin.g.b.s.u(localObject1, "clazz");
      if ((kotlin.g.b.s.p(localObject1, com.tencent.mm.plugin.findersdk.e.a.fsD())) || (kotlin.g.b.s.p(localObject1, com.tencent.mm.plugin.findersdk.e.a.fsC()))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label407;
        }
        localObject1 = com.tencent.mm.plugin.findersdk.e.a.HdV;
        localObject1 = com.tencent.mm.plugin.findersdk.e.a.fsC();
        break;
      }
      break label87;
    }
  }
  
  public final void batchGetLiveStatus(List<? extends Pair<Long, String>> paramList, com.tencent.d.a.a.a.b.c paramc, Context paramContext)
  {
    AppMethodBeat.i(352170);
    kotlin.g.b.s.u(paramList, "finderObjectList");
    kotlin.g.b.s.u(paramc, "callback");
    if (paramList.isEmpty())
    {
      Log.w("Plugin.FinderLive", "batchGetLiveInfo: finderObject list is null!");
      AppMethodBeat.o(352170);
      return;
    }
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      paramList.add(new kotlin.r(localPair.first, localPair.second));
    }
    paramList = new com.tencent.mm.plugin.finder.cgi.g((List)paramList, 1, null, null, 28);
    paramList.HcI = false;
    paramList = com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)paramList.bFJ(), (kotlin.g.a.b)new f(paramc));
    if ((paramContext != null) && ((paramContext instanceof MMActivity))) {
      paramList.b((com.tencent.mm.vending.e.b)paramContext);
    }
    AppMethodBeat.o(352170);
  }
  
  public final void callLiveExperimentalAPI(String paramString)
  {
    AppMethodBeat.i(352513);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.callLiveExperimentalAPI(paramString);
    AppMethodBeat.o(352513);
  }
  
  public final void cancelCirculationFillingActivityIconOfSourceType(final int paramInt)
  {
    AppMethodBeat.i(352613);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this, paramInt));
    AppMethodBeat.o(352613);
  }
  
  public final void checkInsertLiveNewReddot()
  {
    AppMethodBeat.i(352325);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.checkInsertLiveNewReddot();
    AppMethodBeat.o(352325);
  }
  
  public final void checkLastLiveObject(Context paramContext, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(352340);
    boolean bool1;
    boolean bool2;
    if (paramContext != null)
    {
      Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      bool1 = com.tencent.mm.ae.d.ee(com.tencent.mm.plugin.finder.live.utils.a.aBP().getInt("live_status_flag", 0), 1);
      localObject1 = new ah.a();
      bool2 = com.tencent.mm.n.a.r(paramContext, false);
      if ((!bool1) || (bool2)) {
        break label160;
      }
      Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.aBP().putInt("live_status_flag", 0);
      long l = System.currentTimeMillis();
      localObject2 = com.tencent.mm.model.z.bAW();
      kotlin.g.b.s.s(localObject2, "getMyFinderUsername()");
      new ac((String)localObject2, (com.tencent.mm.plugin.findersdk.a.t)new PluginFinderLive.i(l, paramb, (ah.a)localObject1, paramContext, this)).bFJ();
    }
    for (;;)
    {
      Log.i("Plugin.FinderLive", "checkUnfinishLive localUnfinishLive:" + bool1 + " livingAsAnchor:" + bool2);
      AppMethodBeat.o(352340);
      return;
      label160:
      if (paramb != null) {
        paramb.invoke(Boolean.FALSE);
      }
    }
  }
  
  public final void cleatLiveStatusCache(long paramLong)
  {
    AppMethodBeat.i(352103);
    this.BxK.post(new PluginFinderLive..ExternalSyntheticLambda4(paramLong, this));
    AppMethodBeat.o(352103);
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(352084);
    af.b("live", "live/decoration", 268435456L, 86400000L, 49);
    AppMethodBeat.o(352084);
  }
  
  public final void controlLiveMiniWindowVisibility(boolean paramBoolean, Context paramContext)
  {
    AppMethodBeat.i(352440);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.controlLiveMiniWindowVisibility(paramBoolean, paramContext);
    AppMethodBeat.o(352440);
  }
  
  public final void createFinderLive(Context paramContext, String paramString)
  {
    AppMethodBeat.i(352585);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "extInfo");
    Intent localIntent = new Intent();
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (paramString == null)
    {
      paramString = null;
      localObject = paramString;
      if (paramString == null) {
        localObject = null;
      }
      if (localObject != null) {
        localIntent.putExtra("KEY_TAG_INFO", ((bno)localObject).toByteArray());
      }
      if ((paramContext instanceof Activity)) {
        break label333;
      }
    }
    label333:
    for (paramString = localIntent;; paramString = null)
    {
      if (paramString != null) {
        paramString.addFlags(268435456);
      }
      paramString = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(paramString, "service(IFinderCommonService::class.java)");
      h.a.a((com.tencent.mm.plugin.h)paramString, paramContext, localIntent, 0, 124);
      localIntent.setClass(paramContext, FinderLivePostPendingUI.class);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/finder/live/PluginFinderLive", "createFinderLive", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/PluginFinderLive", "createFinderLive", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(352585);
      return;
      int i;
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        label222:
        if (i == 0) {
          break label244;
        }
      }
      label244:
      for (localObject = paramString;; localObject = null)
      {
        if (localObject != null) {
          break label250;
        }
        paramString = null;
        break;
        i = 0;
        break label222;
      }
      label250:
      localObject = new com.tencent.mm.ad.i(paramString);
      paramString = new bno();
      localObject = ((com.tencent.mm.ad.i)localObject).Ft("tag");
      kotlin.g.b.s.s(localObject, "tag");
      com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.ad.i)localObject, paramString);
      localObject = ((com.tencent.mm.ad.i)localObject).Ft("sub_tag");
      paramString.ZWk = new bno();
      kotlin.g.b.s.s(localObject, "subTag");
      com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.ad.i)localObject, paramString.ZWk);
      break;
    }
  }
  
  public final void createLuckyMoneyLive(Context paramContext, String paramString)
  {
    AppMethodBeat.i(352269);
    kotlin.g.b.s.u(paramContext, "context");
    if (kotlin.g.b.s.p(com.tencent.mm.kernel.h.baE().ban().get(at.a.adgj, Integer.valueOf(0)), Integer.valueOf(0)))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()) });
      Intent localIntent = new Intent();
      Object localObject2 = com.tencent.mm.kernel.h.baE().ban().d(274436, "").toString();
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = LocaleUtil.getCurrentCountryCode();
      }
      localObject2 = localObject1;
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (!Util.isAllAlpha((String)localObject1)) {
          localObject2 = "";
        }
      }
      int i = p.h.Csd;
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = "";
      }
      paramString = paramContext.getString(i, new Object[] { URLEncoder.encode((String)localObject1), LocaleUtil.getApplicationLanguage(), localObject2 });
      kotlin.g.b.s.s(paramString, "context.getString(\n     …tryCode\n                )");
      localObject1 = paramString.getBytes(kotlin.n.d.UTF_8);
      kotlin.g.b.s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject1 = Base64.encode((byte[])localObject1, 0);
      kotlin.g.b.s.s(localObject1, "encode(WILCOME_URL.toByteArray(), Base64.DEFAULT)");
      Log.i("Plugin.FinderLive", kotlin.g.b.s.X("WILCOME_URL:", new String((byte[])localObject1, kotlin.n.d.UTF_8)));
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("showShare", false);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgj, Integer.valueOf(1));
      Log.i("Plugin.FinderLive", "createLuckyMoneyLive show guide");
      AppMethodBeat.o(352269);
      return;
    }
    createLuckyMoneyLiveImpl(paramContext, paramString);
    AppMethodBeat.o(352269);
  }
  
  public final void enableAudioVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(352496);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.enableAudioVolumeEvaluation(paramInt);
    AppMethodBeat.o(352496);
  }
  
  public final void enableCustomAudioCapture(boolean paramBoolean)
  {
    AppMethodBeat.i(352483);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.enableCustomAudioCapture(paramBoolean);
    AppMethodBeat.o(352483);
  }
  
  public final void enableLiveMiniWid(boolean paramBoolean)
  {
    AppMethodBeat.i(352667);
    Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).EcI = paramBoolean;
    }
    AppMethodBeat.o(352667);
  }
  
  public final void enableLocalPushStream(String paramString)
  {
    AppMethodBeat.i(352768);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jUQ().bmg()).intValue() == 1)
    {
      this.BxR = paramString;
      AppMethodBeat.o(352768);
      return;
    }
    this.BxR = null;
    AppMethodBeat.o(352768);
  }
  
  public final void enableMicExternalAudioFrame(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(352491);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.enableMicExternalAudioFrame(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(352491);
  }
  
  public final void enterFinderGameLiveAuthUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(352307);
    kotlin.g.b.s.u(paramContext, "context");
    ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).enterFinderGameLiveAuthUI(paramContext, paramIntent);
    AppMethodBeat.o(352307);
  }
  
  public final void enterFinderGameLivePostVerifyUI(Context paramContext, String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(352350);
    kotlin.g.b.s.u(paramString2, "developerCustomParam");
    kotlin.g.b.s.u(paramString3, "reportInfo");
    com.tencent.mm.plugin.f localf;
    Intent localIntent;
    if ((paramContext != null) && (paramString1 != null))
    {
      localf = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      localIntent = new Intent();
      localIntent.putExtra("APPID", paramString1);
      localIntent.putExtra("VERSION_TYPE", paramInt);
      localIntent.putExtra("IGNORE_CONTINUE_LIVE", paramBoolean);
      localIntent.putExtra("WXA_DEVELOPER_CUSTOM_PARAM", paramString2);
      localIntent.putExtra("REPORT_INFO", paramString3);
      if (!(paramContext instanceof Activity)) {
        break label165;
      }
      paramString1 = (Activity)paramContext;
      if (paramString1 != null) {
        break label170;
      }
      paramString1 = null;
      label121:
      if (paramString1 != null) {
        break label211;
      }
      label125:
      if (paramString1 != null) {
        break label237;
      }
      label129:
      localIntent.putExtra("LANDSCAPE_TYPE", f.j.a.adwr.ordinal());
    }
    for (;;)
    {
      paramString1 = ah.aiuX;
      localf.z(paramContext, localIntent);
      AppMethodBeat.o(352350);
      return;
      label165:
      paramString1 = null;
      break;
      label170:
      paramString1 = paramString1.getWindowManager();
      if (paramString1 == null)
      {
        paramString1 = null;
        break label121;
      }
      paramString1 = paramString1.getDefaultDisplay();
      if (paramString1 == null)
      {
        paramString1 = null;
        break label121;
      }
      paramString1 = Integer.valueOf(paramString1.getRotation());
      break label121;
      label211:
      if (paramString1.intValue() != 1) {
        break label125;
      }
      localIntent.putExtra("LANDSCAPE_TYPE", f.j.a.adws.ordinal());
      continue;
      label237:
      if (paramString1.intValue() != 3) {
        break label129;
      }
      localIntent.putExtra("LANDSCAPE_TYPE", f.j.a.adwt.ordinal());
    }
  }
  
  public final void enterFinderLiveAnchorUI(Intent paramIntent, Context paramContext, long paramLong, Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(352228);
    kotlin.g.b.s.u(paramString1, "nonceId");
    kotlin.g.b.s.u(paramString3, "contextId");
    if ((paramContext == null) || (paramLong1 == null))
    {
      AppMethodBeat.o(352228);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(paramString3);
    ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).a(paramIntent, paramContext, paramLong, paramLong1.longValue(), paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(352228);
  }
  
  public final void enterFinderLiveCountDownUI(Context paramContext)
  {
    AppMethodBeat.i(352360);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.f localf = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
    Intent localIntent = new Intent();
    Object localObject;
    if ((paramContext instanceof Activity))
    {
      localObject = (Activity)paramContext;
      if (localObject != null) {
        break label98;
      }
      localObject = null;
      label50:
      if (localObject != null) {
        break label139;
      }
      label54:
      if (localObject != null) {
        break label165;
      }
      label58:
      localIntent.putExtra("LANDSCAPE_TYPE", f.j.a.adwr.ordinal());
    }
    for (;;)
    {
      localObject = ah.aiuX;
      localf.p(paramContext, localIntent);
      AppMethodBeat.o(352360);
      return;
      localObject = null;
      break;
      label98:
      localObject = ((Activity)localObject).getWindowManager();
      if (localObject == null)
      {
        localObject = null;
        break label50;
      }
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      if (localObject == null)
      {
        localObject = null;
        break label50;
      }
      localObject = Integer.valueOf(((Display)localObject).getRotation());
      break label50;
      label139:
      if (((Integer)localObject).intValue() != 1) {
        break label54;
      }
      localIntent.putExtra("LANDSCAPE_TYPE", f.j.a.adws.ordinal());
      continue;
      label165:
      if (((Integer)localObject).intValue() != 3) {
        break label58;
      }
      localIntent.putExtra("LANDSCAPE_TYPE", f.j.a.adwt.ordinal());
    }
  }
  
  public final void enterFinderLiveInvitedUI(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(352318);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.f localf = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
    String str = paramString4;
    if (paramString4 == null) {
      str = "";
    }
    long l = com.tencent.mm.ae.d.FK(str);
    paramString4 = paramString5;
    if (paramString5 == null) {
      paramString4 = "";
    }
    localf.a(paramContext, paramString1, paramString2, paramString3, l, com.tencent.mm.ae.d.FK(paramString4));
    AppMethodBeat.o(352318);
  }
  
  public final void enterFinderLivePostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(352297);
    kotlin.g.b.s.u(paramContext, "context");
    new com.tencent.mm.plugin.finder.live.ui.livepost.b((Activity)paramContext).prepare();
    AppMethodBeat.o(352297);
  }
  
  public final void enterFinderLiveReplayUI(Intent paramIntent, final Context paramContext, final long paramLong1, long paramLong2, final String paramString1, String paramString2, final String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(352724);
    kotlin.g.b.s.u(paramString1, "anchorUserName");
    kotlin.g.b.s.u(paramString2, "nonceId");
    kotlin.g.b.s.u(paramString4, "contextId");
    Log.i("Plugin.FinderLive", "enterFinderLiveReplayUI objectId:" + paramLong1 + ",liveId:" + paramLong2 + ",anchorUserName:" + paramString1 + ",nonceId:" + paramString2 + ",desc:" + paramString3 + ",contextId:" + paramString4 + ",forceCheckTeenMode:" + paramBoolean);
    if ((!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((bw)com.tencent.mm.kernel.h.ax(bw.class)).eZE()) || (!paramBoolean))
    {
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(paramString4);
      paramString4 = (kotlin.u)this.BxJ.get(Long.valueOf(paramLong2));
      if (isLiveInfoValid(paramString4))
      {
        if (paramString4 == null) {
          paramString4 = null;
        }
        for (;;)
        {
          enterFinderLiveReplayUI$enterReplayUIImpl(this, paramContext, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramIntent);
          AppMethodBeat.o(352724);
          return;
          paramString4 = (azl)paramString4.aiuN;
          if (paramString4 == null) {
            paramString4 = null;
          } else {
            paramString4 = paramString4.liveInfo;
          }
        }
      }
      com.tencent.d.a.a.a.b.b.a((com.tencent.d.a.a.a.b)this, paramLong2, true, (b.d)new k(paramIntent, this, paramContext, paramLong1, paramLong2, paramString1, paramString2, paramString3), 4);
      AppMethodBeat.o(352724);
      return;
    }
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
    AppMethodBeat.o(352724);
  }
  
  public final void enterFinderLiveTiger(Intent paramIntent, Context paramContext, Long paramLong1, String paramString1, String paramString2, boolean paramBoolean, int paramInt, Long paramLong2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(371271);
    kotlin.g.b.s.u(paramString1, "anchorUserName");
    kotlin.g.b.s.u(paramString2, "contextId");
    if (paramContext == null)
    {
      AppMethodBeat.o(371271);
      return;
    }
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    long l1;
    Object localObject4;
    if ((!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((bw)com.tencent.mm.kernel.h.ax(bw.class)).eZE()) || (!paramBoolean))
    {
      Log.e("Plugin.FinderLive", "enterFinderLiveTiger liveId:" + paramLong1 + " objectId:" + paramLong2 + " nonceId:" + paramString3 + " anchorUserName:" + paramString1 + " launchMode:" + paramInt);
      if (paramInt == 1)
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(paramString2);
        localObject1 = "";
        localObject2 = e.b.mKf;
        i = e.b.bcu();
        localObject2 = null;
        localObject3 = (kotlin.u)((Map)this.BxJ).get(paramLong1);
        if (com.tencent.mm.plugin.findersdk.a.k.Hca > 0)
        {
          l1 = com.tencent.mm.plugin.findersdk.a.k.Hca * 1000;
          localObject4 = l.d.mYm;
          paramInt = l.d.bhr();
          if ((localObject3 == null) || (paramInt != ((Number)((kotlin.u)localObject3).bsC).intValue())) {
            break label538;
          }
          paramInt = 1;
          label236:
          if ((paramInt == 0) || (System.currentTimeMillis() - ((Number)((kotlin.u)localObject3).bsD).longValue() >= l1)) {
            break label727;
          }
          localObject1 = ((azl)((kotlin.u)localObject3).aiuN).liveInfo;
          if (localObject1 != null) {
            break label544;
          }
          localObject1 = "";
          label285:
          localObject2 = ((azl)((kotlin.u)localObject3).aiuN).liveInfo;
          if (localObject2 != null) {
            break label567;
          }
          localObject2 = null;
          label306:
          if (localObject2 != null) {
            break label598;
          }
          localObject2 = e.b.mKf;
          paramInt = e.b.bcu();
          label321:
          localObject2 = ((azl)((kotlin.u)localObject3).aiuN).liveInfo;
          if (localObject2 != null) {
            break label608;
          }
          localObject2 = null;
        }
      }
    }
    for (;;)
    {
      label342:
      label354:
      long l2;
      if (paramIntent == null)
      {
        paramIntent = new Intent();
        if ((paramIntent.getByteArrayExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO") == null) && (localObject3 != null))
        {
          localObject3 = (azl)((kotlin.u)localObject3).aiuN;
          if (localObject3 != null)
          {
            localObject3 = ((azl)localObject3).liveInfo;
            if (localObject3 != null)
            {
              localObject3 = ((bip)localObject3).ZSn;
              if (localObject3 != null) {
                paramIntent.putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO", ((bgr)localObject3).toByteArray());
              }
            }
          }
        }
        localObject3 = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
        if (paramLong2 != null) {
          break label639;
        }
        l1 = 0L;
        label440:
        if (paramLong1 != null) {
          break label649;
        }
        l2 = 0L;
        label447:
        if (paramString3 != null) {
          break label658;
        }
        paramLong1 = "";
        label456:
        if (paramString4 != null) {
          break label664;
        }
      }
      label649:
      label658:
      label664:
      for (paramLong2 = "";; paramLong2 = paramString4)
      {
        kotlin.g.b.s.s(localObject3, "service(IActivityRouter::class.java)");
        com.tencent.mm.plugin.f.a.a((com.tencent.mm.plugin.f)localObject3, paramIntent, paramContext, l1, l2, paramString1, paramLong1, paramLong2, paramString2, 0, "", "", (String)localObject1, Integer.valueOf(paramInt), 0, (byte[])localObject2, false, 40960);
        AppMethodBeat.o(371271);
        return;
        localObject4 = com.tencent.d.a.a.a.a.a.ahiX;
        l1 = com.tencent.d.a.a.a.a.a.jTz() * 1000;
        break;
        label538:
        paramInt = 0;
        break label236;
        label544:
        localObject1 = ((bip)localObject1).mIE;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label285;
        }
        break label285;
        label567:
        localObject2 = ((bip)localObject2).ZRQ;
        if (localObject2 == null)
        {
          localObject2 = null;
          break label306;
        }
        localObject2 = Integer.valueOf(((bmi)localObject2).mNn);
        break label306;
        label598:
        paramInt = ((Integer)localObject2).intValue();
        break label321;
        label608:
        localObject2 = ((bip)localObject2).ZOg;
        if (localObject2 == null)
        {
          localObject2 = null;
          break label342;
        }
        localObject2 = ((dix)localObject2).toByteArray();
        break label342;
        break label354;
        label639:
        l1 = paramLong2.longValue();
        break label440;
        l2 = paramLong1.longValue();
        break label447;
        paramLong1 = paramString3;
        break label456;
      }
      new ac(paramString1, (com.tencent.mm.plugin.findersdk.a.t)new PluginFinderLive.ae(paramString2, paramIntent, paramContext)).bFJ();
      AppMethodBeat.o(371271);
      return;
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
      AppMethodBeat.o(371271);
      return;
      label727:
      paramInt = i;
    }
  }
  
  public final void enterFinderLiveUIByBiz(Context paramContext, String paramString1, String paramString2, Integer paramInteger, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(352242);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject;
    if (paramList1 == null)
    {
      paramList1 = null;
      paramList2 = new com.tencent.mm.plugin.findersdk.b.e();
      paramList2.context = new WeakReference(paramContext);
      if ((paramContext instanceof Activity)) {
        paramList2.show();
      }
      paramContext = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(paramContext, "service(IFinderCommonService::class.java)");
      localObject = (com.tencent.mm.plugin.h)paramContext;
      if (paramString1 != null) {
        break label249;
      }
    }
    label201:
    label233:
    label237:
    label249:
    for (paramContext = "";; paramContext = paramString1)
    {
      h.a.a((com.tencent.mm.plugin.h)localObject, "", 65, "", paramContext).bFJ().g(new PluginFinderLive..ExternalSyntheticLambda1(paramList2, paramInteger, paramList1, paramString1, paramString2));
      AppMethodBeat.o(352242);
      return;
      paramList2 = (Iterable)paramList1;
      paramList1 = (Collection)new ArrayList();
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        localObject = paramList2.next();
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label233;
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label237;
          }
          paramList1.add(localObject);
          break;
          i = 0;
          break label201;
        }
      }
      paramList1 = (List)paramList1;
      break;
    }
  }
  
  public final void enterFinderLiveVisitorUI(Intent paramIntent, Context paramContext, long paramLong, Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(352220);
    kotlin.g.b.s.u(paramString1, "anchorUserName");
    kotlin.g.b.s.u(paramString2, "nonceId");
    kotlin.g.b.s.u(paramString4, "contextId");
    kotlin.g.b.s.u(paramString7, "streamUrl");
    if ((paramContext == null) || (paramLong1 == null))
    {
      AppMethodBeat.o(352220);
      return;
    }
    Object localObject1;
    Object localObject2;
    long l;
    label215:
    Object localObject3;
    if ((!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((bw)com.tencent.mm.kernel.h.ax(bw.class)).eZE()) || (!paramBoolean))
    {
      if (((CharSequence)paramString1).length() == 0) {}
      for (i = 1; i != 0; i = 0)
      {
        com.tencent.mm.ae.d.B((kotlin.g.a.a)new PluginFinderLive.l(paramString2, paramLong, paramString4, paramContext, paramIntent, this, paramLong1, paramString3, paramString5, paramString6));
        AppMethodBeat.o(352220);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(paramString4);
      localObject1 = null;
      localObject2 = (kotlin.u)this.BxJ.get(paramLong1);
      if (((CharSequence)paramString7).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label743;
        }
        if (com.tencent.mm.plugin.findersdk.a.k.Hca <= 0) {
          break label550;
        }
        l = com.tencent.mm.plugin.findersdk.a.k.Hca * 1000;
        localObject3 = l.d.mYm;
        i = l.d.bhr();
        if ((localObject2 == null) || (i != ((Number)((kotlin.u)localObject2).bsC).intValue())) {
          break label568;
        }
        i = 1;
        label249:
        if ((i == 0) || (System.currentTimeMillis() - ((Number)((kotlin.u)localObject2).bsD).longValue() >= l)) {
          break label743;
        }
        paramString7 = ((azl)((kotlin.u)localObject2).aiuN).liveInfo;
        if (paramString7 != null) {
          break label574;
        }
        paramString7 = "";
        label298:
        localObject1 = ((azl)((kotlin.u)localObject2).aiuN).liveInfo;
        if (localObject1 != null) {
          break label597;
        }
        localObject1 = null;
        label319:
        if (localObject1 != null) {
          break label628;
        }
        localObject1 = e.b.mKf;
        paramInt2 = e.b.bcu();
        label334:
        localObject1 = ((azl)((kotlin.u)localObject2).aiuN).liveInfo;
        if (localObject1 != null) {
          break label638;
        }
        localObject1 = null;
      }
    }
    label355:
    label743:
    for (int i = paramInt2;; i = paramInt2)
    {
      if (paramIntent == null)
      {
        paramIntent = new Intent();
        label371:
        if (paramIntent.getIntExtra("KEY_ENTER_LIVE_PARAM_VR_LIVE_TYPE", 0) == 0)
        {
          if (localObject2 != null) {
            break label669;
          }
          paramInt2 = 0;
          paramIntent.putExtra("KEY_ENTER_LIVE_PARAM_VR_LIVE_TYPE", paramInt2);
        }
        if ((paramIntent.getByteArrayExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO") == null) && (localObject2 != null))
        {
          localObject2 = (azl)((kotlin.u)localObject2).aiuN;
          if (localObject2 != null)
          {
            localObject2 = ((azl)localObject2).liveInfo;
            if (localObject2 != null)
            {
              localObject2 = ((bip)localObject2).ZSn;
              if (localObject2 != null) {
                paramIntent.putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO", ((bgr)localObject2).toByteArray());
              }
            }
          }
        }
        localObject2 = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
        if (paramString3 != null) {
          break label718;
        }
        paramString3 = "";
      }
      for (;;)
      {
        kotlin.g.b.s.s(localObject2, "service(IActivityRouter::class.java)");
        com.tencent.mm.plugin.f.a.a((com.tencent.mm.plugin.f)localObject2, paramIntent, paramContext, paramLong, paramLong1.longValue(), paramString1, paramString2, paramString3, paramString4, paramInt1, paramString5, paramString6, paramString7, Integer.valueOf(i), 0, (byte[])localObject1, false, 40960);
        AppMethodBeat.o(352220);
        return;
        i = 0;
        break;
        localObject3 = com.tencent.d.a.a.a.a.a.ahiX;
        l = com.tencent.d.a.a.a.a.a.jTz() * 1000;
        break label215;
        i = 0;
        break label249;
        paramString7 = paramString7.mIE;
        if (paramString7 == null)
        {
          paramString7 = "";
          break label298;
        }
        break label298;
        localObject1 = ((bip)localObject1).ZRQ;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label319;
        }
        localObject1 = Integer.valueOf(((bmi)localObject1).mNn);
        break label319;
        label628:
        paramInt2 = ((Integer)localObject1).intValue();
        break label334;
        label638:
        localObject1 = ((bip)localObject1).ZOg;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label355;
        }
        localObject1 = ((dix)localObject1).toByteArray();
        break label355;
        break label371;
        localObject3 = (azl)((kotlin.u)localObject2).aiuN;
        if (localObject3 == null)
        {
          paramInt2 = 0;
          break label390;
        }
        localObject3 = ((azl)localObject3).liveInfo;
        if (localObject3 == null)
        {
          paramInt2 = 0;
          break label390;
        }
        paramInt2 = ((bip)localObject3).ZSl;
        break label390;
      }
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramContext);
      AppMethodBeat.o(352220);
      return;
    }
  }
  
  public final void enterLiveTaskPage(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(352154);
    kotlin.g.b.s.u(paramActivity, "activity");
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
    kotlin.g.b.s.s(locala, "service(IActivityRouter::class.java)");
    com.tencent.mm.plugin.f.a.a((com.tencent.mm.plugin.f)locala, (Context)paramActivity, paramInt);
    AppMethodBeat.o(352154);
  }
  
  public final void enterPreloadPlayer(long paramLong, String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(352655);
    kotlin.g.b.s.u(paramString, "streamUrl");
    if (!Util.isNullOrNil(paramString))
    {
      localObject = e.b.mKf;
      if ((paramInt == e.b.bcu()) && (paramLong != 0L)) {}
    }
    else
    {
      Log.e("Plugin.FinderLive", "enterPreloadPlayer: preload core fail, streamUrl = " + paramString + ", audienceMode = " + paramInt + ", liveId = " + paramLong);
      AppMethodBeat.o(352655);
      return;
    }
    Log.i("Plugin.FinderLive", kotlin.g.b.s.X("enterPreloadPlayer: start preload core liveId = ", Long.valueOf(paramLong)));
    Object localObject = av.Fui;
    av.eNR();
    localObject = new com.tencent.mm.live.core.core.model.g(null, paramLong, 0, null, 0L, 0L, null, 0, null, 0L, null, null, 131069);
    ((Map)((com.tencent.mm.live.core.core.model.g)localObject).mNt).put(Integer.valueOf(0), new com.tencent.mm.live.core.core.model.j(paramString, 0, ""));
    ((com.tencent.mm.live.core.core.model.g)localObject).mNn = paramInt;
    if (paramArrayOfByte != null)
    {
      paramString = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      if (!com.tencent.mm.plugin.finder.live.model.aj.elz()) {
        break label487;
      }
      if (paramArrayOfByte == null) {}
    }
    label537:
    for (;;)
    {
      try
      {
        paramString = new dix();
        paramString.parseFrom(paramArrayOfByte);
        paramArrayOfByte = new diy();
        paramArrayOfByte.parseFrom(paramString.aaOv.Op);
        paramString = paramArrayOfByte.aaOC;
        paramInt = paramString.aaNO;
        boolean bool = com.tencent.mm.modelcontrol.e.wb(5);
        paramArrayOfByte = ag.CGN;
        ag.qD(bool);
        if ((bool) || (paramInt != com.tencent.mm.live.core.core.a.mJu.value)) {
          break label537;
        }
        paramInt = paramString.aaNP;
        ((com.tencent.mm.live.core.core.model.g)localObject).mNs = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveVideoDefinitionStorage().oD(paramLong);
        ((com.tencent.mm.live.core.core.model.g)localObject).mJU = paramString.aaNP;
        if (paramInt >= 100) {
          break label493;
        }
        ((com.tencent.mm.live.core.core.model.g)localObject).a(com.tencent.mm.live.core.core.model.a.mMz);
        ((com.tencent.mm.live.core.core.model.g)localObject).mNr = paramInt;
        paramString = paramString.aaNK;
        if (paramString != null)
        {
          paramString = ((Iterable)paramString).iterator();
          if (paramString.hasNext())
          {
            paramArrayOfByte = (xb)paramString.next();
            Map localMap = (Map)((com.tencent.mm.live.core.core.model.g)localObject).mNt;
            paramInt = paramArrayOfByte.ZeQ;
            String str = paramArrayOfByte.url;
            kotlin.g.b.s.s(str, "it.url");
            localMap.put(Integer.valueOf(paramInt), new com.tencent.mm.live.core.core.model.j(str, paramArrayOfByte.ZeS, paramArrayOfByte.ZeT));
            continue;
          }
        }
        kotlinx.coroutines.j.a(kotlinx.coroutines.ar.d((kotlin.d.f)bg.kCi()), null, null, (kotlin.g.a.m)new m((com.tencent.mm.live.core.core.model.g)localObject, null), 3);
      }
      finally
      {
        Log.e("Plugin.FinderLive", "enterPreloadPlayer: parse fail");
      }
      AppMethodBeat.o(352655);
      return;
      label487:
      paramArrayOfByte = null;
      break;
      label493:
      if (paramInt == com.tencent.mm.live.core.core.a.mJv.value) {
        ((com.tencent.mm.live.core.core.model.g)localObject).a(com.tencent.mm.live.core.core.model.a.mMA);
      } else if (paramInt == com.tencent.mm.live.core.core.a.mJw.value) {
        ((com.tencent.mm.live.core.core.model.g)localObject).a(com.tencent.mm.live.core.core.model.a.mMB);
      }
    }
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(352062);
    kotlin.g.b.s.u(paramg, "profile");
    AppMethodBeat.o(352062);
  }
  
  public final Object executeCirculationFillingActivityIcon(final Context paramContext, final long paramLong, String paramString, final ImageView paramImageView, final int paramInt, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(352619);
    paramContext = kotlinx.coroutines.l.a((kotlin.d.f)bg.kCh(), (kotlin.g.a.m)new n(this, paramInt, paramContext, paramLong, paramString, paramImageView, null), paramd);
    if (paramContext == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(352619);
      return paramContext;
    }
    paramContext = ah.aiuX;
    AppMethodBeat.o(352619);
    return paramContext;
  }
  
  public final void fillAuthIcon(TextView paramTextView, ImageView paramImageView, com.tencent.mm.plugin.findersdk.a.b paramb, float paramFloat)
  {
    AppMethodBeat.i(352607);
    if (paramImageView != null)
    {
      Object localObject;
      if (paramb != null)
      {
        localObject = paramb.HbV;
        if (localObject != null)
        {
          localObject = ((bmr)localObject).ZVk;
          if (localObject != null) {
            if (((CharSequence)localObject).length() > 0)
            {
              i = 1;
              if (i != 1) {
                break label141;
              }
            }
          }
        }
      }
      label141:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label147;
        }
        localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
        paramb = new com.tencent.mm.plugin.finder.loader.s(paramb.HbV.ZVk, com.tencent.mm.plugin.finder.storage.v.FKZ);
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject).a(paramb, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ)).d(paramImageView);
        paramImageView.setVisibility(0);
        fillAuthIcon$setNicknamePaddingEnd(paramTextView, paramFloat, true);
        AppMethodBeat.o(352607);
        return;
        i = 0;
        break;
      }
      label147:
      if (paramb != null) {
        break label181;
      }
      paramb = null;
      if (paramb != null) {
        break label206;
      }
      label157:
      if (paramb != null) {
        break label247;
      }
    }
    label181:
    label206:
    label247:
    while (paramb.intValue() != 2)
    {
      paramImageView.setVisibility(8);
      fillAuthIcon$setNicknamePaddingEnd(paramTextView, paramFloat, false);
      AppMethodBeat.o(352607);
      return;
      paramb = paramb.HbV;
      if (paramb == null)
      {
        paramb = null;
        break;
      }
      paramb = Integer.valueOf(paramb.authIconType);
      break;
      if (paramb.intValue() != 1) {
        break label157;
      }
      paramImageView.setImageDrawable(com.tencent.mm.cd.a.m(paramImageView.getContext(), p.g.icons_filled_star_identify_sold));
      paramImageView.setVisibility(0);
      fillAuthIcon$setNicknamePaddingEnd(paramTextView, paramFloat, true);
      AppMethodBeat.o(352607);
      return;
    }
    paramImageView.setImageDrawable(com.tencent.mm.cd.a.m(paramImageView.getContext(), p.g.icons_filled_star_identify_enterprise_sold));
    paramImageView.setVisibility(0);
    fillAuthIcon$setNicknamePaddingEnd(paramTextView, paramFloat, true);
    AppMethodBeat.o(352607);
  }
  
  public final void forceStopCurLive()
  {
    AppMethodBeat.i(352160);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.elI();
    AppMethodBeat.o(352160);
  }
  
  public final void gameLiveShare(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(352285);
    Object localObject = com.tencent.mm.plugin.finder.utils.t.GgN;
    Log.i(com.tencent.mm.plugin.finder.utils.t.TAG, "dealShare, businessType:" + paramString1 + ", appid:" + paramString2 + ", extInfo:" + paramString3);
    if ((paramString3 == null) || (Util.isNullOrNil(paramString3)) || (paramString1 == null) || (Util.isNullOrNil(paramString1)) || (paramString2 == null) || (Util.isNullOrNil(paramString2)))
    {
      com.tencent.mm.plugin.finder.utils.t.ao("appid or extInfo empty", paramString1, paramString2);
      AppMethodBeat.o(352285);
      return;
    }
    fby localfby;
    if (com.tencent.mm.plugin.finder.utils.t.f(paramString1, paramString2, paramString3, paramBoolean))
    {
      localObject = com.tencent.mm.plugin.finder.utils.s.GgL;
      com.tencent.mm.plugin.finder.utils.s.qF(19L);
      localObject = new Intent();
      localfby = new fby();
      etj localetj = new etj();
      localetj.businessType = paramString1;
      localetj.appid = paramString2;
      localetj.extInfo = paramString3;
      paramString1 = ah.aiuX;
      localfby.abBz = localetj;
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString3);
        int i = paramString1.getInt(com.tencent.mm.plugin.finder.utils.t.GgO);
        switch (i)
        {
        default: 
          AppMethodBeat.o(352285);
          return;
        }
      }
      finally {}
      com.tencent.mm.plugin.finder.utils.t.a(paramString1, paramString2, (Intent)localObject);
      AppMethodBeat.o(352285);
      return;
      AppMethodBeat.o(352285);
      return;
      com.tencent.mm.plugin.finder.utils.t.a(paramString1, (Intent)localObject, localfby, paramString2);
      AppMethodBeat.o(352285);
      return;
      com.tencent.mm.plugin.finder.utils.t.c(1, paramString1);
      AppMethodBeat.o(352285);
      return;
      com.tencent.mm.plugin.finder.utils.t.c(0, paramString1);
      AppMethodBeat.o(352285);
      return;
      com.tencent.mm.plugin.finder.utils.t.c(2, paramString1);
    }
  }
  
  public final com.tencent.d.a.a.a.d.a getFinderLiveActionRecordStorage()
  {
    AppMethodBeat.i(352028);
    com.tencent.d.a.a.a.d.a locala = (com.tencent.d.a.a.a.d.a)getLiveActionRecordStorage();
    AppMethodBeat.o(352028);
    return locala;
  }
  
  public final com.tencent.d.a.a.a.d.b getFinderLiveChargeInfoStorage()
  {
    AppMethodBeat.i(352048);
    com.tencent.d.a.a.a.d.b localb = (com.tencent.d.a.a.a.d.b)getFinderLiveChargeInfoStorage();
    AppMethodBeat.o(352048);
    return localb;
  }
  
  public final com.tencent.mm.plugin.finder.live.storage.c getFinderLiveConfigStorage()
  {
    AppMethodBeat.i(352014);
    com.tencent.mm.plugin.finder.live.storage.c localc = getLiveConfigStorage();
    AppMethodBeat.o(352014);
    return localc;
  }
  
  public final com.tencent.d.a.a.a.d.d getFinderLiveDislikeBannerStorage()
  {
    AppMethodBeat.i(352034);
    com.tencent.d.a.a.a.d.d locald = (com.tencent.d.a.a.a.d.d)getFinderLiveDislikeBannerStorage();
    AppMethodBeat.o(352034);
    return locald;
  }
  
  public final bgt getFinderLiveExternalInfo()
  {
    AppMethodBeat.i(352428);
    Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    localObject = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveExternalInfo();
    AppMethodBeat.o(352428);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.live.storage.e getFinderLiveGiftStorage()
  {
    AppMethodBeat.i(351988);
    com.tencent.mm.plugin.finder.live.storage.e locale = getLiveGiftStorage();
    AppMethodBeat.o(351988);
    return locale;
  }
  
  public final com.tencent.mm.plugin.finder.live.storage.f getFinderLiveLastRewardInfoStorage()
  {
    AppMethodBeat.i(352002);
    com.tencent.mm.plugin.finder.live.storage.f localf = getLiveLastRewardInfoStorage();
    AppMethodBeat.o(352002);
    return localf;
  }
  
  public final com.tencent.mm.plugin.finder.live.storage.g getFinderLiveLuckyMoneyStorage()
  {
    AppMethodBeat.i(351993);
    com.tencent.mm.plugin.finder.live.storage.g localg = getLiveLuckyMoneyStorage();
    AppMethodBeat.o(351993);
    return localg;
  }
  
  public final void getFinderLiveMemberListInfo(ca.a<List<bjk>> parama)
  {
    AppMethodBeat.i(352434);
    kotlin.g.b.s.u(parama, "callback");
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveMemberListInfo(parama);
    AppMethodBeat.o(352434);
  }
  
  public final com.tencent.mm.plugin.finder.live.storage.h getFinderLiveNotifyExposureInfoStorage()
  {
    AppMethodBeat.i(352020);
    com.tencent.mm.plugin.finder.live.storage.h localh = getLiveNotifyExposureInfoStorage();
    AppMethodBeat.o(352020);
    return localh;
  }
  
  public final void getFinderLivePreviewUrl(String paramString1, String paramString2, int paramInt, kotlin.g.a.q<? super String, ? super String, ? super Integer, ah> paramq)
  {
    AppMethodBeat.i(352468);
    kotlin.g.b.s.u(paramq, "callback");
    com.tencent.mm.plugin.h localh = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    kotlin.g.b.s.s(localh, "service(IFinderCommonService::class.java)");
    h.a.a(localh, paramString2, paramInt, "", str).bFJ().g(new PluginFinderLive..ExternalSyntheticLambda3(paramq));
    AppMethodBeat.o(352468);
  }
  
  public final Integer getFinderLiveStatusFromTag(View paramView1, View paramView2)
  {
    AppMethodBeat.i(352750);
    if (((paramView2 instanceof FinderLiveOnliveWidget)) && (((FinderLiveOnliveWidget)paramView2).getVisibility() == 0))
    {
      Log.i("Plugin.FinderLive", "getFinderLiveStatusFromTag liveEndTag visible!");
      AppMethodBeat.o(352750);
      return Integer.valueOf(0);
    }
    if (((paramView1 instanceof FinderLiveOnliveWidget)) && (((FinderLiveOnliveWidget)paramView1).getVisibility() == 0))
    {
      paramView1 = ((FinderLiveOnliveWidget)paramView1).getText();
      Log.i("Plugin.FinderLive", "getFinderLiveStatusFromTag liveTag visible,text:" + paramView1 + '!');
      if (Util.isEqual(paramView1, MMApplicationContext.getContext().getResources().getString(p.h.Cjn)))
      {
        AppMethodBeat.o(352750);
        return Integer.valueOf(0);
      }
      if (Util.isEqual(paramView1, MMApplicationContext.getContext().getResources().getString(p.h.Cjk)))
      {
        AppMethodBeat.o(352750);
        return Integer.valueOf(6);
      }
      if (Util.isEqual(paramView1, MMApplicationContext.getContext().getResources().getString(p.h.Cjf)))
      {
        AppMethodBeat.o(352750);
        return Integer.valueOf(2);
      }
      AppMethodBeat.o(352750);
      return null;
    }
    Log.i("Plugin.FinderLive", "getFinderLiveStatusFromTag all tag invisible!");
    AppMethodBeat.o(352750);
    return null;
  }
  
  public final com.tencent.d.a.a.a.d.i getFinderLiveVideoDefinitionStorage()
  {
    AppMethodBeat.i(352042);
    com.tencent.d.a.a.a.d.i locali = (com.tencent.d.a.a.a.d.i)getFinderLiveVideoDefinitionStorage();
    AppMethodBeat.o(352042);
    return locali;
  }
  
  public final int getImageResFromActivityType(int paramInt)
  {
    AppMethodBeat.i(352592);
    f.a.a locala = com.tencent.d.a.b.a.f.a.ahpZ;
    paramInt = f.a.a.getImageResFromActivityType(paramInt);
    AppMethodBeat.o(352592);
    return paramInt;
  }
  
  public final void getLiveInfo(long paramLong, boolean paramBoolean, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, b.d paramd)
  {
    AppMethodBeat.i(352112);
    this.BxK.post(new PluginFinderLive..ExternalSyntheticLambda6(this, paramLong, paramBoolean, paramb, paramd));
    AppMethodBeat.o(352112);
  }
  
  public final bmq getLiveSettlementInfo()
  {
    AppMethodBeat.i(352587);
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    bmq localbmq = new bmq();
    localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    localbmq.enable = com.tencent.mm.ae.d.ee((int)com.tencent.mm.plugin.finder.api.d.a.dUc().field_liveSwitchFlag, 512);
    localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject = com.tencent.mm.plugin.finder.api.d.a.dUc().field_settlementInfo;
    if (localObject == null)
    {
      localObject = "";
      localbmq.ZVg = ((String)localObject);
      localObject = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject = com.tencent.mm.plugin.finder.api.d.a.dUc().field_settlementInfo;
      if (localObject != null) {
        break label113;
      }
      localObject = "";
    }
    for (;;)
    {
      localbmq.mdK = ((String)localObject);
      AppMethodBeat.o(352587);
      return localbmq;
      String str = ((fat)localObject).ZVg;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label113:
      str = ((fat)localObject).mdK;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public final String getLocalPushStreamPath()
  {
    return this.BxR;
  }
  
  public final String getTopic()
  {
    AppMethodBeat.i(352782);
    Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if (localObject == null)
    {
      AppMethodBeat.o(352782);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).desc;
    AppMethodBeat.o(352782);
    return localObject;
  }
  
  public final androidx.lifecycle.aj getViewModelStore()
  {
    return this.er;
  }
  
  public final void goToAnchorLiveDirect(final Activity paramActivity, kotlin.g.a.a<ah> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(352450);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(parama, "finishCallback");
    Log.i("Plugin.FinderLive", "#goToAnchorLiveDirect");
    final com.tencent.mm.plugin.finder.live.ui.livepost.c localc = new com.tencent.mm.plugin.finder.live.ui.livepost.c(paramActivity);
    localc.DIe = ((kotlin.g.a.a)new t(parama, localc, paramActivity, paramBoolean));
    localc.eul();
    AppMethodBeat.o(352450);
  }
  
  public final void gotoLive(Context paramContext, String paramString, brs parambrs, dwa paramdwa)
  {
    AppMethodBeat.i(352793);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramdwa, "reportData");
    Object localObject = (CharSequence)paramString;
    int i;
    com.tencent.mm.plugin.g localg;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label131;
      }
      Log.i("Plugin.FinderLive", kotlin.g.b.s.X("gotoLive anchorUsername:", paramString));
      localg = (com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
      if (paramString != null) {
        break label125;
      }
    }
    label125:
    for (localObject = "";; localObject = paramString)
    {
      localg.a((String)localObject, (com.tencent.mm.plugin.findersdk.a.t)new PluginFinderLive.u(paramString, paramContext, this, paramdwa, parambrs)).bFJ();
      AppMethodBeat.o(352793);
      return;
      i = 0;
      break;
    }
    label131:
    Log.i("Plugin.FinderLive", "[LiveLogoAssistant]click live icon but username is empty!");
    AppMethodBeat.o(352793);
  }
  
  public final void initOlympicsReport(dwa paramdwa)
  {
    AppMethodBeat.i(352805);
    kotlin.g.b.s.u(paramdwa, "reportData");
    Object localObject1 = com.tencent.mm.plugin.finder.live.olympic.report.b.CRS;
    kotlin.g.b.s.u(paramdwa, "reportData");
    Log.i(com.tencent.mm.plugin.finder.live.olympic.report.b.TAG, kotlin.g.b.s.X("reportOnClick reportData=", com.tencent.mm.plugin.finder.live.olympic.report.b.a(paramdwa)));
    com.tencent.mm.plugin.finder.live.olympic.report.b.CRU = paramdwa;
    int i = paramdwa.abbK;
    localObject1 = paramdwa.finderUsername;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    Object localObject3 = paramdwa.hLv;
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    Object localObject4 = paramdwa.hJW;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    int j = paramdwa.abbL;
    com.tencent.mm.plugin.finder.live.olympic.report.b.CRT.clear();
    localObject4 = com.tencent.d.a.a.a.b.b.e.ahon;
    if (i == b.e.a.jVX())
    {
      localObject1 = com.tencent.mm.plugin.finder.live.olympic.report.b.awO((String)localObject3);
      com.tencent.mm.plugin.finder.live.olympic.report.b.CRT.put("finder_username", localObject2);
      com.tencent.mm.plugin.finder.live.olympic.report.b.CRV = paramdwa.CRV;
      paramdwa = (dwa)localObject1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.aqz(paramdwa);
      AppMethodBeat.o(352805);
      return;
      paramdwa = com.tencent.d.a.a.a.b.b.e.ahon;
      if (i == b.e.a.jVY())
      {
        paramdwa = q.n.DtQ.scene;
        com.tencent.mm.plugin.finder.live.olympic.report.b.CRT.put("finder_username", localObject2);
      }
      else
      {
        paramdwa = com.tencent.d.a.a.a.b.b.e.ahon;
        if (i == b.e.a.jVZ())
        {
          paramdwa = q.n.DtO.scene;
          com.tencent.mm.plugin.finder.live.olympic.report.b.CRT.put("username", localObject1);
        }
        else
        {
          paramdwa = com.tencent.d.a.a.a.b.b.e.ahon;
          if (i == b.e.a.jWa())
          {
            paramdwa = q.n.DtP.scene;
            com.tencent.mm.plugin.finder.live.olympic.report.b.CRT.put("username", localObject1);
          }
          else
          {
            paramdwa = com.tencent.d.a.a.a.b.b.e.ahon;
            if (i == b.e.a.jWb())
            {
              paramdwa = q.n.Dty.scene;
              com.tencent.mm.plugin.finder.live.olympic.report.b.CRT.put("username", localObject1);
              com.tencent.mm.plugin.finder.live.olympic.report.b.CRT.put("is_certificate_type", String.valueOf(j));
            }
            else
            {
              paramdwa = com.tencent.d.a.a.a.b.b.e.ahon;
              if (i == b.e.a.jWc())
              {
                paramdwa = "temp_6";
                com.tencent.mm.plugin.finder.live.olympic.report.b.CRT.put("username", localObject1);
                com.tencent.mm.plugin.finder.live.olympic.report.b.CRT.put("is_certificate_type", String.valueOf(j));
              }
              else
              {
                paramdwa = "";
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean isAnchorLiving()
  {
    AppMethodBeat.i(352251);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    boolean bool = com.tencent.mm.plugin.finder.live.model.aj.isAnchorLiving();
    AppMethodBeat.o(352251);
    return bool;
  }
  
  public final boolean isChargeLive(bip parambip)
  {
    if ((parambip != null) && (parambip.liveStatus == 1))
    {
      i = 1;
      if (i == 0) {
        break label53;
      }
      parambip = parambip.ZSc;
      if ((parambip == null) || (parambip.ZGN != 2)) {
        break label48;
      }
    }
    label48:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label53;
      }
      return true;
      i = 0;
      break;
    }
    label53:
    return false;
  }
  
  public final boolean isChatRoomDisable(String paramString)
  {
    AppMethodBeat.i(371318);
    ai localai = ai.akfD;
    if ((ai.isChatRoomDismiss(paramString)) || (ai.isNotInChatRoom(paramString)))
    {
      AppMethodBeat.o(371318);
      return true;
    }
    AppMethodBeat.o(371318);
    return false;
  }
  
  public final boolean isFinderLiveActivityIconEntranceEnable()
  {
    AppMethodBeat.i(352631);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jUd().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(352631);
      return true;
    }
    AppMethodBeat.o(352631);
    return false;
  }
  
  public final boolean isFinderLiveActivityIconSharedEnable()
  {
    AppMethodBeat.i(352636);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jUe().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(352636);
      return true;
    }
    AppMethodBeat.o(352636);
    return false;
  }
  
  public final a.b isGameAnchorLiving(String paramString)
  {
    AppMethodBeat.i(352457);
    kotlin.g.b.s.u(paramString, "appId");
    Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    kotlin.g.b.s.u(paramString, "appId");
    if (com.tencent.mm.plugin.finder.live.model.aj.isAnchorLiving())
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject == null) {}
      for (localObject = null; paramString.equals(localObject); localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Eeu)
      {
        paramString = a.b.ahiS;
        AppMethodBeat.o(352457);
        return paramString;
      }
      paramString = a.b.ahiT;
      AppMethodBeat.o(352457);
      return paramString;
    }
    paramString = a.b.ahiR;
    AppMethodBeat.o(352457);
    return paramString;
  }
  
  public final boolean isLiveTaskEnable(String paramString)
  {
    AppMethodBeat.i(352146);
    kotlin.g.b.s.u(paramString, "entrance");
    com.tencent.mm.plugin.finder.api.d.a locala = com.tencent.mm.plugin.finder.api.d.AwY;
    boolean bool = com.tencent.mm.plugin.finder.api.d.a.auX(paramString);
    AppMethodBeat.o(352146);
    return bool;
  }
  
  public final boolean isNewLiveEntranceEnable()
  {
    AppMethodBeat.i(352624);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jUc().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(352624);
      return true;
    }
    AppMethodBeat.o(352624);
    return false;
  }
  
  public final boolean isReplayLive(View paramView1, View paramView2, long paramLong)
  {
    AppMethodBeat.i(352709);
    paramView1 = getFinderLiveStatusFromTag(paramView1, paramView2);
    if (paramView1 != null)
    {
      if (((Number)paramView1).intValue() == 6)
      {
        AppMethodBeat.o(352709);
        return true;
      }
      AppMethodBeat.o(352709);
      return false;
    }
    paramView1 = (kotlin.u)this.BxJ.get(Long.valueOf(paramLong));
    if (paramView1 == null) {
      paramView1 = null;
    }
    for (;;)
    {
      boolean bool = isReplayLive(paramView1);
      Log.i("Plugin.FinderLive", "liveId:" + paramLong + " is replay:" + bool);
      AppMethodBeat.o(352709);
      return bool;
      paramView1 = (azl)paramView1.aiuN;
      if (paramView1 == null) {
        paramView1 = null;
      } else {
        paramView1 = paramView1.liveInfo;
      }
    }
  }
  
  public final boolean isReplayLive(bip parambip)
  {
    AppMethodBeat.i(352701);
    if ((parambip != null) && (parambip.liveStatus == 2))
    {
      i = 1;
      if ((i == 0) || (parambip.replay_status != 1)) {
        break label77;
      }
      parambip = (CharSequence)parambip.ZRm;
      if ((parambip != null) && (parambip.length() != 0)) {
        break label72;
      }
    }
    label72:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label77;
      }
      AppMethodBeat.o(352701);
      return true;
      i = 0;
      break;
    }
    label77:
    AppMethodBeat.o(352701);
    return false;
  }
  
  public final boolean isUnPurchasedChargeLive(bip parambip)
  {
    AppMethodBeat.i(352695);
    if (isChargeLive(parambip))
    {
      if (parambip != null)
      {
        parambip = parambip.ZSc;
        if ((parambip == null) || (parambip.ZUj != true)) {}
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(352695);
        return true;
      }
    }
    AppMethodBeat.o(352695);
    return false;
  }
  
  public final boolean isVisitorLiving()
  {
    AppMethodBeat.i(352258);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    boolean bool = com.tencent.mm.plugin.finder.live.model.aj.isVisitorLiving();
    AppMethodBeat.o(352258);
    return bool;
  }
  
  public final void loadMicInfos(String paramString1, String paramString2, kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super aub, ah> paramr)
  {
    AppMethodBeat.i(352683);
    kotlin.g.b.s.u(paramString1, "encryptedId");
    kotlin.g.b.s.u(paramString2, "nonceId");
    kotlin.g.b.s.u(paramr, "callback");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new kotlin.r(paramString1, paramString2));
    ah localah = ah.aiuX;
    new com.tencent.mm.plugin.finder.cgi.g((List)localArrayList, (byte)0).bFJ().g(new PluginFinderLive..ExternalSyntheticLambda2(paramString1, paramString2, paramr));
    AppMethodBeat.o(352683);
  }
  
  public final void loadOlympicsImage(ImageView paramImageView, b.j paramj, int paramInt)
  {
    AppMethodBeat.i(352813);
    kotlin.g.b.s.u(paramImageView, "imageView");
    kotlin.g.b.s.u(paramj, "resType");
    com.tencent.mm.plugin.finder.live.olympic.util.a locala = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    com.tencent.mm.plugin.finder.live.olympic.util.a.a(paramImageView, paramj, paramInt);
    AppMethodBeat.o(352813);
  }
  
  public final Object loadVisitorCore(com.tencent.mm.live.core.core.model.g paramg, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(352660);
    paramg = ((com.tencent.mm.plugin.datapreloader.a)new com.tencent.mm.plugin.finder.live.preloader.b(paramg, bg.kCg())).e(true, paramd);
    if (paramg == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(352660);
      return paramg;
    }
    paramg = ah.aiuX;
    AppMethodBeat.o(352660);
    return paramg;
  }
  
  public final void mixExternalAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(352504);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.mixExternalAudioFrame(paramArrayOfByte, paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(352504);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(352080);
    paramc = j.Bxr;
    j.init();
    paramc = com.tencent.mm.plugin.finder.live.view.d.DOz;
    com.tencent.mm.plugin.finder.live.view.d.a.evw();
    paramc = com.tencent.mm.plugin.finder.live.view.d.DOz;
    com.tencent.mm.plugin.finder.live.view.d.a.evw();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("finderliveclosenotifymsg", (com.tencent.mm.plugin.messenger.foundation.a.s)this.BxL);
    com.tencent.mm.am.f.a.a((com.tencent.mm.am.f)this.BxM);
    this.mIj.alive();
    paramc = bl.GlV;
    bl.fif().alive();
    paramc = bl.GlV;
    bl.fig().alive();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).a("2", (o)new com.tencent.mm.plugin.finder.live.status.b());
    ((n)com.tencent.mm.kernel.h.ax(n.class)).a("13", (o)new com.tencent.mm.plugin.finder.live.status.c());
    com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.BxN);
    com.tencent.mm.kernel.h.b(at.class, (com.tencent.mm.kernel.c.a)this.BxN);
    com.tencent.mm.kernel.h.b(com.tencent.d.a.a.a.c.a.class, (com.tencent.mm.kernel.c.a)this.BxO);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.g.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.b());
    ((com.tencent.mm.plugin.messenger.foundation.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.b.class)).a((com.tencent.mm.plugin.messenger.foundation.a.a)new com.tencent.mm.plugin.finder.extension.b());
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.k.class, (com.tencent.mm.kernel.c.a)this.BxP);
    com.tencent.mm.kernel.h.b(ce.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.finder.live.report.j.Dob);
    com.tencent.mm.kernel.h.b(cf.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.finder.live.report.k.Doi);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.aq.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.finder.live.utils.fake.a.DKg);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.aj.class, (com.tencent.mm.kernel.c.a)a.BvB);
    paramc = com.tencent.mm.plugin.finder.live.model.ar.CIh;
    com.tencent.mm.plugin.finder.live.model.ar.emk();
    AppForegroundDelegate.heY.a((com.tencent.mm.app.q)this.BxS);
    registerScreenReceiver();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(105);
    AppMethodBeat.o(352080);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(352094);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("finderliveclosenotifymsg", (com.tencent.mm.plugin.messenger.foundation.a.s)this.BxL);
    Object localObject = com.tencent.mm.plugin.finder.live.view.d.DOz;
    com.tencent.mm.plugin.finder.live.view.d.a.evx();
    this.mIj.dead();
    com.tencent.mm.am.f.a.b((com.tencent.mm.am.f)this.BxM);
    localObject = com.tencent.mm.plugin.finder.feed.model.j.BfL;
    com.tencent.mm.plugin.finder.feed.model.j.clear();
    this.er.clear();
    com.tencent.mm.kernel.h.ay(at.class);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.BxN);
    localObject = com.tencent.mm.plugin.finder.live.view.d.DOz;
    com.tencent.mm.plugin.finder.live.view.d.a.evx();
    localObject = com.tencent.mm.plugin.finder.feed.model.j.BfL;
    com.tencent.mm.plugin.finder.feed.model.j.clear();
    ((com.tencent.mm.plugin.messenger.foundation.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.b.class)).gaS();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bdp("2");
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bdp("13");
    com.tencent.mm.kernel.h.ay(com.tencent.d.a.a.a.c.a.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.g.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.k.class);
    com.tencent.mm.kernel.h.ay(ce.class);
    com.tencent.mm.kernel.h.ay(cf.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.findersdk.a.aq.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.findersdk.a.aj.class);
    localObject = bl.GlV;
    bl.fif().dead();
    localObject = bl.GlV;
    bl.fig().dead();
    AppForegroundDelegate.heY.b((com.tencent.mm.app.q)this.BxS);
    unregisterScreenReceiver();
    AppMethodBeat.o(352094);
  }
  
  public final void openFinderLive(JSONObject paramJSONObject, ca.a<Integer> parama, ca.a<Object> parama1, String paramString)
  {
    AppMethodBeat.i(352181);
    kotlin.g.b.s.u(paramJSONObject, "extInfo");
    kotlin.g.b.s.u(paramString, "appid");
    Object localObject2 = paramJSONObject.optString("feedID");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str1 = paramJSONObject.optString("nonceID");
    localObject2 = str1;
    if (str1 == null) {
      localObject2 = "";
    }
    int j = paramJSONObject.optInt("commentScene");
    String str2 = paramJSONObject.optString("reportExtraInfo", "");
    Object localObject3 = paramJSONObject.optString("sceneNote", "");
    boolean bool = paramJSONObject.optBoolean("showRecommend", false);
    paramJSONObject = aw.Gjk;
    int i;
    if (aw.aBT(str2))
    {
      i = 4;
      str1 = genContextId(j, i, 65);
      if (!Util.isNullOrNil(paramString))
      {
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (str1 != null) {
          break label367;
        }
        paramJSONObject = "";
        label159:
        localh.b(21140, new Object[] { paramJSONObject, paramString, "", "" });
      }
      paramJSONObject = com.tencent.mm.plugin.finder.live.report.k.Doi;
      kotlin.g.b.s.s(localObject3, "sceneNote");
      if (((CharSequence)localObject3).length() <= 0) {
        break label373;
      }
      i = 1;
      label220:
      if (i == 0) {
        break label379;
      }
    }
    label367:
    label373:
    label379:
    for (paramJSONObject = (JSONObject)localObject3;; paramJSONObject = paramString)
    {
      com.tencent.mm.plugin.finder.live.report.k.axs(paramJSONObject);
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(str1);
      com.tencent.mm.plugin.expt.hellhound.a.aqz(q.n.DtE.scene);
      paramJSONObject = new bkr();
      paramJSONObject.hUo = 1;
      paramJSONObject.YPU = paramString;
      paramString = kotlin.a.ak.f(new kotlin.r[] { kotlin.v.Y("key_finder_show_recommend", Boolean.valueOf(bool)) });
      localObject3 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject3, "service(IFinderCommonService::class.java)");
      localObject3 = (com.tencent.mm.plugin.h)localObject3;
      parama1 = (ca.a)new PluginFinderLive.ab(parama1);
      kotlin.g.b.s.s(str2, "extraInfo");
      ((com.tencent.mm.plugin.h)localObject3).a("", (String)localObject1, parama, (String)localObject2, parama1, str1, str2, paramJSONObject, paramString);
      AppMethodBeat.o(352181);
      return;
      i = 2;
      break;
      paramJSONObject = str1;
      break label159;
      i = 0;
      break label220;
    }
  }
  
  public final List<ImageSpan> parseAllBadgeInfos(List<? extends bfl> paramList, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(352761);
    kotlin.g.b.s.u(paramList, "info");
    kotlin.g.b.s.u(paramArrayOfInt, "spanFilter");
    com.tencent.mm.plugin.finder.live.view.span.h localh = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
    paramList = com.tencent.mm.plugin.finder.live.view.span.h.a(paramList, paramArrayOfInt, paramInt1, paramInt2, 0, null, 48);
    AppMethodBeat.o(352761);
    return paramList;
  }
  
  public final void pauseLive(int paramInt)
  {
    AppMethodBeat.i(352535);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.pauseLive(paramInt);
    AppMethodBeat.o(352535);
  }
  
  public final void pauseVisitorLive()
  {
    AppMethodBeat.i(352672);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.pauseVisitorLive();
    AppMethodBeat.o(352672);
  }
  
  public final boolean producingReplay(bip parambip)
  {
    AppMethodBeat.i(352715);
    if ((parambip != null) && (parambip.liveStatus == 2))
    {
      i = 1;
      if ((i == 0) || (parambip.replay_status != 1)) {
        break label77;
      }
      parambip = (CharSequence)parambip.ZRm;
      if ((parambip != null) && (parambip.length() != 0)) {
        break label72;
      }
    }
    label72:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label77;
      }
      AppMethodBeat.o(352715);
      return true;
      i = 0;
      break;
    }
    label77:
    AppMethodBeat.o(352715);
    return false;
  }
  
  public final void registerExternalLiveCallback(com.tencent.d.a.a.a.a parama)
  {
    AppMethodBeat.i(352413);
    if (parama != null)
    {
      com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      com.tencent.mm.plugin.finder.live.model.aj.registerExternalLiveCallback(parama);
    }
    AppMethodBeat.o(352413);
  }
  
  public final void reportFinderLiveReplay(long paramLong, String paramString)
  {
    AppMethodBeat.i(352735);
    kotlin.g.b.s.u(paramString, "pageType");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("object_id", com.tencent.mm.ae.d.hF(paramLong));
    ((JSONObject)localObject).put("page_type", paramString);
    paramString = (ce)com.tencent.mm.kernel.h.ax(ce.class);
    String str = q.bj.DBg.event;
    localObject = ((JSONObject)localObject).toString();
    kotlin.g.b.s.s(localObject, "this.toString()");
    paramString.hP(str, (String)localObject);
    AppMethodBeat.o(352735);
  }
  
  public final void reportPlayGamePanelShowAction(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(352569);
    kotlin.g.b.s.u(paramJSONObject, "jo");
    com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrV, paramJSONObject.toString());
    AppMethodBeat.o(352569);
  }
  
  public final void requestFinderLiveNotify(String paramString)
  {
    AppMethodBeat.i(352125);
    kotlin.g.b.s.u(paramString, "json");
    com.tencent.mm.plugin.finder.extension.a locala = this.BxM;
    Log.i("Finder.FinderLiveNotifyFuncMsgExtension", "requestFinderLiveNotify");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(".sysmsg.functionmsg.cgi", "/cgi-bin/micromsg-bin/findergetlivetips");
    ((Map)localHashMap).put(".sysmsg.functionmsg.cmdid", "6407");
    Map localMap = (Map)localHashMap;
    StringBuilder localStringBuilder = new StringBuilder("client_findergetlivetips_");
    com.tencent.mm.kernel.h.baC();
    localMap.put(".sysmsg.functionmsg.functionmsgid", com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond());
    ((Map)localHashMap).put(".sysmsg.functionmsg.businessid", "70001");
    ((Map)localHashMap).put(".sysmsg.functionmsg.reportid", "1559");
    ((Map)localHashMap).put(".sysmsg.functionmsg.successkey", "222");
    locala.AOY = ((String)localHashMap.get(".sysmsg.functionmsg.functionmsgid"));
    locala.APa = paramString;
    ((com.tencent.mm.api.z)com.tencent.mm.kernel.h.az(com.tencent.mm.api.z.class)).getReceiver().a(new dl(), (Map)localHashMap, "requestFinderLiveNotify");
    AppMethodBeat.o(352125);
  }
  
  public final void requestFinderLiveNotifyOnLiveClose(String paramString)
  {
    AppMethodBeat.i(352138);
    kotlin.g.b.s.u(paramString, "funcMsgId");
    com.tencent.mm.plugin.finder.extension.a locala = this.BxM;
    kotlin.g.b.s.u(paramString, "funcMsgId");
    Log.i("Finder.FinderLiveNotifyFuncMsgExtension", "requestOnLiveClose");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(".sysmsg.functionmsg.cgi", "/cgi-bin/micromsg-bin/findergetlivetips");
    ((Map)localHashMap).put(".sysmsg.functionmsg.cmdid", "6407");
    ((Map)localHashMap).put(".sysmsg.functionmsg.functionmsgid", paramString);
    ((Map)localHashMap).put(".sysmsg.functionmsg.businessid", "70001");
    locala.AOZ = ((String)localHashMap.get(".sysmsg.functionmsg.functionmsgid"));
    ((com.tencent.mm.api.z)com.tencent.mm.kernel.h.az(com.tencent.mm.api.z.class)).getReceiver().a(new dl(), (Map)localHashMap, "requestOnLiveClose");
    AppMethodBeat.o(352138);
  }
  
  public final void resumeLive(int paramInt)
  {
    AppMethodBeat.i(352544);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.resumeLive(paramInt);
    AppMethodBeat.o(352544);
  }
  
  public final void resumeVisitorLive()
  {
    AppMethodBeat.i(352679);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.resumeVisitorLive();
    AppMethodBeat.o(352679);
  }
  
  public final void sendExternalLiveAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(352404);
    kotlin.g.b.s.u(paramArrayOfByte, "audioBuffer");
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.a(paramArrayOfByte, paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(352404);
  }
  
  public final void sendExternalLiveData(EGLContext paramEGLContext, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(352398);
    kotlin.g.b.s.u(paramEGLContext, "eglContext");
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.a(paramEGLContext, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(352398);
  }
  
  public final void setCustomResolution(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(352527);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.setCustomResolution(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(352527);
  }
  
  public final void setFinderLiveTagText(View paramView, int paramInt)
  {
    AppMethodBeat.i(352744);
    String str;
    if ((paramView instanceof FinderLiveOnliveWidget)) {
      switch (paramInt)
      {
      default: 
        str = MMApplicationContext.getContext().getResources().getString(p.h.Cjn);
      }
    }
    for (;;)
    {
      kotlin.g.b.s.s(str, "when(chargeFlag) {\n     …          }\n            }");
      ((FinderLiveOnliveWidget)paramView).setText(str);
      AppMethodBeat.o(352744);
      return;
      str = MMApplicationContext.getContext().getResources().getString(p.h.Cjf);
      continue;
      str = MMApplicationContext.getContext().getResources().getString(p.h.Cjk);
    }
  }
  
  public final void setTopic(String paramString, b.f paramf)
  {
    AppMethodBeat.i(352780);
    kotlin.g.b.s.u(paramString, "topic");
    kotlin.g.b.s.u(paramf, "callback");
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.setTopic(paramString, paramf);
    AppMethodBeat.o(352780);
  }
  
  public final void setVoiceCaptureVolume(int paramInt)
  {
    AppMethodBeat.i(352552);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.setVoiceCaptureVolume(paramInt);
    AppMethodBeat.o(352552);
  }
  
  public final void shareLiveToFriend(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(352390);
    kotlin.g.b.s.u(paramAppCompatActivity, "activity");
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    kotlin.g.b.s.u(paramAppCompatActivity, "activity");
    localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Eco;
      if (localObject2 != null)
      {
        localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
        kotlin.g.b.s.s(localObject1, "service(IActivityRouter::class.java)");
        localObject1 = (com.tencent.mm.plugin.f)localObject1;
        localObject3 = FinderItem.Companion;
        localObject2 = FinderItem.a.e((FinderObject)localObject2, 16384);
        ((FinderItem)localObject2).setMediaType(9);
        localObject3 = ah.aiuX;
        localObject3 = new Bundle();
        localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if ((localObject4 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject4).Eet != true)) {
          break label179;
        }
      }
    }
    label179:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((Bundle)localObject3).putBoolean("Retr_show_success_tips", false);
      }
      localObject4 = ah.aiuX;
      com.tencent.mm.plugin.f.a.a((com.tencent.mm.plugin.f)localObject1, paramAppCompatActivity, (FinderItem)localObject2, (Bundle)localObject3, 0, (kotlin.g.a.b)new aj.w(paramAppCompatActivity), 8);
      AppMethodBeat.o(352390);
      return;
    }
  }
  
  public final void shareLiveToSns(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(352383);
    kotlin.g.b.s.u(paramAppCompatActivity, "activity");
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    kotlin.g.b.s.u(paramAppCompatActivity, "activity");
    localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Eco;
      if (localObject1 != null)
      {
        Object localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
        kotlin.g.b.s.s(localObject2, "service(IActivityRouter::class.java)");
        localObject2 = (com.tencent.mm.plugin.f)localObject2;
        FinderItem.a locala = FinderItem.Companion;
        com.tencent.mm.plugin.f.a.a((com.tencent.mm.plugin.f)localObject2, paramAppCompatActivity, (BaseFinderFeed)new x(FinderItem.a.e((FinderObject)localObject1, 16384)), null, 0, 28);
      }
    }
    AppMethodBeat.o(352383);
  }
  
  public final void startLocalAudio(boolean paramBoolean)
  {
    AppMethodBeat.i(352476);
    com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    com.tencent.mm.plugin.finder.live.model.aj.startLocalAudio(paramBoolean);
    AppMethodBeat.o(352476);
  }
  
  public final void startPlayGameAnchorSetting(JSONObject paramJSONObject, com.tencent.d.a.a.a.b.e parame)
  {
    long l2 = 0L;
    AppMethodBeat.i(352563);
    kotlin.g.b.s.u(paramJSONObject, "jo");
    kotlin.g.b.s.u(parame, "ck");
    Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    kotlin.g.b.s.u(paramJSONObject, "jo");
    kotlin.g.b.s.u(parame, "ck");
    Log.i("Finder.FinderLiveService", "startPayGameAnchorSetting");
    localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    long l1;
    if (localObject == null)
    {
      l1 = 0L;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject != null) {
        break label153;
      }
      label85:
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject != null) {
        break label175;
      }
    }
    label153:
    label175:
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).mZp)
    {
      localObject = com.tencent.mm.bx.b.cX((byte[])localObject);
      kotlin.g.b.s.s(localObject, "copyFrom(business(LiveCo…class.java)?.liveCookies)");
      new com.tencent.mm.plugin.finder.live.model.cgi.j(l1, l2, (com.tencent.mm.bx.b)localObject, paramJSONObject, parame).bFJ();
      AppMethodBeat.o(352563);
      return;
      l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).hKN;
      break;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).liveInfo;
      if (localObject == null) {
        break label85;
      }
      l2 = ((bip)localObject).liveId;
      break label85;
    }
  }
  
  public final void unregisterExternalLiveCallback(com.tencent.d.a.a.a.a parama)
  {
    AppMethodBeat.i(352422);
    if (parama != null)
    {
      com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      com.tencent.mm.plugin.finder.live.model.aj.unregisterExternalLiveCallback(parama);
    }
    AppMethodBeat.o(352422);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveNotifyExposureInfoStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.storage.h>
  {
    aa(PluginFinderLive paramPluginFinderLive)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/PluginFinderLive$ScreenStateReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(350831);
      paramContext = com.tencent.mm.plugin.finder.live.model.ar.CIh;
      com.tencent.mm.plugin.finder.live.model.ar.aw(paramIntent);
      AppMethodBeat.o(350831);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/PluginFinderLive$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.app.q
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(350838);
      paramString = com.tencent.mm.plugin.finder.live.model.ar.CIh;
      com.tencent.mm.plugin.finder.live.model.ar.emm();
      AppMethodBeat.o(350838);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(350845);
      paramString = com.tencent.mm.plugin.finder.live.model.ar.CIh;
      com.tencent.mm.plugin.finder.live.model.ar.eml();
      AppMethodBeat.o(350845);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/PluginFinderLive$autoOpenFinderLive$1", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.findersdk.a.t
  {
    e(String paramString1, String paramString2, PluginFinderLive paramPluginFinderLive, Context paramContext, JSONObject paramJSONObject, ca.a<Object> parama) {}
    
    public final void a(int paramInt1, int paramInt2, azf paramazf)
    {
      AppMethodBeat.i(350833);
      kotlin.g.b.s.u(paramazf, "resp");
      final ah.f localf = new ah.f();
      localf.aqH = paramazf.ZIo;
      paramazf = com.tencent.mm.plugin.finder.storage.d.FAy;
      switch (((Number)com.tencent.mm.plugin.finder.storage.d.eQf().bmg()).intValue())
      {
      default: 
      case 1: 
        for (;;)
        {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.Byf, str4, jdField_this, localf, paramContext, paramJSONObject, parama));
          AppMethodBeat.o(350833);
          return;
          localf.aqH = null;
          Log.i("Plugin.FinderLive", "autoOpenFinderLive mock 1");
        }
      }
      paramazf = (FinderObject)localf.aqH;
      if (paramazf == null) {}
      for (paramazf = null;; paramazf = paramazf.liveInfo)
      {
        if (paramazf != null) {
          paramazf.liveStatus = 2;
        }
        Log.i("Plugin.FinderLive", "autoOpenFinderLive mock 2");
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(String paramString1, String paramString2, PluginFinderLive paramPluginFinderLive, ah.f<FinderObject> paramf, Context paramContext, JSONObject paramJSONObject, ca.a<Object> parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "it"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<b.a<aub>, b.a<aub>>
  {
    f(com.tencent.d.a.a.a.b.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(PluginFinderLive paramPluginFinderLive, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    h(b.d paramd, long paramLong, int paramInt, b.a<azl> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<kotlinx.coroutines.aq, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    int label;
    
    j(long paramLong, PluginFinderLive paramPluginFinderLive, Context paramContext, String paramString, ImageView paramImageView, kotlin.d.d<? super j> paramd)
    {
      super(paramd);
    }
    
    private static final void c(ImageView paramImageView, int paramInt)
    {
      AppMethodBeat.i(350840);
      f.a.a locala = com.tencent.d.a.b.a.f.a.ahpZ;
      paramInt = f.a.a.getImageResFromActivityType(paramInt);
      if (paramInt == 0)
      {
        paramImageView.setVisibility(8);
        AppMethodBeat.o(350840);
        return;
      }
      paramImageView.setImageResource(paramInt);
      paramImageView.setVisibility(0);
      AppMethodBeat.o(350840);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(350864);
      paramd = new j(this.BdS, paramContext, paramString, paramImageView, this.Byq, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(350864);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(350859);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      String str1;
      Object localObject1;
      Object localObject2;
      int i;
      long l;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(350859);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.aq)this.L$0;
        str1 = com.tencent.mm.ae.d.hF(this.BdS);
        localObject1 = (Integer)PluginFinderLive.access$getActivityIconStatusCache$p(paramContext).get(kotlin.d.b.a.b.BF(this.BdS));
        if (localObject1 != null)
        {
          localObject2 = this.Byq;
          Log.i("Plugin.FinderLive", "#circulationFillingActivityIconInner feedId=" + str1 + " cache match: type=it");
          c((ImageView)localObject2, ((Integer)localObject1).intValue());
        }
        localObject1 = new ah.d();
        ((ah.d)localObject1).aixb = 1;
        if (kotlinx.coroutines.ar.a(paramObject)) {
          if (((ah.d)localObject1).aixb <= 0)
          {
            Log.i("Plugin.FinderLive", "#circulationFillingActivityIconInner feedId=" + str1 + " delayValue=" + ((ah.d)localObject1).aixb + " return");
            i = 0;
          }
        }
        break;
      case 1: 
        while (i != 0)
        {
          Log.i("Plugin.FinderLive", "#circulationFillingActivityIconInner feedId=" + str1 + " ready to delay: " + ((ah.d)localObject1).aixb + " second(s)");
          l = ((ah.d)localObject1).aixb;
          localObject2 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.Uf = str1;
          this.VC = localObject1;
          this.label = 1;
          if (bb.e(l * 1000L, (kotlin.d.d)localObject2) != locala) {
            break label755;
          }
          AppMethodBeat.o(350859);
          return locala;
          i = 1;
          continue;
          localObject1 = (ah.d)this.VC;
          str1 = (String)this.Uf;
          localObject2 = (kotlinx.coroutines.aq)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject2;
        }
      }
      label755:
      for (;;)
      {
        localObject2 = paramContext;
        Object localObject3 = paramString;
        l = this.BdS;
        String str2 = paramImageView;
        ImageView localImageView = this.Byq;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = str1;
        this.VC = localObject1;
        this.label = 2;
        localObject2 = PluginFinderLive.access$requestAndRefreshActivityIcon((PluginFinderLive)localObject2, (Context)localObject3, l, str2, localImageView, locald);
        if (localObject2 == locala)
        {
          AppMethodBeat.o(350859);
          return locala;
          localObject1 = (ah.d)this.VC;
          str1 = (String)this.Uf;
          localObject3 = (kotlinx.coroutines.aq)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject2 = paramObject;
          paramObject = localObject3;
        }
        for (;;)
        {
          localObject2 = (PluginFinderLive.b)localObject2;
          ((ah.d)localObject1).aixb = ((PluginFinderLive.b)localObject2).interval;
          if (kotlinx.coroutines.ar.a(paramObject)) {
            c(this.Byq, ((PluginFinderLive.b)localObject2).Bye);
          }
          ((Map)PluginFinderLive.access$getActivityIconStatusCache$p(paramContext)).put(kotlin.d.b.a.b.BF(this.BdS), Integer.valueOf(((PluginFinderLive.b)localObject2).Bye));
          localObject2 = ((Map)PluginFinderLive.access$getActivityIconStatusCache$p(paramContext)).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            i = PluginFinderLive.access$getActivityIconStatusCache$p(paramContext).size();
            if (i <= 500) {
              break;
            }
            Log.i("Plugin.FinderLive", "#circulationFillingActivityIconInner historiesList.size=" + i + ", max=500. remove " + ((Number)((Map.Entry)localObject3).getKey()).longValue());
            ((Iterator)localObject2).remove();
          }
          Log.i("Plugin.FinderLive", "#circulationFillingActivityIconInner feedId=" + str1 + " update delayValue: " + ((ah.d)localObject1).aixb + " second(s)");
          break;
          Log.i("Plugin.FinderLive", "#circulationFillingActivityIconInner feedId=" + str1 + " end");
          paramObject = ah.aiuX;
          AppMethodBeat.o(350859);
          return paramObject;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/PluginFinderLive$enterFinderLiveReplayUI$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "status", "", "liveInfoResp", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements b.d
  {
    k(Intent paramIntent, PluginFinderLive paramPluginFinderLive, Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3) {}
    
    public final void onLiveStatusCallback(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(350969);
      PluginFinderLive localPluginFinderLive = jdField_this;
      Context localContext = paramContext;
      paramLong = paramLong1;
      long l = paramString1;
      String str1 = paramString3;
      String str2 = this.AsO;
      String str3 = this.mjJ;
      if ((paramObject instanceof azl))
      {
        paramObject = (azl)paramObject;
        if (paramObject != null) {
          break label103;
        }
      }
      label103:
      for (paramObject = null;; paramObject = paramObject.liveInfo)
      {
        PluginFinderLive.access$enterFinderLiveReplayUI$enterReplayUIImpl(localPluginFinderLive, localContext, paramLong, l, str1, str2, str3, paramObject, this.odM);
        AppMethodBeat.o(350969);
        return;
        paramObject = null;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<kotlinx.coroutines.aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    m(com.tencent.mm.live.core.core.model.g paramg, kotlin.d.d<? super m> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(350953);
      paramObject = (kotlin.d.d)new m(this.Byw, paramd);
      AppMethodBeat.o(350953);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(350946);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(350946);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("Plugin.FinderLive", "enterPreloadPlayer: preload start");
        paramObject = new com.tencent.mm.plugin.finder.live.preloader.b(this.Byw);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.X(locald) == locala)
        {
          AppMethodBeat.o(350946);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(350946);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<kotlinx.coroutines.aq, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    int label;
    
    n(PluginFinderLive paramPluginFinderLive, int paramInt, Context paramContext, long paramLong, String paramString, ImageView paramImageView, kotlin.d.d<? super n> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(350964);
      paramd = new n(this.Byh, paramInt, paramContext, paramLong, paramImageView, this.Byq, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(350964);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(350956);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      kotlinx.coroutines.aq localaq;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(350956);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localaq = (kotlinx.coroutines.aq)this.L$0;
        localObject1 = (Set)PluginFinderLive.access$getCoroutineScopeRunningJob$p(this.Byh).get(Integer.valueOf(paramInt));
        paramObject = localObject1;
        if (localObject1 == null)
        {
          paramObject = (Set)new LinkedHashSet();
          PluginFinderLive.access$getCoroutineScopeRunningJob$p(this.Byh).put(Integer.valueOf(paramInt), paramObject);
        }
        paramObject.add(localaq);
        Log.i("Plugin.FinderLive", "#executeCirculationFillingActivityIcon source=" + paramInt + " add done. setCount=" + paramObject.size());
      }
      try
      {
        localObject1 = this.Byh;
        Context localContext = paramContext;
        long l = paramLong;
        String str = paramImageView;
        ImageView localImageView = this.Byq;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = localaq;
        this.Uf = paramObject;
        this.label = 1;
        localObject1 = PluginFinderLive.access$circulationFillingActivityIconInner((PluginFinderLive)localObject1, localContext, l, str, localImageView, locald);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(350956);
          return locala;
          localObject1 = (Set)this.Uf;
          localaq = (kotlinx.coroutines.aq)this.L$0;
        }
        paramObject.remove(localaq);
      }
      finally
      {
        try
        {
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject1;
          paramObject.remove(localaq);
          Log.i("Plugin.FinderLive", "#executeCirculationFillingActivityIcon source=" + paramInt + " remove done. setCount=" + paramObject.size());
          paramObject = ah.aiuX;
          AppMethodBeat.o(350956);
          return paramObject;
        }
        finally
        {
          paramObject = localObject2;
          Object localObject3 = localObject4;
        }
        localObject2 = finally;
      }
      Log.i("Plugin.FinderLive", "#executeCirculationFillingActivityIcon source=" + paramInt + " remove done. setCount=" + paramObject.size());
      AppMethodBeat.o(350956);
      throw localObject2;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveChargeInfoStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.storage.b>
  {
    o(PluginFinderLive paramPluginFinderLive)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveDislikeBannerStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.storage.d>
  {
    p(PluginFinderLive paramPluginFinderLive)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveVideoDefinitionStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.storage.i>
  {
    q(PluginFinderLive paramPluginFinderLive)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    r(b.d paramd, long paramLong, kotlin.u<Integer, Long, ? extends azl> paramu)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    s(b.d paramd, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    t(kotlin.g.a.a<ah> parama, com.tencent.mm.plugin.finder.live.ui.livepost.c paramc, Activity paramActivity, boolean paramBoolean)
    {
      super();
    }
    
    private static final void a(awa paramawa, com.tencent.mm.plugin.finder.live.ui.livepost.c paramc, boolean paramBoolean)
    {
      Object localObject2 = null;
      AppMethodBeat.i(350997);
      kotlin.g.b.s.u(paramawa, "$resp");
      kotlin.g.b.s.u(paramc, "$this_apply");
      Object localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      if ((com.tencent.mm.plugin.finder.live.model.aj.elr() == null) && (paramawa.ZGo != null))
      {
        localObject1 = paramawa.ZGo;
        int i;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label181;
          }
          localObject1 = paramawa.ZGo;
          if (localObject1 == null) {
            break label147;
          }
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if ((localObject1 == null) || (((bip)localObject1).liveId != 0L)) {
            break label147;
          }
          i = 1;
          label92:
          if (i != 0) {
            break label181;
          }
          localObject1 = paramawa.ZGo;
          if (localObject1 != null) {
            break label152;
          }
          localObject1 = localObject2;
        }
        for (;;)
        {
          Log.i("Plugin.FinderLive", kotlin.g.b.s.X("#goToAnchorLiveDirect continue live:", localObject1));
          paramc.f(paramawa.ZGo);
          AppMethodBeat.o(350997);
          return;
          localObject1 = ((FinderObject)localObject1).liveInfo;
          break;
          label147:
          i = 0;
          break label92;
          label152:
          bip localbip = ((FinderObject)localObject1).liveInfo;
          localObject1 = localObject2;
          if (localbip != null) {
            localObject1 = Long.valueOf(localbip.liveId);
          }
        }
      }
      label181:
      Log.i("Plugin.FinderLive", "#goToAnchorLiveDirect gotoLive errCode");
      paramc.a(paramawa, paramBoolean);
      AppMethodBeat.o(350997);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveActionRecordStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.storage.a>
  {
    v(PluginFinderLive paramPluginFinderLive)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveConfigStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.storage.c>
  {
    w(PluginFinderLive paramPluginFinderLive)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveGiftStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.storage.e>
  {
    x(PluginFinderLive paramPluginFinderLive)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLastRewardInfoStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.storage.f>
  {
    y(PluginFinderLive paramPluginFinderLive)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLuckyMoneyStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.storage.g>
  {
    z(PluginFinderLive paramPluginFinderLive)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.PluginFinderLive
 * JD-Core Version:    0.7.0.1
 */