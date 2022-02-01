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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.g.b.y.f;
import d.l;
import d.t;
import d.v;
import d.z;
import java.nio.IntBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "cameraPreviewInfo", "Lkotlin/Triple;", "", "context", "Landroid/content/Context;", "currentState", "customOrientation", "", "daemonRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "frameRenderCallback", "Lkotlin/Function0;", "", "getFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "initRecorderRet", "isRecording", "lastFlipCameraStamp", "", "mIsUseApi2", "mediaRecorder", "needResumeRecorder", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordFinish", "recordMiniTime", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "startRecordTimeStamp", "getStartRecordTimeStamp", "()J", "setStartRecordTimeStamp", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "afterStartPreview", "cancelRecord", "checkFlashStatus", "openFlash", "configVendorTagValue", "tag", "", "createImageReaderCallback", "callback", "", "data", "createRecorder", "enableSwitchCamera", "getCameraOrientaion", "getCameraPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getFlashMode", "getMD5", "getRecordFilePath", "getRecordTime", "getSupportZoomRatios", "", "initRecorder", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "isPreviewing", "isUseBackGroundCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "resetRecord", "setCustomOrientationEnable", "enable", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "flash", "setForceZoomTargetRatio", "ratio", "setMute", "mute", "setRecordMiniTime", "time", "setRender", "startPreview", "displayRatio", "success", "startRecord", "isLandscape", "deviceDegree", "stopPreview", "stopRecord", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "capture", "switchCamera", "ignoreFlipCheck", "switchVendorTag", "isChecked", "takePicture", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a hts;
  private Context context;
  public int currentState;
  private final ap gIf;
  public final com.tencent.mm.media.widget.a.e gIo;
  com.tencent.mm.media.j.a hlj;
  public d.g.a.b<? super Boolean, z> hqe;
  private com.tencent.mm.media.widget.c.b htc;
  private com.tencent.mm.media.widget.c.b htd;
  public boolean hte;
  public long htf;
  private boolean htg;
  private volatile boolean hth;
  private volatile t<Integer, Integer, Integer> hti;
  private long htj;
  private boolean htk;
  private long htl;
  private boolean htm;
  public com.tencent.mm.media.widget.camerarecordview.c.a htn;
  private volatile boolean hto;
  public boolean htp;
  d.g.a.a<z> htq;
  public com.tencent.mm.media.widget.camerarecordview.d.a htr;
  
  static
  {
    AppMethodBeat.i(94250);
    hts = new a.a((byte)0);
    AppMethodBeat.o(94250);
  }
  
  public a(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94249);
    this.htr = parama;
    this.gIf = new ap(Looper.getMainLooper());
    this.hte = true;
    this.hti = new t(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
    this.currentState = 1;
    this.htl = 2000L;
    ad.m("MicroMsg.CameraPreviewContainer", this.htr.toString(), new Object[0]);
    parama = this.htr.getCameraPreviewView();
    Object localObject;
    if (this.htr.getPreviewRenderer() != null)
    {
      this.hlj = this.htr.getPreviewRenderer();
      localObject = this.htr.getPreviewRenderer();
      if (localObject == null) {
        p.gfZ();
      }
      parama.a((com.tencent.mm.media.j.a)localObject, this.htr.axJ());
      if (!com.tencent.mm.media.widget.d.a.a(this.htr)) {
        break label301;
      }
      this.gIo = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.b.e(this.htr.getContext()));
      if (com.tencent.mm.media.widget.d.a.b(this.htr)) {
        this.gIo.awb();
      }
      this.htm = true;
    }
    for (;;)
    {
      this.htj = bt.HI();
      this.context = this.htr.getContext();
      this.htn = new com.tencent.mm.media.widget.camerarecordview.c.a(this.context, this.htr);
      AppMethodBeat.o(94249);
      return;
      localObject = new d(this);
      this.hlj = ((com.tencent.mm.media.j.a)localObject);
      parama.a((com.tencent.mm.media.j.a)localObject, this.htr.axJ());
      break;
      label301:
      this.htm = false;
      this.gIo = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.a.d(this.htr.getContext()));
    }
  }
  
  public static boolean axt()
  {
    AppMethodBeat.i(94235);
    boolean bool = com.tencent.mm.media.widget.d.a.axt();
    AppMethodBeat.o(94235);
    return bool;
  }
  
  private final boolean axv()
  {
    AppMethodBeat.i(94238);
    Object localObject1 = this.htr.getRecorder();
    ad.i("MicroMsg.CameraPreviewContainer", "createRecorder: " + this.htc + ", useCpuCrop:" + this.htr.axJ() + ", process.getRecorder():" + localObject1 + ", mute:" + this.htr.Pf());
    Object localObject2 = this.htc;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.htd;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.htr.getEncodeConfig();
    if (localObject1 != null) {
      this.htc = ((com.tencent.mm.media.widget.c.b)localObject1);
    }
    for (;;)
    {
      localObject1 = this.htc;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(this.htr.Pf());
      }
      localObject1 = this.htd;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(true);
      }
      this.htr.getCameraPreviewView().setOnDrawListener((d.g.a.b)new c(this));
      ad.i("MicroMsg.CameraPreviewContainer", "create recorder finish");
      AppMethodBeat.o(94238);
      return true;
      if (this.htr.axJ())
      {
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.aum();
        localObject1 = c.htE;
      }
      EGLContext localEGLContext;
      for (localObject1 = c.a(((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).axz(), this.htr.getVideoTransPara(), this.gIo, this.htr.getRecordRenderer());; localObject1 = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.e)localObject3, localEGLContext, this.htr.getCameraPreviewView(), this.htr.axJ(), this.htr.getRecordRenderer()))
      {
        this.htc = ((com.tencent.mm.media.widget.c.b)localObject1);
        if (!this.htr.axL()) {
          break;
        }
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.aul();
        if (this.htr.getCameraPreviewView().getEGLContext() != null) {
          break label490;
        }
        ad.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.aun();
        AppMethodBeat.o(94238);
        return false;
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.aul();
        if (this.htr.getCameraPreviewView().getEGLContext() == null)
        {
          ad.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
          localObject1 = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.aun();
          AppMethodBeat.o(94238);
          return false;
        }
        localObject1 = c.htE;
        i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).axz();
        localObject1 = this.htr.getVideoTransPara();
        localObject3 = this.gIo;
        localEGLContext = this.htr.getCameraPreviewView().getEGLContext();
        if (localEGLContext == null) {
          p.gfZ();
        }
      }
      label490:
      localObject1 = c.htE;
      int i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).axz();
      localObject1 = this.htr.getDaemonVideoTransPara();
      localObject2 = this.gIo;
      Object localObject3 = this.htr.getCameraPreviewView().getEGLContext();
      if (localObject3 == null) {
        p.gfZ();
      }
      this.htd = c.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.e)localObject2, (EGLContext)localObject3, this.htr.getCameraPreviewView(), this.htr.axJ(), this.htr.getRecordRenderer());
    }
  }
  
  private final void axw()
  {
    com.tencent.mm.media.widget.c.b localb1 = null;
    AppMethodBeat.i(94240);
    com.tencent.mm.media.widget.c.b localb2 = this.htc;
    if (localb2 != null) {
      localb2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.awe(), com.tencent.mm.media.widget.a.b.awf());
    }
    if (localb2 != null) {
      localb2.setFilePath(this.htr.getEncodeConfig().getFilePath());
    }
    if (localb2 != null) {
      localb2.yo(this.htr.getEncodeConfig().axA());
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
      localObject = localb2.axA();
      ad.m("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localb2 = this.htd;
      if (localb2 != null) {
        localb2.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.awe(), com.tencent.mm.media.widget.a.b.awf());
      }
      if (localb2 != null) {
        localb2.setFilePath(this.htr.getEncodeConfig().getFilePath() + "_daemon");
      }
      if (localb2 != null) {
        localb2.yo(this.htr.getEncodeConfig().axA() + "_daemon");
      }
      localStringBuilder = new StringBuilder("filePath : ");
      if (localb2 == null) {
        break label452;
      }
      localObject = localb2.getFilePath();
      localStringBuilder = localStringBuilder.append((String)localObject).append("   thumbPath : ");
      localObject = localb1;
      if (localb2 != null) {
        localObject = localb2.axA();
      }
      ad.m("MicroMsg.CameraPreviewContainer", (String)localObject, new Object[0]);
      localObject = this.htc;
      if (localObject == null) {
        break label457;
      }
      bool1 = ((com.tencent.mm.media.widget.c.b)localObject).od(com.tencent.mm.media.widget.a.b.awd());
      localObject = this.htd;
      if (localObject == null) {
        break label462;
      }
      bool2 = ((com.tencent.mm.media.widget.c.b)localObject).od(com.tencent.mm.media.widget.a.b.awd());
    }
    for (;;)
    {
      if (((this.htd instanceof com.tencent.mm.media.widget.c.c)) && ((this.htc instanceof com.tencent.mm.media.widget.c.c)))
      {
        localObject = this.htd;
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
        localb1 = this.htc;
        if (localb1 == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
          AppMethodBeat.o(94240);
          throw ((Throwable)localObject);
        }
        ((com.tencent.mm.media.widget.c.c)localObject).a(((com.tencent.mm.media.widget.c.c)localb1).ayc());
      }
    }
    if (((this.htd instanceof com.tencent.mm.media.widget.c.e)) && ((this.htc instanceof com.tencent.mm.media.widget.c.e)))
    {
      localObject = this.htd;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.media.widget.c.e)localObject;
      localb1 = this.htc;
      if (localb1 == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.media.widget.c.e)localObject).a(((com.tencent.mm.media.widget.c.e)localb1).ayc());
    }
    ad.m("MicroMsg.CameraPreviewContainer", "init recorder ret:" + bool1 + "  daemonRet:" + bool2, new Object[0]);
    this.htk = bool1;
    AppMethodBeat.o(94240);
  }
  
  public final void A(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94247);
    p.h(paramString, "tag");
    this.gIo.A(paramString, paramBoolean);
    AppMethodBeat.o(94247);
  }
  
  public final void a(boolean paramBoolean, final d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(94241);
    if (this.currentState == 0)
    {
      ad.e("MicroMsg.CameraPreviewContainer", "startPreview, already in preview state");
      AppMethodBeat.o(94241);
      return;
    }
    this.currentState = 0;
    ad.m("MicroMsg.CameraPreviewContainer", "startPreview process.useCpuCrop():" + this.htr.axJ(), new Object[0]);
    this.hte = paramBoolean;
    if ((!this.hte) && (!com.tencent.mm.media.widget.d.a.ayq()))
    {
      this.hte = true;
      ad.i("MicroMsg.CameraPreviewContainer", "force useBackGroundCamera");
    }
    if ((this.hte) && (!com.tencent.mm.media.widget.d.a.ayr()))
    {
      this.hte = false;
      ad.i("MicroMsg.CameraPreviewContainer", "force useFrontGroundCamera");
    }
    this.gIo.s(this.htr.getContext(), this.hte);
    if (this.htr.axJ()) {
      this.gIo.a(this.htr.getCameraPreviewView().getFrameDataCallback());
    }
    this.htr.getCameraPreviewView().d((d.g.a.b)new e(this, paramb));
    AppMethodBeat.o(94241);
  }
  
  public final void awk()
  {
    AppMethodBeat.i(94229);
    if (this.currentState == 0) {
      this.gIo.awk();
    }
    AppMethodBeat.o(94229);
  }
  
  public final void axs()
  {
    AppMethodBeat.i(94226);
    try
    {
      ad.i("MicroMsg.CameraPreviewContainer", "cancelRecord");
      com.tencent.mm.media.widget.c.b localb = this.htc;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.htc;
      if (localb != null) {
        localb.clear();
      }
      localb = this.htd;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.htd;
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
    if (this.gIo.awa())
    {
      axv();
      if (this.gIo.awl() != null) {
        axw();
      }
    }
    AppMethodBeat.o(94226);
  }
  
  public final int axu()
  {
    AppMethodBeat.i(94236);
    int i = this.gIo.awq();
    AppMethodBeat.o(94236);
    return i;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94228);
    if (this.currentState == 0) {
      this.gIo.b(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(94228);
  }
  
  public final boolean ep(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(94233);
    if (!com.tencent.mm.media.widget.d.a.axt())
    {
      ad.i("MicroMsg.CameraPreviewContainer", "only one camera,forbid switch");
      if (!com.tencent.mm.media.widget.d.a.ayq())
      {
        AppMethodBeat.o(94233);
        return true;
      }
      AppMethodBeat.o(94233);
      return false;
    }
    ad.i("MicroMsg.CameraPreviewContainer", "flipCamera time space:" + bt.aO(this.htj));
    if ((!paramBoolean) && (bt.aO(this.htj) < 1000L))
    {
      paramBoolean = this.hte;
      AppMethodBeat.o(94233);
      return paramBoolean;
    }
    this.htj = bt.HI();
    if (this.htg)
    {
      localObject = this.htc;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
      localObject = this.htd;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
    }
    this.htr.getCameraPreviewView().amn();
    this.hte = this.gIo.avZ();
    Object localObject = this.gIo.awl();
    if (!this.htp)
    {
      com.tencent.mm.media.widget.camerarecordview.c.a locala = this.htn;
      paramBoolean = bool;
      if (!this.hte)
      {
        paramBoolean = bool;
        if (this.htr.axK()) {
          paramBoolean = true;
        }
      }
      locala.a(paramBoolean, (com.tencent.mm.media.widget.a.b)localObject);
    }
    if (localObject != null)
    {
      this.htr.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
      localObject = c.htE;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).cU(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
      }
      localObject = c.htE;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).nd(com.tencent.mm.media.widget.a.b.awd());
      }
      localObject = c.htE;
      localObject = c.getRenderer();
      if (localObject != null) {
        ((com.tencent.mm.media.j.a)localObject).eg(com.tencent.mm.media.widget.a.b.awg());
      }
      localObject = this.htc;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.awg());
      }
      localObject = this.htd;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.awg());
      }
      localObject = this.htc;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.awe(), com.tencent.mm.media.widget.a.b.awf());
      }
      localObject = this.htd;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.awe(), com.tencent.mm.media.widget.a.b.awf());
      }
      if (this.htg)
      {
        this.hti = new t(Integer.valueOf(com.tencent.mm.media.widget.a.b.awd()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewWidth()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewHeight()));
        this.hth = true;
      }
    }
    paramBoolean = this.hte;
    AppMethodBeat.o(94233);
    return paramBoolean;
  }
  
  public final Point eq(boolean paramBoolean)
  {
    AppMethodBeat.i(94243);
    Point localPoint = this.gIo.ei(paramBoolean);
    AppMethodBeat.o(94243);
    return localPoint;
  }
  
  public final void er(boolean paramBoolean)
  {
    AppMethodBeat.i(94248);
    this.gIo.ej(paramBoolean);
    AppMethodBeat.o(94248);
  }
  
  public final void j(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94231);
    if (this.currentState == 0) {
      this.gIo.j(paramBoolean, paramInt);
    }
    AppMethodBeat.o(94231);
  }
  
  public final boolean k(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94224);
    ad.m("MicroMsg.CameraPreviewContainer", "startRecord", new Object[0]);
    Object localObject2;
    com.tencent.mm.media.widget.c.b localb;
    if ((this.gIo.awl() != null) && (this.htc != null))
    {
      if (!this.htk)
      {
        ad.i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
        AppMethodBeat.o(94224);
        return false;
      }
      localObject2 = this.htc;
      if (localObject2 != null)
      {
        localObject2 = Integer.valueOf(((com.tencent.mm.media.widget.c.b)localObject2).b(com.tencent.mm.media.widget.a.b.awd(), paramBoolean, paramInt));
        ad.i("MicroMsg.CameraPreviewContainer", "start record ret:".concat(String.valueOf(localObject2)));
        if (!this.htr.axL()) {
          break label294;
        }
        localb = this.htd;
        if (localb == null) {}
      }
    }
    label153:
    label294:
    for (localObject1 = Integer.valueOf(localb.b(com.tencent.mm.media.widget.a.b.awd(), paramBoolean, paramInt));; localObject1 = Integer.valueOf(-1))
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
          ad.i("MicroMsg.CameraPreviewContainer", "start record base ret:" + localObject2 + " daemon ret:" + localObject1 + " ,use daemon record:" + this.htr.axL());
          this.htf = bt.HI();
          this.htg = true;
          this.hto = false;
          localObject1 = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.auZ();
          AppMethodBeat.o(94224);
          return true;
        } while (((Integer)localObject1).intValue() == 0);
      }
      ad.m("MicroMsg.CameraPreviewContainer", "cameraConfig is null", new Object[0]);
      AppMethodBeat.o(94224);
      return false;
    }
  }
  
  public final void oa(int paramInt)
  {
    AppMethodBeat.i(94230);
    if (this.currentState == 0) {
      this.gIo.nW(paramInt);
    }
    AppMethodBeat.o(94230);
  }
  
  public final boolean p(final d.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, z> paramb)
  {
    AppMethodBeat.i(94227);
    if (!this.htg)
    {
      AppMethodBeat.o(94227);
      return true;
    }
    this.htg = false;
    if (bt.aO(this.htf) < this.htl)
    {
      ad.m("MicroMsg.CameraPreviewContainer", "stopRecord " + bt.aO(this.htf), new Object[0]);
      paramb = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.ava();
      axs();
      AppMethodBeat.o(94227);
      return false;
    }
    ad.m("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
    final com.tencent.mm.media.k.a locala = new com.tencent.mm.media.k.a("stopRecord");
    final y.d locald = new y.d();
    locald.MLT = 0;
    final y.f localf1 = new y.f();
    localf1.MLV = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, 16383);
    final y.f localf2 = new y.f();
    localf2.MLV = ((Runnable)new h(this, localf1, paramb));
    if (this.htr.axL())
    {
      localObject = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.avb();
    }
    Object localObject = new y.f();
    ((y.f)localObject).MLV = this.htc;
    com.tencent.mm.media.widget.c.b localb = this.htc;
    if (localb != null) {
      localb.D((Runnable)new f(this, (y.f)localObject, locala, localf1, locald, localf2, paramb));
    }
    localObject = this.htd;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.c.b)localObject).D((Runnable)new g(this, locala, localf1, locald, localf2, paramb));
    }
    AppMethodBeat.o(94227);
    return true;
  }
  
  public final void q(d.g.a.b<? super byte[], z> paramb)
  {
    AppMethodBeat.i(94239);
    p.h(paramb, "callback");
    this.gIo.awc();
    this.gIo.a((g)new a.b(paramb));
    AppMethodBeat.o(94239);
  }
  
  public final void r(final d.g.a.b<? super Bitmap, z> paramb)
  {
    AppMethodBeat.i(94246);
    p.h(paramb, "callback");
    if (!this.gIo.awa())
    {
      ad.e("MicroMsg.CameraPreviewContainer", "camera.isCameraPreviewing : false");
      paramb.invoke(null);
      AppMethodBeat.o(94246);
      return;
    }
    if ((com.tencent.mm.media.widget.d.a.c(this.htr)) && (!com.tencent.mm.media.widget.d.a.b(this.htr)))
    {
      l = bt.HI();
      this.gIo.n((d.g.a.b)new j(this, l, paramb));
      AppMethodBeat.o(94246);
      return;
    }
    final long l = bt.HI();
    com.tencent.mm.media.j.a locala = this.hlj;
    if (locala != null)
    {
      locala.m((d.g.a.b)new i(this, paramb, l));
      locala.atV();
      AppMethodBeat.o(94246);
      return;
    }
    AppMethodBeat.o(94246);
  }
  
  public final void rD(long paramLong)
  {
    AppMethodBeat.i(94232);
    ad.i("MicroMsg.CameraPreviewContainer", "setRecordMiniTime:".concat(String.valueOf(paramLong)));
    this.htl = paramLong;
    AppMethodBeat.o(94232);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94237);
    try
    {
      ad.i("MicroMsg.CameraPreviewContainer", "release");
      this.gIo.onDestroy();
      this.gIo.release();
      Object localObject = this.htn;
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).huc.disable();
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).context = null;
      localObject = c.htE;
      c.axx();
      this.htr.getCameraPreviewView().release();
      localObject = this.htc;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.htc;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.htd;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.htd;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.hlj;
      if (localObject != null) {
        com.tencent.mm.media.j.a.a((com.tencent.mm.media.j.a)localObject);
      }
      this.hlj = null;
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
      this.gIo.release();
      this.gIo.b(this.htr.getCameraPreviewView().getFrameDataCallback());
      this.htr.getCameraPreviewView().amm();
      if (!this.htp) {
        this.htn.a(false, null);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<com.tencent.mm.media.g.d, z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$setRender$curRenderer$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class d
    extends com.tencent.mm.media.j.d
  {
    d(int paramInt)
    {
      super();
    }
    
    public final com.tencent.mm.media.j.b.a amr()
    {
      AppMethodBeat.i(94216);
      if (this.htt.htr.axJ())
      {
        locala = (com.tencent.mm.media.j.b.a)new f(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
        AppMethodBeat.o(94216);
        return locala;
      }
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
      AppMethodBeat.o(94216);
      return locala;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<SurfaceTexture, z>
  {
    e(a parama, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, y.f paramf1, com.tencent.mm.media.k.a parama1, y.f paramf2, y.d paramd, y.f paramf3, d.g.a.b paramb) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(94219);
      if (a.f(this.htt))
      {
        AppMethodBeat.o(94219);
        return;
      }
      Object localObject2 = new StringBuilder("stopRecord ");
      Object localObject1 = (com.tencent.mm.media.widget.c.b)this.htv.MLV;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
        localObject1 = (com.tencent.mm.media.widget.c.b)this.htv.MLV;
        if (localObject1 == null) {
          break label437;
        }
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).axA();
        label88:
        ad.m("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
        locala.akO();
        localObject1 = (com.tencent.mm.media.widget.c.b)this.htv.MLV;
        if (localObject1 == null) {
          break label442;
        }
      }
      label437:
      label442:
      for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
      {
        localObject2 = (com.tencent.mm.media.widget.c.b)this.htv.MLV;
        if (localObject2 != null) {
          str = ((com.tencent.mm.media.widget.c.b)localObject2).axA();
        }
        if ((localObject1 == null) || (str == null)) {
          break label475;
        }
        localObject2 = com.tencent.mm.plugin.sight.base.e.axx((String)localObject1);
        if (localObject2 == null) {
          break label475;
        }
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV).htP = true;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV).yk((String)localObject1);
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV).yl(str);
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV).ddx = 0;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV).htQ = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
        localObject1 = locald;
        ((y.d)localObject1).MLT += 1;
        ad.i("MicroMsg.CameraPreviewContainer", "record video info main: ".concat(String.valueOf(localObject2)));
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avo();
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.ru(((com.tencent.mm.plugin.sight.base.a)localObject2).videoBitrate);
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.rv(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate);
        if (((!this.htt.htr.axL()) || (locald.MLT != 2)) && (this.htt.htr.axL())) {
          break label453;
        }
        if ((this.htt.htr.axL()) && (locald.MLT == 2))
        {
          localObject1 = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.avc();
        }
        aq.aA((Runnable)localf2.MLV);
        a.g(this.htt);
        localObject1 = paramb;
        if (localObject1 == null) {
          break label447;
        }
        ((d.g.a.b)localObject1).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV);
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
      aq.o((Runnable)localf2.MLV, 3000L);
      AppMethodBeat.o(94219);
      return;
      label475:
      AppMethodBeat.o(94219);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama, com.tencent.mm.media.k.a parama1, y.f paramf1, y.d paramd, y.f paramf2, d.g.a.b paramb) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(94220);
      if (a.f(this.htt))
      {
        AppMethodBeat.o(94220);
        return;
      }
      Object localObject2 = new StringBuilder("stop daemonRecorder ");
      Object localObject1 = a.e(this.htt);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
        localObject1 = a.e(this.htt);
        if (localObject1 == null) {
          break label387;
        }
        localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).axA();
        label82:
        ad.m("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
        locala.akO();
        localObject1 = a.e(this.htt);
        if (localObject1 == null) {
          break label392;
        }
      }
      label387:
      label392:
      for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
      {
        localObject2 = a.e(this.htt);
        if (localObject2 != null) {
          str = ((com.tencent.mm.media.widget.c.b)localObject2).axA();
        }
        if ((localObject1 == null) || (str == null)) {
          break label425;
        }
        localObject2 = com.tencent.mm.plugin.sight.base.e.axx((String)localObject1);
        if (localObject2 == null) {
          break label425;
        }
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV).htP = true;
        com.tencent.mm.media.widget.camerarecordview.b.b localb = (com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV;
        p.h(localObject1, "<set-?>");
        localb.htR = ((String)localObject1);
        localObject1 = (com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV;
        p.h(str, "<set-?>");
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).htS = str;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV).htT = 0;
        ((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV).htU = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
        localObject1 = locald;
        ((y.d)localObject1).MLT += 1;
        ad.i("MicroMsg.CameraPreviewContainer", "record video info daemon: ".concat(String.valueOf(localObject2)));
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avp();
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.rw(((com.tencent.mm.plugin.sight.base.a)localObject2).videoBitrate);
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.rx(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate);
        if (locald.MLT != 2) {
          break label403;
        }
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avc();
        aq.aA((Runnable)localf2.MLV);
        a.g(this.htt);
        localObject1 = paramb;
        if (localObject1 == null) {
          break label397;
        }
        ((d.g.a.b)localObject1).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV);
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
      aq.o((Runnable)localf2.MLV, 3000L);
      AppMethodBeat.o(94220);
      return;
      label425:
      AppMethodBeat.o(94220);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(a parama, y.f paramf, d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(94221);
      if (!((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV).axC())
      {
        localObject = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avd();
        localObject = a.d(this.htt);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).cancel();
        }
      }
      if (!((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV).axB())
      {
        localObject = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.ave();
        localObject = a.e(this.htt);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.c.b)localObject).cancel();
        }
      }
      a.g(this.htt);
      Object localObject = paramb;
      if (localObject != null)
      {
        ((d.g.a.b)localObject).invoke((com.tencent.mm.media.widget.camerarecordview.b.b)localf1.MLV);
        AppMethodBeat.o(94221);
        return;
      }
      AppMethodBeat.o(94221);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/nio/IntBuffer;", "invoke", "com/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer$takePicture$2$1"})
  static final class i
    extends q
    implements d.g.a.b<IntBuffer, z>
  {
    i(a parama, d.g.a.b paramb, long paramLong)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
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