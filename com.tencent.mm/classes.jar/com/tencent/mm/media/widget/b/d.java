package com.tencent.mm.media.widget.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
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
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.media.util.f;
import com.tencent.mm.media.widget.b.a.c.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "FOCUS_TAG", "", "getFOCUS_TAG", "()Ljava/lang/String;", "FOCUS_TAG$1", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "TAG$1", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "isUseRecordStream", "", "()Z", "setUseRecordStream", "(Z)V", "mCameraDevice", "Landroid/hardware/camera2/CameraDevice;", "getMCameraDevice", "()Landroid/hardware/camera2/CameraDevice;", "setMCameraDevice", "(Landroid/hardware/camera2/CameraDevice;)V", "mCameraDeviceCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1;", "mCameraFps", "", "getMCameraFps", "()I", "setMCameraFps", "(I)V", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "mCameraOpenCloseLock", "Ljava/util/concurrent/Semaphore;", "getMCameraOpenCloseLock", "()Ljava/util/concurrent/Semaphore;", "mCaptureCallback", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "getMCaptureCallback", "()Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "mCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "getMCaptureSession", "()Landroid/hardware/camera2/CameraCaptureSession;", "setMCaptureSession", "(Landroid/hardware/camera2/CameraCaptureSession;)V", "mCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getMCharacteristics", "()Landroid/hardware/camera2/CameraCharacteristics;", "setMCharacteristics", "(Landroid/hardware/camera2/CameraCharacteristics;)V", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsNoAFRun", "getMIsNoAFRun", "setMIsNoAFRun", "mIsSessionClose", "getMIsSessionClose", "setMIsSessionClose", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mPreviewBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "getMPreviewBuilder", "()Landroid/hardware/camera2/CaptureRequest$Builder;", "setMPreviewBuilder", "(Landroid/hardware/camera2/CaptureRequest$Builder;)V", "mPreviewRect", "Landroid/graphics/Rect;", "getMPreviewRect", "()Landroid/graphics/Rect;", "setMPreviewRect", "(Landroid/graphics/Rect;)V", "mStateCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1;", "mSurface", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mTransformer", "Lcom/tencent/mm/media/widget/camera2/CameraFocusCoordinateTrans;", "getMTransformer", "()Lcom/tencent/mm/media/widget/camera2/CameraFocusCoordinateTrans;", "setMTransformer", "(Lcom/tencent/mm/media/widget/camera2/CameraFocusCoordinateTrans;)V", "mZoomTimesToRatio", "", "getMZoomTimesToRatio", "()[F", "setMZoomTimesToRatio", "([F)V", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "previewRequest", "Landroid/hardware/camera2/CaptureRequest;", "getPreviewRequest", "()Landroid/hardware/camera2/CaptureRequest;", "setPreviewRequest", "(Landroid/hardware/camera2/CaptureRequest;)V", "state", "getState", "setState", "zoomOutRect", "getZoomOutRect", "setZoomOutRect", "abandonFocus", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateLocDiff", "loc1", "loc2", "calculateTapArea", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "captureStillPicture", "checkCameraOpenSucc", "scene", "clamp", "min", "max", "closeCamera", "configVendorTagValue", "tag", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCameraSensorRotate", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getPreviewWidth", "getSupportPreviewSize", "", "Landroid/util/Size;", "()[Landroid/util/Size;", "getSupportZoomRatios", "getValidAFMode", "targetMode", "initCamera", "useBack", "initRawRatios", "isMeteringSupport", "lock3AParams", "builder", "lockFocus", "openCamera", "nowCameraId", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "resumePreview", "runPrecaptureSequence", "safeResetZoom", "safeSetFocusMode", "characteristics", "safeSetMetering", "safeSetOIS", "safeSetPreviewFrameRate", "useFixMode", "safeSetStabilization", "safeSetVendorEffect", "selectNoCropPreviewSize", "resolutionLimit", "selectRatioAndResolutionLimitPreviewSize", "ratio", "longSideLimit", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "setPreviewSize", "width", "height", "setSafeConfig", "startPreview", "useCpuCrop", "(Landroid/graphics/SurfaceTexture;ZLjava/lang/Float;I)V", "surface", "startPreviewWithGPU", "startPreviewWithGPURatio", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "trySetPreviewFrameRateParameters", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends com.tencent.mm.media.widget.a.a
{
  private static final SparseIntArray nHN;
  public static final d.a nHx;
  CameraDevice AF;
  private final CameraCaptureSession.CaptureCallback Cd;
  private CameraManager Fk;
  private ImageReader imageReader;
  private Surface mSurface;
  private final String mgf;
  private kotlin.g.a.b<? super Boolean, ah> nGB;
  private int nGC;
  private boolean nGD;
  private float nGp;
  CaptureRequest.Builder nHA;
  CameraCaptureSession nHB;
  protected CaptureRequest nHC;
  private CameraCharacteristics nHD;
  private b nHE;
  private Rect nHF;
  boolean nHG;
  private boolean nHH;
  private boolean nHI;
  private Rect nHJ;
  private float[] nHK;
  private final e nHL;
  private final c nHM;
  final String nHy;
  final Semaphore nHz;
  int state;
  
  static
  {
    AppMethodBeat.i(94168);
    nHx = new d.a((byte)0);
    SparseIntArray localSparseIntArray = new SparseIntArray();
    nHN = localSparseIntArray;
    localSparseIntArray.append(0, 90);
    nHN.append(1, 0);
    nHN.append(2, 270);
    nHN.append(3, 180);
    AppMethodBeat.o(94168);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94167);
    this.mgf = "MicroMsg.CommonCamera2";
    this.nHy = "MicroMsg.CommonCamera2.FoucsTag";
    this.nGp = 0.1F;
    this.nHz = new Semaphore(1);
    if (com.tencent.mm.media.widget.d.c.bvu())
    {
      paramContext = new com.tencent.mm.media.widget.b.a.c(paramContext);
      q localq = (q)1.nHO;
      s.u(localq, "mSupportWCKeyAvailable");
      paramContext.aa((kotlin.g.a.a)new c.a(paramContext, localq));
      paramContext = c.nGZ;
      c.btr();
    }
    this.nHL = new e(this);
    this.nHM = new c(this);
    this.Cd = ((CameraCaptureSession.CaptureCallback)new d(this));
    this.nGD = true;
    AppMethodBeat.o(94167);
  }
  
  private final boolean b(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(237595);
    for (;;)
    {
      int j;
      try
      {
        localObject1 = this.nHD;
        s.checkNotNull(localObject1);
        localObject1 = (StreamConfigurationMap)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null) {
          continue;
        }
        localObject3 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
        s.s(localObject3, "map.getOutputSizes(SurfaceTexture::class.java)");
        localObject3 = (Object[])localObject3;
        if (localObject3.length > 1) {
          kotlin.a.k.a((Object[])localObject3, (Comparator)new d.f());
        }
        localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
        s.s(localObject1, "map.getOutputSizes(SurfaceTexture::class.java)");
        localObject3 = (Object[])localObject1;
        int k = localObject3.length;
        i = 0;
        if (i >= k) {
          break label407;
        }
        localObject1 = localObject3[i];
        Size localSize = (Size)localObject1;
        if ((Math.abs(localSize.getWidth() * 1.0F / localSize.getHeight() - paramFloat) > 0.1D) || (localSize.getWidth() > paramInt)) {
          break label394;
        }
        j = 1;
      }
      catch (CameraAccessException localCameraAccessException)
      {
        Object localObject1;
        Object localObject3;
        AppMethodBeat.o(237595);
        return false;
      }
      localObject1 = (Size)localObject1;
      if (localObject1 == null)
      {
        AppMethodBeat.o(237595);
        return false;
      }
      Log.i(this.mgf, "selectRatioAndResolutionLimitPreviewSize final select target:" + ((Size)localObject1).getWidth() + 'x' + ((Size)localObject1).getHeight());
      localObject3 = getSurfaceTexture();
      if (localObject3 != null) {
        ((SurfaceTexture)localObject3).setDefaultBufferSize(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight());
      }
      bss().zWH = ((Size)localObject1).getWidth();
      bss().zWI = ((Size)localObject1).getHeight();
      localObject1 = new Size(bss().zWH, bss().zWI);
      paramInt = ((Size)localObject1).getWidth();
      int i = ((Size)localObject1).getHeight();
      localObject1 = c.nGZ;
      localObject1 = ImageReader.newInstance(paramInt, i, c.bto(), 1);
      ((ImageReader)localObject1).setOnImageAvailableListener(bso().nGQ, bso().nGI);
      localObject3 = ah.aiuX;
      this.imageReader = ((ImageReader)localObject1);
      AppMethodBeat.o(237595);
      return true;
      for (;;)
      {
        if (j == 0) {
          break label400;
        }
        break;
        label394:
        j = 0;
      }
      label400:
      i += 1;
      continue;
      label407:
      Object localObject2 = null;
    }
  }
  
  private final void btA()
  {
    AppMethodBeat.i(94161);
    if (this.nHA == null)
    {
      AppMethodBeat.o(94161);
      return;
    }
    CameraCaptureSession localCameraCaptureSession;
    if ((this.AF != null) && (!this.nHG))
    {
      localObject = this.nHA;
      if (localObject != null) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      }
      localObject = this.nHA;
      s.checkNotNull(localObject);
      h((CaptureRequest.Builder)localObject);
      localCameraCaptureSession = this.nHB;
      if (localCameraCaptureSession != null)
      {
        localObject = this.nHA;
        if (localObject != null) {
          break label115;
        }
      }
    }
    label115:
    for (Object localObject = null;; localObject = ((CaptureRequest.Builder)localObject).build())
    {
      s.checkNotNull(localObject);
      localCameraCaptureSession.setRepeatingRequest((CaptureRequest)localObject, this.Cd, bso().nGI);
      AppMethodBeat.o(94161);
      return;
    }
  }
  
  private final void bty()
  {
    AppMethodBeat.i(94129);
    try
    {
      if (this.nHA != null)
      {
        localObject1 = c.nGZ;
        localObject1 = this.nHA;
        s.checkNotNull(localObject1);
        c.g((CaptureRequest.Builder)localObject1);
      }
      this.nHz.acquire();
      Object localObject1 = this.nHB;
      if (localObject1 != null) {
        ((CameraCaptureSession)localObject1).close();
      }
      this.nHB = null;
      localObject1 = this.AF;
      if (localObject1 != null) {
        ((CameraDevice)localObject1).close();
      }
      this.AF = null;
      localObject1 = this.imageReader;
      if (localObject1 != null) {
        ((ImageReader)localObject1).setOnImageAvailableListener(null, bso().nGI);
      }
      localObject1 = this.imageReader;
      if (localObject1 != null) {
        ((ImageReader)localObject1).close();
      }
      this.imageReader = null;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      RuntimeException localRuntimeException = new RuntimeException("Interrupt while trying to lock camera closing", (Throwable)localInterruptedException);
      AppMethodBeat.o(94129);
      throw localRuntimeException;
    }
    finally
    {
      this.nHz.release();
      AppMethodBeat.o(94129);
    }
  }
  
  private final void btz()
  {
    Object localObject2 = null;
    AppMethodBeat.i(94134);
    try
    {
      if (this.state == 4)
      {
        Log.printInfoStack(this.mgf, "capture still picture more than twice", new Object[0]);
        AppMethodBeat.o(94134);
        return;
      }
      this.state = 4;
      Log.i(this.mgf, "captureStillPicture");
      if (this.AF != null) {
        break label102;
      }
      AppMethodBeat.o(94134);
      return;
    }
    catch (Exception localException)
    {
      localObject2 = c.nGZ;
      if (!c.btn())
      {
        localObject2 = com.tencent.mm.media.widget.d.a.nMV;
        com.tencent.mm.media.widget.d.a.buY();
      }
      Log.e(this.mgf, localException.toString());
    }
    AppMethodBeat.o(94134);
    return;
    label102:
    Object localObject1 = this.nHA;
    if (localObject1 == null) {}
    for (localObject1 = null; (this.AF == null) || (this.nHG); localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION))
    {
      AppMethodBeat.o(94134);
      return;
    }
    Object localObject3 = this.AF;
    if (localObject3 == null) {}
    for (localObject1 = null;; localObject1 = null)
    {
      this.nHA = ((CaptureRequest.Builder)localObject1);
      localObject3 = this.nHB;
      if (localObject3 == null) {
        break;
      }
      ((CameraCaptureSession)localObject3).stopRepeating();
      Log.i(this.nHy, "this time happened a cancel auto foucs while capture");
      localObject1 = this.nHA;
      if (localObject1 != null) {
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
      }
      localObject1 = this.nHA;
      if (localObject1 != null) {
        break label544;
      }
      localObject1 = localObject2;
      label223:
      s.checkNotNull(localObject1);
      ((CameraCaptureSession)localObject3).capture((CaptureRequest)localObject1, (CameraCaptureSession.CaptureCallback)new b(this), null);
      AppMethodBeat.o(94134);
      return;
      localObject3 = ((CameraDevice)localObject3).createCaptureRequest(2);
      if (localObject3 != null) {
        break label271;
      }
    }
    label271:
    ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
    localObject1 = this.imageReader;
    if (localObject1 == null)
    {
      localObject1 = null;
      label291:
      s.checkNotNull(localObject1);
      ((CaptureRequest.Builder)localObject3).addTarget((Surface)localObject1);
      localObject1 = this.imageReader;
      if (localObject1 != null) {
        ((ImageReader)localObject1).setOnImageAvailableListener(bso().nGQ, bso().nGI);
      }
      ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
      localObject1 = this.nHD;
      if (localObject1 != null) {
        break label487;
      }
      localObject1 = null;
      label351:
      if (localObject1 == null) {
        break label552;
      }
      if (!s.a((Float)localObject1, 0.0F)) {
        break label557;
      }
      break label552;
    }
    for (;;)
    {
      this.nHI = bool;
      if (!this.nHI)
      {
        localObject1 = this.nHD;
        if (localObject1 == null)
        {
          localObject1 = null;
          label389:
          if (!com.tencent.mm.compatible.loader.a.contains((int[])localObject1, 4)) {
            break label515;
          }
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        }
      }
      else
      {
        label409:
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
        localObject1 = this.nHD;
        if (localObject1 != null) {
          break label530;
        }
      }
      label515:
      label530:
      for (localObject1 = null;; localObject1 = (int[])((CameraCharacteristics)localObject1).get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES))
      {
        if (com.tencent.mm.compatible.loader.a.contains((int[])localObject1, 1)) {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(1));
        }
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        h((CaptureRequest.Builder)localObject3);
        localObject1 = ah.aiuX;
        localObject1 = localObject3;
        break;
        localObject1 = ((ImageReader)localObject1).getSurface();
        break label291;
        label487:
        localObject1 = (Float)((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
        break label351;
        localObject1 = (int[])((CameraCharacteristics)localObject1).get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        break label389;
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        break label409;
      }
      label544:
      localObject1 = ((CaptureRequest.Builder)localObject1).build();
      break label223;
      label552:
      boolean bool = true;
      continue;
      label557:
      bool = false;
    }
  }
  
  private static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private final boolean gE(boolean paramBoolean)
  {
    AppMethodBeat.i(237618);
    if (paramBoolean)
    {
      localObject = this.nHD;
      s.checkNotNull(localObject);
      localObject = ((CameraCharacteristics)localObject).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
      s.checkNotNull(localObject);
    }
    for (Object localObject = (Integer)localObject;; localObject = (Integer)localObject)
    {
      s.s(localObject, "if (focusArea) {\n       …X_REGIONS_AE)!!\n        }");
      if (((Number)localObject).intValue() <= 0) {
        break;
      }
      AppMethodBeat.o(237618);
      return true;
      localObject = this.nHD;
      s.checkNotNull(localObject);
      localObject = ((CameraCharacteristics)localObject).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
      s.checkNotNull(localObject);
    }
    AppMethodBeat.o(237618);
    return false;
  }
  
  private static void h(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94152);
    c localc = c.nGZ;
    c.b(paramBuilder);
    localc = c.nGZ;
    c.d(paramBuilder);
    localc = c.nGZ;
    c.e(paramBuilder);
    localc = c.nGZ;
    c.c(paramBuilder);
    localc = c.nGZ;
    c.f(paramBuilder);
    AppMethodBeat.o(94152);
  }
  
  public final boolean A(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94128);
    s.u(paramContext, "context");
    try
    {
      localObject = MMApplicationContext.getContext().getSystemService("camera");
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(94128);
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace(this.mgf, (Throwable)paramContext, "init camera failed!", new Object[0]);
      paramContext = f.nFE;
      f.bqx();
      AppMethodBeat.o(94128);
      return false;
    }
    this.Fk = ((CameraManager)localObject);
    Object localObject = c.nGZ;
    c.a(this.Fk);
    if (bsA())
    {
      Log.i(this.mgf, "initCamera, already open");
      AppMethodBeat.o(94128);
      return true;
    }
    localObject = f.nFE;
    f.bqv();
    super.A(paramContext, paramBoolean);
    release();
    bty();
    if (paramBoolean)
    {
      paramContext = c.nGZ;
      paramContext = c.btk();
      Log.printInfoStack(this.mgf, "use camera id %s, SrvDeviceInfo id %d", new Object[] { paramContext, Integer.valueOf(af.lXY.lTr) });
      localObject = com.tencent.mm.media.widget.d.a.nMV;
      com.tencent.mm.media.widget.d.a.buR();
      localObject = getContext();
      s.checkNotNull(localObject);
      if (Util.checkPermission((Context)localObject, "android.permission.CAMERA")) {
        break label243;
      }
      Log.e(this.mgf, "it was lack of the camera permision to open camera");
    }
    for (;;)
    {
      AppMethodBeat.o(94128);
      return true;
      paramContext = c.nGZ;
      paramContext = c.btl();
      break;
      try
      {
        label243:
        if (!this.nHz.tryAcquire(2500L, TimeUnit.MILLISECONDS))
        {
          paramContext = new RuntimeException("Time out waiting to lock camera opening");
          AppMethodBeat.o(94128);
          throw paramContext;
        }
      }
      catch (InterruptedException paramContext)
      {
        paramContext = new RuntimeException("interrupt while  trying to lock camera opening", (Throwable)paramContext);
        AppMethodBeat.o(94128);
        throw paramContext;
      }
      try
      {
        localObject = this.Fk;
        s.checkNotNull(localObject);
        CameraDevice.StateCallback localStateCallback = (CameraDevice.StateCallback)this.nHM;
        Handler localHandler = bso().nGI;
        com.tencent.mm.hellhoundlib.a.a.a(localObject, new com.tencent.mm.hellhoundlib.b.a().cG(localHandler).cG(localStateCallback).cG(paramContext).aYi(), "com/tencent/mm/media/widget/camera2/CommonCamera2", "openCamera", "(Ljava/lang/String;)V", "android/hardware/camera2/CameraManager", "openCamera", "(Ljava/lang/String;Landroid/hardware/camera2/CameraDevice$StateCallback;Landroid/os/Handler;)V");
        label376:
        localObject = c.nGZ;
        c.nHg = paramContext;
        s.checkNotNull(paramContext);
        s.u(paramContext, "id");
        localObject = c.Fk;
        if (localObject == null) {}
        for (paramContext = null;; paramContext = ((CameraManager)localObject).getCameraCharacteristics(paramContext))
        {
          s.checkNotNull(paramContext);
          paramContext = paramContext.get(CameraCharacteristics.SENSOR_ORIENTATION);
          s.checkNotNull(paramContext);
          s.s(paramContext, "mCameraManager?.getCamer…ics.SENSOR_ORIENTATION)!!");
          c.nHi = ((Number)paramContext).intValue();
          break;
        }
      }
      catch (CameraAccessException localCameraAccessException)
      {
        break label376;
      }
    }
  }
  
  public final void G(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94159);
    s.u(paramString, "tag");
    com.tencent.mm.media.widget.b.a.a.b.a locala = com.tencent.mm.media.widget.b.a.a.b.nIE;
    if (s.p(paramString, com.tencent.mm.media.widget.b.a.a.b.btM()))
    {
      paramString = c.nGZ;
      c.gD(paramBoolean);
    }
    for (;;)
    {
      btA();
      AppMethodBeat.o(94159);
      return;
      locala = com.tencent.mm.media.widget.b.a.a.b.nIE;
      if (s.p(paramString, com.tencent.mm.media.widget.b.a.a.b.btR()))
      {
        paramString = c.nGZ;
        c.gz(paramBoolean);
      }
      else
      {
        locala = com.tencent.mm.media.widget.b.a.a.b.nIE;
        if (s.p(paramString, com.tencent.mm.media.widget.b.a.a.b.btQ()))
        {
          paramString = c.nGZ;
          c.gA(paramBoolean);
        }
        else
        {
          locala = com.tencent.mm.media.widget.b.a.a.b.nIE;
          if (s.p(paramString, com.tencent.mm.media.widget.b.a.a.b.btT()))
          {
            paramString = c.nGZ;
            c.gB(paramBoolean);
          }
          else
          {
            locala = com.tencent.mm.media.widget.b.a.a.b.nIE;
            if (s.p(paramString, com.tencent.mm.media.widget.b.a.a.b.btS()))
            {
              paramString = c.nGZ;
              c.gC(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  public final boolean H(kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    com.tencent.mm.media.widget.d.a locala = null;
    AppMethodBeat.i(94157);
    s.u(paramb, "dataCallback");
    Log.i(this.mgf, "takePhoto");
    a(com.tencent.mm.media.widget.a.a.a.nGh);
    Object localObject1 = c.nGZ;
    localObject1 = c.btm();
    Object localObject3 = c.nGZ;
    if (s.p(localObject1, c.us(c.nHa)))
    {
      localObject1 = com.tencent.mm.media.widget.d.a.nMV;
      com.tencent.mm.media.widget.d.a.buW();
      for (;;)
      {
        try
        {
          if (this.state != 0)
          {
            a(this.nHD);
            localObject1 = this.nHA;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
            }
            localObject1 = this.nHA;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
            }
            localObject1 = this.nHA;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
            }
            localObject1 = this.nHA;
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
            s.checkNotNull(localObject1);
            s.s(localObject1, "mPreviewBuilder?.build()!!");
            c((CaptureRequest)localObject1);
            boolean bool = this.nHG;
            if (bool) {}
          }
        }
        catch (Exception localException)
        {
          locala = com.tencent.mm.media.widget.d.a.nMV;
          com.tencent.mm.media.widget.d.a.buX();
          Log.printInfoStack(this.mgf, "take photo in back camera error", new Object[] { localException });
          continue;
          localObject2 = localException.build();
          continue;
          localObject2 = ((CaptureRequest.Builder)localObject2).build();
          continue;
        }
        try
        {
          localObject1 = this.nHB;
          if (localObject1 != null) {
            ((CameraCaptureSession)localObject1).setRepeatingRequest(btv(), this.Cd, bso().nGI);
          }
        }
        catch (CameraAccessException localCameraAccessException)
        {
          Log.e(this.mgf, "setRepeatingRequest failed, errMsg: ");
        }
      }
      this.state = 0;
      bso().removeCallbacksAndMessages(null);
      localObject1 = this.nHA;
      if (localObject1 != null) {
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      this.state = 1;
      if (!this.nHG)
      {
        localObject1 = this.nHA;
        if (localObject1 != null) {
          break label380;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject3 = this.nHB;
          if (localObject3 != null)
          {
            localObject1 = this.nHA;
            if (localObject1 != null) {
              break label388;
            }
            localObject1 = locala;
            s.checkNotNull(localObject1);
            ((CameraCaptureSession)localObject3).capture((CaptureRequest)localObject1, this.Cd, bso().nGI);
          }
        }
      }
    }
    for (;;)
    {
      bso().nGK = paramb;
      AppMethodBeat.o(94157);
      return true;
      localObject1 = ((CaptureRequest.Builder)localObject1).build();
      break;
      label380:
      Object localObject2 = com.tencent.mm.media.widget.d.a.nMV;
      label388:
      com.tencent.mm.media.widget.d.a.buV();
      btz();
    }
  }
  
  public final void I(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(94133);
    this.nGB = paramb;
    c localc = c.nGZ;
    c.I(paramb);
    AppMethodBeat.o(94133);
  }
  
  public final Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237828);
    paramInt1 = (int)(4.0F * paramFloat3);
    paramInt2 = (int)paramFloat1;
    Object localObject1 = this.nHF;
    s.checkNotNull(localObject1);
    int i = ((Rect)localObject1).width() / paramInt1 / 2;
    localObject1 = this.nHF;
    s.checkNotNull(localObject1);
    int j = ((Rect)localObject1).left;
    localObject1 = this.nHF;
    s.checkNotNull(localObject1);
    int k = ((Rect)localObject1).right;
    localObject1 = this.nHF;
    s.checkNotNull(localObject1);
    paramInt2 = clamp(paramInt2 - i, j, k - ((Rect)localObject1).width() / paramInt1);
    i = (int)paramFloat2;
    localObject1 = this.nHF;
    s.checkNotNull(localObject1);
    j = ((Rect)localObject1).width() / paramInt1 / 2;
    localObject1 = this.nHF;
    s.checkNotNull(localObject1);
    k = ((Rect)localObject1).top;
    localObject1 = this.nHF;
    s.checkNotNull(localObject1);
    int m = ((Rect)localObject1).bottom;
    localObject1 = this.nHF;
    s.checkNotNull(localObject1);
    i = clamp(i - j, k, m - ((Rect)localObject1).width() / paramInt1);
    paramFloat1 = paramInt2;
    paramFloat2 = i;
    localObject1 = this.nHF;
    s.checkNotNull(localObject1);
    paramFloat3 = paramInt2 + ((Rect)localObject1).width() / paramInt1;
    localObject1 = this.nHF;
    s.checkNotNull(localObject1);
    localObject1 = new RectF(paramFloat1, paramFloat2, paramFloat3, ((Rect)localObject1).width() / paramInt1 + i);
    Object localObject2 = this.nHE;
    s.checkNotNull(localObject2);
    s.u(localObject1, "source");
    RectF localRectF = new RectF();
    localObject2 = ((b)localObject2).nuG;
    if (localObject2 != null) {
      ((Matrix)localObject2).mapRect(localRectF, (RectF)localObject1);
    }
    s.u(localRectF, "rectF");
    localObject1 = new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
    AppMethodBeat.o(237828);
    return localObject1;
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94130);
    this.nHz.acquire();
    this.nHz.release();
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    b(paramSurfaceTexture, null, paramInt);
    AppMethodBeat.o(94130);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, Float paramFloat, int paramInt)
  {
    AppMethodBeat.i(237703);
    this.nHz.acquire();
    this.nHz.release();
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    a(paramFloat);
    if (paramFloat != null)
    {
      float f = paramFloat.floatValue();
      long l = Util.currentTicks();
      Log.i(this.mgf, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + null);
      if (bsD())
      {
        Log.i(this.mgf, "startPreviewWithGPU, camera previewing");
        AppMethodBeat.o(237703);
        return;
      }
      paramFloat = this.Fk;
      Object localObject = c.nGZ;
      localObject = c.btm();
      if ((paramFloat == null) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        Log.e(this.mgf, "startPreviewWithGPURatio error");
        AppMethodBeat.o(237703);
        return;
      }
      try
      {
        s.checkNotNull(localObject);
        this.nHD = paramFloat.getCameraCharacteristics((String)localObject);
        if (b(f, paramInt)) {
          break label279;
        }
        b(paramSurfaceTexture, null, paramInt);
        AppMethodBeat.o(237703);
        return;
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.e(this.mgf, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = f.nFE;
        f.bqx();
      }
      Log.i(this.mgf, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(237703);
      return;
      label279:
      if (this.nHH)
      {
        paramFloat = this.AF;
        if (paramFloat == null) {
          paramFloat = null;
        }
      }
      for (;;)
      {
        this.nHA = paramFloat;
        bta();
        if (!a(paramSurfaceTexture, null)) {
          break;
        }
        a(com.tencent.mm.media.widget.a.a.a.nGg);
        this.state = 0;
        break;
        paramFloat = paramFloat.createCaptureRequest(3);
        continue;
        paramFloat = this.AF;
        if (paramFloat == null) {
          paramFloat = null;
        } else {
          paramFloat = paramFloat.createCaptureRequest(1);
        }
      }
    }
    a(paramSurfaceTexture, paramBoolean, paramInt);
    AppMethodBeat.o(237703);
  }
  
  protected void a(CameraCharacteristics paramCameraCharacteristics, int paramInt)
  {
    AppMethodBeat.i(237790);
    if (af.lXY.lTg > 0)
    {
      Log.i(bsm(), "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(237790);
      return;
    }
    if (paramCameraCharacteristics == null)
    {
      paramCameraCharacteristics = null;
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
      AppMethodBeat.o(237790);
      return;
      paramCameraCharacteristics = (Range[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
      break;
    }
    label79:
    int m = -2147483648;
    int j = -2147483648;
    int i4 = paramCameraCharacteristics.length;
    i = m;
    int k;
    int i3;
    Integer localInteger2;
    int i2;
    int i1;
    Integer localInteger1;
    if (i4 > 0)
    {
      j = 0;
      k = 0;
      i = -2147483648;
      i3 = j + 1;
      localInteger2 = paramCameraCharacteristics[j];
      i2 = i;
      i1 = m;
      if (localInteger2 == null) {
        break label574;
      }
      localInteger1 = (Integer)localInteger2.getLower();
      localInteger2 = (Integer)localInteger2.getUpper();
      Log.i(this.mgf, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(j), localInteger1, localInteger2 });
      s.s(localInteger1, "min");
      if (localInteger1.intValue() >= 0)
      {
        s.s(localInteger2, "max");
        if (localInteger2.intValue() >= localInteger1.intValue()) {
          break label300;
        }
      }
      j = k;
    }
    for (;;)
    {
      if (i3 >= i4)
      {
        j = i;
        i = m;
        Log.i(bsm(), "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(30) });
        if ((i == 2147483647) || (j == 2147483647))
        {
          AppMethodBeat.o(237790);
          return;
          label300:
          if (paramInt == 0) {}
          for (i1 = 30;; i1 = paramInt)
          {
            j = i;
            n = m;
            if (localInteger2.intValue() >= i)
            {
              j = i;
              n = m;
              if (k == 0)
              {
                j = i;
                n = m;
                if (localInteger2.intValue() <= i1)
                {
                  n = localInteger1.intValue();
                  j = localInteger2.intValue();
                }
              }
            }
            if (paramInt == 0) {
              break label411;
            }
            i2 = j;
            i1 = n;
            if (localInteger2.intValue() != paramInt) {
              break label574;
            }
            k = 1;
            i = j;
            j = k;
            m = n;
            break;
          }
          label411:
          i2 = j;
          i1 = n;
          if (localInteger2.intValue() != 30) {
            break label574;
          }
          k = 1;
          i = j;
          j = k;
          m = n;
          continue;
        }
        try
        {
          paramCameraCharacteristics = this.nHA;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range((Comparable)Integer.valueOf(i), (Comparable)Integer.valueOf(j)));
          }
          Log.i(bsm(), "set fps range %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(237790);
          return;
        }
        catch (Exception paramCameraCharacteristics)
        {
          Log.i(bsm(), "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
          AppMethodBeat.o(237790);
          return;
        }
      }
      k = i3;
      int n = j;
      j = k;
      k = n;
      break;
      label574:
      j = k;
      i = i2;
      m = i1;
    }
  }
  
  protected final void a(ImageReader paramImageReader)
  {
    this.imageReader = paramImageReader;
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94131);
    this.nHz.acquire();
    this.nHz.release();
    super.a(paramSurfaceHolder, paramBoolean, paramInt);
    b(null, paramSurfaceHolder, paramInt);
    AppMethodBeat.o(94131);
  }
  
  public final void a(g paramg) {}
  
  protected final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    Object localObject1 = null;
    Surface localSurface = null;
    AppMethodBeat.i(94135);
    Object localObject2 = this.nHA;
    if (localObject2 != null)
    {
      if ((paramSurfaceTexture != null) || (paramSurfaceHolder != null))
      {
        int j;
        int i;
        if (paramSurfaceTexture != null)
        {
          this.mSurface = new Surface(paramSurfaceTexture);
          paramSurfaceTexture = this.mSurface;
          s.checkNotNull(paramSurfaceTexture);
          ((CaptureRequest.Builder)localObject2).addTarget(paramSurfaceTexture);
          paramSurfaceTexture = c.nGZ;
          if (!c.btu()) {
            break label463;
          }
          if (!this.nHH) {
            break label274;
          }
          paramSurfaceTexture = c.nGZ;
          paramSurfaceTexture = this.nHA;
          s.checkNotNull(paramSurfaceTexture);
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.nIE;
          j = c.a(paramSurfaceTexture, kotlin.a.p.listOf(com.tencent.mm.media.widget.b.a.a.b.btS()));
          i = j;
          if (Build.VERSION.SDK_INT < 28) {
            break label441;
          }
          paramSurfaceTexture = this.mSurface;
          s.checkNotNull(paramSurfaceTexture);
          paramSurfaceTexture = new SessionConfiguration(j, kotlin.a.p.listOf(new OutputConfiguration(paramSurfaceTexture)), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.nHL);
          paramSurfaceHolder = this.AF;
          s.checkNotNull(paramSurfaceHolder);
          paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
          if (j == 0)
          {
            paramSurfaceHolder = this.AF;
            s.checkNotNull(paramSurfaceHolder);
            localObject1 = this.mSurface;
            paramSurfaceTexture = this.imageReader;
            if (paramSurfaceTexture != null) {
              break label455;
            }
          }
        }
        label274:
        label441:
        label447:
        label455:
        for (paramSurfaceTexture = localSurface;; paramSurfaceTexture = paramSurfaceTexture.getSurface())
        {
          paramSurfaceHolder.createCaptureSession(kotlin.a.p.listOf(new Surface[] { localObject1, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.nHL, bso().nGI);
          Log.i(this.mgf, "doStartPreview finish");
          AppMethodBeat.o(94135);
          return true;
          if (paramSurfaceHolder == null) {
            break;
          }
          this.mSurface = paramSurfaceHolder.getSurface();
          break;
          paramSurfaceTexture = c.nGZ;
          paramSurfaceTexture = this.nHA;
          s.checkNotNull(paramSurfaceTexture);
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.nIE;
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.btR();
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.nIE;
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.btQ();
          localObject2 = com.tencent.mm.media.widget.b.a.a.b.nIE;
          j = c.a(paramSurfaceTexture, kotlin.a.p.listOf(new String[] { paramSurfaceHolder, localObject1, com.tencent.mm.media.widget.b.a.a.b.btT() }));
          i = j;
          if (Build.VERSION.SDK_INT >= 28)
          {
            paramSurfaceTexture = this.mSurface;
            s.checkNotNull(paramSurfaceTexture);
            paramSurfaceHolder = new OutputConfiguration(paramSurfaceTexture);
            paramSurfaceTexture = this.imageReader;
            if (paramSurfaceTexture != null) {
              break label447;
            }
          }
          for (paramSurfaceTexture = null;; paramSurfaceTexture = paramSurfaceTexture.getSurface())
          {
            s.checkNotNull(paramSurfaceTexture);
            paramSurfaceTexture = new SessionConfiguration(j, kotlin.a.p.listOf(new OutputConfiguration[] { paramSurfaceHolder, new OutputConfiguration(paramSurfaceTexture) }), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.nHL);
            paramSurfaceHolder = this.AF;
            s.checkNotNull(paramSurfaceHolder);
            paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
            i = j;
            j = i;
            break;
          }
        }
        label463:
        paramSurfaceHolder = this.AF;
        s.checkNotNull(paramSurfaceHolder);
        localSurface = this.mSurface;
        paramSurfaceTexture = this.imageReader;
        if (paramSurfaceTexture == null) {}
        for (paramSurfaceTexture = (SurfaceTexture)localObject1;; paramSurfaceTexture = paramSurfaceTexture.getSurface())
        {
          paramSurfaceHolder.createCaptureSession(kotlin.a.p.listOf(new Surface[] { localSurface, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.nHL, bso().nGI);
          break;
        }
      }
      Log.i(this.mgf, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = f.nFE;
      f.bqx();
      paramSurfaceTexture = com.tencent.mm.media.widget.d.a.nMV;
      com.tencent.mm.media.widget.d.a.buT();
      AppMethodBeat.o(94135);
      return false;
    }
    AppMethodBeat.o(94135);
    return false;
  }
  
  protected boolean a(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94149);
    if (this.AF == null)
    {
      AppMethodBeat.o(94149);
      return false;
    }
    if (paramCameraCharacteristics == null)
    {
      paramCameraCharacteristics = null;
      if (paramCameraCharacteristics == null) {
        break label91;
      }
    }
    for (;;)
    {
      try
      {
        if (kotlin.a.k.contains(paramCameraCharacteristics, 4))
        {
          Log.i(this.mgf, "support continuous picture");
          paramCameraCharacteristics = this.nHA;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
          }
          AppMethodBeat.o(94149);
          return true;
          paramCameraCharacteristics = (int[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
          break;
        }
        label91:
        if ((paramCameraCharacteristics != null) && (kotlin.a.k.contains(paramCameraCharacteristics, 3)))
        {
          Log.i(this.mgf, "support continuous video");
          paramCameraCharacteristics = this.nHA;
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
        Log.i(this.mgf, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(94149);
        return false;
      }
      if (kotlin.a.k.contains(paramCameraCharacteristics, 1))
      {
        Log.i(this.mgf, "support auto focus");
        paramCameraCharacteristics = this.nHA;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        }
      }
      else
      {
        label217:
        Log.i(this.mgf, "not support continuous video or auto focus");
      }
    }
  }
  
  protected final boolean a(CameraCharacteristics paramCameraCharacteristics, boolean paramBoolean)
  {
    AppMethodBeat.i(94147);
    if (paramCameraCharacteristics == null)
    {
      AppMethodBeat.o(94147);
      return false;
    }
    int m;
    if (paramBoolean) {
      try
      {
        m = this.nGC;
        if (af.lXY.lTg > 0) {
          Log.i(bsm(), "set frame rate > 0, do not try set preview frame rate");
        }
        for (;;)
        {
          paramCameraCharacteristics = this.nHA;
          if (paramCameraCharacteristics == null)
          {
            paramCameraCharacteristics = null;
            label58:
            Log.i(bsm(), "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), paramCameraCharacteristics });
            AppMethodBeat.o(94147);
            return true;
            if (paramCameraCharacteristics == null)
            {
              Log.e(this.mgf, "trySetPreviewFrameRateParameters error, p is null!");
              continue;
            }
            try
            {
              paramCameraCharacteristics = (Range[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
              if (paramCameraCharacteristics != null)
              {
                n = paramCameraCharacteristics.length;
                j = 0;
                i = 0;
                k = i;
                if (j < n)
                {
                  localObject = paramCameraCharacteristics[j];
                  localComparable = ((Range)localObject).getUpper();
                  s.s(localComparable, "it.upper");
                  if (i < ((Number)localComparable).intValue())
                  {
                    localObject = ((Range)localObject).getUpper();
                    s.s(localObject, "it.upper");
                    i = ((Number)localObject).intValue();
                  }
                }
                else if (m == 0)
                {
                  i = Math.min(30, k);
                  paramCameraCharacteristics = new Range((Comparable)Integer.valueOf(i), (Comparable)Integer.valueOf(i));
                  localObject = this.nHA;
                  if (localObject == null) {
                    continue;
                  }
                  ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, paramCameraCharacteristics);
                }
              }
            }
            catch (Exception paramCameraCharacteristics)
            {
              Log.i(bsm(), "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
            }
          }
        }
      }
      catch (Exception paramCameraCharacteristics)
      {
        Log.i(bsm(), "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(94147);
        return false;
      }
    }
    for (;;)
    {
      int n;
      int j;
      Object localObject;
      Comparable localComparable;
      break;
      int i = Math.min(m, k);
      continue;
      a(paramCameraCharacteristics, this.nGC);
      break;
      paramCameraCharacteristics = (Range)paramCameraCharacteristics.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
      break label58;
      j += 1;
      continue;
      int k = 0;
    }
  }
  
  public final void aE(String paramString, int paramInt)
  {
    AppMethodBeat.i(94160);
    s.u(paramString, "tag");
    Object localObject = c.nGZ;
    localObject = this.nHA;
    s.checkNotNull(localObject);
    c.a((CaptureRequest.Builder)localObject, paramString, paramInt);
    btA();
    AppMethodBeat.o(94160);
  }
  
  public void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(94137);
    if (com.tencent.mm.compatible.util.d.rc(14))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if ((this.AF == null) || (this.nHB == null))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if (!bsD())
    {
      AppMethodBeat.o(94137);
      return;
    }
    this.nHF = new Rect(0, 0, paramInt1, paramInt2);
    Object localObject1 = this.nHD;
    if (localObject1 != null)
    {
      if (this.nHF != null) {
        i = 1;
      }
      if (i == 0) {
        break label225;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = this.nHF;
        s.checkNotNull(localObject2);
        this.nHE = new b((CameraCharacteristics)localObject1, (Rect)localObject2);
      }
      localObject1 = bso();
      Object localObject2 = com.tencent.mm.media.widget.a.a.a.nGH;
      ((com.tencent.mm.media.widget.a.a.a)localObject1).removeMessages(com.tencent.mm.media.widget.a.a.a.btj());
      bso().mkm = paramFloat1;
      bso().mkn = paramFloat2;
      bso().nGM = paramInt1;
      bso().nGN = paramInt2;
      localObject1 = bso();
      localObject2 = bso();
      com.tencent.mm.media.widget.a.a.a.a locala = com.tencent.mm.media.widget.a.a.a.nGH;
      ((com.tencent.mm.media.widget.a.a.a)localObject1).sendMessageDelayed(((com.tencent.mm.media.widget.a.a.a)localObject2).obtainMessage(com.tencent.mm.media.widget.a.a.a.btj()), 400L);
      AppMethodBeat.o(94137);
      return;
      label225:
      localObject1 = null;
    }
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    CaptureRequest.Builder localBuilder = null;
    AppMethodBeat.i(94132);
    long l = Util.currentTicks();
    Log.i(this.mgf, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (bsD())
    {
      Log.i(this.mgf, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94132);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.nHH) {
          continue;
        }
        localCameraDevice = this.AF;
        if (localCameraDevice != null) {
          continue;
        }
        this.nHA = localBuilder;
        ui(paramInt);
        bta();
        if (a(paramSurfaceTexture, paramSurfaceHolder))
        {
          a(com.tencent.mm.media.widget.a.a.a.nGg);
          this.state = 0;
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        CameraDevice localCameraDevice;
        Log.e(this.mgf, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = f.nFE;
        f.bqx();
        continue;
      }
      Log.i(this.mgf, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(94132);
      return;
      localBuilder = localCameraDevice.createCaptureRequest(3);
      continue;
      localCameraDevice = this.AF;
      if (localCameraDevice != null) {
        localBuilder = localCameraDevice.createCaptureRequest(1);
      }
    }
  }
  
  public final void b(g paramg) {}
  
  protected final boolean b(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94153);
    if (paramCameraCharacteristics == null)
    {
      AppMethodBeat.o(94153);
      return false;
    }
    try
    {
      Log.i(this.mgf, "safeSetMetering");
      Rect localRect = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
      MeteringRectangle[] arrayOfMeteringRectangle = new MeteringRectangle[1];
      if (localRect == null) {}
      int i;
      for (paramCameraCharacteristics = null;; paramCameraCharacteristics = Integer.valueOf(i))
      {
        s.checkNotNull(paramCameraCharacteristics);
        arrayOfMeteringRectangle[0] = new MeteringRectangle(paramCameraCharacteristics.intValue() / 2 - 500, localRect.bottom / 2 - 500, 1000, 1000, 0);
        paramCameraCharacteristics = this.nHA;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.nHA;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.nHA;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        }
        paramCameraCharacteristics = this.nHA;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
        }
        AppMethodBeat.o(94153);
        return true;
        i = localRect.right;
      }
      return false;
    }
    catch (Exception paramCameraCharacteristics)
    {
      Log.i(this.mgf, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
      AppMethodBeat.o(94153);
    }
  }
  
  public final int boh()
  {
    AppMethodBeat.i(94163);
    c localc = c.nGZ;
    int i = c.btp();
    AppMethodBeat.o(94163);
    return i;
  }
  
  public final boolean bsE()
  {
    AppMethodBeat.i(94158);
    this.nHH = true;
    Object localObject = c.nGZ;
    c.gC(true);
    localObject = com.tencent.mm.media.widget.d.a.nMV;
    com.tencent.mm.media.widget.d.a.bvf();
    AppMethodBeat.o(94158);
    return true;
  }
  
  public final int bsG()
  {
    AppMethodBeat.i(237915);
    Object localObject = this.nHA;
    if (localObject != null)
    {
      localObject = (Range)((CaptureRequest.Builder)localObject).get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
      if (localObject != null)
      {
        int i = ((Number)((Range)localObject).getLower()).intValue();
        localObject = ((Range)localObject).getUpper();
        s.s(localObject, "it.upper");
        i = (((Number)localObject).intValue() + i) / 2;
        AppMethodBeat.o(237915);
        return i;
      }
    }
    AppMethodBeat.o(237915);
    return 0;
  }
  
  public final boolean bsH()
  {
    AppMethodBeat.i(237953);
    Object localObject = btv();
    if (localObject != null)
    {
      localObject = (Integer)((CaptureRequest)localObject).get(CaptureRequest.CONTROL_AF_MODE);
      if (localObject != null) {
        break label44;
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label57;
      }
      AppMethodBeat.o(237953);
      return false;
      label44:
      if (((Integer)localObject).intValue() != 1) {
        break;
      }
    }
    label57:
    localObject = this.nHA;
    if (localObject != null) {
      ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
    }
    localObject = this.nHA;
    if (localObject != null) {
      ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
    }
    AppMethodBeat.o(237953);
    return true;
  }
  
  public final boolean bsI()
  {
    AppMethodBeat.i(237796);
    c localc = c.nGZ;
    if (c.btp() != 90)
    {
      localc = c.nGZ;
      if (c.btp() != 270) {}
    }
    else
    {
      AppMethodBeat.o(237796);
      return true;
    }
    AppMethodBeat.o(237796);
    return false;
  }
  
  public final Size[] bsJ()
  {
    AppMethodBeat.i(237799);
    try
    {
      Object localObject1 = this.Fk;
      if (localObject1 == null) {}
      Object localObject2;
      for (localObject1 = null;; localObject1 = ((CameraManager)localObject1).getCameraCharacteristics((String)localObject2))
      {
        this.nHD = ((CameraCharacteristics)localObject1);
        localObject1 = c.nGZ;
        localObject1 = c.bts();
        AppMethodBeat.o(237799);
        return localObject1;
        localObject2 = c.nGZ;
        localObject2 = c.btm();
        s.checkNotNull(localObject2);
      }
      return null;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(237799);
    }
  }
  
  protected void bta()
  {
    AppMethodBeat.i(94136);
    if (com.tencent.mm.plugin.mmsight.model.a.k.gcB().KXs != null) {}
    for (Object localObject2 = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.gcB().KXs.KUe);; localObject2 = Integer.valueOf(0))
    {
      Object localObject3 = this.mgf;
      Object localObject1;
      boolean bool1;
      label62:
      boolean bool2;
      label74:
      boolean bool3;
      label87:
      boolean bool4;
      if (af.lXY.lTl == 1)
      {
        localObject1 = "Range";
        if (af.lXY.lTm != 1) {
          break label689;
        }
        bool1 = true;
        if (af.lXY.lTn != 1) {
          break label694;
        }
        bool2 = true;
        if (af.lXY.lTo != 1) {
          break label699;
        }
        bool3 = true;
        if (af.lXY.lTp != 1) {
          break label705;
        }
        bool4 = true;
        label100:
        Log.i((String)localObject3, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localObject2, localObject1, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
        if ((af.lXY.lTl != 1) || ((((Integer)localObject2).intValue() != 0) && (((Integer)localObject2).intValue() != 1))) {
          break label711;
        }
        bool1 = false;
      }
      for (;;)
      {
        label182:
        bool2 = bool1;
        if (bsu() != null)
        {
          localObject1 = bsu();
          if (localObject1 != null) {
            break label743;
          }
          localObject1 = null;
          label205:
          bool2 = bool1;
          if (localObject1 != null)
          {
            localObject1 = bsu();
            if (localObject1 != null) {
              break label753;
            }
            localObject1 = null;
            label226:
            bool2 = bool1;
            if (localObject1 != null)
            {
              localObject1 = bsu();
              bool2 = bool1;
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.media.widget.camerarecordview.d.b.a)localObject1).nKR;
                bool2 = bool1;
                if (localObject1 != null)
                {
                  localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(btf()));
                  bool2 = bool1;
                  if (localObject1 != null)
                  {
                    localObject3 = ((b.a.c)localObject1).nKX;
                    if (localObject3 != null) {
                      this.nGC = ((Number)localObject3).intValue();
                    }
                    localObject1 = ((b.a.c)localObject1).nKY;
                    bool2 = bool1;
                    if (localObject1 != null) {
                      bool2 = ((Boolean)localObject1).booleanValue();
                    }
                  }
                }
              }
            }
          }
        }
        a(this.nHD, bool2);
        if ((af.lXY.lTm == 1) && (((Integer)localObject2).intValue() != 0)) {
          ((Integer)localObject2).intValue();
        }
        if ((af.lYf.lWG != -1) && (af.lYf.lWG == 1) && (com.tencent.mm.compatible.util.d.rd(14))) {
          b(this.nHD);
        }
        if ((af.lXY.lTo == 1) && ((((Integer)localObject2).intValue() == 0) || (((Integer)localObject2).intValue() == 4))) {
          a(this.nHD);
        }
        if ((af.lXY.lTp == 1) && (((Integer)localObject2).intValue() != 0)) {
          ((Integer)localObject2).intValue();
        }
        localObject1 = this.nHD;
        if (localObject1 == null)
        {
          localObject1 = null;
          label473:
          if (localObject1 != null)
          {
            localObject1 = new Rect(((Rect)localObject1).left * 1, ((Rect)localObject1).top * 1, ((Rect)localObject1).right * 1, ((Rect)localObject1).bottom * 1);
            localObject2 = this.nHA;
            if (localObject2 != null) {
              ((CaptureRequest.Builder)localObject2).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
            }
          }
          localObject1 = this.nHD;
          if (localObject1 != null) {
            break label807;
          }
          localObject1 = null;
          label550:
          if (localObject1 != null)
          {
            Log.i(this.mgf, s.X("oisMode:", Arrays.toString((int[])localObject1)));
            if (localObject1.length != 0) {
              break label823;
            }
            i = 1;
            label581:
            if (i != 0) {
              break label828;
            }
          }
        }
        label689:
        label694:
        label699:
        label828:
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (kotlin.a.k.contains((int[])localObject1, 1)))
          {
            localObject1 = com.tencent.mm.media.widget.d.a.nMV;
            com.tencent.mm.media.widget.d.a.buZ();
            localObject1 = c.nGZ;
            c.gC(false);
            localObject1 = this.nHA;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(1));
            }
          }
          localObject1 = this.nHA;
          s.checkNotNull(localObject1);
          h((CaptureRequest.Builder)localObject1);
          AppMethodBeat.o(94136);
          return;
          if (af.lXY.lTk == 1)
          {
            localObject1 = "Fix";
            break;
          }
          localObject1 = "Error";
          break;
          bool1 = false;
          break label62;
          bool2 = false;
          break label74;
          bool3 = false;
          break label87;
          label705:
          bool4 = false;
          break label100;
          label711:
          if ((af.lXY.lTk != 1) || ((((Integer)localObject2).intValue() != 0) && (((Integer)localObject2).intValue() != 5))) {
            break label833;
          }
          bool1 = true;
          break label182;
          label743:
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.d.b.a)localObject1).nKR;
          break label205;
          label753:
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.d.b.a)localObject1).nKR;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label226;
          }
          localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(btf()));
          break label226;
          localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
          break label473;
          localObject1 = (int[])((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
          break label550;
          i = 0;
          break label581;
        }
        label807:
        label823:
        label833:
        bool1 = false;
      }
    }
  }
  
  public void btb()
  {
    AppMethodBeat.i(94138);
    if (!bsD())
    {
      AppMethodBeat.o(94138);
      return;
    }
    com.tencent.mm.media.widget.a.a.a locala = bso();
    com.tencent.mm.media.widget.a.a.a.a locala1 = com.tencent.mm.media.widget.a.a.a.nGH;
    locala.removeMessages(com.tencent.mm.media.widget.a.a.a.btj());
    AppMethodBeat.o(94138);
  }
  
  public com.tencent.mm.media.widget.a.b btc()
  {
    boolean bool = true;
    AppMethodBeat.i(94143);
    Log.printInfoStack(this.mgf, "generateCameraConfig", new Object[0]);
    if (this.AF == null)
    {
      Log.i(this.mgf, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94143);
      return null;
    }
    if (!bsD())
    {
      Log.i(this.mgf, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94143);
      return null;
    }
    Object localObject = com.tencent.mm.media.widget.a.b.nGj;
    com.tencent.mm.media.widget.a.b.uk(getPreviewWidth());
    localObject = com.tencent.mm.media.widget.a.b.nGj;
    com.tencent.mm.media.widget.a.b.uj(getPreviewHeight());
    localObject = this.nHD;
    Integer localInteger;
    int i;
    if (localObject != null)
    {
      localInteger = (Integer)((CameraCharacteristics)localObject).get(CameraCharacteristics.SENSOR_ORIENTATION);
      if (localInteger == null)
      {
        localObject = (Integer)((CameraCharacteristics)localObject).get(CameraCharacteristics.SENSOR_ORIENTATION);
        if (localObject != null) {
          break label264;
        }
      }
    }
    else
    {
      i = 0;
      label137:
      localObject = com.tencent.mm.media.widget.a.b.nGj;
      com.tencent.mm.media.widget.a.b.um(bss().zWH);
      localObject = com.tencent.mm.media.widget.a.b.nGj;
      com.tencent.mm.media.widget.a.b.un(bss().zWI);
      if (i != 0)
      {
        localObject = com.tencent.mm.media.widget.a.b.nGj;
        i = com.tencent.mm.media.widget.a.b.bsM();
        localObject = com.tencent.mm.media.widget.a.b.nGj;
        localObject = com.tencent.mm.media.widget.a.b.nGj;
        com.tencent.mm.media.widget.a.b.um(com.tencent.mm.media.widget.a.b.bsN());
        localObject = com.tencent.mm.media.widget.a.b.nGj;
        com.tencent.mm.media.widget.a.b.un(i);
      }
      localObject = com.tencent.mm.media.widget.a.b.nGj;
      com.tencent.mm.media.widget.a.b.ul(getOrientation());
      localObject = com.tencent.mm.media.widget.a.b.nGj;
      if (bsp()) {
        break label277;
      }
    }
    for (;;)
    {
      com.tencent.mm.media.widget.a.b.setFrontCamera(bool);
      localObject = com.tencent.mm.media.widget.a.b.nGj;
      com.tencent.mm.media.widget.a.b.gw(bsq());
      localObject = bst();
      AppMethodBeat.o(94143);
      return localObject;
      if (localInteger.intValue() != 90) {
        break;
      }
      for (;;)
      {
        i = 1;
        break label137;
        label264:
        if (((Integer)localObject).intValue() != 270) {
          break;
        }
      }
      label277:
      bool = false;
    }
  }
  
  public final int btf()
  {
    AppMethodBeat.i(94162);
    c localc = c.nGZ;
    if (c.btn())
    {
      AppMethodBeat.o(94162);
      return 0;
    }
    AppMethodBeat.o(94162);
    return 1;
  }
  
  public final String btg()
  {
    AppMethodBeat.i(237850);
    Object localObject = btv();
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label59;
      }
      label21:
      if (localObject != null) {
        break label83;
      }
      label25:
      if (localObject != null) {
        break label107;
      }
    }
    label59:
    label83:
    label107:
    while (((Integer)localObject).intValue() != 3)
    {
      localObject = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
      localObject = b.b.but();
      AppMethodBeat.o(237850);
      return localObject;
      localObject = (Integer)((CaptureRequest)localObject).get(CaptureRequest.CONTROL_AF_MODE);
      break;
      if (((Integer)localObject).intValue() != 1) {
        break label21;
      }
      localObject = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
      localObject = b.b.but();
      AppMethodBeat.o(237850);
      return localObject;
      if (((Integer)localObject).intValue() != 4) {
        break label25;
      }
      localObject = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
      localObject = b.b.bus();
      AppMethodBeat.o(237850);
      return localObject;
    }
    localObject = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
    localObject = b.b.bur();
    AppMethodBeat.o(237850);
    return localObject;
  }
  
  public final boolean bth()
  {
    AppMethodBeat.i(237839);
    try
    {
      CaptureRequest.Builder localBuilder = this.nHA;
      if (localBuilder != null) {
        localBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      localBuilder = this.nHA;
      if (localBuilder != null) {
        localBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
      }
      AppMethodBeat.o(237839);
      return true;
    }
    catch (Exception localException)
    {
      Log.i(this.mgf, "triggerAutoFocus failed");
      AppMethodBeat.o(237839);
    }
    return false;
  }
  
  protected final CaptureRequest btv()
  {
    AppMethodBeat.i(237643);
    CaptureRequest localCaptureRequest = this.nHC;
    if (localCaptureRequest != null)
    {
      AppMethodBeat.o(237643);
      return localCaptureRequest;
    }
    s.bIx("previewRequest");
    AppMethodBeat.o(237643);
    return null;
  }
  
  protected final CameraCharacteristics btw()
  {
    return this.nHD;
  }
  
  protected final boolean btx()
  {
    return this.nHH;
  }
  
  protected final void c(CaptureRequest paramCaptureRequest)
  {
    AppMethodBeat.i(237646);
    s.u(paramCaptureRequest, "<set-?>");
    this.nHC = paramCaptureRequest;
    AppMethodBeat.o(237646);
  }
  
  public final int ev(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(237937);
    paramInt1 = i;
    switch (paramInt2)
    {
    default: 
      paramInt1 = i;
    }
    while (!boi())
    {
      localc = c.nGZ;
      paramInt2 = c.btp();
      AppMethodBeat.o(237937);
      return (360 - (paramInt1 + paramInt2) % 360) % 360;
      paramInt1 = 90;
      continue;
      paramInt1 = 180;
      continue;
      paramInt1 = 270;
    }
    c localc = c.nGZ;
    paramInt2 = c.btp();
    AppMethodBeat.o(237937);
    return (paramInt2 - paramInt1 + 360) % 360;
  }
  
  public final boolean ew(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237803);
    try
    {
      SurfaceTexture localSurfaceTexture = getSurfaceTexture();
      s.checkNotNull(localSurfaceTexture);
      localSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
      AppMethodBeat.o(237803);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(237803);
    }
    return false;
  }
  
  /* Error */
  public final boolean f(Rect paramRect1, Rect paramRect2)
  {
    // Byte code:
    //   0: ldc_w 1640
    //   3: invokestatic 331	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 1641
    //   10: invokestatic 358	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_2
    //   14: ldc_w 1642
    //   17: invokestatic 358	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 365	com/tencent/mm/media/widget/b/d:mgf	Ljava/lang/String;
    //   24: ldc_w 1644
    //   27: iconst_2
    //   28: anewarray 657	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload_2
    //   38: aastore
    //   39: invokestatic 1168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: invokevirtual 1134	com/tencent/mm/media/widget/b/d:bsD	()Z
    //   46: ifeq +328 -> 374
    //   49: aload_0
    //   50: getfield 479	com/tencent/mm/media/widget/b/d:nHD	Landroid/hardware/camera2/CameraCharacteristics;
    //   53: astore 6
    //   55: aload 6
    //   57: ifnonnull +325 -> 382
    //   60: aconst_null
    //   61: astore 6
    //   63: aload 6
    //   65: ifnull +32 -> 97
    //   68: aload 6
    //   70: arraylength
    //   71: istore 4
    //   73: iconst_0
    //   74: istore_3
    //   75: iload_3
    //   76: iload 4
    //   78: if_icmpge +320 -> 398
    //   81: aload 6
    //   83: iload_3
    //   84: iaload
    //   85: istore 5
    //   87: iload_3
    //   88: iconst_1
    //   89: iadd
    //   90: istore_3
    //   91: iload 5
    //   93: iconst_1
    //   94: if_icmpne -19 -> 75
    //   97: iconst_1
    //   98: istore_3
    //   99: aload_0
    //   100: getfield 437	com/tencent/mm/media/widget/b/d:nHA	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   103: astore 6
    //   105: aload 6
    //   107: ifnull +15 -> 122
    //   110: aload 6
    //   112: getstatic 606	android/hardware/camera2/CaptureRequest:CONTROL_AF_MODE	Landroid/hardware/camera2/CaptureRequest$Key;
    //   115: iload_3
    //   116: invokestatic 612	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokevirtual 616	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   122: aload_0
    //   123: getfield 437	com/tencent/mm/media/widget/b/d:nHA	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   126: astore 6
    //   128: aload 6
    //   130: ifnull +15 -> 145
    //   133: aload 6
    //   135: getstatic 708	android/hardware/camera2/CaptureRequest:CONTROL_MODE	Landroid/hardware/camera2/CaptureRequest$Key;
    //   138: iconst_1
    //   139: invokestatic 612	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: invokevirtual 616	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   145: aload_0
    //   146: iconst_1
    //   147: invokespecial 1646	com/tencent/mm/media/widget/b/d:gE	(Z)Z
    //   150: ifeq +40 -> 190
    //   153: aload_0
    //   154: getfield 437	com/tencent/mm/media/widget/b/d:nHA	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   157: astore 6
    //   159: aload 6
    //   161: ifnull +29 -> 190
    //   164: aload 6
    //   166: getstatic 1401	android/hardware/camera2/CaptureRequest:CONTROL_AF_REGIONS	Landroid/hardware/camera2/CaptureRequest$Key;
    //   169: iconst_1
    //   170: anewarray 1392	android/hardware/camera2/params/MeteringRectangle
    //   173: dup
    //   174: iconst_0
    //   175: new 1392	android/hardware/camera2/params/MeteringRectangle
    //   178: dup
    //   179: aload_1
    //   180: sipush 1000
    //   183: invokespecial 1649	android/hardware/camera2/params/MeteringRectangle:<init>	(Landroid/graphics/Rect;I)V
    //   186: aastore
    //   187: invokevirtual 616	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   190: aload_0
    //   191: iconst_0
    //   192: invokespecial 1646	com/tencent/mm/media/widget/b/d:gE	(Z)Z
    //   195: ifeq +37 -> 232
    //   198: aload_0
    //   199: getfield 437	com/tencent/mm/media/widget/b/d:nHA	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull +28 -> 232
    //   207: aload_1
    //   208: getstatic 1398	android/hardware/camera2/CaptureRequest:CONTROL_AE_REGIONS	Landroid/hardware/camera2/CaptureRequest$Key;
    //   211: iconst_1
    //   212: anewarray 1392	android/hardware/camera2/params/MeteringRectangle
    //   215: dup
    //   216: iconst_0
    //   217: new 1392	android/hardware/camera2/params/MeteringRectangle
    //   220: dup
    //   221: aload_2
    //   222: sipush 1000
    //   225: invokespecial 1649	android/hardware/camera2/params/MeteringRectangle:<init>	(Landroid/graphics/Rect;I)V
    //   228: aastore
    //   229: invokevirtual 616	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   232: aload_0
    //   233: getfield 437	com/tencent/mm/media/widget/b/d:nHA	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   236: astore_1
    //   237: aload_1
    //   238: ifnull +14 -> 252
    //   241: aload_1
    //   242: getstatic 694	android/hardware/camera2/CaptureRequest:CONTROL_AF_TRIGGER	Landroid/hardware/camera2/CaptureRequest$Key;
    //   245: iconst_0
    //   246: invokestatic 612	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: invokevirtual 616	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   252: aload_0
    //   253: getfield 600	com/tencent/mm/media/widget/b/d:nHG	Z
    //   256: ifne +38 -> 294
    //   259: aload_0
    //   260: getfield 456	com/tencent/mm/media/widget/b/d:nHB	Landroid/hardware/camera2/CameraCaptureSession;
    //   263: astore_1
    //   264: aload_1
    //   265: ifnull +29 -> 294
    //   268: aload_0
    //   269: getfield 437	com/tencent/mm/media/widget/b/d:nHA	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   272: astore_2
    //   273: aload_2
    //   274: invokestatic 441	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   277: aload_1
    //   278: aload_2
    //   279: invokevirtual 446	android/hardware/camera2/CaptureRequest$Builder:build	()Landroid/hardware/camera2/CaptureRequest;
    //   282: aconst_null
    //   283: aload_0
    //   284: invokevirtual 463	com/tencent/mm/media/widget/b/d:bso	()Lcom/tencent/mm/media/widget/a/a/a;
    //   287: getfield 469	com/tencent/mm/media/widget/a/a/a:nGI	Landroid/os/Handler;
    //   290: invokevirtual 475	android/hardware/camera2/CameraCaptureSession:setRepeatingRequest	(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/os/Handler;)I
    //   293: pop
    //   294: aload_0
    //   295: getfield 437	com/tencent/mm/media/widget/b/d:nHA	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   298: astore_1
    //   299: aload_1
    //   300: ifnull +14 -> 314
    //   303: aload_1
    //   304: getstatic 694	android/hardware/camera2/CaptureRequest:CONTROL_AF_TRIGGER	Landroid/hardware/camera2/CaptureRequest$Key;
    //   307: iconst_1
    //   308: invokestatic 612	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   311: invokevirtual 616	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   314: aload_0
    //   315: getfield 600	com/tencent/mm/media/widget/b/d:nHG	Z
    //   318: ifne +118 -> 436
    //   321: aload_0
    //   322: getfield 369	com/tencent/mm/media/widget/b/d:nHy	Ljava/lang/String;
    //   325: ldc_w 1651
    //   328: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload_0
    //   332: getfield 456	com/tencent/mm/media/widget/b/d:nHB	Landroid/hardware/camera2/CameraCaptureSession;
    //   335: astore_1
    //   336: aload_1
    //   337: ifnull +32 -> 369
    //   340: aload_0
    //   341: getfield 437	com/tencent/mm/media/widget/b/d:nHA	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   344: astore_2
    //   345: aload_2
    //   346: invokestatic 441	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   349: aload_1
    //   350: aload_2
    //   351: invokevirtual 446	android/hardware/camera2/CaptureRequest$Builder:build	()Landroid/hardware/camera2/CaptureRequest;
    //   354: aload_0
    //   355: getfield 427	com/tencent/mm/media/widget/b/d:Cd	Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;
    //   358: aload_0
    //   359: invokevirtual 463	com/tencent/mm/media/widget/b/d:bso	()Lcom/tencent/mm/media/widget/a/a/a;
    //   362: getfield 469	com/tencent/mm/media/widget/a/a/a:nGI	Landroid/os/Handler;
    //   365: invokevirtual 475	android/hardware/camera2/CameraCaptureSession:setRepeatingRequest	(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/os/Handler;)I
    //   368: pop
    //   369: aload_0
    //   370: iconst_5
    //   371: putfield 653	com/tencent/mm/media/widget/b/d:state	I
    //   374: ldc_w 1640
    //   377: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   380: iconst_1
    //   381: ireturn
    //   382: aload 6
    //   384: getstatic 736	android/hardware/camera2/CameraCharacteristics:CONTROL_AF_AVAILABLE_MODES	Landroid/hardware/camera2/CameraCharacteristics$Key;
    //   387: invokevirtual 489	android/hardware/camera2/CameraCharacteristics:get	(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;
    //   390: checkcast 738	[I
    //   393: astore 6
    //   395: goto -332 -> 63
    //   398: aload 6
    //   400: iconst_0
    //   401: iaload
    //   402: istore_3
    //   403: goto -304 -> 99
    //   406: astore_1
    //   407: ldc_w 1653
    //   410: aload_1
    //   411: invokevirtual 1654	android/hardware/camera2/CameraAccessException:getMessage	()Ljava/lang/String;
    //   414: invokestatic 1518	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   417: pop
    //   418: goto -124 -> 294
    //   421: astore_1
    //   422: ldc_w 1653
    //   425: aload_1
    //   426: invokevirtual 1655	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   429: invokestatic 1518	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   432: pop
    //   433: goto -139 -> 294
    //   436: aload_0
    //   437: getfield 369	com/tencent/mm/media/widget/b/d:nHy	Ljava/lang/String;
    //   440: ldc_w 1657
    //   443: invokestatic 548	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload_0
    //   447: getfield 365	com/tencent/mm/media/widget/b/d:mgf	Ljava/lang/String;
    //   450: ldc_w 1659
    //   453: invokestatic 678	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: ldc_w 1640
    //   459: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   462: iconst_0
    //   463: ireturn
    //   464: astore_1
    //   465: aload_0
    //   466: getfield 365	com/tencent/mm/media/widget/b/d:mgf	Ljava/lang/String;
    //   469: ldc_w 1661
    //   472: invokestatic 678	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: ldc_w 1640
    //   478: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   481: iconst_0
    //   482: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	d
    //   0	483	1	paramRect1	Rect
    //   0	483	2	paramRect2	Rect
    //   74	329	3	i	int
    //   71	8	4	j	int
    //   85	10	5	k	int
    //   53	346	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   252	264	406	android/hardware/camera2/CameraAccessException
    //   268	294	406	android/hardware/camera2/CameraAccessException
    //   252	264	421	java/lang/IllegalStateException
    //   268	294	421	java/lang/IllegalStateException
    //   314	336	464	android/hardware/camera2/CameraAccessException
    //   340	369	464	android/hardware/camera2/CameraAccessException
    //   436	462	464	android/hardware/camera2/CameraAccessException
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(94165);
    Object localObject = c.nGZ;
    localObject = this.nHA;
    s.checkNotNull(localObject);
    int i = c.a((CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94165);
    return i;
  }
  
  protected final int getOrientation()
  {
    AppMethodBeat.i(237780);
    if (bsD())
    {
      c localc = c.nGZ;
      int i = c.btp();
      AppMethodBeat.o(237780);
      return i;
    }
    AppMethodBeat.o(237780);
    return -1;
  }
  
  protected int getPreviewHeight()
  {
    AppMethodBeat.i(94144);
    if (this.AF == null)
    {
      AppMethodBeat.o(94144);
      return 0;
    }
    try
    {
      if ((bsq()) && (bsw() != null))
      {
        Point localPoint = bsw();
        s.checkNotNull(localPoint);
        i = localPoint.y;
        AppMethodBeat.o(94144);
        return i;
      }
      int i = bss().zWI;
      AppMethodBeat.o(94144);
      return i;
    }
    catch (Exception localException)
    {
      Log.e(this.mgf, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94144);
    }
    return 0;
  }
  
  protected int getPreviewWidth()
  {
    AppMethodBeat.i(94145);
    if (this.AF == null)
    {
      AppMethodBeat.o(94145);
      return 0;
    }
    if (this.Fk != null) {
      try
      {
        if ((bsq()) && (bsw() != null))
        {
          Point localPoint = bsw();
          s.checkNotNull(localPoint);
          i = localPoint.x;
          AppMethodBeat.o(94145);
          return i;
        }
        int i = bss().zWH;
        AppMethodBeat.o(94145);
        return i;
      }
      catch (Exception localException)
      {
        Log.e(this.mgf, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94145);
    return 0;
  }
  
  public final float[] getSupportZoomRatios()
  {
    AppMethodBeat.i(94141);
    Object localObject;
    int i;
    int k;
    if ((this.nHK == null) && (this.nHD != null))
    {
      localObject = this.nHD;
      s.checkNotNull(localObject);
      Float localFloat = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      localObject = localFloat;
      if (localFloat == null) {
        localObject = Float.valueOf(0.0F);
      }
      float f = (int)(((Number)localObject).floatValue() * 10.0F) * 1.0F / 10.0F;
      this.nHK = new float[(int)(f * 10.0F)];
      i = 0;
      k = (int)(f * 10.0F);
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localObject = this.nHK;
      s.checkNotNull(localObject);
      localObject[i] = (i * 1.0F / 10.0F + 1.0F);
      if (j >= k)
      {
        localObject = this.nHK;
        AppMethodBeat.o(94141);
        return localObject;
      }
      i = j;
    }
  }
  
  public Point gx(boolean paramBoolean)
  {
    AppMethodBeat.i(94146);
    if (!paramBoolean)
    {
      localPoint = new Point(bss().zWH, bss().zWI);
      AppMethodBeat.o(94146);
      return localPoint;
    }
    if (bsw() != null)
    {
      localPoint = bsw();
      s.checkNotNull(localPoint);
      AppMethodBeat.o(94146);
      return localPoint;
    }
    Point localPoint = new Point(bss().zWH, bss().zWI);
    AppMethodBeat.o(94146);
    return localPoint;
  }
  
  public final void gy(boolean paramBoolean)
  {
    AppMethodBeat.i(94164);
    Object localObject = c.nGZ;
    localObject = this.nHA;
    s.checkNotNull(localObject);
    c.a(paramBoolean, (CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94164);
  }
  
  public void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94140);
    if ((this.AF != null) && (bsD())) {}
    for (;;)
    {
      float f2;
      try
      {
        Log.d(this.mgf, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (bsy())
        {
          Log.d(this.mgf, "triggerSmallZoom, zooming, ignore");
          return;
        }
        gu(true);
        localObject1 = this.nHA;
        if (localObject1 == null)
        {
          localObject3 = null;
          localObject1 = this.nHD;
          if (localObject1 == null)
          {
            localObject1 = null;
            s.checkNotNull(localObject1);
            f1 = ((Rect)localObject1).width();
            s.checkNotNull(localObject3);
            f2 = f1 / ((Rect)localObject3).width();
            localObject3 = this.nHD;
            s.checkNotNull(localObject3);
            Float localFloat = (Float)((CameraCharacteristics)localObject3).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            localObject3 = localFloat;
            if (localFloat == null) {
              localObject3 = Float.valueOf(0.0F);
            }
            f1 = ((Number)localObject3).floatValue();
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
          localObject3 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
          continue;
        }
        localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        continue;
        f2 = this.nGp + f2;
        if (f2 < f1) {
          break label546;
        }
        Log.d(this.mgf, "triggerSmallZoom, nextZoom: %s", new Object[] { Float.valueOf(f1) });
        f2 = ((Rect)localObject1).width() / f1;
        f1 = ((Rect)localObject1).height() / f1;
        float f3 = (((Rect)localObject1).width() - f2) / 2.0F;
        float f4 = (((Rect)localObject1).height() - f1) / 2.0F;
        localObject1 = new Rect((int)f3, (int)f4, (int)(f2 + f3), (int)(f1 + f4));
        localObject3 = this.nHA;
        if (localObject3 != null) {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
        }
        paramBoolean = this.nHG;
        if (paramBoolean) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        Log.e(this.mgf, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        gu(false);
        AppMethodBeat.o(94140);
      }
      try
      {
        localObject1 = this.nHB;
        if (localObject1 != null)
        {
          localObject3 = this.nHA;
          s.checkNotNull(localObject3);
          ((CameraCaptureSession)localObject1).setRepeatingRequest(((CaptureRequest.Builder)localObject3).build(), this.Cd, bso().nGI);
        }
      }
      catch (CameraAccessException localCameraAccessException)
      {
        continue;
      }
      gu(false);
      AppMethodBeat.o(94140);
      return;
      if (f2 == 1.0F)
      {
        paramInt = 1;
        if (paramInt != 0)
        {
          gu(false);
          AppMethodBeat.o(94140);
        }
      }
      else
      {
        paramInt = 0;
        continue;
      }
      float f1 = this.nGp;
      f2 -= f1;
      f1 = f2;
      if (f2 <= 1.0F)
      {
        f1 = 1.0F;
        continue;
        AppMethodBeat.o(94140);
        return;
        label546:
        f1 = f2;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(94155);
    super.release();
    if (this.AF != null)
    {
      long l = Util.currentTicks();
      Log.i(this.mgf, "release camera beg, %s", new Object[] { Looper.myLooper() });
      bso().removeCallbacksAndMessages(null);
      bty();
      localObject = this.mSurface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      Log.i(this.mgf, "release camera end, use %dms, %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
    }
    d(null);
    gv(false);
    Object localObject = com.tencent.mm.media.widget.d.a.nMV;
    com.tencent.mm.media.widget.d.a.buU();
    AppMethodBeat.o(94155);
  }
  
  public final void setFlashMode(int paramInt)
  {
    int[] arrayOfInt = null;
    AppMethodBeat.i(94166);
    CaptureRequest.Builder localBuilder = this.nHA;
    Object localObject;
    if (localBuilder != null)
    {
      localObject = c.nGZ;
      s.u(localBuilder, "builder");
      switch (paramInt)
      {
      }
    }
    label150:
    for (;;)
    {
      AppMethodBeat.o(94166);
      return;
      c.a(false, localBuilder);
      AppMethodBeat.o(94166);
      return;
      c.a(true, localBuilder);
      AppMethodBeat.o(94166);
      return;
      localObject = c.Fk;
      if (localObject == null) {}
      for (;;)
      {
        if (!com.tencent.mm.compatible.loader.a.contains(arrayOfInt, 2)) {
          break label150;
        }
        localBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
        break;
        localObject = ((CameraManager)localObject).getCameraCharacteristics(String.valueOf(c.nHg));
        if (localObject != null) {
          arrayOfInt = (int[])((CameraCharacteristics)localObject).get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        }
      }
    }
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(94142);
    if (bsy())
    {
      Log.d(this.mgf, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94142);
      return;
    }
    if ((this.nHD != null) && (this.nHA != null)) {
      try
      {
        localObject1 = this.nHD;
        s.checkNotNull(localObject1);
        localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        s.checkNotNull(localObject1);
        int i = ((Rect)localObject1).width() - kotlin.h.a.eH(((Rect)localObject1).width() / paramFloat);
        int j = ((Rect)localObject1).height() - kotlin.h.a.eH(((Rect)localObject1).height() / paramFloat);
        this.nHJ = new Rect(i / 2, j / 2, ((Rect)localObject1).width() - i / 2, ((Rect)localObject1).height() - j / 2);
        localObject1 = this.nHA;
        s.checkNotNull(localObject1);
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.SCALER_CROP_REGION, this.nHJ);
        boolean bool = this.nHG;
        if (bool) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        label222:
        Log.e(this.mgf, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        gu(false);
        AppMethodBeat.o(94142);
      }
    }
    try
    {
      localObject1 = this.nHB;
      if (localObject1 != null)
      {
        CaptureRequest.Builder localBuilder = this.nHA;
        s.checkNotNull(localBuilder);
        ((CameraCaptureSession)localObject1).setRepeatingRequest(localBuilder.build(), this.Cd, bso().nGI);
      }
    }
    catch (CameraAccessException localCameraAccessException)
    {
      break label222;
    }
    gu(false);
    AppMethodBeat.o(94142);
    return;
    AppMethodBeat.o(94142);
  }
  
  public final boolean uh(int paramInt)
  {
    AppMethodBeat.i(237924);
    try
    {
      CameraCaptureSession localCameraCaptureSession = this.nHB;
      if (localCameraCaptureSession != null) {
        localCameraCaptureSession.getDevice();
      }
      AppMethodBeat.o(237924);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(this.mgf, "open scene " + paramInt + " open failed, error:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(237924);
    }
    return false;
  }
  
  public final boolean ui(int paramInt)
  {
    AppMethodBeat.i(94154);
    try
    {
      super.ui(paramInt);
      boolean bool = bsI();
      Point localPoint = bsK();
      Object localObject1 = c.nGZ;
      Object localObject2 = h.b(c.btt(), localPoint, paramInt, bool);
      localObject1 = localObject2;
      if (((h.c)localObject2).KVz == null)
      {
        localObject1 = new Point(Math.min(bsK().x, bsK().y), Math.max(bsK().x, bsK().y));
        localObject2 = c.nGZ;
        localObject1 = h.a(c.btt(), (Point)localObject1, bsn(), bool);
      }
      if (((h.c)localObject1).KVz == null)
      {
        localObject2 = com.tencent.mm.media.widget.d.a.nMV;
        com.tencent.mm.media.widget.d.a.bva();
        Log.i(this.mgf, "checkMore start %s", new Object[] { ((h.c)localObject1).toString() });
        ((h.c)localObject1).KVz = ((h.c)localObject1).KVC;
        ((h.c)localObject1).KVA = ((h.c)localObject1).KVD;
        ((h.c)localObject1).KVB = ((h.c)localObject1).KVE;
      }
      localObject2 = c.nGZ;
      c.e(localPoint);
      localObject1 = new Size(((h.c)localObject1).KVz.x, ((h.c)localObject1).KVz.y);
      paramInt = ((Size)localObject1).getWidth();
      int i = ((Size)localObject1).getHeight();
      localObject1 = c.nGZ;
      localObject1 = ImageReader.newInstance(paramInt, i, c.bto(), 1);
      ((ImageReader)localObject1).setOnImageAvailableListener(bso().nGQ, bso().nGI);
      localObject2 = ah.aiuX;
      this.imageReader = ((ImageReader)localObject1);
      AppMethodBeat.o(94154);
      return true;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      Log.printErrStackTrace(this.mgf, (Throwable)localCameraAccessException, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", new Object[] { Looper.myLooper(), localCameraAccessException.getMessage() });
      AppMethodBeat.o(94154);
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.mgf, (Throwable)localException, "selectNoCropPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
      AppMethodBeat.o(94154);
    }
    return false;
  }
  
  public final void up(int paramInt)
  {
    AppMethodBeat.i(94139);
    if (bsx() > 0)
    {
      AppMethodBeat.o(94139);
      return;
    }
    Object localObject = aw.bf(MMApplicationContext.getContext());
    int i = ((Point)localObject).y;
    Log.i(this.mgf, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94139);
      return;
    }
    try
    {
      localObject = this.nHD;
      s.checkNotNull(localObject);
      Float localFloat = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      localObject = localFloat;
      if (localFloat == null) {
        localObject = Float.valueOf(0.0F);
      }
      float f = ((Number)localObject).floatValue();
      double d = f / (paramInt / 3.0D / 10.0D);
      if (d > 0.0D) {
        ug((int)d + 1);
      }
      Log.i(this.mgf, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(bsx()), Float.valueOf(f) });
      AppMethodBeat.o(94139);
      return;
    }
    catch (Exception localException)
    {
      Log.e(this.mgf, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94139);
    }
  }
  
  public final void ur(int paramInt)
  {
    this.nGC = paramInt;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/widget/camera2/CommonCamera2$captureStillPicture$2$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "onCaptureCompleted", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "result", "Landroid/hardware/camera2/TotalCaptureResult;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends CameraCaptureSession.CaptureCallback
  {
    b(d paramd) {}
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(237509);
      s.u(paramCameraCaptureSession, "session");
      s.u(paramCaptureRequest, "request");
      s.u(paramTotalCaptureResult, "result");
      paramCameraCaptureSession = c.nGZ;
      paramCameraCaptureSession = this.nHP.nHA;
      s.checkNotNull(paramCameraCaptureSession);
      c.g(paramCameraCaptureSession);
      AppMethodBeat.o(237509);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Lcom/tencent/mm/sensitive/IPluginSensitive$MMCameraStateCallBack;", "onDisconnected", "", "camera", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "onPermissionCheck", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.sensitive.d.b
  {
    c(d paramd) {}
    
    public final void btB()
    {
      AppMethodBeat.i(237516);
      this.nHP.nHz.release();
      this.nHP.AF = null;
      AppMethodBeat.o(237516);
    }
    
    public final void onDisconnected(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94120);
      s.u(paramCameraDevice, "camera");
      this.nHP.nHz.release();
      paramCameraDevice.close();
      this.nHP.AF = null;
      AppMethodBeat.o(94120);
    }
    
    public final void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      AppMethodBeat.i(94121);
      s.u(paramCameraDevice, "camera");
      onDisconnected(paramCameraDevice);
      AppMethodBeat.o(94121);
    }
    
    public final void onOpened(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94119);
      s.u(paramCameraDevice, "camera");
      this.nHP.nHz.release();
      this.nHP.AF = paramCameraDevice;
      AppMethodBeat.o(94119);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "capturePicture", "", "result", "Landroid/hardware/camera2/CaptureResult;", "checkFocusEnd", "", "onCaptureCompleted", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "Landroid/hardware/camera2/TotalCaptureResult;", "onCaptureProgressed", "partialResult", "process", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends CameraCaptureSession.CaptureCallback
  {
    d(d paramd) {}
    
    private final void b(CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94122);
      switch (this.nHP.state)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94122);
        return;
        Object localObject = c.nGZ;
        c.a(paramCaptureResult);
        AppMethodBeat.o(94122);
        return;
        localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if ((localObject == null) || (2 == ((Integer)localObject).intValue()) || (6 == ((Integer)localObject).intValue()))
        {
          d.c(this.nHP);
          AppMethodBeat.o(94122);
          return;
        }
        if ((4 == ((Integer)localObject).intValue()) || (5 == ((Integer)localObject).intValue()))
        {
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 2))
          {
            d.c(this.nHP);
            AppMethodBeat.o(94122);
            return;
          }
          d.d(this.nHP);
          AppMethodBeat.o(94122);
          return;
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 5) || (paramCaptureResult.intValue() == 4))
          {
            this.nHP.state = 3;
            AppMethodBeat.o(94122);
            return;
            paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
            if ((paramCaptureResult == null) || (paramCaptureResult.intValue() != 5))
            {
              d.c(this.nHP);
              AppMethodBeat.o(94122);
              return;
              localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
              if (localObject == null) {}
              while (localObject == null)
              {
                AppMethodBeat.o(94122);
                return;
                if (((Integer)localObject).intValue() == 4)
                {
                  label296:
                  if ((!this.nHP.bsD()) || (this.nHP.nHG)) {
                    break label516;
                  }
                  Log.i(this.nHP.nHy, s.X("STATE_TOUCH_FOCUSING and state is  ", paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE)));
                  paramCaptureResult = this.nHP.nHA;
                  if (paramCaptureResult != null) {
                    paramCaptureResult.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
                  }
                  paramCaptureResult = this.nHP.nHA;
                  if (paramCaptureResult != null) {
                    paramCaptureResult.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
                  }
                  localObject = this.nHP;
                  paramCaptureResult = this.nHP.nHA;
                  if (paramCaptureResult != null) {
                    break label492;
                  }
                }
              }
              label492:
              for (paramCaptureResult = null;; paramCaptureResult = paramCaptureResult.build())
              {
                s.checkNotNull(paramCaptureResult);
                s.s(paramCaptureResult, "mPreviewBuilder?.build()!!");
                ((d)localObject).c(paramCaptureResult);
                try
                {
                  paramCaptureResult = this.nHP.nHB;
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(this.nHP.btv(), (CameraCaptureSession.CaptureCallback)this, d.e(this.nHP).nGI);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    Log.e(d.a(this.nHP), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                d.e(this.nHP).nGO = true;
                this.nHP.state = 0;
                AppMethodBeat.o(94122);
                return;
                if (((Integer)localObject).intValue() != 5) {
                  break;
                }
                break label296;
              }
              label516:
              Log.e(d.a(this.nHP), "current is not allowed to do anything casue capturing");
            }
          }
        }
      }
    }
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(94124);
      s.u(paramCameraCaptureSession, "session");
      s.u(paramCaptureRequest, "request");
      s.u(paramTotalCaptureResult, "result");
      b((CaptureResult)paramTotalCaptureResult);
      AppMethodBeat.o(94124);
    }
    
    public final void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94123);
      s.u(paramCameraCaptureSession, "session");
      s.u(paramCaptureRequest, "request");
      s.u(paramCaptureResult, "partialResult");
      b(paramCaptureResult);
      AppMethodBeat.o(94123);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onClosed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigureFailed", "onConfigured", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends CameraCaptureSession.StateCallback
  {
    e(d paramd) {}
    
    public final void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94127);
      s.u(paramCameraCaptureSession, "session");
      super.onClosed(paramCameraCaptureSession);
      Log.i(d.a(this.nHP), "session on close");
      this.nHP.nHG = true;
      AppMethodBeat.o(94127);
    }
    
    public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94126);
      s.u(paramCameraCaptureSession, "session");
      Log.i(d.a(this.nHP), "configure failed ");
      paramCameraCaptureSession = f.nFE;
      f.bqx();
      paramCameraCaptureSession = com.tencent.mm.media.widget.d.a.nMV;
      com.tencent.mm.media.widget.d.a.buT();
      AppMethodBeat.o(94126);
    }
    
    public final void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94125);
      s.u(paramCameraCaptureSession, "session");
      Log.i(d.a(this.nHP), "session on onConfigured");
      if (this.nHP.AF == null)
      {
        AppMethodBeat.o(94125);
        return;
      }
      this.nHP.nHG = false;
      this.nHP.nHB = paramCameraCaptureSession;
      paramCameraCaptureSession = f.nFE;
      f.bqw();
      paramCameraCaptureSession = com.tencent.mm.media.widget.d.a.nMV;
      com.tencent.mm.media.widget.d.a.buS();
      d.b(this.nHP);
      AppMethodBeat.o(94125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d
 * JD-Core Version:    0.7.0.1
 */