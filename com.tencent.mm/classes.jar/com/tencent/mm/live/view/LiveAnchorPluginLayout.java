package com.tencent.mm.live.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
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
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.u;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.live.b.g.c;
import com.tencent.mm.live.b.g.d;
import com.tencent.mm.live.c.ac;
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
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.s;
import d.v;
import d.z;
import java.util.ArrayList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/LiveAnchorPluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "", "curStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "fromForcelockOrientation", "", "lastRotationFromSensor", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveAnchorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "liveAnchorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorMicPlugin;", "liveBanCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "liveBeforePlugin", "Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "liveReadyPlugin", "Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "liveRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveShareRoomsPlugin", "Lcom/tencent/mm/live/plugin/LiveShareRoomsPlugin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "navigation", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "nextStatus", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "pluginShow", "rotationEnable", "shareLiveRetryCount", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkClickArea", "x", "", "y", "validCallback", "checkInitStatus", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "checkVerify", "createNewLive", "liveName", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleErrForeigner", "handleJoinLiveFail", "errCode", "errMsg", "initLogic", "router", "isFinished", "joinLive", "lockOrientation", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onOrientationChange", "orientation", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "orientationChanged", "pause", "refreshCamera", "resume", "start", "startLive", "liveId", "", "statusChange", "status", "stopLive", "toggleShowPlugins", "tryResumeLive", "unMount", "updatePlugin", "plugin-logic_release"})
public final class LiveAnchorPluginLayout
  extends BaseLivePluginLayout
  implements com.tencent.mm.ak.f, com.tencent.mm.live.core.core.b, d.a
{
  private final String TAG;
  private d.g.a.a<z> gXH;
  private com.tencent.mm.live.core.core.a.a gZr;
  private com.tencent.mm.plugin.mmsight.model.d haJ;
  private ba hcS;
  private com.tencent.mm.live.c.t hcT;
  private k hcU;
  private com.tencent.mm.live.c.c hcV;
  private com.tencent.mm.live.c.ao hcW;
  private as hcX;
  private com.tencent.mm.live.c.m hcY;
  private aq hcZ;
  private ay hda;
  private ai hdb;
  private x hdc;
  private com.tencent.mm.live.c.g hdd;
  private com.tencent.mm.live.c.i hde;
  private com.tencent.mm.live.c.o hdf;
  private am hdg;
  private au hdh;
  private com.tencent.mm.live.c.ae hdi;
  private ak hdj;
  private ac hdk;
  private ag hdl;
  private com.tencent.mm.live.c.e hdm;
  private com.tencent.mm.live.c.r hdn;
  private com.tencent.mm.live.a.a hdo;
  private b.c hdp;
  private b.c hdq;
  private int hdr;
  private final ArrayList<com.tencent.mm.live.c.a> hds;
  private boolean hdt;
  private boolean hdu;
  private final com.tencent.mm.model.d hdv;
  private int hdw;
  private boolean hdx;
  private int hdy;
  
  public LiveAnchorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216582);
    this.TAG = "MicroMsg.LiveAnchorPluginLayout";
    this.hdp = b.c.gTZ;
    this.hdq = b.c.gTZ;
    paramContext = c.c.gJR;
    this.hdr = c.c.alK();
    this.hds = new ArrayList();
    this.hdt = true;
    this.hdv = com.tencent.mm.model.d.aAm();
    this.hdw = -1;
    this.gXH = ((d.g.a.a)new n(this));
    AppMethodBeat.o(216582);
  }
  
  private final void a(float paramFloat1, float paramFloat2, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(216568);
    Object localObject = this.hcX;
    int j;
    label35:
    int k;
    if (localObject != null)
    {
      localObject = ((as)localObject).aph();
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
      AppMethodBeat.o(216568);
      return;
    }
  }
  
  private final void aqO()
  {
    AppMethodBeat.i(216575);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreAnchor", "stopLive");
    com.tencent.mm.live.core.core.a.a locala = this.gZr;
    if (locala != null)
    {
      locala.b((com.tencent.mm.live.core.core.b)new r());
      AppMethodBeat.o(216575);
      return;
    }
    AppMethodBeat.o(216575);
  }
  
  private final void aqP()
  {
    AppMethodBeat.i(216576);
    f.a locala = new f.a(getContext()).fQD();
    Context localContext = getContext();
    d.g.b.p.g(localContext, "context");
    locala.au((CharSequence)localContext.getResources().getString(2131766582)).afY(2131755792).b((f.c)LiveAnchorPluginLayout.c.hdD).b((DialogInterface.OnDismissListener)new d(this)).show();
    AppMethodBeat.o(216576);
  }
  
  private final boolean aqQ()
  {
    AppMethodBeat.i(216577);
    Object localObject = com.tencent.mm.live.b.g.gQZ;
    if (com.tencent.mm.live.b.g.anV().gRi)
    {
      localObject = com.tencent.mm.live.b.c.a.gTI;
      localObject = com.tencent.mm.live.b.c.a.aoL();
      if ((((bvh)localObject).rotation != -1) && (((bvh)localObject).rotation != getCurrentOrientation()))
      {
        AppMethodBeat.o(216577);
        return true;
      }
      AppMethodBeat.o(216577);
      return false;
    }
    localObject = com.tencent.mm.live.b.g.gQZ;
    if (com.tencent.mm.live.b.g.anQ() != -1)
    {
      localObject = com.tencent.mm.live.b.g.gQZ;
      if (com.tencent.mm.live.b.g.anQ() != getCurrentOrientation())
      {
        AppMethodBeat.o(216577);
        return true;
      }
    }
    AppMethodBeat.o(216577);
    return false;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void a(com.tencent.mm.live.a.a parama, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(216566);
    d.g.b.p.h(parama, "router");
    d.g.b.p.h(paramLiveConfig, "config");
    this.hdx = false;
    this.haJ = new com.tencent.mm.plugin.mmsight.model.d(getContext(), (byte)0);
    this.hdo = parama;
    parama = com.tencent.mm.live.core.core.a.b.gJU;
    parama = getContext();
    d.g.b.p.g(parama, "context");
    this.gZr = ((com.tencent.mm.live.core.core.a.a)b.a.cs(parama));
    parama = this.gZr;
    if (parama != null) {
      parama.c((com.tencent.mm.live.core.core.b)this);
    }
    com.tencent.mm.live.b.i.gRP.release();
    if (paramLiveConfig.alm() != 0L)
    {
      parama = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.anH().FKy = paramLiveConfig.alm();
    }
    if (!bu.isNullOrNil(paramLiveConfig.alk()))
    {
      parama = com.tencent.mm.live.b.g.gQZ;
      parama = paramLiveConfig.alk();
      d.g.b.p.g(parama, "config.hostRoomId");
      com.tencent.mm.live.b.g.yn(parama);
    }
    parama = com.tencent.mm.live.b.g.gQZ;
    parama = paramLiveConfig.alo();
    d.g.b.p.g(parama, "config.anchorUsername");
    com.tencent.mm.live.b.g.yp(parama);
    parama = findViewById(2131307825);
    d.g.b.p.g(parama, "findViewById(R.id.live_verify_ui_root)");
    this.hcS = new ba((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307634);
    d.g.b.p.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
    this.hcT = new com.tencent.mm.live.c.t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307594);
    d.g.b.p.g(parama, "findViewById(R.id.live_before_ui_root)");
    this.hcU = new k((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307549);
    d.g.b.p.g(parama, "findViewById(R.id.live_after_ui_root)");
    this.hcV = new com.tencent.mm.live.c.c((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307719);
    d.g.b.p.g(parama, "findViewById(R.id.live_preview_ui_root)");
    this.hcW = new com.tencent.mm.live.c.ao((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307771);
    d.g.b.p.g(parama, "findViewById(R.id.live_shadow_ui_root)");
    this.hcX = new as((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307606);
    d.g.b.p.g(parama, "findViewById(R.id.live_comment_ui_root)");
    this.hcY = new com.tencent.mm.live.c.m((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307725);
    d.g.b.p.g(parama, "findViewById(R.id.live_ready_ui_root)");
    this.hcZ = new aq((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307809);
    d.g.b.p.g(parama, "findViewById(R.id.live_title_ui_root)");
    this.hda = new ay((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307768);
    d.g.b.p.g(parama, "findViewById(R.id.live_right_panel_ui_root)");
    this.hdc = new x((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307760);
    d.g.b.p.g(parama, "findViewById(R.id.live_right_panel_btn4_parent)");
    this.hdd = new com.tencent.mm.live.c.g((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307678);
    d.g.b.p.g(parama, "findViewById(R.id.live_members_list_ui_root)");
    this.hdb = new ai((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307583);
    d.g.b.p.g(parama, "findViewById(R.id.live_ban_comment_ui_root)");
    this.hde = new com.tencent.mm.live.c.i((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307617);
    d.g.b.p.g(parama, "findViewById(R.id.live_common_info_ui_root)");
    this.hdf = new com.tencent.mm.live.c.o((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307717);
    d.g.b.p.g(parama, "findViewById(R.id.live_minimize_ui_root)");
    this.hdg = new am((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307786);
    d.g.b.p.g(parama, "findViewById(R.id.live_share_rooms_ui_root)");
    this.hdh = new au((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307652);
    d.g.b.p.g(parama, "findViewById(R.id.live_loading_view_root)");
    this.hdi = new com.tencent.mm.live.c.ae((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307709);
    d.g.b.p.g(parama, "findViewById(R.id.live_mic_visitor_header_root)");
    this.hdj = new ak((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307648);
    d.g.b.p.g(parama, "findViewById(R.id.live_like_confetti_ui_root)");
    this.hdk = new ac((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307691);
    d.g.b.p.g(parama, "findViewById(R.id.live_members_profile_ui_root)");
    this.hdl = new ag((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307555);
    d.g.b.p.g(parama, "findViewById(R.id.live_anchor_close_ui_root)");
    this.hdm = new com.tencent.mm.live.c.e((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307628);
    d.g.b.p.g(parama, "findViewById(R.id.live_exception_ui_root)");
    this.hdn = new com.tencent.mm.live.c.r((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = this.hcW;
    Object localObject;
    if (parama != null)
    {
      localObject = (d.g.a.m)new j(this);
      parama.gKW.setPreviewMoveListener((d.g.a.m)localObject);
    }
    parama = com.tencent.mm.live.b.i.gRP;
    com.tencent.mm.live.b.i.a(paramLiveConfig);
    parama = this.hdc;
    if (parama != null)
    {
      d.g.b.p.h(paramLiveConfig, "config");
      localObject = parama.gXw;
      d.g.b.p.g(localObject, "shareBtn");
      ((ImageView)localObject).setVisibility(0);
      localObject = parama.gXy;
      d.g.b.p.g(localObject, "switchCameraBtn");
      ((ImageView)localObject).setVisibility(0);
      parama.gXw.setImageDrawable(com.tencent.mm.ui.ao.e(parama.gJt.getResources().getDrawable(2131690478), -1));
      parama.gXy.setImageDrawable(com.tencent.mm.ui.ao.e(parama.gJt.getResources().getDrawable(2131690362), -1));
      parama.gXx.setOnClickListener((View.OnClickListener)new x.b(parama));
      parama.gXz.setOnClickListener((View.OnClickListener)new x.c(parama));
      localObject = parama.gXx;
      d.g.b.p.g(localObject, "shareBtnClickArea");
      ((RelativeLayout)localObject).setVisibility(8);
      localObject = parama.gXA;
      d.g.b.p.g(localObject, "shareDescTv");
      ((TextView)localObject).setVisibility(8);
      parama = parama.gXD;
      d.g.b.p.g(parama, "shareBtnLayout");
      parama.setVisibility(8);
    }
    parama = this.hdb;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.hcV;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.hcY;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.hdk;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.hcV;
    if (parama != null) {
      parama.aoR();
    }
    parama = this.hdl;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.hdf;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.hdm;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hcS;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hcT;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hcU;
    if (parama != null) {
      parama.nL(0);
    }
    parama = this.hcW;
    if (parama != null) {
      parama.nL(0);
    }
    parama = this.hcX;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hcV;
    if (parama != null) {
      parama.nL(4);
    }
    parama = this.hcY;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hcZ;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hda;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hdb;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hdc;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hde;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hdf;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hdg;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hdh;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hdi;
    if (parama != null)
    {
      localObject = com.tencent.mm.live.b.g.gQZ;
      parama.yD(com.tencent.mm.live.b.g.anJ());
    }
    parama = this.hdl;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hdn;
    if (parama != null) {
      parama.nL(8);
    }
    parama = this.hcW;
    if (parama != null)
    {
      localObject = (d.g.a.m)new k(this);
      parama.gKW.setPreviewTouchListener((d.g.a.m)localObject);
    }
    if (paramBoolean)
    {
      parama = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.anH().Gud = paramLiveConfig.aln();
      parama = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.anH().FKy = paramLiveConfig.alm();
      parama = com.tencent.mm.live.b.g.gQZ;
      parama = paramLiveConfig.alk();
      d.g.b.p.g(parama, "config.hostRoomId");
      com.tencent.mm.live.b.g.yn(parama);
      b.b.a(this, b.c.gUw);
      parama = this.haJ;
      if (parama != null) {
        parama.a(null);
      }
      parama = this.haJ;
      if (parama != null) {
        parama.disable();
      }
      this.haJ = null;
    }
    for (;;)
    {
      parama = com.tencent.mm.live.b.c.gPx;
      com.tencent.mm.live.b.c.d(name(), this.gXH);
      parama = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.aos().gTr = ((d.g.a.b)new l(this));
      AppMethodBeat.o(216566);
      return;
      parama = com.tencent.mm.live.b.g.gQZ;
      parama = com.tencent.mm.live.b.g.anH();
      if ((parama == null) || (parama.FKy != 0L))
      {
        parama = com.tencent.mm.live.b.g.gQZ;
        if (!bu.isNullOrNil(com.tencent.mm.live.b.g.anC()))
        {
          localObject = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("init anchor plugin with live data, liveId:");
          parama = com.tencent.mm.live.b.g.gQZ;
          parama = com.tencent.mm.live.b.g.anH();
          if (parama != null)
          {
            parama = Long.valueOf(parama.FKy);
            label1780:
            com.tencent.mm.sdk.platformtools.ae.i((String)localObject, parama.longValue() + ", liveName:" + paramLiveConfig.aln() + ", roomId:" + paramLiveConfig.alk());
            paramLiveConfig = this.hda;
            if (paramLiveConfig != null)
            {
              parama = com.tencent.mm.live.b.g.gQZ;
              parama = com.tencent.mm.live.b.g.anH().Gud;
              if (parama == null) {
                break label1909;
              }
              parama = (CharSequence)parama;
              label1852:
              localObject = com.tencent.mm.live.b.g.gQZ;
              paramLiveConfig.a(parama, com.tencent.mm.live.b.g.anJ());
            }
          }
        }
      }
      for (this.hdq = b.c.gUX;; this.hdq = b.c.gTZ)
      {
        if ((this.hcS == null) || (ba.apl() != true)) {
          break label1950;
        }
        a(this.hdq, new Bundle());
        break;
        parama = null;
        break label1780;
        label1909:
        parama = (CharSequence)"";
        break label1852;
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "init logic from directly start");
        parama = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.anH().FKy = 0L;
      }
      label1950:
      parama = this.hcS;
      if (parama != null) {
        parama.nL(0);
      }
      parama = this.hcT;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hcV;
      if (parama != null) {
        parama.nL(4);
      }
      parama = this.hcY;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hdc;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hda;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hcX;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hde;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hdi;
      if (parama != null) {
        parama.nL(8);
      }
      a(b.c.gTV, new Bundle());
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216565);
    d.g.b.p.h(paramc, "status");
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "statusChange:" + paramc.name());
    this.hdp = paramc;
    switch (b.gpL[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(216565);
      return;
      if (this.hdu)
      {
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(216565);
          throw paramc;
        }
        ((Activity)localObject1).setRequestedOrientation(4);
      }
      Object localObject1 = this.hdq;
      Object localObject2;
      Object localObject3;
      switch (b.cqt[localObject1.ordinal()])
      {
      default: 
        break;
      case 1: 
        localObject1 = com.tencent.mm.live.b.i.gRP;
        com.tencent.mm.live.b.i.nK(0);
        localObject1 = this.hcW;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.ao)localObject1).nL(0);
        }
        localObject1 = this.hcS;
        if (localObject1 != null) {
          ((ba)localObject1).nL(8);
        }
        localObject1 = this.hcT;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.t)localObject1).nL(8);
        }
        localObject1 = this.hcU;
        if (localObject1 != null) {
          ((k)localObject1).nL(8);
        }
        localObject1 = this.hcV;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.c)localObject1).nL(8);
        }
        localObject1 = this.hcY;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.m)localObject1).nL(8);
        }
        localObject1 = this.hdc;
        if (localObject1 != null) {
          ((x)localObject1).nL(8);
        }
        localObject1 = this.hda;
        if (localObject1 != null) {
          ((ay)localObject1).nL(8);
        }
        localObject1 = this.hcX;
        if (localObject1 != null) {
          ((as)localObject1).nL(8);
        }
        localObject1 = this.hde;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.i)localObject1).nL(8);
        }
        localObject2 = this.hda;
        if (localObject2 != null)
        {
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          localObject1 = com.tencent.mm.live.b.g.anH().Gud;
          if (localObject1 == null) {
            break label519;
          }
        }
        for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
        {
          localObject3 = com.tencent.mm.live.b.g.gQZ;
          ((ay)localObject2).a((CharSequence)localObject1, com.tencent.mm.live.b.g.anJ());
          a(b.c.gUX, new Bundle());
          break;
        }
      case 2: 
        label519:
        a(b.c.gTZ, new Bundle());
        continue;
        localObject1 = this.haJ;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).disable();
        }
        localObject1 = this.haJ;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a(null);
        }
        this.haJ = null;
        localObject1 = com.tencent.mm.live.b.c.a.gTI;
        localObject1 = com.tencent.mm.live.b.c.a.aoL();
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "lockOrientation liveRotation:" + ((bvh)localObject1).rotation + ", curRotation:" + getCurrentOrientation());
        boolean bool1;
        if ((((bvh)localObject1).rotation == -1) || (((bvh)localObject1).rotation == getCurrentOrientation()))
        {
          localObject1 = getContext();
          if (localObject1 == null)
          {
            paramc = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(216565);
            throw paramc;
          }
          ((Activity)localObject1).setRequestedOrientation(14);
          localObject1 = com.tencent.mm.live.core.core.trtc.a.a.alY();
          d.g.b.p.g(localObject1, "ConfigHelper.getInstance()");
          localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).alZ();
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
          ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject1).dI(bool1);
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("create live, isVideoVertical:");
          localObject3 = com.tencent.mm.live.core.core.trtc.a.a.alY();
          d.g.b.p.g(localObject3, "ConfigHelper.getInstance()");
          localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).alZ();
          d.g.b.p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
          com.tencent.mm.sdk.platformtools.ae.i((String)localObject1, ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).amn());
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          localObject3 = com.tencent.mm.live.b.g.anH();
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
          ((bvk)localObject3).Gud = ((String)localObject1);
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          localObject1 = com.tencent.mm.live.b.g.anH().Gud;
          d.g.b.p.g(localObject1, "LiveDataManager.liveInfo.live_name");
          localObject2 = com.tencent.mm.live.b.g.gQZ;
          l = com.tencent.mm.live.b.g.anH().FKy;
          localObject2 = com.tencent.mm.live.b.g.gQZ;
          localObject2 = com.tencent.mm.live.b.g.anC();
          com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "startLive, name:" + (String)localObject1 + ", roomId:" + l);
          if ((l == 0L) || (bu.isNullOrNil((String)localObject2))) {
            break label1284;
          }
          com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "try resume live, liveId:" + l + ", liveName:" + (String)localObject1 + ", roomId:" + (String)localObject2);
          localObject3 = com.tencent.mm.live.b.g.gQZ;
          localObject3 = com.tencent.mm.live.b.g.anL();
          if (localObject3 != null) {
            break label1231;
          }
          new com.tencent.mm.live.b.a(l, (String)localObject2, (String)localObject1, (byte)0).a((d.g.a.r)new t(this));
        }
        for (;;)
        {
          localObject1 = this.gZr;
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.live.core.core.a.a)localObject1).aly();
          break;
          switch (((bvh)localObject1).rotation)
          {
          default: 
            break;
          case 0: 
          case 2: 
            this.hdx = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(216565);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(1);
            break;
          case 1: 
          case 3: 
            this.hdx = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(216565);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(0);
            break;
            label1225:
            bool1 = false;
            break label769;
            label1231:
            localObject1 = this.gZr;
            if (localObject1 != null) {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.b.d)localObject3);
            }
            localObject1 = this.gZr;
            if (localObject1 != null)
            {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.b)new u(this));
              continue;
              label1284:
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreAnchor", "createNewLive, liveName:" + (String)localObject1 + ", wechatRoomId:" + (String)localObject2);
              localObject3 = getContext();
              d.g.b.p.g(localObject3, "context");
              localObject1 = new com.tencent.mm.live.b.b((String)localObject1, (String)localObject2, (Context)localObject3);
              localObject2 = (s)new b(this);
              localObject3 = com.tencent.mm.kernel.g.ajQ();
              d.g.b.p.g(localObject3, "MMKernel.network()");
              ((com.tencent.mm.kernel.b)localObject3).ajj().a(3501, (com.tencent.mm.ak.f)localObject1);
              localObject3 = new com.tencent.mm.live.b.a.l(((com.tencent.mm.live.b.b)localObject1).name, ((com.tencent.mm.live.b.b)localObject1).roomId);
              localObject4 = com.tencent.mm.kernel.g.ajQ();
              d.g.b.p.g(localObject4, "MMKernel.network()");
              ((com.tencent.mm.kernel.b)localObject4).ajj().b((n)localObject3);
              ((com.tencent.mm.live.b.b)localObject1).gPp = ((s)localObject2);
            }
            break;
          }
        }
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        localObject1 = com.tencent.mm.live.b.g.anH().Gud;
        d.g.b.p.g(localObject1, "LiveDataManager.liveInfo.live_name");
        localObject2 = com.tencent.mm.live.b.g.gQZ;
        localObject2 = com.tencent.mm.live.b.g.anC();
        localObject3 = getContext();
        d.g.b.p.g(localObject3, "context");
        localObject1 = new com.tencent.mm.live.b.b((String)localObject1, (String)localObject2, (Context)localObject3);
        localObject2 = (s)new m(this);
        localObject3 = com.tencent.mm.kernel.g.ajQ();
        d.g.b.p.g(localObject3, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject3).ajj().a(3797, (com.tencent.mm.ak.f)localObject1);
        localObject3 = com.tencent.mm.live.b.g.gQZ;
        long l = com.tencent.mm.live.b.g.anH().FKy;
        localObject3 = ((com.tencent.mm.live.b.b)localObject1).roomId;
        Object localObject4 = com.tencent.mm.live.b.g.gQZ;
        localObject3 = new com.tencent.mm.live.b.a.o(l, (String)localObject3, com.tencent.mm.live.b.g.anG());
        localObject4 = com.tencent.mm.kernel.g.ajQ();
        d.g.b.p.g(localObject4, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject4).ajj().b((n)localObject3);
        ((com.tencent.mm.live.b.b)localObject1).gPq = ((s)localObject2);
        continue;
        this.hdv.aAn();
        localObject1 = this.hdi;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.ae)localObject1).nL(8);
        }
        localObject1 = (Runnable)new q(this);
        localObject2 = com.tencent.mm.live.c.ae.gYp;
        postDelayed((Runnable)localObject1, com.tencent.mm.live.c.ae.ape() + 50L);
        com.tencent.mm.live.b.i.gRP.aoH();
        localObject1 = com.tencent.mm.live.b.i.gRP;
        com.tencent.mm.live.b.i.aoC();
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        if (com.tencent.mm.live.b.g.anH().FZN == 0)
        {
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.b.g.anH().FZN = ch.aDd();
        }
        localObject1 = com.tencent.mm.live.b.c.a.gTI;
        if (com.tencent.mm.live.b.c.a.aoL().FKy != 0L) {}
        int j;
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            localObject1 = com.tencent.mm.live.b.c.a.gTI;
            localObject1 = com.tencent.mm.live.b.g.gQZ;
            l = com.tencent.mm.live.b.g.anH().FKy;
            localObject1 = com.tencent.mm.live.b.g.gQZ;
            localObject1 = com.tencent.mm.live.b.g.anC();
            i = getCurrentOrientation();
            localObject2 = com.tencent.mm.live.b.g.gQZ;
            localObject2 = com.tencent.mm.live.b.g.aov();
            localObject3 = com.tencent.mm.live.b.g.gQZ;
            j = com.tencent.mm.live.b.g.anH().FZN;
            localObject3 = com.tencent.mm.live.b.g.gQZ;
            com.tencent.mm.live.b.c.a.a(l, (String)localObject1, i, (String)localObject2, j, com.tencent.mm.live.b.g.anJ());
          }
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.b.g.aow();
          localObject1 = com.tencent.mm.live.b.i.gRP;
          com.tencent.mm.live.b.i.nK(0);
          break;
        }
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.anP();
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(216565);
          throw paramc;
        }
        ((Activity)localObject1).finishAndRemoveTask();
        continue;
        localObject1 = this.hdd;
        if ((localObject1 != null) && (((com.tencent.mm.live.c.g)localObject1).gVT.isShowing())) {
          ((com.tencent.mm.live.c.g)localObject1).gVT.dismiss();
        }
        localObject1 = this.hdi;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.ae)localObject1).nL(8);
        }
        aqO();
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.aoy();
        localObject1 = com.tencent.mm.live.b.i.gRP;
        com.tencent.mm.live.b.i.aoE();
        localObject1 = com.tencent.mm.live.b.i.gRP;
        com.tencent.mm.live.b.i.aoF();
        com.tencent.mm.live.b.i.gRP.release();
        localObject1 = com.tencent.mm.live.b.c.gPx;
        com.tencent.mm.live.b.c.ang();
        localObject1 = com.tencent.mm.live.b.c.a.gTI;
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.c.a.rz(com.tencent.mm.live.b.g.anH().FKy);
        continue;
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        if (!com.tencent.mm.live.b.g.anV().gRh)
        {
          localObject1 = this.hcZ;
          if (localObject1 != null) {
            ((aq)localObject1).nL(8);
          }
          localObject1 = this.hcW;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.ao)localObject1).nL(8);
          }
          localObject1 = this.hcS;
          if (localObject1 != null) {
            ((ba)localObject1).nL(8);
          }
          localObject1 = this.hcT;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.t)localObject1).nL(8);
          }
          localObject1 = this.hcU;
          if (localObject1 != null) {
            ((k)localObject1).nL(8);
          }
          localObject1 = this.hdi;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.live.b.g.gQZ;
            localObject2 = com.tencent.mm.live.b.g.anJ();
            localObject3 = getContext();
            d.g.b.p.g(localObject3, "context");
            localObject3 = ((Context)localObject3).getResources().getString(2131766622);
            d.g.b.p.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
            ((com.tencent.mm.live.c.ae)localObject1).au((String)localObject2, (String)localObject3);
          }
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.b.g.aox();
          continue;
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          if (!com.tencent.mm.live.b.g.anV().gRh)
          {
            localObject1 = this.hcW;
            if (localObject1 != null) {
              ((com.tencent.mm.live.c.ao)localObject1).nL(0);
            }
            localObject1 = com.tencent.mm.live.b.g.gQZ;
            com.tencent.mm.live.b.g.anV().gRj = false;
            continue;
            if (this.hdu)
            {
              localObject1 = getContext();
              if (localObject1 == null)
              {
                paramc = new v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(216565);
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
              localObject2 = com.tencent.mm.live.b.i.gRP;
              com.tencent.mm.live.b.i.yx((String)localObject1);
              continue;
              localObject1 = com.tencent.mm.live.b.g.gQZ;
              com.tencent.mm.live.b.g.anV().gRk = true;
              continue;
              localObject1 = this.hdi;
              if (localObject1 != null) {
                ((com.tencent.mm.live.c.ae)localObject1).nL(8);
              }
              localObject1 = this.haJ;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a((d.a)this);
              }
              localObject1 = this.haJ;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).enable();
              }
              localObject1 = com.tencent.mm.live.b.g.gQZ;
              if (com.tencent.mm.live.b.g.anW().gRe)
              {
                localObject1 = this.hcT;
                if (localObject1 != null) {
                  ((com.tencent.mm.live.c.t)localObject1).nL(0);
                }
                a(b.c.gTX, new Bundle());
                localObject1 = com.tencent.mm.live.b.g.gQZ;
                com.tencent.mm.live.b.g.anW().gRe = false;
                continue;
                localObject1 = com.tencent.mm.live.b.g.gQZ;
                if (com.tencent.mm.live.b.g.aod()) {}
                for (i = 4;; i = 5)
                {
                  localObject1 = com.tencent.mm.live.b.g.gQZ;
                  localObject1 = com.tencent.mm.live.b.g.anC();
                  localObject2 = com.tencent.mm.live.b.g.gQZ;
                  bool1 = com.tencent.mm.live.b.g.aoa();
                  localObject2 = com.tencent.mm.live.b.g.gQZ;
                  bool2 = com.tencent.mm.live.b.g.aob();
                  localObject2 = com.tencent.mm.live.b.g.gQZ;
                  localObject2 = com.tencent.mm.live.b.g.anH().Gud;
                  localObject3 = com.tencent.mm.live.b.g.gQZ;
                  bool3 = com.tencent.mm.live.b.g.anZ();
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
                  com.tencent.mm.live.d.a.apG();
                  break;
                }
                label2623:
                com.tencent.mm.live.d.a.apH();
                continue;
                localObject1 = com.tencent.mm.live.b.g.gQZ;
                if (!com.tencent.mm.live.b.g.anV().gRh)
                {
                  localObject1 = this.hcZ;
                  if (localObject1 != null) {
                    ((aq)localObject1).nL(8);
                  }
                  localObject1 = this.hcW;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.c.ao)localObject1).nL(8);
                  }
                  localObject1 = this.hcS;
                  if (localObject1 != null) {
                    ((ba)localObject1).nL(8);
                  }
                  localObject1 = this.hcT;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.c.t)localObject1).nL(8);
                  }
                  localObject1 = this.hcU;
                  if (localObject1 != null) {
                    ((k)localObject1).nL(8);
                  }
                  localObject1 = this.hdi;
                  if (localObject1 != null)
                  {
                    localObject2 = com.tencent.mm.live.b.g.gQZ;
                    localObject2 = com.tencent.mm.live.b.g.anJ();
                    localObject3 = getContext();
                    d.g.b.p.g(localObject3, "context");
                    localObject3 = ((Context)localObject3).getResources().getString(2131766622);
                    d.g.b.p.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
                    ((com.tencent.mm.live.c.ae)localObject1).au((String)localObject2, (String)localObject3);
                  }
                  localObject1 = com.tencent.mm.live.b.g.gQZ;
                  com.tencent.mm.live.b.g.aox();
                }
                localObject1 = com.tencent.mm.live.b.g.gQZ;
                localObject1 = com.tencent.mm.live.b.g.anC();
                localObject2 = com.tencent.mm.live.b.g.gQZ;
                bool1 = com.tencent.mm.live.b.g.aoa();
                localObject2 = com.tencent.mm.live.b.g.gQZ;
                boolean bool2 = com.tencent.mm.live.b.g.aob();
                localObject2 = com.tencent.mm.live.b.g.gQZ;
                localObject2 = com.tencent.mm.live.b.g.anH().Gud;
                localObject3 = com.tencent.mm.live.b.g.gQZ;
                boolean bool3 = com.tencent.mm.live.b.g.anZ();
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
                localObject1 = this.hcW;
                if (localObject1 != null) {
                  ((com.tencent.mm.live.c.ao)localObject1).gKW.gOF.anb();
                }
                localObject1 = this.gZr;
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
                  if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).alU() == true))
                  {
                    localObject1 = this.gZr;
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
                      if (localObject1 != null)
                      {
                        ((com.tencent.mm.live.core.core.b.e)localObject1).gKt = e.b.gKE;
                        continue;
                        localObject1 = this.gZr;
                        if (localObject1 != null)
                        {
                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.live.core.core.b.e)localObject1).gKu = e.d.gKK;
                            continue;
                            localObject1 = this.gZr;
                            if (localObject1 != null)
                            {
                              localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
                              if (localObject1 != null)
                              {
                                ((com.tencent.mm.live.core.core.b.e)localObject1).gKu = e.d.gKM;
                                continue;
                                localObject1 = this.gZr;
                                if (localObject1 != null)
                                {
                                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
                                  if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.e)localObject1).isFloatMode()))
                                  {
                                    localObject1 = this.gZr;
                                    if (localObject1 != null)
                                    {
                                      localObject2 = getContext();
                                      d.g.b.p.g(localObject2, "context");
                                      ((com.tencent.mm.live.core.core.a.a)localObject1).cr((Context)localObject2);
                                    }
                                    localObject1 = com.tencent.mm.live.b.g.gQZ;
                                    localObject1 = com.tencent.mm.live.b.g.anC();
                                    localObject2 = com.tencent.mm.live.b.g.gQZ;
                                    l = com.tencent.mm.live.b.g.anH().FKy;
                                    localObject2 = com.tencent.mm.live.b.g.gQZ;
                                    localObject2 = com.tencent.mm.live.b.g.anJ();
                                    localObject3 = com.tencent.mm.live.b.g.gQZ;
                                    com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 1, com.tencent.mm.live.b.g.anH().GTv);
                                    com.tencent.mm.live.d.a.apE();
                                    continue;
                                    localObject1 = com.tencent.mm.live.b.g.gQZ;
                                    localObject1 = com.tencent.mm.live.b.g.anC();
                                    localObject2 = com.tencent.mm.live.b.g.gQZ;
                                    l = com.tencent.mm.live.b.g.anH().FKy;
                                    localObject2 = com.tencent.mm.live.b.g.gQZ;
                                    localObject2 = com.tencent.mm.live.b.g.anJ();
                                    localObject3 = com.tencent.mm.live.b.g.gQZ;
                                    com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 0, com.tencent.mm.live.b.g.anH().GTv);
                                    com.tencent.mm.live.d.a.apF();
                                    continue;
                                    localObject1 = this.gZr;
                                    if (localObject1 != null)
                                    {
                                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
                                      if (localObject1 != null)
                                      {
                                        ((com.tencent.mm.live.core.core.b.e)localObject1).gKt = e.b.gKD;
                                        continue;
                                        localObject1 = this.gZr;
                                        if (localObject1 != null)
                                        {
                                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
                                          if (localObject1 != null) {
                                            ((com.tencent.mm.live.core.core.b.e)localObject1).gKt = e.b.gKC;
                                          }
                                        }
                                        localObject1 = this.hdj;
                                        if (localObject1 != null)
                                        {
                                          this.hds.remove(localObject1);
                                          continue;
                                          localObject1 = com.tencent.mm.live.core.core.trtc.a.a.alY();
                                          d.g.b.p.g(localObject1, "ConfigHelper.getInstance()");
                                          localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).alZ();
                                          d.g.b.p.g(localObject1, "ConfigHelper.getInstance().videoConfig");
                                          localObject2 = com.tencent.mm.live.b.g.gQZ;
                                          if (!com.tencent.mm.live.b.g.anY().aoA())
                                          {
                                            bool1 = true;
                                            label3428:
                                            ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject1).dJ(bool1);
                                            localObject1 = this.gZr;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.core.core.a.a)localObject1).y(0.0F, 0.0F);
                                            }
                                            localObject1 = this.hcW;
                                            if (localObject1 == null) {
                                              continue;
                                            }
                                            localObject2 = com.tencent.mm.live.b.g.gQZ;
                                            if (!com.tencent.mm.live.b.g.anY().aoA()) {
                                              break label3538;
                                            }
                                          }
                                          label3538:
                                          for (i = 2;; i = 1)
                                          {
                                            localObject2 = com.tencent.mm.live.b.g.gQZ;
                                            localObject2 = com.tencent.mm.live.b.g.anY().userId;
                                            localObject3 = com.tencent.mm.live.b.g.gQZ;
                                            j = com.tencent.mm.live.b.g.anY().streamType;
                                            d.g.b.p.h(localObject2, "userId");
                                            ((com.tencent.mm.live.c.ao)localObject1).gKW.c(i, (String)localObject2, j);
                                            break;
                                            bool1 = false;
                                            break label3428;
                                          }
                                          localObject1 = com.tencent.mm.live.b.g.gQZ;
                                          if (!com.tencent.mm.live.b.g.anV().gRh)
                                          {
                                            localObject1 = this.hcZ;
                                            if (localObject1 != null) {
                                              ((aq)localObject1).nL(8);
                                            }
                                            localObject1 = this.hcW;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.ao)localObject1).nL(8);
                                            }
                                            localObject1 = this.hcS;
                                            if (localObject1 != null) {
                                              ((ba)localObject1).nL(8);
                                            }
                                            localObject1 = this.hcT;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.t)localObject1).nL(8);
                                            }
                                            localObject1 = this.hcU;
                                            if (localObject1 != null) {
                                              ((k)localObject1).nL(8);
                                            }
                                            localObject1 = this.hdi;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.ae)localObject1).nL(8);
                                            }
                                            localObject1 = this.hdn;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.r)localObject1).nL(0);
                                            }
                                            localObject1 = com.tencent.mm.live.b.g.gQZ;
                                            com.tencent.mm.live.b.g.aox();
                                            localObject1 = getContext();
                                            if (localObject1 == null)
                                            {
                                              paramc = new v("null cannot be cast to non-null type android.app.Activity");
                                              AppMethodBeat.o(216565);
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
  
  public final void aoO()
  {
    AppMethodBeat.i(216570);
    super.aoO();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().a(3806, (com.tencent.mm.ak.f)this);
    localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().a(3559, (com.tencent.mm.ak.f)this);
    localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().a(3557, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(216570);
  }
  
  public final void aoP()
  {
    AppMethodBeat.i(216571);
    super.aoP();
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).ajj().b(3806, (com.tencent.mm.ak.f)this);
    localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).ajj().b(3559, (com.tencent.mm.ak.f)this);
    localObject = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).ajj().b(3557, (com.tencent.mm.ak.f)this);
    if ((!aqQ()) && (!this.hdx))
    {
      localObject = this.gZr;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).alu();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).alU() == true)) {}
      }
      else
      {
        localObject = this.gZr;
        if (localObject == null) {
          break label191;
        }
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).alu();
        if ((localObject == null) || (((com.tencent.mm.live.core.core.b.e)localObject).alT() != true)) {
          break label191;
        }
      }
      localObject = this.hdd;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.c.g)localObject).gVS.getSelectUser();
        if (localObject != null)
        {
          com.tencent.mm.live.b.i locali = com.tencent.mm.live.b.i.gRP;
          com.tencent.mm.live.b.i.at(((a.a)localObject).gTA, ((a.a)localObject).gTC);
        }
      }
      label191:
      localObject = com.tencent.mm.live.b.i.gRP;
      com.tencent.mm.live.b.i.nK(1);
      aqO();
      com.tencent.mm.live.b.i.gRP.release();
      localObject = com.tencent.mm.live.b.c.gPx;
      com.tencent.mm.live.b.c.ang();
      localObject = this.gZr;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.a)localObject).alw();
      }
      localObject = com.tencent.mm.live.core.core.a.b.gJU;
      b.a.releaseInstance();
      localObject = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.Zq();
      this.hdv.abn();
    }
    AppMethodBeat.o(216571);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(216573);
    boolean bool2 = super.aoQ();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
      bool1 = bool2;
      if (!com.tencent.mm.live.b.g.anV().gRj)
      {
        localg = com.tencent.mm.live.b.g.gQZ;
        bool1 = bool2;
        if (com.tencent.mm.live.b.g.anV().gRi)
        {
          b.b.a(this, b.c.gUd);
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(216573);
    return bool1;
  }
  
  public final void dY(boolean paramBoolean)
  {
    this.hdu = paramBoolean;
  }
  
  public final void f(int paramInt, Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 1;
    int i = 0;
    AppMethodBeat.i(216581);
    Object localObject4 = c.b.gJM;
    if (paramInt == c.b.alB())
    {
      b.b.a(this, b.c.gUz);
      paramBundle = this.hdd;
      if (paramBundle != null)
      {
        paramBundle.aoU();
        AppMethodBeat.o(216581);
        return;
      }
      AppMethodBeat.o(216581);
      return;
    }
    localObject4 = c.b.gJM;
    if (paramInt == c.b.alG())
    {
      paramBundle = this.gZr;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.alu();
        if (paramBundle != null)
        {
          if (paramBundle.alT() != true) {
            break label1339;
          }
          paramBundle = this.gZr;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.alu();
            if (paramBundle != null) {
              paramBundle.gKt = e.b.gKD;
            }
          }
          paramBundle = this.hdd;
          if (paramBundle == null) {
            break label160;
          }
          paramBundle.aoT();
          AppMethodBeat.o(216581);
          return;
        }
      }
      AppMethodBeat.o(216581);
      return;
      label160:
      AppMethodBeat.o(216581);
    }
    else
    {
      localObject4 = c.b.gJM;
      if (paramInt == c.b.alC())
      {
        if (paramBundle != null)
        {
          localObject2 = paramBundle.getString("live_user_id");
          paramBundle.getString("live_user_exit_reason");
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          paramBundle = com.tencent.mm.live.b.g.aos().gTx;
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.gTC;; paramBundle = null)
          {
            com.tencent.mm.sdk.platformtools.ae.i((String)localObject3, paramBundle);
            paramBundle = com.tencent.mm.live.b.g.gQZ;
            localObject3 = com.tencent.mm.live.b.g.aos().gTx;
            paramBundle = (Bundle)localObject1;
            if (localObject3 != null) {
              paramBundle = ((a.a)localObject3).gTC;
            }
            if (!d.g.b.p.i(localObject2, paramBundle)) {
              break;
            }
            paramBundle = this.gZr;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.cb.a.az(getContext(), 2131766706);
              d.g.b.p.g(localObject1, "ResourceHelper.getString…ring.live_room_mini_live)");
              paramBundle.xU((String)localObject1);
            }
            b.b.a(this, b.c.gUm);
            paramBundle = com.tencent.mm.live.b.g.gQZ;
            paramBundle = com.tencent.mm.live.b.g.aos().gTx;
            if (paramBundle == null) {
              break;
            }
            localObject1 = com.tencent.mm.live.b.g.gQZ;
            com.tencent.mm.live.b.g.aos().a(paramBundle.gJh, paramBundle.gTB, paramBundle.gTA);
            AppMethodBeat.o(216581);
            return;
          }
          AppMethodBeat.o(216581);
          return;
        }
        AppMethodBeat.o(216581);
        return;
      }
      localObject1 = c.b.gJM;
      if (paramInt == c.b.alD())
      {
        if (paramBundle != null)
        {
          localObject1 = paramBundle.getString("live_user_id");
          boolean bool = paramBundle.getBoolean("live_media_enable");
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          localObject2 = com.tencent.mm.live.b.g.aos().gTx;
          paramBundle = (Bundle)localObject3;
          if (localObject2 != null) {
            paramBundle = ((a.a)localObject2).gTC;
          }
          if (d.g.b.p.i(localObject1, paramBundle))
          {
            if (bool)
            {
              paramBundle = this.gZr;
              if (paramBundle != null)
              {
                localObject1 = com.tencent.mm.cb.a.az(getContext(), 2131766707);
                d.g.b.p.g(localObject1, "ResourceHelper.getString…tring.live_room_mini_mic)");
                paramBundle.xU((String)localObject1);
              }
              b.b.a(this, b.c.gUj);
              AppMethodBeat.o(216581);
              return;
            }
            paramBundle = this.gZr;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.cb.a.az(getContext(), 2131766706);
              d.g.b.p.g(localObject1, "ResourceHelper.getString…ring.live_room_mini_live)");
              paramBundle.xU((String)localObject1);
            }
            paramBundle = this.hdd;
            if (paramBundle != null)
            {
              LiveAnchorMicUserListView.a(paramBundle.gVS);
              AppMethodBeat.o(216581);
              return;
            }
          }
          AppMethodBeat.o(216581);
          return;
        }
        AppMethodBeat.o(216581);
        return;
      }
      localObject1 = c.b.gJM;
      if (paramInt == c.b.alE())
      {
        i = this.hdr;
        paramBundle = this.gZr;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.alu();
          if (paramBundle != null)
          {
            paramInt = paramBundle.gKA;
            this.hdr = paramInt;
            paramBundle = c.c.gJR;
            if (i == c.c.alM()) {
              break label730;
            }
            paramInt = this.hdr;
            paramBundle = c.c.gJR;
            if (paramInt != c.c.alM()) {
              break label730;
            }
            b.b.a(this, b.c.gUO);
            if (this.hcW != null) {}
          }
        }
        for (;;)
        {
          paramInt = this.hdr;
          paramBundle = c.c.gJR;
          if (paramInt != c.c.alJ()) {
            break label787;
          }
          com.tencent.mm.live.core.c.a.amO();
          AppMethodBeat.o(216581);
          return;
          paramBundle = c.c.gJR;
          paramInt = c.c.alK();
          break;
          label730:
          paramBundle = c.c.gJR;
          if (i == c.c.alM())
          {
            paramInt = this.hdr;
            paramBundle = c.c.gJR;
            if (paramInt != c.c.alM())
            {
              b.b.a(this, b.c.gUP);
              paramBundle = this.hcW;
              if (paramBundle != null) {
                paramBundle.resume();
              }
              paramBundle = com.tencent.mm.live.b.i.gRP;
              com.tencent.mm.live.b.i.aoF();
            }
          }
        }
        label787:
        paramBundle = c.c.gJR;
        if (paramInt == c.c.alK())
        {
          com.tencent.mm.live.core.c.a.amP();
          AppMethodBeat.o(216581);
          return;
        }
        paramBundle = c.c.gJR;
        if (paramInt == c.c.alL())
        {
          com.tencent.mm.live.core.c.a.amQ();
          AppMethodBeat.o(216581);
          return;
        }
        paramBundle = c.c.gJR;
        if (paramInt == c.c.alM())
        {
          com.tencent.mm.live.core.c.a.amR();
          AppMethodBeat.o(216581);
          return;
        }
        AppMethodBeat.o(216581);
        return;
      }
      localObject1 = c.b.gJM;
      long l;
      if (paramInt == c.b.alF())
      {
        paramBundle = this.gZr;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.alu();
          if ((paramBundle != null) && (paramBundle.alU() == true)) {
            i = j;
          }
        }
        for (;;)
        {
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          localObject2 = com.tencent.mm.live.b.g.anC();
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          l = com.tencent.mm.live.b.g.anH().FKy;
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          paramBundle = com.tencent.mm.live.b.g.aos().gTx;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.gTA;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.b.g.anJ(), i, 0, paramInt);
          AppMethodBeat.o(216581);
          return;
          paramBundle = this.gZr;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.alu();
            if ((paramBundle != null) && (paramBundle.alT() == true))
            {
              i = 2;
              continue;
            }
          }
          i = 0;
        }
      }
      localObject1 = c.b.gJM;
      if (paramInt == c.b.alH())
      {
        paramBundle = com.tencent.mm.live.b.g.gQZ;
        l = com.tencent.mm.live.b.g.anH().FKy;
        paramBundle = com.tencent.mm.live.b.g.gQZ;
        paramBundle = com.tencent.mm.live.b.g.anC();
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        localObject1 = com.tencent.mm.live.b.g.anH().Gud;
        d.g.b.p.g(localObject1, "LiveDataManager.liveInfo.live_name");
        new com.tencent.mm.live.b.a(l, paramBundle, (String)localObject1, (byte)0).a((d.g.a.r)new a(this));
        AppMethodBeat.o(216581);
        return;
      }
      localObject1 = c.b.gJM;
      if (paramInt == c.b.alI())
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
        com.tencent.mm.sdk.platformtools.ae.i((String)localObject4, (String)localObject1);
        localObject1 = localObject2;
        if (paramBundle != null) {
          localObject1 = paramBundle.getString("live_user_id");
        }
        if (!bu.isNullOrNil((String)localObject1))
        {
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          localObject3 = com.tencent.mm.live.b.g.anY();
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
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          localObject1 = com.tencent.mm.live.b.g.anY();
          if (paramBundle == null) {
            break label1346;
          }
          paramInt = paramBundle.getInt("live_stream_type");
          ((g.c)localObject1).streamType = paramInt;
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          localObject1 = com.tencent.mm.live.b.g.anY();
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
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      localObject1 = com.tencent.mm.live.b.g.anY();
      paramInt = i;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("live_first_frame_height");
      }
      ((g.c)localObject1).height = paramInt;
      b.b.a(this, b.c.gUY);
      AppMethodBeat.o(216581);
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
  
  public final void nO(int paramInt)
  {
    AppMethodBeat.i(216580);
    if ((this.hdw == -1) || (this.hdw != paramInt))
    {
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "onOrientationChange orientation:".concat(String.valueOf(paramInt)));
      this.hdw = paramInt;
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "refreshCamera");
      com.tencent.mm.live.core.core.a.a locala = this.gZr;
      if (locala != null)
      {
        locala.als();
        AppMethodBeat.o(216580);
        return;
      }
    }
    AppMethodBeat.o(216580);
  }
  
  public final String name()
  {
    AppMethodBeat.i(216569);
    String str = getClass().getSimpleName();
    d.g.b.p.g(str, "this.javaClass.simpleName");
    AppMethodBeat.o(216569);
    return str;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(216567);
    d.g.b.p.h(paramString, "incomingNumber");
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.gZr;
    if (paramString != null)
    {
      paramString = paramString.alu();
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.isFloatMode());
        com.tencent.mm.sdk.platformtools.ae.i((String)localObject, paramString);
        switch (paramInt)
        {
        }
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(216567);
        return;
        paramString = null;
        break;
        AppMethodBeat.o(216567);
        return;
        paramString = com.tencent.mm.live.b.i.gRP;
        com.tencent.mm.live.b.i.nK(2);
        paramString = this.gZr;
        if (paramString != null)
        {
          paramString = paramString.alu();
          if ((paramString != null) && (paramString.isFloatMode() == true))
          {
            paramString = com.tencent.mm.live.b.g.gQZ;
            com.tencent.mm.live.b.g.anP();
            paramString = this.gZr;
            if (paramString != null) {
              paramString.alr();
            }
            paramString = this.gZr;
            if (paramString != null)
            {
              paramString.alv();
              AppMethodBeat.o(216567);
              return;
            }
            AppMethodBeat.o(216567);
            return;
          }
        }
        paramString = this.gZr;
        if (paramString != null) {
          paramString.alr();
        }
        paramString = this.gZr;
        if (paramString != null)
        {
          paramString.alx();
          AppMethodBeat.o(216567);
          return;
        }
        AppMethodBeat.o(216567);
        return;
        paramString = com.tencent.mm.live.b.i.gRP;
        com.tencent.mm.live.b.i.nK(0);
        paramString = this.gZr;
        if (paramString == null) {
          break label346;
        }
        paramString = paramString.alu();
        if (paramString == null) {
          break label346;
        }
        localObject = com.tencent.mm.live.b.g.gQZ;
      } while (paramString.b(Long.valueOf(com.tencent.mm.live.b.g.anH().FKy)) != true);
      paramString = this.hcW;
      if (paramString != null) {
        paramString.startPreview();
      }
      paramString = this.gZr;
    } while (paramString == null);
    paramString.aly();
    AppMethodBeat.o(216567);
    return;
    label346:
    AppMethodBeat.o(216567);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(216574);
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = com.tencent.mm.live.b.g.gQZ;
        if (!com.tencent.mm.live.b.g.anV().gRh)
        {
          paramString = com.tencent.mm.live.b.g.gQZ;
          if (!com.tencent.mm.live.b.g.anV().gRj) {}
        }
        else
        {
          AppMethodBeat.o(216574);
          return;
        }
        paramString = this.hde;
        if (paramString != null)
        {
          paramn = com.tencent.mm.live.b.g.gQZ;
          paramString.gWb = com.tencent.mm.live.b.g.anH().FTM;
        }
        paramString = this.hde;
        if (paramString != null) {
          paramString.aoV();
        }
        paramString = com.tencent.mm.live.b.g.gQZ;
        paramString = com.tencent.mm.live.b.g.gQZ;
        paramInt1 = i;
        if (!com.tencent.mm.live.b.g.anH().FTM) {
          paramInt1 = ch.aDd();
        }
        com.tencent.mm.live.b.g.nw(paramInt1);
        paramString = com.tencent.mm.live.b.g.gQZ;
        if (com.tencent.mm.live.b.g.anH().oEs > 0) {
          b.b.a(this, b.c.gUw);
        }
        AppMethodBeat.o(216574);
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.live.b.a.p))
      {
        paramString = this.hdb;
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
          paramn = paramString.gYX;
          if (paramn != null) {
            paramn.dismiss();
          }
          if (i != 0)
          {
            paramn = paramString.gJt.getContext();
            paramString = paramString.gJt.getContext();
            d.g.b.p.g(paramString, "root.context");
            com.tencent.mm.ui.base.t.cn(paramn, paramString.getResources().getString(2131766628));
            AppMethodBeat.o(216574);
            return;
          }
          paramn = paramString.gJt.getContext();
          paramString = paramString.gJt.getContext();
          d.g.b.p.g(paramString, "root.context");
          com.tencent.mm.ui.base.t.co(paramn, paramString.getResources().getString(2131766627));
          AppMethodBeat.o(216574);
          return;
        }
        AppMethodBeat.o(216574);
        return;
      }
      if (((paramn instanceof u)) && ((paramInt1 != 0) || (paramInt2 != 0)))
      {
        paramInt1 = this.hdy;
        paramString = com.tencent.mm.live.b.f.gPE;
        if (paramInt1 < com.tencent.mm.live.b.f.ank())
        {
          this.hdy += 1;
          com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "will retry share live, delay:" + this.hdy * 1000L);
          postDelayed((Runnable)LiveAnchorPluginLayout.o.hdJ, this.hdy * 1000L);
        }
      }
    }
    AppMethodBeat.o(216574);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(216579);
    super.pause();
    boolean bool = aqQ();
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "pause orientationChanged:" + bool + ", currentOrientation:" + getCurrentOrientation());
    Object localObject;
    if (!bool)
    {
      localObject = com.tencent.mm.live.b.g.gQZ;
      if (!com.tencent.mm.live.b.g.anV().gRj)
      {
        localObject = com.tencent.mm.live.b.g.gQZ;
        if (!com.tencent.mm.live.b.g.anV().gRh)
        {
          localObject = com.tencent.mm.live.b.g.gQZ;
          if (!com.tencent.mm.live.b.g.anV().gRk)
          {
            localObject = com.tencent.mm.live.b.g.gQZ;
            if (com.tencent.mm.live.b.g.anV().gRi)
            {
              localObject = com.tencent.mm.live.b.g.gQZ;
              if ((!com.tencent.mm.live.b.g.anO()) && (!this.hdx) && (com.tencent.mm.compatible.d.b.cc(getContext()))) {
                b.b.a(this, b.c.gUr);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = this.haJ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
      }
      localObject = this.haJ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).a(null);
      }
      this.haJ = null;
      AppMethodBeat.o(216579);
      return;
      localObject = this.gZr;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).alu();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).alR() == true) && (!this.hdx))
        {
          localObject = this.gZr;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.a)localObject).alr();
          }
          localObject = this.gZr;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.a)localObject).alx();
          }
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(216578);
    super.resume();
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "resume curRotation:" + getCurrentOrientation());
    Object localObject1 = com.tencent.mm.live.b.g.gQZ;
    com.tencent.mm.live.b.g.anV().gRk = false;
    localObject1 = com.tencent.mm.live.b.g.gQZ;
    Object localObject2;
    if (com.tencent.mm.live.b.g.anH().FKy != 0L)
    {
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      if (!com.tencent.mm.live.b.g.anV().gRh)
      {
        localObject1 = com.tencent.mm.kernel.g.ajj();
        d.g.b.p.g(localObject1, "MMKernel.getNetSceneQueue()");
        if (((com.tencent.mm.ak.q)localObject1).ajn() != null)
        {
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          long l = com.tencent.mm.live.b.g.anH().FKy;
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          localObject1 = new com.tencent.mm.live.b.a.b(l, com.tencent.mm.live.b.g.anC(), true);
          localObject2 = com.tencent.mm.kernel.g.ajj();
          d.g.b.p.g(localObject2, "MMKernel.getNetSceneQueue()");
          ((com.tencent.mm.live.b.a.b)localObject1).doScene(((com.tencent.mm.ak.q)localObject2).ajn(), (com.tencent.mm.ak.f)new p(this));
        }
        localObject1 = this.gZr;
        if (localObject1 == null) {
          break label318;
        }
        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.b.e)localObject1).gKr)) {
          break label318;
        }
        localObject1 = this.gZr;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.a.a)localObject1).alt();
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.nx(getCurrentOrientation());
      AppMethodBeat.o(216578);
      return;
      localObject1 = this.hcW;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.ao)localObject1).startPreview();
      }
      localObject1 = this.gZr;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.b.e)localObject1).alR() != true)) {
        break;
      }
      localObject1 = this.gZr;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      if (((com.tencent.mm.live.core.core.b.e)localObject1).b(Long.valueOf(com.tencent.mm.live.b.g.anH().FKy)) != true) {
        break;
      }
      localObject1 = this.gZr;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.live.core.core.a.a)localObject1).aly();
      break;
      label318:
      localObject1 = this.gZr;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).alu();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.b.e)localObject1).gKr = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(216572);
    super.start();
    Object localObject = com.tencent.mm.live.b.i.gRP;
    com.tencent.mm.live.b.i.aoF();
    localObject = com.tencent.mm.live.b.g.gQZ;
    if ((com.tencent.mm.live.b.g.anH().FKy == 0L) && (this.hdu))
    {
      localObject = com.tencent.mm.live.b.g.gQZ;
      if (!com.tencent.mm.live.b.g.anV().gRh)
      {
        localObject = com.tencent.mm.live.b.g.gQZ;
        if (!com.tencent.mm.live.b.g.anV().gRk)
        {
          localObject = com.tencent.mm.live.b.g.gQZ;
          if (!com.tencent.mm.live.b.g.anV().gRj)
          {
            localObject = getContext();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(216572);
              throw ((Throwable)localObject);
            }
            ((Activity)localObject).setRequestedOrientation(4);
          }
        }
      }
    }
    AppMethodBeat.o(216572);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, z>
  {
    a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "needFaceVerify", "verifyUrl", "", "errCode", "", "errMsg", "invoke"})
  static final class b
    extends d.g.b.q
    implements s<Boolean, Boolean, String, Integer, String, z>
  {
    b(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(216542);
      b.b.a(this.hdz, b.c.gUe);
      AppMethodBeat.o(216542);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class f
    implements DialogInterface.OnDismissListener
  {
    f(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(216544);
      paramDialogInterface = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.aox();
      b.b.a(this.hdz, b.c.gUe);
      AppMethodBeat.o(216544);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class h
    implements DialogInterface.OnDismissListener
  {
    h(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(216546);
      paramDialogInterface = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.aox();
      b.b.a(this.hdz, b.c.gUe);
      AppMethodBeat.o(216546);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "xOffset", "", "yOffset", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.m<Float, Float, z>
  {
    j(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.m<Float, Float, z>
  {
    k(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "liveID", "", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.b<Long, z>
  {
    l(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class m
    extends d.g.b.q
    implements s<Boolean, Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, z>
  {
    m(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/view/LiveAnchorPluginLayout$joinLive$1$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class a
      implements com.tencent.mm.live.core.core.b
    {
      a(LiveAnchorPluginLayout.m paramm) {}
      
      public final void f(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(216552);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish");
        if (paramInt >= 0)
        {
          b.b.a(this.hdH.hdz, b.c.gUc);
          paramBundle = LiveAnchorPluginLayout.b(this.hdH.hdz);
          if (paramBundle != null)
          {
            String str = com.tencent.mm.cb.a.az(this.hdH.hdz.getContext(), 2131766706);
            d.g.b.p.g(str, "ResourceHelper.getString…ring.live_room_mini_live)");
            paramBundle.xU(str);
          }
          paramBundle = com.tencent.mm.live.b.i.gRP;
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.b.i.yw(com.tencent.mm.live.b.g.anC());
          b.b.a(this.hdH.hdz, b.c.gUS);
          AppMethodBeat.o(216552);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LiveCoreAnchor", "enter room fail");
        com.tencent.mm.ui.base.t.makeText(this.hdH.hdz.getContext(), (CharSequence)"enter room fail", 0).show();
        b.b.a(this.hdH.hdz, b.c.gTZ);
        paramBundle = new Bundle();
        paramBundle.putInt("live_user_exit_reason", paramInt);
        this.hdH.hdz.a(b.c.gUR, paramBundle);
        AppMethodBeat.o(216552);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    n(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class p
    implements com.tencent.mm.ak.f
  {
    p(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(216558);
      paramn.setHasCallbackToQueue(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
          AppMethodBeat.o(216558);
          throw paramString;
        }
        paramString = ((com.tencent.mm.live.b.a.b)paramn).anH();
        if (paramString != null)
        {
          if (paramString.oEs != 0) {
            break label209;
          }
          paramString = com.tencent.mm.live.b.g.gQZ;
          if (com.tencent.mm.live.b.g.anV().gRh) {
            break label209;
          }
          paramString = LiveAnchorPluginLayout.f(this.hdz);
          if (paramString != null) {
            paramString.startPreview();
          }
          paramString = LiveAnchorPluginLayout.b(this.hdz);
          if (paramString != null)
          {
            paramString = paramString.alu();
            if (paramString != null)
            {
              if (paramString.alR() != true) {
                break label209;
              }
              paramString = LiveAnchorPluginLayout.b(this.hdz);
              if (paramString == null) {
                break label203;
              }
              paramString = paramString.alu();
              if (paramString == null) {
                break label203;
              }
              paramn = com.tencent.mm.live.b.g.gQZ;
              if (paramString.b(Long.valueOf(com.tencent.mm.live.b.g.anH().FKy)) != true) {
                break label209;
              }
              paramString = LiveAnchorPluginLayout.b(this.hdz);
              if (paramString == null) {
                break label209;
              }
              paramString.aly();
              AppMethodBeat.o(216558);
            }
          }
        }
        else
        {
          AppMethodBeat.o(216558);
          return;
        }
        AppMethodBeat.o(216558);
        return;
        label203:
        AppMethodBeat.o(216558);
        return;
      }
      label209:
      AppMethodBeat.o(216558);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(216559);
      com.tencent.mm.live.c.ae localae = LiveAnchorPluginLayout.a(this.hdz);
      if (localae != null)
      {
        localae.gJt.setVisibility(8);
        AppMethodBeat.o(216559);
        return;
      }
      AppMethodBeat.o(216559);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/view/LiveAnchorPluginLayout$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class r
    implements com.tencent.mm.live.core.core.b
  {
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(216560);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreAnchor", "on exitRoom finish");
      AppMethodBeat.o(216560);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class s
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    s(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ret", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class t
    extends d.g.b.q
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, z>
  {
    t(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/view/LiveAnchorPluginLayout$tryResumeLive$2", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class u
    implements com.tencent.mm.live.core.core.b
  {
    public final void f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(216564);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreAnchor", "try resume live on enterRoom finish");
      if (paramInt >= 0)
      {
        b.b.a(this.hdz, b.c.gUc);
        AppMethodBeat.o(216564);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LiveCoreAnchor", "try resume live senter room fail");
      com.tencent.mm.ui.base.t.makeText(this.hdz.getContext(), (CharSequence)"enter room fail", 0).show();
      b.b.a(this.hdz, b.c.gTZ);
      AppMethodBeat.o(216564);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAnchorPluginLayout
 * JD-Core Version:    0.7.0.1
 */