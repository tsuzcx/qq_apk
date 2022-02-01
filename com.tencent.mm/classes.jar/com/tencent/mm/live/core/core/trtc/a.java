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
import com.tencent.mm.ab.i;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/IMMLiveCore;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager$IView;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManagerListener;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager$IView;", "context", "Landroid/content/Context;", "isAnchor", "", "(Landroid/content/Context;Z)V", "blurFinalFrame", "Landroid/graphics/Bitmap;", "blurFrameRetrieveCallback", "Lkotlin/Function1;", "", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getCamera", "()Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "setCamera", "(Lcom/tencent/mm/media/widget/camera/ICommonCamera;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "enterRoomCallback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "getEnterRoomCallback", "()Lcom/tencent/mm/live/core/core/LiveCallback;", "setEnterRoomCallback", "(Lcom/tencent/mm/live/core/core/LiveCallback;)V", "exitRoomCallback", "getExitRoomCallback", "setExitRoomCallback", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "frameTexture", "Lcom/tencent/trtc/TRTCCloudDef$TRTCTexture;", "()Z", "setAnchor", "(Z)V", "isPushing", "setPushing", "liveCallback", "getLiveCallback", "setLiveCallback", "liveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "miniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getMiniManager", "()Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "setMiniManager", "(Lcom/tencent/mm/live/core/mini/LiveMiniManager;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "getPreviewView", "()Lcom/tencent/mm/live/core/view/LivePreviewView;", "setPreviewView", "(Lcom/tencent/mm/live/core/view/LivePreviewView;)V", "renderManager", "Lcom/tencent/mm/live/core/render/LiveRenderManager;", "getRenderManager", "()Lcom/tencent/mm/live/core/render/LiveRenderManager;", "setRenderManager", "(Lcom/tencent/mm/live/core/render/LiveRenderManager;)V", "trtcCloud", "Lcom/tencent/trtc/TRTCCloud;", "getTrtcCloud", "()Lcom/tencent/trtc/TRTCCloud;", "setTrtcCloud", "(Lcom/tencent/trtc/TRTCCloud;)V", "trtcManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "getTrtcManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "setTrtcManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;)V", "trtcRemoteUserManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "getTrtcRemoteUserManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "setTrtcRemoteUserManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "enterRoom", "callback", "exitRoom", "finishLastLive", "floatMode", "", "getFinalCameraFrame", "getLiveRoomModel", "getLiveStatus", "getRemoteUserViewById", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "", "steamType", "initCamera", "useCamera2", "frontCamera", "isInLinkMic", "isInLive", "liveId", "", "normalMode", "onAudioEffectFinished", "effectId", "code", "onAudioVolumeEvaluationChange", "enable", "onConnectOtherRoom", "userID", "err", "errMsg", "onDisConnectOtherRoom", "onEnterRoom", "result", "onError", "errCode", "extraInfo", "Landroid/os/Bundle;", "onExitRoom", "reason", "onFirstVideoFrame", "streamType", "width", "height", "onMuteLocalAudio", "isMute", "onMuteLocalVideo", "onNetworkQuality", "localQuality", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "remoteQuality", "Ljava/util/ArrayList;", "onRecvCustomCmdMsg", "cmdID", "seq", "message", "", "onRecvSEIMsg", "data", "onRemoteUserEnterRoom", "onRemoteUserLeaveRoom", "onRemoteViewStatusUpdate", "onStatistics", "statics", "Lcom/tencent/trtc/TRTCStatistics;", "onUserAudioAvailable", "available", "onUserSubStreamAvailable", "onUserVideoAvailable", "onUserVoiceVolume", "userVolumes", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "refreshCamera", "release", "removeMiniWindow", "setLiveStatusCallback", "setup", "startPreview", "startPreviewOnlyLocal", "surfaceHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "startPreviewToRemote", "stopPreview", "switchCamera", "updateLiveMiniState", "state", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "updatePrivateMapKey", "privateMapKey", "Companion", "plugin-core_release"})
public abstract class a
  implements com.tencent.mm.live.core.core.a, com.tencent.mm.live.core.core.trtc.a.b.c.a, com.tencent.mm.live.core.core.trtc.a.c.a, com.tencent.mm.live.core.core.trtc.a.d
{
  public static final a.a gLe = new a.a((byte)0);
  Context context;
  private boolean dzz;
  public final aq gKO;
  public TRTCCloud gKP;
  protected com.tencent.mm.live.core.core.trtc.a.b.c gKQ;
  protected com.tencent.mm.live.core.core.trtc.a.c gKR;
  private final TRTCCloudDef.TRTCVideoFrame gKS;
  private final TRTCCloudDef.TRTCTexture gKT;
  protected com.tencent.mm.live.core.mini.a gKU;
  public com.tencent.mm.live.core.b.b gKV;
  protected LivePreviewView gKW;
  public com.tencent.mm.media.widget.a.e gKX;
  protected com.tencent.mm.live.core.core.b gKY;
  protected com.tencent.mm.live.core.core.b gKZ;
  private com.tencent.mm.live.core.core.b gLa;
  public com.tencent.mm.live.core.core.b.d gLb;
  public com.tencent.mm.live.core.core.b.e gLc;
  protected boolean gLd;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    this.context = paramContext;
    this.dzz = paramBoolean;
    this.gKO = new aq(Looper.getMainLooper());
    paramContext = b.gLs;
    paramContext = this.context.getApplicationContext();
    p.g(paramContext, "context.applicationContext");
    p.h(paramContext, "var0");
    if (b.alX() == null) {
      b.a(new b(paramContext));
    }
    paramContext = b.alX();
    if (paramContext == null) {
      p.gkB();
    }
    this.gKP = ((TRTCCloud)paramContext);
    this.gKQ = new com.tencent.mm.live.core.core.trtc.a.b.c(this.gKP, (com.tencent.mm.live.core.core.trtc.a.b.c.a)this);
    this.gKS = new TRTCCloudDef.TRTCVideoFrame();
    this.gKT = new TRTCCloudDef.TRTCTexture();
    this.gKU = new com.tencent.mm.live.core.mini.a();
    this.gKV = new com.tencent.mm.live.core.b.b();
    this.gLc = new com.tencent.mm.live.core.core.b.e();
    ae.i("MicroMsg.LiveCore", "live anchor use trtc,ver:" + TRTCCloud.getSDKVersion());
    paramContext = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("use trtc sdk,ver:" + TRTCCloud.getSDKVersion());
    TXLiveBase.setListener((ITXLiveBaseListener)a.1.gLf);
    if (this.gLc.isDebugMode)
    {
      TRTCCloud.setLogLevel(0);
      TRTCCloud.setConsoleEnabled(true);
      return;
    }
    TRTCCloud.setLogLevel(4);
  }
  
  public final TXCloudVideoView U(String paramString, int paramInt)
  {
    LivePreviewView localLivePreviewView = this.gKW;
    if (localLivePreviewView != null) {
      return localLivePreviewView.V(paramString, paramInt);
    }
    return null;
  }
  
  public final int a(final com.tencent.mm.live.core.core.b.d paramd)
  {
    p.h(paramd, "model");
    ae.i("MicroMsg.LiveCore", "setup model:".concat(String.valueOf(paramd)));
    Object localObject = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("model:".concat(String.valueOf(paramd)));
    this.gLb = paramd;
    localObject = this.gKV;
    p.h(paramd, "model");
    ((com.tencent.mm.live.core.b.b)localObject).gLb = paramd;
    this.gLc.gKy = paramd.gKl.userId;
    localObject = this.gKU;
    String str = paramd.gKn.name;
    View.OnClickListener localOnClickListener = (View.OnClickListener)new b(this, paramd);
    p.h(str, "activityName");
    ((com.tencent.mm.live.core.mini.a)localObject).intent.setClass(ak.getContext(), Class.forName(str));
    ((com.tencent.mm.live.core.mini.a)localObject).intent.addFlags(268435456);
    ((com.tencent.mm.live.core.mini.a)localObject).gNd = str;
    ((com.tencent.mm.live.core.mini.a)localObject).gNc.setMOnClickListener(localOnClickListener);
    this.gKR = new com.tencent.mm.live.core.core.trtc.a.c(this.gKP, paramd.gKl);
    localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).a((com.tencent.mm.live.core.core.trtc.a.c.a)this);
    }
    localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).a((com.tencent.mm.live.core.core.trtc.a.d)this);
    }
    localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).ame();
    }
    this.gKQ.xY(paramd.gKl.userId);
    this.gLc.gKw = paramd.gKm.gKi;
    this.gKQ.v(paramd.gKm.appId, paramd.gKm.gKj);
    ae.i("MicroMsg.LiveCore", "steve:setQCloudAccount qppid: %s, bizid: %s", new Object[] { Long.valueOf(paramd.gKm.appId), Long.valueOf(paramd.gKm.gKj) });
    return 0;
  }
  
  public final int a(LivePreviewView paramLivePreviewView)
  {
    if (paramLivePreviewView == null)
    {
      ae.e("MicroMsg.LiveCore", "startPreview preiewView is null");
      return -3;
    }
    Object localObject = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("startPreview ".concat(String.valueOf(paramLivePreviewView)));
    this.gKW = paramLivePreviewView;
    localObject = this.gLb;
    boolean bool1;
    boolean bool2;
    label98:
    com.tencent.mm.media.widget.a.e locale;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gKk;
      if (localObject != null)
      {
        bool1 = ((com.tencent.mm.live.core.core.b.b)localObject).gKc;
        localObject = this.gLb;
        if (localObject == null) {
          break label316;
        }
        localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gKk;
        if (localObject == null) {
          break label316;
        }
        bool2 = ((com.tencent.mm.live.core.core.b.b)localObject).gKd;
        k(bool1, bool2);
        localObject = this.gLb;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gKk;
          if ((localObject != null) && (((com.tencent.mm.live.core.core.b.b)localObject).gKe == true))
          {
            localObject = this.gKX;
            if (localObject != null) {
              ((com.tencent.mm.media.widget.a.e)localObject).a(this.gKV.getFrameDataCallback());
            }
          }
        }
        localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).ama();
        p.g(localObject, "ConfigHelper.getInstance().audioConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dH(true);
        localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alZ();
        p.g(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dK(true);
        localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).amc();
        locale = this.gKX;
        if (locale == null) {
          break label322;
        }
      }
    }
    label316:
    label322:
    for (int i = locale.awE();; i = 0)
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject).gLQ = i;
      paramLivePreviewView.a((d.g.a.q)new c(this));
      this.gKV.d((d.g.a.b)new d(this));
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
    if (this.gLc.gKs == e.c.gKI)
    {
      i = 1;
      if (i == 0) {
        break label46;
      }
      ae.i("MicroMsg.LiveCore", "entering room or already room");
      this.gKY = paramb;
    }
    label46:
    do
    {
      return;
      i = 0;
      break;
      Object localObject = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.yg("start create room");
      com.tencent.mm.live.core.core.b.e locale = this.gLc;
      localObject = this.gLb;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gKm;
        if (localObject == null) {}
      }
      for (localObject = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject).gJh); locale.b((Long)localObject); localObject = null)
      {
        localObject = com.tencent.mm.live.core.debug.a.gMY;
        com.tencent.mm.live.core.debug.a.yg("enter room and already in room");
        b.a.a(paramb, 0);
        return;
      }
      this.gKY = paramb;
      paramb = this.gLc;
      localObject = e.c.gKI;
      p.h(localObject, "status");
      paramb.gKs = ((e.c)localObject);
      paramb = this.gKR;
    } while (paramb == null);
    paramb.amf();
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
        paramTRTCQuality = c.c.gJR;
        i = c.c.alJ();
      }
    }
    for (;;)
    {
      if (this.gLc.gKA != i)
      {
        this.gLc.gKA = i;
        ae.i("MicroMsg.LiveCore", "onNetworkQuality, local:".concat(String.valueOf(i)));
      }
      paramTRTCQuality = this.gLa;
      if (paramTRTCQuality != null)
      {
        c.b localb = c.b.gJM;
        b.a.a(paramTRTCQuality, c.b.alE());
      }
      return;
      paramTRTCQuality = c.c.gJR;
      j = c.c.alJ();
      break;
      label96:
      if (j <= 4)
      {
        paramTRTCQuality = c.c.gJR;
        i = c.c.alK();
      }
      else if (j < 6)
      {
        paramTRTCQuality = c.c.gJR;
        i = c.c.alL();
      }
      else
      {
        paramTRTCQuality = c.c.gJR;
        i = c.c.alM();
      }
    }
  }
  
  public boolean alV()
  {
    return false;
  }
  
  public final int alr()
  {
    try
    {
      ae.i("MicroMsg.LiveCore", "release");
      this.gKV.i((d.g.a.a)new i(this));
      return 0;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, "camera release error:" + localException.getMessage(), new Object[0]);
    }
    return 0;
  }
  
  public final void als()
  {
    Object localObject1 = this.gKX;
    Object localObject2;
    com.tencent.mm.media.widget.a.e locale;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.a.e)localObject1).awA();
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.a.a.alY();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).amc();
        locale = this.gKX;
        if (locale == null) {
          break label69;
        }
      }
    }
    label69:
    for (int i = locale.awE();; i = 0)
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject2).gLQ = i;
      this.gKV.a((com.tencent.mm.media.widget.a.b)localObject1);
      return;
    }
  }
  
  public void alt()
  {
    this.gLc.gKu = e.d.gKK;
    this.gKU.amy();
  }
  
  public final com.tencent.mm.live.core.core.b.e alu()
  {
    return this.gLc;
  }
  
  public final void alv()
  {
    if ((this.context instanceof Activity))
    {
      this.gLc.gKu = e.d.gKK;
      this.gLc.gKt = e.b.gKC;
      alr();
      alx();
      Context localContext = this.context;
      if (localContext == null) {
        throw new v("null cannot be cast to non-null type android.app.Activity");
      }
      ((Activity)localContext).finishAndRemoveTask();
      this.gKU.amy();
      return;
    }
    ae.w("MicroMsg.LiveCore", "finishLastLive err: context:" + this.context);
  }
  
  public final void alw()
  {
    this.gLc.gKu = e.d.gKK;
    this.gKU.amy();
  }
  
  public final void b(com.tencent.mm.live.core.core.b paramb)
  {
    p.h(paramb, "callback");
    Object localObject = com.tencent.mm.live.core.mini.b.gNf;
    com.tencent.mm.live.core.core.b.e locale = this.gLc;
    localObject = this.gLb;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gKm;
      if (localObject == null) {}
    }
    for (localObject = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject).gJh); !locale.b((Long)localObject); localObject = null)
    {
      localObject = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.yg("already exit room");
      b.a.a(paramb, 0);
      return;
    }
    alr();
    this.gKZ = paramb;
    paramb = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("start exit room");
    paramb = this.gKR;
    if (paramb != null) {
      paramb.exitRoom();
    }
    paramb = this.gLc;
    paramb.gKs = e.c.gKG;
    paramb.gKv = -1L;
  }
  
  public final void c(com.tencent.mm.live.core.core.b paramb)
  {
    p.h(paramb, "callback");
    this.gLa = paramb;
  }
  
  public int cr(Context paramContext)
  {
    p.h(paramContext, "context");
    Object localObject1 = paramContext.getResources();
    p.g(localObject1, "context.resources");
    int i;
    if (((Resources)localObject1).getConfiguration().orientation == 1) {
      i = com.tencent.mm.cb.a.iu(paramContext) / 4;
    }
    for (localObject1 = new Point(i, (int)(com.tencent.mm.cb.a.iv(paramContext) / com.tencent.mm.cb.a.iu(paramContext) * i));; localObject1 = new Point((int)(com.tencent.mm.cb.a.iu(paramContext) / com.tencent.mm.cb.a.iv(paramContext) * i), i))
    {
      this.gKV.cS(((Point)localObject1).x, ((Point)localObject1).y);
      ae.i("MicroMsg.LiveCore", "floatMode context:" + paramContext + ", this.context:" + this.context);
      boolean bool1 = ((Activity)paramContext).isTaskRoot();
      boolean bool2 = ((Activity)paramContext).moveTaskToBack(true);
      ae.i("MicroMsg.LiveCore", "floatMode moveTaskToBack ret:" + bool2 + ", isTaskRoot:" + bool1);
      this.context = paramContext;
      paramContext = this.gKU;
      p.h(localObject1, "size");
      if (paramContext.gNc.getParent() == null) {
        break;
      }
      ae.i("MicroMsg.LiveCoreMini", "addViewToWindow fail.miniLayout already in window");
      this.gLc.gKu = e.d.gKL;
      return 0;
      i = com.tencent.mm.cb.a.iv(paramContext) / 4;
    }
    Object localObject2 = ak.getContext().getSystemService("window");
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject2 = (WindowManager)localObject2;
    Object localObject3 = new WindowManager.LayoutParams();
    if (com.tencent.mm.compatible.util.d.lA(26)) {}
    for (((WindowManager.LayoutParams)localObject3).type = 2038;; ((WindowManager.LayoutParams)localObject3).type = 2002)
    {
      for (;;)
      {
        ((WindowManager.LayoutParams)localObject3).format = 1;
        ((WindowManager.LayoutParams)localObject3).flags = 40;
        ((WindowManager.LayoutParams)localObject3).gravity = 51;
        Context localContext = ak.getContext();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)localObject2).getDefaultDisplay().getMetrics(localDisplayMetrics);
        ((WindowManager.LayoutParams)localObject3).width = ((Point)localObject1).x;
        ((WindowManager.LayoutParams)localObject3).height = ((Point)localObject1).y;
        localObject1 = g.ajR();
        p.g(localObject1, "MMKernel.storage()");
        i = ((com.tencent.mm.kernel.e)localObject1).ajA().getInt(327947, 0);
        int j = BackwardSupportUtil.b.h(localContext, 5.0F);
        ((WindowManager.LayoutParams)localObject3).x = (localDisplayMetrics.widthPixels - ((WindowManager.LayoutParams)localObject3).width - j);
        ((WindowManager.LayoutParams)localObject3).y = (i + j);
        try
        {
          ((WindowManager)localObject2).addView((View)paramContext.gNc, (ViewGroup.LayoutParams)localObject3);
          localObject1 = com.tencent.mm.live.core.mini.b.gNf;
          localObject1 = com.tencent.mm.cb.a.az(ak.getContext(), 2131766650);
          p.g(localObject1, "ResourceHelper.getString…g.live_notification_tip1)");
          localObject2 = com.tencent.mm.cb.a.az(ak.getContext(), 2131766651);
          p.g(localObject2, "ResourceHelper.getString…g.live_notification_tip2)");
          localObject3 = com.tencent.mm.cb.a.az(ak.getContext(), 2131766650);
          p.g(localObject3, "ResourceHelper.getString…g.live_notification_tip1)");
          com.tencent.mm.live.core.mini.b.c((String)localObject1, (String)localObject2, (String)localObject3, paramContext.gNd);
        }
        catch (Exception paramContext)
        {
          ae.e("MicroMsg.LiveCoreMini", "addViewToWindowManager failed: %s", new Object[] { paramContext.getMessage() });
        }
      }
      break;
    }
  }
  
  public final void dF(boolean paramBoolean)
  {
    ae.i("MicroMsg.LiveCore", "onAudioVolumeEvaluationChange:".concat(String.valueOf(paramBoolean)));
  }
  
  public final int k(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    com.tencent.mm.media.widget.a.e locale;
    Context localContext;
    if (paramBoolean1)
    {
      locale = (com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.b.e(this.context);
      this.gKX = locale;
      locale = this.gKX;
      if (locale != null) {
        locale.awG();
      }
      locale = this.gKX;
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
        ae.e("MicroMsg.LiveCoreError", "[-1] live anchor open camera error");
        i = -1;
      }
      return i;
      locale = (com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.a.d(this.context);
      break;
    }
  }
  
  public final void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    ae.i("MicroMsg.LiveCore", "onConnectOtherRoom, userID:" + paramString1 + ", err:" + paramInt + ", errMsg:$" + paramString2);
  }
  
  public final void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    ae.i("MicroMsg.LiveCore", "onDisConnectOtherRoom, err:" + paramInt + ", errMsg:" + paramString);
  }
  
  public void onEnterRoom(long paramLong)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.gMY;
    localObject1 = new StringBuilder("create room ret:").append(paramLong).append('(');
    Object localObject2 = com.tencent.mm.live.core.a.a.gMZ;
    com.tencent.mm.live.core.debug.a.yg(com.tencent.mm.live.core.a.a.nf((int)paramLong) + ')');
    localObject1 = this.gKY;
    if (localObject1 != null) {
      b.a.a((com.tencent.mm.live.core.core.b)localObject1, (int)paramLong);
    }
    this.gKY = null;
    localObject1 = this.gLc;
    localObject2 = this.gLb;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).gKm;
      if (localObject2 == null) {}
    }
    for (paramLong = ((com.tencent.mm.live.core.core.b.c)localObject2).gJh;; paramLong = -1L)
    {
      ((com.tencent.mm.live.core.core.b.e)localObject1).gKs = e.c.gKH;
      ((com.tencent.mm.live.core.core.b.e)localObject1).gKv = paramLong;
      return;
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    paramBundle = new Bundle();
    paramBundle.putInt("live_err_code", paramInt);
    com.tencent.mm.live.core.core.b localb = this.gLa;
    if (localb != null)
    {
      c.b localb1 = c.b.gJM;
      localb.f(c.b.alF(), paramBundle);
    }
    paramBundle = com.tencent.mm.live.core.debug.a.gMY;
    paramString = new StringBuilder("[").append(paramInt).append("]msg:").append(paramString).append('(');
    paramBundle = com.tencent.mm.live.core.a.a.gMZ;
    com.tencent.mm.live.core.debug.a.yg(com.tencent.mm.live.core.a.a.nf(paramInt) + ')');
  }
  
  public final void onExitRoom(int paramInt)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.gMY;
    localObject1 = new StringBuilder("[").append(paramInt).append("]end exit room.(");
    Object localObject2 = com.tencent.mm.live.core.a.a.gMZ;
    com.tencent.mm.live.core.debug.a.yg(com.tencent.mm.live.core.a.a.nf(paramInt) + ')');
    localObject1 = this.gKZ;
    if (localObject1 != null) {
      b.a.a((com.tencent.mm.live.core.core.b)localObject1, paramInt);
    }
    if (paramInt != 0)
    {
      localObject1 = this.gLa;
      if (localObject1 != null)
      {
        localObject2 = c.b.gJM;
        b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.alH());
      }
    }
    this.gKZ = null;
  }
  
  public final void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("[sdk]onFirstVideoFrame uid:" + paramString + " ,streamType:" + paramInt1 + " width:" + paramInt2 + " height:" + paramInt3);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_first_frame_width", paramInt2);
    ((Bundle)localObject).putInt("live_first_frame_height", paramInt3);
    paramString = this.gLa;
    if (paramString != null)
    {
      c.b localb = c.b.gJM;
      paramString.f(c.b.alI(), (Bundle)localObject);
    }
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("[sdk]onRemoteUserLeaveRoom:" + paramString + " reason:" + paramInt);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_user_exit_reason", paramInt);
    com.tencent.mm.live.core.core.b localb = this.gLa;
    if (localb != null)
    {
      c.b localb1 = c.b.gJM;
      localb.f(c.b.alC(), (Bundle)localObject);
    }
    this.gKQ.yd(paramString);
  }
  
  public final void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "[sdk]onUserAudioAvailable:" + paramString + ", available:" + paramBoolean + ", isAnchor:" + this.dzz);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putBoolean("live_media_enable", paramBoolean);
    com.tencent.mm.live.core.core.b localb = this.gLa;
    if (localb != null)
    {
      c.b localb1 = c.b.gJM;
      localb.f(c.b.alD(), (Bundle)localObject);
    }
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramString))) {
      com.tencent.mm.live.core.core.trtc.a.b.c.yc(paramString);
    }
    if (this.dzz) {
      this.gKQ.amp();
    }
  }
  
  public final void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("onUserSubStreamAvailable:" + paramString + ", available:" + paramBoolean);
  }
  
  public final void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("onUserVideoAvailable uid:" + paramString + " available:" + paramBoolean + ", isAnchor:" + this.dzz);
    Object localObject2;
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      localObject2 = this.gKQ;
      localObject1 = this.gKW;
      if (localObject1 != null)
      {
        localObject1 = ((LivePreviewView)localObject1).V(paramString, 0);
        ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject2).a(paramString, (TXCloudVideoView)localObject1);
        localObject1 = this.gLa;
        if (localObject1 != null)
        {
          localObject2 = c.b.gJM;
          b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.alB());
        }
        if ((!this.dzz) && (bu.lX(this.gLc.gKw, paramString)))
        {
          localObject1 = this.gKW;
          if (localObject1 != null) {
            ((LivePreviewView)localObject1).post((Runnable)new LivePreviewView.a((LivePreviewView)localObject1, paramString));
          }
        }
      }
    }
    for (;;)
    {
      if ((!this.dzz) && (!bu.lX(this.gLc.gKw, paramString))) {
        this.gLc.gKx = paramString;
      }
      if (this.dzz) {
        this.gKQ.amp();
      }
      return;
      localObject1 = null;
      break;
      localObject1 = this.gKW;
      if (localObject1 != null) {
        ((LivePreviewView)localObject1).gOF.yl(paramString);
      }
      this.gKQ.yb(paramString);
      localObject1 = this.gLa;
      if (localObject1 != null)
      {
        localObject2 = c.b.gJM;
        b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.alG());
      }
    }
  }
  
  public void release()
  {
    this.gKV.release();
    this.gKP.setListener(null);
    Object localObject = this.gKU;
    if (((com.tencent.mm.live.core.mini.a)localObject).gNb.isHeld()) {
      ((com.tencent.mm.live.core.mini.a)localObject).gNb.release();
    }
    localObject = b.gLs;
    localObject = b.alX();
    if (localObject != null) {
      ((b)localObject).destroy();
    }
    b.a(null);
  }
  
  public final void switchCamera()
  {
    try
    {
      Object localObject = this.gKX;
      com.tencent.mm.media.widget.a.e locale;
      if ((localObject != null) && (((com.tencent.mm.media.widget.a.e)localObject).awp() == true))
      {
        localObject = this.gKX;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.e)localObject).awo();
        }
        this.gKV.amC();
        if (this.gKW != null)
        {
          localObject = this.gKX;
          if ((localObject != null) && (((com.tencent.mm.media.widget.a.e)localObject).awp() == true))
          {
            localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
            p.g(localObject, "ConfigHelper.getInstance()");
            localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).amc();
            locale = this.gKX;
            if (locale == null) {
              break label134;
            }
          }
        }
      }
      label134:
      for (int i = locale.awE();; i = 0)
      {
        ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject).gLQ = i;
        localObject = this.gKX;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.media.widget.a.e)localObject).awA();
          if (localObject != null) {
            this.gKV.a((com.tencent.mm.media.widget.a.b)localObject);
          }
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, "switch camera error:" + localException.getMessage(), new Object[0]);
    }
  }
  
  public final void xU(String paramString)
  {
    p.h(paramString, "state");
    com.tencent.mm.live.core.mini.a.yj(paramString);
  }
  
  public final void xV(String paramString)
  {
    p.h(paramString, "privateMapKey");
    if (!bu.isNullOrNil(paramString))
    {
      i locali = new i();
      locali.h("privateMapKey", paramString);
      paramString = new i();
      paramString.h("api", "updatePrivateMapKey");
      paramString.h("params", locali);
      ae.i("MicroMsg.LiveCore", "updatePrivateMapKey:" + paramString + ' ');
      this.gKP.callExperimentalAPI(paramString.toString());
    }
  }
  
  public final void y(float paramFloat1, float paramFloat2)
  {
    if (this.dzz) {
      this.gKQ.z(paramFloat1, paramFloat2);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, com.tencent.mm.live.core.core.b.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196849);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      this.gLg.alt();
      localObject = new Intent(this.gLg.context, Class.forName(paramd.gKn.name));
      ((Intent)localObject).putExtra("route_to_maximize", true);
      ((Intent)localObject).addFlags(268435456);
      paramView = ak.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196849);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.q<j, Integer, Integer, z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<SurfaceTexture, z>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "width", "", "height", "invoke"})
  public static final class e
    extends d.g.b.q
    implements m
  {
    public e(a parama, j paramj)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  public static final class f
    extends d.g.b.q
    implements d.g.a.b<SurfaceTexture, z>
  {
    public f(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke", "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$startPreviewToRemote$2$1"})
  public static final class g
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.g.d, z>
  {
    public g(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  public static final class h
    extends d.g.b.q
    implements d.g.a.q<j, Integer, Integer, z>
  {
    public h(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a
 * JD-Core Version:    0.7.0.1
 */