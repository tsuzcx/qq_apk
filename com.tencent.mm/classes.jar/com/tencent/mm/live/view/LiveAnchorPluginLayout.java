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
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.l.a;
import com.tencent.mm.live.b.r.a;
import com.tencent.mm.live.b.u.b;
import com.tencent.mm.live.b.u.c;
import com.tencent.mm.live.b.u.d;
import com.tencent.mm.live.c.ac;
import com.tencent.mm.live.c.ae;
import com.tencent.mm.live.c.ag;
import com.tencent.mm.live.c.ai;
import com.tencent.mm.live.c.ak;
import com.tencent.mm.live.c.am;
import com.tencent.mm.live.c.ao;
import com.tencent.mm.live.c.aq;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.ay;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.c.ba;
import com.tencent.mm.live.c.k;
import com.tencent.mm.live.c.x.b;
import com.tencent.mm.live.c.x.c;
import com.tencent.mm.live.core.core.b.a;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.live.core.core.e.e;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.live.core.core.model.h.b;
import com.tencent.mm.live.core.core.model.h.e;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.ArrayList;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/LiveAnchorPluginLayout;", "Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "", "curStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "fromForcelockOrientation", "", "lastRotationFromSensor", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveAnchorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "liveAnchorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorMicPlugin;", "liveBanCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "liveBeforePlugin", "Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "liveReadyPlugin", "Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "liveRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveShareRoomsPlugin", "Lcom/tencent/mm/live/plugin/LiveShareRoomsPlugin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "nextStatus", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "pluginShow", "rotationEnable", "shareLiveRetryCount", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkClickArea", "x", "", "y", "validCallback", "checkInitStatus", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "checkVerify", "createNewLive", "liveName", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleErrForeigner", "handleJoinLiveFail", "errCode", "errMsg", "initLogic", "isFinished", "isLiving", "joinLive", "lockOrientation", "mount", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onOrientationChange", "orientation", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "orientationChanged", "pause", "refreshCamera", "resume", "start", "startLive", "liveId", "", "startTimer", "statusChange", "status", "stop", "stopLive", "stopTimer", "toggleShowPlugins", "tryResumeLive", "unMount", "updatePlugin", "plugin-logic_release"})
public final class LiveAnchorPluginLayout
  extends RoomBaseLivePluginLayout
  implements com.tencent.mm.an.i, com.tencent.mm.live.core.core.c, d.a
{
  private final String TAG;
  private int curNetworkQuality;
  private com.tencent.mm.live.core.core.a.a kGJ;
  private ag kKA;
  private com.tencent.mm.live.c.e kKB;
  private com.tencent.mm.live.c.r kKC;
  private b.c kKD;
  private b.c kKE;
  private final ArrayList<com.tencent.mm.live.c.a> kKF;
  private boolean kKG;
  private boolean kKH;
  private final com.tencent.mm.model.d kKI;
  private boolean kKJ;
  private int kKK;
  private MTimerHandler kKL;
  private ba kKh;
  private com.tencent.mm.live.c.t kKi;
  private k kKj;
  private com.tencent.mm.live.c.c kKk;
  private ao kKl;
  private as kKm;
  private com.tencent.mm.live.c.m kKn;
  private aq kKo;
  private ay kKp;
  private ai kKq;
  private com.tencent.mm.live.c.x kKr;
  private com.tencent.mm.live.c.g kKs;
  private com.tencent.mm.live.c.i kKt;
  private com.tencent.mm.live.c.o kKu;
  private am kKv;
  private com.tencent.mm.live.c.au kKw;
  private ae kKx;
  private ak kKy;
  private ac kKz;
  private int lastRotationFromSensor;
  private kotlin.g.a.a<kotlin.x> liveMessageCallback;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  
  public LiveAnchorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199485);
    this.TAG = "MicroMsg.LiveAnchorPluginLayout";
    this.kKD = b.c.kyS;
    this.kKE = b.c.kyS;
    paramContext = e.m.kkI;
    this.curNetworkQuality = e.m.aKH();
    this.kKF = new ArrayList();
    this.kKG = true;
    this.kKI = com.tencent.mm.model.d.bcs();
    this.lastRotationFromSensor = -1;
    this.liveMessageCallback = ((kotlin.g.a.a)new n(this));
    this.kKL = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack)new s(this), true);
    AppMethodBeat.o(199485);
  }
  
  private final void a(float paramFloat1, float paramFloat2, kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(199424);
    Object localObject = this.kKm;
    int j;
    label35:
    int k;
    if (localObject != null)
    {
      localObject = ((as)localObject).aPF();
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
      AppMethodBeat.o(199424);
      return;
    }
  }
  
  private final void aRk()
  {
    AppMethodBeat.i(199438);
    Log.i("MicroMsg.LiveCoreAnchor", "stopLive");
    com.tencent.mm.live.core.core.a.a locala = this.kGJ;
    if (locala != null)
    {
      locala.b((com.tencent.mm.live.core.core.c)new r());
      AppMethodBeat.o(199438);
      return;
    }
    AppMethodBeat.o(199438);
  }
  
  private final void aRl()
  {
    AppMethodBeat.i(199439);
    f.a locala = new f.a(getContext()).icD();
    Context localContext = getContext();
    kotlin.g.b.p.j(localContext, "context");
    locala.aR((CharSequence)localContext.getResources().getString(b.h.live_create_tip_foreigner)).ayp(b.h.app_i_know).b((f.c)c.kKQ).b((DialogInterface.OnDismissListener)new d(this)).show();
    AppMethodBeat.o(199439);
  }
  
  private final boolean aRm()
  {
    AppMethodBeat.i(199441);
    Object localObject = com.tencent.mm.live.b.u.kwz;
    if (com.tencent.mm.live.b.u.aOD().kwI)
    {
      localObject = com.tencent.mm.live.b.c.a.kyw;
      localObject = com.tencent.mm.live.b.c.a.aPm();
      if ((((crl)localObject).rotation != -1) && (((crl)localObject).rotation != getCurrentOrientation()))
      {
        AppMethodBeat.o(199441);
        return true;
      }
      AppMethodBeat.o(199441);
      return false;
    }
    localObject = com.tencent.mm.live.b.u.kwz;
    if (com.tencent.mm.live.b.u.getLastOrientation() != -1)
    {
      localObject = com.tencent.mm.live.b.u.kwz;
      if (com.tencent.mm.live.b.u.getLastOrientation() != getCurrentOrientation())
      {
        AppMethodBeat.o(199441);
        return true;
      }
    }
    AppMethodBeat.o(199441);
    return false;
  }
  
  private final void startTimer()
  {
    AppMethodBeat.i(199436);
    this.kKL.stopTimer();
    this.kKL.startTimer(1000L);
    AppMethodBeat.o(199436);
  }
  
  public final void callback(int paramInt, Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 1;
    int i = 0;
    AppMethodBeat.i(199484);
    Object localObject4 = e.e.kjZ;
    if (paramInt == e.e.aJO())
    {
      com.tencent.mm.live.c.b.b.a(this, b.c.kzq);
      paramBundle = this.kKs;
      if (paramBundle != null)
      {
        paramBundle.aPt();
        AppMethodBeat.o(199484);
        return;
      }
      AppMethodBeat.o(199484);
      return;
    }
    localObject4 = e.e.kjZ;
    if (paramInt == e.e.aJT())
    {
      paramBundle = this.kGJ;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.aJA();
        if (paramBundle != null)
        {
          if (paramBundle.aLo() != true) {
            break label1228;
          }
          paramBundle = this.kGJ;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.aJA();
            if (paramBundle != null) {
              paramBundle.kmx = h.b.kmM;
            }
          }
          paramBundle = this.kKs;
          if (paramBundle == null) {
            break label160;
          }
          paramBundle.aPs();
          AppMethodBeat.o(199484);
          return;
        }
      }
      AppMethodBeat.o(199484);
      return;
      label160:
      AppMethodBeat.o(199484);
    }
    else
    {
      localObject4 = e.e.kjZ;
      if (paramInt == e.e.aJP())
      {
        if (paramBundle != null)
        {
          localObject2 = paramBundle.getString("live_user_id");
          paramBundle.getString("live_user_exit_reason");
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
          paramBundle = com.tencent.mm.live.b.u.kwz;
          paramBundle = com.tencent.mm.live.b.u.aPa().kyo;
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.ktN;; paramBundle = null)
          {
            Log.i((String)localObject3, paramBundle);
            paramBundle = com.tencent.mm.live.b.u.kwz;
            localObject3 = com.tencent.mm.live.b.u.aPa().kyo;
            paramBundle = (Bundle)localObject1;
            if (localObject3 != null) {
              paramBundle = ((a.a)localObject3).ktN;
            }
            if (!kotlin.g.b.p.h(localObject2, paramBundle)) {
              break;
            }
            com.tencent.mm.live.c.b.b.a(this, b.c.kzd);
            paramBundle = com.tencent.mm.live.b.u.kwz;
            paramBundle = com.tencent.mm.live.b.u.aPa().kyo;
            if (paramBundle == null) {
              break;
            }
            localObject1 = com.tencent.mm.live.b.u.kwz;
            com.tencent.mm.live.b.u.aPa().a(paramBundle.liveId, paramBundle.ktQ, paramBundle.ktE);
            AppMethodBeat.o(199484);
            return;
          }
          AppMethodBeat.o(199484);
          return;
        }
        AppMethodBeat.o(199484);
        return;
      }
      localObject1 = e.e.kjZ;
      if (paramInt == e.e.aJQ())
      {
        if (paramBundle != null)
        {
          localObject1 = paramBundle.getString("live_user_id");
          boolean bool = paramBundle.getBoolean("live_media_enable");
          paramBundle = com.tencent.mm.live.b.u.kwz;
          localObject2 = com.tencent.mm.live.b.u.aPa().kyo;
          paramBundle = (Bundle)localObject3;
          if (localObject2 != null) {
            paramBundle = ((a.a)localObject2).ktN;
          }
          if (kotlin.g.b.p.h(localObject1, paramBundle))
          {
            if (bool)
            {
              com.tencent.mm.live.c.b.b.a(this, b.c.kza);
              AppMethodBeat.o(199484);
              return;
            }
            paramBundle = this.kKs;
            if (paramBundle != null)
            {
              LiveAnchorMicUserListView.a(paramBundle.kDi);
              AppMethodBeat.o(199484);
              return;
            }
          }
          AppMethodBeat.o(199484);
          return;
        }
        AppMethodBeat.o(199484);
        return;
      }
      localObject1 = e.e.kjZ;
      if (paramInt == e.e.aJR())
      {
        i = this.curNetworkQuality;
        paramBundle = this.kGJ;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.aJA();
          if (paramBundle != null)
          {
            paramInt = paramBundle.kmJ;
            this.curNetworkQuality = paramInt;
            paramBundle = e.m.kkI;
            if (i == e.m.aKJ()) {
              break label619;
            }
            paramInt = this.curNetworkQuality;
            paramBundle = e.m.kkI;
            if (paramInt != e.m.aKJ()) {
              break label619;
            }
            com.tencent.mm.live.c.b.b.a(this, b.c.kzJ);
            if (this.kKl != null) {}
          }
        }
        for (;;)
        {
          paramInt = this.curNetworkQuality;
          paramBundle = e.m.kkI;
          if (paramInt != e.m.aKG()) {
            break label676;
          }
          com.tencent.mm.live.core.c.a.aNb();
          AppMethodBeat.o(199484);
          return;
          paramBundle = e.m.kkI;
          paramInt = e.m.aKH();
          break;
          label619:
          paramBundle = e.m.kkI;
          if (i == e.m.aKJ())
          {
            paramInt = this.curNetworkQuality;
            paramBundle = e.m.kkI;
            if (paramInt != e.m.aKJ())
            {
              com.tencent.mm.live.c.b.b.a(this, b.c.kzK);
              paramBundle = this.kKl;
              if (paramBundle != null) {
                paramBundle.resume();
              }
              paramBundle = com.tencent.mm.live.b.o.kvA;
              com.tencent.mm.live.b.o.aOb();
            }
          }
        }
        label676:
        paramBundle = e.m.kkI;
        if (paramInt == e.m.aKH())
        {
          com.tencent.mm.live.core.c.a.aNc();
          AppMethodBeat.o(199484);
          return;
        }
        paramBundle = e.m.kkI;
        if (paramInt == e.m.aKI())
        {
          com.tencent.mm.live.core.c.a.aNd();
          AppMethodBeat.o(199484);
          return;
        }
        paramBundle = e.m.kkI;
        if (paramInt == e.m.aKJ())
        {
          com.tencent.mm.live.core.c.a.aNe();
          AppMethodBeat.o(199484);
          return;
        }
        AppMethodBeat.o(199484);
        return;
      }
      localObject1 = e.e.kjZ;
      long l;
      if (paramInt == e.e.aJS())
      {
        paramBundle = this.kGJ;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.aJA();
          if ((paramBundle != null) && (paramBundle.aLp() == true)) {
            i = j;
          }
        }
        for (;;)
        {
          paramBundle = com.tencent.mm.live.b.u.kwz;
          localObject2 = com.tencent.mm.live.b.u.aOm();
          paramBundle = com.tencent.mm.live.b.u.kwz;
          l = com.tencent.mm.live.b.u.aOr().klE;
          paramBundle = com.tencent.mm.live.b.u.kwz;
          paramBundle = com.tencent.mm.live.b.u.aPa().kyo;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.ktE;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          localObject1 = com.tencent.mm.live.b.u.kwz;
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.b.u.aOt(), i, 0, paramInt);
          AppMethodBeat.o(199484);
          return;
          paramBundle = this.kGJ;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.aJA();
            if ((paramBundle != null) && (paramBundle.aLo() == true))
            {
              i = 2;
              continue;
            }
          }
          i = 0;
        }
      }
      localObject1 = e.e.kjZ;
      if (paramInt == e.e.aJU())
      {
        paramBundle = com.tencent.mm.live.b.u.kwz;
        l = com.tencent.mm.live.b.u.aOr().klE;
        paramBundle = com.tencent.mm.live.b.u.kwz;
        paramBundle = com.tencent.mm.live.b.u.aOm();
        localObject1 = com.tencent.mm.live.b.u.kwz;
        localObject1 = com.tencent.mm.live.b.u.aOr().Srb;
        kotlin.g.b.p.j(localObject1, "RoomLiveService.liveInfo.live_name");
        new com.tencent.mm.live.b.h(l, paramBundle, (String)localObject1, (byte)0).a((kotlin.g.a.r)new a(this));
        AppMethodBeat.o(199484);
        return;
      }
      localObject1 = e.e.kjZ;
      if (paramInt == e.e.aJV())
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
        Log.i((String)localObject4, (String)localObject1);
        localObject1 = localObject2;
        if (paramBundle != null) {
          localObject1 = paramBundle.getString("live_user_id");
        }
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject1 = com.tencent.mm.live.b.u.kwz;
          localObject3 = com.tencent.mm.live.b.u.aOG();
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
          ((u.c)localObject3).setUserId((String)localObject1);
          localObject1 = com.tencent.mm.live.b.u.kwz;
          localObject1 = com.tencent.mm.live.b.u.aOG();
          if (paramBundle == null) {
            break label1235;
          }
          paramInt = paramBundle.getInt("live_stream_type");
          ((u.c)localObject1).streamType = paramInt;
          localObject1 = com.tencent.mm.live.b.u.kwz;
          localObject1 = com.tencent.mm.live.b.u.aOG();
          if (paramBundle == null) {
            break label1240;
          }
        }
      }
    }
    label1228:
    label1235:
    label1240:
    for (paramInt = paramBundle.getInt("live_first_frame_width");; paramInt = 0)
    {
      ((u.c)localObject1).width = paramInt;
      localObject1 = com.tencent.mm.live.b.u.kwz;
      localObject1 = com.tencent.mm.live.b.u.aOG();
      paramInt = i;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("live_first_frame_height");
      }
      ((u.c)localObject1).height = paramInt;
      com.tencent.mm.live.c.b.b.a(this, b.c.kzT);
      AppMethodBeat.o(199484);
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
    return b.f.live_anchor_ui;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void initLogic(LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(199422);
    kotlin.g.b.p.k(paramLiveConfig, "config");
    this.kKJ = false;
    this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(getContext(), (byte)0);
    Object localObject1 = com.tencent.mm.live.core.core.a.b.klq;
    this.kGJ = ((com.tencent.mm.live.core.core.a.a)com.tencent.mm.live.core.core.a.b.b.aLh());
    localObject1 = this.kGJ;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = getContext();
      kotlin.g.b.p.j(localObject2, "context");
      ((com.tencent.mm.live.core.core.a.a)localObject1).a((AbsLiveMiniView)new RoomLiveMiniView((Context)localObject2));
    }
    localObject1 = this.kGJ;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.a.a)localObject1).c((com.tencent.mm.live.core.core.c)this);
    }
    com.tencent.mm.live.b.o.kvA.release();
    if (paramLiveConfig.getLiveId() != 0L)
    {
      localObject1 = com.tencent.mm.live.b.u.kwz;
      com.tencent.mm.live.b.u.aOr().klE = paramLiveConfig.getLiveId();
    }
    if (!Util.isNullOrNil(paramLiveConfig.aJg()))
    {
      localObject1 = com.tencent.mm.live.b.u.kwz;
      localObject1 = paramLiveConfig.aJg();
      kotlin.g.b.p.j(localObject1, "config.hostRoomId");
      com.tencent.mm.live.b.u.Ob((String)localObject1);
    }
    localObject1 = com.tencent.mm.live.b.u.kwz;
    localObject1 = paramLiveConfig.aJk();
    kotlin.g.b.p.j(localObject1, "config.anchorUsername");
    com.tencent.mm.live.b.u.Od((String)localObject1);
    localObject1 = findViewById(b.e.live_verify_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_verify_ui_root)");
    this.kKh = new ba((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_face_verify_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_face_verify_ui_root)");
    this.kKi = new com.tencent.mm.live.c.t((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_before_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_before_ui_root)");
    this.kKj = new k((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_after_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_after_ui_root)");
    this.kKk = new com.tencent.mm.live.c.c((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_preview_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_preview_ui_root)");
    this.kKl = new ao((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_shadow_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_shadow_ui_root)");
    this.kKm = new as((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_comment_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_comment_ui_root)");
    this.kKn = new com.tencent.mm.live.c.m((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_ready_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_ready_ui_root)");
    this.kKo = new aq((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_title_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_title_ui_root)");
    this.kKp = new ay((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_right_panel_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_right_panel_ui_root)");
    this.kKr = new com.tencent.mm.live.c.x((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_right_panel_btn4_parent);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_right_panel_btn4_parent)");
    this.kKs = new com.tencent.mm.live.c.g((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_members_list_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_members_list_ui_root)");
    this.kKq = new ai((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_ban_comment_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_ban_comment_ui_root)");
    this.kKt = new com.tencent.mm.live.c.i((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_common_info_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_common_info_ui_root)");
    this.kKu = new com.tencent.mm.live.c.o((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_minimize_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_minimize_ui_root)");
    this.kKv = new am((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_share_rooms_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_share_rooms_ui_root)");
    this.kKw = new com.tencent.mm.live.c.au((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_loading_view_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_loading_view_root)");
    this.kKx = new ae((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_mic_visitor_header_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_mic_visitor_header_root)");
    this.kKy = new ak((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_like_confetti_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_like_confetti_ui_root)");
    this.kKz = new ac((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_members_profile_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_members_profile_ui_root)");
    this.kKA = new ag((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_anchor_close_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_anchor_close_ui_root)");
    this.kKB = new com.tencent.mm.live.c.e((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_exception_ui_root);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.live_exception_ui_root)");
    this.kKC = new com.tencent.mm.live.c.r((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = this.kKl;
    if (localObject1 != null)
    {
      localObject2 = (kotlin.g.a.m)new j(this);
      ((ao)localObject1).knt.setPreviewMoveListener((kotlin.g.a.m)localObject2);
    }
    localObject1 = com.tencent.mm.live.b.o.kvA;
    com.tencent.mm.live.b.o.a(paramLiveConfig);
    localObject1 = this.kKr;
    if (localObject1 != null)
    {
      kotlin.g.b.p.k(paramLiveConfig, "config");
      localObject2 = ((com.tencent.mm.live.c.x)localObject1).kEQ;
      kotlin.g.b.p.j(localObject2, "shareBtn");
      ((ImageView)localObject2).setVisibility(0);
      localObject2 = ((com.tencent.mm.live.c.x)localObject1).kES;
      kotlin.g.b.p.j(localObject2, "switchCameraBtn");
      ((ImageView)localObject2).setVisibility(0);
      ((com.tencent.mm.live.c.x)localObject1).kEQ.setImageDrawable(com.tencent.mm.ui.au.e(((com.tencent.mm.live.c.a)localObject1).kiF.getResources().getDrawable(b.g.icons_filled_share), -1));
      ((com.tencent.mm.live.c.x)localObject1).kES.setImageDrawable(com.tencent.mm.ui.au.e(((com.tencent.mm.live.c.a)localObject1).kiF.getResources().getDrawable(b.g.icons_filled_camera_switch), -1));
      ((com.tencent.mm.live.c.x)localObject1).kER.setOnClickListener((View.OnClickListener)new x.b((com.tencent.mm.live.c.x)localObject1));
      ((com.tencent.mm.live.c.x)localObject1).kET.setOnClickListener((View.OnClickListener)new x.c((com.tencent.mm.live.c.x)localObject1));
      localObject2 = ((com.tencent.mm.live.c.x)localObject1).kER;
      kotlin.g.b.p.j(localObject2, "shareBtnClickArea");
      ((RelativeLayout)localObject2).setVisibility(8);
      localObject2 = ((com.tencent.mm.live.c.x)localObject1).kEU;
      kotlin.g.b.p.j(localObject2, "shareDescTv");
      ((TextView)localObject2).setVisibility(8);
      localObject1 = ((com.tencent.mm.live.c.x)localObject1).kEX;
      kotlin.g.b.p.j(localObject1, "shareBtnLayout");
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = this.kKq;
    if (localObject1 != null) {
      ((ai)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.kKk;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.c)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.kKn;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.m)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.kKz;
    if (localObject1 != null) {
      ((ac)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.kKk;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.c)localObject1).aPq();
    }
    localObject1 = this.kKA;
    if (localObject1 != null) {
      ((ag)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.kKu;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.o)localObject1).aPy();
    }
    localObject1 = this.kKB;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.e)localObject1).tU(8);
    }
    localObject1 = this.kKh;
    if (localObject1 != null) {
      ((ba)localObject1).tU(8);
    }
    localObject1 = this.kKi;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.t)localObject1).tU(8);
    }
    localObject1 = this.kKj;
    if (localObject1 != null) {
      ((k)localObject1).tU(0);
    }
    localObject1 = this.kKl;
    if (localObject1 != null) {
      ((ao)localObject1).tU(0);
    }
    localObject1 = this.kKm;
    if (localObject1 != null) {
      ((as)localObject1).tU(8);
    }
    localObject1 = this.kKk;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.c)localObject1).tU(4);
    }
    localObject1 = this.kKn;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.m)localObject1).tU(8);
    }
    localObject1 = this.kKo;
    if (localObject1 != null) {
      ((aq)localObject1).tU(8);
    }
    localObject1 = this.kKp;
    if (localObject1 != null) {
      ((ay)localObject1).tU(8);
    }
    localObject1 = this.kKq;
    if (localObject1 != null) {
      ((ai)localObject1).tU(8);
    }
    localObject1 = this.kKr;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.x)localObject1).tU(8);
    }
    localObject1 = this.kKt;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.i)localObject1).tU(8);
    }
    localObject1 = this.kKu;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.o)localObject1).tU(8);
    }
    localObject1 = this.kKv;
    if (localObject1 != null) {
      ((am)localObject1).tU(8);
    }
    localObject1 = this.kKw;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.au)localObject1).tU(8);
    }
    localObject1 = this.kKx;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.live.b.u.kwz;
      ((ae)localObject1).On(com.tencent.mm.live.b.u.aOt());
    }
    localObject1 = this.kKA;
    if (localObject1 != null) {
      ((ag)localObject1).tU(8);
    }
    localObject1 = this.kKC;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.r)localObject1).tU(8);
    }
    localObject1 = this.kKl;
    if (localObject1 != null)
    {
      localObject2 = (kotlin.g.a.m)new k(this);
      ((ao)localObject1).knt.setPreviewTouchListener((kotlin.g.a.m)localObject2);
    }
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.live.b.u.kwz;
      com.tencent.mm.live.b.u.aOr().Srb = paramLiveConfig.aJj();
      localObject1 = com.tencent.mm.live.b.u.kwz;
      com.tencent.mm.live.b.u.aOr().klE = paramLiveConfig.getLiveId();
      localObject1 = com.tencent.mm.live.b.u.kwz;
      paramLiveConfig = paramLiveConfig.aJg();
      kotlin.g.b.p.j(paramLiveConfig, "config.hostRoomId");
      com.tencent.mm.live.b.u.Ob(paramLiveConfig);
      com.tencent.mm.live.c.b.b.a(this, b.c.kzn);
      paramLiveConfig = this.orientationEventListener;
      if (paramLiveConfig != null) {
        paramLiveConfig.a(null);
      }
      paramLiveConfig = this.orientationEventListener;
      if (paramLiveConfig != null) {
        paramLiveConfig.disable();
      }
      this.orientationEventListener = null;
    }
    for (;;)
    {
      paramLiveConfig = j.kue;
      j.d(name(), this.liveMessageCallback);
      paramLiveConfig = com.tencent.mm.live.b.u.kwz;
      com.tencent.mm.live.b.u.aPa().kyi = ((kotlin.g.a.b)new l(this));
      AppMethodBeat.o(199422);
      return;
      localObject1 = com.tencent.mm.live.b.u.kwz;
      localObject1 = com.tencent.mm.live.b.u.aOr();
      if ((localObject1 == null) || (((crq)localObject1).klE != 0L))
      {
        localObject1 = com.tencent.mm.live.b.u.kwz;
        if (!Util.isNullOrNil(com.tencent.mm.live.b.u.aOm()))
        {
          localObject2 = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("init anchor plugin with live data, liveId:");
          localObject1 = com.tencent.mm.live.b.u.kwz;
          localObject1 = com.tencent.mm.live.b.u.aOr();
          if (localObject1 != null)
          {
            localObject1 = Long.valueOf(((crq)localObject1).klE);
            label1795:
            Log.i((String)localObject2, ((Long)localObject1).longValue() + ", liveName:" + paramLiveConfig.aJj() + ", roomId:" + paramLiveConfig.aJg());
            localObject1 = this.kKp;
            if (localObject1 != null)
            {
              paramLiveConfig = com.tencent.mm.live.b.u.kwz;
              paramLiveConfig = com.tencent.mm.live.b.u.aOr().Srb;
              if (paramLiveConfig == null) {
                break label1924;
              }
              paramLiveConfig = (CharSequence)paramLiveConfig;
              label1867:
              localObject2 = com.tencent.mm.live.b.u.kwz;
              ((ay)localObject1).a(paramLiveConfig, com.tencent.mm.live.b.u.aOt());
            }
          }
        }
      }
      for (this.kKE = b.c.kzS;; this.kKE = b.c.kyS)
      {
        if ((this.kKh == null) || (ba.aPI() != true)) {
          break label1965;
        }
        statusChange(this.kKE, new Bundle());
        break;
        localObject1 = null;
        break label1795;
        label1924:
        paramLiveConfig = (CharSequence)"";
        break label1867;
        Log.i(this.TAG, "init logic from directly start");
        paramLiveConfig = com.tencent.mm.live.b.u.kwz;
        com.tencent.mm.live.b.u.aOr().klE = 0L;
      }
      label1965:
      paramLiveConfig = this.kKh;
      if (paramLiveConfig != null) {
        paramLiveConfig.tU(0);
      }
      paramLiveConfig = this.kKi;
      if (paramLiveConfig != null) {
        paramLiveConfig.tU(8);
      }
      paramLiveConfig = this.kKk;
      if (paramLiveConfig != null) {
        paramLiveConfig.tU(4);
      }
      paramLiveConfig = this.kKn;
      if (paramLiveConfig != null) {
        paramLiveConfig.tU(8);
      }
      paramLiveConfig = this.kKr;
      if (paramLiveConfig != null) {
        paramLiveConfig.tU(8);
      }
      paramLiveConfig = this.kKp;
      if (paramLiveConfig != null) {
        paramLiveConfig.tU(8);
      }
      paramLiveConfig = this.kKm;
      if (paramLiveConfig != null) {
        paramLiveConfig.tU(8);
      }
      paramLiveConfig = this.kKt;
      if (paramLiveConfig != null) {
        paramLiveConfig.tU(8);
      }
      paramLiveConfig = this.kKx;
      if (paramLiveConfig != null) {
        paramLiveConfig.tU(8);
      }
      statusChange(b.c.kyO, new Bundle());
    }
  }
  
  public final boolean isLiving()
  {
    AppMethodBeat.i(199425);
    Object localObject = this.kGJ;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.a.a)localObject).aJA();
      if ((localObject != null) && (((com.tencent.mm.live.core.core.model.h)localObject).isLiving() == true))
      {
        AppMethodBeat.o(199425);
        return true;
      }
    }
    AppMethodBeat.o(199425);
    return false;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(199426);
    super.mount();
    com.tencent.mm.kernel.c localc = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().a(3806, (com.tencent.mm.an.i)this);
    localc = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().a(3559, (com.tencent.mm.an.i)this);
    localc = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().a(3557, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(199426);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(199431);
    boolean bool2 = super.onBackPress();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.b.u localu = com.tencent.mm.live.b.u.kwz;
      bool1 = bool2;
      if (!com.tencent.mm.live.b.u.aOD().kwJ)
      {
        localu = com.tencent.mm.live.b.u.kwz;
        bool1 = bool2;
        if (com.tencent.mm.live.b.u.aOD().kwI)
        {
          com.tencent.mm.live.c.b.b.a(this, b.c.kyV);
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(199431);
    return bool1;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(199423);
    kotlin.g.b.p.k(paramString, "incomingNumber");
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.kGJ;
    if (paramString != null)
    {
      paramString = paramString.aJA();
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.isFloatMode());
        Log.i((String)localObject, paramString);
        switch (paramInt)
        {
        }
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(199423);
        return;
        paramString = null;
        break;
        AppMethodBeat.o(199423);
        return;
        paramString = com.tencent.mm.live.b.o.kvA;
        com.tencent.mm.live.b.o.tH(2);
        paramString = this.kGJ;
        if (paramString != null)
        {
          paramString = paramString.aJA();
          if ((paramString != null) && (paramString.isFloatMode() == true))
          {
            paramString = com.tencent.mm.live.b.u.kwz;
            com.tencent.mm.live.b.u.aOy();
            paramString = this.kGJ;
            if (paramString != null) {
              paramString.aJx();
            }
            paramString = com.tencent.mm.live.b.u.kwz;
            com.tencent.mm.live.b.u.aPi();
            AppMethodBeat.o(199423);
            return;
          }
        }
        paramString = this.kGJ;
        if (paramString != null) {
          paramString.aJx();
        }
        paramString = this.kGJ;
        if (paramString != null)
        {
          paramString.stopPush();
          AppMethodBeat.o(199423);
          return;
        }
        AppMethodBeat.o(199423);
        return;
        paramString = com.tencent.mm.live.b.o.kvA;
        com.tencent.mm.live.b.o.tH(0);
        paramString = this.kGJ;
        if (paramString == null) {
          break label331;
        }
        paramString = paramString.aJA();
        if (paramString == null) {
          break label331;
        }
        localObject = com.tencent.mm.live.b.u.kwz;
      } while (paramString.a(Long.valueOf(com.tencent.mm.live.b.u.aOr().klE)) != true);
      paramString = this.kKl;
      if (paramString != null) {
        paramString.ave();
      }
      paramString = this.kGJ;
    } while (paramString == null);
    paramString.aJC();
    AppMethodBeat.o(199423);
    return;
    label331:
    AppMethodBeat.o(199423);
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(199462);
    if ((this.lastRotationFromSensor == -1) || (this.lastRotationFromSensor != paramInt))
    {
      Log.i(this.TAG, "onOrientationChange orientation:".concat(String.valueOf(paramInt)));
      this.lastRotationFromSensor = paramInt;
      Log.i(this.TAG, "refreshCamera");
      com.tencent.mm.live.core.core.a.a locala = this.kGJ;
      if (locala != null)
      {
        locala.aJy();
        AppMethodBeat.o(199462);
        return;
      }
    }
    AppMethodBeat.o(199462);
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean)
  {
    this.kKH = paramBoolean;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(199435);
    Log.i(this.TAG, "errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramq instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = com.tencent.mm.live.b.u.kwz;
        if (!com.tencent.mm.live.b.u.aOD().kwH)
        {
          paramString = com.tencent.mm.live.b.u.kwz;
          if (!com.tencent.mm.live.b.u.aOD().kwJ) {}
        }
        else
        {
          AppMethodBeat.o(199435);
          return;
        }
        paramString = this.kKt;
        if (paramString != null)
        {
          paramq = com.tencent.mm.live.b.u.kwz;
          paramString.kDr = com.tencent.mm.live.b.u.aOr().ROp;
        }
        paramString = this.kKt;
        if (paramString != null) {
          paramString.aPu();
        }
        paramString = com.tencent.mm.live.b.u.kwz;
        paramString = com.tencent.mm.live.b.u.kwz;
        paramInt1 = i;
        if (!com.tencent.mm.live.b.u.aOr().ROp) {
          paramInt1 = cm.bfF();
        }
        com.tencent.mm.live.b.u.tI(paramInt1);
        paramString = com.tencent.mm.live.b.u.kwz;
        if (com.tencent.mm.live.b.u.aOr().end_time > 0) {
          com.tencent.mm.live.c.b.b.a(this, b.c.kzn);
        }
        AppMethodBeat.o(199435);
      }
    }
    else
    {
      if ((paramq instanceof com.tencent.mm.live.b.a.p))
      {
        paramString = this.kKq;
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
          paramq = paramString.kGp;
          if (paramq != null) {
            paramq.dismiss();
          }
          if (i != 0)
          {
            paramq = paramString.kiF.getContext();
            paramString = paramString.kiF.getContext();
            kotlin.g.b.p.j(paramString, "root.context");
            w.cR(paramq, paramString.getResources().getString(b.h.live_member_kick_tip_kicked));
            AppMethodBeat.o(199435);
            return;
          }
          paramq = paramString.kiF.getContext();
          paramString = paramString.kiF.getContext();
          kotlin.g.b.p.j(paramString, "root.context");
          w.cS(paramq, paramString.getResources().getString(b.h.live_member_kick_tip_kick_fail));
          AppMethodBeat.o(199435);
          return;
        }
        AppMethodBeat.o(199435);
        return;
      }
      if (((paramq instanceof com.tencent.mm.live.b.a.u)) && ((paramInt1 != 0) || (paramInt2 != 0)))
      {
        paramInt1 = this.kKK;
        paramString = com.tencent.mm.live.b.l.kuj;
        if (paramInt1 < com.tencent.mm.live.b.l.aNB())
        {
          this.kKK += 1;
          Log.i(this.TAG, "will retry share live, delay:" + this.kKK * 1000L);
          postDelayed((Runnable)o.kKW, this.kKK * 1000L);
        }
      }
    }
    AppMethodBeat.o(199435);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(199461);
    super.pause();
    boolean bool = aRm();
    Log.i(this.TAG, "pause orientationChanged:" + bool + ", currentOrientation:" + getCurrentOrientation());
    Object localObject;
    if (!bool)
    {
      localObject = com.tencent.mm.live.b.u.kwz;
      if (!com.tencent.mm.live.b.u.aOD().kwJ)
      {
        localObject = com.tencent.mm.live.b.u.kwz;
        if (!com.tencent.mm.live.b.u.aOD().kwH)
        {
          localObject = com.tencent.mm.live.b.u.kwz;
          if (!com.tencent.mm.live.b.u.aOD().kwK)
          {
            localObject = com.tencent.mm.live.b.u.kwz;
            if (com.tencent.mm.live.b.u.aOD().kwI)
            {
              localObject = com.tencent.mm.live.b.u.kwz;
              if ((!com.tencent.mm.live.b.u.isManualClosed()) && (!this.kKJ) && (com.tencent.mm.compatible.e.b.ct(getContext())))
              {
                localObject = new Bundle();
                ((Bundle)localObject).putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 3);
                statusChange(b.c.kzi, (Bundle)localObject);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = this.orientationEventListener;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
      }
      localObject = this.orientationEventListener;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).a(null);
      }
      this.orientationEventListener = null;
      AppMethodBeat.o(199461);
      return;
      localObject = this.kGJ;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).aJA();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.model.h)localObject).aLl() == true) && (!this.kKJ))
        {
          localObject = this.kGJ;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.a)localObject).aJx();
          }
          localObject = this.kGJ;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.a)localObject).stopPush();
          }
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(199450);
    super.resume();
    Log.d(this.TAG, "resume curRotation:" + getCurrentOrientation());
    Object localObject1 = com.tencent.mm.live.b.u.kwz;
    com.tencent.mm.live.b.u.aOD().kwK = false;
    localObject1 = com.tencent.mm.live.b.u.kwz;
    Object localObject2;
    if (com.tencent.mm.live.b.u.aOr().klE != 0L)
    {
      localObject1 = com.tencent.mm.live.b.u.kwz;
      if (!com.tencent.mm.live.b.u.aOD().kwH)
      {
        localObject1 = com.tencent.mm.kernel.h.aGY();
        kotlin.g.b.p.j(localObject1, "MMKernel.getNetSceneQueue()");
        if (((com.tencent.mm.an.t)localObject1).aHc() != null)
        {
          localObject1 = com.tencent.mm.live.b.u.kwz;
          long l = com.tencent.mm.live.b.u.aOr().klE;
          localObject1 = com.tencent.mm.live.b.u.kwz;
          localObject1 = new com.tencent.mm.live.b.a.b(l, com.tencent.mm.live.b.u.aOm(), true);
          localObject2 = com.tencent.mm.kernel.h.aGY();
          kotlin.g.b.p.j(localObject2, "MMKernel.getNetSceneQueue()");
          ((com.tencent.mm.live.b.a.b)localObject1).doScene(((com.tencent.mm.an.t)localObject2).aHc(), (com.tencent.mm.an.i)new p(this));
        }
        localObject1 = this.kGJ;
        if (localObject1 == null) {
          break label318;
        }
        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.h)localObject1).kmv)) {
          break label318;
        }
        localObject1 = this.kGJ;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.a.a)localObject1).aJz();
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.live.b.u.kwz;
      com.tencent.mm.live.b.u.setLastOrientation(getCurrentOrientation());
      AppMethodBeat.o(199450);
      return;
      localObject1 = this.kKl;
      if (localObject1 != null) {
        ((ao)localObject1).ave();
      }
      localObject1 = this.kGJ;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.h)localObject1).aLl() != true)) {
        break;
      }
      localObject1 = this.kGJ;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.live.b.u.kwz;
      if (((com.tencent.mm.live.core.core.model.h)localObject1).a(Long.valueOf(com.tencent.mm.live.b.u.aOr().klE)) != true) {
        break;
      }
      localObject1 = this.kGJ;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.live.core.core.a.a)localObject1).aJC();
      break;
      label318:
      localObject1 = this.kGJ;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.model.h)localObject1).kmv = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(199428);
    super.start();
    Object localObject = com.tencent.mm.live.b.o.kvA;
    com.tencent.mm.live.b.o.aOb();
    localObject = com.tencent.mm.live.b.u.kwz;
    if ((com.tencent.mm.live.b.u.aOr().klE == 0L) && (this.kKH))
    {
      localObject = com.tencent.mm.live.b.u.kwz;
      if (!com.tencent.mm.live.b.u.aOD().kwH)
      {
        localObject = com.tencent.mm.live.b.u.kwz;
        if (!com.tencent.mm.live.b.u.aOD().kwK)
        {
          localObject = com.tencent.mm.live.b.u.kwz;
          if (!com.tencent.mm.live.b.u.aOD().kwJ)
          {
            localObject = getContext();
            if (localObject == null)
            {
              localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(199428);
              throw ((Throwable)localObject);
            }
            ((Activity)localObject).setRequestedOrientation(4);
          }
        }
      }
    }
    startTimer();
    AppMethodBeat.o(199428);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(199416);
    kotlin.g.b.p.k(paramc, "status");
    Log.i(this.TAG, "statusChange:" + paramc.name());
    this.kKD = paramc;
    switch (a.jLJ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(199416);
      return;
      if (this.kKH)
      {
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(199416);
          throw paramc;
        }
        ((Activity)localObject1).setRequestedOrientation(4);
      }
      Object localObject1 = this.kKE;
      Object localObject2;
      Object localObject3;
      switch (a.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        break;
      case 1: 
        localObject1 = com.tencent.mm.live.b.o.kvA;
        com.tencent.mm.live.b.o.tH(0);
        localObject1 = this.kKl;
        if (localObject1 != null) {
          ((ao)localObject1).tU(0);
        }
        localObject1 = this.kKh;
        if (localObject1 != null) {
          ((ba)localObject1).tU(8);
        }
        localObject1 = this.kKi;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.t)localObject1).tU(8);
        }
        localObject1 = this.kKj;
        if (localObject1 != null) {
          ((k)localObject1).tU(8);
        }
        localObject1 = this.kKk;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.c)localObject1).tU(8);
        }
        localObject1 = this.kKn;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.m)localObject1).tU(8);
        }
        localObject1 = this.kKr;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.x)localObject1).tU(8);
        }
        localObject1 = this.kKp;
        if (localObject1 != null) {
          ((ay)localObject1).tU(8);
        }
        localObject1 = this.kKm;
        if (localObject1 != null) {
          ((as)localObject1).tU(8);
        }
        localObject1 = this.kKt;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.i)localObject1).tU(8);
        }
        localObject2 = this.kKp;
        if (localObject2 != null)
        {
          localObject1 = com.tencent.mm.live.b.u.kwz;
          localObject1 = com.tencent.mm.live.b.u.aOr().Srb;
          if (localObject1 == null) {
            break label523;
          }
        }
        for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
        {
          localObject3 = com.tencent.mm.live.b.u.kwz;
          ((ay)localObject2).a((CharSequence)localObject1, com.tencent.mm.live.b.u.aOt());
          statusChange(b.c.kzS, new Bundle());
          break;
        }
      case 2: 
        label523:
        statusChange(b.c.kyS, new Bundle());
        continue;
        localObject1 = this.orientationEventListener;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).disable();
        }
        localObject1 = this.orientationEventListener;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a(null);
        }
        this.orientationEventListener = null;
        localObject1 = com.tencent.mm.live.b.c.a.kyw;
        localObject1 = com.tencent.mm.live.b.c.a.aPm();
        Log.i(this.TAG, "lockOrientation liveRotation:" + ((crl)localObject1).rotation + ", curRotation:" + getCurrentOrientation());
        boolean bool1;
        if ((((crl)localObject1).rotation == -1) || (((crl)localObject1).rotation == getCurrentOrientation()))
        {
          localObject1 = getContext();
          if (localObject1 == null)
          {
            paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(199416);
            throw paramc;
          }
          ((Activity)localObject1).setRequestedOrientation(14);
          localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject1, "ConfigHelper.getInstance()");
          localObject1 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).aLJ();
          kotlin.g.b.p.j(localObject1, "ConfigHelper.getInstance().videoConfig");
          localObject2 = getContext();
          kotlin.g.b.p.j(localObject2, "context");
          localObject2 = ((Context)localObject2).getResources();
          kotlin.g.b.p.j(localObject2, "context.resources");
          if (((Resources)localObject2).getConfiguration().orientation != 1) {
            break label1229;
          }
          bool1 = true;
          label773:
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject1).fd(bool1);
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("create live, isVideoVertical:");
          localObject3 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
          kotlin.g.b.p.j(localObject3, "ConfigHelper.getInstance()");
          localObject3 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject3).aLJ();
          kotlin.g.b.p.j(localObject3, "ConfigHelper.getInstance().videoConfig");
          Log.i((String)localObject1, ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject3).aLW());
          localObject1 = com.tencent.mm.live.b.u.kwz;
          localObject3 = com.tencent.mm.live.b.u.aOr();
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
          ((crq)localObject3).Srb = ((String)localObject1);
          localObject1 = com.tencent.mm.live.b.u.kwz;
          localObject1 = com.tencent.mm.live.b.u.aOr().Srb;
          kotlin.g.b.p.j(localObject1, "RoomLiveService.liveInfo.live_name");
          localObject2 = com.tencent.mm.live.b.u.kwz;
          l = com.tencent.mm.live.b.u.aOr().klE;
          localObject2 = com.tencent.mm.live.b.u.kwz;
          localObject2 = com.tencent.mm.live.b.u.aOm();
          Log.i(this.TAG, "startLive, name:" + (String)localObject1 + ", roomId:" + l);
          if ((l == 0L) || (Util.isNullOrNil((String)localObject2))) {
            break label1288;
          }
          Log.i(this.TAG, "try resume live, liveId:" + l + ", liveName:" + (String)localObject1 + ", roomId:" + (String)localObject2);
          localObject3 = com.tencent.mm.live.b.u.kwz;
          localObject3 = com.tencent.mm.live.b.u.aOv();
          if (localObject3 != null) {
            break label1235;
          }
          new com.tencent.mm.live.b.h(l, (String)localObject2, (String)localObject1, (byte)0).a((kotlin.g.a.r)new u(this));
        }
        for (;;)
        {
          localObject1 = this.kGJ;
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.live.core.core.a.a)localObject1).aJC();
          break;
          switch (((crl)localObject1).rotation)
          {
          default: 
            break;
          case 0: 
          case 2: 
            this.kKJ = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(199416);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(1);
            break;
          case 1: 
          case 3: 
            this.kKJ = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(199416);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(0);
            break;
            label1229:
            bool1 = false;
            break label773;
            label1235:
            localObject1 = this.kGJ;
            if (localObject1 != null) {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.model.g)localObject3);
            }
            localObject1 = this.kGJ;
            if (localObject1 != null)
            {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.c)new v(this));
              continue;
              label1288:
              Log.i("MicroMsg.LiveCoreAnchor", "createNewLive, liveName:" + (String)localObject1 + ", wechatRoomId:" + (String)localObject2);
              localObject3 = getContext();
              kotlin.g.b.p.j(localObject3, "context");
              localObject1 = new com.tencent.mm.live.b.i((String)localObject1, (String)localObject2, (Context)localObject3);
              localObject2 = (kotlin.g.a.s)new b(this);
              localObject3 = com.tencent.mm.kernel.h.aHF();
              kotlin.g.b.p.j(localObject3, "MMKernel.network()");
              ((com.tencent.mm.kernel.c)localObject3).aGY().a(3501, (com.tencent.mm.an.i)localObject1);
              localObject3 = new com.tencent.mm.live.b.a.l(((com.tencent.mm.live.b.i)localObject1).name, ((com.tencent.mm.live.b.i)localObject1).roomId);
              localObject4 = com.tencent.mm.kernel.h.aHF();
              kotlin.g.b.p.j(localObject4, "MMKernel.network()");
              ((com.tencent.mm.kernel.c)localObject4).aGY().b((com.tencent.mm.an.q)localObject3);
              ((com.tencent.mm.live.b.i)localObject1).ktW = ((kotlin.g.a.s)localObject2);
            }
            break;
          }
        }
        localObject1 = com.tencent.mm.live.b.u.kwz;
        localObject1 = com.tencent.mm.live.b.u.aOr().Srb;
        kotlin.g.b.p.j(localObject1, "RoomLiveService.liveInfo.live_name");
        localObject2 = com.tencent.mm.live.b.u.kwz;
        localObject2 = com.tencent.mm.live.b.u.aOm();
        localObject3 = getContext();
        kotlin.g.b.p.j(localObject3, "context");
        localObject1 = new com.tencent.mm.live.b.i((String)localObject1, (String)localObject2, (Context)localObject3);
        localObject2 = (kotlin.g.a.s)new m(this);
        localObject3 = com.tencent.mm.kernel.h.aHF();
        kotlin.g.b.p.j(localObject3, "MMKernel.network()");
        ((com.tencent.mm.kernel.c)localObject3).aGY().a(3797, (com.tencent.mm.an.i)localObject1);
        localObject3 = com.tencent.mm.live.b.u.kwz;
        long l = com.tencent.mm.live.b.u.aOr().klE;
        localObject3 = ((com.tencent.mm.live.b.i)localObject1).roomId;
        Object localObject4 = com.tencent.mm.live.b.u.kwz;
        localObject3 = new com.tencent.mm.live.b.a.o(l, (String)localObject3, com.tencent.mm.live.b.u.aOq());
        localObject4 = com.tencent.mm.kernel.h.aHF();
        kotlin.g.b.p.j(localObject4, "MMKernel.network()");
        ((com.tencent.mm.kernel.c)localObject4).aGY().b((com.tencent.mm.an.q)localObject3);
        ((com.tencent.mm.live.b.i)localObject1).ktX = ((kotlin.g.a.s)localObject2);
        continue;
        this.kKI.bct();
        localObject1 = this.kKx;
        if (localObject1 != null) {
          ((ae)localObject1).tU(8);
        }
        localObject1 = (Runnable)new q(this);
        localObject2 = ae.kFH;
        postDelayed((Runnable)localObject1, ae.aPC() + 50L);
        com.tencent.mm.live.b.o.kvA.aOd();
        localObject1 = com.tencent.mm.live.b.o.kvA;
        com.tencent.mm.live.b.o.aNY();
        localObject1 = com.tencent.mm.live.b.u.kwz;
        if (com.tencent.mm.live.b.u.aOr().ChC == 0)
        {
          localObject1 = com.tencent.mm.live.b.u.kwz;
          com.tencent.mm.live.b.u.aOr().ChC = cm.bfF();
        }
        localObject1 = com.tencent.mm.live.b.c.a.kyw;
        if (com.tencent.mm.live.b.c.a.aPm().klE != 0L) {}
        int j;
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            localObject1 = com.tencent.mm.live.b.c.a.kyw;
            localObject1 = com.tencent.mm.live.b.u.kwz;
            l = com.tencent.mm.live.b.u.aOr().klE;
            localObject1 = com.tencent.mm.live.b.u.kwz;
            localObject1 = com.tencent.mm.live.b.u.aOm();
            i = getCurrentOrientation();
            localObject2 = com.tencent.mm.live.b.u.kwz;
            localObject2 = com.tencent.mm.live.b.u.aPe();
            localObject3 = com.tencent.mm.live.b.u.kwz;
            j = com.tencent.mm.live.b.u.aOr().ChC;
            localObject3 = com.tencent.mm.live.b.u.kwz;
            com.tencent.mm.live.b.c.a.a(l, (String)localObject1, i, (String)localObject2, j, com.tencent.mm.live.b.u.aOt());
          }
          localObject1 = com.tencent.mm.live.b.u.kwz;
          com.tencent.mm.live.b.u.aPf();
          localObject1 = com.tencent.mm.live.b.o.kvA;
          com.tencent.mm.live.b.o.tH(0);
          startTimer();
          break;
        }
        localObject1 = com.tencent.mm.live.b.u.kwz;
        com.tencent.mm.live.b.u.aOy();
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(199416);
          throw paramc;
        }
        ((Activity)localObject1).finishAndRemoveTask();
        continue;
        localObject1 = this.kKs;
        if ((localObject1 != null) && (((com.tencent.mm.live.c.g)localObject1).kDj.isShowing())) {
          ((com.tencent.mm.live.c.g)localObject1).kDj.dismiss();
        }
        localObject1 = this.kKx;
        if (localObject1 != null) {
          ((ae)localObject1).tU(8);
        }
        localObject1 = this.kGJ;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.a.a)localObject1).aJB();
        }
        aRk();
        localObject1 = com.tencent.mm.live.b.u.kwz;
        com.tencent.mm.live.b.u.aPh();
        localObject1 = com.tencent.mm.live.b.o.kvA;
        com.tencent.mm.live.b.o.aOa();
        localObject1 = com.tencent.mm.live.b.o.kvA;
        com.tencent.mm.live.b.o.aOb();
        com.tencent.mm.live.b.o.kvA.release();
        localObject1 = j.kue;
        j.aNy();
        localObject1 = com.tencent.mm.live.b.c.a.kyw;
        localObject1 = com.tencent.mm.live.b.u.kwz;
        com.tencent.mm.live.b.c.a.FL(com.tencent.mm.live.b.u.aOr().klE);
        continue;
        localObject1 = com.tencent.mm.live.b.u.kwz;
        if (!com.tencent.mm.live.b.u.aOD().kwH)
        {
          localObject1 = this.kKo;
          if (localObject1 != null) {
            ((aq)localObject1).tU(8);
          }
          localObject1 = this.kKl;
          if (localObject1 != null) {
            ((ao)localObject1).tU(8);
          }
          localObject1 = this.kKh;
          if (localObject1 != null) {
            ((ba)localObject1).tU(8);
          }
          localObject1 = this.kKi;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.t)localObject1).tU(8);
          }
          localObject1 = this.kKj;
          if (localObject1 != null) {
            ((k)localObject1).tU(8);
          }
          localObject1 = this.kKx;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.live.b.u.kwz;
            localObject2 = com.tencent.mm.live.b.u.aOt();
            localObject3 = getContext();
            kotlin.g.b.p.j(localObject3, "context");
            localObject3 = ((Context)localObject3).getResources().getString(b.h.live_local_network_error_tip);
            kotlin.g.b.p.j(localObject3, "context.resources.getStr…_local_network_error_tip)");
            ((ae)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
          }
          localObject1 = com.tencent.mm.live.b.u.kwz;
          com.tencent.mm.live.b.u.aPg();
          continue;
          localObject1 = com.tencent.mm.live.b.u.kwz;
          if (!com.tencent.mm.live.b.u.aOD().kwH)
          {
            localObject1 = this.kKl;
            if (localObject1 != null) {
              ((ao)localObject1).tU(0);
            }
            localObject1 = com.tencent.mm.live.b.u.kwz;
            com.tencent.mm.live.b.u.aOD().kwJ = false;
            continue;
            if (this.kKH)
            {
              localObject1 = getContext();
              if (localObject1 == null)
              {
                paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(199416);
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
              kotlin.g.b.p.j(localObject1, "param?.getString(ILiveSt…LIVE_KICK_USERNAME) ?: \"\"");
              localObject2 = com.tencent.mm.live.b.o.kvA;
              com.tencent.mm.live.b.o.Oa((String)localObject1);
              continue;
              localObject1 = com.tencent.mm.live.b.u.kwz;
              com.tencent.mm.live.b.u.aOD().kwK = true;
              continue;
              localObject1 = this.kKx;
              if (localObject1 != null) {
                ((ae)localObject1).tU(8);
              }
              localObject1 = this.orientationEventListener;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a((d.a)this);
              }
              localObject1 = this.orientationEventListener;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).enable();
              }
              localObject1 = com.tencent.mm.live.b.u.kwz;
              if (com.tencent.mm.live.b.u.aOE().kwE)
              {
                localObject1 = this.kKi;
                if (localObject1 != null) {
                  ((com.tencent.mm.live.c.t)localObject1).tU(0);
                }
                statusChange(b.c.kyQ, new Bundle());
                localObject1 = com.tencent.mm.live.b.u.kwz;
                com.tencent.mm.live.b.u.aOE().kwE = false;
                continue;
                localObject1 = com.tencent.mm.live.b.u.kwz;
                if (com.tencent.mm.live.b.u.aOL()) {}
                for (i = 4;; i = 5)
                {
                  localObject1 = com.tencent.mm.live.b.u.kwz;
                  localObject1 = com.tencent.mm.live.b.u.aOm();
                  localObject2 = com.tencent.mm.live.b.u.kwz;
                  bool1 = com.tencent.mm.live.b.u.aOI();
                  localObject2 = com.tencent.mm.live.b.u.kwz;
                  bool2 = com.tencent.mm.live.b.u.aOJ();
                  localObject2 = com.tencent.mm.live.b.u.kwz;
                  localObject2 = com.tencent.mm.live.b.u.aOr().Srb;
                  localObject3 = com.tencent.mm.live.b.u.kwz;
                  bool3 = com.tencent.mm.live.b.u.aOH();
                  localObject3 = getContext();
                  kotlin.g.b.p.j(localObject3, "context");
                  localObject3 = ((Context)localObject3).getResources();
                  kotlin.g.b.p.j(localObject3, "context.resources");
                  com.tencent.mm.live.d.e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, ((Resources)localObject3).getConfiguration().orientation, i);
                  localObject1 = getContext();
                  kotlin.g.b.p.j(localObject1, "context");
                  localObject1 = ((Context)localObject1).getResources();
                  kotlin.g.b.p.j(localObject1, "context.resources");
                  if (((Resources)localObject1).getConfiguration().orientation != 2) {
                    break label2657;
                  }
                  com.tencent.mm.live.d.a.aQd();
                  break;
                }
                label2657:
                com.tencent.mm.live.d.a.aQe();
                continue;
                localObject1 = com.tencent.mm.live.b.u.kwz;
                if (!com.tencent.mm.live.b.u.aOD().kwH)
                {
                  localObject1 = this.kKo;
                  if (localObject1 != null) {
                    ((aq)localObject1).tU(8);
                  }
                  localObject1 = this.kKl;
                  if (localObject1 != null) {
                    ((ao)localObject1).tU(8);
                  }
                  localObject1 = this.kKh;
                  if (localObject1 != null) {
                    ((ba)localObject1).tU(8);
                  }
                  localObject1 = this.kKi;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.c.t)localObject1).tU(8);
                  }
                  localObject1 = this.kKj;
                  if (localObject1 != null) {
                    ((k)localObject1).tU(8);
                  }
                  localObject1 = this.kKx;
                  if (localObject1 != null)
                  {
                    localObject2 = com.tencent.mm.live.b.u.kwz;
                    localObject2 = com.tencent.mm.live.b.u.aOt();
                    localObject3 = getContext();
                    kotlin.g.b.p.j(localObject3, "context");
                    localObject3 = ((Context)localObject3).getResources().getString(b.h.live_local_network_error_tip);
                    kotlin.g.b.p.j(localObject3, "context.resources.getStr…_local_network_error_tip)");
                    ((ae)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
                  }
                  localObject1 = com.tencent.mm.live.b.u.kwz;
                  com.tencent.mm.live.b.u.aPg();
                }
                localObject1 = com.tencent.mm.live.b.u.kwz;
                localObject1 = com.tencent.mm.live.b.u.aOm();
                localObject2 = com.tencent.mm.live.b.u.kwz;
                bool1 = com.tencent.mm.live.b.u.aOI();
                localObject2 = com.tencent.mm.live.b.u.kwz;
                boolean bool2 = com.tencent.mm.live.b.u.aOJ();
                localObject2 = com.tencent.mm.live.b.u.kwz;
                localObject2 = com.tencent.mm.live.b.u.aOr().Srb;
                localObject3 = com.tencent.mm.live.b.u.kwz;
                boolean bool3 = com.tencent.mm.live.b.u.aOH();
                localObject3 = getContext();
                kotlin.g.b.p.j(localObject3, "context");
                localObject3 = ((Context)localObject3).getResources();
                kotlin.g.b.p.j(localObject3, "context.resources");
                j = ((Resources)localObject3).getConfiguration().orientation;
                if (paramBundle != null) {}
                for (i = paramBundle.getInt("live_user_exit_reason");; i = 0)
                {
                  com.tencent.mm.live.d.e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, j, 6, i);
                  break;
                }
                localObject1 = this.kKl;
                if (localObject1 != null) {
                  ((ao)localObject1).knt.ksW.aNr();
                }
                localObject1 = this.kGJ;
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
                  if ((localObject1 != null) && (((com.tencent.mm.live.core.core.model.h)localObject1).aLp() == true))
                  {
                    localObject1 = this.kGJ;
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
                      if (localObject1 != null)
                      {
                        ((com.tencent.mm.live.core.core.model.h)localObject1).kmx = h.b.kmN;
                        continue;
                        localObject1 = this.kGJ;
                        if (localObject1 != null)
                        {
                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.live.core.core.model.h)localObject1).kmA = h.e.kmW;
                            continue;
                            localObject1 = this.kGJ;
                            if (localObject1 != null)
                            {
                              localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
                              if (localObject1 != null)
                              {
                                ((com.tencent.mm.live.core.core.model.h)localObject1).kmA = h.e.kmY;
                                continue;
                                localObject1 = this.kGJ;
                                if (localObject1 != null)
                                {
                                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
                                  if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.model.h)localObject1).isFloatMode()))
                                  {
                                    if (paramBundle != null) {}
                                    for (i = paramBundle.getInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0);; i = 0)
                                    {
                                      localObject1 = this.kGJ;
                                      if (localObject1 != null)
                                      {
                                        localObject2 = getContext();
                                        kotlin.g.b.p.j(localObject2, "context");
                                        b.a.a((com.tencent.mm.live.core.core.b)localObject1, (Context)localObject2, false, false, i, 0, null, 54);
                                      }
                                      localObject1 = com.tencent.mm.live.b.u.kwz;
                                      localObject1 = com.tencent.mm.live.b.u.aOm();
                                      localObject2 = com.tencent.mm.live.b.u.kwz;
                                      l = com.tencent.mm.live.b.u.aOr().klE;
                                      localObject2 = com.tencent.mm.live.b.u.kwz;
                                      localObject2 = com.tencent.mm.live.b.u.aOt();
                                      localObject3 = com.tencent.mm.live.b.u.kwz;
                                      com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 1, com.tencent.mm.live.b.u.aOr().SOs);
                                      com.tencent.mm.live.d.a.aQb();
                                      break;
                                    }
                                    localObject1 = com.tencent.mm.live.b.u.kwz;
                                    localObject1 = com.tencent.mm.live.b.u.aOm();
                                    localObject2 = com.tencent.mm.live.b.u.kwz;
                                    l = com.tencent.mm.live.b.u.aOr().klE;
                                    localObject2 = com.tencent.mm.live.b.u.kwz;
                                    localObject2 = com.tencent.mm.live.b.u.aOt();
                                    localObject3 = com.tencent.mm.live.b.u.kwz;
                                    com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 0, com.tencent.mm.live.b.u.aOr().SOs);
                                    com.tencent.mm.live.d.a.aQc();
                                    continue;
                                    localObject1 = this.kGJ;
                                    if (localObject1 != null)
                                    {
                                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
                                      if (localObject1 != null)
                                      {
                                        ((com.tencent.mm.live.core.core.model.h)localObject1).kmx = h.b.kmM;
                                        continue;
                                        localObject1 = this.kGJ;
                                        if (localObject1 != null)
                                        {
                                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aJA();
                                          if (localObject1 != null) {
                                            ((com.tencent.mm.live.core.core.model.h)localObject1).kmx = h.b.kmL;
                                          }
                                        }
                                        localObject1 = this.kKy;
                                        if (localObject1 != null)
                                        {
                                          this.kKF.remove(localObject1);
                                          continue;
                                          localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
                                          kotlin.g.b.p.j(localObject1, "ConfigHelper.getInstance()");
                                          localObject1 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).aLJ();
                                          kotlin.g.b.p.j(localObject1, "ConfigHelper.getInstance().videoConfig");
                                          localObject2 = com.tencent.mm.live.b.u.kwz;
                                          if (!com.tencent.mm.live.b.u.aOG().isLandscape())
                                          {
                                            bool1 = true;
                                            label3485:
                                            ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject1).fe(bool1);
                                            localObject1 = this.kGJ;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.core.core.a.a)localObject1).C(0.0F, 0.0F);
                                            }
                                            localObject1 = this.kKl;
                                            if (localObject1 == null) {
                                              continue;
                                            }
                                            localObject2 = com.tencent.mm.live.b.u.kwz;
                                            if (!com.tencent.mm.live.b.u.aOG().isLandscape()) {
                                              break label3595;
                                            }
                                          }
                                          label3595:
                                          for (i = 2;; i = 1)
                                          {
                                            localObject2 = com.tencent.mm.live.b.u.kwz;
                                            localObject2 = com.tencent.mm.live.b.u.aOG().userId;
                                            localObject3 = com.tencent.mm.live.b.u.kwz;
                                            j = com.tencent.mm.live.b.u.aOG().streamType;
                                            kotlin.g.b.p.k(localObject2, "userId");
                                            ((ao)localObject1).knt.c(i, (String)localObject2, j);
                                            break;
                                            bool1 = false;
                                            break label3485;
                                          }
                                          localObject1 = com.tencent.mm.live.b.u.kwz;
                                          if (!com.tencent.mm.live.b.u.aOD().kwH)
                                          {
                                            localObject1 = this.kKo;
                                            if (localObject1 != null) {
                                              ((aq)localObject1).tU(8);
                                            }
                                            localObject1 = this.kKl;
                                            if (localObject1 != null) {
                                              ((ao)localObject1).tU(8);
                                            }
                                            localObject1 = this.kKh;
                                            if (localObject1 != null) {
                                              ((ba)localObject1).tU(8);
                                            }
                                            localObject1 = this.kKi;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.t)localObject1).tU(8);
                                            }
                                            localObject1 = this.kKj;
                                            if (localObject1 != null) {
                                              ((k)localObject1).tU(8);
                                            }
                                            localObject1 = this.kKx;
                                            if (localObject1 != null) {
                                              ((ae)localObject1).tU(8);
                                            }
                                            localObject1 = this.kKC;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.r)localObject1).tU(0);
                                            }
                                            localObject1 = com.tencent.mm.live.b.u.kwz;
                                            com.tencent.mm.live.b.u.aPg();
                                            localObject1 = getContext();
                                            if (localObject1 == null)
                                            {
                                              paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                                              AppMethodBeat.o(199416);
                                              throw paramc;
                                            }
                                            ((Activity)localObject1).setRequestedOrientation(1);
                                            continue;
                                            localObject1 = this.kKp;
                                            if (localObject1 != null)
                                            {
                                              localObject2 = com.tencent.mm.live.b.u.kwz;
                                              localObject2 = com.tencent.mm.live.b.u.aOr().Srb;
                                              kotlin.g.b.p.j(localObject2, "RoomLiveService.liveInfo.live_name");
                                              localObject2 = (CharSequence)localObject2;
                                              localObject3 = com.tencent.mm.live.b.u.kwz;
                                              ((ay)localObject1).a((CharSequence)localObject2, com.tencent.mm.live.b.u.aOt());
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
        break;
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(199429);
    super.stop();
    this.kKL.stopTimer();
    AppMethodBeat.o(199429);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(199427);
    super.unMount();
    Object localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().b(3806, (com.tencent.mm.an.i)this);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().b(3559, (com.tencent.mm.an.i)this);
    localObject = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().b(3557, (com.tencent.mm.an.i)this);
    if ((!aRm()) && (!this.kKJ))
    {
      localObject = this.kGJ;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).aJA();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.model.h)localObject).aLp() == true)) {}
      }
      else
      {
        localObject = this.kGJ;
        if (localObject == null) {
          break label191;
        }
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).aJA();
        if ((localObject == null) || (((com.tencent.mm.live.core.core.model.h)localObject).aLo() != true)) {
          break label191;
        }
      }
      localObject = this.kKs;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.c.g)localObject).kDi.getSelectUser();
        if (localObject != null)
        {
          com.tencent.mm.live.b.o localo = com.tencent.mm.live.b.o.kvA;
          com.tencent.mm.live.b.o.az(((a.a)localObject).ktE, ((a.a)localObject).ktN);
        }
      }
      label191:
      localObject = com.tencent.mm.live.b.o.kvA;
      com.tencent.mm.live.b.o.tH(1);
      aRk();
      com.tencent.mm.live.b.o.kvA.release();
      localObject = j.kue;
      j.aNy();
      localObject = this.kGJ;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.a)localObject).aJB();
      }
      localObject = com.tencent.mm.live.core.core.a.b.klq;
      com.tencent.mm.live.core.core.a.b.b.eV(false);
      localObject = com.tencent.mm.live.b.u.kwz;
      com.tencent.mm.live.b.u.ate();
      this.kKI.avz();
    }
    this.kKL.stopTimer();
    AppMethodBeat.o(199427);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, String, f, TRTCCloudDef.TRTCParams, kotlin.x>
  {
    a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "needFaceVerify", "verifyUrl", "", "errCode", "", "errMsg", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.s<Boolean, Boolean, String, Integer, String, kotlin.x>
  {
    b(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/LiveAnchorPluginLayout$createNewLive$1$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
    public static final class a
      extends com.tencent.mm.plugin.messenger.a.a
    {
      a()
      {
        super(null);
      }
      
      public final void onClickImp(View paramView)
      {
        AppMethodBeat.i(194761);
        kotlin.g.b.p.k(paramView, "widget");
        paramView = new Intent();
        l.a locala = com.tencent.mm.live.b.l.kuj;
        paramView.putExtra("rawUrl", com.tencent.mm.live.b.l.aNA());
        paramView.putExtra("showShare", false);
        com.tencent.mm.by.c.f(this.kKO.kKM.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
        AppMethodBeat.o(194761);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class c
    implements f.c
  {
    public static final c kKQ;
    
    static
    {
      AppMethodBeat.i(190833);
      kKQ = new c();
      AppMethodBeat.o(190833);
    }
    
    public final void g(boolean paramBoolean, String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(196067);
      com.tencent.mm.live.c.b.b.a(this.kKM, b.c.kyW);
      AppMethodBeat.o(196067);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class f
    implements DialogInterface.OnDismissListener
  {
    f(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(188935);
      paramDialogInterface = com.tencent.mm.live.b.u.kwz;
      com.tencent.mm.live.b.u.aPg();
      com.tencent.mm.live.c.b.b.a(this.kKM, b.c.kyW);
      AppMethodBeat.o(188935);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class h
    implements DialogInterface.OnDismissListener
  {
    h(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(191216);
      paramDialogInterface = com.tencent.mm.live.b.u.kwz;
      com.tencent.mm.live.b.u.aPg();
      com.tencent.mm.live.c.b.b.a(this.kKM, b.c.kyW);
      AppMethodBeat.o(191216);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/LiveAnchorPluginLayout$handleJoinLiveFail$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
  public static final class i
    extends com.tencent.mm.plugin.messenger.a.a
  {
    i()
    {
      super(null);
    }
    
    public final void onClickImp(View paramView)
    {
      AppMethodBeat.i(190626);
      kotlin.g.b.p.k(paramView, "widget");
      paramView = new Intent();
      l.a locala = com.tencent.mm.live.b.l.kuj;
      paramView.putExtra("rawUrl", com.tencent.mm.live.b.l.aNA());
      paramView.putExtra("showShare", false);
      com.tencent.mm.by.c.f(this.kKM.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(190626);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "xOffset", "", "yOffset", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Float, Float, kotlin.x>
  {
    j(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Float, Float, kotlin.x>
  {
    k(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "liveID", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Long, kotlin.x>
  {
    l(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.s<Boolean, Integer, String, f, TRTCCloudDef.TRTCParams, kotlin.x>
  {
    m(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/LiveAnchorPluginLayout$joinLive$1$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class a
      implements com.tencent.mm.live.core.core.c
    {
      a(LiveAnchorPluginLayout.m paramm) {}
      
      public final void callback(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(189260);
        Log.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish");
        if (paramInt >= 0)
        {
          com.tencent.mm.live.c.b.b.a(this.kKU.kKM, b.c.kyU);
          paramBundle = com.tencent.mm.live.b.o.kvA;
          paramBundle = com.tencent.mm.live.b.u.kwz;
          com.tencent.mm.live.b.o.NZ(com.tencent.mm.live.b.u.aOm());
          com.tencent.mm.live.c.b.b.a(this.kKU.kKM, b.c.kzN);
          AppMethodBeat.o(189260);
          return;
        }
        Log.w("MicroMsg.LiveCoreAnchor", "enter room fail");
        w.makeText(this.kKU.kKM.getContext(), (CharSequence)"enter room fail", 0).show();
        com.tencent.mm.live.c.b.b.a(this.kKU.kKM, b.c.kyS);
        paramBundle = new Bundle();
        paramBundle.putInt("live_user_exit_reason", paramInt);
        this.kKU.kKM.statusChange(b.c.kzM, paramBundle);
        AppMethodBeat.o(189260);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    n(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    public static final o kKW;
    
    static
    {
      AppMethodBeat.i(189781);
      kKW = new o();
      AppMethodBeat.o(189781);
    }
    
    public final void run()
    {
      AppMethodBeat.i(189778);
      Object localObject = com.tencent.mm.live.b.o.kvA;
      localObject = com.tencent.mm.live.b.u.kwz;
      com.tencent.mm.live.b.o.NZ(com.tencent.mm.live.b.u.aOm());
      AppMethodBeat.o(189778);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class p
    implements com.tencent.mm.an.i
  {
    p(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(199091);
      paramq.setHasCallbackToQueue(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
          AppMethodBeat.o(199091);
          throw paramString;
        }
        paramString = ((com.tencent.mm.live.b.a.b)paramq).aOr();
        if (paramString != null)
        {
          if (paramString.end_time != 0) {
            break label209;
          }
          paramString = com.tencent.mm.live.b.u.kwz;
          if (com.tencent.mm.live.b.u.aOD().kwH) {
            break label209;
          }
          paramString = LiveAnchorPluginLayout.f(this.kKM);
          if (paramString != null) {
            paramString.ave();
          }
          paramString = LiveAnchorPluginLayout.b(this.kKM);
          if (paramString != null)
          {
            paramString = paramString.aJA();
            if (paramString != null)
            {
              if (paramString.aLl() != true) {
                break label209;
              }
              paramString = LiveAnchorPluginLayout.b(this.kKM);
              if (paramString == null) {
                break label203;
              }
              paramString = paramString.aJA();
              if (paramString == null) {
                break label203;
              }
              paramq = com.tencent.mm.live.b.u.kwz;
              if (paramString.a(Long.valueOf(com.tencent.mm.live.b.u.aOr().klE)) != true) {
                break label209;
              }
              paramString = LiveAnchorPluginLayout.b(this.kKM);
              if (paramString == null) {
                break label209;
              }
              paramString.aJC();
              AppMethodBeat.o(199091);
            }
          }
        }
        else
        {
          AppMethodBeat.o(199091);
          return;
        }
        AppMethodBeat.o(199091);
        return;
        label203:
        AppMethodBeat.o(199091);
        return;
      }
      label209:
      AppMethodBeat.o(199091);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(194224);
      ae localae = LiveAnchorPluginLayout.a(this.kKM);
      if (localae != null)
      {
        localae.kiF.setVisibility(8);
        AppMethodBeat.o(194224);
        return;
      }
      AppMethodBeat.o(194224);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/LiveAnchorPluginLayout$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class r
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(191086);
      Log.i("MicroMsg.LiveCoreAnchor", "on exitRoom finish");
      AppMethodBeat.o(191086);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class s
    implements MTimerHandler.CallBack
  {
    s(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(195206);
      com.tencent.mm.live.c.o localo = LiveAnchorPluginLayout.p(this.kKM);
      Object localObject;
      if ((localo != null) && (localo.kiF.getVisibility() == 0))
      {
        localo = LiveAnchorPluginLayout.p(this.kKM);
        if (localo != null)
        {
          localObject = com.tencent.mm.live.b.u.kwz;
          i = com.tencent.mm.live.b.u.aOr().ChC;
          if (com.tencent.mm.kernel.h.aHE().aGM())
          {
            int j = cm.bfF();
            localObject = com.tencent.mm.live.b.r.kvH;
            localo.kEm = r.a.a(j - i, ":", false, false, false, 28);
          }
        }
        localo = LiveAnchorPluginLayout.p(this.kKM);
        if (localo != null)
        {
          if (!localo.fFE) {
            break label172;
          }
          localObject = com.tencent.mm.live.core.core.a.b.klq;
        }
      }
      for (int i = com.tencent.mm.live.core.core.a.b.b.aLh().knA.kmJ;; i = c.a.aMm().knA.kmJ)
      {
        localo.kEl = i;
        localo = LiveAnchorPluginLayout.p(this.kKM);
        if (localo != null)
        {
          localObject = com.tencent.mm.live.b.u.kwz;
          i = com.tencent.mm.live.b.u.aOr().SOs;
          localObject = com.tencent.mm.live.b.u.kwz;
          localo.dx(i, com.tencent.mm.live.b.u.aOr().TgX);
        }
        AppMethodBeat.o(195206);
        return true;
        label172:
        localObject = com.tencent.mm.live.core.core.c.c.kqq;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    t(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, String, f, TRTCCloudDef.TRTCParams, kotlin.x>
  {
    u(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/LiveAnchorPluginLayout$tryResumeLive$2", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class v
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(189074);
      Log.i("MicroMsg.LiveCoreAnchor", "try resume live on enterRoom finish");
      if (paramInt >= 0)
      {
        com.tencent.mm.live.c.b.b.a(this.kKM, b.c.kyU);
        AppMethodBeat.o(189074);
        return;
      }
      Log.w("MicroMsg.LiveCoreAnchor", "try resume live senter room fail");
      w.makeText(this.kKM.getContext(), (CharSequence)"enter room fail", 0).show();
      com.tencent.mm.live.c.b.b.a(this.kKM, b.c.kyS);
      AppMethodBeat.o(189074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAnchorPluginLayout
 * JD-Core Version:    0.7.0.1
 */