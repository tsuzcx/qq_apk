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
import com.tencent.mm.media.widget.c.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "cameraPreviewInfo", "Lkotlin/Triple;", "", "context", "Landroid/content/Context;", "currentState", "customOrientation", "", "daemonRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "frameRenderCallback", "Lkotlin/Function0;", "", "getFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "initRecorderRet", "isRecording", "lastFlipCameraStamp", "", "mediaRecorder", "needResumeRecorder", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "orientationFit", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "getProcess", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "setProcess", "recordFinish", "recordMiniTime", "recordMirror", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "reportJSON", "Lcom/tencent/mm/json/JSONObject;", "startPreviewStamp", "startRecordTimeStamp", "getStartRecordTimeStamp", "()J", "setStartRecordTimeStamp", "(J)V", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "useBackGroundCamera", "afterStartPreview", "cancelRecord", "checkFlashStatus", "openFlash", "configVendorTagValue", "tag", "", "createImageReaderCallback", "callback", "", "data", "createRecorder", "enableSwitchCamera", "getCameraOrientaion", "getCameraPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getFlashMode", "getMD5", "getRecordFilePath", "getRecordTime", "getReportJSON", "getSupportZoomRatios", "", "initRecorder", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "isPreviewing", "isUseBackGroundCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "prepareCameraZoom", "baseTopLocation", "release", "removeFocusOnTouch", "reportRecordMuxerType", "resetRecord", "setCustomOrientationEnable", "enable", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "flash", "setForceZoomTargetRatio", "ratio", "setMute", "mute", "setRecordMiniTime", "time", "setRecordMirror", "isMirror", "setRender", "setValueToReport", "key", "startPreview", "displayRatio", "success", "(ZLjava/lang/Float;Lkotlin/jvm/functions/Function1;)V", "startRecord", "isLandscape", "deviceDegree", "stopPreview", "stopRecord", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "capture", "switchCamera", "ignoreFlipCheck", "switchVendorTag", "isChecked", "takePicture", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a nJg;
  private Context context;
  public int currentState;
  private final MMHandler mRi;
  public final com.tencent.mm.media.widget.a.f mRu;
  com.tencent.mm.media.j.a nBj;
  public kotlin.g.a.b<? super Boolean, ah> nGB;
  public com.tencent.mm.media.widget.camerarecordview.d.a nJh;
  public com.tencent.mm.media.widget.c.b nJi;
  private com.tencent.mm.media.widget.c.b nJj;
  public boolean nJk;
  public long nJl;
  private boolean nJm;
  private volatile boolean nJn;
  private volatile kotlin.u<Integer, Integer, Integer> nJo;
  private long nJp;
  private boolean nJq;
  private long nJr;
  public com.tencent.mm.media.widget.camerarecordview.c.a nJs;
  private volatile boolean nJt;
  public boolean nJu;
  kotlin.g.a.a<ah> nJv;
  public boolean nJw;
  private long nJx;
  public i nJy;
  
  static
  {
    AppMethodBeat.i(94250);
    nJg = new a.a((byte)0);
    AppMethodBeat.o(94250);
  }
  
  public a(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94249);
    this.nJh = parama;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.nJk = true;
    this.nJo = new kotlin.u(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
    this.currentState = 1;
    this.nJr = 2000L;
    this.nJw = true;
    this.nJy = new i();
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", this.nJh.toString(), new Object[0]);
    parama = this.nJh.getCameraPreviewView();
    Object localObject;
    if (this.nJh.getPreviewRenderer() != null)
    {
      this.nBj = this.nJh.getPreviewRenderer();
      localObject = this.nJh.getPreviewRenderer();
      s.checkNotNull(localObject);
      parama.a((com.tencent.mm.media.j.a)localObject, this.nJh.bun());
      if ((!com.tencent.mm.media.widget.d.c.f(Integer.valueOf(this.nJh.getRecordScene()))) || (this.nJh.bun())) {
        break label352;
      }
      this.mRu = ((com.tencent.mm.media.widget.a.f)new com.tencent.mm.media.widget.b.d(this.nJh.getContext()));
      if (com.tencent.mm.media.widget.d.c.uz(this.nJh.getRecordScene())) {
        this.mRu.bsE();
      }
      p("isUseCamera2", Boolean.TRUE);
    }
    for (;;)
    {
      this.nJp = Util.currentTicks();
      this.context = this.nJh.getContext();
      this.nJs = new com.tencent.mm.media.widget.camerarecordview.c.a(this.context, this.nJh);
      AppMethodBeat.o(94249);
      return;
      localObject = new c(this.nJh.bun());
      this.nBj = ((com.tencent.mm.media.j.a)localObject);
      parama.a((com.tencent.mm.media.j.a)localObject, this.nJh.bun());
      break;
      label352:
      this.mRu = ((com.tencent.mm.media.widget.a.f)new com.tencent.mm.media.widget.a.d(this.nJh.getContext()));
      p("isUseCamera2", Boolean.FALSE);
    }
  }
  
  private static final void a(a parama, com.tencent.mm.media.util.a parama1, ah.f paramf1, ah.d paramd, ah.f paramf2, kotlin.g.a.b paramb)
  {
    com.tencent.mm.plugin.sight.base.b localb = null;
    AppMethodBeat.i(237688);
    s.u(parama, "this$0");
    s.u(parama1, "$man");
    s.u(paramf1, "$captureInfo");
    s.u(paramd, "$doubleCheck");
    s.u(paramf2, "$daemonRecordTimeoutCheck");
    if (parama.nJt)
    {
      AppMethodBeat.o(237688);
      return;
    }
    Object localObject2 = new StringBuilder("stop daemonRecorder ");
    Object localObject1 = parama.nJj;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(' ');
      localObject1 = parama.nJj;
      if (localObject1 != null) {
        break label405;
      }
      localObject1 = null;
      label113:
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", localObject1, new Object[0]);
      parama1.bbW();
      parama.p("LowRecordStopWaitTime", Long.valueOf(parama1.mHw.aPY()));
      parama1 = parama.nJj;
      if (parama1 != null) {
        break label417;
      }
      parama1 = null;
      label165:
      localObject1 = parama.nJj;
      if (localObject1 != null) {
        break label427;
      }
      localObject1 = localb;
    }
    for (;;)
    {
      if ((parama1 != null) && (localObject1 != null))
      {
        localb = com.tencent.mm.plugin.sight.base.f.aVX(parama1);
        if (localb != null)
        {
          ((com.tencent.mm.media.widget.camerarecordview.b.b)paramf1.aqH).nJW = true;
          localObject2 = (com.tencent.mm.media.widget.camerarecordview.b.b)paramf1.aqH;
          s.u(parama1, "<set-?>");
          ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).nJX = parama1;
          parama1 = (com.tencent.mm.media.widget.camerarecordview.b.b)paramf1.aqH;
          s.u(localObject1, "<set-?>");
          parama1.nJY = ((String)localObject1);
          ((com.tencent.mm.media.widget.camerarecordview.b.b)paramf1.aqH).nJZ = 0;
          ((com.tencent.mm.media.widget.camerarecordview.b.b)paramf1.aqH).nKa = localb.videoDuration;
          paramd.aixb += 1;
          Log.i("MicroMsg.CameraPreviewContainer", s.X("record video info daemon: ", localb));
          parama1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.brD();
          parama1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.ie(localb.videoBitrate);
          parama1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.jdMethod_if(localb.frameRate);
          if (paramd.aixb == 2)
          {
            parama1 = com.tencent.mm.media.util.f.nFE;
            com.tencent.mm.media.util.f.brq();
            MMHandlerThread.removeRunnable((Runnable)paramf2.aqH);
            parama.nJt = true;
            if (paramb == null) {
              break label453;
            }
            paramb.invoke(paramf1.aqH);
            AppMethodBeat.o(237688);
            return;
            localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
            break;
            label405:
            localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).bud();
            break label113;
            label417:
            parama1 = parama1.getFilePath();
            break label165;
            label427:
            localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).bud();
            continue;
          }
          MMHandlerThread.postToMainThreadDelayed((Runnable)paramf2.aqH, 3000L);
        }
      }
    }
    label453:
    AppMethodBeat.o(237688);
  }
  
  private static final void a(a parama, ah.f paramf1, com.tencent.mm.media.util.a parama1, ah.f paramf2, ah.d paramd, ah.f paramf3, kotlin.g.a.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(237678);
    s.u(parama, "this$0");
    s.u(paramf1, "$that");
    s.u(parama1, "$man");
    s.u(paramf2, "$captureInfo");
    s.u(paramd, "$doubleCheck");
    s.u(paramf3, "$daemonRecordTimeoutCheck");
    if (parama.nJt)
    {
      AppMethodBeat.o(237678);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("stopRecord ");
    Object localObject1 = (com.tencent.mm.media.widget.c.b)paramf1.aqH;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      localObject1 = (com.tencent.mm.media.widget.c.b)paramf1.aqH;
      if (localObject1 != null) {
        break label447;
      }
      localObject1 = null;
      label127:
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", localObject1, new Object[0]);
      parama1.bbW();
      parama.p("HighRecordStopWaitTime", Long.valueOf(parama1.mHw.aPY()));
      parama1 = (com.tencent.mm.media.widget.c.b)paramf1.aqH;
      if (parama1 != null) {
        break label459;
      }
      parama1 = null;
      label182:
      paramf1 = (com.tencent.mm.media.widget.c.b)paramf1.aqH;
      if (paramf1 != null) {
        break label469;
      }
      paramf1 = localObject2;
    }
    for (;;)
    {
      if ((parama1 != null) && (paramf1 != null))
      {
        localObject1 = com.tencent.mm.plugin.sight.base.f.aVX(parama1);
        if (localObject1 != null)
        {
          ((com.tencent.mm.media.widget.camerarecordview.b.b)paramf2.aqH).nJW = true;
          ((com.tencent.mm.media.widget.camerarecordview.b.b)paramf2.aqH).GZ(parama1);
          ((com.tencent.mm.media.widget.camerarecordview.b.b)paramf2.aqH).Ha(paramf1);
          ((com.tencent.mm.media.widget.camerarecordview.b.b)paramf2.aqH).startTime = 0;
          ((com.tencent.mm.media.widget.camerarecordview.b.b)paramf2.aqH).endTime = ((com.tencent.mm.plugin.sight.base.b)localObject1).videoDuration;
          paramd.aixb += 1;
          Log.i("MicroMsg.CameraPreviewContainer", s.X("record video info main: ", localObject1));
          paramf1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.brC();
          paramf1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.ic(((com.tencent.mm.plugin.sight.base.b)localObject1).videoBitrate);
          paramf1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.id(((com.tencent.mm.plugin.sight.base.b)localObject1).frameRate);
          if (((parama.nJh.bup()) && (paramd.aixb == 2)) || (!parama.nJh.bup()))
          {
            if ((parama.nJh.bup()) && (paramd.aixb == 2))
            {
              paramf1 = com.tencent.mm.media.util.f.nFE;
              com.tencent.mm.media.util.f.brq();
            }
            MMHandlerThread.removeRunnable((Runnable)paramf3.aqH);
            parama.nJt = true;
            if (paramb == null) {
              break label493;
            }
            paramb.invoke(paramf2.aqH);
            AppMethodBeat.o(237678);
            return;
            localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
            break;
            label447:
            localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).bud();
            break label127;
            label459:
            parama1 = parama1.getFilePath();
            break label182;
            label469:
            paramf1 = paramf1.bud();
            continue;
          }
          MMHandlerThread.postToMainThreadDelayed((Runnable)paramf3.aqH, 3000L);
        }
      }
    }
    label493:
    AppMethodBeat.o(237678);
  }
  
  private static final void a(ah.f paramf, a parama, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(237667);
    s.u(paramf, "$captureInfo");
    s.u(parama, "this$0");
    Object localObject;
    if (!((com.tencent.mm.media.widget.camerarecordview.b.b)paramf.aqH).buf())
    {
      localObject = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.brr();
      localObject = parama.nJi;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
    }
    if (!((com.tencent.mm.media.widget.camerarecordview.b.b)paramf.aqH).bue())
    {
      localObject = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.brs();
      localObject = parama.nJj;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
    }
    parama.nJt = true;
    if (paramb != null) {
      paramb.invoke(paramf.aqH);
    }
    AppMethodBeat.o(237667);
  }
  
  private static final boolean a(kotlin.g.a.b paramb, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(237694);
    s.u(paramb, "$callback");
    s.s(paramArrayOfByte, "it");
    paramb.invoke(paramArrayOfByte);
    AppMethodBeat.o(237694);
    return true;
  }
  
  public static boolean btW()
  {
    AppMethodBeat.i(94235);
    boolean bool = com.tencent.mm.media.widget.d.c.btW();
    AppMethodBeat.o(94235);
    return bool;
  }
  
  private final boolean btY()
  {
    AppMethodBeat.i(94238);
    long l = Util.currentTicks();
    Object localObject1 = this.nJh.getRecorder();
    Log.i("MicroMsg.CameraPreviewContainer", "createRecorder: " + this.nJi + ", useCpuCrop:" + this.nJh.bun() + ", process.getRecorder():" + localObject1 + ", mute:" + this.nJh.aGe());
    Object localObject2 = this.nJi;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.nJj;
    if (localObject2 != null)
    {
      ((com.tencent.mm.media.widget.c.b)localObject2).cancel();
      ((com.tencent.mm.media.widget.c.b)localObject2).clear();
    }
    localObject2 = this.nJh.getEncodeConfig();
    if (localObject1 != null) {
      this.nJi = ((com.tencent.mm.media.widget.c.b)localObject1);
    }
    for (;;)
    {
      localObject1 = this.nJi;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(this.nJh.aGe());
      }
      localObject1 = this.nJj;
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.c.b)localObject1).setMute(true);
      }
      this.nJh.getCameraPreviewView().setOnDrawListener((kotlin.g.a.b)new b(this));
      Log.i("MicroMsg.CameraPreviewContainer", "create recorder finish");
      p("REPORT_CREATE_RECORDER", Long.valueOf(Util.ticksToNow(l)));
      AppMethodBeat.o(94238);
      return true;
      if (this.nJh.bun())
      {
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bqz();
        localObject1 = d.nJI;
        localObject1 = d.a(((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).buc(), this.nJh.getVideoTransPara(), this.mRu, this.nJh.getRecordRenderer());
        label327:
        this.nJi = ((com.tencent.mm.media.widget.c.b)localObject1);
        if (this.nJh.getEncodeConfig().buc() != 2) {
          break label604;
        }
        if (this.nJh.getVideoTransPara().oCm != 1) {
          break label598;
        }
      }
      label598:
      for (boolean bool = true;; bool = false)
      {
        bool = com.tencent.mm.plugin.sight.base.c.aP(false, bool);
        p("RecordMuxerType", Boolean.valueOf(bool));
        if ((!this.nJh.bup()) || (this.nJh.bun())) {
          break;
        }
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bqy();
        if (this.nJh.getCameraPreviewView().getEGLContext() != null) {
          break label640;
        }
        Log.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bqA();
        AppMethodBeat.o(94238);
        return false;
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bqy();
        if (this.nJh.getCameraPreviewView().getEGLContext() == null)
        {
          Log.e("MicroMsg.CameraPreviewContainer", "gpu crop, preview view egl context is null!!!");
          localObject1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.bqA();
          AppMethodBeat.o(94238);
          return false;
        }
        localObject1 = d.nJI;
        i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).buc();
        localObject1 = this.nJh.getVideoTransPara();
        localObject3 = this.mRu;
        EGLContext localEGLContext = this.nJh.getCameraPreviewView().getEGLContext();
        s.checkNotNull(localEGLContext);
        localObject1 = d.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.f)localObject3, localEGLContext, this.nJh.getCameraPreviewView(), this.nJh.getRecordRenderer());
        break label327;
      }
      label604:
      if (this.nJh.getVideoTransPara().oCn == 1) {}
      for (bool = true;; bool = false)
      {
        bool = com.tencent.mm.plugin.sight.base.c.aP(true, bool);
        break;
      }
      label640:
      localObject1 = d.nJI;
      int i = ((com.tencent.mm.media.widget.camerarecordview.b.a)localObject2).buc();
      localObject1 = this.nJh.getDaemonVideoTransPara();
      localObject2 = this.mRu;
      Object localObject3 = this.nJh.getCameraPreviewView().getEGLContext();
      s.checkNotNull(localObject3);
      this.nJj = d.a(i, (VideoTransPara)localObject1, (com.tencent.mm.media.widget.a.f)localObject2, (EGLContext)localObject3, this.nJh.getCameraPreviewView(), this.nJh.getRecordRenderer());
    }
  }
  
  private final void btZ()
  {
    com.tencent.mm.media.widget.c.b localb1 = null;
    AppMethodBeat.i(94240);
    com.tencent.mm.media.widget.c.b localb2 = this.nJi;
    if (localb2 != null) {
      localb2.A(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.bsM(), com.tencent.mm.media.widget.a.b.bsN());
    }
    if (localb2 != null) {
      localb2.setFilePath(this.nJh.getEncodeConfig().getFilePath());
    }
    if (localb2 != null) {
      localb2.Hd(this.nJh.getEncodeConfig().bud());
    }
    StringBuilder localStringBuilder = new StringBuilder("filePath : ");
    Object localObject;
    label134:
    label268:
    label292:
    int i;
    label325:
    boolean bool1;
    label338:
    boolean bool2;
    if (localb2 == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append("   thumbPath : ");
      if (localb2 != null) {
        break label415;
      }
      localObject = null;
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", localObject, new Object[0]);
      localb2 = this.nJj;
      if (localb2 != null) {
        localb2.A(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.bsM(), com.tencent.mm.media.widget.a.b.bsN());
      }
      if (localb2 != null) {
        localb2.setFilePath(s.X(this.nJh.getEncodeConfig().getFilePath(), "_daemon"));
      }
      if (localb2 != null) {
        localb2.Hd(s.X(this.nJh.getEncodeConfig().bud(), "_daemon"));
      }
      localStringBuilder = new StringBuilder("filePath : ");
      if (localb2 != null) {
        break label427;
      }
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append("   thumbPath : ");
      if (localb2 != null) {
        break label439;
      }
      localObject = localb1;
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", localObject, new Object[0]);
      localObject = com.tencent.mm.media.widget.a.c.nGn;
      if (!com.tencent.mm.media.widget.a.c.bsQ()) {
        break label451;
      }
      i = 0;
      localObject = this.nJi;
      if (localObject != null) {
        break label458;
      }
      bool1 = false;
      localObject = this.nJj;
      if (localObject != null) {
        break label470;
      }
      bool2 = false;
    }
    for (;;)
    {
      if (((this.nJj instanceof com.tencent.mm.media.widget.c.c)) && ((this.nJi instanceof com.tencent.mm.media.widget.c.c)))
      {
        localObject = this.nJj;
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
          AppMethodBeat.o(94240);
          throw ((Throwable)localObject);
          localObject = localb2.getFilePath();
          break;
          label415:
          localObject = localb2.bud();
          break label134;
          label427:
          localObject = localb2.getFilePath();
          break label268;
          label439:
          localObject = localb2.bud();
          break label292;
          label451:
          i = com.tencent.mm.media.widget.a.b.bsL();
          break label325;
          label458:
          bool1 = ((com.tencent.mm.media.widget.c.b)localObject).uw(i);
          break label338;
          label470:
          bool2 = ((com.tencent.mm.media.widget.c.b)localObject).uw(i);
          continue;
        }
        localObject = (com.tencent.mm.media.widget.c.c)localObject;
        localb1 = this.nJi;
        if (localb1 == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.MediaCodecMP4MuxRecorder");
          AppMethodBeat.o(94240);
          throw ((Throwable)localObject);
        }
        ((com.tencent.mm.media.widget.c.c)localObject).a(((com.tencent.mm.media.widget.c.c)localb1).buM());
      }
    }
    if (((this.nJj instanceof e)) && ((this.nJi instanceof e)))
    {
      localObject = this.nJj;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      localObject = (e)localObject;
      localb1 = this.nJi;
      if (localb1 == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.media.widget.recorder.X264YUVMP4MuxRecorder");
        AppMethodBeat.o(94240);
        throw ((Throwable)localObject);
      }
      ((e)localObject).a(((e)localb1).nMw);
    }
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "init recorder ret:" + bool1 + "  daemonRet:" + bool2, new Object[0]);
    this.nJq = bool1;
    AppMethodBeat.o(94240);
  }
  
  private final void p(String paramString, Object paramObject)
  {
    AppMethodBeat.i(237663);
    this.nJy.m(paramString, paramObject);
    AppMethodBeat.o(237663);
  }
  
  public final void G(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94247);
    s.u(paramString, "tag");
    this.mRu.G(paramString, paramBoolean);
    AppMethodBeat.o(94247);
  }
  
  public final boolean J(kotlin.g.a.b<? super com.tencent.mm.media.widget.camerarecordview.b.b, ah> paramb)
  {
    AppMethodBeat.i(94227);
    if (!this.nJm)
    {
      AppMethodBeat.o(94227);
      return true;
    }
    this.nJm = false;
    if (Util.ticksToNow(this.nJl) < this.nJr)
    {
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", s.X("stopRecord ", Long.valueOf(Util.ticksToNow(this.nJl))), new Object[0]);
      paramb = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bro();
      btV();
      AppMethodBeat.o(94227);
      return false;
    }
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "stopRecord start", new Object[0]);
    com.tencent.mm.media.util.a locala = new com.tencent.mm.media.util.a("stopRecord");
    ah.d locald = new ah.d();
    ah.f localf1 = new ah.f();
    localf1.aqH = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
    ah.f localf2 = new ah.f();
    localf2.aqH = new a..ExternalSyntheticLambda3(localf1, this, paramb);
    if (this.nJh.bup())
    {
      localObject = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.brp();
    }
    Object localObject = new ah.f();
    ((ah.f)localObject).aqH = this.nJi;
    com.tencent.mm.media.widget.c.b localb = this.nJi;
    if (localb != null) {
      localb.J(new a..ExternalSyntheticLambda2(this, (ah.f)localObject, locala, localf1, locald, localf2, paramb));
    }
    localObject = this.nJj;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.c.b)localObject).J(new a..ExternalSyntheticLambda1(this, locala, localf1, locald, localf2, paramb));
    }
    AppMethodBeat.o(94227);
    return true;
  }
  
  public final void K(kotlin.g.a.b<? super byte[], ah> paramb)
  {
    AppMethodBeat.i(94239);
    s.u(paramb, "callback");
    this.mRu.bsF();
    this.mRu.a(new a..ExternalSyntheticLambda0(paramb));
    AppMethodBeat.o(94239);
  }
  
  public final void L(final kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(94246);
    s.u(paramb, "callback");
    if (!this.mRu.bsD())
    {
      Log.e("MicroMsg.CameraPreviewContainer", "camera.isCameraPreviewing : false");
      paramb.invoke(null);
      AppMethodBeat.o(94246);
      return;
    }
    if ((com.tencent.mm.media.widget.d.c.b(this.nJh)) && (!com.tencent.mm.media.widget.d.c.uz(this.nJh.getRecordScene())))
    {
      l = Util.currentTicks();
      this.mRu.H((kotlin.g.a.b)new d(this, l, paramb));
      AppMethodBeat.o(94246);
      return;
    }
    final long l = Util.currentTicks();
    com.tencent.mm.media.j.a locala = this.nBj;
    if (locala != null)
    {
      locala.G((kotlin.g.a.b)new e(this, paramb, l));
      locala.bpM();
    }
    AppMethodBeat.o(94246);
  }
  
  public final void a(boolean paramBoolean, final Float paramFloat, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(237751);
    long l = Util.currentTicks();
    p("OpenCameraTimeStamp", Long.valueOf(l));
    if (this.currentState == 0)
    {
      Log.e("MicroMsg.CameraPreviewContainer", "startPreview, already in preview state");
      AppMethodBeat.o(237751);
      return;
    }
    this.currentState = 0;
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", s.X("startPreview process.useCpuCrop():", Boolean.valueOf(this.nJh.bun())), new Object[0]);
    this.nJk = paramBoolean;
    if ((!this.nJk) && (!com.tencent.mm.media.widget.d.c.bod()))
    {
      this.nJk = true;
      Log.i("MicroMsg.CameraPreviewContainer", "force useBackGroundCamera");
    }
    if ((this.nJk) && (!com.tencent.mm.media.widget.d.c.boe()))
    {
      this.nJk = false;
      Log.i("MicroMsg.CameraPreviewContainer", "force useFrontGroundCamera");
    }
    this.mRu.A(this.nJh.getContext(), this.nJk);
    if (this.nJh.bun()) {
      this.mRu.a(this.nJh.getCameraPreviewView().getFrameDataCallback());
    }
    p("CameraOpenCost", Long.valueOf(Util.ticksToNow(l)));
    this.nJh.getCameraPreviewView().t((kotlin.g.a.b)new c(this, paramFloat, paramb));
    AppMethodBeat.o(237751);
  }
  
  public final void auq()
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
      this.mRu.release();
      this.mRu.b(this.nJh.getCameraPreviewView().getFrameDataCallback());
      this.nJh.getCameraPreviewView().bgw();
      if (!this.nJu) {
        this.nJs.a(false, null);
      }
      AppMethodBeat.o(94245);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, s.X("camera relase error:", localException.getMessage()), new Object[0]);
      }
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94228);
    if (this.currentState == 0) {
      this.mRu.b(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(94228);
  }
  
  public final void btV()
  {
    AppMethodBeat.i(94226);
    try
    {
      Log.i("MicroMsg.CameraPreviewContainer", "cancelRecord");
      com.tencent.mm.media.widget.c.b localb = this.nJi;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.nJi;
      if (localb != null) {
        localb.clear();
      }
      localb = this.nJj;
      if (localb != null) {
        localb.cancel();
      }
      localb = this.nJj;
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
    if (this.mRu.bsD())
    {
      btY();
      if (this.mRu.btc() != null) {
        btZ();
      }
    }
    AppMethodBeat.o(94226);
  }
  
  public final int btX()
  {
    AppMethodBeat.i(94236);
    int i = this.mRu.boh();
    AppMethodBeat.o(94236);
    return i;
  }
  
  public final void btb()
  {
    AppMethodBeat.i(94229);
    if (this.currentState == 0) {
      this.mRu.btb();
    }
    AppMethodBeat.o(94229);
  }
  
  public final boolean gF(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(94233);
    if (!com.tencent.mm.media.widget.d.c.btW())
    {
      Log.i("MicroMsg.CameraPreviewContainer", "only one camera,forbid switch");
      if (!com.tencent.mm.media.widget.d.c.bod())
      {
        AppMethodBeat.o(94233);
        return true;
      }
      AppMethodBeat.o(94233);
      return false;
    }
    Log.i("MicroMsg.CameraPreviewContainer", s.X("flipCamera time space:", Long.valueOf(Util.ticksToNow(this.nJp))));
    if ((!paramBoolean) && (Util.ticksToNow(this.nJp) < 1000L))
    {
      paramBoolean = this.nJk;
      AppMethodBeat.o(94233);
      return paramBoolean;
    }
    this.nJp = Util.currentTicks();
    if (this.nJm)
    {
      localObject = this.nJi;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
      localObject = this.nJj;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).pause();
      }
    }
    this.nJh.getCameraPreviewView().bgx();
    this.nJk = this.mRu.bsC();
    Object localObject = this.mRu.btc();
    if (!this.nJu)
    {
      com.tencent.mm.media.widget.camerarecordview.c.a locala = this.nJs;
      if ((!this.nJk) && (this.nJh.buo()))
      {
        paramBoolean = true;
        locala.a(paramBoolean, (com.tencent.mm.media.widget.a.b)localObject);
      }
    }
    else if (localObject != null)
    {
      this.nJh.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
      localObject = com.tencent.mm.media.widget.a.c.nGn;
      if (!com.tencent.mm.media.widget.a.c.bsQ())
      {
        localObject = d.nJI;
        localObject = d.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.j.a)localObject).el(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
        }
        localObject = d.nJI;
        localObject = d.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.j.a)localObject).th(com.tencent.mm.media.widget.a.b.bsL());
        }
        localObject = d.nJI;
        localObject = d.getRenderer();
        if (localObject != null) {
          ((com.tencent.mm.media.j.a)localObject).fQ(com.tencent.mm.media.widget.a.b.isFrontCamera());
        }
        localObject = this.nJi;
        if (localObject != null) {
          if ((!com.tencent.mm.media.widget.a.b.isFrontCamera()) || (!this.nJw)) {
            break label488;
          }
        }
      }
    }
    label488:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((com.tencent.mm.media.widget.c.b)localObject).setMirror(paramBoolean);
      localObject = this.nJj;
      if (localObject != null)
      {
        paramBoolean = bool;
        if (com.tencent.mm.media.widget.a.b.isFrontCamera())
        {
          paramBoolean = bool;
          if (this.nJw) {
            paramBoolean = true;
          }
        }
        ((com.tencent.mm.media.widget.c.b)localObject).setMirror(paramBoolean);
      }
      localObject = this.nJi;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).A(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.bsM(), com.tencent.mm.media.widget.a.b.bsN());
      }
      localObject = this.nJj;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).A(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.bsM(), com.tencent.mm.media.widget.a.b.bsN());
      }
      if (this.nJm)
      {
        this.nJo = new kotlin.u(Integer.valueOf(com.tencent.mm.media.widget.a.b.bsL()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewWidth()), Integer.valueOf(com.tencent.mm.media.widget.a.b.getPreviewHeight()));
        this.nJn = true;
      }
      paramBoolean = this.nJk;
      AppMethodBeat.o(94233);
      return paramBoolean;
      paramBoolean = false;
      break;
    }
  }
  
  public final Point gG(boolean paramBoolean)
  {
    AppMethodBeat.i(94243);
    Point localPoint = this.mRu.gx(paramBoolean);
    AppMethodBeat.o(94243);
    return localPoint;
  }
  
  public final void gH(boolean paramBoolean)
  {
    AppMethodBeat.i(94248);
    this.mRu.gy(paramBoolean);
    AppMethodBeat.o(94248);
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94231);
    if (this.currentState == 0) {
      this.mRu.h(paramBoolean, paramInt);
    }
    AppMethodBeat.o(94231);
  }
  
  public final boolean i(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94224);
    Log.printInfoStack("MicroMsg.CameraPreviewContainer", "startRecord", new Object[0]);
    Object localObject2;
    boolean bool;
    int i;
    label114:
    com.tencent.mm.media.widget.c.b localb;
    if ((this.mRu.btc() != null) && (this.nJi != null))
    {
      if (!this.nJq)
      {
        Log.i("MicroMsg.CameraPreviewContainer", "startRecord, initRecorder failed");
        AppMethodBeat.o(94224);
        return false;
      }
      localObject2 = this.nJi;
      if (localObject2 != null)
      {
        if ((com.tencent.mm.media.widget.a.b.isFrontCamera()) && (this.nJw))
        {
          bool = true;
          ((com.tencent.mm.media.widget.c.b)localObject2).setMirror(bool);
        }
      }
      else
      {
        localObject2 = com.tencent.mm.media.widget.a.c.nGn;
        if (!com.tencent.mm.media.widget.a.c.bsQ()) {
          break label225;
        }
        i = 0;
        localObject2 = this.nJi;
        if (localObject2 != null) {
          break label232;
        }
        localObject2 = null;
        label128:
        Log.i("MicroMsg.CameraPreviewContainer", s.X("start record ret:", localObject2));
        if (!this.nJh.bup()) {
          break label400;
        }
        localb = this.nJj;
        if (localb != null)
        {
          if ((!com.tencent.mm.media.widget.a.b.isFrontCamera()) || (!this.nJw)) {
            break label250;
          }
          bool = true;
          label181:
          localb.setMirror(bool);
        }
        localb = this.nJj;
        if (localb != null) {
          break label256;
        }
      }
    }
    for (;;)
    {
      label201:
      if (localObject2 == null) {
        label206:
        if (localObject1 != null) {
          break label368;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(94224);
        return false;
        bool = false;
        break;
        label225:
        i = com.tencent.mm.media.widget.a.b.bsL();
        break label114;
        label232:
        localObject2 = Integer.valueOf(((com.tencent.mm.media.widget.c.b)localObject2).b(i, paramBoolean, paramInt));
        break label128;
        label250:
        bool = false;
        break label181;
        label256:
        localObject1 = Integer.valueOf(localb.b(i, paramBoolean, paramInt));
        break label201;
        if (((Integer)localObject2).intValue() != 0) {
          break label206;
        }
        label368:
        do
        {
          Log.i("MicroMsg.CameraPreviewContainer", "start record base ret:" + localObject2 + " daemon ret:" + localObject1 + " ,use daemon record:" + this.nJh.bup());
          this.nJl = Util.currentTicks();
          this.nJm = true;
          this.nJt = false;
          localObject1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.brn();
          AppMethodBeat.o(94224);
          return true;
        } while (((Integer)localObject1).intValue() == 0);
      }
      Log.printInfoStack("MicroMsg.CameraPreviewContainer", "cameraConfig is null", new Object[0]);
      AppMethodBeat.o(94224);
      return false;
      label400:
      localObject1 = Integer.valueOf(-1);
    }
  }
  
  public final void ij(long paramLong)
  {
    AppMethodBeat.i(94232);
    Log.i("MicroMsg.CameraPreviewContainer", s.X("setRecordMiniTime:", Long.valueOf(paramLong)));
    this.nJr = paramLong;
    AppMethodBeat.o(94232);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94237);
    try
    {
      Log.i("MicroMsg.CameraPreviewContainer", "release");
      this.mRu.onDestroy();
      this.mRu.release();
      Object localObject = this.nJs;
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).nKi.disable();
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject).context = null;
      localObject = d.nJI;
      d.bua();
      this.nJh.getCameraPreviewView().release();
      localObject = this.nJi;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.nJi;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      localObject = this.nJj;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
      localObject = this.nJj;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).clear();
      }
      this.nBj = null;
      AppMethodBeat.o(94237);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, s.X("camera release error:", localException.getMessage()), new Object[0]);
      }
    }
  }
  
  public final void ut(int paramInt)
  {
    AppMethodBeat.i(94230);
    if (this.currentState == 0) {
      this.mRu.up(paramInt);
    }
    AppMethodBeat.o(94230);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.media.g.d, ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<SurfaceTexture, ah>
  {
    c(a parama, Float paramFloat, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
    
    private static final void a(a parama, SurfaceTexture paramSurfaceTexture, Float paramFloat, kotlin.g.a.b paramb)
    {
      AppMethodBeat.i(237652);
      s.u(parama, "this$0");
      a.a(parama, Util.currentTicks());
      a.a(parama, "StartPreviewTimeStamp", Long.valueOf(a.j(parama)));
      a.k(parama).a(paramSurfaceTexture, parama.nJh.bun(), paramFloat, parama.nJh.getResolutionLimit());
      if ((!a.k(parama).bsD()) && (!parama.nJh.bun()))
      {
        paramSurfaceTexture = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bqA();
      }
      if (paramb != null) {
        paramb.invoke(Boolean.valueOf(a.k(parama).bsD()));
      }
      a.l(parama);
      AppMethodBeat.o(237652);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    d(a parama, long paramLong, kotlin.g.a.b<? super Bitmap, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/nio/IntBuffer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IntBuffer, ah>
  {
    e(a parama, kotlin.g.a.b<? super Bitmap, ah> paramb, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a
 * JD-Core Version:    0.7.0.1
 */