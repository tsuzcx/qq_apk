package com.tencent.mm.media.widget.camerarecordview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.g.b.y.f;
import d.l;
import d.t;
import d.v;
import d.z;
import java.nio.IntBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "cameraPreviewInfo", "Lkotlin/Triple;", "", "context", "Landroid/content/Context;", "currentState", "customOrientation", "", "daemonRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "frameRenderCallback", "Lkotlin/Function0;", "", "getFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "initRecorderRet", "isRecording", "lastFlipCameraStamp", "", "mIsUseApi2", "mediaRecorder", "needResumeRecorder", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordFinish", "recordMiniTime", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "startRecordTimeStamp", "getStartRecordTimeStamp", "()J", "setStartRecordTimeStamp", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "afterStartPreview", "cancelRecord", "checkFlashStatus", "openFlash", "configVendorTagValue", "tag", "", "createImageReaderCallback", "callback", "", "data", "createRecorder", "enableSwitchCamera", "getCameraOrientaion", "getCameraPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getFlashMode", "getMD5", "getRecordFilePath", "getRecordTime", "getSupportZoomRatios", "", "initRecorder", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "isPreviewing", "isUseBackGroundCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "resetRecord", "setCustomOrientationEnable", "enable", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "flash", "setForceZoomTargetRatio", "ratio", "setMute", "mute", "setRecordMiniTime", "time", "setRender", "startPreview", "displayRatio", "success", "startRecord", "isLandscape", "deviceDegree", "stopPreview", "stopRecord", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "capture", "switchCamera", "ignoreFlipCheck", "switchVendorTag", "isChecked", "takePicture", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a hwg;
  private Context context;
  public int currentState;
  private final aq gKO;
  public final com.tencent.mm.media.widget.a.e gKX;
  com.tencent.mm.media.j.a hnY;
  public d.g.a.b<? super Boolean, z> hsS;
  private com.tencent.mm.media.widget.c.b hvQ;
  private com.tencent.mm.media.widget.c.b hvR;
  public boolean hvS;
  public long hvT;
  private boolean hvU;
  private volatile boolean hvV;
  private volatile t<Integer, Integer, Integer> hvW;
  private long hvX;
  private boolean hvY;
  private long hvZ;
  private boolean hwa;
  public com.tencent.mm.media.widget.camerarecordview.c.a hwb;
  private volatile boolean hwc;
  public boolean hwd;
  d.g.a.a<z> hwe;
  public com.tencent.mm.media.widget.camerarecordview.d.a hwf;
  
  static
  {
    AppMethodBeat.i(94250);
    hwg = new a.a((byte)0);
    AppMethodBeat.o(94250);
  }
  
  public a(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94249);
    this.hwf = parama;
    this.gKO = new aq(Looper.getMainLooper());
    this.hvS = true;
    this.hvW = new t(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
    this.currentState = 1;
    this.hvZ = 2000L;
    ae.m("MicroMsg.CameraPreviewContainer", this.hwf.toString(), new Object[0]);
    parama = this.hwf.getCameraPreviewView();
    Object localObject;
    if (this.hwf.getPreviewRenderer() != null)
    {
      this.hnY = this.hwf.getPreviewRenderer();
      localObject = this.hwf.getPreviewRenderer();
      if (localObject == null) {
        p.gkB();
      }
      parama.a((com.tencent.mm.media.j.a)localObject, this.hwf.axY());
      if (!com.tencent.mm.media.widget.d.a.a(this.hwf)) {
        break label301;
      }
      this.gKX = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.b.e(this.hwf.getContext()));
      if (com.tencent.mm.media.widget.d.a.b(this.hwf)) {
        this.gKX.awq();
      }
      this.hwa = true;
    }
    for (;;)
    {
      this.hvX = bu.HQ();
      this.context = this.hwf.getContext();
      this.hwb = new com.tencent.mm.media.widget.camerarecordview.c.a(this.context, this.hwf);
      AppMethodBeat.o(94249);
      return;
      localObject = new d(this);
      this.hnY = ((com.tencent.mm.media.j.a)localObject);
      parama.a((com.tencent.mm.media.j.a)localObject, this.hwf.axY());
      break;
      label301:
      this.hwa = false;
      this.gKX = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.a.d(this.hwf.getContext()));
    }
  }
  
  public static boolean axI()
  {
    AppMethodBeat.i(94235);
    boolean bool = com.tencent.mm.media.widget.d.a.axI();
    AppMethodBeat.o(94235);
    return bool;
  }
  
  private final boolean axK()
  {
    AppMethodBeat.i(94238);
    Object localObject1 = this.hwf.getRecorder();
    ae.i("MicroMsg.CameraPreviewContainer", "createRecorder: " + this.hvQ + ", useCpuCrop:" + this.hwf.axY() + ", process.getRecorder():" + localObject1 + ", mute:" + this.hwf.Pd());
    Object localObject2 = this.hvQ;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.hvR;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.hwf.getEncodeConfig();
    if (localObject1 != null) {
      this.hvQ = ((com.tencent.mm.media.widget.c.b)localObject1);
    }
    for (;;)
    {
      localObject1 = this.hvQ;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(this.hwf.Pd());
      }
      localObject1 = this.hvR;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(true);
      }
      this.hwf.getCameraPreviewView().setOnDrawListener((d.g.a.b)new c(this));
      ae.i("MicroMsg.CameraPreviewContainer", "create recorder finish");
      AppMethodBeat.o(94238);
      return true;
      if (this.hwf.axY())
      {
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.auB();
        localObject1 = c.hws;
      }
      EGLContext localEGLContext;
      for (localObject1 = c.a(((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).axO(), this.hwf.getVideoTransPara(), this.gKX, this.hwf.getRecordRenderer());; localObject1 = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.e)localObject3, localEGLContext, this.hwf.getCameraPreviewView(), this.hwf.axY(), this.hwf.getRecordRenderer()))
      {
        this.hvQ = ((com.tencent.mm.media.widget.c.b)localObject1);
        if (!this.hwf.aya()) {
          break;
        }
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.auA();
        if (this.hwf.getCameraPreviewView().getEGLContext() != null) {
          break label490;
        }
        ae.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.auC();
        AppMethodBeat.o(94238);
        return false;
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.auA();
        if (this.hwf.getCameraPreviewView().getEGLContext() == null)
        {
          ae.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
          localObject1 = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.auC();
          AppMethodBeat.o(94238);
          return false;
        }
        localObject1 = c.hws;
        i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).axO();
        localObject1 = this.hwf.getVideoTransPara();
        localObject3 = this.gKX;
        localEGLContext = this.hwf.getCameraPreviewView().getEGLContext();
        if (localEGLContext == null) {
          p.gkB();
        }
      }
      label490:
      localObject1 = c.hws;
      int i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).axO();
      localObject1 = this.hwf.getDaemonVideoTransPara();
      localObject2 = this.gKX;
      Object localObject3 = this.hwf.getCameraPreviewView().getEGLContext();
      if (localObject3 == null) {
        p.gkB();
      }
      this.hvR = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.e)localObject2, (EGLContext)localObject3, this.hwf.getCameraPreviewView(), this.hwf.axY(), this.hwf.getRecordRenderer());
    }
  }
  
  private final void axL()
  {
    com.tencent.mm.media.widget.c.b localb1 = null;
    AppMethodBeat.i(94240);
    com.tencent.mm.media.widget.c.b localb2 = this.hvQ;
    if (localb2 != null) {
      localb2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.awt(), com.tencent.mm.media.widget.a.b.awu());
    }
    if (localb2 != null) {
      localb2.setFilePath(this.hwf.getEncodeConfig().getFilePath());
    }
    if (localb2 != null) {
      localb2.yY(this.hwf.getEncodeConfig().axP());
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
      localObject = localb2.axP();
      ae.m("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localb2 = this.hvR;
      if (localb2 != null) {
        localb2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.awt(), com.tencent.mm.media.widget.a.b.awu());
      }
      if (localb2 != null) {
        localb2.setFilePath(this.hwf.getEncodeConfig().getFilePath() + "_daemon");
      }
      if (localb2 != null) {
        localb2.yY(this.hwf.getEncodeConfig().axP() + "_daemon");
      }
      localStringBuilder = new StringBuilder("filePath : ");
      if (localb2 == null) {
        break label452;
      }
      localObject = localb2.getFilePath();
      localStringBuilder = localStringBuilder.append((String)localObject).append("   thumbPath : ");
      localObject = localb1;
      if (localb2 != null) {
        localObject = localb2.axP();
      }
      ae.m("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localObject = this.hvQ;
      if (localObject == null) {
        break label457;
      }
      bool1 = ((com.tencent.mm.media.widget.c.b)localObject).og(com.tencent.mm.media.widget.a.b.aws());
      localObject = this.hvR;
      if (localObject == null) {
        break label462;
      }
      bool2 = ((com.tencent.mm.media.widget.c.b)localObject).og(com.tencent.mm.media.widget.a.b.aws());
    }
    for (;;)
    {
      if (((this.hvR instanceof com.tencent.mm.media.widget.c.c)) && ((this.hvQ instanceof com.tencent.mm.media.widget.c.c)))
      {
        localObject = this.hvR;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
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
        localb1 = this.hvQ;
        if (localb1 == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
          AppMethodBeat.o(94240);
          throw ((Throwable)localObject);
        }
        ((com.tencent.mm.media.widget.c.c)localObject).a(((com.tencent.mm.media.widget.c.c)localb1).ayr());
      }
    }
    if (((this.hvR instanceof com.tencent.mm.media.widget.c.e)) && ((this.hvQ instanceof com.tencent.mm.media.widget.c.e)))
    {
      localObject = this.hvR;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.media.widget.c.e)localObject;
      localb1 = this.hvQ;
      if (localb1 == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.media.widget.c.e)localObject).a(((com.tencent.mm.media.widget.c.e)localb1).ayr());
    }
    ae.m("MicroMsg.CameraPreviewContainer", "init recorder ret:" + bool1 + "  daemonRet:" + bool2, new Object[0]);
    this.hvY = bool1;
    AppMethodBeat.o(94240);
  }
  
  public final void A(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94247);
    p.h(paramString, "tag");
    this.gKX.A(paramString, paramBoolean);
    AppMethodBeat.o(94247);
  }
  
  public final void a(boolean paramBoolean, final d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(94241);
    if (this.currentState == 0)
    {
      ae.e("MicroMsg.CameraPreviewContainer", "startPreview, already in preview state");
      AppMethodBeat.o(94241);
      return;
    }
    this.currentState = 0;
    ae.m("MicroMsg.CameraPreviewContainer", "startPreview process.useCpuCrop():" + this.hwf.axY(), new Object[0]);
    this.hvS = paramBoolean;
    if ((!this.hvS) && (!com.tencent.mm.media.widget.d.a.ayF()))
    {
      this.hvS = true;
      ae.i("MicroMsg.CameraPreviewContainer", "force useBackGroundCamera");
    }
    if ((this.hvS) && (!com.tencent.mm.media.widget.d.a.ayG()))
    {
      this.hvS = false;
      ae.i("MicroMsg.CameraPreviewContainer", "force useFrontGroundCamera");
    }
    this.gKX.s(this.hwf.getContext(), this.hvS);
    if (this.hwf.axY()) {
      this.gKX.a(this.hwf.getCameraPreviewView().getFrameDataCallback());
    }
    this.hwf.getCameraPreviewView().d((d.g.a.b)new e(this, paramb));
    AppMethodBeat.o(94241);
  }
  
  public final void awz()
  {
    AppMethodBeat.i(94229);
    if (this.currentState == 0) {
      this.gKX.awz();
    }
    AppMethodBeat.o(94229);
  }
  
  public final void axH()
  {
    AppMethodBeat.i(94226);
    try
    {
      ae.i("MicroMsg.CameraPreviewContainer", "cancelRecord");
      com.tencent.mm.media.widget.c.b localb = this.hvQ;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.hvQ;
      if (localb != null) {
        localb.clear();
      }
      localb = this.hvR;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.hvR;
      if (localb != null) {
        localb.clear();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "cancel record error", new Object[0]);
      }
    }
    if (this.gKX.awp())
    {
      axK();
      if (this.gKX.awA() != null) {
        axL();
      }
    }
    AppMethodBeat.o(94226);
  }
  
  public final int axJ()
  {
    AppMethodBeat.i(94236);
    int i = this.gKX.awF();
    AppMethodBeat.o(94236);
    return i;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94228);
    if (this.currentState == 0) {
      this.gKX.b(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(94228);
  }
  
  public final boolean er(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(94233);
    if (!com.tencent.mm.media.widget.d.a.axI())
    {
      ae.i("MicroMsg.CameraPreviewContainer", "only one camera,forbid switch");
      if (!com.tencent.mm.media.widget.d.a.ayF())
      {
        AppMethodBeat.o(94233);
        return true;
      }
      AppMethodBeat.o(94233);
      return false;
    }
    ae.i("MicroMsg.CameraPreviewContainer", "flipCamera time space:" + bu.aO(this.hvX));
    if ((!paramBoolean) && (bu.aO(this.hvX) < 1000L))
    {
      paramBoolean = this.hvS;
      AppMethodBeat.o(94233);
      return paramBoolean;
    }
    this.hvX = bu.HQ();
    if (this.hvU)
    {
      localObject = this.hvQ;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
      localObject = this.hvR;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
    }
    this.hwf.getCameraPreviewView().amC();
    this.hvS = this.gKX.awo();
    Object localObject = this.gKX.awA();
    if (!this.hwd)
    {
      com.tencent.mm.media.widget.camerarecordview.c.a locala = this.hwb;
      paramBoolean = bool;
      if (!this.hvS)
      {
        paramBoolean = bool;
        if (this.hwf.axZ()) {
          paramBoolean = true;
        }
      }
      locala.a(paramBoolean, (com.tencent.mm.media.widget.a.b)localObject);
    }
    if (localObject != null)
    {
      this.hwf.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
      localObject = c.hws;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).cU(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
      }
      localObject = c.hws;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).ng(com.tencent.mm.media.widget.a.b.aws());
      }
      localObject = c.hws;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).ei(com.tencent.mm.media.widget.a.b.awv());
      }
      localObject = this.hvQ;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.awv());
      }
      localObject = this.hvR;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.awv());
      }
      localObject = this.hvQ;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.awt(), com.tencent.mm.media.widget.a.b.awu());
      }
      localObject = this.hvR;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.awt(), com.tencent.mm.media.widget.a.b.awu());
      }
      if (this.hvU)
      {
        this.hvW = new t(Integer.valueOf(com.tencent.mm.media.widget.a.b.aws()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewWidth()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewHeight()));
        this.hvV = true;
      }
    }
    paramBoolean = this.hvS;
    AppMethodBeat.o(94233);
    return paramBoolean;
  }
  
  public final Point es(boolean paramBoolean)
  {
    AppMethodBeat.i(94243);
    Point localPoint = this.gKX.ek(paramBoolean);
    AppMethodBeat.o(94243);
    return localPoint;
  }
  
  public final void et(boolean paramBoolean)
  {
    AppMethodBeat.i(94248);
    this.gKX.el(paramBoolean);
    AppMethodBeat.o(94248);
  }
  
  public final void j(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94231);
    if (this.currentState == 0) {
      this.gKX.j(paramBoolean, paramInt);
    }
    AppMethodBeat.o(94231);
  }
  
  public final boolean k(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94224);
    ae.m("MicroMsg.CameraPreviewContainer", "startRecord", new Object[0]);
    Object localObject2;
    com.tencent.mm.media.widget.c.b localb;
    if ((this.gKX.awA() != null) && (this.hvQ != null))
    {
      if (!this.hvY)
      {
        ae.i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
        AppMethodBeat.o(94224);
        return false;
      }
      localObject2 = this.hvQ;
      if (localObject2 != null)
      {
        localObject2 = Integer.valueOf(((com.tencent.mm.media.widget.c.b)localObject2).b(com.tencent.mm.media.widget.a.b.aws(), paramBoolean, paramInt));
        ae.i("MicroMsg.CameraPreviewContainer", "start record ret:".concat(String.valueOf(localObject2)));
        if (!this.hwf.aya()) {
          break label294;
        }
        localb = this.hvR;
        if (localb == null) {}
      }
    }
    label153:
    label294:
    for (localObject1 = Integer.valueOf(localb.b(com.tencent.mm.media.widget.a.b.aws(), paramBoolean, paramInt));; localObject1 = Integer.valueOf(-1))
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
          ae.i("MicroMsg.CameraPreviewContainer", "start record base ret:" + localObject2 + " daemon ret:" + localObject1 + " ,use daemon record:" + this.hwf.aya());
          this.hvT = bu.HQ();
          this.hvU = true;
          this.hwc = false;
          localObject1 = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.avo();
          AppMethodBeat.o(94224);
          return true;
        } while (((Integer)localObject1).intValue() == 0);
      }
      ae.m("MicroMsg.CameraPreviewContainer", "cameraConfig is null", new Object[0]);
      AppMethodBeat.o(94224);
      return false;
    }
  }
  
  public final void od(int paramInt)
  {
    AppMethodBeat.i(94230);
    if (this.currentState == 0) {
      this.gKX.nZ(paramInt);
    }
    AppMethodBeat.o(94230);
  }
  
  public final boolean p(final d.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, z> paramb)
  {
    AppMethodBeat.i(94227);
    if (!this.hvU)
    {
      AppMethodBeat.o(94227);
      return true;
    }
    this.hvU = false;
    if (bu.aO(this.hvT) < this.hvZ)
    {
      ae.m("MicroMsg.CameraPreviewContainer", "stopRecord " + bu.aO(this.hvT), new Object[0]);
      paramb = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avp();
      axH();
      AppMethodBeat.o(94227);
      return false;
    }
    ae.m("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
    final com.tencent.mm.media.k.a locala = new com.tencent.mm.media.k.a("stopRecord");
    final y.d locald = new y.d();
    locald.NiW = 0;
    final y.f localf1 = new y.f();
    localf1.NiY = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, 16383);
    final y.f localf2 = new y.f();
    localf2.NiY = ((Runnable)new h(this, localf1, paramb));
    if (this.hwf.aya())
    {
      localObject = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avq();
    }
    Object localObject = new y.f();
    ((y.f)localObject).NiY = this.hvQ;
    com.tencent.mm.media.widget.c.b localb = this.hvQ;
    if (localb != null) {
      localb.B((Runnable)new f(this, (y.f)localObject, locala, localf1, locald, localf2, paramb));
    }
    localObject = this.hvR;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.c.b)localObject).B((Runnable)new g(this, locala, localf1, locald, localf2, paramb));
    }
    AppMethodBeat.o(94227);
    return true;
  }
  
  public final void q(d.g.a.b<? super byte[], z> paramb)
  {
    AppMethodBeat.i(94239);
    p.h(paramb, "callback");
    this.gKX.awr();
    this.gKX.a((g)new b(paramb));
    AppMethodBeat.o(94239);
  }
  
  public final void r(final d.g.a.b<? super Bitmap, z> paramb)
  {
    AppMethodBeat.i(94246);
    p.h(paramb, "callback");
    if (!this.gKX.awp())
    {
      ae.e("MicroMsg.CameraPreviewContainer", "camera.isCameraPreviewing : false");
      paramb.invoke(null);
      AppMethodBeat.o(94246);
      return;
    }
    if ((com.tencent.mm.media.widget.d.a.c(this.hwf)) && (!com.tencent.mm.media.widget.d.a.b(this.hwf)))
    {
      l = bu.HQ();
      this.gKX.n((d.g.a.b)new j(this, l, paramb));
      AppMethodBeat.o(94246);
      return;
    }
    final long l = bu.HQ();
    com.tencent.mm.media.j.a locala = this.hnY;
    if (locala != null)
    {
      locala.m((d.g.a.b)new i(this, paramb, l));
      locala.auk();
      AppMethodBeat.o(94246);
      return;
    }
    AppMethodBeat.o(94246);
  }
  
  public final void rQ(long paramLong)
  {
    AppMethodBeat.i(94232);
    ae.i("MicroMsg.CameraPreviewContainer", "setRecordMiniTime:".concat(String.valueOf(paramLong)));
    this.hvZ = paramLong;
    AppMethodBeat.o(94232);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94237);
    try
    {
      ae.i("MicroMsg.CameraPreviewContainer", "release");
      this.gKX.onDestroy();
      this.gKX.release();
      Object localObject = this.hwb;
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).hwQ.disable();
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).context = null;
      localObject = c.hws;
      c.axM();
      this.hwf.getCameraPreviewView().release();
      localObject = this.hvQ;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.hvQ;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.hvR;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.hvR;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.hnY;
      if (localObject != null) {
        com.tencent.mm.media.j.a.a((com.tencent.mm.media.j.a)localObject);
      }
      this.hnY = null;
      AppMethodBeat.o(94237);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "camera release error:" + localException.getMessage(), new Object[0]);
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
    ae.m("MicroMsg.CameraPreviewContainer", "stopPreview", new Object[0]);
    try
    {
      this.gKX.release();
      this.gKX.b(this.hwf.getCameraPreviewView().getFrameDataCallback());
      this.hwf.getCameraPreviewView().amB();
      if (!this.hwd) {
        this.hwb.a(false, null);
      }
      AppMethodBeat.o(94245);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "camera relase error:" + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFrameData"})
  static final class b
    implements g
  {
    b(d.g.a.b paramb) {}
    
    public final boolean U(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(94214);
      d.g.a.b localb = this.gll;
      p.g(paramArrayOfByte, "it");
      localb.invoke(paramArrayOfByte);
      AppMethodBeat.o(94214);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<com.tencent.mm.media.g.d, z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$setRender$curRenderer$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class d
    extends com.tencent.mm.media.j.d
  {
    d(int paramInt)
    {
      super();
    }
    
    public final com.tencent.mm.media.j.b.a amG()
    {
      AppMethodBeat.i(94216);
      if (this.hwh.hwf.axY())
      {
        locala = (com.tencent.mm.media.j.b.a)new f(this.gNs, this.gNt, this.gOm, this.gOn, this.hqd, this.scaleType);
        AppMethodBeat.o(94216);
        return locala;
      }
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.gNs, this.gNt, this.gOm, this.gOn, this.hqd, this.scaleType);
      AppMethodBeat.o(94216);
      return locala;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<SurfaceTexture, z>
  {
    e(a parama, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, y.f paramf1, com.tencent.mm.media.k.a parama1, y.f paramf2, y.d paramd, y.f paramf3, d.g.a.b paramb) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(94219);
      if (a.f(this.hwh))
      {
        AppMethodBeat.o(94219);
        return;
      }
      Object localObject2 = new StringBuilder("stopRecord ");
      Object localObject1 = (com.tencent.mm.media.widget.c.b)this.hwj.NiY;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
        localObject1 = (com.tencent.mm.media.widget.c.b)this.hwj.NiY;
        if (localObject1 == null) {
          break label437;
        }
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).axP();
        label88:
        ae.m("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
        locala.ald();
        localObject1 = (com.tencent.mm.media.widget.c.b)this.hwj.NiY;
        if (localObject1 == null) {
          break label442;
        }
      }
      label437:
      label442:
      for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
      {
        localObject2 = (com.tencent.mm.media.widget.c.b)this.hwj.NiY;
        if (localObject2 != null) {
          str = ((com.tencent.mm.media.widget.c.b)localObject2).axP();
        }
        if ((localObject1 == null) || (str == null)) {
          break label475;
        }
        localObject2 = com.tencent.mm.plugin.sight.base.e.ayN((String)localObject1);
        if (localObject2 == null) {
          break label475;
        }
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY).hwD = true;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY).yU((String)localObject1);
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY).yV(str);
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY).dez = 0;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY).hwE = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
        localObject1 = locald;
        ((y.d)localObject1).NiW += 1;
        ae.i("MicroMsg.CameraPreviewContainer", "record video info main: ".concat(String.valueOf(localObject2)));
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avD();
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.rH(((com.tencent.mm.plugin.sight.base.a)localObject2).videoBitrate);
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.rI(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate);
        if (((!this.hwh.hwf.aya()) || (locald.NiW != 2)) && (this.hwh.hwf.aya())) {
          break label453;
        }
        if ((this.hwh.hwf.aya()) && (locald.NiW == 2))
        {
          localObject1 = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.avr();
        }
        ar.ay((Runnable)localf2.NiY);
        a.g(this.hwh);
        localObject1 = paramb;
        if (localObject1 == null) {
          break label447;
        }
        ((d.g.a.b)localObject1).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY);
        AppMethodBeat.o(94219);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label88;
      }
      label447:
      AppMethodBeat.o(94219);
      return;
      label453:
      ar.o((Runnable)localf2.NiY, 3000L);
      AppMethodBeat.o(94219);
      return;
      label475:
      AppMethodBeat.o(94219);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama, com.tencent.mm.media.k.a parama1, y.f paramf1, y.d paramd, y.f paramf2, d.g.a.b paramb) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(94220);
      if (a.f(this.hwh))
      {
        AppMethodBeat.o(94220);
        return;
      }
      Object localObject2 = new StringBuilder("stop daemonRecorder ");
      Object localObject1 = a.e(this.hwh);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
        localObject1 = a.e(this.hwh);
        if (localObject1 == null) {
          break label387;
        }
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).axP();
        label82:
        ae.m("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
        locala.ald();
        localObject1 = a.e(this.hwh);
        if (localObject1 == null) {
          break label392;
        }
      }
      label387:
      label392:
      for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
      {
        localObject2 = a.e(this.hwh);
        if (localObject2 != null) {
          str = ((com.tencent.mm.media.widget.c.b)localObject2).axP();
        }
        if ((localObject1 == null) || (str == null)) {
          break label425;
        }
        localObject2 = com.tencent.mm.plugin.sight.base.e.ayN((String)localObject1);
        if (localObject2 == null) {
          break label425;
        }
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY).hwD = true;
        com.tencent.mm.media.widget.camerarecordview.b.b localb = (com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY;
        p.h(localObject1, "<set-?>");
        localb.hwF = ((String)localObject1);
        localObject1 = (com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY;
        p.h(str, "<set-?>");
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwG = str;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY).hwH = 0;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY).hwI = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
        localObject1 = locald;
        ((y.d)localObject1).NiW += 1;
        ae.i("MicroMsg.CameraPreviewContainer", "record video info daemon: ".concat(String.valueOf(localObject2)));
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avE();
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.rJ(((com.tencent.mm.plugin.sight.base.a)localObject2).videoBitrate);
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.rK(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate);
        if (locald.NiW != 2) {
          break label403;
        }
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avr();
        ar.ay((Runnable)localf2.NiY);
        a.g(this.hwh);
        localObject1 = paramb;
        if (localObject1 == null) {
          break label397;
        }
        ((d.g.a.b)localObject1).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY);
        AppMethodBeat.o(94220);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label82;
      }
      label397:
      AppMethodBeat.o(94220);
      return;
      label403:
      ar.o((Runnable)localf2.NiY, 3000L);
      AppMethodBeat.o(94220);
      return;
      label425:
      AppMethodBeat.o(94220);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(a parama, y.f paramf, d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(94221);
      if (!((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY).axR())
      {
        localObject = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avs();
        localObject = a.d(this.hwh);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).cancel();
        }
      }
      if (!((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY).axQ())
      {
        localObject = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avt();
        localObject = a.e(this.hwh);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).cancel();
        }
      }
      a.g(this.hwh);
      Object localObject = paramb;
      if (localObject != null)
      {
        ((d.g.a.b)localObject).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.NiY);
        AppMethodBeat.o(94221);
        return;
      }
      AppMethodBeat.o(94221);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/nio/IntBuffer;", "invoke", "com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$takePicture$2$1"})
  static final class i
    extends q
    implements d.g.a.b<IntBuffer, z>
  {
    i(a parama, d.g.a.b paramb, long paramLong)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<Bitmap, z>
  {
    j(a parama, long paramLong, d.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a
 * JD-Core Version:    0.7.0.1
 */