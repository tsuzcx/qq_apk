package com.tencent.mm.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.f.a;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.live.b.g.c;
import com.tencent.mm.live.b.g.d;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.c.ab;
import com.tencent.mm.live.c.ab.a;
import com.tencent.mm.live.c.ag;
import com.tencent.mm.live.c.ai;
import com.tencent.mm.live.c.ak;
import com.tencent.mm.live.c.am;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.aw;
import com.tencent.mm.live.c.ay;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.c.bc;
import com.tencent.mm.live.c.be;
import com.tencent.mm.live.c.bg;
import com.tencent.mm.live.c.bi;
import com.tencent.mm.live.c.bk;
import com.tencent.mm.live.c.o;
import com.tencent.mm.live.c.t;
import com.tencent.mm.live.c.z;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.b.e.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.model.ce;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.ao;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.k;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "anchorExceptionInTRTC", "", "audienceMode", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "liveDebugPlugin", "Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveGuestRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "liveInputPlugin", "Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "liveKickedPlugin", "Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVideoMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "liveVisitorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "liveVisitorCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "navigation", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "pluginShow", "rotationEnable", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkAnchorStatus", "checkClickArea", "x", "", "y", "validCallback", "chooseAudienceMode", "byOrientationChange", "enterRoom", "liveName", "", "roomID", "", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleEnterRoom", "handleJoinLiveErr", "errCode", "errMsg", "initLogic", "router", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "keyboardChange", "show", "height", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "requestLinkMic", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "toggleShowPlugins", "unMount", "updatePlugin", "Companion", "plugin-logic_release"})
public final class LiveVisitorPluginLayout
  extends BaseLivePluginLayout
  implements com.tencent.mm.ak.g, com.tencent.mm.live.core.core.b
{
  public static final LiveVisitorPluginLayout.a gHW;
  private final d.g.a.a<y> gBo;
  private com.tencent.mm.live.core.core.c.b gDV;
  private as gGA;
  private com.tencent.mm.live.c.m gGB;
  private ay gGD;
  private ai gGE;
  private o gGI;
  private am gGJ;
  private com.tencent.mm.live.c.ae gGL;
  private ak gGM;
  private com.tencent.mm.live.c.ac gGN;
  private ag gGO;
  private com.tencent.mm.live.c.r gGQ;
  private com.tencent.mm.live.a.a gGR;
  private final ArrayList<com.tencent.mm.live.c.a> gGV;
  private boolean gGW;
  private boolean gGX;
  private final com.tencent.mm.model.d gGY;
  private t gGw;
  private com.tencent.mm.live.c.c gGy;
  private bk gHM;
  private aw gHN;
  private com.tencent.mm.live.c.v gHO;
  private z gHP;
  private bg gHQ;
  private com.tencent.mm.live.c.q gHR;
  private bc gHS;
  private ab gHT;
  private be gHU;
  private boolean gHV;
  private int gnP;
  
  static
  {
    AppMethodBeat.i(190750);
    gHW = new LiveVisitorPluginLayout.a((byte)0);
    AppMethodBeat.o(190750);
  }
  
  public LiveVisitorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(190749);
    this.gGW = true;
    paramContext = c.a.gnl;
    this.gnP = c.a.aiy();
    this.gGV = new ArrayList();
    this.gGY = com.tencent.mm.model.d.axh();
    this.gBo = ((d.g.a.a)new o(this));
    AppMethodBeat.o(190749);
  }
  
  private final void a(float paramFloat1, float paramFloat2, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(190739);
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
      AppMethodBeat.o(190739);
      return;
    }
  }
  
  private final void anS()
  {
    AppMethodBeat.i(190735);
    Object localObject = com.tencent.mm.live.core.core.c.b.gqt;
    localObject = getContext();
    k.g(localObject, "context");
    com.tencent.mm.live.core.core.c.b.a.cu((Context)localObject).ajr();
    localObject = com.tencent.mm.live.core.core.c.b.gqt;
    localObject = getContext();
    k.g(localObject, "context");
    localObject = com.tencent.mm.live.core.core.c.b.a.cu((Context)localObject);
    String str = com.tencent.mm.cc.a.aw(getContext(), 2131766707);
    k.g(str, "ResourceHelper.getString…tring.live_room_mini_mic)");
    ((com.tencent.mm.live.core.core.c.b)localObject).uv(str);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:0");
    AppMethodBeat.o(190735);
  }
  
  private final void c(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(190736);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreVisitor", "join, name:" + paramString1 + ", roomID:" + paramLong);
    com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
    new com.tencent.mm.live.b.a(com.tencent.mm.live.b.g.akF().DMV, paramString2, paramString1, (byte)0).a((d.g.a.r)new e(this));
    AppMethodBeat.o(190736);
  }
  
  private final void dV(final boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(190733);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreVisitor", "audienceMode:" + this.gnP);
    int i = this.gnP;
    Object localObject1 = c.a.gnl;
    if (i == c.a.aiy())
    {
      com.tencent.mm.live.d.f.anz();
      localObject1 = this.gHM;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.b.g.guG;
        localObject2 = com.tencent.mm.live.b.g.akJ();
        if (localObject2 == null) {
          k.fOy();
        }
        ((bk)localObject1).a((com.tencent.mm.live.core.core.b.d)localObject2, (d.g.a.b)new c(this, paramBoolean));
      }
      localObject1 = this.gHM;
      if (localObject1 != null)
      {
        ((bk)localObject1).nj(0);
        AppMethodBeat.o(190733);
        return;
      }
      AppMethodBeat.o(190733);
      return;
    }
    localObject1 = c.a.gnl;
    if (i == c.a.aiz())
    {
      com.tencent.mm.live.d.f.any();
      localObject1 = this.gDV;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.live.b.g.guG;
        localObject3 = com.tencent.mm.live.b.g.akJ();
        if (localObject3 == null) {
          k.fOy();
        }
        ((com.tencent.mm.live.core.core.c.b)localObject1).a((com.tencent.mm.live.core.core.b.d)localObject3);
      }
      Object localObject3 = this.gHN;
      long l;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.live.b.g.guG;
        localObject1 = com.tencent.mm.live.b.g.akJ();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gnU;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.live.core.core.b.c)localObject1).gnO;
            aw.a((aw)localObject3, (String)localObject1, (d.g.a.b)new d(this, paramBoolean));
          }
        }
      }
      else
      {
        localObject1 = this.gHN;
        if (localObject1 != null) {
          ((aw)localObject1).nj(0);
        }
        localObject3 = this.gDV;
        if (localObject3 == null) {
          break label355;
        }
        localObject1 = com.tencent.mm.live.b.g.guG;
        l = com.tencent.mm.live.b.g.akF().DMV;
        localObject1 = this.gHN;
        if (localObject1 == null) {
          break label349;
        }
      }
      label349:
      for (localObject1 = ((aw)localObject1).gte;; localObject1 = null)
      {
        aw localaw = this.gHN;
        if (localaw != null) {
          localObject2 = localaw.amj();
        }
        ((com.tencent.mm.live.core.core.c.b)localObject3).a(l, (TXLivePlayer)localObject1, (TXCloudVideoView)localObject2);
        AppMethodBeat.o(190733);
        return;
        localObject1 = null;
        break;
      }
    }
    label355:
    AppMethodBeat.o(190733);
  }
  
  public final void a(com.tencent.mm.live.a.a parama, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(190731);
    k.h(parama, "router");
    k.h(paramLiveConfig, "config");
    Object localObject = com.tencent.mm.live.core.core.c.b.gqt;
    localObject = getContext();
    k.g(localObject, "context");
    this.gDV = com.tencent.mm.live.core.core.c.b.a.cu((Context)localObject);
    localObject = this.gDV;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).c((com.tencent.mm.live.core.core.b)this);
    }
    this.gGR = parama;
    parama = com.tencent.mm.live.b.g.guG;
    parama = paramLiveConfig.aij();
    k.g(parama, "config.hostRoomId");
    com.tencent.mm.live.b.g.uO(parama);
    parama = com.tencent.mm.live.b.g.guG;
    com.tencent.mm.live.b.g.a(new bqd());
    parama = com.tencent.mm.live.b.g.guG;
    com.tencent.mm.live.b.g.akF().DMV = paramLiveConfig.ail();
    parama = com.tencent.mm.live.b.g.guG;
    com.tencent.mm.live.b.g.uP(paramLiveConfig.aik());
    parama = com.tencent.mm.live.b.g.guG;
    parama = paramLiveConfig.ain();
    k.g(parama, "config.anchorUsername");
    com.tencent.mm.live.b.g.uQ(parama);
    parama = com.tencent.mm.live.b.g.guG;
    com.tencent.mm.live.b.g.akF().DVV = true;
    parama = findViewById(2131307768);
    k.g(parama, "findViewById(R.id.live_right_panel_ui_root)");
    this.gHO = new com.tencent.mm.live.c.v((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307809);
    k.g(parama, "findViewById(R.id.live_title_ui_root)");
    this.gGD = new ay((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307717);
    k.g(parama, "findViewById(R.id.live_minimize_ui_root)");
    this.gGJ = new am((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307838);
    k.g(parama, "findViewById(R.id.live_visitor_comment_root)");
    this.gHQ = new bg((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307644);
    k.g(parama, "findViewById(R.id.live_input_ui_root)");
    this.gHP = new z((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307549);
    k.g(parama, "findViewById(R.id.live_after_ui_root)");
    this.gGy = new com.tencent.mm.live.c.c((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307635);
    k.g(parama, "findViewById(R.id.live_input_debug_view_root)");
    this.gHR = new com.tencent.mm.live.c.q((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307652);
    k.g(parama, "findViewById(R.id.live_loading_view_root)");
    this.gGL = new com.tencent.mm.live.c.ae((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307606);
    k.g(parama, "findViewById(R.id.live_comment_ui_root)");
    this.gGB = new com.tencent.mm.live.c.m((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307678);
    k.g(parama, "findViewById(R.id.live_members_list_ui_root)");
    this.gGE = new ai((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307648);
    k.g(parama, "findViewById(R.id.live_like_confetti_ui_root)");
    this.gGN = new com.tencent.mm.live.c.ac((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307709);
    k.g(parama, "findViewById(R.id.live_mic_visitor_header_root)");
    this.gGM = new ak((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307719);
    k.g(parama, "findViewById(R.id.live_preview_ui_root)");
    this.gHM = new bk((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307811);
    k.g(parama, "findViewById(R.id.live_tx_live_player_ui_root)");
    this.gHN = new aw((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307771);
    k.g(parama, "findViewById(R.id.live_shadow_ui_root)");
    this.gGA = new as((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307833);
    k.g(parama, "findViewById(R.id.live_video_mic_ui_root)");
    this.gHS = new bc((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307691);
    k.g(parama, "findViewById(R.id.live_members_profile_ui_root)");
    this.gGO = new ag((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307647);
    k.g(parama, "findViewById(R.id.live_kicked_ui_root)");
    this.gHT = new ab((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307837);
    k.g(parama, "findViewById(R.id.live_visitor_close_ui_root)");
    this.gHU = new be((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307617);
    k.g(parama, "findViewById(R.id.live_common_info_ui_root)");
    this.gGI = new o((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307628);
    k.g(parama, "findViewById(R.id.live_exception_ui_root)");
    this.gGQ = new com.tencent.mm.live.c.r((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307634);
    k.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
    this.gGw = new t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    localObject = this.gHM;
    if (localObject != null)
    {
      parama = this.gHS;
      if (parama != null)
      {
        parama = parama.aml();
        ((bk)localObject).gEm = parama;
      }
    }
    else
    {
      parama = i.gvw;
      i.a(paramLiveConfig);
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
      localObject = this.gGD;
      if (localObject != null)
      {
        parama = com.tencent.mm.live.b.g.guG;
        parama = com.tencent.mm.live.b.g.akF().Eud;
        if (parama == null) {
          break label1678;
        }
        parama = (CharSequence)parama;
        label1023:
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
        ((ay)localObject).a(parama, com.tencent.mm.live.b.g.akH());
      }
      parama = this.gGE;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.gGO;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.gGI;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.gHN;
      if (parama != null)
      {
        k.h(paramLiveConfig, "config");
        if (paramLiveConfig.aii() != LiveConfig.gmI) {
          break label1688;
        }
        localObject = com.tencent.mm.live.core.core.a.b.gnC;
        localObject = parama.gnb.getContext();
        k.g(localObject, "root.context");
        parama.gDm = ((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.ct((Context)localObject));
      }
      label1139:
      localObject = this.gHS;
      if (localObject != null)
      {
        k.h(paramLiveConfig, "config");
        if (paramLiveConfig.aii() != LiveConfig.gmI) {
          break label1725;
        }
        parama = com.tencent.mm.live.core.core.a.b.gnC;
        parama = ((com.tencent.mm.live.c.a)localObject).gnb.getContext();
        k.g(parama, "root.context");
        parama = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.ct(parama);
        label1195:
        ((bc)localObject).gDm = parama;
      }
      parama = this.gGI;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gHU;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGy;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gHQ;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gHP;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gHO;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGE;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGL;
      if (parama != null) {
        parama.vd(paramLiveConfig.ain());
      }
      parama = this.gHM;
      if (parama != null) {
        parama.nj(0);
      }
      parama = this.gHN;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGA;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gHS;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGO;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gHT;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGQ;
      if (parama != null) {
        parama.nj(8);
      }
      parama = this.gGw;
      if (parama != null) {
        parama.nj(8);
      }
      localObject = this.gHM;
      if (localObject != null)
      {
        parama = (d.g.a.m)new k(this);
        localObject = ((bk)localObject).goF;
        if (localObject != null) {
          ((LivePreviewView)localObject).setPreviewTouchListener(parama);
        }
      }
      parama = this.gHN;
      if (parama != null)
      {
        localObject = (d.g.a.m)new l(this);
        parama.gDl.setPreviewTouchListener((d.g.a.m)localObject);
      }
      if (paramLiveConfig.getScene() == LiveConfig.gmG)
      {
        parama = this.gGy;
        if (parama != null)
        {
          parama.gyX.setVisibility(8);
          parama.gyW.setVisibility(0);
        }
      }
      parama = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.alq().gwY = ((d.g.a.b)new m(this));
      parama = com.tencent.mm.live.b.c.gtd;
      com.tencent.mm.live.b.c.e(name(), (d.g.a.a)new n(this));
      if (!LiveConfig.aio()) {
        break label1756;
      }
      parama = findViewById(2131307634);
      k.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
      this.gGw = new t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
      a(b.c.gyG, new Bundle());
      LiveConfig.dB(false);
    }
    for (;;)
    {
      parama = com.tencent.mm.live.b.c.gtd;
      com.tencent.mm.live.b.c.d(name(), this.gBo);
      AppMethodBeat.o(190731);
      return;
      parama = null;
      break;
      label1678:
      parama = (CharSequence)"";
      break label1023;
      label1688:
      localObject = com.tencent.mm.live.core.core.c.b.gqt;
      localObject = parama.gnb.getContext();
      k.g(localObject, "root.context");
      parama.gDm = ((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.cu((Context)localObject));
      break label1139;
      label1725:
      parama = com.tencent.mm.live.core.core.c.b.gqt;
      parama = ((com.tencent.mm.live.c.a)localObject).gnb.getContext();
      k.g(parama, "root.context");
      parama = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.cu(parama);
      break label1195;
      label1756:
      parama = com.tencent.mm.kernel.g.agR();
      k.g(parama, "MMKernel.storage()");
      if (parama.agA().getInt(ah.a.GWe, 0) == 1)
      {
        parama = this.gHR;
        if (parama != null) {
          parama.nj(0);
        }
      }
      else
      {
        parama = com.tencent.mm.live.b.g.guG;
        if (com.tencent.mm.live.b.g.akO() != -1)
        {
          parama = com.tencent.mm.live.b.g.guG;
          i = com.tencent.mm.live.b.g.akO();
          parama = getContext().getSystemService("window");
          if (parama == null)
          {
            parama = new d.v("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(190731);
            throw parama;
          }
          parama = ((WindowManager)parama).getDefaultDisplay();
          k.g(parama, "((context.getSystemServi…owManager).defaultDisplay");
          if (i != parama.getRotation()) {}
        }
        else
        {
          parama = com.tencent.mm.live.b.g.guG;
          paramLiveConfig = com.tencent.mm.live.b.g.akF().Eud;
          parama = paramLiveConfig;
          if (paramLiveConfig == null) {
            parama = "";
          }
          paramLiveConfig = com.tencent.mm.live.b.g.guG;
          long l = com.tencent.mm.live.b.g.akF().DMV;
          paramLiveConfig = com.tencent.mm.live.b.g.guG;
          c(parama, l, com.tencent.mm.live.b.g.akA());
          continue;
        }
        parama = com.tencent.mm.live.b.g.guG;
        if (com.tencent.mm.live.b.g.akT().guO)
        {
          b.b.a(this, b.c.gyd);
        }
        else
        {
          parama = this.gDV;
          if (parama != null)
          {
            parama = parama.goL;
            if ((parama != null) && (parama.aiS() == true)) {}
          }
          else
          {
            parama = this.gDV;
            if (parama == null) {
              break label2014;
            }
            parama = parama.goL;
            if ((parama == null) || (parama.aiT() != true)) {
              break label2014;
            }
          }
          b.b.a(this, b.c.gxJ);
        }
      }
    }
    label2014:
    parama = com.tencent.mm.live.b.g.guG;
    parama = com.tencent.mm.live.b.g.akJ();
    if (parama != null)
    {
      parama = parama.gnU;
      if (parama == null) {}
    }
    for (int i = parama.gnP;; i = c.a.aiz())
    {
      this.gnP = i;
      dV(true);
      parama = com.tencent.mm.live.b.g.guG;
      if (!com.tencent.mm.live.b.g.akU().guL) {
        break;
      }
      parama = this.gGw;
      if (parama != null) {
        parama.nj(0);
      }
      a(b.c.gxE, new Bundle());
      parama = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.akU().guL = false;
      break;
      parama = c.a.gnl;
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int i = 2;
    int j = 0;
    AppMethodBeat.i(190737);
    k.h(paramc, "status");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreVisitor", "statusChange:" + paramc.name());
    switch (c.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(190737);
      return;
      Object localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      Object localObject2 = com.tencent.mm.live.b.g.guG;
      ((com.tencent.mm.live.b.c.c)localObject1).va(com.tencent.mm.live.b.g.akA());
      localObject1 = com.tencent.mm.live.b.g.guG;
      localObject1 = com.tencent.mm.live.b.g.akA();
      localObject2 = com.tencent.mm.live.b.g.guG;
      long l = com.tencent.mm.live.b.g.akF().DMV;
      localObject2 = com.tencent.mm.live.b.g.guG;
      i = com.tencent.mm.live.b.g.ald();
      localObject2 = com.tencent.mm.live.b.g.guG;
      j = com.tencent.mm.live.b.g.alf();
      localObject2 = com.tencent.mm.live.b.g.guG;
      int k = com.tencent.mm.live.b.g.akF().EQE;
      localObject2 = com.tencent.mm.live.b.g.guG;
      int m = com.tencent.mm.live.b.g.alg();
      localObject2 = com.tencent.mm.live.b.g.guG;
      int n = com.tencent.mm.live.b.g.alh();
      localObject2 = com.tencent.mm.live.b.g.guG;
      int i1 = com.tencent.mm.live.b.g.ali();
      localObject2 = com.tencent.mm.live.b.g.guG;
      int i2 = com.tencent.mm.live.b.g.alj();
      localObject2 = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, com.tencent.mm.live.b.g.akF().Ffg);
      localObject1 = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.akN();
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(190737);
        throw paramc;
      }
      ((Activity)localObject1).finishAndRemoveTask();
      continue;
      localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.b.g.guG;
      ((com.tencent.mm.live.b.c.c)localObject1).va(com.tencent.mm.live.b.g.akA());
      localObject1 = com.tencent.mm.live.b.g.guG;
      localObject1 = com.tencent.mm.live.b.g.akA();
      localObject2 = com.tencent.mm.live.b.g.guG;
      l = com.tencent.mm.live.b.g.akF().DMV;
      localObject2 = com.tencent.mm.live.b.g.guG;
      i = com.tencent.mm.live.b.g.ald();
      localObject2 = com.tencent.mm.live.b.g.guG;
      j = com.tencent.mm.live.b.g.alf();
      localObject2 = com.tencent.mm.live.b.g.guG;
      k = com.tencent.mm.live.b.g.akF().EQE;
      localObject2 = com.tencent.mm.live.b.g.guG;
      m = com.tencent.mm.live.b.g.alg();
      localObject2 = com.tencent.mm.live.b.g.guG;
      n = com.tencent.mm.live.b.g.alh();
      localObject2 = com.tencent.mm.live.b.g.guG;
      i1 = com.tencent.mm.live.b.g.ali();
      localObject2 = com.tencent.mm.live.b.g.guG;
      i2 = com.tencent.mm.live.b.g.alj();
      localObject2 = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, com.tencent.mm.live.b.g.akF().Ffg);
      localObject1 = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.akN();
      localObject1 = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.alw();
      localObject1 = i.gvw;
      i.alD();
      continue;
      localObject1 = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.alw();
      localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.b.g.guG;
      ((com.tencent.mm.live.b.c.c)localObject1).pm(com.tencent.mm.live.b.g.akF().DMV);
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(190737);
        throw paramc;
      }
      ((Activity)localObject1).setRequestedOrientation(1);
      continue;
      if (paramBundle != null) {}
      for (localObject1 = Boolean.valueOf(paramBundle.getBoolean("PARAM_LIVE_START_BY_ORIENTATION_CHANGE", false));; localObject1 = null)
      {
        if (k.g(localObject1, Boolean.FALSE))
        {
          this.gGY.axi();
          i.gvw.alF();
          localObject1 = i.gvw;
          i.alA();
          localObject1 = i.gvw;
          i.alE();
        }
        localObject1 = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.alu();
        localObject1 = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.dN(false);
        break;
      }
      localObject1 = com.tencent.mm.live.b.g.guG;
      if (!com.tencent.mm.live.b.g.akT().guO)
      {
        localObject1 = com.tencent.mm.live.b.g.guG;
        if (!com.tencent.mm.live.b.g.akT().guQ)
        {
          localObject1 = this.gGE;
          if (localObject1 != null)
          {
            ((ai)localObject1).nj(0);
            localObject1 = y.KTp;
          }
          localObject1 = this.gGE;
          if (localObject1 != null)
          {
            ((ai)localObject1).ame();
            localObject1 = y.KTp;
            continue;
            localObject1 = com.tencent.mm.live.b.c.gtd;
            com.tencent.mm.live.b.c.akf();
            i.gvw.release();
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(190737);
              throw paramc;
            }
            ((Activity)localObject1).finishAndRemoveTask();
            continue;
            localObject1 = com.tencent.mm.live.b.g.guG;
            localObject1 = com.tencent.mm.live.b.g.akF().Eud;
            k.g(localObject1, "LiveDataManager.liveInfo.live_name");
            localObject2 = com.tencent.mm.live.b.g.guG;
            l = com.tencent.mm.live.b.g.akF().DMV;
            localObject2 = com.tencent.mm.live.b.g.guG;
            c((String)localObject1, l, com.tencent.mm.live.b.g.akA());
            continue;
            localObject2 = this.gHM;
            if (localObject2 != null)
            {
              localObject1 = this.gHS;
              if (localObject1 != null) {}
              for (localObject1 = ((bc)localObject1).aml();; localObject1 = null)
              {
                ((bk)localObject2).gEm = ((j)localObject1);
                break;
              }
              if (this.gGX)
              {
                localObject1 = getContext();
                if (localObject1 == null)
                {
                  paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                  AppMethodBeat.o(190737);
                  throw paramc;
                }
                ((Activity)localObject1).setRequestedOrientation(4);
                continue;
                localObject1 = getContext();
                if (localObject1 == null)
                {
                  paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                  AppMethodBeat.o(190737);
                  throw paramc;
                }
                ((Activity)localObject1).setRequestedOrientation(14);
                continue;
                localObject1 = com.tencent.mm.live.b.g.guG;
                localObject1 = com.tencent.mm.live.b.g.akJ();
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gnS;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.core.core.b.b)localObject1).gnL = true;
                  }
                }
                if (this.gGX)
                {
                  localObject1 = getContext();
                  if (localObject1 == null)
                  {
                    paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(190737);
                    throw paramc;
                  }
                  ((Activity)localObject1).setRequestedOrientation(4);
                }
                i = this.gnP;
                localObject1 = c.a.gnl;
                if (i == c.a.aiz())
                {
                  localObject1 = this.gHM;
                  if (localObject1 != null)
                  {
                    ((bk)localObject1).exitRoom();
                    localObject1 = y.KTp;
                  }
                  localObject1 = this.gHN;
                  if (localObject1 != null)
                  {
                    ((aw)localObject1).nj(0);
                    localObject1 = y.KTp;
                  }
                  localObject1 = this.gHN;
                  if (localObject1 != null)
                  {
                    localObject1 = ((aw)localObject1).gte;
                    if (localObject1 != null) {
                      ((TXLivePlayer)localObject1).resume();
                    }
                    localObject1 = y.KTp;
                  }
                }
                localObject1 = this.gGM;
                if (localObject1 != null)
                {
                  this.gGV.remove(localObject1);
                  continue;
                  localObject1 = this.gGM;
                  if (localObject1 != null)
                  {
                    this.gGV.remove(localObject1);
                    continue;
                    i = this.gnP;
                    localObject1 = c.a.gnl;
                    if (i == c.a.aiy())
                    {
                      anS();
                    }
                    else
                    {
                      localObject1 = c.a.gnl;
                      if (i == c.a.aiz())
                      {
                        localObject1 = com.tencent.mm.live.b.g.guG;
                        localObject1 = com.tencent.mm.live.b.g.akJ();
                        if (localObject1 != null)
                        {
                          localObject2 = this.gHM;
                          if (localObject2 != null)
                          {
                            ((bk)localObject2).a((com.tencent.mm.live.core.core.b.d)localObject1, (d.g.a.b)new p(this));
                            localObject1 = y.KTp;
                            continue;
                            localObject1 = com.tencent.mm.live.b.g.guG;
                            com.tencent.mm.live.b.g.alv();
                            localObject1 = i.gvw;
                            i.alB();
                            localObject1 = com.tencent.mm.live.b.c.gtd;
                            com.tencent.mm.live.b.c.akf();
                            i.gvw.release();
                            localObject1 = this.gGD;
                            if (localObject1 != null)
                            {
                              ((ay)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gGA;
                            if (localObject1 != null)
                            {
                              ((as)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gGy;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.c)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gHQ;
                            if (localObject1 != null)
                            {
                              ((bg)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gHP;
                            if (localObject1 != null)
                            {
                              ((z)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gHO;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.v)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gGE;
                            if (localObject1 != null)
                            {
                              ((ai)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gGL;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.ae)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gHM;
                            if (localObject1 != null)
                            {
                              ((bk)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gHN;
                            if (localObject1 != null)
                            {
                              ((aw)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gHS;
                            if (localObject1 != null)
                            {
                              ((bc)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gGO;
                            if (localObject1 != null)
                            {
                              ((ag)localObject1).nj(8);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gHT;
                            if (localObject1 != null)
                            {
                              ((ab)localObject1).nj(0);
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gHT;
                            Object localObject3;
                            if (localObject1 != null)
                            {
                              localObject2 = com.tencent.mm.live.b.g.guG;
                              localObject2 = com.tencent.mm.live.b.g.akH();
                              localObject3 = com.tencent.mm.live.b.d.a.gxt;
                              localObject3 = ((com.tencent.mm.live.c.a)localObject1).gnb.getContext();
                              k.g(localObject3, "root.context");
                              com.tencent.mm.live.b.d.a.a.a((String)localObject2, ((Context)localObject3).getResources().getColor(2131100482), (d.g.a.b)new ab.a((ab)localObject1));
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gDV;
                            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).goL.aiS() != true))
                            {
                              localObject1 = this.gDV;
                              if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).goL.aiT() != true))
                              {
                                i = this.gnP;
                                localObject1 = c.a.gnl;
                                if (i != c.a.aiy()) {
                                  break label1860;
                                }
                              }
                            }
                            localObject1 = this.gDV;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.core.core.c.b)localObject1).ajt();
                              localObject1 = y.KTp;
                            }
                            localObject1 = this.gHM;
                            if (localObject1 != null)
                            {
                              ((bk)localObject1).exitRoom();
                              localObject1 = y.KTp;
                              continue;
                              label1860:
                              localObject1 = this.gHN;
                              if (localObject1 != null)
                              {
                                ((aw)localObject1).ami();
                                localObject1 = y.KTp;
                                continue;
                                localObject1 = com.tencent.mm.live.b.g.guG;
                                com.tencent.mm.live.b.g.mX(2);
                                localObject1 = com.tencent.mm.live.b.g.guG;
                                if (!com.tencent.mm.live.b.g.akT().guO)
                                {
                                  localObject1 = com.tencent.mm.live.b.g.guG;
                                  if (!com.tencent.mm.live.b.g.akT().guQ)
                                  {
                                    localObject1 = this.gGL;
                                    if (localObject1 != null)
                                    {
                                      localObject2 = com.tencent.mm.live.b.g.guG;
                                      localObject2 = com.tencent.mm.live.b.g.akH();
                                      localObject3 = getContext();
                                      k.g(localObject3, "context");
                                      localObject3 = ((Context)localObject3).getResources().getString(2131766622);
                                      k.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
                                      ((com.tencent.mm.live.c.ae)localObject1).as((String)localObject2, (String)localObject3);
                                      localObject1 = y.KTp;
                                    }
                                    localObject1 = com.tencent.mm.live.b.g.guG;
                                    com.tencent.mm.live.b.g.alv();
                                    continue;
                                    localObject1 = com.tencent.mm.live.b.g.guG;
                                    com.tencent.mm.live.b.g.mX(1);
                                    localObject1 = com.tencent.mm.live.b.g.guG;
                                    if (!com.tencent.mm.live.b.g.akT().guO)
                                    {
                                      localObject1 = com.tencent.mm.live.b.g.guG;
                                      if (!com.tencent.mm.live.b.g.akT().guQ)
                                      {
                                        localObject1 = this.gGL;
                                        if (localObject1 != null)
                                        {
                                          localObject2 = com.tencent.mm.live.b.g.guG;
                                          localObject2 = com.tencent.mm.live.b.g.akH();
                                          localObject3 = getContext();
                                          k.g(localObject3, "context");
                                          localObject3 = ((Context)localObject3).getResources().getString(2131766568);
                                          k.g(localObject3, "context.resources.getStr…ive_anchor_exception_tip)");
                                          ((com.tencent.mm.live.c.ae)localObject1).as((String)localObject2, (String)localObject3);
                                          localObject1 = y.KTp;
                                          continue;
                                          localObject1 = this.gHM;
                                          if (localObject1 != null)
                                          {
                                            ((bk)localObject1).nj(0);
                                            localObject1 = y.KTp;
                                          }
                                          localObject1 = this.gHM;
                                          if (localObject1 != null)
                                          {
                                            ((bk)localObject1).amq();
                                            localObject1 = y.KTp;
                                          }
                                          localObject1 = this.gHN;
                                          if (localObject1 != null)
                                          {
                                            ((aw)localObject1).nj(8);
                                            localObject1 = y.KTp;
                                          }
                                          localObject1 = this.gHN;
                                          if (localObject1 != null)
                                          {
                                            localObject1 = ((aw)localObject1).gte;
                                            if (localObject1 != null) {
                                              ((TXLivePlayer)localObject1).pause();
                                            }
                                            localObject1 = y.KTp;
                                            continue;
                                            localObject1 = this.gGL;
                                            if (localObject1 != null)
                                            {
                                              ((com.tencent.mm.live.c.ae)localObject1).nj(8);
                                              localObject1 = y.KTp;
                                              continue;
                                              localObject1 = this.gDV;
                                              if (localObject1 != null)
                                              {
                                                localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).goL;
                                                if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.e)localObject1).isFloatMode()))
                                                {
                                                  localObject1 = this.gDV;
                                                  if (localObject1 != null)
                                                  {
                                                    localObject2 = getContext();
                                                    k.g(localObject2, "context");
                                                    ((com.tencent.mm.live.core.core.c.b)localObject1).cs((Context)localObject2);
                                                  }
                                                  localObject1 = com.tencent.mm.live.b.g.guG;
                                                  localObject1 = com.tencent.mm.live.b.g.akA();
                                                  localObject2 = com.tencent.mm.live.b.g.guG;
                                                  l = com.tencent.mm.live.b.g.akF().DMV;
                                                  localObject2 = com.tencent.mm.live.b.g.guG;
                                                  com.tencent.mm.live.d.e.a((String)localObject1, l, com.tencent.mm.live.b.g.akH(), 2, 1);
                                                  com.tencent.mm.live.d.f.anq();
                                                  continue;
                                                  localObject1 = com.tencent.mm.live.b.g.guG;
                                                  localObject1 = com.tencent.mm.live.b.g.akA();
                                                  localObject2 = com.tencent.mm.live.b.g.guG;
                                                  l = com.tencent.mm.live.b.g.akF().DMV;
                                                  localObject2 = com.tencent.mm.live.b.g.guG;
                                                  com.tencent.mm.live.d.e.a((String)localObject1, l, com.tencent.mm.live.b.g.akH(), 2, 0);
                                                  com.tencent.mm.live.d.f.ans();
                                                  continue;
                                                  localObject1 = this.gDV;
                                                  if (localObject1 != null)
                                                  {
                                                    localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).goL;
                                                    if (localObject1 != null)
                                                    {
                                                      ((com.tencent.mm.live.core.core.b.e)localObject1).goc = e.d.got;
                                                      localObject1 = y.KTp;
                                                      continue;
                                                      localObject1 = this.gDV;
                                                      if (localObject1 != null)
                                                      {
                                                        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).goL;
                                                        if (localObject1 != null)
                                                        {
                                                          ((com.tencent.mm.live.core.core.b.e)localObject1).goc = e.d.gov;
                                                          localObject1 = y.KTp;
                                                          continue;
                                                          localObject1 = this.gHM;
                                                          if (localObject1 != null)
                                                          {
                                                            localObject2 = com.tencent.mm.live.b.g.guG;
                                                            if (com.tencent.mm.live.b.g.akW().aly()) {}
                                                            for (;;)
                                                            {
                                                              localObject2 = com.tencent.mm.live.b.g.guG;
                                                              localObject2 = com.tencent.mm.live.b.g.akW().userId;
                                                              localObject3 = com.tencent.mm.live.b.g.guG;
                                                              ((bk)localObject1).c(i, (String)localObject2, com.tencent.mm.live.b.g.akW().streamType);
                                                              localObject1 = y.KTp;
                                                              break;
                                                              i = 1;
                                                            }
                                                            localObject1 = this.gDV;
                                                            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.c.b)localObject1).aiU() != true))
                                                            {
                                                              localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
                                                              localObject2 = com.tencent.mm.live.b.g.guG;
                                                              ((com.tencent.mm.live.b.c.c)localObject1).va(com.tencent.mm.live.b.g.akA());
                                                              localObject1 = com.tencent.mm.live.b.g.guG;
                                                              com.tencent.mm.live.b.g.akN();
                                                              localObject1 = this.gDV;
                                                              if (localObject1 != null)
                                                              {
                                                                ((com.tencent.mm.live.core.core.c.b)localObject1).aiu();
                                                                localObject1 = y.KTp;
                                                                continue;
                                                                if (!aly())
                                                                {
                                                                  if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                                  {
                                                                    localObject1 = this.gGB;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      localObject1 = ((com.tencent.mm.live.c.a)localObject1).gnb;
                                                                      if (localObject1 == null) {}
                                                                    }
                                                                    for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                                    {
                                                                      ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
                                                                      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
                                                                      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
                                                                      localObject1 = this.gGB;
                                                                      if (localObject1 == null) {
                                                                        break;
                                                                      }
                                                                      localObject1 = ((com.tencent.mm.live.c.a)localObject1).gnb;
                                                                      if (localObject1 == null) {
                                                                        break;
                                                                      }
                                                                      ((ViewGroup)localObject1).requestLayout();
                                                                      localObject1 = y.KTp;
                                                                      break;
                                                                    }
                                                                  }
                                                                  localObject1 = this.gGB;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    localObject1 = ((com.tencent.mm.live.c.a)localObject1).gnb;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      localObject1 = ((ViewGroup)localObject1).getLayoutParams();
                                                                      label2779:
                                                                      if ((localObject1 == null) || (!(localObject1 instanceof RelativeLayout.LayoutParams))) {
                                                                        continue;
                                                                      }
                                                                      ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
                                                                      localObject2 = (RelativeLayout.LayoutParams)localObject1;
                                                                      localObject3 = this.gHQ;
                                                                      if (localObject3 == null) {
                                                                        break label2904;
                                                                      }
                                                                      localObject3 = ((com.tencent.mm.live.c.a)localObject3).gnb;
                                                                      if (localObject3 == null) {
                                                                        break label2904;
                                                                      }
                                                                    }
                                                                  }
                                                                  label2904:
                                                                  for (i = ((ViewGroup)localObject3).getId();; i = 0)
                                                                  {
                                                                    ((RelativeLayout.LayoutParams)localObject2).addRule(2, i);
                                                                    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ao.fromDPToPix(getContext(), 12);
                                                                    localObject1 = this.gGB;
                                                                    if (localObject1 == null) {
                                                                      break;
                                                                    }
                                                                    localObject1 = ((com.tencent.mm.live.c.a)localObject1).gnb;
                                                                    if (localObject1 == null) {
                                                                      break;
                                                                    }
                                                                    ((ViewGroup)localObject1).requestLayout();
                                                                    localObject1 = y.KTp;
                                                                    break;
                                                                    localObject1 = null;
                                                                    break label2779;
                                                                  }
                                                                }
                                                                else if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                                {
                                                                  localObject1 = this.gGB;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    ((com.tencent.mm.live.c.m)localObject1).nj(4);
                                                                    localObject1 = y.KTp;
                                                                  }
                                                                }
                                                                else
                                                                {
                                                                  localObject1 = this.gGB;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    ((com.tencent.mm.live.c.m)localObject1).nj(0);
                                                                    localObject1 = y.KTp;
                                                                    continue;
                                                                    if (!aly())
                                                                    {
                                                                      localObject1 = this.gHP;
                                                                      if ((localObject1 != null) && (((com.tencent.mm.live.c.a)localObject1).gnb.getVisibility() == 0))
                                                                      {
                                                                        i = j;
                                                                        if (paramBundle != null) {
                                                                          i = paramBundle.getInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT");
                                                                        }
                                                                        localObject1 = this.gGB;
                                                                        if (localObject1 != null)
                                                                        {
                                                                          localObject1 = ((com.tencent.mm.live.c.a)localObject1).gnb;
                                                                          if (localObject1 == null) {}
                                                                        }
                                                                        for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                                        {
                                                                          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i;
                                                                          localObject1 = this.gGB;
                                                                          if (localObject1 == null) {
                                                                            break;
                                                                          }
                                                                          localObject1 = ((com.tencent.mm.live.c.a)localObject1).gnb;
                                                                          if (localObject1 == null) {
                                                                            break;
                                                                          }
                                                                          ((ViewGroup)localObject1).requestLayout();
                                                                          localObject1 = y.KTp;
                                                                          break;
                                                                        }
                                                                        localObject1 = com.tencent.mm.live.b.g.guG;
                                                                        if (!com.tencent.mm.live.b.g.akT().guO)
                                                                        {
                                                                          localObject1 = this.gHM;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((bk)localObject1).nj(8);
                                                                            localObject1 = y.KTp;
                                                                          }
                                                                          localObject1 = this.gGw;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((t)localObject1).nj(8);
                                                                            localObject1 = y.KTp;
                                                                          }
                                                                          localObject1 = this.gGL;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((com.tencent.mm.live.c.ae)localObject1).nj(8);
                                                                            localObject1 = y.KTp;
                                                                          }
                                                                          localObject1 = this.gGQ;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((com.tencent.mm.live.c.r)localObject1).nj(0);
                                                                            localObject1 = y.KTp;
                                                                          }
                                                                          localObject1 = com.tencent.mm.live.b.g.guG;
                                                                          com.tencent.mm.live.b.g.alv();
                                                                          localObject1 = getContext();
                                                                          if (localObject1 == null)
                                                                          {
                                                                            paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                                                                            AppMethodBeat.o(190737);
                                                                            throw paramc;
                                                                          }
                                                                          ((Activity)localObject1).setRequestedOrientation(1);
                                                                          continue;
                                                                          localObject1 = com.tencent.mm.live.b.g.guG;
                                                                          com.tencent.mm.live.b.g.akT().guR = true;
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
  
  public final void alM()
  {
    AppMethodBeat.i(190743);
    super.alM();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().a(3806, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190743);
  }
  
  public final void alN()
  {
    AppMethodBeat.i(190744);
    super.alN();
    Object localObject1 = com.tencent.mm.live.b.g.guG;
    int i;
    Object localObject2;
    if (com.tencent.mm.live.b.g.akO() != -1)
    {
      localObject1 = com.tencent.mm.live.b.g.guG;
      i = com.tencent.mm.live.b.g.akO();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(190744);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      k.g(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
      if (i != ((Display)localObject1).getRotation())
      {
        i = 1;
        if (i == 0)
        {
          localObject1 = this.gHN;
          if (localObject1 != null) {
            ((aw)localObject1).ami();
          }
          localObject1 = com.tencent.mm.live.b.c.gtd;
          com.tencent.mm.live.b.c.akf();
          localObject1 = i.gvw;
          i.alB();
          i.gvw.release();
          localObject1 = this.gDV;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.c.b)localObject1).aiv();
          }
          localObject1 = this.gDV;
          if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).goL.aiT() != true))
          {
            localObject1 = this.gDV;
            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).goL.aiS() != true)) {
              break label306;
            }
          }
          localObject1 = com.tencent.mm.live.b.g.guG;
          localObject1 = com.tencent.mm.live.b.g.alq().gxe;
          if (localObject1 != null)
          {
            localObject2 = i.gvw;
            i.ar(((com.tencent.mm.live.b.b.a.a)localObject1).gxh, ((com.tencent.mm.live.b.b.a.a)localObject1).gxj);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("PARAM_HANGUP_SELF", true);
          a(b.c.gxT, (Bundle)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.WN();
      localObject1 = com.tencent.mm.live.core.core.c.b.gqt;
      localObject1 = com.tencent.mm.live.core.core.c.b.ajw();
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject1).release();
      }
      com.tencent.mm.live.core.core.c.b.e(null);
      this.gGY.YC();
      localObject1 = com.tencent.mm.kernel.g.agQ();
      k.g(localObject1, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject1).agi().b(3806, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(190744);
      return;
      i = 0;
      break;
      label306:
      localObject1 = this.gHO;
      if ((localObject1 != null) && (((com.tencent.mm.live.c.v)localObject1).gAU.gDW == true))
      {
        localObject1 = i.gvw;
        localObject1 = com.tencent.mm.live.b.g.guG;
        String str = com.tencent.mm.live.b.g.alq().gxf;
        localObject1 = com.tencent.mm.live.b.g.guG;
        localObject2 = com.tencent.mm.live.b.g.akF().Ffe;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        i.ar(str, (String)localObject1);
      }
    }
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(190745);
    boolean bool2 = super.alO();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
      bool1 = bool2;
      if (com.tencent.mm.live.b.g.akT().guP)
      {
        localg = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.akT().guP = false;
        b.b.a(this, b.c.gxK);
        bool1 = true;
      }
    }
    AppMethodBeat.o(190745);
    return bool1;
  }
  
  public final void dU(boolean paramBoolean)
  {
    this.gGX = paramBoolean;
  }
  
  public final void f(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(190748);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreVisitor", "callback:".concat(String.valueOf(paramInt)));
    Object localObject4 = c.b.gnu;
    if (paramInt == c.b.aiA())
    {
      b.b.a(this, b.c.gyg);
      AppMethodBeat.o(190748);
      return;
    }
    localObject4 = c.b.gnu;
    if (paramInt == c.b.aiB())
    {
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getString("live_user_id");
        paramBundle.getString("live_user_exit_reason");
        localObject3 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
        paramBundle = com.tencent.mm.live.b.g.guG;
        paramBundle = com.tencent.mm.live.b.g.alq().gxe;
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.gxj;; paramBundle = null)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreAnchor", paramBundle);
          paramBundle = com.tencent.mm.live.b.g.guG;
          localObject3 = com.tencent.mm.live.b.g.alq().gxe;
          paramBundle = (Bundle)localObject1;
          if (localObject3 != null) {
            paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject3).gxj;
          }
          if (!k.g(localObject2, paramBundle))
          {
            paramBundle = com.tencent.mm.live.b.g.guG;
            if (!k.g(localObject2, com.tencent.mm.live.b.g.akF().Fff)) {}
          }
          else
          {
            paramBundle = com.tencent.mm.live.b.g.guG;
            paramBundle = com.tencent.mm.live.b.g.alq().gxe;
            if (paramBundle != null)
            {
              localObject1 = this.gHM;
              if (localObject1 != null)
              {
                localObject1 = ((bk)localObject1).goF;
                if (localObject1 != null) {
                  ((LivePreviewView)localObject1).clearAnimation();
                }
              }
              localObject1 = com.tencent.mm.live.b.g.guG;
              com.tencent.mm.live.b.g.alq().a(paramBundle.gmP, paramBundle.gxi, paramBundle.gxh);
            }
          }
          paramBundle = com.tencent.mm.live.b.g.guG;
          if (k.g(localObject2, com.tencent.mm.live.b.g.akF().Fff))
          {
            this.gHV = true;
            b.b.a(this, b.c.gyx);
          }
          AppMethodBeat.o(190748);
          return;
        }
      }
      AppMethodBeat.o(190748);
      return;
    }
    localObject1 = c.b.gnu;
    if (paramInt == c.b.aiC()) {
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getString("live_user_id");
        if (paramBundle.getBoolean("live_media_enable"))
        {
          paramBundle = com.tencent.mm.live.b.g.guG;
          localObject3 = com.tencent.mm.live.b.g.alq();
          if (localObject1 != null) {
            break label963;
          }
        }
      }
    }
    label946:
    label963:
    for (paramBundle = "";; paramBundle = (Bundle)localObject1)
    {
      ((com.tencent.mm.live.b.b.a)localObject3).gxg = paramBundle;
      localObject4 = ((com.tencent.mm.live.b.b.a)localObject3).gxe;
      paramBundle = (Bundle)localObject2;
      if (localObject4 != null) {
        paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject4).gxj;
      }
      if ((k.g(localObject1, paramBundle)) && (!((com.tencent.mm.live.b.b.a)localObject3).alI()))
      {
        paramBundle = ((com.tencent.mm.live.b.b.a)localObject3).gxb;
        if (paramBundle != null)
        {
          paramBundle.invoke();
          AppMethodBeat.o(190748);
          return;
        }
      }
      AppMethodBeat.o(190748);
      return;
      b.b.a(this, b.c.gxT);
      AppMethodBeat.o(190748);
      return;
      AppMethodBeat.o(190748);
      return;
      localObject1 = c.b.gnu;
      long l;
      if (paramInt == c.b.aiE())
      {
        paramBundle = this.gDV;
        int k;
        if ((paramBundle != null) && (paramBundle.goL.aiT() == true))
        {
          i = 1;
          k = this.gnP;
          paramBundle = c.a.gnl;
          if (k != c.a.aiy()) {
            break label636;
          }
          j = 2;
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
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.b.g.akH(), i, j, paramInt);
          AppMethodBeat.o(190748);
          return;
          paramBundle = this.gDV;
          if ((paramBundle != null) && (paramBundle.goL.aiS() == true))
          {
            i = 2;
            break;
          }
          i = 0;
          break;
          label636:
          paramBundle = c.a.gnl;
          if (k == c.a.aiz()) {
            j = 1;
          }
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
        k.g(localObject1, "LiveDataManager.liveInfo.live_name");
        new com.tencent.mm.live.b.a(l, paramBundle, (String)localObject1, (byte)0).a((d.g.a.r)new b(this));
        AppMethodBeat.o(190748);
        return;
      }
      localObject1 = c.b.gnu;
      if (paramInt == c.b.aiH())
      {
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
        localObject4 = this.gDV;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject4).goL;
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = ((com.tencent.mm.live.core.core.b.e)localObject4).goe;
          }
        }
        if (!bs.lr((String)localObject1, (String)localObject2))
        {
          localObject2 = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.akW().setUserId((String)localObject1);
          localObject1 = com.tencent.mm.live.b.g.guG;
          localObject1 = com.tencent.mm.live.b.g.akW();
          if (paramBundle != null)
          {
            paramInt = paramBundle.getInt("live_stream_type");
            ((g.c)localObject1).streamType = paramInt;
            localObject1 = com.tencent.mm.live.b.g.guG;
            localObject1 = com.tencent.mm.live.b.g.akW();
            if (paramBundle == null) {
              break label946;
            }
          }
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
            AppMethodBeat.o(190748);
            return;
            paramInt = 0;
            break;
          }
        }
        this.gHV = false;
      }
      AppMethodBeat.o(190748);
      return;
    }
  }
  
  public final int getLiveRole()
  {
    return 0;
  }
  
  public final int getRelativeLayoutId()
  {
    return 2131496356;
  }
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(190747);
    super.i(paramBoolean, paramInt);
    AppMethodBeat.o(190747);
  }
  
  public final String name()
  {
    AppMethodBeat.i(190738);
    String str = LiveVisitorPluginLayout.class.getSimpleName();
    k.g(str, "LiveVisitorPluginLayout::class.java.simpleName");
    AppMethodBeat.o(190738);
    return str;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(190732);
    k.h(paramString, "incomingNumber");
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.gDV;
    if (paramString != null)
    {
      paramString = paramString.goL;
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.isFloatMode());
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreVisitor", paramString);
        switch (paramInt)
        {
        }
      }
    }
    do
    {
      AppMethodBeat.o(190732);
      return;
      paramString = null;
      break;
      AppMethodBeat.o(190732);
      return;
      paramString = i.gvw;
      i.alB();
      paramString = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.akN();
      paramString = this.gDV;
      if ((paramString != null) && (paramString.goL.aiS() == true))
      {
        paramString = this.gDV;
        if (paramString != null) {
          paramString.aiq();
        }
      }
      paramString = this.gDV;
    } while (paramString == null);
    paramString.aiu();
    AppMethodBeat.o(190732);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(190746);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreVisitor", "errType:" + paramInt1 + " errCode:" + paramInt2);
    if (((paramn instanceof com.tencent.mm.live.b.a.b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.gHQ;
      if (paramString != null) {
        paramString.amm();
      }
      paramn = this.gGD;
      if (paramn != null)
      {
        paramString = com.tencent.mm.live.b.g.guG;
        paramString = com.tencent.mm.live.b.g.akF().Eud;
        if (paramString == null) {
          break label145;
        }
        paramString = (CharSequence)paramString;
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
        paramn.a(paramString, com.tencent.mm.live.b.g.akH());
      }
      paramString = com.tencent.mm.live.b.g.guG;
      paramString = com.tencent.mm.live.b.g.guG;
      if (com.tencent.mm.live.b.g.akF().DVV) {
        break label155;
      }
    }
    label145:
    label155:
    for (paramInt1 = ce.azK();; paramInt1 = 0)
    {
      com.tencent.mm.live.b.g.mU(paramInt1);
      AppMethodBeat.o(190746);
      return;
      paramString = (CharSequence)"";
      break;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(190742);
    super.pause();
    Object localObject1 = com.tencent.mm.live.b.g.guG;
    if (com.tencent.mm.live.b.g.akO() != -1)
    {
      localObject1 = com.tencent.mm.live.b.g.guG;
      int i = com.tencent.mm.live.b.g.akO();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(190742);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      k.g(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
      if (i == ((Display)localObject1).getRotation()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new StringBuilder("orientationChanged:").append(bool).append(", ");
      localObject2 = getContext().getSystemService("window");
      if (localObject2 != null) {
        break;
      }
      localObject1 = new d.v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(190742);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
    k.g(localObject2, "((context.getSystemServi…owManager).defaultDisplay");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreVisitor", ((Display)localObject2).getRotation());
    if (!bool)
    {
      localObject1 = com.tencent.mm.live.b.g.guG;
      if (!com.tencent.mm.live.b.g.akT().guO)
      {
        localObject1 = com.tencent.mm.live.b.g.guG;
        if (!com.tencent.mm.live.b.g.akT().guQ)
        {
          localObject1 = com.tencent.mm.live.b.g.guG;
          if (!com.tencent.mm.live.b.g.akT().guR)
          {
            localObject1 = com.tencent.mm.live.b.g.guG;
            if (com.tencent.mm.live.b.g.akT().guP)
            {
              localObject1 = com.tencent.mm.live.b.g.guG;
              if ((!com.tencent.mm.live.b.g.akM()) && (com.tencent.mm.compatible.d.b.cc(getContext()))) {
                b.b.a(this, b.c.gxY);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = this.gDV;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).goL;
      if (localObject1 == null) {
        break;
      }
      if (((com.tencent.mm.live.core.core.b.e)localObject1).aiS() != true) {
        break label369;
      }
      localObject1 = this.gDV;
      if (localObject1 == null) {
        break label369;
      }
      ((com.tencent.mm.live.core.core.c.b)localObject1).aiq();
      AppMethodBeat.o(190742);
      return;
      localObject1 = this.gDV;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).goL;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).aiQ() == true))
        {
          localObject1 = this.gDV;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.c.b)localObject1).ajt();
          }
        }
      }
    }
    AppMethodBeat.o(190742);
    return;
    label369:
    AppMethodBeat.o(190742);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(190741);
    Object localObject1 = com.tencent.mm.live.b.g.guG;
    com.tencent.mm.live.b.g.akT().guR = false;
    localObject1 = getContext().getSystemService("window");
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(190741);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
    k.g(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
    int j = ((Display)localObject1).getRotation();
    localObject1 = new StringBuilder("curOrientation:").append(j).append(", lastOrientation:");
    Object localObject2 = com.tencent.mm.live.b.g.guG;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreVisitor", com.tencent.mm.live.b.g.akO());
    super.resume();
    localObject1 = this.gDV;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).goL;
      if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).aiQ() == true))
      {
        localObject1 = this.gDV;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).aju();
        }
      }
    }
    localObject1 = com.tencent.mm.live.b.g.guG;
    int i;
    if (com.tencent.mm.live.b.g.akO() != -1)
    {
      localObject1 = com.tencent.mm.live.b.g.guG;
      if (j != com.tencent.mm.live.b.g.akO())
      {
        localObject1 = this.gDV;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).ajq();
        }
        localObject1 = this.gHM;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.live.b.g.guG;
          if (!com.tencent.mm.live.b.g.akW().aly()) {
            break label320;
          }
          i = 2;
          localObject2 = com.tencent.mm.live.b.g.guG;
          localObject2 = com.tencent.mm.live.b.g.akW().userId;
          com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
          ((bk)localObject1).c(i, (String)localObject2, com.tencent.mm.live.b.g.akW().streamType);
        }
      }
    }
    for (;;)
    {
      localObject1 = this.gDV;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).goL;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).aiS() == true))
        {
          localObject1 = this.gHM;
          if (localObject1 != null)
          {
            localObject2 = ((bk)localObject1).gDV;
            if (localObject2 != null) {
              ((com.tencent.mm.live.core.core.c.b)localObject2).a(((bk)localObject1).goF);
            }
          }
        }
      }
      localObject1 = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.mV(j);
      AppMethodBeat.o(190741);
      return;
      label320:
      i = 1;
      break;
      localObject1 = this.gDV;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).goL;
        if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.e)localObject1).gnZ))
        {
          localObject1 = this.gDV;
          if (localObject1 == null) {
            continue;
          }
          ((com.tencent.mm.live.core.core.c.b)localObject1).ais();
          continue;
        }
      }
      localObject1 = this.gDV;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).goL;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.b.e)localObject1).gnZ = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(190740);
    super.start();
    Object localObject = i.gvw;
    i.alD();
    localObject = this.gDV;
    if (((localObject == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject).goL.aiS() != true)) && (this.gGX))
    {
      localObject = com.tencent.mm.live.b.g.guG;
      if (!com.tencent.mm.live.b.g.akT().guO)
      {
        localObject = com.tencent.mm.live.b.g.guG;
        if (!com.tencent.mm.live.b.g.akT().guQ)
        {
          localObject = getContext();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(190740);
            throw ((Throwable)localObject);
          }
          ((Activity)localObject).setRequestedOrientation(4);
        }
      }
    }
    AppMethodBeat.o(190740);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, y>
  {
    b(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    c(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    d(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, y>
  {
    e(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class g
    implements DialogInterface.OnDismissListener
  {
    g(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(190717);
      paramDialogInterface = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.alv();
      b.b.a(this.gHX, b.c.gxL);
      AppMethodBeat.o(190717);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class i
    implements DialogInterface.OnDismissListener
  {
    i(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(190719);
      paramDialogInterface = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.alv();
      b.b.a(this.gHX, b.c.gxL);
      AppMethodBeat.o(190719);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/view/LiveVisitorPluginLayout$handleJoinLiveErr$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
  public static final class j
    extends com.tencent.mm.plugin.messenger.a.a
  {
    j(int paramInt) {}
    
    public final void onClickImp(View paramView)
    {
      AppMethodBeat.i(190720);
      k.h(paramView, "widget");
      paramView = new Intent();
      f.a locala = com.tencent.mm.live.b.f.gtk;
      paramView.putExtra("rawUrl", com.tencent.mm.live.b.f.aki());
      paramView.putExtra("showShare", false);
      com.tencent.mm.br.d.e(this.gHX.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(190720);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.m<Float, Float, y>
  {
    k(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.m<Float, Float, y>
  {
    l(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "liveID", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<Long, y>
  {
    m(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    n(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    o(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/live/view/LiveVisitorPluginLayout$statusChange$3$1"})
  static final class p
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    p(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    q(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVisitorPluginLayout
 * JD-Core Version:    0.7.0.1
 */