package com.tencent.mm.live.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.e.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.f.b;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.c.ac;
import com.tencent.mm.live.c.ae;
import com.tencent.mm.live.c.ag;
import com.tencent.mm.live.c.ai;
import com.tencent.mm.live.c.ak;
import com.tencent.mm.live.c.ao;
import com.tencent.mm.live.c.aq;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.au;
import com.tencent.mm.live.c.az;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.c.bb;
import com.tencent.mm.live.c.i;
import com.tencent.mm.live.c.x;
import com.tencent.mm.live.c.x.b;
import com.tencent.mm.live.c.x.c;
import com.tencent.mm.live.c.x.d;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.b.e.b;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.p;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.v;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/LiveAnchorPluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "curNetworkQuality", "", "curStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "forcePush", "", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveAnchorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "liveAnchorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorMicPlugin;", "liveBanCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "liveBeforePlugin", "Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveHasError", "liveHasFinished", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "liveReadyPlugin", "Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "liveRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveShareRoomsPlugin", "Lcom/tencent/mm/live/plugin/LiveShareRoomsPlugin;", "liveStarted", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "navigation", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "nextStatus", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "pluginShow", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkInitStatus", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "checkVerify", "createNewLive", "liveName", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "initLogic", "router", "isFinished", "joinLive", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onOrientationChange", "orientation", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "refreshCamera", "resume", "start", "startLive", "liveId", "", "statusChange", "status", "stopLive", "toggleShowPlugins", "tryResumeLive", "unMount", "updatePlugin", "plugin-logic_release"})
public final class LiveAnchorPluginLayout
  extends BaseLivePluginLayout
  implements com.tencent.mm.al.g, com.tencent.mm.live.core.core.b, d.a
{
  private boolean KAA;
  private as KAa;
  private com.tencent.mm.live.c.m KAb;
  private aq KAc;
  private az KAd;
  private ai KAe;
  private x KAf;
  private com.tencent.mm.live.c.g KAg;
  private i KAh;
  private com.tencent.mm.live.c.o KAi;
  private com.tencent.mm.live.c.am KAj;
  private au KAk;
  private ae KAl;
  private ak KAm;
  private ac KAn;
  private ag KAo;
  private com.tencent.mm.live.c.e KAp;
  private com.tencent.mm.live.c.r KAq;
  private com.tencent.mm.live.a.a KAr;
  private b.c KAs;
  private b.c KAt;
  private boolean KAu;
  private boolean KAv;
  private boolean KAw;
  private boolean KAx;
  private int KAy;
  private final ArrayList<com.tencent.mm.live.c.a> KAz;
  private d.g.a.a<y> Kvu;
  private com.tencent.mm.live.core.core.a.a KwF;
  private bb KzV;
  private com.tencent.mm.live.c.t KzW;
  private com.tencent.mm.live.c.k KzX;
  private com.tencent.mm.live.c.c KzY;
  private ao KzZ;
  private final String TAG;
  private com.tencent.mm.plugin.mmsight.model.d tKW;
  
  public LiveAnchorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(203436);
    this.TAG = "MicroMsg.LiveAnchorPluginLayout";
    this.KAs = b.c.FAS;
    this.KAt = b.c.FAS;
    paramContext = c.c.qyj;
    this.KAy = c.c.cmG();
    this.KAz = new ArrayList();
    this.KAA = true;
    this.Kvu = ((d.g.a.a)new f(this));
    AppMethodBeat.o(203436);
  }
  
  private final void fQB()
  {
    AppMethodBeat.i(203431);
    ad.i("MicroMsg.LiveCoreAnchor", "stopLive");
    Object localObject = this.KwF;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.a.a)localObject).clu();
      if ((localObject != null) && (((com.tencent.mm.live.core.core.b.e)localObject).qzP == true))
      {
        localObject = com.tencent.mm.live.core.debug.a.qOL;
        com.tencent.mm.live.core.debug.a.aUc("activity recycler");
        AppMethodBeat.o(203431);
        return;
      }
    }
    localObject = this.KwF;
    if (localObject != null)
    {
      ((com.tencent.mm.live.core.core.a.a)localObject).b((com.tencent.mm.live.core.core.b)new h(this));
      AppMethodBeat.o(203431);
      return;
    }
    AppMethodBeat.o(203431);
  }
  
  public final void B(int paramInt, Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 1;
    int i = 0;
    AppMethodBeat.i(203435);
    Object localObject4 = c.b.qye;
    if (paramInt == c.b.clQ())
    {
      b.b.a(this, b.c.FBq);
      paramBundle = this.KAg;
      if (paramBundle != null)
      {
        localObject1 = paramBundle.Jhb;
        d.g.b.k.g(localObject1, "liveStateTv");
        ((TextView)localObject1).setText((CharSequence)paramBundle.pTc.getContext().getString(2131766678));
        paramBundle.IIH.setImageDrawable(com.tencent.mm.ui.am.e(paramBundle.pTc.getResources().getDrawable(2131690494), -1));
        AppMethodBeat.o(203435);
        return;
      }
      AppMethodBeat.o(203435);
      return;
    }
    localObject4 = c.b.qye;
    if (paramInt == c.b.cmv())
    {
      paramBundle = this.KwF;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.clu();
        if (paramBundle != null)
        {
          if (paramBundle.cnw() != true) {
            break label1358;
          }
          paramBundle = this.KwF;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.clu();
            if (paramBundle != null) {
              paramBundle.qzO = e.b.qAX;
            }
          }
          paramBundle = this.KAg;
          if (paramBundle == null) {
            break label215;
          }
          paramBundle.fOQ();
          AppMethodBeat.o(203435);
          return;
        }
      }
      AppMethodBeat.o(203435);
      return;
      label215:
      AppMethodBeat.o(203435);
    }
    else
    {
      localObject4 = c.b.qye;
      if (paramInt == c.b.clR())
      {
        if (paramBundle != null)
        {
          localObject2 = paramBundle.getString("live_user_id");
          paramBundle.getString("live_user_exit_reason");
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
          paramBundle = f.rGw;
          paramBundle = f.fOz().BMx;
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.Csx;; paramBundle = null)
          {
            ad.i((String)localObject3, paramBundle);
            paramBundle = f.rGw;
            localObject3 = f.fOz().BMx;
            paramBundle = (Bundle)localObject1;
            if (localObject3 != null) {
              paramBundle = ((a.a)localObject3).Csx;
            }
            if (!d.g.b.k.g(localObject2, paramBundle)) {
              break;
            }
            paramBundle = this.KwF;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.cd.a.aq(getContext(), 2131766671);
              d.g.b.k.g(localObject1, "ResourceHelper.getString…ring.live_room_mini_live)");
              paramBundle.aTU((String)localObject1);
            }
            b.b.a(this, b.c.FBf);
            paramBundle = f.rGw;
            paramBundle = f.fOz().BMx;
            if (paramBundle == null) {
              break;
            }
            localObject1 = f.rGw;
            f.fOz().g(paramBundle.DlB, paramBundle.CaG, paramBundle.BQP);
            AppMethodBeat.o(203435);
            return;
          }
          AppMethodBeat.o(203435);
          return;
        }
        AppMethodBeat.o(203435);
        return;
      }
      localObject1 = c.b.qye;
      if (paramInt == c.b.clS())
      {
        if (paramBundle != null)
        {
          localObject1 = paramBundle.getString("live_user_id");
          boolean bool = paramBundle.getBoolean("live_media_enable");
          paramBundle = f.rGw;
          localObject2 = f.fOz().BMx;
          paramBundle = (Bundle)localObject3;
          if (localObject2 != null) {
            paramBundle = ((a.a)localObject2).Csx;
          }
          if (d.g.b.k.g(localObject1, paramBundle))
          {
            if (bool)
            {
              paramBundle = this.KwF;
              if (paramBundle != null)
              {
                localObject1 = com.tencent.mm.cd.a.aq(getContext(), 2131766672);
                d.g.b.k.g(localObject1, "ResourceHelper.getString…tring.live_room_mini_mic)");
                paramBundle.aTU((String)localObject1);
              }
              b.b.a(this, b.c.FBc);
              AppMethodBeat.o(203435);
              return;
            }
            paramBundle = this.KwF;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.cd.a.aq(getContext(), 2131766671);
              d.g.b.k.g(localObject1, "ResourceHelper.getString…ring.live_room_mini_live)");
              paramBundle.aTU((String)localObject1);
            }
            b.b.a(this, b.c.FBf);
          }
          AppMethodBeat.o(203435);
          return;
        }
        AppMethodBeat.o(203435);
        return;
      }
      localObject1 = c.b.qye;
      if (paramInt == c.b.cmb())
      {
        i = this.KAy;
        paramBundle = this.KwF;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.clu();
          if (paramBundle != null)
          {
            paramInt = paramBundle.zCj;
            this.KAy = paramInt;
            paramBundle = c.c.qyj;
            if (i == c.c.cnp()) {
              break label769;
            }
            paramInt = this.KAy;
            paramBundle = c.c.qyj;
            if (paramInt != c.c.cnp()) {
              break label769;
            }
            b.b.a(this, b.c.HRK);
            if (this.KzZ != null) {}
          }
        }
        for (;;)
        {
          paramInt = this.KAy;
          paramBundle = c.c.qyj;
          if (paramInt != c.c.cmA()) {
            break label813;
          }
          com.tencent.mm.live.core.c.a.deF();
          AppMethodBeat.o(203435);
          return;
          paramBundle = c.c.qyj;
          paramInt = c.c.cmG();
          break;
          label769:
          paramBundle = c.c.qyj;
          if (i == c.c.cnp())
          {
            paramInt = this.KAy;
            paramBundle = c.c.qyj;
            if (paramInt != c.c.cnp())
            {
              b.b.a(this, b.c.HRL);
              paramBundle = h.xfu;
              h.fOH();
            }
          }
        }
        label813:
        paramBundle = c.c.qyj;
        if (paramInt == c.c.cmG())
        {
          com.tencent.mm.live.core.c.a.dhn();
          AppMethodBeat.o(203435);
          return;
        }
        paramBundle = c.c.qyj;
        if (paramInt == c.c.cnl())
        {
          com.tencent.mm.live.core.c.a.dic();
          AppMethodBeat.o(203435);
          return;
        }
        paramBundle = c.c.qyj;
        if (paramInt == c.c.cnp()) {
          com.tencent.mm.live.core.c.a.dnA();
        }
        AppMethodBeat.o(203435);
        return;
      }
      localObject1 = c.b.qye;
      long l;
      if (paramInt == c.b.cml())
      {
        paramBundle = this.KwF;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.clu();
          if ((paramBundle != null) && (paramBundle.cnx() == true)) {
            i = j;
          }
        }
        for (;;)
        {
          paramBundle = f.rGw;
          localObject2 = f.eNB();
          paramBundle = f.rGw;
          l = f.eNG().LwA;
          paramBundle = f.rGw;
          paramBundle = f.fOz().BMx;
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
          localObject1 = f.rGw;
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, f.eNI(), i, 0, paramInt);
          AppMethodBeat.o(203435);
          return;
          paramBundle = this.KwF;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.clu();
            if ((paramBundle != null) && (paramBundle.cnw() == true))
            {
              i = 2;
              continue;
            }
          }
          i = 0;
        }
      }
      localObject1 = c.b.qye;
      if (paramInt == c.b.cmw())
      {
        paramBundle = f.rGw;
        l = f.eNG().LwA;
        paramBundle = f.rGw;
        paramBundle = f.eNB();
        localObject1 = f.rGw;
        localObject1 = f.eNG().LwZ;
        d.g.b.k.g(localObject1, "LiveDataManager.liveInfo.live_name");
        new com.tencent.mm.live.b.a(l, paramBundle, (String)localObject1, (byte)0).d((d.g.a.q)new a(this));
        AppMethodBeat.o(203435);
        return;
      }
      localObject1 = c.b.qye;
      if (paramInt == c.b.cmy())
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
          localObject1 = f.rGw;
          localObject3 = f.fhJ();
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
          ((f.b)localObject3).setUserId((String)localObject1);
          localObject1 = f.rGw;
          localObject1 = f.fhJ();
          if (paramBundle == null) {
            break label1365;
          }
          paramInt = paramBundle.getInt("live_stream_type");
          ((f.b)localObject1).streamType = paramInt;
          localObject1 = f.rGw;
          localObject1 = f.fhJ();
          if (paramBundle == null) {
            break label1370;
          }
        }
      }
    }
    label1358:
    label1365:
    label1370:
    for (paramInt = paramBundle.getInt("live_first_frame_width");; paramInt = 0)
    {
      ((f.b)localObject1).width = paramInt;
      localObject1 = f.rGw;
      localObject1 = f.fhJ();
      paramInt = i;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("live_first_frame_height");
      }
      ((f.b)localObject1).height = paramInt;
      b.b.a(this, b.c.HWJ);
      AppMethodBeat.o(203435);
      return;
      paramInt = 0;
      break;
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void a(com.tencent.mm.live.a.a parama, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(203423);
    d.g.b.k.h(parama, "router");
    d.g.b.k.h(paramLiveConfig, "config");
    this.tKW = new com.tencent.mm.plugin.mmsight.model.d(getContext(), (byte)0);
    this.KAr = parama;
    parama = com.tencent.mm.live.core.core.a.b.qym;
    parama = getContext();
    d.g.b.k.g(parama, "context");
    this.KwF = ((com.tencent.mm.live.core.core.a.a)b.a.eG(parama));
    parama = this.KwF;
    if (parama != null) {
      parama.c((com.tencent.mm.live.core.core.b)this);
    }
    h.xfu.release();
    parama = f.rGw;
    parama = paramLiveConfig.ckA();
    d.g.b.k.g(parama, "config.hostRoomId");
    f.aUk(parama);
    parama = f.rGw;
    parama = paramLiveConfig.ckD();
    d.g.b.k.g(parama, "config.anchorUsername");
    f.aUm(parama);
    parama = findViewById(2131307744);
    d.g.b.k.g(parama, "findViewById(R.id.live_verify_ui_root)");
    this.KzV = new bb((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307550);
    d.g.b.k.g(parama, "findViewById(R.id.live_face_verify_ui_root)");
    this.KzW = new com.tencent.mm.live.c.t((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307514);
    d.g.b.k.g(parama, "findViewById(R.id.live_before_ui_root)");
    this.KzX = new com.tencent.mm.live.c.k((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307473);
    d.g.b.k.g(parama, "findViewById(R.id.live_after_ui_root)");
    this.KzY = new com.tencent.mm.live.c.c((RelativeLayout)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307636);
    d.g.b.k.g(parama, "findViewById(R.id.live_preview_ui_root)");
    this.KzZ = new ao((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307691);
    d.g.b.k.g(parama, "findViewById(R.id.live_shadow_ui_root)");
    this.KAa = new as((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307525);
    d.g.b.k.g(parama, "findViewById(R.id.live_comment_ui_root)");
    this.KAb = new com.tencent.mm.live.c.m((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307642);
    d.g.b.k.g(parama, "findViewById(R.id.live_ready_ui_root)");
    this.KAc = new aq((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307728);
    d.g.b.k.g(parama, "findViewById(R.id.live_title_ui_root)");
    this.KAd = new az((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307689);
    d.g.b.k.g(parama, "findViewById(R.id.live_right_panel_ui_root)");
    this.KAf = new x((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307681);
    d.g.b.k.g(parama, "findViewById(R.id.live_right_panel_btn4_parent)");
    this.KAg = new com.tencent.mm.live.c.g((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307595);
    d.g.b.k.g(parama, "findViewById(R.id.live_members_list_ui_root)");
    this.KAe = new ai((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307505);
    d.g.b.k.g(parama, "findViewById(R.id.live_ban_comment_ui_root)");
    this.KAh = new i((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307536);
    d.g.b.k.g(parama, "findViewById(R.id.live_common_info_ui_root)");
    this.KAi = new com.tencent.mm.live.c.o((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307634);
    d.g.b.k.g(parama, "findViewById(R.id.live_minimize_ui_root)");
    this.KAj = new com.tencent.mm.live.c.am((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307705);
    d.g.b.k.g(parama, "findViewById(R.id.live_share_rooms_ui_root)");
    this.KAk = new au((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307569);
    d.g.b.k.g(parama, "findViewById(R.id.live_loading_view_root)");
    this.KAl = new ae((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307626);
    d.g.b.k.g(parama, "findViewById(R.id.live_mic_visitor_header_root)");
    this.KAm = new ak((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307566);
    d.g.b.k.g(parama, "findViewById(R.id.live_like_confetti_ui_root)");
    this.KAn = new ac((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307608);
    d.g.b.k.g(parama, "findViewById(R.id.live_members_profile_ui_root)");
    this.KAo = new ag((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307479);
    d.g.b.k.g(parama, "findViewById(R.id.live_anchor_close_ui_root)");
    this.KAp = new com.tencent.mm.live.c.e((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = findViewById(2131307547);
    d.g.b.k.g(parama, "findViewById(R.id.live_exception_ui_root)");
    this.KAq = new com.tencent.mm.live.c.r((ViewGroup)parama, (com.tencent.mm.live.c.b)this);
    parama = this.KzZ;
    Object localObject;
    if (parama != null)
    {
      localObject = (d.g.a.m)new c(this);
      parama.qDY.setPreviewMoveListener((d.g.a.m)localObject);
    }
    parama = h.xfu;
    h.a(paramLiveConfig);
    parama = this.KAf;
    if (parama != null)
    {
      d.g.b.k.h(paramLiveConfig, "config");
      localObject = parama.Kvk;
      d.g.b.k.g(localObject, "shareBtn");
      ((ImageView)localObject).setVisibility(0);
      localObject = parama.tKB;
      d.g.b.k.g(localObject, "switchCameraBtn");
      ((ImageView)localObject).setVisibility(0);
      localObject = parama.Kvn;
      d.g.b.k.g(localObject, "liveScreenBtn");
      ((ImageView)localObject).setVisibility(0);
      parama.Kvk.setImageDrawable(com.tencent.mm.ui.am.e(parama.pTc.getResources().getDrawable(2131690478), -1));
      parama.tKB.setImageDrawable(com.tencent.mm.ui.am.e(parama.pTc.getResources().getDrawable(2131690362), -1));
      parama.Kvn.setImageDrawable(com.tencent.mm.ui.am.e(parama.pTc.getResources().getDrawable(2131691513), -1));
      parama.Kvl.setOnClickListener((View.OnClickListener)new x.b(parama));
      parama.Kvm.setOnClickListener((View.OnClickListener)new x.c(parama));
      parama.Kvo.setOnClickListener((View.OnClickListener)new x.d(parama));
      localObject = parama.Kvl;
      d.g.b.k.g(localObject, "shareBtnClickArea");
      ((RelativeLayout)localObject).setVisibility(8);
      localObject = parama.Kvp;
      d.g.b.k.g(localObject, "shareDescTv");
      ((TextView)localObject).setVisibility(8);
      localObject = parama.Kvo;
      d.g.b.k.g(localObject, "liveScreenBtnClickArea");
      ((RelativeLayout)localObject).setVisibility(8);
      parama = parama.Kvr;
      d.g.b.k.g(parama, "screenDescTv");
      parama.setVisibility(8);
    }
    parama = this.KAe;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
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
    parama = this.KzY;
    if (parama != null) {
      parama.fOP();
    }
    parama = this.KAo;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.KAi;
    if (parama != null) {
      parama.a(paramLiveConfig);
    }
    parama = this.KAp;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KzV;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KzW;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KzX;
    if (parama != null) {
      parama.agK(0);
    }
    parama = this.KzZ;
    if (parama != null) {
      parama.agK(0);
    }
    parama = this.KAa;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KzY;
    if (parama != null) {
      parama.agK(4);
    }
    parama = this.KAb;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KAc;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KAd;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KAe;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KAf;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KAh;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KAi;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KAj;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KAk;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KAl;
    if (parama != null)
    {
      localObject = f.rGw;
      parama.aUv(f.eNI());
    }
    parama = this.KAo;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KAq;
    if (parama != null) {
      parama.agK(8);
    }
    parama = this.KzZ;
    if (parama != null)
    {
      localObject = (d.g.a.a)new d(this);
      parama.qDY.setPreviewTouchListener((d.g.a.a)localObject);
    }
    if (paramBoolean)
    {
      b.b.a(this, b.c.FBn);
      parama = this.tKW;
      if (parama != null) {
        parama.a(null);
      }
      parama = this.tKW;
      if (parama != null) {
        parama.disable();
      }
      this.tKW = null;
    }
    for (;;)
    {
      parama = com.tencent.mm.live.b.c.qYi;
      com.tencent.mm.live.b.c.L(this.Kvu);
      AppMethodBeat.o(203423);
      return;
      if ((paramLiveConfig.ckB() != 0L) && (!bt.isNullOrNil(paramLiveConfig.ckA())))
      {
        ad.i(this.TAG, "init anchor plugin with live data, liveId:" + paramLiveConfig.ckB() + ", liveName:" + paramLiveConfig.ckC() + ", roomId:" + paramLiveConfig.ckA());
        parama = f.rGw;
        f.eNG().LwZ = paramLiveConfig.ckC();
        parama = f.rGw;
        f.eNG().LwA = paramLiveConfig.ckB();
        parama = f.rGw;
        parama = paramLiveConfig.ckA();
        d.g.b.k.g(parama, "config.hostRoomId");
        f.aUk(parama);
        parama = this.KAd;
        if (parama != null)
        {
          paramLiveConfig = f.rGw;
          paramLiveConfig = f.eNG().LwZ;
          d.g.b.k.g(paramLiveConfig, "LiveDataManager.liveInfo.live_name");
          paramLiveConfig = (CharSequence)paramLiveConfig;
          localObject = f.rGw;
          parama.g(paramLiveConfig, f.eNI());
        }
      }
      for (this.KAt = b.c.HRT;; this.KAt = b.c.FAS)
      {
        if ((this.KzV == null) || (bb.fOZ() != true)) {
          break label1913;
        }
        a(b.c.FAP, new Bundle());
        break;
        ad.i(this.TAG, "init logic from directly start");
        parama = f.rGw;
        f.eNG().LwA = 0L;
      }
      label1913:
      parama = this.KzZ;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KzV;
      if (parama != null) {
        parama.agK(0);
      }
      parama = this.KzW;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KzX;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KzY;
      if (parama != null) {
        parama.agK(4);
      }
      parama = this.KAb;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KAf;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KAd;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KAa;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KAh;
      if (parama != null) {
        parama.agK(8);
      }
      parama = this.KAl;
      if (parama != null) {
        parama.agK(8);
      }
      a(b.c.FAO, new Bundle());
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    boolean bool1 = false;
    int i = 1;
    AppMethodBeat.i(203422);
    d.g.b.k.h(paramc, "status");
    ad.i(this.TAG, "statusChange:" + paramc.name());
    this.KAs = paramc;
    switch (b.fPQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(203422);
      return;
      Object localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(203422);
        throw paramc;
      }
      ((Activity)localObject1).setRequestedOrientation(4);
      localObject1 = this.KAt;
      Object localObject2;
      Object localObject3;
      switch (b.ciE[localObject1.ordinal()])
      {
      default: 
        break;
      case 1: 
        localObject1 = this.KzZ;
        if (localObject1 != null) {
          ((ao)localObject1).agK(0);
        }
        localObject1 = this.KzV;
        if (localObject1 != null) {
          ((bb)localObject1).agK(8);
        }
        localObject1 = this.KzW;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.t)localObject1).agK(8);
        }
        localObject1 = this.KzX;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.k)localObject1).agK(8);
        }
        localObject1 = this.KzY;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.c)localObject1).agK(8);
        }
        localObject1 = this.KAb;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.m)localObject1).agK(8);
        }
        localObject1 = this.KAf;
        if (localObject1 != null) {
          ((x)localObject1).agK(8);
        }
        localObject1 = this.KAd;
        if (localObject1 != null) {
          ((az)localObject1).agK(8);
        }
        localObject1 = this.KAa;
        if (localObject1 != null) {
          ((as)localObject1).agK(8);
        }
        localObject1 = this.KAh;
        if (localObject1 != null) {
          ((i)localObject1).agK(8);
        }
        localObject1 = this.KAd;
        if (localObject1 != null)
        {
          localObject2 = f.rGw;
          localObject2 = f.eNG().LwZ;
          d.g.b.k.g(localObject2, "LiveDataManager.liveInfo.live_name");
          localObject2 = (CharSequence)localObject2;
          localObject3 = f.rGw;
          ((az)localObject1).g((CharSequence)localObject2, f.eNI());
        }
        a(b.c.HRT, new Bundle());
        break;
      case 2: 
        a(b.c.FAS, new Bundle());
        continue;
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(203422);
          throw paramc;
        }
        ((Activity)localObject1).setRequestedOrientation(14);
        continue;
        localObject1 = this.tKW;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).disable();
        }
        localObject1 = this.tKW;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a(null);
        }
        this.tKW = null;
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(203422);
          throw paramc;
        }
        ((Activity)localObject1).setRequestedOrientation(14);
        localObject1 = com.tencent.mm.live.core.core.trtc.a.a.cpE();
        d.g.b.k.g(localObject1, "ConfigHelper.getInstance()");
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).cpF();
        d.g.b.k.g(localObject1, "ConfigHelper.getInstance().videoConfig");
        localObject2 = getContext();
        d.g.b.k.g(localObject2, "context");
        localObject2 = ((Context)localObject2).getResources();
        d.g.b.k.g(localObject2, "context.resources");
        if (((Resources)localObject2).getConfiguration().orientation == 1)
        {
          bool1 = true;
          label710:
          ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject1).kN(bool1);
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("create live, isVideoVertical:");
          localObject3 = com.tencent.mm.live.core.core.trtc.a.a.cpE();
          d.g.b.k.g(localObject3, "ConfigHelper.getInstance()");
          localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).cpF();
          d.g.b.k.g(localObject3, "ConfigHelper.getInstance().videoConfig");
          ad.i((String)localObject1, ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).crr());
          localObject1 = f.rGw;
          localObject3 = f.eNG();
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
          ((eas)localObject3).LwZ = ((String)localObject1);
          localObject1 = f.rGw;
          localObject1 = f.eNG().LwZ;
          d.g.b.k.g(localObject1, "LiveDataManager.liveInfo.live_name");
          localObject2 = f.rGw;
          l = f.eNG().LwA;
          localObject2 = f.rGw;
          localObject2 = f.eNB();
          ad.i("MicroMsg.LiveCoreAnchor", "startLive, name:" + (String)localObject1 + ", roomId:" + l);
          if ((l == 0L) || (bt.isNullOrNil((String)localObject2))) {
            break label1021;
          }
          ad.i("MicroMsg.LiveCoreAnchor", "try resume live, liveId:" + l + ", liveName:" + (String)localObject1 + ", roomId:" + (String)localObject2);
          new com.tencent.mm.live.b.a(l, (String)localObject2, (String)localObject1, (byte)0).d((d.g.a.q)new i(this));
        }
        for (;;)
        {
          localObject1 = this.KwF;
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.live.core.core.a.a)localObject1).clI();
          break;
          bool1 = false;
          break label710;
          label1021:
          ad.i("MicroMsg.LiveCoreAnchor", "createNewLive, liveName:" + (String)localObject1 + ", wechatRoomId:" + (String)localObject2);
          localObject3 = getContext();
          d.g.b.k.g(localObject3, "context");
          localObject1 = new com.tencent.mm.live.b.b((String)localObject1, (String)localObject2, (Context)localObject3);
          localObject2 = (d.g.a.r)new b(this);
          localObject3 = com.tencent.mm.kernel.g.afA();
          d.g.b.k.g(localObject3, "MMKernel.network()");
          ((com.tencent.mm.kernel.b)localObject3).aeS().a(3501, (com.tencent.mm.al.g)localObject1);
          localObject3 = new com.tencent.mm.live.b.a.k(((com.tencent.mm.live.b.b)localObject1).name, ((com.tencent.mm.live.b.b)localObject1).roomId);
          localObject4 = com.tencent.mm.kernel.g.afA();
          d.g.b.k.g(localObject4, "MMKernel.network()");
          ((com.tencent.mm.kernel.b)localObject4).aeS().b((com.tencent.mm.al.n)localObject3);
          ((com.tencent.mm.live.b.b)localObject1).qWR = ((d.g.a.r)localObject2);
        }
        localObject1 = f.rGw;
        localObject1 = f.eNG().LwZ;
        d.g.b.k.g(localObject1, "LiveDataManager.liveInfo.live_name");
        localObject2 = f.rGw;
        localObject2 = f.eNB();
        localObject3 = getContext();
        d.g.b.k.g(localObject3, "context");
        localObject1 = new com.tencent.mm.live.b.b((String)localObject1, (String)localObject2, (Context)localObject3);
        localObject2 = (d.g.a.r)new e(this);
        localObject3 = com.tencent.mm.kernel.g.afA();
        d.g.b.k.g(localObject3, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject3).aeS().a(3797, (com.tencent.mm.al.g)localObject1);
        localObject3 = f.rGw;
        long l = f.eNG().LwA;
        localObject3 = ((com.tencent.mm.live.b.b)localObject1).roomId;
        Object localObject4 = f.rGw;
        localObject3 = new com.tencent.mm.live.b.a.n(l, (String)localObject3, f.eNF());
        localObject4 = com.tencent.mm.kernel.g.afA();
        d.g.b.k.g(localObject4, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject4).aeS().b((com.tencent.mm.al.n)localObject3);
        ((com.tencent.mm.live.b.b)localObject1).qWS = ((d.g.a.r)localObject2);
        continue;
        localObject1 = this.KAl;
        if (localObject1 != null) {
          ((ae)localObject1).agK(8);
        }
        localObject1 = e.e.rBl;
        localObject1 = ax.aFD(e.e.equ());
        localObject2 = e.e.rBl;
        localObject2 = e.e.eqv();
        localObject3 = f.rGw;
        ((ax)localObject1).putLong((String)localObject2, f.eNG().LwA);
        h.xfu.fOI();
        localObject1 = h.xfu;
        h.fOE();
        localObject1 = f.rGw;
        if (f.eNG().CJd == 0)
        {
          localObject1 = f.rGw;
          f.eNG().CJd = ce.asT();
        }
        this.KAw = true;
        continue;
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(203422);
          throw paramc;
        }
        ((Activity)localObject1).finishAndRemoveTask();
        continue;
        localObject1 = this.KAl;
        if (localObject1 != null) {
          ((ae)localObject1).agK(8);
        }
        fQB();
        this.KAu = true;
        localObject1 = h.xfu;
        h.fOG();
        localObject1 = h.xfu;
        h.fOH();
        h.xfu.release();
        localObject1 = com.tencent.mm.live.b.c.qYi;
        com.tencent.mm.live.b.c.dRl();
        this.KAw = false;
        localObject1 = e.e.rBl;
        localObject1 = ax.aFD(e.e.equ());
        localObject2 = e.e.rBl;
        ((ax)localObject1).putLong(e.e.eqv(), 0L);
        continue;
        if (!this.KAu)
        {
          localObject1 = this.KAc;
          if (localObject1 != null) {
            ((aq)localObject1).agK(8);
          }
          localObject1 = this.KzZ;
          if (localObject1 != null) {
            ((ao)localObject1).agK(8);
          }
          localObject1 = this.KzV;
          if (localObject1 != null) {
            ((bb)localObject1).agK(8);
          }
          localObject1 = this.KzW;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.t)localObject1).agK(8);
          }
          localObject1 = this.KzX;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.k)localObject1).agK(8);
          }
          localObject1 = this.KAl;
          if (localObject1 != null)
          {
            localObject2 = f.rGw;
            localObject2 = f.eNI();
            localObject3 = getContext();
            d.g.b.k.g(localObject3, "context");
            localObject3 = ((Context)localObject3).getResources().getString(2131766590);
            d.g.b.k.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
            ((ae)localObject1).ca((String)localObject2, (String)localObject3);
          }
          this.KAv = true;
          continue;
          if (!this.KAu)
          {
            localObject1 = this.KzZ;
            if (localObject1 != null) {
              ((ao)localObject1).agK(0);
            }
            this.KAv = false;
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
            localObject2 = h.xfu;
            h.aUs((String)localObject1);
            continue;
            localObject1 = this.KAl;
            if (localObject1 != null) {
              ((ae)localObject1).agK(8);
            }
            localObject1 = this.tKW;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a((d.a)this);
            }
            localObject1 = this.tKW;
            if (localObject1 != null)
            {
              ((com.tencent.mm.plugin.mmsight.model.d)localObject1).enable();
              continue;
              localObject1 = f.rGw;
              if (f.fvH()) {}
              for (i = 4;; i = 5)
              {
                localObject1 = f.rGw;
                localObject1 = f.eNB();
                localObject2 = f.rGw;
                bool1 = f.fiE();
                localObject2 = f.rGw;
                bool2 = f.fiF();
                localObject2 = f.rGw;
                localObject2 = f.eNG().LwZ;
                localObject3 = f.rGw;
                bool3 = f.fhK();
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
                  break label2070;
                }
                com.tencent.mm.live.d.a.fPt();
                break;
              }
              label2070:
              com.tencent.mm.live.d.a.fPu();
              continue;
              if (!this.KAu)
              {
                localObject1 = this.KAc;
                if (localObject1 != null) {
                  ((aq)localObject1).agK(8);
                }
                localObject1 = this.KzZ;
                if (localObject1 != null) {
                  ((ao)localObject1).agK(8);
                }
                localObject1 = this.KzV;
                if (localObject1 != null) {
                  ((bb)localObject1).agK(8);
                }
                localObject1 = this.KzW;
                if (localObject1 != null) {
                  ((com.tencent.mm.live.c.t)localObject1).agK(8);
                }
                localObject1 = this.KzX;
                if (localObject1 != null) {
                  ((com.tencent.mm.live.c.k)localObject1).agK(8);
                }
                localObject1 = this.KAl;
                if (localObject1 != null)
                {
                  localObject2 = f.rGw;
                  localObject2 = f.eNI();
                  localObject3 = getContext();
                  d.g.b.k.g(localObject3, "context");
                  localObject3 = ((Context)localObject3).getResources().getString(2131766590);
                  d.g.b.k.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
                  ((ae)localObject1).ca((String)localObject2, (String)localObject3);
                }
                this.KAv = true;
              }
              localObject1 = f.rGw;
              localObject1 = f.eNB();
              localObject2 = f.rGw;
              bool1 = f.fiE();
              localObject2 = f.rGw;
              boolean bool2 = f.fiF();
              localObject2 = f.rGw;
              localObject2 = f.eNG().LwZ;
              localObject3 = f.rGw;
              boolean bool3 = f.fhK();
              localObject3 = getContext();
              d.g.b.k.g(localObject3, "context");
              localObject3 = ((Context)localObject3).getResources();
              d.g.b.k.g(localObject3, "context.resources");
              int j = ((Resources)localObject3).getConfiguration().orientation;
              if (paramBundle != null) {}
              for (i = paramBundle.getInt("live_user_exit_reason");; i = 0)
              {
                com.tencent.mm.live.d.e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, j, 6, i);
                break;
              }
              localObject1 = this.KzZ;
              if (localObject1 != null) {
                ((ao)localObject1).qDY.qUv.dRh();
              }
              localObject1 = this.KwF;
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).clu();
                if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.e)localObject1).cnx() == true))
                {
                  localObject1 = this.KwF;
                  if (localObject1 != null)
                  {
                    localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).clu();
                    if (localObject1 != null)
                    {
                      ((com.tencent.mm.live.core.core.b.e)localObject1).qzO = e.b.qAY;
                      continue;
                      this.KAx = true;
                      continue;
                      this.KAx = true;
                      localObject1 = this.KwF;
                      if (localObject1 != null)
                      {
                        localObject2 = getContext();
                        d.g.b.k.g(localObject2, "context");
                        ((com.tencent.mm.live.core.core.a.a)localObject1).eE((Context)localObject2);
                      }
                      localObject1 = f.rGw;
                      localObject1 = f.eNB();
                      localObject2 = f.rGw;
                      l = f.eNG().LwA;
                      localObject2 = f.rGw;
                      com.tencent.mm.live.d.e.a((String)localObject1, l, f.eNI(), 2, 1);
                      com.tencent.mm.live.d.a.fPr();
                      continue;
                      localObject1 = f.rGw;
                      localObject1 = f.eNB();
                      localObject2 = f.rGw;
                      l = f.eNG().LwA;
                      localObject2 = f.rGw;
                      com.tencent.mm.live.d.e.a((String)localObject1, l, f.eNI(), 2, 0);
                      com.tencent.mm.live.d.a.fPs();
                      continue;
                      localObject1 = this.KwF;
                      if (localObject1 != null)
                      {
                        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).clu();
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.core.core.b.e)localObject1).qzO = e.b.qAX;
                          continue;
                          localObject1 = this.KwF;
                          if (localObject1 != null)
                          {
                            localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).clu();
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.core.core.b.e)localObject1).qzO = e.b.qAR;
                              continue;
                              localObject1 = com.tencent.mm.live.core.core.trtc.a.a.cpE();
                              d.g.b.k.g(localObject1, "ConfigHelper.getInstance()");
                              localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).cpF();
                              d.g.b.k.g(localObject1, "ConfigHelper.getInstance().videoConfig");
                              localObject2 = f.rGw;
                              if (!f.fhJ().aov()) {
                                bool1 = true;
                              }
                              ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject1).kO(bool1);
                              localObject1 = this.KwF;
                              if (localObject1 != null) {
                                ((com.tencent.mm.live.core.core.a.a)localObject1).an(0.0F, 0.0F);
                              }
                              localObject1 = this.KzZ;
                              if (localObject1 != null)
                              {
                                localObject2 = f.rGw;
                                if (f.fhJ().aov()) {
                                  i = 2;
                                }
                                localObject2 = f.rGw;
                                localObject2 = f.fhJ().userId;
                                localObject3 = f.rGw;
                                j = f.fhJ().streamType;
                                d.g.b.k.h(localObject2, "userId");
                                ((ao)localObject1).qDY.w(i, (String)localObject2, j);
                                continue;
                                if (!this.KAu)
                                {
                                  localObject1 = this.KAc;
                                  if (localObject1 != null) {
                                    ((aq)localObject1).agK(8);
                                  }
                                  localObject1 = this.KzZ;
                                  if (localObject1 != null) {
                                    ((ao)localObject1).agK(8);
                                  }
                                  localObject1 = this.KzV;
                                  if (localObject1 != null) {
                                    ((bb)localObject1).agK(8);
                                  }
                                  localObject1 = this.KzW;
                                  if (localObject1 != null) {
                                    ((com.tencent.mm.live.c.t)localObject1).agK(8);
                                  }
                                  localObject1 = this.KzX;
                                  if (localObject1 != null) {
                                    ((com.tencent.mm.live.c.k)localObject1).agK(8);
                                  }
                                  localObject1 = this.KAl;
                                  if (localObject1 != null) {
                                    ((ae)localObject1).agK(8);
                                  }
                                  localObject1 = this.KAq;
                                  if (localObject1 != null) {
                                    ((com.tencent.mm.live.c.r)localObject1).agK(0);
                                  }
                                  this.KAv = true;
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
  
  public final boolean dia()
  {
    AppMethodBeat.i(203429);
    boolean bool2 = super.dia();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (!this.KAv)
      {
        bool1 = bool2;
        if (this.KAw)
        {
          b.b.a(this, b.c.FAW);
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(203429);
    return bool1;
  }
  
  public final void fOM()
  {
    AppMethodBeat.i(203426);
    super.fOM();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().a(3806, (com.tencent.mm.al.g)this);
    localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().a(3559, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(203426);
  }
  
  public final void fON()
  {
    AppMethodBeat.i(203427);
    super.fON();
    Object localObject = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aeS().b(3806, (com.tencent.mm.al.g)this);
    localObject = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aeS().b(3559, (com.tencent.mm.al.g)this);
    localObject = e.e.rBl;
    localObject = ax.aFD(e.e.equ());
    e.e locale = e.e.rBl;
    ((ax)localObject).putLong(e.e.eqv(), 0L);
    localObject = this.KwF;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.a.a)localObject).release();
    }
    fQB();
    AppMethodBeat.o(203427);
  }
  
  public final int getLiveRole()
  {
    return 1;
  }
  
  public final int getRelativeLayoutId()
  {
    return 2131496292;
  }
  
  public final String name()
  {
    AppMethodBeat.i(203425);
    String str = getClass().getSimpleName();
    d.g.b.k.g(str, "this.javaClass.simpleName");
    AppMethodBeat.o(203425);
    return str;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(203424);
    d.g.b.k.h(paramString, "incomingNumber");
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.KwF;
    if (paramString != null)
    {
      paramString = paramString.clu();
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.qzP);
        ad.i((String)localObject, paramString);
        paramString = this.KwF;
        if (paramString == null) {
          break label148;
        }
        paramString = paramString.clu();
        if (paramString == null) {
          break label148;
        }
        if (paramString.qzP == true) {
          switch (paramInt)
          {
          }
        }
      }
    }
    label148:
    do
    {
      do
      {
        AppMethodBeat.o(203424);
        return;
        paramString = null;
        break;
        AppMethodBeat.o(203424);
        return;
        AppMethodBeat.o(203424);
        return;
        paramString = h.xfu;
        h.agJ(2);
        paramString = this.KwF;
        if (paramString != null) {
          paramString.clf();
        }
        paramString = this.KwF;
        if (paramString != null)
        {
          paramString.clG();
          AppMethodBeat.o(203424);
          return;
        }
        AppMethodBeat.o(203424);
        return;
        paramString = h.xfu;
        h.agJ(0);
        paramString = this.KzZ;
        if (paramString != null) {
          paramString.startPreview();
        }
        paramString = this.KwF;
        if (paramString == null) {
          break label301;
        }
        paramString = paramString.clu();
        if (paramString == null) {
          break label301;
        }
        localObject = f.rGw;
      } while (paramString.h(Long.valueOf(f.eNG().LwA)) != true);
      paramString = this.KwF;
    } while (paramString == null);
    paramString.clI();
    AppMethodBeat.o(203424);
    return;
    label301:
    AppMethodBeat.o(203424);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(203430);
    ad.i(this.TAG, "errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!this.KAu)
        {
          paramString = this.KAh;
          if (paramString != null)
          {
            paramn = f.rGw;
            paramString.Kud = f.eNG().LwF;
          }
          paramString = this.KAh;
          if (paramString != null) {
            paramString.fOR();
          }
          paramString = f.rGw;
          paramString = f.rGw;
          paramInt1 = i;
          if (!f.eNG().LwF) {
            paramInt1 = ce.asT();
          }
          f.agw(paramInt1);
          paramString = f.rGw;
          if (f.eNG().nrv > 0) {
            b.b.a(this, b.c.FBn);
          }
        }
        AppMethodBeat.o(203430);
      }
    }
    else if ((paramn instanceof com.tencent.mm.live.b.a.o))
    {
      paramString = this.KAe;
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
        paramn = paramString.Kwl;
        if (paramn != null) {
          paramn.dismiss();
        }
        if (i != 0)
        {
          paramn = paramString.pTc.getContext();
          paramString = paramString.pTc.getContext();
          d.g.b.k.g(paramString, "root.context");
          com.tencent.mm.ui.base.t.cg(paramn, paramString.getResources().getString(2131766595));
          AppMethodBeat.o(203430);
          return;
        }
        paramn = paramString.pTc.getContext();
        paramString = paramString.pTc.getContext();
        d.g.b.k.g(paramString, "root.context");
        com.tencent.mm.ui.base.t.ci(paramn, paramString.getResources().getString(2131766594));
        AppMethodBeat.o(203430);
        return;
      }
    }
    AppMethodBeat.o(203430);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(203433);
    super.pause();
    if (!this.KAx)
    {
      localObject = h.xfu;
      h.agJ(1);
      localObject = this.KwF;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.a)localObject).clf();
      }
      localObject = this.KwF;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.a)localObject).clG();
      }
    }
    Object localObject = this.tKW;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
    }
    localObject = this.tKW;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).a(null);
    }
    this.tKW = null;
    AppMethodBeat.o(203433);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(203432);
    super.resume();
    Object localObject1 = this.KwF;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.a.a)localObject1).clo();
    }
    localObject1 = f.rGw;
    Object localObject2;
    if ((f.eNG().LwA != 0L) && (!this.KAu))
    {
      localObject1 = f.rGw;
      long l = f.eNG().LwA;
      localObject1 = f.rGw;
      localObject1 = new com.tencent.mm.live.b.a.b(l, f.eNB(), true);
      localObject2 = com.tencent.mm.kernel.g.aeS();
      d.g.b.k.g(localObject2, "MMKernel.getNetSceneQueue()");
      ((com.tencent.mm.live.b.a.b)localObject1).doScene(((com.tencent.mm.al.q)localObject2).aeW(), (com.tencent.mm.al.g)new g(this));
    }
    for (;;)
    {
      localObject1 = h.xfu;
      h.agJ(0);
      AppMethodBeat.o(203432);
      return;
      if (!this.KAx)
      {
        localObject1 = this.KzZ;
        if (localObject1 != null) {
          ((ao)localObject1).startPreview();
        }
        localObject1 = this.KwF;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).clu();
          if (localObject1 != null)
          {
            localObject2 = f.rGw;
            if (((com.tencent.mm.live.core.core.b.e)localObject1).h(Long.valueOf(f.eNG().LwA)) == true)
            {
              localObject1 = this.KwF;
              if (localObject1 != null) {
                ((com.tencent.mm.live.core.core.a.a)localObject1).clI();
              }
            }
          }
        }
      }
      this.KAx = false;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(203428);
    super.start();
    Object localObject = h.xfu;
    h.fOH();
    localObject = f.rGw;
    if (f.eNG().CJd == 0)
    {
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(203428);
        throw ((Throwable)localObject);
      }
      ((Activity)localObject).setRequestedOrientation(4);
    }
    AppMethodBeat.o(203428);
  }
  
  public final void wy(int paramInt)
  {
    AppMethodBeat.i(203434);
    ad.i(this.TAG, "refreshCamera");
    com.tencent.mm.live.core.core.a.a locala = this.KwF;
    if (locala != null)
    {
      locala.clg();
      AppMethodBeat.o(203434);
      return;
    }
    AppMethodBeat.o(203434);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ret", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.q<Integer, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, y>
  {
    a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "needFaceVerify", "verifyUrl", "", "errCode", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.r<Boolean, Boolean, String, Integer, y>
  {
    b(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "xOffset", "", "yOffset", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.m<Float, Float, y>
  {
    c(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "errCode", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.r<Boolean, Integer, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, y>
  {
    e(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/view/LiveAnchorPluginLayout$joinLive$1$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class a
      implements com.tencent.mm.live.core.core.b
    {
      a(LiveAnchorPluginLayout.e parame) {}
      
      public final void B(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(203414);
        ad.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish");
        if (paramInt > 0)
        {
          b.b.a(this.KAC.KAB, b.c.FAV);
          paramBundle = LiveAnchorPluginLayout.a(this.KAC.KAB);
          if (paramBundle != null)
          {
            String str = com.tencent.mm.cd.a.aq(this.KAC.KAB.getContext(), 2131766671);
            d.g.b.k.g(str, "ResourceHelper.getString…ring.live_room_mini_live)");
            paramBundle.aTU(str);
          }
          paramBundle = h.xfu;
          paramBundle = f.rGw;
          h.aUr(f.eNB());
          b.b.a(this.KAC.KAB, b.c.HRO);
          AppMethodBeat.o(203414);
          return;
        }
        ad.w("MicroMsg.LiveCoreAnchor", "enter room fail");
        com.tencent.mm.ui.base.t.makeText(this.KAC.KAB.getContext(), (CharSequence)"enter room fail", 0).show();
        b.b.a(this.KAC.KAB, b.c.FAS);
        paramBundle = new Bundle();
        paramBundle.putInt("live_user_exit_reason", paramInt);
        this.KAC.KAB.a(b.c.HRN, paramBundle);
        AppMethodBeat.o(203414);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class g
    implements com.tencent.mm.al.g
  {
    g(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(203418);
      paramn.setHasCallbackToQueue(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
          AppMethodBeat.o(203418);
          throw paramString;
        }
        paramString = ((com.tencent.mm.live.b.a.b)paramn).eNG();
        if (paramString == null) {
          break label174;
        }
        if ((paramString.nrv == 0) && (!LiveAnchorPluginLayout.p(this.KAB)))
        {
          if (!LiveAnchorPluginLayout.n(this.KAB))
          {
            paramString = LiveAnchorPluginLayout.c(this.KAB);
            if (paramString != null) {
              paramString.startPreview();
            }
            paramString = LiveAnchorPluginLayout.a(this.KAB);
            if (paramString != null)
            {
              paramString = paramString.clu();
              if (paramString != null)
              {
                paramn = f.rGw;
                if (paramString.h(Long.valueOf(f.eNG().LwA)) == true)
                {
                  paramString = LiveAnchorPluginLayout.a(this.KAB);
                  if (paramString != null) {
                    paramString.clI();
                  }
                }
              }
            }
          }
          LiveAnchorPluginLayout.o(this.KAB);
        }
      }
      AppMethodBeat.o(203418);
      return;
      label174:
      AppMethodBeat.o(203418);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/view/LiveAnchorPluginLayout$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class h
    implements com.tencent.mm.live.core.core.b
  {
    public final void B(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(203419);
      ad.i("MicroMsg.LiveCoreAnchor", "on exitRoom finish");
      if (!LiveAnchorPluginLayout.n(this.KAB))
      {
        paramBundle = h.xfu;
        h.agJ(1);
        paramBundle = LiveAnchorPluginLayout.a(this.KAB);
        if (paramBundle != null) {
          paramBundle.clf();
        }
        paramBundle = LiveAnchorPluginLayout.a(this.KAB);
        if (paramBundle != null) {
          paramBundle.clG();
        }
      }
      paramBundle = com.tencent.mm.live.core.core.a.b.qym;
      b.a.releaseInstance();
      AppMethodBeat.o(203419);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ret", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.q<Integer, com.tencent.mm.live.core.core.b.c, TRTCCloudDef.TRTCParams, y>
  {
    i(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAnchorPluginLayout
 * JD-Core Version:    0.7.0.1
 */