package com.tencent.mm.plugin.finder.live.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.model.cgi.a.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ag.a;
import com.tencent.mm.plugin.finder.live.model.cgi.b.a;
import com.tencent.mm.plugin.finder.live.model.cgi.c.a;
import com.tencent.mm.plugin.finder.live.model.cgi.e.a;
import com.tencent.mm.plugin.finder.live.model.cgi.g.a;
import com.tencent.mm.plugin.finder.live.model.cgi.h.a;
import com.tencent.mm.plugin.finder.live.model.cgi.o.a;
import com.tencent.mm.plugin.finder.live.model.cgi.p.a;
import com.tencent.mm.plugin.finder.live.model.cgi.q.a;
import com.tencent.mm.plugin.finder.live.model.cgi.r.a;
import com.tencent.mm.plugin.finder.live.model.cgi.s.a;
import com.tencent.mm.plugin.finder.live.model.cgi.t.a;
import com.tencent.mm.plugin.finder.live.model.cgi.u.a;
import com.tencent.mm.plugin.finder.live.model.cgi.x.a;
import com.tencent.mm.plugin.finder.live.model.cgi.y.a;
import com.tencent.mm.plugin.finder.live.plugin.be.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.wallet.wecoin.a.d;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.a.s;
import kotlin.g.a.u;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "", "acceptBattle", "", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "toContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "battleId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAcceptBattle$CallBack;", "acceptLinkMic", "micType", "userId", "sessionId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "acceptLinkMicPk", "sdkLiveId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "activateLiveMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "announceGotoShopping", "productId", "applyBattle", "micId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveApplyBattle$CallBack;", "applyLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "applyLinkMicPk", "sdkUserId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "autoTransMmitLive", "toUser", "", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "batchGetMicContact", "usernameList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "cacheViewVisibility", "view", "Landroid/view/View;", "visibility", "checkVisitorRoleType", "", "data", "Landroid/content/Intent;", "chooseVisitorRoleImpl", "activity", "Landroid/app/Activity;", "fromSetting", "closeBattle", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCloseBattle$CallBack;", "closeLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "closeLinkMicPk", "closeScene", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "closeMiniProgram", "doCloseLive", "cene", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "success", "errCode", "errType", "errMsg", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "resp", "doCloseVisitorLive", "doCreateLive", "Lkotlin/Function7;", "needFaceVerify", "verifyUrl", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "doDisableComment", "username", "enable", "Lkotlin/Function2;", "doFetchFinderContact", "finderUsername", "doFinishLive", "manualFinish", "isSecondDaryDevice", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;", "info", "doGetFinderLiveContact", "contact", "doGetGiftList", "doGetMemberList", "Lkotlin/Function4;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "doGetMicCandidateList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "doHighLightLikeLive", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "doJoinLive", "role", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "doLikeLive", "count", "doManualCloseLive", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "doPostAppMsg", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "doPostComment", "commentContent", "liveMsgType", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "doPostGift", "context", "Landroid/content/Context;", "rewardGiftId", "rewardGiftCnt", "wecoin", "comboId", "sendGiftTargetUserName", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "expose", "commentSeq", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "getLotteryRecord", "lotteryId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "getLuckyMoneyInfo", "nonceId", "liveCookies", "sendIdList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "getMusicInfo", "songIdList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "getProductDetail", "product", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "getShopShelf", "Lcom/tencent/mm/ui/MMActivity;", "anchorUsername", "Lkotlin/Function1;", "getWeCoinBalance", "getWeCoinBalanceFromCache", "goPrepareLuckyMoney", "goQQMusic", "songId", "songmId", "goReceiveLuckyMoney", "luckyMoneySendInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "resultReceiver", "Landroid/os/ResultReceiver;", "actionCallback", "goToFinderProfileImpl", "isAnchor", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "goToGallery", "requestCode", "goToHistoryFile", "gotoWebViewWithoutMiniWindow", "contenxt", "intent", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "initEngine", "sucCallback", "failCallback", "isWeCoinEntranceAvailable", "luckyMoneyRewardNotify", "sendId", "modeShopShelf", "audienceUsername", "finderCmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "modifyMusicList", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;", "onPostGoToFinderProfileResult", "extraMsg", "Landroid/os/Bundle;", "extraData", "keyUsername", "openFullScreenMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "openHalfScreenMiniProgram", "pauseLive", "pauseMode", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "putInBlackList", "usernmae", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "refreshLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "resumeViewVisibility", "searchMusic", "query", "lastBuffer", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "setAnchorStatus", "flag", "liveStatus", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "setGameTeamMode", "gameTeamMode", "setMicSetting", "micSettingFlag", "showRechargeFoodsDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "Landroidx/fragment/app/FragmentActivity;", "Lkotlin/Function0;", "showWeCoinEntranceTutorialDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "plugin-finder_release"})
public abstract interface an
{
  public abstract void K(kotlin.g.a.b<? super Long, x> paramb);
  
