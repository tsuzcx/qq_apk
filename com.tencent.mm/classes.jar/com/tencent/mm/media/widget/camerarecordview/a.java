package com.tencent.mm.media.widget.camerarecordview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.IntBuffer;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.r;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "cameraPreviewInfo", "Lkotlin/Triple;", "", "context", "Landroid/content/Context;", "currentState", "customOrientation", "", "daemonRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "frameRenderCallback", "Lkotlin/Function0;", "", "getFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "initRecorderRet", "isRecording", "lastFlipCameraStamp", "", "mediaRecorder", "needResumeRecorder", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordFinish", "recordMiniTime", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "reportJSON", "Lcom/tencent/mm/json/JSONObject;", "startPreviewStamp", "startRecordTimeStamp", "getStartRecordTimeStamp", "()J", "setStartRecordTimeStamp", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "afterStartPreview", "cancelRecord", "checkFlashStatus", "openFlash", "configVendorTagValue", "tag", "", "createImageReaderCallback", "callback", "", "data", "createRecorder", "enableSwitchCamera", "getCameraOrientaion", "getCameraPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getFlashMode", "getMD5", "getRecordFilePath", "getRecordMuxerType", "getRecordTime", "getReportJSON", "getSupportZoomRatios", "", "initRecorder", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "isPreviewing", "isUseBackGroundCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "resetRecord", "setCustomOrientationEnable", "enable", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "flash", "setForceZoomTargetRatio", "ratio", "setMute", "mute", "setRecordMiniTime", "time", "setRender", "setValueToReport", "key", "startPreview", "displayRatio", "success", "startRecord", "isLandscape", "deviceDegree", "stopPreview", "stopRecord", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "capture", "switchCamera", "ignoreFlipCheck", "switchVendorTag", "isChecked", "takePicture", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a ipI;
  private Context context;
  public int currentState;
  private final MMHandler hAk;
  public final com.tencent.mm.media.widget.a.d hAt;
  com.tencent.mm.media.j.a ihs;
  public kotlin.g.a.b<? super Boolean, x> imw;
  private long ipA;
  public com.tencent.mm.media.widget.camerarecordview.c.a ipB;
  private volatile boolean ipC;
  public boolean ipD;
  kotlin.g.a.a<x> ipE;
  private long ipF;
  public i ipG;
  public com.tencent.mm.media.widget.camerarecordview.d.a ipH;
  public com.tencent.mm.media.widget.c.b ipr;
  private com.tencent.mm.media.widget.c.b ips;
  public boolean ipt;
  public long ipu;
  private boolean ipv;
  private volatile boolean ipw;
  private volatile r<Integer, Integer, Integer> ipx;
  private long ipy;
  private boolean ipz;
  
  static
  {
    AppMethodBeat.i(94250);
    ipI = new a.a((byte)0);
    AppMethodBeat.o(94250);
  }
  
  public a(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94249);
    this.ipH = parama;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.ipt = true;
    this.ipx = new r(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
    this.currentState = 1;
    this.ipA = 2000L;
    this.ipG = new i();
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", this.ipH.toString(), new Object[0]);
    parama = this.ipH.getCameraPreviewView();
    Object localObject;
    if (this.ipH.getPreviewRenderer() != null)
    {
      this.ihs = this.ipH.getPreviewRenderer();
      localObject = this.ipH.getPreviewRenderer();
      if (localObject == null) {
        p.hyc();
      }
      parama.a((com.tencent.mm.media.j.a)localObject, this.ipH.aQw());
      if ((!com.tencent.mm.media.widget.d.b.rG(this.ipH.getRecordScene())) || (this.ipH.aQw())) {
        break label339;
      }
      this.hAt = ((com.tencent.mm.media.widget.a.d)new com.tencent.mm.media.widget.b.c(this.ipH.getContext()));
      if (com.tencent.mm.media.widget.d.b.rH(this.ipH.getRecordScene())) {
        this.hAt.aPd();
      }
      k("isUseCamera2", Boolean.TRUE);
    }
    for (;;)
    {
      this.ipy = Util.currentTicks();
      this.context = this.ipH.getContext();
      this.ipB = new com.tencent.mm.media.widget.camerarecordview.c.a(this.context, this.ipH);
      AppMethodBeat.o(94249);
      return;
      localObject = new d(this);
      this.ihs = ((com.tencent.mm.media.j.a)localObject);
      parama.a((com.tencent.mm.media.j.a)localObject, this.ipH.aQw());
      break;
      label339:
      this.hAt = ((com.tencent.mm.media.widget.a.d)new com.tencent.mm.media.widget.a.c(this.ipH.getContext()));
      k("isUseCamera2", Boolean.FALSE);
    }
  }
  
  public static boolean aQg()
  {
    AppMethodBeat.i(94235);
    boolean bool = com.tencent.mm.media.widget.d.b.aQg();
    AppMethodBeat.o(94235);
    return bool;
  }
  
  private final boolean aQi()
  {
    AppMethodBeat.i(94238);
    Object localObject1 = this.ipH.getRecorder();
    Log.i("MicroMsg.CameraPreviewContainer", "createRecorder: " + this.ipr + ", useCpuCrop:" + this.ipH.aQw() + ", process.getRecorder():" + localObject1 + ", mute:" + this.ipH.Zx());
    Object localObject2 = this.ipr;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.ips;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.ipH.getEncodeConfig();
    if (localObject1 != null) {
      this.ipr = ((com.tencent.mm.media.widget.c.b)localObject1);
    }
    for (;;)
    {
      localObject1 = this.ipr;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(this.ipH.Zx());
      }
      localObject1 = this.ips;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(true);
      }
      this.ipH.getCameraPreviewView().setOnDrawListener((kotlin.g.a.b)new c(this));
      Log.i("MicroMsg.CameraPreviewContainer", "create recorder finish");
      AppMethodBeat.o(94238);
      return true;
      if (this.ipH.aQw())
      {
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNo();
        localObject1 = c.ipU;
        localObject1 = c.a(((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).aQm(), this.ipH.getVideoTransPara(), this.hAt, this.ipH.getRecordRenderer());
        label296:
        this.ipr = ((com.tencent.mm.media.widget.c.b)localObject1);
        if (this.ipH.getEncodeConfig().aQm() != 2) {
          break label559;
        }
        if (this.ipH.getVideoTransPara().iTr != 1) {
          break label554;
        }
      }
      label554:
      for (boolean bool = true;; bool = false)
      {
        bool = com.tencent.mm.plugin.sight.base.b.ak(false, bool);
        k("RecordMuxerType", Boolean.valueOf(bool));
        if (!this.ipH.aQy()) {
          break;
        }
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNn();
        if (this.ipH.getCameraPreviewView().getEGLContext() != null) {
          break label591;
        }
        Log.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNp();
        AppMethodBeat.o(94238);
        return false;
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNn();
        if (this.ipH.getCameraPreviewView().getEGLContext() == null)
        {
          Log.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
          localObject1 = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aNp();
          AppMethodBeat.o(94238);
          return false;
        }
        localObject1 = c.ipU;
        i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).aQm();
        localObject1 = this.ipH.getVideoTransPara();
        localObject3 = this.hAt;
        EGLContext localEGLContext = this.ipH.getCameraPreviewView().getEGLContext();
        if (localEGLContext == null) {
          p.hyc();
        }
        localObject1 = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.d)localObject3, localEGLContext, this.ipH.getCameraPreviewView(), this.ipH.aQw(), this.ipH.getRecordRenderer());
        break label296;
      }
      label559:
      if (this.ipH.getVideoTransPara().iTs == 1) {}
      for (bool = true;; bool = false)
      {
        bool = com.tencent.mm.plugin.sight.base.b.ak(true, bool);
        break;
      }
      label591:
      localObject1 = c.ipU;
      int i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).aQm();
      localObject1 = this.ipH.getDaemonVideoTransPara();
      localObject2 = this.hAt;
      Object localObject3 = this.ipH.getCameraPreviewView().getEGLContext();
      if (localObject3 == null) {
        p.hyc();
      }
      this.ips = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.d)localObject2, (EGLContext)localObject3, this.ipH.getCameraPreviewView(), this.ipH.aQw(), this.ipH.getRecordRenderer());
    }
  }
  
  private final void aQj()
  {
    com.tencent.mm.media.widget.c.b localb1 = null;
    AppMethodBeat.i(94240);
    com.tencent.mm.media.widget.c.b localb2 = this.ipr;
    if (localb2 != null) {
      localb2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aPl(), com.tencent.mm.media.widget.a.b.aPm());
    }
    if (localb2 != null) {
      localb2.setFilePath(this.ipH.getEncodeConfig().getFilePath());
    }
    if (localb2 != null) {
      localb2.HA(this.ipH.getEncodeConfig().aQn());
    }
    StringBuilder localStringBuilder = new StringBuilder("filePath : ");
    Object localObject;
    label143:
    label307:
    boolean bool1;
    label375:
    boolean bool2;
    if (localb2 != null)
    {
      localObject = localb2.getFilePath();
      localStringBuilder = localStringBuilder.append((String)localObject).append("   thumbPath : ");
      if (localb2 == null) {
        break label447;
      }
      localObject = localb2.aQn();
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localb2 = this.ips;
      if (localb2 != null) {
        localb2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aPl(), com.tencent.mm.media.widget.a.b.aPm());
      }
      if (localb2 != null) {
        localb2.setFilePath(this.ipH.getEncodeConfig().getFilePath() + "_daemon");
      }
      if (localb2 != null) {
        localb2.HA(this.ipH.getEncodeConfig().aQn() + "_daemon");
      }
      localStringBuilder = new StringBuilder("filePath : ");
      if (localb2 == null) {
        break label452;
      }
      localObject = localb2.getFilePath();
      localStringBuilder = localStringBuilder.append((String)localObject).append("   thumbPath : ");
      localObject = localb1;
      if (localb2 != null) {
        localObject = localb2.aQn();
      }
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localObject = this.ipr;
      if (localObject == null) {
        break label457;
      }
      bool1 = ((com.tencent.mm.media.widget.c.b)localObject).rC(com.tencent.mm.media.widget.a.b.aPk());
      localObject = this.ips;
      if (localObject == null) {
        break label462;
      }
      bool2 = ((com.tencent.mm.media.widget.c.b)localObject).rC(com.tencent.mm.media.widget.a.b.aPk());
    }
    for (;;)
    {
      if (((this.ips instanceof com.tencent.mm.media.widget.c.c)) && ((this.ipr instanceof com.tencent.mm.media.widget.c.c)))
      {
        localObject = this.ips;
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
          AppMethodBeat.o(94240);
          throw ((Throwable)localObject);
          localObject = null;
          break;
          label447:
          localObject = null;
          break label143;
          label452:
          localObject = null;
          break label307;
          label457:
          bool1 = false;
          break label375;
          label462:
          bool2 = false;
          continue;
        }
        localObject = (com.tencent.mm.media.widget.c.c)localObject;
        localb1 = this.ipr;
        if (localb1 == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
          AppMethodBeat.o(94240);
          throw ((Throwable)localObject);
        }
        ((com.tencent.mm.media.widget.c.c)localObject).a(((com.tencent.mm.media.widget.c.c)localb1).aQW());
      }
    }
    if (((this.ips instanceof com.tencent.mm.media.widget.c.e)) && ((this.ipr instanceof com.tencent.mm.media.widget.c.e)))
    {
      localObject = this.ips;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.media.widget.c.e)localObject;
      localb1 = this.ipr;
      if (localb1 == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.media.widget.c.e)localObject).a(((com.tencent.mm.media.widget.c.e)localb1).aQW());
    }
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "init recorder ret:" + bool1 + "  daemonRet:" + bool2, new Object[0]);
    this.ipz = bool1;
    AppMethodBeat.o(94240);
  }
  
  private final void k(String paramString, Object paramObject)
  {
    AppMethodBeat.i(218875);
    this.ipG.h(paramString, paramObject);
    AppMethodBeat.o(218875);
  }
  
  public final void B(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94247);
    p.h(paramString, "tag");
    this.hAt.B(paramString, paramBoolean);
    AppMethodBeat.o(94247);
  }
  
  public final void a(boolean paramBoolean, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(94241);
    long l = Util.currentTicks();
    k("OpenCameraTimeStamp", Long.valueOf(l));
    if (this.currentState == 0)
    {
      Log.e("MicroMsg.CameraPreviewContainer", "startPreview, already in preview state");
      AppMethodBeat.o(94241);
      return;
    }
    this.currentState = 0;
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "startPreview process.useCpuCrop():" + this.ipH.aQw(), new Object[0]);
    this.ipt = paramBoolean;
    if ((!this.ipt) && (!com.tencent.mm.media.widget.d.b.aRJ()))
    {
      this.ipt = true;
      Log.i("MicroMsg.CameraPreviewContainer", "force useBackGroundCamera");
    }
    if ((this.ipt) && (!com.tencent.mm.media.widget.d.b.aRK()))
    {
      this.ipt = false;
      Log.i("MicroMsg.CameraPreviewContainer", "force useFrontGroundCamera");
    }
    this.hAt.v(this.ipH.getContext(), this.ipt);
    if (this.ipH.aQw()) {
      this.hAt.a(this.ipH.getCameraPreviewView().getFrameDataCallback());
    }
    k("CameraOpenCost", Long.valueOf(Util.ticksToNow(l)));
    this.ipH.getCameraPreviewView().d((kotlin.g.a.b)new e(this, paramb));
    AppMethodBeat.o(94241);
  }
  
  public final void aPq()
  {
    AppMethodBeat.i(94229);
    if (this.currentState == 0) {
      this.hAt.aPq();
    }
    AppMethodBeat.o(94229);
  }
  
  public final void aQf()
  {
    AppMethodBeat.i(94226);
    try
    {
      Log.i("MicroMsg.CameraPreviewContainer", "cancelRecord");
      com.tencent.mm.media.widget.c.b localb = this.ipr;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.ipr;
      if (localb != null) {
        localb.clear();
      }
      localb = this.ips;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.ips;
      if (localb != null) {
        localb.clear();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "cancel record error", new Object[0]);
      }
    }
    if (this.hAt.aPc())
    {
      aQi();
      if (this.hAt.aPr() != null) {
        aQj();
      }
    }
    AppMethodBeat.o(94226);
  }
  
  public final int aQh()
  {
    AppMethodBeat.i(94236);
    int i = this.hAt.aPv();
    AppMethodBeat.o(94236);
    return i;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94228);
    if (this.currentState == 0) {
      this.hAt.b(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(94228);
  }
  
  public final boolean fh(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(94233);
    if (!com.tencent.mm.media.widget.d.b.aQg())
    {
      Log.i("MicroMsg.CameraPreviewContainer", "only one camera,forbid switch");
      if (!com.tencent.mm.media.widget.d.b.aRJ())
      {
        AppMethodBeat.o(94233);
        return true;
      }
      AppMethodBeat.o(94233);
      return false;
    }
    Log.i("MicroMsg.CameraPreviewContainer", "flipCamera time space:" + Util.ticksToNow(this.ipy));
    if ((!paramBoolean) && (Util.ticksToNow(this.ipy) < 1000L))
    {
      paramBoolean = this.ipt;
      AppMethodBeat.o(94233);
      return paramBoolean;
    }
    this.ipy = Util.currentTicks();
    if (this.ipv)
    {
      localObject = this.ipr;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
      localObject = this.ips;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
    }
    this.ipH.getCameraPreviewView().aEy();
    this.ipt = this.hAt.aPb();
    Object localObject = this.hAt.aPr();
    if (!this.ipD)
    {
      com.tencent.mm.media.widget.camerarecordview.c.a locala = this.ipB;
      paramBoolean = bool;
      if (!this.ipt)
      {
        paramBoolean = bool;
        if (this.ipH.aQx()) {
          paramBoolean = true;
        }
      }
      locala.a(paramBoolean, (com.tencent.mm.media.widget.a.b)localObject);
    }
    if (localObject != null)
    {
      this.ipH.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
      localObject = c.ipU;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).cZ(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
      }
      localObject = c.ipU;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).qx(com.tencent.mm.media.widget.a.b.aPk());
      }
      localObject = c.ipU;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).eD(com.tencent.mm.media.widget.a.b.aPn());
      }
      localObject = this.ipr;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.aPn());
      }
      localObject = this.ips;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.aPn());
      }
      localObject = this.ipr;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aPl(), com.tencent.mm.media.widget.a.b.aPm());
      }
      localObject = this.ips;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aPl(), com.tencent.mm.media.widget.a.b.aPm());
      }
      if (this.ipv)
      {
        this.ipx = new r(Integer.valueOf(com.tencent.mm.media.widget.a.b.aPk()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewWidth()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewHeight()));
        this.ipw = true;
      }
    }
    paramBoolean = this.ipt;
    AppMethodBeat.o(94233);
    return paramBoolean;
  }
  
  public final Point fi(boolean paramBoolean)
  {
    AppMethodBeat.i(94243);
    Point localPoint = this.hAt.fa(paramBoolean);
    AppMethodBeat.o(94243);
    return localPoint;
  }
  
  public final void fj(boolean paramBoolean)
  {
    AppMethodBeat.i(94248);
    this.hAt.fb(paramBoolean);
    AppMethodBeat.o(94248);
  }
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94231);
    if (this.currentState == 0) {
      this.hAt.i(paramBoolean, paramInt);
    }
    AppMethodBeat.o(94231);
  }
  
  public final boolean j(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94224);
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "startRecord", new Object[0]);
    Object localObject2;
    com.tencent.mm.media.widget.c.b localb;
    if ((this.hAt.aPr() != null) && (this.ipr != null))
    {
      if (!this.ipz)
      {
        Log.i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
        AppMethodBeat.o(94224);
        return false;
      }
      localObject2 = this.ipr;
      if (localObject2 != null)
      {
        localObject2 = Integer.valueOf(((com.tencent.mm.media.widget.c.b)localObject2).b(com.tencent.mm.media.widget.a.b.aPk(), paramBoolean, paramInt));
        Log.i("MicroMsg.CameraPreviewContainer", "start record ret:".concat(String.valueOf(localObject2)));
        if (!this.ipH.aQy()) {
          break label294;
        }
        localb = this.ips;
        if (localb == null) {}
      }
    }
    label153:
    label294:
    for (localObject1 = Integer.valueOf(localb.b(com.tencent.mm.media.widget.a.b.aPk(), paramBoolean, paramInt));; localObject1 = Integer.valueOf(-1))
    {
      if (localObject2 == null) {
        if (localObject1 != null) {
          break label263;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(94224);
        return false;
        localObject2 = null;
        break;
        if (((Integer)localObject2).intValue() != 0) {
          break label153;
        }
        do
        {
          Log.i("MicroMsg.CameraPreviewContainer", "start record base ret:" + localObject2 + " daemon ret:" + localObject1 + " ,use daemon record:" + this.ipH.aQy());
          this.ipu = Util.currentTicks();
          this.ipv = true;
          this.ipC = false;
          localObject1 = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aOb();
          AppMethodBeat.o(94224);
          return true;
        } while (((Integer)localObject1).intValue() == 0);
      }
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", "cameraConfig is null", new Object[0]);
      AppMethodBeat.o(94224);
      return false;
    }
  }
  
  public final boolean p(final kotlin.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, x> paramb)
  {
    AppMethodBeat.i(94227);
    if (!this.ipv)
    {
      AppMethodBeat.o(94227);
      return true;
    }
    this.ipv = false;
    if (Util.ticksToNow(this.ipu) < this.ipA)
    {
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", "stopRecord " + Util.ticksToNow(this.ipu), new Object[0]);
      paramb = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aOc();
      aQf();
      AppMethodBeat.o(94227);
      return false;
    }
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
    final com.tencent.mm.media.k.a locala = new com.tencent.mm.media.k.a("stopRecord");
    final z.d locald = new z.d();
    locald.SYE = 0;
    final z.f localf1 = new z.f();
    localf1.SYG = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
    final z.f localf2 = new z.f();
    localf2.SYG = ((Runnable)new h(this, localf1, paramb));
    if (this.ipH.aQy())
    {
      localObject = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aOd();
    }
    Object localObject = new z.f();
    ((z.f)localObject).SYG = this.ipr;
    com.tencent.mm.media.widget.c.b localb = this.ipr;
    if (localb != null) {
      localb.E((Runnable)new f(this, (z.f)localObject, locala, localf1, locald, localf2, paramb));
    }
    localObject = this.ips;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.c.b)localObject).E((Runnable)new g(this, locala, localf1, locald, localf2, paramb));
    }
    AppMethodBeat.o(94227);
    return true;
  }
  
  public final void q(kotlin.g.a.b<? super byte[], x> paramb)
  {
    AppMethodBeat.i(94239);
    p.h(paramb, "callback");
    this.hAt.aPe();
    this.hAt.a((g)new b(paramb));
    AppMethodBeat.o(94239);
  }
  
  public final void r(final kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    AppMethodBeat.i(94246);
    p.h(paramb, "callback");
    if (!this.hAt.aPc())
    {
      Log.e("MicroMsg.CameraPreviewContainer", "camera.isCameraPreviewing : false");
      paramb.invoke(null);
      AppMethodBeat.o(94246);
      return;
    }
    if ((com.tencent.mm.media.widget.d.b.a(this.ipH)) && (!com.tencent.mm.media.widget.d.b.rH(this.ipH.getRecordScene())))
    {
      l = Util.currentTicks();
      this.hAt.n((kotlin.g.a.b)new j(this, l, paramb));
      AppMethodBeat.o(94246);
      return;
    }
    final long l = Util.currentTicks();
    com.tencent.mm.media.j.a locala = this.ihs;
    if (locala != null)
    {
      locala.m((kotlin.g.a.b)new i(this, paramb, l));
      locala.aML();
      AppMethodBeat.o(94246);
      return;
    }
    AppMethodBeat.o(94246);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94237);
    try
    {
      Log.i("MicroMsg.CameraPreviewContainer", "release");
      this.hAt.onDestroy();
      this.hAt.release();
      Object localObject = this.ipB;
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).iqs.disable();
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).context = null;
      localObject = c.ipU;
      c.aQk();
      this.ipH.getCameraPreviewView().release();
      localObject = this.ipr;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.ipr;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.ips;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.ips;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.ihs;
      if (localObject != null) {
        com.tencent.mm.media.j.a.a((com.tencent.mm.media.j.a)localObject);
      }
      this.ihs = null;
      AppMethodBeat.o(94237);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "camera release error:" + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  public final void rz(int paramInt)
  {
    AppMethodBeat.i(94230);
    if (this.currentState == 0) {
      this.hAt.rw(paramInt);
    }
    AppMethodBeat.o(94230);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(218874);
    com.tencent.mm.media.widget.c.b localb = this.ipr;
    if (localb != null)
    {
      localb.setMute(paramBoolean);
      AppMethodBeat.o(218874);
      return;
    }
    AppMethodBeat.o(218874);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(94245);
    if (this.currentState == 1)
    {
      AppMethodBeat.o(94245);
      return;
    }
    this.currentState = 1;
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "stopPreview", new Object[0]);
    try
    {
      this.hAt.release();
      this.hAt.b(this.ipH.getCameraPreviewView().getFrameDataCallback());
      this.ipH.getCameraPreviewView().aEx();
      if (!this.ipD) {
        this.ipB.a(false, null);
      }
      AppMethodBeat.o(94245);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "camera relase error:" + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  public final void zU(long paramLong)
  {
    AppMethodBeat.i(94232);
    Log.i("MicroMsg.CameraPreviewContainer", "setRecordMiniTime:".concat(String.valueOf(paramLong)));
    this.ipA = paramLong;
    AppMethodBeat.o(94232);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFrameData"})
  static final class b
    implements g
  {
    b(kotlin.g.a.b paramb) {}
    
    public final boolean ai(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(94214);
      kotlin.g.a.b localb = this.gWe;
      p.g(paramArrayOfByte, "it");
      localb.invoke(paramArrayOfByte);
      AppMethodBeat.o(94214);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.mm.media.g.d, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$setRender$curRenderer$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class d
    extends com.tencent.mm.media.j.d
  {
    d(int paramInt)
    {
      super();
    }
    
    public final com.tencent.mm.media.j.b.a aEC()
    {
      AppMethodBeat.i(94216);
      if (this.ipJ.ipH.aQw())
      {
        locala = (com.tencent.mm.media.j.b.a)new f(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
        AppMethodBeat.o(94216);
        return locala;
      }
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
      AppMethodBeat.o(94216);
      return locala;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<SurfaceTexture, x>
  {
    e(a parama, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, z.f paramf1, com.tencent.mm.media.k.a parama1, z.f paramf2, z.d paramd, z.f paramf3, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(94219);
      if (a.f(this.ipJ))
      {
        AppMethodBeat.o(94219);
        return;
      }
      Object localObject2 = new StringBuilder("stopRecord ");
      Object localObject1 = (com.tencent.mm.media.widget.c.b)this.ipL.SYG;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
        localObject1 = (com.tencent.mm.media.widget.c.b)this.ipL.SYG;
        if (localObject1 == null) {
          break label459;
        }
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).aQn();
        label88:
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
        locala.aBw();
        a.a(this.ipJ, "HighRecordStopWaitTime", Long.valueOf(locala.hvh.apr()));
        localObject1 = (com.tencent.mm.media.widget.c.b)this.ipL.SYG;
        if (localObject1 == null) {
          break label464;
        }
      }
      label459:
      label464:
      for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
      {
        localObject2 = (com.tencent.mm.media.widget.c.b)this.ipL.SYG;
        if (localObject2 != null) {
          str = ((com.tencent.mm.media.widget.c.b)localObject2).aQn();
        }
        if ((localObject1 == null) || (str == null)) {
          break label497;
        }
        localObject2 = com.tencent.mm.plugin.sight.base.e.aNx((String)localObject1);
        if (localObject2 == null) {
          break label497;
        }
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG).iqf = true;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG).Hw((String)localObject1);
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG).Hx(str);
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG).dvv = 0;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG).iqg = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
        localObject1 = locald;
        ((z.d)localObject1).SYE += 1;
        Log.i("MicroMsg.CameraPreviewContainer", "record video info main: ".concat(String.valueOf(localObject2)));
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOq();
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.zN(((com.tencent.mm.plugin.sight.base.a)localObject2).videoBitrate);
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.zO(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate);
        if (((!this.ipJ.ipH.aQy()) || (locald.SYE != 2)) && (this.ipJ.ipH.aQy())) {
          break label475;
        }
        if ((this.ipJ.ipH.aQy()) && (locald.SYE == 2))
        {
          localObject1 = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aOe();
        }
        MMHandlerThread.removeRunnable((Runnable)localf2.SYG);
        a.g(this.ipJ);
        localObject1 = paramb;
        if (localObject1 == null) {
          break label469;
        }
        ((kotlin.g.a.b)localObject1).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG);
        AppMethodBeat.o(94219);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label88;
      }
      label469:
      AppMethodBeat.o(94219);
      return;
      label475:
      MMHandlerThread.postToMainThreadDelayed((Runnable)localf2.SYG, 3000L);
      AppMethodBeat.o(94219);
      return;
      label497:
      AppMethodBeat.o(94219);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama, com.tencent.mm.media.k.a parama1, z.f paramf1, z.d paramd, z.f paramf2, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(94220);
      if (a.f(this.ipJ))
      {
        AppMethodBeat.o(94220);
        return;
      }
      Object localObject2 = new StringBuilder("stop daemonRecorder ");
      Object localObject1 = a.e(this.ipJ);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
        localObject1 = a.e(this.ipJ);
        if (localObject1 == null) {
          break label409;
        }
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).aQn();
        label82:
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
        locala.aBw();
        a.a(this.ipJ, "LowRecordStopWaitTime", Long.valueOf(locala.hvh.apr()));
        localObject1 = a.e(this.ipJ);
        if (localObject1 == null) {
          break label414;
        }
      }
      label409:
      label414:
      for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
      {
        localObject2 = a.e(this.ipJ);
        if (localObject2 != null) {
          str = ((com.tencent.mm.media.widget.c.b)localObject2).aQn();
        }
        if ((localObject1 == null) || (str == null)) {
          break label447;
        }
        localObject2 = com.tencent.mm.plugin.sight.base.e.aNx((String)localObject1);
        if (localObject2 == null) {
          break label447;
        }
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG).iqf = true;
        com.tencent.mm.media.widget.camerarecordview.b.b localb = (com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG;
        p.h(localObject1, "<set-?>");
        localb.iqh = ((String)localObject1);
        localObject1 = (com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG;
        p.h(str, "<set-?>");
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqi = str;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG).iqj = 0;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG).iqk = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
        localObject1 = locald;
        ((z.d)localObject1).SYE += 1;
        Log.i("MicroMsg.CameraPreviewContainer", "record video info daemon: ".concat(String.valueOf(localObject2)));
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOr();
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.zP(((com.tencent.mm.plugin.sight.base.a)localObject2).videoBitrate);
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.zQ(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate);
        if (locald.SYE != 2) {
          break label425;
        }
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOe();
        MMHandlerThread.removeRunnable((Runnable)localf2.SYG);
        a.g(this.ipJ);
        localObject1 = paramb;
        if (localObject1 == null) {
          break label419;
        }
        ((kotlin.g.a.b)localObject1).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG);
        AppMethodBeat.o(94220);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label82;
      }
      label419:
      AppMethodBeat.o(94220);
      return;
      label425:
      MMHandlerThread.postToMainThreadDelayed((Runnable)localf2.SYG, 3000L);
      AppMethodBeat.o(94220);
      return;
      label447:
      AppMethodBeat.o(94220);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(a parama, z.f paramf, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(94221);
      if (!((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG).aQp())
      {
        localObject = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOf();
        localObject = a.d(this.ipJ);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).cancel();
        }
      }
      if (!((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG).aQo())
      {
        localObject = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOg();
        localObject = a.e(this.ipJ);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).cancel();
        }
      }
      a.g(this.ipJ);
      Object localObject = paramb;
      if (localObject != null)
      {
        ((kotlin.g.a.b)localObject).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.SYG);
        AppMethodBeat.o(94221);
        return;
      }
      AppMethodBeat.o(94221);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/nio/IntBuffer;", "invoke", "com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$takePicture$2$1"})
  static final class i
    extends q
    implements kotlin.g.a.b<IntBuffer, x>
  {
    i(a parama, kotlin.g.a.b paramb, long paramLong)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<Bitmap, x>
  {
    j(a parama, long paramLong, kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a
 * JD-Core Version:    0.7.0.1
 */