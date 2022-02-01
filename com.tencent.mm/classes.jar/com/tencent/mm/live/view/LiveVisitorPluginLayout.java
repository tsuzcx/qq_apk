package com.tencent.mm.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.f.b;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.c.ab.a;
import com.tencent.mm.live.c.ac;
import com.tencent.mm.live.c.ae;
import com.tencent.mm.live.c.ag;
import com.tencent.mm.live.c.ai;
import com.tencent.mm.live.c.ak;
import com.tencent.mm.live.c.am;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.aw;
import com.tencent.mm.live.c.ay;
import com.tencent.mm.live.c.az;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.c.bd;
import com.tencent.mm.live.c.bf;
import com.tencent.mm.live.c.bh;
import com.tencent.mm.live.c.bl;
import com.tencent.mm.live.c.m;
import com.tencent.mm.live.c.o;
import com.tencent.mm.live.c.r;
import com.tencent.mm.live.c.t;
import com.tencent.mm.live.c.z;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.model.ce;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.k;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "anchorExceptionInTRTC", "", "audienceMode", "", "forceRender", "isStopLiveMessageCallback", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "liveDebugPlugin", "Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveFinished", "liveGuestRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "liveInputPlugin", "Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "liveKickedPlugin", "Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveStarted", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVideoMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "liveVisitorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "liveVisitorCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "navigation", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "pluginShow", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkAnchorStatus", "chooseAudienceMode", "enterRoom", "liveName", "", "roomID", "", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleEnterRoom", "initLogic", "router", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "requestLinkMic", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "toggleShowPlugins", "unMount", "updatePlugin", "Companion", "plugin-logic_release"})
public final class LiveVisitorPluginLayout
  extends BaseLivePluginLayout
  implements com.tencent.mm.al.g, com.tencent.mm.live.core.core.b
{
  public static final a KBo;
  private boolean KAA;
  private as KAa;
  private m KAb;
  private az KAd;
  private ai KAe;
  private o KAi;
  private am KAj;
  private ae KAl;
  private ak KAm;
  private ac KAn;
  private ag KAo;
  private r KAq;
  private com.tencent.mm.live.a.a KAr;
  private boolean KAw;
  private final ArrayList<com.tencent.mm.live.c.a> KAz;
  private bl KBb;
  private aw KBc;
  private com.tencent.mm.live.c.v KBd;
  private z KBe;
  private bh KBf;
  private com.tencent.mm.live.c.q KBg;
  private bd KBh;
  private com.tencent.mm.live.c.ab KBi;
  private bf KBj;
  private boolean KBk;
  private boolean KBl;
  private boolean KBm;
  private boolean KBn;
  private final d.g.a.a<y> Kvu;
  private com.tencent.mm.live.core.core.c.b Kxx;
  private t KzW;
  private com.tencent.mm.live.c.c KzY;
  private int qzb;
  
  static
  {
    AppMethodBeat.i(203510);
    KBo = new a((byte)0);
    AppMethodBeat.o(203510);
  }
  
  public LiveVisitorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(203509);
    this.KAA = true;
    paramContext = c.a.qxl;
    this.qzb = c.a.clK();
    this.KAz = new ArrayList();
    this.Kvu = ((d.g.a.a)new i(this));
    AppMethodBeat.o(203509);
  }
  
  private final void d(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(203498);
    ad.i("MicroMsg.LiveCoreVisitor", "join, name:" + paramString1 + ", roomID:" + paramLong);
    com.tencent.mm.live.b.f localf = com.tencent.mm.live.b.f.rGw;
    new com.tencent.mm.live.b.a(com.tencent.mm.live.b.f.eNG().LwA, paramString2, paramString1, (byte)0).d((d.g.a.q)new d(this));
    AppMethodBeat.o(203498);
  }
  
  private final void fQD()
  {
    AppMethodBeat.i(203497);
    Object localObject = com.tencent.mm.live.core.core.c.b.qOk;
    localObject = getContext();
    k.g(localObject, "context");
    com.tencent.mm.live.core.core.c.b.a.eH((Context)localObject).csk();
    localObject = com.tencent.mm.live.core.core.c.b.qOk;
    localObject = getContext();
    k.g(localObject, "context");
    localObject = com.tencent.mm.live.core.core.c.b.a.eH((Context)localObject);
    String str = com.tencent.mm.cd.a.aq(getContext(), 2131766672);
    k.g(str, "ResourceHelper.getString…tring.live_room_mini_mic)");
    ((com.tencent.mm.live.core.core.c.b)localObject).aTU(str);
    ad.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:0");
    AppMethodBeat.o(203497);
  }
  
  public final void B(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(203508);
    ad.i("MicroMsg.LiveCoreVisitor", "callback:".concat(String.valueOf(paramInt)));
    Object localObject4 = c.b.qye;
    if (paramInt == c.b.clQ())
    {
      b.b.a(this, b.c.FBq);
      AppMethodBeat.o(203508);
      return;
    }
    localObject4 = c.b.qye;
    if (paramInt == c.b.clR())
    {
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getString("live_user_id");
        paramBundle.getString("live_user_exit_reason");
        localObject3 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
        paramBundle = com.tencent.mm.live.b.f.rGw;
        paramBundle = com.tencent.mm.live.b.f.fOz().BMx;
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.Csx;; paramBundle = null)
        {
          ad.i("MicroMsg.LiveCoreAnchor", paramBundle);
          paramBundle = com.tencent.mm.live.b.f.rGw;
          localObject3 = com.tencent.mm.live.b.f.fOz().BMx;
          paramBundle = (Bundle)localObject1;
          if (localObject3 != null) {
            paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject3).Csx;
          }
          if (!k.g(localObject2, paramBundle))
          {
            paramBundle = com.tencent.mm.live.b.f.rGw;
            if (!k.g(localObject2, com.tencent.mm.live.b.f.eNG().Lzf)) {}
          }
          else
          {
            paramBundle = com.tencent.mm.live.b.f.rGw;
            paramBundle = com.tencent.mm.live.b.f.fOz().BMx;
            if (paramBundle != null)
            {
              localObject1 = this.KBb;
              if (localObject1 != null)
              {
                localObject1 = ((bl)localObject1).qDY;
                if (localObject1 != null) {
                  ((LivePreviewView)localObject1).clearAnimation();
                }
              }
              localObject1 = com.tencent.mm.live.b.f.rGw;
              com.tencent.mm.live.b.f.fOz().g(paramBundle.DlB, paramBundle.CaG, paramBundle.BQP);
            }
          }
          paramBundle = com.tencent.mm.live.b.f.rGw;
          if (k.g(localObject2, com.tencent.mm.live.b.f.eNG().Lzf))
          {
            this.KBl = true;
            b.b.a(this, b.c.HRM);
          }
          AppMethodBeat.o(203508);
          return;
        }
      }
      AppMethodBeat.o(203508);
      return;
    }
    localObject1 = c.b.qye;
    if (paramInt == c.b.clS()) {
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getString("live_user_id");
        if (paramBundle.getBoolean("live_media_enable"))
        {
          paramBundle = com.tencent.mm.live.b.f.rGw;
          localObject3 = com.tencent.mm.live.b.f.fOz();
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
      ((com.tencent.mm.live.b.b.a)localObject3).BMz = paramBundle;
      localObject4 = ((com.tencent.mm.live.b.b.a)localObject3).BMx;
      paramBundle = (Bundle)localObject2;
      if (localObject4 != null) {
        paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject4).Csx;
      }
      if ((k.g(localObject1, paramBundle)) && (!((com.tencent.mm.live.b.b.a)localObject3).fOK()))
      {
        paramBundle = ((com.tencent.mm.live.b.b.a)localObject3).BMv;
        if (paramBundle != null)
        {
          paramBundle.invoke();
          AppMethodBeat.o(203508);
          return;
        }
      }
      AppMethodBeat.o(203508);
      return;
      b.b.a(this, b.c.FBf);
      AppMethodBeat.o(203508);
      return;
      AppMethodBeat.o(203508);
      return;
      localObject1 = c.b.qye;
      long l;
      if (paramInt == c.b.cml())
      {
        paramBundle = this.Kxx;
        int k;
        if ((paramBundle != null) && (paramBundle.qEd.cnx() == true))
        {
          i = 1;
          k = this.qzb;
          paramBundle = c.a.qxl;
          if (k != c.a.clK()) {
            break label636;
          }
          j = 2;
        }
        for (;;)
        {
          paramBundle = com.tencent.mm.live.b.f.rGw;
          localObject2 = com.tencent.mm.live.b.f.eNB();
          paramBundle = com.tencent.mm.live.b.f.rGw;
          l = com.tencent.mm.live.b.f.eNG().LwA;
          paramBundle = com.tencent.mm.live.b.f.rGw;
          paramBundle = com.tencent.mm.live.b.f.fOz().BMx;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.BQP;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          localObject1 = com.tencent.mm.live.b.f.rGw;
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.b.f.eNI(), i, j, paramInt);
          AppMethodBeat.o(203508);
          return;
          paramBundle = this.Kxx;
          if ((paramBundle != null) && (paramBundle.qEd.cnw() == true))
          {
            i = 2;
            break;
          }
          i = 0;
          break;
          label636:
          paramBundle = c.a.qxl;
          if (k == c.a.clO()) {
            j = 1;
          }
        }
      }
      localObject1 = c.b.qye;
      if (paramInt == c.b.cmw())
      {
        paramBundle = com.tencent.mm.live.b.f.rGw;
        l = com.tencent.mm.live.b.f.eNG().LwA;
        paramBundle = com.tencent.mm.live.b.f.rGw;
        paramBundle = com.tencent.mm.live.b.f.eNB();
        localObject1 = com.tencent.mm.live.b.f.rGw;
        localObject1 = com.tencent.mm.live.b.f.eNG().LwZ;
        k.g(localObject1, "LiveDataManager.liveInfo.live_name");
        new com.tencent.mm.live.b.a(l, paramBundle, (String)localObject1, (byte)0).d((d.g.a.q)new b(this));
        AppMethodBeat.o(203508);
        return;
      }
      localObject1 = c.b.qye;
      if (paramInt == c.b.cmy())
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
        localObject4 = this.Kxx;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject4).qEd;
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = ((com.tencent.mm.live.core.core.b.e)localObject4).qzR;
          }
        }
        if (!bt.kU((String)localObject1, (String)localObject2))
        {
          localObject2 = com.tencent.mm.live.b.f.rGw;
          com.tencent.mm.live.b.f.fhJ().setUserId((String)localObject1);
          localObject1 = com.tencent.mm.live.b.f.rGw;
          localObject1 = com.tencent.mm.live.b.f.fhJ();
          if (paramBundle != null)
          {
            paramInt = paramBundle.getInt("live_stream_type");
            ((f.b)localObject1).streamType = paramInt;
            localObject1 = com.tencent.mm.live.b.f.rGw;
            localObject1 = com.tencent.mm.live.b.f.fhJ();
            if (paramBundle == null) {
              break label946;
            }
          }
          for (paramInt = paramBundle.getInt("live_first_frame_width");; paramInt = 0)
          {
            ((f.b)localObject1).width = paramInt;
            localObject1 = com.tencent.mm.live.b.f.rGw;
            localObject1 = com.tencent.mm.live.b.f.fhJ();
            paramInt = i;
            if (paramBundle != null) {
              paramInt = paramBundle.getInt("live_first_frame_height");
            }
            ((f.b)localObject1).height = paramInt;
            b.b.a(this, b.c.HWJ);
            AppMethodBeat.o(203508);
            return;
            paramInt = 0;
            break;
          }
        }
        this.KBl = false;
      }
      AppMethodBeat.o(203508);
      return;
    }
  }
  
  public final void a(com.tencent.mm.live.a.a parama, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(203495);
    k.h(parama, "router");
    k.h(paramLiveConfig, "config");
    if (LiveConfig.ckK())
    {
      parama = findViewById(2131307550);
      k.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
      this.KzW = new t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
      a(b.c.IIc, new Bundle());
      LiveConfig.hy(false);
      AppMethodBeat.o(203495);
      return;
    }
    Object localObject = com.tencent.mm.live.core.core.c.b.qOk;
    localObject = getContext();
    k.g(localObject, "context");
    this.Kxx = com.tencent.mm.live.core.core.c.b.a.eH((Context)localObject);
    localObject = this.Kxx;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).c((com.tencent.mm.live.core.core.b)this);
    }
    this.KAr = parama;
    parama = com.tencent.mm.live.b.f.rGw;
    parama = paramLiveConfig.ckA();
    k.g(parama, "config.hostRoomId");
    com.tencent.mm.live.b.f.aUk(parama);
    parama = com.tencent.mm.live.b.f.rGw;
    com.tencent.mm.live.b.f.a(new eas());
    parama = com.tencent.mm.live.b.f.rGw;
    com.tencent.mm.live.b.f.eNG().LwA = paramLiveConfig.ckB();
    parama = com.tencent.mm.live.b.f.rGw;
    com.tencent.mm.live.b.f.aUl(paramLiveConfig.cmT());
    parama = com.tencent.mm.live.b.f.rGw;
    parama = paramLiveConfig.ckD();
    k.g(parama, "config.anchorUsername");
    com.tencent.mm.live.b.f.aUm(parama);
    parama = com.tencent.mm.live.b.f.rGw;
    com.tencent.mm.live.b.f.eNG().LwF = true;
    parama = findViewById(2131307689);
    k.g(parama, "findViewById(R.id.live_right_panel_ui_root)");
    this.KBd = new com.tencent.mm.live.c.v((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307728);
    k.g(parama, "findViewById(R.id.live_title_ui_root)");
    this.KAd = new az((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307634);
    k.g(parama, "findViewById(R.id.live_minimize_ui_root)");
    this.KAj = new am((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307757);
    k.g(parama, "findViewById(R.id.live_visitor_comment_root)");
    this.KBf = new bh((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307560);
    k.g(parama, "findViewById(R.id.live_input_ui_root)");
    this.KBe = new z((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307473);
    k.g(parama, "findViewById(R.id.live_after_ui_root)");
    this.KzY = new com.tencent.mm.live.c.c((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307551);
    k.g(parama, "findViewById(R.id.live_input_debug_view_root)");
    this.KBg = new com.tencent.mm.live.c.q((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307569);
    k.g(parama, "findViewById(R.id.live_loading_view_root)");
    this.KAl = new ae((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307525);
    k.g(parama, "findViewById(R.id.live_comment_ui_root)");
    this.KAb = new m((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307595);
    k.g(parama, "findViewById(R.id.live_members_list_ui_root)");
    this.KAe = new ai((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307566);
    k.g(parama, "findViewById(R.id.live_like_confetti_ui_root)");
    this.KAn = new ac((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307626);
    k.g(parama, "findViewById(R.id.live_mic_visitor_header_root)");
    this.KAm = new ak((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307636);
    k.g(parama, "findViewById(R.id.live_preview_ui_root)");
    this.KBb = new bl((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307730);
    k.g(parama, "findViewById(R.id.live_tx_live_player_ui_root)");
    this.KBc = new aw((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307691);
    k.g(parama, "findViewById(R.id.live_shadow_ui_root)");
    this.KAa = new as((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307752);
    k.g(parama, "findViewById(R.id.live_video_mic_ui_root)");
    this.KBh = new bd((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307608);
    k.g(parama, "findViewById(R.id.live_members_profile_ui_root)");
    this.KAo = new ag((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307565);
    k.g(parama, "findViewById(R.id.live_kicked_ui_root)");
    this.KBi = new com.tencent.mm.live.c.ab((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307756);
    k.g(parama, "findViewById(R.id.live_visitor_close_ui_root)");
    this.KBj = new bf((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307536);
    k.g(parama, "findViewById(R.id.live_common_info_ui_root)");
    this.KAi = new o((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307547);
    k.g(parama, "findViewById(R.id.live_exception_ui_root)");
    this.KAq = new r((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307550);
    k.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
    this.KzW = new t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    localObject = this.KBb;
    if (localObject != null)
    {
      parama = this.KBh;
      if (parama != null)
      {
        parama = parama.fPa();
        ((bl)localObject).KxP = parama;
      }
    }
    else
    {
      parama = h.xfu;
      h.a(paramLiveConfig);
      parama = this.KzY;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.KAb;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.KAn;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      localObject = this.KAd;
      if (localObject != null)
      {
        parama = com.tencent.mm.live.b.f.rGw;
        parama = com.tencent.mm.live.b.f.eNG().LwZ;
        if (parama == null) {
          break label1724;
        }
        parama = (CharSequence)parama;
        label1087:
        com.tencent.mm.live.b.f localf = com.tencent.mm.live.b.f.rGw;
        ((az)localObject).g(parama, com.tencent.mm.live.b.f.eNI());
      }
      parama = this.KAe;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.KAo;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.KAi;
      if (parama != null) {
        parama.a(paramLiveConfig);
      }
      parama = this.KBc;
      if (parama != null)
      {
        k.h(paramLiveConfig, "config");
        if (paramLiveConfig.ckz() != LiveConfig.qsH) {
          break label1734;
        }
        localObject = com.tencent.mm.live.core.core.a.b.qym;
        localObject = parama.pTc.getContext();
        k.g(localObject, "root.context");
        parama.KwS = ((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.eG((Context)localObject));
      }
      label1203:
      parama = this.KBh;
      if (parama != null)
      {
        k.h(paramLiveConfig, "config");
        if (paramLiveConfig.ckz() != LiveConfig.qsH) {
          break label1771;
        }
        localObject = com.tencent.mm.live.core.core.a.b.qym;
        localObject = parama.pTc.getContext();
        k.g(localObject, "root.context");
        parama.KwS = ((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.eG((Context)localObject));
      }
      label1263:
      parama = this.KAi;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KBj;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KzY;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KBf;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KBe;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KBd;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KAe;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KAl;
      if (parama != null) {
        parama.aUv(paramLiveConfig.ckD());
      }
      parama = this.KBb;
      if (parama != null) {
        parama.agK(0);
      }
      parama = this.KBc;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KAa;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KBh;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KAo;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KBi;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KAq;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KzW;
      if (parama != null) {
        parama.agK(8);
      }
      localObject = this.KBb;
      if (localObject != null)
      {
        parama = (d.g.a.a)new e(this);
        localObject = ((bl)localObject).qDY;
        if (localObject != null) {
          ((LivePreviewView)localObject).setPreviewTouchListener(parama);
        }
      }
      parama = this.KBc;
      if (parama != null)
      {
        localObject = (d.g.a.b)new f(this);
        parama.KwQ.setOnClickListener((View.OnClickListener)new ay((d.g.a.b)localObject));
      }
      if (paramLiveConfig.getScene() == LiveConfig.qsE)
      {
        parama = this.KzY;
        if (parama != null)
        {
          parama.IIp.setVisibility(8);
          parama.IIo.setVisibility(0);
        }
      }
      parama = com.tencent.mm.live.b.f.rGw;
      com.tencent.mm.live.b.f.fOz().BMs = ((d.g.a.b)new g(this));
      parama = com.tencent.mm.live.b.c.qYi;
      com.tencent.mm.live.b.c.M((d.g.a.a)new h(this));
      parama = com.tencent.mm.kernel.g.afB();
      k.g(parama, "MMKernel.storage()");
      if (parama.afk().getInt(ae.a.LBF, 0) != 1) {
        break label1808;
      }
      parama = this.KBg;
      if (parama != null) {
        parama.agK(0);
      }
    }
    for (;;)
    {
      parama = com.tencent.mm.live.b.c.qYi;
      com.tencent.mm.live.b.c.L(this.Kvu);
      AppMethodBeat.o(203495);
      return;
      parama = null;
      break;
      label1724:
      parama = (CharSequence)"";
      break label1087;
      label1734:
      localObject = com.tencent.mm.live.core.core.c.b.qOk;
      localObject = parama.pTc.getContext();
      k.g(localObject, "root.context");
      parama.KwS = ((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.eH((Context)localObject));
      break label1203;
      label1771:
      localObject = com.tencent.mm.live.core.core.c.b.qOk;
      localObject = parama.pTc.getContext();
      k.g(localObject, "root.context");
      parama.KwS = ((com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.eH((Context)localObject));
      break label1263;
      label1808:
      parama = com.tencent.mm.live.b.f.rGw;
      if (com.tencent.mm.live.b.f.fhG() != 0)
      {
        parama = com.tencent.mm.live.b.f.rGw;
        int i = com.tencent.mm.live.b.f.fhG();
        parama = getContext();
        k.g(parama, "context");
        parama = parama.getResources();
        k.g(parama, "context.resources");
        if (i != parama.getConfiguration().orientation) {}
      }
      else
      {
        parama = com.tencent.mm.live.b.f.rGw;
        paramLiveConfig = com.tencent.mm.live.b.f.eNG().LwZ;
        parama = paramLiveConfig;
        if (paramLiveConfig == null) {
          parama = "";
        }
        paramLiveConfig = com.tencent.mm.live.b.f.rGw;
        long l = com.tencent.mm.live.b.f.eNG().LwA;
        paramLiveConfig = com.tencent.mm.live.b.f.rGw;
        d(parama, l, com.tencent.mm.live.b.f.eNB());
        continue;
      }
      b.b.a(this, b.c.FAV);
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int i = 2;
    AppMethodBeat.i(203499);
    k.h(paramc, "status");
    ad.i("MicroMsg.LiveCoreVisitor", "statusChange:" + paramc.name());
    switch (c.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(203499);
      return;
      Object localObject1 = com.tencent.mm.live.b.f.rGw;
      localObject1 = com.tencent.mm.live.b.f.eNB();
      Object localObject2 = com.tencent.mm.live.b.f.rGw;
      long l = com.tencent.mm.live.b.f.eNG().LwA;
      localObject2 = com.tencent.mm.live.b.f.rGw;
      i = com.tencent.mm.live.b.f.fOn();
      localObject2 = com.tencent.mm.live.b.f.rGw;
      int j = com.tencent.mm.live.b.f.fOp();
      localObject2 = com.tencent.mm.live.b.f.rGw;
      int k = com.tencent.mm.live.b.f.eNG().LyP;
      localObject2 = com.tencent.mm.live.b.f.rGw;
      int m = com.tencent.mm.live.b.f.fOq();
      localObject2 = com.tencent.mm.live.b.f.rGw;
      int n = com.tencent.mm.live.b.f.fOr();
      localObject2 = com.tencent.mm.live.b.f.rGw;
      int i1 = com.tencent.mm.live.b.f.fOs();
      localObject2 = com.tencent.mm.live.b.f.rGw;
      int i2 = com.tencent.mm.live.b.f.fOt();
      localObject2 = com.tencent.mm.live.b.f.rGw;
      localObject2 = com.tencent.mm.live.b.f.eNG().Lzg;
      k.g(localObject2, "LiveDataManager.liveInfo.anchor_identity_id");
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, (String)localObject2);
      localObject1 = com.tencent.mm.live.b.f.rGw;
      com.tencent.mm.live.b.f.fhF();
      localObject1 = com.tencent.mm.live.b.c.qYi;
      com.tencent.mm.live.b.c.dRl();
      localObject1 = h.xfu;
      h.fOF();
      h.xfu.release();
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(203499);
        throw paramc;
      }
      ((Activity)localObject1).finishAndRemoveTask();
      continue;
      this.KBk = true;
      localObject1 = h.xfu;
      h.fOH();
      continue;
      this.KBk = true;
      continue;
      h.xfu.fOI();
      localObject1 = h.xfu;
      h.fOE();
      localObject1 = com.tencent.mm.live.b.f.rGw;
      localObject1 = com.tencent.mm.live.b.f.rGw;
      com.tencent.mm.live.b.f.agB(com.tencent.mm.live.b.f.eNG().LyP);
      this.KAw = true;
      localObject1 = com.tencent.mm.live.b.f.rGw;
      com.tencent.mm.live.b.f.li(false);
      continue;
      if (!this.KBk)
      {
        localObject1 = this.KAe;
        if (localObject1 != null) {
          ((ai)localObject1).agK(0);
        }
        localObject1 = this.KAe;
        if (localObject1 != null)
        {
          ((ai)localObject1).fOW();
          continue;
          localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class);
          k.g(localObject1, "MMKernel.plugin(IPluginLive::class.java)");
          localObject1 = ((com.tencent.mm.live.a)localObject1).getLiveTipsBarStorage();
          localObject2 = com.tencent.mm.live.b.f.rGw;
          ((com.tencent.mm.live.b.c.b)localObject1).ci(com.tencent.mm.live.b.f.eNB(), 0L);
          localObject1 = com.tencent.mm.live.b.c.qYi;
          com.tencent.mm.live.b.c.dRl();
          h.xfu.release();
          localObject1 = getContext();
          if (localObject1 == null)
          {
            paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(203499);
            throw paramc;
          }
          ((Activity)localObject1).finishAndRemoveTask();
          continue;
          localObject1 = com.tencent.mm.live.b.f.rGw;
          localObject1 = com.tencent.mm.live.b.f.eNG().LwZ;
          k.g(localObject1, "LiveDataManager.liveInfo.live_name");
          localObject2 = com.tencent.mm.live.b.f.rGw;
          l = com.tencent.mm.live.b.f.eNG().LwA;
          localObject2 = com.tencent.mm.live.b.f.rGw;
          d((String)localObject1, l, com.tencent.mm.live.b.f.eNB());
          continue;
          localObject2 = this.KBb;
          if (localObject2 != null)
          {
            localObject1 = this.KBh;
            if (localObject1 != null) {}
            for (localObject1 = ((bd)localObject1).fPa();; localObject1 = null)
            {
              ((bl)localObject2).KxP = ((j)localObject1);
              break;
            }
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(203499);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(4);
            continue;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(203499);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(14);
            continue;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(203499);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(4);
            i = this.qzb;
            localObject1 = c.a.qxl;
            if (i == c.a.clO())
            {
              localObject1 = this.KBb;
              if (localObject1 != null) {
                ((bl)localObject1).exitRoom();
              }
              localObject1 = this.KBc;
              if (localObject1 != null) {
                ((aw)localObject1).agK(0);
              }
              localObject1 = this.KBc;
              if (localObject1 != null)
              {
                ((aw)localObject1).KwR.resume();
                continue;
                i = this.qzb;
                localObject1 = c.a.qxl;
                if (i == c.a.clK())
                {
                  fQD();
                }
                else
                {
                  localObject1 = c.a.qxl;
                  if (i == c.a.clO())
                  {
                    localObject1 = com.tencent.mm.live.b.f.rGw;
                    localObject1 = com.tencent.mm.live.b.f.eNK();
                    if (localObject1 != null)
                    {
                      localObject2 = this.KBb;
                      if (localObject2 != null)
                      {
                        ((bl)localObject2).a((d)localObject1, (d.g.a.b)new j(this));
                        continue;
                        localObject1 = com.tencent.mm.live.b.c.qYi;
                        com.tencent.mm.live.b.c.dRl();
                        h.xfu.release();
                        localObject1 = this.KAd;
                        if (localObject1 != null) {
                          ((az)localObject1).agK(8);
                        }
                        localObject1 = this.KAa;
                        if (localObject1 != null) {
                          ((as)localObject1).agK(8);
                        }
                        localObject1 = this.KzY;
                        if (localObject1 != null) {
                          ((com.tencent.mm.live.c.c)localObject1).agK(8);
                        }
                        localObject1 = this.KBf;
                        if (localObject1 != null) {
                          ((bh)localObject1).agK(8);
                        }
                        localObject1 = this.KBe;
                        if (localObject1 != null) {
                          ((z)localObject1).agK(8);
                        }
                        localObject1 = this.KBd;
                        if (localObject1 != null) {
                          ((com.tencent.mm.live.c.v)localObject1).agK(8);
                        }
                        localObject1 = this.KAe;
                        if (localObject1 != null) {
                          ((ai)localObject1).agK(8);
                        }
                        localObject1 = this.KAl;
                        if (localObject1 != null) {
                          ((ae)localObject1).agK(8);
                        }
                        localObject1 = this.KBb;
                        if (localObject1 != null) {
                          ((bl)localObject1).agK(8);
                        }
                        localObject1 = this.KBc;
                        if (localObject1 != null) {
                          ((aw)localObject1).agK(8);
                        }
                        localObject1 = this.KBh;
                        if (localObject1 != null) {
                          ((bd)localObject1).agK(8);
                        }
                        localObject1 = this.KAo;
                        if (localObject1 != null) {
                          ((ag)localObject1).agK(8);
                        }
                        localObject1 = this.KBi;
                        if (localObject1 != null) {
                          ((com.tencent.mm.live.c.ab)localObject1).agK(0);
                        }
                        localObject1 = this.KBi;
                        if (localObject1 != null)
                        {
                          localObject2 = com.tencent.mm.live.b.f.rGw;
                          localObject2 = com.tencent.mm.live.b.f.eNI();
                          Object localObject3 = com.tencent.mm.live.b.d.a.Fwy;
                          localObject3 = ((com.tencent.mm.live.c.a)localObject1).pTc.getContext();
                          k.g(localObject3, "root.context");
                          com.tencent.mm.live.b.d.a.a.a((String)localObject2, ((Context)localObject3).getResources().getColor(2131100482), (d.g.a.b)new ab.a((com.tencent.mm.live.c.ab)localObject1));
                          continue;
                          localObject1 = com.tencent.mm.live.b.f.rGw;
                          com.tencent.mm.live.b.f.agz(2);
                          if (!this.KBk)
                          {
                            localObject1 = this.KAl;
                            if (localObject1 != null)
                            {
                              localObject2 = com.tencent.mm.live.b.f.rGw;
                              localObject2 = com.tencent.mm.live.b.f.eNI();
                              localObject3 = getContext();
                              k.g(localObject3, "context");
                              localObject3 = ((Context)localObject3).getResources().getString(2131766590);
                              k.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
                              ((ae)localObject1).ca((String)localObject2, (String)localObject3);
                              continue;
                              localObject1 = com.tencent.mm.live.b.f.rGw;
                              com.tencent.mm.live.b.f.agz(1);
                              if (!this.KBk)
                              {
                                localObject1 = this.KAl;
                                if (localObject1 != null)
                                {
                                  localObject2 = com.tencent.mm.live.b.f.rGw;
                                  localObject2 = com.tencent.mm.live.b.f.eNI();
                                  localObject3 = getContext();
                                  k.g(localObject3, "context");
                                  localObject3 = ((Context)localObject3).getResources().getString(2131766548);
                                  k.g(localObject3, "context.resources.getStr…ive_anchor_exception_tip)");
                                  ((ae)localObject1).ca((String)localObject2, (String)localObject3);
                                  continue;
                                  localObject1 = this.KBb;
                                  if (localObject1 != null) {
                                    ((bl)localObject1).agK(0);
                                  }
                                  localObject1 = this.KBb;
                                  if (localObject1 != null) {
                                    ((bl)localObject1).fPf();
                                  }
                                  localObject1 = this.KBc;
                                  if (localObject1 != null) {
                                    ((aw)localObject1).agK(8);
                                  }
                                  localObject1 = this.KBc;
                                  if (localObject1 != null)
                                  {
                                    ((aw)localObject1).KwR.pause();
                                    continue;
                                    localObject1 = this.KAl;
                                    if (localObject1 != null)
                                    {
                                      ((ae)localObject1).agK(8);
                                      continue;
                                      this.KBm = true;
                                      localObject1 = this.Kxx;
                                      if (localObject1 != null)
                                      {
                                        localObject2 = getContext();
                                        k.g(localObject2, "context");
                                        ((com.tencent.mm.live.core.core.c.b)localObject1).eE((Context)localObject2);
                                      }
                                      localObject1 = com.tencent.mm.live.b.f.rGw;
                                      localObject1 = com.tencent.mm.live.b.f.eNB();
                                      localObject2 = com.tencent.mm.live.b.f.rGw;
                                      l = com.tencent.mm.live.b.f.eNG().LwA;
                                      localObject2 = com.tencent.mm.live.b.f.rGw;
                                      com.tencent.mm.live.d.e.a((String)localObject1, l, com.tencent.mm.live.b.f.eNI(), 2, 1);
                                      com.tencent.mm.live.d.f.fQe();
                                      continue;
                                      localObject1 = com.tencent.mm.live.b.f.rGw;
                                      localObject1 = com.tencent.mm.live.b.f.eNB();
                                      localObject2 = com.tencent.mm.live.b.f.rGw;
                                      l = com.tencent.mm.live.b.f.eNG().LwA;
                                      localObject2 = com.tencent.mm.live.b.f.rGw;
                                      com.tencent.mm.live.d.e.a((String)localObject1, l, com.tencent.mm.live.b.f.eNI(), 2, 0);
                                      com.tencent.mm.live.d.f.fQf();
                                      continue;
                                      this.KBm = true;
                                      continue;
                                      this.KBn = true;
                                      localObject1 = getContext();
                                      if (localObject1 == null)
                                      {
                                        paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                                        AppMethodBeat.o(203499);
                                        throw paramc;
                                      }
                                      ((Activity)localObject1).setRequestedOrientation(14);
                                      localObject1 = this.KzW;
                                      if (localObject1 != null)
                                      {
                                        ((t)localObject1).agK(0);
                                        continue;
                                        this.KBn = false;
                                        localObject1 = getContext();
                                        if (localObject1 == null)
                                        {
                                          paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                                          AppMethodBeat.o(203499);
                                          throw paramc;
                                        }
                                        ((Activity)localObject1).setRequestedOrientation(4);
                                        localObject1 = com.tencent.mm.live.b.c.qYi;
                                        com.tencent.mm.live.b.c.L(this.Kvu);
                                        localObject1 = com.tencent.mm.live.b.f.rGw;
                                        com.tencent.mm.live.b.f.Bf(System.currentTimeMillis());
                                        b.b.a(this, b.c.FBb);
                                        continue;
                                        localObject1 = this.KBb;
                                        if (localObject1 != null)
                                        {
                                          localObject2 = com.tencent.mm.live.b.f.rGw;
                                          if (com.tencent.mm.live.b.f.fhJ().aov()) {}
                                          for (;;)
                                          {
                                            localObject2 = com.tencent.mm.live.b.f.rGw;
                                            localObject2 = com.tencent.mm.live.b.f.fhJ().userId;
                                            localObject3 = com.tencent.mm.live.b.f.rGw;
                                            ((bl)localObject1).w(i, (String)localObject2, com.tencent.mm.live.b.f.fhJ().streamType);
                                            break;
                                            i = 1;
                                          }
                                          localObject1 = this.Kxx;
                                          if ((localObject1 == null) || (((com.tencent.mm.live.core.core.c.b)localObject1).col() != true))
                                          {
                                            localObject1 = this.Kxx;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.core.core.c.b)localObject1).cnS();
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
  
  public final boolean dia()
  {
    AppMethodBeat.i(203506);
    boolean bool2 = super.dia();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.KAw)
      {
        this.KAw = false;
        b.b.a(this, b.c.FAW);
        bool1 = true;
      }
    }
    AppMethodBeat.o(203506);
    return bool1;
  }
  
  public final void fOM()
  {
    AppMethodBeat.i(203504);
    super.fOM();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().a(3806, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(203504);
  }
  
  public final void fON()
  {
    AppMethodBeat.i(203505);
    super.fON();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().b(3806, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(203505);
  }
  
  public final int getLiveRole()
  {
    return 0;
  }
  
  public final int getRelativeLayoutId()
  {
    return 2131496347;
  }
  
  public final String name()
  {
    AppMethodBeat.i(203500);
    String str = LiveVisitorPluginLayout.class.getSimpleName();
    k.g(str, "LiveVisitorPluginLayout::class.java.simpleName");
    AppMethodBeat.o(203500);
    return str;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(203496);
    k.h(paramString, "incomingNumber");
    AppMethodBeat.o(203496);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(203507);
    ad.i("MicroMsg.LiveCoreVisitor", "errType:" + paramInt1 + " errCode:" + paramInt2);
    if (((paramn instanceof com.tencent.mm.live.b.a.b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.KBf;
      if (paramString != null) {
        paramString.fPb();
      }
      paramn = this.KAd;
      if (paramn != null)
      {
        paramString = com.tencent.mm.live.b.f.rGw;
        paramString = com.tencent.mm.live.b.f.eNG().LwZ;
        if (paramString == null) {
          break label145;
        }
        paramString = (CharSequence)paramString;
        com.tencent.mm.live.b.f localf = com.tencent.mm.live.b.f.rGw;
        paramn.g(paramString, com.tencent.mm.live.b.f.eNI());
      }
      paramString = com.tencent.mm.live.b.f.rGw;
      paramString = com.tencent.mm.live.b.f.rGw;
      if (com.tencent.mm.live.b.f.eNG().LwF) {
        break label155;
      }
    }
    label145:
    label155:
    for (paramInt1 = ce.asT();; paramInt1 = 0)
    {
      com.tencent.mm.live.b.f.agw(paramInt1);
      AppMethodBeat.o(203507);
      return;
      paramString = (CharSequence)"";
      break;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(203503);
    super.pause();
    if (!this.KBm)
    {
      com.tencent.mm.live.core.core.c.b localb = this.Kxx;
      if (localb != null)
      {
        localb.bYS();
        AppMethodBeat.o(203503);
        return;
      }
    }
    AppMethodBeat.o(203503);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(203502);
    Object localObject1 = new StringBuilder("curOrientation:");
    Object localObject2 = getContext();
    k.g(localObject2, "context");
    localObject2 = ((Context)localObject2).getResources();
    k.g(localObject2, "context.resources");
    localObject1 = ((StringBuilder)localObject1).append(((Resources)localObject2).getConfiguration().orientation).append(", lastOrientation:");
    localObject2 = com.tencent.mm.live.b.f.rGw;
    ad.i("MicroMsg.LiveCoreVisitor", com.tencent.mm.live.b.f.fhG());
    super.resume();
    localObject1 = com.tencent.mm.live.b.f.rGw;
    int i;
    if (com.tencent.mm.live.b.f.fhG() != 0)
    {
      localObject1 = getContext();
      k.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources();
      k.g(localObject1, "context.resources");
      i = ((Resources)localObject1).getConfiguration().orientation;
      localObject1 = com.tencent.mm.live.b.f.rGw;
      if (i != com.tencent.mm.live.b.f.fhG())
      {
        localObject1 = this.Kxx;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).csi();
        }
        localObject1 = this.KBb;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.live.b.f.rGw;
          if (!com.tencent.mm.live.b.f.fhJ().aov()) {
            break label268;
          }
          i = 2;
          localObject2 = com.tencent.mm.live.b.f.rGw;
          localObject2 = com.tencent.mm.live.b.f.fhJ().userId;
          com.tencent.mm.live.b.f localf = com.tencent.mm.live.b.f.rGw;
          ((bl)localObject1).w(i, (String)localObject2, com.tencent.mm.live.b.f.fhJ().streamType);
        }
      }
    }
    for (;;)
    {
      if (!this.KBm)
      {
        localObject1 = this.Kxx;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).bYR();
        }
        this.KBm = false;
      }
      localObject1 = com.tencent.mm.live.b.f.rGw;
      localObject1 = getContext();
      k.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources();
      k.g(localObject1, "context.resources");
      com.tencent.mm.live.b.f.agx(((Resources)localObject1).getConfiguration().orientation);
      AppMethodBeat.o(203502);
      return;
      label268:
      i = 1;
      break;
      localObject1 = this.Kxx;
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject1).clo();
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(203501);
    super.start();
    Object localObject = h.xfu;
    h.fOH();
    localObject = this.Kxx;
    if ((localObject == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject).qEd.cnw() != true))
    {
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(203501);
        throw ((Throwable)localObject);
      }
      ((Activity)localObject).setRequestedOrientation(4);
    }
    AppMethodBeat.o(203501);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ret", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.q<Integer, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, y>
  {
    b(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    public static final c KBq;
    
    static
    {
      AppMethodBeat.i(203484);
      KBq = new c();
      AppMethodBeat.o(203484);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ret", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.q<Integer, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, y>
  {
    d(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<View, y>
  {
    f(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "liveID", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Long, y>
  {
    g(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/live/view/LiveVisitorPluginLayout$statusChange$1$1"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    j(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVisitorPluginLayout
 * JD-Core Version:    0.7.0.1
 */