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
import com.tencent.mm.ui.ai;
import d.a.j;
import d.v;
import d.y;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "useBack", "", "(Landroid/content/Context;Z)V", "DEFAULT_UPPER_BOUND", "", "FOCUS_TAG", "", "FOCUS_TAG$1", "SMALL_ZOOM_STEP_NUM", "getSMALL_ZOOM_STEP_NUM", "()I", "SMALL_ZOOM_STEP_NUM$1", "SMALL_ZOOM_STEP_UPPER_BOUND", "getSMALL_ZOOM_STEP_UPPER_BOUND", "SMALL_ZOOM_STEP_UPPER_BOUND$1", "SMALL_ZOOM_STEP_VAL", "", "TAG", "TAG$1", "autoFocusRunnable", "com/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1;", "cropSize", "Landroid/graphics/Point;", "imageReader", "Landroid/media/ImageReader;", "isCameraOpen", "isUseRecordStream", "isZooming", "mCameraDevice", "Landroid/hardware/camera2/CameraDevice;", "mCameraDeviceCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1;", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "mCameraOpenCloseLock", "Ljava/util/concurrent/Semaphore;", "mCaptureCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1;", "mCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "mCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "mFpsValuev", "getMFpsValuev", "setMFpsValuev", "(I)V", "mIsNoAFRun", "mIsSessionClose", "mPreviewBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "mPreviewSize", "Landroid/util/Size;", "mStateCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1;", "mSurface", "Landroid/view/Surface;", "mZoomTimesToRatio", "", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "previewRequest", "Landroid/hardware/camera2/CaptureRequest;", "scrollSmallZoomStep", "sightHandler", "Lcom/tencent/mm/media/widget/camera2/Camera2Handler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera2/Camera2Handler;", "smallZoomStep", "state", "zoomOutRect", "Landroid/graphics/Rect;", "abandonFocus", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateTapArea", "x", "y", "surfaceWidth", "surfaceHeight", "captureStillPicture", "clamp", "min", "max", "closeCamera", "configVendorTagValue", "tag", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraOrientation", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "getPreviewWidth", "getSupportZoomRatios", "initCamera", "initRawRatios", "lock3AParams", "builder", "lockFocus", "onDestroy", "openCamera", "nowCameraId", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "resumePreview", "runPrecaptureSequence", "safeResetZoom", "safeSetFocusMode", "characteristics", "safeSetMetering", "safeSetOIS", "safeSetPreviewFrameRate", "useFixMode", "safeSetStabilization", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "safeSetVendorEffect", "selectNoCropPreviewSize", "resolutionLimit", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setSafeConfig", "startPreview", "useCpuCrop", "surface", "startPreviewWithGPU", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "trySetPreviewFrameRateParameters", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends com.tencent.mm.media.widget.a.a
{
  private static final SparseIntArray gza;
  public static final e.a gzb;
  private int KBO;
  private boolean aMX;
  private final String fLc;
  private ImageReader fVP;
  private d.g.a.b<? super Boolean, y> gxB;
  private Point gxn;
  private int gxo;
  private boolean gxx;
  private final int gxy;
  private final String gyE;
  private final int gyF;
  private final int gyG;
  private final float gyH;
  private Size gyI;
  final a gyJ;
  private float gyK;
  private final Semaphore gyL;
  private CameraDevice gyM;
  private CaptureRequest.Builder gyN;
  private CameraCaptureSession gyO;
  private CaptureRequest gyP;
  private CameraCharacteristics gyQ;
  private boolean gyR;
  private boolean gyS;
  private Rect gyT;
  private boolean gyU;
  private float[] gyV;
  private final f gyW;
  private final d gyX;
  private final e gyY;
  private final b gyZ;
  private CameraManager gyb;
  private Surface mSurface;
  private int state;
  
  static
  {
    AppMethodBeat.i(94168);
    gzb = new e.a((byte)0);
    SparseIntArray localSparseIntArray = new SparseIntArray();
    gza = localSparseIntArray;
    localSparseIntArray.append(0, 90);
    gza.append(1, 0);
    gza.append(2, 270);
    gza.append(3, 180);
    AppMethodBeat.o(94168);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94167);
    this.fLc = "MicroMsg.CommonCamera2";
    this.gyE = "MicroMsg.CommonCamera2.FoucsTag";
    this.gyF = 5;
    this.gyG = 20;
    this.gyH = 0.1F;
    Object localObject = Looper.getMainLooper();
    d.g.b.k.g(localObject, "Looper.getMainLooper()");
    this.gyJ = new a((Looper)localObject, paramContext);
    this.gxo = -1;
    this.gyK = -1.0F;
    this.gxy = 2100;
    this.gyL = new Semaphore(1);
    if (com.tencent.mm.media.widget.d.a.aoJ())
    {
      paramContext = new com.tencent.mm.media.widget.b.a.c(paramContext);
      localObject = (d.g.a.q)e.1.gzc;
      d.g.b.k.h(localObject, "mSupportWCKeyAvailable");
      new Thread((Runnable)new c.a(paramContext, (d.g.a.a)new c.b(paramContext, (d.g.a.q)localObject))).start();
      paramContext = d.gyD;
      d.anm();
    }
    this.gyW = new f(this);
    this.gyX = new d(this);
    this.gyY = new e(this);
    this.gyZ = new b(this);
    AppMethodBeat.o(94167);
  }
  
  private final void a(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94148);
    if (ae.fFw.fBm > 0)
    {
      ad.i(this.gww, "set frame rate > 0, do not try set preview fps range");
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
    int k = -2147483648;
    int j = -2147483648;
    i = 0;
    int n = paramCameraCharacteristics.length;
    int m = 0;
    Integer localInteger2;
    if (m < n)
    {
      localInteger2 = paramCameraCharacteristics[m];
      if (localInteger2 == null) {}
      Integer localInteger1;
      int i1;
      do
      {
        m += 1;
        break;
        localInteger1 = (Integer)localInteger2.getLower();
        localInteger2 = (Integer)localInteger2.getUpper();
        ad.i(this.fLc, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(m), localInteger1, localInteger2 });
        if (d.g.b.k.compare(localInteger1.intValue(), 0) < 0) {
          break label216;
        }
        i1 = localInteger2.intValue();
        d.g.b.k.g(localInteger1, "min");
      } while (d.g.b.k.compare(i1, localInteger1.intValue()) < 0);
      label216:
      if ((d.g.b.k.compare(localInteger2.intValue(), j) < 0) || (i != 0)) {
        break label477;
      }
      k = localInteger1.intValue();
      d.g.b.k.g(localInteger2, "max");
      j = localInteger2.intValue();
    }
    label474:
    label477:
    for (;;)
    {
      if (this.KBO != 0)
      {
        if (d.g.b.k.compare(localInteger2.intValue(), this.KBO * 1000) < 0) {
          break label474;
        }
        i = 1;
        break;
      }
      if (d.g.b.k.compare(localInteger2.intValue(), 30000) >= 0)
      {
        i = 1;
        break;
        ad.i(this.gww, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(30) });
        if ((k == 2147483647) || (j == 2147483647))
        {
          AppMethodBeat.o(94148);
          return;
        }
        try
        {
          paramCameraCharacteristics = this.gyN;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range((Comparable)Integer.valueOf(k), (Comparable)Integer.valueOf(j)));
          }
          ad.i(this.gww, "set fps range %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
          AppMethodBeat.o(94148);
          return;
        }
        catch (Exception paramCameraCharacteristics)
        {
          ad.i(this.gww, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
          AppMethodBeat.o(94148);
          return;
        }
      }
      break;
    }
  }
  
  private final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    Object localObject1 = null;
    Surface localSurface = null;
    AppMethodBeat.i(94135);
    Object localObject2 = this.gyN;
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
          paramSurfaceTexture = d.gyD;
          if (!d.anp()) {
            break label456;
          }
          if (!this.gyR) {
            break label279;
          }
          paramSurfaceTexture = d.gyD;
          paramSurfaceTexture = this.gyN;
          if (paramSurfaceTexture == null) {
            d.g.b.k.fvU();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.gAi;
          j = d.a(paramSurfaceTexture, j.listOf(com.tencent.mm.media.widget.b.a.a.b.anK()));
          i = j;
          if (Build.VERSION.SDK_INT < 28) {
            break label445;
          }
          paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration(this.mSurface)), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.gyW);
          paramSurfaceHolder = this.gyM;
          if (paramSurfaceHolder == null) {
            d.g.b.k.fvU();
          }
          paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
          if (j == 0)
          {
            paramSurfaceHolder = this.gyM;
            if (paramSurfaceHolder == null) {
              d.g.b.k.fvU();
            }
            localObject1 = this.mSurface;
            localObject2 = this.fVP;
            paramSurfaceTexture = localSurface;
            if (localObject2 != null) {
              paramSurfaceTexture = ((ImageReader)localObject2).getSurface();
            }
            paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localObject1, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.gyW, this.gyJ.gxN);
          }
        }
        for (;;)
        {
          ad.i(this.fLc, "doStartPreview finish");
          AppMethodBeat.o(94135);
          return true;
          if (paramSurfaceHolder == null) {
            break;
          }
          this.mSurface = paramSurfaceHolder.getSurface();
          break;
          label279:
          paramSurfaceTexture = d.gyD;
          paramSurfaceTexture = this.gyN;
          if (paramSurfaceTexture == null) {
            d.g.b.k.fvU();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.gAi;
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.anJ();
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.gAi;
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.anI();
          localObject2 = com.tencent.mm.media.widget.b.a.a.b.gAi;
          j = d.a(paramSurfaceTexture, j.listOf(new String[] { paramSurfaceHolder, localObject1, com.tencent.mm.media.widget.b.a.a.b.anL() }));
          i = j;
          if (Build.VERSION.SDK_INT >= 28)
          {
            paramSurfaceHolder = new OutputConfiguration(this.mSurface);
            paramSurfaceTexture = this.fVP;
            if (paramSurfaceTexture == null) {
              break label451;
            }
          }
          label445:
          label451:
          for (paramSurfaceTexture = paramSurfaceTexture.getSurface();; paramSurfaceTexture = null)
          {
            paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration[] { paramSurfaceHolder, new OutputConfiguration(paramSurfaceTexture) }), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.gyW);
            paramSurfaceHolder = this.gyM;
            if (paramSurfaceHolder == null) {
              d.g.b.k.fvU();
            }
            paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
            i = j;
            j = i;
            break;
          }
          label456:
          paramSurfaceHolder = this.gyM;
          if (paramSurfaceHolder == null) {
            d.g.b.k.fvU();
          }
          localSurface = this.mSurface;
          localObject2 = this.fVP;
          paramSurfaceTexture = (SurfaceTexture)localObject1;
          if (localObject2 != null) {
            paramSurfaceTexture = ((ImageReader)localObject2).getSurface();
          }
          paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localSurface, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.gyW, this.gyJ.gxN);
        }
      }
      ad.i(this.fLc, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.akD();
      paramSurfaceTexture = c.gya;
      c.amO();
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
        if (ae.fFw.fBm > 0) {
          ad.i(this.gww, "set frame rate > 0, do not try set preview frame rate");
        }
        for (;;)
        {
          paramCameraCharacteristics = this.gyN;
          if (paramCameraCharacteristics != null)
          {
            paramCameraCharacteristics = (Range)paramCameraCharacteristics.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
            label61:
            ad.i(this.gww, "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), paramCameraCharacteristics });
            AppMethodBeat.o(94147);
            return true;
            if (paramCameraCharacteristics == null)
            {
              ad.e(this.fLc, "trySetPreviewFrameRateParameters error, p is null!");
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
              else if (this.KBO == 0)
              {
                i = Math.min(30, i);
                paramCameraCharacteristics = new Range((Comparable)Integer.valueOf(i), (Comparable)Integer.valueOf(i));
                localObject = this.gyN;
                if (localObject == null) {
                  continue;
                }
                ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, paramCameraCharacteristics);
              }
            }
            catch (Exception paramCameraCharacteristics)
            {
              ad.i(this.gww, "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
            }
          }
        }
      }
      catch (Exception paramCameraCharacteristics)
      {
        ad.i(this.gww, "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
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
      int i = Math.min(this.KBO, i);
      continue;
      a(paramCameraCharacteristics);
      break;
      paramCameraCharacteristics = null;
      break label61;
      j += 1;
    }
  }
  
  private final void amE()
  {
    AppMethodBeat.i(94136);
    Integer localInteger = Integer.valueOf(0);
    Object localObject = com.tencent.mm.plugin.mmsight.model.a.k.cQk();
    d.g.b.k.g(localObject, "MMSightController.getInstance()");
    if (((com.tencent.mm.plugin.mmsight.model.a.k)localObject).cQl() != null)
    {
      localObject = com.tencent.mm.plugin.mmsight.model.a.k.cQk();
      d.g.b.k.g(localObject, "MMSightController.getInstance()");
      localInteger = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.a.k)localObject).cQl().tBj);
    }
    String str = this.fLc;
    boolean bool1;
    label92:
    boolean bool2;
    label104:
    boolean bool3;
    label116:
    boolean bool4;
    if (ae.fFw.fBr == 1)
    {
      localObject = "Range";
      if (ae.fFw.fBs != 1) {
        break label399;
      }
      bool1 = true;
      if (ae.fFw.fBt != 1) {
        break label404;
      }
      bool2 = true;
      if (ae.fFw.fBu != 1) {
        break label409;
      }
      bool3 = true;
      if (ae.fFw.fBv != 1) {
        break label414;
      }
      bool4 = true;
      label129:
      ad.i(str, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if ((ae.fFw.fBr != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 1))) {
        break label420;
      }
      a(this.gyQ, false);
    }
    for (;;)
    {
      if ((ae.fFw.fBs == 1) && (localInteger.intValue() != 0)) {
        localInteger.intValue();
      }
      if ((ae.fFD.fEk != -1) && (ae.fFD.fEk == 1) && (com.tencent.mm.compatible.util.d.lh(14))) {
        c(this.gyQ);
      }
      if ((ae.fFw.fBu == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
        b(this.gyQ);
      }
      if ((ae.fFw.fBv == 1) && (localInteger.intValue() != 0)) {
        localInteger.intValue();
      }
      amH();
      ant();
      localObject = this.gyN;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      h((CaptureRequest.Builder)localObject);
      AppMethodBeat.o(94136);
      return;
      if (ae.fFw.fBq == 1)
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
      if ((ae.fFw.fBq == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 5))) {
        a(this.gyQ, true);
      }
    }
  }
  
  private void amH()
  {
    AppMethodBeat.i(94150);
    Object localObject = this.gyQ;
    if (localObject != null) {
      localObject = (Rect)((CameraCharacteristics)localObject).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }
    while (localObject != null)
    {
      localObject = new Rect(((Rect)localObject).left * 1, ((Rect)localObject).top * 1, ((Rect)localObject).right * 1, ((Rect)localObject).bottom * 1);
      CaptureRequest.Builder localBuilder = this.gyN;
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
  
  private final void anq()
  {
    AppMethodBeat.i(94129);
    try
    {
      if (this.gyN != null)
      {
        localObject1 = d.gyD;
        localObject1 = this.gyN;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        d.g((CaptureRequest.Builder)localObject1);
      }
      this.gyL.acquire();
      Object localObject1 = this.gyO;
      if (localObject1 != null) {
        ((CameraCaptureSession)localObject1).close();
      }
      this.gyO = null;
      localObject1 = this.gyM;
      if (localObject1 != null) {
        ((CameraDevice)localObject1).close();
      }
      this.gyM = null;
      localObject1 = this.fVP;
      if (localObject1 != null) {
        ((ImageReader)localObject1).setOnImageAvailableListener(null, this.gyJ.gxN);
      }
      localObject1 = this.fVP;
      if (localObject1 != null) {
        ((ImageReader)localObject1).close();
      }
      this.fVP = null;
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
      this.gyL.release();
      AppMethodBeat.o(94129);
    }
  }
  
  private final void ans()
  {
    Object localObject2 = null;
    AppMethodBeat.i(94134);
    try
    {
      if (this.state == 4)
      {
        ad.m(this.fLc, "capture still picture more than twice", new Object[0]);
        AppMethodBeat.o(94134);
        return;
      }
      this.state = 4;
      ad.i(this.fLc, "captureStillPicture");
      if (this.gyM == null)
      {
        AppMethodBeat.o(94134);
        return;
      }
    }
    catch (Exception localException)
    {
      localObject2 = d.gyD;
      if (!d.ani())
      {
        localObject2 = c.gya;
        c.amT();
      }
      ad.e(this.fLc, localException.toString());
      AppMethodBeat.o(94134);
      return;
    }
    Object localObject1 = this.gyN;
    Object localObject3;
    label190:
    label255:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
      if ((this.gyM == null) || (this.gyU))
      {
        AppMethodBeat.o(94134);
        return;
      }
      localObject3 = this.gyM;
      if (localObject3 != null)
      {
        localObject3 = ((CameraDevice)localObject3).createCaptureRequest(2);
        if (localObject3 != null)
        {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
          localObject1 = this.fVP;
          if (localObject1 == null) {
            break label531;
          }
          localObject1 = ((ImageReader)localObject1).getSurface();
          ((CaptureRequest.Builder)localObject3).addTarget((Surface)localObject1);
          localObject1 = this.fVP;
          if (localObject1 != null) {
            ((ImageReader)localObject1).setOnImageAvailableListener(this.gyJ.gxR, this.gyJ.gxN);
          }
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
          localObject1 = this.gyQ;
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
          this.gyS = bool;
          if (!this.gyS)
          {
            localObject1 = this.gyQ;
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
        localObject1 = this.gyQ;
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
        this.gyN = ((CaptureRequest.Builder)localObject1);
        localObject3 = this.gyO;
        if (localObject3 == null) {
          break label514;
        }
        ((CameraCaptureSession)localObject3).stopRepeating();
        ad.i(this.gyE, "this time happened a cancel auto foucs while capture");
        localObject1 = this.gyN;
        if (localObject1 != null) {
          ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
        }
        CaptureRequest.Builder localBuilder = this.gyN;
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
  
  private final void ant()
  {
    AppMethodBeat.i(94151);
    Object localObject = this.gyQ;
    if (localObject != null)
    {
      localObject = (int[])((CameraCharacteristics)localObject).get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
      if (localObject == null) {
        break label146;
      }
      ad.i(this.fLc, "oisMode:" + Arrays.toString((int[])localObject));
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
      localObject = c.gya;
      c.amU();
      localObject = d.gyD;
      d.dQ(false);
      localObject = this.gyN;
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
  
  private final void anu()
  {
    AppMethodBeat.i(94161);
    if (this.gyN == null)
    {
      AppMethodBeat.o(94161);
      return;
    }
    if ((this.gyM != null) && (!this.gyU))
    {
      Object localObject = this.gyN;
      if (localObject != null) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      }
      localObject = this.gyN;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      h((CaptureRequest.Builder)localObject);
      CameraCaptureSession localCameraCaptureSession = this.gyO;
      if (localCameraCaptureSession != null)
      {
        localObject = this.gyN;
        if (localObject != null) {}
        for (localObject = ((CaptureRequest.Builder)localObject).build();; localObject = null)
        {
          localCameraCaptureSession.setRepeatingRequest((CaptureRequest)localObject, (CameraCaptureSession.CaptureCallback)this.gyY, this.gyJ.gxN);
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
    long l = bt.GC();
    ad.i(this.fLc, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (amv())
    {
      ad.i(this.fLc, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94132);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.gyR) {
          continue;
        }
        localCameraDevice = this.gyM;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(3);
        }
        this.gyN = localBuilder;
        mL(paramInt);
        amE();
        if (a(paramSurfaceTexture, paramSurfaceHolder))
        {
          a(a.a.gwJ);
          this.state = 0;
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        CameraDevice localCameraDevice;
        ad.e(this.fLc, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.akD();
        continue;
      }
      ad.i(this.fLc, "start preview end, use %dms %s", new Object[] { Long.valueOf(bt.aS(l)), Looper.myLooper() });
      AppMethodBeat.o(94132);
      return;
      localCameraDevice = this.gyM;
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
      ad.i(this.fLc, "safeSetMetering");
      Rect localRect = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
      MeteringRectangle[] arrayOfMeteringRectangle = new MeteringRectangle[1];
      if (localRect != null) {}
      for (paramCameraCharacteristics = Integer.valueOf(localRect.right);; paramCameraCharacteristics = null)
      {
        if (paramCameraCharacteristics == null) {
          d.g.b.k.fvU();
        }
        arrayOfMeteringRectangle[0] = new MeteringRectangle(paramCameraCharacteristics.intValue() / 2 - 500, localRect.bottom / 2 - 500, 1000, 1000, 0);
        paramCameraCharacteristics = this.gyN;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.gyN;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.gyN;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        }
        paramCameraCharacteristics = this.gyN;
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
      ad.i(this.fLc, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
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
    if (this.gyM == null)
    {
      AppMethodBeat.o(94144);
      return 0;
    }
    try
    {
      if ((this.gwB) && (this.gxn != null))
      {
        Point localPoint = this.gxn;
        if (localPoint == null) {
          d.g.b.k.fvU();
        }
        i = localPoint.y;
        AppMethodBeat.o(94144);
        return i;
      }
      int i = this.gwE.pUd;
      AppMethodBeat.o(94144);
      return i;
    }
    catch (Exception localException)
    {
      ad.e(this.fLc, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94144);
    }
    return 0;
  }
  
  private final int getPreviewWidth()
  {
    AppMethodBeat.i(94145);
    if (this.gyM == null)
    {
      AppMethodBeat.o(94145);
      return 0;
    }
    if (this.gyb != null) {
      try
      {
        if ((this.gwB) && (this.gxn != null))
        {
          Point localPoint = this.gxn;
          if (localPoint == null) {
            d.g.b.k.fvU();
          }
          i = localPoint.x;
          AppMethodBeat.o(94145);
          return i;
        }
        int i = this.gwE.pUc;
        AppMethodBeat.o(94145);
        return i;
      }
      catch (Exception localException)
      {
        ad.e(this.fLc, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94145);
    return 0;
  }
  
  private static void h(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94152);
    d locald = d.gyD;
    d.b(paramBuilder);
    locald = d.gyD;
    d.d(paramBuilder);
    locald = d.gyD;
    d.e(paramBuilder);
    locald = d.gyD;
    d.c(paramBuilder);
    locald = d.gyD;
    d.f(paramBuilder);
    AppMethodBeat.o(94152);
  }
  
  private final boolean mL(int paramInt)
  {
    AppMethodBeat.i(94154);
    for (;;)
    {
      try
      {
        localObject1 = this.gyb;
        if (localObject1 == null) {
          break label870;
        }
        localObject3 = d.gyD;
        localObject3 = d.anh();
        if (localObject3 == null) {
          d.g.b.k.fvU();
        }
        localObject1 = ((CameraManager)localObject1).getCameraCharacteristics((String)localObject3);
        this.gyQ = ((CameraCharacteristics)localObject1);
        localObject1 = d.gyD;
        if (d.ank() == 90) {
          break label865;
        }
        localObject1 = d.gyD;
        if (d.ank() != 270) {
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
        ad.printErrStackTrace(this.fLc, (Throwable)localCameraAccessException, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", new Object[] { Looper.myLooper(), localCameraAccessException.getMessage() });
        AppMethodBeat.o(94154);
        return false;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(this.fLc, (Throwable)localException, "selectNoCropPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(94154);
        return false;
      }
      if (this.gwH == null)
      {
        localObject1 = com.tencent.mm.plugin.mmsight.d.fv(this.context);
        localObject3 = d.gyD;
        localObject4 = h.b(d.ann(), (Point)localObject1, paramInt, bool);
        localObject3 = localObject4;
        if (((h.c)localObject4).tCB == null)
        {
          ad.e(this.fLc, "fuck, preview size still null!!");
          localObject3 = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
          localObject4 = d.gyD;
          localObject3 = h.a(d.ann(), (Point)localObject3, this.gxy, bool);
        }
        if (((h.c)localObject3).tCB == null)
        {
          ad.i(this.fLc, "checkMore start %s", new Object[] { ((h.c)localObject3).toString() });
          ((h.c)localObject3).tCB = ((h.c)localObject3).tCE;
          ((h.c)localObject3).tCC = ((h.c)localObject3).tCF;
          ((h.c)localObject3).tCD = ((h.c)localObject3).tCG;
        }
        this.gyI = new Size(((h.c)localObject3).tCB.x, ((h.c)localObject3).tCB.y);
        if (this.gyI == null)
        {
          com.tencent.mm.plugin.mmsight.model.l.amV();
          localObject1 = c.gya;
          c.amV();
          AppMethodBeat.o(94154);
          return false;
        }
      }
      else
      {
        localObject1 = this.gwH;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        i = ((Size)localObject1).getWidth();
        localObject1 = this.gwH;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        localObject1 = new Point(i, ((Size)localObject1).getHeight());
        continue;
      }
      localObject4 = this.gwE;
      localSize = this.gyI;
      if (localSize == null) {
        d.g.b.k.fvU();
      }
      ((com.tencent.mm.plugin.mmsight.model.q)localObject4).pUc = localSize.getWidth();
      localObject4 = this.gwE;
      localSize = this.gyI;
      if (localSize == null) {
        d.g.b.k.fvU();
      }
      ((com.tencent.mm.plugin.mmsight.model.q)localObject4).pUd = localSize.getHeight();
      if (((h.c)localObject3).tCD != null) {
        this.gxn = ((h.c)localObject3).tCD;
      }
      localObject3 = this.surfaceTexture;
      if (localObject3 == null) {
        d.g.b.k.fvU();
      }
      localObject4 = this.gyI;
      if (localObject4 == null) {
        d.g.b.k.fvU();
      }
      i = ((Size)localObject4).getWidth();
      localObject4 = this.gyI;
      if (localObject4 == null) {
        d.g.b.k.fvU();
      }
      ((SurfaceTexture)localObject3).setDefaultBufferSize(i, ((Size)localObject4).getHeight());
      ad.i(this.fLc, "final set camera preview size: " + this.gyI + ", cropSize: " + this.gxn);
      localObject3 = d.gyD;
      localObject4 = h.b(d.ano(), (Point)localObject1, paramInt, bool);
      localObject3 = localObject4;
      if (((h.c)localObject4).tCB == null)
      {
        localObject3 = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
        localObject4 = d.gyD;
        localObject3 = h.a(d.ann(), (Point)localObject3, this.gxy, bool);
      }
      if (((h.c)localObject3).tCB == null)
      {
        localObject4 = c.gya;
        c.amW();
        ad.i(this.fLc, "checkMore start %s", new Object[] { ((h.c)localObject3).toString() });
        ((h.c)localObject3).tCB = ((h.c)localObject3).tCE;
        ((h.c)localObject3).tCC = ((h.c)localObject3).tCF;
        ((h.c)localObject3).tCD = ((h.c)localObject3).tCG;
      }
      localObject4 = d.gyD;
      d.c((Point)localObject1);
      localObject1 = new Size(((h.c)localObject3).tCB.x, ((h.c)localObject3).tCB.y);
      paramInt = ((Size)localObject1).getWidth();
      i = ((Size)localObject1).getHeight();
      localObject1 = d.gyD;
      localObject1 = ImageReader.newInstance(paramInt, i, d.anj(), 1);
      ((ImageReader)localObject1).setOnImageAvailableListener(this.gyJ.gxR, this.gyJ.gxN);
      this.fVP = ((ImageReader)localObject1);
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
  
  public final void R(String paramString, int paramInt)
  {
    AppMethodBeat.i(94160);
    d.g.b.k.h(paramString, "tag");
    Object localObject = d.gyD;
    localObject = this.gyN;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    d.a((CaptureRequest.Builder)localObject, paramString, paramInt);
    anu();
    AppMethodBeat.o(94160);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94130);
    this.gyL.acquire();
    this.gyL.release();
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    b(paramSurfaceTexture, null, paramInt);
    AppMethodBeat.o(94130);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94131);
    this.gyL.acquire();
    this.gyL.release();
    super.a(paramSurfaceHolder, paramBoolean, paramInt);
    b(null, paramSurfaceHolder, paramInt);
    AppMethodBeat.o(94131);
  }
  
  public final void a(g paramg) {}
  
  public final void amF()
  {
    AppMethodBeat.i(94138);
    if (!amv())
    {
      AppMethodBeat.o(94138);
      return;
    }
    this.gyJ.removeCallbacks((Runnable)this.gyZ);
    AppMethodBeat.o(94138);
  }
  
  public final com.tencent.mm.media.widget.a.b amG()
  {
    boolean bool = true;
    AppMethodBeat.i(94143);
    ad.m(this.fLc, "generateCameraConfig", new Object[0]);
    if (this.gyM == null)
    {
      ad.i(this.fLc, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94143);
      return null;
    }
    if (!amv())
    {
      ad.i(this.fLc, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94143);
      return null;
    }
    Object localObject = com.tencent.mm.media.widget.a.b.gwQ;
    com.tencent.mm.media.widget.a.b.mE(getPreviewWidth());
    localObject = com.tencent.mm.media.widget.a.b.gwQ;
    com.tencent.mm.media.widget.a.b.mD(getPreviewHeight());
    localObject = this.gyQ;
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
        localObject = com.tencent.mm.media.widget.a.b.gwQ;
        com.tencent.mm.media.widget.a.b.mG(this.gwE.pUc);
        localObject = com.tencent.mm.media.widget.a.b.gwQ;
        com.tencent.mm.media.widget.a.b.mH(this.gwE.pUd);
        if (i != 0)
        {
          localObject = com.tencent.mm.media.widget.a.b.gwQ;
          i = com.tencent.mm.media.widget.a.b.amz();
          localObject = com.tencent.mm.media.widget.a.b.gwQ;
          localObject = com.tencent.mm.media.widget.a.b.gwQ;
          com.tencent.mm.media.widget.a.b.mG(com.tencent.mm.media.widget.a.b.amA());
          localObject = com.tencent.mm.media.widget.a.b.gwQ;
          com.tencent.mm.media.widget.a.b.mH(i);
        }
        localObject = com.tencent.mm.media.widget.a.b.gwQ;
        if (!amv()) {
          break label294;
        }
        localObject = d.gyD;
        i = d.ank();
        label218:
        com.tencent.mm.media.widget.a.b.mF(i);
        localObject = com.tencent.mm.media.widget.a.b.gwQ;
        if (this.gwz) {
          break label299;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.media.widget.a.b.setFrontCamera(bool);
      localObject = com.tencent.mm.media.widget.a.b.gwQ;
      com.tencent.mm.media.widget.a.b.dK(this.gwB);
      localObject = this.gwF;
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
  
  public final int amK()
  {
    AppMethodBeat.i(94162);
    d locald = d.gyD;
    if (d.ani())
    {
      AppMethodBeat.o(94162);
      return 0;
    }
    AppMethodBeat.o(94162);
    return 1;
  }
  
  public final int amL()
  {
    AppMethodBeat.i(94163);
    d locald = d.gyD;
    int i = d.ank();
    AppMethodBeat.o(94163);
    return i;
  }
  
  public final boolean amw()
  {
    AppMethodBeat.i(94158);
    this.gyR = true;
    Object localObject = d.gyD;
    d.dQ(true);
    localObject = c.gya;
    c.anb();
    AppMethodBeat.o(94158);
    return true;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94137);
    if (com.tencent.mm.compatible.util.d.lg(14))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if ((this.gyM == null) || (this.gyO == null))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if (!amv())
    {
      AppMethodBeat.o(94137);
      return;
    }
    this.gyJ.removeCallbacks((Runnable)this.gyZ);
    this.gyZ.x = paramFloat1;
    this.gyZ.y = paramFloat2;
    this.gyZ.surfaceHeight = paramInt2;
    this.gyZ.surfaceWidth = paramInt1;
    this.gyJ.postDelayed((Runnable)this.gyZ, 400L);
    AppMethodBeat.o(94137);
  }
  
  public final void b(g paramg) {}
  
  protected final boolean b(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94149);
    if (this.gyM == null)
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
          ad.i(this.fLc, "support continuous picture");
          paramCameraCharacteristics = this.gyN;
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
          ad.i(this.fLc, "support continuous video");
          paramCameraCharacteristics = this.gyN;
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
        ad.i(this.fLc, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(94149);
        return false;
      }
      if (d.a.e.contains(paramCameraCharacteristics, 1))
      {
        ad.i(this.fLc, "support auto focus");
        paramCameraCharacteristics = this.gyN;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        }
      }
      else
      {
        label217:
        ad.i(this.fLc, "not support continuous video or auto focus");
      }
    }
  }
  
  public final Point dL(boolean paramBoolean)
  {
    AppMethodBeat.i(94146);
    if (!paramBoolean)
    {
      localPoint = new Point(this.gwE.pUc, this.gwE.pUd);
      AppMethodBeat.o(94146);
      return localPoint;
    }
    if (this.gxn != null)
    {
      localPoint = this.gxn;
      if (localPoint == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(94146);
      return localPoint;
    }
    Point localPoint = new Point(this.gwE.pUc, this.gwE.pUd);
    AppMethodBeat.o(94146);
    return localPoint;
  }
  
  public final void dM(boolean paramBoolean)
  {
    AppMethodBeat.i(94164);
    Object localObject = d.gyD;
    localObject = this.gyN;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    d.a(paramBoolean, (CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94164);
  }
  
  public final void fQG()
  {
    this.KBO = 15;
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(94165);
    Object localObject = d.gyD;
    localObject = this.gyN;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    int i = d.a((CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94165);
    return i;
  }
  
  public final float[] getSupportZoomRatios()
  {
    AppMethodBeat.i(94141);
    if ((this.gyV == null) && (this.gyQ != null))
    {
      localObject = this.gyQ;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      if (localObject != null) {}
      for (float f = ((Float)localObject).floatValue();; f = 0.0F)
      {
        f = (int)(f * 10.0F) * 1.0F / 10.0F;
        this.gyV = new float[(int)(f * 10.0F)];
        int i = 0;
        int j = (int)(f * 10.0F);
        while (i < j)
        {
          localObject = this.gyV;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          localObject[i] = (i * 1.0F / 10.0F + 1.0F);
          i += 1;
        }
      }
    }
    Object localObject = this.gyV;
    AppMethodBeat.o(94141);
    return localObject;
  }
  
  public final boolean h(d.g.a.b<? super Bitmap, y> paramb)
  {
    c localc2 = null;
    AppMethodBeat.i(94157);
    d.g.b.k.h(paramb, "dataCallback");
    ad.i(this.fLc, "takePhoto");
    a(a.a.gwK);
    Object localObject1 = d.gyD;
    localObject1 = d.anh();
    Object localObject2 = d.gyD;
    if (d.g.b.k.g(localObject1, d.mM(d.gyc)))
    {
      localObject1 = c.gya;
      c.amR();
      for (;;)
      {
        try
        {
          if (this.state != 0)
          {
            b(this.gyQ);
            localObject1 = this.gyN;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
            }
            localObject1 = this.gyN;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
            }
            localObject1 = this.gyN;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
            }
            localObject1 = this.gyN;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((CaptureRequest.Builder)localObject1).build();
            if (localObject1 == null) {
              d.g.b.k.fvU();
            }
            this.gyP = ((CaptureRequest)localObject1);
            boolean bool = this.gyU;
            if (bool) {}
          }
        }
        catch (Exception localException)
        {
          CaptureRequest.Builder localBuilder;
          localc2 = c.gya;
          c.amS();
          ad.m(this.fLc, "take photo in back camera error", new Object[] { localException });
          continue;
          localc1 = null;
          continue;
        }
        try
        {
          localObject1 = this.gyO;
          if (localObject1 != null)
          {
            localObject2 = this.gyP;
            if (localObject2 == null) {
              d.g.b.k.aPZ("previewRequest");
            }
            ((CameraCaptureSession)localObject1).setRepeatingRequest((CaptureRequest)localObject2, (CameraCaptureSession.CaptureCallback)this.gyY, this.gyJ.gxN);
          }
        }
        catch (CameraAccessException localCameraAccessException)
        {
          ad.e(this.fLc, "setRepeatingRequest failed, errMsg: ");
        }
      }
      this.state = 0;
      this.gyJ.removeCallbacks((Runnable)this.gyZ);
      localObject1 = this.gyN;
      if (localObject1 != null) {
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      this.state = 1;
      if (!this.gyU)
      {
        localObject1 = this.gyN;
        if (localObject1 == null) {
          break label417;
        }
        localObject1 = ((CaptureRequest.Builder)localObject1).build();
        if (localObject1 != null)
        {
          localObject2 = this.gyO;
          if (localObject2 != null)
          {
            localBuilder = this.gyN;
            localObject1 = localc2;
            if (localBuilder != null) {
              localObject1 = localBuilder.build();
            }
            if (localObject1 == null) {
              d.g.b.k.fvU();
            }
            ((CameraCaptureSession)localObject2).capture((CaptureRequest)localObject1, (CameraCaptureSession.CaptureCallback)this.gyY, this.gyJ.gxN);
          }
        }
      }
    }
    for (;;)
    {
      this.gyJ.gxP = paramb;
      AppMethodBeat.o(94157);
      return true;
      localObject1 = null;
      break;
      label417:
      c localc1 = c.gya;
      c.amQ();
      ans();
    }
  }
  
  public final void i(d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(94133);
    this.gxB = paramb;
    d locald = d.gyD;
    d.i(paramb);
    AppMethodBeat.o(94133);
  }
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94140);
    if ((this.gyM != null) && (amv())) {}
    for (;;)
    {
      float f2;
      try
      {
        ad.d(this.fLc, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (this.aMX)
        {
          ad.d(this.fLc, "triggerSmallZoom, zooming, ignore");
          return;
        }
        this.aMX = true;
        localObject1 = this.gyN;
        if (localObject1 != null)
        {
          localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
          localObject3 = this.gyQ;
          if (localObject3 != null)
          {
            localObject3 = (Rect)((CameraCharacteristics)localObject3).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            if (localObject3 == null) {
              d.g.b.k.fvU();
            }
            f1 = ((Rect)localObject3).width();
            if (localObject1 == null) {
              d.g.b.k.fvU();
            }
            f2 = f1 / ((Rect)localObject1).width();
            localObject1 = this.gyQ;
            if (localObject1 == null) {
              d.g.b.k.fvU();
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
        f2 = this.gyH + f2;
        if (f2 < f1) {
          break label542;
        }
        ad.d(this.fLc, "triggerSmallZoom, nextZoom: %s", new Object[] { Float.valueOf(f1) });
        f2 = ((Rect)localObject3).width() / f1;
        f1 = ((Rect)localObject3).height() / f1;
        float f3 = (((Rect)localObject3).width() - f2) / 2.0F;
        float f4 = (((Rect)localObject3).height() - f1) / 2.0F;
        localObject1 = new Rect((int)f3, (int)f4, (int)(f2 + f3), (int)(f1 + f4));
        localObject3 = this.gyN;
        if (localObject3 != null) {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
        }
        paramBoolean = this.gyU;
        if (paramBoolean) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        ad.e(this.fLc, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aMX = false;
        AppMethodBeat.o(94140);
      }
      try
      {
        localObject1 = this.gyO;
        if (localObject1 != null)
        {
          localObject3 = this.gyN;
          if (localObject3 == null) {
            d.g.b.k.fvU();
          }
          ((CameraCaptureSession)localObject1).setRepeatingRequest(((CaptureRequest.Builder)localObject3).build(), (CameraCaptureSession.CaptureCallback)this.gyY, this.gyJ.gxN);
        }
      }
      catch (CameraAccessException localCameraAccessException)
      {
        continue;
      }
      this.aMX = false;
      AppMethodBeat.o(94140);
      return;
      if (f2 == 1.0F)
      {
        this.aMX = false;
        AppMethodBeat.o(94140);
        return;
      }
      float f1 = this.gyH;
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
  
  public final void mJ(int paramInt)
  {
    AppMethodBeat.i(94139);
    if (this.gxo > 0)
    {
      AppMethodBeat.o(94139);
      return;
    }
    Object localObject = ai.cf(aj.getContext());
    int i = ((Point)localObject).y;
    ad.i(this.fLc, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94139);
      return;
    }
    try
    {
      localObject = this.gyQ;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      if (localObject != null) {}
      for (float f = ((Float)localObject).floatValue();; f = 0.0F)
      {
        double d = f / (paramInt / 3.0D / 10.0D);
        if (d > 0.0D) {
          this.gxo = ((int)d + 1);
        }
        ad.i(this.fLc, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.gxo), Float.valueOf(f) });
        AppMethodBeat.o(94139);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e(this.fLc, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94139);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(94156);
    Object localObject = this.gyJ;
    f localf = ((a)localObject).gxQ;
    if (localf != null) {
      localf.release();
    }
    localObject = ((a)localObject).gxO;
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
      ad.printErrStackTrace(this.fLc, (Throwable)paramContext, "init camera failed!", new Object[0]);
      paramContext = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.akD();
      AppMethodBeat.o(94128);
      return false;
    }
    this.gyb = ((CameraManager)localObject);
    Object localObject = d.gyD;
    d.a(this.gyb);
    if (this.gxx)
    {
      ad.i(this.fLc, "initCamera, already open");
      AppMethodBeat.o(94128);
      return true;
    }
    localObject = com.tencent.mm.media.j.d.gwr;
    com.tencent.mm.media.j.d.akB();
    super.q(paramContext, paramBoolean);
    release();
    anq();
    if (paramBoolean) {
      paramContext = d.gyD;
    }
    for (paramContext = d.mM(d.gyc);; paramContext = d.mM(d.gyd))
    {
      ad.m(this.fLc, "use camera id %s, SrvDeviceInfo id %d", new Object[] { paramContext, Integer.valueOf(ae.fFw.fBx) });
      localObject = c.gya;
      c.amM();
      localObject = this.context;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      if (bt.p((Context)localObject, "android.permission.CAMERA")) {
        break;
      }
      ad.e(this.fLc, "it was lack of the camera permision to open camera");
      AppMethodBeat.o(94128);
      return true;
      paramContext = d.gyD;
    }
    try
    {
      if (!this.gyL.tryAcquire(2500L, TimeUnit.MILLISECONDS))
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
      localObject = this.gyb;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      ((CameraManager)localObject).openCamera(paramContext, (CameraDevice.StateCallback)this.gyX, this.gyJ.gxN);
    }
    catch (CameraAccessException localCameraAccessException)
    {
      label348:
      break label348;
    }
    localObject = d.gyD;
    d.gym = paramContext;
    if (paramContext == null) {
      d.g.b.k.fvU();
    }
    d.g.b.k.h(paramContext, "id");
    localObject = d.gyb;
    if (localObject != null) {}
    for (paramContext = ((CameraManager)localObject).getCameraCharacteristics(paramContext);; paramContext = null)
    {
      if (paramContext == null) {
        d.g.b.k.fvU();
      }
      paramContext = paramContext.get(CameraCharacteristics.SENSOR_ORIENTATION);
      if (paramContext == null) {
        d.g.b.k.fvU();
      }
      d.gyo = ((Number)paramContext).intValue();
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(94155);
    super.release();
    if (this.gyM != null)
    {
      long l = bt.GC();
      ad.i(this.fLc, "release camera beg, %s", new Object[] { Looper.myLooper() });
      this.gyJ.removeCallbacksAndMessages(null);
      anq();
      localObject = this.mSurface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      ad.i(this.fLc, "release camera end, use %dms, %s", new Object[] { Long.valueOf(bt.aS(l)), Looper.myLooper() });
    }
    this.gxn = null;
    this.gxx = false;
    Object localObject = c.gya;
    c.amP();
    AppMethodBeat.o(94155);
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(94166);
    Object localObject = d.gyD;
    CaptureRequest.Builder localBuilder = this.gyN;
    if (localBuilder == null) {
      d.g.b.k.fvU();
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
      localObject = d.gyb;
      if (localObject != null)
      {
        localObject = ((CameraManager)localObject).getCameraCharacteristics(d.gym);
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
    if (this.aMX)
    {
      ad.d(this.fLc, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94142);
      return;
    }
    if ((this.gyQ != null) && (this.gyN != null)) {
      try
      {
        localObject1 = this.gyQ;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        int i = ((Rect)localObject1).width() - d.h.a.bU(((Rect)localObject1).width() / paramFloat);
        int j = ((Rect)localObject1).height() - d.h.a.bU(((Rect)localObject1).height() / paramFloat);
        this.gyT = new Rect(i / 2, j / 2, ((Rect)localObject1).width() - i / 2, ((Rect)localObject1).height() - j / 2);
        localObject1 = this.gyN;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.SCALER_CROP_REGION, this.gyT);
        boolean bool = this.gyU;
        if (bool) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        label237:
        ad.e(this.fLc, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aMX = false;
        AppMethodBeat.o(94142);
      }
    }
    try
    {
      localObject1 = this.gyO;
      if (localObject1 != null)
      {
        CaptureRequest.Builder localBuilder = this.gyN;
        if (localBuilder == null) {
          d.g.b.k.fvU();
        }
        ((CameraCaptureSession)localObject1).setRepeatingRequest(localBuilder.build(), (CameraCaptureSession.CaptureCallback)this.gyY, this.gyJ.gxN);
      }
    }
    catch (CameraAccessException localCameraAccessException)
    {
      break label237;
    }
    this.aMX = false;
    AppMethodBeat.o(94142);
    return;
    AppMethodBeat.o(94142);
  }
  
  public final void z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94159);
    d.g.b.k.h(paramString, "tag");
    b.a locala = com.tencent.mm.media.widget.b.a.a.b.gAi;
    if (d.g.b.k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.anE()))
    {
      paramString = d.gyD;
      d.dR(paramBoolean);
    }
    for (;;)
    {
      anu();
      AppMethodBeat.o(94159);
      return;
      locala = com.tencent.mm.media.widget.b.a.a.b.gAi;
      if (d.g.b.k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.anJ()))
      {
        paramString = d.gyD;
        d.dN(paramBoolean);
      }
      else
      {
        locala = com.tencent.mm.media.widget.b.a.a.b.gAi;
        if (d.g.b.k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.anI()))
        {
          paramString = d.gyD;
          d.dO(paramBoolean);
        }
        else
        {
          locala = com.tencent.mm.media.widget.b.a.a.b.gAi;
          if (d.g.b.k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.anL()))
          {
            paramString = d.gyD;
            d.dP(paramBoolean);
          }
          else
          {
            locala = com.tencent.mm.media.widget.b.a.a.b.gAi;
            if (d.g.b.k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.anK()))
            {
              paramString = d.gyD;
              d.dQ(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1", "Ljava/lang/Runnable;", "surfaceHeight", "", "getSurfaceHeight", "()I", "setSurfaceHeight", "(I)V", "surfaceWidth", "getSurfaceWidth", "setSurfaceWidth", "x", "", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "run", "", "plugin-mediaeditor_release"})
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
      e.a(this.gzf, this.x, this.y, this.surfaceWidth, this.surfaceHeight);
      AppMethodBeat.o(94117);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/media/widget/camera2/CommonCamera2$captureStillPicture$2$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "onCaptureCompleted", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "result", "Landroid/hardware/camera2/TotalCaptureResult;", "plugin-mediaeditor_release"})
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
      paramCameraCaptureSession = d.gyD;
      paramCameraCaptureSession = e.a(this.gzf);
      if (paramCameraCaptureSession == null) {
        d.g.b.k.fvU();
      }
      d.g(paramCameraCaptureSession);
      AppMethodBeat.o(94118);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "camera", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "plugin-mediaeditor_release"})
  public static final class d
    extends CameraDevice.StateCallback
  {
    public final void onDisconnected(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94120);
      d.g.b.k.h(paramCameraDevice, "camera");
      e.g(this.gzf).release();
      paramCameraDevice.close();
      e.a(this.gzf, null);
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
      e.g(this.gzf).release();
      e.a(this.gzf, paramCameraDevice);
      AppMethodBeat.o(94119);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "capturePicture", "", "result", "Landroid/hardware/camera2/CaptureResult;", "checkFocusEnd", "", "onCaptureCompleted", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "Landroid/hardware/camera2/TotalCaptureResult;", "onCaptureProgressed", "partialResult", "process", "plugin-mediaeditor_release"})
  public static final class e
    extends CameraCaptureSession.CaptureCallback
  {
    private final void b(CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94122);
      switch (e.h(this.gzf))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94122);
        return;
        Object localObject = d.gyD;
        d.a(paramCaptureResult);
        AppMethodBeat.o(94122);
        return;
        localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if ((localObject == null) || (2 == ((Integer)localObject).intValue()) || (6 == ((Integer)localObject).intValue()))
        {
          e.i(this.gzf);
          AppMethodBeat.o(94122);
          return;
        }
        if ((4 == ((Integer)localObject).intValue()) || (5 == ((Integer)localObject).intValue()))
        {
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 2))
          {
            e.i(this.gzf);
            AppMethodBeat.o(94122);
            return;
          }
          e.j(this.gzf);
        }
        AppMethodBeat.o(94122);
        return;
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 5) || (paramCaptureResult.intValue() == 4))
        {
          e.a(this.gzf, 3);
          AppMethodBeat.o(94122);
          return;
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() != 5))
          {
            e.i(this.gzf);
            AppMethodBeat.o(94122);
            return;
            if (this.gzf.amv())
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
                if ((i == 0) || (e.d(this.gzf))) {
                  break label534;
                }
                ad.i(e.k(this.gzf), "STATE_TOUCH_CAF_WAITING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
                this.gzf.b(e.l(this.gzf));
                paramCaptureResult = e.a(this.gzf);
                if (paramCaptureResult != null) {
                  paramCaptureResult.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                }
                localObject = this.gzf;
                paramCaptureResult = e.a(this.gzf);
                if (paramCaptureResult == null) {
                  break label513;
                }
              }
              label513:
              for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
              {
                if (paramCaptureResult == null) {
                  d.g.b.k.fvU();
                }
                e.a((e)localObject, paramCaptureResult);
                try
                {
                  paramCaptureResult = e.e(this.gzf);
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(e.m(this.gzf), (CameraCaptureSession.CaptureCallback)this, this.gzf.gyJ.gxN);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    ad.e(e.b(this.gzf), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                e.a(this.gzf, 6);
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
            ad.e(e.b(this.gzf), "current is not allowed to do anything casue capturing");
            AppMethodBeat.o(94122);
            return;
            if ((this.gzf.amv()) && (!e.d(this.gzf)))
            {
              ad.i(e.k(this.gzf), "STATE_TOUCH_FOCUSING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
              paramCaptureResult = e.a(this.gzf);
              if (paramCaptureResult != null) {
                paramCaptureResult.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
              }
              paramCaptureResult = e.a(this.gzf);
              if (paramCaptureResult != null) {
                paramCaptureResult.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
              }
              localObject = this.gzf;
              paramCaptureResult = e.a(this.gzf);
              if (paramCaptureResult != null) {}
              for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
              {
                if (paramCaptureResult == null) {
                  d.g.b.k.fvU();
                }
                e.a((e)localObject, paramCaptureResult);
                try
                {
                  paramCaptureResult = e.e(this.gzf);
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(e.m(this.gzf), (CameraCaptureSession.CaptureCallback)this, this.gzf.gyJ.gxN);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    ad.e(e.b(this.gzf), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                e.a(this.gzf, 0);
                AppMethodBeat.o(94122);
                return;
              }
            }
            ad.e(e.b(this.gzf), "current is not allowed to do anything casue capturing");
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onClosed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigureFailed", "onConfigured", "plugin-mediaeditor_release"})
  public static final class f
    extends CameraCaptureSession.StateCallback
  {
    public final void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94127);
      d.g.b.k.h(paramCameraCaptureSession, "session");
      super.onClosed(paramCameraCaptureSession);
      ad.i(e.b(this.gzf), "session on close");
      e.a(this.gzf, true);
      AppMethodBeat.o(94127);
    }
    
    public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94126);
      d.g.b.k.h(paramCameraCaptureSession, "session");
      ad.i(e.b(this.gzf), "configure failed ");
      paramCameraCaptureSession = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.akD();
      paramCameraCaptureSession = c.gya;
      c.amO();
      AppMethodBeat.o(94126);
    }
    
    public final void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94125);
      d.g.b.k.h(paramCameraCaptureSession, "session");
      ad.i(e.b(this.gzf), "session on onConfigured");
      if (e.c(this.gzf) == null)
      {
        AppMethodBeat.o(94125);
        return;
      }
      e.a(this.gzf, false);
      e.a(this.gzf, paramCameraCaptureSession);
      paramCameraCaptureSession = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.akC();
      paramCameraCaptureSession = c.gya;
      c.amN();
      e.f(this.gzf);
      AppMethodBeat.o(94125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e
 * JD-Core Version:    0.7.0.1
 */