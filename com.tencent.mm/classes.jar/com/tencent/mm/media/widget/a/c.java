package com.tencent.mm.media.widget.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Looper;
import android.util.Size;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "", "availableZoomRatioIndexList", "Ljava/util/ArrayList;", "", "getAvailableZoomRatioIndexList", "()Ljava/util/ArrayList;", "bCameraReleased", "", "getBCameraReleased$plugin_mediaeditor_release", "()Z", "setBCameraReleased$plugin_mediaeditor_release", "(Z)V", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "cameraCallback", "Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "getCameraCallback", "()Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "cameraCropCallback", "getCameraCropCallback", "cameraPreviewCallback", "getCameraPreviewCallback", "currentFrameData", "", "getCurrentFrameData", "()[B", "setCurrentFrameData", "([B)V", "finishCallbackTimeCallback", "getFinishCallbackTimeCallback", "frameDataCallbackList", "", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getFrameDataCallbackList", "()Ljava/util/List;", "setFrameDataCallbackList", "(Ljava/util/List;)V", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mCameraFps", "getMCameraFps", "()I", "setMCameraFps", "(I)V", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mZoomTimesToRatio", "Lcom/tencent/tinker/android/utils/SparseIntArray;", "getMZoomTimesToRatio", "()Lcom/tencent/tinker/android/utils/SparseIntArray;", "setMZoomTimesToRatio", "(Lcom/tencent/tinker/android/utils/SparseIntArray;)V", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "openCameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "getOpenCameraRes", "()Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "setOpenCameraRes", "(Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;)V", "prevcameraCallback", "getPrevcameraCallback", "sAutoFocusCallback", "Landroid/hardware/Camera$AutoFocusCallback;", "getSAutoFocusCallback", "()Landroid/hardware/Camera$AutoFocusCallback;", "setSAutoFocusCallback", "(Landroid/hardware/Camera$AutoFocusCallback;)V", "takePictureLock", "getTakePictureLock", "setTakePictureLock", "addFrameDataCallback", "callback", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateLocDiff", "loc1", "loc2", "calculateTapArea", "Landroid/graphics/Rect;", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "checkCameraOpenSucc", "scene", "configVendorTagValue", "tag", "value", "dispatchCameraFrame", "frame", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "parameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCameraSensorRotate", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getPreviewWidth", "getSupportPreviewSize", "", "Landroid/util/Size;", "()[Landroid/util/Size;", "getSupportZoomRatios", "", "initCamera", "useBack", "initRawRatios", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "safeResetZoom", "safeSetFocusMode", "safeSetMetering", "safeSetPreviewFormat", "safeSetPreviewFrameRate", "useFixMode", "safeSetPreviewSize", "resolutionLimit", "safeSetPreviewSizeWithLimitAndRatio", "sizeLimit", "displayRatio", "safeSetStabilization", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewCallbackImpl", "setPreviewCallbackImplInGPUCrop", "setPreviewSize", "width", "height", "setSafeConfig", "startPreview", "useCpuCrop", "startPreviewWithCPU", "startPreviewWithGPU", "switchVendorTag", "isChecked", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "p", "trySetPreviewFrameRateParameters", "plugin-mediaeditor_release"})
public class c
  extends a
{
  private final String TAG;
  v gGr;
  private float imi;
  List<g> imj;
  d.a.a imk;
  private Camera.AutoFocusCallback iml;
  final com.tencent.mm.plugin.mmsight.model.c imm;
  final com.tencent.mm.plugin.mmsight.model.c imn;
  final com.tencent.mm.plugin.mmsight.model.c imo;
  final com.tencent.mm.plugin.mmsight.model.c imp;
  final com.tencent.mm.plugin.mmsight.model.c imq;
  volatile boolean imr;
  volatile byte[] ims;
  private com.tencent.tinker.a.c.b imt;
  private final ArrayList<Integer> imu;
  boolean imv;
  private kotlin.g.a.b<? super Boolean, x> imw;
  int imx;
  boolean imy;
  private final Object lock;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94058);
    this.TAG = "MicroMsg.CommonCamera1";
    this.imi = 10.0F;
    this.imj = ((List)new ArrayList());
    this.iml = ((Camera.AutoFocusCallback)new a(this));
    this.imm = new com.tencent.mm.plugin.mmsight.model.c("prevcameraCallback");
    this.imn = new com.tencent.mm.plugin.mmsight.model.c("cameraCallback");
    this.imo = new com.tencent.mm.plugin.mmsight.model.c("cameraPreviewCallback");
    this.imp = new com.tencent.mm.plugin.mmsight.model.c("cameraCropCallback");
    this.imq = new com.tencent.mm.plugin.mmsight.model.c("finishCallbackTimeCallback");
    this.imu = new ArrayList();
    this.lock = new Object();
    this.imy = true;
    AppMethodBeat.o(94058);
  }
  
  private final void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(94024);
    long l = Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithCPU,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (aPc())
    {
      Log.i(this.TAG, "startPreviewWithCPU, camera previewing");
      AppMethodBeat.o(94024);
      return;
    }
    try
    {
      rx(paramInt);
      aPp();
      aPs();
      if (a(paramSurfaceTexture, paramSurfaceHolder)) {
        a(a.a.ima);
      }
      Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(94024);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNm();
      }
    }
  }
  
  private final void aPs()
  {
    AppMethodBeat.i(94046);
    if (this.gGr == null)
    {
      AppMethodBeat.o(94046);
      return;
    }
    try
    {
      if (this.gGr == null) {
        break label240;
      }
      Object localObject1 = this.gGr;
      if (localObject1 != null)
      {
        localObject1 = ((v)localObject1).getParameters();
        if (localObject1 != null) {}
      }
      else
      {
        AppMethodBeat.o(94046);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94046);
      return;
    }
    int i = this.ilR.sUz;
    int j = this.ilR.sUA;
    j = ImageFormat.getBitsPerPixel(localException.getPreviewFormat()) * (i * j) / 8;
    Log.i(this.TAG, "setPreviewCallbackImpl  size: ".concat(String.valueOf(j)));
    i = 0;
    for (;;)
    {
      Object localObject2;
      if (i < 5)
      {
        localObject2 = k.zwi.h(Integer.valueOf(j));
        v localv = this.gGr;
        if (localv != null) {
          localv.addCallbackBuffer((byte[])localObject2);
        }
      }
      else
      {
        this.imm.reset();
        this.imn.reset();
        this.imo.reset();
        this.imp.reset();
        this.imq.reset();
        localObject2 = this.gGr;
        if (localObject2 != null)
        {
          ((v)localObject2).setPreviewCallbackWithBuffer((Camera.PreviewCallback)new b(this));
          AppMethodBeat.o(94046);
          return;
        }
        AppMethodBeat.o(94046);
        return;
        label240:
        AppMethodBeat.o(94046);
        return;
      }
      i += 1;
    }
  }
  
  private boolean j(int paramInt, float paramFloat)
  {
    Object localObject4 = null;
    AppMethodBeat.i(94026);
    if ((this.gGr == null) || (paramInt <= 0))
    {
      AppMethodBeat.o(94026);
      return false;
    }
    float f2;
    int i;
    label167:
    label255:
    boolean bool;
    try
    {
      localObject1 = this.gGr;
      if (localObject1 == null) {
        p.hyc();
      }
      localParameters = ((v)localObject1).getParameters();
      if (this.ilU != null) {
        break label538;
      }
      localObject1 = ao.az(MMApplicationContext.getContext());
      localPoint = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
      Log.i(this.TAG, "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject1 });
      float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
      f2 = 1.0F / paramFloat;
      if (paramFloat >= 1.0F) {
        break label592;
      }
      i = paramInt;
      Log.i(this.TAG, "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
      localObject1 = this.imk;
      if (localObject1 == null) {
        p.hyc();
      }
      if (((d.a.a)localObject1).dYT == 90) {
        break label623;
      }
      localObject1 = this.imk;
      if (localObject1 == null) {
        p.hyc();
      }
      if (((d.a.a)localObject1).dYT != 270) {
        break label605;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      Camera.Parameters localParameters;
      Point localPoint;
      Log.e(this.TAG, "safeSetPreviewSizeWithLimit error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94026);
      return false;
    }
    localObject1 = h.a(localParameters, localPoint, i, bool);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((h.c)localObject1).zum;
      label280:
      if (localObject3 == null)
      {
        Log.e(this.TAG, "fuck, preview size still null!!");
        if (localParameters == null) {
          p.hyc();
        }
        localObject1 = this.imk;
        if (localObject1 == null) {
          p.hyc();
        }
        if (((d.a.a)localObject1).dYT == 90) {
          break label629;
        }
        localObject1 = this.imk;
        if (localObject1 == null) {
          p.hyc();
        }
        if (((d.a.a)localObject1).dYT != 270) {
          break label617;
        }
        break label629;
      }
    }
    for (;;)
    {
      localObject1 = h.d(localParameters, localPoint, paramInt, bool);
      localObject3 = localObject4;
      if (localObject1 != null) {
        localObject3 = ((h.c)localObject1).zum;
      }
      if (localObject3 != null)
      {
        localObject1 = ((h.c)localObject1).zum;
        this.ilR.sUz = ((Point)localObject1).x;
        this.ilR.sUA = ((Point)localObject1).y;
        this.ilV = null;
        Log.i(this.ilH, "final set camera preview size: : %s, cropSize: %s", new Object[] { localObject1, this.ilV });
        if (localParameters == null) {
          p.hyc();
        }
        localParameters.setPreviewSize(this.ilR.sUz, this.ilR.sUA);
        localObject1 = this.gGr;
        if (localObject1 == null) {
          p.hyc();
        }
        ((v)localObject1).setParameters(localParameters);
        AppMethodBeat.o(94026);
        return true;
      }
      label538:
      Object localObject2 = this.ilU;
      if (localObject2 == null) {
        p.hyc();
      }
      i = ((Size)localObject2).getWidth();
      localObject2 = this.ilU;
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = new Point(i, ((Size)localObject2).getHeight());
      break;
      label592:
      i = Math.round(paramInt / f2);
      break label167;
      label605:
      bool = false;
      break label255;
      localObject3 = null;
      break label280;
      label617:
      bool = false;
      continue;
      label623:
      bool = true;
      break label255;
      label629:
      bool = true;
    }
  }
  
  private final boolean rx(int paramInt)
  {
    AppMethodBeat.i(94048);
    if ((this.gGr == null) || (this.imk == null))
    {
      Log.d(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(94048);
      return false;
    }
    Object localObject1 = this.imk;
    boolean bool;
    if ((localObject1 == null) || (((d.a.a)localObject1).dYT != 90))
    {
      localObject1 = this.imk;
      if ((localObject1 == null) || (((d.a.a)localObject1).dYT != 270)) {}
    }
    else
    {
      bool = true;
    }
    Camera.Parameters localParameters;
    label178:
    Object localObject2;
    for (;;)
    {
      try
      {
        if (this.ilU != null) {
          break label178;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.gx(this.context);
        localObject3 = this.gGr;
        if (localObject3 != null)
        {
          localParameters = ((v)localObject3).getParameters();
          if (localParameters != null) {
            break;
          }
        }
        AppMethodBeat.o(94048);
        return false;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(94048);
        return false;
      }
      bool = false;
      continue;
      localObject2 = this.ilU;
      if (localObject2 == null) {
        p.hyc();
      }
      int i = ((Size)localObject2).getWidth();
      localObject2 = this.ilU;
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = new Point(i, ((Size)localObject2).getHeight());
    }
    h.c localc = h.c(localParameters, (Point)localObject2, paramInt, bool);
    if (localc != null) {}
    for (Object localObject3 = localc.zum;; localObject3 = null)
    {
      if (localObject3 == null) {
        Log.e(this.TAG, "fuck, preview size still null!!");
      }
      for (localObject2 = h.d(localParameters, new Point(Math.min(((Point)localObject2).x, ((Point)localObject2).y), Math.max(((Point)localObject2).x, ((Point)localObject2).y)), this.ilI, bool);; localObject2 = localc)
      {
        if (((h.c)localObject2).zum == null)
        {
          Log.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject2).toString() });
          ((h.c)localObject2).zum = ((h.c)localObject2).zup;
          ((h.c)localObject2).zun = ((h.c)localObject2).zuq;
          ((h.c)localObject2).zuo = ((h.c)localObject2).zur;
        }
        localObject3 = ((h.c)localObject2).zum;
        if (localObject3 == null)
        {
          com.tencent.mm.plugin.mmsight.model.l.ejN();
          AppMethodBeat.o(94048);
          return false;
        }
        this.ilR.sUz = ((Point)localObject3).x;
        this.ilR.sUA = ((Point)localObject3).y;
        this.ilV = ((Point)localObject3);
        if (((h.c)localObject2).zun != null) {
          this.ilV = ((h.c)localObject2).zun;
        }
        Log.i(this.TAG, "final set camera preview size: " + localObject3 + ", cropSize: " + this.ilV);
        localParameters.setPreviewSize(((Point)localObject3).x, ((Point)localObject3).y);
        localObject2 = this.gGr;
        if (localObject2 != null) {
          ((v)localObject2).setParameters(localParameters);
        }
        AppMethodBeat.o(94048);
        return true;
      }
    }
  }
  
  public final void B(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94052);
    p.h(paramString, "tag");
    AppMethodBeat.o(94052);
  }
  
  public final Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218821);
    paramFloat3 = 80.0F * paramFloat3;
    paramFloat1 /= paramInt1;
    paramFloat2 /= paramInt2;
    paramFloat1 = paramFloat1 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    paramFloat2 = paramFloat2 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    Object localObject = new RectF();
    ((RectF)localObject).set(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat3 + paramFloat2);
    localObject = new Rect(android.support.v4.b.a.clamp(kotlin.h.a.cR(((RectF)localObject).left), -1000, 1000), android.support.v4.b.a.clamp(kotlin.h.a.cR(((RectF)localObject).top), -1000, 1000), android.support.v4.b.a.clamp(kotlin.h.a.cR(((RectF)localObject).right), -1000, 1000), android.support.v4.b.a.clamp(kotlin.h.a.cR(((RectF)localObject).bottom), -1000, 1000));
    AppMethodBeat.o(218821);
    return localObject;
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94022);
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    if (paramBoolean)
    {
      a(paramSurfaceTexture, null, paramInt);
      AppMethodBeat.o(94022);
      return;
    }
    b(paramSurfaceTexture, null, paramInt);
    AppMethodBeat.o(94022);
  }
  
  protected void a(Camera.Parameters paramParameters, int paramInt)
  {
    AppMethodBeat.i(218813);
    p.h(paramParameters, "p");
    if (ae.gKt.gFP > 0)
    {
      Log.i(this.ilH, "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(218813);
      return;
    }
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(218813);
      return;
    }
    int j = -2147483648;
    int k = -2147483648;
    int i = 0;
    int i4 = localList.size();
    int i1 = 0;
    int[] arrayOfInt;
    if (i1 < i4)
    {
      arrayOfInt = (int[])localList.get(i1);
      if ((arrayOfInt != null) && (arrayOfInt.length > 1)) {}
    }
    for (;;)
    {
      i1 += 1;
      break;
      int i3 = arrayOfInt[0];
      int i2 = arrayOfInt[1];
      Log.i(this.TAG, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(i2) });
      if ((i3 < 0) || (i2 >= i3))
      {
        int n = k;
        int m = j;
        if (i2 >= k)
        {
          n = k;
          m = j;
          if (i == 0)
          {
            n = i2;
            m = i3;
          }
        }
        if (paramInt != 0)
        {
          if (i2 >= paramInt * 1000)
          {
            i = 1;
            k = n;
            j = m;
          }
        }
        else if (i2 >= 30000)
        {
          i = 1;
          k = n;
          j = m;
          continue;
          Log.i(this.ilH, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(30) });
          if ((j == 2147483647) || (k == 2147483647))
          {
            AppMethodBeat.o(218813);
            return;
          }
          try
          {
            paramParameters.setPreviewFpsRange(j, k);
            Log.i(this.ilH, "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            AppMethodBeat.o(218813);
            return;
          }
          catch (Exception paramParameters)
          {
            Log.i(this.ilH, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
            AppMethodBeat.o(218813);
            return;
          }
        }
        k = n;
        j = m;
      }
    }
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94023);
    super.a(paramSurfaceHolder, paramBoolean, paramInt);
    if (paramBoolean)
    {
      a(null, paramSurfaceHolder, paramInt);
      AppMethodBeat.o(94023);
      return;
    }
    b(null, paramSurfaceHolder, paramInt);
    AppMethodBeat.o(94023);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(94020);
    Log.printInfoStack(this.TAG, "addFrameDataCallback ".concat(String.valueOf(paramg)), new Object[0]);
    if (paramg == null)
    {
      AppMethodBeat.o(94020);
      return;
    }
    synchronized (this.lock)
    {
      this.imj.add(paramg);
      AppMethodBeat.o(94020);
      return;
    }
  }
  
  public final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94027);
    v localv = this.gGr;
    if (localv != null)
    {
      if ((paramSurfaceTexture != null) || (paramSurfaceHolder != null))
      {
        if (paramSurfaceTexture != null) {
          localv.setPreviewTexture(paramSurfaceTexture);
        }
        for (;;)
        {
          localv.startPreview();
          Log.i(this.TAG, "doStartPreview finish");
          paramSurfaceTexture = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aNl();
          AppMethodBeat.o(94027);
          return true;
          localv.setPreviewDisplay(paramSurfaceHolder);
        }
      }
      Log.i(this.TAG, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNm();
      AppMethodBeat.o(94027);
      return false;
    }
    AppMethodBeat.o(94027);
    return false;
  }
  
  protected boolean a(v paramv)
  {
    AppMethodBeat.i(94042);
    if (paramv == null)
    {
      AppMethodBeat.o(94042);
      return false;
    }
    for (;;)
    {
      Camera.Parameters localParameters;
      List localList;
      try
      {
        localParameters = paramv.getParameters();
        p.g(localParameters, "p");
        localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          Log.i(this.TAG, "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          this.ilK.imR = localParameters.getFocusMode();
          paramv.setParameters(localParameters);
          AppMethodBeat.o(94042);
          return true;
        }
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          Log.i(this.TAG, "support continuous video");
          localParameters.setFocusMode("continuous-video");
          continue;
        }
        if (localList == null) {
          break label200;
        }
      }
      catch (Exception paramv)
      {
        Log.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(94042);
        return false;
      }
      if (localList.contains("auto"))
      {
        Log.i(this.TAG, "support auto focus");
        localParameters.setFocusMode("auto");
      }
      else
      {
        label200:
        Log.i(this.TAG, "not support continuous video or auto focus");
      }
    }
  }
  
  protected final boolean a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(94041);
    if (paramv == null)
    {
      AppMethodBeat.o(94041);
      return false;
    }
    for (;;)
    {
      Camera.Parameters localParameters;
      int i;
      try
      {
        localParameters = paramv.getParameters();
        if (!paramBoolean) {
          break label316;
        }
        i = this.imx;
        Object localObject1;
        if (ae.gKt.gFP > 0)
        {
          Log.i(this.ilH, "set frame rate > 0, do not try set preview frame rate");
          p.g(localParameters, "p");
          localObject1 = localParameters.getSupportedPreviewFrameRates();
          Log.i(this.ilH, "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localObject1 });
          paramv.setParameters(localParameters);
          AppMethodBeat.o(94041);
          return true;
        }
        if (localParameters == null)
        {
          Log.e(this.TAG, "trySetPreviewFrameRateParameters error, p is null!");
          continue;
        }
        try
        {
          localObject1 = localParameters.getSupportedPreviewFrameRates();
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            continue;
          }
          if (i != 0)
          {
            localObject1 = Collections.max((Collection)localObject1);
            p.g(localObject1, "Collections.max(fr)");
            i = Math.min(i, ((Number)localObject1).intValue());
            localParameters.setPreviewFrameRate(i);
            Log.i(this.ilH, "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
        }
        catch (Exception localException)
        {
          Log.i(this.ilH, "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        }
      }
      catch (Exception paramv)
      {
        Log.i(this.ilH, "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(94041);
        return false;
      }
      for (;;)
      {
        break;
        Object localObject2 = Collections.max((Collection)localException);
        p.g(localObject2, "Collections.max(fr)");
        i = Math.min(30, ((Number)localObject2).intValue());
      }
      label316:
      p.g(localParameters, "p");
      a(localParameters, this.imx);
    }
  }
  
  public final int aPf()
  {
    AppMethodBeat.i(218817);
    Object localObject = this.gGr;
    if (localObject != null)
    {
      localObject = ((v)localObject).getParameters();
      if (localObject != null)
      {
        int i = ((Camera.Parameters)localObject).getPreviewFrameRate();
        AppMethodBeat.o(218817);
        return i;
      }
    }
    AppMethodBeat.o(218817);
    return 0;
  }
  
  public final boolean aPg()
  {
    AppMethodBeat.i(218819);
    if ((p.j(this.ilK.imR, "auto") ^ true))
    {
      AppMethodBeat.o(218819);
      return false;
    }
    v localv = this.gGr;
    if (localv != null) {
      localv.autoFocus(null);
    }
    AppMethodBeat.o(218819);
    return true;
  }
  
  public final boolean aPh()
  {
    boolean bool2 = false;
    d.a.a locala = this.imk;
    boolean bool1 = bool2;
    if (locala != null) {
      if (locala.dYT != 90)
      {
        bool1 = bool2;
        if (locala.dYT != 270) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Size[] aPi()
  {
    AppMethodBeat.i(218814);
    Object localObject = this.gGr;
    if (localObject != null)
    {
      localObject = ((v)localObject).getParameters();
      if (localObject != null)
      {
        localObject = ((Camera.Parameters)localObject).getSupportedPreviewSizes();
        if (localObject != null)
        {
          int j = ((List)localObject).size();
          Size[] arrayOfSize = new Size[j];
          int i = 0;
          while (i < j)
          {
            Camera.Size localSize = (Camera.Size)((List)localObject).get(i);
            arrayOfSize[i] = new Size(localSize.width, localSize.height);
            i += 1;
          }
          AppMethodBeat.o(218814);
          return arrayOfSize;
        }
      }
    }
    AppMethodBeat.o(218814);
    return null;
  }
  
  /* Error */
  public void aPp()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 896
    //   5: invokestatic 271	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 902	com/tencent/mm/plugin/mmsight/model/a/l:ekc	()Lcom/tencent/mm/plugin/mmsight/model/a/l;
    //   11: astore 8
    //   13: aload 8
    //   15: ldc_w 904
    //   18: invokestatic 789	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload 8
    //   23: invokevirtual 908	com/tencent/mm/plugin/mmsight/model/a/l:ekd	()Lcom/tencent/mm/plugin/mmsight/SightParams;
    //   26: ifnull +943 -> 969
    //   29: invokestatic 902	com/tencent/mm/plugin/mmsight/model/a/l:ekc	()Lcom/tencent/mm/plugin/mmsight/model/a/l;
    //   32: astore 8
    //   34: aload 8
    //   36: ldc_w 904
    //   39: invokestatic 789	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   42: aload 8
    //   44: invokevirtual 908	com/tencent/mm/plugin/mmsight/model/a/l:ekd	()Lcom/tencent/mm/plugin/mmsight/SightParams;
    //   47: getfield 913	com/tencent/mm/plugin/mmsight/SightParams:zsR	I
    //   50: invokestatic 485	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: astore 9
    //   55: aload_0
    //   56: getfield 275	com/tencent/mm/media/widget/a/c:TAG	Ljava/lang/String;
    //   59: astore 10
    //   61: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   64: getfield 916	com/tencent/mm/compatible/deviceinfo/c:gFU	I
    //   67: iconst_1
    //   68: if_icmpne +720 -> 788
    //   71: ldc_w 918
    //   74: astore 8
    //   76: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   79: getfield 921	com/tencent/mm/compatible/deviceinfo/c:gFV	I
    //   82: iconst_1
    //   83: if_icmpne +731 -> 814
    //   86: iconst_1
    //   87: istore 4
    //   89: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   92: getfield 924	com/tencent/mm/compatible/deviceinfo/c:gFW	I
    //   95: iconst_1
    //   96: if_icmpne +724 -> 820
    //   99: iconst_1
    //   100: istore 5
    //   102: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   105: getfield 927	com/tencent/mm/compatible/deviceinfo/c:gFX	I
    //   108: iconst_1
    //   109: if_icmpne +717 -> 826
    //   112: iconst_1
    //   113: istore 6
    //   115: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   118: getfield 930	com/tencent/mm/compatible/deviceinfo/c:gFY	I
    //   121: iconst_1
    //   122: if_icmpne +710 -> 832
    //   125: iconst_1
    //   126: istore 7
    //   128: aload 10
    //   130: ldc_w 932
    //   133: bipush 6
    //   135: anewarray 318	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload 9
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: aload 8
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: iload 4
    //   152: invokestatic 842	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   155: aastore
    //   156: dup
    //   157: iconst_3
    //   158: iload 5
    //   160: invokestatic 842	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   163: aastore
    //   164: dup
    //   165: iconst_4
    //   166: iload 6
    //   168: invokestatic 842	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   171: aastore
    //   172: dup
    //   173: iconst_5
    //   174: iload 7
    //   176: invokestatic 842	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   179: aastore
    //   180: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   186: getfield 916	com/tencent/mm/compatible/deviceinfo/c:gFU	I
    //   189: iconst_1
    //   190: if_icmpne +648 -> 838
    //   193: aload 9
    //   195: invokevirtual 933	java/lang/Integer:intValue	()I
    //   198: ifeq +12 -> 210
    //   201: aload 9
    //   203: invokevirtual 933	java/lang/Integer:intValue	()I
    //   206: iconst_1
    //   207: if_icmpne +631 -> 838
    //   210: iconst_0
    //   211: istore 4
    //   213: iload 4
    //   215: istore 5
    //   217: aload_0
    //   218: getfield 937	com/tencent/mm/media/widget/a/a:ilS	Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   221: ifnull +183 -> 404
    //   224: aload_0
    //   225: getfield 937	com/tencent/mm/media/widget/a/a:ilS	Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   228: astore 8
    //   230: aload 8
    //   232: ifnull +639 -> 871
    //   235: aload 8
    //   237: getfield 943	com/tencent/mm/media/widget/camerarecordview/d/b$a:irc	Ljava/util/HashMap;
    //   240: astore 8
    //   242: iload 4
    //   244: istore 5
    //   246: aload 8
    //   248: ifnull +156 -> 404
    //   251: aload_0
    //   252: getfield 937	com/tencent/mm/media/widget/a/a:ilS	Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   255: astore 8
    //   257: aload 8
    //   259: ifnull +618 -> 877
    //   262: aload 8
    //   264: getfield 943	com/tencent/mm/media/widget/camerarecordview/d/b$a:irc	Ljava/util/HashMap;
    //   267: astore 8
    //   269: aload 8
    //   271: ifnull +606 -> 877
    //   274: aload 8
    //   276: aload_0
    //   277: invokevirtual 946	com/tencent/mm/media/widget/a/c:aPu	()I
    //   280: invokestatic 485	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: invokevirtual 951	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   286: checkcast 953	com/tencent/mm/media/widget/camerarecordview/d/b$a$c
    //   289: astore 8
    //   291: iload 4
    //   293: istore 5
    //   295: aload 8
    //   297: ifnull +107 -> 404
    //   300: aload_0
    //   301: getfield 937	com/tencent/mm/media/widget/a/a:ilS	Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   304: astore 8
    //   306: iload 4
    //   308: istore 5
    //   310: aload 8
    //   312: ifnull +92 -> 404
    //   315: aload 8
    //   317: getfield 943	com/tencent/mm/media/widget/camerarecordview/d/b$a:irc	Ljava/util/HashMap;
    //   320: astore 8
    //   322: iload 4
    //   324: istore 5
    //   326: aload 8
    //   328: ifnull +76 -> 404
    //   331: aload 8
    //   333: aload_0
    //   334: invokevirtual 946	com/tencent/mm/media/widget/a/c:aPu	()I
    //   337: invokestatic 485	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: invokevirtual 951	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   343: checkcast 953	com/tencent/mm/media/widget/camerarecordview/d/b$a$c
    //   346: astore 8
    //   348: iload 4
    //   350: istore 5
    //   352: aload 8
    //   354: ifnull +50 -> 404
    //   357: aload 8
    //   359: getfield 957	com/tencent/mm/media/widget/camerarecordview/d/b$a$c:iri	Ljava/lang/Integer;
    //   362: astore 10
    //   364: aload 10
    //   366: ifnull +15 -> 381
    //   369: aload_0
    //   370: aload 10
    //   372: checkcast 857	java/lang/Number
    //   375: invokevirtual 860	java/lang/Number:intValue	()I
    //   378: putfield 830	com/tencent/mm/media/widget/a/c:imx	I
    //   381: aload 8
    //   383: getfield 961	com/tencent/mm/media/widget/camerarecordview/d/b$a$c:irj	Ljava/lang/Boolean;
    //   386: astore 8
    //   388: iload 4
    //   390: istore 5
    //   392: aload 8
    //   394: ifnull +10 -> 404
    //   397: aload 8
    //   399: invokevirtual 964	java/lang/Boolean:booleanValue	()Z
    //   402: istore 5
    //   404: aload_0
    //   405: aload_0
    //   406: getfield 432	com/tencent/mm/media/widget/a/c:gGr	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   409: iload 5
    //   411: invokevirtual 966	com/tencent/mm/media/widget/a/c:a	(Lcom/tencent/mm/compatible/deviceinfo/v;Z)Z
    //   414: pop
    //   415: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   418: getfield 921	com/tencent/mm/compatible/deviceinfo/c:gFV	I
    //   421: iconst_1
    //   422: if_icmpne +29 -> 451
    //   425: aload 9
    //   427: invokevirtual 933	java/lang/Integer:intValue	()I
    //   430: ifeq +12 -> 442
    //   433: aload 9
    //   435: invokevirtual 933	java/lang/Integer:intValue	()I
    //   438: iconst_2
    //   439: if_icmpne +12 -> 451
    //   442: aload_0
    //   443: aload_0
    //   444: getfield 432	com/tencent/mm/media/widget/a/c:gGr	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   447: invokevirtual 968	com/tencent/mm/media/widget/a/c:b	(Lcom/tencent/mm/compatible/deviceinfo/v;)Z
    //   450: pop
    //   451: getstatic 972	com/tencent/mm/compatible/deviceinfo/ae:gKA	Lcom/tencent/mm/compatible/deviceinfo/x;
    //   454: getfield 977	com/tencent/mm/compatible/deviceinfo/x:gIX	I
    //   457: iconst_m1
    //   458: if_icmpeq +30 -> 488
    //   461: getstatic 972	com/tencent/mm/compatible/deviceinfo/ae:gKA	Lcom/tencent/mm/compatible/deviceinfo/x;
    //   464: getfield 977	com/tencent/mm/compatible/deviceinfo/x:gIX	I
    //   467: iconst_1
    //   468: if_icmpne +20 -> 488
    //   471: bipush 14
    //   473: invokestatic 982	com/tencent/mm/compatible/util/d:oF	(I)Z
    //   476: ifeq +12 -> 488
    //   479: aload_0
    //   480: aload_0
    //   481: getfield 432	com/tencent/mm/media/widget/a/c:gGr	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   484: invokevirtual 984	com/tencent/mm/media/widget/a/c:c	(Lcom/tencent/mm/compatible/deviceinfo/v;)Z
    //   487: pop
    //   488: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   491: getfield 927	com/tencent/mm/compatible/deviceinfo/c:gFX	I
    //   494: iconst_1
    //   495: if_icmpne +29 -> 524
    //   498: aload 9
    //   500: invokevirtual 933	java/lang/Integer:intValue	()I
    //   503: ifeq +12 -> 515
    //   506: aload 9
    //   508: invokevirtual 933	java/lang/Integer:intValue	()I
    //   511: iconst_4
    //   512: if_icmpne +12 -> 524
    //   515: aload_0
    //   516: aload_0
    //   517: getfield 432	com/tencent/mm/media/widget/a/c:gGr	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   520: invokevirtual 986	com/tencent/mm/media/widget/a/c:a	(Lcom/tencent/mm/compatible/deviceinfo/v;)Z
    //   523: pop
    //   524: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   527: getfield 930	com/tencent/mm/compatible/deviceinfo/c:gFY	I
    //   530: iconst_1
    //   531: if_icmpne +17 -> 548
    //   534: aload 9
    //   536: invokevirtual 933	java/lang/Integer:intValue	()I
    //   539: ifeq +9 -> 548
    //   542: aload 9
    //   544: invokevirtual 933	java/lang/Integer:intValue	()I
    //   547: pop
    //   548: aload_0
    //   549: getfield 432	com/tencent/mm/media/widget/a/c:gGr	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   552: astore 8
    //   554: aload 8
    //   556: ifnull +327 -> 883
    //   559: aload 8
    //   561: invokevirtual 438	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   564: astore 8
    //   566: aload 8
    //   568: ifnull +18 -> 586
    //   571: aload 8
    //   573: invokevirtual 989	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   576: iconst_1
    //   577: if_icmpne +9 -> 586
    //   580: aload 8
    //   582: iconst_0
    //   583: invokevirtual 992	android/hardware/Camera$Parameters:setZoom	(I)V
    //   586: aload_0
    //   587: getfield 432	com/tencent/mm/media/widget/a/c:gGr	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   590: astore 9
    //   592: aload 9
    //   594: ifnull +10 -> 604
    //   597: aload 9
    //   599: aload 8
    //   601: invokevirtual 587	com/tencent/mm/compatible/deviceinfo/v:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   604: aload_0
    //   605: getfield 432	com/tencent/mm/media/widget/a/c:gGr	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   608: astore 8
    //   610: aload 8
    //   612: ifnull +304 -> 916
    //   615: aload 8
    //   617: invokevirtual 438	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   620: astore 8
    //   622: aload 8
    //   624: ifnull +298 -> 922
    //   627: aload 8
    //   629: invokevirtual 995	android/hardware/Camera$Parameters:getZoomRatios	()Ljava/util/List;
    //   632: astore 9
    //   634: aload 9
    //   636: ifnull +286 -> 922
    //   639: aload 9
    //   641: invokestatic 1001	kotlin/a/j:ks	(Ljava/util/List;)Ljava/lang/Object;
    //   644: checkcast 482	java/lang/Integer
    //   647: astore 9
    //   649: aload 9
    //   651: ifnull +271 -> 922
    //   654: aload 9
    //   656: invokevirtual 933	java/lang/Integer:intValue	()I
    //   659: istore_2
    //   660: aload_0
    //   661: getfield 316	com/tencent/mm/media/widget/a/c:imu	Ljava/util/ArrayList;
    //   664: invokevirtual 1004	java/util/ArrayList:clear	()V
    //   667: aload_0
    //   668: getfield 316	com/tencent/mm/media/widget/a/c:imu	Ljava/util/ArrayList;
    //   671: iconst_0
    //   672: invokestatic 485	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   675: invokevirtual 1005	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   678: pop
    //   679: iload_2
    //   680: i2f
    //   681: fstore_1
    //   682: aload_0
    //   683: getfield 278	com/tencent/mm/media/widget/a/c:imi	F
    //   686: fload_1
    //   687: fadd
    //   688: fstore_1
    //   689: aload 8
    //   691: ifnull +243 -> 934
    //   694: aload 8
    //   696: invokevirtual 995	android/hardware/Camera$Parameters:getZoomRatios	()Ljava/util/List;
    //   699: astore 8
    //   701: aload 8
    //   703: ifnull +231 -> 934
    //   706: aload 8
    //   708: checkcast 1007	java/lang/Iterable
    //   711: invokeinterface 1011 1 0
    //   716: astore 8
    //   718: iload_3
    //   719: istore_2
    //   720: aload 8
    //   722: invokeinterface 1016 1 0
    //   727: ifeq +200 -> 927
    //   730: aload 8
    //   732: invokeinterface 1019 1 0
    //   737: astore 9
    //   739: iload_2
    //   740: ifge +6 -> 746
    //   743: invokestatic 1022	kotlin/a/j:hxH	()V
    //   746: aload 9
    //   748: checkcast 482	java/lang/Integer
    //   751: invokevirtual 933	java/lang/Integer:intValue	()I
    //   754: i2f
    //   755: fload_1
    //   756: invokestatic 1026	java/lang/Float:compare	(FF)I
    //   759: ifle +201 -> 960
    //   762: aload_0
    //   763: getfield 278	com/tencent/mm/media/widget/a/c:imi	F
    //   766: fload_1
    //   767: fadd
    //   768: fstore_1
    //   769: aload_0
    //   770: getfield 316	com/tencent/mm/media/widget/a/c:imu	Ljava/util/ArrayList;
    //   773: iload_2
    //   774: invokestatic 485	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   777: invokevirtual 1005	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   780: pop
    //   781: iload_2
    //   782: iconst_1
    //   783: iadd
    //   784: istore_2
    //   785: goto -65 -> 720
    //   788: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   791: getfield 1029	com/tencent/mm/compatible/deviceinfo/c:gFT	I
    //   794: iconst_1
    //   795: if_icmpne +11 -> 806
    //   798: ldc_w 1031
    //   801: astore 8
    //   803: goto -727 -> 76
    //   806: ldc_w 1033
    //   809: astore 8
    //   811: goto -735 -> 76
    //   814: iconst_0
    //   815: istore 4
    //   817: goto -728 -> 89
    //   820: iconst_0
    //   821: istore 5
    //   823: goto -721 -> 102
    //   826: iconst_0
    //   827: istore 6
    //   829: goto -714 -> 115
    //   832: iconst_0
    //   833: istore 7
    //   835: goto -707 -> 128
    //   838: getstatic 716	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   841: getfield 1029	com/tencent/mm/compatible/deviceinfo/c:gFT	I
    //   844: iconst_1
    //   845: if_icmpne +118 -> 963
    //   848: aload 9
    //   850: invokevirtual 933	java/lang/Integer:intValue	()I
    //   853: ifeq +12 -> 865
    //   856: aload 9
    //   858: invokevirtual 933	java/lang/Integer:intValue	()I
    //   861: iconst_5
    //   862: if_icmpne +101 -> 963
    //   865: iconst_1
    //   866: istore 4
    //   868: goto -655 -> 213
    //   871: aconst_null
    //   872: astore 8
    //   874: goto -632 -> 242
    //   877: aconst_null
    //   878: astore 8
    //   880: goto -589 -> 291
    //   883: aconst_null
    //   884: astore 8
    //   886: goto -320 -> 566
    //   889: astore 8
    //   891: aload_0
    //   892: getfield 275	com/tencent/mm/media/widget/a/c:TAG	Ljava/lang/String;
    //   895: ldc_w 1035
    //   898: iconst_1
    //   899: anewarray 318	java/lang/Object
    //   902: dup
    //   903: iconst_0
    //   904: aload 8
    //   906: invokevirtual 417	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   909: aastore
    //   910: invokestatic 420	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   913: goto -309 -> 604
    //   916: aconst_null
    //   917: astore 8
    //   919: goto -297 -> 622
    //   922: iconst_0
    //   923: istore_2
    //   924: goto -264 -> 660
    //   927: ldc_w 896
    //   930: invokestatic 326	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   933: return
    //   934: ldc_w 896
    //   937: invokestatic 326	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   940: return
    //   941: astore 8
    //   943: aload_0
    //   944: getfield 275	com/tencent/mm/media/widget/a/c:TAG	Ljava/lang/String;
    //   947: ldc_w 1037
    //   950: invokestatic 370	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   953: ldc_w 896
    //   956: invokestatic 326	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   959: return
    //   960: goto -179 -> 781
    //   963: iconst_0
    //   964: istore 4
    //   966: goto -753 -> 213
    //   969: iconst_0
    //   970: invokestatic 485	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   973: astore 9
    //   975: goto -920 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	978	0	this	c
    //   681	88	1	f	float
    //   659	265	2	i	int
    //   1	718	3	j	int
    //   87	878	4	bool1	boolean
    //   100	722	5	bool2	boolean
    //   113	715	6	bool3	boolean
    //   126	708	7	bool4	boolean
    //   11	874	8	localObject1	Object
    //   889	16	8	localException1	Exception
    //   917	1	8	localObject2	Object
    //   941	1	8	localException2	Exception
    //   53	921	9	localObject3	Object
    //   59	312	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   548	554	889	java/lang/Exception
    //   559	566	889	java/lang/Exception
    //   571	586	889	java/lang/Exception
    //   586	592	889	java/lang/Exception
    //   597	604	889	java/lang/Exception
    //   604	610	941	java/lang/Exception
    //   615	622	941	java/lang/Exception
    //   627	634	941	java/lang/Exception
    //   639	649	941	java/lang/Exception
    //   654	660	941	java/lang/Exception
    //   660	679	941	java/lang/Exception
    //   682	689	941	java/lang/Exception
    //   694	701	941	java/lang/Exception
    //   706	718	941	java/lang/Exception
    //   720	739	941	java/lang/Exception
    //   743	746	941	java/lang/Exception
    //   746	781	941	java/lang/Exception
    //   927	933	941	java/lang/Exception
  }
  
  public void aPq()
  {
    AppMethodBeat.i(94030);
    if (!aPc())
    {
      AppMethodBeat.o(94030);
      return;
    }
    com.tencent.mm.media.widget.a.a.a locala = this.ilK;
    com.tencent.mm.media.widget.a.a.a.a locala1 = com.tencent.mm.media.widget.a.a.a.imU;
    locala.removeMessages(com.tencent.mm.media.widget.a.a.a.aPz());
    AppMethodBeat.o(94030);
  }
  
  public b aPr()
  {
    boolean bool = true;
    AppMethodBeat.i(94036);
    Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.gGr == null)
    {
      Log.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94036);
      return null;
    }
    if (!aPc())
    {
      Log.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94036);
      return null;
    }
    b.rs(getPreviewWidth());
    b.rr(getPreviewHeight());
    Object localObject = this.imk;
    int i;
    if (localObject != null) {
      if ((((d.a.a)localObject).dYT == 90) || (((d.a.a)localObject).dYT == 270))
      {
        i = 1;
        b.ru(this.ilR.sUz);
        b.rv(this.ilR.sUA);
        if (i != 0)
        {
          i = b.aPl();
          b.ru(b.aPm());
          b.rv(i);
        }
        b.rt(getOrientation());
        if (this.ilM) {
          break label202;
        }
      }
    }
    for (;;)
    {
      b.setFrontCamera(bool);
      b.eZ(this.ilO);
      localObject = this.hAu;
      AppMethodBeat.o(94036);
      return localObject;
      i = 0;
      break;
      i = 0;
      break;
      label202:
      bool = false;
    }
  }
  
  public void aPt()
  {
    AppMethodBeat.i(94047);
    if (this.gGr != null) {
      try
      {
        Object localObject = this.gGr;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((v)localObject).getParameters();
        Log.i(this.TAG, "setPreviewCallbackImpl");
        int i = this.ilR.sUz;
        int j = this.ilR.sUA;
        if (localObject == null) {
          p.hyc();
        }
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = k.zwi.h(Integer.valueOf(j));
          v localv = this.gGr;
          if (localv == null) {
            p.hyc();
          }
          localv.addCallbackBuffer((byte[])localObject);
          i += 1;
        }
        this.imm.reset();
        this.imn.reset();
        this.imo.reset();
        this.imp.reset();
        this.imq.reset();
        localObject = this.gGr;
        if (localObject == null) {
          p.hyc();
        }
        ((v)localObject).setPreviewCallbackWithBuffer((Camera.PreviewCallback)new c(this));
        AppMethodBeat.o(94047);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94047);
  }
  
  public final int aPu()
  {
    if (this.ilM) {
      return 0;
    }
    return 1;
  }
  
  public final int aPv()
  {
    AppMethodBeat.i(94050);
    int i = getOrientation();
    AppMethodBeat.o(94050);
    return i;
  }
  
  public final String aPw()
  {
    AppMethodBeat.i(218822);
    Object localObject = this.gGr;
    if (localObject != null)
    {
      localObject = ((v)localObject).getParameters();
      if (localObject != null)
      {
        String str = ((Camera.Parameters)localObject).getFocusMode();
        localObject = str;
        if (str != null) {
          break label39;
        }
      }
    }
    localObject = "auto";
    label39:
    switch (((String)localObject).hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          localObject = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
          localObject = b.b.aQC();
          AppMethodBeat.o(218822);
          return localObject;
        } while (!((String)localObject).equals("auto"));
        localObject = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
        localObject = b.b.aQC();
        AppMethodBeat.o(218822);
        return localObject;
      } while (!((String)localObject).equals("continuous-video"));
      localObject = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
      localObject = b.b.aQA();
      AppMethodBeat.o(218822);
      return localObject;
    } while (!((String)localObject).equals("continuous-picture"));
    localObject = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
    localObject = b.b.aQB();
    AppMethodBeat.o(218822);
    return localObject;
  }
  
  public final boolean aPx()
  {
    AppMethodBeat.i(218823);
    try
    {
      Log.i(this.TAG, "triggerAutoFocus");
      v localv = this.gGr;
      if (localv != null) {
        localv.cancelAutoFocus();
      }
      localv = this.gGr;
      if (localv != null) {
        localv.autoFocus(this.iml);
      }
      AppMethodBeat.o(218823);
      return true;
    }
    catch (Exception localException)
    {
      Log.w(this.TAG, "autofocus fail, exception %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(218823);
    }
    return false;
  }
  
  public final void ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(94053);
    p.h(paramString, "tag");
    AppMethodBeat.o(94053);
  }
  
  protected final boolean ah(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94051);
    p.h(paramArrayOfByte, "frame");
    Util.currentTicks();
    synchronized (this.lock)
    {
      if (this.imj != null)
      {
        int i = this.imj.size();
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(94051);
        return false;
      }
      Iterator localIterator = this.imj.iterator();
      boolean bool1 = false;
      while (localIterator.hasNext())
      {
        boolean bool2 = ((g)localIterator.next()).ai(paramArrayOfByte);
        bool1 |= bool2;
      }
      AppMethodBeat.o(94051);
      return bool1;
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94029);
    if (!aPc())
    {
      AppMethodBeat.o(94029);
      return;
    }
    if (com.tencent.mm.compatible.util.d.oE(14))
    {
      AppMethodBeat.o(94029);
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
    locala.sendMessageDelayed(((com.tencent.mm.media.widget.a.a.a)localObject).obtainMessage(com.tencent.mm.media.widget.a.a.a.aPz(), this.gGr), 400L);
    AppMethodBeat.o(94029);
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(94025);
    long l = Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (aPc())
    {
      Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94025);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.ilQ) {
          continue;
        }
        j(paramInt, this.ilP);
        aPt();
        aPp();
        if (a(paramSurfaceTexture, paramSurfaceHolder)) {
          a(a.a.ima);
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNm();
        continue;
      }
      Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(94025);
      return;
      rq(paramInt);
    }
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(94021);
    Log.printInfoStack(this.TAG, "removeFrameDataCallback ".concat(String.valueOf(paramg)), new Object[0]);
    if (paramg == null)
    {
      AppMethodBeat.o(94021);
      return;
    }
    synchronized (this.lock)
    {
      this.imj.remove(paramg);
      AppMethodBeat.o(94021);
      return;
    }
  }
  
  public final boolean b(Rect paramRect1, Rect paramRect2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(218820);
    p.h(paramRect1, "focusArea");
    p.h(paramRect2, "meteringArea");
    try
    {
      Log.i(this.TAG, "focus on area :: focus rect %s, meter rect %s", new Object[] { paramRect1, paramRect2 });
      Object localObject1 = this.gGr;
      if (localObject1 != null)
      {
        localObject1 = ((v)localObject1).getParameters();
        if (localObject1 != null) {
          localObject2 = ((Camera.Parameters)localObject1).getSupportedFocusModes();
        }
        if ((localObject2 != null) && (((List)localObject2).contains("auto"))) {
          ((Camera.Parameters)localObject1).setFocusMode("auto");
        }
        if (localObject1 == null) {
          break label258;
        }
        i = ((Camera.Parameters)localObject1).getMaxNumFocusAreas();
        label112:
        if (i > 0)
        {
          localObject2 = new ArrayList(1);
          ((ArrayList)localObject2).add(new Camera.Area(paramRect1, 1000));
          if (localObject1 != null) {
            ((Camera.Parameters)localObject1).setFocusAreas((List)localObject2);
          }
        }
        if (localObject1 == null) {
          break label263;
        }
      }
      label258:
      label263:
      for (int i = ((Camera.Parameters)localObject1).getMaxNumMeteringAreas();; i = 0)
      {
        if (i > 0)
        {
          paramRect1 = new ArrayList(1);
          paramRect1.add(new Camera.Area(paramRect2, 1000));
          if (localObject1 != null) {
            ((Camera.Parameters)localObject1).setMeteringAreas((List)paramRect1);
          }
        }
        paramRect1 = this.gGr;
        if (paramRect1 != null) {
          paramRect1.setParameters((Camera.Parameters)localObject1);
        }
        paramRect1 = this.gGr;
        if (paramRect1 != null) {
          paramRect1.autoFocus(this.iml);
        }
        AppMethodBeat.o(218820);
        return true;
        localObject1 = null;
        break;
        i = 0;
        break label112;
      }
      return false;
    }
    catch (Exception paramRect1)
    {
      Log.w(this.TAG, "autofocus with area fail, exception %s", new Object[] { paramRect1.getMessage() });
      AppMethodBeat.o(218820);
    }
  }
  
  public boolean b(v paramv)
  {
    AppMethodBeat.i(94044);
    if (paramv == null)
    {
      AppMethodBeat.o(94044);
      return false;
    }
    try
    {
      Log.i(this.TAG, "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramv.getParameters();
      p.g(localParameters, "p");
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        Log.e(this.TAG, "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramv.setParameters(localParameters);
      AppMethodBeat.o(94044);
      return true;
    }
    catch (Exception paramv)
    {
      Log.i(this.TAG, "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
      AppMethodBeat.o(94044);
    }
    return false;
  }
  
  @TargetApi(14)
  protected final boolean c(v paramv)
  {
    AppMethodBeat.i(94045);
    if (paramv == null)
    {
      AppMethodBeat.o(94045);
      return false;
    }
    try
    {
      Log.i(this.TAG, "safeSetMetering");
      Camera.Parameters localParameters = paramv.getParameters();
      p.g(localParameters, "params");
      if (localParameters.getMaxNumMeteringAreas() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(new Rect(-1000, -1000, 1000, 1000), 600));
        localParameters.setMeteringAreas((List)localArrayList);
      }
      paramv.setParameters(localParameters);
      AppMethodBeat.o(94045);
      return true;
    }
    catch (Exception paramv)
    {
      Log.i(this.TAG, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
      AppMethodBeat.o(94045);
    }
    return false;
  }
  
  public final int df(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218818);
    for (;;)
    {
      try
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt1, localCameraInfo);
        switch (paramInt2)
        {
        default: 
          if (!this.ilM)
          {
            paramInt2 = localCameraInfo.orientation;
            AppMethodBeat.o(218818);
            return (360 - (paramInt1 + paramInt2) % 360) % 360;
          }
          paramInt2 = localCameraInfo.orientation;
          AppMethodBeat.o(218818);
          return (paramInt2 - paramInt1 + 360) % 360;
        }
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "setCameraDisplayOrientation failed cause " + localException.getMessage());
        AppMethodBeat.o(218818);
        return 0;
      }
      paramInt1 = 0;
      continue;
      paramInt1 = 0;
      continue;
      paramInt1 = 90;
      continue;
      paramInt1 = 180;
      continue;
      paramInt1 = 270;
    }
  }
  
  public final boolean dg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218815);
    try
    {
      Object localObject = this.gGr;
      if (localObject != null) {}
      for (localObject = ((v)localObject).getParameters();; localObject = null)
      {
        if (localObject != null) {
          ((Camera.Parameters)localObject).setPreviewSize(paramInt1, paramInt2);
        }
        v localv = this.gGr;
        if (localv != null) {
          localv.setParameters((Camera.Parameters)localObject);
        }
        AppMethodBeat.o(218815);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(218815);
    }
  }
  
  public Point fa(boolean paramBoolean)
  {
    AppMethodBeat.i(94039);
    Object localObject;
    if (!paramBoolean)
    {
      localObject = new Point(this.ilR.sUz, this.ilR.sUA);
      AppMethodBeat.o(94039);
      return localObject;
    }
    if (this.ilV != null)
    {
      Point localPoint = this.ilV;
      localObject = localPoint;
      if (localPoint == null)
      {
        p.hyc();
        AppMethodBeat.o(94039);
        return localPoint;
      }
    }
    else
    {
      localObject = new Point(this.ilR.sUz, this.ilR.sUA);
    }
    AppMethodBeat.o(94039);
    return localObject;
  }
  
  public final void fb(boolean paramBoolean)
  {
    AppMethodBeat.i(94055);
    for (;;)
    {
      try
      {
        Object localObject1 = this.gGr;
        if (localObject1 == null) {
          break label103;
        }
        localObject1 = ((v)localObject1).getParameters();
        if (paramBoolean)
        {
          if (localObject1 != null) {
            ((Camera.Parameters)localObject1).setFlashMode("torch");
          }
          v localv = this.gGr;
          if (localv != null)
          {
            localv.setParameters((Camera.Parameters)localObject1);
            AppMethodBeat.o(94055);
          }
        }
        else
        {
          if (localObject1 == null) {
            continue;
          }
          ((Camera.Parameters)localObject1).setFlashMode("off");
          continue;
        }
        AppMethodBeat.o(94055);
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "set flash mode error", new Object[0]);
        AppMethodBeat.o(94055);
        return;
      }
      return;
      label103:
      Object localObject2 = null;
    }
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(94056);
    Object localObject = this.gGr;
    if (localObject != null)
    {
      localObject = ((v)localObject).getParameters();
      if (localObject != null)
      {
        localObject = ((Camera.Parameters)localObject).getFlashMode();
        if (localObject != null) {
          break label46;
        }
      }
    }
    label46:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(94056);
            return 2;
            localObject = null;
            break;
            switch (((String)localObject).hashCode())
            {
            }
          }
        } while (!((String)localObject).equals("on"));
        AppMethodBeat.o(94056);
        return 1;
      } while (!((String)localObject).equals("auto"));
      AppMethodBeat.o(94056);
      return 3;
    } while (!((String)localObject).equals("off"));
    AppMethodBeat.o(94056);
    return 2;
  }
  
  protected final int getOrientation()
  {
    AppMethodBeat.i(94040);
    if ((this.imk != null) && (aPc()))
    {
      d.a.a locala = this.imk;
      if (locala != null)
      {
        int i = locala.dYT;
        AppMethodBeat.o(94040);
        return i;
      }
      AppMethodBeat.o(94040);
      return 0;
    }
    AppMethodBeat.o(94040);
    return -1;
  }
  
  public int getPreviewHeight()
  {
    AppMethodBeat.i(94037);
    if (this.gGr == null)
    {
      AppMethodBeat.o(94037);
      return 0;
    }
    if (this.imk != null) {
      try
      {
        if ((this.ilO) && (this.ilV != null))
        {
          Point localPoint = this.ilV;
          if (localPoint == null) {
            p.hyc();
          }
          i = localPoint.y;
          AppMethodBeat.o(94037);
          return i;
        }
        int i = this.ilR.sUA;
        AppMethodBeat.o(94037);
        return i;
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94037);
    return 0;
  }
  
  public int getPreviewWidth()
  {
    AppMethodBeat.i(94038);
    if (this.gGr == null)
    {
      AppMethodBeat.o(94038);
      return 0;
    }
    if (this.imk != null) {
      try
      {
        if ((this.ilO) && (this.ilV != null))
        {
          Point localPoint = this.ilV;
          if (localPoint == null) {
            p.hyc();
          }
          i = localPoint.x;
          AppMethodBeat.o(94038);
          return i;
        }
        int i = this.ilR.sUz;
        AppMethodBeat.o(94038);
        return i;
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94038);
    return 0;
  }
  
  public final float[] getSupportZoomRatios()
  {
    Object localObject1 = null;
    AppMethodBeat.i(94033);
    if ((this.imt != null) || (this.gGr != null)) {}
    float[] arrayOfFloat;
    label218:
    label474:
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = this.gGr;
        if (localObject2 == null) {
          p.hyc();
        }
        localObject2 = ((v)localObject2).getParameters();
        if (localObject2 == null) {
          p.hyc();
        }
        boolean bool = ((Camera.Parameters)localObject2).isZoomSupported();
        if (!bool)
        {
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            break label218;
          }
          this.imt = new com.tencent.tinker.a.c.b();
          localObject1 = this.imt;
          if (localObject1 == null) {
            p.hyc();
          }
          localObject1 = new float[((com.tencent.tinker.a.c.b)localObject1).size()];
          localObject2 = this.imt;
          if (localObject2 == null) {
            p.hyc();
          }
          j = ((com.tencent.tinker.a.c.b)localObject2).size();
          i = 0;
          if (i >= j) {
            break;
          }
          localObject2 = this.imt;
          if (localObject2 == null) {
            p.hyc();
          }
          localObject1[i] = (((com.tencent.tinker.a.c.b)localObject2).keyAt(i) * 1.0F / 10.0F);
          i += 1;
          continue;
        }
        localObject1 = ((Camera.Parameters)localObject2).getZoomRatios();
        continue;
        arrayOfFloat = null;
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "getZoom error: %s", new Object[] { localException.getMessage() });
      }
      continue;
      int k = ((Number)arrayOfFloat.get(arrayOfFloat.size() - 1)).intValue();
      int j = k;
      int i = 1;
      while (j / 10 >= 10)
      {
        i *= 10;
        j /= 10;
      }
      int m = k / i;
      j = m;
      if ((k + 4) / i > m) {
        j = m + 1;
      }
      this.imt = new com.tencent.tinker.a.c.b(j);
      if (10 <= j)
      {
        k = 10;
        if (arrayOfFloat.indexOf(Integer.valueOf(k * i)) < 0)
        {
          m = 1;
          if (m <= 4)
          {
            if (arrayOfFloat.indexOf(Integer.valueOf(k * i - m)) <= 0) {
              break label393;
            }
            localObject2 = this.imt;
            if (localObject2 == null) {
              p.hyc();
            }
            ((com.tencent.tinker.a.c.b)localObject2).append(k, k * i - m);
          }
        }
        for (;;)
        {
          if (k == j) {
            break label474;
          }
          k += 1;
          break;
          if (arrayOfFloat.indexOf(Integer.valueOf(k * i + m)) > 0)
          {
            localObject2 = this.imt;
            if (localObject2 == null) {
              p.hyc();
            }
            ((com.tencent.tinker.a.c.b)localObject2).append(k, m + k * i);
          }
          else
          {
            m += 1;
            break label330;
            localObject2 = this.imt;
            if (localObject2 == null) {
              p.hyc();
            }
            ((com.tencent.tinker.a.c.b)localObject2).append(k, k * i);
          }
        }
      }
    }
    label330:
    AppMethodBeat.o(94033);
    label393:
    return arrayOfFloat;
  }
  
  public void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94032);
    if ((this.gGr != null) && (aPc())) {
      try
      {
        Log.d(this.TAG, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (this.aYc)
        {
          Log.d(this.TAG, "triggerSmallZoom, zooming, ignore");
          return;
        }
        Object localObject1 = this.gGr;
        if (localObject1 != null) {
          localObject1 = ((v)localObject1).getParameters();
        }
        int i;
        int j;
        while ((localObject1 != null) && (((Camera.Parameters)localObject1).isZoomSupported() == true))
        {
          this.aYc = true;
          i = ((Camera.Parameters)localObject1).getZoom();
          j = this.imu.indexOf(Integer.valueOf(i));
          int k = ((Camera.Parameters)localObject1).getMaxZoom();
          Log.d(this.TAG, "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(this.ilX), Integer.valueOf(this.ilW), Integer.valueOf(paramInt) });
          if (!paramBoolean) {
            break label349;
          }
          if (i >= k)
          {
            return;
            localObject1 = null;
          }
          else
          {
            if (j != this.imu.size() - 1) {
              break label316;
            }
            paramInt = ((Number)j.ku((List)this.imu)).intValue();
          }
        }
        for (;;)
        {
          Log.d(this.TAG, "triggerSmallZoom, nextZoom: %s, smoothZoomSupported: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(((Camera.Parameters)localObject1).isSmoothZoomSupported()) });
          ((Camera.Parameters)localObject1).setZoom(paramInt);
          Object localObject3 = this.gGr;
          if (localObject3 != null) {
            ((v)localObject3).setParameters((Camera.Parameters)localObject1);
          }
          return;
          label316:
          localObject3 = this.imu.get(j + 1);
          p.g(localObject3, "availableZoomRatioIndexList[currentZoomIndex + 1]");
          paramInt = ((Number)localObject3).intValue();
          continue;
          label349:
          if (i == 0) {
            return;
          }
          if (j == 0)
          {
            paramInt = ((Number)j.ks((List)this.imu)).intValue();
          }
          else
          {
            localObject3 = this.imu.get(j - 1);
            p.g(localObject3, "availableZoomRatioIndexList[currentZoomIndex - 1]");
            paramInt = ((Number)localObject3).intValue();
          }
        }
        AppMethodBeat.o(94032);
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYc = false;
        AppMethodBeat.o(94032);
      }
    }
  }
  
  public final void o(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.imw = paramb;
  }
  
  public final void release()
  {
    int j = 1;
    AppMethodBeat.i(94054);
    super.release();
    label416:
    for (;;)
    {
      try
      {
        Log.i(this.TAG, this.imm.getValue());
        Log.i(this.TAG, this.imn.getValue());
        Log.i(this.TAG, this.imo.getValue());
        Log.i(this.TAG, this.imp.getValue());
        Log.i(this.TAG, this.imq.getValue());
        if (this.gGr != null)
        {
          long l = Util.currentTicks();
          Log.i(this.TAG, "release camera beg, %s", new Object[] { Looper.myLooper() });
          this.ilK.removeCallbacksAndMessages(null);
          this.imv = true;
          if (this.ilS == null) {
            continue;
          }
          localObject = this.ilS;
          if (localObject != null)
          {
            localObject = ((b.a)localObject).ire;
            if (localObject == null) {
              continue;
            }
            localObject = this.ilS;
            if (localObject == null) {
              continue;
            }
            localObject = ((b.a)localObject).ire;
            if (localObject == null) {
              continue;
            }
            b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
            localObject = Boolean.valueOf(((HashSet)localObject).contains(b.b.aQD()));
            i = j;
            if (localObject == null) {
              break label416;
            }
            if (!p.j(localObject, Boolean.FALSE)) {
              continue;
            }
            i = j;
            break label416;
            if (localObject != null)
            {
              ((Boolean)localObject).booleanValue();
              localObject = this.gGr;
              if (localObject != null) {
                ((v)localObject).setPreviewCallback(null);
              }
            }
            localObject = this.gGr;
            if (localObject != null) {
              ((v)localObject).stopPreview();
            }
            localObject = this.gGr;
            if (localObject != null) {
              ((v)localObject).release();
            }
            this.gGr = null;
            Log.i(this.TAG, "release camera end, use %dms, %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
          }
        }
        else
        {
          this.ilK.imQ = true;
          this.ilV = null;
          this.ims = null;
          this.ilY = false;
          AppMethodBeat.o(94054);
          return;
        }
        Object localObject = null;
        continue;
        localObject = null;
        continue;
        int i = 0;
        break label416;
        localObject = null;
        continue;
        localObject = this.gGr;
        if (localObject != null)
        {
          ((v)localObject).setPreviewCallback(null);
          continue;
          if (i == 0) {}
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "cameraRelease error", new Object[0]);
        AppMethodBeat.o(94054);
        return;
      }
    }
  }
  
  public final boolean rp(int paramInt)
  {
    AppMethodBeat.i(218816);
    try
    {
      v localv = this.gGr;
      if (localv != null) {
        localv.getParameters();
      }
      AppMethodBeat.o(218816);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "open scene " + paramInt + " open failed, error:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(218816);
    }
    return false;
  }
  
  public final void rw(int paramInt)
  {
    AppMethodBeat.i(94031);
    if (this.ilW > 0)
    {
      AppMethodBeat.o(94031);
      return;
    }
    Object localObject = ao.az(MMApplicationContext.getContext());
    int i = ((Point)localObject).y;
    Log.i(this.TAG, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94031);
      return;
    }
    try
    {
      if (this.gGr != null)
      {
        localObject = this.gGr;
        if (localObject != null)
        {
          localObject = ((v)localObject).getParameters();
          if (localObject == null) {
            break label187;
          }
        }
        label187:
        for (i = ((Camera.Parameters)localObject).getMaxZoom();; i = 0)
        {
          double d = i / (paramInt / 3.0D / 10.0D);
          if (d > 0.0D) {
            this.ilW = ((int)d + 1);
          }
          Log.i(this.TAG, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.ilW), Integer.valueOf(i) });
          AppMethodBeat.o(94031);
          return;
          localObject = null;
          break;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94031);
    }
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(94057);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(94057);
      return;
      fb(false);
      AppMethodBeat.o(94057);
      return;
      fb(true);
    }
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(94034);
    if (this.aYc)
    {
      Log.d(this.TAG, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94034);
      return;
    }
    if (this.gGr != null) {
      try
      {
        Object localObject1 = this.gGr;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ((v)localObject1).getParameters();
        if (localObject1 == null) {
          p.hyc();
        }
        boolean bool = ((Camera.Parameters)localObject1).isZoomSupported();
        if (!bool) {
          return;
        }
        if (this.imt == null)
        {
          Log.d(this.TAG, "setForceZoomTargetRatio before init zoom info, ignore");
          return;
        }
        Object localObject3 = ((Camera.Parameters)localObject1).getZoomRatios();
        com.tencent.tinker.a.c.b localb = this.imt;
        if (localb == null) {
          p.hyc();
        }
        int i = ((List)localObject3).indexOf(Integer.valueOf(localb.get(kotlin.h.a.cR(10.0F * paramFloat))));
        if (i >= 0)
        {
          int j = ((Camera.Parameters)localObject1).getMaxZoom();
          if (i <= j) {}
        }
        else
        {
          return;
        }
        this.aYc = true;
        ((Camera.Parameters)localObject1).setZoom(i);
        localObject3 = this.gGr;
        if (localObject3 == null) {
          p.hyc();
        }
        ((v)localObject3).setParameters((Camera.Parameters)localObject1);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYc = false;
        AppMethodBeat.o(94034);
      }
    }
    AppMethodBeat.o(94034);
  }
  
  public final boolean v(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94019);
    p.h(paramContext, "context");
    for (;;)
    {
      try
      {
        if (this.ilY)
        {
          Log.i(this.TAG, "initCamera, already open");
          AppMethodBeat.o(94019);
          return true;
        }
        Object localObject = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNk();
        super.v(paramContext, paramBoolean);
        release();
        if (paramBoolean)
        {
          i = com.tencent.mm.compatible.deviceinfo.d.aog();
          Log.printInfoStack(this.TAG, "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(i), Integer.valueOf(ae.gKt.gGa) });
          this.imk = new e().a(paramContext, i, Looper.getMainLooper());
          Log.i(this.TAG, "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.imk == null)
          {
            Log.i(this.TAG, "open camera FAILED, %s", new Object[] { Looper.myLooper() });
            aPa();
            AppMethodBeat.o(94019);
            return false;
          }
        }
        else
        {
          i = com.tencent.mm.compatible.deviceinfo.d.aoh();
          continue;
        }
        paramContext = this.imk;
        if (paramContext != null)
        {
          paramContext = paramContext.gGr;
          this.gGr = paramContext;
          this.imv = false;
          paramContext = this.ilR;
          localObject = this.imk;
          if (localObject == null) {
            break label315;
          }
          i = ((d.a.a)localObject).dYT;
          paramContext.dYT = i;
          if (this.gGr == null)
          {
            Log.e(this.TAG, "start camera FAILED!");
            aPa();
            AppMethodBeat.o(94019);
            return false;
          }
          this.ilY = true;
          AppMethodBeat.o(94019);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramContext, "init camera failed!", new Object[0]);
        paramContext = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNm();
        AppMethodBeat.o(94019);
        return false;
      }
      paramContext = null;
      continue;
      label315:
      int i = 0;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "camera", "Landroid/hardware/Camera;", "kotlin.jvm.PlatformType", "onAutoFocus"})
  static final class a
    implements Camera.AutoFocusCallback
  {
    a(c paramc) {}
    
    public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
    {
      AppMethodBeat.i(218812);
      Log.v(c.a(this.imz), "auto focus callback success ".concat(String.valueOf(paramBoolean)));
      this.imz.ilK.imQ = true;
      if (!this.imz.imv) {
        try
        {
          p.g(paramCamera, "camera");
          Camera.Parameters localParameters = paramCamera.getParameters();
          p.g(localParameters, "camera.parameters");
          if ((localParameters.getFocusMode() != null) && (this.imz.ilK.imR != null))
          {
            localParameters.setFocusMode(this.imz.ilK.imR);
            paramCamera.setParameters(localParameters);
            AppMethodBeat.o(218812);
            return;
          }
        }
        catch (Exception paramCamera)
        {
          Log.e(c.a(this.imz), "auto focus return while camera is release");
        }
      }
      AppMethodBeat.o(218812);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/CommonCamera1$setPreviewCallbackImpl$1$1"})
  static final class b
    implements Camera.PreviewCallback
  {
    b(c paramc) {}
    
    public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      AppMethodBeat.i(94017);
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.length != 0) {
          break label38;
        }
      }
      label38:
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(c.a(this.imz), "onPreviewFrame, frame data is null!!");
        AppMethodBeat.o(94017);
        return;
      }
      if (this.imz.imj.size() <= 0)
      {
        paramCamera = this.imz.gGr;
        if (paramCamera != null)
        {
          paramCamera.addCallbackBuffer(paramArrayOfByte);
          AppMethodBeat.o(94017);
          return;
        }
        AppMethodBeat.o(94017);
        return;
      }
      paramCamera = paramArrayOfByte;
      Object localObject;
      long l1;
      if (!this.imz.imr)
      {
        paramCamera = paramArrayOfByte;
        if (this.imz.imj.size() > 0)
        {
          paramCamera = paramArrayOfByte;
          if (this.imz.ilV != null)
          {
            paramCamera = this.imz.ilV;
            if ((paramCamera != null) && (paramCamera.x == this.imz.ilR.sUz))
            {
              paramCamera = this.imz.ilV;
              if ((paramCamera != null) && (paramCamera.y == this.imz.ilR.sUA)) {
                break label573;
              }
            }
            paramCamera = k.zwi;
            i = this.imz.ilR.sUz;
            localObject = this.imz.ilV;
            if (localObject == null) {
              p.hyc();
            }
            paramCamera = paramCamera.h(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
            this.imz.imo.Hi(1L);
            l1 = Util.currentTicks();
            i = this.imz.ilR.sUz;
            int j = this.imz.ilR.sUA;
            localObject = this.imz.ilV;
            if (localObject == null) {
              p.hyc();
            }
            SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
            localObject = this.imz.ilV;
            if (localObject == null) {
              p.hyc();
            }
            if (((Point)localObject).x >= this.imz.ilR.sUz) {
              break label640;
            }
            localObject = k.zwi;
            Point localPoint = this.imz.ilV;
            if (localPoint == null) {
              p.hyc();
            }
            i = localPoint.x;
            localPoint = this.imz.ilV;
            if (localPoint == null) {
              p.hyc();
            }
            localObject = ((k)localObject).h(Integer.valueOf(i * localPoint.y * 3 / 2));
            i = this.imz.ilR.sUz;
            localPoint = this.imz.ilV;
            if (localPoint == null) {
              p.hyc();
            }
            j = localPoint.x;
            localPoint = this.imz.ilV;
            if (localPoint == null) {
              p.hyc();
            }
            SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
            k.zwi.k(paramCamera);
            paramCamera = (Camera)localObject;
          }
        }
      }
      label640:
      for (;;)
      {
        long l2 = Util.ticksToNow(l1);
        this.imz.imp.Hi(l2);
        localObject = this.imz;
        p.g(paramCamera, "curFrameData");
        boolean bool = ((c)localObject).ah(paramCamera);
        l1 = Util.ticksToNow(l1);
        paramCamera = paramArrayOfByte;
        if (bool)
        {
          this.imz.imq.Hi(l1);
          paramCamera = paramArrayOfByte;
        }
        for (;;)
        {
          paramArrayOfByte = this.imz.gGr;
          if (paramArrayOfByte == null) {
            break;
          }
          paramArrayOfByte.addCallbackBuffer(paramCamera);
          AppMethodBeat.o(94017);
          return;
          label573:
          l1 = Util.currentTicks();
          bool = this.imz.ah(paramArrayOfByte);
          l1 = Util.ticksToNow(l1);
          if (bool) {
            this.imz.imq.Hi(l1);
          }
          paramCamera = paramArrayOfByte;
          if (bool) {
            paramCamera = k.zwi.h(Integer.valueOf(paramArrayOfByte.length));
          }
        }
        AppMethodBeat.o(94017);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "ca", "Landroid/hardware/Camera;", "onPreviewFrame"})
  static final class c
    implements Camera.PreviewCallback
  {
    c(c paramc) {}
    
    public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      boolean bool = false;
      AppMethodBeat.i(94018);
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.length != 0) {
          break label51;
        }
      }
      label51:
      for (int i = 1; (i != 0) || (this.imz.gGr == null); i = 0)
      {
        Log.e(c.a(this.imz), "onPreviewFrame, frame data is null!!");
        AppMethodBeat.o(94018);
        return;
      }
      Object localObject;
      long l1;
      int j;
      if ((!this.imz.imr) && (this.imz.imj != null) && (this.imz.imj.size() > 0)) {
        if (this.imz.ilV != null)
        {
          paramCamera = k.zwi;
          i = this.imz.ilR.sUz;
          localObject = this.imz.ilV;
          if (localObject == null) {
            p.hyc();
          }
          paramCamera = paramCamera.h(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
          this.imz.imo.Hi(1L);
          l1 = Util.currentTicks();
          i = this.imz.ilR.sUz;
          j = this.imz.ilR.sUA;
          localObject = this.imz.ilV;
          if (localObject == null) {
            p.hyc();
          }
          SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
          localObject = this.imz.ilV;
          if (localObject == null) {
            p.hyc();
          }
          if (((Point)localObject).x >= this.imz.ilR.sUz) {
            break label738;
          }
          localObject = k.zwi;
          Point localPoint = this.imz.ilV;
          if (localPoint == null) {
            p.hyc();
          }
          i = localPoint.x;
          localPoint = this.imz.ilV;
          if (localPoint == null) {
            p.hyc();
          }
          localObject = ((k)localObject).h(Integer.valueOf(i * localPoint.y * 3 / 2));
          i = this.imz.ilR.sUz;
          localPoint = this.imz.ilV;
          if (localPoint == null) {
            p.hyc();
          }
          j = localPoint.x;
          localPoint = this.imz.ilV;
          if (localPoint == null) {
            p.hyc();
          }
          SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
          k.zwi.k(paramCamera);
          paramCamera = (Camera)localObject;
        }
      }
      label738:
      for (;;)
      {
        long l2 = Util.ticksToNow(l1);
        this.imz.imp.Hi(l2);
        if (!this.imz.ilM)
        {
          l1 = Util.currentTicks();
          localObject = this.imz.ilV;
          if (localObject == null) {
            p.hyc();
          }
          i = ((Point)localObject).x;
          localObject = this.imz.ilV;
          if (localObject == null) {
            p.hyc();
          }
          j = ((Point)localObject).y;
          localObject = this.imz.imk;
          if (localObject == null) {
            p.hyc();
          }
          if (((d.a.a)localObject).dYT != 270)
          {
            localObject = this.imz.imk;
            if (localObject == null) {
              p.hyc();
            }
            if (((d.a.a)localObject).dYT != 90) {}
          }
          else
          {
            bool = true;
            SightVideoJNI.mirrorCameraData(paramCamera, i, j, bool);
          }
        }
        else
        {
          localObject = this.imz;
          p.g(paramCamera, "curFrameData");
          bool = ((c)localObject).ah(paramCamera);
          l1 = Util.ticksToNow(l1);
          if (bool) {
            this.imz.imq.Hi(l1);
          }
        }
        for (;;)
        {
          this.imz.ims = paramCamera;
          paramCamera = this.imz.gGr;
          if (paramCamera == null) {
            p.hyc();
          }
          paramCamera.addCallbackBuffer(paramArrayOfByte);
          AppMethodBeat.o(94018);
          return;
          bool = false;
          break;
          if (!this.imz.ilM)
          {
            i = this.imz.ilR.sUz;
            j = this.imz.ilR.sUA;
            paramCamera = this.imz.imk;
            if (paramCamera == null) {
              p.hyc();
            }
            if (paramCamera.dYT != 270)
            {
              paramCamera = this.imz.imk;
              if (paramCamera == null) {
                p.hyc();
              }
              if (paramCamera.dYT != 90) {}
            }
            else
            {
              bool = true;
            }
            SightVideoJNI.mirrorCameraData(paramArrayOfByte, i, j, bool);
          }
          this.imz.ah(paramArrayOfByte);
          paramCamera = paramArrayOfByte;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.c
 * JD-Core Version:    0.7.0.1
 */