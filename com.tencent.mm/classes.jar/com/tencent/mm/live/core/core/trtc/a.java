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
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/IMMLiveCore;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager$IView;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManagerListener;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager$IView;", "context", "Landroid/content/Context;", "isAnchor", "", "(Landroid/content/Context;Z)V", "blurFinalFrame", "Landroid/graphics/Bitmap;", "blurFrameRetrieveCallback", "Lkotlin/Function1;", "", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getCamera", "()Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "setCamera", "(Lcom/tencent/mm/media/widget/camera/ICommonCamera;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "enterRoomCallback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "getEnterRoomCallback", "()Lcom/tencent/mm/live/core/core/LiveCallback;", "setEnterRoomCallback", "(Lcom/tencent/mm/live/core/core/LiveCallback;)V", "exitRoomCallback", "getExitRoomCallback", "setExitRoomCallback", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "frameTexture", "Lcom/tencent/trtc/TRTCCloudDef$TRTCTexture;", "()Z", "setAnchor", "(Z)V", "isPushing", "setPushing", "liveCallback", "getLiveCallback", "setLiveCallback", "liveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "miniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getMiniManager", "()Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "setMiniManager", "(Lcom/tencent/mm/live/core/mini/LiveMiniManager;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "getPreviewView", "()Lcom/tencent/mm/live/core/view/LivePreviewView;", "setPreviewView", "(Lcom/tencent/mm/live/core/view/LivePreviewView;)V", "renderManager", "Lcom/tencent/mm/live/core/render/LiveRenderManager;", "getRenderManager", "()Lcom/tencent/mm/live/core/render/LiveRenderManager;", "setRenderManager", "(Lcom/tencent/mm/live/core/render/LiveRenderManager;)V", "trtcCloud", "Lcom/tencent/trtc/TRTCCloud;", "getTrtcCloud", "()Lcom/tencent/trtc/TRTCCloud;", "setTrtcCloud", "(Lcom/tencent/trtc/TRTCCloud;)V", "trtcManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "getTrtcManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "setTrtcManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;)V", "trtcRemoteUserManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "getTrtcRemoteUserManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "setTrtcRemoteUserManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "enterRoom", "callback", "exitRoom", "finishLastLive", "floatMode", "", "getFinalCameraFrame", "getLiveRoomModel", "getLiveStatus", "getRemoteUserViewById", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "", "steamType", "initCamera", "useCamera2", "frontCamera", "isInLinkMic", "isInLive", "liveId", "", "normalMode", "onAudioEffectFinished", "effectId", "code", "onAudioVolumeEvaluationChange", "enable", "onConnectOtherRoom", "userID", "err", "errMsg", "onDisConnectOtherRoom", "onEnterRoom", "result", "onError", "errCode", "extraInfo", "Landroid/os/Bundle;", "onExitRoom", "reason", "onFirstVideoFrame", "streamType", "width", "height", "onMuteLocalAudio", "isMute", "onMuteLocalVideo", "onNetworkQuality", "localQuality", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "remoteQuality", "Ljava/util/ArrayList;", "onRecvCustomCmdMsg", "cmdID", "seq", "message", "", "onRecvSEIMsg", "data", "onRemoteUserEnterRoom", "onRemoteUserLeaveRoom", "onRemoteViewStatusUpdate", "onStatistics", "statics", "Lcom/tencent/trtc/TRTCStatistics;", "onUserAudioAvailable", "available", "onUserSubStreamAvailable", "onUserVideoAvailable", "onUserVoiceVolume", "userVolumes", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "refreshCamera", "release", "removeMiniWindow", "setLiveStatusCallback", "setup", "startPreview", "startPreviewOnlyLocal", "surfaceHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "startPreviewToRemote", "stopPreview", "switchCamera", "updateLiveMiniState", "state", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "updatePrivateMapKey", "privateMapKey", "Companion", "plugin-core_release"})
public abstract class a
  implements com.tencent.mm.live.core.core.a, com.tencent.mm.live.core.core.trtc.a.b.c.a, com.tencent.mm.live.core.core.trtc.a.c.a, com.tencent.mm.live.core.core.trtc.a.d
{
  public static final a.a goN = new a.a((byte)0);
  Context context;
  private boolean dmG;
  protected com.tencent.mm.live.core.core.trtc.a.c goA;
  private final TRTCCloudDef.TRTCVideoFrame goB;
  private final TRTCCloudDef.TRTCTexture goC;
  protected com.tencent.mm.live.core.mini.a goD;
  public com.tencent.mm.live.core.b.b goE;
  protected LivePreviewView goF;
  public com.tencent.mm.media.widget.a.e goG;
  protected com.tencent.mm.live.core.core.b goH;
  protected com.tencent.mm.live.core.core.b goI;
  private com.tencent.mm.live.core.core.b goJ;
  public com.tencent.mm.live.core.core.b.d goK;
  public com.tencent.mm.live.core.core.b.e goL;
  protected boolean goM;
  public final ao gox;
  public TRTCCloud goy;
  protected com.tencent.mm.live.core.core.trtc.a.b.c goz;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    this.context = paramContext;
    this.dmG = paramBoolean;
    this.gox = new ao(Looper.getMainLooper());
    paramContext = b.gpb;
    paramContext = this.context;
    k.h(paramContext, "var0");
    if (b.aiW() == null) {
      b.a(new b(paramContext));
    }
    paramContext = b.aiW();
    if (paramContext == null) {
      k.fOy();
    }
    this.goy = ((TRTCCloud)paramContext);
    this.goz = new com.tencent.mm.live.core.core.trtc.a.b.c(this.goy, (com.tencent.mm.live.core.core.trtc.a.b.c.a)this);
    this.goB = new TRTCCloudDef.TRTCVideoFrame();
    this.goC = new TRTCCloudDef.TRTCTexture();
    this.goD = new com.tencent.mm.live.core.mini.a();
    this.goE = new com.tencent.mm.live.core.b.b();
    this.goL = new com.tencent.mm.live.core.core.b.e();
    ac.i("MicroMsg.LiveCore", "live anchor use trtc,ver:" + TRTCCloud.getSDKVersion());
    paramContext = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("use trtc sdk,ver:" + TRTCCloud.getSDKVersion());
    TXLiveBase.setListener((ITXLiveBaseListener)a.1.goO);
    if (this.goL.isDebugMode)
    {
      TRTCCloud.setLogLevel(0);
      TRTCCloud.setConsoleEnabled(true);
      return;
    }
    TRTCCloud.setLogLevel(4);
  }
  
  public final TXCloudVideoView Q(String paramString, int paramInt)
  {
    LivePreviewView localLivePreviewView = this.goF;
    if (localLivePreviewView != null) {
      return localLivePreviewView.R(paramString, paramInt);
    }
    return null;
  }
  
  public final int a(com.tencent.mm.live.core.core.b.d paramd)
  {
    k.h(paramd, "model");
    ac.i("MicroMsg.LiveCore", "setup model:".concat(String.valueOf(paramd)));
    Object localObject = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("model:".concat(String.valueOf(paramd)));
    this.goK = paramd;
    localObject = this.goE;
    k.h(paramd, "model");
    ((com.tencent.mm.live.core.b.b)localObject).goK = paramd;
    this.goL.gog = paramd.gnT.userId;
    localObject = this.goD;
    String str = paramd.gnV.name;
    View.OnClickListener localOnClickListener = (View.OnClickListener)new a.b(this, paramd);
    k.h(str, "activityName");
    ((com.tencent.mm.live.core.mini.a)localObject).intent.setClass(ai.getContext(), Class.forName(str));
    ((com.tencent.mm.live.core.mini.a)localObject).intent.addFlags(268435456);
    ((com.tencent.mm.live.core.mini.a)localObject).gqK = str;
    ((com.tencent.mm.live.core.mini.a)localObject).gqJ.setMOnClickListener(localOnClickListener);
    this.goA = new com.tencent.mm.live.core.core.trtc.a.c(this.goy, paramd.gnT);
    localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).a((com.tencent.mm.live.core.core.trtc.a.c.a)this);
    }
    localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).a((com.tencent.mm.live.core.core.trtc.a.d)this);
    }
    localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).ajd();
    }
    this.goz.uy(paramd.gnT.userId);
    this.goL.goe = paramd.gnU.gnQ;
    this.goz.v(paramd.gnU.appId, paramd.gnU.gnR);
    ac.i("MicroMsg.LiveCore", "steve:setQCloudAccount qppid: %s, bizid: %s", new Object[] { Long.valueOf(paramd.gnU.appId), Long.valueOf(paramd.gnU.gnR) });
    return 0;
  }
  
  public final int a(LivePreviewView paramLivePreviewView)
  {
    if (paramLivePreviewView == null)
    {
      ac.e("MicroMsg.LiveCore", "startPreview preiewView is null");
      return -3;
    }
    Object localObject = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("startPreview ".concat(String.valueOf(paramLivePreviewView)));
    this.goF = paramLivePreviewView;
    localObject = this.goK;
    boolean bool1;
    boolean bool2;
    label98:
    com.tencent.mm.media.widget.a.e locale;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gnS;
      if (localObject != null)
      {
        bool1 = ((com.tencent.mm.live.core.core.b.b)localObject).gnK;
        localObject = this.goK;
        if (localObject == null) {
          break label316;
        }
        localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gnS;
        if (localObject == null) {
          break label316;
        }
        bool2 = ((com.tencent.mm.live.core.core.b.b)localObject).gnL;
        k(bool1, bool2);
        localObject = this.goK;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gnS;
          if ((localObject != null) && (((com.tencent.mm.live.core.core.b.b)localObject).gnM == true))
          {
            localObject = this.goG;
            if (localObject != null) {
              ((com.tencent.mm.media.widget.a.e)localObject).a(this.goE.getFrameDataCallback());
            }
          }
        }
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aiX();
        k.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aiZ();
        k.g(localObject, "ConfigHelper.getInstance().audioConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dE(true);
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aiX();
        k.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aiY();
        k.g(localObject, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dH(true);
        localObject = com.tencent.mm.live.core.core.trtc.a.a.aiX();
        k.g(localObject, "ConfigHelper.getInstance()");
        localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).ajb();
        locale = this.goG;
        if (locale == null) {
          break label322;
        }
      }
    }
    label316:
    label322:
    for (int i = locale.atC();; i = 0)
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject).gpy = i;
      paramLivePreviewView.a((q)new c(this));
      this.goE.c((d.g.a.b)new d(this));
      return 0;
      bool1 = false;
      break;
      bool2 = true;
      break label98;
    }
  }
  
  public void a(com.tencent.mm.live.core.core.b paramb)
  {
    k.h(paramb, "callback");
    int i;
    if (this.goL.goa == e.c.gor)
    {
      i = 1;
      if (i == 0) {
        break label46;
      }
      ac.i("MicroMsg.LiveCore", "entering room or already room");
      this.goH = paramb;
    }
    label46:
    do
    {
      return;
      i = 0;
      break;
      Object localObject = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.uG("start create room");
      com.tencent.mm.live.core.core.b.e locale = this.goL;
      localObject = this.goK;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gnU;
        if (localObject == null) {}
      }
      for (localObject = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject).gmP); locale.b((Long)localObject); localObject = null)
      {
        localObject = com.tencent.mm.live.core.debug.a.gqF;
        com.tencent.mm.live.core.debug.a.uG("enter room and already in room");
        b.a.a(paramb, 0);
        return;
      }
      this.goH = paramb;
      paramb = this.goL;
      localObject = e.c.gor;
      k.h(localObject, "status");
      paramb.goa = ((e.c)localObject);
      paramb = this.goA;
    } while (paramb == null);
    paramb.aje();
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
        paramTRTCQuality = c.c.gnz;
        i = c.c.aiI();
      }
    }
    for (;;)
    {
      if (this.goL.goi != i)
      {
        this.goL.goi = i;
        ac.i("MicroMsg.LiveCore", "onNetworkQuality, local:".concat(String.valueOf(i)));
      }
      paramTRTCQuality = this.goJ;
      if (paramTRTCQuality != null)
      {
        c.b localb = c.b.gnu;
        b.a.a(paramTRTCQuality, c.b.aiD());
      }
      return;
      paramTRTCQuality = c.c.gnz;
      j = c.c.aiI();
      break;
      label96:
      if (j <= 4)
      {
        paramTRTCQuality = c.c.gnz;
        i = c.c.aiJ();
      }
      else if (j < 6)
      {
        paramTRTCQuality = c.c.gnz;
        i = c.c.aiK();
      }
      else
      {
        paramTRTCQuality = c.c.gnz;
        i = c.c.aiL();
      }
    }
  }
  
  public boolean aiU()
  {
    return false;
  }
  
  public final int aiq()
  {
    try
    {
      ac.i("MicroMsg.LiveCore", "release");
      this.goE.h((d.g.a.a)new i(this));
      return 0;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, "camera release error:" + localException.getMessage(), new Object[0]);
    }
    return 0;
  }
  
  public final void air()
  {
    Object localObject1 = this.goG;
    Object localObject2;
    com.tencent.mm.media.widget.a.e locale;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.a.e)localObject1).aty();
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.a.a.aiX();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).ajb();
        locale = this.goG;
        if (locale == null) {
          break label69;
        }
      }
    }
    label69:
    for (int i = locale.atC();; i = 0)
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject2).gpy = i;
      this.goE.a((com.tencent.mm.media.widget.a.b)localObject1);
      return;
    }
  }
  
  public void ais()
  {
    this.goL.goc = e.d.got;
    this.goD.ajx();
  }
  
  public final com.tencent.mm.live.core.core.b.e ait()
  {
    return this.goL;
  }
  
  public final void aiu()
  {
    if ((this.context instanceof Activity))
    {
      this.goL.goc = e.d.got;
      this.goL.gob = e.b.gok;
      aiq();
      aiw();
      Context localContext = this.context;
      if (localContext == null) {
        throw new v("null cannot be cast to non-null type android.app.Activity");
      }
      ((Activity)localContext).finishAndRemoveTask();
      this.goD.ajx();
      return;
    }
    ac.w("MicroMsg.LiveCore", "finishLastLive err: context:" + this.context);
  }
  
  public final void aiv()
  {
    this.goL.goc = e.d.got;
    this.goD.ajx();
  }
  
  public final void b(com.tencent.mm.live.core.core.b paramb)
  {
    k.h(paramb, "callback");
    Object localObject = com.tencent.mm.live.core.mini.b.gqM;
    com.tencent.mm.live.core.core.b.e locale = this.goL;
    localObject = this.goK;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gnU;
      if (localObject == null) {}
    }
    for (localObject = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject).gmP); !locale.b((Long)localObject); localObject = null)
    {
      localObject = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.uG("already exit room");
      b.a.a(paramb, 0);
      return;
    }
    aiq();
    this.goI = paramb;
    paramb = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("start exit room");
    paramb = this.goA;
    if (paramb != null) {
      paramb.exitRoom();
    }
    paramb = this.goL;
    paramb.goa = e.c.goo;
    paramb.god = -1L;
  }
  
  public final void c(com.tencent.mm.live.core.core.b paramb)
  {
    k.h(paramb, "callback");
    this.goJ = paramb;
  }
  
  public int cs(Context paramContext)
  {
    k.h(paramContext, "context");
    Object localObject1 = paramContext.getResources();
    k.g(localObject1, "context.resources");
    int i;
    if (((Resources)localObject1).getConfiguration().orientation == 1) {
      i = com.tencent.mm.cc.a.ig(paramContext) / 4;
    }
    for (localObject1 = new Point(i, (int)(com.tencent.mm.cc.a.ih(paramContext) / com.tencent.mm.cc.a.ig(paramContext) * i));; localObject1 = new Point((int)(com.tencent.mm.cc.a.ig(paramContext) / com.tencent.mm.cc.a.ih(paramContext) * i), i))
    {
      this.goE.cQ(((Point)localObject1).x, ((Point)localObject1).y);
      ac.i("MicroMsg.LiveCore", "floatMode context:" + paramContext + ", this.context:" + this.context);
      boolean bool1 = ((Activity)paramContext).isTaskRoot();
      boolean bool2 = ((Activity)paramContext).moveTaskToBack(true);
      ac.i("MicroMsg.LiveCore", "floatMode moveTaskToBack ret:" + bool2 + ", isTaskRoot:" + bool1);
      this.context = paramContext;
      paramContext = this.goD;
      k.h(localObject1, "size");
      if (paramContext.gqJ.getParent() == null) {
        break;
      }
      ac.i("MicroMsg.LiveCoreMini", "addViewToWindow fail.miniLayout already in window");
      this.goL.goc = e.d.gou;
      return 0;
      i = com.tencent.mm.cc.a.ih(paramContext) / 4;
    }
    Object localObject2 = ai.getContext().getSystemService("window");
    if (localObject2 == null) {
      throw new v("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject2 = (WindowManager)localObject2;
    Object localObject3 = new WindowManager.LayoutParams();
    if (com.tencent.mm.compatible.util.d.kZ(26)) {}
    for (((WindowManager.LayoutParams)localObject3).type = 2038;; ((WindowManager.LayoutParams)localObject3).type = 2002)
    {
      for (;;)
      {
        ((WindowManager.LayoutParams)localObject3).format = 1;
        ((WindowManager.LayoutParams)localObject3).flags = 40;
        ((WindowManager.LayoutParams)localObject3).gravity = 51;
        Context localContext = ai.getContext();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)localObject2).getDefaultDisplay().getMetrics(localDisplayMetrics);
        ((WindowManager.LayoutParams)localObject3).width = ((Point)localObject1).x;
        ((WindowManager.LayoutParams)localObject3).height = ((Point)localObject1).y;
        localObject1 = g.agR();
        k.g(localObject1, "MMKernel.storage()");
        i = ((com.tencent.mm.kernel.e)localObject1).agA().getInt(327947, 0);
        int j = BackwardSupportUtil.b.g(localContext, 5.0F);
        ((WindowManager.LayoutParams)localObject3).x = (localDisplayMetrics.widthPixels - ((WindowManager.LayoutParams)localObject3).width - j);
        ((WindowManager.LayoutParams)localObject3).y = (i + j);
        try
        {
          ((WindowManager)localObject2).addView((View)paramContext.gqJ, (ViewGroup.LayoutParams)localObject3);
          localObject1 = com.tencent.mm.live.core.mini.b.gqM;
          localObject1 = com.tencent.mm.cc.a.aw(ai.getContext(), 2131766650);
          k.g(localObject1, "ResourceHelper.getString…g.live_notification_tip1)");
          localObject2 = com.tencent.mm.cc.a.aw(ai.getContext(), 2131766651);
          k.g(localObject2, "ResourceHelper.getString…g.live_notification_tip2)");
          localObject3 = com.tencent.mm.cc.a.aw(ai.getContext(), 2131766650);
          k.g(localObject3, "ResourceHelper.getString…g.live_notification_tip1)");
          com.tencent.mm.live.core.mini.b.d((String)localObject1, (String)localObject2, (String)localObject3, paramContext.gqK);
        }
        catch (Exception paramContext)
        {
          ac.e("MicroMsg.LiveCoreMini", "addViewToWindowManager failed: %s", new Object[] { paramContext.getMessage() });
        }
      }
      break;
    }
  }
  
  public final void dC(boolean paramBoolean)
  {
    ac.i("MicroMsg.LiveCore", "onAudioVolumeEvaluationChange:".concat(String.valueOf(paramBoolean)));
  }
  
  public final int k(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    com.tencent.mm.media.widget.a.e locale;
    Context localContext;
    if (paramBoolean1)
    {
      locale = (com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.b.e(this.context);
      this.goG = locale;
      locale = this.goG;
      if (locale != null) {
        locale.atE();
      }
      locale = this.goG;
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
        ac.e("MicroMsg.LiveCoreError", "[-1] live anchor open camera error");
        i = -1;
      }
      return i;
      locale = (com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.a.d(this.context);
      break;
    }
  }
  
  public final void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    ac.i("MicroMsg.LiveCore", "onConnectOtherRoom, userID:" + paramString1 + ", err:" + paramInt + ", errMsg:$" + paramString2);
  }
  
  public final void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    ac.i("MicroMsg.LiveCore", "onDisConnectOtherRoom, err:" + paramInt + ", errMsg:" + paramString);
  }
  
  public void onEnterRoom(long paramLong)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.gqF;
    localObject1 = new StringBuilder("create room ret:").append(paramLong).append('(');
    Object localObject2 = com.tencent.mm.live.core.a.a.gqG;
    com.tencent.mm.live.core.debug.a.uG(com.tencent.mm.live.core.a.a.mD((int)paramLong) + ')');
    localObject1 = this.goH;
    if (localObject1 != null) {
      b.a.a((com.tencent.mm.live.core.core.b)localObject1, (int)paramLong);
    }
    this.goH = null;
    localObject1 = this.goL;
    localObject2 = this.goK;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).gnU;
      if (localObject2 == null) {}
    }
    for (paramLong = ((com.tencent.mm.live.core.core.b.c)localObject2).gmP;; paramLong = -1L)
    {
      ((com.tencent.mm.live.core.core.b.e)localObject1).goa = e.c.goq;
      ((com.tencent.mm.live.core.core.b.e)localObject1).god = paramLong;
      return;
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    paramBundle = new Bundle();
    paramBundle.putInt("live_err_code", paramInt);
    com.tencent.mm.live.core.core.b localb = this.goJ;
    if (localb != null)
    {
      c.b localb1 = c.b.gnu;
      localb.f(c.b.aiE(), paramBundle);
    }
    paramBundle = com.tencent.mm.live.core.debug.a.gqF;
    paramString = new StringBuilder("[").append(paramInt).append("]msg:").append(paramString).append('(');
    paramBundle = com.tencent.mm.live.core.a.a.gqG;
    com.tencent.mm.live.core.debug.a.uG(com.tencent.mm.live.core.a.a.mD(paramInt) + ')');
  }
  
  public final void onExitRoom(int paramInt)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.gqF;
    localObject1 = new StringBuilder("[").append(paramInt).append("]end exit room.(");
    Object localObject2 = com.tencent.mm.live.core.a.a.gqG;
    com.tencent.mm.live.core.debug.a.uG(com.tencent.mm.live.core.a.a.mD(paramInt) + ')');
    localObject1 = this.goI;
    if (localObject1 != null) {
      b.a.a((com.tencent.mm.live.core.core.b)localObject1, paramInt);
    }
    if (paramInt != 0)
    {
      localObject1 = this.goJ;
      if (localObject1 != null)
      {
        localObject2 = c.b.gnu;
        b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.aiG());
      }
    }
    this.goI = null;
  }
  
  public final void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("[sdk]onFirstVideoFrame uid:" + paramString + " ,streamType:" + paramInt1 + " width:" + paramInt2 + " height:" + paramInt3);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_first_frame_width", paramInt2);
    ((Bundle)localObject).putInt("live_first_frame_height", paramInt3);
    paramString = this.goJ;
    if (paramString != null)
    {
      c.b localb = c.b.gnu;
      paramString.f(c.b.aiH(), (Bundle)localObject);
    }
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("[sdk]onRemoteUserLeaveRoom:" + paramString + " reason:" + paramInt);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_user_exit_reason", paramInt);
    com.tencent.mm.live.core.core.b localb = this.goJ;
    if (localb != null)
    {
      c.b localb1 = c.b.gnu;
      localb.f(c.b.aiB(), (Bundle)localObject);
    }
    this.goz.uD(paramString);
  }
  
  public final void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "[sdk]onUserAudioAvailable:" + paramString + ", available:" + paramBoolean + ", isAnchor:" + this.dmG);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putBoolean("live_media_enable", paramBoolean);
    com.tencent.mm.live.core.core.b localb = this.goJ;
    if (localb != null)
    {
      c.b localb1 = c.b.gnu;
      localb.f(c.b.aiC(), (Bundle)localObject);
    }
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramString))) {
      com.tencent.mm.live.core.core.trtc.a.b.c.uC(paramString);
    }
    if (this.dmG) {
      this.goz.ajo();
    }
  }
  
  public final void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("onUserSubStreamAvailable:" + paramString + ", available:" + paramBoolean);
  }
  
  public final void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("onUserVideoAvailable uid:" + paramString + " available:" + paramBoolean + ", isAnchor:" + this.dmG);
    Object localObject2;
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      localObject2 = this.goz;
      localObject1 = this.goF;
      if (localObject1 != null)
      {
        localObject1 = ((LivePreviewView)localObject1).R(paramString, 0);
        ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject2).a(paramString, (TXCloudVideoView)localObject1);
        localObject1 = this.goJ;
        if (localObject1 != null)
        {
          localObject2 = c.b.gnu;
          b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.aiA());
        }
        if ((!this.dmG) && (bs.lr(this.goL.goe, paramString)))
        {
          localObject1 = this.goF;
          if (localObject1 != null)
          {
            int i = ((LivePreviewView)localObject1).gso.uM(paramString);
            ((LivePreviewView)localObject1).gso.mS(i);
          }
        }
      }
    }
    for (;;)
    {
      if ((!this.dmG) && (!bs.lr(this.goL.goe, paramString))) {
        this.goL.gof = paramString;
      }
      if (this.dmG) {
        this.goz.ajo();
      }
      return;
      localObject1 = null;
      break;
      localObject1 = this.goF;
      if (localObject1 != null) {
        ((LivePreviewView)localObject1).gso.uL(paramString);
      }
      this.goz.uB(paramString);
      localObject1 = this.goJ;
      if (localObject1 != null)
      {
        localObject2 = c.b.gnu;
        b.a.a((com.tencent.mm.live.core.core.b)localObject1, c.b.aiF());
      }
    }
  }
  
  public void release()
  {
    this.goE.release();
    this.goy.setListener(null);
    Object localObject = this.goD;
    if (((com.tencent.mm.live.core.mini.a)localObject).gqI.isHeld()) {
      ((com.tencent.mm.live.core.mini.a)localObject).gqI.release();
    }
    localObject = b.gpb;
    localObject = b.aiW();
    if (localObject != null) {
      ((b)localObject).destroy();
    }
    b.a(null);
  }
  
  public final void switchCamera()
  {
    try
    {
      Object localObject = this.goG;
      com.tencent.mm.media.widget.a.e locale;
      if ((localObject != null) && (((com.tencent.mm.media.widget.a.e)localObject).atn() == true))
      {
        localObject = this.goG;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.e)localObject).atm();
        }
        this.goE.ajB();
        if (this.goF != null)
        {
          localObject = this.goG;
          if ((localObject != null) && (((com.tencent.mm.media.widget.a.e)localObject).atn() == true))
          {
            localObject = com.tencent.mm.live.core.core.trtc.a.a.aiX();
            k.g(localObject, "ConfigHelper.getInstance()");
            localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).ajb();
            locale = this.goG;
            if (locale == null) {
              break label134;
            }
          }
        }
      }
      label134:
      for (int i = locale.atC();; i = 0)
      {
        ((com.tencent.mm.live.core.core.trtc.a.a.b)localObject).gpy = i;
        localObject = this.goG;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.media.widget.a.e)localObject).aty();
          if (localObject != null) {
            this.goE.a((com.tencent.mm.media.widget.a.b)localObject);
          }
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, "switch camera error:" + localException.getMessage(), new Object[0]);
    }
  }
  
  public final void uv(String paramString)
  {
    k.h(paramString, "state");
    com.tencent.mm.live.core.mini.a.uJ(paramString);
  }
  
  public final void uw(String paramString)
  {
    k.h(paramString, "privateMapKey");
    if (!bs.isNullOrNil(paramString))
    {
      i locali = new i();
      locali.i("privateMapKey", paramString);
      paramString = new i();
      paramString.i("api", "updatePrivateMapKey");
      paramString.i("params", locali);
      ac.i("MicroMsg.LiveCore", "updatePrivateMapKey:" + paramString + ' ');
      this.goy.callExperimentalAPI(paramString.toString());
    }
  }
  
  public final void w(float paramFloat1, float paramFloat2)
  {
    if (this.dmG) {
      this.goz.x(paramFloat1, paramFloat2);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class c
    extends d.g.b.l
    implements q<j, Integer, Integer, y>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<SurfaceTexture, y>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "width", "", "height", "invoke"})
  public static final class e
    extends d.g.b.l
    implements m
  {
    public e(a parama, j paramj)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  public static final class f
    extends d.g.b.l
    implements d.g.a.b<SurfaceTexture, y>
  {
    public f(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke", "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$startPreviewToRemote$2$1"})
  public static final class g
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.f.d, y>
  {
    public g(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  public static final class h
    extends d.g.b.l
    implements q<j, Integer, Integer, y>
  {
    public h(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a
 * JD-Core Version:    0.7.0.1
 */