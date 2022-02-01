package com.tencent.mm.plugin.finder.live.viewmodel.state.secondary;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.component.u.a;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.m;
import com.tencent.mm.plugin.finder.live.plugin.af;
import com.tencent.mm.plugin.finder.live.plugin.aq;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.bb;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.bi;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.bo;
import com.tencent.mm.plugin.finder.live.plugin.bq;
import com.tencent.mm.plugin.finder.live.plugin.bs;
import com.tencent.mm.plugin.finder.live.plugin.bt;
import com.tencent.mm.plugin.finder.live.plugin.by;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.live.plugin.cd;
import com.tencent.mm.plugin.finder.live.plugin.cj;
import com.tencent.mm.plugin.finder.live.plugin.cl;
import com.tencent.mm.plugin.finder.live.plugin.cn;
import com.tencent.mm.plugin.finder.live.plugin.cp;
import com.tencent.mm.plugin.finder.live.plugin.cr;
import com.tencent.mm.plugin.finder.live.plugin.ct;
import com.tencent.mm.plugin.finder.live.plugin.n;
import com.tencent.mm.plugin.finder.live.plugin.o;
import com.tencent.mm.plugin.finder.live.plugin.r;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.report.s.v;
import com.tencent.mm.plugin.finder.utils.ap;
import com.tencent.mm.plugin.finder.utils.ap.c;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.w;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveSecondaryStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "anchorPausePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin;", "audioModePreviewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAudioModePreviewPlugin;", "bottomOptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin;", "cameraOptPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin;", "closePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin;", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "commonInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "confettiPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "exceptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "getExceptionPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "setExceptionPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;)V", "giftPlayPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "giftQueuePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "likePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin;", "linkApplyListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "linkStatePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin;", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin;", "lotteryBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "lotteryCardPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin;", "luckyMoneyPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin;", "memberListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin;", "micDecoratePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin;", "moreActionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;", "optionPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin;", "profilePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewMemberProfilePlugin;", "readyPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin;", "shadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "shoppingBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "shoppingListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "subtitlePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveSubtitlePlugin;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimerThread", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setTimerThread", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "titleInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "topCommentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;", "adjustLayout", "", "adjustLayoutCDN", "checkFinderObject", "checkMiniWindow", "chooseAudienceMode", "fromMiniWin", "", "getWeAppVersionType", "handleJoinLiveWxshopResponse", "response", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "handleJoinResp", "success", "errCode", "", "errType", "errMsg", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "resp", "handleLiveErr", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "errorPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "hideBottomAraePlugin", "initPlugins", "initShoppingPlugins", "joinLive", "joinLiveByMiniWin", "liveEndWithAnimation", "miniWindow", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "onLiveEnd", "onLiveEventCallback", "errorCode", "param", "Landroid/os/Bundle;", "onLiveMsgChanged", "onLivePrepare", "onLiveStart", "onRelease", "onResume", "onStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "onStop", "prepareShopping", "report", "showLivePauseTip", "startLive", "byMiniWin", "startTimer", "stopLiveVideo", "stopTimer", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.b
{
  public final String TAG;
  public MTimerHandler kKL;
  public aq ysG;
  public af zjB;
  private com.tencent.mm.plugin.finder.live.plugin.x zjF;
  public cc zjJ;
  public n zja;
  public as zjc;
  public cr zjd;
  public at zje;
  public cd zjf;
  public com.tencent.mm.plugin.finder.live.plugin.l zjg;
  public bq zjh;
  public by zji;
  public bi zjj;
  public bt zjk;
  public cj zjl;
  public cl zjm;
  public ct zjn;
  public o zjo;
  public com.tencent.mm.plugin.finder.live.plugin.j zjp;
  public bk zjq;
  public com.tencent.mm.plugin.finder.live.plugin.s zjr;
  public bb zjs;
  public bd zjt;
  public r zju;
  public com.tencent.mm.plugin.finder.live.plugin.q zjv;
  public bs zjw;
  public com.tencent.mm.plugin.finder.live.plugin.h zjx;
  public bo zjy;
  public cp zkh;
  public cn zki;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(291633);
    this.TAG = "FinderLiveSecondaryStartUIC";
    this.kKL = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack)new l(this), true);
    AppMethodBeat.o(291633);
  }
  
  private final void dHm()
  {
    AppMethodBeat.i(291626);
    Object localObject = new Bundle();
    com.tencent.mm.plugin.finder.live.view.router.b localb = this.ycX;
    boolean bool;
    if (localb != null)
    {
      bool = localb.needRemoveActivity();
      ((Bundle)localObject).putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", bool);
      localb = this.ycX;
      if ((localb == null) || (localb.isSwipeBack() != true)) {
        break label178;
      }
    }
    label178:
    for (int i = 1;; i = 3)
    {
      ((Bundle)localObject).putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", i);
      ((Bundle)localObject).putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
      if (com.tencent.mm.compatible.e.b.ct((Context)this.ycV)) {
        break label183;
      }
      Log.e(this.TAG, "showVideoTalking, permission denied");
      localObject = this.ycX;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.b)localObject).setMiniWinPermission(true);
      }
      localObject = this.ycX;
      if (localObject != null) {
        b.b.a((com.tencent.mm.live.c.b)localObject, b.c.kzk);
      }
      RequestFloatWindowPermissionDialog.a((Context)this.ycV, this.ycV.getString(b.j.live_room_mini_view_fail), (RequestFloatWindowPermissionDialog.a)new g(this), false, com.tencent.mm.bx.a.awc());
      AppMethodBeat.o(291626);
      return;
      bool = false;
      break;
    }
    label183:
    localb = this.ycX;
    if (localb != null) {
      localb.setMiniWinPermission(false);
    }
    localb = this.ycX;
    if (localb != null) {
      localb.statusChange(b.c.kzi, (Bundle)localObject);
    }
    report();
    AppMethodBeat.o(291626);
  }
  
  private final void dHr()
  {
    AppMethodBeat.i(291619);
    com.tencent.mm.plugin.finder.live.view.router.b localb = this.ycX;
    if (localb != null)
    {
      Log.i(this.TAG, "user:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ",bind shop:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).yeB);
      Object localObject = this.zjx;
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).yeB)
        {
          localObject = ((com.tencent.mm.plugin.finder.live.plugin.h)localObject).ylt.kiF;
          View localView = localb.findViewById(b.f.finder_live_shopping_bubble_widget_root);
          kotlin.g.b.p.j(localView, "router.findViewById(R.id…pping_bubble_widget_root)");
          this.zjl = new cj((ViewGroup)localObject, (ViewGroup)localView, (com.tencent.mm.live.c.b)localb);
          localObject = localb.findViewById(b.f.finder_live_shopping_list_root);
          kotlin.g.b.p.j(localObject, "router.findViewById(R.id…_live_shopping_list_root)");
          this.zjm = new cl((ViewGroup)localObject, (com.tencent.mm.live.c.b)localb);
        }
        AppMethodBeat.o(291619);
        return;
      }
      AppMethodBeat.o(291619);
      return;
    }
    AppMethodBeat.o(291619);
  }
  
  private static void report()
  {
    AppMethodBeat.i(291627);
    Object localObject = k.yBj;
    k localk;
    if (k.dDm().yDB)
    {
      localObject = String.valueOf(s.v.yHp.type);
      localk = k.yBj;
      k.dDm().yDB = false;
    }
    for (;;)
    {
      localk = k.yBj;
      k.a(s.c.yEk, (String)localObject);
      AppMethodBeat.o(291627);
      return;
      if (com.tencent.mm.plugin.expt.hellhound.a.weM) {
        localObject = String.valueOf(s.v.yHq.type);
      } else {
        localObject = String.valueOf(s.v.yHo.type);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.b paramb)
  {
    AppMethodBeat.i(291631);
    kotlin.g.b.p.k(paramb, "baseRouter");
    super.a(paramb);
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    Object localObject2 = z.bdh();
    kotlin.g.b.p.j(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).aCW((String)localObject2);
    com.tencent.mm.plugin.finder.live.view.a.fillBlurBg$default(paramb, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, false, 2, null);
    paramb = this.ycX;
    if (paramb != null)
    {
      localObject1 = paramb.findViewById(b.f.live_tx_live_player_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.live_tx_live_player_ui_root)");
      this.zkh = new cp((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.live_shadow_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.live_shadow_ui_root)");
      this.zjc = new as((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_lottery_bubble_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…live_lottery_bubble_root)");
      this.zjq = new bk((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.live_title_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.live_title_ui_root)");
      this.zjd = new cr((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.live_common_info_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.live_common_info_ui_root)");
      this.zje = new at((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_ready_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.finder_live_ready_ui_root)");
      this.zjf = new cd((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_comment_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.finder_live_comment_ui_root)");
      this.ysG = new aq((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.live_anchor_close_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.live_anchor_close_ui_root)");
      this.zjg = new com.tencent.mm.plugin.finder.live.plugin.l((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = this.zjg;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (!com.tencent.mm.plugin.finder.live.utils.a.k(this.buContext))
        {
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if (!com.tencent.mm.plugin.finder.live.utils.a.l(this.buContext)) {
            break label558;
          }
        }
      }
      label558:
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.l)localObject1).ymg = bool;
        localObject1 = paramb.findViewById(b.f.live_members_list_ui_root);
        kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.live_members_list_ui_root)");
        this.zjh = new bq((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
        localObject1 = paramb.findViewById(b.f.finder_live_members_profile_ui_root);
        kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…_members_profile_ui_root)");
        this.zji = new by((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb, getContextObj());
        localObject1 = paramb.findViewById(b.f.live_like_confetti_ui_root);
        kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.live_like_confetti_ui_root)");
        this.zjj = new bi((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
        localObject1 = paramb.findViewById(b.f.finder_live_more_action_ui_root);
        kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…live_more_action_ui_root)");
        localObject1 = (ViewGroup)localObject1;
        localObject2 = (com.tencent.mm.live.c.b)paramb;
        localObject3 = this.ycV;
        if (localObject3 != null) {
          break;
        }
        paramb = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(291631);
        throw paramb;
      }
      this.zjk = new bt((ViewGroup)localObject1, (com.tencent.mm.live.c.b)localObject2, (MMActivity)localObject3);
      localObject1 = paramb.findViewById(b.f.finder_live_anchor_like_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…live_anchor_like_ui_root)");
      this.zjo = new o((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_exception);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.finder_live_exception)");
      this.zja = new n((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_top_comment_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…live_top_comment_ui_root)");
      this.zjn = new ct((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_lottery_bubble_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…live_lottery_bubble_root)");
      this.zjq = new bk((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_lottery_card_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…r_live_lottery_card_root)");
      this.zjr = new com.tencent.mm.plugin.finder.live.plugin.s((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_gift_play_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…r_live_gift_play_ui_root)");
      this.zjs = new bb((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_gift_queue_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…_live_gift_queue_ui_root)");
      localObject1 = (ViewGroup)localObject1;
      localObject2 = (com.tencent.mm.live.c.b)paramb;
      Object localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeW;
      View localView = paramb.findViewById(b.f.finder_live_gift_queue_outer_space);
      kotlin.g.b.p.j(localView, "it.findViewById(R.id.fin…e_gift_queue_outer_space)");
      this.zjt = new bd((ViewGroup)localObject1, (com.tencent.mm.live.c.b)localObject2, (com.tencent.mm.plugin.finder.live.util.p)localObject3, (ViewGroup)localView);
      localObject1 = paramb.findViewById(b.f.finder_live_anchor_bottom_option_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…or_bottom_option_ui_root)");
      this.zjx = new com.tencent.mm.plugin.finder.live.plugin.h((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_audio_mode_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…_live_audio_mode_ui_root)");
      this.zjB = new af((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_subtitle_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.finder_live_subtitle_ui_root)");
      this.zki = new cn((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb, getContextObj());
      localObject1 = paramb.findViewById(b.f.finder_live_option_panel_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…ive_option_panel_ui_root)");
      this.zjJ = new cc((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      localObject1 = paramb.findViewById(b.f.finder_live_lucky_money_ui_root);
      kotlin.g.b.p.j(localObject1, "it.findViewById(R.id.fin…live_lucky_money_ui_root)");
      this.zjy = new bo((ViewGroup)localObject1, (com.tencent.mm.live.c.b)paramb);
      dHr();
      com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default(paramb, false, 1, null);
      paramb = this.zjc;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjd;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zje;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjf;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.ysG;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjg;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjh;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zji;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjj;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjk;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjo;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjl;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjm;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zja;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjq;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjr;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjx;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjB;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjs;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjt;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjJ;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjj;
      if (paramb != null) {
        paramb.dBs();
      }
      paramb = this.zje;
      if (paramb != null) {
        paramb.dBs();
      }
      paramb = this.zki;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.zjy;
      if (paramb != null) {
        paramb.tU(8);
      }
      paramb = this.ycX;
      if (paramb != null)
      {
        paramb.showProgressWithBlurBg(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
        AppMethodBeat.o(291631);
        return;
      }
      AppMethodBeat.o(291631);
      return;
    }
    AppMethodBeat.o(291631);
  }
  
  public final void checkMiniWindow()
  {
    AppMethodBeat.i(291624);
    com.tencent.mm.plugin.finder.live.view.router.b localb = this.ycX;
    if (localb != null)
    {
      Log.i(this.TAG, "checkMiniWindow:" + localb + ".checkMiniWin");
      if (!localb.getCheckMiniWin())
      {
        dHn();
        this.kKL.stopTimer();
        localb.setCheckMiniWin(true);
      }
      AppMethodBeat.o(291624);
      return;
    }
    AppMethodBeat.o(291624);
  }
  
  public final void dHl()
  {
    long l2 = 0L;
    AppMethodBeat.i(291621);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject1 = d.a.aAK(z.bdh());
    Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    long l1;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      l1 = ((i)localObject1).field_liveSwitchFlag;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).LR(l1);
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      l1 = l2;
      if (localObject1 != null) {
        l1 = ((i)localObject1).field_liveAnchorStatusFlag;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).zfa = ((int)l1);
      localObject2 = m.yfw;
      m.dyw();
      localObject2 = com.tencent.mm.plugin.finder.live.component.u.ybO;
      u.a.Lh(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("joinLive anchorStatusFlag:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa).append(" switchFlag:");
      if (localObject1 == null) {
        break label290;
      }
    }
    label290:
    for (localObject1 = Long.valueOf(((i)localObject1).field_liveSwitchFlag);; localObject1 = null)
    {
      Log.i((String)localObject2, localObject1 + " giftFuncEnabel:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfH + " linkMicFuncEnabel:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhs);
      localObject1 = ah.yhC;
      localObject1 = ah.getFinderLiveAssistant();
      if (localObject1 == null) {
        break label296;
      }
      ((an)localObject1).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, 1, (kotlin.g.a.u)new f(this));
      AppMethodBeat.o(291621);
      return;
      l1 = 0L;
      break;
    }
    label296:
    AppMethodBeat.o(291621);
  }
  
  public final void dHn()
  {
    AppMethodBeat.i(291625);
    Object localObject2 = this.ycX;
    if (localObject2 != null)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("stopLiveVideo,float mode:");
      Object localObject1 = this.kHp;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
        if (localObject1 != null)
        {
          localObject1 = Boolean.valueOf(((com.tencent.mm.live.core.core.model.h)localObject1).isFloatMode());
          localStringBuilder = localStringBuilder.append(localObject1).append(", normal mode:");
          localObject1 = this.kHp;
          if (localObject1 == null) {
            break label282;
          }
          localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
          if (localObject1 == null) {
            break label282;
          }
          localObject1 = Boolean.valueOf(((com.tencent.mm.live.core.core.model.h)localObject1).aLl());
          label98:
          localStringBuilder = localStringBuilder.append(localObject1).append(",manual closed:").append(((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).isManualClosed()).append(", needMiniWindow:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfn).append(", start:").append(((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).isLiveStarted()).append(",finish:");
          localObject1 = this.ycX;
          if (localObject1 == null) {
            break label287;
          }
        }
      }
      label282:
      label287:
      for (localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).isLiveFinished());; localObject1 = null)
      {
        Log.i(str, localObject1);
        if ((((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).isManualClosed()) || (!((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).isLiveStarted()) || (((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).isLiveFinished())) {
          break label299;
        }
        localObject1 = this.kHp;
        if (localObject1 == null) {
          break label292;
        }
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
        if (localObject1 == null) {
          break label292;
        }
        if ((((com.tencent.mm.live.core.core.model.h)localObject1).aLl() != true) || (!((com.tencent.mm.plugin.finder.live.view.router.b)localObject2).needMiniWindow()) || (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, 2048))) {
          break label378;
        }
        dHm();
        AppMethodBeat.o(291625);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label98;
      }
      label292:
      AppMethodBeat.o(291625);
      return;
      label299:
      localObject1 = this.kHp;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
        if (localObject1 != null)
        {
          if ((((com.tencent.mm.live.core.core.model.h)localObject1).aLl() != true) || (!(this.kHp instanceof com.tencent.mm.live.core.core.b.a))) {
            break label378;
          }
          localObject2 = this.kHp;
          localObject1 = localObject2;
          if (!(localObject2 instanceof com.tencent.mm.live.core.core.b.a)) {
            localObject1 = null;
          }
          localObject1 = (com.tencent.mm.live.core.core.b.a)localObject1;
          if (localObject1 == null) {
            break label378;
          }
          ((com.tencent.mm.live.core.core.b.a)localObject1).aMi();
          AppMethodBeat.o(291625);
          return;
        }
      }
      AppMethodBeat.o(291625);
      return;
      label378:
      AppMethodBeat.o(291625);
      return;
    }
    AppMethodBeat.o(291625);
  }
  
  public final void dHp()
  {
    AppMethodBeat.i(291632);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this));
    AppMethodBeat.o(291632);
  }
  
  public final void dHs()
  {
    AppMethodBeat.i(291628);
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGJ();
    Object localObject1 = e.b.kjz;
    Object localObject2;
    label88:
    Object localObject3;
    RelativeLayout.LayoutParams localLayoutParams;
    label140:
    int m;
    int k;
    int i2;
    boolean bool1;
    boolean bool2;
    float f1;
    int j;
    float f2;
    label385:
    int n;
    if (i != e.b.aJJ())
    {
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGJ();
      localObject1 = e.b.kjz;
      if (i == e.b.aJK())
      {
        localObject1 = this.zkh;
        if (localObject1 != null)
        {
          localObject2 = ((cp)localObject1).aPH();
          if (localObject2 == null) {
            break label771;
          }
          localObject1 = ((TXCloudVideoView)localObject2).getLayoutParams();
          localObject3 = localObject1;
          if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
            localObject3 = null;
          }
          localLayoutParams = (RelativeLayout.LayoutParams)localObject3;
          localObject1 = this.ycX;
          if (localObject1 == null) {
            break label777;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).getPreviewRoot();
          if (localObject1 == null) {
            break label777;
          }
          localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
          localObject3 = localObject1;
          if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
            localObject3 = null;
          }
          localObject3 = (RelativeLayout.LayoutParams)localObject3;
          m = 0;
          k = -1;
          localObject1 = this.ycV.getResources();
          kotlin.g.b.p.j(localObject1, "context.resources");
          i2 = ((Resources)localObject1).getConfiguration().orientation;
          bool1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGQ();
          bool2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGS();
          if ((!bool1) || (1 != i2) || (!bool2)) {
            break label909;
          }
          f1 = ax.au(MMApplicationContext.getContext()).x;
          j = (int)(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).videoHeight / ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).videoWidth * f1);
          f2 = ax.au(MMApplicationContext.getContext()).y * 0.688F;
          localObject1 = MMApplicationContext.getContext();
          kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
          f1 = ((Context)localObject1).getResources().getDimension(b.d.finder_32A);
          if (j > f2) {
            break label792;
          }
          k = (int)(0.156F * ax.au(MMApplicationContext.getContext()).y) + ax.getStatusBarHeight((Context)this.ycV);
          if (j >= f1) {
            break label786;
          }
          i = (int)f1;
          if (localLayoutParams == null) {
            break label783;
          }
          localLayoutParams.addRule(16);
          m = j;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm = false;
          localObject1 = this.ycX;
          if (localObject1 == null) {
            break label817;
          }
          ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).onScreenClear(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm);
          n = m;
          m = k;
          k = i;
          i = n;
        }
      }
    }
    for (;;)
    {
      label446:
      if (localObject3 != null) {
        ((RelativeLayout.LayoutParams)localObject3).topMargin = m;
      }
      if (localObject3 != null) {
        ((RelativeLayout.LayoutParams)localObject3).height = k;
      }
      if (localLayoutParams != null) {
        localLayoutParams.height = i;
      }
      localObject1 = this.ycX;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).getPreviewRoot();
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
      }
      if (localObject2 != null) {
        ((TXCloudVideoView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("adjustLayoutCDN fitLandscapeVideo:").append(bool1).append(",curOrientation:").append(i2).append(",videoSizeValid:").append(bool2).append(",uiState:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu).append(",videoScaleHeight:").append(j).append(",limitHeight:").append(f2).append(",landscapePlayerMiniHeight:").append(f1).append(',').append("parentLp height:");
      if (localObject3 != null)
      {
        localObject1 = Integer.valueOf(((RelativeLayout.LayoutParams)localObject3).height);
        label653:
        localStringBuilder = localStringBuilder.append(localObject1).append(",top:");
        if (localObject3 == null) {
          break label848;
        }
        localObject1 = Integer.valueOf(((RelativeLayout.LayoutParams)localObject3).topMargin);
        label683:
        localObject3 = localStringBuilder.append(localObject1).append(", height:");
        if (localLayoutParams == null) {
          break label854;
        }
        localObject1 = Integer.valueOf(localLayoutParams.height);
        label713:
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(",top:");
        if (localLayoutParams == null) {
          break label860;
        }
      }
      label771:
      label777:
      label783:
      label786:
      label792:
      label817:
      label848:
      label854:
      label860:
      for (localObject1 = Integer.valueOf(localLayoutParams.topMargin);; localObject1 = null)
      {
        Log.i((String)localObject2, localObject1);
        AppMethodBeat.o(291628);
        return;
        localObject2 = null;
        break;
        localObject1 = null;
        break label88;
        localObject1 = null;
        break label140;
        break label385;
        i = j;
        break label385;
        k = 0;
        if (localLayoutParams != null)
        {
          localLayoutParams.addRule(16);
          i = -1;
          break label385;
        }
        i = -1;
        break label385;
        int i1 = m;
        m = i;
        n = k;
        i = i1;
        k = m;
        m = n;
        break label446;
        localObject1 = null;
        break label653;
        localObject1 = null;
        break label683;
        localObject1 = null;
        break label713;
      }
      Log.i(this.TAG, "invalid audience mode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGJ());
      AppMethodBeat.o(291628);
      return;
      label909:
      f1 = 0.0F;
      f2 = 0.0F;
      j = 0;
      i = -1;
    }
  }
  
  public final void fw(final boolean paramBoolean)
  {
    TXCloudVideoView localTXCloudVideoView = null;
    AppMethodBeat.i(291629);
    Object localObject3;
    Object localObject2;
    boolean bool;
    label363:
    long l;
    if (!paramBoolean)
    {
      localObject1 = this.ycX;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).getRootView();
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getContext();
          w.makeText((Context)localObject1, (CharSequence)this.ycV.getResources().getString(b.j.finder_live_secondary_device_toast), 0).show();
        }
      }
    }
    else
    {
      int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGJ();
      localObject1 = e.b.kjz;
      if (i != e.b.aJK()) {
        break label538;
      }
      Log.i(this.TAG, "chooseAudienceMode CDN fromMiniWin:" + paramBoolean + ", liveRoomModel:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvS);
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvS;
      if (localObject3 == null) {
        break label538;
      }
      localObject1 = this.kHp;
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.trtc.a)localObject1).a((g)localObject3);
      }
      localObject2 = this.kHp;
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.live.core.core.c.c)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.live.core.core.c.c)localObject1;
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.c.c)localObject1).b(((g)localObject3).kjd);
      }
      localObject1 = this.zkh;
      if (localObject1 != null) {
        ((cp)localObject1).eT(false);
      }
      localObject1 = ar.AIS;
      localObject2 = new StringBuilder();
      localObject3 = ar.AIS;
      localObject2 = ar.efV() + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
      localObject3 = ap.AIh;
      ar.a((ar)localObject1, (String)localObject2, ap.efm().name, null, false, false, false, 60);
      localObject1 = this.zkh;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.dEH();
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        localObject3 = this.buContext;
        com.tencent.mm.plugin.finder.live.view.router.b localb = this.ycX;
        if (localb == null) {
          break label520;
        }
        bool = localb.isLandscape();
        cp.a((cp)localObject1, 0, (TXLivePlayConfig)localObject2, com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject3, bool), false, (kotlin.g.a.b)new b(this, paramBoolean), 9);
      }
      localObject1 = this.zkh;
      if (localObject1 != null) {
        ((cp)localObject1).tU(0);
      }
      localObject2 = this.kHp;
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.live.core.core.b.a)) {
        localObject1 = null;
      }
      localObject2 = (com.tencent.mm.live.core.core.b.a)localObject1;
      if (localObject2 == null) {
        break label531;
      }
      l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
      localObject1 = this.zkh;
      if (localObject1 == null) {
        break label525;
      }
    }
    label520:
    label525:
    for (Object localObject1 = ((cp)localObject1).kjc;; localObject1 = null)
    {
      localObject3 = this.zkh;
      if (localObject3 != null) {
        localTXCloudVideoView = ((cp)localObject3).aPH();
      }
      ((com.tencent.mm.live.core.core.b.a)localObject2).a(l, (TXLivePlayer)localObject1, localTXCloudVideoView);
      AppMethodBeat.o(291629);
      return;
      localObject1 = null;
      break;
      bool = false;
      break label363;
    }
    label531:
    AppMethodBeat.o(291629);
    return;
    label538:
    AppMethodBeat.o(291629);
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(291623);
    at localat = this.zje;
    if (localat != null)
    {
      if (localat.kiF.getVisibility() == 0)
      {
        this.kKL.stopTimer();
        this.kKL.startTimer(1000L);
      }
      AppMethodBeat.o(291623);
      return;
    }
    AppMethodBeat.o(291623);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "invoke"})
  public static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.an.c.a<att>, kotlin.x>
  {
    public a(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC$chooseAudienceMode$1$1"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    b(c paramc, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetUserGameConfigResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(c paramc, String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC$handleJoinResp$2$1"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    d(c paramc, awj paramawj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "enterRoomSuccess", "", "errCode", "", "errType", "errMsg", "", "extInfo", "Landroid/os/Bundle;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, Bundle, kotlin.x>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.u<Boolean, Integer, Integer, String, com.tencent.mm.live.core.core.model.f, TRTCCloudDef.TRTCParams, awj, kotlin.x>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder_release"})
  public static final class g
    implements RequestFloatWindowPermissionDialog.a
  {
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      int i = 1;
      AppMethodBeat.i(245577);
      kotlin.g.b.p.k(paramRequestFloatWindowPermissionDialog, "dialog");
      com.tencent.mm.plugin.finder.live.view.router.b localb = this.zkj.ycX;
      if (localb != null) {
        localb.setMiniWinPermission(false);
      }
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      paramRequestFloatWindowPermissionDialog.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true);
      localb = this.zkj.ycX;
      if ((localb != null) && (localb.isSwipeBack() == true)) {}
      for (;;)
      {
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", i);
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
        localb = this.zkj.ycX;
        if (localb != null) {
          localb.statusChange(b.c.kzi, paramRequestFloatWindowPermissionDialog);
        }
        c.dHt();
        AppMethodBeat.o(245577);
        return;
        i = 3;
      }
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(245579);
      kotlin.g.b.p.k(paramRequestFloatWindowPermissionDialog, "dialog");
      com.tencent.mm.plugin.finder.live.view.router.b localb = this.zkj.ycX;
      if (localb != null) {
        localb.setMiniWinPermission(false);
      }
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      paramRequestFloatWindowPermissionDialog.putBoolean("PARAM_LIVE_MINI_WINDOW_AUTO", true);
      localb = this.zkj.ycX;
      if (localb != null)
      {
        localb.statusChange(b.c.kzl, paramRequestFloatWindowPermissionDialog);
        AppMethodBeat.o(245579);
        return;
      }
      AppMethodBeat.o(245579);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(245580);
      kotlin.g.b.p.k(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog = this.zkj.ycX;
      if (paramRequestFloatWindowPermissionDialog != null) {
        paramRequestFloatWindowPermissionDialog.setMiniWinPermission(false);
      }
      paramRequestFloatWindowPermissionDialog = new Bundle();
      paramRequestFloatWindowPermissionDialog.putBoolean("PARAM_LIVE_MINI_WINDOW_AUTO", true);
      com.tencent.mm.plugin.finder.live.view.router.b localb = this.zkj.ycX;
      if (localb != null)
      {
        localb.statusChange(b.c.kzm, paramRequestFloatWindowPermissionDialog);
        AppMethodBeat.o(245580);
        return;
      }
      AppMethodBeat.o(245580);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class i
    implements Runnable
  {
    public i(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(291641);
      Object localObject = c.g(this.zkj);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.c.a)localObject).kiF;
        if (localObject != null)
        {
          ct localct = c.h(this.zkj);
          if (localct != null)
          {
            localct.ey((View)localObject);
            AppMethodBeat.o(291641);
            return;
          }
          AppMethodBeat.o(291641);
          return;
        }
      }
      AppMethodBeat.o(291641);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "invoke"})
  public static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    public j(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    public k(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class l
    implements MTimerHandler.CallBack
  {
    l(c paramc) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(265084);
      Object localObject = c.g(this.zkj);
      if ((localObject != null) && (((com.tencent.mm.live.c.a)localObject).kiF.getVisibility() == 0))
      {
        localObject = c.g(this.zkj);
        if (localObject != null) {
          ((at)localObject).Ny(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.zkj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.fod);
        }
        localObject = c.g(this.zkj);
        if (localObject != null) {
          ((at)localObject).dBp();
        }
        localObject = c.g(this.zkj);
        if (localObject != null) {
          ((at)localObject).dBo();
        }
      }
      localObject = c.o(this.zkj);
      if ((localObject != null) && (((com.tencent.mm.live.c.a)localObject).kiF.getVisibility() == 0))
      {
        localObject = c.o(this.zkj);
        if (localObject != null) {
          ((o)localObject).Lp(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.zkj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfk);
        }
      }
      localObject = c.p(this.zkj);
      if ((localObject != null) && (((com.tencent.mm.live.c.a)localObject).kiF.getVisibility() == 0))
      {
        localObject = c.p(this.zkj);
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.x)localObject).dAL();
        }
      }
      AppMethodBeat.o(265084);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c
 * JD-Core Version:    0.7.0.1
 */