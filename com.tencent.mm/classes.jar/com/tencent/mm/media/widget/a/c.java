package com.tencent.mm.media.widget.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
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
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "", "availableZoomRatioIndexList", "Ljava/util/ArrayList;", "", "getAvailableZoomRatioIndexList", "()Ljava/util/ArrayList;", "bCameraReleased", "", "getBCameraReleased$plugin_mediaeditor_release", "()Z", "setBCameraReleased$plugin_mediaeditor_release", "(Z)V", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "cameraCallback", "Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "getCameraCallback", "()Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "cameraCropCallback", "getCameraCropCallback", "cameraPreviewCallback", "getCameraPreviewCallback", "currentFrameData", "", "getCurrentFrameData", "()[B", "setCurrentFrameData", "([B)V", "finishCallbackTimeCallback", "getFinishCallbackTimeCallback", "frameDataCallbackList", "", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getFrameDataCallbackList", "()Ljava/util/List;", "setFrameDataCallbackList", "(Ljava/util/List;)V", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mCameraFps", "getMCameraFps", "()I", "setMCameraFps", "(I)V", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mZoomTimesToRatio", "Lcom/tencent/tinker/android/utils/SparseIntArray;", "getMZoomTimesToRatio", "()Lcom/tencent/tinker/android/utils/SparseIntArray;", "setMZoomTimesToRatio", "(Lcom/tencent/tinker/android/utils/SparseIntArray;)V", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "openCameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "getOpenCameraRes", "()Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "setOpenCameraRes", "(Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;)V", "prevcameraCallback", "getPrevcameraCallback", "sAutoFocusCallback", "Landroid/hardware/Camera$AutoFocusCallback;", "getSAutoFocusCallback", "()Landroid/hardware/Camera$AutoFocusCallback;", "setSAutoFocusCallback", "(Landroid/hardware/Camera$AutoFocusCallback;)V", "takePictureLock", "getTakePictureLock", "setTakePictureLock", "addFrameDataCallback", "callback", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateLocDiff", "loc1", "loc2", "calculateTapArea", "Landroid/graphics/Rect;", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "checkCameraOpenSucc", "scene", "configVendorTagValue", "tag", "value", "dispatchCameraFrame", "frame", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "parameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCameraSensorRotate", "getCurrentCameraId", "getDeviceRotation", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getPreviewWidth", "getSupportPreviewSize", "", "Landroid/util/Size;", "()[Landroid/util/Size;", "getSupportZoomRatios", "", "initCamera", "useBack", "initRawRatios", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "safeResetZoom", "safeSetFocusMode", "safeSetMetering", "safeSetPreviewFormat", "safeSetPreviewFrameRate", "useFixMode", "safeSetPreviewSize", "resolutionLimit", "safeSetPreviewSizeWithLimitAndRatio", "sizeLimit", "displayRatio", "safeSetStabilization", "selectRatioAndResolutionLimitPreviewSize", "ratio", "longSideLimit", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "setPreviewCallbackImpl", "setPreviewCallbackImplInGPUCrop", "setPreviewSize", "width", "height", "setSafeConfig", "startPreview", "useCpuCrop", "(Landroid/graphics/SurfaceTexture;ZLjava/lang/Float;I)V", "startPreviewWithCPU", "startPreviewWithCPURatio", "startPreviewWithGPU", "startPreviewWithGPURatio", "switchVendorTag", "isChecked", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "p", "trySetPreviewFrameRateParameters", "plugin-mediaeditor_release"})
public class c
  extends a
{
  private final String TAG;
  w jqD;
  private float lbi;
  List<g> lbj;
  d.a.a lbk;
  private Camera.AutoFocusCallback lbl;
  private final com.tencent.mm.plugin.mmsight.model.c lbm;
  private final com.tencent.mm.plugin.mmsight.model.c lbn;
  final com.tencent.mm.plugin.mmsight.model.c lbo;
  final com.tencent.mm.plugin.mmsight.model.c lbp;
  final com.tencent.mm.plugin.mmsight.model.c lbq;
  volatile boolean lbr;
  volatile byte[] lbt;
  private com.tencent.tinker.a.c.b lbu;
  private final ArrayList<Integer> lbv;
  boolean lbw;
  private kotlin.g.a.b<? super Boolean, x> lbx;
  private int lby;
  boolean lbz;
  private final Object lock;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94058);
    this.TAG = "MicroMsg.CommonCamera1";
    this.lbi = 10.0F;
    this.lbj = ((List)new ArrayList());
    this.lbl = ((Camera.AutoFocusCallback)new a(this));
    this.lbm = new com.tencent.mm.plugin.mmsight.model.c("prevcameraCallback");
    this.lbn = new com.tencent.mm.plugin.mmsight.model.c("cameraCallback");
    this.lbo = new com.tencent.mm.plugin.mmsight.model.c("cameraPreviewCallback");
    this.lbp = new com.tencent.mm.plugin.mmsight.model.c("cameraCropCallback");
    this.lbq = new com.tencent.mm.plugin.mmsight.model.c("finishCallbackTimeCallback");
    this.lbv = new ArrayList();
    this.lock = new Object();
    this.lbz = true;
    AppMethodBeat.o(94058);
  }
  
  private final void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(94024);
    long l = Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithCPU,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (aXQ())
    {
      Log.i(this.TAG, "startPreviewWithCPU, camera previewing");
      AppMethodBeat.o(94024);
      return;
    }
    try
    {
      uq(paramInt);
      aYd();
      aYg();
      if (a(paramSurfaceTexture, paramSurfaceHolder)) {
        a(a.a.lbb);
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
        paramSurfaceTexture = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aVQ();
      }
    }
  }
  
  private final void aYg()
  {
    AppMethodBeat.i(94046);
    if (this.jqD == null)
    {
      AppMethodBeat.o(94046);
      return;
    }
    try
    {
      if (this.jqD == null) {
        break label240;
      }
      Object localObject1 = this.jqD;
      if (localObject1 != null)
      {
        localObject1 = ((w)localObject1).avd();
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
    int i = this.laR.wAw;
    int j = this.laR.wAx;
    j = ImageFormat.getBitsPerPixel(localException.getPreviewFormat()) * (i * j) / 8;
    Log.i(this.TAG, "setPreviewCallbackImpl  size: ".concat(String.valueOf(j)));
    i = 0;
    for (;;)
    {
      Object localObject2;
      if (i < 5)
      {
        localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(j));
        w localw = this.jqD;
        if (localw != null) {
          localw.aj((byte[])localObject2);
        }
      }
      else
      {
        this.lbm.reset();
        this.lbn.reset();
        this.lbo.reset();
        this.lbp.reset();
        this.lbq.reset();
        localObject2 = this.jqD;
        if (localObject2 != null)
        {
          ((w)localObject2).b((Camera.PreviewCallback)new c(this));
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
  
  private final boolean b(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(258346);
    if ((this.jqD == null) || (this.lbk == null))
    {
      Log.e(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(258346);
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = this.jqD;
        if (localObject1 != null)
        {
          localParameters = ((w)localObject1).avd();
          if (localParameters != null) {}
        }
        else
        {
          AppMethodBeat.o(258346);
          return false;
        }
        localObject1 = localParameters.getSupportedPreviewSizes();
        kotlin.g.b.p.j(localObject1, "parameter.supportedPreviewSizes");
        kotlin.a.j.a((Iterable)localObject1, (Comparator)new c.b());
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label385;
        }
        localObject1 = localIterator.next();
        Camera.Size localSize = (Camera.Size)localObject1;
        if ((Math.abs(localSize.width * 1.0F / localSize.height - paramFloat) > 0.1D) || (localSize.width > paramInt)) {
          break label380;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Camera.Parameters localParameters;
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(258346);
        return false;
      }
      localObject1 = (Camera.Size)localObject1;
      if (localObject1 == null)
      {
        AppMethodBeat.o(258346);
        return false;
      }
      localParameters.setPreviewSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
      this.laR.wAw = ((Camera.Size)localObject1).width;
      this.laR.wAx = ((Camera.Size)localObject1).height;
      this.laW = new Point(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
      Log.i(this.TAG, "selectRatioAndResolutionLimitPreviewSize final select target:" + ((Camera.Size)localObject1).width + 'x' + ((Camera.Size)localObject1).height);
      localObject1 = this.jqD;
      if (localObject1 != null) {
        ((w)localObject1).c(localParameters);
      }
      AppMethodBeat.o(258346);
      return true;
      for (;;)
      {
        if (i == 0) {
          break label383;
        }
        break;
        label380:
        i = 0;
      }
      label383:
      continue;
      label385:
      Object localObject2 = null;
    }
  }
  
  private boolean k(int paramInt, float paramFloat)
  {
    Object localObject4 = null;
    AppMethodBeat.i(94026);
    if ((this.jqD == null) || (paramInt <= 0))
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
      localObject1 = this.jqD;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localParameters = ((w)localObject1).avd();
      if (this.laU != null) {
        break label538;
      }
      localObject1 = ar.au(MMApplicationContext.getContext());
      localPoint = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
      Log.i(this.TAG, "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject1 });
      float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
      f2 = 1.0F / paramFloat;
      if (paramFloat >= 1.0F) {
        break label592;
      }
      i = paramInt;
      Log.i(this.TAG, "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
      localObject1 = this.lbk;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      if (((d.a.a)localObject1).fSM == 90) {
        break label623;
      }
      localObject1 = this.lbk;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      if (((d.a.a)localObject1).fSM != 270) {
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
      localObject3 = ((h.c)localObject1).EZN;
      label280:
      if (localObject3 == null)
      {
        Log.e(this.TAG, "fuck, preview size still null!!");
        if (localParameters == null) {
          kotlin.g.b.p.iCn();
        }
        localObject1 = this.lbk;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        if (((d.a.a)localObject1).fSM == 90) {
          break label629;
        }
        localObject1 = this.lbk;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        if (((d.a.a)localObject1).fSM != 270) {
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
        localObject3 = ((h.c)localObject1).EZN;
      }
      if (localObject3 != null)
      {
        localObject1 = ((h.c)localObject1).EZN;
        this.laR.wAw = ((Point)localObject1).x;
        this.laR.wAx = ((Point)localObject1).y;
        this.laW = null;
        Log.i(aXE(), "final set camera preview size: : %s, cropSize: %s", new Object[] { localObject1, this.laW });
        if (localParameters == null) {
          kotlin.g.b.p.iCn();
        }
        localParameters.setPreviewSize(this.laR.wAw, this.laR.wAx);
        localObject1 = this.jqD;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        ((w)localObject1).c(localParameters);
        AppMethodBeat.o(94026);
        return true;
      }
      label538:
      Object localObject2 = this.laU;
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      i = ((Size)localObject2).getWidth();
      localObject2 = this.laU;
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
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
  
  private final boolean uq(int paramInt)
  {
    AppMethodBeat.i(94048);
    if ((this.jqD == null) || (this.lbk == null))
    {
      Log.d(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(94048);
      return false;
    }
    Object localObject1 = this.lbk;
    boolean bool;
    if ((localObject1 == null) || (((d.a.a)localObject1).fSM != 90))
    {
      localObject1 = this.lbk;
      if ((localObject1 == null) || (((d.a.a)localObject1).fSM != 270)) {}
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
        if (this.laU != null) {
          break label178;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.hv(getContext());
        localObject3 = this.jqD;
        if (localObject3 != null)
        {
          localParameters = ((w)localObject3).avd();
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
      localObject2 = this.laU;
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      int i = ((Size)localObject2).getWidth();
      localObject2 = this.laU;
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject2 = new Point(i, ((Size)localObject2).getHeight());
    }
    h.c localc = h.c(localParameters, (Point)localObject2, paramInt, bool);
    if (localc != null) {}
    for (Object localObject3 = localc.EZN;; localObject3 = null)
    {
      if (localObject3 == null) {
        Log.e(this.TAG, "fuck, preview size still null!!");
      }
      for (localObject2 = h.d(localParameters, new Point(Math.min(((Point)localObject2).x, ((Point)localObject2).y), Math.max(((Point)localObject2).x, ((Point)localObject2).y)), aXF(), bool);; localObject2 = localc)
      {
        if (((h.c)localObject2).EZN == null)
        {
          Log.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject2).toString() });
          ((h.c)localObject2).EZN = ((h.c)localObject2).EZQ;
          ((h.c)localObject2).EZO = ((h.c)localObject2).EZR;
          ((h.c)localObject2).EZP = ((h.c)localObject2).EZS;
        }
        localObject3 = ((h.c)localObject2).EZN;
        if (localObject3 == null)
        {
          k.eTu();
          AppMethodBeat.o(94048);
          return false;
        }
        this.laR.wAw = ((Point)localObject3).x;
        this.laR.wAx = ((Point)localObject3).y;
        this.laW = ((Point)localObject3);
        if (((h.c)localObject2).EZO != null) {
          this.laW = ((h.c)localObject2).EZO;
        }
        Log.i(this.TAG, "final set camera preview size: " + localObject3 + ", cropSize: " + this.laW);
        localParameters.setPreviewSize(((Point)localObject3).x, ((Point)localObject3).y);
        localObject2 = this.jqD;
        if (localObject2 != null) {
          ((w)localObject2).c(localParameters);
        }
        AppMethodBeat.o(94048);
        return true;
      }
    }
  }
  
  public final void D(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94052);
    kotlin.g.b.p.k(paramString, "tag");
    AppMethodBeat.o(94052);
  }
  
  public final Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(258391);
    paramFloat3 = 80.0F * paramFloat3;
    Object localObject1 = new RectF();
    float f1 = Math.max(paramFloat1 - paramFloat3, 0.0F);
    float f2 = Math.min(paramFloat1 + paramFloat3, paramInt1);
    ((RectF)localObject1).set(f1, Math.max(paramFloat2 - paramFloat3, 0.0F), f2, Math.min(paramFloat2 + paramFloat3, paramInt2));
    if (aXJ() != null)
    {
      aXI();
      int j = b.aVp();
      Object localObject2 = getContext();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(258391);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((Activity)localObject2).getWindowManager();
      kotlin.g.b.p.j(localObject2, "(context as Activity).windowManager");
      localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
      kotlin.g.b.p.j(localObject2, "(context as Activity).windowManager.defaultDisplay");
      int i;
      switch (((Display)localObject2).getRotation())
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        localObject2 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
        Object localObject3 = com.tencent.mm.media.widget.d.b.lio;
        aXI();
        boolean bool = b.isFrontCamera();
        paramFloat1 = (j - i + 360) % 360;
        localObject3 = com.tencent.mm.media.widget.d.b.lio;
        RectF localRectF = com.tencent.mm.media.widget.d.b.bat();
        kotlin.g.b.p.k(localRectF, "cameraRect");
        kotlin.g.b.p.k(localObject2, "previewRect");
        localObject3 = new RectF();
        com.tencent.mm.media.widget.d.b.a(bool, paramFloat1, localRectF, (RectF)localObject2).mapRect((RectF)localObject3, (RectF)localObject1);
        localObject1 = new Rect();
        ((RectF)localObject3).round((Rect)localObject1);
        Log.i(this.TAG, "calculateTapArea ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(258391);
        return localObject1;
        i = 0;
        continue;
        i = 90;
        continue;
        i = 180;
        continue;
        i = 270;
      }
    }
    aXI();
    paramFloat1 /= paramInt1;
    paramFloat2 /= paramInt2;
    paramFloat1 = paramFloat1 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    paramFloat2 = paramFloat2 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    localObject1 = new RectF();
    ((RectF)localObject1).set(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat3 + paramFloat2);
    localObject1 = new Rect(androidx.core.b.a.clamp(kotlin.h.a.dm(((RectF)localObject1).left), -1000, 1000), androidx.core.b.a.clamp(kotlin.h.a.dm(((RectF)localObject1).top), -1000, 1000), androidx.core.b.a.clamp(kotlin.h.a.dm(((RectF)localObject1).right), -1000, 1000), androidx.core.b.a.clamp(kotlin.h.a.dm(((RectF)localObject1).bottom), -1000, 1000));
    AppMethodBeat.o(258391);
    return localObject1;
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
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, Float paramFloat, int paramInt)
  {
    AppMethodBeat.i(258330);
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    a(paramFloat);
    if (paramFloat != null)
    {
      if (paramBoolean)
      {
        f = paramFloat.floatValue();
        l = Util.currentTicks();
        Log.i(this.TAG, "start startPreviewWithCPURatio,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + paramSurfaceTexture + ", surface:" + null);
        if (aXQ())
        {
          Log.i(this.TAG, "startPreviewWithCPU, camera previewing");
          AppMethodBeat.o(258330);
          return;
        }
        try
        {
          if (!b(f, paramInt))
          {
            b(paramSurfaceTexture, null, paramInt);
            AppMethodBeat.o(258330);
            return;
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
          paramSurfaceTexture = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aVQ();
        }
        for (;;)
        {
          Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
          AppMethodBeat.o(258330);
          return;
          aYd();
          aYg();
          if (a(paramSurfaceTexture, null)) {
            a(a.a.lbb);
          }
        }
      }
      float f = paramFloat.floatValue();
      long l = Util.currentTicks();
      Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + null);
      if (aXQ())
      {
        Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
        AppMethodBeat.o(258330);
        return;
      }
      try
      {
        if (!b(f, paramInt))
        {
          b(paramSurfaceTexture, null, paramInt);
          AppMethodBeat.o(258330);
          return;
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aVQ();
      }
      for (;;)
      {
        Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
        AppMethodBeat.o(258330);
        return;
        aYd();
        if (aXH()) {
          aYh();
        }
        if (a(paramSurfaceTexture, null)) {
          a(a.a.lbb);
        }
      }
    }
    a(paramSurfaceTexture, paramBoolean, paramInt);
    AppMethodBeat.o(258330);
  }
  
  protected void a(Camera.Parameters paramParameters, int paramInt)
  {
    AppMethodBeat.i(258342);
    kotlin.g.b.p.k(paramParameters, "p");
    if (af.juH.jpZ > 0)
    {
      Log.i(aXE(), "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(258342);
      return;
    }
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(258342);
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
          Log.i(aXE(), "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(30) });
          if ((j == 2147483647) || (k == 2147483647))
          {
            AppMethodBeat.o(258342);
            return;
          }
          try
          {
            paramParameters.setPreviewFpsRange(j, k);
            Log.i(aXE(), "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            AppMethodBeat.o(258342);
            return;
          }
          catch (Exception paramParameters)
          {
            Log.i(aXE(), "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
            AppMethodBeat.o(258342);
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
      this.lbj.add(paramg);
      AppMethodBeat.o(94020);
      return;
    }
  }
  
  public final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94027);
    w localw = this.jqD;
    if (localw != null)
    {
      if ((paramSurfaceTexture != null) || (paramSurfaceHolder != null))
      {
        if (paramSurfaceTexture != null) {
          localw.f(paramSurfaceTexture);
        }
        for (;;)
        {
          localw.ave();
          Log.i(this.TAG, "doStartPreview finish");
          paramSurfaceTexture = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aVP();
          AppMethodBeat.o(94027);
          return true;
          localw.a(paramSurfaceHolder);
        }
      }
      Log.i(this.TAG, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aVQ();
      AppMethodBeat.o(94027);
      return false;
    }
    AppMethodBeat.o(94027);
    return false;
  }
  
  protected boolean a(w paramw)
  {
    AppMethodBeat.i(94042);
    if (paramw == null)
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
        localParameters = paramw.avd();
        kotlin.g.b.p.j(localParameters, "p");
        localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          Log.i(this.TAG, "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          this.laK.lbS = localParameters.getFocusMode();
          paramw.c(localParameters);
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
      catch (Exception paramw)
      {
        Log.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
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
  
  protected final boolean a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(94041);
    if (paramw == null)
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
        localParameters = paramw.avd();
        if (!paramBoolean) {
          break label316;
        }
        i = this.lby;
        Object localObject1;
        if (af.juH.jpZ > 0)
        {
          Log.i(aXE(), "set frame rate > 0, do not try set preview frame rate");
          kotlin.g.b.p.j(localParameters, "p");
          localObject1 = localParameters.getSupportedPreviewFrameRates();
          Log.i(aXE(), "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localObject1 });
          paramw.c(localParameters);
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
            kotlin.g.b.p.j(localObject1, "Collections.max(fr)");
            i = Math.min(i, ((Number)localObject1).intValue());
            localParameters.setPreviewFrameRate(i);
            Log.i(aXE(), "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
        }
        catch (Exception localException)
        {
          Log.i(aXE(), "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        }
      }
      catch (Exception paramw)
      {
        Log.i(aXE(), "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
        AppMethodBeat.o(94041);
        return false;
      }
      for (;;)
      {
        break;
        Object localObject2 = Collections.max((Collection)localException);
        kotlin.g.b.p.j(localObject2, "Collections.max(fr)");
        i = Math.min(30, ((Number)localObject2).intValue());
      }
      label316:
      kotlin.g.b.p.j(localParameters, "p");
      a(localParameters, this.lby);
    }
  }
  
  public final int aXT()
  {
    AppMethodBeat.i(258378);
    Object localObject = this.jqD;
    if (localObject != null)
    {
      localObject = ((w)localObject).avd();
      if (localObject != null)
      {
        int i = ((Camera.Parameters)localObject).getPreviewFrameRate();
        AppMethodBeat.o(258378);
        return i;
      }
    }
    AppMethodBeat.o(258378);
    return 0;
  }
  
  public final boolean aXU()
  {
    AppMethodBeat.i(258383);
    if ((kotlin.g.b.p.h(this.laK.lbS, "auto") ^ true))
    {
      AppMethodBeat.o(258383);
      return false;
    }
    w localw = this.jqD;
    if (localw != null) {
      localw.a(null);
    }
    AppMethodBeat.o(258383);
    return true;
  }
  
  public final boolean aXV()
  {
    boolean bool2 = false;
    d.a.a locala = this.lbk;
    boolean bool1 = bool2;
    if (locala != null) {
      if (locala.fSM != 90)
      {
        bool1 = bool2;
        if (locala.fSM != 270) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Size[] aXW()
  {
    AppMethodBeat.i(258354);
    Object localObject = this.jqD;
    if (localObject != null)
    {
      localObject = ((w)localObject).avd();
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
          AppMethodBeat.o(258354);
          return arrayOfSize;
        }
      }
    }
    AppMethodBeat.o(258354);
    return null;
  }
  
  protected final com.tencent.mm.plugin.mmsight.model.c aYb()
  {
    return this.lbm;
  }
  
  protected final com.tencent.mm.plugin.mmsight.model.c aYc()
  {
    return this.lbn;
  }
  
  /* Error */
  public void aYd()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 1045
    //   5: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 1051	com/tencent/mm/plugin/mmsight/model/a/k:eTI	()Lcom/tencent/mm/plugin/mmsight/model/a/k;
    //   11: astore 8
    //   13: aload 8
    //   15: ldc_w 1053
    //   18: invokestatic 523	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload 8
    //   23: invokevirtual 1057	com/tencent/mm/plugin/mmsight/model/a/k:eTJ	()Lcom/tencent/mm/plugin/mmsight/SightParams;
    //   26: ifnull +943 -> 969
    //   29: invokestatic 1051	com/tencent/mm/plugin/mmsight/model/a/k:eTI	()Lcom/tencent/mm/plugin/mmsight/model/a/k;
    //   32: astore 8
    //   34: aload 8
    //   36: ldc_w 1053
    //   39: invokestatic 523	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   42: aload 8
    //   44: invokevirtual 1057	com/tencent/mm/plugin/mmsight/model/a/k:eTJ	()Lcom/tencent/mm/plugin/mmsight/SightParams;
    //   47: getfield 1062	com/tencent/mm/plugin/mmsight/SightParams:EYs	I
    //   50: invokestatic 491	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: astore 9
    //   55: aload_0
    //   56: getfield 281	com/tencent/mm/media/widget/a/c:TAG	Ljava/lang/String;
    //   59: astore 10
    //   61: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   64: getfield 1065	com/tencent/mm/compatible/deviceinfo/c:jqe	I
    //   67: iconst_1
    //   68: if_icmpne +720 -> 788
    //   71: ldc_w 1067
    //   74: astore 8
    //   76: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   79: getfield 1070	com/tencent/mm/compatible/deviceinfo/c:jqf	I
    //   82: iconst_1
    //   83: if_icmpne +731 -> 814
    //   86: iconst_1
    //   87: istore 4
    //   89: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   92: getfield 1073	com/tencent/mm/compatible/deviceinfo/c:jqg	I
    //   95: iconst_1
    //   96: if_icmpne +724 -> 820
    //   99: iconst_1
    //   100: istore 5
    //   102: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   105: getfield 1076	com/tencent/mm/compatible/deviceinfo/c:jqh	I
    //   108: iconst_1
    //   109: if_icmpne +717 -> 826
    //   112: iconst_1
    //   113: istore 6
    //   115: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   118: getfield 1079	com/tencent/mm/compatible/deviceinfo/c:jqi	I
    //   121: iconst_1
    //   122: if_icmpne +710 -> 832
    //   125: iconst_1
    //   126: istore 7
    //   128: aload 10
    //   130: ldc_w 1081
    //   133: bipush 6
    //   135: anewarray 324	java/lang/Object
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
    //   152: invokestatic 997	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   155: aastore
    //   156: dup
    //   157: iconst_3
    //   158: iload 5
    //   160: invokestatic 997	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   163: aastore
    //   164: dup
    //   165: iconst_4
    //   166: iload 6
    //   168: invokestatic 997	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   171: aastore
    //   172: dup
    //   173: iconst_5
    //   174: iload 7
    //   176: invokestatic 997	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   179: aastore
    //   180: invokestatic 418	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   186: getfield 1065	com/tencent/mm/compatible/deviceinfo/c:jqe	I
    //   189: iconst_1
    //   190: if_icmpne +648 -> 838
    //   193: aload 9
    //   195: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   198: ifeq +12 -> 210
    //   201: aload 9
    //   203: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   206: iconst_1
    //   207: if_icmpne +631 -> 838
    //   210: iconst_0
    //   211: istore 4
    //   213: iload 4
    //   215: istore 5
    //   217: aload_0
    //   218: getfield 1086	com/tencent/mm/media/widget/a/a:laS	Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   221: ifnull +183 -> 404
    //   224: aload_0
    //   225: getfield 1086	com/tencent/mm/media/widget/a/a:laS	Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   228: astore 8
    //   230: aload 8
    //   232: ifnull +639 -> 871
    //   235: aload 8
    //   237: getfield 1092	com/tencent/mm/media/widget/camerarecordview/d/b$a:lgh	Ljava/util/HashMap;
    //   240: astore 8
    //   242: iload 4
    //   244: istore 5
    //   246: aload 8
    //   248: ifnull +156 -> 404
    //   251: aload_0
    //   252: getfield 1086	com/tencent/mm/media/widget/a/a:laS	Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   255: astore 8
    //   257: aload 8
    //   259: ifnull +618 -> 877
    //   262: aload 8
    //   264: getfield 1092	com/tencent/mm/media/widget/camerarecordview/d/b$a:lgh	Ljava/util/HashMap;
    //   267: astore 8
    //   269: aload 8
    //   271: ifnull +606 -> 877
    //   274: aload 8
    //   276: aload_0
    //   277: invokevirtual 1095	com/tencent/mm/media/widget/a/c:aYi	()I
    //   280: invokestatic 491	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: invokevirtual 1100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   286: checkcast 1102	com/tencent/mm/media/widget/camerarecordview/d/b$a$c
    //   289: astore 8
    //   291: iload 4
    //   293: istore 5
    //   295: aload 8
    //   297: ifnull +107 -> 404
    //   300: aload_0
    //   301: getfield 1086	com/tencent/mm/media/widget/a/a:laS	Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   304: astore 8
    //   306: iload 4
    //   308: istore 5
    //   310: aload 8
    //   312: ifnull +92 -> 404
    //   315: aload 8
    //   317: getfield 1092	com/tencent/mm/media/widget/camerarecordview/d/b$a:lgh	Ljava/util/HashMap;
    //   320: astore 8
    //   322: iload 4
    //   324: istore 5
    //   326: aload 8
    //   328: ifnull +76 -> 404
    //   331: aload 8
    //   333: aload_0
    //   334: invokevirtual 1095	com/tencent/mm/media/widget/a/c:aYi	()I
    //   337: invokestatic 491	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: invokevirtual 1100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   343: checkcast 1102	com/tencent/mm/media/widget/camerarecordview/d/b$a$c
    //   346: astore 8
    //   348: iload 4
    //   350: istore 5
    //   352: aload 8
    //   354: ifnull +50 -> 404
    //   357: aload 8
    //   359: getfield 1106	com/tencent/mm/media/widget/camerarecordview/d/b$a$c:lgn	Ljava/lang/Integer;
    //   362: astore 10
    //   364: aload 10
    //   366: ifnull +15 -> 381
    //   369: aload_0
    //   370: aload 10
    //   372: checkcast 1012	java/lang/Number
    //   375: invokevirtual 1015	java/lang/Number:intValue	()I
    //   378: putfield 985	com/tencent/mm/media/widget/a/c:lby	I
    //   381: aload 8
    //   383: getfield 1110	com/tencent/mm/media/widget/camerarecordview/d/b$a$c:lgo	Ljava/lang/Boolean;
    //   386: astore 8
    //   388: iload 4
    //   390: istore 5
    //   392: aload 8
    //   394: ifnull +10 -> 404
    //   397: aload 8
    //   399: invokevirtual 1113	java/lang/Boolean:booleanValue	()Z
    //   402: istore 5
    //   404: aload_0
    //   405: aload_0
    //   406: getfield 438	com/tencent/mm/media/widget/a/c:jqD	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   409: iload 5
    //   411: invokevirtual 1115	com/tencent/mm/media/widget/a/c:a	(Lcom/tencent/mm/compatible/deviceinfo/w;Z)Z
    //   414: pop
    //   415: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   418: getfield 1070	com/tencent/mm/compatible/deviceinfo/c:jqf	I
    //   421: iconst_1
    //   422: if_icmpne +29 -> 451
    //   425: aload 9
    //   427: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   430: ifeq +12 -> 442
    //   433: aload 9
    //   435: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   438: iconst_2
    //   439: if_icmpne +12 -> 451
    //   442: aload_0
    //   443: aload_0
    //   444: getfield 438	com/tencent/mm/media/widget/a/c:jqD	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   447: invokevirtual 1117	com/tencent/mm/media/widget/a/c:b	(Lcom/tencent/mm/compatible/deviceinfo/w;)Z
    //   450: pop
    //   451: getstatic 1121	com/tencent/mm/compatible/deviceinfo/af:juO	Lcom/tencent/mm/compatible/deviceinfo/y;
    //   454: getfield 1126	com/tencent/mm/compatible/deviceinfo/y:jtp	I
    //   457: iconst_m1
    //   458: if_icmpeq +30 -> 488
    //   461: getstatic 1121	com/tencent/mm/compatible/deviceinfo/af:juO	Lcom/tencent/mm/compatible/deviceinfo/y;
    //   464: getfield 1126	com/tencent/mm/compatible/deviceinfo/y:jtp	I
    //   467: iconst_1
    //   468: if_icmpne +20 -> 488
    //   471: bipush 14
    //   473: invokestatic 1131	com/tencent/mm/compatible/util/d:qX	(I)Z
    //   476: ifeq +12 -> 488
    //   479: aload_0
    //   480: aload_0
    //   481: getfield 438	com/tencent/mm/media/widget/a/c:jqD	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   484: invokevirtual 1133	com/tencent/mm/media/widget/a/c:c	(Lcom/tencent/mm/compatible/deviceinfo/w;)Z
    //   487: pop
    //   488: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   491: getfield 1076	com/tencent/mm/compatible/deviceinfo/c:jqh	I
    //   494: iconst_1
    //   495: if_icmpne +29 -> 524
    //   498: aload 9
    //   500: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   503: ifeq +12 -> 515
    //   506: aload 9
    //   508: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   511: iconst_4
    //   512: if_icmpne +12 -> 524
    //   515: aload_0
    //   516: aload_0
    //   517: getfield 438	com/tencent/mm/media/widget/a/c:jqD	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   520: invokevirtual 1135	com/tencent/mm/media/widget/a/c:a	(Lcom/tencent/mm/compatible/deviceinfo/w;)Z
    //   523: pop
    //   524: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   527: getfield 1079	com/tencent/mm/compatible/deviceinfo/c:jqi	I
    //   530: iconst_1
    //   531: if_icmpne +17 -> 548
    //   534: aload 9
    //   536: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   539: ifeq +9 -> 548
    //   542: aload 9
    //   544: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   547: pop
    //   548: aload_0
    //   549: getfield 438	com/tencent/mm/media/widget/a/c:jqD	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   552: astore 8
    //   554: aload 8
    //   556: ifnull +327 -> 883
    //   559: aload 8
    //   561: invokevirtual 444	com/tencent/mm/compatible/deviceinfo/w:avd	()Landroid/hardware/Camera$Parameters;
    //   564: astore 8
    //   566: aload 8
    //   568: ifnull +18 -> 586
    //   571: aload 8
    //   573: invokevirtual 1138	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   576: iconst_1
    //   577: if_icmpne +9 -> 586
    //   580: aload 8
    //   582: iconst_0
    //   583: invokevirtual 1141	android/hardware/Camera$Parameters:setZoom	(I)V
    //   586: aload_0
    //   587: getfield 438	com/tencent/mm/media/widget/a/c:jqD	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   590: astore 9
    //   592: aload 9
    //   594: ifnull +10 -> 604
    //   597: aload 9
    //   599: aload 8
    //   601: invokevirtual 583	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   604: aload_0
    //   605: getfield 438	com/tencent/mm/media/widget/a/c:jqD	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   608: astore 8
    //   610: aload 8
    //   612: ifnull +304 -> 916
    //   615: aload 8
    //   617: invokevirtual 444	com/tencent/mm/compatible/deviceinfo/w:avd	()Landroid/hardware/Camera$Parameters;
    //   620: astore 8
    //   622: aload 8
    //   624: ifnull +298 -> 922
    //   627: aload 8
    //   629: invokevirtual 1144	android/hardware/Camera$Parameters:getZoomRatios	()Ljava/util/List;
    //   632: astore 9
    //   634: aload 9
    //   636: ifnull +286 -> 922
    //   639: aload 9
    //   641: invokestatic 1148	kotlin/a/j:lo	(Ljava/util/List;)Ljava/lang/Object;
    //   644: checkcast 488	java/lang/Integer
    //   647: astore 9
    //   649: aload 9
    //   651: ifnull +271 -> 922
    //   654: aload 9
    //   656: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   659: istore_2
    //   660: aload_0
    //   661: getfield 322	com/tencent/mm/media/widget/a/c:lbv	Ljava/util/ArrayList;
    //   664: invokevirtual 1151	java/util/ArrayList:clear	()V
    //   667: aload_0
    //   668: getfield 322	com/tencent/mm/media/widget/a/c:lbv	Ljava/util/ArrayList;
    //   671: iconst_0
    //   672: invokestatic 491	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   675: invokevirtual 1152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   678: pop
    //   679: iload_2
    //   680: i2f
    //   681: fstore_1
    //   682: aload_0
    //   683: getfield 284	com/tencent/mm/media/widget/a/c:lbi	F
    //   686: fload_1
    //   687: fadd
    //   688: fstore_1
    //   689: aload 8
    //   691: ifnull +243 -> 934
    //   694: aload 8
    //   696: invokevirtual 1144	android/hardware/Camera$Parameters:getZoomRatios	()Ljava/util/List;
    //   699: astore 8
    //   701: aload 8
    //   703: ifnull +231 -> 934
    //   706: aload 8
    //   708: checkcast 525	java/lang/Iterable
    //   711: invokeinterface 539 1 0
    //   716: astore 8
    //   718: iload_3
    //   719: istore_2
    //   720: aload 8
    //   722: invokeinterface 544 1 0
    //   727: ifeq +200 -> 927
    //   730: aload 8
    //   732: invokeinterface 547 1 0
    //   737: astore 9
    //   739: iload_2
    //   740: ifge +6 -> 746
    //   743: invokestatic 1155	kotlin/a/j:iBO	()V
    //   746: aload 9
    //   748: checkcast 488	java/lang/Integer
    //   751: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   754: i2f
    //   755: fload_1
    //   756: invokestatic 1159	java/lang/Float:compare	(FF)I
    //   759: ifle +201 -> 960
    //   762: aload_0
    //   763: getfield 284	com/tencent/mm/media/widget/a/c:lbi	F
    //   766: fload_1
    //   767: fadd
    //   768: fstore_1
    //   769: aload_0
    //   770: getfield 322	com/tencent/mm/media/widget/a/c:lbv	Ljava/util/ArrayList;
    //   773: iload_2
    //   774: invokestatic 491	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   777: invokevirtual 1152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   780: pop
    //   781: iload_2
    //   782: iconst_1
    //   783: iadd
    //   784: istore_2
    //   785: goto -65 -> 720
    //   788: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   791: getfield 1162	com/tencent/mm/compatible/deviceinfo/c:jqd	I
    //   794: iconst_1
    //   795: if_icmpne +11 -> 806
    //   798: ldc_w 1164
    //   801: astore 8
    //   803: goto -727 -> 76
    //   806: ldc_w 1166
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
    //   838: getstatic 877	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   841: getfield 1162	com/tencent/mm/compatible/deviceinfo/c:jqd	I
    //   844: iconst_1
    //   845: if_icmpne +118 -> 963
    //   848: aload 9
    //   850: invokevirtual 1082	java/lang/Integer:intValue	()I
    //   853: ifeq +12 -> 865
    //   856: aload 9
    //   858: invokevirtual 1082	java/lang/Integer:intValue	()I
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
    //   892: getfield 281	com/tencent/mm/media/widget/a/c:TAG	Ljava/lang/String;
    //   895: ldc_w 1168
    //   898: iconst_1
    //   899: anewarray 324	java/lang/Object
    //   902: dup
    //   903: iconst_0
    //   904: aload 8
    //   906: invokevirtual 423	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   909: aastore
    //   910: invokestatic 426	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   913: goto -309 -> 604
    //   916: aconst_null
    //   917: astore 8
    //   919: goto -297 -> 622
    //   922: iconst_0
    //   923: istore_2
    //   924: goto -264 -> 660
    //   927: ldc_w 1045
    //   930: invokestatic 332	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   933: return
    //   934: ldc_w 1045
    //   937: invokestatic 332	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   940: return
    //   941: astore 8
    //   943: aload_0
    //   944: getfield 281	com/tencent/mm/media/widget/a/c:TAG	Ljava/lang/String;
    //   947: ldc_w 1170
    //   950: invokestatic 376	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   953: ldc_w 1045
    //   956: invokestatic 332	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   959: return
    //   960: goto -179 -> 781
    //   963: iconst_0
    //   964: istore 4
    //   966: goto -753 -> 213
    //   969: iconst_0
    //   970: invokestatic 491	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
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
  
  public void aYe()
  {
    AppMethodBeat.i(94030);
    if (!aXQ())
    {
      AppMethodBeat.o(94030);
      return;
    }
    com.tencent.mm.media.widget.a.a.a locala = this.laK;
    com.tencent.mm.media.widget.a.a.a.a locala1 = com.tencent.mm.media.widget.a.a.a.lbV;
    locala.removeMessages(com.tencent.mm.media.widget.a.a.a.aYn());
    AppMethodBeat.o(94030);
  }
  
  public b aYf()
  {
    boolean bool = true;
    AppMethodBeat.i(94036);
    Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.jqD == null)
    {
      Log.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94036);
      return null;
    }
    if (!aXQ())
    {
      Log.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94036);
      return null;
    }
    aXI();
    b.ul(getPreviewWidth());
    aXI();
    b.uk(getPreviewHeight());
    Object localObject = this.lbk;
    int i;
    if (localObject != null) {
      if ((((d.a.a)localObject).fSM == 90) || (((d.a.a)localObject).fSM == 270))
      {
        i = 1;
        aXI();
        b.un(this.laR.wAw);
        aXI();
        b.uo(this.laR.wAx);
        if (i != 0)
        {
          aXI();
          i = b.aXY();
          aXI();
          aXI();
          b.un(b.aXZ());
          aXI();
          b.uo(i);
        }
        aXI();
        b.um(getOrientation());
        aXI();
        if (this.laM) {
          break label257;
        }
      }
    }
    for (;;)
    {
      b.setFrontCamera(bool);
      aXI();
      b.fI(aXG());
      localObject = aXI();
      AppMethodBeat.o(94036);
      return localObject;
      i = 0;
      break;
      i = 0;
      break;
      label257:
      bool = false;
    }
  }
  
  public void aYh()
  {
    AppMethodBeat.i(94047);
    if (this.jqD != null) {
      try
      {
        Object localObject = this.jqD;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        localObject = ((w)localObject).avd();
        Log.i(this.TAG, "setPreviewCallbackImpl");
        int i = this.laR.wAw;
        int j = this.laR.wAx;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(j));
          w localw = this.jqD;
          if (localw == null) {
            kotlin.g.b.p.iCn();
          }
          localw.aj((byte[])localObject);
          i += 1;
        }
        this.lbm.reset();
        this.lbn.reset();
        this.lbo.reset();
        this.lbp.reset();
        this.lbq.reset();
        localObject = this.jqD;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        ((w)localObject).b((Camera.PreviewCallback)new d(this));
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
  
  public final int aYi()
  {
    if (this.laM) {
      return 0;
    }
    return 1;
  }
  
  public final int aYj()
  {
    AppMethodBeat.i(94050);
    int i = getOrientation();
    AppMethodBeat.o(94050);
    return i;
  }
  
  public final String aYk()
  {
    AppMethodBeat.i(258392);
    try
    {
      localObject1 = this.jqD;
      if (localObject1 != null)
      {
        localObject1 = ((w)localObject1).avd();
        if (localObject1 == null) {
          break label172;
        }
        String str = ((Camera.Parameters)localObject1).getFocusMode();
        localObject1 = str;
        if (str != null) {}
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        label76:
        Object localObject2 = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
        localObject2 = b.b.aZu();
        continue;
        localObject2 = "auto";
      }
    }
    switch (((String)localObject1).hashCode())
    {
    case 3005871: 
      localObject1 = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
      localObject1 = b.b.aZu();
    case -194628547: 
    case 910005312: 
      for (;;)
      {
        AppMethodBeat.o(258392);
        return localObject1;
        localObject1 = null;
        break;
        if (!((String)localObject1).equals("auto")) {
          break label76;
        }
        localObject1 = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
        localObject1 = b.b.aZu();
        continue;
        if (!((String)localObject1).equals("continuous-video")) {
          break label76;
        }
        localObject1 = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
        localObject1 = b.b.aZs();
        continue;
        if (!((String)localObject1).equals("continuous-picture")) {
          break label76;
        }
        localObject1 = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
        localObject1 = b.b.aZt();
      }
    }
  }
  
  public final boolean aYl()
  {
    AppMethodBeat.i(258393);
    try
    {
      Log.i(this.TAG, "triggerAutoFocus");
      w localw = this.jqD;
      if (localw != null) {
        localw.avf();
      }
      localw = this.jqD;
      if (localw != null) {
        localw.a(this.lbl);
      }
      AppMethodBeat.o(258393);
      return true;
    }
    catch (Exception localException)
    {
      Log.w(this.TAG, "autofocus fail, exception %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(258393);
    }
    return false;
  }
  
  protected final boolean aq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94051);
    kotlin.g.b.p.k(paramArrayOfByte, "frame");
    Util.currentTicks();
    synchronized (this.lock)
    {
      if (this.lbj != null)
      {
        int i = this.lbj.size();
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(94051);
        return false;
      }
      Iterator localIterator = this.lbj.iterator();
      boolean bool1 = false;
      while (localIterator.hasNext())
      {
        boolean bool2 = ((g)localIterator.next()).ar(paramArrayOfByte);
        bool1 |= bool2;
      }
      AppMethodBeat.o(94051);
      return bool1;
    }
  }
  
  public final void av(String paramString, int paramInt)
  {
    AppMethodBeat.i(94053);
    kotlin.g.b.p.k(paramString, "tag");
    AppMethodBeat.o(94053);
  }
  
  public void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94029);
    if (!aXQ())
    {
      AppMethodBeat.o(94029);
      return;
    }
    if (com.tencent.mm.compatible.util.d.qW(14))
    {
      AppMethodBeat.o(94029);
      return;
    }
    com.tencent.mm.media.widget.a.a.a locala = this.laK;
    Object localObject = com.tencent.mm.media.widget.a.a.a.lbV;
    locala.removeMessages(com.tencent.mm.media.widget.a.a.a.aYn());
    this.laK.jLa = paramFloat1;
    this.laK.jLb = paramFloat2;
    this.laK.lbP = paramInt1;
    this.laK.lbQ = paramInt2;
    locala = this.laK;
    localObject = this.laK;
    com.tencent.mm.media.widget.a.a.a.a locala1 = com.tencent.mm.media.widget.a.a.a.lbV;
    locala.sendMessageDelayed(((com.tencent.mm.media.widget.a.a.a)localObject).obtainMessage(com.tencent.mm.media.widget.a.a.a.aYn(), this.jqD), 400L);
    AppMethodBeat.o(94029);
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(94025);
    long l = Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (aXQ())
    {
      Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94025);
      return;
    }
    for (;;)
    {
      try
      {
        if (!aXH()) {
          continue;
        }
        k(paramInt, getDisplayRatio());
        aYh();
        aYd();
        if (a(paramSurfaceTexture, paramSurfaceHolder)) {
          a(a.a.lbb);
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aVQ();
        continue;
      }
      Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(94025);
      return;
      uj(paramInt);
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
      this.lbj.remove(paramg);
      AppMethodBeat.o(94021);
      return;
    }
  }
  
  public final boolean b(Rect paramRect1, Rect paramRect2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(258387);
    kotlin.g.b.p.k(paramRect1, "focusArea");
    kotlin.g.b.p.k(paramRect2, "meteringArea");
    try
    {
      Log.i(this.TAG, "focus on area :: focus rect %s, meter rect %s", new Object[] { paramRect1, paramRect2 });
      Object localObject1 = this.jqD;
      if (localObject1 != null)
      {
        localObject1 = ((w)localObject1).avd();
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
        paramRect1 = this.jqD;
        if (paramRect1 != null) {
          paramRect1.c((Camera.Parameters)localObject1);
        }
        paramRect1 = this.jqD;
        if (paramRect1 != null) {
          paramRect1.a(this.lbl);
        }
        AppMethodBeat.o(258387);
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
      AppMethodBeat.o(258387);
    }
  }
  
  public boolean b(w paramw)
  {
    AppMethodBeat.i(94044);
    if (paramw == null)
    {
      AppMethodBeat.o(94044);
      return false;
    }
    try
    {
      Log.i(this.TAG, "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramw.avd();
      kotlin.g.b.p.j(localParameters, "p");
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        Log.e(this.TAG, "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramw.c(localParameters);
      AppMethodBeat.o(94044);
      return true;
    }
    catch (Exception paramw)
    {
      Log.i(this.TAG, "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
      AppMethodBeat.o(94044);
    }
    return false;
  }
  
  @TargetApi(14)
  protected final boolean c(w paramw)
  {
    AppMethodBeat.i(94045);
    if (paramw == null)
    {
      AppMethodBeat.o(94045);
      return false;
    }
    try
    {
      Log.i(this.TAG, "safeSetMetering");
      Camera.Parameters localParameters = paramw.avd();
      kotlin.g.b.p.j(localParameters, "params");
      if (localParameters.getMaxNumMeteringAreas() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(new Rect(-1000, -1000, 1000, 1000), 600));
        localParameters.setMeteringAreas((List)localArrayList);
      }
      paramw.c(localParameters);
      AppMethodBeat.o(94045);
      return true;
    }
    catch (Exception paramw)
    {
      Log.i(this.TAG, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
      AppMethodBeat.o(94045);
    }
    return false;
  }
  
  public final int dB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(258381);
    for (;;)
    {
      try
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt1, localCameraInfo);
        switch (paramInt2)
        {
        default: 
          if (!this.laM)
          {
            paramInt2 = localCameraInfo.orientation;
            AppMethodBeat.o(258381);
            return (360 - (paramInt1 + paramInt2) % 360) % 360;
          }
          paramInt2 = localCameraInfo.orientation;
          AppMethodBeat.o(258381);
          return (paramInt2 - paramInt1 + 360) % 360;
        }
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "setCameraDisplayOrientation failed cause " + localException.getMessage());
        AppMethodBeat.o(258381);
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
  
  public final boolean dC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(258355);
    try
    {
      Object localObject = this.jqD;
      if (localObject != null) {}
      for (localObject = ((w)localObject).avd();; localObject = null)
      {
        if (localObject != null) {
          ((Camera.Parameters)localObject).setPreviewSize(paramInt1, paramInt2);
        }
        w localw = this.jqD;
        if (localw != null) {
          localw.c((Camera.Parameters)localObject);
        }
        AppMethodBeat.o(258355);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(258355);
    }
  }
  
  public Point fJ(boolean paramBoolean)
  {
    AppMethodBeat.i(94039);
    Object localObject;
    if (!paramBoolean)
    {
      localObject = new Point(this.laR.wAw, this.laR.wAx);
      AppMethodBeat.o(94039);
      return localObject;
    }
    if (this.laW != null)
    {
      Point localPoint = this.laW;
      localObject = localPoint;
      if (localPoint == null)
      {
        kotlin.g.b.p.iCn();
        AppMethodBeat.o(94039);
        return localPoint;
      }
    }
    else
    {
      localObject = new Point(this.laR.wAw, this.laR.wAx);
    }
    AppMethodBeat.o(94039);
    return localObject;
  }
  
  public final void fK(boolean paramBoolean)
  {
    AppMethodBeat.i(94055);
    for (;;)
    {
      try
      {
        Object localObject1 = this.jqD;
        if (localObject1 == null) {
          break label103;
        }
        localObject1 = ((w)localObject1).avd();
        if (paramBoolean)
        {
          if (localObject1 != null) {
            ((Camera.Parameters)localObject1).setFlashMode("torch");
          }
          w localw = this.jqD;
          if (localw != null)
          {
            localw.c((Camera.Parameters)localObject1);
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
    Object localObject = this.jqD;
    if (localObject != null)
    {
      localObject = ((w)localObject).avd();
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
    if ((this.lbk != null) && (aXQ()))
    {
      d.a.a locala = this.lbk;
      if (locala != null)
      {
        int i = locala.fSM;
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
    if (this.jqD == null)
    {
      AppMethodBeat.o(94037);
      return 0;
    }
    if (this.lbk != null) {
      try
      {
        if ((aXG()) && (this.laW != null))
        {
          Point localPoint = this.laW;
          if (localPoint == null) {
            kotlin.g.b.p.iCn();
          }
          i = localPoint.y;
          AppMethodBeat.o(94037);
          return i;
        }
        int i = this.laR.wAx;
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
    if (this.jqD == null)
    {
      AppMethodBeat.o(94038);
      return 0;
    }
    if (this.lbk != null) {
      try
      {
        if ((aXG()) && (this.laW != null))
        {
          Point localPoint = this.laW;
          if (localPoint == null) {
            kotlin.g.b.p.iCn();
          }
          i = localPoint.x;
          AppMethodBeat.o(94038);
          return i;
        }
        int i = this.laR.wAw;
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
    if ((this.lbu != null) || (this.jqD != null)) {}
    float[] arrayOfFloat;
    label218:
    label474:
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = this.jqD;
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        localObject2 = ((w)localObject2).avd();
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        boolean bool = ((Camera.Parameters)localObject2).isZoomSupported();
        if (!bool)
        {
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            break label218;
          }
          this.lbu = new com.tencent.tinker.a.c.b();
          localObject1 = this.lbu;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          localObject1 = new float[((com.tencent.tinker.a.c.b)localObject1).size()];
          localObject2 = this.lbu;
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          j = ((com.tencent.tinker.a.c.b)localObject2).size();
          i = 0;
          if (i >= j) {
            break;
          }
          localObject2 = this.lbu;
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          localObject1[i] = (((com.tencent.tinker.a.c.b)localObject2).aP(i) * 1.0F / 10.0F);
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
      this.lbu = new com.tencent.tinker.a.c.b(j);
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
            localObject2 = this.lbu;
            if (localObject2 == null) {
              kotlin.g.b.p.iCn();
            }
            ((com.tencent.tinker.a.c.b)localObject2).oa(k, k * i - m);
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
            localObject2 = this.lbu;
            if (localObject2 == null) {
              kotlin.g.b.p.iCn();
            }
            ((com.tencent.tinker.a.c.b)localObject2).oa(k, m + k * i);
          }
          else
          {
            m += 1;
            break label330;
            localObject2 = this.lbu;
            if (localObject2 == null) {
              kotlin.g.b.p.iCn();
            }
            ((com.tencent.tinker.a.c.b)localObject2).oa(k, k * i);
          }
        }
      }
    }
    label330:
    AppMethodBeat.o(94033);
    label393:
    return arrayOfFloat;
  }
  
  public void k(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94032);
    if ((this.jqD != null) && (aXQ())) {
      try
      {
        Log.d(this.TAG, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (aXL())
        {
          Log.d(this.TAG, "triggerSmallZoom, zooming, ignore");
          return;
        }
        Object localObject1 = this.jqD;
        if (localObject1 != null) {
          localObject1 = ((w)localObject1).avd();
        }
        int i;
        int j;
        while ((localObject1 != null) && (((Camera.Parameters)localObject1).isZoomSupported() == true))
        {
          fG(true);
          i = ((Camera.Parameters)localObject1).getZoom();
          j = this.lbv.indexOf(Integer.valueOf(i));
          int k = ((Camera.Parameters)localObject1).getMaxZoom();
          Log.d(this.TAG, "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(aXM()), Integer.valueOf(aXK()), Integer.valueOf(paramInt) });
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
            if (j != this.lbv.size() - 1) {
              break label316;
            }
            paramInt = ((Number)kotlin.a.j.lq((List)this.lbv)).intValue();
          }
        }
        for (;;)
        {
          Log.d(this.TAG, "triggerSmallZoom, nextZoom: %s, smoothZoomSupported: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(((Camera.Parameters)localObject1).isSmoothZoomSupported()) });
          ((Camera.Parameters)localObject1).setZoom(paramInt);
          Object localObject3 = this.jqD;
          if (localObject3 != null) {
            ((w)localObject3).c((Camera.Parameters)localObject1);
          }
          return;
          label316:
          localObject3 = this.lbv.get(j + 1);
          kotlin.g.b.p.j(localObject3, "availableZoomRatioIndexList[currentZoomIndex + 1]");
          paramInt = ((Number)localObject3).intValue();
          continue;
          label349:
          if (i == 0) {
            return;
          }
          if (j == 0)
          {
            paramInt = ((Number)kotlin.a.j.lo((List)this.lbv)).intValue();
          }
          else
          {
            localObject3 = this.lbv.get(j - 1);
            kotlin.g.b.p.j(localObject3, "availableZoomRatioIndexList[currentZoomIndex - 1]");
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
        fG(false);
        AppMethodBeat.o(94032);
      }
    }
  }
  
  public final void o(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.lbx = paramb;
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
        Log.i(this.TAG, this.lbm.getValue());
        Log.i(this.TAG, this.lbn.getValue());
        Log.i(this.TAG, this.lbo.getValue());
        Log.i(this.TAG, this.lbp.getValue());
        Log.i(this.TAG, this.lbq.getValue());
        if (this.jqD != null)
        {
          long l = Util.currentTicks();
          Log.i(this.TAG, "release camera beg, %s", new Object[] { Looper.myLooper() });
          this.laK.removeCallbacksAndMessages(null);
          this.lbw = true;
          if (this.laS == null) {
            continue;
          }
          localObject = this.laS;
          if (localObject != null)
          {
            localObject = ((b.a)localObject).lgj;
            if (localObject == null) {
              continue;
            }
            localObject = this.laS;
            if (localObject == null) {
              continue;
            }
            localObject = ((b.a)localObject).lgj;
            if (localObject == null) {
              continue;
            }
            b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
            localObject = Boolean.valueOf(((HashSet)localObject).contains(b.b.aZv()));
            i = j;
            if (localObject == null) {
              break label416;
            }
            if (!kotlin.g.b.p.h(localObject, Boolean.FALSE)) {
              continue;
            }
            i = j;
            break label416;
            if (localObject != null)
            {
              ((Boolean)localObject).booleanValue();
              localObject = this.jqD;
              if (localObject != null) {
                ((w)localObject).a(null);
              }
            }
            localObject = this.jqD;
            if (localObject != null) {
              ((w)localObject).TL();
            }
            localObject = this.jqD;
            if (localObject != null) {
              ((w)localObject).release();
            }
            this.jqD = null;
            Log.i(this.TAG, "release camera end, use %dms, %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
          }
        }
        else
        {
          this.laK.lbR = true;
          this.laW = null;
          this.lbt = null;
          fH(false);
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
        localObject = this.jqD;
        if (localObject != null)
        {
          ((w)localObject).a(null);
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
      fK(false);
      AppMethodBeat.o(94057);
      return;
      fK(true);
    }
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(94034);
    if (aXL())
    {
      Log.d(this.TAG, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94034);
      return;
    }
    if (this.jqD != null) {
      try
      {
        Object localObject1 = this.jqD;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        localObject1 = ((w)localObject1).avd();
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        boolean bool = ((Camera.Parameters)localObject1).isZoomSupported();
        if (!bool) {
          return;
        }
        if (this.lbu == null)
        {
          Log.d(this.TAG, "setForceZoomTargetRatio before init zoom info, ignore");
          return;
        }
        Object localObject3 = ((Camera.Parameters)localObject1).getZoomRatios();
        com.tencent.tinker.a.c.b localb = this.lbu;
        if (localb == null) {
          kotlin.g.b.p.iCn();
        }
        int i = ((List)localObject3).indexOf(Integer.valueOf(localb.get(kotlin.h.a.dm(10.0F * paramFloat))));
        if (i >= 0)
        {
          int j = ((Camera.Parameters)localObject1).getMaxZoom();
          if (i <= j) {}
        }
        else
        {
          return;
        }
        fG(true);
        ((Camera.Parameters)localObject1).setZoom(i);
        localObject3 = this.jqD;
        if (localObject3 == null) {
          kotlin.g.b.p.iCn();
        }
        ((w)localObject3).c((Camera.Parameters)localObject1);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        fG(false);
        AppMethodBeat.o(94034);
      }
    }
    AppMethodBeat.o(94034);
  }
  
  public final boolean ui(int paramInt)
  {
    AppMethodBeat.i(258377);
    try
    {
      w localw = this.jqD;
      if (localw != null) {
        localw.avd();
      }
      AppMethodBeat.o(258377);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "open scene " + paramInt + " open failed, error:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(258377);
    }
    return false;
  }
  
  public final void up(int paramInt)
  {
    AppMethodBeat.i(94031);
    if (aXK() > 0)
    {
      AppMethodBeat.o(94031);
      return;
    }
    Object localObject = ar.au(MMApplicationContext.getContext());
    int i = ((Point)localObject).y;
    Log.i(this.TAG, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94031);
      return;
    }
    try
    {
      if (this.jqD != null)
      {
        localObject = this.jqD;
        if (localObject != null)
        {
          localObject = ((w)localObject).avd();
          if (localObject == null) {
            break label187;
          }
        }
        label187:
        for (i = ((Camera.Parameters)localObject).getMaxZoom();; i = 0)
        {
          double d = i / (paramInt / 3.0D / 10.0D);
          if (d > 0.0D) {
            uh((int)d + 1);
          }
          Log.i(this.TAG, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(aXK()), Integer.valueOf(i) });
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
  
  public final void ur(int paramInt)
  {
    this.lby = paramInt;
  }
  
  public final boolean y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94019);
    kotlin.g.b.p.k(paramContext, "context");
    for (;;)
    {
      try
      {
        if (aXN())
        {
          Log.i(this.TAG, "initCamera, already open");
          AppMethodBeat.o(94019);
          return true;
        }
        Object localObject = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aVO();
        super.y(paramContext, paramBoolean);
        release();
        if (paramBoolean)
        {
          i = com.tencent.mm.compatible.deviceinfo.d.auk();
          Log.printInfoStack(this.TAG, "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(i), Integer.valueOf(af.juH.jqk) });
          this.lbk = new f().M(paramContext, i);
          Log.i(this.TAG, "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.lbk == null)
          {
            Log.i(this.TAG, "open camera FAILED, %s", new Object[] { Looper.myLooper() });
            aXO();
            AppMethodBeat.o(94019);
            return false;
          }
        }
        else
        {
          i = com.tencent.mm.compatible.deviceinfo.d.aul();
          continue;
        }
        paramContext = this.lbk;
        if (paramContext != null)
        {
          paramContext = paramContext.jqD;
          this.jqD = paramContext;
          this.lbw = false;
          paramContext = this.laR;
          localObject = this.lbk;
          if (localObject == null) {
            break label312;
          }
          i = ((d.a.a)localObject).fSM;
          paramContext.fSM = i;
          if (this.jqD == null)
          {
            Log.e(this.TAG, "start camera FAILED!");
            aXO();
            AppMethodBeat.o(94019);
            return false;
          }
          fH(true);
          AppMethodBeat.o(94019);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramContext, "init camera failed!", new Object[0]);
        paramContext = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aVQ();
        AppMethodBeat.o(94019);
        return false;
      }
      paramContext = null;
      continue;
      label312:
      int i = 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "camera", "Landroid/hardware/Camera;", "kotlin.jvm.PlatformType", "onAutoFocus"})
  static final class a
    implements Camera.AutoFocusCallback
  {
    a(c paramc) {}
    
    public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
    {
      AppMethodBeat.i(258097);
      Log.v(c.a(this.lbA), "auto focus callback success ".concat(String.valueOf(paramBoolean)));
      this.lbA.laK.lbR = true;
      if (!this.lbA.lbw) {
        try
        {
          kotlin.g.b.p.j(paramCamera, "camera");
          Camera.Parameters localParameters = paramCamera.getParameters();
          kotlin.g.b.p.j(localParameters, "camera.parameters");
          if ((localParameters.getFocusMode() != null) && (this.lbA.laK.lbS != null))
          {
            localParameters.setFocusMode(this.lbA.laK.lbS);
            paramCamera.setParameters(localParameters);
            AppMethodBeat.o(258097);
            return;
          }
        }
        catch (Exception paramCamera)
        {
          Log.e(c.a(this.lbA), "auto focus return while camera is release");
        }
      }
      AppMethodBeat.o(258097);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/CommonCamera1$setPreviewCallbackImpl$1$1"})
  static final class c
    implements Camera.PreviewCallback
  {
    c(c paramc) {}
    
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
        Log.e(c.a(this.lbA), "onPreviewFrame, frame data is null!!");
        AppMethodBeat.o(94017);
        return;
      }
      if (this.lbA.lbj.size() <= 0)
      {
        paramCamera = this.lbA.jqD;
        if (paramCamera != null)
        {
          paramCamera.aj(paramArrayOfByte);
          AppMethodBeat.o(94017);
          return;
        }
        AppMethodBeat.o(94017);
        return;
      }
      paramCamera = paramArrayOfByte;
      Object localObject;
      long l1;
      if (!this.lbA.lbr)
      {
        paramCamera = paramArrayOfByte;
        if (this.lbA.lbj.size() > 0)
        {
          paramCamera = paramArrayOfByte;
          if (this.lbA.laW != null)
          {
            paramCamera = this.lbA.laW;
            if ((paramCamera != null) && (paramCamera.x == this.lbA.laR.wAw))
            {
              paramCamera = this.lbA.laW;
              if ((paramCamera != null) && (paramCamera.y == this.lbA.laR.wAx)) {
                break label573;
              }
            }
            paramCamera = com.tencent.mm.plugin.mmsight.model.a.j.FbH;
            i = this.lbA.laR.wAw;
            localObject = this.lbA.laW;
            if (localObject == null) {
              kotlin.g.b.p.iCn();
            }
            paramCamera = paramCamera.k(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
            this.lbA.lbo.Ox(1L);
            l1 = Util.currentTicks();
            i = this.lbA.laR.wAw;
            int j = this.lbA.laR.wAx;
            localObject = this.lbA.laW;
            if (localObject == null) {
              kotlin.g.b.p.iCn();
            }
            SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
            localObject = this.lbA.laW;
            if (localObject == null) {
              kotlin.g.b.p.iCn();
            }
            if (((Point)localObject).x >= this.lbA.laR.wAw) {
              break label640;
            }
            localObject = com.tencent.mm.plugin.mmsight.model.a.j.FbH;
            Point localPoint = this.lbA.laW;
            if (localPoint == null) {
              kotlin.g.b.p.iCn();
            }
            i = localPoint.x;
            localPoint = this.lbA.laW;
            if (localPoint == null) {
              kotlin.g.b.p.iCn();
            }
            localObject = ((com.tencent.mm.plugin.mmsight.model.a.j)localObject).k(Integer.valueOf(i * localPoint.y * 3 / 2));
            i = this.lbA.laR.wAw;
            localPoint = this.lbA.laW;
            if (localPoint == null) {
              kotlin.g.b.p.iCn();
            }
            j = localPoint.x;
            localPoint = this.lbA.laW;
            if (localPoint == null) {
              kotlin.g.b.p.iCn();
            }
            SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
            com.tencent.mm.plugin.mmsight.model.a.j.FbH.as(paramCamera);
            paramCamera = (Camera)localObject;
          }
        }
      }
      label640:
      for (;;)
      {
        long l2 = Util.ticksToNow(l1);
        this.lbA.lbp.Ox(l2);
        localObject = this.lbA;
        kotlin.g.b.p.j(paramCamera, "curFrameData");
        boolean bool = ((c)localObject).aq(paramCamera);
        l1 = Util.ticksToNow(l1);
        paramCamera = paramArrayOfByte;
        if (bool)
        {
          this.lbA.lbq.Ox(l1);
          paramCamera = paramArrayOfByte;
        }
        for (;;)
        {
          paramArrayOfByte = this.lbA.jqD;
          if (paramArrayOfByte == null) {
            break;
          }
          paramArrayOfByte.aj(paramCamera);
          AppMethodBeat.o(94017);
          return;
          label573:
          l1 = Util.currentTicks();
          bool = this.lbA.aq(paramArrayOfByte);
          l1 = Util.ticksToNow(l1);
          if (bool) {
            this.lbA.lbq.Ox(l1);
          }
          paramCamera = paramArrayOfByte;
          if (bool) {
            paramCamera = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(paramArrayOfByte.length));
          }
        }
        AppMethodBeat.o(94017);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "ca", "Landroid/hardware/Camera;", "onPreviewFrame"})
  static final class d
    implements Camera.PreviewCallback
  {
    d(c paramc) {}
    
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
      for (int i = 1; (i != 0) || (this.lbA.jqD == null); i = 0)
      {
        Log.e(c.a(this.lbA), "onPreviewFrame, frame data is null!!");
        AppMethodBeat.o(94018);
        return;
      }
      Object localObject;
      long l1;
      int j;
      if ((!this.lbA.lbr) && (this.lbA.lbj != null) && (this.lbA.lbj.size() > 0)) {
        if (this.lbA.laW != null)
        {
          paramCamera = com.tencent.mm.plugin.mmsight.model.a.j.FbH;
          i = this.lbA.laR.wAw;
          localObject = this.lbA.laW;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          paramCamera = paramCamera.k(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
          this.lbA.lbo.Ox(1L);
          l1 = Util.currentTicks();
          i = this.lbA.laR.wAw;
          j = this.lbA.laR.wAx;
          localObject = this.lbA.laW;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
          localObject = this.lbA.laW;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          if (((Point)localObject).x >= this.lbA.laR.wAw) {
            break label738;
          }
          localObject = com.tencent.mm.plugin.mmsight.model.a.j.FbH;
          Point localPoint = this.lbA.laW;
          if (localPoint == null) {
            kotlin.g.b.p.iCn();
          }
          i = localPoint.x;
          localPoint = this.lbA.laW;
          if (localPoint == null) {
            kotlin.g.b.p.iCn();
          }
          localObject = ((com.tencent.mm.plugin.mmsight.model.a.j)localObject).k(Integer.valueOf(i * localPoint.y * 3 / 2));
          i = this.lbA.laR.wAw;
          localPoint = this.lbA.laW;
          if (localPoint == null) {
            kotlin.g.b.p.iCn();
          }
          j = localPoint.x;
          localPoint = this.lbA.laW;
          if (localPoint == null) {
            kotlin.g.b.p.iCn();
          }
          SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
          com.tencent.mm.plugin.mmsight.model.a.j.FbH.as(paramCamera);
          paramCamera = (Camera)localObject;
        }
      }
      label738:
      for (;;)
      {
        long l2 = Util.ticksToNow(l1);
        this.lbA.lbp.Ox(l2);
        if (!this.lbA.laM)
        {
          l1 = Util.currentTicks();
          localObject = this.lbA.laW;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          i = ((Point)localObject).x;
          localObject = this.lbA.laW;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          j = ((Point)localObject).y;
          localObject = this.lbA.lbk;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          if (((d.a.a)localObject).fSM != 270)
          {
            localObject = this.lbA.lbk;
            if (localObject == null) {
              kotlin.g.b.p.iCn();
            }
            if (((d.a.a)localObject).fSM != 90) {}
          }
          else
          {
            bool = true;
            SightVideoJNI.mirrorCameraData(paramCamera, i, j, bool);
          }
        }
        else
        {
          localObject = this.lbA;
          kotlin.g.b.p.j(paramCamera, "curFrameData");
          bool = ((c)localObject).aq(paramCamera);
          l1 = Util.ticksToNow(l1);
          if (bool) {
            this.lbA.lbq.Ox(l1);
          }
        }
        for (;;)
        {
          this.lbA.lbt = paramCamera;
          paramCamera = this.lbA.jqD;
          if (paramCamera == null) {
            kotlin.g.b.p.iCn();
          }
          paramCamera.aj(paramArrayOfByte);
          AppMethodBeat.o(94018);
          return;
          bool = false;
          break;
          if (!this.lbA.laM)
          {
            i = this.lbA.laR.wAw;
            j = this.lbA.laR.wAx;
            paramCamera = this.lbA.lbk;
            if (paramCamera == null) {
              kotlin.g.b.p.iCn();
            }
            if (paramCamera.fSM != 270)
            {
              paramCamera = this.lbA.lbk;
              if (paramCamera == null) {
                kotlin.g.b.p.iCn();
              }
              if (paramCamera.fSM != 90) {}
            }
            else
            {
              bool = true;
            }
            SightVideoJNI.mirrorCameraData(paramArrayOfByte, i, j, bool);
          }
          this.lbA.aq(paramArrayOfByte);
          paramCamera = paramArrayOfByte;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.c
 * JD-Core Version:    0.7.0.1
 */