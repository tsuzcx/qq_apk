package com.tencent.mm.live.core.core.trtc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.mm.live.core.core.b.d.a;
import com.tencent.mm.live.core.core.b.e.b;
import com.tencent.mm.live.core.core.b.e.c;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.core.mini.LiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/IMMLiveCore;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager$IView;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManagerListener;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager$IView;", "context", "Landroid/content/Context;", "isAnchor", "", "(Landroid/content/Context;Z)V", "blurFinalFrame", "Landroid/graphics/Bitmap;", "blurFrameRetrieveCallback", "Lkotlin/Function1;", "", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getCamera", "()Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "setCamera", "(Lcom/tencent/mm/media/widget/camera/ICommonCamera;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "enterRoomCallback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "getEnterRoomCallback", "()Lcom/tencent/mm/live/core/core/LiveCallback;", "setEnterRoomCallback", "(Lcom/tencent/mm/live/core/core/LiveCallback;)V", "exitRoomCallback", "getExitRoomCallback", "setExitRoomCallback", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "frameTexture", "Lcom/tencent/trtc/TRTCCloudDef$TRTCTexture;", "()Z", "setAnchor", "(Z)V", "isPushing", "setPushing", "liveCallback", "getLiveCallback", "setLiveCallback", "liveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "miniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getMiniManager", "()Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "setMiniManager", "(Lcom/tencent/mm/live/core/mini/LiveMiniManager;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "getPreviewView", "()Lcom/tencent/mm/live/core/view/LivePreviewView;", "setPreviewView", "(Lcom/tencent/mm/live/core/view/LivePreviewView;)V", "renderManager", "Lcom/tencent/mm/live/core/render/LiveRenderManager;", "getRenderManager", "()Lcom/tencent/mm/live/core/render/LiveRenderManager;", "setRenderManager", "(Lcom/tencent/mm/live/core/render/LiveRenderManager;)V", "trtcCloud", "Lcom/tencent/trtc/TRTCCloud;", "getTrtcCloud", "()Lcom/tencent/trtc/TRTCCloud;", "setTrtcCloud", "(Lcom/tencent/trtc/TRTCCloud;)V", "trtcManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "getTrtcManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "setTrtcManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;)V", "trtcRemoteUserManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "getTrtcRemoteUserManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "setTrtcRemoteUserManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "enterRoom", "callback", "exitRoom", "finishLastLive", "floatMode", "", "getFinalCameraFrame", "getLiveRoomModel", "getLiveStatus", "getRemoteUserViewById", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "", "steamType", "initCamera", "useCamera2", "frontCamera", "isInLinkMic", "isInLive", "liveId", "", "normalMode", "onAudioEffectFinished", "effectId", "code", "onAudioVolumeEvaluationChange", "enable", "onConnectOtherRoom", "userID", "err", "errMsg", "onDisConnectOtherRoom", "onEnterRoom", "result", "onError", "errCode", "extraInfo", "Landroid/os/Bundle;", "onExitRoom", "reason", "onFirstVideoFrame", "streamType", "width", "height", "onMuteLocalAudio", "isMute", "onMuteLocalVideo", "onNetworkQuality", "localQuality", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "remoteQuality", "Ljava/util/ArrayList;", "onRecvCustomCmdMsg", "cmdID", "seq", "message", "", "onRecvSEIMsg", "data", "onRemoteViewStatusUpdate", "onStatistics", "statics", "Lcom/tencent/trtc/TRTCStatistics;", "onUserAudioAvailable", "available", "onUserEnter", "onUserExit", "onUserSubStreamAvailable", "onUserVideoAvailable", "onUserVoiceVolume", "userVolumes", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "refreshCamera", "release", "setLiveStatusCallback", "setup", "startPreview", "startPreviewOnlyLocal", "surfaceHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "startPreviewToRemote", "stopPreview", "switchCamera", "updateLiveMiniState", "state", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "updatePrivateMapKey", "privateMapKey", "Companion", "plugin-core_release"})
public abstract class a
  implements com.tencent.mm.live.core.core.a, com.tencent.mm.live.core.core.trtc.a.b.c.a, com.tencent.mm.live.core.core.trtc.a.c.a, com.tencent.mm.live.core.core.trtc.a.d
{
  public static final a qEh = new a((byte)0);
  private boolean aWl;
  Context context;
  public final ap gAC;
  public com.tencent.mm.media.widget.a.e gAz;
  protected com.tencent.mm.live.core.core.trtc.a.b.c qDS;
  protected com.tencent.mm.live.core.core.trtc.a.c qDT;
  private final TRTCCloudDef.TRTCVideoFrame qDU;
  private final TRTCCloudDef.TRTCTexture qDV;
  protected com.tencent.mm.live.core.mini.a qDW;
  public com.tencent.mm.live.core.b.b qDX;
  protected LivePreviewView qDY;
  protected com.tencent.mm.live.core.core.b qDZ;
  public TRTCCloud qDj;
  protected com.tencent.mm.live.core.core.b qEa;
  protected com.tencent.mm.live.core.core.b qEb;
  public com.tencent.mm.live.core.core.b.d qEc;
  public com.tencent.mm.live.core.core.b.e qEd;
  private volatile Bitmap qEe;
  private d.g.a.b<? super Bitmap, y> qEf;
  protected boolean qEg;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    this.context = paramContext;
    this.aWl = paramBoolean;
    this.gAC = new ap(Looper.getMainLooper());
    paramContext = b.qEw;
    paramContext = this.context;
    k.h(paramContext, "var0");
    if (b.coT() == null) {
      b.a(new b(paramContext));
    }
    paramContext = b.coT();
    if (paramContext == null) {
      k.fvU();
    }
    this.qDj = ((TRTCCloud)paramContext);
    this.qDS = new com.tencent.mm.live.core.core.trtc.a.b.c(this.qDj, (com.tencent.mm.live.core.core.trtc.a.b.c.a)this);
    this.qDU = new TRTCCloudDef.TRTCVideoFrame();
    this.qDV = new TRTCCloudDef.TRTCTexture();
    this.qDW = new com.tencent.mm.live.core.mini.a();
    this.qDX = new com.tencent.mm.live.core.b.b();
    this.qEd = new com.tencent.mm.live.core.core.b.e();
    ad.i("MicroMsg.LiveCore", "live anchor use trtc,ver:" + TRTCCloud.getSDKVersion());
    paramContext = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("use trtc sdk,ver:" + TRTCCloud.getSDKVersion());
    TXLiveBase.setListener((ITXLiveBaseListener)1.qEj);
    if (this.qEd.isDebugMode)
    {
      TRTCCloud.setLogLevel(0);
      TRTCCloud.setConsoleEnabled(true);
      return;
    }
    TRTCCloud.setLogLevel(4);
  }
  
  public final int a(final com.tencent.mm.live.core.core.b.d paramd)
  {
    k.h(paramd, "model");
    ad.i("MicroMsg.LiveCore", "setup model:".concat(String.valueOf(paramd)));
    Object localObject = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("model:".concat(String.valueOf(paramd)));
    this.qEc = paramd;
    this.qEd.qAh = paramd.qzq.userId;
    localObject = this.qDW;
    String str = paramd.qzs.name;
    View.OnClickListener localOnClickListener = (View.OnClickListener)new b(this, paramd);
    k.h(str, "activityName");
    ((com.tencent.mm.live.core.mini.a)localObject).intent.setClass(aj.getContext(), Class.forName(str));
    ((com.tencent.mm.live.core.mini.a)localObject).intent.addFlags(268435456);
    ((com.tencent.mm.live.core.mini.a)localObject).qOR = str;
    ((com.tencent.mm.live.core.mini.a)localObject).qOQ.setMOnClickListener(localOnClickListener);
    this.qDT = new com.tencent.mm.live.core.core.trtc.a.c(this.qDj, paramd.qzq);
    localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).a((com.tencent.mm.live.core.core.trtc.a.c.a)this);
    }
    localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).a((com.tencent.mm.live.core.core.trtc.a.d)this);
    }
    localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).cpY();
    }
    this.qDS.aTX(paramd.qzq.userId);
    this.qEd.qzR = paramd.qzr.qzc;
    this.qDS.E(paramd.qzr.appId, paramd.qzr.qzd);
    ad.i("MicroMsg.LiveCore", "steve:setQCloudAccount qppid: %s, bizid: %s", new Object[] { Long.valueOf(paramd.qzr.appId), Long.valueOf(paramd.qzr.qzd) });
    return 0;
  }
  
  public final int a(LivePreviewView paramLivePreviewView)
  {
    if (paramLivePreviewView == null)
    {
      ad.e("MicroMsg.LiveCore", "startPreview preiewView is null");
      return -3;
    }
    Object localObject = this.gAz;
    if ((localObject != null) && (((com.tencent.mm.media.widget.a.e)localObject).amv() == true))
    {
      ad.e("MicroMsg.LiveCore", "camera is previewing");
      return 0;
    }
    localObject = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("startPreview ".concat(String.valueOf(paramLivePreviewView)));
    this.qDY = paramLivePreviewView;
    localObject = com.tencent.mm.live.core.core.b.d.qzw;
    boolean bool = com.tencent.mm.live.core.core.b.d.cnu().qyF;
    localObject = com.tencent.mm.live.core.core.b.d.qzw;
    aO(bool, com.tencent.mm.live.core.core.b.d.cnu().qyV);
    localObject = com.tencent.mm.live.core.core.b.d.qzw;
    if (com.tencent.mm.live.core.core.b.d.cnu().qyW)
    {
      localObject = this.gAz;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.a.e)localObject).a(this.qDX.getFrameDataCallback());
      }
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).cpP();
    k.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).kd(true);
    localObject = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).cpF();
    k.g(localObject, "ConfigHelper.getInstance().videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).kP(true);
    localObject = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).cpV();
    com.tencent.mm.media.widget.a.e locale = this.gAz;
    if (locale != null) {}
    for (int i = locale.amK();; i = 0)
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject).qGm = i;
      paramLivePreviewView.c((q)new c(this));
      this.qDX.m((d.g.a.b)new d(this));
      return 0;
    }
  }
  
  public void a(com.tencent.mm.live.core.core.b paramb)
  {
    k.h(paramb, "callback");
    int i;
    if (this.qEd.qzN == e.c.qCT)
    {
      i = 1;
      if (i == 0) {
        break label46;
      }
      ad.i("MicroMsg.LiveCore", "entering room or already room");
      this.qDZ = paramb;
    }
    label46:
    do
    {
      return;
      i = 0;
      break;
      Object localObject = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.aUc("start create room");
      com.tencent.mm.live.core.core.b.e locale = this.qEd;
      localObject = this.qEc;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.b.d)localObject).qzr;
        if (localObject == null) {}
      }
      for (localObject = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject).DlB); locale.h((Long)localObject); localObject = null)
      {
        localObject = com.tencent.mm.live.core.debug.a.qOL;
        com.tencent.mm.live.core.debug.a.aUc("enter room and already in room");
        b.a.a(paramb, 0);
        return;
      }
      this.qDZ = paramb;
      paramb = this.qEd;
      localObject = e.c.qCT;
      k.h(localObject, "status");
      paramb.qzN = ((e.c)localObject);
      paramb = this.qDT;
    } while (paramb == null);
    paramb.cqb();
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
        paramTRTCQuality = c.c.qyj;
        i = c.c.cmA();
      }
    }
    for (;;)
    {
      if (this.qEd.zCj != i)
      {
        this.qEd.zCj = i;
        ad.i("MicroMsg.LiveCore", "onNetworkQuality, local:".concat(String.valueOf(i)));
      }
      paramTRTCQuality = this.qEb;
      if (paramTRTCQuality != null)
      {
        c.b localb = c.b.qye;
        b.a.a(paramTRTCQuality, c.b.cmb());
      }
      return;
      paramTRTCQuality = c.c.qyj;
      j = c.c.cmA();
      break;
      label96:
      if (j <= 4)
      {
        paramTRTCQuality = c.c.qyj;
        i = c.c.cmG();
      }
      else if (j < 6)
      {
        paramTRTCQuality = c.c.qyj;
        i = c.c.cnl();
      }
      else
      {
        paramTRTCQuality = c.c.qyj;
        i = c.c.cnp();
      }
    }
  }
  
  public final int aO(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    com.tencent.mm.media.widget.a.e locale;
    Context localContext;
    if (paramBoolean1)
    {
      locale = (com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.b.e(this.context);
      this.gAz = locale;
      locale = this.gAz;
      if (locale != null) {
        locale.fQG();
      }
      locale = this.gAz;
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
      if (locale.q(localContext, paramBoolean1) != true)
      {
        ad.e("MicroMsg.LiveCoreError", "[-1] live anchor open camera error");
        i = -1;
      }
      return i;
      locale = (com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.a.d(this.context);
      break;
    }
  }
  
  public final void aTU(String paramString)
  {
    k.h(paramString, "state");
    com.tencent.mm.live.core.mini.a.aUf(paramString);
  }
  
  public final void aTV(String paramString)
  {
    k.h(paramString, "privateMapKey");
    if (!bt.isNullOrNil(paramString))
    {
      i locali = new i();
      locali.j("privateMapKey", paramString);
      paramString = new i();
      paramString.j("api", "updatePrivateMapKey");
      paramString.j("params", locali);
      ad.i("MicroMsg.LiveCore", "updatePrivateMapKey:" + paramString + ' ');
      this.qDj.callExperimentalAPI(paramString.toString());
    }
  }
  
  public final void an(float paramFloat1, float paramFloat2)
  {
    if (this.aWl) {
      this.qDS.ao(paramFloat1, paramFloat2);
    }
  }
  
  public final void b(com.tencent.mm.live.core.core.b paramb)
  {
    k.h(paramb, "callback");
    Object localObject = com.tencent.mm.live.core.mini.b.qPc;
    com.tencent.mm.live.core.core.b.e locale = this.qEd;
    localObject = this.qEc;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.d)localObject).qzr;
      if (localObject == null) {}
    }
    for (localObject = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject).DlB); !locale.h((Long)localObject); localObject = null)
    {
      localObject = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.aUc("already exit room");
      b.a.a(paramb, 0);
      return;
    }
    clf();
    this.qEa = paramb;
    paramb = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("start exit room");
    paramb = this.qDT;
    if (paramb != null) {
      paramb.exitRoom();
    }
    paramb = this.qEd;
    paramb.qzN = e.c.qBA;
    paramb.qzQ = -1L;
  }
  
  public final void c(com.tencent.mm.live.core.core.b paramb)
  {
    k.h(paramb, "callback");
    this.qEb = paramb;
  }
  
  public final int clf()
  {
    try
    {
      ad.i("MicroMsg.LiveCore", "release");
      this.qDX.j((d.g.a.a)new i(this));
      return 0;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, "camera release error:" + localException.getMessage(), new Object[0]);
    }
    return 0;
  }
  
  public final void clg()
  {
    Object localObject1 = this.gAz;
    Object localObject2;
    com.tencent.mm.media.widget.a.e locale;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.a.e)localObject1).amG();
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.a.a.cpE();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).cpV();
        locale = this.gAz;
        if (locale == null) {
          break label69;
        }
      }
    }
    label69:
    for (int i = locale.amK();; i = 0)
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject2).qGm = i;
      this.qDX.a((com.tencent.mm.media.widget.a.b)localObject1);
      return;
    }
  }
  
  public void clo()
  {
    this.qEd.qzP = false;
    this.qDW.csy();
  }
  
  public final com.tencent.mm.live.core.core.b.e clu()
  {
    return this.qEd;
  }
  
  public final void cnS()
  {
    if ((this.context instanceof Activity))
    {
      this.qEd.qzP = false;
      this.qEd.qzO = e.b.qAR;
      Context localContext = this.context;
      if (localContext == null) {
        throw new v("null cannot be cast to non-null type android.app.Activity");
      }
      ((Activity)localContext).finishAndRemoveTask();
      this.qDW.csy();
      return;
    }
    ad.w("MicroMsg.LiveCore", "finishLastLive err: context:" + this.context);
  }
  
  public boolean col()
  {
    return false;
  }
  
  public int eE(Context paramContext)
  {
    k.h(paramContext, "context");
    Object localObject1 = paramContext.getResources();
    k.g(localObject1, "context.resources");
    int i;
    if (((Resources)localObject1).getConfiguration().orientation == 1) {
      i = com.tencent.mm.cd.a.hV(paramContext) / 4;
    }
    for (localObject1 = new Point(i, (int)(com.tencent.mm.cd.a.hW(paramContext) / com.tencent.mm.cd.a.hV(paramContext) * i));; localObject1 = new Point((int)(com.tencent.mm.cd.a.hV(paramContext) / com.tencent.mm.cd.a.hW(paramContext) * i), i))
    {
      this.qDX.cR(((Point)localObject1).x, ((Point)localObject1).y);
      ad.i("MicroMsg.LiveCore", "floatMode context:" + paramContext + ", this.context:" + this.context);
      boolean bool1 = ((Activity)paramContext).isTaskRoot();
      boolean bool2 = ((Activity)paramContext).moveTaskToBack(true);
      ad.i("MicroMsg.LiveCore", "floatMode moveTaskToBack ret:" + bool2 + ", isTaskRoot:" + bool1);
      this.context = paramContext;
      paramContext = this.qDW;
      k.h(localObject1, "size");
      if (paramContext.qOQ.getParent() == null) {
        break;
      }
      ad.i("MicroMsg.LiveCoreMini", "addViewToWindow fail.miniLayout already in window");
      this.qEd.qzP = true;
      return 0;
      i = com.tencent.mm.cd.a.hW(paramContext) / 4;
    }
    Object localObject2 = aj.getContext().getSystemService("window");
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject2 = (WindowManager)localObject2;
    Object localObject3 = new WindowManager.LayoutParams();
    if (com.tencent.mm.compatible.util.d.lf(26)) {}
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
        localObject1 = g.afB();
        k.g(localObject1, "MMKernel.storage()");
        i = ((com.tencent.mm.kernel.e)localObject1).afk().getInt(327947, 0);
        int j = BackwardSupportUtil.b.g(localContext, 5.0F);
        ((WindowManager.LayoutParams)localObject3).x = (localDisplayMetrics.widthPixels - ((WindowManager.LayoutParams)localObject3).width - j);
        ((WindowManager.LayoutParams)localObject3).y = (i + j);
        try
        {
          ((WindowManager)localObject2).addView((View)paramContext.qOQ, (ViewGroup.LayoutParams)localObject3);
          localObject1 = com.tencent.mm.live.core.mini.b.qPc;
          localObject1 = com.tencent.mm.cd.a.aq(aj.getContext(), 2131766616);
          k.g(localObject1, "ResourceHelper.getString…g.live_notification_tip1)");
          localObject2 = com.tencent.mm.cd.a.aq(aj.getContext(), 2131766617);
          k.g(localObject2, "ResourceHelper.getString…g.live_notification_tip2)");
          localObject3 = com.tencent.mm.cd.a.aq(aj.getContext(), 2131766616);
          k.g(localObject3, "ResourceHelper.getString…g.live_notification_tip1)");
          com.tencent.mm.live.core.mini.b.A((String)localObject1, (String)localObject2, (String)localObject3, paramContext.qOR);
        }
        catch (Exception paramContext)
        {
          ad.e("MicroMsg.LiveCoreMini", "addViewToWindowManager failed: %s", new Object[] { paramContext.getMessage() });
        }
      }
      break;
    }
  }
  
  public final TXCloudVideoView gN(String paramString, int paramInt)
  {
    LivePreviewView localLivePreviewView = this.qDY;
    if (localLivePreviewView != null) {
      return localLivePreviewView.gO(paramString, paramInt);
    }
    return null;
  }
  
  public final void hB(boolean paramBoolean)
  {
    ad.i("MicroMsg.LiveCore", "onAudioVolumeEvaluationChange:".concat(String.valueOf(paramBoolean)));
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
    Object localObject1 = com.tencent.mm.live.core.debug.a.qOL;
    localObject1 = new StringBuilder("create room ret:").append(paramLong).append('(');
    Object localObject2 = com.tencent.mm.live.core.a.a.qOM;
    com.tencent.mm.live.core.debug.a.aUc(com.tencent.mm.live.core.a.a.CE((int)paramLong) + ')');
    localObject1 = this.qDZ;
    if (localObject1 != null) {
      b.a.a((com.tencent.mm.live.core.core.b)localObject1, (int)paramLong);
    }
    this.qDZ = null;
    localObject1 = this.qEd;
    localObject2 = this.qEc;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).qzr;
      if (localObject2 == null) {}
    }
    for (paramLong = ((com.tencent.mm.live.core.core.b.c)localObject2).DlB;; paramLong = -1L)
    {
      ((com.tencent.mm.live.core.core.b.e)localObject1).qzN = e.c.qCR;
      ((com.tencent.mm.live.core.core.b.e)localObject1).qzQ = paramLong;
      return;
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    paramBundle = new Bundle();
    paramBundle.putInt("live_err_code", paramInt);
    com.tencent.mm.live.core.core.b localb = this.qEb;
    if (localb != null)
    {
      c.b localb1 = c.b.qye;
      localb.B(c.b.cml(), paramBundle);
    }
    paramBundle = com.tencent.mm.live.core.debug.a.qOL;
    paramString = new StringBuilder("[").append(paramInt).append("]msg:").append(paramString).append('(');
    paramBundle = com.tencent.mm.live.core.a.a.qOM;
    com.tencent.mm.live.core.debug.a.aUc(com.tencent.mm.live.core.a.a.CE(paramInt) + ')');
  }
  
  public final void onExitRoom(int paramInt)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.qOL;
    localObject1 = new StringBuilder("[").append(paramInt).append("]end exit room.(");
    Object localObject2 = com.tencent.mm.live.core.a.a.qOM;
    com.tencent.mm.live.core.debug.a.aUc(com.tencent.mm.live.core.a.a.CE(paramInt) + ')');
    localObject1 = this.qEa;
    if (localObject1 != null) {
      b.a.a((com.tencent.mm.live.core.core.b)localObject1, paramInt);
    }
    if (paramInt != 0)
    {
      localObject1 = this.qEb;
      if (localObject1 != null)
      {
        localObject2 = c.b.qye;
        b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.cmw());
      }
    }
    this.qEa = null;
  }
  
  public final void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("[sdk]onFirstVideoFrame uid:" + paramString + " ,streamType:" + paramInt1 + " width:" + paramInt2 + " height:" + paramInt3);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_first_frame_width", paramInt2);
    ((Bundle)localObject).putInt("live_first_frame_height", paramInt3);
    paramString = this.qEb;
    if (paramString != null)
    {
      c.b localb = c.b.qye;
      paramString.B(c.b.cmy(), (Bundle)localObject);
    }
  }
  
  public final void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "[sdk]onUserAudioAvailable:" + paramString + ", available:" + paramBoolean + ", isAnchor:" + this.aWl);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putBoolean("live_media_enable", paramBoolean);
    com.tencent.mm.live.core.core.b localb = this.qEb;
    if (localb != null)
    {
      c.b localb1 = c.b.qye;
      localb.B(c.b.clS(), (Bundle)localObject);
    }
    if (paramBoolean) {
      TextUtils.isEmpty((CharSequence)paramString);
    }
    com.tencent.mm.live.core.core.trtc.a.b.c.aUa(paramString);
    if (this.aWl) {
      this.qDS.crD();
    }
  }
  
  public void onUserExit(String paramString, int paramInt)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("[sdk]onUserExit:" + paramString + " reason:" + paramInt);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_user_exit_reason", paramInt);
    paramString = this.qEb;
    if (paramString != null)
    {
      c.b localb = c.b.qye;
      paramString.B(c.b.clR(), (Bundle)localObject);
    }
  }
  
  public final void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("onUserSubStreamAvailable:" + paramString + ", available:" + paramBoolean);
  }
  
  public final void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("onUserVideoAvailable uid:" + paramString + " available:" + paramBoolean + ", isAnchor:" + this.aWl);
    Object localObject2;
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      localObject2 = this.qDS;
      localObject1 = this.qDY;
      if (localObject1 != null)
      {
        localObject1 = ((LivePreviewView)localObject1).gO(paramString, 0);
        ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject2).a(paramString, (TXCloudVideoView)localObject1);
        localObject1 = this.qEb;
        if (localObject1 != null)
        {
          localObject2 = c.b.qye;
          b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.clQ());
        }
        if ((!this.aWl) && (bt.kU(this.qEd.qzR, paramString)))
        {
          localObject1 = this.qDY;
          if (localObject1 != null)
          {
            int i = ((LivePreviewView)localObject1).qUv.aUi(paramString);
            ((LivePreviewView)localObject1).qUv.aaq(i);
          }
        }
      }
    }
    for (;;)
    {
      if ((!this.aWl) && (!bt.kU(this.qEd.qzR, paramString))) {
        this.qEd.qAd = paramString;
      }
      if (this.aWl) {
        this.qDS.crD();
      }
      return;
      localObject1 = null;
      break;
      localObject1 = this.qDY;
      if (localObject1 != null) {
        ((LivePreviewView)localObject1).qUv.aUh(paramString);
      }
      this.qDS.aTZ(paramString);
      localObject1 = this.qEb;
      if (localObject1 != null)
      {
        localObject2 = c.b.qye;
        b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.cmv());
      }
    }
  }
  
  public void release()
  {
    this.qDX.release();
    this.qDj.setListener(null);
    Object localObject = this.qDW;
    if (((com.tencent.mm.live.core.mini.a)localObject).zqF.isHeld()) {
      ((com.tencent.mm.live.core.mini.a)localObject).zqF.release();
    }
    localObject = b.qEw;
    localObject = b.coT();
    if (localObject != null) {
      ((b)localObject).destroy();
    }
    b.a(null);
  }
  
  public final void switchCamera()
  {
    try
    {
      Object localObject = this.gAz;
      com.tencent.mm.media.widget.a.e locale;
      if ((localObject != null) && (((com.tencent.mm.media.widget.a.e)localObject).amv() == true))
      {
        localObject = this.gAz;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.e)localObject).amu();
        }
        this.qDX.anT();
        if (this.qDY != null)
        {
          localObject = this.gAz;
          if ((localObject != null) && (((com.tencent.mm.media.widget.a.e)localObject).amv() == true))
          {
            localObject = com.tencent.mm.live.core.core.trtc.a.a.cpE();
            k.g(localObject, "ConfigHelper.getInstance()");
            localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).cpV();
            locale = this.gAz;
            if (locale == null) {
              break label134;
            }
          }
        }
      }
      label134:
      for (int i = locale.amK();; i = 0)
      {
        ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject).qGm = i;
        localObject = this.gAz;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.media.widget.a.e)localObject).amG();
          if (localObject != null) {
            this.qDX.a((com.tencent.mm.media.widget.a.b)localObject);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, com.tencent.mm.live.core.core.b.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205644);
      this.qEk.clo();
      Object localObject = new Intent(this.qEk.context, Class.forName(paramd.qzs.name));
      ((Intent)localObject).putExtra("route_to_maximize", true);
      ((Intent)localObject).addFlags(268435456);
      paramView = aj.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(205644);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class c
    extends d.g.b.l
    implements q<j, Integer, Integer, y>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<SurfaceTexture, y>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "width", "", "height", "invoke"})
  public static final class e
    extends d.g.b.l
    implements m
  {
    public e(a parama, j paramj)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  public static final class f
    extends d.g.b.l
    implements d.g.a.b<SurfaceTexture, y>
  {
    public f(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke", "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$startPreviewToRemote$2$1"})
  public static final class g
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.f.d, y>
  {
    public g(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  public static final class h
    extends d.g.b.l
    implements q<j, Integer, Integer, y>
  {
    public h(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a
 * JD-Core Version:    0.7.0.1
 */