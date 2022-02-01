package com.tencent.mm.live.core.core.trtc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.AudioMusicParam;
import com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.autogen.mmdata.rpt.jg;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.live.core.b.d.l;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.d;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.core.core.e.p;
import com.tencent.mm.live.core.core.e.q;
import com.tencent.mm.live.core.core.e.r;
import com.tencent.mm.live.core.core.e.s;
import com.tencent.mm.live.core.core.model.i.c;
import com.tencent.mm.live.core.core.model.i.d;
import com.tencent.mm.live.core.core.model.i.e;
import com.tencent.mm.live.core.core.trtc.sdkadapter.b.c.b;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.mini.b.b;
import com.tencent.mm.live.core.mini.b.c;
import com.tencent.mm.live.core.mini.b.d;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCMixUser;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCLocalStatistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/IMMLiveCore;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager$IView;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManagerListener;", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "isAnchor", "", "(Z)V", "audienceMode", "", "getAudienceMode", "()Ljava/lang/Integer;", "setAudienceMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "audioFrame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCAudioFrame;", "backupCaptureVolume", "getBackupCaptureVolume", "()I", "setBackupCaptureVolume", "(I)V", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "getBeautyConfig", "()Lcom/tencent/mm/live/core/render/BeautyConfig;", "setBeautyConfig", "(Lcom/tencent/mm/live/core/render/BeautyConfig;)V", "blurFinalFrame", "Landroid/graphics/Bitmap;", "blurFrameRetrieveCallback", "Lkotlin/Function1;", "", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getCamera", "()Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "setCamera", "(Lcom/tencent/mm/media/widget/camera/ICommonCamera;)V", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "curScreenShareView", "Landroid/view/View;", "debugPushPlayer", "Lcom/tencent/thumbplayer/tplayer/TPPlayer;", "enterRoomCallback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "getEnterRoomCallback", "()Lcom/tencent/mm/live/core/core/LiveCallback;", "setEnterRoomCallback", "(Lcom/tencent/mm/live/core/core/LiveCallback;)V", "exitRoomCallback", "getExitRoomCallback", "setExitRoomCallback", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "getFilterConfig", "()Lcom/tencent/mm/live/core/render/FilterConfig;", "setFilterConfig", "(Lcom/tencent/mm/live/core/render/FilterConfig;)V", "firstFrameCallback", "getFirstFrameCallback", "setFirstFrameCallback", "floatModeBitmap", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "frameTexture", "Lcom/tencent/trtc/TRTCCloudDef$TRTCTexture;", "()Z", "setAnchor", "isPlayingBgMusic", "setPlayingBgMusic", "isPushing", "setPushing", "lastCameraFps", "getLastCameraFps", "setLastCameraFps", "lastLocalNetworkQuality", "getLastLocalNetworkQuality", "setLastLocalNetworkQuality", "lastSEIReportTimestamp", "", "getLastSEIReportTimestamp", "()J", "setLastSEIReportTimestamp", "(J)V", "liveCallback", "getLiveCallback", "setLiveCallback", "liveConfig", "Lcom/tencent/mm/live/core/core/model/LiveConfig;", "getLiveConfig", "()Lcom/tencent/mm/live/core/core/model/LiveConfig;", "setLiveConfig", "(Lcom/tencent/mm/live/core/core/model/LiveConfig;)V", "liveScene", "getLiveScene", "setLiveScene", "liveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "miniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getMiniManager", "()Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "setMiniManager", "(Lcom/tencent/mm/live/core/mini/LiveMiniManager;)V", "miniWindowStateCallback", "Lcom/tencent/mm/live/core/core/trtc/MiniWindowStateCallback;", "getMiniWindowStateCallback", "()Lcom/tencent/mm/live/core/core/trtc/MiniWindowStateCallback;", "setMiniWindowStateCallback", "(Lcom/tencent/mm/live/core/core/trtc/MiniWindowStateCallback;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "playingBgMusic", "Lcom/tencent/liteav/audio/TXAudioEffectManager$AudioMusicParam;", "getPlayingBgMusic", "()Lcom/tencent/liteav/audio/TXAudioEffectManager$AudioMusicParam;", "(Lcom/tencent/liteav/audio/TXAudioEffectManager$AudioMusicParam;)V", "playingLocalSoundEffect", "getPlayingLocalSoundEffect", "setPlayingLocalSoundEffect", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "getPreviewView", "()Lcom/tencent/mm/live/core/view/LivePreviewView;", "setPreviewView", "(Lcom/tencent/mm/live/core/view/LivePreviewView;)V", "renderManager", "Lcom/tencent/mm/live/core/render/LiveRenderManager;", "getRenderManager", "()Lcom/tencent/mm/live/core/render/LiveRenderManager;", "setRenderManager", "(Lcom/tencent/mm/live/core/render/LiveRenderManager;)V", "screenShareBlendBitmap", "screenShareBlendCanvas", "Landroid/graphics/Canvas;", "screenShareBlendMatrix", "Landroid/graphics/Matrix;", "screenShareCameraBitmap", "screenShareCameraCanvas", "screenShareCameraDstRect", "Landroid/graphics/Rect;", "screenShareCameraSrcRect", "screenShareFloatTranslate", "Landroid/graphics/Point;", "screenShareRenderPrco", "Lcom/tencent/mm/live/core/render/LiveScreenShareRender;", "screenShareSurface", "Landroid/view/Surface;", "screenShareTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "seiData", "", "getSeiData", "()Ljava/lang/String;", "setSeiData", "(Ljava/lang/String;)V", "seiReportInterval", "getSeiReportInterval", "setSeiReportInterval", "trtcCloud", "Lcom/tencent/trtc/TRTCCloud;", "getTrtcCloud", "()Lcom/tencent/trtc/TRTCCloud;", "trtcCloud$delegate", "Lkotlin/Lazy;", "trtcCloudIsInit", "trtcManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "getTrtcManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;", "setTrtcManager", "(Lcom/tencent/mm/live/core/core/trtc/sdkadapter/TRTCCloudManager;)V", "trtcRemoteUserManager", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "getTrtcRemoteUserManager", "()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;", "trtcRemoteUserManager$delegate", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "adjustFloatBallSize", "size", "applyLiveMiniState", "applyState", "calcMiniWindowSize", "context", "Landroid/content/Context;", "callLiveExperimentalAPI", "jsStr", "checkMirror", "dumpUserVoiceVolume", "userVolumes", "Ljava/util/ArrayList;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "enableAudioVolumeEvaluation", "interval", "enableCustomAudioCapture", "enable", "enableMicExternalAudioFrame", "enablePublish", "enablePlayout", "enterRoom", "callback", "exitRoom", "fillMiniView", "miniView", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "floatMode", "forceMoveTask", "dontFinish", "generateType", "opType", "muteVideoImage", "isFluentFloatShow", "genAudioMusicParam", "id", "path", "isPublish", "loopCount", "genBlendBitmap", "previewBitmap", "genLiveResolution", "getAnchorInfoLinkMicJson", "Lorg/json/JSONObject;", "getAudioCaptureVolume", "getBgMusicId", "getCurrentBallSize", "getFinalCameraFrame", "getLiveConfigInfo", "getLiveRoomModel", "getLiveStatus", "getPreviewBitmap", "width", "height", "Lkotlin/ParameterName;", "name", "bitmap", "getRecordScene", "getRemoteUserViewById", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "steamType", "getResolutionLimit", "getScene", "getScreenShareFloatLocation", "getScreenShareShot", "handleSeiMessage", "seiMode", "", "initCamera", "useCamera2", "frontCamera", "initCameraConfig", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "isInLinkMic", "isInLive", "liveId", "justRemoveMiniWindow", "markScreenShareFloatLocation", "x", "y", "mixExternalAudioFrame", "audioBuffer", "sampleRate", "channel", "timestamp", "muteLocalAudio", "mute", "muteLocalVideo", "muteMicVolume", "normalMode", "notifyCloudMixtureForFinder", "micData", "onAudioEffectFinished", "effectId", "code", "onAudioVolumeEvaluationChange", "onCloseLive", "onConnectOtherRoom", "userID", "err", "errMsg", "onDisConnectOtherRoom", "onEnterRoom", "result", "onError", "errCode", "extraInfo", "Landroid/os/Bundle;", "onExitRoom", "reason", "onFirstVideoFrame", "streamType", "onMuteLocalAudio", "isMute", "onMuteLocalVideo", "onNetworkQuality", "localQuality", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "remoteQuality", "onRecvCustomCmdMsg", "cmdID", "seq", "message", "onRecvSEIMsg", "data", "onRemoteUserEnterRoom", "onRemoteUserLeaveRoom", "onRemoteViewStatusUpdate", "onStatistics", "statics", "Lcom/tencent/trtc/TRTCStatistics;", "onUserAudioAvailable", "available", "onUserSubStreamAvailable", "onUserVideoAvailable", "onUserVoiceVolume", "onWarning", "warningCode", "warningMsg", "parseResolution", "resolutionCode", "pauseBgMusic", "pauseLive", "playBgMusic", "publish", "listener", "Lcom/tencent/liteav/audio/TXAudioEffectManager$TXMusicPlayObserver;", "playLocalSoundEffect", "prepareScreenModeFloatBm", "refreshCamera", "release", "releaseLiveMiniState", "releaseState", "removeMiniWindow", "renderBitmap", "view", "reportDelayInfo", "msgType", "seiMessage", "resetMixtureParams", "resetScreenShare", "restoreCamera", "resumeBgMusic", "resumeLive", "seiStrInvalid", "setStr", "sendCustomAudioData", "sendCustomVideoData", "eglContext", "Landroid/opengl/EGLContext;", "texId", "setAudioCaptureVolume", "volume", "setFirstFrameDrawCallback", "setLiveMiniState", "newState", "setLiveStatusCallback", "setLocalSoundVolume", "setMiniWindowStateListener", "setMusicVolume", "level", "setNetEnv", "env", "setScene", "scene", "setVoiceCaptureVolume", "setup", "startLocalAudio", "startPreview", "startPreviewOnlyLocal", "surfaceHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "startPreviewToRemote", "startPushLocalVideo", "stopBgMusic", "stopLocalSoundEffect", "stopPreview", "stopPushLocalVideo", "switchAudioMode", "muteImage", "switchCamera", "switchScreenShareMode", "screenShareMode", "cameraView", "Landroid/view/TextureView;", "screenShareView", "switchVideoMode", "updateBeautyConfig", "updateCloudMixtureParamsForFinder", "reset", "updateFilterConfig", "updateMirrorMode", "mirrorMode", "updateMixStreamFloatOffset", "xOffset", "", "yOffset", "updateMuteVideoImage", "fps", "updatePreview", "updatePrivateMapKey", "privateMapKey", "updateRemoteOutputSurface", "updateSdkParam", "updateVisitoreRenderMode", "renderMode", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements com.tencent.mm.live.core.core.b, com.tencent.mm.live.core.core.trtc.sdkadapter.b.c.a, com.tencent.mm.live.core.core.trtc.sdkadapter.c.a, com.tencent.mm.live.core.core.trtc.sdkadapter.d, com.tencent.mm.media.widget.camerarecordview.d.b
{
  public static final a.a mRh = new a.a((byte)0);
  private boolean hKC;
  public com.tencent.mm.live.core.core.model.h mRA;
  public com.tencent.mm.live.core.core.model.i mRB;
  protected boolean mRC;
  public com.tencent.mm.live.core.b.a mRD;
  public com.tencent.mm.live.core.b.b mRE;
  private long mRF;
  private int mRG;
  public TXAudioEffectManager.AudioMusicParam mRH;
  public boolean mRI;
  public TXAudioEffectManager.AudioMusicParam mRJ;
  public int mRK;
  public int mRL;
  public com.tencent.mm.live.core.core.model.c mRM;
  public int mRN;
  private int mRO;
  private Bitmap mRP;
  public Point mRQ;
  private Surface mRR;
  private com.tencent.mm.live.core.b.f mRS;
  public View mRT;
  private final MTimerHandler mRU;
  private Bitmap mRV;
  private Canvas mRW;
  private Matrix mRX;
  private Rect mRY;
  private Rect mRZ;
  public final MMHandler mRi;
  private final kotlin.j mRj;
  private boolean mRk;
  private final kotlin.j mRl;
  private com.tencent.mm.live.core.core.trtc.sdkadapter.c mRm;
  public final TRTCCloudDef.TRTCVideoFrame mRn;
  public final TRTCCloudDef.TRTCTexture mRo;
  public final TRTCCloudDef.TRTCAudioFrame mRp;
  public com.tencent.mm.live.core.mini.b mRq;
  public b mRr;
  public com.tencent.mm.live.core.b.d mRs;
  public LivePreviewView mRt;
  public com.tencent.mm.media.widget.a.f mRu;
  public com.tencent.mm.media.widget.a.b mRv;
  private com.tencent.mm.live.core.core.c mRw;
  private com.tencent.mm.live.core.core.c mRx;
  public com.tencent.mm.live.core.core.c mRy;
  private com.tencent.mm.live.core.core.c mRz;
  private Canvas mSa;
  private Bitmap mSb;
  public com.tencent.thumbplayer.g.b mSc;
  public String mSd;
  public Integer mSe;
  
  public a(boolean paramBoolean)
  {
    this.hKC = paramBoolean;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.mRj = kotlin.k.cm((kotlin.g.a.a)new a.y(this));
    this.mRl = kotlin.k.cm((kotlin.g.a.a)new z(this));
    this.mRn = new TRTCCloudDef.TRTCVideoFrame();
    this.mRo = new TRTCCloudDef.TRTCTexture();
    this.mRp = new TRTCCloudDef.TRTCAudioFrame();
    this.mRq = new com.tencent.mm.live.core.mini.b();
    this.mRs = new com.tencent.mm.live.core.b.d();
    this.mRB = new com.tencent.mm.live.core.core.model.i();
    this.mRG = 5;
    this.mRK = 15;
    this.mRM = new com.tencent.mm.live.core.core.model.c((byte)0);
    Object localObject = e.h.mKY;
    this.mRN = e.h.bdi();
    this.mRO = 100;
    this.mRQ = new Point(0, 0);
    this.mRU = new MTimerHandler("liveScreenShareTimer", new a..ExternalSyntheticLambda0(this), true);
    this.mRY = new Rect();
    this.mRZ = new Rect();
    Log.i("MicroMsg.LiveCore", s.X("live anchor use trtc,ver:", TRTCCloud.getSDKVersion()));
    localObject = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.Ga(s.X("use trtc sdk,ver:", TRTCCloud.getSDKVersion()));
    TXLiveBase.setListener(a..ExternalSyntheticLambda1.INSTANCE);
    if (this.mRB.isDebugMode)
    {
      TRTCCloud.setLogLevel(0);
      TRTCCloud.setConsoleEnabled(true);
    }
    for (;;)
    {
      this.mRM.mMI = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZj, 20);
      return;
      TRTCCloud.setLogLevel(4);
    }
  }
  
  private final void G(int paramInt, String paramString)
  {
    long l3 = System.currentTimeMillis();
    if (l3 - this.mRF > this.mRG * 1000) {}
    for (;;)
    {
      try
      {
        long l4 = cn.bDu();
        com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
        Object localObject = com.tencent.mm.ad.h.Fo(paramString);
        if ((paramInt == e.q.mLM.value) && (localObject != null))
        {
          paramString = e.r.mLO;
          l2 = ((com.tencent.mm.ad.c)localObject).optLong(e.r.bdL(), 0L);
          locali.n("SVRT", Long.valueOf(l4));
          paramString = this.mRA;
          if (paramString == null)
          {
            paramString = "";
            locali.n("GAMEID", paramString);
            locali.n("SEI", localObject);
            Log.i("MicroMsg.LiveCore", "handleSeiMessage SEIMode_GAMEREPORT jsonData:" + locali + ", anchorTs:" + l2 + ", audienceTs:" + l4);
            localObject = new jg();
            ((jg)localObject).rZ(String.valueOf(paramInt));
            ((jg)localObject).iSo = 2012L;
            paramString = this.mRA;
            if (paramString == null)
            {
              l1 = 0L;
              ((jg)localObject).iDB = l1;
              ((jg)localObject).iuA = this.mRN;
              paramString = this.mRA;
              if (paramString != null) {
                continue;
              }
              l1 = 0L;
              ((jg)localObject).iSq = l1;
              ((jg)localObject).sa(com.tencent.mm.compatible.util.r.as(locali.toString(), "UTF-8"));
              ((jg)localObject).iSr = l2;
              ((jg)localObject).iSs = l4;
              paramString = this.mRA;
              if (paramString != null) {
                continue;
              }
              paramInt = 0;
              ((jg)localObject).iSt = paramInt;
              paramString = this.mRA;
              if (paramString != null) {
                continue;
              }
              paramString = "";
              ((jg)localObject).sb(paramString);
              ((jg)localObject).bMH();
              this.mRF = l3;
            }
          }
          else
          {
            paramString = paramString.mJH;
            if (paramString == null)
            {
              paramString = "";
              continue;
            }
            paramString = paramString.mNv;
            if (paramString == null)
            {
              paramString = "";
              continue;
            }
            str = paramString.Idh;
            paramString = str;
            if (str != null) {
              continue;
            }
            paramString = "";
            continue;
          }
          paramString = paramString.mJH;
          if (paramString == null)
          {
            l1 = 0L;
            continue;
          }
          long l1 = paramString.liveId;
          continue;
          paramString = paramString.mJH;
          if (paramString == null)
          {
            l1 = 0L;
            continue;
          }
          l1 = paramString.mNn;
          continue;
          paramString = paramString.mNz;
          if (paramString == null)
          {
            paramInt = 0;
            continue;
          }
          paramInt = paramString.roomId;
          continue;
          paramString = paramString.mJH;
          if (paramString == null)
          {
            paramString = "";
            continue;
          }
          String str = paramString.mIA;
          paramString = str;
          if (str != null) {
            continue;
          }
          paramString = "";
          continue;
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.i("MicroMsg.LiveCore", paramString.toString());
      }
      long l2 = 0L;
    }
  }
  
  private static final void a(int paramInt, byte[] paramArrayOfByte, a parama)
  {
    s.u(parama, "this$0");
    Log.d("MicroMsg.LiveCore", "handleSeiMessage seiMode:" + paramInt + " seiData:" + paramArrayOfByte + " anchorId:" + parama.mRB.mNM);
    int i;
    if ((paramInt != 0) && (paramArrayOfByte != null))
    {
      if (paramArrayOfByte.length == 0)
      {
        i = 1;
        if (i == 0) {
          break label90;
        }
      }
    }
    else {
      Log.i("MicroMsg.LiveCore", "skip handleSeiMessage");
    }
    label90:
    Object localObject1;
    label449:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                i = 0;
                break;
                localObject1 = new String(paramArrayOfByte, kotlin.n.d.UTF_8);
                i = n.g((CharSequence)localObject1, "\\0");
                paramArrayOfByte = (byte[])localObject1;
                if (i != -1)
                {
                  paramArrayOfByte = (byte[])localObject1;
                  if (i == ((String)localObject1).length() - 2)
                  {
                    paramArrayOfByte = ((String)localObject1).substring(0, i);
                    s.s(paramArrayOfByte, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                  }
                }
                Log.d("MicroMsg.LiveCore", s.X("final seiMessage:", paramArrayOfByte));
                if (!n.i((CharSequence)paramArrayOfByte, (CharSequence)"TencentStreamSEI")) {
                  try
                  {
                    localObject2 = new com.tencent.mm.ad.i(paramArrayOfByte);
                    parama.mSd = paramArrayOfByte;
                    i = ((com.tencent.mm.ad.i)localObject2).optInt("wxT");
                    if ((i == 0) || (Util.isNullOrNil(((com.tencent.mm.ad.i)localObject2).optString("d")))) {
                      break label449;
                    }
                    if ((com.tencent.mm.ae.d.ee(paramInt, e.q.mLK.value)) && (com.tencent.mm.ae.d.ee(i, e.q.mLK.value)))
                    {
                      localObject1 = new Bundle();
                      ((Bundle)localObject1).putString("live_cdn_sei_msg", ((com.tencent.mm.ad.i)localObject2).optString("d"));
                      parama = parama.mRy;
                      if (parama == null) {
                        continue;
                      }
                      localObject2 = e.g.mKv;
                      parama.callback(e.g.bcY(), (Bundle)localObject1);
                    }
                  }
                  catch (Exception parama)
                  {
                    Log.w("MicroMsg.LiveCore", "handleSeiMessage Exception:" + parama.getMessage() + " seiMessage:" + paramArrayOfByte);
                    return;
                  }
                }
              }
            } while ((!com.tencent.mm.ae.d.ee(paramInt, e.q.mLM.value)) || (!com.tencent.mm.ae.d.ee(i, e.q.mLM.value)));
            localObject1 = new Bundle();
            parama.G(e.q.mLM.value, ((com.tencent.mm.ad.i)localObject2).optString("d"));
            ((Bundle)localObject1).putString("live_cdn_sei_msg", ((com.tencent.mm.ad.i)localObject2).optString("d"));
            ((Bundle)localObject1).putString("live_link_mic_info_in_anchor_sei_msg", ((com.tencent.mm.ad.i)localObject2).optString("m"));
            parama = parama.mRy;
          } while (parama == null);
          localObject2 = e.g.mKv;
          parama.callback(e.g.bda(), (Bundle)localObject1);
          return;
          if ((com.tencent.mm.ae.d.ee(paramInt, e.q.mLI.value)) && (n.i((CharSequence)paramArrayOfByte, (CharSequence)"sgame"))) {
            parama.G(e.q.mLI.value, paramArrayOfByte);
          }
        } while ((!com.tencent.mm.ae.d.ee(paramInt, e.q.mLJ.value)) || (!n.i((CharSequence)paramArrayOfByte, (CharSequence)"subtitle")));
        Log.i("MicroMsg.LiveCore", s.X("handleSeiMessage SEIMode_SUBTITLE seiMessage:", paramArrayOfByte));
      } while (((com.tencent.mm.ad.i)localObject2).optInt("wxt") != e.q.mLJ.value);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("live_cdn_sei_msg", paramArrayOfByte);
      parama = parama.mRy;
    } while (parama == null);
    Object localObject2 = e.g.mKv;
    parama.callback(e.g.bdb(), (Bundle)localObject1);
  }
  
  private static final boolean a(a parama)
  {
    s.u(parama, "this$0");
    if (parama.mRB.mNQ)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(parama));
      return true;
    }
    return false;
  }
  
  public static void b(Point paramPoint)
  {
    s.u(paramPoint, "size");
    Object localObject = com.tencent.mm.live.core.mini.a.mUD;
    localObject = com.tencent.mm.live.core.mini.a.b.mUF;
    com.tencent.mm.live.core.mini.a.b.bfP().b(paramPoint);
  }
  
  public static Point beW()
  {
    Object localObject = com.tencent.mm.live.core.mini.a.mUD;
    localObject = com.tencent.mm.live.core.mini.a.b.mUF;
    localObject = com.tencent.mm.live.core.mini.a.b.bfP().vjV;
    if (localObject == null) {
      return null;
    }
    return ((BallInfo)localObject).vjC;
  }
  
  private final void beX()
  {
    this.mRS = null;
    this.mRR = null;
    this.mRT = null;
    this.mRV = null;
    this.mRW = null;
    this.mRX = null;
    this.mRY.setEmpty();
    this.mRZ.setEmpty();
    this.mSa = null;
    this.mSb = null;
    this.mRQ.set(0, 0);
    this.mRU.stopTimer();
  }
  
  private void bfb()
  {
    b.a.a locala = new b.a.a();
    Object localObject1 = com.tencent.mm.compatible.c.a.lQF;
    int k = com.tencent.mm.compatible.c.a.aOk();
    int j;
    if (k >= 0) {
      j = 0;
    }
    for (;;)
    {
      b.a.c localc = new b.a.c();
      int i = this.mRN;
      localObject1 = e.h.mKY;
      Object localObject2;
      if (i == e.h.bdj())
      {
        localObject1 = q.aPo();
        s.s(localObject1, "getModel()");
        String str2 = ((String)localObject1).toLowerCase();
        s.s(str2, "(this as java.lang.String).toLowerCase()");
        String str3 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZw, "");
        localObject2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zwt, "");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        Object localObject3 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zwu, "");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        String str1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zwv, "");
        localObject3 = str1;
        if (str1 == null) {
          localObject3 = "";
        }
        Log.i("MicroMsg.LiveCore", "this=" + str2 + " cfg0=" + (String)localObject1 + " cfg1=" + (String)localObject2 + " cfg2=" + (String)localObject3);
        if ((n.i((CharSequence)localObject1, (CharSequence)str2)) || (n.i((CharSequence)localObject2, (CharSequence)str2)) || (n.i((CharSequence)localObject3, (CharSequence)str2)))
        {
          i = 1;
          if (i != 0) {
            break label510;
          }
          if (Util.isNullOrNil(str3)) {
            break label497;
          }
          s.s(str3, "whiteList");
          if (!n.i((CharSequence)str3, (CharSequence)str2)) {
            break label497;
          }
          i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZn, com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTa);
        }
      }
      for (;;)
      {
        this.mRK = i;
        Log.i("MicroMsg.LiveCore", s.X("camera param prepare. fps:", Integer.valueOf(i)));
        localc.nKW = Integer.valueOf(i);
        localc.nKV = Integer.valueOf(i);
        localc.nKX = Integer.valueOf(i);
        locala.b(new kotlin.r[] { new kotlin.r(Integer.valueOf(j), localc) });
        if (j != k) {
          break label523;
        }
        locala.scene = 13;
        localObject1 = locala.buq();
        localObject2 = this.mRu;
        if (localObject2 != null) {
          ((com.tencent.mm.media.widget.a.f)localObject2).a((com.tencent.mm.media.widget.camerarecordview.d.b.a)localObject1);
        }
        return;
        i = 0;
        break;
        label497:
        i = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTa;
        continue;
        label510:
        i = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTa;
      }
      label523:
      j += 1;
    }
  }
  
  private final void db(View paramView)
  {
    for (;;)
    {
      int i;
      int j;
      Object localObject1;
      Object localObject2;
      try
      {
        i = paramView.getMeasuredWidth() - paramView.getMeasuredWidth() % 4;
        j = paramView.getMeasuredHeight();
        int k = paramView.getMeasuredHeight();
        j -= k % 4;
        if ((i <= 0) || (j <= 0)) {
          return;
        }
        if (this.mRS == null) {
          this.mRS = new com.tencent.mm.live.core.b.f(i, j, (kotlin.g.a.b)new a.f(this));
        }
        if (!this.mRB.bex())
        {
          localObject1 = this.mRV;
          if (localObject1 != null)
          {
            localObject2 = this.mRS;
            if (localObject2 != null) {
              ((com.tencent.mm.live.core.b.f)localObject2).mVG = ((Bitmap)localObject1);
            }
          }
          localObject1 = this.mRS;
          if (localObject1 != null)
          {
            localObject2 = ((com.tencent.mm.live.core.b.f)localObject1).mVF;
            if (localObject2 != null) {
              ((com.tencent.mm.media.j.b.b)localObject2).el(i, j);
            }
            localObject2 = ((com.tencent.mm.live.core.b.f)localObject1).mSurfaceTexture;
            if (localObject2 != null) {
              ((SurfaceTexture)localObject2).setDefaultBufferSize(i, j);
            }
            if (i <= j) {
              break label360;
            }
            localObject2 = ((com.tencent.mm.live.core.b.f)localObject1).mVF;
            if (localObject2 != null) {
              ((com.tencent.mm.media.j.b.b)localObject2).th(270);
            }
            localObject2 = ((com.tencent.mm.live.core.b.f)localObject1).mVF;
            if (localObject2 != null) {
              ((com.tencent.mm.media.j.b.b)localObject2).gq(false);
            }
            localObject2 = ((com.tencent.mm.live.core.b.f)localObject1).mVF;
            if (localObject2 != null) {
              ((com.tencent.mm.media.j.b.b)localObject2).ek(j, i);
            }
            localObject2 = ((com.tencent.mm.live.core.b.f)localObject1).mVF;
            if (localObject2 != null) {
              ((com.tencent.mm.media.j.b.b)localObject2).es(j, i);
            }
            ((com.tencent.mm.live.core.b.f)localObject1).mWidth = i;
            ((com.tencent.mm.live.core.b.f)localObject1).mHeight = j;
          }
          localObject1 = this.mRR;
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((Surface)localObject1).lockCanvas(null);
          if (localObject1 == null) {
            continue;
          }
          if (!this.mRB.isFloatMode()) {
            break label437;
          }
          paramView = this.mRP;
          if (paramView != null) {
            ((Canvas)localObject1).drawBitmap(paramView, null, new Rect(0, 0, i, j), null);
          }
          paramView = this.mRR;
          if (paramView == null) {
            continue;
          }
          paramView.unlockCanvasAndPost((Canvas)localObject1);
          continue;
        }
        localObject1 = this.mRS;
      }
      finally {}
      if (localObject1 != null)
      {
        ((com.tencent.mm.live.core.b.f)localObject1).mVG = null;
        continue;
        label360:
        localObject2 = ((com.tencent.mm.live.core.b.f)localObject1).mVF;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.b)localObject2).th(0);
        }
        localObject2 = ((com.tencent.mm.live.core.b.f)localObject1).mVF;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.b)localObject2).gr(true);
        }
        localObject2 = ((com.tencent.mm.live.core.b.f)localObject1).mVF;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.b)localObject2).ek(i, j);
        }
        localObject2 = ((com.tencent.mm.live.core.b.f)localObject1).mVF;
        if (localObject2 != null)
        {
          ((com.tencent.mm.media.j.b.b)localObject2).es(i, j);
          continue;
          label437:
          ((Canvas)localObject1).drawPaint(new Paint());
          ((Canvas)localObject1).setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
          paramView.draw((Canvas)localObject1);
        }
      }
    }
  }
  
  private static final void j(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      Log.v("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      return;
    case 1: 
      Log.d("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      return;
    case 2: 
      Log.i("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      return;
    case 3: 
      Log.w("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
      return;
    }
    Log.e("MicroMsg.LiveCoreSdk", "[LiteAV][" + paramInt + "][" + paramString1 + ']' + paramString2);
  }
  
  private static int sX(int paramInt)
  {
    switch (paramInt)
    {
    case 111: 
    case 113: 
    case 114: 
    default: 
      return 1080;
    case 112: 
      return 720;
    }
    return 540;
  }
  
  private void setAudioCaptureVolume(int paramInt)
  {
    Log.i("MicroMsg.LiveCore", s.X("setAudioCaptureVolume ", Integer.valueOf(paramInt)));
    beO().setAudioCaptureVolume(paramInt);
  }
  
  public void C(JSONObject paramJSONObject) {}
  
  public void FO(String paramString)
  {
    s.u(paramString, "privateMapKey");
    if (!Util.isNullOrNil(paramString))
    {
      com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
      locali.m("privateMapKey", paramString);
      paramString = new com.tencent.mm.ad.i();
      paramString.m("api", "updatePrivateMapKey");
      paramString.m("params", locali);
      Log.i("MicroMsg.LiveCore", "updatePrivateMapKey:" + paramString + ' ');
      beO().callExperimentalAPI(paramString.toString());
    }
  }
  
  public final void FP(String paramString)
  {
    Log.i("MicroMsg.LiveCore", s.X("onRecvCustomCmdMsg userId:", paramString));
  }
  
  public final void FQ(String paramString)
  {
    Log.i("MicroMsg.LiveCore", s.X("updateRemoteOutputSurface userId:", paramString));
    com.tencent.mm.live.core.core.trtc.sdkadapter.b.c localc;
    if (paramString != null)
    {
      localc = beP();
      localObject = this.mRt;
      if (localObject != null) {
        break label40;
      }
    }
    label40:
    for (Object localObject = null;; localObject = ((LivePreviewView)localObject).az(paramString, 0))
    {
      localc.a(paramString, (TXCloudVideoView)localObject);
      return;
    }
  }
  
  public final void G(Bitmap paramBitmap)
  {
    s.u(paramBitmap, "muteImage");
    beO().setVideoMuteImage(paramBitmap, 5);
  }
  
  public final void H(Bitmap paramBitmap)
  {
    s.u(paramBitmap, "muteImage");
    this.mRB.bev();
    ((com.tencent.mm.live.core.core.b)this).G(paramBitmap);
    muteLocalAudio(false);
    if (this.mRB.mNQ) {
      muteLocalVideo(false);
    }
    for (;;)
    {
      bce();
      beP().fN(false);
      return;
      muteLocalVideo(true);
      paramBitmap = this.mRm;
      if (paramBitmap != null) {
        paramBitmap.fL(this.mRB.bex());
      }
    }
  }
  
  public int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, boolean paramBoolean3)
  {
    long l = 0L;
    s.u(paramContext, "context");
    this.mRP = paramBitmap;
    paramBitmap = dB(paramContext);
    this.mRs.ej(paramBitmap.x, paramBitmap.y);
    Log.i("MicroMsg.LiveCore", s.X("floatMode context:", paramContext));
    Object localObject;
    if (paramBoolean1)
    {
      paramBoolean1 = ((Activity)paramContext).isTaskRoot();
      if (paramBoolean2)
      {
        paramBoolean2 = ((Activity)paramContext).moveTaskToBack(paramBoolean1);
        Log.i("MicroMsg.LiveCore", "floatMode moveTaskToBack ret:" + paramBoolean2 + ", isTaskRoot:" + paramBoolean1 + " scene:" + this.mRN);
      }
    }
    else
    {
      paramContext = this.mRq;
      localObject = this.mRA;
      if (localObject != null) {
        break label243;
      }
    }
    for (;;)
    {
      paramContext.a(paramBitmap, l, this.hKC, paramInt1, paramInt2);
      this.mRB.mNK = i.e.mOg;
      return 0;
      int i = this.mRN;
      localObject = e.h.mKY;
      if (i == e.h.bdj()) {
        ((Activity)paramContext).finish();
      }
      for (;;)
      {
        Log.i("MicroMsg.LiveCore", "floatMode finishAndRemoveTask, isTaskRoot:" + paramBoolean1 + " scene:" + this.mRN);
        break;
        ((Activity)paramContext).finishAndRemoveTask();
      }
      label243:
      localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mJH;
      if (localObject != null) {
        l = ((com.tencent.mm.live.core.core.model.g)localObject).liveId;
      }
    }
  }
  
  public final int a(com.tencent.mm.live.core.b.k paramk)
  {
    int i = 1;
    s.u(paramk, "surfaceHolder");
    this.mRs.bgy();
    paramk.mWz = ((kotlin.g.a.a)new a.l(paramk, this));
    paramk.mWA = ((m)new a.m(this));
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.Ga("startPreview " + paramk + ' ');
    paramk = this.mRA;
    boolean bool1;
    boolean bool2;
    if (paramk == null)
    {
      bool1 = false;
      paramk = this.mRA;
      if (paramk != null) {
        break label202;
      }
      bool2 = true;
      label100:
      r(bool1, bool2);
      paramk = this.mRA;
      if (paramk == null) {
        break label226;
      }
      paramk = paramk.mNB;
      if ((paramk == null) || (paramk.mNk != true)) {
        break label226;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramk = this.mRu;
        if (paramk != null) {
          paramk.a(this.mRs.getFrameDataCallback());
        }
      }
      this.mRs.t((kotlin.g.a.b)new a.n(this));
      return 0;
      paramk = paramk.mNB;
      if (paramk == null)
      {
        bool1 = false;
        break;
      }
      bool1 = paramk.mNi;
      break;
      label202:
      paramk = paramk.mNB;
      if (paramk == null)
      {
        bool2 = true;
        break label100;
      }
      bool2 = paramk.mNj;
      break label100;
      label226:
      i = 0;
    }
  }
  
  public final int a(com.tencent.mm.live.core.core.model.h paramh)
  {
    s.u(paramh, "model");
    Log.i("MicroMsg.LiveCore", s.X("setup model:", paramh));
    this.mRA = paramh;
    Object localObject1 = this.mRA;
    boolean bool;
    label53:
    int i;
    label133:
    com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a locala;
    com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e locale;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        if (this.mRv != null) {
          break label663;
        }
        bool = true;
        ((com.tencent.mm.live.core.core.model.f)localObject1).mNj = bool;
      }
      localObject1 = this.mRs;
      i = this.mRN;
      s.u(paramh, "model");
      ((com.tencent.mm.live.core.b.d)localObject1).mRA = paramh;
      localObject1 = ((com.tencent.mm.live.core.b.d)localObject1).mVm;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.b.g)localObject1).mVT;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.b.j)localObject1).mWt;
          if (localObject1 != null)
          {
            if (((com.tencent.mm.live.core.b.c)localObject1).muW == null) {
              break label670;
            }
            ((com.tencent.mm.live.core.b.c)localObject1).tg(i);
          }
        }
      }
      this.mRB.mNR = paramh.mNz.userId;
      localObject1 = this.mRq;
      Object localObject2 = paramh.mNA.name;
      s.u(localObject2, "activityName");
      ((com.tencent.mm.live.core.mini.b)localObject1).intent.setClass(MMApplicationContext.getContext(), Class.forName((String)localObject2));
      ((com.tencent.mm.live.core.mini.b)localObject1).intent.addFlags(268435456);
      ((com.tencent.mm.live.core.mini.b)localObject1).mUM = ((String)localObject2);
      this.mRm = new com.tencent.mm.live.core.core.trtc.sdkadapter.c(beO(), paramh.mNz);
      localObject1 = this.mRm;
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSC = ((com.tencent.mm.live.core.core.trtc.sdkadapter.c.a)this);
      }
      localObject1 = this.mRm;
      if (localObject1 != null)
      {
        localObject2 = (com.tencent.mm.live.core.core.trtc.sdkadapter.d)this;
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setListener(new com.tencent.mm.live.core.core.trtc.sdkadapter.b((com.tencent.mm.live.core.core.trtc.sdkadapter.d)localObject2));
      }
      localObject1 = this.mRm;
      if (localObject1 != null)
      {
        localObject2 = this.mRB;
        locala = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo();
        locale = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn();
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSD = ((com.tencent.mm.live.core.core.model.i)localObject2);
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.enableCustomVideoCapture(true);
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setDefaultStreamRecvMode(true, true);
        if (!locale.mTg) {
          break label679;
        }
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setLocalViewFillMode(0);
        label355:
        i = locale.mTo;
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setLocalViewRotation(i);
        if (!locala.mSL) {
          break label691;
        }
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setAudioRoute(0);
        label387:
        if (!locale.mTm) {
          break label703;
        }
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setGSensorMode(2);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).setSystemVolumeType(locala.mSG);
      bool = locale.eCF;
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setVideoEncoderMirror(bool);
      i = locale.mTh;
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setLocalViewMirror(i);
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).fL(false);
      beP().mTG = paramh.mNz.userId;
      beP().mTH = String.valueOf(paramh.mNz.roomId);
      this.mRB.mNM = paramh.mJH.mNo;
      localObject1 = beP();
      long l1 = paramh.mJH.appId;
      long l2 = paramh.mJH.mNp;
      if (l1 > 0L) {
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject1).mTJ = ((int)l1);
      }
      if (l2 > 0L) {
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject1).mTK = ((int)l2);
      }
      TXLog.i("MicroMsg.LiveCoreVisitor", "setQCloudAccount:appid: " + l1 + ", bizid: " + l2 + ", mCloudAppid: " + ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject1).mTJ + ", mCloudBizid: " + ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject1).mTK);
      Log.i("MicroMsg.LiveCore", "steve:setQCloudAccount qppid: %s, bizid: %s", new Object[] { Long.valueOf(paramh.mJH.appId), Long.valueOf(paramh.mJH.mNp) });
      return 0;
      localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).mNB;
      break;
      label663:
      bool = com.tencent.mm.media.widget.a.b.isFrontCamera();
      break label53;
      label670:
      ((com.tencent.mm.live.core.b.c)localObject1).scene = i;
      break label133;
      label679:
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setLocalViewFillMode(1);
      break label355;
      label691:
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setAudioRoute(1);
      break label387;
      label703:
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject1).mSx.setGSensorMode(0);
    }
  }
  
  public final int a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.b.a parama, com.tencent.mm.live.core.b.b paramb)
  {
    Object localObject1 = null;
    if (paramLivePreviewView == null)
    {
      Log.e("MicroMsg.LiveCore", "startPreview preiewView is null");
      return -3;
    }
    Object localObject2 = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.Ga(s.X("startPreview ", paramLivePreviewView));
    this.mRt = paramLivePreviewView;
    localObject2 = this.mRA;
    boolean bool1;
    label64:
    label85:
    boolean bool2;
    if (localObject2 == null)
    {
      bool1 = false;
      localObject2 = this.mRA;
      if (localObject2 != null) {
        break label306;
      }
      if (localObject1 != null) {
        break label343;
      }
      if ((this.mRv == null) || (com.tencent.mm.media.widget.a.b.isFrontCamera())) {
        break label331;
      }
      i = 1;
      if (i != 0) {
        break label337;
      }
      bool2 = true;
      label93:
      r(bool1, bool2);
      localObject1 = this.mRA;
      if (localObject1 == null) {
        break label353;
      }
      localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).mNB;
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.f)localObject1).mNk != true)) {
        break label353;
      }
      i = 1;
      label137:
      if (i != 0)
      {
        localObject1 = this.mRu;
        if (localObject1 != null) {
          ((com.tencent.mm.media.widget.a.f)localObject1).a(this.mRs.getFrameDataCallback());
        }
      }
      com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSJ = true;
      com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTi = true;
      localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfq();
      localObject2 = this.mRu;
      if (localObject2 != null) {
        break label359;
      }
    }
    label306:
    label331:
    label337:
    label343:
    label353:
    label359:
    for (int i = 0;; i = ((com.tencent.mm.media.widget.a.f)localObject2).btf())
    {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.b)localObject1).cameraId = i;
      paramLivePreviewView.a((kotlin.g.a.b)new a.i(this), (m)new a.j(this));
      this.mRs.a(parama);
      this.mRs.a(paramb);
      this.mRs.t((kotlin.g.a.b)new a.k(this));
      return 0;
      localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mNB;
      if (localObject2 == null)
      {
        bool1 = false;
        break;
      }
      bool1 = ((com.tencent.mm.live.core.core.model.f)localObject2).mNi;
      break;
      localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mNB;
      if (localObject2 == null) {
        break label64;
      }
      localObject1 = Boolean.valueOf(((com.tencent.mm.live.core.core.model.f)localObject2).mNj);
      break label64;
      i = 0;
      break label85;
      bool2 = false;
      break label93;
      bool2 = ((Boolean)localObject1).booleanValue();
      break label93;
      i = 0;
      break label137;
    }
  }
  
  public final void a(int paramInt, String paramString, TXAudioEffectManager.TXMusicPlayObserver paramTXMusicPlayObserver)
  {
    s.u(paramString, "path");
    Log.i("MicroMsg.LiveCore", "playBgMusic path:" + paramString + ", publish:true, loopCount:0" + ", listener:" + paramTXMusicPlayObserver);
    TXAudioEffectManager.AudioMusicParam localAudioMusicParam = this.mRH;
    if (localAudioMusicParam != null)
    {
      Log.i("MicroMsg.LiveCore", "already has playing music [" + localAudioMusicParam.path + ", " + localAudioMusicParam.publish + ", " + localAudioMusicParam.loopCount + "], stop it firstly.");
      beO().getAudioEffectManager().stopPlayMusic(localAudioMusicParam.id);
      beO().getAudioEffectManager().setMusicObserver(localAudioMusicParam.id, null);
    }
    this.mRH = H(paramInt, paramString);
    paramString = this.mRH;
    if (paramString != null)
    {
      beO().getAudioEffectManager().setMusicObserver(paramString.id, (TXAudioEffectManager.TXMusicPlayObserver)new a.c(paramTXMusicPlayObserver, this));
      beO().getAudioEffectManager().startPlayMusic(paramString);
    }
  }
  
  public final void a(com.tencent.mm.live.core.b.b paramb)
  {
    this.mRs.a(paramb);
  }
  
  public void a(com.tencent.mm.live.core.core.c paramc)
  {
    Object localObject1 = null;
    s.u(paramc, "callback");
    if (this.mRB.mNG == i.d.mOd)
    {
      i = 1;
      if (i == 0) {
        break label49;
      }
      Log.i("MicroMsg.LiveCore", "entering room or already room");
      this.mRw = paramc;
    }
    label49:
    Object localObject2;
    do
    {
      return;
      i = 0;
      break;
      localObject2 = com.tencent.mm.live.core.debug.a.mUy;
      com.tencent.mm.live.core.debug.a.Ga("start create room");
      localObject2 = this.mRB;
      Object localObject3 = this.mRA;
      if (localObject3 == null) {}
      while (((com.tencent.mm.live.core.core.model.i)localObject2).a((Long)localObject1))
      {
        localObject1 = com.tencent.mm.live.core.debug.a.mUy;
        com.tencent.mm.live.core.debug.a.Ga("enter room and already in room");
        com.tencent.mm.live.core.core.c.a.a(paramc, 0);
        return;
        localObject3 = ((com.tencent.mm.live.core.core.model.h)localObject3).mJH;
        if (localObject3 != null) {
          localObject1 = Long.valueOf(((com.tencent.mm.live.core.core.model.g)localObject3).liveId);
        }
      }
      this.mRw = paramc;
      paramc = this.mRB;
      localObject1 = i.d.mOd;
      s.u(localObject1, "status");
      paramc.mNG = ((i.d)localObject1);
      paramc = this.mRm;
    } while (paramc == null);
    int i = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSP;
    paramc.mSx.setAudioQuality(i);
    paramc.setSystemVolumeType(com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSG);
    boolean bool = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSM;
    if (bool)
    {
      paramc.mSx.enableAudioVolumeEvaluation(300);
      if (paramc.mSC != null) {
        paramc.mSC.fH(bool);
      }
      bool = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTq;
      localObject1 = new JSONObject();
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("api", "enableHevcEncode");
        localObject2 = new JSONObject();
        if (!bool) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject2).put("enable", i);
        ((JSONObject)localObject1).put("params", localObject2);
        paramc.mSx.callExperimentalAPI(((JSONObject)localObject1).toString());
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      paramc.mSx.enterRoom(paramc.mTRTCParams, paramc.mAppScene);
      return;
      paramc.mSx.enableAudioVolumeEvaluation(0);
      break;
      i = 0;
    }
  }
  
  public final void a(AbsLiveMiniView paramAbsLiveMiniView)
  {
    this.mRq.b(paramAbsLiveMiniView);
  }
  
  public final void a(LivePreviewView paramLivePreviewView)
  {
    if (paramLivePreviewView == null)
    {
      Log.e("MicroMsg.LiveCore", "startPreviewToRemote preiewView is null");
      return;
    }
    this.mRs.bgy();
    Object localObject = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.Ga(s.X("startPreview ", paramLivePreviewView));
    this.mRt = paramLivePreviewView;
    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSJ = true;
    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTi = true;
    paramLivePreviewView.a((kotlin.g.a.b)new a.o(this), (m)new a.p(this));
    paramLivePreviewView = this.mRu;
    int i;
    if ((paramLivePreviewView != null) && (paramLivePreviewView.bsD() == true))
    {
      i = 1;
      label107:
      if (i == 0) {
        break label190;
      }
      paramLivePreviewView = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfq();
      localObject = this.mRu;
      if (localObject != null) {
        break label192;
      }
      i = 0;
      label129:
      paramLivePreviewView.cameraId = i;
      Log.i("MicroMsg.LiveCore", "start preview success");
      localObject = this.mRs;
      paramLivePreviewView = this.mRu;
      if (paramLivePreviewView != null) {
        break label202;
      }
    }
    label190:
    label192:
    label202:
    for (paramLivePreviewView = null;; paramLivePreviewView = paramLivePreviewView.btc())
    {
      s.checkNotNull(paramLivePreviewView);
      ((com.tencent.mm.live.core.b.d)localObject).a(paramLivePreviewView);
      this.mRs.setOnDrawListener((kotlin.g.a.b)new a.q(this));
      return;
      i = 0;
      break label107;
      break;
      i = ((com.tencent.mm.media.widget.a.f)localObject).btf();
      break label129;
    }
  }
  
  public final void a(TRTCCloudDef.TRTCQuality paramTRTCQuality)
  {
    Object localObject;
    int i;
    if (paramTRTCQuality == null)
    {
      localObject = null;
      if (localObject != null) {
        break label180;
      }
      localObject = e.o.mLz;
      i = e.o.bdC();
      label21:
      if (i == 0) {
        break label282;
      }
      if (i > 2) {
        break label189;
      }
      localObject = e.o.mLz;
      i = e.o.bdC();
    }
    label282:
    for (;;)
    {
      label39:
      int j;
      if (paramTRTCQuality == null)
      {
        j = 0;
        label45:
        this.mRL = j;
        j = this.mRB.mNT;
        paramTRTCQuality = e.o.mLz;
        if (j == e.o.bdF()) {
          break label244;
        }
        paramTRTCQuality = e.o.mLz;
        if (i != e.o.bdF()) {
          break label244;
        }
        sY(1);
      }
      for (;;)
      {
        if (this.mRB.mNT != i)
        {
          this.mRB.mNT = i;
          Log.i("MicroMsg.LiveCore", s.X("onNetworkQuality, local:", Integer.valueOf(i)));
        }
        i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
        if (this.mRB.networkType != i) {
          this.mRB.networkType = i;
        }
        paramTRTCQuality = this.mRy;
        if (paramTRTCQuality != null)
        {
          localObject = e.g.mKv;
          com.tencent.mm.live.core.core.c.a.a(paramTRTCQuality, e.g.bcK());
        }
        return;
        localObject = Integer.valueOf(paramTRTCQuality.quality);
        break;
        label180:
        i = ((Integer)localObject).intValue();
        break label21;
        label189:
        if (i <= 4)
        {
          localObject = e.o.mLz;
          i = e.o.bdD();
          break label39;
        }
        if (i < 6)
        {
          localObject = e.o.mLz;
          i = e.o.bdE();
          break label39;
        }
        localObject = e.o.mLz;
        i = e.o.bdF();
        break label39;
        j = paramTRTCQuality.quality;
        break label45;
        label244:
        j = this.mRB.mNT;
        paramTRTCQuality = e.o.mLz;
        if (j == e.o.bdF())
        {
          paramTRTCQuality = e.o.mLz;
          if (i != e.o.bdF()) {
            sZ(1);
          }
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean, TextureView paramTextureView, View paramView)
  {
    Log.i("MicroMsg.LiveCore", s.X("switchScreenShareMode screenShareMode:", Boolean.valueOf(paramBoolean)));
    this.mRB.mNQ = paramBoolean;
    beP().fN(false);
    if (paramBoolean)
    {
      if (paramTextureView != null) {
        paramTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new a.v(this));
      }
      this.mRs.reset();
      paramTextureView = this.mRm;
      if (paramTextureView != null) {
        paramTextureView.fL(false);
      }
      if (this.mRB.bex()) {
        muteLocalVideo(false);
      }
      this.mRT = paramView;
      this.mRU.stopTimer();
      this.mRU.startTimer(0L, 100L);
    }
    do
    {
      return;
      paramTextureView = this.mRt;
      if (paramTextureView != null) {
        paramTextureView.a((kotlin.g.a.b)new a.w(this), (m)new a.x(this));
      }
      this.mRs.reset();
      beX();
    } while (!this.mRB.bex());
    paramTextureView = this.mRm;
    if (paramTextureView != null) {
      paramTextureView.fL(true);
    }
    muteLocalVideo(true);
  }
  
  public final void ai(float paramFloat1, float paramFloat2)
  {
    com.tencent.mm.live.core.core.trtc.sdkadapter.b.c localc;
    int i;
    int j;
    int k;
    int m;
    int i3;
    int i2;
    int i1;
    int n;
    if (this.hKC)
    {
      localc = beP();
      i = 720;
      j = 1280;
      if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTf)
      {
        i = 1280;
        j = 720;
      }
      k = 180;
      m = 320;
      if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTp)
      {
        k = 320;
        m = 180;
      }
      i3 = 50;
      i2 = 1500;
      switch (com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mSZ)
      {
      default: 
        i1 = m;
        n = i;
        m = j;
        j = i1;
        i1 = i3;
        i = i2;
        i2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mVideoBitrate;
        if (i2 > 0) {
          i = i2;
        }
        i2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTa;
        if (i2 <= 0) {
          break;
        }
      }
    }
    for (;;)
    {
      float f1 = paramFloat1 / bf.bf(MMApplicationContext.getContext()).x;
      f1 = n * f1;
      float f2 = paramFloat2 / bf.bf(MMApplicationContext.getContext()).y;
      f2 = m * f2;
      Log.i("MicroMsg.LiveCoreVisitor", "xOffset:%s, realXOffset:%s, yOffset:%s, realYOffset:%s, videoWidth:%s, videoHeight:%s, bitrate:%s,fps:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(f1), Float.valueOf(paramFloat2), Float.valueOf(f2), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(i2) });
      TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
      localTRTCTranscodingConfig.appId = localc.mTJ;
      localTRTCTranscodingConfig.bizId = localc.mTK;
      localTRTCTranscodingConfig.videoWidth = n;
      localTRTCTranscodingConfig.videoHeight = m;
      localTRTCTranscodingConfig.videoGOP = 1;
      localTRTCTranscodingConfig.videoFramerate = i2;
      localTRTCTranscodingConfig.videoBitrate = i;
      localTRTCTranscodingConfig.audioSampleRate = 48000;
      localTRTCTranscodingConfig.audioBitrate = 64;
      if (com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSP == 3) {
        localTRTCTranscodingConfig.audioBitrate = 128;
      }
      localTRTCTranscodingConfig.audioChannels = 2;
      Object localObject1 = new TRTCCloudDef.TRTCMixUser();
      ((TRTCCloudDef.TRTCMixUser)localObject1).userId = localc.mTG;
      ((TRTCCloudDef.TRTCMixUser)localObject1).zOrder = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).x = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).y = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).width = n;
      ((TRTCCloudDef.TRTCMixUser)localObject1).height = m;
      localTRTCTranscodingConfig.mixUsers = new ArrayList();
      localTRTCTranscodingConfig.mixUsers.add(localObject1);
      if (com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTn)
      {
        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + localc.mTF.size());
        localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().mTz;
        label821:
        label1734:
        label1750:
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          label600:
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)((Iterator)localObject1).next();
            TRTCCloudDef.TRTCMixUser localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
            com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d locald = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfp();
            if ((locald.mST) && (((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)localObject2).luk.equalsIgnoreCase(locald.mSS))) {
              localTRTCMixUser.roomId = locald.mSR;
            }
            localTRTCMixUser.userId = ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)localObject2).luk;
            localTRTCMixUser.streamType = ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)localObject2).mStreamType;
            localTRTCMixUser.zOrder = (i + 1);
            localTRTCMixUser.pureAudio = true;
            localObject2 = localc.FW(localTRTCMixUser.userId);
            if (localObject2 != null)
            {
              localTRTCMixUser.pureAudio = ((c.b)localObject2).mTR;
              if (i >= 3) {
                break label1767;
              }
              if (((c.b)localObject2).x != 0) {
                break label1734;
              }
              localTRTCMixUser.x = (n - 5 - k + (int)f1);
              label764:
              localTRTCMixUser.x = Math.max(Math.min(n - k, localTRTCMixUser.x), 0);
              ((c.b)localObject2).x = localTRTCMixUser.x;
              if (((c.b)localObject2).y != 0) {
                break label1750;
              }
              localTRTCMixUser.y = (i * j + i1 + (int)f2);
              localTRTCMixUser.y = Math.max(Math.min(m - j, localTRTCMixUser.y), 0);
              ((c.b)localObject2).y = localTRTCMixUser.y;
              localTRTCMixUser.width = k;
              localTRTCMixUser.height = j;
            }
            for (;;)
            {
              TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + localTRTCMixUser.userId + ", pureAudioMode: " + localTRTCMixUser.pureAudio);
              localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
              i += 1;
              break label600;
              n = 160;
              m = 160;
              i = 27;
              j = 48;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTp)
              {
                i = 48;
                j = 27;
              }
              i2 = 200;
              i1 = 20;
              k = i;
              i = i2;
              break;
              i = 192;
              j = 336;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTf)
              {
                i = 336;
                j = 192;
              }
              k = 54;
              m = 96;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTp)
              {
                k = 96;
                m = 54;
              }
              i1 = 30;
              i3 = 400;
              n = j;
              i2 = i;
              i = i3;
              j = m;
              m = n;
              n = i2;
              break;
              i = 240;
              j = 320;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTf)
              {
                i = 320;
                j = 240;
              }
              k = 54;
              m = 96;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTp)
              {
                k = 96;
                m = 54;
              }
              i1 = 400;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              n = 480;
              i = 72;
              j = 128;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTp)
              {
                i = 128;
                j = 72;
              }
              i1 = 600;
              k = i;
              m = 480;
              i = i1;
              i1 = i3;
              break;
              i = 368;
              j = 640;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTf)
              {
                i = 640;
                j = 368;
              }
              k = 90;
              m = 160;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTp)
              {
                k = 160;
                m = 90;
              }
              i1 = 800;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              i = 480;
              j = 640;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTf)
              {
                i = 640;
                j = 480;
              }
              k = 90;
              m = 160;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTp)
              {
                k = 160;
                m = 90;
              }
              i1 = 800;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              i = 544;
              j = 960;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTf)
              {
                i = 960;
                j = 544;
              }
              k = 171;
              m = 304;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTp)
              {
                k = 304;
                m = 171;
              }
              i1 = 1000;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              i = 720;
              j = 1280;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTf)
              {
                i = 1280;
                j = 720;
              }
              k = 180;
              m = 320;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTp)
              {
                k = 320;
                m = 180;
              }
              i1 = 1500;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              i = 1088;
              j = 1920;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTf)
              {
                i = 1920;
                j = 1088;
              }
              k = 272;
              m = 480;
              if (!com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTp)
              {
                k = 480;
                m = 272;
              }
              i1 = 1900;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              localTRTCMixUser.x = (((c.b)localObject2).x + (int)f1);
              break label764;
              localTRTCMixUser.y = (((c.b)localObject2).y + (int)f2);
              break label821;
              label1767:
              if (i < 6)
              {
                localTRTCMixUser.x = 5;
                localTRTCMixUser.y = (m - i1 - (i - 3) * j - j);
                localTRTCMixUser.width = k;
                localTRTCMixUser.height = j;
              }
            }
          }
        }
      }
      boolean bool1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTq;
      boolean bool2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTr;
      if ((bool1) && (bool2)) {}
      for (i = 1;; i = 0)
      {
        Log.i("MicroMsg.LiveCoreVisitor", "cloudmixing,is265:%b, forceMixing:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((i == 0) && ((localTRTCTranscodingConfig.mixUsers == null) || (localTRTCTranscodingConfig.mixUsers.size() <= 1))) {
          break;
        }
        localc.mSx.setMixTranscodingConfig(localTRTCTranscodingConfig);
        Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", new Object[] { localTRTCTranscodingConfig, Boolean.valueOf(bool1) });
        return;
      }
      localc.mSx.setMixTranscodingConfig(null);
      Log.i("MicroMsg.LiveCoreVisitor", "cancel cloudmixturing");
      return;
      i2 = 15;
    }
  }
  
  public final void al(byte[] paramArrayOfByte)
  {
    int i = 0;
    Object localObject = this.mRA;
    if (localObject == null) {}
    for (;;)
    {
      if (i > 0) {
        h(i, paramArrayOfByte);
      }
      return;
      localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mJH;
      if (localObject != null) {
        i = ((com.tencent.mm.live.core.core.model.g)localObject).mNu;
      }
    }
  }
  
  public final TXCloudVideoView ax(String paramString, int paramInt)
  {
    LivePreviewView localLivePreviewView = this.mRt;
    if (localLivePreviewView == null) {
      return null;
    }
    return localLivePreviewView.az(paramString, paramInt);
  }
  
  public final void b(com.tencent.mm.live.core.core.c paramc)
  {
    Object localObject1 = null;
    s.u(paramc, "callback");
    Object localObject2 = com.tencent.mm.live.core.mini.c.mUS;
    localObject2 = this.mRB;
    Object localObject3 = this.mRA;
    if (localObject3 == null) {}
    while (!((com.tencent.mm.live.core.core.model.i)localObject2).a((Long)localObject1))
    {
      localObject1 = com.tencent.mm.live.core.debug.a.mUy;
      com.tencent.mm.live.core.debug.a.Ga("already exit room");
      bce();
      com.tencent.mm.live.core.core.c.a.a(paramc, 0);
      return;
      localObject3 = ((com.tencent.mm.live.core.core.model.h)localObject3).mJH;
      if (localObject3 != null) {
        localObject1 = Long.valueOf(((com.tencent.mm.live.core.core.model.g)localObject3).liveId);
      }
    }
    bce();
    this.mRx = paramc;
    paramc = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.Ga("start exit room");
    paramc = this.mRm;
    if ((paramc != null) && (paramc.mSx != null)) {
      paramc.mSx.exitRoom();
    }
    paramc = this.mRB;
    paramc.mNG = i.d.mOb;
    paramc.mNL = -1L;
  }
  
  public final int bce()
  {
    try
    {
      Log.i("MicroMsg.LiveCore", "release");
      this.mRs.H((kotlin.g.a.a)new a.u(this));
      return 0;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, s.X("camera release error:", localException.getMessage()), new Object[0]);
    }
    return 0;
  }
  
  public final void bcf()
  {
    Object localObject = this.mRu;
    com.tencent.mm.live.core.core.trtc.sdkadapter.feature.b localb;
    com.tencent.mm.media.widget.a.f localf;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.a.f)localObject).btc();
      if (localObject != null)
      {
        localb = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfq();
        localf = this.mRu;
        if (localf != null) {
          break label54;
        }
      }
    }
    label54:
    for (int i = 0;; i = localf.btf())
    {
      localb.cameraId = i;
      this.mRs.a((com.tencent.mm.media.widget.a.b)localObject);
      return;
    }
  }
  
  public void bcg()
  {
    this.mRB.mNK = i.e.mOf;
    this.mRP = null;
  }
  
  public final com.tencent.mm.live.core.core.model.i bch()
  {
    return this.mRB;
  }
  
  public final void bci()
  {
    this.mRB.mNK = i.e.mOf;
    beY();
  }
  
  public final TRTCCloud beO()
  {
    return (TRTCCloud)this.mRj.getValue();
  }
  
  protected final com.tencent.mm.live.core.core.trtc.sdkadapter.b.c beP()
  {
    return (com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)this.mRl.getValue();
  }
  
  protected final com.tencent.mm.live.core.core.trtc.sdkadapter.c beQ()
  {
    return this.mRm;
  }
  
  protected final com.tencent.mm.live.core.core.c beR()
  {
    return this.mRw;
  }
  
  protected final void beS()
  {
    this.mRw = null;
  }
  
  protected final void beT()
  {
    this.mRx = null;
  }
  
  protected final com.tencent.mm.live.core.core.c beU()
  {
    return this.mRz;
  }
  
  protected final int beV()
  {
    return this.mRG;
  }
  
  public final void beY()
  {
    this.mRq.bfQ();
    b localb = this.mRr;
    if (localb != null) {
      localb.bfj();
    }
  }
  
  public boolean beZ()
  {
    return false;
  }
  
  public final void bew()
  {
    this.mRB.bew();
    Object localObject = (com.tencent.mm.live.core.core.b)this;
    Drawable localDrawable = MMApplicationContext.getContext().getResources().getDrawable(com.tencent.mm.live.core.a.f.mic_user_leave);
    s.s(localDrawable, "getContext().resources.g…ble(R.raw.mic_user_leave)");
    ((com.tencent.mm.live.core.core.b)localObject).G(com.tencent.mm.ae.d.drawable2Bitmap(localDrawable));
    muteLocalVideo(false);
    muteLocalAudio(false);
    beP().fN(false);
    localObject = this.mRm;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).fL(this.mRB.bex());
    }
  }
  
  public final void bfa()
  {
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = this.mRm;
    if (localc != null) {
      if ((!this.mRB.bex()) || (this.mRB.mNQ)) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      localc.fL(bool);
      return;
    }
  }
  
  public final void bfc()
  {
    Object localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().mTz;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    beP().mTF.clear();
    int i = this.mRN;
    localObject = e.h.mKY;
    if (i == e.h.bdi())
    {
      beP().bfw();
      return;
    }
    i = this.mRN;
    localObject = e.h.mKY;
    if (i == e.h.bdj())
    {
      beP().fN(true);
      return;
    }
    Log.w("MicroMsg.LiveCore", s.X("resetMixtureParams invalid live scene: ", Integer.valueOf(this.mRN)));
  }
  
  public final void bfd()
  {
    StringBuilder localStringBuilder = new StringBuilder("stopBgMusic path:");
    Object localObject = this.mRH;
    if (localObject == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append(", publish:");
      localObject = this.mRH;
      if (localObject != null) {
        break label143;
      }
      localObject = null;
      label45:
      localStringBuilder = localStringBuilder.append(localObject).append(", loopCount:");
      localObject = this.mRH;
      if (localObject != null) {
        break label154;
      }
    }
    label143:
    label154:
    for (localObject = null;; localObject = Integer.valueOf(((TXAudioEffectManager.AudioMusicParam)localObject).loopCount))
    {
      Log.i("MicroMsg.LiveCore", localObject);
      localObject = this.mRH;
      if (localObject != null)
      {
        beO().getAudioEffectManager().stopPlayMusic(((TXAudioEffectManager.AudioMusicParam)localObject).id);
        beO().getAudioEffectManager().setMusicObserver(((TXAudioEffectManager.AudioMusicParam)localObject).id, null);
        this.mRH = null;
        this.mRI = false;
      }
      return;
      localObject = ((TXAudioEffectManager.AudioMusicParam)localObject).path;
      break;
      localObject = Boolean.valueOf(((TXAudioEffectManager.AudioMusicParam)localObject).publish);
      break label45;
    }
  }
  
  public final void bfe()
  {
    Object localObject = this.mRB;
    Log.i("MicroMsg.LiveStatus", s.X("pauseLive,liveMode:", ((com.tencent.mm.live.core.core.model.i)localObject).mNP));
    ((com.tencent.mm.live.core.core.model.i)localObject).pause = true;
    localObject = (com.tencent.mm.live.core.core.b)this;
    Drawable localDrawable = MMApplicationContext.getContext().getResources().getDrawable(com.tencent.mm.live.core.a.f.mic_user_leave);
    s.s(localDrawable, "getContext().resources.g…ble(R.raw.mic_user_leave)");
    ((com.tencent.mm.live.core.core.b)localObject).G(com.tencent.mm.ae.d.drawable2Bitmap(localDrawable));
    muteLocalAudio(true);
    muteLocalVideo(true);
    bce();
  }
  
  public final void bff()
  {
    int i = 0;
    Object localObject = this.mRB;
    Log.i("MicroMsg.LiveStatus", s.X("resumeLive,liveMode:", ((com.tencent.mm.live.core.core.model.i)localObject).mNP));
    ((com.tencent.mm.live.core.core.model.i)localObject).pause = false;
    if (this.mRB.mNP == i.c.mNY) {
      i = 1;
    }
    if (i != 0)
    {
      bew();
      return;
    }
    if (this.mRB.bex())
    {
      localObject = MMApplicationContext.getContext().getResources().getDrawable(com.tencent.mm.live.core.a.c.live_audio_mode_frame);
      s.s(localObject, "getContext().resources.g…le.live_audio_mode_frame)");
      H(com.tencent.mm.ae.d.drawable2Bitmap((Drawable)localObject));
      return;
    }
    Log.i("MicroMsg.LiveCore", "resumeLive error");
  }
  
  public final void bfg()
  {
    com.tencent.thumbplayer.g.b localb = this.mSc;
    if (localb != null) {
      localb.stop();
    }
    localb = this.mSc;
    if (localb != null) {
      localb.release();
    }
    this.mSc = null;
  }
  
  public final void bfh()
  {
    beP().fN(false);
  }
  
  public final JSONObject bfi()
  {
    return beP().mTO;
  }
  
  public final void c(com.tencent.mm.live.core.core.c paramc)
  {
    this.mRy = paramc;
  }
  
  public final void callLiveExperimentalAPI(String paramString)
  {
    beO().callExperimentalAPI(paramString);
  }
  
  public final void d(com.tencent.mm.live.core.core.c paramc)
  {
    s.u(paramc, "callback");
    this.mRz = paramc;
  }
  
  public Point dB(Context paramContext)
  {
    s.u(paramContext, "context");
    return new Point(bd.bs(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.float_ball_voip_view_video_width), bd.bs(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.float_ball_voip_view_video_height));
  }
  
  public final void eg(int paramInt1, int paramInt2)
  {
    this.mRQ.set(paramInt1, paramInt2);
  }
  
  public final void fH(boolean paramBoolean)
  {
    Log.i("MicroMsg.LiveCore", s.X("onAudioVolumeEvaluationChange:", Boolean.valueOf(paramBoolean)));
  }
  
  public final void fI(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setAudioCaptureVolume(0);
      return;
    }
    setAudioCaptureVolume(this.mRO);
  }
  
  public int getRecordScene()
  {
    return 13;
  }
  
  public int getResolutionLimit()
  {
    Object localObject = this.mRA;
    if (localObject == null) {}
    do
    {
      return 1080;
      localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mNB;
    } while (localObject == null);
    return ((com.tencent.mm.live.core.core.model.f)localObject).mNl;
  }
  
  protected final void h(int paramInt, byte[] paramArrayOfByte)
  {
    com.tencent.threadpool.h.ahAA.g(new a..ExternalSyntheticLambda2(paramInt, paramArrayOfByte, this), "Sei_Message_Handler");
  }
  
  public final void muteLocalAudio(boolean paramBoolean)
  {
    Log.i("MicroMsg.LiveCore", s.X("muteLocalAudio ", Boolean.valueOf(paramBoolean)));
    beO().muteLocalAudio(paramBoolean);
  }
  
  public final void muteLocalVideo(boolean paramBoolean)
  {
    Log.i("MicroMsg.LiveCore", s.X("muteLocalVideo ", Boolean.valueOf(paramBoolean)));
    beO().muteLocalVideo(paramBoolean);
  }
  
  public final void onConnectOtherRoom(String paramString1, int paramInt, String paramString2)
  {
    Log.i("MicroMsg.LiveCore", "onConnectOtherRoom, userID:" + paramString1 + ", err:" + paramInt + ", errMsg:$" + paramString2);
    if (paramInt == 0)
    {
      paramString2 = new Bundle();
      Object localObject = e.d.mKj;
      paramString2.putString(e.d.bcx(), paramString1);
      paramString1 = this.mRy;
      if (paramString1 != null)
      {
        localObject = e.g.mKv;
        paramString1.callback(e.g.bcP(), paramString2);
      }
    }
  }
  
  public final void onDisConnectOtherRoom(int paramInt, String paramString)
  {
    Log.i("MicroMsg.LiveCore", "onDisConnectOtherRoom, err:" + paramInt + ", errMsg:" + paramString);
    if (paramInt == 0)
    {
      paramString = new Bundle();
      com.tencent.mm.live.core.core.c localc = this.mRy;
      if (localc != null)
      {
        e.g localg = e.g.mKv;
        localc.callback(e.g.bcQ(), paramString);
      }
    }
  }
  
  public void onEnterRoom(long paramLong)
  {
    long l = -1L;
    Object localObject1 = com.tencent.mm.live.core.debug.a.mUy;
    localObject1 = new StringBuilder("create room ret:").append(paramLong).append('(');
    Object localObject2 = com.tencent.mm.live.core.a.a.mUB;
    com.tencent.mm.live.core.debug.a.Ga(com.tencent.mm.live.core.a.a.td((int)paramLong) + ')');
    localObject1 = this.mRw;
    if (localObject1 != null) {
      com.tencent.mm.live.core.core.c.a.a((com.tencent.mm.live.core.core.c)localObject1, (int)paramLong);
    }
    this.mRw = null;
    localObject1 = this.mRB;
    localObject2 = this.mRA;
    if (localObject2 == null) {}
    for (;;)
    {
      ((com.tencent.mm.live.core.core.model.i)localObject1).mNG = i.d.mOc;
      ((com.tencent.mm.live.core.core.model.i)localObject1).mNL = l;
      if ((paramLong >= 0L) && (this.hKC))
      {
        boolean bool1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTq;
        boolean bool2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTr;
        Log.i("MicroMsg.LiveCore", "onEnterRoom hevcenable:" + bool1 + ", force265Mixing:" + bool2);
        if ((bool1) && (bool2)) {
          beP().bfw();
        }
      }
      return;
      localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mJH;
      if (localObject2 != null) {
        l = ((com.tencent.mm.live.core.core.model.g)localObject2).liveId;
      }
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    paramBundle = new Bundle();
    paramBundle.putInt("live_err_code", paramInt);
    com.tencent.mm.live.core.core.c localc = this.mRy;
    if (localc != null)
    {
      e.g localg = e.g.mKv;
      localc.callback(e.g.bcL(), paramBundle);
    }
    paramBundle = com.tencent.mm.live.core.debug.a.mUy;
    paramString = new StringBuilder("[").append(paramInt).append("]msg:").append(paramString).append('(');
    paramBundle = com.tencent.mm.live.core.a.a.mUB;
    com.tencent.mm.live.core.debug.a.Ga(com.tencent.mm.live.core.a.a.td(paramInt) + ')');
  }
  
  public void onExitRoom(int paramInt)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.mUy;
    localObject1 = new StringBuilder("[").append(paramInt).append("]end exit room.(");
    Object localObject2 = com.tencent.mm.live.core.a.a.mUB;
    com.tencent.mm.live.core.debug.a.Ga(com.tencent.mm.live.core.a.a.td(paramInt) + ')');
    localObject1 = this.mRx;
    if (localObject1 != null) {
      com.tencent.mm.live.core.core.c.a.a((com.tencent.mm.live.core.core.c)localObject1, paramInt);
    }
    if (paramInt != 0)
    {
      localObject1 = this.mRy;
      if (localObject1 != null)
      {
        localObject2 = e.g.mKv;
        com.tencent.mm.live.core.core.c.a.a((com.tencent.mm.live.core.core.c)localObject1, e.g.bcN());
      }
    }
    this.mRx = null;
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.Ga("[sdk]onFirstVideoFrame uid:" + paramString + " ,streamType:" + paramInt1 + " width:" + paramInt2 + " height:" + paramInt3);
    localObject = new Bundle();
    ((Bundle)localObject).putString("live_user_id", paramString);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_stream_type", paramInt1);
    ((Bundle)localObject).putInt("live_first_frame_width", paramInt2);
    ((Bundle)localObject).putInt("live_first_frame_height", paramInt3);
    paramString = this.mRy;
    if (paramString != null)
    {
      e.g localg = e.g.mKv;
      paramString.callback(e.g.bcO(), (Bundle)localObject);
    }
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.Ga("[sdk]onRemoteUserLeaveRoom:" + paramString + " reason:" + paramInt);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("live_user_id", paramString);
    ((Bundle)localObject1).putInt("live_user_exit_reason", paramInt);
    paramInt = this.mRN;
    Object localObject2 = e.h.mKY;
    if (paramInt == e.h.bdj())
    {
      localObject2 = this.mRt;
      if (localObject2 != null) {
        ((LivePreviewView)localObject2).Gg(paramString);
      }
    }
    localObject2 = this.mRy;
    if (localObject2 != null)
    {
      e.g localg = e.g.mKv;
      ((com.tencent.mm.live.core.core.c)localObject2).callback(e.g.bcI(), (Bundle)localObject1);
    }
    localObject1 = beP();
    com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().FS(paramString);
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject1).FZ(paramString);
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject1).mSx.stopRemoteView(paramString);
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject1).mSx.stopRemoteSubStreamView(paramString);
    localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfp();
    if (paramString.equals(((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mSS)) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).reset();
    }
    beP().FX(paramString);
    if (this.hKC)
    {
      paramInt = this.mRN;
      paramString = e.h.mKY;
      if (paramInt == e.h.bdj()) {
        beP().fN(false);
      }
    }
    else
    {
      return;
    }
    Log.w("MicroMsg.LiveCore", s.X("invalid live scene: ", Integer.valueOf(this.mRN)));
  }
  
  public final void onStatistics(TRTCStatistics paramTRTCStatistics)
  {
    long l2 = 0L;
    int j = 0;
    Log.i("MicroMsg.LiveCore", s.X("onStatistics, statics:", paramTRTCStatistics));
    Bundle localBundle = new Bundle();
    Object localObject1 = e.s.mLT;
    localObject1 = e.s.bdY();
    Object localObject2 = com.tencent.mm.live.core.d.c.mWN;
    localBundle.putString((String)localObject1, com.tencent.mm.live.core.d.c.a(paramTRTCStatistics));
    localObject1 = e.s.mLT;
    localObject1 = e.s.bdM();
    localObject2 = this.mRA;
    label176:
    label194:
    int i;
    if (localObject2 == null)
    {
      l1 = 0L;
      localBundle.putLong((String)localObject1, l1);
      localObject1 = e.s.mLT;
      localObject1 = e.s.bdN();
      localObject2 = e.p.mLE;
      localBundle.putInt((String)localObject1, e.p.bdG());
      localObject1 = e.s.mLT;
      localObject1 = e.s.bdO();
      localObject2 = e.b.mKf;
      localBundle.putInt((String)localObject1, e.b.bct());
      localObject1 = e.s.mLT;
      localBundle.putLong(e.s.bdP(), System.currentTimeMillis());
      localObject1 = e.s.mLT;
      localObject1 = e.s.bdQ();
      localObject2 = this.mRA;
      if (localObject2 != null) {
        break label524;
      }
      l1 = 0L;
      localBundle.putLong((String)localObject1, l1);
      if (paramTRTCStatistics != null) {
        break label552;
      }
      localObject1 = "";
      localBundle.putString("CPU_USAGE", (String)localObject1);
      if (paramTRTCStatistics != null) {
        break label581;
      }
      i = 0;
      label210:
      localBundle.putInt("VIDEO_WIDTH", i);
      if (paramTRTCStatistics != null) {
        break label629;
      }
      i = 0;
      label225:
      localBundle.putInt("VIDEO_HEIGHT", i);
      if (paramTRTCStatistics != null) {
        break label677;
      }
      i = 0;
      label240:
      localBundle.putInt("VIDEO_BITRATE", i);
      if (paramTRTCStatistics != null) {
        break label725;
      }
      i = 0;
      label255:
      localBundle.putInt("AUDIO_BITRATE", i);
      if (paramTRTCStatistics != null) {
        break label773;
      }
      i = 0;
      label270:
      localBundle.putInt("VIDEO_FPS", i);
      localBundle.putInt("NET_SPEED", CdnLogic.getRecentAverageSpeed(2));
      localObject1 = e.s.mLT;
      localObject1 = e.s.bdX();
      if (paramTRTCStatistics != null) {
        break label821;
      }
      i = 0;
      label307:
      localBundle.putInt((String)localObject1, i);
      localObject1 = e.s.mLT;
      localObject1 = e.s.bdR();
      if (paramTRTCStatistics != null) {
        break label869;
      }
      i = 0;
      label331:
      localBundle.putInt((String)localObject1, i);
      localObject1 = e.s.mLT;
      localObject1 = e.s.bdS();
      if (paramTRTCStatistics != null) {
        break label877;
      }
      i = 0;
      label355:
      localBundle.putInt((String)localObject1, i);
      localObject1 = e.s.mLT;
      localObject1 = e.s.bdT();
      if (paramTRTCStatistics != null) {
        break label885;
      }
      i = j;
      label379:
      localBundle.putInt((String)localObject1, i);
      localObject1 = e.s.mLT;
      localObject1 = e.s.bdU();
      if (paramTRTCStatistics != null) {
        break label893;
      }
      l1 = 0L;
      label404:
      localBundle.putLong((String)localObject1, l1);
      localObject1 = e.s.mLT;
      localObject1 = e.s.bdV();
      if (paramTRTCStatistics != null) {
        break label902;
      }
    }
    label773:
    label902:
    for (long l1 = l2;; l1 = paramTRTCStatistics.receiveBytes)
    {
      localBundle.putLong((String)localObject1, l1);
      paramTRTCStatistics = e.s.mLT;
      localBundle.putInt(e.s.bdW(), NetStatusUtil.getNetType(MMApplicationContext.getContext()));
      localBundle.putInt("NET_QUALITY_LEVEL", this.mRL);
      paramTRTCStatistics = this.mRy;
      if (paramTRTCStatistics != null)
      {
        localObject1 = e.g.mKv;
        paramTRTCStatistics.callback(e.g.bcS(), localBundle);
      }
      return;
      localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mJH;
      if (localObject2 == null)
      {
        l1 = 0L;
        break;
      }
      l1 = ((com.tencent.mm.live.core.core.model.g)localObject2).liveId;
      break;
      label524:
      localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mJH;
      if (localObject2 == null)
      {
        l1 = 0L;
        break label176;
      }
      l1 = ((com.tencent.mm.live.core.core.model.g)localObject2).startTime;
      break label176;
      label552:
      localObject2 = Integer.valueOf(paramTRTCStatistics.appCpu).toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label194;
      }
      localObject1 = "";
      break label194;
      label581:
      localObject1 = paramTRTCStatistics.localArray;
      if (localObject1 == null)
      {
        i = 0;
        break label210;
      }
      localObject1 = (TRTCStatistics.TRTCLocalStatistics)p.oL((List)localObject1);
      if (localObject1 == null)
      {
        i = 0;
        break label210;
      }
      i = ((TRTCStatistics.TRTCLocalStatistics)localObject1).width;
      break label210;
      label629:
      localObject1 = paramTRTCStatistics.localArray;
      if (localObject1 == null)
      {
        i = 0;
        break label225;
      }
      localObject1 = (TRTCStatistics.TRTCLocalStatistics)p.oL((List)localObject1);
      if (localObject1 == null)
      {
        i = 0;
        break label225;
      }
      i = ((TRTCStatistics.TRTCLocalStatistics)localObject1).height;
      break label225;
      label677:
      localObject1 = paramTRTCStatistics.localArray;
      if (localObject1 == null)
      {
        i = 0;
        break label240;
      }
      localObject1 = (TRTCStatistics.TRTCLocalStatistics)p.oL((List)localObject1);
      if (localObject1 == null)
      {
        i = 0;
        break label240;
      }
      i = ((TRTCStatistics.TRTCLocalStatistics)localObject1).videoBitrate;
      break label240;
      label725:
      localObject1 = paramTRTCStatistics.localArray;
      if (localObject1 == null)
      {
        i = 0;
        break label255;
      }
      localObject1 = (TRTCStatistics.TRTCLocalStatistics)p.oL((List)localObject1);
      if (localObject1 == null)
      {
        i = 0;
        break label255;
      }
      i = ((TRTCStatistics.TRTCLocalStatistics)localObject1).audioBitrate;
      break label255;
      localObject1 = paramTRTCStatistics.localArray;
      if (localObject1 == null)
      {
        i = 0;
        break label270;
      }
      localObject1 = (TRTCStatistics.TRTCLocalStatistics)p.oL((List)localObject1);
      if (localObject1 == null)
      {
        i = 0;
        break label270;
      }
      i = ((TRTCStatistics.TRTCLocalStatistics)localObject1).frameRate;
      break label270;
      label821:
      localObject2 = paramTRTCStatistics.localArray;
      if (localObject2 == null)
      {
        i = 0;
        break label307;
      }
      localObject2 = (TRTCStatistics.TRTCLocalStatistics)p.oL((List)localObject2);
      if (localObject2 == null)
      {
        i = 0;
        break label307;
      }
      i = ((TRTCStatistics.TRTCLocalStatistics)localObject2).audioCaptureState;
      break label307;
      label869:
      i = paramTRTCStatistics.rtt;
      break label331;
      label877:
      i = paramTRTCStatistics.upLoss;
      break label355;
      label885:
      i = paramTRTCStatistics.downLoss;
      break label379;
      label893:
      l1 = paramTRTCStatistics.sendBytes;
      break label404;
    }
  }
  
  public final void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", "[sdk]onUserAudioAvailable:" + paramString + ", available:" + paramBoolean + ", isAnchor:" + this.hKC);
    if (paramBoolean) {
      if (!TextUtils.isEmpty((CharSequence)paramString))
      {
        i = this.mRN;
        localObject = e.h.mKY;
        if (i == e.h.bdj())
        {
          localObject = this.mRt;
          if (localObject != null) {
            ((LivePreviewView)localObject).az(paramString, 0);
          }
        }
        beP();
        localObject = new c.b((byte)0);
        ((c.b)localObject).userId = paramString;
        ((c.b)localObject).streamType = 0;
        if (com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().FU(paramString) == null)
        {
          localObject = new com.tencent.mm.live.core.core.trtc.sdkadapter.b.a(paramString, (byte)0);
          com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().a((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)localObject);
        }
      }
    }
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("live_user_id", paramString);
      ((Bundle)localObject).putBoolean("live_media_enable", paramBoolean);
      paramString = this.mRy;
      if (paramString != null)
      {
        e.g localg = e.g.mKv;
        paramString.callback(e.g.bcJ(), (Bundle)localObject);
      }
      if (this.hKC)
      {
        i = this.mRN;
        paramString = e.h.mKY;
        if (i != e.h.bdi()) {
          break;
        }
        beP().bfw();
      }
      return;
      beP();
    }
    int i = this.mRN;
    paramString = e.h.mKY;
    if ((i == e.h.bdj()) && (paramBoolean))
    {
      beP().fN(false);
      return;
    }
    Log.w("MicroMsg.LiveCore", s.X("invalid live scene: ", Integer.valueOf(this.mRN)));
  }
  
  public final void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.Ga("onUserSubStreamAvailable:" + paramString + ", available:" + paramBoolean);
  }
  
  public final void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.Ga("onUserVideoAvailable uid:" + paramString + " available:" + paramBoolean + ", isAnchor:" + this.hKC);
    Object localObject2;
    e.g localg;
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      localObject2 = beP();
      localObject1 = this.mRt;
      if (localObject1 == null)
      {
        localObject1 = null;
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject2).a(paramString, (TXCloudVideoView)localObject1);
        if ((!this.hKC) && (Util.isEqual(this.mRB.mNM, paramString)))
        {
          localObject1 = this.mRt;
          if (localObject1 != null) {
            ((LivePreviewView)localObject1).Gf(paramString);
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("live_user_id", paramString);
        localObject2 = this.mRy;
        if (localObject2 != null)
        {
          localg = e.g.mKv;
          ((com.tencent.mm.live.core.core.c)localObject2).callback(e.g.bcH(), (Bundle)localObject1);
        }
      }
    }
    for (;;)
    {
      if ((!this.hKC) && (!Util.isEqual(this.mRB.mNM, paramString))) {
        this.mRB.mNO = paramString;
      }
      if (this.hKC)
      {
        i = this.mRN;
        paramString = e.h.mKY;
        if (i != e.h.bdi()) {
          break label334;
        }
        beP().bfw();
      }
      return;
      localObject1 = ((LivePreviewView)localObject1).az(paramString, 0);
      break;
      i = this.mRN;
      localObject1 = e.h.mKY;
      if (i == e.h.bdi())
      {
        localObject1 = this.mRt;
        if (localObject1 != null) {
          ((LivePreviewView)localObject1).Gg(paramString);
        }
      }
      beP();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("live_user_id", paramString);
      localObject2 = this.mRy;
      if (localObject2 != null)
      {
        localg = e.g.mKv;
        ((com.tencent.mm.live.core.core.c)localObject2).callback(e.g.bcM(), (Bundle)localObject1);
      }
    }
    label334:
    int i = this.mRN;
    paramString = e.h.mKY;
    if ((i == e.h.bdj()) && (paramBoolean))
    {
      beP().fN(false);
      return;
    }
    Log.w("MicroMsg.LiveCore", s.X("invalid live scene: ", Integer.valueOf(this.mRN)));
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("userVolumeSize:");
    if (paramArrayList == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramArrayList.size()))
    {
      localStringBuilder2.append(localObject).append(",totalVolume:").append(paramInt);
      if (paramArrayList == null) {
        break;
      }
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (TRTCCloudDef.TRTCVolumeInfo)paramArrayList.next();
        localStringBuilder1.append(" [" + ((TRTCCloudDef.TRTCVolumeInfo)localObject).userId + ", " + ((TRTCCloudDef.TRTCVolumeInfo)localObject).volume + ']');
      }
    }
    Log.i("MicroMsg.LiveCore", localStringBuilder1.toString());
  }
  
  public final void onWarning(int paramInt, String paramString, Bundle paramBundle)
  {
    boolean bool1 = true;
    if (paramInt == 1104)
    {
      if (paramBundle != null) {
        paramBundle.getString("EVT_MSG");
      }
      if (paramBundle != null) {
        break label171;
      }
      paramInt = 0;
      if (paramInt != 1) {
        break label182;
      }
    }
    for (;;)
    {
      paramBundle = com.tencent.mm.live.core.debug.a.mUy;
      com.tencent.mm.live.core.debug.a.Gb("TRTC codec change! type:[1104], enctype:" + paramInt + ", msg:" + paramString);
      if (this.hKC)
      {
        boolean bool2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTq;
        boolean bool3 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTr;
        Log.i("MicroMsg.LiveCore", "TRTC codec change! hevcenable:" + bool2 + ", force265Mixing:" + bool3);
        if ((bool2) && (bool1 != bool2))
        {
          com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTq = bool1;
          bfa();
          if (bool3) {
            beP().bfw();
          }
        }
      }
      return;
      label171:
      paramInt = paramBundle.getInt("type");
      break;
      label182:
      bool1 = false;
    }
  }
  
  public final int r(boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = 1;
    int k = 0;
    int j = 1080;
    Log.i("MicroMsg.LiveCore", "useCamera2:" + paramBoolean1 + ", frontCamera:" + paramBoolean2 + " fps:" + com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTa);
    Object localObject1;
    Object localObject2;
    if (paramBoolean1)
    {
      localObject1 = MMApplicationContext.getContext();
      s.s(localObject1, "getContext()");
      localObject1 = (com.tencent.mm.media.widget.a.f)new com.tencent.mm.media.widget.b.d((Context)localObject1);
      this.mRu = ((com.tencent.mm.media.widget.a.f)localObject1);
      bfb();
      localObject1 = this.mRu;
      if (localObject1 == null) {
        break label318;
      }
      localObject2 = MMApplicationContext.getContext();
      s.s(localObject2, "getContext()");
      if (paramBoolean2) {
        break label313;
      }
      paramBoolean1 = true;
      label133:
      if (((com.tencent.mm.media.widget.a.f)localObject1).A((Context)localObject2, paramBoolean1) != true) {
        break label318;
      }
    }
    label291:
    label313:
    label318:
    for (int i = m;; i = 0)
    {
      j = k;
      if (i == 0)
      {
        Log.e("MicroMsg.LiveCoreError", "[-1] live anchor open camera error");
        j = -1;
      }
      return j;
      localObject1 = MMApplicationContext.getContext();
      s.s(localObject1, "getContext()");
      localObject1 = new com.tencent.mm.media.widget.a.e((Context)localObject1);
      localObject2 = this.mRA;
      if (localObject2 == null)
      {
        i = 1080;
        label212:
        localObject2 = this.mRA;
        if (localObject2 != null) {
          break label291;
        }
      }
      for (;;)
      {
        ((com.tencent.mm.media.widget.a.a)localObject1).nFZ = new Size(i, (int)(j * 4.0F / 3.0F));
        localObject2 = ah.aiuX;
        localObject1 = (com.tencent.mm.media.widget.a.f)localObject1;
        break;
        localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mNB;
        if (localObject2 == null)
        {
          i = 1080;
          break label212;
        }
        i = ((com.tencent.mm.live.core.core.model.f)localObject2).mNl;
        break label212;
        localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mNB;
        if (localObject2 != null) {
          j = ((com.tencent.mm.live.core.core.model.f)localObject2).mNl;
        }
      }
      paramBoolean1 = false;
      break label133;
    }
  }
  
  public void release()
  {
    Object localObject1 = this.mRH;
    if (localObject1 != null)
    {
      if (this.mRk)
      {
        beO().getAudioEffectManager().stopPlayMusic(((TXAudioEffectManager.AudioMusicParam)localObject1).id);
        beO().getAudioEffectManager().setMusicObserver(((TXAudioEffectManager.AudioMusicParam)localObject1).id, null);
      }
      this.mRH = null;
      this.mRI = false;
    }
    this.mRs.release();
    localObject1 = this.mRq;
    Log.i("MicroMsg.LiveCoreMini", s.X("dl: LiveMiniManager release ", Boolean.valueOf(((com.tencent.mm.live.core.mini.b)localObject1).mUJ.isHeld())));
    if (((com.tencent.mm.live.core.mini.b)localObject1).mUJ.isHeld())
    {
      localObject1 = ((com.tencent.mm.live.core.mini.b)localObject1).mUJ;
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, "com/tencent/mm/live/core/mini/LiveMiniManager", "release", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      ((PowerManager.WakeLock)localObject1).release();
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/live/core/mini/LiveMiniManager", "release", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    this.mRP = null;
    beX();
    if (this.mRk)
    {
      beO().setListener(null);
      localObject1 = c.mSj;
      c.a.destroySharedInstance();
    }
    bfg();
    localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr();
    if (((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).mSs == null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).mSs = new com.tencent.mm.live.core.core.trtc.sdkadapter.a.a();
    }
    Object localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).mSs;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a.a)localObject2).mSE = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a.a)localObject2).mPW = 1;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a.a)localObject2).mPX = 0;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a.a)localObject2).mJQ = 3;
    localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).bfn();
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mSZ = 108;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTa = 15;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mVideoBitrate = 600;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mMinVideoBitrate = 600;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTb = 110;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTc = 15;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTd = 1500;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTe = 600;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mQosMode = 1;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mQosPreference = 2;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTf = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTg = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTh = 0;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTi = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).eCF = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTj = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTk = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTl = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTm = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTn = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTo = 0;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTp = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTq = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTr = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTs = 5;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTt = 10;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTu = 0;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).mTv = 0;
    localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).bfo();
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSF = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSG = 0;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSH = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSI = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSJ = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSK = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSL = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSM = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSN = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSO = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject2).mSP = 2;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).bfp().reset();
    if (((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).mSr == null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).mSr = new com.tencent.mm.live.core.core.trtc.sdkadapter.feature.c();
    }
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).mSr.mSQ = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).bfq().cameraId = -1;
  }
  
  protected final void sW(int paramInt)
  {
    this.mRG = paramInt;
  }
  
  public final void sY(int paramInt)
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.b(this.mRq, paramInt));
  }
  
  public final void sZ(int paramInt)
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.c(this.mRq, paramInt));
  }
  
  public final void setNetEnv(int paramInt)
  {
    TRTCCloud.setNetEnv(paramInt);
  }
  
  public final void setScene(int paramInt)
  {
    Log.i("MicroMsg.LiveCore", s.X("setScene:", Integer.valueOf(paramInt)));
    this.mRN = paramInt;
  }
  
  public final void startLocalAudio(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.tencent.mm.hellhoundlib.a.a.a(beO(), "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore", "startLocalAudio", "(Z)V", "com/tencent/trtc/TRTCCloud", "startLocalAudio", "()V");
      return;
    }
    beO().stopLocalAudio();
  }
  
  public final void switchCamera()
  {
    int j = 1;
    for (;;)
    {
      try
      {
        Object localObject = this.mRu;
        if ((localObject != null) && (((com.tencent.mm.media.widget.a.f)localObject).bsD() == true))
        {
          i = 1;
          if (i != 0)
          {
            localObject = this.mRu;
            if (localObject != null) {
              ((com.tencent.mm.media.widget.a.f)localObject).bsC();
            }
            this.mRs.bgx();
            if (this.mRt != null)
            {
              localObject = this.mRu;
              if ((localObject == null) || (((com.tencent.mm.media.widget.a.f)localObject).bsD() != true)) {
                break label183;
              }
              i = j;
              if (i != 0)
              {
                localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfq();
                com.tencent.mm.media.widget.a.f localf = this.mRu;
                if (localf == null)
                {
                  i = 0;
                  ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.b)localObject).cameraId = i;
                  localObject = this.mRu;
                  if (localObject != null)
                  {
                    localObject = ((com.tencent.mm.media.widget.a.f)localObject).btc();
                    if (localObject != null)
                    {
                      this.mRv = ((com.tencent.mm.media.widget.a.b)localObject);
                      this.mRs.a((com.tencent.mm.media.widget.a.b)localObject);
                    }
                  }
                }
                else
                {
                  i = localf.btf();
                  continue;
                }
              }
            }
          }
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.LiveCoreError", (Throwable)localException, s.X("switch camera error:", localException.getMessage()), new Object[0]);
      }
      int i = 0;
      continue;
      label183:
      i = 0;
    }
  }
  
  public void ta(int paramInt)
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.d(this.mRq, paramInt));
  }
  
  public final void tb(int paramInt)
  {
    com.tencent.mm.live.core.b.h localh = beP().FY(this.mRB.mNM);
    if (localh != null) {
      localh.ti(paramInt);
    }
  }
  
  public final void tc(int paramInt)
  {
    com.tencent.mm.live.core.b.d locald = this.mRs;
    locald.H((kotlin.g.a.a)new d.l(locald, paramInt));
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/live/core/core/trtc/sdkadapter/remoteuser/TRTCRemoteUserManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends u
    implements kotlin.g.a.a<com.tencent.mm.live.core.core.trtc.sdkadapter.b.c>
  {
    z(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a
 * JD-Core Version:    0.7.0.1
 */