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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.u;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.live.b.g.c;
import com.tencent.mm.live.b.g.d;
import com.tencent.mm.live.c.ae;
import com.tencent.mm.live.c.ag;
import com.tencent.mm.live.c.ai;
import com.tencent.mm.live.c.ak;
import com.tencent.mm.live.c.ao;
import com.tencent.mm.live.c.aq;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.au;
import com.tencent.mm.live.c.ay;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.c.ba;
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
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.s;
import d.v;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/LiveAnchorPluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "", "curStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "fromForcelockOrientation", "", "lastRotationFromSensor", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveAnchorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "liveAnchorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorMicPlugin;", "liveBanCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "liveBeforePlugin", "Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "liveReadyPlugin", "Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "liveRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveShareRoomsPlugin", "Lcom/tencent/mm/live/plugin/LiveShareRoomsPlugin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "navigation", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "nextStatus", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "pluginShow", "rotationEnable", "shareLiveRetryCount", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkClickArea", "x", "", "y", "validCallback", "checkInitStatus", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "checkVerify", "createNewLive", "liveName", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleErrForeigner", "handleJoinLiveFail", "errCode", "errMsg", "initLogic", "router", "isFinished", "joinLive", "lockOrientation", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onOrientationChange", "orientation", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "orientationChanged", "pause", "refreshCamera", "resume", "start", "startLive", "liveId", "", "statusChange", "status", "stopLive", "toggleShowPlugins", "tryResumeLive", "unMount", "updatePlugin", "plugin-logic_release"})
public final class LiveAnchorPluginLayout
  extends BaseLivePluginLayout
  implements com.tencent.mm.ak.g, com.tencent.mm.live.core.core.b, d.a
{
  private final String TAG;
  private d.g.a.a<y> gBo;
  private com.tencent.mm.live.core.core.a.a gCU;
  private com.tencent.mm.plugin.mmsight.model.d gEn;
  private as gGA;
  private com.tencent.mm.live.c.m gGB;
  private aq gGC;
  private ay gGD;
  private ai gGE;
  private x gGF;
  private com.tencent.mm.live.c.g gGG;
  private com.tencent.mm.live.c.i gGH;
  private com.tencent.mm.live.c.o gGI;
  private com.tencent.mm.live.c.am gGJ;
  private au gGK;
  private ae gGL;
  private ak gGM;
  private com.tencent.mm.live.c.ac gGN;
  private ag gGO;
  private com.tencent.mm.live.c.e gGP;
  private com.tencent.mm.live.c.r gGQ;
  private com.tencent.mm.live.a.a gGR;
  private b.c gGS;
  private b.c gGT;
  private int gGU;
  private final ArrayList<com.tencent.mm.live.c.a> gGV;
  private boolean gGW;
  private boolean gGX;
  private final com.tencent.mm.model.d gGY;
  private int gGZ;
  private ba gGv;
  private com.tencent.mm.live.c.t gGw;
  private com.tencent.mm.live.c.k gGx;
  private com.tencent.mm.live.c.c gGy;
  private ao gGz;
  private boolean gHa;
  private int gHb;
  
  public LiveAnchorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(190662);
    this.TAG = "MicroMsg.LiveAnchorPluginLayout";
    this.gGS = b.c.gxG;
    this.gGT = b.c.gxG;
    paramContext = c.c.gnz;
    this.gGU = c.c.aiJ();
    this.gGV = new ArrayList();
    this.gGW = true;
    this.gGY = com.tencent.mm.model.d.axh();
    this.gGZ = -1;
    this.gBo = ((d.g.a.a)new m(this));
    AppMethodBeat.o(190662);
  }
  
  private final void a(float paramFloat1, float paramFloat2, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(190648);
    Object localObject = this.gGA;
    int j;
    label35:
    int k;
    if (localObject != null)
    {
      localObject = ((as)localObject).amg();
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
      AppMethodBeat.o(190648);
      return;
    }
  }
  
  private final void anN()
  {
    AppMethodBeat.i(190655);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreAnchor", "stopLive");
    com.tencent.mm.live.core.core.a.a locala = this.gCU;
    if (locala != null)
    {
      locala.b((com.tencent.mm.live.core.core.b)new LiveAnchorPluginLayout.q());
      AppMethodBeat.o(190655);
      return;
    }
    AppMethodBeat.o(190655);
  }
  
  private final void anO()
  {
    AppMethodBeat.i(190656);
    com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(getContext()).fvx();
    Context localContext = getContext();
    d.g.b.k.g(localContext, "context");
    locala.av((CharSequence)localContext.getResources().getString(2131766582)).acQ(2131755792).b((f.c)c.gHg).b((DialogInterface.OnDismissListener)new d(this)).show();
    AppMethodBeat.o(190656);
  }
  
  private final boolean anP()
  {
    AppMethodBeat.i(190657);
    Object localObject = com.tencent.mm.live.b.g.guG;
    if (com.tencent.mm.live.b.g.akT().guP)
    {
      localObject = com.tencent.mm.live.b.c.a.gxp;
      localObject = com.tencent.mm.live.b.c.a.alJ();
      if ((((bqa)localObject).rotation != -1) && (((bqa)localObject).rotation != getCurrentOrientation()))
      {
        AppMethodBeat.o(190657);
        return true;
      }
      AppMethodBeat.o(190657);
      return false;
    }
    localObject = com.tencent.mm.live.b.g.guG;
    if (com.tencent.mm.live.b.g.akO() != -1)
    {
      localObject = com.tencent.mm.live.b.g.guG;
      if (com.tencent.mm.live.b.g.akO() != getCurrentOrientation())
      {
        AppMethodBeat.o(190657);
        return true;
      }
    }
    AppMethodBeat.o(190657);
    return false;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void a(com.tencent.mm.live.a.a parama, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(190646);
    d.g.b.k.h(parama, "router");
    d.g.b.k.h(paramLiveConfig, "config");
    this.gHa = false;
    this.gEn = new com.tencent.mm.plugin.mmsight.model.d(getContext(), (byte)0);
    this.gGR = parama;
    parama = com.tencent.mm.live.core.core.a.b.gnC;
    parama = getContext();
    d.g.b.k.g(parama, "context");
    this.gCU = ((com.tencent.mm.live.core.core.a.a)b.a.ct(parama));
    parama = this.gCU;
    if (parama != null) {
      parama.c((com.tencent.mm.live.core.core.b)this);
    }
    com.tencent.mm.live.b.i.gvw.release();
    if (paramLiveConfig.ail() != 0L)
    {
      parama = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.akF().DMV = paramLiveConfig.ail();
    }
    if (!bs.isNullOrNil(paramLiveConfig.aij()))
    {
      parama = com.tencent.mm.live.b.g.guG;
      parama = paramLiveConfig.aij();
      d.g.b.k.g(parama, "config.hostRoomId");
      com.tencent.mm.live.b.g.uO(parama);
    }
    parama = com.tencent.mm.live.b.g.guG;
    parama = paramLiveConfig.ain();
    d.g.b.k.g(parama, "config.anchorUsername");
    com.tencent.mm.live.b.g.uQ(parama);
    parama = findViewById(2131307825);
    d.g.b.k.g(parama, "findViewById(R.id.live_verify_ui_root)");
    this.gGv = new ba((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307634);
    d.g.b.k.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
    this.gGw = new com.tencent.mm.live.c.t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307594);
    d.g.b.k.g(parama, "findViewById(R.id.live_before_ui_root)");
    this.gGx = new com.tencent.mm.live.c.k((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307549);
    d.g.b.k.g(parama, "findViewById(R.id.live_after_ui_root)");
    this.gGy = new com.tencent.mm.live.c.c((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307719);
    d.g.b.k.g(parama, "findViewById(R.id.live_preview_ui_root)");
    this.gGz = new ao((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307771);
    d.g.b.k.g(parama, "findViewById(R.id.live_shadow_ui_root)");
    this.gGA = new as((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307606);
    d.g.b.k.g(parama, "findViewById(R.id.live_comment_ui_root)");
    this.gGB = new com.tencent.mm.live.c.m((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307725);
    d.g.b.k.g(parama, "findViewById(R.id.live_ready_ui_root)");
    this.gGC = new aq((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307809);
    d.g.b.k.g(parama, "findViewById(R.id.live_title_ui_root)");
    this.gGD = new ay((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307768);
    d.g.b.k.g(parama, "findViewById(R.id.live_right_panel_ui_root)");
    this.gGF = new x((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307760);
    d.g.b.k.g(parama, "findViewById(R.id.live_right_panel_btn4_parent)");
    this.gGG = new com.tencent.mm.live.c.g((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307678);
    d.g.b.k.g(parama, "findViewById(R.id.live_members_list_ui_root)");
    this.gGE = new ai((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307583);
    d.g.b.k.g(parama, "findViewById(R.id.live_ban_comment_ui_root)");
    this.gGH = new com.tencent.mm.live.c.i((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307617);
    d.g.b.k.g(parama, "findViewById(R.id.live_common_info_ui_root)");
    this.gGI = new com.tencent.mm.live.c.o((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307717);
    d.g.b.k.g(parama, "findViewById(R.id.live_minimize_ui_root)");
    this.gGJ = new com.tencent.mm.live.c.am((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307786);
    d.g.b.k.g(parama, "findViewById(R.id.live_share_rooms_ui_root)");
    this.gGK = new au((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307652);
    d.g.b.k.g(parama, "findViewById(R.id.live_loading_view_root)");
    this.gGL = new ae((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307709);
    d.g.b.k.g(parama, "findViewById(R.id.live_mic_visitor_header_root)");
    this.gGM = new ak((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307648);
    d.g.b.k.g(parama, "findViewById(R.id.live_like_confetti_ui_root)");
    this.gGN = new com.tencent.mm.live.c.ac((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307691);
    d.g.b.k.g(parama, "findViewById(R.id.live_members_profile_ui_root)");
    this.gGO = new ag((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307555);
    d.g.b.k.g(parama, "findViewById(R.id.live_anchor_close_ui_root)");
    this.gGP = new com.tencent.mm.live.c.e((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307628);
    d.g.b.k.g(parama, "findViewById(R.id.live_exception_ui_root)");
    this.gGQ = new com.tencent.mm.live.c.r((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = this.gGz;
    Object localObject;
    if (parama != null)
    {
      localObject = (d.g.a.m)new j(this);
      parama.goF.setPreviewMoveListener((d.g.a.m)localObject);
    }
    parama = com.tencent.mm.live.b.i.gvw;
    com.tencent.mm.live.b.i.a(paramLiveConfig);
    parama = this.gGF;
    if (parama != null)
    {
      d.g.b.k.h(paramLiveConfig, "config");
      localObject = parama.gBd;
      d.g.b.k.g(localObject, "shareBtn");
      ((ImageView)localObject).setVisibility(0);
      localObject = parama.gBf;
      d.g.b.k.g(localObject, "switchCameraBtn");
      ((ImageView)localObject).setVisibility(0);
      parama.gBd.setImageDrawable(com.tencent.mm.ui.am.e(parama.gnb.getResources().getDrawable(2131690478), -1));
      parama.gBf.setImageDrawable(com.tencent.mm.ui.am.e(parama.gnb.getResources().getDrawable(2131690362), -1));
      parama.gBe.setOnClickListener((View.OnClickListener)new x.b(parama));
      parama.gBg.setOnClickListener((View.OnClickListener)new x.c(parama));
      localObject = parama.gBe;
      d.g.b.k.g(localObject, "shareBtnClickArea");
      ((RelativeLayout)localObject).setVisibility(8);
      localObject = parama.gBh;
      d.g.b.k.g(localObject, "shareDescTv");
      ((TextView)localObject).setVisibility(8);
      parama = parama.gBk;
      d.g.b.k.g(parama, "shareBtnLayout");
      parama.setVisibility(8);
    }
    parama = this.gGE;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.gGy;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.gGB;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.gGN;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.gGy;
    if (parama != null) {
      parama.alQ();
    }
    parama = this.gGO;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.gGI;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.gGP;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGv;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGw;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGx;
    if (parama != null) {
      parama.nj(0);
    }
    parama = this.gGz;
    if (parama != null) {
      parama.nj(0);
    }
    parama = this.gGA;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGy;
    if (parama != null) {
      parama.nj(4);
    }
    parama = this.gGB;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGC;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGD;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGE;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGF;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGH;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGI;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGJ;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGK;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGL;
    if (parama != null)
    {
      localObject = com.tencent.mm.live.b.g.guG;
      parama.vd(com.tencent.mm.live.b.g.akH());
    }
    parama = this.gGO;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGQ;
    if (parama != null) {
      parama.nj(8);
    }
    parama = this.gGz;
    if (parama != null)
    {
      localObject = (d.g.a.m)new k(this);
      parama.goF.setPreviewTouchListener((d.g.a.m)localObject);
    }
    if (paramBoolean)
    {
      parama = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.akF().Eud = paramLiveConfig.aim();
      parama = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.akF().DMV = paramLiveConfig.ail();
      parama = com.tencent.mm.live.b.g.guG;
      parama = paramLiveConfig.aij();
      d.g.b.k.g(parama, "config.hostRoomId");
      com.tencent.mm.live.b.g.uO(parama);
      b.b.a(this, b.c.gyd);
      parama = this.gEn;
      if (parama != null) {
        parama.a(null);
      }
      parama = this.gEn;
      if (parama != null) {
        parama.disable();
      }
      this.gEn = null;
    }
    for (;;)
    {
      parama = com.tencent.mm.live.b.c.gtd;
      com.tencent.mm.live.b.c.d(name(), this.gBo);
      AppMethodBeat.o(190646);
      return;
      parama = com.tencent.mm.live.b.g.guG;
      parama = com.tencent.mm.live.b.g.akF();
      if ((parama == null) || (parama.DMV != 0L))
      {
        parama = com.tencent.mm.live.b.g.guG;
        if (!bs.isNullOrNil(com.tencent.mm.live.b.g.akA()))
        {
          localObject = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("init anchor plugin with live data, liveId:");
          parama = com.tencent.mm.live.b.g.guG;
          parama = com.tencent.mm.live.b.g.akF();
          if (parama != null)
          {
            parama = Long.valueOf(parama.DMV);
            label1759:
            com.tencent.mm.sdk.platformtools.ac.i((String)localObject, parama.longValue() + ", liveName:" + paramLiveConfig.aim() + ", roomId:" + paramLiveConfig.aij());
            paramLiveConfig = this.gGD;
            if (paramLiveConfig != null)
            {
              parama = com.tencent.mm.live.b.g.guG;
              parama = com.tencent.mm.live.b.g.akF().Eud;
              if (parama == null) {
                break label1888;
              }
              parama = (CharSequence)parama;
              label1831:
              localObject = com.tencent.mm.live.b.g.guG;
              paramLiveConfig.a(parama, com.tencent.mm.live.b.g.akH());
            }
          }
        }
      }
      for (this.gGT = b.c.gyE;; this.gGT = b.c.gxG)
      {
        if ((this.gGv == null) || (ba.amk() != true)) {
          break label1929;
        }
        a(this.gGT, new Bundle());
        break;
        parama = null;
        break label1759;
        label1888:
        parama = (CharSequence)"";
        break label1831;
        com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "init logic from directly start");
        parama = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.akF().DMV = 0L;
      }
      label1929:
      parama = this.gGv;
      if (parama != null) {
        parama.nj(0);
      }
      parama = this.gGw;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGy;
      if (parama != null) {
        parama.nj(4);
      }
      parama = this.gGB;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGF;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGD;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGA;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGH;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGL;
      if (parama != null) {
        parama.nj(8);
      }
      a(b.c.gxC, new Bundle());
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190645);
    d.g.b.k.h(paramc, "status");
    com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "statusChange:" + paramc.name());
    this.gGS = paramc;
    switch (b.fTL[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(190645);
      return;
      if (this.gGX)
      {
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(190645);
          throw paramc;
        }
        ((Activity)localObject1).setRequestedOrientation(4);
      }
      Object localObject1 = this.gGT;
      Object localObject2;
      Object localObject3;
      switch (b.cfA[localObject1.ordinal()])
      {
      default: 
        break;
      case 1: 
        localObject1 = com.tencent.mm.live.b.i.gvw;
        com.tencent.mm.live.b.i.ni(0);
        localObject1 = this.gGz;
        if (localObject1 != null) {
          ((ao)localObject1).nj(0);
        }
        localObject1 = this.gGv;
        if (localObject1 != null) {
          ((ba)localObject1).nj(8);
        }
        localObject1 = this.gGw;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.t)localObject1).nj(8);
        }
        localObject1 = this.gGx;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.k)localObject1).nj(8);
        }
        localObject1 = this.gGy;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.c)localObject1).nj(8);
        }
        localObject1 = this.gGB;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.m)localObject1).nj(8);
        }
        localObject1 = this.gGF;
        if (localObject1 != null) {
          ((x)localObject1).nj(8);
        }
        localObject1 = this.gGD;
        if (localObject1 != null) {
          ((ay)localObject1).nj(8);
        }
        localObject1 = this.gGA;
        if (localObject1 != null) {
          ((as)localObject1).nj(8);
        }
        localObject1 = this.gGH;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.i)localObject1).nj(8);
        }
        localObject2 = this.gGD;
        if (localObject2 != null)
        {
          localObject1 = com.tencent.mm.live.b.g.guG;
          localObject1 = com.tencent.mm.live.b.g.akF().Eud;
          if (localObject1 == null) {
            break label519;
          }
        }
        for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
        {
          localObject3 = com.tencent.mm.live.b.g.guG;
          ((ay)localObject2).a((CharSequence)localObject1, com.tencent.mm.live.b.g.akH());
          a(b.c.gyE, new Bundle());
          break;
        }
      case 2: 
        label519:
        a(b.c.gxG, new Bundle());
        continue;
        localObject1 = this.gEn;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).disable();
        }
        localObject1 = this.gEn;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a(null);
        }
        this.gEn = null;
        localObject1 = com.tencent.mm.live.b.c.a.gxp;
        localObject1 = com.tencent.mm.live.b.c.a.alJ();
        com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "lockOrientation liveRotation:" + ((bqa)localObject1).rotation + ", curRotation:" + getCurrentOrientation());
        boolean bool1;
        if ((((bqa)localObject1).rotation == -1) || (((bqa)localObject1).rotation == getCurrentOrientation()))
        {
          localObject1 = getContext();
          if (localObject1 == null)
          {
            paramc = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(190645);
            throw paramc;
          }
          ((Activity)localObject1).setRequestedOrientation(14);
          localObject1 = com.tencent.mm.live.core.core.trtc.a.a.aiX();
          d.g.b.k.g(localObject1, "ConfigHelper.getInstance()");
          localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).aiY();
          d.g.b.k.g(localObject1, "ConfigHelper.getInstance().videoConfig");
          localObject2 = getContext();
          d.g.b.k.g(localObject2, "context");
          localObject2 = ((Context)localObject2).getResources();
          d.g.b.k.g(localObject2, "context.resources");
          if (((Resources)localObject2).getConfiguration().orientation != 1) {
            break label1225;
          }
          bool1 = true;
          label769:
          ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject1).dF(bool1);
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("create live, isVideoVertical:");
          localObject3 = com.tencent.mm.live.core.core.trtc.a.a.aiX();
          d.g.b.k.g(localObject3, "ConfigHelper.getInstance()");
          localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).aiY();
          d.g.b.k.g(localObject3, "ConfigHelper.getInstance().videoConfig");
          com.tencent.mm.sdk.platformtools.ac.i((String)localObject1, ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).ajm());
          localObject1 = com.tencent.mm.live.b.g.guG;
          localObject3 = com.tencent.mm.live.b.g.akF();
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
          ((bqd)localObject3).Eud = ((String)localObject1);
          localObject1 = com.tencent.mm.live.b.g.guG;
          localObject1 = com.tencent.mm.live.b.g.akF().Eud;
          d.g.b.k.g(localObject1, "LiveDataManager.liveInfo.live_name");
          localObject2 = com.tencent.mm.live.b.g.guG;
          l = com.tencent.mm.live.b.g.akF().DMV;
          localObject2 = com.tencent.mm.live.b.g.guG;
          localObject2 = com.tencent.mm.live.b.g.akA();
          com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "startLive, name:" + (String)localObject1 + ", roomId:" + l);
          if ((l == 0L) || (bs.isNullOrNil((String)localObject2))) {
            break label1284;
          }
          com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "try resume live, liveId:" + l + ", liveName:" + (String)localObject1 + ", roomId:" + (String)localObject2);
          localObject3 = com.tencent.mm.live.b.g.guG;
          localObject3 = com.tencent.mm.live.b.g.akJ();
          if (localObject3 != null) {
            break label1231;
          }
          new com.tencent.mm.live.b.a(l, (String)localObject2, (String)localObject1, (byte)0).a((d.g.a.r)new s(this));
        }
        for (;;)
        {
          localObject1 = this.gCU;
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.live.core.core.a.a)localObject1).aix();
          break;
          switch (((bqa)localObject1).rotation)
          {
          default: 
            break;
          case 0: 
          case 2: 
            this.gHa = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(190645);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(1);
            break;
          case 1: 
          case 3: 
            this.gHa = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(190645);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(0);
            break;
            label1225:
            bool1 = false;
            break label769;
            label1231:
            localObject1 = this.gCU;
            if (localObject1 != null) {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.b.d)localObject3);
            }
            localObject1 = this.gCU;
            if (localObject1 != null)
            {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.b)new t(this));
              continue;
              label1284:
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreAnchor", "createNewLive, liveName:" + (String)localObject1 + ", wechatRoomId:" + (String)localObject2);
              localObject3 = getContext();
              d.g.b.k.g(localObject3, "context");
              localObject1 = new com.tencent.mm.live.b.b((String)localObject1, (String)localObject2, (Context)localObject3);
              localObject2 = (s)new b(this);
              localObject3 = com.tencent.mm.kernel.g.agQ();
              d.g.b.k.g(localObject3, "MMKernel.network()");
              ((com.tencent.mm.kernel.b)localObject3).agi().a(3501, (com.tencent.mm.ak.g)localObject1);
              localObject3 = new com.tencent.mm.live.b.a.l(((com.tencent.mm.live.b.b)localObject1).name, ((com.tencent.mm.live.b.b)localObject1).roomId);
              localObject4 = com.tencent.mm.kernel.g.agQ();
              d.g.b.k.g(localObject4, "MMKernel.network()");
              ((com.tencent.mm.kernel.b)localObject4).agi().b((n)localObject3);
              ((com.tencent.mm.live.b.b)localObject1).gsV = ((s)localObject2);
            }
            break;
          }
        }
        localObject1 = com.tencent.mm.live.b.g.guG;
        localObject1 = com.tencent.mm.live.b.g.akF().Eud;
        d.g.b.k.g(localObject1, "LiveDataManager.liveInfo.live_name");
        localObject2 = com.tencent.mm.live.b.g.guG;
        localObject2 = com.tencent.mm.live.b.g.akA();
        localObject3 = getContext();
        d.g.b.k.g(localObject3, "context");
        localObject1 = new com.tencent.mm.live.b.b((String)localObject1, (String)localObject2, (Context)localObject3);
        localObject2 = (s)new l(this);
        localObject3 = com.tencent.mm.kernel.g.agQ();
        d.g.b.k.g(localObject3, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject3).agi().a(3797, (com.tencent.mm.ak.g)localObject1);
        localObject3 = com.tencent.mm.live.b.g.guG;
        long l = com.tencent.mm.live.b.g.akF().DMV;
        localObject3 = ((com.tencent.mm.live.b.b)localObject1).roomId;
        Object localObject4 = com.tencent.mm.live.b.g.guG;
        localObject3 = new com.tencent.mm.live.b.a.o(l, (String)localObject3, com.tencent.mm.live.b.g.akE());
        localObject4 = com.tencent.mm.kernel.g.agQ();
        d.g.b.k.g(localObject4, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject4).agi().b((n)localObject3);
        ((com.tencent.mm.live.b.b)localObject1).gsW = ((s)localObject2);
        continue;
        this.gGY.axi();
        localObject1 = this.gGL;
        if (localObject1 != null) {
          ((ae)localObject1).nj(8);
        }
        localObject1 = (Runnable)new p(this);
        localObject2 = ae.gBW;
        postDelayed((Runnable)localObject1, ae.amd() + 50L);
        com.tencent.mm.live.b.i.gvw.alF();
        localObject1 = com.tencent.mm.live.b.i.gvw;
        com.tencent.mm.live.b.i.alA();
        localObject1 = com.tencent.mm.live.b.g.guG;
        if (com.tencent.mm.live.b.g.akF().EbF == 0)
        {
          localObject1 = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.akF().EbF = ce.azK();
        }
        localObject1 = com.tencent.mm.live.b.c.a.gxp;
        if (com.tencent.mm.live.b.c.a.alJ().DMV != 0L) {}
        int j;
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            localObject1 = com.tencent.mm.live.b.c.a.gxp;
            localObject1 = com.tencent.mm.live.b.g.guG;
            l = com.tencent.mm.live.b.g.akF().DMV;
            localObject1 = com.tencent.mm.live.b.g.guG;
            localObject1 = com.tencent.mm.live.b.g.akA();
            i = getCurrentOrientation();
            localObject2 = com.tencent.mm.live.b.g.guG;
            localObject2 = com.tencent.mm.live.b.g.alt();
            localObject3 = com.tencent.mm.live.b.g.guG;
            j = com.tencent.mm.live.b.g.akF().EbF;
            localObject3 = com.tencent.mm.live.b.g.guG;
            com.tencent.mm.live.b.c.a.a(l, (String)localObject1, i, (String)localObject2, j, com.tencent.mm.live.b.g.akH());
          }
          localObject1 = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.alu();
          localObject1 = com.tencent.mm.live.b.i.gvw;
          com.tencent.mm.live.b.i.ni(0);
          break;
        }
        localObject1 = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.akN();
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(190645);
          throw paramc;
        }
        ((Activity)localObject1).finishAndRemoveTask();
        continue;
        localObject1 = this.gGG;
        if ((localObject1 != null) && (((com.tencent.mm.live.c.g)localObject1).gzz.isShowing())) {
          ((com.tencent.mm.live.c.g)localObject1).gzz.dismiss();
        }
        localObject1 = this.gGL;
        if (localObject1 != null) {
          ((ae)localObject1).nj(8);
        }
        anN();
        localObject1 = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.alw();
        localObject1 = com.tencent.mm.live.b.i.gvw;
        com.tencent.mm.live.b.i.alC();
        localObject1 = com.tencent.mm.live.b.i.gvw;
        com.tencent.mm.live.b.i.alD();
        com.tencent.mm.live.b.i.gvw.release();
        localObject1 = com.tencent.mm.live.b.c.gtd;
        com.tencent.mm.live.b.c.akf();
        localObject1 = com.tencent.mm.live.b.c.a.gxp;
        localObject1 = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.c.a.pl(com.tencent.mm.live.b.g.akF().DMV);
        continue;
        localObject1 = com.tencent.mm.live.b.g.guG;
        if (!com.tencent.mm.live.b.g.akT().guO)
        {
          localObject1 = this.gGC;
          if (localObject1 != null) {
            ((aq)localObject1).nj(8);
          }
          localObject1 = this.gGz;
          if (localObject1 != null) {
            ((ao)localObject1).nj(8);
          }
          localObject1 = this.gGv;
          if (localObject1 != null) {
            ((ba)localObject1).nj(8);
          }
          localObject1 = this.gGw;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.t)localObject1).nj(8);
          }
          localObject1 = this.gGx;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.k)localObject1).nj(8);
          }
          localObject1 = this.gGL;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.live.b.g.guG;
            localObject2 = com.tencent.mm.live.b.g.akH();
            localObject3 = getContext();
            d.g.b.k.g(localObject3, "context");
            localObject3 = ((Context)localObject3).getResources().getString(2131766622);
            d.g.b.k.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
            ((ae)localObject1).as((String)localObject2, (String)localObject3);
          }
          localObject1 = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.alv();
          continue;
          localObject1 = com.tencent.mm.live.b.g.guG;
          if (!com.tencent.mm.live.b.g.akT().guO)
          {
            localObject1 = this.gGz;
            if (localObject1 != null) {
              ((ao)localObject1).nj(0);
            }
            localObject1 = com.tencent.mm.live.b.g.guG;
            com.tencent.mm.live.b.g.akT().guQ = false;
            continue;
            if (this.gGX)
            {
              localObject1 = getContext();
              if (localObject1 == null)
              {
                paramc = new v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(190645);
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
              localObject2 = com.tencent.mm.live.b.i.gvw;
              com.tencent.mm.live.b.i.uY((String)localObject1);
              continue;
              localObject1 = com.tencent.mm.live.b.g.guG;
              com.tencent.mm.live.b.g.akT().guR = true;
              continue;
              localObject1 = this.gGL;
              if (localObject1 != null) {
                ((ae)localObject1).nj(8);
              }
              localObject1 = this.gEn;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a((d.a)this);
              }
              localObject1 = this.gEn;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).enable();
              }
              localObject1 = com.tencent.mm.live.b.g.guG;
              if (com.tencent.mm.live.b.g.akU().guL)
              {
                localObject1 = this.gGw;
                if (localObject1 != null) {
                  ((com.tencent.mm.live.c.t)localObject1).nj(0);
                }
                a(b.c.gxE, new Bundle());
                localObject1 = com.tencent.mm.live.b.g.guG;
                com.tencent.mm.live.b.g.akU().guL = false;
                continue;
                localObject1 = com.tencent.mm.live.b.g.guG;
                if (com.tencent.mm.live.b.g.alb()) {}
                for (i = 4;; i = 5)
                {
                  localObject1 = com.tencent.mm.live.b.g.guG;
                  localObject1 = com.tencent.mm.live.b.g.akA();
                  localObject2 = com.tencent.mm.live.b.g.guG;
                  bool1 = com.tencent.mm.live.b.g.akY();
                  localObject2 = com.tencent.mm.live.b.g.guG;
                  bool2 = com.tencent.mm.live.b.g.akZ();
                  localObject2 = com.tencent.mm.live.b.g.guG;
                  localObject2 = com.tencent.mm.live.b.g.akF().Eud;
                  localObject3 = com.tencent.mm.live.b.g.guG;
                  bool3 = com.tencent.mm.live.b.g.akX();
                  localObject3 = getContext();
                  d.g.b.k.g(localObject3, "context");
                  localObject3 = ((Context)localObject3).getResources();
                  d.g.b.k.g(localObject3, "context.resources");
                  com.tencent.mm.live.d.e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, ((Resources)localObject3).getConfiguration().orientation, i);
                  localObject1 = getContext();
                  d.g.b.k.g(localObject1, "context");
                  localObject1 = ((Context)localObject1).getResources();
                  d.g.b.k.g(localObject1, "context.resources");
                  if (((Resources)localObject1).getConfiguration().orientation != 2) {
                    break label2623;
                  }
                  com.tencent.mm.live.d.a.amF();
                  break;
                }
                label2623:
                com.tencent.mm.live.d.a.amG();
                continue;
                localObject1 = com.tencent.mm.live.b.g.guG;
                if (!com.tencent.mm.live.b.g.akT().guO)
                {
                  localObject1 = this.gGC;
                  if (localObject1 != null) {
                    ((aq)localObject1).nj(8);
                  }
                  localObject1 = this.gGz;
                  if (localObject1 != null) {
                    ((ao)localObject1).nj(8);
                  }
                  localObject1 = this.gGv;
                  if (localObject1 != null) {
                    ((ba)localObject1).nj(8);
                  }
                  localObject1 = this.gGw;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.c.t)localObject1).nj(8);
                  }
                  localObject1 = this.gGx;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.c.k)localObject1).nj(8);
                  }
                  localObject1 = this.gGL;
                  if (localObject1 != null)
                  {
                    localObject2 = com.tencent.mm.live.b.g.guG;
                    localObject2 = com.tencent.mm.live.b.g.akH();
                    localObject3 = getContext();
                    d.g.b.k.g(localObject3, "context");
                    localObject3 = ((Context)localObject3).getResources().getString(2131766622);
                    d.g.b.k.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
                    ((ae)localObject1).as((String)localObject2, (String)localObject3);
                  }
                  localObject1 = com.tencent.mm.live.b.g.guG;
                  com.tencent.mm.live.b.g.alv();
                }
                localObject1 = com.tencent.mm.live.b.g.guG;
                localObject1 = com.tencent.mm.live.b.g.akA();
                localObject2 = com.tencent.mm.live.b.g.guG;
                bool1 = com.tencent.mm.live.b.g.akY();
                localObject2 = com.tencent.mm.live.b.g.guG;
                boolean bool2 = com.tencent.mm.live.b.g.akZ();
                localObject2 = com.tencent.mm.live.b.g.guG;
                localObject2 = com.tencent.mm.live.b.g.akF().Eud;
                localObject3 = com.tencent.mm.live.b.g.guG;
                boolean bool3 = com.tencent.mm.live.b.g.akX();
                localObject3 = getContext();
                d.g.b.k.g(localObject3, "context");
                localObject3 = ((Context)localObject3).getResources();
                d.g.b.k.g(localObject3, "context.resources");
                j = ((Resources)localObject3).getConfiguration().orientation;
                if (paramBundle != null) {}
                for (i = paramBundle.getInt("live_user_exit_reason");; i = 0)
                {
                  com.tencent.mm.live.d.e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, j, 6, i);
                  break;
                }
                localObject1 = this.gGz;
                if (localObject1 != null) {
                  ((ao)localObject1).goF.gso.aka();
                }
                localObject1 = this.gCU;
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
                  if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).aiT() == true))
                  {
                    localObject1 = this.gCU;
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
                      if (localObject1 != null)
                      {
                        ((com.tencent.mm.live.core.core.b.e)localObject1).gob = e.b.gom;
                        continue;
                        localObject1 = this.gCU;
                        if (localObject1 != null)
                        {
                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.live.core.core.b.e)localObject1).goc = e.d.got;
                            continue;
                            localObject1 = this.gCU;
                            if (localObject1 != null)
                            {
                              localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
                              if (localObject1 != null)
                              {
                                ((com.tencent.mm.live.core.core.b.e)localObject1).goc = e.d.gov;
                                continue;
                                localObject1 = this.gCU;
                                if (localObject1 != null)
                                {
                                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
                                  if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.e)localObject1).isFloatMode()))
                                  {
                                    localObject1 = this.gCU;
                                    if (localObject1 != null)
                                    {
                                      localObject2 = getContext();
                                      d.g.b.k.g(localObject2, "context");
                                      ((com.tencent.mm.live.core.core.a.a)localObject1).cs((Context)localObject2);
                                    }
                                    localObject1 = com.tencent.mm.live.b.g.guG;
                                    localObject1 = com.tencent.mm.live.b.g.akA();
                                    localObject2 = com.tencent.mm.live.b.g.guG;
                                    l = com.tencent.mm.live.b.g.akF().DMV;
                                    localObject2 = com.tencent.mm.live.b.g.guG;
                                    com.tencent.mm.live.d.e.a((String)localObject1, l, com.tencent.mm.live.b.g.akH(), 2, 1);
                                    com.tencent.mm.live.d.a.amD();
                                    continue;
                                    localObject1 = com.tencent.mm.live.b.g.guG;
                                    localObject1 = com.tencent.mm.live.b.g.akA();
                                    localObject2 = com.tencent.mm.live.b.g.guG;
                                    l = com.tencent.mm.live.b.g.akF().DMV;
                                    localObject2 = com.tencent.mm.live.b.g.guG;
                                    com.tencent.mm.live.d.e.a((String)localObject1, l, com.tencent.mm.live.b.g.akH(), 2, 0);
                                    com.tencent.mm.live.d.a.amE();
                                    continue;
                                    localObject1 = this.gCU;
                                    if (localObject1 != null)
                                    {
                                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
                                      if (localObject1 != null)
                                      {
                                        ((com.tencent.mm.live.core.core.b.e)localObject1).gob = e.b.gol;
                                        continue;
                                        localObject1 = this.gCU;
                                        if (localObject1 != null)
                                        {
                                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
                                          if (localObject1 != null) {
                                            ((com.tencent.mm.live.core.core.b.e)localObject1).gob = e.b.gok;
                                          }
                                        }
                                        localObject1 = this.gGM;
                                        if (localObject1 != null)
                                        {
                                          this.gGV.remove(localObject1);
                                          continue;
                                          localObject1 = com.tencent.mm.live.core.core.trtc.a.a.aiX();
                                          d.g.b.k.g(localObject1, "ConfigHelper.getInstance()");
                                          localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).aiY();
                                          d.g.b.k.g(localObject1, "ConfigHelper.getInstance().videoConfig");
                                          localObject2 = com.tencent.mm.live.b.g.guG;
                                          if (!com.tencent.mm.live.b.g.akW().aly())
                                          {
                                            bool1 = true;
                                            label3398:
                                            ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject1).dG(bool1);
                                            localObject1 = this.gCU;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.core.core.a.a)localObject1).w(0.0F, 0.0F);
                                            }
                                            localObject1 = this.gGz;
                                            if (localObject1 == null) {
                                              continue;
                                            }
                                            localObject2 = com.tencent.mm.live.b.g.guG;
                                            if (!com.tencent.mm.live.b.g.akW().aly()) {
                                              break label3508;
                                            }
                                          }
                                          label3508:
                                          for (i = 2;; i = 1)
                                          {
                                            localObject2 = com.tencent.mm.live.b.g.guG;
                                            localObject2 = com.tencent.mm.live.b.g.akW().userId;
                                            localObject3 = com.tencent.mm.live.b.g.guG;
                                            j = com.tencent.mm.live.b.g.akW().streamType;
                                            d.g.b.k.h(localObject2, "userId");
                                            ((ao)localObject1).goF.c(i, (String)localObject2, j);
                                            break;
                                            bool1 = false;
                                            break label3398;
                                          }
                                          localObject1 = com.tencent.mm.live.b.g.guG;
                                          if (!com.tencent.mm.live.b.g.akT().guO)
                                          {
                                            localObject1 = this.gGC;
                                            if (localObject1 != null) {
                                              ((aq)localObject1).nj(8);
                                            }
                                            localObject1 = this.gGz;
                                            if (localObject1 != null) {
                                              ((ao)localObject1).nj(8);
                                            }
                                            localObject1 = this.gGv;
                                            if (localObject1 != null) {
                                              ((ba)localObject1).nj(8);
                                            }
                                            localObject1 = this.gGw;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.t)localObject1).nj(8);
                                            }
                                            localObject1 = this.gGx;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.k)localObject1).nj(8);
                                            }
                                            localObject1 = this.gGL;
                                            if (localObject1 != null) {
                                              ((ae)localObject1).nj(8);
                                            }
                                            localObject1 = this.gGQ;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.r)localObject1).nj(0);
                                            }
                                            localObject1 = com.tencent.mm.live.b.g.guG;
                                            com.tencent.mm.live.b.g.alv();
                                            localObject1 = getContext();
                                            if (localObject1 == null)
                                            {
                                              paramc = new v("null cannot be cast to non-null type android.app.Activity");
                                              AppMethodBeat.o(190645);
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
  
  public final void alM()
  {
    AppMethodBeat.i(190650);
    super.alM();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().a(3806, (com.tencent.mm.ak.g)this);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().a(3559, (com.tencent.mm.ak.g)this);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().a(3557, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190650);
  }
  
  public final void alN()
  {
    AppMethodBeat.i(190651);
    super.alN();
    Object localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).agi().b(3806, (com.tencent.mm.ak.g)this);
    localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).agi().b(3559, (com.tencent.mm.ak.g)this);
    localObject = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).agi().b(3557, (com.tencent.mm.ak.g)this);
    if ((!anP()) && (!this.gHa))
    {
      localObject = this.gCU;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).ait();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).aiT() == true)) {}
      }
      else
      {
        localObject = this.gCU;
        if (localObject == null) {
          break label191;
        }
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).ait();
        if ((localObject == null) || (((com.tencent.mm.live.core.core.b.e)localObject).aiS() != true)) {
          break label191;
        }
      }
      localObject = this.gGG;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.c.g)localObject).gzy.getSelectUser();
        if (localObject != null)
        {
          com.tencent.mm.live.b.i locali = com.tencent.mm.live.b.i.gvw;
          com.tencent.mm.live.b.i.ar(((a.a)localObject).gxh, ((a.a)localObject).gxj);
        }
      }
      label191:
      localObject = com.tencent.mm.live.b.i.gvw;
      com.tencent.mm.live.b.i.ni(1);
      anN();
      com.tencent.mm.live.b.i.gvw.release();
      localObject = com.tencent.mm.live.b.c.gtd;
      com.tencent.mm.live.b.c.akf();
      localObject = this.gCU;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.a)localObject).aiv();
      }
      localObject = com.tencent.mm.live.core.core.a.b.gnC;
      b.a.releaseInstance();
      localObject = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.WN();
      this.gGY.YC();
    }
    AppMethodBeat.o(190651);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(190653);
    boolean bool2 = super.alO();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
      bool1 = bool2;
      if (!com.tencent.mm.live.b.g.akT().guQ)
      {
        localg = com.tencent.mm.live.b.g.guG;
        bool1 = bool2;
        if (com.tencent.mm.live.b.g.akT().guP)
        {
          b.b.a(this, b.c.gxK);
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(190653);
    return bool1;
  }
  
  public final void dU(boolean paramBoolean)
  {
    this.gGX = paramBoolean;
  }
  
  public final void f(int paramInt, Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 1;
    int i = 0;
    AppMethodBeat.i(190661);
    Object localObject4 = c.b.gnu;
    if (paramInt == c.b.aiA())
    {
      b.b.a(this, b.c.gyg);
      paramBundle = this.gGG;
      if (paramBundle != null)
      {
        paramBundle.alT();
        AppMethodBeat.o(190661);
        return;
      }
      AppMethodBeat.o(190661);
      return;
    }
    localObject4 = c.b.gnu;
    if (paramInt == c.b.aiF())
    {
      paramBundle = this.gCU;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.ait();
        if (paramBundle != null)
        {
          if (paramBundle.aiS() != true) {
            break label1332;
          }
          paramBundle = this.gCU;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.ait();
            if (paramBundle != null) {
              paramBundle.gob = e.b.gol;
            }
          }
          paramBundle = this.gGG;
          if (paramBundle == null) {
            break label160;
          }
          paramBundle.alS();
          AppMethodBeat.o(190661);
          return;
        }
      }
      AppMethodBeat.o(190661);
      return;
      label160:
      AppMethodBeat.o(190661);
    }
    else
    {
      localObject4 = c.b.gnu;
      if (paramInt == c.b.aiB())
      {
        if (paramBundle != null)
        {
          localObject2 = paramBundle.getString("live_user_id");
          paramBundle.getString("live_user_exit_reason");
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
          paramBundle = com.tencent.mm.live.b.g.guG;
          paramBundle = com.tencent.mm.live.b.g.alq().gxe;
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.gxj;; paramBundle = null)
          {
            com.tencent.mm.sdk.platformtools.ac.i((String)localObject3, paramBundle);
            paramBundle = com.tencent.mm.live.b.g.guG;
            localObject3 = com.tencent.mm.live.b.g.alq().gxe;
            paramBundle = (Bundle)localObject1;
            if (localObject3 != null) {
              paramBundle = ((a.a)localObject3).gxj;
            }
            if (!d.g.b.k.g(localObject2, paramBundle)) {
              break;
            }
            paramBundle = this.gCU;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.cc.a.aw(getContext(), 2131766706);
              d.g.b.k.g(localObject1, "ResourceHelper.getString…ring.live_room_mini_live)");
              paramBundle.uv((String)localObject1);
            }
            b.b.a(this, b.c.gxT);
            paramBundle = com.tencent.mm.live.b.g.guG;
            paramBundle = com.tencent.mm.live.b.g.alq().gxe;
            if (paramBundle == null) {
              break;
            }
            localObject1 = com.tencent.mm.live.b.g.guG;
            com.tencent.mm.live.b.g.alq().a(paramBundle.gmP, paramBundle.gxi, paramBundle.gxh);
            AppMethodBeat.o(190661);
            return;
          }
          AppMethodBeat.o(190661);
          return;
        }
        AppMethodBeat.o(190661);
        return;
      }
      localObject1 = c.b.gnu;
      if (paramInt == c.b.aiC())
      {
        if (paramBundle != null)
        {
          localObject1 = paramBundle.getString("live_user_id");
          boolean bool = paramBundle.getBoolean("live_media_enable");
          paramBundle = com.tencent.mm.live.b.g.guG;
          localObject2 = com.tencent.mm.live.b.g.alq().gxe;
          paramBundle = (Bundle)localObject3;
          if (localObject2 != null) {
            paramBundle = ((a.a)localObject2).gxj;
          }
          if (d.g.b.k.g(localObject1, paramBundle))
          {
            if (bool)
            {
              paramBundle = this.gCU;
              if (paramBundle != null)
              {
                localObject1 = com.tencent.mm.cc.a.aw(getContext(), 2131766707);
                d.g.b.k.g(localObject1, "ResourceHelper.getString…tring.live_room_mini_mic)");
                paramBundle.uv((String)localObject1);
              }
              b.b.a(this, b.c.gxQ);
              AppMethodBeat.o(190661);
              return;
            }
            paramBundle = this.gCU;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.cc.a.aw(getContext(), 2131766706);
              d.g.b.k.g(localObject1, "ResourceHelper.getString…ring.live_room_mini_live)");
              paramBundle.uv((String)localObject1);
            }
            paramBundle = this.gGG;
            if (paramBundle != null)
            {
              LiveAnchorMicUserListView.a(paramBundle.gzy);
              AppMethodBeat.o(190661);
              return;
            }
          }
          AppMethodBeat.o(190661);
          return;
        }
        AppMethodBeat.o(190661);
        return;
      }
      localObject1 = c.b.gnu;
      if (paramInt == c.b.aiD())
      {
        i = this.gGU;
        paramBundle = this.gCU;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.ait();
          if (paramBundle != null)
          {
            paramInt = paramBundle.goi;
            this.gGU = paramInt;
            paramBundle = c.c.gnz;
            if (i == c.c.aiL()) {
              break label730;
            }
            paramInt = this.gGU;
            paramBundle = c.c.gnz;
            if (paramInt != c.c.aiL()) {
              break label730;
            }
            b.b.a(this, b.c.gyv);
            if (this.gGz != null) {}
          }
        }
        for (;;)
        {
          paramInt = this.gGU;
          paramBundle = c.c.gnz;
          if (paramInt != c.c.aiI()) {
            break label787;
          }
          com.tencent.mm.live.core.c.a.ajN();
          AppMethodBeat.o(190661);
          return;
          paramBundle = c.c.gnz;
          paramInt = c.c.aiJ();
          break;
          label730:
          paramBundle = c.c.gnz;
          if (i == c.c.aiL())
          {
            paramInt = this.gGU;
            paramBundle = c.c.gnz;
            if (paramInt != c.c.aiL())
            {
              b.b.a(this, b.c.gyw);
              paramBundle = this.gGz;
              if (paramBundle != null) {
                paramBundle.resume();
              }
              paramBundle = com.tencent.mm.live.b.i.gvw;
              com.tencent.mm.live.b.i.alD();
            }
          }
        }
        label787:
        paramBundle = c.c.gnz;
        if (paramInt == c.c.aiJ())
        {
          com.tencent.mm.live.core.c.a.ajO();
          AppMethodBeat.o(190661);
          return;
        }
        paramBundle = c.c.gnz;
        if (paramInt == c.c.aiK())
        {
          com.tencent.mm.live.core.c.a.ajP();
          AppMethodBeat.o(190661);
          return;
        }
        paramBundle = c.c.gnz;
        if (paramInt == c.c.aiL()) {
          com.tencent.mm.live.core.c.a.ajQ();
        }
        AppMethodBeat.o(190661);
        return;
      }
      localObject1 = c.b.gnu;
      long l;
      if (paramInt == c.b.aiE())
      {
        paramBundle = this.gCU;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.ait();
          if ((paramBundle != null) && (paramBundle.aiT() == true)) {
            i = j;
          }
        }
        for (;;)
        {
          paramBundle = com.tencent.mm.live.b.g.guG;
          localObject2 = com.tencent.mm.live.b.g.akA();
          paramBundle = com.tencent.mm.live.b.g.guG;
          l = com.tencent.mm.live.b.g.akF().DMV;
          paramBundle = com.tencent.mm.live.b.g.guG;
          paramBundle = com.tencent.mm.live.b.g.alq().gxe;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.gxh;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          localObject1 = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.b.g.akH(), i, 0, paramInt);
          AppMethodBeat.o(190661);
          return;
          paramBundle = this.gCU;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.ait();
            if ((paramBundle != null) && (paramBundle.aiS() == true))
            {
              i = 2;
              continue;
            }
          }
          i = 0;
        }
      }
      localObject1 = c.b.gnu;
      if (paramInt == c.b.aiG())
      {
        paramBundle = com.tencent.mm.live.b.g.guG;
        l = com.tencent.mm.live.b.g.akF().DMV;
        paramBundle = com.tencent.mm.live.b.g.guG;
        paramBundle = com.tencent.mm.live.b.g.akA();
        localObject1 = com.tencent.mm.live.b.g.guG;
        localObject1 = com.tencent.mm.live.b.g.akF().Eud;
        d.g.b.k.g(localObject1, "LiveDataManager.liveInfo.live_name");
        new com.tencent.mm.live.b.a(l, paramBundle, (String)localObject1, (byte)0).a((d.g.a.r)new a(this));
        AppMethodBeat.o(190661);
        return;
      }
      localObject1 = c.b.gnu;
      if (paramInt == c.b.aiH())
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
        com.tencent.mm.sdk.platformtools.ac.i((String)localObject4, (String)localObject1);
        localObject1 = localObject2;
        if (paramBundle != null) {
          localObject1 = paramBundle.getString("live_user_id");
        }
        if (!bs.isNullOrNil((String)localObject1))
        {
          localObject1 = com.tencent.mm.live.b.g.guG;
          localObject3 = com.tencent.mm.live.b.g.akW();
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
          localObject1 = com.tencent.mm.live.b.g.guG;
          localObject1 = com.tencent.mm.live.b.g.akW();
          if (paramBundle == null) {
            break label1339;
          }
          paramInt = paramBundle.getInt("live_stream_type");
          ((g.c)localObject1).streamType = paramInt;
          localObject1 = com.tencent.mm.live.b.g.guG;
          localObject1 = com.tencent.mm.live.b.g.akW();
          if (paramBundle == null) {
            break label1344;
          }
        }
      }
    }
    label1332:
    label1339:
    label1344:
    for (paramInt = paramBundle.getInt("live_first_frame_width");; paramInt = 0)
    {
      ((g.c)localObject1).width = paramInt;
      localObject1 = com.tencent.mm.live.b.g.guG;
      localObject1 = com.tencent.mm.live.b.g.akW();
      paramInt = i;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("live_first_frame_height");
      }
      ((g.c)localObject1).height = paramInt;
      b.b.a(this, b.c.gyF);
      AppMethodBeat.o(190661);
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
  
  public final String name()
  {
    AppMethodBeat.i(190649);
    String str = getClass().getSimpleName();
    d.g.b.k.g(str, "this.javaClass.simpleName");
    AppMethodBeat.o(190649);
    return str;
  }
  
  public final void nm(int paramInt)
  {
    AppMethodBeat.i(190660);
    if ((this.gGZ == -1) || (this.gGZ != paramInt))
    {
      com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "onOrientationChange orientation:".concat(String.valueOf(paramInt)));
      this.gGZ = paramInt;
      com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "refreshCamera");
      com.tencent.mm.live.core.core.a.a locala = this.gCU;
      if (locala != null)
      {
        locala.air();
        AppMethodBeat.o(190660);
        return;
      }
    }
    AppMethodBeat.o(190660);
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(190647);
    d.g.b.k.h(paramString, "incomingNumber");
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.gCU;
    if (paramString != null)
    {
      paramString = paramString.ait();
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.isFloatMode());
        com.tencent.mm.sdk.platformtools.ac.i((String)localObject, paramString);
        switch (paramInt)
        {
        }
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(190647);
        return;
        paramString = null;
        break;
        AppMethodBeat.o(190647);
        return;
        paramString = com.tencent.mm.live.b.i.gvw;
        com.tencent.mm.live.b.i.ni(2);
        paramString = this.gCU;
        if (paramString != null)
        {
          paramString = paramString.ait();
          if ((paramString != null) && (paramString.isFloatMode() == true))
          {
            paramString = com.tencent.mm.live.b.g.guG;
            com.tencent.mm.live.b.g.akN();
            paramString = this.gCU;
            if (paramString != null) {
              paramString.aiq();
            }
            paramString = this.gCU;
            if (paramString != null)
            {
              paramString.aiu();
              AppMethodBeat.o(190647);
              return;
            }
            AppMethodBeat.o(190647);
            return;
          }
        }
        paramString = this.gCU;
        if (paramString != null) {
          paramString.aiq();
        }
        paramString = this.gCU;
        if (paramString != null)
        {
          paramString.aiw();
          AppMethodBeat.o(190647);
          return;
        }
        AppMethodBeat.o(190647);
        return;
        paramString = com.tencent.mm.live.b.i.gvw;
        com.tencent.mm.live.b.i.ni(0);
        paramString = this.gCU;
        if (paramString == null) {
          break label346;
        }
        paramString = paramString.ait();
        if (paramString == null) {
          break label346;
        }
        localObject = com.tencent.mm.live.b.g.guG;
      } while (paramString.b(Long.valueOf(com.tencent.mm.live.b.g.akF().DMV)) != true);
      paramString = this.gGz;
      if (paramString != null) {
        paramString.startPreview();
      }
      paramString = this.gCU;
    } while (paramString == null);
    paramString.aix();
    AppMethodBeat.o(190647);
    return;
    label346:
    AppMethodBeat.o(190647);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(190654);
    com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = com.tencent.mm.live.b.g.guG;
        if (!com.tencent.mm.live.b.g.akT().guO)
        {
          paramString = com.tencent.mm.live.b.g.guG;
          if (!com.tencent.mm.live.b.g.akT().guQ) {}
        }
        else
        {
          AppMethodBeat.o(190654);
          return;
        }
        paramString = this.gGH;
        if (paramString != null)
        {
          paramn = com.tencent.mm.live.b.g.guG;
          paramString.gzH = com.tencent.mm.live.b.g.akF().DVV;
        }
        paramString = this.gGH;
        if (paramString != null) {
          paramString.alU();
        }
        paramString = com.tencent.mm.live.b.g.guG;
        paramString = com.tencent.mm.live.b.g.guG;
        paramInt1 = i;
        if (!com.tencent.mm.live.b.g.akF().DVV) {
          paramInt1 = ce.azK();
        }
        com.tencent.mm.live.b.g.mU(paramInt1);
        paramString = com.tencent.mm.live.b.g.guG;
        if (com.tencent.mm.live.b.g.akF().nUv > 0) {
          b.b.a(this, b.c.gyd);
        }
        AppMethodBeat.o(190654);
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.live.b.a.p))
      {
        paramString = this.gGE;
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
          paramn = paramString.gCA;
          if (paramn != null) {
            paramn.dismiss();
          }
          if (i != 0)
          {
            paramn = paramString.gnb.getContext();
            paramString = paramString.gnb.getContext();
            d.g.b.k.g(paramString, "root.context");
            com.tencent.mm.ui.base.t.ch(paramn, paramString.getResources().getString(2131766628));
            AppMethodBeat.o(190654);
            return;
          }
          paramn = paramString.gnb.getContext();
          paramString = paramString.gnb.getContext();
          d.g.b.k.g(paramString, "root.context");
          com.tencent.mm.ui.base.t.ci(paramn, paramString.getResources().getString(2131766627));
          AppMethodBeat.o(190654);
          return;
        }
        AppMethodBeat.o(190654);
        return;
      }
      if (((paramn instanceof u)) && ((paramInt1 != 0) || (paramInt2 != 0)))
      {
        paramInt1 = this.gHb;
        paramString = f.gtk;
        if (paramInt1 < f.akj())
        {
          this.gHb += 1;
          com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "will retry share live, delay:" + this.gHb * 1000L);
          postDelayed((Runnable)n.gHl, this.gHb * 1000L);
        }
      }
    }
    AppMethodBeat.o(190654);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(190659);
    super.pause();
    boolean bool = anP();
    com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "pause orientationChanged:" + bool + ", currentOrientation:" + getCurrentOrientation());
    Object localObject;
    if (!bool)
    {
      localObject = com.tencent.mm.live.b.g.guG;
      if (!com.tencent.mm.live.b.g.akT().guQ)
      {
        localObject = com.tencent.mm.live.b.g.guG;
        if (!com.tencent.mm.live.b.g.akT().guO)
        {
          localObject = com.tencent.mm.live.b.g.guG;
          if (!com.tencent.mm.live.b.g.akT().guR)
          {
            localObject = com.tencent.mm.live.b.g.guG;
            if (com.tencent.mm.live.b.g.akT().guP)
            {
              localObject = com.tencent.mm.live.b.g.guG;
              if ((!com.tencent.mm.live.b.g.akM()) && (!this.gHa) && (com.tencent.mm.compatible.d.b.cc(getContext()))) {
                b.b.a(this, b.c.gxY);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = this.gEn;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
      }
      localObject = this.gEn;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).a(null);
      }
      this.gEn = null;
      AppMethodBeat.o(190659);
      return;
      localObject = this.gCU;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).ait();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).aiQ() == true) && (!this.gHa))
        {
          localObject = this.gCU;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.a)localObject).aiq();
          }
          localObject = this.gCU;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.a)localObject).aiw();
          }
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(190658);
    super.resume();
    com.tencent.mm.sdk.platformtools.ac.d(this.TAG, "resume curRotation:" + getCurrentOrientation());
    Object localObject1 = com.tencent.mm.live.b.g.guG;
    com.tencent.mm.live.b.g.akT().guR = false;
    localObject1 = com.tencent.mm.live.b.g.guG;
    Object localObject2;
    if (com.tencent.mm.live.b.g.akF().DMV != 0L)
    {
      localObject1 = com.tencent.mm.live.b.g.guG;
      if (!com.tencent.mm.live.b.g.akT().guO)
      {
        localObject1 = com.tencent.mm.kernel.g.agi();
        d.g.b.k.g(localObject1, "MMKernel.getNetSceneQueue()");
        if (((q)localObject1).agm() != null)
        {
          localObject1 = com.tencent.mm.live.b.g.guG;
          long l = com.tencent.mm.live.b.g.akF().DMV;
          localObject1 = com.tencent.mm.live.b.g.guG;
          localObject1 = new com.tencent.mm.live.b.a.b(l, com.tencent.mm.live.b.g.akA(), true);
          localObject2 = com.tencent.mm.kernel.g.agi();
          d.g.b.k.g(localObject2, "MMKernel.getNetSceneQueue()");
          ((com.tencent.mm.live.b.a.b)localObject1).doScene(((q)localObject2).agm(), (com.tencent.mm.ak.g)new o(this));
        }
        localObject1 = this.gCU;
        if (localObject1 == null) {
          break label318;
        }
        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.b.e)localObject1).gnZ)) {
          break label318;
        }
        localObject1 = this.gCU;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.a.a)localObject1).ais();
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.mV(getCurrentOrientation());
      AppMethodBeat.o(190658);
      return;
      localObject1 = this.gGz;
      if (localObject1 != null) {
        ((ao)localObject1).startPreview();
      }
      localObject1 = this.gCU;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.b.e)localObject1).aiQ() != true)) {
        break;
      }
      localObject1 = this.gCU;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.live.b.g.guG;
      if (((com.tencent.mm.live.core.core.b.e)localObject1).b(Long.valueOf(com.tencent.mm.live.b.g.akF().DMV)) != true) {
        break;
      }
      localObject1 = this.gCU;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.live.core.core.a.a)localObject1).aix();
      break;
      label318:
      localObject1 = this.gCU;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).ait();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.b.e)localObject1).gnZ = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(190652);
    super.start();
    Object localObject = com.tencent.mm.live.b.i.gvw;
    com.tencent.mm.live.b.i.alD();
    localObject = com.tencent.mm.live.b.g.guG;
    if ((com.tencent.mm.live.b.g.akF().DMV == 0L) && (this.gGX))
    {
      localObject = com.tencent.mm.live.b.g.guG;
      if (!com.tencent.mm.live.b.g.akT().guO)
      {
        localObject = com.tencent.mm.live.b.g.guG;
        if (!com.tencent.mm.live.b.g.akT().guR)
        {
          localObject = com.tencent.mm.live.b.g.guG;
          if (!com.tencent.mm.live.b.g.akT().guQ)
          {
            localObject = getContext();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(190652);
              throw ((Throwable)localObject);
            }
            ((Activity)localObject).setRequestedOrientation(4);
          }
        }
      }
    }
    AppMethodBeat.o(190652);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, y>
  {
    a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "success", "", "needFaceVerify", "verifyUrl", "", "errCode", "", "errMsg", "invoke"})
  static final class b
    extends d.g.b.l
    implements s<Boolean, Boolean, String, Integer, String, y>
  {
    b(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/view/LiveAnchorPluginLayout$createNewLive$1$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
    public static final class a
      extends com.tencent.mm.plugin.messenger.a.a
    {
      a(int paramInt) {}
      
      public final void onClickImp(View paramView)
      {
        AppMethodBeat.i(190621);
        d.g.b.k.h(paramView, "widget");
        paramView = new Intent();
        com.tencent.mm.live.b.f.a locala = f.gtk;
        paramView.putExtra("rawUrl", f.aki());
        paramView.putExtra("showShare", false);
        com.tencent.mm.br.d.e(this.gHe.gHc.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
        AppMethodBeat.o(190621);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class c
    implements f.c
  {
    public static final c gHg;
    
    static
    {
      AppMethodBeat.i(190623);
      gHg = new c();
      AppMethodBeat.o(190623);
    }
    
    public final void d(boolean paramBoolean, String paramString) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(190624);
      b.b.a(this.gHc, b.c.gxL);
      AppMethodBeat.o(190624);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class f
    implements DialogInterface.OnDismissListener
  {
    f(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(190626);
      paramDialogInterface = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.alv();
      b.b.a(this.gHc, b.c.gxL);
      AppMethodBeat.o(190626);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class h
    implements DialogInterface.OnDismissListener
  {
    h(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(190628);
      paramDialogInterface = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.alv();
      b.b.a(this.gHc, b.c.gxL);
      AppMethodBeat.o(190628);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/view/LiveAnchorPluginLayout$handleJoinLiveFail$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
  public static final class i
    extends com.tencent.mm.plugin.messenger.a.a
  {
    i(int paramInt) {}
    
    public final void onClickImp(View paramView)
    {
      AppMethodBeat.i(190629);
      d.g.b.k.h(paramView, "widget");
      paramView = new Intent();
      com.tencent.mm.live.b.f.a locala = f.gtk;
      paramView.putExtra("rawUrl", f.aki());
      paramView.putExtra("showShare", false);
      com.tencent.mm.br.d.e(this.gHc.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(190629);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "xOffset", "", "yOffset", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.m<Float, Float, y>
  {
    j(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.m<Float, Float, y>
  {
    k(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "success", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class l
    extends d.g.b.l
    implements s<Boolean, Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, y>
  {
    l(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/view/LiveAnchorPluginLayout$joinLive$1$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class a
      implements com.tencent.mm.live.core.core.b
    {
      a(LiveAnchorPluginLayout.l paraml) {}
      
      public final void f(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(190632);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish");
        if (paramInt >= 0)
        {
          b.b.a(this.gHj.gHc, b.c.gxJ);
          paramBundle = LiveAnchorPluginLayout.b(this.gHj.gHc);
          if (paramBundle != null)
          {
            String str = com.tencent.mm.cc.a.aw(this.gHj.gHc.getContext(), 2131766706);
            d.g.b.k.g(str, "ResourceHelper.getString…ring.live_room_mini_live)");
            paramBundle.uv(str);
          }
          paramBundle = com.tencent.mm.live.b.i.gvw;
          paramBundle = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.i.uX(com.tencent.mm.live.b.g.akA());
          b.b.a(this.gHj.gHc, b.c.gyz);
          AppMethodBeat.o(190632);
          return;
        }
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.LiveCoreAnchor", "enter room fail");
        com.tencent.mm.ui.base.t.makeText(this.gHj.gHc.getContext(), (CharSequence)"enter room fail", 0).show();
        b.b.a(this.gHj.gHc, b.c.gxG);
        paramBundle = new Bundle();
        paramBundle.putInt("live_user_exit_reason", paramInt);
        this.gHj.gHc.a(b.c.gyy, paramBundle);
        AppMethodBeat.o(190632);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    m(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    public static final n gHl;
    
    static
    {
      AppMethodBeat.i(190637);
      gHl = new n();
      AppMethodBeat.o(190637);
    }
    
    public final void run()
    {
      AppMethodBeat.i(190636);
      Object localObject = com.tencent.mm.live.b.i.gvw;
      localObject = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.i.uX(com.tencent.mm.live.b.g.akA());
      AppMethodBeat.o(190636);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class o
    implements com.tencent.mm.ak.g
  {
    o(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(190638);
      paramn.setHasCallbackToQueue(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
          AppMethodBeat.o(190638);
          throw paramString;
        }
        paramString = ((com.tencent.mm.live.b.a.b)paramn).akF();
        if (paramString != null)
        {
          if (paramString.nUv != 0) {
            break label209;
          }
          paramString = com.tencent.mm.live.b.g.guG;
          if (com.tencent.mm.live.b.g.akT().guO) {
            break label209;
          }
          paramString = LiveAnchorPluginLayout.d(this.gHc);
          if (paramString != null) {
            paramString.startPreview();
          }
          paramString = LiveAnchorPluginLayout.b(this.gHc);
          if (paramString != null)
          {
            paramString = paramString.ait();
            if (paramString != null)
            {
              if (paramString.aiQ() != true) {
                break label209;
              }
              paramString = LiveAnchorPluginLayout.b(this.gHc);
              if (paramString == null) {
                break label203;
              }
              paramString = paramString.ait();
              if (paramString == null) {
                break label203;
              }
              paramn = com.tencent.mm.live.b.g.guG;
              if (paramString.b(Long.valueOf(com.tencent.mm.live.b.g.akF().DMV)) != true) {
                break label209;
              }
              paramString = LiveAnchorPluginLayout.b(this.gHc);
              if (paramString == null) {
                break label209;
              }
              paramString.aix();
              AppMethodBeat.o(190638);
            }
          }
        }
        else
        {
          AppMethodBeat.o(190638);
          return;
        }
        AppMethodBeat.o(190638);
        return;
        label203:
        AppMethodBeat.o(190638);
        return;
      }
      label209:
      AppMethodBeat.o(190638);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(190639);
      ae localae = LiveAnchorPluginLayout.a(this.gHc);
      if (localae != null)
      {
        localae.gnb.setVisibility(8);
        AppMethodBeat.o(190639);
        return;
      }
      AppMethodBeat.o(190639);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class r
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    r(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "ret", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, y>
  {
    s(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/view/LiveAnchorPluginLayout$tryResumeLive$2", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class t
    implements com.tencent.mm.live.core.core.b
  {
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(190644);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreAnchor", "try resume live on enterRoom finish");
      if (paramInt >= 0)
      {
        b.b.a(this.gHc, b.c.gxJ);
        AppMethodBeat.o(190644);
        return;
      }
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.LiveCoreAnchor", "try resume live senter room fail");
      com.tencent.mm.ui.base.t.makeText(this.gHc.getContext(), (CharSequence)"enter room fail", 0).show();
      b.b.a(this.gHc, b.c.gxG);
      AppMethodBeat.o(190644);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAnchorPluginLayout
 * JD-Core Version:    0.7.0.1
 */