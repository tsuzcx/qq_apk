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
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.u.a;
import com.tencent.mm.live.b.x.d;
import com.tencent.mm.live.c.ac;
import com.tencent.mm.live.c.ae;
import com.tencent.mm.live.c.ag;
import com.tencent.mm.live.c.ai;
import com.tencent.mm.live.c.ak;
import com.tencent.mm.live.c.am;
import com.tencent.mm.live.c.ao;
import com.tencent.mm.live.c.aq;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.au;
import com.tencent.mm.live.c.ay;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.c.ba;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.b.g.b;
import com.tencent.mm.live.core.core.b.g.d;
import com.tencent.mm.live.core.core.e.d;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.ArrayList;
import kotlin.g.a.s;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/LiveAnchorPluginLayout;", "Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "", "curStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "fromForcelockOrientation", "", "lastRotationFromSensor", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveAnchorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "liveAnchorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorMicPlugin;", "liveBanCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "liveBeforePlugin", "Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "liveReadyPlugin", "Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "liveRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveShareRoomsPlugin", "Lcom/tencent/mm/live/plugin/LiveShareRoomsPlugin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "nextStatus", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "pluginShow", "rotationEnable", "shareLiveRetryCount", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkClickArea", "x", "", "y", "validCallback", "checkInitStatus", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "checkVerify", "createNewLive", "liveName", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleErrForeigner", "handleJoinLiveFail", "errCode", "errMsg", "initLogic", "isFinished", "joinLive", "lockOrientation", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onOrientationChange", "orientation", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "orientationChanged", "pause", "refreshCamera", "resume", "start", "startLive", "liveId", "", "startTimer", "statusChange", "status", "stop", "stopLive", "stopTimer", "toggleShowPlugins", "tryResumeLive", "unMount", "updatePlugin", "plugin-logic_release"})
public final class LiveAnchorPluginLayout
  extends RoomBaseLivePluginLayout
  implements com.tencent.mm.ak.i, com.tencent.mm.live.core.core.c, d.a
{
  private final String TAG;
  private int curNetworkQuality;
  private com.tencent.mm.live.core.core.a.a hSm;
  private ba hVG;
  private com.tencent.mm.live.c.t hVH;
  private com.tencent.mm.live.c.k hVI;
  private com.tencent.mm.live.c.c hVJ;
  private ao hVK;
  private as hVL;
  private com.tencent.mm.live.c.m hVM;
  private aq hVN;
  private ay hVO;
  private ai hVP;
  private com.tencent.mm.live.c.x hVQ;
  private com.tencent.mm.live.c.g hVR;
  private com.tencent.mm.live.c.i hVS;
  private com.tencent.mm.live.c.o hVT;
  private am hVU;
  private au hVV;
  private ae hVW;
  private ak hVX;
  private ac hVY;
  private ag hVZ;
  private com.tencent.mm.live.c.e hWa;
  private com.tencent.mm.live.c.r hWb;
  private b.c hWc;
  private b.c hWd;
  private final ArrayList<com.tencent.mm.live.c.a> hWe;
  private boolean hWf;
  private boolean hWg;
  private final com.tencent.mm.model.d hWh;
  private boolean hWi;
  private int hWj;
  private int lastRotationFromSensor;
  private kotlin.g.a.a<kotlin.x> liveMessageCallback;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private MTimerHandler timerThread;
  
  public LiveAnchorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(208544);
    this.TAG = "MicroMsg.LiveAnchorPluginLayout";
    this.hWc = b.c.hLy;
    this.hWd = b.c.hLy;
    paramContext = e.h.hya;
    this.curNetworkQuality = e.h.aCT();
    this.hWe = new ArrayList();
    this.hWf = true;
    this.hWh = com.tencent.mm.model.d.aTu();
    this.lastRotationFromSensor = -1;
    this.liveMessageCallback = ((kotlin.g.a.a)new n(this));
    this.timerThread = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack)new s(this), true);
    AppMethodBeat.o(208544);
  }
  
  private final void a(float paramFloat1, float paramFloat2, kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(208528);
    Object localObject = this.hVL;
    int j;
    label35:
    int k;
    if (localObject != null)
    {
      localObject = ((as)localObject).aHH();
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
      AppMethodBeat.o(208528);
      return;
    }
  }
  
  private final void aJm()
  {
    AppMethodBeat.i(208537);
    Log.i("MicroMsg.LiveCoreAnchor", "stopLive");
    com.tencent.mm.live.core.core.a.a locala = this.hSm;
    if (locala != null)
    {
      locala.b((com.tencent.mm.live.core.core.c)new r());
      AppMethodBeat.o(208537);
      return;
    }
    AppMethodBeat.o(208537);
  }
  
  private final void aJn()
  {
    AppMethodBeat.i(208538);
    f.a locala = new f.a(getContext()).hbu();
    Context localContext = getContext();
    kotlin.g.b.p.g(localContext, "context");
    locala.aC((CharSequence)localContext.getResources().getString(2131762272)).apa(2131755873).b((f.c)c.hWo).b((DialogInterface.OnDismissListener)new d(this)).show();
    AppMethodBeat.o(208538);
  }
  
  private final boolean aJo()
  {
    AppMethodBeat.i(208539);
    Object localObject = com.tencent.mm.live.b.x.hJf;
    if (com.tencent.mm.live.b.x.aGD().hJo)
    {
      localObject = com.tencent.mm.live.b.c.a.hLc;
      localObject = com.tencent.mm.live.b.c.a.aHm();
      if ((((cip)localObject).rotation != -1) && (((cip)localObject).rotation != getCurrentOrientation()))
      {
        AppMethodBeat.o(208539);
        return true;
      }
      AppMethodBeat.o(208539);
      return false;
    }
    localObject = com.tencent.mm.live.b.x.hJf;
    if (com.tencent.mm.live.b.x.getLastOrientation() != -1)
    {
      localObject = com.tencent.mm.live.b.x.hJf;
      if (com.tencent.mm.live.b.x.getLastOrientation() != getCurrentOrientation())
      {
        AppMethodBeat.o(208539);
        return true;
      }
    }
    AppMethodBeat.o(208539);
    return false;
  }
  
  private final void startTimer()
  {
    AppMethodBeat.i(208536);
    this.timerThread.stopTimer();
    this.timerThread.startTimer(1000L);
    AppMethodBeat.o(208536);
  }
  
  public final void callback(int paramInt, Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 1;
    int i = 0;
    AppMethodBeat.i(208543);
    Object localObject4 = e.d.hxF;
    if (paramInt == e.d.aCo())
    {
      b.b.a(this, b.c.hLY);
      paramBundle = this.hVR;
      if (paramBundle != null)
      {
        paramBundle.aHt();
        AppMethodBeat.o(208543);
        return;
      }
      AppMethodBeat.o(208543);
      return;
    }
    localObject4 = e.d.hxF;
    if (paramInt == e.d.aCt())
    {
      paramBundle = this.hSm;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.aBV();
        if (paramBundle != null)
        {
          if (paramBundle.aDt() != true) {
            break label1234;
          }
          paramBundle = this.hSm;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.aBV();
            if (paramBundle != null) {
              paramBundle.hzB = g.b.hzO;
            }
          }
          paramBundle = this.hVR;
          if (paramBundle == null) {
            break label160;
          }
          paramBundle.aHs();
          AppMethodBeat.o(208543);
          return;
        }
      }
      AppMethodBeat.o(208543);
      return;
      label160:
      AppMethodBeat.o(208543);
    }
    else
    {
      localObject4 = e.d.hxF;
      if (paramInt == e.d.aCp())
      {
        if (paramBundle != null)
        {
          localObject2 = paramBundle.getString("live_user_id");
          paramBundle.getString("live_user_exit_reason");
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
          paramBundle = com.tencent.mm.live.b.x.hJf;
          paramBundle = com.tencent.mm.live.b.x.aHa().hKU;
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.hFG;; paramBundle = null)
          {
            Log.i((String)localObject3, paramBundle);
            paramBundle = com.tencent.mm.live.b.x.hJf;
            localObject3 = com.tencent.mm.live.b.x.aHa().hKU;
            paramBundle = (Bundle)localObject1;
            if (localObject3 != null) {
              paramBundle = ((a.a)localObject3).hFG;
            }
            if (!kotlin.g.b.p.j(localObject2, paramBundle)) {
              break;
            }
            b.b.a(this, b.c.hLL);
            paramBundle = com.tencent.mm.live.b.x.hJf;
            paramBundle = com.tencent.mm.live.b.x.aHa().hKU;
            if (paramBundle == null) {
              break;
            }
            localObject1 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.aHa().a(paramBundle.liveId, paramBundle.hFJ, paramBundle.hFz);
            AppMethodBeat.o(208543);
            return;
          }
          AppMethodBeat.o(208543);
          return;
        }
        AppMethodBeat.o(208543);
        return;
      }
      localObject1 = e.d.hxF;
      if (paramInt == e.d.aCq())
      {
        if (paramBundle != null)
        {
          localObject1 = paramBundle.getString("live_user_id");
          boolean bool = paramBundle.getBoolean("live_media_enable");
          paramBundle = com.tencent.mm.live.b.x.hJf;
          localObject2 = com.tencent.mm.live.b.x.aHa().hKU;
          paramBundle = (Bundle)localObject3;
          if (localObject2 != null) {
            paramBundle = ((a.a)localObject2).hFG;
          }
          if (kotlin.g.b.p.j(localObject1, paramBundle))
          {
            if (bool)
            {
              b.b.a(this, b.c.hLI);
              AppMethodBeat.o(208543);
              return;
            }
            paramBundle = this.hVR;
            if (paramBundle != null)
            {
              LiveAnchorMicUserListView.a(paramBundle.hOM);
              AppMethodBeat.o(208543);
              return;
            }
          }
          AppMethodBeat.o(208543);
          return;
        }
        AppMethodBeat.o(208543);
        return;
      }
      localObject1 = e.d.hxF;
      if (paramInt == e.d.aCr())
      {
        i = this.curNetworkQuality;
        paramBundle = this.hSm;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.aBV();
          if (paramBundle != null)
          {
            paramInt = paramBundle.hzL;
            this.curNetworkQuality = paramInt;
            paramBundle = e.h.hya;
            if (i == e.h.aCV()) {
              break label625;
            }
            paramInt = this.curNetworkQuality;
            paramBundle = e.h.hya;
            if (paramInt != e.h.aCV()) {
              break label625;
            }
            b.b.a(this, b.c.hMo);
            paramBundle = this.hVK;
            if (paramBundle != null) {
              paramBundle.pause();
            }
          }
        }
        for (;;)
        {
          paramInt = this.curNetworkQuality;
          paramBundle = e.h.hya;
          if (paramInt != e.h.aCS()) {
            break label682;
          }
          com.tencent.mm.live.core.c.a.aEK();
          AppMethodBeat.o(208543);
          return;
          paramBundle = e.h.hya;
          paramInt = e.h.aCT();
          break;
          label625:
          paramBundle = e.h.hya;
          if (i == e.h.aCV())
          {
            paramInt = this.curNetworkQuality;
            paramBundle = e.h.hya;
            if (paramInt != e.h.aCV())
            {
              b.b.a(this, b.c.hMp);
              paramBundle = this.hVK;
              if (paramBundle != null) {
                paramBundle.resume();
              }
              paramBundle = com.tencent.mm.live.b.r.hIg;
              com.tencent.mm.live.b.r.aGb();
            }
          }
        }
        label682:
        paramBundle = e.h.hya;
        if (paramInt == e.h.aCT())
        {
          com.tencent.mm.live.core.c.a.aEL();
          AppMethodBeat.o(208543);
          return;
        }
        paramBundle = e.h.hya;
        if (paramInt == e.h.aCU())
        {
          com.tencent.mm.live.core.c.a.aEM();
          AppMethodBeat.o(208543);
          return;
        }
        paramBundle = e.h.hya;
        if (paramInt == e.h.aCV())
        {
          com.tencent.mm.live.core.c.a.aEN();
          AppMethodBeat.o(208543);
          return;
        }
        AppMethodBeat.o(208543);
        return;
      }
      localObject1 = e.d.hxF;
      long l;
      if (paramInt == e.d.aCs())
      {
        paramBundle = this.hSm;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.aBV();
          if ((paramBundle != null) && (paramBundle.aDu() == true)) {
            i = j;
          }
        }
        for (;;)
        {
          paramBundle = com.tencent.mm.live.b.x.hJf;
          localObject2 = com.tencent.mm.live.b.x.aGm();
          paramBundle = com.tencent.mm.live.b.x.hJf;
          l = com.tencent.mm.live.b.x.aGr().hyH;
          paramBundle = com.tencent.mm.live.b.x.hJf;
          paramBundle = com.tencent.mm.live.b.x.aHa().hKU;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.hFz;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          localObject1 = com.tencent.mm.live.b.x.hJf;
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.b.x.aGt(), i, 0, paramInt);
          AppMethodBeat.o(208543);
          return;
          paramBundle = this.hSm;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.aBV();
            if ((paramBundle != null) && (paramBundle.aDt() == true))
            {
              i = 2;
              continue;
            }
          }
          i = 0;
        }
      }
      localObject1 = e.d.hxF;
      if (paramInt == e.d.aCu())
      {
        paramBundle = com.tencent.mm.live.b.x.hJf;
        l = com.tencent.mm.live.b.x.aGr().hyH;
        paramBundle = com.tencent.mm.live.b.x.hJf;
        paramBundle = com.tencent.mm.live.b.x.aGm();
        localObject1 = com.tencent.mm.live.b.x.hJf;
        localObject1 = com.tencent.mm.live.b.x.aGr().LpF;
        kotlin.g.b.p.g(localObject1, "RoomLiveService.liveInfo.live_name");
        new com.tencent.mm.live.b.k(l, paramBundle, (String)localObject1, (byte)0).a((kotlin.g.a.r)new a(this));
        AppMethodBeat.o(208543);
        return;
      }
      localObject1 = e.d.hxF;
      if (paramInt == e.d.aCv())
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
          localObject1 = com.tencent.mm.live.b.x.hJf;
          localObject3 = com.tencent.mm.live.b.x.aGG();
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
          ((com.tencent.mm.live.b.x.c)localObject3).setUserId((String)localObject1);
          localObject1 = com.tencent.mm.live.b.x.hJf;
          localObject1 = com.tencent.mm.live.b.x.aGG();
          if (paramBundle == null) {
            break label1241;
          }
          paramInt = paramBundle.getInt("live_stream_type");
          ((com.tencent.mm.live.b.x.c)localObject1).streamType = paramInt;
          localObject1 = com.tencent.mm.live.b.x.hJf;
          localObject1 = com.tencent.mm.live.b.x.aGG();
          if (paramBundle == null) {
            break label1246;
          }
        }
      }
    }
    label1234:
    label1241:
    label1246:
    for (paramInt = paramBundle.getInt("live_first_frame_width");; paramInt = 0)
    {
      ((com.tencent.mm.live.b.x.c)localObject1).width = paramInt;
      localObject1 = com.tencent.mm.live.b.x.hJf;
      localObject1 = com.tencent.mm.live.b.x.aGG();
      paramInt = i;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("live_first_frame_height");
      }
      ((com.tencent.mm.live.b.x.c)localObject1).height = paramInt;
      b.b.a(this, b.c.hMy);
      AppMethodBeat.o(208543);
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
    return 2131495240;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void initLogic(LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(208526);
    kotlin.g.b.p.h(paramLiveConfig, "config");
    this.hWi = false;
    this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(getContext(), (byte)0);
    Object localObject1 = com.tencent.mm.live.core.core.a.b.hyv;
    getContext();
    this.hSm = ((com.tencent.mm.live.core.core.a.a)com.tencent.mm.live.core.core.a.b.a.aDo());
    localObject1 = this.hSm;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      ((com.tencent.mm.live.core.core.a.a)localObject1).a((AbsLiveMiniView)new RoomLiveMiniView((Context)localObject2));
    }
    localObject1 = this.hSm;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.a.a)localObject1).c((com.tencent.mm.live.core.core.c)this);
    }
    com.tencent.mm.live.b.r.hIg.release();
    if (paramLiveConfig.getLiveId() != 0L)
    {
      localObject1 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aGr().hyH = paramLiveConfig.getLiveId();
    }
    if (!Util.isNullOrNil(paramLiveConfig.aBD()))
    {
      localObject1 = com.tencent.mm.live.b.x.hJf;
      localObject1 = paramLiveConfig.aBD();
      kotlin.g.b.p.g(localObject1, "config.hostRoomId");
      com.tencent.mm.live.b.x.GQ((String)localObject1);
    }
    localObject1 = com.tencent.mm.live.b.x.hJf;
    localObject1 = paramLiveConfig.aBG();
    kotlin.g.b.p.g(localObject1, "config.anchorUsername");
    com.tencent.mm.live.b.x.GS((String)localObject1);
    localObject1 = findViewById(2131303613);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_verify_ui_root)");
    this.hVG = new ba((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303396);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_face_verify_ui_root)");
    this.hVH = new com.tencent.mm.live.c.t((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303355);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_before_ui_root)");
    this.hVI = new com.tencent.mm.live.c.k((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303307);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_after_ui_root)");
    this.hVJ = new com.tencent.mm.live.c.c((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303505);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_preview_ui_root)");
    this.hVK = new ao((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303557);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_shadow_ui_root)");
    this.hVL = new as((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303368);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_comment_ui_root)");
    this.hVM = new com.tencent.mm.live.c.m((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303511);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_ready_ui_root)");
    this.hVN = new aq((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303597);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_title_ui_root)");
    this.hVO = new ay((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303554);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_right_panel_ui_root)");
    this.hVQ = new com.tencent.mm.live.c.x((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303546);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_right_panel_btn4_parent)");
    this.hVR = new com.tencent.mm.live.c.g((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303461);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_members_list_ui_root)");
    this.hVP = new ai((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303343);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_ban_comment_ui_root)");
    this.hVS = new com.tencent.mm.live.c.i((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303379);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_common_info_ui_root)");
    this.hVT = new com.tencent.mm.live.c.o((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303501);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_minimize_ui_root)");
    this.hVU = new am((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303573);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_share_rooms_ui_root)");
    this.hVV = new au((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303431);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_loading_view_root)");
    this.hVW = new ae((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303493);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_mic_visitor_header_root)");
    this.hVX = new ak((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303420);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_like_confetti_ui_root)");
    this.hVY = new ac((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303475);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_members_profile_ui_root)");
    this.hVZ = new ag((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303315);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_anchor_close_ui_root)");
    this.hWa = new com.tencent.mm.live.c.e((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303390);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.live_exception_ui_root)");
    this.hWb = new com.tencent.mm.live.c.r((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = this.hVK;
    if (localObject1 != null)
    {
      localObject2 = (kotlin.g.a.m)new j(this);
      ((ao)localObject1).hAs.setPreviewMoveListener((kotlin.g.a.m)localObject2);
    }
    localObject1 = com.tencent.mm.live.b.r.hIg;
    com.tencent.mm.live.b.r.a(paramLiveConfig);
    localObject1 = this.hVQ;
    if (localObject1 != null)
    {
      kotlin.g.b.p.h(paramLiveConfig, "config");
      localObject2 = ((com.tencent.mm.live.c.x)localObject1).hQt;
      kotlin.g.b.p.g(localObject2, "shareBtn");
      ((ImageView)localObject2).setVisibility(0);
      localObject2 = ((com.tencent.mm.live.c.x)localObject1).hQv;
      kotlin.g.b.p.g(localObject2, "switchCameraBtn");
      ((ImageView)localObject2).setVisibility(0);
      ((com.tencent.mm.live.c.x)localObject1).hQt.setImageDrawable(ar.e(((com.tencent.mm.live.c.a)localObject1).hwr.getResources().getDrawable(2131690674), -1));
      ((com.tencent.mm.live.c.x)localObject1).hQv.setImageDrawable(ar.e(((com.tencent.mm.live.c.a)localObject1).hwr.getResources().getDrawable(2131690502), -1));
      ((com.tencent.mm.live.c.x)localObject1).hQu.setOnClickListener((View.OnClickListener)new com.tencent.mm.live.c.x.b((com.tencent.mm.live.c.x)localObject1));
      ((com.tencent.mm.live.c.x)localObject1).hQw.setOnClickListener((View.OnClickListener)new com.tencent.mm.live.c.x.c((com.tencent.mm.live.c.x)localObject1));
      localObject2 = ((com.tencent.mm.live.c.x)localObject1).hQu;
      kotlin.g.b.p.g(localObject2, "shareBtnClickArea");
      ((RelativeLayout)localObject2).setVisibility(8);
      localObject2 = ((com.tencent.mm.live.c.x)localObject1).hQx;
      kotlin.g.b.p.g(localObject2, "shareDescTv");
      ((TextView)localObject2).setVisibility(8);
      localObject1 = ((com.tencent.mm.live.c.x)localObject1).hQA;
      kotlin.g.b.p.g(localObject1, "shareBtnLayout");
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = this.hVP;
    if (localObject1 != null) {
      ((ai)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.hVJ;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.c)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.hVM;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.m)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.hVY;
    if (localObject1 != null) {
      ((ac)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.hVJ;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.c)localObject1).aHq();
    }
    localObject1 = this.hVZ;
    if (localObject1 != null) {
      ((ag)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.hVT;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.o)localObject1).aHy();
    }
    localObject1 = this.hWa;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.e)localObject1).rg(8);
    }
    localObject1 = this.hVG;
    if (localObject1 != null) {
      ((ba)localObject1).rg(8);
    }
    localObject1 = this.hVH;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.t)localObject1).rg(8);
    }
    localObject1 = this.hVI;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.k)localObject1).rg(0);
    }
    localObject1 = this.hVK;
    if (localObject1 != null) {
      ((ao)localObject1).rg(0);
    }
    localObject1 = this.hVL;
    if (localObject1 != null) {
      ((as)localObject1).rg(8);
    }
    localObject1 = this.hVJ;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.c)localObject1).rg(4);
    }
    localObject1 = this.hVM;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.m)localObject1).rg(8);
    }
    localObject1 = this.hVN;
    if (localObject1 != null) {
      ((aq)localObject1).rg(8);
    }
    localObject1 = this.hVO;
    if (localObject1 != null) {
      ((ay)localObject1).rg(8);
    }
    localObject1 = this.hVP;
    if (localObject1 != null) {
      ((ai)localObject1).rg(8);
    }
    localObject1 = this.hVQ;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.x)localObject1).rg(8);
    }
    localObject1 = this.hVS;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.i)localObject1).rg(8);
    }
    localObject1 = this.hVT;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.o)localObject1).rg(8);
    }
    localObject1 = this.hVU;
    if (localObject1 != null) {
      ((am)localObject1).rg(8);
    }
    localObject1 = this.hVV;
    if (localObject1 != null) {
      ((au)localObject1).rg(8);
    }
    localObject1 = this.hVW;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.live.b.x.hJf;
      ((ae)localObject1).Hc(com.tencent.mm.live.b.x.aGt());
    }
    localObject1 = this.hVZ;
    if (localObject1 != null) {
      ((ag)localObject1).rg(8);
    }
    localObject1 = this.hWb;
    if (localObject1 != null) {
      ((com.tencent.mm.live.c.r)localObject1).rg(8);
    }
    localObject1 = this.hVK;
    if (localObject1 != null)
    {
      localObject2 = (kotlin.g.a.m)new k(this);
      ((ao)localObject1).hAs.setPreviewTouchListener((kotlin.g.a.m)localObject2);
    }
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aGr().LpF = paramLiveConfig.aBF();
      localObject1 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aGr().hyH = paramLiveConfig.getLiveId();
      localObject1 = com.tencent.mm.live.b.x.hJf;
      paramLiveConfig = paramLiveConfig.aBD();
      kotlin.g.b.p.g(paramLiveConfig, "config.hostRoomId");
      com.tencent.mm.live.b.x.GQ(paramLiveConfig);
      b.b.a(this, b.c.hLV);
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
      paramLiveConfig = com.tencent.mm.live.b.m.hGg;
      com.tencent.mm.live.b.m.d(name(), this.liveMessageCallback);
      paramLiveConfig = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aHa().hKO = ((kotlin.g.a.b)new l(this));
      AppMethodBeat.o(208526);
      return;
      localObject1 = com.tencent.mm.live.b.x.hJf;
      localObject1 = com.tencent.mm.live.b.x.aGr();
      if ((localObject1 == null) || (((civ)localObject1).hyH != 0L))
      {
        localObject1 = com.tencent.mm.live.b.x.hJf;
        if (!Util.isNullOrNil(com.tencent.mm.live.b.x.aGm()))
        {
          localObject2 = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("init anchor plugin with live data, liveId:");
          localObject1 = com.tencent.mm.live.b.x.hJf;
          localObject1 = com.tencent.mm.live.b.x.aGr();
          if (localObject1 != null)
          {
            localObject1 = Long.valueOf(((civ)localObject1).hyH);
            label1800:
            Log.i((String)localObject2, ((Long)localObject1).longValue() + ", liveName:" + paramLiveConfig.aBF() + ", roomId:" + paramLiveConfig.aBD());
            localObject1 = this.hVO;
            if (localObject1 != null)
            {
              paramLiveConfig = com.tencent.mm.live.b.x.hJf;
              paramLiveConfig = com.tencent.mm.live.b.x.aGr().LpF;
              if (paramLiveConfig == null) {
                break label1929;
              }
              paramLiveConfig = (CharSequence)paramLiveConfig;
              label1872:
              localObject2 = com.tencent.mm.live.b.x.hJf;
              ((ay)localObject1).a(paramLiveConfig, com.tencent.mm.live.b.x.aGt());
            }
          }
        }
      }
      for (this.hWd = b.c.hMx;; this.hWd = b.c.hLy)
      {
        if ((this.hVG == null) || (ba.aHK() != true)) {
          break label1970;
        }
        statusChange(this.hWd, new Bundle());
        break;
        localObject1 = null;
        break label1800;
        label1929:
        paramLiveConfig = (CharSequence)"";
        break label1872;
        Log.i(this.TAG, "init logic from directly start");
        paramLiveConfig = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aGr().hyH = 0L;
      }
      label1970:
      paramLiveConfig = this.hVG;
      if (paramLiveConfig != null) {
        paramLiveConfig.rg(0);
      }
      paramLiveConfig = this.hVH;
      if (paramLiveConfig != null) {
        paramLiveConfig.rg(8);
      }
      paramLiveConfig = this.hVJ;
      if (paramLiveConfig != null) {
        paramLiveConfig.rg(4);
      }
      paramLiveConfig = this.hVM;
      if (paramLiveConfig != null) {
        paramLiveConfig.rg(8);
      }
      paramLiveConfig = this.hVQ;
      if (paramLiveConfig != null) {
        paramLiveConfig.rg(8);
      }
      paramLiveConfig = this.hVO;
      if (paramLiveConfig != null) {
        paramLiveConfig.rg(8);
      }
      paramLiveConfig = this.hVL;
      if (paramLiveConfig != null) {
        paramLiveConfig.rg(8);
      }
      paramLiveConfig = this.hVS;
      if (paramLiveConfig != null) {
        paramLiveConfig.rg(8);
      }
      paramLiveConfig = this.hVW;
      if (paramLiveConfig != null) {
        paramLiveConfig.rg(8);
      }
      statusChange(b.c.hLu, new Bundle());
    }
  }
  
  public final void mount()
  {
    AppMethodBeat.i(208530);
    super.mount();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().a(3806, (com.tencent.mm.ak.i)this);
    localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().a(3559, (com.tencent.mm.ak.i)this);
    localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().a(3557, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(208530);
  }
  
  public final String name()
  {
    AppMethodBeat.i(208529);
    String str = getClass().getSimpleName();
    kotlin.g.b.p.g(str, "this.javaClass.simpleName");
    AppMethodBeat.o(208529);
    return str;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(208534);
    boolean bool2 = super.onBackPress();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
      bool1 = bool2;
      if (!com.tencent.mm.live.b.x.aGD().hJp)
      {
        localx = com.tencent.mm.live.b.x.hJf;
        bool1 = bool2;
        if (com.tencent.mm.live.b.x.aGD().hJo)
        {
          b.b.a(this, b.c.hLC);
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(208534);
    return bool1;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(208527);
    kotlin.g.b.p.h(paramString, "incomingNumber");
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.hSm;
    if (paramString != null)
    {
      paramString = paramString.aBV();
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
        AppMethodBeat.o(208527);
        return;
        paramString = null;
        break;
        AppMethodBeat.o(208527);
        return;
        paramString = com.tencent.mm.live.b.r.hIg;
        com.tencent.mm.live.b.r.qS(2);
        paramString = this.hSm;
        if (paramString != null)
        {
          paramString = paramString.aBV();
          if ((paramString != null) && (paramString.isFloatMode() == true))
          {
            paramString = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.aGy();
            paramString = this.hSm;
            if (paramString != null) {
              paramString.aBS();
            }
            paramString = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.aHi();
            AppMethodBeat.o(208527);
            return;
          }
        }
        paramString = this.hSm;
        if (paramString != null) {
          paramString.aBS();
        }
        paramString = this.hSm;
        if (paramString != null)
        {
          paramString.aBX();
          AppMethodBeat.o(208527);
          return;
        }
        AppMethodBeat.o(208527);
        return;
        paramString = com.tencent.mm.live.b.r.hIg;
        com.tencent.mm.live.b.r.qS(0);
        paramString = this.hSm;
        if (paramString == null) {
          break label331;
        }
        paramString = paramString.aBV();
        if (paramString == null) {
          break label331;
        }
        localObject = com.tencent.mm.live.b.x.hJf;
      } while (paramString.b(Long.valueOf(com.tencent.mm.live.b.x.aGr().hyH)) != true);
      paramString = this.hVK;
      if (paramString != null) {
        paramString.startPreview();
      }
      paramString = this.hSm;
    } while (paramString == null);
    paramString.aBY();
    AppMethodBeat.o(208527);
    return;
    label331:
    AppMethodBeat.o(208527);
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(208542);
    if ((this.lastRotationFromSensor == -1) || (this.lastRotationFromSensor != paramInt))
    {
      Log.i(this.TAG, "onOrientationChange orientation:".concat(String.valueOf(paramInt)));
      this.lastRotationFromSensor = paramInt;
      Log.i(this.TAG, "refreshCamera");
      com.tencent.mm.live.core.core.a.a locala = this.hSm;
      if (locala != null)
      {
        locala.aBT();
        AppMethodBeat.o(208542);
        return;
      }
    }
    AppMethodBeat.o(208542);
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean)
  {
    this.hWg = paramBoolean;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(208535);
    Log.i(this.TAG, "errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramq instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJn)
        {
          paramString = com.tencent.mm.live.b.x.hJf;
          if (!com.tencent.mm.live.b.x.aGD().hJp) {}
        }
        else
        {
          AppMethodBeat.o(208535);
          return;
        }
        paramString = this.hVS;
        if (paramString != null)
        {
          paramq = com.tencent.mm.live.b.x.hJf;
          paramString.hOV = com.tencent.mm.live.b.x.aGr().KNv;
        }
        paramString = this.hVS;
        if (paramString != null) {
          paramString.aHu();
        }
        paramString = com.tencent.mm.live.b.x.hJf;
        paramString = com.tencent.mm.live.b.x.hJf;
        paramInt1 = i;
        if (!com.tencent.mm.live.b.x.aGr().KNv) {
          paramInt1 = cl.aWB();
        }
        com.tencent.mm.live.b.x.qT(paramInt1);
        paramString = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGr().pSb > 0) {
          b.b.a(this, b.c.hLV);
        }
        AppMethodBeat.o(208535);
      }
    }
    else
    {
      if ((paramq instanceof com.tencent.mm.live.b.a.p))
      {
        paramString = this.hVP;
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
          paramq = paramString.hRS;
          if (paramq != null) {
            paramq.dismiss();
          }
          if (i != 0)
          {
            paramq = paramString.hwr.getContext();
            paramString = paramString.hwr.getContext();
            kotlin.g.b.p.g(paramString, "root.context");
            com.tencent.mm.ui.base.u.cG(paramq, paramString.getResources().getString(2131762319));
            AppMethodBeat.o(208535);
            return;
          }
          paramq = paramString.hwr.getContext();
          paramString = paramString.hwr.getContext();
          kotlin.g.b.p.g(paramString, "root.context");
          com.tencent.mm.ui.base.u.cH(paramq, paramString.getResources().getString(2131762318));
          AppMethodBeat.o(208535);
          return;
        }
        AppMethodBeat.o(208535);
        return;
      }
      if (((paramq instanceof com.tencent.mm.live.b.a.u)) && ((paramInt1 != 0) || (paramInt2 != 0)))
      {
        paramInt1 = this.hWj;
        paramString = com.tencent.mm.live.b.o.hGl;
        if (paramInt1 < com.tencent.mm.live.b.o.aFk())
        {
          this.hWj += 1;
          Log.i(this.TAG, "will retry share live, delay:" + this.hWj * 1000L);
          postDelayed((Runnable)o.hWu, this.hWj * 1000L);
        }
      }
    }
    AppMethodBeat.o(208535);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(208541);
    super.pause();
    boolean bool = aJo();
    Log.i(this.TAG, "pause orientationChanged:" + bool + ", currentOrientation:" + getCurrentOrientation());
    Object localObject;
    if (!bool)
    {
      localObject = com.tencent.mm.live.b.x.hJf;
      if (!com.tencent.mm.live.b.x.aGD().hJp)
      {
        localObject = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJn)
        {
          localObject = com.tencent.mm.live.b.x.hJf;
          if (!com.tencent.mm.live.b.x.aGD().hJq)
          {
            localObject = com.tencent.mm.live.b.x.hJf;
            if (com.tencent.mm.live.b.x.aGD().hJo)
            {
              localObject = com.tencent.mm.live.b.x.hJf;
              if ((!com.tencent.mm.live.b.x.isManualClosed()) && (!this.hWi) && (com.tencent.mm.compatible.e.b.cx(getContext())))
              {
                localObject = new Bundle();
                ((Bundle)localObject).putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 3);
                statusChange(b.c.hLQ, (Bundle)localObject);
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
      AppMethodBeat.o(208541);
      return;
      localObject = this.hSm;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).aBV();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.g)localObject).isNormalMode() == true) && (!this.hWi))
        {
          localObject = this.hSm;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.a)localObject).aBS();
          }
          localObject = this.hSm;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.a.a)localObject).aBX();
          }
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(208540);
    super.resume();
    Log.d(this.TAG, "resume curRotation:" + getCurrentOrientation());
    Object localObject1 = com.tencent.mm.live.b.x.hJf;
    com.tencent.mm.live.b.x.aGD().hJq = false;
    localObject1 = com.tencent.mm.live.b.x.hJf;
    Object localObject2;
    if (com.tencent.mm.live.b.x.aGr().hyH != 0L)
    {
      localObject1 = com.tencent.mm.live.b.x.hJf;
      if (!com.tencent.mm.live.b.x.aGD().hJn)
      {
        localObject1 = com.tencent.mm.kernel.g.azz();
        kotlin.g.b.p.g(localObject1, "MMKernel.getNetSceneQueue()");
        if (((com.tencent.mm.ak.t)localObject1).azD() != null)
        {
          localObject1 = com.tencent.mm.live.b.x.hJf;
          long l = com.tencent.mm.live.b.x.aGr().hyH;
          localObject1 = com.tencent.mm.live.b.x.hJf;
          localObject1 = new com.tencent.mm.live.b.a.b(l, com.tencent.mm.live.b.x.aGm(), true);
          localObject2 = com.tencent.mm.kernel.g.azz();
          kotlin.g.b.p.g(localObject2, "MMKernel.getNetSceneQueue()");
          ((com.tencent.mm.live.b.a.b)localObject1).doScene(((com.tencent.mm.ak.t)localObject2).azD(), (com.tencent.mm.ak.i)new p(this));
        }
        localObject1 = this.hSm;
        if (localObject1 == null) {
          break label318;
        }
        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.b.g)localObject1).hzz)) {
          break label318;
        }
        localObject1 = this.hSm;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.a.a)localObject1).aBU();
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.setLastOrientation(getCurrentOrientation());
      AppMethodBeat.o(208540);
      return;
      localObject1 = this.hVK;
      if (localObject1 != null) {
        ((ao)localObject1).startPreview();
      }
      localObject1 = this.hSm;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.b.g)localObject1).isNormalMode() != true)) {
        break;
      }
      localObject1 = this.hSm;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.live.b.x.hJf;
      if (((com.tencent.mm.live.core.core.b.g)localObject1).b(Long.valueOf(com.tencent.mm.live.b.x.aGr().hyH)) != true) {
        break;
      }
      localObject1 = this.hSm;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.live.core.core.a.a)localObject1).aBY();
      break;
      label318:
      localObject1 = this.hSm;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.b.g)localObject1).hzz = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(208532);
    super.start();
    Object localObject = com.tencent.mm.live.b.r.hIg;
    com.tencent.mm.live.b.r.aGb();
    localObject = com.tencent.mm.live.b.x.hJf;
    if ((com.tencent.mm.live.b.x.aGr().hyH == 0L) && (this.hWg))
    {
      localObject = com.tencent.mm.live.b.x.hJf;
      if (!com.tencent.mm.live.b.x.aGD().hJn)
      {
        localObject = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJq)
        {
          localObject = com.tencent.mm.live.b.x.hJf;
          if (!com.tencent.mm.live.b.x.aGD().hJp)
          {
            localObject = getContext();
            if (localObject == null)
            {
              localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(208532);
              throw ((Throwable)localObject);
            }
            ((Activity)localObject).setRequestedOrientation(4);
          }
        }
      }
    }
    startTimer();
    AppMethodBeat.o(208532);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208525);
    kotlin.g.b.p.h(paramc, "status");
    Log.i(this.TAG, "statusChange:" + paramc.name());
    this.hWc = paramc;
    switch (b.haE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(208525);
      return;
      if (this.hWg)
      {
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(208525);
          throw paramc;
        }
        ((Activity)localObject1).setRequestedOrientation(4);
      }
      Object localObject1 = this.hWd;
      Object localObject2;
      Object localObject3;
      switch (b.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        break;
      case 1: 
        localObject1 = com.tencent.mm.live.b.r.hIg;
        com.tencent.mm.live.b.r.qS(0);
        localObject1 = this.hVK;
        if (localObject1 != null) {
          ((ao)localObject1).rg(0);
        }
        localObject1 = this.hVG;
        if (localObject1 != null) {
          ((ba)localObject1).rg(8);
        }
        localObject1 = this.hVH;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.t)localObject1).rg(8);
        }
        localObject1 = this.hVI;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.k)localObject1).rg(8);
        }
        localObject1 = this.hVJ;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.c)localObject1).rg(8);
        }
        localObject1 = this.hVM;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.m)localObject1).rg(8);
        }
        localObject1 = this.hVQ;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.x)localObject1).rg(8);
        }
        localObject1 = this.hVO;
        if (localObject1 != null) {
          ((ay)localObject1).rg(8);
        }
        localObject1 = this.hVL;
        if (localObject1 != null) {
          ((as)localObject1).rg(8);
        }
        localObject1 = this.hVS;
        if (localObject1 != null) {
          ((com.tencent.mm.live.c.i)localObject1).rg(8);
        }
        localObject2 = this.hVO;
        if (localObject2 != null)
        {
          localObject1 = com.tencent.mm.live.b.x.hJf;
          localObject1 = com.tencent.mm.live.b.x.aGr().LpF;
          if (localObject1 == null) {
            break label523;
          }
        }
        for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
        {
          localObject3 = com.tencent.mm.live.b.x.hJf;
          ((ay)localObject2).a((CharSequence)localObject1, com.tencent.mm.live.b.x.aGt());
          statusChange(b.c.hMx, new Bundle());
          break;
        }
      case 2: 
        label523:
        statusChange(b.c.hLy, new Bundle());
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
        localObject1 = com.tencent.mm.live.b.c.a.hLc;
        localObject1 = com.tencent.mm.live.b.c.a.aHm();
        Log.i(this.TAG, "lockOrientation liveRotation:" + ((cip)localObject1).rotation + ", curRotation:" + getCurrentOrientation());
        boolean bool1;
        if ((((cip)localObject1).rotation == -1) || (((cip)localObject1).rotation == getCurrentOrientation()))
        {
          localObject1 = getContext();
          if (localObject1 == null)
          {
            paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(208525);
            throw paramc;
          }
          ((Activity)localObject1).setRequestedOrientation(14);
          localObject1 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
          kotlin.g.b.p.g(localObject1, "ConfigHelper.getInstance()");
          localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).aDD();
          kotlin.g.b.p.g(localObject1, "ConfigHelper.getInstance().videoConfig");
          localObject2 = getContext();
          kotlin.g.b.p.g(localObject2, "context");
          localObject2 = ((Context)localObject2).getResources();
          kotlin.g.b.p.g(localObject2, "context.resources");
          if (((Resources)localObject2).getConfiguration().orientation != 1) {
            break label1229;
          }
          bool1 = true;
          label773:
          ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject1).eA(bool1);
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("create live, isVideoVertical:");
          localObject3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
          kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance()");
          localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).aDD();
          kotlin.g.b.p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
          Log.i((String)localObject1, ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).aDS());
          localObject1 = com.tencent.mm.live.b.x.hJf;
          localObject3 = com.tencent.mm.live.b.x.aGr();
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
          ((civ)localObject3).LpF = ((String)localObject1);
          localObject1 = com.tencent.mm.live.b.x.hJf;
          localObject1 = com.tencent.mm.live.b.x.aGr().LpF;
          kotlin.g.b.p.g(localObject1, "RoomLiveService.liveInfo.live_name");
          localObject2 = com.tencent.mm.live.b.x.hJf;
          l = com.tencent.mm.live.b.x.aGr().hyH;
          localObject2 = com.tencent.mm.live.b.x.hJf;
          localObject2 = com.tencent.mm.live.b.x.aGm();
          Log.i(this.TAG, "startLive, name:" + (String)localObject1 + ", roomId:" + l);
          if ((l == 0L) || (Util.isNullOrNil((String)localObject2))) {
            break label1288;
          }
          Log.i(this.TAG, "try resume live, liveId:" + l + ", liveName:" + (String)localObject1 + ", roomId:" + (String)localObject2);
          localObject3 = com.tencent.mm.live.b.x.hJf;
          localObject3 = com.tencent.mm.live.b.x.aGv();
          if (localObject3 != null) {
            break label1235;
          }
          new com.tencent.mm.live.b.k(l, (String)localObject2, (String)localObject1, (byte)0).a((kotlin.g.a.r)new u(this));
        }
        for (;;)
        {
          localObject1 = this.hSm;
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.live.core.core.a.a)localObject1).aBY();
          break;
          switch (((cip)localObject1).rotation)
          {
          default: 
            break;
          case 0: 
          case 2: 
            this.hWi = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(208525);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(1);
            break;
          case 1: 
          case 3: 
            this.hWi = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(208525);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(0);
            break;
            label1229:
            bool1 = false;
            break label773;
            label1235:
            localObject1 = this.hSm;
            if (localObject1 != null) {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((f)localObject3);
            }
            localObject1 = this.hSm;
            if (localObject1 != null)
            {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.c)new v(this));
              continue;
              label1288:
              Log.i("MicroMsg.LiveCoreAnchor", "createNewLive, liveName:" + (String)localObject1 + ", wechatRoomId:" + (String)localObject2);
              localObject3 = getContext();
              kotlin.g.b.p.g(localObject3, "context");
              localObject1 = new com.tencent.mm.live.b.l((String)localObject1, (String)localObject2, (Context)localObject3);
              localObject2 = (s)new b(this);
              localObject3 = com.tencent.mm.kernel.g.aAg();
              kotlin.g.b.p.g(localObject3, "MMKernel.network()");
              ((com.tencent.mm.kernel.b)localObject3).azz().a(3501, (com.tencent.mm.ak.i)localObject1);
              localObject3 = new com.tencent.mm.live.b.a.l(((com.tencent.mm.live.b.l)localObject1).name, ((com.tencent.mm.live.b.l)localObject1).roomId);
              localObject4 = com.tencent.mm.kernel.g.aAg();
              kotlin.g.b.p.g(localObject4, "MMKernel.network()");
              ((com.tencent.mm.kernel.b)localObject4).azz().b((com.tencent.mm.ak.q)localObject3);
              ((com.tencent.mm.live.b.l)localObject1).hFY = ((s)localObject2);
            }
            break;
          }
        }
        localObject1 = com.tencent.mm.live.b.x.hJf;
        localObject1 = com.tencent.mm.live.b.x.aGr().LpF;
        kotlin.g.b.p.g(localObject1, "RoomLiveService.liveInfo.live_name");
        localObject2 = com.tencent.mm.live.b.x.hJf;
        localObject2 = com.tencent.mm.live.b.x.aGm();
        localObject3 = getContext();
        kotlin.g.b.p.g(localObject3, "context");
        localObject1 = new com.tencent.mm.live.b.l((String)localObject1, (String)localObject2, (Context)localObject3);
        localObject2 = (s)new m(this);
        localObject3 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(localObject3, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject3).azz().a(3797, (com.tencent.mm.ak.i)localObject1);
        localObject3 = com.tencent.mm.live.b.x.hJf;
        long l = com.tencent.mm.live.b.x.aGr().hyH;
        localObject3 = ((com.tencent.mm.live.b.l)localObject1).roomId;
        Object localObject4 = com.tencent.mm.live.b.x.hJf;
        localObject3 = new com.tencent.mm.live.b.a.o(l, (String)localObject3, com.tencent.mm.live.b.x.aGq());
        localObject4 = com.tencent.mm.kernel.g.aAg();
        kotlin.g.b.p.g(localObject4, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject4).azz().b((com.tencent.mm.ak.q)localObject3);
        ((com.tencent.mm.live.b.l)localObject1).hFZ = ((s)localObject2);
        continue;
        this.hWh.aTv();
        localObject1 = this.hVW;
        if (localObject1 != null) {
          ((ae)localObject1).rg(8);
        }
        localObject1 = (Runnable)new q(this);
        localObject2 = ae.hRk;
        postDelayed((Runnable)localObject1, ae.aHE() + 50L);
        com.tencent.mm.live.b.r.hIg.aGd();
        localObject1 = com.tencent.mm.live.b.r.hIg;
        com.tencent.mm.live.b.r.aFY();
        localObject1 = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGr().Gaz == 0)
        {
          localObject1 = com.tencent.mm.live.b.x.hJf;
          com.tencent.mm.live.b.x.aGr().Gaz = cl.aWB();
        }
        localObject1 = com.tencent.mm.live.b.c.a.hLc;
        if (com.tencent.mm.live.b.c.a.aHm().hyH != 0L) {}
        int j;
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            localObject1 = com.tencent.mm.live.b.c.a.hLc;
            localObject1 = com.tencent.mm.live.b.x.hJf;
            l = com.tencent.mm.live.b.x.aGr().hyH;
            localObject1 = com.tencent.mm.live.b.x.hJf;
            localObject1 = com.tencent.mm.live.b.x.aGm();
            i = getCurrentOrientation();
            localObject2 = com.tencent.mm.live.b.x.hJf;
            localObject2 = com.tencent.mm.live.b.x.aHe();
            localObject3 = com.tencent.mm.live.b.x.hJf;
            j = com.tencent.mm.live.b.x.aGr().Gaz;
            localObject3 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.c.a.a(l, (String)localObject1, i, (String)localObject2, j, com.tencent.mm.live.b.x.aGt());
          }
          localObject1 = com.tencent.mm.live.b.x.hJf;
          com.tencent.mm.live.b.x.aHf();
          localObject1 = com.tencent.mm.live.b.r.hIg;
          com.tencent.mm.live.b.r.qS(0);
          startTimer();
          break;
        }
        localObject1 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aGy();
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(208525);
          throw paramc;
        }
        ((Activity)localObject1).finishAndRemoveTask();
        continue;
        localObject1 = this.hVR;
        if ((localObject1 != null) && (((com.tencent.mm.live.c.g)localObject1).hON.isShowing())) {
          ((com.tencent.mm.live.c.g)localObject1).hON.dismiss();
        }
        localObject1 = this.hVW;
        if (localObject1 != null) {
          ((ae)localObject1).rg(8);
        }
        localObject1 = this.hSm;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.a.a)localObject1).aBW();
        }
        aJm();
        localObject1 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aHh();
        localObject1 = com.tencent.mm.live.b.r.hIg;
        com.tencent.mm.live.b.r.aGa();
        localObject1 = com.tencent.mm.live.b.r.hIg;
        com.tencent.mm.live.b.r.aGb();
        com.tencent.mm.live.b.r.hIg.release();
        localObject1 = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.aFh();
        localObject1 = com.tencent.mm.live.b.c.a.hLc;
        localObject1 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.c.a.zE(com.tencent.mm.live.b.x.aGr().hyH);
        continue;
        localObject1 = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJn)
        {
          localObject1 = this.hVN;
          if (localObject1 != null) {
            ((aq)localObject1).rg(8);
          }
          localObject1 = this.hVK;
          if (localObject1 != null) {
            ((ao)localObject1).rg(8);
          }
          localObject1 = this.hVG;
          if (localObject1 != null) {
            ((ba)localObject1).rg(8);
          }
          localObject1 = this.hVH;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.t)localObject1).rg(8);
          }
          localObject1 = this.hVI;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.k)localObject1).rg(8);
          }
          localObject1 = this.hVW;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.live.b.x.hJf;
            localObject2 = com.tencent.mm.live.b.x.aGt();
            localObject3 = getContext();
            kotlin.g.b.p.g(localObject3, "context");
            localObject3 = ((Context)localObject3).getResources().getString(2131762312);
            kotlin.g.b.p.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
            ((ae)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
          }
          localObject1 = com.tencent.mm.live.b.x.hJf;
          com.tencent.mm.live.b.x.aHg();
          continue;
          localObject1 = com.tencent.mm.live.b.x.hJf;
          if (!com.tencent.mm.live.b.x.aGD().hJn)
          {
            localObject1 = this.hVK;
            if (localObject1 != null) {
              ((ao)localObject1).rg(0);
            }
            localObject1 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.aGD().hJp = false;
            continue;
            if (this.hWg)
            {
              localObject1 = getContext();
              if (localObject1 == null)
              {
                paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(208525);
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
              kotlin.g.b.p.g(localObject1, "param?.getString(ILiveSt…LIVE_KICK_USERNAME) ?: \"\"");
              localObject2 = com.tencent.mm.live.b.r.hIg;
              com.tencent.mm.live.b.r.GP((String)localObject1);
              continue;
              localObject1 = com.tencent.mm.live.b.x.hJf;
              com.tencent.mm.live.b.x.aGD().hJq = true;
              continue;
              localObject1 = this.hVW;
              if (localObject1 != null) {
                ((ae)localObject1).rg(8);
              }
              localObject1 = this.orientationEventListener;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).a((d.a)this);
              }
              localObject1 = this.orientationEventListener;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).enable();
              }
              localObject1 = com.tencent.mm.live.b.x.hJf;
              if (com.tencent.mm.live.b.x.aGE().hJk)
              {
                localObject1 = this.hVH;
                if (localObject1 != null) {
                  ((com.tencent.mm.live.c.t)localObject1).rg(0);
                }
                statusChange(b.c.hLw, new Bundle());
                localObject1 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGE().hJk = false;
                continue;
                localObject1 = com.tencent.mm.live.b.x.hJf;
                if (com.tencent.mm.live.b.x.aGL()) {}
                for (i = 4;; i = 5)
                {
                  localObject1 = com.tencent.mm.live.b.x.hJf;
                  localObject1 = com.tencent.mm.live.b.x.aGm();
                  localObject2 = com.tencent.mm.live.b.x.hJf;
                  bool1 = com.tencent.mm.live.b.x.aGI();
                  localObject2 = com.tencent.mm.live.b.x.hJf;
                  bool2 = com.tencent.mm.live.b.x.aGJ();
                  localObject2 = com.tencent.mm.live.b.x.hJf;
                  localObject2 = com.tencent.mm.live.b.x.aGr().LpF;
                  localObject3 = com.tencent.mm.live.b.x.hJf;
                  bool3 = com.tencent.mm.live.b.x.aGH();
                  localObject3 = getContext();
                  kotlin.g.b.p.g(localObject3, "context");
                  localObject3 = ((Context)localObject3).getResources();
                  kotlin.g.b.p.g(localObject3, "context.resources");
                  com.tencent.mm.live.d.e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, ((Resources)localObject3).getConfiguration().orientation, i);
                  localObject1 = getContext();
                  kotlin.g.b.p.g(localObject1, "context");
                  localObject1 = ((Context)localObject1).getResources();
                  kotlin.g.b.p.g(localObject1, "context.resources");
                  if (((Resources)localObject1).getConfiguration().orientation != 2) {
                    break label2657;
                  }
                  com.tencent.mm.live.d.a.aIf();
                  break;
                }
                label2657:
                com.tencent.mm.live.d.a.aIg();
                continue;
                localObject1 = com.tencent.mm.live.b.x.hJf;
                if (!com.tencent.mm.live.b.x.aGD().hJn)
                {
                  localObject1 = this.hVN;
                  if (localObject1 != null) {
                    ((aq)localObject1).rg(8);
                  }
                  localObject1 = this.hVK;
                  if (localObject1 != null) {
                    ((ao)localObject1).rg(8);
                  }
                  localObject1 = this.hVG;
                  if (localObject1 != null) {
                    ((ba)localObject1).rg(8);
                  }
                  localObject1 = this.hVH;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.c.t)localObject1).rg(8);
                  }
                  localObject1 = this.hVI;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.c.k)localObject1).rg(8);
                  }
                  localObject1 = this.hVW;
                  if (localObject1 != null)
                  {
                    localObject2 = com.tencent.mm.live.b.x.hJf;
                    localObject2 = com.tencent.mm.live.b.x.aGt();
                    localObject3 = getContext();
                    kotlin.g.b.p.g(localObject3, "context");
                    localObject3 = ((Context)localObject3).getResources().getString(2131762312);
                    kotlin.g.b.p.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
                    ((ae)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
                  }
                  localObject1 = com.tencent.mm.live.b.x.hJf;
                  com.tencent.mm.live.b.x.aHg();
                }
                localObject1 = com.tencent.mm.live.b.x.hJf;
                localObject1 = com.tencent.mm.live.b.x.aGm();
                localObject2 = com.tencent.mm.live.b.x.hJf;
                bool1 = com.tencent.mm.live.b.x.aGI();
                localObject2 = com.tencent.mm.live.b.x.hJf;
                boolean bool2 = com.tencent.mm.live.b.x.aGJ();
                localObject2 = com.tencent.mm.live.b.x.hJf;
                localObject2 = com.tencent.mm.live.b.x.aGr().LpF;
                localObject3 = com.tencent.mm.live.b.x.hJf;
                boolean bool3 = com.tencent.mm.live.b.x.aGH();
                localObject3 = getContext();
                kotlin.g.b.p.g(localObject3, "context");
                localObject3 = ((Context)localObject3).getResources();
                kotlin.g.b.p.g(localObject3, "context.resources");
                j = ((Resources)localObject3).getConfiguration().orientation;
                if (paramBundle != null) {}
                for (i = paramBundle.getInt("live_user_exit_reason");; i = 0)
                {
                  com.tencent.mm.live.d.e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, j, 6, i);
                  break;
                }
                localObject1 = this.hVK;
                if (localObject1 != null) {
                  ((ao)localObject1).hAs.hER.aEZ();
                }
                localObject1 = this.hSm;
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
                  if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.g)localObject1).aDu() == true))
                  {
                    localObject1 = this.hSm;
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
                      if (localObject1 != null)
                      {
                        ((com.tencent.mm.live.core.core.b.g)localObject1).hzB = g.b.hzP;
                        continue;
                        localObject1 = this.hSm;
                        if (localObject1 != null)
                        {
                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.live.core.core.b.g)localObject1).hzE = g.d.hzW;
                            continue;
                            localObject1 = this.hSm;
                            if (localObject1 != null)
                            {
                              localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
                              if (localObject1 != null)
                              {
                                ((com.tencent.mm.live.core.core.b.g)localObject1).hzE = g.d.hzY;
                                continue;
                                localObject1 = this.hSm;
                                if (localObject1 != null)
                                {
                                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
                                  if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.g)localObject1).isFloatMode()))
                                  {
                                    if (paramBundle != null) {}
                                    for (i = paramBundle.getInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0);; i = 0)
                                    {
                                      localObject1 = this.hSm;
                                      if (localObject1 != null)
                                      {
                                        localObject2 = getContext();
                                        kotlin.g.b.p.g(localObject2, "context");
                                        com.tencent.mm.live.core.core.b.a.a((com.tencent.mm.live.core.core.b)localObject1, (Context)localObject2, false, false, i, 0, 22);
                                      }
                                      localObject1 = com.tencent.mm.live.b.x.hJf;
                                      localObject1 = com.tencent.mm.live.b.x.aGm();
                                      localObject2 = com.tencent.mm.live.b.x.hJf;
                                      l = com.tencent.mm.live.b.x.aGr().hyH;
                                      localObject2 = com.tencent.mm.live.b.x.hJf;
                                      localObject2 = com.tencent.mm.live.b.x.aGt();
                                      localObject3 = com.tencent.mm.live.b.x.hJf;
                                      com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 1, com.tencent.mm.live.b.x.aGr().LIa);
                                      com.tencent.mm.live.d.a.aId();
                                      break;
                                    }
                                    localObject1 = com.tencent.mm.live.b.x.hJf;
                                    localObject1 = com.tencent.mm.live.b.x.aGm();
                                    localObject2 = com.tencent.mm.live.b.x.hJf;
                                    l = com.tencent.mm.live.b.x.aGr().hyH;
                                    localObject2 = com.tencent.mm.live.b.x.hJf;
                                    localObject2 = com.tencent.mm.live.b.x.aGt();
                                    localObject3 = com.tencent.mm.live.b.x.hJf;
                                    com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 0, com.tencent.mm.live.b.x.aGr().LIa);
                                    com.tencent.mm.live.d.a.aIe();
                                    continue;
                                    localObject1 = this.hSm;
                                    if (localObject1 != null)
                                    {
                                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
                                      if (localObject1 != null)
                                      {
                                        ((com.tencent.mm.live.core.core.b.g)localObject1).hzB = g.b.hzO;
                                        continue;
                                        localObject1 = this.hSm;
                                        if (localObject1 != null)
                                        {
                                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).aBV();
                                          if (localObject1 != null) {
                                            ((com.tencent.mm.live.core.core.b.g)localObject1).hzB = g.b.hzN;
                                          }
                                        }
                                        localObject1 = this.hVX;
                                        if (localObject1 != null)
                                        {
                                          this.hWe.remove(localObject1);
                                          continue;
                                          localObject1 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                                          kotlin.g.b.p.g(localObject1, "ConfigHelper.getInstance()");
                                          localObject1 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject1).aDD();
                                          kotlin.g.b.p.g(localObject1, "ConfigHelper.getInstance().videoConfig");
                                          localObject2 = com.tencent.mm.live.b.x.hJf;
                                          if (!com.tencent.mm.live.b.x.aGG().isLandscape())
                                          {
                                            bool1 = true;
                                            label3484:
                                            ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject1).eB(bool1);
                                            localObject1 = this.hSm;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.core.core.a.a)localObject1).A(0.0F, 0.0F);
                                            }
                                            localObject1 = this.hVK;
                                            if (localObject1 == null) {
                                              continue;
                                            }
                                            localObject2 = com.tencent.mm.live.b.x.hJf;
                                            if (!com.tencent.mm.live.b.x.aGG().isLandscape()) {
                                              break label3594;
                                            }
                                          }
                                          label3594:
                                          for (i = 2;; i = 1)
                                          {
                                            localObject2 = com.tencent.mm.live.b.x.hJf;
                                            localObject2 = com.tencent.mm.live.b.x.aGG().userId;
                                            localObject3 = com.tencent.mm.live.b.x.hJf;
                                            j = com.tencent.mm.live.b.x.aGG().streamType;
                                            kotlin.g.b.p.h(localObject2, "userId");
                                            ((ao)localObject1).hAs.c(i, (String)localObject2, j);
                                            break;
                                            bool1 = false;
                                            break label3484;
                                          }
                                          localObject1 = com.tencent.mm.live.b.x.hJf;
                                          if (!com.tencent.mm.live.b.x.aGD().hJn)
                                          {
                                            localObject1 = this.hVN;
                                            if (localObject1 != null) {
                                              ((aq)localObject1).rg(8);
                                            }
                                            localObject1 = this.hVK;
                                            if (localObject1 != null) {
                                              ((ao)localObject1).rg(8);
                                            }
                                            localObject1 = this.hVG;
                                            if (localObject1 != null) {
                                              ((ba)localObject1).rg(8);
                                            }
                                            localObject1 = this.hVH;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.t)localObject1).rg(8);
                                            }
                                            localObject1 = this.hVI;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.k)localObject1).rg(8);
                                            }
                                            localObject1 = this.hVW;
                                            if (localObject1 != null) {
                                              ((ae)localObject1).rg(8);
                                            }
                                            localObject1 = this.hWb;
                                            if (localObject1 != null) {
                                              ((com.tencent.mm.live.c.r)localObject1).rg(0);
                                            }
                                            localObject1 = com.tencent.mm.live.b.x.hJf;
                                            com.tencent.mm.live.b.x.aHg();
                                            localObject1 = getContext();
                                            if (localObject1 == null)
                                            {
                                              paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                                              AppMethodBeat.o(208525);
                                              throw paramc;
                                            }
                                            ((Activity)localObject1).setRequestedOrientation(1);
                                            continue;
                                            localObject1 = this.hVO;
                                            if (localObject1 != null)
                                            {
                                              localObject2 = com.tencent.mm.live.b.x.hJf;
                                              localObject2 = com.tencent.mm.live.b.x.aGr().LpF;
                                              kotlin.g.b.p.g(localObject2, "RoomLiveService.liveInfo.live_name");
                                              localObject2 = (CharSequence)localObject2;
                                              localObject3 = com.tencent.mm.live.b.x.hJf;
                                              ((ay)localObject1).a((CharSequence)localObject2, com.tencent.mm.live.b.x.aGt());
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
    AppMethodBeat.i(208533);
    super.stop();
    this.timerThread.stopTimer();
    AppMethodBeat.o(208533);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(208531);
    super.unMount();
    Object localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().b(3806, (com.tencent.mm.ak.i)this);
    localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().b(3559, (com.tencent.mm.ak.i)this);
    localObject = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().b(3557, (com.tencent.mm.ak.i)this);
    if ((!aJo()) && (!this.hWi))
    {
      localObject = this.hSm;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).aBV();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.b.g)localObject).aDu() == true)) {}
      }
      else
      {
        localObject = this.hSm;
        if (localObject == null) {
          break label191;
        }
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).aBV();
        if ((localObject == null) || (((com.tencent.mm.live.core.core.b.g)localObject).aDt() != true)) {
          break label191;
        }
      }
      localObject = this.hVR;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.c.g)localObject).hOM.getSelectUser();
        if (localObject != null)
        {
          com.tencent.mm.live.b.r localr = com.tencent.mm.live.b.r.hIg;
          com.tencent.mm.live.b.r.aw(((a.a)localObject).hFz, ((a.a)localObject).hFG);
        }
      }
      label191:
      localObject = com.tencent.mm.live.b.r.hIg;
      com.tencent.mm.live.b.r.qS(1);
      aJm();
      com.tencent.mm.live.b.r.hIg.release();
      localObject = com.tencent.mm.live.b.m.hGg;
      com.tencent.mm.live.b.m.aFh();
      localObject = this.hSm;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.a)localObject).aBW();
      }
      localObject = com.tencent.mm.live.core.core.a.b.hyv;
      com.tencent.mm.live.core.core.a.b.a.releaseInstance();
      localObject = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.and();
      this.hWh.apm();
    }
    this.timerThread.stopTimer();
    AppMethodBeat.o(208531);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, kotlin.x>
  {
    a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "needFaceVerify", "verifyUrl", "", "errCode", "", "errMsg", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements s<Boolean, Boolean, String, Integer, String, kotlin.x>
  {
    b(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class c
    implements f.c
  {
    public static final c hWo;
    
    static
    {
      AppMethodBeat.i(208500);
      hWo = new c();
      AppMethodBeat.o(208500);
    }
    
    public final void e(boolean paramBoolean, String paramString) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(208501);
      b.b.a(this.hWk, b.c.hLD);
      AppMethodBeat.o(208501);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class f
    implements DialogInterface.OnDismissListener
  {
    f(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(208503);
      paramDialogInterface = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aHg();
      b.b.a(this.hWk, b.c.hLD);
      AppMethodBeat.o(208503);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class h
    implements DialogInterface.OnDismissListener
  {
    h(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(208505);
      paramDialogInterface = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aHg();
      b.b.a(this.hWk, b.c.hLD);
      AppMethodBeat.o(208505);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "xOffset", "", "yOffset", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Float, Float, kotlin.x>
  {
    j(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Float, Float, kotlin.x>
  {
    k(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "liveID", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Long, kotlin.x>
  {
    l(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements s<Boolean, Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, kotlin.x>
  {
    m(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/LiveAnchorPluginLayout$joinLive$1$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class a
      implements com.tencent.mm.live.core.core.c
    {
      a(LiveAnchorPluginLayout.m paramm) {}
      
      public final void callback(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(208511);
        Log.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish");
        if (paramInt >= 0)
        {
          b.b.a(this.hWs.hWk, b.c.hLB);
          paramBundle = com.tencent.mm.live.b.r.hIg;
          paramBundle = com.tencent.mm.live.b.x.hJf;
          com.tencent.mm.live.b.r.GO(com.tencent.mm.live.b.x.aGm());
          b.b.a(this.hWs.hWk, b.c.hMs);
          AppMethodBeat.o(208511);
          return;
        }
        Log.w("MicroMsg.LiveCoreAnchor", "enter room fail");
        com.tencent.mm.ui.base.u.makeText(this.hWs.hWk.getContext(), (CharSequence)"enter room fail", 0).show();
        b.b.a(this.hWs.hWk, b.c.hLy);
        paramBundle = new Bundle();
        paramBundle.putInt("live_user_exit_reason", paramInt);
        this.hWs.hWk.statusChange(b.c.hMr, paramBundle);
        AppMethodBeat.o(208511);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    n(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    public static final o hWu;
    
    static
    {
      AppMethodBeat.i(208516);
      hWu = new o();
      AppMethodBeat.o(208516);
    }
    
    public final void run()
    {
      AppMethodBeat.i(208515);
      Object localObject = com.tencent.mm.live.b.r.hIg;
      localObject = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.r.GO(com.tencent.mm.live.b.x.aGm());
      AppMethodBeat.o(208515);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class p
    implements com.tencent.mm.ak.i
  {
    p(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(208517);
      paramq.setHasCallbackToQueue(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
          AppMethodBeat.o(208517);
          throw paramString;
        }
        paramString = ((com.tencent.mm.live.b.a.b)paramq).aGr();
        if (paramString != null)
        {
          if (paramString.pSb != 0) {
            break label209;
          }
          paramString = com.tencent.mm.live.b.x.hJf;
          if (com.tencent.mm.live.b.x.aGD().hJn) {
            break label209;
          }
          paramString = LiveAnchorPluginLayout.f(this.hWk);
          if (paramString != null) {
            paramString.startPreview();
          }
          paramString = LiveAnchorPluginLayout.b(this.hWk);
          if (paramString != null)
          {
            paramString = paramString.aBV();
            if (paramString != null)
            {
              if (paramString.isNormalMode() != true) {
                break label209;
              }
              paramString = LiveAnchorPluginLayout.b(this.hWk);
              if (paramString == null) {
                break label203;
              }
              paramString = paramString.aBV();
              if (paramString == null) {
                break label203;
              }
              paramq = com.tencent.mm.live.b.x.hJf;
              if (paramString.b(Long.valueOf(com.tencent.mm.live.b.x.aGr().hyH)) != true) {
                break label209;
              }
              paramString = LiveAnchorPluginLayout.b(this.hWk);
              if (paramString == null) {
                break label209;
              }
              paramString.aBY();
              AppMethodBeat.o(208517);
            }
          }
        }
        else
        {
          AppMethodBeat.o(208517);
          return;
        }
        AppMethodBeat.o(208517);
        return;
        label203:
        AppMethodBeat.o(208517);
        return;
      }
      label209:
      AppMethodBeat.o(208517);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(208518);
      ae localae = LiveAnchorPluginLayout.a(this.hWk);
      if (localae != null)
      {
        localae.hwr.setVisibility(8);
        AppMethodBeat.o(208518);
        return;
      }
      AppMethodBeat.o(208518);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/LiveAnchorPluginLayout$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class r
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(208519);
      Log.i("MicroMsg.LiveCoreAnchor", "on exitRoom finish");
      AppMethodBeat.o(208519);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class s
    implements MTimerHandler.CallBack
  {
    s(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(208520);
      com.tencent.mm.live.c.o localo = LiveAnchorPluginLayout.p(this.hWk);
      Object localObject;
      if ((localo != null) && (localo.hwr.getVisibility() == 0))
      {
        localo = LiveAnchorPluginLayout.p(this.hWk);
        if (localo != null)
        {
          localObject = com.tencent.mm.live.b.x.hJf;
          i = com.tencent.mm.live.b.x.aGr().Gaz;
          if (com.tencent.mm.kernel.g.aAf().azp())
          {
            int j = cl.aWB();
            localObject = com.tencent.mm.live.b.u.hIn;
            localo.hPQ = u.a.a(j - i, ":", false, false, false, 28);
          }
        }
        localo = LiveAnchorPluginLayout.p(this.hWk);
        if (localo != null)
        {
          if (!localo.dMz) {
            break label180;
          }
          localObject = com.tencent.mm.live.core.core.a.b.hyv;
          localo.hwr.getContext();
        }
      }
      for (int i = com.tencent.mm.live.core.core.a.b.a.aDo().hAz.hzL;; i = com.tencent.mm.live.core.core.d.b.a.aEf().hAz.hzL)
      {
        localo.hPP = i;
        localo = LiveAnchorPluginLayout.p(this.hWk);
        if (localo != null)
        {
          localObject = com.tencent.mm.live.b.x.hJf;
          i = com.tencent.mm.live.b.x.aGr().LIa;
          localObject = com.tencent.mm.live.b.x.hJf;
          localo.db(i, com.tencent.mm.live.b.x.aGr().LXG);
        }
        AppMethodBeat.o(208520);
        return true;
        label180:
        localObject = com.tencent.mm.live.core.core.d.b.hCo;
        localo.hwr.getContext();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    t(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ret", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, kotlin.x>
  {
    u(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/LiveAnchorPluginLayout$tryResumeLive$2", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
  public static final class v
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(208524);
      Log.i("MicroMsg.LiveCoreAnchor", "try resume live on enterRoom finish");
      if (paramInt >= 0)
      {
        b.b.a(this.hWk, b.c.hLB);
        AppMethodBeat.o(208524);
        return;
      }
      Log.w("MicroMsg.LiveCoreAnchor", "try resume live senter room fail");
      com.tencent.mm.ui.base.u.makeText(this.hWk.getContext(), (CharSequence)"enter room fail", 0).show();
      b.b.a(this.hWk, b.c.hLy);
      AppMethodBeat.o(208524);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAnchorPluginLayout
 * JD-Core Version:    0.7.0.1
 */