package com.tencent.mm.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.ab;
import com.tencent.mm.live.b.ac;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.k;
import com.tencent.mm.live.b.n;
import com.tencent.mm.live.b.q;
import com.tencent.mm.live.b.t;
import com.tencent.mm.live.b.v;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.b.y;
import com.tencent.mm.live.b.z;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.core.core.model.i.b;
import com.tencent.mm.live.core.core.model.i.e;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.model.j;
import com.tencent.mm.live.model.l.a;
import com.tencent.mm.live.model.r.a;
import com.tencent.mm.live.model.u.b;
import com.tencent.mm.live.model.u.c;
import com.tencent.mm.live.model.u.d;
import com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView;
import com.tencent.mm.model.cn;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/LiveAnchorPluginLayout;", "Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "", "curStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "fromForcelockOrientation", "", "lastRotationFromSensor", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveAnchorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "liveAnchorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveAnchorMicPlugin;", "liveBanCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "liveBeforePlugin", "Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "liveReadyPlugin", "Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "liveRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveShareRoomsPlugin", "Lcom/tencent/mm/live/plugin/LiveShareRoomsPlugin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "nextStatus", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "pluginShow", "rotationEnable", "shareLiveRetryCount", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkClickArea", "x", "", "y", "validCallback", "checkInitStatus", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "checkVerify", "createNewLive", "liveName", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "handleErrForeigner", "handleJoinLiveFail", "errCode", "errMsg", "initLogic", "isFinished", "isLiving", "joinLive", "lockOrientation", "mount", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onOrientationChange", "orientation", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "orientationChanged", "pause", "refreshCamera", "resume", "start", "startLive", "liveId", "", "startTimer", "statusChange", "status", "stop", "stopLive", "stopTimer", "toggleShowPlugins", "tryResumeLive", "unMount", "updatePlugin", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveAnchorPluginLayout
  extends RoomBaseLivePluginLayout
  implements com.tencent.mm.am.h, com.tencent.mm.live.core.core.c, com.tencent.mm.plugin.mmsight.model.d.a
{
  private final String TAG;
  private int curNetworkQuality;
  private int lastRotationFromSensor;
  private kotlin.g.a.a<ah> liveMessageCallback;
  private com.tencent.mm.live.core.core.a.a njF;
  private y nmA;
  private com.tencent.mm.live.b.h nmB;
  private x nmC;
  private ab nmD;
  private t nmE;
  private n nmF;
  private com.tencent.mm.live.b.e nmG;
  private f nmH;
  private com.tencent.mm.live.b.i nmI;
  private v nmJ;
  private z nmK;
  private com.tencent.mm.live.b.r nmL;
  private com.tencent.mm.live.b.u nmM;
  private q nmN;
  private com.tencent.mm.live.b.s nmO;
  private com.tencent.mm.live.b.d nmP;
  private k nmQ;
  private b.c nmR;
  private b.c nmS;
  private final ArrayList<com.tencent.mm.live.b.a> nmT;
  private boolean nmU;
  private boolean nmV;
  private final com.tencent.mm.model.d nmW;
  private boolean nmX;
  private int nmY;
  private MTimerHandler nmZ;
  private ac nmv;
  private com.tencent.mm.live.b.l nmw;
  private com.tencent.mm.live.b.g nmx;
  private com.tencent.mm.live.b.c nmy;
  private com.tencent.mm.live.b.w nmz;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  
  public LiveAnchorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(246048);
    this.TAG = "MicroMsg.LiveAnchorPluginLayout";
    this.nmR = b.c.nch;
    this.nmS = b.c.nch;
    paramContext = e.o.mLz;
    this.curNetworkQuality = e.o.bdD();
    this.nmT = new ArrayList();
    this.nmU = true;
    this.nmW = new com.tencent.mm.model.d();
    this.lastRotationFromSensor = -1;
    this.liveMessageCallback = ((kotlin.g.a.a)new i(this));
    this.nmZ = new MTimerHandler("LiveCommonInfoPlugin::Timer", new LiveAnchorPluginLayout..ExternalSyntheticLambda4(this), true);
    AppMethodBeat.o(246048);
  }
  
  private static final void a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int i = 1;
    AppMethodBeat.i(246148);
    kotlin.g.b.s.u(paramLiveAnchorPluginLayout, "this$0");
    paramp.setHasCallbackToQueue(true);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramLiveAnchorPluginLayout = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
        AppMethodBeat.o(246148);
        throw paramLiveAnchorPluginLayout;
      }
      paramString = ((com.tencent.mm.live.model.a.b)paramp).bie();
      if ((paramString == null) || (paramString.end_time != 0)) {
        break label225;
      }
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        paramString = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nai)
        {
          paramString = paramLiveAnchorPluginLayout.nmz;
          if (paramString != null) {
            paramString.aPz();
          }
          paramString = paramLiveAnchorPluginLayout.nmz;
          if (paramString != null) {
            paramString.bjr();
          }
          paramString = paramLiveAnchorPluginLayout.njF;
          if (paramString == null) {
            break label230;
          }
          paramString = paramString.bch();
          if ((paramString == null) || (paramString.bep() != true)) {
            break label230;
          }
          paramInt1 = 1;
          label149:
          if (paramInt1 != 0)
          {
            paramString = paramLiveAnchorPluginLayout.njF;
            if (paramString == null) {
              break label235;
            }
            paramString = paramString.bch();
            if (paramString == null) {
              break label235;
            }
            paramp = com.tencent.mm.live.model.u.mZl;
            if (paramString.a(Long.valueOf(com.tencent.mm.live.model.u.bie().mMJ)) != true) {
              break label235;
            }
          }
        }
      }
    }
    label225:
    label230:
    label235:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        paramLiveAnchorPluginLayout = paramLiveAnchorPluginLayout.njF;
        if (paramLiveAnchorPluginLayout != null) {
          paramLiveAnchorPluginLayout.bcj();
        }
      }
      AppMethodBeat.o(246148);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break label149;
    }
  }
  
  private static final void a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(246119);
    kotlin.g.b.s.u(paramLiveAnchorPluginLayout, "this$0");
    paramDialogInterface = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.biT();
    b.b.a((com.tencent.mm.live.b.b)paramLiveAnchorPluginLayout, b.c.ncl);
    AppMethodBeat.o(246119);
  }
  
  private static final boolean a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
  {
    AppMethodBeat.i(246097);
    kotlin.g.b.s.u(paramLiveAnchorPluginLayout, "this$0");
    Object localObject1 = paramLiveAnchorPluginLayout.nmI;
    Object localObject2;
    if ((localObject1 != null) && (((com.tencent.mm.live.b.a)localObject1).mJe.getVisibility() == 0))
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = paramLiveAnchorPluginLayout.nmI;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.live.model.u.mZl;
          i = com.tencent.mm.live.model.u.bie().HTK;
          if (com.tencent.mm.kernel.h.baC().aZN())
          {
            int j = cn.getSyncServerTimeSecond();
            localObject2 = com.tencent.mm.live.model.r.mZi;
            ((com.tencent.mm.live.b.i)localObject1).nhA = r.a.a(j - i, ":", false, false, false, 28);
          }
        }
        localObject1 = paramLiveAnchorPluginLayout.nmI;
        if (localObject1 != null)
        {
          if (!((com.tencent.mm.live.b.i)localObject1).hKC) {
            break label179;
          }
          localObject2 = com.tencent.mm.live.core.core.a.b.mMo;
        }
      }
    }
    for (int i = com.tencent.mm.live.core.core.a.b.a.bej().mRB.mNT;; i = com.tencent.mm.live.core.core.f.d.a.bfM().mRB.mNT)
    {
      ((com.tencent.mm.live.b.i)localObject1).nhz = i;
      paramLiveAnchorPluginLayout = paramLiveAnchorPluginLayout.nmI;
      if (paramLiveAnchorPluginLayout != null)
      {
        localObject1 = com.tencent.mm.live.model.u.mZl;
        i = com.tencent.mm.live.model.u.bie().ZWw;
        localObject1 = com.tencent.mm.live.model.u.mZl;
        paramLiveAnchorPluginLayout.eo(i, com.tencent.mm.live.model.u.bie().aaun);
      }
      AppMethodBeat.o(246097);
      return true;
      i = 0;
      break;
      label179:
      localObject2 = com.tencent.mm.live.core.core.f.d.mUj;
    }
  }
  
  private static final void b(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
  {
    AppMethodBeat.i(246102);
    kotlin.g.b.s.u(paramLiveAnchorPluginLayout, "this$0");
    paramLiveAnchorPluginLayout = paramLiveAnchorPluginLayout.nmL;
    if (paramLiveAnchorPluginLayout != null) {
      paramLiveAnchorPluginLayout.mJe.setVisibility(8);
    }
    AppMethodBeat.o(246102);
  }
  
  private static final void b(LiveAnchorPluginLayout paramLiveAnchorPluginLayout, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(246131);
    kotlin.g.b.s.u(paramLiveAnchorPluginLayout, "this$0");
    paramDialogInterface = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.biT();
    b.b.a((com.tencent.mm.live.b.b)paramLiveAnchorPluginLayout, b.c.ncl);
    AppMethodBeat.o(246131);
  }
  
  private final void bkX()
  {
    AppMethodBeat.i(246064);
    Log.i("MicroMsg.LiveCoreAnchor", "stopLive");
    com.tencent.mm.live.core.core.a.a locala = this.njF;
    if (locala != null) {
      locala.b((com.tencent.mm.live.core.core.c)new LiveAnchorPluginLayout.j());
    }
    AppMethodBeat.o(246064);
  }
  
  private final void bkY()
  {
    AppMethodBeat.i(246078);
    g.a locala = new g.a(getContext());
    locala.Xdm = true;
    locala.bf((CharSequence)getContext().getResources().getString(b.h.live_create_tip_foreigner)).aEX(b.h.app_i_know).b(LiveAnchorPluginLayout..ExternalSyntheticLambda6.INSTANCE).d(new LiveAnchorPluginLayout..ExternalSyntheticLambda1(this)).show();
    AppMethodBeat.o(246078);
  }
  
  private final boolean bkZ()
  {
    AppMethodBeat.i(246087);
    Object localObject = com.tencent.mm.live.model.u.mZl;
    if (com.tencent.mm.live.model.u.biq().naj)
    {
      localObject = com.tencent.mm.live.model.c.a.nbR;
      localObject = com.tencent.mm.live.model.c.a.biZ();
      if ((((dig)localObject).rotation != -1) && (((dig)localObject).rotation != getCurrentOrientation()))
      {
        AppMethodBeat.o(246087);
        return true;
      }
      AppMethodBeat.o(246087);
      return false;
    }
    localObject = com.tencent.mm.live.model.u.mZl;
    if (com.tencent.mm.live.model.u.getLastOrientation() != -1)
    {
      localObject = com.tencent.mm.live.model.u.mZl;
      if (com.tencent.mm.live.model.u.getLastOrientation() != getCurrentOrientation())
      {
        AppMethodBeat.o(246087);
        return true;
      }
    }
    AppMethodBeat.o(246087);
    return false;
  }
  
  private static final void bla()
  {
    AppMethodBeat.i(246110);
    Object localObject = com.tencent.mm.live.model.o.mZb;
    localObject = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.o.Gm(com.tencent.mm.live.model.u.bhZ());
    AppMethodBeat.o(246110);
  }
  
  private static final void c(LiveAnchorPluginLayout paramLiveAnchorPluginLayout, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(246140);
    kotlin.g.b.s.u(paramLiveAnchorPluginLayout, "this$0");
    b.b.a((com.tencent.mm.live.b.b)paramLiveAnchorPluginLayout, b.c.ncl);
    AppMethodBeat.o(246140);
  }
  
  private static final void s(boolean paramBoolean, String paramString) {}
  
  private final void startTimer()
  {
    AppMethodBeat.i(246057);
    this.nmZ.stopTimer();
    this.nmZ.startTimer(1000L);
    AppMethodBeat.o(246057);
  }
  
  private static final void t(boolean paramBoolean, String paramString) {}
  
  private static final void u(boolean paramBoolean, String paramString) {}
  
  public final void callback(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    String str = null;
    Object localObject1 = null;
    int j = 1;
    int k = 1;
    int m = 1;
    int i = 0;
    AppMethodBeat.i(246638);
    e.g localg = e.g.mKv;
    if (paramInt == e.g.bcH())
    {
      b.b.a((com.tencent.mm.live.b.b)this, b.c.ncG);
      paramBundle = this.nmG;
      if (paramBundle != null)
      {
        paramBundle.bjf();
        AppMethodBeat.o(246638);
      }
    }
    else
    {
      localg = e.g.mKv;
      if (paramInt == e.g.bcM())
      {
        paramBundle = this.njF;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.bch();
          if ((paramBundle == null) || (paramBundle.bet() != true)) {}
        }
        for (paramInt = m; paramInt != 0; paramInt = 0)
        {
          paramBundle = this.njF;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.bch();
            if (paramBundle != null) {
              paramBundle.mNH = i.b.mNV;
            }
          }
          paramBundle = this.nmG;
          if (paramBundle == null) {
            break;
          }
          paramBundle.bje();
          AppMethodBeat.o(246638);
          return;
        }
      }
      localg = e.g.mKv;
      if (paramInt == e.g.bcI())
      {
        if (paramBundle != null)
        {
          str = paramBundle.getString("live_user_id");
          paramBundle.getString("live_user_exit_reason");
          localObject2 = this.TAG;
          localObject3 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append(str).append(" micUid:");
          paramBundle = com.tencent.mm.live.model.u.mZl;
          paramBundle = com.tencent.mm.live.model.u.biN().nbN;
          if (paramBundle == null)
          {
            paramBundle = null;
            Log.i((String)localObject2, paramBundle);
            paramBundle = com.tencent.mm.live.model.u.mZl;
            paramBundle = com.tencent.mm.live.model.u.biN().nbN;
            if (paramBundle != null) {
              break label353;
            }
          }
          label353:
          for (paramBundle = (Bundle)localObject1;; paramBundle = paramBundle.mXH)
          {
            if (kotlin.g.b.s.p(str, paramBundle))
            {
              b.b.a((com.tencent.mm.live.b.b)this, b.c.ncs);
              paramBundle = com.tencent.mm.live.model.u.mZl;
              paramBundle = com.tencent.mm.live.model.u.biN().nbN;
              if (paramBundle != null)
              {
                localObject1 = com.tencent.mm.live.model.u.mZl;
                com.tencent.mm.live.model.u.biN().a(paramBundle.liveId, paramBundle.mXK, paramBundle.mXx);
              }
            }
            AppMethodBeat.o(246638);
            return;
            paramBundle = paramBundle.mXH;
            break;
          }
        }
      }
      else
      {
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcJ())
        {
          if (paramBundle != null)
          {
            localObject1 = paramBundle.getString("live_user_id");
            boolean bool = paramBundle.getBoolean("live_media_enable");
            paramBundle = com.tencent.mm.live.model.u.mZl;
            paramBundle = com.tencent.mm.live.model.u.biN().nbN;
            if (paramBundle == null) {
              paramBundle = (Bundle)localObject2;
            }
            while (kotlin.g.b.s.p(localObject1, paramBundle)) {
              if (bool)
              {
                b.b.a((com.tencent.mm.live.b.b)this, b.c.ncp);
                AppMethodBeat.o(246638);
                return;
                paramBundle = paramBundle.mXH;
              }
              else
              {
                paramBundle = this.nmG;
                if (paramBundle != null) {
                  LiveAnchorMicUserListView.a(paramBundle.ngz);
                }
              }
            }
            AppMethodBeat.o(246638);
          }
        }
        else
        {
          localObject1 = e.g.mKv;
          if (paramInt == e.g.bcK())
          {
            i = this.curNetworkQuality;
            paramBundle = this.njF;
            if (paramBundle == null)
            {
              paramBundle = (Bundle)localObject3;
              if (paramBundle != null) {
                break label625;
              }
              paramBundle = e.o.mLz;
              paramInt = e.o.bdD();
              label516:
              this.curNetworkQuality = paramInt;
              paramBundle = e.o.mLz;
              if (i == e.o.bdF()) {
                break label633;
              }
              paramInt = this.curNetworkQuality;
              paramBundle = e.o.mLz;
              if (paramInt != e.o.bdF()) {
                break label633;
              }
              b.b.a((com.tencent.mm.live.b.b)this, b.c.ncZ);
              paramBundle = this.nmz;
              if (paramBundle != null) {
                paramBundle.pause();
              }
            }
            for (;;)
            {
              paramInt = this.curNetworkQuality;
              paramBundle = e.o.mLz;
              if (paramInt != e.o.bdC()) {
                break label693;
              }
              com.tencent.mm.live.core.c.a.bgL();
              AppMethodBeat.o(246638);
              return;
              localObject1 = paramBundle.bch();
              paramBundle = (Bundle)localObject3;
              if (localObject1 == null) {
                break;
              }
              paramBundle = Integer.valueOf(((com.tencent.mm.live.core.core.model.i)localObject1).mNT);
              break;
              label625:
              paramInt = paramBundle.intValue();
              break label516;
              label633:
              paramBundle = e.o.mLz;
              if (i == e.o.bdF())
              {
                paramInt = this.curNetworkQuality;
                paramBundle = e.o.mLz;
                if (paramInt != e.o.bdF())
                {
                  b.b.a((com.tencent.mm.live.b.b)this, b.c.nda);
                  paramBundle = this.nmz;
                  if (paramBundle != null) {
                    paramBundle.resume();
                  }
                  paramBundle = com.tencent.mm.live.model.o.mZb;
                  com.tencent.mm.live.model.o.bhM();
                }
              }
            }
            label693:
            paramBundle = e.o.mLz;
            if (paramInt == e.o.bdD())
            {
              com.tencent.mm.live.core.c.a.bgM();
              AppMethodBeat.o(246638);
              return;
            }
            paramBundle = e.o.mLz;
            if (paramInt == e.o.bdE())
            {
              com.tencent.mm.live.core.c.a.bgN();
              AppMethodBeat.o(246638);
              return;
            }
            paramBundle = e.o.mLz;
            if (paramInt == e.o.bdF())
            {
              com.tencent.mm.live.core.c.a.bgO();
              AppMethodBeat.o(246638);
            }
          }
          else
          {
            localObject1 = e.g.mKv;
            label805:
            long l;
            if (paramInt == e.g.bcL())
            {
              paramBundle = this.njF;
              if (paramBundle != null)
              {
                paramBundle = paramBundle.bch();
                if ((paramBundle != null) && (paramBundle.beu() == true))
                {
                  i = 1;
                  if (i == 0) {
                    break label876;
                  }
                  i = j;
                  paramBundle = com.tencent.mm.live.model.u.mZl;
                  str = com.tencent.mm.live.model.u.bhZ();
                  paramBundle = com.tencent.mm.live.model.u.mZl;
                  l = com.tencent.mm.live.model.u.bie().mMJ;
                  paramBundle = com.tencent.mm.live.model.u.mZl;
                  paramBundle = com.tencent.mm.live.model.u.biN().nbN;
                  if (paramBundle != null) {
                    break label926;
                  }
                  paramBundle = "";
                }
              }
              for (;;)
              {
                localObject1 = com.tencent.mm.live.model.u.mZl;
                com.tencent.mm.live.c.e.b(str, l, paramBundle, com.tencent.mm.live.model.u.big(), i, 0, paramInt);
                AppMethodBeat.o(246638);
                return;
                i = 0;
                break;
                label876:
                paramBundle = this.njF;
                if (paramBundle != null)
                {
                  paramBundle = paramBundle.bch();
                  if ((paramBundle == null) || (paramBundle.bet() != true)) {}
                }
                for (i = k;; i = 0)
                {
                  if (i == 0) {
                    break label921;
                  }
                  i = 2;
                  break;
                }
                label921:
                i = 0;
                break label805;
                label926:
                localObject1 = paramBundle.mXx;
                paramBundle = (Bundle)localObject1;
                if (localObject1 == null) {
                  paramBundle = "";
                }
              }
            }
            localObject1 = e.g.mKv;
            if (paramInt == e.g.bcN())
            {
              paramBundle = com.tencent.mm.live.model.u.mZl;
              l = com.tencent.mm.live.model.u.bie().mMJ;
              paramBundle = com.tencent.mm.live.model.u.mZl;
              paramBundle = com.tencent.mm.live.model.u.bhZ();
              localObject1 = com.tencent.mm.live.model.u.mZl;
              localObject1 = com.tencent.mm.live.model.u.bie().Zqd;
              kotlin.g.b.s.s(localObject1, "RoomLiveService.liveInfo.live_name");
              new com.tencent.mm.live.model.h(l, paramBundle, (String)localObject1, (byte)0).a((kotlin.g.a.r)new b(this));
              AppMethodBeat.o(246638);
              return;
            }
            localObject1 = e.g.mKv;
            label1154:
            if (paramInt == e.g.bcO())
            {
              localObject3 = this.TAG;
              if (paramBundle != null) {
                break label1199;
              }
              localObject1 = "";
              Log.i((String)localObject3, kotlin.g.b.s.X("EVENT_RENDER_FIRST_I_FRAME, userId:", localObject1));
              if (paramBundle != null) {
                break label1225;
              }
              localObject1 = str;
              label1082:
              if (!Util.isNullOrNil((String)localObject1))
              {
                localObject1 = com.tencent.mm.live.model.u.mZl;
                localObject2 = com.tencent.mm.live.model.u.bit();
                if (paramBundle != null) {
                  break label1237;
                }
                localObject1 = "";
                label1109:
                ((u.c)localObject2).setUserId((String)localObject1);
                localObject1 = com.tencent.mm.live.model.u.mZl;
                localObject1 = com.tencent.mm.live.model.u.bit();
                if (paramBundle != null) {
                  break label1263;
                }
                paramInt = 0;
                label1132:
                ((u.c)localObject1).streamType = paramInt;
                localObject1 = com.tencent.mm.live.model.u.mZl;
                localObject1 = com.tencent.mm.live.model.u.bit();
                if (paramBundle != null) {
                  break label1274;
                }
                paramInt = 0;
                ((u.c)localObject1).width = paramInt;
                localObject1 = com.tencent.mm.live.model.u.mZl;
                localObject1 = com.tencent.mm.live.model.u.bit();
                if (paramBundle != null) {
                  break label1285;
                }
              }
            }
          }
        }
      }
    }
    label1285:
    for (paramInt = i;; paramInt = paramBundle.getInt("live_first_frame_height"))
    {
      ((u.c)localObject1).height = paramInt;
      b.b.a((com.tencent.mm.live.b.b)this, b.c.ndj);
      AppMethodBeat.o(246638);
      return;
      label1199:
      localObject2 = paramBundle.getString("live_user_id");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label1225:
      localObject1 = paramBundle.getString("live_user_id");
      break label1082;
      label1237:
      str = paramBundle.getString("live_user_id");
      localObject1 = str;
      if (str != null) {
        break label1109;
      }
      localObject1 = "";
      break label1109;
      label1263:
      paramInt = paramBundle.getInt("live_stream_type");
      break label1132;
      label1274:
      paramInt = paramBundle.getInt("live_first_frame_width");
      break label1154;
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
  
  public final void initLogic(LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(246502);
    kotlin.g.b.s.u(paramLiveConfig, "config");
    this.nmX = false;
    this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(getContext(), (byte)0);
    Object localObject1 = com.tencent.mm.live.core.core.a.b.mMo;
    this.njF = ((com.tencent.mm.live.core.core.a.a)com.tencent.mm.live.core.core.a.b.a.bej());
    localObject1 = this.njF;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = getContext();
      kotlin.g.b.s.s(localObject2, "context");
      ((com.tencent.mm.live.core.core.a.a)localObject1).a((AbsLiveMiniView)new RoomLiveMiniView((Context)localObject2));
    }
    localObject1 = this.njF;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.a.a)localObject1).c((com.tencent.mm.live.core.core.c)this);
    }
    com.tencent.mm.live.model.o.mZb.release();
    if (paramLiveConfig.liveId != 0L)
    {
      localObject1 = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.bie().mMJ = paramLiveConfig.liveId;
    }
    if (!Util.isNullOrNil(paramLiveConfig.mIz))
    {
      localObject1 = com.tencent.mm.live.model.u.mZl;
      localObject1 = paramLiveConfig.mIz;
      kotlin.g.b.s.s(localObject1, "config.hostRoomId");
      com.tencent.mm.live.model.u.Go((String)localObject1);
    }
    localObject1 = com.tencent.mm.live.model.u.mZl;
    localObject1 = paramLiveConfig.mIC;
    kotlin.g.b.s.s(localObject1, "config.anchorUsername");
    com.tencent.mm.live.model.u.Gq((String)localObject1);
    localObject1 = findViewById(b.e.live_verify_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_verify_ui_root)");
    this.nmv = new ac((RelativeLayout)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_face_verify_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_face_verify_ui_root)");
    this.nmw = new com.tencent.mm.live.b.l((RelativeLayout)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_before_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_before_ui_root)");
    this.nmx = new com.tencent.mm.live.b.g((RelativeLayout)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_after_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_after_ui_root)");
    this.nmy = new com.tencent.mm.live.b.c((RelativeLayout)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_preview_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_preview_ui_root)");
    this.nmz = new com.tencent.mm.live.b.w((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_shadow_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_shadow_ui_root)");
    this.nmA = new y((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_comment_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_comment_ui_root)");
    this.nmB = new com.tencent.mm.live.b.h((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_ready_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_ready_ui_root)");
    this.nmC = new x((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_title_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_title_ui_root)");
    this.nmD = new ab((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_right_panel_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_right_panel_ui_root)");
    this.nmF = new n((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_right_panel_btn4_parent);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_right_panel_btn4_parent)");
    this.nmG = new com.tencent.mm.live.b.e((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_members_list_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_members_list_ui_root)");
    this.nmE = new t((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_ban_comment_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_ban_comment_ui_root)");
    this.nmH = new f((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_common_info_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_common_info_ui_root)");
    this.nmI = new com.tencent.mm.live.b.i((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_minimize_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_minimize_ui_root)");
    this.nmJ = new v((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_share_rooms_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_share_rooms_ui_root)");
    this.nmK = new z((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_loading_view_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_loading_view_root)");
    this.nmL = new com.tencent.mm.live.b.r((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_mic_visitor_header_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_mic_visitor_header_root)");
    this.nmM = new com.tencent.mm.live.b.u((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_like_confetti_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_like_confetti_ui_root)");
    this.nmN = new q((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_members_profile_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_members_profile_ui_root)");
    this.nmO = new com.tencent.mm.live.b.s((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_anchor_close_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_anchor_close_ui_root)");
    this.nmP = new com.tencent.mm.live.b.d((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_exception_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_exception_ui_root)");
    this.nmQ = new k((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = this.nmz;
    if (localObject1 != null)
    {
      localObject2 = (m)new e(this);
      ((com.tencent.mm.live.b.w)localObject1).mRt.setPreviewMoveListener((m)localObject2);
    }
    localObject1 = com.tencent.mm.live.model.o.mZb;
    com.tencent.mm.live.model.o.a(paramLiveConfig);
    localObject1 = this.nmF;
    if (localObject1 != null) {
      ((n)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.nmE;
    if (localObject1 != null) {
      ((t)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.nmy;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.c)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.nmB;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.h)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.nmN;
    if (localObject1 != null) {
      ((q)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.nmy;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.c)localObject1).bjc();
    }
    localObject1 = this.nmO;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.s)localObject1).a(paramLiveConfig);
    }
    localObject1 = this.nmI;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.i)localObject1).bjl();
    }
    localObject1 = this.nmP;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.d)localObject1).tO(8);
    }
    localObject1 = this.nmv;
    if (localObject1 != null) {
      ((ac)localObject1).tO(8);
    }
    localObject1 = this.nmw;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.l)localObject1).tO(8);
    }
    localObject1 = this.nmx;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.g)localObject1).tO(0);
    }
    localObject1 = this.nmz;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.w)localObject1).tO(0);
    }
    localObject1 = this.nmA;
    if (localObject1 != null) {
      ((y)localObject1).tO(8);
    }
    localObject1 = this.nmy;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.c)localObject1).tO(4);
    }
    localObject1 = this.nmB;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.h)localObject1).tO(8);
    }
    localObject1 = this.nmC;
    if (localObject1 != null) {
      ((x)localObject1).tO(8);
    }
    localObject1 = this.nmD;
    if (localObject1 != null) {
      ((ab)localObject1).tO(8);
    }
    localObject1 = this.nmE;
    if (localObject1 != null) {
      ((t)localObject1).tO(8);
    }
    localObject1 = this.nmF;
    if (localObject1 != null) {
      ((n)localObject1).tO(8);
    }
    localObject1 = this.nmH;
    if (localObject1 != null) {
      ((f)localObject1).tO(8);
    }
    localObject1 = this.nmI;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.i)localObject1).tO(8);
    }
    localObject1 = this.nmJ;
    if (localObject1 != null) {
      ((v)localObject1).tO(8);
    }
    localObject1 = this.nmK;
    if (localObject1 != null) {
      ((z)localObject1).tO(8);
    }
    localObject1 = this.nmL;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.live.model.u.mZl;
      ((com.tencent.mm.live.b.r)localObject1).GA(com.tencent.mm.live.model.u.big());
    }
    localObject1 = this.nmO;
    if (localObject1 != null) {
      ((com.tencent.mm.live.b.s)localObject1).tO(8);
    }
    localObject1 = this.nmQ;
    if (localObject1 != null) {
      ((k)localObject1).tO(8);
    }
    localObject1 = this.nmz;
    if (localObject1 != null)
    {
      localObject2 = (m)new f(this);
      ((com.tencent.mm.live.b.w)localObject1).mRt.setPreviewTouchListener((m)localObject2);
    }
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.bie().Zqd = paramLiveConfig.mIA;
      localObject1 = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.bie().mMJ = paramLiveConfig.liveId;
      localObject1 = com.tencent.mm.live.model.u.mZl;
      paramLiveConfig = paramLiveConfig.mIz;
      kotlin.g.b.s.s(paramLiveConfig, "config.hostRoomId");
      com.tencent.mm.live.model.u.Go(paramLiveConfig);
      b.b.a((com.tencent.mm.live.b.b)this, b.c.ncD);
      paramLiveConfig = this.orientationEventListener;
      if (paramLiveConfig != null) {
        paramLiveConfig.KUU = null;
      }
      paramLiveConfig = this.orientationEventListener;
      if (paramLiveConfig != null) {
        paramLiveConfig.disable();
      }
      this.orientationEventListener = null;
    }
    for (;;)
    {
      paramLiveConfig = j.mXT;
      j.g(name(), this.liveMessageCallback);
      paramLiveConfig = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.biN().nbH = ((kotlin.g.a.b)new g(this));
      AppMethodBeat.o(246502);
      return;
      localObject1 = com.tencent.mm.live.model.u.mZl;
      localObject1 = com.tencent.mm.live.model.u.bie();
      if ((localObject1 != null) && (((dio)localObject1).mMJ == 0L))
      {
        i = 1;
        label1740:
        if (i != 0) {
          break label1952;
        }
        localObject1 = com.tencent.mm.live.model.u.mZl;
        if (Util.isNullOrNil(com.tencent.mm.live.model.u.bhZ())) {
          break label1952;
        }
        localObject2 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("init anchor plugin with live data, liveId:");
        localObject1 = com.tencent.mm.live.model.u.mZl;
        localObject1 = com.tencent.mm.live.model.u.bie();
        if (localObject1 != null) {
          break label1939;
        }
        localObject1 = null;
        label1794:
        Log.i((String)localObject2, localObject1 + ", liveName:" + paramLiveConfig.mIA + ", roomId:" + paramLiveConfig.mIz);
        localObject2 = this.nmD;
        if (localObject2 != null)
        {
          paramLiveConfig = com.tencent.mm.live.model.u.mZl;
          localObject1 = com.tencent.mm.live.model.u.bie().Zqd;
          paramLiveConfig = (LiveConfig)localObject1;
          if (localObject1 == null) {
            paramLiveConfig = "";
          }
          paramLiveConfig = (CharSequence)paramLiveConfig;
          localObject1 = com.tencent.mm.live.model.u.mZl;
          ((ab)localObject2).a(paramLiveConfig, com.tencent.mm.live.model.u.big());
        }
        this.nmS = b.c.ndi;
        label1896:
        if ((this.nmv == null) || (ac.bjw() != true)) {
          break label1983;
        }
      }
      label1939:
      label1952:
      label1983:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label1988;
        }
        statusChange(this.nmS, new Bundle());
        break;
        i = 0;
        break label1740;
        localObject1 = Long.valueOf(((dio)localObject1).mMJ);
        break label1794;
        Log.i(this.TAG, "init logic from directly start");
        paramLiveConfig = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.bie().mMJ = 0L;
        this.nmS = b.c.nch;
        break label1896;
      }
      label1988:
      paramLiveConfig = this.nmv;
      if (paramLiveConfig != null) {
        paramLiveConfig.tO(0);
      }
      paramLiveConfig = this.nmw;
      if (paramLiveConfig != null) {
        paramLiveConfig.tO(8);
      }
      paramLiveConfig = this.nmy;
      if (paramLiveConfig != null) {
        paramLiveConfig.tO(4);
      }
      paramLiveConfig = this.nmB;
      if (paramLiveConfig != null) {
        paramLiveConfig.tO(8);
      }
      paramLiveConfig = this.nmF;
      if (paramLiveConfig != null) {
        paramLiveConfig.tO(8);
      }
      paramLiveConfig = this.nmD;
      if (paramLiveConfig != null) {
        paramLiveConfig.tO(8);
      }
      paramLiveConfig = this.nmA;
      if (paramLiveConfig != null) {
        paramLiveConfig.tO(8);
      }
      paramLiveConfig = this.nmH;
      if (paramLiveConfig != null) {
        paramLiveConfig.tO(8);
      }
      paramLiveConfig = this.nmL;
      if (paramLiveConfig != null) {
        paramLiveConfig.tO(8);
      }
      statusChange(b.c.ncd, new Bundle());
    }
  }
  
  public final boolean isLiving()
  {
    AppMethodBeat.i(246542);
    Object localObject = this.njF;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.a.a)localObject).bch();
      if ((localObject != null) && (((com.tencent.mm.live.core.core.model.i)localObject).isLiving() == true))
      {
        AppMethodBeat.o(246542);
        return true;
      }
    }
    AppMethodBeat.o(246542);
    return false;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(246546);
    super.mount();
    com.tencent.mm.kernel.h.baD().mCm.a(3806, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(3559, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(3557, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(246546);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(246576);
    boolean bool2 = super.onBackPress();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
      bool1 = bool2;
      if (!com.tencent.mm.live.model.u.biq().nak)
      {
        localu = com.tencent.mm.live.model.u.mZl;
        bool1 = bool2;
        if (com.tencent.mm.live.model.u.biq().naj)
        {
          b.b.a((com.tencent.mm.live.b.b)this, b.c.nck);
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(246576);
    return bool1;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    com.tencent.mm.live.model.u localu = null;
    int i = 1;
    AppMethodBeat.i(246515);
    kotlin.g.b.s.u(paramString, "incomingNumber");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.njF;
    if (paramString == null)
    {
      paramString = localu;
      Log.i(str, paramString);
      switch (paramInt)
      {
      }
    }
    label356:
    for (;;)
    {
      AppMethodBeat.o(246515);
      return;
      com.tencent.mm.live.core.core.model.i locali = paramString.bch();
      paramString = localu;
      if (locali == null) {
        break;
      }
      paramString = Boolean.valueOf(locali.isFloatMode());
      break;
      AppMethodBeat.o(246515);
      return;
      paramString = com.tencent.mm.live.model.o.mZb;
      com.tencent.mm.live.model.o.tB(2);
      paramString = this.njF;
      if (paramString != null)
      {
        paramString = paramString.bch();
        if ((paramString == null) || (paramString.isFloatMode() != true)) {}
      }
      for (paramInt = i; paramInt != 0; paramInt = 0)
      {
        paramString = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.bil();
        paramString = this.njF;
        if (paramString != null) {
          paramString.bce();
        }
        paramString = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.biV();
        AppMethodBeat.o(246515);
        return;
      }
      paramString = this.njF;
      if (paramString != null) {
        paramString.bce();
      }
      paramString = this.njF;
      if (paramString != null)
      {
        paramString.stopPush();
        AppMethodBeat.o(246515);
        return;
        paramString = com.tencent.mm.live.model.o.mZb;
        com.tencent.mm.live.model.o.tB(0);
        paramString = this.njF;
        if (paramString != null)
        {
          paramString = paramString.bch();
          if (paramString != null)
          {
            localu = com.tencent.mm.live.model.u.mZl;
            if (paramString.a(Long.valueOf(com.tencent.mm.live.model.u.bie().mMJ)) != true) {}
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label356;
          }
          paramString = this.nmz;
          if (paramString != null) {
            paramString.aPz();
          }
          paramString = this.njF;
          if (paramString == null) {
            break;
          }
          paramString.bcj();
          break;
        }
      }
    }
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(246620);
    if ((this.lastRotationFromSensor == -1) || (this.lastRotationFromSensor != paramInt))
    {
      Log.i(this.TAG, kotlin.g.b.s.X("onOrientationChange orientation:", Integer.valueOf(paramInt)));
      this.lastRotationFromSensor = paramInt;
      Log.i(this.TAG, "refreshCamera");
      com.tencent.mm.live.core.core.a.a locala = this.njF;
      if (locala != null) {
        locala.bcf();
      }
    }
    AppMethodBeat.o(246620);
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean)
  {
    this.nmV = paramBoolean;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(246591);
    Log.i(this.TAG, "errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramp instanceof com.tencent.mm.live.model.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nai)
        {
          paramString = com.tencent.mm.live.model.u.mZl;
          if (!com.tencent.mm.live.model.u.biq().nak) {}
        }
        else
        {
          AppMethodBeat.o(246591);
          return;
        }
        paramString = this.nmH;
        if (paramString != null)
        {
          paramp = com.tencent.mm.live.model.u.mZl;
          paramString.ngI = com.tencent.mm.live.model.u.bie().YLD;
        }
        paramString = this.nmH;
        if (paramString != null) {
          paramString.bjg();
        }
        paramString = com.tencent.mm.live.model.u.mZl;
        paramString = com.tencent.mm.live.model.u.mZl;
        paramInt1 = i;
        if (!com.tencent.mm.live.model.u.bie().YLD) {
          paramInt1 = cn.getSyncServerTimeSecond();
        }
        com.tencent.mm.live.model.u.tC(paramInt1);
        paramString = com.tencent.mm.live.model.u.mZl;
        if (com.tencent.mm.live.model.u.bie().end_time > 0) {
          b.b.a((com.tencent.mm.live.b.b)this, b.c.ncD);
        }
        AppMethodBeat.o(246591);
      }
    }
    else if ((paramp instanceof com.tencent.mm.live.model.a.p))
    {
      paramString = this.nmE;
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
        paramp = paramString.njn;
        if (paramp != null) {
          paramp.dismiss();
        }
        if (i != 0)
        {
          aa.db(paramString.mJe.getContext(), paramString.mJe.getContext().getResources().getString(b.h.live_member_kick_tip_kicked));
          AppMethodBeat.o(246591);
          return;
        }
        aa.dc(paramString.mJe.getContext(), paramString.mJe.getContext().getResources().getString(b.h.live_member_kick_tip_kick_fail));
        AppMethodBeat.o(246591);
      }
    }
    else if (((paramp instanceof com.tencent.mm.live.model.a.u)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      paramInt1 = this.nmY;
      paramString = com.tencent.mm.live.model.l.mYb;
      if (paramInt1 < com.tencent.mm.live.model.l.bhm())
      {
        this.nmY += 1;
        Log.i(this.TAG, kotlin.g.b.s.X("will retry share live, delay:", Long.valueOf(this.nmY * 1000L)));
        postDelayed(LiveAnchorPluginLayout..ExternalSyntheticLambda9.INSTANCE, this.nmY * 1000L);
      }
    }
    AppMethodBeat.o(246591);
  }
  
  public final void pause()
  {
    int i = 1;
    AppMethodBeat.i(246615);
    super.pause();
    boolean bool = bkZ();
    Log.i(this.TAG, "pause orientationChanged:" + bool + ", currentOrientation:" + getCurrentOrientation());
    Object localObject;
    if (!bool)
    {
      localObject = com.tencent.mm.live.model.u.mZl;
      if (!com.tencent.mm.live.model.u.biq().nak)
      {
        localObject = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nai)
        {
          localObject = com.tencent.mm.live.model.u.mZl;
          if (!com.tencent.mm.live.model.u.biq().nal)
          {
            localObject = com.tencent.mm.live.model.u.mZl;
            if (com.tencent.mm.live.model.u.biq().naj)
            {
              localObject = com.tencent.mm.live.model.u.mZl;
              if ((!com.tencent.mm.live.model.u.isManualClosed()) && (!this.nmX) && (com.tencent.mm.compatible.e.b.dh(getContext())))
              {
                localObject = new Bundle();
                ((Bundle)localObject).putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 3);
                statusChange(b.c.ncx, (Bundle)localObject);
              }
            }
          }
        }
      }
    }
    label277:
    for (;;)
    {
      localObject = this.orientationEventListener;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
      }
      localObject = this.orientationEventListener;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).KUU = null;
      }
      this.orientationEventListener = null;
      AppMethodBeat.o(246615);
      return;
      localObject = this.njF;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).bch();
        if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).bep() != true)) {}
      }
      for (;;)
      {
        if ((i == 0) || (this.nmX)) {
          break label277;
        }
        localObject = this.njF;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.a.a)localObject).bce();
        }
        localObject = this.njF;
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.live.core.core.a.a)localObject).stopPush();
        break;
        i = 0;
      }
    }
  }
  
  public final void resume()
  {
    int j = 1;
    AppMethodBeat.i(246610);
    super.resume();
    Log.d(this.TAG, kotlin.g.b.s.X("resume curRotation:", Integer.valueOf(getCurrentOrientation())));
    Object localObject = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.biq().nal = false;
    localObject = com.tencent.mm.live.model.u.mZl;
    int i;
    if (com.tencent.mm.live.model.u.bie().mMJ != 0L)
    {
      localObject = com.tencent.mm.live.model.u.mZl;
      if (!com.tencent.mm.live.model.u.biq().nai)
      {
        if (com.tencent.mm.kernel.h.aZW().oun != null)
        {
          localObject = com.tencent.mm.live.model.u.mZl;
          long l = com.tencent.mm.live.model.u.bie().mMJ;
          localObject = com.tencent.mm.live.model.u.mZl;
          new com.tencent.mm.live.model.a.b(l, com.tencent.mm.live.model.u.bhZ(), true).doScene(com.tencent.mm.kernel.h.aZW().oun, new LiveAnchorPluginLayout..ExternalSyntheticLambda3(this));
        }
        localObject = this.njF;
        if (localObject == null) {
          break label364;
        }
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).bch();
        if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).mNF)) {
          break label364;
        }
        i = j;
        label165:
        if (i == 0) {
          break label369;
        }
        localObject = this.njF;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.a.a)localObject).bcg();
        }
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.setLastOrientation(getCurrentOrientation());
      AppMethodBeat.o(246610);
      return;
      localObject = this.nmz;
      if (localObject != null) {
        ((com.tencent.mm.live.b.w)localObject).aPz();
      }
      localObject = this.nmz;
      if (localObject != null) {
        ((com.tencent.mm.live.b.w)localObject).bjr();
      }
      localObject = this.njF;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).bch();
        if ((localObject != null) && (((com.tencent.mm.live.core.core.model.i)localObject).bep() == true))
        {
          i = 1;
          label274:
          if (i == 0) {
            break label357;
          }
          localObject = this.njF;
          if (localObject == null) {
            break label359;
          }
          localObject = ((com.tencent.mm.live.core.core.a.a)localObject).bch();
          if (localObject == null) {
            break label359;
          }
          com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
          if (((com.tencent.mm.live.core.core.model.i)localObject).a(Long.valueOf(com.tencent.mm.live.model.u.bie().mMJ)) != true) {
            break label359;
          }
        }
      }
      label357:
      label359:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label362;
        }
        localObject = this.njF;
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.live.core.core.a.a)localObject).bcj();
        break;
        i = 0;
        break label274;
        break;
      }
      label362:
      break;
      label364:
      i = 0;
      break label165;
      label369:
      localObject = this.njF;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).bch();
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.model.i)localObject).mNF = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(246562);
    super.start();
    Object localObject = com.tencent.mm.live.model.o.mZb;
    com.tencent.mm.live.model.o.bhM();
    localObject = com.tencent.mm.live.model.u.mZl;
    if ((com.tencent.mm.live.model.u.bie().mMJ == 0L) && (this.nmV))
    {
      localObject = com.tencent.mm.live.model.u.mZl;
      if (!com.tencent.mm.live.model.u.biq().nai)
      {
        localObject = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nal)
        {
          localObject = com.tencent.mm.live.model.u.mZl;
          if (!com.tencent.mm.live.model.u.biq().nak)
          {
            localObject = getContext();
            if (localObject == null)
            {
              localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(246562);
              throw ((Throwable)localObject);
            }
            ((Activity)localObject).setRequestedOrientation(4);
          }
        }
      }
    }
    startTimer();
    AppMethodBeat.o(246562);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246455);
    kotlin.g.b.s.u(paramc, "status");
    Log.i(this.TAG, kotlin.g.b.s.X("statusChange:", paramc.name()));
    this.nmR = paramc;
    switch (LiveAnchorPluginLayout.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(246455);
      return;
      if (this.nmV)
      {
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(246455);
          throw paramc;
        }
        ((Activity)localObject1).setRequestedOrientation(4);
      }
      Object localObject1 = this.nmS;
      Object localObject3;
      Object localObject2;
      switch (LiveAnchorPluginLayout.a.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        break;
      case 2: 
        localObject1 = com.tencent.mm.live.model.o.mZb;
        com.tencent.mm.live.model.o.tB(0);
        localObject1 = this.nmz;
        if (localObject1 != null)
        {
          ((com.tencent.mm.live.b.w)localObject1).tO(0);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.nmv;
        if (localObject1 != null)
        {
          ((ac)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.nmw;
        if (localObject1 != null)
        {
          ((com.tencent.mm.live.b.l)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.nmx;
        if (localObject1 != null)
        {
          ((com.tencent.mm.live.b.g)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.nmy;
        if (localObject1 != null)
        {
          ((com.tencent.mm.live.b.c)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.nmB;
        if (localObject1 != null)
        {
          ((com.tencent.mm.live.b.h)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.nmF;
        if (localObject1 != null)
        {
          ((n)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.nmD;
        if (localObject1 != null)
        {
          ((ab)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.nmA;
        if (localObject1 != null)
        {
          ((y)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.nmH;
        if (localObject1 != null)
        {
          ((f)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject3 = this.nmD;
        if (localObject3 != null)
        {
          localObject1 = com.tencent.mm.live.model.u.mZl;
          localObject2 = com.tencent.mm.live.model.u.bie().Zqd;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject1 = (CharSequence)localObject1;
          localObject2 = com.tencent.mm.live.model.u.mZl;
          ((ab)localObject3).a((CharSequence)localObject1, com.tencent.mm.live.model.u.big());
          localObject1 = ah.aiuX;
        }
        statusChange(b.c.ndi, new Bundle());
        break;
      case 3: 
        statusChange(b.c.nch, new Bundle());
        continue;
        localObject1 = this.orientationEventListener;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).disable();
          localObject1 = ah.aiuX;
        }
        localObject1 = this.orientationEventListener;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.mmsight.model.d)localObject1).KUU = null;
          localObject1 = ah.aiuX;
        }
        this.orientationEventListener = null;
        localObject1 = com.tencent.mm.live.model.c.a.nbR;
        localObject1 = com.tencent.mm.live.model.c.a.biZ();
        Log.i(this.TAG, "lockOrientation liveRotation:" + ((dig)localObject1).rotation + ", curRotation:" + getCurrentOrientation());
        boolean bool1;
        if ((((dig)localObject1).rotation == -1) || (((dig)localObject1).rotation == getCurrentOrientation()))
        {
          localObject1 = getContext();
          if (localObject1 == null)
          {
            paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(246455);
            throw paramc;
          }
          ((Activity)localObject1).setRequestedOrientation(14);
          localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn();
          if (getContext().getResources().getConfiguration().orientation != 1) {
            break label1177;
          }
          bool1 = true;
          label780:
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject1).mTf = bool1;
          Log.i(this.TAG, kotlin.g.b.s.X("create live, isVideoVertical:", Boolean.valueOf(com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTf)));
          localObject1 = com.tencent.mm.live.model.u.mZl;
          localObject3 = com.tencent.mm.live.model.u.bie();
          if (paramBundle != null) {
            break label1183;
          }
          localObject1 = "";
          label831:
          ((dio)localObject3).Zqd = ((String)localObject1);
          localObject1 = com.tencent.mm.live.model.u.mZl;
          localObject1 = com.tencent.mm.live.model.u.bie().Zqd;
          kotlin.g.b.s.s(localObject1, "RoomLiveService.liveInfo.live_name");
          localObject2 = com.tencent.mm.live.model.u.mZl;
          l = com.tencent.mm.live.model.u.bie().mMJ;
          localObject2 = com.tencent.mm.live.model.u.mZl;
          localObject2 = com.tencent.mm.live.model.u.bhZ();
          Log.i(this.TAG, "startLive, name:" + (String)localObject1 + ", roomId:" + l);
          if ((l == 0L) || (Util.isNullOrNil((String)localObject2))) {
            break label1262;
          }
          Log.i(this.TAG, "try resume live, liveId:" + l + ", liveName:" + (String)localObject1 + ", roomId:" + (String)localObject2);
          localObject3 = com.tencent.mm.live.model.u.mZl;
          localObject3 = com.tencent.mm.live.model.u.bii();
          if (localObject3 != null) {
            break label1209;
          }
          new com.tencent.mm.live.model.h(l, (String)localObject2, (String)localObject1, (byte)0).a((kotlin.g.a.r)new l(this));
        }
        for (;;)
        {
          localObject1 = this.njF;
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.live.core.core.a.a)localObject1).bcj();
          break;
          switch (((dig)localObject1).rotation)
          {
          default: 
            break;
          case 0: 
          case 2: 
            this.nmX = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(246455);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(1);
            break;
          case 1: 
          case 3: 
            this.nmX = true;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(246455);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(0);
            break;
            label1177:
            bool1 = false;
            break label780;
            label1183:
            localObject2 = paramBundle.getString("PARAM_START_LIVE_TITLE");
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label831;
            }
            localObject1 = "";
            break label831;
            label1209:
            localObject1 = this.njF;
            if (localObject1 != null) {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.model.h)localObject3);
            }
            localObject1 = this.njF;
            if (localObject1 != null)
            {
              ((com.tencent.mm.live.core.core.a.a)localObject1).a((com.tencent.mm.live.core.core.c)new m(this));
              continue;
              label1262:
              Log.i("MicroMsg.LiveCoreAnchor", "createNewLive, liveName:" + (String)localObject1 + ", wechatRoomId:" + (String)localObject2);
              localObject3 = getContext();
              kotlin.g.b.s.s(localObject3, "context");
              localObject1 = new com.tencent.mm.live.model.i((String)localObject1, (String)localObject2, (Context)localObject3);
              localObject2 = (kotlin.g.a.s)new c(this);
              com.tencent.mm.kernel.h.baD().mCm.a(3501, (com.tencent.mm.am.h)localObject1);
              localObject3 = new com.tencent.mm.live.model.a.l(((com.tencent.mm.live.model.i)localObject1).name, ((com.tencent.mm.live.model.i)localObject1).roomId);
              com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject3, 0);
              ((com.tencent.mm.live.model.i)localObject1).mXR = ((kotlin.g.a.s)localObject2);
            }
            break;
          }
        }
        localObject1 = com.tencent.mm.live.model.u.mZl;
        localObject1 = com.tencent.mm.live.model.u.bie().Zqd;
        kotlin.g.b.s.s(localObject1, "RoomLiveService.liveInfo.live_name");
        localObject2 = com.tencent.mm.live.model.u.mZl;
        localObject2 = com.tencent.mm.live.model.u.bhZ();
        localObject3 = getContext();
        kotlin.g.b.s.s(localObject3, "context");
        localObject1 = new com.tencent.mm.live.model.i((String)localObject1, (String)localObject2, (Context)localObject3);
        localObject2 = (kotlin.g.a.s)new h(this);
        com.tencent.mm.kernel.h.baD().mCm.a(3797, (com.tencent.mm.am.h)localObject1);
        localObject3 = com.tencent.mm.live.model.u.mZl;
        long l = com.tencent.mm.live.model.u.bie().mMJ;
        localObject3 = ((com.tencent.mm.live.model.i)localObject1).roomId;
        com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
        localObject3 = new com.tencent.mm.live.model.a.o(l, (String)localObject3, com.tencent.mm.live.model.u.bid());
        com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject3, 0);
        ((com.tencent.mm.live.model.i)localObject1).mXS = ((kotlin.g.a.s)localObject2);
        continue;
        this.nmW.bAh();
        localObject1 = this.nmL;
        if (localObject1 != null)
        {
          ((com.tencent.mm.live.b.r)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject1 = new LiveAnchorPluginLayout..ExternalSyntheticLambda8(this);
        localObject2 = com.tencent.mm.live.b.r.niG;
        postDelayed((Runnable)localObject1, com.tencent.mm.live.b.r.bjp() + 50L);
        com.tencent.mm.live.model.o.mZb.bhO();
        localObject1 = com.tencent.mm.live.model.o.mZb;
        com.tencent.mm.live.model.o.bhJ();
        localObject1 = com.tencent.mm.live.model.u.mZl;
        if (com.tencent.mm.live.model.u.bie().HTK == 0)
        {
          localObject1 = com.tencent.mm.live.model.u.mZl;
          com.tencent.mm.live.model.u.bie().HTK = cn.getSyncServerTimeSecond();
        }
        localObject1 = com.tencent.mm.live.model.c.a.nbR;
        if (com.tencent.mm.live.model.c.a.biZ().mMJ != 0L) {}
        int j;
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            localObject1 = com.tencent.mm.live.model.c.a.nbR;
            localObject1 = com.tencent.mm.live.model.u.mZl;
            l = com.tencent.mm.live.model.u.bie().mMJ;
            localObject1 = com.tencent.mm.live.model.u.mZl;
            localObject1 = com.tencent.mm.live.model.u.bhZ();
            i = getCurrentOrientation();
            localObject2 = com.tencent.mm.live.model.u.mZl;
            localObject2 = com.tencent.mm.live.model.u.biR();
            localObject3 = com.tencent.mm.live.model.u.mZl;
            j = com.tencent.mm.live.model.u.bie().HTK;
            localObject3 = com.tencent.mm.live.model.u.mZl;
            com.tencent.mm.live.model.c.a.a(l, (String)localObject1, i, (String)localObject2, j, com.tencent.mm.live.model.u.big());
          }
          localObject1 = com.tencent.mm.live.model.u.mZl;
          com.tencent.mm.live.model.u.biS();
          localObject1 = com.tencent.mm.live.model.o.mZb;
          com.tencent.mm.live.model.o.tB(0);
          startTimer();
          break;
        }
        localObject1 = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.bil();
        localObject1 = getContext();
        if (localObject1 == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(246455);
          throw paramc;
        }
        ((Activity)localObject1).finishAndRemoveTask();
        continue;
        localObject1 = this.nmG;
        if (localObject1 != null)
        {
          if (((com.tencent.mm.live.b.e)localObject1).ngA.isShowing()) {
            ((com.tencent.mm.live.b.e)localObject1).ngA.dismiss();
          }
          localObject1 = ah.aiuX;
        }
        localObject1 = this.nmL;
        if (localObject1 != null)
        {
          ((com.tencent.mm.live.b.r)localObject1).tO(8);
          localObject1 = ah.aiuX;
        }
        localObject1 = this.njF;
        if (localObject1 != null)
        {
          ((com.tencent.mm.live.core.core.a.a)localObject1).bci();
          localObject1 = ah.aiuX;
        }
        bkX();
        localObject1 = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.biU();
        localObject1 = com.tencent.mm.live.model.o.mZb;
        com.tencent.mm.live.model.o.bhL();
        localObject1 = com.tencent.mm.live.model.o.mZb;
        com.tencent.mm.live.model.o.bhM();
        com.tencent.mm.live.model.o.mZb.release();
        localObject1 = j.mXT;
        j.bhj();
        localObject1 = com.tencent.mm.live.model.c.a.nbR;
        localObject1 = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.c.a.hS(com.tencent.mm.live.model.u.bie().mMJ);
        continue;
        localObject1 = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nai)
        {
          localObject1 = this.nmC;
          if (localObject1 != null)
          {
            ((x)localObject1).tO(8);
            localObject1 = ah.aiuX;
          }
          localObject1 = this.nmz;
          if (localObject1 != null)
          {
            ((com.tencent.mm.live.b.w)localObject1).tO(8);
            localObject1 = ah.aiuX;
          }
          localObject1 = this.nmv;
          if (localObject1 != null)
          {
            ((ac)localObject1).tO(8);
            localObject1 = ah.aiuX;
          }
          localObject1 = this.nmw;
          if (localObject1 != null)
          {
            ((com.tencent.mm.live.b.l)localObject1).tO(8);
            localObject1 = ah.aiuX;
          }
          localObject1 = this.nmx;
          if (localObject1 != null)
          {
            ((com.tencent.mm.live.b.g)localObject1).tO(8);
            localObject1 = ah.aiuX;
          }
          localObject1 = this.nmL;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.live.model.u.mZl;
            localObject2 = com.tencent.mm.live.model.u.big();
            localObject3 = getContext().getResources().getString(b.h.live_local_network_error_tip);
            kotlin.g.b.s.s(localObject3, "context.resources.getStr…_local_network_error_tip)");
            ((com.tencent.mm.live.b.r)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
            localObject1 = ah.aiuX;
          }
          localObject1 = com.tencent.mm.live.model.u.mZl;
          com.tencent.mm.live.model.u.biT();
          continue;
          localObject1 = com.tencent.mm.live.model.u.mZl;
          if (!com.tencent.mm.live.model.u.biq().nai)
          {
            localObject1 = this.nmz;
            if (localObject1 != null)
            {
              ((com.tencent.mm.live.b.w)localObject1).tO(0);
              localObject1 = ah.aiuX;
            }
            localObject1 = com.tencent.mm.live.model.u.mZl;
            com.tencent.mm.live.model.u.biq().nak = false;
            continue;
            if (this.nmV)
            {
              localObject1 = getContext();
              if (localObject1 == null)
              {
                paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(246455);
                throw paramc;
              }
              ((Activity)localObject1).setRequestedOrientation(4);
              continue;
              if (paramBundle == null) {
                localObject1 = "";
              }
              for (;;)
              {
                localObject2 = com.tencent.mm.live.model.o.mZb;
                com.tencent.mm.live.model.o.Gn((String)localObject1);
                break;
                localObject2 = paramBundle.getString("PARAM_LIVE_KICK_USERNAME");
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
              }
              localObject1 = com.tencent.mm.live.model.u.mZl;
              com.tencent.mm.live.model.u.biq().nal = true;
              continue;
              localObject1 = this.nmL;
              if (localObject1 != null)
              {
                ((com.tencent.mm.live.b.r)localObject1).tO(8);
                localObject1 = ah.aiuX;
              }
              localObject1 = this.orientationEventListener;
              if (localObject1 != null)
              {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).KUU = ((com.tencent.mm.plugin.mmsight.model.d.a)this);
                localObject1 = ah.aiuX;
              }
              localObject1 = this.orientationEventListener;
              if (localObject1 != null)
              {
                ((com.tencent.mm.plugin.mmsight.model.d)localObject1).enable();
                localObject1 = ah.aiuX;
              }
              localObject1 = com.tencent.mm.live.model.u.mZl;
              if (com.tencent.mm.live.model.u.bir().naf)
              {
                localObject1 = this.nmw;
                if (localObject1 != null)
                {
                  ((com.tencent.mm.live.b.l)localObject1).tO(0);
                  localObject1 = ah.aiuX;
                }
                statusChange(b.c.ncf, new Bundle());
                localObject1 = com.tencent.mm.live.model.u.mZl;
                com.tencent.mm.live.model.u.bir().naf = false;
                continue;
                localObject1 = com.tencent.mm.live.model.u.mZl;
                if (com.tencent.mm.live.model.u.biy()) {}
                for (i = 4;; i = 5)
                {
                  localObject1 = com.tencent.mm.live.model.u.mZl;
                  localObject1 = com.tencent.mm.live.model.u.bhZ();
                  localObject2 = com.tencent.mm.live.model.u.mZl;
                  bool1 = com.tencent.mm.live.model.u.biv();
                  localObject2 = com.tencent.mm.live.model.u.mZl;
                  bool2 = com.tencent.mm.live.model.u.biw();
                  localObject2 = com.tencent.mm.live.model.u.mZl;
                  localObject2 = com.tencent.mm.live.model.u.bie().Zqd;
                  localObject3 = com.tencent.mm.live.model.u.mZl;
                  com.tencent.mm.live.c.e.a((String)localObject1, bool1, bool2, (String)localObject2, com.tencent.mm.live.model.u.biu(), getContext().getResources().getConfiguration().orientation, i);
                  if (getContext().getResources().getConfiguration().orientation != 2) {
                    break label2593;
                  }
                  com.tencent.mm.live.c.a.bjQ();
                  break;
                }
                label2593:
                com.tencent.mm.live.c.a.bjR();
                continue;
                localObject1 = com.tencent.mm.live.model.u.mZl;
                if (!com.tencent.mm.live.model.u.biq().nai)
                {
                  localObject1 = this.nmC;
                  if (localObject1 != null)
                  {
                    ((x)localObject1).tO(8);
                    localObject1 = ah.aiuX;
                  }
                  localObject1 = this.nmz;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.live.b.w)localObject1).tO(8);
                    localObject1 = ah.aiuX;
                  }
                  localObject1 = this.nmv;
                  if (localObject1 != null)
                  {
                    ((ac)localObject1).tO(8);
                    localObject1 = ah.aiuX;
                  }
                  localObject1 = this.nmw;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.live.b.l)localObject1).tO(8);
                    localObject1 = ah.aiuX;
                  }
                  localObject1 = this.nmx;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.live.b.g)localObject1).tO(8);
                    localObject1 = ah.aiuX;
                  }
                  localObject1 = this.nmL;
                  if (localObject1 != null)
                  {
                    localObject2 = com.tencent.mm.live.model.u.mZl;
                    localObject2 = com.tencent.mm.live.model.u.big();
                    localObject3 = getContext().getResources().getString(b.h.live_local_network_error_tip);
                    kotlin.g.b.s.s(localObject3, "context.resources.getStr…_local_network_error_tip)");
                    ((com.tencent.mm.live.b.r)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
                    localObject1 = ah.aiuX;
                  }
                  localObject1 = com.tencent.mm.live.model.u.mZl;
                  com.tencent.mm.live.model.u.biT();
                }
                localObject1 = com.tencent.mm.live.model.u.mZl;
                localObject1 = com.tencent.mm.live.model.u.bhZ();
                localObject2 = com.tencent.mm.live.model.u.mZl;
                bool1 = com.tencent.mm.live.model.u.biv();
                localObject2 = com.tencent.mm.live.model.u.mZl;
                boolean bool2 = com.tencent.mm.live.model.u.biw();
                localObject2 = com.tencent.mm.live.model.u.mZl;
                localObject2 = com.tencent.mm.live.model.u.bie().Zqd;
                localObject3 = com.tencent.mm.live.model.u.mZl;
                boolean bool3 = com.tencent.mm.live.model.u.biu();
                j = getContext().getResources().getConfiguration().orientation;
                if (paramBundle == null) {}
                for (i = 0;; i = paramBundle.getInt("live_user_exit_reason"))
                {
                  com.tencent.mm.live.c.e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, j, 6, i);
                  break;
                }
                localObject1 = this.nmz;
                if (localObject1 != null)
                {
                  ((com.tencent.mm.live.b.w)localObject1).bjr();
                  localObject1 = ah.aiuX;
                }
                localObject1 = this.njF;
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).bch();
                  if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).beu() != true)) {}
                }
                for (i = 1; i != 0; i = 0)
                {
                  localObject1 = this.njF;
                  if (localObject1 == null) {
                    break;
                  }
                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).bch();
                  if (localObject1 == null) {
                    break;
                  }
                  ((com.tencent.mm.live.core.core.model.i)localObject1).mNH = i.b.mNW;
                  localObject1 = ah.aiuX;
                  break;
                }
                localObject1 = this.njF;
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).bch();
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.live.core.core.model.i)localObject1).mNK = i.e.mOf;
                    localObject1 = ah.aiuX;
                    continue;
                    localObject1 = this.njF;
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).bch();
                      if (localObject1 != null)
                      {
                        ((com.tencent.mm.live.core.core.model.i)localObject1).mNK = i.e.mOh;
                        localObject1 = ah.aiuX;
                        continue;
                        localObject1 = this.njF;
                        if (localObject1 != null)
                        {
                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).bch();
                          if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.model.i)localObject1).isFloatMode()))
                          {
                            i = 1;
                            label3124:
                            if (i == 0) {
                              continue;
                            }
                            if (paramBundle != null) {
                              break label3248;
                            }
                          }
                        }
                        label3248:
                        for (i = 0;; i = paramBundle.getInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0))
                        {
                          localObject1 = this.njF;
                          if (localObject1 != null)
                          {
                            localObject1 = (com.tencent.mm.live.core.core.b)localObject1;
                            localObject2 = getContext();
                            kotlin.g.b.s.s(localObject2, "context");
                            com.tencent.mm.live.core.core.b.a.a((com.tencent.mm.live.core.core.b)localObject1, (Context)localObject2, false, false, i, 0, null, false, 118);
                          }
                          localObject1 = com.tencent.mm.live.model.u.mZl;
                          localObject1 = com.tencent.mm.live.model.u.bhZ();
                          localObject2 = com.tencent.mm.live.model.u.mZl;
                          l = com.tencent.mm.live.model.u.bie().mMJ;
                          localObject2 = com.tencent.mm.live.model.u.mZl;
                          localObject2 = com.tencent.mm.live.model.u.big();
                          localObject3 = com.tencent.mm.live.model.u.mZl;
                          com.tencent.mm.live.c.e.a((String)localObject1, l, (String)localObject2, 2, 1, com.tencent.mm.live.model.u.bie().ZWw);
                          com.tencent.mm.live.c.a.bjO();
                          break;
                          i = 0;
                          break label3124;
                        }
                        localObject1 = com.tencent.mm.live.model.u.mZl;
                        localObject1 = com.tencent.mm.live.model.u.bhZ();
                        localObject2 = com.tencent.mm.live.model.u.mZl;
                        l = com.tencent.mm.live.model.u.bie().mMJ;
                        localObject2 = com.tencent.mm.live.model.u.mZl;
                        localObject2 = com.tencent.mm.live.model.u.big();
                        localObject3 = com.tencent.mm.live.model.u.mZl;
                        com.tencent.mm.live.c.e.a((String)localObject1, l, (String)localObject2, 2, 0, com.tencent.mm.live.model.u.bie().ZWw);
                        com.tencent.mm.live.c.a.bjP();
                        continue;
                        localObject1 = this.njF;
                        if (localObject1 != null)
                        {
                          localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).bch();
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.live.core.core.model.i)localObject1).mNH = i.b.mNV;
                            localObject1 = ah.aiuX;
                            continue;
                            localObject1 = this.njF;
                            if (localObject1 != null)
                            {
                              localObject1 = ((com.tencent.mm.live.core.core.a.a)localObject1).bch();
                              if (localObject1 != null)
                              {
                                ((com.tencent.mm.live.core.core.model.i)localObject1).mNH = i.b.mNU;
                                localObject1 = ah.aiuX;
                              }
                            }
                            localObject1 = this.nmM;
                            if (localObject1 != null)
                            {
                              this.nmT.remove(localObject1);
                              continue;
                              localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn();
                              localObject2 = com.tencent.mm.live.model.u.mZl;
                              if (!com.tencent.mm.live.model.u.bit().isLandscape())
                              {
                                bool1 = true;
                                label3449:
                                ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject1).mTp = bool1;
                                localObject1 = this.njF;
                                if (localObject1 != null)
                                {
                                  ((com.tencent.mm.live.core.core.a.a)localObject1).ai(0.0F, 0.0F);
                                  localObject1 = ah.aiuX;
                                }
                                localObject1 = this.nmz;
                                if (localObject1 == null) {
                                  continue;
                                }
                                localObject2 = com.tencent.mm.live.model.u.mZl;
                                if (!com.tencent.mm.live.model.u.bit().isLandscape()) {
                                  break label3554;
                                }
                              }
                              label3554:
                              for (i = 2;; i = 1)
                              {
                                localObject2 = com.tencent.mm.live.model.u.mZl;
                                localObject2 = com.tencent.mm.live.model.u.bit().userId;
                                localObject3 = com.tencent.mm.live.model.u.mZl;
                                ((com.tencent.mm.live.b.w)localObject1).c(i, (String)localObject2, com.tencent.mm.live.model.u.bit().streamType);
                                localObject1 = ah.aiuX;
                                break;
                                bool1 = false;
                                break label3449;
                              }
                              localObject1 = com.tencent.mm.live.model.u.mZl;
                              if (!com.tencent.mm.live.model.u.biq().nai)
                              {
                                localObject1 = this.nmC;
                                if (localObject1 != null)
                                {
                                  ((x)localObject1).tO(8);
                                  localObject1 = ah.aiuX;
                                }
                                localObject1 = this.nmz;
                                if (localObject1 != null)
                                {
                                  ((com.tencent.mm.live.b.w)localObject1).tO(8);
                                  localObject1 = ah.aiuX;
                                }
                                localObject1 = this.nmv;
                                if (localObject1 != null)
                                {
                                  ((ac)localObject1).tO(8);
                                  localObject1 = ah.aiuX;
                                }
                                localObject1 = this.nmw;
                                if (localObject1 != null)
                                {
                                  ((com.tencent.mm.live.b.l)localObject1).tO(8);
                                  localObject1 = ah.aiuX;
                                }
                                localObject1 = this.nmx;
                                if (localObject1 != null)
                                {
                                  ((com.tencent.mm.live.b.g)localObject1).tO(8);
                                  localObject1 = ah.aiuX;
                                }
                                localObject1 = this.nmL;
                                if (localObject1 != null)
                                {
                                  ((com.tencent.mm.live.b.r)localObject1).tO(8);
                                  localObject1 = ah.aiuX;
                                }
                                localObject1 = this.nmQ;
                                if (localObject1 != null)
                                {
                                  ((k)localObject1).tO(0);
                                  localObject1 = ah.aiuX;
                                }
                                localObject1 = com.tencent.mm.live.model.u.mZl;
                                com.tencent.mm.live.model.u.biT();
                                localObject1 = getContext();
                                if (localObject1 == null)
                                {
                                  paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                                  AppMethodBeat.o(246455);
                                  throw paramc;
                                }
                                ((Activity)localObject1).setRequestedOrientation(1);
                                continue;
                                localObject1 = this.nmD;
                                if (localObject1 != null)
                                {
                                  localObject2 = com.tencent.mm.live.model.u.mZl;
                                  localObject2 = com.tencent.mm.live.model.u.bie().Zqd;
                                  kotlin.g.b.s.s(localObject2, "RoomLiveService.liveInfo.live_name");
                                  localObject2 = (CharSequence)localObject2;
                                  localObject3 = com.tencent.mm.live.model.u.mZl;
                                  ((ab)localObject1).a((CharSequence)localObject2, com.tencent.mm.live.model.u.big());
                                  localObject1 = ah.aiuX;
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
    AppMethodBeat.i(246568);
    super.stop();
    this.nmZ.stopTimer();
    AppMethodBeat.o(246568);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246556);
    super.unMount();
    com.tencent.mm.kernel.h.baD().mCm.b(3806, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(3559, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(3557, (com.tencent.mm.am.h)this);
    Object localObject;
    if ((!bkZ()) && (!this.nmX))
    {
      localObject = this.njF;
      if (localObject == null) {
        break label254;
      }
      localObject = ((com.tencent.mm.live.core.core.a.a)localObject).bch();
      if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).beu() != true)) {
        break label254;
      }
      i = 1;
      if (i == 0)
      {
        localObject = this.njF;
        if (localObject == null) {
          break label259;
        }
        localObject = ((com.tencent.mm.live.core.core.a.a)localObject).bch();
        if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).bet() != true)) {
          break label259;
        }
      }
    }
    label259:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.nmG;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.live.b.e)localObject).ngz.getSelectUser();
          if (localObject != null)
          {
            com.tencent.mm.live.model.o localo = com.tencent.mm.live.model.o.mZb;
            com.tencent.mm.live.model.o.aI(((com.tencent.mm.live.model.b.a.a)localObject).mXx, ((com.tencent.mm.live.model.b.a.a)localObject).mXH);
          }
        }
      }
      localObject = com.tencent.mm.live.model.o.mZb;
      com.tencent.mm.live.model.o.tB(1);
      bkX();
      com.tencent.mm.live.model.o.mZb.release();
      localObject = j.mXT;
      j.bhj();
      localObject = this.njF;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.a)localObject).bci();
      }
      localObject = com.tencent.mm.live.core.core.a.b.mMo;
      com.tencent.mm.live.core.core.a.b.a.fF(false);
      localObject = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.aNm();
      this.nmW.gR(false);
      this.nmZ.stopTimer();
      AppMethodBeat.o(246556);
      return;
      label254:
      i = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.model.g, TRTCCloudDef.TRTCParams, ah>
  {
    b(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "needFaceVerify", "verifyUrl", "", "errCode", "", "errMsg"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.s<Boolean, Boolean, String, Integer, String, ah>
  {
    c(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    private static final void d(LiveAnchorPluginLayout paramLiveAnchorPluginLayout, DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(246168);
      kotlin.g.b.s.u(paramLiveAnchorPluginLayout, "this$0");
      paramDialogInterface = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.biT();
      b.b.a((com.tencent.mm.live.b.b)paramLiveAnchorPluginLayout, b.c.ncl);
      AppMethodBeat.o(246168);
    }
    
    private static final void e(LiveAnchorPluginLayout paramLiveAnchorPluginLayout, DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(246176);
      kotlin.g.b.s.u(paramLiveAnchorPluginLayout, "this$0");
      paramDialogInterface = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.biT();
      b.b.a((com.tencent.mm.live.b.b)paramLiveAnchorPluginLayout, b.c.ncl);
      AppMethodBeat.o(246176);
    }
    
    private static final void k(boolean paramBoolean, String paramString) {}
    
    private static final void m(boolean paramBoolean, String paramString) {}
    
    @Metadata(d1={""}, d2={"com/tencent/mm/live/view/LiveAnchorPluginLayout$createNewLive$1$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends com.tencent.mm.plugin.messenger.a.a
    {
      a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
      {
        super();
      }
      
      public final void onClickImp(View paramView)
      {
        AppMethodBeat.i(246226);
        kotlin.g.b.s.u(paramView, "widget");
        paramView = new Intent();
        l.a locala = com.tencent.mm.live.model.l.mYb;
        paramView.putExtra("rawUrl", com.tencent.mm.live.model.l.bhl());
        paramView.putExtra("showShare", false);
        com.tencent.mm.br.c.g(this.nna.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
        AppMethodBeat.o(246226);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/view/LiveAnchorPluginLayout$handleJoinLiveFail$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.messenger.a.a
  {
    d(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    public final void onClickImp(View paramView)
    {
      AppMethodBeat.i(246158);
      kotlin.g.b.s.u(paramView, "widget");
      paramView = new Intent();
      l.a locala = com.tencent.mm.live.model.l.mYb;
      paramView.putExtra("rawUrl", com.tencent.mm.live.model.l.bhl());
      paramView.putExtra("showShare", false);
      com.tencent.mm.br.c.g(this.nna.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(246158);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "xOffset", "", "yOffset"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements m<Float, Float, ah>
  {
    e(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "x", "", "y"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements m<Float, Float, ah>
  {
    f(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "liveID", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Long, ah>
  {
    g(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.s<Boolean, Integer, String, com.tencent.mm.live.core.core.model.g, TRTCCloudDef.TRTCParams, ah>
  {
    h(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/live/view/LiveAnchorPluginLayout$joinLive$1$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.live.core.core.c
    {
      a(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
      
      public final void callback(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(246117);
        Log.i("MicroMsg.LiveCoreAnchor", "on enterRoom finish");
        if (paramInt >= 0)
        {
          b.b.a((com.tencent.mm.live.b.b)this.nna, b.c.ncj);
          paramBundle = com.tencent.mm.live.model.o.mZb;
          paramBundle = com.tencent.mm.live.model.u.mZl;
          com.tencent.mm.live.model.o.Gm(com.tencent.mm.live.model.u.bhZ());
          b.b.a((com.tencent.mm.live.b.b)this.nna, b.c.ndd);
          AppMethodBeat.o(246117);
          return;
        }
        Log.w("MicroMsg.LiveCoreAnchor", "enter room fail");
        aa.makeText(this.nna.getContext(), (CharSequence)"enter room fail", 0).show();
        b.b.a((com.tencent.mm.live.b.b)this.nna, b.c.nch);
        paramBundle = new Bundle();
        paramBundle.putInt("live_user_exit_reason", paramInt);
        this.nna.statusChange(b.c.ndc, paramBundle);
        AppMethodBeat.o(246117);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    i(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    k(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ret", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.model.g, TRTCCloudDef.TRTCParams, ah>
  {
    l(LiveAnchorPluginLayout paramLiveAnchorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/view/LiveAnchorPluginLayout$tryResumeLive$2", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements com.tencent.mm.live.core.core.c
  {
    m(LiveAnchorPluginLayout paramLiveAnchorPluginLayout) {}
    
    public final void callback(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(246180);
      Log.i("MicroMsg.LiveCoreAnchor", "try resume live on enterRoom finish");
      if (paramInt >= 0)
      {
        b.b.a((com.tencent.mm.live.b.b)this.nna, b.c.ncj);
        AppMethodBeat.o(246180);
        return;
      }
      Log.w("MicroMsg.LiveCoreAnchor", "try resume live senter room fail");
      aa.makeText(this.nna.getContext(), (CharSequence)"enter room fail", 0).show();
      b.b.a((com.tencent.mm.live.b.b)this.nna, b.c.nch);
      AppMethodBeat.o(246180);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAnchorPluginLayout
 * JD-Core Version:    0.7.0.1
 */