  public abstract void Li(long paramLong);
  
  public abstract void Nn(int paramInt);
  
  public abstract d a(FragmentActivity paramFragmentActivity, int paramInt, kotlin.g.a.a<x> parama);
  
  public abstract void a(int paramInt1, int paramInt2, ad.a parama);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, g.a parama);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, aza paramaza, h.a parama);
  
  public abstract void a(int paramInt, s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super aqs, x> params);
  
  public abstract void a(long paramLong, int paramInt, u<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super f, ? super TRTCCloudDef.TRTCParams, ? super awj, x> paramu);
  
  public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.live.cgi.d.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, long paramLong3, com.tencent.mm.plugin.finder.live.cgi.d.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt1, aza paramaza, int paramInt2, com.tencent.mm.plugin.finder.live.model.cgi.d.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, aza paramaza, int paramInt2, String paramString2, String paramString3, a.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, aza paramaza, String paramString2, int paramInt2, e.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, aza paramaza, String paramString2, int paramInt2, String paramString3, b.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, aza paramaza, String paramString2, o.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, aza paramaza, String paramString2, p.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, aza paramaza, String paramString2, t.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, ag.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, List<String> paramList, y.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2, c.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, LinkedList<String> paramLinkedList, q.a parama);
  
  public abstract void a(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, int paramInt, LinkedList<Integer> paramLinkedList, r.a parama);
  
  public abstract void a(Activity paramActivity, bbx parambbx, ResultReceiver paramResultReceiver, kotlin.g.a.b<? super Integer, x> paramb);
  
  public abstract void a(Context paramContext, long paramLong1, long paramLong2, int paramInt, com.tencent.mm.plugin.finder.live.cgi.d.a parama);
  
  public abstract void a(Context paramContext, long paramLong, String paramString, Long paramLong1);
  
  public abstract void a(Context paramContext, Intent paramIntent, Integer paramInteger);
  
  public abstract void a(Context paramContext, g paramg, com.tencent.mm.plugin.finder.live.view.a parama);
  
  public abstract void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, be.a parama);
  
  public abstract void a(s.a parama);
  
  public abstract void a(blm paramblm);
  
  public abstract void a(MMActivity paramMMActivity, long paramLong1, long paramLong2, String paramString, aqt paramaqt, m<? super Boolean, ? super bbc, x> paramm);
  
  public abstract void a(MMActivity paramMMActivity, long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, kotlin.g.a.b<? super Boolean, x> paramb);
  
  public abstract void a(String paramString, int paramInt, u.a parama);
  
  public abstract void a(String paramString, com.tencent.mm.cd.b paramb, x.a parama);
  
  public abstract void a(String paramString, boolean paramBoolean, m<? super Boolean, ? super Boolean, x> paramm);
  
  public abstract void a(List<String> paramList, FinderItem paramFinderItem);
  
  public abstract void a(u<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super Integer, ? super String, ? super art, x> paramu);
  
  public abstract void a(boolean paramBoolean, String paramString, bid parambid);
  
  public abstract void a(boolean paramBoolean, s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.plugin.finder.live.viewmodel.data.a, x> params);
  
  public abstract void aBW(String paramString);
  
  public abstract void aBX(String paramString);
  
  public abstract void ah(Context paramContext, int paramInt);
  
  public abstract void ai(Context paramContext, int paramInt);
  
  public abstract void aj(Context paramContext, int paramInt);
  
  public abstract void aj(View paramView, int paramInt);
  
  public abstract void ap(Activity paramActivity);
  
  public abstract void b(Context paramContext, g paramg, com.tencent.mm.plugin.finder.live.view.a parama);
  
  public abstract void b(String paramString, m<? super beo, ? super aqu, x> paramm);
  
  public abstract void c(Activity paramActivity, boolean paramBoolean);
  
  public abstract void c(r<? super Integer, ? super Integer, ? super String, ? super bgy, x> paramr);
  
  public abstract void d(r<? super Integer, ? super Integer, ? super String, ? super aux, x> paramr);
  
  public abstract void dxU();
  
  public abstract void dxV();
  
  public abstract void dxW();
  
  public abstract boolean dxX();
  
  public abstract boolean dxY();
  
  public abstract void e(m<? super Boolean, ? super Integer, x> paramm);
  
  public abstract void f(Object paramObject, String paramString);
  
  public abstract void fw(Context paramContext);
  
  @l(iBK={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.an
 * JD-Core Version:    0.7.0.1
 */