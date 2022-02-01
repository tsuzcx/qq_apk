package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.a.a;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.viewmodel.data.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.o;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.protocal.protobuf.epb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bf;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "adIdToUxInfoMap", "Ljava/util/HashMap;", "", "getAdIdToUxInfoMap", "()Ljava/util/HashMap;", "setAdIdToUxInfoMap", "(Ljava/util/HashMap;)V", "alertInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "getAlertInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "setAlertInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;)V", "anchorFinderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getAnchorFinderContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setAnchorFinderContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "anchorMusicData", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorMusicData;", "getAnchorMusicData", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorMusicData;", "setAnchorMusicData", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAnchorMusicData;)V", "value", "anchorPauseStartTime", "getAnchorPauseStartTime", "()J", "setAnchorPauseStartTime", "(J)V", "anchorPauseTimeCount", "", "getAnchorPauseTimeCount", "()I", "setAnchorPauseTimeCount", "(I)V", "anchorStatusFlag", "getAnchorStatusFlag", "setAnchorStatusFlag", "anchorUsername", "getAnchorUsername", "()Ljava/lang/String;", "setAnchorUsername", "(Ljava/lang/String;)V", "audioModeCoverInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveAudioModeCoverInfo;", "getAudioModeCoverInfo", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveAudioModeCoverInfo;", "setAudioModeCoverInfo", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveAudioModeCoverInfo;)V", "audioModeSwitch", "", "getAudioModeSwitch", "()Z", "setAudioModeSwitch", "(Z)V", "autoJumpRedPackId", "getAutoJumpRedPackId", "setAutoJumpRedPackId", "backEndAnchorStatusFlag", "getBackEndAnchorStatusFlag", "setBackEndAnchorStatusFlag", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "badgeInfos", "getBadgeInfos", "()Ljava/util/LinkedList;", "setBadgeInfos", "(Ljava/util/LinkedList;)V", "bannerJumpFromLandscapeClick", "getBannerJumpFromLandscapeClick", "setBannerJumpFromLandscapeClick", "bannerJumpInfoList", "Lcom/tencent/mm/plugin/finder/live/model/FinderBannerJumpInfo;", "getBannerJumpInfoList", "setBannerJumpInfoList", "cacheLayerShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerShowInfo;", "getCacheLayerShowInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerShowInfo;", "setCacheLayerShowInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerShowInfo;)V", "cacheVisitorRoleList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "getCacheVisitorRoleList", "setCacheVisitorRoleList", "cacheVisitorRoleModifyTime", "getCacheVisitorRoleModifyTime", "setCacheVisitorRoleModifyTime", "cacheVisitorRoleType", "getCacheVisitorRoleType", "setCacheVisitorRoleType", "canAppluad", "getCanAppluad", "setCanAppluad", "castScreenDeviceInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ScreenDeviceData;", "getCastScreenDeviceInfo", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ScreenDeviceData;", "setCastScreenDeviceInfo", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ScreenDeviceData;)V", "cmdItemCache", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "Lkotlin/collections/ArrayList;", "getCmdItemCache", "()Ljava/util/ArrayList;", "setCmdItemCache", "(Ljava/util/ArrayList;)V", "coCertRewardInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCoCertRewardInfo;", "getCoCertRewardInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCoCertRewardInfo;", "setCoCertRewardInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCoCertRewardInfo;)V", "commentSize", "getCommentSize", "setCommentSize", "contentRect", "Landroid/graphics/Rect;", "getContentRect", "()Landroid/graphics/Rect;", "setContentRect", "(Landroid/graphics/Rect;)V", "curBalance", "getCurBalance", "setCurBalance", "curlLikeCount", "getCurlLikeCount", "setCurlLikeCount", "desc", "getDesc", "setDesc", "disableCommentCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getDisableCommentCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setDisableCommentCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "ec_source", "getEc_source", "setEc_source", "enableAudioMode", "getEnableAudioMode", "setEnableAudioMode", "enableAudioModeFlag", "getEnableAudioModeFlag", "setEnableAudioModeFlag", "enableCommentSvr", "getEnableCommentSvr", "()Ljava/lang/Boolean;", "setEnableCommentSvr", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableCustomerComment", "getEnableCustomerComment", "setEnableCustomerComment", "enableDisplayNewHeatValue", "getEnableDisplayNewHeatValue", "setEnableDisplayNewHeatValue", "enableGift", "getEnableGift", "setEnableGift", "enableGiftAntispam", "getEnableGiftAntispam", "setEnableGiftAntispam", "enableGiftFlag", "getEnableGiftFlag", "setEnableGiftFlag", "enableGiftSwitch", "getEnableGiftSwitch", "setEnableGiftSwitch", "enableLiveRoomComment", "getEnableLiveRoomComment", "setEnableLiveRoomComment", "enableLiveRoomLike", "getEnableLiveRoomLike", "setEnableLiveRoomLike", "enableLuckyMoney", "getEnableLuckyMoney", "setEnableLuckyMoney", "enableSubtitle", "getEnableSubtitle", "setEnableSubtitle", "enableVisitorAnonymous", "getEnableVisitorAnonymous", "setEnableVisitorAnonymous", "enableVisitorGiftSwitch", "getEnableVisitorGiftSwitch", "setEnableVisitorGiftSwitch", "event_id", "getEvent_id", "setEvent_id", "event_status", "getEvent_status", "setEvent_status", "exptBeautyEnable", "getExptBeautyEnable", "setExptBeautyEnable", "exptFilterEnable", "getExptFilterEnable", "setExptFilterEnable", "externalPost", "getExternalPost", "setExternalPost", "fastCommentList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShortcutWordingInfo;", "getFastCommentList", "()Ljava/util/List;", "setFastCommentList", "(Ljava/util/List;)V", "fastCommentSendCache", "getFastCommentSendCache", "setFastCommentSendCache", "floatModeRemoveActivity", "getFloatModeRemoveActivity", "setFloatModeRemoveActivity", "forceChangeOrientation", "getForceChangeOrientation", "setForceChangeOrientation", "forceFetchObject", "getForceFetchObject", "setForceFetchObject", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "fromShareScene", "getFromShareScene", "setFromShareScene", "gameAppId", "getGameAppId", "setGameAppId", "gameInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;", "getGameInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;", "setGameInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;)V", "gameInviteInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgGameInvitationInfo;", "getGameInviteInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgGameInvitationInfo;", "setGameInviteInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgGameInvitationInfo;)V", "gameInviteInfoSeq", "getGameInviteInfoSeq", "setGameInviteInfoSeq", "gameJoinTeamSetting", "Lcom/tencent/mm/protocal/protobuf/GameJoinTeamSetting;", "getGameJoinTeamSetting", "()Lcom/tencent/mm/protocal/protobuf/GameJoinTeamSetting;", "Lcom/tencent/mm/protocal/protobuf/GameTeamUpPaymentSetting;", "gamePaymentSetting", "getGamePaymentSetting", "()Lcom/tencent/mm/protocal/protobuf/GameTeamUpPaymentSetting;", "setGamePaymentSetting", "(Lcom/tencent/mm/protocal/protobuf/GameTeamUpPaymentSetting;)V", "gameTeamUpInMiniProgram", "getGameTeamUpInMiniProgram", "setGameTeamUpInMiniProgram", "gameVersionType", "getGameVersionType", "setGameVersionType", "giftQueue", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "getGiftQueue", "()Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "setGiftQueue", "(Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;)V", "hasGetLiveReward", "getHasGetLiveReward", "setHasGetLiveReward", "hasRequestRedPacketStatus", "getHasRequestRedPacketStatus", "setHasRequestRedPacketStatus", "haveJoinLive", "getHaveJoinLive", "setHaveJoinLive", "inMiniVolumeState", "getInMiniVolumeState", "setInMiniVolumeState", "injectEvent", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/EventWrapper;", "getInjectEvent", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/EventWrapper;", "setInjectEvent", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/EventWrapper;)V", "isAssistant", "setAssistant", "isFromScan", "setFromScan", "isLiveQosControlEnabled", "setLiveQosControlEnabled", "isLiveQosReportEnabled", "setLiveQosReportEnabled", "isShowGameWelfareTask", "setShowGameWelfareTask", "isTeamFull", "setTeamFull", "isVisitorAnonymousSwitchOn", "setVisitorAnonymousSwitchOn", "joinLiveTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;", "getJoinLiveTabTipsInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;", "setJoinLiveTabTipsInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;)V", "joinLiveTips", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;", "getJoinLiveTips", "()Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;", "setJoinLiveTips", "(Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;)V", "lastAnchorPauseState", "getLastAnchorPauseState", "setLastAnchorPauseState", "lastCandidateBuffer", "", "getLastCandidateBuffer", "()[B", "setLastCandidateBuffer", "([B)V", "lastChosenTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLastChosenTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setLastChosenTagInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "lastGameRankSwitchInfo", "Lcom/tencent/mm/protocal/protobuf/GameRankSwitchInfo;", "getLastGameRankSwitchInfo", "()Lcom/tencent/mm/protocal/protobuf/GameRankSwitchInfo;", "setLastGameRankSwitchInfo", "(Lcom/tencent/mm/protocal/protobuf/GameRankSwitchInfo;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;", "lastGameTeamInfo", "getLastGameTeamInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;", "setLastGameTeamInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGameTeamInfo;)V", "lastLiveCommentSeq", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "getLastLiveCommentSeq", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "setLastLiveCommentSeq", "(Lcom/tencent/mm/algorithm/MMLRUMap;)V", "lastLiveState", "getLastLiveState", "setLastLiveState", "lastLocalTopCommentClientMsgId", "getLastLocalTopCommentClientMsgId", "setLastLocalTopCommentClientMsgId", "lastScreenSize", "Lkotlin/Pair;", "getLastScreenSize", "()Lkotlin/Pair;", "setLastScreenSize", "(Lkotlin/Pair;)V", "lastShowGameInviteInfoSeq", "getLastShowGameInviteInfoSeq", "setLastShowGameInviteInfoSeq", "lastUiState", "getLastUiState", "setLastUiState", "lastUpdateFinderObjectSeq", "getLastUpdateFinderObjectSeq", "setLastUpdateFinderObjectSeq", "likes", "getLikes", "setLikes", "liveBreakRule", "getLiveBreakRule", "setLiveBreakRule", "liveCoverUrl", "getLiveCoverUrl", "setLiveCoverUrl", "liveExtFlag", "getLiveExtFlag", "setLiveExtFlag", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "liveFinderObject", "getLiveFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setLiveFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "liveFinish", "getLiveFinish", "setLiveFinish", "liveGameData", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameData;", "getLiveGameData", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGameData;", "setLiveGameData", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGameData;)V", "liveMode", "getLiveMode", "setLiveMode", "liveRoomLikeSwitch", "getLiveRoomLikeSwitch", "setLiveRoomLikeSwitch", "liveState", "getLiveState", "setLiveState", "liveTaskInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivity;", "getLiveTaskInfo", "setLiveTaskInfo", "live_contacts_continue_flag", "getLive_contacts_continue_flag", "setLive_contacts_continue_flag", "live_contacts_max_display_count", "getLive_contacts_max_display_count", "setLive_contacts_max_display_count", "localCheerInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice$CheerInfo;", "getLocalCheerInfo", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice$CheerInfo;", "localRewardonlineMemberList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRecentRewardOnlineMember;", "getLocalRewardonlineMemberList", "setLocalRewardonlineMemberList", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "luckyMoneyData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LuckyMoneyLiveData;", "getLuckyMoneyData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LuckyMoneyLiveData;", "setLuckyMoneyData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LuckyMoneyLiveData;)V", "luckyMoneyList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "kotlin.jvm.PlatformType", "", "getLuckyMoneyList", "setLuckyMoneyList", "luckyMoneyMsgList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "getLuckyMoneyMsgList", "setLuckyMoneyMsgList", "luckyMoneySvrConfig", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLuckyMoneySvrConfig;", "getLuckyMoneySvrConfig", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLuckyMoneySvrConfig;", "setLuckyMoneySvrConfig", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLuckyMoneySvrConfig;)V", "maxVisibleRoomCount", "getMaxVisibleRoomCount", "setMaxVisibleRoomCount", "maxVisibleUserCount", "getMaxVisibleUserCount", "setMaxVisibleUserCount", "miniGameDeveloperCustomParam", "getMiniGameDeveloperCustomParam", "setMiniGameDeveloperCustomParam", "miniGameReportInfo", "getMiniGameReportInfo", "setMiniGameReportInfo", "miniGameScene", "getMiniGameScene", "setMiniGameScene", "msg_ec_source", "getMsg_ec_source", "setMsg_ec_source", "musicVolume", "getMusicVolume", "setMusicVolume", "muteMic", "getMuteMic", "setMuteMic", "muteVideoBitmap", "Landroid/graphics/Bitmap;", "getMuteVideoBitmap", "()Landroid/graphics/Bitmap;", "setMuteVideoBitmap", "(Landroid/graphics/Bitmap;)V", "myLocalCommentCache", "getMyLocalCommentCache", "setMyLocalCommentCache", "myLocalTextCommentCache", "getMyLocalTextCommentCache", "setMyLocalTextCommentCache", "needMiniWindow", "getNeedMiniWindow", "setNeedMiniWindow", "needRelaunchWeAppOnLiveFinished", "getNeedRelaunchWeAppOnLiveFinished", "setNeedRelaunchWeAppOnLiveFinished", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "notifiedRefreshGameTeamInfo", "getNotifiedRefreshGameTeamInfo", "setNotifiedRefreshGameTeamInfo", "onceEnabledLiveRoomLike", "getOnceEnabledLiveRoomLike", "setOnceEnabledLiveRoomLike", "outSideuxInfo", "getOutSideuxInfo", "setOutSideuxInfo", "participant_identity", "getParticipant_identity", "setParticipant_identity", "pauseWording", "getPauseWording", "setPauseWording", "preloadLive", "getPreloadLive", "setPreloadLive", "qosReportInterval", "getQosReportInterval", "setQosReportInterval", "relatedEventList", "Lcom/tencent/mm/protocal/protobuf/RelatedEventInfo;", "getRelatedEventList", "releaseUIKeepData", "getReleaseUIKeepData", "setReleaseUIKeepData", "remoteRewardonlineMemberList", "getRemoteRewardonlineMemberList", "setRemoteRewardonlineMemberList", "requestId", "getRequestId", "setRequestId", "riskControlEnableComment", "getRiskControlEnableComment", "setRiskControlEnableComment", "screenClear", "getScreenClear", "setScreenClear", "screenShareEnable", "getScreenShareEnable", "setScreenShareEnable", "screenShareFilePath", "getScreenShareFilePath", "setScreenShareFilePath", "screenSharePicType", "getScreenSharePicType", "setScreenSharePicType", "screenShareSwitch", "getScreenShareSwitch", "setScreenShareSwitch", "secondaryDeviceCanClose", "getSecondaryDeviceCanClose", "setSecondaryDeviceCanClose", "secondaryDeviceFlag", "getSecondaryDeviceFlag", "setSecondaryDeviceFlag", "sessionId", "getSessionId", "setSessionId", "shareUserName", "getShareUserName", "setShareUserName", "showTeenDigAtStart", "getShowTeenDigAtStart", "setShowTeenDigAtStart", "statistics", "getStatistics", "setStatistics", "statusVerifyInfo", "getStatusVerifyInfo", "setStatusVerifyInfo", "streamStatusChangedListeners", "Lkotlin/Function0;", "", "v", "stream_status", "getStream_status", "setStream_status", "subtitleInfo", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveSubtitle;", "getSubtitleInfo", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setSubtitleInfo", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "supportScreenRotation", "getSupportScreenRotation", "setSupportScreenRotation", "tagInfo", "getTagInfo", "setTagInfo", "teamup_gift_desc", "getTeamup_gift_desc", "setTeamup_gift_desc", "teamup_gift_status", "getTeamup_gift_status", "setTeamup_gift_status", "tickleUserCache", "getTickleUserCache", "setTickleUserCache", "token", "getToken", "setToken", "topCommentCache", "getTopCommentCache", "setTopCommentCache", "totalCnt", "getTotalCnt", "setTotalCnt", "uiState", "getUiState", "setUiState", "useUpdateStrategy", "getUseUpdateStrategy", "setUseUpdateStrategy", "videoHeight", "getVideoHeight", "setVideoHeight", "videoWidth", "getVideoWidth", "setVideoWidth", "visitorGiftEffectOff", "getVisitorGiftEffectOff", "setVisitorGiftEffectOff", "visitorJoinTime", "getVisitorJoinTime", "setVisitorJoinTime", "visitorRole", "getVisitorRole", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "setVisitorRole", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;)V", "vrLiveType", "getVrLiveType", "setVrLiveType", "appendAudioModeTip", "roomData", "appendGameTeamModeTip", "appendGiftTip", "audienceMode", "canShowGameRankGuide", "diffCheerInfos", "remoteInfo", "Lcom/tencent/mm/protocal/protobuf/CheerIconInfo;", "enable", "getCommentBadge", "getCurGameSwitchInfo", "Lcom/tencent/mm/protocal/protobuf/GameRankSwitch;", "getLastGameSwitchInfo", "getTrtcKeyParams", "handleCheerIconMsg", "remoteLiveAppMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "handleUpdateFinderAppMsg", "hasJoinLive", "info", "initVisitorRoleInfo", "isAnchor", "isAnchorAliveExpired", "isLandscapeVideo", "isLinkMicVideo", "isLiveFinish", "isLiveIdle", "isLivePrepare", "isLiveStarted", "isLuckyMoneyEnable", "luckyMoneyConfig", "isLuckyMoneyFestival", "isLuckyMoneyNormal", "isMicLinking", "isVrLive", "needFetchFeedObject", "onCleared", "printNewBadgeList", "oriList", "newList", "printRedPacketInfoList", "prefix", "fromJoinLive", "registerStreamStatusListener", "listener", "reset2", "resetFastCommentInfoToList", "remoteFastCommentInfoList", "resetRedPackInfoToList", "liveMsgRedPacketInfoList", "safeAddAudienceMicUser", "micUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "safeResetAlertInfo", "safeSetAlertInfo", "sdkAppId", "selfSdkLiveId", "selfSdkUserId", "setupOnceExptConfig", "toString", "unregisterStreamStatusListener", "updateAnchorStatus", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "updateAnchorStatus2", "updateCheerInfos", "cheerInfos", "iconBtnUrl", "updateCoverInfo", "updateFinderInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgUpdateFinderObjectInfo;", "updateFuncEnableAnchor", "switchFlag", "updateFuncEnableVisitor", "contactFlag", "updateJoinLiveCommentState", "enableComment", "(Ljava/lang/Integer;)V", "updateLayerShowInfo", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "pause", "lastPauseTime", "updateLiveDesc", "updateLocalAnchorStatus", "updateLocalSwitchFlag", "updateVisitorRoleInfo", "validVideoSize", "CheerInfo", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final e.b Eck;
  public bkk BvE;
  public int CFc;
  public LinkedList<bno> CFd;
  public bno CFe;
  public int CFg;
  public int CFh;
  public bha CFy;
  private boolean DRP;
  public boolean DUe;
  public Bitmap DVR;
  public int DXO;
  public bcb Ebs;
  public boolean EcA;
  public final List<epb> EcB;
  public List<kotlin.g.a.a<ah>> EcC;
  public volatile boolean EcD;
  public long EcE;
  public long EcF;
  public boolean EcG;
  public boolean EcH;
  public boolean EcI;
  public boolean EcJ;
  public int EcK;
  public int EcL;
  public long EcM;
  public ConcurrentHashMap<String, Boolean> EcN;
  public bkf EcO;
  public boolean EcP;
  public auy EcQ;
  public int EcR;
  public int EcS;
  public int EcT;
  public int EcU;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.c EcV;
  public String EcW;
  public int EcX;
  private String EcY;
  public long EcZ;
  public com.tencent.mm.plugin.finder.live.util.s Ecl;
  public LinkedList<bfl> Ecm;
  public bcc Ecn;
  public FinderObject Eco;
  public int Ecp;
  public long Ecq;
  public boolean Ecr;
  public boolean Ecs;
  public boolean Ect;
  public boolean Ecu;
  public boolean Ecv;
  public boolean Ecw;
  public boolean Ecx;
  public boolean Ecy;
  public byte[] Ecz;
  public final e.a EdA;
  public Boolean EdB;
  public boolean EdC;
  public boolean EdD;
  public int EdE;
  public boolean EdF;
  public boolean EdG;
  public com.tencent.mm.b.h<Long, com.tencent.mm.plugin.finder.live.model.aq> EdH;
  public bcz EdI;
  public int EdJ;
  public LinkedList<bcz> EdK;
  public long EdL;
  public String EdM;
  public boolean EdN;
  public boolean EdO;
  public bjh EdP;
  public n EdQ;
  private List<bke> EdR;
  public List<bls> EdS;
  public List<bmw> EdT;
  private ArrayList<auw> EdU;
  public ArrayList<String> EdV;
  public int EdW;
  public int EdX;
  public boolean EdY;
  public List<String> EdZ;
  public boolean Eda;
  public boolean Edb;
  public com.tencent.mm.b.h<String, Long> Edc;
  public int Edd;
  public String Ede;
  public boolean Edf;
  public bhf Edg;
  public boolean Edh;
  public boolean Edi;
  public bgz Edj;
  public bee Edk;
  public long Edl;
  public long Edm;
  public String Edn;
  public String Edo;
  public LinkedList<com.tencent.mm.plugin.finder.live.model.b> Edp;
  public boolean Edq;
  public boolean Edr;
  private boolean Eds;
  public cbw Edt;
  public int Edu;
  public boolean Edv;
  public boolean Edw;
  public boolean Edx;
  public long Edy;
  public boolean Edz;
  public boolean EeA;
  public ConcurrentLinkedDeque<com.tencent.mm.plugin.finder.live.viewmodel.data.k> EeB;
  public String EeC;
  public LinkedList<blq> EeD;
  public LinkedList<blq> EeE;
  public String EeF;
  public HashMap<Long, String> EeG;
  private boolean EeH;
  private boolean EeI;
  public String EeJ;
  public boolean EeK;
  public long EeL;
  public boolean EeM;
  public r<Integer, Integer> EeN;
  private boolean EeO;
  public List<String> Eea;
  public List<com.tencent.mm.plugin.finder.live.model.aq> Eeb;
  public String Eec;
  public o Eed;
  public com.tencent.mm.plugin.finder.live.model.c Eee;
  public int Eef;
  public boolean Eeg;
  public int Eeh;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.d Eei;
  public com.tencent.mm.plugin.finder.api.m Eej;
  public boolean Eek;
  public LinkedList<blk> Eel;
  public boolean Eem;
  public long Een;
  public int Eeo;
  public int Eep;
  public bix Eeq;
  public String Eer;
  public boolean Ees;
  public boolean Eet;
  public String Eeu;
  public int Eev;
  public String Eew;
  public String Eex;
  public boolean Eey;
  public boolean Eez;
  public final String TAG;
  public String desc;
  public int friendFollowCount;
  public String hOG;
  public int lastLiveState;
  public boi location;
  public String mIC;
  public boolean mIR;
  public String mIS;
  public int mIT;
  public int mIX;
  public int mIY;
  public int mIZ;
  public int mJa;
  public int mJb;
  public long sessionId;
  public String token;
  public int videoHeight;
  public int videoWidth;
  private Rect yok;
  
  static
  {
    AppMethodBeat.i(356998);
    Eck = new e.b((byte)0);
    AppMethodBeat.o(356998);
  }
  
  public e(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356933);
    this.TAG = kotlin.g.b.s.X("LiveCommonSlice@", Integer.valueOf(hashCode()));
    this.Ecl = ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUH();
    this.mIC = "";
    this.Ecr = true;
    this.Ecs = true;
    this.Ect = true;
    this.Ecw = true;
    this.Ecx = true;
    this.token = "";
    this.mJb = -1;
    this.EcB = ((List)new ArrayList());
    this.EcC = ((List)new ArrayList());
    this.EcI = true;
    this.EcK = -1;
    this.EcN = new ConcurrentHashMap();
    this.EcV = new com.tencent.mm.plugin.finder.live.viewmodel.data.c(null, null, null);
    this.EcY = "";
    parama = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXj().bmg()).intValue() == 1)
    {
      bool1 = true;
      this.Edb = bool1;
      this.Edc = new com.tencent.mm.b.h(100);
      this.Ede = "";
      this.Edl = -1L;
      this.Edm = -1L;
      this.Edn = "";
      this.Edo = "";
      this.Edp = new LinkedList();
      this.Edr = true;
      this.Eds = true;
      this.Edu = -1;
      this.Edx = true;
      this.EdA = new e.a();
      this.CFc = 1;
      this.EdE = 2;
      this.EdF = true;
      this.EdG = true;
      this.hOG = "";
      this.EdH = new com.tencent.mm.b.h(1000);
      this.EdI = new bcz();
      this.EdJ = 4;
      this.EdK = new LinkedList();
      this.EdL = -9223372036854775808L;
      parama = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jSV().bmg()).intValue() != 1) {
        break label776;
      }
    }
    label776:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.EdN = bool1;
      this.EdP = new bjh();
      this.EdQ = new n();
      this.EdR = Collections.synchronizedList((List)new ArrayList());
      this.EdS = Collections.synchronizedList((List)new ArrayList());
      parama = Collections.synchronizedList((List)new ArrayList());
      kotlin.g.b.s.s(parama, "synchronizedList(ArrayLi…veShortcutWordingInfo>())");
      this.EdT = parama;
      this.EdU = new ArrayList();
      this.EdV = new ArrayList();
      this.yok = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
      this.mIS = "";
      this.EdY = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adfd, false);
      this.EdZ = Collections.synchronizedList((List)new ArrayList());
      this.Eea = Collections.synchronizedList((List)new ArrayList());
      this.Eeb = Collections.synchronizedList((List)new ArrayList());
      this.Eec = "";
      this.Eee = new com.tencent.mm.plugin.finder.live.model.c();
      parama = com.tencent.d.a.a.a.a.a.ahiX;
      this.Eef = ((Number)com.tencent.d.a.a.a.a.a.jRT().bmg()).intValue();
      this.Eeh = -1;
      this.Eei = new com.tencent.mm.plugin.finder.live.viewmodel.data.d((byte)0);
      this.Eel = new LinkedList();
      this.Eew = "";
      this.Eex = "";
      this.EeB = new ConcurrentLinkedDeque();
      this.EeD = new LinkedList();
      this.EeE = new LinkedList();
      this.EeG = new HashMap();
      this.EeN = new r(Integer.valueOf(0), Integer.valueOf(0));
      parama = this.TAG;
      aw localaw = aw.Gjk;
      Log.i(parama, kotlin.g.b.s.X("LiveBuContext init ", aw.fgr()));
      AppMethodBeat.o(356933);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static boolean Qa(int paramInt)
  {
    return paramInt != 1;
  }
  
  public static boolean Qb(int paramInt)
  {
    return paramInt == 3;
  }
  
  public static boolean Qc(int paramInt)
  {
    return paramInt == 2;
  }
  
  private final boolean i(LinkedList<acl> arg1, int paramInt)
  {
    AppMethodBeat.i(356967);
    StringBuffer localStringBuffer = new StringBuffer(String.valueOf(this.EdA.lTH));
    acl localacl;
    synchronized ((Iterable)this.EdA.EeP)
    {
      localObject3 = ((Iterable)???).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localacl = (acl)((Iterator)localObject3).next();
        localStringBuffer.append(localacl.icon_url).append(localacl.ZkN);
      }
    }
    Object localObject3 = ah.aiuX;
    ??? = new StringBuffer(String.valueOf(paramInt));
    if (??? != null)
    {
      synchronized ((Iterable)???)
      {
        localObject3 = ???.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localacl = (acl)((Iterator)localObject3).next();
          ((StringBuffer)???).append(localacl.icon_url).append(localacl.ZkN);
        }
      }
      localObject3 = ah.aiuX;
    }
    if (!Util.isEqual(localObject1, ???))
    {
      AppMethodBeat.o(356967);
      return true;
    }
    AppMethodBeat.o(356967);
    return false;
  }
  
  public static void pa(long paramLong)
  {
    AppMethodBeat.i(356944);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adaF, Long.valueOf(paramLong));
    AppMethodBeat.o(356944);
  }
  
  public static void pb(long paramLong)
  {
    AppMethodBeat.i(356950);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adaG, Long.valueOf(paramLong));
    AppMethodBeat.o(356950);
  }
  
  public final void PY(int paramInt)
  {
    AppMethodBeat.i(357047);
    Object localObject = bj.GlQ;
    paramInt = bj.Uy(paramInt);
    if (this.mJb != paramInt)
    {
      localObject = ((Iterable)this.EcC).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((kotlin.g.a.a)((Iterator)localObject).next()).invoke();
      }
    }
    Log.i(this.TAG, kotlin.g.b.s.X("olympics set stream_status:", Integer.valueOf(paramInt)));
    this.mJb = paramInt;
    AppMethodBeat.o(357047);
  }
  
  public final void PZ(int paramInt)
  {
    AppMethodBeat.i(357062);
    if (paramInt != this.EcR) {
      Log.i(this.TAG, kotlin.g.b.s.X("liveMode ", Integer.valueOf(paramInt)));
    }
    this.EcR = paramInt;
    AppMethodBeat.o(357062);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.c paramc)
  {
    AppMethodBeat.i(357068);
    kotlin.g.b.s.u(paramc, "<set-?>");
    this.EcV = paramc;
    AppMethodBeat.o(357068);
  }
  
  public final void a(bix parambix, boolean paramBoolean, kotlin.g.a.m<? super Boolean, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(357329);
    kotlin.g.b.s.u(parambix, "info");
    kotlin.g.b.s.u(paramm, "callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e.g(this, parambix, paramBoolean, paramm));
    AppMethodBeat.o(357329);
  }
  
  public final void a(cca paramcca)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(357098);
    Object localObject1 = this.CFy;
    if (localObject1 == null) {
      localObject1 = localIterator;
    }
    Object localObject2;
    do
    {
      do
      {
        if (localObject1 != null) {
          ((des)localObject1).ZGd = paramcca;
        }
        AppMethodBeat.o(357098);
        return;
        localObject2 = ((bha)localObject1).ZQy;
        localObject1 = localIterator;
      } while (localObject2 == null);
      localObject2 = ((cbr)localObject2).aakZ;
      localObject1 = localIterator;
    } while (localObject2 == null);
    localIterator = ((Iterable)localObject2).iterator();
    label78:
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (((des)localObject1).value == 7)
      {
        i = 1;
        label110:
        if (i == 0) {
          break label125;
        }
      }
    }
    for (;;)
    {
      localObject1 = (des)localObject1;
      break;
      i = 0;
      break label110;
      label125:
      break label78;
      localObject1 = null;
    }
  }
  
  public final void a(LinkedList<acl> paramLinkedList, String paramString, int paramInt)
  {
    AppMethodBeat.i(357346);
    Log.i(this.TAG, "updateCheerInfos. cheerInfos:" + paramLinkedList + " iconBtnUrl:" + paramString + " enable:" + paramInt);
    if (i(paramLinkedList, paramInt)) {
      if (paramInt == 0)
      {
        Log.i(this.TAG, "updateCheerInfos. disable custom cheer info");
        this.EdA.EeP.clear();
        this.EdA.tXv = true;
      }
    }
    for (;;)
    {
      this.EdA.EeQ = paramString;
      this.EdA.lTH = paramInt;
      AppMethodBeat.o(357346);
      return;
      Log.i(this.TAG, kotlin.g.b.s.X("updateCheerInfos. new cheerInfo:", paramLinkedList));
      this.EdA.EeP.clear();
      Collection localCollection = (Collection)paramLinkedList;
      if ((localCollection == null) || (localCollection.isEmpty())) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label195;
        }
        this.EdA.EeP.addAll((Collection)paramLinkedList);
        break;
      }
      label195:
      break;
      this.EdA.tXv = false;
      Log.i(this.TAG, "updateCheerInfos. skip by no differences");
    }
  }
  
  public final void aD(LinkedList<bfl> paramLinkedList)
  {
    Object localObject2 = null;
    int k = 0;
    AppMethodBeat.i(357009);
    int i;
    if (paramLinkedList != null)
    {
      Object localObject3 = ((Iterable)paramLinkedList).iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label178;
        }
        localObject1 = ((Iterator)localObject3).next();
        if (((bfl)localObject1).ZPp != 4) {
          break;
        }
        i = 1;
      } while (i == 0);
      label64:
      localObject3 = (bfl)localObject1;
      if (localObject3 != null)
      {
        localObject1 = ((bfl)localObject3).ZPs;
        if (localObject1 != null) {
          break label194;
        }
        localObject1 = ((h)business(h.class)).Efg;
        if (localObject1 != null) {
          break label184;
        }
        localObject1 = localObject2;
        label112:
        ((bfl)localObject3).ZPs = ((String)localObject1);
      }
    }
    Object localObject1 = (List)this.Ecm;
    localObject2 = (List)paramLinkedList;
    label141:
    int j;
    if (localObject2 == null)
    {
      i = 0;
      if (localObject1 != null) {
        break label208;
      }
      j = 0;
      label148:
      if (i == j) {
        break label327;
      }
    }
    for (;;)
    {
      try
      {
        e.b.n((List)localObject2, "printNewBadgeList");
        this.Ecm = paramLinkedList;
        AppMethodBeat.o(357009);
        return;
        i = 0;
        break;
        label178:
        localObject1 = null;
        break label64;
        label184:
        localObject1 = ((bgw)localObject1).ZQn;
        break label112;
        label194:
        break label112;
        i = ((List)localObject2).size();
        break label141;
        label208:
        j = ((List)localObject1).size();
        break label148;
        k = j + 1;
        if ((((bfl)((List)localObject2).get(j)).ZPp != ((bfl)((List)localObject1).get(j)).ZPp) || (((bfl)((List)localObject2).get(j)).ZPr != ((bfl)((List)localObject1).get(j)).ZPr))
        {
          e.b.n((List)localObject2, "printNewBadgeList");
          continue;
        }
      }
      catch (Exception localException)
      {
        localObject2 = aw.Gjk;
        aw.a(localException, "printNewBadgeList");
        continue;
        if (k >= i) {
          continue;
        }
        j = k;
        continue;
      }
      label327:
      if ((localObject2 != null) && (localException != null) && (i > 0)) {
        j = k;
      }
    }
  }
  
  public final void ayk(String paramString)
  {
    AppMethodBeat.i(357083);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.EcY = paramString;
    AppMethodBeat.o(357083);
  }
  
  public final void ayl(String paramString)
  {
    AppMethodBeat.i(357133);
    kotlin.g.b.s.u(paramString, "value");
    Object localObject = (q)business(q.class);
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) {
        break label72;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject).DVj.request_id = paramString;
      }
      this.hOG = paramString;
      AppMethodBeat.o(357133);
      return;
      localObject = ((q)localObject).Eie;
      break;
      label72:
      localObject = null;
    }
  }
  
  public final void aym(String paramString)
  {
    AppMethodBeat.i(357146);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.Eec = paramString;
    AppMethodBeat.o(357146);
  }
  
  public final void ayn(String paramString)
  {
    AppMethodBeat.i(357162);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.Eew = paramString;
    AppMethodBeat.o(357162);
  }
  
  public final void ayo(String paramString)
  {
    AppMethodBeat.i(357168);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.Eex = paramString;
    AppMethodBeat.o(357168);
  }
  
  public final void b(bhf parambhf)
  {
    if ((parambhf != null) && (parambhf.status == 3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.Edi = bool;
      this.Edg = parambhf;
      return;
    }
  }
  
  public final boolean bUB()
  {
    AppMethodBeat.i(357208);
    Object localObject = ((f)business(f.class)).mZu;
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      boolean bool = Util.isEqual((String)localObject, eyF());
      AppMethodBeat.o(357208);
      return bool;
      localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mJH;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((g)localObject).mNo;
      }
    }
  }
  
  public final void bp(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(357051);
    kotlin.g.b.s.u(parama, "listener");
    if (!this.EcC.contains(parama)) {
      this.EcC.add(parama);
    }
    AppMethodBeat.o(357051);
  }
  
  public final void c(r<Integer, Integer> paramr)
  {
    AppMethodBeat.i(357175);
    kotlin.g.b.s.u(paramr, "<set-?>");
    this.EeN = paramr;
    AppMethodBeat.o(357175);
  }
  
  public final boolean ejX()
  {
    AppMethodBeat.i(357277);
    boolean bool = eyD();
    Log.i(this.TAG, kotlin.g.b.s.X("isLandscapeVideo validVideoSize:", Boolean.valueOf(bool)));
    if ((bool) && (this.videoWidth >= this.videoHeight))
    {
      AppMethodBeat.o(357277);
      return true;
    }
    AppMethodBeat.o(357277);
    return false;
  }
  
  public final boolean eyA()
  {
    return this.EcT == 3;
  }
  
  public final boolean eyB()
  {
    return this.EcT == 0;
  }
  
  public final boolean eyC()
  {
    return this.EcX == 1;
  }
  
  public final boolean eyD()
  {
    AppMethodBeat.i(357283);
    Log.i(this.TAG, "validVideoSize videoWidth:" + this.videoWidth + ",videoHeight:" + this.videoHeight);
    if ((this.videoWidth > 0) && (this.videoHeight > 0))
    {
      AppMethodBeat.o(357283);
      return true;
    }
    AppMethodBeat.o(357283);
    return false;
  }
  
  public final boolean eyE()
  {
    bool2 = false;
    AppMethodBeat.i(357291);
    Log.i(this.TAG, "isLinkMicVideo videoWidth:" + this.videoWidth + ",videoHeight:" + this.videoHeight);
    bool1 = bool2;
    for (;;)
    {
      try
      {
        if (this.videoWidth > 0)
        {
          bool1 = bool2;
          if (this.videoHeight > 0)
          {
            float f = new BigDecimal(this.videoWidth / this.videoHeight).setScale(1, 4).floatValue();
            if (f != 1.1F) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              if (f != 1.0F) {
                continue;
              }
              i = 1;
              bool1 = bool2;
              if (i == 0) {}
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
        int i;
        Log.w(this.TAG, kotlin.g.b.s.X("ex:", localException.getMessage()));
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(357291);
      return bool1;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final String eyF()
  {
    AppMethodBeat.i(357296);
    Object localObject = ((f)business(f.class)).mZu;
    if (localObject == null)
    {
      AppMethodBeat.o(357296);
      return null;
    }
    localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mNz;
    if (localObject == null)
    {
      AppMethodBeat.o(357296);
      return null;
    }
    localObject = ((TRTCCloudDef.TRTCParams)localObject).userId;
    AppMethodBeat.o(357296);
    return localObject;
  }
  
  public final int eyG()
  {
    AppMethodBeat.i(357301);
    Object localObject = ((f)business(f.class)).mZu;
    if (localObject == null)
    {
      AppMethodBeat.o(357301);
      return 0;
    }
    localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mNz;
    if (localObject == null)
    {
      AppMethodBeat.o(357301);
      return 0;
    }
    int i = ((TRTCCloudDef.TRTCParams)localObject).roomId;
    AppMethodBeat.o(357301);
    return i;
  }
  
  public final int eyH()
  {
    AppMethodBeat.i(357303);
    Object localObject = ((f)business(f.class)).mZu;
    if (localObject == null)
    {
      AppMethodBeat.o(357303);
      return 0;
    }
    localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mNz;
    if (localObject == null)
    {
      AppMethodBeat.o(357303);
      return 0;
    }
    int i = ((TRTCCloudDef.TRTCParams)localObject).sdkAppId;
    AppMethodBeat.o(357303);
    return i;
  }
  
  public final void eyI()
  {
    AppMethodBeat.i(357313);
    Object localObject1 = bj.GlQ;
    if ((bj.y(this.CBK)) && (this.EdJ != 4))
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("initVisitorRoleInfo olympics visitorRoleList:");
      localObject3 = com.tencent.mm.plugin.finder.live.util.u.DJC;
      Log.i((String)localObject1, com.tencent.mm.plugin.finder.live.util.u.a("initVisitorRoleInfo", this.EdK, this.EdJ) + ", cacheVisitorRoleType:" + this.EdJ + ", visitor Role:" + com.tencent.mm.ae.f.dg(this.EdI));
      AppMethodBeat.o(357313);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.live.util.u.DJC;
    Object localObject2 = com.tencent.mm.plugin.finder.live.util.u.euA();
    int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaO, 4);
    Object localObject3 = ((Iterable)localObject2).iterator();
    int i;
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (((bcz)localObject1).ZNI == j)
      {
        i = 1;
        label184:
        if (i == 0) {
          break label339;
        }
        label188:
        localObject1 = (bcz)localObject1;
        if (localObject1 != null) {
          break label347;
        }
        this.EdI.ZNI = 4;
        this.EdI.nickname = z.bAO();
        this.EdI.xkY = com.tencent.mm.modelavatar.q.bFE().LS(z.bAM()).bFx();
        label237:
        localObject3 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("initVisitorRoleInfo local visitorRoleList:");
        com.tencent.mm.plugin.finder.live.util.u localu = com.tencent.mm.plugin.finder.live.util.u.DJC;
        localObject2 = localStringBuilder.append(com.tencent.mm.plugin.finder.live.util.u.a("initVisitorRoleInfo", (LinkedList)localObject2, j)).append(",local VisitorRoleType:").append(j).append(", local visitor role is empty:");
        if (localObject1 != null) {
          break label386;
        }
      }
    }
    label386:
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject3, bool + ",visitor Role:" + com.tencent.mm.ae.f.dg(this.EdI));
      AppMethodBeat.o(357313);
      return;
      i = 0;
      break label184;
      label339:
      break;
      localObject1 = null;
      break label188;
      label347:
      this.EdI = ((bcz)localObject1);
      this.EdK = ((LinkedList)localObject2);
      this.EdJ = j;
      this.EdL = com.tencent.mm.kernel.h.baE().ban().a(at.a.adaS, -9223372036854775808L);
      break label237;
    }
  }
  
  public final void eyJ()
  {
    AppMethodBeat.i(357321);
    Log.i(this.TAG, kotlin.g.b.s.X("updateVisitorRoleInfo,before udpate:", com.tencent.mm.ae.f.dg(this.EdI)));
    Iterator localIterator = ((Iterable)this.EdK).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((bcz)localObject).ZNI == this.EdJ)
      {
        i = 1;
        label71:
        if (i == 0) {
          break label119;
        }
      }
    }
    for (;;)
    {
      localObject = (bcz)localObject;
      if (localObject != null) {
        this.EdI = ((bcz)localObject);
      }
      Log.i(this.TAG, kotlin.g.b.s.X("updateVisitorRoleInfo,after udpate:", com.tencent.mm.ae.f.dg(this.EdI)));
      AppMethodBeat.o(357321);
      return;
      i = 0;
      break label71;
      label119:
      break;
      localObject = null;
    }
  }
  
  public final boolean eyK()
  {
    AppMethodBeat.i(357327);
    if (((j)business(j.class)).Efv == null)
    {
      List localList = ((j)business(j.class)).Efw;
      kotlin.g.b.s.s(localList, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      if (((Collection)localList).isEmpty()) {
        break label69;
      }
    }
    label69:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(357327);
      return true;
    }
    AppMethodBeat.o(357327);
    return false;
  }
  
  public final LinkedList<bfl> eyL()
  {
    Object localObject1 = null;
    AppMethodBeat.i(357338);
    Object localObject2 = this.Ecm;
    if (localObject2 == null)
    {
      if (localObject1 != null)
      {
        localObject2 = new LinkedList();
        ((LinkedList)localObject2).add(localObject1);
        AppMethodBeat.o(357338);
        return localObject2;
      }
    }
    else
    {
      localObject2 = ((Iterable)localObject2).iterator();
      label53:
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        if (((bfl)localObject1).ZPp == 5)
        {
          i = 1;
          label82:
          if (i == 0) {
            break label97;
          }
        }
      }
      for (;;)
      {
        localObject1 = (bfl)localObject1;
        break;
        i = 0;
        break label82;
        label97:
        break label53;
        localObject1 = null;
      }
    }
    localObject1 = this.Ecm;
    AppMethodBeat.o(357338);
    return localObject1;
  }
  
  public final boolean eyM()
  {
    AppMethodBeat.i(357351);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jUG().bmg()).intValue() == 1) {}
    for (int i = 1; (i != 0) && (this.mIX == 1); i = 0)
    {
      AppMethodBeat.o(357351);
      return true;
    }
    AppMethodBeat.o(357351);
    return false;
  }
  
  public final String eyh()
  {
    return this.mIC;
  }
  
  public final String eyo()
  {
    AppMethodBeat.i(357078);
    Object localObject = this.Eco;
    if (localObject != null)
    {
      localObject = ((FinderObject)localObject).liveInfo;
      if ((localObject != null) && (((bip)localObject).ZRU == 1)) {
        i = 1;
      }
    }
    while (i != 0)
    {
      localObject = this.Eco;
      if (localObject == null)
      {
        AppMethodBeat.o(357078);
        return "";
        i = 0;
      }
      else
      {
        localObject = ((FinderObject)localObject).objectDesc;
        if (localObject == null)
        {
          AppMethodBeat.o(357078);
          return "";
        }
        localObject = ((FinderObjectDesc)localObject).liveDesc;
        if (localObject == null)
        {
          AppMethodBeat.o(357078);
          return "";
        }
        localObject = ((bgk)localObject).EcY;
        if (localObject == null)
        {
          AppMethodBeat.o(357078);
          return "";
        }
        AppMethodBeat.o(357078);
        return localObject;
      }
    }
    localObject = (CharSequence)this.EcY;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = aw.Gjk;
      if (aw.bgV()) {
        Log.i(this.TAG, kotlin.g.b.s.X("liveCoverUrl field:", this.EcY));
      }
      localObject = this.EcY;
      AppMethodBeat.o(357078);
      return localObject;
    }
    localObject = this.Eco;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject != null)
    {
      localObject = kotlin.g.b.s.X(((FinderMedia)localObject).thumbUrl, Util.nullAsNil(((FinderMedia)localObject).thumb_url_token));
      AppMethodBeat.o(357078);
      return localObject;
      localObject = ((FinderObject)localObject).objectDesc;
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (FinderMedia)p.oL((List)localObject);
        }
      }
    }
    AppMethodBeat.o(357078);
    return "";
  }
  
  public final cca eyp()
  {
    AppMethodBeat.i(357093);
    Object localObject = this.CFy;
    if (localObject == null)
    {
      AppMethodBeat.o(357093);
      return null;
    }
    localObject = ((bha)localObject).ZQy;
    if (localObject == null)
    {
      AppMethodBeat.o(357093);
      return null;
    }
    localObject = ((cbr)localObject).aakZ;
    if (localObject == null)
    {
      AppMethodBeat.o(357093);
      return null;
    }
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((des)localObject).value == 7)
      {
        i = 1;
        label97:
        if (i == 0) {
          break label121;
        }
      }
    }
    for (;;)
    {
      localObject = (des)localObject;
      if (localObject != null) {
        break label128;
      }
      AppMethodBeat.o(357093);
      return null;
      i = 0;
      break label97;
      label121:
      break;
      localObject = null;
    }
    label128:
    localObject = ((des)localObject).ZGd;
    AppMethodBeat.o(357093);
    return localObject;
  }
  
  public final cbm eyq()
  {
    AppMethodBeat.i(357109);
    cbm localcbm = new cbm();
    bha localbha = this.CFy;
    if (localbha == null) {}
    for (int i = 0;; i = localbha.ZQz)
    {
      localcbm.aakL = i;
      localcbm.ZGd = eyp();
      AppMethodBeat.o(357109);
      return localcbm;
    }
  }
  
  public final boolean eyr()
  {
    return this.Edu == 1;
  }
  
  public final boolean eys()
  {
    AppMethodBeat.i(357139);
    Collection localCollection = (Collection)this.EdQ.EbY;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(357139);
      return true;
    }
    AppMethodBeat.o(357139);
    return false;
  }
  
  public final boolean eyt()
  {
    return this.Eeh == 1;
  }
  
  public final int eyu()
  {
    AppMethodBeat.i(357221);
    Object localObject = ((f)business(f.class)).mZu;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      localObject = com.tencent.mm.live.core.core.e.b.mKf;
      i = com.tencent.mm.live.core.core.e.b.bcu();
      AppMethodBeat.o(357221);
      return i;
      localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mJH;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Integer.valueOf(((g)localObject).mNn);
      }
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(357221);
    return i;
  }
  
  public final cbv eyv()
  {
    AppMethodBeat.i(357229);
    Object localObject2 = this.CFy;
    Object localObject1 = this.Edt;
    if ((localObject2 != null) && (localObject1 != null))
    {
      Object localObject3 = com.tencent.mm.plugin.finder.live.util.u.DJC;
      com.tencent.mm.plugin.finder.live.util.u.a((cbw)localObject1, kotlin.g.b.s.X(this.TAG, "_getlast"));
      localObject2 = ((bha)localObject2).Idh;
      localObject3 = (CharSequence)localObject2;
      int i;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {
        i = 1;
      }
      while (i == 0)
      {
        localObject1 = ((cbw)localObject1).aalh;
        if (localObject1 == null)
        {
          AppMethodBeat.o(357229);
          return null;
          i = 0;
        }
        else
        {
          localObject3 = ((Iterable)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = ((Iterator)localObject3).next();
          } while (!kotlin.g.b.s.p(((cbv)localObject1).ZGM, localObject2));
          for (;;)
          {
            localObject1 = (cbv)localObject1;
            AppMethodBeat.o(357229);
            return localObject1;
            localObject1 = null;
          }
        }
      }
    }
    AppMethodBeat.o(357229);
    return null;
  }
  
  public final cbv eyw()
  {
    AppMethodBeat.i(357238);
    Object localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adfm, "");
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(357238);
      throw ((Throwable)localObject1);
    }
    Object localObject3 = (String)localObject1;
    if (!Util.isNullOrNil((String)localObject3))
    {
      localObject1 = (com.tencent.mm.bx.a)new cbw();
      localObject3 = Util.decodeHexString((String)localObject3);
    }
    for (;;)
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (cbw)localObject1;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.finder.live.util.u.DJC;
          com.tencent.mm.plugin.finder.live.util.u.a((cbw)localObject1, kotlin.g.b.s.X(this.TAG, "_getcur"));
        }
        localObject3 = this.CFy;
        if ((localObject3 != null) && (localObject1 != null))
        {
          localObject3 = ((bha)localObject3).Idh;
          localObject4 = (CharSequence)localObject3;
          if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0))
          {
            i = 1;
            if (i != 0) {
              continue;
            }
            localObject1 = ((cbw)localObject1).aalh;
            if (localObject1 != null) {
              continue;
            }
            AppMethodBeat.o(357238);
            return null;
          }
        }
      }
      catch (Exception localException)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        localObject2 = null;
        continue;
        int i = 0;
        continue;
        Object localObject4 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localObject2 = ((Iterator)localObject4).next();
          if (!kotlin.g.b.s.p(((cbv)localObject2).ZGM, localObject3)) {
            continue;
          }
          localObject2 = (cbv)localObject2;
          AppMethodBeat.o(357238);
          return localObject2;
        }
        localObject2 = null;
        continue;
        AppMethodBeat.o(357238);
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  public final void eyx()
  {
    AppMethodBeat.i(357244);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(357244);
  }
  
  public final String eyy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(357247);
    StringBuilder localStringBuilder = new StringBuilder("appId:");
    Object localObject1 = ((f)business(f.class)).mZu;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append("\nroomId:");
      localObject1 = ((f)business(f.class)).mZu;
      if (localObject1 != null) {
        break label118;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = localObject1 + '\n';
      AppMethodBeat.o(357247);
      return localObject1;
      localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).mNz;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Integer.valueOf(((TRTCCloudDef.TRTCParams)localObject1).sdkAppId);
      break;
      label118:
      TRTCCloudDef.TRTCParams localTRTCParams = ((com.tencent.mm.live.core.core.model.h)localObject1).mNz;
      localObject1 = localObject2;
      if (localTRTCParams != null) {
        localObject1 = Integer.valueOf(localTRTCParams.roomId);
      }
    }
  }
  
  public final boolean eyz()
  {
    return this.EcT == 1;
  }
  
  public final void g(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    AppMethodBeat.i(357325);
    Object localObject1 = ((j)business(j.class)).Efw;
    kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    synchronized ((Iterable)localObject1)
    {
      Iterator localIterator = ???.iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        com.tencent.mm.plugin.finder.live.viewmodel.data.h localh = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2;
        if (paramh == null) {}
        for (localObject1 = null;; localObject1 = paramh.mXL)
        {
          boolean bool = Util.isEqual((String)localObject1, localh.mXL);
          if (!bool) {
            break;
          }
          localObject1 = localObject2;
          if (localObject1 == null)
          {
            ((j)business(j.class)).Efw.add(paramh);
            localObject1 = this.TAG;
            paramh = new StringBuilder("safeAddAudienceMicUser: ").append(paramh).append(", size:").append(((j)business(j.class)).Efw.size()).append(' ');
            localObject2 = aw.Gjk;
            Log.i((String)localObject1, aw.fgr());
          }
          AppMethodBeat.o(357325);
          return;
        }
      }
      localObject1 = null;
    }
  }
  
  public final String info()
  {
    AppMethodBeat.i(357184);
    String str = "liveId:" + ((f)business(f.class)).liveInfo.liveId + ",objectId:" + ((f)business(f.class)).info() + ", " + com.tencent.mm.ae.d.hF(((f)business(f.class)).hKN) + ",uiState:" + this.EcS + ",liveState:" + this.EcT + ",bindShop:" + ((q)business(q.class)).info() + ",shoppingAvailable:" + ((q)business(q.class)).EhZ + ",qosReport:" + this.EdC + ",qosContrl:" + this.EdD + ",qosInterval:" + this.EdE + ",curRoleType:" + this.EdI.ZNI;
    AppMethodBeat.o(357184);
    return str;
  }
  
  public final boolean isLiveStarted()
  {
    return this.EcT == 2;
  }
  
  public final void l(FinderObject paramFinderObject)
  {
    int j = 0;
    Object localObject3 = null;
    AppMethodBeat.i(357020);
    this.Eco = paramFinderObject;
    Object localObject2 = this.TAG;
    Object localObject4 = new StringBuilder("#liveFinderObject set liveInfo.live_flag=");
    Object localObject1;
    label63:
    label89:
    int i;
    label141:
    label149:
    if (paramFinderObject == null)
    {
      localObject1 = null;
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(" liveInfo.biz_info.username=");
      if (paramFinderObject != null) {
        break label203;
      }
      localObject1 = null;
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(' ');
      localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      if (paramFinderObject != null) {
        break label248;
      }
      localObject1 = null;
      Log.i((String)localObject2, com.tencent.mm.plugin.finder.live.view.convert.a.a((blf)localObject1));
      if (paramFinderObject != null) {
        break label275;
      }
      i = 0;
      label113:
      if (com.tencent.mm.ae.d.ee(i, 64))
      {
        localObject4 = (b)business(b.class);
        if (paramFinderObject != null) {
          break label300;
        }
        localObject1 = null;
        if (paramFinderObject != null) {
          break label345;
        }
        localObject2 = localObject3;
        if (paramFinderObject != null) {
          break label386;
        }
        i = j;
      }
    }
    for (;;)
    {
      ((b)localObject4).b(true, (String)localObject1, (String)localObject2, i);
      AppMethodBeat.o(357020);
      return;
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Integer.valueOf(((bip)localObject1).live_flag);
      break;
      label203:
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label63;
      }
      localObject1 = ((bip)localObject1).ZSj;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label63;
      }
      localObject1 = ((aui)localObject1).ADE;
      break label63;
      label248:
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label89;
      }
      localObject1 = ((bip)localObject1).ZSc;
      break label89;
      label275:
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 == null)
      {
        i = 0;
        break label113;
      }
      i = ((bip)localObject1).live_flag;
      break label113;
      label300:
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label141;
      }
      localObject1 = ((bip)localObject1).ZSj;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label141;
      }
      localObject1 = ((aui)localObject1).ADE;
      break label141;
      label345:
      Object localObject5 = paramFinderObject.liveInfo;
      localObject2 = localObject3;
      if (localObject5 == null) {
        break label149;
      }
      localObject5 = ((bip)localObject5).ZSj;
      localObject2 = localObject3;
      if (localObject5 == null) {
        break label149;
      }
      localObject2 = ((aui)localObject5).YTl;
      break label149;
      label386:
      paramFinderObject = paramFinderObject.liveInfo;
      i = j;
      if (paramFinderObject != null)
      {
        paramFinderObject = paramFinderObject.ZSj;
        i = j;
        if (paramFinderObject != null) {
          i = paramFinderObject.ZEN;
        }
      }
    }
  }
  
  public final void oW(long paramLong)
  {
    AppMethodBeat.i(357090);
    Log.i(this.TAG, kotlin.g.b.s.X("join live time:", Long.valueOf(paramLong)));
    this.EcZ = paramLong;
    AppMethodBeat.o(357090);
  }
  
  public final void oX(long paramLong)
  {
    AppMethodBeat.i(357127);
    Log.i(this.TAG, kotlin.g.b.s.X("set curBalance:", Long.valueOf(paramLong)));
    this.Edy = paramLong;
    AppMethodBeat.o(357127);
  }
  
  public final void oY(long paramLong)
  {
    AppMethodBeat.i(357158);
    Log.i(this.TAG, kotlin.g.b.s.X("setAnchorPauseStartTime:", Long.valueOf(paramLong)));
    this.Een = paramLong;
    AppMethodBeat.o(357158);
  }
  
  public final void oZ(long paramLong)
  {
    AppMethodBeat.i(357215);
    Log.i(this.TAG, kotlin.g.b.s.X("updateFuncEnableAnchor switchFlag:", Long.valueOf(paramLong)));
    ((j)business(j.class)).EfD = com.tencent.mm.ae.d.ee((int)paramLong, 4);
    Object localObject = com.tencent.mm.plugin.finder.live.util.u.DJC;
    this.Edv = com.tencent.mm.plugin.finder.live.util.u.oE(paramLong);
    this.Eek = com.tencent.mm.ae.d.ee((int)paramLong, 8);
    ((j)business(j.class)).EfJ = com.tencent.mm.ae.d.ee((int)paramLong, 64);
    this.Ecw = com.tencent.mm.ae.d.ee((int)paramLong, 256);
    this.Ecu = com.tencent.mm.ae.d.ee((int)paramLong, 4096);
    if (com.tencent.mm.ae.d.ee((int)paramLong, 128))
    {
      localObject = com.tencent.mm.live.core.core.e.a.mRf;
      if (a.a.bek()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.EeH = bool;
      AppMethodBeat.o(357215);
      return;
    }
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(357201);
    super.onCleared();
    Log.i(this.TAG, "reset22");
    aD(null);
    this.Edr = true;
    this.Ecl.clear();
    this.Ecn = null;
    l(null);
    this.mIC = "";
    this.Ecp = 0;
    this.Ecq = 0L;
    this.Ecr = true;
    this.Ecs = true;
    this.Ect = true;
    this.Ecu = false;
    this.Ecv = false;
    this.Ecw = true;
    this.Ecx = true;
    this.Ecy = false;
    this.Ecz = null;
    sk(false);
    this.EcE = 0L;
    this.EcG = false;
    this.EcH = false;
    this.EcI = true;
    this.EcJ = false;
    this.EcK = -1;
    this.EcL = 0;
    this.friendFollowCount = 0;
    this.desc = null;
    this.EcN.clear();
    eyx();
    this.Eds = true;
    this.token = "";
    this.mIY = 0;
    this.EcC.clear();
    PY(-1);
    this.EcB.clear();
    this.EcS = 0;
    this.EcT = 0;
    this.EcU = 0;
    this.lastLiveState = 0;
    this.EcV = new com.tencent.mm.plugin.finder.live.viewmodel.data.c(null, null, null);
    this.sessionId = 0L;
    this.EcW = null;
    this.EcX = 0;
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.EcM = 0L;
    this.EcY = "";
    oW(0L);
    this.Eda = false;
    this.CFy = null;
    this.Edd = 0;
    this.Ede = "";
    this.Edf = false;
    b(null);
    this.Edh = false;
    this.Edj = null;
    this.Edk = null;
    this.Edl = 0L;
    this.Edm = 0L;
    this.Edt = null;
    this.Edn = "";
    this.Edo = "";
    this.Edp.clear();
    this.Edq = false;
    this.Edu = -1;
    Log.i(this.TAG, kotlin.g.b.s.X("set enableGift:", Boolean.FALSE));
    this.DRP = false;
    this.Edv = false;
    sl(false);
    this.Edx = true;
    oX(0L);
    this.EdB = null;
    this.EdC = false;
    this.EdD = false;
    this.EdE = 2;
    ayl("");
    this.EdF = true;
    this.EdG = true;
    this.CFd = null;
    this.CFe = null;
    this.EdI = new bcz();
    this.EdK.clear();
    this.EdJ = 4;
    this.EdL = -9223372036854775808L;
    this.EdN = false;
    this.EdO = false;
    this.EdM = null;
    this.EdP = new bjh();
    this.EdR.clear();
    this.EdS.clear();
    this.EdQ = new n();
    this.EdT.clear();
    this.CFg = 0;
    this.CFh = 0;
    this.EdH.clear();
    this.Edc.clear();
    this.location = null;
    this.EdW = 0;
    this.EdX = 0;
    this.EdY = false;
    this.EdZ.clear();
    this.Eea.clear();
    this.Eeb.clear();
    this.Eee = new com.tencent.mm.plugin.finder.live.model.c();
    this.Eef = 0;
    this.Eeg = false;
    this.Eeh = -1;
    this.Eei = new com.tencent.mm.plugin.finder.live.viewmodel.data.d((byte)0);
    this.DVR = null;
    this.Eej = null;
    this.Eek = false;
    this.yok.set(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    this.mIR = false;
    this.Eed = null;
    this.Eem = false;
    oY(0L);
    this.Eeo = 0;
    this.Eep = 0;
    this.Eeq = null;
    this.Eer = null;
    this.Ees = false;
    this.Eet = false;
    this.Eeu = null;
    this.Eev = 0;
    this.DXO = 0;
    this.Eew = "";
    this.Eex = "";
    this.Eez = false;
    this.Eey = false;
    this.EeA = false;
    this.EeB = new ConcurrentLinkedDeque();
    this.EeC = null;
    this.BvE = null;
    this.EeD.clear();
    this.EeE.clear();
    this.EeG.clear();
    this.EeF = null;
    this.Eel.clear();
    this.EeH = false;
    this.EeI = false;
    this.EeJ = null;
    this.EeK = false;
    this.EeL = 0L;
    e.a locala = this.EdA;
    locala.tXv = false;
    locala.EeP.clear();
    locala.EeQ = null;
    locala.lTH = 0;
    locala.EeR = 0;
    this.EeM = false;
    this.EeN = new r(Integer.valueOf(0), Integer.valueOf(0));
    this.mIX = 0;
    this.EeO = false;
    AppMethodBeat.o(357201);
  }
  
  public final void setAnchorUsername(String paramString)
  {
    AppMethodBeat.i(357031);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.mIC = paramString;
    AppMethodBeat.o(357031);
  }
  
  public final void sj(boolean paramBoolean)
  {
    AppMethodBeat.i(357039);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("haveJoinLive:").append(paramBoolean).append(",liveId:");
    Object localObject = ((f)business(f.class)).liveInfo;
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((bip)localObject).liveId))
    {
      Log.i(str, localObject);
      this.EcA = paramBoolean;
      AppMethodBeat.o(357039);
      return;
    }
  }
  
  public final void sk(boolean paramBoolean)
  {
    AppMethodBeat.i(357058);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("liveFinish:").append(this.EcD).append(",value:").append(paramBoolean).append(",liveId:");
    Object localObject = ((f)business(f.class)).liveInfo;
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((bip)localObject).liveId))
    {
      Log.i(str, localObject);
      this.EcD = paramBoolean;
      AppMethodBeat.o(357058);
      return;
    }
  }
  
  public final void sl(boolean paramBoolean)
  {
    AppMethodBeat.i(357121);
    Log.i(this.TAG, kotlin.g.b.s.X("set enableVisitorGiftSwitch:", Boolean.valueOf(paramBoolean)));
    this.Edw = paramBoolean;
    AppMethodBeat.o(357121);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(357355);
    String str = info();
    AppMethodBeat.o(357355);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    e(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.e
 * JD-Core Version:    0.7.0.1
 */