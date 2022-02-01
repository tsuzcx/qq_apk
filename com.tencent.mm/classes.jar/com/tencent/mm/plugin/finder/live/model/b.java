package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.provider.Settings.System;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.live.b.o.c;
import com.tencent.mm.live.b.o.l;
import com.tencent.mm.live.b.o.m;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.b;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.cgi.t.a;
import com.tencent.mm.plugin.finder.live.model.cgi.a.a;
import com.tencent.mm.plugin.finder.live.model.cgi.c.a;
import com.tencent.mm.plugin.finder.live.model.cgi.d.a;
import com.tencent.mm.plugin.finder.live.model.cgi.e.a;
import com.tencent.mm.plugin.finder.live.model.cgi.f.a;
import com.tencent.mm.plugin.finder.live.model.cgi.h.a;
import com.tencent.mm.plugin.finder.live.model.cgi.i.a;
import com.tencent.mm.plugin.finder.live.model.cgi.j.a;
import com.tencent.mm.plugin.finder.live.model.cgi.l.a;
import com.tencent.mm.plugin.finder.live.model.cgi.o.a;
import com.tencent.mm.plugin.finder.live.model.cgi.p.a;
import com.tencent.mm.plugin.finder.live.model.cgi.q.a;
import com.tencent.mm.plugin.finder.live.model.cgi.v;
import com.tencent.mm.plugin.finder.live.model.cgi.v.a;
import com.tencent.mm.plugin.finder.live.model.cgi.x.a;
import com.tencent.mm.plugin.finder.live.model.cgi.y.a;
import com.tencent.mm.plugin.finder.live.plugin.af.a;
import com.tencent.mm.plugin.finder.live.plugin.af.a.a;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.report.live.s.ay;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.aj.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.a.r;
import org.xwalk.core.XWalkEnvironment;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAssistant;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheViewVisibilityList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/view/View;", "", "Lkotlin/collections/ArrayList;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getPluginLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "rotationHelper", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRotationHelper;", "acceptLinkMic", "", "liveId", "", "objectId", "objectNonceId", "liveCookie", "", "scene", "toContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "micType", "userId", "sessionId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "announceGotoShopping", "productId", "applyLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "cacheViewVisibility", "view", "visibility", "changeScreenOrientation", "", "changeScreenToLandscape", "changeScreenToPortrait", "closeLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "closeMiniProgram", "consumeGift", "context", "Landroid/content/Context;", "sessionID", "consumeWeCoin", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "doAcceptLiveMic", "finderLinkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLinkMicUser;", "doApplyLiveMic", "invitedUsername", "doCloseLive", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "success", "errCode", "errType", "errMsg", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "resp", "doCloseLiveMic", "doCloseVisitorLive", "doCreateLive", "Lkotlin/Function7;", "needFaceVerify", "verifyUrl", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "doDisableComment", "username", "enable", "Lkotlin/Function2;", "doFetchFinderContact", "finderUsername", "doFinishLive", "manualFinish", "isSecondDaryDevice", "Lcom/tencent/mm/plugin/finder/live/viewmodel/AnchorFinishInfo;", "info", "doGetFinderLiveContact", "contact", "doGetGiftList", "doGetMemberList", "Lkotlin/Function4;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "doGetMicCandidateList", "doGetProductList", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "Lkotlin/Function1;", "doHighLightLikeLive", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "doJoinLive", "role", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "doLikeLive", "count", "doManualCloseLive", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "doPostAppMsg", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "doPostComment", "commentContent", "liveMsgType", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "doPostGift", "rewardGiftId", "rewardGiftCnt", "wecoin", "comboId", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "doPrepareLive", "micFinderUsername", "micFinderObjectId", "micLiveId", "enableAutoRotation", "expose", "commentSeq", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "genAcceptLinkMicMsg", "genApplyLinkMicMsg", "genCloseLinkMicMsg", "getLotteryRecord", "lotteryId", "lastBuff", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "getProductDetail", "product", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "getWeCoinBalance", "getWeCoinBalanceFromCache", "gotoWebViewWithoutMiniWindow", "intent", "Landroid/content/Intent;", "requestCode", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "initEngine", "sucCallback", "failCallback", "isWeCoinEntranceAvailable", "lockScreenRotation", "openFullScreenMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "openHalfScreenMiniProgram", "openMiniProgram", "processCreateLiveResponse", "response", "processJoinLiveResponse", "processLiveCgiSDKResponse", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "putInBlackList", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "refreshLinkMic", "sdkUserId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "resumeViewVisibility", "setAnchorStatus", "flag", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "showRechargeFoodsDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "Landroid/support/v4/app/FragmentActivity;", "Lkotlin/Function0;", "showWeCoinEntranceTutorialDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "Landroid/app/Activity;", "plugin-finder_release"})
public final class b
  implements s
{
  final String TAG;
  com.tencent.mm.plugin.finder.live.viewmodel.g liveData;
  ArrayList<kotlin.o<View, Integer>> uhL;
  private l uhM;
  final FinderBaseLivePluginLayout uhN;
  
  public b(FinderBaseLivePluginLayout paramFinderBaseLivePluginLayout)
  {
    AppMethodBeat.i(246073);
    this.uhN = paramFinderBaseLivePluginLayout;
    this.TAG = "Finder.FinderLiveAssistant";
    this.liveData = this.uhN.getLiveData();
    this.uhL = new ArrayList();
    paramFinderBaseLivePluginLayout = this.uhN.getContext();
    if (paramFinderBaseLivePluginLayout == null)
    {
      paramFinderBaseLivePluginLayout = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
      AppMethodBeat.o(246073);
      throw paramFinderBaseLivePluginLayout;
    }
    this.uhM = new l((MMFinderUI)paramFinderBaseLivePluginLayout);
    AppMethodBeat.o(246073);
  }
  
  private final void b(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(246053);
    Object localObject = com.tencent.mm.plugin.finder.live.j.ugg;
    com.tencent.mm.plugin.finder.live.j.a(this.liveData, paramg, paramBoolean);
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (com.tencent.mm.plugin.finder.storage.c.dvc()) {}
    for (paramg.iOo = 1;; paramg.iOo = 0)
    {
      localObject = this.liveData;
      String str = paramg.appId;
      kotlin.g.b.p.g(str, "bundle.appId");
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).atU(str);
      localObject = this.uhN;
      str = paramg.appId;
      kotlin.g.b.p.g(str, "bundle.appId");
      paramg.kHB = ((ValueCallback)new com.tencent.mm.plugin.finder.live.i((FinderBaseLivePluginLayout)localObject, str));
      paramg.kHC = 1000;
      localObject = o.ujN;
      o.b(paramContext, paramg);
      AppMethodBeat.o(246053);
      return;
    }
  }
  
  public final void E(final kotlin.g.a.b<? super Long, kotlin.x> paramb)
  {
    AppMethodBeat.i(246070);
    Log.i(this.TAG, "[WeCoin] getWeCoinBalance");
    ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).a((com.tencent.mm.plugin.wallet.wecoin.a.e)new u(this, paramb));
    AppMethodBeat.o(246070);
  }
  
  public final void EH(long paramLong)
  {
    AppMethodBeat.i(246057);
    boolean bool = this.liveData.uEn.contains(Long.valueOf(paramLong));
    Log.i(this.TAG, "announceGotoShopping productId:" + paramLong + ", haveBug:" + bool);
    if ((paramLong != 0L) && (!bool))
    {
      this.liveData.uEn.add(Long.valueOf(paramLong));
      o.c localc = o.c.hGH;
      a("", o.c.aFv(), null);
    }
    AppMethodBeat.o(246057);
  }
  
  public final void Jf(int paramInt)
  {
    AppMethodBeat.i(246035);
    Log.i(this.TAG, "[likeInfo] doLikeLive:".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      AppMethodBeat.o(246035);
      return;
    }
    Object localObject = this.liveData.liveInfo;
    ((awe)localObject).wBG += paramInt;
    localObject = am.tuw;
    new com.tencent.mm.plugin.finder.live.model.cgi.j(am.cXY(), this.liveData.hIt, this.liveData.liveInfo.liveId, paramInt, this.liveData.hFK, (j.a)new o(this)).aYI();
    AppMethodBeat.o(246035);
  }
  
  public final com.tencent.mm.plugin.wallet.wecoin.a.d a(final FragmentActivity paramFragmentActivity, int paramInt, final kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(246071);
    kotlin.g.b.p.h(paramFragmentActivity, "context");
    kotlin.g.b.p.h(parama, "callback");
    String str = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMG();
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      Log.i(this.TAG, "showRechargeFoodsDialog sessionId:".concat(String.valueOf(str)));
      paramFragmentActivity = ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).a(paramFragmentActivity, paramInt, str, (com.tencent.mm.plugin.wallet.wecoin.a.e)new y(this, paramFragmentActivity, parama));
      AppMethodBeat.o(246071);
      return paramFragmentActivity;
    }
  }
  
  public final void a(int paramInt, d.a parama)
  {
    Object localObject3 = null;
    AppMethodBeat.i(246067);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
    boolean bool = com.tencent.mm.plugin.finder.utils.m.dBP();
    Object localObject2;
    if (bool)
    {
      localObject1 = this.liveData.uEB;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.e)localObject1).uCo;
        if (!bool) {
          break label483;
        }
        localObject2 = this.liveData.uEB;
        if (localObject2 == null) {
          break label477;
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.e)localObject2).sessionId;
      }
    }
    for (;;)
    {
      Object localObject5 = this.TAG;
      Object localObject4 = new StringBuilder("closeLinkMic isAnchor:").append(bool).append(", linkMicState:").append(this.liveData.uEC).append(", liveId:").append(this.liveData.liveInfo.liveId).append(", objectId:").append(this.liveData.hFK).append(", nonceId:").append(this.liveData.hwg).append(", scene:").append(paramInt).append(", userId:");
      Object localObject6 = this.liveData.uEB;
      if (localObject6 != null) {
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.e)localObject6).uCo;
      }
      localObject6 = ((StringBuilder)localObject4).append((String)localObject3).append(", selfSdkId:").append(this.liveData.djq()).append(", sessionId:");
      localObject3 = this.liveData.uEB;
      if (localObject3 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.e)localObject3).sessionId;
        localObject3 = localObject4;
        if (localObject4 != null) {}
      }
      else
      {
        localObject3 = "";
      }
      Log.i((String)localObject5, (String)localObject3 + ", applySessionId:" + this.liveData.uEy);
      long l1 = this.liveData.liveInfo.liveId;
      long l2 = this.liveData.hFK;
      localObject4 = this.liveData.hwg;
      localObject5 = this.liveData.hIt;
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = "";
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = new aut();
      ((aut)localObject2).session_id = ((String)localObject1);
      localObject1 = new aux();
      ((aux)localObject1).Lmn = ((String)localObject3);
      ((aut)localObject2).LFB = com.tencent.mm.bw.b.cD(((aux)localObject1).toByteArray());
      localObject1 = o.l.hHy;
      ((aut)localObject2).ybm = o.l.aFS();
      localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
      ((aut)localObject2).LFr = com.tencent.mm.plugin.finder.utils.y.dCV();
      new com.tencent.mm.plugin.finder.live.model.cgi.d(l1, l2, (String)localObject4, (byte[])localObject5, paramInt, (aut)localObject2, parama).aYI();
      AppMethodBeat.o(246067);
      return;
      localObject1 = null;
      break;
      localObject1 = this.liveData.djq();
      break;
      label477:
      localObject2 = null;
      continue;
      label483:
      localObject2 = this.liveData.uEy;
    }
  }
  
  public final void a(int paramInt, final kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super ape, kotlin.x> params)
  {
    AppMethodBeat.i(246033);
    Log.i(this.TAG, "doCloseLive liveId:" + this.liveData.liveInfo.liveId + " objectId:" + this.liveData.hFK + " nonceId:" + this.liveData.hwg);
    long l = this.liveData.liveInfo.liveId;
    String str = z.aUg();
    kotlin.g.b.p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
    new com.tencent.mm.plugin.finder.live.model.cgi.c(l, str, this.liveData.hFK, this.liveData.hwg, paramInt, (c.a)new b(this, params)).aYI();
    EventCenter.instance.publish((IEvent)new hi());
    AppMethodBeat.o(246033);
  }
  
  public final void a(final int paramInt, final kotlin.g.a.u<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.live.core.core.b.e, ? super TRTCCloudDef.TRTCParams, ? super auf, kotlin.x> paramu)
  {
    AppMethodBeat.i(246030);
    new com.tencent.mm.plugin.finder.live.model.cgi.i(this.liveData.liveInfo.liveId, this.liveData.hIt, z.aUg(), this.liveData.hFK, paramInt, this.liveData.hwg, this.liveData.sessionBuffer, (i.a)new n(this, paramu, paramInt)).aYI();
    AppMethodBeat.o(246030);
  }
  
  public final void a(long paramLong1, long paramLong2, com.tencent.mm.bw.b paramb, final kotlin.g.a.b<? super Boolean, kotlin.x> paramb1)
  {
    AppMethodBeat.i(246039);
    Object localObject = com.tencent.mm.plugin.finder.utils.m.vVH;
    final int i;
    if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
      if (!this.liveData.uEj) {
        i = 2;
      }
    }
    for (;;)
    {
      localObject = z.aUg();
      kotlin.g.b.p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      paramb = new com.tencent.mm.plugin.finder.live.model.cgi.q(paramLong1, paramLong2, (String)localObject, paramb, i, this.liveData.dPI, (q.a)new l(this, paramb1, i)).aYI();
      paramb1 = this.uhN.getContext();
      if (paramb1 != null) {
        break;
      }
      paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(246039);
      throw paramb;
      i = 1;
      continue;
      i = 0;
    }
    paramb.a((com.tencent.mm.vending.e.b)paramb1);
    AppMethodBeat.o(246039);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt1, avn paramavn, int paramInt2, com.tencent.mm.plugin.finder.live.model.cgi.b.a parama)
  {
    AppMethodBeat.i(246065);
    Log.i(this.TAG, "applyLinkMic liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString + ", scene:" + paramInt1 + ", micType:" + paramInt2);
    aut localaut = new aut();
    localaut.LFz = paramavn;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramavn);
    localaut.LFD = localLinkedList;
    paramavn = new auw();
    paramavn.LFG = paramInt2;
    localaut.LFB = com.tencent.mm.bw.b.cD(paramavn.toByteArray());
    paramavn = o.l.hHy;
    localaut.ybm = o.l.aFQ();
    paramavn = com.tencent.mm.plugin.finder.utils.y.vXH;
    localaut.LFr = com.tencent.mm.plugin.finder.utils.y.dCV();
    new com.tencent.mm.plugin.finder.live.model.cgi.b(paramLong1, paramLong2, paramString, paramArrayOfByte, paramInt1, localaut, parama).aYI();
    AppMethodBeat.o(246065);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, avn paramavn, int paramInt2, String paramString2, String paramString3, a.a parama)
  {
    AppMethodBeat.i(246066);
    Log.i(this.TAG, "acceptLinkMic liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString1 + ", scene:" + paramInt1 + ", micType:" + paramInt2 + ", userId:" + paramString2 + ", sessionId:" + paramString3);
    aut localaut = new aut();
    localaut.session_id = paramString3;
    localaut.LFz = paramavn;
    paramavn = new auu();
    paramavn.LFG = paramInt2;
    paramavn.Lmn = paramString2;
    localaut.LFB = com.tencent.mm.bw.b.cD(paramavn.toByteArray());
    paramavn = o.l.hHy;
    localaut.ybm = o.l.aFR();
    paramavn = com.tencent.mm.plugin.finder.utils.y.vXH;
    localaut.LFr = com.tencent.mm.plugin.finder.utils.y.dCV();
    new com.tencent.mm.plugin.finder.live.model.cgi.a(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt1, localaut, parama).aYI();
    AppMethodBeat.o(246066);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, com.tencent.mm.plugin.finder.live.model.cgi.u.a parama)
  {
    AppMethodBeat.i(246068);
    Log.i(this.TAG, "refreshLinkMic liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", nonceId:" + paramString1 + ", scene:" + paramInt + ", sdkUserId:" + paramString2);
    new com.tencent.mm.plugin.finder.live.model.cgi.u(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramInt, paramString2, parama).aYI();
    AppMethodBeat.o(246068);
  }
  
  public final void a(Context paramContext, Intent paramIntent, Integer paramInteger)
  {
    AppMethodBeat.i(246056);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramIntent, "intent");
    this.liveData.uDS = false;
    if (paramInteger != null)
    {
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent, paramInteger.intValue());
      AppMethodBeat.o(246056);
      return;
    }
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    AppMethodBeat.o(246056);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(246051);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramg, "bundle");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("open fullscreen miniPro appId:").append(paramg.appId).append(",patch:").append(paramg.kHw).append(",luanchFromApp:").append(paramBoolean).append(",is test:");
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    Log.i(str, com.tencent.mm.plugin.finder.storage.c.dvc());
    if ((Util.isNullOrNil(paramg.appId)) || (Util.isNullOrNil(paramg.kHw)))
    {
      AppMethodBeat.o(246051);
      return;
    }
    paramg.kHM = true;
    b(paramContext, paramg, paramBoolean);
    AppMethodBeat.o(246051);
  }
  
  public final void a(final Context paramContext, final String paramString1, final int paramInt1, final int paramInt2, final String paramString2, final af.a parama)
  {
    AppMethodBeat.i(246048);
    kotlin.g.b.p.h(paramContext, "context");
    if (this.liveData.dja())
    {
      Object localObject1 = e.uiD;
      if (!e.getDebug())
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1581, 70);
        localObject1 = z.aUg();
        Object localObject2 = com.tencent.mm.plugin.finder.utils.y.vXH;
        localObject2 = com.tencent.mm.plugin.finder.utils.y.dCV();
        com.tencent.mm.plugin.report.service.h.CyF.a(22129, new Object[] { Integer.valueOf(1), localObject2, "", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "" });
        new v(this.liveData.liveInfo.liveId, this.liveData.hFK, paramString1, paramInt1, (String)localObject1, paramInt2, (String)localObject2, paramString2, (v.a)new r(this, paramInt2, paramContext, (String)localObject2, parama, paramString1, paramInt1, paramString2)).aYI();
      }
    }
    AppMethodBeat.o(246048);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.b paramb)
  {
    AppMethodBeat.i(246038);
    kotlin.g.b.p.h(paramb, "finderLinkUser");
    AppMethodBeat.o(246038);
  }
  
  public final void a(axg paramaxg)
  {
    AppMethodBeat.i(246040);
    kotlin.g.b.p.h(paramaxg, "product");
    if (paramaxg.LHK == 0)
    {
      Log.i(this.TAG, "[getProductDetail] product:" + paramaxg.title + " is not promotting, return ");
      AppMethodBeat.o(246040);
      return;
    }
    new com.tencent.mm.plugin.finder.live.model.cgi.p(this.liveData, paramaxg, (p.a)new t(this)).aYI();
    AppMethodBeat.o(246040);
  }
  
  final void a(cjc paramcjc, TRTCCloudDef.TRTCParams paramTRTCParams, com.tencent.mm.live.core.core.b.e parame)
  {
    boolean bool2 = false;
    AppMethodBeat.i(246050);
    Object localObject2 = paramcjc.Mot;
    Object localObject1 = paramcjc.Mou;
    cja localcja = paramcjc.Mov;
    Object localObject3;
    if (localObject2 != null)
    {
      if (((cjd)localObject2).Mow > 0)
      {
        localObject3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance()");
        localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).aDD();
        kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).setVideoResolution(((cjd)localObject2).Mow);
      }
      if (((cjd)localObject2).Moy > 0)
      {
        localObject3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance()");
        localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).aDD();
        kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).qu(((cjd)localObject2).Moy);
      }
      if (((cjd)localObject2).Moz > 0)
      {
        localObject3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance()");
        localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).aDD();
        kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).setVideoBitrate(((cjd)localObject2).Moz);
      }
      if (((cjd)localObject2).MoB > 0)
      {
        localObject3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance()");
        localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).aDD();
        kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).qv(((cjd)localObject2).MoB);
      }
      i = ((cjd)localObject2).MoC;
      if (i >= 0) {}
    }
    else
    {
      if (localObject1 != null)
      {
        if (((ciz)localObject1).MnT > 0)
        {
          localObject2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
          kotlin.g.b.p.g(localObject2, "ConfigHelper.getInstance()");
          localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).aDE();
          kotlin.g.b.p.g(localObject2, "ConfigHelper.getInstance().audioConfig");
          ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject2).setAudioQuality(((ciz)localObject1).MnT);
        }
        Log.i(this.TAG, "processLiveSdkParams audioQuality:" + ((ciz)localObject1).MnT);
      }
      if (localcja == null) {
        break label794;
      }
      Log.i(this.TAG, "userDefineRecordId:" + localcja.MnU);
      localObject1 = localcja.MnV;
      localObject2 = localcja.MnU;
      int j = localcja.Moe;
      i = j;
      if (!com.tencent.mm.modelcontrol.e.sX(5))
      {
        i = j;
        if (j == com.tencent.mm.live.core.core.a.hwC.value) {
          i = localcja.Mof;
        }
      }
      parame.hzr = localcja.Mof;
      if (i >= 100) {
        break label601;
      }
      parame.a(com.tencent.mm.live.core.core.b.a.hyD);
      parame.hzq = i;
      label423:
      localObject3 = (Collection)localcja.Moa;
      if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
        break label643;
      }
    }
    label643:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label649;
      }
      localObject3 = localcja.Moa;
      kotlin.g.b.p.g(localObject3, "channelParams.cdn_trans_info");
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (vh)((Iterator)localObject3).next();
        Map localMap = (Map)parame.hzs;
        i = ((vh)localObject4).LfB;
        localObject4 = ((vh)localObject4).url;
        kotlin.g.b.p.g(localObject4, "it.url");
        localMap.put(Integer.valueOf(i), localObject4);
      }
      if (1 < i) {
        break;
      }
      localObject3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
      kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance()");
      localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).aDD();
      kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).qt(((cjd)localObject2).MoC);
      break;
      label601:
      if (i == com.tencent.mm.live.core.core.a.hwD.value)
      {
        parame.a(com.tencent.mm.live.core.core.b.a.hyE);
        break label423;
      }
      if (i != com.tencent.mm.live.core.core.a.hwE.value) {
        break label423;
      }
      parame.a(com.tencent.mm.live.core.core.b.a.hyF);
      break label423;
    }
    label649:
    if ((!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil((String)localObject2)))
    {
      localObject3 = new com.tencent.mm.ab.i();
      if (!Util.isNullOrNil((String)localObject1)) {
        ((com.tencent.mm.ab.i)localObject3).h("userdefine_streamid_main", localObject1);
      }
      if (!Util.isNullOrNil((String)localObject2)) {
        ((com.tencent.mm.ab.i)localObject3).h("userdefine_record_id", localObject2);
      }
      localObject1 = new com.tencent.mm.ab.i();
      ((com.tencent.mm.ab.i)localObject1).h("Str_uc_params", localObject3);
      paramTRTCParams.businessInfo = ((com.tencent.mm.ab.i)localObject1).toString();
    }
    Log.i(this.TAG, "processLiveSdkParams cdnQualitySvrcfg" + parame.hzq + " cdnSwitchMode:" + parame.hzp + " cdn_quality_h265backcfg:" + parame.hzr);
    label794:
    boolean bool1;
    if (localcja != null)
    {
      this.liveData.uEt = localcja.Mog;
      paramTRTCParams = this.liveData;
      if (paramcjc.Mov.Moh == 1)
      {
        bool1 = true;
        paramTRTCParams.uET = bool1;
        paramTRTCParams = this.liveData;
        bool1 = bool2;
        if (paramcjc.Mov.Moi == 1) {
          bool1 = true;
        }
        paramTRTCParams.uEU = bool1;
      }
    }
    else
    {
      paramcjc = com.tencent.mm.plugin.finder.utils.y.vXH;
      if (com.tencent.mm.plugin.finder.utils.y.dCM())
      {
        paramcjc = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvj()) {
          this.liveData.uEt = 1;
        }
      }
      paramTRTCParams = this.TAG;
      parame = new StringBuilder("processLiveSdkParams support_screen_rotate:");
      if (localcja == null) {
        break label998;
      }
    }
    label998:
    for (paramcjc = Integer.valueOf(localcja.Mog);; paramcjc = null)
    {
      paramcjc = parame.append(paramcjc).append(",config:");
      parame = com.tencent.mm.plugin.finder.storage.c.vCb;
      Log.i(paramTRTCParams, com.tencent.mm.plugin.finder.storage.c.dvj() + ", qosReport:" + this.liveData.uET + ", qosControl:" + this.liveData.uEU);
      AppMethodBeat.o(246050);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a(String paramString, int paramInt, final l.a parama)
  {
    AppMethodBeat.i(246042);
    kotlin.g.b.p.h(paramString, "commentContent");
    new com.tencent.mm.plugin.finder.live.model.cgi.l(this.liveData.liveInfo.liveId, paramString, paramInt, this.liveData.hIt, this.liveData.hFK, (l.a)new q(this, parama)).aYI();
    AppMethodBeat.o(246042);
  }
  
  public final void a(String paramString, com.tencent.mm.bw.b paramb, final o.a parama)
  {
    AppMethodBeat.i(246064);
    kotlin.g.b.p.h(paramString, "lotteryId");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
    int i;
    if (com.tencent.mm.plugin.finder.utils.m.dBP())
    {
      localObject1 = o.m.hHB;
      i = o.m.aFV();
      localObject1 = z.aUg();
      kotlin.g.b.p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject2 = this.liveData.liveInfo;
      if (localObject2 == null) {
        break label151;
      }
    }
    label151:
    for (Object localObject2 = Long.valueOf(((awe)localObject2).liveId);; localObject2 = null)
    {
      new com.tencent.mm.plugin.finder.live.model.cgi.o(i, (String)localObject1, ((Long)localObject2).longValue(), this.liveData.hFK, this.liveData.hIt, this.liveData.hwg, paramString, paramb, (o.a)new s(this, parama)).aYI();
      AppMethodBeat.o(246064);
      return;
      localObject1 = o.m.hHB;
      i = o.m.aFW();
      localObject1 = "";
      break;
    }
  }
  
  public final void a(final String paramString, final boolean paramBoolean, final kotlin.g.a.m<? super Boolean, ? super Boolean, kotlin.x> paramm)
  {
    AppMethodBeat.i(246043);
    if (paramString != null)
    {
      new com.tencent.mm.plugin.finder.cgi.t(this.liveData.liveInfo.liveId, this.liveData.hFK, paramString, paramBoolean, (t.a)new e(this, paramBoolean, paramString, paramm)).aYI();
      AppMethodBeat.o(246043);
      return;
    }
    AppMethodBeat.o(246043);
  }
  
  public final void a(final kotlin.g.a.u<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super Integer, ? super String, ? super aqd, kotlin.x> paramu)
  {
    AppMethodBeat.i(246031);
    LinkedList localLinkedList = new LinkedList();
    if (this.liveData.uFa == 1)
    {
      com.tencent.mm.plugin.finder.utils.m localm = com.tencent.mm.plugin.finder.utils.m.vVH;
      localLinkedList.addAll((Collection)com.tencent.mm.plugin.finder.utils.m.ez(this.liveData.uEZ));
    }
    new com.tencent.mm.plugin.finder.live.model.cgi.e(z.aUg(), this.liveData.uDm, this.liveData.uix, this.liveData.uFa, localLinkedList, (e.a)new d(this, paramu), (byte)0).aYI();
    AppMethodBeat.o(246031);
  }
  
  public final void a(boolean paramBoolean, final kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.plugin.finder.live.viewmodel.a, kotlin.x> params)
  {
    AppMethodBeat.i(246032);
    Log.i(this.TAG, "doFinishLive manualFinish:" + paramBoolean + " isSecondDaryDevice:false");
    if (!paramBoolean)
    {
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).getLiveInfo(Long.valueOf(this.liveData.liveInfo.liveId), (aj.b)new f(this, params));
      AppMethodBeat.o(246032);
      return;
    }
    if (paramBoolean)
    {
      params = (kotlin.g.a.s)new g(this, params);
      Log.i(this.TAG, "doManualCloseLive liveId:" + this.liveData.liveInfo.liveId + " objectId:" + this.liveData.hFK + " nonceId:" + this.liveData.hwg);
      new com.tencent.mm.plugin.finder.live.model.cgi.x(this.liveData.liveInfo.liveId, this.liveData.hFK, this.liveData.hwg, (x.a)new p(this, params)).aYI();
      EventCenter.instance.publish((IEvent)new hi());
      AppMethodBeat.o(246032);
      return;
    }
    s.a.a(this, (kotlin.g.a.s)new h(params));
    AppMethodBeat.o(246032);
  }
  
  public final void ag(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(246058);
    kotlin.g.b.p.h(paramView, "view");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramView, paramInt));
    AppMethodBeat.o(246058);
  }
  
  public final void atx(String paramString)
  {
    AppMethodBeat.i(246037);
    kotlin.g.b.p.h(paramString, "invitedUsername");
    AppMethodBeat.o(246037);
  }
  
  public final void aty(String paramString)
  {
    AppMethodBeat.i(246041);
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      paramString = new cn(paramString, 0L, null, 0, null, 0, 0L, 104);
      paramString.twC = true;
      com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramString);
      AppMethodBeat.o(246041);
      return;
    }
  }
  
  public final void b(Context paramContext, long paramLong, String paramString, Long paramLong1, int paramInt)
  {
    AppMethodBeat.i(246055);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramString, "username");
    this.liveData.uDS = false;
    com.tencent.mm.plugin.finder.feed.logic.a locala = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
    com.tencent.mm.plugin.finder.feed.logic.a.a(paramContext, paramLong, paramString, paramLong1, paramInt);
    AppMethodBeat.o(246055);
  }
  
  public final void b(final String paramString, final kotlin.g.a.m<? super Boolean, ? super avn, kotlin.x> paramm)
  {
    AppMethodBeat.i(246044);
    if (paramString != null)
    {
      new com.tencent.mm.plugin.finder.cgi.u(this.liveData.liveInfo.liveId, this.liveData.hFK, paramString, 0, (com.tencent.mm.plugin.finder.cgi.u.a)new i(this, 0, paramString, paramm)).aYI();
      AppMethodBeat.o(246044);
      return;
    }
    AppMethodBeat.o(246044);
  }
  
  public final void c(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(246052);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramg, "bundle");
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("open halfscreen miniPro appId:").append(paramg.appId).append(",patch:").append(paramg.kHw).append(",is test:");
    Object localObject3 = com.tencent.mm.plugin.finder.storage.c.vCb;
    Log.i((String)localObject1, com.tencent.mm.plugin.finder.storage.c.dvc());
    if ((Util.isNullOrNil(paramg.appId)) || (Util.isNullOrNil(paramg.kHw)))
    {
      AppMethodBeat.o(246052);
      return;
    }
    localObject2 = paramg.kHL;
    if (localObject2 != null)
    {
      localObject1 = new HalfScreenConfig.b();
      boolean bool = ((HalfScreenConfig)localObject2).isEnable();
      ((HalfScreenConfig.b)localObject1).enable = bool;
      int i = ((HalfScreenConfig)localObject2).height;
      ((HalfScreenConfig.b)localObject1).height = i;
      bool = ((HalfScreenConfig)localObject2).lfm;
      ((HalfScreenConfig.b)localObject1).lfm = bool;
      localObject3 = ((HalfScreenConfig)localObject2).lfn;
      kotlin.g.b.p.h(localObject3, "activityAnimStyle");
      ((HalfScreenConfig.b)localObject1).lfn = ((HalfScreenConfig.a)localObject3);
      bool = ((HalfScreenConfig)localObject2).lfo;
      ((HalfScreenConfig.b)localObject1).lfo = bool;
      ((HalfScreenConfig.b)localObject1).a(((HalfScreenConfig)localObject2).lfq);
      localObject3 = ((HalfScreenConfig)localObject2).lfp;
      kotlin.g.b.p.h(localObject3, "bgShapeConf");
      ((HalfScreenConfig.b)localObject1).lfp = ((HalfScreenConfig.BackgroundShapeConfig)localObject3);
      bool = ((HalfScreenConfig)localObject2).kuZ;
      ((HalfScreenConfig.b)localObject1).kuZ = bool;
      localObject2 = paramContext.getClass().getName();
      kotlin.g.b.p.g(localObject2, "context.javaClass.name");
      localObject1 = ((HalfScreenConfig.b)localObject1).a(new HalfScreenConfig.CloseWhenClickEmptyAreaConfig((String)localObject2, HalfScreenConfig.a.lft));
    }
    for (localObject1 = new HalfScreenConfig(((HalfScreenConfig.b)localObject1).enable, ((HalfScreenConfig.b)localObject1).height, ((HalfScreenConfig.b)localObject1).lfm, ((HalfScreenConfig.b)localObject1).lfn, ((HalfScreenConfig.b)localObject1).lfo, ((HalfScreenConfig.b)localObject1).lfp, ((HalfScreenConfig.b)localObject1).kuZ, ((HalfScreenConfig.b)localObject1).lfq);; localObject1 = null)
    {
      paramg.kHL = ((HalfScreenConfig)localObject1);
      b(paramContext, paramg, true);
      AppMethodBeat.o(246052);
      return;
    }
  }
  
  public final void c(String paramString, kotlin.g.a.m<? super ayt, ? super apg, kotlin.x> paramm)
  {
    AppMethodBeat.i(246045);
    Log.i(this.TAG, "putInBlackList username:".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.t.class)).b(paramString, (ai)new w(paramm));
      AppMethodBeat.o(246045);
      return;
    }
    AppMethodBeat.o(246045);
  }
  
  public final void c(r<? super Integer, ? super Integer, ? super String, ? super ban, kotlin.x> paramr)
  {
    AppMethodBeat.i(246036);
    Object localObject = com.tencent.mm.plugin.finder.cgi.x.ttF;
    localObject = new aut();
    o.l locall = o.l.hHy;
    ((aut)localObject).ybm = o.l.aFT();
    ((aut)localObject).LFr = (z.aTY() + System.currentTimeMillis());
    new com.tencent.mm.plugin.finder.cgi.x((aut)localObject, this.liveData, (r)new m(paramr)).aYI();
    AppMethodBeat.o(246036);
  }
  
  public final void d(final r<? super Integer, ? super Integer, ? super String, ? super asu, kotlin.x> paramr)
  {
    AppMethodBeat.i(246049);
    Object localObject = am.tuw;
    localObject = am.cXY();
    long l = this.liveData.liveInfo.liveId;
    String str = z.aUg();
    kotlin.g.b.p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
    paramr = new com.tencent.mm.plugin.finder.live.model.cgi.y((aov)localObject, l, str, this.liveData.hFK, (y.a)new k(this, paramr)).aYI();
    localObject = this.uhN.getContext();
    if (localObject == null)
    {
      paramr = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(246049);
      throw paramr;
    }
    paramr.a((com.tencent.mm.vending.e.b)localObject);
    AppMethodBeat.o(246049);
  }
  
  public final void dfj()
  {
    AppMethodBeat.i(246034);
    Log.i(this.TAG, "doCloseVisitorLive liveId:" + this.liveData.liveInfo.liveId + " objectId:" + this.liveData.hFK + " nonceId:" + this.liveData.hwg);
    am localam = am.tuw;
    new com.tencent.mm.plugin.finder.live.model.cgi.h(am.cXY(), z.aUg(), this.liveData.hIt, this.liveData.liveInfo.liveId, this.liveData.hFK, this.liveData.hwg, 0, true, null, (h.a)new c(), 256).aYI();
    AppMethodBeat.o(246034);
  }
  
  public final void dfk()
  {
    AppMethodBeat.i(246054);
    Log.i(this.TAG, "close miniPro appId:" + this.liveData.uEq);
    Object localObject = o.ujN;
    localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
    o.fo((Context)localObject);
    AppMethodBeat.o(246054);
  }
  
  public final void dfl()
  {
    AppMethodBeat.i(246059);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new x(this));
    AppMethodBeat.o(246059);
  }
  
  public final void dfm()
  {
    boolean bool = true;
    AppMethodBeat.i(246060);
    l locall;
    if (this.liveData.djm()) {
      locall = this.uhM;
    }
    for (;;)
    {
      try
      {
        if (Settings.System.getInt(XWalkEnvironment.getContentResolver(), "accelerometer_rotation") == 1)
        {
          Object localObject = locall.ujj;
          if ((localObject != null) && (((MMFinderUI)localObject).getRequestedOrientation() != -1))
          {
            ((MMFinderUI)localObject).vPS = true;
            ((MMFinderUI)localObject).setRequestedOrientation(-1);
          }
          localObject = locall.TAG;
          StringBuilder localStringBuilder = new StringBuilder("enableAutoRotation ACCELEROMETER_ROTATION context is null:");
          if (locall.ujj != null) {
            break label164;
          }
          Log.i((String)localObject, bool + '!');
          AppMethodBeat.o(246060);
          return;
        }
        Log.i(locall.TAG, "enableAutoRotation ACCELEROMETER_ROTATION failed!");
        AppMethodBeat.o(246060);
        return;
      }
      catch (Exception localException)
      {
        Log.e(locall.TAG, "enableAutoRotation " + localException.getMessage());
      }
      AppMethodBeat.o(246060);
      return;
      label164:
      bool = false;
    }
  }
  
  public final void dfn()
  {
    AppMethodBeat.i(246061);
    Object localObject2;
    int i;
    Object localObject3;
    if (this.liveData.djm())
    {
      localObject1 = this.uhM;
      localObject2 = ((l)localObject1).ujj.getResources();
      kotlin.g.b.p.g(localObject2, "context.resources");
      i = ((Resources)localObject2).getConfiguration().orientation;
      if (i != 2) {
        break label284;
      }
      localObject2 = ((l)localObject1).ujj;
      if (localObject2 != null)
      {
        ((MMFinderUI)localObject2).vPS = true;
        localObject3 = ((MMFinderUI)localObject2).getContext();
        kotlin.g.b.p.g(localObject3, "context");
        localObject3 = ((AppCompatActivity)localObject3).getWindow();
        kotlin.g.b.p.g(localObject3, "context.window");
        localObject3 = ((Window)localObject3).getWindowManager();
        kotlin.g.b.p.g(localObject3, "context.window.windowManager");
        localObject3 = ((WindowManager)localObject3).getDefaultDisplay();
        kotlin.g.b.p.g(localObject3, "context.window.windowManager.defaultDisplay");
        if (((Display)localObject3).getRotation() != 1) {
          break label205;
        }
        ((MMFinderUI)localObject2).setRequestedOrientation(0);
      }
      localObject2 = ((l)localObject1).TAG;
      localObject3 = new StringBuilder("lockScreenRotation curOrientation:").append(i).append(",requestOrientation:");
      localObject1 = ((l)localObject1).ujj;
      if (localObject1 == null) {
        break label311;
      }
    }
    label284:
    label311:
    for (Object localObject1 = Integer.valueOf(((MMFinderUI)localObject1).getRequestedOrientation());; localObject1 = null)
    {
      Log.i((String)localObject2, ((Integer)localObject1).intValue());
      AppMethodBeat.o(246061);
      return;
      label205:
      localObject3 = ((MMFinderUI)localObject2).getContext();
      kotlin.g.b.p.g(localObject3, "context");
      localObject3 = ((AppCompatActivity)localObject3).getWindow();
      kotlin.g.b.p.g(localObject3, "context.window");
      localObject3 = ((Window)localObject3).getWindowManager();
      kotlin.g.b.p.g(localObject3, "context.window.windowManager");
      localObject3 = ((WindowManager)localObject3).getDefaultDisplay();
      kotlin.g.b.p.g(localObject3, "context.window.windowManager.defaultDisplay");
      if (((Display)localObject3).getRotation() != 3) {
        break;
      }
      ((MMFinderUI)localObject2).setRequestedOrientation(8);
      break;
      if (i != 1) {
        break;
      }
      localObject2 = ((l)localObject1).ujj;
      if (localObject2 == null) {
        break;
      }
      ((MMFinderUI)localObject2).vPS = true;
      ((MMFinderUI)localObject2).setRequestedOrientation(1);
      break;
    }
  }
  
  public final boolean dfo()
  {
    boolean bool2 = false;
    AppMethodBeat.i(246062);
    if (this.liveData.djm())
    {
      l locall = this.uhM;
      Object localObject1 = locall.ujj;
      boolean bool1;
      label66:
      Object localObject2;
      StringBuilder localStringBuilder;
      if (localObject1 != null)
      {
        localObject1 = ((MMFinderUI)localObject1).getResources();
        if (localObject1 != null)
        {
          localObject1 = ((Resources)localObject1).getConfiguration();
          if (localObject1 != null)
          {
            localObject1 = Integer.valueOf(((Configuration)localObject1).orientation);
            if (localObject1 != null) {
              break label153;
            }
            bool1 = bool2;
            localObject2 = locall.TAG;
            localStringBuilder = new StringBuilder("changeScreenToPortrait curOrientation:").append(localObject1).append(",requestOrientation:");
            localObject1 = locall.ujj;
            if (localObject1 == null) {
              break label194;
            }
          }
        }
      }
      label153:
      label194:
      for (localObject1 = Integer.valueOf(((MMFinderUI)localObject1).getRequestedOrientation());; localObject1 = null)
      {
        Log.i((String)localObject2, ((Integer)localObject1).intValue() + ",change:" + bool1);
        AppMethodBeat.o(246062);
        return bool1;
        localObject1 = null;
        break;
        bool1 = bool2;
        if (((Integer)localObject1).intValue() != 2) {
          break label66;
        }
        localObject2 = locall.ujj;
        bool1 = bool2;
        if (localObject2 == null) {
          break label66;
        }
        ((MMFinderUI)localObject2).vPS = true;
        ((MMFinderUI)localObject2).setRequestedOrientation(1);
        bool1 = true;
        break label66;
      }
    }
    AppMethodBeat.o(246062);
    return false;
  }
  
  public final boolean dfp()
  {
    boolean bool2 = false;
    AppMethodBeat.i(246063);
    if (this.liveData.djm())
    {
      l locall = this.uhM;
      Object localObject1 = locall.ujj;
      boolean bool1;
      label66:
      Object localObject2;
      StringBuilder localStringBuilder;
      if (localObject1 != null)
      {
        localObject1 = ((MMFinderUI)localObject1).getResources();
        if (localObject1 != null)
        {
          localObject1 = ((Resources)localObject1).getConfiguration();
          if (localObject1 != null)
          {
            localObject1 = Integer.valueOf(((Configuration)localObject1).orientation);
            if (localObject1 != null) {
              break label153;
            }
            bool1 = bool2;
            localObject2 = locall.TAG;
            localStringBuilder = new StringBuilder("changeScreenToLandscape curOrientation:").append(localObject1).append(",requestOrientation:");
            localObject1 = locall.ujj;
            if (localObject1 == null) {
              break label194;
            }
          }
        }
      }
      label153:
      label194:
      for (localObject1 = Integer.valueOf(((MMFinderUI)localObject1).getRequestedOrientation());; localObject1 = null)
      {
        Log.i((String)localObject2, ((Integer)localObject1).intValue() + ",change:" + bool1);
        AppMethodBeat.o(246063);
        return bool1;
        localObject1 = null;
        break;
        bool1 = bool2;
        if (((Integer)localObject1).intValue() != 1) {
          break label66;
        }
        localObject2 = locall.ujj;
        bool1 = bool2;
        if (localObject2 == null) {
          break label66;
        }
        ((MMFinderUI)localObject2).vPS = true;
        ((MMFinderUI)localObject2).setRequestedOrientation(0);
        bool1 = true;
        break label66;
      }
    }
    AppMethodBeat.o(246063);
    return false;
  }
  
  public final boolean dfq()
  {
    AppMethodBeat.i(246072);
    boolean bool = ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).dfq();
    AppMethodBeat.o(246072);
    return bool;
  }
  
  public final void f(final kotlin.g.a.m<? super Boolean, ? super Integer, kotlin.x> paramm)
  {
    AppMethodBeat.i(246047);
    if (!this.liveData.uEJ)
    {
      localObject = com.tencent.mm.plugin.finder.utils.y.vXH;
      if (!com.tencent.mm.plugin.finder.utils.y.dCM()) {}
    }
    else
    {
      localObject = e.uiD;
      if (e.getDebug())
      {
        Log.i(this.TAG, "doGetGiftList : enter debug");
        paramm = e.uiD;
        e.dfB();
        AppMethodBeat.o(246047);
        return;
      }
      new com.tencent.mm.plugin.finder.live.model.cgi.f(this.liveData.liveInfo.liveId, this.liveData.hFK, this.liveData.hwg, z.aUg(), (f.a)new j(this, paramm)).aYI();
      AppMethodBeat.o(246047);
      return;
    }
    paramm = this.TAG;
    Object localObject = new StringBuilder("doGetGiftList liveData.enableGiftSwitch:").append(this.liveData.uEJ).append(", FinderUtil.isTest():");
    com.tencent.mm.plugin.finder.utils.y localy = com.tencent.mm.plugin.finder.utils.y.vXH;
    Log.i(paramm, com.tencent.mm.plugin.finder.utils.y.dCM());
    AppMethodBeat.o(246047);
  }
  
  public final void fn(Context paramContext)
  {
    AppMethodBeat.i(246069);
    kotlin.g.b.p.h(paramContext, "context");
    Log.i(this.TAG, "[WeCoin] initEngine");
    ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).a(paramContext, (com.tencent.mm.plugin.wallet.wecoin.a.e)new v(this));
    AppMethodBeat.o(246069);
  }
  
  public final void h(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(246046);
    Log.i(this.TAG, "setAnchorStatus liveId:" + paramLong1 + " objectId:" + paramLong2 + " flag:" + paramInt);
    String str = z.aUg();
    kotlin.g.b.p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
    new com.tencent.mm.plugin.finder.cgi.s(paramLong1, paramLong2, paramInt, str, null).aYI();
    AppMethodBeat.o(246046);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    a(b paramb, View paramView, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCloseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder_release"})
  public static final class b
    implements c.a
  {
    b(kotlin.g.a.s params) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, ape paramape)
    {
      AppMethodBeat.i(245998);
      kotlin.g.b.p.h(paramape, "resp");
      Object localObject2;
      Boolean localBoolean;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i(this.uhO.TAG, "close live room failed");
        localObject2 = params;
        if (localObject2 != null)
        {
          localBoolean = Boolean.FALSE;
          if (paramString != null) {
            break label180;
          }
        }
      }
      label177:
      label180:
      for (Object localObject1 = "";; localObject1 = paramString)
      {
        ((kotlin.g.a.s)localObject2).a(localBoolean, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localObject1, paramape);
        paramape = ae.vZW;
        localObject1 = ae.dEg();
        paramape = paramString;
        if (paramString == null) {
          paramape = "";
        }
        ae.a((String)localObject1, paramInt2, paramInt1, paramape, this.uhO.liveData);
        AppMethodBeat.o(245998);
        return;
        localObject1 = params;
        if (localObject1 != null)
        {
          localObject2 = Boolean.TRUE;
          if (paramString != null) {
            break label177;
          }
          paramString = "";
        }
        for (;;)
        {
          ((kotlin.g.a.s)localObject1).a(localObject2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, paramape);
          AppMethodBeat.o(245998);
          return;
          AppMethodBeat.o(245998);
          return;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCloseVisitorLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "plugin-finder_release"})
  public static final class c
    implements h.a
  {
    public final void a(int paramInt1, int paramInt2, ass paramass)
    {
      AppMethodBeat.i(245999);
      kotlin.g.b.p.h(paramass, "resp");
      AppMethodBeat.o(245999);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCreateLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "plugin-finder_release"})
  public static final class d
    implements e.a
  {
    d(kotlin.g.a.u paramu) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aqd paramaqd)
    {
      AppMethodBeat.i(246000);
      kotlin.g.b.p.h(paramaqd, "resp");
      Object localObject3;
      Object localObject4;
      Boolean localBoolean;
      Object localObject1;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i(this.uhO.TAG, "launch live room failed");
        if (paramInt2 == -200008)
        {
          localObject3 = paramu;
          if (localObject3 != null)
          {
            localObject4 = Boolean.FALSE;
            localBoolean = Boolean.TRUE;
            localObject2 = paramaqd.LCf;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            if (paramString != null) {
              break label444;
            }
          }
        }
      }
      label305:
      label435:
      label444:
      for (Object localObject2 = "";; localObject2 = paramString)
      {
        ((kotlin.g.a.u)localObject3).invoke(localObject4, localBoolean, localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject2, paramaqd);
        do
        {
          paramaqd = ae.vZW;
          localObject1 = ae.dEb();
          paramaqd = paramString;
          if (paramString == null) {
            paramaqd = "";
          }
          ae.a((String)localObject1, paramInt2, paramInt1, paramaqd, this.uhO.liveData);
          AppMethodBeat.o(246000);
          return;
          localObject2 = paramu;
        } while (localObject2 == null);
        localObject3 = Boolean.FALSE;
        if (paramString == null) {}
        for (localObject1 = "";; localObject1 = paramString)
        {
          ((kotlin.g.a.u)localObject2).invoke(localObject3, localObject3, "", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject1, paramaqd);
          break;
          localObject3 = this.uhO;
          localObject1 = paramaqd.LCe;
          long l;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).liveInfo;
            localObject4 = ((b)localObject3).liveData;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new awe();
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4).setLiveInfo((awe)localObject2);
            ((b)localObject3).liveData.uDz = paramaqd.LCe;
            localObject1 = ((b)localObject3).liveData;
            localObject2 = paramaqd.LCe;
            if (localObject2 == null) {
              break label423;
            }
            l = ((FinderObject)localObject2).id;
            ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).hFK = l;
            localObject3 = ((b)localObject3).liveData;
            localObject1 = paramaqd.LCe;
            if (localObject1 != null)
            {
              localObject2 = ((FinderObject)localObject1).objectNonceId;
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).atS((String)localObject1);
            localObject1 = paramu;
            if (localObject1 == null) {
              break label429;
            }
            localObject2 = Boolean.TRUE;
            localObject3 = Boolean.FALSE;
            if (paramString != null) {
              break label435;
            }
            paramString = "";
          }
          for (;;)
          {
            ((kotlin.g.a.u)localObject1).invoke(localObject2, localObject3, "", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramaqd);
            AppMethodBeat.o(246000);
            return;
            localObject1 = null;
            break;
            l = 0L;
            break label305;
            AppMethodBeat.o(246000);
            return;
          }
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doDisableComment$1$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveBanComment$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "enable", "", "onSuccess", "plugin-finder_release"})
  public static final class e
    implements t.a
  {
    e(b paramb, boolean paramBoolean, String paramString, kotlin.g.a.m paramm) {}
    
    public final void mO(boolean paramBoolean)
    {
      AppMethodBeat.i(246001);
      Log.i(this.uhO.TAG, "doDisableComment success, enable:" + paramBoolean + " username:" + paramString);
      Object localObject = (Map)this.uhO.liveData.uDX;
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
        AppMethodBeat.o(246001);
        return;
      }
      AppMethodBeat.o(246001);
    }
    
    public final void t(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(246002);
      Log.i(this.uhO.TAG, "doDisableComment fail, enable:" + paramBoolean + " username:" + paramString + " errType:" + paramInt1 + " errCode:" + paramInt2);
      kotlin.g.a.m localm = paramm;
      if (localm != null)
      {
        localm.invoke(Boolean.FALSE, Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(246002);
        return;
      }
      AppMethodBeat.o(246002);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "respLiveId", "", "liveStatus", "", "resp", "", "kotlin.jvm.PlatformType", "onLiveStatusCallback"})
  static final class f
    implements aj.b
  {
    f(b paramb, kotlin.g.a.s params) {}
    
    public final void a(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(246003);
      Log.i(this.uhO.TAG, "getLiveInfo,liveData.liveId:" + this.uhO.liveData.liveInfo.liveId + ",respLiveId:" + paramLong + ",liveStatus:" + paramInt + ",resp:" + paramObject);
      if ((paramLong == this.uhO.liveData.liveInfo.liveId) && ((paramObject instanceof asq)))
      {
        awe localawe = ((asq)paramObject).liveInfo;
        int i;
        label140:
        int j;
        label162:
        int k;
        label184:
        int m;
        if (localawe != null)
        {
          paramInt = localawe.iqg;
          localawe = ((asq)paramObject).liveInfo;
          if (localawe == null) {
            break label276;
          }
          i = localawe.dvv;
          localawe = ((asq)paramObject).liveInfo;
          if (localawe == null) {
            break label282;
          }
          j = localawe.uBn;
          localawe = ((asq)paramObject).liveInfo;
          if (localawe == null) {
            break label288;
          }
          k = localawe.wBG;
          m = ((asq)paramObject).LBn;
          paramObject = ((asq)paramObject).liveInfo;
          if (paramObject == null) {
            break label294;
          }
        }
        label276:
        label282:
        label288:
        label294:
        for (paramLong = paramObject.LDN;; paramLong = 0L)
        {
          paramObject = params;
          if (paramObject == null) {
            break label299;
          }
          paramObject.a(Boolean.TRUE, Integer.valueOf(0), Integer.valueOf(0), "", new com.tencent.mm.plugin.finder.live.viewmodel.a(paramInt - i, j, k, m, paramLong));
          AppMethodBeat.o(246003);
          return;
          paramInt = 0;
          break;
          i = 0;
          break label140;
          j = 0;
          break label162;
          k = 0;
          break label184;
        }
        label299:
        AppMethodBeat.o(246003);
        return;
      }
      paramObject = params;
      if (paramObject != null)
      {
        paramObject.a(Boolean.FALSE, Integer.valueOf(0), Integer.valueOf(0), "", new com.tencent.mm.plugin.finder.live.viewmodel.a(0, 0, 0, 0, 31));
        AppMethodBeat.o(246003);
        return;
      }
      AppMethodBeat.o(246003);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, ayd, kotlin.x>
  {
    g(b paramb, kotlin.g.a.s params)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, ape, kotlin.x>
  {
    h(kotlin.g.a.s params)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetFinderLiveContact$1$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveGetContact$CallBack;", "onFinish", "", "success", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.finder.cgi.u.a
  {
    i(b paramb, int paramInt, String paramString, kotlin.g.a.m paramm) {}
    
    public final void a(boolean paramBoolean, avn paramavn)
    {
      boolean bool = true;
      AppMethodBeat.i(246006);
      Log.i(this.uhO.TAG, "doGetFinderLiveContact success:" + paramBoolean + " username:" + paramString);
      Object localObject;
      String str;
      if (paramBoolean)
      {
        localObject = this.uhO.liveData;
        if (localObject == null) {
          break label139;
        }
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDX;
        localObject = (Map)localObject;
        str = paramString;
        if ((paramavn == null) || (paramavn.LGh != 1)) {
          break label145;
        }
      }
      for (;;)
      {
        ((Map)localObject).put(str, Boolean.valueOf(bool));
        localObject = paramm;
        if (localObject == null) {
          break label150;
        }
        ((kotlin.g.a.m)localObject).invoke(Boolean.valueOf(paramBoolean), paramavn);
        AppMethodBeat.o(246006);
        return;
        label139:
        localObject = null;
        break;
        label145:
        bool = false;
      }
      label150:
      AppMethodBeat.o(246006);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetGiftList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListResponse;", "plugin-finder_release"})
  public static final class j
    implements f.a
  {
    j(kotlin.g.a.m paramm) {}
    
    public final void a(int paramInt1, int paramInt2, ata paramata)
    {
      AppMethodBeat.i(246007);
      kotlin.g.b.p.h(paramata, "resp");
      Log.i(this.uhO.TAG, "doGetGiftList errType:" + paramInt1 + ", errCode:" + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        o localo = o.ujN;
        o.b(paramata.LDs);
        localo = o.ujN;
        o.Jg(paramata.LDW);
        localo = o.ujN;
        o.Jh(paramata.LDX);
        paramata = paramm;
        if (paramata != null)
        {
          paramata.invoke(Boolean.TRUE, Integer.valueOf(paramInt2));
          AppMethodBeat.o(246007);
          return;
        }
        AppMethodBeat.o(246007);
        return;
      }
      paramata = paramm;
      if (paramata != null)
      {
        paramata.invoke(Boolean.FALSE, Integer.valueOf(paramInt2));
        AppMethodBeat.o(246007);
        return;
      }
      AppMethodBeat.o(246007);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetMemberList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "plugin-finder_release"})
  public static final class k
    implements y.a
  {
    k(r paramr) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, asu paramasu)
    {
      AppMethodBeat.i(246008);
      kotlin.g.b.p.h(paramasu, "resp");
      Object localObject;
      com.tencent.mm.plugin.finder.live.viewmodel.g localg;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uhO.liveData.uDn.clear();
        localObject = com.tencent.mm.plugin.finder.live.plugin.y.uoV;
        if (com.tencent.mm.plugin.finder.live.plugin.y.access$getDEBUG$cp())
        {
          localObject = com.tencent.mm.plugin.finder.utils.m.vVH;
          localObject = com.tencent.mm.plugin.finder.utils.m.dBR();
          if (localObject != null) {
            this.uhO.liveData.uDn.addAll((Collection)localObject);
          }
        }
        this.uhO.liveData.uDn.addAll((Collection)paramasu.LDL);
        this.uhO.liveData.uDp.clear();
        this.uhO.liveData.uDp.addAll((Collection)paramasu.LDM);
        this.uhO.liveData.liveInfo.uBn = paramasu.LDO;
        this.uhO.liveData.uDq = paramasu.LDO;
        this.uhO.liveData.uDr = paramasu.LDP;
        this.uhO.liveData.uDo = paramasu.LDQ;
        localObject = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (!com.tencent.mm.plugin.finder.utils.m.dBP())
        {
          localg = this.uhO.liveData;
          String str = localg.TAG;
          StringBuilder localStringBuilder = new StringBuilder("online member enableComment:");
          localObject = localg.uDo;
          if (localObject == null) {
            break label336;
          }
          localObject = Integer.valueOf(((avn)localObject).hFI);
          Log.i(str, localObject);
          localObject = localg.uDo;
          if (localObject != null)
          {
            if (((avn)localObject).hFI != 1) {
              break label342;
            }
            localg.uDC = true;
          }
        }
      }
      for (;;)
      {
        localObject = paramr;
        if (localObject == null) {
          break label359;
        }
        ((r)localObject).invoke(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, paramasu);
        AppMethodBeat.o(246008);
        return;
        label336:
        localObject = null;
        break;
        label342:
        if (((avn)localObject).hFI == 0) {
          localg.uDC = false;
        }
      }
      label359:
      AppMethodBeat.o(246008);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetProductList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingList$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "plugin-finder_release"})
  public static final class l
    implements q.a
  {
    l(kotlin.g.a.b paramb, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, awc paramawc)
    {
      AppMethodBeat.i(246009);
      kotlin.g.b.p.h(paramawc, "resp");
      long l = paramawc.liveId;
      Object localObject = this.uhO.liveData.liveInfo;
      if ((localObject == null) || (l != ((awe)localObject).liveId))
      {
        localObject = this.uhO.TAG;
        paramawc = new StringBuilder("invalid live resp,liveId:").append(paramawc.liveId).append(",current liveId:");
        paramString = this.uhO.liveData.liveInfo;
        if (paramString != null) {}
        for (paramString = Long.valueOf(paramString.liveId);; paramString = null)
        {
          Log.i((String)localObject, paramString.longValue());
          paramString = paramb1;
          if (paramString == null) {
            break;
          }
          paramString.invoke(Boolean.FALSE);
          AppMethodBeat.o(246009);
          return;
        }
        AppMethodBeat.o(246009);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uhO.liveData.uEj = true;
        paramString = paramawc.LGw;
        if (paramString != null)
        {
          localObject = this.uhO.liveData;
          kotlin.g.b.p.g(paramString, "it");
          ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).atV(paramString);
        }
        this.uhO.liveData.b(paramawc);
        paramString = paramb1;
        if (paramString != null)
        {
          paramString.invoke(Boolean.TRUE);
          AppMethodBeat.o(246009);
          return;
        }
        AppMethodBeat.o(246009);
        return;
      }
      paramawc = paramb1;
      if (paramawc != null) {
        paramawc.invoke(Boolean.FALSE);
      }
      if (i != 0)
      {
        paramawc = ae.vZW;
        localObject = ae.dEj();
        paramawc = paramString;
        if (paramString == null) {
          paramawc = "";
        }
        ae.a((String)localObject, paramInt2, paramInt1, paramawc, this.uhO.liveData);
      }
      AppMethodBeat.o(246009);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements r<Integer, Integer, String, ban, kotlin.x>
  {
    m(r paramr)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doJoinLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "plugin-finder_release"})
  public static final class n
    implements i.a
  {
    n(kotlin.g.a.u paramu, int paramInt) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final auf paramauf)
    {
      AppMethodBeat.i(246012);
      kotlin.g.b.p.h(paramauf, "resp");
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramauf, paramInt2, paramInt1, paramString));
      AppMethodBeat.o(246012);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(b.n paramn, auf paramauf, int paramInt1, int paramInt2, String paramString)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doLikeLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveResp;", "plugin-finder_release"})
  public static final class o
    implements j.a
  {
    public final void a(int paramInt1, int paramInt2, aun paramaun)
    {
      AppMethodBeat.i(246013);
      kotlin.g.b.p.h(paramaun, "resp");
      Log.i(this.uhO.TAG, "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2);
      Object localObject;
      StringBuilder localStringBuilder;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (com.tencent.mm.ac.d.cW(paramaun.LFs, 1)))
      {
        paramaun = this.uhO.uhN;
        localObject = MMApplicationContext.getContext();
        kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getResources().getString(2131760017);
        kotlin.g.b.p.g(localObject, "MMApplicationContext.get…er_live_lottery_attended)");
        paramaun.showCenterCustomizeToast((String)localObject, 2131690787);
        localObject = this.uhO.TAG;
        localStringBuilder = new StringBuilder("doLikeLive attended lottery success,lotteryId:");
        paramaun = this.uhO.liveData.uEa;
        if (paramaun == null) {
          break label206;
        }
        paramaun = paramaun.tWe;
        if (paramaun == null) {
          break label206;
        }
      }
      label206:
      for (paramaun = paramaun.id;; paramaun = null)
      {
        Log.i((String)localObject, paramaun);
        if (this.uhO.uhN.getLiveRole() == 0)
        {
          paramaun = com.tencent.mm.plugin.finder.report.live.m.vli;
          com.tencent.mm.plugin.finder.report.live.m.a(s.ay.vsL, "");
        }
        AppMethodBeat.o(246013);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doManualCloseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "plugin-finder_release"})
  public static final class p
    implements x.a
  {
    p(kotlin.g.a.s params) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, ayd paramayd)
    {
      AppMethodBeat.i(246014);
      kotlin.g.b.p.h(paramayd, "resp");
      Object localObject2;
      Boolean localBoolean;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i(this.uhO.TAG, "manual close live room failed");
        localObject2 = params;
        if (localObject2 != null)
        {
          localBoolean = Boolean.FALSE;
          if (paramString != null) {
            break label180;
          }
        }
      }
      label177:
      label180:
      for (Object localObject1 = "";; localObject1 = paramString)
      {
        ((kotlin.g.a.s)localObject2).a(localBoolean, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localObject1, paramayd);
        paramayd = ae.vZW;
        localObject1 = ae.dEh();
        paramayd = paramString;
        if (paramString == null) {
          paramayd = "";
        }
        ae.a((String)localObject1, paramInt2, paramInt1, paramayd, this.uhO.liveData);
        AppMethodBeat.o(246014);
        return;
        localObject1 = params;
        if (localObject1 != null)
        {
          localObject2 = Boolean.TRUE;
          if (paramString != null) {
            break label177;
          }
          paramString = "";
        }
        for (;;)
        {
          ((kotlin.g.a.s)localObject1).a(localObject2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, paramayd);
          AppMethodBeat.o(246014);
          return;
          AppMethodBeat.o(246014);
          return;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostComment$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder_release"})
  public static final class q
    implements l.a
  {
    q(l.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bap parambap)
    {
      AppMethodBeat.i(246015);
      kotlin.g.b.p.h(parambap, "resp");
      Object localObject = parama;
      if (localObject != null) {
        ((l.a)localObject).a(paramInt1, paramInt2, paramString, parambap);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (com.tencent.mm.ac.d.cW(parambap.LFs, 1))
        {
          paramString = this.uhO.uhN;
          parambap = MMApplicationContext.getContext();
          kotlin.g.b.p.g(parambap, "MMApplicationContext.getContext()");
          parambap = parambap.getResources().getString(2131760017);
          kotlin.g.b.p.g(parambap, "MMApplicationContext.get…er_live_lottery_attended)");
          paramString.showCenterCustomizeToast(parambap, 2131690787);
          parambap = this.uhO.TAG;
          localObject = new StringBuilder("doPostComment attended lottery success,lotteryId:");
          paramString = this.uhO.liveData.uEa;
          if (paramString != null)
          {
            paramString = paramString.tWe;
            if (paramString == null) {}
          }
          for (paramString = paramString.id;; paramString = null)
          {
            Log.i(parambap, paramString);
            if (this.uhO.uhN.getLiveRole() != 0) {
              break;
            }
            paramString = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.a(s.ay.vsL, "");
            AppMethodBeat.o(246015);
            return;
          }
        }
      }
      else
      {
        parambap = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.dCM()) {
          com.tencent.mm.ui.base.u.makeText(this.uhO.uhN.getContext(), (CharSequence)(paramInt2 + ':' + paramString), 0).show();
        }
      }
      AppMethodBeat.o(246015);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostGift$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "plugin-finder_release"})
  public static final class r
    implements v.a
  {
    r(int paramInt1, Context paramContext, String paramString1, af.a parama, String paramString2, int paramInt2, String paramString3) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, axc paramaxc)
    {
      AppMethodBeat.i(246018);
      kotlin.g.b.p.h(paramaxc, "resp");
      Log.i(this.uhO.TAG, "doPostGift errType:" + paramInt1 + ", errCode:" + paramInt2 + ",errMsg:" + paramString);
      paramString = af.waa;
      af.LZ(paramInt2);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = af.waa;
        af.dEu();
      }
      Object localObject = this.uhO;
      Context localContext = paramContext;
      String str = this.uhZ;
      paramString = paramaxc.LHF;
      if (paramString != null) {}
      for (paramString = paramString.toByteArray();; paramString = null)
      {
        com.tencent.mm.plugin.wallet.wecoin.a.e locale = (com.tencent.mm.plugin.wallet.wecoin.a.e)new a(this);
        Log.i(((b)localObject).TAG, "[WeCoin] consumeGift:".concat(String.valueOf(paramString)));
        localObject = (com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class);
        paramaxc = paramString;
        if (paramString == null) {
          paramaxc = new byte[0];
        }
        ((com.tencent.mm.plugin.wallet.wecoin.a.c)localObject).a(localContext, str, paramaxc, locale);
        AppMethodBeat.o(246018);
        return;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostGift$1$onCgiBack$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "msg", "", "onSuccess", "data", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.wallet.wecoin.a.e<Long>
    {
      public final void p(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(246017);
        Log.i(this.uif.uhO.TAG, "[WeCoin] consumeGift onFailed errorType:" + paramInt1 + ",errorCode:" + paramInt2 + ",msg:" + paramString);
        paramString = this.uif.uia;
        if (paramString != null) {
          paramString.a(false, paramInt2, af.a.a.uqJ, this.uif.uib, null, this.uif.uic, this.uif.uie);
        }
        paramString = af.waa;
        af.dEv();
        AppMethodBeat.o(246017);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getLotteryRecord$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class s
    implements o.a
  {
    s(o.a parama) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final avy paramavy)
    {
      AppMethodBeat.i(246020);
      kotlin.g.b.p.h(paramavy, "resp");
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramavy, paramInt1, paramInt2, paramString));
      AppMethodBeat.o(246020);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(b.s params, avy paramavy, int paramInt1, int paramInt2, String paramString)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getProductDetail$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailResponse;", "plugin-finder_release"})
  public static final class t
    implements p.a
  {
    public final void a(int paramInt1, int paramInt2, awa paramawa)
    {
      AppMethodBeat.i(246021);
      kotlin.g.b.p.h(paramawa, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        String str = paramawa.LGw;
        if (str != null)
        {
          com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.uhO.liveData;
          kotlin.g.b.p.g(str, "it");
          localg.atV(str);
        }
        paramawa = paramawa.LGx;
        if (paramawa != null)
        {
          this.uhO.liveData.b(paramawa);
          AppMethodBeat.o(246021);
          return;
        }
      }
      AppMethodBeat.o(246021);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getWeCoinBalance$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "msg", "", "onSuccess", "data", "plugin-finder_release"})
  public static final class u
    implements com.tencent.mm.plugin.wallet.wecoin.a.e<Long>
  {
    u(kotlin.g.a.b paramb) {}
    
    public final void p(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(246023);
      Log.i(this.uhO.TAG, "[WeCoin] getWeCoinBalance onFailed,errorType:" + paramInt1 + ",errorCode:" + paramInt2 + ",msg:" + paramString);
      paramString = paramb;
      if (paramString != null)
      {
        paramString.invoke(Long.valueOf(-1L));
        AppMethodBeat.o(246023);
        return;
      }
      AppMethodBeat.o(246023);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$initEngine$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "msg", "", "onSuccess", "data", "(Ljava/lang/Boolean;)V", "plugin-finder_release"})
  public static final class v
    implements com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean>
  {
    v(kotlin.g.a.b paramb) {}
    
    public final void p(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(246025);
      Log.i(this.uhO.TAG, "[WeCoin] initEngine onFailed");
      paramString = this.uik;
      if (paramString != null)
      {
        paramString.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        AppMethodBeat.o(246025);
        return;
      }
      AppMethodBeat.o(246025);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$putInBlackList$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class w
    implements ai<ayt>
  {
    w(kotlin.g.a.m paramm) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    x(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$showRechargeFoodsDialog$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "(Ljava/lang/Boolean;)V", "plugin-finder_release"})
  public static final class y
    implements com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean>
  {
    y(FragmentActivity paramFragmentActivity, kotlin.g.a.a parama) {}
    
    public final void p(int paramInt1, int paramInt2, String paramString) {}
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
    static final class a
      implements com.tencent.mm.plugin.wallet.wecoin.a.a
    {
      a(b.y paramy) {}
      
      public final void onClick()
      {
        AppMethodBeat.i(246028);
        this.uim.ihE.invoke();
        AppMethodBeat.o(246028);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.b
 * JD-Core Version:    0.7.0.1
 */