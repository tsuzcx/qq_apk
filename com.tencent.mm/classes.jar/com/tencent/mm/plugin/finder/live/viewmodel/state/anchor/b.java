package com.tencent.mm.plugin.finder.live.viewmodel.state.anchor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.cgi.t.a;
import com.tencent.mm.plugin.finder.live.component.aj.a;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.ap.a;
import com.tencent.mm.plugin.finder.live.model.ar;
import com.tencent.mm.plugin.finder.live.model.cgi.a.a;
import com.tencent.mm.plugin.finder.live.model.cgi.g.a;
import com.tencent.mm.plugin.finder.live.model.cgi.h.a;
import com.tencent.mm.plugin.finder.live.model.cgi.p.a;
import com.tencent.mm.plugin.finder.live.model.cgi.q.a;
import com.tencent.mm.plugin.finder.live.model.cgi.v.a;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ab;
import com.tencent.mm.plugin.finder.live.plugin.ac;
import com.tencent.mm.plugin.finder.live.plugin.ak;
import com.tencent.mm.plugin.finder.live.plugin.av;
import com.tencent.mm.plugin.finder.live.plugin.aw;
import com.tencent.mm.plugin.finder.live.plugin.ay;
import com.tencent.mm.plugin.finder.live.plugin.az;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.be;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.plugin.bg;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.bp;
import com.tencent.mm.plugin.finder.live.plugin.bq;
import com.tencent.mm.plugin.finder.live.plugin.br;
import com.tencent.mm.plugin.finder.live.plugin.bs;
import com.tencent.mm.plugin.finder.live.plugin.bt;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.plugin.cb;
import com.tencent.mm.plugin.finder.live.plugin.cd;
import com.tencent.mm.plugin.finder.live.plugin.cf;
import com.tencent.mm.plugin.finder.live.plugin.k;
import com.tencent.mm.plugin.finder.live.plugin.l;
import com.tencent.mm.plugin.finder.live.plugin.n;
import com.tencent.mm.plugin.finder.live.plugin.o;
import com.tencent.mm.plugin.finder.live.plugin.p;
import com.tencent.mm.plugin.finder.live.plugin.t;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.plugin.finder.live.plugin.w;
import com.tencent.mm.plugin.finder.live.plugin.x;
import com.tencent.mm.plugin.finder.live.report.q.al;
import com.tencent.mm.plugin.finder.live.report.q.ap;
import com.tencent.mm.plugin.finder.live.report.q.az;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.f;
import com.tencent.mm.plugin.finder.live.report.q.i;
import com.tencent.mm.plugin.finder.live.report.q.z;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.utils.bb;
import com.tencent.mm.plugin.finder.utils.bb.c;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveAnchorStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "allowanceGiftBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAllowanceGiftBubblePlugin;", "allowanceGiftCardPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAllowanceGiftCardPlugin;", "anchorDescEditPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorDescEditPlugin;", "anchorFansClubPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorFansClubPlugin;", "anchorFastCommentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorFastCommentPlugin;", "anchorMoreOptionPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMoreOptionPanelPlugin;", "anchorMusicGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "anchorMusicPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicPlugin;", "anchorMusicVolumePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;", "anchorPausePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin;", "anchorPauseRecoveryPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPauseRecoveryPlugin;", "anchorPromotePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPromotionPlugin;", "anchorSearchMusicPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorSearchMusicPlugin;", "audioModePreviewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAudioModePreviewPlugin;", "battleInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBattleInfoPlugin;", "bottomOptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin;", "bubbleContainer", "Landroid/widget/LinearLayout;", "cameraOptPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin;", "closePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin;", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "commonInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "confettiPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "decorationPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveDecorationPlugin;", "exceptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "getExceptionPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "setExceptionPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;)V", "giftPlayPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "giftQueuePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin;", "likePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin;", "linkApplyListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "linkStatePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin;", "lotteryBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "lotteryCardPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin;", "luckyMoneyPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin;", "memberListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin;", "micAudioPreviewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicAudioPreviewPlugin;", "micDecoratePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin;", "moreActionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;", "optionPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin;", "originCommentBottomMargin", "", "previewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin;", "profilePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewMemberProfilePlugin;", "promoteBannerPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBannerPlugin;", "promottingBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBubblePlugin;", "randomMatchLinkStatePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveRandomMatchLinkMicStatePlugin;", "readyPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin;", "shadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "shoppingListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "switchModePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveSwitchModePlugin;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "titleInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "topCommentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;", "adjustCameraPreviewByScreen", "", "cancelRandomMatchLinkMic", "endAction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "checkDecorationInfo", "checkFinderObject", "checkLinkMicStateWhenJoin", "micInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMicInfo;", "checkMiniWindow", "checkNetworkType", "createLive", "handleAcceptBattleResp", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptBattleResponse;", "applyContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "handleAcceptMicPkResp", "Lcom/tencent/mm/protocal/protobuf/FinderAcceptLiveMicResponse;", "fromRandomMatch", "handleApplyBattleResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyBattleResponse;", "handleApplyMicPkResp", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "isRandomMatch", "handleCheerIconsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "handleCloseBattleResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseBattleResponse;", "contact", "handleJoinLiveWxshopResponse", "response", "handleJoinResp", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "handleLiveErr", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "errorPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "hideBottomAraePlugin", "initPlugins", "initShoppingPlugins", "init", "joinLive", "joinLiveByMiniWin", "miniWindow", "notifyAnchorVolume", "userVolumeList", "", "Lcom/tencent/mm/live/core/core/model/UserVolumeInfo;", "notifyMicUserVolume", "notifyUIAfterCloseLinkPk", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAcceptMicPkTimeout", "onAcceptMicTimeout", "micId", "onApplyBattleTimeout", "onApplyMicPkTimeout", "onBattleApply", "onBattleClose", "onBattleDismiss", "onBattleEnd", "onBattleStart", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "onCloseLinkPkSuccess", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onLiveEnd", "onLiveEndWithAnimation", "onLiveEventCallback", "errorCode", "param", "Landroid/os/Bundle;", "onLiveMsgChanged", "onLiveMsgSlowChanged", "onLivePrepare", "onLiveStart", "onRandomMatchTimeout", "onRandomMicAccept", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgApplyPkInfo;", "onRandomMicApply", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgNotifyApplyRandomMicInfo;", "onRelease", "onStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "onStop", "postCloseLinkMsg", "linkMicUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "postCloseLinkPkMsg", "prepareShopping", "report", "reportLaunchLiveSuccess", "restoreLinkMicUI", "startLive", "byMiniWin", "startLiveVideo", "fromMiniWindow", "startTimer", "stopLiveVideo", "stopTimer", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.a
{
  public t CWq;
  public com.tencent.mm.plugin.finder.live.plugin.ah DcS;
  public l EiN;
  public com.tencent.mm.plugin.finder.live.plugin.y EiO;
  public com.tencent.mm.live.b.y EiP;
  public cd EiQ;
  public com.tencent.mm.plugin.finder.live.plugin.aj EiR;
  public bt EiS;
  public com.tencent.mm.plugin.finder.live.plugin.j EiT;
  public bd EiU;
  public bk EiV;
  public az EiW;
  public bg EiX;
  public bq EiY;
  public br EiZ;
  public ac EjA;
  public bp EjB;
  public k EjC;
  public n EjD;
  public com.tencent.mm.plugin.finder.live.plugin.s EjE;
  private com.tencent.mm.plugin.finder.live.plugin.m EjF;
  public ak EjG;
  private int EjH;
  private LinearLayout EjI;
  public bz Eja;
  public cf Ejb;
  public o Ejc;
  public com.tencent.mm.plugin.finder.live.plugin.i Ejd;
  private ay Eje;
  public com.tencent.mm.plugin.finder.live.plugin.ba Ejf;
  public com.tencent.mm.plugin.finder.live.plugin.r Ejg;
  public com.tencent.mm.plugin.finder.live.plugin.d Ejh;
  public com.tencent.mm.plugin.finder.live.plugin.e Eji;
  public av Ejj;
  public aw Ejk;
  public com.tencent.mm.plugin.finder.live.plugin.q Ejl;
  public bs Ejm;
  public p Ejn;
  public bf Ejo;
  public com.tencent.mm.plugin.finder.live.plugin.h Ejp;
  public com.tencent.mm.plugin.finder.live.plugin.bc Ejq;
  public be Ejr;
  public cb Ejs;
  public ab Ejt;
  public com.tencent.mm.plugin.finder.live.plugin.u Eju;
  public com.tencent.mm.plugin.finder.live.plugin.z Ejv;
  public com.tencent.mm.plugin.finder.live.plugin.aa Ejw;
  public v Ejx;
  public w Ejy;
  public x Ejz;
  public final String TAG;
  public MTimerHandler nmZ;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(357350);
    this.TAG = "FinderLiveAnchorStartUIC";
    this.nmZ = new MTimerHandler("LiveCommonInfoPlugin::Timer", new b..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(357350);
  }
  
  private final void a(int paramInt1, int paramInt2, String paramString, atc paramatc, boolean paramBoolean)
  {
    Object localObject1 = null;
    AppMethodBeat.i(357372);
    Object localObject2 = this.Ejl;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.q)localObject2).epp();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i(this.TAG, "[LinkMicPk] accept anchor link mic pk success");
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
      if (localObject2 != null)
      {
        if (this.ngB == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
          AppMethodBeat.o(357372);
          throw paramString;
        }
        com.tencent.mm.live.core.core.a.b.r(String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXz), ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXL, "");
        if (this.ngB == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
          AppMethodBeat.o(357372);
          throw paramString;
        }
        com.tencent.mm.live.core.core.a.b.d(String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXz), String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyG()), "", ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXL);
        com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().FT(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).sessionId);
        paramString = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXL;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        if (com.tencent.mm.plugin.finder.live.utils.a.a(paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXz, true, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).sessionId))
        {
          paramString = this.ngB;
          if (paramString != null) {
            paramString.bfh();
          }
        }
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efu.clear();
      paramString = this.Ejp;
      if (paramString != null) {
        paramString.eoT();
      }
      paramString = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      com.tencent.mm.plugin.finder.live.model.aj.elF();
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.ap.DyW;
      paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
      if (paramString == null) {}
      for (paramString = null;; paramString = paramString.username)
      {
        ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.ap)localObject2, paramString, q.az.DAn.type, q.al.Dyx.type);
        if (!paramBoolean) {
          break;
        }
        com.tencent.mm.plugin.finder.live.report.j.Dob.bw(q.i.DsQ.type, paramatc.session_id);
        AppMethodBeat.o(357372);
        return;
      }
    }
    paramatc = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
    com.tencent.mm.plugin.finder.live.model.mic.b.enh();
    Log.i(this.TAG, "[LinkMicPk] accept anchor link mic pk fail");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv = null;
    com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().FT(null);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy = 0;
    paramatc = (CharSequence)paramString;
    int i;
    if ((paramatc == null) || (paramatc.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label541;
      }
      paramString = (String)localObject1;
    }
    label541:
    for (;;)
    {
      if (paramInt2 != -200074) {
        break label544;
      }
      localObject1 = (Context)this.CCa;
      paramatc = paramString;
      if (paramString == null)
      {
        paramatc = this.CCa.getResources().getString(p.h.Cli);
        kotlin.g.b.s.s(paramatc, "context.resources.getStr…k_accept_pk_tip_canceled)");
      }
      com.tencent.mm.ui.base.aa.makeText((Context)localObject1, (CharSequence)paramatc, 0).show();
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.ap.DyZ, this.CCa.getResources().getString(p.h.Cli), -1, -1);
      AppMethodBeat.o(357372);
      return;
      i = 0;
      break;
    }
    label544:
    localObject1 = (Context)this.CCa;
    paramatc = paramString;
    if (paramString == null)
    {
      paramatc = this.CCa.getResources().getString(p.h.CnI);
      kotlin.g.b.s.s(paramatc, "context.resources.getStr…ring.finder_live_mic_err)");
    }
    com.tencent.mm.ui.base.aa.makeText((Context)localObject1, (CharSequence)paramatc, 0).show();
    paramString = com.tencent.mm.plugin.finder.live.model.aa.CGv;
    paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    long l;
    if (paramString == null) {
      l = 0L;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.live.model.aa.q(paramInt2, paramInt1, l);
      AppMethodBeat.o(357372);
      return;
      paramString = paramString.liveInfo;
      if (paramString == null) {
        l = 0L;
      } else {
        l = paramString.liveId;
      }
    }
  }
  
  private final void a(int paramInt1, int paramInt2, String paramString, atn paramatn, bgh parambgh, boolean paramBoolean)
  {
    AppMethodBeat.i(357389);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("[LinkMicPk] apply anchor link mic pk success. toContact:[");
      paramString = parambgh.contact;
      com.tencent.mm.plugin.finder.live.viewmodel.data.business.j localj;
      if (paramString == null)
      {
        paramString = null;
        Log.i((String)localObject1, paramString + ']');
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        localObject1 = paramatn.session_id;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).ayq(paramString);
        localj = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        paramString = parambgh.contact;
        if (paramString != null) {
          break label219;
        }
        paramString = null;
        label124:
        localObject1 = parambgh.contact;
        if (localObject1 != null) {
          break label227;
        }
        localObject1 = null;
        label139:
        localObject2 = parambgh.contact;
        if (localObject2 != null) {
          break label237;
        }
      }
      label219:
      label227:
      label237:
      for (localObject2 = null;; localObject2 = ((FinderContact)localObject2).nickname)
      {
        localj.Efv = new com.tencent.mm.plugin.finder.live.viewmodel.data.h("", paramString, (String)localObject1, (String)localObject2, 2, paramatn.session_id, null, true, 0, null, null, 0, 0, false, null, 0L, parambgh, paramBoolean, 654336);
        paramString = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
        com.tencent.mm.plugin.finder.live.model.mic.b.enb();
        AppMethodBeat.o(357389);
        return;
        paramString = paramString.nickname;
        break;
        paramString = paramString.headUrl;
        break label124;
        localObject1 = ((FinderContact)localObject1).username;
        break label139;
      }
    }
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("[LinkMicPk] apply anchor link mic pk fail. toContact:[");
    paramatn = parambgh.contact;
    label280:
    int i;
    if (paramatn == null)
    {
      paramatn = null;
      Log.i((String)localObject1, paramatn + ']');
      paramatn = this.Ejl;
      if (paramatn != null) {
        paramatn.epp();
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy = 0;
      paramatn = (CharSequence)paramString;
      if ((paramatn != null) && (paramatn.length() != 0)) {
        break label495;
      }
      i = 1;
      label354:
      if (i == 0) {
        break label501;
      }
      paramString = null;
    }
    label495:
    label501:
    for (;;)
    {
      switch (paramInt2)
      {
      case -200074: 
      default: 
        parambgh = (Context)this.CCa;
        paramatn = paramString;
        if (paramString == null)
        {
          paramatn = this.CCa.getResources().getString(p.h.CnI);
          kotlin.g.b.s.s(paramatn, "context.resources.getStr…ring.finder_live_mic_err)");
        }
        com.tencent.mm.ui.base.aa.makeText(parambgh, (CharSequence)paramatn, 0).show();
        paramString = com.tencent.mm.plugin.finder.live.model.aa.CGv;
        com.tencent.mm.plugin.finder.live.model.aa.p(paramInt2, paramInt1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
        AppMethodBeat.o(357389);
        return;
        paramatn = paramatn.nickname;
        break label280;
        i = 0;
        break label354;
      }
    }
    parambgh = (Context)this.CCa;
    paramatn = paramString;
    if (paramString == null)
    {
      paramatn = this.CCa.getResources().getString(p.h.Clm);
      kotlin.g.b.s.s(paramatn, "context.resources.getStr…e_link_apply_pk_tip_self)");
    }
    com.tencent.mm.ui.base.aa.makeText(parambgh, (CharSequence)paramatn, 0).show();
    com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.ap.DyZ, this.CCa.getResources().getString(p.h.Clm), -1, -1);
    AppMethodBeat.o(357389);
    return;
    parambgh = (Context)this.CCa;
    paramatn = paramString;
    if (paramString == null)
    {
      paramatn = this.CCa.getResources().getString(p.h.Cln);
      kotlin.g.b.s.s(paramatn, "context.resources.getStr…ink_apply_pk_tip_version)");
    }
    com.tencent.mm.ui.base.aa.makeText(parambgh, (CharSequence)paramatn, 0).show();
    com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.ap.DyZ, this.CCa.getResources().getString(p.h.Cln), -1, -1);
    AppMethodBeat.o(357389);
    return;
    parambgh = (Context)this.CCa;
    paramatn = paramString;
    if (paramString == null)
    {
      paramatn = this.CCa.getResources().getString(p.h.Cll);
      kotlin.g.b.s.s(paramatn, "context.resources.getStr…ink_apply_pk_tip_disable)");
    }
    com.tencent.mm.ui.base.aa.makeText(parambgh, (CharSequence)paramatn, 0).show();
    com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.ap.DyZ, this.CCa.getResources().getString(p.h.Cll), -1, -1);
    AppMethodBeat.o(357389);
    return;
    parambgh = (Context)this.CCa;
    paramatn = paramString;
    if (paramString == null)
    {
      paramatn = this.CCa.getResources().getString(p.h.Clj);
      kotlin.g.b.s.s(paramatn, "context.resources.getStr…e_link_apply_pk_tip_busy)");
    }
    com.tencent.mm.ui.base.aa.makeText(parambgh, (CharSequence)paramatn, 0).show();
    com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.ap.DyZ, this.CCa.getResources().getString(p.h.Clj), -1, -1);
    AppMethodBeat.o(357389);
    return;
    parambgh = (Context)this.CCa;
    paramatn = paramString;
    if (paramString == null)
    {
      paramatn = this.CCa.getResources().getString(p.h.Clk);
      kotlin.g.b.s.s(paramatn, "context.resources.getStr…link_apply_pk_tip_closed)");
    }
    com.tencent.mm.ui.base.aa.makeText(parambgh, (CharSequence)paramatn, 0).show();
    com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.ap.DyZ, this.CCa.getResources().getString(p.h.Clk), -1, -1);
    AppMethodBeat.o(357389);
  }
  
  private static final void a(Bundle paramBundle, b paramb, com.tencent.mm.plugin.finder.live.plugin.ah paramah)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(357490);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramah, "$it");
    if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
    {
      if (i == 0) {
        break label185;
      }
      paramBundle = paramb.Eje;
      if (paramBundle != null) {
        break label95;
      }
      paramBundle = null;
    }
    for (;;)
    {
      if (paramBundle == null)
      {
        paramBundle = paramah.mJe.getLayoutParams();
        if (paramBundle == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(357490);
          throw paramBundle;
          i = 0;
          break;
          label95:
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
      AppMethodBeat.o(357490);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    paramBundle.addRule(12);
    paramBundle.removeRule(2);
    AppMethodBeat.o(357490);
    return;
    label185:
    paramBundle = paramb.Eje;
    if (paramBundle != null) {
      paramBundle.DcS = null;
    }
    paramBundle = paramah.mJe.getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(357490);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    paramBundle.removeRule(12);
    LinearLayout localLinearLayout = paramb.EjI;
    if (localLinearLayout == null) {}
    for (i = j;; i = localLinearLayout.getId())
    {
      paramBundle.addRule(2, i);
      paramBundle = paramah.mJe.getLayoutParams();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(357490);
      throw paramBundle;
    }
    ((ViewGroup.MarginLayoutParams)paramBundle).bottomMargin = paramb.EjH;
    paramah.mJe.requestLayout();
    AppMethodBeat.o(357490);
  }
  
  private final void bji()
  {
    AppMethodBeat.i(357451);
    Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    localObject = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
    if (localObject != null) {
      ((ap)localObject).a((kotlin.g.a.u)new b.f(this));
    }
    AppMethodBeat.o(357451);
  }
  
  private static final boolean c(b paramb)
  {
    AppMethodBeat.i(357466);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject1 = paramb.EiR;
    if ((localObject1 != null) && (((com.tencent.mm.live.b.a)localObject1).mJe.getVisibility() == 0))
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = paramb.EiR;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject1).OX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.startTime);
        }
        localObject1 = paramb.EiR;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject1).eqb();
        }
        localObject1 = new LinkedList();
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eyj()) {
          break label327;
        }
        ((LinkedList)localObject1).add(new kotlin.r(Integer.valueOf(1), null));
        label121:
        Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if ((com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))) || ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edv) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyr()))) {
          ((LinkedList)localObject1).add(new kotlin.r(Integer.valueOf(4), null));
        }
        ((LinkedList)localObject1).add(new kotlin.r(Integer.valueOf(3), null));
        localObject2 = paramb.EiR;
        if (localObject2 != null) {
          com.tencent.mm.plugin.finder.live.plugin.aj.a((com.tencent.mm.plugin.finder.live.plugin.aj)localObject2, (List)localObject1, true);
        }
      }
      localObject1 = paramb.Ejc;
      if ((localObject1 == null) || (((com.tencent.mm.live.b.a)localObject1).mJe.getVisibility() != 0)) {
        break label347;
      }
      i = 1;
      label246:
      if (i != 0)
      {
        localObject1 = paramb.Ejc;
        if (localObject1 != null) {
          ((o)localObject1).oo(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcF);
        }
      }
      localObject1 = paramb.Ejy;
      if ((localObject1 == null) || (((com.tencent.mm.live.b.a)localObject1).mJe.getVisibility() != 0)) {
        break label352;
      }
    }
    label327:
    label347:
    label352:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramb = paramb.Ejy;
        if (paramb != null) {
          paramb.epu();
        }
      }
      AppMethodBeat.o(357466);
      return true;
      i = 0;
      break;
      ((LinkedList)localObject1).add(new kotlin.r(Integer.valueOf(2), null));
      break label121;
      i = 0;
      break label246;
    }
  }
  
  private static final void d(b paramb)
  {
    AppMethodBeat.i(357477);
    kotlin.g.b.s.u(paramb, "this$0");
    Log.i(paramb.TAG, "restoreLinkMicUI curLinkMicUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + " liveData.business(LiveCommonSlice::class.java).audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eza())
    {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy == 5)
      {
        paramb = paramb.Ejm;
        if (paramb != null)
        {
          bs.a(paramb);
          AppMethodBeat.o(357477);
        }
      }
      else
      {
        paramb = paramb.Ejl;
        if (paramb != null)
        {
          paramb.epo();
          AppMethodBeat.o(357477);
        }
      }
    }
    else
    {
      Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
      int i;
      Object localObject2;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).EbD == true))
      {
        i = 1;
        if (i != 0)
        {
          localObject2 = paramb.ngB;
          if (localObject2 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
            if (localObject1 != null) {
              break label429;
            }
            localObject1 = null;
            label227:
            ((com.tencent.mm.live.core.core.a.b)localObject2).FQ((String)localObject1);
          }
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM) {
            break label445;
          }
          localObject1 = paramb.CCb;
          if (localObject1 != null)
          {
            localObject2 = (com.tencent.mm.plugin.finder.live.view.a)localObject1;
            localObject1 = paramb.ngB;
            if (localObject1 != null) {
              break label437;
            }
            localObject1 = null;
            label273:
            com.tencent.mm.plugin.finder.live.view.a.notifyRoomPKMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)localObject2, (JSONObject)localObject1, false, null, 6, null);
          }
        }
        label284:
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
        kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        if (((Collection)localObject1).isEmpty()) {
          break label467;
        }
        i = 1;
      }
      label429:
      label437:
      label445:
      for (;;)
      {
        label319:
        if (i != 0)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
          kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
          localObject1 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)localObject1).next();
              Object localObject3 = paramb.EiO;
              if (localObject3 != null) {
                ((com.tencent.mm.plugin.finder.live.plugin.y)localObject3).awR(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXL);
              }
              if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXM == 2)
              {
                localObject3 = paramb.ngB;
                if (localObject3 != null)
                {
                  ((com.tencent.mm.live.core.core.a.b)localObject3).FQ(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXL);
                  continue;
                  i = 0;
                  break;
                  localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).mXL;
                  break label227;
                  localObject1 = ((com.tencent.mm.live.core.core.a.b)localObject1).bfi();
                  break label273;
                  localObject1 = paramb.CCb;
                  if (localObject1 == null) {
                    break label284;
                  }
                  com.tencent.mm.plugin.finder.live.view.a.notifyPKMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)localObject1, false, 1, null);
                  break label284;
                  label467:
                  i = 0;
                  break label319;
                }
              }
            }
          }
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
          {
            localObject1 = paramb.CCb;
            if (localObject1 != null)
            {
              localObject1 = (com.tencent.mm.plugin.finder.live.view.a)localObject1;
              paramb = paramb.ngB;
              if (paramb == null) {}
              for (paramb = null;; paramb = paramb.bfi())
              {
                com.tencent.mm.plugin.finder.live.view.a.notifyRoomPKMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)localObject1, paramb, false, null, 6, null);
                AppMethodBeat.o(357477);
                return;
              }
            }
          }
          else
          {
            paramb = paramb.CCb;
            if (paramb != null) {
              com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramb, false, 1, null);
            }
          }
        }
      }
    }
    AppMethodBeat.o(357477);
  }
  
  private static final void e(b paramb)
  {
    AppMethodBeat.i(357480);
    kotlin.g.b.s.u(paramb, "this$0");
    paramb.epz();
    AppMethodBeat.o(357480);
  }
  
  private l ezq()
  {
    return this.EiN;
  }
  
  private final void ezr()
  {
    AppMethodBeat.i(357401);
    ap localap;
    MMActivity localMMActivity;
    long l1;
    long l2;
    String str;
    byte[] arrayOfByte;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).CEZ)
    {
      localObject = this.Ejp;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.h)localObject).eoQ();
      }
      localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localap = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (localap != null)
      {
        localMMActivity = (MMActivity)this.CCa;
        l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
        l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
        str = com.tencent.mm.model.z.bAW();
        kotlin.g.b.s.s(str, "getMyFinderUsername()");
        arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject != null) {
          break label177;
        }
      }
    }
    label177:
    for (Object localObject = null;; localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).EeF)
    {
      ap.a.a(localap, localMMActivity, l1, l2, str, arrayOfByte, null, (String)localObject, (kotlin.g.a.b)new ak(this), 64);
      AppMethodBeat.o(357401);
      return;
    }
  }
  
  private final void ezv()
  {
    AppMethodBeat.i(357432);
    Object localObject = new Bundle();
    com.tencent.mm.plugin.finder.live.view.router.a locala = this.CCb;
    boolean bool;
    if (locala == null)
    {
      bool = false;
      ((Bundle)localObject).putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", bool);
      locala = this.CCb;
      if ((locala == null) || (locala.isSwipeBack() != true)) {
        break label187;
      }
      i = 1;
      label57:
      if (i == 0) {
        break label192;
      }
    }
    label187:
    label192:
    for (int i = 1;; i = 3)
    {
      ((Bundle)localObject).putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", i);
      ((Bundle)localObject).putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
      if (com.tencent.mm.compatible.e.b.dh((Context)this.CCa)) {
        break label197;
      }
      Log.e(this.TAG, "showVideoTalking, permission denied");
      localObject = this.CCb;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.a)localObject).setMiniWinPermission(true);
      }
      localObject = this.CCb;
      if (localObject != null) {
        com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject, com.tencent.mm.live.b.b.c.ncz);
      }
      RequestFloatWindowPermissionDialog.a((Context)this.CCa, this.CCa.getString(p.h.live_room_mini_view_fail), (RequestFloatWindowPermissionDialog.a)new l(this), false, com.tencent.mm.bq.a.aQB());
      AppMethodBeat.o(357432);
      return;
      bool = locala.needRemoveActivity();
      break;
      i = 0;
      break label57;
    }
    label197:
    locala = this.CCb;
    if (locala != null) {
      locala.setMiniWinPermission(false);
    }
    locala = this.CCb;
    if (locala != null) {
      locala.statusChange(com.tencent.mm.live.b.b.c.ncx, (Bundle)localObject);
    }
    report();
    AppMethodBeat.o(357432);
  }
  
  private static final void f(b paramb)
  {
    AppMethodBeat.i(357496);
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
    AppMethodBeat.o(357496);
  }
  
  public static void onAcceptLiveMic(com.tencent.mm.live.model.a parama)
  {
    AppMethodBeat.i(357456);
    kotlin.g.b.s.u(parama, "info");
    if (parama.mXF) {
      com.tencent.mm.plugin.finder.live.report.j.Dob.bw(q.i.DsQ.type, parama.mXx);
    }
    AppMethodBeat.o(357456);
  }
  
  private static void report()
  {
    AppMethodBeat.i(357447);
    Object localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
    if (com.tencent.mm.plugin.finder.live.report.j.Doc.Dqv)
    {
      localObject = String.valueOf(q.z.DxA.type);
      com.tencent.mm.plugin.finder.live.report.j localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.Doc.Dqv = false;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Dri, (String)localObject);
      AppMethodBeat.o(357447);
      return;
      localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
      if (!com.tencent.mm.plugin.finder.live.report.j.Doc.DpE)
      {
        localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
        if (!com.tencent.mm.plugin.finder.live.report.j.Doc.DpF) {}
      }
      else
      {
        localObject = String.valueOf(q.f.Dsk.action);
        continue;
      }
      if (com.tencent.mm.plugin.expt.hellhound.a.zAJ) {
        localObject = String.valueOf(q.z.DxB.type);
      } else {
        localObject = String.valueOf(q.z.Dxz.type);
      }
    }
  }
  
  private final void st(boolean paramBoolean)
  {
    AppMethodBeat.i(357361);
    Log.i(this.TAG, "initShoppingPlugins,user:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC + ",bind shop:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).CEZ + ", init:" + paramBoolean);
    com.tencent.mm.plugin.finder.live.view.router.a locala = this.CCb;
    if ((locala != null) && (this.Ejp != null) && (paramBoolean))
    {
      View localView = locala.findViewById(p.e.BSz);
      kotlin.g.b.s.s(localView, "router.findViewById(R.id…_live_shopping_list_root)");
      this.Eja = new bz((ViewGroup)localView, (com.tencent.mm.live.b.b)locala);
    }
    AppMethodBeat.o(357361);
  }
  
  /* Error */
  public final void a(com.tencent.mm.live.b.b.c arg1, final Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 2183
    //   3: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: astore 12
    //   9: aload_1
    //   10: astore_2
    //   11: aload_2
    //   12: ldc_w 2184
    //   15: invokestatic 478	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: getstatic 2188	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$a:$EnumSwitchMapping$0	[I
    //   21: aload_2
    //   22: invokevirtual 2191	com/tencent/mm/live/b/b$c:ordinal	()I
    //   25: iaload
    //   26: tableswitch	default:+138 -> 164, 1:+145->171, 2:+217->243, 3:+410->436, 4:+435->461, 5:+641->667, 6:+1327->1353, 7:+1474->1500, 8:+1971->1997, 9:+2009->2035, 10:+2112->2138, 11:+2158->2184, 12:+2205->2231, 13:+2586->2612, 14:+2998->3024, 15:+3039->3065, 16:+3080->3106, 17:+3104->3130, 18:+3414->3440, 19:+3438->3464, 20:+3752->3778, 21:+4255->4281, 22:+4443->4469, 23:+4488->4514, 24:+4580->4606, 25:+4808->4834, 26:+5155->5181, 27:+5517->5543, 28:+5672->5698, 29:+5672->5698, 30:+6595->6621, 31:+6783->6809
    //   165: iconst_5
    //   166: i2d
    //   167: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: aload_0
    //   172: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   175: astore_1
    //   176: aload_1
    //   177: ifnull +61 -> 238
    //   180: aload_1
    //   181: getfield 2195	com/tencent/mm/live/core/core/trtc/a:mRB	Lcom/tencent/mm/live/core/core/model/i;
    //   184: astore_1
    //   185: aload_1
    //   186: ifnull +52 -> 238
    //   189: aload_1
    //   190: getfield 2200	com/tencent/mm/live/core/core/model/i:mNQ	Z
    //   193: iconst_1
    //   194: if_icmpne +44 -> 238
    //   197: iconst_1
    //   198: istore_3
    //   199: iload_3
    //   200: ifeq +20 -> 220
    //   203: aload_0
    //   204: getfield 1464	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiO	Lcom/tencent/mm/plugin/finder/live/plugin/y;
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +11 -> 220
    //   212: aload_1
    //   213: invokevirtual 2203	com/tencent/mm/plugin/finder/live/plugin/y:epA	()V
    //   216: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   219: astore_1
    //   220: getstatic 2209	com/tencent/mm/plugin/finder/live/util/m:DJb	Lcom/tencent/mm/plugin/finder/live/util/m;
    //   223: astore_1
    //   224: aload_0
    //   225: getfield 1543	com/tencent/mm/plugin/finder/live/component/statecomponent/e:buContext	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   228: invokestatic 2212	com/tencent/mm/plugin/finder/live/util/m:l	(Lcom/tencent/mm/plugin/finder/live/model/context/a;)V
    //   231: ldc_w 2183
    //   234: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: return
    //   238: iconst_0
    //   239: istore_3
    //   240: goto -41 -> 199
    //   243: aload 12
    //   245: ifnonnull +40 -> 285
    //   248: aconst_null
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   254: ldc_w 2214
    //   257: aload_1
    //   258: invokestatic 1262	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   261: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_1
    //   265: getstatic 2220	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   268: invokestatic 2223	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   271: ifeq +30 -> 301
    //   274: aload_0
    //   275: invokespecial 2225	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:bji	()V
    //   278: ldc_w 2183
    //   281: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: return
    //   285: aload 12
    //   287: ldc_w 2227
    //   290: iconst_0
    //   291: invokevirtual 2230	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   294: invokestatic 2233	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   297: astore_1
    //   298: goto -48 -> 250
    //   301: aload 12
    //   303: ifnonnull +121 -> 424
    //   306: aconst_null
    //   307: astore_1
    //   308: aload_1
    //   309: ifnull +108 -> 417
    //   312: aload_0
    //   313: ldc_w 740
    //   316: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   319: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   322: astore_2
    //   323: new 2235	com/tencent/mm/protocal/protobuf/FinderObjectDesc
    //   326: dup
    //   327: invokespecial 2236	com/tencent/mm/protocal/protobuf/FinderObjectDesc:<init>	()V
    //   330: astore 12
    //   332: aload 12
    //   334: aload_1
    //   335: invokevirtual 2240	com/tencent/mm/protocal/protobuf/FinderObjectDesc:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   338: pop
    //   339: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   342: astore_1
    //   343: aload_2
    //   344: aload 12
    //   346: putfield 2244	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:EeY	Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;
    //   349: getstatic 1507	com/tencent/mm/plugin/finder/utils/ba:Gjt	Lcom/tencent/mm/plugin/finder/utils/ba;
    //   352: astore_1
    //   353: getstatic 1513	com/tencent/mm/plugin/finder/utils/bb:GjM	Lcom/tencent/mm/plugin/finder/utils/bb$a;
    //   356: astore_2
    //   357: aload_1
    //   358: invokestatic 2247	com/tencent/mm/plugin/finder/utils/bb:fhs	()Lcom/tencent/mm/plugin/finder/utils/bb$c;
    //   361: getfield 1521	com/tencent/mm/plugin/finder/utils/bb$c:name	Ljava/lang/String;
    //   364: aconst_null
    //   365: iconst_1
    //   366: iconst_0
    //   367: bipush 10
    //   369: invokestatic 1524	com/tencent/mm/plugin/finder/utils/ba:a	(Lcom/tencent/mm/plugin/finder/utils/ba;Ljava/lang/String;Lcom/tencent/mm/bx/b;ZZI)V
    //   372: getstatic 1507	com/tencent/mm/plugin/finder/utils/ba:Gjt	Lcom/tencent/mm/plugin/finder/utils/ba;
    //   375: astore_1
    //   376: getstatic 1513	com/tencent/mm/plugin/finder/utils/bb:GjM	Lcom/tencent/mm/plugin/finder/utils/bb$a;
    //   379: astore_2
    //   380: aload_1
    //   381: invokestatic 2250	com/tencent/mm/plugin/finder/utils/bb:fht	()Lcom/tencent/mm/plugin/finder/utils/bb$c;
    //   384: getfield 1521	com/tencent/mm/plugin/finder/utils/bb$c:name	Ljava/lang/String;
    //   387: aconst_null
    //   388: iconst_0
    //   389: iconst_0
    //   390: bipush 14
    //   392: invokestatic 1524	com/tencent/mm/plugin/finder/utils/ba:a	(Lcom/tencent/mm/plugin/finder/utils/ba;Ljava/lang/String;Lcom/tencent/mm/bx/b;ZZI)V
    //   395: getstatic 1645	com/tencent/mm/plugin/finder/utils/bc:GkH	Lcom/tencent/mm/plugin/finder/utils/bc;
    //   398: astore_1
    //   399: invokestatic 1650	com/tencent/mm/model/cn:bDu	()J
    //   402: invokestatic 2253	com/tencent/mm/plugin/finder/utils/bc:qP	(J)V
    //   405: aload_0
    //   406: invokespecial 2225	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:bji	()V
    //   409: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   412: astore_1
    //   413: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   416: astore_1
    //   417: ldc_w 2183
    //   420: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: return
    //   424: aload 12
    //   426: ldc_w 2255
    //   429: invokevirtual 2259	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   432: astore_1
    //   433: goto -125 -> 308
    //   436: new 2261	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ad
    //   439: dup
    //   440: aload_0
    //   441: invokespecial 2262	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ad:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;)V
    //   444: checkcast 1176	kotlin/g/a/a
    //   447: invokestatic 2265	com/tencent/mm/ae/d:B	(Lkotlin/g/a/a;)V
    //   450: aload_0
    //   451: invokevirtual 2268	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ezs	()V
    //   454: ldc_w 2183
    //   457: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   460: return
    //   461: aload_0
    //   462: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   465: ldc_w 2270
    //   468: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload_0
    //   472: ldc_w 559
    //   475: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   478: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   481: invokevirtual 2273	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyA	()Z
    //   484: ifne +117 -> 601
    //   487: aload_0
    //   488: getfield 2275	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiS	Lcom/tencent/mm/plugin/finder/live/plugin/bt;
    //   491: astore_1
    //   492: aload_1
    //   493: ifnull +13 -> 506
    //   496: aload_1
    //   497: bipush 8
    //   499: invokevirtual 2278	com/tencent/mm/plugin/finder/live/plugin/bt:tO	(I)V
    //   502: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   505: astore_1
    //   506: aload_0
    //   507: getfield 1464	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiO	Lcom/tencent/mm/plugin/finder/live/plugin/y;
    //   510: astore_1
    //   511: aload_1
    //   512: ifnull +13 -> 525
    //   515: aload_1
    //   516: bipush 8
    //   518: invokevirtual 2279	com/tencent/mm/plugin/finder/live/plugin/y:tO	(I)V
    //   521: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   524: astore_1
    //   525: aload_0
    //   526: getfield 2281	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejt	Lcom/tencent/mm/plugin/finder/live/plugin/ab;
    //   529: astore_1
    //   530: aload_1
    //   531: ifnull +13 -> 544
    //   534: aload_1
    //   535: bipush 8
    //   537: invokevirtual 2284	com/tencent/mm/plugin/finder/live/plugin/ab:tO	(I)V
    //   540: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   543: astore_1
    //   544: aload_0
    //   545: getfield 964	com/tencent/mm/plugin/finder/live/component/statecomponent/a:CCb	Lcom/tencent/mm/plugin/finder/live/view/router/a;
    //   548: astore_1
    //   549: aload_1
    //   550: ifnull +51 -> 601
    //   553: aload_0
    //   554: ldc_w 559
    //   557: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   560: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   563: getfield 1324	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:mIC	Ljava/lang/String;
    //   566: astore_2
    //   567: aload_0
    //   568: getfield 690	com/tencent/mm/plugin/finder/live/component/statecomponent/a:CCa	Landroidx/appcompat/app/AppCompatActivity;
    //   571: invokevirtual 698	androidx/appcompat/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   574: getstatic 2287	com/tencent/mm/plugin/finder/live/p$h:live_local_network_error_tip	I
    //   577: invokevirtual 708	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   580: astore 13
    //   582: aload 13
    //   584: ldc_w 2289
    //   587: invokestatic 713	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   590: aload_1
    //   591: aload_2
    //   592: aload 13
    //   594: invokevirtual 2292	com/tencent/mm/plugin/finder/live/view/router/a:showTipWithBlurBg	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   600: astore_1
    //   601: getstatic 623	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   604: getstatic 924	com/tencent/mm/plugin/finder/live/report/q$a:DqG	Lcom/tencent/mm/plugin/finder/live/report/q$a;
    //   607: getfield 927	com/tencent/mm/plugin/finder/live/report/q$a:mwI	J
    //   610: getstatic 933	com/tencent/mm/plugin/finder/live/report/q$bs:DCa	Lcom/tencent/mm/plugin/finder/live/report/q$bs;
    //   613: getfield 934	com/tencent/mm/plugin/finder/live/report/q$bs:type	I
    //   616: invokestatic 547	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   619: invokevirtual 938	com/tencent/mm/plugin/finder/live/report/j:C	(JLjava/lang/String;)V
    //   622: getstatic 623	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   625: astore_1
    //   626: aload 12
    //   628: ifnonnull +26 -> 654
    //   631: iconst_0
    //   632: istore_3
    //   633: iload_3
    //   634: invokestatic 941	com/tencent/mm/plugin/finder/live/report/j:setErrorCode	(I)V
    //   637: getstatic 623	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   640: astore_1
    //   641: getstatic 947	com/tencent/mm/plugin/finder/live/report/q$v:DwK	Lcom/tencent/mm/plugin/finder/live/report/q$v;
    //   644: invokestatic 951	com/tencent/mm/plugin/finder/live/report/j:b	(Lcom/tencent/mm/plugin/finder/live/report/q$v;)V
    //   647: ldc_w 2183
    //   650: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: return
    //   654: aload 12
    //   656: ldc_w 2294
    //   659: iconst_0
    //   660: invokevirtual 2297	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   663: istore_3
    //   664: goto -31 -> 633
    //   667: aload 12
    //   669: ifnonnull +583 -> 1252
    //   672: iconst_0
    //   673: istore 7
    //   675: aload_0
    //   676: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   679: astore_2
    //   680: new 758	java/lang/StringBuilder
    //   683: dup
    //   684: ldc_w 2299
    //   687: invokespecial 761	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   690: astore 12
    //   692: aload_0
    //   693: ldc_w 559
    //   696: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   699: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   702: getfield 2303	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:Eco	Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   705: astore_1
    //   706: aload_1
    //   707: ifnonnull +558 -> 1265
    //   710: aconst_null
    //   711: astore_1
    //   712: aload_2
    //   713: aload 12
    //   715: aload_1
    //   716: invokevirtual 770	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   719: ldc_w 2305
    //   722: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload_0
    //   726: ldc_w 740
    //   729: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   732: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   735: getfield 2308	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:nonceId	Ljava/lang/String;
    //   738: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 777	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: aload_0
    //   748: ldc_w 559
    //   751: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   754: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   757: getfield 2303	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:Eco	Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   760: ifnull +36 -> 796
    //   763: aload_0
    //   764: ldc_w 559
    //   767: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   770: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   773: getfield 2303	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:Eco	Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   776: astore_1
    //   777: aload_1
    //   778: ifnull +498 -> 1276
    //   781: aload_1
    //   782: getfield 2313	com/tencent/mm/protocal/protobuf/FinderObject:id	J
    //   785: lconst_0
    //   786: lcmp
    //   787: ifne +489 -> 1276
    //   790: iconst_1
    //   791: istore_3
    //   792: iload_3
    //   793: ifeq +145 -> 938
    //   796: aload_0
    //   797: ldc_w 740
    //   800: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   803: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   806: getfield 2308	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:nonceId	Ljava/lang/String;
    //   809: invokestatic 2318	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   812: ifne +126 -> 938
    //   815: new 2320	com/tencent/mm/protocal/protobuf/bui
    //   818: dup
    //   819: invokespecial 2321	com/tencent/mm/protocal/protobuf/bui:<init>	()V
    //   822: astore_1
    //   823: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   826: astore_2
    //   827: invokestatic 2325	com/tencent/mm/plugin/finder/live/model/aj:egD	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/g;
    //   830: astore_2
    //   831: aload_2
    //   832: ifnonnull +449 -> 1281
    //   835: iconst_0
    //   836: istore_3
    //   837: aload_1
    //   838: iload_3
    //   839: putfield 2328	com/tencent/mm/protocal/protobuf/bui:hLK	I
    //   842: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   845: astore_2
    //   846: invokestatic 2325	com/tencent/mm/plugin/finder/live/model/aj:egD	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/g;
    //   849: astore_2
    //   850: aload_2
    //   851: ifnonnull +452 -> 1303
    //   854: iconst_0
    //   855: istore_3
    //   856: aload_1
    //   857: iload_3
    //   858: putfield 2331	com/tencent/mm/protocal/protobuf/bui:AJo	I
    //   861: ldc_w 1369
    //   864: invokestatic 1375	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   867: astore_2
    //   868: aload_2
    //   869: ldc_w 1377
    //   872: invokestatic 713	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   875: aload_2
    //   876: checkcast 1369	com/tencent/mm/plugin/h
    //   879: aload_0
    //   880: getfield 690	com/tencent/mm/plugin/finder/live/component/statecomponent/a:CCa	Landroidx/appcompat/app/AppCompatActivity;
    //   883: checkcast 1972	com/tencent/mm/ui/MMActivity
    //   886: aload_0
    //   887: ldc_w 740
    //   890: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   893: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   896: getfield 1327	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:hKN	J
    //   899: aload_0
    //   900: ldc_w 740
    //   903: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   906: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   909: getfield 2308	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:nonceId	Ljava/lang/String;
    //   912: ldc_w 551
    //   915: iconst_1
    //   916: aconst_null
    //   917: iconst_0
    //   918: aconst_null
    //   919: aload_1
    //   920: iconst_0
    //   921: new 2333	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$d
    //   924: dup
    //   925: aload_0
    //   926: invokespecial 2334	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$d:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;)V
    //   929: checkcast 1986	kotlin/g/a/b
    //   932: ldc_w 2335
    //   935: invokestatic 2338	com/tencent/mm/plugin/h$a:a	(Lcom/tencent/mm/plugin/h;Lcom/tencent/mm/ui/MMActivity;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/bui;ILkotlin/g/a/b;I)V
    //   938: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   941: astore_1
    //   942: invokestatic 2341	com/tencent/mm/plugin/finder/live/model/aj:biS	()V
    //   945: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   948: astore_1
    //   949: aload_0
    //   950: ldc_w 740
    //   953: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   956: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   959: getfield 748	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   962: getfield 754	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   965: invokestatic 2344	com/tencent/mm/plugin/finder/live/model/aj:oc	(J)V
    //   968: aload_0
    //   969: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   972: astore_1
    //   973: aload_1
    //   974: ifnull +8 -> 982
    //   977: aload_1
    //   978: invokevirtual 2347	com/tencent/mm/live/core/core/a/b:bcj	()I
    //   981: pop
    //   982: aload_0
    //   983: ldc_w 559
    //   986: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   989: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   992: invokevirtual 2350	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyt	()Z
    //   995: ifeq +330 -> 1325
    //   998: aload_0
    //   999: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   1002: astore_1
    //   1003: aload_1
    //   1004: ifnull +36 -> 1040
    //   1007: aload_0
    //   1008: getfield 690	com/tencent/mm/plugin/finder/live/component/statecomponent/a:CCa	Landroidx/appcompat/app/AppCompatActivity;
    //   1011: invokevirtual 698	androidx/appcompat/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   1014: getstatic 2355	com/tencent/mm/plugin/finder/live/p$d:live_audio_mode_frame	I
    //   1017: invokevirtual 2359	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1020: astore_2
    //   1021: aload_2
    //   1022: ldc_w 2361
    //   1025: invokestatic 713	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1028: aload_1
    //   1029: aload_2
    //   1030: invokestatic 2365	com/tencent/mm/ae/d:drawable2Bitmap	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   1033: invokevirtual 2369	com/tencent/mm/live/core/core/a/b:H	(Landroid/graphics/Bitmap;)V
    //   1036: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   1039: astore_1
    //   1040: aload_0
    //   1041: getfield 2089	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejf	Lcom/tencent/mm/plugin/finder/live/plugin/ba;
    //   1044: astore_1
    //   1045: aload_1
    //   1046: ifnull +11 -> 1057
    //   1049: aload_1
    //   1050: invokevirtual 2374	com/tencent/mm/plugin/finder/live/plugin/ba:eqO	()V
    //   1053: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   1056: astore_1
    //   1057: aload_0
    //   1058: getfield 2146	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejq	Lcom/tencent/mm/plugin/finder/live/plugin/bc;
    //   1061: astore_1
    //   1062: aload_1
    //   1063: ifnull +11 -> 1074
    //   1066: aload_1
    //   1067: invokevirtual 2379	com/tencent/mm/plugin/finder/live/plugin/bc:eqX	()V
    //   1070: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   1073: astore_1
    //   1074: aload_0
    //   1075: getfield 2381	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:CWq	Lcom/tencent/mm/plugin/finder/live/plugin/t;
    //   1078: astore_1
    //   1079: aload_1
    //   1080: ifnull +11 -> 1091
    //   1083: aload_1
    //   1084: invokevirtual 2386	com/tencent/mm/plugin/finder/live/plugin/t:eoD	()V
    //   1087: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   1090: astore_1
    //   1091: aload_0
    //   1092: invokevirtual 2388	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:startTimer	()V
    //   1095: aload_0
    //   1096: invokespecial 2390	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ezr	()V
    //   1099: getstatic 586	com/tencent/mm/plugin/finder/live/utils/a:DJT	Lcom/tencent/mm/plugin/finder/live/utils/a;
    //   1102: astore_1
    //   1103: invokestatic 2394	com/tencent/mm/plugin/finder/live/utils/a:aBP	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   1106: ldc_w 2396
    //   1109: iconst_1
    //   1110: invokevirtual 2401	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   1113: pop
    //   1114: aload_0
    //   1115: getfield 964	com/tencent/mm/plugin/finder/live/component/statecomponent/a:CCb	Lcom/tencent/mm/plugin/finder/live/view/router/a;
    //   1118: astore_1
    //   1119: aload_1
    //   1120: ifnull +11 -> 1131
    //   1123: aload_1
    //   1124: invokevirtual 2404	com/tencent/mm/plugin/finder/live/view/router/a:checkPauseStateWhenLiveStart	()V
    //   1127: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   1130: astore_1
    //   1131: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   1134: astore_1
    //   1135: invokestatic 2407	com/tencent/mm/plugin/finder/live/model/aj:elC	()V
    //   1138: getstatic 2209	com/tencent/mm/plugin/finder/live/util/m:DJb	Lcom/tencent/mm/plugin/finder/live/util/m;
    //   1141: astore_1
    //   1142: aload_0
    //   1143: getfield 1543	com/tencent/mm/plugin/finder/live/component/statecomponent/e:buContext	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   1146: invokestatic 2409	com/tencent/mm/plugin/finder/live/util/m:k	(Lcom/tencent/mm/plugin/finder/live/model/context/a;)V
    //   1149: getstatic 623	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   1152: astore_1
    //   1153: getstatic 1562	com/tencent/mm/plugin/finder/live/report/j:Doc	Lcom/tencent/mm/plugin/finder/live/report/q;
    //   1156: getfield 2412	com/tencent/mm/plugin/finder/live/report/q:Dqs	Z
    //   1159: ifne +15 -> 1174
    //   1162: getstatic 623	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   1165: getstatic 2415	com/tencent/mm/plugin/finder/live/report/q$c:Drg	Lcom/tencent/mm/plugin/finder/live/report/q$c;
    //   1168: ldc_w 551
    //   1171: invokevirtual 1120	com/tencent/mm/plugin/finder/live/report/j:a	(Lcom/tencent/mm/plugin/finder/live/report/q$c;Ljava/lang/String;)V
    //   1174: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   1177: astore_1
    //   1178: ldc_w 1350
    //   1181: invokestatic 2416	com/tencent/mm/plugin/finder/live/model/aj:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1184: checkcast 1350	com/tencent/mm/plugin/finder/live/viewmodel/data/business/q
    //   1187: astore_1
    //   1188: aload_1
    //   1189: ifnull +38 -> 1227
    //   1192: aload_1
    //   1193: getfield 2420	com/tencent/mm/plugin/finder/live/viewmodel/data/business/q:Ein	Lcom/tencent/mm/protocal/protobuf/buh;
    //   1196: astore_1
    //   1197: aload_1
    //   1198: ifnull +29 -> 1227
    //   1201: aload_1
    //   1202: getfield 2425	com/tencent/mm/protocal/protobuf/buh:ZTl	I
    //   1205: ifne +140 -> 1345
    //   1208: iconst_3
    //   1209: istore_3
    //   1210: getstatic 623	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   1213: bipush 8
    //   1215: iload_3
    //   1216: invokestatic 2428	com/tencent/mm/plugin/finder/live/report/j:a	(Lcom/tencent/mm/plugin/finder/live/report/j;II)V
    //   1219: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   1222: astore_1
    //   1223: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   1226: astore_1
    //   1227: aload_0
    //   1228: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   1231: ldc_w 2430
    //   1234: iload 7
    //   1236: invokestatic 2233	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1239: invokestatic 1262	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1242: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1245: ldc_w 2183
    //   1248: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1251: return
    //   1252: aload 12
    //   1254: ldc_w 2432
    //   1257: invokevirtual 842	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   1260: istore 7
    //   1262: goto -587 -> 675
    //   1265: aload_1
    //   1266: getfield 2313	com/tencent/mm/protocal/protobuf/FinderObject:id	J
    //   1269: invokestatic 1280	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1272: astore_1
    //   1273: goto -561 -> 712
    //   1276: iconst_0
    //   1277: istore_3
    //   1278: goto -486 -> 792
    //   1281: aload_2
    //   1282: getfield 2438	com/tencent/mm/plugin/finder/live/viewmodel/data/g:Bwy	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/j;
    //   1285: astore_2
    //   1286: aload_2
    //   1287: ifnonnull +8 -> 1295
    //   1290: iconst_0
    //   1291: istore_3
    //   1292: goto -455 -> 837
    //   1295: aload_2
    //   1296: getfield 2441	com/tencent/mm/plugin/finder/live/viewmodel/data/j:AJo	I
    //   1299: istore_3
    //   1300: goto -463 -> 837
    //   1303: aload_2
    //   1304: getfield 2438	com/tencent/mm/plugin/finder/live/viewmodel/data/g:Bwy	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/j;
    //   1307: astore_2
    //   1308: aload_2
    //   1309: ifnonnull +8 -> 1317
    //   1312: iconst_0
    //   1313: istore_3
    //   1314: goto -458 -> 856
    //   1317: aload_2
    //   1318: getfield 2441	com/tencent/mm/plugin/finder/live/viewmodel/data/j:AJo	I
    //   1321: istore_3
    //   1322: goto -466 -> 856
    //   1325: aload_0
    //   1326: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   1329: astore_1
    //   1330: aload_1
    //   1331: ifnull -291 -> 1040
    //   1334: aload_1
    //   1335: invokevirtual 2444	com/tencent/mm/live/core/core/a/b:bew	()V
    //   1338: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   1341: astore_1
    //   1342: goto -302 -> 1040
    //   1345: aload_1
    //   1346: getfield 2447	com/tencent/mm/protocal/protobuf/buh:ZTm	I
    //   1349: istore_3
    //   1350: goto -140 -> 1210
    //   1353: aload_0
    //   1354: ldc_w 559
    //   1357: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1360: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1363: invokevirtual 2450	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyB	()Z
    //   1366: ifne +82 -> 1448
    //   1369: getstatic 586	com/tencent/mm/plugin/finder/live/utils/a:DJT	Lcom/tencent/mm/plugin/finder/live/utils/a;
    //   1372: astore_1
    //   1373: invokestatic 2453	com/tencent/mm/plugin/finder/live/utils/a:euF	()Z
    //   1376: ifeq +72 -> 1448
    //   1379: getstatic 2459	com/tencent/mm/plugin/finder/live/ui/a:DHB	Lcom/tencent/mm/plugin/finder/live/ui/a;
    //   1382: astore_1
    //   1383: aload_0
    //   1384: ldc_w 740
    //   1387: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1390: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   1393: getfield 748	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   1396: getfield 754	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   1399: aload_0
    //   1400: ldc_w 740
    //   1403: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1406: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   1409: getfield 1983	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:mZp	[B
    //   1412: invokestatic 1977	com/tencent/mm/model/z:bAW	()Ljava/lang/String;
    //   1415: aload_0
    //   1416: ldc_w 740
    //   1419: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1422: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   1425: getfield 1327	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:hKN	J
    //   1428: aload_0
    //   1429: ldc_w 559
    //   1432: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1435: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1438: getfield 2463	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:Eee	Lcom/tencent/mm/plugin/finder/live/model/c;
    //   1441: invokevirtual 2469	com/tencent/mm/plugin/finder/live/model/c:ekf	()Lcom/tencent/mm/protocal/protobuf/bfk;
    //   1444: iconst_0
    //   1445: invokestatic 2472	com/tencent/mm/plugin/finder/live/ui/a:a	(J[BLjava/lang/String;JLcom/tencent/mm/protocal/protobuf/bfk;I)V
    //   1448: aload_0
    //   1449: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   1452: astore_1
    //   1453: aload_1
    //   1454: ifnull +11 -> 1465
    //   1457: aload_1
    //   1458: invokevirtual 2475	com/tencent/mm/live/core/core/a/b:bci	()V
    //   1461: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   1464: astore_1
    //   1465: aload_0
    //   1466: getfield 964	com/tencent/mm/plugin/finder/live/component/statecomponent/a:CCb	Lcom/tencent/mm/plugin/finder/live/view/router/a;
    //   1469: astore_1
    //   1470: aload_1
    //   1471: ifnull +11 -> 1482
    //   1474: aload_1
    //   1475: invokevirtual 2478	com/tencent/mm/plugin/finder/live/view/router/a:finish	()V
    //   1478: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   1481: astore_1
    //   1482: getstatic 2209	com/tencent/mm/plugin/finder/live/util/m:DJb	Lcom/tencent/mm/plugin/finder/live/util/m;
    //   1485: astore_1
    //   1486: aload_0
    //   1487: getfield 1543	com/tencent/mm/plugin/finder/live/component/statecomponent/e:buContext	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   1490: invokestatic 2212	com/tencent/mm/plugin/finder/live/util/m:l	(Lcom/tencent/mm/plugin/finder/live/model/context/a;)V
    //   1493: ldc_w 2183
    //   1496: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1499: return
    //   1500: aload 12
    //   1502: ifnonnull +277 -> 1779
    //   1505: aconst_null
    //   1506: astore_2
    //   1507: aload 12
    //   1509: ifnonnull +286 -> 1795
    //   1512: iconst_0
    //   1513: istore_3
    //   1514: aload 12
    //   1516: ifnull +13 -> 1529
    //   1519: aload 12
    //   1521: ldc_w 2007
    //   1524: iconst_0
    //   1525: invokevirtual 2297	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1528: pop
    //   1529: aload_0
    //   1530: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   1533: astore_1
    //   1534: aload_1
    //   1535: ifnull +273 -> 1808
    //   1538: aload_1
    //   1539: getfield 2195	com/tencent/mm/live/core/core/trtc/a:mRB	Lcom/tencent/mm/live/core/core/model/i;
    //   1542: astore_1
    //   1543: aload_1
    //   1544: ifnull +264 -> 1808
    //   1547: aload_1
    //   1548: invokevirtual 2481	com/tencent/mm/live/core/core/model/i:isFloatMode	()Z
    //   1551: ifne +257 -> 1808
    //   1554: iconst_1
    //   1555: istore 4
    //   1557: iload 4
    //   1559: ifeq +192 -> 1751
    //   1562: aload_0
    //   1563: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   1566: astore_1
    //   1567: aload_1
    //   1568: ifnull +246 -> 1814
    //   1571: aload_1
    //   1572: getfield 2195	com/tencent/mm/live/core/core/trtc/a:mRB	Lcom/tencent/mm/live/core/core/model/i;
    //   1575: astore_1
    //   1576: aload_1
    //   1577: ifnull +237 -> 1814
    //   1580: aload_1
    //   1581: getfield 2200	com/tencent/mm/live/core/core/model/i:mNQ	Z
    //   1584: iconst_1
    //   1585: if_icmpne +229 -> 1814
    //   1588: iconst_1
    //   1589: istore 4
    //   1591: iload 4
    //   1593: ifeq +333 -> 1926
    //   1596: aload_0
    //   1597: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   1600: astore 12
    //   1602: aload 12
    //   1604: ifnull +379 -> 1983
    //   1607: aconst_null
    //   1608: astore_1
    //   1609: aload 12
    //   1611: getfield 2484	com/tencent/mm/live/core/core/trtc/a:mRT	Landroid/view/View;
    //   1614: astore 12
    //   1616: aload 12
    //   1618: ifnull +305 -> 1923
    //   1621: aload 12
    //   1623: invokevirtual 2487	android/view/View:getMeasuredWidth	()I
    //   1626: aload 12
    //   1628: invokevirtual 2487	android/view/View:getMeasuredWidth	()I
    //   1631: iconst_4
    //   1632: irem
    //   1633: isub
    //   1634: istore 5
    //   1636: aload 12
    //   1638: invokevirtual 2490	android/view/View:getMeasuredHeight	()I
    //   1641: aload 12
    //   1643: invokevirtual 2490	android/view/View:getMeasuredHeight	()I
    //   1646: iconst_4
    //   1647: irem
    //   1648: isub
    //   1649: istore 6
    //   1651: iload 5
    //   1653: ifle +8 -> 1661
    //   1656: iload 6
    //   1658: ifgt +162 -> 1820
    //   1661: aconst_null
    //   1662: astore_1
    //   1663: getstatic 1336	com/tencent/mm/plugin/finder/live/model/ar:CIh	Lcom/tencent/mm/plugin/finder/live/model/ar;
    //   1666: astore 12
    //   1668: invokestatic 2493	com/tencent/mm/plugin/finder/live/model/ar:emi	()V
    //   1671: aload_0
    //   1672: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   1675: astore 12
    //   1677: aload 12
    //   1679: ifnull +43 -> 1722
    //   1682: aload 12
    //   1684: checkcast 1526	com/tencent/mm/live/core/core/b
    //   1687: astore 12
    //   1689: aload_0
    //   1690: getfield 690	com/tencent/mm/plugin/finder/live/component/statecomponent/a:CCa	Landroidx/appcompat/app/AppCompatActivity;
    //   1693: checkcast 692	android/content/Context
    //   1696: astore 13
    //   1698: aload_2
    //   1699: ifnonnull +289 -> 1988
    //   1702: iconst_1
    //   1703: istore 7
    //   1705: aload 12
    //   1707: aload 13
    //   1709: iload 7
    //   1711: iconst_0
    //   1712: iload_3
    //   1713: iconst_0
    //   1714: aload_1
    //   1715: iconst_0
    //   1716: bipush 80
    //   1718: invokestatic 2498	com/tencent/mm/live/core/core/b$a:a	(Lcom/tencent/mm/live/core/core/b;Landroid/content/Context;ZZIILandroid/graphics/Bitmap;ZI)I
    //   1721: pop
    //   1722: aload_0
    //   1723: ldc_w 559
    //   1726: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1729: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1732: getfield 2501	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:EcS	I
    //   1735: ldc_w 2502
    //   1738: invokestatic 2506	com/tencent/mm/ae/d:ee	(II)Z
    //   1741: ifeq +10 -> 1751
    //   1744: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   1747: astore_1
    //   1748: invokestatic 2509	com/tencent/mm/plugin/finder/live/model/aj:elJ	()V
    //   1751: getstatic 623	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   1754: astore_1
    //   1755: getstatic 1562	com/tencent/mm/plugin/finder/live/report/j:Doc	Lcom/tencent/mm/plugin/finder/live/report/q;
    //   1758: getfield 1568	com/tencent/mm/plugin/finder/live/report/q:Dqq	Lcom/tencent/mm/plugin/finder/live/report/r;
    //   1761: astore_1
    //   1762: aload_1
    //   1763: aload_1
    //   1764: getfield 2512	com/tencent/mm/plugin/finder/live/report/r:DFY	J
    //   1767: lconst_1
    //   1768: ladd
    //   1769: putfield 2512	com/tencent/mm/plugin/finder/live/report/r:DFY	J
    //   1772: ldc_w 2183
    //   1775: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1778: return
    //   1779: aload 12
    //   1781: ldc_w 1996
    //   1784: iconst_1
    //   1785: invokevirtual 2230	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   1788: invokestatic 2233	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1791: astore_2
    //   1792: goto -285 -> 1507
    //   1795: aload 12
    //   1797: ldc_w 2005
    //   1800: iconst_0
    //   1801: invokevirtual 2297	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1804: istore_3
    //   1805: goto -291 -> 1514
    //   1808: iconst_0
    //   1809: istore 4
    //   1811: goto -254 -> 1557
    //   1814: iconst_0
    //   1815: istore 4
    //   1817: goto -226 -> 1591
    //   1820: iload 5
    //   1822: iload 6
    //   1824: getstatic 2518	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1827: invokestatic 2524	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1830: astore_1
    //   1831: aload_1
    //   1832: ifnull +19 -> 1851
    //   1835: aload_1
    //   1836: invokevirtual 2527	android/graphics/Bitmap:isRecycled	()Z
    //   1839: iconst_1
    //   1840: if_icmpne +16 -> 1856
    //   1843: iconst_1
    //   1844: istore 4
    //   1846: iload 4
    //   1848: ifeq +14 -> 1862
    //   1851: aconst_null
    //   1852: astore_1
    //   1853: goto -190 -> 1663
    //   1856: iconst_0
    //   1857: istore 4
    //   1859: goto -13 -> 1846
    //   1862: new 2529	android/graphics/Canvas
    //   1865: dup
    //   1866: aload_1
    //   1867: invokespecial 2531	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1870: astore 13
    //   1872: aload 13
    //   1874: new 2533	android/graphics/Paint
    //   1877: dup
    //   1878: invokespecial 2534	android/graphics/Paint:<init>	()V
    //   1881: invokevirtual 2538	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   1884: aload 13
    //   1886: new 2540	android/graphics/PaintFlagsDrawFilter
    //   1889: dup
    //   1890: iconst_0
    //   1891: iconst_3
    //   1892: invokespecial 2542	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   1895: checkcast 2544	android/graphics/DrawFilter
    //   1898: invokevirtual 2548	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   1901: aload 12
    //   1903: aload 13
    //   1905: invokevirtual 2552	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   1908: iload 5
    //   1910: iload 6
    //   1912: if_icmple +4928 -> 6840
    //   1915: aload_1
    //   1916: ldc_w 2553
    //   1919: invokestatic 2559	com/tencent/mm/sdk/platformtools/BitmapUtil:rotate	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   1922: astore_1
    //   1923: goto -260 -> 1663
    //   1926: aload_0
    //   1927: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   1930: astore_1
    //   1931: aload_1
    //   1932: ifnull +45 -> 1977
    //   1935: aload_1
    //   1936: getfield 2195	com/tencent/mm/live/core/core/trtc/a:mRB	Lcom/tencent/mm/live/core/core/model/i;
    //   1939: astore_1
    //   1940: aload_1
    //   1941: ifnull +36 -> 1977
    //   1944: aload_1
    //   1945: invokevirtual 2562	com/tencent/mm/live/core/core/model/i:bex	()Z
    //   1948: iconst_1
    //   1949: if_icmpne +28 -> 1977
    //   1952: iconst_1
    //   1953: istore 4
    //   1955: iload 4
    //   1957: ifeq +26 -> 1983
    //   1960: aload_0
    //   1961: ldc_w 559
    //   1964: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1967: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1970: getfield 2566	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:DVR	Landroid/graphics/Bitmap;
    //   1973: astore_1
    //   1974: goto -311 -> 1663
    //   1977: iconst_0
    //   1978: istore 4
    //   1980: goto -25 -> 1955
    //   1983: aconst_null
    //   1984: astore_1
    //   1985: goto -322 -> 1663
    //   1988: aload_2
    //   1989: invokevirtual 2569	java/lang/Boolean:booleanValue	()Z
    //   1992: istore 7
    //   1994: goto -289 -> 1705
    //   1997: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   2000: astore_1
    //   2001: lconst_0
    //   2002: aload_0
    //   2003: ldc_w 740
    //   2006: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2009: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2012: getfield 748	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   2015: getfield 754	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   2018: invokestatic 2573	com/tencent/mm/plugin/finder/live/model/aj:ap	(JJ)V
    //   2021: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   2024: astore_1
    //   2025: invokestatic 2407	com/tencent/mm/plugin/finder/live/model/aj:elC	()V
    //   2028: ldc_w 2183
    //   2031: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2034: return
    //   2035: aload 12
    //   2037: ifnull +94 -> 2131
    //   2040: aload 12
    //   2042: ldc_w 2575
    //   2045: invokevirtual 2259	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   2048: astore_2
    //   2049: aload_2
    //   2050: ifnull +81 -> 2131
    //   2053: new 2577	com/tencent/mm/protocal/protobuf/bke
    //   2056: dup
    //   2057: invokespecial 2578	com/tencent/mm/protocal/protobuf/bke:<init>	()V
    //   2060: astore_1
    //   2061: aload_1
    //   2062: aload_2
    //   2063: invokevirtual 2579	com/tencent/mm/protocal/protobuf/bke:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   2066: pop
    //   2067: new 2581	java/util/ArrayList
    //   2070: dup
    //   2071: invokespecial 2582	java/util/ArrayList:<init>	()V
    //   2074: astore_2
    //   2075: aload_2
    //   2076: aload_1
    //   2077: invokevirtual 2583	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2080: pop
    //   2081: aload_0
    //   2082: getfield 2053	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejb	Lcom/tencent/mm/plugin/finder/live/plugin/cf;
    //   2085: astore_1
    //   2086: aload_1
    //   2087: ifnull +15 -> 2102
    //   2090: aload_1
    //   2091: aload_2
    //   2092: checkcast 598	java/util/List
    //   2095: invokevirtual 2586	com/tencent/mm/plugin/finder/live/plugin/cf:gF	(Ljava/util/List;)V
    //   2098: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2101: astore_1
    //   2102: getstatic 623	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   2105: astore_1
    //   2106: getstatic 1562	com/tencent/mm/plugin/finder/live/report/j:Doc	Lcom/tencent/mm/plugin/finder/live/report/q;
    //   2109: getfield 1568	com/tencent/mm/plugin/finder/live/report/q:Dqq	Lcom/tencent/mm/plugin/finder/live/report/r;
    //   2112: astore_1
    //   2113: aload_1
    //   2114: aload_1
    //   2115: getfield 2589	com/tencent/mm/plugin/finder/live/report/r:DGj	J
    //   2118: lconst_1
    //   2119: ladd
    //   2120: putfield 2589	com/tencent/mm/plugin/finder/live/report/r:DGj	J
    //   2123: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2126: astore_1
    //   2127: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2130: astore_1
    //   2131: ldc_w 2183
    //   2134: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2137: return
    //   2138: aload_0
    //   2139: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   2142: astore_1
    //   2143: aload_1
    //   2144: ifnonnull +22 -> 2166
    //   2147: new 531	java/lang/NullPointerException
    //   2150: dup
    //   2151: ldc_w 533
    //   2154: invokespecial 536	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   2157: astore_1
    //   2158: ldc_w 2183
    //   2161: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2164: aload_1
    //   2165: athrow
    //   2166: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   2169: astore_2
    //   2170: aload_1
    //   2171: invokestatic 2592	com/tencent/mm/plugin/finder/live/model/aj:needMirror	()Z
    //   2174: invokevirtual 2595	com/tencent/mm/live/core/core/a/b:fE	(Z)V
    //   2177: ldc_w 2183
    //   2180: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2183: return
    //   2184: aload 12
    //   2186: ifnonnull +32 -> 2218
    //   2189: iconst_0
    //   2190: istore 7
    //   2192: aload_0
    //   2193: getfield 964	com/tencent/mm/plugin/finder/live/component/statecomponent/a:CCb	Lcom/tencent/mm/plugin/finder/live/view/router/a;
    //   2196: astore_1
    //   2197: aload_1
    //   2198: ifnull +13 -> 2211
    //   2201: aload_1
    //   2202: iload 7
    //   2204: invokevirtual 2598	com/tencent/mm/plugin/finder/live/view/router/a:onScreenClear	(Z)V
    //   2207: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2210: astore_1
    //   2211: ldc_w 2183
    //   2214: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2217: return
    //   2218: aload 12
    //   2220: ldc_w 2600
    //   2223: invokevirtual 842	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   2226: istore 7
    //   2228: goto -36 -> 2192
    //   2231: aload 12
    //   2233: ifnonnull +274 -> 2507
    //   2236: ldc_w 551
    //   2239: astore_1
    //   2240: aload_0
    //   2241: ldc_w 517
    //   2244: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2247: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2250: getfield 2603	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efx	Ljava/util/List;
    //   2253: astore_2
    //   2254: aload_2
    //   2255: ifnonnull +275 -> 2530
    //   2258: aconst_null
    //   2259: astore_2
    //   2260: aload_2
    //   2261: ifnull +239 -> 2500
    //   2264: new 763	com/tencent/mm/protocal/protobuf/bgh
    //   2267: dup
    //   2268: invokespecial 2604	com/tencent/mm/protocal/protobuf/bgh:<init>	()V
    //   2271: astore 14
    //   2273: new 792	com/tencent/mm/protocal/protobuf/FinderContact
    //   2276: dup
    //   2277: invokespecial 2605	com/tencent/mm/protocal/protobuf/FinderContact:<init>	()V
    //   2280: astore 12
    //   2282: aload 12
    //   2284: aload_2
    //   2285: getfield 667	com/tencent/mm/plugin/finder/live/viewmodel/data/h:username	Ljava/lang/String;
    //   2288: putfield 799	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   2291: aload 12
    //   2293: aload_2
    //   2294: getfield 2606	com/tencent/mm/plugin/finder/live/viewmodel/data/h:nickname	Ljava/lang/String;
    //   2297: putfield 795	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   2300: aload 12
    //   2302: aload_2
    //   2303: getfield 2607	com/tencent/mm/plugin/finder/live/viewmodel/data/h:headUrl	Ljava/lang/String;
    //   2306: putfield 798	com/tencent/mm/protocal/protobuf/FinderContact:headUrl	Ljava/lang/String;
    //   2309: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2312: astore 13
    //   2314: aload 14
    //   2316: aload 12
    //   2318: putfield 766	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   2321: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2324: astore 12
    //   2326: getstatic 673	com/tencent/mm/plugin/finder/live/model/mic/b:CMY	Lcom/tencent/mm/plugin/finder/live/model/mic/b;
    //   2329: astore 12
    //   2331: aload_2
    //   2332: getfield 575	com/tencent/mm/plugin/finder/live/viewmodel/data/h:sessionId	Ljava/lang/String;
    //   2335: invokestatic 2610	com/tencent/mm/plugin/finder/live/model/mic/b:awH	(Ljava/lang/String;)V
    //   2338: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   2341: astore 12
    //   2343: invokestatic 1791	com/tencent/mm/plugin/finder/live/model/aj:getFinderLiveAssistant	()Lcom/tencent/mm/plugin/finder/live/model/ap;
    //   2346: astore 15
    //   2348: aload 15
    //   2350: ifnull +150 -> 2500
    //   2353: aload_0
    //   2354: ldc_w 740
    //   2357: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2360: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2363: getfield 748	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   2366: getfield 754	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   2369: lstore 8
    //   2371: aload_0
    //   2372: ldc_w 740
    //   2375: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2378: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2381: getfield 1327	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:hKN	J
    //   2384: lstore 10
    //   2386: aload_0
    //   2387: ldc_w 740
    //   2390: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2393: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2396: getfield 2308	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:nonceId	Ljava/lang/String;
    //   2399: astore 16
    //   2401: aload_0
    //   2402: ldc_w 740
    //   2405: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2408: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   2411: getfield 1983	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:mZp	[B
    //   2414: astore 17
    //   2416: getstatic 2616	com/tencent/mm/live/model/l$k:mYO	Lcom/tencent/mm/live/model/l$k;
    //   2419: astore 12
    //   2421: invokestatic 2619	com/tencent/mm/live/model/l$k:bhG	()I
    //   2424: istore_3
    //   2425: aload_2
    //   2426: getfield 1946	com/tencent/mm/plugin/finder/live/viewmodel/data/h:mXM	I
    //   2429: istore 4
    //   2431: aload_2
    //   2432: getfield 550	com/tencent/mm/plugin/finder/live/viewmodel/data/h:mXL	Ljava/lang/String;
    //   2435: astore 18
    //   2437: aload_2
    //   2438: getfield 575	com/tencent/mm/plugin/finder/live/viewmodel/data/h:sessionId	Ljava/lang/String;
    //   2441: astore 13
    //   2443: aload 13
    //   2445: astore 12
    //   2447: aload 13
    //   2449: ifnonnull +8 -> 2457
    //   2452: ldc_w 551
    //   2455: astore 12
    //   2457: aload 15
    //   2459: lload 8
    //   2461: lload 10
    //   2463: aload 16
    //   2465: aload 17
    //   2467: iload_3
    //   2468: aload 14
    //   2470: iload 4
    //   2472: aload 18
    //   2474: aload 12
    //   2476: new 15	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ae
    //   2479: dup
    //   2480: aload_0
    //   2481: aload_2
    //   2482: aload 14
    //   2484: aload_1
    //   2485: invokespecial 2622	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ae:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;Lcom/tencent/mm/protocal/protobuf/bgh;Ljava/lang/String;)V
    //   2488: checkcast 2624	com/tencent/mm/plugin/finder/live/model/cgi/a$a
    //   2491: invokeinterface 2627 13 0
    //   2496: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2499: astore_1
    //   2500: ldc_w 2183
    //   2503: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2506: return
    //   2507: aload 12
    //   2509: ldc_w 2629
    //   2512: invokevirtual 2632	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2515: astore_1
    //   2516: aload_1
    //   2517: ifnonnull +10 -> 2527
    //   2520: ldc_w 551
    //   2523: astore_1
    //   2524: goto -284 -> 2240
    //   2527: goto -287 -> 2240
    //   2530: aload_2
    //   2531: checkcast 1205	java/lang/Iterable
    //   2534: astore 12
    //   2536: aload 12
    //   2538: monitorenter
    //   2539: aload 12
    //   2541: invokeinterface 1209 1 0
    //   2546: astore 13
    //   2548: aload 13
    //   2550: invokeinterface 1215 1 0
    //   2555: ifeq +40 -> 2595
    //   2558: aload 13
    //   2560: invokeinterface 1219 1 0
    //   2565: astore_2
    //   2566: aload_2
    //   2567: checkcast 538	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   2570: getfield 575	com/tencent/mm/plugin/finder/live/viewmodel/data/h:sessionId	Ljava/lang/String;
    //   2573: aload_1
    //   2574: invokestatic 2636	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2577: istore 7
    //   2579: iload 7
    //   2581: ifeq -33 -> 2548
    //   2584: aload 12
    //   2586: monitorexit
    //   2587: aload_2
    //   2588: checkcast 538	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   2591: astore_2
    //   2592: goto -332 -> 2260
    //   2595: aconst_null
    //   2596: astore_2
    //   2597: goto -13 -> 2584
    //   2600: astore_1
    //   2601: aload 12
    //   2603: monitorexit
    //   2604: ldc_w 2183
    //   2607: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2610: aload_1
    //   2611: athrow
    //   2612: aload_0
    //   2613: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   2616: new 758	java/lang/StringBuilder
    //   2619: dup
    //   2620: ldc_w 2638
    //   2623: invokespecial 761	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2626: aload_0
    //   2627: ldc_w 517
    //   2630: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2633: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2636: getfield 525	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   2639: invokevirtual 770	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2642: ldc_w 2640
    //   2645: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2648: aload_0
    //   2649: ldc_w 517
    //   2652: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2655: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2658: getfield 1910	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efw	Ljava/util/List;
    //   2661: invokevirtual 770	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2664: ldc_w 2642
    //   2667: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2670: aload_0
    //   2671: ldc_w 517
    //   2674: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2677: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2680: getfield 681	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efy	I
    //   2683: invokevirtual 913	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2686: ldc_w 2644
    //   2689: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2692: aload_0
    //   2693: ldc_w 517
    //   2696: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2699: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2702: getfield 1932	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfM	Z
    //   2705: invokevirtual 1359	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2708: invokevirtual 777	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2711: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2714: aload_0
    //   2715: ldc_w 517
    //   2718: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2721: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2724: getfield 681	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efy	I
    //   2727: iconst_5
    //   2728: if_icmpne +32 -> 2760
    //   2731: getstatic 673	com/tencent/mm/plugin/finder/live/model/mic/b:CMY	Lcom/tencent/mm/plugin/finder/live/model/mic/b;
    //   2734: astore_1
    //   2735: invokestatic 1298	com/tencent/mm/plugin/finder/live/model/mic/b:enj	()V
    //   2738: aload_0
    //   2739: new 21	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$af
    //   2742: dup
    //   2743: aload_0
    //   2744: invokespecial 2645	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$af:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;)V
    //   2747: checkcast 1986	kotlin/g/a/b
    //   2750: invokevirtual 2647	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ap	(Lkotlin/g/a/b;)V
    //   2753: ldc_w 2183
    //   2756: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2759: return
    //   2760: aload 12
    //   2762: ifnonnull +197 -> 2959
    //   2765: aconst_null
    //   2766: astore_1
    //   2767: aload_0
    //   2768: ldc_w 517
    //   2771: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2774: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2777: aload_1
    //   2778: invokevirtual 2651	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:ays	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   2781: astore_2
    //   2782: aload_0
    //   2783: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   2786: new 758	java/lang/StringBuilder
    //   2789: dup
    //   2790: ldc_w 2653
    //   2793: invokespecial 761	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2796: aload_1
    //   2797: invokevirtual 770	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2800: ldc_w 2655
    //   2803: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2806: aload_2
    //   2807: invokevirtual 770	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2810: invokevirtual 777	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2813: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2816: aload_2
    //   2817: ifnonnull +154 -> 2971
    //   2820: aconst_null
    //   2821: astore_1
    //   2822: aload_1
    //   2823: ifnonnull +194 -> 3017
    //   2826: aload_0
    //   2827: checkcast 2	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b
    //   2830: astore_1
    //   2831: aload_1
    //   2832: ldc_w 517
    //   2835: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2838: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2841: getfield 525	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   2844: astore_2
    //   2845: aload_2
    //   2846: ifnull +153 -> 2999
    //   2849: aload_2
    //   2850: getfield 1926	com/tencent/mm/plugin/finder/live/viewmodel/data/h:EbD	Z
    //   2853: iconst_1
    //   2854: if_icmpne +145 -> 2999
    //   2857: iconst_1
    //   2858: istore_3
    //   2859: iload_3
    //   2860: ifeq +144 -> 3004
    //   2863: getstatic 673	com/tencent/mm/plugin/finder/live/model/mic/b:CMY	Lcom/tencent/mm/plugin/finder/live/model/mic/b;
    //   2866: astore_2
    //   2867: invokestatic 1295	com/tencent/mm/plugin/finder/live/model/mic/b:eng	()V
    //   2870: aload_1
    //   2871: new 25	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ah
    //   2874: dup
    //   2875: aload_1
    //   2876: invokespecial 2656	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ah:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;)V
    //   2879: checkcast 1986	kotlin/g/a/b
    //   2882: invokevirtual 898	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ao	(Lkotlin/g/a/b;)V
    //   2885: getstatic 623	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   2888: astore_1
    //   2889: getstatic 1098	com/tencent/mm/plugin/finder/live/report/q$c:DrF	Lcom/tencent/mm/plugin/finder/live/report/q$c;
    //   2892: astore_2
    //   2893: new 1100	org/json/JSONObject
    //   2896: dup
    //   2897: invokespecial 1101	org/json/JSONObject:<init>	()V
    //   2900: astore 12
    //   2902: aload 12
    //   2904: ldc_w 1102
    //   2907: getstatic 2659	com/tencent/mm/plugin/finder/live/report/q$i:DsL	Lcom/tencent/mm/plugin/finder/live/report/q$i;
    //   2910: getfield 655	com/tencent/mm/plugin/finder/live/report/q$i:type	I
    //   2913: invokestatic 1110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2916: invokevirtual 1114	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2919: pop
    //   2920: aload 12
    //   2922: ldc_w 1116
    //   2925: iconst_1
    //   2926: invokestatic 1110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2929: invokevirtual 1114	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2932: pop
    //   2933: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2936: astore 13
    //   2938: aload_1
    //   2939: aload_2
    //   2940: aload 12
    //   2942: invokevirtual 1117	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2945: invokevirtual 1120	com/tencent/mm/plugin/finder/live/report/j:a	(Lcom/tencent/mm/plugin/finder/live/report/q$c;Ljava/lang/String;)V
    //   2948: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2951: astore_1
    //   2952: ldc_w 2183
    //   2955: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2958: return
    //   2959: aload 12
    //   2961: ldc_w 2629
    //   2964: invokevirtual 2632	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2967: astore_1
    //   2968: goto -201 -> 2767
    //   2971: aload_0
    //   2972: aload_2
    //   2973: new 23	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ag
    //   2976: dup
    //   2977: aload_0
    //   2978: aload_2
    //   2979: invokespecial 2661	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ag:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;)V
    //   2982: checkcast 1986	kotlin/g/a/b
    //   2985: invokevirtual 1198	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:a	(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;Lkotlin/g/a/b;)V
    //   2988: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2991: astore_1
    //   2992: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   2995: astore_1
    //   2996: goto -174 -> 2822
    //   2999: iconst_0
    //   3000: istore_3
    //   3001: goto -142 -> 2859
    //   3004: aload_1
    //   3005: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   3008: ldc_w 2663
    //   3011: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3014: goto -66 -> 2948
    //   3017: ldc_w 2183
    //   3020: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3023: return
    //   3024: aload_0
    //   3025: getfield 2665	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejo	Lcom/tencent/mm/plugin/finder/live/plugin/bf;
    //   3028: astore_1
    //   3029: aload_1
    //   3030: ifnull +11 -> 3041
    //   3033: aload_1
    //   3034: invokevirtual 2670	com/tencent/mm/plugin/finder/live/plugin/bf:era	()V
    //   3037: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3040: astore_1
    //   3041: aload_0
    //   3042: getfield 2672	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejr	Lcom/tencent/mm/plugin/finder/live/plugin/be;
    //   3045: astore_1
    //   3046: aload_1
    //   3047: ifnull +11 -> 3058
    //   3050: aload_1
    //   3051: invokevirtual 2675	com/tencent/mm/plugin/finder/live/plugin/be:era	()V
    //   3054: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3057: astore_1
    //   3058: ldc_w 2183
    //   3061: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3064: return
    //   3065: aload_0
    //   3066: getfield 2665	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejo	Lcom/tencent/mm/plugin/finder/live/plugin/bf;
    //   3069: astore_1
    //   3070: aload_1
    //   3071: ifnull +11 -> 3082
    //   3074: aload_1
    //   3075: invokevirtual 2678	com/tencent/mm/plugin/finder/live/plugin/bf:erb	()V
    //   3078: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3081: astore_1
    //   3082: aload_0
    //   3083: getfield 2672	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejr	Lcom/tencent/mm/plugin/finder/live/plugin/be;
    //   3086: astore_1
    //   3087: aload_1
    //   3088: ifnull +11 -> 3099
    //   3091: aload_1
    //   3092: invokevirtual 2679	com/tencent/mm/plugin/finder/live/plugin/be:erb	()V
    //   3095: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3098: astore_1
    //   3099: ldc_w 2183
    //   3102: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3105: return
    //   3106: aload_0
    //   3107: getfield 603	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejp	Lcom/tencent/mm/plugin/finder/live/plugin/h;
    //   3110: astore_1
    //   3111: aload_1
    //   3112: ifnull +11 -> 3123
    //   3115: aload_1
    //   3116: invokevirtual 2682	com/tencent/mm/plugin/finder/live/plugin/h:eoR	()V
    //   3119: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3122: astore_1
    //   3123: ldc_w 2183
    //   3126: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3129: return
    //   3130: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   3133: astore_1
    //   3134: invokestatic 1791	com/tencent/mm/plugin/finder/live/model/aj:getFinderLiveAssistant	()Lcom/tencent/mm/plugin/finder/live/model/ap;
    //   3137: astore_1
    //   3138: aload_1
    //   3139: ifnull +60 -> 3199
    //   3142: aload_1
    //   3143: aload_0
    //   3144: ldc_w 740
    //   3147: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3150: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   3153: getfield 748	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   3156: getfield 754	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   3159: aload_0
    //   3160: ldc_w 740
    //   3163: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3166: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   3169: getfield 1327	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:hKN	J
    //   3172: aload_0
    //   3173: ldc_w 559
    //   3176: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3179: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   3182: getfield 2685	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:Ecp	I
    //   3185: ldc2_w 2686
    //   3188: iconst_0
    //   3189: aconst_null
    //   3190: bipush 48
    //   3192: invokestatic 2690	com/tencent/mm/plugin/finder/live/model/ap$a:a	(Lcom/tencent/mm/plugin/finder/live/model/ap;JJIJILcom/tencent/mm/plugin/finder/live/cgi/e$a;I)V
    //   3195: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3198: astore_1
    //   3199: aload 12
    //   3201: ifnonnull +122 -> 3323
    //   3204: iconst_1
    //   3205: istore 7
    //   3207: iload 7
    //   3209: ifne +63 -> 3272
    //   3212: aload_0
    //   3213: ldc_w 517
    //   3216: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3219: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3222: getfield 525	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   3225: ifnull +47 -> 3272
    //   3228: aload_0
    //   3229: ldc_w 517
    //   3232: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3235: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3238: getfield 525	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   3241: astore_1
    //   3242: aload_1
    //   3243: ifnull +93 -> 3336
    //   3246: aload_1
    //   3247: getfield 1926	com/tencent/mm/plugin/finder/live/viewmodel/data/h:EbD	Z
    //   3250: iconst_1
    //   3251: if_icmpne +85 -> 3336
    //   3254: iconst_1
    //   3255: istore_3
    //   3256: iload_3
    //   3257: ifeq +84 -> 3341
    //   3260: getstatic 673	com/tencent/mm/plugin/finder/live/model/mic/b:CMY	Lcom/tencent/mm/plugin/finder/live/model/mic/b;
    //   3263: astore_1
    //   3264: invokestatic 1295	com/tencent/mm/plugin/finder/live/model/mic/b:eng	()V
    //   3267: aload_0
    //   3268: aconst_null
    //   3269: invokevirtual 898	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ao	(Lkotlin/g/a/b;)V
    //   3272: iload 7
    //   3274: ifne -3110 -> 164
    //   3277: aload_0
    //   3278: ldc_w 517
    //   3281: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3284: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3287: getfield 681	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efy	I
    //   3290: iconst_5
    //   3291: if_icmpne -3127 -> 164
    //   3294: getstatic 673	com/tencent/mm/plugin/finder/live/model/mic/b:CMY	Lcom/tencent/mm/plugin/finder/live/model/mic/b;
    //   3297: astore_1
    //   3298: invokestatic 1298	com/tencent/mm/plugin/finder/live/model/mic/b:enj	()V
    //   3301: aload_0
    //   3302: new 85	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$v
    //   3305: dup
    //   3306: aload_0
    //   3307: invokespecial 2691	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$v:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;)V
    //   3310: checkcast 1986	kotlin/g/a/b
    //   3313: invokevirtual 2647	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ap	(Lkotlin/g/a/b;)V
    //   3316: ldc_w 2183
    //   3319: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3322: return
    //   3323: aload 12
    //   3325: ldc_w 2693
    //   3328: invokevirtual 842	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   3331: istore 7
    //   3333: goto -126 -> 3207
    //   3336: iconst_0
    //   3337: istore_3
    //   3338: goto -82 -> 3256
    //   3341: aload_0
    //   3342: ldc_w 517
    //   3345: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3348: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3351: getfield 1910	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efw	Ljava/util/List;
    //   3354: astore_1
    //   3355: aload_1
    //   3356: ldc_w 1940
    //   3359: invokestatic 713	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3362: aload_1
    //   3363: checkcast 1205	java/lang/Iterable
    //   3366: astore_1
    //   3367: aload_1
    //   3368: monitorenter
    //   3369: aload_1
    //   3370: invokeinterface 1209 1 0
    //   3375: astore_2
    //   3376: aload_2
    //   3377: invokeinterface 1215 1 0
    //   3382: ifeq +31 -> 3413
    //   3385: aload_0
    //   3386: aload_2
    //   3387: invokeinterface 1219 1 0
    //   3392: checkcast 538	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   3395: aconst_null
    //   3396: invokevirtual 1198	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:a	(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;Lkotlin/g/a/b;)V
    //   3399: goto -23 -> 3376
    //   3402: astore_2
    //   3403: aload_1
    //   3404: monitorexit
    //   3405: ldc_w 2183
    //   3408: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3411: aload_2
    //   3412: athrow
    //   3413: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3416: astore_2
    //   3417: aload_1
    //   3418: monitorexit
    //   3419: aload_0
    //   3420: ldc_w 517
    //   3423: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3426: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3429: getfield 1910	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efw	Ljava/util/List;
    //   3432: invokeinterface 601 1 0
    //   3437: goto -165 -> 3272
    //   3440: aload_0
    //   3441: getfield 2695	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejk	Lcom/tencent/mm/plugin/finder/live/plugin/aw;
    //   3444: astore_1
    //   3445: aload_1
    //   3446: ifnull +11 -> 3457
    //   3449: aload_1
    //   3450: invokevirtual 2700	com/tencent/mm/plugin/finder/live/plugin/aw:eqw	()V
    //   3453: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3456: astore_1
    //   3457: ldc_w 2183
    //   3460: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3463: return
    //   3464: aload 12
    //   3466: ifnonnull +255 -> 3721
    //   3469: aconst_null
    //   3470: astore_1
    //   3471: new 763	com/tencent/mm/protocal/protobuf/bgh
    //   3474: dup
    //   3475: invokespecial 2604	com/tencent/mm/protocal/protobuf/bgh:<init>	()V
    //   3478: checkcast 1782	com/tencent/mm/bx/a
    //   3481: astore_2
    //   3482: aload_2
    //   3483: aload_1
    //   3484: invokevirtual 2701	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   3487: pop
    //   3488: aload_2
    //   3489: astore_1
    //   3490: aload_1
    //   3491: checkcast 763	com/tencent/mm/protocal/protobuf/bgh
    //   3494: astore_2
    //   3495: aload_0
    //   3496: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   3499: astore 12
    //   3501: new 758	java/lang/StringBuilder
    //   3504: dup
    //   3505: ldc_w 2703
    //   3508: invokespecial 761	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3511: astore 13
    //   3513: aload_2
    //   3514: ifnonnull +242 -> 3756
    //   3517: aconst_null
    //   3518: astore_1
    //   3519: aload 12
    //   3521: aload 13
    //   3523: aload_1
    //   3524: invokevirtual 770	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3527: bipush 93
    //   3529: invokevirtual 773	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3532: invokevirtual 777	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3535: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3538: aload_2
    //   3539: ifnull +175 -> 3714
    //   3542: aload_0
    //   3543: ldc_w 517
    //   3546: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3549: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3552: iconst_2
    //   3553: putfield 681	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efy	I
    //   3556: aload_0
    //   3557: getfield 502	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejl	Lcom/tencent/mm/plugin/finder/live/plugin/q;
    //   3560: astore_1
    //   3561: aload_1
    //   3562: ifnull +11 -> 3573
    //   3565: aload_1
    //   3566: invokevirtual 1923	com/tencent/mm/plugin/finder/live/plugin/q:epo	()V
    //   3569: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3572: astore_1
    //   3573: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   3576: astore_1
    //   3577: invokestatic 1791	com/tencent/mm/plugin/finder/live/model/aj:getFinderLiveAssistant	()Lcom/tencent/mm/plugin/finder/live/model/ap;
    //   3580: astore_1
    //   3581: aload_1
    //   3582: ifnull +132 -> 3714
    //   3585: aload_0
    //   3586: ldc_w 740
    //   3589: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3592: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   3595: getfield 748	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   3598: getfield 754	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   3601: lstore 8
    //   3603: aload_0
    //   3604: ldc_w 740
    //   3607: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3610: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   3613: getfield 1327	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:hKN	J
    //   3616: lstore 10
    //   3618: aload_0
    //   3619: ldc_w 740
    //   3622: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3625: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   3628: getfield 2308	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:nonceId	Ljava/lang/String;
    //   3631: astore 12
    //   3633: aload_0
    //   3634: ldc_w 740
    //   3637: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3640: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   3643: getfield 1983	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:mZp	[B
    //   3646: astore 13
    //   3648: getstatic 2616	com/tencent/mm/live/model/l$k:mYO	Lcom/tencent/mm/live/model/l$k;
    //   3651: astore 14
    //   3653: aload_1
    //   3654: lload 8
    //   3656: lload 10
    //   3658: aload 12
    //   3660: aload 13
    //   3662: invokestatic 2619	com/tencent/mm/live/model/l$k:bhG	()I
    //   3665: aload_2
    //   3666: aload_0
    //   3667: ldc_w 559
    //   3670: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3673: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   3676: invokevirtual 2706	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyF	()Ljava/lang/String;
    //   3679: aload_0
    //   3680: ldc_w 559
    //   3683: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3686: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   3689: invokevirtual 563	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyG	()I
    //   3692: aconst_null
    //   3693: new 87	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$w
    //   3696: dup
    //   3697: aload_0
    //   3698: aload_2
    //   3699: invokespecial 2709	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$w:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;Lcom/tencent/mm/protocal/protobuf/bgh;)V
    //   3702: checkcast 2711	com/tencent/mm/plugin/finder/live/model/cgi/e$a
    //   3705: invokeinterface 2714 13 0
    //   3710: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3713: astore_1
    //   3714: ldc_w 2183
    //   3717: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3720: return
    //   3721: aload 12
    //   3723: ldc_w 2716
    //   3726: invokevirtual 2259	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   3729: astore_1
    //   3730: goto -259 -> 3471
    //   3733: astore_1
    //   3734: ldc_w 2718
    //   3737: ldc_w 551
    //   3740: iconst_1
    //   3741: anewarray 2720	java/lang/Object
    //   3744: dup
    //   3745: iconst_0
    //   3746: aload_1
    //   3747: aastore
    //   3748: invokestatic 2724	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3751: aconst_null
    //   3752: astore_1
    //   3753: goto -263 -> 3490
    //   3756: aload_2
    //   3757: getfield 766	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   3760: astore_1
    //   3761: aload_1
    //   3762: ifnonnull +8 -> 3770
    //   3765: aconst_null
    //   3766: astore_1
    //   3767: goto -248 -> 3519
    //   3770: aload_1
    //   3771: getfield 795	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   3774: astore_1
    //   3775: goto -256 -> 3519
    //   3778: aload_0
    //   3779: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   3782: ldc_w 2726
    //   3785: aload_0
    //   3786: ldc_w 517
    //   3789: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3792: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3795: getfield 525	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   3798: invokestatic 1262	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   3801: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3804: aload_0
    //   3805: ldc_w 517
    //   3808: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3811: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3814: getfield 525	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   3817: astore_1
    //   3818: aload_1
    //   3819: ifnull +172 -> 3991
    //   3822: aload_0
    //   3823: ldc_w 517
    //   3826: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3829: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3832: getfield 2729	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Eft	Ljava/util/List;
    //   3835: astore_2
    //   3836: aload_2
    //   3837: ldc_w 2731
    //   3840: invokestatic 713	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3843: aload_2
    //   3844: checkcast 1205	java/lang/Iterable
    //   3847: astore_2
    //   3848: aload_2
    //   3849: monitorenter
    //   3850: new 2581	java/util/ArrayList
    //   3853: dup
    //   3854: invokespecial 2582	java/util/ArrayList:<init>	()V
    //   3857: checkcast 1393	java/util/Collection
    //   3860: astore 12
    //   3862: aload_2
    //   3863: invokeinterface 1209 1 0
    //   3868: astore 13
    //   3870: aload 13
    //   3872: invokeinterface 1215 1 0
    //   3877: ifeq +54 -> 3931
    //   3880: aload 13
    //   3882: invokeinterface 1219 1 0
    //   3887: astore 14
    //   3889: aload 14
    //   3891: checkcast 538	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   3894: getfield 667	com/tencent/mm/plugin/finder/live/viewmodel/data/h:username	Ljava/lang/String;
    //   3897: aload_1
    //   3898: getfield 667	com/tencent/mm/plugin/finder/live/viewmodel/data/h:username	Ljava/lang/String;
    //   3901: invokestatic 2636	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3904: ifeq -34 -> 3870
    //   3907: aload 12
    //   3909: aload 14
    //   3911: invokeinterface 2732 2 0
    //   3916: pop
    //   3917: goto -47 -> 3870
    //   3920: astore_1
    //   3921: aload_2
    //   3922: monitorexit
    //   3923: ldc_w 2183
    //   3926: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3929: aload_1
    //   3930: athrow
    //   3931: aload 12
    //   3933: checkcast 598	java/util/List
    //   3936: astore 12
    //   3938: aload_2
    //   3939: monitorexit
    //   3940: aload 12
    //   3942: checkcast 1393	java/util/Collection
    //   3945: invokeinterface 1396 1 0
    //   3950: ifeq +48 -> 3998
    //   3953: iconst_1
    //   3954: istore_3
    //   3955: iload_3
    //   3956: ifeq +47 -> 4003
    //   3959: aload_0
    //   3960: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   3963: ldc_w 2734
    //   3966: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3969: aload_0
    //   3970: ldc_w 517
    //   3973: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3976: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   3979: aconst_null
    //   3980: putfield 525	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   3983: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3986: astore_1
    //   3987: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   3990: astore_1
    //   3991: ldc_w 2183
    //   3994: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3997: return
    //   3998: iconst_0
    //   3999: istore_3
    //   4000: goto -45 -> 3955
    //   4003: new 763	com/tencent/mm/protocal/protobuf/bgh
    //   4006: dup
    //   4007: invokespecial 2604	com/tencent/mm/protocal/protobuf/bgh:<init>	()V
    //   4010: astore_2
    //   4011: new 792	com/tencent/mm/protocal/protobuf/FinderContact
    //   4014: dup
    //   4015: invokespecial 2605	com/tencent/mm/protocal/protobuf/FinderContact:<init>	()V
    //   4018: astore 12
    //   4020: aload 12
    //   4022: aload_1
    //   4023: getfield 667	com/tencent/mm/plugin/finder/live/viewmodel/data/h:username	Ljava/lang/String;
    //   4026: putfield 799	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   4029: aload 12
    //   4031: aload_1
    //   4032: getfield 2606	com/tencent/mm/plugin/finder/live/viewmodel/data/h:nickname	Ljava/lang/String;
    //   4035: putfield 795	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   4038: aload 12
    //   4040: aload_1
    //   4041: getfield 2607	com/tencent/mm/plugin/finder/live/viewmodel/data/h:headUrl	Ljava/lang/String;
    //   4044: putfield 798	com/tencent/mm/protocal/protobuf/FinderContact:headUrl	Ljava/lang/String;
    //   4047: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4050: astore 13
    //   4052: aload_2
    //   4053: aload 12
    //   4055: putfield 766	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   4058: aload_2
    //   4059: aload_1
    //   4060: getfield 2737	com/tencent/mm/plugin/finder/live/viewmodel/data/h:EbH	Ljava/lang/String;
    //   4063: putfield 2740	com/tencent/mm/protocal/protobuf/bgh:ZOx	Ljava/lang/String;
    //   4066: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4069: astore 12
    //   4071: aload_0
    //   4072: ldc_w 517
    //   4075: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4078: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4081: iconst_2
    //   4082: putfield 681	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efy	I
    //   4085: aload_0
    //   4086: getfield 502	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejl	Lcom/tencent/mm/plugin/finder/live/plugin/q;
    //   4089: astore 12
    //   4091: aload 12
    //   4093: ifnull +13 -> 4106
    //   4096: aload 12
    //   4098: invokevirtual 1923	com/tencent/mm/plugin/finder/live/plugin/q:epo	()V
    //   4101: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4104: astore 12
    //   4106: getstatic 673	com/tencent/mm/plugin/finder/live/model/mic/b:CMY	Lcom/tencent/mm/plugin/finder/live/model/mic/b;
    //   4109: astore 12
    //   4111: invokestatic 2743	com/tencent/mm/plugin/finder/live/model/mic/b:ene	()V
    //   4114: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   4117: astore 12
    //   4119: invokestatic 1791	com/tencent/mm/plugin/finder/live/model/aj:getFinderLiveAssistant	()Lcom/tencent/mm/plugin/finder/live/model/ap;
    //   4122: astore 12
    //   4124: aload 12
    //   4126: ifnull +118 -> 4244
    //   4129: aload_0
    //   4130: ldc_w 740
    //   4133: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4136: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4139: getfield 748	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   4142: getfield 754	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   4145: lstore 8
    //   4147: aload_0
    //   4148: ldc_w 740
    //   4151: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4154: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4157: getfield 1327	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:hKN	J
    //   4160: lstore 10
    //   4162: aload_0
    //   4163: ldc_w 740
    //   4166: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4169: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4172: getfield 2308	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:nonceId	Ljava/lang/String;
    //   4175: astore 13
    //   4177: aload_0
    //   4178: ldc_w 740
    //   4181: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4184: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4187: getfield 1983	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:mZp	[B
    //   4190: astore 14
    //   4192: getstatic 2616	com/tencent/mm/live/model/l$k:mYO	Lcom/tencent/mm/live/model/l$k;
    //   4195: astore 15
    //   4197: aload 12
    //   4199: lload 8
    //   4201: lload 10
    //   4203: aload 13
    //   4205: aload 14
    //   4207: invokestatic 2619	com/tencent/mm/live/model/l$k:bhG	()I
    //   4210: aload_2
    //   4211: aload_1
    //   4212: getfield 550	com/tencent/mm/plugin/finder/live/viewmodel/data/h:mXL	Ljava/lang/String;
    //   4215: aload_1
    //   4216: getfield 541	com/tencent/mm/plugin/finder/live/viewmodel/data/h:mXz	I
    //   4219: aload_1
    //   4220: getfield 575	com/tencent/mm/plugin/finder/live/viewmodel/data/h:sessionId	Ljava/lang/String;
    //   4223: aconst_null
    //   4224: new 89	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$x
    //   4227: dup
    //   4228: aload_0
    //   4229: invokespecial 2744	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$x:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;)V
    //   4232: checkcast 2746	com/tencent/mm/plugin/finder/live/model/cgi/b$a
    //   4235: invokeinterface 2749 14 0
    //   4240: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4243: astore_2
    //   4244: aload_0
    //   4245: ldc_w 517
    //   4248: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4251: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4254: getfield 2729	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Eft	Ljava/util/List;
    //   4257: astore_2
    //   4258: aload_2
    //   4259: ifnull -276 -> 3983
    //   4262: aload_2
    //   4263: new 91	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$y
    //   4266: dup
    //   4267: aload_1
    //   4268: invokespecial 2751	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$y:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;)V
    //   4271: checkcast 1986	kotlin/g/a/b
    //   4274: invokestatic 2754	com/tencent/mm/ae/d:a	(Ljava/util/List;Lkotlin/g/a/b;)Z
    //   4277: pop
    //   4278: goto -295 -> 3983
    //   4281: aload_0
    //   4282: ldc_w 517
    //   4285: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4288: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4291: iconst_5
    //   4292: putfield 681	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efy	I
    //   4295: new 2756	com/tencent/mm/protocal/protobuf/bln
    //   4298: dup
    //   4299: invokespecial 2757	com/tencent/mm/protocal/protobuf/bln:<init>	()V
    //   4302: checkcast 1782	com/tencent/mm/bx/a
    //   4305: astore_2
    //   4306: aload 12
    //   4308: ifnonnull +112 -> 4420
    //   4311: aconst_null
    //   4312: astore_1
    //   4313: aload_2
    //   4314: aload_1
    //   4315: invokevirtual 2701	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   4318: pop
    //   4319: aload_2
    //   4320: astore_1
    //   4321: aload_1
    //   4322: checkcast 2756	com/tencent/mm/protocal/protobuf/bln
    //   4325: astore_1
    //   4326: aload_0
    //   4327: getfield 1915	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejm	Lcom/tencent/mm/plugin/finder/live/plugin/bs;
    //   4330: astore_2
    //   4331: aload_2
    //   4332: ifnull +21 -> 4353
    //   4335: aload_1
    //   4336: ifnonnull +119 -> 4455
    //   4339: aconst_null
    //   4340: astore_1
    //   4341: aload_2
    //   4342: aload_1
    //   4343: checkcast 598	java/util/List
    //   4346: invokevirtual 2760	com/tencent/mm/plugin/finder/live/plugin/bs:gD	(Ljava/util/List;)V
    //   4349: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4352: astore_1
    //   4353: aload_0
    //   4354: ldc_w 517
    //   4357: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4360: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4363: getfield 2763	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfL	I
    //   4366: ifle +97 -> 4463
    //   4369: aload_0
    //   4370: ldc_w 517
    //   4373: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4376: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4379: getfield 2763	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfL	I
    //   4382: istore_3
    //   4383: aload_0
    //   4384: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   4387: ldc_w 2765
    //   4390: iload_3
    //   4391: invokestatic 1110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4394: invokestatic 1262	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   4397: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4400: getstatic 673	com/tencent/mm/plugin/finder/live/model/mic/b:CMY	Lcom/tencent/mm/plugin/finder/live/model/mic/b;
    //   4403: astore_1
    //   4404: iload_3
    //   4405: i2l
    //   4406: ldc2_w 2766
    //   4409: lmul
    //   4410: invokestatic 2770	com/tencent/mm/plugin/finder/live/model/mic/b:om	(J)V
    //   4413: ldc_w 2183
    //   4416: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4419: return
    //   4420: aload 12
    //   4422: ldc_w 2772
    //   4425: invokevirtual 2259	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   4428: astore_1
    //   4429: goto -116 -> 4313
    //   4432: astore_1
    //   4433: ldc_w 2718
    //   4436: ldc_w 551
    //   4439: iconst_1
    //   4440: anewarray 2720	java/lang/Object
    //   4443: dup
    //   4444: iconst_0
    //   4445: aload_1
    //   4446: aastore
    //   4447: invokestatic 2724	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4450: aconst_null
    //   4451: astore_1
    //   4452: goto -131 -> 4321
    //   4455: aload_1
    //   4456: getfield 2775	com/tencent/mm/protocal/protobuf/bln:ZUE	Ljava/util/LinkedList;
    //   4459: astore_1
    //   4460: goto -119 -> 4341
    //   4463: bipush 20
    //   4465: istore_3
    //   4466: goto -83 -> 4383
    //   4469: aload_0
    //   4470: getfield 2777	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejs	Lcom/tencent/mm/plugin/finder/live/plugin/cb;
    //   4473: astore_1
    //   4474: aload_1
    //   4475: ifnull +32 -> 4507
    //   4478: aload_1
    //   4479: iconst_0
    //   4480: invokevirtual 2780	com/tencent/mm/plugin/finder/live/plugin/cb:tO	(I)V
    //   4483: aload_1
    //   4484: getfield 2783	com/tencent/mm/plugin/finder/live/plugin/cb:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   4487: invokevirtual 2785	com/tencent/mm/sdk/platformtools/MTimerHandler:stopTimer	()V
    //   4490: aload_1
    //   4491: getfield 2783	com/tencent/mm/plugin/finder/live/plugin/cb:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   4494: ldc2_w 2766
    //   4497: ldc2_w 2766
    //   4500: invokevirtual 2787	com/tencent/mm/sdk/platformtools/MTimerHandler:startTimer	(JJ)V
    //   4503: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4506: astore_1
    //   4507: ldc_w 2183
    //   4510: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4513: return
    //   4514: aload 12
    //   4516: ifnonnull +51 -> 4567
    //   4519: iconst_0
    //   4520: istore 7
    //   4522: aload_0
    //   4523: ldc_w 559
    //   4526: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4529: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   4532: iload 7
    //   4534: putfield 2790	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:Eem	Z
    //   4537: iload 7
    //   4539: ifeq +42 -> 4581
    //   4542: aload_0
    //   4543: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   4546: astore_1
    //   4547: aload_1
    //   4548: ifnull +12 -> 4560
    //   4551: aload_1
    //   4552: iconst_1
    //   4553: invokevirtual 2793	com/tencent/mm/live/core/core/a/b:fI	(Z)V
    //   4556: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4559: astore_1
    //   4560: ldc_w 2183
    //   4563: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4566: return
    //   4567: aload 12
    //   4569: ldc_w 2795
    //   4572: iconst_0
    //   4573: invokevirtual 2230	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   4576: istore 7
    //   4578: goto -56 -> 4522
    //   4581: aload_0
    //   4582: getfield 529	com/tencent/mm/plugin/finder/live/component/statecomponent/a:ngB	Lcom/tencent/mm/live/core/core/a/b;
    //   4585: astore_1
    //   4586: aload_1
    //   4587: ifnull +12 -> 4599
    //   4590: aload_1
    //   4591: iconst_0
    //   4592: invokevirtual 2793	com/tencent/mm/live/core/core/a/b:fI	(Z)V
    //   4595: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4598: astore_1
    //   4599: ldc_w 2183
    //   4602: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4605: return
    //   4606: aload_0
    //   4607: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   4610: ldc_w 2797
    //   4613: aload_0
    //   4614: ldc_w 517
    //   4617: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4620: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4623: invokevirtual 2801	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyS	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   4626: invokestatic 1262	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   4629: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4632: aload_0
    //   4633: ldc_w 517
    //   4636: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4639: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4642: invokevirtual 2801	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyS	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   4645: astore_1
    //   4646: aload_1
    //   4647: ifnull +180 -> 4827
    //   4650: new 763	com/tencent/mm/protocal/protobuf/bgh
    //   4653: dup
    //   4654: invokespecial 2604	com/tencent/mm/protocal/protobuf/bgh:<init>	()V
    //   4657: astore_2
    //   4658: new 792	com/tencent/mm/protocal/protobuf/FinderContact
    //   4661: dup
    //   4662: invokespecial 2605	com/tencent/mm/protocal/protobuf/FinderContact:<init>	()V
    //   4665: astore 12
    //   4667: aload 12
    //   4669: aload_1
    //   4670: invokevirtual 2802	com/tencent/mm/plugin/finder/live/viewmodel/data/h:getNickname	()Ljava/lang/String;
    //   4673: putfield 795	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   4676: aload 12
    //   4678: aload_1
    //   4679: invokevirtual 2805	com/tencent/mm/plugin/finder/live/viewmodel/data/h:getUsername	()Ljava/lang/String;
    //   4682: putfield 799	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   4685: aload 12
    //   4687: aload_1
    //   4688: invokevirtual 2808	com/tencent/mm/plugin/finder/live/viewmodel/data/h:exZ	()Ljava/lang/String;
    //   4691: putfield 798	com/tencent/mm/protocal/protobuf/FinderContact:headUrl	Ljava/lang/String;
    //   4694: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4697: astore 13
    //   4699: aload_2
    //   4700: aload 12
    //   4702: putfield 766	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   4705: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4708: astore 12
    //   4710: invokestatic 2809	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:getFinderLiveAssistant	()Lcom/tencent/mm/plugin/finder/live/model/ap;
    //   4713: astore 12
    //   4715: aload 12
    //   4717: ifnull +110 -> 4827
    //   4720: aload_0
    //   4721: ldc_w 740
    //   4724: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4727: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4730: invokevirtual 2813	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:getLiveInfo	()Lcom/tencent/mm/protocal/protobuf/bip;
    //   4733: getfield 754	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   4736: lstore 8
    //   4738: aload_0
    //   4739: ldc_w 740
    //   4742: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4745: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4748: invokevirtual 2816	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:ecI	()J
    //   4751: lstore 10
    //   4753: aload_0
    //   4754: ldc_w 740
    //   4757: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4760: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4763: invokevirtual 2819	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:getNonceId	()Ljava/lang/String;
    //   4766: astore 13
    //   4768: aload_0
    //   4769: ldc_w 740
    //   4772: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4775: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   4778: invokevirtual 2822	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:bid	()[B
    //   4781: astore 14
    //   4783: getstatic 2616	com/tencent/mm/live/model/l$k:mYO	Lcom/tencent/mm/live/model/l$k;
    //   4786: astore 15
    //   4788: aload 12
    //   4790: lload 8
    //   4792: lload 10
    //   4794: aload 13
    //   4796: aload 14
    //   4798: invokestatic 2619	com/tencent/mm/live/model/l$k:bhG	()I
    //   4801: aload_2
    //   4802: aload_1
    //   4803: invokevirtual 2825	com/tencent/mm/plugin/finder/live/viewmodel/data/h:getSessionId	()Ljava/lang/String;
    //   4806: new 93	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$z
    //   4809: dup
    //   4810: aload_0
    //   4811: aload_2
    //   4812: invokespecial 2826	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$z:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;Lcom/tencent/mm/protocal/protobuf/bgh;)V
    //   4815: checkcast 2828	com/tencent/mm/plugin/finder/live/model/cgi/q$a
    //   4818: invokeinterface 2831 11 0
    //   4823: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4826: astore_1
    //   4827: ldc_w 2183
    //   4830: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4833: return
    //   4834: aload_0
    //   4835: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   4838: ldc_w 2833
    //   4841: aload_0
    //   4842: ldc_w 517
    //   4845: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4848: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4851: invokevirtual 2837	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyZ	()Lcom/tencent/mm/plugin/finder/live/model/i;
    //   4854: invokestatic 1262	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   4857: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4860: aload_0
    //   4861: ldc_w 517
    //   4864: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4867: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4870: invokevirtual 2837	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyZ	()Lcom/tencent/mm/plugin/finder/live/model/i;
    //   4873: astore 12
    //   4875: aload 12
    //   4877: ifnull +242 -> 5119
    //   4880: aload 12
    //   4882: aload_0
    //   4883: ldc_w 559
    //   4886: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4889: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   4892: invokevirtual 2840	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyh	()Ljava/lang/String;
    //   4895: invokevirtual 2844	com/tencent/mm/plugin/finder/live/model/i:awt	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/live/viewmodel/data/e;
    //   4898: astore 15
    //   4900: new 763	com/tencent/mm/protocal/protobuf/bgh
    //   4903: dup
    //   4904: invokespecial 2604	com/tencent/mm/protocal/protobuf/bgh:<init>	()V
    //   4907: astore 13
    //   4909: new 792	com/tencent/mm/protocal/protobuf/FinderContact
    //   4912: dup
    //   4913: invokespecial 2605	com/tencent/mm/protocal/protobuf/FinderContact:<init>	()V
    //   4916: astore 14
    //   4918: aload_0
    //   4919: ldc_w 517
    //   4922: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4925: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4928: invokevirtual 2801	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyS	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   4931: astore_1
    //   4932: aload_1
    //   4933: ifnonnull +193 -> 5126
    //   4936: ldc_w 551
    //   4939: astore_1
    //   4940: aload 14
    //   4942: aload_1
    //   4943: putfield 795	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   4946: aload 15
    //   4948: ifnonnull +196 -> 5144
    //   4951: ldc_w 551
    //   4954: astore_1
    //   4955: aload 14
    //   4957: aload_1
    //   4958: putfield 799	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   4961: aload_0
    //   4962: ldc_w 517
    //   4965: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   4968: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   4971: invokevirtual 2801	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyS	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   4974: astore_1
    //   4975: aload_1
    //   4976: ifnonnull +187 -> 5163
    //   4979: ldc_w 551
    //   4982: astore_1
    //   4983: aload 14
    //   4985: aload_1
    //   4986: putfield 798	com/tencent/mm/protocal/protobuf/FinderContact:headUrl	Ljava/lang/String;
    //   4989: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   4992: astore_1
    //   4993: aload 13
    //   4995: aload 14
    //   4997: putfield 766	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   5000: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5003: astore_1
    //   5004: invokestatic 2809	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:getFinderLiveAssistant	()Lcom/tencent/mm/plugin/finder/live/model/ap;
    //   5007: astore_1
    //   5008: aload_1
    //   5009: ifnull +110 -> 5119
    //   5012: aload_0
    //   5013: ldc_w 740
    //   5016: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5019: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   5022: invokevirtual 2813	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:getLiveInfo	()Lcom/tencent/mm/protocal/protobuf/bip;
    //   5025: getfield 754	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   5028: lstore 8
    //   5030: aload_0
    //   5031: ldc_w 740
    //   5034: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5037: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   5040: invokevirtual 2816	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:ecI	()J
    //   5043: lstore 10
    //   5045: aload_0
    //   5046: ldc_w 740
    //   5049: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5052: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   5055: invokevirtual 2819	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:getNonceId	()Ljava/lang/String;
    //   5058: astore_2
    //   5059: aload_0
    //   5060: ldc_w 740
    //   5063: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5066: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   5069: invokevirtual 2822	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:bid	()[B
    //   5072: astore 14
    //   5074: getstatic 2616	com/tencent/mm/live/model/l$k:mYO	Lcom/tencent/mm/live/model/l$k;
    //   5077: astore 15
    //   5079: aload_1
    //   5080: lload 8
    //   5082: lload 10
    //   5084: aload_2
    //   5085: aload 14
    //   5087: invokestatic 2619	com/tencent/mm/live/model/l$k:bhG	()I
    //   5090: aload 13
    //   5092: aload 12
    //   5094: invokevirtual 2847	com/tencent/mm/plugin/finder/live/model/i:ekA	()Ljava/lang/String;
    //   5097: new 9	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$aa
    //   5100: dup
    //   5101: aload_0
    //   5102: aload 13
    //   5104: invokespecial 2848	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$aa:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;Lcom/tencent/mm/protocal/protobuf/bgh;)V
    //   5107: checkcast 2850	com/tencent/mm/plugin/finder/live/model/cgi/p$a
    //   5110: invokeinterface 2853 11 0
    //   5115: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5118: astore_1
    //   5119: ldc_w 2183
    //   5122: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5125: return
    //   5126: aload_1
    //   5127: invokevirtual 2802	com/tencent/mm/plugin/finder/live/viewmodel/data/h:getNickname	()Ljava/lang/String;
    //   5130: astore_2
    //   5131: aload_2
    //   5132: astore_1
    //   5133: aload_2
    //   5134: ifnonnull -194 -> 4940
    //   5137: ldc_w 551
    //   5140: astore_1
    //   5141: goto -201 -> 4940
    //   5144: aload 15
    //   5146: invokevirtual 2854	com/tencent/mm/plugin/finder/live/viewmodel/data/e:getUsername	()Ljava/lang/String;
    //   5149: astore_2
    //   5150: aload_2
    //   5151: astore_1
    //   5152: aload_2
    //   5153: ifnonnull -198 -> 4955
    //   5156: ldc_w 551
    //   5159: astore_1
    //   5160: goto -205 -> 4955
    //   5163: aload_1
    //   5164: invokevirtual 2808	com/tencent/mm/plugin/finder/live/viewmodel/data/h:exZ	()Ljava/lang/String;
    //   5167: astore_2
    //   5168: aload_2
    //   5169: astore_1
    //   5170: aload_2
    //   5171: ifnonnull -188 -> 4983
    //   5174: ldc_w 551
    //   5177: astore_1
    //   5178: goto -195 -> 4983
    //   5181: aload_0
    //   5182: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   5185: new 758	java/lang/StringBuilder
    //   5188: dup
    //   5189: ldc_w 2856
    //   5192: invokespecial 761	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5195: aload_0
    //   5196: ldc_w 517
    //   5199: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5202: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   5205: invokevirtual 2837	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyZ	()Lcom/tencent/mm/plugin/finder/live/model/i;
    //   5208: invokevirtual 770	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5211: ldc_w 2858
    //   5214: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5217: aload_0
    //   5218: ldc_w 517
    //   5221: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5224: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   5227: invokevirtual 2801	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyS	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   5230: invokevirtual 770	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5233: invokevirtual 777	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5236: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5239: aload_0
    //   5240: ldc_w 517
    //   5243: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5246: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   5249: invokevirtual 2801	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyS	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   5252: astore 12
    //   5254: aload 12
    //   5256: ifnull +243 -> 5499
    //   5259: aload_0
    //   5260: ldc_w 517
    //   5263: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5266: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   5269: invokevirtual 2837	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyZ	()Lcom/tencent/mm/plugin/finder/live/model/i;
    //   5272: astore_1
    //   5273: aload_1
    //   5274: ifnonnull +232 -> 5506
    //   5277: aconst_null
    //   5278: astore_1
    //   5279: aload 12
    //   5281: invokevirtual 2805	com/tencent/mm/plugin/finder/live/viewmodel/data/h:getUsername	()Ljava/lang/String;
    //   5284: astore_2
    //   5285: aload_1
    //   5286: ifnonnull +241 -> 5527
    //   5289: aconst_null
    //   5290: astore_1
    //   5291: aload_2
    //   5292: aload_1
    //   5293: invokestatic 2636	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   5296: ifeq +195 -> 5491
    //   5299: new 763	com/tencent/mm/protocal/protobuf/bgh
    //   5302: dup
    //   5303: invokespecial 2604	com/tencent/mm/protocal/protobuf/bgh:<init>	()V
    //   5306: astore_2
    //   5307: new 792	com/tencent/mm/protocal/protobuf/FinderContact
    //   5310: dup
    //   5311: invokespecial 2605	com/tencent/mm/protocal/protobuf/FinderContact:<init>	()V
    //   5314: astore_1
    //   5315: aload_1
    //   5316: aload 12
    //   5318: invokevirtual 2802	com/tencent/mm/plugin/finder/live/viewmodel/data/h:getNickname	()Ljava/lang/String;
    //   5321: putfield 795	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   5324: aload_1
    //   5325: aload 12
    //   5327: invokevirtual 2805	com/tencent/mm/plugin/finder/live/viewmodel/data/h:getUsername	()Ljava/lang/String;
    //   5330: putfield 799	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   5333: aload_1
    //   5334: aload 12
    //   5336: invokevirtual 2808	com/tencent/mm/plugin/finder/live/viewmodel/data/h:exZ	()Ljava/lang/String;
    //   5339: putfield 798	com/tencent/mm/protocal/protobuf/FinderContact:headUrl	Ljava/lang/String;
    //   5342: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5345: astore 12
    //   5347: aload_2
    //   5348: aload_1
    //   5349: putfield 766	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   5352: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5355: astore_1
    //   5356: invokestatic 2809	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:getFinderLiveAssistant	()Lcom/tencent/mm/plugin/finder/live/model/ap;
    //   5359: astore 12
    //   5361: aload 12
    //   5363: ifnull +128 -> 5491
    //   5366: aload_0
    //   5367: ldc_w 740
    //   5370: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5373: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   5376: invokevirtual 2813	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:getLiveInfo	()Lcom/tencent/mm/protocal/protobuf/bip;
    //   5379: getfield 754	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   5382: lstore 8
    //   5384: aload_0
    //   5385: ldc_w 740
    //   5388: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5391: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   5394: invokevirtual 2816	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:ecI	()J
    //   5397: lstore 10
    //   5399: aload_0
    //   5400: ldc_w 740
    //   5403: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5406: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   5409: invokevirtual 2819	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:getNonceId	()Ljava/lang/String;
    //   5412: astore 13
    //   5414: aload_0
    //   5415: ldc_w 740
    //   5418: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5421: checkcast 740	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   5424: invokevirtual 2822	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:bid	()[B
    //   5427: astore 14
    //   5429: getstatic 2616	com/tencent/mm/live/model/l$k:mYO	Lcom/tencent/mm/live/model/l$k;
    //   5432: astore_1
    //   5433: invokestatic 2619	com/tencent/mm/live/model/l$k:bhG	()I
    //   5436: istore_3
    //   5437: aload_0
    //   5438: ldc_w 517
    //   5441: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5444: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   5447: invokevirtual 2837	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyZ	()Lcom/tencent/mm/plugin/finder/live/model/i;
    //   5450: astore_1
    //   5451: aload_1
    //   5452: ifnonnull +83 -> 5535
    //   5455: aconst_null
    //   5456: astore_1
    //   5457: aload 12
    //   5459: lload 8
    //   5461: lload 10
    //   5463: aload 13
    //   5465: aload 14
    //   5467: iload_3
    //   5468: aload_2
    //   5469: aload_1
    //   5470: new 11	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ab
    //   5473: dup
    //   5474: aload_0
    //   5475: aload_2
    //   5476: invokespecial 2859	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ab:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;Lcom/tencent/mm/protocal/protobuf/bgh;)V
    //   5479: checkcast 2861	com/tencent/mm/plugin/finder/live/model/cgi/v$a
    //   5482: invokeinterface 2864 11 0
    //   5487: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5490: astore_1
    //   5491: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5494: astore_1
    //   5495: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5498: astore_1
    //   5499: ldc_w 2183
    //   5502: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5505: return
    //   5506: aload_1
    //   5507: aload_0
    //   5508: ldc_w 559
    //   5511: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   5514: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   5517: invokevirtual 2840	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyh	()Ljava/lang/String;
    //   5520: invokevirtual 2844	com/tencent/mm/plugin/finder/live/model/i:awt	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/live/viewmodel/data/e;
    //   5523: astore_1
    //   5524: goto -245 -> 5279
    //   5527: aload_1
    //   5528: invokevirtual 2854	com/tencent/mm/plugin/finder/live/viewmodel/data/e:getUsername	()Ljava/lang/String;
    //   5531: astore_1
    //   5532: goto -241 -> 5291
    //   5535: aload_1
    //   5536: invokevirtual 2847	com/tencent/mm/plugin/finder/live/model/i:ekA	()Ljava/lang/String;
    //   5539: astore_1
    //   5540: goto -83 -> 5457
    //   5543: aload 12
    //   5545: ifnonnull +69 -> 5614
    //   5548: aconst_null
    //   5549: astore_1
    //   5550: aload 12
    //   5552: ifnonnull +121 -> 5673
    //   5555: aconst_null
    //   5556: astore_2
    //   5557: aload 12
    //   5559: ifnonnull +126 -> 5685
    //   5562: aconst_null
    //   5563: astore 12
    //   5565: aload_0
    //   5566: invokespecial 2866	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ezq	()Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   5569: astore 13
    //   5571: aload 13
    //   5573: ifnull +16 -> 5589
    //   5576: aload 13
    //   5578: aload_2
    //   5579: aload 12
    //   5581: aload_1
    //   5582: invokevirtual 2871	com/tencent/mm/plugin/finder/live/plugin/l:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/bgq;)V
    //   5585: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5588: astore_1
    //   5589: aload_0
    //   5590: invokespecial 2866	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ezq	()Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   5593: astore_1
    //   5594: aload_1
    //   5595: ifnull +12 -> 5607
    //   5598: aload_1
    //   5599: iconst_0
    //   5600: invokevirtual 2872	com/tencent/mm/plugin/finder/live/plugin/l:tO	(I)V
    //   5603: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5606: astore_1
    //   5607: ldc_w 2183
    //   5610: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5613: return
    //   5614: aload 12
    //   5616: ldc_w 989
    //   5619: invokevirtual 2259	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   5622: astore_2
    //   5623: aload_2
    //   5624: ifnonnull +8 -> 5632
    //   5627: aconst_null
    //   5628: astore_1
    //   5629: goto -79 -> 5550
    //   5632: new 991	com/tencent/mm/protocal/protobuf/bgq
    //   5635: dup
    //   5636: invokespecial 2873	com/tencent/mm/protocal/protobuf/bgq:<init>	()V
    //   5639: astore_1
    //   5640: aload_1
    //   5641: aload_2
    //   5642: invokevirtual 2874	com/tencent/mm/protocal/protobuf/bgq:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   5645: pop
    //   5646: goto -96 -> 5550
    //   5649: astore_1
    //   5650: aload_0
    //   5651: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   5654: ldc_w 2876
    //   5657: iconst_1
    //   5658: anewarray 2720	java/lang/Object
    //   5661: dup
    //   5662: iconst_0
    //   5663: aload_1
    //   5664: aastore
    //   5665: invokestatic 2878	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5668: aconst_null
    //   5669: astore_1
    //   5670: goto -24 -> 5646
    //   5673: aload 12
    //   5675: ldc_w 2880
    //   5678: invokevirtual 2632	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5681: astore_2
    //   5682: goto -125 -> 5557
    //   5685: aload 12
    //   5687: ldc_w 2882
    //   5690: invokevirtual 2632	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5693: astore 12
    //   5695: goto -130 -> 5565
    //   5698: aload 12
    //   5700: ifnonnull +812 -> 6512
    //   5703: aconst_null
    //   5704: astore_1
    //   5705: aload 12
    //   5707: ifnonnull +867 -> 6574
    //   5710: iconst_0
    //   5711: istore_3
    //   5712: aload_0
    //   5713: invokevirtual 2886	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ejl	()Lcom/tencent/mm/plugin/finder/live/view/router/a;
    //   5716: astore 12
    //   5718: aload 12
    //   5720: ifnull +19 -> 5739
    //   5723: aload 12
    //   5725: checkcast 1934	com/tencent/mm/plugin/finder/live/view/a
    //   5728: iconst_0
    //   5729: iconst_1
    //   5730: aconst_null
    //   5731: invokestatic 2889	com/tencent/mm/plugin/finder/live/view/a:hideLoadingLayer$default	(Lcom/tencent/mm/plugin/finder/live/view/a;ZILjava/lang/Object;)V
    //   5734: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5737: astore 12
    //   5739: aload_0
    //   5740: getfield 2891	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiP	Lcom/tencent/mm/live/b/y;
    //   5743: astore 12
    //   5745: aload 12
    //   5747: ifnull +15 -> 5762
    //   5750: aload 12
    //   5752: bipush 8
    //   5754: invokevirtual 2894	com/tencent/mm/live/b/y:tO	(I)V
    //   5757: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5760: astore 12
    //   5762: aload_0
    //   5763: getfield 1464	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiO	Lcom/tencent/mm/plugin/finder/live/plugin/y;
    //   5766: astore 12
    //   5768: aload 12
    //   5770: ifnull +15 -> 5785
    //   5773: aload 12
    //   5775: bipush 8
    //   5777: invokevirtual 2279	com/tencent/mm/plugin/finder/live/plugin/y:tO	(I)V
    //   5780: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5783: astore 12
    //   5785: aload_0
    //   5786: getfield 2062	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiQ	Lcom/tencent/mm/plugin/finder/live/plugin/cd;
    //   5789: astore 12
    //   5791: aload 12
    //   5793: ifnull +15 -> 5808
    //   5796: aload 12
    //   5798: bipush 8
    //   5800: invokevirtual 2897	com/tencent/mm/plugin/finder/live/plugin/cd:tO	(I)V
    //   5803: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5806: astore 12
    //   5808: aload_0
    //   5809: getfield 1850	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiR	Lcom/tencent/mm/plugin/finder/live/plugin/aj;
    //   5812: astore 12
    //   5814: aload 12
    //   5816: ifnull +15 -> 5831
    //   5819: aload 12
    //   5821: bipush 8
    //   5823: invokevirtual 2898	com/tencent/mm/plugin/finder/live/plugin/aj:tO	(I)V
    //   5826: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5829: astore 12
    //   5831: aload_0
    //   5832: getfield 2275	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiS	Lcom/tencent/mm/plugin/finder/live/plugin/bt;
    //   5835: astore 12
    //   5837: aload 12
    //   5839: ifnull +15 -> 5854
    //   5842: aload 12
    //   5844: bipush 8
    //   5846: invokevirtual 2278	com/tencent/mm/plugin/finder/live/plugin/bt:tO	(I)V
    //   5849: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5852: astore 12
    //   5854: aload_0
    //   5855: getfield 870	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:DcS	Lcom/tencent/mm/plugin/finder/live/plugin/ah;
    //   5858: astore 12
    //   5860: aload 12
    //   5862: ifnull +15 -> 5877
    //   5865: aload 12
    //   5867: bipush 8
    //   5869: invokevirtual 2901	com/tencent/mm/plugin/finder/live/plugin/ah:tO	(I)V
    //   5872: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5875: astore 12
    //   5877: aload_0
    //   5878: getfield 2903	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiT	Lcom/tencent/mm/plugin/finder/live/plugin/j;
    //   5881: astore 12
    //   5883: aload 12
    //   5885: ifnull +15 -> 5900
    //   5888: aload 12
    //   5890: bipush 8
    //   5892: invokevirtual 2906	com/tencent/mm/plugin/finder/live/plugin/j:tO	(I)V
    //   5895: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5898: astore 12
    //   5900: aload_0
    //   5901: getfield 2908	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiU	Lcom/tencent/mm/plugin/finder/live/plugin/bd;
    //   5904: astore 12
    //   5906: aload 12
    //   5908: ifnull +15 -> 5923
    //   5911: aload 12
    //   5913: bipush 8
    //   5915: invokevirtual 2911	com/tencent/mm/plugin/finder/live/plugin/bd:tO	(I)V
    //   5918: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5921: astore 12
    //   5923: aload_0
    //   5924: getfield 2913	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiV	Lcom/tencent/mm/plugin/finder/live/plugin/bk;
    //   5927: astore 12
    //   5929: aload 12
    //   5931: ifnull +15 -> 5946
    //   5934: aload 12
    //   5936: bipush 8
    //   5938: invokevirtual 2916	com/tencent/mm/plugin/finder/live/plugin/bk:tO	(I)V
    //   5941: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5944: astore 12
    //   5946: aload_0
    //   5947: getfield 1421	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiW	Lcom/tencent/mm/plugin/finder/live/plugin/az;
    //   5950: astore 12
    //   5952: aload 12
    //   5954: ifnull +15 -> 5969
    //   5957: aload 12
    //   5959: bipush 8
    //   5961: invokevirtual 2917	com/tencent/mm/plugin/finder/live/plugin/az:tO	(I)V
    //   5964: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5967: astore 12
    //   5969: aload_0
    //   5970: getfield 2919	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiX	Lcom/tencent/mm/plugin/finder/live/plugin/bg;
    //   5973: astore 12
    //   5975: aload 12
    //   5977: ifnull +15 -> 5992
    //   5980: aload 12
    //   5982: bipush 8
    //   5984: invokevirtual 2922	com/tencent/mm/plugin/finder/live/plugin/bg:tO	(I)V
    //   5987: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   5990: astore 12
    //   5992: aload_0
    //   5993: getfield 2053	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejb	Lcom/tencent/mm/plugin/finder/live/plugin/cf;
    //   5996: astore 12
    //   5998: aload 12
    //   6000: ifnull +15 -> 6015
    //   6003: aload 12
    //   6005: bipush 8
    //   6007: invokevirtual 2923	com/tencent/mm/plugin/finder/live/plugin/cf:tO	(I)V
    //   6010: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6013: astore 12
    //   6015: aload_0
    //   6016: getfield 1432	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejc	Lcom/tencent/mm/plugin/finder/live/plugin/o;
    //   6019: astore 12
    //   6021: aload 12
    //   6023: ifnull +15 -> 6038
    //   6026: aload 12
    //   6028: bipush 8
    //   6030: invokevirtual 2924	com/tencent/mm/plugin/finder/live/plugin/o:tO	(I)V
    //   6033: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6036: astore 12
    //   6038: aload_0
    //   6039: getfield 2926	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EiZ	Lcom/tencent/mm/plugin/finder/live/plugin/br;
    //   6042: astore 12
    //   6044: aload 12
    //   6046: ifnull +15 -> 6061
    //   6049: aload 12
    //   6051: bipush 8
    //   6053: invokevirtual 2929	com/tencent/mm/plugin/finder/live/plugin/br:tO	(I)V
    //   6056: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6059: astore 12
    //   6061: aload_0
    //   6062: getfield 1384	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Eja	Lcom/tencent/mm/plugin/finder/live/plugin/bz;
    //   6065: astore 12
    //   6067: aload 12
    //   6069: ifnull +15 -> 6084
    //   6072: aload 12
    //   6074: bipush 8
    //   6076: invokevirtual 2930	com/tencent/mm/plugin/finder/live/plugin/bz:tO	(I)V
    //   6079: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6082: astore 12
    //   6084: aload_0
    //   6085: getfield 502	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejl	Lcom/tencent/mm/plugin/finder/live/plugin/q;
    //   6088: astore 12
    //   6090: aload 12
    //   6092: ifnull +15 -> 6107
    //   6095: aload 12
    //   6097: bipush 8
    //   6099: invokevirtual 2931	com/tencent/mm/plugin/finder/live/plugin/q:tO	(I)V
    //   6102: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6105: astore 12
    //   6107: aload_0
    //   6108: getfield 1915	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejm	Lcom/tencent/mm/plugin/finder/live/plugin/bs;
    //   6111: astore 12
    //   6113: aload 12
    //   6115: ifnull +15 -> 6130
    //   6118: aload 12
    //   6120: bipush 8
    //   6122: invokevirtual 2932	com/tencent/mm/plugin/finder/live/plugin/bs:tO	(I)V
    //   6125: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6128: astore 12
    //   6130: aload_0
    //   6131: getfield 1075	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejn	Lcom/tencent/mm/plugin/finder/live/plugin/p;
    //   6134: astore 12
    //   6136: aload 12
    //   6138: ifnull +15 -> 6153
    //   6141: aload 12
    //   6143: bipush 8
    //   6145: invokevirtual 2933	com/tencent/mm/plugin/finder/live/plugin/p:tO	(I)V
    //   6148: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6151: astore 12
    //   6153: aload_0
    //   6154: getfield 2665	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejo	Lcom/tencent/mm/plugin/finder/live/plugin/bf;
    //   6157: astore 12
    //   6159: aload 12
    //   6161: ifnull +15 -> 6176
    //   6164: aload 12
    //   6166: bipush 8
    //   6168: invokevirtual 2934	com/tencent/mm/plugin/finder/live/plugin/bf:tO	(I)V
    //   6171: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6174: astore 12
    //   6176: aload_0
    //   6177: getfield 2936	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejd	Lcom/tencent/mm/plugin/finder/live/plugin/i;
    //   6180: astore 12
    //   6182: aload 12
    //   6184: ifnull +15 -> 6199
    //   6187: aload 12
    //   6189: bipush 8
    //   6191: invokevirtual 2939	com/tencent/mm/plugin/finder/live/plugin/i:tO	(I)V
    //   6194: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6197: astore 12
    //   6199: aload_0
    //   6200: getfield 2941	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejj	Lcom/tencent/mm/plugin/finder/live/plugin/av;
    //   6203: astore 12
    //   6205: aload 12
    //   6207: ifnull +15 -> 6222
    //   6210: aload 12
    //   6212: bipush 8
    //   6214: invokevirtual 2944	com/tencent/mm/plugin/finder/live/plugin/av:tO	(I)V
    //   6217: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6220: astore 12
    //   6222: aload_0
    //   6223: getfield 2695	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejk	Lcom/tencent/mm/plugin/finder/live/plugin/aw;
    //   6226: astore 12
    //   6228: aload 12
    //   6230: ifnull +15 -> 6245
    //   6233: aload 12
    //   6235: bipush 8
    //   6237: invokevirtual 2945	com/tencent/mm/plugin/finder/live/plugin/aw:tO	(I)V
    //   6240: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6243: astore 12
    //   6245: aload_0
    //   6246: getfield 603	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:Ejp	Lcom/tencent/mm/plugin/finder/live/plugin/h;
    //   6249: astore 12
    //   6251: aload 12
    //   6253: ifnull +15 -> 6268
    //   6256: aload 12
    //   6258: bipush 8
    //   6260: invokevirtual 2946	com/tencent/mm/plugin/finder/live/plugin/h:tO	(I)V
    //   6263: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6266: astore 12
    //   6268: aload_0
    //   6269: getfield 2180	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:EjG	Lcom/tencent/mm/plugin/finder/live/plugin/ak;
    //   6272: astore 12
    //   6274: aload 12
    //   6276: ifnull +15 -> 6291
    //   6279: aload 12
    //   6281: bipush 8
    //   6283: invokevirtual 2949	com/tencent/mm/plugin/finder/live/plugin/ak:tO	(I)V
    //   6286: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6289: astore 12
    //   6291: aload_2
    //   6292: getstatic 1026	com/tencent/mm/live/b/b$c:ndT	Lcom/tencent/mm/live/b/b$c;
    //   6295: if_acmpne +291 -> 6586
    //   6298: aload_0
    //   6299: invokespecial 2866	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ezq	()Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   6302: astore_2
    //   6303: aload_2
    //   6304: ifnull +26 -> 6330
    //   6307: aload_2
    //   6308: aload_0
    //   6309: ldc_w 559
    //   6312: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   6315: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   6318: invokevirtual 2840	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyh	()Ljava/lang/String;
    //   6321: aload_1
    //   6322: iload_3
    //   6323: invokevirtual 2952	com/tencent/mm/plugin/finder/live/plugin/l:a	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/bgq;I)V
    //   6326: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6329: astore_2
    //   6330: aload_0
    //   6331: invokespecial 2866	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ezq	()Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   6334: ifnull +66 -> 6400
    //   6337: aload_0
    //   6338: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   6341: ldc_w 2954
    //   6344: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6347: aload_0
    //   6348: ldc_w 2956
    //   6351: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   6354: checkcast 2956	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i
    //   6357: iconst_1
    //   6358: putfield 2959	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i:Efn	Z
    //   6361: aload_0
    //   6362: ldc_w 2956
    //   6365: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   6368: checkcast 2956	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i
    //   6371: aload_1
    //   6372: putfield 2962	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i:Efo	Lcom/tencent/mm/protocal/protobuf/bgq;
    //   6375: aload_0
    //   6376: ldc_w 2956
    //   6379: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   6382: checkcast 2956	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i
    //   6385: iload_3
    //   6386: invokestatic 1110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6389: putfield 2966	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i:Efp	Ljava/lang/Integer;
    //   6392: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6395: astore_1
    //   6396: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6399: astore_1
    //   6400: aload_0
    //   6401: invokespecial 2866	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ezq	()Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   6404: astore_1
    //   6405: aload_1
    //   6406: ifnull +12 -> 6418
    //   6409: aload_1
    //   6410: iconst_0
    //   6411: invokevirtual 2872	com/tencent/mm/plugin/finder/live/plugin/l:tO	(I)V
    //   6414: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6417: astore_1
    //   6418: aload_0
    //   6419: invokevirtual 2970	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:getLiveCore	()Lcom/tencent/mm/live/core/core/a/b;
    //   6422: astore_1
    //   6423: aload_1
    //   6424: ifnull +12 -> 6436
    //   6427: aload_1
    //   6428: iconst_4
    //   6429: invokevirtual 2973	com/tencent/mm/live/core/core/a/b:sY	(I)V
    //   6432: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6435: astore_1
    //   6436: invokestatic 2809	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:getFinderLiveAssistant	()Lcom/tencent/mm/plugin/finder/live/model/ap;
    //   6439: astore_1
    //   6440: aload_1
    //   6441: ifnull +25 -> 6466
    //   6444: aload_1
    //   6445: iconst_1
    //   6446: new 13	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ac
    //   6449: dup
    //   6450: aload_0
    //   6451: invokespecial 2974	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$ac:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;)V
    //   6454: checkcast 1794	kotlin/g/a/s
    //   6457: invokeinterface 2977 3 0
    //   6462: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6465: astore_1
    //   6466: invokestatic 2809	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:getFinderLiveAssistant	()Lcom/tencent/mm/plugin/finder/live/model/ap;
    //   6469: astore_1
    //   6470: aload_1
    //   6471: ifnull +20 -> 6491
    //   6474: aload_1
    //   6475: aload_0
    //   6476: getfield 690	com/tencent/mm/plugin/finder/live/component/statecomponent/a:CCa	Landroidx/appcompat/app/AppCompatActivity;
    //   6479: checkcast 692	android/content/Context
    //   6482: invokeinterface 2981 2 0
    //   6487: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6490: astore_1
    //   6491: getstatic 2987	com/tencent/mm/plugin/finder/live/model/al:CHU	Lcom/tencent/mm/plugin/finder/live/model/al;
    //   6494: astore_1
    //   6495: invokestatic 2990	com/tencent/mm/plugin/finder/live/model/al:eme	()V
    //   6498: getstatic 614	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   6501: astore_1
    //   6502: invokestatic 2993	com/tencent/mm/plugin/finder/live/model/aj:biU	()V
    //   6505: ldc_w 2183
    //   6508: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6511: return
    //   6512: aload 12
    //   6514: ldc_w 989
    //   6517: invokevirtual 2259	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   6520: astore 13
    //   6522: aload 13
    //   6524: ifnonnull +8 -> 6532
    //   6527: aconst_null
    //   6528: astore_1
    //   6529: goto -824 -> 5705
    //   6532: new 991	com/tencent/mm/protocal/protobuf/bgq
    //   6535: dup
    //   6536: invokespecial 2873	com/tencent/mm/protocal/protobuf/bgq:<init>	()V
    //   6539: astore_1
    //   6540: aload_1
    //   6541: aload 13
    //   6543: invokevirtual 2874	com/tencent/mm/protocal/protobuf/bgq:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   6546: pop
    //   6547: goto -842 -> 5705
    //   6550: astore_1
    //   6551: aload_0
    //   6552: getfield 485	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:TAG	Ljava/lang/String;
    //   6555: ldc_w 2876
    //   6558: iconst_1
    //   6559: anewarray 2720	java/lang/Object
    //   6562: dup
    //   6563: iconst_0
    //   6564: aload_1
    //   6565: aastore
    //   6566: invokestatic 2878	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6569: aconst_null
    //   6570: astore_1
    //   6571: goto -24 -> 6547
    //   6574: aload 12
    //   6576: ldc_w 1001
    //   6579: invokevirtual 2996	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   6582: istore_3
    //   6583: goto -871 -> 5712
    //   6586: aload_0
    //   6587: invokespecial 2866	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:ezq	()Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   6590: astore_2
    //   6591: aload_2
    //   6592: ifnull -192 -> 6400
    //   6595: aload_2
    //   6596: aload_0
    //   6597: ldc_w 559
    //   6600: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   6603: checkcast 559	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   6606: invokevirtual 2840	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyh	()Ljava/lang/String;
    //   6609: aload_1
    //   6610: iload_3
    //   6611: invokevirtual 2998	com/tencent/mm/plugin/finder/live/plugin/l:b	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/bgq;I)V
    //   6614: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6617: astore_1
    //   6618: goto -218 -> 6400
    //   6621: aload_0
    //   6622: ldc_w 517
    //   6625: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   6628: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   6631: invokevirtual 2801	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyS	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   6634: ifnull +13 -> 6647
    //   6637: getstatic 3001	com/tencent/mm/live/b/b$c:neB	Lcom/tencent/mm/live/b/b$c;
    //   6640: astore_2
    //   6641: aconst_null
    //   6642: astore 12
    //   6644: goto -6633 -> 11
    //   6647: aload_0
    //   6648: ldc_w 517
    //   6651: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   6654: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   6657: invokevirtual 3005	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyT	()Ljava/util/List;
    //   6660: astore_1
    //   6661: aload_1
    //   6662: ifnull +186 -> 6848
    //   6665: aload_1
    //   6666: checkcast 1393	java/util/Collection
    //   6669: invokeinterface 1396 1 0
    //   6674: ifne +169 -> 6843
    //   6677: iconst_1
    //   6678: istore_3
    //   6679: iload_3
    //   6680: iconst_1
    //   6681: if_icmpne +167 -> 6848
    //   6684: iconst_1
    //   6685: istore_3
    //   6686: iload_3
    //   6687: ifeq -6523 -> 164
    //   6690: aload_0
    //   6691: ldc_w 517
    //   6694: invokevirtual 521	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   6697: checkcast 517	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   6700: invokevirtual 3005	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:eyT	()Ljava/util/List;
    //   6703: astore_1
    //   6704: aload_1
    //   6705: ifnull +86 -> 6791
    //   6708: aload_1
    //   6709: checkcast 1205	java/lang/Iterable
    //   6712: astore_1
    //   6713: aload_1
    //   6714: monitorenter
    //   6715: aload_1
    //   6716: invokeinterface 1209 1 0
    //   6721: astore_2
    //   6722: aload_2
    //   6723: invokeinterface 1215 1 0
    //   6728: ifeq +53 -> 6781
    //   6731: aload_2
    //   6732: invokeinterface 1219 1 0
    //   6737: checkcast 538	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   6740: astore 12
    //   6742: new 838	android/os/Bundle
    //   6745: dup
    //   6746: invokespecial 987	android/os/Bundle:<init>	()V
    //   6749: astore 13
    //   6751: aload 13
    //   6753: ldc_w 2629
    //   6756: aload 12
    //   6758: invokevirtual 2825	com/tencent/mm/plugin/finder/live/viewmodel/data/h:getSessionId	()Ljava/lang/String;
    //   6761: invokevirtual 3008	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   6764: aload_0
    //   6765: getstatic 3001	com/tencent/mm/live/b/b$c:neB	Lcom/tencent/mm/live/b/b$c;
    //   6768: aload 13
    //   6770: invokevirtual 3010	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:a	(Lcom/tencent/mm/live/b/b$c;Landroid/os/Bundle;)V
    //   6773: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6776: astore 12
    //   6778: goto -56 -> 6722
    //   6781: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6784: astore_2
    //   6785: aload_1
    //   6786: monitorexit
    //   6787: getstatic 1062	kotlin/ah:aiuX	Lkotlin/ah;
    //   6790: astore_1
    //   6791: ldc_w 2183
    //   6794: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6797: return
    //   6798: astore_2
    //   6799: aload_1
    //   6800: monitorexit
    //   6801: ldc_w 2183
    //   6804: invokestatic 448	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6807: aload_2
    //   6808: athrow
    //   6809: aload_0
    //   6810: getfield 870	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b:DcS	Lcom/tencent/mm/plugin/finder/live/plugin/ah;
    //   6813: astore_1
    //   6814: aload_1
    //   6815: ifnull -6651 -> 164
    //   6818: aload_1
    //   6819: invokevirtual 3014	com/tencent/mm/plugin/finder/live/plugin/ah:getRoot	()Landroid/view/ViewGroup;
    //   6822: new 3016	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$$ExternalSyntheticLambda1
    //   6825: dup
    //   6826: aload 12
    //   6828: aload_0
    //   6829: aload_1
    //   6830: invokespecial 3018	com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b$$ExternalSyntheticLambda1:<init>	(Landroid/os/Bundle;Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/b;Lcom/tencent/mm/plugin/finder/live/plugin/ah;)V
    //   6833: invokevirtual 3022	android/view/ViewGroup:post	(Ljava/lang/Runnable;)Z
    //   6836: pop
    //   6837: goto -6673 -> 164
    //   6840: goto -4917 -> 1923
    //   6843: iconst_0
    //   6844: istore_3
    //   6845: goto -166 -> 6679
    //   6848: iconst_0
    //   6849: istore_3
    //   6850: goto -164 -> 6686
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6853	0	this	b
    //   0	6853	2	paramBundle	Bundle
    //   198	6652	3	i	int
    //   1555	916	4	j	int
    //   1634	279	5	k	int
    //   1649	264	6	m	int
    //   673	3904	7	bool	boolean
    //   2369	3091	8	l1	long
    //   2384	3078	10	l2	long
    //   7	6820	12	localObject1	Object
    //   580	6189	13	localObject2	Object
    //   2271	3195	14	localObject3	Object
    //   2346	2799	15	localObject4	Object
    //   2399	65	16	str1	String
    //   2414	52	17	arrayOfByte	byte[]
    //   2435	38	18	str2	String
    // Exception table:
    //   from	to	target	type
    //   2539	2548	2600	finally
    //   2548	2579	2600	finally
    //   3369	3376	3402	finally
    //   3376	3399	3402	finally
    //   3413	3417	3402	finally
    //   3482	3488	3733	java/lang/Exception
    //   3850	3870	3920	finally
    //   3870	3917	3920	finally
    //   3931	3938	3920	finally
    //   4313	4319	4432	java/lang/Exception
    //   5640	5646	5649	finally
    //   6540	6547	6550	finally
    //   6715	6722	6798	finally
    //   6722	6778	6798	finally
    //   6781	6785	6798	finally
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.a parama)
  {
    AppMethodBeat.i(357865);
    kotlin.g.b.s.u(parama, "baseRouter");
    super.a(parama);
    parama = this.CCb;
    if (parama != null)
    {
      Object localObject1 = parama.findViewById(p.e.live_preview_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_preview_ui_root)");
      this.EiO = new com.tencent.mm.plugin.finder.live.plugin.y((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.live_shadow_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_shadow_ui_root)");
      this.EiP = new com.tencent.mm.live.b.y((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BNs);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_lottery_bubble_root)");
      this.Ejf = new com.tencent.mm.plugin.finder.live.plugin.ba((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BEZ);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…lowance_gift_bubble_root)");
      this.Ejh = new com.tencent.mm.plugin.finder.live.plugin.d((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BFa);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…allowance_gift_card_root)");
      this.Eji = new com.tencent.mm.plugin.finder.live.plugin.e((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.live_title_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_title_ui_root)");
      this.EiQ = new cd((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.live_common_info_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_common_info_ui_root)");
      this.EiR = new com.tencent.mm.plugin.finder.live.plugin.aj((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BRT);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.finder_live_ready_ui_root)");
      this.EiS = new bt((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BJU);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.finder_live_comment_ui_root)");
      this.DcS = new com.tencent.mm.plugin.finder.live.plugin.ah((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.live_anchor_close_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_anchor_close_ui_root)");
      this.EiT = new com.tencent.mm.plugin.finder.live.plugin.j((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.live_members_list_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_members_list_ui_root)");
      this.EiU = new bd((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BOp);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_members_profile_ui_root)");
      this.EiV = new bk((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama, getContextObj());
      localObject1 = parama.findViewById(p.e.live_like_confetti_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_like_confetti_ui_root)");
      this.EiW = new az((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BOR);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_more_action_ui_root)");
      this.EiX = new bg((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama, (MMActivity)this.CCa);
      localObject1 = parama.findViewById(p.e.BRv);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_promote_banner_root)");
      this.EiY = new bq((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BKs);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.finder_live_exception)");
      this.EiN = new l((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BLQ);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…r_live_gift_play_ui_root)");
      this.Ejj = new av((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BMa);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_live_gift_queue_ui_root)");
      localObject1 = (ViewGroup)localObject1;
      Object localObject2 = (com.tencent.mm.live.b.b)parama;
      Object localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecl;
      View localView = parama.findViewById(p.e.BLZ);
      kotlin.g.b.s.s(localView, "it.findViewById(R.id.fin…e_gift_queue_outer_space)");
      this.Ejk = new aw((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject2, (com.tencent.mm.plugin.finder.live.util.s)localObject3, (ViewGroup)localView);
      localObject1 = parama.findViewById(p.e.BTr);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_top_comment_ui_root)");
      this.Ejb = new cf((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BFp);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_anchor_like_ui_root)");
      this.Ejc = new o((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BJa);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…camera_opt_panel_ui_root)");
      this.Ejd = new com.tencent.mm.plugin.finder.live.plugin.i((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BWQ);
      if (localObject1 == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(357865);
        throw parama;
      }
      this.Eje = new ay((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BNu);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…r_live_lottery_card_root)");
      this.Ejg = new com.tencent.mm.plugin.finder.live.plugin.r((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BNb);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_live_link_state_ui_root)");
      this.Ejl = new com.tencent.mm.plugin.finder.live.plugin.q((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BRP);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…match_link_state_ui_root)");
      this.Ejm = new bs((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BFW);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…anchor_link_list_ui_root)");
      this.Ejn = new p((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BOx);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…ive_mic_decorate_ui_root)");
      localObject1 = (ViewGroup)localObject1;
      localObject2 = (com.tencent.mm.live.b.b)parama;
      localObject3 = parama.findViewById(p.e.BSi);
      kotlin.g.b.s.s(localObject3, "it.findViewById(R.id.finder_live_shade_view)");
      this.Ejo = new bf((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject2, (FinderLiveShadeView)localObject3);
      localObject1 = parama.findViewById(p.e.BFg);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…or_bottom_option_ui_root)");
      this.Ejp = new com.tencent.mm.plugin.finder.live.plugin.h((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BNE);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_lucky_money_ui_root)");
      this.Ejq = new com.tencent.mm.plugin.finder.live.plugin.bc((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BOq);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…ic_audio_preview_ui_root)");
      localObject1 = (ViewGroup)localObject1;
      localObject2 = (com.tencent.mm.live.b.b)parama;
      localObject3 = parama.findViewById(p.e.BSi);
      kotlin.g.b.s.s(localObject3, "it.findViewById(R.id.finder_live_shade_view)");
      this.Ejr = new be((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject2, (FinderLiveShadeView)localObject3, (byte)0);
      localObject1 = parama.findViewById(p.e.BSU);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_switch_mode_ui_root)");
      this.Ejs = new cb((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BGN);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_live_audio_mode_ui_root)");
      this.Ejt = new ab((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BGm);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…ive_anchor_music_ui_root)");
      this.Eju = new com.tencent.mm.plugin.finder.live.plugin.u((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BGt);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…anchor_promotion_ui_root)");
      this.Ejv = new com.tencent.mm.plugin.finder.live.plugin.z((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BGw);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…hor_search_music_ui_root)");
      this.Ejw = new com.tencent.mm.plugin.finder.live.plugin.aa((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BGk);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_anchor_music_guide_root)");
      this.CWq = new t((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BGj);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…r_music_guide_click_root)");
      this.Ejx = new v((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BGn);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…nchor_pause_live_ui_root)");
      this.Ejy = new w((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BTY);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…nning_count_down_ui_root)");
      this.Ejz = new x((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BHa);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_battle_info_ui_root)");
      this.EjA = new ac((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BQv);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…ive_option_panel_ui_root)");
      this.EjB = new bp((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BKk);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.finder_live_desc_edit_root)");
      this.EjC = new k((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BKu);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…r_live_fast_comment_root)");
      this.EjD = new n((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BGb);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…ore_option_panel_ui_root)");
      this.EjE = new com.tencent.mm.plugin.finder.live.plugin.s((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = this.CCa.findViewById(p.e.BKe);
      kotlin.g.b.s.s(localObject1, "context as Activity).fin…finder_live_content_root)");
      this.EjF = new com.tencent.mm.plugin.finder.live.plugin.m((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      localObject1 = parama.findViewById(p.e.BKi);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_live_decoration_ui_root)");
      this.EjG = new ak((ViewGroup)localObject1, (com.tencent.mm.live.b.b)parama);
      if (this.EiZ == null)
      {
        localObject1 = (ViewGroup)parama;
        localObject2 = parama.findViewById(p.e.BRz);
        kotlin.g.b.s.s(localObject2, "it.findViewById(R.id.fin…promote_bubble_container)");
        this.EiZ = new br((ViewGroup)localObject1, (ViewGroup)localObject2, (com.tencent.mm.live.b.b)parama);
        localObject1 = this.EiZ;
        if (localObject1 != null)
        {
          ((br)localObject1).tO(8);
          localObject1 = kotlin.ah.aiuX;
        }
      }
      localObject1 = this.EiR;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject1).CYH = this.EiY;
      }
      this.EjI = ((LinearLayout)parama.findViewById(p.e.BSj));
      st(true);
      com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)parama, false, 1, null);
      localObject1 = this.EiO;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.y)localObject1).tO(0);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiP;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.b.y)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiQ;
      if (localObject1 != null)
      {
        ((cd)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiR;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiS;
      if (localObject1 != null)
      {
        ((bt)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.DcS;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiT;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.j)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiU;
      if (localObject1 != null)
      {
        ((bd)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiV;
      if (localObject1 != null)
      {
        ((bk)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiW;
      if (localObject1 != null)
      {
        ((az)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiX;
      if (localObject1 != null)
      {
        ((bg)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiY;
      if (localObject1 != null)
      {
        ((bq)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejc;
      if (localObject1 != null)
      {
        ((o)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiZ;
      if (localObject1 != null)
      {
        ((br)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Eja;
      if (localObject1 != null)
      {
        ((bz)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiN;
      if (localObject1 != null)
      {
        ((l)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejj;
      if (localObject1 != null)
      {
        ((av)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejk;
      if (localObject1 != null)
      {
        ((aw)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejd;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.i)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Eje;
      if (localObject1 != null)
      {
        ((ay)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejl;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.q)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejm;
      if (localObject1 != null)
      {
        ((bs)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejn;
      if (localObject1 != null)
      {
        ((p)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejo;
      if (localObject1 != null)
      {
        ((bf)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejr;
      if (localObject1 != null)
      {
        ((be)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Eju;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.u)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejv;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.z)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejw;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.aa)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.CWq;
      if (localObject1 != null)
      {
        ((t)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejx;
      if (localObject1 != null)
      {
        ((v)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejy;
      if (localObject1 != null)
      {
        ((w)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejz;
      if (localObject1 != null)
      {
        ((x)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejf;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.ba)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejg;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.r)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejh;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Eji;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.e)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejp;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.h)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.Ejq;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.bc)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EjC;
      if (localObject1 != null)
      {
        ((k)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EjD;
      if (localObject1 != null)
      {
        ((n)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EjA;
      if (localObject1 != null)
      {
        ((ac)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EjB;
      if (localObject1 != null)
      {
        ((bp)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EjE;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.s)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EjG;
      if (localObject1 != null)
      {
        ((ak)localObject1).tO(8);
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = this.EiW;
      if (localObject1 != null)
      {
        ((az)localObject1).eqJ();
        localObject1 = kotlin.ah.aiuX;
      }
      if (this.EiR != null) {
        localObject1 = kotlin.ah.aiuX;
      }
      parama.showProgressWithBlurBg(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      parama = kotlin.ah.aiuX;
      parama = kotlin.ah.aiuX;
    }
    AppMethodBeat.o(357865);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh, final kotlin.g.a.b<? super Boolean, kotlin.ah> paramb)
  {
    AppMethodBeat.i(357762);
    Log.i(this.TAG, kotlin.g.b.s.X("postCloseLinkMsg linkMicUser:", paramh));
    if (paramh != null)
    {
      Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (localObject != null)
      {
        l.k localk = l.k.mYO;
        ((ap)localObject).a(l.k.bhG(), paramh.mXL, paramh.sessionId, (g.a)new ai(this, paramb, paramh, paramh));
      }
    }
    AppMethodBeat.o(357762);
  }
  
  public final void ao(final kotlin.g.a.b<? super Boolean, kotlin.ah> paramb)
  {
    AppMethodBeat.i(357771);
    Log.i(this.TAG, kotlin.g.b.s.X("postCloseLinkPkMsg curLinkUser:", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv));
    bgh localbgh = new bgh();
    Object localObject2 = new FinderContact();
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    if (localObject1 == null)
    {
      localObject1 = null;
      ((FinderContact)localObject2).username = ((String)localObject1);
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
      if (localObject1 != null) {
        break label243;
      }
      localObject1 = null;
      label94:
      ((FinderContact)localObject2).nickname = ((String)localObject1);
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
      if (localObject1 != null) {
        break label251;
      }
      localObject1 = null;
      label119:
      ((FinderContact)localObject2).headUrl = ((String)localObject1);
      localObject1 = kotlin.ah.aiuX;
      localbgh.contact = ((FinderContact)localObject2);
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
      if (localObject1 != null) {
        break label259;
      }
    }
    label259:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).sessionId)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efs;
      }
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (localObject1 != null)
      {
        l.k localk = l.k.mYO;
        ((ap)localObject1).a(l.k.bhG(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyF(), (String)localObject2, localbgh, (h.a)new aj(this, paramb));
      }
      AppMethodBeat.o(357771);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).username;
      break;
      label243:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).nickname;
      break label94;
      label251:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).headUrl;
      break label119;
    }
  }
  
  public final void ap(final kotlin.g.a.b<? super Boolean, kotlin.ah> paramb)
  {
    AppMethodBeat.i(357782);
    Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    localObject = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
    if (localObject != null)
    {
      byte[] arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
      long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      String str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
      String str2 = com.tencent.mm.model.z.bAW();
      kotlin.g.b.s.s(str2, "getMyFinderUsername()");
      ((ap)localObject).a(arrayOfByte, l1, l2, str1, str2, 2, (t.a)new b(this, paramb));
    }
    AppMethodBeat.o(357782);
  }
  
  public final void checkMiniWindow()
  {
    AppMethodBeat.i(357788);
    String str = this.TAG;
    Object localObject = this.CCb;
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, kotlin.g.b.s.X("checkMiniWindow:", localObject));
      localObject = this.CCb;
      if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.view.router.a)localObject).getCheckMiniWin())) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ezw();
        this.nmZ.stopTimer();
        localObject = this.CCb;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.a)localObject).setCheckMiniWin(true);
        }
      }
      AppMethodBeat.o(357788);
      return;
      localObject = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.view.router.a)localObject).getCheckMiniWin());
      break;
    }
  }
  
  public final void epz()
  {
    AppMethodBeat.i(358010);
    com.tencent.mm.plugin.finder.live.plugin.y localy = this.EiO;
    if (localy != null) {
      localy.epz();
    }
    AppMethodBeat.o(358010);
  }
  
  public final void ezs()
  {
    AppMethodBeat.i(357738);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eej;
    Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    long l;
    label62:
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      l = 0L;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).oZ(l);
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 != null) {
        break label379;
      }
      l = 0L;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).Ecp = ((int)l);
      localObject2 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject2 = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (localObject2 != null) {
        ap.a.a((ap)localObject2, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
      }
      localObject2 = com.tencent.mm.plugin.finder.live.model.q.CFU;
      com.tencent.mm.plugin.finder.live.model.q.ekN();
      localObject2 = com.tencent.mm.plugin.finder.live.component.aj.CzY;
      aj.a.nU(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("joinLive anchorStatusFlag:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp).append(" switchFlag:");
      if (localObject1 != null) {
        break label387;
      }
    }
    label387:
    for (localObject1 = null;; localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.api.m)localObject1).field_liveSwitchFlag))
    {
      Log.i((String)localObject2, localObject1 + " giftFuncEnabel:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edv + " linkMicFuncEnabel:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfD);
      localObject1 = com.tencent.mm.plugin.finder.live.util.u.DJC;
      com.tencent.mm.plugin.finder.live.util.u.ey("joinLive", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.Doc.a(new com.tencent.mm.ad.f());
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.Doc.DqB = 0L;
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (localObject1 != null) {
        ((ap)localObject1).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, 1, (kotlin.g.a.u)new j(this));
      }
      AppMethodBeat.o(357738);
      return;
      l = ((com.tencent.mm.plugin.finder.api.m)localObject1).field_liveSwitchFlag;
      break;
      label379:
      l = ((com.tencent.mm.plugin.finder.api.m)localObject1).field_liveAnchorStatusFlag;
      break label62;
    }
  }
  
  public final void ezt()
  {
    AppMethodBeat.i(357752);
    Object localObject1 = this.CCb;
    if (localObject1 != null) {
      com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)localObject1, false, 1, null);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", true);
    Object localObject2 = this.CCb;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.finder.live.view.router.a)localObject2).statusChange(com.tencent.mm.live.b.b.c.ncj, (Bundle)localObject1);
    }
    localObject1 = this.ngB;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      if ((localObject1 != null) && (((com.tencent.mm.live.core.core.model.i)localObject1).mNQ == true))
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = this.EiO;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.plugin.y)localObject1).epB();
          }
        }
        localObject1 = this.EiO;
        if (localObject1 != null)
        {
          localObject1 = (ViewGroup)((com.tencent.mm.plugin.finder.live.plugin.y)localObject1).mRt.getRenderLayout();
          if (localObject1 != null) {
            ((ViewGroup)localObject1).post(new b..ExternalSyntheticLambda4(this));
          }
        }
        localObject1 = this.EjA;
        if (localObject1 != null) {
          ((ac)localObject1).epJ();
        }
        com.tencent.mm.ae.d.a(200L, (kotlin.g.a.a)new k(this));
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eie;
        if (!(localObject1 instanceof com.tencent.mm.plugin.j)) {
          break label295;
        }
        localObject1 = (com.tencent.mm.plugin.j)localObject1;
        label242:
        if (localObject1 != null) {
          break label301;
        }
      }
    }
    label295:
    label301:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.j)localObject1).bUz())
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject2).Eif = l;
      localObject1 = this.CCb;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.a(this.buContext, (com.tencent.mm.live.b.b)localObject1);
      }
      AppMethodBeat.o(357752);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label242;
    }
  }
  
  public final void ezu()
  {
    AppMethodBeat.i(357776);
    Log.i(this.TAG, "notifyUIAfterCloseLinkPk: roomPk=" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM + ", audienceLinkMicUserList=" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw);
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
      kotlin.g.b.s.s(localObject, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      if (!((Collection)localObject).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label254;
        }
      }
    }
    else
    {
      localObject = this.CCb;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.a)localObject).setLastPkMicUser(null);
      }
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
      kotlin.g.b.s.s(localObject, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      if (((Collection)localObject).isEmpty()) {
        break label198;
      }
    }
    label198:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label203;
      }
      localObject = this.CCb;
      if (localObject == null) {
        break label273;
      }
      ((com.tencent.mm.plugin.finder.live.view.router.a)localObject).notifyAudienceMicUserChange(false);
      AppMethodBeat.o(357776);
      return;
      i = 0;
      break;
    }
    label203:
    Object localObject = this.CCb;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.live.view.a locala = (com.tencent.mm.plugin.finder.live.view.a)localObject;
      localObject = this.ngB;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.live.core.core.a.b)localObject).bfi())
      {
        com.tencent.mm.plugin.finder.live.view.a.notifyRoomPKMicUserChange$default(locala, (JSONObject)localObject, false, null, 6, null);
        AppMethodBeat.o(357776);
        return;
      }
      label254:
      localObject = this.CCb;
      if (localObject != null) {
        com.tencent.mm.plugin.finder.live.view.a.notifyPKMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)localObject, false, 1, null);
      }
    }
    label273:
    AppMethodBeat.o(357776);
  }
  
  public final void ezw()
  {
    Object localObject2 = null;
    AppMethodBeat.i(357800);
    com.tencent.mm.plugin.finder.live.view.router.a locala = this.CCb;
    Object localObject1;
    if (locala != null)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("stopLiveVideo,float mode:");
      localObject1 = this.ngB;
      if (localObject1 != null) {
        break label248;
      }
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", normal mode:");
      localObject1 = this.ngB;
      if (localObject1 != null) {
        break label273;
      }
      localObject1 = localObject2;
      label73:
      Log.i(str, localObject1 + ",manual closed:" + locala.isManualClosed() + ", needMiniWindow:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI + ", start:" + locala.isLiveStarted() + ",finish:" + locala.isLiveFinished());
      if ((!locala.isManualClosed()) && (locala.isLiveStarted()) && (!locala.isLiveFinished()))
      {
        localObject1 = this.ngB;
        if (localObject1 == null) {
          break label298;
        }
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).bep() != true)) {
          break label298;
        }
      }
    }
    label273:
    label298:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (locala.needMiniWindow()) && (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 2048))) {
        ezv();
      }
      AppMethodBeat.o(357800);
      return;
      label248:
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Boolean.valueOf(((com.tencent.mm.live.core.core.model.i)localObject1).isFloatMode());
      break;
      com.tencent.mm.live.core.core.model.i locali = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      localObject1 = localObject2;
      if (locali == null) {
        break label73;
      }
      localObject1 = Boolean.valueOf(locali.bep());
      break label73;
    }
  }
  
  public final void ezx()
  {
    AppMethodBeat.i(358002);
    Object localObject = this.EiQ;
    if (localObject != null) {
      cd.a((cd)localObject, null, false, 3);
    }
    localObject = this.EiO;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.y)localObject).tO(0);
    }
    localObject = this.EiP;
    if (localObject != null) {
      ((com.tencent.mm.live.b.y)localObject).tO(0);
    }
    localObject = this.EiQ;
    if (localObject != null) {
      ((cd)localObject).tO(0);
    }
    localObject = this.EiR;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject).tO(0);
    }
    localObject = this.DcS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject).tO(0);
    }
    localObject = this.EiX;
    if (localObject != null) {
      ((bg)localObject).tO(0);
    }
    localObject = this.EiY;
    int i;
    if ((localObject != null) && (((bq)localObject).erx() == true))
    {
      i = 1;
      if (i != 0)
      {
        localObject = this.EiY;
        if (localObject != null) {
          ((bq)localObject).tO(0);
        }
      }
      if (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp, 512)) {
        break label892;
      }
      localObject = this.Ejc;
      if (localObject != null) {
        ((o)localObject).tO(8);
      }
      label180:
      localObject = this.Ejl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.q)localObject).tO(0);
      }
      localObject = this.Ejm;
      if (localObject != null) {
        ((bs)localObject).tO(0);
      }
      localObject = this.EiS;
      if (localObject != null) {
        ((bt)localObject).tO(8);
      }
      localObject = this.Ejd;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.i)localObject).tO(8);
      }
      localObject = this.EiN;
      if (localObject != null) {
        ((l)localObject).tO(8);
      }
      localObject = this.EiW;
      if (localObject != null) {
        ((az)localObject).tO(0);
      }
      localObject = this.EiT;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.j)localObject).tO(0);
      }
      localObject = this.EiR;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.b.a)localObject).mJe;
        if (localObject != null) {
          ((ViewGroup)localObject).post(new b..ExternalSyntheticLambda2(this));
        }
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfK == null) {
        break label909;
      }
      localObject = this.EjA;
      if (localObject != null) {
        ((ac)localObject).tO(0);
      }
    }
    for (;;)
    {
      localObject = this.Ejp;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.h)localObject).eoQ();
      }
      localObject = this.Ejx;
      if (localObject != null) {
        ((v)localObject).eoD();
      }
      localObject = this.Ejy;
      if (localObject != null) {
        ((w)localObject).epv();
      }
      if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 32))
      {
        localObject = this.CCb;
        if (localObject != null)
        {
          String str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
          String str2 = this.CCa.getResources().getString(p.h.Cma);
          kotlin.g.b.s.s(str2, "context.resources.getStr…ng_exception_tip_network)");
          ((com.tencent.mm.plugin.finder.live.view.router.a)localObject).showTipWithBlurBg(str1, str2);
        }
        localObject = this.Ejy;
        if (localObject != null)
        {
          Log.i(((w)localObject).TAG, "hide!");
          ((w)localObject).tO(8);
        }
        localObject = this.Ejc;
        if (localObject != null) {
          ((o)localObject).tO(8);
        }
        localObject = this.Eja;
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
        localObject = this.DcS;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject).tO(8);
        }
        localObject = this.EiV;
        if (localObject != null) {
          ((bk)localObject).tO(8);
        }
        localObject = this.Ejd;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.i)localObject).tO(8);
        }
        localObject = this.Ejg;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.r)localObject).tO(8);
        }
        localObject = this.Ejp;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.h)localObject).tO(8);
        }
        localObject = this.Ejl;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.q)localObject).tO(8);
        }
        localObject = this.Ejm;
        if (localObject != null) {
          ((bs)localObject).tO(8);
        }
        localObject = this.EjA;
        if (localObject != null) {
          ((ac)localObject).tO(8);
        }
        localObject = this.EjB;
        if (localObject != null) {
          ((bp)localObject).tO(8);
        }
        localObject = this.EjE;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.s)localObject).tO(8);
        }
        localObject = this.CCb;
        if (localObject != null) {
          com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject, com.tencent.mm.live.b.b.c.neD);
        }
      }
      if ((com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcU, 32)) && (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 32)) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).qag) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM))
      {
        localObject = this.CCb;
        if (localObject != null) {
          com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)localObject, false, 1, null);
        }
      }
      localObject = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveLastRewardInfoStorage().axJ(String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeD.clear();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeD.addAll((Collection)localObject);
      }
      AppMethodBeat.o(358002);
      return;
      i = 0;
      break;
      label892:
      localObject = this.Ejc;
      if (localObject == null) {
        break label180;
      }
      ((o)localObject).tO(0);
      break label180;
      label909:
      localObject = this.EjA;
      if (localObject != null) {
        ((ac)localObject).tO(8);
      }
    }
  }
  
  public final void ezy()
  {
    AppMethodBeat.i(358015);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(this));
    AppMethodBeat.o(358015);
  }
  
  public final void gZ(List<UserVolumeInfo> paramList)
  {
    AppMethodBeat.i(357729);
    for (;;)
    {
      int i;
      synchronized ((Iterable)paramList)
      {
        Iterator localIterator = ???.iterator();
        if (localIterator.hasNext())
        {
          paramList = localIterator.next();
          UserVolumeInfo localUserVolumeInfo = (UserVolumeInfo)paramList;
          boolean bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw, localUserVolumeInfo.userId);
          if (!bool) {
            continue;
          }
          paramList = (UserVolumeInfo)paramList;
          if (paramList == null) {
            break;
          }
          int j = paramList.volume;
          paramList = this.ngB;
          if (paramList == null)
          {
            i = 0;
            if (j <= i) {
              break;
            }
            paramList = this.EiR;
            if (paramList == null) {
              break label186;
            }
            paramList.qJ(true);
            AppMethodBeat.o(357729);
          }
        }
        else
        {
          paramList = null;
        }
      }
      paramList = paramList.mRM;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.mMI;
      }
    }
    paramList = this.EiR;
    if (paramList != null) {
      paramList.qJ(false);
    }
    label186:
    AppMethodBeat.o(357729);
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(357824);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted())
    {
      this.nmZ.stopTimer();
      this.nmZ.startTimer(1000L);
    }
    AppMethodBeat.o(357824);
  }
  
  public final void su(boolean paramBoolean)
  {
    Object localObject4 = null;
    int j = 0;
    AppMethodBeat.i(357816);
    int i;
    boolean bool;
    label67:
    Object localObject6;
    if (!paramBoolean)
    {
      localObject1 = this.ngB;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.model.i)localObject1).isFloatMode() == true))
        {
          i = 1;
          if (i == 0) {
            break label493;
          }
          localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if (!com.tencent.mm.plugin.finder.live.utils.a.euB()) {
            break label493;
          }
        }
      }
    }
    else
    {
      bool = true;
      ??? = this.TAG;
      localObject6 = new StringBuilder("startLiveVideo,float mode:");
      localObject1 = this.ngB;
      if (localObject1 != null) {
        break label499;
      }
      localObject1 = null;
      label99:
      localObject6 = ((StringBuilder)localObject6).append(localObject1).append(", normal mode:");
      localObject1 = this.ngB;
      if (localObject1 != null) {
        break label530;
      }
      localObject1 = localObject4;
      label129:
      localObject1 = ((StringBuilder)localObject6).append(localObject1).append(", liveData.enableAudioMode:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyt()).append(", pkMicUser:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv).append(",fromMiniWindow:").append(paramBoolean).append(",directorStartFromMiniW:");
      localObject4 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      Log.i((String)???, com.tencent.mm.plugin.finder.live.utils.a.euB());
      localObject1 = this.ngB;
      if (localObject1 == null) {
        break label559;
      }
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).isFloatMode() != true)) {
        break label559;
      }
      i = 1;
      label253:
      if (i != 0)
      {
        localObject1 = ar.CIh;
        ar.emj();
        localObject1 = this.ngB;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.a.b)localObject1).bcg();
        }
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Dri, String.valueOf(q.z.Dxx.type));
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_SWITCH_MODE_FROM_MINIWINDOW", bool);
      ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyt());
      localObject4 = this.ngB;
      if (localObject4 != null) {
        break label564;
      }
      paramBoolean = false;
    }
    label493:
    label499:
    Object localObject7;
    for (;;)
    {
      ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_IS_SHARE_MODE", paramBoolean);
      localObject4 = this.CCb;
      if (localObject4 != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.a)localObject4).statusChange(com.tencent.mm.live.b.b.c.neR, (Bundle)localObject1);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("PARAM_FINDER_LIVE_IS_MUTE_MIC", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eem);
      localObject4 = this.CCb;
      if (localObject4 != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.a)localObject4).statusChange(com.tencent.mm.live.b.b.c.neV, (Bundle)localObject1);
      }
      if (this.ngB == null) {
        break label858;
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv == null) {
        break label622;
      }
      ??? = this.ngB;
      if (??? != null) {
        break label590;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
      AppMethodBeat.o(357816);
      throw ((Throwable)localObject1);
      i = 0;
      break;
      bool = false;
      break label67;
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label99;
      }
      localObject1 = Boolean.valueOf(((com.tencent.mm.live.core.core.model.i)localObject1).isFloatMode());
      break label99;
      label530:
      localObject7 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      localObject1 = localObject4;
      if (localObject7 == null) {
        break label129;
      }
      localObject1 = Boolean.valueOf(((com.tencent.mm.live.core.core.model.i)localObject7).bep());
      break label129;
      label559:
      i = 0;
      break label253;
      label564:
      localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject4).mRB;
      if (localObject4 == null) {
        paramBoolean = false;
      } else {
        paramBoolean = ((com.tencent.mm.live.core.core.model.i)localObject4).mNQ;
      }
    }
    label590:
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      ((com.tencent.mm.live.core.core.a.b)???).FM((String)localObject1);
      label622:
      localObject1 = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
      if (localObject1 != null)
      {
        i = j;
        if (!((Collection)localObject1).isEmpty()) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0) {
        break label858;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
      kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      synchronized ((Iterable)localObject1)
      {
        localObject6 = ((Iterable)???).iterator();
        do
        {
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)localObject6).next();
        } while (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).mXM != 2);
        localObject7 = this.ngB;
        if (localObject7 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
        AppMethodBeat.o(357816);
        throw ((Throwable)localObject1);
      }
      localObject4 = localObject2.mXL;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
    }
    if (localObject3 == null) {
      localObject3 = "";
    }
    for (;;)
    {
      ((com.tencent.mm.live.core.core.a.b)localObject7).FM((String)localObject3);
      break;
      localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).mXL;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
    }
    Object localObject3 = kotlin.ah.aiuX;
    label858:
    localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    if (localObject3 != null)
    {
      localObject4 = this.Ejo;
      if (localObject4 != null) {
        ((bf)localObject4).awC(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).mXL);
      }
      localObject3 = this.EiR;
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject3).emx();
      }
      localObject3 = this.EiR;
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject3).emy();
      }
    }
    localObject3 = this.CCb;
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.finder.live.view.router.a)localObject3).post(new b..ExternalSyntheticLambda3(this));
    }
    AppMethodBeat.o(357816);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$onStatusChanged$15$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAcceptBattle$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptBattleResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class aa
    implements p.a
  {
    aa(b paramb, bgh parambgh) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bcv parambcv)
    {
      AppMethodBeat.i(357230);
      kotlin.g.b.s.u(parambcv, "resp");
      Log.i(b.h(this.EjJ), "[Battle] accept battle. errType:" + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
      b.a(this.EjJ, paramInt1, paramInt2, paramString, this.EjP);
      AppMethodBeat.o(357230);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$onStatusChanged$16$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCloseBattle$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseBattleResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ab
    implements v.a
  {
    ab(b paramb, bgh parambgh) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bge parambge)
    {
      AppMethodBeat.i(357232);
      kotlin.g.b.s.u(parambge, "resp");
      Log.i(b.h(this.EjJ), "[Battle] close battle. errType:" + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
      b.b(this.EjJ, paramInt1, paramInt2, paramString, paramBundle);
      AppMethodBeat.o(357232);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends kotlin.g.b.u
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, auv, kotlin.ah>
  {
    ac(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$onStatusChanged$6$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ae
    implements a.a
  {
    ae(b paramb, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh, bgh parambgh, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bcx parambcx)
    {
      Object localObject = null;
      AppMethodBeat.i(357253);
      kotlin.g.b.s.u(parambcx, "resp");
      Log.i(b.h(this.EjJ), "acceptLinkMic " + paramBundle.nickname + ' ' + paramBundle.mXL + " errCode:" + paramInt2 + " errType:" + paramInt1 + " errMsg:" + paramString);
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = com.tencent.mm.plugin.finder.utils.ba.Gjt;
        com.tencent.mm.plugin.finder.utils.ba.fgL();
        if (paramBundle.mXM == 1)
        {
          com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.ap.DyN, "", -1, -1);
          parambcx = com.tencent.mm.plugin.finder.live.report.j.Dob;
          localObject = q.ap.DyW;
          paramString = this.EjM.contact;
          if (paramString != null) {
            break label379;
          }
          paramString = null;
          label152:
          parambcx.a((q.ap)localObject, paramString, q.az.DAo.type, q.al.Dyx.type);
          paramString = b.v(this.EjJ);
          if (paramString != null) {
            paramString.awR(paramBundle.mXL);
          }
          paramString = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          paramString = paramBundle.mXL;
          if (paramString != null) {
            break label387;
          }
          paramString = "";
          label214:
          paramInt1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyG();
          parambcx = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
          if (parambcx != null) {
            break label390;
          }
          parambcx = null;
          label255:
          boolean bool = com.tencent.mm.plugin.finder.live.utils.a.a(paramString, paramInt1, false, parambcx);
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM) {
            break label400;
          }
          if (bool)
          {
            paramString = this.EjJ.ngB;
            if (paramString != null) {
              paramString.bfh();
            }
          }
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efu.clear();
          paramString = b.q(this.EjJ);
          if (paramString != null) {
            paramString.eoT();
          }
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this.EjJ));
          AppMethodBeat.o(357253);
          return;
          com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.ap.DyO, "", -1, -1);
          break;
          label379:
          paramString = paramString.username;
          break label152;
          label387:
          break label214;
          label390:
          parambcx = parambcx.sessionId;
          break label255;
          label400:
          paramBundle.eyb();
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).g(paramBundle);
          paramString = this.EjJ.CCb;
          if (paramString != null) {
            com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)paramString, false, 1, null);
          }
        }
      }
      parambcx = (CharSequence)paramString;
      int i;
      if ((parambcx == null) || (parambcx.length() == 0))
      {
        i = 1;
        label475:
        if (i == 0) {
          break label608;
        }
        paramString = (String)localObject;
      }
      label608:
      for (;;)
      {
        if (paramInt2 != -200074) {
          break label611;
        }
        localObject = (Context)b.j(this.EjJ);
        parambcx = paramString;
        if (paramString == null)
        {
          parambcx = b.j(this.EjJ).getResources().getString(p.h.Cli);
          kotlin.g.b.s.s(parambcx, "context.resources.getStr…k_accept_pk_tip_canceled)");
        }
        com.tencent.mm.ui.base.aa.makeText((Context)localObject, (CharSequence)parambcx, 0).show();
        paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efx;
        kotlin.g.b.s.s(paramString, "business(LiveLinkMicSlic…java).linkMicUserInfoList");
        com.tencent.mm.ae.d.a(paramString, (kotlin.g.a.b)new a(paramc));
        paramBundle.EbE = 0;
        break;
        i = 0;
        break label475;
      }
      label611:
      paramString = com.tencent.mm.plugin.finder.live.model.aa.CGv;
      paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      long l;
      if (paramString == null) {
        l = 0L;
      }
      for (;;)
      {
        com.tencent.mm.plugin.finder.live.model.aa.o(paramInt2, paramInt1, l);
        break;
        paramString = paramString.liveInfo;
        if (paramString == null) {
          l = 0L;
        } else {
          l = paramString.liveId;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "micUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
    {
      a(String paramString)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      b(b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class af
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    af(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ag
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    ag(b paramb, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ah
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    ah(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$postCloseLinkMsg$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ai
    implements g.a
  {
    ai(b paramb, kotlin.g.a.b<? super Boolean, kotlin.ah> paramb1, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh1, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh2) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, bgg parambgg)
    {
      AppMethodBeat.i(357228);
      kotlin.g.b.s.u(parambgg, "resp");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.EjJ, paramInt2, paramInt1, paramString, paramb, paramh, paramh));
      AppMethodBeat.o(357228);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      a(b paramb, int paramInt1, int paramInt2, String paramString, kotlin.g.a.b<? super Boolean, kotlin.ah> paramb1, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh1, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh2)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$postCloseLinkPkMsg$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveMicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class aj
    implements h.a
  {
    aj(b paramb, kotlin.g.a.b<? super Boolean, kotlin.ah> paramb1) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, aut paramaut)
    {
      AppMethodBeat.i(357222);
      kotlin.g.b.s.u(paramaut, "resp");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.EjJ, paramInt2, paramInt1, paramString, paramb));
      AppMethodBeat.o(357222);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      a(b paramb, int paramInt1, int paramInt2, String paramString, kotlin.g.a.b<? super Boolean, kotlin.ah> paramb1)
      {
        super();
      }
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$cancelRandomMatchLinkMic$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveRandomMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRandomMicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements t.a
  {
    b(b paramb, kotlin.g.a.b<? super Boolean, kotlin.ah> paramb1) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bln parambln)
    {
      AppMethodBeat.i(357316);
      kotlin.g.b.s.u(parambln, "resp");
      Log.i(b.h(this.EjJ), "cancel random match: errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        b.k(this.EjJ);
        paramString = paramb;
        if (paramString != null)
        {
          paramString.invoke(Boolean.TRUE);
          AppMethodBeat.o(357316);
        }
      }
      else
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy = 0;
        paramString = b.l(this.EjJ);
        if (paramString != null) {
          paramString.epp();
        }
        paramString = com.tencent.mm.plugin.finder.live.model.aa.CGv;
        com.tencent.mm.plugin.finder.live.model.aa.s(paramInt2, paramInt1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
        paramString = paramb;
        if (paramString != null) {
          paramString.invoke(Boolean.FALSE);
        }
      }
      AppMethodBeat.o(357316);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "avatarItem", "Lcom/tencent/mm/protocal/protobuf/LiveElementMedia;", "atmosphereItem"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.m<dik, dik, kotlin.ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$handleJoinResp$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.live.core.core.c
  {
    g(b paramb, bca parambca) {}
    
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(357320);
      Log.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish, liveData.business(LiveCommonSlice::class.java).enableAudioMode():" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyt() + " audioModeHolderBm:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DVR);
      if (paramInt > 0)
      {
        paramBundle = this.EjJ.ngB;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.mRB;
          if ((paramBundle == null) || (paramBundle.bex() != true)) {}
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0)
          {
            paramBundle = this.EjJ.ngB;
            if (paramBundle != null)
            {
              localObject1 = b.j(this.EjJ).getResources().getDrawable(p.d.live_audio_mode_frame);
              kotlin.g.b.s.s(localObject1, "context.resources.getDra…le.live_audio_mode_frame)");
              paramBundle.H(com.tencent.mm.ae.d.drawable2Bitmap((Drawable)localObject1));
            }
          }
          b.a(this.EjJ, this.CEs.ZMN);
          paramBundle = com.tencent.mm.plugin.finder.utils.bc.GkH;
          com.tencent.mm.plugin.finder.utils.bc.qS(cn.bDu());
          paramBundle = com.tencent.mm.plugin.finder.utils.ba.Gjt;
          localObject1 = bb.GjM;
          com.tencent.mm.plugin.finder.utils.ba.a(paramBundle, bb.fhA().name, null, false, false, 14);
          paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
          paramBundle = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
          if (paramBundle == null) {
            break;
          }
          paramBundle.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.EjJ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp, 1, (com.tencent.mm.plugin.finder.live.cgi.e.a)new a(this.EjJ, this.CEs));
          AppMethodBeat.o(357320);
          return;
        }
      }
      Object localObject1 = com.tencent.mm.plugin.finder.utils.ba.Gjt;
      Object localObject2 = bb.GjM;
      com.tencent.mm.plugin.finder.utils.ba.a((com.tencent.mm.plugin.finder.utils.ba)localObject1, bb.fhz().name, null, false, true, 6);
      Log.w("MicroMsg.LiveCoreAnchor", "enter room fail");
      com.tencent.mm.ui.base.aa.makeText((Context)b.j(this.EjJ), (CharSequence)"enter room fail", 0).show();
      localObject1 = this.EjJ.CCb;
      if (localObject1 != null) {
        com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)localObject1, com.tencent.mm.live.b.b.c.nch);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("live_user_exit_reason", paramInt);
      localObject2 = this.EjJ.CCb;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.a)localObject2).statusChange(com.tencent.mm.live.b.b.c.ndc, (Bundle)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (localObject1 != null) {
        ap.a.a((ap)localObject1, (kotlin.g.a.s)new b(this.EjJ));
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.bc.GkH;
      com.tencent.mm.plugin.finder.utils.bc.it(com.tencent.mm.plugin.finder.utils.bc.fhK(), String.valueOf(paramBundle));
      AppMethodBeat.o(357320);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$handleJoinResp$1$1$callback$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.finder.live.cgi.e.a
    {
      a(b paramb, bca parambca) {}
      
      public final void a(bvg parambvg)
      {
        AppMethodBeat.i(357343);
        kotlin.g.b.s.u(this, "this");
        AppMethodBeat.o(357343);
      }
      
      public final void am(int paramInt, long paramLong)
      {
        AppMethodBeat.i(357328);
        Log.i(b.h(this.EjJ), "share live success!");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this.EjJ, this.CEs));
        AppMethodBeat.o(357328);
      }
      
      public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        AppMethodBeat.i(357336);
        Log.i(b.h(this.EjJ), "share live fail!");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.g.a.a(this.EjJ, paramString, paramInt2, paramInt1));
        AppMethodBeat.o(357336);
      }
      
      public final void eho()
      {
        AppMethodBeat.i(357347);
        kotlin.g.b.s.u(this, "this");
        AppMethodBeat.o(357347);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class b
        extends kotlin.g.b.u
        implements kotlin.g.a.a<kotlin.ah>
      {
        b(b paramb, bca parambca)
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.s<Boolean, Integer, Integer, String, auv, kotlin.ah>
    {
      b(b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, auv, kotlin.ah>
  {
    i(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.u<Boolean, Integer, Integer, String, g, TRTCCloudDef.TRTCParams, bca, kotlin.ah>
  {
    j(b paramb)
    {
      super();
    }
    
    private static final void emb()
    {
      AppMethodBeat.i(357297);
      Exception localException = new Exception("manul exception");
      AppMethodBeat.o(357297);
      throw localException;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    k(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements RequestFloatWindowPermissionDialog.a
  {
    l(b paramb) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      int j = 1;
      AppMethodBeat.i(357306);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      Object localObject = this.EjJ;
      paramRequestFloatWindowPermissionDialog.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true);
      com.tencent.mm.plugin.finder.live.view.router.a locala = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject).CCb;
      if ((locala != null) && (locala.isSwipeBack() == true))
      {
        i = 1;
        if (i == 0) {
          break label134;
        }
      }
      label134:
      for (int i = j;; i = 3)
      {
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", i);
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
        localObject = ((com.tencent.mm.plugin.finder.live.component.statecomponent.a)localObject).CCb;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.a)localObject).statusChange(com.tencent.mm.live.b.b.c.ncx, paramRequestFloatWindowPermissionDialog);
        }
        paramRequestFloatWindowPermissionDialog = this.EjJ.CCb;
        if (paramRequestFloatWindowPermissionDialog != null) {
          paramRequestFloatWindowPermissionDialog.setMiniWinPermission(false);
        }
        b.ezz();
        AppMethodBeat.o(357306);
        return;
        i = 0;
        break;
      }
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(357311);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      com.tencent.mm.plugin.finder.live.view.router.a locala = this.EjJ.CCb;
      if (locala != null) {
        locala.setMiniWinPermission(false);
      }
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      locala = this.EjJ.CCb;
      if (locala != null) {
        locala.statusChange(com.tencent.mm.live.b.b.c.ncA, paramRequestFloatWindowPermissionDialog);
      }
      AppMethodBeat.o(357311);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(357319);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog = this.EjJ.CCb;
      if (paramRequestFloatWindowPermissionDialog != null) {
        paramRequestFloatWindowPermissionDialog.setMiniWinPermission(false);
      }
      paramRequestFloatWindowPermissionDialog = new Bundle();
      com.tencent.mm.plugin.finder.live.view.router.a locala = this.EjJ.CCb;
      if (locala != null) {
        locala.statusChange(com.tencent.mm.live.b.b.c.ncC, paramRequestFloatWindowPermissionDialog);
      }
      AppMethodBeat.o(357319);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    public m(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public n(com.tencent.mm.live.model.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public p(String paramString)
    {
      super();
    }
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
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public r(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    public s(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public t(b paramb, bgh parambgh, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh, bdt parambdt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$onRandomMicApply$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class u
    implements com.tencent.mm.plugin.finder.live.model.cgi.e.a
  {
    public u(b paramb, bgh parambgh) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, atn paramatn)
    {
      AppMethodBeat.i(357264);
      kotlin.g.b.s.u(paramatn, "resp");
      b.b(this.EjJ, paramInt1, paramInt2, paramString, paramatn, this.EjP);
      AppMethodBeat.o(357264);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    v(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$onStatusChanged$12$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class w
    implements com.tencent.mm.plugin.finder.live.model.cgi.e.a
  {
    w(b paramb, bgh parambgh) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, atn paramatn)
    {
      AppMethodBeat.i(357269);
      kotlin.g.b.s.u(paramatn, "resp");
      b.a(this.EjJ, paramInt1, paramInt2, paramString, paramatn, paramBundle);
      AppMethodBeat.o(357269);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$onStatusChanged$13$2", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderAcceptLiveMicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class x
    implements com.tencent.mm.plugin.finder.live.model.cgi.b.a
  {
    x(b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, atc paramatc)
    {
      AppMethodBeat.i(357270);
      kotlin.g.b.s.u(paramatc, "resp");
      b.a(this.EjJ, paramInt1, paramInt2, paramString, paramatc);
      AppMethodBeat.o(357270);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    y(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorLivingUIC$onStatusChanged$14$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveApplyBattle$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyBattleResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class z
    implements q.a
  {
    z(b paramb, bgh parambgh) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bfb parambfb)
    {
      AppMethodBeat.i(357265);
      kotlin.g.b.s.u(parambfb, "resp");
      Log.i(b.h(this.EjJ), "[Battle] apply battle. errType:" + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
      b.a(this.EjJ, paramInt1, paramInt2, paramString, parambfb, paramBundle);
      AppMethodBeat.o(357265);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.b
 * JD-Core Version:    0.7.0.1
 */