package com.tencent.mm.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.f.b.a.hh;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.l.a;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.b.u.b;
import com.tencent.mm.live.b.u.c;
import com.tencent.mm.live.b.u.d;
import com.tencent.mm.live.c.ab;
import com.tencent.mm.live.c.ab.a;
import com.tencent.mm.live.c.ac;
import com.tencent.mm.live.c.ae;
import com.tencent.mm.live.c.ag;
import com.tencent.mm.live.c.ai;
import com.tencent.mm.live.c.ak;
import com.tencent.mm.live.c.am;
import com.tencent.mm.live.c.as;
import com.tencent.mm.live.c.ay;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.c.bc;
import com.tencent.mm.live.c.be;
import com.tencent.mm.live.c.bg;
import com.tencent.mm.live.c.bi;
import com.tencent.mm.live.c.bk;
import com.tencent.mm.live.core.b.n;
import com.tencent.mm.live.core.core.b.a;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.live.core.core.c.c.f;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.e;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.core.core.model.h.e;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.d;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout;", "Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "anchorExceptionInTRTC", "", "audienceMode", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "liveDebugPlugin", "Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveGuestRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "liveInputPlugin", "Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "liveKickedPlugin", "Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVideoMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "liveVisitorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "liveVisitorCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "miniView", "Lcom/tencent/mm/live/view/RoomLiveMiniView;", "getMiniView", "()Lcom/tencent/mm/live/view/RoomLiveMiniView;", "miniView$delegate", "Lkotlin/Lazy;", "pluginShow", "rotationEnable", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkAnchorStatus", "checkClickArea", "x", "", "y", "validCallback", "chooseAudienceMode", "byOrientationChange", "enterRoom", "liveName", "", "roomID", "", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "getRenderMode", "handleEnterRoom", "handleJoinLiveErr", "errCode", "errMsg", "initLogic", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "isLiving", "keyboardChange", "show", "height", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "requestLinkMic", "resume", "start", "startTimer", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "stopTimer", "toggleShowPlugins", "unMount", "updatePlugin", "Companion", "plugin-logic_release"})
public final class LiveVisitorPluginLayout
  extends RoomBaseLivePluginLayout
  implements i, com.tencent.mm.live.core.core.c
{
  public static final a kLI;
  private int curNetworkQuality;
  private ag kKA;
  private com.tencent.mm.live.c.r kKC;
  private final ArrayList<com.tencent.mm.live.c.a> kKF;
  private boolean kKG;
  private boolean kKH;
  private final d kKI;
  private MTimerHandler kKL;
  private com.tencent.mm.live.c.t kKi;
  private com.tencent.mm.live.c.c kKk;
  private as kKm;
  private com.tencent.mm.live.c.m kKn;
  private ay kKp;
  private ai kKq;
  private com.tencent.mm.live.c.o kKu;
  private am kKv;
  private ae kKx;
  private ak kKy;
  private ac kKz;
  private com.tencent.mm.live.c.z kLA;
  private bg kLB;
  private com.tencent.mm.live.c.q kLC;
  private bc kLD;
  private ab kLE;
  private be kLF;
  private boolean kLG;
  private final kotlin.f kLH;
  private bk kLx;
  private com.tencent.mm.live.c.aw kLy;
  private com.tencent.mm.live.c.v kLz;
  private int kmi;
  private com.tencent.mm.live.core.core.c.c liveCore;
  private final kotlin.g.a.a<x> liveMessageCallback;
  
  static
  {
    AppMethodBeat.i(194111);
    kLI = new a((byte)0);
    AppMethodBeat.o(194111);
  }
  
  public LiveVisitorPluginLayout(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194110);
    this.kKG = true;
    paramAttributeSet = e.b.kjz;
    this.kmi = e.b.aJJ();
    this.kKF = new ArrayList();
    this.kKI = d.bcs();
    paramAttributeSet = e.m.kkI;
    this.curNetworkQuality = e.m.aKH();
    this.kLH = kotlin.g.ar((kotlin.g.a.a)new p(this, paramContext));
    this.liveMessageCallback = ((kotlin.g.a.a)new o(this));
    this.kKL = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack)new r(this), true);
    AppMethodBeat.o(194110);
  }
  
  private final void a(float paramFloat1, float paramFloat2, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(194073);
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
      AppMethodBeat.o(194073);
      return;
    }
  }
  
  private final void a(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(194029);
    Log.i("MicroMsg.LiveCoreVisitor", "join, name:" + paramString1 + ", roomID:" + paramLong);
    u localu = u.kwz;
    new com.tencent.mm.live.b.h(u.aOr().klE, paramString2, paramString1, (byte)0).a((kotlin.g.a.r)new e(this));
    AppMethodBeat.o(194029);
  }
  
  private static void aRp()
  {
    AppMethodBeat.i(194026);
    c.a locala = com.tencent.mm.live.core.core.c.c.kqq;
    c.a.aMm().aMg();
    Log.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:0");
    AppMethodBeat.o(194026);
  }
  
  private final void fw(final boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(194020);
    Log.i("MicroMsg.LiveCoreVisitor", "audienceMode:" + this.kmi);
    int i = this.kmi;
    Object localObject1 = e.b.kjz;
    if (i == e.b.aJJ())
    {
      com.tencent.mm.live.d.f.aQW();
      localObject1 = this.kLx;
      if (localObject1 != null)
      {
        localObject2 = u.kwz;
        localObject2 = u.aOv();
        if (localObject2 == null) {
          p.iCn();
        }
        ((bk)localObject1).a((com.tencent.mm.live.core.core.model.g)localObject2, (kotlin.g.a.b)new c(this, paramBoolean));
      }
      localObject1 = this.kLx;
      if (localObject1 != null)
      {
        ((bk)localObject1).tU(0);
        AppMethodBeat.o(194020);
        return;
      }
      AppMethodBeat.o(194020);
      return;
    }
    localObject1 = e.b.kjz;
    if (i == e.b.aJK())
    {
      com.tencent.mm.live.d.f.aQV();
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject3 = u.kwz;
        localObject3 = u.aOv();
        if (localObject3 == null) {
          p.iCn();
        }
        ((com.tencent.mm.live.core.core.c.c)localObject1).a((com.tencent.mm.live.core.core.model.g)localObject3);
      }
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject3 = u.kwz;
        localObject3 = u.aOv();
        if (localObject3 == null) {
          p.iCn();
        }
        ((com.tencent.mm.live.core.core.c.c)localObject1).b(((com.tencent.mm.live.core.core.model.g)localObject3).kjd);
      }
      localObject1 = this.kLy;
      if (localObject1 != null) {
        com.tencent.mm.live.c.aw.a((com.tencent.mm.live.c.aw)localObject1, getRenderMode(), (kotlin.g.a.b)new d(this, paramBoolean));
      }
      localObject1 = this.kLy;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.aw)localObject1).tU(0);
      }
      Object localObject3 = this.liveCore;
      if (localObject3 != null)
      {
        localObject1 = u.kwz;
        long l = u.aOr().klE;
        localObject1 = this.kLy;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.live.c.aw)localObject1).kjc;; localObject1 = null)
        {
          com.tencent.mm.live.c.aw localaw = this.kLy;
          if (localaw != null) {
            localObject2 = localaw.aPH();
          }
          ((com.tencent.mm.live.core.core.c.c)localObject3).a(l, (TXLivePlayer)localObject1, (TXCloudVideoView)localObject2);
          AppMethodBeat.o(194020);
          return;
        }
      }
    }
    AppMethodBeat.o(194020);
  }
  
  private final RoomLiveMiniView getMiniView()
  {
    AppMethodBeat.i(193993);
    RoomLiveMiniView localRoomLiveMiniView = (RoomLiveMiniView)this.kLH.getValue();
    AppMethodBeat.o(193993);
    return localRoomLiveMiniView;
  }
  
  private final int getRenderMode()
  {
    AppMethodBeat.i(194024);
    if (isLandscape())
    {
      AppMethodBeat.o(194024);
      return 1;
    }
    AppMethodBeat.o(194024);
    return 0;
  }
  
  private final void startTimer()
  {
    AppMethodBeat.i(194013);
    this.kKL.stopTimer();
    this.kKL.startTimer(1000L);
    AppMethodBeat.o(194013);
  }
  
  public final void callback(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(194107);
    Log.i("MicroMsg.LiveCoreVisitor", "callback:".concat(String.valueOf(paramInt)));
    Object localObject4 = e.e.kjZ;
    if (paramInt == e.e.aJO())
    {
      com.tencent.mm.live.c.b.b.a(this, b.c.kzq);
      AppMethodBeat.o(194107);
      return;
    }
    localObject4 = e.e.kjZ;
    if (paramInt == e.e.aJP())
    {
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getString("live_user_id");
        paramBundle.getString("live_user_exit_reason");
        localObject3 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
        paramBundle = u.kwz;
        paramBundle = u.aPa().kyo;
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.ktN;; paramBundle = null)
        {
          Log.i("MicroMsg.LiveCoreAnchor", paramBundle);
          paramBundle = u.kwz;
          localObject3 = u.aPa().kyo;
          paramBundle = (Bundle)localObject1;
          if (localObject3 != null) {
            paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject3).ktN;
          }
          if (!p.h(localObject2, paramBundle))
          {
            paramBundle = u.kwz;
            if (!p.h(localObject2, u.aOr().TyG)) {}
          }
          else
          {
            paramBundle = u.kwz;
            paramBundle = u.aPa().kyo;
            if (paramBundle != null)
            {
              localObject1 = this.kLx;
              if (localObject1 != null)
              {
                localObject1 = ((bk)localObject1).knt;
                if (localObject1 != null) {
                  ((LivePreviewView)localObject1).clearAnimation();
                }
              }
              localObject1 = u.kwz;
              u.aPa().a(paramBundle.liveId, paramBundle.ktQ, paramBundle.ktE);
            }
          }
          paramBundle = u.kwz;
          if (p.h(localObject2, u.aOr().TyG))
          {
            this.kLG = true;
            com.tencent.mm.live.c.b.b.a(this, b.c.kzL);
          }
          AppMethodBeat.o(194107);
          return;
        }
      }
      AppMethodBeat.o(194107);
      return;
    }
    localObject1 = e.e.kjZ;
    if (paramInt == e.e.aJQ()) {
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getString("live_user_id");
        if (paramBundle.getBoolean("live_media_enable"))
        {
          paramBundle = u.kwz;
          localObject3 = u.aPa();
          if (localObject1 != null) {
            break label1243;
          }
        }
      }
    }
    label581:
    label1243:
    for (paramBundle = "";; paramBundle = (Bundle)localObject1)
    {
      ((com.tencent.mm.live.b.b.a)localObject3).kyq = paramBundle;
      localObject4 = ((com.tencent.mm.live.b.b.a)localObject3).kyo;
      paramBundle = (Bundle)localObject2;
      if (localObject4 != null) {
        paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject4).ktN;
      }
      if ((p.h(localObject1, paramBundle)) && (!((com.tencent.mm.live.b.b.a)localObject3).aPl()))
      {
        paramBundle = ((com.tencent.mm.live.b.b.a)localObject3).kyl;
        if (paramBundle != null)
        {
          paramBundle.invoke();
          AppMethodBeat.o(194107);
          return;
        }
      }
      AppMethodBeat.o(194107);
      return;
      com.tencent.mm.live.c.b.b.a(this, b.c.kzd);
      AppMethodBeat.o(194107);
      return;
      AppMethodBeat.o(194107);
      return;
      localObject1 = e.e.kjZ;
      if (paramInt == e.e.aJR())
      {
        i = this.curNetworkQuality;
        paramBundle = this.liveCore;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.knA;
          if (paramBundle == null) {}
        }
        for (paramInt = paramBundle.kmJ;; paramInt = e.m.aKH())
        {
          this.curNetworkQuality = paramInt;
          paramBundle = e.m.kkI;
          if (i == e.m.aKJ()) {
            break label581;
          }
          paramInt = this.curNetworkQuality;
          paramBundle = e.m.kkI;
          if (paramInt != e.m.aKJ()) {
            break label581;
          }
          com.tencent.mm.live.c.b.b.a(this, b.c.kzJ);
          if (this.kLx == null) {
            break;
          }
          AppMethodBeat.o(194107);
          return;
          paramBundle = e.m.kkI;
        }
        AppMethodBeat.o(194107);
        return;
        paramBundle = e.m.kkI;
        if (i == e.m.aKJ())
        {
          paramInt = this.curNetworkQuality;
          paramBundle = e.m.kkI;
          if (paramInt != e.m.aKJ())
          {
            com.tencent.mm.live.c.b.b.a(this, b.c.kzK);
            paramBundle = this.kLx;
            if (paramBundle != null) {
              paramBundle.resume();
            }
            paramBundle = com.tencent.mm.live.b.o.kvA;
            com.tencent.mm.live.b.o.aOb();
          }
        }
        AppMethodBeat.o(194107);
        return;
      }
      localObject1 = e.e.kjZ;
      long l;
      if (paramInt == e.e.aJS())
      {
        paramBundle = this.liveCore;
        int k;
        if ((paramBundle != null) && (paramBundle.knA.aLp() == true))
        {
          i = 1;
          k = this.kmi;
          paramBundle = e.b.kjz;
          if (k != e.b.aJJ()) {
            break label808;
          }
          j = 2;
        }
        for (;;)
        {
          paramBundle = u.kwz;
          localObject2 = u.aOm();
          paramBundle = u.kwz;
          l = u.aOr().klE;
          paramBundle = u.kwz;
          paramBundle = u.aPa().kyo;
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
          localObject1 = u.kwz;
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, u.aOt(), i, j, paramInt);
          AppMethodBeat.o(194107);
          return;
          paramBundle = this.liveCore;
          if ((paramBundle != null) && (paramBundle.knA.aLo() == true))
          {
            i = 2;
            break;
          }
          i = 0;
          break;
          paramBundle = e.b.kjz;
          if (k == e.b.aJK()) {
            j = 1;
          }
        }
      }
      localObject1 = e.e.kjZ;
      if (paramInt == e.e.aJU())
      {
        paramBundle = u.kwz;
        l = u.aOr().klE;
        paramBundle = u.kwz;
        paramBundle = u.aOm();
        localObject1 = u.kwz;
        localObject1 = u.aOr().Srb;
        p.j(localObject1, "RoomLiveService.liveInfo.live_name");
        new com.tencent.mm.live.b.h(l, paramBundle, (String)localObject1, (byte)0).a((kotlin.g.a.r)new b(this));
        AppMethodBeat.o(194107);
        return;
      }
      localObject1 = e.e.kjZ;
      if (paramInt == e.e.aJV())
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
        p.j(localObject1, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
        localObject4 = this.liveCore;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject4).knA;
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject4).kmC;
          }
        }
        if (!Util.isEqual((String)localObject1, (String)localObject2))
        {
          localObject2 = u.kwz;
          u.aOG().setUserId((String)localObject1);
          localObject1 = u.kwz;
          localObject1 = u.aOG();
          if (paramBundle != null)
          {
            paramInt = paramBundle.getInt("live_stream_type");
            ((u.c)localObject1).streamType = paramInt;
            localObject1 = u.kwz;
            localObject1 = u.aOG();
            if (paramBundle == null) {
              break label1126;
            }
          }
          label1126:
          for (paramInt = paramBundle.getInt("live_first_frame_width");; paramInt = 0)
          {
            ((u.c)localObject1).width = paramInt;
            localObject1 = u.kwz;
            localObject1 = u.aOG();
            paramInt = i;
            if (paramBundle != null) {
              paramInt = paramBundle.getInt("live_first_frame_height");
            }
            ((u.c)localObject1).height = paramInt;
            com.tencent.mm.live.c.b.b.a(this, b.c.kzT);
            AppMethodBeat.o(194107);
            return;
            paramInt = 0;
            break;
          }
        }
        this.kLG = false;
        AppMethodBeat.o(194107);
        return;
      }
      paramBundle = e.e.kjZ;
      if (paramInt == e.e.aJY())
      {
        com.tencent.mm.live.c.b.b.a(this, b.c.kyU);
        AppMethodBeat.o(194107);
        return;
      }
      paramBundle = e.e.kjZ;
      if (paramInt == e.e.aKa())
      {
        com.tencent.mm.live.c.b.b.a(this, b.c.kzK);
        AppMethodBeat.o(194107);
        return;
      }
      paramBundle = e.e.kjZ;
      if (paramInt == e.e.aKb())
      {
        com.tencent.mm.live.c.b.b.a(this, b.c.kzI);
        AppMethodBeat.o(194107);
        return;
      }
      paramBundle = e.e.kjZ;
      if (paramInt == e.e.aKc()) {
        com.tencent.mm.live.c.b.b.a(this, b.c.kzJ);
      }
      AppMethodBeat.o(194107);
      return;
    }
  }
  
  public final int getLiveRole()
  {
    return 0;
  }
  
  public final int getRelativeLayoutId()
  {
    return b.f.live_visitor_ui;
  }
  
  public final void initLogic(LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(194004);
    p.k(paramLiveConfig, "config");
    Object localObject1 = com.tencent.mm.live.core.core.c.c.kqq;
    this.liveCore = c.a.aMm();
    localObject1 = this.liveCore;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.c.c)localObject1).a((AbsLiveMiniView)getMiniView());
    }
    localObject1 = this.liveCore;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.trtc.a)localObject1).kny = ((com.tencent.mm.live.core.core.c)this);
    }
    localObject1 = u.kwz;
    localObject1 = paramLiveConfig.aJg();
    p.j(localObject1, "config.hostRoomId");
    u.Ob((String)localObject1);
    localObject1 = u.kwz;
    u.a(new crq());
    localObject1 = u.kwz;
    u.aOr().klE = paramLiveConfig.getLiveId();
    localObject1 = u.kwz;
    u.Oc(paramLiveConfig.aJi());
    localObject1 = u.kwz;
    localObject1 = paramLiveConfig.aJk();
    p.j(localObject1, "config.anchorUsername");
    u.Od((String)localObject1);
    localObject1 = u.kwz;
    u.aOr().ROp = true;
    localObject1 = findViewById(b.e.live_right_panel_ui_root);
    p.j(localObject1, "findViewById(R.id.live_right_panel_ui_root)");
    this.kLz = new com.tencent.mm.live.c.v((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_title_ui_root);
    p.j(localObject1, "findViewById(R.id.live_title_ui_root)");
    this.kKp = new ay((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_visitor_comment_root);
    p.j(localObject1, "findViewById(R.id.live_visitor_comment_root)");
    this.kLB = new bg((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_input_ui_root);
    p.j(localObject1, "findViewById(R.id.live_input_ui_root)");
    this.kLA = new com.tencent.mm.live.c.z((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_after_ui_root);
    p.j(localObject1, "findViewById(R.id.live_after_ui_root)");
    this.kKk = new com.tencent.mm.live.c.c((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_input_debug_view_root);
    p.j(localObject1, "findViewById(R.id.live_input_debug_view_root)");
    this.kLC = new com.tencent.mm.live.c.q((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_loading_view_root);
    p.j(localObject1, "findViewById(R.id.live_loading_view_root)");
    this.kKx = new ae((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_comment_ui_root);
    p.j(localObject1, "findViewById(R.id.live_comment_ui_root)");
    this.kKn = new com.tencent.mm.live.c.m((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_members_list_ui_root);
    p.j(localObject1, "findViewById(R.id.live_members_list_ui_root)");
    this.kKq = new ai((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_like_confetti_ui_root);
    p.j(localObject1, "findViewById(R.id.live_like_confetti_ui_root)");
    this.kKz = new ac((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_mic_visitor_header_root);
    p.j(localObject1, "findViewById(R.id.live_mic_visitor_header_root)");
    this.kKy = new ak((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_preview_ui_root);
    p.j(localObject1, "findViewById(R.id.live_preview_ui_root)");
    this.kLx = new bk((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_tx_live_player_ui_root);
    p.j(localObject1, "findViewById(R.id.live_tx_live_player_ui_root)");
    this.kLy = new com.tencent.mm.live.c.aw((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_shadow_ui_root);
    p.j(localObject1, "findViewById(R.id.live_shadow_ui_root)");
    this.kKm = new as((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_video_mic_ui_root);
    p.j(localObject1, "findViewById(R.id.live_video_mic_ui_root)");
    this.kLD = new bc((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_members_profile_ui_root);
    p.j(localObject1, "findViewById(R.id.live_members_profile_ui_root)");
    this.kKA = new ag((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_kicked_ui_root);
    p.j(localObject1, "findViewById(R.id.live_kicked_ui_root)");
    this.kLE = new ab((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_visitor_close_ui_root);
    p.j(localObject1, "findViewById(R.id.live_visitor_close_ui_root)");
    this.kLF = new be((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_common_info_ui_root);
    p.j(localObject1, "findViewById(R.id.live_common_info_ui_root)");
    this.kKu = new com.tencent.mm.live.c.o((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_exception_ui_root);
    p.j(localObject1, "findViewById(R.id.live_exception_ui_root)");
    this.kKC = new com.tencent.mm.live.c.r((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_face_verify_ui_root);
    p.j(localObject1, "findViewById(R.id.live_face_verify_ui_root)");
    this.kKi = new com.tencent.mm.live.c.t((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(b.e.live_minimize_ui_root);
    p.j(localObject1, "findViewById(R.id.live_minimize_ui_root)");
    this.kKv = new am((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    Object localObject2 = this.kLx;
    if (localObject2 != null)
    {
      localObject1 = this.kLD;
      if (localObject1 != null)
      {
        localObject1 = ((bc)localObject1).aPJ();
        ((bk)localObject2).kHZ = ((n)localObject1);
      }
    }
    else
    {
      localObject1 = com.tencent.mm.live.b.o.kvA;
      com.tencent.mm.live.b.o.a(paramLiveConfig);
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
      localObject2 = this.kKp;
      if (localObject2 != null)
      {
        localObject1 = u.kwz;
        localObject1 = u.aOr().Srb;
        if (localObject1 == null) {
          break label1784;
        }
        localObject1 = (CharSequence)localObject1;
        label1116:
        u localu = u.kwz;
        ((ay)localObject2).a((CharSequence)localObject1, u.aOt());
      }
      localObject1 = this.kKq;
      if (localObject1 != null) {
        ((ai)localObject1).a(paramLiveConfig);
      }
      localObject1 = this.kKA;
      if (localObject1 != null) {
        ((ag)localObject1).a(paramLiveConfig);
      }
      localObject1 = this.kKu;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.o)localObject1).aPy();
      }
      localObject1 = this.kLy;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.core.core.c.c.kqq;
        ((com.tencent.mm.live.c.aw)localObject1).liveCore = c.a.aMm();
      }
      localObject2 = this.kLD;
      if (localObject2 != null)
      {
        p.k(paramLiveConfig, "config");
        if (paramLiveConfig.aJf() != LiveConfig.khW) {
          break label1795;
        }
        localObject1 = com.tencent.mm.live.core.core.a.b.klq;
        localObject1 = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.b.aLh();
        label1246:
        ((bc)localObject2).kHp = ((com.tencent.mm.live.core.core.trtc.a)localObject1);
      }
      localObject1 = this.kKu;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.o)localObject1).tU(8);
      }
      localObject1 = this.kLF;
      if (localObject1 != null) {
        ((be)localObject1).tU(8);
      }
      localObject1 = this.kKk;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.c)localObject1).tU(8);
      }
      localObject1 = this.kLB;
      if (localObject1 != null) {
        ((bg)localObject1).tU(8);
      }
      localObject1 = this.kLA;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.z)localObject1).tU(8);
      }
      localObject1 = this.kLz;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.v)localObject1).tU(8);
      }
      localObject1 = this.kKq;
      if (localObject1 != null) {
        ((ai)localObject1).tU(8);
      }
      localObject1 = this.kKx;
      if (localObject1 != null) {
        ((ae)localObject1).On(paramLiveConfig.aJk());
      }
      localObject1 = this.kLx;
      if (localObject1 != null) {
        ((bk)localObject1).tU(0);
      }
      localObject1 = this.kLy;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.aw)localObject1).tU(8);
      }
      localObject1 = this.kKm;
      if (localObject1 != null) {
        ((as)localObject1).tU(8);
      }
      localObject1 = this.kLD;
      if (localObject1 != null) {
        ((bc)localObject1).tU(8);
      }
      localObject1 = this.kKA;
      if (localObject1 != null) {
        ((ag)localObject1).tU(8);
      }
      localObject1 = this.kLE;
      if (localObject1 != null) {
        ((ab)localObject1).tU(8);
      }
      localObject1 = this.kKC;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.r)localObject1).tU(8);
      }
      localObject1 = this.kKi;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.t)localObject1).tU(8);
      }
      localObject2 = this.kLx;
      if (localObject2 != null)
      {
        localObject1 = (kotlin.g.a.m)new k(this);
        localObject2 = ((bk)localObject2).knt;
        if (localObject2 != null) {
          ((LivePreviewView)localObject2).setPreviewTouchListener((kotlin.g.a.m)localObject1);
        }
      }
      localObject1 = this.kLy;
      if (localObject1 != null)
      {
        localObject2 = (kotlin.g.a.m)new l(this);
        ((com.tencent.mm.live.c.aw)localObject1).kHa.setPreviewTouchListener((kotlin.g.a.m)localObject2);
      }
      if (paramLiveConfig.getScene() == LiveConfig.khU)
      {
        paramLiveConfig = this.kKk;
        if (paramLiveConfig != null)
        {
          paramLiveConfig.kCH.setVisibility(8);
          paramLiveConfig.kCG.setVisibility(0);
        }
      }
      paramLiveConfig = u.kwz;
      u.aPa().kyi = ((kotlin.g.a.b)new m(this));
      paramLiveConfig = j.kue;
      j.e(name(), (kotlin.g.a.a)new n(this));
      if (!LiveConfig.aJr()) {
        break label1811;
      }
      paramLiveConfig = findViewById(b.e.live_face_verify_ui_root);
      p.j(paramLiveConfig, "findViewById(R.id.live_face_verify_ui_root)");
      this.kKi = new com.tencent.mm.live.c.t((RelativeLayout)paramLiveConfig, (com.tencent.mm.live.c.b)this);
      statusChange(b.c.kzU, new Bundle());
      LiveConfig.eS(false);
    }
    for (;;)
    {
      paramLiveConfig = j.kue;
      j.d(name(), this.liveMessageCallback);
      AppMethodBeat.o(194004);
      return;
      localObject1 = null;
      break;
      label1784:
      localObject1 = (CharSequence)"";
      break label1116;
      label1795:
      localObject1 = com.tencent.mm.live.core.core.c.c.kqq;
      localObject1 = (com.tencent.mm.live.core.core.trtc.a)c.a.aMm();
      break label1246;
      label1811:
      paramLiveConfig = com.tencent.mm.kernel.h.aHG();
      p.j(paramLiveConfig, "MMKernel.storage()");
      if (paramLiveConfig.aHp().getInt(ar.a.VCz, 0) == 1)
      {
        paramLiveConfig = this.kLC;
        if (paramLiveConfig != null) {
          paramLiveConfig.tU(0);
        }
      }
      else
      {
        paramLiveConfig = u.kwz;
        if (u.getLastOrientation() != -1)
        {
          paramLiveConfig = u.kwz;
          i = u.getLastOrientation();
          paramLiveConfig = getContext().getSystemService("window");
          if (paramLiveConfig == null)
          {
            paramLiveConfig = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(194004);
            throw paramLiveConfig;
          }
          paramLiveConfig = ((WindowManager)paramLiveConfig).getDefaultDisplay();
          p.j(paramLiveConfig, "((context.getSystemServi…owManager).defaultDisplay");
          if (i != paramLiveConfig.getRotation()) {}
        }
        else
        {
          paramLiveConfig = u.kwz;
          localObject1 = u.aOr().Srb;
          paramLiveConfig = (LiveConfig)localObject1;
          if (localObject1 == null) {
            paramLiveConfig = "";
          }
          localObject1 = u.kwz;
          long l = u.aOr().klE;
          localObject1 = u.kwz;
          a(paramLiveConfig, l, u.aOm());
          continue;
        }
        paramLiveConfig = u.kwz;
        if (u.aOD().kwH)
        {
          com.tencent.mm.live.c.b.b.a(this, b.c.kzn);
        }
        else
        {
          paramLiveConfig = this.liveCore;
          if (paramLiveConfig != null)
          {
            paramLiveConfig = paramLiveConfig.knA;
            if ((paramLiveConfig != null) && (paramLiveConfig.aLo() == true)) {}
          }
          else
          {
            paramLiveConfig = this.liveCore;
            if (paramLiveConfig == null) {
              break label2072;
            }
            paramLiveConfig = paramLiveConfig.knA;
            if ((paramLiveConfig == null) || (paramLiveConfig.aLp() != true)) {
              break label2072;
            }
          }
          com.tencent.mm.live.c.b.b.a(this, b.c.kyU);
        }
      }
    }
    label2072:
    paramLiveConfig = u.kwz;
    paramLiveConfig = u.aOv();
    if (paramLiveConfig != null)
    {
      paramLiveConfig = paramLiveConfig.kjd;
      if (paramLiveConfig == null) {}
    }
    for (int i = paramLiveConfig.kmi;; i = e.b.aJK())
    {
      this.kmi = i;
      fw(true);
      paramLiveConfig = u.kwz;
      if (!u.aOE().kwE) {
        break;
      }
      paramLiveConfig = this.kKi;
      if (paramLiveConfig != null) {
        paramLiveConfig.tU(0);
      }
      statusChange(b.c.kyQ, new Bundle());
      paramLiveConfig = u.kwz;
      u.aOE().kwE = false;
      break;
      paramLiveConfig = e.b.kjz;
    }
  }
  
  public final boolean isLiving()
  {
    AppMethodBeat.i(194094);
    Object localObject = this.liveCore;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.model.h)localObject).isLiving() == true))
      {
        AppMethodBeat.o(194094);
        return true;
      }
    }
    AppMethodBeat.o(194094);
    return false;
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(194103);
    super.keyboardChange(paramBoolean, paramInt);
    AppMethodBeat.o(194103);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(194088);
    super.mount();
    com.tencent.mm.kernel.c localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().a(3806, (i)this);
    AppMethodBeat.o(194088);
  }
  
  public final String name()
  {
    AppMethodBeat.i(194069);
    String str = LiveVisitorPluginLayout.class.getSimpleName();
    p.j(str, "LiveVisitorPluginLayout::class.java.simpleName");
    AppMethodBeat.o(194069);
    return str;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(194098);
    boolean bool2 = super.onBackPress();
    boolean bool1 = bool2;
    if (!bool2)
    {
      u localu = u.kwz;
      bool1 = bool2;
      if (u.aOD().kwI)
      {
        localu = u.kwz;
        u.aOD().kwI = false;
        com.tencent.mm.live.c.b.b.a(this, b.c.kyV);
        bool1 = true;
      }
    }
    AppMethodBeat.o(194098);
    return bool1;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(194010);
    p.k(paramString, "incomingNumber");
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.liveCore;
    if (paramString != null)
    {
      paramString = paramString.knA;
      if (paramString != null)
      {
        paramString = Boolean.valueOf(paramString.isFloatMode());
        Log.i("MicroMsg.LiveCoreVisitor", paramString);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(194010);
      return;
      paramString = null;
      break;
      AppMethodBeat.o(194010);
      return;
      paramString = com.tencent.mm.live.b.o.kvA;
      com.tencent.mm.live.b.o.aNZ();
      paramString = u.kwz;
      u.aOy();
      paramString = this.liveCore;
      if ((paramString != null) && (paramString.knA.aLo() == true))
      {
        paramString = this.liveCore;
        if (paramString != null) {
          paramString.aJx();
        }
      }
      paramString = u.kwz;
      u.aPi();
    }
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean)
  {
    this.kKH = paramBoolean;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(194102);
    Log.i("MicroMsg.LiveCoreVisitor", "errType:" + paramInt1 + " errCode:" + paramInt2);
    if (((paramq instanceof com.tencent.mm.live.b.a.b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.kLB;
      if (paramString != null) {
        paramString.aPK();
      }
      paramq = this.kKp;
      if (paramq != null)
      {
        paramString = u.kwz;
        paramString = u.aOr().Srb;
        if (paramString == null) {
          break label145;
        }
        paramString = (CharSequence)paramString;
        u localu = u.kwz;
        paramq.a(paramString, u.aOt());
      }
      paramString = u.kwz;
      paramString = u.kwz;
      if (u.aOr().ROp) {
        break label155;
      }
    }
    label145:
    label155:
    for (paramInt1 = cm.bfF();; paramInt1 = 0)
    {
      u.tI(paramInt1);
      AppMethodBeat.o(194102);
      return;
      paramString = (CharSequence)"";
      break;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(194086);
    super.pause();
    Object localObject1 = u.kwz;
    if (u.getLastOrientation() != -1)
    {
      localObject1 = u.kwz;
      int i = u.getLastOrientation();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(194086);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.j(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
      if (i == ((Display)localObject1).getRotation()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new StringBuilder("orientationChanged:").append(bool).append(", ");
      localObject2 = getContext().getSystemService("window");
      if (localObject2 != null) {
        break;
      }
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(194086);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
    p.j(localObject2, "((context.getSystemServi…owManager).defaultDisplay");
    Log.i("MicroMsg.LiveCoreVisitor", ((Display)localObject2).getRotation());
    if (!bool)
    {
      localObject1 = u.kwz;
      if (!u.aOD().kwH)
      {
        localObject1 = u.kwz;
        if (!u.aOD().kwJ)
        {
          localObject1 = u.kwz;
          if (!u.aOD().kwK)
          {
            localObject1 = u.kwz;
            if (u.aOD().kwI)
            {
              localObject1 = u.kwz;
              if ((!u.isManualClosed()) && (com.tencent.mm.compatible.e.b.ct(getContext())))
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 3);
                statusChange(b.c.kzi, (Bundle)localObject1);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = this.liveCore;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
      if (localObject1 == null) {
        break;
      }
      if (((com.tencent.mm.live.core.core.model.h)localObject1).aLo() != true) {
        break label386;
      }
      localObject1 = this.liveCore;
      if (localObject1 == null) {
        break label386;
      }
      ((com.tencent.mm.live.core.core.c.c)localObject1).aJx();
      AppMethodBeat.o(194086);
      return;
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.model.h)localObject1).aLl() == true))
        {
          localObject1 = this.liveCore;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.c.c)localObject1).aMi();
          }
        }
      }
    }
    AppMethodBeat.o(194086);
    return;
    label386:
    AppMethodBeat.o(194086);
  }
  
  public final void resume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(194083);
    Object localObject1 = u.kwz;
    u.aOD().kwK = false;
    localObject1 = getContext().getSystemService("window");
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(194083);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
    p.j(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
    int j = ((Display)localObject1).getRotation();
    localObject1 = new StringBuilder("curOrientation:").append(j).append(", lastOrientation:");
    Object localObject3 = u.kwz;
    Log.i("MicroMsg.LiveCoreVisitor", u.getLastOrientation());
    super.resume();
    localObject1 = this.liveCore;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
      if ((localObject1 != null) && (((com.tencent.mm.live.core.core.model.h)localObject1).aLl() == true))
      {
        localObject1 = this.liveCore;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.c)localObject1).aMj();
        }
      }
    }
    localObject1 = u.kwz;
    Object localObject4;
    int i;
    if (u.getLastOrientation() != -1)
    {
      localObject1 = u.kwz;
      if (j != u.getLastOrientation())
      {
        localObject1 = this.liveCore;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.c)localObject1).aJz();
        }
        localObject3 = this.liveCore;
        if (localObject3 != null)
        {
          String str;
          if (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.live.core.core.trtc.a)localObject3).knA.kmC))
          {
            localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject3).knm;
            str = ((com.tencent.mm.live.core.core.trtc.a)localObject3).knA.kmC;
            localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject3).knt;
            if (localObject1 == null) {
              break label568;
            }
            localObject1 = ((LivePreviewView)localObject1).ap(((com.tencent.mm.live.core.core.trtc.a)localObject3).knA.kmC, 0);
            ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject4).a(str, (TXCloudVideoView)localObject1);
            ((com.tencent.mm.live.core.core.trtc.a)localObject3).knm.muteRemoteAudio(((com.tencent.mm.live.core.core.trtc.a)localObject3).knA.kmC, false);
          }
          if (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.live.core.core.trtc.a)localObject3).knA.kmE))
          {
            localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject3).knm;
            str = ((com.tencent.mm.live.core.core.trtc.a)localObject3).knA.kmE;
            LivePreviewView localLivePreviewView = ((com.tencent.mm.live.core.core.trtc.a)localObject3).knt;
            localObject1 = localObject2;
            if (localLivePreviewView != null) {
              localObject1 = localLivePreviewView.ap(((com.tencent.mm.live.core.core.trtc.a)localObject3).knA.kmE, 0);
            }
            ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject4).a(str, (TXCloudVideoView)localObject1);
            ((com.tencent.mm.live.core.core.trtc.a)localObject3).knm.muteRemoteAudio(((com.tencent.mm.live.core.core.trtc.a)localObject3).knA.kmC, false);
          }
          if (((com.tencent.mm.live.core.core.trtc.a)localObject3).knA.aLo())
          {
            localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject3).knt;
            if (localObject1 != null) {
              ((LivePreviewView)localObject1).a((kotlin.g.a.q)new c.f((com.tencent.mm.live.core.core.c.c)localObject3));
            }
          }
        }
        localObject1 = this.kLx;
        if (localObject1 != null)
        {
          localObject2 = u.kwz;
          if (!u.aOG().isLandscape()) {
            break label573;
          }
          i = 2;
          label441:
          localObject2 = u.kwz;
          localObject2 = u.aOG().userId;
          localObject3 = u.kwz;
          ((bk)localObject1).c(i, (String)localObject2, u.aOG().streamType);
        }
      }
    }
    for (;;)
    {
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.model.h)localObject1).aLo() == true))
        {
          localObject2 = this.kLx;
          if (localObject2 != null)
          {
            localObject1 = ((bk)localObject2).liveCore;
            if (localObject1 != null)
            {
              localObject2 = ((bk)localObject2).knt;
              localObject3 = u.kwz;
              localObject3 = u.aOk();
              localObject4 = u.kwz;
              ((com.tencent.mm.live.core.core.c.c)localObject1).a((LivePreviewView)localObject2, (com.tencent.mm.live.core.b.a)localObject3, u.aOl());
            }
          }
        }
      }
      localObject1 = u.kwz;
      u.setLastOrientation(j);
      AppMethodBeat.o(194083);
      return;
      label568:
      localObject1 = null;
      break;
      label573:
      i = 1;
      break label441;
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
        if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.model.h)localObject1).kmv))
        {
          localObject1 = this.liveCore;
          if (localObject1 == null) {
            continue;
          }
          ((com.tencent.mm.live.core.core.c.c)localObject1).aJz();
          continue;
        }
      }
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.model.h)localObject1).kmv = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(194076);
    super.start();
    Object localObject = com.tencent.mm.live.b.o.kvA;
    com.tencent.mm.live.b.o.aOb();
    localObject = this.liveCore;
    if (((localObject == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject).knA.aLo() != true)) && (this.kKH))
    {
      localObject = u.kwz;
      if (!u.aOD().kwH)
      {
        localObject = u.kwz;
        if (!u.aOD().kwJ)
        {
          localObject = getContext();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(194076);
            throw ((Throwable)localObject);
          }
          ((Activity)localObject).setRequestedOrientation(4);
        }
      }
    }
    startTimer();
    AppMethodBeat.o(194076);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(194067);
    p.k(paramc, "status");
    Log.i("MicroMsg.LiveCoreVisitor", "statusChange:" + paramc.name());
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(194067);
      return;
      Object localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      Object localObject2 = u.kwz;
      ((com.tencent.mm.live.b.c.c)localObject1).Oj(u.aOm());
      localObject1 = com.tencent.mm.live.d.e.kIm;
      com.tencent.mm.live.d.e.aQI().rr(System.currentTimeMillis());
      localObject1 = com.tencent.mm.live.d.e.kIm;
      localObject1 = com.tencent.mm.live.d.e.aQI();
      localObject2 = com.tencent.mm.live.d.e.kIm;
      long l = com.tencent.mm.live.d.e.aQI().alE();
      localObject2 = com.tencent.mm.live.d.e.kIm;
      ((hh)localObject1).rp((l - com.tencent.mm.live.d.e.aQI().alD()) / 1000L);
      localObject1 = com.tencent.mm.live.d.e.kIm;
      localObject1 = com.tencent.mm.live.d.e.aQI();
      localObject2 = u.kwz;
      ((hh)localObject1).rs(com.tencent.mm.model.v.Pu(u.aOm()));
      localObject1 = u.kwz;
      localObject1 = u.aOm();
      localObject2 = u.kwz;
      l = u.aOr().klE;
      localObject2 = u.kwz;
      i = u.aON();
      localObject2 = u.kwz;
      j = u.aOP();
      localObject2 = u.kwz;
      int k = u.aOr().SOs;
      localObject2 = u.kwz;
      int m = u.aOQ();
      localObject2 = u.kwz;
      int n = u.aOR();
      localObject2 = u.kwz;
      int i1 = u.aOS();
      localObject2 = u.kwz;
      int i2 = u.aOT();
      localObject2 = u.kwz;
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, u.aOr().TyH);
      localObject1 = u.kwz;
      u.aOy();
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(194067);
        throw paramc;
      }
      ((Activity)localObject1).finishAndRemoveTask();
      continue;
      localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      localObject2 = u.kwz;
      ((com.tencent.mm.live.b.c.c)localObject1).Oj(u.aOm());
      localObject1 = com.tencent.mm.live.d.e.kIm;
      com.tencent.mm.live.d.e.aQI().rr(System.currentTimeMillis());
      localObject1 = com.tencent.mm.live.d.e.kIm;
      localObject1 = com.tencent.mm.live.d.e.aQI();
      localObject2 = com.tencent.mm.live.d.e.kIm;
      l = com.tencent.mm.live.d.e.aQI().alE();
      localObject2 = com.tencent.mm.live.d.e.kIm;
      ((hh)localObject1).rp((l - com.tencent.mm.live.d.e.aQI().alD()) / 1000L);
      localObject1 = com.tencent.mm.live.d.e.kIm;
      localObject1 = com.tencent.mm.live.d.e.aQI();
      localObject2 = u.kwz;
      ((hh)localObject1).rs(com.tencent.mm.model.v.Pu(u.aOm()));
      localObject1 = u.kwz;
      localObject1 = u.aOm();
      localObject2 = u.kwz;
      l = u.aOr().klE;
      localObject2 = u.kwz;
      i = u.aON();
      localObject2 = u.kwz;
      j = u.aOP();
      localObject2 = u.kwz;
      k = u.aOr().SOs;
      localObject2 = u.kwz;
      m = u.aOQ();
      localObject2 = u.kwz;
      n = u.aOR();
      localObject2 = u.kwz;
      i1 = u.aOS();
      localObject2 = u.kwz;
      i2 = u.aOT();
      localObject2 = u.kwz;
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, u.aOr().TyH);
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.core.core.c.c)localObject1).aJB();
        localObject1 = x.aazN;
      }
      localObject1 = u.kwz;
      u.aOy();
      localObject1 = u.kwz;
      u.aPh();
      localObject1 = com.tencent.mm.live.b.o.kvA;
      com.tencent.mm.live.b.o.aOb();
      continue;
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.core.core.c.c)localObject1).aJB();
        localObject1 = x.aazN;
      }
      localObject1 = u.kwz;
      u.aPh();
      localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      localObject2 = u.kwz;
      ((com.tencent.mm.live.b.c.c)localObject1).FM(u.aOr().klE);
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(194067);
        throw paramc;
      }
      ((Activity)localObject1).setRequestedOrientation(1);
      continue;
      if (paramBundle != null) {}
      for (localObject1 = Boolean.valueOf(paramBundle.getBoolean("PARAM_LIVE_START_BY_ORIENTATION_CHANGE", false));; localObject1 = null)
      {
        if (p.h(localObject1, Boolean.FALSE))
        {
          this.kKI.bct();
          com.tencent.mm.live.b.o.kvA.aOd();
          localObject1 = com.tencent.mm.live.b.o.kvA;
          com.tencent.mm.live.b.o.aNY();
          localObject1 = com.tencent.mm.live.b.o.kvA;
          com.tencent.mm.live.b.o.aOc();
        }
        localObject1 = u.kwz;
        u.aPf();
        localObject1 = u.kwz;
        u.fs(false);
        startTimer();
        localObject1 = com.tencent.mm.live.d.e.kIm;
        com.tencent.mm.live.d.e.aQI().rq(System.currentTimeMillis());
        break;
      }
      localObject1 = u.kwz;
      if (!u.aOD().kwH)
      {
        localObject1 = u.kwz;
        if (!u.aOD().kwJ)
        {
          localObject1 = this.kKq;
          if (localObject1 != null)
          {
            ((ai)localObject1).tU(0);
            localObject1 = x.aazN;
          }
          localObject1 = this.kKq;
          if (localObject1 != null)
          {
            ((ai)localObject1).aPD();
            localObject1 = x.aazN;
            continue;
            localObject1 = j.kue;
            j.aNy();
            com.tencent.mm.live.b.o.kvA.release();
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(194067);
              throw paramc;
            }
            ((Activity)localObject1).finishAndRemoveTask();
            continue;
            localObject1 = u.kwz;
            localObject1 = u.aOr().Srb;
            p.j(localObject1, "RoomLiveService.liveInfo.live_name");
            localObject2 = u.kwz;
            l = u.aOr().klE;
            localObject2 = u.kwz;
            a((String)localObject1, l, u.aOm());
            continue;
            localObject2 = this.kLx;
            if (localObject2 != null)
            {
              localObject1 = this.kLD;
              if (localObject1 == null) {
                break label1202;
              }
            }
            label1202:
            for (localObject1 = ((bc)localObject1).aPJ();; localObject1 = null)
            {
              ((bk)localObject2).kHZ = ((n)localObject1);
              getMiniView().fx(false);
              break;
            }
            if (this.kKH)
            {
              localObject1 = getContext();
              if (localObject1 == null)
              {
                paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(194067);
                throw paramc;
              }
              ((Activity)localObject1).setRequestedOrientation(4);
            }
            getMiniView().fx(false);
            continue;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(194067);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(14);
            getMiniView().fx(false);
            continue;
            getMiniView().fx(true);
            localObject1 = u.kwz;
            localObject1 = u.aOv();
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.live.core.core.model.g)localObject1).kmp;
              if (localObject1 != null) {
                ((com.tencent.mm.live.core.core.model.e)localObject1).kme = true;
              }
            }
            if (this.kKH)
            {
              localObject1 = getContext();
              if (localObject1 == null)
              {
                paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(194067);
                throw paramc;
              }
              ((Activity)localObject1).setRequestedOrientation(4);
            }
            i = this.kmi;
            localObject1 = e.b.kjz;
            if (i == e.b.aJK())
            {
              localObject1 = this.kLx;
              if (localObject1 != null)
              {
                ((bk)localObject1).exitRoom();
                localObject1 = x.aazN;
              }
              localObject1 = this.kLy;
              if (localObject1 != null)
              {
                ((com.tencent.mm.live.c.aw)localObject1).tU(0);
                localObject1 = x.aazN;
              }
              localObject1 = this.kLy;
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.live.c.aw)localObject1).kjc;
                if (localObject1 != null) {
                  ((TXLivePlayer)localObject1).resume();
                }
                localObject1 = x.aazN;
              }
            }
            localObject1 = this.kKy;
            if (localObject1 != null)
            {
              this.kKF.remove(localObject1);
              continue;
              localObject1 = this.kKy;
              if (localObject1 != null)
              {
                this.kKF.remove(localObject1);
                continue;
                getMiniView().fx(false);
                i = this.kmi;
                localObject1 = e.b.kjz;
                if (i == e.b.aJJ())
                {
                  aRp();
                }
                else
                {
                  localObject1 = e.b.kjz;
                  if (i == e.b.aJK())
                  {
                    localObject1 = u.kwz;
                    localObject1 = u.aOv();
                    if (localObject1 != null)
                    {
                      localObject2 = this.kLx;
                      if (localObject2 != null)
                      {
                        ((bk)localObject2).a((com.tencent.mm.live.core.core.model.g)localObject1, (kotlin.g.a.b)new q(this));
                        localObject1 = x.aazN;
                        continue;
                        localObject1 = u.kwz;
                        u.aPg();
                        localObject1 = com.tencent.mm.live.b.o.kvA;
                        com.tencent.mm.live.b.o.aNZ();
                        localObject1 = j.kue;
                        j.aNy();
                        com.tencent.mm.live.b.o.kvA.release();
                        localObject1 = this.kKp;
                        if (localObject1 != null)
                        {
                          ((ay)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kKm;
                        if (localObject1 != null)
                        {
                          ((as)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kKk;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.c.c)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kLB;
                        if (localObject1 != null)
                        {
                          ((bg)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kLA;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.c.z)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kLz;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.c.v)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kKq;
                        if (localObject1 != null)
                        {
                          ((ai)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kKx;
                        if (localObject1 != null)
                        {
                          ((ae)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kLx;
                        if (localObject1 != null)
                        {
                          ((bk)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kLy;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.c.aw)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kLD;
                        if (localObject1 != null)
                        {
                          ((bc)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kKA;
                        if (localObject1 != null)
                        {
                          ((ag)localObject1).tU(8);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kLE;
                        if (localObject1 != null)
                        {
                          ((ab)localObject1).tU(0);
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kLE;
                        Object localObject3;
                        if (localObject1 != null)
                        {
                          localObject2 = u.kwz;
                          localObject2 = u.aOt();
                          localObject3 = com.tencent.mm.live.b.d.a.kyA;
                          localObject3 = ((com.tencent.mm.live.c.a)localObject1).kiF.getContext();
                          p.j(localObject3, "root.context");
                          com.tencent.mm.live.b.d.a.a.b((String)localObject2, ((Context)localObject3).getResources().getColor(com.tencent.mm.live.b.b.half_alpha_black), (kotlin.g.a.b)new ab.a((ab)localObject1));
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.liveCore;
                        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).knA.aLo() != true))
                        {
                          localObject1 = this.liveCore;
                          if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).knA.aLp() != true))
                          {
                            i = this.kmi;
                            localObject1 = e.b.kjz;
                            if (i != e.b.aJJ()) {
                              break label2152;
                            }
                          }
                        }
                        localObject1 = this.liveCore;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.core.core.c.c)localObject1).aMi();
                          localObject1 = x.aazN;
                        }
                        localObject1 = this.kLx;
                        if (localObject1 != null)
                        {
                          ((bk)localObject1).exitRoom();
                          localObject1 = x.aazN;
                          continue;
                          label2152:
                          localObject1 = this.kLy;
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.live.c.aw)localObject1).eT(false);
                            localObject1 = x.aazN;
                            continue;
                            localObject1 = u.kwz;
                            u.tK(2);
                            localObject1 = u.kwz;
                            if (!u.aOD().kwH)
                            {
                              localObject1 = u.kwz;
                              if (!u.aOD().kwJ)
                              {
                                localObject1 = this.kKx;
                                if (localObject1 != null)
                                {
                                  localObject2 = u.kwz;
                                  localObject2 = u.aOt();
                                  localObject3 = getContext();
                                  p.j(localObject3, "context");
                                  localObject3 = ((Context)localObject3).getResources().getString(b.h.live_local_network_error_tip);
                                  p.j(localObject3, "context.resources.getStr…_local_network_error_tip)");
                                  ((ae)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
                                  localObject1 = x.aazN;
                                }
                                localObject1 = u.kwz;
                                u.aPg();
                                continue;
                                localObject1 = u.kwz;
                                u.tK(1);
                                localObject1 = u.kwz;
                                if (!u.aOD().kwH)
                                {
                                  localObject1 = u.kwz;
                                  if (!u.aOD().kwJ)
                                  {
                                    localObject1 = this.kKx;
                                    if (localObject1 != null)
                                    {
                                      localObject2 = u.kwz;
                                      localObject2 = u.aOt();
                                      localObject3 = getContext();
                                      p.j(localObject3, "context");
                                      localObject3 = ((Context)localObject3).getResources().getString(b.h.live_anchor_exception_tip);
                                      p.j(localObject3, "context.resources.getStr…ive_anchor_exception_tip)");
                                      ((ae)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
                                      localObject1 = x.aazN;
                                      continue;
                                      localObject1 = this.kLx;
                                      if (localObject1 != null)
                                      {
                                        ((bk)localObject1).tU(0);
                                        localObject1 = x.aazN;
                                      }
                                      localObject1 = this.kLx;
                                      if (localObject1 != null)
                                      {
                                        ((bk)localObject1).aPO();
                                        localObject1 = x.aazN;
                                      }
                                      localObject1 = this.kLy;
                                      if (localObject1 != null)
                                      {
                                        ((com.tencent.mm.live.c.aw)localObject1).tU(8);
                                        localObject1 = x.aazN;
                                      }
                                      localObject1 = this.kLy;
                                      if (localObject1 != null)
                                      {
                                        localObject1 = ((com.tencent.mm.live.c.aw)localObject1).kjc;
                                        if (localObject1 != null) {
                                          ((TXLivePlayer)localObject1).pause();
                                        }
                                        localObject1 = x.aazN;
                                        continue;
                                        localObject1 = this.kKx;
                                        if (localObject1 != null)
                                        {
                                          ((ae)localObject1).tU(8);
                                          localObject1 = x.aazN;
                                          continue;
                                          localObject1 = this.liveCore;
                                          if (localObject1 != null)
                                          {
                                            localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
                                            if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.model.h)localObject1).isFloatMode()))
                                            {
                                              localObject1 = this.liveCore;
                                              if (localObject1 != null)
                                              {
                                                localObject2 = getContext();
                                                p.j(localObject2, "context");
                                                b.a.a((com.tencent.mm.live.core.core.b)localObject1, (Context)localObject2, false, false, 0, 0, null, 62);
                                              }
                                              localObject1 = u.kwz;
                                              localObject1 = u.aOm();
                                              localObject2 = u.kwz;
                                              l = u.aOr().klE;
                                              localObject2 = u.kwz;
                                              localObject2 = u.aOt();
                                              localObject3 = u.kwz;
                                              com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 1, u.aOr().SOs);
                                              com.tencent.mm.live.d.f.aQO();
                                              continue;
                                              localObject1 = u.kwz;
                                              localObject1 = u.aOm();
                                              localObject2 = u.kwz;
                                              l = u.aOr().klE;
                                              localObject2 = u.kwz;
                                              localObject2 = u.aOt();
                                              localObject3 = u.kwz;
                                              com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 0, u.aOr().SOs);
                                              com.tencent.mm.live.d.f.aQP();
                                              continue;
                                              localObject1 = this.liveCore;
                                              if (localObject1 != null)
                                              {
                                                localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
                                                if (localObject1 != null)
                                                {
                                                  ((com.tencent.mm.live.core.core.model.h)localObject1).kmA = h.e.kmW;
                                                  localObject1 = x.aazN;
                                                  continue;
                                                  localObject1 = this.liveCore;
                                                  if (localObject1 != null)
                                                  {
                                                    localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
                                                    if (localObject1 != null)
                                                    {
                                                      ((com.tencent.mm.live.core.core.model.h)localObject1).kmA = h.e.kmY;
                                                      localObject1 = x.aazN;
                                                      continue;
                                                      localObject1 = this.kLx;
                                                      if (localObject1 != null)
                                                      {
                                                        localObject2 = u.kwz;
                                                        if (u.aOG().isLandscape()) {}
                                                        for (i = 2;; i = 1)
                                                        {
                                                          localObject2 = u.kwz;
                                                          localObject2 = u.aOG().userId;
                                                          localObject3 = u.kwz;
                                                          ((bk)localObject1).c(i, (String)localObject2, u.aOG().streamType);
                                                          localObject1 = x.aazN;
                                                          break;
                                                        }
                                                        localObject1 = this.liveCore;
                                                        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.c.c)localObject1).aLA() != true))
                                                        {
                                                          localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
                                                          localObject2 = u.kwz;
                                                          ((com.tencent.mm.live.b.c.c)localObject1).Oj(u.aOm());
                                                          localObject1 = u.kwz;
                                                          u.aOy();
                                                          localObject1 = u.kwz;
                                                          u.aPi();
                                                          continue;
                                                          if (!isLandscape())
                                                          {
                                                            if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                            {
                                                              localObject1 = this.kKn;
                                                              if (localObject1 != null)
                                                              {
                                                                localObject1 = ((com.tencent.mm.live.c.a)localObject1).kiF;
                                                                if (localObject1 == null) {}
                                                              }
                                                              for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                              {
                                                                ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
                                                                ((RelativeLayout.LayoutParams)localObject1).addRule(12);
                                                                ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
                                                                localObject1 = this.kKn;
                                                                if (localObject1 == null) {
                                                                  break;
                                                                }
                                                                localObject1 = ((com.tencent.mm.live.c.a)localObject1).kiF;
                                                                if (localObject1 == null) {
                                                                  break;
                                                                }
                                                                ((ViewGroup)localObject1).requestLayout();
                                                                localObject1 = x.aazN;
                                                                break;
                                                              }
                                                            }
                                                            localObject1 = this.kKn;
                                                            if (localObject1 != null)
                                                            {
                                                              localObject1 = ((com.tencent.mm.live.c.a)localObject1).kiF;
                                                              if (localObject1 == null) {}
                                                            }
                                                            for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                            {
                                                              ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
                                                              localObject2 = (RelativeLayout.LayoutParams)localObject1;
                                                              localObject3 = this.kLB;
                                                              i = j;
                                                              if (localObject3 != null)
                                                              {
                                                                localObject3 = ((com.tencent.mm.live.c.a)localObject3).kiF;
                                                                i = j;
                                                                if (localObject3 != null) {
                                                                  i = ((ViewGroup)localObject3).getId();
                                                                }
                                                              }
                                                              ((RelativeLayout.LayoutParams)localObject2).addRule(2, i);
                                                              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ui.aw.fromDPToPix(getContext(), 12);
                                                              localObject1 = this.kKn;
                                                              if (localObject1 == null) {
                                                                break;
                                                              }
                                                              localObject1 = ((com.tencent.mm.live.c.a)localObject1).kiF;
                                                              if (localObject1 == null) {
                                                                break;
                                                              }
                                                              ((ViewGroup)localObject1).requestLayout();
                                                              localObject1 = x.aazN;
                                                              break;
                                                            }
                                                          }
                                                          if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                          {
                                                            localObject1 = this.kKn;
                                                            if (localObject1 != null)
                                                            {
                                                              ((com.tencent.mm.live.c.m)localObject1).tU(4);
                                                              localObject1 = x.aazN;
                                                            }
                                                          }
                                                          else
                                                          {
                                                            localObject1 = this.kKn;
                                                            if (localObject1 != null)
                                                            {
                                                              ((com.tencent.mm.live.c.m)localObject1).tU(0);
                                                              localObject1 = x.aazN;
                                                              continue;
                                                              if (!isLandscape())
                                                              {
                                                                localObject1 = this.kLA;
                                                                if ((localObject1 != null) && (((com.tencent.mm.live.c.a)localObject1).kiF.getVisibility() == 0))
                                                                {
                                                                  if (paramBundle != null) {
                                                                    i = paramBundle.getInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT");
                                                                  }
                                                                  localObject1 = this.kKn;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    localObject1 = ((com.tencent.mm.live.c.a)localObject1).kiF;
                                                                    if (localObject1 == null) {}
                                                                  }
                                                                  for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                                  {
                                                                    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i;
                                                                    localObject1 = this.kKn;
                                                                    if (localObject1 == null) {
                                                                      break;
                                                                    }
                                                                    localObject1 = ((com.tencent.mm.live.c.a)localObject1).kiF;
                                                                    if (localObject1 == null) {
                                                                      break;
                                                                    }
                                                                    ((ViewGroup)localObject1).requestLayout();
                                                                    localObject1 = x.aazN;
                                                                    break;
                                                                  }
                                                                  localObject1 = u.kwz;
                                                                  if (!u.aOD().kwH)
                                                                  {
                                                                    localObject1 = this.kLx;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      ((bk)localObject1).tU(8);
                                                                      localObject1 = x.aazN;
                                                                    }
                                                                    localObject1 = this.kKi;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      ((com.tencent.mm.live.c.t)localObject1).tU(8);
                                                                      localObject1 = x.aazN;
                                                                    }
                                                                    localObject1 = this.kKx;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      ((ae)localObject1).tU(8);
                                                                      localObject1 = x.aazN;
                                                                    }
                                                                    localObject1 = this.kKC;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      ((com.tencent.mm.live.c.r)localObject1).tU(0);
                                                                      localObject1 = x.aazN;
                                                                    }
                                                                    localObject1 = u.kwz;
                                                                    u.aPg();
                                                                    localObject1 = getContext();
                                                                    if (localObject1 == null)
                                                                    {
                                                                      paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                                                                      AppMethodBeat.o(194067);
                                                                      throw paramc;
                                                                    }
                                                                    ((Activity)localObject1).setRequestedOrientation(1);
                                                                    continue;
                                                                    localObject1 = u.kwz;
                                                                    u.aOD().kwK = true;
                                                                    continue;
                                                                    localObject1 = u.kwz;
                                                                    localObject1 = u.aOm();
                                                                    localObject2 = u.kwz;
                                                                    l = u.aOr().klE;
                                                                    localObject2 = u.kwz;
                                                                    localObject2 = u.aOt();
                                                                    localObject3 = com.tencent.mm.model.z.bcZ();
                                                                    p.j(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
                                                                    u localu = u.kwz;
                                                                    com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 8, 1, (String)localObject3, u.aOr().SOs);
                                                                    com.tencent.mm.live.d.f.aQM();
                                                                    continue;
                                                                    localObject1 = this.kKp;
                                                                    if (localObject1 != null)
                                                                    {
                                                                      ((ay)localObject1).tU(4);
                                                                      localObject1 = x.aazN;
                                                                      continue;
                                                                      localObject1 = u.kwz;
                                                                      u.tO(u.aOR() + 1);
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
  
  public final void stop()
  {
    AppMethodBeat.i(194078);
    super.stop();
    this.kKL.stopTimer();
    AppMethodBeat.o(194078);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(194090);
    super.unMount();
    Object localObject1 = u.kwz;
    int i;
    Object localObject2;
    if (u.getLastOrientation() != -1)
    {
      localObject1 = u.kwz;
      i = u.getLastOrientation();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(194090);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.j(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
      if (i != ((Display)localObject1).getRotation())
      {
        i = 1;
        if (i == 0)
        {
          localObject1 = this.kLy;
          if (localObject1 != null) {
            ((com.tencent.mm.live.c.aw)localObject1).eT(false);
          }
          localObject1 = j.kue;
          j.aNy();
          localObject1 = com.tencent.mm.live.b.o.kvA;
          com.tencent.mm.live.b.o.aNZ();
          com.tencent.mm.live.b.o.kvA.release();
          localObject1 = this.liveCore;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.c.c)localObject1).aJB();
          }
          localObject1 = this.liveCore;
          if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).knA.aLp() != true))
          {
            localObject1 = this.liveCore;
            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).knA.aLo() != true)) {
              break label314;
            }
          }
          localObject1 = u.kwz;
          localObject1 = u.aPa().kyo;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.live.b.o.kvA;
            com.tencent.mm.live.b.o.az(((com.tencent.mm.live.b.b.a.a)localObject1).ktE, ((com.tencent.mm.live.b.b.a.a)localObject1).ktN);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("PARAM_HANGUP_SELF", true);
          statusChange(b.c.kzd, (Bundle)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject1 = u.kwz;
      u.ate();
      localObject1 = com.tencent.mm.live.core.core.c.c.kqq;
      localObject1 = com.tencent.mm.live.core.core.c.c.aMl();
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.c.c)localObject1).release();
      }
      com.tencent.mm.live.core.core.c.c.e(null);
      this.kKI.avz();
      localObject1 = com.tencent.mm.kernel.h.aHF();
      p.j(localObject1, "MMKernel.network()");
      ((com.tencent.mm.kernel.c)localObject1).aGY().b(3806, (i)this);
      this.kKL.stopTimer();
      AppMethodBeat.o(194090);
      return;
      i = 0;
      break;
      label314:
      localObject1 = this.kLz;
      if ((localObject1 != null) && (((com.tencent.mm.live.c.v)localObject1).kEF.kHJ == true))
      {
        localObject1 = com.tencent.mm.live.b.o.kvA;
        localObject1 = u.kwz;
        String str = u.aPa().kyp;
        localObject1 = u.kwz;
        localObject2 = u.aOr().TyF;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.live.b.o.az(str, (String)localObject1);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.model.f, TRTCCloudDef.TRTCParams, x>
  {
    b(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    c(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.model.f, TRTCCloudDef.TRTCParams, x>
  {
    e(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class g
    implements DialogInterface.OnDismissListener
  {
    g(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(199072);
      paramDialogInterface = u.kwz;
      u.aPg();
      com.tencent.mm.live.c.b.b.a(this.kLJ, b.c.kyW);
      AppMethodBeat.o(199072);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class i
    implements DialogInterface.OnDismissListener
  {
    i(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(197817);
      paramDialogInterface = u.kwz;
      u.aPg();
      com.tencent.mm.live.c.b.b.a(this.kLJ, b.c.kyW);
      AppMethodBeat.o(197817);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/LiveVisitorPluginLayout$handleJoinLiveErr$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"})
  public static final class j
    extends com.tencent.mm.plugin.messenger.a.a
  {
    j()
    {
      super(null);
    }
    
    public final void onClickImp(View paramView)
    {
      AppMethodBeat.i(201436);
      p.k(paramView, "widget");
      paramView = new Intent();
      l.a locala = com.tencent.mm.live.b.l.kuj;
      paramView.putExtra("rawUrl", com.tencent.mm.live.b.l.aNA());
      paramView.putExtra("showShare", false);
      com.tencent.mm.by.c.f(this.kLJ.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(201436);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Float, Float, x>
  {
    k(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Float, Float, x>
  {
    l(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "liveID", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Long, x>
  {
    m(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    n(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    o(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/live/view/RoomLiveMiniView;", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RoomLiveMiniView>
  {
    p(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, Context paramContext)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/live/view/LiveVisitorPluginLayout$miniView$2$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(LiveVisitorPluginLayout.p paramp)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/live/view/LiveVisitorPluginLayout$statusChange$3$1"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    q(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class r
    implements MTimerHandler.CallBack
  {
    r(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(193767);
      com.tencent.mm.live.c.o localo = LiveVisitorPluginLayout.k(this.kLJ);
      if ((localo != null) && (localo.kiF.getVisibility() == 0))
      {
        localo = LiveVisitorPluginLayout.k(this.kLJ);
        if (localo != null)
        {
          u localu = u.kwz;
          int i = u.aOr().SOs;
          localu = u.kwz;
          localo.dx(i, u.aOr().TgX);
        }
      }
      AppMethodBeat.o(193767);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    s(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVisitorPluginLayout
 * JD-Core Version:    0.7.0.1
 */