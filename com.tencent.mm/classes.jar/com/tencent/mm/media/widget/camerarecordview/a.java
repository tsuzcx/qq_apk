package com.tencent.mm.media.widget.camerarecordview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.IntBuffer;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.r;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "cameraPreviewInfo", "Lkotlin/Triple;", "", "context", "Landroid/content/Context;", "currentState", "customOrientation", "", "daemonRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "frameRenderCallback", "Lkotlin/Function0;", "", "getFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "initRecorderRet", "isRecording", "lastFlipCameraStamp", "", "mediaRecorder", "needResumeRecorder", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordFinish", "recordMiniTime", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "reportJSON", "Lcom/tencent/mm/json/JSONObject;", "startPreviewStamp", "startRecordTimeStamp", "getStartRecordTimeStamp", "()J", "setStartRecordTimeStamp", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "afterStartPreview", "cancelRecord", "checkFlashStatus", "openFlash", "configVendorTagValue", "tag", "", "createImageReaderCallback", "callback", "", "data", "createRecorder", "enableSwitchCamera", "getCameraOrientaion", "getCameraPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getFlashMode", "getMD5", "getRecordFilePath", "getRecordMuxerType", "getRecordTime", "getReportJSON", "getSupportZoomRatios", "", "initRecorder", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "isPreviewing", "isUseBackGroundCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "resetRecord", "setCustomOrientationEnable", "enable", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "flash", "setForceZoomTargetRatio", "ratio", "setMute", "mute", "setRecordMiniTime", "time", "setRender", "setValueToReport", "key", "startPreview", "displayRatio", "success", "(ZLjava/lang/Float;Lkotlin/jvm/functions/Function1;)V", "startRecord", "isLandscape", "deviceDegree", "stopPreview", "stopRecord", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "capture", "switchCamera", "ignoreFlipCheck", "switchVendorTag", "isChecked", "takePicture", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a leN;
  private Context context;
  public int currentState;
  com.tencent.mm.media.j.a kWg;
  private final MMHandler knk;
  public final com.tencent.mm.media.widget.a.e knu;
  public kotlin.g.a.b<? super Boolean, x> lbx;
  private boolean leA;
  private volatile boolean leB;
  private volatile r<Integer, Integer, Integer> leC;
  private long leD;
  private boolean leE;
  private long leF;
  public com.tencent.mm.media.widget.camerarecordview.c.a leG;
  private volatile boolean leH;
  public boolean leI;
  kotlin.g.a.a<x> leJ;
  private long leK;
  public i leL;
  public com.tencent.mm.media.widget.camerarecordview.d.a leM;
  public com.tencent.mm.media.widget.c.b lew;
  private com.tencent.mm.media.widget.c.b lex;
  public boolean ley;
  public long lez;
  
  static
  {
    AppMethodBeat.i(94250);
    leN = new a((byte)0);
    AppMethodBeat.o(94250);
  }
  
  public a(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94249);
    this.leM = parama;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.ley = true;
    this.leC = new r(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
    this.currentState = 1;
    this.leF = 2000L;
    this.leL = new i();
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", this.leM.toString(), new Object[0]);
    parama = this.leM.getCameraPreviewView();
    Object localObject;
    if (this.leM.getPreviewRenderer() != null)
    {
      this.kWg = this.leM.getPreviewRenderer();
      localObject = this.leM.getPreviewRenderer();
      if (localObject == null) {
        p.iCn();
      }
      parama.a((com.tencent.mm.media.j.a)localObject, this.leM.aZo());
      if ((!com.tencent.mm.media.widget.d.c.f(Integer.valueOf(this.leM.getRecordScene()))) || (this.leM.aZo())) {
        break label342;
      }
      this.knu = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.b.d(this.leM.getContext()));
      if (com.tencent.mm.media.widget.d.c.uA(this.leM.getRecordScene())) {
        this.knu.aXR();
      }
      j("isUseCamera2", Boolean.TRUE);
    }
    for (;;)
    {
      this.leD = Util.currentTicks();
      this.context = this.leM.getContext();
      this.leG = new com.tencent.mm.media.widget.camerarecordview.c.a(this.context, this.leM);
      AppMethodBeat.o(94249);
      return;
      localObject = new d(this);
      this.kWg = ((com.tencent.mm.media.j.a)localObject);
      parama.a((com.tencent.mm.media.j.a)localObject, this.leM.aZo());
      break;
      label342:
      this.knu = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.a.c(this.leM.getContext()));
      j("isUseCamera2", Boolean.FALSE);
    }
  }
  
  public static boolean aYX()
  {
    AppMethodBeat.i(94235);
    boolean bool = com.tencent.mm.media.widget.d.c.aYX();
    AppMethodBeat.o(94235);
    return bool;
  }
  
  private final boolean aYZ()
  {
    AppMethodBeat.i(94238);
    long l = Util.currentTicks();
    Object localObject1 = this.leM.getRecorder();
    Log.i("MicroMsg.CameraPreviewContainer", "createRecorder: " + this.lew + ", useCpuCrop:" + this.leM.aZo() + ", process.getRecorder():" + localObject1 + ", mute:" + this.leM.aeg());
    Object localObject2 = this.lew;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.lex;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.leM.getEncodeConfig();
    if (localObject1 != null) {
      this.lew = ((com.tencent.mm.media.widget.c.b)localObject1);
    }
    for (;;)
    {
      localObject1 = this.lew;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(this.leM.aeg());
      }
      localObject1 = this.lex;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(true);
      }
      this.leM.getCameraPreviewView().setOnDrawListener((kotlin.g.a.b)new c(this));
      Log.i("MicroMsg.CameraPreviewContainer", "create recorder finish");
      j("REPORT_CREATE_RECORDER", Long.valueOf(Util.ticksToNow(l)));
      AppMethodBeat.o(94238);
      return true;
      if (this.leM.aZo())
      {
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aVS();
        localObject1 = c.lfa;
        localObject1 = c.a(((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).aZd(), this.leM.getVideoTransPara(), this.knu, this.leM.getRecordRenderer());
        label327:
        this.lew = ((com.tencent.mm.media.widget.c.b)localObject1);
        if (this.leM.getEncodeConfig().aZd() != 2) {
          break label604;
        }
        if (this.leM.getVideoTransPara().lJK != 1) {
          break label598;
        }
      }
      label598:
      for (boolean bool = true;; bool = false)
      {
        bool = com.tencent.mm.plugin.sight.base.c.aw(false, bool);
        j("RecordMuxerType", Boolean.valueOf(bool));
        if (!this.leM.aZq()) {
          break;
        }
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aVR();
        if (this.leM.getCameraPreviewView().getEGLContext() != null) {
          break label640;
        }
        Log.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aVT();
        AppMethodBeat.o(94238);
        return false;
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aVR();
        if (this.leM.getCameraPreviewView().getEGLContext() == null)
        {
          Log.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
          localObject1 = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aVT();
          AppMethodBeat.o(94238);
          return false;
        }
        localObject1 = c.lfa;
        i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).aZd();
        localObject1 = this.leM.getVideoTransPara();
        localObject3 = this.knu;
        EGLContext localEGLContext = this.leM.getCameraPreviewView().getEGLContext();
        if (localEGLContext == null) {
          p.iCn();
        }
        localObject1 = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.e)localObject3, localEGLContext, this.leM.getCameraPreviewView(), this.leM.aZo(), this.leM.getRecordRenderer());
        break label327;
      }
      label604:
      if (this.leM.getVideoTransPara().lJL == 1) {}
      for (bool = true;; bool = false)
      {
        bool = com.tencent.mm.plugin.sight.base.c.aw(true, bool);
        break;
      }
      label640:
      localObject1 = c.lfa;
      int i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).aZd();
      localObject1 = this.leM.getDaemonVideoTransPara();
      localObject2 = this.knu;
      Object localObject3 = this.leM.getCameraPreviewView().getEGLContext();
      if (localObject3 == null) {
        p.iCn();
      }
      this.lex = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.e)localObject2, (EGLContext)localObject3, this.leM.getCameraPreviewView(), this.leM.aZo(), this.leM.getRecordRenderer());
    }
  }
  
  private final void aZa()
  {
    com.tencent.mm.media.widget.c.b localb1 = null;
    AppMethodBeat.i(94240);
    com.tencent.mm.media.widget.c.b localb2 = this.lew;
    if (localb2 != null) {
      localb2.u(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aXY(), com.tencent.mm.media.widget.a.b.aXZ());
    }
    if (localb2 != null) {
      localb2.setFilePath(this.leM.getEncodeConfig().getFilePath());
    }
    if (localb2 != null) {
      localb2.ON(this.leM.getEncodeConfig().aZe());
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
      localObject = localb2.aZe();
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localb2 = this.lex;
      if (localb2 != null) {
        localb2.u(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aXY(), com.tencent.mm.media.widget.a.b.aXZ());
      }
      if (localb2 != null) {
        localb2.setFilePath(this.leM.getEncodeConfig().getFilePath() + "_daemon");
      }
      if (localb2 != null) {
        localb2.ON(this.leM.getEncodeConfig().aZe() + "_daemon");
      }
      localStringBuilder = new StringBuilder("filePath : ");
      if (localb2 == null) {
        break label452;
      }
      localObject = localb2.getFilePath();
      localStringBuilder = localStringBuilder.append((String)localObject).append("   thumbPath : ");
      localObject = localb1;
      if (localb2 != null) {
        localObject = localb2.aZe();
      }
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localObject = this.lew;
      if (localObject == null) {
        break label457;
      }
      bool1 = ((com.tencent.mm.media.widget.c.b)localObject).uw(com.tencent.mm.media.widget.a.b.aVp());
      localObject = this.lex;
      if (localObject == null) {
        break label462;
      }
      bool2 = ((com.tencent.mm.media.widget.c.b)localObject).uw(com.tencent.mm.media.widget.a.b.aVp());
    }
    for (;;)
    {
      if (((this.lex instanceof com.tencent.mm.media.widget.c.c)) && ((this.lew instanceof com.tencent.mm.media.widget.c.c)))
      {
        localObject = this.lex;
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
        localb1 = this.lew;
        if (localb1 == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
          AppMethodBeat.o(94240);
          throw ((Throwable)localObject);
        }
        ((com.tencent.mm.media.widget.c.c)localObject).a(((com.tencent.mm.media.widget.c.c)localb1).aZO());
      }
    }
    if (((this.lex instanceof com.tencent.mm.media.widget.c.e)) && ((this.lew instanceof com.tencent.mm.media.widget.c.e)))
    {
      localObject = this.lex;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.media.widget.c.e)localObject;
      localb1 = this.lew;
      if (localb1 == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.media.widget.c.e)localObject).a(((com.tencent.mm.media.widget.c.e)localb1).aZO());
    }
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "init recorder ret:" + bool1 + "  daemonRet:" + bool2, new Object[0]);
    this.leE = bool1;
    AppMethodBeat.o(94240);
  }
  
  private final void j(String paramString, Object paramObject)
  {
    AppMethodBeat.i(258665);
    this.leL.g(paramString, paramObject);
    AppMethodBeat.o(258665);
  }
  
  public final void D(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94247);
    p.k(paramString, "tag");
    this.knu.D(paramString, paramBoolean);
    AppMethodBeat.o(94247);
  }
  
  public final void Gb(long paramLong)
  {
    AppMethodBeat.i(94232);
    Log.i("MicroMsg.CameraPreviewContainer", "setRecordMiniTime:".concat(String.valueOf(paramLong)));
    this.leF = paramLong;
    AppMethodBeat.o(94232);
  }
  
  public final void TL()
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
      this.knu.release();
      this.knu.b(this.leM.getCameraPreviewView().getFrameDataCallback());
      this.leM.getCameraPreviewView().aMM();
      if (!this.leI) {
        this.leG.a(false, null);
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
  
  public final void a(boolean paramBoolean, final Float paramFloat, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(258649);
    long l = Util.currentTicks();
    j("OpenCameraTimeStamp", Long.valueOf(l));
    if (this.currentState == 0)
    {
      Log.e("MicroMsg.CameraPreviewContainer", "startPreview, already in preview state");
      AppMethodBeat.o(258649);
      return;
    }
    this.currentState = 0;
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "startPreview process.useCpuCrop():" + this.leM.aZo(), new Object[0]);
    this.ley = paramBoolean;
    if ((!this.ley) && (!com.tencent.mm.media.widget.d.c.baD()))
    {
      this.ley = true;
      Log.i("MicroMsg.CameraPreviewContainer", "force useBackGroundCamera");
    }
    if ((this.ley) && (!com.tencent.mm.media.widget.d.c.baE()))
    {
      this.ley = false;
      Log.i("MicroMsg.CameraPreviewContainer", "force useFrontGroundCamera");
    }
    this.knu.y(this.leM.getContext(), this.ley);
    if (this.leM.aZo()) {
      this.knu.a(this.leM.getCameraPreviewView().getFrameDataCallback());
    }
    j("CameraOpenCost", Long.valueOf(Util.ticksToNow(l)));
    this.leM.getCameraPreviewView().d((kotlin.g.a.b)new e(this, paramFloat, paramb));
    AppMethodBeat.o(258649);
  }
  
  public final void aYW()
  {
    AppMethodBeat.i(94226);
    try
    {
      Log.i("MicroMsg.CameraPreviewContainer", "cancelRecord");
      com.tencent.mm.media.widget.c.b localb = this.lew;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.lew;
      if (localb != null) {
        localb.clear();
      }
      localb = this.lex;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.lex;
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
    if (this.knu.aXQ())
    {
      aYZ();
      if (this.knu.aYf() != null) {
        aZa();
      }
    }
    AppMethodBeat.o(94226);
  }
  
  public final int aYY()
  {
    AppMethodBeat.i(94236);
    int i = this.knu.aYj();
    AppMethodBeat.o(94236);
    return i;
  }
  
  public final void aYe()
  {
    AppMethodBeat.i(94229);
    if (this.currentState == 0) {
      this.knu.aYe();
    }
    AppMethodBeat.o(94229);
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94228);
    if (this.currentState == 0) {
      this.knu.b(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(94228);
  }
  
  public final boolean fR(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(94233);
    if (!com.tencent.mm.media.widget.d.c.aYX())
    {
      Log.i("MicroMsg.CameraPreviewContainer", "only one camera,forbid switch");
      if (!com.tencent.mm.media.widget.d.c.baD())
      {
        AppMethodBeat.o(94233);
        return true;
      }
      AppMethodBeat.o(94233);
      return false;
    }
    Log.i("MicroMsg.CameraPreviewContainer", "flipCamera time space:" + Util.ticksToNow(this.leD));
    if ((!paramBoolean) && (Util.ticksToNow(this.leD) < 1000L))
    {
      paramBoolean = this.ley;
      AppMethodBeat.o(94233);
      return paramBoolean;
    }
    this.leD = Util.currentTicks();
    if (this.leA)
    {
      localObject = this.lew;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
      localObject = this.lex;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
    }
    this.leM.getCameraPreviewView().aMN();
    this.ley = this.knu.aXP();
    Object localObject = this.knu.aYf();
    if (!this.leI)
    {
      com.tencent.mm.media.widget.camerarecordview.c.a locala = this.leG;
      paramBoolean = bool;
      if (!this.ley)
      {
        paramBoolean = bool;
        if (this.leM.aZp()) {
          paramBoolean = true;
        }
      }
      locala.a(paramBoolean, (com.tencent.mm.media.widget.a.b)localObject);
    }
    if (localObject != null)
    {
      this.leM.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
      localObject = c.lfa;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).dv(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
      }
      localObject = c.lfa;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).tm(com.tencent.mm.media.widget.a.b.aVp());
      }
      localObject = c.lfa;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).fj(com.tencent.mm.media.widget.a.b.isFrontCamera());
      }
      localObject = this.lew;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.isFrontCamera());
      }
      localObject = this.lex;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.isFrontCamera());
      }
      localObject = this.lew;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).u(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aXY(), com.tencent.mm.media.widget.a.b.aXZ());
      }
      localObject = this.lex;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).u(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aXY(), com.tencent.mm.media.widget.a.b.aXZ());
      }
      if (this.leA)
      {
        this.leC = new r(Integer.valueOf(com.tencent.mm.media.widget.a.b.aVp()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewWidth()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewHeight()));
        this.leB = true;
      }
    }
    paramBoolean = this.ley;
    AppMethodBeat.o(94233);
    return paramBoolean;
  }
  
  public final Point fS(boolean paramBoolean)
  {
    AppMethodBeat.i(94243);
    Point localPoint = this.knu.fJ(paramBoolean);
    AppMethodBeat.o(94243);
    return localPoint;
  }
  
  public final void fT(boolean paramBoolean)
  {
    AppMethodBeat.i(94248);
    this.knu.fK(paramBoolean);
    AppMethodBeat.o(94248);
  }
  
  public final void k(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94231);
    if (this.currentState == 0) {
      this.knu.k(paramBoolean, paramInt);
    }
    AppMethodBeat.o(94231);
  }
  
  public final boolean l(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94224);
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "startRecord", new Object[0]);
    Object localObject2;
    com.tencent.mm.media.widget.c.b localb;
    if ((this.knu.aYf() != null) && (this.lew != null))
    {
      if (!this.leE)
      {
        Log.i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
        AppMethodBeat.o(94224);
        return false;
      }
      localObject2 = this.lew;
      if (localObject2 != null)
      {
        localObject2 = Integer.valueOf(((com.tencent.mm.media.widget.c.b)localObject2).b(com.tencent.mm.media.widget.a.b.aVp(), paramBoolean, paramInt));
        Log.i("MicroMsg.CameraPreviewContainer", "start record ret:".concat(String.valueOf(localObject2)));
        if (!this.leM.aZq()) {
          break label294;
        }
        localb = this.lex;
        if (localb == null) {}
      }
    }
    label153:
    label294:
    for (localObject1 = Integer.valueOf(localb.b(com.tencent.mm.media.widget.a.b.aVp(), paramBoolean, paramInt));; localObject1 = Integer.valueOf(-1))
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
          Log.i("MicroMsg.CameraPreviewContainer", "start record base ret:" + localObject2 + " daemon ret:" + localObject1 + " ,use daemon record:" + this.leM.aZq());
          this.lez = Util.currentTicks();
          this.leA = true;
          this.leH = false;
          localObject1 = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aWF();
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
    if (!this.leA)
    {
      AppMethodBeat.o(94227);
      return true;
    }
    this.leA = false;
    if (Util.ticksToNow(this.lez) < this.leF)
    {
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", "stopRecord " + Util.ticksToNow(this.lez), new Object[0]);
      paramb = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWG();
      aYW();
      AppMethodBeat.o(94227);
      return false;
    }
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
    final com.tencent.mm.media.k.a locala = new com.tencent.mm.media.k.a("stopRecord");
    final aa.d locald = new aa.d();
    locald.aaBA = 0;
    final aa.f localf1 = new aa.f();
    localf1.aaBC = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
    final aa.f localf2 = new aa.f();
    localf2.aaBC = ((Runnable)new h(this, localf1, paramb));
    if (this.leM.aZq())
    {
      localObject = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWH();
    }
    Object localObject = new aa.f();
    ((aa.f)localObject).aaBC = this.lew;
    com.tencent.mm.media.widget.c.b localb = this.lew;
    if (localb != null) {
      localb.E((Runnable)new f(this, (aa.f)localObject, locala, localf1, locald, localf2, paramb));
    }
    localObject = this.lex;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.c.b)localObject).E((Runnable)new g(this, locala, localf1, locald, localf2, paramb));
    }
    AppMethodBeat.o(94227);
    return true;
  }
  
  public final void q(kotlin.g.a.b<? super byte[], x> paramb)
  {
    AppMethodBeat.i(94239);
    p.k(paramb, "callback");
    this.knu.aXS();
    this.knu.a((g)new b(paramb));
    AppMethodBeat.o(94239);
  }
  
  public final void r(final kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    AppMethodBeat.i(94246);
    p.k(paramb, "callback");
    if (!this.knu.aXQ())
    {
      Log.e("MicroMsg.CameraPreviewContainer", "camera.isCameraPreviewing : false");
      paramb.invoke(null);
      AppMethodBeat.o(94246);
      return;
    }
    if ((com.tencent.mm.media.widget.d.c.a(this.leM)) && (!com.tencent.mm.media.widget.d.c.uA(this.leM.getRecordScene())))
    {
      l = Util.currentTicks();
      this.knu.n((kotlin.g.a.b)new j(this, l, paramb));
      AppMethodBeat.o(94246);
      return;
    }
    final long l = Util.currentTicks();
    com.tencent.mm.media.j.a locala = this.kWg;
    if (locala != null)
    {
      locala.m((kotlin.g.a.b)new i(this, paramb, l));
      locala.aVe();
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
      this.knu.onDestroy();
      this.knu.release();
      Object localObject = this.leG;
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).lfx.disable();
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).context = null;
      localObject = c.lfa;
      c.aZb();
      this.leM.getCameraPreviewView().release();
      localObject = this.lew;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.lew;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.lex;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.lex;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      this.kWg = null;
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
  
  public final void ut(int paramInt)
  {
    AppMethodBeat.i(94230);
    if (this.currentState == 0) {
      this.knu.up(paramInt);
    }
    AppMethodBeat.o(94230);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$Companion;", "", "()V", "REPORT_CAMERA_FIRST_FRAME_COST", "", "REPORT_CAMERA_IS_CAMERA2", "REPORT_CAMERA_OPEN_COST", "REPORT_CREATE_RECORDER", "REPORT_HIGH_RECORD_TIME", "REPORT_LOW_RECORD_TIME", "REPORT_OPEN_CAMERA_TIME_STAMP", "REPORT_PREVIEW_SUCCESS_TIME_STAMP", "REPORT_RECORD_MUXER_TYPE", "REPORT_START_PREVIEW_TIME_STAMP", "STATE_IN_PAUSE", "", "STATE_IN_PREVIEW", "SWITCH_BLOCK_TIME", "TAG", "plugin-mediaeditor_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFrameData"})
  static final class b
    implements g
  {
    b(kotlin.g.a.b paramb) {}
    
    public final boolean ar(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(94214);
      kotlin.g.a.b localb = this.jFa;
      p.j(paramArrayOfByte, "it");
      localb.invoke(paramArrayOfByte);
      AppMethodBeat.o(94214);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.mm.media.g.d, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$setRender$curRenderer$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class d
    extends com.tencent.mm.media.j.d
  {
    d()
    {
      super();
    }
    
    public final com.tencent.mm.media.j.b.a aMT()
    {
      AppMethodBeat.i(94216);
      if (this.leO.leM.aZo())
      {
        locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.f(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
        AppMethodBeat.o(94216);
        return locala;
      }
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
      AppMethodBeat.o(94216);
      return locala;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<SurfaceTexture, x>
  {
    e(a parama, Float paramFloat, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, aa.f paramf1, com.tencent.mm.media.k.a parama1, aa.f paramf2, aa.d paramd, aa.f paramf3, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(94219);
      if (a.f(this.leO))
      {
        AppMethodBeat.o(94219);
        return;
      }
      Object localObject2 = new StringBuilder("stopRecord ");
      Object localObject1 = (com.tencent.mm.media.widget.c.b)this.leR.aaBC;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
        localObject1 = (com.tencent.mm.media.widget.c.b)this.leR.aaBC;
        if (localObject1 == null) {
          break label459;
        }
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).aZe();
        label88:
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
        locala.aIZ();
        a.a(this.leO, "HighRecordStopWaitTime", Long.valueOf(locala.khd.avE()));
        localObject1 = (com.tencent.mm.media.widget.c.b)this.leR.aaBC;
        if (localObject1 == null) {
          break label464;
        }
      }
      label459:
      label464:
      for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
      {
        localObject2 = (com.tencent.mm.media.widget.c.b)this.leR.aaBC;
        if (localObject2 != null) {
          str = ((com.tencent.mm.media.widget.c.b)localObject2).aZe();
        }
        if ((localObject1 == null) || (str == null)) {
          break label497;
        }
        localObject2 = com.tencent.mm.plugin.sight.base.f.aYg((String)localObject1);
        if (localObject2 == null) {
          break label497;
        }
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC).lfl = true;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC).OJ((String)localObject1);
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC).OK(str);
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC).fod = 0;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC).endTime = ((com.tencent.mm.plugin.sight.base.b)localObject2).videoDuration;
        localObject1 = locald;
        ((aa.d)localObject1).aaBA += 1;
        Log.i("MicroMsg.CameraPreviewContainer", "record video info main: ".concat(String.valueOf(localObject2)));
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWU();
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.FU(((com.tencent.mm.plugin.sight.base.b)localObject2).videoBitrate);
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.FV(((com.tencent.mm.plugin.sight.base.b)localObject2).frameRate);
        if (((!this.leO.leM.aZq()) || (locald.aaBA != 2)) && (this.leO.leM.aZq())) {
          break label475;
        }
        if ((this.leO.leM.aZq()) && (locald.aaBA == 2))
        {
          localObject1 = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aWI();
        }
        MMHandlerThread.removeRunnable((Runnable)localf2.aaBC);
        a.g(this.leO);
        localObject1 = paramb;
        if (localObject1 == null) {
          break label469;
        }
        ((kotlin.g.a.b)localObject1).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC);
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
      MMHandlerThread.postToMainThreadDelayed((Runnable)localf2.aaBC, 3000L);
      AppMethodBeat.o(94219);
      return;
      label497:
      AppMethodBeat.o(94219);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama, com.tencent.mm.media.k.a parama1, aa.f paramf1, aa.d paramd, aa.f paramf2, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(94220);
      if (a.f(this.leO))
      {
        AppMethodBeat.o(94220);
        return;
      }
      Object localObject2 = new StringBuilder("stop daemonRecorder ");
      Object localObject1 = a.e(this.leO);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
        localObject1 = a.e(this.leO);
        if (localObject1 == null) {
          break label409;
        }
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).aZe();
        label82:
        Log.printInfoStack("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
        locala.aIZ();
        a.a(this.leO, "LowRecordStopWaitTime", Long.valueOf(locala.khd.avE()));
        localObject1 = a.e(this.leO);
        if (localObject1 == null) {
          break label414;
        }
      }
      label409:
      label414:
      for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
      {
        localObject2 = a.e(this.leO);
        if (localObject2 != null) {
          str = ((com.tencent.mm.media.widget.c.b)localObject2).aZe();
        }
        if ((localObject1 == null) || (str == null)) {
          break label447;
        }
        localObject2 = com.tencent.mm.plugin.sight.base.f.aYg((String)localObject1);
        if (localObject2 == null) {
          break label447;
        }
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC).lfl = true;
        com.tencent.mm.media.widget.camerarecordview.b.b localb = (com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC;
        p.k(localObject1, "<set-?>");
        localb.lfm = ((String)localObject1);
        localObject1 = (com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC;
        p.k(str, "<set-?>");
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfn = str;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC).lfo = 0;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC).lfp = ((com.tencent.mm.plugin.sight.base.b)localObject2).videoDuration;
        localObject1 = locald;
        ((aa.d)localObject1).aaBA += 1;
        Log.i("MicroMsg.CameraPreviewContainer", "record video info daemon: ".concat(String.valueOf(localObject2)));
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWV();
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.FW(((com.tencent.mm.plugin.sight.base.b)localObject2).videoBitrate);
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.FX(((com.tencent.mm.plugin.sight.base.b)localObject2).frameRate);
        if (locald.aaBA != 2) {
          break label425;
        }
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWI();
        MMHandlerThread.removeRunnable((Runnable)localf2.aaBC);
        a.g(this.leO);
        localObject1 = paramb;
        if (localObject1 == null) {
          break label419;
        }
        ((kotlin.g.a.b)localObject1).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC);
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
      MMHandlerThread.postToMainThreadDelayed((Runnable)localf2.aaBC, 3000L);
      AppMethodBeat.o(94220);
      return;
      label447:
      AppMethodBeat.o(94220);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(a parama, aa.f paramf, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(94221);
      if (!((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC).aZg())
      {
        localObject = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWJ();
        localObject = a.d(this.leO);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).cancel();
        }
      }
      if (!((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC).aZf())
      {
        localObject = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWK();
        localObject = a.e(this.leO);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).cancel();
        }
      }
      a.g(this.leO);
      Object localObject = paramb;
      if (localObject != null)
      {
        ((kotlin.g.a.b)localObject).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.aaBC);
        AppMethodBeat.o(94221);
        return;
      }
      AppMethodBeat.o(94221);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/nio/IntBuffer;", "invoke", "com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$takePicture$2$1"})
  static final class i
    extends q
    implements kotlin.g.a.b<IntBuffer, x>
  {
    i(a parama, kotlin.g.a.b paramb, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a
 * JD-Core Version:    0.7.0.1
 */