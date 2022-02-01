package com.tencent.mm.plugin.finder.live.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.d.a.a.a.b.b;
import com.tencent.d.a.a.a.b.d;
import com.tencent.d.a.a.a.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ia;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.b;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.appbrand.config.WeAppHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.MiniProgramHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.finder.live.cgi.e.b;
import com.tencent.mm.plugin.finder.live.cgi.l;
import com.tencent.mm.plugin.finder.live.model.cgi.aa.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ad;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ae;
import com.tencent.mm.plugin.finder.live.model.cgi.ae.a;
import com.tencent.mm.plugin.finder.live.model.cgi.af.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ag.a;
import com.tencent.mm.plugin.finder.live.model.cgi.aj.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ak;
import com.tencent.mm.plugin.finder.live.model.cgi.ak.a;
import com.tencent.mm.plugin.finder.live.model.cgi.al;
import com.tencent.mm.plugin.finder.live.model.cgi.al.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ao;
import com.tencent.mm.plugin.finder.live.model.cgi.ao.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ar;
import com.tencent.mm.plugin.finder.live.model.cgi.ar.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ax;
import com.tencent.mm.plugin.finder.live.model.cgi.ay.a;
import com.tencent.mm.plugin.finder.live.model.cgi.az;
import com.tencent.mm.plugin.finder.live.model.cgi.ba;
import com.tencent.mm.plugin.finder.live.model.cgi.ba.a;
import com.tencent.mm.plugin.finder.live.model.cgi.d.a;
import com.tencent.mm.plugin.finder.live.model.cgi.i.a;
import com.tencent.mm.plugin.finder.live.model.cgi.p.a;
import com.tencent.mm.plugin.finder.live.model.cgi.q.a;
import com.tencent.mm.plugin.finder.live.model.cgi.s.a;
import com.tencent.mm.plugin.finder.live.model.cgi.u.a;
import com.tencent.mm.plugin.finder.live.model.cgi.v;
import com.tencent.mm.plugin.finder.live.model.cgi.v.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ax.a;
import com.tencent.mm.plugin.finder.live.plugin.ax.a.a;
import com.tencent.mm.plugin.finder.live.plugin.ax.a.b;
import com.tencent.mm.plugin.finder.live.report.q.bb;
import com.tencent.mm.plugin.finder.live.report.q.bh;
import com.tencent.mm.plugin.finder.live.report.q.bi;
import com.tencent.mm.plugin.finder.live.report.q.ca;
import com.tencent.mm.plugin.finder.live.report.q.cf;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.o;
import com.tencent.mm.plugin.finder.live.widget.bf;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bd;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.bdz;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.glm;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAssistant;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "Lcom/tencent/mm/plugin/finder/live/model/context/IFinderLiveStore;", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/ref/WeakReference;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheViewVisibilityList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/view/View;", "", "Lkotlin/collections/ArrayList;", "getContextRef", "()Ljava/lang/ref/WeakReference;", "isFestivalLive", "", "()Z", "setFestivalLive", "(Z)V", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "acceptBattle", "", "liveId", "", "objectId", "objectNonceId", "liveCookie", "", "scene", "toContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "battleId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAcceptBattle$CallBack;", "acceptLinkMic", "micType", "userId", "sessionId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "acceptLinkMicPk", "sdkLiveId", "randomMicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "announceGotoShopping", "productId", "applyBattle", "micId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveApplyBattle$CallBack;", "applyLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "applyLinkMicPk", "sdkUserId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "autoTransMmitLive", "toUser", "", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "batchGetMicContact", "usernameList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "cacheViewVisibility", "view", "visibility", "checkVisitorRoleTypeAndGameRankSwitch", "data", "Landroid/content/Intent;", "chooseVisitorRoleImpl", "activity", "Landroid/app/Activity;", "fromUserGuide", "closeBattle", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCloseBattle$CallBack;", "closeLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "closeLinkMicPk", "closeScene", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "closeMiniProgram", "context", "consumeGift", "sessionID", "consumeWeCoin", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "doCloseLive", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "success", "errCode", "errType", "errMsg", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "resp", "doCloseVisitorLive", "doCreateLive", "Lkotlin/Function7;", "needFaceVerify", "verifyUrl", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "doDisableComment", "username", "enable", "Lkotlin/Function2;", "doFetchFinderContact", "finderUsername", "doFinishLive", "manualFinish", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;", "info", "doGetFinderLiveContact", "contact", "doGetGiftList", "doGetMemberList", "Lkotlin/Function4;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "doGetMicCandidateList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "doHighLightLikeLive", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "doJoinLive", "role", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "doLikeLive", "count", "doManualCloseLive", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "doPostAppMsg", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "liveData", "doPostComment", "commentContent", "liveMsgType", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "doPostGift", "rewardGiftId", "rewardGiftCnt", "wecoin", "comboId", "sendGiftTargetUserName", "rewardType", "rewardExtInfo", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "expose", "commentSeq", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "filterAnchorStatusFlag", "originalFlag", "genAcceptBattleMsg", "genAcceptLinkMicMsg", "genAcceptLinkMicPkMsg", "genApplyBattleMsg", "genApplyLinkMicMsg", "genApplyLinkMicPkMsg", "genCloseBattleMsg", "genCloseLinkMicMsg", "genCloseLinkMicPkMsg", "genLiveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "genReportContextObj", "getContext", "getCouponList", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetCouponListResponse;", "getJsonField", "jsonVal", "field", "getLotteryRecord", "lotteryId", "lastBuff", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "getLuckyMoneyInfo", "nonceId", "liveCookies", "sendIdList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "getMusicInfo", "songIdList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "getProductReplayUrl", "replayId", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetReplayUrlResponse;", "getShopShelf", "anchorUsername", "stockId", "pullScene", "uxInfo", "Lkotlin/Function1;", "getWeCoinBalance", "requestId", "balance", "getWeCoinBalanceFromCache", "goPrepareLuckyMoney", "goQQMusic", "songId", "songmid", "goReceiveLuckyMoney", "luckyMoneySendInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "resultReceiver", "Landroid/os/ResultReceiver;", "actionCallback", "goToGallery", "requestCode", "goToHistoryFile", "gotoWebViewWithoutMiniWindow", "intent", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "initEngine", "sucCallback", "failCallback", "isWeCoinEntranceAvailable", "issueCoupon", "Lcom/tencent/mm/protocal/protobuf/FinderLiveIssueCouponResponse;", "luckyMoneyRewardNotify", "sendId", "modeShopShelf", "audienceUsername", "finderCmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "Lkotlin/Function3;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "modifyMusicList", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;", "onPostGoToVisitorProfileResult", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "keyUsername", "openFullScreenMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "openHalfScreenMiniProgram", "openMiniProgram", "pauseLive", "pauseMode", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "postCmdItemCache", "processCreateLiveResponse", "response", "processJoinLiveResponse", "processLiveCgiSDKResponse", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "processOlympicsLiveResponse", "processVisitorRoleResponse", "putInBlackList", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "randomLinkMic", "finderUserName", "opCode", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveRandomMic$CallBack;", "receiveAllCouponBindToProduct", "product", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReceiveCouponResponse;", "receiveCoupon", "stockIds", "showErrorToast", "resumeViewVisibility", "searchMusic", "query", "lastBuffer", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "setAnchorStatus", "flag", "liveStatus", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "setAnchorStatusWithOpFlag", "opFlag", "setGameTeamMode", "gameTeamSetting", "Lcom/tencent/mm/protocal/protobuf/GameJoinTeamSetting;", "setLotterySetting", "lotterySetting", "Lcom/tencent/mm/protocal/protobuf/LiveLotterySetting;", "setMicSetting", "micSettingFlag", "setTopic", "topic", "showCenterCustomizeToast", "msg", "res", "showCenterTextToast", "showRechargeFoodsDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "Landroidx/fragment/app/FragmentActivity;", "Lkotlin/Function0;", "showWeCoinEntranceTutorialDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "updateRedPacketCoverInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements ap
{
  public static final f.a CEf;
  private static final int CEi;
  private static final int CEj;
  private static final int CEk;
  private static final int CEl;
  private ArrayList<kotlin.r<View, Integer>> CEg;
  boolean CEh;
  final String TAG;
  private final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private final WeakReference<Context> contextRef;
  final bui reportObj;
  
  static
  {
    AppMethodBeat.i(359764);
    CEf = new f.a((byte)0);
    CEi = 1;
    CEj = 2;
    CEk = 3;
    CEl = 4;
    AppMethodBeat.o(359764);
  }
  
  public f(WeakReference<Context> paramWeakReference, com.tencent.mm.plugin.finder.live.model.context.a parama, bui parambui)
  {
    AppMethodBeat.i(359424);
    this.contextRef = paramWeakReference;
    this.buContext = parama;
    this.reportObj = parambui;
    this.TAG = "Finder.FinderLiveAssistant";
    this.CEg = new ArrayList();
    AppMethodBeat.o(359424);
  }
  
  private final int ON(int paramInt)
  {
    AppMethodBeat.i(359508);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.n(this.buContext)) {}
    for (int i = paramInt & 0xFFFFFFBF;; i = paramInt)
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("filterAnchorStatusFlag ori:").append(paramInt).append(" result:").append(i).append(' ');
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      Log.i((String)localObject, com.tencent.mm.plugin.finder.live.utils.a.n(this.buContext));
      AppMethodBeat.o(359508);
      return i;
    }
  }
  
  private static final ah a(ad.a parama, f paramf, com.tencent.mm.am.b.a parama1)
  {
    AppMethodBeat.i(359586);
    kotlin.g.b.s.u(paramf, "this$0");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f.n(parama1, parama, paramf));
    parama = ah.aiuX;
    AppMethodBeat.o(359586);
    return parama;
  }
  
  private static final ah a(ae.a parama, com.tencent.mm.am.b.a parama1)
  {
    AppMethodBeat.i(359593);
    if (parama == null)
    {
      AppMethodBeat.o(359593);
      return null;
    }
    int i = parama1.errType;
    int j = parama1.errCode;
    parama1 = parama1.ott;
    kotlin.g.b.s.s(parama1, "it.resp");
    parama.a(i, j, (bid)parama1);
    parama = ah.aiuX;
    AppMethodBeat.o(359593);
    return parama;
  }
  
  private static final ah a(p.a parama, com.tencent.mm.am.b.a parama1)
  {
    AppMethodBeat.i(359630);
    if (parama == null)
    {
      AppMethodBeat.o(359630);
      return null;
    }
    int i = parama1.errType;
    int j = parama1.errCode;
    String str = parama1.errMsg;
    parama1 = parama1.ott;
    kotlin.g.b.s.s(parama1, "it.resp");
    parama.a(i, j, str, (bcv)parama1);
    parama = ah.aiuX;
    AppMethodBeat.o(359630);
    return parama;
  }
  
  private static final ah a(q.a parama, com.tencent.mm.am.b.a parama1)
  {
    AppMethodBeat.i(359622);
    if (parama == null)
    {
      AppMethodBeat.o(359622);
      return null;
    }
    int i = parama1.errType;
    int j = parama1.errCode;
    String str = parama1.errMsg;
    parama1 = parama1.ott;
    kotlin.g.b.s.s(parama1, "it.resp");
    parama.a(i, j, str, (bfb)parama1);
    parama = ah.aiuX;
    AppMethodBeat.o(359622);
    return parama;
  }
  
  private static final ah a(v.a parama, com.tencent.mm.am.b.a parama1)
  {
    AppMethodBeat.i(359635);
    if (parama == null)
    {
      AppMethodBeat.o(359635);
      return null;
    }
    int i = parama1.errType;
    int j = parama1.errCode;
    String str = parama1.errMsg;
    parama1 = parama1.ott;
    kotlin.g.b.s.s(parama1, "it.resp");
    parama.a(i, j, str, (bge)parama1);
    parama = ah.aiuX;
    AppMethodBeat.o(359635);
    return parama;
  }
  
  private static final ah a(com.tencent.mm.plugin.finder.live.model.cgi.w.a parama, f paramf, com.tencent.mm.am.b.a parama1)
  {
    AppMethodBeat.i(359541);
    kotlin.g.b.s.u(paramf, "this$0");
    int i = parama1.errType;
    int j = parama1.errCode;
    String str = parama1.errMsg;
    parama1 = (bst)parama1.ott;
    if (parama != null)
    {
      kotlin.g.b.s.s(parama1, "resp");
      parama.a(i, j, parama1);
    }
    if ((i == 0) && (j == 0)) {
      if (com.tencent.mm.ae.d.ee(parama1.ZND, 1))
      {
        parama = MMApplicationContext.getContext().getResources().getString(p.h.Cmh);
        kotlin.g.b.s.s(parama, "getContext().resources.g…er_live_lottery_attended)");
        paramf.showCenterCustomizeToast(parama, p.g.icons_outlined_done);
        parama1 = paramf.TAG;
        parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
        if (parama != null) {
          break label177;
        }
        parama = null;
        Log.i(parama1, kotlin.g.b.s.X("doPostComment attended lottery success,lotteryId:", parama));
        parama = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
          com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFi, "");
        }
      }
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(359541);
      return parama;
      label177:
      parama = parama.Bhm;
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = parama.id;
      break;
      parama = aw.Gjk;
      if (aw.bgV()) {
        com.tencent.mm.ui.base.aa.makeText(paramf.getContext(), (CharSequence)(j + ':' + str), 0).show();
      }
    }
  }
  
  private static final ah a(f paramf, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(359531);
    kotlin.g.b.s.u(paramf, "this$0");
    int i = parama.errType;
    int j = parama.errCode;
    parama = (bcq)parama.ott;
    Log.i(paramf.TAG, "onSceneEnd errType:" + i + " errCode:" + j);
    if ((i == 0) && (j == 0) && (com.tencent.mm.ae.d.ee(parama.ZND, 1)))
    {
      parama = MMApplicationContext.getContext().getResources().getString(p.h.Cmh);
      kotlin.g.b.s.s(parama, "getContext().resources.g…er_live_lottery_attended)");
      paramf.showCenterCustomizeToast(parama, p.g.icons_outlined_done);
      parama = paramf.TAG;
      paramf = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (paramf != null) {
        break label182;
      }
      paramf = null;
    }
    for (;;)
    {
      Log.i(parama, kotlin.g.b.s.X("doLikeLive attended lottery success,lotteryId:", paramf));
      paramf = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFi, "");
      }
      paramf = ah.aiuX;
      AppMethodBeat.o(359531);
      return paramf;
      label182:
      paramf = paramf.Bhm;
      if (paramf == null) {
        paramf = null;
      } else {
        paramf = paramf.id;
      }
    }
  }
  
  private static final ah a(f paramf, String paramString, kotlin.g.a.m paramm, com.tencent.mm.am.b.a parama)
  {
    boolean bool2 = true;
    Object localObject1 = null;
    AppMethodBeat.i(359551);
    kotlin.g.b.s.u(paramf, "this$0");
    boolean bool1;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      bool1 = true;
      Log.i(paramf.TAG, "doGetFinderLiveContact success:" + bool1 + " username:" + paramString);
      if (bool1)
      {
        paramf = paramf.buContext;
        if (paramf != null) {
          break label162;
        }
        paramf = null;
        label87:
        paramf = (Map)paramf;
        if (parama == null) {
          break label190;
        }
        Object localObject2 = (bhj)parama.ott;
        if (localObject2 == null) {
          break label190;
        }
        localObject2 = ((bhj)localObject2).Ddj;
        if ((localObject2 == null) || (((bgh)localObject2).ZPQ != 1)) {
          break label190;
        }
      }
    }
    for (;;)
    {
      paramf.put(paramString, Boolean.valueOf(bool2));
      if (paramm != null) {
        break label196;
      }
      AppMethodBeat.o(359551);
      return null;
      bool1 = false;
      break;
      label162:
      paramf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (paramf == null)
      {
        paramf = null;
        break label87;
      }
      paramf = paramf.EcN;
      break label87;
      label190:
      bool2 = false;
    }
    label196:
    if (parama == null) {
      paramf = localObject1;
    }
    for (;;)
    {
      paramm.invoke(Boolean.valueOf(bool1), paramf);
      paramf = ah.aiuX;
      AppMethodBeat.o(359551);
      return paramf;
      paramString = (bhj)parama.ott;
      paramf = localObject1;
      if (paramString != null) {
        paramf = paramString.Ddj;
      }
    }
  }
  
  private static final ah a(f paramf, kotlin.g.a.m paramm, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(359557);
    kotlin.g.b.s.u(paramf, "this$0");
    int i = parama.errType;
    int j = parama.errCode;
    Log.i(paramf.TAG, "doGetGiftList errType:" + i + ", errCode:" + j);
    if ((i == 0) && (j == 0))
    {
      paramf = aj.CGT;
      aj.e(((bab)parama.ott).ZEQ);
      paramf = aj.CGT;
      aj.OR(((bab)parama.ott).ZKT);
      paramf = aj.CGT;
      aj.OS(((bab)parama.ott).ZKU);
      if (paramm == null)
      {
        AppMethodBeat.o(359557);
        return null;
      }
      paramm.invoke(Boolean.TRUE, Integer.valueOf(j));
      paramf = ah.aiuX;
      AppMethodBeat.o(359557);
      return paramf;
    }
    if (paramm == null)
    {
      AppMethodBeat.o(359557);
      return null;
    }
    paramm.invoke(Boolean.FALSE, Integer.valueOf(j));
    paramf = ah.aiuX;
    AppMethodBeat.o(359557);
    return paramf;
  }
  
  private static final ah a(com.tencent.mm.plugin.finder.live.view.convert.h paramh, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(359654);
    kotlin.g.b.s.u(paramh, "$promotingInfo");
    b.c localc;
    Bundle localBundle;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = aj.CGT;
      parama = aj.elk();
      if (parama != null)
      {
        localc = b.c.ndP;
        localBundle = new Bundle();
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramh = com.tencent.mm.plugin.finder.live.utils.a.c((cc)paramh);
        if (paramh != null) {
          break label100;
        }
      }
    }
    label100:
    for (paramh = null;; paramh = paramh.toByteArray())
    {
      localBundle.putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", paramh);
      paramh = ah.aiuX;
      parama.statusChange(localc, localBundle);
      paramh = ah.aiuX;
      AppMethodBeat.o(359654);
      return paramh;
    }
  }
  
  private static final ah a(kotlin.g.a.r paramr, f paramf, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(359570);
    kotlin.g.b.s.u(paramf, "this$0");
    Object localObject;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localObject = (azv)parama.ott;
      if (localObject != null)
      {
        o localo = (o)paramf.business(o.class);
        kotlin.g.b.s.u(localObject, "resp");
        localo.EhQ.clear();
        localo.EhQ.addAll((Collection)((azv)localObject).ZKw);
        localo.EhS.clear();
        localo.EhS.addAll((Collection)((azv)localObject).ZKx);
        localo.EhT = ((azv)localObject).ZKz;
        localo.EhU = ((azv)localObject).ZKA;
        localo.EhR = ((azv)localObject).ZKB;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.DSe = ((azv)localObject).ZKz;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdW = ((azv)localObject).EdW;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdX = ((azv)localObject).EdX;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeE.clear();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeE.addAll((Collection)((azv)localObject).ZKC);
        localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
        {
          localObject = (o)paramf.business(o.class);
          paramf = ((o)((o)localObject).business(o.class)).EhR;
          if (paramf != null) {
            break label333;
          }
          paramf = null;
          Log.i("MMFinder.LiveOnlineMemberSlice", kotlin.g.b.s.X("online member enableComment:", paramf));
          paramf = ((o)((o)localObject).business(o.class)).EhR;
          if (paramf != null)
          {
            if (paramf.mXJ != 1) {
              break label344;
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((o)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecs = true;
          }
        }
      }
    }
    for (;;)
    {
      if (paramr != null) {
        break label368;
      }
      AppMethodBeat.o(359570);
      return null;
      label333:
      paramf = Integer.valueOf(paramf.mXJ);
      break;
      label344:
      if (paramf.mXJ == 0) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((o)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecs = false;
      }
    }
    label368:
    paramr.a(Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType), parama.errMsg, parama.ott);
    paramr = ah.aiuX;
    AppMethodBeat.o(359570);
    return paramr;
  }
  
  private static final void a(int paramInt1, int paramInt2, f paramf, Context paramContext, DialogInterface paramDialogInterface, int paramInt3)
  {
    AppMethodBeat.i(359607);
    kotlin.g.b.s.u(paramf, "this$0");
    kotlin.g.b.s.u(paramContext, "$context");
    paramDialogInterface.dismiss();
    paramDialogInterface = "qqmusic://qq.com/media/playSonglist?p=%7b%22song%22%3a%5b%7b%22type%22%3a%220%22%2c%22songid%22%3a%22" + paramInt1 + "%22%2c%22songmid%22%3a%22" + paramInt2 + "%22%7d%5d%2c%22action%22%3a%22play%22%7d&source=https%3a%2f%2fi.y.qq.com%2fv8%2fplaysong.html%3fADTAG%3dhz_nb_wxzhibo1";
    Object localObject = Uri.parse(paramDialogInterface);
    if (localObject == null) {
      Log.w(paramf.TAG, "goQQMusic parse qq music action url fail, url %s", new Object[] { paramDialogInterface });
    }
    localObject = new Intent("android.intent.action.VIEW", (Uri)localObject);
    ((Intent)localObject).addFlags(268435456);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant", "goQQMusic$lambda-93", "(IILcom/tencent/mm/plugin/finder/live/model/FinderLiveAssistant;Landroid/content/Context;Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant", "goQQMusic$lambda-93", "(IILcom/tencent/mm/plugin/finder/live/model/FinderLiveAssistant;Landroid/content/Context;Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Log.i(paramf.TAG, "goQQMusic qqMusicActionUrl: %s", new Object[] { paramDialogInterface });
    com.tencent.mm.plugin.finder.live.report.k.Doi.Pm(q.bb.DAx.type);
    AppMethodBeat.o(359607);
  }
  
  private final void a(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg, boolean paramBoolean, com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(359515);
    if (parama != null)
    {
      Object localObject = com.tencent.mm.plugin.finder.live.n.BxF;
      com.tencent.mm.plugin.finder.live.n.a(this.buContext, paramg, true);
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramg.euz = com.tencent.mm.plugin.finder.live.utils.a.bUq();
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      String str = paramg.appId;
      kotlin.g.b.s.s(str, "bundle.appId");
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).ayx(str);
      localObject = paramg.appId;
      kotlin.g.b.s.s(localObject, "bundle.appId");
      paramg.idh = ((ValueCallback)new com.tencent.mm.plugin.finder.live.m(parama, (String)localObject));
      paramg.qAL = 1000;
      parama = aj.CGT;
      aj.b(paramContext, paramg);
    }
    AppMethodBeat.o(359515);
  }
  
  private static final void a(f paramf, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(359617);
    kotlin.g.b.s.u(paramf, "this$0");
    paramDialogInterface.dismiss();
    Log.i(paramf.TAG, "goQQMusic cancel");
    AppMethodBeat.o(359617);
  }
  
  private static final void a(f paramf, com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(359642);
    kotlin.g.b.s.u(paramf, "this$0");
    AppMethodBeat.o(359642);
  }
  
  private final void a(diy paramdiy, TRTCCloudDef.TRTCParams paramTRTCParams, com.tencent.mm.live.core.core.model.g paramg, bip parambip)
  {
    AppMethodBeat.i(359501);
    Object localObject1 = paramdiy.aaOA;
    Object localObject2 = paramdiy.aaOB;
    diw localdiw = paramdiy.aaOC;
    Object localObject3;
    boolean bool1;
    boolean bool2;
    label69:
    int i;
    if (localObject1 != null)
    {
      localObject3 = com.tencent.d.a.a.a.a.a.ahiX;
      if ((!com.tencent.d.a.a.a.a.a.jTE()) || (((diz)localObject1).aaOO <= 0)) {
        break label777;
      }
      bool1 = true;
      boolean bool3 = com.tencent.mm.modelcontrol.e.bIx();
      if ((!bool1) || (!bool3)) {
        break label783;
      }
      bool2 = true;
      localObject3 = com.tencent.d.a.a.a.a.a.ahiX;
      boolean bool4 = com.tencent.d.a.a.a.a.a.jTF();
      Log.i(this.TAG, "processLiveSdkParams enableHEVCEncFromSvr:" + bool1 + ", sdkenable:" + ((diz)localObject1).aaOO + ", enableHEVCEncFromLocal:" + bool3 + ", isHEVCEncEnable:" + bool2 + ", isForceHEVCMixing:" + bool4);
      com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTq = bool2;
      com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTr = bool4;
      if (((diz)localObject1).aaOD > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mSZ = ((diz)localObject1).aaOD;
      }
      if (((diz)localObject1).aaOF > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTa = ((diz)localObject1).aaOF;
      }
      if (((diz)localObject1).aaOG > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mVideoBitrate = ((diz)localObject1).aaOG;
      }
      if (((diz)localObject1).aaON > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mMinVideoBitrate = ((diz)localObject1).aaON;
      }
      if (((diz)localObject1).aaOP > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTb = ((diz)localObject1).aaOP;
      }
      if (((diz)localObject1).aaOQ > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTc = ((diz)localObject1).aaOQ;
      }
      if (((diz)localObject1).aaOR > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTd = ((diz)localObject1).aaOR;
      }
      if (((diz)localObject1).aaOS > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTe = ((diz)localObject1).aaOS;
      }
      if (((diz)localObject1).aaOI > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mQosPreference = ((diz)localObject1).aaOI;
      }
      i = ((diz)localObject1).aaOJ;
      if (i < 0) {
        break label795;
      }
      if (i > 1) {
        break label789;
      }
      i = 1;
      label392:
      if (i != 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mQosMode = ((diz)localObject1).aaOJ;
      }
    }
    if (localObject2 != null)
    {
      if (((div)localObject2).aaND > 0) {
        com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSP = ((div)localObject2).aaND;
      }
      Log.i(this.TAG, kotlin.g.b.s.X("processLiveSdkParams audioQuality:", Integer.valueOf(((div)localObject2).aaND)));
    }
    String str1;
    if (localdiw != null)
    {
      Log.i(this.TAG, "userDefineRecordId:" + localdiw.aaNE + ',' + localdiw.aaNF);
      localObject2 = localdiw.aaNF;
      localObject3 = localdiw.aaNE;
      i = localdiw.aaNO;
      str1 = localdiw.aaOl;
      bool1 = com.tencent.mm.modelcontrol.e.wb(5);
      localObject1 = ag.CGN;
      ag.qD(bool1);
      if ((bool1) || (i != com.tencent.mm.live.core.core.a.mJu.value)) {
        break label1668;
      }
      i = localdiw.aaNP;
    }
    label1668:
    for (int j = 1;; j = 0)
    {
      paramg.mNs = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveVideoDefinitionStorage().oD(paramg.liveId);
      paramg.mJU = localdiw.aaNP;
      label629:
      int k;
      if (i < 100)
      {
        paramg.a(com.tencent.mm.live.core.core.model.a.mMz);
        paramg.mNr = i;
        localObject1 = (Collection)localdiw.aaNK;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label843;
        }
        k = 1;
      }
      label777:
      label783:
      for (;;)
      {
        label657:
        if (k == 0)
        {
          localObject1 = localdiw.aaNK;
          kotlin.g.b.s.s(localObject1, "channelParams.cdn_trans_info");
          localObject1 = ((Iterable)localObject1).iterator();
          Object localObject4;
          Object localObject5;
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject4 = (xb)((Iterator)localObject1).next();
              localObject5 = (Map)paramg.mNt;
              k = ((xb)localObject4).ZeQ;
              String str2 = ((xb)localObject4).url;
              kotlin.g.b.s.s(str2, "it.url");
              ((Map)localObject5).put(Integer.valueOf(k), new com.tencent.mm.live.core.core.model.j(str2, ((xb)localObject4).ZeS, ((xb)localObject4).ZeT));
              continue;
              bool1 = false;
              break;
              bool2 = false;
              break label69;
              label789:
              i = 0;
              break label392;
              label795:
              i = 0;
              break label392;
              if (i == com.tencent.mm.live.core.core.a.mJv.value)
              {
                paramg.a(com.tencent.mm.live.core.core.model.a.mMA);
                break label629;
              }
              if (i != com.tencent.mm.live.core.core.a.mJw.value) {
                break label629;
              }
              paramg.a(com.tencent.mm.live.core.core.model.a.mMB);
              break label629;
              label843:
              k = 0;
              break label657;
            }
          }
          if (j != 0)
          {
            localObject1 = paramg.sQ(i);
            if (localObject1 != null) {
              break label1572;
            }
            localObject1 = null;
            localObject1 = (CharSequence)localObject1;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label1582;
            }
            j = 1;
            label895:
            if (j != 0)
            {
              localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
              if (((Number)com.tencent.d.a.a.a.a.a.jUC().bmg()).intValue() == 0)
              {
                j = localdiw.aaNO;
                localObject1 = (com.tencent.mm.live.core.core.model.j)paramg.mNt.get(Integer.valueOf(i));
                localObject4 = (com.tencent.mm.live.core.core.model.j)paramg.mNt.get(Integer.valueOf(j));
                if ((localObject1 != null) && (localObject4 != null))
                {
                  Log.i("LiveRoomInfo", kotlin.g.b.s.X("before exchangeCdnUrl:", paramg.mNt));
                  i = ((com.tencent.mm.live.core.core.model.j)localObject1).level;
                  localObject5 = ((com.tencent.mm.live.core.core.model.j)localObject1).desc;
                  ((com.tencent.mm.live.core.core.model.j)localObject1).level = ((com.tencent.mm.live.core.core.model.j)localObject4).level;
                  ((com.tencent.mm.live.core.core.model.j)localObject1).desc = ((com.tencent.mm.live.core.core.model.j)localObject4).desc;
                  ((com.tencent.mm.live.core.core.model.j)localObject4).level = i;
                  ((com.tencent.mm.live.core.core.model.j)localObject4).desc = ((String)localObject5);
                  Log.i("LiveRoomInfo", kotlin.g.b.s.X("after exchangeCdnUrl:", paramg.mNt));
                }
              }
            }
          }
        }
      }
      if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil((String)localObject3)) || (!Util.isNullOrNil(str1)))
      {
        localObject1 = new com.tencent.mm.ad.i();
        if (!Util.isNullOrNil((String)localObject2)) {
          ((com.tencent.mm.ad.i)localObject1).m("userdefine_streamid_main", localObject2);
        }
        if (!Util.isNullOrNil((String)localObject3)) {
          ((com.tencent.mm.ad.i)localObject1).m("userdefine_record_id", localObject3);
        }
        if (!Util.isNullOrNil(str1)) {
          ((com.tencent.mm.ad.i)localObject1).m("userdefine_push_args", str1);
        }
        localObject2 = new com.tencent.mm.ad.i();
        ((com.tencent.mm.ad.i)localObject2).m("Str_uc_params", localObject1);
        paramTRTCParams.businessInfo = ((com.tencent.mm.ad.i)localObject2).toString();
      }
      paramg.a(localdiw);
      Log.i(this.TAG, "processLiveSdkParams cdnQualitySvrcfg" + paramg.mNr + " cdnSwitchMode:" + paramg.mNq + " cdn_quality_h265backcfg:" + paramg.mJU);
      if (localdiw != null)
      {
        paramTRTCParams = com.tencent.d.a.a.a.a.a.ahiX;
        if (((Number)com.tencent.d.a.a.a.a.a.jUG().bmg()).intValue() == 1)
        {
          i = 1;
          label1257:
          if ((i == 0) || (parambip.ZSl != 1)) {
            break label1594;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcX = 0;
          label1285:
          paramTRTCParams = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (paramdiy.aaOC.aaNQ != 1) {
            break label1615;
          }
          bool1 = true;
          label1310:
          paramTRTCParams.EdC = bool1;
          paramTRTCParams = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (paramdiy.aaOC.aaNR != 1) {
            break label1621;
          }
          bool1 = true;
          label1341:
          paramTRTCParams.EdD = bool1;
          i = paramdiy.aaOC.aaOm;
          if (2 > i) {
            break label1633;
          }
          if (i > 50) {
            break label1627;
          }
          i = 1;
          label1372:
          if (i == 0) {
            break label1639;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdE = paramdiy.aaOC.aaOm;
        }
      }
      else
      {
        label1397:
        paramdiy = aw.Gjk;
        if (aw.bgV())
        {
          paramdiy = com.tencent.d.a.a.a.a.a.ahiX;
          if (com.tencent.d.a.a.a.a.a.jTH()) {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcX = 1;
          }
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeA = com.tencent.mm.ae.d.ee(paramg.mNu, 2);
        paramTRTCParams = this.TAG;
        parambip = new StringBuilder("processLiveSdkParams support_screen_rotate:");
        if (localdiw != null) {
          break label1656;
        }
      }
      label1572:
      label1582:
      label1594:
      label1615:
      label1621:
      label1627:
      label1633:
      label1639:
      label1656:
      for (paramdiy = null;; paramdiy = Integer.valueOf(localdiw.ZUH))
      {
        paramdiy = parambip.append(paramdiy).append(",config:");
        parambip = com.tencent.d.a.a.a.a.a.ahiX;
        Log.i(paramTRTCParams, com.tencent.d.a.a.a.a.a.jTH() + ", qosReport:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdC + ", qosControl:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdD + ", seiMode:" + paramg.mNu);
        AppMethodBeat.o(359501);
        return;
        localObject1 = ((com.tencent.mm.live.core.core.model.j)localObject1).desc;
        break;
        j = 0;
        break label895;
        i = 0;
        break label1257;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcX = localdiw.ZUH;
        break label1285;
        bool1 = false;
        break label1310;
        bool1 = false;
        break label1341;
        i = 0;
        break label1372;
        i = 0;
        break label1372;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdE = 2;
        break label1397;
      }
    }
  }
  
  public static com.tencent.mm.plugin.wallet.wecoin.a.c az(Activity paramActivity)
  {
    AppMethodBeat.i(359524);
    kotlin.g.b.s.u(paramActivity, "context");
    paramActivity = ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).T((Context)paramActivity, true);
    AppMethodBeat.o(359524);
    return paramActivity;
  }
  
  private static final ah b(f paramf, com.tencent.mm.am.b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(359581);
    kotlin.g.b.s.u(paramf, "this$0");
    String str;
    StringBuilder localStringBuilder;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = ((bht)parama.ott).ZQZ;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).b(parama);
      paramf = bf.Evf;
      str = bf.access$getTAG$cp();
      localStringBuilder = new StringBuilder("doCgiToRefresh gameTeamInfo status:");
      if (parama != null) {
        break label125;
      }
      paramf = null;
      localStringBuilder = localStringBuilder.append(paramf).append(", in_teaming_up:");
      if (parama != null) {
        break label136;
      }
    }
    label136:
    for (paramf = localObject;; paramf = Integer.valueOf(parama.ZOK))
    {
      Log.i(str, paramf);
      paramf = ah.aiuX;
      AppMethodBeat.o(359581);
      return paramf;
      label125:
      paramf = Integer.valueOf(parama.status);
      break;
    }
  }
  
  private static final ah b(f paramf, kotlin.g.a.m paramm, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(359575);
    kotlin.g.b.s.u(paramf, "this$0");
    Log.i(paramf.TAG, "errType:" + parama.errType + " errCode:" + parama.errCode);
    if (paramm == null)
    {
      AppMethodBeat.o(359575);
      return null;
    }
    if (parama.errCode == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramm.invoke(Boolean.valueOf(bool), parama.errMsg);
      paramf = ah.aiuX;
      AppMethodBeat.o(359575);
      return paramf;
    }
  }
  
  private static final ah c(f paramf, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(359639);
    kotlin.g.b.s.u(paramf, "this$0");
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      Log.i(paramf.TAG, "post fastComment succ, errType = " + parama.errType + ", errCode = " + parama.errCode + ", errMsg = " + parama.errMsg);
    }
    for (;;)
    {
      paramf = ah.aiuX;
      AppMethodBeat.o(359639);
      return paramf;
      Log.i(paramf.TAG, "post fastComment fail, errType = " + parama.errType + ", errCode = " + parama.errCode + ", errMsg = " + parama.errMsg);
    }
  }
  
  private final bui eki()
  {
    AppMethodBeat.i(359444);
    Object localObject = new bui();
    Context localContext = getContext();
    if (localContext != null)
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = ((bn)com.tencent.mm.ui.component.k.nq(localContext).cq(bn.class)).fou();
    }
    AppMethodBeat.o(359444);
    return localObject;
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(359437);
    Object localObject = this.contextRef;
    if (localObject == null)
    {
      AppMethodBeat.o(359437);
      return null;
    }
    localObject = (Context)((WeakReference)localObject).get();
    AppMethodBeat.o(359437);
    return localObject;
  }
  
  private final String hK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(359458);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)paramString2).length() != 0) {
          break label66;
        }
      }
    }
    label66:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label71;
      }
      AppMethodBeat.o(359458);
      return "";
      i = 0;
      break;
    }
    label71:
    localObject = "";
    try
    {
      paramString1 = new JSONObject(kotlin.n.n.m(paramString1, ";", ",", false)).get(paramString2).toString();
      AppMethodBeat.o(359458);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.i(this.TAG, String.valueOf(paramString1.getMessage()));
        paramString1 = (String)localObject;
      }
    }
  }
  
  private final void showCenterCustomizeToast(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(359467);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ab(this, paramString, paramInt));
    AppMethodBeat.o(359467);
  }
  
  public final void OM(int paramInt)
  {
    AppMethodBeat.i(359942);
    Log.i(this.TAG, kotlin.g.b.s.X("[likeInfo] doLikeLive:", Integer.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      AppMethodBeat.o(359942);
      return;
    }
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcF += paramInt;
    localObject1 = eki();
    Object localObject2 = bi.ABn;
    localObject2 = bi.a((bui)localObject1);
    byte[] arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    String str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
    String str2 = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str2, "getMyFinderUsername()");
    localObject1 = new com.tencent.mm.plugin.finder.live.model.cgi.n((atz)localObject2, arrayOfByte, l1, paramInt, l2, str1, str2, (bui)localObject1, ekj()).bFJ().g(new f..ExternalSyntheticLambda10(this));
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      localObject2 = getContext();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(359942);
        throw ((Throwable)localObject1);
      }
      ((com.tencent.mm.cp.f)localObject1).a((com.tencent.mm.vending.e.b)localObject2);
    }
    AppMethodBeat.o(359942);
  }
  
  public final com.tencent.mm.plugin.wallet.wecoin.a.e a(final FragmentActivity paramFragmentActivity, int paramInt, final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(360268);
    kotlin.g.b.s.u(paramFragmentActivity, "context");
    kotlin.g.b.s.u(parama, "callback");
    Object localObject2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHQ();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Log.i(this.TAG, kotlin.g.b.s.X("showRechargeFoodsDialog sessionId:", localObject1));
    localObject2 = new com.tencent.mm.plugin.wallet.wecoin.a.h();
    ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject2).mScene = paramInt;
    ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject2).Vua = ((String)localObject1);
    ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject2).VtR = ((com.tencent.mm.plugin.wallet.wecoin.a.i)new ad(this, paramFragmentActivity, parama));
    ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject2).Vud = com.tencent.mm.plugin.wallet.wecoin.a.g.VtX;
    ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject2).VtZ = true;
    paramFragmentActivity = ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).a(paramFragmentActivity, (com.tencent.mm.plugin.wallet.wecoin.a.h)localObject2);
    AppMethodBeat.o(360268);
    return paramFragmentActivity;
  }
  
  public final String a(String paramString, int paramInt, com.tencent.mm.plugin.finder.live.model.cgi.w.a parama)
  {
    AppMethodBeat.i(359976);
    kotlin.g.b.s.u(paramString, "commentContent");
    bui localbui = eki();
    Object localObject = aw.Gjk;
    String str1 = aw.fgw();
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eea.add(str1);
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    byte[] arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    String str2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
    String str3 = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str3, "getMyFinderUsername()");
    localObject = com.tencent.mm.live.core.core.f.mMm.bee();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.live.core.core.model.e)localObject).mNe)
    {
      paramString = new com.tencent.mm.plugin.finder.live.model.cgi.w(l1, paramString, paramInt, arrayOfByte, l2, str2, str3, localbui, str1, (String)localObject, ekj(), (byte)0);
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
      {
        localObject = paramString.CJB.ZEc;
        if (localObject != null) {
          ((atz)localObject).ZEt = 3;
        }
      }
      paramString = paramString.bFJ().g(new f..ExternalSyntheticLambda7(parama, this));
      if (!(getContext() instanceof MMActivity)) {
        break label281;
      }
      parama = getContext();
      if (parama != null) {
        break;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(359976);
      throw paramString;
    }
    paramString.a((com.tencent.mm.vending.e.b)parama);
    label281:
    AppMethodBeat.o(359976);
    return str1;
  }
  
  public final void a(int paramInt1, int paramInt2, al.a parama)
  {
    AppMethodBeat.i(360351);
    parama = new al(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, com.tencent.mm.model.z.bAW(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, paramInt1, paramInt2, parama).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      Context localContext = getContext();
      if (localContext == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360351);
        throw parama;
      }
      parama.a((com.tencent.mm.vending.e.b)localContext);
    }
    AppMethodBeat.o(360351);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, com.tencent.mm.plugin.finder.live.model.cgi.g.a parama)
  {
    AppMethodBeat.i(360191);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool = com.tencent.mm.plugin.finder.live.utils.a.bUx();
    Object localObject3 = this.TAG;
    Object localObject2 = new StringBuilder("closeLinkMic isAnchor:").append(bool).append(", linkMicState:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy).append(", liveId:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId).append(", objectId:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN).append(", nonceId:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId).append(", scene:").append(paramInt).append(", userId:");
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = ((StringBuilder)localObject2).append(localObject1).append(", selfSdkId:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF()).append(", sessionId:");
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
      if (localObject1 != null) {
        break label454;
      }
      localObject1 = "";
    }
    for (;;)
    {
      Log.i((String)localObject3, (String)localObject1 + ", applySessionId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efs);
      long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
      localObject1 = paramString1;
      if (paramString1 == null) {
        localObject1 = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      paramString2 = new bdm();
      paramString2.session_id = paramString1;
      paramString1 = new bdz();
      paramString1.ZlX = ((String)localObject1);
      localObject1 = ah.aiuX;
      paramString2.ZNY = com.tencent.mm.bx.b.cX(paramString1.toByteArray());
      paramString2.msg_type = 20005;
      paramString1 = aw.Gjk;
      paramString2.Tro = aw.fgw();
      new com.tencent.mm.plugin.finder.live.model.cgi.g(l1, l2, (String)localObject2, (byte[])localObject3, paramInt, paramString2, parama).bFJ();
      AppMethodBeat.o(360191);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).mXL;
      break;
      label454:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).sessionId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, bgh parambgh, com.tencent.mm.plugin.finder.live.model.cgi.h.a parama)
  {
    AppMethodBeat.i(360244);
    Log.i(this.TAG, "closeLinkMicPk liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ", objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN + ", nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId + ", scene:" + paramInt + ", closeScene:1, sdkUserId:" + paramString1 + ", sessionId:" + paramString2);
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
    byte[] arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
    bdm localbdm = new bdm();
    localbdm.ZNW = parambgh;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(parambgh);
    parambgh = ah.aiuX;
    localbdm.ZOa = localLinkedList;
    localbdm.session_id = paramString2;
    paramString2 = new bea();
    paramString2.ZlX = paramString1;
    paramString2.scene = 1;
    paramString1 = ah.aiuX;
    localbdm.ZNY = com.tencent.mm.bx.b.cX(paramString2.toByteArray());
    localbdm.msg_type = 20017;
    paramString1 = aw.Gjk;
    localbdm.Tro = aw.fgw();
    paramString1 = new com.tencent.mm.plugin.finder.live.model.cgi.h(l1, l2, str, arrayOfByte, paramInt, localbdm, parama).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramString2 = getContext();
      if (paramString2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360244);
        throw paramString1;
      }
      paramString1.a((com.tencent.mm.vending.e.b)paramString2);
    }
    AppMethodBeat.o(360244);
  }
  
  public final void a(int paramInt, final kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super auv, ah> params)
  {
    AppMethodBeat.i(359927);
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    Log.i(this.TAG, "doCloseLive liveId:" + l1 + " objectId:" + l2 + " nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId);
    if ((l1 == 0L) || (l2 == 0L))
    {
      Log.i(this.TAG, "doCloseLive return by invalid params");
      AppMethodBeat.o(359927);
      return;
    }
    String str = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str, "getMyFinderUsername()");
    new com.tencent.mm.plugin.finder.live.model.cgi.f(l1, str, l2, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId, paramInt, (com.tencent.mm.plugin.finder.live.model.cgi.f.a)new c(this, params)).bFJ();
    new ia().publish();
    AppMethodBeat.o(359927);
  }
  
  public final void a(final long paramLong, final int paramInt, kotlin.g.a.u<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.live.core.core.model.g, ? super TRTCCloudDef.TRTCParams, ? super bca, ah> paramu)
  {
    AppMethodBeat.i(359895);
    com.tencent.mm.ae.d.e(this.TAG, (kotlin.g.a.a)new j(this, paramInt, paramLong, paramu));
    AppMethodBeat.o(359895);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.live.cgi.e.a parama)
  {
    AppMethodBeat.i(360020);
    Log.i(this.TAG, "setAnchorStatus liveId:" + paramLong1 + " objectId:" + paramLong2 + " flag:" + paramInt1 + " micSetting[" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Cvf.CJK + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Cvf.aaVw + ']');
    dom localdom = new dom();
    localdom.CJK = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Cvf.CJK;
    paramInt1 = ON(paramInt1);
    String str = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str, "getMyFinderUsername()");
    new com.tencent.mm.plugin.finder.live.cgi.e(paramLong1, paramLong2, paramInt1, str, paramInt2, localdom, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyq(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egu, 0L, parama, 256).bFJ();
    AppMethodBeat.o(360020);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, com.tencent.mm.plugin.finder.live.cgi.e.a parama)
  {
    AppMethodBeat.i(360013);
    Log.i(this.TAG, "setAnchorStatus opFlag:" + com.tencent.mm.ae.d.hF(paramLong3) + ", liveId:" + paramLong1 + " objectId:" + paramLong2 + " flag:" + paramInt1 + " micSetting[" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Cvf.CJK + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Cvf.aaVw + ']');
    paramInt1 = ON(paramInt1);
    String str = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str, "getMyFinderUsername()");
    new com.tencent.mm.plugin.finder.live.cgi.e(paramLong1, paramLong2, paramInt1, str, paramInt2, null, null, null, paramLong3, parama, 224).bFJ();
    AppMethodBeat.o(360013);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, com.tencent.mm.plugin.finder.live.cgi.e.a parama)
  {
    AppMethodBeat.i(360031);
    Log.i(this.TAG, "setMicSetting liveId:" + paramLong1 + " objectId:" + paramLong2 + " micSettingFlag:" + paramLong3 + " BUPROVIDER.get(LiveLinkMicSlice::class.java).micSetting[" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Cvf.CJK + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Cvf.aaVw + ']');
    Object localObject = new dom();
    ((dom)localObject).CJK = paramLong3;
    int i = ON(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
    String str = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str, "getMyFinderUsername()");
    e.b localb = com.tencent.mm.plugin.finder.live.cgi.e.CuZ;
    parama = new com.tencent.mm.plugin.finder.live.cgi.e(paramLong1, paramLong2, i, str, 0, (dom)localObject, null, null, com.tencent.mm.plugin.finder.live.cgi.e.ehn(), parama, 208).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      localObject = getContext();
      if (localObject == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360031);
        throw parama;
      }
      parama.a((com.tencent.mm.vending.e.b)localObject);
    }
    AppMethodBeat.o(360031);
  }
  
  public final void a(long paramLong1, long paramLong2, diq paramdiq, com.tencent.mm.plugin.finder.live.cgi.e.a parama)
  {
    AppMethodBeat.i(360045);
    kotlin.g.b.s.u(paramdiq, "lotterySetting");
    Log.i(this.TAG, "setMicSetting liveId:" + paramLong1 + " objectId:" + paramLong2 + " lotterySetting:" + paramdiq.CJK + ", " + paramdiq.BBE);
    int i = ON(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
    String str = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str, "getMyFinderUsername()");
    e.b localb = com.tencent.mm.plugin.finder.live.cgi.e.CuZ;
    paramdiq = new com.tencent.mm.plugin.finder.live.cgi.e(paramLong1, paramLong2, i, str, 0, null, null, paramdiq, com.tencent.mm.plugin.finder.live.cgi.e.ehn(), parama, 112).bFJ();
    parama = getContext();
    if ((parama != null) && ((parama instanceof MMActivity))) {
      paramdiq.a((com.tencent.mm.vending.e.b)parama);
    }
    AppMethodBeat.o(360045);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt1, bgh parambgh, int paramInt2, d.a parama)
  {
    AppMethodBeat.i(360167);
    Log.i(this.TAG, "applyLinkMic liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString + ", scene:" + paramInt1 + ", micType:" + paramInt2);
    bdm localbdm = new bdm();
    localbdm.ZNW = parambgh;
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(parambgh);
    parambgh = ah.aiuX;
    localbdm.ZOa = ((LinkedList)localObject);
    parambgh = new bds();
    parambgh.ZOf = paramInt2;
    localObject = ah.aiuX;
    localbdm.ZNY = com.tencent.mm.bx.b.cX(parambgh.toByteArray());
    localbdm.msg_type = 20003;
    parambgh = aw.Gjk;
    localbdm.Tro = aw.fgw();
    paramString = new com.tencent.mm.plugin.finder.live.model.cgi.d(paramLong1, paramLong2, paramString, paramArrayOfByte, paramInt1, localbdm, parama).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramArrayOfByte = getContext();
      if (paramArrayOfByte == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360167);
        throw paramString;
      }
      paramString.a((com.tencent.mm.vending.e.b)paramArrayOfByte);
    }
    AppMethodBeat.o(360167);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, bgh parambgh, int paramInt2, String paramString2, String paramString3, com.tencent.mm.plugin.finder.live.model.cgi.a.a parama)
  {
    AppMethodBeat.i(360176);
    Log.i(this.TAG, "acceptLinkMic liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString1 + ", scene:" + paramInt1 + ", micType:" + paramInt2 + ", userId:" + paramString2 + ", sessionId:" + paramString3);
    bdm localbdm = new bdm();
    localbdm.session_id = paramString3;
    localbdm.ZNW = parambgh;
    parambgh = new bdo();
    parambgh.ZOf = paramInt2;
    parambgh.ZlX = paramString2;
    paramString2 = ah.aiuX;
    localbdm.ZNY = com.tencent.mm.bx.b.cX(parambgh.toByteArray());
    localbdm.msg_type = 20004;
    parambgh = aw.Gjk;
    localbdm.Tro = aw.fgw();
    paramString1 = new com.tencent.mm.plugin.finder.live.model.cgi.a(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt1, localbdm, parama).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramArrayOfByte = getContext();
      if (paramArrayOfByte == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360176);
        throw paramString1;
      }
      paramString1.a((com.tencent.mm.vending.e.b)paramArrayOfByte);
    }
    AppMethodBeat.o(360176);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, bgh parambgh, String paramString2, int paramInt2, com.tencent.mm.bx.b paramb, com.tencent.mm.plugin.finder.live.model.cgi.e.a parama)
  {
    AppMethodBeat.i(360219);
    Log.i(this.TAG, "applyLinkMicPk liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString1 + ", scene:" + paramInt1 + ", sdkUserId:" + paramString2 + ", sdkLiveId:" + paramInt2);
    bdm localbdm = new bdm();
    localbdm.ZNW = parambgh;
    Object localObject2 = new LinkedList();
    Object localObject1 = parambgh;
    if (parambgh == null) {
      localObject1 = new bgh();
    }
    ((LinkedList)localObject2).add(localObject1);
    parambgh = ah.aiuX;
    localbdm.ZOa = ((LinkedList)localObject2);
    localObject2 = new bdt();
    parambgh = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
    int i;
    if (parambgh == null)
    {
      parambgh = null;
      localObject1 = (CharSequence)parambgh;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label420;
      }
      i = 1;
      label204:
      if (i == 0) {
        break label537;
      }
      parambgh = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
      if (parambgh != null) {
        break label426;
      }
      parambgh = "";
    }
    label537:
    for (;;)
    {
      ((bdt)localObject2).ZOx = parambgh;
      ((bdt)localObject2).ZOj = paramString2;
      ((bdt)localObject2).ZOk = paramInt2;
      ((bdt)localObject2).ZOn = paramb;
      parambgh = ah.aiuX;
      localbdm.ZNY = com.tencent.mm.bx.b.cX(((bdt)localObject2).toByteArray());
      localbdm.msg_type = 20015;
      parambgh = aw.Gjk;
      localbdm.Tro = aw.fgw();
      paramString1 = new com.tencent.mm.plugin.finder.live.model.cgi.e(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt1, localbdm, parama).bFJ();
      if ((getContext() != null) && ((getContext() instanceof MMActivity)))
      {
        paramArrayOfByte = getContext();
        if (paramArrayOfByte == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(360219);
          throw paramString1;
          parambgh = parambgh.objectDesc;
          if (parambgh == null)
          {
            parambgh = null;
            break;
          }
          parambgh = parambgh.liveDesc;
          if (parambgh == null)
          {
            parambgh = null;
            break;
          }
          parambgh = parambgh.EcY;
          break;
          label420:
          i = 0;
          break label204;
          label426:
          parambgh = parambgh.objectDesc;
          if (parambgh == null)
          {
            parambgh = "";
            continue;
          }
          parambgh = parambgh.media;
          if (parambgh == null)
          {
            parambgh = "";
            continue;
          }
          parambgh = (FinderMedia)kotlin.a.p.oL((List)parambgh);
          if (parambgh == null)
          {
            parambgh = "";
            continue;
          }
          localObject1 = parambgh.url;
          parambgh = (bgh)localObject1;
          if (localObject1 != null) {
            continue;
          }
          parambgh = "";
          continue;
        }
        paramString1.a((com.tencent.mm.vending.e.b)paramArrayOfByte);
      }
      AppMethodBeat.o(360219);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, bgh parambgh, String paramString2, int paramInt2, String paramString3, com.tencent.mm.bx.b paramb, com.tencent.mm.plugin.finder.live.model.cgi.b.a parama)
  {
    AppMethodBeat.i(360233);
    Log.i(this.TAG, "acceptLinkMicPk liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString1 + ", scene:" + paramInt1 + ", sdkUserId:" + paramString2 + ", sdkLiveId:" + paramInt2 + ", sessionId:" + paramString3);
    bdm localbdm = new bdm();
    localbdm.ZNW = parambgh;
    Object localObject2 = new LinkedList();
    Object localObject1;
    label193:
    int i;
    if (parambgh == null)
    {
      localObject1 = new bgh();
      ((LinkedList)localObject2).add(localObject1);
      localObject1 = ah.aiuX;
      localbdm.ZOa = ((LinkedList)localObject2);
      localbdm.session_id = paramString3;
      localObject2 = new bdp();
      paramString3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
      if (paramString3 != null) {
        break label412;
      }
      paramString3 = null;
      localObject1 = (CharSequence)paramString3;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label458;
      }
      i = 1;
      label218:
      if (i == 0) {
        break label599;
      }
      paramString3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
      if (paramString3 != null) {
        break label464;
      }
      paramString3 = "";
    }
    label412:
    label458:
    label464:
    label592:
    label599:
    for (;;)
    {
      label248:
      ((bdp)localObject2).ZOm = paramString3;
      if (parambgh == null) {
        parambgh = "";
      }
      for (;;)
      {
        ((bdp)localObject2).ZOl = parambgh;
        ((bdp)localObject2).ZOj = paramString2;
        ((bdp)localObject2).ZOk = paramInt2;
        ((bdp)localObject2).ZOn = paramb;
        parambgh = ah.aiuX;
        localbdm.ZNY = com.tencent.mm.bx.b.cX(((bdp)localObject2).toByteArray());
        localbdm.msg_type = 20016;
        parambgh = aw.Gjk;
        localbdm.Tro = aw.fgw();
        paramString1 = new com.tencent.mm.plugin.finder.live.model.cgi.b(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt1, localbdm, parama).bFJ();
        if ((getContext() == null) || (!(getContext() instanceof MMActivity))) {
          break label592;
        }
        paramArrayOfByte = getContext();
        if (paramArrayOfByte != null) {
          break label578;
        }
        paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360233);
        throw paramString1;
        localObject1 = parambgh;
        break;
        paramString3 = paramString3.objectDesc;
        if (paramString3 == null)
        {
          paramString3 = null;
          break label193;
        }
        paramString3 = paramString3.liveDesc;
        if (paramString3 == null)
        {
          paramString3 = null;
          break label193;
        }
        paramString3 = paramString3.EcY;
        break label193;
        i = 0;
        break label218;
        paramString3 = paramString3.objectDesc;
        if (paramString3 == null)
        {
          paramString3 = "";
          break label248;
        }
        paramString3 = paramString3.media;
        if (paramString3 == null)
        {
          paramString3 = "";
          break label248;
        }
        paramString3 = (FinderMedia)kotlin.a.p.oL((List)paramString3);
        if (paramString3 == null)
        {
          paramString3 = "";
          break label248;
        }
        localObject1 = paramString3.url;
        paramString3 = (String)localObject1;
        if (localObject1 != null) {
          break label248;
        }
        paramString3 = "";
        break label248;
        paramString3 = parambgh.ZOx;
        parambgh = paramString3;
        if (paramString3 == null) {
          parambgh = "";
        }
      }
      paramString1.a((com.tencent.mm.vending.e.b)paramArrayOfByte);
      AppMethodBeat.o(360233);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, bgh parambgh, String paramString2, p.a parama)
  {
    AppMethodBeat.i(360373);
    Log.i(this.TAG, "acceptBattle liveId:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " battleId:" + paramString2);
    bdm localbdm = new bdm();
    localbdm.session_id = paramString2;
    localbdm.ZNW = parambgh;
    paramString2 = new LinkedList();
    paramString2.add(parambgh);
    parambgh = ah.aiuX;
    localbdm.ZOa = paramString2;
    parambgh = new bdn();
    paramString2 = ah.aiuX;
    localbdm.ZNY = com.tencent.mm.bx.b.cX(parambgh.toByteArray());
    localbdm.msg_type = 20027;
    parambgh = aw.Gjk;
    localbdm.Tro = aw.fgw();
    paramString1 = new com.tencent.mm.plugin.finder.live.model.cgi.p(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt, localbdm).bFJ().g(new f..ExternalSyntheticLambda4(parama));
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramArrayOfByte = getContext();
      if (paramArrayOfByte == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360373);
        throw paramString1;
      }
      paramString1.a((com.tencent.mm.vending.e.b)paramArrayOfByte);
    }
    AppMethodBeat.o(360373);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, bgh parambgh, String paramString2, q.a parama)
  {
    AppMethodBeat.i(360361);
    Log.i(this.TAG, "applyBattle liveId:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " micId:" + paramString2);
    bdm localbdm = new bdm();
    localbdm.ZNW = parambgh;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(parambgh);
    parambgh = ah.aiuX;
    localbdm.ZOa = localLinkedList;
    parambgh = new bdr();
    parambgh.ZOt = paramString2;
    paramString2 = ah.aiuX;
    localbdm.ZNY = com.tencent.mm.bx.b.cX(parambgh.toByteArray());
    localbdm.msg_type = 20026;
    parambgh = aw.Gjk;
    localbdm.Tro = aw.fgw();
    paramString1 = new com.tencent.mm.plugin.finder.live.model.cgi.q(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt, localbdm).bFJ().g(new f..ExternalSyntheticLambda5(parama));
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramArrayOfByte = getContext();
      if (paramArrayOfByte == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360361);
        throw paramString1;
      }
      paramString1.a((com.tencent.mm.vending.e.b)paramArrayOfByte);
    }
    AppMethodBeat.o(360361);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, bgh parambgh, String paramString2, v.a parama)
  {
    AppMethodBeat.i(360380);
    Log.i(this.TAG, "closeBattle liveId:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " micId:" + paramString2);
    bdm localbdm = new bdm();
    localbdm.session_id = paramString2;
    localbdm.ZNW = parambgh;
    paramString2 = new LinkedList();
    paramString2.add(parambgh);
    parambgh = ah.aiuX;
    localbdm.ZOa = paramString2;
    parambgh = new bdy();
    parambgh.scene = parambgh.scene;
    paramString2 = ah.aiuX;
    localbdm.ZNY = com.tencent.mm.bx.b.cX(parambgh.toByteArray());
    localbdm.msg_type = 20028;
    parambgh = aw.Gjk;
    localbdm.Tro = aw.fgw();
    paramString1 = new v(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt, localbdm).bFJ().g(new f..ExternalSyntheticLambda6(parama));
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramArrayOfByte = getContext();
      if (paramArrayOfByte == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360380);
        throw paramString1;
      }
      paramString1.a((com.tencent.mm.vending.e.b)paramArrayOfByte);
    }
    AppMethodBeat.o(360380);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, List<String> paramList, ae.a parama)
  {
    AppMethodBeat.i(360332);
    kotlin.g.b.s.u(paramString, "nonceId");
    kotlin.g.b.s.u(paramList, "sendIdList");
    paramString = new ae(paramLong1, paramLong2, paramString, paramArrayOfByte, paramInt, paramList).bFJ().g(new f..ExternalSyntheticLambda3(parama));
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramArrayOfByte = getContext();
      if (paramArrayOfByte == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360332);
        throw paramString;
      }
      paramString.a((com.tencent.mm.vending.e.b)paramArrayOfByte);
    }
    AppMethodBeat.o(360332);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(360325);
    paramString1 = new ax(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramString2).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramArrayOfByte = getContext();
      if (paramArrayOfByte == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360325);
        throw paramString1;
      }
      paramString1.a((com.tencent.mm.vending.e.b)paramArrayOfByte);
    }
    AppMethodBeat.o(360325);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, LinkedList<String> paramLinkedList, s.a parama)
  {
    AppMethodBeat.i(360201);
    kotlin.g.b.s.u(paramLinkedList, "usernameList");
    Log.i(this.TAG, "batchGetMicContact liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString + ", scene:1");
    paramString = new com.tencent.mm.plugin.finder.live.model.cgi.s(paramLong1, paramLong2, paramString, paramArrayOfByte, paramLinkedList, parama).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramArrayOfByte = getContext();
      if (paramArrayOfByte == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360201);
        throw paramString;
      }
      paramString.a((com.tencent.mm.vending.e.b)paramArrayOfByte);
    }
    AppMethodBeat.o(360201);
  }
  
  public final void a(long paramLong, kotlin.g.a.m<? super Long, ? super Long, ah> paramm)
  {
    AppMethodBeat.i(360254);
    Log.i(this.TAG, kotlin.g.b.s.X("[WeCoin] getWeCoinBalance: requestId:", Long.valueOf(paramLong)));
    ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).a((com.tencent.mm.plugin.wallet.wecoin.a.i)new f.q(this, paramLong, paramm), getContext());
    AppMethodBeat.o(360254);
  }
  
  public final void a(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, int paramInt, LinkedList<Integer> paramLinkedList, com.tencent.mm.plugin.finder.live.model.cgi.t.a parama)
  {
    AppMethodBeat.i(360338);
    kotlin.g.b.s.u(paramLinkedList, "songIdList");
    kotlin.g.b.s.u(parama, "callback");
    paramArrayOfByte = new com.tencent.mm.plugin.finder.live.model.cgi.t(paramLong1, paramArrayOfByte, paramString, paramLong2, paramInt, paramLinkedList, parama).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramString = getContext();
      if (paramString == null)
      {
        paramArrayOfByte = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360338);
        throw paramArrayOfByte;
      }
      paramArrayOfByte.a((com.tencent.mm.vending.e.b)paramString);
    }
    AppMethodBeat.o(360338);
  }
  
  public final void a(Activity paramActivity, bls parambls, ResultReceiver paramResultReceiver, kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(360289);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(parambls, "luckyMoneySendInfo");
    Log.i(this.TAG, kotlin.g.b.s.X("goReceiveLuckyMoney visitorRole:", Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.ZNI)));
    Bundle localBundle = new Bundle();
    Object localObject;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.ZNI == 3)
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
      {
        paramb.invoke(Integer.valueOf(1));
        com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.bi.DBd, q.bh.DAQ, true);
        AppMethodBeat.o(360289);
        return;
      }
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.ZNI == 2)
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
      {
        paramb.invoke(Integer.valueOf(2));
        com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.bi.DBd, q.bh.DAQ, true);
        AppMethodBeat.o(360289);
        return;
      }
    }
    String str;
    label247:
    com.tencent.mm.message.k.b localb;
    int i;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.ZNI != 1)
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {}
    }
    else
    {
      localObject = null;
      str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHQ();
      if (str != null) {
        break label574;
      }
      str = "";
      localb = com.tencent.mm.message.k.b.Hf(parambls.ZSV);
      if (!Util.isNullOrNil(parambls.ZPd)) {
        break label577;
      }
      i = 1;
      label269:
      localBundle.putInt("key_live_anchor_type", i);
      localBundle.putString("key_live_error_msg", (String)localObject);
      localBundle.putString("key_live_id", com.tencent.mm.ae.d.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
      localBundle.putString("key_live_attach", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdQ.EbZ);
      localBundle.putInt("key_from", 3);
      localBundle.putString("key_session_id", str);
      localBundle.putString("key_username", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      if (paramResultReceiver != null) {
        break label583;
      }
    }
    label574:
    label577:
    label583:
    for (parambls = new ResultReceiver(MMHandler.createFreeHandler(Looper.getMainLooper()));; parambls = paramResultReceiver)
    {
      localBundle.putParcelable("key_open_result_receiver", (Parcelable)parambls);
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).gotoLuckyMoneyReceiveUI((Context)paramActivity, localBundle, localb);
      Log.i(this.TAG, "goReceiveLuckyMoney liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ", clientBuff:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdQ.EbZ + ", sessionId:" + str + ", anchorUsername:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC + ", appMsgContent:" + localb);
      paramb.invoke(Integer.valueOf(0));
      AppMethodBeat.o(360289);
      return;
      localObject = paramActivity.getResources().getString(p.h.CpJ);
      break;
      break label247;
      i = 2;
      break label269;
    }
  }
  
  public final void a(final Context paramContext, long paramLong1, long paramLong2, cbm paramcbm, com.tencent.mm.plugin.finder.live.cgi.e.a parama)
  {
    AppMethodBeat.i(360041);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramcbm, "gameTeamSetting");
    Log.i(this.TAG, "setGameTeamMode liveId:" + paramLong1 + " objectId:" + paramLong2 + " gameTeamMode:" + paramcbm);
    int i = ON(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
    String str = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str, "getMyFinderUsername()");
    e.b localb = com.tencent.mm.plugin.finder.live.cgi.e.CuZ;
    paramcbm = new com.tencent.mm.plugin.finder.live.cgi.e(paramLong1, paramLong2, i, str, 0, null, paramcbm, null, com.tencent.mm.plugin.finder.live.cgi.e.ehn(), (com.tencent.mm.plugin.finder.live.cgi.e.a)new aa(parama, paramContext), 176).e(paramContext, paramContext.getResources().getString(p.h.finder_waiting), 500L).bFJ();
    if ((paramContext instanceof MMActivity)) {
      paramcbm.a((com.tencent.mm.vending.e.b)paramContext);
    }
    AppMethodBeat.o(360041);
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, Long paramLong1)
  {
    AppMethodBeat.i(360129);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "username");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI = false;
    ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a(paramContext, paramLong, paramString, paramLong1, 62);
    AppMethodBeat.o(360129);
  }
  
  public final void a(Context paramContext, Intent paramIntent, Integer paramInteger)
  {
    AppMethodBeat.i(360135);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "intent");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI = false;
    if (paramInteger != null)
    {
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent, paramInteger.intValue());
      AppMethodBeat.o(360135);
      return;
    }
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    AppMethodBeat.o(360135);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg, com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(360099);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramg, "bundle");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("open fullscreen miniPro appId:").append(paramg.appId).append(",patch:").append(paramg.qAF).append(",luanchFromApp:true,is test:");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    Log.i(str, com.tencent.mm.plugin.finder.live.utils.a.bUq());
    if ((Util.isNullOrNil(paramg.appId)) || (Util.isNullOrNil(paramg.qAF)))
    {
      AppMethodBeat.o(360099);
      return;
    }
    paramg.epq = com.tencent.mm.plugin.appbrand.config.z.raX;
    a(paramContext, paramg, true, parama);
    AppMethodBeat.o(360099);
  }
  
  public final void a(Context paramContext, final String paramString1, final int paramInt1, final int paramInt2, final String paramString2, String paramString3, int paramInt3, com.tencent.mm.bx.b paramb, final ax.a parama)
  {
    AppMethodBeat.i(360068);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString3, "sendGiftTargetUserName");
    final WeakReference localWeakReference = new WeakReference(paramContext);
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyr()) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 70);
      String str = com.tencent.mm.model.z.bAW();
      Object localObject1 = aw.Gjk;
      localObject1 = aw.fgw();
      com.tencent.mm.plugin.report.service.h.OAn.b(22129, new Object[] { Integer.valueOf(1), localObject1, "", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "" });
      Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = ((bn)com.tencent.mm.ui.component.k.nq(paramContext).cq(bn.class)).fou();
      paramString1 = new ar(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, paramString1, paramInt1, str, paramInt2, (String)localObject1, paramString2, paramString3, (bui)localObject2, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).sessionBuffer, paramInt3, paramb, (ar.a)new l(this, paramInt2, parama, (String)localObject1, localWeakReference, paramString1, paramInt1, paramString2)).bFJ();
      if ((paramContext instanceof MMActivity)) {
        paramString1.a((com.tencent.mm.vending.e.b)paramContext);
      }
    }
    AppMethodBeat.o(360068);
  }
  
  public final void a(u.a parama)
  {
    AppMethodBeat.i(359960);
    bi localbi = bi.ABn;
    new com.tencent.mm.plugin.finder.live.model.cgi.u(bi.dVu(), com.tencent.mm.model.z.bAW(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecz, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp, parama).bFJ();
    AppMethodBeat.o(359960);
  }
  
  public final void a(MMActivity paramMMActivity, long paramLong1, long paramLong2, String paramString, auw paramauw, kotlin.g.a.q<? super Boolean, ? super String, ? super bkd, ah> paramq)
  {
    AppMethodBeat.i(360396);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    kotlin.g.b.s.u(paramString, "audienceUsername");
    kotlin.g.b.s.u(paramauw, "finderCmdItem");
    new ak(paramLong1, paramLong2, paramString, paramauw, (ak.a)new f.t(paramq, paramauw, this)).bFJ().a((com.tencent.mm.vending.e.b)paramMMActivity);
    AppMethodBeat.o(360396);
  }
  
  public final void a(MMActivity paramMMActivity, long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, final String paramString2, int paramInt, String paramString3, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(360390);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    kotlin.g.b.s.u(paramString1, "anchorUsername");
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    final int i;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).EhX) {
        i = 2;
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMMActivity).cq(bn.class)).fou();
      String str = com.tencent.mm.model.z.bAW();
      kotlin.g.b.s.s(str, "getMyFinderUsername()");
      new com.tencent.mm.plugin.finder.live.model.cgi.af(paramLong1, paramLong2, paramString1, paramArrayOfByte, i, str, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).hOG, paramString2, paramInt, (bui)localObject, paramString3, (af.a)new p(this, paramb, i, paramString2), (byte)0).bFJ().a((com.tencent.mm.vending.e.b)paramMMActivity);
      AppMethodBeat.o(360390);
      return;
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public final void a(MMActivity paramMMActivity, long paramLong, kotlin.g.a.m<? super Boolean, ? super bif, ah> paramm)
  {
    AppMethodBeat.i(360448);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    new ba(paramLong, (ba.a)new f.o(paramm)).bFJ().a((com.tencent.mm.vending.e.b)paramMMActivity);
    AppMethodBeat.o(360448);
  }
  
  public final void a(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.live.view.convert.k paramk, kotlin.g.a.m<? super Boolean, ? super blp, ah> paramm)
  {
    AppMethodBeat.i(360430);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    kotlin.g.b.s.u(paramk, "product");
    LinkedList localLinkedList = new LinkedList();
    paramk = paramk.DVj.aaig;
    if (paramk != null)
    {
      paramk = kotlin.a.p.l((Iterable)paramk);
      if (paramk != null)
      {
        paramk = ((Iterable)paramk).iterator();
        while (paramk.hasNext())
        {
          Object localObject = (agn)paramk.next();
          if (((agn)localObject).ZpJ > 0)
          {
            localObject = ((agn)localObject).mdE;
            if (localObject != null) {
              localLinkedList.add(localObject);
            }
          }
        }
      }
    }
    if (localLinkedList.isEmpty())
    {
      Log.i(this.TAG, "empty stockIds");
      paramm.invoke(Boolean.TRUE, null);
      AppMethodBeat.o(360430);
      return;
    }
    a(paramMMActivity, localLinkedList, false, (kotlin.g.a.m)new f.x(this, paramm));
    AppMethodBeat.o(360430);
  }
  
  public final void a(MMActivity paramMMActivity, String paramString, int paramInt, kotlin.g.a.m<? super Boolean, ? super bir, ah> paramm)
  {
    AppMethodBeat.i(360410);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    kotlin.g.b.s.u(paramString, "stockId");
    new com.tencent.mm.plugin.finder.live.model.cgi.ag(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, paramString, paramInt, (ag.a)new f.s(paramm)).bFJ().a((com.tencent.mm.vending.e.b)paramMMActivity);
    AppMethodBeat.o(360410);
  }
  
  public final void a(MMActivity paramMMActivity, LinkedList<String> paramLinkedList, boolean paramBoolean, kotlin.g.a.m<? super Boolean, ? super blp, ah> paramm)
  {
    AppMethodBeat.i(360421);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    kotlin.g.b.s.u(paramLinkedList, "stockIds");
    int i;
    long l1;
    long l2;
    String str;
    if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaO, 4) == 3)
    {
      i = 1;
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.J((Context)paramMMActivity, true);
      l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
      if (i == 0) {
        break label181;
      }
    }
    label181:
    for (Object localObject = com.tencent.mm.model.z.bAW();; localObject = null)
    {
      new ao(l1, l2, str, (String)localObject, com.tencent.mm.bx.b.cX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp), paramLinkedList, (ao.a)new f.y(paramMMActivity, paramm, paramBoolean)).bFJ().a((com.tencent.mm.vending.e.b)paramMMActivity);
      AppMethodBeat.o(360421);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(MMActivity paramMMActivity, kotlin.g.a.m<? super Boolean, ? super bhl, ah> paramm)
  {
    AppMethodBeat.i(360403);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    new com.tencent.mm.plugin.finder.live.model.cgi.aa(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eil, (aa.a)new f.m(this, paramm)).bFJ().a((com.tencent.mm.vending.e.b)paramMMActivity);
    AppMethodBeat.o(360403);
  }
  
  public final void a(String paramString, com.tencent.mm.bx.b paramb, ad.a parama)
  {
    AppMethodBeat.i(360157);
    kotlin.g.b.s.u(paramString, "lotteryId");
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    int i;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject1 = l.k.mYO;
      i = l.k.bhG();
      localObject1 = com.tencent.mm.model.z.bAW();
      kotlin.g.b.s.s(localObject1, "getMyFinderUsername()");
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
      if (localObject2 != null) {
        break label194;
      }
    }
    label194:
    for (Object localObject2 = null;; localObject2 = Long.valueOf(((bip)localObject2).liveId))
    {
      paramString = new ad(i, (String)localObject1, ((Long)localObject2).longValue(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId, paramString, paramb).bFJ();
      if ((getContext() == null) || (!(getContext() instanceof MMActivity))) {
        break label219;
      }
      paramb = getContext();
      if (paramb != null) {
        break label207;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(360157);
      throw paramString;
      localObject1 = l.k.mYO;
      i = l.k.bhH();
      localObject1 = "";
      break;
    }
    label207:
    paramString.a((com.tencent.mm.vending.e.b)paramb);
    label219:
    paramString.g(new f..ExternalSyntheticLambda2(parama, this));
    AppMethodBeat.o(360157);
  }
  
  public final void a(String paramString, boolean paramBoolean, kotlin.g.a.m<? super Boolean, ? super Boolean, ah> paramm)
  {
    AppMethodBeat.i(359986);
    if (paramString != null)
    {
      paramString = new com.tencent.mm.plugin.finder.live.cgi.g(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, paramString, paramBoolean, (com.tencent.mm.plugin.finder.live.cgi.g.a)new f.f(this, paramString, paramm)).bFJ();
      if ((getContext() != null) && ((getContext() instanceof MMActivity)))
      {
        paramm = getContext();
        if (paramm == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(359986);
          throw paramString;
        }
        paramString.a((com.tencent.mm.vending.e.b)paramm);
      }
    }
    AppMethodBeat.o(359986);
  }
  
  public final void a(List<String> arg1, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(360319);
    kotlin.g.b.s.u(???, "toUser");
    kotlin.g.b.s.u(paramFinderItem, "feedObject");
    Log.i(this.TAG, "[autoTransMmitLive] group size:" + ???.size() + ",mediaList:" + paramFinderItem.getLiveMediaList().size());
    if (!???.isEmpty())
    {
      localObject1 = (Collection)paramFinderItem.getLiveMediaList();
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label111;
      }
    }
    label111:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(360319);
      return;
    }
    Object localObject1 = new com.tencent.mm.message.k.b();
    Object localObject2 = new com.tencent.mm.plugin.findersdk.a.b();
    ((com.tencent.mm.plugin.findersdk.a.b)localObject2).b(paramFinderItem.getFinderLive());
    ((com.tencent.mm.message.k.b)localObject1).a((com.tencent.mm.message.f)localObject2);
    if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(paramFinderItem.getLiveInfo())) {}
    for (i = 88;; i = 63)
    {
      ((com.tencent.mm.message.k.b)localObject1).type = i;
      ((com.tencent.mm.message.k.b)localObject1).title = MMApplicationContext.getContext().getString(p.h.low_version_upgrade_tip);
      ((com.tencent.mm.message.k.b)localObject1).url = MMApplicationContext.getContext().getString(p.h.low_version_upgrade_url);
      synchronized ((Iterable)???)
      {
        paramFinderItem = ???.iterator();
        if (!paramFinderItem.hasNext()) {
          break;
        }
        localObject2 = (String)paramFinderItem.next();
        com.tencent.mm.message.w.a.bwq().a((com.tencent.mm.message.k.b)localObject1, "", "", (String)localObject2, "", null);
      }
    }
    paramFinderItem = ah.aiuX;
    AppMethodBeat.o(360319);
  }
  
  public final void a(final kotlin.g.a.u<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super Integer, ? super String, ? super awc, ah> paramu)
  {
    AppMethodBeat.i(359907);
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1;
    if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eis, 1))
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localLinkedList1.addAll((Collection)com.tencent.mm.plugin.finder.live.utils.a.gG(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eir));
    }
    LinkedList localLinkedList2 = new LinkedList();
    if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eis, 2)) {
      localLinkedList2.addAll((Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eit);
    }
    LinkedList localLinkedList3 = new LinkedList();
    if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eis, 4)) {
      localLinkedList3.addAll((Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eiu);
    }
    int i;
    label214:
    glm localglm;
    label293:
    String str;
    StringBuilder localStringBuilder;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeu;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcP) {
        break label568;
      }
      i = 5;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet) {
        break label585;
      }
      localglm = new glm();
      localglm.ZSe = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eev;
      localglm.acgY = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eew;
      localglm.report_info = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eex;
      str = this.TAG;
      localStringBuilder = new StringBuilder("doCreateLive: luckyMoneyChatRoom:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdQ.EbY).append(", visibilityMode:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eis).append(", visibilityList:").append(localLinkedList1).append(", visibilityRoomList:").append(localLinkedList2).append(", externalPost:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet).append(", appid:").append(localObject1).append(", gameVersionType:");
      if (localglm != null) {
        break label591;
      }
    }
    label568:
    label585:
    label591:
    for (Object localObject2 = null;; localObject2 = Integer.valueOf(localglm.ZSe))
    {
      Log.i(str, localObject2 + ", scene:" + i);
      new com.tencent.mm.plugin.finder.live.model.cgi.i(com.tencent.mm.model.z.bAW(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).EeY, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFe, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eis, localLinkedList1, localLinkedList2, localLinkedList3, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdQ.EbY, (String)localObject1, i, localglm, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).CJb, this.reportObj, (i.a)new e(this, paramu), (byte)0).bFJ();
      AppMethodBeat.o(359907);
      return;
      localObject1 = "";
      break;
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DXO;
      break label214;
      localglm = null;
      break label293;
    }
  }
  
  public final void a(boolean paramBoolean, final kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.plugin.finder.live.viewmodel.data.a, ah> params)
  {
    AppMethodBeat.i(359918);
    Log.i(this.TAG, kotlin.g.b.s.X("doFinishLive manualFinish:", Boolean.valueOf(paramBoolean)));
    Object localObject;
    if (!paramBoolean)
    {
      localObject = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
      kotlin.g.b.s.s(localObject, "plugin(IPluginFinderLive::class.java)");
      b.b.a((com.tencent.d.a.a.a.b)localObject, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, false, (b.d)new f.g(this, params), 6);
      AppMethodBeat.o(359918);
      return;
    }
    params = (kotlin.g.a.s)new f.h(params, this);
    Log.i(this.TAG, "doManualCloseLive liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + " objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN + " nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId);
    params = new com.tencent.mm.plugin.finder.live.model.cgi.ay(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId, (ay.a)new k(this, params)).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      localObject = getContext();
      if (localObject == null)
      {
        params = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(359918);
        throw params;
      }
      params.a((com.tencent.mm.vending.e.b)localObject);
    }
    new ia().publish();
    AppMethodBeat.o(359918);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, com.tencent.mm.plugin.finder.live.cgi.t.a parama)
  {
    AppMethodBeat.i(360210);
    kotlin.g.b.s.u(paramString1, "objectNonceId");
    kotlin.g.b.s.u(paramString2, "finderUserName");
    Log.i(this.TAG, "randomLinkMic: liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", objectNonceId:" + paramString1 + ", finderUserName:" + paramString2 + ", opCode:" + paramInt);
    paramArrayOfByte = new com.tencent.mm.plugin.finder.live.cgi.t(paramArrayOfByte, paramLong1, paramLong2, paramString1, paramString2, paramInt, parama).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      paramString1 = getContext();
      if (paramString1 == null)
      {
        paramArrayOfByte = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360210);
        throw paramArrayOfByte;
      }
      paramArrayOfByte.a((com.tencent.mm.vending.e.b)paramString1);
    }
    AppMethodBeat.o(360210);
  }
  
  public final void aA(Activity paramActivity)
  {
    AppMethodBeat.i(360276);
    kotlin.g.b.s.u(paramActivity, "context");
    Intent localIntent = new Intent();
    String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHQ();
    if (str == null)
    {
      str = "";
      if (!Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF())) {
        break label264;
      }
    }
    label264:
    for (int i = 1;; i = 2)
    {
      localIntent.putExtra("key_live_anchor_type", i);
      localIntent.putExtra("key_live_id", com.tencent.mm.ae.d.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
      localIntent.putExtra("key_live_attach", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdQ.EbZ);
      localIntent.putExtra("key_from", 3);
      localIntent.putExtra("key_session_id", str);
      com.tencent.mm.br.c.b((Context)paramActivity, "luckymoney", ".ui.LuckyMoneyPrepareUI", localIntent);
      Log.i(this.TAG, "goPrepareLuckyMoney liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ", clientBuff:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdQ.EbZ + ", sessionId:" + str);
      AppMethodBeat.o(360276);
      return;
      break;
    }
  }
  
  public final void ar(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(360346);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.utils.e.GfX;
    boolean bool = com.tencent.mm.plugin.finder.utils.e.D(paramContext, "com.tencent.qqmusic", "CBD27CD7C861227D013A25B2D10F0799");
    Log.i(this.TAG, "goQQMusic isInstalled:" + bool + " songId:" + paramInt + " songmid:0");
    if (bool)
    {
      com.tencent.mm.ui.base.k.b(paramContext, paramContext.getResources().getString(p.h.finder_secondcut_jump_tip, new Object[] { paramContext.getResources().getString(p.h.Cue) }), "", paramContext.getResources().getString(p.h.app_ok), paramContext.getResources().getString(p.h.app_cancel), new f..ExternalSyntheticLambda0(paramInt, 0, this, paramContext), new f..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(360346);
      return;
    }
    Log.i(this.TAG, "goQQMusic download");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", "https://y.qq.com/m/download.html");
    ((Intent)localObject).putExtra("showShare", false);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(360346);
  }
  
  public final void as(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(360436);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_media_type", 2);
    localIntent.putExtra("scene", 4);
    com.tencent.mm.br.c.d(paramContext, "com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI", localIntent, paramInt);
    AppMethodBeat.o(360436);
  }
  
  public final void at(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(360443);
    kotlin.g.b.s.u(paramContext, "context");
    if ((paramContext instanceof Activity)) {}
    for (paramContext = (Activity)paramContext;; paramContext = null)
    {
      com.tencent.mm.pluginsdk.ui.tools.t.a(paramContext, paramInt, 1, 30, 1, false, new Intent());
      AppMethodBeat.o(360443);
      return;
    }
  }
  
  public final void at(View paramView, int paramInt)
  {
    AppMethodBeat.i(360144);
    kotlin.g.b.s.u(paramView, "view");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f.b(this, paramView, paramInt));
    AppMethodBeat.o(360144);
  }
  
  public final void aws(String paramString)
  {
    AppMethodBeat.i(359966);
    Object localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    kotlin.g.b.s.s(localObject, "service(IFinderCommonService::class.java)");
    localObject = (com.tencent.mm.plugin.h)localObject;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      com.tencent.mm.plugin.h.a.a((com.tencent.mm.plugin.h)localObject, paramString, true, null, null, 872);
      AppMethodBeat.o(359966);
      return;
    }
  }
  
  public final void b(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg, com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(360120);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramg, "bundle");
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("open halfscreen miniPro appId:").append(paramg.appId).append(",patch:").append(paramg.qAF).append(",is test:");
    Object localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.live.utils.a.bUq()).append(",halfScreenConfig is null:");
    if (paramg.qAT == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i((String)localObject1, bool1);
      if ((!Util.isNullOrNil(paramg.appId)) && (!Util.isNullOrNil(paramg.qAF))) {
        break;
      }
      AppMethodBeat.o(360120);
      return;
    }
    localObject3 = new HalfScreenConfig.BackgroundShapeConfig(MMApplicationContext.getContext().getResources().getDimension(p.c.finder_live_shopping_panel_corner), true, true, 24);
    localObject1 = paramContext.getClass().getName();
    kotlin.g.b.s.s(localObject1, "context.javaClass.name");
    localObject2 = new HalfScreenConfig.CloseWhenClickEmptyAreaConfig((String)localObject1, HalfScreenConfig.a.rae);
    localObject1 = com.tencent.mm.plugin.finder.live.k.Bxu;
    int i = com.tencent.mm.plugin.finder.live.k.bUw();
    localObject1 = paramg.qAG;
    label238:
    boolean bool2;
    label259:
    label267:
    Object localObject4;
    if ((localObject1 instanceof ay))
    {
      localObject1 = (ay)localObject1;
      if (localObject1 != null) {
        break label325;
      }
      bool1 = true;
      localObject1 = paramg.qAG;
      if (!(localObject1 instanceof ay)) {
        break label335;
      }
      localObject1 = (ay)localObject1;
      if (localObject1 != null) {
        break label341;
      }
      bool2 = false;
      localObject1 = new MiniProgramHalfScreenStatusChangeListener(parama);
      if (paramg.qAT == null) {
        break label539;
      }
      localObject4 = paramg.qAT;
      if (localObject4 != null) {
        break label351;
      }
      localObject1 = null;
    }
    for (;;)
    {
      paramg.qAT = ((HalfScreenConfig)localObject1);
      a(paramContext, paramg, true, parama);
      AppMethodBeat.o(360120);
      return;
      localObject1 = null;
      break;
      label325:
      bool1 = ((ay)localObject1).CIK;
      break label238;
      label335:
      localObject1 = null;
      break label259;
      label341:
      bool2 = ((ay)localObject1).qZT;
      break label267;
      label351:
      localObject4 = ((HalfScreenConfig)localObject4).ckQ();
      if (localObject4 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject4 = ((HalfScreenConfig.b)localObject4).ix(true);
        if (localObject4 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject4 = ((HalfScreenConfig.b)localObject4).iy(true);
          if (localObject4 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject3 = ((HalfScreenConfig.b)localObject4).a((HalfScreenConfig.BackgroundShapeConfig)localObject3);
            if (localObject3 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject3 = ((HalfScreenConfig.b)localObject3).iz(true);
              if (localObject3 == null)
              {
                localObject1 = null;
              }
              else
              {
                localObject2 = ((HalfScreenConfig.b)localObject3).a((HalfScreenConfig.CloseWhenClickEmptyAreaConfig)localObject2);
                if (localObject2 == null)
                {
                  localObject1 = null;
                }
                else
                {
                  localObject2 = ((HalfScreenConfig.b)localObject2).iA(bool1);
                  if (localObject2 == null)
                  {
                    localObject1 = null;
                  }
                  else
                  {
                    localObject2 = ((HalfScreenConfig.b)localObject2).iB(bool2);
                    if (localObject2 == null)
                    {
                      localObject1 = null;
                    }
                    else
                    {
                      localObject1 = ((HalfScreenConfig.b)localObject2).a((WeAppHalfScreenStatusChangeListener)localObject1);
                      if (localObject1 == null)
                      {
                        localObject1 = null;
                      }
                      else
                      {
                        localObject1 = ((HalfScreenConfig.b)localObject1).ckR();
                        continue;
                        label539:
                        localObject1 = new HalfScreenConfig(true, i, HalfScreenConfig.a.rae, true, (HalfScreenConfig.BackgroundShapeConfig)localObject3, true, (HalfScreenConfig.CloseWhenClickEmptyAreaConfig)localObject2, HalfScreenConfig.c.rao, bool1, true, (WeAppHalfScreenStatusChangeListener)localObject1, null, false, false, null, false, null, 0, 0, 0, false, false, false, null, 16771072);
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
  
  public final <T extends androidx.lifecycle.af> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(359886);
    kotlin.g.b.s.u(paramClass, "bu");
    paramClass = this.buContext.business(paramClass);
    AppMethodBeat.o(359886);
    return paramClass;
  }
  
  public final void c(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(360297);
    kotlin.g.b.s.u(paramActivity, "activity");
    com.tencent.mm.plugin.f localf = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
    Intent localIntent = new Intent();
    Object localObject2 = (Iterable)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdK;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((bcz)((Iterator)localObject2).next()).toByteArray());
    }
    localIntent.putExtra("KEY_VISITOR_ROLE_LIST", (Serializable)localObject1);
    localIntent.putExtra("KEY_VISITOR_ROLE", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdJ);
    localIntent.putExtra("KEY_MODIFY_TIME", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdL);
    localIntent.putExtra("KEY_SOURCE", 1);
    localObject1 = ah.aiuX;
    localf.a(paramActivity, localIntent, 1009, paramBoolean);
    AppMethodBeat.o(360297);
  }
  
  public final void c(String paramString, kotlin.g.a.m<? super Boolean, ? super bgh, ah> paramm)
  {
    AppMethodBeat.i(359992);
    if (paramString != null)
    {
      com.tencent.mm.cp.f localf = new l(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, paramString).bFJ();
      if ((getContext() != null) && ((getContext() instanceof MMActivity)))
      {
        Context localContext = getContext();
        if (localContext == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(359992);
          throw paramString;
        }
        localf.a((com.tencent.mm.vending.e.b)localContext);
      }
      localf.g(new f..ExternalSyntheticLambda11(this, paramString, paramm));
    }
    AppMethodBeat.o(359992);
  }
  
  public final void c(kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super bsq, ah> paramr)
  {
    AppMethodBeat.i(359953);
    Object localObject1 = eki();
    Object localObject2 = com.tencent.mm.plugin.finder.live.cgi.x.CvN;
    localObject2 = new bdm();
    ((bdm)localObject2).msg_type = 20006;
    ((bdm)localObject2).Tro = kotlin.g.b.s.X(com.tencent.mm.model.z.bAM(), Long.valueOf(System.currentTimeMillis()));
    paramr = new com.tencent.mm.plugin.finder.live.cgi.x((bdm)localObject2, this.buContext, (bui)localObject1, (kotlin.g.a.r)new i(paramr)).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramr = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(359953);
        throw paramr;
      }
      paramr.a((com.tencent.mm.vending.e.b)localObject1);
    }
    AppMethodBeat.o(359953);
  }
  
  public final void d(String paramString, kotlin.g.a.m<? super bpp, ? super aux, ah> paramm)
  {
    AppMethodBeat.i(360002);
    Log.i(this.TAG, kotlin.g.b.s.X("putInBlackList username:", paramString));
    if (paramString != null)
    {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DUe)
      {
        ((com.tencent.mm.plugin.finder.service.p)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.p.class)).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, paramString, (ck)new v(paramm));
        AppMethodBeat.o(360002);
        return;
      }
      ((com.tencent.mm.plugin.finder.service.p)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.p.class)).b(paramString, (ck)new w(paramm));
    }
    AppMethodBeat.o(360002);
  }
  
  public final void d(kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super azv, ah> paramr)
  {
    AppMethodBeat.i(360080);
    Object localObject1 = bi.ABn;
    localObject1 = bi.dVu();
    long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    Object localObject2 = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(localObject2, "getMyFinderUsername()");
    localObject1 = new az((atz)localObject1, l, (String)localObject2, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN).bFJ();
    if ((getContext() != null) && ((getContext() instanceof MMActivity)))
    {
      localObject2 = getContext();
      if (localObject2 == null)
      {
        paramr = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360080);
        throw paramr;
      }
      ((com.tencent.mm.cp.f)localObject1).a((com.tencent.mm.vending.e.b)localObject2);
    }
    ((com.tencent.mm.cp.f)localObject1).g(new f..ExternalSyntheticLambda15(paramr, this));
    AppMethodBeat.o(360080);
  }
  
  public final void e(String paramString, kotlin.g.a.m<? super Boolean, ? super String, ah> paramm)
  {
    AppMethodBeat.i(360091);
    kotlin.g.b.s.u(paramString, "topic");
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    aj.a locala = com.tencent.mm.plugin.finder.live.model.cgi.aj.CKd;
    new com.tencent.mm.plugin.finder.live.model.cgi.aj(l1, l2, 1, aj.a.awF(paramString)).bFJ().g(new f..ExternalSyntheticLambda13(this, paramm));
    AppMethodBeat.o(360091);
  }
  
  public final bma ekj()
  {
    AppMethodBeat.i(359881);
    bma localbma = new bma();
    Context localContext = getContext();
    Object localObject1;
    Object localObject2;
    int i;
    if (localContext != null)
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localbma.ZUK = ((bn)com.tencent.mm.ui.component.k.nq(localContext).cq(bn.class)).foz();
      localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localbma.session_id = ((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localbma.ZUL = com.tencent.mm.plugin.finder.live.report.k.etq();
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.etu();
      if (localObject1 != null) {
        break label404;
      }
      localObject1 = "";
      localbma.ZUN = ((String)localObject1);
      localbma.ZUM = System.currentTimeMillis();
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((bn)com.tencent.mm.ui.component.k.nq(localContext).cq(bn.class)).foA();
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label435;
      }
      i = 1;
      label182:
      if (i == 0) {
        break label440;
      }
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localObject1 = hK(com.tencent.mm.plugin.finder.live.report.k.ets(), "exposeType");
      label203:
      localbma.ZUO = ((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (!kotlin.g.b.s.p(com.tencent.mm.plugin.finder.live.report.k.eto(), q.n.Dty.scene)) {
        break label454;
      }
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
      if (!kotlin.g.b.s.p(com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a.dLz(), "111")) {
        break label454;
      }
      localObject1 = q.n.Dtz.scene;
      label255:
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localbma.ZUR = com.tencent.mm.plugin.finder.live.report.q.aB((String)localObject1, com.tencent.mm.plugin.finder.live.report.j.Doc.Dqh.type);
      localObject2 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localbma.ZUQ = hK(com.tencent.mm.plugin.finder.live.report.k.ets(), "enter_immerse_type");
      localbma.ZUS = ((String)localObject1);
    }
    for (;;)
    {
      try
      {
        if (kotlin.n.n.a((CharSequence)localObject1, "temp_", 0, false, 6) != -1) {
          continue;
        }
        l = 0L;
        localbma.ZUP = l;
      }
      catch (Exception localException)
      {
        long l;
        label404:
        label435:
        label440:
        label454:
        Log.e(this.TAG, kotlin.g.b.s.X("genLiveReportObj err:", localException.getMessage()));
        continue;
      }
      Log.i(this.TAG, "enter_icon_type :" + localbma.ZUR + " chnl_enter_immerse_type: " + localbma.ZUQ + " chnl_expose_type: " + localbma.ZUO);
      AppMethodBeat.o(359881);
      return localbma;
      localObject2 = kotlin.n.n.m((String)localObject1, ",", ";", false);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      i = 0;
      break label182;
      localObject1 = hK((String)localObject1, "exposeType");
      break label203;
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.eto();
      break label255;
      l = Long.parseLong(kotlin.n.n.m((String)localObject1, "temp_", "", false));
    }
  }
  
  public final void ekk()
  {
    AppMethodBeat.i(359935);
    Log.i(this.TAG, "doCloseVisitorLive liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + " objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN + " nonceId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId);
    bui localbui = eki();
    Object localObject = com.tencent.mm.kernel.h.ax(com.tencent.d.a.a.a.c.a.class);
    kotlin.g.b.s.s(localObject, "service(ILiveCgiFactoryService::class.java)");
    com.tencent.d.a.a.a.c.a locala = (com.tencent.d.a.a.a.c.a)localObject;
    localObject = bi.ABn;
    atz localatz = bi.a(localbui);
    String str1 = com.tencent.mm.model.z.bAW();
    byte[] arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    String str2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.ZNI;
    String str3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hTs;
    a.b localb = (a.b)new d();
    if (aj.CGT == null) {
      localObject = null;
    }
    for (;;)
    {
      com.tencent.d.a.a.a.c.a.a.a(locala, localatz, str1, arrayOfByte, l1, l2, str2, 0, true, null, i, localbui, str3, localb, (String)localObject, (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgQ.getValue(), ekj(), 256).bFJ();
      AppMethodBeat.o(359935);
      return;
      localObject = aj.getLiveCore();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mSd;
      }
    }
  }
  
  public final void ekl()
  {
    AppMethodBeat.i(360149);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f.z(this));
    AppMethodBeat.o(360149);
  }
  
  public final long ekm()
  {
    AppMethodBeat.i(360261);
    Long localLong = ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).ihk();
    Log.i(this.TAG, kotlin.g.b.s.X("[WeCoin] getWeCoinBalanceFromCache, balance = ", localLong));
    kotlin.g.b.s.s(localLong, "balance");
    long l = localLong.longValue();
    AppMethodBeat.o(360261);
    return l;
  }
  
  public final boolean ekn()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(360307);
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.ZNI;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyI();
    int j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.ZNI;
    Log.i(this.TAG, "checkVisitorRoleType oriVisitorRoleType:" + i + ",newVisitorRoleType:" + j);
    cbv localcbv1;
    if ((i != j) && (j != 4))
    {
      j = 1;
      if (j != 0) {
        break label410;
      }
      localcbv1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyv();
      if (localcbv1 != null) {
        break label219;
      }
      i = 0;
      if (localObject1 == null) {
        Log.i(((f)this).TAG, "lastGameRankSwitchInfo null");
      }
    }
    for (;;)
    {
      if ((j != 0) || (i != 0))
      {
        localObject1 = new if();
        ((if)localObject1).hJB.id = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
        ((if)localObject1).hJB.type = 14;
        ((if)localObject1).publish();
        AppMethodBeat.o(360307);
        return true;
        j = 0;
        break;
        label219:
        cbv localcbv2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyw();
        label254:
        boolean bool;
        if ((localcbv2 != null) && (localcbv1.aalf != localcbv2.aalf))
        {
          i = 1;
          String str = this.TAG;
          localObject1 = new StringBuilder("check should update by gameRankSwitch, ");
          if (localcbv2 == null) {
            break label371;
          }
          bool = true;
          label279:
          StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(bool).append(", last:").append(localcbv1.aalf).append(", cur:");
          if (localcbv2 != null) {
            break label376;
          }
          localObject1 = null;
          label315:
          Log.i(str, localObject1);
          if (localcbv2 != null) {
            break label389;
          }
        }
        label389:
        for (localObject1 = localObject2;; localObject1 = Integer.valueOf(localcbv2.aalf))
        {
          if ((i != 0) && (localObject1 != null)) {
            localcbv1.aalf = ((Integer)localObject1).intValue();
          }
          localObject1 = ah.aiuX;
          break;
          i = 0;
          break label254;
          label371:
          bool = false;
          break label279;
          label376:
          localObject1 = Integer.valueOf(localcbv2.aalf);
          break label315;
        }
      }
      AppMethodBeat.o(360307);
      return false;
      label410:
      i = 0;
    }
  }
  
  public final void eko()
  {
    AppMethodBeat.i(360459);
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eie;
    if (localObject != null)
    {
      if (!(localObject instanceof com.tencent.mm.plugin.finder.live.view.convert.h)) {
        break label97;
      }
      if (localObject != null) {
        if (!(localObject instanceof com.tencent.mm.plugin.finder.live.view.convert.h)) {
          break label102;
        }
      }
    }
    label97:
    label102:
    for (localObject = (com.tencent.mm.plugin.finder.live.view.convert.h)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        bkz localbkz = ((com.tencent.mm.plugin.finder.live.view.convert.h)localObject).DUM;
        if (localbkz != null) {
          new com.tencent.mm.plugin.finder.live.model.cgi.bc(this.buContext, localbkz).bFJ().g(new f..ExternalSyntheticLambda14((com.tencent.mm.plugin.finder.live.view.convert.h)localObject));
        }
      }
      AppMethodBeat.o(360459);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void gt(Context paramContext)
  {
    AppMethodBeat.i(360124);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i(this.TAG, kotlin.g.b.s.X("close miniPro appId:", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eii));
    aj localaj = aj.CGT;
    aj.gw(paramContext);
    AppMethodBeat.o(360124);
  }
  
  public final void gu(Context paramContext)
  {
    AppMethodBeat.i(360248);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i(this.TAG, "[WeCoin] initEngine");
    ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).a(paramContext, (com.tencent.mm.plugin.wallet.wecoin.a.i)new f.r(this));
    AppMethodBeat.o(360248);
  }
  
  public final void m(Object paramObject, String paramString)
  {
    AppMethodBeat.i(360312);
    kotlin.g.b.s.u(paramString, "keyUsername");
    if ((paramObject instanceof Bundle))
    {
      paramObject = (Bundle)paramObject;
      if (paramObject == null) {
        break label111;
      }
      paramObject = paramObject.getString(paramString);
      paramString = (CharSequence)paramObject;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label92;
      }
    }
    label92:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label97;
      }
      paramString = g.CEN;
      g.a(getContext(), this.buContext, false, paramObject, this.reportObj);
      AppMethodBeat.o(360312);
      return;
      paramObject = null;
      break;
    }
    label97:
    Log.i(this.TAG, kotlin.g.b.s.X("onPostGoToVisitorProfileResult finderUsername:", paramObject));
    label111:
    AppMethodBeat.o(360312);
  }
  
  public final void m(kotlin.g.a.m<? super Boolean, ? super Integer, ah> paramm)
  {
    int k = 0;
    AppMethodBeat.i(360058);
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edv)
    {
      localObject1 = aw.Gjk;
      if (!aw.bgV()) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      int i;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
        if ((localObject1 == null) || (((bgw)localObject1).ZQq != true)) {
          break label241;
        }
        j = 1;
        i = k;
        if (j == 0) {
          break label125;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
        if ((localObject1 == null) || (((bgw)localObject1).ZQo != true)) {
          break label246;
        }
      }
      label241:
      label246:
      for (int j = 1;; j = 0)
      {
        i = k;
        if (j != 0) {
          i = 1;
        }
        label125:
        paramm = new com.tencent.mm.plugin.finder.live.model.cgi.k(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId, com.tencent.mm.model.z.bAW(), i).bFJ().g(new f..ExternalSyntheticLambda12(this, paramm));
        if ((getContext() == null) || (!(getContext() instanceof MMActivity))) {
          break label264;
        }
        localObject1 = getContext();
        if (localObject1 != null) {
          break label251;
        }
        paramm = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(360058);
        throw paramm;
        j = 0;
        break;
      }
      label251:
      paramm.a((com.tencent.mm.vending.e.b)localObject1);
    }
    label264:
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("doGetGiftList liveData.business(LiveCommonSlice::class.java).enableGiftSwitch:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edv).append(",haveFansClub:");
    paramm = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
    if (paramm == null) {}
    for (paramm = null;; paramm = Boolean.valueOf(paramm.ZQo))
    {
      paramm = ((StringBuilder)localObject2).append(paramm).append(",FinderUtil.isTest():");
      localObject2 = aw.Gjk;
      Log.i((String)localObject1, aw.bgV());
      AppMethodBeat.o(360058);
      return;
    }
  }
  
  public final void oa(long paramLong)
  {
    AppMethodBeat.i(360140);
    boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eig.contains(Long.valueOf(paramLong));
    Log.i(this.TAG, "announceGotoShopping productId:" + paramLong + ", haveBug:" + bool);
    if ((paramLong != 0L) && (!bool))
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eig.add(Long.valueOf(paramLong));
      a("", 10012, null);
    }
    AppMethodBeat.o(360140);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$setGameTeamMode$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class aa
    implements com.tencent.mm.plugin.finder.live.cgi.e.a
  {
    aa(com.tencent.mm.plugin.finder.live.cgi.e.a parama, Context paramContext) {}
    
    public final void a(bvg parambvg)
    {
      AppMethodBeat.i(359604);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(359604);
    }
    
    public final void am(int paramInt, long paramLong)
    {
      AppMethodBeat.i(359589);
      com.tencent.mm.plugin.finder.live.cgi.e.a locala = this.CEK;
      if (locala != null) {
        locala.am(paramInt, paramLong);
      }
      AppMethodBeat.o(359589);
    }
    
    public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(359598);
      if (paramInt2 == -200139) {
        com.tencent.mm.ui.base.k.a(paramContext, paramContext.getString(p.h.CgY), "", paramContext.getString(p.h.app_i_know), false, null);
      }
      for (;;)
      {
        com.tencent.mm.plugin.finder.live.cgi.e.a locala = this.CEK;
        if (locala != null) {
          locala.b(paramInt1, paramInt2, paramString, paramInt3);
        }
        AppMethodBeat.o(359598);
        return;
        com.tencent.mm.ui.base.aa.dc(paramContext, paramContext.getString(p.h.CkD));
      }
    }
    
    public final void eho()
    {
      AppMethodBeat.i(359610);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(359610);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ab
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ab(f paramf, String paramString, int paramInt)
    {
      super();
    }
    
    private static final void i(int paramInt, View paramView)
    {
      AppMethodBeat.i(359584);
      if (paramView != null)
      {
        TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
        if (localTextView != null) {
          localTextView.setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
        if (paramView != null) {
          paramView.setImageResource(paramInt);
        }
      }
      AppMethodBeat.o(359584);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$showRechargeFoodsDialog$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Ljava/lang/Void;", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ad
    implements com.tencent.mm.plugin.wallet.wecoin.a.i<Void>
  {
    ad(f paramf, FragmentActivity paramFragmentActivity, kotlin.g.a.a<ah> parama) {}
    
    private static final void a(kotlin.g.a.a parama, com.tencent.mm.plugin.wallet.wecoin.a.c paramc)
    {
      AppMethodBeat.i(359608);
      kotlin.g.b.s.u(parama, "$callback");
      parama.invoke();
      AppMethodBeat.o(359608);
    }
    
    public final void s(int paramInt1, int paramInt2, String paramString) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCloseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.finder.live.model.cgi.f.a
  {
    c(f paramf, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super auv, ah> params) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, auv paramauv)
    {
      AppMethodBeat.i(359605);
      kotlin.g.b.s.u(paramauv, "resp");
      Object localObject2;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i(this.CEm.TAG, "close live room failed");
        localObject2 = params;
        Boolean localBoolean;
        if (localObject2 != null)
        {
          localBoolean = Boolean.FALSE;
          if (paramString != null) {
            break label120;
          }
        }
        label120:
        for (localObject1 = "";; localObject1 = paramString)
        {
          ((kotlin.g.a.s)localObject2).a(localBoolean, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localObject1, paramauv);
          paramauv = com.tencent.mm.plugin.finder.utils.bc.GkH;
          localObject1 = com.tencent.mm.plugin.finder.utils.bc.fhM();
          paramauv = paramString;
          if (paramString == null) {
            paramauv = "";
          }
          f.a(this.CEm);
          com.tencent.mm.plugin.finder.utils.bc.it((String)localObject1, paramauv);
          AppMethodBeat.o(359605);
          return;
        }
      }
      Object localObject1 = params;
      if (localObject1 != null)
      {
        localObject2 = Boolean.TRUE;
        if (paramString != null) {
          break label176;
        }
        paramString = "";
      }
      label176:
      for (;;)
      {
        ((kotlin.g.a.s)localObject1).a(localObject2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, paramauv);
        AppMethodBeat.o(359605);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCloseVisitorLive$1", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "requestCode", "uniqueId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements a.b
  {
    public final void a(int paramInt1, int paramInt2, azp paramazp, int paramInt3, String paramString)
    {
      AppMethodBeat.i(359615);
      kotlin.g.b.s.u(paramazp, "resp");
      AppMethodBeat.o(359615);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCreateLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements i.a
  {
    e(f paramf, kotlin.g.a.u<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super Integer, ? super String, ? super awc, ah> paramu) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, awc paramawc)
    {
      AppMethodBeat.i(359600);
      kotlin.g.b.s.u(paramawc, "resp");
      Object localObject3;
      Object localObject2;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i(this.CEm.TAG, "launch live room failed");
        if (paramInt2 == -200008)
        {
          localObject3 = paramu;
          if (localObject3 != null)
          {
            Boolean localBoolean1 = Boolean.FALSE;
            Boolean localBoolean2 = Boolean.TRUE;
            localObject2 = paramawc.ZGV;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            if (paramString != null) {
              break label155;
            }
            localObject2 = "";
            ((kotlin.g.a.u)localObject3).invoke(localBoolean1, localBoolean2, localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject2, paramawc);
          }
        }
        label155:
        do
        {
          paramawc = com.tencent.mm.plugin.finder.utils.bc.GkH;
          localObject1 = com.tencent.mm.plugin.finder.utils.bc.fhH();
          paramawc = paramString;
          if (paramString == null) {
            paramawc = "";
          }
          f.a(this.CEm);
          com.tencent.mm.plugin.finder.utils.bc.it((String)localObject1, paramawc);
          AppMethodBeat.o(359600);
          return;
          localObject2 = paramString;
          break;
          localObject2 = paramu;
        } while (localObject2 == null);
        localObject3 = Boolean.FALSE;
        if (paramString == null) {}
        for (localObject1 = "";; localObject1 = paramString)
        {
          ((kotlin.g.a.u)localObject2).invoke(localObject3, localObject3, "", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject1, paramawc);
          break;
        }
      }
      f.a(this.CEm, paramawc);
      Object localObject1 = paramu;
      if (localObject1 != null)
      {
        localObject2 = Boolean.TRUE;
        localObject3 = Boolean.FALSE;
        if (paramString != null) {
          break label288;
        }
        paramString = "";
      }
      label288:
      for (;;)
      {
        ((kotlin.g.a.u)localObject1).invoke(localObject2, localObject3, "", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramawc);
        AppMethodBeat.o(359600);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.r<Integer, Integer, String, bsq, ah>
  {
    i(kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super bsq, ah> paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    j(f paramf, int paramInt, long paramLong, kotlin.g.a.u<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.live.core.core.model.g, ? super TRTCCloudDef.TRTCParams, ? super bca, ah> paramu)
    {
      super();
    }
    
    private static final ah a(long paramLong, f paramf, final kotlin.g.a.u paramu, final int paramInt, com.tencent.mm.am.b.a parama)
    {
      AppMethodBeat.i(359591);
      kotlin.g.b.s.u(paramf, "this$0");
      final int i = parama.errType;
      final int j = parama.errCode;
      final String str = parama.errMsg;
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramLong, paramf, (bca)parama.ott, paramu, j, i, str, paramInt));
      paramf = ah.aiuX;
      AppMethodBeat.o(359591);
      return paramf;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(long paramLong, f paramf, bca parambca, kotlin.g.a.u<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.live.core.core.model.g, ? super TRTCCloudDef.TRTCParams, ? super bca, ah> paramu, int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        super();
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends kotlin.g.b.u
        implements kotlin.g.a.a<ah>
      {
        a(f paramf)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doManualCloseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements ay.a
  {
    k(f paramf, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super bov, ah> params) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bov parambov)
    {
      AppMethodBeat.i(359634);
      kotlin.g.b.s.u(parambov, "resp");
      Object localObject2;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i(this.CEm.TAG, "manual close live room failed");
        localObject2 = params;
        Boolean localBoolean;
        if (localObject2 != null)
        {
          localBoolean = Boolean.FALSE;
          if (paramString != null) {
            break label120;
          }
        }
        label120:
        for (localObject1 = "";; localObject1 = paramString)
        {
          ((kotlin.g.a.s)localObject2).a(localBoolean, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localObject1, parambov);
          parambov = com.tencent.mm.plugin.finder.utils.bc.GkH;
          localObject1 = com.tencent.mm.plugin.finder.utils.bc.fhN();
          parambov = paramString;
          if (paramString == null) {
            parambov = "";
          }
          f.a(this.CEm);
          com.tencent.mm.plugin.finder.utils.bc.it((String)localObject1, parambov);
          AppMethodBeat.o(359634);
          return;
        }
      }
      Object localObject1 = params;
      if (localObject1 != null)
      {
        localObject2 = Boolean.TRUE;
        if (paramString != null) {
          break label176;
        }
        paramString = "";
      }
      label176:
      for (;;)
      {
        ((kotlin.g.a.s)localObject1).a(localObject2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, parambov);
        AppMethodBeat.o(359634);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostGift$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements ar.a
  {
    l(f paramf, int paramInt1, ax.a parama, String paramString1, WeakReference<Context> paramWeakReference, String paramString2, int paramInt2, String paramString3) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bmf parambmf)
    {
      AppMethodBeat.i(359636);
      kotlin.g.b.s.u(parambmf, "resp");
      Log.i(this.CEm.TAG, "doPostGift errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString + ", bill_no:" + parambmf.YzL);
      Object localObject = bd.Gli;
      bd.Ux(paramInt2);
      if ((paramInt2 != 0) && (paramInt2 != -200042))
      {
        parambmf = parama;
        if (parambmf != null) {
          ax.a.a.a(parambmf, false, paramInt2, ax.a.b.DcD, null, null, 0, null, paramString, 16);
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(22129, new Object[] { Integer.valueOf(1), this.CEv, "", Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(paramInt2), paramString });
        paramString = bd.Gli;
        bd.fic();
        AppMethodBeat.o(359636);
        return;
      }
      localObject = (Context)localWeakReference.get();
      if (localObject == null)
      {
        AppMethodBeat.o(359636);
        return;
      }
      f localf = this.CEm;
      String str = this.CEv;
      paramString = parambmf.ZUX;
      if (paramString == null) {}
      for (paramString = null;; paramString = paramString.toByteArray())
      {
        f.a(localf, (Context)localObject, str, paramString, (com.tencent.mm.plugin.wallet.wecoin.a.i)new a(this.CEm, parama, paramString1, paramInt1, paramString2));
        AppMethodBeat.o(359636);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostGift$1$onCgiBack$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "msg", "", "onSuccess", "data", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.wallet.wecoin.a.i<Long>
    {
      a(f paramf, ax.a parama, String paramString1, int paramInt, String paramString2) {}
      
      public final void s(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(359627);
        Log.i(this.CEm.TAG, "[WeCoin] consumeGift onFailed errorType:" + paramInt1 + ",errorCode:" + paramInt2 + ",msg:" + paramString);
        paramString = this.CEu;
        if (paramString != null) {
          ax.a.a.a(paramString, false, paramInt2, ax.a.b.DcE, this.CEx, null, this.CEy, this.Cwa, null, 144);
        }
        paramString = bd.Gli;
        bd.fid();
        AppMethodBeat.o(359627);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getShopShelf$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements af.a
  {
    p(f paramf, kotlin.g.a.b<? super Boolean, ah> paramb, int paramInt, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bih parambih)
    {
      String str = null;
      boolean bool = true;
      AppMethodBeat.i(359629);
      kotlin.g.b.s.u(parambih, "resp");
      long l = parambih.mMJ;
      Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CEm.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
      int i;
      if ((localObject != null) && (l == ((bip)localObject).liveId))
      {
        i = 1;
        if (i != 0) {
          break label177;
        }
        str = this.CEm.TAG;
        parambih = new StringBuilder("invalid live resp,liveId:").append(parambih.mMJ).append(",current liveId:");
        paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CEm.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
        if (paramString != null) {
          break label166;
        }
      }
      label166:
      for (paramString = null;; paramString = Long.valueOf(paramString.liveId))
      {
        Log.i(str, paramString);
        paramString = paramb;
        if (paramString != null) {
          paramString.invoke(Boolean.FALSE);
        }
        AppMethodBeat.o(359629);
        return;
        i = 0;
        break;
      }
      label177:
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = this.CEm.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
        paramString = paramString2;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).aNm();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).EhX = true;
        if (parambih.ZRy > 0)
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eik = bool;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eil = parambih.ZRx;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eid = parambih.ZRt;
          if (paramString != null) {
            break label401;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).c(parambih);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).a(parambih.ZRv);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eio = parambih.ZRw;
          localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CEm.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          paramString = parambih.YJa;
          if (paramString != null) {
            break label417;
          }
        }
        for (paramString = str;; paramString = paramString.Op)
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).mZp = paramString;
          Log.i(this.CEm.TAG, kotlin.g.b.s.X("mergeProducts, resp list size:", Integer.valueOf(parambih.ZgM.size())));
          paramString = parambih.ZRn;
          if (paramString != null) {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CEm.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).ayl(paramString);
          }
          paramString = paramb;
          if (paramString == null) {
            break label490;
          }
          paramString.invoke(Boolean.TRUE);
          AppMethodBeat.o(359629);
          return;
          bool = false;
          break;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).d(parambih);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eim = paramString;
          break label265;
        }
      }
      label265:
      label401:
      label417:
      parambih = paramb;
      if (parambih != null) {
        parambih.invoke(Boolean.FALSE);
      }
      if (i != 0)
      {
        parambih = com.tencent.mm.plugin.finder.utils.bc.GkH;
        str = com.tencent.mm.plugin.finder.utils.bc.fhP();
        parambih = paramString;
        if (paramString == null) {
          parambih = "";
        }
        f.a(this.CEm);
        com.tencent.mm.plugin.finder.utils.bc.it(str, parambih);
      }
      label490:
      AppMethodBeat.o(359629);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$putInBlackList$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class v
    implements ck<bpp>
  {
    v(kotlin.g.a.m<? super bpp, ? super aux, ah> paramm) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$putInBlackList$1$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class w
    implements ck<bpp>
  {
    w(kotlin.g.a.m<? super bpp, ? super aux, ah> paramm) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.f
 * JD-Core Version:    0.7.0.1
 */