package com.tencent.mm.plugin.finder.live.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mm.plugin.finder.live.model.cgi.a.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ae.a;
import com.tencent.mm.plugin.finder.live.model.cgi.al.a;
import com.tencent.mm.plugin.finder.live.model.cgi.b.a;
import com.tencent.mm.plugin.finder.live.model.cgi.d.a;
import com.tencent.mm.plugin.finder.live.model.cgi.g.a;
import com.tencent.mm.plugin.finder.live.model.cgi.h.a;
import com.tencent.mm.plugin.finder.live.model.cgi.p.a;
import com.tencent.mm.plugin.finder.live.model.cgi.q.a;
import com.tencent.mm.plugin.finder.live.model.cgi.s.a;
import com.tencent.mm.plugin.finder.live.model.cgi.u.a;
import com.tencent.mm.plugin.finder.live.model.cgi.v.a;
import com.tencent.mm.plugin.finder.live.model.cgi.w.a;
import com.tencent.mm.plugin.finder.live.plugin.ax.a;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.wallet.wecoin.a.e;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.a.s;
import kotlin.g.a.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "", "acceptBattle", "", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "toContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "battleId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAcceptBattle$CallBack;", "acceptLinkMic", "micType", "userId", "sessionId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "acceptLinkMicPk", "sdkLiveId", "randomMicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "announceGotoShopping", "productId", "applyBattle", "micId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveApplyBattle$CallBack;", "applyLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "applyLinkMicPk", "sdkUserId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "autoTransMmitLive", "toUser", "", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "batchGetMicContact", "usernameList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "cacheViewVisibility", "view", "Landroid/view/View;", "visibility", "checkVisitorRoleTypeAndGameRankSwitch", "", "data", "Landroid/content/Intent;", "chooseVisitorRoleImpl", "activity", "Landroid/app/Activity;", "fromSetting", "closeBattle", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCloseBattle$CallBack;", "closeLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "closeLinkMicPk", "closeScene", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "closeMiniProgram", "context", "Landroid/content/Context;", "doCloseLive", "cene", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "success", "errCode", "errType", "errMsg", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "resp", "doCloseVisitorLive", "doCreateLive", "Lkotlin/Function7;", "needFaceVerify", "verifyUrl", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "doDisableComment", "username", "enable", "Lkotlin/Function2;", "doFetchFinderContact", "finderUsername", "doFinishLive", "manualFinish", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;", "info", "doGetFinderLiveContact", "contact", "doGetGiftList", "doGetMemberList", "Lkotlin/Function4;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "doGetMicCandidateList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "doHighLightLikeLive", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "doJoinLive", "role", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "doLikeLive", "count", "doManualCloseLive", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "doPostAppMsg", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "doPostComment", "commentContent", "liveMsgType", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "doPostGift", "rewardGiftId", "rewardGiftCnt", "wecoin", "comboId", "sendGiftTargetUserName", "rewardType", "rewardExtInfo", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "expose", "commentSeq", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "genLiveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "getCouponList", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetCouponListResponse;", "getLotteryRecord", "lotteryId", "lastBuff", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "getLuckyMoneyInfo", "nonceId", "liveCookies", "sendIdList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "getMusicInfo", "songIdList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "getProductReplayUrl", "replayId", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetReplayUrlResponse;", "getShopShelf", "anchorUsername", "stockId", "pullScene", "uxInfo", "Lkotlin/Function1;", "getWeCoinBalance", "requestId", "balance", "getWeCoinBalanceFromCache", "goPrepareLuckyMoney", "goQQMusic", "songId", "songmId", "goReceiveLuckyMoney", "luckyMoneySendInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "resultReceiver", "Landroid/os/ResultReceiver;", "actionCallback", "goToGallery", "requestCode", "goToHistoryFile", "gotoWebViewWithoutMiniWindow", "contenxt", "intent", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "initEngine", "sucCallback", "failCallback", "isWeCoinEntranceAvailable", "issueCoupon", "Lcom/tencent/mm/protocal/protobuf/FinderLiveIssueCouponResponse;", "luckyMoneyRewardNotify", "sendId", "modeShopShelf", "audienceUsername", "finderCmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "Lkotlin/Function3;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "modifyMusicList", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;", "onPostGoToVisitorProfileResult", "extraMsg", "Landroid/os/Bundle;", "extraData", "keyUsername", "openFullScreenMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "openHalfScreenMiniProgram", "pauseLive", "pauseMode", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "putInBlackList", "usernmae", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "randomLinkMic", "finderUserName", "opCode", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveRandomMic$CallBack;", "receiveAllCouponBindToProduct", "product", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReceiveCouponResponse;", "receiveCoupon", "stockIds", "showErrorToast", "resumeViewVisibility", "searchMusic", "query", "lastBuffer", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "setAnchorStatus", "flag", "liveStatus", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "setAnchorStatusWithOpFlag", "opFlag", "setGameTeamMode", "gameTeamSetting", "Lcom/tencent/mm/protocal/protobuf/GameJoinTeamSetting;", "setLotterySetting", "lotterySetting", "Lcom/tencent/mm/protocal/protobuf/LiveLotterySetting;", "setMicSetting", "micSettingFlag", "setTopic", "topic", "showRechargeFoodsDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "Landroidx/fragment/app/FragmentActivity;", "Lkotlin/Function0;", "showWeCoinEntranceTutorialDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "updateRedPacketCoverInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ap
{
  public abstract void OM(int paramInt);
  
  public abstract e a(FragmentActivity paramFragmentActivity, int paramInt, kotlin.g.a.a<ah> parama);
  
  public abstract String a(String paramString, int paramInt, w.a parama);
  
  public abstract void a(int paramInt1, int paramInt2, al.a parama);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, g.a parama);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, bgh parambgh, h.a parama);
  
  public abstract void a(int paramInt, s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super auv, ah> params);
  
  public abstract void a(long paramLong, int paramInt, u<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.live.core.core.model.g, ? super TRTCCloudDef.TRTCParams, ? super bca, ah> paramu);
  
  public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.live.cgi.e.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, com.tencent.mm.plugin.finder.live.cgi.e.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, long paramLong3, com.tencent.mm.plugin.finder.live.cgi.e.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, diq paramdiq, com.tencent.mm.plugin.finder.live.cgi.e.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt1, bgh parambgh, int paramInt2, d.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, bgh parambgh, int paramInt2, String paramString2, String paramString3, a.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, bgh parambgh, String paramString2, int paramInt2, com.tencent.mm.bx.b paramb, com.tencent.mm.plugin.finder.live.model.cgi.e.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, bgh parambgh, String paramString2, int paramInt2, String paramString3, com.tencent.mm.bx.b paramb, b.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, bgh parambgh, String paramString2, p.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, bgh parambgh, String paramString2, q.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, bgh parambgh, String paramString2, v.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, List<String> paramList, ae.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, LinkedList<String> paramLinkedList, s.a parama);
  
  public abstract void a(long paramLong, m<? super Long, ? super Long, ah> paramm);
  
  public abstract void a(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, int paramInt, LinkedList<Integer> paramLinkedList, com.tencent.mm.plugin.finder.live.model.cgi.t.a parama);
  
  public abstract void a(Activity paramActivity, bls parambls, ResultReceiver paramResultReceiver, kotlin.g.a.b<? super Integer, ah> paramb);
  
  public abstract void a(Context paramContext, long paramLong1, long paramLong2, cbm paramcbm, com.tencent.mm.plugin.finder.live.cgi.e.a parama);
  
  public abstract void a(Context paramContext, long paramLong, String paramString, Long paramLong1);
  
  public abstract void a(Context paramContext, Intent paramIntent, Integer paramInteger);
  
  public abstract void a(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg, com.tencent.mm.plugin.finder.live.view.a parama);
  
  public abstract void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, com.tencent.mm.bx.b paramb, ax.a parama);
  
  public abstract void a(u.a parama);
  
  public abstract void a(MMActivity paramMMActivity, long paramLong1, long paramLong2, String paramString, auw paramauw, q<? super Boolean, ? super String, ? super bkd, ah> paramq);
  
  public abstract void a(MMActivity paramMMActivity, long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt, String paramString3, kotlin.g.a.b<? super Boolean, ah> paramb);
  
  public abstract void a(MMActivity paramMMActivity, long paramLong, m<? super Boolean, ? super bif, ah> paramm);
  
  public abstract void a(MMActivity paramMMActivity, k paramk, m<? super Boolean, ? super blp, ah> paramm);
  
  public abstract void a(MMActivity paramMMActivity, String paramString, int paramInt, m<? super Boolean, ? super bir, ah> paramm);
  
  public abstract void a(MMActivity paramMMActivity, LinkedList<String> paramLinkedList, boolean paramBoolean, m<? super Boolean, ? super blp, ah> paramm);
  
  public abstract void a(MMActivity paramMMActivity, m<? super Boolean, ? super bhl, ah> paramm);
  
  public abstract void a(String paramString, com.tencent.mm.bx.b paramb, ad.a parama);
  
  public abstract void a(String paramString, boolean paramBoolean, m<? super Boolean, ? super Boolean, ah> paramm);
  
  public abstract void a(List<String> paramList, FinderItem paramFinderItem);
  
  public abstract void a(u<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super Integer, ? super String, ? super awc, ah> paramu);
  
  public abstract void a(boolean paramBoolean, s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.plugin.finder.live.viewmodel.data.a, ah> params);
  
  public abstract void a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, com.tencent.mm.plugin.finder.live.cgi.t.a parama);
  
  public abstract void aA(Activity paramActivity);
  
  public abstract void ar(Context paramContext, int paramInt);
  
  public abstract void as(Context paramContext, int paramInt);
  
  public abstract void at(Context paramContext, int paramInt);
  
  public abstract void at(View paramView, int paramInt);
  
  public abstract void aws(String paramString);
  
  public abstract void b(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg, com.tencent.mm.plugin.finder.live.view.a parama);
  
  public abstract void c(Activity paramActivity, boolean paramBoolean);
  
  public abstract void c(String paramString, m<? super Boolean, ? super bgh, ah> paramm);
  
  public abstract void c(r<? super Integer, ? super Integer, ? super String, ? super bsq, ah> paramr);
  
  public abstract void d(String paramString, m<? super bpp, ? super aux, ah> paramm);
  
  public abstract void d(r<? super Integer, ? super Integer, ? super String, ? super azv, ah> paramr);
  
  public abstract void e(String paramString, m<? super Boolean, ? super String, ah> paramm);
  
  public abstract bma ekj();
  
  public abstract void ekk();
  
  public abstract void ekl();
  
  public abstract long ekm();
  
  public abstract boolean ekn();
  
  public abstract void eko();
  
  public abstract void gt(Context paramContext);
  
  public abstract void gu(Context paramContext);
  
  public abstract void m(Object paramObject, String paramString);
  
  public abstract void m(m<? super Boolean, ? super Integer, ah> paramm);
  
  public abstract void oa(long paramLong);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ap
 * JD-Core Version:    0.7.0.1
 */