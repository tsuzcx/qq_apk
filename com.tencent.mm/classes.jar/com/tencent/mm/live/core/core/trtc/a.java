package com.tencent.mm.live.core.core.trtc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.b.a;
import com.tencent.mm.live.core.core.b.e.b;
import com.tencent.mm.live.core.core.b.e.c;
import com.tencent.mm.live.core.core.b.e.d;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.core.mini.LiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.LivePreviewView.a;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/IMMLiveCore;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager$IView;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManagerListener;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager$IView;", "context", "Landroid/content/Context;", "isAnchor", "", "(Landroid/content/Context;Z)V", "blurFinalFrame", "Landroid/graphics/Bitmap;", "blurFrameRetrieveCallback", "Lkotlin/Function1;", "", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getCamera", "()Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "setCamera", "(Lcom/tencent/mm/media/widget/camera/ICommonCamera;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "enterRoomCallback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "getEnterRoomCallback", "()Lcom/tencent/mm/live/core/core/LiveCallback;", "setEnterRoomCallback", "(Lcom/tencent/mm/live/core/core/LiveCallback;)V", "exitRoomCallback", "getExitRoomCallback", "setExitRoomCallback", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "frameTexture", "Lcom/tencent/trtc/TRTCCloudDef$TRTCTexture;", "()Z", "setAnchor", "(Z)V", "isPushing", "setPushing", "liveCallback", "getLiveCallback", "setLiveCallback", "liveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "miniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getMiniManager", "()Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "setMiniManager", "(Lcom/tencent/mm/live/core/mini/LiveMiniManager;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "getPreviewView", "()Lcom/tencent/mm/live/core/view/LivePreviewView;", "setPreviewView", "(Lcom/tencent/mm/live/core/view/LivePreviewView;)V", "renderManager", "Lcom/tencent/mm/live/core/render/LiveRenderManager;", "getRenderManager", "()Lcom/tencent/mm/live/core/render/LiveRenderManager;", "setRenderManager", "(Lcom/tencent/mm/live/core/render/LiveRenderManager;)V", "trtcCloud", "Lcom/tencent/trtc/TRTCCloud;", "getTrtcCloud", "()Lcom/tencent/trtc/TRTCCloud;", "setTrtcCloud", "(Lcom/tencent/trtc/TRTCCloud;)V", "trtcManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "getTrtcManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "setTrtcManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;)V", "trtcRemoteUserManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "getTrtcRemoteUserManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "setTrtcRemoteUserManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "enterRoom", "callback", "exitRoom", "finishLastLive", "floatMode", "", "getFinalCameraFrame", "getLiveRoomModel", "getLiveStatus", "getRemoteUserViewById", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "", "steamType", "initCamera", "useCamera2", "frontCamera", "isInLinkMic", "isInLive", "liveId", "", "normalMode", "onAudioEffectFinished", "effectId", "code", "onAudioVolumeEvaluationChange", "enable", "onConnectOtherRoom", "userID", "err", "errMsg", "onDisConnectOtherRoom", "onEnterRoom", "result", "onError", "errCode", "extraInfo", "Landroid/os/Bundle;", "onExitRoom", "reason", "onFirstVideoFrame", "streamType", "width", "height", "onMuteLocalAudio", "isMute", "onMuteLocalVideo", "onNetworkQuality", "localQuality", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "remoteQuality", "Ljava/util/ArrayList;", "onRecvCustomCmdMsg", "cmdID", "seq", "message", "", "onRecvSEIMsg", "data", "onRemoteUserEnterRoom", "onRemoteUserLeaveRoom", "onRemoteViewStatusUpdate", "onStatistics", "statics", "Lcom/tencent/trtc/TRTCStatistics;", "onUserAudioAvailable", "available", "onUserSubStreamAvailable", "onUserVideoAvailable", "onUserVoiceVolume", "userVolumes", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "refreshCamera", "release", "removeMiniWindow", "setLiveStatusCallback", "setup", "startPreview", "startPreviewOnlyLocal", "surfaceHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "startPreviewToRemote", "stopPreview", "switchCamera", "updateLiveMiniState", "state", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "updatePrivateMapKey", "privateMapKey", "Companion", "plugin-core_release"})
public abstract class a
  implements com.tencent.mm.live.core.core.a, com.tencent.mm.live.core.core.trtc.a.b.c.a, com.tencent.mm.live.core.core.trtc.a.c.a, com.tencent.mm.live.core.core.trtc.a.d
{
  public static final a.a gIv = new a.a((byte)0);
  Context context;
  private boolean dyu;
  public final ap gIf;
  public TRTCCloud gIg;
  protected com.tencent.mm.live.core.core.trtc.a.b.c gIh;
  protected com.tencent.mm.live.core.core.trtc.a.c gIi;
  private final TRTCCloudDef.TRTCVideoFrame gIj;
  private final TRTCCloudDef.TRTCTexture gIk;
  protected com.tencent.mm.live.core.mini.a gIl;
  public com.tencent.mm.live.core.b.b gIm;
  protected LivePreviewView gIn;
  public com.tencent.mm.media.widget.a.e gIo;
  protected com.tencent.mm.live.core.core.b gIp;
  protected com.tencent.mm.live.core.core.b gIq;
  private com.tencent.mm.live.core.core.b gIr;
  public com.tencent.mm.live.core.core.b.d gIs;
  public com.tencent.mm.live.core.core.b.e gIt;
  protected boolean gIu;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    this.context = paramContext;
    this.dyu = paramBoolean;
    this.gIf = new ap(Looper.getMainLooper());
    paramContext = b.gIJ;
    paramContext = this.context.getApplicationContext();
    p.g(paramContext, "context.applicationContext");
    p.h(paramContext, "var0");
    if (b.alI() == null) {
      b.a(new b(paramContext));
    }
    paramContext = b.alI();
    if (paramContext == null) {
      p.gfZ();
    }
    this.gIg = ((TRTCCloud)paramContext);
    this.gIh = new com.tencent.mm.live.core.core.trtc.a.b.c(this.gIg, (com.tencent.mm.live.core.core.trtc.a.b.c.a)this);
    this.gIj = new TRTCCloudDef.TRTCVideoFrame();
    this.gIk = new TRTCCloudDef.TRTCTexture();
    this.gIl = new com.tencent.mm.live.core.mini.a();
    this.gIm = new com.tencent.mm.live.core.b.b();
    this.gIt = new com.tencent.mm.live.core.core.b.e();
    ad.i("MicroMsg.LiveCore", "live anchor use trtc,ver:" + TRTCCloud.getSDKVersion());
    paramContext = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("use trtc sdk,ver:" + TRTCCloud.getSDKVersion());
    TXLiveBase.setListener((ITXLiveBaseListener)a.1.gIw);
    if (this.gIt.isDebugMode)
    {
      TRTCCloud.setLogLevel(0);
      TRTCCloud.setConsoleEnabled(true);
      return;
    }
    TRTCCloud.setLogLevel(4);
  }
  
  public final TXCloudVideoView T(String paramString, int paramInt)
  {
    LivePreviewView localLivePreviewView = this.gIn;
    if (localLivePreviewView != null) {
      return localLivePreviewView.U(paramString, paramInt);
    }
    return null;
  }
  
  public final int a(final com.tencent.mm.live.core.core.b.d paramd)
  {
    p.h(paramd, "model");
    ad.i("MicroMsg.LiveCore", "setup model:".concat(String.valueOf(paramd)));
    Object localObject = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("model:".concat(String.valueOf(paramd)));
    this.gIs = paramd;
    localObject = this.gIm;
    p.h(paramd, "model");
    ((com.tencent.mm.live.core.b.b)localObject).gIs = paramd;
    this.gIt.gHP = paramd.gHC.userId;
    localObject = this.gIl;
    String str = paramd.gHE.name;
    View.OnClickListener localOnClickListener = (View.OnClickListener)new b(this, paramd);
    p.h(str, "activityName");
    ((com.tencent.mm.live.core.mini.a)localObject).intent.setClass(aj.getContext(), Class.forName(str));
    ((com.tencent.mm.live.core.mini.a)localObject).intent.addFlags(268435456);
    ((com.tencent.mm.live.core.mini.a)localObject).gKu = str;
    ((com.tencent.mm.live.core.mini.a)localObject).gKt.setMOnClickListener(localOnClickListener);
    this.gIi = new com.tencent.mm.live.core.core.trtc.a.c(this.gIg, paramd.gHC);
    localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).a((com.tencent.mm.live.core.core.trtc.a.c.a)this);
    }
    localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).a((com.tencent.mm.live.core.core.trtc.a.d)this);
    }
    localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).alP();
    }
    this.gIh.xp(paramd.gHC.userId);
    this.gIt.gHN = paramd.gHD.gHz;
    this.gIh.v(paramd.gHD.appId, paramd.gHD.gHA);
    ad.i("MicroMsg.LiveCore", "steve:setQCloudAccount qppid: %s, bizid: %s", new Object[] { Long.valueOf(paramd.gHD.appId), Long.valueOf(paramd.gHD.gHA) });
    return 0;
  }
  
  public final int a(LivePreviewView paramLivePreviewView)
  {
    if (paramLivePreviewView == null)
    {
      ad.e("MicroMsg.LiveCore", "startPreview preiewView is null");
      return -3;
    }
    Object localObject = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("startPreview ".concat(String.valueOf(paramLivePreviewView)));
    this.gIn = paramLivePreviewView;
    localObject = this.gIs;
    boolean bool1;
    boolean bool2;
    label98:
    com.tencent.mm.media.widget.a.e locale;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gHB;
      if (localObject != null)
      {
        bool1 = ((com.tencent.mm.live.core.core.b.b)localObject).gHt;
        localObject = this.gIs;
        if (localObject == null) {
          break label316;
        }
        localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gHB;
        if (localObject == null) {
          break label316;
        }
        bool2 = ((com.tencent.mm.live.core.core.b.b)localObject).gHu;
        k(bool1, bool2);
        localObject = this.gIs;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gHB;
          if ((localObject != null) && (((com.tencent.mm.live.core.core.b.b)localObject).gHv == true))
          {
            localObject = this.gIo;
            if (localObject != null) {
              ((com.tencent.mm.media.widget.a.e)localObject).a(this.gIm.getFrameDataCallback());
            }
          }
        }
        localObject = com.tencent.mm.live.core.core.trtc.a.a.alJ();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alL();
        p.g(localObject, "ConfigHelper.getInstance().audioConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dG(true);
        localObject = com.tencent.mm.live.core.core.trtc.a.a.alJ();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alK();
        p.g(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dJ(true);
        localObject = com.tencent.mm.live.core.core.trtc.a.a.alJ();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alN();
        locale = this.gIo;
        if (locale == null) {
          break label322;
        }
      }
    }
    label316:
    label322:
    for (int i = locale.awp();; i = 0)
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject).gJh = i;
      paramLivePreviewView.a((d.g.a.q)new c(this));
      this.gIm.d((d.g.a.b)new d(this));
      return 0;
      bool1 = false;
      break;
      bool2 = true;
      break label98;
    }
  }
  
  public void a(com.tencent.mm.live.core.core.b paramb)
  {
    p.h(paramb, "callback");
    int i;
    if (this.gIt.gHJ == e.c.gHZ)
    {
      i = 1;
      if (i == 0) {
        break label46;
      }
      ad.i("MicroMsg.LiveCore", "entering room or already room");
      this.gIp = paramb;
    }
    label46:
    do
    {
      return;
      i = 0;
      break;
      Object localObject = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.xx("start create room");
      com.tencent.mm.live.core.core.b.e locale = this.gIt;
      localObject = this.gIs;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gHD;
        if (localObject == null) {}
      }
      for (localObject = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject).gGy); locale.b((Long)localObject); localObject = null)
      {
        localObject = com.tencent.mm.live.core.debug.a.gKp;
        com.tencent.mm.live.core.debug.a.xx("enter room and already in room");
        b.a.a(paramb, 0);
        return;
      }
      this.gIp = paramb;
      paramb = this.gIt;
      localObject = e.c.gHZ;
      p.h(localObject, "status");
      paramb.gHJ = ((e.c)localObject);
      paramb = this.gIi;
    } while (paramb == null);
    paramb.alQ();
  }
  
  public final void a(TRTCCloudDef.TRTCQuality paramTRTCQuality)
  {
    int j;
    int i;
    if (paramTRTCQuality != null)
    {
      j = paramTRTCQuality.quality;
      i = j;
      if (j != 0)
      {
        if (j > 2) {
          break label96;
        }
        paramTRTCQuality = c.c.gHi;
        i = c.c.alu();
      }
    }
    for (;;)
    {
      if (this.gIt.gHR != i)
      {
        this.gIt.gHR = i;
        ad.i("MicroMsg.LiveCore", "onNetworkQuality, local:".concat(String.valueOf(i)));
      }
      paramTRTCQuality = this.gIr;
      if (paramTRTCQuality != null)
      {
        c.b localb = c.b.gHd;
        b.a.a(paramTRTCQuality, c.b.alp());
      }
      return;
      paramTRTCQuality = c.c.gHi;
      j = c.c.alu();
      break;
      label96:
      if (j <= 4)
      {
        paramTRTCQuality = c.c.gHi;
        i = c.c.alv();
      }
      else if (j < 6)
      {
        paramTRTCQuality = c.c.gHi;
        i = c.c.alw();
      }
      else
      {
        paramTRTCQuality = c.c.gHi;
        i = c.c.alx();
      }
    }
  }
  
  public boolean alG()
  {
    return false;
  }
  
  public final int alc()
  {
    try
    {
      ad.i("MicroMsg.LiveCore", "release");
      this.gIm.h((d.g.a.a)new i(this));
      return 0;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, "camera release error:" + localException.getMessage(), new Object[0]);
    }
    return 0;
  }
  
  public final void ald()
  {
    Object localObject1 = this.gIo;
    Object localObject2;
    com.tencent.mm.media.widget.a.e locale;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.a.e)localObject1).awl();
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.a.a.alJ();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).alN();
        locale = this.gIo;
        if (locale == null) {
          break label69;
        }
      }
    }
    label69:
    for (int i = locale.awp();; i = 0)
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject2).gJh = i;
      this.gIm.a((com.tencent.mm.media.widget.a.b)localObject1);
      return;
    }
  }
  
  public void ale()
  {
    this.gIt.gHL = e.d.gIb;
    this.gIl.amj();
  }
  
  public final com.tencent.mm.live.core.core.b.e alf()
  {
    return this.gIt;
  }
  
  public final void alg()
  {
    if ((this.context instanceof Activity))
    {
      this.gIt.gHL = e.d.gIb;
      this.gIt.gHK = e.b.gHT;
      alc();
      ali();
      Context localContext = this.context;
      if (localContext == null) {
        throw new v("null cannot be cast to non-null type android.app.Activity");
      }
      ((Activity)localContext).finishAndRemoveTask();
      this.gIl.amj();
      return;
    }
    ad.w("MicroMsg.LiveCore", "finishLastLive err: context:" + this.context);
  }
  
  public final void alh()
  {
    this.gIt.gHL = e.d.gIb;
    this.gIl.amj();
  }
  
  public final void b(com.tencent.mm.live.core.core.b paramb)
  {
    p.h(paramb, "callback");
    Object localObject = com.tencent.mm.live.core.mini.b.gKw;
    com.tencent.mm.live.core.core.b.e locale = this.gIt;
    localObject = this.gIs;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gHD;
      if (localObject == null) {}
    }
    for (localObject = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject).gGy); !locale.b((Long)localObject); localObject = null)
    {
      localObject = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.xx("already exit room");
      b.a.a(paramb, 0);
      return;
    }
    alc();
    this.gIq = paramb;
    paramb = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("start exit room");
    paramb = this.gIi;
    if (paramb != null) {
      paramb.exitRoom();
    }
    paramb = this.gIt;
    paramb.gHJ = e.c.gHX;
    paramb.gHM = -1L;
  }
  
  public final void c(com.tencent.mm.live.core.core.b paramb)
  {
    p.h(paramb, "callback");
    this.gIr = paramb;
  }
  
  public int cp(Context paramContext)
  {
    p.h(paramContext, "context");
    Object localObject1 = paramContext.getResources();
    p.g(localObject1, "context.resources");
    int i;
    if (((Resources)localObject1).getConfiguration().orientation == 1) {
      i = com.tencent.mm.cc.a.ip(paramContext) / 4;
    }
    for (localObject1 = new Point(i, (int)(com.tencent.mm.cc.a.iq(paramContext) / com.tencent.mm.cc.a.ip(paramContext) * i));; localObject1 = new Point((int)(com.tencent.mm.cc.a.ip(paramContext) / com.tencent.mm.cc.a.iq(paramContext) * i), i))
    {
      this.gIm.cS(((Point)localObject1).x, ((Point)localObject1).y);
      ad.i("MicroMsg.LiveCore", "floatMode context:" + paramContext + ", this.context:" + this.context);
      boolean bool1 = ((Activity)paramContext).isTaskRoot();
      boolean bool2 = ((Activity)paramContext).moveTaskToBack(true);
      ad.i("MicroMsg.LiveCore", "floatMode moveTaskToBack ret:" + bool2 + ", isTaskRoot:" + bool1);
      this.context = paramContext;
      paramContext = this.gIl;
      p.h(localObject1, "size");
      if (paramContext.gKt.getParent() == null) {
        break;
      }
      ad.i("MicroMsg.LiveCoreMini", "addViewToWindow fail.miniLayout already in window");
      this.gIt.gHL = e.d.gIc;
      return 0;
      i = com.tencent.mm.cc.a.iq(paramContext) / 4;
    }
    Object localObject2 = aj.getContext().getSystemService("window");
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject2 = (WindowManager)localObject2;
    Object localObject3 = new WindowManager.LayoutParams();
    if (com.tencent.mm.compatible.util.d.ly(26)) {}
    for (((WindowManager.LayoutParams)localObject3).type = 2038;; ((WindowManager.LayoutParams)localObject3).type = 2002)
    {
      for (;;)
      {
        ((WindowManager.LayoutParams)localObject3).format = 1;
        ((WindowManager.LayoutParams)localObject3).flags = 40;
        ((WindowManager.LayoutParams)localObject3).gravity = 51;
        Context localContext = aj.getContext();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)localObject2).getDefaultDisplay().getMetrics(localDisplayMetrics);
        ((WindowManager.LayoutParams)localObject3).width = ((Point)localObject1).x;
        ((WindowManager.LayoutParams)localObject3).height = ((Point)localObject1).y;
        localObject1 = g.ajC();
        p.g(localObject1, "MMKernel.storage()");
        i = ((com.tencent.mm.kernel.e)localObject1).ajl().getInt(327947, 0);
        int j = BackwardSupportUtil.b.g(localContext, 5.0F);
        ((WindowManager.LayoutParams)localObject3).x = (localDisplayMetrics.widthPixels - ((WindowManager.LayoutParams)localObject3).width - j);
        ((WindowManager.LayoutParams)localObject3).y = (i + j);
        try
        {
          ((WindowManager)localObject2).addView((View)paramContext.gKt, (ViewGroup.LayoutParams)localObject3);
          localObject1 = com.tencent.mm.live.core.mini.b.gKw;
          localObject1 = com.tencent.mm.cc.a.az(aj.getContext(), 2131766650);
          p.g(localObject1, "ResourceHelper.getString…g.live_notification_tip1)");
          localObject2 = com.tencent.mm.cc.a.az(aj.getContext(), 2131766651);
          p.g(localObject2, "ResourceHelper.getString…g.live_notification_tip2)");
          localObject3 = com.tencent.mm.cc.a.az(aj.getContext(), 2131766650);
          p.g(localObject3, "ResourceHelper.getString…g.live_notification_tip1)");
          com.tencent.mm.live.core.mini.b.c((String)localObject1, (String)localObject2, (String)localObject3, paramContext.gKu);
        }
        catch (Exception paramContext)
        {
          ad.e("MicroMsg.LiveCoreMini", "addViewToWindowManager failed: %s", new Object[] { paramContext.getMessage() });
        }
      }
      break;
    }
  }
  
  public final void dE(boolean paramBoolean)
  {
    ad.i("MicroMsg.LiveCore", "onAudioVolumeEvaluationChange:".concat(String.valueOf(paramBoolean)));
  }
  
  public final int k(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    com.tencent.mm.media.widget.a.e locale;
    Context localContext;
    if (paramBoolean1)
    {
      locale = (com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.b.e(this.context);
      this.gIo = locale;
      locale = this.gIo;
      if (locale != null) {
        locale.awr();
      }
      locale = this.gIo;
      if (locale != null)
      {
        localContext = this.context;
        if (paramBoolean2) {
          break label115;
        }
      }
    }
    label115:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      if (locale.s(localContext, paramBoolean1) != true)
      {
        ad.e("MicroMsg.LiveCoreError", "[-1] live anchor open camera error");
        i = -1;
      }
      return i;
      locale = (com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.a.d(this.context);
      break;
    }
  }
  
  public final void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    ad.i("MicroMsg.LiveCore", "onConnectOtherRoom, userID:" + paramString1 + ", err:" + paramInt + ", errMsg:$" + paramString2);
  }
  
  public final void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    ad.i("MicroMsg.LiveCore", "onDisConnectOtherRoom, err:" + paramInt + ", errMsg:" + paramString);
  }
  
  public void onEnterRoom(long paramLong)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.gKp;
    localObject1 = new StringBuilder("create room ret:").append(paramLong).append('(');
    Object localObject2 = com.tencent.mm.live.core.a.a.gKq;
    com.tencent.mm.live.core.debug.a.xx(com.tencent.mm.live.core.a.a.nc((int)paramLong) + ')');
    localObject1 = this.gIp;
    if (localObject1 != null) {
      b.a.a((com.tencent.mm.live.core.core.b)localObject1, (int)paramLong);
    }
    this.gIp = null;
    localObject1 = this.gIt;
    localObject2 = this.gIs;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).gHD;
      if (localObject2 == null) {}
    }
    for (paramLong = ((com.tencent.mm.live.core.core.b.c)localObject2).gGy;; paramLong = -1L)
    {
      ((com.tencent.mm.live.core.core.b.e)localObject1).gHJ = e.c.gHY;
      ((com.tencent.mm.live.core.core.b.e)localObject1).gHM = paramLong;
      return;
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    paramBundle = new Bundle();
    paramBundle.putInt("live_err_code", paramInt);
    com.tencent.mm.live.core.core.b localb = this.gIr;
    if (localb != null)
    {
      c.b localb1 = c.b.gHd;
      localb.f(c.b.alq(), paramBundle);
    }
    paramBundle = com.tencent.mm.live.core.debug.a.gKp;
    paramString = new StringBuilder("[").append(paramInt).append("]msg:").append(paramString).append('(');
    paramBundle = com.tencent.mm.live.core.a.a.gKq;
    com.tencent.mm.live.core.debug.a.xx(com.tencent.mm.live.core.a.a.nc(paramInt) + ')');
  }
  
  public final void onExitRoom(int paramInt)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.gKp;
    localObject1 = new StringBuilder("[").append(paramInt).append("]end exit room.(");
    Object localObject2 = com.tencent.mm.live.core.a.a.gKq;
    com.tencent.mm.live.core.debug.a.xx(com.tencent.mm.live.core.a.a.nc(paramInt) + ')');
    localObject1 = this.gIq;
    if (localObject1 != null) {
      b.a.a((com.tencent.mm.live.core.core.b)localObject1, paramInt);
    }
    if (paramInt != 0)
    {
      localObject1 = this.gIr;
      if (localObject1 != null)
      {
        localObject2 = c.b.gHd;
        b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.als());
      }
    }
    this.gIq = null;
  }
  
  public final void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("[sdk]onFirstVideoFrame uid:" + paramString + " ,streamType:" + paramInt1 + " width:" + paramInt2 + " height:" + paramInt3);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_first_frame_width", paramInt2);
    ((Bundle)localObject).putInt("live_first_frame_height", paramInt3);
    paramString = this.gIr;
    if (paramString != null)
    {
      c.b localb = c.b.gHd;
      paramString.f(c.b.alt(), (Bundle)localObject);
    }
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("[sdk]onRemoteUserLeaveRoom:" + paramString + " reason:" + paramInt);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_user_exit_reason", paramInt);
    com.tencent.mm.live.core.core.b localb = this.gIr;
    if (localb != null)
    {
      c.b localb1 = c.b.gHd;
      localb.f(c.b.aln(), (Bundle)localObject);
    }
    this.gIh.xu(paramString);
  }
  
  public final void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "[sdk]onUserAudioAvailable:" + paramString + ", available:" + paramBoolean + ", isAnchor:" + this.dyu);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putBoolean("live_media_enable", paramBoolean);
    com.tencent.mm.live.core.core.b localb = this.gIr;
    if (localb != null)
    {
      c.b localb1 = c.b.gHd;
      localb.f(c.b.alo(), (Bundle)localObject);
    }
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramString))) {
      com.tencent.mm.live.core.core.trtc.a.b.c.xt(paramString);
    }
    if (this.dyu) {
      this.gIh.ama();
    }
  }
  
  public final void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("onUserSubStreamAvailable:" + paramString + ", available:" + paramBoolean);
  }
  
  public final void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("onUserVideoAvailable uid:" + paramString + " available:" + paramBoolean + ", isAnchor:" + this.dyu);
    Object localObject2;
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      localObject2 = this.gIh;
      localObject1 = this.gIn;
      if (localObject1 != null)
      {
        localObject1 = ((LivePreviewView)localObject1).U(paramString, 0);
        ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject2).a(paramString, (TXCloudVideoView)localObject1);
        localObject1 = this.gIr;
        if (localObject1 != null)
        {
          localObject2 = c.b.gHd;
          b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.alm());
        }
        if ((!this.dyu) && (bt.lQ(this.gIt.gHN, paramString)))
        {
          localObject1 = this.gIn;
          if (localObject1 != null) {
            ((LivePreviewView)localObject1).post((Runnable)new LivePreviewView.a((LivePreviewView)localObject1, paramString));
          }
        }
      }
    }
    for (;;)
    {
      if ((!this.dyu) && (!bt.lQ(this.gIt.gHN, paramString))) {
        this.gIt.gHO = paramString;
      }
      if (this.dyu) {
        this.gIh.ama();
      }
      return;
      localObject1 = null;
      break;
      localObject1 = this.gIn;
      if (localObject1 != null) {
        ((LivePreviewView)localObject1).gLW.xC(paramString);
      }
      this.gIh.xs(paramString);
      localObject1 = this.gIr;
      if (localObject1 != null)
      {
        localObject2 = c.b.gHd;
        b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.alr());
      }
    }
  }
  
  public void release()
  {
    this.gIm.release();
    this.gIg.setListener(null);
    Object localObject = this.gIl;
    if (((com.tencent.mm.live.core.mini.a)localObject).gKs.isHeld()) {
      ((com.tencent.mm.live.core.mini.a)localObject).gKs.release();
    }
    localObject = b.gIJ;
    localObject = b.alI();
    if (localObject != null) {
      ((b)localObject).destroy();
    }
    b.a(null);
  }
  
  public final void switchCamera()
  {
    try
    {
      Object localObject = this.gIo;
      com.tencent.mm.media.widget.a.e locale;
      if ((localObject != null) && (((com.tencent.mm.media.widget.a.e)localObject).awa() == true))
      {
        localObject = this.gIo;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.e)localObject).avZ();
        }
        this.gIm.amn();
        if (this.gIn != null)
        {
          localObject = this.gIo;
          if ((localObject != null) && (((com.tencent.mm.media.widget.a.e)localObject).awa() == true))
          {
            localObject = com.tencent.mm.live.core.core.trtc.a.a.alJ();
            p.g(localObject, "ConfigHelper.getInstance()");
            localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alN();
            locale = this.gIo;
            if (locale == null) {
              break label134;
            }
          }
        }
      }
      label134:
      for (int i = locale.awp();; i = 0)
      {
        ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject).gJh = i;
        localObject = this.gIo;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.media.widget.a.e)localObject).awl();
          if (localObject != null) {
            this.gIm.a((com.tencent.mm.media.widget.a.b)localObject);
          }
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, "switch camera error:" + localException.getMessage(), new Object[0]);
    }
  }
  
  public final void xl(String paramString)
  {
    p.h(paramString, "state");
    com.tencent.mm.live.core.mini.a.xA(paramString);
  }
  
  public final void xm(String paramString)
  {
    p.h(paramString, "privateMapKey");
    if (!bt.isNullOrNil(paramString))
    {
      i locali = new i();
      locali.h("privateMapKey", paramString);
      paramString = new i();
      paramString.h("api", "updatePrivateMapKey");
      paramString.h("params", locali);
      ad.i("MicroMsg.LiveCore", "updatePrivateMapKey:" + paramString + ' ');
      this.gIg.callExperimentalAPI(paramString.toString());
    }
  }
  
  public final void y(float paramFloat1, float paramFloat2)
  {
    if (this.dyu) {
      this.gIh.z(paramFloat1, paramFloat2);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, com.tencent.mm.live.core.core.b.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216837);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      this.gIx.ale();
      localObject = new Intent(this.gIx.context, Class.forName(paramd.gHE.name));
      ((Intent)localObject).putExtra("route_to_maximize", true);
      ((Intent)localObject).addFlags(268435456);
      paramView = aj.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216837);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.q<j, Integer, Integer, z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<SurfaceTexture, z>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "width", "", "height", "invoke"})
  public static final class e
    extends d.g.b.q
    implements m
  {
    public e(a parama, j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  public static final class f
    extends d.g.b.q
    implements d.g.a.b<SurfaceTexture, z>
  {
    public f(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke", "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$startPreviewToRemote$2$1"})
  public static final class g
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.g.d, z>
  {
    public g(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  public static final class h
    extends d.g.b.q
    implements d.g.a.q<j, Integer, Integer, z>
  {
    public h(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a
 * JD-Core Version:    0.7.0.1
 */