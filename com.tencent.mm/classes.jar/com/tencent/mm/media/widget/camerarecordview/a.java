package com.tencent.mm.media.widget.camerarecordview;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.opengl.EGLContext;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.a.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "cameraCountNumber", "", "context", "Landroid/content/Context;", "currentState", "initRecorderRet", "", "isRecording", "lastFlipCameraStamp", "", "mediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordMiniTime", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "startRecordTimeStamp", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "afterStartPreview", "", "cancelRecord", "createRecorder", "getCameraCount", "getCameraPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getMD5", "", "getRecordFilePath", "getRecordTime", "initRecorder", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "isPreviewing", "isUseBackGroundCamera", "onPause", "onResume", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "setRecordMiniTime", "time", "setRender", "startPreview", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "startRecord", "isLandscape", "deviceDegree", "stopPreview", "stopRecord", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "capture", "switchCamera", "takePicture", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a fbd;
  private Context context;
  private int currentState;
  com.tencent.mm.media.h.a eWh;
  public final int faS;
  private final e faT;
  public com.tencent.mm.media.widget.b.b faU;
  private final ak faV;
  public boolean faW;
  private long faX;
  private long faY;
  private boolean faZ;
  private long fba;
  private com.tencent.mm.media.widget.camerarecordview.b.a fbb;
  com.tencent.mm.media.widget.camerarecordview.c.a fbc;
  public boolean isRecording;
  
  static
  {
    AppMethodBeat.i(13246);
    fbd = new a.a((byte)0);
    AppMethodBeat.o(13246);
  }
  
  public a(com.tencent.mm.media.widget.camerarecordview.c.a parama)
  {
    AppMethodBeat.i(13245);
    this.fbc = parama;
    this.faS = com.tencent.mm.compatible.e.d.getNumberOfCameras();
    this.faV = new ak(Looper.getMainLooper());
    this.faW = true;
    this.currentState = 1;
    this.fba = 2000L;
    com.tencent.luggage.g.d.b("MicroMsg.CameraPreviewContainer", this.fbc.toString(), new Object[0]);
    parama = this.fbc.getCameraPreviewView();
    Object localObject;
    if (this.fbc.getPreviewRenderer() != null)
    {
      this.eWh = this.fbc.getPreviewRenderer();
      localObject = this.fbc.getPreviewRenderer();
      if (localObject == null) {
        j.ebi();
      }
      parama.a((com.tencent.mm.media.h.a)localObject, this.fbc.Xn());
    }
    for (;;)
    {
      this.faT = ((e)new com.tencent.mm.media.widget.a.d(this.fbc.getContext()));
      this.faY = bo.yB();
      this.context = this.fbc.getContext();
      this.fbb = new com.tencent.mm.media.widget.camerarecordview.b.a(this.context, this.fbc);
      AppMethodBeat.o(13245);
      return;
      localObject = new a.c(this);
      this.eWh = ((com.tencent.mm.media.h.a)localObject);
      parama.a((com.tencent.mm.media.h.a)localObject, this.fbc.Xn());
    }
  }
  
  private final boolean Xb()
  {
    AppMethodBeat.i(13240);
    com.tencent.luggage.g.d.i("MicroMsg.CameraPreviewContainer", "createRecorder: " + this.faU + ", useCpuCrop:" + this.fbc.Xn() + ", process.getRecorder():" + this.fbc.getRecorder() + ", mute:" + this.fbc.DP());
    Object localObject1 = this.faU;
    if (localObject1 != null)
    {
      ((com.tencent.mm.media.widget.b.b)localObject1).cancel();
      ((com.tencent.mm.media.widget.b.b)localObject1).clear();
    }
    localObject1 = this.fbc.getEncodeConfig();
    if (this.fbc.getRecorder() != null) {
      localObject1 = this.fbc.getRecorder();
    }
    for (;;)
    {
      this.faU = ((com.tencent.mm.media.widget.b.b)localObject1);
      localObject1 = this.faU;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.b.b)localObject1).setMute(this.fbc.DP());
      }
      this.fbc.getCameraPreviewView().setOnDrawListener((a.f.a.b)new b(this));
      com.tencent.luggage.g.d.i("MicroMsg.CameraPreviewContainer", "create recorder finish");
      AppMethodBeat.o(13240);
      return true;
      Object localObject2;
      if (this.fbc.Xn())
      {
        localObject2 = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Vu();
        localObject2 = b.fbj;
        localObject1 = b.a(((com.tencent.mm.media.widget.camerarecordview.a.a)localObject1).Xh(), this.fbc.getVideoTransPara(), this.faT, this.fbc.getRecordRenderer());
      }
      else
      {
        localObject2 = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Vt();
        if (this.fbc.getCameraPreviewView().getEGLContext() == null)
        {
          com.tencent.luggage.g.d.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
          localObject1 = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.Vv();
          AppMethodBeat.o(13240);
          return false;
        }
        localObject2 = b.fbj;
        int i = ((com.tencent.mm.media.widget.camerarecordview.a.a)localObject1).Xh();
        localObject1 = this.fbc.getVideoTransPara();
        localObject2 = this.faT;
        EGLContext localEGLContext = this.fbc.getCameraPreviewView().getEGLContext();
        if (localEGLContext == null) {
          j.ebi();
        }
        localObject1 = b.a(i, (VideoTransPara)localObject1, (e)localObject2, localEGLContext, this.fbc.getCameraPreviewView(), this.fbc.Xn(), this.fbc.getRecordRenderer());
      }
    }
  }
  
  private final void Xc()
  {
    Object localObject2 = null;
    AppMethodBeat.i(13241);
    com.tencent.mm.media.widget.b.b localb = this.faU;
    if (localb != null) {
      localb.s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.WQ(), com.tencent.mm.media.widget.a.b.WR());
    }
    if (localb != null) {
      localb.setFilePath(this.fbc.getEncodeConfig().getFilePath());
    }
    if (localb != null) {
      localb.mV(this.fbc.getEncodeConfig().Xi());
    }
    StringBuilder localStringBuilder = new StringBuilder("filePath : ");
    Object localObject1;
    if (localb != null)
    {
      localObject1 = localb.getFilePath();
      localStringBuilder = localStringBuilder.append((String)localObject1).append("   thumbPath : ");
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.Xi();
      }
      com.tencent.luggage.g.d.b("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
      localObject1 = this.faU;
      if (localObject1 == null) {
        break label217;
      }
    }
    label217:
    for (boolean bool = ((com.tencent.mm.media.widget.b.b)localObject1).km(com.tencent.mm.media.widget.a.b.WP());; bool = false)
    {
      com.tencent.luggage.g.d.b("MicroMsg.CameraPreviewContainer", "init recorder ret:".concat(String.valueOf(bool)), new Object[0]);
      this.faZ = bool;
      AppMethodBeat.o(13241);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final boolean WN()
  {
    AppMethodBeat.i(13239);
    com.tencent.luggage.g.d.i("MicroMsg.CameraPreviewContainer", "flipCamera time space:" + bo.av(this.faY));
    if (bo.av(this.faY) < 1000L)
    {
      bool = this.faW;
      AppMethodBeat.o(13239);
      return bool;
    }
    this.faY = bo.yB();
    if (this.isRecording)
    {
      localObject = this.faU;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.b.b)localObject).pause();
      }
    }
    this.fbc.getCameraPreviewView().Xl();
    this.faW = this.faT.WN();
    Object localObject = this.faT.WX();
    com.tencent.mm.media.widget.camerarecordview.b.a locala = this.fbb;
    if ((!this.faW) && (this.fbc.Xo())) {}
    for (boolean bool = true;; bool = false)
    {
      locala.a(bool, (com.tencent.mm.media.widget.a.b)localObject);
      if (localObject != null)
      {
        this.fbc.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
        localObject = b.fbj;
        localObject = b.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.h.a)localObject).cm(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
        }
        localObject = b.fbj;
        localObject = b.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.h.a)localObject).jX(com.tencent.mm.media.widget.a.b.WP());
        }
        localObject = b.fbj;
        localObject = b.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.h.a)localObject).cE(com.tencent.mm.media.widget.a.b.WS());
        }
        localObject = this.faU;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.b.b)localObject).s(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.WQ(), com.tencent.mm.media.widget.a.b.WR());
        }
        if (this.isRecording)
        {
          localObject = this.faU;
          if (localObject != null) {
            ((com.tencent.mm.media.widget.b.b)localObject).G(com.tencent.mm.media.widget.a.b.WP(), com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          }
        }
      }
      bool = this.faW;
      AppMethodBeat.o(13239);
      return bool;
    }
  }
  
  public final void WW()
  {
    AppMethodBeat.i(13236);
    if (this.currentState == 0) {
      this.faT.WW();
    }
    AppMethodBeat.o(13236);
  }
  
  public final Point Xd()
  {
    AppMethodBeat.i(152130);
    Point localPoint = this.faT.WY();
    AppMethodBeat.o(152130);
    return localPoint;
  }
  
  public final String Xe()
  {
    AppMethodBeat.i(152131);
    Object localObject = this.faU;
    if (localObject != null)
    {
      String str = ((com.tencent.mm.media.widget.b.b)localObject).getFilePath();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    AppMethodBeat.o(152131);
    return localObject;
  }
  
  public final long Xf()
  {
    AppMethodBeat.i(152132);
    com.tencent.mm.media.widget.b.b localb = this.faU;
    if (localb != null)
    {
      long l = localb.Xf();
      AppMethodBeat.o(152132);
      return l;
    }
    AppMethodBeat.o(152132);
    return 0L;
  }
  
  public final void a(boolean paramBoolean, a.f.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(13242);
    if (this.currentState == 0)
    {
      com.tencent.luggage.g.d.e("MicroMsg.CameraPreviewContainer", "startPreview, already in preview state");
      AppMethodBeat.o(13242);
      return;
    }
    this.currentState = 0;
    com.tencent.luggage.g.d.b("MicroMsg.CameraPreviewContainer", "startPreview process.useCpuCrop():" + this.fbc.Xn(), new Object[0]);
    this.faW = paramBoolean;
    this.faT.p(this.fbc.getContext(), paramBoolean);
    if (this.fbc.Xn()) {
      this.faT.a(this.fbc.getCameraPreviewView().getFrameDataCallback());
    }
    this.fbc.getCameraPreviewView().e((a.f.a.b)new a.d(this, paramb));
    AppMethodBeat.o(13242);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(13238);
    if (this.currentState == 0) {
      this.faT.a(paramBoolean1, paramBoolean2, paramInt);
    }
    AppMethodBeat.o(13238);
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13235);
    if (this.currentState == 0) {
      this.faT.b(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(13235);
  }
  
  public final boolean c(a.f.a.b<? super com.tencent.mm.media.widget.camerarecordview.a.b, y> paramb)
  {
    AppMethodBeat.i(13234);
    if (!this.isRecording)
    {
      AppMethodBeat.o(13234);
      return true;
    }
    this.isRecording = false;
    if (bo.av(this.faX) < this.fba)
    {
      com.tencent.luggage.g.d.b("MicroMsg.CameraPreviewContainer", "stopRecord " + bo.av(this.faX), new Object[0]);
      paramb = this.faU;
      if (paramb != null) {
        paramb.cancel();
      }
      paramb = this.faU;
      if (paramb != null) {
        paramb.clear();
      }
      Xb();
      if (this.faT.WX() == null)
      {
        AppMethodBeat.o(13234);
        return false;
      }
      Xc();
      AppMethodBeat.o(13234);
      return false;
    }
    com.tencent.luggage.g.d.b("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
    com.tencent.mm.media.i.a locala = new com.tencent.mm.media.i.a("stopRecord");
    com.tencent.mm.media.widget.b.b localb = this.faU;
    if (localb != null) {
      localb.u((Runnable)new a.e(this, locala, paramb));
    }
    AppMethodBeat.o(13234);
    return true;
  }
  
  public final void d(a.f.a.b<? super Bitmap, y> paramb)
  {
    AppMethodBeat.i(152133);
    j.q(paramb, "callback");
    if (!this.faT.WO())
    {
      com.tencent.luggage.g.d.e("MicroMsg.CameraPreviewContainer", "camera.isCameraPreviewing : false");
      paramb.S(null);
      AppMethodBeat.o(152133);
      return;
    }
    long l = bo.yB();
    com.tencent.mm.media.h.a locala = this.eWh;
    if (locala != null)
    {
      paramb = (a.f.a.b)new a.f(this, paramb, l);
      j.q(paramb, "listener");
      Object localObject = new StringBuilder("glTextureRenderProc is null ?");
      if (locala.eXY == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.b("MicroMsg.Media.AbsSurfaceRenderer", bool, new Object[0]);
        localObject = locala.eXY;
        if (localObject != null) {
          ((com.tencent.mm.media.h.b.a)localObject).eYC = paramb;
        }
        ab.i("MicroMsg.Media.AbsSurfaceRenderer", "takePhoto");
        paramb = locala.eXY;
        if (paramb == null) {
          break;
        }
        paramb.eYD = true;
        AppMethodBeat.o(152133);
        return;
      }
      AppMethodBeat.o(152133);
      return;
    }
    AppMethodBeat.o(152133);
  }
  
  public final boolean g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(152125);
    com.tencent.luggage.g.d.b("MicroMsg.CameraPreviewContainer", "startRecord", new Object[0]);
    if ((this.faT.WX() != null) && (this.faU != null))
    {
      if (!this.faZ)
      {
        com.tencent.luggage.g.d.i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
        AppMethodBeat.o(152125);
        return false;
      }
      Object localObject = this.faU;
      if (localObject != null)
      {
        localObject = Integer.valueOf(((com.tencent.mm.media.widget.b.b)localObject).b(com.tencent.mm.media.widget.a.b.WP(), paramBoolean, paramInt));
        com.tencent.luggage.g.d.i("MicroMsg.CameraPreviewContainer", "start record ret:".concat(String.valueOf(localObject)));
        if (localObject != null) {
          break label116;
        }
      }
      label116:
      while (((Integer)localObject).intValue() != 0)
      {
        AppMethodBeat.o(152125);
        return false;
        localObject = null;
        break;
      }
      this.faX = bo.yB();
      this.isRecording = true;
      AppMethodBeat.o(152125);
      return true;
    }
    com.tencent.luggage.g.d.b("MicroMsg.CameraPreviewContainer", "cameraConfig is null", new Object[0]);
    AppMethodBeat.o(152125);
    return false;
  }
  
  public final void gq(long paramLong)
  {
    AppMethodBeat.i(152127);
    com.tencent.luggage.g.d.i("MicroMsg.CameraPreviewContainer", "setRecordMiniTime:".concat(String.valueOf(paramLong)));
    this.fba = paramLong;
    AppMethodBeat.o(152127);
  }
  
  public final void kk(int paramInt)
  {
    AppMethodBeat.i(13237);
    if (this.currentState == 0) {
      this.faT.kh(paramInt);
    }
    AppMethodBeat.o(13237);
  }
  
  public final void release()
  {
    AppMethodBeat.i(152128);
    try
    {
      com.tencent.luggage.g.d.i("MicroMsg.CameraPreviewContainer", "release");
      this.faT.release();
      Object localObject = this.fbb;
      ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject).fbt.disable();
      ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject).context = null;
      localObject = b.fbj;
      b.Xg();
      this.fbc.getCameraPreviewView().release();
      localObject = this.faU;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.b.b)localObject).cancel();
      }
      localObject = this.faU;
      if (localObject != null)
      {
        ((com.tencent.mm.media.widget.b.b)localObject).clear();
        AppMethodBeat.o(152128);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "camera release error:" + localException.getMessage(), new Object[0]);
      }
      AppMethodBeat.o(152128);
    }
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(13244);
    if (this.currentState == 1)
    {
      AppMethodBeat.o(13244);
      return;
    }
    this.currentState = 1;
    com.tencent.luggage.g.d.b("MicroMsg.CameraPreviewContainer", "stopPreview", new Object[0]);
    try
    {
      this.faT.release();
      this.faT.b(this.fbc.getCameraPreviewView().getFrameDataCallback());
      this.fbc.getCameraPreviewView().Xk();
      this.fbb.a(false, null);
      AppMethodBeat.o(13244);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "camera relase error:" + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends k
    implements a.f.a.b<Integer, y>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a
 * JD-Core Version:    0.7.0.1
 */