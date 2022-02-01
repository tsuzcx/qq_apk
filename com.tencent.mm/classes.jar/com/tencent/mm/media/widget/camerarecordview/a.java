package com.tencent.mm.media.widget.camerarecordview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.g.b.v.c;
import d.g.b.v.e;
import d.v;
import d.y;
import java.nio.IntBuffer;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "currentState", "", "customOrientation", "", "daemonRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "frameRenderCallback", "Lkotlin/Function0;", "", "getFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "initRecorderRet", "isRecording", "lastFlipCameraStamp", "", "mIsUseApi2", "mediaRecorder", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordFinish", "recordMiniTime", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "startRecordTimeStamp", "getStartRecordTimeStamp", "()J", "setStartRecordTimeStamp", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "afterStartPreview", "cancelRecord", "checkFlashStatus", "openFlash", "configVendorTagValue", "tag", "", "createImageReaderCallback", "callback", "", "data", "createRecorder", "enableSwitchCamera", "getCameraOrientaion", "getCameraPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getFlashMode", "getMD5", "getRecordFilePath", "getRecordTime", "getSupportZoomRatios", "", "initRecorder", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "isPreviewing", "isUseBackGroundCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "resetRecord", "setCustomOrientationEnable", "enable", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "flash", "setForceZoomTargetRatio", "ratio", "setMute", "mute", "setRecordMiniTime", "time", "setRender", "startPreview", "displayRatio", "success", "startRecord", "isLandscape", "deviceDegree", "stopPreview", "stopRecord", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "capture", "switchCamera", "ignoreFlipCheck", "switchVendorTag", "isChecked", "takePicture", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a gAO;
  d.g.a.a<y> KBP;
  private Context context;
  public int currentState;
  private com.tencent.mm.media.widget.c.b gAA;
  private com.tencent.mm.media.widget.c.b gAB;
  private final ap gAC;
  public boolean gAD;
  public long gAE;
  private boolean gAF;
  private long gAG;
  private boolean gAH;
  private long gAI;
  private boolean gAJ;
  public com.tencent.mm.media.widget.camerarecordview.c.a gAK;
  private volatile boolean gAL;
  public boolean gAM;
  public com.tencent.mm.media.widget.camerarecordview.d.a gAN;
  public final com.tencent.mm.media.widget.a.e gAz;
  com.tencent.mm.media.i.a gsB;
  public d.g.a.b<? super Boolean, y> gxB;
  
  static
  {
    AppMethodBeat.i(94250);
    gAO = new a.a((byte)0);
    AppMethodBeat.o(94250);
  }
  
  public a(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94249);
    this.gAN = parama;
    this.gAC = new ap(Looper.getMainLooper());
    this.gAD = true;
    this.currentState = 1;
    this.gAI = 2000L;
    ad.m("MicroMsg.CameraPreviewContainer", this.gAN.toString(), new Object[0]);
    parama = this.gAN.getCameraPreviewView();
    Object localObject;
    if (this.gAN.getPreviewRenderer() != null)
    {
      this.gsB = this.gAN.getPreviewRenderer();
      localObject = this.gAN.getPreviewRenderer();
      if (localObject == null) {
        k.fvU();
      }
      parama.a((com.tencent.mm.media.i.a)localObject, this.gAN.aof());
      if (!com.tencent.mm.media.widget.d.a.a(this.gAN)) {
        break label277;
      }
      this.gAz = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.b.e(this.gAN.getContext()));
      if (com.tencent.mm.media.widget.d.a.b(this.gAN)) {
        this.gAz.amw();
      }
      this.gAJ = true;
    }
    for (;;)
    {
      this.gAG = bt.GC();
      this.context = this.gAN.getContext();
      this.gAK = new com.tencent.mm.media.widget.camerarecordview.c.a(this.context, this.gAN);
      AppMethodBeat.o(94249);
      return;
      localObject = new d(this);
      this.gsB = ((com.tencent.mm.media.i.a)localObject);
      parama.a((com.tencent.mm.media.i.a)localObject, this.gAN.aof());
      break;
      label277:
      this.gAJ = false;
      this.gAz = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.a.d(this.gAN.getContext()));
    }
  }
  
  public static boolean anO()
  {
    AppMethodBeat.i(94235);
    boolean bool = com.tencent.mm.media.widget.d.a.anO();
    AppMethodBeat.o(94235);
    return bool;
  }
  
  private final boolean anQ()
  {
    AppMethodBeat.i(94238);
    Object localObject1 = this.gAN.getRecorder();
    ad.i("MicroMsg.CameraPreviewContainer", "createRecorder: " + this.gAA + ", useCpuCrop:" + this.gAN.aof() + ", process.getRecorder():" + localObject1 + ", mute:" + this.gAN.Ny());
    Object localObject2 = this.gAA;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.gAB;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.gAN.getEncodeConfig();
    if (localObject1 != null) {
      this.gAA = ((com.tencent.mm.media.widget.c.b)localObject1);
    }
    for (;;)
    {
      localObject1 = this.gAA;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(this.gAN.Ny());
      }
      localObject1 = this.gAB;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(true);
      }
      this.gAN.getCameraPreviewView().setOnDrawListener((d.g.a.b)new a.c(this));
      ad.i("MicroMsg.CameraPreviewContainer", "create recorder finish");
      AppMethodBeat.o(94238);
      return true;
      if (this.gAN.aof())
      {
        localObject1 = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.akF();
        localObject1 = c.gBa;
      }
      EGLContext localEGLContext;
      for (localObject1 = c.a(((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).anW(), this.gAN.getVideoTransPara(), this.gAz, this.gAN.getRecordRenderer());; localObject1 = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.e)localObject3, localEGLContext, this.gAN.getCameraPreviewView(), this.gAN.aof(), this.gAN.getRecordRenderer()))
      {
        this.gAA = ((com.tencent.mm.media.widget.c.b)localObject1);
        if (!this.gAN.aoh()) {
          break;
        }
        localObject1 = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.akE();
        if (this.gAN.getCameraPreviewView().getEGLContext() != null) {
          break label486;
        }
        ad.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
        localObject1 = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.akG();
        AppMethodBeat.o(94238);
        return false;
        localObject1 = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.akE();
        if (this.gAN.getCameraPreviewView().getEGLContext() == null)
        {
          ad.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
          localObject1 = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.akG();
          AppMethodBeat.o(94238);
          return false;
        }
        localObject1 = c.gBa;
        i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).anW();
        localObject1 = this.gAN.getVideoTransPara();
        localObject3 = this.gAz;
        localEGLContext = this.gAN.getCameraPreviewView().getEGLContext();
        if (localEGLContext == null) {
          k.fvU();
        }
      }
      label486:
      localObject1 = c.gBa;
      int i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).anW();
      localObject1 = this.gAN.getDaemonVideoTransPara();
      localObject2 = this.gAz;
      Object localObject3 = this.gAN.getCameraPreviewView().getEGLContext();
      if (localObject3 == null) {
        k.fvU();
      }
      this.gAB = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.e)localObject2, (EGLContext)localObject3, this.gAN.getCameraPreviewView(), this.gAN.aof(), this.gAN.getRecordRenderer());
    }
  }
  
  private final void anR()
  {
    com.tencent.mm.media.widget.c.b localb1 = null;
    AppMethodBeat.i(94240);
    com.tencent.mm.media.widget.c.b localb2 = this.gAA;
    if (localb2 != null) {
      localb2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.amz(), com.tencent.mm.media.widget.a.b.amA());
    }
    if (localb2 != null) {
      localb2.setFilePath(this.gAN.getEncodeConfig().getFilePath());
    }
    if (localb2 != null) {
      localb2.ru(this.gAN.getEncodeConfig().anX());
    }
    StringBuilder localStringBuilder = new StringBuilder("filePath : ");
    Object localObject;
    label143:
    label306:
    boolean bool1;
    label373:
    boolean bool2;
    if (localb2 != null)
    {
      localObject = localb2.getFilePath();
      localStringBuilder = localStringBuilder.append((String)localObject).append("   thumbPath : ");
      if (localb2 == null) {
        break label445;
      }
      localObject = localb2.anX();
      ad.m("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localb2 = this.gAB;
      if (localb2 != null) {
        localb2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.amz(), com.tencent.mm.media.widget.a.b.amA());
      }
      if (localb2 != null) {
        localb2.setFilePath(this.gAN.getEncodeConfig().getFilePath() + "_daemon");
      }
      if (localb2 != null) {
        localb2.ru(this.gAN.getEncodeConfig().anX() + "_daemon");
      }
      localStringBuilder = new StringBuilder("filePath : ");
      if (localb2 == null) {
        break label450;
      }
      localObject = localb2.getFilePath();
      localStringBuilder = localStringBuilder.append((String)localObject).append("   thumbPath : ");
      localObject = localb1;
      if (localb2 != null) {
        localObject = localb2.anX();
      }
      ad.m("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localObject = this.gAA;
      if (localObject == null) {
        break label455;
      }
      bool1 = ((com.tencent.mm.media.widget.c.b)localObject).mQ(com.tencent.mm.media.widget.a.b.amy());
      localObject = this.gAB;
      if (localObject == null) {
        break label460;
      }
      bool2 = ((com.tencent.mm.media.widget.c.b)localObject).mQ(com.tencent.mm.media.widget.a.b.amy());
    }
    for (;;)
    {
      if (((this.gAB instanceof com.tencent.mm.media.widget.c.c)) && ((this.gAA instanceof com.tencent.mm.media.widget.c.c)))
      {
        localObject = this.gAB;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
          AppMethodBeat.o(94240);
          throw ((Throwable)localObject);
          localObject = null;
          break;
          label445:
          localObject = null;
          break label143;
          label450:
          localObject = null;
          break label306;
          label455:
          bool1 = false;
          break label373;
          label460:
          bool2 = false;
          continue;
        }
        localObject = (com.tencent.mm.media.widget.c.c)localObject;
        localb1 = this.gAA;
        if (localb1 == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
          AppMethodBeat.o(94240);
          throw ((Throwable)localObject);
        }
        ((com.tencent.mm.media.widget.c.c)localObject).a(((com.tencent.mm.media.widget.c.c)localb1).aoz());
      }
    }
    if (((this.gAB instanceof com.tencent.mm.media.widget.c.e)) && ((this.gAA instanceof com.tencent.mm.media.widget.c.e)))
    {
      localObject = this.gAB;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.media.widget.c.e)localObject;
      localb1 = this.gAA;
      if (localb1 == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.media.widget.c.e)localObject).a(((com.tencent.mm.media.widget.c.e)localb1).aoz());
    }
    ad.m("MicroMsg.CameraPreviewContainer", "init recorder ret:" + bool1 + "  daemonRet:" + bool2, new Object[0]);
    this.gAH = bool1;
    AppMethodBeat.o(94240);
  }
  
  public final void a(boolean paramBoolean, final d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(94241);
    if (this.currentState == 0)
    {
      ad.e("MicroMsg.CameraPreviewContainer", "startPreview, already in preview state");
      AppMethodBeat.o(94241);
      return;
    }
    this.currentState = 0;
    ad.m("MicroMsg.CameraPreviewContainer", "startPreview process.useCpuCrop():" + this.gAN.aof(), new Object[0]);
    this.gAD = paramBoolean;
    if ((!this.gAD) && (!com.tencent.mm.media.widget.d.a.aoM()))
    {
      this.gAD = true;
      ad.i("MicroMsg.CameraPreviewContainer", "force useBackGroundCamera");
    }
    if ((this.gAD) && (!com.tencent.mm.media.widget.d.a.aoN()))
    {
      this.gAD = false;
      ad.i("MicroMsg.CameraPreviewContainer", "force useFrontGroundCamera");
    }
    this.gAz.q(this.gAN.getContext(), this.gAD);
    if (this.gAN.aof()) {
      this.gAz.a(this.gAN.getCameraPreviewView().getFrameDataCallback());
    }
    this.gAN.getCameraPreviewView().m((d.g.a.b)new e(this, paramb));
    AppMethodBeat.o(94241);
  }
  
  public final void amF()
  {
    AppMethodBeat.i(94229);
    if (this.currentState == 0) {
      this.gAz.amF();
    }
    AppMethodBeat.o(94229);
  }
  
  public final void anN()
  {
    AppMethodBeat.i(94226);
    try
    {
      ad.i("MicroMsg.CameraPreviewContainer", "cancelRecord");
      com.tencent.mm.media.widget.c.b localb = this.gAA;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.gAA;
      if (localb != null) {
        localb.clear();
      }
      localb = this.gAB;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.gAB;
      if (localb != null) {
        localb.clear();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "cancel record error", new Object[0]);
      }
    }
    if (this.gAz.amv())
    {
      anQ();
      if (this.gAz.amG() != null) {
        anR();
      }
    }
    AppMethodBeat.o(94226);
  }
  
  public final int anP()
  {
    AppMethodBeat.i(94236);
    int i = this.gAz.amL();
    AppMethodBeat.o(94236);
    return i;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94228);
    if (this.currentState == 0) {
      this.gAz.b(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(94228);
  }
  
  public final boolean dS(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(94233);
    if (!com.tencent.mm.media.widget.d.a.anO())
    {
      ad.i("MicroMsg.CameraPreviewContainer", "only one camera,forbid switch");
      if (!com.tencent.mm.media.widget.d.a.aoM())
      {
        AppMethodBeat.o(94233);
        return true;
      }
      AppMethodBeat.o(94233);
      return false;
    }
    ad.i("MicroMsg.CameraPreviewContainer", "flipCamera time space:" + bt.aS(this.gAG));
    if ((!paramBoolean) && (bt.aS(this.gAG) < 1000L))
    {
      paramBoolean = this.gAD;
      AppMethodBeat.o(94233);
      return paramBoolean;
    }
    this.gAG = bt.GC();
    if (this.gAF)
    {
      localObject = this.gAA;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
      localObject = this.gAB;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
    }
    this.gAN.getCameraPreviewView().anT();
    this.gAD = this.gAz.amu();
    Object localObject = this.gAz.amG();
    com.tencent.mm.media.widget.camerarecordview.c.a locala;
    if (!this.gAM)
    {
      locala = this.gAK;
      if ((this.gAD) || (!this.gAN.aog())) {
        break label462;
      }
    }
    label462:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.a(paramBoolean, (com.tencent.mm.media.widget.a.b)localObject);
      if (localObject != null)
      {
        this.gAN.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
        localObject = c.gBa;
        localObject = c.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.i.a)localObject).cS(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
        }
        localObject = c.gBa;
        localObject = c.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.i.a)localObject).mz(com.tencent.mm.media.widget.a.b.amy());
        }
        localObject = c.gBa;
        localObject = c.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.i.a)localObject).dJ(com.tencent.mm.media.widget.a.b.amB());
        }
        localObject = this.gAA;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.amB());
        }
        localObject = this.gAB;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.amB());
        }
        localObject = this.gAA;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.amz(), com.tencent.mm.media.widget.a.b.amA());
        }
        localObject = this.gAB;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.amz(), com.tencent.mm.media.widget.a.b.amA());
        }
        if (this.gAF)
        {
          localObject = this.gAA;
          if (localObject != null) {
            ((com.tencent.mm.media.widget.c.b)localObject).J(com.tencent.mm.media.widget.a.b.amy(), com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          }
          localObject = this.gAB;
          if (localObject != null) {
            ((com.tencent.mm.media.widget.c.b)localObject).J(com.tencent.mm.media.widget.a.b.amy(), com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          }
        }
      }
      paramBoolean = this.gAD;
      AppMethodBeat.o(94233);
      return paramBoolean;
    }
  }
  
  public final Point dT(boolean paramBoolean)
  {
    AppMethodBeat.i(94243);
    Point localPoint = this.gAz.dL(paramBoolean);
    AppMethodBeat.o(94243);
    return localPoint;
  }
  
  public final void dU(boolean paramBoolean)
  {
    AppMethodBeat.i(94248);
    this.gAz.dM(paramBoolean);
    AppMethodBeat.o(94248);
  }
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94231);
    if (this.currentState == 0) {
      this.gAz.i(paramBoolean, paramInt);
    }
    AppMethodBeat.o(94231);
  }
  
  public final boolean j(d.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, y> paramb)
  {
    AppMethodBeat.i(94227);
    if (!this.gAF)
    {
      AppMethodBeat.o(94227);
      return true;
    }
    this.gAF = false;
    if (bt.aS(this.gAE) < this.gAI)
    {
      ad.m("MicroMsg.CameraPreviewContainer", "stopRecord " + bt.aS(this.gAE), new Object[0]);
      paramb = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.alt();
      anN();
      AppMethodBeat.o(94227);
      return false;
    }
    ad.m("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
    com.tencent.mm.media.j.a locala = new com.tencent.mm.media.j.a("stopRecord");
    v.c localc = new v.c();
    localc.Jhu = 0;
    v.e locale1 = new v.e();
    locale1.Jhw = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, 16383);
    v.e locale2 = new v.e();
    locale2.Jhw = ((Runnable)new a.h(this, locale1, paramb));
    if (this.gAN.aoh())
    {
      localObject = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.alu();
    }
    Object localObject = new v.e();
    ((v.e)localObject).Jhw = this.gAA;
    com.tencent.mm.media.widget.c.b localb = this.gAA;
    if (localb != null) {
      localb.C((Runnable)new a.f(this, (v.e)localObject, locala, locale1, localc, locale2, paramb));
    }
    localObject = this.gAB;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.c.b)localObject).C((Runnable)new a.g(this, locala, locale1, localc, locale2, paramb));
    }
    AppMethodBeat.o(94227);
    return true;
  }
  
  public final boolean j(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94224);
    ad.m("MicroMsg.CameraPreviewContainer", "startRecord", new Object[0]);
    Object localObject2;
    com.tencent.mm.media.widget.c.b localb;
    if ((this.gAz.amG() != null) && (this.gAA != null))
    {
      if (!this.gAH)
      {
        ad.i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
        AppMethodBeat.o(94224);
        return false;
      }
      localObject2 = this.gAA;
      if (localObject2 != null)
      {
        localObject2 = Integer.valueOf(((com.tencent.mm.media.widget.c.b)localObject2).b(com.tencent.mm.media.widget.a.b.amy(), paramBoolean, paramInt));
        ad.i("MicroMsg.CameraPreviewContainer", "start record ret:".concat(String.valueOf(localObject2)));
        if (!this.gAN.aoh()) {
          break label289;
        }
        localb = this.gAB;
        if (localb == null) {}
      }
    }
    label150:
    label289:
    for (localObject1 = Integer.valueOf(localb.b(com.tencent.mm.media.widget.a.b.amy(), paramBoolean, paramInt));; localObject1 = Integer.valueOf(-1))
    {
      if (localObject2 == null) {
        if (localObject1 != null) {
          break label259;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(94224);
        return false;
        localObject2 = null;
        break;
        if (((Integer)localObject2).intValue() != 0) {
          break label150;
        }
        do
        {
          ad.i("MicroMsg.CameraPreviewContainer", "start record base ret:" + localObject2 + " daemon ret:" + localObject1 + " ,use daemon record:" + this.gAN.aoh());
          this.gAE = bt.GC();
          this.gAF = true;
          this.gAL = false;
          localObject1 = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.als();
          AppMethodBeat.o(94224);
          return true;
        } while (((Integer)localObject1).intValue() == 0);
      }
      ad.m("MicroMsg.CameraPreviewContainer", "cameraConfig is null", new Object[0]);
      AppMethodBeat.o(94224);
      return false;
    }
  }
  
  public final void k(d.g.a.b<? super byte[], y> paramb)
  {
    AppMethodBeat.i(94239);
    k.h(paramb, "callback");
    this.gAz.amx();
    this.gAz.a((g)new a.b(paramb));
    AppMethodBeat.o(94239);
  }
  
  public final void l(final d.g.a.b<? super Bitmap, y> paramb)
  {
    AppMethodBeat.i(94246);
    k.h(paramb, "callback");
    if (!this.gAz.amv())
    {
      ad.e("MicroMsg.CameraPreviewContainer", "camera.isCameraPreviewing : false");
      paramb.aA(null);
      AppMethodBeat.o(94246);
      return;
    }
    if ((com.tencent.mm.media.widget.d.a.c(this.gAN)) && (!com.tencent.mm.media.widget.d.a.b(this.gAN)))
    {
      l = bt.GC();
      this.gAz.h((d.g.a.b)new j(this, l, paramb));
      AppMethodBeat.o(94246);
      return;
    }
    final long l = bt.GC();
    com.tencent.mm.media.i.a locala = this.gsB;
    if (locala != null)
    {
      locala.g((d.g.a.b)new i(this, paramb, l));
      locala.akm();
      AppMethodBeat.o(94246);
      return;
    }
    AppMethodBeat.o(94246);
  }
  
  public final void lQ(long paramLong)
  {
    AppMethodBeat.i(94232);
    ad.i("MicroMsg.CameraPreviewContainer", "setRecordMiniTime:".concat(String.valueOf(paramLong)));
    this.gAI = paramLong;
    AppMethodBeat.o(94232);
  }
  
  public final void mN(int paramInt)
  {
    AppMethodBeat.i(94230);
    if (this.currentState == 0) {
      this.gAz.mJ(paramInt);
    }
    AppMethodBeat.o(94230);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94237);
    try
    {
      ad.i("MicroMsg.CameraPreviewContainer", "release");
      this.gAz.onDestroy();
      this.gAz.release();
      Object localObject = this.gAK;
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).gBx.disable();
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).context = null;
      localObject = c.gBa;
      c.anU();
      this.gAN.getCameraPreviewView().release();
      localObject = this.gAA;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.gAA;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.gAB;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.gAB;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.gsB;
      if (localObject != null) {
        com.tencent.mm.media.i.a.a((com.tencent.mm.media.i.a)localObject);
      }
      this.gsB = null;
      AppMethodBeat.o(94237);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "camera release error:" + localException.getMessage(), new Object[0]);
      }
    }
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
    ad.m("MicroMsg.CameraPreviewContainer", "stopPreview", new Object[0]);
    try
    {
      this.gAz.release();
      this.gAz.b(this.gAN.getCameraPreviewView().getFrameDataCallback());
      this.gAN.getCameraPreviewView().anS();
      if (!this.gAM) {
        this.gAK.a(false, null);
      }
      AppMethodBeat.o(94245);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "camera relase error:" + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  public final void z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94247);
    k.h(paramString, "tag");
    this.gAz.z(paramString, paramBoolean);
    AppMethodBeat.o(94247);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$setRender$curRenderer$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class d
    extends com.tencent.mm.media.i.d
  {
    d(int paramInt)
    {
      super();
    }
    
    public final com.tencent.mm.media.i.b.a akj()
    {
      AppMethodBeat.i(94216);
      if (this.gAP.gAN.aof())
      {
        locala = (com.tencent.mm.media.i.b.a)new com.tencent.mm.media.i.b.e(this.guI, this.guJ, this.guK, this.guL, this.guM, this.scaleType);
        AppMethodBeat.o(94216);
        return locala;
      }
      com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new com.tencent.mm.media.i.b.c(this.guI, this.guJ, this.guK, this.guL, this.guM, this.scaleType);
      AppMethodBeat.o(94216);
      return locala;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<SurfaceTexture, y>
  {
    e(a parama, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/nio/IntBuffer;", "invoke", "com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$takePicture$2$1"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<IntBuffer, y>
  {
    i(a parama, d.g.a.b paramb, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<Bitmap, y>
  {
    j(a parama, long paramLong, d.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a
 * JD-Core Version:    0.7.0.1
 */