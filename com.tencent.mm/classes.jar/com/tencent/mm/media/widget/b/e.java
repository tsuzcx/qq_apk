package com.tencent.mm.media.widget.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.ImageReader;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Range;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.media.widget.a.a.a;
import com.tencent.mm.media.widget.b.a.a.b.a;
import com.tencent.mm.media.widget.b.a.c.a;
import com.tencent.mm.media.widget.b.a.c.b;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import d.a.j;
import d.v;
import d.y;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "useBack", "", "(Landroid/content/Context;Z)V", "DEFAULT_UPPER_BOUND", "", "FOCUS_TAG", "", "FOCUS_TAG$1", "SMALL_ZOOM_STEP_NUM", "getSMALL_ZOOM_STEP_NUM", "()I", "SMALL_ZOOM_STEP_NUM$1", "SMALL_ZOOM_STEP_UPPER_BOUND", "getSMALL_ZOOM_STEP_UPPER_BOUND", "SMALL_ZOOM_STEP_UPPER_BOUND$1", "SMALL_ZOOM_STEP_VAL", "", "TAG", "TAG$1", "autoFocusRunnable", "com/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1;", "cropSize", "Landroid/graphics/Point;", "imageReader", "Landroid/media/ImageReader;", "isCameraOpen", "isUseRecordStream", "isZooming", "mCameraDevice", "Landroid/hardware/camera2/CameraDevice;", "mCameraDeviceCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1;", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "mCameraOpenCloseLock", "Ljava/util/concurrent/Semaphore;", "mCaptureCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1;", "mCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "mCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "mFpsValuev", "getMFpsValuev", "setMFpsValuev", "(I)V", "mIsNoAFRun", "mIsSessionClose", "mPreviewBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "mPreviewSize", "Landroid/util/Size;", "mStateCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1;", "mSurface", "Landroid/view/Surface;", "mZoomTimesToRatio", "", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "previewRequest", "Landroid/hardware/camera2/CaptureRequest;", "scrollSmallZoomStep", "sightHandler", "Lcom/tencent/mm/media/widget/camera2/Camera2Handler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera2/Camera2Handler;", "smallZoomStep", "state", "zoomOutRect", "Landroid/graphics/Rect;", "abandonFocus", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateTapArea", "x", "y", "surfaceWidth", "surfaceHeight", "captureStillPicture", "clamp", "min", "max", "closeCamera", "configVendorTagValue", "tag", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraOrientation", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "getPreviewWidth", "getSupportZoomRatios", "initCamera", "initRawRatios", "lock3AParams", "builder", "lockFocus", "onDestroy", "openCamera", "nowCameraId", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "resumePreview", "runPrecaptureSequence", "safeResetZoom", "safeSetFocusMode", "characteristics", "safeSetMetering", "safeSetOIS", "safeSetPreviewFrameRate", "useFixMode", "safeSetStabilization", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "safeSetVendorEffect", "selectNoCropPreviewSize", "resolutionLimit", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setSafeConfig", "startPreview", "useCpuCrop", "surface", "startPreviewWithGPU", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "trySetPreviewFrameRateParameters", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends com.tencent.mm.media.widget.a.a
{
  public static final e.a gZA;
  private static final SparseIntArray gZz;
  private boolean aNN;
  private final String fOO;
  private ImageReader fZK;
  private Point gXK;
  private int gXL;
  private boolean gXU;
  private final int gXV;
  private d.g.a.b<? super Boolean, y> gXY;
  private CameraManager gYz;
  private final String gZc;
  private final int gZd;
  private final int gZe;
  private final float gZf;
  private Size gZg;
  final a gZh;
  private float gZi;
  private final Semaphore gZj;
  private CameraDevice gZk;
  private CaptureRequest.Builder gZl;
  private CameraCaptureSession gZm;
  private CaptureRequest gZn;
  private CameraCharacteristics gZo;
  private boolean gZp;
  private boolean gZq;
  private Rect gZr;
  private boolean gZs;
  private float[] gZt;
  private final f gZu;
  private final d gZv;
  private final e gZw;
  private final b gZx;
  private int gZy;
  private Surface mSurface;
  private int state;
  
  static
  {
    AppMethodBeat.i(94168);
    gZA = new e.a((byte)0);
    SparseIntArray localSparseIntArray = new SparseIntArray();
    gZz = localSparseIntArray;
    localSparseIntArray.append(0, 90);
    gZz.append(1, 0);
    gZz.append(2, 270);
    gZz.append(3, 180);
    AppMethodBeat.o(94168);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94167);
    this.fOO = "MicroMsg.CommonCamera2";
    this.gZc = "MicroMsg.CommonCamera2.FoucsTag";
    this.gZd = 5;
    this.gZe = 20;
    this.gZf = 0.1F;
    Object localObject = Looper.getMainLooper();
    d.g.b.k.g(localObject, "Looper.getMainLooper()");
    this.gZh = new a((Looper)localObject, paramContext);
    this.gXL = -1;
    this.gZi = -1.0F;
    this.gXV = 2100;
    this.gZj = new Semaphore(1);
    if (com.tencent.mm.media.widget.d.a.avA())
    {
      paramContext = new com.tencent.mm.media.widget.b.a.c(paramContext);
      localObject = (d.g.a.q)e.1.gZB;
      d.g.b.k.h(localObject, "mSupportWCKeyAvailable");
      new Thread((Runnable)new c.a(paramContext, (d.g.a.a)new c.b(paramContext, (d.g.a.q)localObject))).start();
      paramContext = d.gZb;
      d.auf();
    }
    this.gZu = new f(this);
    this.gZv = new d(this);
    this.gZw = new e(this);
    this.gZx = new b(this);
    AppMethodBeat.o(94167);
  }
  
  private final void a(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94148);
    if (ae.fJd.fET > 0)
    {
      ac.i(this.gWT, "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(94148);
      return;
    }
    if (paramCameraCharacteristics != null)
    {
      paramCameraCharacteristics = (Range[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
      if (paramCameraCharacteristics != null) {
        if (paramCameraCharacteristics.length != 0) {
          break label74;
        }
      }
    }
    label74:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label79;
      }
      AppMethodBeat.o(94148);
      return;
      paramCameraCharacteristics = null;
      break;
    }
    label79:
    int j = -2147483648;
    int k = -2147483648;
    i = 0;
    int i1 = paramCameraCharacteristics.length;
    int m = 0;
    Integer localInteger2;
    int n;
    label264:
    if (m < i1)
    {
      localInteger2 = paramCameraCharacteristics[m];
      if (localInteger2 == null)
      {
        n = k;
        k = j;
      }
      Integer localInteger1;
      for (j = n;; j = n)
      {
        n = m + 1;
        m = k;
        k = j;
        j = m;
        m = n;
        break;
        localInteger1 = (Integer)localInteger2.getLower();
        localInteger2 = (Integer)localInteger2.getUpper();
        ac.i(this.fOO, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(m), localInteger1, localInteger2 });
        if (d.g.b.k.compare(localInteger1.intValue(), 0) >= 0)
        {
          n = localInteger2.intValue();
          d.g.b.k.g(localInteger1, "min");
          if (d.g.b.k.compare(n, localInteger1.intValue()) >= 0) {
            break label253;
          }
        }
        n = k;
        k = j;
      }
      label253:
      if (this.gZy == 0)
      {
        n = 30;
        if ((d.g.b.k.compare(localInteger2.intValue(), k) < 0) || (i != 0) || (d.g.b.k.compare(localInteger2.intValue(), n) > 0)) {
          break label554;
        }
        k = localInteger1.intValue();
        d.g.b.k.g(localInteger2, "max");
        j = localInteger2.intValue();
      }
    }
    for (;;)
    {
      if (this.gZy != 0)
      {
        n = this.gZy;
        if (localInteger2 == null)
        {
          break;
          n = this.gZy;
          break label264;
        }
        if (localInteger2.intValue() != n) {
          break label551;
        }
        i = 1;
        break;
      }
      if (localInteger2 == null) {
        break;
      }
      if (localInteger2.intValue() == 30)
      {
        i = 1;
        break;
        ac.i(this.gWT, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(30) });
        if ((j == 2147483647) || (k == 2147483647))
        {
          AppMethodBeat.o(94148);
          return;
        }
        try
        {
          paramCameraCharacteristics = this.gZl;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range((Comparable)Integer.valueOf(j), (Comparable)Integer.valueOf(k)));
          }
          ac.i(this.gWT, "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          AppMethodBeat.o(94148);
          return;
        }
        catch (Exception paramCameraCharacteristics)
        {
          ac.i(this.gWT, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
          AppMethodBeat.o(94148);
          return;
        }
      }
      label551:
      break;
      label554:
      n = j;
      j = k;
      k = n;
    }
  }
  
  private final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    Object localObject1 = null;
    Surface localSurface = null;
    AppMethodBeat.i(94135);
    Object localObject2 = this.gZl;
    if (localObject2 != null)
    {
      if ((paramSurfaceTexture != null) || (paramSurfaceHolder != null))
      {
        int j;
        int i;
        if (paramSurfaceTexture != null)
        {
          this.mSurface = new Surface(paramSurfaceTexture);
          ((CaptureRequest.Builder)localObject2).addTarget(this.mSurface);
          paramSurfaceTexture = d.gZb;
          if (!d.aui()) {
            break label456;
          }
          if (!this.gZp) {
            break label279;
          }
          paramSurfaceTexture = d.gZb;
          paramSurfaceTexture = this.gZl;
          if (paramSurfaceTexture == null) {
            d.g.b.k.fOy();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.haF;
          j = d.a(paramSurfaceTexture, j.listOf(com.tencent.mm.media.widget.b.a.a.b.auC()));
          i = j;
          if (Build.VERSION.SDK_INT < 28) {
            break label445;
          }
          paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration(this.mSurface)), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.gZu);
          paramSurfaceHolder = this.gZk;
          if (paramSurfaceHolder == null) {
            d.g.b.k.fOy();
          }
          paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
          if (j == 0)
          {
            paramSurfaceHolder = this.gZk;
            if (paramSurfaceHolder == null) {
              d.g.b.k.fOy();
            }
            localObject1 = this.mSurface;
            localObject2 = this.fZK;
            paramSurfaceTexture = localSurface;
            if (localObject2 != null) {
              paramSurfaceTexture = ((ImageReader)localObject2).getSurface();
            }
            paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localObject1, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.gZu, this.gZh.gYl);
          }
        }
        for (;;)
        {
          ac.i(this.fOO, "doStartPreview finish");
          AppMethodBeat.o(94135);
          return true;
          if (paramSurfaceHolder == null) {
            break;
          }
          this.mSurface = paramSurfaceHolder.getSurface();
          break;
          label279:
          paramSurfaceTexture = d.gZb;
          paramSurfaceTexture = this.gZl;
          if (paramSurfaceTexture == null) {
            d.g.b.k.fOy();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.haF;
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.auB();
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.haF;
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.auA();
          localObject2 = com.tencent.mm.media.widget.b.a.a.b.haF;
          j = d.a(paramSurfaceTexture, j.listOf(new String[] { paramSurfaceHolder, localObject1, com.tencent.mm.media.widget.b.a.a.b.auD() }));
          i = j;
          if (Build.VERSION.SDK_INT >= 28)
          {
            paramSurfaceHolder = new OutputConfiguration(this.mSurface);
            paramSurfaceTexture = this.fZK;
            if (paramSurfaceTexture == null) {
              break label451;
            }
          }
          label445:
          label451:
          for (paramSurfaceTexture = paramSurfaceTexture.getSurface();; paramSurfaceTexture = null)
          {
            paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration[] { paramSurfaceHolder, new OutputConfiguration(paramSurfaceTexture) }), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.gZu);
            paramSurfaceHolder = this.gZk;
            if (paramSurfaceHolder == null) {
              d.g.b.k.fOy();
            }
            paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
            i = j;
            j = i;
            break;
          }
          label456:
          paramSurfaceHolder = this.gZk;
          if (paramSurfaceHolder == null) {
            d.g.b.k.fOy();
          }
          localSurface = this.mSurface;
          localObject2 = this.fZK;
          paramSurfaceTexture = (SurfaceTexture)localObject1;
          if (localObject2 != null) {
            paramSurfaceTexture = ((ImageReader)localObject2).getSurface();
          }
          paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localSurface, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.gZu, this.gZh.gYl);
        }
      }
      ac.i(this.fOO, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.arx();
      paramSurfaceTexture = c.gYy;
      c.atH();
      AppMethodBeat.o(94135);
      return false;
    }
    AppMethodBeat.o(94135);
    return false;
  }
  
  private final boolean a(CameraCharacteristics paramCameraCharacteristics, boolean paramBoolean)
  {
    AppMethodBeat.i(94147);
    if (paramCameraCharacteristics == null)
    {
      AppMethodBeat.o(94147);
      return false;
    }
    if (paramBoolean) {
      try
      {
        if (ae.fJd.fET > 0) {
          ac.i(this.gWT, "set frame rate > 0, do not try set preview frame rate");
        }
        for (;;)
        {
          paramCameraCharacteristics = this.gZl;
          if (paramCameraCharacteristics != null)
          {
            paramCameraCharacteristics = (Range)paramCameraCharacteristics.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
            label61:
            ac.i(this.gWT, "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), paramCameraCharacteristics });
            AppMethodBeat.o(94147);
            return true;
            if (paramCameraCharacteristics == null)
            {
              ac.e(this.fOO, "trySetPreviewFrameRateParameters error, p is null!");
              continue;
            }
            try
            {
              paramCameraCharacteristics = (Range[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
              d.g.b.k.g(paramCameraCharacteristics, "fpsList");
              k = paramCameraCharacteristics.length;
              j = 0;
              i = 0;
              if (j < k)
              {
                localObject = paramCameraCharacteristics[j];
                d.g.b.k.g(localObject, "it");
                localComparable = ((Range)localObject).getUpper();
                d.g.b.k.g(localComparable, "it.upper");
                if (d.g.b.k.compare(i, ((Number)localComparable).intValue()) < 0)
                {
                  localObject = ((Range)localObject).getUpper();
                  d.g.b.k.g(localObject, "it.upper");
                  i = ((Number)localObject).intValue();
                }
              }
              else if (this.gZy == 0)
              {
                i = Math.min(30, i);
                paramCameraCharacteristics = new Range((Comparable)Integer.valueOf(i), (Comparable)Integer.valueOf(i));
                localObject = this.gZl;
                if (localObject == null) {
                  continue;
                }
                ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, paramCameraCharacteristics);
              }
            }
            catch (Exception paramCameraCharacteristics)
            {
              ac.i(this.gWT, "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
            }
          }
        }
      }
      catch (Exception paramCameraCharacteristics)
      {
        ac.i(this.gWT, "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(94147);
        return false;
      }
    }
    for (;;)
    {
      int k;
      int j;
      Object localObject;
      Comparable localComparable;
      break;
      int i = Math.min(this.gZy, i);
      continue;
      a(paramCameraCharacteristics);
      break;
      paramCameraCharacteristics = null;
      break label61;
      j += 1;
    }
  }
  
  private final void atw()
  {
    AppMethodBeat.i(94136);
    Integer localInteger = Integer.valueOf(0);
    Object localObject = com.tencent.mm.plugin.mmsight.model.a.k.ddS();
    d.g.b.k.g(localObject, "MMSightController.getInstance()");
    if (((com.tencent.mm.plugin.mmsight.model.a.k)localObject).ddT() != null)
    {
      localObject = com.tencent.mm.plugin.mmsight.model.a.k.ddS();
      d.g.b.k.g(localObject, "MMSightController.getInstance()");
      localInteger = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.a.k)localObject).ddT().uJG);
    }
    String str = this.fOO;
    boolean bool1;
    label92:
    boolean bool2;
    label104:
    boolean bool3;
    label116:
    boolean bool4;
    if (ae.fJd.fEY == 1)
    {
      localObject = "Range";
      if (ae.fJd.fEZ != 1) {
        break label399;
      }
      bool1 = true;
      if (ae.fJd.fFa != 1) {
        break label404;
      }
      bool2 = true;
      if (ae.fJd.fFb != 1) {
        break label409;
      }
      bool3 = true;
      if (ae.fJd.fFc != 1) {
        break label414;
      }
      bool4 = true;
      label129:
      ac.i(str, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if ((ae.fJd.fEY != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 1))) {
        break label420;
      }
      a(this.gZo, false);
    }
    for (;;)
    {
      if ((ae.fJd.fEZ == 1) && (localInteger.intValue() != 0)) {
        localInteger.intValue();
      }
      if ((ae.fJk.fHR != -1) && (ae.fJk.fHR == 1) && (com.tencent.mm.compatible.util.d.lb(14))) {
        c(this.gZo);
      }
      if ((ae.fJd.fFb == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
        b(this.gZo);
      }
      if ((ae.fJd.fFc == 1) && (localInteger.intValue() != 0)) {
        localInteger.intValue();
      }
      atz();
      aul();
      localObject = this.gZl;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      h((CaptureRequest.Builder)localObject);
      AppMethodBeat.o(94136);
      return;
      if (ae.fJd.fEX == 1)
      {
        localObject = "Fix";
        break;
      }
      localObject = "Error";
      break;
      label399:
      bool1 = false;
      break label92;
      label404:
      bool2 = false;
      break label104;
      label409:
      bool3 = false;
      break label116;
      label414:
      bool4 = false;
      break label129;
      label420:
      if ((ae.fJd.fEX == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 5))) {
        a(this.gZo, true);
      }
    }
  }
  
  private void atz()
  {
    AppMethodBeat.i(94150);
    Object localObject = this.gZo;
    if (localObject != null) {
      localObject = (Rect)((CameraCharacteristics)localObject).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }
    while (localObject != null)
    {
      localObject = new Rect(((Rect)localObject).left * 1, ((Rect)localObject).top * 1, ((Rect)localObject).right * 1, ((Rect)localObject).bottom * 1);
      CaptureRequest.Builder localBuilder = this.gZl;
      if (localBuilder != null)
      {
        localBuilder.set(CaptureRequest.SCALER_CROP_REGION, localObject);
        AppMethodBeat.o(94150);
        return;
        localObject = null;
      }
      else
      {
        AppMethodBeat.o(94150);
        return;
      }
    }
    AppMethodBeat.o(94150);
  }
  
  private final void auj()
  {
    AppMethodBeat.i(94129);
    try
    {
      if (this.gZl != null)
      {
        localObject1 = d.gZb;
        localObject1 = this.gZl;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        d.g((CaptureRequest.Builder)localObject1);
      }
      this.gZj.acquire();
      Object localObject1 = this.gZm;
      if (localObject1 != null) {
        ((CameraCaptureSession)localObject1).close();
      }
      this.gZm = null;
      localObject1 = this.gZk;
      if (localObject1 != null) {
        ((CameraDevice)localObject1).close();
      }
      this.gZk = null;
      localObject1 = this.fZK;
      if (localObject1 != null) {
        ((ImageReader)localObject1).setOnImageAvailableListener(null, this.gZh.gYl);
      }
      localObject1 = this.fZK;
      if (localObject1 != null) {
        ((ImageReader)localObject1).close();
      }
      this.fZK = null;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Throwable localThrowable = (Throwable)new RuntimeException("Interrupt while trying to lock camera closing", (Throwable)localInterruptedException);
      AppMethodBeat.o(94129);
      throw localThrowable;
    }
    finally
    {
      this.gZj.release();
      AppMethodBeat.o(94129);
    }
  }
  
  private final void auk()
  {
    Object localObject2 = null;
    AppMethodBeat.i(94134);
    try
    {
      if (this.state == 4)
      {
        ac.m(this.fOO, "capture still picture more than twice", new Object[0]);
        AppMethodBeat.o(94134);
        return;
      }
      this.state = 4;
      ac.i(this.fOO, "captureStillPicture");
      if (this.gZk == null)
      {
        AppMethodBeat.o(94134);
        return;
      }
    }
    catch (Exception localException)
    {
      localObject2 = d.gZb;
      if (!d.aub())
      {
        localObject2 = c.gYy;
        c.atM();
      }
      ac.e(this.fOO, localException.toString());
      AppMethodBeat.o(94134);
      return;
    }
    Object localObject1 = this.gZl;
    Object localObject3;
    label190:
    label255:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
      if ((this.gZk == null) || (this.gZs))
      {
        AppMethodBeat.o(94134);
        return;
      }
      localObject3 = this.gZk;
      if (localObject3 != null)
      {
        localObject3 = ((CameraDevice)localObject3).createCaptureRequest(2);
        if (localObject3 != null)
        {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
          localObject1 = this.fZK;
          if (localObject1 == null) {
            break label531;
          }
          localObject1 = ((ImageReader)localObject1).getSurface();
          ((CaptureRequest.Builder)localObject3).addTarget((Surface)localObject1);
          localObject1 = this.fZK;
          if (localObject1 != null) {
            ((ImageReader)localObject1).setOnImageAvailableListener(this.gZh.gYp, this.gZh.gYl);
          }
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
          localObject1 = this.gZo;
          if (localObject1 == null) {
            break label536;
          }
          localObject1 = (Float)((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
          if (localObject1 == null) {
            break label526;
          }
          if (!d.g.b.k.a((Float)localObject1)) {
            break label541;
          }
          break label526;
          label269:
          this.gZq = bool;
          if (!this.gZq)
          {
            localObject1 = this.gZo;
            if (localObject1 == null) {
              break label546;
            }
          }
        }
      }
    }
    label514:
    label526:
    label531:
    label536:
    label541:
    label546:
    for (localObject1 = (int[])((CameraCharacteristics)localObject1).get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);; localObject1 = null)
    {
      if (com.tencent.mm.compatible.loader.a.contains((int[])localObject1, 4))
      {
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
        localObject1 = this.gZo;
        if (localObject1 == null) {
          break label504;
        }
        localObject1 = (int[])((CameraCharacteristics)localObject1).get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        label353:
        if (com.tencent.mm.compatible.loader.a.contains((int[])localObject1, 1)) {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(1));
        }
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        h((CaptureRequest.Builder)localObject3);
      }
      for (localObject1 = localObject3;; localObject1 = null)
      {
        this.gZl = ((CaptureRequest.Builder)localObject1);
        localObject3 = this.gZm;
        if (localObject3 == null) {
          break label514;
        }
        ((CameraCaptureSession)localObject3).stopRepeating();
        ac.i(this.gZc, "this time happened a cancel auto foucs while capture");
        localObject1 = this.gZl;
        if (localObject1 != null) {
          ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
        }
        CaptureRequest.Builder localBuilder = this.gZl;
        localObject1 = localObject2;
        if (localBuilder != null) {
          localObject1 = localBuilder.build();
        }
        ((CameraCaptureSession)localObject3).capture((CaptureRequest)localObject1, (CameraCaptureSession.CaptureCallback)new c(this), null);
        AppMethodBeat.o(94134);
        return;
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        break;
        label504:
        localObject1 = null;
        break label353;
      }
      AppMethodBeat.o(94134);
      return;
      localObject1 = null;
      break;
      bool = true;
      break label269;
      localObject1 = null;
      break label190;
      localObject1 = null;
      break label255;
      bool = false;
      break label269;
    }
  }
  
  private final void aul()
  {
    AppMethodBeat.i(94151);
    Object localObject = this.gZo;
    if (localObject != null)
    {
      localObject = (int[])((CameraCharacteristics)localObject).get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
      if (localObject == null) {
        break label146;
      }
      ac.i(this.fOO, "oisMode:" + Arrays.toString((int[])localObject));
      if (localObject.length != 0) {
        break label129;
      }
      i = 1;
      label64:
      if (i != 0) {
        break label134;
      }
    }
    label129:
    label134:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!d.a.e.contains((int[])localObject, 1))) {
        break label139;
      }
      localObject = c.gYy;
      c.atN();
      localObject = d.gZb;
      d.el(false);
      localObject = this.gZl;
      if (localObject == null) {
        break label139;
      }
      ((CaptureRequest.Builder)localObject).set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(1));
      AppMethodBeat.o(94151);
      return;
      localObject = null;
      break;
      i = 0;
      break label64;
    }
    label139:
    AppMethodBeat.o(94151);
    return;
    label146:
    AppMethodBeat.o(94151);
  }
  
  private final void aum()
  {
    AppMethodBeat.i(94161);
    if (this.gZl == null)
    {
      AppMethodBeat.o(94161);
      return;
    }
    if ((this.gZk != null) && (!this.gZs))
    {
      Object localObject = this.gZl;
      if (localObject != null) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      }
      localObject = this.gZl;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      h((CaptureRequest.Builder)localObject);
      CameraCaptureSession localCameraCaptureSession = this.gZm;
      if (localCameraCaptureSession != null)
      {
        localObject = this.gZl;
        if (localObject != null) {}
        for (localObject = ((CaptureRequest.Builder)localObject).build();; localObject = null)
        {
          localCameraCaptureSession.setRepeatingRequest((CaptureRequest)localObject, (CameraCaptureSession.CaptureCallback)this.gZw, this.gZh.gYl);
          AppMethodBeat.o(94161);
          return;
        }
      }
    }
    AppMethodBeat.o(94161);
  }
  
  private final void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    CaptureRequest.Builder localBuilder = null;
    AppMethodBeat.i(94132);
    long l = bs.Gn();
    ac.i(this.fOO, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (atn())
    {
      ac.i(this.fOO, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94132);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.gZp) {
          continue;
        }
        localCameraDevice = this.gZk;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(3);
        }
        this.gZl = localBuilder;
        nz(paramInt);
        atw();
        if (a(paramSurfaceTexture, paramSurfaceHolder))
        {
          a(a.a.gXg);
          this.state = 0;
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        CameraDevice localCameraDevice;
        ac.e(this.fOO, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arx();
        continue;
      }
      ac.i(this.fOO, "start preview end, use %dms %s", new Object[] { Long.valueOf(bs.aO(l)), Looper.myLooper() });
      AppMethodBeat.o(94132);
      return;
      localCameraDevice = this.gZk;
      if (localCameraDevice != null) {
        localBuilder = localCameraDevice.createCaptureRequest(1);
      }
    }
  }
  
  @TargetApi(14)
  private boolean c(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94153);
    if (paramCameraCharacteristics == null)
    {
      AppMethodBeat.o(94153);
      return false;
    }
    try
    {
      ac.i(this.fOO, "safeSetMetering");
      Rect localRect = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
      MeteringRectangle[] arrayOfMeteringRectangle = new MeteringRectangle[1];
      if (localRect != null) {}
      for (paramCameraCharacteristics = Integer.valueOf(localRect.right);; paramCameraCharacteristics = null)
      {
        if (paramCameraCharacteristics == null) {
          d.g.b.k.fOy();
        }
        arrayOfMeteringRectangle[0] = new MeteringRectangle(paramCameraCharacteristics.intValue() / 2 - 500, localRect.bottom / 2 - 500, 1000, 1000, 0);
        paramCameraCharacteristics = this.gZl;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.gZl;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.gZl;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        }
        paramCameraCharacteristics = this.gZl;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
        }
        AppMethodBeat.o(94153);
        return true;
      }
      return false;
    }
    catch (Exception paramCameraCharacteristics)
    {
      ac.i(this.fOO, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
      AppMethodBeat.o(94153);
    }
  }
  
  private static int cX(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    if (paramInt1 < 0) {
      return 0;
    }
    return paramInt1;
  }
  
  private final int getPreviewHeight()
  {
    AppMethodBeat.i(94144);
    if (this.gZk == null)
    {
      AppMethodBeat.o(94144);
      return 0;
    }
    try
    {
      if ((this.gWY) && (this.gXK != null))
      {
        Point localPoint = this.gXK;
        if (localPoint == null) {
          d.g.b.k.fOy();
        }
        i = localPoint.y;
        AppMethodBeat.o(94144);
        return i;
      }
      int i = this.gXb.qCI;
      AppMethodBeat.o(94144);
      return i;
    }
    catch (Exception localException)
    {
      ac.e(this.fOO, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94144);
    }
    return 0;
  }
  
  private final int getPreviewWidth()
  {
    AppMethodBeat.i(94145);
    if (this.gZk == null)
    {
      AppMethodBeat.o(94145);
      return 0;
    }
    if (this.gYz != null) {
      try
      {
        if ((this.gWY) && (this.gXK != null))
        {
          Point localPoint = this.gXK;
          if (localPoint == null) {
            d.g.b.k.fOy();
          }
          i = localPoint.x;
          AppMethodBeat.o(94145);
          return i;
        }
        int i = this.gXb.qCH;
        AppMethodBeat.o(94145);
        return i;
      }
      catch (Exception localException)
      {
        ac.e(this.fOO, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94145);
    return 0;
  }
  
  private static void h(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94152);
    d locald = d.gZb;
    d.b(paramBuilder);
    locald = d.gZb;
    d.d(paramBuilder);
    locald = d.gZb;
    d.e(paramBuilder);
    locald = d.gZb;
    d.c(paramBuilder);
    locald = d.gZb;
    d.f(paramBuilder);
    AppMethodBeat.o(94152);
  }
  
  private final boolean nz(int paramInt)
  {
    AppMethodBeat.i(94154);
    for (;;)
    {
      try
      {
        localObject1 = this.gYz;
        if (localObject1 == null) {
          break label870;
        }
        localObject3 = d.gZb;
        localObject3 = d.aua();
        if (localObject3 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = ((CameraManager)localObject1).getCameraCharacteristics((String)localObject3);
        this.gZo = ((CameraCharacteristics)localObject1);
        localObject1 = d.gZb;
        if (d.aud() == 90) {
          break label865;
        }
        localObject1 = d.gZb;
        if (d.aud() != 270) {
          break label876;
        }
      }
      catch (CameraAccessException localCameraAccessException)
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        int i;
        Size localSize;
        ac.printErrStackTrace(this.fOO, (Throwable)localCameraAccessException, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", new Object[] { Looper.myLooper(), localCameraAccessException.getMessage() });
        AppMethodBeat.o(94154);
        return false;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace(this.fOO, (Throwable)localException, "selectNoCropPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(94154);
        return false;
      }
      if (this.gXe == null)
      {
        localObject1 = com.tencent.mm.plugin.mmsight.d.fH(this.context);
        localObject3 = d.gZb;
        localObject4 = h.b(d.aug(), (Point)localObject1, paramInt, bool);
        localObject3 = localObject4;
        if (((h.c)localObject4).uKY == null)
        {
          ac.e(this.fOO, "fuck, preview size still null!!");
          localObject3 = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
          localObject4 = d.gZb;
          localObject3 = h.a(d.aug(), (Point)localObject3, this.gXV, bool);
        }
        if (((h.c)localObject3).uKY == null)
        {
          ac.i(this.fOO, "checkMore start %s", new Object[] { ((h.c)localObject3).toString() });
          ((h.c)localObject3).uKY = ((h.c)localObject3).uLb;
          ((h.c)localObject3).uKZ = ((h.c)localObject3).uLc;
          ((h.c)localObject3).uLa = ((h.c)localObject3).uLd;
        }
        this.gZg = new Size(((h.c)localObject3).uKY.x, ((h.c)localObject3).uKY.y);
        if (this.gZg == null)
        {
          com.tencent.mm.plugin.mmsight.model.l.atO();
          localObject1 = c.gYy;
          c.atO();
          AppMethodBeat.o(94154);
          return false;
        }
      }
      else
      {
        localObject1 = this.gXe;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        i = ((Size)localObject1).getWidth();
        localObject1 = this.gXe;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = new Point(i, ((Size)localObject1).getHeight());
        continue;
      }
      localObject4 = this.gXb;
      localSize = this.gZg;
      if (localSize == null) {
        d.g.b.k.fOy();
      }
      ((com.tencent.mm.plugin.mmsight.model.q)localObject4).qCH = localSize.getWidth();
      localObject4 = this.gXb;
      localSize = this.gZg;
      if (localSize == null) {
        d.g.b.k.fOy();
      }
      ((com.tencent.mm.plugin.mmsight.model.q)localObject4).qCI = localSize.getHeight();
      if (((h.c)localObject3).uLa != null) {
        this.gXK = ((h.c)localObject3).uLa;
      }
      localObject3 = this.surfaceTexture;
      if (localObject3 == null) {
        d.g.b.k.fOy();
      }
      localObject4 = this.gZg;
      if (localObject4 == null) {
        d.g.b.k.fOy();
      }
      i = ((Size)localObject4).getWidth();
      localObject4 = this.gZg;
      if (localObject4 == null) {
        d.g.b.k.fOy();
      }
      ((SurfaceTexture)localObject3).setDefaultBufferSize(i, ((Size)localObject4).getHeight());
      ac.i(this.fOO, "final set camera preview size: " + this.gZg + ", cropSize: " + this.gXK);
      localObject3 = d.gZb;
      localObject4 = h.b(d.auh(), (Point)localObject1, paramInt, bool);
      localObject3 = localObject4;
      if (((h.c)localObject4).uKY == null)
      {
        localObject3 = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
        localObject4 = d.gZb;
        localObject3 = h.a(d.aug(), (Point)localObject3, this.gXV, bool);
      }
      if (((h.c)localObject3).uKY == null)
      {
        localObject4 = c.gYy;
        c.atP();
        ac.i(this.fOO, "checkMore start %s", new Object[] { ((h.c)localObject3).toString() });
        ((h.c)localObject3).uKY = ((h.c)localObject3).uLb;
        ((h.c)localObject3).uKZ = ((h.c)localObject3).uLc;
        ((h.c)localObject3).uLa = ((h.c)localObject3).uLd;
      }
      localObject4 = d.gZb;
      d.c((Point)localObject1);
      localObject1 = new Size(((h.c)localObject3).uKY.x, ((h.c)localObject3).uKY.y);
      paramInt = ((Size)localObject1).getWidth();
      i = ((Size)localObject1).getHeight();
      localObject1 = d.gZb;
      localObject1 = ImageReader.newInstance(paramInt, i, d.auc(), 1);
      ((ImageReader)localObject1).setOnImageAvailableListener(this.gZh.gYp, this.gZh.gYl);
      this.fZK = ((ImageReader)localObject1);
      AppMethodBeat.o(94154);
      return true;
      label865:
      boolean bool = true;
      continue;
      label870:
      Object localObject2 = null;
      continue;
      label876:
      bool = false;
    }
  }
  
  public final void A(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94159);
    d.g.b.k.h(paramString, "tag");
    b.a locala = com.tencent.mm.media.widget.b.a.a.b.haF;
    if (d.g.b.k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.auw()))
    {
      paramString = d.gZb;
      d.em(paramBoolean);
    }
    for (;;)
    {
      aum();
      AppMethodBeat.o(94159);
      return;
      locala = com.tencent.mm.media.widget.b.a.a.b.haF;
      if (d.g.b.k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.auB()))
      {
        paramString = d.gZb;
        d.ei(paramBoolean);
      }
      else
      {
        locala = com.tencent.mm.media.widget.b.a.a.b.haF;
        if (d.g.b.k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.auA()))
        {
          paramString = d.gZb;
          d.ej(paramBoolean);
        }
        else
        {
          locala = com.tencent.mm.media.widget.b.a.a.b.haF;
          if (d.g.b.k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.auD()))
          {
            paramString = d.gZb;
            d.ek(paramBoolean);
          }
          else
          {
            locala = com.tencent.mm.media.widget.b.a.a.b.haF;
            if (d.g.b.k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.auC()))
            {
              paramString = d.gZb;
              d.el(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  public final void W(String paramString, int paramInt)
  {
    AppMethodBeat.i(94160);
    d.g.b.k.h(paramString, "tag");
    Object localObject = d.gZb;
    localObject = this.gZl;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    d.a((CaptureRequest.Builder)localObject, paramString, paramInt);
    aum();
    AppMethodBeat.o(94160);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94130);
    this.gZj.acquire();
    this.gZj.release();
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    b(paramSurfaceTexture, null, paramInt);
    AppMethodBeat.o(94130);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94131);
    this.gZj.acquire();
    this.gZj.release();
    super.a(paramSurfaceHolder, paramBoolean, paramInt);
    b(null, paramSurfaceHolder, paramInt);
    AppMethodBeat.o(94131);
  }
  
  public final void a(g paramg) {}
  
  public final int atC()
  {
    AppMethodBeat.i(94162);
    d locald = d.gZb;
    if (d.aub())
    {
      AppMethodBeat.o(94162);
      return 0;
    }
    AppMethodBeat.o(94162);
    return 1;
  }
  
  public final int atD()
  {
    AppMethodBeat.i(94163);
    d locald = d.gZb;
    int i = d.aud();
    AppMethodBeat.o(94163);
    return i;
  }
  
  public final void atE()
  {
    this.gZy = 15;
  }
  
  public final boolean ato()
  {
    AppMethodBeat.i(94158);
    this.gZp = true;
    Object localObject = d.gZb;
    d.el(true);
    localObject = c.gYy;
    c.atU();
    AppMethodBeat.o(94158);
    return true;
  }
  
  public final void atx()
  {
    AppMethodBeat.i(94138);
    if (!atn())
    {
      AppMethodBeat.o(94138);
      return;
    }
    this.gZh.removeCallbacks((Runnable)this.gZx);
    AppMethodBeat.o(94138);
  }
  
  public final com.tencent.mm.media.widget.a.b aty()
  {
    boolean bool = true;
    AppMethodBeat.i(94143);
    ac.m(this.fOO, "generateCameraConfig", new Object[0]);
    if (this.gZk == null)
    {
      ac.i(this.fOO, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94143);
      return null;
    }
    if (!atn())
    {
      ac.i(this.fOO, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94143);
      return null;
    }
    Object localObject = com.tencent.mm.media.widget.a.b.gXn;
    com.tencent.mm.media.widget.a.b.ns(getPreviewWidth());
    localObject = com.tencent.mm.media.widget.a.b.gXn;
    com.tencent.mm.media.widget.a.b.nr(getPreviewHeight());
    localObject = this.gZo;
    Integer localInteger;
    int i;
    if (localObject != null)
    {
      localInteger = (Integer)((CameraCharacteristics)localObject).get(CameraCharacteristics.SENSOR_ORIENTATION);
      if (localInteger == null)
      {
        localObject = (Integer)((CameraCharacteristics)localObject).get(CameraCharacteristics.SENSOR_ORIENTATION);
        if (localObject != null) {
          break label276;
        }
        i = 0;
        label137:
        localObject = com.tencent.mm.media.widget.a.b.gXn;
        com.tencent.mm.media.widget.a.b.nu(this.gXb.qCH);
        localObject = com.tencent.mm.media.widget.a.b.gXn;
        com.tencent.mm.media.widget.a.b.nv(this.gXb.qCI);
        if (i != 0)
        {
          localObject = com.tencent.mm.media.widget.a.b.gXn;
          i = com.tencent.mm.media.widget.a.b.atr();
          localObject = com.tencent.mm.media.widget.a.b.gXn;
          localObject = com.tencent.mm.media.widget.a.b.gXn;
          com.tencent.mm.media.widget.a.b.nu(com.tencent.mm.media.widget.a.b.ats());
          localObject = com.tencent.mm.media.widget.a.b.gXn;
          com.tencent.mm.media.widget.a.b.nv(i);
        }
        localObject = com.tencent.mm.media.widget.a.b.gXn;
        if (!atn()) {
          break label294;
        }
        localObject = d.gZb;
        i = d.aud();
        label218:
        com.tencent.mm.media.widget.a.b.nt(i);
        localObject = com.tencent.mm.media.widget.a.b.gXn;
        if (this.gWW) {
          break label299;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.media.widget.a.b.setFrontCamera(bool);
      localObject = com.tencent.mm.media.widget.a.b.gXn;
      com.tencent.mm.media.widget.a.b.ef(this.gWY);
      localObject = this.gXc;
      AppMethodBeat.o(94143);
      return localObject;
      if (localInteger.intValue() != 90) {
        break;
      }
      for (;;)
      {
        i = 1;
        break label137;
        label276:
        if (((Integer)localObject).intValue() != 270) {
          break;
        }
      }
      i = 0;
      break label137;
      label294:
      i = -1;
      break label218;
      label299:
      bool = false;
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94137);
    if (com.tencent.mm.compatible.util.d.la(14))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if ((this.gZk == null) || (this.gZm == null))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if (!atn())
    {
      AppMethodBeat.o(94137);
      return;
    }
    this.gZh.removeCallbacks((Runnable)this.gZx);
    this.gZx.x = paramFloat1;
    this.gZx.y = paramFloat2;
    this.gZx.surfaceHeight = paramInt2;
    this.gZx.surfaceWidth = paramInt1;
    this.gZh.postDelayed((Runnable)this.gZx, 400L);
    AppMethodBeat.o(94137);
  }
  
  public final void b(g paramg) {}
  
  protected final boolean b(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94149);
    if (this.gZk == null)
    {
      AppMethodBeat.o(94149);
      return false;
    }
    if (paramCameraCharacteristics != null) {}
    for (;;)
    {
      try
      {
        paramCameraCharacteristics = (int[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if ((paramCameraCharacteristics != null) && (d.a.e.contains(paramCameraCharacteristics, 4)))
        {
          ac.i(this.fOO, "support continuous picture");
          paramCameraCharacteristics = this.gZl;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
          }
          AppMethodBeat.o(94149);
          return true;
          paramCameraCharacteristics = null;
          continue;
        }
        if ((paramCameraCharacteristics != null) && (d.a.e.contains(paramCameraCharacteristics, 3)))
        {
          ac.i(this.fOO, "support continuous video");
          paramCameraCharacteristics = this.gZl;
          if (paramCameraCharacteristics == null) {
            continue;
          }
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
          continue;
        }
        if (paramCameraCharacteristics == null) {
          break label217;
        }
      }
      catch (Exception paramCameraCharacteristics)
      {
        ac.i(this.fOO, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(94149);
        return false;
      }
      if (d.a.e.contains(paramCameraCharacteristics, 1))
      {
        ac.i(this.fOO, "support auto focus");
        paramCameraCharacteristics = this.gZl;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        }
      }
      else
      {
        label217:
        ac.i(this.fOO, "not support continuous video or auto focus");
      }
    }
  }
  
  public final Point eg(boolean paramBoolean)
  {
    AppMethodBeat.i(94146);
    if (!paramBoolean)
    {
      localPoint = new Point(this.gXb.qCH, this.gXb.qCI);
      AppMethodBeat.o(94146);
      return localPoint;
    }
    if (this.gXK != null)
    {
      localPoint = this.gXK;
      if (localPoint == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(94146);
      return localPoint;
    }
    Point localPoint = new Point(this.gXb.qCH, this.gXb.qCI);
    AppMethodBeat.o(94146);
    return localPoint;
  }
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(94164);
    Object localObject = d.gZb;
    localObject = this.gZl;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    d.a(paramBoolean, (CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94164);
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(94165);
    Object localObject = d.gZb;
    localObject = this.gZl;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    int i = d.a((CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94165);
    return i;
  }
  
  public final float[] getSupportZoomRatios()
  {
    AppMethodBeat.i(94141);
    if ((this.gZt == null) && (this.gZo != null))
    {
      localObject = this.gZo;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      if (localObject != null) {}
      for (float f = ((Float)localObject).floatValue();; f = 0.0F)
      {
        f = (int)(f * 10.0F) * 1.0F / 10.0F;
        this.gZt = new float[(int)(f * 10.0F)];
        int i = 0;
        int j = (int)(f * 10.0F);
        while (i < j)
        {
          localObject = this.gZt;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          localObject[i] = (i * 1.0F / 10.0F + 1.0F);
          i += 1;
        }
      }
    }
    Object localObject = this.gZt;
    AppMethodBeat.o(94141);
    return localObject;
  }
  
  public final void j(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94140);
    if ((this.gZk != null) && (atn())) {}
    for (;;)
    {
      float f2;
      try
      {
        ac.d(this.fOO, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (this.aNN)
        {
          ac.d(this.fOO, "triggerSmallZoom, zooming, ignore");
          return;
        }
        this.aNN = true;
        localObject1 = this.gZl;
        if (localObject1 != null)
        {
          localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
          localObject3 = this.gZo;
          if (localObject3 != null)
          {
            localObject3 = (Rect)((CameraCharacteristics)localObject3).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            if (localObject3 == null) {
              d.g.b.k.fOy();
            }
            f1 = ((Rect)localObject3).width();
            if (localObject1 == null) {
              d.g.b.k.fOy();
            }
            f2 = f1 / ((Rect)localObject1).width();
            localObject1 = this.gZo;
            if (localObject1 == null) {
              d.g.b.k.fOy();
            }
            localObject1 = (Float)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            if (localObject1 == null) {
              continue;
            }
            f1 = ((Float)localObject1).floatValue();
            if (!paramBoolean) {
              continue;
            }
            if (f2 < f1) {
              continue;
            }
          }
        }
        else
        {
          localObject1 = null;
          continue;
        }
        localObject3 = null;
        continue;
        f1 = 0.0F;
        continue;
        f2 = this.gZf + f2;
        if (f2 < f1) {
          break label542;
        }
        ac.d(this.fOO, "triggerSmallZoom, nextZoom: %s", new Object[] { Float.valueOf(f1) });
        f2 = ((Rect)localObject3).width() / f1;
        f1 = ((Rect)localObject3).height() / f1;
        float f3 = (((Rect)localObject3).width() - f2) / 2.0F;
        float f4 = (((Rect)localObject3).height() - f1) / 2.0F;
        localObject1 = new Rect((int)f3, (int)f4, (int)(f2 + f3), (int)(f1 + f4));
        localObject3 = this.gZl;
        if (localObject3 != null) {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
        }
        paramBoolean = this.gZs;
        if (paramBoolean) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        ac.e(this.fOO, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aNN = false;
        AppMethodBeat.o(94140);
      }
      try
      {
        localObject1 = this.gZm;
        if (localObject1 != null)
        {
          localObject3 = this.gZl;
          if (localObject3 == null) {
            d.g.b.k.fOy();
          }
          ((CameraCaptureSession)localObject1).setRepeatingRequest(((CaptureRequest.Builder)localObject3).build(), (CameraCaptureSession.CaptureCallback)this.gZw, this.gZh.gYl);
        }
      }
      catch (CameraAccessException localCameraAccessException)
      {
        continue;
      }
      this.aNN = false;
      AppMethodBeat.o(94140);
      return;
      if (f2 == 1.0F)
      {
        this.aNN = false;
        AppMethodBeat.o(94140);
        return;
      }
      float f1 = this.gZf;
      f2 -= f1;
      f1 = f2;
      if (f2 <= 1.0F)
      {
        f1 = 1.0F;
        continue;
        AppMethodBeat.o(94140);
        return;
        label542:
        f1 = f2;
      }
    }
  }
  
  public final boolean m(d.g.a.b<? super Bitmap, y> paramb)
  {
    c localc2 = null;
    AppMethodBeat.i(94157);
    d.g.b.k.h(paramb, "dataCallback");
    ac.i(this.fOO, "takePhoto");
    a(a.a.gXh);
    Object localObject1 = d.gZb;
    localObject1 = d.aua();
    Object localObject2 = d.gZb;
    if (d.g.b.k.g(localObject1, d.nA(d.gYA)))
    {
      localObject1 = c.gYy;
      c.atK();
      for (;;)
      {
        try
        {
          if (this.state != 0)
          {
            b(this.gZo);
            localObject1 = this.gZl;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
            }
            localObject1 = this.gZl;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
            }
            localObject1 = this.gZl;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
            }
            localObject1 = this.gZl;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((CaptureRequest.Builder)localObject1).build();
            if (localObject1 == null) {
              d.g.b.k.fOy();
            }
            this.gZn = ((CaptureRequest)localObject1);
            boolean bool = this.gZs;
            if (bool) {}
          }
        }
        catch (Exception localException)
        {
          CaptureRequest.Builder localBuilder;
          localc2 = c.gYy;
          c.atL();
          ac.m(this.fOO, "take photo in back camera error", new Object[] { localException });
          continue;
          localc1 = null;
          continue;
        }
        try
        {
          localObject1 = this.gZm;
          if (localObject1 != null)
          {
            localObject2 = this.gZn;
            if (localObject2 == null) {
              d.g.b.k.aVY("previewRequest");
            }
            ((CameraCaptureSession)localObject1).setRepeatingRequest((CaptureRequest)localObject2, (CameraCaptureSession.CaptureCallback)this.gZw, this.gZh.gYl);
          }
        }
        catch (CameraAccessException localCameraAccessException)
        {
          ac.e(this.fOO, "setRepeatingRequest failed, errMsg: ");
        }
      }
      this.state = 0;
      this.gZh.removeCallbacks((Runnable)this.gZx);
      localObject1 = this.gZl;
      if (localObject1 != null) {
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      this.state = 1;
      if (!this.gZs)
      {
        localObject1 = this.gZl;
        if (localObject1 == null) {
          break label417;
        }
        localObject1 = ((CaptureRequest.Builder)localObject1).build();
        if (localObject1 != null)
        {
          localObject2 = this.gZm;
          if (localObject2 != null)
          {
            localBuilder = this.gZl;
            localObject1 = localc2;
            if (localBuilder != null) {
              localObject1 = localBuilder.build();
            }
            if (localObject1 == null) {
              d.g.b.k.fOy();
            }
            ((CameraCaptureSession)localObject2).capture((CaptureRequest)localObject1, (CameraCaptureSession.CaptureCallback)this.gZw, this.gZh.gYl);
          }
        }
      }
    }
    for (;;)
    {
      this.gZh.gYn = paramb;
      AppMethodBeat.o(94157);
      return true;
      localObject1 = null;
      break;
      label417:
      c localc1 = c.gYy;
      c.atJ();
      auk();
    }
  }
  
  public final void n(d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(94133);
    this.gXY = paramb;
    d locald = d.gZb;
    d.n(paramb);
    AppMethodBeat.o(94133);
  }
  
  public final void nx(int paramInt)
  {
    AppMethodBeat.i(94139);
    if (this.gXL > 0)
    {
      AppMethodBeat.o(94139);
      return;
    }
    Object localObject = aj.cl(ai.getContext());
    int i = ((Point)localObject).y;
    ac.i(this.fOO, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94139);
      return;
    }
    try
    {
      localObject = this.gZo;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      if (localObject != null) {}
      for (float f = ((Float)localObject).floatValue();; f = 0.0F)
      {
        double d = f / (paramInt / 3.0D / 10.0D);
        if (d > 0.0D) {
          this.gXL = ((int)d + 1);
        }
        ac.i(this.fOO, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.gXL), Float.valueOf(f) });
        AppMethodBeat.o(94139);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e(this.fOO, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94139);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(94156);
    Object localObject = this.gZh;
    f localf = ((a)localObject).gYo;
    if (localf != null) {
      localf.release();
    }
    localObject = ((a)localObject).gYm;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quitSafely();
      AppMethodBeat.o(94156);
      return;
    }
    AppMethodBeat.o(94156);
  }
  
  public final boolean q(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94128);
    d.g.b.k.h(paramContext, "context");
    try
    {
      localObject = ai.getContext().getSystemService("camera");
      if (localObject == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(94128);
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace(this.fOO, (Throwable)paramContext, "init camera failed!", new Object[0]);
      paramContext = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.arx();
      AppMethodBeat.o(94128);
      return false;
    }
    this.gYz = ((CameraManager)localObject);
    Object localObject = d.gZb;
    d.a(this.gYz);
    if (this.gXU)
    {
      ac.i(this.fOO, "initCamera, already open");
      AppMethodBeat.o(94128);
      return true;
    }
    localObject = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.arv();
    super.q(paramContext, paramBoolean);
    release();
    auj();
    if (paramBoolean) {
      paramContext = d.gZb;
    }
    for (paramContext = d.nA(d.gYA);; paramContext = d.nA(d.gYB))
    {
      ac.m(this.fOO, "use camera id %s, SrvDeviceInfo id %d", new Object[] { paramContext, Integer.valueOf(ae.fJd.fFe) });
      localObject = c.gYy;
      c.atF();
      localObject = this.context;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      if (bs.checkPermission((Context)localObject, "android.permission.CAMERA")) {
        break;
      }
      ac.e(this.fOO, "it was lack of the camera permision to open camera");
      AppMethodBeat.o(94128);
      return true;
      paramContext = d.gZb;
    }
    try
    {
      if (!this.gZj.tryAcquire(2500L, TimeUnit.MILLISECONDS))
      {
        paramContext = (Throwable)new RuntimeException("Time out waiting to lock camera opening");
        AppMethodBeat.o(94128);
        throw paramContext;
      }
    }
    catch (InterruptedException paramContext)
    {
      paramContext = (Throwable)new RuntimeException("interrupt while  trying to lock camera opening", (Throwable)paramContext);
      AppMethodBeat.o(94128);
      throw paramContext;
    }
    try
    {
      localObject = this.gYz;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      ((CameraManager)localObject).openCamera(paramContext, (CameraDevice.StateCallback)this.gZv, this.gZh.gYl);
    }
    catch (CameraAccessException localCameraAccessException)
    {
      label348:
      break label348;
    }
    localObject = d.gZb;
    d.gYK = paramContext;
    if (paramContext == null) {
      d.g.b.k.fOy();
    }
    d.g.b.k.h(paramContext, "id");
    localObject = d.gYz;
    if (localObject != null) {}
    for (paramContext = ((CameraManager)localObject).getCameraCharacteristics(paramContext);; paramContext = null)
    {
      if (paramContext == null) {
        d.g.b.k.fOy();
      }
      paramContext = paramContext.get(CameraCharacteristics.SENSOR_ORIENTATION);
      if (paramContext == null) {
        d.g.b.k.fOy();
      }
      d.gYM = ((Number)paramContext).intValue();
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(94155);
    super.release();
    if (this.gZk != null)
    {
      long l = bs.Gn();
      ac.i(this.fOO, "release camera beg, %s", new Object[] { Looper.myLooper() });
      this.gZh.removeCallbacksAndMessages(null);
      auj();
      localObject = this.mSurface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      ac.i(this.fOO, "release camera end, use %dms, %s", new Object[] { Long.valueOf(bs.aO(l)), Looper.myLooper() });
    }
    this.gXK = null;
    this.gXU = false;
    Object localObject = c.gYy;
    c.atI();
    AppMethodBeat.o(94155);
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(94166);
    Object localObject = d.gZb;
    CaptureRequest.Builder localBuilder = this.gZl;
    if (localBuilder == null) {
      d.g.b.k.fOy();
    }
    d.g.b.k.h(localBuilder, "builder");
    switch (paramInt)
    {
    }
    label143:
    for (;;)
    {
      AppMethodBeat.o(94166);
      return;
      d.a(false, localBuilder);
      AppMethodBeat.o(94166);
      return;
      d.a(true, localBuilder);
      AppMethodBeat.o(94166);
      return;
      localObject = d.gYz;
      if (localObject != null)
      {
        localObject = ((CameraManager)localObject).getCameraCharacteristics(d.gYK);
        if (localObject == null) {}
      }
      for (localObject = (int[])((CameraCharacteristics)localObject).get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);; localObject = null)
      {
        if (!com.tencent.mm.compatible.loader.a.contains((int[])localObject, 2)) {
          break label143;
        }
        localBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
        break;
      }
    }
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(94142);
    if (this.aNN)
    {
      ac.d(this.fOO, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94142);
      return;
    }
    if ((this.gZo != null) && (this.gZl != null)) {
      try
      {
        localObject1 = this.gZo;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        int i = ((Rect)localObject1).width() - d.h.a.cj(((Rect)localObject1).width() / paramFloat);
        int j = ((Rect)localObject1).height() - d.h.a.cj(((Rect)localObject1).height() / paramFloat);
        this.gZr = new Rect(i / 2, j / 2, ((Rect)localObject1).width() - i / 2, ((Rect)localObject1).height() - j / 2);
        localObject1 = this.gZl;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.SCALER_CROP_REGION, this.gZr);
        boolean bool = this.gZs;
        if (bool) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        label237:
        ac.e(this.fOO, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aNN = false;
        AppMethodBeat.o(94142);
      }
    }
    try
    {
      localObject1 = this.gZm;
      if (localObject1 != null)
      {
        CaptureRequest.Builder localBuilder = this.gZl;
        if (localBuilder == null) {
          d.g.b.k.fOy();
        }
        ((CameraCaptureSession)localObject1).setRepeatingRequest(localBuilder.build(), (CameraCaptureSession.CaptureCallback)this.gZw, this.gZh.gYl);
      }
    }
    catch (CameraAccessException localCameraAccessException)
    {
      break label237;
    }
    this.aNN = false;
    AppMethodBeat.o(94142);
    return;
    AppMethodBeat.o(94142);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1", "Ljava/lang/Runnable;", "surfaceHeight", "", "getSurfaceHeight", "()I", "setSurfaceHeight", "(I)V", "surfaceWidth", "getSurfaceWidth", "setSurfaceWidth", "x", "", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "run", "", "plugin-mediaeditor_release"})
  public static final class b
    implements Runnable
  {
    int surfaceHeight;
    int surfaceWidth;
    float x;
    float y;
    
    public final void run()
    {
      AppMethodBeat.i(94117);
      e.a(this.gZC, this.x, this.y, this.surfaceWidth, this.surfaceHeight);
      AppMethodBeat.o(94117);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/widget/camera2/CommonCamera2$captureStillPicture$2$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "onCaptureCompleted", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "result", "Landroid/hardware/camera2/TotalCaptureResult;", "plugin-mediaeditor_release"})
  public static final class c
    extends CameraCaptureSession.CaptureCallback
  {
    c(e parame) {}
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(94118);
      d.g.b.k.h(paramCameraCaptureSession, "session");
      d.g.b.k.h(paramCaptureRequest, "request");
      d.g.b.k.h(paramTotalCaptureResult, "result");
      paramCameraCaptureSession = d.gZb;
      paramCameraCaptureSession = e.a(this.gZC);
      if (paramCameraCaptureSession == null) {
        d.g.b.k.fOy();
      }
      d.g(paramCameraCaptureSession);
      AppMethodBeat.o(94118);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "camera", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "plugin-mediaeditor_release"})
  public static final class d
    extends CameraDevice.StateCallback
  {
    public final void onDisconnected(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94120);
      d.g.b.k.h(paramCameraDevice, "camera");
      e.g(this.gZC).release();
      paramCameraDevice.close();
      e.a(this.gZC, null);
      AppMethodBeat.o(94120);
    }
    
    public final void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      AppMethodBeat.i(94121);
      d.g.b.k.h(paramCameraDevice, "camera");
      onDisconnected(paramCameraDevice);
      AppMethodBeat.o(94121);
    }
    
    public final void onOpened(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94119);
      d.g.b.k.h(paramCameraDevice, "camera");
      e.g(this.gZC).release();
      e.a(this.gZC, paramCameraDevice);
      AppMethodBeat.o(94119);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "capturePicture", "", "result", "Landroid/hardware/camera2/CaptureResult;", "checkFocusEnd", "", "onCaptureCompleted", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "Landroid/hardware/camera2/TotalCaptureResult;", "onCaptureProgressed", "partialResult", "process", "plugin-mediaeditor_release"})
  public static final class e
    extends CameraCaptureSession.CaptureCallback
  {
    private final void b(CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94122);
      switch (e.h(this.gZC))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94122);
        return;
        Object localObject = d.gZb;
        d.a(paramCaptureResult);
        AppMethodBeat.o(94122);
        return;
        localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if ((localObject == null) || (2 == ((Integer)localObject).intValue()) || (6 == ((Integer)localObject).intValue()))
        {
          e.i(this.gZC);
          AppMethodBeat.o(94122);
          return;
        }
        if ((4 == ((Integer)localObject).intValue()) || (5 == ((Integer)localObject).intValue()))
        {
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 2))
          {
            e.i(this.gZC);
            AppMethodBeat.o(94122);
            return;
          }
          e.j(this.gZC);
        }
        AppMethodBeat.o(94122);
        return;
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 5) || (paramCaptureResult.intValue() == 4))
        {
          e.a(this.gZC, 3);
          AppMethodBeat.o(94122);
          return;
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() != 5))
          {
            e.i(this.gZC);
            AppMethodBeat.o(94122);
            return;
            if (this.gZC.atn())
            {
              d.g.b.k.h(paramCaptureResult, "result");
              localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
              int i;
              if (localObject == null)
              {
                localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (localObject != null) {
                  break label502;
                }
                i = 0;
                label315:
                if ((i == 0) || (e.d(this.gZC))) {
                  break label534;
                }
                ac.i(e.k(this.gZC), "STATE_TOUCH_CAF_WAITING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
                this.gZC.b(e.l(this.gZC));
                paramCaptureResult = e.a(this.gZC);
                if (paramCaptureResult != null) {
                  paramCaptureResult.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                }
                localObject = this.gZC;
                paramCaptureResult = e.a(this.gZC);
                if (paramCaptureResult == null) {
                  break label513;
                }
              }
              label513:
              for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
              {
                if (paramCaptureResult == null) {
                  d.g.b.k.fOy();
                }
                e.a((e)localObject, paramCaptureResult);
                try
                {
                  paramCaptureResult = e.e(this.gZC);
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(e.m(this.gZC), (CameraCaptureSession.CaptureCallback)this, this.gZC.gZh.gYl);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    ac.e(e.b(this.gZC), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                e.a(this.gZC, 6);
                AppMethodBeat.o(94122);
                return;
                if (((Integer)localObject).intValue() != 4) {
                  break;
                }
                for (;;)
                {
                  i = 1;
                  break label315;
                  label502:
                  if (((Integer)localObject).intValue() != 5) {
                    break;
                  }
                }
              }
            }
            label534:
            ac.e(e.b(this.gZC), "current is not allowed to do anything casue capturing");
            AppMethodBeat.o(94122);
            return;
            if ((this.gZC.atn()) && (!e.d(this.gZC)))
            {
              ac.i(e.k(this.gZC), "STATE_TOUCH_FOCUSING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
              paramCaptureResult = e.a(this.gZC);
              if (paramCaptureResult != null) {
                paramCaptureResult.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
              }
              paramCaptureResult = e.a(this.gZC);
              if (paramCaptureResult != null) {
                paramCaptureResult.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
              }
              localObject = this.gZC;
              paramCaptureResult = e.a(this.gZC);
              if (paramCaptureResult != null) {}
              for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
              {
                if (paramCaptureResult == null) {
                  d.g.b.k.fOy();
                }
                e.a((e)localObject, paramCaptureResult);
                try
                {
                  paramCaptureResult = e.e(this.gZC);
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(e.m(this.gZC), (CameraCaptureSession.CaptureCallback)this, this.gZC.gZh.gYl);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    ac.e(e.b(this.gZC), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                e.a(this.gZC, 0);
                AppMethodBeat.o(94122);
                return;
              }
            }
            ac.e(e.b(this.gZC), "current is not allowed to do anything casue capturing");
          }
        }
      }
    }
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(94124);
      d.g.b.k.h(paramCameraCaptureSession, "session");
      d.g.b.k.h(paramCaptureRequest, "request");
      d.g.b.k.h(paramTotalCaptureResult, "result");
      b((CaptureResult)paramTotalCaptureResult);
      AppMethodBeat.o(94124);
    }
    
    public final void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94123);
      d.g.b.k.h(paramCameraCaptureSession, "session");
      d.g.b.k.h(paramCaptureRequest, "request");
      d.g.b.k.h(paramCaptureResult, "partialResult");
      b(paramCaptureResult);
      AppMethodBeat.o(94123);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onClosed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigureFailed", "onConfigured", "plugin-mediaeditor_release"})
  public static final class f
    extends CameraCaptureSession.StateCallback
  {
    public final void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94127);
      d.g.b.k.h(paramCameraCaptureSession, "session");
      super.onClosed(paramCameraCaptureSession);
      ac.i(e.b(this.gZC), "session on close");
      e.a(this.gZC, true);
      AppMethodBeat.o(94127);
    }
    
    public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94126);
      d.g.b.k.h(paramCameraCaptureSession, "session");
      ac.i(e.b(this.gZC), "configure failed ");
      paramCameraCaptureSession = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.arx();
      paramCameraCaptureSession = c.gYy;
      c.atH();
      AppMethodBeat.o(94126);
    }
    
    public final void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94125);
      d.g.b.k.h(paramCameraCaptureSession, "session");
      ac.i(e.b(this.gZC), "session on onConfigured");
      if (e.c(this.gZC) == null)
      {
        AppMethodBeat.o(94125);
        return;
      }
      e.a(this.gZC, false);
      e.a(this.gZC, paramCameraCaptureSession);
      paramCameraCaptureSession = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.arw();
      paramCameraCaptureSession = c.gYy;
      c.atG();
      e.f(this.gZC);
      AppMethodBeat.o(94125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e
 * JD-Core Version:    0.7.0.1
 */