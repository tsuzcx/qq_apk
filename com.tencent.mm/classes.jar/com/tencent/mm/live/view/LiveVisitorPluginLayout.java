package com.tencent.mm.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.db;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.live.b.g.c;
import com.tencent.mm.live.b.g.d;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.c.ab;
import com.tencent.mm.live.c.ab.a;
import com.tencent.mm.live.c.ac;
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
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.b.e.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.model.ch;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.aq;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "anchorExceptionInTRTC", "", "audienceMode", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "liveDebugPlugin", "Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveGuestRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "liveInputPlugin", "Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "liveKickedPlugin", "Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVideoMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "liveVisitorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "liveVisitorCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "navigation", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "pluginShow", "rotationEnable", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkAnchorStatus", "checkClickArea", "x", "", "y", "validCallback", "chooseAudienceMode", "byOrientationChange", "enterRoom", "liveName", "", "roomID", "", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleEnterRoom", "handleJoinLiveErr", "errCode", "errMsg", "initLogic", "router", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "keyboardChange", "show", "height", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "requestLinkMic", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "toggleShowPlugins", "unMount", "updatePlugin", "Companion", "plugin-logic_release"})
public final class LiveVisitorPluginLayout
  extends BaseLivePluginLayout
  implements com.tencent.mm.ak.f, com.tencent.mm.live.core.core.b
{
  public static final LiveVisitorPluginLayout.a heu;
  private int gKh;
  private final d.g.a.a<d.z> gXH;
  private com.tencent.mm.live.core.core.c.b har;
  private t hcT;
  private com.tencent.mm.live.c.c hcV;
  private as hcX;
  private com.tencent.mm.live.c.m hcY;
  private ay hda;
  private ai hdb;
  private o hdf;
  private am hdg;
  private com.tencent.mm.live.c.ae hdi;
  private ak hdj;
  private ac hdk;
  private ag hdl;
  private com.tencent.mm.live.c.r hdn;
  private com.tencent.mm.live.a.a hdo;
  private final ArrayList<com.tencent.mm.live.c.a> hds;
  private boolean hdt;
  private boolean hdu;
  private final com.tencent.mm.model.d hdv;
  private bk hek;
  private aw hel;
  private com.tencent.mm.live.c.v hem;
  private com.tencent.mm.live.c.z hen;
  private bg heo;
  private com.tencent.mm.live.c.q hep;
  private bc heq;
  private ab her;
  private be hes;
  private boolean het;
  
  static
  {
    AppMethodBeat.i(216670);
    heu = new LiveVisitorPluginLayout.a((byte)0);
    AppMethodBeat.o(216670);
  }
  
  public LiveVisitorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216669);
    this.hdt = true;
    paramContext = c.a.gJD;
    this.gKh = c.a.alz();
    this.hds = new ArrayList();
    this.hdv = com.tencent.mm.model.d.aAm();
    this.gXH = ((d.g.a.a)new o(this));
    AppMethodBeat.o(216669);
  }
  
  private final void a(float paramFloat1, float paramFloat2, d.g.a.a<d.z> parama)
  {
    AppMethodBeat.i(216659);
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
      AppMethodBeat.o(216659);
      return;
    }
  }
  
  private final void aqT()
  {
    AppMethodBeat.i(216655);
    Object localObject = com.tencent.mm.live.core.core.c.b.gMM;
    localObject = getContext();
    p.g(localObject, "context");
    com.tencent.mm.live.core.core.c.b.a.ct((Context)localObject).ams();
    localObject = com.tencent.mm.live.core.core.c.b.gMM;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = com.tencent.mm.live.core.core.c.b.a.ct((Context)localObject);
    String str = com.tencent.mm.cb.a.az(getContext(), 2131766707);
    p.g(str, "ResourceHelper.getString…tring.live_room_mini_mic)");
    ((com.tencent.mm.live.core.core.c.b)localObject).xU(str);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:0");
    AppMethodBeat.o(216655);
  }
  
  private final void c(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(216656);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreVisitor", "join, name:" + paramString1 + ", roomID:" + paramLong);
    com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
    new com.tencent.mm.live.b.a(com.tencent.mm.live.b.g.anH().FKy, paramString2, paramString1, (byte)0).a((d.g.a.r)new e(this));
    AppMethodBeat.o(216656);
  }
  
  private final void dZ(final boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(216653);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreVisitor", "audienceMode:" + this.gKh);
    int i = this.gKh;
    Object localObject1 = c.a.gJD;
    if (i == c.a.alz())
    {
      com.tencent.mm.live.d.f.aqA();
      localObject1 = this.hek;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.b.g.gQZ;
        localObject2 = com.tencent.mm.live.b.g.anL();
        if (localObject2 == null) {
          p.gkB();
        }
        ((bk)localObject1).a((com.tencent.mm.live.core.core.b.d)localObject2, (d.g.a.b)new c(this, paramBoolean));
      }
      localObject1 = this.hek;
      if (localObject1 != null)
      {
        ((bk)localObject1).nL(0);
        AppMethodBeat.o(216653);
        return;
      }
      AppMethodBeat.o(216653);
      return;
    }
    localObject1 = c.a.gJD;
    if (i == c.a.alA())
    {
      com.tencent.mm.live.d.f.aqz();
      localObject1 = this.har;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.live.b.g.gQZ;
        localObject3 = com.tencent.mm.live.b.g.anL();
        if (localObject3 == null) {
          p.gkB();
        }
        ((com.tencent.mm.live.core.core.c.b)localObject1).a((com.tencent.mm.live.core.core.b.d)localObject3);
      }
      Object localObject3 = this.hel;
      long l;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        localObject1 = com.tencent.mm.live.b.g.anL();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gKm;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.live.core.core.b.c)localObject1).gKg;
            aw.a((aw)localObject3, (String)localObject1, (d.g.a.b)new d(this, paramBoolean));
          }
        }
      }
      else
      {
        localObject1 = this.hel;
        if (localObject1 != null) {
          ((aw)localObject1).nL(0);
        }
        localObject3 = this.har;
        if (localObject3 == null) {
          break label355;
        }
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        l = com.tencent.mm.live.b.g.anH().FKy;
        localObject1 = this.hel;
        if (localObject1 == null) {
          break label349;
        }
      }
      label349:
      for (localObject1 = ((aw)localObject1).gPy;; localObject1 = null)
      {
        aw localaw = this.hel;
        if (localaw != null) {
          localObject2 = localaw.apk();
        }
        ((com.tencent.mm.live.core.core.c.b)localObject3).a(l, (TXLivePlayer)localObject1, (TXCloudVideoView)localObject2);
        AppMethodBeat.o(216653);
        return;
        localObject1 = null;
        break;
      }
    }
    label355:
    AppMethodBeat.o(216653);
  }
  
  public final void a(com.tencent.mm.live.a.a parama, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(216651);
    p.h(parama, "router");
    p.h(paramLiveConfig, "config");
    Object localObject = com.tencent.mm.live.core.core.c.b.gMM;
    localObject = getContext();
    p.g(localObject, "context");
    this.har = com.tencent.mm.live.core.core.c.b.a.ct((Context)localObject);
    localObject = this.har;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).c((com.tencent.mm.live.core.core.b)this);
    }
    this.hdo = parama;
    parama = com.tencent.mm.live.b.g.gQZ;
    parama = paramLiveConfig.alk();
    p.g(parama, "config.hostRoomId");
    com.tencent.mm.live.b.g.yn(parama);
    parama = com.tencent.mm.live.b.g.gQZ;
    com.tencent.mm.live.b.g.a(new bvk());
    parama = com.tencent.mm.live.b.g.gQZ;
    com.tencent.mm.live.b.g.anH().FKy = paramLiveConfig.alm();
    parama = com.tencent.mm.live.b.g.gQZ;
    com.tencent.mm.live.b.g.yo(paramLiveConfig.all());
    parama = com.tencent.mm.live.b.g.gQZ;
    parama = paramLiveConfig.alo();
    p.g(parama, "config.anchorUsername");
    com.tencent.mm.live.b.g.yp(parama);
    parama = com.tencent.mm.live.b.g.gQZ;
    com.tencent.mm.live.b.g.anH().FTM = true;
    parama = findViewById(2131307768);
    p.g(parama, "findViewById(R.id.live_right_panel_ui_root)");
    this.hem = new com.tencent.mm.live.c.v((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307809);
    p.g(parama, "findViewById(R.id.live_title_ui_root)");
    this.hda = new ay((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307717);
    p.g(parama, "findViewById(R.id.live_minimize_ui_root)");
    this.hdg = new am((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307838);
    p.g(parama, "findViewById(R.id.live_visitor_comment_root)");
    this.heo = new bg((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307644);
    p.g(parama, "findViewById(R.id.live_input_ui_root)");
    this.hen = new com.tencent.mm.live.c.z((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307549);
    p.g(parama, "findViewById(R.id.live_after_ui_root)");
    this.hcV = new com.tencent.mm.live.c.c((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307635);
    p.g(parama, "findViewById(R.id.live_input_debug_view_root)");
    this.hep = new com.tencent.mm.live.c.q((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307652);
    p.g(parama, "findViewById(R.id.live_loading_view_root)");
    this.hdi = new com.tencent.mm.live.c.ae((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307606);
    p.g(parama, "findViewById(R.id.live_comment_ui_root)");
    this.hcY = new com.tencent.mm.live.c.m((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307678);
    p.g(parama, "findViewById(R.id.live_members_list_ui_root)");
    this.hdb = new ai((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307648);
    p.g(parama, "findViewById(R.id.live_like_confetti_ui_root)");
    this.hdk = new ac((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307709);
    p.g(parama, "findViewById(R.id.live_mic_visitor_header_root)");
    this.hdj = new ak((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307719);
    p.g(parama, "findViewById(R.id.live_preview_ui_root)");
    this.hek = new bk((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307811);
    p.g(parama, "findViewById(R.id.live_tx_live_player_ui_root)");
    this.hel = new aw((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307771);
    p.g(parama, "findViewById(R.id.live_shadow_ui_root)");
    this.hcX = new as((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307833);
    p.g(parama, "findViewById(R.id.live_video_mic_ui_root)");
    this.heq = new bc((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307691);
    p.g(parama, "findViewById(R.id.live_members_profile_ui_root)");
    this.hdl = new ag((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307647);
    p.g(parama, "findViewById(R.id.live_kicked_ui_root)");
    this.her = new ab((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307837);
    p.g(parama, "findViewById(R.id.live_visitor_close_ui_root)");
    this.hes = new be((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307617);
    p.g(parama, "findViewById(R.id.live_common_info_ui_root)");
    this.hdf = new o((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307628);
    p.g(parama, "findViewById(R.id.live_exception_ui_root)");
    this.hdn = new com.tencent.mm.live.c.r((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307634);
    p.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
    this.hcT = new t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    localObject = this.hek;
    if (localObject != null)
    {
      parama = this.heq;
      if (parama != null)
      {
        parama = parama.apm();
        ((bk)localObject).haI = parama;
      }
    }
    else
    {
      parama = i.gRP;
      i.a(paramLiveConfig);
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
      localObject = this.hda;
      if (localObject != null)
      {
        parama = com.tencent.mm.live.b.g.gQZ;
        parama = com.tencent.mm.live.b.g.anH().Gud;
        if (parama == null) {
          break label1677;
        }
        parama = (CharSequence)parama;
        label1022:
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
        ((ay)localObject).a(parama, com.tencent.mm.live.b.g.anJ());
      }
      parama = this.hdb;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.hdl;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.hdf;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.hel;
      if (parama != null)
      {
        p.h(paramLiveConfig, "config");
        if (paramLiveConfig.alj() != LiveConfig.gJa) {
          break label1687;
        }
        localObject = com.tencent.mm.live.core.core.a.b.gJU;
        localObject = parama.gJt.getContext();
        p.g(localObject, "root.context");
        parama.gZJ = ((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.cs((Context)localObject));
      }
      label1138:
      localObject = this.heq;
      if (localObject != null)
      {
        p.h(paramLiveConfig, "config");
        if (paramLiveConfig.alj() != LiveConfig.gJa) {
          break label1724;
        }
        parama = com.tencent.mm.live.core.core.a.b.gJU;
        parama = ((com.tencent.mm.live.c.a)localObject).gJt.getContext();
        p.g(parama, "root.context");
        parama = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.cs(parama);
        label1194:
        ((bc)localObject).gZJ = parama;
      }
      parama = this.hdf;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hes;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hcV;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.heo;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hen;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hem;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hdb;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hdi;
      if (parama != null) {
        parama.yD(paramLiveConfig.alo());
      }
      parama = this.hek;
      if (parama != null) {
        parama.nL(0);
      }
      parama = this.hel;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hcX;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.heq;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hdl;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.her;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hdn;
      if (parama != null) {
        parama.nL(8);
      }
      parama = this.hcT;
      if (parama != null) {
        parama.nL(8);
      }
      localObject = this.hek;
      if (localObject != null)
      {
        parama = (d.g.a.m)new k(this);
        localObject = ((bk)localObject).gKW;
        if (localObject != null) {
          ((LivePreviewView)localObject).setPreviewTouchListener(parama);
        }
      }
      parama = this.hel;
      if (parama != null)
      {
        localObject = (d.g.a.m)new l(this);
        parama.gZI.setPreviewTouchListener((d.g.a.m)localObject);
      }
      if (paramLiveConfig.getScene() == LiveConfig.gIY)
      {
        parama = this.hcV;
        if (parama != null)
        {
          parama.gVr.setVisibility(8);
          parama.gVq.setVisibility(0);
        }
      }
      parama = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.aos().gTr = ((d.g.a.b)new m(this));
      parama = com.tencent.mm.live.b.c.gPx;
      com.tencent.mm.live.b.c.e(name(), (d.g.a.a)new n(this));
      if (!LiveConfig.alp()) {
        break label1755;
      }
      parama = findViewById(2131307634);
      p.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
      this.hcT = new t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
      a(b.c.gUZ, new Bundle());
      LiveConfig.dE(false);
    }
    for (;;)
    {
      parama = com.tencent.mm.live.b.c.gPx;
      com.tencent.mm.live.b.c.d(name(), this.gXH);
      AppMethodBeat.o(216651);
      return;
      parama = null;
      break;
      label1677:
      parama = (CharSequence)"";
      break label1022;
      label1687:
      localObject = com.tencent.mm.live.core.core.c.b.gMM;
      localObject = parama.gJt.getContext();
      p.g(localObject, "root.context");
      parama.gZJ = ((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.ct((Context)localObject));
      break label1138;
      label1724:
      parama = com.tencent.mm.live.core.core.c.b.gMM;
      parama = ((com.tencent.mm.live.c.a)localObject).gJt.getContext();
      p.g(parama, "root.context");
      parama = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.ct(parama);
      break label1194;
      label1755:
      parama = com.tencent.mm.kernel.g.ajR();
      p.g(parama, "MMKernel.storage()");
      if (parama.ajA().getInt(am.a.JdH, 0) == 1)
      {
        parama = this.hep;
        if (parama != null) {
          parama.nL(0);
        }
      }
      else
      {
        parama = com.tencent.mm.live.b.g.gQZ;
        if (com.tencent.mm.live.b.g.anQ() != -1)
        {
          parama = com.tencent.mm.live.b.g.gQZ;
          i = com.tencent.mm.live.b.g.anQ();
          parama = getContext().getSystemService("window");
          if (parama == null)
          {
            parama = new d.v("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(216651);
            throw parama;
          }
          parama = ((WindowManager)parama).getDefaultDisplay();
          p.g(parama, "((context.getSystemServi…owManager).defaultDisplay");
          if (i != parama.getRotation()) {}
        }
        else
        {
          parama = com.tencent.mm.live.b.g.gQZ;
          paramLiveConfig = com.tencent.mm.live.b.g.anH().Gud;
          parama = paramLiveConfig;
          if (paramLiveConfig == null) {
            parama = "";
          }
          paramLiveConfig = com.tencent.mm.live.b.g.gQZ;
          long l = com.tencent.mm.live.b.g.anH().FKy;
          paramLiveConfig = com.tencent.mm.live.b.g.gQZ;
          c(parama, l, com.tencent.mm.live.b.g.anC());
          continue;
        }
        parama = com.tencent.mm.live.b.g.gQZ;
        if (com.tencent.mm.live.b.g.anV().gRh)
        {
          b.b.a(this, b.c.gUw);
        }
        else
        {
          parama = this.har;
          if (parama != null)
          {
            parama = parama.gLc;
            if ((parama != null) && (parama.alT() == true)) {}
          }
          else
          {
            parama = this.har;
            if (parama == null) {
              break label2013;
            }
            parama = parama.gLc;
            if ((parama == null) || (parama.alU() != true)) {
              break label2013;
            }
          }
          b.b.a(this, b.c.gUc);
        }
      }
    }
    label2013:
    parama = com.tencent.mm.live.b.g.gQZ;
    parama = com.tencent.mm.live.b.g.anL();
    if (parama != null)
    {
      parama = parama.gKm;
      if (parama == null) {}
    }
    for (int i = parama.gKh;; i = c.a.alA())
    {
      this.gKh = i;
      dZ(true);
      parama = com.tencent.mm.live.b.g.gQZ;
      if (!com.tencent.mm.live.b.g.anW().gRe) {
        break;
      }
      parama = this.hcT;
      if (parama != null) {
        parama.nL(0);
      }
      a(b.c.gTX, new Bundle());
      parama = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.anW().gRe = false;
      break;
      parama = c.a.gJD;
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int i = 2;
    int j = 0;
    AppMethodBeat.i(216657);
    p.h(paramc, "status");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreVisitor", "statusChange:" + paramc.name());
    switch (c.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(216657);
      return;
      Object localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      Object localObject2 = com.tencent.mm.live.b.g.gQZ;
      ((com.tencent.mm.live.b.c.c)localObject1).yz(com.tencent.mm.live.b.g.anC());
      localObject1 = com.tencent.mm.live.d.e.haW;
      com.tencent.mm.live.d.e.aqm().jx(System.currentTimeMillis());
      localObject1 = com.tencent.mm.live.d.e.haW;
      localObject1 = com.tencent.mm.live.d.e.aqm();
      localObject2 = com.tencent.mm.live.d.e.haW;
      long l = com.tencent.mm.live.d.e.aqm().SZ();
      localObject2 = com.tencent.mm.live.d.e.haW;
      ((db)localObject1).jv((l - com.tencent.mm.live.d.e.aqm().SY()) / 1000L);
      localObject1 = com.tencent.mm.live.d.e.haW;
      localObject1 = com.tencent.mm.live.d.e.aqm();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      ((db)localObject1).jy(com.tencent.mm.model.r.zC(com.tencent.mm.live.b.g.anC()));
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      localObject1 = com.tencent.mm.live.b.g.anC();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      l = com.tencent.mm.live.b.g.anH().FKy;
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      i = com.tencent.mm.live.b.g.aof();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      j = com.tencent.mm.live.b.g.aoh();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      int k = com.tencent.mm.live.b.g.anH().GTv;
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      int m = com.tencent.mm.live.b.g.aoi();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      int n = com.tencent.mm.live.b.g.aoj();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      int i1 = com.tencent.mm.live.b.g.aok();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      int i2 = com.tencent.mm.live.b.g.aol();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, com.tencent.mm.live.b.g.anH().Hik);
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.anP();
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(216657);
        throw paramc;
      }
      ((Activity)localObject1).finishAndRemoveTask();
      continue;
      localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      ((com.tencent.mm.live.b.c.c)localObject1).yz(com.tencent.mm.live.b.g.anC());
      localObject1 = com.tencent.mm.live.d.e.haW;
      com.tencent.mm.live.d.e.aqm().jx(System.currentTimeMillis());
      localObject1 = com.tencent.mm.live.d.e.haW;
      localObject1 = com.tencent.mm.live.d.e.aqm();
      localObject2 = com.tencent.mm.live.d.e.haW;
      l = com.tencent.mm.live.d.e.aqm().SZ();
      localObject2 = com.tencent.mm.live.d.e.haW;
      ((db)localObject1).jv((l - com.tencent.mm.live.d.e.aqm().SY()) / 1000L);
      localObject1 = com.tencent.mm.live.d.e.haW;
      localObject1 = com.tencent.mm.live.d.e.aqm();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      ((db)localObject1).jy(com.tencent.mm.model.r.zC(com.tencent.mm.live.b.g.anC()));
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      localObject1 = com.tencent.mm.live.b.g.anC();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      l = com.tencent.mm.live.b.g.anH().FKy;
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      i = com.tencent.mm.live.b.g.aof();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      j = com.tencent.mm.live.b.g.aoh();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      k = com.tencent.mm.live.b.g.anH().GTv;
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      m = com.tencent.mm.live.b.g.aoi();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      n = com.tencent.mm.live.b.g.aoj();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      i1 = com.tencent.mm.live.b.g.aok();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      i2 = com.tencent.mm.live.b.g.aol();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, com.tencent.mm.live.b.g.anH().Hik);
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.anP();
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.aoy();
      localObject1 = i.gRP;
      i.aoF();
      continue;
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.aoy();
      localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.b.g.gQZ;
      ((com.tencent.mm.live.b.c.c)localObject1).rA(com.tencent.mm.live.b.g.anH().FKy);
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(216657);
        throw paramc;
      }
      ((Activity)localObject1).setRequestedOrientation(1);
      continue;
      if (paramBundle != null) {}
      for (localObject1 = Boolean.valueOf(paramBundle.getBoolean("PARAM_LIVE_START_BY_ORIENTATION_CHANGE", false));; localObject1 = null)
      {
        if (p.i(localObject1, Boolean.FALSE))
        {
          this.hdv.aAn();
          i.gRP.aoH();
          localObject1 = i.gRP;
          i.aoC();
          localObject1 = i.gRP;
          i.aoG();
        }
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.aow();
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.dQ(false);
        localObject1 = com.tencent.mm.live.d.e.haW;
        com.tencent.mm.live.d.e.aqm().jw(System.currentTimeMillis());
        break;
      }
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      if (!com.tencent.mm.live.b.g.anV().gRh)
      {
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        if (!com.tencent.mm.live.b.g.anV().gRj)
        {
          localObject1 = this.hdb;
          if (localObject1 != null)
          {
            ((ai)localObject1).nL(0);
            localObject1 = d.z.Nhr;
          }
          localObject1 = this.hdb;
          if (localObject1 != null)
          {
            ((ai)localObject1).apf();
            localObject1 = d.z.Nhr;
            continue;
            localObject1 = com.tencent.mm.live.b.c.gPx;
            com.tencent.mm.live.b.c.ang();
            i.gRP.release();
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(216657);
              throw paramc;
            }
            ((Activity)localObject1).finishAndRemoveTask();
            continue;
            localObject1 = com.tencent.mm.live.b.g.gQZ;
            localObject1 = com.tencent.mm.live.b.g.anH().Gud;
            p.g(localObject1, "LiveDataManager.liveInfo.live_name");
            localObject2 = com.tencent.mm.live.b.g.gQZ;
            l = com.tencent.mm.live.b.g.anH().FKy;
            localObject2 = com.tencent.mm.live.b.g.gQZ;
            c((String)localObject1, l, com.tencent.mm.live.b.g.anC());
            continue;
            localObject2 = this.hek;
            if (localObject2 != null)
            {
              localObject1 = this.heq;
              if (localObject1 != null) {}
              for (localObject1 = ((bc)localObject1).apm();; localObject1 = null)
              {
                ((bk)localObject2).haI = ((j)localObject1);
                break;
              }
              if (this.hdu)
              {
                localObject1 = getContext();
                if (localObject1 == null)
                {
                  paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                  AppMethodBeat.o(216657);
                  throw paramc;
                }
                ((Activity)localObject1).setRequestedOrientation(4);
                continue;
                localObject1 = getContext();
                if (localObject1 == null)
                {
                  paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                  AppMethodBeat.o(216657);
                  throw paramc;
                }
                ((Activity)localObject1).setRequestedOrientation(14);
                continue;
                localObject1 = com.tencent.mm.live.b.g.gQZ;
                localObject1 = com.tencent.mm.live.b.g.anL();
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gKk;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.core.core.b.b)localObject1).gKd = true;
                  }
                }
                if (this.hdu)
                {
                  localObject1 = getContext();
                  if (localObject1 == null)
                  {
                    paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(216657);
                    throw paramc;
                  }
                  ((Activity)localObject1).setRequestedOrientation(4);
                }
                i = this.gKh;
                localObject1 = c.a.gJD;
                if (i == c.a.alA())
                {
                  localObject1 = this.hek;
                  if (localObject1 != null)
                  {
                    ((bk)localObject1).exitRoom();
                    localObject1 = d.z.Nhr;
                  }
                  localObject1 = this.hel;
                  if (localObject1 != null)
                  {
                    ((aw)localObject1).nL(0);
                    localObject1 = d.z.Nhr;
                  }
                  localObject1 = this.hel;
                  if (localObject1 != null)
                  {
                    localObject1 = ((aw)localObject1).gPy;
                    if (localObject1 != null) {
                      ((TXLivePlayer)localObject1).resume();
                    }
                    localObject1 = d.z.Nhr;
                  }
                }
                localObject1 = this.hdj;
                if (localObject1 != null)
                {
                  this.hds.remove(localObject1);
                  continue;
                  localObject1 = this.hdj;
                  if (localObject1 != null)
                  {
                    this.hds.remove(localObject1);
                    continue;
                    i = this.gKh;
                    localObject1 = c.a.gJD;
                    if (i == c.a.alz())
                    {
                      aqT();
                    }
                    else
                    {
                      localObject1 = c.a.gJD;
                      if (i == c.a.alA())
                      {
                        localObject1 = com.tencent.mm.live.b.g.gQZ;
                        localObject1 = com.tencent.mm.live.b.g.anL();
                        if (localObject1 != null)
                        {
                          localObject2 = this.hek;
                          if (localObject2 != null)
                          {
                            ((bk)localObject2).a((com.tencent.mm.live.core.core.b.d)localObject1, (d.g.a.b)new p(this));
                            localObject1 = d.z.Nhr;
                            continue;
                            localObject1 = com.tencent.mm.live.b.g.gQZ;
                            com.tencent.mm.live.b.g.aox();
                            localObject1 = i.gRP;
                            i.aoD();
                            localObject1 = com.tencent.mm.live.b.c.gPx;
                            com.tencent.mm.live.b.c.ang();
                            i.gRP.release();
                            localObject1 = this.hda;
                            if (localObject1 != null)
                            {
                              ((ay)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.hcX;
                            if (localObject1 != null)
                            {
                              ((as)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.hcV;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.c)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.heo;
                            if (localObject1 != null)
                            {
                              ((bg)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.hen;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.z)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.hem;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.v)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.hdb;
                            if (localObject1 != null)
                            {
                              ((ai)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.hdi;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.ae)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.hek;
                            if (localObject1 != null)
                            {
                              ((bk)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.hel;
                            if (localObject1 != null)
                            {
                              ((aw)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.heq;
                            if (localObject1 != null)
                            {
                              ((bc)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.hdl;
                            if (localObject1 != null)
                            {
                              ((ag)localObject1).nL(8);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.her;
                            if (localObject1 != null)
                            {
                              ((ab)localObject1).nL(0);
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.her;
                            Object localObject3;
                            if (localObject1 != null)
                            {
                              localObject2 = com.tencent.mm.live.b.g.gQZ;
                              localObject2 = com.tencent.mm.live.b.g.anJ();
                              localObject3 = com.tencent.mm.live.b.d.a.gTM;
                              localObject3 = ((com.tencent.mm.live.c.a)localObject1).gJt.getContext();
                              p.g(localObject3, "root.context");
                              com.tencent.mm.live.b.d.a.a.a((String)localObject2, ((Context)localObject3).getResources().getColor(2131100482), (d.g.a.b)new ab.a((ab)localObject1));
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.har;
                            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc.alT() != true))
                            {
                              localObject1 = this.har;
                              if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc.alU() != true))
                              {
                                i = this.gKh;
                                localObject1 = c.a.gJD;
                                if (i != c.a.alz()) {
                                  break label2055;
                                }
                              }
                            }
                            localObject1 = this.har;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.core.core.c.b)localObject1).amu();
                              localObject1 = d.z.Nhr;
                            }
                            localObject1 = this.hek;
                            if (localObject1 != null)
                            {
                              ((bk)localObject1).exitRoom();
                              localObject1 = d.z.Nhr;
                              continue;
                              label2055:
                              localObject1 = this.hel;
                              if (localObject1 != null)
                              {
                                ((aw)localObject1).apj();
                                localObject1 = d.z.Nhr;
                                continue;
                                localObject1 = com.tencent.mm.live.b.g.gQZ;
                                com.tencent.mm.live.b.g.nz(2);
                                localObject1 = com.tencent.mm.live.b.g.gQZ;
                                if (!com.tencent.mm.live.b.g.anV().gRh)
                                {
                                  localObject1 = com.tencent.mm.live.b.g.gQZ;
                                  if (!com.tencent.mm.live.b.g.anV().gRj)
                                  {
                                    localObject1 = this.hdi;
                                    if (localObject1 != null)
                                    {
                                      localObject2 = com.tencent.mm.live.b.g.gQZ;
                                      localObject2 = com.tencent.mm.live.b.g.anJ();
                                      localObject3 = getContext();
                                      p.g(localObject3, "context");
                                      localObject3 = ((Context)localObject3).getResources().getString(2131766622);
                                      p.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
                                      ((com.tencent.mm.live.c.ae)localObject1).au((String)localObject2, (String)localObject3);
                                      localObject1 = d.z.Nhr;
                                    }
                                    localObject1 = com.tencent.mm.live.b.g.gQZ;
                                    com.tencent.mm.live.b.g.aox();
                                    continue;
                                    localObject1 = com.tencent.mm.live.b.g.gQZ;
                                    com.tencent.mm.live.b.g.nz(1);
                                    localObject1 = com.tencent.mm.live.b.g.gQZ;
                                    if (!com.tencent.mm.live.b.g.anV().gRh)
                                    {
                                      localObject1 = com.tencent.mm.live.b.g.gQZ;
                                      if (!com.tencent.mm.live.b.g.anV().gRj)
                                      {
                                        localObject1 = this.hdi;
                                        if (localObject1 != null)
                                        {
                                          localObject2 = com.tencent.mm.live.b.g.gQZ;
                                          localObject2 = com.tencent.mm.live.b.g.anJ();
                                          localObject3 = getContext();
                                          p.g(localObject3, "context");
                                          localObject3 = ((Context)localObject3).getResources().getString(2131766568);
                                          p.g(localObject3, "context.resources.getStr…ive_anchor_exception_tip)");
                                          ((com.tencent.mm.live.c.ae)localObject1).au((String)localObject2, (String)localObject3);
                                          localObject1 = d.z.Nhr;
                                          continue;
                                          localObject1 = this.hek;
                                          if (localObject1 != null)
                                          {
                                            ((bk)localObject1).nL(0);
                                            localObject1 = d.z.Nhr;
                                          }
                                          localObject1 = this.hek;
                                          if (localObject1 != null)
                                          {
                                            ((bk)localObject1).apr();
                                            localObject1 = d.z.Nhr;
                                          }
                                          localObject1 = this.hel;
                                          if (localObject1 != null)
                                          {
                                            ((aw)localObject1).nL(8);
                                            localObject1 = d.z.Nhr;
                                          }
                                          localObject1 = this.hel;
                                          if (localObject1 != null)
                                          {
                                            localObject1 = ((aw)localObject1).gPy;
                                            if (localObject1 != null) {
                                              ((TXLivePlayer)localObject1).pause();
                                            }
                                            localObject1 = d.z.Nhr;
                                            continue;
                                            localObject1 = this.hdi;
                                            if (localObject1 != null)
                                            {
                                              ((com.tencent.mm.live.c.ae)localObject1).nL(8);
                                              localObject1 = d.z.Nhr;
                                              continue;
                                              localObject1 = this.har;
                                              if (localObject1 != null)
                                              {
                                                localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc;
                                                if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.e)localObject1).isFloatMode()))
                                                {
                                                  localObject1 = this.har;
                                                  if (localObject1 != null)
                                                  {
                                                    localObject2 = getContext();
                                                    p.g(localObject2, "context");
                                                    ((com.tencent.mm.live.core.core.c.b)localObject1).cr((Context)localObject2);
                                                  }
                                                  localObject1 = com.tencent.mm.live.b.g.gQZ;
                                                  localObject1 = com.tencent.mm.live.b.g.anC();
                                                  localObject2 = com.tencent.mm.live.b.g.gQZ;
                                                  l = com.tencent.mm.live.b.g.anH().FKy;
                                                  localObject2 = com.tencent.mm.live.b.g.gQZ;
                                                  localObject2 = com.tencent.mm.live.b.g.anJ();
                                                  localObject3 = com.tencent.mm.live.b.g.gQZ;
                                                  com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 1, com.tencent.mm.live.b.g.anH().GTv);
                                                  com.tencent.mm.live.d.f.aqs();
                                                  continue;
                                                  localObject1 = com.tencent.mm.live.b.g.gQZ;
                                                  localObject1 = com.tencent.mm.live.b.g.anC();
                                                  localObject2 = com.tencent.mm.live.b.g.gQZ;
                                                  l = com.tencent.mm.live.b.g.anH().FKy;
                                                  localObject2 = com.tencent.mm.live.b.g.gQZ;
                                                  localObject2 = com.tencent.mm.live.b.g.anJ();
                                                  localObject3 = com.tencent.mm.live.b.g.gQZ;
                                                  com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 0, com.tencent.mm.live.b.g.anH().GTv);
                                                  com.tencent.mm.live.d.f.aqt();
                                                  continue;
                                                  localObject1 = this.har;
                                                  if (localObject1 != null)
                                                  {
                                                    localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc;
                                                    if (localObject1 != null)
                                                    {
                                                      ((com.tencent.mm.live.core.core.b.e)localObject1).gKu = e.d.gKK;
                                                      localObject1 = d.z.Nhr;
                                                      continue;
                                                      localObject1 = this.har;
                                                      if (localObject1 != null)
                                                      {
                                                        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc;
                                                        if (localObject1 != null)
                                                        {
                                                          ((com.tencent.mm.live.core.core.b.e)localObject1).gKu = e.d.gKM;
                                                          localObject1 = d.z.Nhr;
                                                          continue;
                                                          localObject1 = this.hek;
                                                          if (localObject1 != null)
                                                          {
                                                            localObject2 = com.tencent.mm.live.b.g.gQZ;
                                                            if (com.tencent.mm.live.b.g.anY().aoA()) {}
                                                            for (;;)
                                                            {
                                                              localObject2 = com.tencent.mm.live.b.g.gQZ;
                                                              localObject2 = com.tencent.mm.live.b.g.anY().userId;
                                                              localObject3 = com.tencent.mm.live.b.g.gQZ;
                                                              ((bk)localObject1).c(i, (String)localObject2, com.tencent.mm.live.b.g.anY().streamType);
                                                              localObject1 = d.z.Nhr;
                                                              break;
                                                              i = 1;
                                                            }
                                                            localObject1 = this.har;
                                                            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.c.b)localObject1).alV() != true))
                                                            {
                                                              localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
                                                              localObject2 = com.tencent.mm.live.b.g.gQZ;
                                                              ((com.tencent.mm.live.b.c.c)localObject1).yz(com.tencent.mm.live.b.g.anC());
                                                              localObject1 = com.tencent.mm.live.b.g.gQZ;
                                                              com.tencent.mm.live.b.g.anP();
                                                              localObject1 = this.har;
                                                              if (localObject1 != null)
                                                              {
                                                                ((com.tencent.mm.live.core.core.c.b)localObject1).alv();
                                                                localObject1 = d.z.Nhr;
                                                                continue;
                                                                if (!aoA())
                                                                {
                                                                  if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                                  {
                                                                    localObject1 = this.hcY;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      localObject1 = ((com.tencent.mm.live.c.a)localObject1).gJt;
                                                                      if (localObject1 == null) {}
                                                                    }
                                                                    for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                                    {
                                                                      ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
                                                                      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
                                                                      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
                                                                      localObject1 = this.hcY;
                                                                      if (localObject1 == null) {
                                                                        break;
                                                                      }
                                                                      localObject1 = ((com.tencent.mm.live.c.a)localObject1).gJt;
                                                                      if (localObject1 == null) {
                                                                        break;
                                                                      }
                                                                      ((ViewGroup)localObject1).requestLayout();
                                                                      localObject1 = d.z.Nhr;
                                                                      break;
                                                                    }
                                                                  }
                                                                  localObject1 = this.hcY;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    localObject1 = ((com.tencent.mm.live.c.a)localObject1).gJt;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      localObject1 = ((ViewGroup)localObject1).getLayoutParams();
                                                                      label3001:
                                                                      if ((localObject1 == null) || (!(localObject1 instanceof RelativeLayout.LayoutParams))) {
                                                                        continue;
                                                                      }
                                                                      ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
                                                                      localObject2 = (RelativeLayout.LayoutParams)localObject1;
                                                                      localObject3 = this.heo;
                                                                      if (localObject3 == null) {
                                                                        break label3126;
                                                                      }
                                                                      localObject3 = ((com.tencent.mm.live.c.a)localObject3).gJt;
                                                                      if (localObject3 == null) {
                                                                        break label3126;
                                                                      }
                                                                    }
                                                                  }
                                                                  label3126:
                                                                  for (i = ((ViewGroup)localObject3).getId();; i = 0)
                                                                  {
                                                                    ((RelativeLayout.LayoutParams)localObject2).addRule(2, i);
                                                                    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = aq.fromDPToPix(getContext(), 12);
                                                                    localObject1 = this.hcY;
                                                                    if (localObject1 == null) {
                                                                      break;
                                                                    }
                                                                    localObject1 = ((com.tencent.mm.live.c.a)localObject1).gJt;
                                                                    if (localObject1 == null) {
                                                                      break;
                                                                    }
                                                                    ((ViewGroup)localObject1).requestLayout();
                                                                    localObject1 = d.z.Nhr;
                                                                    break;
                                                                    localObject1 = null;
                                                                    break label3001;
                                                                  }
                                                                }
                                                                else if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                                {
                                                                  localObject1 = this.hcY;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    ((com.tencent.mm.live.c.m)localObject1).nL(4);
                                                                    localObject1 = d.z.Nhr;
                                                                  }
                                                                }
                                                                else
                                                                {
                                                                  localObject1 = this.hcY;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    ((com.tencent.mm.live.c.m)localObject1).nL(0);
                                                                    localObject1 = d.z.Nhr;
                                                                    continue;
                                                                    if (!aoA())
                                                                    {
                                                                      localObject1 = this.hen;
                                                                      if ((localObject1 != null) && (((com.tencent.mm.live.c.a)localObject1).gJt.getVisibility() == 0))
                                                                      {
                                                                        i = j;
                                                                        if (paramBundle != null) {
                                                                          i = paramBundle.getInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT");
                                                                        }
                                                                        localObject1 = this.hcY;
                                                                        if (localObject1 != null)
                                                                        {
                                                                          localObject1 = ((com.tencent.mm.live.c.a)localObject1).gJt;
                                                                          if (localObject1 == null) {}
                                                                        }
                                                                        for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                                        {
                                                                          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i;
                                                                          localObject1 = this.hcY;
                                                                          if (localObject1 == null) {
                                                                            break;
                                                                          }
                                                                          localObject1 = ((com.tencent.mm.live.c.a)localObject1).gJt;
                                                                          if (localObject1 == null) {
                                                                            break;
                                                                          }
                                                                          ((ViewGroup)localObject1).requestLayout();
                                                                          localObject1 = d.z.Nhr;
                                                                          break;
                                                                        }
                                                                        localObject1 = com.tencent.mm.live.b.g.gQZ;
                                                                        if (!com.tencent.mm.live.b.g.anV().gRh)
                                                                        {
                                                                          localObject1 = this.hek;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((bk)localObject1).nL(8);
                                                                            localObject1 = d.z.Nhr;
                                                                          }
                                                                          localObject1 = this.hcT;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((t)localObject1).nL(8);
                                                                            localObject1 = d.z.Nhr;
                                                                          }
                                                                          localObject1 = this.hdi;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((com.tencent.mm.live.c.ae)localObject1).nL(8);
                                                                            localObject1 = d.z.Nhr;
                                                                          }
                                                                          localObject1 = this.hdn;
                                                                          if (localObject1 != null)
                                                                          {
                                                                            ((com.tencent.mm.live.c.r)localObject1).nL(0);
                                                                            localObject1 = d.z.Nhr;
                                                                          }
                                                                          localObject1 = com.tencent.mm.live.b.g.gQZ;
                                                                          com.tencent.mm.live.b.g.aox();
                                                                          localObject1 = getContext();
                                                                          if (localObject1 == null)
                                                                          {
                                                                            paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                                                                            AppMethodBeat.o(216657);
                                                                            throw paramc;
                                                                          }
                                                                          ((Activity)localObject1).setRequestedOrientation(1);
                                                                          continue;
                                                                          localObject1 = com.tencent.mm.live.b.g.gQZ;
                                                                          com.tencent.mm.live.b.g.anV().gRk = true;
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
  
  public final void aoO()
  {
    AppMethodBeat.i(216663);
    super.aoO();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().a(3806, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(216663);
  }
  
  public final void aoP()
  {
    AppMethodBeat.i(216664);
    super.aoP();
    Object localObject1 = com.tencent.mm.live.b.g.gQZ;
    int i;
    Object localObject2;
    if (com.tencent.mm.live.b.g.anQ() != -1)
    {
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      i = com.tencent.mm.live.b.g.anQ();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(216664);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.g(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
      if (i != ((Display)localObject1).getRotation())
      {
        i = 1;
        if (i == 0)
        {
          localObject1 = this.hel;
          if (localObject1 != null) {
            ((aw)localObject1).apj();
          }
          localObject1 = com.tencent.mm.live.b.c.gPx;
          com.tencent.mm.live.b.c.ang();
          localObject1 = i.gRP;
          i.aoD();
          i.gRP.release();
          localObject1 = this.har;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.c.b)localObject1).alw();
          }
          localObject1 = this.har;
          if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc.alU() != true))
          {
            localObject1 = this.har;
            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc.alT() != true)) {
              break label306;
            }
          }
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          localObject1 = com.tencent.mm.live.b.g.aos().gTx;
          if (localObject1 != null)
          {
            localObject2 = i.gRP;
            i.at(((com.tencent.mm.live.b.b.a.a)localObject1).gTA, ((com.tencent.mm.live.b.b.a.a)localObject1).gTC);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("PARAM_HANGUP_SELF", true);
          a(b.c.gUm, (Bundle)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.Zq();
      localObject1 = com.tencent.mm.live.core.core.c.b.gMM;
      localObject1 = com.tencent.mm.live.core.core.c.b.amx();
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject1).release();
      }
      com.tencent.mm.live.core.core.c.b.e(null);
      this.hdv.abn();
      localObject1 = com.tencent.mm.kernel.g.ajQ();
      p.g(localObject1, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject1).ajj().b(3806, (com.tencent.mm.ak.f)this);
      AppMethodBeat.o(216664);
      return;
      i = 0;
      break;
      label306:
      localObject1 = this.hem;
      if ((localObject1 != null) && (((com.tencent.mm.live.c.v)localObject1).gXn.has == true))
      {
        localObject1 = i.gRP;
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        String str = com.tencent.mm.live.b.g.aos().gTy;
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        localObject2 = com.tencent.mm.live.b.g.anH().Hii;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        i.at(str, (String)localObject1);
      }
    }
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(216665);
    boolean bool2 = super.aoQ();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
      bool1 = bool2;
      if (com.tencent.mm.live.b.g.anV().gRi)
      {
        localg = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.anV().gRi = false;
        b.b.a(this, b.c.gUd);
        bool1 = true;
      }
    }
    AppMethodBeat.o(216665);
    return bool1;
  }
  
  public final void dY(boolean paramBoolean)
  {
    this.hdu = paramBoolean;
  }
  
  public final void f(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(216668);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreVisitor", "callback:".concat(String.valueOf(paramInt)));
    Object localObject4 = c.b.gJM;
    if (paramInt == c.b.alB())
    {
      b.b.a(this, b.c.gUz);
      AppMethodBeat.o(216668);
      return;
    }
    localObject4 = c.b.gJM;
    if (paramInt == c.b.alC())
    {
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getString("live_user_id");
        paramBundle.getString("live_user_exit_reason");
        localObject3 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
        paramBundle = com.tencent.mm.live.b.g.gQZ;
        paramBundle = com.tencent.mm.live.b.g.aos().gTx;
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.gTC;; paramBundle = null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreAnchor", paramBundle);
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          localObject3 = com.tencent.mm.live.b.g.aos().gTx;
          paramBundle = (Bundle)localObject1;
          if (localObject3 != null) {
            paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject3).gTC;
          }
          if (!p.i(localObject2, paramBundle))
          {
            paramBundle = com.tencent.mm.live.b.g.gQZ;
            if (!p.i(localObject2, com.tencent.mm.live.b.g.anH().Hij)) {}
          }
          else
          {
            paramBundle = com.tencent.mm.live.b.g.gQZ;
            paramBundle = com.tencent.mm.live.b.g.aos().gTx;
            if (paramBundle != null)
            {
              localObject1 = this.hek;
              if (localObject1 != null)
              {
                localObject1 = ((bk)localObject1).gKW;
                if (localObject1 != null) {
                  ((LivePreviewView)localObject1).clearAnimation();
                }
              }
              localObject1 = com.tencent.mm.live.b.g.gQZ;
              com.tencent.mm.live.b.g.aos().a(paramBundle.gJh, paramBundle.gTB, paramBundle.gTA);
            }
          }
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          if (p.i(localObject2, com.tencent.mm.live.b.g.anH().Hij))
          {
            this.het = true;
            b.b.a(this, b.c.gUQ);
          }
          AppMethodBeat.o(216668);
          return;
        }
      }
      AppMethodBeat.o(216668);
      return;
    }
    localObject1 = c.b.gJM;
    if (paramInt == c.b.alD()) {
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getString("live_user_id");
        if (paramBundle.getBoolean("live_media_enable"))
        {
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          localObject3 = com.tencent.mm.live.b.g.aos();
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
      ((com.tencent.mm.live.b.b.a)localObject3).gTz = paramBundle;
      localObject4 = ((com.tencent.mm.live.b.b.a)localObject3).gTx;
      paramBundle = (Bundle)localObject2;
      if (localObject4 != null) {
        paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject4).gTC;
      }
      if ((p.i(localObject1, paramBundle)) && (!((com.tencent.mm.live.b.b.a)localObject3).aoK()))
      {
        paramBundle = ((com.tencent.mm.live.b.b.a)localObject3).gTu;
        if (paramBundle != null)
        {
          paramBundle.invoke();
          AppMethodBeat.o(216668);
          return;
        }
      }
      AppMethodBeat.o(216668);
      return;
      b.b.a(this, b.c.gUm);
      AppMethodBeat.o(216668);
      return;
      AppMethodBeat.o(216668);
      return;
      localObject1 = c.b.gJM;
      long l;
      if (paramInt == c.b.alF())
      {
        paramBundle = this.har;
        int k;
        if ((paramBundle != null) && (paramBundle.gLc.alU() == true))
        {
          i = 1;
          k = this.gKh;
          paramBundle = c.a.gJD;
          if (k != c.a.alz()) {
            break label636;
          }
          j = 2;
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
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.b.g.anJ(), i, j, paramInt);
          AppMethodBeat.o(216668);
          return;
          paramBundle = this.har;
          if ((paramBundle != null) && (paramBundle.gLc.alT() == true))
          {
            i = 2;
            break;
          }
          i = 0;
          break;
          label636:
          paramBundle = c.a.gJD;
          if (k == c.a.alA()) {
            j = 1;
          }
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
        p.g(localObject1, "LiveDataManager.liveInfo.live_name");
        new com.tencent.mm.live.b.a(l, paramBundle, (String)localObject1, (byte)0).a((d.g.a.r)new b(this));
        AppMethodBeat.o(216668);
        return;
      }
      localObject1 = c.b.gJM;
      if (paramInt == c.b.alI())
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
        localObject4 = this.har;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject4).gLc;
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = ((com.tencent.mm.live.core.core.b.e)localObject4).gKw;
          }
        }
        if (!bu.lX((String)localObject1, (String)localObject2))
        {
          localObject2 = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.b.g.anY().setUserId((String)localObject1);
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          localObject1 = com.tencent.mm.live.b.g.anY();
          if (paramBundle != null)
          {
            paramInt = paramBundle.getInt("live_stream_type");
            ((g.c)localObject1).streamType = paramInt;
            localObject1 = com.tencent.mm.live.b.g.gQZ;
            localObject1 = com.tencent.mm.live.b.g.anY();
            if (paramBundle == null) {
              break label946;
            }
          }
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
            AppMethodBeat.o(216668);
            return;
            paramInt = 0;
            break;
          }
        }
        this.het = false;
      }
      AppMethodBeat.o(216668);
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
    AppMethodBeat.i(216667);
    super.i(paramBoolean, paramInt);
    AppMethodBeat.o(216667);
  }
  
  public final String name()
  {
    AppMethodBeat.i(216658);
    String str = LiveVisitorPluginLayout.class.getSimpleName();
    p.g(str, "LiveVisitorPluginLayout::class.java.simpleName");
    AppMethodBeat.o(216658);
    return str;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(216652);
    p.h(paramString, "incomingNumber");
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.har;
    if (paramString != null)
    {
      paramString = paramString.gLc;
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.isFloatMode());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreVisitor", paramString);
        switch (paramInt)
        {
        }
      }
    }
    do
    {
      AppMethodBeat.o(216652);
      return;
      paramString = null;
      break;
      AppMethodBeat.o(216652);
      return;
      paramString = i.gRP;
      i.aoD();
      paramString = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.anP();
      paramString = this.har;
      if ((paramString != null) && (paramString.gLc.alT() == true))
      {
        paramString = this.har;
        if (paramString != null) {
          paramString.alr();
        }
      }
      paramString = this.har;
    } while (paramString == null);
    paramString.alv();
    AppMethodBeat.o(216652);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(216666);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreVisitor", "errType:" + paramInt1 + " errCode:" + paramInt2);
    if (((paramn instanceof com.tencent.mm.live.b.a.b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.heo;
      if (paramString != null) {
        paramString.apn();
      }
      paramn = this.hda;
      if (paramn != null)
      {
        paramString = com.tencent.mm.live.b.g.gQZ;
        paramString = com.tencent.mm.live.b.g.anH().Gud;
        if (paramString == null) {
          break label145;
        }
        paramString = (CharSequence)paramString;
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
        paramn.a(paramString, com.tencent.mm.live.b.g.anJ());
      }
      paramString = com.tencent.mm.live.b.g.gQZ;
      paramString = com.tencent.mm.live.b.g.gQZ;
      if (com.tencent.mm.live.b.g.anH().FTM) {
        break label155;
      }
    }
    label145:
    label155:
    for (paramInt1 = ch.aDd();; paramInt1 = 0)
    {
      com.tencent.mm.live.b.g.nw(paramInt1);
      AppMethodBeat.o(216666);
      return;
      paramString = (CharSequence)"";
      break;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(216662);
    super.pause();
    Object localObject1 = com.tencent.mm.live.b.g.gQZ;
    if (com.tencent.mm.live.b.g.anQ() != -1)
    {
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      int i = com.tencent.mm.live.b.g.anQ();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(216662);
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
      AppMethodBeat.o(216662);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
    p.g(localObject2, "((context.getSystemServi…owManager).defaultDisplay");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreVisitor", ((Display)localObject2).getRotation());
    if (!bool)
    {
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      if (!com.tencent.mm.live.b.g.anV().gRh)
      {
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        if (!com.tencent.mm.live.b.g.anV().gRj)
        {
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          if (!com.tencent.mm.live.b.g.anV().gRk)
          {
            localObject1 = com.tencent.mm.live.b.g.gQZ;
            if (com.tencent.mm.live.b.g.anV().gRi)
            {
              localObject1 = com.tencent.mm.live.b.g.gQZ;
              if ((!com.tencent.mm.live.b.g.anO()) && (com.tencent.mm.compatible.d.b.cc(getContext()))) {
                b.b.a(this, b.c.gUr);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = this.har;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc;
      if (localObject1 == null) {
        break;
      }
      if (((com.tencent.mm.live.core.core.b.e)localObject1).alT() != true) {
        break label369;
      }
      localObject1 = this.har;
      if (localObject1 == null) {
        break label369;
      }
      ((com.tencent.mm.live.core.core.c.b)localObject1).alr();
      AppMethodBeat.o(216662);
      return;
      localObject1 = this.har;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).alR() == true))
        {
          localObject1 = this.har;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.c.b)localObject1).amu();
          }
        }
      }
    }
    AppMethodBeat.o(216662);
    return;
    label369:
    AppMethodBeat.o(216662);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(216661);
    Object localObject1 = com.tencent.mm.live.b.g.gQZ;
    com.tencent.mm.live.b.g.anV().gRk = false;
    localObject1 = getContext().getSystemService("window");
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(216661);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
    p.g(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
    int j = ((Display)localObject1).getRotation();
    localObject1 = new StringBuilder("curOrientation:").append(j).append(", lastOrientation:");
    Object localObject2 = com.tencent.mm.live.b.g.gQZ;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LiveCoreVisitor", com.tencent.mm.live.b.g.anQ());
    super.resume();
    localObject1 = this.har;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc;
      if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).alR() == true))
      {
        localObject1 = this.har;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).amv();
        }
      }
    }
    localObject1 = com.tencent.mm.live.b.g.gQZ;
    int i;
    if (com.tencent.mm.live.b.g.anQ() != -1)
    {
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      if (j != com.tencent.mm.live.b.g.anQ())
      {
        localObject1 = this.har;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).alt();
        }
        localObject1 = this.har;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).amr();
        }
        localObject1 = this.hek;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.live.b.g.gQZ;
          if (!com.tencent.mm.live.b.g.anY().aoA()) {
            break label333;
          }
          i = 2;
          localObject2 = com.tencent.mm.live.b.g.gQZ;
          localObject2 = com.tencent.mm.live.b.g.anY().userId;
          com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
          ((bk)localObject1).c(i, (String)localObject2, com.tencent.mm.live.b.g.anY().streamType);
        }
      }
    }
    for (;;)
    {
      localObject1 = this.har;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).alT() == true))
        {
          localObject1 = this.hek;
          if (localObject1 != null)
          {
            localObject2 = ((bk)localObject1).har;
            if (localObject2 != null) {
              ((com.tencent.mm.live.core.core.c.b)localObject2).a(((bk)localObject1).gKW);
            }
          }
        }
      }
      localObject1 = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.nx(j);
      AppMethodBeat.o(216661);
      return;
      label333:
      i = 1;
      break;
      localObject1 = this.har;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc;
        if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.e)localObject1).gKr))
        {
          localObject1 = this.har;
          if (localObject1 == null) {
            continue;
          }
          ((com.tencent.mm.live.core.core.c.b)localObject1).alt();
          continue;
        }
      }
      localObject1 = this.har;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).gLc;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.b.e)localObject1).gKr = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(216660);
    super.start();
    Object localObject = i.gRP;
    i.aoF();
    localObject = this.har;
    if (((localObject == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject).gLc.alT() != true)) && (this.hdu))
    {
      localObject = com.tencent.mm.live.b.g.gQZ;
      if (!com.tencent.mm.live.b.g.anV().gRh)
      {
        localObject = com.tencent.mm.live.b.g.gQZ;
        if (!com.tencent.mm.live.b.g.anV().gRj)
        {
          localObject = getContext();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(216660);
            throw ((Throwable)localObject);
          }
          ((Activity)localObject).setRequestedOrientation(4);
        }
      }
    }
    AppMethodBeat.o(216660);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, d.z>
  {
    b(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.b<Boolean, d.z>
  {
    c(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<Boolean, d.z>
  {
    d(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, d.z>
  {
    e(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class g
    implements DialogInterface.OnDismissListener
  {
    g(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(216637);
      paramDialogInterface = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.aox();
      b.b.a(this.hev, b.c.gUe);
      AppMethodBeat.o(216637);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class i
    implements DialogInterface.OnDismissListener
  {
    i(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(216639);
      paramDialogInterface = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.aox();
      b.b.a(this.hev, b.c.gUe);
      AppMethodBeat.o(216639);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.m<Float, Float, d.z>
  {
    k(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.m<Float, Float, d.z>
  {
    l(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "liveID", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.b<Long, d.z>
  {
    m(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    n(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class o
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    o(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/live/view/LiveVisitorPluginLayout$statusChange$3$1"})
  static final class p
    extends d.g.b.q
    implements d.g.a.b<Boolean, d.z>
  {
    p(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVisitorPluginLayout
 * JD-Core Version:    0.7.0.1
 */