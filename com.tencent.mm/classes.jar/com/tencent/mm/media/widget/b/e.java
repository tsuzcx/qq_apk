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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import d.a.j;
import d.g.b.p;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "useBack", "", "(Landroid/content/Context;Z)V", "DEFAULT_UPPER_BOUND", "", "FOCUS_TAG", "", "FOCUS_TAG$1", "SMALL_ZOOM_STEP_NUM", "getSMALL_ZOOM_STEP_NUM", "()I", "SMALL_ZOOM_STEP_NUM$1", "SMALL_ZOOM_STEP_UPPER_BOUND", "getSMALL_ZOOM_STEP_UPPER_BOUND", "SMALL_ZOOM_STEP_UPPER_BOUND$1", "SMALL_ZOOM_STEP_VAL", "", "TAG", "TAG$1", "autoFocusRunnable", "com/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1;", "cropSize", "Landroid/graphics/Point;", "imageReader", "Landroid/media/ImageReader;", "isCameraOpen", "isUseRecordStream", "isZooming", "mCameraDevice", "Landroid/hardware/camera2/CameraDevice;", "mCameraDeviceCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1;", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "mCameraOpenCloseLock", "Ljava/util/concurrent/Semaphore;", "mCaptureCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1;", "mCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "mCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "mFpsValuev", "getMFpsValuev", "setMFpsValuev", "(I)V", "mIsNoAFRun", "mIsSessionClose", "mPreviewBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "mPreviewSize", "Landroid/util/Size;", "mStateCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1;", "mSurface", "Landroid/view/Surface;", "mZoomTimesToRatio", "", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "previewRequest", "Landroid/hardware/camera2/CaptureRequest;", "scrollSmallZoomStep", "sightHandler", "Lcom/tencent/mm/media/widget/camera2/Camera2Handler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera2/Camera2Handler;", "smallZoomStep", "state", "zoomOutRect", "Landroid/graphics/Rect;", "abandonFocus", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateTapArea", "x", "y", "surfaceWidth", "surfaceHeight", "captureStillPicture", "clamp", "min", "max", "closeCamera", "configVendorTagValue", "tag", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraOrientation", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "getPreviewWidth", "getSupportZoomRatios", "initCamera", "initRawRatios", "lock3AParams", "builder", "lockFocus", "onDestroy", "openCamera", "nowCameraId", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "resumePreview", "runPrecaptureSequence", "safeResetZoom", "safeSetFocusMode", "characteristics", "safeSetMetering", "safeSetOIS", "safeSetPreviewFrameRate", "useFixMode", "safeSetStabilization", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "safeSetVendorEffect", "selectNoCropPreviewSize", "resolutionLimit", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setSafeConfig", "startPreview", "useCpuCrop", "surface", "startPreviewWithGPU", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "trySetPreviewFrameRateParameters", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends com.tencent.mm.media.widget.a.a
{
  private static final SparseIntArray hrF;
  public static final e.a hrG;
  private boolean aYh;
  private final String gio;
  private ImageReader gtg;
  private Point hpQ;
  private int hpR;
  private CameraManager hqF;
  private boolean hqa;
  private final int hqb;
  private d.g.a.b<? super Boolean, z> hqe;
  private final f hrA;
  private final d hrB;
  private final e hrC;
  private final b hrD;
  private int hrE;
  private final String hri;
  private final int hrj;
  private final int hrk;
  private final float hrl;
  private Size hrm;
  final a hrn;
  private float hro;
  private final Semaphore hrp;
  private CameraDevice hrq;
  private CaptureRequest.Builder hrr;
  private CameraCaptureSession hrs;
  private CaptureRequest hrt;
  private CameraCharacteristics hru;
  private boolean hrv;
  private boolean hrw;
  private Rect hrx;
  private boolean hry;
  private float[] hrz;
  private Surface mSurface;
  private int state;
  
  static
  {
    AppMethodBeat.i(94168);
    hrG = new e.a((byte)0);
    SparseIntArray localSparseIntArray = new SparseIntArray();
    hrF = localSparseIntArray;
    localSparseIntArray.append(0, 90);
    hrF.append(1, 0);
    hrF.append(2, 270);
    hrF.append(3, 180);
    AppMethodBeat.o(94168);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94167);
    this.gio = "MicroMsg.CommonCamera2";
    this.hri = "MicroMsg.CommonCamera2.FoucsTag";
    this.hrj = 5;
    this.hrk = 20;
    this.hrl = 0.1F;
    Object localObject = Looper.getMainLooper();
    p.g(localObject, "Looper.getMainLooper()");
    this.hrn = new a((Looper)localObject, paramContext);
    this.hpR = -1;
    this.hro = -1.0F;
    this.hqb = 2100;
    this.hrp = new Semaphore(1);
    if (com.tencent.mm.media.widget.d.a.ayn())
    {
      paramContext = new com.tencent.mm.media.widget.b.a.c(paramContext);
      localObject = (d.g.a.q)1.hrH;
      p.h(localObject, "mSupportWCKeyAvailable");
      new Thread((Runnable)new c.a(paramContext, (d.g.a.a)new c.b(paramContext, (d.g.a.q)localObject))).start();
      paramContext = d.hrh;
      d.awS();
    }
    this.hrA = new f(this);
    this.hrB = new d(this);
    this.hrC = new e(this);
    this.hrD = new b(this);
    AppMethodBeat.o(94167);
  }
  
  private final void a(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94148);
    if (ae.gcE.fYs > 0)
    {
      ad.i(this.hoZ, "set frame rate > 0, do not try set preview fps range");
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
        ad.i(this.gio, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(m), localInteger1, localInteger2 });
        if (p.compare(localInteger1.intValue(), 0) >= 0)
        {
          n = localInteger2.intValue();
          p.g(localInteger1, "min");
          if (p.compare(n, localInteger1.intValue()) >= 0) {
            break label253;
          }
        }
        n = k;
        k = j;
      }
      label253:
      if (this.hrE == 0)
      {
        n = 30;
        if ((p.compare(localInteger2.intValue(), k) < 0) || (i != 0) || (p.compare(localInteger2.intValue(), n) > 0)) {
          break label554;
        }
        k = localInteger1.intValue();
        p.g(localInteger2, "max");
        j = localInteger2.intValue();
      }
    }
    for (;;)
    {
      if (this.hrE != 0)
      {
        n = this.hrE;
        if (localInteger2 == null)
        {
          break;
          n = this.hrE;
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
        ad.i(this.hoZ, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(30) });
        if ((j == 2147483647) || (k == 2147483647))
        {
          AppMethodBeat.o(94148);
          return;
        }
        try
        {
          paramCameraCharacteristics = this.hrr;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range((Comparable)Integer.valueOf(j), (Comparable)Integer.valueOf(k)));
          }
          ad.i(this.hoZ, "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          AppMethodBeat.o(94148);
          return;
        }
        catch (Exception paramCameraCharacteristics)
        {
          ad.i(this.hoZ, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
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
    Object localObject2 = this.hrr;
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
          paramSurfaceTexture = d.hrh;
          if (!d.awV()) {
            break label456;
          }
          if (!this.hrv) {
            break label279;
          }
          paramSurfaceTexture = d.hrh;
          paramSurfaceTexture = this.hrr;
          if (paramSurfaceTexture == null) {
            p.gfZ();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.hsL;
          j = d.a(paramSurfaceTexture, j.listOf(com.tencent.mm.media.widget.b.a.a.b.axp()));
          i = j;
          if (Build.VERSION.SDK_INT < 28) {
            break label445;
          }
          paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration(this.mSurface)), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.hrA);
          paramSurfaceHolder = this.hrq;
          if (paramSurfaceHolder == null) {
            p.gfZ();
          }
          paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
          if (j == 0)
          {
            paramSurfaceHolder = this.hrq;
            if (paramSurfaceHolder == null) {
              p.gfZ();
            }
            localObject1 = this.mSurface;
            localObject2 = this.gtg;
            paramSurfaceTexture = localSurface;
            if (localObject2 != null) {
              paramSurfaceTexture = ((ImageReader)localObject2).getSurface();
            }
            paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localObject1, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.hrA, this.hrn.hqr);
          }
        }
        for (;;)
        {
          ad.i(this.gio, "doStartPreview finish");
          AppMethodBeat.o(94135);
          return true;
          if (paramSurfaceHolder == null) {
            break;
          }
          this.mSurface = paramSurfaceHolder.getSurface();
          break;
          label279:
          paramSurfaceTexture = d.hrh;
          paramSurfaceTexture = this.hrr;
          if (paramSurfaceTexture == null) {
            p.gfZ();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.hsL;
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.axo();
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.hsL;
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.axn();
          localObject2 = com.tencent.mm.media.widget.b.a.a.b.hsL;
          j = d.a(paramSurfaceTexture, j.listOf(new String[] { paramSurfaceHolder, localObject1, com.tencent.mm.media.widget.b.a.a.b.axq() }));
          i = j;
          if (Build.VERSION.SDK_INT >= 28)
          {
            paramSurfaceHolder = new OutputConfiguration(this.mSurface);
            paramSurfaceTexture = this.gtg;
            if (paramSurfaceTexture == null) {
              break label451;
            }
          }
          label445:
          label451:
          for (paramSurfaceTexture = paramSurfaceTexture.getSurface();; paramSurfaceTexture = null)
          {
            paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration[] { paramSurfaceHolder, new OutputConfiguration(paramSurfaceTexture) }), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.hrA);
            paramSurfaceHolder = this.hrq;
            if (paramSurfaceHolder == null) {
              p.gfZ();
            }
            paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
            i = j;
            j = i;
            break;
          }
          label456:
          paramSurfaceHolder = this.hrq;
          if (paramSurfaceHolder == null) {
            p.gfZ();
          }
          localSurface = this.mSurface;
          localObject2 = this.gtg;
          paramSurfaceTexture = (SurfaceTexture)localObject1;
          if (localObject2 != null) {
            paramSurfaceTexture = ((ImageReader)localObject2).getSurface();
          }
          paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localSurface, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.hrA, this.hrn.hqr);
        }
      }
      ad.i(this.gio, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auk();
      paramSurfaceTexture = c.hqE;
      c.awu();
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
        if (ae.gcE.fYs > 0) {
          ad.i(this.hoZ, "set frame rate > 0, do not try set preview frame rate");
        }
        for (;;)
        {
          paramCameraCharacteristics = this.hrr;
          if (paramCameraCharacteristics != null)
          {
            paramCameraCharacteristics = (Range)paramCameraCharacteristics.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
            label61:
            ad.i(this.hoZ, "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), paramCameraCharacteristics });
            AppMethodBeat.o(94147);
            return true;
            if (paramCameraCharacteristics == null)
            {
              ad.e(this.gio, "trySetPreviewFrameRateParameters error, p is null!");
              continue;
            }
            try
            {
              paramCameraCharacteristics = (Range[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
              p.g(paramCameraCharacteristics, "fpsList");
              k = paramCameraCharacteristics.length;
              j = 0;
              i = 0;
              if (j < k)
              {
                localObject = paramCameraCharacteristics[j];
                p.g(localObject, "it");
                localComparable = ((Range)localObject).getUpper();
                p.g(localComparable, "it.upper");
                if (p.compare(i, ((Number)localComparable).intValue()) < 0)
                {
                  localObject = ((Range)localObject).getUpper();
                  p.g(localObject, "it.upper");
                  i = ((Number)localObject).intValue();
                }
              }
              else if (this.hrE == 0)
              {
                i = Math.min(30, i);
                paramCameraCharacteristics = new Range((Comparable)Integer.valueOf(i), (Comparable)Integer.valueOf(i));
                localObject = this.hrr;
                if (localObject == null) {
                  continue;
                }
                ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, paramCameraCharacteristics);
              }
            }
            catch (Exception paramCameraCharacteristics)
            {
              ad.i(this.hoZ, "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
            }
          }
        }
      }
      catch (Exception paramCameraCharacteristics)
      {
        ad.i(this.hoZ, "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
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
      int i = Math.min(this.hrE, i);
      continue;
      a(paramCameraCharacteristics);
      break;
      paramCameraCharacteristics = null;
      break label61;
      j += 1;
    }
  }
  
  private final void awW()
  {
    AppMethodBeat.i(94129);
    try
    {
      if (this.hrr != null)
      {
        localObject1 = d.hrh;
        localObject1 = this.hrr;
        if (localObject1 == null) {
          p.gfZ();
        }
        d.g((CaptureRequest.Builder)localObject1);
      }
      this.hrp.acquire();
      Object localObject1 = this.hrs;
      if (localObject1 != null) {
        ((CameraCaptureSession)localObject1).close();
      }
      this.hrs = null;
      localObject1 = this.hrq;
      if (localObject1 != null) {
        ((CameraDevice)localObject1).close();
      }
      this.hrq = null;
      localObject1 = this.gtg;
      if (localObject1 != null) {
        ((ImageReader)localObject1).setOnImageAvailableListener(null, this.hrn.hqr);
      }
      localObject1 = this.gtg;
      if (localObject1 != null) {
        ((ImageReader)localObject1).close();
      }
      this.gtg = null;
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
      this.hrp.release();
      AppMethodBeat.o(94129);
    }
  }
  
  private final void awX()
  {
    Object localObject2 = null;
    AppMethodBeat.i(94134);
    try
    {
      if (this.state == 4)
      {
        ad.m(this.gio, "capture still picture more than twice", new Object[0]);
        AppMethodBeat.o(94134);
        return;
      }
      this.state = 4;
      ad.i(this.gio, "captureStillPicture");
      if (this.hrq == null)
      {
        AppMethodBeat.o(94134);
        return;
      }
    }
    catch (Exception localException)
    {
      localObject2 = d.hrh;
      if (!d.awO())
      {
        localObject2 = c.hqE;
        c.awz();
      }
      ad.e(this.gio, localException.toString());
      AppMethodBeat.o(94134);
      return;
    }
    Object localObject1 = this.hrr;
    Object localObject3;
    label190:
    label255:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
      if ((this.hrq == null) || (this.hry))
      {
        AppMethodBeat.o(94134);
        return;
      }
      localObject3 = this.hrq;
      if (localObject3 != null)
      {
        localObject3 = ((CameraDevice)localObject3).createCaptureRequest(2);
        if (localObject3 != null)
        {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
          localObject1 = this.gtg;
          if (localObject1 == null) {
            break label531;
          }
          localObject1 = ((ImageReader)localObject1).getSurface();
          ((CaptureRequest.Builder)localObject3).addTarget((Surface)localObject1);
          localObject1 = this.gtg;
          if (localObject1 != null) {
            ((ImageReader)localObject1).setOnImageAvailableListener(this.hrn.hqv, this.hrn.hqr);
          }
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
          localObject1 = this.hru;
          if (localObject1 == null) {
            break label536;
          }
          localObject1 = (Float)((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
          if (localObject1 == null) {
            break label526;
          }
          if (!p.a((Float)localObject1)) {
            break label541;
          }
          break label526;
          label269:
          this.hrw = bool;
          if (!this.hrw)
          {
            localObject1 = this.hru;
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
        localObject1 = this.hru;
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
        this.hrr = ((CaptureRequest.Builder)localObject1);
        localObject3 = this.hrs;
        if (localObject3 == null) {
          break label514;
        }
        ((CameraCaptureSession)localObject3).stopRepeating();
        ad.i(this.hri, "this time happened a cancel auto foucs while capture");
        localObject1 = this.hrr;
        if (localObject1 != null) {
          ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
        }
        CaptureRequest.Builder localBuilder = this.hrr;
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
  
  private final void awY()
  {
    AppMethodBeat.i(94151);
    Object localObject = this.hru;
    if (localObject != null)
    {
      localObject = (int[])((CameraCharacteristics)localObject).get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
      if (localObject == null) {
        break label146;
      }
      ad.i(this.gio, "oisMode:" + Arrays.toString((int[])localObject));
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
      localObject = c.hqE;
      c.awA();
      localObject = d.hrh;
      d.en(false);
      localObject = this.hrr;
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
  
  private final void awZ()
  {
    AppMethodBeat.i(94161);
    if (this.hrr == null)
    {
      AppMethodBeat.o(94161);
      return;
    }
    if ((this.hrq != null) && (!this.hry))
    {
      Object localObject = this.hrr;
      if (localObject != null) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      }
      localObject = this.hrr;
      if (localObject == null) {
        p.gfZ();
      }
      h((CaptureRequest.Builder)localObject);
      CameraCaptureSession localCameraCaptureSession = this.hrs;
      if (localCameraCaptureSession != null)
      {
        localObject = this.hrr;
        if (localObject != null) {}
        for (localObject = ((CaptureRequest.Builder)localObject).build();; localObject = null)
        {
          localCameraCaptureSession.setRepeatingRequest((CaptureRequest)localObject, (CameraCaptureSession.CaptureCallback)this.hrC, this.hrn.hqr);
          AppMethodBeat.o(94161);
          return;
        }
      }
    }
    AppMethodBeat.o(94161);
  }
  
  private final void awj()
  {
    AppMethodBeat.i(94136);
    Integer localInteger = Integer.valueOf(0);
    Object localObject = com.tencent.mm.plugin.mmsight.model.a.l.dno();
    p.g(localObject, "MMSightController.getInstance()");
    if (((com.tencent.mm.plugin.mmsight.model.a.l)localObject).dnp() != null)
    {
      localObject = com.tencent.mm.plugin.mmsight.model.a.l.dno();
      p.g(localObject, "MMSightController.getInstance()");
      localInteger = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.a.l)localObject).dnp().vMM);
    }
    String str = this.gio;
    boolean bool1;
    label92:
    boolean bool2;
    label104:
    boolean bool3;
    label116:
    boolean bool4;
    if (ae.gcE.fYx == 1)
    {
      localObject = "Range";
      if (ae.gcE.fYy != 1) {
        break label399;
      }
      bool1 = true;
      if (ae.gcE.fYz != 1) {
        break label404;
      }
      bool2 = true;
      if (ae.gcE.fYA != 1) {
        break label409;
      }
      bool3 = true;
      if (ae.gcE.fYB != 1) {
        break label414;
      }
      bool4 = true;
      label129:
      ad.i(str, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if ((ae.gcE.fYx != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 1))) {
        break label420;
      }
      a(this.hru, false);
    }
    for (;;)
    {
      if ((ae.gcE.fYy == 1) && (localInteger.intValue() != 0)) {
        localInteger.intValue();
      }
      if ((ae.gcL.gbr != -1) && (ae.gcL.gbr == 1) && (com.tencent.mm.compatible.util.d.lA(14))) {
        c(this.hru);
      }
      if ((ae.gcE.fYA == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
        b(this.hru);
      }
      if ((ae.gcE.fYB == 1) && (localInteger.intValue() != 0)) {
        localInteger.intValue();
      }
      awm();
      awY();
      localObject = this.hrr;
      if (localObject == null) {
        p.gfZ();
      }
      h((CaptureRequest.Builder)localObject);
      AppMethodBeat.o(94136);
      return;
      if (ae.gcE.fYw == 1)
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
      if ((ae.gcE.fYw == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 5))) {
        a(this.hru, true);
      }
    }
  }
  
  private void awm()
  {
    AppMethodBeat.i(94150);
    Object localObject = this.hru;
    if (localObject != null) {
      localObject = (Rect)((CameraCharacteristics)localObject).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }
    while (localObject != null)
    {
      localObject = new Rect(((Rect)localObject).left * 1, ((Rect)localObject).top * 1, ((Rect)localObject).right * 1, ((Rect)localObject).bottom * 1);
      CaptureRequest.Builder localBuilder = this.hrr;
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
  
  private final void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    CaptureRequest.Builder localBuilder = null;
    AppMethodBeat.i(94132);
    long l = bt.HI();
    ad.i(this.gio, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (awa())
    {
      ad.i(this.gio, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94132);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.hrv) {
          continue;
        }
        localCameraDevice = this.hrq;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(3);
        }
        this.hrr = localBuilder;
        nY(paramInt);
        awj();
        if (a(paramSurfaceTexture, paramSurfaceHolder))
        {
          a(a.a.hpm);
          this.state = 0;
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        CameraDevice localCameraDevice;
        ad.e(this.gio, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.auk();
        continue;
      }
      ad.i(this.gio, "start preview end, use %dms %s", new Object[] { Long.valueOf(bt.aO(l)), Looper.myLooper() });
      AppMethodBeat.o(94132);
      return;
      localCameraDevice = this.hrq;
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
      ad.i(this.gio, "safeSetMetering");
      Rect localRect = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
      MeteringRectangle[] arrayOfMeteringRectangle = new MeteringRectangle[1];
      if (localRect != null) {}
      for (paramCameraCharacteristics = Integer.valueOf(localRect.right);; paramCameraCharacteristics = null)
      {
        if (paramCameraCharacteristics == null) {
          p.gfZ();
        }
        arrayOfMeteringRectangle[0] = new MeteringRectangle(paramCameraCharacteristics.intValue() / 2 - 500, localRect.bottom / 2 - 500, 1000, 1000, 0);
        paramCameraCharacteristics = this.hrr;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.hrr;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.hrr;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        }
        paramCameraCharacteristics = this.hrr;
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
      ad.i(this.gio, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
      AppMethodBeat.o(94153);
    }
  }
  
  private static int cZ(int paramInt1, int paramInt2)
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
    if (this.hrq == null)
    {
      AppMethodBeat.o(94144);
      return 0;
    }
    try
    {
      if ((this.hpe) && (this.hpQ != null))
      {
        Point localPoint = this.hpQ;
        if (localPoint == null) {
          p.gfZ();
        }
        i = localPoint.y;
        AppMethodBeat.o(94144);
        return i;
      }
      int i = this.hph.rmy;
      AppMethodBeat.o(94144);
      return i;
    }
    catch (Exception localException)
    {
      ad.e(this.gio, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94144);
    }
    return 0;
  }
  
  private final int getPreviewWidth()
  {
    AppMethodBeat.i(94145);
    if (this.hrq == null)
    {
      AppMethodBeat.o(94145);
      return 0;
    }
    if (this.hqF != null) {
      try
      {
        if ((this.hpe) && (this.hpQ != null))
        {
          Point localPoint = this.hpQ;
          if (localPoint == null) {
            p.gfZ();
          }
          i = localPoint.x;
          AppMethodBeat.o(94145);
          return i;
        }
        int i = this.hph.rmx;
        AppMethodBeat.o(94145);
        return i;
      }
      catch (Exception localException)
      {
        ad.e(this.gio, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94145);
    return 0;
  }
  
  private static void h(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94152);
    d locald = d.hrh;
    d.b(paramBuilder);
    locald = d.hrh;
    d.d(paramBuilder);
    locald = d.hrh;
    d.e(paramBuilder);
    locald = d.hrh;
    d.c(paramBuilder);
    locald = d.hrh;
    d.f(paramBuilder);
    AppMethodBeat.o(94152);
  }
  
  private final boolean nY(int paramInt)
  {
    AppMethodBeat.i(94154);
    for (;;)
    {
      try
      {
        localObject1 = this.hqF;
        if (localObject1 == null) {
          break label870;
        }
        localObject3 = d.hrh;
        localObject3 = d.awN();
        if (localObject3 == null) {
          p.gfZ();
        }
        localObject1 = ((CameraManager)localObject1).getCameraCharacteristics((String)localObject3);
        this.hru = ((CameraCharacteristics)localObject1);
        localObject1 = d.hrh;
        if (d.awQ() == 90) {
          break label865;
        }
        localObject1 = d.hrh;
        if (d.awQ() != 270) {
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
        ad.printErrStackTrace(this.gio, (Throwable)localCameraAccessException, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", new Object[] { Looper.myLooper(), localCameraAccessException.getMessage() });
        AppMethodBeat.o(94154);
        return false;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(this.gio, (Throwable)localException, "selectNoCropPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(94154);
        return false;
      }
      if (this.hpk == null)
      {
        localObject1 = com.tencent.mm.plugin.mmsight.d.fM(this.context);
        localObject3 = d.hrh;
        localObject4 = h.b(d.awT(), (Point)localObject1, paramInt, bool);
        localObject3 = localObject4;
        if (((h.c)localObject4).vOe == null)
        {
          ad.e(this.gio, "fuck, preview size still null!!");
          localObject3 = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
          localObject4 = d.hrh;
          localObject3 = h.a(d.awT(), (Point)localObject3, this.hqb, bool);
        }
        if (((h.c)localObject3).vOe == null)
        {
          ad.i(this.gio, "checkMore start %s", new Object[] { ((h.c)localObject3).toString() });
          ((h.c)localObject3).vOe = ((h.c)localObject3).vOh;
          ((h.c)localObject3).vOf = ((h.c)localObject3).vOi;
          ((h.c)localObject3).vOg = ((h.c)localObject3).vOj;
        }
        this.hrm = new Size(((h.c)localObject3).vOe.x, ((h.c)localObject3).vOe.y);
        if (this.hrm == null)
        {
          com.tencent.mm.plugin.mmsight.model.l.awB();
          localObject1 = c.hqE;
          c.awB();
          AppMethodBeat.o(94154);
          return false;
        }
      }
      else
      {
        localObject1 = this.hpk;
        if (localObject1 == null) {
          p.gfZ();
        }
        i = ((Size)localObject1).getWidth();
        localObject1 = this.hpk;
        if (localObject1 == null) {
          p.gfZ();
        }
        localObject1 = new Point(i, ((Size)localObject1).getHeight());
        continue;
      }
      localObject4 = this.hph;
      localSize = this.hrm;
      if (localSize == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.mmsight.model.q)localObject4).rmx = localSize.getWidth();
      localObject4 = this.hph;
      localSize = this.hrm;
      if (localSize == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.mmsight.model.q)localObject4).rmy = localSize.getHeight();
      if (((h.c)localObject3).vOg != null) {
        this.hpQ = ((h.c)localObject3).vOg;
      }
      localObject3 = this.surfaceTexture;
      if (localObject3 == null) {
        p.gfZ();
      }
      localObject4 = this.hrm;
      if (localObject4 == null) {
        p.gfZ();
      }
      i = ((Size)localObject4).getWidth();
      localObject4 = this.hrm;
      if (localObject4 == null) {
        p.gfZ();
      }
      ((SurfaceTexture)localObject3).setDefaultBufferSize(i, ((Size)localObject4).getHeight());
      ad.i(this.gio, "final set camera preview size: " + this.hrm + ", cropSize: " + this.hpQ);
      localObject3 = d.hrh;
      localObject4 = h.b(d.awU(), (Point)localObject1, paramInt, bool);
      localObject3 = localObject4;
      if (((h.c)localObject4).vOe == null)
      {
        localObject3 = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
        localObject4 = d.hrh;
        localObject3 = h.a(d.awT(), (Point)localObject3, this.hqb, bool);
      }
      if (((h.c)localObject3).vOe == null)
      {
        localObject4 = c.hqE;
        c.awC();
        ad.i(this.gio, "checkMore start %s", new Object[] { ((h.c)localObject3).toString() });
        ((h.c)localObject3).vOe = ((h.c)localObject3).vOh;
        ((h.c)localObject3).vOf = ((h.c)localObject3).vOi;
        ((h.c)localObject3).vOg = ((h.c)localObject3).vOj;
      }
      localObject4 = d.hrh;
      d.c((Point)localObject1);
      localObject1 = new Size(((h.c)localObject3).vOe.x, ((h.c)localObject3).vOe.y);
      paramInt = ((Size)localObject1).getWidth();
      i = ((Size)localObject1).getHeight();
      localObject1 = d.hrh;
      localObject1 = ImageReader.newInstance(paramInt, i, d.awP(), 1);
      ((ImageReader)localObject1).setOnImageAvailableListener(this.hrn.hqv, this.hrn.hqr);
      this.gtg = ((ImageReader)localObject1);
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
    p.h(paramString, "tag");
    b.a locala = com.tencent.mm.media.widget.b.a.a.b.hsL;
    if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axj()))
    {
      paramString = d.hrh;
      d.eo(paramBoolean);
    }
    for (;;)
    {
      awZ();
      AppMethodBeat.o(94159);
      return;
      locala = com.tencent.mm.media.widget.b.a.a.b.hsL;
      if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axo()))
      {
        paramString = d.hrh;
        d.ek(paramBoolean);
      }
      else
      {
        locala = com.tencent.mm.media.widget.b.a.a.b.hsL;
        if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axn()))
        {
          paramString = d.hrh;
          d.el(paramBoolean);
        }
        else
        {
          locala = com.tencent.mm.media.widget.b.a.a.b.hsL;
          if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axq()))
          {
            paramString = d.hrh;
            d.em(paramBoolean);
          }
          else
          {
            locala = com.tencent.mm.media.widget.b.a.a.b.hsL;
            if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axp()))
            {
              paramString = d.hrh;
              d.en(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94130);
    this.hrp.acquire();
    this.hrp.release();
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    b(paramSurfaceTexture, null, paramInt);
    AppMethodBeat.o(94130);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94131);
    this.hrp.acquire();
    this.hrp.release();
    super.a(paramSurfaceHolder, paramBoolean, paramInt);
    b(null, paramSurfaceHolder, paramInt);
    AppMethodBeat.o(94131);
  }
  
  public final void a(g paramg) {}
  
  public final void aa(String paramString, int paramInt)
  {
    AppMethodBeat.i(94160);
    p.h(paramString, "tag");
    Object localObject = d.hrh;
    localObject = this.hrr;
    if (localObject == null) {
      p.gfZ();
    }
    d.a((CaptureRequest.Builder)localObject, paramString, paramInt);
    awZ();
    AppMethodBeat.o(94160);
  }
  
  public final boolean awb()
  {
    AppMethodBeat.i(94158);
    this.hrv = true;
    Object localObject = d.hrh;
    d.en(true);
    localObject = c.hqE;
    c.awH();
    AppMethodBeat.o(94158);
    return true;
  }
  
  public final void awk()
  {
    AppMethodBeat.i(94138);
    if (!awa())
    {
      AppMethodBeat.o(94138);
      return;
    }
    this.hrn.removeCallbacks((Runnable)this.hrD);
    AppMethodBeat.o(94138);
  }
  
  public final com.tencent.mm.media.widget.a.b awl()
  {
    boolean bool = true;
    AppMethodBeat.i(94143);
    ad.m(this.gio, "generateCameraConfig", new Object[0]);
    if (this.hrq == null)
    {
      ad.i(this.gio, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94143);
      return null;
    }
    if (!awa())
    {
      ad.i(this.gio, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94143);
      return null;
    }
    Object localObject = com.tencent.mm.media.widget.a.b.hpt;
    com.tencent.mm.media.widget.a.b.nR(getPreviewWidth());
    localObject = com.tencent.mm.media.widget.a.b.hpt;
    com.tencent.mm.media.widget.a.b.nQ(getPreviewHeight());
    localObject = this.hru;
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
        localObject = com.tencent.mm.media.widget.a.b.hpt;
        com.tencent.mm.media.widget.a.b.nT(this.hph.rmx);
        localObject = com.tencent.mm.media.widget.a.b.hpt;
        com.tencent.mm.media.widget.a.b.nU(this.hph.rmy);
        if (i != 0)
        {
          localObject = com.tencent.mm.media.widget.a.b.hpt;
          i = com.tencent.mm.media.widget.a.b.awe();
          localObject = com.tencent.mm.media.widget.a.b.hpt;
          localObject = com.tencent.mm.media.widget.a.b.hpt;
          com.tencent.mm.media.widget.a.b.nT(com.tencent.mm.media.widget.a.b.awf());
          localObject = com.tencent.mm.media.widget.a.b.hpt;
          com.tencent.mm.media.widget.a.b.nU(i);
        }
        localObject = com.tencent.mm.media.widget.a.b.hpt;
        if (!awa()) {
          break label294;
        }
        localObject = d.hrh;
        i = d.awQ();
        label218:
        com.tencent.mm.media.widget.a.b.nS(i);
        localObject = com.tencent.mm.media.widget.a.b.hpt;
        if (this.hpc) {
          break label299;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.media.widget.a.b.setFrontCamera(bool);
      localObject = com.tencent.mm.media.widget.a.b.hpt;
      com.tencent.mm.media.widget.a.b.eh(this.hpe);
      localObject = this.hpi;
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
  
  public final int awp()
  {
    AppMethodBeat.i(94162);
    d locald = d.hrh;
    if (d.awO())
    {
      AppMethodBeat.o(94162);
      return 0;
    }
    AppMethodBeat.o(94162);
    return 1;
  }
  
  public final int awq()
  {
    AppMethodBeat.i(94163);
    d locald = d.hrh;
    int i = d.awQ();
    AppMethodBeat.o(94163);
    return i;
  }
  
  public final void awr()
  {
    this.hrE = 15;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94137);
    if (com.tencent.mm.compatible.util.d.lz(14))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if ((this.hrq == null) || (this.hrs == null))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if (!awa())
    {
      AppMethodBeat.o(94137);
      return;
    }
    this.hrn.removeCallbacks((Runnable)this.hrD);
    this.hrD.x = paramFloat1;
    this.hrD.y = paramFloat2;
    this.hrD.surfaceHeight = paramInt2;
    this.hrD.surfaceWidth = paramInt1;
    this.hrn.postDelayed((Runnable)this.hrD, 400L);
    AppMethodBeat.o(94137);
  }
  
  public final void b(g paramg) {}
  
  protected final boolean b(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94149);
    if (this.hrq == null)
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
          ad.i(this.gio, "support continuous picture");
          paramCameraCharacteristics = this.hrr;
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
          ad.i(this.gio, "support continuous video");
          paramCameraCharacteristics = this.hrr;
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
        ad.i(this.gio, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(94149);
        return false;
      }
      if (d.a.e.contains(paramCameraCharacteristics, 1))
      {
        ad.i(this.gio, "support auto focus");
        paramCameraCharacteristics = this.hrr;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        }
      }
      else
      {
        label217:
        ad.i(this.gio, "not support continuous video or auto focus");
      }
    }
  }
  
  public final Point ei(boolean paramBoolean)
  {
    AppMethodBeat.i(94146);
    if (!paramBoolean)
    {
      localPoint = new Point(this.hph.rmx, this.hph.rmy);
      AppMethodBeat.o(94146);
      return localPoint;
    }
    if (this.hpQ != null)
    {
      localPoint = this.hpQ;
      if (localPoint == null) {
        p.gfZ();
      }
      AppMethodBeat.o(94146);
      return localPoint;
    }
    Point localPoint = new Point(this.hph.rmx, this.hph.rmy);
    AppMethodBeat.o(94146);
    return localPoint;
  }
  
  public final void ej(boolean paramBoolean)
  {
    AppMethodBeat.i(94164);
    Object localObject = d.hrh;
    localObject = this.hrr;
    if (localObject == null) {
      p.gfZ();
    }
    d.a(paramBoolean, (CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94164);
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(94165);
    Object localObject = d.hrh;
    localObject = this.hrr;
    if (localObject == null) {
      p.gfZ();
    }
    int i = d.a((CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94165);
    return i;
  }
  
  public final float[] getSupportZoomRatios()
  {
    AppMethodBeat.i(94141);
    if ((this.hrz == null) && (this.hru != null))
    {
      localObject = this.hru;
      if (localObject == null) {
        p.gfZ();
      }
      localObject = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      if (localObject != null) {}
      for (float f = ((Float)localObject).floatValue();; f = 0.0F)
      {
        f = (int)(f * 10.0F) * 1.0F / 10.0F;
        this.hrz = new float[(int)(f * 10.0F)];
        int i = 0;
        int j = (int)(f * 10.0F);
        while (i < j)
        {
          localObject = this.hrz;
          if (localObject == null) {
            p.gfZ();
          }
          localObject[i] = (i * 1.0F / 10.0F + 1.0F);
          i += 1;
        }
      }
    }
    Object localObject = this.hrz;
    AppMethodBeat.o(94141);
    return localObject;
  }
  
  public final void j(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94140);
    if ((this.hrq != null) && (awa())) {}
    for (;;)
    {
      float f2;
      try
      {
        ad.d(this.gio, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (this.aYh)
        {
          ad.d(this.gio, "triggerSmallZoom, zooming, ignore");
          return;
        }
        this.aYh = true;
        localObject1 = this.hrr;
        if (localObject1 != null)
        {
          localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
          localObject3 = this.hru;
          if (localObject3 != null)
          {
            localObject3 = (Rect)((CameraCharacteristics)localObject3).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            if (localObject3 == null) {
              p.gfZ();
            }
            f1 = ((Rect)localObject3).width();
            if (localObject1 == null) {
              p.gfZ();
            }
            f2 = f1 / ((Rect)localObject1).width();
            localObject1 = this.hru;
            if (localObject1 == null) {
              p.gfZ();
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
        f2 = this.hrl + f2;
        if (f2 < f1) {
          break label542;
        }
        ad.d(this.gio, "triggerSmallZoom, nextZoom: %s", new Object[] { Float.valueOf(f1) });
        f2 = ((Rect)localObject3).width() / f1;
        f1 = ((Rect)localObject3).height() / f1;
        float f3 = (((Rect)localObject3).width() - f2) / 2.0F;
        float f4 = (((Rect)localObject3).height() - f1) / 2.0F;
        localObject1 = new Rect((int)f3, (int)f4, (int)(f2 + f3), (int)(f1 + f4));
        localObject3 = this.hrr;
        if (localObject3 != null) {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
        }
        paramBoolean = this.hry;
        if (paramBoolean) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        ad.e(this.gio, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYh = false;
        AppMethodBeat.o(94140);
      }
      try
      {
        localObject1 = this.hrs;
        if (localObject1 != null)
        {
          localObject3 = this.hrr;
          if (localObject3 == null) {
            p.gfZ();
          }
          ((CameraCaptureSession)localObject1).setRepeatingRequest(((CaptureRequest.Builder)localObject3).build(), (CameraCaptureSession.CaptureCallback)this.hrC, this.hrn.hqr);
        }
      }
      catch (CameraAccessException localCameraAccessException)
      {
        continue;
      }
      this.aYh = false;
      AppMethodBeat.o(94140);
      return;
      if (f2 == 1.0F)
      {
        this.aYh = false;
        AppMethodBeat.o(94140);
        return;
      }
      float f1 = this.hrl;
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
  
  public final boolean n(d.g.a.b<? super Bitmap, z> paramb)
  {
    c localc2 = null;
    AppMethodBeat.i(94157);
    p.h(paramb, "dataCallback");
    ad.i(this.gio, "takePhoto");
    a(a.a.hpn);
    Object localObject1 = d.hrh;
    localObject1 = d.awN();
    Object localObject2 = d.hrh;
    if (p.i(localObject1, d.nZ(d.hqG)))
    {
      localObject1 = c.hqE;
      c.awx();
      for (;;)
      {
        try
        {
          if (this.state != 0)
          {
            b(this.hru);
            localObject1 = this.hrr;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
            }
            localObject1 = this.hrr;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
            }
            localObject1 = this.hrr;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
            }
            localObject1 = this.hrr;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((CaptureRequest.Builder)localObject1).build();
            if (localObject1 == null) {
              p.gfZ();
            }
            this.hrt = ((CaptureRequest)localObject1);
            boolean bool = this.hry;
            if (bool) {}
          }
        }
        catch (Exception localException)
        {
          CaptureRequest.Builder localBuilder;
          localc2 = c.hqE;
          c.awy();
          ad.m(this.gio, "take photo in back camera error", new Object[] { localException });
          continue;
          localc1 = null;
          continue;
        }
        try
        {
          localObject1 = this.hrs;
          if (localObject1 != null)
          {
            localObject2 = this.hrt;
            if (localObject2 == null) {
              p.bcb("previewRequest");
            }
            ((CameraCaptureSession)localObject1).setRepeatingRequest((CaptureRequest)localObject2, (CameraCaptureSession.CaptureCallback)this.hrC, this.hrn.hqr);
          }
        }
        catch (CameraAccessException localCameraAccessException)
        {
          ad.e(this.gio, "setRepeatingRequest failed, errMsg: ");
        }
      }
      this.state = 0;
      this.hrn.removeCallbacks((Runnable)this.hrD);
      localObject1 = this.hrr;
      if (localObject1 != null) {
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      this.state = 1;
      if (!this.hry)
      {
        localObject1 = this.hrr;
        if (localObject1 == null) {
          break label417;
        }
        localObject1 = ((CaptureRequest.Builder)localObject1).build();
        if (localObject1 != null)
        {
          localObject2 = this.hrs;
          if (localObject2 != null)
          {
            localBuilder = this.hrr;
            localObject1 = localc2;
            if (localBuilder != null) {
              localObject1 = localBuilder.build();
            }
            if (localObject1 == null) {
              p.gfZ();
            }
            ((CameraCaptureSession)localObject2).capture((CaptureRequest)localObject1, (CameraCaptureSession.CaptureCallback)this.hrC, this.hrn.hqr);
          }
        }
      }
    }
    for (;;)
    {
      this.hrn.hqt = paramb;
      AppMethodBeat.o(94157);
      return true;
      localObject1 = null;
      break;
      label417:
      c localc1 = c.hqE;
      c.aww();
      awX();
    }
  }
  
  public final void nW(int paramInt)
  {
    AppMethodBeat.i(94139);
    if (this.hpR > 0)
    {
      AppMethodBeat.o(94139);
      return;
    }
    Object localObject = al.ci(aj.getContext());
    int i = ((Point)localObject).y;
    ad.i(this.gio, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94139);
      return;
    }
    try
    {
      localObject = this.hru;
      if (localObject == null) {
        p.gfZ();
      }
      localObject = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      if (localObject != null) {}
      for (float f = ((Float)localObject).floatValue();; f = 0.0F)
      {
        double d = f / (paramInt / 3.0D / 10.0D);
        if (d > 0.0D) {
          this.hpR = ((int)d + 1);
        }
        ad.i(this.gio, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.hpR), Float.valueOf(f) });
        AppMethodBeat.o(94139);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e(this.gio, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94139);
    }
  }
  
  public final void o(d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(94133);
    this.hqe = paramb;
    d locald = d.hrh;
    d.o(paramb);
    AppMethodBeat.o(94133);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(94156);
    Object localObject = this.hrn;
    f localf = ((a)localObject).hqu;
    if (localf != null) {
      localf.release();
    }
    localObject = ((a)localObject).hqs;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quitSafely();
      AppMethodBeat.o(94156);
      return;
    }
    AppMethodBeat.o(94156);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94155);
    super.release();
    if (this.hrq != null)
    {
      long l = bt.HI();
      ad.i(this.gio, "release camera beg, %s", new Object[] { Looper.myLooper() });
      this.hrn.removeCallbacksAndMessages(null);
      awW();
      localObject = this.mSurface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      ad.i(this.gio, "release camera end, use %dms, %s", new Object[] { Long.valueOf(bt.aO(l)), Looper.myLooper() });
    }
    this.hpQ = null;
    this.hqa = false;
    Object localObject = c.hqE;
    c.awv();
    AppMethodBeat.o(94155);
  }
  
  public final boolean s(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94128);
    p.h(paramContext, "context");
    try
    {
      localObject = aj.getContext().getSystemService("camera");
      if (localObject == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(94128);
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace(this.gio, (Throwable)paramContext, "init camera failed!", new Object[0]);
      paramContext = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auk();
      AppMethodBeat.o(94128);
      return false;
    }
    this.hqF = ((CameraManager)localObject);
    Object localObject = d.hrh;
    d.a(this.hqF);
    if (this.hqa)
    {
      ad.i(this.gio, "initCamera, already open");
      AppMethodBeat.o(94128);
      return true;
    }
    localObject = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.aui();
    super.s(paramContext, paramBoolean);
    release();
    awW();
    if (paramBoolean) {
      paramContext = d.hrh;
    }
    for (paramContext = d.nZ(d.hqG);; paramContext = d.nZ(d.hqH))
    {
      ad.m(this.gio, "use camera id %s, SrvDeviceInfo id %d", new Object[] { paramContext, Integer.valueOf(ae.gcE.fYD) });
      localObject = c.hqE;
      c.aws();
      localObject = this.context;
      if (localObject == null) {
        p.gfZ();
      }
      if (bt.checkPermission((Context)localObject, "android.permission.CAMERA")) {
        break;
      }
      ad.e(this.gio, "it was lack of the camera permision to open camera");
      AppMethodBeat.o(94128);
      return true;
      paramContext = d.hrh;
    }
    try
    {
      if (!this.hrp.tryAcquire(2500L, TimeUnit.MILLISECONDS))
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
      localObject = this.hqF;
      if (localObject == null) {
        p.gfZ();
      }
      ((CameraManager)localObject).openCamera(paramContext, (CameraDevice.StateCallback)this.hrB, this.hrn.hqr);
    }
    catch (CameraAccessException localCameraAccessException)
    {
      label348:
      break label348;
    }
    localObject = d.hrh;
    d.hqQ = paramContext;
    if (paramContext == null) {
      p.gfZ();
    }
    p.h(paramContext, "id");
    localObject = d.hqF;
    if (localObject != null) {}
    for (paramContext = ((CameraManager)localObject).getCameraCharacteristics(paramContext);; paramContext = null)
    {
      if (paramContext == null) {
        p.gfZ();
      }
      paramContext = paramContext.get(CameraCharacteristics.SENSOR_ORIENTATION);
      if (paramContext == null) {
        p.gfZ();
      }
      d.hqS = ((Number)paramContext).intValue();
      break;
    }
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(94166);
    Object localObject = d.hrh;
    CaptureRequest.Builder localBuilder = this.hrr;
    if (localBuilder == null) {
      p.gfZ();
    }
    p.h(localBuilder, "builder");
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
      localObject = d.hqF;
      if (localObject != null)
      {
        localObject = ((CameraManager)localObject).getCameraCharacteristics(d.hqQ);
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
    if (this.aYh)
    {
      ad.d(this.gio, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94142);
      return;
    }
    if ((this.hru != null) && (this.hrr != null)) {
      try
      {
        localObject1 = this.hru;
        if (localObject1 == null) {
          p.gfZ();
        }
        localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (localObject1 == null) {
          p.gfZ();
        }
        int i = ((Rect)localObject1).width() - d.h.a.co(((Rect)localObject1).width() / paramFloat);
        int j = ((Rect)localObject1).height() - d.h.a.co(((Rect)localObject1).height() / paramFloat);
        this.hrx = new Rect(i / 2, j / 2, ((Rect)localObject1).width() - i / 2, ((Rect)localObject1).height() - j / 2);
        localObject1 = this.hrr;
        if (localObject1 == null) {
          p.gfZ();
        }
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.SCALER_CROP_REGION, this.hrx);
        boolean bool = this.hry;
        if (bool) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        label237:
        ad.e(this.gio, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYh = false;
        AppMethodBeat.o(94142);
      }
    }
    try
    {
      localObject1 = this.hrs;
      if (localObject1 != null)
      {
        CaptureRequest.Builder localBuilder = this.hrr;
        if (localBuilder == null) {
          p.gfZ();
        }
        ((CameraCaptureSession)localObject1).setRepeatingRequest(localBuilder.build(), (CameraCaptureSession.CaptureCallback)this.hrC, this.hrn.hqr);
      }
    }
    catch (CameraAccessException localCameraAccessException)
    {
      break label237;
    }
    this.aYh = false;
    AppMethodBeat.o(94142);
    return;
    AppMethodBeat.o(94142);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1", "Ljava/lang/Runnable;", "surfaceHeight", "", "getSurfaceHeight", "()I", "setSurfaceHeight", "(I)V", "surfaceWidth", "getSurfaceWidth", "setSurfaceWidth", "x", "", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "run", "", "plugin-mediaeditor_release"})
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
      e.a(this.hrI, this.x, this.y, this.surfaceWidth, this.surfaceHeight);
      AppMethodBeat.o(94117);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/widget/camera2/CommonCamera2$captureStillPicture$2$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "onCaptureCompleted", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "result", "Landroid/hardware/camera2/TotalCaptureResult;", "plugin-mediaeditor_release"})
  public static final class c
    extends CameraCaptureSession.CaptureCallback
  {
    c(e parame) {}
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(94118);
      p.h(paramCameraCaptureSession, "session");
      p.h(paramCaptureRequest, "request");
      p.h(paramTotalCaptureResult, "result");
      paramCameraCaptureSession = d.hrh;
      paramCameraCaptureSession = e.a(this.hrI);
      if (paramCameraCaptureSession == null) {
        p.gfZ();
      }
      d.g(paramCameraCaptureSession);
      AppMethodBeat.o(94118);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "camera", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "plugin-mediaeditor_release"})
  public static final class d
    extends CameraDevice.StateCallback
  {
    public final void onDisconnected(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94120);
      p.h(paramCameraDevice, "camera");
      e.g(this.hrI).release();
      paramCameraDevice.close();
      e.a(this.hrI, null);
      AppMethodBeat.o(94120);
    }
    
    public final void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      AppMethodBeat.i(94121);
      p.h(paramCameraDevice, "camera");
      onDisconnected(paramCameraDevice);
      AppMethodBeat.o(94121);
    }
    
    public final void onOpened(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94119);
      p.h(paramCameraDevice, "camera");
      e.g(this.hrI).release();
      e.a(this.hrI, paramCameraDevice);
      AppMethodBeat.o(94119);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "capturePicture", "", "result", "Landroid/hardware/camera2/CaptureResult;", "checkFocusEnd", "", "onCaptureCompleted", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "Landroid/hardware/camera2/TotalCaptureResult;", "onCaptureProgressed", "partialResult", "process", "plugin-mediaeditor_release"})
  public static final class e
    extends CameraCaptureSession.CaptureCallback
  {
    private final void b(CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94122);
      switch (e.h(this.hrI))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94122);
        return;
        Object localObject = d.hrh;
        d.a(paramCaptureResult);
        AppMethodBeat.o(94122);
        return;
        localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if ((localObject == null) || (2 == ((Integer)localObject).intValue()) || (6 == ((Integer)localObject).intValue()))
        {
          e.i(this.hrI);
          AppMethodBeat.o(94122);
          return;
        }
        if ((4 == ((Integer)localObject).intValue()) || (5 == ((Integer)localObject).intValue()))
        {
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 2))
          {
            e.i(this.hrI);
            AppMethodBeat.o(94122);
            return;
          }
          e.j(this.hrI);
        }
        AppMethodBeat.o(94122);
        return;
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 5) || (paramCaptureResult.intValue() == 4))
        {
          e.a(this.hrI, 3);
          AppMethodBeat.o(94122);
          return;
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() != 5))
          {
            e.i(this.hrI);
            AppMethodBeat.o(94122);
            return;
            if (this.hrI.awa())
            {
              p.h(paramCaptureResult, "result");
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
                if ((i == 0) || (e.d(this.hrI))) {
                  break label534;
                }
                ad.i(e.k(this.hrI), "STATE_TOUCH_CAF_WAITING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
                this.hrI.b(e.l(this.hrI));
                paramCaptureResult = e.a(this.hrI);
                if (paramCaptureResult != null) {
                  paramCaptureResult.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                }
                localObject = this.hrI;
                paramCaptureResult = e.a(this.hrI);
                if (paramCaptureResult == null) {
                  break label513;
                }
              }
              label513:
              for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
              {
                if (paramCaptureResult == null) {
                  p.gfZ();
                }
                e.a((e)localObject, paramCaptureResult);
                try
                {
                  paramCaptureResult = e.e(this.hrI);
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(e.m(this.hrI), (CameraCaptureSession.CaptureCallback)this, this.hrI.hrn.hqr);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    ad.e(e.b(this.hrI), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                e.a(this.hrI, 6);
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
            ad.e(e.b(this.hrI), "current is not allowed to do anything casue capturing");
            AppMethodBeat.o(94122);
            return;
            if ((this.hrI.awa()) && (!e.d(this.hrI)))
            {
              ad.i(e.k(this.hrI), "STATE_TOUCH_FOCUSING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
              paramCaptureResult = e.a(this.hrI);
              if (paramCaptureResult != null) {
                paramCaptureResult.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
              }
              paramCaptureResult = e.a(this.hrI);
              if (paramCaptureResult != null) {
                paramCaptureResult.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
              }
              localObject = this.hrI;
              paramCaptureResult = e.a(this.hrI);
              if (paramCaptureResult != null) {}
              for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
              {
                if (paramCaptureResult == null) {
                  p.gfZ();
                }
                e.a((e)localObject, paramCaptureResult);
                try
                {
                  paramCaptureResult = e.e(this.hrI);
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(e.m(this.hrI), (CameraCaptureSession.CaptureCallback)this, this.hrI.hrn.hqr);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    ad.e(e.b(this.hrI), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                e.a(this.hrI, 0);
                AppMethodBeat.o(94122);
                return;
              }
            }
            ad.e(e.b(this.hrI), "current is not allowed to do anything casue capturing");
          }
        }
      }
    }
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(94124);
      p.h(paramCameraCaptureSession, "session");
      p.h(paramCaptureRequest, "request");
      p.h(paramTotalCaptureResult, "result");
      b((CaptureResult)paramTotalCaptureResult);
      AppMethodBeat.o(94124);
    }
    
    public final void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94123);
      p.h(paramCameraCaptureSession, "session");
      p.h(paramCaptureRequest, "request");
      p.h(paramCaptureResult, "partialResult");
      b(paramCaptureResult);
      AppMethodBeat.o(94123);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onClosed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigureFailed", "onConfigured", "plugin-mediaeditor_release"})
  public static final class f
    extends CameraCaptureSession.StateCallback
  {
    public final void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94127);
      p.h(paramCameraCaptureSession, "session");
      super.onClosed(paramCameraCaptureSession);
      ad.i(e.b(this.hrI), "session on close");
      e.a(this.hrI, true);
      AppMethodBeat.o(94127);
    }
    
    public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94126);
      p.h(paramCameraCaptureSession, "session");
      ad.i(e.b(this.hrI), "configure failed ");
      paramCameraCaptureSession = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auk();
      paramCameraCaptureSession = c.hqE;
      c.awu();
      AppMethodBeat.o(94126);
    }
    
    public final void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94125);
      p.h(paramCameraCaptureSession, "session");
      ad.i(e.b(this.hrI), "session on onConfigured");
      if (e.c(this.hrI) == null)
      {
        AppMethodBeat.o(94125);
        return;
      }
      e.a(this.hrI, false);
      e.a(this.hrI, paramCameraCaptureSession);
      paramCameraCaptureSession = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auj();
      paramCameraCaptureSession = c.hqE;
      c.awt();
      e.f(this.hrI);
      AppMethodBeat.o(94125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e
 * JD-Core Version:    0.7.0.1
 */