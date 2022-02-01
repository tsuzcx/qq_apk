package com.tencent.mm.live.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.u;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.live.b.g.c;
import com.tencent.mm.live.b.g.d;
import com.tencent.mm.live.c.ac;
import com.tencent.mm.live.c.ae;
import com.tencent.mm.live.c.ag;
import com.tencent.mm.live.c.ai;
import com.tencent.mm.live.c.ak;
import com.tencent.mm.live.c.am;
import com.tencent.mm.live.c.aq;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.au;
import com.tencent.mm.live.c.ay;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.c.ba;
import com.tencent.mm.live.c.k;
import com.tencent.mm.live.c.x;
import com.tencent.mm.live.c.x.b;
import com.tencent.mm.live.c.x.c;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.b.e.b;
import com.tencent.mm.live.core.core.b.e.d;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.s;
import d.v;
import d.z;
import java.util.ArrayList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/LiveAnchorPluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "", "curStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "fromForcelockOrientation", "", "lastRotationFromSensor", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveAnchorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "liveAnchorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorMicPlugin;", "liveBanCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "liveBeforePlugin", "Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "liveReadyPlugin", "Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "liveRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveShareRoomsPlugin", "Lcom/tencent/mm/live/plugin/LiveShareRoomsPlugin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "navigation", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "nextStatus", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "pluginShow", "rotationEnable", "shareLiveRetryCount", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkClickArea", "x", "", "y", "validCallback", "checkInitStatus", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "checkVerify", "createNewLive", "liveName", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleErrForeigner", "handleJoinLiveFail", "errCode", "errMsg", "initLogic", "router", "isFinished", "joinLive", "lockOrientation", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onOrientationChange", "orientation", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "orientationChanged", "pause", "refreshCamera", "resume", "start", "startLive", "liveId", "", "statusChange", "status", "stopLive", "toggleShowPlugins", "tryResumeLive", "unMount", "updatePlugin", "plugin-logic_release"})
public final class LiveAnchorPluginLayout
  extends BaseLivePluginLayout
  implements com.tencent.mm.al.f, com.tencent.mm.live.core.core.b, d.a
{
  private final String TAG;
  private d.g.a.a<z> gUY;
  private com.tencent.mm.live.core.core.a.a gWE;
  private com.tencent.mm.plugin.mmsight.model.d gXX;
  private com.tencent.mm.live.c.r haA;
  private com.tencent.mm.live.a.a haB;
  private b.c haC;
  private b.c haD;
  private int haE;
  private final ArrayList<com.tencent.mm.live.c.a> haF;
  private boolean haG;
  private boolean haH;
  private final com.tencent.mm.model.d haI;
  private int haJ;
  private boolean haK;
  private int haL;
  private ba haf;
  private com.tencent.mm.live.c.t hag;
  private k hah;
  private com.tencent.mm.live.c.c hai;
  private com.tencent.mm.live.c.ao haj;
  private as hak;
  private com.tencent.mm.live.c.m hal;
  private aq ham;
  private ay han;
  private ai hao;
  private x hap;
  private com.tencent.mm.live.c.g haq;
  private com.tencent.mm.live.c.i har;
  private com.tencent.mm.live.c.o has;
  private am hat;
  private au hau;
  private ae hav;
  private ak haw;
  private ac hax;
  private ag hay;
  private com.tencent.mm.live.c.e haz;
  
  public LiveAnchorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(212952);
    this.TAG = "MicroMsg.LiveAnchorPluginLayout";
    this.haC = b.c.gRr;
    this.haD = b.c.gRr;
    paramContext = c.c.gHi;
    this.haE = c.c.alv();
    this.haF = new ArrayList();
    this.haG = true;
    this.haI = com.tencent.mm.model.d.azW();
    this.haJ = -1;
    this.gUY = ((d.g.a.a)new m(this));
    AppMethodBeat.o(212952);
  }
  
  private final void a(float paramFloat1, float paramFloat2, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(212938);
    Object localObject = this.hak;
    int j;
    label35:
    int k;
    if (localObject != null)
    {
      localObject = ((as)localObject).aoT();
      if (localObject == null) {
        break label81;
      }
      j = 0;
      int i = 0;
      k = i;
      if (j >= 2) {
        break label84;
      }
      if (!((Rect)localObject[j]).contains((int)paramFloat1, (int)paramFloat2)) {
        break label103;
      }
      i = 1;
    }
    label81:
    label84:
    label103:
    for (;;)
    {
      j += 1;
      break label35;
      localObject = null;
      break;
      k = 0;
      if (k == 0) {
        parama.invoke();
      }
      AppMethodBeat.o(212938);
      return;
    }
  }
  
  private final void aqA()
  {
    AppMethodBeat.i(212946);
    com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(getContext()).fMj();
    Context localContext = getContext();
    d.g.b.p.g(localContext, "context");
    locala.av((CharSequence)localContext.getResources().getString(2131766582)).afp(2131755792).b((f.c)LiveAnchorPluginLayout.c.haQ).b((DialogInterface.OnDismissListener)new d(this)).show();
    AppMethodBeat.o(212946);
  }
  
  private final boolean aqB()
  {
    AppMethodBeat.i(212947);
    Object localObject = com.tencent.mm.live.b.g.gOr;
    if (com.tencent.mm.live.b.g.anG().gOA)
    {
      localObject = com.tencent.mm.live.b.c.a.gRa;
      localObject = com.tencent.mm.live.b.c.a.aow();
      if ((((bun)localObject).rotation != -1) && (((bun)localObject).rotation != getCurrentOrientation()))
      {
        AppMethodBeat.o(212947);
        return true;
      }
      AppMethodBeat.o(212947);
      return false;
    }
    localObject = com.tencent.mm.live.b.g.gOr;
    if (com.tencent.mm.live.b.g.anB() != -1)
    {
      localObject = com.tencent.mm.live.b.g.gOr;
      if (com.tencent.mm.live.b.g.anB() != getCurrentOrientation())
      {
        AppMethodBeat.o(212947);
        return true;
      }
    }
    AppMethodBeat.o(212947);
    return false;
  }
  
  private final void aqz()
  {
    AppMethodBeat.i(212945);
    ad.i("MicroMsg.LiveCoreAnchor", "stopLive");
    com.tencent.mm.live.core.core.a.a locala = this.gWE;
    if (locala != null)
    {
      locala.b((com.tencent.mm.live.core.core.b)new q());
      AppMethodBeat.o(212945);
      return;
    }
    AppMethodBeat.o(212945);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void a(com.tencent.mm.live.a.a parama, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(212936);
    d.g.b.p.h(parama, "router");
    d.g.b.p.h(paramLiveConfig, "config");
    this.haK = false;
    this.gXX = new com.tencent.mm.plugin.mmsight.model.d(getContext(), (byte)0);
    this.haB = parama;
    parama = com.tencent.mm.live.core.core.a.b.gHl;
    parama = getContext();
    d.g.b.p.g(parama, "context");
    this.gWE = ((com.tencent.mm.live.core.core.a.a)b.a.cq(parama));
    parama = this.gWE;
    if (parama != null) {
      parama.c((com.tencent.mm.live.core.core.b)this);
    }
    com.tencent.mm.live.b.i.gPh.release();
    if (paramLiveConfig.akX() != 0L)
    {
      parama = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.ans().Fsa = paramLiveConfig.akX();
    }
    if (!bt.isNullOrNil(paramLiveConfig.akV()))
    {
      parama = com.tencent.mm.live.b.g.gOr;
      parama = paramLiveConfig.akV();
      d.g.b.p.g(parama, "config.hostRoomId");
      com.tencent.mm.live.b.g.xE(parama);
    }
    parama = com.tencent.mm.live.b.g.gOr;
    parama = paramLiveConfig.akZ();
    d.g.b.p.g(parama, "config.anchorUsername");
    com.tencent.mm.live.b.g.xG(parama);
    parama = findViewById(2131307825);
    d.g.b.p.g(parama, "findViewById(R.id.live_verify_ui_root)");
    this.haf = new ba((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307634);
    d.g.b.p.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
    this.hag = new com.tencent.mm.live.c.t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307594);
    d.g.b.p.g(parama, "findViewById(R.id.live_before_ui_root)");
    this.hah = new k((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307549);
    d.g.b.p.g(parama, "findViewById(R.id.live_after_ui_root)");
    this.hai = new com.tencent.mm.live.c.c((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307719);
    d.g.b.p.g(parama, "findViewById(R.id.live_preview_ui_root)");
    this.haj = new com.tencent.mm.live.c.ao((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307771);
    d.g.b.p.g(parama, "findViewById(R.id.live_shadow_ui_root)");
    this.hak = new as((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307606);
    d.g.b.p.g(parama, "findViewById(R.id.live_comment_ui_root)");
    this.hal = new com.tencent.mm.live.c.m((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307725);
    d.g.b.p.g(parama, "findViewById(R.id.live_ready_ui_root)");
    this.ham = new aq((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307809);
    d.g.b.p.g(parama, "findViewById(R.id.live_title_ui_root)");
    this.han = new ay((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307768);
    d.g.b.p.g(parama, "findViewById(R.id.live_right_panel_ui_root)");
    this.hap = new x((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307760);
    d.g.b.p.g(parama, "findViewById(R.id.live_right_panel_btn4_parent)");
    this.haq = new com.tencent.mm.live.c.g((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307678);
    d.g.b.p.g(parama, "findViewById(R.id.live_members_list_ui_root)");
    this.hao = new ai((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307583);
    d.g.b.p.g(parama, "findViewById(R.id.live_ban_comment_ui_root)");
    this.har = new com.tencent.mm.live.c.i((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307617);
    d.g.b.p.g(parama, "findViewById(R.id.live_common_info_ui_root)");
    this.has = new com.tencent.mm.live.c.o((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307717);
    d.g.b.p.g(parama, "findViewById(R.id.live_minimize_ui_root)");
    this.hat = new am((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307786);
    d.g.b.p.g(parama, "findViewById(R.id.live_share_rooms_ui_root)");
    this.hau = new au((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307652);
    d.g.b.p.g(parama, "findViewById(R.id.live_loading_view_root)");
    this.hav = new ae((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307709);
    d.g.b.p.g(parama, "findViewById(R.id.live_mic_visitor_header_root)");
    this.haw = new ak((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307648);
    d.g.b.p.g(parama, "findViewById(R.id.live_like_confetti_ui_root)");
    this.hax = new ac((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307691);
    d.g.b.p.g(parama, "findViewById(R.id.live_members_profile_ui_root)");
    this.hay = new ag((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307555);
    d.g.b.p.g(parama, "findViewById(R.id.live_anchor_close_ui_root)");
    this.haz = new com.tencent.mm.live.c.e((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307628);
    d.g.b.p.g(parama, "findViewById(R.id.live_exception_ui_root)");
    this.haA = new com.tencent.mm.live.c.r((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = this.haj;
    Object localObject;
    if (parama != null)
    {
      localObject = (d.g.a.m)new j(this);
      parama.gIn.setPreviewMoveListener((d.g.a.m)localObject);
    }
    parama = com.tencent.mm.live.b.i.gPh;
    com.tencent.mm.live.b.i.a(paramLiveConfig);
    parama = this.hap;
    if (parama != null)
    {
      d.g.b.p.h(paramLiveConfig, "config");
      localObject = parama.gUN;
      d.g.b.p.g(localObject, "shareBtn");
      ((ImageView)localObject).setVisibility(0);
      localObject = parama.gUP;
      d.g.b.p.g(localObject, "switchCameraBtn");
      ((ImageView)localObject).setVisibility(0);
      parama.gUN.setImageDrawable(com.tencent.mm.ui.ao.e(parama.gGK.getResources().getDrawable(2131690478), -1));
      parama.gUP.setImageDrawable(com.tencent.mm.ui.ao.e(parama.gGK.getResources().getDrawable(2131690362), -1));
      parama.gUO.setOnClickListener((View.OnClickListener)new x.b(parama));
      parama.gUQ.setOnClickListener((View.OnClickListener)new x.c(parama));
      localObject = parama.gUO;
      d.g.b.p.g(localObject, "shareBtnClickArea");
      ((RelativeLayout)localObject).setVisibility(8);
      localObject = parama.gUR;
      d.g.b.p.g(localObject, "shareDescTv");
      ((TextView)localObject).setVisibility(8);
      parama = parama.gUU;
      d.g.b.p.g(parama, "shareBtnLayout");
      parama.setVisibility(8);
    }
    parama = this.hao;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.hai;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.hal;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.hax;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.hai;
    if (parama != null) {
      parama.aoD();
    }
    parama = this.hay;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.has;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.haz;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.haf;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.hag;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.hah;
    if (parama != null) {
      parama.nI(0);
    }
    parama = this.haj;
    if (parama != null) {
      parama.nI(0);
    }
    parama = this.hak;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.hai;
    if (parama != null) {
      parama.nI(4);
    }
    parama = this.hal;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.ham;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.han;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.hao;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.hap;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.har;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.has;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.hat;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.hau;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.hav;
    if (parama != null)
    {
      localObject = com.tencent.mm.live.b.g.gOr;
      parama.xT(com.tencent.mm.live.b.g.anu());
    }
    parama = this.hay;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.haA;
    if (parama != null) {
      parama.nI(8);
    }
    parama = this.haj;
    if (parama != null)
    {
      localObject = (d.g.a.m)new k(this);
      parama.gIn.setPreviewTouchListener((d.g.a.m)localObject);
    }
    if (paramBoolean)
    {
      parama = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.ans().Gbw = paramLiveConfig.akY();
      parama = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.ans().Fsa = paramLiveConfig.akX();
      parama = com.tencent.mm.live.b.g.gOr;
      parama = paramLiveConfig.akV();
      d.g.b.p.g(parama, "config.hostRoomId");
      com.tencent.mm.live.b.g.xE(parama);
      b.b.a(this, b.c.gRO);
      parama = this.gXX;
      if (parama != null) {
        parama.a(null);
      }
      parama = this.gXX;
      if (parama != null) {
        parama.disable();
      }
      this.gXX = null;
    }
    for (;;)
    {
      parama = com.tencent.mm.live.b.c.gMO;
      com.tencent.mm.live.b.c.d(name(), this.gUY);
      AppMethodBeat.o(212936);
      return;
      parama = com.tencent.mm.live.b.g.gOr;
      parama = com.tencent.mm.live.b.g.ans();
      if ((parama == null) || (parama.Fsa != 0L))
      {
        parama = com.tencent.mm.live.b.g.gOr;
        if (!bt.isNullOrNil(com.tencent.mm.live.b.g.anm()))
        {
          localObject = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("init anchor plugin with live data, liveId:");
          parama = com.tencent.mm.live.b.g.gOr;
          parama = com.tencent.mm.live.b.g.ans();
          if (parama != null)
          {
            parama = Long.valueOf(parama.Fsa);
            label1759:
            ad.i((String)localObject, parama.longValue() + ", liveName:" + paramLiveConfig.akY() + ", roomId:" + paramLiveConfig.akV());
            paramLiveConfig = this.han;
            if (paramLiveConfig != null)
            {
              parama = com.tencent.mm.live.b.g.gOr;
              parama = com.tencent.mm.live.b.g.ans().Gbw;
              if (parama == null) {
                break label1888;
              }
              parama = (CharSequence)parama;
              label1831:
              localObject = com.tencent.mm.live.b.g.gOr;
              paramLiveConfig.a(parama, com.tencent.mm.live.b.g.anu());
            }
          }
        }
      }
      for (this.haD = b.c.gSp;; this.haD = b.c.gRr)
      {
        if ((this.haf == null) || (ba.aoX() != true)) {
          break label1929;
        }
        a(this.haD, new Bundle());
        break;
        parama = null;
        break label1759;
        label1888:
        parama = (CharSequence)"";
        break label1831;
        ad.i(this.TAG, "init logic from directly start");
        parama = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.ans().Fsa = 0L;
      }
      label1929:
      parama = this.haf;
      if (parama != null) {
        parama.nI(0);
      }
      parama = this.hag;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hai;
      if (parama != null) {
        parama.nI(4);
      }
      parama = this.hal;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hap;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.han;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hak;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.har;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hav;
      if (parama != null) {
        parama.nI(8);
      }
      a(b.c.gRn, new Bundle());
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212935);
    d.g.b.p.h(paramc, "status");
    ad.i(this.TAG, "statusChange:" + paramc.name());
    this.haC = paramc;
    switch (b.gnp[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(212935);
      return;
      if (this.haH)
      {
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(212935);
          throw paramc;
        }
        ((Activity)localObject1).setRequestedOrientation(4);
      }
      Object localObject1 = this.haD;
      Object localObject2;
      Object localObject3;
      switch (b.cpQ[localObject1.ordinal()])
      {
      default: 
        break;
      case 1: 
        localObject1 = com.tencent.mm.live.b.i.gPh;
        com.tencent.mm.live.b.i.nH(0);
        localObject1 = this.haj;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.ao)localObject1).nI(0);
        }
        localObject1 = this.haf;
        if (localObject1 != null) {
          ((ba)localObject1).nI(8);
        }
        localObject1 = this.hag;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.t)localObject1).nI(8);
        }
        localObject1 = this.hah;
        if (localObject1 != null) {
          ((k)localObject1).nI(8);
        }
        localObject1 = this.hai;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.c)localObject1).nI(8);
        }
        localObject1 = this.hal;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.m)localObject1).nI(8);
        }
        localObject1 = this.hap;
        if (localObject1 != null) {
          ((x)localObject1).nI(8);
        }
        localObject1 = this.han;
        if (localObject1 != null) {
          ((ay)localObject1).nI(8);
        }
        localObject1 = this.hak;
        if (localObject1 != null) {
          ((as)localObject1).nI(8);
        }
        localObject1 = this.har;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.i)localObject1).nI(8);
        }
        localObject2 = this.han;
        if (localObject2 != null)
        {
          localObject1 = com.tencent.mm.live.b.g.gOr;
          localObject1 = com.tencent.mm.live.b.g.ans().Gbw;
          if (localObject1 == null) {
            break label519;
          }
        }
        for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
        {
          localObject3 = com.tencent.mm.live.b.g.gOr;
          ((ay)localObject2).a((CharSequence)localObject1, com.tencent.mm.live.b.g.anu());
          a(b.c.gSp, new Bundle());
          break;
        }
      case 2: 
        label519:
        a(b.c.gRr, new Bundle());
        continue;
        localObject1 = this.gXX;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).disable();
        }
        localObject1 = this.gXX;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a(null);
        }
        this.gXX = null;
        localObject1 = com.tencent.mm.live.b.c.a.gRa;
        localObject1 = com.tencent.mm.live.b.c.a.aow();
        ad.i(this.TAG, "lockOrientation liveRotation:" + ((bun)localObject1).rotation + ", curRotation:" + getCurrentOrientation());
        boolean bool1;
        if ((((bun)localObject1).rotation == -1) || (((bun)localObject1).rotation == getCurrentOrientation()))
        {
          localObject1 = getContext();
          if (localObject1 == null)
          {
            paramc = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(212935);
            throw paramc;
          }
          ((Activity)localObject1).setRequestedOrientation(14);
          localObject1 = com.tencent.mm.live.core.core.trtc.a.a.alJ();
          d.g.b.p.g(localObject1, "ConfigHelper.getInstance()");
          localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).alK();
          d.g.b.p.g(localObject1, "ConfigHelper.getInstance().videoConfig");
          localObject2 = getContext();
          d.g.b.p.g(localObject2, "context");
          localObject2 = ((Context)localObject2).getResources();
          d.g.b.p.g(localObject2, "context.resources");
          if (((Resources)localObject2).getConfiguration().orientation != 1) {
            break label1225;
          }
          bool1 = true;
          label769:
          ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject1).dH(bool1);
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("create live, isVideoVertical:");
          localObject3 = com.tencent.mm.live.core.core.trtc.a.a.alJ();
          d.g.b.p.g(localObject3, "ConfigHelper.getInstance()");
          localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).alK();
          d.g.b.p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
          ad.i((String)localObject1, ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).alY());
          localObject1 = com.tencent.mm.live.b.g.gOr;
          localObject3 = com.tencent.mm.live.b.g.ans();
          if (paramBundle != null)
          {
            localObject2 = paramBundle.getString("PARAM_START_LIVE_TITLE");
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          ((buq)localObject3).Gbw = ((String)localObject1);
          localObject1 = com.tencent.mm.live.b.g.gOr;
          localObject1 = com.tencent.mm.live.b.g.ans().Gbw;
          d.g.b.p.g(localObject1, "LiveDataManager.liveInfo.live_name");
          localObject2 = com.tencent.mm.live.b.g.gOr;
          l = com.tencent.mm.live.b.g.ans().Fsa;
          localObject2 = com.tencent.mm.live.b.g.gOr;
          localObject2 = com.tencent.mm.live.b.g.anm();
          ad.i(this.TAG, "startLive, name:" + (String)localObject1 + ", roomId:" + l);
          if ((l == 0L) || (bt.isNullOrNil((String)localObject2))) {
            break label1284;
          }
          ad.i(this.TAG, "try resume live, liveId:" + l + ", liveName:" + (String)localObject1 + ", roomId:" + (String)localObject2);
          localObject3 = com.tencent.mm.live.b.g.gOr;
          localObject3 = com.tencent.mm.live.b.g.anw();
          if (localObject3 != null) {
            break label1231;
          }
          new com.tencent.mm.live.b.a(l, (String)localObject2, (String)localObject1, (byte)0).a((d.g.a.r)new s(this));
        }
        for (;;)
        {
          localObject1 = this.gWE;
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.live.core.core.a.a)localObject1).alj();
          break;
          switch (((bun)localObject1).rotation)
          {
          default: 
            break;
          case 0: 
          case 2: 
            this.haK = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(212935);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(1);
            break;
          case 1: 
          case 3: 
            this.haK = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(212935);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(0);
            break;
            label1225:
            bool1 = false;
            break label769;
            label1231:
            localObject1 = this.gWE;
            if (localObject1 != null) {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.b.d)localObject3);
            }
            localObject1 = this.gWE;
            if (localObject1 != null)
            {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.b)new t(this));
              continue;
              label1284:
              ad.i("MicroMsg.LiveCoreAnchor", "createNewLive, liveName:" + (String)localObject1 + ", wechatRoomId:" + (String)localObject2);
              localObject3 = getContext();
              d.g.b.p.g(localObject3, "context");
              localObject1 = new com.tencent.mm.live.b.b((String)localObject1, (String)localObject2, (Context)localObject3);
              localObject2 = (s)new b(this);
              localObject3 = com.tencent.mm.kernel.g.ajB();
              d.g.b.p.g(localObject3, "MMKernel.network()");
              ((com.tencent.mm.kernel.b)localObject3).aiU().a(3501, (com.tencent.mm.al.f)localObject1);
              localObject3 = new com.tencent.mm.live.b.a.l(((com.tencent.mm.live.b.b)localObject1).name, ((com.tencent.mm.live.b.b)localObject1).roomId);
              localObject4 = com.tencent.mm.kernel.g.ajB();
              d.g.b.p.g(localObject4, "MMKernel.network()");
              ((com.tencent.mm.kernel.b)localObject4).aiU().b((n)localObject3);
              ((com.tencent.mm.live.b.b)localObject1).gMG = ((s)localObject2);
            }
            break;
          }
        }
        localObject1 = com.tencent.mm.live.b.g.gOr;
        localObject1 = com.tencent.mm.live.b.g.ans().Gbw;
        d.g.b.p.g(localObject1, "LiveDataManager.liveInfo.live_name");
        localObject2 = com.tencent.mm.live.b.g.gOr;
        localObject2 = com.tencent.mm.live.b.g.anm();
        localObject3 = getContext();
        d.g.b.p.g(localObject3, "context");
        localObject1 = new com.tencent.mm.live.b.b((String)localObject1, (String)localObject2, (Context)localObject3);
        localObject2 = (s)new l(this);
        localObject3 = com.tencent.mm.kernel.g.ajB();
        d.g.b.p.g(localObject3, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject3).aiU().a(3797, (com.tencent.mm.al.f)localObject1);
        localObject3 = com.tencent.mm.live.b.g.gOr;
        long l = com.tencent.mm.live.b.g.ans().Fsa;
        localObject3 = ((com.tencent.mm.live.b.b)localObject1).roomId;
        Object localObject4 = com.tencent.mm.live.b.g.gOr;
        localObject3 = new com.tencent.mm.live.b.a.o(l, (String)localObject3, com.tencent.mm.live.b.g.anq());
        localObject4 = com.tencent.mm.kernel.g.ajB();
        d.g.b.p.g(localObject4, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject4).aiU().b((n)localObject3);
        ((com.tencent.mm.live.b.b)localObject1).gMH = ((s)localObject2);
        continue;
        this.haI.azX();
        localObject1 = this.hav;
        if (localObject1 != null) {
          ((ae)localObject1).nI(8);
        }
        localObject1 = (Runnable)new p(this);
        localObject2 = ae.gVG;
        postDelayed((Runnable)localObject1, ae.aoQ() + 50L);
        com.tencent.mm.live.b.i.gPh.aos();
        localObject1 = com.tencent.mm.live.b.i.gPh;
        com.tencent.mm.live.b.i.aon();
        localObject1 = com.tencent.mm.live.b.g.gOr;
        if (com.tencent.mm.live.b.g.ans().FHr == 0)
        {
          localObject1 = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.b.g.ans().FHr = cf.aCN();
        }
        localObject1 = com.tencent.mm.live.b.c.a.gRa;
        if (com.tencent.mm.live.b.c.a.aow().Fsa != 0L) {}
        int j;
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            localObject1 = com.tencent.mm.live.b.c.a.gRa;
            localObject1 = com.tencent.mm.live.b.g.gOr;
            l = com.tencent.mm.live.b.g.ans().Fsa;
            localObject1 = com.tencent.mm.live.b.g.gOr;
            localObject1 = com.tencent.mm.live.b.g.anm();
            i = getCurrentOrientation();
            localObject2 = com.tencent.mm.live.b.g.gOr;
            localObject2 = com.tencent.mm.live.b.g.aog();
            localObject3 = com.tencent.mm.live.b.g.gOr;
            j = com.tencent.mm.live.b.g.ans().FHr;
            localObject3 = com.tencent.mm.live.b.g.gOr;
            com.tencent.mm.live.b.c.a.a(l, (String)localObject1, i, (String)localObject2, j, com.tencent.mm.live.b.g.anu());
          }
          localObject1 = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.b.g.aoh();
          localObject1 = com.tencent.mm.live.b.i.gPh;
          com.tencent.mm.live.b.i.nH(0);
          break;
        }
        localObject1 = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.anA();
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(212935);
          throw paramc;
        }
        ((Activity)localObject1).finishAndRemoveTask();
        continue;
        localObject1 = this.haq;
        if ((localObject1 != null) && (((com.tencent.mm.live.c.g)localObject1).gTk.isShowing())) {
          ((com.tencent.mm.live.c.g)localObject1).gTk.dismiss();
        }
        localObject1 = this.hav;
        if (localObject1 != null) {
          ((ae)localObject1).nI(8);
        }
        aqz();
        localObject1 = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.aoj();
        localObject1 = com.tencent.mm.live.b.i.gPh;
        com.tencent.mm.live.b.i.aop();
        localObject1 = com.tencent.mm.live.b.i.gPh;
        com.tencent.mm.live.b.i.aoq();
        com.tencent.mm.live.b.i.gPh.release();
        localObject1 = com.tencent.mm.live.b.c.gMO;
        com.tencent.mm.live.b.c.amR();
        localObject1 = com.tencent.mm.live.b.c.a.gRa;
        localObject1 = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.c.a.rm(com.tencent.mm.live.b.g.ans().Fsa);
        continue;
        localObject1 = com.tencent.mm.live.b.g.gOr;
        if (!com.tencent.mm.live.b.g.anG().gOz)
        {
          localObject1 = this.ham;
          if (localObject1 != null) {
            ((aq)localObject1).nI(8);
          }
          localObject1 = this.haj;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.ao)localObject1).nI(8);
          }
          localObject1 = this.haf;
          if (localObject1 != null) {
            ((ba)localObject1).nI(8);
          }
          localObject1 = this.hag;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.t)localObject1).nI(8);
          }
          localObject1 = this.hah;
          if (localObject1 != null) {
            ((k)localObject1).nI(8);
          }
          localObject1 = this.hav;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.live.b.g.gOr;
            localObject2 = com.tencent.mm.live.b.g.anu();
            localObject3 = getContext();
            d.g.b.p.g(localObject3, "context");
            localObject3 = ((Context)localObject3).getResources().getString(2131766622);
            d.g.b.p.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
            ((ae)localObject1).at((String)localObject2, (String)localObject3);
          }
          localObject1 = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.b.g.aoi();
          continue;
          localObject1 = com.tencent.mm.live.b.g.gOr;
          if (!com.tencent.mm.live.b.g.anG().gOz)
          {
            localObject1 = this.haj;
            if (localObject1 != null) {
              ((com.tencent.mm.live.c.ao)localObject1).nI(0);
            }
            localObject1 = com.tencent.mm.live.b.g.gOr;
            com.tencent.mm.live.b.g.anG().gOB = false;
            continue;
            if (this.haH)
            {
              localObject1 = getContext();
              if (localObject1 == null)
              {
                paramc = new v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(212935);
                throw paramc;
              }
              ((Activity)localObject1).setRequestedOrientation(4);
              continue;
              if (paramBundle != null)
              {
                localObject2 = paramBundle.getString("PARAM_LIVE_KICK_USERNAME");
                localObject1 = localObject2;
                if (localObject2 != null) {}
              }
              else
              {
                localObject1 = "";
              }
              localObject2 = com.tencent.mm.live.b.i.gPh;
              com.tencent.mm.live.b.i.xO((String)localObject1);
              continue;
              localObject1 = com.tencent.mm.live.b.g.gOr;
              com.tencent.mm.live.b.g.anG().gOC = true;
              continue;
              localObject1 = this.hav;
              if (localObject1 != null) {
                ((ae)localObject1).nI(8);
              }
              localObject1 = this.gXX;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a((d.a)this);
              }
              localObject1 = this.gXX;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).enable();
              }
              localObject1 = com.tencent.mm.live.b.g.gOr;
              if (com.tencent.mm.live.b.g.anH().gOw)
              {
                localObject1 = this.hag;
                if (localObject1 != null) {
                  ((com.tencent.mm.live.c.t)localObject1).nI(0);
                }
                a(b.c.gRp, new Bundle());
                localObject1 = com.tencent.mm.live.b.g.gOr;
                com.tencent.mm.live.b.g.anH().gOw = false;
                continue;
                localObject1 = com.tencent.mm.live.b.g.gOr;
                if (com.tencent.mm.live.b.g.anO()) {}
                for (i = 4;; i = 5)
                {
                  localObject1 = com.tencent.mm.live.b.g.gOr;
                  localObject1 = com.tencent.mm.live.b.g.anm();
                  localObject2 = com.tencent.mm.live.b.g.gOr;
                  bool1 = com.tencent.mm.live.b.g.anL();
                  localObject2 = com.tencent.mm.live.b.g.gOr;
                  bool2 = com.tencent.mm.live.b.g.anM();
                  localObject2 = com.tencent.mm.live.b.g.gOr;
                  localObject2 = com.tencent.mm.live.b.g.ans().Gbw;
                  localObject3 = com.tencent.mm.live.b.g.gOr;
                  bool3 = com.tencent.mm.live.b.g.anK();
                  localObject3 = getContext();
                  d.g.b.p.g(localObject3, "context");
                  localObject3 = ((Context)localObject3).getResources();
                  d.g.b.p.g(localObject3, "context.resources");
                  com.tencent.mm.live.d.e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, ((Resources)localObject3).getConfiguration().orientation, i);
                  localObject1 = getContext();
                  d.g.b.p.g(localObject1, "context");
                  localObject1 = ((Context)localObject1).getResources();
                  d.g.b.p.g(localObject1, "context.resources");
                  if (((Resources)localObject1).getConfiguration().orientation != 2) {
                    break label2623;
                  }
                  com.tencent.mm.live.d.a.aps();
                  break;
                }
                label2623:
                com.tencent.mm.live.d.a.apt();
                continue;
                localObject1 = com.tencent.mm.live.b.g.gOr;
                if (!com.tencent.mm.live.b.g.anG().gOz)
                {
                  localObject1 = this.ham;
                  if (localObject1 != null) {
                    ((aq)localObject1).nI(8);
                  }
                  localObject1 = this.haj;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.c.ao)localObject1).nI(8);
                  }
                  localObject1 = this.haf;
                  if (localObject1 != null) {
                    ((ba)localObject1).nI(8);
                  }
                  localObject1 = this.hag;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.c.t)localObject1).nI(8);
                  }
                  localObject1 = this.hah;
                  if (localObject1 != null) {
                    ((k)localObject1).nI(8);
                  }
                  localObject1 = this.hav;
                  if (localObject1 != null)
                  {
                    localObject2 = com.tencent.mm.live.b.g.gOr;
                    localObject2 = com.tencent.mm.live.b.g.anu();
                    localObject3 = getContext();
                    d.g.b.p.g(localObject3, "context");
                    localObject3 = ((Context)localObject3).getResources().getString(2131766622);
                    d.g.b.p.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
                    ((ae)localObject1).at((String)localObject2, (String)localObject3);
                  }
                  localObject1 = com.tencent.mm.live.b.g.gOr;
                  com.tencent.mm.live.b.g.aoi();
                }
                localObject1 = com.tencent.mm.live.b.g.gOr;
                localObject1 = com.tencent.mm.live.b.g.anm();
                localObject2 = com.tencent.mm.live.b.g.gOr;
                bool1 = com.tencent.mm.live.b.g.anL();
                localObject2 = com.tencent.mm.live.b.g.gOr;
                boolean bool2 = com.tencent.mm.live.b.g.anM();
                localObject2 = com.tencent.mm.live.b.g.gOr;
                localObject2 = com.tencent.mm.live.b.g.ans().Gbw;
                localObject3 = com.tencent.mm.live.b.g.gOr;
                boolean bool3 = com.tencent.mm.live.b.g.anK();
                localObject3 = getContext();
                d.g.b.p.g(localObject3, "context");
                localObject3 = ((Context)localObject3).getResources();
                d.g.b.p.g(localObject3, "context.resources");
                j = ((Resources)localObject3).getConfiguration().orientation;
                if (paramBundle != null) {}
                for (i = paramBundle.getInt("live_user_exit_reason");; i = 0)
                {
                  com.tencent.mm.live.d.e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, j, 6, i);
                  break;
                }
                localObject1 = this.haj;
                if (localObject1 != null) {
                  ((com.tencent.mm.live.c.ao)localObject1).gIn.gLW.amM();
                }
                localObject1 = this.gWE;
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
                  if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).alF() == true))
                  {
                    localObject1 = this.gWE;
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
                      if (localObject1 != null)
                      {
                        ((com.tencent.mm.live.core.core.b.e)localObject1).gHK = e.b.gHV;
                        continue;
                        localObject1 = this.gWE;
                        if (localObject1 != null)
                        {
                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.live.core.core.b.e)localObject1).gHL = e.d.gIb;
                            continue;
                            localObject1 = this.gWE;
                            if (localObject1 != null)
                            {
                              localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
                              if (localObject1 != null)
                              {
                                ((com.tencent.mm.live.core.core.b.e)localObject1).gHL = e.d.gId;
                                continue;
                                localObject1 = this.gWE;
                                if (localObject1 != null)
                                {
                                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
                                  if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.e)localObject1).isFloatMode()))
                                  {
                                    localObject1 = this.gWE;
                                    if (localObject1 != null)
                                    {
                                      localObject2 = getContext();
                                      d.g.b.p.g(localObject2, "context");
                                      ((com.tencent.mm.live.core.core.a.a)localObject1).cp((Context)localObject2);
                                    }
                                    localObject1 = com.tencent.mm.live.b.g.gOr;
                                    localObject1 = com.tencent.mm.live.b.g.anm();
                                    localObject2 = com.tencent.mm.live.b.g.gOr;
                                    l = com.tencent.mm.live.b.g.ans().Fsa;
                                    localObject2 = com.tencent.mm.live.b.g.gOr;
                                    com.tencent.mm.live.d.e.a((String)localObject1, l, com.tencent.mm.live.b.g.anu(), 2, 1);
                                    com.tencent.mm.live.d.a.apq();
                                    continue;
                                    localObject1 = com.tencent.mm.live.b.g.gOr;
                                    localObject1 = com.tencent.mm.live.b.g.anm();
                                    localObject2 = com.tencent.mm.live.b.g.gOr;
                                    l = com.tencent.mm.live.b.g.ans().Fsa;
                                    localObject2 = com.tencent.mm.live.b.g.gOr;
                                    com.tencent.mm.live.d.e.a((String)localObject1, l, com.tencent.mm.live.b.g.anu(), 2, 0);
                                    com.tencent.mm.live.d.a.apr();
                                    continue;
                                    localObject1 = this.gWE;
                                    if (localObject1 != null)
                                    {
                                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
                                      if (localObject1 != null)
                                      {
                                        ((com.tencent.mm.live.core.core.b.e)localObject1).gHK = e.b.gHU;
                                        continue;
                                        localObject1 = this.gWE;
                                        if (localObject1 != null)
                                        {
                                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
                                          if (localObject1 != null) {
                                            ((com.tencent.mm.live.core.core.b.e)localObject1).gHK = e.b.gHT;
                                          }
                                        }
                                        localObject1 = this.haw;
                                        if (localObject1 != null)
                                        {
                                          this.haF.remove(localObject1);
                                          continue;
                                          localObject1 = com.tencent.mm.live.core.core.trtc.a.a.alJ();
                                          d.g.b.p.g(localObject1, "ConfigHelper.getInstance()");
                                          localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).alK();
                                          d.g.b.p.g(localObject1, "ConfigHelper.getInstance().videoConfig");
                                          localObject2 = com.tencent.mm.live.b.g.gOr;
                                          if (!com.tencent.mm.live.b.g.anJ().aol())
                                          {
                                            bool1 = true;
                                            label3398:
                                            ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject1).dI(bool1);
                                            localObject1 = this.gWE;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.core.core.a.a)localObject1).y(0.0F, 0.0F);
                                            }
                                            localObject1 = this.haj;
                                            if (localObject1 == null) {
                                              continue;
                                            }
                                            localObject2 = com.tencent.mm.live.b.g.gOr;
                                            if (!com.tencent.mm.live.b.g.anJ().aol()) {
                                              break label3508;
                                            }
                                          }
                                          label3508:
                                          for (i = 2;; i = 1)
                                          {
                                            localObject2 = com.tencent.mm.live.b.g.gOr;
                                            localObject2 = com.tencent.mm.live.b.g.anJ().userId;
                                            localObject3 = com.tencent.mm.live.b.g.gOr;
                                            j = com.tencent.mm.live.b.g.anJ().streamType;
                                            d.g.b.p.h(localObject2, "userId");
                                            ((com.tencent.mm.live.c.ao)localObject1).gIn.c(i, (String)localObject2, j);
                                            break;
                                            bool1 = false;
                                            break label3398;
                                          }
                                          localObject1 = com.tencent.mm.live.b.g.gOr;
                                          if (!com.tencent.mm.live.b.g.anG().gOz)
                                          {
                                            localObject1 = this.ham;
                                            if (localObject1 != null) {
                                              ((aq)localObject1).nI(8);
                                            }
                                            localObject1 = this.haj;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.ao)localObject1).nI(8);
                                            }
                                            localObject1 = this.haf;
                                            if (localObject1 != null) {
                                              ((ba)localObject1).nI(8);
                                            }
                                            localObject1 = this.hag;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.t)localObject1).nI(8);
                                            }
                                            localObject1 = this.hah;
                                            if (localObject1 != null) {
                                              ((k)localObject1).nI(8);
                                            }
                                            localObject1 = this.hav;
                                            if (localObject1 != null) {
                                              ((ae)localObject1).nI(8);
                                            }
                                            localObject1 = this.haA;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.r)localObject1).nI(0);
                                            }
                                            localObject1 = com.tencent.mm.live.b.g.gOr;
                                            com.tencent.mm.live.b.g.aoi();
                                            localObject1 = getContext();
                                            if (localObject1 == null)
                                            {
                                              paramc = new v("null cannot be cast to non-null type android.app.Activity");
                                              AppMethodBeat.o(212935);
                                              throw paramc;
                                            }
                                            ((Activity)localObject1).setRequestedOrientation(1);
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
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
  }
  
  public final void aoA()
  {
    AppMethodBeat.i(212941);
    super.aoA();
    Object localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aiU().b(3806, (com.tencent.mm.al.f)this);
    localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aiU().b(3559, (com.tencent.mm.al.f)this);
    localObject = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aiU().b(3557, (com.tencent.mm.al.f)this);
    if ((!aqB()) && (!this.haK))
    {
      localObject = this.gWE;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).alf();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).alF() == true)) {}
      }
      else
      {
        localObject = this.gWE;
        if (localObject == null) {
          break label191;
        }
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).alf();
        if ((localObject == null) || (((com.tencent.mm.live.core.core.b.e)localObject).alE() != true)) {
          break label191;
        }
      }
      localObject = this.haq;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.c.g)localObject).gTj.getSelectUser();
        if (localObject != null)
        {
          com.tencent.mm.live.b.i locali = com.tencent.mm.live.b.i.gPh;
          com.tencent.mm.live.b.i.as(((a.a)localObject).gQS, ((a.a)localObject).gQU);
        }
      }
      label191:
      localObject = com.tencent.mm.live.b.i.gPh;
      com.tencent.mm.live.b.i.nH(1);
      aqz();
      com.tencent.mm.live.b.i.gPh.release();
      localObject = com.tencent.mm.live.b.c.gMO;
      com.tencent.mm.live.b.c.amR();
      localObject = this.gWE;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.a)localObject).alh();
      }
      localObject = com.tencent.mm.live.core.core.a.b.gHl;
      b.a.releaseInstance();
      localObject = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.Zh();
      this.haI.abe();
    }
    AppMethodBeat.o(212941);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(212943);
    boolean bool2 = super.aoB();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
      bool1 = bool2;
      if (!com.tencent.mm.live.b.g.anG().gOB)
      {
        localg = com.tencent.mm.live.b.g.gOr;
        bool1 = bool2;
        if (com.tencent.mm.live.b.g.anG().gOA)
        {
          b.b.a(this, b.c.gRv);
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(212943);
    return bool1;
  }
  
  public final void aoz()
  {
    AppMethodBeat.i(212940);
    super.aoz();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().a(3806, (com.tencent.mm.al.f)this);
    localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().a(3559, (com.tencent.mm.al.f)this);
    localb = com.tencent.mm.kernel.g.ajB();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.aiU().a(3557, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(212940);
  }
  
  public final void dW(boolean paramBoolean)
  {
    this.haH = paramBoolean;
  }
  
  public final void f(int paramInt, Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 1;
    int i = 0;
    AppMethodBeat.i(212951);
    Object localObject4 = c.b.gHd;
    if (paramInt == c.b.alm())
    {
      b.b.a(this, b.c.gRR);
      paramBundle = this.haq;
      if (paramBundle != null)
      {
        paramBundle.aoG();
        AppMethodBeat.o(212951);
        return;
      }
      AppMethodBeat.o(212951);
      return;
    }
    localObject4 = c.b.gHd;
    if (paramInt == c.b.alr())
    {
      paramBundle = this.gWE;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.alf();
        if (paramBundle != null)
        {
          if (paramBundle.alE() != true) {
            break label1339;
          }
          paramBundle = this.gWE;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.alf();
            if (paramBundle != null) {
              paramBundle.gHK = e.b.gHU;
            }
          }
          paramBundle = this.haq;
          if (paramBundle == null) {
            break label160;
          }
          paramBundle.aoF();
          AppMethodBeat.o(212951);
          return;
        }
      }
      AppMethodBeat.o(212951);
      return;
      label160:
      AppMethodBeat.o(212951);
    }
    else
    {
      localObject4 = c.b.gHd;
      if (paramInt == c.b.aln())
      {
        if (paramBundle != null)
        {
          localObject2 = paramBundle.getString("live_user_id");
          paramBundle.getString("live_user_exit_reason");
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
          paramBundle = com.tencent.mm.live.b.g.gOr;
          paramBundle = com.tencent.mm.live.b.g.aod().gQP;
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.gQU;; paramBundle = null)
          {
            ad.i((String)localObject3, paramBundle);
            paramBundle = com.tencent.mm.live.b.g.gOr;
            localObject3 = com.tencent.mm.live.b.g.aod().gQP;
            paramBundle = (Bundle)localObject1;
            if (localObject3 != null) {
              paramBundle = ((a.a)localObject3).gQU;
            }
            if (!d.g.b.p.i(localObject2, paramBundle)) {
              break;
            }
            paramBundle = this.gWE;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.cc.a.az(getContext(), 2131766706);
              d.g.b.p.g(localObject1, "ResourceHelper.getString…ring.live_room_mini_live)");
              paramBundle.xl((String)localObject1);
            }
            b.b.a(this, b.c.gRE);
            paramBundle = com.tencent.mm.live.b.g.gOr;
            paramBundle = com.tencent.mm.live.b.g.aod().gQP;
            if (paramBundle == null) {
              break;
            }
            localObject1 = com.tencent.mm.live.b.g.gOr;
            com.tencent.mm.live.b.g.aod().a(paramBundle.gGy, paramBundle.gQT, paramBundle.gQS);
            AppMethodBeat.o(212951);
            return;
          }
          AppMethodBeat.o(212951);
          return;
        }
        AppMethodBeat.o(212951);
        return;
      }
      localObject1 = c.b.gHd;
      if (paramInt == c.b.alo())
      {
        if (paramBundle != null)
        {
          localObject1 = paramBundle.getString("live_user_id");
          boolean bool = paramBundle.getBoolean("live_media_enable");
          paramBundle = com.tencent.mm.live.b.g.gOr;
          localObject2 = com.tencent.mm.live.b.g.aod().gQP;
          paramBundle = (Bundle)localObject3;
          if (localObject2 != null) {
            paramBundle = ((a.a)localObject2).gQU;
          }
          if (d.g.b.p.i(localObject1, paramBundle))
          {
            if (bool)
            {
              paramBundle = this.gWE;
              if (paramBundle != null)
              {
                localObject1 = com.tencent.mm.cc.a.az(getContext(), 2131766707);
                d.g.b.p.g(localObject1, "ResourceHelper.getString…tring.live_room_mini_mic)");
                paramBundle.xl((String)localObject1);
              }
              b.b.a(this, b.c.gRB);
              AppMethodBeat.o(212951);
              return;
            }
            paramBundle = this.gWE;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.cc.a.az(getContext(), 2131766706);
              d.g.b.p.g(localObject1, "ResourceHelper.getString…ring.live_room_mini_live)");
              paramBundle.xl((String)localObject1);
            }
            paramBundle = this.haq;
            if (paramBundle != null)
            {
              LiveAnchorMicUserListView.a(paramBundle.gTj);
              AppMethodBeat.o(212951);
              return;
            }
          }
          AppMethodBeat.o(212951);
          return;
        }
        AppMethodBeat.o(212951);
        return;
      }
      localObject1 = c.b.gHd;
      if (paramInt == c.b.alp())
      {
        i = this.haE;
        paramBundle = this.gWE;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.alf();
          if (paramBundle != null)
          {
            paramInt = paramBundle.gHR;
            this.haE = paramInt;
            paramBundle = c.c.gHi;
            if (i == c.c.alx()) {
              break label730;
            }
            paramInt = this.haE;
            paramBundle = c.c.gHi;
            if (paramInt != c.c.alx()) {
              break label730;
            }
            b.b.a(this, b.c.gSg);
            if (this.haj != null) {}
          }
        }
        for (;;)
        {
          paramInt = this.haE;
          paramBundle = c.c.gHi;
          if (paramInt != c.c.alu()) {
            break label787;
          }
          com.tencent.mm.live.core.c.a.amz();
          AppMethodBeat.o(212951);
          return;
          paramBundle = c.c.gHi;
          paramInt = c.c.alv();
          break;
          label730:
          paramBundle = c.c.gHi;
          if (i == c.c.alx())
          {
            paramInt = this.haE;
            paramBundle = c.c.gHi;
            if (paramInt != c.c.alx())
            {
              b.b.a(this, b.c.gSh);
              paramBundle = this.haj;
              if (paramBundle != null) {
                paramBundle.resume();
              }
              paramBundle = com.tencent.mm.live.b.i.gPh;
              com.tencent.mm.live.b.i.aoq();
            }
          }
        }
        label787:
        paramBundle = c.c.gHi;
        if (paramInt == c.c.alv())
        {
          com.tencent.mm.live.core.c.a.amA();
          AppMethodBeat.o(212951);
          return;
        }
        paramBundle = c.c.gHi;
        if (paramInt == c.c.alw())
        {
          com.tencent.mm.live.core.c.a.amB();
          AppMethodBeat.o(212951);
          return;
        }
        paramBundle = c.c.gHi;
        if (paramInt == c.c.alx())
        {
          com.tencent.mm.live.core.c.a.amC();
          AppMethodBeat.o(212951);
          return;
        }
        AppMethodBeat.o(212951);
        return;
      }
      localObject1 = c.b.gHd;
      long l;
      if (paramInt == c.b.alq())
      {
        paramBundle = this.gWE;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.alf();
          if ((paramBundle != null) && (paramBundle.alF() == true)) {
            i = j;
          }
        }
        for (;;)
        {
          paramBundle = com.tencent.mm.live.b.g.gOr;
          localObject2 = com.tencent.mm.live.b.g.anm();
          paramBundle = com.tencent.mm.live.b.g.gOr;
          l = com.tencent.mm.live.b.g.ans().Fsa;
          paramBundle = com.tencent.mm.live.b.g.gOr;
          paramBundle = com.tencent.mm.live.b.g.aod().gQP;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.gQS;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          localObject1 = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.b.g.anu(), i, 0, paramInt);
          AppMethodBeat.o(212951);
          return;
          paramBundle = this.gWE;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.alf();
            if ((paramBundle != null) && (paramBundle.alE() == true))
            {
              i = 2;
              continue;
            }
          }
          i = 0;
        }
      }
      localObject1 = c.b.gHd;
      if (paramInt == c.b.als())
      {
        paramBundle = com.tencent.mm.live.b.g.gOr;
        l = com.tencent.mm.live.b.g.ans().Fsa;
        paramBundle = com.tencent.mm.live.b.g.gOr;
        paramBundle = com.tencent.mm.live.b.g.anm();
        localObject1 = com.tencent.mm.live.b.g.gOr;
        localObject1 = com.tencent.mm.live.b.g.ans().Gbw;
        d.g.b.p.g(localObject1, "LiveDataManager.liveInfo.live_name");
        new com.tencent.mm.live.b.a(l, paramBundle, (String)localObject1, (byte)0).a((d.g.a.r)new a(this));
        AppMethodBeat.o(212951);
        return;
      }
      localObject1 = c.b.gHd;
      if (paramInt == c.b.alt())
      {
        localObject4 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("EVENT_RENDER_FIRST_I_FRAME, userId:");
        if (paramBundle != null)
        {
          localObject3 = paramBundle.getString("live_user_id");
          localObject1 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ad.i((String)localObject4, (String)localObject1);
        localObject1 = localObject2;
        if (paramBundle != null) {
          localObject1 = paramBundle.getString("live_user_id");
        }
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject1 = com.tencent.mm.live.b.g.gOr;
          localObject3 = com.tencent.mm.live.b.g.anJ();
          if (paramBundle != null)
          {
            localObject2 = paramBundle.getString("live_user_id");
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          ((g.c)localObject3).setUserId((String)localObject1);
          localObject1 = com.tencent.mm.live.b.g.gOr;
          localObject1 = com.tencent.mm.live.b.g.anJ();
          if (paramBundle == null) {
            break label1346;
          }
          paramInt = paramBundle.getInt("live_stream_type");
          ((g.c)localObject1).streamType = paramInt;
          localObject1 = com.tencent.mm.live.b.g.gOr;
          localObject1 = com.tencent.mm.live.b.g.anJ();
          if (paramBundle == null) {
            break label1351;
          }
        }
      }
    }
    label1339:
    label1346:
    label1351:
    for (paramInt = paramBundle.getInt("live_first_frame_width");; paramInt = 0)
    {
      ((g.c)localObject1).width = paramInt;
      localObject1 = com.tencent.mm.live.b.g.gOr;
      localObject1 = com.tencent.mm.live.b.g.anJ();
      paramInt = i;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("live_first_frame_height");
      }
      ((g.c)localObject1).height = paramInt;
      b.b.a(this, b.c.gSq);
      AppMethodBeat.o(212951);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final int getLiveRole()
  {
    return 1;
  }
  
  public final int getRelativeLayoutId()
  {
    return 2131496301;
  }
  
  public final void nL(int paramInt)
  {
    AppMethodBeat.i(212950);
    if ((this.haJ == -1) || (this.haJ != paramInt))
    {
      ad.i(this.TAG, "onOrientationChange orientation:".concat(String.valueOf(paramInt)));
      this.haJ = paramInt;
      ad.i(this.TAG, "refreshCamera");
      com.tencent.mm.live.core.core.a.a locala = this.gWE;
      if (locala != null)
      {
        locala.ald();
        AppMethodBeat.o(212950);
        return;
      }
    }
    AppMethodBeat.o(212950);
  }
  
  public final String name()
  {
    AppMethodBeat.i(212939);
    String str = getClass().getSimpleName();
    d.g.b.p.g(str, "this.javaClass.simpleName");
    AppMethodBeat.o(212939);
    return str;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(212937);
    d.g.b.p.h(paramString, "incomingNumber");
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.gWE;
    if (paramString != null)
    {
      paramString = paramString.alf();
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.isFloatMode());
        ad.i((String)localObject, paramString);
        switch (paramInt)
        {
        }
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(212937);
        return;
        paramString = null;
        break;
        AppMethodBeat.o(212937);
        return;
        paramString = com.tencent.mm.live.b.i.gPh;
        com.tencent.mm.live.b.i.nH(2);
        paramString = this.gWE;
        if (paramString != null)
        {
          paramString = paramString.alf();
          if ((paramString != null) && (paramString.isFloatMode() == true))
          {
            paramString = com.tencent.mm.live.b.g.gOr;
            com.tencent.mm.live.b.g.anA();
            paramString = this.gWE;
            if (paramString != null) {
              paramString.alc();
            }
            paramString = this.gWE;
            if (paramString != null)
            {
              paramString.alg();
              AppMethodBeat.o(212937);
              return;
            }
            AppMethodBeat.o(212937);
            return;
          }
        }
        paramString = this.gWE;
        if (paramString != null) {
          paramString.alc();
        }
        paramString = this.gWE;
        if (paramString != null)
        {
          paramString.ali();
          AppMethodBeat.o(212937);
          return;
        }
        AppMethodBeat.o(212937);
        return;
        paramString = com.tencent.mm.live.b.i.gPh;
        com.tencent.mm.live.b.i.nH(0);
        paramString = this.gWE;
        if (paramString == null) {
          break label346;
        }
        paramString = paramString.alf();
        if (paramString == null) {
          break label346;
        }
        localObject = com.tencent.mm.live.b.g.gOr;
      } while (paramString.b(Long.valueOf(com.tencent.mm.live.b.g.ans().Fsa)) != true);
      paramString = this.haj;
      if (paramString != null) {
        paramString.startPreview();
      }
      paramString = this.gWE;
    } while (paramString == null);
    paramString.alj();
    AppMethodBeat.o(212937);
    return;
    label346:
    AppMethodBeat.o(212937);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(212944);
    ad.i(this.TAG, "errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = com.tencent.mm.live.b.g.gOr;
        if (!com.tencent.mm.live.b.g.anG().gOz)
        {
          paramString = com.tencent.mm.live.b.g.gOr;
          if (!com.tencent.mm.live.b.g.anG().gOB) {}
        }
        else
        {
          AppMethodBeat.o(212944);
          return;
        }
        paramString = this.har;
        if (paramString != null)
        {
          paramn = com.tencent.mm.live.b.g.gOr;
          paramString.gTs = com.tencent.mm.live.b.g.ans().FBr;
        }
        paramString = this.har;
        if (paramString != null) {
          paramString.aoH();
        }
        paramString = com.tencent.mm.live.b.g.gOr;
        paramString = com.tencent.mm.live.b.g.gOr;
        paramInt1 = i;
        if (!com.tencent.mm.live.b.g.ans().FBr) {
          paramInt1 = cf.aCN();
        }
        com.tencent.mm.live.b.g.nt(paramInt1);
        paramString = com.tencent.mm.live.b.g.gOr;
        if (com.tencent.mm.live.b.g.ans().oxQ > 0) {
          b.b.a(this, b.c.gRO);
        }
        AppMethodBeat.o(212944);
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.live.b.a.p))
      {
        paramString = this.hao;
        if (paramString != null)
        {
          i = j;
          if (paramInt1 == 0)
          {
            i = j;
            if (paramInt2 == 0) {
              i = 1;
            }
          }
          paramn = paramString.gWk;
          if (paramn != null) {
            paramn.dismiss();
          }
          if (i != 0)
          {
            paramn = paramString.gGK.getContext();
            paramString = paramString.gGK.getContext();
            d.g.b.p.g(paramString, "root.context");
            com.tencent.mm.ui.base.t.cm(paramn, paramString.getResources().getString(2131766628));
            AppMethodBeat.o(212944);
            return;
          }
          paramn = paramString.gGK.getContext();
          paramString = paramString.gGK.getContext();
          d.g.b.p.g(paramString, "root.context");
          com.tencent.mm.ui.base.t.cn(paramn, paramString.getResources().getString(2131766627));
          AppMethodBeat.o(212944);
          return;
        }
        AppMethodBeat.o(212944);
        return;
      }
      if (((paramn instanceof u)) && ((paramInt1 != 0) || (paramInt2 != 0)))
      {
        paramInt1 = this.haL;
        paramString = com.tencent.mm.live.b.f.gMV;
        if (paramInt1 < com.tencent.mm.live.b.f.amV())
        {
          this.haL += 1;
          ad.i(this.TAG, "will retry share live, delay:" + this.haL * 1000L);
          postDelayed((Runnable)LiveAnchorPluginLayout.n.haV, this.haL * 1000L);
        }
      }
    }
    AppMethodBeat.o(212944);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(212949);
    super.pause();
    boolean bool = aqB();
    ad.i(this.TAG, "pause orientationChanged:" + bool + ", currentOrientation:" + getCurrentOrientation());
    Object localObject;
    if (!bool)
    {
      localObject = com.tencent.mm.live.b.g.gOr;
      if (!com.tencent.mm.live.b.g.anG().gOB)
      {
        localObject = com.tencent.mm.live.b.g.gOr;
        if (!com.tencent.mm.live.b.g.anG().gOz)
        {
          localObject = com.tencent.mm.live.b.g.gOr;
          if (!com.tencent.mm.live.b.g.anG().gOC)
          {
            localObject = com.tencent.mm.live.b.g.gOr;
            if (com.tencent.mm.live.b.g.anG().gOA)
            {
              localObject = com.tencent.mm.live.b.g.gOr;
              if ((!com.tencent.mm.live.b.g.anz()) && (!this.haK) && (com.tencent.mm.compatible.d.b.ca(getContext()))) {
                b.b.a(this, b.c.gRJ);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = this.gXX;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
      }
      localObject = this.gXX;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).a(null);
      }
      this.gXX = null;
      AppMethodBeat.o(212949);
      return;
      localObject = this.gWE;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).alf();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).alC() == true) && (!this.haK))
        {
          localObject = this.gWE;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.a)localObject).alc();
          }
          localObject = this.gWE;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.a)localObject).ali();
          }
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(212948);
    super.resume();
    ad.d(this.TAG, "resume curRotation:" + getCurrentOrientation());
    Object localObject1 = com.tencent.mm.live.b.g.gOr;
    com.tencent.mm.live.b.g.anG().gOC = false;
    localObject1 = com.tencent.mm.live.b.g.gOr;
    Object localObject2;
    if (com.tencent.mm.live.b.g.ans().Fsa != 0L)
    {
      localObject1 = com.tencent.mm.live.b.g.gOr;
      if (!com.tencent.mm.live.b.g.anG().gOz)
      {
        localObject1 = com.tencent.mm.kernel.g.aiU();
        d.g.b.p.g(localObject1, "MMKernel.getNetSceneQueue()");
        if (((com.tencent.mm.al.q)localObject1).aiY() != null)
        {
          localObject1 = com.tencent.mm.live.b.g.gOr;
          long l = com.tencent.mm.live.b.g.ans().Fsa;
          localObject1 = com.tencent.mm.live.b.g.gOr;
          localObject1 = new com.tencent.mm.live.b.a.b(l, com.tencent.mm.live.b.g.anm(), true);
          localObject2 = com.tencent.mm.kernel.g.aiU();
          d.g.b.p.g(localObject2, "MMKernel.getNetSceneQueue()");
          ((com.tencent.mm.live.b.a.b)localObject1).doScene(((com.tencent.mm.al.q)localObject2).aiY(), (com.tencent.mm.al.f)new o(this));
        }
        localObject1 = this.gWE;
        if (localObject1 == null) {
          break label318;
        }
        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.b.e)localObject1).gHI)) {
          break label318;
        }
        localObject1 = this.gWE;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.a.a)localObject1).ale();
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.nu(getCurrentOrientation());
      AppMethodBeat.o(212948);
      return;
      localObject1 = this.haj;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.ao)localObject1).startPreview();
      }
      localObject1 = this.gWE;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.b.e)localObject1).alC() != true)) {
        break;
      }
      localObject1 = this.gWE;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.live.b.g.gOr;
      if (((com.tencent.mm.live.core.core.b.e)localObject1).b(Long.valueOf(com.tencent.mm.live.b.g.ans().Fsa)) != true) {
        break;
      }
      localObject1 = this.gWE;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.live.core.core.a.a)localObject1).alj();
      break;
      label318:
      localObject1 = this.gWE;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alf();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.b.e)localObject1).gHI = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(212942);
    super.start();
    Object localObject = com.tencent.mm.live.b.i.gPh;
    com.tencent.mm.live.b.i.aoq();
    localObject = com.tencent.mm.live.b.g.gOr;
    if ((com.tencent.mm.live.b.g.ans().Fsa == 0L) && (this.haH))
    {
      localObject = com.tencent.mm.live.b.g.gOr;
      if (!com.tencent.mm.live.b.g.anG().gOz)
      {
        localObject = com.tencent.mm.live.b.g.gOr;
        if (!com.tencent.mm.live.b.g.anG().gOC)
        {
          localObject = com.tencent.mm.live.b.g.gOr;
          if (!com.tencent.mm.live.b.g.anG().gOB)
          {
            localObject = getContext();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(212942);
              throw ((Throwable)localObject);
            }
            ((Activity)localObject).setRequestedOrientation(4);
          }
        }
      }
    }
    AppMethodBeat.o(212942);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, z>
  {
    a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "success", "", "needFaceVerify", "verifyUrl", "", "errCode", "", "errMsg", "invoke"})
  static final class b
    extends d.g.b.q
    implements s<Boolean, Boolean, String, Integer, String, z>
  {
    b(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/view/LiveAnchorPluginLayout$createNewLive$1$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
    public static final class a
      extends com.tencent.mm.plugin.messenger.a.a
    {
      a(int paramInt) {}
      
      public final void onClickImp(View paramView)
      {
        AppMethodBeat.i(212911);
        d.g.b.p.h(paramView, "widget");
        paramView = new Intent();
        com.tencent.mm.live.b.f.a locala = com.tencent.mm.live.b.f.gMV;
        paramView.putExtra("rawUrl", com.tencent.mm.live.b.f.amU());
        paramView.putExtra("showShare", false);
        com.tencent.mm.bs.d.f(this.haO.haM.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
        AppMethodBeat.o(212911);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(212914);
      b.b.a(this.haM, b.c.gRw);
      AppMethodBeat.o(212914);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class f
    implements DialogInterface.OnDismissListener
  {
    f(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(212916);
      paramDialogInterface = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.aoi();
      b.b.a(this.haM, b.c.gRw);
      AppMethodBeat.o(212916);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class h
    implements DialogInterface.OnDismissListener
  {
    h(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(212918);
      paramDialogInterface = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.aoi();
      b.b.a(this.haM, b.c.gRw);
      AppMethodBeat.o(212918);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/view/LiveAnchorPluginLayout$handleJoinLiveFail$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
  public static final class i
    extends com.tencent.mm.plugin.messenger.a.a
  {
    i(int paramInt) {}
    
    public final void onClickImp(View paramView)
    {
      AppMethodBeat.i(212919);
      d.g.b.p.h(paramView, "widget");
      paramView = new Intent();
      com.tencent.mm.live.b.f.a locala = com.tencent.mm.live.b.f.gMV;
      paramView.putExtra("rawUrl", com.tencent.mm.live.b.f.amU());
      paramView.putExtra("showShare", false);
      com.tencent.mm.bs.d.f(this.haM.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(212919);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "xOffset", "", "yOffset", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.m<Float, Float, z>
  {
    j(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.m<Float, Float, z>
  {
    k(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "success", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class l
    extends d.g.b.q
    implements s<Boolean, Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, z>
  {
    l(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/view/LiveAnchorPluginLayout$joinLive$1$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class a
      implements com.tencent.mm.live.core.core.b
    {
      a(LiveAnchorPluginLayout.l paraml) {}
      
      public final void f(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(212922);
        ad.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish");
        if (paramInt >= 0)
        {
          b.b.a(this.haT.haM, b.c.gRu);
          paramBundle = LiveAnchorPluginLayout.b(this.haT.haM);
          if (paramBundle != null)
          {
            String str = com.tencent.mm.cc.a.az(this.haT.haM.getContext(), 2131766706);
            d.g.b.p.g(str, "ResourceHelper.getString…ring.live_room_mini_live)");
            paramBundle.xl(str);
          }
          paramBundle = com.tencent.mm.live.b.i.gPh;
          paramBundle = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.b.i.xN(com.tencent.mm.live.b.g.anm());
          b.b.a(this.haT.haM, b.c.gSk);
          AppMethodBeat.o(212922);
          return;
        }
        ad.w("MicroMsg.LiveCoreAnchor", "enter room fail");
        com.tencent.mm.ui.base.t.makeText(this.haT.haM.getContext(), (CharSequence)"enter room fail", 0).show();
        b.b.a(this.haT.haM, b.c.gRr);
        paramBundle = new Bundle();
        paramBundle.putInt("live_user_exit_reason", paramInt);
        this.haT.haM.a(b.c.gSj, paramBundle);
        AppMethodBeat.o(212922);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    m(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class o
    implements com.tencent.mm.al.f
  {
    o(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(212928);
      paramn.setHasCallbackToQueue(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
          AppMethodBeat.o(212928);
          throw paramString;
        }
        paramString = ((com.tencent.mm.live.b.a.b)paramn).ans();
        if (paramString != null)
        {
          if (paramString.oxQ != 0) {
            break label209;
          }
          paramString = com.tencent.mm.live.b.g.gOr;
          if (com.tencent.mm.live.b.g.anG().gOz) {
            break label209;
          }
          paramString = LiveAnchorPluginLayout.d(this.haM);
          if (paramString != null) {
            paramString.startPreview();
          }
          paramString = LiveAnchorPluginLayout.b(this.haM);
          if (paramString != null)
          {
            paramString = paramString.alf();
            if (paramString != null)
            {
              if (paramString.alC() != true) {
                break label209;
              }
              paramString = LiveAnchorPluginLayout.b(this.haM);
              if (paramString == null) {
                break label203;
              }
              paramString = paramString.alf();
              if (paramString == null) {
                break label203;
              }
              paramn = com.tencent.mm.live.b.g.gOr;
              if (paramString.b(Long.valueOf(com.tencent.mm.live.b.g.ans().Fsa)) != true) {
                break label209;
              }
              paramString = LiveAnchorPluginLayout.b(this.haM);
              if (paramString == null) {
                break label209;
              }
              paramString.alj();
              AppMethodBeat.o(212928);
            }
          }
        }
        else
        {
          AppMethodBeat.o(212928);
          return;
        }
        AppMethodBeat.o(212928);
        return;
        label203:
        AppMethodBeat.o(212928);
        return;
      }
      label209:
      AppMethodBeat.o(212928);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(212929);
      ae localae = LiveAnchorPluginLayout.a(this.haM);
      if (localae != null)
      {
        localae.gGK.setVisibility(8);
        AppMethodBeat.o(212929);
        return;
      }
      AppMethodBeat.o(212929);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/view/LiveAnchorPluginLayout$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class q
    implements com.tencent.mm.live.core.core.b
  {
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(212930);
      ad.i("MicroMsg.LiveCoreAnchor", "on exitRoom finish");
      AppMethodBeat.o(212930);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class r
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    r(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "ret", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class s
    extends d.g.b.q
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, z>
  {
    s(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/view/LiveAnchorPluginLayout$tryResumeLive$2", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class t
    implements com.tencent.mm.live.core.core.b
  {
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(212934);
      ad.i("MicroMsg.LiveCoreAnchor", "try resume live on enterRoom finish");
      if (paramInt >= 0)
      {
        b.b.a(this.haM, b.c.gRu);
        AppMethodBeat.o(212934);
        return;
      }
      ad.w("MicroMsg.LiveCoreAnchor", "try resume live senter room fail");
      com.tencent.mm.ui.base.t.makeText(this.haM.getContext(), (CharSequence)"enter room fail", 0).show();
      b.b.a(this.haM, b.c.gRr);
      AppMethodBeat.o(212934);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAnchorPluginLayout
 * JD-Core Version:    0.7.0.1
 */