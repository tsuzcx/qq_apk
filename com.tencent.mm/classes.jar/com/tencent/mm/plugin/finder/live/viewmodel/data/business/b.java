package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.live.util.r;
import com.tencent.mm.plugin.finder.live.viewmodel.data.n;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ax;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "adIdToUxInfoMap", "Ljava/util/HashMap;", "", "getAdIdToUxInfoMap", "()Ljava/util/HashMap;", "setAdIdToUxInfoMap", "(Ljava/util/HashMap;)V", "alertInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "getAlertInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "setAlertInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;)V", "anchorFinderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getAnchorFinderContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setAnchorFinderContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "anchorMusicData", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorMusicData;", "getAnchorMusicData", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorMusicData;", "setAnchorMusicData", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorMusicData;)V", "value", "anchorPauseStartTime", "getAnchorPauseStartTime", "()J", "setAnchorPauseStartTime", "(J)V", "anchorPauseTimeCount", "", "getAnchorPauseTimeCount", "()I", "setAnchorPauseTimeCount", "(I)V", "anchorStatusFlag", "getAnchorStatusFlag", "setAnchorStatusFlag", "anchorUsername", "getAnchorUsername", "()Ljava/lang/String;", "setAnchorUsername", "(Ljava/lang/String;)V", "audioModeCoverInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveAudioModeCoverInfo;", "getAudioModeCoverInfo", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveAudioModeCoverInfo;", "setAudioModeCoverInfo", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveAudioModeCoverInfo;)V", "audioModeSwitch", "", "getAudioModeSwitch", "()Z", "setAudioModeSwitch", "(Z)V", "autoJumpRedPackId", "getAutoJumpRedPackId", "setAutoJumpRedPackId", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "badgeInfos", "getBadgeInfos", "()Ljava/util/LinkedList;", "setBadgeInfos", "(Ljava/util/LinkedList;)V", "cacheLayerShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerShowInfo;", "getCacheLayerShowInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerShowInfo;", "setCacheLayerShowInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerShowInfo;)V", "cacheVisitorRoleList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "getCacheVisitorRoleList", "setCacheVisitorRoleList", "cacheVisitorRoleModifyTime", "getCacheVisitorRoleModifyTime", "setCacheVisitorRoleModifyTime", "cacheVisitorRoleType", "getCacheVisitorRoleType", "setCacheVisitorRoleType", "castScreenDeviceInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ScreenDeviceData;", "getCastScreenDeviceInfo", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ScreenDeviceData;", "setCastScreenDeviceInfo", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ScreenDeviceData;)V", "cheerIconInfos", "Lcom/tencent/mm/protocal/protobuf/CheerIconInfo;", "getCheerIconInfos", "commentSize", "getCommentSize", "setCommentSize", "contentRect", "Landroid/graphics/Rect;", "getContentRect", "()Landroid/graphics/Rect;", "setContentRect", "(Landroid/graphics/Rect;)V", "curBalance", "getCurBalance", "setCurBalance", "curBattle", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;", "getCurBattle", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;", "setCurBattle", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;)V", "curlLikeCount", "getCurlLikeCount", "setCurlLikeCount", "desc", "getDesc", "setDesc", "disableCommentCacheMap", "getDisableCommentCacheMap", "setDisableCommentCacheMap", "enableAudioMode", "getEnableAudioMode", "setEnableAudioMode", "enableAudioModeFlag", "getEnableAudioModeFlag", "setEnableAudioModeFlag", "enableCommentSvr", "getEnableCommentSvr", "()Ljava/lang/Boolean;", "setEnableCommentSvr", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableCustomerComment", "getEnableCustomerComment", "setEnableCustomerComment", "enableGift", "getEnableGift", "setEnableGift", "enableGiftAntispam", "getEnableGiftAntispam", "setEnableGiftAntispam", "enableGiftFlag", "getEnableGiftFlag", "setEnableGiftFlag", "enableGiftSwitch", "getEnableGiftSwitch", "setEnableGiftSwitch", "enableLiveRoomComment", "getEnableLiveRoomComment", "setEnableLiveRoomComment", "enableLiveRoomLike", "getEnableLiveRoomLike", "setEnableLiveRoomLike", "enableLuckyMoney", "getEnableLuckyMoney", "setEnableLuckyMoney", "enableSubtitle", "getEnableSubtitle", "setEnableSubtitle", "enableVisitorGiftSwitch", "getEnableVisitorGiftSwitch", "setEnableVisitorGiftSwitch", "exptBeautyEnable", "getExptBeautyEnable", "setExptBeautyEnable", "exptFilterEnable", "getExptFilterEnable", "setExptFilterEnable", "externalPost", "getExternalPost", "setExternalPost", "floatModeRemoveActivity", "getFloatModeRemoveActivity", "setFloatModeRemoveActivity", "forceChangeOrientation", "getForceChangeOrientation", "setForceChangeOrientation", "forceFetchObject", "getForceFetchObject", "setForceFetchObject", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "fromShareScene", "getFromShareScene", "setFromShareScene", "gameAppId", "getGameAppId", "setGameAppId", "gameInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;", "getGameInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;", "setGameInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;)V", "gameVersionType", "getGameVersionType", "setGameVersionType", "giftQueue", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "getGiftQueue", "()Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "setGiftQueue", "(Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;)V", "hasGetLiveReward", "getHasGetLiveReward", "setHasGetLiveReward", "inMiniVolumeState", "getInMiniVolumeState", "setInMiniVolumeState", "injectEvent", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/EventWrapper;", "getInjectEvent", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/EventWrapper;", "setInjectEvent", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/EventWrapper;)V", "isLiveQosControlEnabled", "setLiveQosControlEnabled", "isLiveQosReportEnabled", "setLiveQosReportEnabled", "isTeamFull", "setTeamFull", "joinLiveTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;", "getJoinLiveTabTipsInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;", "setJoinLiveTabTipsInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;)V", "joinLiveTips", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;", "getJoinLiveTips", "()Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;", "setJoinLiveTips", "(Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;)V", "lastAnchorPauseState", "getLastAnchorPauseState", "setLastAnchorPauseState", "lastCandidateBuffer", "", "getLastCandidateBuffer", "()[B", "setLastCandidateBuffer", "([B)V", "lastChosenTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLastChosenTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setLastChosenTagInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;", "lastGameTeamInfo", "getLastGameTeamInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;", "setLastGameTeamInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;)V", "lastLiveCommentSeq", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "getLastLiveCommentSeq", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "setLastLiveCommentSeq", "(Lcom/tencent/mm/algorithm/MMLRUMap;)V", "lastLiveState", "getLastLiveState", "setLastLiveState", "lastUiState", "getLastUiState", "setLastUiState", "likes", "getLikes", "setLikes", "liveBreakRule", "getLiveBreakRule", "setLiveBreakRule", "liveCoverUrl", "getLiveCoverUrl", "setLiveCoverUrl", "liveExtFlag", "getLiveExtFlag", "setLiveExtFlag", "liveFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLiveFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setLiveFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "liveFinish", "getLiveFinish", "setLiveFinish", "liveRoomLikeSwitch", "getLiveRoomLikeSwitch", "setLiveRoomLikeSwitch", "liveState", "getLiveState", "setLiveState", "liveTaskInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivity;", "getLiveTaskInfo", "setLiveTaskInfo", "live_contacts_continue_flag", "getLive_contacts_continue_flag", "setLive_contacts_continue_flag", "live_contacts_max_display_count", "getLive_contacts_max_display_count", "setLive_contacts_max_display_count", "localRewardonlineMemberList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRecentRewardOnlineMember;", "getLocalRewardonlineMemberList", "setLocalRewardonlineMemberList", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "luckyMoneyData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LuckyMoneyLiveData;", "getLuckyMoneyData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LuckyMoneyLiveData;", "setLuckyMoneyData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LuckyMoneyLiveData;)V", "luckyMoneyList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "kotlin.jvm.PlatformType", "", "getLuckyMoneyList", "()Ljava/util/List;", "setLuckyMoneyList", "(Ljava/util/List;)V", "luckyMoneyMsgList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "getLuckyMoneyMsgList", "setLuckyMoneyMsgList", "luckyMoneySvrConfig", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLuckyMoneySvrConfig;", "getLuckyMoneySvrConfig", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLuckyMoneySvrConfig;", "setLuckyMoneySvrConfig", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLuckyMoneySvrConfig;)V", "maxVisibleRoomCount", "getMaxVisibleRoomCount", "setMaxVisibleRoomCount", "maxVisibleUserCount", "getMaxVisibleUserCount", "setMaxVisibleUserCount", "musicVolume", "getMusicVolume", "setMusicVolume", "muteMic", "getMuteMic", "setMuteMic", "muteVideoBitmap", "Landroid/graphics/Bitmap;", "getMuteVideoBitmap", "()Landroid/graphics/Bitmap;", "setMuteVideoBitmap", "(Landroid/graphics/Bitmap;)V", "myLocalCommentCache", "getMyLocalCommentCache", "setMyLocalCommentCache", "needMiniWindow", "getNeedMiniWindow", "setNeedMiniWindow", "needRelaunchWeAppOnLiveFinished", "getNeedRelaunchWeAppOnLiveFinished", "setNeedRelaunchWeAppOnLiveFinished", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "onceEnabledLiveRoomLike", "getOnceEnabledLiveRoomLike", "setOnceEnabledLiveRoomLike", "outSideuxInfo", "getOutSideuxInfo", "setOutSideuxInfo", "pauseWording", "getPauseWording", "setPauseWording", "preloadLive", "getPreloadLive", "setPreloadLive", "releaseAnchorUIKeepData", "getReleaseAnchorUIKeepData", "setReleaseAnchorUIKeepData", "remoteRewardonlineMemberList", "getRemoteRewardonlineMemberList", "setRemoteRewardonlineMemberList", "requestId", "getRequestId", "setRequestId", "riskControlEnableComment", "getRiskControlEnableComment", "setRiskControlEnableComment", "screenClear", "getScreenClear", "setScreenClear", "screenShareEnable", "getScreenShareEnable", "setScreenShareEnable", "screenShareFilePath", "getScreenShareFilePath", "setScreenShareFilePath", "screenSharePicType", "getScreenSharePicType", "setScreenSharePicType", "screenShareSwitch", "getScreenShareSwitch", "setScreenShareSwitch", "secondaryDeviceFlag", "getSecondaryDeviceFlag", "setSecondaryDeviceFlag", "sessionId", "getSessionId", "setSessionId", "shareUserName", "getShareUserName", "setShareUserName", "statistics", "getStatistics", "setStatistics", "statusVerifyInfo", "getStatusVerifyInfo", "setStatusVerifyInfo", "subtitleInfo", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveSubtitle;", "getSubtitleInfo", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setSubtitleInfo", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "supportScreenRotation", "getSupportScreenRotation", "setSupportScreenRotation", "tagInfo", "getTagInfo", "setTagInfo", "tickleUserCache", "getTickleUserCache", "setTickleUserCache", "topCommentCache", "getTopCommentCache", "setTopCommentCache", "totalCnt", "getTotalCnt", "setTotalCnt", "uiState", "getUiState", "setUiState", "useUpdateStrategy", "getUseUpdateStrategy", "setUseUpdateStrategy", "videoHeight", "getVideoHeight", "setVideoHeight", "videoWidth", "getVideoWidth", "setVideoWidth", "visitorRole", "getVisitorRole", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "setVisitorRole", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;)V", "appendAudioModeTip", "", "roomData", "appendGameTeamModeTip", "appendGiftTip", "audienceMode", "fitLandscapeVideo", "getTrtcKeyParams", "hasJoinLive", "info", "initVisitorRoleInfo", "isAnchor", "isAnchorAliveExpired", "isLandscapeVideo", "isLinkMicVideo", "isLiveFinish", "isLiveIdle", "isLivePrepare", "isLiveStarted", "isLiveStartedWait", "isLuckyMoneyEnable", "luckyMoneyConfig", "isLuckyMoneyFestival", "isLuckyMoneyNormal", "isMicLinking", "needFetchFeedObject", "onCleared", "printRedPacketInfoList", "prefix", "fromJoinLive", "reset2", "resetRedPackInfoToList", "liveMsgRedPacketInfoList", "safeAddAudienceMicUser", "micUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "safeResetAlertInfo", "safeSetAlertInfo", "sdkAppId", "selfSdkLiveId", "selfSdkUserId", "setupOnceExptConfig", "toString", "updateAnchorStatus", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "updateFuncEnableAnchor", "switchFlag", "updateFuncEnableVisitor", "contactFlag", "updateJoinLiveCommentState", "enableComment", "(Ljava/lang/Integer;)V", "updateLayerShowInfo", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "pause", "lastPauseTime", "updateLocalAnchorStatus", "updateLocalSwitchFlag", "updateVisitorRoleInfo", "validVideoSize", "Companion", "plugin-finder-base_release"})
public final class b
  extends a<com.tencent.mm.plugin.finder.live.model.context.a>
{
  private static final com.tencent.mm.b.h<Long, Boolean> zgP;
  public static final a zgQ;
  public final String TAG;
  public String desc;
  public String fIY;
  public int friendFollowCount;
  public String kig;
  public boolean kis;
  public String kit;
  public int kiu;
  public int lastLiveState;
  public bdm location;
  public long sessionId;
  private Rect vcr;
  public int videoHeight;
  public int videoWidth;
  public bbh xUD;
  private boolean yYj;
  public int yeE;
  public LinkedList<bda> yeF;
  public bda yeG;
  public int yeI;
  public int yeJ;
  public com.tencent.mm.plugin.finder.live.util.p zeW;
  public LinkedList<ayl> zeX;
  public awl zeY;
  public FinderObject zeZ;
  public String zfA;
  public boolean zfB;
  public com.tencent.mm.b.h<String, Long> zfC;
  public azh zfD;
  public azi zfE;
  public boolean zfF;
  public int zfG;
  public boolean zfH;
  public boolean zfI;
  public boolean zfJ;
  public long zfK;
  public final LinkedList<aal> zfL;
  public Boolean zfM;
  public boolean zfN;
  public boolean zfO;
  public boolean zfP;
  public boolean zfQ;
  public com.tencent.mm.b.h<Long, com.tencent.mm.plugin.finder.live.model.ao> zfR;
  public axc zfS;
  public int zfT;
  public LinkedList<axc> zfU;
  public long zfV;
  public String zfW;
  public boolean zfX;
  public boolean zfY;
  public bap zfZ;
  public int zfa;
  public boolean zfb;
  public boolean zfc;
  public boolean zfd;
  public boolean zfe;
  public boolean zff;
  public boolean zfg;
  public byte[] zfh;
  public volatile boolean zfi;
  public long zfj;
  public long zfk;
  public boolean zfl;
  public boolean zfm;
  public boolean zfn;
  public boolean zfo;
  public int zfp;
  public int zfq;
  public long zfr;
  public HashMap<String, Boolean> zfs;
  public bbe zft;
  public int zfu;
  public int zfv;
  public int zfw;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.c zfx;
  public String zfy;
  public int zfz;
  public int zgA;
  public boolean zgB;
  public boolean zgC;
  public boolean zgD;
  public ConcurrentLinkedDeque<com.tencent.mm.plugin.finder.live.viewmodel.data.k> zgE;
  public String zgF;
  public awk zgG;
  public LinkedList<bbv> zgH;
  public LinkedList<bbv> zgI;
  public String zgJ;
  public HashMap<Long, String> zgK;
  public boolean zgL;
  private boolean zgM;
  public String zgN;
  public boolean zgO;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.m zga;
  private List<bbd> zgb;
  public List<bbx> zgc;
  public int zgd;
  public int zge;
  public boolean zgf;
  public List<String> zgg;
  public List<String> zgh;
  public n zgi;
  public com.tencent.mm.plugin.finder.live.model.b zgj;
  public int zgk;
  public boolean zgl;
  public int zgm;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.d zgn;
  public Bitmap zgo;
  public i zgp;
  public boolean zgq;
  public LinkedList<bbt> zgr;
  public boolean zgs;
  public long zgt;
  public int zgu;
  public int zgv;
  public bag zgw;
  public String zgx;
  public boolean zgy;
  public String zgz;
  
  static
  {
    AppMethodBeat.i(258782);
    zgQ = new a((byte)0);
    zgP = new com.tencent.mm.b.h(10);
    AppMethodBeat.o(258782);
  }
  
  public b(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(258780);
    this.TAG = ("LiveCommonSlice@" + hashCode());
    this.zeW = ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvV();
    this.kig = "";
    this.zfb = true;
    this.zfc = true;
    this.zfd = true;
    this.zfe = true;
    this.zff = true;
    this.zfn = true;
    this.zfp = -1;
    this.zfs = new HashMap();
    this.zfx = new com.tencent.mm.plugin.finder.live.viewmodel.data.c(null, null, null);
    this.zfA = "";
    this.zfC = new com.tencent.mm.b.h(100);
    this.zfG = -1;
    this.zfJ = true;
    this.zfL = new LinkedList();
    this.yeE = 1;
    this.zfP = true;
    this.zfQ = true;
    this.fIY = "";
    this.zfR = new com.tencent.mm.b.h(1000);
    this.zfS = new axc();
    this.zfT = 4;
    this.zfU = new LinkedList();
    this.zfV = -9223372036854775808L;
    parama = com.tencent.c.a.a.a.a.a.Zlt;
    boolean bool;
    String str;
    StringBuilder localStringBuilder;
    if (((Number)com.tencent.c.a.a.a.a.a.imt().aSr()).intValue() == 1)
    {
      bool = true;
      this.zfX = bool;
      this.zfZ = new bap();
      this.zga = new com.tencent.mm.plugin.finder.live.viewmodel.data.m();
      this.zgb = Collections.synchronizedList((List)new ArrayList());
      this.zgc = Collections.synchronizedList((List)new ArrayList());
      this.vcr = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
      this.kit = "";
      parama = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(parama, "MMKernel.storage()");
      this.zgf = parama.aHp().getBoolean(ar.a.VCo, false);
      this.zgg = Collections.synchronizedList((List)new ArrayList());
      this.zgh = Collections.synchronizedList((List)new ArrayList());
      this.zgj = new com.tencent.mm.plugin.finder.live.model.b();
      parama = com.tencent.c.a.a.a.a.a.Zlt;
      this.zgk = ((Number)com.tencent.c.a.a.a.a.a.ils().aSr()).intValue();
      this.zgm = -1;
      this.zgn = new com.tencent.mm.plugin.finder.live.viewmodel.data.d((byte)0);
      this.zgr = new LinkedList();
      this.zgE = new ConcurrentLinkedDeque();
      this.zgH = new LinkedList();
      this.zgI = new LinkedList();
      this.zgK = new HashMap();
      str = this.TAG;
      localStringBuilder = new StringBuilder("LiveBuContext init ");
      parama = ak.AGL;
      if (!ak.eej()) {
        break label588;
      }
      parama = Util.getStack().toString();
      kotlin.g.b.p.j(parama, "Util.getStack().toString()");
    }
    for (;;)
    {
      Log.i(str, parama);
      AppMethodBeat.o(258780);
      return;
      bool = false;
      break;
      label588:
      parama = "";
    }
  }
  
  public static void LS(long paramLong)
  {
    AppMethodBeat.i(258731);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VyJ, Long.valueOf(paramLong));
    AppMethodBeat.o(258731);
  }
  
  public static void LT(long paramLong)
  {
    AppMethodBeat.i(258733);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VyK, Long.valueOf(paramLong));
    AppMethodBeat.o(258733);
  }
  
  public static boolean NV(int paramInt)
  {
    return paramInt != 1;
  }
  
  public static boolean NW(int paramInt)
  {
    return paramInt == 3;
  }
  
  public static boolean NX(int paramInt)
  {
    return paramInt == 2;
  }
  
  private boolean dGR()
  {
    AppMethodBeat.i(258750);
    boolean bool = dGS();
    Log.i(this.TAG, "isLandscapeVideo validVideoSize:".concat(String.valueOf(bool)));
    if ((bool) && (this.videoWidth >= this.videoHeight))
    {
      AppMethodBeat.o(258750);
      return true;
    }
    AppMethodBeat.o(258750);
    return false;
  }
  
  public final void LP(long paramLong)
  {
    AppMethodBeat.i(258719);
    Log.i(this.TAG, "set curBalance:".concat(String.valueOf(paramLong)));
    this.zfK = paramLong;
    AppMethodBeat.o(258719);
  }
  
  public final void LQ(long paramLong)
  {
    AppMethodBeat.i(258723);
    Log.i(this.TAG, "setAnchorPauseStartTime:".concat(String.valueOf(paramLong)));
    this.zgt = paramLong;
    AppMethodBeat.o(258723);
  }
  
  public final void LR(long paramLong)
  {
    AppMethodBeat.i(258729);
    Log.i(this.TAG, "updateFuncEnableAnchor switchFlag:".concat(String.valueOf(paramLong)));
    ((f)business(f.class)).zhs = com.tencent.mm.ae.d.dr((int)paramLong, 4);
    r localr = r.yQS;
    this.zfH = r.Lw(paramLong);
    this.zgq = com.tencent.mm.ae.d.dr((int)paramLong, 8);
    ((f)business(f.class)).zhy = com.tencent.mm.ae.d.dr((int)paramLong, 64);
    this.zfe = com.tencent.mm.ae.d.dr((int)paramLong, 256);
    this.zgL = com.tencent.mm.ae.d.dr((int)paramLong, 128);
    AppMethodBeat.o(258729);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.c paramc)
  {
    AppMethodBeat.i(258713);
    kotlin.g.b.p.k(paramc, "<set-?>");
    this.zfx = paramc;
    AppMethodBeat.o(258713);
  }
  
  public final void a(azi paramazi)
  {
    if ((paramazi != null) && (paramazi.status == 3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.zfF = bool;
      this.zfE = paramazi;
      return;
    }
  }
  
  public final void a(final bag parambag, final boolean paramBoolean, final kotlin.g.a.m<? super Boolean, ? super Integer, x> paramm)
  {
    AppMethodBeat.i(258774);
    kotlin.g.b.p.k(parambag, "info");
    kotlin.g.b.p.k(paramm, "callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, parambag, paramBoolean, paramm));
    AppMethodBeat.o(258774);
  }
  
  public final void aCW(String paramString)
  {
    AppMethodBeat.i(258711);
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.kig = paramString;
    AppMethodBeat.o(258711);
  }
  
  public final void aCX(String paramString)
  {
    AppMethodBeat.i(258720);
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.fIY = paramString;
    AppMethodBeat.o(258720);
  }
  
  public final String aJk()
  {
    return this.kig;
  }
  
  public final void ax(LinkedList<ayl> paramLinkedList)
  {
    AppMethodBeat.i(258709);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("set badgeInfos:");
    if (paramLinkedList == null) {}
    for (Object localObject = "";; localObject = paramLinkedList)
    {
      Log.i(str, com.tencent.mm.ae.g.bN(localObject));
      this.zeX = paramLinkedList;
      AppMethodBeat.o(258709);
      return;
    }
  }
  
  public final boolean bvS()
  {
    AppMethodBeat.i(258728);
    Object localObject = ((c)business(c.class)).kvS;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.model.g)localObject).kjd;
      if (localObject == null) {}
    }
    for (localObject = ((com.tencent.mm.live.core.core.model.f)localObject).kmj;; localObject = null)
    {
      boolean bool = Util.isEqual((String)localObject, dGU());
      AppMethodBeat.o(258728);
      return bool;
    }
  }
  
  public final String dGE()
  {
    AppMethodBeat.i(258715);
    Object localObject = this.zeZ;
    if (localObject != null)
    {
      localObject = ((FinderObject)localObject).liveInfo;
      if ((localObject != null) && (((bac)localObject).SLR == 1))
      {
        localObject = this.zeZ;
        if (localObject != null)
        {
          localObject = ((FinderObject)localObject).objectDesc;
          if (localObject != null)
          {
            localObject = ((FinderObjectDesc)localObject).liveDesc;
            if (localObject != null)
            {
              String str = ((azd)localObject).zfA;
              localObject = str;
              if (str != null) {
                break label74;
              }
            }
          }
        }
        localObject = "";
        label74:
        AppMethodBeat.o(258715);
        return localObject;
      }
    }
    localObject = (CharSequence)this.zfA;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = ak.AGL;
      if (ak.eej()) {
        Log.i(this.TAG, "liveCoverUrl field:" + this.zfA);
      }
      localObject = this.zfA;
      AppMethodBeat.o(258715);
      return localObject;
    }
    localObject = this.zeZ;
    if (localObject != null)
    {
      localObject = ((FinderObject)localObject).objectDesc;
      if (localObject != null)
      {
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject == null) {}
      }
    }
    for (localObject = (FinderMedia)kotlin.a.j.lp((List)localObject); localObject != null; localObject = null)
    {
      localObject = kotlin.g.b.p.I(((FinderMedia)localObject).thumbUrl, Util.nullAsNil(((FinderMedia)localObject).thumb_url_token));
      AppMethodBeat.o(258715);
      return localObject;
    }
    AppMethodBeat.o(258715);
    return "";
  }
  
  public final boolean dGF()
  {
    return this.zfG == 1;
  }
  
  public final boolean dGG()
  {
    AppMethodBeat.i(258722);
    Collection localCollection = (Collection)this.zga.zeT;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(258722);
      return true;
    }
    AppMethodBeat.o(258722);
    return false;
  }
  
  public final boolean dGH()
  {
    return this.zgm == 1;
  }
  
  public final boolean dGI()
  {
    AppMethodBeat.i(258724);
    boolean bool = com.tencent.mm.ae.d.dr(this.zfa, 1024);
    AppMethodBeat.o(258724);
    return bool;
  }
  
  public final int dGJ()
  {
    AppMethodBeat.i(258735);
    Object localObject = ((c)business(c.class)).kvS;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.model.g)localObject).kjd;
      if (localObject != null)
      {
        i = ((com.tencent.mm.live.core.core.model.f)localObject).kmi;
        AppMethodBeat.o(258735);
        return i;
      }
    }
    localObject = e.b.kjz;
    int i = e.b.aJK();
    AppMethodBeat.o(258735);
    return i;
  }
  
  public final void dGK()
  {
    AppMethodBeat.i(258736);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(258736);
  }
  
  public final String dGL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(258737);
    StringBuilder localStringBuilder = new StringBuilder("appId:");
    Object localObject1 = ((c)business(c.class)).kvS;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.model.g)localObject1).kmq;
      if (localObject1 == null) {}
    }
    for (localObject1 = Integer.valueOf(((TRTCCloudDef.TRTCParams)localObject1).sdkAppId);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append("\nroomId:");
      Object localObject3 = ((c)business(c.class)).kvS;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.live.core.core.model.g)localObject3).kmq;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = Integer.valueOf(((TRTCCloudDef.TRTCParams)localObject3).roomId);
        }
      }
      localObject1 = localObject1 + '\n';
      AppMethodBeat.o(258737);
      return localObject1;
    }
  }
  
  public final boolean dGM()
  {
    boolean bool1 = true;
    AppMethodBeat.i(258739);
    r localr = r.yQS;
    boolean bool2 = r.dEy();
    if (this.zfv == 1) {}
    for (;;)
    {
      AppMethodBeat.o(258739);
      return bool1 & bool2;
      bool1 = false;
    }
  }
  
  public final boolean dGN()
  {
    return this.zfv == 4;
  }
  
  public final boolean dGO()
  {
    return this.zfv == 0;
  }
  
  public final boolean dGP()
  {
    return this.zfz == 1;
  }
  
  public final boolean dGQ()
  {
    AppMethodBeat.i(258748);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    boolean bool1 = com.tencent.c.a.a.a.a.a.imn();
    boolean bool2 = dGR();
    Log.i(this.TAG, "fitLandscapeVideo config:" + bool1 + ",isLandscapeVideo:" + bool2);
    AppMethodBeat.o(258748);
    return bool1 & bool2;
  }
  
  public final boolean dGS()
  {
    AppMethodBeat.i(258752);
    Log.i(this.TAG, "validVideoSize videoWidth:" + this.videoWidth + ",videoHeight:" + this.videoHeight);
    if ((this.videoWidth > 0) && (this.videoHeight > 0))
    {
      AppMethodBeat.o(258752);
      return true;
    }
    AppMethodBeat.o(258752);
    return false;
  }
  
  public final boolean dGT()
  {
    bool2 = false;
    AppMethodBeat.i(258755);
    Log.i(this.TAG, "isLinkMicVideo videoWidth:" + this.videoWidth + ",videoHeight:" + this.videoHeight);
    bool1 = bool2;
    try
    {
      if (this.videoWidth > 0)
      {
        bool1 = bool2;
        if (this.videoHeight > 0)
        {
          Object localObject = new DecimalFormat("0.0");
          ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
          localObject = ((DecimalFormat)localObject).format(Float.valueOf(this.videoWidth / this.videoHeight));
          kotlin.g.b.p.j(localObject, "floatFormat.format(video… / videoHeight.toFloat())");
          float f = Float.parseFloat((String)localObject);
          if (f != 1.1F)
          {
            bool1 = bool2;
            if (f != 1.0F) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w(this.TAG, "ex:" + localException.getMessage());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(258755);
    return bool1;
  }
  
  public final String dGU()
  {
    AppMethodBeat.i(258757);
    Object localObject = ((c)business(c.class)).kvS;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.model.g)localObject).kmq;
      if (localObject != null)
      {
        localObject = ((TRTCCloudDef.TRTCParams)localObject).userId;
        AppMethodBeat.o(258757);
        return localObject;
      }
    }
    AppMethodBeat.o(258757);
    return null;
  }
  
  public final int dGV()
  {
    AppMethodBeat.i(258759);
    Object localObject = ((c)business(c.class)).kvS;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.model.g)localObject).kmq;
      if (localObject != null)
      {
        int i = ((TRTCCloudDef.TRTCParams)localObject).sdkAppId;
        AppMethodBeat.o(258759);
        return i;
      }
    }
    AppMethodBeat.o(258759);
    return 0;
  }
  
  public final void dGW()
  {
    AppMethodBeat.i(258763);
    Object localObject1 = r.yQS;
    Object localObject2 = r.dEz();
    localObject1 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.VyS, 4);
    Object localObject3 = ((Iterable)localObject2).iterator();
    int i;
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (((axc)localObject1).SJy == j)
      {
        i = 1;
        label87:
        if (i == 0) {
          break label258;
        }
        label91:
        localObject1 = (axc)localObject1;
        if (localObject1 != null) {
          break label266;
        }
        this.zfS.SJy = 4;
        this.zfS.nickname = z.bdb();
        localObject3 = this.zfS;
        Object localObject4 = com.tencent.mm.am.q.bhP().TS(z.bcZ());
        kotlin.g.b.p.j(localObject4, "SubCoreAvatar.getImgFlag…etUsernameFromUserInfo())");
        ((axc)localObject3).ueX = ((com.tencent.mm.am.j)localObject4).bhI();
        label156:
        localObject3 = this.TAG;
        localObject4 = new StringBuilder("initVisitorRoleInfo local visitorRoleList:");
        r localr = r.yQS;
        localObject2 = ((StringBuilder)localObject4).append(r.a("initVisitorRoleInfo", (LinkedList)localObject2, j)).append(",local VisitorRoleType:").append(j).append(", local visitor role is empty:");
        if (localObject1 != null) {
          break label341;
        }
      }
    }
    label258:
    label266:
    label341:
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject3, bool + ",visitor Role:" + com.tencent.mm.ae.g.bN(this.zfS));
      AppMethodBeat.o(258763);
      return;
      i = 0;
      break label87;
      break;
      localObject1 = null;
      break label91;
      this.zfS = ((axc)localObject1);
      this.zfU = ((LinkedList)localObject2);
      localObject3 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject3, "MMKernel.storage()");
      this.zfT = ((com.tencent.mm.kernel.f)localObject3).aHp().getInt(ar.a.VyS, 4);
      localObject3 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject3, "MMKernel.storage()");
      this.zfV = ((com.tencent.mm.kernel.f)localObject3).aHp().a(ar.a.VyW, -9223372036854775808L);
      break label156;
    }
  }
  
  public final void dGX()
  {
    AppMethodBeat.i(258765);
    Log.i(this.TAG, "updateVisitorRoleInfo,before udpate:" + com.tencent.mm.ae.g.bN(this.zfS));
    Iterator localIterator = ((Iterable)this.zfU).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((axc)localObject).SJy == this.zfT)
      {
        i = 1;
        label81:
        if (i == 0) {
          break label139;
        }
      }
    }
    for (;;)
    {
      localObject = (axc)localObject;
      if (localObject != null) {
        this.zfS = ((axc)localObject);
      }
      Log.i(this.TAG, "updateVisitorRoleInfo,after udpate:" + com.tencent.mm.ae.g.bN(this.zfS));
      AppMethodBeat.o(258765);
      return;
      i = 0;
      break label81;
      label139:
      break;
      localObject = null;
    }
  }
  
  public final boolean dGY()
  {
    AppMethodBeat.i(258771);
    if (((f)business(f.class)).zhl == null)
    {
      List localList = ((f)business(f.class)).zhm;
      kotlin.g.b.p.j(localList, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      if (((Collection)localList).isEmpty()) {
        break label69;
      }
    }
    label69:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(258771);
      return true;
    }
    AppMethodBeat.o(258771);
    return false;
  }
  
  public final void g(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    AppMethodBeat.i(258769);
    Object localObject = ((f)business(f.class)).zhm;
    kotlin.g.b.p.j(localObject, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    synchronized ((Iterable)localObject)
    {
      Iterator localIterator = ???.iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        com.tencent.mm.plugin.finder.live.viewmodel.data.h localh = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject;
        boolean bool = Util.isEqual(paramh.ktR, localh.ktR);
        if (bool)
        {
          if (localObject == null) {
            ((f)business(f.class)).zhm.add(paramh);
          }
          AppMethodBeat.o(258769);
          return;
        }
      }
      localObject = null;
    }
  }
  
  public final String info()
  {
    AppMethodBeat.i(258725);
    String str = "liveId:" + ((c)business(c.class)).liveInfo.liveId + ",objectId:" + ((c)business(c.class)).info() + ", " + com.tencent.mm.ae.d.Fw(((c)business(c.class)).xbk) + ",uiState:" + this.zfu + ",liveState:" + this.zfv + ",bindShop:" + ((j)business(j.class)).info() + ",shoppingAvailable:" + ((j)business(j.class)).ziH + ",qosReport:" + this.zfN + ",qosContrl:" + this.zfO + ",curRoleType:" + this.zfS.SJy;
    AppMethodBeat.o(258725);
    return str;
  }
  
  public final boolean isLiveStarted()
  {
    return (this.zfv == 3) || (this.zfv == 2);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(258727);
    super.onCleared();
    Log.i(this.TAG, "reset22");
    ax(null);
    this.zeW.clear();
    this.zeY = null;
    this.zeZ = null;
    this.kig = "";
    this.zfa = 0;
    this.zfb = true;
    this.zfc = true;
    this.zfd = true;
    this.zfe = true;
    this.zff = true;
    this.zfg = false;
    this.zfh = null;
    pz(false);
    this.zfj = 0L;
    this.zfl = false;
    this.zfm = false;
    this.zfn = true;
    this.zfo = false;
    this.zfp = -1;
    this.zfq = 0;
    this.friendFollowCount = 0;
    this.desc = null;
    this.zfs.clear();
    dGK();
    this.zfu = 0;
    this.zfv = 0;
    this.zfw = 0;
    this.lastLiveState = 0;
    this.zfx = new com.tencent.mm.plugin.finder.live.viewmodel.data.c(null, null, null);
    this.sessionId = 0L;
    this.zfy = null;
    this.zfz = 0;
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.zfr = 0L;
    this.zfA = "";
    this.zfB = false;
    this.zfD = null;
    a(null);
    this.zfG = -1;
    Log.i(this.TAG, "set enableGift:false");
    this.yYj = false;
    this.zfH = false;
    pA(false);
    this.zfJ = true;
    LP(0L);
    this.zfM = null;
    this.zfN = false;
    this.zfO = false;
    this.fIY = "";
    this.zfP = true;
    this.zfQ = true;
    this.yeF = null;
    this.yeG = null;
    this.zfS = new axc();
    this.zfU.clear();
    this.zfT = 4;
    this.zfV = -9223372036854775808L;
    this.zfX = false;
    this.zfY = false;
    this.zfW = null;
    this.zfZ = new bap();
    this.zgb.clear();
    this.zgc.clear();
    this.zga = new com.tencent.mm.plugin.finder.live.viewmodel.data.m();
    this.yeI = 0;
    this.yeJ = 0;
    this.zfR.clear();
    this.zfC.clear();
    this.location = null;
    this.zgd = 0;
    this.zge = 0;
    this.zgf = false;
    this.zgg.clear();
    this.zgj = new com.tencent.mm.plugin.finder.live.model.b();
    this.zgk = 0;
    this.zgl = false;
    this.zgm = -1;
    this.zgn = new com.tencent.mm.plugin.finder.live.viewmodel.data.d((byte)0);
    this.zgo = null;
    this.zgp = null;
    this.zgq = false;
    this.vcr.set(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    this.kis = false;
    this.zgi = null;
    this.zgs = false;
    LQ(0L);
    this.zgu = 0;
    this.zgv = 0;
    this.zgw = null;
    this.zgx = null;
    this.zgy = false;
    this.zgz = null;
    this.zgA = 0;
    this.zgB = false;
    this.zgC = false;
    this.zgD = false;
    this.zgE = new ConcurrentLinkedDeque();
    this.zgF = null;
    this.xUD = null;
    this.zgH.clear();
    this.zgI.clear();
    this.zgK.clear();
    this.zgJ = null;
    this.zgr.clear();
    this.zgL = false;
    this.zgM = false;
    this.zgN = null;
    this.zgO = false;
    AppMethodBeat.o(258727);
  }
  
  public final void pA(boolean paramBoolean)
  {
    AppMethodBeat.i(258717);
    Log.i(this.TAG, "set enableVisitorGiftSwitch:".concat(String.valueOf(paramBoolean)));
    this.zfI = paramBoolean;
    AppMethodBeat.o(258717);
  }
  
  public final void pz(boolean paramBoolean)
  {
    AppMethodBeat.i(258712);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("liveFinish:").append(this.zfi).append(",value:").append(paramBoolean).append(",liveId:");
    Object localObject = ((c)business(c.class)).liveInfo;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((bac)localObject).liveId);; localObject = null)
    {
      Log.i(str, ((Long)localObject).longValue());
      this.zfi = paramBoolean;
      AppMethodBeat.o(258712);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258777);
    String str = info();
    AppMethodBeat.o(258777);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice$Companion;", "", "()V", "LIVE_STATE_DEFAULT", "", "LIVE_STATE_FINISHED", "LIVE_STATE_PREPARE", "LIVE_STATE_STARTED", "LIVE_STATE_STARTED_WAIT", "SUPPORT_SCREEN_ROTATION", "UI_STATE_ANCHOR_EXIT", "UI_STATE_ANCHOR_PAUSE", "UI_STATE_ANCHOR_POST", "UI_STATE_ANCHOR_STATUS_EXCEPTION", "UI_STATE_CAMERA_OPT", "UI_STATE_COMMENT", "UI_STATE_DEFAULT", "UI_STATE_DISCONNECTION", "UI_STATE_DISPLAY_LINK_APPLY_LISENCE", "UI_STATE_DISPLAY_LINK_APPLY_LIST", "UI_STATE_EXPLAIN_WECOIN_HOT", "UI_STATE_GIFT", "UI_STATE_KICKED", "UI_STATE_MEMBER_LIST", "UI_STATE_MINI_WINDOW_PERMISSION", "UI_STATE_MORE_ACTION", "UI_STATE_NORMAL", "UI_STATE_PRIVATE_PERMISSION", "UI_STATE_REAL_NAME_COMMENT", "UI_STATE_RECONNECTING", "UI_STATE_SHOPPING_PANEL", "watchOneMinCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "", "getWatchOneMinCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "plugin-finder-base_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public b(b paramb, LinkedList paramLinkedList, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public d(b paramb, bbe parambbe)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(b paramb, bag parambag, boolean paramBoolean, kotlin.g.a.m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.b
 * JD-Core Version:    0.7.0.1
 */