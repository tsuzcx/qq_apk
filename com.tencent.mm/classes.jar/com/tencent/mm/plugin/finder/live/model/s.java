package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.model.cgi.a.a;
import com.tencent.mm.plugin.finder.live.model.cgi.b.a;
import com.tencent.mm.plugin.finder.live.model.cgi.d.a;
import com.tencent.mm.plugin.finder.live.model.cgi.l.a;
import com.tencent.mm.plugin.finder.live.model.cgi.o.a;
import com.tencent.mm.plugin.finder.live.model.cgi.u.a;
import com.tencent.mm.plugin.finder.live.plugin.af.a;
import com.tencent.mm.plugin.wallet.wecoin.a.d;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.a.u;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "", "acceptLinkMic", "", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "toContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "micType", "userId", "sessionId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "announceGotoShopping", "productId", "applyLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "cacheViewVisibility", "view", "Landroid/view/View;", "visibility", "changeScreenOrientation", "", "changeScreenToLandscape", "changeScreenToPortrait", "closeLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "closeMiniProgram", "doAcceptLiveMic", "finderLinkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLinkMicUser;", "doApplyLiveMic", "invitedUsername", "doCloseLive", "cene", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "success", "errCode", "errType", "errMsg", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "resp", "doCloseLiveMic", "doCloseVisitorLive", "doCreateLive", "Lkotlin/Function7;", "needFaceVerify", "verifyUrl", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "doDisableComment", "username", "enable", "Lkotlin/Function2;", "doFetchFinderContact", "finderUsername", "doFinishLive", "manualFinish", "isSecondDaryDevice", "Lcom/tencent/mm/plugin/finder/live/viewmodel/AnchorFinishInfo;", "info", "doGetFinderLiveContact", "contact", "doGetGiftList", "doGetMemberList", "Lkotlin/Function4;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "doGetMicCandidateList", "doGetProductList", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "Lkotlin/Function1;", "doHighLightLikeLive", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "doJoinLive", "role", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "doLikeLive", "count", "doManualCloseLive", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "doPostAppMsg", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "doPostComment", "commentContent", "liveMsgType", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "doPostGift", "context", "Landroid/content/Context;", "rewardGiftId", "rewardGiftCnt", "wecoin", "comboId", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "doPrepareLive", "micFinderUsername", "micFinderObjectId", "micLiveId", "enableAutoRotation", "expose", "commentSeq", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "getLotteryRecord", "lotteryId", "lastBuff", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "getProductDetail", "product", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "getWeCoinBalance", "getWeCoinBalanceFromCache", "gotoWebViewWithoutMiniWindow", "contenxt", "intent", "Landroid/content/Intent;", "requestCode", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "initEngine", "sucCallback", "failCallback", "isWeCoinEntranceAvailable", "lockScreenRotation", "openFullScreenMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "openHalfScreenMiniProgram", "putInBlackList", "usernmae", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "refreshLinkMic", "sdkUserId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "resumeViewVisibility", "setAnchorStatus", "flag", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "showRechargeFoodsDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "Landroid/support/v4/app/FragmentActivity;", "Lkotlin/Function0;", "showWeCoinEntranceTutorialDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "Landroid/app/Activity;", "plugin-finder_release"})
public abstract interface s
{
  public abstract void E(kotlin.g.a.b<? super Long, x> paramb);
  
  public abstract void EH(long paramLong);
  
  public abstract void Jf(int paramInt);
  
  public abstract d a(FragmentActivity paramFragmentActivity, int paramInt, kotlin.g.a.a<x> parama);
  
  public abstract void a(int paramInt, d.a parama);
  
  public abstract void a(int paramInt, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super ape, x> params);
  
  public abstract void a(int paramInt, u<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super e, ? super TRTCCloudDef.TRTCParams, ? super auf, x> paramu);
  
  public abstract void a(long paramLong1, long paramLong2, com.tencent.mm.bw.b paramb, kotlin.g.a.b<? super Boolean, x> paramb1);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt1, avn paramavn, int paramInt2, b.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, avn paramavn, int paramInt2, String paramString2, String paramString3, a.a parama);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, u.a parama);
  
  public abstract void a(Context paramContext, Intent paramIntent, Integer paramInteger);
  
  public abstract void a(Context paramContext, g paramg, boolean paramBoolean);
  
  public abstract void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, af.a parama);
  
  public abstract void a(com.tencent.mm.plugin.finder.live.viewmodel.b paramb);
  
  public abstract void a(axg paramaxg);
  
  public abstract void a(String paramString, int paramInt, l.a parama);
  
  public abstract void a(String paramString, com.tencent.mm.bw.b paramb, o.a parama);
  
  public abstract void a(String paramString, boolean paramBoolean, m<? super Boolean, ? super Boolean, x> paramm);
  
  public abstract void a(u<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super Integer, ? super String, ? super aqd, x> paramu);
  
  public abstract void a(boolean paramBoolean, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.plugin.finder.live.viewmodel.a, x> params);
  
  public abstract void ag(View paramView, int paramInt);
  
  public abstract void atx(String paramString);
  
  public abstract void aty(String paramString);
  
  public abstract void b(Context paramContext, long paramLong, String paramString, Long paramLong1, int paramInt);
  
  public abstract void b(String paramString, m<? super Boolean, ? super avn, x> paramm);
  
  public abstract void c(Context paramContext, g paramg);
  
  public abstract void c(String paramString, m<? super ayt, ? super apg, x> paramm);
  
  public abstract void c(r<? super Integer, ? super Integer, ? super String, ? super ban, x> paramr);
  
  public abstract void d(r<? super Integer, ? super Integer, ? super String, ? super asu, x> paramr);
  
  public abstract void dfj();
  
  public abstract void dfk();
  
  public abstract void dfl();
  
  public abstract void dfm();
  
  public abstract void dfn();
  
  public abstract boolean dfo();
  
  public abstract boolean dfp();
  
  public abstract boolean dfq();
  
  public abstract void f(m<? super Boolean, ? super Integer, x> paramm);
  
  public abstract void fn(Context paramContext);
  
  public abstract void h(long paramLong1, long paramLong2, int paramInt);
  
  @l(hxD={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.s
 * JD-Core Version:    0.7.0.1
 */