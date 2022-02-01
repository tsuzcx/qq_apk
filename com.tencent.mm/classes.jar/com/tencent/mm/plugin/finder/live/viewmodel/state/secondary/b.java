package com.tencent.mm.plugin.finder.live.viewmodel.state.secondary;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.y;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.live.component.aj.a;
import com.tencent.mm.plugin.finder.live.component.statecomponent.c;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.ap.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ab;
import com.tencent.mm.plugin.finder.live.plugin.ak;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.av;
import com.tencent.mm.plugin.finder.live.plugin.aw;
import com.tencent.mm.plugin.finder.live.plugin.ay;
import com.tencent.mm.plugin.finder.live.plugin.az;
import com.tencent.mm.plugin.finder.live.plugin.ba;
import com.tencent.mm.plugin.finder.live.plugin.bc;
import com.tencent.mm.plugin.finder.live.plugin.be;
import com.tencent.mm.plugin.finder.live.plugin.bg;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.bl;
import com.tencent.mm.plugin.finder.live.plugin.bp;
import com.tencent.mm.plugin.finder.live.plugin.bq;
import com.tencent.mm.plugin.finder.live.plugin.br;
import com.tencent.mm.plugin.finder.live.plugin.bt;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.plugin.ca;
import com.tencent.mm.plugin.finder.live.plugin.cc;
import com.tencent.mm.plugin.finder.live.plugin.cd;
import com.tencent.mm.plugin.finder.live.plugin.cf;
import com.tencent.mm.plugin.finder.live.plugin.k;
import com.tencent.mm.plugin.finder.live.plugin.l;
import com.tencent.mm.plugin.finder.live.plugin.n;
import com.tencent.mm.plugin.finder.live.plugin.o;
import com.tencent.mm.plugin.finder.live.plugin.p;
import com.tencent.mm.plugin.finder.live.plugin.w;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.z;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.utils.bb;
import com.tencent.mm.plugin.finder.utils.bb.c;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveSecondaryStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "allowanceGiftBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAllowanceGiftBubblePlugin;", "allowanceGiftCardPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAllowanceGiftCardPlugin;", "anchorDescEditPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorDescEditPlugin;", "anchorFansClubPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorFansClubPlugin;", "anchorFastCommentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorFastCommentPlugin;", "anchorMoreOptionPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMoreOptionPanelPlugin;", "anchorPausePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin;", "anchorPromotePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPromotionPlugin;", "audioModePreviewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAudioModePreviewPlugin;", "bottomOptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin;", "bubbleContainer", "Landroid/view/View;", "cameraOptPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPanelPlugin;", "closePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin;", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "commonInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "confettiPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "decorationPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveDecorationPlugin;", "exceptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "getExceptionPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;", "setExceptionPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorExceptionPlugin;)V", "gameWelfareTaskBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameWelfareTaskBubblePlugin;", "giftPlayPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "giftQueuePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin;", "lastAudioMode", "", "lastScreenShareMode", "likePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin;", "linkApplyListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "linkStatePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin;", "liveTXLivePlayerPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTXLivePlayerPlugin;", "lotteryBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "lotteryCardPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin;", "luckyMoneyPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin;", "memberListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin;", "micAudioPreviewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicAudioPreviewPlugin;", "micDecoratePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin;", "moreActionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;", "optionPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin;", "originCommentBottomMargin", "", "postPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin;", "profilePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewMemberProfilePlugin;", "promoteBannerPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBannerPlugin;", "promottingBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBubblePlugin;", "readyPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin;", "shadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "shoppingListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "subtitlePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveSubtitlePlugin;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimerThread", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setTimerThread", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "titleInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "topCommentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;", "adjustLayout", "", "adjustLayoutCDN", "checkAnchorAudioModeBySei", "userStatus", "checkDecorationInfo", "checkFinderObject", "checkLinkMicStateWhenJoin", "micInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMicInfo;", "checkMiniWindow", "checkSeiServerTime", "anchorServerTime", "", "anchorIdBySei", "chooseAudienceMode", "fromMiniWin", "handleCheerIconsInfo", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "handleJoinLiveWxshopResponse", "response", "handleJoinResp", "success", "errCode", "errType", "errMsg", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "handleLiveErr", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "errorPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "hideBottomAraePlugin", "initPlugins", "initShoppingPlugins", "joinLive", "joinLiveByMiniWin", "liveEndWithAnimation", "miniWindow", "notifyMicUserVolume", "notityAnchorInfoBySei", "anchorUserId", "songId", "playStatus", "onAcceptLinkMicOthers", "micType", "(Ljava/lang/Integer;)V", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "onLiveEnd", "onLiveEventCallback", "errorCode", "param", "Landroid/os/Bundle;", "onLiveMsgChanged", "onLiveMsgSlowChanged", "onLivePrepare", "onLiveStart", "onRelease", "onResume", "onStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "onStop", "prepareShopping", "report", "showLivePauseTip", "startLive", "byMiniWin", "startTimer", "stopLiveVideo", "stopTimer", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c
{
  public boolean CuM;
  public boolean CuN;
  public com.tencent.mm.plugin.finder.live.plugin.ah DcS;
  public l EiN;
  public y EiP;
  public cd EiQ;
  public com.tencent.mm.plugin.finder.live.plugin.aj EiR;
  public bt EiS;
  public com.tencent.mm.plugin.finder.live.plugin.j EiT;
  public com.tencent.mm.plugin.finder.live.plugin.bd EiU;
  public bk EiV;
  public az EiW;
  public bg EiX;
  public bq EiY;
  public br EiZ;
  public bp EjB;
  public k EjC;
  public n EjD;
  public com.tencent.mm.plugin.finder.live.plugin.s EjE;
  private com.tencent.mm.plugin.finder.live.plugin.m EjF;
  public ak EjG;
  private int EjH;
  public cc EjV;
  public ca EjW;
  private bl EjX;
  public at EjY;
  private View EjZ;
  public bz Eja;
  public cf Ejb;
  public o Ejc;
  private com.tencent.mm.plugin.finder.live.plugin.i Ejd;
  private ay Eje;
  public ba Ejf;
  public com.tencent.mm.plugin.finder.live.plugin.r Ejg;
  public com.tencent.mm.plugin.finder.live.plugin.d Ejh;
  public com.tencent.mm.plugin.finder.live.plugin.e Eji;
  public av Ejj;
  public aw Ejk;
  private com.tencent.mm.plugin.finder.live.plugin.q Ejl;
  private p Ejn;
  public com.tencent.mm.plugin.finder.live.plugin.bf Ejo;
  public com.tencent.mm.plugin.finder.live.plugin.h Ejp;
  public bc Ejq;
  private be Ejr;
  public ab Ejt;
  public com.tencent.mm.plugin.finder.live.plugin.z Ejv;
  private w Ejy;
  public final String TAG;
  public MTimerHandler nmZ;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(357210);
    this.TAG = "FinderLiveSecondaryStartUIC";
    this.nmZ = new MTimerHandler("LiveCommonInfoPlugin::Timer", new b..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(357210);
  }
  
  private static final void a(Bundle paramBundle, b paramb, com.tencent.mm.plugin.finder.live.plugin.ah paramah)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(357292);
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
          AppMethodBeat.o(357292);
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
      AppMethodBeat.o(357292);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    paramBundle.addRule(12);
    paramBundle.removeRule(2);
    AppMethodBeat.o(357292);
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
      AppMethodBeat.o(357292);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    paramBundle.removeRule(12);
    View localView = paramb.EjZ;
    if (localView == null) {}
    for (i = j;; i = localView.getId())
    {
      paramBundle.addRule(2, i);
      paramBundle = paramah.mJe.getLayoutParams();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(357292);
      throw paramBundle;
    }
    ((ViewGroup.MarginLayoutParams)paramBundle).bottomMargin = paramb.EjH;
    paramah.mJe.requestLayout();
    AppMethodBeat.o(357292);
  }
  
  private static final boolean b(b paramb)
  {
    AppMethodBeat.i(357275);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject1 = paramb.EiR;
    if ((localObject1 != null) && (((com.tencent.mm.live.b.a)localObject1).mJe.getVisibility() == 0))
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = paramb.EiR;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject1).OX(((f)paramb.business(f.class)).liveInfo.startTime);
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
      AppMethodBeat.o(357275);
      return true;
      i = 0;
      break;
      ((LinkedList)localObject1).add(new kotlin.r(Integer.valueOf(2), null));
      break label121;
      i = 0;
      break label246;
    }
  }
  
  private static final void c(b paramb)
  {
    AppMethodBeat.i(357281);
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
    AppMethodBeat.o(357281);
  }
  
  private final void ezA()
  {
    AppMethodBeat.i(357219);
    Object localObject = this.CCe;
    if (localObject != null)
    {
      Log.i(this.TAG, "user:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC + ",bind shop:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).CEZ);
      if ((this.Ejp != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).CEZ))
      {
        View localView = ((com.tencent.mm.plugin.finder.live.view.router.b)localObject).findViewById(p.e.BSz);
        kotlin.g.b.s.s(localView, "router.findViewById(R.id…_live_shopping_list_root)");
        this.Eja = new bz((ViewGroup)localView, (com.tencent.mm.live.b.b)localObject);
        localObject = this.Eja;
        if (localObject != null) {
          ((bz)localObject).mount();
        }
      }
    }
    AppMethodBeat.o(357219);
  }
  
  private final void ezB()
  {
    AppMethodBeat.i(357254);
    Object localObject1 = this.EjV;
    Object localObject2;
    label28:
    RelativeLayout.LayoutParams localLayoutParams;
    label43:
    label57:
    label72:
    int j;
    int k;
    int m;
    int i;
    float f2;
    float f1;
    Object localObject3;
    int n;
    int i1;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label739;
      }
      localObject1 = null;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label749;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)localObject1;
      localObject1 = this.CCe;
      if (localObject1 != null) {
        break label755;
      }
      localObject1 = null;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label783;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      j = 0;
      k = -1;
      m = -1;
      int i5 = this.CCa.getResources().getConfiguration().orientation;
      boolean bool1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).ejX();
      int i4 = 0;
      i = 0;
      float f5 = 0.0F;
      f2 = 0.0F;
      float f6 = 0.0F;
      f1 = 0.0F;
      boolean bool2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyD();
      localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject3 = com.tencent.mm.plugin.finder.live.utils.a.gG((Context)this.CCa);
      int i6 = ((Number)((kotlin.r)localObject3).bsC).intValue();
      ((Number)((kotlin.r)localObject3).bsD).intValue();
      float f3 = f6;
      float f4 = f5;
      n = i4;
      i1 = m;
      int i2 = k;
      int i3 = j;
      if (bool1)
      {
        f3 = f6;
        f4 = f5;
        n = i4;
        i1 = m;
        i2 = k;
        i3 = j;
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyM())
        {
          f3 = f6;
          f4 = f5;
          n = i4;
          i1 = m;
          i2 = k;
          i3 = j;
          if (1 == i5)
          {
            f3 = f6;
            f4 = f5;
            n = i4;
            i1 = m;
            i2 = k;
            i3 = j;
            if (bool2)
            {
              if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyE()) {
                break label789;
              }
              localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
              m = com.tencent.mm.plugin.finder.live.utils.a.euM();
              k = i6 / 2;
              j = (int)(1.777778F * k);
              k = (int)(k * 1.777778F);
              label360:
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcH = false;
              localObject3 = this.CCe;
              f3 = f1;
              f4 = f2;
              n = i;
              i1 = j;
              i2 = k;
              i3 = m;
              if (localObject3 != null)
              {
                ((com.tencent.mm.plugin.finder.live.view.router.b)localObject3).onScreenClear(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcH);
                i3 = m;
                i2 = k;
                i1 = j;
                n = i;
                f4 = f2;
                f3 = f1;
              }
            }
          }
        }
      }
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).topMargin = i3;
      }
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).height = i2;
      }
      if (localLayoutParams != null) {
        localLayoutParams.height = i1;
      }
      localObject3 = this.CCe;
      if (localObject3 != null) {
        break label1037;
      }
      localObject3 = null;
      label495:
      if (localObject3 != null) {
        ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (localObject2 != null) {
        ((TXCloudVideoView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      localObject3 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("adjustLayoutCDN fitLandscapeVideo:").append(bool1).append(",curOrientation:").append(i5).append(",videoSizeValid:").append(bool2).append(",uiState:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS).append(",videoScaleHeight:").append(n).append(",limitHeight:").append(f4).append(",landscapePlayerMiniHeight:").append(f3).append(",parentLp height:");
      if (localObject1 != null) {
        break label1047;
      }
      localObject2 = null;
      label638:
      localObject2 = localStringBuilder.append(localObject2).append(",top:");
      if (localObject1 != null) {
        break label1060;
      }
      localObject1 = null;
      label661:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", height:");
      if (localLayoutParams != null) {
        break label1073;
      }
      localObject1 = null;
      label684:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",top:");
      if (localLayoutParams != null) {
        break label1086;
      }
    }
    label783:
    label789:
    label1047:
    label1060:
    label1073:
    label1086:
    for (localObject1 = null;; localObject1 = Integer.valueOf(localLayoutParams.topMargin))
    {
      Log.i((String)localObject3, localObject1);
      AppMethodBeat.o(357254);
      return;
      localObject2 = ((cc)localObject1).bjv();
      break;
      label739:
      localObject1 = ((TXCloudVideoView)localObject2).getLayoutParams();
      break label28;
      label749:
      localLayoutParams = null;
      break label43;
      label755:
      localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).getPreviewRoot();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label57;
      }
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      break label57;
      localObject1 = null;
      break label72;
      f1 = com.tencent.mm.ui.bf.bf(MMApplicationContext.getContext()).x;
      i = (int)(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).videoHeight / ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).videoWidth * f1);
      f2 = com.tencent.mm.ui.bf.bf(MMApplicationContext.getContext()).y * 0.688F;
      f1 = MMApplicationContext.getContext().getResources().getDimension(p.c.finder_32A);
      if (i <= f2)
      {
        n = (int)(0.156F * com.tencent.mm.ui.bf.bf(MMApplicationContext.getContext()).y) + com.tencent.mm.ui.bf.getStatusBarHeight((Context)this.CCa);
        if (i < f1)
        {
          k = (int)f1;
          j = k;
          m = n;
          if (localLayoutParams == null) {
            break label1010;
          }
          localLayoutParams.addRule(16);
          j = i;
          m = i;
          i = j;
          j = m;
          m = n;
          break label360;
        }
        m = i;
        j = i;
        k = i;
        i = m;
        m = n;
        break label360;
      }
      k = 0;
      n = -1;
      j = n;
      m = k;
      if (localLayoutParams != null)
      {
        localLayoutParams.addRule(16);
        m = k;
        j = n;
      }
      label1010:
      k = i;
      n = i;
      i1 = j;
      i = k;
      j = n;
      k = i1;
      break label360;
      localObject3 = ((com.tencent.mm.plugin.finder.live.view.router.b)localObject3).getPreviewRoot();
      break label495;
      localObject2 = Integer.valueOf(((RelativeLayout.LayoutParams)localObject1).height);
      break label638;
      localObject1 = Integer.valueOf(((RelativeLayout.LayoutParams)localObject1).topMargin);
      break label661;
      localObject1 = Integer.valueOf(localLayoutParams.height);
      break label684;
    }
  }
  
  private final void ezr()
  {
    AppMethodBeat.i(357266);
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
        l1 = ((f)business(f.class)).liveInfo.liveId;
        l2 = ((f)business(f.class)).hKN;
        str = com.tencent.mm.model.z.bAW();
        kotlin.g.b.s.s(str, "getMyFinderUsername()");
        arrayOfByte = ((f)business(f.class)).mZp;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject != null) {
          break label177;
        }
      }
    }
    label177:
    for (Object localObject = null;; localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).EeF)
    {
      ap.a.a(localap, localMMActivity, l1, l2, str, arrayOfByte, null, (String)localObject, (kotlin.g.a.b)new m(this), 64);
      AppMethodBeat.o(357266);
      return;
    }
  }
  
  private final void ezv()
  {
    AppMethodBeat.i(357231);
    Object localObject = new Bundle();
    com.tencent.mm.plugin.finder.live.view.router.b localb = this.CCe;
    boolean bool;
    if (localb == null)
    {
      bool = false;
      ((Bundle)localObject).putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", bool);
      localb = this.CCe;
      if ((localb == null) || (localb.isSwipeBack() != true)) {
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
      localObject = this.CCe;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.b)localObject).setMiniWinPermission(true);
      }
      localObject = this.CCe;
      if (localObject != null) {
        b.b.a((com.tencent.mm.live.b.b)localObject, com.tencent.mm.live.b.b.c.ncz);
      }
      RequestFloatWindowPermissionDialog.a((Context)this.CCa, this.CCa.getString(p.h.live_room_mini_view_fail), (RequestFloatWindowPermissionDialog.a)new h(this), false, com.tencent.mm.bq.a.aQB());
      AppMethodBeat.o(357231);
      return;
      bool = localb.needRemoveActivity();
      break;
      i = 0;
      break label57;
    }
    label197:
    localb = this.CCe;
    if (localb != null) {
      localb.setMiniWinPermission(false);
    }
    localb = this.CCe;
    if (localb != null) {
      localb.statusChange(com.tencent.mm.live.b.b.c.ncx, (Bundle)localObject);
    }
    report();
    AppMethodBeat.o(357231);
  }
  
  private static void report()
  {
    AppMethodBeat.i(357236);
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
      AppMethodBeat.o(357236);
      return;
      if (com.tencent.mm.plugin.expt.hellhound.a.zAJ) {
        localObject = String.valueOf(q.z.DxB.type);
      } else {
        localObject = String.valueOf(q.z.Dxz.type);
      }
    }
  }
  
  /* Error */
  public final void a(com.tencent.mm.live.b.b.c paramc, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 1731
    //   3: invokestatic 330	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 1732
    //   10: invokestatic 356	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 1736	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b$a:$EnumSwitchMapping$0	[I
    //   16: aload_1
    //   17: invokevirtual 1739	com/tencent/mm/live/b/b$c:ordinal	()I
    //   20: iaload
    //   21: tableswitch	default:+75 -> 96, 1:+82->103, 2:+250->271, 3:+861->882, 4:+916->937, 5:+1133->1154, 6:+1133->1154, 7:+1169->1190, 8:+1270->1291, 9:+1842->1863, 10:+1994->2015, 11:+1994->2015, 12:+2854->2875, 13:+2899->2920, 14:+2933->2954, 15:+2974->2995
    //   97: iconst_3
    //   98: monitorexit
    //   99: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: return
    //   103: aload_0
    //   104: getfield 363	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:TAG	Ljava/lang/String;
    //   107: ldc_w 1741
    //   110: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: ldc_w 533
    //   117: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   120: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   123: invokevirtual 1744	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyA	()Z
    //   126: ifne +81 -> 207
    //   129: aload_0
    //   130: getfield 1746	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiS	Lcom/tencent/mm/plugin/finder/live/plugin/bt;
    //   133: astore_1
    //   134: aload_1
    //   135: ifnull +13 -> 148
    //   138: aload_1
    //   139: bipush 8
    //   141: invokevirtual 1751	com/tencent/mm/plugin/finder/live/plugin/bt:tO	(I)V
    //   144: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   147: astore_1
    //   148: aload_0
    //   149: getfield 921	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCe	Lcom/tencent/mm/plugin/finder/live/view/router/b;
    //   152: astore_1
    //   153: aload_1
    //   154: ifnull +53 -> 207
    //   157: aload_0
    //   158: ldc_w 533
    //   161: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   164: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   167: getfield 986	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:mIC	Ljava/lang/String;
    //   170: astore 6
    //   172: aload_0
    //   173: getfield 1262	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCa	Landroidx/appcompat/app/AppCompatActivity;
    //   176: invokevirtual 1270	androidx/appcompat/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   179: getstatic 1754	com/tencent/mm/plugin/finder/live/p$h:live_local_network_error_tip	I
    //   182: invokevirtual 1280	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   185: astore 7
    //   187: aload 7
    //   189: ldc_w 1756
    //   192: invokestatic 720	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   195: aload_1
    //   196: aload 6
    //   198: aload 7
    //   200: invokevirtual 1759	com/tencent/mm/plugin/finder/live/view/router/b:showTipWithBlurBg	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   206: astore_1
    //   207: getstatic 959	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   210: getstatic 1199	com/tencent/mm/plugin/finder/live/report/q$a:DqG	Lcom/tencent/mm/plugin/finder/live/report/q$a;
    //   213: getfield 1202	com/tencent/mm/plugin/finder/live/report/q$a:mwI	J
    //   216: getstatic 1208	com/tencent/mm/plugin/finder/live/report/q$bs:DCa	Lcom/tencent/mm/plugin/finder/live/report/q$bs;
    //   219: getfield 1211	com/tencent/mm/plugin/finder/live/report/q$bs:type	I
    //   222: invokestatic 1214	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   225: invokevirtual 1218	com/tencent/mm/plugin/finder/live/report/j:C	(JLjava/lang/String;)V
    //   228: getstatic 959	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   231: astore_1
    //   232: aload_2
    //   233: ifnonnull +26 -> 259
    //   236: iconst_0
    //   237: istore_3
    //   238: iload_3
    //   239: invokestatic 1221	com/tencent/mm/plugin/finder/live/report/j:setErrorCode	(I)V
    //   242: getstatic 959	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   245: astore_1
    //   246: getstatic 1227	com/tencent/mm/plugin/finder/live/report/q$v:DwK	Lcom/tencent/mm/plugin/finder/live/report/q$v;
    //   249: invokestatic 1230	com/tencent/mm/plugin/finder/live/report/j:b	(Lcom/tencent/mm/plugin/finder/live/report/q$v;)V
    //   252: ldc_w 1731
    //   255: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: return
    //   259: aload_2
    //   260: ldc_w 1761
    //   263: iconst_0
    //   264: invokevirtual 1765	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   267: istore_3
    //   268: goto -30 -> 238
    //   271: aload_2
    //   272: ifnonnull +538 -> 810
    //   275: iconst_0
    //   276: istore 5
    //   278: aload_0
    //   279: getfield 363	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:TAG	Ljava/lang/String;
    //   282: astore_2
    //   283: new 460	java/lang/StringBuilder
    //   286: dup
    //   287: ldc_w 1767
    //   290: invokespecial 463	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: astore 6
    //   295: aload_0
    //   296: ldc_w 533
    //   299: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   302: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   305: getfield 1771	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:Eco	Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   308: astore_1
    //   309: aload_1
    //   310: ifnonnull +512 -> 822
    //   313: aconst_null
    //   314: astore_1
    //   315: aload_2
    //   316: aload 6
    //   318: aload_1
    //   319: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   322: ldc_w 1773
    //   325: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_0
    //   329: ldc_w 631
    //   332: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   335: checkcast 631	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   338: getfield 1776	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:nonceId	Ljava/lang/String;
    //   341: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 495	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: aload_0
    //   351: ldc_w 533
    //   354: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   357: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   360: getfield 1771	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:Eco	Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   363: ifnull +36 -> 399
    //   366: aload_0
    //   367: ldc_w 533
    //   370: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   373: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   376: getfield 1771	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:Eco	Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   379: astore_1
    //   380: aload_1
    //   381: ifnull +452 -> 833
    //   384: aload_1
    //   385: getfield 1781	com/tencent/mm/protocal/protobuf/FinderObject:id	J
    //   388: lconst_0
    //   389: lcmp
    //   390: ifne +443 -> 833
    //   393: iconst_1
    //   394: istore_3
    //   395: iload_3
    //   396: ifeq +145 -> 541
    //   399: aload_0
    //   400: ldc_w 631
    //   403: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   406: checkcast 631	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   409: getfield 1776	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:nonceId	Ljava/lang/String;
    //   412: invokestatic 1784	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   415: ifne +126 -> 541
    //   418: new 1786	com/tencent/mm/protocal/protobuf/bui
    //   421: dup
    //   422: invokespecial 1787	com/tencent/mm/protocal/protobuf/bui:<init>	()V
    //   425: astore_1
    //   426: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   429: astore_2
    //   430: invokestatic 1791	com/tencent/mm/plugin/finder/live/model/aj:egD	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/g;
    //   433: astore_2
    //   434: aload_2
    //   435: ifnonnull +403 -> 838
    //   438: iconst_0
    //   439: istore_3
    //   440: aload_1
    //   441: iload_3
    //   442: putfield 1794	com/tencent/mm/protocal/protobuf/bui:hLK	I
    //   445: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   448: astore_2
    //   449: invokestatic 1791	com/tencent/mm/plugin/finder/live/model/aj:egD	()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/g;
    //   452: astore_2
    //   453: aload_2
    //   454: ifnonnull +406 -> 860
    //   457: iconst_0
    //   458: istore_3
    //   459: aload_1
    //   460: iload_3
    //   461: putfield 1797	com/tencent/mm/protocal/protobuf/bui:AJo	I
    //   464: ldc_w 793
    //   467: invokestatic 799	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   470: astore_2
    //   471: aload_2
    //   472: ldc_w 801
    //   475: invokestatic 720	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   478: aload_2
    //   479: checkcast 793	com/tencent/mm/plugin/h
    //   482: aload_0
    //   483: getfield 1262	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCa	Landroidx/appcompat/app/AppCompatActivity;
    //   486: checkcast 1583	com/tencent/mm/ui/MMActivity
    //   489: aload_0
    //   490: ldc_w 631
    //   493: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   496: checkcast 631	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   499: getfield 1586	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:hKN	J
    //   502: aload_0
    //   503: ldc_w 631
    //   506: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   509: checkcast 631	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   512: getfield 1776	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:nonceId	Ljava/lang/String;
    //   515: ldc_w 1254
    //   518: iconst_1
    //   519: aconst_null
    //   520: iconst_0
    //   521: aconst_null
    //   522: aload_1
    //   523: iconst_0
    //   524: new 9	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b$c
    //   527: dup
    //   528: aload_0
    //   529: invokespecial 1798	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b$c:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b;)V
    //   532: checkcast 1600	kotlin/g/a/b
    //   535: ldc_w 1799
    //   538: invokestatic 1802	com/tencent/mm/plugin/h$a:a	(Lcom/tencent/mm/plugin/h;Lcom/tencent/mm/ui/MMActivity;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/bui;ILkotlin/g/a/b;I)V
    //   541: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   544: astore_1
    //   545: invokestatic 1805	com/tencent/mm/plugin/finder/live/model/aj:biS	()V
    //   548: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   551: astore_1
    //   552: aload_0
    //   553: ldc_w 631
    //   556: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   559: checkcast 631	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   562: getfield 635	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   565: getfield 640	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   568: invokestatic 1808	com/tencent/mm/plugin/finder/live/model/aj:oc	(J)V
    //   571: aload_0
    //   572: getfield 1075	com/tencent/mm/plugin/finder/live/component/statecomponent/c:nkg	Lcom/tencent/mm/live/core/core/trtc/a;
    //   575: astore_1
    //   576: aload_1
    //   577: ifnull +8 -> 585
    //   580: aload_1
    //   581: invokevirtual 1811	com/tencent/mm/live/core/core/trtc/a:bcj	()I
    //   584: pop
    //   585: aload_0
    //   586: invokevirtual 1813	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:startTimer	()V
    //   589: aload_0
    //   590: getfield 1672	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejf	Lcom/tencent/mm/plugin/finder/live/plugin/ba;
    //   593: astore_1
    //   594: aload_1
    //   595: ifnull +11 -> 606
    //   598: aload_1
    //   599: invokevirtual 1818	com/tencent/mm/plugin/finder/live/plugin/ba:eqO	()V
    //   602: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   605: astore_1
    //   606: aload_0
    //   607: getfield 1683	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejq	Lcom/tencent/mm/plugin/finder/live/plugin/bc;
    //   610: astore_1
    //   611: aload_1
    //   612: ifnull +11 -> 623
    //   615: aload_1
    //   616: invokevirtual 1823	com/tencent/mm/plugin/finder/live/plugin/bc:eqX	()V
    //   619: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   622: astore_1
    //   623: aload_0
    //   624: invokespecial 1825	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:ezr	()V
    //   627: getstatic 959	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   630: astore_1
    //   631: getstatic 1698	com/tencent/mm/plugin/finder/live/report/j:Doc	Lcom/tencent/mm/plugin/finder/live/report/q;
    //   634: getfield 1828	com/tencent/mm/plugin/finder/live/report/q:Dqs	Z
    //   637: ifne +36 -> 673
    //   640: getstatic 959	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   643: getstatic 1199	com/tencent/mm/plugin/finder/live/report/q$a:DqG	Lcom/tencent/mm/plugin/finder/live/report/q$a;
    //   646: getfield 1202	com/tencent/mm/plugin/finder/live/report/q$a:mwI	J
    //   649: getstatic 1831	com/tencent/mm/plugin/finder/live/report/q$bs:DCb	Lcom/tencent/mm/plugin/finder/live/report/q$bs;
    //   652: getfield 1211	com/tencent/mm/plugin/finder/live/report/q$bs:type	I
    //   655: invokestatic 1214	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   658: invokevirtual 1218	com/tencent/mm/plugin/finder/live/report/j:C	(JLjava/lang/String;)V
    //   661: getstatic 959	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   664: getstatic 1834	com/tencent/mm/plugin/finder/live/report/q$c:Drg	Lcom/tencent/mm/plugin/finder/live/report/q$c;
    //   667: ldc_w 1254
    //   670: invokevirtual 1719	com/tencent/mm/plugin/finder/live/report/j:a	(Lcom/tencent/mm/plugin/finder/live/report/q$c;Ljava/lang/String;)V
    //   673: aload_0
    //   674: ldc_w 548
    //   677: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   680: checkcast 548	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   683: getfield 620	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   686: astore_1
    //   687: aload_1
    //   688: ifnull +58 -> 746
    //   691: aload_0
    //   692: getfield 1836	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejo	Lcom/tencent/mm/plugin/finder/live/plugin/bf;
    //   695: astore_2
    //   696: aload_2
    //   697: ifnull +15 -> 712
    //   700: aload_2
    //   701: aload_1
    //   702: getfield 1839	com/tencent/mm/plugin/finder/live/viewmodel/data/h:mXL	Ljava/lang/String;
    //   705: invokevirtual 1844	com/tencent/mm/plugin/finder/live/plugin/bf:awC	(Ljava/lang/String;)V
    //   708: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   711: astore_1
    //   712: aload_0
    //   713: getfield 1338	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiR	Lcom/tencent/mm/plugin/finder/live/plugin/aj;
    //   716: astore_1
    //   717: aload_1
    //   718: ifnull +11 -> 729
    //   721: aload_1
    //   722: invokevirtual 1847	com/tencent/mm/plugin/finder/live/plugin/aj:emx	()V
    //   725: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   728: astore_1
    //   729: aload_0
    //   730: getfield 1338	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiR	Lcom/tencent/mm/plugin/finder/live/plugin/aj;
    //   733: astore_1
    //   734: aload_1
    //   735: ifnull +11 -> 746
    //   738: aload_1
    //   739: invokevirtual 1850	com/tencent/mm/plugin/finder/live/plugin/aj:emy	()V
    //   742: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   745: astore_1
    //   746: aload_0
    //   747: getfield 1852	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EjW	Lcom/tencent/mm/plugin/finder/live/plugin/ca;
    //   750: astore_1
    //   751: aload_1
    //   752: ifnull +11 -> 763
    //   755: aload_1
    //   756: invokevirtual 1857	com/tencent/mm/plugin/finder/live/plugin/ca:eoD	()V
    //   759: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   762: astore_1
    //   763: iload 5
    //   765: ifeq +20 -> 785
    //   768: aload_0
    //   769: getfield 1859	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejk	Lcom/tencent/mm/plugin/finder/live/plugin/aw;
    //   772: astore_1
    //   773: aload_1
    //   774: ifnull +11 -> 785
    //   777: aload_1
    //   778: invokevirtual 1864	com/tencent/mm/plugin/finder/live/plugin/aw:eqw	()V
    //   781: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   784: astore_1
    //   785: aload_0
    //   786: getfield 363	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:TAG	Ljava/lang/String;
    //   789: ldc_w 1866
    //   792: iload 5
    //   794: invokestatic 1871	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   797: invokestatic 524	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   800: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   803: ldc_w 1731
    //   806: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   809: return
    //   810: aload_2
    //   811: ldc_w 1873
    //   814: invokevirtual 389	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   817: istore 5
    //   819: goto -541 -> 278
    //   822: aload_1
    //   823: getfield 1781	com/tencent/mm/protocal/protobuf/FinderObject:id	J
    //   826: invokestatic 586	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   829: astore_1
    //   830: goto -515 -> 315
    //   833: iconst_0
    //   834: istore_3
    //   835: goto -440 -> 395
    //   838: aload_2
    //   839: getfield 1879	com/tencent/mm/plugin/finder/live/viewmodel/data/g:Bwy	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/j;
    //   842: astore_2
    //   843: aload_2
    //   844: ifnonnull +8 -> 852
    //   847: iconst_0
    //   848: istore_3
    //   849: goto -409 -> 440
    //   852: aload_2
    //   853: getfield 1882	com/tencent/mm/plugin/finder/live/viewmodel/data/j:AJo	I
    //   856: istore_3
    //   857: goto -417 -> 440
    //   860: aload_2
    //   861: getfield 1879	com/tencent/mm/plugin/finder/live/viewmodel/data/g:Bwy	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/j;
    //   864: astore_2
    //   865: aload_2
    //   866: ifnonnull +8 -> 874
    //   869: iconst_0
    //   870: istore_3
    //   871: goto -412 -> 459
    //   874: aload_2
    //   875: getfield 1882	com/tencent/mm/plugin/finder/live/viewmodel/data/j:AJo	I
    //   878: istore_3
    //   879: goto -420 -> 459
    //   882: aload_0
    //   883: getfield 921	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCe	Lcom/tencent/mm/plugin/finder/live/view/router/b;
    //   886: astore_1
    //   887: aload_1
    //   888: ifnull +8 -> 896
    //   891: aload_1
    //   892: iconst_0
    //   893: invokevirtual 1632	com/tencent/mm/plugin/finder/live/view/router/b:setMiniWinPermission	(Z)V
    //   896: aload_0
    //   897: getfield 1075	com/tencent/mm/plugin/finder/live/component/statecomponent/c:nkg	Lcom/tencent/mm/live/core/core/trtc/a;
    //   900: astore_1
    //   901: aload_1
    //   902: ifnull +11 -> 913
    //   905: aload_1
    //   906: invokevirtual 1885	com/tencent/mm/live/core/core/trtc/a:bci	()V
    //   909: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   912: astore_1
    //   913: aload_0
    //   914: getfield 921	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCe	Lcom/tencent/mm/plugin/finder/live/view/router/b;
    //   917: astore_1
    //   918: aload_1
    //   919: ifnull +11 -> 930
    //   922: aload_1
    //   923: invokevirtual 1888	com/tencent/mm/plugin/finder/live/view/router/b:finish	()V
    //   926: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   929: astore_1
    //   930: ldc_w 1731
    //   933: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   936: return
    //   937: aload_2
    //   938: ifnonnull +174 -> 1112
    //   941: aconst_null
    //   942: astore_1
    //   943: aload_2
    //   944: ifnonnull +183 -> 1127
    //   947: iconst_0
    //   948: istore_3
    //   949: aload_2
    //   950: ifnull +12 -> 962
    //   953: aload_2
    //   954: ldc_w 1619
    //   957: iconst_0
    //   958: invokevirtual 1765	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   961: pop
    //   962: aload_0
    //   963: getfield 1075	com/tencent/mm/plugin/finder/live/component/statecomponent/c:nkg	Lcom/tencent/mm/live/core/core/trtc/a;
    //   966: astore_2
    //   967: aload_2
    //   968: ifnull +171 -> 1139
    //   971: aload_2
    //   972: getfield 1892	com/tencent/mm/live/core/core/trtc/a:mRB	Lcom/tencent/mm/live/core/core/model/i;
    //   975: astore_2
    //   976: aload_2
    //   977: ifnull +162 -> 1139
    //   980: aload_2
    //   981: invokevirtual 1897	com/tencent/mm/live/core/core/model/i:isFloatMode	()Z
    //   984: ifne +155 -> 1139
    //   987: iconst_1
    //   988: istore 4
    //   990: iload 4
    //   992: ifeq +92 -> 1084
    //   995: getstatic 759	com/tencent/mm/plugin/finder/live/model/ar:CIh	Lcom/tencent/mm/plugin/finder/live/model/ar;
    //   998: astore_2
    //   999: invokestatic 1900	com/tencent/mm/plugin/finder/live/model/ar:emi	()V
    //   1002: aload_0
    //   1003: getfield 1075	com/tencent/mm/plugin/finder/live/component/statecomponent/c:nkg	Lcom/tencent/mm/live/core/core/trtc/a;
    //   1006: astore_2
    //   1007: aload_2
    //   1008: ifnull +40 -> 1048
    //   1011: aload_2
    //   1012: checkcast 1902	com/tencent/mm/live/core/core/b
    //   1015: astore_2
    //   1016: aload_0
    //   1017: getfield 1262	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCa	Landroidx/appcompat/app/AppCompatActivity;
    //   1020: checkcast 1264	android/content/Context
    //   1023: astore 6
    //   1025: aload_1
    //   1026: ifnonnull +119 -> 1145
    //   1029: iconst_1
    //   1030: istore 5
    //   1032: aload_2
    //   1033: aload 6
    //   1035: iload 5
    //   1037: iconst_0
    //   1038: iload_3
    //   1039: iconst_0
    //   1040: aconst_null
    //   1041: iconst_0
    //   1042: bipush 112
    //   1044: invokestatic 1907	com/tencent/mm/live/core/core/b$a:a	(Lcom/tencent/mm/live/core/core/b;Landroid/content/Context;ZZIILandroid/graphics/Bitmap;ZI)I
    //   1047: pop
    //   1048: aload_0
    //   1049: ldc_w 533
    //   1052: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1055: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1058: getfield 1503	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:EcS	I
    //   1061: ldc_w 1908
    //   1064: invokestatic 1912	com/tencent/mm/ae/d:ee	(II)Z
    //   1067: ifeq +10 -> 1077
    //   1070: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   1073: astore_1
    //   1074: invokestatic 1915	com/tencent/mm/plugin/finder/live/model/aj:elJ	()V
    //   1077: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   1080: astore_1
    //   1081: invokestatic 1918	com/tencent/mm/plugin/finder/live/model/aj:elN	()V
    //   1084: getstatic 959	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   1087: astore_1
    //   1088: getstatic 1698	com/tencent/mm/plugin/finder/live/report/j:Doc	Lcom/tencent/mm/plugin/finder/live/report/q;
    //   1091: getfield 1922	com/tencent/mm/plugin/finder/live/report/q:Dqq	Lcom/tencent/mm/plugin/finder/live/report/r;
    //   1094: astore_1
    //   1095: aload_1
    //   1096: aload_1
    //   1097: getfield 1927	com/tencent/mm/plugin/finder/live/report/r:DFY	J
    //   1100: lconst_1
    //   1101: ladd
    //   1102: putfield 1927	com/tencent/mm/plugin/finder/live/report/r:DFY	J
    //   1105: ldc_w 1731
    //   1108: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1111: return
    //   1112: aload_2
    //   1113: ldc_w 1612
    //   1116: iconst_1
    //   1117: invokevirtual 1930	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   1120: invokestatic 1871	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1123: astore_1
    //   1124: goto -181 -> 943
    //   1127: aload_2
    //   1128: ldc_w 1617
    //   1131: iconst_0
    //   1132: invokevirtual 1765	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1135: istore_3
    //   1136: goto -187 -> 949
    //   1139: iconst_0
    //   1140: istore 4
    //   1142: goto -152 -> 990
    //   1145: aload_1
    //   1146: invokevirtual 1933	java/lang/Boolean:booleanValue	()Z
    //   1149: istore 5
    //   1151: goto -119 -> 1032
    //   1154: aload_0
    //   1155: getfield 1075	com/tencent/mm/plugin/finder/live/component/statecomponent/c:nkg	Lcom/tencent/mm/live/core/core/trtc/a;
    //   1158: astore_1
    //   1159: aload_1
    //   1160: ifnull +23 -> 1183
    //   1163: aload_1
    //   1164: getfield 1892	com/tencent/mm/live/core/core/trtc/a:mRB	Lcom/tencent/mm/live/core/core/model/i;
    //   1167: astore_1
    //   1168: aload_1
    //   1169: ifnull +14 -> 1183
    //   1172: aload_1
    //   1173: getstatic 1939	com/tencent/mm/live/core/core/model/i$e:mOf	Lcom/tencent/mm/live/core/core/model/i$e;
    //   1176: putfield 1942	com/tencent/mm/live/core/core/model/i:mNK	Lcom/tencent/mm/live/core/core/model/i$e;
    //   1179: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1182: astore_1
    //   1183: ldc_w 1731
    //   1186: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1189: return
    //   1190: aload_2
    //   1191: ifnull +93 -> 1284
    //   1194: aload_2
    //   1195: ldc_w 1944
    //   1198: invokevirtual 1948	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   1201: astore_2
    //   1202: aload_2
    //   1203: ifnull +81 -> 1284
    //   1206: new 1950	com/tencent/mm/protocal/protobuf/bke
    //   1209: dup
    //   1210: invokespecial 1951	com/tencent/mm/protocal/protobuf/bke:<init>	()V
    //   1213: astore_1
    //   1214: aload_1
    //   1215: aload_2
    //   1216: invokevirtual 1955	com/tencent/mm/protocal/protobuf/bke:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   1219: pop
    //   1220: new 1957	java/util/ArrayList
    //   1223: dup
    //   1224: invokespecial 1958	java/util/ArrayList:<init>	()V
    //   1227: astore_2
    //   1228: aload_2
    //   1229: aload_1
    //   1230: invokevirtual 1959	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1233: pop
    //   1234: aload_0
    //   1235: getfield 1394	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejb	Lcom/tencent/mm/plugin/finder/live/plugin/cf;
    //   1238: astore_1
    //   1239: aload_1
    //   1240: ifnull +15 -> 1255
    //   1243: aload_1
    //   1244: aload_2
    //   1245: checkcast 691	java/util/List
    //   1248: invokevirtual 1962	com/tencent/mm/plugin/finder/live/plugin/cf:gF	(Ljava/util/List;)V
    //   1251: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1254: astore_1
    //   1255: getstatic 959	com/tencent/mm/plugin/finder/live/report/j:Dob	Lcom/tencent/mm/plugin/finder/live/report/j;
    //   1258: astore_1
    //   1259: getstatic 1698	com/tencent/mm/plugin/finder/live/report/j:Doc	Lcom/tencent/mm/plugin/finder/live/report/q;
    //   1262: getfield 1922	com/tencent/mm/plugin/finder/live/report/q:Dqq	Lcom/tencent/mm/plugin/finder/live/report/r;
    //   1265: astore_1
    //   1266: aload_1
    //   1267: aload_1
    //   1268: getfield 1965	com/tencent/mm/plugin/finder/live/report/r:DGj	J
    //   1271: lconst_1
    //   1272: ladd
    //   1273: putfield 1965	com/tencent/mm/plugin/finder/live/report/r:DGj	J
    //   1276: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1279: astore_1
    //   1280: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1283: astore_1
    //   1284: ldc_w 1731
    //   1287: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1290: return
    //   1291: aload_0
    //   1292: getfield 363	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:TAG	Ljava/lang/String;
    //   1295: ldc_w 1967
    //   1298: aload_2
    //   1299: invokestatic 524	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1302: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1305: aload_0
    //   1306: ldc_w 533
    //   1309: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1312: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1315: astore_1
    //   1316: aload_2
    //   1317: ifnonnull +455 -> 1772
    //   1320: iconst_0
    //   1321: istore_3
    //   1322: aload_1
    //   1323: iload_3
    //   1324: putfield 1547	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:videoWidth	I
    //   1327: aload_0
    //   1328: ldc_w 533
    //   1331: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1334: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1337: astore_1
    //   1338: aload_2
    //   1339: ifnonnull +444 -> 1783
    //   1342: iconst_0
    //   1343: istore_3
    //   1344: aload_1
    //   1345: iload_3
    //   1346: putfield 1544	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:videoHeight	I
    //   1349: aload_0
    //   1350: getfield 1063	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EjV	Lcom/tencent/mm/plugin/finder/live/plugin/cc;
    //   1353: astore_1
    //   1354: aload_1
    //   1355: ifnull +55 -> 1410
    //   1358: aload_1
    //   1359: getfield 1088	com/tencent/mm/plugin/finder/live/plugin/cc:mJG	Lcom/tencent/mm/live/core/core/c/b;
    //   1362: astore_1
    //   1363: aload_1
    //   1364: ifnull +46 -> 1410
    //   1367: getstatic 768	com/tencent/mm/plugin/finder/live/utils/a:DJT	Lcom/tencent/mm/plugin/finder/live/utils/a;
    //   1370: astore_2
    //   1371: aload_0
    //   1372: getfield 927	com/tencent/mm/plugin/finder/live/component/statecomponent/e:buContext	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   1375: astore_2
    //   1376: aload_0
    //   1377: getfield 921	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCe	Lcom/tencent/mm/plugin/finder/live/view/router/b;
    //   1380: astore 6
    //   1382: aload 6
    //   1384: ifnonnull +410 -> 1794
    //   1387: iconst_0
    //   1388: istore 5
    //   1390: aload_1
    //   1391: aload_2
    //   1392: iload 5
    //   1394: aload_0
    //   1395: getfield 1090	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:CuN	Z
    //   1398: invokestatic 1093	com/tencent/mm/plugin/finder/live/utils/a:a	(Lcom/tencent/mm/plugin/finder/live/model/context/a;ZZ)I
    //   1401: invokeinterface 1098 2 0
    //   1406: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1409: astore_1
    //   1410: aload_0
    //   1411: getfield 363	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:TAG	Ljava/lang/String;
    //   1414: new 460	java/lang/StringBuilder
    //   1417: dup
    //   1418: ldc_w 1969
    //   1421: invokespecial 463	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1424: aload_0
    //   1425: ldc_w 533
    //   1428: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1431: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1434: getfield 1547	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:videoWidth	I
    //   1437: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1440: ldc_w 1971
    //   1443: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: aload_0
    //   1447: ldc_w 533
    //   1450: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1453: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1456: getfield 1544	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:videoHeight	I
    //   1459: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1462: invokevirtual 495	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1465: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1468: aload_0
    //   1469: ldc_w 533
    //   1472: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1475: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1478: invokevirtual 1465	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyE	()Z
    //   1481: ifne +135 -> 1616
    //   1484: aload_0
    //   1485: ldc_w 548
    //   1488: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1491: checkcast 548	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   1494: aconst_null
    //   1495: putfield 620	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   1498: aload_0
    //   1499: ldc_w 548
    //   1502: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1505: checkcast 548	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   1508: getfield 1974	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efw	Ljava/util/List;
    //   1511: invokeinterface 1975 1 0
    //   1516: aload_0
    //   1517: ldc_w 548
    //   1520: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1523: checkcast 548	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   1526: iconst_0
    //   1527: putfield 1978	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfM	Z
    //   1530: aload_0
    //   1531: getfield 921	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCe	Lcom/tencent/mm/plugin/finder/live/view/router/b;
    //   1534: astore_1
    //   1535: aload_1
    //   1536: ifnull +17 -> 1553
    //   1539: aload_1
    //   1540: checkcast 929	com/tencent/mm/live/b/b
    //   1543: getstatic 1981	com/tencent/mm/live/b/b$c:neD	Lcom/tencent/mm/live/b/b$c;
    //   1546: invokestatic 1250	com/tencent/mm/live/b/b$b:a	(Lcom/tencent/mm/live/b/b;Lcom/tencent/mm/live/b/b$c;)V
    //   1549: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1552: astore_1
    //   1553: aload_0
    //   1554: getfield 1411	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejp	Lcom/tencent/mm/plugin/finder/live/plugin/h;
    //   1557: astore_1
    //   1558: aload_1
    //   1559: ifnull +11 -> 1570
    //   1562: aload_1
    //   1563: invokevirtual 1984	com/tencent/mm/plugin/finder/live/plugin/h:eoT	()V
    //   1566: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1569: astore_1
    //   1570: aload_0
    //   1571: getfield 921	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCe	Lcom/tencent/mm/plugin/finder/live/view/router/b;
    //   1574: astore_1
    //   1575: aload_1
    //   1576: ifnull +23 -> 1599
    //   1579: aload_1
    //   1580: checkcast 1986	com/tencent/mm/plugin/finder/live/view/a
    //   1583: new 1988	org/json/JSONObject
    //   1586: dup
    //   1587: invokespecial 1989	org/json/JSONObject:<init>	()V
    //   1590: iconst_0
    //   1591: aconst_null
    //   1592: bipush 6
    //   1594: aconst_null
    //   1595: invokestatic 1993	com/tencent/mm/plugin/finder/live/view/a:notifyRoomPKMicUserChange$default	(Lcom/tencent/mm/plugin/finder/live/view/a;Lorg/json/JSONObject;ZLkotlin/r;ILjava/lang/Object;)Z
    //   1598: pop
    //   1599: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   1602: astore_1
    //   1603: iconst_3
    //   1604: new 1988	org/json/JSONObject
    //   1607: dup
    //   1608: invokespecial 1989	org/json/JSONObject:<init>	()V
    //   1611: iconst_0
    //   1612: iconst_4
    //   1613: invokestatic 1996	com/tencent/mm/plugin/finder/live/model/aj:a	(ILorg/json/JSONObject;ZI)V
    //   1616: aload_0
    //   1617: ldc_w 548
    //   1620: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1623: checkcast 548	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   1626: getfield 1978	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfM	Z
    //   1629: ifne +82 -> 1711
    //   1632: aload_0
    //   1633: getfield 921	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCe	Lcom/tencent/mm/plugin/finder/live/view/router/b;
    //   1636: astore_1
    //   1637: aload_1
    //   1638: ifnull +17 -> 1655
    //   1641: aload_1
    //   1642: checkcast 1986	com/tencent/mm/plugin/finder/live/view/a
    //   1645: iconst_0
    //   1646: iconst_1
    //   1647: aconst_null
    //   1648: invokestatic 2000	com/tencent/mm/plugin/finder/live/view/a:notifyAudienceMicUserChange$default	(Lcom/tencent/mm/plugin/finder/live/view/a;ZILjava/lang/Object;)V
    //   1651: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1654: astore_1
    //   1655: aload_0
    //   1656: getfield 921	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCe	Lcom/tencent/mm/plugin/finder/live/view/router/b;
    //   1659: astore_1
    //   1660: aload_1
    //   1661: ifnull +17 -> 1678
    //   1664: aload_1
    //   1665: checkcast 1986	com/tencent/mm/plugin/finder/live/view/a
    //   1668: iconst_0
    //   1669: iconst_1
    //   1670: aconst_null
    //   1671: invokestatic 2003	com/tencent/mm/plugin/finder/live/view/a:notifyPKMicUserChange$default	(Lcom/tencent/mm/plugin/finder/live/view/a;ZILjava/lang/Object;)V
    //   1674: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1677: astore_1
    //   1678: aload_0
    //   1679: ldc_w 548
    //   1682: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1685: checkcast 548	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   1688: astore_1
    //   1689: aload_1
    //   1690: ifnonnull +114 -> 1804
    //   1693: aconst_null
    //   1694: astore_1
    //   1695: aload_1
    //   1696: ifnull +116 -> 1812
    //   1699: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   1702: astore_1
    //   1703: iconst_1
    //   1704: aconst_null
    //   1705: iconst_0
    //   1706: bipush 6
    //   1708: invokestatic 1996	com/tencent/mm/plugin/finder/live/model/aj:a	(ILorg/json/JSONObject;ZI)V
    //   1711: aload_0
    //   1712: ldc_w 533
    //   1715: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1718: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1721: invokevirtual 1052	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyu	()I
    //   1724: istore_3
    //   1725: getstatic 1058	com/tencent/mm/live/core/core/e$b:mKf	Lcom/tencent/mm/live/core/core/e$b;
    //   1728: astore_1
    //   1729: iload_3
    //   1730: invokestatic 2006	com/tencent/mm/live/core/core/e$b:bct	()I
    //   1733: if_icmpeq +123 -> 1856
    //   1736: aload_0
    //   1737: ldc_w 533
    //   1740: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1743: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1746: invokevirtual 1052	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyu	()I
    //   1749: istore_3
    //   1750: getstatic 1058	com/tencent/mm/live/core/core/e$b:mKf	Lcom/tencent/mm/live/core/core/e$b;
    //   1753: astore_1
    //   1754: iload_3
    //   1755: invokestatic 1061	com/tencent/mm/live/core/core/e$b:bcu	()I
    //   1758: if_icmpne +69 -> 1827
    //   1761: aload_0
    //   1762: invokespecial 1071	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:ezB	()V
    //   1765: ldc_w 1731
    //   1768: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1771: return
    //   1772: aload_2
    //   1773: ldc_w 2008
    //   1776: invokevirtual 2011	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1779: istore_3
    //   1780: goto -458 -> 1322
    //   1783: aload_2
    //   1784: ldc_w 2013
    //   1787: invokevirtual 2011	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1790: istore_3
    //   1791: goto -447 -> 1344
    //   1794: aload 6
    //   1796: invokevirtual 1154	com/tencent/mm/plugin/finder/live/view/router/b:isLandscape	()Z
    //   1799: istore 5
    //   1801: goto -411 -> 1390
    //   1804: aload_1
    //   1805: getfield 620	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   1808: astore_1
    //   1809: goto -114 -> 1695
    //   1812: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   1815: astore_1
    //   1816: iconst_2
    //   1817: aconst_null
    //   1818: iconst_0
    //   1819: bipush 6
    //   1821: invokestatic 1996	com/tencent/mm/plugin/finder/live/model/aj:a	(ILorg/json/JSONObject;ZI)V
    //   1824: goto -113 -> 1711
    //   1827: aload_0
    //   1828: getfield 363	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:TAG	Ljava/lang/String;
    //   1831: ldc_w 2015
    //   1834: aload_0
    //   1835: ldc_w 533
    //   1838: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1841: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1844: invokevirtual 1052	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyu	()I
    //   1847: invokestatic 520	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1850: invokestatic 524	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1853: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1856: ldc_w 1731
    //   1859: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1862: return
    //   1863: aload_2
    //   1864: ifnonnull +67 -> 1931
    //   1867: aconst_null
    //   1868: astore_1
    //   1869: aload_2
    //   1870: ifnonnull +122 -> 1992
    //   1873: aconst_null
    //   1874: astore 6
    //   1876: aload_2
    //   1877: ifnonnull +127 -> 2004
    //   1880: aconst_null
    //   1881: astore_2
    //   1882: aload_0
    //   1883: getfield 2017	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiN	Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   1886: astore 7
    //   1888: aload 7
    //   1890: ifnull +16 -> 1906
    //   1893: aload 7
    //   1895: aload 6
    //   1897: aload_2
    //   1898: aload_1
    //   1899: invokevirtual 2022	com/tencent/mm/plugin/finder/live/plugin/l:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/bgq;)V
    //   1902: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1905: astore_1
    //   1906: aload_0
    //   1907: getfield 2017	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiN	Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   1910: astore_1
    //   1911: aload_1
    //   1912: ifnull +12 -> 1924
    //   1915: aload_1
    //   1916: iconst_0
    //   1917: invokevirtual 2023	com/tencent/mm/plugin/finder/live/plugin/l:tO	(I)V
    //   1920: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   1923: astore_1
    //   1924: ldc_w 1731
    //   1927: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1930: return
    //   1931: aload_2
    //   1932: ldc_w 1310
    //   1935: invokevirtual 1948	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   1938: astore 6
    //   1940: aload 6
    //   1942: ifnonnull +8 -> 1950
    //   1945: aconst_null
    //   1946: astore_1
    //   1947: goto -78 -> 1869
    //   1950: new 1312	com/tencent/mm/protocal/protobuf/bgq
    //   1953: dup
    //   1954: invokespecial 2024	com/tencent/mm/protocal/protobuf/bgq:<init>	()V
    //   1957: astore_1
    //   1958: aload_1
    //   1959: aload 6
    //   1961: invokevirtual 2025	com/tencent/mm/protocal/protobuf/bgq:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   1964: pop
    //   1965: goto -96 -> 1869
    //   1968: astore_1
    //   1969: aload_0
    //   1970: getfield 363	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:TAG	Ljava/lang/String;
    //   1973: ldc_w 2027
    //   1976: iconst_1
    //   1977: anewarray 2029	java/lang/Object
    //   1980: dup
    //   1981: iconst_0
    //   1982: aload_1
    //   1983: aastore
    //   1984: invokestatic 2032	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1987: aconst_null
    //   1988: astore_1
    //   1989: goto -24 -> 1965
    //   1992: aload_2
    //   1993: ldc_w 2034
    //   1996: invokevirtual 2037	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1999: astore 6
    //   2001: goto -125 -> 1876
    //   2004: aload_2
    //   2005: ldc_w 2039
    //   2008: invokevirtual 2037	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2011: astore_2
    //   2012: goto -130 -> 1882
    //   2015: aload_2
    //   2016: ifnonnull +745 -> 2761
    //   2019: aconst_null
    //   2020: astore 6
    //   2022: aload_2
    //   2023: ifnonnull +805 -> 2828
    //   2026: iconst_0
    //   2027: istore_3
    //   2028: aload_0
    //   2029: getfield 921	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCe	Lcom/tencent/mm/plugin/finder/live/view/router/b;
    //   2032: astore_2
    //   2033: aload_2
    //   2034: ifnull +17 -> 2051
    //   2037: aload_2
    //   2038: checkcast 1986	com/tencent/mm/plugin/finder/live/view/a
    //   2041: iconst_0
    //   2042: iconst_1
    //   2043: aconst_null
    //   2044: invokestatic 2042	com/tencent/mm/plugin/finder/live/view/a:hideLoadingLayer$default	(Lcom/tencent/mm/plugin/finder/live/view/a;ZILjava/lang/Object;)V
    //   2047: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2050: astore_2
    //   2051: aload_0
    //   2052: getfield 2044	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiP	Lcom/tencent/mm/live/b/y;
    //   2055: astore_2
    //   2056: aload_2
    //   2057: ifnull +13 -> 2070
    //   2060: aload_2
    //   2061: bipush 8
    //   2063: invokevirtual 2047	com/tencent/mm/live/b/y:tO	(I)V
    //   2066: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2069: astore_2
    //   2070: aload_0
    //   2071: getfield 1662	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiQ	Lcom/tencent/mm/plugin/finder/live/plugin/cd;
    //   2074: astore_2
    //   2075: aload_2
    //   2076: ifnull +13 -> 2089
    //   2079: aload_2
    //   2080: bipush 8
    //   2082: invokevirtual 2050	com/tencent/mm/plugin/finder/live/plugin/cd:tO	(I)V
    //   2085: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2088: astore_2
    //   2089: aload_0
    //   2090: getfield 1338	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiR	Lcom/tencent/mm/plugin/finder/live/plugin/aj;
    //   2093: astore_2
    //   2094: aload_2
    //   2095: ifnull +13 -> 2108
    //   2098: aload_2
    //   2099: bipush 8
    //   2101: invokevirtual 2051	com/tencent/mm/plugin/finder/live/plugin/aj:tO	(I)V
    //   2104: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2107: astore_2
    //   2108: aload_0
    //   2109: getfield 1746	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiS	Lcom/tencent/mm/plugin/finder/live/plugin/bt;
    //   2112: astore_2
    //   2113: aload_2
    //   2114: ifnull +13 -> 2127
    //   2117: aload_2
    //   2118: bipush 8
    //   2120: invokevirtual 1751	com/tencent/mm/plugin/finder/live/plugin/bt:tO	(I)V
    //   2123: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2126: astore_2
    //   2127: aload_0
    //   2128: getfield 422	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:DcS	Lcom/tencent/mm/plugin/finder/live/plugin/ah;
    //   2131: astore_2
    //   2132: aload_2
    //   2133: ifnull +13 -> 2146
    //   2136: aload_2
    //   2137: bipush 8
    //   2139: invokevirtual 2054	com/tencent/mm/plugin/finder/live/plugin/ah:tO	(I)V
    //   2142: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2145: astore_2
    //   2146: aload_0
    //   2147: getfield 2056	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiT	Lcom/tencent/mm/plugin/finder/live/plugin/j;
    //   2150: astore_2
    //   2151: aload_2
    //   2152: ifnull +13 -> 2165
    //   2155: aload_2
    //   2156: bipush 8
    //   2158: invokevirtual 2059	com/tencent/mm/plugin/finder/live/plugin/j:tO	(I)V
    //   2161: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2164: astore_2
    //   2165: aload_0
    //   2166: getfield 2061	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiU	Lcom/tencent/mm/plugin/finder/live/plugin/bd;
    //   2169: astore_2
    //   2170: aload_2
    //   2171: ifnull +13 -> 2184
    //   2174: aload_2
    //   2175: bipush 8
    //   2177: invokevirtual 2064	com/tencent/mm/plugin/finder/live/plugin/bd:tO	(I)V
    //   2180: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2183: astore_2
    //   2184: aload_0
    //   2185: getfield 2066	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiV	Lcom/tencent/mm/plugin/finder/live/plugin/bk;
    //   2188: astore_2
    //   2189: aload_2
    //   2190: ifnull +13 -> 2203
    //   2193: aload_2
    //   2194: bipush 8
    //   2196: invokevirtual 2069	com/tencent/mm/plugin/finder/live/plugin/bk:tO	(I)V
    //   2199: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2202: astore_2
    //   2203: aload_0
    //   2204: getfield 843	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiW	Lcom/tencent/mm/plugin/finder/live/plugin/az;
    //   2207: astore_2
    //   2208: aload_2
    //   2209: ifnull +13 -> 2222
    //   2212: aload_2
    //   2213: bipush 8
    //   2215: invokevirtual 2070	com/tencent/mm/plugin/finder/live/plugin/az:tO	(I)V
    //   2218: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2221: astore_2
    //   2222: aload_0
    //   2223: getfield 2072	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiX	Lcom/tencent/mm/plugin/finder/live/plugin/bg;
    //   2226: astore_2
    //   2227: aload_2
    //   2228: ifnull +13 -> 2241
    //   2231: aload_2
    //   2232: bipush 8
    //   2234: invokevirtual 2075	com/tencent/mm/plugin/finder/live/plugin/bg:tO	(I)V
    //   2237: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2240: astore_2
    //   2241: aload_0
    //   2242: getfield 1394	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejb	Lcom/tencent/mm/plugin/finder/live/plugin/cf;
    //   2245: astore_2
    //   2246: aload_2
    //   2247: ifnull +13 -> 2260
    //   2250: aload_2
    //   2251: bipush 8
    //   2253: invokevirtual 2076	com/tencent/mm/plugin/finder/live/plugin/cf:tO	(I)V
    //   2256: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2259: astore_2
    //   2260: aload_0
    //   2261: getfield 854	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejc	Lcom/tencent/mm/plugin/finder/live/plugin/o;
    //   2264: astore_2
    //   2265: aload_2
    //   2266: ifnull +13 -> 2279
    //   2269: aload_2
    //   2270: bipush 8
    //   2272: invokevirtual 2077	com/tencent/mm/plugin/finder/live/plugin/o:tO	(I)V
    //   2275: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2278: astore_2
    //   2279: aload_0
    //   2280: getfield 2079	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiZ	Lcom/tencent/mm/plugin/finder/live/plugin/br;
    //   2283: astore_2
    //   2284: aload_2
    //   2285: ifnull +13 -> 2298
    //   2288: aload_2
    //   2289: bipush 8
    //   2291: invokevirtual 2082	com/tencent/mm/plugin/finder/live/plugin/br:tO	(I)V
    //   2294: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2297: astore_2
    //   2298: aload_0
    //   2299: getfield 808	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Eja	Lcom/tencent/mm/plugin/finder/live/plugin/bz;
    //   2302: astore_2
    //   2303: aload_2
    //   2304: ifnull +13 -> 2317
    //   2307: aload_2
    //   2308: bipush 8
    //   2310: invokevirtual 2083	com/tencent/mm/plugin/finder/live/plugin/bz:tO	(I)V
    //   2313: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2316: astore_2
    //   2317: aload_0
    //   2318: getfield 2085	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejl	Lcom/tencent/mm/plugin/finder/live/plugin/q;
    //   2321: astore_2
    //   2322: aload_2
    //   2323: ifnull +13 -> 2336
    //   2326: aload_2
    //   2327: bipush 8
    //   2329: invokevirtual 2088	com/tencent/mm/plugin/finder/live/plugin/q:tO	(I)V
    //   2332: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2335: astore_2
    //   2336: aload_0
    //   2337: getfield 1680	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejn	Lcom/tencent/mm/plugin/finder/live/plugin/p;
    //   2340: astore_2
    //   2341: aload_2
    //   2342: ifnull +13 -> 2355
    //   2345: aload_2
    //   2346: bipush 8
    //   2348: invokevirtual 2091	com/tencent/mm/plugin/finder/live/plugin/p:tO	(I)V
    //   2351: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2354: astore_2
    //   2355: aload_0
    //   2356: getfield 1836	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejo	Lcom/tencent/mm/plugin/finder/live/plugin/bf;
    //   2359: astore_2
    //   2360: aload_2
    //   2361: ifnull +13 -> 2374
    //   2364: aload_2
    //   2365: bipush 8
    //   2367: invokevirtual 2092	com/tencent/mm/plugin/finder/live/plugin/bf:tO	(I)V
    //   2370: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2373: astore_2
    //   2374: aload_0
    //   2375: getfield 2094	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejd	Lcom/tencent/mm/plugin/finder/live/plugin/i;
    //   2378: astore_2
    //   2379: aload_2
    //   2380: ifnull +13 -> 2393
    //   2383: aload_2
    //   2384: bipush 8
    //   2386: invokevirtual 2097	com/tencent/mm/plugin/finder/live/plugin/i:tO	(I)V
    //   2389: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2392: astore_2
    //   2393: aload_0
    //   2394: getfield 2099	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejj	Lcom/tencent/mm/plugin/finder/live/plugin/av;
    //   2397: astore_2
    //   2398: aload_2
    //   2399: ifnull +13 -> 2412
    //   2402: aload_2
    //   2403: bipush 8
    //   2405: invokevirtual 2102	com/tencent/mm/plugin/finder/live/plugin/av:tO	(I)V
    //   2408: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2411: astore_2
    //   2412: aload_0
    //   2413: getfield 1859	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejk	Lcom/tencent/mm/plugin/finder/live/plugin/aw;
    //   2416: astore_2
    //   2417: aload_2
    //   2418: ifnull +13 -> 2431
    //   2421: aload_2
    //   2422: bipush 8
    //   2424: invokevirtual 2103	com/tencent/mm/plugin/finder/live/plugin/aw:tO	(I)V
    //   2427: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2430: astore_2
    //   2431: aload_0
    //   2432: getfield 1411	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejp	Lcom/tencent/mm/plugin/finder/live/plugin/h;
    //   2435: astore_2
    //   2436: aload_2
    //   2437: ifnull +13 -> 2450
    //   2440: aload_2
    //   2441: bipush 8
    //   2443: invokevirtual 2104	com/tencent/mm/plugin/finder/live/plugin/h:tO	(I)V
    //   2446: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2449: astore_2
    //   2450: aload_0
    //   2451: getfield 2106	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EjB	Lcom/tencent/mm/plugin/finder/live/plugin/bp;
    //   2454: astore_2
    //   2455: aload_2
    //   2456: ifnull +13 -> 2469
    //   2459: aload_2
    //   2460: bipush 8
    //   2462: invokevirtual 2109	com/tencent/mm/plugin/finder/live/plugin/bp:tO	(I)V
    //   2465: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2468: astore_2
    //   2469: aload_0
    //   2470: getfield 2111	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EjC	Lcom/tencent/mm/plugin/finder/live/plugin/k;
    //   2473: astore_2
    //   2474: aload_2
    //   2475: ifnull +13 -> 2488
    //   2478: aload_2
    //   2479: bipush 8
    //   2481: invokevirtual 2114	com/tencent/mm/plugin/finder/live/plugin/k:tO	(I)V
    //   2484: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2487: astore_2
    //   2488: aload_0
    //   2489: getfield 2116	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EjD	Lcom/tencent/mm/plugin/finder/live/plugin/n;
    //   2492: astore_2
    //   2493: aload_2
    //   2494: ifnull +13 -> 2507
    //   2497: aload_2
    //   2498: bipush 8
    //   2500: invokevirtual 2119	com/tencent/mm/plugin/finder/live/plugin/n:tO	(I)V
    //   2503: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2506: astore_2
    //   2507: aload_0
    //   2508: getfield 2121	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EjE	Lcom/tencent/mm/plugin/finder/live/plugin/s;
    //   2511: astore_2
    //   2512: aload_2
    //   2513: ifnull +13 -> 2526
    //   2516: aload_2
    //   2517: bipush 8
    //   2519: invokevirtual 2124	com/tencent/mm/plugin/finder/live/plugin/s:tO	(I)V
    //   2522: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2525: astore_2
    //   2526: aload_0
    //   2527: getfield 2126	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejv	Lcom/tencent/mm/plugin/finder/live/plugin/z;
    //   2530: astore_2
    //   2531: aload_2
    //   2532: ifnull +13 -> 2545
    //   2535: aload_2
    //   2536: bipush 8
    //   2538: invokevirtual 2129	com/tencent/mm/plugin/finder/live/plugin/z:tO	(I)V
    //   2541: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2544: astore_2
    //   2545: aload_0
    //   2546: getfield 1693	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EjG	Lcom/tencent/mm/plugin/finder/live/plugin/ak;
    //   2549: astore_2
    //   2550: aload_2
    //   2551: ifnull +13 -> 2564
    //   2554: aload_2
    //   2555: bipush 8
    //   2557: invokevirtual 2132	com/tencent/mm/plugin/finder/live/plugin/ak:tO	(I)V
    //   2560: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2563: astore_2
    //   2564: aload_1
    //   2565: getstatic 1329	com/tencent/mm/live/b/b$c:ndT	Lcom/tencent/mm/live/b/b$c;
    //   2568: if_acmpne +271 -> 2839
    //   2571: aload_0
    //   2572: getfield 2017	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiN	Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   2575: astore_1
    //   2576: aload_1
    //   2577: ifnull +27 -> 2604
    //   2580: aload_1
    //   2581: aload_0
    //   2582: ldc_w 533
    //   2585: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2588: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   2591: getfield 986	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:mIC	Ljava/lang/String;
    //   2594: aload 6
    //   2596: iload_3
    //   2597: invokevirtual 2135	com/tencent/mm/plugin/finder/live/plugin/l:a	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/bgq;I)V
    //   2600: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2603: astore_1
    //   2604: aload_0
    //   2605: getfield 2017	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiN	Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   2608: ifnull +67 -> 2675
    //   2611: aload_0
    //   2612: getfield 363	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:TAG	Ljava/lang/String;
    //   2615: ldc_w 2137
    //   2618: invokestatic 500	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2621: aload_0
    //   2622: ldc_w 2139
    //   2625: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2628: checkcast 2139	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i
    //   2631: iconst_1
    //   2632: putfield 2142	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i:Efn	Z
    //   2635: aload_0
    //   2636: ldc_w 2139
    //   2639: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2642: checkcast 2139	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i
    //   2645: aload 6
    //   2647: putfield 2145	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i:Efo	Lcom/tencent/mm/protocal/protobuf/bgq;
    //   2650: aload_0
    //   2651: ldc_w 2139
    //   2654: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2657: checkcast 2139	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i
    //   2660: iload_3
    //   2661: invokestatic 520	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2664: putfield 2149	com/tencent/mm/plugin/finder/live/viewmodel/data/business/i:Efp	Ljava/lang/Integer;
    //   2667: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2670: astore_1
    //   2671: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2674: astore_1
    //   2675: aload_0
    //   2676: getfield 2017	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiN	Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   2679: astore_1
    //   2680: aload_1
    //   2681: ifnull +12 -> 2693
    //   2684: aload_1
    //   2685: iconst_0
    //   2686: invokevirtual 2023	com/tencent/mm/plugin/finder/live/plugin/l:tO	(I)V
    //   2689: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2692: astore_1
    //   2693: aload_0
    //   2694: getfield 1075	com/tencent/mm/plugin/finder/live/component/statecomponent/c:nkg	Lcom/tencent/mm/live/core/core/trtc/a;
    //   2697: astore_1
    //   2698: aload_1
    //   2699: ifnull +12 -> 2711
    //   2702: aload_1
    //   2703: iconst_4
    //   2704: invokevirtual 2152	com/tencent/mm/live/core/core/trtc/a:sY	(I)V
    //   2707: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2710: astore_1
    //   2711: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   2714: astore_1
    //   2715: invokestatic 1581	com/tencent/mm/plugin/finder/live/model/aj:getFinderLiveAssistant	()Lcom/tencent/mm/plugin/finder/live/model/ap;
    //   2718: astore_1
    //   2719: aload_1
    //   2720: ifnull +20 -> 2740
    //   2723: aload_1
    //   2724: aload_0
    //   2725: getfield 1262	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCa	Landroidx/appcompat/app/AppCompatActivity;
    //   2728: checkcast 1264	android/content/Context
    //   2731: invokeinterface 2158 2 0
    //   2736: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2739: astore_1
    //   2740: getstatic 2164	com/tencent/mm/plugin/finder/live/model/al:CHU	Lcom/tencent/mm/plugin/finder/live/model/al;
    //   2743: astore_1
    //   2744: invokestatic 2167	com/tencent/mm/plugin/finder/live/model/al:eme	()V
    //   2747: getstatic 911	com/tencent/mm/plugin/finder/live/model/aj:CGT	Lcom/tencent/mm/plugin/finder/live/model/aj;
    //   2750: astore_1
    //   2751: invokestatic 2170	com/tencent/mm/plugin/finder/live/model/aj:biU	()V
    //   2754: ldc_w 1731
    //   2757: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2760: return
    //   2761: aload_2
    //   2762: ldc_w 1310
    //   2765: invokevirtual 1948	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   2768: astore 7
    //   2770: aload 7
    //   2772: ifnonnull +9 -> 2781
    //   2775: aconst_null
    //   2776: astore 6
    //   2778: goto -756 -> 2022
    //   2781: new 1312	com/tencent/mm/protocal/protobuf/bgq
    //   2784: dup
    //   2785: invokespecial 2024	com/tencent/mm/protocal/protobuf/bgq:<init>	()V
    //   2788: astore 6
    //   2790: aload 6
    //   2792: aload 7
    //   2794: invokevirtual 2025	com/tencent/mm/protocal/protobuf/bgq:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   2797: pop
    //   2798: goto -776 -> 2022
    //   2801: astore 6
    //   2803: aload_0
    //   2804: getfield 363	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:TAG	Ljava/lang/String;
    //   2807: ldc_w 2027
    //   2810: iconst_1
    //   2811: anewarray 2029	java/lang/Object
    //   2814: dup
    //   2815: iconst_0
    //   2816: aload 6
    //   2818: aastore
    //   2819: invokestatic 2032	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2822: aconst_null
    //   2823: astore 6
    //   2825: goto -27 -> 2798
    //   2828: aload_2
    //   2829: ldc_w 1322
    //   2832: invokevirtual 2011	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2835: istore_3
    //   2836: goto -808 -> 2028
    //   2839: aload_0
    //   2840: getfield 2017	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:EiN	Lcom/tencent/mm/plugin/finder/live/plugin/l;
    //   2843: astore_1
    //   2844: aload_1
    //   2845: ifnull -170 -> 2675
    //   2848: aload_1
    //   2849: aload_0
    //   2850: ldc_w 533
    //   2853: invokevirtual 537	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2856: checkcast 533	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   2859: getfield 986	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:mIC	Ljava/lang/String;
    //   2862: aload 6
    //   2864: iload_3
    //   2865: invokevirtual 2172	com/tencent/mm/plugin/finder/live/plugin/l:b	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/bgq;I)V
    //   2868: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2871: astore_1
    //   2872: goto -197 -> 2675
    //   2875: aload_2
    //   2876: ifnonnull +32 -> 2908
    //   2879: iconst_0
    //   2880: istore 5
    //   2882: aload_0
    //   2883: getfield 921	com/tencent/mm/plugin/finder/live/component/statecomponent/c:CCe	Lcom/tencent/mm/plugin/finder/live/view/router/b;
    //   2886: astore_1
    //   2887: aload_1
    //   2888: ifnull +13 -> 2901
    //   2891: aload_1
    //   2892: iload 5
    //   2894: invokevirtual 1475	com/tencent/mm/plugin/finder/live/view/router/b:onScreenClear	(Z)V
    //   2897: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2900: astore_1
    //   2901: ldc_w 1731
    //   2904: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2907: return
    //   2908: aload_2
    //   2909: ldc_w 2174
    //   2912: invokevirtual 389	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   2915: istore 5
    //   2917: goto -35 -> 2882
    //   2920: aload_0
    //   2921: getfield 422	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:DcS	Lcom/tencent/mm/plugin/finder/live/plugin/ah;
    //   2924: astore_1
    //   2925: aload_1
    //   2926: ifnull +21 -> 2947
    //   2929: aload_1
    //   2930: getfield 397	com/tencent/mm/live/b/a:mJe	Landroid/view/ViewGroup;
    //   2933: new 2176	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b$$ExternalSyntheticLambda1
    //   2936: dup
    //   2937: aload_2
    //   2938: aload_0
    //   2939: aload_1
    //   2940: invokespecial 2178	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b$$ExternalSyntheticLambda1:<init>	(Landroid/os/Bundle;Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b;Lcom/tencent/mm/plugin/finder/live/plugin/ah;)V
    //   2943: invokevirtual 2182	android/view/ViewGroup:post	(Ljava/lang/Runnable;)Z
    //   2946: pop
    //   2947: ldc_w 1731
    //   2950: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2953: return
    //   2954: aload_0
    //   2955: getfield 1836	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejo	Lcom/tencent/mm/plugin/finder/live/plugin/bf;
    //   2958: astore_1
    //   2959: aload_1
    //   2960: ifnull +11 -> 2971
    //   2963: aload_1
    //   2964: invokevirtual 2185	com/tencent/mm/plugin/finder/live/plugin/bf:era	()V
    //   2967: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2970: astore_1
    //   2971: aload_0
    //   2972: getfield 1667	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejr	Lcom/tencent/mm/plugin/finder/live/plugin/be;
    //   2975: astore_1
    //   2976: aload_1
    //   2977: ifnull +11 -> 2988
    //   2980: aload_1
    //   2981: invokevirtual 2188	com/tencent/mm/plugin/finder/live/plugin/be:era	()V
    //   2984: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   2987: astore_1
    //   2988: ldc_w 1731
    //   2991: invokestatic 336	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2994: return
    //   2995: aload_0
    //   2996: getfield 1836	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejo	Lcom/tencent/mm/plugin/finder/live/plugin/bf;
    //   2999: astore_1
    //   3000: aload_1
    //   3001: ifnull +11 -> 3012
    //   3004: aload_1
    //   3005: invokevirtual 2191	com/tencent/mm/plugin/finder/live/plugin/bf:erb	()V
    //   3008: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   3011: astore_1
    //   3012: aload_0
    //   3013: getfield 1667	com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/b:Ejr	Lcom/tencent/mm/plugin/finder/live/plugin/be;
    //   3016: astore_1
    //   3017: aload_1
    //   3018: ifnull -2922 -> 96
    //   3021: aload_1
    //   3022: invokevirtual 2192	com/tencent/mm/plugin/finder/live/plugin/be:erb	()V
    //   3025: getstatic 730	kotlin/ah:aiuX	Lkotlin/ah;
    //   3028: astore_1
    //   3029: goto -2933 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3032	0	this	b
    //   0	3032	1	paramc	com.tencent.mm.live.b.b.c
    //   0	3032	2	paramBundle	Bundle
    //   237	2628	3	i	int
    //   988	153	4	j	int
    //   276	2640	5	bool	boolean
    //   170	2621	6	localObject1	Object
    //   2801	16	6	localObject2	Object
    //   2823	40	6	localbgq	com.tencent.mm.protocal.protobuf.bgq
    //   185	2608	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   1958	1965	1968	finally
    //   2790	2798	2801	finally
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.b paramb)
  {
    AppMethodBeat.i(357495);
    kotlin.g.b.s.u(paramb, "baseRouter");
    super.a(paramb);
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    Object localObject2 = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(localObject2, "getMyFinderUsername()");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).setAnchorUsername((String)localObject2);
    com.tencent.mm.plugin.finder.live.view.a.fillBlurBg$default((com.tencent.mm.plugin.finder.live.view.a)paramb, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, false, 2, null);
    paramb = this.CCe;
    if (paramb != null)
    {
      localObject1 = paramb.findViewById(p.e.live_tx_live_player_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_tx_live_player_ui_root)");
      this.EjV = new cc((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.live_shadow_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_shadow_ui_root)");
      this.EiP = new y((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BNs);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_lottery_bubble_root)");
      this.Ejf = new ba((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BEZ);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…lowance_gift_bubble_root)");
      this.Ejh = new com.tencent.mm.plugin.finder.live.plugin.d((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BFa);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…allowance_gift_card_root)");
      this.Eji = new com.tencent.mm.plugin.finder.live.plugin.e((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BLn);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…welfare_task_bubble_root)");
      this.EjY = new at((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.live_title_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_title_ui_root)");
      this.EiQ = new cd((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.live_common_info_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_common_info_ui_root)");
      this.EiR = new com.tencent.mm.plugin.finder.live.plugin.aj((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BRv);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_promote_banner_root)");
      this.EiY = new bq((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BRT);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.finder_live_ready_ui_root)");
      this.EiS = new bt((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BJU);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.finder_live_comment_ui_root)");
      this.DcS = new com.tencent.mm.plugin.finder.live.plugin.ah((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.live_anchor_close_ui_root);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_anchor_close_ui_root)");
      this.EiT = new com.tencent.mm.plugin.finder.live.plugin.j((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = this.EiT;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.n(this.buContext))
        {
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if (!com.tencent.mm.plugin.finder.live.utils.a.o(this.buContext)) {
            break label713;
          }
        }
      }
      label713:
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.finder.live.plugin.j)localObject1).CUB = bool;
        localObject1 = paramb.findViewById(p.e.live_members_list_ui_root);
        kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_members_list_ui_root)");
        this.EiU = new com.tencent.mm.plugin.finder.live.plugin.bd((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
        localObject1 = paramb.findViewById(p.e.BOp);
        kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_members_profile_ui_root)");
        this.EiV = new bk((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb, getContextObj());
        localObject1 = paramb.findViewById(p.e.live_like_confetti_ui_root);
        kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.live_like_confetti_ui_root)");
        this.EiW = new az((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
        localObject1 = paramb.findViewById(p.e.BOR);
        kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_more_action_ui_root)");
        this.EiX = new bg((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb, (MMActivity)this.CCa);
        localObject1 = paramb.findViewById(p.e.BWQ);
        if (localObject1 != null) {
          break;
        }
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(357495);
        throw paramb;
      }
      this.Eje = new ay((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BTR);
      if (localObject1 == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(357495);
        throw paramb;
      }
      this.EjX = new bl((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BFp);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_anchor_like_ui_root)");
      this.Ejc = new o((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BKs);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.finder_live_exception)");
      this.EiN = new l((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BTr);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_top_comment_ui_root)");
      this.Ejb = new cf((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BNu);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…r_live_lottery_card_root)");
      this.Ejg = new com.tencent.mm.plugin.finder.live.plugin.r((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BLQ);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…r_live_gift_play_ui_root)");
      this.Ejj = new av((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BMa);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_live_gift_queue_ui_root)");
      localObject1 = (ViewGroup)localObject1;
      localObject2 = (com.tencent.mm.live.b.b)paramb;
      Object localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecl;
      View localView = paramb.findViewById(p.e.BLZ);
      kotlin.g.b.s.s(localView, "it.findViewById(R.id.fin…e_gift_queue_outer_space)");
      this.Ejk = new aw((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject2, (com.tencent.mm.plugin.finder.live.util.s)localObject3, (ViewGroup)localView);
      localObject1 = paramb.findViewById(p.e.BFg);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…or_bottom_option_ui_root)");
      this.Ejp = new com.tencent.mm.plugin.finder.live.plugin.h((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BGN);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_live_audio_mode_ui_root)");
      this.Ejt = new ab((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BSR);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.finder_live_subtitle_ui_root)");
      this.EjW = new ca((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb, getContextObj());
      localObject1 = paramb.findViewById(p.e.BQv);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…ive_option_panel_ui_root)");
      this.EjB = new bp((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BGb);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…ore_option_panel_ui_root)");
      this.EjE = new com.tencent.mm.plugin.finder.live.plugin.s((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BGt);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…anchor_promotion_ui_root)");
      this.Ejv = new com.tencent.mm.plugin.finder.live.plugin.z((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BNE);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…live_lucky_money_ui_root)");
      this.Ejq = new bc((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BKk);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.finder_live_desc_edit_root)");
      this.EjC = new k((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = this.CCa.findViewById(p.e.BKe);
      kotlin.g.b.s.s(localObject1, "context as Activity).fin…finder_live_content_root)");
      this.EjF = new com.tencent.mm.plugin.finder.live.plugin.m((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BKu);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…r_live_fast_comment_root)");
      this.EjD = new n((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BKi);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…_live_decoration_ui_root)");
      this.EjG = new ak((ViewGroup)localObject1, (com.tencent.mm.live.b.b)paramb);
      localObject1 = paramb.findViewById(p.e.BOq);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…ic_audio_preview_ui_root)");
      localObject1 = (ViewGroup)localObject1;
      localObject2 = (com.tencent.mm.live.b.b)paramb;
      localObject3 = paramb.findViewById(p.e.BSi);
      kotlin.g.b.s.s(localObject3, "it.findViewById(R.id.finder_live_shade_view)");
      this.Ejr = new be((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject2, (FinderLiveShadeView)localObject3, (byte)0);
      localObject1 = paramb.findViewById(p.e.BOx);
      kotlin.g.b.s.s(localObject1, "it.findViewById(R.id.fin…ive_mic_decorate_ui_root)");
      localObject1 = (ViewGroup)localObject1;
      localObject2 = (com.tencent.mm.live.b.b)paramb;
      localObject3 = paramb.findViewById(p.e.BSi);
      kotlin.g.b.s.s(localObject3, "it.findViewById(R.id.finder_live_shade_view)");
      this.Ejo = new com.tencent.mm.plugin.finder.live.plugin.bf((ViewGroup)localObject1, (com.tencent.mm.live.b.b)localObject2, (FinderLiveShadeView)localObject3, getContextObj());
      localObject1 = this.EiR;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject1).CYH = this.EiY;
      }
      this.EjZ = paramb.findViewById(p.e.BRz);
      localObject1 = this.EjX;
      if (localObject1 != null) {
        ((bl)localObject1).tO(4);
      }
      if (this.EiZ == null)
      {
        localObject1 = (ViewGroup)paramb;
        localObject2 = paramb.findViewById(p.e.BRz);
        kotlin.g.b.s.s(localObject2, "it.findViewById(R.id.fin…promote_bubble_container)");
        this.EiZ = new br((ViewGroup)localObject1, (ViewGroup)localObject2, (com.tencent.mm.live.b.b)paramb);
        localObject1 = this.EiZ;
        if (localObject1 != null) {
          ((br)localObject1).tO(8);
        }
      }
      ezA();
      com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default((com.tencent.mm.plugin.finder.live.view.a)paramb, false, 1, null);
      paramb = this.EiP;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiQ;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiR;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiY;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiS;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.DcS;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiT;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiU;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiV;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiW;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiX;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Eje;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejc;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiZ;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Eja;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiN;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejf;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejg;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejh;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Eji;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EjY;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejp;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejt;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejj;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejk;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EjB;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EjE;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejv;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EiW;
      if (paramb != null) {
        paramb.eqJ();
      }
      paramb = this.EjW;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejq;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EjC;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EjD;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.EjG;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejr;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.Ejo;
      if (paramb != null) {
        paramb.tO(8);
      }
      paramb = this.CCe;
      if (paramb != null) {
        paramb.showProgressWithBlurBg(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      }
    }
    AppMethodBeat.o(357495);
  }
  
  public final void checkMiniWindow()
  {
    AppMethodBeat.i(357450);
    com.tencent.mm.plugin.finder.live.view.router.b localb = this.CCe;
    if (localb != null)
    {
      Log.i(this.TAG, "checkMiniWindow:" + localb + ".checkMiniWin");
      if (!localb.getCheckMiniWin())
      {
        ezw();
        this.nmZ.stopTimer();
        localb.setCheckMiniWin(true);
      }
    }
    AppMethodBeat.o(357450);
  }
  
  public final void ehm()
  {
    AppMethodBeat.i(357512);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this));
    AppMethodBeat.o(357512);
  }
  
  public final void ezC()
  {
    AppMethodBeat.i(357516);
    Log.i(this.TAG, "onAcceptLinkMicOthers curLinkState:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy + " curLiveUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv + " audienceLinkMicUserList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw + " audienceMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu());
    business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
    com.tencent.mm.plugin.finder.live.plugin.h localh = this.Ejp;
    if (localh != null) {
      localh.eoT();
    }
    AppMethodBeat.o(357516);
  }
  
  public final void ezs()
  {
    AppMethodBeat.i(357437);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject1 = d.a.auT(com.tencent.mm.model.z.bAW());
    Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    long l;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      l = 0L;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).oZ(l);
      localObject2 = com.tencent.mm.plugin.finder.live.model.q.CFU;
      com.tencent.mm.plugin.finder.live.model.q.ekN();
      localObject2 = com.tencent.mm.plugin.finder.live.component.aj.CzY;
      aj.a.nU(((f)business(f.class)).liveInfo.liveId);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("joinLive anchorStatusFlag:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp).append(" switchFlag:");
      if (localObject1 != null) {
        break label261;
      }
    }
    label261:
    for (localObject1 = null;; localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.api.m)localObject1).field_liveSwitchFlag))
    {
      Log.i((String)localObject2, localObject1 + " giftFuncEnabel:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edv + " linkMicFuncEnabel:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfD);
      localObject1 = com.tencent.mm.plugin.finder.live.util.u.DJC;
      com.tencent.mm.plugin.finder.live.util.u.ey("secondary_joinLive", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject1 = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
      if (localObject1 != null) {
        ((ap)localObject1).a(((f)business(f.class)).liveInfo.liveId, 1, (kotlin.g.a.u)new g(this));
      }
      AppMethodBeat.o(357437);
      return;
      l = ((com.tencent.mm.plugin.finder.api.m)localObject1).field_liveSwitchFlag;
      break;
    }
  }
  
  public final void ezw()
  {
    int i = 1;
    AppMethodBeat.i(357459);
    com.tencent.mm.plugin.finder.live.view.router.b localb = this.CCe;
    if (localb != null)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("stopLiveVideo,float mode:");
      localObject = this.nkg;
      if (localObject == null)
      {
        localObject = null;
        localStringBuilder = localStringBuilder.append(localObject).append(", normal mode:");
        localObject = this.nkg;
        if (localObject != null) {
          break label274;
        }
        localObject = null;
        label71:
        localStringBuilder = localStringBuilder.append(localObject).append(",manual closed:").append(localb.isManualClosed()).append(", needMiniWindow:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI).append(", start:").append(localb.isLiveStarted()).append(",finish:");
        localObject = this.CCe;
        if (localObject != null) {
          break label299;
        }
        localObject = null;
        label144:
        Log.i(str, localObject);
        if ((localb.isManualClosed()) || (!localb.isLiveStarted()) || (localb.isLiveFinished())) {
          break label315;
        }
        localObject = this.nkg;
        if (localObject == null) {
          break label310;
        }
        localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
        if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).bep() != true)) {
          break label310;
        }
      }
      for (;;)
      {
        if ((i != 0) && (localb.needMiniWindow()) && (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 2048)))
        {
          ezv();
          AppMethodBeat.o(357459);
          return;
          localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
          if (localObject == null)
          {
            localObject = null;
            break;
          }
          localObject = Boolean.valueOf(((com.tencent.mm.live.core.core.model.i)localObject).isFloatMode());
          break;
          label274:
          localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
          if (localObject == null)
          {
            localObject = null;
            break label71;
          }
          localObject = Boolean.valueOf(((com.tencent.mm.live.core.core.model.i)localObject).bep());
          break label71;
          label299:
          localObject = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.view.router.b)localObject).isLiveFinished());
          break label144;
          label310:
          i = 0;
          continue;
          label315:
          localObject = this.nkg;
          if (localObject == null) {
            break label389;
          }
          localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
          if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).bep() != true)) {
            break label389;
          }
          i = 1;
          if ((i != 0) && ((this.nkg instanceof com.tencent.mm.live.core.core.e.a)))
          {
            localObject = this.nkg;
            if (!(localObject instanceof com.tencent.mm.live.core.core.e.a)) {
              break label394;
            }
          }
        }
      }
    }
    label389:
    label394:
    for (Object localObject = (com.tencent.mm.live.core.core.e.a)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.e.a)localObject).bfH();
      }
      AppMethodBeat.o(357459);
      return;
      i = 0;
      break;
    }
  }
  
  public final void ezx()
  {
    int i = 1;
    AppMethodBeat.i(357505);
    Object localObject = com.tencent.mm.plugin.finder.live.util.m.DJb;
    com.tencent.mm.plugin.finder.live.util.m.k(this.buContext);
    localObject = this.EiQ;
    if (localObject != null) {
      cd.a((cd)localObject, null, false, 3);
    }
    localObject = this.EiP;
    if (localObject != null) {
      ((y)localObject).tO(0);
    }
    localObject = this.EiQ;
    if (localObject != null) {
      ((cd)localObject).tO(0);
    }
    localObject = this.EiR;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject).tO(0);
    }
    localObject = this.EiY;
    if ((localObject != null) && (((bq)localObject).erx() == true))
    {
      if (i != 0)
      {
        localObject = this.EiY;
        if (localObject != null) {
          ((bq)localObject).tO(0);
        }
      }
      localObject = this.DcS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.ah)localObject).tO(0);
      }
      localObject = this.EiX;
      if (localObject != null) {
        ((bg)localObject).tO(0);
      }
      if (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp, 512)) {
        break label431;
      }
      localObject = this.Ejc;
      if (localObject != null) {
        ((o)localObject).tO(8);
      }
    }
    String str1;
    String str2;
    for (;;)
    {
      localObject = this.EiS;
      if (localObject != null) {
        ((bt)localObject).tO(8);
      }
      localObject = this.EiN;
      if (localObject != null) {
        ((l)localObject).tO(8);
      }
      localObject = this.EiW;
      if (localObject != null) {
        ((az)localObject).tO(0);
      }
      localObject = this.EiR;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.b.a)localObject).mJe;
        if (localObject != null) {
          ((ViewGroup)localObject).post(new b..ExternalSyntheticLambda2(this));
        }
      }
      localObject = this.Ejp;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.h)localObject).eoQ();
      }
      localObject = this.EjX;
      if (localObject != null) {
        ((bl)localObject).tO(0);
      }
      if (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 524288)) {
        break label508;
      }
      localObject = this.CCe;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.b)localObject).forceScreenToPortrait();
      }
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet) {
        break label448;
      }
      localObject = this.CCe;
      if (localObject == null) {
        break label501;
      }
      str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
      str2 = this.CCa.getResources().getString(p.h.Cqv);
      kotlin.g.b.s.s(str2, "context.resources.getStr…inder_live_pauseing_tips)");
      String str3 = this.CCa.getResources().getString(p.h.Cqp);
      kotlin.g.b.s.s(str3, "context.resources.getStr…e_pause_mini_game_action)");
      ((com.tencent.mm.plugin.finder.live.view.router.b)localObject).showTipWithBlurBgAction(str1, str2, str3, (kotlin.g.a.a)new n(this));
      AppMethodBeat.o(357505);
      return;
      i = 0;
      break;
      label431:
      localObject = this.Ejc;
      if (localObject != null) {
        ((o)localObject).tO(0);
      }
    }
    label448:
    localObject = this.CCe;
    if (localObject != null)
    {
      str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
      str2 = this.CCa.getResources().getString(p.h.Cib);
      kotlin.g.b.s.s(str2, "context.resources.getStr…er_live_anchor_exception)");
      ((com.tencent.mm.plugin.finder.live.view.router.b)localObject).showBlurBgWithTimeCount(str1, str2);
    }
    label501:
    AppMethodBeat.o(357505);
    return;
    label508:
    if (com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcS, 32))
    {
      localObject = this.CCe;
      if (localObject != null)
      {
        str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
        str2 = this.CCa.getResources().getString(p.h.Cma);
        kotlin.g.b.s.s(str2, "context.resources.getStr…ng_exception_tip_network)");
        ((com.tencent.mm.plugin.finder.live.view.router.b)localObject).showTipWithBlurBg(str1, str2);
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
      localObject = this.Ejg;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.r)localObject).tO(8);
      }
      localObject = this.Ejp;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.h)localObject).tO(8);
      }
      localObject = this.Ejt;
      if (localObject != null) {
        ((ab)localObject).tO(8);
      }
      localObject = this.EjW;
      if (localObject != null) {
        ((ca)localObject).tO(8);
      }
      localObject = this.EjB;
      if (localObject != null) {
        ((bp)localObject).tO(8);
      }
      localObject = this.EjC;
      if (localObject != null) {
        ((k)localObject).tO(8);
      }
      localObject = this.EjD;
      if (localObject != null) {
        ((n)localObject).tO(8);
      }
      localObject = this.EjE;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.s)localObject).tO(8);
      }
    }
    AppMethodBeat.o(357505);
  }
  
  public final void ezy()
  {
    AppMethodBeat.i(357521);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new k(this));
    AppMethodBeat.o(357521);
  }
  
  public final void ge(boolean paramBoolean)
  {
    TXCloudVideoView localTXCloudVideoView = null;
    AppMethodBeat.i(357469);
    Object localObject1;
    Object localObject2;
    label184:
    Object localObject3;
    com.tencent.mm.plugin.finder.live.view.router.b localb;
    boolean bool;
    label317:
    long l;
    if (!paramBoolean)
    {
      localObject1 = this.CCe;
      if (localObject1 == null)
      {
        localObject1 = null;
        aa.makeText((Context)localObject1, (CharSequence)this.CCa.getResources().getString(p.h.Csl), 0).show();
      }
    }
    else
    {
      int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
      localObject1 = e.b.mKf;
      if (i == e.b.bcu())
      {
        Log.i(this.TAG, "chooseAudienceMode CDN fromMiniWin:" + paramBoolean + ", liveRoomModel:" + ((f)business(f.class)).mZu);
        localObject2 = ((f)business(f.class)).mZu;
        if (localObject2 != null)
        {
          localObject1 = this.nkg;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.trtc.a)localObject1).a((com.tencent.mm.live.core.core.model.h)localObject2);
          }
          localObject1 = this.nkg;
          if (!(localObject1 instanceof com.tencent.mm.live.core.core.f.d)) {
            break label483;
          }
          localObject1 = (com.tencent.mm.live.core.core.f.d)localObject1;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.f.d)localObject1).b(((com.tencent.mm.live.core.core.model.h)localObject2).mJH);
          }
          localObject1 = this.EjV;
          if (localObject1 != null) {
            ((cc)localObject1).fD(false);
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.bd.Gli;
          localObject2 = kotlin.g.b.s.X(com.tencent.mm.plugin.finder.utils.bd.fhS(), Long.valueOf(((f)business(f.class)).liveInfo.liveId));
          localObject3 = bb.GjM;
          com.tencent.mm.plugin.finder.utils.bd.a((com.tencent.mm.plugin.finder.utils.bd)localObject1, (String)localObject2, bb.fhj().name, null, false, false, false, 60);
          localObject1 = this.EjV;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            localObject2 = com.tencent.mm.plugin.finder.live.utils.a.euG();
            localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            localObject3 = this.buContext;
            localb = this.CCe;
            if (localb != null) {
              break label489;
            }
            bool = false;
            cc.a((cc)localObject1, 0, (TXLivePlayConfig)localObject2, com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject3, bool, this.CuN), false, false, (kotlin.g.a.b)new d(paramBoolean, this), 25);
          }
          localObject1 = this.EjV;
          if (localObject1 != null) {
            ((cc)localObject1).tO(0);
          }
          localObject1 = this.nkg;
          if (!(localObject1 instanceof com.tencent.mm.live.core.core.e.a)) {
            break label498;
          }
          localObject1 = (com.tencent.mm.live.core.core.e.a)localObject1;
          label389:
          if (localObject1 != null)
          {
            l = ((f)business(f.class)).liveInfo.liveId;
            localObject2 = this.EjV;
            if (localObject2 != null) {
              break label504;
            }
            localObject2 = null;
            label426:
            localObject3 = this.EjV;
            if (localObject3 != null) {
              break label514;
            }
          }
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.live.core.core.e.a)localObject1).a(l, (com.tencent.mm.live.core.core.c.b)localObject2, localTXCloudVideoView);
      AppMethodBeat.o(357469);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.view.router.b)localObject1).getRootView();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((View)localObject1).getContext();
      break;
      label483:
      localObject1 = null;
      break label184;
      label489:
      bool = localb.isLandscape();
      break label317;
      label498:
      localObject1 = null;
      break label389;
      label504:
      localObject2 = ((cc)localObject2).mJG;
      break label426;
      label514:
      localTXCloudVideoView = ((cc)localObject3).bjv();
    }
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(357445);
    com.tencent.mm.plugin.finder.live.plugin.aj localaj = this.EiR;
    if ((localaj != null) && (localaj.mJe.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.nmZ.stopTimer();
        this.nmZ.startTimer(1000L);
      }
      AppMethodBeat.o(357445);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.am.b.a<ayl>, kotlin.ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    d(boolean paramBoolean, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "enterRoomSuccess", "", "errCode", "", "errType", "errMsg", "", "extInfo", "Landroid/os/Bundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, Bundle, kotlin.ah>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(b paramb, bca parambca)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.u<Boolean, Integer, Integer, String, g, TRTCCloudDef.TRTCParams, bca, kotlin.ah>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryLivingUIC$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements RequestFloatWindowPermissionDialog.a
  {
    h(b paramb) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      int k = 0;
      int j = 1;
      AppMethodBeat.i(357160);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      Object localObject = this.Eka.CCe;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.router.b)localObject).setMiniWinPermission(false);
      }
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      localObject = this.Eka;
      paramRequestFloatWindowPermissionDialog.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true);
      com.tencent.mm.plugin.finder.live.view.router.b localb = ((c)localObject).CCe;
      int i = k;
      if (localb != null)
      {
        i = k;
        if (localb.isSwipeBack() == true) {
          i = 1;
        }
      }
      if (i != 0) {}
      for (i = j;; i = 3)
      {
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", i);
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
        localObject = ((c)localObject).CCe;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.router.b)localObject).statusChange(com.tencent.mm.live.b.b.c.ncx, paramRequestFloatWindowPermissionDialog);
        }
        b.ezD();
        AppMethodBeat.o(357160);
        return;
      }
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(357167);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      com.tencent.mm.plugin.finder.live.view.router.b localb = this.Eka.CCe;
      if (localb != null) {
        localb.setMiniWinPermission(false);
      }
      paramRequestFloatWindowPermissionDialog.finish();
      paramRequestFloatWindowPermissionDialog = new Bundle();
      localb = this.Eka.CCe;
      if (localb != null) {
        localb.statusChange(com.tencent.mm.live.b.b.c.ncA, paramRequestFloatWindowPermissionDialog);
      }
      AppMethodBeat.o(357167);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(357176);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog = this.Eka.CCe;
      if (paramRequestFloatWindowPermissionDialog != null) {
        paramRequestFloatWindowPermissionDialog.setMiniWinPermission(false);
      }
      paramRequestFloatWindowPermissionDialog = new Bundle();
      com.tencent.mm.plugin.finder.live.view.router.b localb = this.Eka.CCe;
      if (localb != null) {
        localb.statusChange(com.tencent.mm.live.b.b.c.ncC, paramRequestFloatWindowPermissionDialog);
      }
      AppMethodBeat.o(357176);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    i(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public j(ah.a parama, dlg paramdlg, b paramb, LinkedList<com.tencent.mm.plugin.finder.live.viewmodel.data.h> paramLinkedList)
    {
      super();
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
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public l(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    m(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    n(b paramb)
    {
      super();
    }
    
    private static final void s(b paramb)
    {
      AppMethodBeat.i(357136);
      kotlin.g.b.s.u(paramb, "this$0");
      b.e(paramb).finish();
      AppMethodBeat.o(357136);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.b
 * JD-Core Version:    0.7.0.1
 */