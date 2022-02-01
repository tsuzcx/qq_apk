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
import android.os.Looper;
import android.util.Range;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "FOCUS_TAG", "", "getFOCUS_TAG", "()Ljava/lang/String;", "FOCUS_TAG$1", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "TAG$1", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "isUseRecordStream", "", "()Z", "setUseRecordStream", "(Z)V", "mCameraDevice", "Landroid/hardware/camera2/CameraDevice;", "getMCameraDevice", "()Landroid/hardware/camera2/CameraDevice;", "setMCameraDevice", "(Landroid/hardware/camera2/CameraDevice;)V", "mCameraDeviceCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1;", "mCameraFps", "", "getMCameraFps", "()I", "setMCameraFps", "(I)V", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "mCameraOpenCloseLock", "Ljava/util/concurrent/Semaphore;", "getMCameraOpenCloseLock", "()Ljava/util/concurrent/Semaphore;", "mCaptureCallback", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "getMCaptureCallback", "()Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "mCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "getMCaptureSession", "()Landroid/hardware/camera2/CameraCaptureSession;", "setMCaptureSession", "(Landroid/hardware/camera2/CameraCaptureSession;)V", "mCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "getMCharacteristics", "()Landroid/hardware/camera2/CameraCharacteristics;", "setMCharacteristics", "(Landroid/hardware/camera2/CameraCharacteristics;)V", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsNoAFRun", "getMIsNoAFRun", "setMIsNoAFRun", "mIsSessionClose", "getMIsSessionClose", "setMIsSessionClose", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mPreviewBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "getMPreviewBuilder", "()Landroid/hardware/camera2/CaptureRequest$Builder;", "setMPreviewBuilder", "(Landroid/hardware/camera2/CaptureRequest$Builder;)V", "mStateCallback", "com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1;", "mSurface", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mZoomTimesToRatio", "", "getMZoomTimesToRatio", "()[F", "setMZoomTimesToRatio", "([F)V", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "onHDRCheckerResult", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "previewRequest", "Landroid/hardware/camera2/CaptureRequest;", "getPreviewRequest", "()Landroid/hardware/camera2/CaptureRequest;", "setPreviewRequest", "(Landroid/hardware/camera2/CaptureRequest;)V", "state", "getState", "setState", "zoomOutRect", "Landroid/graphics/Rect;", "getZoomOutRect", "()Landroid/graphics/Rect;", "setZoomOutRect", "(Landroid/graphics/Rect;)V", "abandonFocus", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateLocDiff", "loc1", "loc2", "calculateTapArea", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "captureStillPicture", "checkCameraOpenSucc", "scene", "clamp", "min", "max", "closeCamera", "configVendorTagValue", "tag", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCameraSensorRotate", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getPreviewWidth", "getSupportPreviewSize", "", "Landroid/util/Size;", "()[Landroid/util/Size;", "getSupportZoomRatios", "initCamera", "useBack", "initRawRatios", "lock3AParams", "builder", "lockFocus", "openCamera", "nowCameraId", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "resumePreview", "runPrecaptureSequence", "safeResetZoom", "safeSetFocusMode", "characteristics", "safeSetMetering", "safeSetOIS", "safeSetPreviewFrameRate", "useFixMode", "safeSetStabilization", "safeSetVendorEffect", "selectNoCropPreviewSize", "resolutionLimit", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewSize", "width", "height", "setSafeConfig", "startPreview", "useCpuCrop", "surface", "startPreviewWithGPU", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "trySetPreviewFrameRateParameters", "Companion", "plugin-mediaeditor_release"})
public class c
  extends com.tencent.mm.media.widget.a.a
{
  private static final SparseIntArray inU;
  public static final c.a inV;
  private final String gVB;
  ImageReader hiC;
  private float imi;
  private kotlin.g.a.b<? super Boolean, kotlin.x> imw;
  int imx;
  private boolean imy;
  final String inF;
  final Semaphore inG;
  CameraDevice inH;
  CaptureRequest.Builder inI;
  CameraCaptureSession inJ;
  protected CaptureRequest inK;
  CameraCharacteristics inL;
  boolean inM;
  boolean inN;
  private boolean inO;
  private Rect inP;
  private float[] inQ;
  private final e inR;
  private final c inS;
  private final CameraCaptureSession.CaptureCallback inT;
  private CameraManager inc;
  private Surface mSurface;
  int state;
  
  static
  {
    AppMethodBeat.i(94168);
    inV = new c.a((byte)0);
    SparseIntArray localSparseIntArray = new SparseIntArray();
    inU = localSparseIntArray;
    localSparseIntArray.append(0, 90);
    inU.append(1, 0);
    inU.append(2, 270);
    inU.append(3, 180);
    AppMethodBeat.o(94168);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94167);
    this.gVB = "MicroMsg.CommonCamera2";
    this.inF = "MicroMsg.CommonCamera2.FoucsTag";
    this.imi = 0.1F;
    this.inG = new Semaphore(1);
    if (com.tencent.mm.media.widget.d.b.aRG())
    {
      paramContext = new com.tencent.mm.media.widget.b.a.c(paramContext);
      kotlin.g.a.q localq = (kotlin.g.a.q)1.inW;
      p.h(localq, "mSupportWCKeyAvailable");
      new Thread((Runnable)new com.tencent.mm.media.widget.b.a.c.a(paramContext, (kotlin.g.a.a)new com.tencent.mm.media.widget.b.a.c.b(paramContext, localq))).start();
      paramContext = b.inE;
      b.aPF();
    }
    this.inR = new e(this);
    this.inS = new c(this);
    this.inT = ((CameraCaptureSession.CaptureCallback)new d(this));
    this.imy = true;
    AppMethodBeat.o(94167);
  }
  
  private final void aPK()
  {
    AppMethodBeat.i(94129);
    try
    {
      if (this.inI != null)
      {
        localObject1 = b.inE;
        localObject1 = this.inI;
        if (localObject1 == null) {
          p.hyc();
        }
        b.g((CaptureRequest.Builder)localObject1);
      }
      this.inG.acquire();
      Object localObject1 = this.inJ;
      if (localObject1 != null) {
        ((CameraCaptureSession)localObject1).close();
      }
      this.inJ = null;
      localObject1 = this.inH;
      if (localObject1 != null) {
        ((CameraDevice)localObject1).close();
      }
      this.inH = null;
      localObject1 = this.hiC;
      if (localObject1 != null) {
        ((ImageReader)localObject1).setOnImageAvailableListener(null, this.ilK.imK);
      }
      localObject1 = this.hiC;
      if (localObject1 != null) {
        ((ImageReader)localObject1).close();
      }
      this.hiC = null;
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
      this.inG.release();
      AppMethodBeat.o(94129);
    }
  }
  
  private final void aPL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(94134);
    try
    {
      if (this.state == 4)
      {
        Log.printInfoStack(this.gVB, "capture still picture more than twice", new Object[0]);
        AppMethodBeat.o(94134);
        return;
      }
      this.state = 4;
      Log.i(this.gVB, "captureStillPicture");
      if (this.inH == null)
      {
        AppMethodBeat.o(94134);
        return;
      }
    }
    catch (Exception localException)
    {
      localObject2 = b.inE;
      if (!b.aPB())
      {
        localObject2 = com.tencent.mm.media.widget.d.a.itg;
        com.tencent.mm.media.widget.d.a.aRi();
      }
      Log.e(this.gVB, localException.toString());
      AppMethodBeat.o(94134);
      return;
    }
    Object localObject1 = this.inI;
    Object localObject3;
    label190:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
      if ((this.inH == null) || (this.inM))
      {
        AppMethodBeat.o(94134);
        return;
      }
      localObject3 = this.inH;
      if (localObject3 != null)
      {
        localObject3 = ((CameraDevice)localObject3).createCaptureRequest(2);
        if (localObject3 != null)
        {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
          localObject1 = this.hiC;
          if (localObject1 == null) {
            break label553;
          }
          localObject1 = ((ImageReader)localObject1).getSurface();
          if (localObject1 == null) {
            p.hyc();
          }
          ((CaptureRequest.Builder)localObject3).addTarget((Surface)localObject1);
          localObject1 = this.hiC;
          if (localObject1 != null) {
            ((ImageReader)localObject1).setOnImageAvailableListener(this.ilK.imS, this.ilK.imK);
          }
          p.g(localObject3, "this");
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
          localObject1 = this.inL;
          if (localObject1 == null) {
            break label558;
          }
          localObject1 = (Float)((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
          label270:
          if (localObject1 == null) {
            break label548;
          }
          if (!p.a((Float)localObject1)) {
            break label563;
          }
          break label548;
          label284:
          this.inO = bool;
          if (!this.inO)
          {
            localObject1 = this.inL;
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
        localObject1 = this.inL;
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
        this.inI = ((CaptureRequest.Builder)localObject1);
        localObject3 = this.inJ;
        if (localObject3 == null) {
          break label536;
        }
        ((CameraCaptureSession)localObject3).stopRepeating();
        Log.i(this.inF, "this time happened a cancel auto foucs while capture");
        localObject1 = this.inI;
        if (localObject1 != null) {
          ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
        }
        CaptureRequest.Builder localBuilder = this.inI;
        localObject1 = localObject2;
        if (localBuilder != null) {
          localObject1 = localBuilder.build();
        }
        if (localObject1 == null) {
          p.hyc();
        }
        ((CameraCaptureSession)localObject3).capture((CaptureRequest)localObject1, (CameraCaptureSession.CaptureCallback)new b(this), null);
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
  
  private final void aPM()
  {
    AppMethodBeat.i(94161);
    if (this.inI == null)
    {
      AppMethodBeat.o(94161);
      return;
    }
    if ((this.inH != null) && (!this.inM))
    {
      Object localObject = this.inI;
      if (localObject != null) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      }
      localObject = this.inI;
      if (localObject == null) {
        p.hyc();
      }
      h((CaptureRequest.Builder)localObject);
      CameraCaptureSession localCameraCaptureSession = this.inJ;
      if (localCameraCaptureSession != null)
      {
        localObject = this.inI;
        if (localObject != null) {}
        for (localObject = ((CaptureRequest.Builder)localObject).build();; localObject = null)
        {
          if (localObject == null) {
            p.hyc();
          }
          localCameraCaptureSession.setRepeatingRequest((CaptureRequest)localObject, this.inT, this.ilK.imK);
          AppMethodBeat.o(94161);
          return;
        }
      }
    }
    AppMethodBeat.o(94161);
  }
  
  private static int di(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    if (paramInt1 < 0) {
      return 0;
    }
    return paramInt1;
  }
  
  private static void h(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94152);
    b localb = b.inE;
    b.b(paramBuilder);
    localb = b.inE;
    b.d(paramBuilder);
    localb = b.inE;
    b.e(paramBuilder);
    localb = b.inE;
    b.c(paramBuilder);
    localb = b.inE;
    b.f(paramBuilder);
    AppMethodBeat.o(94152);
  }
  
  public final void B(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94159);
    p.h(paramString, "tag");
    com.tencent.mm.media.widget.b.a.a.b.a locala = com.tencent.mm.media.widget.b.a.a.b.ipa;
    if (p.j(paramString, com.tencent.mm.media.widget.b.a.a.b.aPW()))
    {
      paramString = b.inE;
      b.fg(paramBoolean);
    }
    for (;;)
    {
      aPM();
      AppMethodBeat.o(94159);
      return;
      locala = com.tencent.mm.media.widget.b.a.a.b.ipa;
      if (p.j(paramString, com.tencent.mm.media.widget.b.a.a.b.aQb()))
      {
        paramString = b.inE;
        b.fc(paramBoolean);
      }
      else
      {
        locala = com.tencent.mm.media.widget.b.a.a.b.ipa;
        if (p.j(paramString, com.tencent.mm.media.widget.b.a.a.b.aQa()))
        {
          paramString = b.inE;
          b.fd(paramBoolean);
        }
        else
        {
          locala = com.tencent.mm.media.widget.b.a.a.b.ipa;
          if (p.j(paramString, com.tencent.mm.media.widget.b.a.a.b.aQd()))
          {
            paramString = b.inE;
            b.fe(paramBoolean);
          }
          else
          {
            locala = com.tencent.mm.media.widget.b.a.a.b.ipa;
            if (p.j(paramString, com.tencent.mm.media.widget.b.a.a.b.aQc()))
            {
              paramString = b.inE;
              b.ff(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  public final Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218853);
    int j = this.ilR.sUz;
    int i = this.ilR.sUA;
    Object localObject = b.inE;
    if (90 != b.aPD())
    {
      localObject = b.inE;
      if (270 != b.aPD()) {}
    }
    else
    {
      j = this.ilR.sUA;
      i = this.ilR.sUz;
    }
    for (;;)
    {
      float f1 = 0.0F;
      float f2 = 0.0F;
      if (i * paramInt1 > j * paramInt2)
      {
        paramFloat3 = (float)(paramInt1 * 1.0D / j);
        f1 = (i - paramInt2 / paramFloat3) / 2.0F;
        paramFloat1 = f2 + paramFloat1 / paramFloat3;
        paramFloat2 = paramFloat2 / paramFloat3 + f1;
        localObject = b.inE;
        if (90 != b.aPD()) {
          break label483;
        }
        paramFloat1 = this.ilR.sUA - paramFloat1;
      }
      for (;;)
      {
        label150:
        localObject = this.inL;
        if (localObject == null) {
          p.hyc();
        }
        Rect localRect = (Rect)((CameraCharacteristics)localObject).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        localObject = this.inI;
        if (localObject != null)
        {
          localObject = (Rect)((CaptureRequest.Builder)localObject).get(CaptureRequest.SCALER_CROP_REGION);
          label201:
          if (localObject != null) {
            break label559;
          }
          Log.e(this.gVB, "can't get crop region");
          localObject = localRect;
        }
        label559:
        for (;;)
        {
          if (localObject == null) {
            p.hyc();
          }
          paramInt1 = ((Rect)localObject).width();
          paramInt2 = ((Rect)localObject).height();
          if (this.ilR.sUA * paramInt1 > this.ilR.sUz * paramInt2)
          {
            paramFloat3 = (float)(paramInt2 * 1.0D / this.ilR.sUA);
            f1 = 0.0F;
            f2 = (paramInt1 - this.ilR.sUz * paramFloat3) / 2.0F;
          }
          for (;;)
          {
            paramFloat2 = f2 + paramFloat2 * paramFloat3 + ((Rect)localObject).left;
            paramFloat1 = paramFloat3 * paramFloat1 + f1 + ((Rect)localObject).top;
            localRect = new Rect();
            localRect.left = di((int)(paramFloat2 - 0.05D * ((Rect)localObject).width()), ((Rect)localObject).width());
            localRect.right = di((int)(paramFloat2 + 0.05D * ((Rect)localObject).width()), ((Rect)localObject).width());
            localRect.top = di((int)(paramFloat1 - 0.05D * ((Rect)localObject).height()), ((Rect)localObject).height());
            localRect.bottom = di((int)(paramFloat1 + 0.05D * ((Rect)localObject).height()), ((Rect)localObject).height());
            AppMethodBeat.o(218853);
            return localRect;
            paramFloat3 = (float)(paramInt2 * 1.0D / i);
            f2 = (j - paramInt1 / paramFloat3) / 2.0F;
            break;
            label483:
            localObject = b.inE;
            if (270 != b.aPD()) {
              break label562;
            }
            paramFloat3 = this.ilR.sUz;
            paramFloat2 = paramFloat3 - paramFloat2;
            break label150;
            localObject = null;
            break label201;
            paramFloat3 = (float)(paramInt1 * 1.0D / this.ilR.sUz);
            f2 = 0.0F;
            f1 = (paramInt2 - this.ilR.sUA * paramFloat3) / 2.0F;
          }
        }
        label562:
        paramFloat3 = paramFloat1;
        paramFloat1 = paramFloat2;
        paramFloat2 = paramFloat3;
      }
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94130);
    this.inG.acquire();
    this.inG.release();
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    b(paramSurfaceTexture, null, paramInt);
    AppMethodBeat.o(94130);
  }
  
  protected void a(CameraCharacteristics paramCameraCharacteristics, int paramInt)
  {
    AppMethodBeat.i(218849);
    if (ae.gKt.gFP > 0)
    {
      Log.i(this.ilH, "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(218849);
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
      AppMethodBeat.o(218849);
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
        Log.i(this.gVB, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(m), localInteger1, localInteger2 });
        if (p.compare(localInteger1.intValue(), 0) < 0) {
          break label217;
        }
        n = localInteger2.intValue();
        p.g(localInteger1, "min");
      } while (p.compare(n, localInteger1.intValue()) < 0);
      label217:
      if (paramInt == 0)
      {
        n = 30;
        label228:
        if ((p.compare(localInteger2.intValue(), j) < 0) || (i != 0) || (p.compare(localInteger2.intValue(), n) > 0)) {
          break label510;
        }
        k = localInteger1.intValue();
        p.g(localInteger2, "max");
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
        Log.i(this.ilH, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(30) });
        if ((k == 2147483647) || (j == 2147483647))
        {
          AppMethodBeat.o(218849);
          return;
        }
        try
        {
          paramCameraCharacteristics = this.inI;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range((Comparable)Integer.valueOf(k), (Comparable)Integer.valueOf(j)));
          }
          Log.i(this.ilH, "set fps range %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
          AppMethodBeat.o(218849);
          return;
        }
        catch (Exception paramCameraCharacteristics)
        {
          Log.i(this.ilH, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
          AppMethodBeat.o(218849);
          return;
        }
      }
      break;
    }
  }
  
  protected final void a(CaptureRequest paramCaptureRequest)
  {
    AppMethodBeat.i(218847);
    p.h(paramCaptureRequest, "<set-?>");
    this.inK = paramCaptureRequest;
    AppMethodBeat.o(218847);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94131);
    this.inG.acquire();
    this.inG.release();
    super.a(paramSurfaceHolder, paramBoolean, paramInt);
    b(null, paramSurfaceHolder, paramInt);
    AppMethodBeat.o(94131);
  }
  
  public final void a(g paramg) {}
  
  protected final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94135);
    Object localObject2 = this.inI;
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
            p.hyc();
          }
          ((CaptureRequest.Builder)localObject2).addTarget(paramSurfaceTexture);
          paramSurfaceTexture = b.inE;
          if (!b.aPI()) {
            break label486;
          }
          if (!this.inN) {
            break label288;
          }
          paramSurfaceTexture = b.inE;
          paramSurfaceTexture = this.inI;
          if (paramSurfaceTexture == null) {
            p.hyc();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.ipa;
          j = b.a(paramSurfaceTexture, j.listOf(com.tencent.mm.media.widget.b.a.a.b.aQc()));
          i = j;
          if (Build.VERSION.SDK_INT < 28) {
            break label470;
          }
          paramSurfaceTexture = this.mSurface;
          if (paramSurfaceTexture == null) {
            p.hyc();
          }
          paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration(paramSurfaceTexture)), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.inR);
          paramSurfaceHolder = this.inH;
          if (paramSurfaceHolder == null) {
            p.hyc();
          }
          paramSurfaceHolder.createCaptureSession(paramSurfaceTexture);
          if (j == 0)
          {
            paramSurfaceHolder = this.inH;
            if (paramSurfaceHolder == null) {
              p.hyc();
            }
            localObject1 = this.mSurface;
            paramSurfaceTexture = this.hiC;
            if (paramSurfaceTexture == null) {
              break label481;
            }
            paramSurfaceTexture = paramSurfaceTexture.getSurface();
            label219:
            paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localObject1, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.inR, this.ilK.imK);
          }
        }
        for (;;)
        {
          Log.i(this.gVB, "doStartPreview finish");
          AppMethodBeat.o(94135);
          return true;
          if (paramSurfaceHolder == null) {
            break;
          }
          this.mSurface = paramSurfaceHolder.getSurface();
          break;
          label288:
          paramSurfaceTexture = b.inE;
          paramSurfaceTexture = this.inI;
          if (paramSurfaceTexture == null) {
            p.hyc();
          }
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.ipa;
          paramSurfaceHolder = com.tencent.mm.media.widget.b.a.a.b.aQb();
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.ipa;
          localObject1 = com.tencent.mm.media.widget.b.a.a.b.aQa();
          localObject2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
          j = b.a(paramSurfaceTexture, j.listOf(new String[] { paramSurfaceHolder, localObject1, com.tencent.mm.media.widget.b.a.a.b.aQd() }));
          i = j;
          if (Build.VERSION.SDK_INT >= 28)
          {
            paramSurfaceTexture = this.mSurface;
            if (paramSurfaceTexture == null) {
              p.hyc();
            }
            paramSurfaceHolder = new OutputConfiguration(paramSurfaceTexture);
            paramSurfaceTexture = this.hiC;
            if (paramSurfaceTexture == null) {
              break label476;
            }
          }
          label470:
          label476:
          for (paramSurfaceTexture = paramSurfaceTexture.getSurface();; paramSurfaceTexture = null)
          {
            if (paramSurfaceTexture == null) {
              p.hyc();
            }
            paramSurfaceTexture = new SessionConfiguration(j, j.listOf(new OutputConfiguration[] { paramSurfaceHolder, new OutputConfiguration(paramSurfaceTexture) }), AsyncTask.THREAD_POOL_EXECUTOR, (CameraCaptureSession.StateCallback)this.inR);
            paramSurfaceHolder = this.inH;
            if (paramSurfaceHolder == null) {
              p.hyc();
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
          paramSurfaceHolder = this.inH;
          if (paramSurfaceHolder == null) {
            p.hyc();
          }
          localObject2 = this.mSurface;
          ImageReader localImageReader = this.hiC;
          paramSurfaceTexture = (SurfaceTexture)localObject1;
          if (localImageReader != null) {
            paramSurfaceTexture = localImageReader.getSurface();
          }
          paramSurfaceHolder.createCaptureSession(j.listOf(new Surface[] { localObject2, paramSurfaceTexture }), (CameraCaptureSession.StateCallback)this.inR, this.ilK.imK);
        }
      }
      Log.i(this.gVB, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNm();
      paramSurfaceTexture = com.tencent.mm.media.widget.d.a.itg;
      com.tencent.mm.media.widget.d.a.aRd();
      AppMethodBeat.o(94135);
      return false;
    }
    AppMethodBeat.o(94135);
    return false;
  }
  
  protected boolean a(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(94149);
    if (this.inH == null)
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
        if ((paramCameraCharacteristics != null) && (kotlin.a.e.contains(paramCameraCharacteristics, 4)))
        {
          Log.i(this.gVB, "support continuous picture");
          paramCameraCharacteristics = this.inI;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
          }
          AppMethodBeat.o(94149);
          return true;
          paramCameraCharacteristics = null;
          continue;
        }
        if ((paramCameraCharacteristics != null) && (kotlin.a.e.contains(paramCameraCharacteristics, 3)))
        {
          Log.i(this.gVB, "support continuous video");
          paramCameraCharacteristics = this.inI;
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
        Log.i(this.gVB, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(94149);
        return false;
      }
      if (kotlin.a.e.contains(paramCameraCharacteristics, 1))
      {
        Log.i(this.gVB, "support auto focus");
        paramCameraCharacteristics = this.inI;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        }
      }
      else
      {
        label217:
        Log.i(this.gVB, "not support continuous video or auto focus");
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
        m = this.imx;
        if (ae.gKt.gFP > 0) {
          Log.i(this.ilH, "set frame rate > 0, do not try set preview frame rate");
        }
        for (;;)
        {
          paramCameraCharacteristics = this.inI;
          if (paramCameraCharacteristics != null)
          {
            paramCameraCharacteristics = (Range)paramCameraCharacteristics.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
            label67:
            Log.i(this.ilH, "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), paramCameraCharacteristics });
            AppMethodBeat.o(94147);
            return true;
            if (paramCameraCharacteristics == null)
            {
              Log.e(this.gVB, "trySetPreviewFrameRateParameters error, p is null!");
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
                else if (m == 0)
                {
                  i = Math.min(30, k);
                  paramCameraCharacteristics = new Range((Comparable)Integer.valueOf(i), (Comparable)Integer.valueOf(i));
                  localObject = this.inI;
                  if (localObject == null) {
                    continue;
                  }
                  ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, paramCameraCharacteristics);
                }
              }
            }
            catch (Exception paramCameraCharacteristics)
            {
              Log.i(this.ilH, "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
            }
          }
        }
      }
      catch (Exception paramCameraCharacteristics)
      {
        Log.i(this.ilH, "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
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
      a(paramCameraCharacteristics, this.imx);
      break;
      paramCameraCharacteristics = null;
      break label67;
      j += 1;
      continue;
      int k = 0;
    }
  }
  
  protected final CaptureRequest aPJ()
  {
    AppMethodBeat.i(218846);
    CaptureRequest localCaptureRequest = this.inK;
    if (localCaptureRequest == null) {
      p.btv("previewRequest");
    }
    AppMethodBeat.o(218846);
    return localCaptureRequest;
  }
  
  public final boolean aPd()
  {
    AppMethodBeat.i(94158);
    this.inN = true;
    Object localObject = b.inE;
    b.ff(true);
    localObject = com.tencent.mm.media.widget.d.a.itg;
    com.tencent.mm.media.widget.d.a.aRp();
    AppMethodBeat.o(94158);
    return true;
  }
  
  public final int aPf()
  {
    AppMethodBeat.i(218856);
    Object localObject = this.inI;
    if (localObject != null)
    {
      localObject = (Range)((CaptureRequest.Builder)localObject).get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
      if (localObject != null)
      {
        p.g(localObject, "it");
        int i = ((Number)((Range)localObject).getLower()).intValue();
        localObject = ((Range)localObject).getUpper();
        p.g(localObject, "it.upper");
        i = (((Number)localObject).intValue() + i) / 2;
        AppMethodBeat.o(218856);
        return i;
      }
    }
    AppMethodBeat.o(218856);
    return 0;
  }
  
  public final boolean aPg()
  {
    AppMethodBeat.i(218859);
    Object localObject = this.inK;
    if (localObject == null) {
      p.btv("previewRequest");
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
      AppMethodBeat.o(218859);
      return false;
      localObject = null;
      break;
    }
    localObject = this.inI;
    if (localObject != null) {
      ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
    }
    localObject = this.inI;
    if (localObject != null) {
      ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
    }
    AppMethodBeat.o(218859);
    return true;
  }
  
  public final boolean aPh()
  {
    AppMethodBeat.i(218850);
    b localb = b.inE;
    if (b.aPD() != 90)
    {
      localb = b.inE;
      if (b.aPD() != 270) {}
    }
    else
    {
      AppMethodBeat.o(218850);
      return true;
    }
    AppMethodBeat.o(218850);
    return false;
  }
  
  public final Size[] aPi()
  {
    AppMethodBeat.i(218851);
    try
    {
      Object localObject1 = this.inc;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = b.inE;
        localObject2 = b.aPA();
        if (localObject2 == null) {
          p.hyc();
        }
      }
      for (localObject1 = ((CameraManager)localObject1).getCameraCharacteristics((String)localObject2);; localObject1 = null)
      {
        this.inL = ((CameraCharacteristics)localObject1);
        localObject1 = b.inE;
        localObject1 = b.aPG();
        AppMethodBeat.o(218851);
        return localObject1;
      }
      return null;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(218851);
    }
  }
  
  protected void aPp()
  {
    AppMethodBeat.i(94136);
    Object localObject1 = com.tencent.mm.plugin.mmsight.model.a.l.ekc();
    p.g(localObject1, "MMSightController.getInstance()");
    if (((com.tencent.mm.plugin.mmsight.model.a.l)localObject1).ekd() != null)
    {
      localObject1 = com.tencent.mm.plugin.mmsight.model.a.l.ekc();
      p.g(localObject1, "MMSightController.getInstance()");
    }
    for (Object localObject2 = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.a.l)localObject1).ekd().zsR);; localObject2 = Integer.valueOf(0))
    {
      Object localObject3 = this.gVB;
      boolean bool1;
      label86:
      boolean bool2;
      label98:
      boolean bool3;
      label111:
      boolean bool4;
      if (ae.gKt.gFU == 1)
      {
        localObject1 = "Range";
        if (ae.gKt.gFV != 1) {
          break label776;
        }
        bool1 = true;
        if (ae.gKt.gFW != 1) {
          break label781;
        }
        bool2 = true;
        if (ae.gKt.gFX != 1) {
          break label786;
        }
        bool3 = true;
        if (ae.gKt.gFY != 1) {
          break label792;
        }
        bool4 = true;
        label124:
        Log.i((String)localObject3, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localObject2, localObject1, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
        if ((ae.gKt.gFU != 1) || ((((Integer)localObject2).intValue() != 0) && (((Integer)localObject2).intValue() != 1))) {
          break label798;
        }
        bool1 = false;
      }
      for (;;)
      {
        label206:
        bool2 = bool1;
        if (this.ilS != null)
        {
          localObject1 = this.ilS;
          if (localObject1 == null) {
            break label830;
          }
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.d.b.a)localObject1).irc;
          label233:
          bool2 = bool1;
          if (localObject1 != null)
          {
            localObject1 = this.ilS;
            if (localObject1 == null) {
              break label836;
            }
            localObject1 = ((com.tencent.mm.media.widget.camerarecordview.d.b.a)localObject1).irc;
            if (localObject1 == null) {
              break label836;
            }
            localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(aPu()));
            label280:
            bool2 = bool1;
            if (localObject1 != null)
            {
              localObject1 = this.ilS;
              bool2 = bool1;
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.media.widget.camerarecordview.d.b.a)localObject1).irc;
                bool2 = bool1;
                if (localObject1 != null)
                {
                  localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(aPu()));
                  bool2 = bool1;
                  if (localObject1 != null)
                  {
                    localObject3 = ((b.a.c)localObject1).iri;
                    if (localObject3 != null) {
                      this.imx = ((Number)localObject3).intValue();
                    }
                    localObject1 = ((b.a.c)localObject1).irj;
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
        a(this.inL, bool2);
        if ((ae.gKt.gFV == 1) && (((Integer)localObject2).intValue() != 0)) {
          ((Integer)localObject2).intValue();
        }
        if ((ae.gKA.gIX != -1) && (ae.gKA.gIX == 1) && (d.oF(14))) {
          b(this.inL);
        }
        if ((ae.gKt.gFX == 1) && ((((Integer)localObject2).intValue() == 0) || (((Integer)localObject2).intValue() == 4))) {
          a(this.inL);
        }
        if ((ae.gKt.gFY == 1) && (((Integer)localObject2).intValue() != 0)) {
          ((Integer)localObject2).intValue();
        }
        localObject1 = this.inL;
        label665:
        if (localObject1 != null)
        {
          localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
          label537:
          if (localObject1 != null)
          {
            localObject1 = new Rect(((Rect)localObject1).left * 1, ((Rect)localObject1).top * 1, ((Rect)localObject1).right * 1, ((Rect)localObject1).bottom * 1);
            localObject2 = this.inI;
            if (localObject2 != null) {
              ((CaptureRequest.Builder)localObject2).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
            }
          }
          localObject1 = this.inL;
          if (localObject1 == null) {
            break label848;
          }
          localObject1 = (int[])((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
          label624:
          if (localObject1 != null)
          {
            Log.i(this.gVB, "oisMode:" + Arrays.toString((int[])localObject1));
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
          if ((i != 0) && (kotlin.a.e.contains((int[])localObject1, 1)))
          {
            localObject1 = com.tencent.mm.media.widget.d.a.itg;
            com.tencent.mm.media.widget.d.a.aRj();
            localObject1 = b.inE;
            b.ff(false);
            localObject1 = this.inI;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(1));
            }
          }
          localObject1 = this.inI;
          if (localObject1 == null) {
            p.hyc();
          }
          h((CaptureRequest.Builder)localObject1);
          AppMethodBeat.o(94136);
          return;
          if (ae.gKt.gFT == 1)
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
          if ((ae.gKt.gFT != 1) || ((((Integer)localObject2).intValue() != 0) && (((Integer)localObject2).intValue() != 5))) {
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
  
  public void aPq()
  {
    AppMethodBeat.i(94138);
    if (!aPc())
    {
      AppMethodBeat.o(94138);
      return;
    }
    com.tencent.mm.media.widget.a.a.a locala = this.ilK;
    com.tencent.mm.media.widget.a.a.a.a locala1 = com.tencent.mm.media.widget.a.a.a.imU;
    locala.removeMessages(com.tencent.mm.media.widget.a.a.a.aPz());
    AppMethodBeat.o(94138);
  }
  
  public com.tencent.mm.media.widget.a.b aPr()
  {
    boolean bool = true;
    AppMethodBeat.i(94143);
    Log.printInfoStack(this.gVB, "generateCameraConfig", new Object[0]);
    if (this.inH == null)
    {
      Log.i(this.gVB, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94143);
      return null;
    }
    if (!aPc())
    {
      Log.i(this.gVB, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94143);
      return null;
    }
    Object localObject = com.tencent.mm.media.widget.a.b.imh;
    com.tencent.mm.media.widget.a.b.rs(getPreviewWidth());
    localObject = com.tencent.mm.media.widget.a.b.imh;
    com.tencent.mm.media.widget.a.b.rr(getPreviewHeight());
    localObject = this.inL;
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
        localObject = com.tencent.mm.media.widget.a.b.imh;
        com.tencent.mm.media.widget.a.b.ru(this.ilR.sUz);
        localObject = com.tencent.mm.media.widget.a.b.imh;
        com.tencent.mm.media.widget.a.b.rv(this.ilR.sUA);
        if (i != 0)
        {
          localObject = com.tencent.mm.media.widget.a.b.imh;
          i = com.tencent.mm.media.widget.a.b.aPl();
          localObject = com.tencent.mm.media.widget.a.b.imh;
          localObject = com.tencent.mm.media.widget.a.b.imh;
          com.tencent.mm.media.widget.a.b.ru(com.tencent.mm.media.widget.a.b.aPm());
          localObject = com.tencent.mm.media.widget.a.b.imh;
          com.tencent.mm.media.widget.a.b.rv(i);
        }
        localObject = com.tencent.mm.media.widget.a.b.imh;
        com.tencent.mm.media.widget.a.b.rt(getOrientation());
        localObject = com.tencent.mm.media.widget.a.b.imh;
        if (this.ilM) {
          break label282;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.media.widget.a.b.setFrontCamera(bool);
      localObject = com.tencent.mm.media.widget.a.b.imh;
      com.tencent.mm.media.widget.a.b.eZ(this.ilO);
      localObject = this.hAu;
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
  
  public final int aPu()
  {
    AppMethodBeat.i(94162);
    b localb = b.inE;
    if (b.aPB())
    {
      AppMethodBeat.o(94162);
      return 0;
    }
    AppMethodBeat.o(94162);
    return 1;
  }
  
  public final int aPv()
  {
    AppMethodBeat.i(94163);
    b localb = b.inE;
    int i = b.aPD();
    AppMethodBeat.o(94163);
    return i;
  }
  
  public final String aPw()
  {
    AppMethodBeat.i(218855);
    Object localObject = this.inK;
    if (localObject == null) {
      p.btv("previewRequest");
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
      localObject = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
      localObject = b.b.aQC();
      AppMethodBeat.o(218855);
      return localObject;
      localObject = null;
      break;
      if (((Integer)localObject).intValue() != 1) {
        break label40;
      }
      localObject = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
      localObject = b.b.aQC();
      AppMethodBeat.o(218855);
      return localObject;
      if (((Integer)localObject).intValue() != 4) {
        break label44;
      }
      localObject = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
      localObject = b.b.aQB();
      AppMethodBeat.o(218855);
      return localObject;
    }
    localObject = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
    localObject = b.b.aQA();
    AppMethodBeat.o(218855);
    return localObject;
  }
  
  public final boolean aPx()
  {
    AppMethodBeat.i(218854);
    try
    {
      CaptureRequest.Builder localBuilder = this.inI;
      if (localBuilder != null) {
        localBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      localBuilder = this.inI;
      if (localBuilder != null) {
        localBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
      }
      AppMethodBeat.o(218854);
      return true;
    }
    catch (Exception localException)
    {
      Log.i(this.gVB, "triggerAutoFocus failed");
      AppMethodBeat.o(218854);
    }
    return false;
  }
  
  public final void ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(94160);
    p.h(paramString, "tag");
    Object localObject = b.inE;
    localObject = this.inI;
    if (localObject == null) {
      p.hyc();
    }
    b.a((CaptureRequest.Builder)localObject, paramString, paramInt);
    aPM();
    AppMethodBeat.o(94160);
  }
  
  public void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94137);
    if (d.oE(14))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if ((this.inH == null) || (this.inJ == null))
    {
      AppMethodBeat.o(94137);
      return;
    }
    if (!aPc())
    {
      AppMethodBeat.o(94137);
      return;
    }
    com.tencent.mm.media.widget.a.a.a locala = this.ilK;
    Object localObject = com.tencent.mm.media.widget.a.a.a.imU;
    locala.removeMessages(com.tencent.mm.media.widget.a.a.a.aPz());
    this.ilK.gZZ = paramFloat1;
    this.ilK.haa = paramFloat2;
    this.ilK.imO = paramInt1;
    this.ilK.imP = paramInt2;
    locala = this.ilK;
    localObject = this.ilK;
    com.tencent.mm.media.widget.a.a.a.a locala1 = com.tencent.mm.media.widget.a.a.a.imU;
    locala.sendMessageDelayed(((com.tencent.mm.media.widget.a.a.a)localObject).obtainMessage(com.tencent.mm.media.widget.a.a.a.aPz()), 400L);
    AppMethodBeat.o(94137);
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    CaptureRequest.Builder localBuilder = null;
    AppMethodBeat.i(94132);
    long l = Util.currentTicks();
    Log.i(this.gVB, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (aPc())
    {
      Log.i(this.gVB, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94132);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.inN) {
          continue;
        }
        localCameraDevice = this.inH;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(3);
        }
        this.inI = localBuilder;
        rq(paramInt);
        aPp();
        if (a(paramSurfaceTexture, paramSurfaceHolder))
        {
          a(com.tencent.mm.media.widget.a.a.a.ima);
          this.state = 0;
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        CameraDevice localCameraDevice;
        Log.e(this.gVB, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNm();
        continue;
      }
      Log.i(this.gVB, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(94132);
      return;
      localCameraDevice = this.inH;
      if (localCameraDevice != null) {
        localBuilder = localCameraDevice.createCaptureRequest(1);
      }
    }
  }
  
  public final void b(g paramg) {}
  
  public final boolean b(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(218860);
    p.h(paramRect1, "focusArea");
    p.h(paramRect2, "meteringArea");
    Log.i(this.gVB, "focus on area :: focus rect %s, meter rect %s", new Object[] { paramRect1, paramRect2 });
    if (aPc())
    {
      Log.i(this.inF, "a focus action happened");
      CaptureRequest.Builder localBuilder = this.inI;
      if (localBuilder != null) {
        localBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[] { new MeteringRectangle(paramRect1, 200) });
      }
      paramRect1 = this.inI;
      if (paramRect1 != null) {
        paramRect1.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[] { new MeteringRectangle(paramRect2, 360) });
      }
      paramRect1 = this.inI;
      if (paramRect1 != null) {
        paramRect1.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
      }
      paramRect1 = this.inI;
      if (paramRect1 != null) {
        paramRect1.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      paramRect1 = this.inI;
      if (paramRect1 != null) {
        paramRect1.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
      }
    }
    try
    {
      if (!this.inM)
      {
        Log.i(this.inF, "params set and try focus");
        paramRect1 = this.inJ;
        if (paramRect1 != null)
        {
          paramRect2 = this.inI;
          if (paramRect2 == null) {
            p.hyc();
          }
          paramRect1.setRepeatingRequest(paramRect2.build(), this.inT, this.ilK.imK);
        }
        this.state = 5;
        AppMethodBeat.o(218860);
        return true;
      }
      Log.i(this.inF, "something happened casue focus no request");
      Log.e(this.gVB, "this has been camera session close");
      AppMethodBeat.o(218860);
      return false;
    }
    catch (CameraAccessException paramRect1)
    {
      Log.e(this.gVB, "setRepeatingRequest failed, ");
      AppMethodBeat.o(218860);
    }
    return false;
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
      Log.i(this.gVB, "safeSetMetering");
      Rect localRect = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
      MeteringRectangle[] arrayOfMeteringRectangle = new MeteringRectangle[1];
      if (localRect != null) {}
      for (paramCameraCharacteristics = Integer.valueOf(localRect.right);; paramCameraCharacteristics = null)
      {
        if (paramCameraCharacteristics == null) {
          p.hyc();
        }
        arrayOfMeteringRectangle[0] = new MeteringRectangle(paramCameraCharacteristics.intValue() / 2 - 500, localRect.bottom / 2 - 500, 1000, 1000, 0);
        paramCameraCharacteristics = this.inI;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.inI;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_REGIONS, arrayOfMeteringRectangle);
        }
        paramCameraCharacteristics = this.inI;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        }
        paramCameraCharacteristics = this.inI;
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
      Log.i(this.gVB, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
      AppMethodBeat.o(94153);
    }
  }
  
  public final int df(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(218858);
    paramInt1 = i;
    switch (paramInt2)
    {
    default: 
      paramInt1 = i;
    }
    while (!this.ilM)
    {
      localb = b.inE;
      paramInt2 = b.aPD();
      AppMethodBeat.o(218858);
      return (360 - (paramInt1 + paramInt2) % 360) % 360;
      paramInt1 = 90;
      continue;
      paramInt1 = 180;
      continue;
      paramInt1 = 270;
    }
    b localb = b.inE;
    paramInt2 = b.aPD();
    AppMethodBeat.o(218858);
    return (paramInt2 - paramInt1 + 360) % 360;
  }
  
  public final boolean dg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218852);
    try
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      if (localSurfaceTexture == null) {
        p.hyc();
      }
      localSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
      AppMethodBeat.o(218852);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(218852);
    }
    return false;
  }
  
  public Point fa(boolean paramBoolean)
  {
    AppMethodBeat.i(94146);
    if (!paramBoolean)
    {
      localPoint = new Point(this.ilR.sUz, this.ilR.sUA);
      AppMethodBeat.o(94146);
      return localPoint;
    }
    if (this.ilV != null)
    {
      localPoint = this.ilV;
      if (localPoint == null) {
        p.hyc();
      }
      AppMethodBeat.o(94146);
      return localPoint;
    }
    Point localPoint = new Point(this.ilR.sUz, this.ilR.sUA);
    AppMethodBeat.o(94146);
    return localPoint;
  }
  
  public final void fb(boolean paramBoolean)
  {
    AppMethodBeat.i(94164);
    Object localObject = b.inE;
    localObject = this.inI;
    if (localObject == null) {
      p.hyc();
    }
    b.a(paramBoolean, (CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94164);
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(94165);
    Object localObject = b.inE;
    localObject = this.inI;
    if (localObject == null) {
      p.hyc();
    }
    int i = b.a((CaptureRequest.Builder)localObject);
    AppMethodBeat.o(94165);
    return i;
  }
  
  protected final int getOrientation()
  {
    AppMethodBeat.i(218848);
    if (aPc())
    {
      b localb = b.inE;
      int i = b.aPD();
      AppMethodBeat.o(218848);
      return i;
    }
    AppMethodBeat.o(218848);
    return -1;
  }
  
  protected int getPreviewHeight()
  {
    AppMethodBeat.i(94144);
    if (this.inH == null)
    {
      AppMethodBeat.o(94144);
      return 0;
    }
    try
    {
      if ((this.ilO) && (this.ilV != null))
      {
        Point localPoint = this.ilV;
        if (localPoint == null) {
          p.hyc();
        }
        i = localPoint.y;
        AppMethodBeat.o(94144);
        return i;
      }
      int i = this.ilR.sUA;
      AppMethodBeat.o(94144);
      return i;
    }
    catch (Exception localException)
    {
      Log.e(this.gVB, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94144);
    }
    return 0;
  }
  
  protected int getPreviewWidth()
  {
    AppMethodBeat.i(94145);
    if (this.inH == null)
    {
      AppMethodBeat.o(94145);
      return 0;
    }
    if (this.inc != null) {
      try
      {
        if ((this.ilO) && (this.ilV != null))
        {
          Point localPoint = this.ilV;
          if (localPoint == null) {
            p.hyc();
          }
          i = localPoint.x;
          AppMethodBeat.o(94145);
          return i;
        }
        int i = this.ilR.sUz;
        AppMethodBeat.o(94145);
        return i;
      }
      catch (Exception localException)
      {
        Log.e(this.gVB, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94145);
    return 0;
  }
  
  public final float[] getSupportZoomRatios()
  {
    AppMethodBeat.i(94141);
    if ((this.inQ == null) && (this.inL != null))
    {
      localObject = this.inL;
      if (localObject == null) {
        p.hyc();
      }
      Float localFloat = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      localObject = localFloat;
      if (localFloat == null) {
        localObject = Float.valueOf(0.0F);
      }
      p.g(localObject, "mCharacteristics!!.get(C…_MAX_DIGITAL_ZOOM)?: 0.0f");
      float f = (int)(((Float)localObject).floatValue() * 10.0F) * 1.0F / 10.0F;
      this.inQ = new float[(int)(f * 10.0F)];
      int i = 0;
      int j = (int)(f * 10.0F);
      while (i < j)
      {
        localObject = this.inQ;
        if (localObject == null) {
          p.hyc();
        }
        localObject[i] = (i * 1.0F / 10.0F + 1.0F);
        i += 1;
      }
    }
    Object localObject = this.inQ;
    AppMethodBeat.o(94141);
    return localObject;
  }
  
  public void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94140);
    if ((this.inH != null) && (aPc())) {}
    for (;;)
    {
      float f2;
      try
      {
        Log.d(this.gVB, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (this.aYc)
        {
          Log.d(this.gVB, "triggerSmallZoom, zooming, ignore");
          return;
        }
        this.aYc = true;
        localObject1 = this.inI;
        if (localObject1 != null)
        {
          localObject3 = (Rect)((CaptureRequest.Builder)localObject1).get(CaptureRequest.SCALER_CROP_REGION);
          localObject1 = this.inL;
          if (localObject1 != null)
          {
            localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            if (localObject1 == null) {
              p.hyc();
            }
            f1 = ((Rect)localObject1).width();
            if (localObject3 == null) {
              p.hyc();
            }
            f2 = f1 / ((Rect)localObject3).width();
            localObject3 = this.inL;
            if (localObject3 == null) {
              p.hyc();
            }
            Float localFloat = (Float)((CameraCharacteristics)localObject3).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            localObject3 = localFloat;
            if (localFloat == null) {
              localObject3 = Float.valueOf(0.0F);
            }
            p.g(localObject3, "mCharacteristics!!.get(C…_MAX_DIGITAL_ZOOM)?: 0.0f");
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
        f2 = this.imi + f2;
        if (f2 < f1) {
          break label552;
        }
        Log.d(this.gVB, "triggerSmallZoom, nextZoom: %s", new Object[] { Float.valueOf(f1) });
        f2 = ((Rect)localObject1).width() / f1;
        f1 = ((Rect)localObject1).height() / f1;
        float f3 = (((Rect)localObject1).width() - f2) / 2.0F;
        float f4 = (((Rect)localObject1).height() - f1) / 2.0F;
        localObject1 = new Rect((int)f3, (int)f4, (int)(f2 + f3), (int)(f1 + f4));
        localObject3 = this.inI;
        if (localObject3 != null) {
          ((CaptureRequest.Builder)localObject3).set(CaptureRequest.SCALER_CROP_REGION, localObject1);
        }
        paramBoolean = this.inM;
        if (paramBoolean) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        Log.e(this.gVB, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYc = false;
        AppMethodBeat.o(94140);
      }
      try
      {
        localObject1 = this.inJ;
        if (localObject1 != null)
        {
          localObject3 = this.inI;
          if (localObject3 == null) {
            p.hyc();
          }
          ((CameraCaptureSession)localObject1).setRepeatingRequest(((CaptureRequest.Builder)localObject3).build(), this.inT, this.ilK.imK);
        }
      }
      catch (CameraAccessException localCameraAccessException)
      {
        continue;
      }
      this.aYc = false;
      AppMethodBeat.o(94140);
      return;
      if (f2 == 1.0F)
      {
        this.aYc = false;
        AppMethodBeat.o(94140);
        return;
      }
      float f1 = this.imi;
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
  
  public final boolean n(kotlin.g.a.b<? super Bitmap, kotlin.x> paramb)
  {
    com.tencent.mm.media.widget.d.a locala2 = null;
    AppMethodBeat.i(94157);
    p.h(paramb, "dataCallback");
    Log.i(this.gVB, "takePhoto");
    a(com.tencent.mm.media.widget.a.a.a.imb);
    Object localObject1 = b.inE;
    localObject1 = b.aPA();
    Object localObject2 = b.inE;
    if (p.j(localObject1, b.ry(b.ind)))
    {
      localObject1 = com.tencent.mm.media.widget.d.a.itg;
      com.tencent.mm.media.widget.d.a.aRg();
      for (;;)
      {
        try
        {
          if (this.state != 0)
          {
            a(this.inL);
            localObject1 = this.inI;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
            }
            localObject1 = this.inI;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
            }
            localObject1 = this.inI;
            if (localObject1 != null) {
              ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
            }
            localObject1 = this.inI;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((CaptureRequest.Builder)localObject1).build();
            if (localObject1 == null) {
              p.hyc();
            }
            this.inK = ((CaptureRequest)localObject1);
            boolean bool = this.inM;
            if (bool) {}
          }
        }
        catch (Exception localException)
        {
          CaptureRequest.Builder localBuilder;
          locala2 = com.tencent.mm.media.widget.d.a.itg;
          com.tencent.mm.media.widget.d.a.aRh();
          Log.printInfoStack(this.gVB, "take photo in back camera error", new Object[] { localException });
          continue;
          locala1 = null;
          continue;
        }
        try
        {
          localObject1 = this.inJ;
          if (localObject1 != null)
          {
            localObject2 = this.inK;
            if (localObject2 == null) {
              p.btv("previewRequest");
            }
            ((CameraCaptureSession)localObject1).setRepeatingRequest((CaptureRequest)localObject2, this.inT, this.ilK.imK);
          }
        }
        catch (CameraAccessException localCameraAccessException)
        {
          Log.e(this.gVB, "setRepeatingRequest failed, errMsg: ");
        }
      }
      this.state = 0;
      this.ilK.removeCallbacksAndMessages(null);
      localObject1 = this.inI;
      if (localObject1 != null) {
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      }
      this.state = 1;
      if (!this.inM)
      {
        localObject1 = this.inI;
        if (localObject1 == null) {
          break label405;
        }
        localObject1 = ((CaptureRequest.Builder)localObject1).build();
        if (localObject1 != null)
        {
          localObject2 = this.inJ;
          if (localObject2 != null)
          {
            localBuilder = this.inI;
            localObject1 = locala2;
            if (localBuilder != null) {
              localObject1 = localBuilder.build();
            }
            if (localObject1 == null) {
              p.hyc();
            }
            ((CameraCaptureSession)localObject2).capture((CaptureRequest)localObject1, this.inT, this.ilK.imK);
          }
        }
      }
    }
    for (;;)
    {
      this.ilK.imM = paramb;
      AppMethodBeat.o(94157);
      return true;
      localObject1 = null;
      break;
      label405:
      com.tencent.mm.media.widget.d.a locala1 = com.tencent.mm.media.widget.d.a.itg;
      com.tencent.mm.media.widget.d.a.aRf();
      aPL();
    }
  }
  
  public final void o(kotlin.g.a.b<? super Boolean, kotlin.x> paramb)
  {
    AppMethodBeat.i(94133);
    this.imw = paramb;
    b localb = b.inE;
    b.o(paramb);
    AppMethodBeat.o(94133);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94155);
    super.release();
    if (this.inH != null)
    {
      long l = Util.currentTicks();
      Log.i(this.gVB, "release camera beg, %s", new Object[] { Looper.myLooper() });
      this.ilK.removeCallbacksAndMessages(null);
      aPK();
      localObject = this.mSurface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      Log.i(this.gVB, "release camera end, use %dms, %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
    }
    this.ilV = null;
    this.ilY = false;
    Object localObject = com.tencent.mm.media.widget.d.a.itg;
    com.tencent.mm.media.widget.d.a.aRe();
    AppMethodBeat.o(94155);
  }
  
  public final boolean rp(int paramInt)
  {
    AppMethodBeat.i(218857);
    try
    {
      Object localObject = this.inJ;
      if (localObject != null) {}
      for (localObject = ((CameraCaptureSession)localObject).getDevice();; localObject = null)
      {
        if (localObject != null) {}
        AppMethodBeat.o(218857);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.e(this.gVB, "open scene " + paramInt + " open failed, error:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(218857);
    }
  }
  
  public final boolean rq(int paramInt)
  {
    AppMethodBeat.i(94154);
    try
    {
      super.rq(paramInt);
      boolean bool = aPh();
      Point localPoint = aPj();
      Object localObject1 = b.inE;
      Object localObject2 = h.b(b.aPH(), localPoint, paramInt, bool);
      localObject1 = localObject2;
      if (((h.c)localObject2).zum == null)
      {
        localObject1 = new Point(Math.min(aPj().x, aPj().y), Math.max(aPj().x, aPj().y));
        localObject2 = b.inE;
        localObject1 = h.a(b.aPH(), (Point)localObject1, this.ilI, bool);
      }
      if (((h.c)localObject1).zum == null)
      {
        localObject2 = com.tencent.mm.media.widget.d.a.itg;
        com.tencent.mm.media.widget.d.a.aRk();
        Log.i(this.gVB, "checkMore start %s", new Object[] { ((h.c)localObject1).toString() });
        ((h.c)localObject1).zum = ((h.c)localObject1).zup;
        ((h.c)localObject1).zun = ((h.c)localObject1).zuq;
        ((h.c)localObject1).zuo = ((h.c)localObject1).zur;
      }
      localObject2 = b.inE;
      b.d(localPoint);
      localObject1 = new Size(((h.c)localObject1).zum.x, ((h.c)localObject1).zum.y);
      paramInt = ((Size)localObject1).getWidth();
      int i = ((Size)localObject1).getHeight();
      localObject1 = b.inE;
      localObject1 = ImageReader.newInstance(paramInt, i, b.aPC(), 1);
      ((ImageReader)localObject1).setOnImageAvailableListener(this.ilK.imS, this.ilK.imK);
      this.hiC = ((ImageReader)localObject1);
      AppMethodBeat.o(94154);
      return true;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      Log.printErrStackTrace(this.gVB, (Throwable)localCameraAccessException, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", new Object[] { Looper.myLooper(), localCameraAccessException.getMessage() });
      AppMethodBeat.o(94154);
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.gVB, (Throwable)localException, "selectNoCropPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
      AppMethodBeat.o(94154);
    }
    return false;
  }
  
  public final void rw(int paramInt)
  {
    AppMethodBeat.i(94139);
    if (this.ilW > 0)
    {
      AppMethodBeat.o(94139);
      return;
    }
    Object localObject = ao.az(MMApplicationContext.getContext());
    int i = ((Point)localObject).y;
    Log.i(this.gVB, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94139);
      return;
    }
    try
    {
      localObject = this.inL;
      if (localObject == null) {
        p.hyc();
      }
      Float localFloat = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
      localObject = localFloat;
      if (localFloat == null) {
        localObject = Float.valueOf(0.0F);
      }
      p.g(localObject, "mCharacteristics!!.get(C…_MAX_DIGITAL_ZOOM)?: 0.0f");
      float f = ((Float)localObject).floatValue();
      double d = f / (paramInt / 3.0D / 10.0D);
      if (d > 0.0D) {
        this.ilW = ((int)d + 1);
      }
      Log.i(this.gVB, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.ilW), Float.valueOf(f) });
      AppMethodBeat.o(94139);
      return;
    }
    catch (Exception localException)
    {
      Log.e(this.gVB, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94139);
    }
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(94166);
    CaptureRequest.Builder localBuilder = this.inI;
    if (localBuilder != null)
    {
      Object localObject = b.inE;
      p.h(localBuilder, "builder");
      switch (paramInt)
      {
      }
      label142:
      for (;;)
      {
        AppMethodBeat.o(94166);
        return;
        b.a(false, localBuilder);
        AppMethodBeat.o(94166);
        return;
        b.a(true, localBuilder);
        AppMethodBeat.o(94166);
        return;
        localObject = b.inc;
        if (localObject != null)
        {
          localObject = ((CameraManager)localObject).getCameraCharacteristics(String.valueOf(b.inn));
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
    if (this.aYc)
    {
      Log.d(this.gVB, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94142);
      return;
    }
    if ((this.inL != null) && (this.inI != null)) {
      try
      {
        localObject1 = this.inL;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = (Rect)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (localObject1 == null) {
          p.hyc();
        }
        int i = ((Rect)localObject1).width() - kotlin.h.a.cR(((Rect)localObject1).width() / paramFloat);
        int j = ((Rect)localObject1).height() - kotlin.h.a.cR(((Rect)localObject1).height() / paramFloat);
        this.inP = new Rect(i / 2, j / 2, ((Rect)localObject1).width() - i / 2, ((Rect)localObject1).height() - j / 2);
        localObject1 = this.inI;
        if (localObject1 == null) {
          p.hyc();
        }
        ((CaptureRequest.Builder)localObject1).set(CaptureRequest.SCALER_CROP_REGION, this.inP);
        boolean bool = this.inM;
        if (bool) {}
      }
      catch (Exception localException)
      {
        Object localObject1;
        label234:
        Log.e(this.gVB, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYc = false;
        AppMethodBeat.o(94142);
      }
    }
    try
    {
      localObject1 = this.inJ;
      if (localObject1 != null)
      {
        CaptureRequest.Builder localBuilder = this.inI;
        if (localBuilder == null) {
          p.hyc();
        }
        ((CameraCaptureSession)localObject1).setRepeatingRequest(localBuilder.build(), this.inT, this.ilK.imK);
      }
    }
    catch (CameraAccessException localCameraAccessException)
    {
      break label234;
    }
    this.aYc = false;
    AppMethodBeat.o(94142);
    return;
    AppMethodBeat.o(94142);
  }
  
  public final boolean v(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94128);
    p.h(paramContext, "context");
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
      Log.printErrStackTrace(this.gVB, (Throwable)paramContext, "init camera failed!", new Object[0]);
      paramContext = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNm();
      AppMethodBeat.o(94128);
      return false;
    }
    this.inc = ((CameraManager)localObject);
    Object localObject = b.inE;
    b.a(this.inc);
    if (this.ilY)
    {
      Log.i(this.gVB, "initCamera, already open");
      AppMethodBeat.o(94128);
      return true;
    }
    localObject = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aNk();
    super.v(paramContext, paramBoolean);
    release();
    aPK();
    if (paramBoolean) {
      paramContext = b.inE;
    }
    for (paramContext = b.ry(b.ind);; paramContext = b.ry(b.ine))
    {
      Log.printInfoStack(this.gVB, "use camera id %s, SrvDeviceInfo id %d", new Object[] { paramContext, Integer.valueOf(ae.gKt.gGa) });
      localObject = com.tencent.mm.media.widget.d.a.itg;
      com.tencent.mm.media.widget.d.a.aRb();
      localObject = this.context;
      if (localObject == null) {
        p.hyc();
      }
      if (Util.checkPermission((Context)localObject, "android.permission.CAMERA")) {
        break;
      }
      Log.e(this.gVB, "it was lack of the camera permision to open camera");
      AppMethodBeat.o(94128);
      return true;
      paramContext = b.inE;
    }
    try
    {
      if (!this.inG.tryAcquire(2500L, TimeUnit.MILLISECONDS))
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
      localObject = this.inc;
      if (localObject == null) {
        p.hyc();
      }
      ((CameraManager)localObject).openCamera(paramContext, (CameraDevice.StateCallback)this.inS, this.ilK.imK);
    }
    catch (CameraAccessException localCameraAccessException)
    {
      label348:
      break label348;
    }
    localObject = b.inE;
    b.inn = paramContext;
    if (paramContext == null) {
      p.hyc();
    }
    p.h(paramContext, "id");
    localObject = b.inc;
    if (localObject != null) {}
    for (paramContext = ((CameraManager)localObject).getCameraCharacteristics(paramContext);; paramContext = null)
    {
      if (paramContext == null) {
        p.hyc();
      }
      paramContext = paramContext.get(CameraCharacteristics.SENSOR_ORIENTATION);
      if (paramContext == null) {
        p.hyc();
      }
      b.inp = ((Number)paramContext).intValue();
      break;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/widget/camera2/CommonCamera2$captureStillPicture$2$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "onCaptureCompleted", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "result", "Landroid/hardware/camera2/TotalCaptureResult;", "plugin-mediaeditor_release"})
  public static final class b
    extends CameraCaptureSession.CaptureCallback
  {
    b(c paramc) {}
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(94118);
      p.h(paramCameraCaptureSession, "session");
      p.h(paramCaptureRequest, "request");
      p.h(paramTotalCaptureResult, "result");
      paramCameraCaptureSession = b.inE;
      paramCameraCaptureSession = this.inX.inI;
      if (paramCameraCaptureSession == null) {
        p.hyc();
      }
      b.g(paramCameraCaptureSession);
      AppMethodBeat.o(94118);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCameraDeviceCallback$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onDisconnected", "", "camera", "Landroid/hardware/camera2/CameraDevice;", "onError", "error", "", "onOpened", "plugin-mediaeditor_release"})
  public static final class c
    extends CameraDevice.StateCallback
  {
    public final void onDisconnected(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(94120);
      p.h(paramCameraDevice, "camera");
      this.inX.inG.release();
      paramCameraDevice.close();
      this.inX.inH = null;
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
      this.inX.inG.release();
      this.inX.inH = paramCameraDevice;
      AppMethodBeat.o(94119);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/widget/camera2/CommonCamera2$mCaptureCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "capturePicture", "", "result", "Landroid/hardware/camera2/CaptureResult;", "checkFocusEnd", "", "onCaptureCompleted", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "request", "Landroid/hardware/camera2/CaptureRequest;", "Landroid/hardware/camera2/TotalCaptureResult;", "onCaptureProgressed", "partialResult", "process", "plugin-mediaeditor_release"})
  public static final class d
    extends CameraCaptureSession.CaptureCallback
  {
    private final void b(CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(94122);
      switch (this.inX.state)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94122);
        return;
        Object localObject = b.inE;
        b.a(paramCaptureResult);
        AppMethodBeat.o(94122);
        return;
        localObject = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if ((localObject == null) || (2 == ((Integer)localObject).intValue()) || (6 == ((Integer)localObject).intValue()))
        {
          c.c(this.inX);
          AppMethodBeat.o(94122);
          return;
        }
        if ((4 == ((Integer)localObject).intValue()) || (5 == ((Integer)localObject).intValue()))
        {
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 2))
          {
            c.c(this.inX);
            AppMethodBeat.o(94122);
            return;
          }
          c.d(this.inX);
        }
        AppMethodBeat.o(94122);
        return;
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 5) || (paramCaptureResult.intValue() == 4))
        {
          this.inX.state = 3;
          AppMethodBeat.o(94122);
          return;
          paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if ((paramCaptureResult == null) || (paramCaptureResult.intValue() != 5))
          {
            c.c(this.inX);
            AppMethodBeat.o(94122);
            return;
            if (this.inX.aPc())
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
                if ((i == 0) || (this.inX.inM)) {
                  break label534;
                }
                Log.i(this.inX.inF, "STATE_TOUCH_CAF_WAITING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
                this.inX.a(this.inX.inL);
                paramCaptureResult = this.inX.inI;
                if (paramCaptureResult != null) {
                  paramCaptureResult.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                }
                localObject = this.inX;
                paramCaptureResult = this.inX.inI;
                if (paramCaptureResult == null) {
                  break label513;
                }
              }
              label513:
              for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
              {
                if (paramCaptureResult == null) {
                  p.hyc();
                }
                ((c)localObject).a(paramCaptureResult);
                try
                {
                  paramCaptureResult = this.inX.inJ;
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(this.inX.aPJ(), (CameraCaptureSession.CaptureCallback)this, c.e(this.inX).imK);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    Log.e(c.a(this.inX), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                this.inX.state = 6;
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
            Log.e(c.a(this.inX), "current is not allowed to do anything casue capturing");
            AppMethodBeat.o(94122);
            return;
            if ((this.inX.aPc()) && (!this.inX.inM))
            {
              Log.i(this.inX.inF, "STATE_TOUCH_FOCUSING and state is  " + (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE));
              paramCaptureResult = this.inX.inI;
              if (paramCaptureResult != null) {
                paramCaptureResult.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
              }
              paramCaptureResult = this.inX.inI;
              if (paramCaptureResult != null) {
                paramCaptureResult.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
              }
              localObject = this.inX;
              paramCaptureResult = this.inX.inI;
              if (paramCaptureResult != null) {}
              for (paramCaptureResult = paramCaptureResult.build();; paramCaptureResult = null)
              {
                if (paramCaptureResult == null) {
                  p.hyc();
                }
                ((c)localObject).a(paramCaptureResult);
                try
                {
                  paramCaptureResult = this.inX.inJ;
                  if (paramCaptureResult != null) {
                    paramCaptureResult.setRepeatingRequest(this.inX.aPJ(), (CameraCaptureSession.CaptureCallback)this, c.e(this.inX).imK);
                  }
                }
                catch (CameraAccessException paramCaptureResult)
                {
                  for (;;)
                  {
                    Log.e(c.a(this.inX), "setRepeatingRequest failed, errMsg: ");
                  }
                }
                c.e(this.inX).imQ = true;
                this.inX.state = 0;
                AppMethodBeat.o(94122);
                return;
              }
            }
            Log.e(c.a(this.inX), "current is not allowed to do anything casue capturing");
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/widget/camera2/CommonCamera2$mStateCallback$1", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onClosed", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigureFailed", "onConfigured", "plugin-mediaeditor_release"})
  public static final class e
    extends CameraCaptureSession.StateCallback
  {
    public final void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94127);
      p.h(paramCameraCaptureSession, "session");
      super.onClosed(paramCameraCaptureSession);
      Log.i(c.a(this.inX), "session on close");
      this.inX.inM = true;
      AppMethodBeat.o(94127);
    }
    
    public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94126);
      p.h(paramCameraCaptureSession, "session");
      Log.i(c.a(this.inX), "configure failed ");
      paramCameraCaptureSession = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNm();
      paramCameraCaptureSession = com.tencent.mm.media.widget.d.a.itg;
      com.tencent.mm.media.widget.d.a.aRd();
      AppMethodBeat.o(94126);
    }
    
    public final void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(94125);
      p.h(paramCameraCaptureSession, "session");
      Log.i(c.a(this.inX), "session on onConfigured");
      if (this.inX.inH == null)
      {
        AppMethodBeat.o(94125);
        return;
      }
      this.inX.inM = false;
      this.inX.inJ = paramCameraCaptureSession;
      paramCameraCaptureSession = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNl();
      paramCameraCaptureSession = com.tencent.mm.media.widget.d.a.itg;
      com.tencent.mm.media.widget.d.a.aRc();
      c.b(this.inX);
      AppMethodBeat.o(94125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.c
 * JD-Core Version:    0.7.0.1
 */