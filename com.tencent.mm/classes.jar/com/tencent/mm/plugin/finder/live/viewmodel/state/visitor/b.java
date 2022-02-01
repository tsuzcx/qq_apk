package com.tencent.mm.plugin.finder.live.viewmodel.state.visitor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.autogen.mmdata.rpt.ej;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.core.core.e.r;
import com.tencent.mm.live.core.core.f.a.a;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.live.model.cgi.g.a;
import com.tencent.mm.plugin.finder.live.model.frameset.c.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ab;
import com.tencent.mm.plugin.finder.live.plugin.ac;
import com.tencent.mm.plugin.finder.live.plugin.af;
import com.tencent.mm.plugin.finder.live.plugin.ai;
import com.tencent.mm.plugin.finder.live.plugin.ak;
import com.tencent.mm.plugin.finder.live.plugin.an;
import com.tencent.mm.plugin.finder.live.plugin.ao;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.au;
import com.tencent.mm.plugin.finder.live.plugin.au.b;
import com.tencent.mm.plugin.finder.live.plugin.ax;
import com.tencent.mm.plugin.finder.live.plugin.ay;
import com.tencent.mm.plugin.finder.live.plugin.az;
import com.tencent.mm.plugin.finder.live.plugin.ba;
import com.tencent.mm.plugin.finder.live.plugin.bc;
import com.tencent.mm.plugin.finder.live.plugin.be;
import com.tencent.mm.plugin.finder.live.plugin.bh;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.bl;
import com.tencent.mm.plugin.finder.live.plugin.bo;
import com.tencent.mm.plugin.finder.live.plugin.bq;
import com.tencent.mm.plugin.finder.live.plugin.br;
import com.tencent.mm.plugin.finder.live.plugin.bv;
import com.tencent.mm.plugin.finder.live.plugin.bx;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.plugin.ca;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.live.plugin.cd;
import com.tencent.mm.plugin.finder.live.plugin.cf;
import com.tencent.mm.plugin.finder.live.plugin.cg;
import com.tencent.mm.plugin.finder.live.plugin.ci;
import com.tencent.mm.plugin.finder.live.plugin.cj;
import com.tencent.mm.plugin.finder.live.plugin.ck;
import com.tencent.mm.plugin.finder.live.plugin.ck.a;
import com.tencent.mm.plugin.finder.live.plugin.cl;
import com.tencent.mm.plugin.finder.live.plugin.cm;
import com.tencent.mm.plugin.finder.live.plugin.cp;
import com.tencent.mm.plugin.finder.live.plugin.cr;
import com.tencent.mm.plugin.finder.live.plugin.cs;
import com.tencent.mm.plugin.finder.live.plugin.ct;
import com.tencent.mm.plugin.finder.live.plugin.ct.c;
import com.tencent.mm.plugin.finder.live.plugin.cv;
import com.tencent.mm.plugin.finder.live.plugin.cz;
import com.tencent.mm.plugin.finder.live.report.q.bw;
import com.tencent.mm.plugin.finder.live.report.q.ca;
import com.tencent.mm.plugin.finder.live.report.q.cc;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.report.q.u;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.live.report.q.z;
import com.tencent.mm.plugin.finder.live.view.FinderLiveCommentPostRealNamePanel;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGameInfoView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.view.a.b;
import com.tencent.mm.plugin.finder.live.widget.w;
import com.tencent.mm.plugin.finder.utils.bb.c;
import com.tencent.mm.plugin.findersdk.a.by;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.k.b;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.lang.ref.SoftReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.g.b.ah.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveVisitorStateComponent;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "Lcom/tencent/mm/plugin/finder/live/model/service/IFinderLiveCommonAdapter;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "LOOPTAG", "", "TAG", "allowanceGiftBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAllowanceGiftBubblePlugin;", "allowanceGiftCardPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAllowanceGiftCardPlugin;", "allowanceGiftPagPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAllowanceGiftPagPlugin;", "anchorDescEditPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorDescEditPlugin;", "anchorFastCommentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorFastCommentPlugin;", "audioModePreviewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAudioModePreviewPlugin;", "autoCloseLinkMicSelfCount", "", "battleInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBattleInfoPlugin;", "bottomGroupLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "bottomOptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin;", "getBottomOptionPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin;", "setBottomOptionPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin;)V", "bottomTipPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBottomTipPlugin;", "getBottomTipPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBottomTipPlugin;", "bottomTipPlugin$delegate", "Lkotlin/Lazy;", "boxPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxPlugin;", "bubbleContainer", "Landroid/widget/LinearLayout;", "castScreenPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCastScreenPlugin;", "closePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin;", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "commentRealNamePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentRealNamePlugin;", "commonInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "getCommonInfoPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "setCommonInfoPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;)V", "confettiPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "curBgmPlayingId", "curPlayStatus", "decorationPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveDecorationPlugin;", "exceptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExceptionPlugin;", "finderLiveLoadMoreTips", "Landroid/view/View;", "getFinderLiveLoadMoreTips", "()Landroid/view/View;", "finderLiveLoadMoreTips$delegate", "finderLiveRealHistoryTips", "getFinderLiveRealHistoryTips", "finderLiveRealHistoryTips$delegate", "firstFrameCallback", "com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$firstFrameCallback$2$1", "getFirstFrameCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$firstFrameCallback$2$1;", "firstFrameCallback$delegate", "followGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin;", "galaDanmakuPlugin", "Lcom/tencent/mm/plugin/finder/live/gala/plugin/FinderLiveDanmakuPlugin;", "galaGroupHintPlugin", "Lcom/tencent/mm/plugin/finder/live/gala/plugin/FinderLiveGalaGroupHintPlugin;", "gameDynamicOperateFrameSetPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameDynamicOperateFrameSetPlugin;", "gameDynamicPlayerFrameSetPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameDynamicPlayerFrameSetPlugin;", "gameInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameInfoPlugin;", "gameJoinBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameGuideBubblePlugin;", "gameWelfareTaskBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameWelfareTaskBubblePlugin;", "giftPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin;", "giftPlayPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "giftQueuePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "giftSendPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin;", "hasCheckGameRankGuide", "", "inputPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin;", "isBottomTipPluginInit", "isLinkLisencePluginInit", "isMusicEntrancePluginInit", "isUseByFluentDirector", "lastAudioMode", "lastScreenShareMode", "likePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin;", "getLikePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin;", "setLikePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin;)V", "linkLisencePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin;", "getLinkLisencePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin;", "linkLisencePlugin$delegate", "linkMicStatePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicStatePlugin;", "liveChargePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveChargePayPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "liveTXLivePlayerPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin;", "getLiveTXLivePlayerPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin;", "setLiveTXLivePlayerPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin;)V", "lotteryBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "lotteryCardPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "luckyMoneyPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin;", "memberListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin;", "micAudioPreviewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicAudioPreviewPlugin;", "micDecoratePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin;", "miniWindowPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMiniWindowPlugin;", "moreActionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;", "moreLiveEntrancePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin;", "getMoreLiveEntrancePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin;", "setMoreLiveEntrancePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin;)V", "musicEntrancePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMusicPlugin;", "getMusicEntrancePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMusicPlugin;", "musicEntrancePlugin$delegate", "musicPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin;", "olympicBulletClickPlugin", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsBulletClickPlugin;", "olympicCertificatePlugin", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicCertificatePlugin;", "olympicReserveGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicReserveGuidePlugin;", "olympicRoomBgPlugin", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsRoomBgPlugin;", "olympicRunPlugin", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsActivitisPlugin;", "olympicTorchPlugin", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsTorchPlugin;", "olympicsCertBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsCertBubblePlugin;", "olympicsPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicsPlugin;", "originCommentBottomMargin", "originCommentViewPagerBottomMargin", "postPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin;", "previewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin;", "profilePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewMemberProfilePlugin;", "promoteBannerPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBannerPlugin;", "promottingBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBubblePlugin;", "screenClearPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin;", "shadowPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShadowPlugin;", "shoppingListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "subtitlePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveSubtitlePlugin;", "timerCallback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/VisitorTimerCallbackImpl;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "titleInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "getTitleInfoPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "setTitleInfoPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;)V", "topCommentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;", "videoOrientationPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin;", "viewPagerCommentPlugin", "Lcom/tencent/mm/plugin/finder/live/gala/plugin/FinderLiveViewPagerCommentPlugin;", "visitorFansClubPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorFansClubPanelPlugin;", "visitorFansClubPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorFansClubPlugin;", "visitorGameRankGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorGameRankSwitchGuidePlugin;", "visitorVRBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorVRBubblePlugin;", "adjustCommentPluginBottom", "", "param", "Landroid/os/Bundle;", "adjustLayout", "screenSize", "Lkotlin/Pair;", "adjustLayoutCDN", "adjustLayoutTRTC", "buildPreloadLiveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveId", "", "streamUrl", "audienceMode", "callback", "errorCode", "canPreloadLive", "canShowMiniWindow", "checkAnchorAudioModeBySei", "userStatus", "checkAnchorAudioModeBySvr", "checkAnchorContactInfo", "checkChargeLiveInvalid", "checkDecorationInfo", "checkEnablePreloadLive", "audienMode", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "checkFinderObject", "checkLinkMicStateWhenJoin", "micInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMicInfo;", "checkLiveCharge", "checkLocalLiveSceneAfterClose", "checkMiniWindow", "checkPlayerState", "checkSeiServerTime", "anchorServerTime", "anchorIdBySei", "checkShowGameRankGuide", "checkVisitorRoleWhenDirectStart", "chooseAudienModeAfterJoinLive", "chooseAudienceMode", "fromMiniWin", "mute", "enterLiveAnim", "exitLive", "getIFinderLiveCommonAdapter", "getLiveMiniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getLiveRoomPlayListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "getLiveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "getScreenSize", "getWindowSize", "Landroid/graphics/Point;", "handleCheerIconsInfo", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "handleJoinErr", "errCode", "errMsg", "handleLinkMicRequest", "micType", "errType", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyMicWithAudienceResponse;", "hideBottomAraePlugin", "hideFinderNewGuide", "hidePlugins", "initBoxPlugin", "initGiftEffectEnable", "initMemberListPlugin", "initOlympicPlugin", "initShoppingPlugin", "initStaticPlugins", "isCdnMode", "isFloatMode", "isNormalMode", "joinLive", "joinLiveByMiniWin", "lazyInitPlugins", "markIsUserByDirector", "isUse", "miniWindow", "notifyMicUserVolume", "notifyMiniWindowShow", "isFluentExit", "notityAnchorInfoBySei", "anchorUserId", "songId", "playStatus", "onAcceptLinkMicOthers", "(Ljava/lang/Integer;)V", "onAcceptLinkMicSelf", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAcceptLiveMic", "onApplyMicTimeout", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onCloseLinkMicOthers", "onCloseLinkMicSelf", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onLiveEnd", "extraMsg", "onLiveEventCallback", "onLiveIdle", "onLiveStart", "onMessageCallback", "onMount", "onRelease", "onResume", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSlowMessageCallback", "onStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "onStop", "parseInjectEvent", "postCloseLinkMsg", "preloadJoinTips", "preloadLive", "(JLjava/lang/String;Ljava/lang/Integer;Z)V", "preloadNextLive", "(JLjava/lang/String;Ljava/lang/Integer;)Z", "prepareShopping", "resInvalid", "respAnchorUserId", "restartCDNPlayer", "restoreLinkMicUI", "setLiveRoomInfoFromLiveSdkInfo", "liveRoomInfo", "setupReportParams", "showFinderNewGuide", "isHistoryGuide", "showLivePauseTip", "showRealNameBottomSheet", "realNameUrl", "showUnknowJoinErrDialog", "startLive", "byMiniWin", "startLiveVideo", "startTimer", "stopLiveVideo", "stopTimer", "trySwitchCdnStream", "Companion", "JoinLiveCallback", "JoinLiveCallback2", "PrepareShoppingCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.d
  implements com.tencent.mm.live.core.core.c, com.tencent.mm.plugin.finder.live.model.service.a
{
  public static final a Ekd;
  public boolean CuM;
  public boolean CuN;
  public com.tencent.mm.plugin.finder.live.plugin.ah DcS;
  private int DmD;
  private int DmE;
  cd EiQ;
  com.tencent.mm.plugin.finder.live.plugin.aj EiR;
  private com.tencent.mm.plugin.finder.live.plugin.bd EiU;
  private bk EiV;
  private az EiW;
  private com.tencent.mm.plugin.finder.live.plugin.bg EiX;
  private bq EiY;
  private br EiZ;
  public ac EjA;
  private com.tencent.mm.plugin.finder.live.plugin.k EjC;
  private com.tencent.mm.plugin.finder.live.plugin.n EjD;
  private ak EjG;
  private int EjH;
  private LinearLayout EjI;
  public cc EjV;
  private ca EjW;
  private bl EjX;
  public at EjY;
  private bz Eja;
  private cf Ejb;
  com.tencent.mm.plugin.finder.live.plugin.o Ejc;
  private ay Eje;
  public ba Ejf;
  private com.tencent.mm.plugin.finder.live.plugin.d Ejh;
  private com.tencent.mm.plugin.finder.live.plugin.e Eji;
  private com.tencent.mm.plugin.finder.live.plugin.av Ejj;
  private com.tencent.mm.plugin.finder.live.plugin.aw Ejk;
  private com.tencent.mm.plugin.finder.live.plugin.bf Ejo;
  private bc Ejq;
  private be Ejr;
  private ab Ejt;
  bh EkA;
  private boolean EkB;
  private final kotlin.j EkC;
  public af EkD;
  private boolean EkE;
  private final kotlin.j EkF;
  private com.tencent.mm.plugin.finder.live.plugin.bj EkG;
  private com.tencent.mm.plugin.finder.live.plugin.al EkH;
  private com.tencent.mm.plugin.finder.live.plugin.bn EkI;
  private cm EkJ;
  private cl EkK;
  private cv EkL;
  private com.tencent.mm.plugin.finder.live.plugin.cn EkM;
  private com.tencent.mm.plugin.finder.live.plugin.ag EkN;
  private boolean EkO;
  private e EkP;
  private boolean EkQ;
  public int EkR;
  private com.tencent.mm.plugin.finder.live.olympic.c EkS;
  private com.tencent.mm.plugin.finder.live.olympic.k EkT;
  private com.tencent.mm.plugin.finder.live.olympic.l EkU;
  private com.tencent.mm.plugin.finder.live.olympic.j EkV;
  private com.tencent.mm.plugin.finder.live.olympic.i EkW;
  private com.tencent.mm.plugin.finder.live.olympic.m EkX;
  private final kotlin.j EkY;
  private final kotlin.j EkZ;
  private final String Eke;
  public ct Ekf;
  private bo Ekg;
  private bx Ekh;
  private cj Eki;
  private cr Ekj;
  private ai Ekk;
  private bv Ekl;
  private com.tencent.mm.plugin.finder.live.plugin.ar Ekm;
  private com.tencent.mm.plugin.finder.live.plugin.ap Ekn;
  private ao Eko;
  private ck Ekp;
  private au Ekq;
  private ax Ekr;
  private cg Eks;
  private com.tencent.mm.plugin.finder.live.plugin.bb Ekt;
  private com.tencent.mm.plugin.finder.live.plugin.f Eku;
  public cp Ekv;
  private boolean Ekw;
  private final kotlin.j Ekx;
  public ci Eky;
  private com.tencent.mm.plugin.finder.live.plugin.aq Ekz;
  private final kotlin.j Ela;
  public final String TAG;
  private cz akhg;
  private ConstraintLayout akhh;
  private int akhi;
  private com.tencent.mm.plugin.finder.live.gala.b.b akhj;
  private com.tencent.mm.plugin.finder.live.gala.b.a akhk;
  public kotlinx.coroutines.aq coroutineScope;
  public MTimerHandler nmZ;
  
  static
  {
    AppMethodBeat.i(358325);
    Ekd = new a((byte)0);
    AppMethodBeat.o(358325);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(357551);
    this.TAG = kotlin.g.b.s.X("FinderLiveVisitorStartUIC@", Integer.valueOf(hashCode()));
    this.Eke = kotlin.g.b.s.X("Finder.LOOP_LiveVisitorPluginLayout@", Integer.valueOf(hashCode()));
    this.Ekx = kotlin.k.cm((kotlin.g.a.a)new r(this));
    this.EkC = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.EkF = kotlin.k.cm((kotlin.g.a.a)new t(this));
    this.EkP = new e(this, this.Eke, this.buContext);
    this.nmZ = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack)this.EkP, true);
    this.coroutineScope = kotlinx.coroutines.ar.kBZ();
    this.EkY = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.EkZ = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.Ela = kotlin.k.cm((kotlin.g.a.a)new m(this));
    AppMethodBeat.o(357551);
  }
  
  private final void H(long paramLong, String paramString)
  {
    AppMethodBeat.i(357742);
    if (Util.isEqual(paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw))
    {
      long l = com.tencent.mm.model.cn.bDv();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfI = kotlin.k.k.bR(l - paramLong, 0L);
      Log.d(this.TAG, "anchorServerTime:" + paramLong + " myServerTime:" + l);
      AppMethodBeat.o(357742);
      return;
    }
    Log.d(this.TAG, kotlin.g.b.s.X("anchorId is invalid, maybe is in pk link mic. ", paramString));
    AppMethodBeat.o(357742);
  }
  
  private static final void a(Bundle paramBundle, b paramb, com.tencent.mm.plugin.finder.live.gala.b.b paramb1)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(371879);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramb1, "$it");
    if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true)) {}
    while (i != 0) {
      if (paramb.akhi == 0)
      {
        paramBundle = paramb1.mJe.getLayoutParams();
        if (paramBundle == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(371879);
          throw paramBundle;
          i = 0;
        }
        else
        {
          paramb.akhi = ((ViewGroup.MarginLayoutParams)paramBundle).bottomMargin;
        }
      }
      else
      {
        paramBundle = paramb1.mJe.getLayoutParams();
        if (paramBundle == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(371879);
          throw paramBundle;
        }
        paramBundle = (RelativeLayout.LayoutParams)paramBundle;
        paramBundle.addRule(12);
        paramBundle.removeRule(2);
        AppMethodBeat.o(371879);
        return;
      }
    }
    paramBundle = paramb1.mJe.getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(371879);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    paramBundle.removeRule(12);
    ConstraintLayout localConstraintLayout = paramb.akhh;
    if (localConstraintLayout == null) {}
    for (i = j;; i = localConstraintLayout.getId())
    {
      paramBundle.addRule(2, i);
      paramBundle.bottomMargin = paramb.akhi;
      paramb1.mJe.requestLayout();
      AppMethodBeat.o(371879);
      return;
    }
  }
  
  private static final void a(Bundle paramBundle, b paramb, com.tencent.mm.plugin.finder.live.plugin.ah paramah)
  {
    Object localObject = null;
    int k = 0;
    int j = 0;
    int n = 1;
    int m = 1;
    AppMethodBeat.i(371871);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramah, "$it");
    if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
    {
      i = 1;
      if (i == 0) {
        break label198;
      }
      paramBundle = paramb.Eje;
      if (paramBundle != null) {
        break label108;
      }
      paramBundle = (Bundle)localObject;
    }
    for (;;)
    {
      if (paramBundle == null)
      {
        paramBundle = paramah.mJe.getLayoutParams();
        if (paramBundle == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(371871);
          throw paramBundle;
          i = 0;
          break;
          label108:
          paramBundle = paramBundle.DcS;
          continue;
        }
        paramb.EjH = ((ViewGroup.MarginLayoutParams)paramBundle).bottomMargin;
      }
    }
    paramBundle = paramb.Eje;
    if (paramBundle != null) {
      paramBundle.DcS = paramb.DcS;
    }
    paramBundle = paramah.mJe.getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(371871);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    paramBundle.addRule(12);
    paramBundle.removeRule(2);
    AppMethodBeat.o(371871);
    return;
    label198:
    if (paramb.Ekz != null)
    {
      paramBundle = paramb.Ekz;
      if (paramBundle == null) {
        paramBundle = null;
      }
      while (paramBundle == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(371871);
        throw paramBundle;
        paramBundle = paramBundle.CZo;
        if (paramBundle == null) {
          paramBundle = null;
        } else {
          paramBundle = Boolean.valueOf(paramBundle.cvt());
        }
      }
      if (paramBundle.booleanValue())
      {
        paramBundle = paramb.Eje;
        if (paramBundle != null) {
          paramBundle.DcS = null;
        }
        paramBundle = paramah.mJe.getLayoutParams();
        if (paramBundle == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(371871);
          throw paramBundle;
        }
        paramBundle = (RelativeLayout.LayoutParams)paramBundle;
        localObject = paramb.CCg;
        if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isLandscape() == true)) {}
        for (i = m; i != 0; i = 0)
        {
          paramBundle.addRule(12);
          paramBundle = paramah.mJe.getLayoutParams();
          if (paramBundle != null) {
            break label428;
          }
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(371871);
          throw paramBundle;
        }
        paramBundle.removeRule(12);
        localObject = paramb.EjI;
        if (localObject == null) {}
        for (i = j;; i = ((LinearLayout)localObject).getId())
        {
          paramBundle.addRule(2, i);
          break;
        }
        ((ViewGroup.MarginLayoutParams)paramBundle).bottomMargin = paramb.EjH;
        AppMethodBeat.o(371871);
        return;
      }
    }
    label428:
    paramBundle = paramb.Eje;
    if (paramBundle != null) {
      paramBundle.DcS = null;
    }
    paramBundle = paramah.mJe.getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(371871);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    localObject = paramb.CCg;
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isLandscape() == true)) {}
    for (int i = n; i != 0; i = 0)
    {
      paramBundle.addRule(12);
      paramBundle = paramah.mJe.getLayoutParams();
      if (paramBundle != null) {
        break label603;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(371871);
      throw paramBundle;
    }
    paramBundle.removeRule(12);
    localObject = paramb.EjI;
    if (localObject == null) {}
    for (i = k;; i = ((LinearLayout)localObject).getId())
    {
      paramBundle.addRule(2, i);
      break;
    }
    label603:
    ((ViewGroup.MarginLayoutParams)paramBundle).bottomMargin = paramb.EjH;
    paramah.mJe.requestLayout();
    AppMethodBeat.o(371871);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(371858);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    paramView = com.tencent.mm.ui.component.k.aeZF;
    if (((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.d(paramb.CCa).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD)
    {
      paramView = com.tencent.mm.ui.component.k.aeZF;
      paramView = ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.d(paramb.CCa).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE;
      if (paramView != null) {
        paramView.hide();
      }
      paramView = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.d(paramb.CCa).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGH.DGN = 3;
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(371858);
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.finder.live.plugin.ah paramah)
  {
    AppMethodBeat.i(371878);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramah, "$it");
    Object localObject1 = paramb.Eje;
    if (localObject1 != null) {
      ((ay)localObject1).DcS = null;
    }
    localObject1 = paramah.mJe.getLayoutParams();
    Object localObject2;
    int i;
    if ((localObject1 instanceof RelativeLayout.LayoutParams))
    {
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      if (localObject1 != null)
      {
        localObject2 = paramb.CCg;
        if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.live.view.router.c)localObject2).isLandscape() != true)) {
          break label150;
        }
        i = 1;
        label80:
        if (i == 0) {
          break label155;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      }
      if (paramb.EjH != 0) {
        break label197;
      }
      paramah = paramah.mJe.getLayoutParams();
      if (!(paramah instanceof ViewGroup.MarginLayoutParams)) {
        break label192;
      }
    }
    label150:
    label155:
    label192:
    for (paramah = (ViewGroup.MarginLayoutParams)paramah;; paramah = null)
    {
      if (paramah == null) {
        break label229;
      }
      paramah.bottomMargin = paramb.CCa.getResources().getDimensionPixelOffset(p.c.Edge_2A);
      AppMethodBeat.o(371878);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label80;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
      localObject2 = paramb.EjI;
      if (localObject2 == null) {}
      for (i = 0;; i = ((LinearLayout)localObject2).getId())
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, i);
        break;
      }
    }
    label197:
    paramah = paramah.mJe.getLayoutParams();
    if ((paramah instanceof ViewGroup.MarginLayoutParams)) {}
    for (paramah = (ViewGroup.MarginLayoutParams)paramah;; paramah = null)
    {
      if (paramah != null) {
        paramah.bottomMargin = paramb.EjH;
      }
      label229:
      AppMethodBeat.o(371878);
      return;
    }
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    AppMethodBeat.i(371883);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject = paramb.CCg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).getLastMicUserList();
      if (localObject != null) {
        ((ArrayList)localObject).clear();
      }
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).h(paramh);
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
    {
      paramh = paramb.CCg;
      if (paramh != null) {
        com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramh, false, 1, null);
      }
      paramh = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      com.tencent.mm.plugin.finder.live.model.aj.a(2, null, false, 6);
    }
    paramh = paramb.Ekf;
    if (paramh != null) {
      paramh.aPz();
    }
    paramb = paramb.Ekf;
    if (paramb != null) {
      paramb.mRt.bha();
    }
    AppMethodBeat.o(371883);
  }
  
  private static final void a(b paramb, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(371866);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject = paramb.Eks;
    if (localObject != null) {
      ((cg)localObject).fY((View)paramTXCloudVideoView);
    }
    localObject = paramb.Ekm;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.ar)localObject).fY((View)paramTXCloudVideoView);
    }
    paramb = paramb.Ekn;
    if (paramb != null) {
      paramb.fY((View)paramTXCloudVideoView);
    }
    AppMethodBeat.o(371866);
  }
  
  private static final void a(b paramb, Integer paramInteger, View paramView)
  {
    AppMethodBeat.i(371877);
    ??? = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramInteger);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", ???, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
    kotlin.g.b.s.s(paramView, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    for (;;)
    {
      synchronized ((Iterable)paramView)
      {
        localObject2 = ((Iterable)???).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          paramView = ((Iterator)localObject2).next();
          bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramView).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF());
          if (!bool) {
            continue;
          }
          if (paramView != null)
          {
            bool = true;
            if (!bool) {
              break label311;
            }
            if ((paramb.CCa instanceof Activity))
            {
              paramView = paramb.CCg;
              if (paramView != null) {
                com.tencent.mm.plugin.finder.live.view.a.showAlertDialog$default((com.tencent.mm.plugin.finder.live.view.a)paramView, (Activity)paramb.CCa, "", paramb.CCa.getResources().getString(p.h.CtM), "", false, 16, null);
              }
            }
            Log.i(paramb.TAG, "scene:" + paramInteger + ", click ok linking:" + bool);
            com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(371877);
          }
        }
        else
        {
          paramView = null;
        }
      }
      boolean bool = false;
      continue;
      label311:
      paramView = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      paramView = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (paramView != null) {
        paramView.c((Activity)paramb.CCa, false);
      }
    }
  }
  
  private static final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(371882);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramString, "$realNameUrl");
    paramb.ayy(paramString);
    AppMethodBeat.o(371882);
  }
  
  private static final void a(b paramb, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(371864);
    kotlin.g.b.s.u(paramb, "this$0");
    paramString = paramb.CCg;
    if (paramString != null) {
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramString, com.tencent.mm.live.b.b.c.ncl);
    }
    Log.i(paramb.TAG, kotlin.g.b.s.X("showAlertDialog click bOk:", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(371864);
  }
  
  private final void af(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(357712);
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
    Object localObject1 = e.b.mKf;
    Object localObject3;
    label446:
    label458:
    Object localObject4;
    if (i == e.b.bct())
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.bd.Gli;
      localObject2 = kotlin.g.b.s.X(com.tencent.mm.plugin.finder.utils.bd.fhS(), Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
      localObject3 = com.tencent.mm.plugin.finder.utils.bb.GjM;
      com.tencent.mm.plugin.finder.utils.bd.a((com.tencent.mm.plugin.finder.utils.bd)localObject1, (String)localObject2, com.tencent.mm.plugin.finder.utils.bb.fhj().name, null, false, false, false, 60);
      Log.i(this.TAG, "chooseAudienceMode TRTC fromMiniWin:" + paramBoolean1 + ", mute:" + paramBoolean2 + ", liveRoomModel:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZu + ", liveExtFlag:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcK + ", lastScreenShareMode:" + this.CuN);
      localObject1 = getLiveCore();
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject2 = this.buContext;
        localObject3 = this.CCg;
        if (localObject3 == null)
        {
          paramBoolean2 = false;
          ((com.tencent.mm.live.core.core.f.d)localObject1).tb(com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject2, paramBoolean2, this.CuN));
        }
      }
      else
      {
        if (!paramBoolean1) {
          break label458;
        }
        localObject1 = this.Ekf;
        if (localObject1 != null) {
          ((ct)localObject1).esR();
        }
        localObject1 = getLiveCore();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.f.d)localObject1).bfI();
        }
        localObject1 = getLiveCore();
        if (localObject1 != null)
        {
          Log.i("MicroMsg.LiveCoreVisitor", "[makeRemotePreviewFullScreen] anchorID:" + ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB.mNM + " preview:" + ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRt);
          if (((com.tencent.mm.live.core.core.trtc.a)localObject1).mRt == null) {
            break label446;
          }
          if (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB.mNM))
          {
            localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRt;
            if (localObject2 != null) {
              ((LivePreviewView)localObject2).Gf(((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB.mNM);
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = this.Ekf;
        if (localObject1 != null) {
          ((ct)localObject1).tO(0);
        }
        localObject1 = getLiveCore();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRy = ((com.tencent.mm.live.core.core.c)this);
        }
        localObject1 = getLiveCore();
        if (localObject1 == null) {
          break label1352;
        }
        ((com.tencent.mm.live.core.core.f.d)localObject1).d((com.tencent.mm.live.core.core.c)ezJ());
        AppMethodBeat.o(357712);
        return;
        paramBoolean2 = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject3).isLandscape();
        break;
        Log.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
        continue;
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZu;
        if (localObject3 != null)
        {
          localObject1 = this.Ekf;
          if (localObject1 != null)
          {
            localObject2 = (kotlin.g.a.b)i.Ele;
            kotlin.g.b.s.u(localObject3, "liveRoomModel");
            kotlin.g.b.s.u(localObject2, "action");
            localObject4 = ((ct)localObject1).getLiveCore();
            if (localObject4 != null) {
              ((com.tencent.mm.live.core.core.f.d)localObject4).a((com.tencent.mm.live.core.core.model.h)localObject3);
            }
            localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.live.core.core.b)((ct)localObject1).getLiveCore());
            localObject3 = ((ct)localObject1).getLiveCore();
            if (localObject3 != null) {
              ((com.tencent.mm.live.core.core.f.d)localObject3).a(((ct)localObject1).mRt, (com.tencent.mm.live.core.core.c)new ct.c((ct)localObject1, (kotlin.g.a.b)localObject2));
            }
          }
        }
      }
    }
    localObject1 = e.b.mKf;
    com.tencent.mm.plugin.finder.live.view.router.c localc;
    boolean bool;
    label1054:
    label1083:
    long l;
    if (i == e.b.bcu())
    {
      Log.i(this.TAG, "chooseAudienceMode CDN fromMiniWin:" + paramBoolean1 + ", mute:" + paramBoolean2 + ", liveRoomModel:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZu + ", liveExtFlag:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcK);
      localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZu;
      localc = this.CCg;
      localObject3 = getLiveCore();
      if ((localObject4 != null) && (localc != null) && (localObject3 != null))
      {
        localObject2 = this.EjV;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localc.findViewById(p.e.live_tx_live_player_ui_root);
          kotlin.g.b.s.s(localObject1, "_router.findViewById(R.i…e_tx_live_player_ui_root)");
          localObject1 = new cc((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localc);
        }
        this.EjV = ((cc)localObject1);
        localObject1 = e.h.mKY;
        ((com.tencent.mm.live.core.core.f.d)localObject3).setScene(e.h.bdj());
        localObject1 = this.Ekf;
        if (localObject1 != null) {
          ((ct)localObject1).esR();
        }
        ((com.tencent.mm.live.core.core.f.d)localObject3).b(((com.tencent.mm.live.core.core.model.h)localObject4).mJH);
        localObject1 = com.tencent.mm.plugin.finder.report.av.Fui;
        com.tencent.mm.plugin.finder.report.av.eNT();
        localObject1 = com.tencent.mm.plugin.finder.report.r.Fqi;
        com.tencent.mm.plugin.finder.report.r.eMF();
        localObject1 = this.EjV;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.euG();
          localObject4 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          localObject4 = this.buContext;
          localc = this.CCg;
          if (localc != null) {
            break label1359;
          }
          bool = false;
          cc.a((cc)localObject1, 0, (TXLivePlayConfig)localObject2, com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject4, bool, this.CuN), paramBoolean2, false, (kotlin.g.a.b)j.Elf, 17);
        }
        localObject1 = getLiveCore();
        if (localObject1 != null)
        {
          localObject2 = e.b.mKf;
          ((com.tencent.mm.live.core.core.trtc.a)localObject1).mSe = Integer.valueOf(e.b.bcu());
        }
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("chooseAudienceMode isOlympicsLive ");
        localObject4 = com.tencent.mm.plugin.finder.utils.bj.GlQ;
        localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.utils.bj.y(this.buContext)).append(", ");
        localObject4 = com.tencent.mm.plugin.finder.utils.bj.GlQ;
        Log.i((String)localObject1, com.tencent.mm.plugin.finder.utils.bj.z(this.buContext));
        localObject1 = com.tencent.mm.plugin.finder.utils.bj.GlQ;
        if (!com.tencent.mm.plugin.finder.utils.bj.y(this.buContext)) {
          break label1375;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.bj.GlQ;
        if (com.tencent.mm.plugin.finder.utils.bj.z(this.buContext)) {
          break label1375;
        }
        localObject1 = getLiveCore();
        if (!(localObject1 instanceof com.tencent.mm.live.core.core.f.a)) {
          break label1369;
        }
        localObject1 = (com.tencent.mm.live.core.core.f.a)localObject1;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.f.a)localObject1).bC((List)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.n)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.class)).Ehj);
        }
        if (!paramBoolean1)
        {
          localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
          l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
          Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", kotlin.g.b.s.X("#markStartCdnPlay ", Long.valueOf(l)));
          localObject1 = com.tencent.mm.plugin.finder.live.report.k.or(l);
          ((ej)localObject1).iDB = l;
          ((ej)localObject1).iDD = com.tencent.mm.model.cn.bDv();
          localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
          l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
          Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", kotlin.g.b.s.X("#markShowCdnPlayerView ", Long.valueOf(l)));
          localObject1 = com.tencent.mm.plugin.finder.live.report.k.or(l);
          ((ej)localObject1).iDB = l;
          ((ej)localObject1).iDN = com.tencent.mm.model.cn.bDv();
        }
        localObject1 = this.data;
        if (localObject1 != null) {
          break label1395;
        }
        l = 0L;
        label1225:
        localObject1 = this.EjV;
        if (localObject1 != null) {
          break label1423;
        }
        localObject1 = null;
        label1239:
        localObject2 = this.EjV;
        if (localObject2 != null) {
          break label1433;
        }
      }
    }
    label1423:
    label1433:
    for (Object localObject2 = null;; localObject2 = ((cc)localObject2).bjv())
    {
      ((com.tencent.mm.live.core.core.f.d)localObject3).a(l, (com.tencent.mm.live.core.core.c.b)localObject1, (TXCloudVideoView)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.utils.bd.Gli;
      localObject2 = kotlin.g.b.s.X(com.tencent.mm.plugin.finder.utils.bd.fhS(), Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
      localObject4 = com.tencent.mm.plugin.finder.utils.bb.GjM;
      com.tencent.mm.plugin.finder.utils.bd.a((com.tencent.mm.plugin.finder.utils.bd)localObject1, (String)localObject2, com.tencent.mm.plugin.finder.utils.bb.fhj().name, null, false, false, false, 60);
      ((com.tencent.mm.live.core.core.trtc.a)localObject3).mRy = ((com.tencent.mm.live.core.core.c)this);
      localObject1 = getLiveCore();
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.f.d)localObject1).d((com.tencent.mm.live.core.core.c)ezJ());
      }
      label1352:
      AppMethodBeat.o(357712);
      return;
      label1359:
      bool = localc.isLandscape();
      break;
      label1369:
      localObject1 = null;
      break label1054;
      label1375:
      localObject1 = this.EjV;
      if (localObject1 == null) {
        break label1083;
      }
      ((cc)localObject1).tO(0);
      break label1083;
      label1395:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject1).Ebr;
      if (localObject1 == null)
      {
        l = 0L;
        break label1225;
      }
      l = ((LiveConfig)localObject1).liveId;
      break label1225;
      localObject1 = ((cc)localObject1).mJG;
      break label1239;
    }
  }
  
  private final void ayy(String paramString)
  {
    AppMethodBeat.i(357728);
    Object localObject = this.CCg;
    if (localObject != null)
    {
      this.Ekk = new ai(new FinderLiveCommentPostRealNamePanel((Context)this.CCa), (com.tencent.mm.live.b.b)localObject);
      localObject = this.Ekk;
      if (localObject != null) {
        ((ai)localObject).q(paramString, (kotlin.g.a.b)new ak(this));
      }
    }
    AppMethodBeat.o(357728);
  }
  
  private static final void b(b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(371857);
    kotlin.g.b.s.u(paramb, "this$0");
    Log.i(paramb.TAG, "restoreLinkMicUI: curLinkMicUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + ", audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw + ", audienceMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu() + ", isRoomPk:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM);
    Object localObject1;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eza())
    {
      localObject1 = paramb.Ekv;
      if (localObject1 != null) {
        ((cp)localObject1).epo();
      }
    }
    for (;;)
    {
      localObject1 = paramb.Ejo;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.bf)localObject1).erc();
      }
      paramb = paramb.Eky;
      if (paramb != null) {
        paramb.eoT();
      }
      AppMethodBeat.o(371857);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
      kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      Object localObject5;
      com.tencent.mm.plugin.finder.live.viewmodel.data.h localh;
      label497:
      int i;
      do
      {
        for (;;)
        {
          synchronized ((Iterable)localObject1)
          {
            ??? = ((Iterable)???).iterator();
            if (((Iterator)???).hasNext())
            {
              localObject1 = ((Iterator)???).next();
              boolean bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF());
              if (!bool) {
                continue;
              }
              ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1;
              localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
              kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
              synchronized ((Iterable)localObject1)
              {
                localObject5 = ((Iterable)???).iterator();
                if (!((Iterator)localObject5).hasNext()) {
                  break label676;
                }
                localh = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)localObject5).next();
                if (!Util.isEqual(localh.mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF())) {
                  break;
                }
                localObject1 = paramb.EjV;
                if (localObject1 != null) {
                  ((cc)localObject1).fD(true);
                }
                localObject1 = paramb.EjV;
                if (localObject1 != null) {
                  ((cc)localObject1).tO(8);
                }
                localObject1 = paramb.Ekf;
                if (localObject1 != null) {
                  ((ct)localObject1).tO(0);
                }
                localObject1 = paramb.Ekf;
                if (localObject1 != null) {
                  ((ct)localObject1).esS();
                }
                locald = paramb.getLiveCore();
                if (locald != null)
                {
                  localObject1 = paramb.getLiveCore();
                  if (localObject1 != null) {
                    break label497;
                  }
                  localObject1 = null;
                  locald.FQ((String)localObject1);
                }
                if (localh.mXM != 2) {
                  continue;
                }
                localObject1 = paramb.Ekf;
                if (localObject1 == null) {
                  continue;
                }
                ((ct)localObject1).aPz();
              }
            }
            localObject1 = null;
          }
          localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((com.tencent.mm.live.core.core.model.i)localObject1).mNM;
          }
        }
        i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
        localObject1 = e.b.mKf;
        if (i == e.b.bct()) {
          break;
        }
        i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
        localObject1 = e.b.mKf;
      } while ((i != e.b.bcu()) || (??? == null));
      localObject1 = paramb.Ekf;
      if (localObject1 != null) {
        ((ct)localObject1).awR(localh.mXL);
      }
      localObject1 = paramb.Ekf;
      if (localObject1 != null) {
        ((ct)localObject1).esS();
      }
      com.tencent.mm.live.core.core.f.d locald = paramb.getLiveCore();
      if (locald != null)
      {
        localObject1 = paramb.getLiveCore();
        if (localObject1 != null) {
          break label654;
        }
        localObject1 = null;
      }
      for (;;)
      {
        locald.FQ((String)localObject1);
        localObject1 = paramb.getLiveCore();
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.live.core.core.f.d)localObject1).FQ(localh.mXL);
        break;
        label654:
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((com.tencent.mm.live.core.core.model.i)localObject1).mNM;
        }
      }
      label676:
      localObject1 = kotlin.ah.aiuX;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).EbD == true))
        {
          i = 1;
          label727:
          if (i == 0) {
            break label915;
          }
          i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
          localObject1 = e.b.mKf;
          if (i != e.b.bct())
          {
            i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
            localObject1 = e.b.mKf;
            if ((i != e.b.bcu()) || (??? == null)) {
              continue;
            }
          }
          ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
          if (??? == null) {
            continue;
          }
          localObject1 = paramb.Ekf;
          if (localObject1 != null) {
            ((ct)localObject1).awR(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL);
          }
          localObject1 = paramb.Ekf;
          if (localObject1 != null) {
            ((ct)localObject1).esS();
          }
          ??? = paramb.getLiveCore();
          if (??? != null)
          {
            localObject1 = paramb.getLiveCore();
            if (localObject1 != null) {
              break label892;
            }
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          ((com.tencent.mm.live.core.core.f.d)???).FQ((String)localObject1);
          localObject1 = paramb.getLiveCore();
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.live.core.core.f.d)localObject1).FQ(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL);
          break;
          i = 0;
          break label727;
          label892:
          localObject5 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
          localObject1 = localObject2;
          if (localObject5 != null) {
            localObject1 = ((com.tencent.mm.live.core.core.model.i)localObject5).mNM;
          }
        }
      }
      label915:
      localObject1 = paramb.CCg;
      if (localObject1 != null) {
        com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)localObject1, false, 1, null);
      }
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      com.tencent.mm.plugin.finder.live.model.aj.a(2, null, false, 6);
    }
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(371867);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject = paramb.Eks;
    if (localObject != null) {
      ((cg)localObject).fY(paramView);
    }
    localObject = paramb.Ekm;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.ar)localObject).fY(paramView);
    }
    paramb = paramb.Ekn;
    if (paramb != null) {
      paramb.fY(paramView);
    }
    AppMethodBeat.o(371867);
  }
  
  private static final void b(b paramb, com.tencent.mm.plugin.finder.live.plugin.ah paramah)
  {
    AppMethodBeat.i(357901);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramah, "$it");
    if (paramb.Ekz != null)
    {
      localObject = paramb.Ekz;
      if (localObject == null) {
        localObject = null;
      }
      while (localObject == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(357901);
        throw paramb;
        localObject = ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject).CZo;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.widget.ae)localObject).cvt());
        }
      }
      if (((Boolean)localObject).booleanValue())
      {
        localObject = paramb.EiZ;
        if ((localObject == null) || (((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() != 0)) {
          break label164;
        }
      }
    }
    label164:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = paramb.EiZ;
        if (localObject != null) {
          ((br)localObject).tO(8);
        }
      }
      localObject = paramah.mJe.getLayoutParams();
      if (localObject != null) {
        break;
      }
      paramb = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(357901);
      throw paramb;
    }
    Object localObject = (RelativeLayout.LayoutParams)localObject;
    if (paramb.EjH == 0)
    {
      paramah = paramah.mJe.getLayoutParams();
      if (paramah == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(357901);
        throw paramb;
      }
      ((ViewGroup.MarginLayoutParams)paramah).bottomMargin = paramb.CCa.getResources().getDimensionPixelOffset(p.c.Edge_2A);
      paramah = paramb.Eje;
      if (paramah != null) {
        paramah.DcS = null;
      }
      paramah = paramb.CCg;
      if ((paramah == null) || (paramah.isLandscape() != true)) {
        break label327;
      }
    }
    label327:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label332;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      AppMethodBeat.o(357901);
      return;
      paramah = paramah.mJe.getLayoutParams();
      if (paramah == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(357901);
        throw paramb;
      }
      ((ViewGroup.MarginLayoutParams)paramah).bottomMargin = paramb.EjH;
      break;
    }
    label332:
    ((RelativeLayout.LayoutParams)localObject).removeRule(12);
    paramb = paramb.EjI;
    if (paramb == null) {}
    for (i = 0;; i = paramb.getId())
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(2, i);
      AppMethodBeat.o(357901);
      return;
    }
  }
  
  private static final void b(b paramb, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    AppMethodBeat.i(371884);
    kotlin.g.b.s.u(paramb, "this$0");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).h(paramh);
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
    {
      paramb = paramb.CCg;
      if (paramb != null) {
        com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramb, false, 1, null);
      }
    }
    AppMethodBeat.o(371884);
  }
  
  private static final void b(b paramb, Integer paramInteger, View paramView)
  {
    AppMethodBeat.i(357882);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramInteger);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    paramView = paramb.ezF();
    if (paramView != null) {
      paramView.niX.hide();
    }
    Log.i(paramb.TAG, "scene:" + paramInteger + ", click cancel");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357882);
  }
  
  private final boolean bep()
  {
    AppMethodBeat.i(357651);
    Object localObject = getLiveCore();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.model.i)localObject).bep() == true))
      {
        AppMethodBeat.o(357651);
        return true;
      }
    }
    AppMethodBeat.o(357651);
    return false;
  }
  
  private final void c(com.tencent.mm.live.core.core.model.g paramg)
  {
    AppMethodBeat.i(357602);
    label562:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = this.data;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject1).Ebr;
          if (localObject1 != null)
          {
            localObject1 = ((LiveConfig)localObject1).mIW;
            if (localObject1 != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
              if ((!com.tencent.mm.plugin.finder.live.model.aj.elz()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOv != null)) {
                break label229;
              }
              i = 1;
              break label562;
              if (localObject1 != null)
              {
                localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
                localObject3 = new dix();
                ((dix)localObject3).parseFrom((byte[])localObject1);
                localObject1 = kotlin.ah.aiuX;
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).a((dix)localObject3);
              }
            }
          }
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOv;
        if (localObject1 != null)
        {
          localObject1 = new diy().parseFrom(((com.tencent.mm.bx.b)localObject1).Op);
          if (localObject1 != null) {
            break label240;
          }
          paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
          AppMethodBeat.o(357602);
          throw paramg;
        }
      }
      catch (Exception paramg)
      {
        com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "parseLiveSdkInfoForPreliveErr", false, null, false, null, 60);
        Log.e(this.TAG, kotlin.g.b.s.X("setLiveRoomInfoFromLiveSdkInfo ", paramg.getMessage()));
        AppMethodBeat.o(357602);
        return;
      }
      label229:
      int i = 0;
      label240:
      while (i == 0)
      {
        localObject1 = null;
        break;
        localObject1 = ((diy)localObject1).aaOC;
        i = ((diw)localObject1).aaNO;
        boolean bool = com.tencent.mm.modelcontrol.e.wb(5);
        localObject2 = com.tencent.mm.plugin.finder.live.model.ag.CGN;
        com.tencent.mm.plugin.finder.live.model.ag.qD(bool);
        if ((!bool) && (i == com.tencent.mm.live.core.core.a.mJu.value)) {
          i = ((diw)localObject1).aaNP;
        }
        for (;;)
        {
          paramg.mNs = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveVideoDefinitionStorage().oD(paramg.liveId);
          paramg.mJU = ((diw)localObject1).aaNP;
          if (i < 100)
          {
            paramg.a(com.tencent.mm.live.core.core.model.a.mMz);
            paramg.mNr = i;
          }
          for (;;)
          {
            localObject2 = ((diw)localObject1).aaNK;
            if (localObject2 == null) {
              break;
            }
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (xb)((Iterator)localObject2).next();
              Map localMap = (Map)paramg.mNt;
              i = ((xb)localObject3).ZeQ;
              String str = ((xb)localObject3).url;
              kotlin.g.b.s.s(str, "it.url");
              localMap.put(Integer.valueOf(i), new com.tencent.mm.live.core.core.model.j(str, ((xb)localObject3).ZeS, ((xb)localObject3).ZeT));
            }
            if (i == com.tencent.mm.live.core.core.a.mJv.value) {
              paramg.a(com.tencent.mm.live.core.core.model.a.mMA);
            } else if (i == com.tencent.mm.live.core.core.a.mJw.value) {
              paramg.a(com.tencent.mm.live.core.core.model.a.mMB);
            }
          }
          kotlin.g.b.s.s(localObject1, "_channelParams");
          paramg.a((diw)localObject1);
          Log.i(this.TAG, "setLiveRoomInfoFromLiveSdkInfo p2pSwtich " + paramg.mNv.aaNY + " appId " + paramg.mNv.aaOg);
          AppMethodBeat.o(357602);
          return;
        }
      }
    }
  }
  
  private static final void c(b paramb)
  {
    AppMethodBeat.i(371870);
    kotlin.g.b.s.u(paramb, "this$0");
    paramb = paramb.Ekl;
    if (paramb != null) {
      paramb.erI();
    }
    AppMethodBeat.o(371870);
  }
  
  private static final void c(b paramb, View paramView)
  {
    AppMethodBeat.i(371875);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    paramView = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    paramView = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
    if (paramView != null) {
      paramView.c((Activity)paramb.CCa, false);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(371875);
  }
  
  private static final void d(b paramb)
  {
    AppMethodBeat.i(371873);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    localObject = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.model.ap)localObject).d((kotlin.g.a.r)new ag(paramb));
    }
    AppMethodBeat.o(371873);
  }
  
  private static final void d(b paramb, View paramView)
  {
    AppMethodBeat.i(371876);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    paramView = paramb.ezF();
    if (paramView != null) {
      paramView.niX.hide();
    }
    paramb = paramb.Eky;
    if (paramb != null) {
      paramb.Dlx.ezZ();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(371876);
  }
  
  private static final void e(b paramb)
  {
    AppMethodBeat.i(371880);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject = paramb.EiQ;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.b.a)localObject).mJe;
      if (localObject != null)
      {
        paramb = paramb.Ejb;
        if (paramb != null) {
          paramb.gc((View)localObject);
        }
      }
    }
    AppMethodBeat.o(371880);
  }
  
  private void e(kotlin.r<Integer, Integer> paramr)
  {
    AppMethodBeat.i(357630);
    Object localObject1 = this.EjV;
    Object localObject2;
    label28:
    RelativeLayout.LayoutParams localLayoutParams;
    label43:
    label57:
    label72:
    int k;
    int n;
    int j;
    int i3;
    boolean bool2;
    int i2;
    boolean bool3;
    int m;
    int i1;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label1021;
      }
      localObject1 = null;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label1031;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)localObject1;
      localObject1 = this.CCg;
      if (localObject1 != null) {
        break label1037;
      }
      localObject1 = null;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label1065;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      k = 0;
      n = -1;
      j = -1;
      i3 = this.CCa.getResources().getConfiguration().orientation;
      bool2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).ejX();
      i2 = 0;
      bool3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyD();
      ??? = this.Eks;
      if (??? != null) {
        ((cg)???).rK(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC());
      }
      ??? = paramr;
      if (paramr == null)
      {
        paramr = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        ??? = com.tencent.mm.plugin.finder.live.utils.a.gG((Context)this.CCa);
      }
      m = ((Number)((kotlin.r)???).bsC).intValue();
      i1 = ((Number)((kotlin.r)???).bsD).intValue();
      paramr = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
      kotlin.g.b.s.s(paramr, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    }
    for (;;)
    {
      synchronized ((Iterable)paramr)
      {
        Object localObject4 = ((Iterable)???).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          paramr = ((Iterator)localObject4).next();
          bool1 = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramr).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF());
          if (!bool1) {
            continue;
          }
          if (paramr == null) {
            break label1088;
          }
          bool1 = true;
          if (((!bool2) && (!bool1)) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyM())) {
            break label1471;
          }
          if ((1 != i3) || (!bool3)) {
            break label1295;
          }
          if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyE()) && (!bool1)) {
            break label1094;
          }
          paramr = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          k = com.tencent.mm.plugin.finder.live.utils.a.euM();
          i = m / 2;
          j = (int)(1.777778F * i);
          i = (int)(i * 1.777778F);
          f1 = 0.0F;
          f2 = 0.0F;
          m = i2;
          paramr = com.tencent.mm.plugin.finder.utils.bj.GlQ;
          if ((!com.tencent.mm.plugin.finder.utils.bj.y(this.buContext)) || (1 != i3)) {
            break label1738;
          }
          paramr = this.Ejt;
          if (paramr != null) {
            paramr.tO(8);
          }
          i = -2;
          paramr = this.EjV;
          if (paramr != null) {
            break label1647;
          }
          paramr = null;
          label455:
          if (paramr != null) {
            break label1658;
          }
          paramr = null;
          label461:
          if (!(paramr instanceof ConstraintLayout.LayoutParams)) {
            break label1666;
          }
          paramr = (ConstraintLayout.LayoutParams)paramr;
          label473:
          if (paramr != null) {
            paramr.topMargin = j;
          }
          ??? = this.TAG;
          localObject4 = new StringBuilder("switchLp?.topMargin:");
          if (paramr != null) {
            break label1671;
          }
          paramr = null;
          label507:
          Log.i((String)???, paramr + ", parentTopMargin:" + k + ", parentHeight:-2, previewHeight:" + j);
          if (localObject2 != null) {
            break label1682;
          }
          paramr = null;
          label550:
          if (!(paramr instanceof View)) {
            break label1691;
          }
          paramr = (View)paramr;
          label562:
          if (paramr != null) {
            paramr.setTranslationX(0.0F);
          }
          if (localObject2 != null) {
            break label1696;
          }
          paramr = null;
          label578:
          if (!(paramr instanceof View)) {
            break label1705;
          }
          paramr = (View)paramr;
          label590:
          if (paramr != null) {
            paramr.setTranslationY(0.0F);
          }
          if (localObject2 != null) {
            break label1710;
          }
          paramr = null;
          label606:
          if (!(paramr instanceof View)) {
            break label1719;
          }
          paramr = (View)paramr;
          label618:
          if (paramr != null) {
            paramr.setScaleX(1.0F);
          }
          if (localObject2 != null) {
            break label1724;
          }
          paramr = null;
          label634:
          if (!(paramr instanceof View)) {
            break label1733;
          }
          paramr = (View)paramr;
          label646:
          if (paramr != null) {
            paramr.setScaleY(1.0F);
          }
          paramr = this.EjV;
          n = i;
          if (paramr != null)
          {
            paramr.ess();
            n = i;
          }
          label676:
          if (localObject1 != null) {
            ((RelativeLayout.LayoutParams)localObject1).topMargin = k;
          }
          if (localObject1 != null) {
            ((RelativeLayout.LayoutParams)localObject1).height = n;
          }
          if (localLayoutParams != null) {
            localLayoutParams.height = j;
          }
          paramr = this.CCg;
          if (paramr != null) {
            break label1765;
          }
          paramr = null;
          label723:
          if (paramr != null) {
            paramr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if (localObject2 != null) {
            ((TXCloudVideoView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
          }
          if (localObject2 != null) {
            ((TXCloudVideoView)localObject2).postDelayed(new b..ExternalSyntheticLambda22(this, (TXCloudVideoView)localObject2), 100L);
          }
          paramr = this.EkU;
          if (paramr != null) {
            paramr.hH(k, j);
          }
          localObject2 = this.TAG;
          ??? = new StringBuilder();
          localObject4 = ((StringBuilder)???).append("adjustLayoutCDN fitLandscapeVideo:").append(bool2).append(",curOrientation:").append(i3).append(",videoSizeValid:").append(bool3).append(",uiState:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS).append(",videoScaleHeight:").append(m).append(",limitHeight:").append(f2).append(",landscapePlayerMiniHeight:").append(f1).append(",parentLp height:");
          if (localObject1 != null) {
            break label1773;
          }
          paramr = null;
          label910:
          localObject4 = ((StringBuilder)localObject4).append(paramr).append(",top:");
          if (localObject1 != null) {
            break label1785;
          }
          paramr = null;
          label931:
          localObject1 = ((StringBuilder)localObject4).append(paramr).append(", height:");
          if (localLayoutParams != null) {
            break label1797;
          }
          paramr = null;
          label952:
          localObject1 = ((StringBuilder)localObject1).append(paramr).append(",top:");
          if (localLayoutParams != null) {
            break label1809;
          }
          paramr = null;
          label973:
          ((StringBuilder)localObject1).append(paramr).append(", isLinkMicSelf:");
          ((StringBuilder)???).append(bool1);
          Log.i((String)localObject2, ((StringBuilder)???).toString());
          AppMethodBeat.o(357630);
          return;
          localObject2 = ((cc)localObject1).bjv();
          break;
          label1021:
          localObject1 = ((TXCloudVideoView)localObject2).getLayoutParams();
          break label28;
          label1031:
          localLayoutParams = null;
          break label43;
          label1037:
          localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).getPreviewRoot();
          if (localObject1 == null)
          {
            localObject1 = null;
            break label57;
          }
          localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
          break label57;
          label1065:
          localObject1 = null;
          break label72;
        }
        paramr = null;
      }
      label1088:
      boolean bool1 = false;
      continue;
      label1094:
      float f1 = m;
      int i = (int)(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).videoHeight / ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).videoWidth * f1);
      float f2 = i1 * 0.688F;
      f1 = MMApplicationContext.getContext().getResources().getDimension(p.c.finder_32A);
      if (i <= f2)
      {
        j = (int)(0.156F * i1) + com.tencent.mm.ui.bf.getStatusBarHeight((Context)this.CCa);
        if (i < f1)
        {
          n = (int)f1;
          k = n;
          m = j;
          if (localLayoutParams != null)
          {
            localLayoutParams.addRule(16);
            m = i;
            k = j;
            j = i;
            i = n;
          }
        }
        else
        {
          m = i;
          k = i;
          n = j;
          j = k;
          k = n;
        }
      }
      else
      {
        m = 0;
        k = -1;
        if (localLayoutParams != null)
        {
          localLayoutParams.addRule(16);
          m = i;
          n = -1;
          k = 0;
          j = i;
          i = n;
          continue;
          label1295:
          if (com.tencent.mm.ui.aw.jkS())
          {
            if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv == null)
            {
              paramr = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
              kotlin.g.b.s.s(paramr, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
              if (((Collection)paramr).isEmpty()) {
                break label1465;
              }
              i = 1;
            }
            for (;;)
            {
              if (i != 0)
              {
                i = m / 2;
                f1 = com.tencent.mm.live.core.view.c.bhe();
                paramr = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                n = com.tencent.mm.plugin.finder.live.utils.a.euM();
                m = (int)(i * f1);
                i1 = (int)(i * f1);
                paramr = this.EjV;
                j = m;
                i = i1;
                k = n;
                if (paramr != null)
                {
                  paramr = paramr.mJG;
                  j = m;
                  i = i1;
                  k = n;
                  if (paramr != null)
                  {
                    paramr.setRenderMode(0);
                    f1 = 0.0F;
                    f2 = 0.0F;
                    j = m;
                    m = i2;
                    i = i1;
                    k = n;
                    break;
                    label1465:
                    i = 0;
                    continue;
                    label1471:
                    if (!com.tencent.mm.ui.aw.jkS()) {
                      break label1821;
                    }
                    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv == null)
                    {
                      paramr = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
                      kotlin.g.b.s.s(paramr, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
                      if (((Collection)paramr).isEmpty()) {
                        break label1641;
                      }
                      i = 1;
                    }
                  }
                }
                for (;;)
                {
                  if (i != 0)
                  {
                    i = m / 2;
                    f1 = com.tencent.mm.live.core.view.c.bhe();
                    paramr = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                    m = com.tencent.mm.plugin.finder.live.utils.a.euM();
                    n = (int)(i * f1);
                    i1 = (int)(i * f1);
                    paramr = this.EjV;
                    j = n;
                    i = i1;
                    k = m;
                    if (paramr != null)
                    {
                      paramr = paramr.mJG;
                      j = n;
                      i = i1;
                      k = m;
                      if (paramr != null)
                      {
                        paramr.setRenderMode(0);
                        k = m;
                        i = i1;
                        j = n;
                      }
                    }
                    f1 = 0.0F;
                    f2 = 0.0F;
                    m = i2;
                    break;
                    label1641:
                    i = 0;
                    continue;
                    label1647:
                    paramr = paramr.Dkj.CSG;
                    break label455;
                    label1658:
                    paramr = paramr.getLayoutParams();
                    break label461;
                    paramr = null;
                    break label473;
                    paramr = Integer.valueOf(paramr.topMargin);
                    break label507;
                    label1682:
                    paramr = ((TXCloudVideoView)localObject2).getParent();
                    break label550;
                    label1691:
                    paramr = null;
                    break label562;
                    label1696:
                    paramr = ((TXCloudVideoView)localObject2).getParent();
                    break label578;
                    label1705:
                    paramr = null;
                    break label590;
                    label1710:
                    paramr = ((TXCloudVideoView)localObject2).getParent();
                    break label606;
                    label1719:
                    paramr = null;
                    break label618;
                    label1724:
                    paramr = ((TXCloudVideoView)localObject2).getParent();
                    break label634;
                    label1733:
                    paramr = null;
                    break label646;
                    label1738:
                    paramr = this.EjV;
                    n = i;
                    if (paramr == null) {
                      break label676;
                    }
                    paramr.Dkj.doE();
                    n = i;
                    break label676;
                    label1765:
                    paramr = paramr.getPreviewRoot();
                    break label723;
                    label1773:
                    paramr = Integer.valueOf(((RelativeLayout.LayoutParams)localObject1).height);
                    break label910;
                    label1785:
                    paramr = Integer.valueOf(((RelativeLayout.LayoutParams)localObject1).topMargin);
                    break label931;
                    paramr = Integer.valueOf(localLayoutParams.height);
                    break label952;
                    label1809:
                    paramr = Integer.valueOf(localLayoutParams.topMargin);
                    break label973;
                  }
                }
              }
            }
          }
          label1666:
          label1671:
          label1821:
          f1 = 0.0F;
          label1797:
          f2 = 0.0F;
          m = i2;
          i = n;
          continue;
        }
      }
      j = i;
      n = m;
      m = j;
      j = i;
      i = k;
      k = n;
    }
  }
  
  private final void ehm()
  {
    AppMethodBeat.i(357691);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(this));
    AppMethodBeat.o(357691);
  }
  
  private final void emg()
  {
    AppMethodBeat.i(357734);
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
    Object localObject = e.b.mKf;
    if ((i == e.b.bct()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ezb()))
    {
      localObject = getLiveCore();
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.f.d)localObject).bfH();
      }
      localObject = this.Ekf;
      if (localObject != null)
      {
        ((ct)localObject).exitRoom();
        AppMethodBeat.o(357734);
      }
    }
    else
    {
      localObject = this.EjV;
      if (localObject != null) {
        ((cc)localObject).fD(false);
      }
    }
    AppMethodBeat.o(357734);
  }
  
  private final com.tencent.mm.plugin.finder.live.plugin.co ezE()
  {
    AppMethodBeat.i(357556);
    com.tencent.mm.plugin.finder.live.plugin.co localco = (com.tencent.mm.plugin.finder.live.plugin.co)this.Ekx.getValue();
    AppMethodBeat.o(357556);
    return localco;
  }
  
  private final com.tencent.mm.plugin.finder.live.plugin.ae ezF()
  {
    AppMethodBeat.i(357566);
    com.tencent.mm.plugin.finder.live.plugin.ae localae = (com.tencent.mm.plugin.finder.live.plugin.ae)this.EkC.getValue();
    AppMethodBeat.o(357566);
    return localae;
  }
  
  private final cs ezG()
  {
    AppMethodBeat.i(357577);
    cs localcs = (cs)this.EkF.getValue();
    AppMethodBeat.o(357577);
    return localcs;
  }
  
  private final b.m.1 ezJ()
  {
    AppMethodBeat.i(357583);
    b.m.1 local1 = (b.m.1)this.Ela.getValue();
    AppMethodBeat.o(357583);
    return local1;
  }
  
  private void ezL()
  {
    AppMethodBeat.i(357587);
    String str = this.TAG;
    com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
    Log.i(str, kotlin.g.b.s.X("checkChargeLiveInvalid live info:", com.tencent.mm.plugin.finder.live.view.convert.a.c(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo)));
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eyl())
    {
      AppMethodBeat.o(357587);
      return;
    }
    kotlinx.coroutines.j.a(this.coroutineScope, null, null, (kotlin.g.a.m)new g(this, null), 3);
    AppMethodBeat.o(357587);
  }
  
  private final void ezP()
  {
    AppMethodBeat.i(357751);
    Object localObject = this.Eja;
    if (localObject != null) {
      ((bz)localObject).tO(8);
    }
    localObject = this.EiZ;
    if (localObject != null) {
      ((br)localObject).tO(8);
    }
    localObject = this.EiW;
    if (localObject != null) {
      ((az)localObject).tO(8);
    }
    localObject = this.Eje;
    if (localObject != null) {
      ((ay)localObject).tO(8);
    }
    localObject = this.EjX;
    if (localObject != null) {
      ((bl)localObject).tO(8);
    }
    localObject = this.DcS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject).tO(8);
    }
    localObject = this.Ejb;
    if (localObject != null) {
      ((cf)localObject).tO(8);
    }
    localObject = ezE();
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.co)localObject).tO(8);
    }
    localObject = this.Ekt;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.bb)localObject).tO(8);
    }
    localObject = this.Ekr;
    if (localObject != null) {
      ((ax)localObject).tO(8);
    }
    localObject = this.Eky;
    if (localObject != null) {
      ((ci)localObject).tO(8);
    }
    localObject = this.Ekz;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject).tO(8);
    }
    localObject = this.EiY;
    if (localObject != null) {
      ((bq)localObject).tO(8);
    }
    localObject = this.Ekv;
    if (localObject != null) {
      ((cp)localObject).tO(8);
    }
    localObject = this.EkD;
    if (localObject != null) {
      ((af)localObject).tO(8);
    }
    localObject = this.EjA;
    if (localObject != null) {
      ((ac)localObject).tO(8);
    }
    localObject = this.EiV;
    if (localObject != null) {
      ((bk)localObject).tO(8);
    }
    AppMethodBeat.o(357751);
  }
  
  private final void ezv()
  {
    AppMethodBeat.i(357760);
    if (!com.tencent.mm.compatible.e.b.dh((Context)this.CCa))
    {
      Log.e(this.TAG, "showVideoTalking, permission denied");
      Object localObject = this.CCg;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).setMiniWinPermission(true);
      }
      localObject = this.CCg;
      if (localObject != null) {
        com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject, com.tencent.mm.live.b.b.c.ncz);
      }
      localObject = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
      com.tencent.mm.plugin.finder.live.fluent.g.eju();
      RequestFloatWindowPermissionDialog.a((Context)this.CCa, this.CCa.getString(p.h.live_room_mini_view_fail), (RequestFloatWindowPermissionDialog.a)new s(this), false, true, com.tencent.mm.bq.a.aQB());
      AppMethodBeat.o(357760);
      return;
    }
    qL(false);
    AppMethodBeat.o(357760);
  }
  
  private static final void f(b paramb)
  {
    AppMethodBeat.i(371881);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject = paramb.EiR;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.b.a)localObject).mJe;
      if (localObject != null)
      {
        paramb = paramb.Ejb;
        if (paramb != null) {
          paramb.gc((View)localObject);
        }
      }
    }
    AppMethodBeat.o(371881);
  }
  
  private final void f(kotlin.r<Integer, Integer> paramr)
  {
    AppMethodBeat.i(357644);
    Object localObject1 = this.Ekf;
    View localView;
    label28:
    RelativeLayout.LayoutParams localLayoutParams;
    label43:
    label57:
    label72:
    int k;
    int j;
    int i2;
    boolean bool1;
    int m;
    float f2;
    boolean bool2;
    Object localObject2;
    int n;
    int i1;
    int i;
    float f1;
    if (localObject1 == null)
    {
      localView = null;
      if (localView != null) {
        break label582;
      }
      localObject1 = null;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label592;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)localObject1;
      localObject1 = this.CCg;
      if (localObject1 != null) {
        break label598;
      }
      localObject1 = null;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label626;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      k = 0;
      j = -1;
      i2 = this.CCa.getResources().getConfiguration().orientation;
      bool1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).ejX();
      m = 0;
      f2 = 0.0F;
      bool2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyD();
      localObject2 = this.Eks;
      if (localObject2 != null) {
        ((cg)localObject2).rK(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC());
      }
      localObject2 = paramr;
      if (paramr == null)
      {
        paramr = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.gG((Context)this.CCa);
      }
      n = ((Number)((kotlin.r)localObject2).bsC).intValue();
      i1 = ((Number)((kotlin.r)localObject2).bsD).intValue();
      if (!bool1) {
        break label939;
      }
      if ((1 != i2) || (!bool2)) {
        break label830;
      }
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyE()) {
        break label632;
      }
      paramr = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      k = com.tencent.mm.plugin.finder.live.utils.a.euM();
      j = n / 2;
      i = (int)(1.777778F * j);
      j = (int)(j * 1.777778F);
      f1 = 0.0F;
    }
    for (;;)
    {
      label275:
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).topMargin = k;
      }
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).height = j;
      }
      if (localLayoutParams != null) {
        localLayoutParams.height = i;
      }
      paramr = this.CCg;
      if (paramr == null)
      {
        paramr = null;
        label322:
        if (paramr != null) {
          paramr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (localView != null) {
          localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        }
        localObject2 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("adjustLayoutTRTC fitLandscapeVideo:").append(bool1).append(",curOrientation:").append(i2).append(",videoSizeValid:").append(bool2).append(",uiState:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS).append(",videoScaleHeight:").append(m).append(",limitHeight:").append(f2).append(",landscapePlayerMiniHeight:").append(f1).append(",parentLp height:");
        if (localObject1 != null) {
          break label1056;
        }
        paramr = null;
        label461:
        localStringBuilder = localStringBuilder.append(paramr).append(",top:");
        if (localObject1 != null) {
          break label1068;
        }
        paramr = null;
        label482:
        localObject1 = localStringBuilder.append(paramr).append(", height:");
        if (localLayoutParams != null) {
          break label1080;
        }
        paramr = null;
        label503:
        localObject1 = ((StringBuilder)localObject1).append(paramr).append(",top:");
        if (localLayoutParams != null) {
          break label1092;
        }
      }
      label830:
      label1092:
      for (paramr = null;; paramr = Integer.valueOf(localLayoutParams.topMargin))
      {
        Log.i((String)localObject2, paramr);
        if (localView != null) {
          localView.postDelayed(new b..ExternalSyntheticLambda17(this, localView), 100L);
        }
        AppMethodBeat.o(357644);
        return;
        localView = (View)((ct)localObject1).mRt;
        break;
        label582:
        localObject1 = localView.getLayoutParams();
        break label28;
        label592:
        localLayoutParams = null;
        break label43;
        label598:
        localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).getPreviewRoot();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label57;
        }
        localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
        break label57;
        label626:
        localObject1 = null;
        break label72;
        label632:
        f1 = n;
        i = (int)(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).videoHeight / ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).videoWidth * f1);
        f2 = i1 * 0.688F;
        f1 = MMApplicationContext.getContext().getResources().getDimension(p.c.finder_32A);
        if (i <= f2)
        {
          n = (int)(0.156F * i1) + com.tencent.mm.ui.bf.getStatusBarHeight((Context)this.CCa);
          if (i < f1)
          {
            i1 = (int)f1;
            j = i1;
            k = n;
            if (localLayoutParams == null) {
              break label1112;
            }
            localLayoutParams.addRule(16);
            m = i;
            j = i1;
            k = n;
            break label275;
          }
          m = i;
          k = i;
          j = i;
          i = k;
          k = n;
          break label275;
        }
        k = 0;
        i1 = 0;
        n = -1;
        j = n;
        if (localLayoutParams == null) {
          break label1112;
        }
        localLayoutParams.addRule(16);
        m = i;
        j = n;
        k = i1;
        break label275;
        if (!com.tencent.mm.ui.aw.jkS()) {
          break label1104;
        }
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv == null)
        {
          paramr = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
          kotlin.g.b.s.s(paramr, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
          if (((Collection)paramr).isEmpty()) {
            break label933;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1104;
          }
          j = n / 2;
          f1 = com.tencent.mm.live.core.view.c.bhe();
          paramr = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          k = com.tencent.mm.plugin.finder.live.utils.a.euM();
          i = (int)(j * f1);
          j = (int)(j * f1);
          f1 = 0.0F;
          break;
        }
        if (!com.tencent.mm.ui.aw.jkS()) {
          break label1104;
        }
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv == null)
        {
          paramr = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
          kotlin.g.b.s.s(paramr, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
          if (((Collection)paramr).isEmpty()) {
            break label1042;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1104;
          }
          j = n / 2;
          f1 = com.tencent.mm.live.core.view.c.bhe();
          paramr = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          k = com.tencent.mm.plugin.finder.live.utils.a.euM();
          i = (int)(j * f1);
          j = (int)(j * f1);
          f1 = 0.0F;
          break;
        }
        paramr = paramr.getPreviewRoot();
        break label322;
        paramr = Integer.valueOf(((RelativeLayout.LayoutParams)localObject1).height);
        break label461;
        paramr = Integer.valueOf(((RelativeLayout.LayoutParams)localObject1).topMargin);
        break label482;
        paramr = Integer.valueOf(localLayoutParams.height);
        break label503;
      }
      label933:
      label939:
      label1068:
      label1080:
      label1104:
      f1 = 0.0F;
      label1042:
      label1056:
      i = -1;
      continue;
      label1112:
      m = i;
    }
  }
  
  private static final void g(b paramb)
  {
    AppMethodBeat.i(371885);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    if ((((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.d(paramb.CCa).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD) && ((paramb.CCg instanceof FinderLiveVisitorPluginLayout)))
    {
      paramb = paramb.CCg;
      if ((paramb instanceof FinderLiveVisitorPluginLayout)) {
        paramb = (FinderLiveVisitorPluginLayout)paramb;
      }
    }
    while (paramb != null)
    {
      paramb.clearForSideBar();
      AppMethodBeat.o(371885);
      return;
      paramb = null;
      continue;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcH)
      {
        localObject = paramb.CCg;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).onScreenClear(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcH);
        }
      }
    }
    AppMethodBeat.o(371885);
  }
  
  private static final void go(View paramView)
  {
    AppMethodBeat.i(371860);
    paramView.animate().alpha(1.0F).setDuration(500L).start();
    AppMethodBeat.o(371860);
  }
  
  private static final void gp(View paramView)
  {
    AppMethodBeat.i(371862);
    paramView.animate().alpha(1.0F).setDuration(500L).start();
    AppMethodBeat.o(371862);
  }
  
  private final boolean isFloatMode()
  {
    AppMethodBeat.i(357659);
    Object localObject = getLiveCore();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.model.i)localObject).isFloatMode() == true))
      {
        AppMethodBeat.o(357659);
        return true;
      }
    }
    AppMethodBeat.o(357659);
    return false;
  }
  
  private static final void lg(View paramView)
  {
    AppMethodBeat.i(371863);
    paramView.post(new b..ExternalSyntheticLambda8(paramView));
    AppMethodBeat.o(371863);
  }
  
  private final void p(String paramString, int paramInt1, final int paramInt2, final int paramInt3)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    AppMethodBeat.i(357682);
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("notityAnchorInfoBySei anchorUserId:").append(paramString).append(" lastAudioMode:").append(this.CuM).append(" lastScreenShareMode:").append(this.CuN).append("userStatus:").append(paramInt1).append(" songId:").append(paramInt2).append(", playStatus:").append(paramInt3).append(" coverUrl:");
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
    label162:
    boolean bool1;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject3, localObject1);
      if (paramString != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr;
        if (localObject1 != null) {
          break label589;
        }
        localObject1 = null;
        if (Util.isEqual(paramString, (String)localObject1))
        {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new v(this, paramInt2, paramInt3));
          paramString = com.tencent.mm.live.core.core.e.a.mKb;
          bool1 = com.tencent.mm.ae.d.ee(paramInt1, com.tencent.mm.live.core.core.e.a.bcs());
          if (this.CuN != bool1)
          {
            this.CuN = bool1;
            if (!bool1) {
              break label599;
            }
            paramString = getLiveCore();
            if (paramString != null)
            {
              paramString = paramString.mRB;
              if (paramString != null) {
                paramString.mNQ = true;
              }
            }
            paramString = this.EjV;
            if (paramString != null)
            {
              paramString = paramString.mJG;
              if (paramString != null) {
                paramString.setRenderMode(1);
              }
            }
            this.CuM = false;
            paramString = this.Ejt;
            if (paramString != null) {
              paramString.tO(4);
            }
          }
          paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
          if (paramString != null) {
            break label700;
          }
          paramString = localObject2;
          label309:
          localObject1 = (CharSequence)paramString;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label738;
          }
          paramInt2 = 1;
          label332:
          if (paramInt2 == 0) {
            break label848;
          }
          paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
          if (paramString != null) {
            break label743;
          }
          paramString = "";
        }
      }
    }
    label401:
    label589:
    label848:
    for (;;)
    {
      label358:
      localObject1 = com.tencent.mm.live.core.core.e.a.mKb;
      bool1 = com.tencent.mm.ae.d.ee(paramInt1, com.tencent.mm.live.core.core.e.a.bcr());
      if (this.CuM != bool1)
      {
        paramString = (CharSequence)paramString;
        if ((paramString != null) && (paramString.length() != 0)) {
          break label818;
        }
        paramInt2 = 1;
        if (paramInt2 == 0)
        {
          this.CuM = bool1;
          paramString = com.tencent.mm.live.core.core.e.a.mKb;
          bool1 = com.tencent.mm.ae.d.ee(paramInt1, com.tencent.mm.live.core.core.e.a.bcr());
          if (!bool1) {
            break label823;
          }
          paramString = getLiveCore();
          if (paramString != null)
          {
            paramString = paramString.mRB;
            if (paramString != null) {
              paramString.bev();
            }
          }
        }
      }
      for (;;)
      {
        paramString = new Bundle();
        paramString.putBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", bool1);
        paramString.putBoolean("PARAM_FINDER_LIVE_IS_SHARE_MODE", this.CuN);
        localObject1 = this.CCg;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).statusChange(com.tencent.mm.live.b.b.c.neR, paramString);
        }
        paramString = this.EiR;
        if (paramString != null)
        {
          localObject1 = com.tencent.mm.live.core.core.e.a.mKb;
          bool1 = bool2;
          if (!com.tencent.mm.ae.d.ee(paramInt1, com.tencent.mm.live.core.core.e.a.bcq())) {
            bool1 = true;
          }
          paramString.qJ(bool1);
        }
        AppMethodBeat.o(357682);
        return;
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderObjectDesc)localObject1).liveDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((bgk)localObject1).EcY;
        break;
        localObject1 = ((dix)localObject1).aaOw;
        break label162;
        label599:
        paramString = getLiveCore();
        if (paramString != null)
        {
          paramString = paramString.mRB;
          if (paramString != null) {
            paramString.mNQ = false;
          }
        }
        paramString = this.EjV;
        if (paramString != null)
        {
          paramString = paramString.mJG;
          if (paramString != null)
          {
            localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            localObject1 = this.buContext;
            localObject3 = this.CCg;
            if (localObject3 != null) {
              break label690;
            }
          }
        }
        for (bool1 = false;; bool1 = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject3).isLandscape())
        {
          paramString.setRenderMode(com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, bool1, this.CuN));
          this.CuM = false;
          break;
        }
        localObject1 = paramString.objectDesc;
        paramString = localObject2;
        if (localObject1 == null) {
          break label309;
        }
        localObject1 = ((FinderObjectDesc)localObject1).liveDesc;
        paramString = localObject2;
        if (localObject1 == null) {
          break label309;
        }
        paramString = ((bgk)localObject1).EcY;
        break label309;
        label738:
        paramInt2 = 0;
        break label332;
        label743:
        paramString = paramString.objectDesc;
        if (paramString == null)
        {
          paramString = "";
          break label358;
        }
        paramString = paramString.media;
        if (paramString == null)
        {
          paramString = "";
          break label358;
        }
        paramString = (FinderMedia)kotlin.a.p.oL((List)paramString);
        if (paramString == null)
        {
          paramString = "";
          break label358;
        }
        localObject1 = paramString.url;
        paramString = (String)localObject1;
        if (localObject1 != null) {
          break label358;
        }
        paramString = "";
        break label358;
        paramInt2 = 0;
        break label401;
        paramString = getLiveCore();
        if (paramString != null)
        {
          paramString = paramString.mRB;
          if (paramString != null) {
            paramString.bew();
          }
        }
      }
    }
  }
  
  public final void Qg(int paramInt)
  {
    AppMethodBeat.i(358652);
    Log.i(this.TAG, kotlin.g.b.s.X("onCloseLinkMicOthers micType:", Integer.valueOf(paramInt)));
    paramInt = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
    ??? = e.b.mKf;
    if (paramInt != e.b.bct())
    {
      paramInt = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
      ??? = e.b.mKf;
      if (paramInt == e.b.bcu())
      {
        ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
        kotlin.g.b.s.s(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        synchronized ((Iterable)???)
        {
          Iterator localIterator = ((Iterable)???).iterator();
          boolean bool;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localIterator.next()).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF());
          } while (!bool);
          AppMethodBeat.o(358652);
          return;
        }
      }
    }
    AppMethodBeat.o(358652);
  }
  
  public final void a(com.tencent.mm.live.b.b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(358814);
    kotlin.g.b.s.u(paramc, "status");
    switch (e.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(358814);
      return;
      Object localObject1 = new StringBuilder("checkFinderObject id:");
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
      label183:
      final int i;
      label286:
      label310:
      label346:
      Object localObject2;
      label373:
      Object localObject3;
      label393:
      Object localObject4;
      long l1;
      label440:
      label453:
      label498:
      boolean bool1;
      if (paramc == null)
      {
        paramc = null;
        paramc = paramc + ", nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId + ", data:" + this.data;
        localObject1 = com.tencent.mm.plugin.findersdk.f.b.HeJ;
        com.tencent.mm.plugin.findersdk.f.b.iz(this.TAG, paramc);
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco != null)
        {
          paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
          if ((paramc == null) || (paramc.id != 0L)) {
            break label895;
          }
          i = 1;
          if (i == 0)
          {
            paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
            if (paramc != null) {
              break label900;
            }
            paramc = null;
            if (paramc != null)
            {
              paramc = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyo();
              if ((paramc != null) && (paramc.length() != 0)) {
                break label922;
              }
              i = 1;
              if (i == 0) {
                break label498;
              }
            }
          }
        }
        localObject2 = new bui();
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        paramc = com.tencent.mm.plugin.finder.live.model.aj.egD();
        if (paramc != null) {
          break label927;
        }
        i = 0;
        ((bui)localObject2).hLK = i;
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        paramc = com.tencent.mm.plugin.finder.live.model.aj.egD();
        if (paramc != null) {
          break label949;
        }
        i = 0;
        ((bui)localObject2).AJo = i;
        paramc = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        kotlin.g.b.s.s(paramc, "service(IFinderCommonService::class.java)");
        localObject3 = (com.tencent.mm.plugin.h)paramc;
        localObject4 = (MMActivity)this.CCa;
        paramc = this.data;
        if (paramc != null) {
          break label971;
        }
        l1 = 0L;
        paramc = this.data;
        if (paramc != null) {
          break label995;
        }
        paramc = "";
        h.a.a((com.tencent.mm.plugin.h)localObject3, (MMActivity)localObject4, l1, paramc, "", true, null, false, null, (bui)localObject2, 5, (kotlin.g.a.b)new d(new SoftReference(this), this.TAG), 16256);
        if (paramBundle != null) {
          break label1032;
        }
        bool1 = false;
        label505:
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        com.tencent.mm.plugin.finder.live.model.aj.biS();
        paramc = this.Ejf;
        if (paramc != null)
        {
          paramc.eqO();
          paramc = kotlin.ah.aiuX;
        }
        paramc = this.Ejq;
        if (paramc != null)
        {
          paramc.eqX();
          paramc = kotlin.ah.aiuX;
        }
        startTimer();
        Log.i(this.TAG, kotlin.g.b.s.X("START_LIVE byMiniWin:", Boolean.valueOf(bool1)));
        if ((paramBundle == null) || (paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW") != true)) {
          break label1044;
        }
        i = 1;
        label585:
        if ((i != 0) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcH))
        {
          paramc = this.CCg;
          if (paramc != null) {
            paramc.postDelayed(new b..ExternalSyntheticLambda11(this), 300L);
          }
        }
        paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
        if (paramc != null)
        {
          paramBundle = this.Ejo;
          if (paramBundle != null)
          {
            paramBundle.awC(paramc.mXL);
            paramc = kotlin.ah.aiuX;
          }
          paramc = this.EiR;
          if (paramc != null)
          {
            paramc.emx();
            paramc = kotlin.ah.aiuX;
          }
          paramc = this.EiR;
          if (paramc != null)
          {
            paramc.emy();
            paramc = kotlin.ah.aiuX;
          }
        }
        paramc = this.CCg;
        if (paramc != null)
        {
          paramc.checkPauseStateWhenLiveStart();
          paramc = kotlin.ah.aiuX;
        }
        paramc = this.EjW;
        if (paramc != null)
        {
          paramc.eoD();
          paramc = kotlin.ah.aiuX;
        }
        paramc = this.Ejc;
        if (paramc != null)
        {
          paramc.eoD();
          paramc = kotlin.ah.aiuX;
        }
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DUe)
        {
          paramc = this.EiW;
          if (paramc != null)
          {
            paramc.eqI();
            paramc = kotlin.ah.aiuX;
          }
        }
        paramc = this.Eje;
        if (paramc != null) {
          break label1049;
        }
      }
      label900:
      label1032:
      label1044:
      label1049:
      for (paramc = null;; paramc = paramc.DcS)
      {
        if (paramc != null)
        {
          paramc = this.CCg;
          if (paramc != null)
          {
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramc, com.tencent.mm.live.b.b.c.ncO);
            paramc = kotlin.ah.aiuX;
          }
        }
        paramc = com.tencent.mm.plugin.finder.live.util.m.DJb;
        com.tencent.mm.plugin.finder.live.util.m.k(this.buContext);
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edb) {
          break;
        }
        paramc = com.tencent.mm.ui.component.k.aeZF;
        ((by)com.tencent.mm.ui.component.k.d(this.CCa).cq(by.class)).fpm();
        AppMethodBeat.o(358814);
        return;
        paramc = Long.valueOf(paramc.id);
        break label183;
        label895:
        i = 0;
        break label286;
        paramc = paramc.liveInfo;
        if (paramc == null)
        {
          paramc = null;
          break label310;
        }
        paramc = paramc.ZRS;
        break label310;
        label922:
        i = 0;
        break label346;
        label927:
        paramc = paramc.Bwy;
        if (paramc == null)
        {
          i = 0;
          break label373;
        }
        i = paramc.AJo;
        break label373;
        label949:
        paramc = paramc.Bwy;
        if (paramc == null)
        {
          i = 0;
          break label393;
        }
        i = paramc.AJo;
        break label393;
        label971:
        paramc = paramc.Ebr;
        if (paramc == null)
        {
          l1 = 0L;
          break label440;
        }
        l1 = paramc.mIH;
        break label440;
        label995:
        paramc = paramc.Ebr;
        if (paramc == null)
        {
          paramc = "";
          break label453;
        }
        localObject1 = paramc.nonceId;
        paramc = (com.tencent.mm.live.b.b.c)localObject1;
        if (localObject1 != null) {
          break label453;
        }
        paramc = "";
        break label453;
        bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW");
        break label505;
        i = 0;
        break label585;
      }
      paramc = com.tencent.mm.plugin.finder.live.util.m.DJb;
      com.tencent.mm.plugin.finder.live.util.m.l(this.buContext);
      paramc = this.CCg;
      if (paramc != null) {
        paramc.setMiniWinPermission(false);
      }
      paramc = this.CCg;
      if (paramc != null)
      {
        paramc = paramc.getLiveCore();
        if (paramc != null)
        {
          paramc.bci();
          paramc = kotlin.ah.aiuX;
        }
      }
      paramc = this.CCg;
      if (paramc != null)
      {
        paramc.finish();
        paramc = kotlin.ah.aiuX;
      }
      paramc = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if (com.tencent.mm.plugin.finder.utils.aw.bgV())
      {
        paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        if ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)com.tencent.mm.plugin.finder.live.model.aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class) != null)
        {
          com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.sm(false);
          AppMethodBeat.o(358814);
          return;
          if (paramBundle == null)
          {
            paramc = null;
            if (paramBundle != null) {
              break label1321;
            }
            bool1 = false;
            label1175:
            if (paramBundle != null) {
              break label1334;
            }
            i = 0;
            label1181:
            if (isFloatMode()) {
              continue;
            }
            paramBundle = com.tencent.mm.plugin.finder.live.model.ar.CIh;
            com.tencent.mm.plugin.finder.live.model.ar.emi();
            paramBundle = this.CCg;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.getLiveCore();
              if (paramBundle != null)
              {
                paramBundle = (com.tencent.mm.live.core.core.b)paramBundle;
                localObject1 = (Context)this.CCa;
                if (paramc != null) {
                  break label1346;
                }
              }
            }
          }
          label1321:
          label1334:
          label1346:
          for (boolean bool2 = true;; bool2 = paramc.booleanValue())
          {
            com.tencent.mm.live.core.core.b.a.a(paramBundle, (Context)localObject1, bool2, false, i, 0, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DVR, bool1, 16);
            if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 524288))
            {
              paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
              com.tencent.mm.plugin.finder.live.model.aj.elJ();
            }
            paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
            com.tencent.mm.plugin.finder.live.model.aj.elR();
            AppMethodBeat.o(358814);
            return;
            paramc = Boolean.valueOf(paramBundle.getBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true));
            break;
            bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_FLUENT_EXIT", false);
            break label1175;
            i = paramBundle.getInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0);
            break label1181;
          }
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcG)
          {
            paramc = this.CCg;
            if (paramc != null)
            {
              com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramc, com.tencent.mm.live.b.b.c.ncD);
              paramc = kotlin.ah.aiuX;
            }
          }
          paramc = this.Eky;
          if (paramc != null)
          {
            paramc.rL(false);
            paramc = kotlin.ah.aiuX;
          }
          paramc = this.EkL;
          if (paramc != null)
          {
            paramc.esV();
            paramc = kotlin.ah.aiuX;
          }
          long l2;
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).EhZ) {
            if (this.Ekz != null)
            {
              paramc = this.Ekz;
              if (paramc == null) {
                paramc = null;
              }
              while (paramc == null)
              {
                paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(358814);
                throw paramc;
                paramc = paramc.CZo;
                if (paramc == null) {
                  paramc = null;
                } else {
                  paramc = Boolean.valueOf(paramc.cvt());
                }
              }
              if (paramc.booleanValue()) {}
            }
            else
            {
              paramc = com.tencent.mm.plugin.finder.live.d.BvP;
              l1 = com.tencent.mm.plugin.finder.live.d.egK();
              paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
              if ((paramc == null) || (l1 != paramc.id)) {
                break label1899;
              }
              i = 1;
              if (i == 0)
              {
                paramc = this.Eky;
                if (paramc != null)
                {
                  paramBundle = ci.Dlv;
                  paramc.Pe(ci.esH());
                }
                paramc = com.tencent.mm.plugin.finder.live.report.k.Doi;
                com.tencent.mm.plugin.finder.live.report.k.etr();
                if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eih)
                {
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eih = true;
                  paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
                  paramBundle = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
                  if (paramBundle != null)
                  {
                    localObject1 = (MMActivity)this.CCa;
                    l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
                    l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
                    localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
                    localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
                    paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
                    if (paramc != null) {
                      break label1904;
                    }
                    paramc = null;
                    label1719:
                    paramBundle.a((MMActivity)localObject1, l1, l2, (String)localObject2, (byte[])localObject3, null, 1, paramc, (kotlin.g.a.b)new d(new SoftReference(this), this.TAG));
                  }
                }
              }
            }
          }
          paramBundle = this.Eks;
          if (paramBundle != null)
          {
            paramc = this.EjV;
            if (paramc == null)
            {
              paramc = null;
              label1780:
              paramc = (View)paramc;
              if ((paramBundle.mJe.getVisibility() != 0) || (paramc == null) || (!(paramBundle.mJe.getTag() instanceof Integer)) || (paramBundle.isLandscape())) {
                break label2006;
              }
              paramc = (com.tencent.mm.plugin.finder.live.plugin.ar)paramBundle.getPlugin(com.tencent.mm.plugin.finder.live.plugin.ar.class);
              if ((paramc == null) || (paramc.mJe.getVisibility() != 0)) {
                break label1920;
              }
              i = 1;
              label1846:
              if ((i == 0) || (paramc == null)) {
                break label1925;
              }
              paramc = paramc.mJe;
              if (paramc == null) {
                break label1925;
              }
            }
            label1920:
            label1925:
            for (i = paramc.getHeight();; i = 0)
            {
              paramc = paramBundle.mJe.getTag();
              if (paramc != null) {
                break label1930;
              }
              paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(358814);
              throw paramc;
              label1899:
              i = 0;
              break;
              label1904:
              paramc = paramc.EeF;
              break label1719;
              paramc = paramc.bjv();
              break label1780;
              i = 0;
              break label1846;
            }
            label1930:
            i += ((Integer)paramc).intValue();
            paramc = paramBundle.mJe.getLayoutParams();
            if (!(paramc instanceof ViewGroup.MarginLayoutParams)) {
              break label2017;
            }
            paramc = (ViewGroup.MarginLayoutParams)paramc;
            if (paramc != null) {
              break label2022;
            }
            paramc = null;
            label1966:
            if (paramc != null) {
              break label2033;
            }
            label1970:
            paramc = paramBundle.mJe.getLayoutParams();
            if (!(paramc instanceof ViewGroup.MarginLayoutParams)) {
              break label2044;
            }
          }
          label2006:
          label2017:
          label2022:
          label2033:
          label2044:
          for (paramc = (ViewGroup.MarginLayoutParams)paramc;; paramc = null)
          {
            if (paramc != null) {
              paramc.topMargin = i;
            }
            paramBundle.mJe.requestLayout();
            do
            {
              paramc = kotlin.ah.aiuX;
              AppMethodBeat.o(358814);
              return;
              paramc = null;
              break;
              paramc = Integer.valueOf(paramc.topMargin);
              break label1966;
            } while (paramc.intValue() == i);
            break label1970;
          }
          if (paramBundle == null) {}
          for (bool1 = false;; bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR"))
          {
            paramc = this.CCg;
            if (paramc != null)
            {
              paramc.onScreenClear(bool1);
              paramc = kotlin.ah.aiuX;
            }
            AppMethodBeat.o(358814);
            return;
          }
          paramc = this.CCg;
          if (paramc != null) {
            paramc.setManualClosed(true);
          }
          paramc = this.CCg;
          if (paramc != null)
          {
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramc, com.tencent.mm.live.b.b.c.nck);
            paramc = kotlin.ah.aiuX;
          }
          AppMethodBeat.o(358814);
          return;
          paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE;
          kotlin.g.b.s.s(paramc, "business(LiveMsgSlice::class.java).msgList");
          if (!((Collection)paramc).isEmpty())
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            paramc = this.CCg;
            if (paramc != null) {
              break label2405;
            }
            paramc = null;
            label2192:
            i = com.tencent.mm.plugin.finder.live.utils.a.at(paramc);
            paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            paramc = this.CCg;
            if (paramc != null) {
              break label2447;
            }
            paramc = null;
            label2212:
            localObject2 = com.tencent.mm.plugin.finder.live.utils.a.au(paramc);
            localObject3 = com.tencent.mm.plugin.finder.live.report.k.Doi;
            paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE;
            kotlin.g.b.s.s(paramc, "business(LiveMsgSlice::class.java).msgList");
            localObject4 = ((com.tencent.mm.plugin.finder.live.model.aq)kotlin.a.p.oM(paramc)).getContent();
            if (i <= 0) {
              break label2489;
            }
            paramBundle = this.CCa.getString(p.h.Cox, new Object[] { Integer.valueOf(i) });
            label2284:
            paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE;
            kotlin.g.b.s.s(paramc, "business(LiveMsgSlice::class.java).msgList");
            i = ((com.tencent.mm.plugin.finder.live.model.aq)kotlin.a.p.oM(paramc)).getType();
            bool1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm();
            paramc = (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgQ.getValue();
            if (paramc != null) {
              break label2496;
            }
            paramc = "";
          }
          for (;;)
          {
            kotlin.g.b.s.u(paramc, "groupId");
            ((com.tencent.mm.plugin.finder.live.report.k)localObject3).a((String)localObject4, paramBundle, (String)localObject2, Integer.valueOf(i), bool1, paramc);
            com.tencent.mm.plugin.finder.live.report.k.Dop += 1;
            AppMethodBeat.o(358814);
            return;
            i = 0;
            break;
            label2405:
            paramc = paramc.getBuContext();
            if (paramc == null)
            {
              paramc = null;
              break label2192;
            }
            paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
            if (paramc == null)
            {
              paramc = null;
              break label2192;
            }
            paramc = paramc.Ecm;
            break label2192;
            label2447:
            paramc = paramc.getBuContext();
            if (paramc == null)
            {
              paramc = null;
              break label2212;
            }
            paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
            if (paramc == null)
            {
              paramc = null;
              break label2212;
            }
            paramc = paramc.Ecm;
            break label2212;
            label2489:
            paramBundle = "";
            break label2284;
            label2496:
            localObject1 = paramc.id;
            paramc = (com.tencent.mm.live.b.b.c)localObject1;
            if (localObject1 == null) {
              paramc = "";
            }
          }
          AppMethodBeat.o(358814);
          return;
          paramc = this.CCa;
          if ((paramc instanceof MMActivity))
          {
            paramc = (MMActivity)paramc;
            if ((paramc == null) || (paramc.isFinishing() != true)) {
              break label2700;
            }
            i = 1;
            label2555:
            if (i == 0)
            {
              paramc = this.CCa;
              if (!(paramc instanceof MMActivity)) {
                break label2705;
              }
              paramc = (MMActivity)paramc;
              if ((paramc == null) || (paramc.isDestroyed() != true)) {
                break label2710;
              }
              i = 1;
              if (i == 0) {
                continue;
              }
            }
            label2576:
            label2590:
            paramBundle = com.tencent.mm.plugin.finder.live.report.k.Doi;
            localObject1 = (Context)this.CCa;
            localObject2 = q.bw.DDy;
            paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
            paramc = com.tencent.mm.plugin.finder.live.model.aj.egD();
            if (paramc != null) {
              break label2715;
            }
          }
          label2700:
          label2705:
          label2710:
          label2715:
          for (paramc = null;; paramc = paramc.CFn)
          {
            paramBundle.a((Context)localObject1, (q.bw)localObject2, paramc);
            paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
            com.tencent.mm.plugin.finder.live.model.aj.a(false, false, null, false, 15);
            paramc = com.tencent.mm.live.core.core.f.a.mUf;
            a.a.clear();
            paramc = this.CCg;
            if (paramc != null)
            {
              paramc = paramc.getLiveCore();
              if (paramc != null)
              {
                paramc.bci();
                paramc = kotlin.ah.aiuX;
              }
            }
            this.buContext.clear();
            AppMethodBeat.o(358814);
            return;
            paramc = null;
            break;
            i = 0;
            break label2555;
            paramc = null;
            break label2576;
            i = 0;
            break label2590;
          }
          Log.i(this.TAG, kotlin.g.b.s.X("param:", paramBundle));
          paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (paramBundle == null)
          {
            i = 0;
            paramc.videoWidth = i;
            paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
            if (paramBundle != null) {
              break label3232;
            }
            i = 0;
            label2776:
            paramc.videoHeight = i;
            paramc = this.EjV;
            if (paramc != null)
            {
              paramc = paramc.mJG;
              if (paramc != null)
              {
                paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                paramBundle = this.buContext;
                localObject1 = this.CCg;
                if (localObject1 != null) {
                  break label3243;
                }
                bool1 = false;
                label2822:
                paramc.setRenderMode(com.tencent.mm.plugin.finder.live.utils.a.a(paramBundle, bool1, this.CuN));
                paramc = kotlin.ah.aiuX;
              }
            }
            paramc = this.TAG;
            paramBundle = new StringBuilder("videoWidth:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).videoWidth).append(",videoHeight:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).videoHeight).append(", audienceMode:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu()).append(", renderMode:");
            localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            localObject1 = this.buContext;
            localObject2 = this.CCg;
            if (localObject2 != null) {
              break label3253;
            }
            bool1 = false;
            label2949:
            Log.i(paramc, com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, bool1));
            if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyE())
            {
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv = null;
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.clear();
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM = false;
              paramc = this.CCg;
              if (paramc != null)
              {
                com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramc, com.tencent.mm.live.b.b.c.neD);
                paramc = kotlin.ah.aiuX;
              }
              paramc = this.Eky;
              if (paramc != null)
              {
                paramc.eoT();
                paramc = kotlin.ah.aiuX;
              }
              paramc = this.CCg;
              if (paramc != null) {
                com.tencent.mm.plugin.finder.live.view.a.notifyRoomPKMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramc, new JSONObject(), false, null, 6, null);
              }
              paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
              com.tencent.mm.plugin.finder.live.model.aj.a(3, new JSONObject(), false, 4);
            }
            if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
            {
              paramc = this.CCg;
              if (paramc != null)
              {
                com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramc, false, 1, null);
                paramc = kotlin.ah.aiuX;
              }
              paramc = this.CCg;
              if (paramc != null)
              {
                com.tencent.mm.plugin.finder.live.view.a.notifyPKMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramc, false, 1, null);
                paramc = kotlin.ah.aiuX;
              }
              paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
              if (paramc != null) {
                break label3263;
              }
              paramc = null;
              label3194:
              if (paramc == null) {
                break label3271;
              }
              paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
              com.tencent.mm.plugin.finder.live.model.aj.a(1, null, false, 6);
            }
          }
          for (;;)
          {
            a(this);
            AppMethodBeat.o(358814);
            return;
            i = paramBundle.getInt("EVT_PARAM1");
            break;
            label3232:
            i = paramBundle.getInt("EVT_PARAM2");
            break label2776;
            label3243:
            bool1 = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).isLandscape();
            break label2822;
            label3253:
            bool1 = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject2).isLandscape();
            break label2949;
            label3263:
            paramc = paramc.Efv;
            break label3194;
            label3271:
            paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
            com.tencent.mm.plugin.finder.live.model.aj.a(2, null, false, 6);
          }
          paramc = this.CCg;
          if ((paramc != null) && (!paramc.isLandscape()))
          {
            i = 1;
            if (i != 0)
            {
              paramc = this.akhj;
              if ((paramc == null) || (paramc.mJe.getVisibility() != 0)) {
                break label3479;
              }
              i = 1;
              label3329:
              if (i == 0) {
                break label3484;
              }
              paramc = this.akhj;
              if (paramc != null) {
                paramc.mJe.post(new b..ExternalSyntheticLambda6(paramBundle, this, paramc));
              }
            }
            label3360:
            if (paramBundle != null) {
              break label3536;
            }
            bool1 = false;
            label3367:
            paramc = com.tencent.mm.ui.component.k.aeZF;
            paramc = ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.d(this.CCa).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE;
            if (paramc != null)
            {
              if (!bool1) {
                break label3548;
              }
              kotlin.g.b.s.u("ENTERING_COMMENT", "sceneId");
              Log.i(paramc.TAG, kotlin.g.b.s.X("addDragBarrier ", "ENTERING_COMMENT"));
              paramc.DGo.add("ENTERING_COMMENT");
              paramBundle = paramc.DGn;
              paramc = paramBundle;
              if (paramBundle == null)
              {
                kotlin.g.b.s.bIx("finderSideBar");
                paramc = null;
              }
              paramc.fmj();
            }
          }
          for (;;)
          {
            paramc = kotlin.ah.aiuX;
            paramc = kotlin.ah.aiuX;
            AppMethodBeat.o(358814);
            return;
            i = 0;
            break;
            label3479:
            i = 0;
            break label3329;
            label3484:
            paramc = this.DcS;
            if (paramc == null) {
              break label3360;
            }
            localObject1 = paramc.mJe;
            if (localObject1 == null) {}
            for (paramc = null;; paramc = Boolean.valueOf(((ViewGroup)localObject1).post(new b..ExternalSyntheticLambda7(paramBundle, this, paramc))))
            {
              paramc.booleanValue();
              break;
            }
            label3536:
            bool1 = paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT");
            break label3367;
            label3548:
            kotlin.g.b.s.u("ENTERING_COMMENT", "sceneId");
            Log.i(paramc.TAG, kotlin.g.b.s.X("removeDragBarrier ", "ENTERING_COMMENT"));
            paramc.DGo.remove("ENTERING_COMMENT");
            paramc.rS(paramc.enable);
          }
          if (paramBundle != null)
          {
            paramBundle = paramBundle.getByteArray("PARAM_FINDER_LIVE_TOP_COMMENT");
            if (paramBundle != null)
            {
              paramc = new bke();
              paramc.parseFrom(paramBundle);
              paramBundle = new ArrayList();
              paramBundle.add(paramc);
              paramc = this.Ejb;
              if (paramc != null)
              {
                paramc.gF((List)paramBundle);
                paramc = kotlin.ah.aiuX;
              }
            }
          }
          AppMethodBeat.o(358814);
          return;
          if (paramBundle == null) {}
          for (i = 0;; i = paramBundle.getInt("PARAM_FINDER_LIVE_LINK_MIC_TYPE", 0))
          {
            paramc = new bgh();
            paramBundle = new FinderContact();
            paramBundle.username = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
            localObject1 = kotlin.ah.aiuX;
            paramc.contact = paramBundle;
            paramBundle = kotlin.ah.aiuX;
            paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
            paramBundle = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
            if (paramBundle != null)
            {
              l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
              l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
              localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
              localObject3 = l.k.mYO;
              paramBundle.a(l1, l2, (String)localObject1, (byte[])localObject2, l.k.bhH(), paramc, i, (com.tencent.mm.plugin.finder.live.model.cgi.d.a)new af(this, i));
              paramc = kotlin.ah.aiuX;
            }
            Log.i(this.TAG, kotlin.g.b.s.X("apply link mic type:", Integer.valueOf(i)));
            AppMethodBeat.o(358814);
            return;
          }
          paramc = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
          com.tencent.mm.plugin.finder.live.model.mic.b.enf();
          ezN();
          AppMethodBeat.o(358814);
          return;
          paramc = this.Ejo;
          if (paramc != null)
          {
            paramc.era();
            paramc = kotlin.ah.aiuX;
          }
          paramc = this.Ejr;
          if (paramc != null)
          {
            paramc.era();
            paramc = kotlin.ah.aiuX;
          }
          AppMethodBeat.o(358814);
          return;
          paramc = this.Ejo;
          if (paramc != null)
          {
            paramc.erb();
            paramc = kotlin.ah.aiuX;
          }
          paramc = this.Ejr;
          if (paramc != null)
          {
            paramc.erb();
            paramc = kotlin.ah.aiuX;
          }
          AppMethodBeat.o(358814);
          return;
          paramc = this.Eky;
          if (paramc != null)
          {
            paramc.Dlx.eBU();
            paramc = kotlin.ah.aiuX;
          }
          AppMethodBeat.o(358814);
          return;
          paramc = this.Ejk;
          if (paramc != null)
          {
            paramc.eqw();
            paramc = kotlin.ah.aiuX;
          }
          AppMethodBeat.o(358814);
          return;
          paramc = this.EiU;
          if (paramc == null)
          {
            paramc = null;
            label4033:
            if (paramBundle != null) {
              break label4144;
            }
            i = 0;
            label4039:
            Log.i(this.TAG, "FINDER_LIVE_MEMBERS_AUTO_REFRESH memberListPluginVisibility:" + paramc + ", delayTime:" + i);
            paramc = this.EiU;
            if ((paramc == null) || (paramc.mJe.getVisibility() != 0)) {
              break label4155;
            }
          }
          label4144:
          label4155:
          for (int j = 1; (j != 0) && (i >= 0); j = 0)
          {
            com.tencent.threadpool.h.ahAA.p(new b..ExternalSyntheticLambda13(this), i);
            AppMethodBeat.o(358814);
            return;
            paramc = Integer.valueOf(paramc.mJe.getVisibility());
            break label4033;
            i = paramBundle.getInt("PARAM_FINDER_LIVE_MEMBER_LIST_AUTOREFRESH_VALUE");
            break label4039;
          }
          if (paramBundle == null)
          {
            paramc = null;
            Log.i(this.TAG, kotlin.g.b.s.X("FINDER_LIVE_SHOW_BOTTOM_TIP_PANEL scene:", paramc));
            if (paramc != null) {
              break label4263;
            }
            label4185:
            if (paramc != null) {
              break label4325;
            }
            label4189:
            if (paramc != null) {
              break label4338;
            }
            label4193:
            i = 0;
            label4195:
            if (i == 0) {
              continue;
            }
            paramBundle = ezF();
            if (paramBundle != null) {
              if (paramc != null) {
                break label4351;
              }
            }
          }
          label4263:
          label4317:
          label4325:
          label4338:
          label4351:
          for (i = 0;; i = paramc.intValue())
          {
            paramBundle.a(i, new b..ExternalSyntheticLambda3(this, paramc), new b..ExternalSyntheticLambda4(this, paramc));
            paramc = kotlin.ah.aiuX;
            AppMethodBeat.o(358814);
            return;
            paramc = Integer.valueOf(paramBundle.getInt("PARAM_FINDER_BOTTOM_TIP_SCENE", 0));
            break;
            if (paramc.intValue() != 0) {
              break label4185;
            }
            paramBundle = ezF();
            if (paramBundle != null) {
              if (paramc != null) {
                break label4317;
              }
            }
            for (i = 0;; i = paramc.intValue())
            {
              paramBundle.a(i, new b..ExternalSyntheticLambda0(this), new b..ExternalSyntheticLambda2(this));
              paramc = kotlin.ah.aiuX;
              AppMethodBeat.o(358814);
              return;
            }
            if (paramc.intValue() != 2) {
              break label4189;
            }
            i = 1;
            break label4195;
            if (paramc.intValue() != 1) {
              break label4193;
            }
            i = 1;
            break label4195;
          }
          if (paramBundle == null) {}
          for (bool1 = false;; bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_IS_MUTE_MIC", false))
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eem = bool1;
            if (!bool1) {
              break;
            }
            paramc = this.CCg;
            if (paramc != null)
            {
              paramc = paramc.getLiveCore();
              if (paramc != null)
              {
                paramc.fI(true);
                paramc = kotlin.ah.aiuX;
              }
            }
            AppMethodBeat.o(358814);
            return;
          }
          paramc = this.CCg;
          if (paramc != null)
          {
            paramc = paramc.getLiveCore();
            if (paramc != null)
            {
              paramc.fI(false);
              paramc = kotlin.ah.aiuX;
            }
          }
          AppMethodBeat.o(358814);
          return;
          paramc = this.akhj;
          if ((paramc != null) && (paramc.mJe.getVisibility() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(358814);
            return;
          }
          paramc = this.DcS;
          if (paramc != null)
          {
            paramBundle = paramc.mJe;
            if (paramBundle != null) {
              break label4536;
            }
          }
          label4536:
          for (paramc = null;; paramc = Boolean.valueOf(paramBundle.post(new b..ExternalSyntheticLambda18(this, paramc))))
          {
            paramc.booleanValue();
            AppMethodBeat.o(358814);
            return;
          }
          paramc = this.akhj;
          if ((paramc != null) && (paramc.mJe.getVisibility() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(358814);
            return;
          }
          paramc = this.DcS;
          if (paramc != null)
          {
            paramBundle = paramc.mJe;
            if (paramBundle != null) {
              break label4625;
            }
          }
          label4625:
          for (paramc = null;; paramc = Boolean.valueOf(paramBundle.post(new b..ExternalSyntheticLambda19(this, paramc))))
          {
            paramc.booleanValue();
            AppMethodBeat.o(358814);
            return;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).PX(1);
          paramc = this.CCg;
          if (paramc != null)
          {
            paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            com.tencent.mm.plugin.finder.live.utils.a.c(this.buContext, (com.tencent.mm.live.b.b)paramc);
            paramc = kotlin.ah.aiuX;
            paramc = kotlin.ah.aiuX;
          }
          paramc = com.tencent.d.a.a.a.a.a.ahiX;
          if (((Number)com.tencent.d.a.a.a.a.a.jUo().bmg()).intValue() == 0)
          {
            paramc = new if();
            paramc.hJB.id = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
            paramc.hJB.type = 14;
            paramc.publish();
            paramc = this.CCg;
            if (paramc != null)
            {
              paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
              com.tencent.mm.plugin.finder.live.utils.a.a(this.buContext, (com.tencent.mm.live.b.b)paramc);
              paramc = kotlin.ah.aiuX;
              paramc = kotlin.ah.aiuX;
            }
          }
          for (;;)
          {
            paramc = this.CCg;
            if (paramc != null)
            {
              com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)paramc, false, 1, null);
              paramc = kotlin.ah.aiuX;
            }
            AppMethodBeat.o(358814);
            return;
            paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
            com.tencent.mm.plugin.finder.live.model.aj.elB();
            paramc = com.tencent.mm.plugin.finder.live.model.aj.CGT;
            paramc = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
            if (paramc != null)
            {
              paramc.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, 2, (kotlin.g.a.u)new c(new SoftReference(this), this.TAG));
              paramc = kotlin.ah.aiuX;
            }
          }
          paramc = this.EjV;
          if (paramc != null)
          {
            paramc.fD(true);
            paramc = kotlin.ah.aiuX;
          }
          paramc = this.CCg;
          if (paramc != null)
          {
            paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
            localObject1 = this.CCa.getResources().getString(p.h.CiX);
            kotlin.g.b.s.s(localObject1, "context.resources.getStr…arge_free_time_over_tips)");
            paramc.showTipWithBlurBg(paramBundle, (String)localObject1);
            paramc = kotlin.ah.aiuX;
          }
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.c paramc, bui parambui)
  {
    AppMethodBeat.i(358719);
    kotlin.g.b.s.u(paramc, "baseRouter");
    super.a(paramc, parambui);
    Object localObject = com.tencent.mm.plugin.finder.live.util.ag.DJR;
    com.tencent.mm.plugin.finder.live.util.ag.ejv().gF("onBindData start");
    Log.i(this.TAG, "onBindData");
    paramc.setExternalCallback((a.b)new b.y(this, paramc, parambui));
    if (paramc.getAudienPreloadCDNLiveConfig())
    {
      paramc = com.tencent.mm.plugin.finder.api.d.AwY;
      parambui = com.tencent.mm.plugin.finder.api.d.a.auT(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      if (parambui != null) {
        break label1021;
      }
      paramc = null;
      paramc = (CharSequence)paramc;
      if ((paramc != null) && (paramc.length() != 0)) {
        break label1029;
      }
      i = 1;
      label114:
      if (i == 0)
      {
        if (parambui != null) {
          break label1034;
        }
        paramc = null;
        label124:
        paramc = (CharSequence)paramc;
        if ((paramc != null) && (paramc.length() != 0)) {
          break label1042;
        }
      }
    }
    label1029:
    label1034:
    label1042:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramc = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        kotlin.g.b.s.s(paramc, "service(IFinderCommonService::class.java)");
        localObject = (com.tencent.mm.plugin.h)paramc;
        parambui = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
        paramc = parambui;
        if (parambui == null) {
          paramc = "";
        }
        h.a.a((com.tencent.mm.plugin.h)localObject, paramc, true, null, Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN), 360);
      }
      paramc = com.tencent.mm.plugin.finder.live.util.ag.DJR;
      com.tencent.mm.plugin.finder.live.util.ag.ejv().gF("initStaticPlugins start");
      localObject = this.CCg;
      if (localObject == null) {
        break label1310;
      }
      parambui = this.EjV;
      paramc = parambui;
      if (parambui == null)
      {
        paramc = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.live_tx_live_player_ui_root);
        kotlin.g.b.s.s(paramc, "it.findViewById(R.id.live_tx_live_player_ui_root)");
        paramc = new cc((ViewGroup)paramc, (com.tencent.mm.live.b.b)localObject);
      }
      this.EjV = paramc;
      paramc = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.live_preview_ui_root);
      kotlin.g.b.s.s(paramc, "it.findViewById(R.id.live_preview_ui_root)");
      this.Ekf = new ct((ViewGroup)paramc, (com.tencent.mm.live.b.b)localObject);
      paramc = this.Ekf;
      if (paramc != null) {
        paramc.tO(8);
      }
      if (this.Ekh == null)
      {
        paramc = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.live_shadow_ui_root);
        kotlin.g.b.s.s(paramc, "it.findViewById(R.id.live_shadow_ui_root)");
        this.Ekh = new bx((ViewGroup)paramc, (com.tencent.mm.live.b.b)localObject);
        paramc = this.Ekh;
        if (paramc != null) {
          paramc.tO(8);
        }
      }
      this.Ekg = new bo((ViewGroup)localObject, (com.tencent.mm.live.b.b)localObject, (MMActivity)this.CCa, (byte)0);
      if (this.EiQ == null)
      {
        paramc = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.live_title_ui_root);
        kotlin.g.b.s.s(paramc, "it.findViewById(R.id.live_title_ui_root)");
        this.EiQ = new cd((ViewGroup)paramc, (com.tencent.mm.live.b.b)localObject, this.reportObj);
        paramc = this.EiQ;
        if (paramc != null) {
          paramc.tO(4);
        }
      }
      if (this.Eki == null)
      {
        paramc = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.live_visitor_close_ui_root);
        kotlin.g.b.s.s(paramc, "it.findViewById(R.id.live_visitor_close_ui_root)");
        this.Eki = new cj((ViewGroup)paramc, (com.tencent.mm.live.b.b)localObject);
        paramc = this.Eki;
        if (paramc != null) {
          paramc.tO(8);
        }
      }
      if (this.Eks == null)
      {
        paramc = (ViewGroup)genRootViewByStub(p.e.BTB, (View)localObject);
        parambui = paramc.findViewById(p.e.CbT);
        kotlin.g.b.s.s(parambui, "orientationRoot.findView…id.video_orientation_btn)");
        parambui = (ImageView)parambui;
        View localView = paramc.findViewById(p.e.BTA);
        kotlin.g.b.s.s(localView, "orientationRoot.findView…e_video_orientation_root)");
        this.Eks = new cg(paramc, parambui, (ViewGroup)localView, (com.tencent.mm.live.b.b)localObject);
        paramc = this.Eks;
        if (paramc != null) {
          paramc.tO(8);
        }
      }
      if (this.Ekj == null)
      {
        paramc = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.BXh);
        kotlin.g.b.s.s(paramc, "it.findViewById(R.id.liv…itor_mini_window_ui_root)");
        this.Ekj = new cr((ViewGroup)paramc, (com.tencent.mm.live.b.b)localObject);
        paramc = this.Ekj;
        if (paramc != null) {
          paramc.tO(8);
        }
      }
      if (this.EiX == null)
      {
        paramc = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.BOR);
        kotlin.g.b.s.s(paramc, "it.findViewById(R.id.fin…live_more_action_ui_root)");
        this.EiX = new com.tencent.mm.plugin.finder.live.plugin.bg((ViewGroup)paramc, (com.tencent.mm.live.b.b)localObject, (MMActivity)this.CCa);
        paramc = this.EiX;
        if (paramc != null) {
          paramc.tO(8);
        }
      }
      if (this.EjC == null)
      {
        paramc = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.BKk);
        kotlin.g.b.s.s(paramc, "it.findViewById(R.id.finder_live_desc_edit_root)");
        this.EjC = new com.tencent.mm.plugin.finder.live.plugin.k((ViewGroup)paramc, (com.tencent.mm.live.b.b)localObject);
        paramc = this.EjC;
        if (paramc != null) {
          paramc.tO(8);
        }
      }
      if (this.EjD == null)
      {
        paramc = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.BKu);
        kotlin.g.b.s.s(paramc, "it.findViewById(R.id.fin…r_live_fast_comment_root)");
        this.EjD = new com.tencent.mm.plugin.finder.live.plugin.n((ViewGroup)paramc, (com.tencent.mm.live.b.b)localObject);
        paramc = this.EjD;
        if (paramc != null) {
          paramc.tO(8);
        }
      }
      if (this.DcS == null)
      {
        this.DcS = new com.tencent.mm.plugin.finder.live.plugin.ah((ViewGroup)genRootViewByStub(p.e.BJV, (View)localObject), (com.tencent.mm.live.b.b)localObject);
        paramc = this.DcS;
        if (paramc != null) {
          paramc.tO(8);
        }
        paramc = this.DcS;
        if (paramc != null) {
          paramc.EjI = ((LinearLayout)((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.BIc));
        }
      }
      if (this.akhj != null) {
        break label1105;
      }
      parambui = (ViewStub)((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.VIr);
      if (parambui == null) {
        break label1105;
      }
      paramc = (MMActivity)this.CCa;
      parambui = parambui.inflate();
      if (parambui != null) {
        break label1047;
      }
      paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(358719);
      throw paramc;
      label1021:
      paramc = parambui.amx();
      break;
      i = 0;
      break label114;
      paramc = parambui.getNickname();
      break label124;
    }
    label1047:
    this.akhj = new com.tencent.mm.plugin.finder.live.gala.b.b(paramc, (ViewGroup)parambui, (com.tencent.mm.live.b.b)localObject, (ViewGroup)localObject);
    paramc = this.akhj;
    if (paramc != null) {
      paramc.DcS = this.DcS;
    }
    paramc = this.akhj;
    if (paramc != null) {
      paramc.tO(8);
    }
    label1105:
    if (this.Ejt == null)
    {
      this.Ejt = new ab((ViewGroup)genRootViewByStub(p.e.BGL, (View)localObject), (com.tencent.mm.live.b.b)localObject);
      paramc = this.Ejt;
      if (paramc != null) {
        paramc.tO(4);
      }
    }
    parambui = this.EkN;
    paramc = parambui;
    if (parambui == null) {
      paramc = new com.tencent.mm.plugin.finder.live.plugin.ag((ViewGroup)genRootViewByStub(p.e.BJP, (View)localObject), (com.tencent.mm.live.b.b)localObject, (byte)0);
    }
    this.EkN = paramc;
    paramc = this.EkN;
    if (paramc != null) {
      paramc.tO(8);
    }
    parambui = this.EkK;
    paramc = parambui;
    if (parambui == null) {
      paramc = new cl((ViewGroup)new FrameLayout((Context)this.CCa), (com.tencent.mm.live.b.b)localObject);
    }
    this.EkK = paramc;
    parambui = this.EkJ;
    paramc = parambui;
    if (parambui == null)
    {
      paramc = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.BKt);
      kotlin.g.b.s.s(paramc, "it.findViewById(R.id.fin…r_live_fans_club_ui_root)");
      paramc = new cm((ViewGroup)paramc, (com.tencent.mm.live.b.b)localObject);
    }
    this.EkJ = paramc;
    label1310:
    paramc = com.tencent.mm.plugin.finder.live.util.ag.DJR;
    com.tencent.mm.plugin.finder.live.util.ag.ejv().gG("initStaticPlugins end");
    paramc = com.tencent.mm.plugin.finder.live.util.ag.DJR;
    com.tencent.mm.plugin.finder.live.util.ag.ejv().gG("onBindData end");
    AppMethodBeat.o(358719);
  }
  
  public final void aEB()
  {
    AppMethodBeat.i(358558);
    Object localObject1 = com.tencent.mm.plugin.finder.live.util.ag.DJR;
    com.tencent.mm.plugin.finder.live.util.ag.ejv().gF("LivingUIC onSelected start");
    localObject1 = com.tencent.mm.plugin.finder.live.util.ag.DJR;
    com.tencent.mm.plugin.finder.live.util.ag.ejv().gF("lazyInitPlugins start");
    com.tencent.mm.plugin.finder.live.view.router.c localc = this.CCg;
    if (localc != null)
    {
      localObject1 = localc.findViewById(p.e.live_loading_blur);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new b..ExternalSyntheticLambda1(this));
      }
      if (this.Ejh == null)
      {
        localObject1 = localc.findViewById(p.e.BEZ);
        kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…lowance_gift_bubble_root)");
        this.Ejh = new com.tencent.mm.plugin.finder.live.plugin.d((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localc);
        localObject1 = this.Ejh;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).tO(8);
        }
      }
      if (this.Eji == null)
      {
        localObject1 = localc.findViewById(p.e.BFa);
        kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…allowance_gift_card_root)");
        this.Eji = new com.tencent.mm.plugin.finder.live.plugin.e((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localc);
        localObject1 = this.Eji;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.e)localObject1).tO(8);
        }
      }
      if (this.Eku == null)
      {
        localObject1 = localc.findViewById(p.e.BFb);
        kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_allowance_gift_pag_root)");
        this.Eku = new com.tencent.mm.plugin.finder.live.plugin.f((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localc);
        localObject1 = this.Eku;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.f)localObject1).tO(8);
        }
      }
      if (this.EjY == null)
      {
        localObject1 = localc.findViewById(p.e.BLn);
        kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…welfare_task_bubble_root)");
        this.EjY = new at((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localc);
        localObject1 = this.EjY;
        if (localObject1 != null) {
          ((at)localObject1).tO(8);
        }
      }
      if (this.Ekl == null)
      {
        this.Ekl = new bv((ViewGroup)genRootViewByStub(p.e.BSf, (View)localc), (com.tencent.mm.live.b.b)localc);
        localObject1 = this.Ekl;
        if (localObject1 != null) {
          ((bv)localObject1).tO(8);
        }
      }
      localObject1 = new com.tencent.mm.plugin.finder.live.model.frameset.c();
      if (!((com.tencent.mm.plugin.finder.live.model.frameset.c)localObject1).baY)
      {
        Log.i(((com.tencent.mm.plugin.finder.live.model.frameset.c)localObject1).TAG, "initConfig");
        ((com.tencent.mm.plugin.finder.live.model.frameset.c)localObject1).baY = true;
      }
    }
    for (;;)
    {
      Object localObject5;
      Object localObject6;
      try
      {
        Object localObject2 = new com.tencent.mm.plugin.surface.core.g((Collection)kotlin.a.p.listOf(new com.tencent.mm.plugin.appbrand.jsapi.p[] { (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.d(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.co(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.b(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.a(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.c(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.f(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.aa.f(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.e(), ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).zk(764), ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).zk(865), ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).zk(968) }), (com.tencent.mm.plugin.surface.d.a)new c.a());
        localObject5 = com.tencent.mm.plugin.surface.b.SJM;
        com.tencent.mm.plugin.surface.b.a(((com.tencent.mm.plugin.finder.live.model.frameset.c)localObject1).appId, (com.tencent.mm.plugin.surface.core.g)localObject2);
        localObject2 = kotlin.ah.aiuX;
        if (this.Ekm == null)
        {
          localObject2 = localc.findViewById(p.e.BXe);
          kotlin.g.b.s.s(localObject2, "it.findViewById(R.id.live_tx_game_info_view)");
          this.Ekm = new com.tencent.mm.plugin.finder.live.plugin.ar((FinderLiveGameInfoView)localObject2, (com.tencent.mm.live.b.b)localc);
          localObject2 = this.Ekm;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.ar)localObject2).tO(8);
          }
          localObject2 = this.Ekm;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.ar)localObject2).CZh = ((com.tencent.mm.plugin.finder.live.model.frameset.c)localObject1);
          }
        }
        if (this.Ekn == null)
        {
          localObject2 = localc.findViewById(p.e.BKD);
          kotlin.g.b.s.s(localObject2, "it.findViewById(R.id.fin…ayer_frame_set_container)");
          this.Ekn = new com.tencent.mm.plugin.finder.live.plugin.ap((ViewGroup)localObject2, (com.tencent.mm.live.b.b)localc);
          localObject2 = this.Ekn;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.ap)localObject2).tO(8);
          }
          localObject2 = this.Ekn;
          if (localObject2 != null) {
            ((an)localObject2).CZh = ((com.tencent.mm.plugin.finder.live.model.frameset.c)localObject1);
          }
        }
        if (this.Eko == null)
        {
          localObject2 = localc.findViewById(p.e.BKC);
          kotlin.g.b.s.s(localObject2, "it.findViewById(R.id.fin…rate_frame_set_container)");
          this.Eko = new ao((ViewGroup)localObject2, (com.tencent.mm.live.b.b)localc);
          localObject2 = this.Eko;
          if (localObject2 != null) {
            ((ao)localObject2).tO(8);
          }
          localObject2 = this.Eko;
          if (localObject2 != null) {
            ((an)localObject2).CZh = ((com.tencent.mm.plugin.finder.live.model.frameset.c)localObject1);
          }
        }
        if (this.Ejq == null)
        {
          localObject1 = localc.findViewById(p.e.BNE);
          kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_lucky_money_ui_root)");
          this.Ejq = new bc((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localc);
          localObject1 = this.Ejq;
          if (localObject1 != null) {
            ((bc)localObject1).tO(8);
          }
        }
        this.EjI = ((LinearLayout)localc.findViewById(p.e.BIc));
        this.akhh = ((ConstraintLayout)localc.findViewById(p.e.VIs));
        if (this.Ejf == null)
        {
          this.Ejf = new ba((ViewGroup)genRootViewByStub(p.e.BNt, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.Ejf;
          if (localObject1 != null) {
            ((ba)localObject1).tO(8);
          }
        }
        if (this.EiR == null) {
          this.EiR = new com.tencent.mm.plugin.finder.live.plugin.aj((ViewGroup)genRootViewByStub(p.e.BWD, (View)localc), (com.tencent.mm.live.b.b)localc);
        }
        if (this.Ejb == null)
        {
          this.Ejb = new cf((ViewGroup)genRootViewByStub(p.e.BTs, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.Ejb;
          if (localObject1 != null) {
            ((cf)localObject1).tO(8);
          }
        }
        if (this.EjX == null)
        {
          this.EjX = new bl((ViewGroup)genRootViewByStub(p.e.BTR, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.EjX;
          if (localObject1 != null) {
            ((bl)localObject1).tO(4);
          }
        }
        if (this.Ejc == null)
        {
          this.Ejc = new com.tencent.mm.plugin.finder.live.plugin.o((ViewGroup)genRootViewByStub(p.e.BFq, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.Ejc;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.o)localObject1).tO(8);
          }
        }
        if (this.EiW == null)
        {
          this.EiW = new az((ViewGroup)genRootViewByStub(p.e.BWS, (View)localc), (com.tencent.mm.live.b.b)localc, localc.getConfettiBitmapManager());
          localObject1 = this.EiW;
          if (localObject1 != null) {
            ((az)localObject1).eqJ();
          }
        }
        if (this.Ekp == null)
        {
          this.Ekp = new ck((ViewGroup)genRootViewByStub(p.e.BTI, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.Ekp;
          if (localObject1 != null) {
            ((ck)localObject1).tO(8);
          }
        }
        if (this.Ejj == null)
        {
          this.Ejj = new com.tencent.mm.plugin.finder.live.plugin.av((ViewGroup)genRootViewByStub(p.e.BLR, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.Ejj;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.av)localObject1).tO(8);
          }
        }
        if (this.Ekv == null)
        {
          this.Ekv = new cp((ViewGroup)genRootViewByStub(p.e.BNc, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.Ekv;
          if (localObject1 != null) {
            ((cp)localObject1).tO(8);
          }
        }
        if (this.Ejo == null)
        {
          localObject1 = (ViewGroup)genRootViewByStub(p.e.BOy, (View)localc);
          localObject2 = (com.tencent.mm.live.b.b)localc;
          localObject5 = localc.findViewById(p.e.BSi);
          kotlin.g.b.s.s(localObject5, "it.findViewById(R.id.finder_live_shade_view)");
          this.Ejo = new com.tencent.mm.plugin.finder.live.plugin.bf((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject2, (FinderLiveShadeView)localObject5, this.reportObj);
          localObject1 = this.Ejo;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.bf)localObject1).tO(8);
          }
        }
        if (this.Ejr == null)
        {
          localObject1 = (ViewGroup)genRootViewByStub(p.e.BOr, (View)localc);
          localObject2 = (com.tencent.mm.live.b.b)localc;
          localObject5 = localc.findViewById(p.e.BSi);
          kotlin.g.b.s.s(localObject5, "it.findViewById(R.id.finder_live_shade_view)");
          this.Ejr = new be((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject2, (FinderLiveShadeView)localObject5, (byte)0);
          localObject1 = this.Ejr;
          if (localObject1 != null) {
            ((be)localObject1).tO(8);
          }
        }
        if (this.Eky == null)
        {
          this.Eky = new ci((ViewGroup)genRootViewByStub(p.e.BTH, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.Eky;
          if (localObject1 != null) {
            ((ci)localObject1).tO(8);
          }
        }
        if (this.Ekz == null)
        {
          localObject1 = this.Eky;
          kotlin.g.b.s.checkNotNull(localObject1);
          this.Ekz = new com.tencent.mm.plugin.finder.live.plugin.aq(((ci)localObject1).DlB.mJe, (ViewGroup)genRootViewByStub(p.e.BKE, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.Ekz;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject1).tO(8);
          }
        }
        if (this.EiY == null)
        {
          this.EiY = new bq((ViewGroup)genRootViewByStub(p.e.BRw, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.EiY;
          if (localObject1 != null) {
            ((bq)localObject1).tO(8);
          }
        }
        if (this.EkI == null)
        {
          this.EkI = new com.tencent.mm.plugin.finder.live.plugin.bn((ViewGroup)genRootViewByStub(p.e.BQp, (View)localc), (com.tencent.mm.live.b.b)localc, (byte)0);
          localObject1 = this.EkI;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.bn)localObject1).tO(8);
          }
        }
        if (this.EkL == null)
        {
          this.EkL = new cv((ViewGroup)genRootViewByStub(p.e.BKd, (View)localc), (com.tencent.mm.live.b.b)localc);
          localObject1 = this.EkL;
          if (localObject1 != null) {
            ((cv)localObject1).tO(8);
          }
        }
        localObject2 = this.EjW;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ca((ViewGroup)genRootViewByStub(p.e.BSS, (View)localc), (com.tencent.mm.live.b.b)localc, this.reportObj);
        }
        this.EjW = ((ca)localObject1);
        localObject1 = this.EjW;
        if (localObject1 != null) {
          ((ca)localObject1).tO(8);
        }
        localObject2 = this.EkA;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new bh((ViewGroup)genRootViewByStub(p.e.BOT, (View)localc), (com.tencent.mm.live.b.b)localc, this.reportObj);
        }
        this.EkA = ((bh)localObject1);
        localObject1 = this.EkA;
        if (localObject1 != null) {
          ((bh)localObject1).tO(8);
        }
        localObject2 = this.Ejk;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localc.findViewById(p.e.BMa);
          kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_live_gift_queue_ui_root)");
          localObject1 = (ViewGroup)localObject1;
          localObject2 = (com.tencent.mm.live.b.b)localc;
          localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecl;
          localObject6 = localc.findViewById(p.e.BLZ);
          kotlin.g.b.s.s(localObject6, "it.findViewById(R.id.fin…e_gift_queue_outer_space)");
          localObject1 = new com.tencent.mm.plugin.finder.live.plugin.aw((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject2, (com.tencent.mm.plugin.finder.live.util.s)localObject5, (ViewGroup)localObject6, true);
        }
        this.Ejk = ((com.tencent.mm.plugin.finder.live.plugin.aw)localObject1);
        localObject1 = this.Ejk;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aw)localObject1).tO(8);
        }
        localObject2 = this.Ekr;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localc.findViewById(p.e.BMb);
          kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.finder_live_gift_send_again)");
          localObject1 = new ax((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localc);
        }
        this.Ekr = ((ax)localObject1);
        localObject1 = this.Ekr;
        if (localObject1 != null) {
          ((ax)localObject1).tO(8);
        }
        if (this.EiZ == null)
        {
          localObject1 = (ViewGroup)localc;
          localObject2 = localc.findViewById(p.e.BRz);
          kotlin.g.b.s.s(localObject2, "it.findViewById(R.id.fin…promote_bubble_container)");
          this.EiZ = new br((ViewGroup)localObject1, (ViewGroup)localObject2, (com.tencent.mm.live.b.b)localc);
          localObject1 = this.EiZ;
          if (localObject1 != null) {
            ((br)localObject1).tO(8);
          }
        }
        localObject5 = this.CCg;
        if (localObject5 != null)
        {
          if (!(this.CCa instanceof MMActivity)) {
            Log.e(this.TAG, "initOlympicPlugin context is not !");
          }
        }
        else
        {
          localObject1 = this.CCg;
          if (localObject1 != null)
          {
            if ((this.CCa instanceof MMActivity)) {
              break label2706;
            }
            Log.e(this.TAG, "initOlympicPlugin context is not !");
          }
          if (this.EjG == null)
          {
            this.EjG = new ak((ViewGroup)genRootViewByStub(p.e.BKj, (View)localc), (com.tencent.mm.live.b.b)localc);
            localObject1 = this.EjG;
            if (localObject1 != null) {
              ((ak)localObject1).tO(8);
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.live.util.ag.DJR;
          com.tencent.mm.plugin.finder.live.util.ag.ejv().gG("lazyInitPlugins end");
          localObject1 = ezH();
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          localObject1 = ezI();
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          localObject1 = this.EiQ;
          if (localObject1 != null) {
            cd.a((cd)localObject1, null, false, 3);
          }
          localObject1 = this.Eki;
          if (localObject1 != null) {
            ((cj)localObject1).tO(0);
          }
          localObject1 = this.EiX;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.bg)localObject1).tO(0);
          }
          localObject1 = com.tencent.mm.plugin.finder.live.util.m.DJb;
          com.tencent.mm.plugin.finder.live.util.m.k(this.buContext);
          localObject1 = com.tencent.mm.plugin.finder.live.util.ag.DJR;
          com.tencent.mm.plugin.finder.live.util.ag.ejv().gG("LivingUIC onSelected end");
          AppMethodBeat.o(358558);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(358558);
      }
      Object localObject4;
      if (this.EkS == null)
      {
        localObject1 = (FrameLayout)this.CCa.findViewById(p.e.BKe);
        if (localObject1 == null)
        {
          com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "liveInitContentViewError", false, null, false, null, 60);
          Log.e(this.TAG, "initOlympicPlugin root is empty!");
        }
        localObject4 = (MMActivity)this.CCa;
        kotlin.g.b.s.s(localObject1, "root");
        this.EkS = new com.tencent.mm.plugin.finder.live.olympic.c((MMActivity)localObject4, (ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject5);
      }
      if (this.EkT == null)
      {
        localObject4 = (ViewStub)((com.tencent.mm.plugin.finder.live.view.router.c)localObject5).findViewById(p.e.BPX);
        if (localObject4 != null)
        {
          localObject1 = (MMActivity)this.CCa;
          localObject4 = ((ViewStub)localObject4).inflate();
          if (localObject4 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(358558);
            throw ((Throwable)localObject1);
          }
          this.EkT = new com.tencent.mm.plugin.finder.live.olympic.k((MMActivity)localObject1, (ViewGroup)localObject4, (com.tencent.mm.live.b.b)localObject5);
        }
      }
      if (this.EkU == null) {
        this.EkU = new com.tencent.mm.plugin.finder.live.olympic.l((ViewGroup)genRootViewByStub(p.e.BQs, (View)localObject5), (com.tencent.mm.live.b.b)localObject5, (MMActivity)this.CCa);
      }
      if (this.EkV == null) {
        this.EkV = new com.tencent.mm.plugin.finder.live.olympic.j((ViewGroup)genRootViewByStub(p.e.BQr, (View)localObject5), (com.tencent.mm.live.b.b)localObject5, (MMActivity)this.CCa);
      }
      if (this.EkX == null)
      {
        localObject4 = (ViewGroup)genRootViewByStub(p.e.BQu, (View)localObject5);
        localObject6 = (com.tencent.mm.live.b.b)localObject5;
        localObject1 = this.EjV;
        if (localObject1 != null) {
          break label2695;
        }
      }
      label2695:
      for (localObject1 = null;; localObject1 = ((cc)localObject1).Dkj.CSG)
      {
        this.EkX = new com.tencent.mm.plugin.finder.live.olympic.m((ViewGroup)localObject4, (com.tencent.mm.live.b.b)localObject6, (View)localObject1);
        localObject4 = this.EkW;
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject5).findViewById(p.e.BQt);
          kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…r_live_olympics_run_root)");
          localObject1 = new com.tencent.mm.plugin.finder.live.olympic.i((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject5);
        }
        this.EkW = ((com.tencent.mm.plugin.finder.live.olympic.i)localObject1);
        break;
      }
      label2706:
      if (this.akhg == null) {
        this.akhg = new cz((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject1, (MMActivity)this.CCa, (byte)0);
      }
      if (this.akhk == null) {
        this.akhk = new com.tencent.mm.plugin.finder.live.gala.b.a((MMActivity)this.CCa, (ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject1);
      }
    }
  }
  
  public final void as(Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(358852);
    if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 524288))
    {
      localObject2 = this.CCg;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.c)localObject2).forceScreenToPortrait();
      }
      ezO();
    }
    Object localObject2 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    localObject2 = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.finder.live.model.ap)localObject2).ekl();
    }
    localObject2 = this.EiQ;
    if (localObject2 != null) {
      cd.a((cd)localObject2, null, false, 3);
    }
    localObject2 = this.CCg;
    int i;
    label319:
    Object localObject4;
    label495:
    Object localObject5;
    if ((localObject2 != null) && (!((com.tencent.mm.plugin.finder.live.view.router.c)localObject2).getAudienPreloadCDNLiveConfig()))
    {
      i = 1;
      if (i != 0)
      {
        localObject2 = this.EiQ;
        if (localObject2 != null) {
          ((cd)localObject2).tO(0);
        }
      }
      localObject2 = this.DcS;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject2).tO(0);
      }
      localObject2 = this.EiR;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject2).tO(0);
      }
      localObject2 = this.Ekh;
      if (localObject2 != null) {
        ((bx)localObject2).tO(0);
      }
      localObject2 = this.EjX;
      if (localObject2 != null) {
        ((bl)localObject2).tO(0);
      }
      localObject2 = this.Eki;
      if (localObject2 != null) {
        ((cj)localObject2).tO(0);
      }
      localObject2 = this.Ekj;
      if (localObject2 != null) {
        ((cr)localObject2).tO(0);
      }
      localObject2 = this.EiW;
      if (localObject2 != null) {
        ((az)localObject2).tO(0);
      }
      localObject2 = this.EiX;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.bg)localObject2).tO(0);
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eie == null) {
        break label1109;
      }
      localObject2 = this.EiZ;
      if (localObject2 != null) {
        ((br)localObject2).tO(0);
      }
      localObject2 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      com.tencent.mm.plugin.finder.live.report.k.etr();
      localObject2 = this.Ekl;
      if (localObject2 != null) {
        ((bv)localObject2).tO(0);
      }
      localObject2 = this.Ekm;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ar)localObject2).eoD();
      }
      localObject2 = this.Ekn;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ap)localObject2).eoD();
      }
      localObject2 = this.Eko;
      if (localObject2 != null) {
        ((ao)localObject2).eoD();
      }
      localObject2 = this.Eky;
      if (localObject2 != null)
      {
        localObject4 = ci.Dlv;
        ((ci)localObject2).Pe(ci.esG());
      }
      localObject2 = this.Eky;
      if (localObject2 != null) {
        ci.a((ci)localObject2);
      }
      localObject2 = this.EiY;
      if (localObject2 != null) {
        ((bq)localObject2).eoD();
      }
      localObject2 = this.EkA;
      if (localObject2 != null) {
        ((bh)localObject2).erq();
      }
      localObject2 = this.Ekz;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject2).tO(0);
      }
      localObject2 = this.EiY;
      if ((localObject2 == null) || (((bq)localObject2).erx() != true)) {
        break label1130;
      }
      i = 1;
      if (i != 0)
      {
        localObject2 = this.EiY;
        if (localObject2 != null) {
          ((bq)localObject2).tO(0);
        }
      }
      localObject2 = this.CCg;
      if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.live.view.router.c)localObject2).isLandscape() != true)) {
        break label1135;
      }
      i = 1;
      label538:
      if (i == 0) {
        break label1140;
      }
      localObject2 = this.EiQ;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.live.b.a)localObject2).mJe;
        if (localObject2 != null) {
          ((ViewGroup)localObject2).post(new b..ExternalSyntheticLambda14(this));
        }
      }
      label579:
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfK == null) {
        break label1180;
      }
      localObject2 = this.EjA;
      if (localObject2 != null) {
        ((ac)localObject2).tO(0);
      }
      label612:
      localObject2 = this.Ejf;
      if (localObject2 != null) {
        ((ba)localObject2).eqN();
      }
      localObject2 = this.CCg;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.c)localObject2).enableRotation();
      }
      localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcV.event;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcV.bundle;
      localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcV.Ebp;
      if (localObject5 != null)
      {
        Log.i(this.TAG, kotlin.g.b.s.X("parseInjectEvent injectEvent:", localObject5));
        if (!kotlin.g.b.s.p(localObject5, "EVENT_POST_PORTRAIT_ACTION")) {
          break label1201;
        }
        localObject5 = this.CCg;
        if (localObject5 != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.c)localObject5).onPortraitAction(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcT, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, (Bundle)localObject2, localObject4);
        }
        label775:
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcV.event = null;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcV.bundle = null;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcV.Ebp = null;
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyM())
      {
        localObject2 = this.EkL;
        if (localObject2 != null)
        {
          localObject4 = cv.DmJ;
          ((cv)localObject2).bv(cv.esX(), this.CCa.getResources().getString(p.h.CtQ));
        }
      }
      if (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 128)) {
        break label1269;
      }
      paramBundle = this.CCg;
      if (paramBundle != null) {
        paramBundle.forceScreenToPortrait();
      }
      paramBundle = com.tencent.mm.plugin.finder.live.model.al.CHU;
      com.tencent.mm.plugin.finder.live.model.al.eme();
      paramBundle = this.CCg;
      if (paramBundle != null) {
        com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)paramBundle, false, 1, null);
      }
      eqj();
      emg();
      paramBundle = this.Ekp;
      if (paramBundle != null) {
        paramBundle.tO(0);
      }
      paramBundle = this.Ekp;
      if (paramBundle != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
        kotlin.g.b.s.u(localObject2, "anchorUserName");
        Log.i(paramBundle.TAG, kotlin.g.b.s.X("showKickedMemberTip anchorUserName:", localObject2));
        paramBundle.awP((String)localObject2);
        localObject2 = paramBundle.CUG;
        if (localObject2 != null)
        {
          localObject3 = w.EoA;
          w.a((w)localObject2, w.eAE(), null, (kotlin.g.a.b)new ck.a(paramBundle), 6);
        }
      }
      localObject2 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localObject3 = (Context)this.CCa;
      localObject4 = q.bw.DDA;
      paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      paramBundle = com.tencent.mm.plugin.finder.live.model.aj.egD();
      if (paramBundle != null) {
        break label1261;
      }
    }
    label1109:
    label1130:
    label1261:
    for (paramBundle = (Bundle)localObject1;; paramBundle = paramBundle.CFn)
    {
      ((com.tencent.mm.plugin.finder.live.report.k)localObject2).a((Context)localObject3, (q.bw)localObject4, paramBundle);
      AppMethodBeat.o(358852);
      return;
      i = 0;
      break;
      localObject2 = this.EiZ;
      if (localObject2 == null) {
        break label319;
      }
      ((br)localObject2).tO(8);
      break label319;
      i = 0;
      break label495;
      label1135:
      i = 0;
      break label538;
      label1140:
      localObject2 = this.EiR;
      if (localObject2 == null) {
        break label579;
      }
      localObject2 = ((com.tencent.mm.live.b.a)localObject2).mJe;
      if (localObject2 == null) {
        break label579;
      }
      ((ViewGroup)localObject2).post(new b..ExternalSyntheticLambda12(this));
      break label579;
      localObject2 = this.EjA;
      if (localObject2 == null) {
        break label612;
      }
      ((ac)localObject2).tO(8);
      break label612;
      if (!kotlin.g.b.s.p(localObject5, "EVENT_POST_LANDSCAPE_ACTION")) {
        break label775;
      }
      localObject5 = this.CCg;
      if (localObject5 == null) {
        break label775;
      }
      ((com.tencent.mm.plugin.finder.live.view.router.c)localObject5).onLandscapeAction(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcT, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, (Bundle)localObject2, localObject4);
      break label775;
    }
    label1180:
    label1201:
    label1269:
    if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 256))
    {
      paramBundle = this.CCg;
      if (paramBundle != null) {
        paramBundle.forceScreenToPortrait();
      }
      paramBundle = com.tencent.mm.plugin.finder.live.model.al.CHU;
      com.tencent.mm.plugin.finder.live.model.al.eme();
      paramBundle = this.CCg;
      if (paramBundle != null) {
        com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)paramBundle, false, 1, null);
      }
      eqj();
      paramBundle = this.Ekp;
      if (paramBundle != null) {
        paramBundle.bkp(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      }
      paramBundle = this.Ekp;
      if (paramBundle != null) {
        paramBundle.tO(0);
      }
      emg();
      AppMethodBeat.o(358852);
      return;
    }
    if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 1048576))
    {
      paramBundle = this.CCg;
      if (paramBundle != null) {
        paramBundle.forceScreenToPortrait();
      }
      paramBundle = com.tencent.mm.plugin.finder.live.model.al.CHU;
      com.tencent.mm.plugin.finder.live.model.al.eme();
      paramBundle = this.CCg;
      if (paramBundle != null) {
        com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)paramBundle, false, 1, null);
      }
      eqj();
      paramBundle = this.Ekp;
      if (paramBundle != null) {
        paramBundle.bkp(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      }
      paramBundle = this.Ekp;
      if (paramBundle != null) {
        paramBundle.tO(0);
      }
      emg();
      AppMethodBeat.o(358852);
      return;
    }
    if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 32))
    {
      paramBundle = this.CCg;
      if (paramBundle != null) {
        paramBundle.forceScreenToPortrait();
      }
      ezP();
      paramBundle = this.CCg;
      if (paramBundle != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
        localObject2 = this.CCa.getResources().getString(p.h.Cib);
        kotlin.g.b.s.s(localObject2, "context.resources.getStr…er_live_anchor_exception)");
        paramBundle.showBlurBgWithTimeCount((String)localObject1, (String)localObject2);
        AppMethodBeat.o(358852);
      }
    }
    else if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 64))
    {
      if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.isEmpty()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv == null))
      {
        paramBundle = this.CCg;
        if (paramBundle != null) {
          paramBundle.forceScreenToPortrait();
        }
        ezP();
        paramBundle = this.CCg;
        if (paramBundle != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
          localObject2 = this.CCa.getResources().getString(p.h.Cib);
          kotlin.g.b.s.s(localObject2, "context.resources.getStr…er_live_anchor_exception)");
          paramBundle.showBlurBgWithTimeCount((String)localObject1, (String)localObject2);
          AppMethodBeat.o(358852);
        }
      }
    }
    else
    {
      if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 262144))
      {
        if (paramBundle == null) {}
        for (i = j; (i == 2) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.isEmpty()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv == null); i = paramBundle.getInt("PARAM_LIVE_ANCHOR_STATUS_EXCEPTION_SECNE"))
        {
          paramBundle = this.CCg;
          if (paramBundle != null) {
            paramBundle.forceScreenToPortrait();
          }
          ezP();
          paramBundle = this.CCg;
          if (paramBundle == null) {
            break;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
          localObject2 = this.CCa.getResources().getString(p.h.Cib);
          kotlin.g.b.s.s(localObject2, "context.resources.getStr…er_live_anchor_exception)");
          paramBundle.showBlurBgWithTimeCount((String)localObject1, (String)localObject2);
          AppMethodBeat.o(358852);
          return;
        }
      }
      if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 512))
      {
        paramBundle = this.CCg;
        if (paramBundle != null)
        {
          paramBundle.showProgress();
          AppMethodBeat.o(358852);
        }
      }
      else if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 32768))
      {
        paramBundle = ezE();
        if (paramBundle != null) {
          paramBundle.tO(0);
        }
        paramBundle = ezE();
        if (paramBundle != null)
        {
          paramBundle.esL();
          AppMethodBeat.o(358852);
        }
      }
      else
      {
        if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 4096))
        {
          if (paramBundle == null) {
            paramBundle = "";
          }
          while (Util.isNullOrNil(paramBundle))
          {
            AppMethodBeat.o(358852);
            return;
            localObject1 = paramBundle.getString("PARAM_FINDER_LIVE_URL");
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null) {
              paramBundle = "";
            }
          }
          localObject1 = this.CCg;
          if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).isLandscape() == true)) {}
          for (i = 1; i != 0; i = 0)
          {
            localObject1 = this.CCg;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).forceScreenToPortrait();
            }
            localObject1 = this.CCg;
            if (localObject1 == null) {
              break label2351;
            }
            ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).post(new b..ExternalSyntheticLambda23(this, paramBundle));
            AppMethodBeat.o(358852);
            return;
          }
          ayy(paramBundle);
          AppMethodBeat.o(358852);
          return;
        }
        if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 65536))
        {
          com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.cc.DEr, "", 0);
          if (paramBundle == null)
          {
            localObject1 = null;
            if (paramBundle != null) {
              break label2315;
            }
            localObject2 = null;
            label2205:
            if (paramBundle != null) {
              break label2327;
            }
          }
          label2315:
          label2327:
          for (paramBundle = (Bundle)localObject3;; paramBundle = paramBundle.getString("PARAM_FINDER_LIVE_LINK_AVATAR"))
          {
            Log.i(this.TAG, "UI_STATE_GIFT targetUsername:" + localObject1 + " targetNickname:" + localObject2 + " targetAvatar:" + paramBundle);
            if (Util.isNullOrNil((String)localObject1)) {
              break label2338;
            }
            paramBundle = new au.b((String)localObject1, (String)localObject2, paramBundle);
            localObject1 = this.Ekq;
            if (localObject1 == null) {
              break label2351;
            }
            ((au)localObject1).a(paramBundle);
            AppMethodBeat.o(358852);
            return;
            localObject1 = paramBundle.getString("PARAM_FINDER_LIVE_LINK_USERNAME");
            break;
            localObject2 = paramBundle.getString("PARAM_FINDER_LIVE_LINK_NICKNAME");
            break label2205;
          }
          label2338:
          paramBundle = this.Ekq;
          if (paramBundle != null) {
            au.a(paramBundle);
          }
        }
      }
    }
    label2351:
    AppMethodBeat.o(358852);
  }
  
  public final com.tencent.mm.live.core.core.model.g b(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(358621);
    com.tencent.mm.live.core.core.model.g localg = new com.tencent.mm.live.core.core.model.g("", paramLong, 0, null, 0L, 0L, null, 0, null, 0L, null, null, 131068);
    ((Map)localg.mNt).put(Integer.valueOf(0), new com.tencent.mm.live.core.core.model.j(paramString, 0, ""));
    localg.mNn = paramInt;
    paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localg.setNickName(paramString);
      c(localg);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).b(new com.tencent.mm.live.core.core.model.h(new TRTCCloudDef.TRTCParams(), localg, new com.tencent.mm.live.core.core.model.d("com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI")));
      AppMethodBeat.o(358621);
      return localg;
      String str = paramString.nickname;
      paramString = str;
      if (str == null) {
        paramString = "";
      }
    }
  }
  
  public final com.tencent.mm.live.core.core.model.i bch()
  {
    AppMethodBeat.i(358974);
    Object localObject = getLiveCore();
    if (localObject == null)
    {
      AppMethodBeat.o(358974);
      return null;
    }
    localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
    AppMethodBeat.o(358974);
    return localObject;
  }
  
  public final boolean bfD()
  {
    AppMethodBeat.i(358986);
    com.tencent.mm.live.core.core.f.d locald = getLiveCore();
    if (locald == null)
    {
      AppMethodBeat.o(358986);
      return false;
    }
    boolean bool = locald.bfD();
    AppMethodBeat.o(358986);
    return bool;
  }
  
  public final void callback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(358634);
    onLiveEventCallback(paramInt, paramBundle);
    AppMethodBeat.o(358634);
  }
  
  public final void checkMiniWindow()
  {
    AppMethodBeat.i(359011);
    String str = this.TAG;
    Object localObject = this.CCg;
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, kotlin.g.b.s.X("checkMiniWindow:", localObject));
      localObject = this.CCg;
      if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.view.router.c)localObject).getCheckMiniWin())) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ezw();
        this.nmZ.stopTimer();
      }
      AppMethodBeat.o(359011);
      return;
      localObject = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.view.router.c)localObject).getCheckMiniWin());
      break;
    }
  }
  
  public final void d(int paramInt1, int paramInt2, com.tencent.mm.am.p paramp)
  {
    Object localObject2 = null;
    AppMethodBeat.i(358934);
    Object localObject1;
    if (paramp == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label45;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(358934);
        return;
        localObject1 = Integer.valueOf(paramp.getType());
        break;
        label45:
        if (((Integer)localObject1).intValue() == 3736)
        {
          if (!(paramp instanceof com.tencent.mm.plugin.api.a)) {
            break label484;
          }
          localObject1 = ((com.tencent.mm.plugin.api.a)paramp).caK();
          if ((!((com.tencent.mm.plugin.api.a)paramp).caL()) || (localObject1 == null) || (!kotlin.g.b.s.p(((com.tencent.mm.plugin.api.a)paramp).caM(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC))) {
            break label484;
          }
          cd localcd = this.EiQ;
          if (localcd != null)
          {
            localObject2 = ((FinderContact)localObject1).username;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localcd.bA((String)localObject1, true);
          }
          localObject1 = com.tencent.mm.plugin.finder.live.util.m.DJb;
          com.tencent.mm.plugin.finder.live.util.m.k(this.buContext);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).friendFollowCount = ((com.tencent.mm.plugin.api.a)paramp).caN();
          AppMethodBeat.o(358934);
          return;
        }
      }
    }
    if ((((Integer)localObject1).intValue() == 3867) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramp = paramp.getReqResp();
      if ((paramp instanceof com.tencent.mm.am.c))
      {
        paramp = (com.tencent.mm.am.c)paramp;
        if (paramp != null) {
          break label421;
        }
        paramp = null;
        label242:
        if (!(paramp instanceof axq)) {
          break label432;
        }
        paramp = (axq)paramp;
        label254:
        if (paramp == null) {
          break label484;
        }
        paramp = paramp.contact;
        if (paramp != null) {
          break label437;
        }
      }
      boolean bool;
      label421:
      label432:
      label437:
      for (paramp = (com.tencent.mm.am.p)localObject2;; paramp = paramp.username)
      {
        Log.i(this.TAG, kotlin.g.b.s.X("MMFunc_FinderFollow,anchorUsername:", paramp));
        if (!kotlin.g.b.s.p(paramp, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC)) {
          break label484;
        }
        bool = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Ss(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
        paramp = this.CCg;
        if (paramp == null) {
          break label484;
        }
        paramp = paramp.getPlugins();
        if (paramp == null) {
          break label484;
        }
        localObject1 = (Iterable)paramp;
        paramp = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((localObject2 instanceof com.tencent.mm.plugin.finder.live.plugin.b)) {
            paramp.add(localObject2);
          }
        }
        paramp = null;
        break;
        paramp = c.c.b(paramp.otC);
        break label242;
        paramp = null;
        break label254;
      }
      paramp = ((Iterable)paramp).iterator();
      while (paramp.hasNext()) {
        ((com.tencent.mm.plugin.finder.live.plugin.b)paramp.next()).qX(bool);
      }
    }
    label484:
    AppMethodBeat.o(358934);
  }
  
  public final void d(kotlin.r<Integer, Integer> paramr)
  {
    int i = 1;
    AppMethodBeat.i(358629);
    Object localObject = getLiveCore();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).isFloatMode() != true)) {}
    }
    while (i != 0)
    {
      Log.i(this.TAG, "skip adjustLayout, now is floatMode");
      AppMethodBeat.o(358629);
      return;
      i = 0;
    }
    i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
    localObject = e.b.mKf;
    if (i == e.b.bct())
    {
      f(paramr);
      AppMethodBeat.o(358629);
      return;
    }
    i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
    localObject = e.b.mKf;
    if (i == e.b.bcu())
    {
      e(paramr);
      AppMethodBeat.o(358629);
      return;
    }
    Log.i(this.TAG, kotlin.g.b.s.X("invalid audience mode:", Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu())));
    AppMethodBeat.o(358629);
  }
  
  public final void ehA()
  {
    AppMethodBeat.i(359018);
    Object localObject = this.CCg;
    if ((localObject != null) && (!((com.tencent.mm.plugin.finder.live.view.router.c)localObject).getAudienPreloadCDNLiveConfig())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        localObject = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.model.ap)localObject).aws(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
        }
      }
      localObject = this.CCg;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).post(new b..ExternalSyntheticLambda16(this));
      }
      AppMethodBeat.o(359018);
      return;
    }
  }
  
  public final boolean enm()
  {
    AppMethodBeat.i(358961);
    com.tencent.mm.plugin.finder.live.view.router.c localc = this.CCg;
    if (localc != null)
    {
      boolean bool = com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 2048);
      Log.i(this.TAG, "preOpenMiniWindow, isManualClosed: " + localc.isManualClosed() + " isLiveStarted: " + localc.isLiveStarted() + " isLiveFinished: " + localc.isLiveFinished() + " isNormalMode: " + bep() + " needMiniWindow: " + localc.needMiniWindow() + " windowPermission: " + com.tencent.mm.compatible.e.b.dh((Context)this.CCa) + " opMiniWindowPermission: " + bool);
      if ((!localc.isManualClosed()) && (localc.isLiveStarted()) && (!localc.isLiveFinished()) && (bep()) && (localc.needMiniWindow()) && (!bool))
      {
        AppMethodBeat.o(358961);
        return true;
      }
    }
    AppMethodBeat.o(358961);
    return false;
  }
  
  public final com.tencent.mm.live.core.mini.b enn()
  {
    AppMethodBeat.i(358969);
    Object localObject = this.CCg;
    if (localObject == null)
    {
      AppMethodBeat.o(358969);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).getLiveCore();
    if (localObject == null)
    {
      AppMethodBeat.o(358969);
      return null;
    }
    localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRq;
    AppMethodBeat.o(358969);
    return localObject;
  }
  
  public final void eno()
  {
    AppMethodBeat.i(358980);
    if (com.tencent.mm.compatible.e.b.dh((Context)this.CCa)) {
      this.EkQ = true;
    }
    AppMethodBeat.o(358980);
  }
  
  public final Point enp()
  {
    Point localPoint = null;
    AppMethodBeat.i(358992);
    Object localObject = this.CCg;
    if (localObject == null) {}
    while (localPoint == null)
    {
      localPoint = new Point();
      AppMethodBeat.o(358992);
      return localPoint;
      localObject = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).getLiveCore();
      if (localObject != null) {
        localPoint = ((com.tencent.mm.live.core.core.f.d)localObject).dB((Context)this.CCa);
      }
    }
    AppMethodBeat.o(358992);
    return localPoint;
  }
  
  public final void eqj()
  {
    AppMethodBeat.i(358675);
    Object localObject = this.Ekf;
    if (localObject != null) {
      ((ct)localObject).tO(8);
    }
    localObject = this.Ekh;
    if (localObject != null) {
      ((bx)localObject).tO(8);
    }
    localObject = this.EiQ;
    if (localObject != null) {
      ((cd)localObject).tO(4);
    }
    localObject = this.EiR;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject).tO(8);
    }
    localObject = this.DcS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject).tO(8);
    }
    localObject = this.Ejb;
    if (localObject != null) {
      ((cf)localObject).tO(8);
    }
    localObject = this.EjX;
    if (localObject != null) {
      ((bl)localObject).tO(8);
    }
    localObject = this.Eki;
    if (localObject != null) {
      ((cj)localObject).tO(8);
    }
    localObject = this.Ekj;
    if (localObject != null) {
      ((cr)localObject).tO(8);
    }
    localObject = this.EiW;
    if (localObject != null) {
      ((az)localObject).tO(8);
    }
    localObject = this.EiX;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.bg)localObject).tO(8);
    }
    localObject = this.EjC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.k)localObject).tO(8);
    }
    localObject = this.EjD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.n)localObject).tO(8);
    }
    localObject = this.Ekl;
    if (localObject != null) {
      ((bv)localObject).tO(8);
    }
    localObject = this.Ekm;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.ar)localObject).tO(8);
    }
    localObject = this.Ekn;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.ap)localObject).tO(8);
    }
    localObject = this.Ekn;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.ap)localObject).eqj();
    }
    localObject = this.Eko;
    if (localObject != null) {
      ((ao)localObject).tO(8);
    }
    localObject = this.Eko;
    if (localObject != null) {
      ((ao)localObject).eqj();
    }
    localObject = this.Ekp;
    if (localObject != null) {
      ((ck)localObject).tO(8);
    }
    localObject = this.Eks;
    if (localObject != null) {
      ((cg)localObject).tO(8);
    }
    localObject = this.Ejf;
    if (localObject != null) {
      ((ba)localObject).tO(8);
    }
    localObject = this.Ekt;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.bb)localObject).tO(8);
    }
    localObject = this.Ejh;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.d)localObject).tO(8);
    }
    localObject = this.Eji;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.e)localObject).tO(8);
    }
    localObject = this.Eku;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.f)localObject).tO(8);
    }
    localObject = this.EjY;
    if (localObject != null) {
      ((at)localObject).tO(8);
    }
    localObject = this.Ekv;
    if (localObject != null) {
      ((cp)localObject).tO(8);
    }
    localObject = this.Ejo;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.bf)localObject).tO(8);
    }
    localObject = this.Ejr;
    if (localObject != null) {
      ((be)localObject).tO(8);
    }
    localObject = this.Ejt;
    if (localObject != null) {
      ((ab)localObject).tO(4);
    }
    if (this.Ekw)
    {
      localObject = ezE();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.co)localObject).tO(8);
      }
    }
    localObject = this.Ejj;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.av)localObject).tO(8);
    }
    localObject = this.Eky;
    if (localObject != null) {
      ((ci)localObject).tO(8);
    }
    localObject = this.EiZ;
    if (localObject != null) {
      ((br)localObject).tO(8);
    }
    localObject = this.Ekz;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.aq)localObject).tO(8);
    }
    localObject = this.EiY;
    if (localObject != null) {
      ((bq)localObject).tO(8);
    }
    localObject = this.EiU;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.bd)localObject).tO(8);
    }
    localObject = this.EkA;
    if (localObject != null) {
      ((bh)localObject).tO(8);
    }
    localObject = this.Ejq;
    if (localObject != null) {
      ((bc)localObject).tO(8);
    }
    if (this.EkB)
    {
      localObject = ezF();
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ae)localObject).tO(8);
      }
    }
    localObject = this.EkD;
    if (localObject != null) {
      ((af)localObject).tO(8);
    }
    if (this.EkE)
    {
      localObject = ezG();
      if (localObject != null) {
        ((cs)localObject).tO(8);
      }
    }
    localObject = this.EjW;
    if (localObject != null) {
      ((ca)localObject).tO(8);
    }
    localObject = this.EjA;
    if (localObject != null) {
      ((ac)localObject).tO(8);
    }
    localObject = this.EkH;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.al)localObject).tO(8);
    }
    localObject = this.EkI;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.bn)localObject).tO(8);
    }
    localObject = this.EiV;
    if (localObject != null) {
      ((bk)localObject).tO(8);
    }
    localObject = this.EjG;
    if (localObject != null) {
      ((ak)localObject).tO(8);
    }
    AppMethodBeat.o(358675);
  }
  
  public final void ezC()
  {
    AppMethodBeat.i(358643);
    Log.i(this.TAG, "onAcceptLinkMicOthers curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + " curLiveUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw + " audienceMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu());
    business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
    ci localci = this.Eky;
    if (localci != null) {
      localci.eoT();
    }
    AppMethodBeat.o(358643);
  }
  
  public final View ezH()
  {
    AppMethodBeat.i(358500);
    View localView = (View)this.EkY.getValue();
    AppMethodBeat.o(358500);
    return localView;
  }
  
  public final View ezI()
  {
    AppMethodBeat.i(358508);
    View localView = (View)this.EkZ.getValue();
    AppMethodBeat.o(358508);
    return localView;
  }
  
  public final void ezK()
  {
    boolean bool = true;
    AppMethodBeat.i(358592);
    Object localObject;
    com.tencent.mm.plugin.finder.live.plugin.ag localag;
    int i;
    label205:
    int j;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eyj())
    {
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jUR().bmg()).intValue() == 1) {
        this.CCa.getWindow().setFlags(8192, 8192);
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eyk())
      {
        localObject = this.CCg;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).applyLiveScene(0);
        }
        localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        localObject = com.tencent.mm.plugin.finder.live.model.aj.elA();
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.replay.a)localObject).release();
          AppMethodBeat.o(358592);
        }
      }
      else
      {
        localObject = this.CCg;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).applyLiveScene(1);
        }
        localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        com.tencent.mm.plugin.finder.live.model.aj.og(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
        localag = this.EkN;
        if (localag != null)
        {
          localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
          localObject = com.tencent.mm.plugin.finder.live.model.aj.elA();
          if (localObject != null) {
            break label245;
          }
          localObject = null;
          if (localObject != null) {
            break label258;
          }
          localObject = com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.Eci;
          i = com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.eyn();
          localObject = this.CCg;
          if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isLandscape() != true)) {
            break label267;
          }
          j = 1;
          label227:
          if (j != 0) {
            break label272;
          }
        }
      }
    }
    for (;;)
    {
      localag.aC(i, bool);
      AppMethodBeat.o(358592);
      return;
      label245:
      localObject = Integer.valueOf(((com.tencent.mm.plugin.finder.replay.a)localObject).FjF);
      break;
      label258:
      i = ((Integer)localObject).intValue();
      break label205;
      label267:
      j = 0;
      break label227;
      label272:
      bool = false;
    }
  }
  
  public final void ezM()
  {
    AppMethodBeat.i(358601);
    Object localObject = this.CCg;
    if (localObject != null)
    {
      View localView = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.BTT);
      localView.setAlpha(0.0F);
      localView.post(new b..ExternalSyntheticLambda10(localView));
      localObject = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).findViewById(p.e.BTF);
      ((View)localObject).setAlpha(0.0F);
      ((View)localObject).post(new b..ExternalSyntheticLambda9((View)localObject));
      localObject = this.Ekh;
      if (localObject != null) {
        ((bx)localObject).erT();
      }
    }
    AppMethodBeat.o(358601);
  }
  
  public final void ezN()
  {
    AppMethodBeat.i(358658);
    String str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF();
    final String str2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efs;
    Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    localObject = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
    if (localObject != null)
    {
      l.k localk = l.k.mYO;
      ((com.tencent.mm.plugin.finder.live.model.ap)localObject).a(l.k.bhH(), str1, str2, (g.a)new ah(this, str2));
    }
    AppMethodBeat.o(358658);
  }
  
  public final void ezO()
  {
    AppMethodBeat.i(358689);
    com.tencent.mm.plugin.finder.live.view.router.c localc;
    String str1;
    Object localObject;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet)
    {
      localc = this.CCg;
      if (localc != null)
      {
        str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
        localObject = this.CCa.getResources().getString(p.h.Cqq);
        kotlin.g.b.s.s(localObject, "context.resources.getStr…live_pause_mini_game_tip)");
      }
    }
    for (;;)
    {
      localc.showBlurBgWithTimeCount(str1, (String)localObject);
      do
      {
        AppMethodBeat.o(358689);
        return;
        localc = this.CCg;
      } while (localc == null);
      str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
      String str2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eer;
      localObject = str2;
      if (str2 == null)
      {
        localObject = this.CCa.getResources().getString(p.h.Cib);
        kotlin.g.b.s.s(localObject, "context.resources.getStr…er_live_anchor_exception)");
      }
    }
  }
  
  public final void ezQ()
  {
    AppMethodBeat.i(358943);
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
    kotlin.g.b.s.s(localObject, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    Iterator localIterator = ((Iterable)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF()));
    for (;;)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject;
      Log.i(this.TAG, "startLiveVideo,float mode:" + isFloatMode() + ", normal mode:" + bep() + ", selfMicUser:" + localObject + " liveData.business(LiveCommonSlice::class.java).audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw);
      if ((bep()) && (localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject).mXM == 2))
      {
        localObject = this.Ekf;
        if (localObject != null) {
          ((ct)localObject).aPz();
        }
        localObject = this.Ekf;
        if (localObject != null) {
          ((ct)localObject).bha();
        }
      }
      AppMethodBeat.o(358943);
      return;
      localObject = null;
    }
  }
  
  public final void ezR()
  {
    AppMethodBeat.i(359044);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ad(this));
    AppMethodBeat.o(359044);
  }
  
  public final void ezt()
  {
    AppMethodBeat.i(358578);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.euD())
    {
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.model.ap)localObject1).ekn();
      }
    }
    localObject1 = this.CCg;
    if (localObject1 != null) {
      com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)localObject1, false, 1, null);
    }
    localObject1 = this.EjX;
    if (localObject1 != null) {
      ((bl)localObject1).epR();
    }
    a(this, true, false, 2);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted()) {
      d(null);
    }
    Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eie;
    if ((localObject1 instanceof com.tencent.mm.plugin.j))
    {
      localObject1 = (com.tencent.mm.plugin.j)localObject1;
      if (localObject1 != null) {
        break label334;
      }
    }
    label334:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.j)localObject1).bUz())
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject2).Eif = l;
      localObject1 = this.CCg;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.a(this.buContext, (com.tencent.mm.live.b.b)localObject1);
      }
      localObject1 = this.Ekf;
      if (localObject1 != null)
      {
        localObject1 = (View)((ct)localObject1).mRt.getRenderLayout();
        if (localObject1 != null) {
          ((View)localObject1).post(new b..ExternalSyntheticLambda15(this));
        }
      }
      localObject1 = this.EjA;
      if (localObject1 != null) {
        ((ac)localObject1).epJ();
      }
      localObject1 = this.Eks;
      if (localObject1 != null) {
        ((cg)localObject1).rK(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC());
      }
      localObject1 = this.CCg;
      if (localObject1 != null) {
        com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject1, com.tencent.mm.live.b.b.c.ncy);
      }
      ezK();
      com.tencent.mm.ae.d.a(200L, (kotlin.g.a.a)new q(this));
      ezR();
      Log.i(this.TAG, kotlin.g.b.s.X("joinLiveByMiniWin audienceMode:", Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu())));
      AppMethodBeat.o(358578);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void ezw()
  {
    AppMethodBeat.i(358954);
    Object localObject = this.CCg;
    if (localObject != null)
    {
      Log.i(this.TAG, "stopLiveVideo,float mode:" + isFloatMode() + ", normal mode:" + bep() + ",manual closed:" + ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isManualClosed() + ", start:" + ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isLiveStarted() + ",finish:" + ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isLiveFinished() + ", needMiniWindow:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI + " isUseByFluentDirector: " + this.EkQ);
      if ((!((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isManualClosed()) && (!this.EkQ) && (((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isLiveStarted()) && (!((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isLiveFinished()))
      {
        if ((bep()) && (((com.tencent.mm.plugin.finder.live.view.router.c)localObject).needMiniWindow()) && (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 2048)))
        {
          ezv();
          AppMethodBeat.o(358954);
        }
      }
      else if (bep())
      {
        localObject = getLiveCore();
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.f.d)localObject).bfH();
        }
      }
    }
    AppMethodBeat.o(358954);
  }
  
  public final com.tencent.mm.live.core.core.f.d getLiveCore()
  {
    AppMethodBeat.i(358494);
    Object localObject = this.data;
    if (localObject == null) {}
    for (localObject = null;; localObject = a.a.hH(((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject).Ebr.liveId))
    {
      localObject = (com.tencent.mm.live.core.core.f.d)localObject;
      AppMethodBeat.o(358494);
      return localObject;
      a.a locala = com.tencent.mm.live.core.core.f.a.mUf;
    }
  }
  
  public final void onBattleEnd()
  {
    AppMethodBeat.i(359037);
    com.tencent.mm.plugin.finder.live.view.router.c localc = this.CCg;
    if (localc != null) {
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localc, com.tencent.mm.live.b.b.c.nfb);
    }
    AppMethodBeat.o(359037);
  }
  
  public final void onBattleStart()
  {
    AppMethodBeat.i(359030);
    com.tencent.mm.plugin.finder.live.view.router.c localc = this.CCg;
    if (localc != null) {
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localc, com.tencent.mm.live.b.b.c.nfa);
    }
    AppMethodBeat.o(359030);
  }
  
  public final void onLiveEventCallback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(358918);
    Object localObject1 = e.g.mKv;
    label160:
    boolean bool1;
    label267:
    label278:
    label614:
    label626:
    label890:
    int i;
    label882:
    Object localObject4;
    label964:
    label1009:
    int j;
    label1098:
    label1123:
    label1131:
    label2798:
    label3580:
    int k;
    if (paramInt == e.g.bcO())
    {
      Log.i(this.TAG, "first I frame");
      if (paramBundle == null)
      {
        localObject1 = null;
        if (!Util.isEqual((String)localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw)) {
          break label5038;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.bd.Gli;
        ??? = kotlin.g.b.s.X(com.tencent.mm.plugin.finder.utils.bd.fhS(), Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
        ??? = com.tencent.mm.plugin.finder.utils.bb.GjM;
        com.tencent.mm.plugin.finder.utils.bd.a((com.tencent.mm.plugin.finder.utils.bd)localObject1, (String)???, com.tencent.mm.plugin.finder.utils.bb.fhm().name, null, false, true, false, 44);
        localObject1 = this.CCg;
        if (localObject1 != null)
        {
          com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject1, com.tencent.mm.live.b.b.c.ndj);
          localObject1 = kotlin.ah.aiuX;
        }
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (paramBundle != null) {
          break label267;
        }
        paramInt = 0;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).videoWidth = paramInt;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (paramBundle != null) {
          break label278;
        }
      }
      for (paramInt = 0;; paramInt = paramBundle.getInt("live_first_frame_height"))
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).videoHeight = paramInt;
        Log.i(this.TAG, "EVENT_RENDER_FIRST_I_FRAME videoWidth:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).videoWidth + ",videoHeight:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).videoHeight);
        AppMethodBeat.o(358918);
        return;
        localObject1 = paramBundle.getString("live_user_id");
        break;
        paramInt = paramBundle.getInt("live_first_frame_width");
        break label160;
      }
    }
    else
    {
      localObject1 = e.g.mKv;
      if (paramInt == e.g.bcI())
      {
        if (paramBundle != null)
        {
          localObject1 = paramBundle.getString("live_user_id");
          paramBundle = paramBundle.getString("live_user_exit_reason");
          Log.i(this.TAG, "user exit sdkUid:" + localObject1 + ",reason:" + paramBundle + " linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + " curLinkMic:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw);
          if (kotlin.g.b.s.p(localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw))
          {
            paramBundle = this.CCg;
            if (paramBundle != null)
            {
              com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.ndb);
              paramBundle = kotlin.ah.aiuX;
            }
            paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
            kotlin.g.b.s.s(paramBundle, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
          }
        }
        for (;;)
        {
          synchronized ((Iterable)paramBundle)
          {
            ??? = ((Iterable)???).iterator();
            if (((Iterator)???).hasNext())
            {
              paramBundle = ((Iterator)???).next();
              bool1 = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramBundle).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF());
              if (!bool1) {
                continue;
              }
              if (paramBundle != null)
              {
                paramBundle = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
                com.tencent.mm.plugin.finder.live.model.mic.b.enf();
                ezN();
              }
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM = false;
              if (localObject1 == null) {
                break label890;
              }
              paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
              if (paramBundle != null) {
                break label882;
              }
              paramBundle = null;
              if (((String)localObject1).equals(paramBundle) != true) {
                break label890;
              }
              paramInt = 1;
              if (paramInt != 0) {
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv = null;
              }
              paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
              kotlin.g.b.s.s(paramBundle, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
            }
          }
          synchronized ((Iterable)paramBundle)
          {
            ??? = ((Iterable)???).iterator();
            for (;;)
            {
              if (((Iterator)???).hasNext())
              {
                paramBundle = ((Iterator)???).next();
                bool1 = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramBundle).mXL, (String)localObject1);
                if (bool1)
                {
                  if (paramBundle != null)
                  {
                    paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
                    kotlin.g.b.s.s(paramBundle, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
                    com.tencent.mm.ae.d.a(paramBundle, (kotlin.g.a.b)new aa((String)localObject1));
                    paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
                    kotlin.g.b.s.s(paramBundle, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
                    com.tencent.mm.ae.d.a(paramBundle, (kotlin.g.a.b)new ab((String)localObject1));
                    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
                    {
                      paramBundle = this.CCg;
                      if (paramBundle != null)
                      {
                        com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramBundle, false, 1, null);
                        paramBundle = kotlin.ah.aiuX;
                      }
                      paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
                      com.tencent.mm.plugin.finder.live.model.aj.a(2, null, false, 6);
                    }
                  }
                  paramBundle = kotlin.ah.aiuX;
                  AppMethodBeat.o(358918);
                  return;
                  paramBundle = null;
                  break;
                  paramBundle = finally;
                  AppMethodBeat.o(358918);
                  throw paramBundle;
                  paramBundle = paramBundle.mXL;
                  break label614;
                  paramInt = 0;
                  break label626;
                }
              }
            }
            paramBundle = null;
          }
        }
      }
      localObject1 = e.g.mKv;
      if (paramInt == e.g.bcK())
      {
        localObject1 = this.CCg;
        if (localObject1 != null)
        {
          i = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).getCurNetworkQuality();
          paramBundle = getLiveCore();
          if (paramBundle != null) {
            break label1098;
          }
          paramBundle = null;
          if (paramBundle != null) {
            break label1123;
          }
          paramBundle = e.o.mLz;
          paramInt = e.o.bdD();
          ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).setCurNetworkQuality(paramInt);
          paramBundle = e.o.mLz;
          if (i == e.o.bdF()) {
            break label1131;
          }
          paramInt = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).getCurNetworkQuality();
          paramBundle = e.o.mLz;
          if (paramInt != e.o.bdF()) {
            break label1131;
          }
          com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject1, com.tencent.mm.live.b.b.c.ncZ);
          i = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).getCurNetworkType();
          paramBundle = getLiveCore();
          if (paramBundle != null) {
            break label1173;
          }
          paramInt = -1;
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).setCurNetworkType(paramInt);
          if ((i == 0) && (((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).getCurNetworkType() != 0) && (((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).getCurNetworkType() != -1)) {
            aa.makeText((Context)this.CCa, (CharSequence)this.CCa.getResources().getString(p.h.Cmb), 0).show();
          }
          paramBundle = kotlin.ah.aiuX;
          paramBundle = kotlin.ah.aiuX;
          AppMethodBeat.o(358918);
          return;
          paramBundle = paramBundle.mRB;
          if (paramBundle == null)
          {
            paramBundle = null;
            break;
          }
          paramBundle = Integer.valueOf(paramBundle.mNT);
          break;
          paramInt = paramBundle.intValue();
          break label964;
          paramBundle = e.o.mLz;
          if (i != e.o.bdF()) {
            break label1009;
          }
          paramInt = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).getCurNetworkQuality();
          paramBundle = e.o.mLz;
          if (paramInt == e.o.bdF()) {
            break label1009;
          }
          com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject1, com.tencent.mm.live.b.b.c.nda);
          break label1009;
          label1173:
          paramBundle = paramBundle.mRB;
          if (paramBundle == null) {
            paramInt = -1;
          } else {
            paramInt = paramBundle.networkType;
          }
        }
      }
      localObject1 = e.g.mKv;
      if (paramInt != e.g.bcR())
      {
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcS())
        {
          localObject1 = this.CCg;
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).statusChange(com.tencent.mm.live.b.b.c.ned, paramBundle);
            paramBundle = kotlin.ah.aiuX;
          }
          AppMethodBeat.o(358918);
          return;
        }
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcT())
        {
          paramBundle = com.tencent.mm.plugin.finder.live.report.k.Doi;
          com.tencent.mm.plugin.finder.live.report.k.os(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
          paramBundle = this.CCg;
          if (paramBundle != null)
          {
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.nda);
            paramBundle = kotlin.ah.aiuX;
          }
          AppMethodBeat.o(358918);
          return;
        }
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcU())
        {
          paramBundle = this.CCg;
          if (paramBundle != null)
          {
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.ncY);
            paramBundle = kotlin.ah.aiuX;
          }
          AppMethodBeat.o(358918);
          return;
        }
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcV())
        {
          paramBundle = this.CCg;
          if (paramBundle != null)
          {
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.ncZ);
            paramBundle = kotlin.ah.aiuX;
          }
          ezL();
          AppMethodBeat.o(358918);
          return;
        }
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bdg())
        {
          i = 1;
          if (i == 0) {
            break label1460;
          }
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label1482;
          }
          ezL();
          AppMethodBeat.o(358918);
          return;
          localObject1 = e.g.mKv;
          if (paramInt == e.g.bdh())
          {
            i = 1;
            break;
          }
          i = 0;
          break;
          label1460:
          localObject1 = e.g.mKv;
          if (paramInt == e.g.bdf()) {
            i = 1;
          } else {
            i = 0;
          }
        }
        label1482:
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcW())
        {
          localObject1 = this.CCg;
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).statusChange(com.tencent.mm.live.b.b.c.ndo, paramBundle);
            paramBundle = kotlin.ah.aiuX;
          }
          AppMethodBeat.o(358918);
          return;
        }
        localObject1 = e.g.mKv;
        label1553:
        boolean bool2;
        if (paramInt == e.g.bcJ())
        {
          if (paramBundle == null)
          {
            localObject1 = "";
            if (paramBundle != null) {
              break label1895;
            }
            bool1 = false;
            if (bool1)
            {
              paramBundle = this.Ekf;
              if (paramBundle != null)
              {
                paramBundle.awR((String)localObject1);
                paramBundle = kotlin.ah.aiuX;
              }
              paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
              kotlin.g.b.s.s(paramBundle, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
            }
          }
          for (;;)
          {
            synchronized ((Iterable)paramBundle)
            {
              ??? = ((Iterable)???).iterator();
              if (((Iterator)???).hasNext())
              {
                paramBundle = ((Iterator)???).next();
                bool2 = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramBundle).mXL, (String)localObject1);
                if (!bool2) {
                  continue;
                }
                paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramBundle;
                if (paramBundle == null) {
                  break label2015;
                }
                if (!paramBundle.EbD) {
                  break label1924;
                }
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv = paramBundle;
                paramBundle = this.CCg;
                if (paramBundle != null)
                {
                  com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.neC);
                  paramBundle = kotlin.ah.aiuX;
                }
                if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
                {
                  paramBundle = this.CCg;
                  if (paramBundle != null)
                  {
                    com.tencent.mm.plugin.finder.live.view.a.notifyPKMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramBundle, false, 1, null);
                    paramBundle = kotlin.ah.aiuX;
                  }
                  paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
                  com.tencent.mm.plugin.finder.live.model.aj.a(1, null, false, 6);
                }
                Log.i(this.TAG, "EVENT_ROOM_USER_AUDIO_STATE linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + " curLinkMic:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw + " userId:" + (String)localObject1 + " enable:" + bool1);
                AppMethodBeat.o(358918);
                return;
                ??? = paramBundle.getString("live_user_id");
                localObject1 = ???;
                if (??? != null) {
                  break;
                }
                localObject1 = "";
                break;
                label1895:
                bool1 = paramBundle.getBoolean("live_media_enable");
                break label1553;
              }
              paramBundle = null;
            }
            label1924:
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).h(paramBundle);
            paramBundle = this.CCg;
            if (paramBundle != null)
            {
              com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.neC);
              paramBundle = kotlin.ah.aiuX;
            }
            if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
            {
              paramBundle = this.CCg;
              if (paramBundle != null)
              {
                com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramBundle, false, 1, null);
                paramBundle = kotlin.ah.aiuX;
              }
              paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
              com.tencent.mm.plugin.finder.live.model.aj.a(2, null, false, 6);
              continue;
              label2015:
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfH.add(new com.tencent.mm.plugin.finder.live.viewmodel.data.h((String)localObject1, null, null, null, 0, null, null, false, 0, null, null, 0, 0, false, null, 0L, null, false, 1048512));
            }
          }
        }
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcH())
        {
          if (paramBundle == null)
          {
            paramBundle = "";
            paramInt = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
            localObject1 = e.b.mKf;
            if (paramInt == e.b.bcu())
            {
              localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
              kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
            }
          }
          for (;;)
          {
            synchronized ((Iterable)localObject1)
            {
              ??? = ((Iterable)???).iterator();
              if (((Iterator)???).hasNext())
              {
                localObject1 = ((Iterator)???).next();
                bool1 = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF());
                if (!bool1) {
                  continue;
                }
                ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1;
                if (??? != null)
                {
                  localObject1 = getLiveCore();
                  if (localObject1 != null) {
                    break label2432;
                  }
                  localObject1 = null;
                  if (Util.isEqual((String)localObject1, paramBundle))
                  {
                    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXM != 2) {
                      break label2460;
                    }
                    localObject1 = this.CCg;
                    if (localObject1 != null) {
                      ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).post(new b..ExternalSyntheticLambda21(this, (com.tencent.mm.plugin.finder.live.viewmodel.data.h)???));
                    }
                    localObject1 = getLiveCore();
                    if (localObject1 != null) {
                      ((com.tencent.mm.live.core.core.f.d)localObject1).bcj();
                    }
                  }
                }
                Log.i(this.TAG, "EVENT_USER_VIDEO_AVAILABLE linkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + " curLinkMic:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw + " userId:" + paramBundle);
                AppMethodBeat.o(358918);
                return;
                paramBundle = paramBundle.getString("live_user_id");
                if (paramBundle == null)
                {
                  paramBundle = "";
                  break;
                }
                break;
              }
              localObject1 = null;
            }
            label2432:
            localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
            if (localObject1 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = ((com.tencent.mm.live.core.core.model.i)localObject1).mNM;
              continue;
              label2460:
              localObject1 = this.CCg;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).post(new b..ExternalSyntheticLambda20(this, (com.tencent.mm.plugin.finder.live.viewmodel.data.h)???));
              }
              localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
              com.tencent.mm.plugin.finder.live.model.aj.a(2, null, false, 6);
            }
          }
        }
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcX())
        {
          paramBundle = com.tencent.mm.plugin.finder.live.model.ag.CGN;
          com.tencent.mm.plugin.finder.live.model.ag.elh();
          AppMethodBeat.o(358918);
          return;
        }
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcY())
        {
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
          {
            Log.i(this.TAG, "EVENT_CDN_SEI_MESSAGE_LINK_MIC: roomPk = true, skip");
            AppMethodBeat.o(358918);
            return;
          }
          if (paramBundle == null) {
            paramBundle = null;
          }
          while (paramBundle != null)
          {
            localObject1 = new dlg();
            ??? = (com.tencent.mm.bx.a)localObject1;
            ??? = kotlin.n.d.UTF_8;
            if (paramBundle == null)
            {
              paramBundle = new NullPointerException("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(358918);
              throw paramBundle;
              paramBundle = paramBundle.getString("live_cdn_sei_msg");
            }
            else
            {
              paramBundle = paramBundle.getBytes((Charset)???);
              kotlin.g.b.s.s(paramBundle, "(this as java.lang.String).getBytes(charset)");
              try
              {
                ((com.tencent.mm.bx.a)???).parseFrom(paramBundle);
                paramBundle = kotlin.ah.aiuX;
                Log.i(this.TAG, "EVENT_CDN_SEI_MESSAGE_LINK_MIC micSEIMsg.infos:" + ((dlg)localObject1).ToF + " liveData.business(LiveCommonSlice::class.java).audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw);
                paramBundle = (Collection)((dlg)localObject1).ToF;
                if ((paramBundle == null) || (paramBundle.isEmpty()))
                {
                  paramInt = 1;
                  if (paramInt == 0) {
                    break label2798;
                  }
                  paramBundle = this.CCg;
                  if (paramBundle == null) {
                    break;
                  }
                  com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.neD);
                  paramBundle = kotlin.ah.aiuX;
                  AppMethodBeat.o(358918);
                }
              }
              catch (Exception paramBundle)
              {
                for (;;)
                {
                  Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
                  continue;
                  paramInt = 0;
                }
                paramBundle = this.CCg;
                if (paramBundle != null)
                {
                  com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.neC);
                  paramBundle = kotlin.ah.aiuX;
                }
                ehm();
                ??? = new ah.a();
                ((ah.a)???).aiwY = true;
                ??? = new LinkedList();
                paramBundle = ((dlg)localObject1).ToF;
                kotlin.g.b.s.s(paramBundle, "micSEIMsg.infos");
                localObject4 = ((Iterable)paramBundle).iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  ??? = (dlh)((Iterator)localObject4).next();
                  paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
                  kotlin.g.b.s.s(paramBundle, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
                  synchronized ((Iterable)paramBundle)
                  {
                    ??? = ((Iterable)???).iterator();
                    for (;;)
                    {
                      if (((Iterator)???).hasNext())
                      {
                        paramBundle = ((Iterator)???).next();
                        bool1 = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramBundle).mXL, ((dlh)???).YRR);
                        if (bool1)
                        {
                          paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramBundle;
                          if (paramBundle != null) {
                            break label3012;
                          }
                          ((ah.a)???).aiwY = false;
                          break;
                        }
                      }
                    }
                    paramBundle = null;
                  }
                  label3012:
                  paramInt = ((dlh)???).aaRl;
                  ??? = e.m.mLr;
                  paramBundle.EbG = com.tencent.mm.ae.d.ee(paramInt, e.m.bdw());
                  ((LinkedList)???).add(paramBundle);
                }
                com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ac((ah.a)???, (dlg)localObject1, this, (LinkedList)???));
                paramBundle = kotlin.ah.aiuX;
              }
            }
          }
          AppMethodBeat.o(358918);
          return;
        }
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bda())
        {
          if (paramBundle == null)
          {
            localObject1 = null;
            if (localObject1 == null) {
              break label3741;
            }
            ??? = new com.tencent.mm.ad.i((String)localObject1);
            localObject1 = e.r.mLO;
            localObject1 = ((com.tencent.mm.ad.i)???).optString(e.r.getUserId());
            if (localObject1 != null) {
              break label3485;
            }
            localObject1 = "";
            label3135:
            ??? = e.r.mLO;
            i = ((com.tencent.mm.ad.i)???).optInt(e.r.bdI());
            ??? = e.r.mLO;
            paramInt = ((com.tencent.mm.ad.i)???).optInt(e.r.bdJ());
            ??? = e.r.mLO;
            j = ((com.tencent.mm.ad.i)???).optInt(e.r.bdK());
            ??? = e.r.mLO;
            H(((com.tencent.mm.ad.i)???).optLong(e.r.bdL()), (String)localObject1);
            p((String)localObject1, i, paramInt, j);
            ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
            if (??? != null) {
              if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL, (String)localObject1))
              {
                ??? = com.tencent.mm.live.core.core.e.a.mKb;
                bool1 = com.tencent.mm.ae.d.ee(i, com.tencent.mm.live.core.core.e.a.bcr());
                if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).AWE != bool1)
                {
                  ??? = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).EbH;
                  if ((??? != null) && (((CharSequence)???).length() != 0)) {
                    break label3488;
                  }
                }
              }
            }
          }
          label3485:
          label3488:
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0)
            {
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).AWE = bool1;
              ??? = this.Ejo;
              if (??? != null)
              {
                ((com.tencent.mm.plugin.finder.live.plugin.bf)???).awC(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL);
                ??? = kotlin.ah.aiuX;
              }
              ??? = this.EiR;
              if (??? != null)
              {
                ((com.tencent.mm.plugin.finder.live.plugin.aj)???).emx();
                ??? = kotlin.ah.aiuX;
              }
            }
            ??? = com.tencent.mm.live.core.core.e.a.mKb;
            bool1 = com.tencent.mm.ae.d.ee(i, com.tencent.mm.live.core.core.e.a.bcq());
            if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).EbG != bool1)
            {
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).EbG = bool1;
              ??? = this.EiR;
              if (??? != null)
              {
                ((com.tencent.mm.plugin.finder.live.plugin.aj)???).emy();
                ??? = kotlin.ah.aiuX;
              }
            }
            ??? = kotlin.ah.aiuX;
            ??? = kotlin.ah.aiuX;
            if (!((String)localObject1).equals(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw)) {
              break label3733;
            }
            paramBundle = paramBundle.getString("live_link_mic_info_in_anchor_sei_msg");
            if (!Util.isNullOrNil(paramBundle)) {
              break label3748;
            }
            if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM) {
              break label3493;
            }
            AppMethodBeat.o(358918);
            return;
            localObject1 = paramBundle.getString("live_cdn_sei_msg");
            break;
            break label3135;
          }
          label3493:
          Log.i(this.TAG, "EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: linkMicInfo empty, linkMicInfo:" + paramBundle + ", roomPk:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM);
          localObject1 = new JSONObject();
          Log.d(this.TAG, kotlin.g.b.s.X("EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: micData:", localObject1));
          ??? = ((JSONObject)localObject1).optJSONArray("list");
          if (??? == null)
          {
            paramInt = 0;
            if (paramInt != 0) {
              break label3828;
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM = false;
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv = null;
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ezc();
            paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
            kotlin.g.b.s.s(paramBundle, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
            if (((Collection)paramBundle).isEmpty()) {
              break label3784;
            }
            paramInt = 1;
            label3660:
            if (paramInt == 0) {
              break label3789;
            }
            Log.i(this.TAG, kotlin.g.b.s.X("EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: audienceLinkMicUserList:", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw));
            paramBundle = this.CCg;
            if (paramBundle != null) {
              paramBundle.setLastRoomPkMicUserList(null);
            }
            paramBundle = this.CCg;
            if (paramBundle != null)
            {
              paramBundle.notifyAudienceMicUserChange(false);
              paramBundle = kotlin.ah.aiuX;
            }
            paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
            com.tencent.mm.plugin.finder.live.model.aj.a(2, null, false, 2);
          }
          for (;;)
          {
            for (;;)
            {
              label3733:
              paramBundle = kotlin.ah.aiuX;
              paramBundle = kotlin.ah.aiuX;
              label3741:
              AppMethodBeat.o(358918);
              return;
              try
              {
                label3748:
                paramBundle = new JSONObject(paramBundle);
                localObject1 = paramBundle;
              }
              catch (JSONException paramBundle)
              {
                for (;;)
                {
                  paramBundle = new JSONObject();
                }
              }
            }
            paramInt = ((JSONArray)???).length();
            break label3580;
            label3784:
            paramInt = 0;
            break label3660;
            label3789:
            paramBundle = this.CCg;
            if (paramBundle != null) {
              com.tencent.mm.plugin.finder.live.view.a.notifyRoomPKMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramBundle, (JSONObject)localObject1, false, null, 6, null);
            }
            paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
            com.tencent.mm.plugin.finder.live.model.aj.a(3, (JSONObject)localObject1, false, 4);
            continue;
            label3828:
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM = true;
            paramBundle = this.CCg;
            if (paramBundle != null)
            {
              com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.neC);
              paramBundle = kotlin.ah.aiuX;
            }
            ??? = new LinkedList();
            j = 0;
            if (??? == null)
            {
              i = 0;
              label3884:
              if (i <= 0) {
                break label5062;
              }
              paramInt = 1;
              paramBundle = null;
              k = j + 1;
              if (??? != null) {
                break label4399;
              }
              ??? = null;
              label3906:
              if (??? != null) {
                break label4411;
              }
              ??? = null;
              label3914:
              localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
              kotlin.g.b.s.s(localObject4, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
              synchronized ((Iterable)localObject4)
              {
                Iterator localIterator = ((Iterable)???).iterator();
                while (localIterator.hasNext())
                {
                  localObject4 = localIterator.next();
                  bool1 = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).mXL, (String)???);
                  if (bool1)
                  {
                    label3995:
                    localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4;
                    if (localObject4 != null) {
                      break label4442;
                    }
                    Log.i(this.TAG, kotlin.g.b.s.X("EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: can't find user info, userId:", ???));
                    paramInt = 0;
                    label4027:
                    if (k < i) {
                      break label5055;
                    }
                    label4033:
                    ehm();
                    bool1 = false;
                    j = 0;
                    if (??? != null) {
                      break label4527;
                    }
                    i = 0;
                    label4050:
                    if (i > 0)
                    {
                      bool1 = false;
                      label4057:
                      k = j + 1;
                      if (??? != null) {
                        break label4536;
                      }
                      ??? = null;
                      label4071:
                      if (??? != null) {
                        break label4548;
                      }
                      ??? = null;
                      label4079:
                      if (!Util.isEqual((String)???, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF())) {
                        break label5052;
                      }
                      bool1 = true;
                      if (k < i) {
                        break label5045;
                      }
                    }
                    label4103:
                    ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
                    kotlin.g.b.s.s(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
                  }
                }
              }
            }
            for (;;)
            {
              synchronized ((Iterable)???)
              {
                localObject4 = ((Iterable)???).iterator();
                if (((Iterator)localObject4).hasNext())
                {
                  ??? = ((Iterator)localObject4).next();
                  bool2 = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF());
                  if (!bool2) {
                    continue;
                  }
                  if (??? == null) {
                    break label4579;
                  }
                  bool2 = true;
                  if ((bool2) && (!bool1))
                  {
                    this.EkR += 1;
                    Log.i(this.TAG, "EVENT_CDN_SEI_MESSAGE_ANCHOR_INFO: isMicingByLocal:" + bool2 + ", isMicingBySei:" + bool1 + ", autoCloseLinkMicSelfCount:" + this.EkR + ", maybe postCloseLinkMsg");
                    if (this.EkR >= 10) {
                      ezN();
                    }
                  }
                  else
                  {
                    this.EkR = 0;
                  }
                  if (paramInt == 0) {
                    break;
                  }
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv = paramBundle;
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.clear();
                  paramBundle = ((Iterable)???).iterator();
                  if (!paramBundle.hasNext()) {
                    break label4585;
                  }
                  ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramBundle.next();
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).g((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???);
                  continue;
                  i = ((JSONArray)???).length();
                  break label3884;
                  label4399:
                  ??? = ((JSONArray)???).optJSONObject(j);
                  break label3906;
                  label4411:
                  ??? = ((JSONObject)???).optString("uId");
                  break label3914;
                  localObject4 = null;
                  break label3995;
                  paramBundle = finally;
                  AppMethodBeat.o(358918);
                  throw paramBundle;
                  label4442:
                  if (??? == null)
                  {
                    j = 0;
                    ??? = e.m.mLr;
                    ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).EbG = com.tencent.mm.ae.d.ee(j, e.m.bdw());
                    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).EbD) {
                      continue;
                    }
                    paramBundle = (Bundle)localObject4;
                    break label4027;
                  }
                  j = ((JSONObject)???).optInt("us");
                  continue;
                  ??? = e.m.mLr;
                  ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).EbK = Boolean.valueOf(com.tencent.mm.ae.d.ee(j, e.m.bdz()));
                  ((LinkedList)???).add(localObject4);
                  break label4027;
                  label4527:
                  i = ((JSONArray)???).length();
                  break label4050;
                  label4536:
                  ??? = ((JSONArray)???).optJSONObject(j);
                  break label4071;
                  label4548:
                  ??? = ((JSONObject)???).optString("uId");
                  break label4079;
                }
                ??? = null;
              }
              label4579:
              bool2 = false;
            }
            label4585:
            paramBundle = this.CCg;
            if (paramBundle != null) {
              com.tencent.mm.plugin.finder.live.view.a.notifyRoomPKMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramBundle, (JSONObject)localObject1, false, null, 6, null);
            }
            paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
            com.tencent.mm.plugin.finder.live.model.aj.a(3, (JSONObject)localObject1, false, 4);
          }
        }
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcZ()) {
          if (paramBundle == null)
          {
            paramBundle = null;
            label4642:
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
            kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
          }
        }
      }
    }
    for (;;)
    {
      synchronized ((Iterable)localObject1)
      {
        ??? = ((Iterable)???).iterator();
        if (!((Iterator)???).hasNext()) {
          break label4888;
        }
        localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)???).next();
        if (paramBundle != null) {
          break label4761;
        }
        paramInt = 0;
        label4712:
        localObject1 = getLiveCore();
        if (localObject1 != null) {
          break label4862;
        }
        i = 0;
        break label5069;
        label4728:
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).EbG = bool1;
      }
      paramBundle = paramBundle.getParcelableArrayList("live_user_volume_info");
      break label4642;
      for (;;)
      {
        label4761:
        synchronized ((Iterable)paramBundle)
        {
          ??? = ((Iterable)???).iterator();
          if (!((Iterator)???).hasNext()) {
            break label5080;
          }
          localObject1 = ((Iterator)???).next();
          bool1 = Util.isEqual(((UserVolumeInfo)localObject1).userId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).mXL);
          if (!bool1) {
            continue;
          }
          localObject1 = (UserVolumeInfo)localObject1;
          if (localObject1 == null) {
            paramInt = 0;
          }
        }
        paramInt = ((UserVolumeInfo)localObject1).volume;
        break label4712;
        label4862:
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRM;
        if (localObject1 == null)
        {
          i = 0;
        }
        else
        {
          i = ((com.tencent.mm.live.core.core.model.c)localObject1).mMI;
          break label5069;
          label4888:
          paramBundle = kotlin.ah.aiuX;
          ehm();
          AppMethodBeat.o(358918);
          return;
          localObject1 = e.g.mKv;
          if (paramInt == e.g.bdb())
          {
            localObject1 = this.EjW;
            if (localObject1 != null) {
              if (paramBundle != null) {
                break label4952;
              }
            }
            label4952:
            for (paramBundle = null;; paramBundle = paramBundle.getString("live_cdn_sei_msg"))
            {
              ((ca)localObject1).axm(paramBundle);
              paramBundle = kotlin.ah.aiuX;
              AppMethodBeat.o(358918);
              return;
            }
          }
          paramBundle = e.g.mKv;
          if (paramInt == e.g.bdc())
          {
            paramBundle = this.CCg;
            if (paramBundle != null)
            {
              com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.nft);
              paramBundle = kotlin.ah.aiuX;
            }
            AppMethodBeat.o(358918);
            return;
          }
          paramBundle = e.g.mKv;
          if (paramInt == e.g.bdd())
          {
            paramBundle = this.CCg;
            if (paramBundle != null)
            {
              com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramBundle, com.tencent.mm.live.b.b.c.nfu);
              paramBundle = kotlin.ah.aiuX;
            }
          }
          label5038:
          AppMethodBeat.o(358918);
          return;
          label5045:
          j = k;
          break label4057;
          label5052:
          break label4103;
          label5055:
          j = k;
          break;
          label5062:
          paramInt = 1;
          paramBundle = null;
          break label4033;
        }
        label5069:
        if (paramInt > i) {
          break label5086;
        }
        bool1 = true;
        break label4728;
        label5080:
        localObject1 = null;
      }
      label5086:
      bool1 = false;
    }
  }
  
  public final boolean pc(long paramLong)
  {
    AppMethodBeat.i(358609);
    int i = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage().ov(paramLong);
    boolean bool = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage().ox(paramLong);
    Log.i(this.TAG, "canPreloadLive live " + paramLong + " watchDuration:" + i + ",havePay:" + bool);
    com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.a locala = com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.Eci;
    if ((i < com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.eyn()) || (bool))
    {
      AppMethodBeat.o(358609);
      return true;
    }
    AppMethodBeat.o(358609);
    return false;
  }
  
  public final void qL(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(359004);
    Bundle localBundle = new Bundle();
    Object localObject = this.CCg;
    boolean bool;
    int i;
    if (localObject == null)
    {
      bool = false;
      localBundle.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", bool);
      localBundle.putBoolean("PARAM_FINDER_LIVE_FLUENT_EXIT", paramBoolean);
      localObject = this.CCg;
      if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isSwipeBack() != true)) {
        break label196;
      }
      i = 1;
      label72:
      if (i == 0) {
        break label201;
      }
      i = 1;
      label78:
      localBundle.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", i);
      localBundle.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
      localObject = this.CCg;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).setMiniWinPermission(false);
      }
      localObject = this.CCg;
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((com.tencent.mm.plugin.finder.live.view.router.c)localObject).isSwipeBack() == true) {
          i = 1;
        }
      }
      if (i == 0) {
        break label206;
      }
      localObject = q.z.Dxz;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.live.report.k.Doi.a(true, (q.z)localObject);
      localObject = this.CCg;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).statusChange(com.tencent.mm.live.b.b.c.ncx, localBundle);
      }
      AppMethodBeat.o(359004);
      return;
      bool = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).needRemoveActivity();
      break;
      label196:
      i = 0;
      break label72;
      label201:
      i = 3;
      break label78;
      label206:
      localObject = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (com.tencent.mm.plugin.finder.live.report.k.ett()) {
        localObject = q.z.DxD;
      } else {
        localObject = q.z.DxB;
      }
    }
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(359051);
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA())
    {
      this.nmZ.stopTimer();
      this.nmZ.startTimer(1000L);
      com.tencent.mm.plugin.finder.live.plugin.aj localaj = this.EiR;
      if (localaj != null) {
        localaj.CYC = 1;
      }
    }
    AppMethodBeat.o(359051);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$Companion;", "", "()V", "AUTO_CLOSE_LINK_MIC_SELF_COUNT_THRESHOLD", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    aa(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ab
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    ab(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    ac(ah.a parama, dlg paramdlg, b paramb, LinkedList<com.tencent.mm.plugin.finder.live.viewmodel.data.h> paramLinkedList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ad
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    ad(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class ae
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public ae(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$onStatusChanged$6", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyMicWithAudienceResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class af
    implements com.tencent.mm.plugin.finder.live.model.cgi.d.a
  {
    af(b paramb, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bfd parambfd)
    {
      AppMethodBeat.i(357418);
      kotlin.g.b.s.u(parambfd, "resp");
      Log.i(b.q(this.Eld), "ApplyLinkMic errCode:" + paramInt2 + " errType:" + paramInt1 + "  errMsg:" + paramString);
      b.a(this.Eld, i, paramInt2, paramInt1, paramString, parambfd);
      AppMethodBeat.o(357418);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", "", "errType", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ag
    extends kotlin.g.b.u
    implements kotlin.g.a.r<Integer, Integer, String, azv, kotlin.ah>
  {
    ag(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$postCloseLinkMsg$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ah
    implements g.a
  {
    ah(b paramb, String paramString) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, bgg parambgg)
    {
      AppMethodBeat.i(357411);
      kotlin.g.b.s.u(parambgg, "resp");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.Eld, paramInt2, paramInt1, paramString, str2));
      AppMethodBeat.o(357411);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      a(b paramb, int paramInt1, int paramInt2, String paramString1, String paramString2)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class ai
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<kotlinx.coroutines.aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    public ai(com.tencent.mm.live.core.core.model.g paramg, b paramb, boolean paramBoolean1, boolean paramBoolean2, kotlin.d.d<? super ai> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(357474);
      paramObject = (kotlin.d.d)new ai(this.Byw, this.Eld, this.usI, this.Elo, paramd);
      AppMethodBeat.o(357474);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(357468);
      Object localObject1 = kotlin.d.a.a.aiwj;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(357468);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
        localObject2 = this.Byw;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.loadVisitorCore((com.tencent.mm.live.core.core.model.g)localObject2, locald) == localObject1)
        {
          AppMethodBeat.o(357468);
          return localObject1;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.rV(false);
      b.a(this.Eld, false, this.usI, 1);
      paramObject = this.Eld.CCg;
      if (paramObject != null) {
        com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramObject, com.tencent.mm.live.b.b.c.nfv);
      }
      boolean bool;
      if (this.Elo)
      {
        paramObject = b.i(this.Eld);
        if (paramObject != null)
        {
          paramObject = paramObject.mRB;
          if (paramObject != null) {
            paramObject.bev();
          }
        }
        paramObject = new Bundle();
        localObject1 = this.Eld;
        paramObject.putBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", true);
        localObject2 = b.i((b)localObject1);
        if (localObject2 != null) {
          break label251;
        }
        bool = false;
      }
      for (;;)
      {
        paramObject.putBoolean("PARAM_FINDER_LIVE_IS_SHARE_MODE", bool);
        localObject1 = ((com.tencent.mm.plugin.finder.live.component.statecomponent.d)localObject1).CCg;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).statusChange(com.tencent.mm.live.b.b.c.neR, paramObject);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(357468);
        return paramObject;
        label251:
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mRB;
        if (localObject2 == null) {
          bool = false;
        } else {
          bool = ((com.tencent.mm.live.core.core.model.i)localObject2).mNQ;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class aj
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<kotlinx.coroutines.aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    public aj(com.tencent.mm.live.core.core.model.g paramg, b paramb, kotlin.d.d<? super aj> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(357471);
      paramObject = (kotlin.d.d)new aj(this.Byw, this.Eld, paramd);
      AppMethodBeat.o(357471);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(357463);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(357463);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
        com.tencent.mm.live.core.core.model.g localg = this.Byw;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.loadVisitorCore(localg, locald) == locala)
        {
          AppMethodBeat.o(357463);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.rV(false);
      b.a(this.Eld, false, true, 1);
      paramObject = this.Eld.CCg;
      if (paramObject == null)
      {
        AppMethodBeat.o(357463);
        return null;
      }
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramObject, com.tencent.mm.live.b.b.c.nfv);
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(357463);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ak
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    ak(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$JoinLiveCallback;", "Lkotlin/Function7;", "", "", "", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "", "livingUICRef", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "tag", "(Ljava/lang/ref/SoftReference;Ljava/lang/String;)V", "getLivingUICRef", "()Ljava/lang/ref/SoftReference;", "setLivingUICRef", "(Ljava/lang/ref/SoftReference;)V", "getTag", "()Ljava/lang/String;", "invoke", "success", "errCode", "errType", "errMsg", "liveRoomInfo", "trtcParams", "resp", "reportJoinLive", "isBizMode", "bizUsername", "bizNickname", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements kotlin.g.a.u<Boolean, Integer, Integer, String, com.tencent.mm.live.core.core.model.g, TRTCCloudDef.TRTCParams, bca, kotlin.ah>
  {
    private SoftReference<b> Elb;
    private final String tag;
    
    public b(SoftReference<b> paramSoftReference, String paramString)
    {
      AppMethodBeat.i(357359);
      this.Elb = paramSoftReference;
      this.tag = paramString;
      AppMethodBeat.o(357359);
    }
    
    private static final void V(b paramb)
    {
      AppMethodBeat.i(357384);
      kotlin.g.b.s.u(paramb, "$livingUIC");
      Object localObject;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
      {
        com.tencent.mm.plugin.finder.live.view.router.c localc = paramb.CCg;
        if (localc != null)
        {
          localObject = paramb.CCg;
          if (localObject != null) {
            break label82;
          }
          localObject = null;
          localc.notifyRoomPKMicUserChange((JSONObject)localObject, true, null);
        }
      }
      for (;;)
      {
        paramb = paramb.CCg;
        if (paramb != null)
        {
          paramb = paramb.getStartUIC();
          if (paramb != null) {
            b.a(paramb);
          }
        }
        AppMethodBeat.o(357384);
        return;
        label82:
        localObject = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).getLastMicData();
        break;
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv != null)
        {
          localObject = paramb.CCg;
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).notifyPKMicUserChange(false);
          }
        }
        else
        {
          localObject = paramb.CCg;
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).notifyAudienceMicUserChange(false);
          }
        }
      }
    }
    
    private static final void a(b paramb, boolean paramBoolean, String paramString1, String paramString2, com.tencent.mm.live.core.core.model.g paramg, bca parambca)
    {
      AppMethodBeat.i(357379);
      kotlin.g.b.s.u(paramb, "this$0");
      kotlin.g.b.s.u(paramString1, "$bizUsername");
      kotlin.g.b.s.u(paramString2, "$bizNickname");
      kotlin.g.b.s.u(paramg, "$liveRoomInfo");
      paramb = paramb.Elb;
      b localb;
      Object localObject;
      long l1;
      long l2;
      if (paramb != null)
      {
        localb = (b)paramb.get();
        if (localb != null)
        {
          paramb = com.tencent.mm.ui.component.k.aeZF;
          localObject = (com.tencent.mm.plugin.findersdk.a.bn)com.tencent.mm.ui.component.k.d(b.h(localb)).cq(com.tencent.mm.plugin.findersdk.a.bn.class);
          if (paramBoolean) {}
          for (paramb = "1";; paramb = "0")
          {
            ((com.tencent.mm.plugin.findersdk.a.bn)localObject).iw("is_mmbiz_live", paramb);
            paramb = com.tencent.mm.ui.component.k.aeZF;
            ((com.tencent.mm.plugin.findersdk.a.bn)com.tencent.mm.ui.component.k.d(b.h(localb)).cq(com.tencent.mm.plugin.findersdk.a.bn.class)).iw("mmbiz_accountid", paramString1);
            paramb = com.tencent.mm.ui.component.k.aeZF;
            ((com.tencent.mm.plugin.findersdk.a.bn)com.tencent.mm.ui.component.k.d(b.h(localb)).cq(com.tencent.mm.plugin.findersdk.a.bn.class)).iw("mmbiz_nickname", paramString2);
            paramb = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
            paramb = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKL();
            if (paramb == null) {
              break;
            }
            paramb = ((Map)paramb).entrySet().iterator();
            while (paramb.hasNext())
            {
              paramString1 = (Map.Entry)paramb.next();
              paramString2 = com.tencent.mm.ui.component.k.aeZF;
              ((com.tencent.mm.plugin.findersdk.a.bn)com.tencent.mm.ui.component.k.d(b.h(localb)).cq(com.tencent.mm.plugin.findersdk.a.bn.class)).iw((String)paramString1.getKey(), (String)paramString1.getValue());
            }
          }
          paramb = com.tencent.mm.plugin.finder.live.report.k.Doi;
          l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
          paramb = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramb = com.tencent.mm.plugin.finder.live.report.j.Doc.Dpy;
          kotlin.g.b.s.u(paramb, "commentScene");
          Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", kotlin.g.b.s.X("#markJoinResp ", Long.valueOf(l1)));
          paramString1 = com.tencent.mm.plugin.finder.live.report.k.or(l1);
          paramString1.iDB = l1;
          paramString1.iDO = paramString1.F("commentSceneStr", paramb, true);
          paramString1.iDG = com.tencent.mm.model.cn.bDv();
          paramb = com.tencent.mm.plugin.finder.live.model.ar.CIh;
          com.tencent.mm.plugin.finder.live.model.ar.ok(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
          paramb = com.tencent.mm.plugin.finder.live.report.j.Dob;
          l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet) {
            break label1085;
          }
          l1 = 5L;
          paramb = com.tencent.mm.plugin.finder.api.d.AwY;
          paramb = com.tencent.mm.plugin.finder.api.d.a.auT(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
          if (paramb != null) {
            break label1093;
          }
          paramb = null;
          label430:
          com.tencent.mm.plugin.finder.live.report.j.a(String.valueOf(l2), l1, paramb, false);
          paramb = com.tencent.mm.ui.component.k.aeZF;
          paramb = com.tencent.mm.ui.component.k.d(b.h(localb)).q(com.tencent.mm.plugin.finder.live.sidebar.d.class);
          kotlin.g.b.s.s(paramb, "UICProvider.of(livingUIC…veSideBarUIC::class.java)");
          paramString2 = (com.tencent.mm.plugin.finder.live.sidebar.d)paramb;
          paramString1 = "";
          paramb = com.tencent.mm.ui.component.k.aeZF;
          paramb = ((com.tencent.mm.plugin.findersdk.a.bn)com.tencent.mm.ui.component.k.d(b.h(localb)).cq(com.tencent.mm.plugin.findersdk.a.bn.class)).foA();
          if (!paramString2.DGD) {
            break label1101;
          }
          paramb = paramString2.DGH.etF();
          paramBoolean = ((Boolean)paramb.bsC).booleanValue();
          paramb = (String)paramb.bsD;
          if (!paramBoolean) {
            break label1178;
          }
          paramString1 = q.n.DtN.scene;
        }
      }
      label1153:
      label1163:
      label1178:
      for (;;)
      {
        label548:
        paramString2 = (Map)new HashMap();
        localObject = com.tencent.mm.plugin.finder.utils.bj.GlQ;
        if (com.tencent.mm.plugin.finder.utils.bj.y(localb.buContext))
        {
          paramString2 = com.tencent.mm.plugin.finder.live.olympic.report.b.CRS;
          paramString2 = com.tencent.mm.plugin.finder.live.olympic.report.b.eok();
        }
        for (;;)
        {
          localObject = com.tencent.mm.plugin.finder.live.report.k.Doi;
          localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
          localObject = com.tencent.mm.plugin.finder.live.model.aj.egD();
          label606:
          int i;
          label631:
          long l3;
          label828:
          long l4;
          long l5;
          String str1;
          long l6;
          if (localObject == null)
          {
            localObject = null;
            localObject = com.tencent.mm.plugin.finder.live.report.k.cd((Bundle)localObject);
            if ((localObject != null) && (!((Map)localObject).isEmpty())) {
              break label1122;
            }
            i = 1;
            if (i == 0) {
              paramString2.putAll((Map)localObject);
            }
            localObject = com.tencent.mm.plugin.finder.live.report.k.Doi;
            com.tencent.mm.plugin.finder.live.report.k.a(q.u.DwE);
            com.tencent.mm.plugin.finder.live.viewmodel.business.a.a((com.tencent.mm.plugin.finder.live.viewmodel.business.a)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.business.a.class), b.h(localb).getResources().getConfiguration().orientation, paramString1, paramb, false, paramString2, 8);
            paramb = com.tencent.mm.plugin.finder.utils.bd.Gli;
            paramString1 = kotlin.g.b.s.X(com.tencent.mm.plugin.finder.utils.bd.fhS(), Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
            paramString2 = com.tencent.mm.plugin.finder.utils.bb.GjM;
            com.tencent.mm.plugin.finder.utils.bd.a(paramb, paramString1, com.tencent.mm.plugin.finder.utils.bb.fhi().name, null, false, false, false, 60);
            paramb = com.tencent.mm.plugin.finder.live.report.j.Dob;
            com.tencent.mm.plugin.finder.live.report.j.C(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN);
            localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
            l3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
            if (paramg.liveId > 0L) {
              break label1153;
            }
            if (parambca != null) {
              break label1128;
            }
            l1 = 0L;
            TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
            paramg = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
            paramb = com.tencent.mm.plugin.finder.live.report.j.Dob;
            l4 = com.tencent.mm.plugin.finder.live.report.j.Doc.Dpz;
            l5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.o)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.o.class)).EhQ.size();
            parambca = q.w.DwV;
            paramb = com.tencent.mm.plugin.finder.live.report.j.Dob;
            str1 = com.tencent.mm.plugin.finder.live.report.j.Doc.Dpy;
            l6 = q.u.DwE.status;
            paramb = com.tencent.mm.plugin.finder.live.report.k.Doi;
            if (com.tencent.mm.plugin.finder.live.report.k.etq() > 0L) {
              break label1163;
            }
          }
          for (l2 = System.currentTimeMillis();; l2 = com.tencent.mm.plugin.finder.live.report.k.etq())
          {
            paramb = com.tencent.mm.plugin.finder.live.report.j.Dob;
            q.ca localca = com.tencent.mm.plugin.finder.live.report.j.Doc.Dqh;
            String str2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).sessionBuffer;
            paramb = com.tencent.mm.ui.component.k.aeZF;
            paramString1 = ((com.tencent.mm.plugin.findersdk.a.bn)com.tencent.mm.ui.component.k.d(b.h(localb)).cq(com.tencent.mm.plugin.findersdk.a.bn.class)).foz();
            paramb = paramString1;
            if (paramString1 == null) {
              paramb = "";
            }
            paramString1 = com.tencent.mm.ui.component.k.aeZF;
            paramString2 = ((com.tencent.mm.plugin.findersdk.a.bn)com.tencent.mm.ui.component.k.d(b.h(localb)).cq(com.tencent.mm.plugin.findersdk.a.bn.class)).foA();
            paramString1 = paramString2;
            if (paramString2 == null) {
              paramString1 = "";
            }
            ((com.tencent.mm.plugin.finder.live.report.j)localObject).a(l3, l1, paramg, l4, l5, parambca, str1, l6, l2, localca, str2, paramb, paramString1);
            ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.Dvq);
            AppMethodBeat.o(357379);
            return;
            label1085:
            l1 = 3L;
            break;
            label1093:
            paramb = paramb.getNickname();
            break label430;
            label1101:
            paramString2 = com.tencent.mm.plugin.finder.live.report.k.Doi;
            com.tencent.mm.plugin.finder.live.report.k.axr(paramb);
            break label548;
            localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).CFn;
            break label606;
            label1122:
            i = 0;
            break label631;
            label1128:
            paramb = parambca.liveInfo;
            if (paramb == null)
            {
              l1 = 0L;
              break label828;
            }
            l1 = paramb.liveId;
            break label828;
            l1 = paramg.liveId;
            break label828;
            paramb = com.tencent.mm.plugin.finder.live.report.k.Doi;
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      a(b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$JoinLiveCallback2;", "Lkotlin/Function7;", "", "", "", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "", "livingUICRef", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "tag", "(Ljava/lang/ref/SoftReference;Ljava/lang/String;)V", "getLivingUICRef", "()Ljava/lang/ref/SoftReference;", "setLivingUICRef", "(Ljava/lang/ref/SoftReference;)V", "getTag", "()Ljava/lang/String;", "invoke", "success", "errCode", "errType", "errMsg", "liveRoomInfo", "trtcParams", "resp", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements kotlin.g.a.u<Boolean, Integer, Integer, String, com.tencent.mm.live.core.core.model.g, TRTCCloudDef.TRTCParams, bca, kotlin.ah>
  {
    private SoftReference<b> Elb;
    private final String tag;
    
    public c(SoftReference<b> paramSoftReference, String paramString)
    {
      AppMethodBeat.i(357356);
      this.Elb = paramSoftReference;
      this.tag = paramString;
      AppMethodBeat.o(357356);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$PrepareShoppingCallback;", "Lkotlin/Function1;", "", "", "livingUICRef", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "tag", "", "(Ljava/lang/ref/SoftReference;Ljava/lang/String;)V", "getLivingUICRef", "()Ljava/lang/ref/SoftReference;", "setLivingUICRef", "(Ljava/lang/ref/SoftReference;)V", "getTag", "()Ljava/lang/String;", "invoke", "success", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    private SoftReference<b> Elb;
    private final String tag;
    
    public d(SoftReference<b> paramSoftReference, String paramString)
    {
      AppMethodBeat.i(357354);
      this.Elb = paramSoftReference;
      this.tag = paramString;
      AppMethodBeat.o(357354);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBottomTipPlugin;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.plugin.ae>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<kotlinx.coroutines.aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    g(b paramb, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(357369);
      paramObject = (kotlin.d.d)new g(this.Eld, paramd);
      AppMethodBeat.o(357369);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(357366);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(357366);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.f)kotlinx.coroutines.bg.kCi();
        Object localObject = (kotlin.g.a.m)new a(this.Eld, null);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = kotlinx.coroutines.l.a(paramObject, (kotlin.g.a.m)localObject, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(357366);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      if (((Boolean)paramObject).booleanValue())
      {
        paramObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.aD((Context)b.h(this.Eld), "charge live invalid!");
        paramObject = this.Eld.CCg;
        if (paramObject != null) {
          com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramObject, com.tencent.mm.live.b.b.c.nfC);
        }
        paramObject = this.Eld.CCg;
        if (paramObject != null)
        {
          paramObject = (com.tencent.mm.plugin.finder.live.plugin.ag)paramObject.getPlugin(com.tencent.mm.plugin.finder.live.plugin.ag.class);
          if (paramObject != null)
          {
            Log.i("FinderLiveChargePayPlugin", "finishCountDown");
            paramObject.hG(0, paramObject.CXA);
          }
        }
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(357366);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<kotlinx.coroutines.aq, kotlin.d.d<? super Boolean>, Object>
    {
      int label;
      
      a(b paramb, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(357415);
        paramObject = (kotlin.d.d)new a(this.Eld, paramd);
        AppMethodBeat.o(357415);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(357408);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(357408);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = com.tencent.mm.plugin.finder.live.model.g.CEN;
          long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.Eld.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
          Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.Eld.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
          long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.Eld.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          localObject = com.tencent.mm.plugin.finder.live.model.g.a(paramObject, l1, (String)localObject, l2, locald);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(357408);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(357408);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "avatarItem", "Lcom/tencent/mm/protocal/protobuf/LiveElementMedia;", "atmosphereItem"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.m<dik, dik, kotlin.ah>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    public static final i Ele;
    
    static
    {
      AppMethodBeat.i(357382);
      Ele = new i();
      AppMethodBeat.o(357382);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    public static final j Elf;
    
    static
    {
      AppMethodBeat.i(357362);
      Elf = new j();
      AppMethodBeat.o(357362);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    k(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    l(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$firstFrameCallback$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<1>
  {
    m(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    n(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$hideFinderNewGuide$2$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements Animation.AnimationListener
  {
    public o(View paramView) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(357380);
      this.$view.setVisibility(8);
      AppMethodBeat.o(357380);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$hideFinderNewGuide$4$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements Animation.AnimationListener
  {
    public p(View paramView) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(357377);
      this.$view.setVisibility(8);
      AppMethodBeat.o(357377);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    q(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.plugin.co>
  {
    r(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    implements RequestFloatWindowPermissionDialog.a
  {
    s(b paramb) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      int j = 1;
      AppMethodBeat.i(357398);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      com.tencent.mm.plugin.finder.live.report.k.Doi.a(true, q.z.Dxw);
      paramRequestFloatWindowPermissionDialog = new Bundle();
      Object localObject = this.Eld;
      paramRequestFloatWindowPermissionDialog.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true);
      com.tencent.mm.plugin.finder.live.view.router.c localc = ((com.tencent.mm.plugin.finder.live.component.statecomponent.d)localObject).CCg;
      if ((localc != null) && (localc.isSwipeBack() == true))
      {
        i = 1;
        if (i == 0) {
          break label141;
        }
      }
      label141:
      for (int i = j;; i = 3)
      {
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", i);
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
        localObject = ((com.tencent.mm.plugin.finder.live.component.statecomponent.d)localObject).CCg;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.c)localObject).statusChange(com.tencent.mm.live.b.b.c.ncx, paramRequestFloatWindowPermissionDialog);
        }
        paramRequestFloatWindowPermissionDialog = this.Eld.CCg;
        if (paramRequestFloatWindowPermissionDialog != null) {
          paramRequestFloatWindowPermissionDialog.setMiniWinPermission(false);
        }
        AppMethodBeat.o(357398);
        return;
        i = 0;
        break;
      }
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(357402);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      com.tencent.mm.plugin.finder.live.view.router.c localc = this.Eld.CCg;
      if (localc != null) {
        localc.setMiniWinPermission(false);
      }
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      localc = this.Eld.CCg;
      if (localc != null) {
        localc.statusChange(com.tencent.mm.live.b.b.c.ncA, paramRequestFloatWindowPermissionDialog);
      }
      AppMethodBeat.o(357402);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(357404);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog = this.Eld.CCg;
      if (paramRequestFloatWindowPermissionDialog != null) {
        paramRequestFloatWindowPermissionDialog.setMiniWinPermission(false);
      }
      paramRequestFloatWindowPermissionDialog = new Bundle();
      com.tencent.mm.plugin.finder.live.view.router.c localc = this.Eld.CCg;
      if (localc != null) {
        localc.statusChange(com.tencent.mm.live.b.b.c.ncC, paramRequestFloatWindowPermissionDialog);
      }
      AppMethodBeat.o(357404);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMusicPlugin;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.a<cs>
  {
    t(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    u(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    v(b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public w(b paramb, com.tencent.mm.live.model.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class x
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public x(b paramb, com.tencent.mm.live.model.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class z
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public z(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b
 * JD-Core Version:    0.7.0.1
 */