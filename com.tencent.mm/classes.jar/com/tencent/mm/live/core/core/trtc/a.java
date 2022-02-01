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
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.live.core.b.d.j;
import com.tencent.mm.live.core.core.b.g.c;
import com.tencent.mm.live.core.core.b.g.d;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.d;
import com.tencent.mm.live.core.core.e.f;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.core.e.i;
import com.tencent.mm.live.core.core.e.j;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.mini.b.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCLocalStatistics;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/IMMLiveCore;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager$IView;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManagerListener;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "isAnchor", "", "(Z)V", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "getBeautyConfig", "()Lcom/tencent/mm/live/core/render/BeautyConfig;", "setBeautyConfig", "(Lcom/tencent/mm/live/core/render/BeautyConfig;)V", "blurFinalFrame", "Landroid/graphics/Bitmap;", "blurFrameRetrieveCallback", "Lkotlin/Function1;", "", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getCamera", "()Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "setCamera", "(Lcom/tencent/mm/media/widget/camera/ICommonCamera;)V", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "enterRoomCallback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "getEnterRoomCallback", "()Lcom/tencent/mm/live/core/core/LiveCallback;", "setEnterRoomCallback", "(Lcom/tencent/mm/live/core/core/LiveCallback;)V", "exitRoomCallback", "getExitRoomCallback", "setExitRoomCallback", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "getFilterConfig", "()Lcom/tencent/mm/live/core/render/FilterConfig;", "setFilterConfig", "(Lcom/tencent/mm/live/core/render/FilterConfig;)V", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "frameTexture", "Lcom/tencent/trtc/TRTCCloudDef$TRTCTexture;", "()Z", "setAnchor", "isPushing", "setPushing", "lastCameraFps", "", "getLastCameraFps", "()I", "setLastCameraFps", "(I)V", "liveCallback", "getLiveCallback", "setLiveCallback", "liveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "miniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getMiniManager", "()Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "setMiniManager", "(Lcom/tencent/mm/live/core/mini/LiveMiniManager;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "getPreviewView", "()Lcom/tencent/mm/live/core/view/LivePreviewView;", "setPreviewView", "(Lcom/tencent/mm/live/core/view/LivePreviewView;)V", "renderManager", "Lcom/tencent/mm/live/core/render/LiveRenderManager;", "getRenderManager", "()Lcom/tencent/mm/live/core/render/LiveRenderManager;", "setRenderManager", "(Lcom/tencent/mm/live/core/render/LiveRenderManager;)V", "trtcCloud", "Lcom/tencent/trtc/TRTCCloud;", "getTrtcCloud", "()Lcom/tencent/trtc/TRTCCloud;", "setTrtcCloud", "(Lcom/tencent/trtc/TRTCCloud;)V", "trtcManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "getTrtcManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "setTrtcManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;)V", "trtcRemoteUserManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "getTrtcRemoteUserManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "setTrtcRemoteUserManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkMirror", "enterRoom", "callback", "exitRoom", "fillMiniView", "miniView", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "dontFinish", "generateType", "opType", "getFinalCameraFrame", "getLiveRoomModel", "getLiveStatus", "getRecordScene", "getRemoteUserViewById", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "", "steamType", "getResolutionLimit", "initCamera", "useCamera2", "frontCamera", "initCameraConfig", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "isInLinkMic", "isInLive", "liveId", "", "justRemoveMiniWindow", "liveScene", "normalMode", "onAudioEffectFinished", "effectId", "code", "onAudioVolumeEvaluationChange", "enable", "onCloseLive", "onConnectOtherRoom", "userID", "err", "errMsg", "onDisConnectOtherRoom", "onEnterRoom", "result", "onError", "errCode", "extraInfo", "Landroid/os/Bundle;", "onExitRoom", "reason", "onFirstVideoFrame", "streamType", "width", "height", "onMuteLocalAudio", "isMute", "onMuteLocalVideo", "onNetworkQuality", "localQuality", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "remoteQuality", "Ljava/util/ArrayList;", "onRecvCustomCmdMsg", "cmdID", "seq", "message", "", "onRecvSEIMsg", "data", "onRemoteUserEnterRoom", "onRemoteUserLeaveRoom", "onRemoteViewStatusUpdate", "onStatistics", "statics", "Lcom/tencent/trtc/TRTCStatistics;", "onUserAudioAvailable", "available", "onUserSubStreamAvailable", "onUserVideoAvailable", "onUserVoiceVolume", "userVolumes", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "refreshCamera", "release", "removeMiniWindow", "setLiveStatusCallback", "setup", "startPreview", "startPreviewOnlyLocal", "surfaceHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "startPreviewToRemote", "stopPreview", "switchCamera", "updateBeautyConfig", "updateFilterConfig", "updateLiveMiniState", "state", "Lcom/tencent/mm/live/core/mini/LiveMiniState;", "updateMirrorMode", "mirrorMode", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "updatePrivateMapKey", "privateMapKey", "updateRemoteOutputSurface", "updateSdkParam", "updateVisitoreRenderMode", "renderMode", "Companion", "plugin-core_release"})
public abstract class a
  implements com.tencent.mm.live.core.core.b, com.tencent.mm.live.core.core.trtc.a.b.c.a, com.tencent.mm.live.core.core.trtc.a.c.a, com.tencent.mm.live.core.core.trtc.a.d, com.tencent.mm.media.widget.camerarecordview.d.b
{
  public static final a hAC = new a((byte)0);
  private boolean dMz;
  protected boolean hAA;
  public int hAB;
  public final MMHandler hAk;
  public TRTCCloud hAl;
  public com.tencent.mm.live.core.core.trtc.a.b.c hAm;
  protected com.tencent.mm.live.core.core.trtc.a.c hAn;
  private final TRTCCloudDef.TRTCVideoFrame hAo;
  private final TRTCCloudDef.TRTCTexture hAp;
  public com.tencent.mm.live.core.mini.b hAq;
  public com.tencent.mm.live.core.b.d hAr;
  protected LivePreviewView hAs;
  protected com.tencent.mm.media.widget.a.d hAt;
  private com.tencent.mm.media.widget.a.b hAu;
  protected com.tencent.mm.live.core.core.c hAv;
  protected com.tencent.mm.live.core.core.c hAw;
  public com.tencent.mm.live.core.core.c hAx;
  public com.tencent.mm.live.core.core.b.f hAy;
  public com.tencent.mm.live.core.core.b.g hAz;
  
  public a(boolean paramBoolean)
  {
    this.dMz = paramBoolean;
    this.hAk = new MMHandler(Looper.getMainLooper());
    Object localObject = b.hAP;
    localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    p.h(localObject, "var0");
    if (b.aDB() == null) {
      b.a(new b((Context)localObject));
    }
    localObject = b.aDB();
    if (localObject == null) {
      p.hyc();
    }
    this.hAl = ((TRTCCloud)localObject);
    this.hAm = new com.tencent.mm.live.core.core.trtc.a.b.c(this.hAl, (com.tencent.mm.live.core.core.trtc.a.b.c.a)this);
    this.hAo = new TRTCCloudDef.TRTCVideoFrame();
    this.hAp = new TRTCCloudDef.TRTCTexture();
    this.hAq = new com.tencent.mm.live.core.mini.b();
    this.hAr = new com.tencent.mm.live.core.b.d();
    this.hAz = new com.tencent.mm.live.core.core.b.g();
    this.hAB = 15;
    Log.i("MicroMsg.LiveCore", "live anchor use trtc,ver:" + TRTCCloud.getSDKVersion());
    localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("use trtc sdk,ver:" + TRTCCloud.getSDKVersion());
    TXLiveBase.setListener((ITXLiveBaseListener)1.hAD);
    if (this.hAz.isDebugMode)
    {
      TRTCCloud.setLogLevel(0);
      TRTCCloud.setConsoleEnabled(true);
      return;
    }
    TRTCCloud.setLogLevel(4);
  }
  
  private void aDz()
  {
    Object localObject1 = new com.tencent.mm.media.widget.camerarecordview.d.b.a.a();
    Object localObject2 = com.tencent.mm.compatible.c.a.gDs;
    int j = com.tencent.mm.compatible.c.a.anJ();
    if (j >= 0)
    {
      int i = 0;
      for (;;)
      {
        localObject2 = new b.a.c();
        Object localObject3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject3, "ConfigHelper.getInstance()");
        localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).aDD();
        p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
        ((b.a.c)localObject2).irh = Integer.valueOf(((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).aDR());
        localObject3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject3, "ConfigHelper.getInstance()");
        localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).aDD();
        p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
        ((b.a.c)localObject2).irg = Integer.valueOf(((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).aDR());
        localObject3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject3, "ConfigHelper.getInstance()");
        localObject3 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject3).aDD();
        p.g(localObject3, "ConfigHelper.getInstance().videoConfig");
        ((b.a.c)localObject2).iri = Integer.valueOf(((com.tencent.mm.live.core.core.trtc.a.a.d)localObject3).aDR());
        ((com.tencent.mm.media.widget.camerarecordview.d.b.a.a)localObject1).b(new o[] { new o(Integer.valueOf(i), localObject2) });
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    ((com.tencent.mm.media.widget.camerarecordview.d.b.a.a)localObject1).scene = 13;
    localObject1 = ((com.tencent.mm.media.widget.camerarecordview.d.b.a.a)localObject1).aQz();
    localObject2 = this.hAt;
    if (localObject2 != null) {
      ((com.tencent.mm.media.widget.a.d)localObject2).a((b.a)localObject1);
    }
  }
  
  private final int k(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    Object localObject1 = new StringBuilder("useCamera2:").append(paramBoolean1).append(", frontCamera:").append(paramBoolean2).append(" fps:");
    Object localObject2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    p.g(localObject2, "ConfigHelper.getInstance()");
    localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).aDD();
    p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
    Log.i("MicroMsg.LiveCore", ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject2).aDR());
    if (paramBoolean1)
    {
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = (com.tencent.mm.media.widget.a.d)new com.tencent.mm.media.widget.b.c((Context)localObject1);
      this.hAt = ((com.tencent.mm.media.widget.a.d)localObject1);
      aDz();
      localObject1 = this.hAt;
      if (localObject1 != null)
      {
        localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        if (paramBoolean2) {
          break label209;
        }
      }
    }
    label209:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      if (((com.tencent.mm.media.widget.a.d)localObject1).v((Context)localObject2, paramBoolean1) != true)
      {
        Log.e("MicroMsg.LiveCoreError", "[-1] live anchor open camera error");
        i = -1;
      }
      return i;
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = (com.tencent.mm.media.widget.a.d)new com.tencent.mm.media.widget.a.c((Context)localObject1);
      break;
    }
  }
  
  public final void A(float paramFloat1, float paramFloat2)
  {
    if (this.dMz) {
      this.hAm.B(paramFloat1, paramFloat2);
    }
  }
  
  public void Go(String paramString)
  {
    p.h(paramString, "privateMapKey");
    if (!Util.isNullOrNil(paramString))
    {
      i locali = new i();
      locali.h("privateMapKey", paramString);
      paramString = new i();
      paramString.h("api", "updatePrivateMapKey");
      paramString.h("params", locali);
      Log.i("MicroMsg.LiveCore", "updatePrivateMapKey:" + paramString + ' ');
      this.hAl.callExperimentalAPI(paramString.toString());
    }
  }
  
  public final void Gp(String paramString)
  {
    Log.i("MicroMsg.LiveCore", "updateRemoteOutputSurface userId:".concat(String.valueOf(paramString)));
    com.tencent.mm.live.core.core.trtc.a.b.c localc;
    if (paramString != null)
    {
      localc = this.hAm;
      localObject = this.hAs;
      if (localObject == null) {
        break label48;
      }
    }
    label48:
    for (Object localObject = ((LivePreviewView)localObject).X(paramString, 0);; localObject = null)
    {
      localc.a(paramString, (TXCloudVideoView)localObject);
      return;
    }
  }
  
  public final TXCloudVideoView W(String paramString, int paramInt)
  {
    LivePreviewView localLivePreviewView = this.hAs;
    if (localLivePreviewView != null) {
      return localLivePreviewView.X(paramString, paramInt);
    }
    return null;
  }
  
  public int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    p.h(paramContext, "context");
    Object localObject1 = paramContext.getResources();
    p.g(localObject1, "context.resources");
    int i;
    Object localObject2;
    label140:
    long l;
    label244:
    Object localObject3;
    label280:
    View localView;
    if (((Resources)localObject1).getConfiguration().orientation == 1)
    {
      i = au.az(paramContext).x / 4;
      localObject1 = new Point(i, (int)(au.az(paramContext).y / au.az(paramContext).x * i));
      this.hAr.cX(((Point)localObject1).x, ((Point)localObject1).y);
      Log.i("MicroMsg.LiveCore", "floatMode context:".concat(String.valueOf(paramContext)));
      localObject2 = this.hAy;
      if (localObject2 == null) {
        break label567;
      }
      localObject2 = ((com.tencent.mm.live.core.core.b.f)localObject2).hwP;
      if (localObject2 == null) {
        break label567;
      }
      i = ((com.tencent.mm.live.core.core.b.e)localObject2).hzo;
      if (paramBoolean1)
      {
        paramBoolean1 = ((Activity)paramContext).isTaskRoot();
        if (!paramBoolean2) {
          break label580;
        }
        paramBoolean2 = ((Activity)paramContext).moveTaskToBack(paramBoolean1);
        Log.i("MicroMsg.LiveCore", "floatMode moveTaskToBack ret:" + paramBoolean2 + ", isTaskRoot:" + paramBoolean1 + " scene:" + i);
      }
      paramContext = this.hAq;
      localObject2 = this.hAy;
      if (localObject2 == null) {
        break label647;
      }
      localObject2 = ((com.tencent.mm.live.core.core.b.f)localObject2).hwP;
      if (localObject2 == null) {
        break label647;
      }
      l = ((com.tencent.mm.live.core.core.b.e)localObject2).liveId;
      paramBoolean1 = this.dMz;
      p.h(localObject1, "size");
      paramBoolean2 = paramContext.gqx;
      localObject2 = paramContext.hCO;
      if (localObject2 == null) {
        break label653;
      }
      i = ((AbsLiveMiniView)localObject2).aEg();
      localObject2 = new com.tencent.mm.live.core.mini.f(paramBoolean2, l, paramBoolean1, paramInt1, i, paramInt2);
      localObject3 = com.tencent.mm.live.core.mini.a.hCD;
      localObject3 = com.tencent.mm.live.core.mini.a.b.hCF;
      localObject3 = com.tencent.mm.live.core.mini.a.b.aEi();
      localView = (View)paramContext.hCO;
      p.h(localObject2, "reportDataInfo");
      p.h(localObject1, "size");
      if (localView != null)
      {
        paramInt1 = at.aH(MMApplicationContext.getContext(), 2131165314);
        localView.setPadding(paramInt1, paramInt1, paramInt1, paramInt1);
        paramBoolean1 = ((com.tencent.mm.live.core.mini.f)localObject2).gqx;
        if (!((com.tencent.mm.live.core.mini.a)localObject3).ciq()) {
          break label687;
        }
        if (((com.tencent.mm.live.core.mini.a)localObject3).oWE.vk == localView) {
          break label659;
        }
        Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", new Object[] { Integer.valueOf(4), localView, ((com.tencent.mm.live.core.mini.a)localObject3).oWE.vk });
        ((com.tencent.mm.live.core.mini.a)localObject3).oWE.oWr = true;
        ((com.tencent.mm.live.core.mini.a)localObject3).oWE.state = 4;
        ((com.tencent.mm.live.core.mini.a)localObject3).oWE.vk = localView;
        ((com.tencent.mm.live.core.mini.a)localObject3).oWE.nno = false;
        ((com.tencent.mm.live.core.mini.a)localObject3).oWE.oWq = true;
        ((com.tencent.mm.live.core.mini.a)localObject3).oWE.gqx = paramBoolean1;
        ((com.tencent.mm.live.core.mini.a)localObject3).a((com.tencent.mm.live.core.mini.f)localObject2);
        ((com.tencent.mm.live.core.mini.a)localObject3).aEh();
        ((com.tencent.mm.live.core.mini.a)localObject3).cis();
      }
    }
    for (;;)
    {
      paramContext.gqx = true;
      this.hAz.hzE = g.d.hzX;
      return 0;
      i = au.az(paramContext).y / 4;
      localObject1 = new Point((int)(au.az(paramContext).x / au.az(paramContext).y * i), i);
      break;
      label567:
      localObject2 = e.f.hxS;
      i = e.f.aCO();
      break label140;
      label580:
      localObject2 = e.f.hxS;
      if (i == e.f.aCP()) {
        ((Activity)paramContext).finish();
      }
      for (;;)
      {
        Log.i("MicroMsg.LiveCore", "floatMode finishAndRemoveTask, isTaskRoot:" + paramBoolean1 + " scene:" + i);
        break;
        ((Activity)paramContext).finishAndRemoveTask();
      }
      label647:
      l = 0L;
      break label244;
      label653:
      i = 0;
      break label280;
      label659:
      Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, has ball, state:%s, view:%s", new Object[] { Integer.valueOf(4), localView });
      continue;
      label687:
      localObject1 = (Runnable)new com.tencent.mm.live.core.mini.a.c((com.tencent.mm.live.core.mini.a)localObject3, localView, paramBoolean1, (com.tencent.mm.live.core.mini.f)localObject2, (Point)localObject1);
      l = ((com.tencent.mm.live.core.mini.a)localObject3).hCC + 200L - Util.nowMilliSecond();
      if (l <= 0L)
      {
        ((Runnable)localObject1).run();
      }
      else
      {
        Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, no ball, add delayed:%s", new Object[] { Long.valueOf(l) });
        MMHandlerThread.postToMainThreadDelayed((Runnable)localObject1, l);
      }
    }
  }
  
  public final int a(final com.tencent.mm.live.core.b.l paraml)
  {
    p.h(paraml, "surfaceHolder");
    this.hAr.aEz();
    paraml.hEC = ((kotlin.g.a.a)new d(this, paraml));
    paraml.hED = ((m)new e(this));
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("startPreview " + paraml + ' ');
    paraml = this.hAy;
    boolean bool1;
    if (paraml != null)
    {
      paraml = paraml.hzt;
      if (paraml != null)
      {
        bool1 = paraml.hzg;
        paraml = this.hAy;
        if (paraml == null) {
          break label201;
        }
        paraml = paraml.hzt;
        if (paraml == null) {
          break label201;
        }
      }
    }
    label201:
    for (boolean bool2 = paraml.hzh;; bool2 = true)
    {
      k(bool1, bool2);
      paraml = this.hAy;
      if (paraml != null)
      {
        paraml = paraml.hzt;
        if ((paraml != null) && (paraml.hzi == true))
        {
          paraml = this.hAt;
          if (paraml != null) {
            paraml.a(this.hAr.getFrameDataCallback());
          }
        }
      }
      this.hAr.d((kotlin.g.a.b)new f(this));
      return 0;
      bool1 = false;
      break;
    }
  }
  
  public final int a(com.tencent.mm.live.core.core.b.f paramf)
  {
    p.h(paramf, "model");
    Log.i("MicroMsg.LiveCore", "setup model:".concat(String.valueOf(paramf)));
    Object localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("model:".concat(String.valueOf(paramf)));
    this.hAy = paramf;
    localObject = this.hAy;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
      if (localObject != null) {
        if (this.hAu == null) {
          break label321;
        }
      }
    }
    label321:
    for (boolean bool = com.tencent.mm.media.widget.a.b.aPn();; bool = true)
    {
      ((com.tencent.mm.live.core.core.b.d)localObject).hzh = bool;
      localObject = this.hAr;
      p.h(paramf, "model");
      ((com.tencent.mm.live.core.b.d)localObject).hAy = paramf;
      this.hAz.hzJ = paramf.hzu.userId;
      localObject = this.hAq;
      String str = paramf.hzv.name;
      p.h(str, "activityName");
      ((com.tencent.mm.live.core.mini.b)localObject).intent.setClass(MMApplicationContext.getContext(), Class.forName(str));
      ((com.tencent.mm.live.core.mini.b)localObject).intent.addFlags(268435456);
      ((com.tencent.mm.live.core.mini.b)localObject).hCQ = str;
      this.hAn = new com.tencent.mm.live.core.core.trtc.a.c(this.hAl, paramf.hzu);
      localObject = this.hAn;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.trtc.a.c)localObject).a((com.tencent.mm.live.core.core.trtc.a.c.a)this);
      }
      localObject = this.hAn;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.trtc.a.c)localObject).a((com.tencent.mm.live.core.core.trtc.a.d)this);
      }
      localObject = this.hAn;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.trtc.a.c)localObject).aDI();
      }
      this.hAm.Gs(paramf.hzu.userId);
      this.hAz.hzG = paramf.hwP.hzm;
      this.hAm.y(paramf.hwP.appId, paramf.hwP.hzn);
      Log.i("MicroMsg.LiveCore", "steve:setQCloudAccount qppid: %s, bizid: %s", new Object[] { Long.valueOf(paramf.hwP.appId), Long.valueOf(paramf.hwP.hzn) });
      return 0;
    }
  }
  
  public final int a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.b.a parama, com.tencent.mm.live.core.b.b paramb)
  {
    if (paramLivePreviewView == null)
    {
      Log.e("MicroMsg.LiveCore", "startPreview preiewView is null");
      return -3;
    }
    Object localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("startPreview ".concat(String.valueOf(paramLivePreviewView)));
    this.hAs = paramLivePreviewView;
    localObject = this.hAy;
    boolean bool2;
    boolean bool1;
    label99:
    com.tencent.mm.media.widget.a.d locald;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
      if (localObject != null)
      {
        bool2 = ((com.tencent.mm.live.core.core.b.d)localObject).hzg;
        localObject = this.hAy;
        if (localObject == null) {
          break label374;
        }
        localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
        if (localObject == null) {
          break label374;
        }
        bool1 = ((com.tencent.mm.live.core.core.b.d)localObject).hzh;
        k(bool2, bool1);
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDD();
        p.g(localObject, "ConfigHelper.getInstance().videoConfig");
        this.hAB = ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).aDR();
        localObject = this.hAy;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
          if ((localObject != null) && (((com.tencent.mm.live.core.core.b.d)localObject).hzi == true))
          {
            localObject = this.hAt;
            if (localObject != null) {
              ((com.tencent.mm.media.widget.a.d)localObject).a(this.hAr.getFrameDataCallback());
            }
          }
        }
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDE();
        p.g(localObject, "ConfigHelper.getInstance().audioConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).ez(true);
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDD();
        p.g(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).eC(true);
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDG();
        locald = this.hAt;
        if (locald == null) {
          break label399;
        }
      }
    }
    label399:
    for (int i = locald.aPu();; i = 0)
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject).hBp = i;
      paramLivePreviewView.a((kotlin.g.a.q)new b(this));
      this.hAr.a(parama);
      this.hAr.a(paramb);
      this.hAr.d((kotlin.g.a.b)new c(this));
      return 0;
      bool2 = false;
      break;
      label374:
      if ((this.hAu == null) || (com.tencent.mm.media.widget.a.b.aPn()))
      {
        bool1 = true;
        break label99;
      }
      bool1 = false;
      break label99;
    }
  }
  
  public final void a(com.tencent.mm.live.core.b.b paramb)
  {
    this.hAr.a(paramb);
  }
  
  public void a(com.tencent.mm.live.core.core.c paramc)
  {
    p.h(paramc, "callback");
    int i;
    if (this.hAz.hzA == g.c.hzU)
    {
      i = 1;
      if (i == 0) {
        break label46;
      }
      Log.i("MicroMsg.LiveCore", "entering room or already room");
      this.hAv = paramc;
    }
    label46:
    do
    {
      return;
      i = 0;
      break;
      Object localObject = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.GA("start create room");
      com.tencent.mm.live.core.core.b.g localg = this.hAz;
      localObject = this.hAy;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hwP;
        if (localObject == null) {}
      }
      for (localObject = Long.valueOf(((com.tencent.mm.live.core.core.b.e)localObject).liveId); localg.b((Long)localObject); localObject = null)
      {
        localObject = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("enter room and already in room");
        com.tencent.mm.live.core.core.c.a.a(paramc, 0);
        return;
      }
      this.hAv = paramc;
      paramc = this.hAz;
      localObject = g.c.hzU;
      p.h(localObject, "status");
      paramc.hzA = ((g.c)localObject);
      paramc = this.hAn;
    } while (paramc == null);
    paramc.aDJ();
  }
  
  public final void a(AbsLiveMiniView paramAbsLiveMiniView)
  {
    com.tencent.mm.live.core.mini.b localb = this.hAq;
    com.tencent.mm.live.core.mini.e locale = new com.tencent.mm.live.core.mini.e(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8));
    localb.hCO = paramAbsLiveMiniView;
    paramAbsLiveMiniView = localb.hCO;
    if (paramAbsLiveMiniView != null) {
      paramAbsLiveMiniView.setClipToOutline(true);
    }
    paramAbsLiveMiniView = localb.hCO;
    if (paramAbsLiveMiniView != null) {
      paramAbsLiveMiniView.setOutlineProvider((ViewOutlineProvider)locale);
    }
    localb.hCP.setBackgroundColor(-16777216);
    localb.hCP.setClipToOutline(true);
    localb.hCP.setOutlineProvider((ViewOutlineProvider)locale);
    if ((localb.hCP.getParent() != null) && ((localb.hCP.getParent() instanceof ViewGroup)))
    {
      paramAbsLiveMiniView = localb.hCP.getParent();
      if (paramAbsLiveMiniView == null) {
        throw new t("null cannot be cast to non-null type android.view.ViewGroup");
      }
      paramAbsLiveMiniView = (ViewGroup)paramAbsLiveMiniView;
      if (paramAbsLiveMiniView != null) {
        paramAbsLiveMiniView.removeView((View)localb.hCP);
      }
    }
    paramAbsLiveMiniView = localb.hCO;
    if (paramAbsLiveMiniView != null) {
      paramAbsLiveMiniView.addView((View)localb.hCP, 0);
    }
  }
  
  public final void a(com.tencent.mm.live.core.mini.d paramd)
  {
    p.h(paramd, "state");
    com.tencent.mm.live.core.mini.b localb = this.hAq;
    p.h(paramd, "state");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b.b(localb, paramd));
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
          break label159;
        }
        paramTRTCQuality = e.h.hya;
        i = e.h.aCS();
      }
      label28:
      j = this.hAz.hzL;
      paramTRTCQuality = e.h.hya;
      if (j == e.h.aCV()) {
        break label203;
      }
      paramTRTCQuality = e.h.hya;
      if (i != e.h.aCV()) {
        break label203;
      }
      a(com.tencent.mm.live.core.mini.d.hCW);
    }
    for (;;)
    {
      if (this.hAz.hzL != i)
      {
        this.hAz.hzL = i;
        Log.i("MicroMsg.LiveCore", "onNetworkQuality, local:".concat(String.valueOf(i)));
      }
      i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
      if (this.hAz.networkType != i) {
        this.hAz.networkType = i;
      }
      paramTRTCQuality = this.hAx;
      if (paramTRTCQuality != null)
      {
        e.d locald = e.d.hxF;
        com.tencent.mm.live.core.core.c.a.a(paramTRTCQuality, e.d.aCr());
      }
      return;
      paramTRTCQuality = e.h.hya;
      j = e.h.aCS();
      break;
      label159:
      if (j <= 4)
      {
        paramTRTCQuality = e.h.hya;
        i = e.h.aCT();
        break label28;
      }
      if (j < 6)
      {
        paramTRTCQuality = e.h.hya;
        i = e.h.aCU();
        break label28;
      }
      paramTRTCQuality = e.h.hya;
      i = e.h.aCV();
      break label28;
      label203:
      j = this.hAz.hzL;
      paramTRTCQuality = e.h.hya;
      if (j == e.h.aCV())
      {
        paramTRTCQuality = e.h.hya;
        if (i != e.h.aCV()) {
          a(com.tencent.mm.live.core.mini.d.hCV);
        }
      }
    }
  }
  
  public final int aBS()
  {
    try
    {
      Log.i("MicroMsg.LiveCore", "release");
      this.hAr.j((kotlin.g.a.a)new i(this));
      return 0;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, "camera release error:" + localException.getMessage(), new Object[0]);
    }
    return 0;
  }
  
  public final void aBT()
  {
    Object localObject1 = this.hAt;
    Object localObject2;
    com.tencent.mm.media.widget.a.d locald;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.a.d)localObject1).aPr();
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).aDG();
        locald = this.hAt;
        if (locald == null) {
          break label69;
        }
      }
    }
    label69:
    for (int i = locald.aPu();; i = 0)
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject2).hBp = i;
      this.hAr.a((com.tencent.mm.media.widget.a.b)localObject1);
      return;
    }
  }
  
  public void aBU()
  {
    this.hAz.hzE = g.d.hzW;
  }
  
  public final com.tencent.mm.live.core.core.b.g aBV()
  {
    return this.hAz;
  }
  
  public final void aBW()
  {
    this.hAz.hzE = g.d.hzW;
    this.hAq.aEj();
  }
  
  public boolean aDx()
  {
    return false;
  }
  
  public final void aDy()
  {
    com.tencent.mm.live.core.core.trtc.a.c localc = this.hAn;
    if (localc != null) {
      localc.aDK();
    }
  }
  
  public final void b(com.tencent.mm.live.core.core.c paramc)
  {
    p.h(paramc, "callback");
    Object localObject = com.tencent.mm.live.core.mini.c.hCU;
    com.tencent.mm.live.core.core.b.g localg = this.hAz;
    localObject = this.hAy;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hwP;
      if (localObject == null) {}
    }
    for (localObject = Long.valueOf(((com.tencent.mm.live.core.core.b.e)localObject).liveId); !localg.b((Long)localObject); localObject = null)
    {
      localObject = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.GA("already exit room");
      com.tencent.mm.live.core.core.c.a.a(paramc, 0);
      return;
    }
    aBS();
    this.hAw = paramc;
    paramc = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("start exit room");
    paramc = this.hAn;
    if (paramc != null) {
      paramc.exitRoom();
    }
    paramc = this.hAz;
    paramc.hzA = g.c.hzS;
    paramc.hzF = -1L;
  }
  
  public final void c(com.tencent.mm.live.core.core.c paramc)
  {
    this.hAx = paramc;
  }
  
  public final void ex(boolean paramBoolean)
  {
    Log.i("MicroMsg.LiveCore", "onAudioVolumeEvaluationChange:".concat(String.valueOf(paramBoolean)));
  }
  
  public int getRecordScene()
  {
    return 13;
  }
  
  public int getResolutionLimit()
  {
    Object localObject = this.hAy;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
      if (localObject != null) {
        return ((com.tencent.mm.live.core.core.b.d)localObject).hzj;
      }
    }
    return 1080;
  }
  
  public final void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    Log.i("MicroMsg.LiveCore", "onConnectOtherRoom, userID:" + paramString1 + ", err:" + paramInt + ", errMsg:$" + paramString2);
    if (paramInt == 0)
    {
      paramString2 = new Bundle();
      Object localObject = e.b.hxe;
      paramString2.putString(e.b.aCg(), paramString1);
      paramString1 = this.hAx;
      if (paramString1 != null)
      {
        localObject = e.d.hxF;
        paramString1.callback(e.d.aCw(), paramString2);
      }
    }
  }
  
  public final void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    Log.i("MicroMsg.LiveCore", "onDisConnectOtherRoom, err:" + paramInt + ", errMsg:" + paramString);
    if (paramInt == 0)
    {
      paramString = new Bundle();
      com.tencent.mm.live.core.core.c localc = this.hAx;
      if (localc != null)
      {
        e.d locald = e.d.hxF;
        localc.callback(e.d.aCx(), paramString);
      }
    }
  }
  
  public void onEnterRoom(long paramLong)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.hCA;
    localObject1 = new StringBuilder("create room ret:").append(paramLong).append('(');
    Object localObject2 = com.tencent.mm.live.core.a.a.hCB;
    com.tencent.mm.live.core.debug.a.GA(com.tencent.mm.live.core.a.a.qw((int)paramLong) + ')');
    localObject1 = this.hAv;
    if (localObject1 != null) {
      com.tencent.mm.live.core.core.c.a.a((com.tencent.mm.live.core.core.c)localObject1, (int)paramLong);
    }
    this.hAv = null;
    localObject1 = this.hAz;
    localObject2 = this.hAy;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.b.f)localObject2).hwP;
      if (localObject2 == null) {}
    }
    for (paramLong = ((com.tencent.mm.live.core.core.b.e)localObject2).liveId;; paramLong = -1L)
    {
      ((com.tencent.mm.live.core.core.b.g)localObject1).hzA = g.c.hzT;
      ((com.tencent.mm.live.core.core.b.g)localObject1).hzF = paramLong;
      return;
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    paramBundle = new Bundle();
    paramBundle.putInt("live_err_code", paramInt);
    com.tencent.mm.live.core.core.c localc = this.hAx;
    if (localc != null)
    {
      e.d locald = e.d.hxF;
      localc.callback(e.d.aCs(), paramBundle);
    }
    paramBundle = com.tencent.mm.live.core.debug.a.hCA;
    paramString = new StringBuilder("[").append(paramInt).append("]msg:").append(paramString).append('(');
    paramBundle = com.tencent.mm.live.core.a.a.hCB;
    com.tencent.mm.live.core.debug.a.GA(com.tencent.mm.live.core.a.a.qw(paramInt) + ')');
  }
  
  public final void onExitRoom(int paramInt)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.hCA;
    localObject1 = new StringBuilder("[").append(paramInt).append("]end exit room.(");
    Object localObject2 = com.tencent.mm.live.core.a.a.hCB;
    com.tencent.mm.live.core.debug.a.GA(com.tencent.mm.live.core.a.a.qw(paramInt) + ')');
    localObject1 = this.hAw;
    if (localObject1 != null) {
      com.tencent.mm.live.core.core.c.a.a((com.tencent.mm.live.core.core.c)localObject1, paramInt);
    }
    if (paramInt != 0)
    {
      localObject1 = this.hAx;
      if (localObject1 != null)
      {
        localObject2 = e.d.hxF;
        com.tencent.mm.live.core.core.c.a.a((com.tencent.mm.live.core.core.c)localObject1, e.d.aCu());
      }
    }
    this.hAw = null;
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("[sdk]onFirstVideoFrame uid:" + paramString + " ,streamType:" + paramInt1 + " width:" + paramInt2 + " height:" + paramInt3);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_first_frame_width", paramInt2);
    ((Bundle)localObject).putInt("live_first_frame_height", paramInt3);
    paramString = this.hAx;
    if (paramString != null)
    {
      e.d locald = e.d.hxF;
      paramString.callback(e.d.aCv(), (Bundle)localObject);
    }
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("[sdk]onRemoteUserLeaveRoom:" + paramString + " reason:" + paramInt);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_user_exit_reason", paramInt);
    com.tencent.mm.live.core.core.c localc = this.hAx;
    if (localc != null)
    {
      e.d locald = e.d.hxF;
      localc.callback(e.d.aCp(), (Bundle)localObject);
    }
    this.hAm.Gx(paramString);
  }
  
  public final void onStatistics(TRTCStatistics paramTRTCStatistics)
  {
    long l2 = 0L;
    int j = 0;
    Log.i("MicroMsg.LiveCore", "onStatistics, statics:".concat(String.valueOf(paramTRTCStatistics)));
    Bundle localBundle = new Bundle();
    Object localObject1 = e.j.hyq;
    localObject1 = e.j.aDj();
    Object localObject2 = com.tencent.mm.live.core.d.b.hEQ;
    localBundle.putString((String)localObject1, com.tencent.mm.live.core.d.b.a(paramTRTCStatistics));
    localObject1 = e.j.hyq;
    localObject1 = e.j.aCY();
    localObject2 = this.hAy;
    label211:
    int i;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.b.f)localObject2).hwP;
      if (localObject2 != null)
      {
        l1 = ((com.tencent.mm.live.core.core.b.e)localObject2).liveId;
        localBundle.putLong((String)localObject1, l1);
        localObject1 = e.j.hyq;
        localObject1 = e.j.aCZ();
        localObject2 = e.i.hyd;
        localBundle.putInt((String)localObject1, e.i.aCW());
        localObject1 = e.j.hyq;
        localObject1 = e.j.aDa();
        localObject2 = e.a.hxc;
        localBundle.putInt((String)localObject1, e.a.aCe());
        localObject1 = e.j.hyq;
        localBundle.putLong(e.j.aDb(), System.currentTimeMillis());
        localObject1 = e.j.hyq;
        localObject1 = e.j.aDc();
        localObject2 = this.hAy;
        if (localObject2 == null) {
          break label704;
        }
        localObject2 = ((com.tencent.mm.live.core.core.b.f)localObject2).hwP;
        if (localObject2 == null) {
          break label704;
        }
        l1 = ((com.tencent.mm.live.core.core.b.e)localObject2).startTime;
        localBundle.putLong((String)localObject1, l1);
        if (paramTRTCStatistics != null)
        {
          localObject2 = String.valueOf(paramTRTCStatistics.appCpu);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localBundle.putString("CPU_USAGE", (String)localObject1);
        if (paramTRTCStatistics == null) {
          break label710;
        }
        localObject1 = paramTRTCStatistics.localArray;
        if (localObject1 == null) {
          break label710;
        }
        localObject1 = (TRTCStatistics.TRTCLocalStatistics)j.kt((List)localObject1);
        if (localObject1 == null) {
          break label710;
        }
        i = ((TRTCStatistics.TRTCLocalStatistics)localObject1).width;
        label296:
        localBundle.putInt("VIDEO_WIDTH", i);
        if (paramTRTCStatistics == null) {
          break label715;
        }
        localObject1 = paramTRTCStatistics.localArray;
        if (localObject1 == null) {
          break label715;
        }
        localObject1 = (TRTCStatistics.TRTCLocalStatistics)j.kt((List)localObject1);
        if (localObject1 == null) {
          break label715;
        }
        i = ((TRTCStatistics.TRTCLocalStatistics)localObject1).height;
        label344:
        localBundle.putInt("VIDEO_HEIGHT", i);
        if (paramTRTCStatistics == null) {
          break label720;
        }
        localObject1 = paramTRTCStatistics.localArray;
        if (localObject1 == null) {
          break label720;
        }
        localObject1 = (TRTCStatistics.TRTCLocalStatistics)j.kt((List)localObject1);
        if (localObject1 == null) {
          break label720;
        }
        i = ((TRTCStatistics.TRTCLocalStatistics)localObject1).videoBitrate;
        label392:
        localBundle.putInt("VIDEO_BITRATE", i);
        if (paramTRTCStatistics == null) {
          break label725;
        }
        localObject1 = paramTRTCStatistics.localArray;
        if (localObject1 == null) {
          break label725;
        }
        localObject1 = (TRTCStatistics.TRTCLocalStatistics)j.kt((List)localObject1);
        if (localObject1 == null) {
          break label725;
        }
        i = ((TRTCStatistics.TRTCLocalStatistics)localObject1).audioBitrate;
        label440:
        localBundle.putInt("AUDIO_BITRATE", i);
        if (paramTRTCStatistics == null) {
          break label730;
        }
        localObject1 = paramTRTCStatistics.localArray;
        if (localObject1 == null) {
          break label730;
        }
        localObject1 = (TRTCStatistics.TRTCLocalStatistics)j.kt((List)localObject1);
        if (localObject1 == null) {
          break label730;
        }
        i = ((TRTCStatistics.TRTCLocalStatistics)localObject1).frameRate;
        label488:
        localBundle.putInt("VIDEO_FPS", i);
        localBundle.putInt("NET_SPEED", CdnLogic.getRecentAverageSpeed(2));
        localObject1 = e.j.hyq;
        localObject1 = e.j.aDd();
        if (paramTRTCStatistics == null) {
          break label735;
        }
        i = paramTRTCStatistics.rtt;
        label528:
        localBundle.putInt((String)localObject1, i);
        localObject1 = e.j.hyq;
        localObject1 = e.j.aDe();
        if (paramTRTCStatistics == null) {
          break label740;
        }
        i = paramTRTCStatistics.upLoss;
        label555:
        localBundle.putInt((String)localObject1, i);
        localObject1 = e.j.hyq;
        localObject1 = e.j.aDf();
        i = j;
        if (paramTRTCStatistics != null) {
          i = paramTRTCStatistics.downLoss;
        }
        localBundle.putInt((String)localObject1, i);
        localObject1 = e.j.hyq;
        localObject1 = e.j.aDg();
        if (paramTRTCStatistics == null) {
          break label745;
        }
      }
    }
    label704:
    label710:
    label715:
    label720:
    label725:
    label730:
    label735:
    label740:
    label745:
    for (long l1 = paramTRTCStatistics.sendBytes;; l1 = 0L)
    {
      localBundle.putLong((String)localObject1, l1);
      localObject1 = e.j.hyq;
      localObject1 = e.j.aDh();
      l1 = l2;
      if (paramTRTCStatistics != null) {
        l1 = paramTRTCStatistics.receiveBytes;
      }
      localBundle.putLong((String)localObject1, l1);
      paramTRTCStatistics = e.j.hyq;
      localBundle.putInt(e.j.aDi(), NetStatusUtil.getNetType(MMApplicationContext.getContext()));
      paramTRTCStatistics = this.hAx;
      if (paramTRTCStatistics != null)
      {
        localObject1 = e.d.hxF;
        paramTRTCStatistics.callback(e.d.aCz(), localBundle);
      }
      return;
      l1 = 0L;
      break;
      l1 = 0L;
      break label211;
      i = 0;
      break label296;
      i = 0;
      break label344;
      i = 0;
      break label392;
      i = 0;
      break label440;
      i = 0;
      break label488;
      i = 0;
      break label528;
      i = 0;
      break label555;
    }
  }
  
  public final void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sdk]onUserAudioAvailable:" + paramString + ", available:" + paramBoolean + ", isAnchor:" + this.dMz);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putBoolean("live_media_enable", paramBoolean);
    com.tencent.mm.live.core.core.c localc = this.hAx;
    if (localc != null)
    {
      e.d locald = e.d.hxF;
      localc.callback(e.d.aCq(), (Bundle)localObject);
    }
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramString))) {
      com.tencent.mm.live.core.core.trtc.a.b.c.Gw(paramString);
    }
    int i;
    if (this.dMz)
    {
      paramString = this.hAy;
      if (paramString != null)
      {
        paramString = paramString.hwP;
        if (paramString != null)
        {
          i = paramString.hzo;
          paramString = e.f.hxS;
          if (i == e.f.aCO()) {
            this.hAm.aDU();
          }
        }
      }
    }
    else
    {
      return;
    }
    paramString = this.hAy;
    if (paramString != null)
    {
      paramString = paramString.hwP;
      if (paramString != null)
      {
        i = paramString.hzo;
        paramString = e.f.hxS;
        if (i == e.f.aCP())
        {
          this.hAm.aDV();
          return;
        }
      }
    }
    localObject = new StringBuilder("invalid live scene: ");
    paramString = this.hAy;
    if (paramString != null)
    {
      paramString = paramString.hwP;
      if (paramString == null) {}
    }
    for (paramString = Integer.valueOf(paramString.hzo);; paramString = null)
    {
      Log.w("MicroMsg.LiveCore", paramString);
      return;
    }
  }
  
  public final void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("onUserSubStreamAvailable:" + paramString + ", available:" + paramBoolean);
  }
  
  public final void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("onUserVideoAvailable uid:" + paramString + " available:" + paramBoolean + ", isAnchor:" + this.dMz);
    e.d locald;
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      localObject3 = this.hAm;
      localObject1 = this.hAs;
      if (localObject1 != null)
      {
        localObject1 = ((LivePreviewView)localObject1).X(paramString, 0);
        ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject3).a(paramString, (TXCloudVideoView)localObject1);
        if ((!this.dMz) && (Util.isEqual(this.hAz.hzG, paramString)))
        {
          localObject1 = this.hAs;
          if (localObject1 != null) {
            ((LivePreviewView)localObject1).GE(paramString);
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("live_user_id", paramString);
        localObject3 = this.hAx;
        if (localObject3 != null)
        {
          locald = e.d.hxF;
          ((com.tencent.mm.live.core.core.c)localObject3).callback(e.d.aCo(), (Bundle)localObject1);
        }
      }
    }
    int i;
    for (;;)
    {
      if ((!this.dMz) && (!Util.isEqual(this.hAz.hzG, paramString))) {
        this.hAz.hzI = paramString;
      }
      if (this.dMz)
      {
        paramString = this.hAy;
        if (paramString == null) {
          break label344;
        }
        paramString = paramString.hwP;
        if (paramString == null) {
          break label344;
        }
        i = paramString.hzo;
        paramString = e.f.hxS;
        if (i != e.f.aCO()) {
          break label344;
        }
        this.hAm.aDU();
      }
      return;
      localObject1 = null;
      break;
      localObject1 = this.hAs;
      if (localObject1 != null) {
        ((LivePreviewView)localObject1).hER.GH(paramString);
      }
      this.hAm.Gv(paramString);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("live_user_id", paramString);
      localObject3 = this.hAx;
      if (localObject3 != null)
      {
        locald = e.d.hxF;
        ((com.tencent.mm.live.core.core.c)localObject3).callback(e.d.aCt(), (Bundle)localObject1);
      }
    }
    label344:
    paramString = this.hAy;
    if (paramString != null)
    {
      paramString = paramString.hwP;
      if (paramString != null)
      {
        i = paramString.hzo;
        paramString = e.f.hxS;
        if (i == e.f.aCP())
        {
          this.hAm.aDV();
          return;
        }
      }
    }
    localObject1 = new StringBuilder("invalid live scene: ");
    Object localObject3 = this.hAy;
    paramString = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((com.tencent.mm.live.core.core.b.f)localObject3).hwP;
      paramString = localObject2;
      if (localObject3 != null) {
        paramString = Integer.valueOf(((com.tencent.mm.live.core.core.b.e)localObject3).hzo);
      }
    }
    Log.w("MicroMsg.LiveCore", paramString);
  }
  
  public final void qs(int paramInt)
  {
    com.tencent.mm.live.core.b.d locald = this.hAr;
    locald.j((kotlin.g.a.a)new d.j(locald, paramInt));
  }
  
  public void release()
  {
    this.hAr.release();
    this.hAl.setListener(null);
    Object localObject = this.hAq;
    if (((com.tencent.mm.live.core.mini.b)localObject).hCN.isHeld()) {
      ((com.tencent.mm.live.core.mini.b)localObject).hCN.release();
    }
    localObject = b.hAP;
    localObject = b.aDB();
    if (localObject != null) {
      ((b)localObject).destroy();
    }
    localObject = b.aDB();
    if (localObject != null) {
      b.a((b)localObject, (Runnable)b.a.a.hAQ);
    }
    b.a(null);
  }
  
  public final void switchCamera()
  {
    try
    {
      Object localObject = this.hAt;
      com.tencent.mm.media.widget.a.d locald;
      if ((localObject != null) && (((com.tencent.mm.media.widget.a.d)localObject).aPc() == true))
      {
        localObject = this.hAt;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.d)localObject).aPb();
        }
        this.hAr.aEy();
        if (this.hAs != null)
        {
          localObject = this.hAt;
          if ((localObject != null) && (((com.tencent.mm.media.widget.a.d)localObject).aPc() == true))
          {
            localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            p.g(localObject, "ConfigHelper.getInstance()");
            localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDG();
            locald = this.hAt;
            if (locald == null) {
              break label139;
            }
          }
        }
      }
      label139:
      for (int i = locald.aPu();; i = 0)
      {
        ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject).hBp = i;
        localObject = this.hAt;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.media.widget.a.d)localObject).aPr();
          if (localObject != null)
          {
            this.hAu = ((com.tencent.mm.media.widget.a.b)localObject);
            this.hAr.a((com.tencent.mm.media.widget.a.b)localObject);
          }
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, "switch camera error:" + localException.getMessage(), new Object[0]);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.q<com.tencent.mm.live.core.b.l, Integer, Integer, x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<SurfaceTexture, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a
  {
    d(a parama, com.tencent.mm.live.core.b.l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "width", "", "height", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements m
  {
    e(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<SurfaceTexture, x>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke", "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$startPreviewToRemote$2$1"})
  public static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.g.d, x>
  {
    public g(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  public static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.q<com.tencent.mm.live.core.b.l, Integer, Integer, x>
  {
    public h(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a
 * JD-Core Version:    0.7.0.1
 */