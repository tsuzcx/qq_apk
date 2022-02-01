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
import com.tencent.mm.ak.i;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.k;
import com.tencent.mm.live.b.x.b;
import com.tencent.mm.live.b.x.c;
import com.tencent.mm.live.b.x.d;
import com.tencent.mm.live.c.ab;
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
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.c.bc;
import com.tencent.mm.live.c.be;
import com.tencent.mm.live.c.bg;
import com.tencent.mm.live.c.bi;
import com.tencent.mm.live.c.bk;
import com.tencent.mm.live.c.o;
import com.tencent.mm.live.core.core.b.g.d;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.d;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.at;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.ArrayList;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout;", "Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "anchorExceptionInTRTC", "", "audienceMode", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "liveDebugPlugin", "Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveGuestRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "liveInputPlugin", "Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "liveKickedPlugin", "Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVideoMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "liveVisitorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "liveVisitorCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "pluginShow", "rotationEnable", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkAnchorStatus", "checkClickArea", "x", "", "y", "validCallback", "chooseAudienceMode", "byOrientationChange", "enterRoom", "liveName", "", "roomID", "", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "getRenderMode", "handleEnterRoom", "handleJoinLiveErr", "errCode", "errMsg", "initLogic", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "keyboardChange", "show", "height", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "requestLinkMic", "resume", "start", "startTimer", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "stopTimer", "toggleShowPlugins", "unMount", "updatePlugin", "Companion", "plugin-logic_release"})
public final class LiveVisitorPluginLayout
  extends RoomBaseLivePluginLayout
  implements i, com.tencent.mm.live.core.core.c
{
  public static final a hXe;
  private int curNetworkQuality;
  private com.tencent.mm.live.c.t hVH;
  private com.tencent.mm.live.c.c hVJ;
  private as hVL;
  private com.tencent.mm.live.c.m hVM;
  private ay hVO;
  private ai hVP;
  private o hVT;
  private am hVU;
  private ae hVW;
  private ak hVX;
  private ac hVY;
  private ag hVZ;
  private bk hWV;
  private com.tencent.mm.live.c.v hWW;
  private com.tencent.mm.live.c.z hWX;
  private bg hWY;
  private com.tencent.mm.live.c.q hWZ;
  private com.tencent.mm.live.c.r hWb;
  private final ArrayList<com.tencent.mm.live.c.a> hWe;
  private boolean hWf;
  private boolean hWg;
  private final com.tencent.mm.model.d hWh;
  private bc hXa;
  private ab hXb;
  private be hXc;
  private boolean hXd;
  private int hzl;
  private com.tencent.mm.live.core.core.d.b liveCore;
  private final kotlin.g.a.a<kotlin.x> liveMessageCallback;
  private aw liveTXLivePlayerPlygin;
  private MTimerHandler timerThread;
  
  static
  {
    AppMethodBeat.i(208637);
    hXe = new a((byte)0);
    AppMethodBeat.o(208637);
  }
  
  public LiveVisitorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(208636);
    this.hWf = true;
    paramContext = e.a.hxc;
    this.hzl = e.a.aCe();
    this.hWe = new ArrayList();
    this.hWh = com.tencent.mm.model.d.aTu();
    paramContext = e.h.hya;
    this.curNetworkQuality = e.h.aCT();
    this.liveMessageCallback = ((kotlin.g.a.a)new o(this));
    this.timerThread = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack)new q(this), true);
    AppMethodBeat.o(208636);
  }
  
  private final void a(float paramFloat1, float paramFloat2, kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(208625);
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
      AppMethodBeat.o(208625);
      return;
    }
  }
  
  private final void aJr()
  {
    AppMethodBeat.i(208621);
    com.tencent.mm.live.core.core.d.b.a locala = com.tencent.mm.live.core.core.d.b.hCo;
    getContext();
    com.tencent.mm.live.core.core.d.b.a.aEf().aDY();
    Log.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:0");
    AppMethodBeat.o(208621);
  }
  
  private final void c(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(208622);
    Log.i("MicroMsg.LiveCoreVisitor", "join, name:" + paramString1 + ", roomID:" + paramLong);
    com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
    new k(com.tencent.mm.live.b.x.aGr().hyH, paramString2, paramString1, (byte)0).a((kotlin.g.a.r)new e(this));
    AppMethodBeat.o(208622);
  }
  
  private final void chooseAudienceMode(final boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(208618);
    Log.i("MicroMsg.LiveCoreVisitor", "audienceMode:" + this.hzl);
    int i = this.hzl;
    Object localObject1 = e.a.hxc;
    if (i == e.a.aCe())
    {
      com.tencent.mm.live.d.f.aIY();
      localObject1 = this.hWV;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.b.x.hJf;
        localObject2 = com.tencent.mm.live.b.x.aGv();
        if (localObject2 == null) {
          p.hyc();
        }
        ((bk)localObject1).a((com.tencent.mm.live.core.core.b.f)localObject2, (kotlin.g.a.b)new c(this, paramBoolean));
      }
      localObject1 = this.hWV;
      if (localObject1 != null)
      {
        ((bk)localObject1).rg(0);
        AppMethodBeat.o(208618);
        return;
      }
      AppMethodBeat.o(208618);
      return;
    }
    localObject1 = e.a.hxc;
    if (i == e.a.aCf())
    {
      com.tencent.mm.live.d.f.aIX();
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.live.b.x.hJf;
        localObject3 = com.tencent.mm.live.b.x.aGv();
        if (localObject3 == null) {
          p.hyc();
        }
        ((com.tencent.mm.live.core.core.d.b)localObject1).a((com.tencent.mm.live.core.core.b.f)localObject3);
      }
      if (this.liveCore != null)
      {
        localObject1 = com.tencent.mm.live.b.x.hJf;
        localObject1 = com.tencent.mm.live.b.x.aGv();
        if (localObject1 == null) {
          p.hyc();
        }
        com.tencent.mm.live.core.core.d.a(((com.tencent.mm.live.core.core.b.f)localObject1).hwP);
      }
      localObject1 = this.liveTXLivePlayerPlygin;
      if (localObject1 != null) {
        aw.a((aw)localObject1, 0, null, getRenderMode(), (kotlin.g.a.b)new d(this, paramBoolean), 3);
      }
      localObject1 = this.liveTXLivePlayerPlygin;
      if (localObject1 != null) {
        ((aw)localObject1).rg(0);
      }
      Object localObject3 = this.liveCore;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.live.b.x.hJf;
        long l = com.tencent.mm.live.b.x.aGr().hyH;
        localObject1 = this.liveTXLivePlayerPlygin;
        if (localObject1 != null) {}
        for (localObject1 = ((aw)localObject1).hwO;; localObject1 = null)
        {
          aw localaw = this.liveTXLivePlayerPlygin;
          if (localaw != null) {
            localObject2 = localaw.aHJ();
          }
          ((com.tencent.mm.live.core.core.d.b)localObject3).a(l, (TXLivePlayer)localObject1, (TXCloudVideoView)localObject2);
          AppMethodBeat.o(208618);
          return;
        }
      }
    }
    AppMethodBeat.o(208618);
  }
  
  private final int getRenderMode()
  {
    AppMethodBeat.i(208620);
    if (isLandscape())
    {
      AppMethodBeat.o(208620);
      return 1;
    }
    AppMethodBeat.o(208620);
    return 0;
  }
  
  private final void startTimer()
  {
    AppMethodBeat.i(208617);
    this.timerThread.stopTimer();
    this.timerThread.startTimer(1000L);
    AppMethodBeat.o(208617);
  }
  
  public final void callback(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(208635);
    Log.i("MicroMsg.LiveCoreVisitor", "callback:".concat(String.valueOf(paramInt)));
    Object localObject4 = e.d.hxF;
    if (paramInt == e.d.aCo())
    {
      b.b.a(this, b.c.hLY);
      AppMethodBeat.o(208635);
      return;
    }
    localObject4 = e.d.hxF;
    if (paramInt == e.d.aCp())
    {
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getString("live_user_id");
        paramBundle.getString("live_user_exit_reason");
        localObject3 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append((String)localObject2).append(" micUid:");
        paramBundle = com.tencent.mm.live.b.x.hJf;
        paramBundle = com.tencent.mm.live.b.x.aHa().hKU;
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.hFG;; paramBundle = null)
        {
          Log.i("MicroMsg.LiveCoreAnchor", paramBundle);
          paramBundle = com.tencent.mm.live.b.x.hJf;
          localObject3 = com.tencent.mm.live.b.x.aHa().hKU;
          paramBundle = (Bundle)localObject1;
          if (localObject3 != null) {
            paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject3).hFG;
          }
          if (!p.j(localObject2, paramBundle))
          {
            paramBundle = com.tencent.mm.live.b.x.hJf;
            if (!p.j(localObject2, com.tencent.mm.live.b.x.aGr().MnM)) {}
          }
          else
          {
            paramBundle = com.tencent.mm.live.b.x.hJf;
            paramBundle = com.tencent.mm.live.b.x.aHa().hKU;
            if (paramBundle != null)
            {
              localObject1 = this.hWV;
              if (localObject1 != null)
              {
                localObject1 = ((bk)localObject1).hAs;
                if (localObject1 != null) {
                  ((LivePreviewView)localObject1).clearAnimation();
                }
              }
              localObject1 = com.tencent.mm.live.b.x.hJf;
              com.tencent.mm.live.b.x.aHa().a(paramBundle.liveId, paramBundle.hFJ, paramBundle.hFz);
            }
          }
          paramBundle = com.tencent.mm.live.b.x.hJf;
          if (p.j(localObject2, com.tencent.mm.live.b.x.aGr().MnM))
          {
            this.hXd = true;
            b.b.a(this, b.c.hMq);
          }
          AppMethodBeat.o(208635);
          return;
        }
      }
      AppMethodBeat.o(208635);
      return;
    }
    localObject1 = e.d.hxF;
    if (paramInt == e.d.aCq()) {
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getString("live_user_id");
        if (paramBundle.getBoolean("live_media_enable"))
        {
          paramBundle = com.tencent.mm.live.b.x.hJf;
          localObject3 = com.tencent.mm.live.b.x.aHa();
          if (localObject1 != null) {
            break label1249;
          }
        }
      }
    }
    label587:
    label1249:
    for (paramBundle = "";; paramBundle = (Bundle)localObject1)
    {
      ((com.tencent.mm.live.b.b.a)localObject3).hKW = paramBundle;
      localObject4 = ((com.tencent.mm.live.b.b.a)localObject3).hKU;
      paramBundle = (Bundle)localObject2;
      if (localObject4 != null) {
        paramBundle = ((com.tencent.mm.live.b.b.a.a)localObject4).hFG;
      }
      if ((p.j(localObject1, paramBundle)) && (!((com.tencent.mm.live.b.b.a)localObject3).aHl()))
      {
        paramBundle = ((com.tencent.mm.live.b.b.a)localObject3).hKR;
        if (paramBundle != null)
        {
          paramBundle.invoke();
          AppMethodBeat.o(208635);
          return;
        }
      }
      AppMethodBeat.o(208635);
      return;
      b.b.a(this, b.c.hLL);
      AppMethodBeat.o(208635);
      return;
      AppMethodBeat.o(208635);
      return;
      localObject1 = e.d.hxF;
      if (paramInt == e.d.aCr())
      {
        i = this.curNetworkQuality;
        paramBundle = this.liveCore;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.hAz;
          if (paramBundle == null) {}
        }
        for (paramInt = paramBundle.hzL;; paramInt = e.h.aCT())
        {
          this.curNetworkQuality = paramInt;
          paramBundle = e.h.hya;
          if (i == e.h.aCV()) {
            break label587;
          }
          paramInt = this.curNetworkQuality;
          paramBundle = e.h.hya;
          if (paramInt != e.h.aCV()) {
            break label587;
          }
          b.b.a(this, b.c.hMo);
          paramBundle = this.hWV;
          if (paramBundle == null) {
            break;
          }
          paramBundle.pause();
          AppMethodBeat.o(208635);
          return;
          paramBundle = e.h.hya;
        }
        AppMethodBeat.o(208635);
        return;
        paramBundle = e.h.hya;
        if (i == e.h.aCV())
        {
          paramInt = this.curNetworkQuality;
          paramBundle = e.h.hya;
          if (paramInt != e.h.aCV())
          {
            b.b.a(this, b.c.hMp);
            paramBundle = this.hWV;
            if (paramBundle != null) {
              paramBundle.resume();
            }
            paramBundle = com.tencent.mm.live.b.r.hIg;
            com.tencent.mm.live.b.r.aGb();
          }
        }
        AppMethodBeat.o(208635);
        return;
      }
      localObject1 = e.d.hxF;
      long l;
      if (paramInt == e.d.aCs())
      {
        paramBundle = this.liveCore;
        int k;
        if ((paramBundle != null) && (paramBundle.hAz.aDu() == true))
        {
          i = 1;
          k = this.hzl;
          paramBundle = e.a.hxc;
          if (k != e.a.aCe()) {
            break label814;
          }
          j = 2;
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
          com.tencent.mm.live.d.e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.b.x.aGt(), i, j, paramInt);
          AppMethodBeat.o(208635);
          return;
          paramBundle = this.liveCore;
          if ((paramBundle != null) && (paramBundle.hAz.aDt() == true))
          {
            i = 2;
            break;
          }
          i = 0;
          break;
          paramBundle = e.a.hxc;
          if (k == e.a.aCf()) {
            j = 1;
          }
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
        p.g(localObject1, "RoomLiveService.liveInfo.live_name");
        new k(l, paramBundle, (String)localObject1, (byte)0).a((kotlin.g.a.r)new b(this));
        AppMethodBeat.o(208635);
        return;
      }
      localObject1 = e.d.hxF;
      if (paramInt == e.d.aCv())
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
        p.g(localObject1, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
        localObject4 = this.liveCore;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.live.core.core.trtc.a)localObject4).hAz;
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = ((com.tencent.mm.live.core.core.b.g)localObject4).hzG;
          }
        }
        if (!Util.isEqual((String)localObject1, (String)localObject2))
        {
          localObject2 = com.tencent.mm.live.b.x.hJf;
          com.tencent.mm.live.b.x.aGG().setUserId((String)localObject1);
          localObject1 = com.tencent.mm.live.b.x.hJf;
          localObject1 = com.tencent.mm.live.b.x.aGG();
          if (paramBundle != null)
          {
            paramInt = paramBundle.getInt("live_stream_type");
            ((x.c)localObject1).streamType = paramInt;
            localObject1 = com.tencent.mm.live.b.x.hJf;
            localObject1 = com.tencent.mm.live.b.x.aGG();
            if (paramBundle == null) {
              break label1132;
            }
          }
          label1132:
          for (paramInt = paramBundle.getInt("live_first_frame_width");; paramInt = 0)
          {
            ((x.c)localObject1).width = paramInt;
            localObject1 = com.tencent.mm.live.b.x.hJf;
            localObject1 = com.tencent.mm.live.b.x.aGG();
            paramInt = i;
            if (paramBundle != null) {
              paramInt = paramBundle.getInt("live_first_frame_height");
            }
            ((x.c)localObject1).height = paramInt;
            b.b.a(this, b.c.hMy);
            AppMethodBeat.o(208635);
            return;
            paramInt = 0;
            break;
          }
        }
        this.hXd = false;
        AppMethodBeat.o(208635);
        return;
      }
      paramBundle = e.d.hxF;
      if (paramInt == e.d.aCy())
      {
        b.b.a(this, b.c.hLB);
        AppMethodBeat.o(208635);
        return;
      }
      paramBundle = e.d.hxF;
      if (paramInt == e.d.aCA())
      {
        b.b.a(this, b.c.hMp);
        AppMethodBeat.o(208635);
        return;
      }
      paramBundle = e.d.hxF;
      if (paramInt == e.d.aCB())
      {
        b.b.a(this, b.c.hMn);
        AppMethodBeat.o(208635);
        return;
      }
      paramBundle = e.d.hxF;
      if (paramInt == e.d.aCC()) {
        b.b.a(this, b.c.hMo);
      }
      AppMethodBeat.o(208635);
      return;
    }
  }
  
  public final int getLiveRole()
  {
    return 0;
  }
  
  public final int getRelativeLayoutId()
  {
    return 2131495296;
  }
  
  public final void initLogic(LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(208615);
    p.h(paramLiveConfig, "config");
    Object localObject1 = com.tencent.mm.live.core.core.d.b.hCo;
    getContext();
    this.liveCore = com.tencent.mm.live.core.core.d.b.a.aEf();
    localObject1 = this.liveCore;
    if (localObject1 != null)
    {
      localObject2 = getContext();
      p.g(localObject2, "context");
      ((com.tencent.mm.live.core.core.d.b)localObject1).a((AbsLiveMiniView)new RoomLiveMiniView((Context)localObject2));
    }
    localObject1 = this.liveCore;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.trtc.a)localObject1).hAx = ((com.tencent.mm.live.core.core.c)this);
    }
    localObject1 = com.tencent.mm.live.b.x.hJf;
    localObject1 = paramLiveConfig.aBD();
    p.g(localObject1, "config.hostRoomId");
    com.tencent.mm.live.b.x.GQ((String)localObject1);
    localObject1 = com.tencent.mm.live.b.x.hJf;
    com.tencent.mm.live.b.x.a(new civ());
    localObject1 = com.tencent.mm.live.b.x.hJf;
    com.tencent.mm.live.b.x.aGr().hyH = paramLiveConfig.getLiveId();
    localObject1 = com.tencent.mm.live.b.x.hJf;
    com.tencent.mm.live.b.x.GR(paramLiveConfig.aBE());
    localObject1 = com.tencent.mm.live.b.x.hJf;
    localObject1 = paramLiveConfig.aBG();
    p.g(localObject1, "config.anchorUsername");
    com.tencent.mm.live.b.x.GS((String)localObject1);
    localObject1 = com.tencent.mm.live.b.x.hJf;
    com.tencent.mm.live.b.x.aGr().KNv = true;
    localObject1 = findViewById(2131303554);
    p.g(localObject1, "findViewById(R.id.live_right_panel_ui_root)");
    this.hWW = new com.tencent.mm.live.c.v((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303597);
    p.g(localObject1, "findViewById(R.id.live_title_ui_root)");
    this.hVO = new ay((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303501);
    p.g(localObject1, "findViewById(R.id.live_minimize_ui_root)");
    this.hVU = new am((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303626);
    p.g(localObject1, "findViewById(R.id.live_visitor_comment_root)");
    this.hWY = new bg((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303414);
    p.g(localObject1, "findViewById(R.id.live_input_ui_root)");
    this.hWX = new com.tencent.mm.live.c.z((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303307);
    p.g(localObject1, "findViewById(R.id.live_after_ui_root)");
    this.hVJ = new com.tencent.mm.live.c.c((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303403);
    p.g(localObject1, "findViewById(R.id.live_input_debug_view_root)");
    this.hWZ = new com.tencent.mm.live.c.q((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303431);
    p.g(localObject1, "findViewById(R.id.live_loading_view_root)");
    this.hVW = new ae((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303368);
    p.g(localObject1, "findViewById(R.id.live_comment_ui_root)");
    this.hVM = new com.tencent.mm.live.c.m((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303461);
    p.g(localObject1, "findViewById(R.id.live_members_list_ui_root)");
    this.hVP = new ai((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303420);
    p.g(localObject1, "findViewById(R.id.live_like_confetti_ui_root)");
    this.hVY = new ac((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303493);
    p.g(localObject1, "findViewById(R.id.live_mic_visitor_header_root)");
    this.hVX = new ak((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303505);
    p.g(localObject1, "findViewById(R.id.live_preview_ui_root)");
    this.hWV = new bk((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303599);
    p.g(localObject1, "findViewById(R.id.live_tx_live_player_ui_root)");
    this.liveTXLivePlayerPlygin = new aw((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303557);
    p.g(localObject1, "findViewById(R.id.live_shadow_ui_root)");
    this.hVL = new as((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303621);
    p.g(localObject1, "findViewById(R.id.live_video_mic_ui_root)");
    this.hXa = new bc((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303475);
    p.g(localObject1, "findViewById(R.id.live_members_profile_ui_root)");
    this.hVZ = new ag((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303418);
    p.g(localObject1, "findViewById(R.id.live_kicked_ui_root)");
    this.hXb = new ab((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303625);
    p.g(localObject1, "findViewById(R.id.live_visitor_close_ui_root)");
    this.hXc = new be((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303379);
    p.g(localObject1, "findViewById(R.id.live_common_info_ui_root)");
    this.hVT = new o((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303390);
    p.g(localObject1, "findViewById(R.id.live_exception_ui_root)");
    this.hWb = new com.tencent.mm.live.c.r((ViewGroup)localObject1, (com.tencent.mm.live.c.b)this);
    localObject1 = findViewById(2131303396);
    p.g(localObject1, "findViewById(R.id.live_face_verify_ui_root)");
    this.hVH = new com.tencent.mm.live.c.t((RelativeLayout)localObject1, (com.tencent.mm.live.c.b)this);
    Object localObject2 = this.hWV;
    if (localObject2 != null)
    {
      localObject1 = this.hXa;
      if (localObject1 != null)
      {
        localObject1 = ((bc)localObject1).aHL();
        ((bk)localObject2).hTC = ((com.tencent.mm.live.core.b.l)localObject1);
      }
    }
    else
    {
      localObject1 = com.tencent.mm.live.b.r.hIg;
      com.tencent.mm.live.b.r.a(paramLiveConfig);
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
      localObject2 = this.hVO;
      if (localObject2 != null)
      {
        localObject1 = com.tencent.mm.live.b.x.hJf;
        localObject1 = com.tencent.mm.live.b.x.aGr().LpF;
        if (localObject1 == null) {
          break label1809;
        }
        localObject1 = (CharSequence)localObject1;
        label1140:
        com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
        ((ay)localObject2).a((CharSequence)localObject1, com.tencent.mm.live.b.x.aGt());
      }
      localObject1 = this.hVP;
      if (localObject1 != null) {
        ((ai)localObject1).a(paramLiveConfig);
      }
      localObject1 = this.hVZ;
      if (localObject1 != null) {
        ((ag)localObject1).a(paramLiveConfig);
      }
      localObject1 = this.hVT;
      if (localObject1 != null) {
        ((o)localObject1).aHy();
      }
      localObject1 = this.liveTXLivePlayerPlygin;
      if (localObject1 != null) {
        ((aw)localObject1).aHy();
      }
      localObject2 = this.hXa;
      if (localObject2 != null)
      {
        p.h(paramLiveConfig, "config");
        if (paramLiveConfig.aBC() != LiveConfig.hvT) {
          break label1820;
        }
        localObject1 = com.tencent.mm.live.core.core.a.b.hyv;
        ((com.tencent.mm.live.c.a)localObject2).hwr.getContext();
        localObject1 = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.aDo();
        label1271:
        ((bc)localObject2).hSS = ((com.tencent.mm.live.core.core.trtc.a)localObject1);
      }
      localObject1 = this.hVT;
      if (localObject1 != null) {
        ((o)localObject1).rg(8);
      }
      localObject1 = this.hXc;
      if (localObject1 != null) {
        ((be)localObject1).rg(8);
      }
      localObject1 = this.hVJ;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.c)localObject1).rg(8);
      }
      localObject1 = this.hWY;
      if (localObject1 != null) {
        ((bg)localObject1).rg(8);
      }
      localObject1 = this.hWX;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.z)localObject1).rg(8);
      }
      localObject1 = this.hWW;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.v)localObject1).rg(8);
      }
      localObject1 = this.hVP;
      if (localObject1 != null) {
        ((ai)localObject1).rg(8);
      }
      localObject1 = this.hVW;
      if (localObject1 != null) {
        ((ae)localObject1).Hc(paramLiveConfig.aBG());
      }
      localObject1 = this.hWV;
      if (localObject1 != null) {
        ((bk)localObject1).rg(0);
      }
      localObject1 = this.liveTXLivePlayerPlygin;
      if (localObject1 != null) {
        ((aw)localObject1).rg(8);
      }
      localObject1 = this.hVL;
      if (localObject1 != null) {
        ((as)localObject1).rg(8);
      }
      localObject1 = this.hXa;
      if (localObject1 != null) {
        ((bc)localObject1).rg(8);
      }
      localObject1 = this.hVZ;
      if (localObject1 != null) {
        ((ag)localObject1).rg(8);
      }
      localObject1 = this.hXb;
      if (localObject1 != null) {
        ((ab)localObject1).rg(8);
      }
      localObject1 = this.hWb;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.r)localObject1).rg(8);
      }
      localObject1 = this.hVH;
      if (localObject1 != null) {
        ((com.tencent.mm.live.c.t)localObject1).rg(8);
      }
      localObject2 = this.hWV;
      if (localObject2 != null)
      {
        localObject1 = (kotlin.g.a.m)new k(this);
        localObject2 = ((bk)localObject2).hAs;
        if (localObject2 != null) {
          ((LivePreviewView)localObject2).setPreviewTouchListener((kotlin.g.a.m)localObject1);
        }
      }
      localObject1 = this.liveTXLivePlayerPlygin;
      if (localObject1 != null)
      {
        localObject2 = (kotlin.g.a.m)new l(this);
        ((aw)localObject1).hSD.setPreviewTouchListener((kotlin.g.a.m)localObject2);
      }
      if (paramLiveConfig.getScene() == LiveConfig.hvR)
      {
        paramLiveConfig = this.hVJ;
        if (paramLiveConfig != null)
        {
          paramLiveConfig.hOl.setVisibility(8);
          paramLiveConfig.hOk.setVisibility(0);
        }
      }
      paramLiveConfig = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aHa().hKO = ((kotlin.g.a.b)new m(this));
      paramLiveConfig = com.tencent.mm.live.b.m.hGg;
      com.tencent.mm.live.b.m.e(name(), (kotlin.g.a.a)new n(this));
      if (!LiveConfig.aBO()) {
        break label1845;
      }
      paramLiveConfig = findViewById(2131303396);
      p.g(paramLiveConfig, "findViewById(R.id.live_face_verify_ui_root)");
      this.hVH = new com.tencent.mm.live.c.t((RelativeLayout)paramLiveConfig, (com.tencent.mm.live.c.b)this);
      statusChange(b.c.hMz, new Bundle());
      LiveConfig.eu(false);
    }
    for (;;)
    {
      paramLiveConfig = com.tencent.mm.live.b.m.hGg;
      com.tencent.mm.live.b.m.d(name(), this.liveMessageCallback);
      AppMethodBeat.o(208615);
      return;
      localObject1 = null;
      break;
      label1809:
      localObject1 = (CharSequence)"";
      break label1140;
      label1820:
      localObject1 = com.tencent.mm.live.core.core.d.b.hCo;
      ((com.tencent.mm.live.c.a)localObject2).hwr.getContext();
      localObject1 = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.d.b.a.aEf();
      break label1271;
      label1845:
      paramLiveConfig = com.tencent.mm.kernel.g.aAh();
      p.g(paramLiveConfig, "MMKernel.storage()");
      if (paramLiveConfig.azQ().getInt(ar.a.Onn, 0) == 1)
      {
        paramLiveConfig = this.hWZ;
        if (paramLiveConfig != null) {
          paramLiveConfig.rg(0);
        }
      }
      else
      {
        paramLiveConfig = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.getLastOrientation() != -1)
        {
          paramLiveConfig = com.tencent.mm.live.b.x.hJf;
          i = com.tencent.mm.live.b.x.getLastOrientation();
          paramLiveConfig = getContext().getSystemService("window");
          if (paramLiveConfig == null)
          {
            paramLiveConfig = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(208615);
            throw paramLiveConfig;
          }
          paramLiveConfig = ((WindowManager)paramLiveConfig).getDefaultDisplay();
          p.g(paramLiveConfig, "((context.getSystemServi…owManager).defaultDisplay");
          if (i != paramLiveConfig.getRotation()) {}
        }
        else
        {
          paramLiveConfig = com.tencent.mm.live.b.x.hJf;
          localObject1 = com.tencent.mm.live.b.x.aGr().LpF;
          paramLiveConfig = (LiveConfig)localObject1;
          if (localObject1 == null) {
            paramLiveConfig = "";
          }
          localObject1 = com.tencent.mm.live.b.x.hJf;
          long l = com.tencent.mm.live.b.x.aGr().hyH;
          localObject1 = com.tencent.mm.live.b.x.hJf;
          c(paramLiveConfig, l, com.tencent.mm.live.b.x.aGm());
          continue;
        }
        paramLiveConfig = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGD().hJn)
        {
          b.b.a(this, b.c.hLV);
        }
        else
        {
          paramLiveConfig = this.liveCore;
          if (paramLiveConfig != null)
          {
            paramLiveConfig = paramLiveConfig.hAz;
            if ((paramLiveConfig != null) && (paramLiveConfig.aDt() == true)) {}
          }
          else
          {
            paramLiveConfig = this.liveCore;
            if (paramLiveConfig == null) {
              break label2106;
            }
            paramLiveConfig = paramLiveConfig.hAz;
            if ((paramLiveConfig == null) || (paramLiveConfig.aDu() != true)) {
              break label2106;
            }
          }
          b.b.a(this, b.c.hLB);
        }
      }
    }
    label2106:
    paramLiveConfig = com.tencent.mm.live.b.x.hJf;
    paramLiveConfig = com.tencent.mm.live.b.x.aGv();
    if (paramLiveConfig != null)
    {
      paramLiveConfig = paramLiveConfig.hwP;
      if (paramLiveConfig == null) {}
    }
    for (int i = paramLiveConfig.hzl;; i = e.a.aCf())
    {
      this.hzl = i;
      chooseAudienceMode(true);
      paramLiveConfig = com.tencent.mm.live.b.x.hJf;
      if (!com.tencent.mm.live.b.x.aGE().hJk) {
        break;
      }
      paramLiveConfig = this.hVH;
      if (paramLiveConfig != null) {
        paramLiveConfig.rg(0);
      }
      statusChange(b.c.hLw, new Bundle());
      paramLiveConfig = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aGE().hJk = false;
      break;
      paramLiveConfig = e.a.hxc;
    }
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(208634);
    super.keyboardChange(paramBoolean, paramInt);
    AppMethodBeat.o(208634);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(208630);
    super.mount();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().a(3806, (i)this);
    AppMethodBeat.o(208630);
  }
  
  public final String name()
  {
    AppMethodBeat.i(208624);
    String str = LiveVisitorPluginLayout.class.getSimpleName();
    p.g(str, "LiveVisitorPluginLayout::class.java.simpleName");
    AppMethodBeat.o(208624);
    return str;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(208632);
    boolean bool2 = super.onBackPress();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
      bool1 = bool2;
      if (com.tencent.mm.live.b.x.aGD().hJo)
      {
        localx = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aGD().hJo = false;
        b.b.a(this, b.c.hLC);
        bool1 = true;
      }
    }
    AppMethodBeat.o(208632);
    return bool1;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(208616);
    p.h(paramString, "incomingNumber");
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.liveCore;
    if (paramString != null)
    {
      paramString = paramString.hAz;
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
      AppMethodBeat.o(208616);
      return;
      paramString = null;
      break;
      AppMethodBeat.o(208616);
      return;
      paramString = com.tencent.mm.live.b.r.hIg;
      com.tencent.mm.live.b.r.aFZ();
      paramString = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aGy();
      paramString = this.liveCore;
      if ((paramString != null) && (paramString.hAz.aDt() == true))
      {
        paramString = this.liveCore;
        if (paramString != null) {
          paramString.aBS();
        }
      }
      paramString = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aHi();
    }
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean)
  {
    this.hWg = paramBoolean;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(208633);
    Log.i("MicroMsg.LiveCoreVisitor", "errType:" + paramInt1 + " errCode:" + paramInt2);
    if (((paramq instanceof com.tencent.mm.live.b.a.b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.hWY;
      if (paramString != null) {
        paramString.aHM();
      }
      paramq = this.hVO;
      if (paramq != null)
      {
        paramString = com.tencent.mm.live.b.x.hJf;
        paramString = com.tencent.mm.live.b.x.aGr().LpF;
        if (paramString == null) {
          break label145;
        }
        paramString = (CharSequence)paramString;
        com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
        paramq.a(paramString, com.tencent.mm.live.b.x.aGt());
      }
      paramString = com.tencent.mm.live.b.x.hJf;
      paramString = com.tencent.mm.live.b.x.hJf;
      if (com.tencent.mm.live.b.x.aGr().KNv) {
        break label155;
      }
    }
    label145:
    label155:
    for (paramInt1 = cl.aWB();; paramInt1 = 0)
    {
      com.tencent.mm.live.b.x.qT(paramInt1);
      AppMethodBeat.o(208633);
      return;
      paramString = (CharSequence)"";
      break;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(208629);
    super.pause();
    Object localObject1 = com.tencent.mm.live.b.x.hJf;
    if (com.tencent.mm.live.b.x.getLastOrientation() != -1)
    {
      localObject1 = com.tencent.mm.live.b.x.hJf;
      int i = com.tencent.mm.live.b.x.getLastOrientation();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(208629);
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
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(208629);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
    p.g(localObject2, "((context.getSystemServi…owManager).defaultDisplay");
    Log.i("MicroMsg.LiveCoreVisitor", ((Display)localObject2).getRotation());
    if (!bool)
    {
      localObject1 = com.tencent.mm.live.b.x.hJf;
      if (!com.tencent.mm.live.b.x.aGD().hJn)
      {
        localObject1 = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJp)
        {
          localObject1 = com.tencent.mm.live.b.x.hJf;
          if (!com.tencent.mm.live.b.x.aGD().hJq)
          {
            localObject1 = com.tencent.mm.live.b.x.hJf;
            if (com.tencent.mm.live.b.x.aGD().hJo)
            {
              localObject1 = com.tencent.mm.live.b.x.hJf;
              if ((!com.tencent.mm.live.b.x.isManualClosed()) && (com.tencent.mm.compatible.e.b.cx(getContext())))
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 3);
                statusChange(b.c.hLQ, (Bundle)localObject1);
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
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz;
      if (localObject1 == null) {
        break;
      }
      if (((com.tencent.mm.live.core.core.b.g)localObject1).aDt() != true) {
        break label386;
      }
      localObject1 = this.liveCore;
      if (localObject1 == null) {
        break label386;
      }
      ((com.tencent.mm.live.core.core.d.b)localObject1).aBS();
      AppMethodBeat.o(208629);
      return;
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.g)localObject1).isNormalMode() == true))
        {
          localObject1 = this.liveCore;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.d.b)localObject1).aEa();
          }
        }
      }
    }
    AppMethodBeat.o(208629);
    return;
    label386:
    AppMethodBeat.o(208629);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(208628);
    Object localObject1 = com.tencent.mm.live.b.x.hJf;
    com.tencent.mm.live.b.x.aGD().hJq = false;
    localObject1 = getContext().getSystemService("window");
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(208628);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
    p.g(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
    int j = ((Display)localObject1).getRotation();
    localObject1 = new StringBuilder("curOrientation:").append(j).append(", lastOrientation:");
    Object localObject2 = com.tencent.mm.live.b.x.hJf;
    Log.i("MicroMsg.LiveCoreVisitor", com.tencent.mm.live.b.x.getLastOrientation());
    super.resume();
    localObject1 = this.liveCore;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz;
      if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.g)localObject1).isNormalMode() == true))
      {
        localObject1 = this.liveCore;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.d.b)localObject1).aEb();
        }
      }
    }
    localObject1 = com.tencent.mm.live.b.x.hJf;
    int i;
    Object localObject3;
    if (com.tencent.mm.live.b.x.getLastOrientation() != -1)
    {
      localObject1 = com.tencent.mm.live.b.x.hJf;
      if (j != com.tencent.mm.live.b.x.getLastOrientation())
      {
        localObject1 = this.liveCore;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.d.b)localObject1).aBU();
        }
        localObject1 = this.liveCore;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.d.b)localObject1).aDX();
        }
        localObject1 = this.hWV;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.live.b.x.hJf;
          if (!com.tencent.mm.live.b.x.aGG().isLandscape()) {
            break label358;
          }
          i = 2;
          localObject2 = com.tencent.mm.live.b.x.hJf;
          localObject2 = com.tencent.mm.live.b.x.aGG().userId;
          localObject3 = com.tencent.mm.live.b.x.hJf;
          ((bk)localObject1).c(i, (String)localObject2, com.tencent.mm.live.b.x.aGG().streamType);
        }
      }
    }
    for (;;)
    {
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz;
        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.b.g)localObject1).aDt() == true))
        {
          localObject2 = this.hWV;
          if (localObject2 != null)
          {
            localObject1 = ((bk)localObject2).liveCore;
            if (localObject1 != null)
            {
              localObject2 = ((bk)localObject2).hAs;
              localObject3 = com.tencent.mm.live.b.x.hJf;
              localObject3 = com.tencent.mm.live.b.x.aGk();
              com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
              ((com.tencent.mm.live.core.core.d.b)localObject1).a((LivePreviewView)localObject2, (com.tencent.mm.live.core.b.a)localObject3, com.tencent.mm.live.b.x.aGl());
            }
          }
        }
      }
      localObject1 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.setLastOrientation(j);
      AppMethodBeat.o(208628);
      return;
      label358:
      i = 1;
      break;
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz;
        if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.g)localObject1).hzz))
        {
          localObject1 = this.liveCore;
          if (localObject1 == null) {
            continue;
          }
          ((com.tencent.mm.live.core.core.d.b)localObject1).aBU();
          continue;
        }
      }
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.b.g)localObject1).hzz = false;
        }
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(208626);
    super.start();
    Object localObject = com.tencent.mm.live.b.r.hIg;
    com.tencent.mm.live.b.r.aGb();
    localObject = this.liveCore;
    if (((localObject == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject).hAz.aDt() != true)) && (this.hWg))
    {
      localObject = com.tencent.mm.live.b.x.hJf;
      if (!com.tencent.mm.live.b.x.aGD().hJn)
      {
        localObject = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJp)
        {
          localObject = getContext();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(208626);
            throw ((Throwable)localObject);
          }
          ((Activity)localObject).setRequestedOrientation(4);
        }
      }
    }
    startTimer();
    AppMethodBeat.o(208626);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(208623);
    p.h(paramc, "status");
    Log.i("MicroMsg.LiveCoreVisitor", "statusChange:" + paramc.name());
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(208623);
      return;
      Object localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      Object localObject2 = com.tencent.mm.live.b.x.hJf;
      ((com.tencent.mm.live.b.c.c)localObject1).GY(com.tencent.mm.live.b.x.aGm());
      localObject1 = com.tencent.mm.live.d.e.hTP;
      com.tencent.mm.live.d.e.aIK().pe(System.currentTimeMillis());
      localObject1 = com.tencent.mm.live.d.e.hTP;
      localObject1 = com.tencent.mm.live.d.e.aIK();
      localObject2 = com.tencent.mm.live.d.e.hTP;
      long l = com.tencent.mm.live.d.e.aIK().agB();
      localObject2 = com.tencent.mm.live.d.e.hTP;
      ((fp)localObject1).pc((l - com.tencent.mm.live.d.e.aIK().agA()) / 1000L);
      localObject1 = com.tencent.mm.live.d.e.hTP;
      localObject1 = com.tencent.mm.live.d.e.aIK();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      ((fp)localObject1).pf(com.tencent.mm.model.v.Ie(com.tencent.mm.live.b.x.aGm()));
      localObject1 = com.tencent.mm.live.b.x.hJf;
      localObject1 = com.tencent.mm.live.b.x.aGm();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      l = com.tencent.mm.live.b.x.aGr().hyH;
      localObject2 = com.tencent.mm.live.b.x.hJf;
      i = com.tencent.mm.live.b.x.aGN();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      j = com.tencent.mm.live.b.x.aGP();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      int k = com.tencent.mm.live.b.x.aGr().LIa;
      localObject2 = com.tencent.mm.live.b.x.hJf;
      int m = com.tencent.mm.live.b.x.aGQ();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      int n = com.tencent.mm.live.b.x.aGR();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      int i1 = com.tencent.mm.live.b.x.aGS();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      int i2 = com.tencent.mm.live.b.x.aGT();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, com.tencent.mm.live.b.x.aGr().MnN);
      localObject1 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aGy();
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(208623);
        throw paramc;
      }
      ((Activity)localObject1).finishAndRemoveTask();
      continue;
      localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      ((com.tencent.mm.live.b.c.c)localObject1).GY(com.tencent.mm.live.b.x.aGm());
      localObject1 = com.tencent.mm.live.d.e.hTP;
      com.tencent.mm.live.d.e.aIK().pe(System.currentTimeMillis());
      localObject1 = com.tencent.mm.live.d.e.hTP;
      localObject1 = com.tencent.mm.live.d.e.aIK();
      localObject2 = com.tencent.mm.live.d.e.hTP;
      l = com.tencent.mm.live.d.e.aIK().agB();
      localObject2 = com.tencent.mm.live.d.e.hTP;
      ((fp)localObject1).pc((l - com.tencent.mm.live.d.e.aIK().agA()) / 1000L);
      localObject1 = com.tencent.mm.live.d.e.hTP;
      localObject1 = com.tencent.mm.live.d.e.aIK();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      ((fp)localObject1).pf(com.tencent.mm.model.v.Ie(com.tencent.mm.live.b.x.aGm()));
      localObject1 = com.tencent.mm.live.b.x.hJf;
      localObject1 = com.tencent.mm.live.b.x.aGm();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      l = com.tencent.mm.live.b.x.aGr().hyH;
      localObject2 = com.tencent.mm.live.b.x.hJf;
      i = com.tencent.mm.live.b.x.aGN();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      j = com.tencent.mm.live.b.x.aGP();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      k = com.tencent.mm.live.b.x.aGr().LIa;
      localObject2 = com.tencent.mm.live.b.x.hJf;
      m = com.tencent.mm.live.b.x.aGQ();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      n = com.tencent.mm.live.b.x.aGR();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      i1 = com.tencent.mm.live.b.x.aGS();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      i2 = com.tencent.mm.live.b.x.aGT();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.d.e.a((String)localObject1, l, i, j, k, m, n, i1, i2, com.tencent.mm.live.b.x.aGr().MnN);
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.core.core.d.b)localObject1).aBW();
        localObject1 = kotlin.x.SXb;
      }
      localObject1 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aGy();
      localObject1 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aHh();
      localObject1 = com.tencent.mm.live.b.r.hIg;
      com.tencent.mm.live.b.r.aGb();
      continue;
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.core.core.d.b)localObject1).aBW();
        localObject1 = kotlin.x.SXb;
      }
      localObject1 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aHh();
      localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.b.x.hJf;
      ((com.tencent.mm.live.b.c.c)localObject1).zF(com.tencent.mm.live.b.x.aGr().hyH);
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(208623);
        throw paramc;
      }
      ((Activity)localObject1).setRequestedOrientation(1);
      continue;
      if (paramBundle != null) {}
      for (localObject1 = Boolean.valueOf(paramBundle.getBoolean("PARAM_LIVE_START_BY_ORIENTATION_CHANGE", false));; localObject1 = null)
      {
        if (p.j(localObject1, Boolean.FALSE))
        {
          this.hWh.aTv();
          com.tencent.mm.live.b.r.hIg.aGd();
          localObject1 = com.tencent.mm.live.b.r.hIg;
          com.tencent.mm.live.b.r.aFY();
          localObject1 = com.tencent.mm.live.b.r.hIg;
          com.tencent.mm.live.b.r.aGc();
        }
        localObject1 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aHf();
        localObject1 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.eM(false);
        startTimer();
        localObject1 = com.tencent.mm.live.d.e.hTP;
        com.tencent.mm.live.d.e.aIK().pd(System.currentTimeMillis());
        break;
      }
      localObject1 = com.tencent.mm.live.b.x.hJf;
      if (!com.tencent.mm.live.b.x.aGD().hJn)
      {
        localObject1 = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJp)
        {
          localObject1 = this.hVP;
          if (localObject1 != null)
          {
            ((ai)localObject1).rg(0);
            localObject1 = kotlin.x.SXb;
          }
          localObject1 = this.hVP;
          if (localObject1 != null)
          {
            ((ai)localObject1).aHF();
            localObject1 = kotlin.x.SXb;
            continue;
            localObject1 = com.tencent.mm.live.b.m.hGg;
            com.tencent.mm.live.b.m.aFh();
            com.tencent.mm.live.b.r.hIg.release();
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(208623);
              throw paramc;
            }
            ((Activity)localObject1).finishAndRemoveTask();
            continue;
            localObject1 = com.tencent.mm.live.b.x.hJf;
            localObject1 = com.tencent.mm.live.b.x.aGr().LpF;
            p.g(localObject1, "RoomLiveService.liveInfo.live_name");
            localObject2 = com.tencent.mm.live.b.x.hJf;
            l = com.tencent.mm.live.b.x.aGr().hyH;
            localObject2 = com.tencent.mm.live.b.x.hJf;
            c((String)localObject1, l, com.tencent.mm.live.b.x.aGm());
            continue;
            localObject2 = this.hWV;
            if (localObject2 != null)
            {
              localObject1 = this.hXa;
              if (localObject1 != null) {}
              for (localObject1 = ((bc)localObject1).aHL();; localObject1 = null)
              {
                ((bk)localObject2).hTC = ((com.tencent.mm.live.core.b.l)localObject1);
                break;
              }
              if (this.hWg)
              {
                localObject1 = getContext();
                if (localObject1 == null)
                {
                  paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                  AppMethodBeat.o(208623);
                  throw paramc;
                }
                ((Activity)localObject1).setRequestedOrientation(4);
                continue;
                localObject1 = getContext();
                if (localObject1 == null)
                {
                  paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                  AppMethodBeat.o(208623);
                  throw paramc;
                }
                ((Activity)localObject1).setRequestedOrientation(14);
                continue;
                localObject1 = com.tencent.mm.live.b.x.hJf;
                localObject1 = com.tencent.mm.live.b.x.aGv();
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.live.core.core.b.f)localObject1).hzt;
                  if (localObject1 != null) {
                    ((com.tencent.mm.live.core.core.b.d)localObject1).hzh = true;
                  }
                }
                if (this.hWg)
                {
                  localObject1 = getContext();
                  if (localObject1 == null)
                  {
                    paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(208623);
                    throw paramc;
                  }
                  ((Activity)localObject1).setRequestedOrientation(4);
                }
                i = this.hzl;
                localObject1 = e.a.hxc;
                if (i == e.a.aCf())
                {
                  localObject1 = this.hWV;
                  if (localObject1 != null)
                  {
                    ((bk)localObject1).exitRoom();
                    localObject1 = kotlin.x.SXb;
                  }
                  localObject1 = this.liveTXLivePlayerPlygin;
                  if (localObject1 != null)
                  {
                    ((aw)localObject1).rg(0);
                    localObject1 = kotlin.x.SXb;
                  }
                  localObject1 = this.liveTXLivePlayerPlygin;
                  if (localObject1 != null)
                  {
                    localObject1 = ((aw)localObject1).hwO;
                    if (localObject1 != null) {
                      ((TXLivePlayer)localObject1).resume();
                    }
                    localObject1 = kotlin.x.SXb;
                  }
                }
                localObject1 = this.hVX;
                if (localObject1 != null)
                {
                  this.hWe.remove(localObject1);
                  continue;
                  localObject1 = this.hVX;
                  if (localObject1 != null)
                  {
                    this.hWe.remove(localObject1);
                    continue;
                    i = this.hzl;
                    localObject1 = e.a.hxc;
                    if (i == e.a.aCe())
                    {
                      aJr();
                    }
                    else
                    {
                      localObject1 = e.a.hxc;
                      if (i == e.a.aCf())
                      {
                        localObject1 = com.tencent.mm.live.b.x.hJf;
                        localObject1 = com.tencent.mm.live.b.x.aGv();
                        if (localObject1 != null)
                        {
                          localObject2 = this.hWV;
                          if (localObject2 != null)
                          {
                            ((bk)localObject2).a((com.tencent.mm.live.core.core.b.f)localObject1, (kotlin.g.a.b)new p(this));
                            localObject1 = kotlin.x.SXb;
                            continue;
                            localObject1 = com.tencent.mm.live.b.x.hJf;
                            com.tencent.mm.live.b.x.aHg();
                            localObject1 = com.tencent.mm.live.b.r.hIg;
                            com.tencent.mm.live.b.r.aFZ();
                            localObject1 = com.tencent.mm.live.b.m.hGg;
                            com.tencent.mm.live.b.m.aFh();
                            com.tencent.mm.live.b.r.hIg.release();
                            localObject1 = this.hVO;
                            if (localObject1 != null)
                            {
                              ((ay)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hVL;
                            if (localObject1 != null)
                            {
                              ((as)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hVJ;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.c)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hWY;
                            if (localObject1 != null)
                            {
                              ((bg)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hWX;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.z)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hWW;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.c.v)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hVP;
                            if (localObject1 != null)
                            {
                              ((ai)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hVW;
                            if (localObject1 != null)
                            {
                              ((ae)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hWV;
                            if (localObject1 != null)
                            {
                              ((bk)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.liveTXLivePlayerPlygin;
                            if (localObject1 != null)
                            {
                              ((aw)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hXa;
                            if (localObject1 != null)
                            {
                              ((bc)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hVZ;
                            if (localObject1 != null)
                            {
                              ((ag)localObject1).rg(8);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hXb;
                            if (localObject1 != null)
                            {
                              ((ab)localObject1).rg(0);
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hXb;
                            Object localObject3;
                            if (localObject1 != null)
                            {
                              localObject2 = com.tencent.mm.live.b.x.hJf;
                              localObject2 = com.tencent.mm.live.b.x.aGt();
                              localObject3 = com.tencent.mm.live.b.d.a.hLg;
                              localObject3 = ((com.tencent.mm.live.c.a)localObject1).hwr.getContext();
                              p.g(localObject3, "root.context");
                              com.tencent.mm.live.b.d.a.a.a((String)localObject2, ((Context)localObject3).getResources().getColor(2131100584), (kotlin.g.a.b)new ab.a((ab)localObject1));
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.liveCore;
                            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz.aDt() != true))
                            {
                              localObject1 = this.liveCore;
                              if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz.aDu() != true))
                              {
                                i = this.hzl;
                                localObject1 = e.a.hxc;
                                if (i != e.a.aCe()) {
                                  break label2113;
                                }
                              }
                            }
                            localObject1 = this.liveCore;
                            if (localObject1 != null)
                            {
                              ((com.tencent.mm.live.core.core.d.b)localObject1).aEa();
                              localObject1 = kotlin.x.SXb;
                            }
                            localObject1 = this.hWV;
                            if (localObject1 != null)
                            {
                              ((bk)localObject1).exitRoom();
                              localObject1 = kotlin.x.SXb;
                              continue;
                              label2113:
                              localObject1 = this.liveTXLivePlayerPlygin;
                              if (localObject1 != null)
                              {
                                ((aw)localObject1).ev(false);
                                localObject1 = kotlin.x.SXb;
                                continue;
                                localObject1 = com.tencent.mm.live.b.x.hJf;
                                com.tencent.mm.live.b.x.qV(2);
                                localObject1 = com.tencent.mm.live.b.x.hJf;
                                if (!com.tencent.mm.live.b.x.aGD().hJn)
                                {
                                  localObject1 = com.tencent.mm.live.b.x.hJf;
                                  if (!com.tencent.mm.live.b.x.aGD().hJp)
                                  {
                                    localObject1 = this.hVW;
                                    if (localObject1 != null)
                                    {
                                      localObject2 = com.tencent.mm.live.b.x.hJf;
                                      localObject2 = com.tencent.mm.live.b.x.aGt();
                                      localObject3 = getContext();
                                      p.g(localObject3, "context");
                                      localObject3 = ((Context)localObject3).getResources().getString(2131762312);
                                      p.g(localObject3, "context.resources.getStr…_local_network_error_tip)");
                                      ((ae)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
                                      localObject1 = kotlin.x.SXb;
                                    }
                                    localObject1 = com.tencent.mm.live.b.x.hJf;
                                    com.tencent.mm.live.b.x.aHg();
                                    continue;
                                    localObject1 = com.tencent.mm.live.b.x.hJf;
                                    com.tencent.mm.live.b.x.qV(1);
                                    localObject1 = com.tencent.mm.live.b.x.hJf;
                                    if (!com.tencent.mm.live.b.x.aGD().hJn)
                                    {
                                      localObject1 = com.tencent.mm.live.b.x.hJf;
                                      if (!com.tencent.mm.live.b.x.aGD().hJp)
                                      {
                                        localObject1 = this.hVW;
                                        if (localObject1 != null)
                                        {
                                          localObject2 = com.tencent.mm.live.b.x.hJf;
                                          localObject2 = com.tencent.mm.live.b.x.aGt();
                                          localObject3 = getContext();
                                          p.g(localObject3, "context");
                                          localObject3 = ((Context)localObject3).getResources().getString(2131762255);
                                          p.g(localObject3, "context.resources.getStr…ive_anchor_exception_tip)");
                                          ((ae)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
                                          localObject1 = kotlin.x.SXb;
                                          continue;
                                          localObject1 = this.hWV;
                                          if (localObject1 != null)
                                          {
                                            ((bk)localObject1).rg(0);
                                            localObject1 = kotlin.x.SXb;
                                          }
                                          localObject1 = this.hWV;
                                          if (localObject1 != null)
                                          {
                                            ((bk)localObject1).aHQ();
                                            localObject1 = kotlin.x.SXb;
                                          }
                                          localObject1 = this.liveTXLivePlayerPlygin;
                                          if (localObject1 != null)
                                          {
                                            ((aw)localObject1).rg(8);
                                            localObject1 = kotlin.x.SXb;
                                          }
                                          localObject1 = this.liveTXLivePlayerPlygin;
                                          if (localObject1 != null)
                                          {
                                            localObject1 = ((aw)localObject1).hwO;
                                            if (localObject1 != null) {
                                              ((TXLivePlayer)localObject1).pause();
                                            }
                                            localObject1 = kotlin.x.SXb;
                                            continue;
                                            localObject1 = this.hVW;
                                            if (localObject1 != null)
                                            {
                                              ((ae)localObject1).rg(8);
                                              localObject1 = kotlin.x.SXb;
                                              continue;
                                              localObject1 = this.liveCore;
                                              if (localObject1 != null)
                                              {
                                                localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz;
                                                if ((localObject1 != null) && (!((com.tencent.mm.live.core.core.b.g)localObject1).isFloatMode()))
                                                {
                                                  localObject1 = this.liveCore;
                                                  if (localObject1 != null)
                                                  {
                                                    localObject2 = getContext();
                                                    p.g(localObject2, "context");
                                                    com.tencent.mm.live.core.core.b.a.a((com.tencent.mm.live.core.core.b)localObject1, (Context)localObject2, false, false, 0, 0, 30);
                                                  }
                                                  localObject1 = com.tencent.mm.live.b.x.hJf;
                                                  localObject1 = com.tencent.mm.live.b.x.aGm();
                                                  localObject2 = com.tencent.mm.live.b.x.hJf;
                                                  l = com.tencent.mm.live.b.x.aGr().hyH;
                                                  localObject2 = com.tencent.mm.live.b.x.hJf;
                                                  localObject2 = com.tencent.mm.live.b.x.aGt();
                                                  localObject3 = com.tencent.mm.live.b.x.hJf;
                                                  com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 1, com.tencent.mm.live.b.x.aGr().LIa);
                                                  com.tencent.mm.live.d.f.aIQ();
                                                  continue;
                                                  localObject1 = com.tencent.mm.live.b.x.hJf;
                                                  localObject1 = com.tencent.mm.live.b.x.aGm();
                                                  localObject2 = com.tencent.mm.live.b.x.hJf;
                                                  l = com.tencent.mm.live.b.x.aGr().hyH;
                                                  localObject2 = com.tencent.mm.live.b.x.hJf;
                                                  localObject2 = com.tencent.mm.live.b.x.aGt();
                                                  localObject3 = com.tencent.mm.live.b.x.hJf;
                                                  com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 2, 0, com.tencent.mm.live.b.x.aGr().LIa);
                                                  com.tencent.mm.live.d.f.aIR();
                                                  continue;
                                                  localObject1 = this.liveCore;
                                                  if (localObject1 != null)
                                                  {
                                                    localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz;
                                                    if (localObject1 != null)
                                                    {
                                                      ((com.tencent.mm.live.core.core.b.g)localObject1).hzE = g.d.hzW;
                                                      localObject1 = kotlin.x.SXb;
                                                      continue;
                                                      localObject1 = this.liveCore;
                                                      if (localObject1 != null)
                                                      {
                                                        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz;
                                                        if (localObject1 != null)
                                                        {
                                                          ((com.tencent.mm.live.core.core.b.g)localObject1).hzE = g.d.hzY;
                                                          localObject1 = kotlin.x.SXb;
                                                          continue;
                                                          localObject1 = this.hWV;
                                                          if (localObject1 != null)
                                                          {
                                                            localObject2 = com.tencent.mm.live.b.x.hJf;
                                                            if (com.tencent.mm.live.b.x.aGG().isLandscape()) {}
                                                            for (i = 2;; i = 1)
                                                            {
                                                              localObject2 = com.tencent.mm.live.b.x.hJf;
                                                              localObject2 = com.tencent.mm.live.b.x.aGG().userId;
                                                              localObject3 = com.tencent.mm.live.b.x.hJf;
                                                              ((bk)localObject1).c(i, (String)localObject2, com.tencent.mm.live.b.x.aGG().streamType);
                                                              localObject1 = kotlin.x.SXb;
                                                              break;
                                                            }
                                                            localObject1 = this.liveCore;
                                                            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.d.b)localObject1).aDx() != true))
                                                            {
                                                              localObject1 = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
                                                              localObject2 = com.tencent.mm.live.b.x.hJf;
                                                              ((com.tencent.mm.live.b.c.c)localObject1).GY(com.tencent.mm.live.b.x.aGm());
                                                              localObject1 = com.tencent.mm.live.b.x.hJf;
                                                              com.tencent.mm.live.b.x.aGy();
                                                              localObject1 = com.tencent.mm.live.b.x.hJf;
                                                              com.tencent.mm.live.b.x.aHi();
                                                              continue;
                                                              if (!isLandscape())
                                                              {
                                                                if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                                {
                                                                  localObject1 = this.hVM;
                                                                  if (localObject1 != null)
                                                                  {
                                                                    localObject1 = ((com.tencent.mm.live.c.a)localObject1).hwr;
                                                                    if (localObject1 == null) {}
                                                                  }
                                                                  for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                                  {
                                                                    ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
                                                                    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
                                                                    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
                                                                    localObject1 = this.hVM;
                                                                    if (localObject1 == null) {
                                                                      break;
                                                                    }
                                                                    localObject1 = ((com.tencent.mm.live.c.a)localObject1).hwr;
                                                                    if (localObject1 == null) {
                                                                      break;
                                                                    }
                                                                    ((ViewGroup)localObject1).requestLayout();
                                                                    localObject1 = kotlin.x.SXb;
                                                                    break;
                                                                  }
                                                                }
                                                                localObject1 = this.hVM;
                                                                if (localObject1 != null)
                                                                {
                                                                  localObject1 = ((com.tencent.mm.live.c.a)localObject1).hwr;
                                                                  if (localObject1 == null) {}
                                                                }
                                                                for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                                {
                                                                  ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
                                                                  localObject2 = (RelativeLayout.LayoutParams)localObject1;
                                                                  localObject3 = this.hWY;
                                                                  i = j;
                                                                  if (localObject3 != null)
                                                                  {
                                                                    localObject3 = ((com.tencent.mm.live.c.a)localObject3).hwr;
                                                                    i = j;
                                                                    if (localObject3 != null) {
                                                                      i = ((ViewGroup)localObject3).getId();
                                                                    }
                                                                  }
                                                                  ((RelativeLayout.LayoutParams)localObject2).addRule(2, i);
                                                                  ((RelativeLayout.LayoutParams)localObject1).bottomMargin = at.fromDPToPix(getContext(), 12);
                                                                  localObject1 = this.hVM;
                                                                  if (localObject1 == null) {
                                                                    break;
                                                                  }
                                                                  localObject1 = ((com.tencent.mm.live.c.a)localObject1).hwr;
                                                                  if (localObject1 == null) {
                                                                    break;
                                                                  }
                                                                  ((ViewGroup)localObject1).requestLayout();
                                                                  localObject1 = kotlin.x.SXb;
                                                                  break;
                                                                }
                                                              }
                                                              if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                              {
                                                                localObject1 = this.hVM;
                                                                if (localObject1 != null)
                                                                {
                                                                  ((com.tencent.mm.live.c.m)localObject1).rg(4);
                                                                  localObject1 = kotlin.x.SXb;
                                                                }
                                                              }
                                                              else
                                                              {
                                                                localObject1 = this.hVM;
                                                                if (localObject1 != null)
                                                                {
                                                                  ((com.tencent.mm.live.c.m)localObject1).rg(0);
                                                                  localObject1 = kotlin.x.SXb;
                                                                  continue;
                                                                  if (!isLandscape())
                                                                  {
                                                                    localObject1 = this.hWX;
                                                                    if ((localObject1 != null) && (((com.tencent.mm.live.c.a)localObject1).hwr.getVisibility() == 0))
                                                                    {
                                                                      if (paramBundle != null) {
                                                                        i = paramBundle.getInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT");
                                                                      }
                                                                      localObject1 = this.hVM;
                                                                      if (localObject1 != null)
                                                                      {
                                                                        localObject1 = ((com.tencent.mm.live.c.a)localObject1).hwr;
                                                                        if (localObject1 == null) {}
                                                                      }
                                                                      for (localObject1 = ((ViewGroup)localObject1).getLayoutParams(); (localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)); localObject1 = null)
                                                                      {
                                                                        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i;
                                                                        localObject1 = this.hVM;
                                                                        if (localObject1 == null) {
                                                                          break;
                                                                        }
                                                                        localObject1 = ((com.tencent.mm.live.c.a)localObject1).hwr;
                                                                        if (localObject1 == null) {
                                                                          break;
                                                                        }
                                                                        ((ViewGroup)localObject1).requestLayout();
                                                                        localObject1 = kotlin.x.SXb;
                                                                        break;
                                                                      }
                                                                      localObject1 = com.tencent.mm.live.b.x.hJf;
                                                                      if (!com.tencent.mm.live.b.x.aGD().hJn)
                                                                      {
                                                                        localObject1 = this.hWV;
                                                                        if (localObject1 != null)
                                                                        {
                                                                          ((bk)localObject1).rg(8);
                                                                          localObject1 = kotlin.x.SXb;
                                                                        }
                                                                        localObject1 = this.hVH;
                                                                        if (localObject1 != null)
                                                                        {
                                                                          ((com.tencent.mm.live.c.t)localObject1).rg(8);
                                                                          localObject1 = kotlin.x.SXb;
                                                                        }
                                                                        localObject1 = this.hVW;
                                                                        if (localObject1 != null)
                                                                        {
                                                                          ((ae)localObject1).rg(8);
                                                                          localObject1 = kotlin.x.SXb;
                                                                        }
                                                                        localObject1 = this.hWb;
                                                                        if (localObject1 != null)
                                                                        {
                                                                          ((com.tencent.mm.live.c.r)localObject1).rg(0);
                                                                          localObject1 = kotlin.x.SXb;
                                                                        }
                                                                        localObject1 = com.tencent.mm.live.b.x.hJf;
                                                                        com.tencent.mm.live.b.x.aHg();
                                                                        localObject1 = getContext();
                                                                        if (localObject1 == null)
                                                                        {
                                                                          paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                                                                          AppMethodBeat.o(208623);
                                                                          throw paramc;
                                                                        }
                                                                        ((Activity)localObject1).setRequestedOrientation(1);
                                                                        continue;
                                                                        localObject1 = com.tencent.mm.live.b.x.hJf;
                                                                        com.tencent.mm.live.b.x.aGD().hJq = true;
                                                                        continue;
                                                                        localObject1 = com.tencent.mm.live.b.x.hJf;
                                                                        localObject1 = com.tencent.mm.live.b.x.aGm();
                                                                        localObject2 = com.tencent.mm.live.b.x.hJf;
                                                                        l = com.tencent.mm.live.b.x.aGr().hyH;
                                                                        localObject2 = com.tencent.mm.live.b.x.hJf;
                                                                        localObject2 = com.tencent.mm.live.b.x.aGt();
                                                                        localObject3 = com.tencent.mm.model.z.aTY();
                                                                        p.g(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
                                                                        com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
                                                                        com.tencent.mm.live.d.e.a((String)localObject1, l, (String)localObject2, 8, 1, (String)localObject3, com.tencent.mm.live.b.x.aGr().LIa);
                                                                        com.tencent.mm.live.d.f.aIO();
                                                                        continue;
                                                                        localObject1 = this.hVO;
                                                                        if (localObject1 != null)
                                                                        {
                                                                          ((ay)localObject1).rg(4);
                                                                          localObject1 = kotlin.x.SXb;
                                                                          continue;
                                                                          localObject1 = com.tencent.mm.live.b.x.hJf;
                                                                          com.tencent.mm.live.b.x.qZ(com.tencent.mm.live.b.x.aGR() + 1);
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
  
  public final void stop()
  {
    AppMethodBeat.i(208627);
    super.stop();
    this.timerThread.stopTimer();
    AppMethodBeat.o(208627);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(208631);
    super.unMount();
    Object localObject1 = com.tencent.mm.live.b.x.hJf;
    int i;
    Object localObject2;
    if (com.tencent.mm.live.b.x.getLastOrientation() != -1)
    {
      localObject1 = com.tencent.mm.live.b.x.hJf;
      i = com.tencent.mm.live.b.x.getLastOrientation();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(208631);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.g(localObject1, "((context.getSystemServi…owManager).defaultDisplay");
      if (i != ((Display)localObject1).getRotation())
      {
        i = 1;
        if (i == 0)
        {
          localObject1 = this.liveTXLivePlayerPlygin;
          if (localObject1 != null) {
            ((aw)localObject1).ev(false);
          }
          localObject1 = com.tencent.mm.live.b.m.hGg;
          com.tencent.mm.live.b.m.aFh();
          localObject1 = com.tencent.mm.live.b.r.hIg;
          com.tencent.mm.live.b.r.aFZ();
          com.tencent.mm.live.b.r.hIg.release();
          localObject1 = this.liveCore;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.d.b)localObject1).aBW();
          }
          localObject1 = this.liveCore;
          if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz.aDu() != true))
          {
            localObject1 = this.liveCore;
            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).hAz.aDt() != true)) {
              break label301;
            }
          }
          localObject1 = com.tencent.mm.live.b.x.hJf;
          localObject1 = com.tencent.mm.live.b.x.aHa().hKU;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.live.b.r.hIg;
            com.tencent.mm.live.b.r.aw(((com.tencent.mm.live.b.b.a.a)localObject1).hFz, ((com.tencent.mm.live.b.b.a.a)localObject1).hFG);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("PARAM_HANGUP_SELF", true);
          statusChange(b.c.hLL, (Bundle)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.and();
      localObject1 = com.tencent.mm.live.core.core.d.b.hCo;
      com.tencent.mm.live.core.core.d.b.a.releaseInstance();
      this.hWh.apm();
      localObject1 = com.tencent.mm.kernel.g.aAg();
      p.g(localObject1, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject1).azz().b(3806, (i)this);
      this.timerThread.stopTimer();
      AppMethodBeat.o(208631);
      return;
      i = 0;
      break;
      label301:
      localObject1 = this.hWW;
      if ((localObject1 != null) && (((com.tencent.mm.live.c.v)localObject1).hQi.hTm == true))
      {
        localObject1 = com.tencent.mm.live.b.r.hIg;
        localObject1 = com.tencent.mm.live.b.x.hJf;
        String str = com.tencent.mm.live.b.x.aHa().hKV;
        localObject1 = com.tencent.mm.live.b.x.hJf;
        localObject2 = com.tencent.mm.live.b.x.aGr().MnL;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.live.b.r.aw(str, (String)localObject1);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, kotlin.x>
  {
    b(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    c(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    d(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.r<Integer, String, com.tencent.mm.live.core.core.b.e, TRTCCloudDef.TRTCParams, kotlin.x>
  {
    e(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class g
    implements DialogInterface.OnDismissListener
  {
    g(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(208600);
      paramDialogInterface = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aHg();
      b.b.a(this.hXf, b.c.hLD);
      AppMethodBeat.o(208600);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class i
    implements DialogInterface.OnDismissListener
  {
    i(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(208602);
      paramDialogInterface = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aHg();
      b.b.a(this.hXf, b.c.hLD);
      AppMethodBeat.o(208602);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Float, Float, kotlin.x>
  {
    k(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "x", "", "y", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Float, Float, kotlin.x>
  {
    l(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "liveID", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Long, kotlin.x>
  {
    m(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    n(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    o(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/live/view/LiveVisitorPluginLayout$statusChange$3$1"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    p(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class q
    implements MTimerHandler.CallBack
  {
    q(LiveVisitorPluginLayout paramLiveVisitorPluginLayout) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(208613);
      o localo = LiveVisitorPluginLayout.l(this.hXf);
      if ((localo != null) && (localo.hwr.getVisibility() == 0))
      {
        localo = LiveVisitorPluginLayout.l(this.hXf);
        if (localo != null)
        {
          com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
          int i = com.tencent.mm.live.b.x.aGr().LIa;
          localx = com.tencent.mm.live.b.x.hJf;
          localo.db(i, com.tencent.mm.live.b.x.aGr().LXG);
        }
      }
      AppMethodBeat.o(208613);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    r(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVisitorPluginLayout
 * JD-Core Version:    0.7.0.1
 */