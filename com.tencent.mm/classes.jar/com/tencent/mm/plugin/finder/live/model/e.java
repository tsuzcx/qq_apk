package com.tencent.mm.plugin.finder.live.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.tencent.c.a.a.a.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.f.a.hp;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.live.b.l.k;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.b;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.appbrand.config.WeAppHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.plugin.finder.live.MiniProgramHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.finder.live.cgi.n;
import com.tencent.mm.plugin.finder.live.model.cgi.aa;
import com.tencent.mm.plugin.finder.live.model.cgi.aa.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ac.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ad;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ag;
import com.tencent.mm.plugin.finder.live.model.cgi.ag.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ai;
import com.tencent.mm.plugin.finder.live.model.cgi.ai.a;
import com.tencent.mm.plugin.finder.live.model.cgi.am;
import com.tencent.mm.plugin.finder.live.model.cgi.ao.a;
import com.tencent.mm.plugin.finder.live.model.cgi.b.a;
import com.tencent.mm.plugin.finder.live.model.cgi.c.a;
import com.tencent.mm.plugin.finder.live.model.cgi.f.a;
import com.tencent.mm.plugin.finder.live.model.cgi.i.a;
import com.tencent.mm.plugin.finder.live.model.cgi.j.a;
import com.tencent.mm.plugin.finder.live.model.cgi.o.a;
import com.tencent.mm.plugin.finder.live.model.cgi.p.a;
import com.tencent.mm.plugin.finder.live.model.cgi.q.a;
import com.tencent.mm.plugin.finder.live.model.cgi.r.a;
import com.tencent.mm.plugin.finder.live.model.cgi.s.a;
import com.tencent.mm.plugin.finder.live.model.cgi.t.a;
import com.tencent.mm.plugin.finder.live.model.cgi.u.a;
import com.tencent.mm.plugin.finder.live.model.cgi.x.a;
import com.tencent.mm.plugin.finder.live.model.cgi.y;
import com.tencent.mm.plugin.finder.live.model.cgi.y.a;
import com.tencent.mm.plugin.finder.live.model.cgi.z.a;
import com.tencent.mm.plugin.finder.live.plugin.be.a;
import com.tencent.mm.plugin.finder.live.report.s.at;
import com.tencent.mm.plugin.finder.live.report.s.au;
import com.tencent.mm.plugin.finder.live.report.s.bm;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aq;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.avd;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axh;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.axp;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAssistant;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "Lcom/tencent/mm/plugin/finder/live/model/context/IFinderLiveStore;", "context", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheViewVisibilityList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/view/View;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "isFestivalLive", "", "()Z", "setFestivalLive", "(Z)V", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "acceptBattle", "", "liveId", "", "objectId", "objectNonceId", "liveCookie", "", "scene", "toContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "battleId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAcceptBattle$CallBack;", "acceptLinkMic", "micType", "userId", "sessionId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "acceptLinkMicPk", "sdkLiveId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "activateLiveMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "announceGotoShopping", "productId", "applyBattle", "micId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveApplyBattle$CallBack;", "applyLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "applyLinkMicPk", "sdkUserId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "autoTransMmitLive", "toUser", "", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "batchGetMicContact", "usernameList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "cacheViewVisibility", "view", "visibility", "checkVisitorRoleType", "data", "Landroid/content/Intent;", "chooseVisitorRoleImpl", "activity", "Landroid/app/Activity;", "fromUserGuide", "closeBattle", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCloseBattle$CallBack;", "closeLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "closeLinkMicPk", "closeScene", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "closeMiniProgram", "consumeGift", "sessionID", "consumeWeCoin", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "doCloseLive", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "success", "errCode", "errType", "errMsg", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "resp", "doCloseVisitorLive", "doCreateLive", "Lkotlin/Function7;", "needFaceVerify", "verifyUrl", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "doDisableComment", "username", "enable", "Lkotlin/Function2;", "doFetchFinderContact", "finderUsername", "doFinishLive", "manualFinish", "isSecondDaryDevice", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;", "info", "doGetFinderLiveContact", "contact", "doGetGiftList", "doGetMemberList", "Lkotlin/Function4;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "doGetMicCandidateList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "doHighLightLikeLive", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "doJoinLive", "role", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "doLikeLive", "count", "doManualCloseLive", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "doPostAppMsg", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "liveData", "doPostComment", "commentContent", "liveMsgType", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "doPostGift", "rewardGiftId", "rewardGiftCnt", "wecoin", "comboId", "sendGiftTargetUserName", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "expose", "commentSeq", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "genAcceptBattleMsg", "genAcceptLinkMicMsg", "genAcceptLinkMicPkMsg", "genApplyBattleMsg", "genApplyLinkMicMsg", "genApplyLinkMicPkMsg", "genCloseBattleMsg", "genCloseLinkMicMsg", "genCloseLinkMicPkMsg", "genReportContextObj", "getLotteryRecord", "lotteryId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "getLuckyMoneyInfo", "nonceId", "liveCookies", "sendIdList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "getMusicInfo", "songIdList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "getProductDetail", "product", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "getShopShelf", "Lcom/tencent/mm/ui/MMActivity;", "anchorUsername", "Lkotlin/Function1;", "getWeCoinBalance", "getWeCoinBalanceFromCache", "goPrepareLuckyMoney", "goQQMusic", "songId", "songmid", "goReceiveLuckyMoney", "luckyMoneySendInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "resultReceiver", "Landroid/os/ResultReceiver;", "actionCallback", "goToFinderProfileImpl", "isAnchor", "goToGallery", "requestCode", "goToHistoryFile", "gotoWebViewWithoutMiniWindow", "intent", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "initEngine", "sucCallback", "failCallback", "isWeCoinEntranceAvailable", "luckyMoneyRewardNotify", "sendId", "modeShopShelf", "audienceUsername", "finderCmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "modifyMusicList", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;", "onPostGoToFinderProfileResult", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "keyUsername", "openFullScreenMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "openHalfScreenMiniProgram", "openMiniProgram", "pauseLive", "pauseMode", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "processCreateLiveResponse", "response", "processJoinLiveResponse", "processLiveCgiSDKResponse", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "processVisitorRoleResponse", "putInBlackList", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "refreshLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "resumeViewVisibility", "searchMusic", "query", "lastBuffer", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "setAnchorStatus", "flag", "liveStatus", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "setGameTeamMode", "gameTeamMode", "setMicSetting", "micSettingFlag", "showCenterCustomizeToast", "msg", "res", "showRechargeFoodsDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "Landroidx/fragment/app/FragmentActivity;", "Lkotlin/Function0;", "showWeCoinEntranceTutorialDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "Companion", "plugin-finder_release"})
public final class e
  implements an
{
  private static final int ydB = 1;
  private static final int ydC = 2;
  private static final int ydD = 3;
  private static final int ydE = 4;
  public static final e.a ydF;
  final String TAG;
  private final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  final Context context;
  final bid reportObj;
  boolean ydA;
  private ArrayList<kotlin.o<View, Integer>> ydz;
  
  static
  {
    AppMethodBeat.i(287018);
    ydF = new e.a((byte)0);
    ydB = 1;
    ydC = 2;
    ydD = 3;
    ydE = 4;
    AppMethodBeat.o(287018);
  }
  
  public e(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, bid parambid)
  {
    AppMethodBeat.i(287017);
    this.context = paramContext;
    this.buContext = parama;
    this.reportObj = parambid;
    this.TAG = "Finder.FinderLiveAssistant";
    this.ydz = new ArrayList();
    AppMethodBeat.o(287017);
  }
  
  private final void a(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg, boolean paramBoolean, com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(286974);
    if (parama != null)
    {
      Object localObject = com.tencent.mm.plugin.finder.live.u.xWQ;
      com.tencent.mm.plugin.finder.live.u.a(this.buContext, paramg, true);
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      paramg.cBU = com.tencent.mm.plugin.finder.live.utils.a.dEO();
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      String str = paramg.appId;
      kotlin.g.b.p.j(str, "bundle.appId");
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject).aDe(str);
      localObject = paramg.appId;
      kotlin.g.b.p.j(localObject, "bundle.appId");
      paramg.nBv = ((ValueCallback)new com.tencent.mm.plugin.finder.live.t(parama, (String)localObject));
      paramg.nBw = 1000;
      parama = ah.yhC;
      ah.b(paramContext, paramg);
      AppMethodBeat.o(286974);
      return;
    }
    AppMethodBeat.o(286974);
  }
  
  private final void a(crx paramcrx, TRTCCloudDef.TRTCParams paramTRTCParams, com.tencent.mm.live.core.core.model.f paramf)
  {
    boolean bool3 = false;
    AppMethodBeat.i(286971);
    Object localObject3 = paramcrx.Tzt;
    Object localObject2 = paramcrx.Tzu;
    Object localObject1 = paramcrx.Tzv;
    Object localObject4;
    boolean bool1;
    boolean bool2;
    if (localObject3 != null)
    {
      localObject4 = com.tencent.c.a.a.a.a.a.Zlt;
      if ((com.tencent.c.a.a.a.a.a.imX()) && (((cry)localObject3).TzH > 0))
      {
        bool1 = true;
        boolean bool4 = com.tencent.mm.modelcontrol.e.bkD();
        if ((!bool1) || (!bool4)) {
          break label953;
        }
        bool2 = true;
        label72:
        Log.i(this.TAG, "processLiveSdkParams enableHEVCEncFromSvr:" + bool1 + ", sdkenable:" + ((cry)localObject3).TzH + ", enableHEVCEncFromLocal:" + bool4 + ", isHEVCEncEnable:" + bool2);
        localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
        localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
        kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).fg(bool2);
        if (((cry)localObject3).Tzw > 0)
        {
          localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
          localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).setVideoResolution(((cry)localObject3).Tzw);
        }
        if (((cry)localObject3).Tzy > 0)
        {
          localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
          localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).ta(((cry)localObject3).Tzy);
        }
        if (((cry)localObject3).Tzz > 0)
        {
          localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
          localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).setVideoBitrate(((cry)localObject3).Tzz);
        }
        if (((cry)localObject3).TzG > 0)
        {
          localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
          localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).setMinVideoBitrate(((cry)localObject3).TzG);
        }
        if (((cry)localObject3).TzI > 0)
        {
          localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
          localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).tb(((cry)localObject3).TzI);
        }
        if (((cry)localObject3).TzJ > 0)
        {
          localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
          localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).tc(((cry)localObject3).TzJ);
        }
        if (((cry)localObject3).TzK > 0)
        {
          localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
          localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).td(((cry)localObject3).TzK);
        }
        if (((cry)localObject3).TzL > 0)
        {
          localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
          localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).te(((cry)localObject3).TzL);
        }
        if (((cry)localObject3).TzB > 0)
        {
          localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
          localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
          kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).tf(((cry)localObject3).TzB);
        }
        i = ((cry)localObject3).TzC;
        if (i >= 0) {
          break label959;
        }
      }
    }
    else
    {
      label594:
      if (localObject2 != null)
      {
        if (((cru)localObject2).TyN > 0)
        {
          localObject3 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject3, "ConfigHelper.getInstance()");
          localObject3 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject3).aLK();
          kotlin.g.b.p.j(localObject3, "ConfigHelper.getInstance().audioConfig");
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject3).setAudioQuality(((cru)localObject2).TyN);
        }
        Log.i(this.TAG, "processLiveSdkParams audioQuality:" + ((cru)localObject2).TyN);
      }
      if (localObject1 == null) {
        break label1213;
      }
      Log.i(this.TAG, "userDefineRecordId:" + ((crv)localObject1).TyO + ',' + ((crv)localObject1).TyP);
      localObject2 = ((crv)localObject1).TyP;
      localObject3 = ((crv)localObject1).TyO;
      int j = ((crv)localObject1).TyY;
      bool1 = com.tencent.mm.modelcontrol.e.vW(5);
      localObject4 = ac.ygU;
      ac.oM(bool1);
      i = j;
      if (!bool1)
      {
        i = j;
        if (j == com.tencent.mm.live.core.core.a.kiQ.value) {
          i = ((crv)localObject1).TyZ;
        }
      }
      paramf.kjr = ((crv)localObject1).TyZ;
      if (i >= 100) {
        break label1006;
      }
      paramf.a(com.tencent.mm.live.core.core.model.a.klz);
      paramf.kjq = i;
      label816:
      localObject4 = (Collection)((crv)localObject1).TyU;
      if ((localObject4 != null) && (!((Collection)localObject4).isEmpty())) {
        break label1048;
      }
    }
    label1048:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label1054;
      }
      localObject4 = ((crv)localObject1).TyU;
      kotlin.g.b.p.j(localObject4, "channelParams.cdn_trans_info");
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = (vj)((Iterator)localObject4).next();
        Map localMap = (Map)paramf.kmm;
        i = ((vj)localObject5).SgP;
        localObject5 = ((vj)localObject5).url;
        kotlin.g.b.p.j(localObject5, "it.url");
        localMap.put(Integer.valueOf(i), localObject5);
      }
      bool1 = false;
      break;
      label953:
      bool2 = false;
      break label72;
      label959:
      if (1 < i) {
        break label594;
      }
      localObject4 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
      kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance()");
      localObject4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject4).aLJ();
      kotlin.g.b.p.j(localObject4, "ConfigHelper.getInstance().videoConfig");
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject4).sZ(((cry)localObject3).TzC);
      break label594;
      label1006:
      if (i == com.tencent.mm.live.core.core.a.kiR.value)
      {
        paramf.a(com.tencent.mm.live.core.core.model.a.klA);
        break label816;
      }
      if (i != com.tencent.mm.live.core.core.a.kiS.value) {
        break label816;
      }
      paramf.a(com.tencent.mm.live.core.core.model.a.klB);
      break label816;
    }
    label1054:
    if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil((String)localObject3)))
    {
      localObject4 = new com.tencent.mm.ad.i();
      if (!Util.isNullOrNil((String)localObject2)) {
        ((com.tencent.mm.ad.i)localObject4).g("userdefine_streamid_main", localObject2);
      }
      if (!Util.isNullOrNil((String)localObject3)) {
        ((com.tencent.mm.ad.i)localObject4).g("userdefine_record_id", localObject3);
      }
      localObject2 = new com.tencent.mm.ad.i();
      ((com.tencent.mm.ad.i)localObject2).g("Str_uc_params", localObject4);
      paramTRTCParams.businessInfo = ((com.tencent.mm.ad.i)localObject2).toString();
    }
    kotlin.g.b.p.k(localObject1, "<set-?>");
    paramf.kmo = ((crv)localObject1);
    Log.i(this.TAG, "processLiveSdkParams cdnQualitySvrcfg" + paramf.kjq + " cdnSwitchMode:" + paramf.kml + " cdn_quality_h265backcfg:" + paramf.kjr);
    label1213:
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfz = ((crv)localObject1).Tza;
      paramTRTCParams = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (paramcrx.Tzv.Tzb == 1)
      {
        bool1 = true;
        paramTRTCParams.zfN = bool1;
        paramTRTCParams = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        bool1 = bool3;
        if (paramcrx.Tzv.Tzc == 1) {
          bool1 = true;
        }
        paramTRTCParams.zfO = bool1;
      }
    }
    else
    {
      paramcrx = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.eej())
      {
        paramcrx = com.tencent.c.a.a.a.a.a.Zlt;
        if (com.tencent.c.a.a.a.a.a.imZ()) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfz = 1;
        }
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgD = com.tencent.mm.ae.d.dr(paramf.kmn, 2);
      paramTRTCParams = this.TAG;
      localObject2 = new StringBuilder("processLiveSdkParams support_screen_rotate:");
      if (localObject1 == null) {
        break label1490;
      }
    }
    label1490:
    for (paramcrx = Integer.valueOf(((crv)localObject1).Tza);; paramcrx = null)
    {
      paramcrx = ((StringBuilder)localObject2).append(paramcrx).append(",config:");
      localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
      Log.i(paramTRTCParams, com.tencent.c.a.a.a.a.a.imZ() + ", qosReport:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfN + ", qosControl:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfO + ", seiMode:" + paramf.kmn);
      AppMethodBeat.o(286971);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static com.tencent.mm.plugin.wallet.wecoin.a.b ao(Activity paramActivity)
  {
    AppMethodBeat.i(286996);
    kotlin.g.b.p.k(paramActivity, "context");
    paramActivity = ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).ao(paramActivity);
    AppMethodBeat.o(286996);
    return paramActivity;
  }
  
  private final bid dxT()
  {
    AppMethodBeat.i(286949);
    Object localObject = new bid();
    Context localContext = this.context;
    if (localContext != null)
    {
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.lm(localContext).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    }
    AppMethodBeat.o(286949);
    return localObject;
  }
  
  public final void K(final kotlin.g.a.b<? super Long, kotlin.x> paramb)
  {
    AppMethodBeat.i(286992);
    Log.i(this.TAG, "[WeCoin] getWeCoinBalance");
    ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).a((com.tencent.mm.plugin.wallet.wecoin.a.e)new z(this, paramb));
    AppMethodBeat.o(286992);
  }
  
  public final void Li(long paramLong)
  {
    AppMethodBeat.i(286978);
    boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziL.contains(Long.valueOf(paramLong));
    Log.i(this.TAG, "announceGotoShopping productId:" + paramLong + ", haveBug:" + bool);
    if ((paramLong != 0L) && (!bool))
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziL.add(Long.valueOf(paramLong));
      a("", 10012, null);
    }
    AppMethodBeat.o(286978);
  }
  
  public final void Nn(int paramInt)
  {
    AppMethodBeat.i(286956);
    Log.i(this.TAG, "[likeInfo] doLikeLive:".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      AppMethodBeat.o(286956);
      return;
    }
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zfk += paramInt;
    localObject1 = dxT();
    Object localObject2 = com.tencent.mm.plugin.finder.cgi.ao.xcj;
    localObject2 = com.tencent.mm.plugin.finder.cgi.ao.a((bid)localObject1);
    byte[] arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN;
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk;
    String str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId;
    String str2 = com.tencent.mm.model.z.bdh();
    kotlin.g.b.p.j(str2, "ConfigStorageLogic.getMyFinderUsername()");
    localObject1 = new com.tencent.mm.plugin.finder.live.model.cgi.m((aqe)localObject2, arrayOfByte, l1, paramInt, l2, str1, str2, (bid)localObject1).bhW().g((com.tencent.mm.vending.c.a)new r(this));
    if ((this.context != null) && ((this.context instanceof MMActivity))) {
      ((com.tencent.mm.cw.f)localObject1).a((com.tencent.mm.vending.e.b)this.context);
    }
    AppMethodBeat.o(286956);
  }
  
  public final com.tencent.mm.plugin.wallet.wecoin.a.d a(FragmentActivity paramFragmentActivity, int paramInt, kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(286993);
    kotlin.g.b.p.k(paramFragmentActivity, "context");
    kotlin.g.b.p.k(parama, "callback");
    String str = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbu();
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      Log.i(this.TAG, "showRechargeFoodsDialog sessionId:".concat(String.valueOf(str)));
      paramFragmentActivity = ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).a(paramFragmentActivity, paramInt, str, (com.tencent.mm.plugin.wallet.wecoin.a.e)new e.ai(this, paramFragmentActivity, parama));
      AppMethodBeat.o(286993);
      return paramFragmentActivity;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, ad.a parama)
  {
    AppMethodBeat.i(287008);
    parama = new ad(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, com.tencent.mm.model.z.bdh(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, paramInt1, paramInt2, parama).bhW();
    if ((this.context != null) && ((this.context instanceof MMActivity))) {
      parama.a((com.tencent.mm.vending.e.b)this.context);
    }
    AppMethodBeat.o(287008);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, com.tencent.mm.plugin.finder.live.model.cgi.g.a parama)
  {
    AppMethodBeat.i(286984);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    boolean bool = com.tencent.mm.plugin.finder.live.utils.a.dEy();
    Object localObject3 = this.TAG;
    Object localObject2 = new StringBuilder("closeLinkMic isAnchor:").append(bool).append(", linkMicState:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhn).append(", liveId:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId).append(", objectId:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk).append(", nonceId:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId).append(", scene:").append(paramInt).append(", userId:");
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).ktR;; localObject1 = null)
    {
      StringBuilder localStringBuilder = ((StringBuilder)localObject2).append((String)localObject1).append(", selfSdkId:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGU()).append(", sessionId:");
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhl;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).sessionId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Log.i((String)localObject3, (String)localObject1 + ", applySessionId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhi);
      long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
      long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId;
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN;
      localObject1 = paramString1;
      if (paramString1 == null) {
        localObject1 = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      paramString2 = new axe();
      paramString2.session_id = paramString1;
      paramString1 = new axo();
      paramString1.SnB = ((String)localObject1);
      paramString2.SJE = com.tencent.mm.cd.b.cU(paramString1.toByteArray());
      paramString2.msg_type = 20005;
      paramString1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      paramString2.SJs = com.tencent.mm.plugin.finder.utils.aj.eet();
      new com.tencent.mm.plugin.finder.live.model.cgi.g(l1, l2, (String)localObject2, (byte[])localObject3, paramInt, paramString2, parama).bhW();
      AppMethodBeat.o(286984);
      return;
    }
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, aza paramaza, com.tencent.mm.plugin.finder.live.model.cgi.h.a parama)
  {
    AppMethodBeat.i(286989);
    Log.i(this.TAG, "closeLinkMicPk liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ", objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk + ", nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId + ", scene:" + paramInt + ", closeScene:1, sdkUserId:" + paramString1 + ", sessionId:" + paramString2);
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk;
    String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId;
    byte[] arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN;
    axe localaxe = new axe();
    localaxe.SJC = paramaza;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramaza);
    localaxe.SJG = localLinkedList;
    localaxe.session_id = paramString2;
    paramString2 = new axp();
    paramString2.SnB = paramString1;
    paramString2.scene = 1;
    localaxe.SJE = com.tencent.mm.cd.b.cU(paramString2.toByteArray());
    localaxe.msg_type = 20017;
    paramString1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localaxe.SJs = com.tencent.mm.plugin.finder.utils.aj.eet();
    new com.tencent.mm.plugin.finder.live.model.cgi.h(l1, l2, str, arrayOfByte, paramInt, localaxe, parama).bhW();
    AppMethodBeat.o(286989);
  }
  
  public final void a(int paramInt, final kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super aqs, kotlin.x> params)
  {
    AppMethodBeat.i(286954);
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk;
    Log.i(this.TAG, "doCloseLive liveId:" + l1 + " objectId:" + l2 + " nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId);
    if ((l1 == 0L) || (l2 == 0L))
    {
      Log.i(this.TAG, "doCloseLive return by invalid params");
      AppMethodBeat.o(286954);
      return;
    }
    String str = com.tencent.mm.model.z.bdh();
    kotlin.g.b.p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
    new com.tencent.mm.plugin.finder.live.model.cgi.f(l1, str, l2, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId, paramInt, (f.a)new f(this, params)).bhW();
    EventCenter.instance.publish((IEvent)new hp());
    AppMethodBeat.o(286954);
  }
  
  public final void a(long paramLong, int paramInt, kotlin.g.a.u<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.live.core.core.model.f, ? super TRTCCloudDef.TRTCParams, ? super awj, kotlin.x> paramu)
  {
    AppMethodBeat.i(286951);
    com.tencent.mm.ae.d.c(this.TAG, (kotlin.g.a.a)new e.q(this, paramInt, paramLong, paramu));
    AppMethodBeat.o(286951);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.live.cgi.d.a parama)
  {
    AppMethodBeat.i(286965);
    Log.i(this.TAG, "setAnchorStatus liveId:" + paramLong1 + " objectId:" + paramLong2 + " flag:" + paramInt1 + " micSetting[" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhx.TFP + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhx.TFQ + ']');
    String str = com.tencent.mm.model.z.bdh();
    kotlin.g.b.p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
    long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhx.TFP;
    azh localazh = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfD;
    if (localazh != null) {}
    for (int i = localazh.SLe;; i = 0)
    {
      new com.tencent.mm.plugin.finder.live.cgi.d(paramLong1, paramLong2, paramInt1, str, paramInt2, l, i, parama).bhW();
      AppMethodBeat.o(286965);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, com.tencent.mm.plugin.finder.live.cgi.d.a parama)
  {
    AppMethodBeat.i(286966);
    Log.i(this.TAG, "setMicSetting liveId:" + paramLong1 + " objectId:" + paramLong2 + " micSettingFlag:" + paramLong3 + " BUPROVIDER.get(LiveLinkMicSlice::class.java).micSetting[" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhx.TFP + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhx.TFQ + ']');
    int j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa;
    String str = com.tencent.mm.model.z.bdh();
    kotlin.g.b.p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
    azh localazh = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfD;
    if (localazh != null) {}
    for (int i = localazh.SLe;; i = 0)
    {
      new com.tencent.mm.plugin.finder.live.cgi.d(paramLong1, paramLong2, j, str, 0, paramLong3, i, parama, 16).bhW();
      AppMethodBeat.o(286966);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt1, aza paramaza, int paramInt2, com.tencent.mm.plugin.finder.live.model.cgi.d.a parama)
  {
    AppMethodBeat.i(286982);
    Log.i(this.TAG, "applyLinkMic liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString + ", scene:" + paramInt1 + ", micType:" + paramInt2);
    axe localaxe = new axe();
    localaxe.SJC = paramaza;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramaza);
    localaxe.SJG = localLinkedList;
    paramaza = new axk();
    paramaza.SJK = paramInt2;
    localaxe.SJE = com.tencent.mm.cd.b.cU(paramaza.toByteArray());
    localaxe.msg_type = 20003;
    paramaza = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localaxe.SJs = com.tencent.mm.plugin.finder.utils.aj.eet();
    new com.tencent.mm.plugin.finder.live.model.cgi.d(paramLong1, paramLong2, paramString, paramArrayOfByte, paramInt1, localaxe, parama).bhW();
    AppMethodBeat.o(286982);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, aza paramaza, int paramInt2, String paramString2, String paramString3, com.tencent.mm.plugin.finder.live.model.cgi.a.a parama)
  {
    AppMethodBeat.i(286983);
    Log.i(this.TAG, "acceptLinkMic liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString1 + ", scene:" + paramInt1 + ", micType:" + paramInt2 + ", userId:" + paramString2 + ", sessionId:" + paramString3);
    axe localaxe = new axe();
    localaxe.session_id = paramString3;
    localaxe.SJC = paramaza;
    paramaza = new axg();
    paramaza.SJK = paramInt2;
    paramaza.SnB = paramString2;
    localaxe.SJE = com.tencent.mm.cd.b.cU(paramaza.toByteArray());
    localaxe.msg_type = 20004;
    paramaza = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localaxe.SJs = com.tencent.mm.plugin.finder.utils.aj.eet();
    new com.tencent.mm.plugin.finder.live.model.cgi.a(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt1, localaxe, parama).bhW();
    AppMethodBeat.o(286983);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, aza paramaza, String paramString2, int paramInt2, com.tencent.mm.plugin.finder.live.model.cgi.e.a parama)
  {
    AppMethodBeat.i(286987);
    Log.i(this.TAG, "applyLinkMicPk liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString1 + ", scene:" + paramInt1 + ", sdkUserId:" + paramString2 + ", sdkLiveId:" + paramInt2);
    axe localaxe = new axe();
    localaxe.SJC = paramaza;
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramaza);
    localaxe.SJG = ((LinkedList)localObject);
    axl localaxl = new axl();
    paramaza = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
    int i;
    if (paramaza != null)
    {
      paramaza = paramaza.objectDesc;
      if (paramaza != null)
      {
        paramaza = paramaza.liveDesc;
        if (paramaza != null)
        {
          paramaza = paramaza.zfA;
          localObject = (CharSequence)paramaza;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label388;
          }
          i = 1;
          label209:
          if (i == 0) {
            break label394;
          }
          paramaza = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
          if (paramaza != null)
          {
            paramaza = paramaza.objectDesc;
            if (paramaza != null)
            {
              paramaza = paramaza.media;
              if (paramaza != null)
              {
                paramaza = (FinderMedia)kotlin.a.j.lp((List)paramaza);
                if (paramaza != null)
                {
                  localObject = paramaza.url;
                  paramaza = (aza)localObject;
                  if (localObject != null) {
                    break label297;
                  }
                }
              }
            }
          }
          paramaza = "";
        }
      }
    }
    label388:
    label394:
    for (;;)
    {
      label297:
      localaxl.SKa = paramaza;
      localaxl.SJO = paramString2;
      localaxl.SJP = paramInt2;
      localaxe.SJE = com.tencent.mm.cd.b.cU(localaxl.toByteArray());
      localaxe.msg_type = 20015;
      paramaza = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localaxe.SJs = com.tencent.mm.plugin.finder.utils.aj.eet();
      new com.tencent.mm.plugin.finder.live.model.cgi.e(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt1, localaxe, parama).bhW();
      AppMethodBeat.o(286987);
      return;
      paramaza = null;
      break;
      i = 0;
      break label209;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, aza paramaza, String paramString2, int paramInt2, String paramString3, b.a parama)
  {
    AppMethodBeat.i(286988);
    Log.i(this.TAG, "acceptLinkMicPk liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString1 + ", scene:" + paramInt1 + ", sdkUserId:" + paramString2 + ", sdkLiveId:" + paramInt2 + ", sessionId:" + paramString3);
    axe localaxe = new axe();
    localaxe.SJC = paramaza;
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramaza);
    localaxe.SJG = ((LinkedList)localObject);
    localaxe.session_id = paramString3;
    axh localaxh = new axh();
    paramString3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
    int i;
    if (paramString3 != null)
    {
      paramString3 = paramString3.objectDesc;
      if (paramString3 != null)
      {
        paramString3 = paramString3.liveDesc;
        if (paramString3 != null)
        {
          paramString3 = paramString3.zfA;
          localObject = (CharSequence)paramString3;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label434;
          }
          i = 1;
          label227:
          if (i == 0) {
            break label440;
          }
          paramString3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
          if (paramString3 != null)
          {
            paramString3 = paramString3.objectDesc;
            if (paramString3 != null)
            {
              paramString3 = paramString3.media;
              if (paramString3 != null)
              {
                paramString3 = (FinderMedia)kotlin.a.j.lp((List)paramString3);
                if (paramString3 != null)
                {
                  localObject = paramString3.url;
                  paramString3 = (String)localObject;
                  if (localObject != null) {
                    break label315;
                  }
                }
              }
            }
          }
          paramString3 = "";
        }
      }
    }
    label434:
    label440:
    for (;;)
    {
      label315:
      localaxh.SJR = paramString3;
      paramString3 = paramaza.SKa;
      paramaza = paramString3;
      if (paramString3 == null) {
        paramaza = "";
      }
      localaxh.SJQ = paramaza;
      localaxh.SJO = paramString2;
      localaxh.SJP = paramInt2;
      localaxe.SJE = com.tencent.mm.cd.b.cU(localaxh.toByteArray());
      localaxe.msg_type = 20016;
      paramaza = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localaxe.SJs = com.tencent.mm.plugin.finder.utils.aj.eet();
      new com.tencent.mm.plugin.finder.live.model.cgi.b(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt1, localaxe, parama).bhW();
      AppMethodBeat.o(286988);
      return;
      paramString3 = null;
      break;
      i = 0;
      break label227;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, aza paramaza, String paramString2, o.a parama)
  {
    AppMethodBeat.i(287010);
    Log.i(this.TAG, "acceptBattle liveId:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " battleId:" + paramString2);
    axe localaxe = new axe();
    localaxe.session_id = paramString2;
    localaxe.SJC = paramaza;
    paramString2 = new LinkedList();
    paramString2.add(paramaza);
    localaxe.SJG = paramString2;
    localaxe.SJE = com.tencent.mm.cd.b.cU(new axf().toByteArray());
    localaxe.msg_type = 20027;
    paramaza = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localaxe.SJs = com.tencent.mm.plugin.finder.utils.aj.eet();
    new com.tencent.mm.plugin.finder.live.model.cgi.o(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt, localaxe).bhW().g((com.tencent.mm.vending.c.a)new e.b(parama));
    AppMethodBeat.o(287010);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, aza paramaza, String paramString2, p.a parama)
  {
    AppMethodBeat.i(287009);
    Log.i(this.TAG, "applyBattle liveId:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " micId:" + paramString2);
    axe localaxe = new axe();
    localaxe.SJC = paramaza;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramaza);
    localaxe.SJG = localLinkedList;
    paramaza = new axj();
    paramaza.SJW = paramString2;
    localaxe.SJE = com.tencent.mm.cd.b.cU(paramaza.toByteArray());
    localaxe.msg_type = 20026;
    paramaza = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localaxe.SJs = com.tencent.mm.plugin.finder.utils.aj.eet();
    new com.tencent.mm.plugin.finder.live.model.cgi.p(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt, localaxe).bhW().g((com.tencent.mm.vending.c.a)new e.c(parama));
    AppMethodBeat.o(287009);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, aza paramaza, String paramString2, t.a parama)
  {
    AppMethodBeat.i(287011);
    Log.i(this.TAG, "closeBattle liveId:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " micId:" + paramString2);
    axe localaxe = new axe();
    localaxe.session_id = paramString2;
    localaxe.SJC = paramaza;
    paramString2 = new LinkedList();
    paramString2.add(paramaza);
    localaxe.SJG = paramString2;
    paramaza = new axn();
    paramaza.scene = paramaza.scene;
    localaxe.SJE = com.tencent.mm.cd.b.cU(paramaza.toByteArray());
    localaxe.msg_type = 20028;
    paramaza = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localaxe.SJs = com.tencent.mm.plugin.finder.utils.aj.eet();
    new com.tencent.mm.plugin.finder.live.model.cgi.t(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt, localaxe).bhW().g((com.tencent.mm.vending.c.a)new e.e(parama));
    AppMethodBeat.o(287011);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, ag.a parama)
  {
    AppMethodBeat.i(286985);
    Log.i(this.TAG, "refreshLinkMic liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString1 + ", scene:" + paramInt + ", sdkUserId:" + paramString2);
    new ag(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt, paramString2, parama).bhW();
    AppMethodBeat.o(286985);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, List<String> paramList, y.a parama)
  {
    AppMethodBeat.i(287005);
    kotlin.g.b.p.k(paramString, "nonceId");
    kotlin.g.b.p.k(paramList, "sendIdList");
    paramString = new y(paramLong1, paramLong2, paramString, paramArrayOfByte, paramInt, paramList).bhW().g((com.tencent.mm.vending.c.a)new e.w(parama));
    if ((this.context != null) && ((this.context instanceof MMActivity))) {
      paramString.a((com.tencent.mm.vending.e.b)this.context);
    }
    AppMethodBeat.o(287005);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(287004);
    new am(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramString2).bhW();
    AppMethodBeat.o(287004);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2, c.a parama)
  {
    AppMethodBeat.i(286990);
    Log.i(this.TAG, "activateLiveMic liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString1 + ", scene:1, sessionId:" + paramString2);
    new com.tencent.mm.plugin.finder.live.model.cgi.c(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramString2, parama).bhW();
    AppMethodBeat.o(286990);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, LinkedList<String> paramLinkedList, q.a parama)
  {
    AppMethodBeat.i(286986);
    kotlin.g.b.p.k(paramLinkedList, "usernameList");
    Log.i(this.TAG, "batchGetMicContact liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString + ", scene:1");
    new com.tencent.mm.plugin.finder.live.model.cgi.q(paramLong1, paramLong2, paramString, paramArrayOfByte, paramLinkedList, parama).bhW();
    AppMethodBeat.o(286986);
  }
  
  public final void a(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, int paramInt, LinkedList<Integer> paramLinkedList, r.a parama)
  {
    AppMethodBeat.i(287006);
    kotlin.g.b.p.k(paramLinkedList, "songIdList");
    kotlin.g.b.p.k(parama, "callback");
    paramArrayOfByte = new com.tencent.mm.plugin.finder.live.model.cgi.r(paramLong1, paramArrayOfByte, paramString, paramLong2, paramInt, paramLinkedList, parama).bhW();
    if ((this.context != null) && ((this.context instanceof MMActivity))) {
      paramArrayOfByte.a((com.tencent.mm.vending.e.b)this.context);
    }
    AppMethodBeat.o(287006);
  }
  
  public final void a(Activity paramActivity, bbx parambbx, ResultReceiver paramResultReceiver, kotlin.g.a.b<? super Integer, kotlin.x> paramb)
  {
    AppMethodBeat.i(286998);
    kotlin.g.b.p.k(paramActivity, "context");
    kotlin.g.b.p.k(parambbx, "luckyMoneySendInfo");
    Log.i(this.TAG, "goReceiveLuckyMoney visitorRole:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.SJy);
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.SJy == 3)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        paramb.invoke(Integer.valueOf(1));
        com.tencent.mm.plugin.finder.live.report.m.yCt.a(s.au.yJZ, s.at.yJN, true);
        AppMethodBeat.o(286998);
        return;
      }
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.SJy == 2)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        paramb.invoke(Integer.valueOf(2));
        com.tencent.mm.plugin.finder.live.report.m.yCt.a(s.au.yJZ, s.at.yJN, true);
        AppMethodBeat.o(286998);
        return;
      }
    }
    Object localObject2;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.SJy != 1)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.dEy()) {}
    }
    else
    {
      localObject1 = null;
      localObject2 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class);
      kotlin.g.b.p.j(localObject2, "MMKernel.service(IHellBizService::class.java)");
      localObject2 = ((com.tencent.mm.plugin.expt.b.c)localObject2).dbu();
      if (localObject2 != null) {
        break label607;
      }
      localObject2 = "";
    }
    label288:
    label587:
    label607:
    for (;;)
    {
      k.b localb = k.b.OQ(parambbx.SMy);
      int i;
      if (Util.isNullOrNil(parambbx.SKx))
      {
        i = 1;
        localBundle.putInt("key_live_anchor_type", i);
        localBundle.putString("key_live_error_msg", (String)localObject1);
        localBundle.putString("key_live_id", com.tencent.mm.ae.d.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId));
        localBundle.putString("key_live_attach", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zga.zeU);
        localBundle.putInt("key_from", 3);
        localBundle.putString("key_session_id", (String)localObject2);
        localBundle.putString("key_username", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
        if (paramResultReceiver == null) {
          break label587;
        }
      }
      for (parambbx = (Parcelable)paramResultReceiver;; parambbx = (Parcelable)new ResultReceiver(MMHandler.createFreeHandler(Looper.getMainLooper())))
      {
        localBundle.putParcelable("key_open_result_receiver", parambbx);
        ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).gotoLuckyMoneyReceiveUI((Context)paramActivity, localBundle, localb);
        Log.i(this.TAG, "goReceiveLuckyMoney liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ", clientBuff:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zga.zeU + ", sessionId:" + (String)localObject2 + ", anchorUsername:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ", appMsgContent:" + localb);
        paramb.invoke(Integer.valueOf(0));
        AppMethodBeat.o(286998);
        return;
        localObject1 = paramActivity.getResources().getString(b.j.finder_live_open_lucky_money_refuse_tip_role);
        break;
        i = 2;
        break label288;
      }
    }
  }
  
  public final void a(Context paramContext, long paramLong1, long paramLong2, int paramInt, com.tencent.mm.plugin.finder.live.cgi.d.a parama)
  {
    AppMethodBeat.i(286967);
    kotlin.g.b.p.k(paramContext, "context");
    Log.i(this.TAG, "setGameTeamMode liveId:" + paramLong1 + " objectId:" + paramLong2 + " gameTeamMode:" + paramInt);
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa;
    String str = com.tencent.mm.model.z.bdh();
    kotlin.g.b.p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
    new com.tencent.mm.plugin.finder.live.cgi.d(paramLong1, paramLong2, i, str, 0, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhx.TFP, paramInt, parama, 16).e(paramContext, paramContext.getResources().getString(b.j.finder_waiting), 500L).bhW();
    AppMethodBeat.o(286967);
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, Long paramLong1)
  {
    AppMethodBeat.i(286976);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramString, "username");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfn = false;
    com.tencent.mm.plugin.finder.feed.logic.a locala = com.tencent.mm.plugin.finder.feed.logic.a.xFq;
    com.tencent.mm.plugin.finder.feed.logic.a.a(paramContext, paramLong, paramString, paramLong1, 62);
    AppMethodBeat.o(286976);
  }
  
  public final void a(Context paramContext, Intent paramIntent, Integer paramInteger)
  {
    AppMethodBeat.i(286977);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramIntent, "intent");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfn = false;
    if (paramInteger != null)
    {
      com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent, paramInteger.intValue());
      AppMethodBeat.o(286977);
      return;
    }
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    AppMethodBeat.o(286977);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg, com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(286972);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramg, "bundle");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("open fullscreen miniPro appId:").append(paramg.appId).append(",patch:").append(paramg.nBq).append(",luanchFromApp:true,is test:");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    Log.i(str, com.tencent.mm.plugin.finder.live.utils.a.dEO());
    if ((Util.isNullOrNil(paramg.appId)) || (Util.isNullOrNil(paramg.nBq)))
    {
      AppMethodBeat.o(286972);
      return;
    }
    paramg.nBF = true;
    a(paramContext, paramg, true, parama);
    AppMethodBeat.o(286972);
  }
  
  public final void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, be.a parama)
  {
    AppMethodBeat.i(286969);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramString3, "sendGiftTargetUserName");
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGF())
    {
      Object localObject1 = m.yfw;
      if (!m.getDebug())
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(1581, 70);
        localObject1 = com.tencent.mm.model.z.bdh();
        Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject2 = com.tencent.mm.plugin.finder.utils.aj.eet();
        com.tencent.mm.plugin.report.service.h.IzE.a(22129, new Object[] { Integer.valueOf(1), localObject2, "", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "" });
        Object localObject3 = com.tencent.mm.ui.component.g.Xox;
        localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.lm(paramContext).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
        new ai(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, paramString1, paramInt1, (String)localObject1, paramInt2, (String)localObject2, paramString2, paramString3, (bid)localObject3, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).sessionBuffer, (ai.a)new e.u(this, paramInt2, parama, (String)localObject2, paramContext, paramString1, paramInt1, paramString2)).bhW();
      }
    }
    AppMethodBeat.o(286969);
  }
  
  public final void a(s.a parama)
  {
    AppMethodBeat.i(286958);
    com.tencent.mm.plugin.finder.cgi.ao localao = com.tencent.mm.plugin.finder.cgi.ao.xcj;
    new com.tencent.mm.plugin.finder.live.model.cgi.s(com.tencent.mm.plugin.finder.cgi.ao.dnO(), com.tencent.mm.model.z.bdh(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfh, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN, parama).bhW();
    AppMethodBeat.o(286958);
  }
  
  public final void a(blm paramblm)
  {
    AppMethodBeat.i(286959);
    kotlin.g.b.p.k(paramblm, "product");
    if (paramblm.zaV == 0)
    {
      Log.i(this.TAG, "[getProductDetail] product:" + paramblm.title + ',' + paramblm.zaO + " is not promotting, return ");
      AppMethodBeat.o(286959);
      return;
    }
    new com.tencent.mm.plugin.finder.live.model.cgi.z(this.buContext, paramblm.zaO, (z.a)new x(this)).bhW();
    AppMethodBeat.o(286959);
  }
  
  public final void a(MMActivity paramMMActivity, long paramLong1, long paramLong2, String paramString, aqt paramaqt, kotlin.g.a.m<? super Boolean, ? super bbc, kotlin.x> paramm)
  {
    AppMethodBeat.i(287013);
    kotlin.g.b.p.k(paramMMActivity, "activity");
    kotlin.g.b.p.k(paramString, "audienceUsername");
    kotlin.g.b.p.k(paramaqt, "finderCmdItem");
    new com.tencent.mm.plugin.finder.live.model.cgi.ac(paramLong1, paramLong2, paramString, paramaqt, (ac.a)new e.ad(paramm)).bhW().a((com.tencent.mm.vending.e.b)paramMMActivity);
    AppMethodBeat.o(287013);
  }
  
  public final void a(MMActivity paramMMActivity, long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, final kotlin.g.a.b<? super Boolean, kotlin.x> paramb)
  {
    AppMethodBeat.i(287012);
    kotlin.g.b.p.k(paramMMActivity, "activity");
    kotlin.g.b.p.k(paramString, "anchorUsername");
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    final int i;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziF) {
        i = 2;
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.model.z.bdh();
      kotlin.g.b.p.j(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      new aa(paramLong1, paramLong2, paramString, paramArrayOfByte, i, (String)localObject, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).fIY, (aa.a)new y(this, paramb, i)).bhW().a((com.tencent.mm.vending.e.b)paramMMActivity);
      AppMethodBeat.o(287012);
      return;
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public final void a(String paramString, int paramInt, final u.a parama)
  {
    AppMethodBeat.i(286961);
    kotlin.g.b.p.k(paramString, "commentContent");
    bid localbid = dxT();
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localObject = com.tencent.mm.plugin.finder.utils.aj.eet();
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgh.add(localObject);
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
    byte[] arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk;
    String str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId;
    String str2 = com.tencent.mm.model.z.bdh();
    kotlin.g.b.p.j(str2, "ConfigStorageLogic.getMyFinderUsername()");
    new com.tencent.mm.plugin.finder.live.model.cgi.u(l1, paramString, paramInt, arrayOfByte, l2, str1, str2, localbid, (String)localObject, (u.a)new t(this, parama)).bhW();
    AppMethodBeat.o(286961);
  }
  
  public final void a(String paramString, com.tencent.mm.cd.b paramb, final x.a parama)
  {
    AppMethodBeat.i(286981);
    kotlin.g.b.p.k(paramString, "lotteryId");
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    int i;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      localObject1 = l.k.kuV;
      i = l.k.aNV();
      localObject1 = com.tencent.mm.model.z.bdh();
      kotlin.g.b.p.j(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo;
      if (localObject2 == null) {
        break label175;
      }
    }
    label175:
    for (Object localObject2 = Long.valueOf(((bac)localObject2).liveId);; localObject2 = null)
    {
      new com.tencent.mm.plugin.finder.live.model.cgi.x(i, (String)localObject1, ((Long)localObject2).longValue(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId, paramString, paramb, (x.a)new v(this, parama)).bhW();
      AppMethodBeat.o(286981);
      return;
      localObject1 = l.k.kuV;
      i = l.k.aNW();
      localObject1 = "";
      break;
    }
  }
  
  public final void a(final String paramString, final boolean paramBoolean, final kotlin.g.a.m<? super Boolean, ? super Boolean, kotlin.x> paramm)
  {
    AppMethodBeat.i(286962);
    if (paramString != null)
    {
      new com.tencent.mm.plugin.finder.live.cgi.e(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, paramString, paramBoolean, (com.tencent.mm.plugin.finder.live.cgi.e.a)new i(this, paramBoolean, paramString, paramm)).bhW();
      AppMethodBeat.o(286962);
      return;
    }
    AppMethodBeat.o(286962);
  }
  
  public final void a(List<String> paramList, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(287003);
    kotlin.g.b.p.k(paramList, "toUser");
    kotlin.g.b.p.k(paramFinderItem, "feedObject");
    Log.i(this.TAG, "[autoTransMmitLive] group size:" + paramList.size() + ",mediaList:" + paramFinderItem.getLiveMediaList().size());
    if (!paramList.isEmpty())
    {
      localObject = (Collection)paramFinderItem.getLiveMediaList();
      if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
        break label111;
      }
    }
    label111:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(287003);
      return;
    }
    Object localObject = new k.b();
    com.tencent.mm.plugin.findersdk.a.b localb = new com.tencent.mm.plugin.findersdk.a.b();
    localb.b(paramFinderItem.getFinderLive());
    ((k.b)localObject).a((com.tencent.mm.aj.f)localb);
    ((k.b)localObject).type = 63;
    ((k.b)localObject).title = MMApplicationContext.getContext().getString(b.j.low_version_upgrade_tip);
    ((k.b)localObject).url = MMApplicationContext.getContext().getString(b.j.low_version_upgrade_url);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      paramFinderItem = (String)paramList.next();
      w.a.bbx().a((k.b)localObject, "", "", paramFinderItem, "", null);
    }
    AppMethodBeat.o(287003);
  }
  
  public final void a(kotlin.g.a.u<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super Integer, ? super String, ? super art, kotlin.x> paramu)
  {
    AppMethodBeat.i(286952);
    LinkedList localLinkedList1 = new LinkedList();
    if (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziS, 1))
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localLinkedList1.addAll((Collection)com.tencent.mm.plugin.finder.live.utils.a.eu(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziR));
    }
    LinkedList localLinkedList2 = new LinkedList();
    if (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziS, 2)) {
      localLinkedList2.addAll((Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziT);
    }
    LinkedList localLinkedList3 = new LinkedList();
    if (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziS, 4)) {
      localLinkedList3.addAll((Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziU);
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy) {}
    for (Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgz;; localObject = "")
    {
      Log.i(this.TAG, "doCreateLive luckyMoneyChatRoom:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zga.zeT + " visibilityMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziS + " visibilityList:" + localLinkedList1 + " visibilityRoomList:" + localLinkedList2 + " externalPost:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy + " appid:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgz);
      new com.tencent.mm.plugin.finder.live.model.cgi.i(com.tencent.mm.model.z.bdh(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).zgW, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeG, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziS, localLinkedList1, localLinkedList2, localLinkedList3, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zga.zeT, (String)localObject, (i.a)new e.h(this, paramu), (byte)0).bhW();
      AppMethodBeat.o(286952);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, String paramString, bid parambid)
  {
    AppMethodBeat.i(287001);
    kotlin.g.b.p.k(paramString, "finderUsername");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_profile_share_scene", 0);
    if (paramBoolean) {
      if (Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig))
      {
        localIntent.putExtra("finder_username", "");
        localIntent.putExtra("key_finder_object_Id", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk);
        localIntent.putExtra("key_finder_object_nonce_id_key", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId);
      }
    }
    for (;;)
    {
      localIntent.putExtra("key_enter_profile_type", 11);
      if (parambid != null)
      {
        paramString = parambid.wmL;
        parambid = parambid.wmz;
        if (!TextUtils.isEmpty((CharSequence)paramString)) {
          localIntent.putExtra("key_context_id", paramString);
        }
        if (!TextUtils.isEmpty((CharSequence)parambid)) {
          localIntent.putExtra("key_click_tab_context_id", parambid);
        }
      }
      if (this.context != null)
      {
        paramString = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        aj.a.a(this.context, localIntent, 0L, 0, false, 124);
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderProfileUI(this.context, localIntent);
      }
      AppMethodBeat.o(287001);
      return;
      localIntent.putExtra("finder_username", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
      continue;
      localIntent.putExtra("finder_username", paramString);
    }
  }
  
  public final void a(boolean paramBoolean, final kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.plugin.finder.live.viewmodel.data.a, kotlin.x> params)
  {
    AppMethodBeat.i(286953);
    Log.i(this.TAG, "doFinishLive manualFinish:" + paramBoolean + " isSecondDaryDevice:false");
    if (!paramBoolean)
    {
      ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getLiveInfo(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, (com.tencent.c.a.a.a.b.d)new j(this, params));
      AppMethodBeat.o(286953);
      return;
    }
    if (paramBoolean)
    {
      params = (kotlin.g.a.s)new k(this, params);
      Log.i(this.TAG, "doManualCloseLive liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + " objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk + " nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId);
      new com.tencent.mm.plugin.finder.live.model.cgi.an(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId, (com.tencent.mm.plugin.finder.live.model.cgi.an.a)new s(this, params)).bhW();
      EventCenter.instance.publish((IEvent)new hp());
      AppMethodBeat.o(286953);
      return;
    }
    an.a.a(this, (kotlin.g.a.s)new l(params));
    AppMethodBeat.o(286953);
  }
  
  public final void aBW(String paramString)
  {
    AppMethodBeat.i(286960);
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      paramString = new cr(paramString, 0L, null, 0, null, 0, 0L, 104);
      paramString.xer = true;
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramString);
      AppMethodBeat.o(286960);
      return;
    }
  }
  
  public final void aBX(final String paramString)
  {
    AppMethodBeat.i(286963);
    if (paramString != null)
    {
      new com.tencent.mm.plugin.finder.live.cgi.h(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, paramString, (com.tencent.mm.plugin.finder.live.cgi.h.a)new m(this, paramString)).bhW();
      AppMethodBeat.o(286963);
      return;
    }
    AppMethodBeat.o(286963);
  }
  
  public final void ah(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(287007);
    kotlin.g.b.p.k(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.recordvideo.e.a.IeL;
    boolean bool = com.tencent.mm.plugin.recordvideo.e.a.M(paramContext, "com.tencent.qqmusic", "CBD27CD7C861227D013A25B2D10F0799");
    Log.i(this.TAG, "goQQMusic isInstalled:" + bool + " songId:" + paramInt + " songmid:0");
    if (bool)
    {
      com.tencent.mm.ui.base.h.c(paramContext, paramContext.getResources().getString(b.j.finder_secondcut_jump_tip, new Object[] { paramContext.getResources().getString(b.j.finder_qq_music) }), "", paramContext.getResources().getString(b.j.app_ok), paramContext.getResources().getString(b.j.app_cancel), (DialogInterface.OnClickListener)new e.aa(this, paramInt, 0, paramContext), (DialogInterface.OnClickListener)new e.ab(this));
      AppMethodBeat.o(287007);
      return;
    }
    Log.i(this.TAG, "goQQMusic download");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", "https://y.qq.com/m/download.html");
    ((Intent)localObject).putExtra("showShare", false);
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(287007);
  }
  
  public final void ai(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(287015);
    kotlin.g.b.p.k(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_media_type", 2);
    localIntent.putExtra("scene", 4);
    com.tencent.mm.by.c.d(paramContext, "com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI", localIntent, paramInt);
    AppMethodBeat.o(287015);
  }
  
  public final void aj(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(287016);
    kotlin.g.b.p.k(paramContext, "context");
    if (!(paramContext instanceof Activity)) {
      paramContext = null;
    }
    for (;;)
    {
      com.tencent.mm.pluginsdk.ui.tools.u.a((Activity)paramContext, paramInt, 1, 30, 1, new Intent());
      AppMethodBeat.o(287016);
      return;
    }
  }
  
  public final void aj(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(286979);
    kotlin.g.b.p.k(paramView, "view");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramView, paramInt));
    AppMethodBeat.o(286979);
  }
  
  public final void ap(Activity paramActivity)
  {
    AppMethodBeat.i(286997);
    kotlin.g.b.p.k(paramActivity, "context");
    Intent localIntent = new Intent();
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class);
    kotlin.g.b.p.j(localObject, "MMKernel.service(IHellBizService::class.java)");
    localObject = ((com.tencent.mm.plugin.expt.b.c)localObject).dbu();
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvP.Tzp, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGU())) {}
      for (int i = 1;; i = 2)
      {
        localIntent.putExtra("key_live_anchor_type", i);
        localIntent.putExtra("key_live_id", com.tencent.mm.ae.d.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId));
        localIntent.putExtra("key_live_attach", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zga.zeU);
        localIntent.putExtra("key_from", 3);
        localIntent.putExtra("key_session_id", (String)localObject);
        com.tencent.mm.by.c.b((Context)paramActivity, "luckymoney", ".ui.LuckyMoneyPrepareUI", localIntent);
        Log.i(this.TAG, "goPrepareLuckyMoney liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ", clientBuff:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zga.zeU + ", sessionId:" + (String)localObject);
        AppMethodBeat.o(286997);
        return;
      }
    }
  }
  
  public final void b(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg, com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(286973);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramg, "bundle");
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("open halfscreen miniPro appId:").append(paramg.appId).append(",patch:").append(paramg.nBq).append(",is test:");
    Object localObject3 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.live.utils.a.dEO()).append(",halfScreenConfig is null:");
    if (paramg.nBE == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject1, bool);
      if ((!Util.isNullOrNil(paramg.appId)) && (!Util.isNullOrNil(paramg.nBq))) {
        break;
      }
      AppMethodBeat.o(286973);
      return;
    }
    localObject1 = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
    localObject3 = new HalfScreenConfig.BackgroundShapeConfig(((Context)localObject1).getResources().getDimension(com.tencent.mm.plugin.finder.b.d.finder_live_shopping_panel_corner), true, true, 24);
    localObject1 = paramContext.getClass().getName();
    kotlin.g.b.p.j(localObject1, "context.javaClass.name");
    HalfScreenConfig.CloseWhenClickEmptyAreaConfig localCloseWhenClickEmptyAreaConfig = new HalfScreenConfig.CloseWhenClickEmptyAreaConfig((String)localObject1, HalfScreenConfig.a.nZL);
    localObject1 = com.tencent.mm.plugin.finder.live.r.xWC;
    int i = com.tencent.mm.plugin.finder.live.r.dwO();
    localObject2 = paramg.nBr;
    localObject1 = localObject2;
    if (!(localObject2 instanceof at)) {
      localObject1 = null;
    }
    localObject1 = (at)localObject1;
    if (localObject1 != null)
    {
      bool = ((at)localObject1).yiG;
      localObject1 = new MiniProgramHalfScreenStatusChangeListener(parama);
      if (paramg.nBE == null) {
        break label527;
      }
      localObject2 = paramg.nBE;
      if (localObject2 == null) {
        break label521;
      }
      HalfScreenConfig.b localb = new HalfScreenConfig.b();
      localb.hG(((HalfScreenConfig)localObject2).isEnable());
      localb.zr(((HalfScreenConfig)localObject2).height);
      localb.a(((HalfScreenConfig)localObject2).nZz);
      localb.hH(((HalfScreenConfig)localObject2).nZA);
      localb.a(((HalfScreenConfig)localObject2).nZC);
      localb.a(((HalfScreenConfig)localObject2).nZB);
      localb.hI(((HalfScreenConfig)localObject2).nnk);
      localb.a(((HalfScreenConfig)localObject2).nZC);
      localb.a(((HalfScreenConfig)localObject2).nZD);
      localb.hJ(((HalfScreenConfig)localObject2).nZE);
      localb.hK(((HalfScreenConfig)localObject2).nZF);
      localb.a(((HalfScreenConfig)localObject2).nZG);
      localb.a(((HalfScreenConfig)localObject2).nZH);
      localb.hL(((HalfScreenConfig)localObject2).nZI);
      localObject1 = localb.hG(true).hH(true).a((HalfScreenConfig.BackgroundShapeConfig)localObject3).hI(true).a(localCloseWhenClickEmptyAreaConfig).hJ(bool).a((WeAppHalfScreenStatusChangeListener)localObject1).bLu();
    }
    for (;;)
    {
      paramg.nBE = ((HalfScreenConfig)localObject1);
      a(paramContext, paramg, true, parama);
      AppMethodBeat.o(286973);
      return;
      bool = true;
      break;
      label521:
      localObject1 = null;
      continue;
      label527:
      localObject1 = new HalfScreenConfig(true, i, HalfScreenConfig.a.nZL, true, (HalfScreenConfig.BackgroundShapeConfig)localObject3, true, localCloseWhenClickEmptyAreaConfig, HalfScreenConfig.c.nZV, bool, true, (WeAppHalfScreenStatusChangeListener)localObject1, null, false, 2048);
    }
  }
  
  public final void b(String paramString, kotlin.g.a.m<? super beo, ? super aqu, kotlin.x> paramm)
  {
    AppMethodBeat.i(286964);
    Log.i(this.TAG, "putInBlackList username:".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      ((com.tencent.mm.plugin.finder.service.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.finder.service.k.class)).b(paramString, (com.tencent.mm.plugin.findersdk.a.aj)new af(paramm));
      AppMethodBeat.o(286964);
      return;
    }
    AppMethodBeat.o(286964);
  }
  
  public final <T extends androidx.lifecycle.x> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(286950);
    kotlin.g.b.p.k(paramClass, "bu");
    paramClass = this.buContext.business(paramClass);
    AppMethodBeat.o(286950);
    return paramClass;
  }
  
  public final void c(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(286999);
    kotlin.g.b.p.k(paramActivity, "activity");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
    localObject1 = new Intent();
    Object localObject2 = (Iterable)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfU;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localCollection.add(((axc)((Iterator)localObject2).next()).toByteArray());
    }
    ((Intent)localObject1).putExtra("KEY_VISITOR_ROLE_LIST", (Serializable)localCollection);
    ((Intent)localObject1).putExtra("KEY_VISITOR_ROLE", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfT);
    ((Intent)localObject1).putExtra("KEY_MODIFY_TIME", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfV);
    ((Intent)localObject1).putExtra("KEY_SOURCE", 1);
    com.tencent.mm.plugin.finder.utils.a.a(paramActivity, (Intent)localObject1, 1009, paramBoolean);
    AppMethodBeat.o(286999);
  }
  
  public final void c(kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super bgy, kotlin.x> paramr)
  {
    AppMethodBeat.i(286957);
    bid localbid = dxT();
    Object localObject = n.xYm;
    localObject = new axe();
    ((axe)localObject).msg_type = 20006;
    ((axe)localObject).SJs = (com.tencent.mm.model.z.bcZ() + System.currentTimeMillis());
    new n((axe)localObject, this.buContext, localbid, (kotlin.g.a.r)new p(paramr)).bhW();
    AppMethodBeat.o(286957);
  }
  
  public final void d(final kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super aux, kotlin.x> paramr)
  {
    AppMethodBeat.i(286970);
    Object localObject = com.tencent.mm.plugin.finder.cgi.ao.xcj;
    localObject = com.tencent.mm.plugin.finder.cgi.ao.dnO();
    long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
    String str = com.tencent.mm.model.z.bdh();
    kotlin.g.b.p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
    paramr = new com.tencent.mm.plugin.finder.live.model.cgi.ao((aqe)localObject, l, str, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, (ao.a)new o(this, paramr)).bhW();
    if ((this.context != null) && ((this.context instanceof MMActivity))) {
      paramr.a((com.tencent.mm.vending.e.b)this.context);
    }
    AppMethodBeat.o(286970);
  }
  
  public final void dxU()
  {
    AppMethodBeat.i(286955);
    Log.i(this.TAG, "doCloseVisitorLive liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + " objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk + " nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId);
    bid localbid = dxT();
    com.tencent.c.a.a.a.c.a locala = (com.tencent.c.a.a.a.c.a)com.tencent.mm.kernel.h.ae(com.tencent.c.a.a.a.c.a.class);
    com.tencent.mm.plugin.finder.cgi.ao localao = com.tencent.mm.plugin.finder.cgi.ao.xcj;
    com.tencent.c.a.a.a.c.a.a.a(locala, com.tencent.mm.plugin.finder.cgi.ao.a(localbid), com.tencent.mm.model.z.bdh(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId, 0, true, null, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.SJy, localbid, (a.b)new g(), 256).bhW();
    AppMethodBeat.o(286955);
  }
  
  public final void dxV()
  {
    AppMethodBeat.i(286975);
    Log.i(this.TAG, "close miniPro appId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziN);
    Object localObject = ah.yhC;
    localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
    ah.fx((Context)localObject);
    AppMethodBeat.o(286975);
  }
  
  public final void dxW()
  {
    AppMethodBeat.i(286980);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ag(this));
    AppMethodBeat.o(286980);
  }
  
  public final boolean dxX()
  {
    AppMethodBeat.i(286994);
    boolean bool = ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).dxX();
    AppMethodBeat.o(286994);
    return bool;
  }
  
  public final boolean dxY()
  {
    AppMethodBeat.i(287000);
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.SJy;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGW();
    int j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.SJy;
    Log.i(this.TAG, "checkVisitorRoleType oriVisitorRoleType:" + i + ",newVisitorRoleType:" + j);
    if ((i != j) && (j != 4))
    {
      hu localhu = new hu();
      localhu.fEL.id = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
      localhu.fEL.type = 14;
      EventCenter.instance.publish((IEvent)localhu);
      AppMethodBeat.o(287000);
      return true;
    }
    AppMethodBeat.o(287000);
    return false;
  }
  
  public final void e(final kotlin.g.a.m<? super Boolean, ? super Integer, kotlin.x> paramm)
  {
    AppMethodBeat.i(286968);
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfH)
    {
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.eej()) {}
    }
    else
    {
      localObject = m.yfw;
      if (m.getDebug())
      {
        Log.i(this.TAG, "doGetGiftList : enter debug");
        paramm = m.yfw;
        m.dyz();
        AppMethodBeat.o(286968);
        return;
      }
      new com.tencent.mm.plugin.finder.live.model.cgi.j(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId, com.tencent.mm.model.z.bdh(), (j.a)new n(this, paramm)).bhW();
      AppMethodBeat.o(286968);
      return;
    }
    paramm = this.TAG;
    Object localObject = new StringBuilder("doGetGiftList liveData.business(LiveCommonSlice::class.java).enableGiftSwitch:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfH).append(", FinderUtil.isTest():");
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    Log.i(paramm, com.tencent.mm.plugin.finder.utils.aj.eej());
    AppMethodBeat.o(286968);
  }
  
  public final void f(Object paramObject, String paramString)
  {
    AppMethodBeat.i(287002);
    kotlin.g.b.p.k(paramString, "keyUsername");
    if (!(paramObject instanceof Bundle)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (Bundle)paramObject;
      if (paramObject != null)
      {
        paramObject = paramObject.getString(paramString);
        paramString = (CharSequence)paramObject;
        if ((paramString == null) || (paramString.length() == 0)) {}
        for (int i = 1; i == 0; i = 0)
        {
          a(false, paramObject, null);
          AppMethodBeat.o(287002);
          return;
        }
        Log.i(this.TAG, "goToFinderProfileImpl finderUsername:".concat(String.valueOf(paramObject)));
        AppMethodBeat.o(287002);
        return;
      }
      AppMethodBeat.o(287002);
      return;
    }
  }
  
  public final void fw(Context paramContext)
  {
    AppMethodBeat.i(286991);
    kotlin.g.b.p.k(paramContext, "context");
    Log.i(this.TAG, "[WeCoin] initEngine");
    ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).a(paramContext, (com.tencent.mm.plugin.wallet.wecoin.a.e)new ac(this));
    AppMethodBeat.o(286991);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$initEngine$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "msg", "", "onSuccess", "data", "(Ljava/lang/Boolean;)V", "plugin-finder_release"})
  public static final class ac
    implements com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean>
  {
    public final void p(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(287131);
      Log.i(this.ydI.TAG, "[WeCoin] initEngine onFailed");
      paramString = this.yej;
      if (paramString != null)
      {
        paramString.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        AppMethodBeat.o(287131);
        return;
      }
      AppMethodBeat.o(287131);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$putInBlackList$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class af
    implements com.tencent.mm.plugin.findersdk.a.aj<beo>
  {
    af(kotlin.g.a.m paramm) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ag
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    ag(e parame)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    d(e parame, View paramView, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCloseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder_release"})
  public static final class f
    implements f.a
  {
    f(kotlin.g.a.s params) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aqs paramaqs)
    {
      AppMethodBeat.i(268096);
      kotlin.g.b.p.k(paramaqs, "resp");
      Object localObject2;
      Boolean localBoolean;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i(this.ydI.TAG, "close live room failed");
        localObject2 = params;
        if (localObject2 != null)
        {
          localBoolean = Boolean.FALSE;
          if (paramString != null) {
            break label179;
          }
        }
      }
      label176:
      label179:
      for (Object localObject1 = "";; localObject1 = paramString)
      {
        ((kotlin.g.a.s)localObject2).a(localBoolean, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localObject1, paramaqs);
        paramaqs = aq.AIJ;
        localObject1 = aq.efP();
        paramaqs = paramString;
        if (paramString == null) {
          paramaqs = "";
        }
        e.a(this.ydI);
        aq.hw((String)localObject1, paramaqs);
        AppMethodBeat.o(268096);
        return;
        localObject1 = params;
        if (localObject1 != null)
        {
          localObject2 = Boolean.TRUE;
          if (paramString != null) {
            break label176;
          }
          paramString = "";
        }
        for (;;)
        {
          ((kotlin.g.a.s)localObject1).a(localObject2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, paramaqs);
          AppMethodBeat.o(268096);
          return;
          AppMethodBeat.o(268096);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCloseVisitorLive$1", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "requestCode", "plugin-finder_release"})
  public static final class g
    implements a.b
  {
    public final void a(int paramInt1, int paramInt2, auv paramauv, int paramInt3)
    {
      AppMethodBeat.i(287110);
      kotlin.g.b.p.k(paramauv, "resp");
      AppMethodBeat.o(287110);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doDisableComment$1$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveBanComment$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "enable", "", "onSuccess", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.finder.live.cgi.e.a
  {
    i(e parame, boolean paramBoolean, String paramString, kotlin.g.a.m paramm) {}
    
    public final void oE(boolean paramBoolean)
    {
      AppMethodBeat.i(269453);
      Log.i(this.ydI.TAG, "doDisableComment success, enable:" + paramBoolean + " username:" + paramString);
      Object localObject = (Map)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfs;
      String str = paramString;
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        ((Map)localObject).put(str, Boolean.valueOf(bool));
        localObject = paramm;
        if (localObject == null) {
          break;
        }
        ((kotlin.g.a.m)localObject).invoke(Boolean.TRUE, Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(269453);
        return;
      }
      AppMethodBeat.o(269453);
    }
    
    public final void w(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(269454);
      Log.i(this.ydI.TAG, "doDisableComment fail, enable:" + paramBoolean + " username:" + paramString + " errType:" + paramInt1 + " errCode:" + paramInt2);
      kotlin.g.a.m localm = paramm;
      if (localm != null)
      {
        localm.invoke(Boolean.FALSE, Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(269454);
        return;
      }
      AppMethodBeat.o(269454);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doFinishLive$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "respLiveId", "", "liveStatus", "", "resp", "", "plugin-finder_release"})
  public static final class j
    implements com.tencent.c.a.a.a.b.d
  {
    j(kotlin.g.a.s params) {}
    
    public final void a(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(275913);
      Log.i(this.ydI.TAG, "getLiveInfo,liveData.business(LiveCommonSlice::class.java).liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ",respLiveId:" + paramLong + ",liveStatus:" + paramInt + ",resp:" + paramObject);
      if ((paramLong == ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId) && ((paramObject instanceof aur)))
      {
        Object localObject = ((aur)paramObject).liveInfo;
        int i;
        label150:
        int j;
        label172:
        int k;
        label194:
        int m;
        if (localObject != null)
        {
          paramInt = ((bac)localObject).endTime;
          localObject = ((aur)paramObject).liveInfo;
          if (localObject == null) {
            break label294;
          }
          i = ((bac)localObject).fod;
          localObject = ((aur)paramObject).liveInfo;
          if (localObject == null) {
            break label300;
          }
          j = ((bac)localObject).yYz;
          localObject = ((aur)paramObject).liveInfo;
          if (localObject == null) {
            break label306;
          }
          k = ((bac)localObject).BpL;
          m = ((aur)paramObject).SDW;
          localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          paramObject = com.tencent.mm.plugin.finder.live.utils.a.a(((aur)paramObject).liveInfo);
          if (paramObject == null) {
            break label312;
          }
        }
        label294:
        label300:
        label306:
        label312:
        for (paramLong = paramObject.longValue();; paramLong = 0L)
        {
          paramObject = params;
          if (paramObject == null) {
            break label317;
          }
          paramObject.a(Boolean.TRUE, Integer.valueOf(0), Integer.valueOf(0), "", new com.tencent.mm.plugin.finder.live.viewmodel.data.a(paramInt - i, j, k, m, paramLong));
          AppMethodBeat.o(275913);
          return;
          paramInt = 0;
          break;
          i = 0;
          break label150;
          j = 0;
          break label172;
          k = 0;
          break label194;
        }
        label317:
        AppMethodBeat.o(275913);
        return;
      }
      paramObject = params;
      if (paramObject != null)
      {
        paramObject.a(Boolean.FALSE, Integer.valueOf(0), Integer.valueOf(0), "", new com.tencent.mm.plugin.finder.live.viewmodel.data.a(0, 0, 0, 0, 31));
        AppMethodBeat.o(275913);
        return;
      }
      AppMethodBeat.o(275913);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, bdx, kotlin.x>
  {
    k(e parame, kotlin.g.a.s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, aqs, kotlin.x>
  {
    l(kotlin.g.a.s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetFinderLiveContact$1$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetContact$CallBack;", "onFinish", "", "success", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.plugin.finder.live.cgi.h.a
  {
    m(e parame, String paramString) {}
    
    public final void a(boolean paramBoolean, aza paramaza)
    {
      boolean bool = true;
      AppMethodBeat.i(289710);
      Log.i(this.ydI.TAG, "doGetFinderLiveContact success:" + paramBoolean + " username:" + paramString);
      Object localObject;
      String str;
      if (paramBoolean)
      {
        localObject = e.a(this.ydI);
        if (localObject == null) {
          break label156;
        }
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (localObject == null) {
          break label156;
        }
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfs;
        localObject = (Map)localObject;
        str = paramString;
        if ((paramaza == null) || (paramaza.SKR != 1)) {
          break label162;
        }
      }
      for (;;)
      {
        ((Map)localObject).put(str, Boolean.valueOf(bool));
        localObject = this.kJK;
        if (localObject == null) {
          break label167;
        }
        ((kotlin.g.a.m)localObject).invoke(Boolean.valueOf(paramBoolean), paramaza);
        AppMethodBeat.o(289710);
        return;
        label156:
        localObject = null;
        break;
        label162:
        bool = false;
      }
      label167:
      AppMethodBeat.o(289710);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetGiftList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListResponse;", "plugin-finder_release"})
  public static final class n
    implements j.a
  {
    n(kotlin.g.a.m paramm) {}
    
    public final void a(int paramInt1, int paramInt2, avd paramavd)
    {
      AppMethodBeat.i(289730);
      kotlin.g.b.p.k(paramavd, "resp");
      Log.i(this.ydI.TAG, "doGetGiftList errType:" + paramInt1 + ", errCode:" + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ah localah = ah.yhC;
        ah.c(paramavd.SDI);
        localah = ah.yhC;
        ah.Nt(paramavd.SHw);
        localah = ah.yhC;
        ah.Nu(paramavd.SHx);
        paramavd = paramm;
        if (paramavd != null)
        {
          paramavd.invoke(Boolean.TRUE, Integer.valueOf(paramInt2));
          AppMethodBeat.o(289730);
          return;
        }
        AppMethodBeat.o(289730);
        return;
      }
      paramavd = paramm;
      if (paramavd != null)
      {
        paramavd.invoke(Boolean.FALSE, Integer.valueOf(paramInt2));
        AppMethodBeat.o(289730);
        return;
      }
      AppMethodBeat.o(289730);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetMemberList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "plugin-finder_release"})
  public static final class o
    implements ao.a
  {
    o(kotlin.g.a.r paramr) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aux paramaux)
    {
      AppMethodBeat.i(234617);
      kotlin.g.b.p.k(paramaux, "resp");
      Object localObject;
      com.tencent.mm.plugin.finder.live.viewmodel.data.business.i locali;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class);
        kotlin.g.b.p.k(paramaux, "resp");
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)localObject).ziz.clear();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)localObject).ziz.addAll((Collection)paramaux.SHh);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)localObject).ziB.clear();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)localObject).ziB.addAll((Collection)paramaux.SHi);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)localObject).ziC = paramaux.SHk;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)localObject).ziD = paramaux.SHl;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)localObject).ziA = paramaux.SHm;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.yYz = paramaux.SHk;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgd = paramaux.zgd;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zge = paramaux.zge;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgI.clear();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgI.addAll((Collection)paramaux.SHn);
        localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (!com.tencent.mm.plugin.finder.live.utils.a.dEy())
        {
          locali = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class);
          StringBuilder localStringBuilder = new StringBuilder("online member enableComment:");
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)locali.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).ziA;
          if (localObject == null) {
            break label389;
          }
          localObject = Integer.valueOf(((aza)localObject).ktP);
          Log.i("MMFinder.LiveOnlineMemberSlice", localObject);
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)locali.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).ziA;
          if (localObject != null)
          {
            if (((aza)localObject).ktP != 1) {
              break label395;
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)locali.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfc = true;
          }
        }
      }
      for (;;)
      {
        localObject = paramr;
        if (localObject == null) {
          break label420;
        }
        ((kotlin.g.a.r)localObject).a(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, paramaux);
        AppMethodBeat.o(234617);
        return;
        label389:
        localObject = null;
        break;
        label395:
        if (((aza)localObject).ktP == 0) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)locali.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfc = false;
        }
      }
      label420:
      AppMethodBeat.o(234617);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, Integer, String, bgy, kotlin.x>
  {
    p(kotlin.g.a.r paramr)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveResp;", "kotlin.jvm.PlatformType", "call"})
  static final class r<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    r(e parame) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doManualCloseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "plugin-finder_release"})
  public static final class s
    implements com.tencent.mm.plugin.finder.live.model.cgi.an.a
  {
    s(kotlin.g.a.s params) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bdx parambdx)
    {
      AppMethodBeat.i(270625);
      kotlin.g.b.p.k(parambdx, "resp");
      Object localObject2;
      Boolean localBoolean;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i(this.ydI.TAG, "manual close live room failed");
        localObject2 = params;
        if (localObject2 != null)
        {
          localBoolean = Boolean.FALSE;
          if (paramString != null) {
            break label179;
          }
        }
      }
      label176:
      label179:
      for (Object localObject1 = "";; localObject1 = paramString)
      {
        ((kotlin.g.a.s)localObject2).a(localBoolean, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localObject1, parambdx);
        parambdx = aq.AIJ;
        localObject1 = aq.efQ();
        parambdx = paramString;
        if (paramString == null) {
          parambdx = "";
        }
        e.a(this.ydI);
        aq.hw((String)localObject1, parambdx);
        AppMethodBeat.o(270625);
        return;
        localObject1 = params;
        if (localObject1 != null)
        {
          localObject2 = Boolean.TRUE;
          if (paramString != null) {
            break label176;
          }
          paramString = "";
        }
        for (;;)
        {
          ((kotlin.g.a.s)localObject1).a(localObject2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, parambdx);
          AppMethodBeat.o(270625);
          return;
          AppMethodBeat.o(270625);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostComment$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder_release"})
  public static final class t
    implements u.a
  {
    t(u.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bha parambha)
    {
      AppMethodBeat.i(274457);
      kotlin.g.b.p.k(parambha, "resp");
      Object localObject = parama;
      if (localObject != null) {
        ((u.a)localObject).a(paramInt1, paramInt2, paramString, parambha);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (com.tencent.mm.ae.d.dr(parambha.SJt, 1))
        {
          paramString = this.ydI;
          parambha = MMApplicationContext.getContext();
          kotlin.g.b.p.j(parambha, "MMApplicationContext.getContext()");
          parambha = parambha.getResources().getString(b.j.finder_live_lottery_attended);
          kotlin.g.b.p.j(parambha, "MMApplicationContext.get…er_live_lottery_attended)");
          e.a(paramString, parambha, b.i.icons_outlined_done);
          parambha = this.ydI.TAG;
          localObject = new StringBuilder("doPostComment attended lottery success,lotteryId:");
          paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class)).zic;
          if (paramString != null)
          {
            paramString = paramString.xHW;
            if (paramString == null) {}
          }
          for (paramString = paramString.id;; paramString = null)
          {
            Log.i(parambha, paramString);
            paramString = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
              break;
            }
            com.tencent.mm.plugin.finder.live.report.m.yCt.a(s.bm.yMR, "");
            AppMethodBeat.o(274457);
            return;
          }
        }
      }
      else
      {
        parambha = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.eej()) {
          com.tencent.mm.ui.base.w.makeText(this.ydI.context, (CharSequence)(paramInt2 + ':' + paramString), 0).show();
        }
      }
      AppMethodBeat.o(274457);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getLotteryRecord$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class v
    implements x.a
  {
    v(x.a parama) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final azs paramazs)
    {
      AppMethodBeat.i(273886);
      kotlin.g.b.p.k(paramazs, "resp");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramazs, paramInt1, paramInt2, paramString));
      AppMethodBeat.o(273886);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(e.v paramv, azs paramazs, int paramInt1, int paramInt2, String paramString)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getProductDetail$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailResponse;", "plugin-finder_release"})
  public static final class x
    implements z.a
  {
    public final void a(int paramInt1, int paramInt2, azw paramazw)
    {
      AppMethodBeat.i(276120);
      kotlin.g.b.p.k(paramazw, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject = paramazw.SLt;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).aCX((String)localObject);
        }
        paramazw = paramazw.SKr;
        if (paramazw != null)
        {
          localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject).d((bu)com.tencent.mm.plugin.finder.live.view.convert.a.b(paramazw));
          AppMethodBeat.o(276120);
          return;
        }
      }
      AppMethodBeat.o(276120);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getShopShelf$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "plugin-finder_release"})
  public static final class y
    implements aa.a
  {
    y(kotlin.g.a.b paramb, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, azy paramazy)
    {
      String str = null;
      AppMethodBeat.i(287309);
      kotlin.g.b.p.k(paramazy, "resp");
      long l = paramazy.klE;
      Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo;
      if ((localObject == null) || (l != ((bac)localObject).liveId))
      {
        str = this.ydI.TAG;
        paramazy = new StringBuilder("invalid live resp,liveId:").append(paramazy.klE).append(",current liveId:");
        paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo;
        if (paramString != null) {}
        for (paramString = Long.valueOf(paramString.liveId);; paramString = null)
        {
          Log.i(str, paramString.longValue());
          paramString = paramb;
          if (paramString == null) {
            break;
          }
          paramString.invoke(Boolean.FALSE);
          AppMethodBeat.o(287309);
          return;
        }
        AppMethodBeat.o(287309);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).dHk();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziF = true;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
        com.tencent.mm.cd.b localb = paramazy.RLO;
        paramString = str;
        if (localb != null) {
          paramString = localb.UH;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).kvN = paramString;
        Log.i(this.ydI.TAG, "mergeProducts, resp list size:" + paramazy.SiG.size());
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).d(paramazy);
        paramString = paramazy.SLt;
        if (paramString != null) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ydI.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).aCX(paramString);
        }
        paramString = paramb;
        if (paramString != null)
        {
          paramString.invoke(Boolean.TRUE);
          AppMethodBeat.o(287309);
          return;
        }
        AppMethodBeat.o(287309);
        return;
      }
      paramazy = paramb;
      if (paramazy != null) {
        paramazy.invoke(Boolean.FALSE);
      }
      if (i != 0)
      {
        paramazy = aq.AIJ;
        str = aq.efS();
        paramazy = paramString;
        if (paramString == null) {
          paramazy = "";
        }
        e.a(this.ydI);
        aq.hw(str, paramazy);
      }
      AppMethodBeat.o(287309);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getWeCoinBalance$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "msg", "", "onSuccess", "data", "plugin-finder_release"})
  public static final class z
    implements com.tencent.mm.plugin.wallet.wecoin.a.e<Long>
  {
    z(kotlin.g.a.b paramb) {}
    
    public final void p(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(236794);
      Log.i(this.ydI.TAG, "[WeCoin] getWeCoinBalance onFailed,errorType:" + paramInt1 + ",errorCode:" + paramInt2 + ",msg:" + paramString);
      paramString = paramb;
      if (paramString != null)
      {
        paramString.invoke(Long.valueOf(-1L));
        AppMethodBeat.o(236794);
        return;
      }
      AppMethodBeat.o(236794);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.e
 * JD-Core Version:    0.7.0.1
 */