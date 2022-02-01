package com.tencent.mm.media.widget.camerarecordview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.g.b.v.d;
import d.g.b.v.f;
import d.v;
import d.y;
import java.nio.IntBuffer;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "currentState", "", "customOrientation", "", "daemonRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "frameRenderCallback", "Lkotlin/Function0;", "", "getFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "initRecorderRet", "isRecording", "lastFlipCameraStamp", "", "mIsUseApi2", "mediaRecorder", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordFinish", "recordMiniTime", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "startRecordTimeStamp", "getStartRecordTimeStamp", "()J", "setStartRecordTimeStamp", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "afterStartPreview", "cancelRecord", "checkFlashStatus", "openFlash", "configVendorTagValue", "tag", "", "createImageReaderCallback", "callback", "", "data", "createRecorder", "enableSwitchCamera", "getCameraOrientaion", "getCameraPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getFlashMode", "getMD5", "getRecordFilePath", "getRecordTime", "getSupportZoomRatios", "", "initRecorder", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "isPreviewing", "isUseBackGroundCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "resetRecord", "setCustomOrientationEnable", "enable", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "flash", "setForceZoomTargetRatio", "ratio", "setMute", "mute", "setRecordMiniTime", "time", "setRender", "startPreview", "displayRatio", "success", "startRecord", "isLandscape", "deviceDegree", "stopPreview", "stopRecord", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "capture", "switchCamera", "ignoreFlipCheck", "switchVendorTag", "isChecked", "takePicture", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a hbk;
  private Context context;
  public int currentState;
  com.tencent.mm.media.i.a gTi;
  public d.g.a.b<? super Boolean, y> gXY;
  public final com.tencent.mm.media.widget.a.e goG;
  private final ao gox;
  private com.tencent.mm.media.widget.c.b haW;
  private com.tencent.mm.media.widget.c.b haX;
  public boolean haY;
  public long haZ;
  private boolean hba;
  private long hbb;
  private boolean hbc;
  private long hbd;
  private boolean hbe;
  public com.tencent.mm.media.widget.camerarecordview.c.a hbf;
  private volatile boolean hbg;
  public boolean hbh;
  d.g.a.a<y> hbi;
  public com.tencent.mm.media.widget.camerarecordview.d.a hbj;
  
  static
  {
    AppMethodBeat.i(94250);
    hbk = new a.a((byte)0);
    AppMethodBeat.o(94250);
  }
  
  public a(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94249);
    this.hbj = parama;
    this.gox = new ao(Looper.getMainLooper());
    this.haY = true;
    this.currentState = 1;
    this.hbd = 2000L;
    ac.m("MicroMsg.CameraPreviewContainer", this.hbj.toString(), new Object[0]);
    parama = this.hbj.getCameraPreviewView();
    Object localObject;
    if (this.hbj.getPreviewRenderer() != null)
    {
      this.gTi = this.hbj.getPreviewRenderer();
      localObject = this.hbj.getPreviewRenderer();
      if (localObject == null) {
        k.fOy();
      }
      parama.a((com.tencent.mm.media.i.a)localObject, this.hbj.auW());
      if (!com.tencent.mm.media.widget.d.a.a(this.hbj)) {
        break label277;
      }
      this.goG = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.b.e(this.hbj.getContext()));
      if (com.tencent.mm.media.widget.d.a.b(this.hbj)) {
        this.goG.ato();
      }
      this.hbe = true;
    }
    for (;;)
    {
      this.hbb = bs.Gn();
      this.context = this.hbj.getContext();
      this.hbf = new com.tencent.mm.media.widget.camerarecordview.c.a(this.context, this.hbj);
      AppMethodBeat.o(94249);
      return;
      localObject = new d(this);
      this.gTi = ((com.tencent.mm.media.i.a)localObject);
      parama.a((com.tencent.mm.media.i.a)localObject, this.hbj.auW());
      break;
      label277:
      this.hbe = false;
      this.goG = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.a.d(this.hbj.getContext()));
    }
  }
  
  public static boolean auG()
  {
    AppMethodBeat.i(94235);
    boolean bool = com.tencent.mm.media.widget.d.a.auG();
    AppMethodBeat.o(94235);
    return bool;
  }
  
  private final boolean auI()
  {
    AppMethodBeat.i(94238);
    Object localObject1 = this.hbj.getRecorder();
    ac.i("MicroMsg.CameraPreviewContainer", "createRecorder: " + this.haW + ", useCpuCrop:" + this.hbj.auW() + ", process.getRecorder():" + localObject1 + ", mute:" + this.hbj.Nw());
    Object localObject2 = this.haW;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.haX;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.hbj.getEncodeConfig();
    if (localObject1 != null) {
      this.haW = ((com.tencent.mm.media.widget.c.b)localObject1);
    }
    for (;;)
    {
      localObject1 = this.haW;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(this.hbj.Nw());
      }
      localObject1 = this.haX;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(true);
      }
      this.hbj.getCameraPreviewView().setOnDrawListener((d.g.a.b)new a.c(this));
      ac.i("MicroMsg.CameraPreviewContainer", "create recorder finish");
      AppMethodBeat.o(94238);
      return true;
      if (this.hbj.auW())
      {
        localObject1 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arz();
        localObject1 = c.hbw;
      }
      EGLContext localEGLContext;
      for (localObject1 = c.a(((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).auM(), this.hbj.getVideoTransPara(), this.goG, this.hbj.getRecordRenderer());; localObject1 = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.e)localObject3, localEGLContext, this.hbj.getCameraPreviewView(), this.hbj.auW(), this.hbj.getRecordRenderer()))
      {
        this.haW = ((com.tencent.mm.media.widget.c.b)localObject1);
        if (!this.hbj.auY()) {
          break;
        }
        localObject1 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.ary();
        if (this.hbj.getCameraPreviewView().getEGLContext() != null) {
          break label486;
        }
        ac.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
        localObject1 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arA();
        AppMethodBeat.o(94238);
        return false;
        localObject1 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.ary();
        if (this.hbj.getCameraPreviewView().getEGLContext() == null)
        {
          ac.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
          localObject1 = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.arA();
          AppMethodBeat.o(94238);
          return false;
        }
        localObject1 = c.hbw;
        i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).auM();
        localObject1 = this.hbj.getVideoTransPara();
        localObject3 = this.goG;
        localEGLContext = this.hbj.getCameraPreviewView().getEGLContext();
        if (localEGLContext == null) {
          k.fOy();
        }
      }
      label486:
      localObject1 = c.hbw;
      int i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).auM();
      localObject1 = this.hbj.getDaemonVideoTransPara();
      localObject2 = this.goG;
      Object localObject3 = this.hbj.getCameraPreviewView().getEGLContext();
      if (localObject3 == null) {
        k.fOy();
      }
      this.haX = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.e)localObject2, (EGLContext)localObject3, this.hbj.getCameraPreviewView(), this.hbj.auW(), this.hbj.getRecordRenderer());
    }
  }
  
  private final void auJ()
  {
    com.tencent.mm.media.widget.c.b localb1 = null;
    AppMethodBeat.i(94240);
    com.tencent.mm.media.widget.c.b localb2 = this.haW;
    if (localb2 != null) {
      localb2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.atr(), com.tencent.mm.media.widget.a.b.ats());
    }
    if (localb2 != null) {
      localb2.setFilePath(this.hbj.getEncodeConfig().getFilePath());
    }
    if (localb2 != null) {
      localb2.vx(this.hbj.getEncodeConfig().auN());
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
      localObject = localb2.auN();
      ac.m("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localb2 = this.haX;
      if (localb2 != null) {
        localb2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.atr(), com.tencent.mm.media.widget.a.b.ats());
      }
      if (localb2 != null) {
        localb2.setFilePath(this.hbj.getEncodeConfig().getFilePath() + "_daemon");
      }
      if (localb2 != null) {
        localb2.vx(this.hbj.getEncodeConfig().auN() + "_daemon");
      }
      localStringBuilder = new StringBuilder("filePath : ");
      if (localb2 == null) {
        break label450;
      }
      localObject = localb2.getFilePath();
      localStringBuilder = localStringBuilder.append((String)localObject).append("   thumbPath : ");
      localObject = localb1;
      if (localb2 != null) {
        localObject = localb2.auN();
      }
      ac.m("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localObject = this.haW;
      if (localObject == null) {
        break label455;
      }
      bool1 = ((com.tencent.mm.media.widget.c.b)localObject).nE(com.tencent.mm.media.widget.a.b.atq());
      localObject = this.haX;
      if (localObject == null) {
        break label460;
      }
      bool2 = ((com.tencent.mm.media.widget.c.b)localObject).nE(com.tencent.mm.media.widget.a.b.atq());
    }
    for (;;)
    {
      if (((this.haX instanceof com.tencent.mm.media.widget.c.c)) && ((this.haW instanceof com.tencent.mm.media.widget.c.c)))
      {
        localObject = this.haX;
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
        localb1 = this.haW;
        if (localb1 == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
          AppMethodBeat.o(94240);
          throw ((Throwable)localObject);
        }
        ((com.tencent.mm.media.widget.c.c)localObject).a(((com.tencent.mm.media.widget.c.c)localb1).avp());
      }
    }
    if (((this.haX instanceof com.tencent.mm.media.widget.c.e)) && ((this.haW instanceof com.tencent.mm.media.widget.c.e)))
    {
      localObject = this.haX;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.media.widget.c.e)localObject;
      localb1 = this.haW;
      if (localb1 == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.media.widget.c.e)localObject).a(((com.tencent.mm.media.widget.c.e)localb1).avp());
    }
    ac.m("MicroMsg.CameraPreviewContainer", "init recorder ret:" + bool1 + "  daemonRet:" + bool2, new Object[0]);
    this.hbc = bool1;
    AppMethodBeat.o(94240);
  }
  
  public final void A(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94247);
    k.h(paramString, "tag");
    this.goG.A(paramString, paramBoolean);
    AppMethodBeat.o(94247);
  }
  
  public final void a(boolean paramBoolean, final d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(94241);
    if (this.currentState == 0)
    {
      ac.e("MicroMsg.CameraPreviewContainer", "startPreview, already in preview state");
      AppMethodBeat.o(94241);
      return;
    }
    this.currentState = 0;
    ac.m("MicroMsg.CameraPreviewContainer", "startPreview process.useCpuCrop():" + this.hbj.auW(), new Object[0]);
    this.haY = paramBoolean;
    if ((!this.haY) && (!com.tencent.mm.media.widget.d.a.avD()))
    {
      this.haY = true;
      ac.i("MicroMsg.CameraPreviewContainer", "force useBackGroundCamera");
    }
    if ((this.haY) && (!com.tencent.mm.media.widget.d.a.avE()))
    {
      this.haY = false;
      ac.i("MicroMsg.CameraPreviewContainer", "force useFrontGroundCamera");
    }
    this.goG.q(this.hbj.getContext(), this.haY);
    if (this.hbj.auW()) {
      this.goG.a(this.hbj.getCameraPreviewView().getFrameDataCallback());
    }
    this.hbj.getCameraPreviewView().c((d.g.a.b)new e(this, paramb));
    AppMethodBeat.o(94241);
  }
  
  public final void atx()
  {
    AppMethodBeat.i(94229);
    if (this.currentState == 0) {
      this.goG.atx();
    }
    AppMethodBeat.o(94229);
  }
  
  public final void auF()
  {
    AppMethodBeat.i(94226);
    try
    {
      ac.i("MicroMsg.CameraPreviewContainer", "cancelRecord");
      com.tencent.mm.media.widget.c.b localb = this.haW;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.haW;
      if (localb != null) {
        localb.clear();
      }
      localb = this.haX;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.haX;
      if (localb != null) {
        localb.clear();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "cancel record error", new Object[0]);
      }
    }
    if (this.goG.atn())
    {
      auI();
      if (this.goG.aty() != null) {
        auJ();
      }
    }
    AppMethodBeat.o(94226);
  }
  
  public final int auH()
  {
    AppMethodBeat.i(94236);
    int i = this.goG.atD();
    AppMethodBeat.o(94236);
    return i;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94228);
    if (this.currentState == 0) {
      this.goG.b(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(94228);
  }
  
  public final boolean en(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(94233);
    if (!com.tencent.mm.media.widget.d.a.auG())
    {
      ac.i("MicroMsg.CameraPreviewContainer", "only one camera,forbid switch");
      if (!com.tencent.mm.media.widget.d.a.avD())
      {
        AppMethodBeat.o(94233);
        return true;
      }
      AppMethodBeat.o(94233);
      return false;
    }
    ac.i("MicroMsg.CameraPreviewContainer", "flipCamera time space:" + bs.aO(this.hbb));
    if ((!paramBoolean) && (bs.aO(this.hbb) < 1000L))
    {
      paramBoolean = this.haY;
      AppMethodBeat.o(94233);
      return paramBoolean;
    }
    this.hbb = bs.Gn();
    if (this.hba)
    {
      localObject = this.haW;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
      localObject = this.haX;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
    }
    this.hbj.getCameraPreviewView().ajB();
    this.haY = this.goG.atm();
    Object localObject = this.goG.aty();
    com.tencent.mm.media.widget.camerarecordview.c.a locala;
    if (!this.hbh)
    {
      locala = this.hbf;
      if ((this.haY) || (!this.hbj.auX())) {
        break label462;
      }
    }
    label462:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.a(paramBoolean, (com.tencent.mm.media.widget.a.b)localObject);
      if (localObject != null)
      {
        this.hbj.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
        localObject = c.hbw;
        localObject = c.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.i.a)localObject).cS(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
        }
        localObject = c.hbw;
        localObject = c.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.i.a)localObject).mE(com.tencent.mm.media.widget.a.b.atq());
        }
        localObject = c.hbw;
        localObject = c.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.i.a)localObject).ee(com.tencent.mm.media.widget.a.b.att());
        }
        localObject = this.haW;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.att());
        }
        localObject = this.haX;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.att());
        }
        localObject = this.haW;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.atr(), com.tencent.mm.media.widget.a.b.ats());
        }
        localObject = this.haX;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.atr(), com.tencent.mm.media.widget.a.b.ats());
        }
        if (this.hba)
        {
          localObject = this.haW;
          if (localObject != null) {
            ((com.tencent.mm.media.widget.c.b)localObject).K(com.tencent.mm.media.widget.a.b.atq(), com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          }
          localObject = this.haX;
          if (localObject != null) {
            ((com.tencent.mm.media.widget.c.b)localObject).K(com.tencent.mm.media.widget.a.b.atq(), com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          }
        }
      }
      paramBoolean = this.haY;
      AppMethodBeat.o(94233);
      return paramBoolean;
    }
  }
  
  public final Point eo(boolean paramBoolean)
  {
    AppMethodBeat.i(94243);
    Point localPoint = this.goG.eg(paramBoolean);
    AppMethodBeat.o(94243);
    return localPoint;
  }
  
  public final void ep(boolean paramBoolean)
  {
    AppMethodBeat.i(94248);
    this.goG.eh(paramBoolean);
    AppMethodBeat.o(94248);
  }
  
  public final void j(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94231);
    if (this.currentState == 0) {
      this.goG.j(paramBoolean, paramInt);
    }
    AppMethodBeat.o(94231);
  }
  
  public final boolean k(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94224);
    ac.m("MicroMsg.CameraPreviewContainer", "startRecord", new Object[0]);
    Object localObject2;
    com.tencent.mm.media.widget.c.b localb;
    if ((this.goG.aty() != null) && (this.haW != null))
    {
      if (!this.hbc)
      {
        ac.i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
        AppMethodBeat.o(94224);
        return false;
      }
      localObject2 = this.haW;
      if (localObject2 != null)
      {
        localObject2 = Integer.valueOf(((com.tencent.mm.media.widget.c.b)localObject2).b(com.tencent.mm.media.widget.a.b.atq(), paramBoolean, paramInt));
        ac.i("MicroMsg.CameraPreviewContainer", "start record ret:".concat(String.valueOf(localObject2)));
        if (!this.hbj.auY()) {
          break label289;
        }
        localb = this.haX;
        if (localb == null) {}
      }
    }
    label150:
    label289:
    for (localObject1 = Integer.valueOf(localb.b(com.tencent.mm.media.widget.a.b.atq(), paramBoolean, paramInt));; localObject1 = Integer.valueOf(-1))
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
          ac.i("MicroMsg.CameraPreviewContainer", "start record base ret:" + localObject2 + " daemon ret:" + localObject1 + " ,use daemon record:" + this.hbj.auY());
          this.haZ = bs.Gn();
          this.hba = true;
          this.hbg = false;
          localObject1 = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.asm();
          AppMethodBeat.o(94224);
          return true;
        } while (((Integer)localObject1).intValue() == 0);
      }
      ac.m("MicroMsg.CameraPreviewContainer", "cameraConfig is null", new Object[0]);
      AppMethodBeat.o(94224);
      return false;
    }
  }
  
  public final void nB(int paramInt)
  {
    AppMethodBeat.i(94230);
    if (this.currentState == 0) {
      this.goG.nx(paramInt);
    }
    AppMethodBeat.o(94230);
  }
  
  public final boolean o(d.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, y> paramb)
  {
    AppMethodBeat.i(94227);
    if (!this.hba)
    {
      AppMethodBeat.o(94227);
      return true;
    }
    this.hba = false;
    if (bs.aO(this.haZ) < this.hbd)
    {
      ac.m("MicroMsg.CameraPreviewContainer", "stopRecord " + bs.aO(this.haZ), new Object[0]);
      paramb = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asn();
      auF();
      AppMethodBeat.o(94227);
      return false;
    }
    ac.m("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
    com.tencent.mm.media.j.a locala = new com.tencent.mm.media.j.a("stopRecord");
    v.d locald = new v.d();
    locald.KUO = 0;
    v.f localf1 = new v.f();
    localf1.KUQ = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, 16383);
    v.f localf2 = new v.f();
    localf2.KUQ = ((Runnable)new a.h(this, localf1, paramb));
    if (this.hbj.auY())
    {
      localObject = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.aso();
    }
    Object localObject = new v.f();
    ((v.f)localObject).KUQ = this.haW;
    com.tencent.mm.media.widget.c.b localb = this.haW;
    if (localb != null) {
      localb.E((Runnable)new a.f(this, (v.f)localObject, locala, localf1, locald, localf2, paramb));
    }
    localObject = this.haX;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.c.b)localObject).E((Runnable)new a.g(this, locala, localf1, locald, localf2, paramb));
    }
    AppMethodBeat.o(94227);
    return true;
  }
  
  public final void p(d.g.a.b<? super byte[], y> paramb)
  {
    AppMethodBeat.i(94239);
    k.h(paramb, "callback");
    this.goG.atp();
    this.goG.a((g)new b(paramb));
    AppMethodBeat.o(94239);
  }
  
  public final void pE(long paramLong)
  {
    AppMethodBeat.i(94232);
    ac.i("MicroMsg.CameraPreviewContainer", "setRecordMiniTime:".concat(String.valueOf(paramLong)));
    this.hbd = paramLong;
    AppMethodBeat.o(94232);
  }
  
  public final void q(final d.g.a.b<? super Bitmap, y> paramb)
  {
    AppMethodBeat.i(94246);
    k.h(paramb, "callback");
    if (!this.goG.atn())
    {
      ac.e("MicroMsg.CameraPreviewContainer", "camera.isCameraPreviewing : false");
      paramb.ay(null);
      AppMethodBeat.o(94246);
      return;
    }
    if ((com.tencent.mm.media.widget.d.a.c(this.hbj)) && (!com.tencent.mm.media.widget.d.a.b(this.hbj)))
    {
      l = bs.Gn();
      this.goG.m((d.g.a.b)new j(this, l, paramb));
      AppMethodBeat.o(94246);
      return;
    }
    final long l = bs.Gn();
    com.tencent.mm.media.i.a locala = this.gTi;
    if (locala != null)
    {
      locala.l((d.g.a.b)new i(this, paramb, l));
      locala.ari();
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
      ac.i("MicroMsg.CameraPreviewContainer", "release");
      this.goG.onDestroy();
      this.goG.release();
      Object localObject = this.hbf;
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).hbU.disable();
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).context = null;
      localObject = c.hbw;
      c.auK();
      this.hbj.getCameraPreviewView().release();
      localObject = this.haW;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.haW;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.haX;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.haX;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.gTi;
      if (localObject != null) {
        com.tencent.mm.media.i.a.a((com.tencent.mm.media.i.a)localObject);
      }
      this.gTi = null;
      AppMethodBeat.o(94237);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "camera release error:" + localException.getMessage(), new Object[0]);
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
    ac.m("MicroMsg.CameraPreviewContainer", "stopPreview", new Object[0]);
    try
    {
      this.goG.release();
      this.goG.b(this.hbj.getCameraPreviewView().getFrameDataCallback());
      this.hbj.getCameraPreviewView().ajA();
      if (!this.hbh) {
        this.hbf.a(false, null);
      }
      AppMethodBeat.o(94245);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "camera relase error:" + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFrameData"})
  static final class b
    implements g
  {
    b(d.g.a.b paramb) {}
    
    public final boolean V(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(94214);
      d.g.a.b localb = this.fPt;
      k.g(paramArrayOfByte, "it");
      localb.ay(paramArrayOfByte);
      AppMethodBeat.o(94214);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$setRender$curRenderer$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class d
    extends com.tencent.mm.media.i.d
  {
    d(int paramInt)
    {
      super();
    }
    
    public final com.tencent.mm.media.i.b.a ajF()
    {
      AppMethodBeat.i(94216);
      if (this.hbl.hbj.auW())
      {
        locala = (com.tencent.mm.media.i.b.a)new f(this.gqZ, this.gra, this.grV, this.grW, this.gVm, this.scaleType);
        AppMethodBeat.o(94216);
        return locala;
      }
      com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new com.tencent.mm.media.i.b.c(this.gqZ, this.gra, this.grV, this.grW, this.gVm, this.scaleType);
      AppMethodBeat.o(94216);
      return locala;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<SurfaceTexture, y>
  {
    e(a parama, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/nio/IntBuffer;", "invoke", "com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$takePicture$2$1"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<IntBuffer, y>
  {
    i(a parama, d.g.a.b paramb, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
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