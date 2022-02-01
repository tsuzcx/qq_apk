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
import com.tencent.mm.al.n;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.f.a;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.live.b.g.c;
import com.tencent.mm.live.b.g.d;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.c.ab;
import com.tencent.mm.live.c.ab.a;
import com.tencent.mm.live.c.ac;
import com.tencent.mm.live.c.ae;
import com.tencent.mm.live.c.ag;
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
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.b.e.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.aq;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "anchorExceptionInTRTC", "", "audienceMode", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "liveDebugPlugin", "Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveGuestRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "liveInputPlugin", "Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "liveKickedPlugin", "Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVideoMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "liveVisitorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "liveVisitorCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "navigation", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "pluginShow", "rotationEnable", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkAnchorStatus", "checkClickArea", "x", "", "y", "validCallback", "chooseAudienceMode", "byOrientationChange", "enterRoom", "liveName", "", "roomID", "", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleEnterRoom", "handleJoinLiveErr", "errCode", "errMsg", "initLogic", "router", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "keyboardChange", "show", "height", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "requestLinkMic", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "toggleShowPlugins", "unMount", "updatePlugin", "Companion", "plugin-logic_release"})
public final class LiveVisitorPluginLayout
  extends BaseLivePluginLayout
  implements com.tencent.mm.al.f, com.tencent.mm.live.core.core.b
{
  public static final LiveVisitorPluginLayout.a hbG;
  private int gHy;
  private final d.g.a.a<d.z> gUY;
  private com.tencent.mm.live.core.core.c.b gXF;
  private com.tencent.mm.live.c.r haA;
  private com.tencent.mm.live.a.a haB;
  private final ArrayList<com.tencent.mm.live.c.a> haF;
  private boolean haG;
  private boolean haH;
  private final com.tencent.mm.model.d haI;
  private t hag;
  private com.tencent.mm.live.c.c hai;
  private as hak;
  private com.tencent.mm.live.c.m hal;
  private ay han;
  private com.tencent.mm.live.c.ai hao;
  private o has;
  private am hat;
  private ae hav;
  private ak haw;
  private ac hax;
  private ag hay;
  private bg hbA;
  private com.tencent.mm.live.c.q hbB;
  private bc hbC;
  private ab hbD;
  private be hbE;
  private boolean hbF;
  private bk hbw;
  private aw hbx;
  private com.tencent.mm.live.c.v hby;
  private com.tencent.mm.live.c.z hbz;
  
  static
  {
    AppMethodBeat.i(213040);
    hbG = new LiveVisitorPluginLayout.a((byte)0);
    AppMethodBeat.o(213040);
  }
  
  public LiveVisitorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(213039);
    this.haG = true;
    paramContext = c.a.gGU;
    this.gHy = c.a.alk();
    this.haF = new ArrayList();
    this.haI = com.tencent.mm.model.d.azW();
    this.gUY = ((d.g.a.a)new o(this));
    AppMethodBeat.o(213039);
  }
  
  private final void a(float paramFloat1, float paramFloat2, d.g.a.a<d.z> parama)
  {
    AppMethodBeat.i(213029);
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
      AppMethodBeat.o(213029);
      return;
    }
  }
  
  private final void aqE()
  {
    AppMethodBeat.i(213025);
    Object localObject = com.tencent.mm.live.core.core.c.b.gKd;
    localObject = getContext();
    p.g(localObject, "context");
    com.tencent.mm.live.core.core.c.b.a.cr((Context)localObject).amd();
    localObject = com.tencent.mm.live.core.core.c.b.gKd;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = com.tencent.mm.live.core.core.c.b.a.cr((Context)localObject);
    String str = com.tencent.mm.cc.a.az(getContext(), 2131766707);
    p.g(str, "ResourceHelper.getString…tring.live_room_mini_mic)");
    ((com.tencent.mm.live.core.core.c.b)localObject).xl(str);
    ad.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:0");
    AppMethodBeat.o(213025);
  }
  
  private final void c(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(213026);
    ad.i("MicroMsg.LiveCoreVisitor", "join, name:" + paramString1 + ", roomID:" + paramLong);
    com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
    new com.tencent.mm.live.b.a(com.tencent.mm.live.b.g.ans().Fsa, paramString2, paramString1, (byte)0).a((d.g.a.r)new e(this));
    AppMethodBeat.o(213026);
  }
  
  private final void dX(final boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(213023);
    ad.i("MicroMsg.LiveCoreVisitor", "audienceMode:" + this.gHy);
    int i = this.gHy;
    Object localObject1 = c.a.gGU;
    if (i == c.a.alk())
    {
      com.tencent.mm.live.d.f.aql();
      localObject1 = this.hbw;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.b.g.gOr;
        localObject2 = com.tencent.mm.live.b.g.anw();
        if (localObject2 == null) {
          p.gfZ();
        }
        ((bk)localObject1).a((com.tencent.mm.live.core.core.b.d)localObject2, (d.g.a.b)new c(this, paramBoolean));
      }
      localObject1 = this.hbw;
      if (localObject1 != null)
      {
        ((bk)localObject1).nI(0);
        AppMethodBeat.o(213023);
        return;
      }
      AppMethodBeat.o(213023);
      return;
    }
    localObject1 = c.a.gGU;
    if (i == c.a.all())
    {
      com.tencent.mm.live.d.f.aqk();
      localObject1 = this.gXF;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.live.b.g.gOr;
        localObject3 = com.tencent.mm.live.b.g.anw();
        if (localObject3 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.live.core.core.c.b)localObject1).a((com.tencent.mm.live.core.core.b.d)localObject3);
      }
      Object localObject3 = this.hbx;
      long l;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.live.b.g.gOr;
        localObject1 = com.tencent.mm.live.b.g.anw();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gHD;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.live.core.core.b.c)localObject1).gHx;
            aw.a((aw)localObject3, (String)localObject1, (d.g.a.b)new d(this, paramBoolean));
          }
        }
      }
      else
      {
        localObject1 = this.hbx;
        if (localObject1 != null) {
          ((aw)localObject1).nI(0);
        }
        localObject3 = this.gXF;
        if (localObject3 == null) {
          break label355;
        }
        localObject1 = com.tencent.mm.live.b.g.gOr;
        l = com.tencent.mm.live.b.g.ans().Fsa;
        localObject1 = this.hbx;
        if (localObject1 == null) {
          break label349;
        }
      }
      label349:
      for (localObject1 = ((aw)localObject1).gMP;; localObject1 = null)
      {
        aw localaw = this.hbx;
        if (localaw != null) {
          localObject2 = localaw.aoW();
        }
        ((com.tencent.mm.live.core.core.c.b)localObject3).a(l, (TXLivePlayer)localObject1, (TXCloudVideoView)localObject2);
        AppMethodBeat.o(213023);
        return;
        localObject1 = null;
        break;
      }
    }
    label355:
    AppMethodBeat.o(213023);
  }
  
  public final void a(com.tencent.mm.live.a.a parama, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(213021);
    p.h(parama, "router");
    p.h(paramLiveConfig, "config");
    Object localObject = com.tencent.mm.live.core.core.c.b.gKd;
    localObject = getContext();
    p.g(localObject, "context");
    this.gXF = com.tencent.mm.live.core.core.c.b.a.cr((Context)localObject);
    localObject = this.gXF;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).c((com.tencent.mm.live.core.core.b)this);
    }
    this.haB = parama;
    parama = com.tencent.mm.live.b.g.gOr;
    parama = paramLiveConfig.akV();
    p.g(parama, "config.hostRoomId");
    com.tencent.mm.live.b.g.xE(parama);
    parama = com.tencent.mm.live.b.g.gOr;
    com.tencent.mm.live.b.g.a(new buq());
    parama = com.tencent.mm.live.b.g.gOr;
    com.tencent.mm.live.b.g.ans().Fsa = paramLiveConfig.akX();
    parama = com.tencent.mm.live.b.g.gOr;
    com.tencent.mm.live.b.g.xF(paramLiveConfig.akW());
    parama = com.tencent.mm.live.b.g.gOr;
    parama = paramLiveConfig.akZ();
    p.g(parama, "config.anchorUsername");
    com.tencent.mm.live.b.g.xG(parama);
    parama = com.tencent.mm.live.b.g.gOr;
    com.tencent.mm.live.b.g.ans().FBr = true;
    parama = findViewById(2131307768);
    p.g(parama, "findViewById(R.id.live_right_panel_ui_root)");
    this.hby = new com.tencent.mm.live.c.v((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307809);
    p.g(parama, "findViewById(R.id.live_title_ui_root)");
    this.han = new ay((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307717);
    p.g(parama, "findViewById(R.id.live_minimize_ui_root)");
    this.hat = new am((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307838);
    p.g(parama, "findViewById(R.id.live_visitor_comment_root)");
    this.hbA = new bg((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307644);
    p.g(parama, "findViewById(R.id.live_input_ui_root)");
    this.hbz = new com.tencent.mm.live.c.z((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307549);
    p.g(parama, "findViewById(R.id.live_after_ui_root)");
    this.hai = new com.tencent.mm.live.c.c((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307635);
    p.g(parama, "findViewById(R.id.live_input_debug_view_root)");
    this.hbB = new com.tencent.mm.live.c.q((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307652);
    p.g(parama, "findViewById(R.id.live_loading_view_root)");
    this.hav = new ae((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307606);
    p.g(parama, "findViewById(R.id.live_comment_ui_root)");
    this.hal = new com.tencent.mm.live.c.m((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307678);
    p.g(parama, "findViewById(R.id.live_members_list_ui_root)");
    this.hao = new com.tencent.mm.live.c.ai((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307648);
    p.g(parama, "findViewById(R.id.live_like_confetti_ui_root)");
    this.hax = new ac((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307709);
    p.g(parama, "findViewById(R.id.live_mic_visitor_header_root)");
    this.haw = new ak((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307719);
    p.g(parama, "findViewById(R.id.live_preview_ui_root)");
    this.hbw = new bk((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307811);
    p.g(parama, "findViewById(R.id.live_tx_live_player_ui_root)");
    this.hbx = new aw((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307771);
    p.g(parama, "findViewById(R.id.live_shadow_ui_root)");
    this.hak = new as((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307833);
    p.g(parama, "findViewById(R.id.live_video_mic_ui_root)");
    this.hbC = new bc((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307691);
    p.g(parama, "findViewById(R.id.live_members_profile_ui_root)");
    this.hay = new ag((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307647);
    p.g(parama, "findViewById(R.id.live_kicked_ui_root)");
    this.hbD = new ab((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307837);
    p.g(parama, "findViewById(R.id.live_visitor_close_ui_root)");
    this.hbE = new be((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307617);
    p.g(parama, "findViewById(R.id.live_common_info_ui_root)");
    this.has = new o((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307628);
    p.g(parama, "findViewById(R.id.live_exception_ui_root)");
    this.haA = new com.tencent.mm.live.c.r((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307634);
    p.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
    this.hag = new t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    localObject = this.hbw;
    if (localObject != null)
    {
      parama = this.hbC;
      if (parama != null)
      {
        parama = parama.aoY();
        ((bk)localObject).gXW = parama;
      }
    }
    else
    {
      parama = i.gPh;
      i.a(paramLiveConfig);
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
      localObject = this.han;
      if (localObject != null)
      {
        parama = com.tencent.mm.live.b.g.gOr;
        parama = com.tencent.mm.live.b.g.ans().Gbw;
        if (parama == null) {
          break label1678;
        }
        parama = (CharSequence)parama;
        label1023:
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
        ((ay)localObject).a(parama, com.tencent.mm.live.b.g.anu());
      }
      parama = this.hao;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.hay;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.has;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.hbx;
      if (parama != null)
      {
        p.h(paramLiveConfig, "config");
        if (paramLiveConfig.akU() != LiveConfig.gGr) {
          break label1688;
        }
        localObject = com.tencent.mm.live.core.core.a.b.gHl;
        localObject = parama.gGK.getContext();
        p.g(localObject, "root.context");
        parama.gWW = ((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.cq((Context)localObject));
      }
      label1139:
      localObject = this.hbC;
      if (localObject != null)
      {
        p.h(paramLiveConfig, "config");
        if (paramLiveConfig.akU() != LiveConfig.gGr) {
          break label1725;
        }
        parama = com.tencent.mm.live.core.core.a.b.gHl;
        parama = ((com.tencent.mm.live.c.a)localObject).gGK.getContext();
        p.g(parama, "root.context");
        parama = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.cq(parama);
        label1195:
        ((bc)localObject).gWW = parama;
      }
      parama = this.has;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hbE;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hai;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hbA;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hbz;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hby;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hao;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hav;
      if (parama != null) {
        parama.xT(paramLiveConfig.akZ());
      }
      parama = this.hbw;
      if (parama != null) {
        parama.nI(0);
      }
      parama = this.hbx;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hak;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hbC;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hay;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hbD;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.haA;
      if (parama != null) {
        parama.nI(8);
      }
      parama = this.hag;
      if (parama != null) {
        parama.nI(8);
      }
      localObject = this.hbw;
      if (localObject != null)
      {
        parama = (d.g.a.m)new k(this);
        localObject = ((bk)localObject).gIn;
        if (localObject != null) {
          ((LivePreviewView)localObject).setPreviewTouchListener(parama);
        }
      }
      parama = this.hbx;
      if (parama != null)
      {
        localObject = (d.g.a.m)new l(this);
        parama.gWV.setPreviewTouchListener((d.g.a.m)localObject);
      }
      if (paramLiveConfig.getScene() == LiveConfig.gGp)
      {
        parama = this.hai;
        if (parama != null)
        {
          parama.gSI.setVisibility(8);
          parama.gSH.setVisibility(0);
        }
      }
      parama = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.aod().gQJ = ((d.g.a.b)new m(this));
      parama = com.tencent.mm.live.b.c.gMO;
      com.tencent.mm.live.b.c.e(name(), (d.g.a.a)new n(this));
      if (!LiveConfig.ala()) {
        break label1756;
      }
      parama = findViewById(2131307634);
      p.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
      this.hag = new t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
      a(b.c.gSr, new Bundle());
      LiveConfig.dD(false);
    }
    for (;;)
    {
      parama = com.tencent.mm.live.b.c.gMO;
      com.tencent.mm.live.b.c.d(name(), this.gUY);
      AppMethodBeat.o(213021);
      return;
      parama = null;
      break;
      label1678:
      parama = (CharSequence)"";
      break label1023;
      label1688:
      localObject = com.tencent.mm.live.core.core.c.b.gKd;
      localObject = parama.gGK.getContext();
      p.g(localObject, "root.context");
      parama.gWW = ((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.cr((Context)localObject));
      break label1139;
      label1725:
      parama = com.tencent.mm.live.core.core.c.b.gKd;
      parama = ((com.tencent.mm.live.c.a)localObject).gGK.getContext();
      p.g(parama, "root.context");
      parama = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.cr(parama);
      break label1195;
      label1756:
      parama = com.tencent.mm.kernel.g.ajC();
      p.g(parama, "MMKernel.storage()");
      if (parama.ajl().getInt(al.a.IJb, 0) == 1)
      {
        parama = this.hbB;
        if (parama != null) {
          parama.nI(0);
        }
      }
      else
      {
        parama = com.tencent.mm.live.b.g.gOr;
        if (com.tencent.mm.live.b.g.anB() != -1)
        {
          parama = com.tencent.mm.live.b.g.gOr;
          i = com.tencent.mm.live.b.g.anB();
          parama = getContext().getSystemService("window");
          if (parama == null)
          {
            parama = new d.v("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(213021);
            throw parama;
          }
          parama = ((WindowManager)parama).getDefaultDisplay();
          p.g(parama, "((context.getSystemServi…owManager).defaultDisplay");
          if (i != parama.getRotation()) {}
        }
        else
        {
          parama = com.tencent.mm.live.b.g.gOr;
          paramLiveConfig = com.tencent.mm.live.b.g.ans().Gbw;
          parama = paramLiveConfig;
          if (paramLiveConfig == null) {
            parama = "";
          }
          paramLiveConfig = com.tencent.mm.live.b.g.gOr;
          long l = com.tencent.mm.live.b.g.ans().Fsa;
          paramLiveConfig = com.tencent.mm.live.b.g.gOr;
          c(parama, l, com.tencent.mm.live.b.g.anm());
          continue;
        }
        parama = com.tencent.mm.live.b.g.gOr;
        if (com.tencent.mm.live.b.g.anG().gOz)
        {
          b.b.a(this, b.c.gRO);
        }
        else
        {
          parama = this.gXF;
          if (parama != null)
          {
            parama = parama.gIt;
            if ((parama != null) && (parama.alE() == true)) {}
          }
          else
          {
            parama = this.gXF;
            if (parama == null) {
              break label2014;
            }
            parama = parama.gIt;
            if ((parama == null) || (parama.alF() != true)) {
              break label2014;
            }
          }
          b.b.a(this, b.c.gRu);
        }
      }
    }
    label2014:
    parama = com.tencent.mm.live.b.g.gOr;
    parama = com.tencent.mm.live.b.g.anw();
    if (parama != null)
    {
      parama = parama.gHD;
      if (parama == null) {}
    }
    for (int i = parama.gHy;; i = c.a.all())
    {
      this.gHy = i;
      dX(true);
      parama = com.tencent.mm.live.b.g.gOr;
      if (!com.tencent.mm.live.b.g.anH().gOw) {
        break;
      }
      parama = this.hag;
      if (parama != null) {
        parama.nI(0);
      }
      a(b.c.gRp, new Bundle());
      parama = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.anH().gOw = false;
      break;
      parama = c.a.gGU;
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int i = 2;
    int j = 0;
    AppMethodBeat.i(213027);
    p.h(paramc, "status");
    ad.i("MicroMsg.LiveCoreVisitor", "statusChange:" + paramc.name());
    switch (c.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(213027);
      return;
      Object localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      Object localObject2 = com.tencent.mm.live.b.g.gOr;
      ((com.tencent.mm.live.b.c.c)localObject1).xQ(com.tencent.mm.live.b.g.anm());
      localObject1 = com.tencent.mm.live.b.g.gOr;
      localObject1 = com.tencent.mm.live.b.g.anm();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      long l = com.tencent.mm.live.b.g.ans().Fsa;
      localObject2 = com.tencent.mm.live.b.g.gOr;
      i = com.tencent.mm.live.b.g.anQ();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      j = com.tencent.mm.live.b.g.anS();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      int k = com.tencent.mm.live.b.g.ans().GzV;
      localObject2 = com.tencent.mm.live.b.g.gOr;
      int m = com.tencent.mm.live.b.g.anT();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      int n = com.tencent.mm.live.b.g.anU();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      int i1 = com.tencent.mm.live.b.g.anV();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      int i2 = com.tencent.mm.live.b.g.anW();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, com.tencent.mm.live.b.g.ans().GOK);
      localObject1 = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.anA();
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(213027);
        throw paramc;
      }
      ((Activity)localObject1).finishAndRemoveTask();
      continue;
      localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      ((com.tencent.mm.live.b.c.c)localObject1).xQ(com.tencent.mm.live.b.g.anm());
      localObject1 = com.tencent.mm.live.b.g.gOr;
      localObject1 = com.tencent.mm.live.b.g.anm();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      l = com.tencent.mm.live.b.g.ans().Fsa;
      localObject2 = com.tencent.mm.live.b.g.gOr;
      i = com.tencent.mm.live.b.g.anQ();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      j = com.tencent.mm.live.b.g.anS();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      k = com.tencent.mm.live.b.g.ans().GzV;
      localObject2 = com.tencent.mm.live.b.g.gOr;
      m = com.tencent.mm.live.b.g.anT();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      n = com.tencent.mm.live.b.g.anU();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      i1 = com.tencent.mm.live.b.g.anV();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      i2 = com.tencent.mm.live.b.g.anW();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, com.tencent.mm.live.b.g.ans().GOK);
      localObject1 = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.anA();
      localObject1 = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.aoj();
      localObject1 = i.gPh;
      i.aoq();
      continue;
      localObject1 = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.aoj();
      localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.b.g.gOr;
      ((com.tencent.mm.live.b.c.c)localObject1).rn(com.tencent.mm.live.b.g.ans().Fsa);
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(213027);
        throw paramc;
      }
      ((Activity)localObject1).setRequestedOrientation(1);
      continue;
      if (paramBundle != null) {}
      for (localObject1 = Boolean.valueOf(paramBundle.getBoolean("PARAM_LIVE_START_BY_ORIENTATION_CHANGE", false));; localObject1 = null)
      {
        if (p.i(localObject1, Boolean.FALSE))
        {
          this.haI.azX();
          i.gPh.aos();
          localObject1 = i.gPh;
          i.aon();
          localObject1 = i.gPh;
          i.aor();
        }
        localObject1 = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.aoh();
        localObject1 = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.dP(false);
        break;
      }
      localObject1 = com.tencent.mm.live.b.g.gOr;
      if (!com.tencent.mm.live.b.g.anG().gOz)
      {
        localObject1 = com.tencent.mm.live.b.g.gOr;
        if (!com.tencent.mm.live.b.g.anG().gOB)
        {
          localObject1 = this.hao;
          if (localObject1 != null)
          {
            ((com.tencent.mm.live.c.ai)localObject1).nI(0);
            localObject1 = d.z.MKo;
          }
          localObject1 = this.hao;
          if (localObject1 != null)
          {
            ((com.tencent.mm.live.c.ai)localObject1).aoR();
            localObject1 = d.z.MKo;
            continue;
            localObject1 = com.tencent.mm.live.b.c.gMO;
            com.tencent.mm.live.b.c.amR();
            i.gPh.release();
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(213027);
              throw paramc;
            }
            ((Activity)localObject1).finishAndRemoveTask();
            continue;
            localObject1 = com.tencent.mm.live.b.g.gOr;
            localObject1 = com.tencent.mm.live.b.g.ans().Gbw;
            p.g(localObject1, "LiveDataManager.liveInfo.live_name");
            localObject2 = com.tencent.mm.live.b.g.gOr;
            l = com.tencent.mm.live.b.g.ans().Fsa;
            localObject2 = com.tencent.mm.live.b.g.gOr;
            c((String)localObject1, l, com.tencent.mm.live.b.g.anm());
            continue;
            localObject2 = this.hbw;
            if (localObject2 != null)
            {
              localObject1 = this.hbC;
              if (localObject1 != null) {}
              for (localObject1 = ((bc)localObject1).aoY();; localObject1 = null)
              {
                ((bk)localObject2).gXW = ((j)localObject1);
                break;
              }
              if (this.haH)
              {
                localObject1 = getContext();
                if (localObject1 == null)
                {
                  paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                  AppMethodBeat.o(213027);
                  throw paramc;
                }
                ((Activity)localObject1).setRequestedOrientation(4);
                continue;
                localObject1 = getContext();
                if (localObject1 == null)
                {
                  paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                  AppMethodBeat.o(213027);
                  throw paramc;
                }
                ((Activity)localObject1).setRequestedOrientation(14);
                continue;
                localObject1 = com.tencent.mm.live.b.g.gOr;
                localObject1 = com.tencent.mm.live.b.g.anw();
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gHB;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.core.core.b.b)localObject1).gHu = true;
                  }
                }
                if (this.haH)
                {
                  localObject1 = getContext();
                  if (localObject1 == null)
                  {
                    paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(213027);
                    throw paramc;
                  }
                  ((Activity)localObject1).setRequestedOrientation(4);
                }
                i = this.gHy;
                localObject1 = c.a.gGU;
                if (i == c.a.all())
                {
                  localObject1 = this.hbw;
                  if (localObject1 != null)
                  {
                    ((bk)localObject1).exitRoom();
                    localObject1 = d.z.MKo;
                  }
                  localObject1 = this.hbx;
                  if (localObject1 != null)
                  {
                    ((aw)localObject1).nI(0);
                    localObject1 = d.z.MKo;
                  }
                  localObject1 = this.hbx;
                  if (localObject1 != null)
                  {
                    localObject1 = ((aw)localObject1).gMP;
                    if (localObject1 != null) {
                      ((TXLivePlayer)localObject1).resume();
                    }
                    localObject1 = d.z.MKo;
                  }
                }
                localObject1 = this.haw;
                if (localObject1 != null)
                {
                  this.haF.remove(localObject1);
                  continue;
                  localObject1 = this.haw;
                  if (localObject1 != null)
                  {
                    this.haF.remove(localObject1);
                    continue;
                    i = this.gHy;
                    localObject1 = c.a.gGU;
                    if (i == c.a.alk())
                    {
                      aqE();
                    }
                    else
                    {
                      localObject1 = c.a.gGU;
                      if (i == c.a.all())
                      {
                        localObject1 = com.tencent.mm.live.b.g.gOr;
                        localObject1 = com.tencent.mm.live.b.g.anw();
                        if (localObject1 != null)
                        {
                          localObject2 = this.hbw;
                          if (localObject2 != null)
                          {
                            ((bk)localObject2).a((com.tencent.mm.live.core.core.b.d)localObject1, (d.g.a.b)new p(this));
                            localObject1 = d.z.MKo;
                            continue;
                            localObject1 = com.tencent.mm.live.b.g.gOr;
                            com.tencent.mm.live.b.g.aoi();
                            localObject1 = i.gPh;
                            i.aoo();
                            localObject1 = com.tencent.mm.live.b.c.gMO;
                            com.tencent.mm.live.b.c.amR();
                            i.gPh.release();
                            localObject1 = this.han;
                            if (localObject1 != null)
                            {
                              ((ay)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hak;
                            if (localObject1 != null)
                            {
                              ((as)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hai;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.c)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hbA;
                            if (localObject1 != null)
                            {
                              ((bg)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hbz;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.z)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hby;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.v)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hao;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.ai)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hav;
                            if (localObject1 != null)
                            {
                              ((ae)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hbw;
                            if (localObject1 != null)
                            {
                              ((bk)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hbx;
                            if (localObject1 != null)
                            {
                              ((aw)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hbC;
                            if (localObject1 != null)
                            {
                              ((bc)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hay;
                            if (localObject1 != null)
                            {
                              ((ag)localObject1).nI(8);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hbD;
                            if (localObject1 != null)
                            {
                              ((ab)localObject1).nI(0);
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hbD;
                            Object localObject3;
                            if (localObject1 != null)
                            {
                              localObject2 = com.tencent.mm.live.b.g.gOr;
                              localObject2 = com.tencent.mm.live.b.g.anu();
                              localObject3 = com.tencent.mm.live.b.d.a.gRe;
                              localObject3 = ((com.tencent.mm.live.c.a)localObject1).gGK.getContext();
                              p.g(localObject3, "root.context");
                              com.tencent.mm.live.b.d.a.a.a((String)localObject2, ((Context)localObject3).getResources().getColor(2131100482), (d.g.a.b)new ab.a((ab)localObject1));
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.gXF;
                            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt.alE() != true))
                            {
                              localObject1 = this.gXF;
                              if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt.alF() != true))
                              {
                                i = this.gHy;
                                localObject1 = c.a.gGU;
                                if (i != c.a.alk()) {
                                  break label1860;
                                }
                              }
                            }
                            localObject1 = this.gXF;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.core.core.c.b)localObject1).amf();
                              localObject1 = d.z.MKo;
                            }
                            localObject1 = this.hbw;
                            if (localObject1 != null)
                            {
                              ((bk)localObject1).exitRoom();
                              localObject1 = d.z.MKo;
                              continue;
                              label1860:
                              localObject1 = this.hbx;
                              if (localObject1 != null)
                              {
                                ((aw)localObject1).aoV();
                                localObject1 = d.z.MKo;
                                continue;
                                localObject1 = com.tencent.mm.live.b.g.gOr;
                                com.tencent.mm.live.b.g.nw(2);
                                localObject1 = com.tencent.mm.live.b.g.gOr;
                                if (!com.tencent.mm.live.b.g.anG().gOz)
                                {
                                  localObject1 = com.tencent.mm.live.b.g.gOr;
                                  if (!com.tencent.mm.live.b.g.anG().gOB)
                                  {
                                    localObject1 = this.hav;
                                    if (localObject1 != null)
                                    {
                                      localObject2 = com.tencent.mm.live.b.g.gOr;
                                      localObject2 = com.tencent.mm.live.b.g.anu();
                                      localObject3 = getContext();
                                      p.g(localObject3, "context");
                                      localObject3 = ((Context)localObject3).getResources().getString(2131766622);
                                      p.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
                                      ((ae)localObject1).at((String)localObject2, (String)localObject3);
                                      localObject1 = d.z.MKo;
                                    }
                                    localObject1 = com.tencent.mm.live.b.g.gOr;
                                    com.tencent.mm.live.b.g.aoi();
                                    continue;
                                    localObject1 = com.tencent.mm.live.b.g.gOr;
                                    com.tencent.mm.live.b.g.nw(1);
                                    localObject1 = com.tencent.mm.live.b.g.gOr;
                                    if (!com.tencent.mm.live.b.g.anG().gOz)
                                    {
                                      localObject1 = com.tencent.mm.live.b.g.gOr;
                                      if (!com.tencent.mm.live.b.g.anG().gOB)
                                      {
                                        localObject1 = this.hav;
                                        if (localObject1 != null)
                                        {
                                          localObject2 = com.tencent.mm.live.b.g.gOr;
                                          localObject2 = com.tencent.mm.live.b.g.anu();
                                          localObject3 = getContext();
                                          p.g(localObject3, "context");
                                          localObject3 = ((Context)localObject3).getResources().getString(2131766568);
                                          p.g(localObject3, "context.resources.getStr…ive_anchor_exception_tip)");
                                          ((ae)localObject1).at((String)localObject2, (String)localObject3);
                                          localObject1 = d.z.MKo;
                                          continue;
                                          localObject1 = this.hbw;
                                          if (localObject1 != null)
                                          {
                                            ((bk)localObject1).nI(0);
                                            localObject1 = d.z.MKo;
                                          }
                                          localObject1 = this.hbw;
                                          if (localObject1 != null)
                                          {
                                            ((bk)localObject1).apd();
                                            localObject1 = d.z.MKo;
                                          }
                                          localObject1 = this.hbx;
                                          if (localObject1 != null)
                                          {
                                            ((aw)localObject1).nI(8);
                                            localObject1 = d.z.MKo;
                                          }
                                          localObject1 = this.hbx;
                                          if (localObject1 != null)
                                          {
                                            localObject1 = ((aw)localObject1).gMP;
                                            if (localObject1 != null) {
                                              ((TXLivePlayer)localObject1).pause();
                                            }
                                            localObject1 = d.z.MKo;
                                            continue;
                                            localObject1 = this.hav;
                                            if (localObject1 != null)
                                            {
                                              ((ae)localObject1).nI(8);
                                              localObject1 = d.z.MKo;
                                              continue;
                                              localObject1 = this.gXF;
                                              if (localObject1 != null)
                                              {
                                                localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt;
                                                if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.e)localObject1).isFloatMode()))
                                                {
                                                  localObject1 = this.gXF;
                                                  if (localObject1 != null)
                                                  {
                                                    localObject2 = getContext();
                                                    p.g(localObject2, "context");
                                                    ((com.tencent.mm.live.core.core.c.b)localObject1).cp((Context)localObject2);
                                                  }
                                                  localObject1 = com.tencent.mm.live.b.g.gOr;
                                                  localObject1 = com.tencent.mm.live.b.g.anm();
                                                  localObject2 = com.tencent.mm.live.b.g.gOr;
                                                  l = com.tencent.mm.live.b.g.ans().Fsa;
                                                  localObject2 = com.tencent.mm.live.b.g.gOr;
                                                  com.tencent.mm.live.d.e.a((String)localObject1, l, com.tencent.mm.live.b.g.anu(), 2, 1);
                                                  com.tencent.mm.live.d.f.aqd();
                                                  continue;
                                                  localObject1 = com.tencent.mm.live.b.g.gOr;
                                                  localObject1 = com.tencent.mm.live.b.g.anm();
                                                  localObject2 = com.tencent.mm.live.b.g.gOr;
                                                  l = com.tencent.mm.live.b.g.ans().Fsa;
                                                  localObject2 = com.tencent.mm.live.b.g.gOr;
                                                  com.tencent.mm.live.d.e.a((String)localObject1, l, com.tencent.mm.live.b.g.anu(), 2, 0);
                                                  com.tencent.mm.live.d.f.aqe();
                                                  continue;
                                                  localObject1 = this.gXF;
                                                  if (localObject1 != null)
                                                  {
                                                    localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt;
                                                    if (localObject1 != null)
                                                    {
                                                      ((com.tencent.mm.live.core.core.b.e)localObject1).gHL = e.d.gIb;
                                                      localObject1 = d.z.MKo;
                                                      continue;
                                                      localObject1 = this.gXF;
                                                      if (localObject1 != null)
                                                      {
                                                        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt;
                                                        if (localObject1 != null)
                                                        {
                                                          ((com.tencent.mm.live.core.core.b.e)localObject1).gHL = e.d.gId;
                                                          localObject1 = d.z.MKo;
                                                          continue;
                                                          localObject1 = this.hbw;
                                                          if (localObject1 != null)
                                                          {
                                                            localObject2 = com.tencent.mm.live.b.g.gOr;
                                                            if (com.tencent.mm.live.b.g.anJ().aol()) {}
                                                            for (;;)
                                                            {
                                                              localObject2 = com.tencent.mm.live.b.g.gOr;
                                                              localObject2 = com.tencent.mm.live.b.g.anJ().userId;
                                                              localObject3 = com.tencent.mm.live.b.g.gOr;
                                                              ((bk)localObject1).c(i, (String)localObject2, com.tencent.mm.live.b.g.anJ().streamType);
                                                              localObject1 = d.z.MKo;
                                                              break;
                                                              i = 1;
                                                            }
                                                            localObject1 = this.gXF;
                                                            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.c.b)localObject1).alG() != true))
                                                            {
                                                              localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
                                                              localObject2 = com.tencent.mm.live.b.g.gOr;
                                                              ((com.tencent.mm.live.b.c.c)localObject1).xQ(com.tencent.mm.live.b.g.anm());
                                                              localObject1 = com.tencent.mm.live.b.g.gOr;
                                                              com.tencent.mm.live.b.g.anA();
                                                              localObject1 = this.gXF;
                                                              if (localObject1 != null)
                                                              {
                                                                ((com.tencent.mm.live.core.core.c.b)localObject1).alg();
                                                                localObject1 = d.z.MKo;
                                                                continue;
                                                                if (!aol())
                                                                {
                                                                  if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                                  {
                                                                    localObject1 = this.hal;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      localObject1 = ((com.tencent.mm.live.c.a)localObject1).gGK;
                                                                      if (localObject1 == null) {}
                                                                    }
                                                                    for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                                    {
                                                                      ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
                                                                      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
                                                                      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
                                                                      localObject1 = this.hal;
                                                                      if (localObject1 == null) {
                                                                        break;
                                                                      }
                                                                      localObject1 = ((com.tencent.mm.live.c.a)localObject1).gGK;
                                                                      if (localObject1 == null) {
                                                                        break;
                                                                      }
                                                                      ((ViewGroup)localObject1).requestLayout();
                                                                      localObject1 = d.z.MKo;
                                                                      break;
                                                                    }
                                                                  }
                                                                  localObject1 = this.hal;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    localObject1 = ((com.tencent.mm.live.c.a)localObject1).gGK;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      localObject1 = ((ViewGroup)localObject1).getLayoutParams();
                                                                      label2779:
                                                                      if ((localObject1 == null) || (!(localObject1 instanceof RelativeLayout.LayoutParams))) {
                                                                        continue;
                                                                      }
                                                                      ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
                                                                      localObject2 = (RelativeLayout.LayoutParams)localObject1;
                                                                      localObject3 = this.hbA;
                                                                      if (localObject3 == null) {
                                                                        break label2904;
                                                                      }
                                                                      localObject3 = ((com.tencent.mm.live.c.a)localObject3).gGK;
                                                                      if (localObject3 == null) {
                                                                        break label2904;
                                                                      }
                                                                    }
                                                                  }
                                                                  label2904:
                                                                  for (i = ((ViewGroup)localObject3).getId();; i = 0)
                                                                  {
                                                                    ((RelativeLayout.LayoutParams)localObject2).addRule(2, i);
                                                                    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = aq.fromDPToPix(getContext(), 12);
                                                                    localObject1 = this.hal;
                                                                    if (localObject1 == null) {
                                                                      break;
                                                                    }
                                                                    localObject1 = ((com.tencent.mm.live.c.a)localObject1).gGK;
                                                                    if (localObject1 == null) {
                                                                      break;
                                                                    }
                                                                    ((ViewGroup)localObject1).requestLayout();
                                                                    localObject1 = d.z.MKo;
                                                                    break;
                                                                    localObject1 = null;
                                                                    break label2779;
                                                                  }
                                                                }
                                                                else if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                                {
                                                                  localObject1 = this.hal;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    ((com.tencent.mm.live.c.m)localObject1).nI(4);
                                                                    localObject1 = d.z.MKo;
                                                                  }
                                                                }
                                                                else
                                                                {
                                                                  localObject1 = this.hal;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    ((com.tencent.mm.live.c.m)localObject1).nI(0);
                                                                    localObject1 = d.z.MKo;
                                                                    continue;
                                                                    if (!aol())
                                                                    {
                                                                      localObject1 = this.hbz;
                                                                      if ((localObject1 != null) && (((com.tencent.mm.live.c.a)localObject1).gGK.getVisibility() == 0))
                                                                      {
                                                                        i = j;
                                                                        if (paramBundle != null) {
                                                                          i = paramBundle.getInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT");
                                                                        }
                                                                        localObject1 = this.hal;
                                                                        if (localObject1 != null)
                                                                        {
                                                                          localObject1 = ((com.tencent.mm.live.c.a)localObject1).gGK;
                                                                          if (localObject1 == null) {}
                                                                        }
                                                                        for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                                        {
                                                                          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i;
                                                                          localObject1 = this.hal;
                                                                          if (localObject1 == null) {
                                                                            break;
                                                                          }
                                                                          localObject1 = ((com.tencent.mm.live.c.a)localObject1).gGK;
                                                                          if (localObject1 == null) {
                                                                            break;
                                                                          }
                                                                          ((ViewGroup)localObject1).requestLayout();
                                                                          localObject1 = d.z.MKo;
                                                                          break;
                                                                        }
                                                                        localObject1 = com.tencent.mm.live.b.g.gOr;
                                                                        if (!com.tencent.mm.live.b.g.anG().gOz)
                                                                        {
                                                                          localObject1 = this.hbw;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((bk)localObject1).nI(8);
                                                                            localObject1 = d.z.MKo;
                                                                          }
                                                                          localObject1 = this.hag;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((t)localObject1).nI(8);
                                                                            localObject1 = d.z.MKo;
                                                                          }
                                                                          localObject1 = this.hav;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((ae)localObject1).nI(8);
                                                                            localObject1 = d.z.MKo;
                                                                          }
                                                                          localObject1 = this.haA;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((com.tencent.mm.live.c.r)localObject1).nI(0);
                                                                            localObject1 = d.z.MKo;
                                                                          }
                                                                          localObject1 = com.tencent.mm.live.b.g.gOr;
                                                                          com.tencent.mm.live.b.g.aoi();
                                                                          localObject1 = getContext();
                                                                          if (localObject1 == null)
                                                                          {
                                                                            paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                                                                            AppMethodBeat.o(213027);
                                                                            throw paramc;
                                                                          }
                                                                          ((Activity)localObject1).setRequestedOrientation(1);
                                                                          continue;
                                                                          localObject1 = com.tencent.mm.live.b.g.gOr;
                                                                          com.tencent.mm.live.b.g.anG().gOC = true;
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
  
  public final void aoA()
  {
    AppMethodBeat.i(213034);
    super.aoA();
    Object localObject1 = com.tencent.mm.live.b.g.gOr;
    int i;
    Object localObject2;
    if (com.tencent.mm.live.b.g.anB() != -1)
    {
      localObject1 = com.tencent.mm.live.b.g.gOr;
      i = com.tencent.mm.live.b.g.anB();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(213034);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.g(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
      if (i != ((Display)localObject1).getRotation())
      {
        i = 1;
        if (i == 0)
        {
          localObject1 = this.hbx;
          if (localObject1 != null) {
            ((aw)localObject1).aoV();
          }
          localObject1 = com.tencent.mm.live.b.c.gMO;
          com.tencent.mm.live.b.c.amR();
          localObject1 = i.gPh;
          i.aoo();
          i.gPh.release();
          localObject1 = this.gXF;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.c.b)localObject1).alh();
          }
          localObject1 = this.gXF;
          if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt.alF() != true))
          {
            localObject1 = this.gXF;
            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt.alE() != true)) {
              break label306;
            }
          }
          localObject1 = com.tencent.mm.live.b.g.gOr;
          localObject1 = com.tencent.mm.live.b.g.aod().gQP;
          if (localObject1 != null)
          {
            localObject2 = i.gPh;
            i.as(((com.tencent.mm.live.b.b.a.a)localObject1).gQS, ((com.tencent.mm.live.b.b.a.a)localObject1).gQU);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("PARAM_HANGUP_SELF", true);
          a(b.c.gRE, (Bundle)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.Zh();
      localObject1 = com.tencent.mm.live.core.core.c.b.gKd;
      localObject1 = com.tencent.mm.live.core.core.c.b.ami();
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject1).release();
      }
      com.tencent.mm.live.core.core.c.b.e(null);
      this.haI.abe();
      localObject1 = com.tencent.mm.kernel.g.ajB();
      p.g(localObject1, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject1).aiU().b(3806, (com.tencent.mm.al.f)this);
      AppMethodBeat.o(213034);
      return;
      i = 0;
      break;
      label306:
      localObject1 = this.hby;
      if ((localObject1 != null) && (((com.tencent.mm.live.c.v)localObject1).gUE.gXG == true))
      {
        localObject1 = i.gPh;
        localObject1 = com.tencent.mm.live.b.g.gOr;
        String str = com.tencent.mm.live.b.g.aod().gQQ;
        localObject1 = com.tencent.mm.live.b.g.gOr;
        localObject2 = com.tencent.mm.live.b.g.ans().GOI;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        i.as(str, (String)localObject1);
      }
    }
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(213035);
    boolean bool2 = super.aoB();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
      bool1 = bool2;
      if (com.tencent.mm.live.b.g.anG().gOA)
      {
        localg = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.anG().gOA = false;
        b.b.a(this, b.c.gRv);
        bool1 = true;
      }
    }
    AppMethodBeat.o(213035);
    return bool1;
  }
  
  public final void aoz()
  {
    AppMethodBeat.i(213033);
    super.aoz();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().a(3806, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(213033);
  }
  
  public final void dW(boolean paramBoolean)
  {
    this.haH = paramBoolean;
  }
  
  public final void f(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(213038);
    ad.i("MicroMsg.LiveCoreVisitor", "callback:".concat(String.valueOf(paramInt)));
    Object localObject4 = c.b.gHd;
    if (paramInt == c.b.alm())
    {
      b.b.a(this, b.c.gRR);
      AppMethodBeat.o(213038);
      return;
    }
    localObject4 = c.b.gHd;
    if (paramInt == c.b.aln())
    {
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getString("live_user_id");
        paramBundle.getString("live_user_exit_reason");
        localObject3 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
        paramBundle = com.tencent.mm.live.b.g.gOr;
        paramBundle = com.tencent.mm.live.b.g.aod().gQP;
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.gQU;; paramBundle = null)
        {
          ad.i("MicroMsg.LiveCoreAnchor", paramBundle);
          paramBundle = com.tencent.mm.live.b.g.gOr;
          localObject3 = com.tencent.mm.live.b.g.aod().gQP;
          paramBundle = (Bundle)localObject1;
          if (localObject3 != null) {
            paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject3).gQU;
          }
          if (!p.i(localObject2, paramBundle))
          {
            paramBundle = com.tencent.mm.live.b.g.gOr;
            if (!p.i(localObject2, com.tencent.mm.live.b.g.ans().GOJ)) {}
          }
          else
          {
            paramBundle = com.tencent.mm.live.b.g.gOr;
            paramBundle = com.tencent.mm.live.b.g.aod().gQP;
            if (paramBundle != null)
            {
              localObject1 = this.hbw;
              if (localObject1 != null)
              {
                localObject1 = ((bk)localObject1).gIn;
                if (localObject1 != null) {
                  ((LivePreviewView)localObject1).clearAnimation();
                }
              }
              localObject1 = com.tencent.mm.live.b.g.gOr;
              com.tencent.mm.live.b.g.aod().a(paramBundle.gGy, paramBundle.gQT, paramBundle.gQS);
            }
          }
          paramBundle = com.tencent.mm.live.b.g.gOr;
          if (p.i(localObject2, com.tencent.mm.live.b.g.ans().GOJ))
          {
            this.hbF = true;
            b.b.a(this, b.c.gSi);
          }
          AppMethodBeat.o(213038);
          return;
        }
      }
      AppMethodBeat.o(213038);
      return;
    }
    localObject1 = c.b.gHd;
    if (paramInt == c.b.alo()) {
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getString("live_user_id");
        if (paramBundle.getBoolean("live_media_enable"))
        {
          paramBundle = com.tencent.mm.live.b.g.gOr;
          localObject3 = com.tencent.mm.live.b.g.aod();
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
      ((com.tencent.mm.live.b.b.a)localObject3).gQR = paramBundle;
      localObject4 = ((com.tencent.mm.live.b.b.a)localObject3).gQP;
      paramBundle = (Bundle)localObject2;
      if (localObject4 != null) {
        paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject4).gQU;
      }
      if ((p.i(localObject1, paramBundle)) && (!((com.tencent.mm.live.b.b.a)localObject3).aov()))
      {
        paramBundle = ((com.tencent.mm.live.b.b.a)localObject3).gQM;
        if (paramBundle != null)
        {
          paramBundle.invoke();
          AppMethodBeat.o(213038);
          return;
        }
      }
      AppMethodBeat.o(213038);
      return;
      b.b.a(this, b.c.gRE);
      AppMethodBeat.o(213038);
      return;
      AppMethodBeat.o(213038);
      return;
      localObject1 = c.b.gHd;
      long l;
      if (paramInt == c.b.alq())
      {
        paramBundle = this.gXF;
        int k;
        if ((paramBundle != null) && (paramBundle.gIt.alF() == true))
        {
          i = 1;
          k = this.gHy;
          paramBundle = c.a.gGU;
          if (k != c.a.alk()) {
            break label636;
          }
          j = 2;
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
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.b.g.anu(), i, j, paramInt);
          AppMethodBeat.o(213038);
          return;
          paramBundle = this.gXF;
          if ((paramBundle != null) && (paramBundle.gIt.alE() == true))
          {
            i = 2;
            break;
          }
          i = 0;
          break;
          label636:
          paramBundle = c.a.gGU;
          if (k == c.a.all()) {
            j = 1;
          }
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
        p.g(localObject1, "LiveDataManager.liveInfo.live_name");
        new com.tencent.mm.live.b.a(l, paramBundle, (String)localObject1, (byte)0).a((d.g.a.r)new b(this));
        AppMethodBeat.o(213038);
        return;
      }
      localObject1 = c.b.gHd;
      if (paramInt == c.b.alt())
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
        localObject4 = this.gXF;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject4).gIt;
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = ((com.tencent.mm.live.core.core.b.e)localObject4).gHN;
          }
        }
        if (!bt.lQ((String)localObject1, (String)localObject2))
        {
          localObject2 = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.b.g.anJ().setUserId((String)localObject1);
          localObject1 = com.tencent.mm.live.b.g.gOr;
          localObject1 = com.tencent.mm.live.b.g.anJ();
          if (paramBundle != null)
          {
            paramInt = paramBundle.getInt("live_stream_type");
            ((g.c)localObject1).streamType = paramInt;
            localObject1 = com.tencent.mm.live.b.g.gOr;
            localObject1 = com.tencent.mm.live.b.g.anJ();
            if (paramBundle == null) {
              break label946;
            }
          }
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
            AppMethodBeat.o(213038);
            return;
            paramInt = 0;
            break;
          }
        }
        this.hbF = false;
      }
      AppMethodBeat.o(213038);
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
    AppMethodBeat.i(213037);
    super.i(paramBoolean, paramInt);
    AppMethodBeat.o(213037);
  }
  
  public final String name()
  {
    AppMethodBeat.i(213028);
    String str = LiveVisitorPluginLayout.class.getSimpleName();
    p.g(str, "LiveVisitorPluginLayout::class.java.simpleName");
    AppMethodBeat.o(213028);
    return str;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(213022);
    p.h(paramString, "incomingNumber");
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.gXF;
    if (paramString != null)
    {
      paramString = paramString.gIt;
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.isFloatMode());
        ad.i("MicroMsg.LiveCoreVisitor", paramString);
        switch (paramInt)
        {
        }
      }
    }
    do
    {
      AppMethodBeat.o(213022);
      return;
      paramString = null;
      break;
      AppMethodBeat.o(213022);
      return;
      paramString = i.gPh;
      i.aoo();
      paramString = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.anA();
      paramString = this.gXF;
      if ((paramString != null) && (paramString.gIt.alE() == true))
      {
        paramString = this.gXF;
        if (paramString != null) {
          paramString.alc();
        }
      }
      paramString = this.gXF;
    } while (paramString == null);
    paramString.alg();
    AppMethodBeat.o(213022);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(213036);
    ad.i("MicroMsg.LiveCoreVisitor", "errType:" + paramInt1 + " errCode:" + paramInt2);
    if (((paramn instanceof com.tencent.mm.live.b.a.b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.hbA;
      if (paramString != null) {
        paramString.aoZ();
      }
      paramn = this.han;
      if (paramn != null)
      {
        paramString = com.tencent.mm.live.b.g.gOr;
        paramString = com.tencent.mm.live.b.g.ans().Gbw;
        if (paramString == null) {
          break label145;
        }
        paramString = (CharSequence)paramString;
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
        paramn.a(paramString, com.tencent.mm.live.b.g.anu());
      }
      paramString = com.tencent.mm.live.b.g.gOr;
      paramString = com.tencent.mm.live.b.g.gOr;
      if (com.tencent.mm.live.b.g.ans().FBr) {
        break label155;
      }
    }
    label145:
    label155:
    for (paramInt1 = cf.aCN();; paramInt1 = 0)
    {
      com.tencent.mm.live.b.g.nt(paramInt1);
      AppMethodBeat.o(213036);
      return;
      paramString = (CharSequence)"";
      break;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(213032);
    super.pause();
    Object localObject1 = com.tencent.mm.live.b.g.gOr;
    if (com.tencent.mm.live.b.g.anB() != -1)
    {
      localObject1 = com.tencent.mm.live.b.g.gOr;
      int i = com.tencent.mm.live.b.g.anB();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(213032);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.g(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
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
      AppMethodBeat.o(213032);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
    p.g(localObject2, "((context.getSystemServi…owManager).defaultDisplay");
    ad.i("MicroMsg.LiveCoreVisitor", ((Display)localObject2).getRotation());
    if (!bool)
    {
      localObject1 = com.tencent.mm.live.b.g.gOr;
      if (!com.tencent.mm.live.b.g.anG().gOz)
      {
        localObject1 = com.tencent.mm.live.b.g.gOr;
        if (!com.tencent.mm.live.b.g.anG().gOB)
        {
          localObject1 = com.tencent.mm.live.b.g.gOr;
          if (!com.tencent.mm.live.b.g.anG().gOC)
          {
            localObject1 = com.tencent.mm.live.b.g.gOr;
            if (com.tencent.mm.live.b.g.anG().gOA)
            {
              localObject1 = com.tencent.mm.live.b.g.gOr;
              if ((!com.tencent.mm.live.b.g.anz()) && (com.tencent.mm.compatible.d.b.ca(getContext()))) {
                b.b.a(this, b.c.gRJ);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = this.gXF;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt;
      if (localObject1 == null) {
        break;
      }
      if (((com.tencent.mm.live.core.core.b.e)localObject1).alE() != true) {
        break label369;
      }
      localObject1 = this.gXF;
      if (localObject1 == null) {
        break label369;
      }
      ((com.tencent.mm.live.core.core.c.b)localObject1).alc();
      AppMethodBeat.o(213032);
      return;
      localObject1 = this.gXF;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).alC() == true))
        {
          localObject1 = this.gXF;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.c.b)localObject1).amf();
          }
        }
      }
    }
    AppMethodBeat.o(213032);
    return;
    label369:
    AppMethodBeat.o(213032);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(213031);
    Object localObject1 = com.tencent.mm.live.b.g.gOr;
    com.tencent.mm.live.b.g.anG().gOC = false;
    localObject1 = getContext().getSystemService("window");
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(213031);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
    p.g(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
    int j = ((Display)localObject1).getRotation();
    localObject1 = new StringBuilder("curOrientation:").append(j).append(", lastOrientation:");
    Object localObject2 = com.tencent.mm.live.b.g.gOr;
    ad.i("MicroMsg.LiveCoreVisitor", com.tencent.mm.live.b.g.anB());
    super.resume();
    localObject1 = this.gXF;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt;
      if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).alC() == true))
      {
        localObject1 = this.gXF;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).amg();
        }
      }
    }
    localObject1 = com.tencent.mm.live.b.g.gOr;
    int i;
    if (com.tencent.mm.live.b.g.anB() != -1)
    {
      localObject1 = com.tencent.mm.live.b.g.gOr;
      if (j != com.tencent.mm.live.b.g.anB())
      {
        localObject1 = this.gXF;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).amc();
        }
        localObject1 = this.hbw;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.live.b.g.gOr;
          if (!com.tencent.mm.live.b.g.anJ().aol()) {
            break label320;
          }
          i = 2;
          localObject2 = com.tencent.mm.live.b.g.gOr;
          localObject2 = com.tencent.mm.live.b.g.anJ().userId;
          com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
          ((bk)localObject1).c(i, (String)localObject2, com.tencent.mm.live.b.g.anJ().streamType);
        }
      }
    }
    for (;;)
    {
      localObject1 = this.gXF;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).alE() == true))
        {
          localObject1 = this.hbw;
          if (localObject1 != null)
          {
            localObject2 = ((bk)localObject1).gXF;
            if (localObject2 != null) {
              ((com.tencent.mm.live.core.core.c.b)localObject2).a(((bk)localObject1).gIn);
            }
          }
        }
      }
      localObject1 = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.nu(j);
      AppMethodBeat.o(213031);
      return;
      label320:
      i = 1;
      break;
      localObject1 = this.gXF;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt;
        if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.e)localObject1).gHI))
        {
          localObject1 = this.gXF;
          if (localObject1 == null) {
            continue;
          }
          ((com.tencent.mm.live.core.core.c.b)localObject1).ale();
          continue;
        }
      }
      localObject1 = this.gXF;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gIt;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.b.e)localObject1).gHI = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(213030);
    super.start();
    Object localObject = i.gPh;
    i.aoq();
    localObject = this.gXF;
    if (((localObject == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject).gIt.alE() != true)) && (this.haH))
    {
      localObject = com.tencent.mm.live.b.g.gOr;
      if (!com.tencent.mm.live.b.g.anG().gOz)
      {
        localObject = com.tencent.mm.live.b.g.gOr;
        if (!com.tencent.mm.live.b.g.anG().gOB)
        {
          localObject = getContext();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(213030);
            throw ((Throwable)localObject);
          }
          ((Activity)localObject).setRequestedOrientation(4);
        }
      }
    }
    AppMethodBeat.o(213030);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, d.z>
  {
    b(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.b<Boolean, d.z>
  {
    c(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<Boolean, d.z>
  {
    d(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, d.z>
  {
    e(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class g
    implements DialogInterface.OnDismissListener
  {
    g(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(213007);
      paramDialogInterface = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.aoi();
      b.b.a(this.hbH, b.c.gRw);
      AppMethodBeat.o(213007);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class i
    implements DialogInterface.OnDismissListener
  {
    i(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(213009);
      paramDialogInterface = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.aoi();
      b.b.a(this.hbH, b.c.gRw);
      AppMethodBeat.o(213009);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/view/LiveVisitorPluginLayout$handleJoinLiveErr$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
  public static final class j
    extends com.tencent.mm.plugin.messenger.a.a
  {
    j(int paramInt) {}
    
    public final void onClickImp(View paramView)
    {
      AppMethodBeat.i(213010);
      p.h(paramView, "widget");
      paramView = new Intent();
      f.a locala = com.tencent.mm.live.b.f.gMV;
      paramView.putExtra("rawUrl", com.tencent.mm.live.b.f.amU());
      paramView.putExtra("showShare", false);
      com.tencent.mm.bs.d.f(this.hbH.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(213010);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.m<Float, Float, d.z>
  {
    k(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.m<Float, Float, d.z>
  {
    l(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "liveID", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.b<Long, d.z>
  {
    m(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    n(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class o
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    o(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/live/view/LiveVisitorPluginLayout$statusChange$3$1"})
  static final class p
    extends d.g.b.q
    implements d.g.a.b<Boolean, d.z>
  {
    p(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.a<d.z>
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