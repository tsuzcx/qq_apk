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
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.media.widget.a.a.a;
import com.tencent.mm.media.widget.b.a.a.b.a;
import com.tencent.mm.media.widget.b.a.c.a;
import com.tencent.mm.media.widget.b.a.c.b;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import d.a.j;
import d.g.b.p;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "useBack", "", "(Landroid/content/Context;Z)V", "DEFAULT_UPPER_BOUND", "", "FOCUS_TAG", "", "FOCUS_TAG$1", "SMALL_ZOOM_STEP_NUM", "getSMALL_ZOOM_STEP_NUM", "()I", "SMALL_ZOOM_STEP_NUM$1", "SMALL_ZOOM_STEP_UPPER_BOUND", "getSMALL_ZOOM_STEP_UPPER_BOUND", "SMALL_ZOOM_STEP_UPPER_BOUND$1", "SMALL_ZOOM_STEP_VAL", "", "TAG", "TAG$1", "autoFocusRunnable", "com/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1;", "cropSize", "Landroid/graphics/Point;", "imageReader", "Landroid/media/ImageReader;", "isCameraOpen", "isUseRecordStream", "isZooming", "mCameraDevice", "Landroid/hardware/camera2/CameraDevice;", "mCameraDeviceCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1;", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "mCameraOpenCloseLock", "Ljava/util/concurrent/Semaphore;", "mCaptureCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1;", "mCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "mCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "mFpsValuev", "getMFpsValuev", "setMFpsValuev", "(I)V", "mIsNoAFRun", "mIsSessionClose", "mPreviewBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "mPreviewSize", "Landroid/util/Size;", "mStateCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1;", "mSurface", "Landroid/view/Surface;", "mZoomTimesToRatio", "", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "previewRequest", "Landroid/hardware/camera2/CaptureRequest;", "scrollSmallZoomStep", "sightHandler", "Lcom/tencent/mm/media/widget/camera2/Camera2Handler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera2/Camera2Handler;", "smallZoomStep", "state", "zoomOutRect", "Landroid/graphics/Rect;", "abandonFocus", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateTapArea", "x", "y", "surfaceWidth", "surfaceHeight", "captureStillPicture", "clamp", "min", "max", "closeCamera", "configVendorTagValue", "tag", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraOrientation", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "getPreviewWidth", "getSupportZoomRatios", "initCamera", "initRawRatios", "lock3AParams", "builder", "lockFocus", "onDestroy", "openCamera", "nowCameraId", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "resumePreview", "runPrecaptureSequence", "safeResetZoom", "safeSetFocusMode", "characteristics", "safeSetMetering", "safeSetOIS", "safeSetPreviewFrameRate", "useFixMode", "safeSetStabilization", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "safeSetVendorEffect", "selectNoCropPreviewSize", "resolutionLimit", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setSafeConfig", "startPreview", "useCpuCrop", "surface", "startPreviewWithGPU", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "trySetPreviewFrameRateParameters", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends com.tencent.mm.media.widget.a.a
{
  private static final SparseIntArray hut;
  public static final e.a huu;
  private boolean aYh;
  private final String gkG;
  private ImageReader gvN;
  private Point hsE;
  private int hsF;
  private boolean hsO;
  private final int hsP;
  private d.g.a.b<? super Boolean, z> hsS;
  private final String htW;
  private final int htX;
  private final int htY;
  private final float htZ;
  private CameraManager htt;
  private Size hua;
  final a hub;
  private float huc;
  private final Semaphore hud;
  private CameraDevice hue;
  private CaptureRequest.Builder huf;
  private CameraCaptureSession hug;
  private CaptureRequest huh;
  private CameraCharacteristics hui;
  private boolean huj;
  private boolean huk;
  private Rect hul;
  private boolean hum;
  private float[] hun;
  private final f huo;
  private final d hup;
  private final e huq;
  private final b hur;
  private int hus;
  private Surface mSurface;
  private int state;
  
  static
  {
    AppMethodBeat.i(94168);
    huu = new e.a((byte)0);
    SparseIntArray localSparseIntArray = new SparseIntArray();
    hut = localSparseIntArray;
    localSparseIntArray.append(0, 90);
    hut.append(1, 0);
    hut.append(2, 270);
    hut.append(3, 180);
    AppMethodBeat.o(94168);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94167);
    this.gkG = "MicroMsg.CommonCamera2";
    this.htW = "MicroMsg.CommonCamera2.FoucsTag";
    this.htX = 5;
    this.htY = 20;
    this.htZ = 0.1F;
    Object localObject = Looper.getMainLooper();
    p.g(localObject, "Looper.getMainLooper()");
    this.hub = new a((Looper)localObject, paramContext);
    this.hsF = -1;
    this.huc = -1.0F;
    this.hsP = 2100;
    this.hud = new Semaphore(1);
    if (com.tencent.mm.media.widget.d.a.ayC())
    {
      paramContext = new com.tencent.mm.media.widget.b.a.c(paramContext);
      localObject = (d.g.a.q)1.huv;
      p.h(localObject, "mSupportWCKeyAvailable");
      new Thread((Runnable)new c.a(paramContext, (d.g.a.a)new c.b(paramContext, (d.g.a.q)localObject))).start();
      paramContext = d.htV;
      d.axh();
    }
    this.huo = new f(this);
    this.hup = new d(this);
    this.huq = new e(this);
    this.hur = new b(this);
    AppMethodBeat.o(94167);
  }
  
  private final void a(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94148);
    if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaz > 0)
    {
      com.tencent.mm.sdk.platformtools.ae.i(this.hrN, "set frame rate > 0, do not try set preview fps range");
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
        com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(m), localInteger1, localInteger2 });
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
      if (this.hus == 0)
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
      if (this.hus != 0)
      {
        n = this.hus;
        if (localInteger2 == null)
        {
          break;
          n = this.hus;
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
        com.tencent.mm.sdk.platformtools.ae.i(this.hrN, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(30) });
        if ((j == 2147483647) || (k == 2147483647))
        {
          AppMethodBeat.o(94148);
          return;
        }
        try
        {
          paramCameraCharacteristics = this.huf;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range((Comparable)Integer.valueOf(j), (Comparable)Integer.valueOf(k)));
          }
          com.tencent.mm.sdk.platformtools.ae.i(this.hrN, "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          AppMethodBeat.o(94148);
          return;
        }
        catch (Exception paramCameraCharacteristics)
        {
          com.tencent.mm.sdk.platformtools.ae.i(this.hrN, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
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
    Object localObject2 = this.huf;
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
          paramSurfaceTexture = d.htV;
          if (!d.axk()) {
            break label456;
          }
          if (!this.huj) {
            break label279;
          }
          paramSurfaceTexture = d.htV;
          paramSurfaceTexture = this.huf;
          if (paramSurfaceTexture == null) {
            p.gkB();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.hvz;
          j = d.a(paramSurfaceTexture, j.listOf(com.tencent.mm.media.widget.b.a.a.b.axE()));
          i = j;
          if (Build.VERSION.SDK_INT < 28) {
            break label445;
          }
          paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration(this.mSurface)), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.huo);
          paramSurfaceHolder = this.hue;
          if (paramSurfaceHolder == null) {
            p.gkB();
          }
          paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
          if (j == 0)
          {
            paramSurfaceHolder = this.hue;
            if (paramSurfaceHolder == null) {
              p.gkB();
            }
            localObject1 = this.mSurface;
            localObject2 = this.gvN;
            paramSurfaceTexture = localSurface;
            if (localObject2 != null) {
              paramSurfaceTexture = ((ImageReader)localObject2).getSurface();
            }
            paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localObject1, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.huo, this.hub.htf);
          }
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "doStartPreview finish");
          AppMethodBeat.o(94135);
          return true;
          if (paramSurfaceHolder == null) {
            break;
          }
          this.mSurface = paramSurfaceHolder.getSurface();
          break;
          label279:
          paramSurfaceTexture = d.htV;
          paramSurfaceTexture = this.huf;
          if (paramSurfaceTexture == null) {
            p.gkB();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.hvz;
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.axD();
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.hvz;
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.axC();
          localObject2 = com.tencent.mm.media.widget.b.a.a.b.hvz;
          j = d.a(paramSurfaceTexture, j.listOf(new String[] { paramSurfaceHolder, localObject1, com.tencent.mm.media.widget.b.a.a.b.axF() }));
          i = j;
          if (Build.VERSION.SDK_INT >= 28)
          {
            paramSurfaceHolder = new OutputConfiguration(this.mSurface);
            paramSurfaceTexture = this.gvN;
            if (paramSurfaceTexture == null) {
              break label451;
            }
          }
          label445:
          label451:
          for (paramSurfaceTexture = paramSurfaceTexture.getSurface();; paramSurfaceTexture = null)
          {
            paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration[] { paramSurfaceHolder, new OutputConfiguration(paramSurfaceTexture) }), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.huo);
            paramSurfaceHolder = this.hue;
            if (paramSurfaceHolder == null) {
              p.gkB();
            }
            paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
            i = j;
            j = i;
            break;
          }
          label456:
          paramSurfaceHolder = this.hue;
          if (paramSurfaceHolder == null) {
            p.gkB();
          }
          localSurface = this.mSurface;
          localObject2 = this.gvN;
          paramSurfaceTexture = (SurfaceTexture)localObject1;
          if (localObject2 != null) {
            paramSurfaceTexture = ((ImageReader)localObject2).getSurface();
          }
          paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localSurface, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.huo, this.hub.htf);
        }
      }
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.auz();
      paramSurfaceTexture = c.hts;
      c.awJ();
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
        if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaz > 0) {
          com.tencent.mm.sdk.platformtools.ae.i(this.hrN, "set frame rate > 0, do not try set preview frame rate");
        }
        for (;;)
        {
          paramCameraCharacteristics = this.huf;
          if (paramCameraCharacteristics != null)
          {
            paramCameraCharacteristics = (Range)paramCameraCharacteristics.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
            label61:
            com.tencent.mm.sdk.platformtools.ae.i(this.hrN, "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), paramCameraCharacteristics });
            AppMethodBeat.o(94147);
            return true;
            if (paramCameraCharacteristics == null)
            {
              com.tencent.mm.sdk.platformtools.ae.e(this.gkG, "trySetPreviewFrameRateParameters error, p is null!");
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
              else if (this.hus == 0)
              {
                i = Math.min(30, i);
                paramCameraCharacteristics = new Range((Comparable)Integer.valueOf(i), (Comparable)Integer.valueOf(i));
                localObject = this.huf;
                if (localObject == null) {
                  continue;
                }
                ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, paramCameraCharacteristics);
              }
            }
            catch (Exception paramCameraCharacteristics)
            {
              com.tencent.mm.sdk.platformtools.ae.i(this.hrN, "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
            }
          }
        }
      }
      catch (Exception paramCameraCharacteristics)
      {
        com.tencent.mm.sdk.platformtools.ae.i(this.hrN, "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
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
      int i = Math.min(this.hus, i);
      continue;
      a(paramCameraCharacteristics);
      break;
      paramCameraCharacteristics = null;
      break label61;
      j += 1;
    }
  }
  
  private void awB()
  {
    AppMethodBeat.i(94150);
    Object localObject = this.hui;
    if (localObject != null) {
      localObject = (Rect)((CameraCharacteristics)localObject).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }
    while (localObject != null)
    {
      localObject = new Rect(((Rect)localObject).left * 1, ((Rect)localObject).top * 1, ((Rect)localObject).right * 1, ((Rect)localObject).bottom * 1);
      CaptureRequest.Builder localBuilder = this.huf;
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
  
  private final void awy()
  {
    AppMethodBeat.i(94136);
    Integer localInteger = Integer.valueOf(0);
    Object localObject = com.tencent.mm.plugin.mmsight.model.a.l.dqm();
    p.g(localObject, "MMSightController.getInstance()");
    if (((com.tencent.mm.plugin.mmsight.model.a.l)localObject).dqn() != null)
    {
      localObject = com.tencent.mm.plugin.mmsight.model.a.l.dqm();
      p.g(localObject, "MMSightController.getInstance()");
      localInteger = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.a.l)localObject).dqn().vYP);
    }
    String str = this.gkG;
    boolean bool1;
    label92:
    boolean bool2;
    label104:
    boolean bool3;
    label116:
    boolean bool4;
    if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaE == 1)
    {
      localObject = "Range";
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaF != 1) {
        break label399;
      }
      bool1 = true;
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaG != 1) {
        break label404;
      }
      bool2 = true;
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaH != 1) {
        break label409;
      }
      bool3 = true;
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaI != 1) {
        break label414;
      }
      bool4 = true;
      label129:
      com.tencent.mm.sdk.platformtools.ae.i(str, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaE != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 1))) {
        break label420;
      }
      a(this.hui, false);
    }
    for (;;)
    {
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaF == 1) && (localInteger.intValue() != 0)) {
        localInteger.intValue();
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdz != -1) && (com.tencent.mm.compatible.deviceinfo.ae.geT.gdz == 1) && (com.tencent.mm.compatible.util.d.lC(14))) {
        c(this.hui);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaH == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
        b(this.hui);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaI == 1) && (localInteger.intValue() != 0)) {
        localInteger.intValue();
      }
      awB();
      axn();
      localObject = this.huf;
      if (localObject == null) {
        p.gkB();
      }
      h((CaptureRequest.Builder)localObject);
      AppMethodBeat.o(94136);
      return;
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaD == 1)
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
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaD == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 5))) {
        a(this.hui, true);
      }
    }
  }
  
  private final void axl()
  {
    AppMethodBeat.i(94129);
    try
    {
      if (this.huf != null)
      {
        localObject1 = d.htV;
        localObject1 = this.huf;
        if (localObject1 == null) {
          p.gkB();
        }
        d.g((CaptureRequest.Builder)localObject1);
      }
      this.hud.acquire();
      Object localObject1 = this.hug;
      if (localObject1 != null) {
        ((CameraCaptureSession)localObject1).close();
      }
      this.hug = null;
      localObject1 = this.hue;
      if (localObject1 != null) {
        ((CameraDevice)localObject1).close();
      }
      this.hue = null;
      localObject1 = this.gvN;
      if (localObject1 != null) {
        ((ImageReader)localObject1).setOnImageAvailableListener(null, this.hub.htf);
      }
      localObject1 = this.gvN;
      if (localObject1 != null) {
        ((ImageReader)localObject1).close();
      }
      this.gvN = null;
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
      this.hud.release();
      AppMethodBeat.o(94129);
    }
  }
  
  private final void axm()
  {
    Object localObject2 = null;
    AppMethodBeat.i(94134);
    try
    {
      if (this.state == 4)
      {
        com.tencent.mm.sdk.platformtools.ae.m(this.gkG, "capture still picture more than twice", new Object[0]);
        AppMethodBeat.o(94134);
        return;
      }
      this.state = 4;
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "captureStillPicture");
      if (this.hue == null)
      {
        AppMethodBeat.o(94134);
        return;
      }
    }
    catch (Exception localException)
    {
      localObject2 = d.htV;
      if (!d.axd())
      {
        localObject2 = c.hts;
        c.awO();
      }
      com.tencent.mm.sdk.platformtools.ae.e(this.gkG, localException.toString());
      AppMethodBeat.o(94134);
      return;
    }
    Object localObject1 = this.huf;
    Object localObject3;
    label190:
    label255:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
      if ((this.hue == null) || (this.hum))
      {
        AppMethodBeat.o(94134);
        return;
      }
      localObject3 = this.hue;
      if (localObject3 != null)
      {
        localObject3 = ((CameraDevice)localObject3).createCaptureRequest(2);
        if (localObject3 != null)
        {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
          localObject1 = this.gvN;
          if (localObject1 == null) {
            break label531;
          }
          localObject1 = ((ImageReader)localObject1).getSurface();
          ((CaptureRequest.Builder)localObject3).addTarget((Surface)localObject1);
          localObject1 = this.gvN;
          if (localObject1 != null) {
            ((ImageReader)localObject1).setOnImageAvailableListener(this.hub.htj, this.hub.htf);
          }
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
          localObject1 = this.hui;
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
          this.huk = bool;
          if (!this.huk)
          {
            localObject1 = this.hui;
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
        localObject1 = this.hui;
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
        this.huf = ((CaptureRequest.Builder)localObject1);
        localObject3 = this.hug;
        if (localObject3 == null) {
          break label514;
        }
        ((CameraCaptureSession)localObject3).stopRepeating();
        com.tencent.mm.sdk.platformtools.ae.i(this.htW, "this time happened a cancel auto foucs while capture");
        localObject1 = this.huf;
        if (localObject1 != null) {
          ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
        }
        CaptureRequest.Builder localBuilder = this.huf;
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
  
  private final void axn()
  {
    AppMethodBeat.i(94151);
    Object localObject = this.hui;
    if (localObject != null)
    {
      localObject = (int[])((CameraCharacteristics)localObject).get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
      if (localObject == null) {
        break label146;
      }
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "oisMode:" + Arrays.toString((int[])localObject));
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
      localObject = c.hts;
      c.awP();
      localObject = d.htV;
      d.ep(false);
      localObject = this.huf;
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
  
  private final void axo()
  {
    AppMethodBeat.i(94161);
    if (this.huf == null)
    {
      AppMethodBeat.o(94161);
      return;
    }
    if ((this.hue != null) && (!this.hum))
    {
      Object localObject = this.huf;
      if (localObject != null) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      }
      localObject = this.huf;
      if (localObject == null) {
        p.gkB();
      }
      h((CaptureRequest.Builder)localObject);
      CameraCaptureSession localCameraCaptureSession = this.hug;
      if (localCameraCaptureSession != null)
      {
        localObject = this.huf;
        if (localObject != null) {}
        for (localObject = ((CaptureRequest.Builder)localObject).build();; localObject = null)
        {
          localCameraCaptureSession.setRepeatingRequest((CaptureRequest)localObject, (CameraCaptureSession.CaptureCallback)this.huq, this.hub.htf);
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
    long l = bu.HQ();
    com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (awp())
    {
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94132);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.huj) {
          continue;
        }
        localCameraDevice = this.hue;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(3);
        }
        this.huf = localBuilder;
        ob(paramInt);
        awy();
        if (a(paramSurfaceTexture, paramSurfaceHolder))
        {
          a(a.a.hsa);
          this.state = 0;
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        CameraDevice localCameraDevice;
        com.tencent.mm.sdk.platformtools.ae.e(this.gkG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.auz();
        continue;
      }
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "start preview end, use %dms %s", new Object[] { Long.valueOf(bu.aO(l)), Looper.myLooper() });
      AppMethodBeat.o(94132);
      return;
      localCameraDevice = this.hue;
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
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "safeSetMetering");
      Rect localRect = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
      MeteringRectangle[] arrayOfMeteringRectangle = new MeteringRectangle[1];
      if (localRect != null) {}
      for (paramCameraCharacteristics = Integer.valueOf(localRect.right);; paramCameraCharacteristics = null)
      {
        if (paramCameraCharacteristics == null) {
          p.gkB();
        }
        arrayOfMeteringRectangle[0] = new MeteringRectangle(paramCameraCharacteristics.intValue() / 2 - 500, localRect.bottom / 2 - 500, 1000, 1000, 0);
        paramCameraCharacteristics = this.huf;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.huf;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.huf;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        }
        paramCameraCharacteristics = this.huf;
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
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
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
    if (this.hue == null)
    {
      AppMethodBeat.o(94144);
      return 0;
    }
    try
    {
      if ((this.hrS) && (this.hsE != null))
      {
        Point localPoint = this.hsE;
        if (localPoint == null) {
          p.gkB();
        }
        i = localPoint.y;
        AppMethodBeat.o(94144);
        return i;
      }
      int i = this.hrV.ruD;
      AppMethodBeat.o(94144);
      return i;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e(this.gkG, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94144);
    }
    return 0;
  }
  
  private final int getPreviewWidth()
  {
    AppMethodBeat.i(94145);
    if (this.hue == null)
    {
      AppMethodBeat.o(94145);
      return 0;
    }
    if (this.htt != null) {
      try
      {
        if ((this.hrS) && (this.hsE != null))
        {
          Point localPoint = this.hsE;
          if (localPoint == null) {
            p.gkB();
          }
          i = localPoint.x;
          AppMethodBeat.o(94145);
          return i;
        }
        int i = this.hrV.ruC;
        AppMethodBeat.o(94145);
        return i;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e(this.gkG, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94145);
    return 0;
  }
  
  private static void h(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94152);
    d locald = d.htV;
    d.b(paramBuilder);
    locald = d.htV;
    d.d(paramBuilder);
    locald = d.htV;
    d.e(paramBuilder);
    locald = d.htV;
    d.c(paramBuilder);
    locald = d.htV;
    d.f(paramBuilder);
    AppMethodBeat.o(94152);
  }
  
  private final boolean ob(int paramInt)
  {
    AppMethodBeat.i(94154);
    for (;;)
    {
      try
      {
        localObject1 = this.htt;
        if (localObject1 == null) {
          break label870;
        }
        localObject3 = d.htV;
        localObject3 = d.axc();
        if (localObject3 == null) {
          p.gkB();
        }
        localObject1 = ((CameraManager)localObject1).getCameraCharacteristics((String)localObject3);
        this.hui = ((CameraCharacteristics)localObject1);
        localObject1 = d.htV;
        if (d.axf() == 90) {
          break label865;
        }
        localObject1 = d.htV;
        if (d.axf() != 270) {
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
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(this.gkG, (Throwable)localCameraAccessException, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", new Object[] { Looper.myLooper(), localCameraAccessException.getMessage() });
        AppMethodBeat.o(94154);
        return false;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(this.gkG, (Throwable)localException, "selectNoCropPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(94154);
        return false;
      }
      if (this.hrY == null)
      {
        localObject1 = com.tencent.mm.plugin.mmsight.d.fS(this.context);
        localObject3 = d.htV;
        localObject4 = h.b(d.axi(), (Point)localObject1, paramInt, bool);
        localObject3 = localObject4;
        if (((h.c)localObject4).wah == null)
        {
          com.tencent.mm.sdk.platformtools.ae.e(this.gkG, "fuck, preview size still null!!");
          localObject3 = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
          localObject4 = d.htV;
          localObject3 = h.a(d.axi(), (Point)localObject3, this.hsP, bool);
        }
        if (((h.c)localObject3).wah == null)
        {
          com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "checkMore start %s", new Object[] { ((h.c)localObject3).toString() });
          ((h.c)localObject3).wah = ((h.c)localObject3).wak;
          ((h.c)localObject3).wai = ((h.c)localObject3).wal;
          ((h.c)localObject3).waj = ((h.c)localObject3).wam;
        }
        this.hua = new Size(((h.c)localObject3).wah.x, ((h.c)localObject3).wah.y);
        if (this.hua == null)
        {
          com.tencent.mm.plugin.mmsight.model.l.awQ();
          localObject1 = c.hts;
          c.awQ();
          AppMethodBeat.o(94154);
          return false;
        }
      }
      else
      {
        localObject1 = this.hrY;
        if (localObject1 == null) {
          p.gkB();
        }
        i = ((Size)localObject1).getWidth();
        localObject1 = this.hrY;
        if (localObject1 == null) {
          p.gkB();
        }
        localObject1 = new Point(i, ((Size)localObject1).getHeight());
        continue;
      }
      localObject4 = this.hrV;
      localSize = this.hua;
      if (localSize == null) {
        p.gkB();
      }
      ((com.tencent.mm.plugin.mmsight.model.q)localObject4).ruC = localSize.getWidth();
      localObject4 = this.hrV;
      localSize = this.hua;
      if (localSize == null) {
        p.gkB();
      }
      ((com.tencent.mm.plugin.mmsight.model.q)localObject4).ruD = localSize.getHeight();
      if (((h.c)localObject3).waj != null) {
        this.hsE = ((h.c)localObject3).waj;
      }
      localObject3 = this.surfaceTexture;
      if (localObject3 == null) {
        p.gkB();
      }
      localObject4 = this.hua;
      if (localObject4 == null) {
        p.gkB();
      }
      i = ((Size)localObject4).getWidth();
      localObject4 = this.hua;
      if (localObject4 == null) {
        p.gkB();
      }
      ((SurfaceTexture)localObject3).setDefaultBufferSize(i, ((Size)localObject4).getHeight());
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "final set camera preview size: " + this.hua + ", cropSize: " + this.hsE);
      localObject3 = d.htV;
      localObject4 = h.b(d.axj(), (Point)localObject1, paramInt, bool);
      localObject3 = localObject4;
      if (((h.c)localObject4).wah == null)
      {
        localObject3 = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
        localObject4 = d.htV;
        localObject3 = h.a(d.axi(), (Point)localObject3, this.hsP, bool);
      }
      if (((h.c)localObject3).wah == null)
      {
        localObject4 = c.hts;
        c.awR();
        com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "checkMore start %s", new Object[] { ((h.c)localObject3).toString() });
        ((h.c)localObject3).wah = ((h.c)localObject3).wak;
        ((h.c)localObject3).wai = ((h.c)localObject3).wal;
        ((h.c)localObject3).waj = ((h.c)localObject3).wam;
      }
      localObject4 = d.htV;
      d.c((Point)localObject1);
      localObject1 = new Size(((h.c)localObject3).wah.x, ((h.c)localObject3).wah.y);
      paramInt = ((Size)localObject1).getWidth();
      i = ((Size)localObject1).getHeight();
      localObject1 = d.htV;
      localObject1 = ImageReader.newInstance(paramInt, i, d.axe(), 1);
      ((ImageReader)localObject1).setOnImageAvailableListener(this.hub.htj, this.hub.htf);
      this.gvN = ((ImageReader)localObject1);
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
    b.a locala = com.tencent.mm.media.widget.b.a.a.b.hvz;
    if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axy()))
    {
      paramString = d.htV;
      d.eq(paramBoolean);
    }
    for (;;)
    {
      axo();
      AppMethodBeat.o(94159);
      return;
      locala = com.tencent.mm.media.widget.b.a.a.b.hvz;
      if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axD()))
      {
        paramString = d.htV;
        d.em(paramBoolean);
      }
      else
      {
        locala = com.tencent.mm.media.widget.b.a.a.b.hvz;
        if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axC()))
        {
          paramString = d.htV;
          d.en(paramBoolean);
        }
        else
        {
          locala = com.tencent.mm.media.widget.b.a.a.b.hvz;
          if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axF()))
          {
            paramString = d.htV;
            d.eo(paramBoolean);
          }
          else
          {
            locala = com.tencent.mm.media.widget.b.a.a.b.hvz;
            if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axE()))
            {
              paramString = d.htV;
              d.ep(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94130);
    this.hud.acquire();
    this.hud.release();
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    b(paramSurfaceTexture, null, paramInt);
    AppMethodBeat.o(94130);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94131);
    this.hud.acquire();
    this.hud.release();
    super.a(paramSurfaceHolder, paramBoolean, paramInt);
    b(null, paramSurfaceHolder, paramInt);
    AppMethodBeat.o(94131);
  }
  
  public final void a(g paramg) {}
  
  public final void ab(String paramString, int paramInt)
  {
    AppMethodBeat.i(94160);
    p.h(paramString, "tag");
    Object localObject = d.htV;
    localObject = this.huf;
    if (localObject == null) {
      p.gkB();
    }
    d.a((CaptureRequest.Builder)localObject, paramString, paramInt);
    axo();
    AppMethodBeat.o(94160);
  }
  
  public final com.tencent.mm.media.widget.a.b awA()
  {
    boolean bool = true;
    AppMethodBeat.i(94143);
    com.tencent.mm.sdk.platformtools.ae.m(this.gkG, "generateCameraConfig", new Object[0]);
    if (this.hue == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94143);
      return null;
    }
    if (!awp())
    {
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94143);
      return null;
    }
    Object localObject = com.tencent.mm.media.widget.a.b.hsh;
    com.tencent.mm.media.widget.a.b.nU(getPreviewWidth());
    localObject = com.tencent.mm.media.widget.a.b.hsh;
    com.tencent.mm.media.widget.a.b.nT(getPreviewHeight());
    localObject = this.hui;
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
        localObject = com.tencent.mm.media.widget.a.b.hsh;
        com.tencent.mm.media.widget.a.b.nW(this.hrV.ruC);
        localObject = com.tencent.mm.media.widget.a.b.hsh;
        com.tencent.mm.media.widget.a.b.nX(this.hrV.ruD);
        if (i != 0)
        {
          localObject = com.tencent.mm.media.widget.a.b.hsh;
          i = com.tencent.mm.media.widget.a.b.awt();
          localObject = com.tencent.mm.media.widget.a.b.hsh;
          localObject = com.tencent.mm.media.widget.a.b.hsh;
          com.tencent.mm.media.widget.a.b.nW(com.tencent.mm.media.widget.a.b.awu());
          localObject = com.tencent.mm.media.widget.a.b.hsh;
          com.tencent.mm.media.widget.a.b.nX(i);
        }
        localObject = com.tencent.mm.media.widget.a.b.hsh;
        if (!awp()) {
          break label294;
        }
        localObject = d.htV;
        i = d.axf();
        label218:
        com.tencent.mm.media.widget.a.b.nV(i);
        localObject = com.tencent.mm.media.widget.a.b.hsh;
        if (this.hrQ) {
          break label299;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.media.widget.a.b.setFrontCamera(bool);
      localObject = com.tencent.mm.media.widget.a.b.hsh;
      com.tencent.mm.media.widget.a.b.ej(this.hrS);
      localObject = this.hrW;
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
  
  public final int awE()
  {
    AppMethodBeat.i(94162);
    d locald = d.htV;
    if (d.axd())
    {
      AppMethodBeat.o(94162);
      return 0;
    }
    AppMethodBeat.o(94162);
    return 1;
  }
  
  public final int awF()
  {
    AppMethodBeat.i(94163);
    d locald = d.htV;
    int i = d.axf();
    AppMethodBeat.o(94163);
    return i;
  }
  
  public final void awG()
  {
    this.hus = 15;
  }
  
  public final boolean awq()
  {
    AppMethodBeat.i(94158);
    this.huj = true;
    Object localObject = d.htV;
    d.ep(true);
    localObject = c.hts;
    c.awW();
    AppMethodBeat.o(94158);
    return true;
  }
  
  public final void awz()
  {
    AppMethodBeat.i(94138);
    if (!awp())
    {
      AppMethodBeat.o(94138);
      return;
    }
    this.hub.removeCallbacks((Runnable)this.hur);
    AppMethodBeat.o(94138);
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94137);
    if (com.tencent.mm.compatible.util.d.lB(14))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if ((this.hue == null) || (this.hug == null))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if (!awp())
    {
      AppMethodBeat.o(94137);
      return;
    }
    this.hub.removeCallbacks((Runnable)this.hur);
    this.hur.x = paramFloat1;
    this.hur.y = paramFloat2;
    this.hur.surfaceHeight = paramInt2;
    this.hur.surfaceWidth = paramInt1;
    this.hub.postDelayed((Runnable)this.hur, 400L);
    AppMethodBeat.o(94137);
  }
  
  public final void b(g paramg) {}
  
  protected final boolean b(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94149);
    if (this.hue == null)
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
          com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "support continuous picture");
          paramCameraCharacteristics = this.huf;
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
          com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "support continuous video");
          paramCameraCharacteristics = this.huf;
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
        com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(94149);
        return false;
      }
      if (d.a.e.contains(paramCameraCharacteristics, 1))
      {
        com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "support auto focus");
        paramCameraCharacteristics = this.huf;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        }
      }
      else
      {
        label217:
        com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "not support continuous video or auto focus");
      }
    }
  }
  
  public final Point ek(boolean paramBoolean)
  {
    AppMethodBeat.i(94146);
    if (!paramBoolean)
    {
      localPoint = new Point(this.hrV.ruC, this.hrV.ruD);
      AppMethodBeat.o(94146);
      return localPoint;
    }
    if (this.hsE != null)
    {
      localPoint = this.hsE;
      if (localPoint == null) {
        p.gkB();
      }
      AppMethodBeat.o(94146);
      return localPoint;
    }
    Point localPoint = new Point(this.hrV.ruC, this.hrV.ruD);
    AppMethodBeat.o(94146);
    return localPoint;
  }
  
  public final void el(boolean paramBoolean)
  {
    AppMethodBeat.i(94164);
    Object localObject = d.htV;
    localObject = this.huf;
    if (localObject == null) {
      p.gkB();
    }
    d.a(paramBoolean, (CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94164);
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(94165);
    Object localObject = d.htV;
    localObject = this.huf;
    if (localObject == null) {
      p.gkB();
    }
    int i = d.a((CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94165);
    return i;
  }
  
  public final float[] getSupportZoomRatios()
  {
    AppMethodBeat.i(94141);
    if ((this.hun == null) && (this.hui != null))
    {
      localObject = this.hui;
      if (localObject == null) {
        p.gkB();
      }
      localObject = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      if (localObject != null) {}
      for (float f = ((Float)localObject).floatValue();; f = 0.0F)
      {
        f = (int)(f * 10.0F) * 1.0F / 10.0F;
        this.hun = new float[(int)(f * 10.0F)];
        int i = 0;
        int j = (int)(f * 10.0F);
        while (i < j)
        {
          localObject = this.hun;
          if (localObject == null) {
            p.gkB();
          }
          localObject[i] = (i * 1.0F / 10.0F + 1.0F);
          i += 1;
        }
      }
    }
    Object localObject = this.hun;
    AppMethodBeat.o(94141);
    return localObject;
  }
  
  public final void j(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94140);
    if ((this.hue != null) && (awp())) {}
    for (;;)
    {
      float f2;
      try
      {
        com.tencent.mm.sdk.platformtools.ae.d(this.gkG, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (this.aYh)
        {
          com.tencent.mm.sdk.platformtools.ae.d(this.gkG, "triggerSmallZoom, zooming, ignore");
          return;
        }
        this.aYh = true;
        localObject1 = this.huf;
        if (localObject1 != null)
        {
          localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
          localObject3 = this.hui;
          if (localObject3 != null)
          {
            localObject3 = (Rect)((CameraCharacteristics)localObject3).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            if (localObject3 == null) {
              p.gkB();
            }
            f1 = ((Rect)localObject3).width();
            if (localObject1 == null) {
              p.gkB();
            }
            f2 = f1 / ((Rect)localObject1).width();
            localObject1 = this.hui;
            if (localObject1 == null) {
              p.gkB();
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
        f2 = this.htZ + f2;
        if (f2 < f1) {
          break label542;
        }
        com.tencent.mm.sdk.platformtools.ae.d(this.gkG, "triggerSmallZoom, nextZoom: %s", new Object[] { Float.valueOf(f1) });
        f2 = ((Rect)localObject3).width() / f1;
        f1 = ((Rect)localObject3).height() / f1;
        float f3 = (((Rect)localObject3).width() - f2) / 2.0F;
        float f4 = (((Rect)localObject3).height() - f1) / 2.0F;
        localObject1 = new Rect((int)f3, (int)f4, (int)(f2 + f3), (int)(f1 + f4));
        localObject3 = this.huf;
        if (localObject3 != null) {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
        }
        paramBoolean = this.hum;
        if (paramBoolean) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        com.tencent.mm.sdk.platformtools.ae.e(this.gkG, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYh = false;
        AppMethodBeat.o(94140);
      }
      try
      {
        localObject1 = this.hug;
        if (localObject1 != null)
        {
          localObject3 = this.huf;
          if (localObject3 == null) {
            p.gkB();
          }
          ((CameraCaptureSession)localObject1).setRepeatingRequest(((CaptureRequest.Builder)localObject3).build(), (CameraCaptureSession.CaptureCallback)this.huq, this.hub.htf);
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
      float f1 = this.htZ;
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
    com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "takePhoto");
    a(a.a.hsb);
    Object localObject1 = d.htV;
    localObject1 = d.axc();
    Object localObject2 = d.htV;
    if (p.i(localObject1, d.oc(d.htu)))
    {
      localObject1 = c.hts;
      c.awM();
      for (;;)
      {
        try
        {
          if (this.state != 0)
          {
            b(this.hui);
            localObject1 = this.huf;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
            }
            localObject1 = this.huf;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
            }
            localObject1 = this.huf;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
            }
            localObject1 = this.huf;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((CaptureRequest.Builder)localObject1).build();
            if (localObject1 == null) {
              p.gkB();
            }
            this.huh = ((CaptureRequest)localObject1);
            boolean bool = this.hum;
            if (bool) {}
          }
        }
        catch (Exception localException)
        {
          CaptureRequest.Builder localBuilder;
          localc2 = c.hts;
          c.awN();
          com.tencent.mm.sdk.platformtools.ae.m(this.gkG, "take photo in back camera error", new Object[] { localException });
          continue;
          localc1 = null;
          continue;
        }
        try
        {
          localObject1 = this.hug;
          if (localObject1 != null)
          {
            localObject2 = this.huh;
            if (localObject2 == null) {
              p.bdF("previewRequest");
            }
            ((CameraCaptureSession)localObject1).setRepeatingRequest((CaptureRequest)localObject2, (CameraCaptureSession.CaptureCallback)this.huq, this.hub.htf);
          }
        }
        catch (CameraAccessException localCameraAccessException)
        {
          com.tencent.mm.sdk.platformtools.ae.e(this.gkG, "setRepeatingRequest failed, errMsg: ");
        }
      }
      this.state = 0;
      this.hub.removeCallbacks((Runnable)this.hur);
      localObject1 = this.huf;
      if (localObject1 != null) {
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      this.state = 1;
      if (!this.hum)
      {
        localObject1 = this.huf;
        if (localObject1 == null) {
          break label417;
        }
        localObject1 = ((CaptureRequest.Builder)localObject1).build();
        if (localObject1 != null)
        {
          localObject2 = this.hug;
          if (localObject2 != null)
          {
            localBuilder = this.huf;
            localObject1 = localc2;
            if (localBuilder != null) {
              localObject1 = localBuilder.build();
            }
            if (localObject1 == null) {
              p.gkB();
            }
            ((CameraCaptureSession)localObject2).capture((CaptureRequest)localObject1, (CameraCaptureSession.CaptureCallback)this.huq, this.hub.htf);
          }
        }
      }
    }
    for (;;)
    {
      this.hub.hth = paramb;
      AppMethodBeat.o(94157);
      return true;
      localObject1 = null;
      break;
      label417:
      c localc1 = c.hts;
      c.awL();
      axm();
    }
  }
  
  public final void nZ(int paramInt)
  {
    AppMethodBeat.i(94139);
    if (this.hsF > 0)
    {
      AppMethodBeat.o(94139);
      return;
    }
    Object localObject = al.ck(ak.getContext());
    int i = ((Point)localObject).y;
    com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94139);
      return;
    }
    try
    {
      localObject = this.hui;
      if (localObject == null) {
        p.gkB();
      }
      localObject = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      if (localObject != null) {}
      for (float f = ((Float)localObject).floatValue();; f = 0.0F)
      {
        double d = f / (paramInt / 3.0D / 10.0D);
        if (d > 0.0D) {
          this.hsF = ((int)d + 1);
        }
        com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.hsF), Float.valueOf(f) });
        AppMethodBeat.o(94139);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e(this.gkG, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94139);
    }
  }
  
  public final void o(d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(94133);
    this.hsS = paramb;
    d locald = d.htV;
    d.o(paramb);
    AppMethodBeat.o(94133);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(94156);
    Object localObject = this.hub;
    f localf = ((a)localObject).hti;
    if (localf != null) {
      localf.release();
    }
    localObject = ((a)localObject).htg;
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
    if (this.hue != null)
    {
      long l = bu.HQ();
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "release camera beg, %s", new Object[] { Looper.myLooper() });
      this.hub.removeCallbacksAndMessages(null);
      axl();
      localObject = this.mSurface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "release camera end, use %dms, %s", new Object[] { Long.valueOf(bu.aO(l)), Looper.myLooper() });
    }
    this.hsE = null;
    this.hsO = false;
    Object localObject = c.hts;
    c.awK();
    AppMethodBeat.o(94155);
  }
  
  public final boolean s(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94128);
    p.h(paramContext, "context");
    try
    {
      localObject = ak.getContext().getSystemService("camera");
      if (localObject == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(94128);
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(this.gkG, (Throwable)paramContext, "init camera failed!", new Object[0]);
      paramContext = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.auz();
      AppMethodBeat.o(94128);
      return false;
    }
    this.htt = ((CameraManager)localObject);
    Object localObject = d.htV;
    d.a(this.htt);
    if (this.hsO)
    {
      com.tencent.mm.sdk.platformtools.ae.i(this.gkG, "initCamera, already open");
      AppMethodBeat.o(94128);
      return true;
    }
    localObject = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.aux();
    super.s(paramContext, paramBoolean);
    release();
    axl();
    if (paramBoolean) {
      paramContext = d.htV;
    }
    for (paramContext = d.oc(d.htu);; paramContext = d.oc(d.htv))
    {
      com.tencent.mm.sdk.platformtools.ae.m(this.gkG, "use camera id %s, SrvDeviceInfo id %d", new Object[] { paramContext, Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geM.gaK) });
      localObject = c.hts;
      c.awH();
      localObject = this.context;
      if (localObject == null) {
        p.gkB();
      }
      if (bu.checkPermission((Context)localObject, "android.permission.CAMERA")) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.e(this.gkG, "it was lack of the camera permision to open camera");
      AppMethodBeat.o(94128);
      return true;
      paramContext = d.htV;
    }
    try
    {
      if (!this.hud.tryAcquire(2500L, TimeUnit.MILLISECONDS))
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
      localObject = this.htt;
      if (localObject == null) {
        p.gkB();
      }
      ((CameraManager)localObject).openCamera(paramContext, (CameraDevice.StateCallback)this.hup, this.hub.htf);
    }
    catch (CameraAccessException localCameraAccessException)
    {
      label348:
      break label348;
    }
    localObject = d.htV;
    d.htE = paramContext;
    if (paramContext == null) {
      p.gkB();
    }
    p.h(paramContext, "id");
    localObject = d.htt;
    if (localObject != null) {}
    for (paramContext = ((CameraManager)localObject).getCameraCharacteristics(paramContext);; paramContext = null)
    {
      if (paramContext == null) {
        p.gkB();
      }
      paramContext = paramContext.get(CameraCharacteristics.SENSOR_ORIENTATION);
      if (paramContext == null) {
        p.gkB();
      }
      d.htG = ((Number)paramContext).intValue();
      break;
    }
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(94166);
    Object localObject = d.htV;
    CaptureRequest.Builder localBuilder = this.huf;
    if (localBuilder == null) {
      p.gkB();
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
      localObject = d.htt;
      if (localObject != null)
      {
        localObject = ((CameraManager)localObject).getCameraCharacteristics(d.htE);
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
      com.tencent.mm.sdk.platformtools.ae.d(this.gkG, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94142);
      return;
    }
    if ((this.hui != null) && (this.huf != null)) {
      try
      {
        localObject1 = this.hui;
        if (localObject1 == null) {
          p.gkB();
        }
        localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (localObject1 == null) {
          p.gkB();
        }
        int i = ((Rect)localObject1).width() - d.h.a.cm(((Rect)localObject1).width() / paramFloat);
        int j = ((Rect)localObject1).height() - d.h.a.cm(((Rect)localObject1).height() / paramFloat);
        this.hul = new Rect(i / 2, j / 2, ((Rect)localObject1).width() - i / 2, ((Rect)localObject1).height() - j / 2);
        localObject1 = this.huf;
        if (localObject1 == null) {
          p.gkB();
        }
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.SCALER_CROP_REGION, this.hul);
        boolean bool = this.hum;
        if (bool) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        label237:
        com.tencent.mm.sdk.platformtools.ae.e(this.gkG, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
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
      localObject1 = this.hug;
      if (localObject1 != null)
      {
        CaptureRequest.Builder localBuilder = this.huf;
        if (localBuilder == null) {
          p.gkB();
        }
        ((CameraCaptureSession)localObject1).setRepeatingRequest(localBuilder.build(), (CameraCaptureSession.CaptureCallback)this.huq, this.hub.htf);
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/widget/camera2/CommonCamera2$autoFocusRunnable$1", "Ljava/lang/Runnable;", "surfaceHeight", "", "getSurfaceHeight", "()I", "setSurfaceHeight", "(I)V", "surfaceWidth", "getSurfaceWidth", "setSurfaceWidth", "x", "", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "run", "", "plugin-mediaeditor_release"})
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
      e.a(this.huw, this.x, this.y, this.surfaceWidth, this.surfaceHeight);
      AppMethodBeat.o(94117);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/widget/camera2/CommonCamera2$captureStillPicture$2$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "onCaptureCompleted", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "result", "Landroid/hardware/camera2/TotalCaptureResult;", "plugin-mediaeditor_release"})
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
      paramCameraCaptureSession = d.htV;
      paramCameraCaptureSession = e.a(this.huw);
      if (paramCameraCaptureSession == null) {
        p.gkB();
      }
      d.g(paramCameraCaptureSession);
      AppMethodBeat.o(94118);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "camera", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "plugin-mediaeditor_release"})
  public static final class d
    extends CameraDevice.StateCallback
  {
    public final void onDisconnected(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94120);
      p.h(paramCameraDevice, "camera");
      e.g(this.huw).release();
      paramCameraDevice.close();
      e.a(this.huw, null);
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
      e.g(this.huw).release();
      e.a(this.huw, paramCameraDevice);
      AppMethodBeat.o(94119);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "capturePicture", "", "result", "Landroid/hardware/camera2/CaptureResult;", "checkFocusEnd", "", "onCaptureCompleted", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "Landroid/hardware/camera2/TotalCaptureResult;", "onCaptureProgressed", "partialResult", "process", "plugin-mediaeditor_release"})
  public static final class e
    extends CameraCaptureSession.CaptureCallback
  {
    private final void b(CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94122);
      switch (e.h(this.huw))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94122);
        return;
        Object localObject = d.htV;
        d.a(paramCaptureResult);
        AppMethodBeat.o(94122);
        return;
        localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if ((localObject == null) || (2 == ((Integer)localObject).intValue()) || (6 == ((Integer)localObject).intValue()))
        {
          e.i(this.huw);
          AppMethodBeat.o(94122);
          return;
        }
        if ((4 == ((Integer)localObject).intValue()) || (5 == ((Integer)localObject).intValue()))
        {
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 2))
          {
            e.i(this.huw);
            AppMethodBeat.o(94122);
            return;
          }
          e.j(this.huw);
        }
        AppMethodBeat.o(94122);
        return;
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 5) || (paramCaptureResult.intValue() == 4))
        {
          e.a(this.huw, 3);
          AppMethodBeat.o(94122);
          return;
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() != 5))
          {
            e.i(this.huw);
            AppMethodBeat.o(94122);
            return;
            if (this.huw.awp())
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
                if ((i == 0) || (e.d(this.huw))) {
                  break label534;
                }
                com.tencent.mm.sdk.platformtools.ae.i(e.k(this.huw), "STATE_TOUCH_CAF_WAITING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
                this.huw.b(e.l(this.huw));
                paramCaptureResult = e.a(this.huw);
                if (paramCaptureResult != null) {
                  paramCaptureResult.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                }
                localObject = this.huw;
                paramCaptureResult = e.a(this.huw);
                if (paramCaptureResult == null) {
                  break label513;
                }
              }
              label513:
              for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
              {
                if (paramCaptureResult == null) {
                  p.gkB();
                }
                e.a((e)localObject, paramCaptureResult);
                try
                {
                  paramCaptureResult = e.e(this.huw);
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(e.m(this.huw), (CameraCaptureSession.CaptureCallback)this, this.huw.hub.htf);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.ae.e(e.b(this.huw), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                e.a(this.huw, 6);
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
            com.tencent.mm.sdk.platformtools.ae.e(e.b(this.huw), "current is not allowed to do anything casue capturing");
            AppMethodBeat.o(94122);
            return;
            if ((this.huw.awp()) && (!e.d(this.huw)))
            {
              com.tencent.mm.sdk.platformtools.ae.i(e.k(this.huw), "STATE_TOUCH_FOCUSING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
              paramCaptureResult = e.a(this.huw);
              if (paramCaptureResult != null) {
                paramCaptureResult.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
              }
              paramCaptureResult = e.a(this.huw);
              if (paramCaptureResult != null) {
                paramCaptureResult.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
              }
              localObject = this.huw;
              paramCaptureResult = e.a(this.huw);
              if (paramCaptureResult != null) {}
              for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
              {
                if (paramCaptureResult == null) {
                  p.gkB();
                }
                e.a((e)localObject, paramCaptureResult);
                try
                {
                  paramCaptureResult = e.e(this.huw);
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(e.m(this.huw), (CameraCaptureSession.CaptureCallback)this, this.huw.hub.htf);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.ae.e(e.b(this.huw), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                e.a(this.huw, 0);
                AppMethodBeat.o(94122);
                return;
              }
            }
            com.tencent.mm.sdk.platformtools.ae.e(e.b(this.huw), "current is not allowed to do anything casue capturing");
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onClosed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigureFailed", "onConfigured", "plugin-mediaeditor_release"})
  public static final class f
    extends CameraCaptureSession.StateCallback
  {
    public final void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94127);
      p.h(paramCameraCaptureSession, "session");
      super.onClosed(paramCameraCaptureSession);
      com.tencent.mm.sdk.platformtools.ae.i(e.b(this.huw), "session on close");
      e.a(this.huw, true);
      AppMethodBeat.o(94127);
    }
    
    public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94126);
      p.h(paramCameraCaptureSession, "session");
      com.tencent.mm.sdk.platformtools.ae.i(e.b(this.huw), "configure failed ");
      paramCameraCaptureSession = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.auz();
      paramCameraCaptureSession = c.hts;
      c.awJ();
      AppMethodBeat.o(94126);
    }
    
    public final void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94125);
      p.h(paramCameraCaptureSession, "session");
      com.tencent.mm.sdk.platformtools.ae.i(e.b(this.huw), "session on onConfigured");
      if (e.c(this.huw) == null)
      {
        AppMethodBeat.o(94125);
        return;
      }
      e.a(this.huw, false);
      e.a(this.huw, paramCameraCaptureSession);
      paramCameraCaptureSession = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.auy();
      paramCameraCaptureSession = c.hts;
      c.awI();
      e.f(this.huw);
      AppMethodBeat.o(94125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e
 * JD-Core Version:    0.7.0.1
 */