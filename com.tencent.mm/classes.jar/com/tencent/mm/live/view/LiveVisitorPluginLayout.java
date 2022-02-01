package com.tencent.mm.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.autogen.mmdata.rpt.jf;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.aa;
import com.tencent.mm.live.b.ab;
import com.tencent.mm.live.b.ad;
import com.tencent.mm.live.b.ae;
import com.tencent.mm.live.b.af;
import com.tencent.mm.live.b.ag;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.b.p.a;
import com.tencent.mm.live.b.q;
import com.tencent.mm.live.b.t;
import com.tencent.mm.live.b.y;
import com.tencent.mm.live.c.e;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.core.core.f.d.a;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.i.e;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.live.model.l.a;
import com.tencent.mm.live.model.u.b;
import com.tencent.mm.live.model.u.c;
import com.tencent.mm.live.model.u.d;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bd;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/LiveVisitorPluginLayout;", "Lcom/tencent/mm/live/view/RoomBaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/live/core/core/LiveCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "anchorExceptionInTRTC", "", "audienceMode", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "curNetworkQuality", "liveAfterPlugin", "Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "liveCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveCommentPlugin;", "liveCommonInfoPlugin", "Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "liveDebugPlugin", "Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "liveExceptionPlugin", "Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "liveFaceVerifyPlugin", "Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "liveGuestRightPanelPlugin", "Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "liveInputPlugin", "Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "liveKickedPlugin", "Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "liveLikeConfettiPlugin", "Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "liveLoadingPlugin", "Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "liveMemberListPlugin", "Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "liveMemberProfilePlugin", "Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveMicUserHeaderPlugin", "Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "liveMinimizePlugin", "Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "livePreviewPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "liveShadowPlugin", "Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "liveTitlePlugin", "Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "liveVideoMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "liveVisitorClosePlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "liveVisitorCommentPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "miniView", "Lcom/tencent/mm/live/view/RoomLiveMiniView;", "getMiniView", "()Lcom/tencent/mm/live/view/RoomLiveMiniView;", "miniView$delegate", "Lkotlin/Lazy;", "pluginShow", "rotationEnable", "tempHidePlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "callback", "errorCode", "param", "Landroid/os/Bundle;", "checkAnchorStatus", "checkClickArea", "x", "", "y", "validCallback", "chooseAudienceMode", "byOrientationChange", "enterRoom", "liveName", "", "roomID", "", "wechatRoomId", "getLiveRole", "getRelativeLayoutId", "getRenderMode", "handleEnterRoom", "handleJoinLiveErr", "errCode", "errMsg", "initLogic", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "isLiving", "keyboardChange", "show", "height", "mount", "name", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onRotationSwitchChange", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "requestLinkMic", "resume", "start", "startTimer", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "stopTimer", "toggleShowPlugins", "unMount", "updatePlugin", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveVisitorPluginLayout
  extends RoomBaseLivePluginLayout
  implements com.tencent.mm.am.h, com.tencent.mm.live.core.core.c
{
  public static final LiveVisitorPluginLayout.a nnA;
  private int curNetworkQuality;
  private com.tencent.mm.live.core.core.f.d liveCore;
  private final kotlin.g.a.a<kotlin.ah> liveMessageCallback;
  private int mNn;
  private y nmA;
  private com.tencent.mm.live.b.h nmB;
  private ab nmD;
  private t nmE;
  private com.tencent.mm.live.b.i nmI;
  private com.tencent.mm.live.b.v nmJ;
  private com.tencent.mm.live.b.r nmL;
  private com.tencent.mm.live.b.u nmM;
  private q nmN;
  private com.tencent.mm.live.b.s nmO;
  private com.tencent.mm.live.b.k nmQ;
  private final ArrayList<com.tencent.mm.live.b.a> nmT;
  private boolean nmU;
  private boolean nmV;
  private final com.tencent.mm.model.d nmW;
  private MTimerHandler nmZ;
  private com.tencent.mm.live.b.l nmw;
  private com.tencent.mm.live.b.c nmy;
  private com.tencent.mm.live.b.ah nnB;
  private aa nnC;
  private com.tencent.mm.live.b.m nnD;
  private com.tencent.mm.live.b.o nnE;
  private af nnF;
  private com.tencent.mm.live.b.j nnG;
  private ad nnH;
  private com.tencent.mm.live.b.p nnI;
  private ae nnJ;
  private boolean nnK;
  private final kotlin.j nnL;
  
  static
  {
    AppMethodBeat.i(246483);
    nnA = new LiveVisitorPluginLayout.a((byte)0);
    AppMethodBeat.o(246483);
  }
  
  public LiveVisitorPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(246284);
    this.nmU = true;
    paramAttributeSet = e.b.mKf;
    this.mNn = e.b.bct();
    this.nmT = new ArrayList();
    this.nmW = new com.tencent.mm.model.d();
    paramAttributeSet = e.o.mLz;
    this.curNetworkQuality = e.o.bdD();
    this.nnL = kotlin.k.cm((kotlin.g.a.a)new m(paramContext, this));
    this.liveMessageCallback = ((kotlin.g.a.a)new l(this));
    this.nmZ = new MTimerHandler("LiveCommonInfoPlugin::Timer", new LiveVisitorPluginLayout..ExternalSyntheticLambda2(this), true);
    AppMethodBeat.o(246284);
  }
  
  private static final void a(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(246361);
    kotlin.g.b.s.u(paramLiveVisitorPluginLayout, "this$0");
    paramDialogInterface = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.biT();
    com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramLiveVisitorPluginLayout, b.c.ncl);
    AppMethodBeat.o(246361);
  }
  
  private final void a(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(246338);
    Log.i("MicroMsg.LiveCoreVisitor", "join, name:" + paramString1 + ", roomID:" + paramLong);
    com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
    new com.tencent.mm.live.model.h(com.tencent.mm.live.model.u.bie().mMJ, paramString2, paramString1, (byte)0).a((kotlin.g.a.r)new f(this));
    AppMethodBeat.o(246338);
  }
  
  private static final void b(LiveVisitorPluginLayout paramLiveVisitorPluginLayout, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(246371);
    kotlin.g.b.s.u(paramLiveVisitorPluginLayout, "this$0");
    paramDialogInterface = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.biT();
    com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramLiveVisitorPluginLayout, b.c.ncl);
    AppMethodBeat.o(246371);
  }
  
  private static final boolean b(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
  {
    AppMethodBeat.i(246346);
    kotlin.g.b.s.u(paramLiveVisitorPluginLayout, "this$0");
    Object localObject = paramLiveVisitorPluginLayout.nmI;
    if ((localObject != null) && (((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramLiveVisitorPluginLayout = paramLiveVisitorPluginLayout.nmI;
        if (paramLiveVisitorPluginLayout != null)
        {
          localObject = com.tencent.mm.live.model.u.mZl;
          i = com.tencent.mm.live.model.u.bie().ZWw;
          localObject = com.tencent.mm.live.model.u.mZl;
          paramLiveVisitorPluginLayout.eo(i, com.tencent.mm.live.model.u.bie().aaun);
        }
      }
      AppMethodBeat.o(246346);
      return true;
    }
  }
  
  private static void bld()
  {
    AppMethodBeat.i(246332);
    d.a locala = com.tencent.mm.live.core.core.f.d.mUj;
    Log.i("MicroMsg.LiveCoreVisitor", kotlin.g.b.s.X("requestLinkMic ret:", Integer.valueOf(d.a.bfM().bfF())));
    AppMethodBeat.o(246332);
  }
  
  private final void ge(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(246310);
    Log.i("MicroMsg.LiveCoreVisitor", kotlin.g.b.s.X("audienceMode:", Integer.valueOf(this.mNn)));
    int i = this.mNn;
    Object localObject1 = e.b.mKf;
    Object localObject3;
    long l;
    aa localaa;
    if (i == e.b.bct())
    {
      com.tencent.mm.live.c.f.bkJ();
      localObject1 = this.nnB;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.model.u.mZl;
        localObject2 = com.tencent.mm.live.model.u.bii();
        kotlin.g.b.s.checkNotNull(localObject2);
        ((com.tencent.mm.live.b.ah)localObject1).a((com.tencent.mm.live.core.core.model.h)localObject2, (kotlin.g.a.b)new d(paramBoolean, this));
      }
      localObject1 = this.nnB;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.b.ah)localObject1).tO(0);
        AppMethodBeat.o(246310);
      }
    }
    else
    {
      localObject1 = e.b.mKf;
      if (i == e.b.bcu())
      {
        com.tencent.mm.live.c.f.bkI();
        localObject1 = this.liveCore;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.live.model.u.mZl;
          localObject3 = com.tencent.mm.live.model.u.bii();
          kotlin.g.b.s.checkNotNull(localObject3);
          ((com.tencent.mm.live.core.core.f.d)localObject1).a((com.tencent.mm.live.core.core.model.h)localObject3);
        }
        localObject1 = this.liveCore;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.live.model.u.mZl;
          localObject3 = com.tencent.mm.live.model.u.bii();
          kotlin.g.b.s.checkNotNull(localObject3);
          ((com.tencent.mm.live.core.core.f.d)localObject1).b(((com.tencent.mm.live.core.core.model.h)localObject3).mJH);
        }
        localObject1 = this.nnC;
        if (localObject1 != null) {
          aa.a((aa)localObject1, getRenderMode(), (kotlin.g.a.b)new e(paramBoolean, this));
        }
        localObject1 = this.nnC;
        if (localObject1 != null) {
          ((aa)localObject1).tO(0);
        }
        localObject3 = this.liveCore;
        if (localObject3 != null)
        {
          localObject1 = com.tencent.mm.live.model.u.mZl;
          l = com.tencent.mm.live.model.u.bie().mMJ;
          localObject1 = this.nnC;
          if (localObject1 != null) {
            break label316;
          }
          localObject1 = null;
          localaa = this.nnC;
          if (localaa != null) {
            break label326;
          }
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.live.core.core.f.d)localObject3).a(l, (com.tencent.mm.live.core.core.c.b)localObject1, (TXCloudVideoView)localObject2);
      AppMethodBeat.o(246310);
      return;
      label316:
      localObject1 = ((aa)localObject1).mJG;
      break;
      label326:
      localObject2 = localaa.bjv();
    }
  }
  
  private final RoomLiveMiniView getMiniView()
  {
    AppMethodBeat.i(246291);
    RoomLiveMiniView localRoomLiveMiniView = (RoomLiveMiniView)this.nnL.getValue();
    AppMethodBeat.o(246291);
    return localRoomLiveMiniView;
  }
  
  private final int getRenderMode()
  {
    AppMethodBeat.i(246325);
    if (isLandscape())
    {
      AppMethodBeat.o(246325);
      return 1;
    }
    AppMethodBeat.o(246325);
    return 0;
  }
  
  private final void startTimer()
  {
    AppMethodBeat.i(246299);
    this.nmZ.stopTimer();
    this.nmZ.startTimer(1000L);
    AppMethodBeat.o(246299);
  }
  
  private static final void v(boolean paramBoolean, String paramString) {}
  
  private static final void w(boolean paramBoolean, String paramString) {}
  
  public final void callback(int paramInt, Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(246755);
    Log.i("MicroMsg.LiveCoreVisitor", kotlin.g.b.s.X("callback:", Integer.valueOf(paramInt)));
    e.g localg = e.g.mKv;
    if (paramInt == e.g.bcH())
    {
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.ncG);
      AppMethodBeat.o(246755);
      return;
    }
    localg = e.g.mKv;
    if (paramInt == e.g.bcI())
    {
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getString("live_user_id");
        paramBundle.getString("live_user_exit_reason");
        localObject3 = new StringBuilder("EVT_ROOM_USER_EXIT sdkUid:").append(localObject2).append(" micUid:");
        paramBundle = com.tencent.mm.live.model.u.mZl;
        paramBundle = com.tencent.mm.live.model.u.biN().nbN;
        if (paramBundle == null)
        {
          paramBundle = null;
          Log.i("MicroMsg.LiveCoreAnchor", paramBundle);
          paramBundle = com.tencent.mm.live.model.u.mZl;
          paramBundle = com.tencent.mm.live.model.u.biN().nbN;
          if (paramBundle != null) {
            break label315;
          }
        }
        label315:
        for (paramBundle = (Bundle)localObject1;; paramBundle = paramBundle.mXH)
        {
          if (!kotlin.g.b.s.p(localObject2, paramBundle))
          {
            paramBundle = com.tencent.mm.live.model.u.mZl;
            if (!kotlin.g.b.s.p(localObject2, com.tencent.mm.live.model.u.bie().aaNo)) {}
          }
          else
          {
            paramBundle = com.tencent.mm.live.model.u.mZl;
            paramBundle = com.tencent.mm.live.model.u.biN().nbN;
            if (paramBundle != null)
            {
              localObject1 = this.nnB;
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.live.b.ah)localObject1).mRt;
                if (localObject1 != null) {
                  ((LivePreviewView)localObject1).clearAnimation();
                }
              }
              localObject1 = com.tencent.mm.live.model.u.mZl;
              com.tencent.mm.live.model.u.biN().a(paramBundle.liveId, paramBundle.mXK, paramBundle.mXx);
            }
          }
          paramBundle = com.tencent.mm.live.model.u.mZl;
          if (kotlin.g.b.s.p(localObject2, com.tencent.mm.live.model.u.bie().aaNo))
          {
            this.nnK = true;
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.ndb);
          }
          AppMethodBeat.o(246755);
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
          if (paramBundle.getBoolean("live_media_enable"))
          {
            paramBundle = com.tencent.mm.live.model.u.mZl;
            localObject2 = com.tencent.mm.live.model.u.biN();
            if (localObject1 == null)
            {
              paramBundle = "";
              ((com.tencent.mm.live.model.b.a)localObject2).nbP = paramBundle;
              paramBundle = ((com.tencent.mm.live.model.b.a)localObject2).nbN;
              if (paramBundle != null) {
                break label442;
              }
            }
            label442:
            for (paramBundle = (Bundle)localObject3;; paramBundle = paramBundle.mXH)
            {
              if ((kotlin.g.b.s.p(localObject1, paramBundle)) && (!((com.tencent.mm.live.model.b.a)localObject2).biY()))
              {
                paramBundle = ((com.tencent.mm.live.model.b.a)localObject2).nbK;
                if (paramBundle != null) {
                  paramBundle.invoke();
                }
              }
              AppMethodBeat.o(246755);
              return;
              paramBundle = (Bundle)localObject1;
              break;
            }
          }
          com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.ncs);
          AppMethodBeat.o(246755);
        }
      }
      else
      {
        localObject1 = e.g.mKv;
        if (paramInt == e.g.bcK())
        {
          i = this.curNetworkQuality;
          paramBundle = this.liveCore;
          if (paramBundle == null)
          {
            paramBundle = localObject4;
            if (paramBundle != null) {
              break label596;
            }
            paramBundle = e.o.mLz;
          }
          label596:
          for (paramInt = e.o.bdD();; paramInt = paramBundle.intValue())
          {
            this.curNetworkQuality = paramInt;
            paramBundle = e.o.mLz;
            if (i == e.o.bdF()) {
              break label604;
            }
            paramInt = this.curNetworkQuality;
            paramBundle = e.o.mLz;
            if (paramInt != e.o.bdF()) {
              break label604;
            }
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.ncZ);
            paramBundle = this.nnB;
            if (paramBundle == null) {
              break label1304;
            }
            paramBundle.pause();
            AppMethodBeat.o(246755);
            return;
            localObject1 = paramBundle.mRB;
            paramBundle = localObject4;
            if (localObject1 == null) {
              break;
            }
            paramBundle = Integer.valueOf(((com.tencent.mm.live.core.core.model.i)localObject1).mNT);
            break;
          }
          label604:
          paramBundle = e.o.mLz;
          if (i == e.o.bdF())
          {
            paramInt = this.curNetworkQuality;
            paramBundle = e.o.mLz;
            if (paramInt != e.o.bdF())
            {
              com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.nda);
              paramBundle = this.nnB;
              if (paramBundle != null) {
                paramBundle.resume();
              }
              paramBundle = com.tencent.mm.live.model.o.mZb;
              com.tencent.mm.live.model.o.bhM();
              AppMethodBeat.o(246755);
            }
          }
        }
        else
        {
          localObject1 = e.g.mKv;
          label708:
          label729:
          long l;
          if (paramInt == e.g.bcL())
          {
            paramBundle = this.liveCore;
            int k;
            if ((paramBundle != null) && (paramBundle.mRB.beu() == true))
            {
              i = 1;
              if (i == 0) {
                break label801;
              }
              i = 1;
              k = this.mNn;
              paramBundle = e.b.mKf;
              if (k != e.b.bct()) {
                break label842;
              }
              j = 2;
              paramBundle = com.tencent.mm.live.model.u.mZl;
              localObject2 = com.tencent.mm.live.model.u.bhZ();
              paramBundle = com.tencent.mm.live.model.u.mZl;
              l = com.tencent.mm.live.model.u.bie().mMJ;
              paramBundle = com.tencent.mm.live.model.u.mZl;
              paramBundle = com.tencent.mm.live.model.u.biN().nbN;
              if (paramBundle != null) {
                break label860;
              }
              paramBundle = "";
            }
            for (;;)
            {
              localObject1 = com.tencent.mm.live.model.u.mZl;
              e.b((String)localObject2, l, paramBundle, com.tencent.mm.live.model.u.big(), i, j, paramInt);
              AppMethodBeat.o(246755);
              return;
              i = 0;
              break;
              label801:
              paramBundle = this.liveCore;
              if ((paramBundle != null) && (paramBundle.mRB.bet() == true)) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label837;
                }
                i = 2;
                break;
              }
              label837:
              i = 0;
              break label708;
              label842:
              paramBundle = e.b.mKf;
              if (k != e.b.bcu()) {
                break label729;
              }
              j = 1;
              break label729;
              label860:
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
            new com.tencent.mm.live.model.h(l, paramBundle, (String)localObject1, (byte)0).a((kotlin.g.a.r)new c(this));
            AppMethodBeat.o(246755);
            return;
          }
          localObject1 = e.g.mKv;
          if (paramInt == e.g.bcO())
          {
            if (paramBundle == null)
            {
              localObject1 = "";
              localObject3 = this.liveCore;
              if (localObject3 != null) {
                break label1132;
              }
              label1000:
              if (Util.isEqual((String)localObject1, (String)localObject2)) {
                break label1187;
              }
              localObject2 = com.tencent.mm.live.model.u.mZl;
              com.tencent.mm.live.model.u.bit().setUserId((String)localObject1);
              localObject1 = com.tencent.mm.live.model.u.mZl;
              localObject1 = com.tencent.mm.live.model.u.bit();
              if (paramBundle != null) {
                break label1154;
              }
              paramInt = 0;
              label1039:
              ((u.c)localObject1).streamType = paramInt;
              localObject1 = com.tencent.mm.live.model.u.mZl;
              localObject1 = com.tencent.mm.live.model.u.bit();
              if (paramBundle != null) {
                break label1165;
              }
              paramInt = 0;
              label1061:
              ((u.c)localObject1).width = paramInt;
              localObject1 = com.tencent.mm.live.model.u.mZl;
              localObject1 = com.tencent.mm.live.model.u.bit();
              if (paramBundle != null) {
                break label1176;
              }
            }
            label1154:
            label1165:
            label1176:
            for (paramInt = i;; paramInt = paramBundle.getInt("live_first_frame_height"))
            {
              ((u.c)localObject1).height = paramInt;
              com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.ndj);
              AppMethodBeat.o(246755);
              return;
              localObject3 = paramBundle.getString("live_user_id");
              localObject1 = localObject3;
              if (localObject3 != null) {
                break;
              }
              localObject1 = "";
              break;
              label1132:
              localObject3 = ((com.tencent.mm.live.core.core.trtc.a)localObject3).mRB;
              if (localObject3 == null) {
                break label1000;
              }
              localObject2 = ((com.tencent.mm.live.core.core.model.i)localObject3).mNM;
              break label1000;
              paramInt = paramBundle.getInt("live_stream_type");
              break label1039;
              paramInt = paramBundle.getInt("live_first_frame_width");
              break label1061;
            }
            label1187:
            this.nnK = false;
            AppMethodBeat.o(246755);
            return;
          }
          paramBundle = e.g.mKv;
          if (paramInt == e.g.bcR())
          {
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.ncj);
            AppMethodBeat.o(246755);
            return;
          }
          paramBundle = e.g.mKv;
          if (paramInt == e.g.bcT())
          {
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.nda);
            AppMethodBeat.o(246755);
            return;
          }
          paramBundle = e.g.mKv;
          if (paramInt == e.g.bcU())
          {
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.ncY);
            AppMethodBeat.o(246755);
            return;
          }
          paramBundle = e.g.mKv;
          if (paramInt == e.g.bcV()) {
            com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.ncZ);
          }
        }
      }
    }
    label1304:
    AppMethodBeat.o(246755);
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
    Object localObject2 = null;
    AppMethodBeat.i(246565);
    kotlin.g.b.s.u(paramLiveConfig, "config");
    Object localObject1 = com.tencent.mm.live.core.core.f.d.mUj;
    this.liveCore = d.a.bfM();
    localObject1 = this.liveCore;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.f.d)localObject1).a((AbsLiveMiniView)getMiniView());
    }
    localObject1 = this.liveCore;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRy = ((com.tencent.mm.live.core.core.c)this);
    }
    localObject1 = com.tencent.mm.live.model.u.mZl;
    localObject1 = paramLiveConfig.mIz;
    kotlin.g.b.s.s(localObject1, "config.hostRoomId");
    com.tencent.mm.live.model.u.Go((String)localObject1);
    localObject1 = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.a(new dio());
    localObject1 = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.bie().mMJ = paramLiveConfig.liveId;
    localObject1 = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.Gp(paramLiveConfig.thumbUrl);
    localObject1 = com.tencent.mm.live.model.u.mZl;
    localObject1 = paramLiveConfig.mIC;
    kotlin.g.b.s.s(localObject1, "config.anchorUsername");
    com.tencent.mm.live.model.u.Gq((String)localObject1);
    localObject1 = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.bie().YLD = true;
    localObject1 = findViewById(b.e.live_right_panel_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_right_panel_ui_root)");
    this.nnD = new com.tencent.mm.live.b.m((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_title_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_title_ui_root)");
    this.nmD = new ab((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_visitor_comment_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_visitor_comment_root)");
    this.nnF = new af((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_input_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_input_ui_root)");
    this.nnE = new com.tencent.mm.live.b.o((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_after_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_after_ui_root)");
    this.nmy = new com.tencent.mm.live.b.c((RelativeLayout)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_input_debug_view_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_input_debug_view_root)");
    this.nnG = new com.tencent.mm.live.b.j((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_loading_view_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_loading_view_root)");
    this.nmL = new com.tencent.mm.live.b.r((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_comment_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_comment_ui_root)");
    this.nmB = new com.tencent.mm.live.b.h((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_members_list_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_members_list_ui_root)");
    this.nmE = new t((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_like_confetti_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_like_confetti_ui_root)");
    this.nmN = new q((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_mic_visitor_header_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_mic_visitor_header_root)");
    this.nmM = new com.tencent.mm.live.b.u((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_preview_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_preview_ui_root)");
    this.nnB = new com.tencent.mm.live.b.ah((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_tx_live_player_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_tx_live_player_ui_root)");
    this.nnC = new aa((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_shadow_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_shadow_ui_root)");
    this.nmA = new y((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_video_mic_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_video_mic_ui_root)");
    this.nnH = new ad((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_members_profile_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_members_profile_ui_root)");
    this.nmO = new com.tencent.mm.live.b.s((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_kicked_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_kicked_ui_root)");
    this.nnI = new com.tencent.mm.live.b.p((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_visitor_close_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_visitor_close_ui_root)");
    this.nnJ = new ae((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_common_info_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_common_info_ui_root)");
    this.nmI = new com.tencent.mm.live.b.i((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_exception_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_exception_ui_root)");
    this.nmQ = new com.tencent.mm.live.b.k((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_face_verify_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_face_verify_ui_root)");
    this.nmw = new com.tencent.mm.live.b.l((RelativeLayout)localObject1, (com.tencent.mm.live.b.b)this);
    localObject1 = findViewById(b.e.live_minimize_ui_root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.live_minimize_ui_root)");
    this.nmJ = new com.tencent.mm.live.b.v((ViewGroup)localObject1, (com.tencent.mm.live.b.b)this);
    Object localObject3 = this.nnB;
    if (localObject3 != null)
    {
      localObject1 = this.nnH;
      if (localObject1 == null)
      {
        localObject1 = null;
        ((com.tencent.mm.live.b.ah)localObject3).nkE = ((com.tencent.mm.live.core.b.k)localObject1);
      }
    }
    else
    {
      localObject1 = com.tencent.mm.live.model.o.mZb;
      com.tencent.mm.live.model.o.a(paramLiveConfig);
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
      ab localab = this.nmD;
      if (localab != null)
      {
        localObject1 = com.tencent.mm.live.model.u.mZl;
        localObject3 = com.tencent.mm.live.model.u.bie().Zqd;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject1 = (CharSequence)localObject1;
        localObject3 = com.tencent.mm.live.model.u.mZl;
        localab.a((CharSequence)localObject1, com.tencent.mm.live.model.u.big());
      }
      localObject1 = this.nmE;
      if (localObject1 != null) {
        ((t)localObject1).a(paramLiveConfig);
      }
      localObject1 = this.nmO;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.s)localObject1).a(paramLiveConfig);
      }
      localObject1 = this.nmI;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.i)localObject1).bjl();
      }
      localObject1 = this.nnC;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.live.core.core.f.d.mUj;
        ((aa)localObject1).liveCore = d.a.bfM();
      }
      localObject3 = this.nnH;
      if (localObject3 != null)
      {
        kotlin.g.b.s.u(paramLiveConfig, "config");
        if (paramLiveConfig.mIy != LiveConfig.mIs) {
          break label1796;
        }
        localObject1 = com.tencent.mm.live.core.core.a.b.mMo;
        localObject1 = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.bej();
        label1254:
        ((ad)localObject3).nkg = ((com.tencent.mm.live.core.core.trtc.a)localObject1);
      }
      localObject1 = this.nmI;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.i)localObject1).tO(8);
      }
      localObject1 = this.nnJ;
      if (localObject1 != null) {
        ((ae)localObject1).tO(8);
      }
      localObject1 = this.nmy;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.c)localObject1).tO(8);
      }
      localObject1 = this.nnF;
      if (localObject1 != null) {
        ((af)localObject1).tO(8);
      }
      localObject1 = this.nnE;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.o)localObject1).tO(8);
      }
      localObject1 = this.nnD;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.m)localObject1).tO(8);
      }
      localObject1 = this.nmE;
      if (localObject1 != null) {
        ((t)localObject1).tO(8);
      }
      localObject1 = this.nmL;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.r)localObject1).GA(paramLiveConfig.mIC);
      }
      localObject1 = this.nnB;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.ah)localObject1).tO(0);
      }
      localObject1 = this.nnC;
      if (localObject1 != null) {
        ((aa)localObject1).tO(8);
      }
      localObject1 = this.nmA;
      if (localObject1 != null) {
        ((y)localObject1).tO(8);
      }
      localObject1 = this.nnH;
      if (localObject1 != null) {
        ((ad)localObject1).tO(8);
      }
      localObject1 = this.nmO;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.s)localObject1).tO(8);
      }
      localObject1 = this.nnI;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.p)localObject1).tO(8);
      }
      localObject1 = this.nmQ;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.k)localObject1).tO(8);
      }
      localObject1 = this.nmw;
      if (localObject1 != null) {
        ((com.tencent.mm.live.b.l)localObject1).tO(8);
      }
      localObject3 = this.nnB;
      if (localObject3 != null)
      {
        localObject1 = (kotlin.g.a.m)new h(this);
        localObject3 = ((com.tencent.mm.live.b.ah)localObject3).mRt;
        if (localObject3 != null) {
          ((LivePreviewView)localObject3).setPreviewTouchListener((kotlin.g.a.m)localObject1);
        }
      }
      localObject1 = this.nnC;
      if (localObject1 != null)
      {
        localObject3 = (kotlin.g.a.m)new i(this);
        ((aa)localObject1).njU.setPreviewTouchListener((kotlin.g.a.m)localObject3);
      }
      if (paramLiveConfig.scene == LiveConfig.mIq)
      {
        paramLiveConfig = this.nmy;
        if (paramLiveConfig != null)
        {
          paramLiveConfig.ngg.setVisibility(8);
          paramLiveConfig.ngf.setVisibility(0);
        }
      }
      paramLiveConfig = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.biN().nbH = ((kotlin.g.a.b)new j(this));
      paramLiveConfig = com.tencent.mm.live.model.j.mXT;
      com.tencent.mm.live.model.j.i(name(), (kotlin.g.a.a)new k(this));
      if (!LiveConfig.bcc()) {
        break label1812;
      }
      paramLiveConfig = findViewById(b.e.live_face_verify_ui_root);
      kotlin.g.b.s.s(paramLiveConfig, "findViewById(R.id.live_face_verify_ui_root)");
      this.nmw = new com.tencent.mm.live.b.l((RelativeLayout)paramLiveConfig, (com.tencent.mm.live.b.b)this);
      statusChange(b.c.ndk, new Bundle());
      LiveConfig.fC(false);
    }
    for (;;)
    {
      paramLiveConfig = com.tencent.mm.live.model.j.mXT;
      com.tencent.mm.live.model.j.g(name(), this.liveMessageCallback);
      AppMethodBeat.o(246565);
      return;
      localObject1 = ((ad)localObject1).bjx();
      break;
      label1796:
      localObject1 = com.tencent.mm.live.core.core.f.d.mUj;
      localObject1 = (com.tencent.mm.live.core.core.trtc.a)d.a.bfM();
      break label1254;
      label1812:
      if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adft, 0) == 1)
      {
        paramLiveConfig = this.nnG;
        if (paramLiveConfig != null) {
          paramLiveConfig.tO(0);
        }
      }
      else
      {
        paramLiveConfig = com.tencent.mm.live.model.u.mZl;
        if (com.tencent.mm.live.model.u.getLastOrientation() != -1)
        {
          paramLiveConfig = com.tencent.mm.live.model.u.mZl;
          i = com.tencent.mm.live.model.u.getLastOrientation();
          paramLiveConfig = getContext().getSystemService("window");
          if (paramLiveConfig == null)
          {
            paramLiveConfig = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(246565);
            throw paramLiveConfig;
          }
          if (i != ((WindowManager)paramLiveConfig).getDefaultDisplay().getRotation()) {}
        }
        else
        {
          paramLiveConfig = com.tencent.mm.live.model.u.mZl;
          localObject1 = com.tencent.mm.live.model.u.bie().Zqd;
          paramLiveConfig = (LiveConfig)localObject1;
          if (localObject1 == null) {
            paramLiveConfig = "";
          }
          localObject1 = com.tencent.mm.live.model.u.mZl;
          long l = com.tencent.mm.live.model.u.bie().mMJ;
          localObject1 = com.tencent.mm.live.model.u.mZl;
          a(paramLiveConfig, l, com.tencent.mm.live.model.u.bhZ());
          continue;
        }
        paramLiveConfig = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nai) {
          break label1996;
        }
        com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.ncD);
      }
    }
    label1996:
    paramLiveConfig = this.liveCore;
    if (paramLiveConfig != null)
    {
      paramLiveConfig = paramLiveConfig.mRB;
      if ((paramLiveConfig != null) && (paramLiveConfig.bet() == true))
      {
        i = 1;
        label2024:
        if (i == 0)
        {
          paramLiveConfig = this.liveCore;
          if (paramLiveConfig == null) {
            break label2078;
          }
          paramLiveConfig = paramLiveConfig.mRB;
          if ((paramLiveConfig == null) || (paramLiveConfig.beu() != true)) {
            break label2078;
          }
        }
      }
    }
    label2078:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label2083;
      }
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.ncj);
      break;
      i = 0;
      break label2024;
    }
    label2083:
    paramLiveConfig = com.tencent.mm.live.model.u.mZl;
    paramLiveConfig = com.tencent.mm.live.model.u.bii();
    if (paramLiveConfig == null)
    {
      paramLiveConfig = localObject2;
      label2098:
      if (paramLiveConfig != null) {
        break label2201;
      }
      paramLiveConfig = e.b.mKf;
    }
    label2201:
    for (i = e.b.bcu();; i = paramLiveConfig.intValue())
    {
      this.mNn = i;
      ge(true);
      paramLiveConfig = com.tencent.mm.live.model.u.mZl;
      if (!com.tencent.mm.live.model.u.bir().naf) {
        break;
      }
      paramLiveConfig = this.nmw;
      if (paramLiveConfig != null) {
        paramLiveConfig.tO(0);
      }
      statusChange(b.c.ncf, new Bundle());
      paramLiveConfig = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.bir().naf = false;
      break;
      localObject1 = paramLiveConfig.mJH;
      paramLiveConfig = localObject2;
      if (localObject1 == null) {
        break label2098;
      }
      paramLiveConfig = Integer.valueOf(((g)localObject1).mNn);
      break label2098;
    }
  }
  
  public final boolean isLiving()
  {
    AppMethodBeat.i(246713);
    Object localObject = this.liveCore;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.model.i)localObject).isLiving() == true))
      {
        AppMethodBeat.o(246713);
        return true;
      }
    }
    AppMethodBeat.o(246713);
    return false;
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(246737);
    super.keyboardChange(paramBoolean, paramInt);
    AppMethodBeat.o(246737);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(246684);
    super.mount();
    com.tencent.mm.kernel.h.baD().mCm.a(3806, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(246684);
  }
  
  public final String name()
  {
    AppMethodBeat.i(246641);
    String str = LiveVisitorPluginLayout.class.getSimpleName();
    kotlin.g.b.s.s(str, "LiveVisitorPluginLayout::class.java.simpleName");
    AppMethodBeat.o(246641);
    return str;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(246721);
    boolean bool2 = super.onBackPress();
    boolean bool1 = bool2;
    if (!bool2)
    {
      com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
      bool1 = bool2;
      if (com.tencent.mm.live.model.u.biq().naj)
      {
        localu = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.biq().naj = false;
        com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)this, b.c.nck);
        bool1 = true;
      }
    }
    AppMethodBeat.o(246721);
    return bool1;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(246575);
    kotlin.g.b.s.u(paramString, "incomingNumber");
    StringBuilder localStringBuilder = new StringBuilder("onCallStateChanged state:").append(paramInt).append(", isFloatMode:");
    paramString = this.liveCore;
    if (paramString == null) {
      paramString = localObject;
    }
    for (;;)
    {
      Log.i("MicroMsg.LiveCoreVisitor", paramString);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(246575);
        return;
        com.tencent.mm.live.core.core.model.i locali = paramString.mRB;
        paramString = localObject;
        if (locali != null) {
          paramString = Boolean.valueOf(locali.isFloatMode());
        }
        break;
      }
    }
    AppMethodBeat.o(246575);
    return;
    paramString = com.tencent.mm.live.model.o.mZb;
    com.tencent.mm.live.model.o.bhK();
    paramString = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.bil();
    paramString = this.liveCore;
    if ((paramString != null) && (paramString.mRB.bet() == true)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        paramString = this.liveCore;
        if (paramString != null) {
          paramString.bce();
        }
      }
      paramString = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.biV();
      break;
    }
  }
  
  public final void onRotationSwitchChange(boolean paramBoolean)
  {
    this.nmV = paramBoolean;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(246730);
    Log.i("MicroMsg.LiveCoreVisitor", "errType:" + paramInt1 + " errCode:" + paramInt2);
    if (((paramp instanceof com.tencent.mm.live.model.a.b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.nnF;
      if (paramString != null) {
        paramString.bjy();
      }
      ab localab = this.nmD;
      if (localab != null)
      {
        paramString = com.tencent.mm.live.model.u.mZl;
        paramp = com.tencent.mm.live.model.u.bie().Zqd;
        paramString = paramp;
        if (paramp == null) {
          paramString = "";
        }
        paramString = (CharSequence)paramString;
        paramp = com.tencent.mm.live.model.u.mZl;
        localab.a(paramString, com.tencent.mm.live.model.u.big());
      }
      paramString = com.tencent.mm.live.model.u.mZl;
      paramString = com.tencent.mm.live.model.u.mZl;
      if (com.tencent.mm.live.model.u.bie().YLD) {
        break label154;
      }
    }
    label154:
    for (paramInt1 = cn.getSyncServerTimeSecond();; paramInt1 = 0)
    {
      com.tencent.mm.live.model.u.tC(paramInt1);
      AppMethodBeat.o(246730);
      return;
    }
  }
  
  public final void pause()
  {
    int j = 1;
    AppMethodBeat.i(246677);
    super.pause();
    Object localObject1 = com.tencent.mm.live.model.u.mZl;
    if (com.tencent.mm.live.model.u.getLastOrientation() != -1)
    {
      localObject1 = com.tencent.mm.live.model.u.mZl;
      i = com.tencent.mm.live.model.u.getLastOrientation();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(246677);
        throw ((Throwable)localObject1);
      }
      if (i == ((WindowManager)localObject1).getDefaultDisplay().getRotation()) {}
    }
    Object localObject2;
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new StringBuilder("orientationChanged:").append(bool).append(", ");
      localObject2 = getContext().getSystemService("window");
      if (localObject2 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(246677);
      throw ((Throwable)localObject1);
    }
    Log.i("MicroMsg.LiveCoreVisitor", ((WindowManager)localObject2).getDefaultDisplay().getRotation());
    if (!bool)
    {
      localObject1 = com.tencent.mm.live.model.u.mZl;
      if (!com.tencent.mm.live.model.u.biq().nai)
      {
        localObject1 = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nak)
        {
          localObject1 = com.tencent.mm.live.model.u.mZl;
          if (!com.tencent.mm.live.model.u.biq().nal)
          {
            localObject1 = com.tencent.mm.live.model.u.mZl;
            if (com.tencent.mm.live.model.u.biq().naj)
            {
              localObject1 = com.tencent.mm.live.model.u.mZl;
              if ((!com.tencent.mm.live.model.u.isManualClosed()) && (com.tencent.mm.compatible.e.b.dh(getContext())))
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 3);
                statusChange(b.c.ncx, (Bundle)localObject1);
                localObject1 = this.liveCore;
                if (localObject1 == null) {
                  break label414;
                }
                localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
                if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).bet() != true)) {
                  break label414;
                }
              }
            }
          }
        }
      }
    }
    label412:
    label414:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = this.liveCore;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.f.d)localObject1).bce();
        }
      }
      AppMethodBeat.o(246677);
      return;
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).bep() != true)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label412;
        }
        localObject1 = this.liveCore;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.live.core.core.f.d)localObject1).bfH();
        break;
      }
      break;
    }
  }
  
  public final void resume()
  {
    int j = 1;
    AppMethodBeat.i(246667);
    Object localObject1 = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.model.u.biq().nal = false;
    localObject1 = getContext().getSystemService("window");
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(246667);
      throw ((Throwable)localObject1);
    }
    int k = ((WindowManager)localObject1).getDefaultDisplay().getRotation();
    localObject1 = new StringBuilder("curOrientation:").append(k).append(", lastOrientation:");
    Object localObject2 = com.tencent.mm.live.model.u.mZl;
    Log.i("MicroMsg.LiveCoreVisitor", com.tencent.mm.live.model.u.getLastOrientation());
    super.resume();
    localObject1 = this.liveCore;
    label257:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      if ((localObject1 != null) && (((com.tencent.mm.live.core.core.model.i)localObject1).bep() == true))
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = this.liveCore;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.f.d)localObject1).bfI();
          }
        }
        localObject1 = com.tencent.mm.live.model.u.mZl;
        if (com.tencent.mm.live.model.u.getLastOrientation() == -1) {
          break label427;
        }
        localObject1 = com.tencent.mm.live.model.u.mZl;
        if (k == com.tencent.mm.live.model.u.getLastOrientation()) {
          break label427;
        }
        localObject1 = this.liveCore;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.f.d)localObject1).bcg();
        }
        localObject1 = this.liveCore;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.f.d)localObject1).bfE();
        }
        localObject1 = this.nnB;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.live.model.u.mZl;
          if (!com.tencent.mm.live.model.u.bit().isLandscape()) {
            break label422;
          }
          i = 2;
          localObject2 = com.tencent.mm.live.model.u.mZl;
          localObject2 = com.tencent.mm.live.model.u.bit().userId;
          localObject3 = com.tencent.mm.live.model.u.mZl;
          ((com.tencent.mm.live.b.ah)localObject1).c(i, (String)localObject2, com.tencent.mm.live.model.u.bit().streamType);
        }
        label289:
        localObject1 = this.liveCore;
        if (localObject1 == null) {
          break label520;
        }
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).bet() != true)) {
          break label520;
        }
      }
    }
    label520:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = this.nnB;
        if (localObject1 != null) {
          ((com.tencent.mm.live.b.ah)localObject1).bjr();
        }
        localObject2 = this.nnB;
        if (localObject2 != null)
        {
          localObject1 = ((com.tencent.mm.live.b.ah)localObject2).liveCore;
          if (localObject1 != null)
          {
            localObject2 = ((com.tencent.mm.live.b.ah)localObject2).mRt;
            localObject3 = com.tencent.mm.live.model.u.mZl;
            localObject3 = com.tencent.mm.live.model.u.bhX();
            com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
            ((com.tencent.mm.live.core.core.f.d)localObject1).a((LivePreviewView)localObject2, (com.tencent.mm.live.core.b.a)localObject3, com.tencent.mm.live.model.u.bhY());
          }
        }
      }
      localObject1 = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.setLastOrientation(k);
      AppMethodBeat.o(246667);
      return;
      i = 0;
      break;
      label422:
      i = 1;
      break label257;
      label427:
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).mNF)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label488;
        }
        localObject1 = this.liveCore;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.live.core.core.f.d)localObject1).bcg();
        break;
      }
      label488:
      localObject1 = this.liveCore;
      if (localObject1 == null) {
        break label289;
      }
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      if (localObject1 == null) {
        break label289;
      }
      ((com.tencent.mm.live.core.core.model.i)localObject1).mNF = false;
      break label289;
    }
  }
  
  public final void start()
  {
    int i = 1;
    AppMethodBeat.i(246646);
    super.start();
    Object localObject = com.tencent.mm.live.model.o.mZb;
    com.tencent.mm.live.model.o.bhM();
    localObject = this.liveCore;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a)localObject).mRB.bet() == true)) {}
    while ((i == 0) && (this.nmV))
    {
      localObject = com.tencent.mm.live.model.u.mZl;
      if (!com.tencent.mm.live.model.u.biq().nai)
      {
        localObject = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nak)
        {
          localObject = getContext();
          if (localObject == null)
          {
            localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(246646);
            throw ((Throwable)localObject);
            i = 0;
          }
          else
          {
            ((Activity)localObject).setRequestedOrientation(4);
          }
        }
      }
    }
    startTimer();
    AppMethodBeat.o(246646);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    int i = 1;
    int n = 1;
    int i1 = 1;
    int i2 = 1;
    int j = 1;
    int m = 0;
    int k = 0;
    AppMethodBeat.i(246634);
    kotlin.g.b.s.u(paramc, "status");
    Log.i("MicroMsg.LiveCoreVisitor", kotlin.g.b.s.X("statusChange:", paramc.name()));
    switch (LiveVisitorPluginLayout.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(246634);
      return;
      localObject1 = com.tencent.mm.live.model.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      ((com.tencent.mm.live.model.c.c)localObject1).Gw(com.tencent.mm.live.model.u.bhZ());
      localObject1 = e.nkN;
      e.bkv().iSl = System.currentTimeMillis();
      localObject1 = e.nkN;
      localObject1 = e.bkv();
      localObject2 = e.nkN;
      long l = e.bkv().iSl;
      localObject2 = e.nkN;
      ((jf)localObject1).iku = ((l - e.bkv().iSk) / 1000L);
      localObject1 = e.nkN;
      localObject1 = e.bkv();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      ((jf)localObject1).iSm = com.tencent.mm.model.v.getMembersCountByChatRoomName(com.tencent.mm.live.model.u.bhZ());
      localObject1 = com.tencent.mm.live.model.u.mZl;
      localObject1 = com.tencent.mm.live.model.u.bhZ();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      l = com.tencent.mm.live.model.u.bie().mMJ;
      localObject2 = com.tencent.mm.live.model.u.mZl;
      i = com.tencent.mm.live.model.u.biA();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      j = com.tencent.mm.live.model.u.biC();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      k = com.tencent.mm.live.model.u.bie().ZWw;
      localObject2 = com.tencent.mm.live.model.u.mZl;
      m = com.tencent.mm.live.model.u.biD();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      n = com.tencent.mm.live.model.u.biE();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      i1 = com.tencent.mm.live.model.u.biF();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      i2 = com.tencent.mm.live.model.u.biG();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      e.a((String)localObject1, l, i, j, k, m, n, i1, i2, com.tencent.mm.live.model.u.bie().aaNp);
      localObject1 = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.bil();
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(246634);
        throw paramc;
      }
      ((Activity)localObject1).finishAndRemoveTask();
      continue;
      localObject1 = com.tencent.mm.live.model.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      ((com.tencent.mm.live.model.c.c)localObject1).Gw(com.tencent.mm.live.model.u.bhZ());
      localObject1 = e.nkN;
      e.bkv().iSl = System.currentTimeMillis();
      localObject1 = e.nkN;
      localObject1 = e.bkv();
      localObject2 = e.nkN;
      l = e.bkv().iSl;
      localObject2 = e.nkN;
      ((jf)localObject1).iku = ((l - e.bkv().iSk) / 1000L);
      localObject1 = e.nkN;
      localObject1 = e.bkv();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      ((jf)localObject1).iSm = com.tencent.mm.model.v.getMembersCountByChatRoomName(com.tencent.mm.live.model.u.bhZ());
      localObject1 = com.tencent.mm.live.model.u.mZl;
      localObject1 = com.tencent.mm.live.model.u.bhZ();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      l = com.tencent.mm.live.model.u.bie().mMJ;
      localObject2 = com.tencent.mm.live.model.u.mZl;
      i = com.tencent.mm.live.model.u.biA();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      j = com.tencent.mm.live.model.u.biC();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      k = com.tencent.mm.live.model.u.bie().ZWw;
      localObject2 = com.tencent.mm.live.model.u.mZl;
      m = com.tencent.mm.live.model.u.biD();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      n = com.tencent.mm.live.model.u.biE();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      i1 = com.tencent.mm.live.model.u.biF();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      i2 = com.tencent.mm.live.model.u.biG();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      e.a((String)localObject1, l, i, j, k, m, n, i1, i2, com.tencent.mm.live.model.u.bie().aaNp);
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.core.core.f.d)localObject1).bci();
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.bil();
      localObject1 = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.biU();
      localObject1 = com.tencent.mm.live.model.o.mZb;
      com.tencent.mm.live.model.o.bhM();
      continue;
      localObject1 = this.liveCore;
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.core.core.f.d)localObject1).bci();
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.biU();
      localObject1 = com.tencent.mm.live.model.c.c.getLiveTipsBarStorage();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      ((com.tencent.mm.live.model.c.c)localObject1).hT(com.tencent.mm.live.model.u.bie().mMJ);
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(246634);
        throw paramc;
      }
      ((Activity)localObject1).setRequestedOrientation(1);
      continue;
      if (paramBundle == null) {}
      for (localObject1 = localObject3;; localObject1 = Boolean.valueOf(paramBundle.getBoolean("PARAM_LIVE_START_BY_ORIENTATION_CHANGE", false)))
      {
        if (kotlin.g.b.s.p(localObject1, Boolean.FALSE))
        {
          this.nmW.bAh();
          com.tencent.mm.live.model.o.mZb.bhO();
          localObject1 = com.tencent.mm.live.model.o.mZb;
          com.tencent.mm.live.model.o.bhJ();
          localObject1 = com.tencent.mm.live.model.o.mZb;
          com.tencent.mm.live.model.o.bhN();
        }
        localObject1 = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.biS();
        localObject1 = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.fZ(false);
        startTimer();
        localObject1 = e.nkN;
        e.bkv().iSk = System.currentTimeMillis();
        break;
      }
      localObject1 = com.tencent.mm.live.model.u.mZl;
      if (!com.tencent.mm.live.model.u.biq().nai)
      {
        localObject1 = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nak)
        {
          localObject1 = this.nmE;
          if (localObject1 != null)
          {
            ((t)localObject1).tO(0);
            localObject1 = kotlin.ah.aiuX;
          }
          localObject1 = this.nmE;
          if (localObject1 != null)
          {
            ((t)localObject1).bjq();
            localObject1 = kotlin.ah.aiuX;
            continue;
            localObject1 = com.tencent.mm.live.model.j.mXT;
            com.tencent.mm.live.model.j.bhj();
            com.tencent.mm.live.model.o.mZb.release();
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(246634);
              throw paramc;
            }
            ((Activity)localObject1).finishAndRemoveTask();
            continue;
            localObject1 = com.tencent.mm.live.model.u.mZl;
            localObject1 = com.tencent.mm.live.model.u.bie().Zqd;
            kotlin.g.b.s.s(localObject1, "RoomLiveService.liveInfo.live_name");
            localObject2 = com.tencent.mm.live.model.u.mZl;
            l = com.tencent.mm.live.model.u.bie().mMJ;
            localObject2 = com.tencent.mm.live.model.u.mZl;
            a((String)localObject1, l, com.tencent.mm.live.model.u.bhZ());
            continue;
            localObject2 = this.nnB;
            if (localObject2 != null)
            {
              localObject3 = this.nnH;
              if (localObject3 != null) {
                break label1201;
              }
            }
            for (;;)
            {
              ((com.tencent.mm.live.b.ah)localObject2).nkE = ((com.tencent.mm.live.core.b.k)localObject1);
              getMiniView().gf(false);
              break;
              label1201:
              localObject1 = ((ad)localObject3).bjx();
            }
            if (this.nmV)
            {
              localObject1 = getContext();
              if (localObject1 == null)
              {
                paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(246634);
                throw paramc;
              }
              ((Activity)localObject1).setRequestedOrientation(4);
            }
            getMiniView().gf(false);
            continue;
            localObject1 = getContext();
            if (localObject1 == null)
            {
              paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(246634);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(14);
            getMiniView().gf(false);
            continue;
            getMiniView().gf(true);
            localObject1 = com.tencent.mm.live.model.u.mZl;
            localObject1 = com.tencent.mm.live.model.u.bii();
            if (localObject1 == null) {}
            for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).mNB)
            {
              if (localObject1 != null) {
                ((com.tencent.mm.live.core.core.model.f)localObject1).mNj = true;
              }
              if (!this.nmV) {
                break label1413;
              }
              localObject1 = getContext();
              if (localObject1 != null) {
                break;
              }
              paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(246634);
              throw paramc;
            }
            ((Activity)localObject1).setRequestedOrientation(4);
            label1413:
            i = this.mNn;
            localObject1 = e.b.mKf;
            if (i == e.b.bcu())
            {
              localObject1 = this.nnB;
              if (localObject1 != null)
              {
                ((com.tencent.mm.live.b.ah)localObject1).exitRoom();
                localObject1 = kotlin.ah.aiuX;
              }
              localObject1 = this.nnC;
              if (localObject1 != null)
              {
                ((aa)localObject1).tO(0);
                localObject1 = kotlin.ah.aiuX;
              }
              localObject1 = this.nnC;
              if (localObject1 != null)
              {
                localObject1 = ((aa)localObject1).liveCore;
                if (localObject1 != null) {
                  ((com.tencent.mm.live.core.core.f.d)localObject1).mUn.bcl();
                }
                localObject1 = kotlin.ah.aiuX;
              }
            }
            localObject1 = this.nmM;
            if (localObject1 != null)
            {
              this.nmT.remove(localObject1);
              continue;
              localObject1 = this.nmM;
              if (localObject1 != null)
              {
                this.nmT.remove(localObject1);
                continue;
                getMiniView().gf(false);
                i = this.mNn;
                localObject1 = e.b.mKf;
                if (i == e.b.bct())
                {
                  bld();
                }
                else
                {
                  localObject1 = e.b.mKf;
                  if (i == e.b.bcu())
                  {
                    localObject1 = com.tencent.mm.live.model.u.mZl;
                    localObject1 = com.tencent.mm.live.model.u.bii();
                    if (localObject1 != null)
                    {
                      localObject2 = this.nnB;
                      if (localObject2 != null)
                      {
                        ((com.tencent.mm.live.b.ah)localObject2).a((com.tencent.mm.live.core.core.model.h)localObject1, (kotlin.g.a.b)new LiveVisitorPluginLayout.n(this));
                        localObject1 = kotlin.ah.aiuX;
                        continue;
                        localObject1 = com.tencent.mm.live.model.u.mZl;
                        com.tencent.mm.live.model.u.biT();
                        localObject1 = com.tencent.mm.live.model.o.mZb;
                        com.tencent.mm.live.model.o.bhK();
                        localObject1 = com.tencent.mm.live.model.j.mXT;
                        com.tencent.mm.live.model.j.bhj();
                        com.tencent.mm.live.model.o.mZb.release();
                        localObject1 = this.nmD;
                        if (localObject1 != null)
                        {
                          ((ab)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nmA;
                        if (localObject1 != null)
                        {
                          ((y)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nmy;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.b.c)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nnF;
                        if (localObject1 != null)
                        {
                          ((af)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nnE;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.b.o)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nnD;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.b.m)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nmE;
                        if (localObject1 != null)
                        {
                          ((t)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nmL;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.b.r)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nnB;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.b.ah)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nnC;
                        if (localObject1 != null)
                        {
                          ((aa)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nnH;
                        if (localObject1 != null)
                        {
                          ((ad)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nmO;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.b.s)localObject1).tO(8);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nnI;
                        if (localObject1 != null)
                        {
                          ((com.tencent.mm.live.b.p)localObject1).tO(0);
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.nnI;
                        if (localObject1 != null)
                        {
                          localObject2 = com.tencent.mm.live.model.u.mZl;
                          localObject2 = com.tencent.mm.live.model.u.big();
                          localObject3 = com.tencent.mm.live.model.d.a.nbX;
                          com.tencent.mm.live.model.d.a.a.b((String)localObject2, ((com.tencent.mm.live.b.a)localObject1).mJe.getContext().getResources().getColor(com.tencent.mm.live.b.b.half_alpha_black), (kotlin.g.a.b)new p.a((com.tencent.mm.live.b.p)localObject1));
                          localObject1 = kotlin.ah.aiuX;
                        }
                        localObject1 = this.liveCore;
                        if ((localObject1 != null) && (((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB.bet() == true))
                        {
                          i = 1;
                          label2070:
                          if (i == 0)
                          {
                            localObject1 = this.liveCore;
                            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB.beu() != true)) {
                              break label2171;
                            }
                          }
                        }
                        label2171:
                        for (i = j;; i = 0)
                        {
                          if (i == 0)
                          {
                            i = this.mNn;
                            localObject1 = e.b.mKf;
                            if (i != e.b.bct()) {
                              break label2176;
                            }
                          }
                          localObject1 = this.liveCore;
                          if (localObject1 != null)
                          {
                            ((com.tencent.mm.live.core.core.f.d)localObject1).bfH();
                            localObject1 = kotlin.ah.aiuX;
                          }
                          localObject1 = this.nnB;
                          if (localObject1 == null) {
                            break;
                          }
                          ((com.tencent.mm.live.b.ah)localObject1).exitRoom();
                          localObject1 = kotlin.ah.aiuX;
                          break;
                          i = 0;
                          break label2070;
                        }
                        label2176:
                        localObject1 = this.nnC;
                        if (localObject1 != null)
                        {
                          ((aa)localObject1).fD(false);
                          localObject1 = kotlin.ah.aiuX;
                          continue;
                          localObject1 = com.tencent.mm.live.model.u.mZl;
                          com.tencent.mm.live.model.u.tE(2);
                          localObject1 = com.tencent.mm.live.model.u.mZl;
                          if (!com.tencent.mm.live.model.u.biq().nai)
                          {
                            localObject1 = com.tencent.mm.live.model.u.mZl;
                            if (!com.tencent.mm.live.model.u.biq().nak)
                            {
                              localObject1 = this.nmL;
                              if (localObject1 != null)
                              {
                                localObject2 = com.tencent.mm.live.model.u.mZl;
                                localObject2 = com.tencent.mm.live.model.u.big();
                                localObject3 = getContext().getResources().getString(b.h.live_local_network_error_tip);
                                kotlin.g.b.s.s(localObject3, "context.resources.getStr…_local_network_error_tip)");
                                ((com.tencent.mm.live.b.r)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
                                localObject1 = kotlin.ah.aiuX;
                              }
                              localObject1 = com.tencent.mm.live.model.u.mZl;
                              com.tencent.mm.live.model.u.biT();
                              continue;
                              localObject1 = com.tencent.mm.live.model.u.mZl;
                              com.tencent.mm.live.model.u.tE(1);
                              localObject1 = com.tencent.mm.live.model.u.mZl;
                              if (!com.tencent.mm.live.model.u.biq().nai)
                              {
                                localObject1 = com.tencent.mm.live.model.u.mZl;
                                if (!com.tencent.mm.live.model.u.biq().nak)
                                {
                                  localObject1 = this.nmL;
                                  if (localObject1 != null)
                                  {
                                    localObject2 = com.tencent.mm.live.model.u.mZl;
                                    localObject2 = com.tencent.mm.live.model.u.big();
                                    localObject3 = getContext().getResources().getString(b.h.live_anchor_exception_tip);
                                    kotlin.g.b.s.s(localObject3, "context.resources.getStr…ive_anchor_exception_tip)");
                                    ((com.tencent.mm.live.b.r)localObject1).showTipWithBlurBg((String)localObject2, (String)localObject3);
                                    localObject1 = kotlin.ah.aiuX;
                                    continue;
                                    localObject1 = this.nnB;
                                    if (localObject1 != null)
                                    {
                                      ((com.tencent.mm.live.b.ah)localObject1).tO(0);
                                      localObject1 = kotlin.ah.aiuX;
                                    }
                                    localObject1 = this.nnB;
                                    if (localObject1 != null)
                                    {
                                      ((com.tencent.mm.live.b.ah)localObject1).bjr();
                                      localObject1 = kotlin.ah.aiuX;
                                    }
                                    localObject1 = this.nnC;
                                    if (localObject1 != null)
                                    {
                                      ((aa)localObject1).tO(8);
                                      localObject1 = kotlin.ah.aiuX;
                                    }
                                    localObject1 = this.nnC;
                                    if (localObject1 != null)
                                    {
                                      localObject1 = ((aa)localObject1).liveCore;
                                      if (localObject1 != null) {
                                        ((com.tencent.mm.live.core.core.f.d)localObject1).mUn.bck();
                                      }
                                      localObject1 = kotlin.ah.aiuX;
                                      continue;
                                      localObject1 = this.nmL;
                                      if (localObject1 != null)
                                      {
                                        ((com.tencent.mm.live.b.r)localObject1).tO(8);
                                        localObject1 = kotlin.ah.aiuX;
                                        continue;
                                        localObject1 = this.liveCore;
                                        if (localObject1 != null)
                                        {
                                          localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
                                          if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).isFloatMode())) {}
                                        }
                                        for (i = 1; i != 0; i = 0)
                                        {
                                          localObject1 = this.liveCore;
                                          if (localObject1 != null)
                                          {
                                            localObject1 = (com.tencent.mm.live.core.core.b)localObject1;
                                            localObject2 = getContext();
                                            kotlin.g.b.s.s(localObject2, "context");
                                            com.tencent.mm.live.core.core.b.a.a((com.tencent.mm.live.core.core.b)localObject1, (Context)localObject2, false, false, 0, 0, null, false, 126);
                                          }
                                          localObject1 = com.tencent.mm.live.model.u.mZl;
                                          localObject1 = com.tencent.mm.live.model.u.bhZ();
                                          localObject2 = com.tencent.mm.live.model.u.mZl;
                                          l = com.tencent.mm.live.model.u.bie().mMJ;
                                          localObject2 = com.tencent.mm.live.model.u.mZl;
                                          localObject2 = com.tencent.mm.live.model.u.big();
                                          localObject3 = com.tencent.mm.live.model.u.mZl;
                                          e.a((String)localObject1, l, (String)localObject2, 2, 1, com.tencent.mm.live.model.u.bie().ZWw);
                                          com.tencent.mm.live.c.f.bkB();
                                          break;
                                        }
                                        localObject1 = com.tencent.mm.live.model.u.mZl;
                                        localObject1 = com.tencent.mm.live.model.u.bhZ();
                                        localObject2 = com.tencent.mm.live.model.u.mZl;
                                        l = com.tencent.mm.live.model.u.bie().mMJ;
                                        localObject2 = com.tencent.mm.live.model.u.mZl;
                                        localObject2 = com.tencent.mm.live.model.u.big();
                                        localObject3 = com.tencent.mm.live.model.u.mZl;
                                        e.a((String)localObject1, l, (String)localObject2, 2, 0, com.tencent.mm.live.model.u.bie().ZWw);
                                        com.tencent.mm.live.c.f.bkC();
                                        continue;
                                        localObject1 = this.liveCore;
                                        if (localObject1 != null)
                                        {
                                          localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
                                          if (localObject1 != null)
                                          {
                                            ((com.tencent.mm.live.core.core.model.i)localObject1).mNK = i.e.mOf;
                                            localObject1 = kotlin.ah.aiuX;
                                            continue;
                                            localObject1 = this.liveCore;
                                            if (localObject1 != null)
                                            {
                                              localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
                                              if (localObject1 != null)
                                              {
                                                ((com.tencent.mm.live.core.core.model.i)localObject1).mNK = i.e.mOh;
                                                localObject1 = kotlin.ah.aiuX;
                                                continue;
                                                localObject1 = this.nnB;
                                                if (localObject1 != null)
                                                {
                                                  localObject2 = com.tencent.mm.live.model.u.mZl;
                                                  if (com.tencent.mm.live.model.u.bit().isLandscape()) {}
                                                  for (i = 2;; i = 1)
                                                  {
                                                    localObject2 = com.tencent.mm.live.model.u.mZl;
                                                    localObject2 = com.tencent.mm.live.model.u.bit().userId;
                                                    localObject3 = com.tencent.mm.live.model.u.mZl;
                                                    ((com.tencent.mm.live.b.ah)localObject1).c(i, (String)localObject2, com.tencent.mm.live.model.u.bit().streamType);
                                                    localObject1 = kotlin.ah.aiuX;
                                                    break;
                                                  }
                                                  localObject1 = this.liveCore;
                                                  if ((localObject1 != null) && (((com.tencent.mm.live.core.core.f.d)localObject1).beZ() == true)) {}
                                                  while (i == 0)
                                                  {
                                                    localObject1 = com.tencent.mm.live.model.c.c.getLiveTipsBarStorage();
                                                    localObject2 = com.tencent.mm.live.model.u.mZl;
                                                    ((com.tencent.mm.live.model.c.c)localObject1).Gw(com.tencent.mm.live.model.u.bhZ());
                                                    localObject1 = com.tencent.mm.live.model.u.mZl;
                                                    com.tencent.mm.live.model.u.bil();
                                                    localObject1 = com.tencent.mm.live.model.u.mZl;
                                                    com.tencent.mm.live.model.u.biV();
                                                    break;
                                                    i = 0;
                                                  }
                                                  if (!isLandscape())
                                                  {
                                                    if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
                                                    {
                                                      i = n;
                                                      label2989:
                                                      if (i == 0) {
                                                        break label3117;
                                                      }
                                                      localObject1 = this.nmB;
                                                      if (localObject1 != null) {
                                                        break label3089;
                                                      }
                                                      localObject1 = null;
                                                    }
                                                    while ((localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)))
                                                    {
                                                      ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
                                                      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
                                                      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
                                                      localObject1 = this.nmB;
                                                      if (localObject1 == null) {
                                                        break;
                                                      }
                                                      localObject1 = ((com.tencent.mm.live.b.a)localObject1).mJe;
                                                      if (localObject1 == null) {
                                                        break;
                                                      }
                                                      ((ViewGroup)localObject1).requestLayout();
                                                      localObject1 = kotlin.ah.aiuX;
                                                      break;
                                                      i = 0;
                                                      break label2989;
                                                      label3089:
                                                      localObject1 = ((com.tencent.mm.live.b.a)localObject1).mJe;
                                                      if (localObject1 == null) {
                                                        localObject1 = null;
                                                      } else {
                                                        localObject1 = ((ViewGroup)localObject1).getLayoutParams();
                                                      }
                                                    }
                                                    label3117:
                                                    localObject1 = this.nmB;
                                                    if (localObject1 == null)
                                                    {
                                                      localObject1 = null;
                                                      label3131:
                                                      if ((localObject1 == null) || (!(localObject1 instanceof RelativeLayout.LayoutParams))) {
                                                        continue;
                                                      }
                                                      ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
                                                      localObject2 = (RelativeLayout.LayoutParams)localObject1;
                                                      localObject3 = this.nnF;
                                                      if (localObject3 != null) {
                                                        break label3263;
                                                      }
                                                      i = k;
                                                    }
                                                    for (;;)
                                                    {
                                                      ((RelativeLayout.LayoutParams)localObject2).addRule(2, i);
                                                      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = bd.fromDPToPix(getContext(), 12);
                                                      localObject1 = this.nmB;
                                                      if (localObject1 == null) {
                                                        break;
                                                      }
                                                      localObject1 = ((com.tencent.mm.live.b.a)localObject1).mJe;
                                                      if (localObject1 == null) {
                                                        break;
                                                      }
                                                      ((ViewGroup)localObject1).requestLayout();
                                                      localObject1 = kotlin.ah.aiuX;
                                                      break;
                                                      localObject1 = ((com.tencent.mm.live.b.a)localObject1).mJe;
                                                      if (localObject1 == null)
                                                      {
                                                        localObject1 = null;
                                                        break label3131;
                                                      }
                                                      localObject1 = ((ViewGroup)localObject1).getLayoutParams();
                                                      break label3131;
                                                      label3263:
                                                      localObject3 = ((com.tencent.mm.live.b.a)localObject3).mJe;
                                                      i = k;
                                                      if (localObject3 != null) {
                                                        i = ((ViewGroup)localObject3).getId();
                                                      }
                                                    }
                                                  }
                                                  else
                                                  {
                                                    if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true)) {}
                                                    for (i = i1;; i = 0)
                                                    {
                                                      if (i == 0) {
                                                        break label3339;
                                                      }
                                                      localObject1 = this.nmB;
                                                      if (localObject1 == null) {
                                                        break;
                                                      }
                                                      ((com.tencent.mm.live.b.h)localObject1).tO(4);
                                                      localObject1 = kotlin.ah.aiuX;
                                                      break;
                                                    }
                                                    label3339:
                                                    localObject1 = this.nmB;
                                                    if (localObject1 != null)
                                                    {
                                                      ((com.tencent.mm.live.b.h)localObject1).tO(0);
                                                      localObject1 = kotlin.ah.aiuX;
                                                      continue;
                                                      if (!isLandscape())
                                                      {
                                                        localObject1 = this.nnE;
                                                        if ((localObject1 != null) && (((com.tencent.mm.live.b.a)localObject1).mJe.getVisibility() == 0))
                                                        {
                                                          i = i2;
                                                          label3396:
                                                          if (i == 0) {
                                                            continue;
                                                          }
                                                          if (paramBundle != null) {
                                                            break label3484;
                                                          }
                                                          i = m;
                                                          label3407:
                                                          localObject1 = this.nmB;
                                                          if (localObject1 != null) {
                                                            break label3495;
                                                          }
                                                          localObject1 = null;
                                                        }
                                                        while ((localObject1 != null) && ((localObject1 instanceof RelativeLayout.LayoutParams)))
                                                        {
                                                          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i;
                                                          localObject1 = this.nmB;
                                                          if (localObject1 == null) {
                                                            break;
                                                          }
                                                          localObject1 = ((com.tencent.mm.live.b.a)localObject1).mJe;
                                                          if (localObject1 == null) {
                                                            break;
                                                          }
                                                          ((ViewGroup)localObject1).requestLayout();
                                                          localObject1 = kotlin.ah.aiuX;
                                                          break;
                                                          i = 0;
                                                          break label3396;
                                                          label3484:
                                                          i = paramBundle.getInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT");
                                                          break label3407;
                                                          label3495:
                                                          localObject1 = ((com.tencent.mm.live.b.a)localObject1).mJe;
                                                          if (localObject1 == null) {
                                                            localObject1 = null;
                                                          } else {
                                                            localObject1 = ((ViewGroup)localObject1).getLayoutParams();
                                                          }
                                                        }
                                                        localObject1 = com.tencent.mm.live.model.u.mZl;
                                                        if (!com.tencent.mm.live.model.u.biq().nai)
                                                        {
                                                          localObject1 = this.nnB;
                                                          if (localObject1 != null)
                                                          {
                                                            ((com.tencent.mm.live.b.ah)localObject1).tO(8);
                                                            localObject1 = kotlin.ah.aiuX;
                                                          }
                                                          localObject1 = this.nmw;
                                                          if (localObject1 != null)
                                                          {
                                                            ((com.tencent.mm.live.b.l)localObject1).tO(8);
                                                            localObject1 = kotlin.ah.aiuX;
                                                          }
                                                          localObject1 = this.nmL;
                                                          if (localObject1 != null)
                                                          {
                                                            ((com.tencent.mm.live.b.r)localObject1).tO(8);
                                                            localObject1 = kotlin.ah.aiuX;
                                                          }
                                                          localObject1 = this.nmQ;
                                                          if (localObject1 != null)
                                                          {
                                                            ((com.tencent.mm.live.b.k)localObject1).tO(0);
                                                            localObject1 = kotlin.ah.aiuX;
                                                          }
                                                          localObject1 = com.tencent.mm.live.model.u.mZl;
                                                          com.tencent.mm.live.model.u.biT();
                                                          localObject1 = getContext();
                                                          if (localObject1 == null)
                                                          {
                                                            paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                                                            AppMethodBeat.o(246634);
                                                            throw paramc;
                                                          }
                                                          ((Activity)localObject1).setRequestedOrientation(1);
                                                          continue;
                                                          localObject1 = com.tencent.mm.live.model.u.mZl;
                                                          com.tencent.mm.live.model.u.biq().nal = true;
                                                          continue;
                                                          localObject1 = com.tencent.mm.live.model.u.mZl;
                                                          localObject1 = com.tencent.mm.live.model.u.bhZ();
                                                          localObject2 = com.tencent.mm.live.model.u.mZl;
                                                          l = com.tencent.mm.live.model.u.bie().mMJ;
                                                          localObject2 = com.tencent.mm.live.model.u.mZl;
                                                          localObject2 = com.tencent.mm.live.model.u.big();
                                                          localObject3 = z.bAM();
                                                          kotlin.g.b.s.s(localObject3, "getUsernameFromUserInfo()");
                                                          com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
                                                          e.a((String)localObject1, l, (String)localObject2, 8, 1, (String)localObject3, com.tencent.mm.live.model.u.bie().ZWw);
                                                          com.tencent.mm.live.c.f.bkz();
                                                          continue;
                                                          localObject1 = this.nmD;
                                                          if (localObject1 != null)
                                                          {
                                                            ((ab)localObject1).tO(4);
                                                            localObject1 = kotlin.ah.aiuX;
                                                            continue;
                                                            localObject1 = com.tencent.mm.live.model.u.mZl;
                                                            com.tencent.mm.live.model.u.tI(com.tencent.mm.live.model.u.biE() + 1);
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
    AppMethodBeat.i(246653);
    super.stop();
    this.nmZ.stopTimer();
    AppMethodBeat.o(246653);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246703);
    super.unMount();
    Object localObject1 = com.tencent.mm.live.model.u.mZl;
    int i;
    label154:
    label180:
    Object localObject2;
    if (com.tencent.mm.live.model.u.getLastOrientation() != -1)
    {
      localObject1 = com.tencent.mm.live.model.u.mZl;
      i = com.tencent.mm.live.model.u.getLastOrientation();
      localObject1 = getContext().getSystemService("window");
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(246703);
        throw ((Throwable)localObject1);
      }
      if (i != ((WindowManager)localObject1).getDefaultDisplay().getRotation())
      {
        i = 1;
        if (i == 0)
        {
          localObject1 = this.nnC;
          if (localObject1 != null) {
            ((aa)localObject1).fD(false);
          }
          localObject1 = com.tencent.mm.live.model.j.mXT;
          com.tencent.mm.live.model.j.bhj();
          localObject1 = com.tencent.mm.live.model.o.mZb;
          com.tencent.mm.live.model.o.bhK();
          com.tencent.mm.live.model.o.mZb.release();
          localObject1 = this.liveCore;
          if (localObject1 != null) {
            ((com.tencent.mm.live.core.core.f.d)localObject1).bci();
          }
          localObject1 = this.liveCore;
          if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB.beu() != true)) {
            break label309;
          }
          i = 1;
          if (i == 0)
          {
            localObject1 = this.liveCore;
            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB.bet() != true)) {
              break label314;
            }
            i = 1;
            if (i == 0) {
              break label319;
            }
          }
          localObject1 = com.tencent.mm.live.model.u.mZl;
          localObject1 = com.tencent.mm.live.model.u.biN().nbN;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.live.model.o.mZb;
            com.tencent.mm.live.model.o.aI(((com.tencent.mm.live.model.b.a.a)localObject1).mXx, ((com.tencent.mm.live.model.b.a.a)localObject1).mXH);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("PARAM_HANGUP_SELF", true);
          statusChange(b.c.ncs, (Bundle)localObject1);
        }
      }
    }
    label394:
    for (;;)
    {
      localObject1 = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.aNm();
      localObject1 = com.tencent.mm.live.core.core.f.d.mUj;
      localObject1 = com.tencent.mm.live.core.core.f.d.bfL();
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.f.d)localObject1).release();
      }
      com.tencent.mm.live.core.core.f.d.a(null);
      this.nmW.gR(false);
      com.tencent.mm.kernel.h.baD().mCm.b(3806, (com.tencent.mm.am.h)this);
      this.nmZ.stopTimer();
      AppMethodBeat.o(246703);
      return;
      i = 0;
      break;
      label309:
      i = 0;
      break label154;
      label314:
      i = 0;
      break label180;
      label319:
      localObject1 = this.nnD;
      if ((localObject1 != null) && (((com.tencent.mm.live.b.m)localObject1).nhN.nkz == true)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label394;
        }
        localObject1 = com.tencent.mm.live.model.o.mZb;
        localObject1 = com.tencent.mm.live.model.u.mZl;
        String str = com.tencent.mm.live.model.u.biN().nbO;
        localObject1 = com.tencent.mm.live.model.u.mZl;
        localObject2 = com.tencent.mm.live.model.u.bie().aaNn;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.live.model.o.aI(str, (String)localObject1);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.r<Integer, String, g, TRTCCloudDef.TRTCParams, kotlin.ah>
  {
    c(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    d(boolean paramBoolean, LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    e(boolean paramBoolean, LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", "", "errMsg", "", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.r<Integer, String, g, TRTCCloudDef.TRTCParams, kotlin.ah>
  {
    f(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/view/LiveVisitorPluginLayout$handleJoinLiveErr$clickSpan$1", "Lcom/tencent/mm/plugin/messenger/api/AvoidDuplicatedPressableSpan;", "onClickImp", "", "widget", "Landroid/view/View;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends com.tencent.mm.plugin.messenger.a.a
  {
    g(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
    
    public final void onClickImp(View paramView)
    {
      AppMethodBeat.i(246127);
      kotlin.g.b.s.u(paramView, "widget");
      paramView = new Intent();
      l.a locala = com.tencent.mm.live.model.l.mYb;
      paramView.putExtra("rawUrl", com.tencent.mm.live.model.l.bhl());
      paramView.putExtra("showShare", false);
      com.tencent.mm.br.c.g(this.nnM.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(246127);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "x", "", "y"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.m<Float, Float, kotlin.ah>
  {
    h(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "x", "", "y"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.m<Float, Float, kotlin.ah>
  {
    i(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "liveID", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Long, kotlin.ah>
  {
    j(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
    
    private static final void l(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      AppMethodBeat.i(246125);
      kotlin.g.b.s.u(paramLiveVisitorPluginLayout, "this$0");
      com.tencent.mm.live.b.b.b.a((com.tencent.mm.live.b.b)paramLiveVisitorPluginLayout, b.c.ncE);
      AppMethodBeat.o(246125);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    k(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    l(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/live/view/RoomLiveMiniView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<RoomLiveMiniView>
  {
    m(Context paramContext, LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      a(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    o(LiveVisitorPluginLayout paramLiveVisitorPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVisitorPluginLayout
 * JD-Core Version:    0.7.0.1
 */