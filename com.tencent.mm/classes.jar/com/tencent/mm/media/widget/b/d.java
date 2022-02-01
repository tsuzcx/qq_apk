package com.tencent.mm.media.widget.b;

import android.annotation.TargetApi;
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
import com.tencent.mm.media.k.f;
import com.tencent.mm.media.widget.b.a.c.a;
import com.tencent.mm.media.widget.b.a.c.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "FOCUS_TAG", "", "getFOCUS_TAG", "()Ljava/lang/String;", "FOCUS_TAG$1", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "TAG$1", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "isUseRecordStream", "", "()Z", "setUseRecordStream", "(Z)V", "mCameraDevice", "Landroid/hardware/camera2/CameraDevice;", "getMCameraDevice", "()Landroid/hardware/camera2/CameraDevice;", "setMCameraDevice", "(Landroid/hardware/camera2/CameraDevice;)V", "mCameraDeviceCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1;", "mCameraFps", "", "getMCameraFps", "()I", "setMCameraFps", "(I)V", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "mCameraOpenCloseLock", "Ljava/util/concurrent/Semaphore;", "getMCameraOpenCloseLock", "()Ljava/util/concurrent/Semaphore;", "mCaptureCallback", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "getMCaptureCallback", "()Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "mCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "getMCaptureSession", "()Landroid/hardware/camera2/CameraCaptureSession;", "setMCaptureSession", "(Landroid/hardware/camera2/CameraCaptureSession;)V", "mCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getMCharacteristics", "()Landroid/hardware/camera2/CameraCharacteristics;", "setMCharacteristics", "(Landroid/hardware/camera2/CameraCharacteristics;)V", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsNoAFRun", "getMIsNoAFRun", "setMIsNoAFRun", "mIsSessionClose", "getMIsSessionClose", "setMIsSessionClose", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mPreviewBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "getMPreviewBuilder", "()Landroid/hardware/camera2/CaptureRequest$Builder;", "setMPreviewBuilder", "(Landroid/hardware/camera2/CaptureRequest$Builder;)V", "mPreviewRect", "Landroid/graphics/Rect;", "getMPreviewRect", "()Landroid/graphics/Rect;", "setMPreviewRect", "(Landroid/graphics/Rect;)V", "mStateCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1;", "mSurface", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mTransformer", "Lcom/tencent/mm/media/widget/camera2/CameraFocusCoordinateTrans;", "getMTransformer", "()Lcom/tencent/mm/media/widget/camera2/CameraFocusCoordinateTrans;", "setMTransformer", "(Lcom/tencent/mm/media/widget/camera2/CameraFocusCoordinateTrans;)V", "mZoomTimesToRatio", "", "getMZoomTimesToRatio", "()[F", "setMZoomTimesToRatio", "([F)V", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "previewRequest", "Landroid/hardware/camera2/CaptureRequest;", "getPreviewRequest", "()Landroid/hardware/camera2/CaptureRequest;", "setPreviewRequest", "(Landroid/hardware/camera2/CaptureRequest;)V", "state", "getState", "setState", "zoomOutRect", "getZoomOutRect", "setZoomOutRect", "abandonFocus", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateLocDiff", "loc1", "loc2", "calculateTapArea", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "captureStillPicture", "checkCameraOpenSucc", "scene", "clamp", "min", "max", "closeCamera", "configVendorTagValue", "tag", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCameraSensorRotate", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getPreviewWidth", "getSupportPreviewSize", "", "Landroid/util/Size;", "()[Landroid/util/Size;", "getSupportZoomRatios", "getValidAFMode", "targetMode", "initCamera", "useBack", "initRawRatios", "isMeteringSupport", "lock3AParams", "builder", "lockFocus", "openCamera", "nowCameraId", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "resumePreview", "runPrecaptureSequence", "safeResetZoom", "safeSetFocusMode", "characteristics", "safeSetMetering", "safeSetOIS", "safeSetPreviewFrameRate", "useFixMode", "safeSetStabilization", "safeSetVendorEffect", "selectNoCropPreviewSize", "resolutionLimit", "selectRatioAndResolutionLimitPreviewSize", "ratio", "longSideLimit", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "setPreviewSize", "width", "height", "setSafeConfig", "startPreview", "useCpuCrop", "(Landroid/graphics/SurfaceTexture;ZLjava/lang/Float;I)V", "surface", "startPreviewWithGPU", "startPreviewWithGPURatio", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "trySetPreviewFrameRateParameters", "Companion", "plugin-mediaeditor_release"})
public class d
  extends com.tencent.mm.media.widget.a.a
{
  private static final SparseIntArray lcZ;
  public static final d.b lda;
  private final String jGx;
  private ImageReader jUA;
  private float lbi;
  private kotlin.g.a.b<? super Boolean, x> lbx;
  private int lby;
  private boolean lbz;
  final String lcI;
  final Semaphore lcJ;
  CameraDevice lcK;
  CaptureRequest.Builder lcL;
  CameraCaptureSession lcM;
  protected CaptureRequest lcN;
  private CameraCharacteristics lcO;
  private b lcP;
  private Rect lcQ;
  boolean lcR;
  private boolean lcS;
  private boolean lcT;
  private Rect lcU;
  private float[] lcV;
  private final f lcW;
  private final d lcX;
  private final CameraCaptureSession.CaptureCallback lcY;
  private CameraManager lcf;
  private Surface mSurface;
  int state;
  
  static
  {
    AppMethodBeat.i(94168);
    lda = new d.b((byte)0);
    SparseIntArray localSparseIntArray = new SparseIntArray();
    lcZ = localSparseIntArray;
    localSparseIntArray.append(0, 90);
    lcZ.append(1, 0);
    lcZ.append(2, 270);
    lcZ.append(3, 180);
    AppMethodBeat.o(94168);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94167);
    this.jGx = "MicroMsg.CommonCamera2";
    this.lcI = "MicroMsg.CommonCamera2.FoucsTag";
    this.lbi = 0.1F;
    this.lcJ = new Semaphore(1);
    if (com.tencent.mm.media.widget.d.c.baA())
    {
      paramContext = new com.tencent.mm.media.widget.b.a.c(paramContext);
      kotlin.g.a.q localq = (kotlin.g.a.q)1.ldb;
      kotlin.g.b.p.k(localq, "mSupportWCKeyAvailable");
      new Thread((Runnable)new c.a(paramContext, (kotlin.g.a.a)new c.b(paramContext, localq))).start();
      paramContext = c.lcH;
      c.aYt();
    }
    this.lcW = new f(this);
    this.lcX = new d(this);
    this.lcY = ((CameraCaptureSession.CaptureCallback)new e(this));
    this.lbz = true;
    AppMethodBeat.o(94167);
  }
  
  private final void aYA()
  {
    AppMethodBeat.i(94129);
    try
    {
      if (this.lcL != null)
      {
        localObject1 = c.lcH;
        localObject1 = this.lcL;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        c.g((CaptureRequest.Builder)localObject1);
      }
      this.lcJ.acquire();
      Object localObject1 = this.lcM;
      if (localObject1 != null) {
        ((CameraCaptureSession)localObject1).close();
      }
      this.lcM = null;
      localObject1 = this.lcK;
      if (localObject1 != null) {
        ((CameraDevice)localObject1).close();
      }
      this.lcK = null;
      localObject1 = this.jUA;
      if (localObject1 != null) {
        ((ImageReader)localObject1).setOnImageAvailableListener(null, this.laK.lbL);
      }
      localObject1 = this.jUA;
      if (localObject1 != null) {
        ((ImageReader)localObject1).close();
      }
      this.jUA = null;
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
      this.lcJ.release();
      AppMethodBeat.o(94129);
    }
  }
  
  private final void aYB()
  {
    Object localObject2 = null;
    AppMethodBeat.i(94134);
    try
    {
      if (this.state == 4)
      {
        Log.printInfoStack(this.jGx, "capture still picture more than twice", new Object[0]);
        AppMethodBeat.o(94134);
        return;
      }
      this.state = 4;
      Log.i(this.jGx, "captureStillPicture");
      if (this.lcK == null)
      {
        AppMethodBeat.o(94134);
        return;
      }
    }
    catch (Exception localException)
    {
      localObject2 = c.lcH;
      if (!c.aYp())
      {
        localObject2 = com.tencent.mm.media.widget.d.a.lim;
        com.tencent.mm.media.widget.d.a.bab();
      }
      Log.e(this.jGx, localException.toString());
      AppMethodBeat.o(94134);
      return;
    }
    Object localObject1 = this.lcL;
    Object localObject3;
    label190:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
      if ((this.lcK == null) || (this.lcR))
      {
        AppMethodBeat.o(94134);
        return;
      }
      localObject3 = this.lcK;
      if (localObject3 != null)
      {
        localObject3 = ((CameraDevice)localObject3).createCaptureRequest(2);
        if (localObject3 != null)
        {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
          localObject1 = this.jUA;
          if (localObject1 == null) {
            break label553;
          }
          localObject1 = ((ImageReader)localObject1).getSurface();
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          ((CaptureRequest.Builder)localObject3).addTarget((Surface)localObject1);
          localObject1 = this.jUA;
          if (localObject1 != null) {
            ((ImageReader)localObject1).setOnImageAvailableListener(this.laK.lbT, this.laK.lbL);
          }
          kotlin.g.b.p.j(localObject3, "this");
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
          localObject1 = this.lcO;
          if (localObject1 == null) {
            break label558;
          }
          localObject1 = (Float)((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
          label270:
          if (localObject1 == null) {
            break label548;
          }
          if (!kotlin.g.b.p.e((Float)localObject1)) {
            break label563;
          }
          break label548;
          label284:
          this.lcT = bool;
          if (!this.lcT)
          {
            localObject1 = this.lcO;
            if (localObject1 == null) {
              break label568;
            }
          }
        }
      }
    }
    label526:
    label536:
    label548:
    label553:
    label558:
    label563:
    label568:
    for (localObject1 = (int[])((CameraCharacteristics)localObject1).get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);; localObject1 = null)
    {
      if (com.tencent.mm.compatible.loader.a.contains((int[])localObject1, 4))
      {
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
        localObject1 = this.lcO;
        if (localObject1 == null) {
          break label526;
        }
        localObject1 = (int[])((CameraCharacteristics)localObject1).get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        label368:
        if (com.tencent.mm.compatible.loader.a.contains((int[])localObject1, 1)) {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(1));
        }
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        h((CaptureRequest.Builder)localObject3);
      }
      for (localObject1 = localObject3;; localObject1 = null)
      {
        this.lcL = ((CaptureRequest.Builder)localObject1);
        localObject3 = this.lcM;
        if (localObject3 == null) {
          break label536;
        }
        ((CameraCaptureSession)localObject3).stopRepeating();
        Log.i(this.lcI, "this time happened a cancel auto foucs while capture");
        localObject1 = this.lcL;
        if (localObject1 != null) {
          ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
        }
        CaptureRequest.Builder localBuilder = this.lcL;
        localObject1 = localObject2;
        if (localBuilder != null) {
          localObject1 = localBuilder.build();
        }
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        ((CameraCaptureSession)localObject3).capture((CaptureRequest)localObject1, (CameraCaptureSession.CaptureCallback)new c(this), null);
        AppMethodBeat.o(94134);
        return;
        ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        break;
        localObject1 = null;
        break label368;
      }
      AppMethodBeat.o(94134);
      return;
      localObject1 = null;
      break;
      bool = true;
      break label284;
      localObject1 = null;
      break label190;
      localObject1 = null;
      break label270;
      bool = false;
      break label284;
    }
  }
  
  private final void aYC()
  {
    AppMethodBeat.i(94161);
    if (this.lcL == null)
    {
      AppMethodBeat.o(94161);
      return;
    }
    if ((this.lcK != null) && (!this.lcR))
    {
      Object localObject = this.lcL;
      if (localObject != null) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      }
      localObject = this.lcL;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      h((CaptureRequest.Builder)localObject);
      CameraCaptureSession localCameraCaptureSession = this.lcM;
      if (localCameraCaptureSession != null)
      {
        localObject = this.lcL;
        if (localObject != null) {}
        for (localObject = ((CaptureRequest.Builder)localObject).build();; localObject = null)
        {
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          localCameraCaptureSession.setRepeatingRequest((CaptureRequest)localObject, this.lcY, this.laK.lbL);
          AppMethodBeat.o(94161);
          return;
        }
      }
    }
    AppMethodBeat.o(94161);
  }
  
  private final boolean b(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(259547);
    for (;;)
    {
      int j;
      try
      {
        localObject1 = this.lcO;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        localObject1 = (StreamConfigurationMap)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null) {
          continue;
        }
        localObject3 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
        kotlin.g.b.p.j(localObject3, "map.getOutputSizes(SurfaceTexture::class.java)");
        if (localObject3.length > 1) {
          e.a((Object[])localObject3, (Comparator)new d.a());
        }
        localObject3 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
        kotlin.g.b.p.j(localObject3, "map.getOutputSizes(SurfaceTexture::class.java)");
        int k = localObject3.length;
        i = 0;
        if (i >= k) {
          break label385;
        }
        localObject1 = localObject3[i];
        kotlin.g.b.p.j(localObject1, "it");
        if ((Math.abs(((Size)localObject1).getWidth() * 1.0F / ((Size)localObject1).getHeight() - paramFloat) > 0.1D) || (((Size)localObject1).getWidth() > paramInt)) {
          break label372;
        }
        j = 1;
      }
      catch (CameraAccessException localCameraAccessException)
      {
        Object localObject1;
        Object localObject3;
        AppMethodBeat.o(259547);
        return false;
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(259547);
        return false;
      }
      Log.i(this.jGx, "selectRatioAndResolutionLimitPreviewSize final select target:" + ((Size)localObject1).getWidth() + 'x' + ((Size)localObject1).getHeight());
      localObject3 = getSurfaceTexture();
      if (localObject3 != null) {
        ((SurfaceTexture)localObject3).setDefaultBufferSize(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight());
      }
      this.laR.wAw = ((Size)localObject1).getWidth();
      this.laR.wAx = ((Size)localObject1).getHeight();
      localObject1 = new Size(this.laR.wAw, this.laR.wAx);
      paramInt = ((Size)localObject1).getWidth();
      int i = ((Size)localObject1).getHeight();
      localObject1 = c.lcH;
      localObject1 = ImageReader.newInstance(paramInt, i, c.aYq(), 1);
      ((ImageReader)localObject1).setOnImageAvailableListener(this.laK.lbT, this.laK.lbL);
      this.jUA = ((ImageReader)localObject1);
      AppMethodBeat.o(259547);
      return true;
      for (;;)
      {
        if (j == 0) {
          break label378;
        }
        break;
        label372:
        j = 0;
      }
      label378:
      i += 1;
      continue;
      label385:
      Object localObject2 = null;
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
  
  private final boolean fQ(boolean paramBoolean)
  {
    AppMethodBeat.i(259618);
    if (paramBoolean)
    {
      localObject = this.lcO;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = ((CameraCharacteristics)localObject).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
    }
    for (Object localObject = (Integer)localObject;; localObject = (Integer)localObject)
    {
      kotlin.g.b.p.j(localObject, "if (focusArea) {\n       …X_REGIONS_AE)!!\n        }");
      if (((Integer)localObject).intValue() <= 0) {
        break;
      }
      AppMethodBeat.o(259618);
      return true;
      localObject = this.lcO;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = ((CameraCharacteristics)localObject).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
    }
    AppMethodBeat.o(259618);
    return false;
  }
  
  private static void h(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94152);
    c localc = c.lcH;
    c.b(paramBuilder);
    localc = c.lcH;
    c.d(paramBuilder);
    localc = c.lcH;
    c.e(paramBuilder);
    localc = c.lcH;
    c.c(paramBuilder);
    localc = c.lcH;
    c.f(paramBuilder);
    AppMethodBeat.o(94152);
  }
  
  public final void D(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94159);
    kotlin.g.b.p.k(paramString, "tag");
    com.tencent.mm.media.widget.b.a.a.b.a locala = com.tencent.mm.media.widget.b.a.a.b.lef;
    if (kotlin.g.b.p.h(paramString, com.tencent.mm.media.widget.b.a.a.b.aYN()))
    {
      paramString = c.lcH;
      c.fP(paramBoolean);
    }
    for (;;)
    {
      aYC();
      AppMethodBeat.o(94159);
      return;
      locala = com.tencent.mm.media.widget.b.a.a.b.lef;
      if (kotlin.g.b.p.h(paramString, com.tencent.mm.media.widget.b.a.a.b.aYS()))
      {
        paramString = c.lcH;
        c.fL(paramBoolean);
      }
      else
      {
        locala = com.tencent.mm.media.widget.b.a.a.b.lef;
        if (kotlin.g.b.p.h(paramString, com.tencent.mm.media.widget.b.a.a.b.aYR()))
        {
          paramString = c.lcH;
          c.fM(paramBoolean);
        }
        else
        {
          locala = com.tencent.mm.media.widget.b.a.a.b.lef;
          if (kotlin.g.b.p.h(paramString, com.tencent.mm.media.widget.b.a.a.b.aYU()))
          {
            paramString = c.lcH;
            c.fN(paramBoolean);
          }
          else
          {
            locala = com.tencent.mm.media.widget.b.a.a.b.lef;
            if (kotlin.g.b.p.h(paramString, com.tencent.mm.media.widget.b.a.a.b.aYT()))
            {
              paramString = c.lcH;
              c.fO(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  public final Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259599);
    paramInt1 = (int)(4.0F * paramFloat3);
    paramInt2 = (int)paramFloat1;
    Object localObject1 = this.lcQ;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    int i = ((Rect)localObject1).width() / paramInt1 / 2;
    localObject1 = this.lcQ;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    int j = ((Rect)localObject1).left;
    localObject1 = this.lcQ;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    int k = ((Rect)localObject1).right;
    localObject1 = this.lcQ;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    paramInt2 = clamp(paramInt2 - i, j, k - ((Rect)localObject1).width() / paramInt1);
    i = (int)paramFloat2;
    localObject1 = this.lcQ;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    j = ((Rect)localObject1).width() / paramInt1 / 2;
    localObject1 = this.lcQ;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    k = ((Rect)localObject1).top;
    localObject1 = this.lcQ;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    int m = ((Rect)localObject1).bottom;
    localObject1 = this.lcQ;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    i = clamp(i - j, k, m - ((Rect)localObject1).width() / paramInt1);
    paramFloat1 = paramInt2;
    paramFloat2 = i;
    localObject1 = this.lcQ;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    paramFloat3 = paramInt2 + ((Rect)localObject1).width() / paramInt1;
    localObject1 = this.lcQ;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    localObject1 = new RectF(paramFloat1, paramFloat2, paramFloat3, ((Rect)localObject1).width() / paramInt1 + i);
    Object localObject2 = this.lcP;
    if (localObject2 == null) {
      kotlin.g.b.p.iCn();
    }
    kotlin.g.b.p.k(localObject1, "source");
    RectF localRectF = new RectF();
    localObject2 = ((b)localObject2).lcd;
    if (localObject2 != null) {
      ((Matrix)localObject2).mapRect(localRectF, (RectF)localObject1);
    }
    kotlin.g.b.p.k(localRectF, "rectF");
    localObject1 = new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
    AppMethodBeat.o(259599);
    return localObject1;
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94130);
    this.lcJ.acquire();
    this.lcJ.release();
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    b(paramSurfaceTexture, null, paramInt);
    AppMethodBeat.o(94130);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, Float paramFloat, int paramInt)
  {
    AppMethodBeat.i(259545);
    this.lcJ.acquire();
    this.lcJ.release();
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    a(paramFloat);
    if (paramFloat != null)
    {
      float f = paramFloat.floatValue();
      long l = Util.currentTicks();
      Log.i(this.jGx, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + null);
      if (aXQ())
      {
        Log.i(this.jGx, "startPreviewWithGPU, camera previewing");
        AppMethodBeat.o(259545);
        return;
      }
      paramFloat = this.lcf;
      Object localObject = c.lcH;
      localObject = c.aYo();
      if ((paramFloat == null) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        Log.e(this.jGx, "startPreviewWithGPURatio error");
        AppMethodBeat.o(259545);
        return;
      }
      if (localObject == null) {}
      try
      {
        kotlin.g.b.p.iCn();
        this.lcO = paramFloat.getCameraCharacteristics((String)localObject);
        if (b(f, paramInt)) {
          break label282;
        }
        b(paramSurfaceTexture, null, paramInt);
        AppMethodBeat.o(259545);
        return;
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.e(this.jGx, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = f.laB;
        f.aVQ();
      }
      Log.i(this.jGx, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(259545);
      return;
      label282:
      if (this.lcS)
      {
        paramFloat = this.lcK;
        if (paramFloat == null) {
          break label375;
        }
        paramFloat = paramFloat.createCaptureRequest(3);
      }
    }
    for (;;)
    {
      this.lcL = paramFloat;
      aYd();
      if (!a(paramSurfaceTexture, null)) {
        break;
      }
      a(com.tencent.mm.media.widget.a.a.a.lbb);
      this.state = 0;
      break;
      paramFloat = this.lcK;
      if (paramFloat != null)
      {
        paramFloat = paramFloat.createCaptureRequest(1);
      }
      else
      {
        paramFloat = null;
        continue;
        a(paramSurfaceTexture, paramBoolean, paramInt);
        AppMethodBeat.o(259545);
        return;
        label375:
        paramFloat = null;
      }
    }
  }
  
  protected void a(CameraCharacteristics paramCameraCharacteristics, int paramInt)
  {
    AppMethodBeat.i(259586);
    if (af.juH.jpZ > 0)
    {
      Log.i(aXE(), "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(259586);
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
      AppMethodBeat.o(259586);
      return;
      paramCameraCharacteristics = null;
      break;
    }
    label79:
    int k = -2147483648;
    int j = -2147483648;
    i = 0;
    int i1 = paramCameraCharacteristics.length;
    int m = 0;
    Integer localInteger2;
    int n;
    if (m < i1)
    {
      localInteger2 = paramCameraCharacteristics[m];
      if (localInteger2 == null) {}
      Integer localInteger1;
      do
      {
        m += 1;
        break;
        localInteger1 = (Integer)localInteger2.getLower();
        localInteger2 = (Integer)localInteger2.getUpper();
        Log.i(this.jGx, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(m), localInteger1, localInteger2 });
        if (kotlin.g.b.p.compare(localInteger1.intValue(), 0) < 0) {
          break label217;
        }
        n = localInteger2.intValue();
        kotlin.g.b.p.j(localInteger1, "min");
      } while (kotlin.g.b.p.compare(n, localInteger1.intValue()) < 0);
      label217:
      if (paramInt == 0)
      {
        n = 30;
        label228:
        if ((kotlin.g.b.p.compare(localInteger2.intValue(), j) < 0) || (i != 0) || (kotlin.g.b.p.compare(localInteger2.intValue(), n) > 0)) {
          break label510;
        }
        k = localInteger1.intValue();
        kotlin.g.b.p.j(localInteger2, "max");
        j = localInteger2.intValue();
      }
    }
    label507:
    label510:
    for (;;)
    {
      if (paramInt != 0)
      {
        if (localInteger2 == null)
        {
          break;
          n = paramInt;
          break label228;
        }
        if (localInteger2.intValue() != paramInt) {
          break label507;
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
        Log.i(aXE(), "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(30) });
        if ((k == 2147483647) || (j == 2147483647))
        {
          AppMethodBeat.o(259586);
          return;
        }
        try
        {
          paramCameraCharacteristics = this.lcL;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range((Comparable)Integer.valueOf(k), (Comparable)Integer.valueOf(j)));
          }
          Log.i(aXE(), "set fps range %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
          AppMethodBeat.o(259586);
          return;
        }
        catch (Exception paramCameraCharacteristics)
        {
          Log.i(aXE(), "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
          AppMethodBeat.o(259586);
          return;
        }
      }
      break;
    }
  }
  
  protected final void a(CaptureRequest paramCaptureRequest)
  {
    AppMethodBeat.i(259533);
    kotlin.g.b.p.k(paramCaptureRequest, "<set-?>");
    this.lcN = paramCaptureRequest;
    AppMethodBeat.o(259533);
  }
  
  protected final void a(ImageReader paramImageReader)
  {
    this.jUA = paramImageReader;
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94131);
    this.lcJ.acquire();
    this.lcJ.release();
    super.a(paramSurfaceHolder, paramBoolean, paramInt);
    b(null, paramSurfaceHolder, paramInt);
    AppMethodBeat.o(94131);
  }
  
  public final void a(g paramg) {}
  
  protected final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94135);
    Object localObject2 = this.lcL;
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
          if (paramSurfaceTexture == null) {
            kotlin.g.b.p.iCn();
          }
          ((CaptureRequest.Builder)localObject2).addTarget(paramSurfaceTexture);
          paramSurfaceTexture = c.lcH;
          if (!c.aYw()) {
            break label486;
          }
          if (!this.lcS) {
            break label288;
          }
          paramSurfaceTexture = c.lcH;
          paramSurfaceTexture = this.lcL;
          if (paramSurfaceTexture == null) {
            kotlin.g.b.p.iCn();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.lef;
          j = c.a(paramSurfaceTexture, j.listOf(com.tencent.mm.media.widget.b.a.a.b.aYT()));
          i = j;
          if (Build.VERSION.SDK_INT < 28) {
            break label470;
          }
          paramSurfaceTexture = this.mSurface;
          if (paramSurfaceTexture == null) {
            kotlin.g.b.p.iCn();
          }
          paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration(paramSurfaceTexture)), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.lcW);
          paramSurfaceHolder = this.lcK;
          if (paramSurfaceHolder == null) {
            kotlin.g.b.p.iCn();
          }
          paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
          if (j == 0)
          {
            paramSurfaceHolder = this.lcK;
            if (paramSurfaceHolder == null) {
              kotlin.g.b.p.iCn();
            }
            localObject1 = this.mSurface;
            paramSurfaceTexture = this.jUA;
            if (paramSurfaceTexture == null) {
              break label481;
            }
            paramSurfaceTexture = paramSurfaceTexture.getSurface();
            label219:
            paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localObject1, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.lcW, this.laK.lbL);
          }
        }
        for (;;)
        {
          Log.i(this.jGx, "doStartPreview finish");
          AppMethodBeat.o(94135);
          return true;
          if (paramSurfaceHolder == null) {
            break;
          }
          this.mSurface = paramSurfaceHolder.getSurface();
          break;
          label288:
          paramSurfaceTexture = c.lcH;
          paramSurfaceTexture = this.lcL;
          if (paramSurfaceTexture == null) {
            kotlin.g.b.p.iCn();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.lef;
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.aYS();
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.lef;
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.aYR();
          localObject2 = com.tencent.mm.media.widget.b.a.a.b.lef;
          j = c.a(paramSurfaceTexture, j.listOf(new String[] { paramSurfaceHolder, localObject1, com.tencent.mm.media.widget.b.a.a.b.aYU() }));
          i = j;
          if (Build.VERSION.SDK_INT >= 28)
          {
            paramSurfaceTexture = this.mSurface;
            if (paramSurfaceTexture == null) {
              kotlin.g.b.p.iCn();
            }
            paramSurfaceHolder = new OutputConfiguration(paramSurfaceTexture);
            paramSurfaceTexture = this.jUA;
            if (paramSurfaceTexture == null) {
              break label476;
            }
          }
          label470:
          label476:
          for (paramSurfaceTexture = paramSurfaceTexture.getSurface();; paramSurfaceTexture = null)
          {
            if (paramSurfaceTexture == null) {
              kotlin.g.b.p.iCn();
            }
            paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration[] { paramSurfaceHolder, new OutputConfiguration(paramSurfaceTexture) }), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.lcW);
            paramSurfaceHolder = this.lcK;
            if (paramSurfaceHolder == null) {
              kotlin.g.b.p.iCn();
            }
            paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
            i = j;
            j = i;
            break;
          }
          label481:
          paramSurfaceTexture = null;
          break label219;
          label486:
          paramSurfaceHolder = this.lcK;
          if (paramSurfaceHolder == null) {
            kotlin.g.b.p.iCn();
          }
          localObject2 = this.mSurface;
          ImageReader localImageReader = this.jUA;
          paramSurfaceTexture = (SurfaceTexture)localObject1;
          if (localImageReader != null) {
            paramSurfaceTexture = localImageReader.getSurface();
          }
          paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localObject2, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.lcW, this.laK.lbL);
        }
      }
      Log.i(this.jGx, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = f.laB;
      f.aVQ();
      paramSurfaceTexture = com.tencent.mm.media.widget.d.a.lim;
      com.tencent.mm.media.widget.d.a.aZW();
      AppMethodBeat.o(94135);
      return false;
    }
    AppMethodBeat.o(94135);
    return false;
  }
  
  protected boolean a(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94149);
    if (this.lcK == null)
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
        if ((paramCameraCharacteristics != null) && (e.contains(paramCameraCharacteristics, 4)))
        {
          Log.i(this.jGx, "support continuous picture");
          paramCameraCharacteristics = this.lcL;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
          }
          AppMethodBeat.o(94149);
          return true;
          paramCameraCharacteristics = null;
          continue;
        }
        if ((paramCameraCharacteristics != null) && (e.contains(paramCameraCharacteristics, 3)))
        {
          Log.i(this.jGx, "support continuous video");
          paramCameraCharacteristics = this.lcL;
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
        Log.i(this.jGx, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(94149);
        return false;
      }
      if (e.contains(paramCameraCharacteristics, 1))
      {
        Log.i(this.jGx, "support auto focus");
        paramCameraCharacteristics = this.lcL;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        }
      }
      else
      {
        label217:
        Log.i(this.jGx, "not support continuous video or auto focus");
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
        m = this.lby;
        if (af.juH.jpZ > 0) {
          Log.i(aXE(), "set frame rate > 0, do not try set preview frame rate");
        }
        for (;;)
        {
          paramCameraCharacteristics = this.lcL;
          if (paramCameraCharacteristics != null)
          {
            paramCameraCharacteristics = (Range)paramCameraCharacteristics.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
            label67:
            Log.i(aXE(), "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), paramCameraCharacteristics });
            AppMethodBeat.o(94147);
            return true;
            if (paramCameraCharacteristics == null)
            {
              Log.e(this.jGx, "trySetPreviewFrameRateParameters error, p is null!");
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
                  kotlin.g.b.p.j(localObject, "it");
                  localComparable = ((Range)localObject).getUpper();
                  kotlin.g.b.p.j(localComparable, "it.upper");
                  if (kotlin.g.b.p.compare(i, ((Number)localComparable).intValue()) < 0)
                  {
                    localObject = ((Range)localObject).getUpper();
                    kotlin.g.b.p.j(localObject, "it.upper");
                    i = ((Number)localObject).intValue();
                  }
                }
                else if (m == 0)
                {
                  i = Math.min(30, k);
                  paramCameraCharacteristics = new Range((Comparable)Integer.valueOf(i), (Comparable)Integer.valueOf(i));
                  localObject = this.lcL;
                  if (localObject == null) {
                    continue;
                  }
                  ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, paramCameraCharacteristics);
                }
              }
            }
            catch (Exception paramCameraCharacteristics)
            {
              Log.i(aXE(), "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
            }
          }
        }
      }
      catch (Exception paramCameraCharacteristics)
      {
        Log.i(aXE(), "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
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
      a(paramCameraCharacteristics, this.lby);
      break;
      paramCameraCharacteristics = null;
      break label67;
      j += 1;
      continue;
      int k = 0;
    }
  }
  
  public final boolean aXR()
  {
    AppMethodBeat.i(94158);
    this.lcS = true;
    Object localObject = c.lcH;
    c.fO(true);
    localObject = com.tencent.mm.media.widget.d.a.lim;
    com.tencent.mm.media.widget.d.a.bai();
    AppMethodBeat.o(94158);
    return true;
  }
  
  public final int aXT()
  {
    AppMethodBeat.i(259609);
    Object localObject = this.lcL;
    if (localObject != null)
    {
      localObject = (Range)((CaptureRequest.Builder)localObject).get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
      if (localObject != null)
      {
        kotlin.g.b.p.j(localObject, "it");
        int i = ((Number)((Range)localObject).getLower()).intValue();
        localObject = ((Range)localObject).getUpper();
        kotlin.g.b.p.j(localObject, "it.upper");
        i = (((Number)localObject).intValue() + i) / 2;
        AppMethodBeat.o(259609);
        return i;
      }
    }
    AppMethodBeat.o(259609);
    return 0;
  }
  
  public final boolean aXU()
  {
    AppMethodBeat.i(259614);
    Object localObject = this.lcN;
    if (localObject == null) {
      kotlin.g.b.p.bGy("previewRequest");
    }
    if (localObject != null)
    {
      localObject = (Integer)((CaptureRequest)localObject).get(CaptureRequest.CONTROL_AF_MODE);
      if (localObject != null) {
        break label53;
      }
    }
    label53:
    while (((Integer)localObject).intValue() != 1)
    {
      AppMethodBeat.o(259614);
      return false;
      localObject = null;
      break;
    }
    localObject = this.lcL;
    if (localObject != null) {
      ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
    }
    localObject = this.lcL;
    if (localObject != null) {
      ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
    }
    AppMethodBeat.o(259614);
    return true;
  }
  
  public final boolean aXV()
  {
    AppMethodBeat.i(259592);
    c localc = c.lcH;
    if (c.aYr() != 90)
    {
      localc = c.lcH;
      if (c.aYr() != 270) {}
    }
    else
    {
      AppMethodBeat.o(259592);
      return true;
    }
    AppMethodBeat.o(259592);
    return false;
  }
  
  public final Size[] aXW()
  {
    AppMethodBeat.i(259593);
    try
    {
      Object localObject1 = this.lcf;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = c.lcH;
        localObject2 = c.aYo();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
      }
      for (localObject1 = ((CameraManager)localObject1).getCameraCharacteristics((String)localObject2);; localObject1 = null)
      {
        this.lcO = ((CameraCharacteristics)localObject1);
        localObject1 = c.lcH;
        localObject1 = c.aYu();
        AppMethodBeat.o(259593);
        return localObject1;
      }
      return null;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(259593);
    }
  }
  
  protected void aYd()
  {
    AppMethodBeat.i(94136);
    Object localObject1 = k.eTI();
    kotlin.g.b.p.j(localObject1, "MMSightController.getInstance()");
    if (((k)localObject1).eTJ() != null)
    {
      localObject1 = k.eTI();
      kotlin.g.b.p.j(localObject1, "MMSightController.getInstance()");
    }
    for (Object localObject2 = Integer.valueOf(((k)localObject1).eTJ().EYs);; localObject2 = Integer.valueOf(0))
    {
      Object localObject3 = this.jGx;
      boolean bool1;
      label86:
      boolean bool2;
      label98:
      boolean bool3;
      label111:
      boolean bool4;
      if (af.juH.jqe == 1)
      {
        localObject1 = "Range";
        if (af.juH.jqf != 1) {
          break label776;
        }
        bool1 = true;
        if (af.juH.jqg != 1) {
          break label781;
        }
        bool2 = true;
        if (af.juH.jqh != 1) {
          break label786;
        }
        bool3 = true;
        if (af.juH.jqi != 1) {
          break label792;
        }
        bool4 = true;
        label124:
        Log.i((String)localObject3, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localObject2, localObject1, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
        if ((af.juH.jqe != 1) || ((((Integer)localObject2).intValue() != 0) && (((Integer)localObject2).intValue() != 1))) {
          break label798;
        }
        bool1 = false;
      }
      for (;;)
      {
        label206:
        bool2 = bool1;
        if (this.laS != null)
        {
          localObject1 = this.laS;
          if (localObject1 == null) {
            break label830;
          }
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.d.b.a)localObject1).lgh;
          label233:
          bool2 = bool1;
          if (localObject1 != null)
          {
            localObject1 = this.laS;
            if (localObject1 == null) {
              break label836;
            }
            localObject1 = ((com.tencent.mm.media.widget.camerarecordview.d.b.a)localObject1).lgh;
            if (localObject1 == null) {
              break label836;
            }
            localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(aYi()));
            label280:
            bool2 = bool1;
            if (localObject1 != null)
            {
              localObject1 = this.laS;
              bool2 = bool1;
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.media.widget.camerarecordview.d.b.a)localObject1).lgh;
                bool2 = bool1;
                if (localObject1 != null)
                {
                  localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(aYi()));
                  bool2 = bool1;
                  if (localObject1 != null)
                  {
                    localObject3 = ((b.a.c)localObject1).lgn;
                    if (localObject3 != null) {
                      this.lby = ((Number)localObject3).intValue();
                    }
                    localObject1 = ((b.a.c)localObject1).lgo;
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
        a(this.lcO, bool2);
        if ((af.juH.jqf == 1) && (((Integer)localObject2).intValue() != 0)) {
          ((Integer)localObject2).intValue();
        }
        if ((af.juO.jtp != -1) && (af.juO.jtp == 1) && (com.tencent.mm.compatible.util.d.qX(14))) {
          b(this.lcO);
        }
        if ((af.juH.jqh == 1) && ((((Integer)localObject2).intValue() == 0) || (((Integer)localObject2).intValue() == 4))) {
          a(this.lcO);
        }
        if ((af.juH.jqi == 1) && (((Integer)localObject2).intValue() != 0)) {
          ((Integer)localObject2).intValue();
        }
        localObject1 = this.lcO;
        label665:
        if (localObject1 != null)
        {
          localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
          label537:
          if (localObject1 != null)
          {
            localObject1 = new Rect(((Rect)localObject1).left * 1, ((Rect)localObject1).top * 1, ((Rect)localObject1).right * 1, ((Rect)localObject1).bottom * 1);
            localObject2 = this.lcL;
            if (localObject2 != null) {
              ((CaptureRequest.Builder)localObject2).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
            }
          }
          localObject1 = this.lcO;
          if (localObject1 == null) {
            break label848;
          }
          localObject1 = (int[])((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
          label624:
          if (localObject1 != null)
          {
            Log.i(this.jGx, "oisMode:" + Arrays.toString((int[])localObject1));
            if (localObject1.length != 0) {
              break label854;
            }
            i = 1;
            if (i != 0) {
              break label859;
            }
          }
        }
        label776:
        label781:
        label786:
        label792:
        label798:
        label830:
        label836:
        label848:
        label854:
        label859:
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (e.contains((int[])localObject1, 1)))
          {
            localObject1 = com.tencent.mm.media.widget.d.a.lim;
            com.tencent.mm.media.widget.d.a.bac();
            localObject1 = c.lcH;
            c.fO(false);
            localObject1 = this.lcL;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(1));
            }
          }
          localObject1 = this.lcL;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          h((CaptureRequest.Builder)localObject1);
          AppMethodBeat.o(94136);
          return;
          if (af.juH.jqd == 1)
          {
            localObject1 = "Fix";
            break;
          }
          localObject1 = "Error";
          break;
          bool1 = false;
          break label86;
          bool2 = false;
          break label98;
          bool3 = false;
          break label111;
          bool4 = false;
          break label124;
          if ((af.juH.jqd != 1) || ((((Integer)localObject2).intValue() != 0) && (((Integer)localObject2).intValue() != 5))) {
            break label864;
          }
          bool1 = true;
          break label206;
          localObject1 = null;
          break label233;
          localObject1 = null;
          break label280;
          localObject1 = null;
          break label537;
          localObject1 = null;
          break label624;
          i = 0;
          break label665;
        }
        label864:
        bool1 = false;
      }
    }
  }
  
  public void aYe()
  {
    AppMethodBeat.i(94138);
    if (!aXQ())
    {
      AppMethodBeat.o(94138);
      return;
    }
    com.tencent.mm.media.widget.a.a.a locala = this.laK;
    com.tencent.mm.media.widget.a.a.a.a locala1 = com.tencent.mm.media.widget.a.a.a.lbV;
    locala.removeMessages(com.tencent.mm.media.widget.a.a.a.aYn());
    AppMethodBeat.o(94138);
  }
  
  public com.tencent.mm.media.widget.a.b aYf()
  {
    boolean bool = true;
    AppMethodBeat.i(94143);
    Log.printInfoStack(this.jGx, "generateCameraConfig", new Object[0]);
    if (this.lcK == null)
    {
      Log.i(this.jGx, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94143);
      return null;
    }
    if (!aXQ())
    {
      Log.i(this.jGx, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94143);
      return null;
    }
    Object localObject = com.tencent.mm.media.widget.a.b.lbh;
    com.tencent.mm.media.widget.a.b.ul(getPreviewWidth());
    localObject = com.tencent.mm.media.widget.a.b.lbh;
    com.tencent.mm.media.widget.a.b.uk(getPreviewHeight());
    localObject = this.lcO;
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
        i = 0;
        label137:
        localObject = com.tencent.mm.media.widget.a.b.lbh;
        com.tencent.mm.media.widget.a.b.un(this.laR.wAw);
        localObject = com.tencent.mm.media.widget.a.b.lbh;
        com.tencent.mm.media.widget.a.b.uo(this.laR.wAx);
        if (i != 0)
        {
          localObject = com.tencent.mm.media.widget.a.b.lbh;
          i = com.tencent.mm.media.widget.a.b.aXY();
          localObject = com.tencent.mm.media.widget.a.b.lbh;
          localObject = com.tencent.mm.media.widget.a.b.lbh;
          com.tencent.mm.media.widget.a.b.un(com.tencent.mm.media.widget.a.b.aXZ());
          localObject = com.tencent.mm.media.widget.a.b.lbh;
          com.tencent.mm.media.widget.a.b.uo(i);
        }
        localObject = com.tencent.mm.media.widget.a.b.lbh;
        com.tencent.mm.media.widget.a.b.um(getOrientation());
        localObject = com.tencent.mm.media.widget.a.b.lbh;
        if (this.laM) {
          break label282;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.media.widget.a.b.setFrontCamera(bool);
      localObject = com.tencent.mm.media.widget.a.b.lbh;
      com.tencent.mm.media.widget.a.b.fI(aXG());
      localObject = aXI();
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
      i = 0;
      break label137;
      label282:
      bool = false;
    }
  }
  
  public final int aYi()
  {
    AppMethodBeat.i(94162);
    c localc = c.lcH;
    if (c.aYp())
    {
      AppMethodBeat.o(94162);
      return 0;
    }
    AppMethodBeat.o(94162);
    return 1;
  }
  
  public final int aYj()
  {
    AppMethodBeat.i(94163);
    c localc = c.lcH;
    int i = c.aYr();
    AppMethodBeat.o(94163);
    return i;
  }
  
  public final String aYk()
  {
    AppMethodBeat.i(259603);
    Object localObject = this.lcN;
    if (localObject == null) {
      kotlin.g.b.p.bGy("previewRequest");
    }
    if (localObject != null)
    {
      localObject = (Integer)((CaptureRequest)localObject).get(CaptureRequest.CONTROL_AF_MODE);
      if (localObject != null) {
        break label69;
      }
      label40:
      if (localObject != null) {
        break label93;
      }
      label44:
      if (localObject != null) {
        break label117;
      }
    }
    label69:
    label93:
    label117:
    while (((Integer)localObject).intValue() != 3)
    {
      localObject = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
      localObject = b.b.aZu();
      AppMethodBeat.o(259603);
      return localObject;
      localObject = null;
      break;
      if (((Integer)localObject).intValue() != 1) {
        break label40;
      }
      localObject = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
      localObject = b.b.aZu();
      AppMethodBeat.o(259603);
      return localObject;
      if (((Integer)localObject).intValue() != 4) {
        break label44;
      }
      localObject = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
      localObject = b.b.aZt();
      AppMethodBeat.o(259603);
      return localObject;
    }
    localObject = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
    localObject = b.b.aZs();
    AppMethodBeat.o(259603);
    return localObject;
  }
  
  public final boolean aYl()
  {
    AppMethodBeat.i(259601);
    try
    {
      CaptureRequest.Builder localBuilder = this.lcL;
      if (localBuilder != null) {
        localBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      localBuilder = this.lcL;
      if (localBuilder != null) {
        localBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
      }
      AppMethodBeat.o(259601);
      return true;
    }
    catch (Exception localException)
    {
      Log.i(this.jGx, "triggerAutoFocus failed");
      AppMethodBeat.o(259601);
    }
    return false;
  }
  
  protected final CaptureRequest aYx()
  {
    AppMethodBeat.i(259531);
    CaptureRequest localCaptureRequest = this.lcN;
    if (localCaptureRequest == null) {
      kotlin.g.b.p.bGy("previewRequest");
    }
    AppMethodBeat.o(259531);
    return localCaptureRequest;
  }
  
  protected final CameraCharacteristics aYy()
  {
    return this.lcO;
  }
  
  protected final boolean aYz()
  {
    return this.lcS;
  }
  
  public final void av(String paramString, int paramInt)
  {
    AppMethodBeat.i(94160);
    kotlin.g.b.p.k(paramString, "tag");
    Object localObject = c.lcH;
    localObject = this.lcL;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    c.a((CaptureRequest.Builder)localObject, paramString, paramInt);
    aYC();
    AppMethodBeat.o(94160);
  }
  
  public void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(94137);
    if (com.tencent.mm.compatible.util.d.qW(14))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if ((this.lcK == null) || (this.lcM == null))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if (!aXQ())
    {
      AppMethodBeat.o(94137);
      return;
    }
    this.lcQ = new Rect(0, 0, paramInt1, paramInt2);
    Object localObject1 = this.lcO;
    if (localObject1 != null)
    {
      if (this.lcQ != null) {
        i = 1;
      }
      if (i == 0) {
        break label228;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = this.lcQ;
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        this.lcP = new b((CameraCharacteristics)localObject1, (Rect)localObject2);
      }
      localObject1 = this.laK;
      Object localObject2 = com.tencent.mm.media.widget.a.a.a.lbV;
      ((com.tencent.mm.media.widget.a.a.a)localObject1).removeMessages(com.tencent.mm.media.widget.a.a.a.aYn());
      this.laK.jLa = paramFloat1;
      this.laK.jLb = paramFloat2;
      this.laK.lbP = paramInt1;
      this.laK.lbQ = paramInt2;
      localObject1 = this.laK;
      localObject2 = this.laK;
      com.tencent.mm.media.widget.a.a.a.a locala = com.tencent.mm.media.widget.a.a.a.lbV;
      ((com.tencent.mm.media.widget.a.a.a)localObject1).sendMessageDelayed(((com.tencent.mm.media.widget.a.a.a)localObject2).obtainMessage(com.tencent.mm.media.widget.a.a.a.aYn()), 400L);
      AppMethodBeat.o(94137);
      return;
      label228:
      localObject1 = null;
    }
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    CaptureRequest.Builder localBuilder = null;
    AppMethodBeat.i(94132);
    long l = Util.currentTicks();
    Log.i(this.jGx, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (aXQ())
    {
      Log.i(this.jGx, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94132);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.lcS) {
          continue;
        }
        localCameraDevice = this.lcK;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(3);
        }
        this.lcL = localBuilder;
        uj(paramInt);
        aYd();
        if (a(paramSurfaceTexture, paramSurfaceHolder))
        {
          a(com.tencent.mm.media.widget.a.a.a.lbb);
          this.state = 0;
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        CameraDevice localCameraDevice;
        Log.e(this.jGx, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = f.laB;
        f.aVQ();
        continue;
      }
      Log.i(this.jGx, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(94132);
      return;
      localCameraDevice = this.lcK;
      if (localCameraDevice != null) {
        localBuilder = localCameraDevice.createCaptureRequest(1);
      }
    }
  }
  
  public final void b(g paramg) {}
  
  /* Error */
  public final boolean b(Rect paramRect1, Rect paramRect2)
  {
    // Byte code:
    //   0: ldc_w 1452
    //   3: invokestatic 329	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 1453
    //   10: invokestatic 356	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_2
    //   14: ldc_w 1454
    //   17: invokestatic 356	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 363	com/tencent/mm/media/widget/b/d:jGx	Ljava/lang/String;
    //   24: ldc_w 1456
    //   27: iconst_2
    //   28: anewarray 507	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload_2
    //   38: aastore
    //   39: invokestatic 985	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: invokevirtual 931	com/tencent/mm/media/widget/b/d:aXQ	()Z
    //   46: ifeq +336 -> 382
    //   49: aload_0
    //   50: getfield 585	com/tencent/mm/media/widget/b/d:lcO	Landroid/hardware/camera2/CameraCharacteristics;
    //   53: astore 5
    //   55: aload 5
    //   57: ifnull +333 -> 390
    //   60: aload 5
    //   62: getstatic 604	android/hardware/camera2/CameraCharacteristics:CONTROL_AF_AVAILABLE_MODES	Landroid/hardware/camera2/CameraCharacteristics$Key;
    //   65: invokevirtual 594	android/hardware/camera2/CameraCharacteristics:get	(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;
    //   68: checkcast 606	[I
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +336 -> 411
    //   78: aload 5
    //   80: arraylength
    //   81: istore 4
    //   83: iconst_0
    //   84: istore_3
    //   85: iload_3
    //   86: iload 4
    //   88: if_icmpge +315 -> 403
    //   91: aload 5
    //   93: iload_3
    //   94: iaload
    //   95: iconst_1
    //   96: if_icmpne +300 -> 396
    //   99: iconst_1
    //   100: istore_3
    //   101: aload_0
    //   102: getfield 446	com/tencent/mm/media/widget/b/d:lcL	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   105: astore 5
    //   107: aload 5
    //   109: ifnull +15 -> 124
    //   112: aload 5
    //   114: getstatic 615	android/hardware/camera2/CaptureRequest:CONTROL_AF_MODE	Landroid/hardware/camera2/CaptureRequest$Key;
    //   117: iload_3
    //   118: invokestatic 583	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: invokevirtual 559	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   124: aload_0
    //   125: getfield 446	com/tencent/mm/media/widget/b/d:lcL	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   128: astore 5
    //   130: aload 5
    //   132: ifnull +15 -> 147
    //   135: aload 5
    //   137: getstatic 577	android/hardware/camera2/CaptureRequest:CONTROL_MODE	Landroid/hardware/camera2/CaptureRequest$Key;
    //   140: iconst_1
    //   141: invokestatic 583	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: invokevirtual 559	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   147: aload_0
    //   148: iconst_1
    //   149: invokespecial 1458	com/tencent/mm/media/widget/b/d:fQ	(Z)Z
    //   152: ifeq +40 -> 192
    //   155: aload_0
    //   156: getfield 446	com/tencent/mm/media/widget/b/d:lcL	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   159: astore 5
    //   161: aload 5
    //   163: ifnull +29 -> 192
    //   166: aload 5
    //   168: getstatic 1461	android/hardware/camera2/CaptureRequest:CONTROL_AF_REGIONS	Landroid/hardware/camera2/CaptureRequest$Key;
    //   171: iconst_1
    //   172: anewarray 1463	android/hardware/camera2/params/MeteringRectangle
    //   175: dup
    //   176: iconst_0
    //   177: new 1463	android/hardware/camera2/params/MeteringRectangle
    //   180: dup
    //   181: aload_1
    //   182: sipush 1000
    //   185: invokespecial 1466	android/hardware/camera2/params/MeteringRectangle:<init>	(Landroid/graphics/Rect;I)V
    //   188: aastore
    //   189: invokevirtual 559	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   192: aload_0
    //   193: iconst_0
    //   194: invokespecial 1458	com/tencent/mm/media/widget/b/d:fQ	(Z)Z
    //   197: ifeq +37 -> 234
    //   200: aload_0
    //   201: getfield 446	com/tencent/mm/media/widget/b/d:lcL	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   204: astore_1
    //   205: aload_1
    //   206: ifnull +28 -> 234
    //   209: aload_1
    //   210: getstatic 1469	android/hardware/camera2/CaptureRequest:CONTROL_AE_REGIONS	Landroid/hardware/camera2/CaptureRequest$Key;
    //   213: iconst_1
    //   214: anewarray 1463	android/hardware/camera2/params/MeteringRectangle
    //   217: dup
    //   218: iconst_0
    //   219: new 1463	android/hardware/camera2/params/MeteringRectangle
    //   222: dup
    //   223: aload_2
    //   224: sipush 1000
    //   227: invokespecial 1466	android/hardware/camera2/params/MeteringRectangle:<init>	(Landroid/graphics/Rect;I)V
    //   230: aastore
    //   231: invokevirtual 559	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   234: aload_0
    //   235: getfield 446	com/tencent/mm/media/widget/b/d:lcL	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   238: astore_1
    //   239: aload_1
    //   240: ifnull +14 -> 254
    //   243: aload_1
    //   244: getstatic 635	android/hardware/camera2/CaptureRequest:CONTROL_AF_TRIGGER	Landroid/hardware/camera2/CaptureRequest$Key;
    //   247: iconst_0
    //   248: invokestatic 583	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: invokevirtual 559	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   254: aload_0
    //   255: getfield 551	com/tencent/mm/media/widget/b/d:lcR	Z
    //   258: ifne +41 -> 299
    //   261: aload_0
    //   262: getfield 457	com/tencent/mm/media/widget/b/d:lcM	Landroid/hardware/camera2/CameraCaptureSession;
    //   265: astore_1
    //   266: aload_1
    //   267: ifnull +32 -> 299
    //   270: aload_0
    //   271: getfield 446	com/tencent/mm/media/widget/b/d:lcL	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   274: astore_2
    //   275: aload_2
    //   276: ifnonnull +6 -> 282
    //   279: invokestatic 449	kotlin/g/b/p:iCn	()V
    //   282: aload_1
    //   283: aload_2
    //   284: invokevirtual 638	android/hardware/camera2/CaptureRequest$Builder:build	()Landroid/hardware/camera2/CaptureRequest;
    //   287: aconst_null
    //   288: aload_0
    //   289: getfield 473	com/tencent/mm/media/widget/a/a:laK	Lcom/tencent/mm/media/widget/a/a/a;
    //   292: getfield 479	com/tencent/mm/media/widget/a/a/a:lbL	Landroid/os/Handler;
    //   295: invokevirtual 648	android/hardware/camera2/CameraCaptureSession:setRepeatingRequest	(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/os/Handler;)I
    //   298: pop
    //   299: aload_0
    //   300: getfield 446	com/tencent/mm/media/widget/b/d:lcL	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   303: astore_1
    //   304: aload_1
    //   305: ifnull +14 -> 319
    //   308: aload_1
    //   309: getstatic 635	android/hardware/camera2/CaptureRequest:CONTROL_AF_TRIGGER	Landroid/hardware/camera2/CaptureRequest$Key;
    //   312: iconst_1
    //   313: invokestatic 583	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   316: invokevirtual 559	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   319: aload_0
    //   320: getfield 551	com/tencent/mm/media/widget/b/d:lcR	Z
    //   323: ifne +137 -> 460
    //   326: aload_0
    //   327: getfield 367	com/tencent/mm/media/widget/b/d:lcI	Ljava/lang/String;
    //   330: ldc_w 1471
    //   333: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: aload_0
    //   337: getfield 457	com/tencent/mm/media/widget/b/d:lcM	Landroid/hardware/camera2/CameraCaptureSession;
    //   340: astore_1
    //   341: aload_1
    //   342: ifnull +35 -> 377
    //   345: aload_0
    //   346: getfield 446	com/tencent/mm/media/widget/b/d:lcL	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   349: astore_2
    //   350: aload_2
    //   351: ifnonnull +6 -> 357
    //   354: invokestatic 449	kotlin/g/b/p:iCn	()V
    //   357: aload_1
    //   358: aload_2
    //   359: invokevirtual 638	android/hardware/camera2/CaptureRequest$Builder:build	()Landroid/hardware/camera2/CaptureRequest;
    //   362: aload_0
    //   363: getfield 436	com/tencent/mm/media/widget/b/d:lcY	Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;
    //   366: aload_0
    //   367: getfield 473	com/tencent/mm/media/widget/a/a:laK	Lcom/tencent/mm/media/widget/a/a/a;
    //   370: getfield 479	com/tencent/mm/media/widget/a/a/a:lbL	Landroid/os/Handler;
    //   373: invokevirtual 648	android/hardware/camera2/CameraCaptureSession:setRepeatingRequest	(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/os/Handler;)I
    //   376: pop
    //   377: aload_0
    //   378: iconst_5
    //   379: putfield 503	com/tencent/mm/media/widget/b/d:state	I
    //   382: ldc_w 1452
    //   385: invokestatic 348	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: iconst_1
    //   389: ireturn
    //   390: aconst_null
    //   391: astore 5
    //   393: goto -320 -> 73
    //   396: iload_3
    //   397: iconst_1
    //   398: iadd
    //   399: istore_3
    //   400: goto -315 -> 85
    //   403: aload 5
    //   405: iconst_0
    //   406: iaload
    //   407: istore_3
    //   408: goto -307 -> 101
    //   411: iconst_1
    //   412: istore_3
    //   413: goto -312 -> 101
    //   416: astore_1
    //   417: new 706	java/lang/StringBuilder
    //   420: dup
    //   421: ldc_w 1473
    //   424: invokespecial 710	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   427: aload_1
    //   428: invokevirtual 1474	android/hardware/camera2/CameraAccessException:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 926	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: goto -136 -> 299
    //   438: astore_1
    //   439: new 706	java/lang/StringBuilder
    //   442: dup
    //   443: ldc_w 1473
    //   446: invokespecial 710	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: aload_1
    //   450: invokevirtual 1475	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   453: invokevirtual 926	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: goto -158 -> 299
    //   460: aload_0
    //   461: getfield 367	com/tencent/mm/media/widget/b/d:lcI	Ljava/lang/String;
    //   464: ldc_w 1477
    //   467: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload_0
    //   471: getfield 363	com/tencent/mm/media/widget/b/d:jGx	Ljava/lang/String;
    //   474: ldc_w 1479
    //   477: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: ldc_w 1452
    //   483: invokestatic 348	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   486: iconst_0
    //   487: ireturn
    //   488: astore_1
    //   489: aload_0
    //   490: getfield 363	com/tencent/mm/media/widget/b/d:jGx	Ljava/lang/String;
    //   493: ldc_w 1481
    //   496: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: ldc_w 1452
    //   502: invokestatic 348	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   505: iconst_0
    //   506: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	d
    //   0	507	1	paramRect1	Rect
    //   0	507	2	paramRect2	Rect
    //   84	329	3	i	int
    //   81	8	4	j	int
    //   53	351	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   254	266	416	android/hardware/camera2/CameraAccessException
    //   270	275	416	android/hardware/camera2/CameraAccessException
    //   279	282	416	android/hardware/camera2/CameraAccessException
    //   282	299	416	android/hardware/camera2/CameraAccessException
    //   254	266	438	java/lang/IllegalStateException
    //   270	275	438	java/lang/IllegalStateException
    //   279	282	438	java/lang/IllegalStateException
    //   282	299	438	java/lang/IllegalStateException
    //   319	341	488	android/hardware/camera2/CameraAccessException
    //   345	350	488	android/hardware/camera2/CameraAccessException
    //   354	357	488	android/hardware/camera2/CameraAccessException
    //   357	377	488	android/hardware/camera2/CameraAccessException
    //   460	486	488	android/hardware/camera2/CameraAccessException
  }
  
  @TargetApi(14)
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
      Log.i(this.jGx, "safeSetMetering");
      Rect localRect = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
      MeteringRectangle[] arrayOfMeteringRectangle = new MeteringRectangle[1];
      if (localRect != null) {}
      for (paramCameraCharacteristics = Integer.valueOf(localRect.right);; paramCameraCharacteristics = null)
      {
        if (paramCameraCharacteristics == null) {
          kotlin.g.b.p.iCn();
        }
        arrayOfMeteringRectangle[0] = new MeteringRectangle(paramCameraCharacteristics.intValue() / 2 - 500, localRect.bottom / 2 - 500, 1000, 1000, 0);
        paramCameraCharacteristics = this.lcL;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.lcL;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.lcL;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        }
        paramCameraCharacteristics = this.lcL;
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
      Log.i(this.jGx, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
      AppMethodBeat.o(94153);
    }
  }
  
  public final int dB(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(259612);
    paramInt1 = i;
    switch (paramInt2)
    {
    default: 
      paramInt1 = i;
    }
    while (!this.laM)
    {
      localc = c.lcH;
      paramInt2 = c.aYr();
      AppMethodBeat.o(259612);
      return (360 - (paramInt1 + paramInt2) % 360) % 360;
      paramInt1 = 90;
      continue;
      paramInt1 = 180;
      continue;
      paramInt1 = 270;
    }
    c localc = c.lcH;
    paramInt2 = c.aYr();
    AppMethodBeat.o(259612);
    return (paramInt2 - paramInt1 + 360) % 360;
  }
  
  public final boolean dC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259594);
    try
    {
      SurfaceTexture localSurfaceTexture = getSurfaceTexture();
      if (localSurfaceTexture == null) {
        kotlin.g.b.p.iCn();
      }
      localSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
      AppMethodBeat.o(259594);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(259594);
    }
    return false;
  }
  
  public Point fJ(boolean paramBoolean)
  {
    AppMethodBeat.i(94146);
    if (!paramBoolean)
    {
      localPoint = new Point(this.laR.wAw, this.laR.wAx);
      AppMethodBeat.o(94146);
      return localPoint;
    }
    if (this.laW != null)
    {
      localPoint = this.laW;
      if (localPoint == null) {
        kotlin.g.b.p.iCn();
      }
      AppMethodBeat.o(94146);
      return localPoint;
    }
    Point localPoint = new Point(this.laR.wAw, this.laR.wAx);
    AppMethodBeat.o(94146);
    return localPoint;
  }
  
  public final void fK(boolean paramBoolean)
  {
    AppMethodBeat.i(94164);
    Object localObject = c.lcH;
    localObject = this.lcL;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    c.a(paramBoolean, (CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94164);
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(94165);
    Object localObject = c.lcH;
    localObject = this.lcL;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    int i = c.a((CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94165);
    return i;
  }
  
  protected final int getOrientation()
  {
    AppMethodBeat.i(259584);
    if (aXQ())
    {
      c localc = c.lcH;
      int i = c.aYr();
      AppMethodBeat.o(259584);
      return i;
    }
    AppMethodBeat.o(259584);
    return -1;
  }
  
  protected int getPreviewHeight()
  {
    AppMethodBeat.i(94144);
    if (this.lcK == null)
    {
      AppMethodBeat.o(94144);
      return 0;
    }
    try
    {
      if ((aXG()) && (this.laW != null))
      {
        Point localPoint = this.laW;
        if (localPoint == null) {
          kotlin.g.b.p.iCn();
        }
        i = localPoint.y;
        AppMethodBeat.o(94144);
        return i;
      }
      int i = this.laR.wAx;
      AppMethodBeat.o(94144);
      return i;
    }
    catch (Exception localException)
    {
      Log.e(this.jGx, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94144);
    }
    return 0;
  }
  
  protected int getPreviewWidth()
  {
    AppMethodBeat.i(94145);
    if (this.lcK == null)
    {
      AppMethodBeat.o(94145);
      return 0;
    }
    if (this.lcf != null) {
      try
      {
        if ((aXG()) && (this.laW != null))
        {
          Point localPoint = this.laW;
          if (localPoint == null) {
            kotlin.g.b.p.iCn();
          }
          i = localPoint.x;
          AppMethodBeat.o(94145);
          return i;
        }
        int i = this.laR.wAw;
        AppMethodBeat.o(94145);
        return i;
      }
      catch (Exception localException)
      {
        Log.e(this.jGx, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94145);
    return 0;
  }
  
  public final float[] getSupportZoomRatios()
  {
    AppMethodBeat.i(94141);
    if ((this.lcV == null) && (this.lcO != null))
    {
      localObject = this.lcO;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      Float localFloat = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      localObject = localFloat;
      if (localFloat == null) {
        localObject = Float.valueOf(0.0F);
      }
      kotlin.g.b.p.j(localObject, "mCharacteristics!!.get(C…_MAX_DIGITAL_ZOOM)?: 0.0f");
      float f = (int)(((Float)localObject).floatValue() * 10.0F) * 1.0F / 10.0F;
      this.lcV = new float[(int)(f * 10.0F)];
      int i = 0;
      int j = (int)(f * 10.0F);
      while (i < j)
      {
        localObject = this.lcV;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        localObject[i] = (i * 1.0F / 10.0F + 1.0F);
        i += 1;
      }
    }
    Object localObject = this.lcV;
    AppMethodBeat.o(94141);
    return localObject;
  }
  
  public void k(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94140);
    if ((this.lcK != null) && (aXQ())) {}
    for (;;)
    {
      float f2;
      try
      {
        Log.d(this.jGx, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (aXL())
        {
          Log.d(this.jGx, "triggerSmallZoom, zooming, ignore");
          return;
        }
        fG(true);
        localObject1 = this.lcL;
        if (localObject1 != null)
        {
          localObject3 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
          localObject1 = this.lcO;
          if (localObject1 != null)
          {
            localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            f1 = ((Rect)localObject1).width();
            if (localObject3 == null) {
              kotlin.g.b.p.iCn();
            }
            f2 = f1 / ((Rect)localObject3).width();
            localObject3 = this.lcO;
            if (localObject3 == null) {
              kotlin.g.b.p.iCn();
            }
            Float localFloat = (Float)((CameraCharacteristics)localObject3).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            localObject3 = localFloat;
            if (localFloat == null) {
              localObject3 = Float.valueOf(0.0F);
            }
            kotlin.g.b.p.j(localObject3, "mCharacteristics!!.get(C…_MAX_DIGITAL_ZOOM)?: 0.0f");
            f1 = ((Float)localObject3).floatValue();
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
          localObject3 = null;
          continue;
        }
        localObject1 = null;
        continue;
        f2 = this.lbi + f2;
        if (f2 < f1) {
          break label552;
        }
        Log.d(this.jGx, "triggerSmallZoom, nextZoom: %s", new Object[] { Float.valueOf(f1) });
        f2 = ((Rect)localObject1).width() / f1;
        f1 = ((Rect)localObject1).height() / f1;
        float f3 = (((Rect)localObject1).width() - f2) / 2.0F;
        float f4 = (((Rect)localObject1).height() - f1) / 2.0F;
        localObject1 = new Rect((int)f3, (int)f4, (int)(f2 + f3), (int)(f1 + f4));
        localObject3 = this.lcL;
        if (localObject3 != null) {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
        }
        paramBoolean = this.lcR;
        if (paramBoolean) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        Log.e(this.jGx, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        fG(false);
        AppMethodBeat.o(94140);
      }
      try
      {
        localObject1 = this.lcM;
        if (localObject1 != null)
        {
          localObject3 = this.lcL;
          if (localObject3 == null) {
            kotlin.g.b.p.iCn();
          }
          ((CameraCaptureSession)localObject1).setRepeatingRequest(((CaptureRequest.Builder)localObject3).build(), this.lcY, this.laK.lbL);
        }
      }
      catch (CameraAccessException localCameraAccessException)
      {
        continue;
      }
      fG(false);
      AppMethodBeat.o(94140);
      return;
      if (f2 == 1.0F)
      {
        fG(false);
        AppMethodBeat.o(94140);
        return;
      }
      float f1 = this.lbi;
      f2 -= f1;
      f1 = f2;
      if (f2 <= 1.0F)
      {
        f1 = 1.0F;
        continue;
        AppMethodBeat.o(94140);
        return;
        label552:
        f1 = f2;
      }
    }
  }
  
  public final boolean n(kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    com.tencent.mm.media.widget.d.a locala2 = null;
    AppMethodBeat.i(94157);
    kotlin.g.b.p.k(paramb, "dataCallback");
    Log.i(this.jGx, "takePhoto");
    a(com.tencent.mm.media.widget.a.a.a.lbc);
    Object localObject1 = c.lcH;
    localObject1 = c.aYo();
    Object localObject2 = c.lcH;
    if (kotlin.g.b.p.h(localObject1, c.us(c.lcg)))
    {
      localObject1 = com.tencent.mm.media.widget.d.a.lim;
      com.tencent.mm.media.widget.d.a.aZZ();
      for (;;)
      {
        try
        {
          if (this.state != 0)
          {
            a(this.lcO);
            localObject1 = this.lcL;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
            }
            localObject1 = this.lcL;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
            }
            localObject1 = this.lcL;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
            }
            localObject1 = this.lcL;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((CaptureRequest.Builder)localObject1).build();
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            this.lcN = ((CaptureRequest)localObject1);
            boolean bool = this.lcR;
            if (bool) {}
          }
        }
        catch (Exception localException)
        {
          CaptureRequest.Builder localBuilder;
          locala2 = com.tencent.mm.media.widget.d.a.lim;
          com.tencent.mm.media.widget.d.a.baa();
          Log.printInfoStack(this.jGx, "take photo in back camera error", new Object[] { localException });
          continue;
          locala1 = null;
          continue;
        }
        try
        {
          localObject1 = this.lcM;
          if (localObject1 != null)
          {
            localObject2 = this.lcN;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("previewRequest");
            }
            ((CameraCaptureSession)localObject1).setRepeatingRequest((CaptureRequest)localObject2, this.lcY, this.laK.lbL);
          }
        }
        catch (CameraAccessException localCameraAccessException)
        {
          Log.e(this.jGx, "setRepeatingRequest failed, errMsg: ");
        }
      }
      this.state = 0;
      this.laK.removeCallbacksAndMessages(null);
      localObject1 = this.lcL;
      if (localObject1 != null) {
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      this.state = 1;
      if (!this.lcR)
      {
        localObject1 = this.lcL;
        if (localObject1 == null) {
          break label405;
        }
        localObject1 = ((CaptureRequest.Builder)localObject1).build();
        if (localObject1 != null)
        {
          localObject2 = this.lcM;
          if (localObject2 != null)
          {
            localBuilder = this.lcL;
            localObject1 = locala2;
            if (localBuilder != null) {
              localObject1 = localBuilder.build();
            }
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            ((CameraCaptureSession)localObject2).capture((CaptureRequest)localObject1, this.lcY, this.laK.lbL);
          }
        }
      }
    }
    for (;;)
    {
      this.laK.lbN = paramb;
      AppMethodBeat.o(94157);
      return true;
      localObject1 = null;
      break;
      label405:
      com.tencent.mm.media.widget.d.a locala1 = com.tencent.mm.media.widget.d.a.lim;
      com.tencent.mm.media.widget.d.a.aZY();
      aYB();
    }
  }
  
  public final void o(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(94133);
    this.lbx = paramb;
    c localc = c.lcH;
    c.o(paramb);
    AppMethodBeat.o(94133);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94155);
    super.release();
    if (this.lcK != null)
    {
      long l = Util.currentTicks();
      Log.i(this.jGx, "release camera beg, %s", new Object[] { Looper.myLooper() });
      this.laK.removeCallbacksAndMessages(null);
      aYA();
      localObject = this.mSurface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      Log.i(this.jGx, "release camera end, use %dms, %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
    }
    this.laW = null;
    fH(false);
    Object localObject = com.tencent.mm.media.widget.d.a.lim;
    com.tencent.mm.media.widget.d.a.aZX();
    AppMethodBeat.o(94155);
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(94166);
    CaptureRequest.Builder localBuilder = this.lcL;
    if (localBuilder != null)
    {
      Object localObject = c.lcH;
      kotlin.g.b.p.k(localBuilder, "builder");
      switch (paramInt)
      {
      }
      label142:
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
        localObject = c.lcf;
        if (localObject != null)
        {
          localObject = ((CameraManager)localObject).getCameraCharacteristics(String.valueOf(c.lcq));
          if (localObject == null) {}
        }
        for (localObject = (int[])((CameraCharacteristics)localObject).get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);; localObject = null)
        {
          if (!com.tencent.mm.compatible.loader.a.contains((int[])localObject, 2)) {
            break label142;
          }
          localBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
          break;
        }
      }
    }
    AppMethodBeat.o(94166);
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(94142);
    if (aXL())
    {
      Log.d(this.jGx, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94142);
      return;
    }
    if ((this.lcO != null) && (this.lcL != null)) {
      try
      {
        localObject1 = this.lcO;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        int i = ((Rect)localObject1).width() - kotlin.h.a.dm(((Rect)localObject1).width() / paramFloat);
        int j = ((Rect)localObject1).height() - kotlin.h.a.dm(((Rect)localObject1).height() / paramFloat);
        this.lcU = new Rect(i / 2, j / 2, ((Rect)localObject1).width() - i / 2, ((Rect)localObject1).height() - j / 2);
        localObject1 = this.lcL;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.SCALER_CROP_REGION, this.lcU);
        boolean bool = this.lcR;
        if (bool) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        label234:
        Log.e(this.jGx, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        fG(false);
        AppMethodBeat.o(94142);
      }
    }
    try
    {
      localObject1 = this.lcM;
      if (localObject1 != null)
      {
        CaptureRequest.Builder localBuilder = this.lcL;
        if (localBuilder == null) {
          kotlin.g.b.p.iCn();
        }
        ((CameraCaptureSession)localObject1).setRepeatingRequest(localBuilder.build(), this.lcY, this.laK.lbL);
      }
    }
    catch (CameraAccessException localCameraAccessException)
    {
      break label234;
    }
    fG(false);
    AppMethodBeat.o(94142);
    return;
    AppMethodBeat.o(94142);
  }
  
  public final boolean ui(int paramInt)
  {
    AppMethodBeat.i(259610);
    try
    {
      Object localObject = this.lcM;
      if (localObject != null) {}
      for (localObject = ((CameraCaptureSession)localObject).getDevice();; localObject = null)
      {
        if (localObject != null) {}
        AppMethodBeat.o(259610);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.e(this.jGx, "open scene " + paramInt + " open failed, error:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(259610);
    }
  }
  
  public final boolean uj(int paramInt)
  {
    AppMethodBeat.i(94154);
    try
    {
      super.uj(paramInt);
      boolean bool = aXV();
      Point localPoint = aXX();
      Object localObject1 = c.lcH;
      Object localObject2 = h.b(c.aYv(), localPoint, paramInt, bool);
      localObject1 = localObject2;
      if (((h.c)localObject2).EZN == null)
      {
        localObject1 = new Point(Math.min(aXX().x, aXX().y), Math.max(aXX().x, aXX().y));
        localObject2 = c.lcH;
        localObject1 = h.a(c.aYv(), (Point)localObject1, aXF(), bool);
      }
      if (((h.c)localObject1).EZN == null)
      {
        localObject2 = com.tencent.mm.media.widget.d.a.lim;
        com.tencent.mm.media.widget.d.a.bad();
        Log.i(this.jGx, "checkMore start %s", new Object[] { ((h.c)localObject1).toString() });
        ((h.c)localObject1).EZN = ((h.c)localObject1).EZQ;
        ((h.c)localObject1).EZO = ((h.c)localObject1).EZR;
        ((h.c)localObject1).EZP = ((h.c)localObject1).EZS;
      }
      localObject2 = c.lcH;
      c.d(localPoint);
      localObject1 = new Size(((h.c)localObject1).EZN.x, ((h.c)localObject1).EZN.y);
      paramInt = ((Size)localObject1).getWidth();
      int i = ((Size)localObject1).getHeight();
      localObject1 = c.lcH;
      localObject1 = ImageReader.newInstance(paramInt, i, c.aYq(), 1);
      ((ImageReader)localObject1).setOnImageAvailableListener(this.laK.lbT, this.laK.lbL);
      this.jUA = ((ImageReader)localObject1);
      AppMethodBeat.o(94154);
      return true;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      Log.printErrStackTrace(this.jGx, (Throwable)localCameraAccessException, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", new Object[] { Looper.myLooper(), localCameraAccessException.getMessage() });
      AppMethodBeat.o(94154);
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.jGx, (Throwable)localException, "selectNoCropPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
      AppMethodBeat.o(94154);
    }
    return false;
  }
  
  public final void up(int paramInt)
  {
    AppMethodBeat.i(94139);
    if (aXK() > 0)
    {
      AppMethodBeat.o(94139);
      return;
    }
    Object localObject = ar.au(MMApplicationContext.getContext());
    int i = ((Point)localObject).y;
    Log.i(this.jGx, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94139);
      return;
    }
    try
    {
      localObject = this.lcO;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      Float localFloat = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      localObject = localFloat;
      if (localFloat == null) {
        localObject = Float.valueOf(0.0F);
      }
      kotlin.g.b.p.j(localObject, "mCharacteristics!!.get(C…_MAX_DIGITAL_ZOOM)?: 0.0f");
      float f = ((Float)localObject).floatValue();
      double d = f / (paramInt / 3.0D / 10.0D);
      if (d > 0.0D) {
        uh((int)d + 1);
      }
      Log.i(this.jGx, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(aXK()), Float.valueOf(f) });
      AppMethodBeat.o(94139);
      return;
    }
    catch (Exception localException)
    {
      Log.e(this.jGx, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94139);
    }
  }
  
  public final void ur(int paramInt)
  {
    this.lby = paramInt;
  }
  
  public final boolean y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94128);
    kotlin.g.b.p.k(paramContext, "context");
    try
    {
      localObject = MMApplicationContext.getContext().getSystemService("camera");
      if (localObject == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(94128);
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace(this.jGx, (Throwable)paramContext, "init camera failed!", new Object[0]);
      paramContext = f.laB;
      f.aVQ();
      AppMethodBeat.o(94128);
      return false;
    }
    this.lcf = ((CameraManager)localObject);
    Object localObject = c.lcH;
    c.a(this.lcf);
    if (aXN())
    {
      Log.i(this.jGx, "initCamera, already open");
      AppMethodBeat.o(94128);
      return true;
    }
    localObject = f.laB;
    f.aVO();
    super.y(paramContext, paramBoolean);
    release();
    aYA();
    if (paramBoolean) {
      paramContext = c.lcH;
    }
    for (paramContext = c.us(c.lcg);; paramContext = c.us(c.lch))
    {
      Log.printInfoStack(this.jGx, "use camera id %s, SrvDeviceInfo id %d", new Object[] { paramContext, Integer.valueOf(af.juH.jqk) });
      localObject = com.tencent.mm.media.widget.d.a.lim;
      com.tencent.mm.media.widget.d.a.aZU();
      localObject = getContext();
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      if (Util.checkPermission((Context)localObject, "android.permission.CAMERA")) {
        break;
      }
      Log.e(this.jGx, "it was lack of the camera permision to open camera");
      AppMethodBeat.o(94128);
      return true;
      paramContext = c.lcH;
    }
    try
    {
      if (!this.lcJ.tryAcquire(2500L, TimeUnit.MILLISECONDS))
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
      localObject = this.lcf;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      ((CameraManager)localObject).openCamera(paramContext, (CameraDevice.StateCallback)this.lcX, this.laK.lbL);
    }
    catch (CameraAccessException localCameraAccessException)
    {
      label348:
      break label348;
    }
    localObject = c.lcH;
    c.lcq = paramContext;
    if (paramContext == null) {
      kotlin.g.b.p.iCn();
    }
    kotlin.g.b.p.k(paramContext, "id");
    localObject = c.lcf;
    if (localObject != null) {}
    for (paramContext = ((CameraManager)localObject).getCameraCharacteristics(paramContext);; paramContext = null)
    {
      if (paramContext == null) {
        kotlin.g.b.p.iCn();
      }
      paramContext = paramContext.get(CameraCharacteristics.SENSOR_ORIENTATION);
      if (paramContext == null) {
        kotlin.g.b.p.iCn();
      }
      c.lcs = ((Number)paramContext).intValue();
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/widget/camera2/CommonCamera2$captureStillPicture$2$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "onCaptureCompleted", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "result", "Landroid/hardware/camera2/TotalCaptureResult;", "plugin-mediaeditor_release"})
  public static final class c
    extends CameraCaptureSession.CaptureCallback
  {
    c(d paramd) {}
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(94118);
      kotlin.g.b.p.k(paramCameraCaptureSession, "session");
      kotlin.g.b.p.k(paramCaptureRequest, "request");
      kotlin.g.b.p.k(paramTotalCaptureResult, "result");
      paramCameraCaptureSession = c.lcH;
      paramCameraCaptureSession = this.ldc.lcL;
      if (paramCameraCaptureSession == null) {
        kotlin.g.b.p.iCn();
      }
      c.g(paramCameraCaptureSession);
      AppMethodBeat.o(94118);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "camera", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "plugin-mediaeditor_release"})
  public static final class d
    extends CameraDevice.StateCallback
  {
    public final void onDisconnected(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94120);
      kotlin.g.b.p.k(paramCameraDevice, "camera");
      this.ldc.lcJ.release();
      paramCameraDevice.close();
      this.ldc.lcK = null;
      AppMethodBeat.o(94120);
    }
    
    public final void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      AppMethodBeat.i(94121);
      kotlin.g.b.p.k(paramCameraDevice, "camera");
      onDisconnected(paramCameraDevice);
      AppMethodBeat.o(94121);
    }
    
    public final void onOpened(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94119);
      kotlin.g.b.p.k(paramCameraDevice, "camera");
      this.ldc.lcJ.release();
      this.ldc.lcK = paramCameraDevice;
      AppMethodBeat.o(94119);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "capturePicture", "", "result", "Landroid/hardware/camera2/CaptureResult;", "checkFocusEnd", "", "onCaptureCompleted", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "Landroid/hardware/camera2/TotalCaptureResult;", "onCaptureProgressed", "partialResult", "process", "plugin-mediaeditor_release"})
  public static final class e
    extends CameraCaptureSession.CaptureCallback
  {
    private final void b(CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94122);
      switch (this.ldc.state)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94122);
        return;
        Object localObject = c.lcH;
        c.a(paramCaptureResult);
        AppMethodBeat.o(94122);
        return;
        localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if ((localObject == null) || (2 == ((Integer)localObject).intValue()) || (6 == ((Integer)localObject).intValue()))
        {
          d.c(this.ldc);
          AppMethodBeat.o(94122);
          return;
        }
        if ((4 == ((Integer)localObject).intValue()) || (5 == ((Integer)localObject).intValue()))
        {
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 2))
          {
            d.c(this.ldc);
            AppMethodBeat.o(94122);
            return;
          }
          d.d(this.ldc);
        }
        AppMethodBeat.o(94122);
        return;
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 5) || (paramCaptureResult.intValue() == 4))
        {
          this.ldc.state = 3;
          AppMethodBeat.o(94122);
          return;
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() != 5))
          {
            d.c(this.ldc);
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
                if ((!this.ldc.aXQ()) || (this.ldc.lcR)) {
                  break label526;
                }
                Log.i(this.ldc.lcI, "STATE_TOUCH_FOCUSING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
                paramCaptureResult = this.ldc.lcL;
                if (paramCaptureResult != null) {
                  paramCaptureResult.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
                }
                paramCaptureResult = this.ldc.lcL;
                if (paramCaptureResult != null) {
                  paramCaptureResult.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
                }
                localObject = this.ldc;
                paramCaptureResult = this.ldc.lcL;
                if (paramCaptureResult == null) {
                  break label505;
                }
              }
            }
            label505:
            for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
            {
              if (paramCaptureResult == null) {
                kotlin.g.b.p.iCn();
              }
              ((d)localObject).a(paramCaptureResult);
              try
              {
                paramCaptureResult = this.ldc.lcM;
                if (paramCaptureResult != null) {
                  paramCaptureResult.setRepeatingRequest(this.ldc.aYx(), (CameraCaptureSession.CaptureCallback)this, d.e(this.ldc).lbL);
                }
              }
              catch (CameraAccessException paramCaptureResult)
              {
                for (;;)
                {
                  Log.e(d.a(this.ldc), "setRepeatingRequest failed, errMsg: ");
                }
              }
              d.e(this.ldc).lbR = true;
              this.ldc.state = 0;
              AppMethodBeat.o(94122);
              return;
              if (((Integer)localObject).intValue() != 5) {
                break;
              }
              break label296;
            }
            label526:
            Log.e(d.a(this.ldc), "current is not allowed to do anything casue capturing");
          }
        }
      }
    }
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(94124);
      kotlin.g.b.p.k(paramCameraCaptureSession, "session");
      kotlin.g.b.p.k(paramCaptureRequest, "request");
      kotlin.g.b.p.k(paramTotalCaptureResult, "result");
      b((CaptureResult)paramTotalCaptureResult);
      AppMethodBeat.o(94124);
    }
    
    public final void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94123);
      kotlin.g.b.p.k(paramCameraCaptureSession, "session");
      kotlin.g.b.p.k(paramCaptureRequest, "request");
      kotlin.g.b.p.k(paramCaptureResult, "partialResult");
      b(paramCaptureResult);
      AppMethodBeat.o(94123);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onClosed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigureFailed", "onConfigured", "plugin-mediaeditor_release"})
  public static final class f
    extends CameraCaptureSession.StateCallback
  {
    public final void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94127);
      kotlin.g.b.p.k(paramCameraCaptureSession, "session");
      super.onClosed(paramCameraCaptureSession);
      Log.i(d.a(this.ldc), "session on close");
      this.ldc.lcR = true;
      AppMethodBeat.o(94127);
    }
    
    public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94126);
      kotlin.g.b.p.k(paramCameraCaptureSession, "session");
      Log.i(d.a(this.ldc), "configure failed ");
      paramCameraCaptureSession = f.laB;
      f.aVQ();
      paramCameraCaptureSession = com.tencent.mm.media.widget.d.a.lim;
      com.tencent.mm.media.widget.d.a.aZW();
      AppMethodBeat.o(94126);
    }
    
    public final void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94125);
      kotlin.g.b.p.k(paramCameraCaptureSession, "session");
      Log.i(d.a(this.ldc), "session on onConfigured");
      if (this.ldc.lcK == null)
      {
        AppMethodBeat.o(94125);
        return;
      }
      this.ldc.lcR = false;
      this.ldc.lcM = paramCameraCaptureSession;
      paramCameraCaptureSession = f.laB;
      f.aVP();
      paramCameraCaptureSession = com.tencent.mm.media.widget.d.a.lim;
      com.tencent.mm.media.widget.d.a.aZV();
      d.b(this.ldc);
      AppMethodBeat.o(94125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d
 * JD-Core Version:    0.7.0.1
 */