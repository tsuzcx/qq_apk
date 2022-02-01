package com.tencent.mm.media.widget.a;

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
import com.tencent.mm.media.util.f;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "", "availableZoomRatioIndexList", "Ljava/util/ArrayList;", "", "getAvailableZoomRatioIndexList", "()Ljava/util/ArrayList;", "bCameraReleased", "", "getBCameraReleased$plugin_mediaeditor_release", "()Z", "setBCameraReleased$plugin_mediaeditor_release", "(Z)V", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "cameraCallback", "Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "getCameraCallback", "()Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "cameraCropCallback", "getCameraCropCallback", "cameraPreviewCallback", "getCameraPreviewCallback", "currentFrameData", "", "getCurrentFrameData", "()[B", "setCurrentFrameData", "([B)V", "finishCallbackTimeCallback", "getFinishCallbackTimeCallback", "frameDataCallbackList", "", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getFrameDataCallbackList", "()Ljava/util/List;", "setFrameDataCallbackList", "(Ljava/util/List;)V", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mCameraFps", "getMCameraFps", "()I", "setMCameraFps", "(I)V", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mZoomTimesToRatio", "Lcom/tencent/tinker/android/utils/SparseIntArray;", "getMZoomTimesToRatio", "()Lcom/tencent/tinker/android/utils/SparseIntArray;", "setMZoomTimesToRatio", "(Lcom/tencent/tinker/android/utils/SparseIntArray;)V", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "openCameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "getOpenCameraRes", "()Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "setOpenCameraRes", "(Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;)V", "prevcameraCallback", "getPrevcameraCallback", "sAutoFocusCallback", "Landroid/hardware/Camera$AutoFocusCallback;", "getSAutoFocusCallback", "()Landroid/hardware/Camera$AutoFocusCallback;", "setSAutoFocusCallback", "(Landroid/hardware/Camera$AutoFocusCallback;)V", "takePictureLock", "getTakePictureLock", "setTakePictureLock", "addFrameDataCallback", "callback", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "calculateLocDiff", "loc1", "loc2", "calculateTapArea", "Landroid/graphics/Rect;", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "checkCameraOpenSucc", "scene", "configVendorTagValue", "tag", "value", "dispatchCameraFrame", "frame", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "parameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCameraSensorRotate", "getCurrentCameraId", "getDeviceRotation", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getPreviewWidth", "getSupportPreviewSize", "", "Landroid/util/Size;", "()[Landroid/util/Size;", "getSupportZoomRatios", "", "initCamera", "useBack", "initRawRatios", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "safeResetZoom", "safeSetFocusMode", "safeSetMetering", "safeSetPreviewFormat", "safeSetPreviewFrameRate", "useFixMode", "safeSetPreviewSize", "resolutionLimit", "safeSetPreviewSizeWithLimitAndRatio", "sizeLimit", "displayRatio", "safeSetStabilization", "selectRatioAndResolutionLimitPreviewSize", "ratio", "longSideLimit", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "setPreviewCallbackImpl", "setPreviewCallbackImplInGPUCrop", "setPreviewSize", "width", "height", "setSafeConfig", "startPreview", "useCpuCrop", "(Landroid/graphics/SurfaceTexture;ZLjava/lang/Float;I)V", "startPreviewWithCPU", "startPreviewWithCPURatio", "startPreviewWithGPU", "startPreviewWithGPURatio", "switchVendorTag", "isChecked", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "p", "trySetPreviewFrameRateParameters", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends a
{
  private final String TAG;
  private w lTN;
  private final Object lock;
  private boolean nGA;
  private kotlin.g.a.b<? super Boolean, ah> nGB;
  private int nGC;
  private boolean nGD;
  private float nGp;
  private List<com.tencent.mm.plugin.mmsight.model.g> nGq;
  private d.a.a nGr;
  private final com.tencent.mm.plugin.mmsight.model.c nGs;
  private final com.tencent.mm.plugin.mmsight.model.c nGt;
  private final com.tencent.mm.plugin.mmsight.model.c nGu;
  private final com.tencent.mm.plugin.mmsight.model.c nGv;
  private final com.tencent.mm.plugin.mmsight.model.c nGw;
  private volatile boolean nGx;
  private volatile byte[] nGy;
  private com.tencent.tinker.a.c.b nGz;
  private Camera.AutoFocusCallback nuM;
  private final ArrayList<Integer> nvd;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94058);
    this.TAG = "MicroMsg.CommonCamera1";
    this.nGp = 10.0F;
    this.nGq = ((List)new ArrayList());
    this.nuM = new d..ExternalSyntheticLambda0(this);
    this.nGs = new com.tencent.mm.plugin.mmsight.model.c("prevcameraCallback");
    this.nGt = new com.tencent.mm.plugin.mmsight.model.c("cameraCallback");
    this.nGu = new com.tencent.mm.plugin.mmsight.model.c("cameraPreviewCallback");
    this.nGv = new com.tencent.mm.plugin.mmsight.model.c("cameraCropCallback");
    this.nGw = new com.tencent.mm.plugin.mmsight.model.c("finishCallbackTimeCallback");
    this.nvd = new ArrayList();
    this.lock = new Object();
    this.nGD = true;
    AppMethodBeat.o(94058);
  }
  
  private final void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(94024);
    long l = Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithCPU,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (bsD())
    {
      Log.i(this.TAG, "startPreviewWithCPU, camera previewing");
      AppMethodBeat.o(94024);
      return;
    }
    try
    {
      uq(paramInt);
      bta();
      btd();
      if (a(paramSurfaceTexture, paramSurfaceHolder)) {
        a(a.a.nGg);
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
        paramSurfaceTexture = f.nFE;
        f.bqx();
      }
    }
  }
  
  private static final void a(d paramd, boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(237649);
    s.u(paramd, "this$0");
    Log.v(paramd.TAG, s.X("auto focus callback success ", Boolean.valueOf(paramBoolean)));
    paramd.bso().nGO = true;
    if (!paramd.nGA) {
      try
      {
        Camera.Parameters localParameters = paramCamera.getParameters();
        s.s(localParameters, "camera.parameters");
        if ((localParameters.getFocusMode() != null) && (paramd.bso().nGP != null))
        {
          localParameters.setFocusMode(paramd.bso().nGP);
          paramCamera.setParameters(localParameters);
          AppMethodBeat.o(237649);
          return;
        }
      }
      catch (Exception paramCamera)
      {
        Log.e(paramd.TAG, "auto focus return while camera is release");
      }
    }
    AppMethodBeat.o(237649);
  }
  
  private static final void a(d paramd, byte[] paramArrayOfByte, Camera paramCamera)
  {
    int j = 1;
    AppMethodBeat.i(237658);
    s.u(paramd, "this$0");
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length != 0) {
        break label48;
      }
    }
    label48:
    for (int i = 1; i != 0; i = 0)
    {
      Log.e(paramd.TAG, "onPreviewFrame, frame data is null!!");
      AppMethodBeat.o(237658);
      return;
    }
    if (paramd.nGq.size() <= 0)
    {
      paramd = paramd.lTN;
      if (paramd != null) {
        paramd.aj(paramArrayOfByte);
      }
      AppMethodBeat.o(237658);
      return;
    }
    paramCamera = paramArrayOfByte;
    label173:
    long l1;
    if (!paramd.nGx)
    {
      paramCamera = paramArrayOfByte;
      if (paramd.nGq.size() > 0)
      {
        paramCamera = paramArrayOfByte;
        if (paramd.bsw() != null)
        {
          paramCamera = paramd.bsw();
          if ((paramCamera == null) || (paramCamera.x != paramd.bss().zWH)) {
            break label490;
          }
          i = 1;
          if (i != 0)
          {
            paramCamera = paramd.bsw();
            if ((paramCamera == null) || (paramCamera.y != paramd.bss().zWI)) {
              break label495;
            }
            i = j;
            if (i != 0) {
              break label500;
            }
          }
          paramCamera = j.KXq;
          i = paramd.bss().zWH;
          Object localObject = paramd.bsw();
          s.checkNotNull(localObject);
          paramCamera = paramCamera.m(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
          paramd.nGu.ss(1L);
          l1 = Util.currentTicks();
          i = paramd.bss().zWH;
          j = paramd.bss().zWI;
          localObject = paramd.bsw();
          s.checkNotNull(localObject);
          SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
          localObject = paramd.bsw();
          s.checkNotNull(localObject);
          if (((Point)localObject).x >= paramd.bss().zWH) {
            break label555;
          }
          localObject = j.KXq;
          Point localPoint = paramd.bsw();
          s.checkNotNull(localPoint);
          i = localPoint.x;
          localPoint = paramd.bsw();
          s.checkNotNull(localPoint);
          localObject = ((j)localObject).m(Integer.valueOf(i * localPoint.y * 3 / 2));
          i = paramd.bss().zWH;
          localPoint = paramd.bsw();
          s.checkNotNull(localPoint);
          j = localPoint.x;
          localPoint = paramd.bsw();
          s.checkNotNull(localPoint);
          SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
          j.KXq.as(paramCamera);
          paramCamera = (Camera)localObject;
        }
      }
    }
    label555:
    for (;;)
    {
      long l2 = Util.ticksToNow(l1);
      paramd.nGv.ss(l2);
      s.s(paramCamera, "curFrameData");
      boolean bool = paramd.ar(paramCamera);
      l1 = Util.ticksToNow(l1);
      paramCamera = paramArrayOfByte;
      if (bool)
      {
        paramd.nGw.ss(l1);
        paramCamera = paramArrayOfByte;
      }
      for (;;)
      {
        paramd = paramd.lTN;
        if (paramd != null) {
          paramd.aj(paramCamera);
        }
        AppMethodBeat.o(237658);
        return;
        label490:
        i = 0;
        break;
        label495:
        i = 0;
        break label173;
        label500:
        l1 = Util.currentTicks();
        bool = paramd.ar(paramArrayOfByte);
        l1 = Util.ticksToNow(l1);
        if (bool) {
          paramd.nGw.ss(l1);
        }
        paramCamera = paramArrayOfByte;
        if (bool) {
          paramCamera = j.KXq.m(Integer.valueOf(paramArrayOfByte.length));
        }
      }
    }
  }
  
  private static final void b(d paramd, byte[] paramArrayOfByte, Camera paramCamera)
  {
    boolean bool = false;
    AppMethodBeat.i(237664);
    s.u(paramd, "this$0");
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length != 0) {
        break label55;
      }
    }
    label55:
    for (int i = 1; (i != 0) || (paramd.lTN == null); i = 0)
    {
      Log.e(paramd.TAG, "onPreviewFrame, frame data is null!!");
      AppMethodBeat.o(237664);
      return;
    }
    Object localObject;
    long l1;
    int j;
    if ((!paramd.nGx) && (paramd.nGq != null) && (paramd.nGq.size() > 0)) {
      if (paramd.bsw() != null)
      {
        paramCamera = j.KXq;
        i = paramd.bss().zWH;
        localObject = paramd.bsw();
        s.checkNotNull(localObject);
        paramCamera = paramCamera.m(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
        paramd.nGu.ss(1L);
        l1 = Util.currentTicks();
        i = paramd.bss().zWH;
        j = paramd.bss().zWI;
        localObject = paramd.bsw();
        s.checkNotNull(localObject);
        SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
        localObject = paramd.bsw();
        s.checkNotNull(localObject);
        if (((Point)localObject).x >= paramd.bss().zWH) {
          break label599;
        }
        localObject = j.KXq;
        Point localPoint = paramd.bsw();
        s.checkNotNull(localPoint);
        i = localPoint.x;
        localPoint = paramd.bsw();
        s.checkNotNull(localPoint);
        localObject = ((j)localObject).m(Integer.valueOf(i * localPoint.y * 3 / 2));
        i = paramd.bss().zWH;
        localPoint = paramd.bsw();
        s.checkNotNull(localPoint);
        j = localPoint.x;
        localPoint = paramd.bsw();
        s.checkNotNull(localPoint);
        SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
        j.KXq.as(paramCamera);
        paramCamera = (Camera)localObject;
      }
    }
    label599:
    for (;;)
    {
      long l2 = Util.ticksToNow(l1);
      paramd.nGv.ss(l2);
      if (!paramd.bsp())
      {
        l1 = Util.currentTicks();
        localObject = paramd.bsw();
        s.checkNotNull(localObject);
        i = ((Point)localObject).x;
        localObject = paramd.bsw();
        s.checkNotNull(localObject);
        j = ((Point)localObject).y;
        localObject = paramd.nGr;
        s.checkNotNull(localObject);
        if (((d.a.a)localObject).hYK != 270)
        {
          localObject = paramd.nGr;
          s.checkNotNull(localObject);
          if (((d.a.a)localObject).hYK != 90) {}
        }
        else
        {
          bool = true;
          SightVideoJNI.mirrorCameraData(paramCamera, i, j, bool);
        }
      }
      else
      {
        s.s(paramCamera, "curFrameData");
        bool = paramd.ar(paramCamera);
        l1 = Util.ticksToNow(l1);
        if (bool) {
          paramd.nGw.ss(l1);
        }
      }
      for (;;)
      {
        paramd.nGy = paramCamera;
        paramd = paramd.lTN;
        s.checkNotNull(paramd);
        paramd.aj(paramArrayOfByte);
        AppMethodBeat.o(237664);
        return;
        bool = false;
        break;
        if (!paramd.bsp())
        {
          i = paramd.bss().zWH;
          j = paramd.bss().zWI;
          paramCamera = paramd.nGr;
          s.checkNotNull(paramCamera);
          if (paramCamera.hYK != 270)
          {
            paramCamera = paramd.nGr;
            s.checkNotNull(paramCamera);
            if (paramCamera.hYK != 90) {}
          }
          else
          {
            bool = true;
          }
          SightVideoJNI.mirrorCameraData(paramArrayOfByte, i, j, bool);
        }
        paramd.ar(paramArrayOfByte);
        paramCamera = paramArrayOfByte;
      }
    }
  }
  
  private final boolean b(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(237642);
    if ((this.lTN == null) || (this.nGr == null))
    {
      Log.e(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(237642);
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = this.lTN;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            AppMethodBeat.o(237642);
            return false;
          }
        }
        else
        {
          localObject1 = ((w)localObject1).aPy();
          continue;
        }
        localObject2 = ((Camera.Parameters)localObject1).getSupportedPreviewSizes();
        s.s(localObject2, "parameter.supportedPreviewSizes");
        kotlin.a.p.a((Iterable)localObject2, (Comparator)new d.a());
        Iterator localIterator = ((Iterable)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break label391;
        }
        localObject2 = localIterator.next();
        Camera.Size localSize = (Camera.Size)localObject2;
        if ((Math.abs(localSize.width * 1.0F / localSize.height - paramFloat) > 0.1D) || (localSize.width > paramInt)) {
          break label386;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(237642);
        return false;
      }
      Object localObject2 = (Camera.Size)localObject2;
      if (localObject2 == null)
      {
        AppMethodBeat.o(237642);
        return false;
      }
      ((Camera.Parameters)localObject1).setPreviewSize(((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height);
      bss().zWH = ((Camera.Size)localObject2).width;
      bss().zWI = ((Camera.Size)localObject2).height;
      d(new Point(((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height));
      Log.i(this.TAG, "selectRatioAndResolutionLimitPreviewSize final select target:" + ((Camera.Size)localObject2).width + 'x' + ((Camera.Size)localObject2).height);
      localObject2 = this.lTN;
      if (localObject2 != null) {
        ((w)localObject2).c((Camera.Parameters)localObject1);
      }
      AppMethodBeat.o(237642);
      return true;
      for (;;)
      {
        if (i == 0) {
          break label389;
        }
        break;
        label386:
        i = 0;
      }
      label389:
      continue;
      label391:
      localObject2 = null;
    }
  }
  
  private final void btd()
  {
    AppMethodBeat.i(94046);
    if (this.lTN == null)
    {
      AppMethodBeat.o(94046);
      return;
    }
    for (;;)
    {
      try
      {
        if (this.lTN != null)
        {
          w localw1 = this.lTN;
          if (localw1 != null) {
            break label84;
          }
          localw1 = null;
          if (localw1 != null) {
            break;
          }
          AppMethodBeat.o(94046);
        }
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(94046);
        return;
      }
      label84:
      localObject = localException.aPy();
    }
    int i = bss().zWH;
    int j = bss().zWI;
    int k = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
    Log.i(this.TAG, s.X("setPreviewCallbackImpl  size: ", Integer.valueOf(k)));
    i = 0;
    do
    {
      j = i + 1;
      localObject = j.KXq.m(Integer.valueOf(k));
      w localw2 = this.lTN;
      if (localw2 != null) {
        localw2.aj((byte[])localObject);
      }
      i = j;
    } while (j < 5);
    this.nGs.reset();
    this.nGt.reset();
    this.nGu.reset();
    this.nGv.reset();
    this.nGw.reset();
    Object localObject = this.lTN;
    if (localObject != null) {
      ((w)localObject).b(new d..ExternalSyntheticLambda2(this));
    }
    AppMethodBeat.o(94046);
  }
  
  private boolean o(int paramInt, float paramFloat)
  {
    Object localObject4 = null;
    AppMethodBeat.i(94026);
    if ((this.lTN == null) || (paramInt <= 0))
    {
      AppMethodBeat.o(94026);
      return false;
    }
    float f2;
    int i;
    label164:
    label246:
    boolean bool;
    try
    {
      localObject1 = this.lTN;
      s.checkNotNull(localObject1);
      localParameters = ((w)localObject1).aPy();
      if (this.nFZ != null) {
        break label497;
      }
      localObject1 = aw.bf(MMApplicationContext.getContext());
      localPoint = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
      Log.i(this.TAG, "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject1 });
      float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
      f2 = 1.0F / paramFloat;
      if (paramFloat >= 1.0F) {
        break label545;
      }
      i = paramInt;
      Log.i(this.TAG, "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
      localObject1 = this.nGr;
      s.checkNotNull(localObject1);
      if (((d.a.a)localObject1).hYK == 90) {
        break label578;
      }
      localObject1 = this.nGr;
      s.checkNotNull(localObject1);
      if (((d.a.a)localObject1).hYK != 270) {
        break label602;
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
    if (localObject1 == null)
    {
      localObject3 = null;
      label267:
      if (localObject3 != null) {
        break label590;
      }
      Log.e(this.TAG, "fuck, preview size still null!!");
      s.checkNotNull(localParameters);
      localObject1 = this.nGr;
      s.checkNotNull(localObject1);
      if (((d.a.a)localObject1).hYK == 90) {
        break label584;
      }
      localObject1 = this.nGr;
      s.checkNotNull(localObject1);
      if (((d.a.a)localObject1).hYK != 270) {
        break label608;
      }
    }
    for (;;)
    {
      label333:
      localObject1 = h.d(localParameters, localPoint, paramInt, bool);
      for (;;)
      {
        label348:
        if (localObject3 != null)
        {
          localObject1 = ((h.c)localObject1).KVz;
          bss().zWH = ((Point)localObject1).x;
          bss().zWI = ((Point)localObject1).y;
          d(null);
          Log.i(bsm(), "final set camera preview size: : %s, cropSize: %s", new Object[] { localObject1, bsw() });
          s.checkNotNull(localParameters);
          localParameters.setPreviewSize(bss().zWH, bss().zWI);
          localObject1 = this.lTN;
          s.checkNotNull(localObject1);
          ((w)localObject1).c(localParameters);
          AppMethodBeat.o(94026);
          return true;
        }
        label497:
        Object localObject2 = this.nFZ;
        s.checkNotNull(localObject2);
        i = ((Size)localObject2).getWidth();
        localObject2 = this.nFZ;
        s.checkNotNull(localObject2);
        localObject2 = new Point(i, ((Size)localObject2).getHeight());
        break;
        label545:
        i = Math.round(paramInt / f2);
        break label164;
        localObject3 = ((h.c)localObject2).KVz;
        break label267;
        label578:
        label584:
        label590:
        do
        {
          localObject3 = ((h.c)localObject2).KVz;
          break label348;
          bool = true;
          break;
          bool = true;
          break label333;
        } while (localObject2 != null);
        localObject3 = localObject4;
      }
      label602:
      bool = false;
      break label246;
      label608:
      bool = false;
    }
  }
  
  private final boolean uq(int paramInt)
  {
    Point localPoint = null;
    AppMethodBeat.i(94048);
    if ((this.lTN == null) || (this.nGr == null))
    {
      Log.d(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(94048);
      return false;
    }
    Object localObject1 = this.nGr;
    int i;
    label92:
    boolean bool;
    if ((localObject1 != null) && (((d.a.a)localObject1).hYK == 90))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = this.nGr;
        if ((localObject1 == null) || (((d.a.a)localObject1).hYK != 270)) {
          break label189;
        }
        i = 1;
        if (i == 0) {
          break label194;
        }
      }
      bool = true;
    }
    label189:
    label194:
    label199:
    Object localObject2;
    for (;;)
    {
      try
      {
        if (this.nFZ != null) {
          break label199;
        }
        localObject3 = com.tencent.mm.plugin.mmsight.d.iQ(getContext());
        localObject1 = this.lTN;
        if (localObject1 != null) {
          break label245;
        }
        localObject1 = null;
        if (localObject1 != null) {
          break label255;
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
      i = 0;
      break;
      i = 0;
      break label92;
      bool = false;
      continue;
      localObject2 = this.nFZ;
      s.checkNotNull(localObject2);
      i = ((Size)localObject2).getWidth();
      localObject2 = this.nFZ;
      s.checkNotNull(localObject2);
      localObject3 = new Point(i, ((Size)localObject2).getHeight());
      continue;
      label245:
      localObject2 = ((w)localObject2).aPy();
    }
    label255:
    h.c localc = h.c((Camera.Parameters)localObject2, (Point)localObject3, paramInt, bool);
    if (localc == null)
    {
      if (localPoint != null) {
        break label550;
      }
      Log.e(this.TAG, "fuck, preview size still null!!");
    }
    label550:
    for (Object localObject3 = h.d((Camera.Parameters)localObject2, new Point(Math.min(((Point)localObject3).x, ((Point)localObject3).y), Math.max(((Point)localObject3).x, ((Point)localObject3).y)), bsn(), bool);; localObject3 = localc)
    {
      if (((h.c)localObject3).KVz == null)
      {
        Log.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject3).toString() });
        ((h.c)localObject3).KVz = ((h.c)localObject3).KVC;
        ((h.c)localObject3).KVA = ((h.c)localObject3).KVD;
        ((h.c)localObject3).KVB = ((h.c)localObject3).KVE;
      }
      localPoint = ((h.c)localObject3).KVz;
      if (localPoint == null)
      {
        k.gcn();
        AppMethodBeat.o(94048);
        return false;
        localPoint = localc.KVz;
        break;
      }
      bss().zWH = localPoint.x;
      bss().zWI = localPoint.y;
      d(localPoint);
      if (((h.c)localObject3).KVA != null) {
        d(((h.c)localObject3).KVA);
      }
      Log.i(this.TAG, "final set camera preview size: " + localPoint + ", cropSize: " + bsw());
      ((Camera.Parameters)localObject2).setPreviewSize(localPoint.x, localPoint.y);
      localObject3 = this.lTN;
      if (localObject3 != null) {
        ((w)localObject3).c((Camera.Parameters)localObject2);
      }
      AppMethodBeat.o(94048);
      return true;
    }
  }
  
  public final boolean A(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94019);
    s.u(paramContext, "context");
    try
    {
      if (bsA())
      {
        Log.i(this.TAG, "initCamera, already open");
        AppMethodBeat.o(94019);
        return true;
      }
      Object localObject = f.nFE;
      f.bqv();
      super.A(paramContext, paramBoolean);
      release();
      if (paramBoolean) {}
      for (int i = com.tencent.mm.compatible.deviceinfo.d.aOr();; i = com.tencent.mm.compatible.deviceinfo.d.aOs())
      {
        Log.printInfoStack(this.TAG, "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(i), Integer.valueOf(af.lXY.lTr) });
        this.nGr = new g().P(paramContext, i);
        Log.i(this.TAG, "open camera end, %s", new Object[] { Looper.myLooper() });
        if (this.nGr != null) {
          break;
        }
        Log.i(this.TAG, "open camera FAILED, %s", new Object[] { Looper.myLooper() });
        bsB();
        AppMethodBeat.o(94019);
        return false;
      }
      paramContext = this.nGr;
      if (paramContext == null)
      {
        paramContext = null;
        this.lTN = paramContext;
        this.nGA = false;
        paramContext = bss();
        localObject = this.nGr;
        if (localObject != null) {
          break label261;
        }
      }
      label261:
      for (i = 0;; i = ((d.a.a)localObject).hYK)
      {
        paramContext.hYK = i;
        if (this.lTN != null) {
          break label270;
        }
        Log.e(this.TAG, "start camera FAILED!");
        bsB();
        AppMethodBeat.o(94019);
        return false;
        paramContext = paramContext.lTN;
        break;
      }
      label270:
      gv(true);
      AppMethodBeat.o(94019);
      return true;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramContext, "init camera failed!", new Object[0]);
      paramContext = f.nFE;
      f.bqx();
      AppMethodBeat.o(94019);
    }
    return false;
  }
  
  public final void G(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94052);
    s.u(paramString, "tag");
    AppMethodBeat.o(94052);
  }
  
  public final void I(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.nGB = paramb;
  }
  
  public final Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237811);
    paramFloat3 = 80.0F * paramFloat3;
    Object localObject1 = new RectF();
    float f1 = Math.max(paramFloat1 - paramFloat3, 0.0F);
    float f2 = Math.min(paramFloat1 + paramFloat3, paramInt1);
    ((RectF)localObject1).set(f1, Math.max(paramFloat2 - paramFloat3, 0.0F), f2, Math.min(paramFloat2 + paramFloat3, paramInt2));
    if (bsv() != null)
    {
      bst();
      int j = b.bsL();
      int i;
      switch (((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation())
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        RectF localRectF1 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
        Object localObject2 = com.tencent.mm.media.widget.d.b.nMW;
        bst();
        boolean bool = b.isFrontCamera();
        paramFloat1 = (j - i + 360) % 360;
        localObject2 = com.tencent.mm.media.widget.d.b.nMW;
        RectF localRectF2 = com.tencent.mm.media.widget.d.b.bvq();
        s.u(localRectF2, "cameraRect");
        s.u(localRectF1, "previewRect");
        localObject2 = new RectF();
        com.tencent.mm.media.widget.d.b.a(bool, paramFloat1, localRectF2, localRectF1).mapRect((RectF)localObject2, (RectF)localObject1);
        localObject1 = new Rect();
        ((RectF)localObject2).round((Rect)localObject1);
        Log.i(this.TAG, s.X("calculateTapArea ", localObject1));
        AppMethodBeat.o(237811);
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
    bst();
    paramFloat1 /= paramInt1;
    paramFloat2 /= paramInt2;
    paramFloat1 = paramFloat1 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    paramFloat2 = paramFloat2 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    localObject1 = new RectF();
    ((RectF)localObject1).set(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat3 + paramFloat2);
    localObject1 = new Rect(androidx.core.b.a.clamp(kotlin.h.a.eH(((RectF)localObject1).left), -1000, 1000), androidx.core.b.a.clamp(kotlin.h.a.eH(((RectF)localObject1).top), -1000, 1000), androidx.core.b.a.clamp(kotlin.h.a.eH(((RectF)localObject1).right), -1000, 1000), androidx.core.b.a.clamp(kotlin.h.a.eH(((RectF)localObject1).bottom), -1000, 1000));
    AppMethodBeat.o(237811);
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
    AppMethodBeat.i(237720);
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    a(paramFloat);
    if (paramFloat != null)
    {
      if (paramBoolean)
      {
        f = paramFloat.floatValue();
        l = Util.currentTicks();
        Log.i(this.TAG, "start startPreviewWithCPURatio,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + paramSurfaceTexture + ", surface:" + null);
        if (bsD())
        {
          Log.i(this.TAG, "startPreviewWithCPU, camera previewing");
          AppMethodBeat.o(237720);
          return;
        }
        try
        {
          if (!b(f, paramInt))
          {
            b(paramSurfaceTexture, null, paramInt);
            AppMethodBeat.o(237720);
            return;
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
          paramSurfaceTexture = f.nFE;
          f.bqx();
        }
        for (;;)
        {
          Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
          AppMethodBeat.o(237720);
          return;
          bta();
          btd();
          if (a(paramSurfaceTexture, null)) {
            a(a.a.nGg);
          }
        }
      }
      float f = paramFloat.floatValue();
      long l = Util.currentTicks();
      Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + null);
      if (bsD())
      {
        Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
        AppMethodBeat.o(237720);
        return;
      }
      try
      {
        if (!b(f, paramInt))
        {
          b(paramSurfaceTexture, null, paramInt);
          AppMethodBeat.o(237720);
          return;
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = f.nFE;
        f.bqx();
      }
      for (;;)
      {
        Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
        AppMethodBeat.o(237720);
        return;
        bta();
        if (bsr()) {
          bte();
        }
        if (a(paramSurfaceTexture, null)) {
          a(a.a.nGg);
        }
      }
    }
    a(paramSurfaceTexture, paramBoolean, paramInt);
    AppMethodBeat.o(237720);
  }
  
  protected void a(Camera.Parameters paramParameters, int paramInt)
  {
    AppMethodBeat.i(237762);
    s.u(paramParameters, "p");
    if (af.lXY.lTg > 0)
    {
      Log.i(bsm(), "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(237762);
      return;
    }
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(237762);
      return;
    }
    int j = -2147483648;
    int k = -2147483648;
    int i4 = localList.size();
    int m = k;
    int i = j;
    int i1;
    int[] arrayOfInt;
    if (i4 > 0)
    {
      m = 0;
      i = 0;
      i1 = m + 1;
      arrayOfInt = (int[])localList.get(m);
      if ((arrayOfInt != null) && (arrayOfInt.length > 1)) {
        break label208;
      }
    }
    for (;;)
    {
      label208:
      int n;
      if (i1 >= i4)
      {
        i = j;
        m = k;
        Log.i(bsm(), "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(30) });
        if ((i == 2147483647) || (m == 2147483647))
        {
          AppMethodBeat.o(237762);
          return;
          int i3 = arrayOfInt[0];
          int i2 = arrayOfInt[1];
          Log.i(this.TAG, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(m), Integer.valueOf(i3), Integer.valueOf(i2) });
          if ((i3 >= 0) && (i2 < i3)) {
            continue;
          }
          n = k;
          m = j;
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
            if (i2 < paramInt * 1000) {
              break label441;
            }
            i = 1;
            k = n;
            j = m;
            continue;
          }
          if (i2 < 30000) {
            break label441;
          }
          i = 1;
          k = n;
          j = m;
          continue;
        }
        try
        {
          paramParameters.setPreviewFpsRange(i, m);
          Log.i(bsm(), "set fps range %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
          AppMethodBeat.o(237762);
          return;
        }
        catch (Exception paramParameters)
        {
          Log.i(bsm(), "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
          AppMethodBeat.o(237762);
          return;
        }
      }
      m = i1;
      break;
      label441:
      k = n;
      j = m;
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
  
  public final void a(com.tencent.mm.plugin.mmsight.model.g paramg)
  {
    AppMethodBeat.i(94020);
    Log.printInfoStack(this.TAG, s.X("addFrameDataCallback ", paramg), new Object[0]);
    if (paramg == null)
    {
      AppMethodBeat.o(94020);
      return;
    }
    synchronized (this.lock)
    {
      this.nGq.add(paramg);
      AppMethodBeat.o(94020);
      return;
    }
  }
  
  public final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94027);
    w localw = this.lTN;
    if (localw != null)
    {
      if ((paramSurfaceTexture != null) || (paramSurfaceHolder != null))
      {
        if (paramSurfaceTexture != null) {
          localw.f(paramSurfaceTexture);
        }
        for (;;)
        {
          localw.aPz();
          Log.i(this.TAG, "doStartPreview finish");
          paramSurfaceTexture = f.nFE;
          f.bqw();
          AppMethodBeat.o(94027);
          return true;
          localw.a(paramSurfaceHolder);
        }
      }
      Log.i(this.TAG, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = f.nFE;
      f.bqx();
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
        localParameters = paramw.aPy();
        localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          Log.i(this.TAG, "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          bso().nGP = localParameters.getFocusMode();
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
          break label193;
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
        label193:
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
        localParameters = paramw.aPy();
        if (!paramBoolean) {
          break label308;
        }
        i = this.nGC;
        Object localObject1;
        if (af.lXY.lTg > 0)
        {
          Log.i(bsm(), "set frame rate > 0, do not try set preview frame rate");
          localObject1 = localParameters.getSupportedPreviewFrameRates();
          Log.i(bsm(), "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localObject1 });
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
            s.s(localObject1, "max(fr)");
            i = Math.min(i, ((Number)localObject1).intValue());
            localParameters.setPreviewFrameRate(i);
            Log.i(bsm(), "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
        }
        catch (Exception localException)
        {
          Log.i(bsm(), "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        }
      }
      catch (Exception paramw)
      {
        Log.i(bsm(), "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
        AppMethodBeat.o(94041);
        return false;
      }
      for (;;)
      {
        break;
        Object localObject2 = Collections.max((Collection)localException);
        s.s(localObject2, "max(fr)");
        i = Math.min(30, ((Number)localObject2).intValue());
      }
      label308:
      s.s(localParameters, "p");
      a(localParameters, this.nGC);
    }
  }
  
  public final void aE(String paramString, int paramInt)
  {
    AppMethodBeat.i(94053);
    s.u(paramString, "tag");
    AppMethodBeat.o(94053);
  }
  
  protected final void aq(byte[] paramArrayOfByte)
  {
    this.nGy = paramArrayOfByte;
  }
  
  protected final boolean ar(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94051);
    s.u(paramArrayOfByte, "frame");
    Util.currentTicks();
    synchronized (this.lock)
    {
      if (this.nGq != null)
      {
        int i = this.nGq.size();
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(94051);
        return false;
      }
      Iterator localIterator = this.nGq.iterator();
      boolean bool1 = false;
      while (localIterator.hasNext())
      {
        boolean bool2 = ((com.tencent.mm.plugin.mmsight.model.g)localIterator.next()).onFrameData(paramArrayOfByte);
        bool1 |= bool2;
      }
      AppMethodBeat.o(94051);
      return bool1;
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94029);
    if (!bsD())
    {
      AppMethodBeat.o(94029);
      return;
    }
    if (com.tencent.mm.compatible.util.d.rc(14))
    {
      AppMethodBeat.o(94029);
      return;
    }
    com.tencent.mm.media.widget.a.a.a locala = bso();
    Object localObject = com.tencent.mm.media.widget.a.a.a.nGH;
    locala.removeMessages(com.tencent.mm.media.widget.a.a.a.btj());
    bso().mkm = paramFloat1;
    bso().mkn = paramFloat2;
    bso().nGM = paramInt1;
    bso().nGN = paramInt2;
    locala = bso();
    localObject = bso();
    com.tencent.mm.media.widget.a.a.a.a locala1 = com.tencent.mm.media.widget.a.a.a.nGH;
    locala.sendMessageDelayed(((com.tencent.mm.media.widget.a.a.a)localObject).obtainMessage(com.tencent.mm.media.widget.a.a.a.btj(), this.lTN), 400L);
    AppMethodBeat.o(94029);
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(94025);
    long l = Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (bsD())
    {
      Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94025);
      return;
    }
    for (;;)
    {
      try
      {
        if (!bsr()) {
          continue;
        }
        o(paramInt, getDisplayRatio());
        bte();
        bta();
        if (a(paramSurfaceTexture, paramSurfaceHolder)) {
          a(a.a.nGg);
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = f.nFE;
        f.bqx();
        continue;
      }
      Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(94025);
      return;
      ui(paramInt);
    }
  }
  
  public final void b(com.tencent.mm.plugin.mmsight.model.g paramg)
  {
    AppMethodBeat.i(94021);
    Log.printInfoStack(this.TAG, s.X("removeFrameDataCallback ", paramg), new Object[0]);
    if (paramg == null)
    {
      AppMethodBeat.o(94021);
      return;
    }
    synchronized (this.lock)
    {
      this.nGq.remove(paramg);
      AppMethodBeat.o(94021);
      return;
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
      Camera.Parameters localParameters = paramw.aPy();
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
  
  public final int boh()
  {
    AppMethodBeat.i(94050);
    int i = getOrientation();
    AppMethodBeat.o(94050);
    return i;
  }
  
  public final int bsG()
  {
    AppMethodBeat.i(237802);
    Object localObject = this.lTN;
    if (localObject == null)
    {
      AppMethodBeat.o(237802);
      return 0;
    }
    localObject = ((w)localObject).aPy();
    if (localObject == null)
    {
      AppMethodBeat.o(237802);
      return 0;
    }
    int i = ((Camera.Parameters)localObject).getPreviewFrameRate();
    AppMethodBeat.o(237802);
    return i;
  }
  
  public final boolean bsH()
  {
    AppMethodBeat.i(237805);
    if (!s.p(bso().nGP, "auto"))
    {
      AppMethodBeat.o(237805);
      return false;
    }
    w localw = this.lTN;
    if (localw != null) {
      localw.a(null);
    }
    AppMethodBeat.o(237805);
    return true;
  }
  
  public final boolean bsI()
  {
    boolean bool2 = false;
    d.a.a locala = this.nGr;
    boolean bool1 = bool2;
    if (locala != null) {
      if (locala.hYK != 90)
      {
        bool1 = bool2;
        if (locala.hYK != 270) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Size[] bsJ()
  {
    AppMethodBeat.i(237784);
    Object localObject = this.lTN;
    if (localObject != null)
    {
      localObject = ((w)localObject).aPy();
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
          AppMethodBeat.o(237784);
          return arrayOfSize;
        }
      }
    }
    AppMethodBeat.o(237784);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.mmsight.model.g> bsR()
  {
    return this.nGq;
  }
  
  protected final w bsS()
  {
    return this.lTN;
  }
  
  protected final d.a.a bsT()
  {
    return this.nGr;
  }
  
  protected final com.tencent.mm.plugin.mmsight.model.c bsU()
  {
    return this.nGs;
  }
  
  protected final com.tencent.mm.plugin.mmsight.model.c bsV()
  {
    return this.nGt;
  }
  
  protected final com.tencent.mm.plugin.mmsight.model.c bsW()
  {
    return this.nGu;
  }
  
  protected final com.tencent.mm.plugin.mmsight.model.c bsX()
  {
    return this.nGv;
  }
  
  protected final com.tencent.mm.plugin.mmsight.model.c bsY()
  {
    return this.nGw;
  }
  
  protected final boolean bsZ()
  {
    return this.nGx;
  }
  
  /* Error */
  public void bta()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc_w 1253
    //   6: invokestatic 266	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 1259	com/tencent/mm/plugin/mmsight/model/a/k:gcB	()Lcom/tencent/mm/plugin/mmsight/model/a/k;
    //   12: getfield 1263	com/tencent/mm/plugin/mmsight/model/a/k:KXs	Lcom/tencent/mm/plugin/mmsight/SightParams;
    //   15: ifnull +973 -> 988
    //   18: invokestatic 1259	com/tencent/mm/plugin/mmsight/model/a/k:gcB	()Lcom/tencent/mm/plugin/mmsight/model/a/k;
    //   21: getfield 1263	com/tencent/mm/plugin/mmsight/model/a/k:KXs	Lcom/tencent/mm/plugin/mmsight/SightParams;
    //   24: getfield 1268	com/tencent/mm/plugin/mmsight/SightParams:KUe	I
    //   27: invokestatic 556	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: astore 10
    //   32: aload_0
    //   33: getfield 298	com/tencent/mm/media/widget/a/d:TAG	Ljava/lang/String;
    //   36: astore 11
    //   38: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   41: getfield 1271	com/tencent/mm/compatible/deviceinfo/c:lTl	I
    //   44: iconst_1
    //   45: if_icmpne +663 -> 708
    //   48: ldc_w 1273
    //   51: astore 9
    //   53: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   56: getfield 1276	com/tencent/mm/compatible/deviceinfo/c:lTm	I
    //   59: iconst_1
    //   60: if_icmpne +674 -> 734
    //   63: iconst_1
    //   64: istore 5
    //   66: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   69: getfield 1279	com/tencent/mm/compatible/deviceinfo/c:lTn	I
    //   72: iconst_1
    //   73: if_icmpne +667 -> 740
    //   76: iconst_1
    //   77: istore 6
    //   79: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   82: getfield 1282	com/tencent/mm/compatible/deviceinfo/c:lTo	I
    //   85: iconst_1
    //   86: if_icmpne +660 -> 746
    //   89: iconst_1
    //   90: istore 7
    //   92: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   95: getfield 1285	com/tencent/mm/compatible/deviceinfo/c:lTp	I
    //   98: iconst_1
    //   99: if_icmpne +653 -> 752
    //   102: iconst_1
    //   103: istore 8
    //   105: aload 11
    //   107: ldc_w 1287
    //   110: bipush 6
    //   112: anewarray 341	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload 10
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: aload 9
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: iload 5
    //   129: invokestatic 456	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   132: aastore
    //   133: dup
    //   134: iconst_3
    //   135: iload 6
    //   137: invokestatic 456	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   140: aastore
    //   141: dup
    //   142: iconst_4
    //   143: iload 7
    //   145: invokestatic 456	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   148: aastore
    //   149: dup
    //   150: iconst_5
    //   151: iload 8
    //   153: invokestatic 456	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   156: aastore
    //   157: invokestatic 429	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   163: getfield 1271	com/tencent/mm/compatible/deviceinfo/c:lTl	I
    //   166: iconst_1
    //   167: if_icmpne +591 -> 758
    //   170: aload 10
    //   172: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   175: ifeq +12 -> 187
    //   178: aload 10
    //   180: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   183: iconst_1
    //   184: if_icmpne +574 -> 758
    //   187: iconst_0
    //   188: istore 5
    //   190: iload 5
    //   192: istore 6
    //   194: aload_0
    //   195: invokevirtual 1292	com/tencent/mm/media/widget/a/d:bsu	()Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   198: ifnull +153 -> 351
    //   201: aload_0
    //   202: invokevirtual 1292	com/tencent/mm/media/widget/a/d:bsu	()Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   205: astore 9
    //   207: aload 9
    //   209: ifnonnull +582 -> 791
    //   212: aconst_null
    //   213: astore 9
    //   215: iload 5
    //   217: istore 6
    //   219: aload 9
    //   221: ifnull +130 -> 351
    //   224: aload_0
    //   225: invokevirtual 1292	com/tencent/mm/media/widget/a/d:bsu	()Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   228: astore 9
    //   230: aload 9
    //   232: ifnonnull +569 -> 801
    //   235: aconst_null
    //   236: astore 9
    //   238: iload 5
    //   240: istore 6
    //   242: aload 9
    //   244: ifnull +107 -> 351
    //   247: aload_0
    //   248: invokevirtual 1292	com/tencent/mm/media/widget/a/d:bsu	()Lcom/tencent/mm/media/widget/camerarecordview/d/b$a;
    //   251: astore 9
    //   253: iload 5
    //   255: istore 6
    //   257: aload 9
    //   259: ifnull +92 -> 351
    //   262: aload 9
    //   264: getfield 1298	com/tencent/mm/media/widget/camerarecordview/d/b$a:nKR	Ljava/util/HashMap;
    //   267: astore 9
    //   269: iload 5
    //   271: istore 6
    //   273: aload 9
    //   275: ifnull +76 -> 351
    //   278: aload 9
    //   280: aload_0
    //   281: invokevirtual 1301	com/tencent/mm/media/widget/a/d:btf	()I
    //   284: invokestatic 556	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   287: invokevirtual 1306	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   290: checkcast 1308	com/tencent/mm/media/widget/camerarecordview/d/b$a$c
    //   293: astore 9
    //   295: iload 5
    //   297: istore 6
    //   299: aload 9
    //   301: ifnull +50 -> 351
    //   304: aload 9
    //   306: getfield 1312	com/tencent/mm/media/widget/camerarecordview/d/b$a$c:nKX	Ljava/lang/Integer;
    //   309: astore 11
    //   311: aload 11
    //   313: ifnull +15 -> 328
    //   316: aload_0
    //   317: aload 11
    //   319: checkcast 1129	java/lang/Number
    //   322: invokevirtual 1132	java/lang/Number:intValue	()I
    //   325: putfield 1107	com/tencent/mm/media/widget/a/d:nGC	I
    //   328: aload 9
    //   330: getfield 1316	com/tencent/mm/media/widget/camerarecordview/d/b$a$c:nKY	Ljava/lang/Boolean;
    //   333: astore 9
    //   335: iload 5
    //   337: istore 6
    //   339: aload 9
    //   341: ifnull +10 -> 351
    //   344: aload 9
    //   346: invokevirtual 1319	java/lang/Boolean:booleanValue	()Z
    //   349: istore 6
    //   351: aload_0
    //   352: aload_0
    //   353: getfield 512	com/tencent/mm/media/widget/a/d:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   356: iload 6
    //   358: invokevirtual 1321	com/tencent/mm/media/widget/a/d:a	(Lcom/tencent/mm/compatible/deviceinfo/w;Z)Z
    //   361: pop
    //   362: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   365: getfield 1276	com/tencent/mm/compatible/deviceinfo/c:lTm	I
    //   368: iconst_1
    //   369: if_icmpne +29 -> 398
    //   372: aload 10
    //   374: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   377: ifeq +12 -> 389
    //   380: aload 10
    //   382: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   385: iconst_2
    //   386: if_icmpne +12 -> 398
    //   389: aload_0
    //   390: aload_0
    //   391: getfield 512	com/tencent/mm/media/widget/a/d:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   394: invokevirtual 1323	com/tencent/mm/media/widget/a/d:b	(Lcom/tencent/mm/compatible/deviceinfo/w;)Z
    //   397: pop
    //   398: getstatic 1327	com/tencent/mm/compatible/deviceinfo/af:lYf	Lcom/tencent/mm/compatible/deviceinfo/y;
    //   401: getfield 1332	com/tencent/mm/compatible/deviceinfo/y:lWG	I
    //   404: iconst_m1
    //   405: if_icmpeq +30 -> 435
    //   408: getstatic 1327	com/tencent/mm/compatible/deviceinfo/af:lYf	Lcom/tencent/mm/compatible/deviceinfo/y;
    //   411: getfield 1332	com/tencent/mm/compatible/deviceinfo/y:lWG	I
    //   414: iconst_1
    //   415: if_icmpne +20 -> 435
    //   418: bipush 14
    //   420: invokestatic 1335	com/tencent/mm/compatible/util/d:rd	(I)Z
    //   423: ifeq +12 -> 435
    //   426: aload_0
    //   427: aload_0
    //   428: getfield 512	com/tencent/mm/media/widget/a/d:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   431: invokevirtual 1337	com/tencent/mm/media/widget/a/d:c	(Lcom/tencent/mm/compatible/deviceinfo/w;)Z
    //   434: pop
    //   435: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   438: getfield 1282	com/tencent/mm/compatible/deviceinfo/c:lTo	I
    //   441: iconst_1
    //   442: if_icmpne +29 -> 471
    //   445: aload 10
    //   447: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   450: ifeq +12 -> 462
    //   453: aload 10
    //   455: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   458: iconst_4
    //   459: if_icmpne +12 -> 471
    //   462: aload_0
    //   463: aload_0
    //   464: getfield 512	com/tencent/mm/media/widget/a/d:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   467: invokevirtual 1339	com/tencent/mm/media/widget/a/d:a	(Lcom/tencent/mm/compatible/deviceinfo/w;)Z
    //   470: pop
    //   471: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   474: getfield 1285	com/tencent/mm/compatible/deviceinfo/c:lTp	I
    //   477: iconst_1
    //   478: if_icmpne +17 -> 495
    //   481: aload 10
    //   483: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   486: ifeq +9 -> 495
    //   489: aload 10
    //   491: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   494: pop
    //   495: aload_0
    //   496: getfield 512	com/tencent/mm/media/widget/a/d:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   499: astore 9
    //   501: aload 9
    //   503: ifnonnull +336 -> 839
    //   506: aconst_null
    //   507: astore 9
    //   509: aload 9
    //   511: ifnull +338 -> 849
    //   514: aload 9
    //   516: invokevirtual 1342	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   519: iconst_1
    //   520: if_icmpne +329 -> 849
    //   523: iconst_1
    //   524: istore_3
    //   525: iload_3
    //   526: ifeq +9 -> 535
    //   529: aload 9
    //   531: iconst_0
    //   532: invokevirtual 1345	android/hardware/Camera$Parameters:setZoom	(I)V
    //   535: aload_0
    //   536: getfield 512	com/tencent/mm/media/widget/a/d:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   539: astore 10
    //   541: aload 10
    //   543: ifnull +10 -> 553
    //   546: aload 10
    //   548: aload 9
    //   550: invokevirtual 669	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   553: aload_0
    //   554: getfield 512	com/tencent/mm/media/widget/a/d:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   557: astore 9
    //   559: aload 9
    //   561: ifnonnull +320 -> 881
    //   564: aconst_null
    //   565: astore 9
    //   567: goto +430 -> 997
    //   570: aload_0
    //   571: getfield 339	com/tencent/mm/media/widget/a/d:nvd	Ljava/util/ArrayList;
    //   574: invokevirtual 1348	java/util/ArrayList:clear	()V
    //   577: aload_0
    //   578: getfield 339	com/tencent/mm/media/widget/a/d:nvd	Ljava/util/ArrayList;
    //   581: iconst_0
    //   582: invokestatic 556	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   585: invokevirtual 1349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   588: pop
    //   589: iload_3
    //   590: i2f
    //   591: fstore_1
    //   592: aload_0
    //   593: getfield 301	com/tencent/mm/media/widget/a/d:nGp	F
    //   596: fload_1
    //   597: fadd
    //   598: fstore_1
    //   599: aload 9
    //   601: ifnull +352 -> 953
    //   604: aload 9
    //   606: invokevirtual 1352	android/hardware/Camera$Parameters:getZoomRatios	()Ljava/util/List;
    //   609: astore 9
    //   611: aload 9
    //   613: ifnull +340 -> 953
    //   616: aload 9
    //   618: checkcast 613	java/lang/Iterable
    //   621: invokeinterface 627 1 0
    //   626: astore 10
    //   628: iload 4
    //   630: istore_3
    //   631: aload 10
    //   633: invokeinterface 632 1 0
    //   638: ifeq +315 -> 953
    //   641: aload 10
    //   643: invokeinterface 635 1 0
    //   648: astore 9
    //   650: iload_3
    //   651: ifge +6 -> 657
    //   654: invokestatic 1355	kotlin/a/p:kkW	()V
    //   657: aload 9
    //   659: checkcast 553	java/lang/Integer
    //   662: astore 9
    //   664: aload 9
    //   666: ifnonnull +271 -> 937
    //   669: aconst_null
    //   670: astore 9
    //   672: aload 9
    //   674: invokevirtual 1002	java/lang/Float:floatValue	()F
    //   677: fload_1
    //   678: fcmpl
    //   679: ifle +300 -> 979
    //   682: aload_0
    //   683: getfield 301	com/tencent/mm/media/widget/a/d:nGp	F
    //   686: fload_1
    //   687: fadd
    //   688: fstore_1
    //   689: aload_0
    //   690: getfield 339	com/tencent/mm/media/widget/a/d:nvd	Ljava/util/ArrayList;
    //   693: iload_3
    //   694: invokestatic 556	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   697: invokevirtual 1349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   700: pop
    //   701: iload_3
    //   702: iconst_1
    //   703: iadd
    //   704: istore_3
    //   705: goto -74 -> 631
    //   708: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   711: getfield 1358	com/tencent/mm/compatible/deviceinfo/c:lTk	I
    //   714: iconst_1
    //   715: if_icmpne +11 -> 726
    //   718: ldc_w 1360
    //   721: astore 9
    //   723: goto -670 -> 53
    //   726: ldc_w 1362
    //   729: astore 9
    //   731: goto -678 -> 53
    //   734: iconst_0
    //   735: istore 5
    //   737: goto -671 -> 66
    //   740: iconst_0
    //   741: istore 6
    //   743: goto -664 -> 79
    //   746: iconst_0
    //   747: istore 7
    //   749: goto -657 -> 92
    //   752: iconst_0
    //   753: istore 8
    //   755: goto -650 -> 105
    //   758: getstatic 835	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   761: getfield 1358	com/tencent/mm/compatible/deviceinfo/c:lTk	I
    //   764: iconst_1
    //   765: if_icmpne +217 -> 982
    //   768: aload 10
    //   770: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   773: ifeq +12 -> 785
    //   776: aload 10
    //   778: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   781: iconst_5
    //   782: if_icmpne +200 -> 982
    //   785: iconst_1
    //   786: istore 5
    //   788: goto -598 -> 190
    //   791: aload 9
    //   793: getfield 1298	com/tencent/mm/media/widget/camerarecordview/d/b$a:nKR	Ljava/util/HashMap;
    //   796: astore 9
    //   798: goto -583 -> 215
    //   801: aload 9
    //   803: getfield 1298	com/tencent/mm/media/widget/camerarecordview/d/b$a:nKR	Ljava/util/HashMap;
    //   806: astore 9
    //   808: aload 9
    //   810: ifnonnull +9 -> 819
    //   813: aconst_null
    //   814: astore 9
    //   816: goto -578 -> 238
    //   819: aload 9
    //   821: aload_0
    //   822: invokevirtual 1301	com/tencent/mm/media/widget/a/d:btf	()I
    //   825: invokestatic 556	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   828: invokevirtual 1306	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   831: checkcast 1308	com/tencent/mm/media/widget/camerarecordview/d/b$a$c
    //   834: astore 9
    //   836: goto -598 -> 238
    //   839: aload 9
    //   841: invokevirtual 606	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   844: astore 9
    //   846: goto -337 -> 509
    //   849: iconst_0
    //   850: istore_3
    //   851: goto -326 -> 525
    //   854: astore 9
    //   856: aload_0
    //   857: getfield 298	com/tencent/mm/media/widget/a/d:TAG	Ljava/lang/String;
    //   860: ldc_w 1364
    //   863: iconst_1
    //   864: anewarray 341	java/lang/Object
    //   867: dup
    //   868: iconst_0
    //   869: aload 9
    //   871: invokevirtual 434	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   874: aastore
    //   875: invokestatic 437	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   878: goto -325 -> 553
    //   881: aload 9
    //   883: invokevirtual 606	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   886: astore 9
    //   888: goto +109 -> 997
    //   891: aload 9
    //   893: invokevirtual 1352	android/hardware/Camera$Parameters:getZoomRatios	()Ljava/util/List;
    //   896: astore 10
    //   898: aload 10
    //   900: ifnonnull +8 -> 908
    //   903: iconst_0
    //   904: istore_3
    //   905: goto -335 -> 570
    //   908: aload 10
    //   910: invokestatic 1368	kotlin/a/p:oK	(Ljava/util/List;)Ljava/lang/Object;
    //   913: checkcast 553	java/lang/Integer
    //   916: astore 10
    //   918: aload 10
    //   920: ifnonnull +8 -> 928
    //   923: iconst_0
    //   924: istore_3
    //   925: goto -355 -> 570
    //   928: aload 10
    //   930: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   933: istore_3
    //   934: goto -364 -> 570
    //   937: aload 9
    //   939: invokevirtual 1288	java/lang/Integer:intValue	()I
    //   942: i2f
    //   943: fstore_2
    //   944: fload_2
    //   945: invokestatic 733	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   948: astore 9
    //   950: goto -278 -> 672
    //   953: ldc_w 1253
    //   956: invokestatic 272	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   959: return
    //   960: astore 9
    //   962: aload_0
    //   963: getfield 298	com/tencent/mm/media/widget/a/d:TAG	Ljava/lang/String;
    //   966: ldc_w 1370
    //   969: invokestatic 387	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   972: ldc_w 1253
    //   975: invokestatic 272	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   978: return
    //   979: goto -278 -> 701
    //   982: iconst_0
    //   983: istore 5
    //   985: goto -795 -> 190
    //   988: iconst_0
    //   989: invokestatic 556	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   992: astore 10
    //   994: goto -962 -> 32
    //   997: aload 9
    //   999: ifnonnull -108 -> 891
    //   1002: iconst_0
    //   1003: istore_3
    //   1004: goto -434 -> 570
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1007	0	this	d
    //   591	98	1	f1	float
    //   943	2	2	f2	float
    //   524	480	3	i	int
    //   1	628	4	j	int
    //   64	920	5	bool1	boolean
    //   77	665	6	bool2	boolean
    //   90	658	7	bool3	boolean
    //   103	651	8	bool4	boolean
    //   51	794	9	localObject1	Object
    //   854	28	9	localException1	Exception
    //   886	63	9	localObject2	Object
    //   960	38	9	localException2	Exception
    //   30	963	10	localObject3	Object
    //   36	282	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   495	501	854	java/lang/Exception
    //   514	523	854	java/lang/Exception
    //   529	535	854	java/lang/Exception
    //   535	541	854	java/lang/Exception
    //   546	553	854	java/lang/Exception
    //   839	846	854	java/lang/Exception
    //   553	559	960	java/lang/Exception
    //   570	589	960	java/lang/Exception
    //   592	599	960	java/lang/Exception
    //   604	611	960	java/lang/Exception
    //   616	628	960	java/lang/Exception
    //   631	650	960	java/lang/Exception
    //   654	657	960	java/lang/Exception
    //   657	664	960	java/lang/Exception
    //   672	701	960	java/lang/Exception
    //   881	888	960	java/lang/Exception
    //   891	898	960	java/lang/Exception
    //   908	918	960	java/lang/Exception
    //   928	934	960	java/lang/Exception
    //   937	944	960	java/lang/Exception
  }
  
  public void btb()
  {
    AppMethodBeat.i(94030);
    if (!bsD())
    {
      AppMethodBeat.o(94030);
      return;
    }
    com.tencent.mm.media.widget.a.a.a locala = bso();
    com.tencent.mm.media.widget.a.a.a.a locala1 = com.tencent.mm.media.widget.a.a.a.nGH;
    locala.removeMessages(com.tencent.mm.media.widget.a.a.a.btj());
    AppMethodBeat.o(94030);
  }
  
  public b btc()
  {
    boolean bool = true;
    AppMethodBeat.i(94036);
    Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.lTN == null)
    {
      Log.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94036);
      return null;
    }
    if (!bsD())
    {
      Log.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94036);
      return null;
    }
    bst();
    b.uk(getPreviewWidth());
    bst();
    b.uj(getPreviewHeight());
    Object localObject = this.nGr;
    int i;
    if ((localObject != null) && ((((d.a.a)localObject).hYK == 90) || (((d.a.a)localObject).hYK == 270)))
    {
      i = 1;
      bst();
      b.um(bss().zWH);
      bst();
      b.un(bss().zWI);
      if (i != 0)
      {
        bst();
        i = b.bsM();
        bst();
        bst();
        b.um(b.bsN());
        bst();
        b.un(i);
      }
      bst();
      b.ul(getOrientation());
      bst();
      if (bsp()) {
        break label252;
      }
    }
    for (;;)
    {
      b.setFrontCamera(bool);
      bst();
      b.gw(bsq());
      localObject = bst();
      AppMethodBeat.o(94036);
      return localObject;
      i = 0;
      break;
      label252:
      bool = false;
    }
  }
  
  public void bte()
  {
    AppMethodBeat.i(94047);
    if (this.lTN != null) {
      try
      {
        Object localObject = this.lTN;
        s.checkNotNull(localObject);
        localObject = ((w)localObject).aPy();
        Log.i(this.TAG, "setPreviewCallbackImpl");
        int i = bss().zWH;
        int j = bss().zWI;
        s.checkNotNull(localObject);
        int k = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        do
        {
          j = i + 1;
          localObject = j.KXq.m(Integer.valueOf(k));
          w localw = this.lTN;
          s.checkNotNull(localw);
          localw.aj((byte[])localObject);
          i = j;
        } while (j < 5);
        this.nGs.reset();
        this.nGt.reset();
        this.nGu.reset();
        this.nGv.reset();
        this.nGw.reset();
        localObject = this.lTN;
        s.checkNotNull(localObject);
        ((w)localObject).b(new d..ExternalSyntheticLambda1(this));
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
  
  public final int btf()
  {
    AppMethodBeat.i(237788);
    if (bsp())
    {
      AppMethodBeat.o(237788);
      return 0;
    }
    AppMethodBeat.o(237788);
    return 1;
  }
  
  public final String btg()
  {
    AppMethodBeat.i(237813);
    try
    {
      localObject1 = this.lTN;
      if (localObject1 == null) {
        localObject1 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        label60:
        Object localObject2 = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
        localObject2 = b.b.but();
        continue;
        if (localObject2 == null) {
          localObject2 = "auto";
        }
      }
    }
    switch (((String)localObject1).hashCode())
    {
    case 3005871: 
      localObject1 = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
      localObject1 = b.b.but();
    case -194628547: 
    case 910005312: 
      for (;;)
      {
        AppMethodBeat.o(237813);
        return localObject1;
        localObject1 = ((w)localObject1).aPy();
        break label177;
        String str = ((Camera.Parameters)localObject1).getFocusMode();
        localObject1 = str;
        if (str != null) {
          break;
        }
        localObject1 = "auto";
        break;
        if (!((String)localObject1).equals("auto")) {
          break label60;
        }
        localObject1 = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
        localObject1 = b.b.but();
        continue;
        if (!((String)localObject1).equals("continuous-video")) {
          break label60;
        }
        localObject1 = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
        localObject1 = b.b.bur();
        continue;
        if (!((String)localObject1).equals("continuous-picture")) {
          break label60;
        }
        localObject1 = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
        localObject1 = b.b.bus();
      }
    }
  }
  
  public final boolean bth()
  {
    AppMethodBeat.i(237816);
    try
    {
      Log.i(this.TAG, "triggerAutoFocus");
      w localw = this.lTN;
      if (localw != null) {
        localw.aPA();
      }
      localw = this.lTN;
      if (localw != null) {
        localw.a(this.nuM);
      }
      AppMethodBeat.o(237816);
      return true;
    }
    catch (Exception localException)
    {
      Log.w(this.TAG, "autofocus fail, exception %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(237816);
    }
    return false;
  }
  
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
      Camera.Parameters localParameters = paramw.aPy();
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
  
  public final int ev(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237804);
    for (;;)
    {
      try
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt1, localCameraInfo);
        switch (paramInt2)
        {
        default: 
          if (!boi())
          {
            paramInt2 = localCameraInfo.orientation;
            AppMethodBeat.o(237804);
            return (360 - (paramInt1 + paramInt2) % 360) % 360;
          }
          paramInt2 = localCameraInfo.orientation;
          AppMethodBeat.o(237804);
          return (paramInt2 - paramInt1 + 360) % 360;
        }
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, s.X("setCameraDisplayOrientation failed cause ", localException.getMessage()));
        AppMethodBeat.o(237804);
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
  
  public final boolean ew(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237787);
    try
    {
      Object localObject = this.lTN;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((w)localObject).aPy())
      {
        if (localObject != null) {
          ((Camera.Parameters)localObject).setPreviewSize(paramInt1, paramInt2);
        }
        w localw = this.lTN;
        if (localw != null) {
          localw.c((Camera.Parameters)localObject);
        }
        AppMethodBeat.o(237787);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(237787);
    }
  }
  
  public final boolean f(Rect paramRect1, Rect paramRect2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(237809);
    s.u(paramRect1, "focusArea");
    s.u(paramRect2, "meteringArea");
    for (;;)
    {
      Object localObject1;
      try
      {
        Log.i(this.TAG, "focus on area :: focus rect %s, meter rect %s", new Object[] { paramRect1, paramRect2 });
        localObject1 = this.lTN;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label291;
          if ((localObject2 == null) || (!((List)localObject2).contains("auto"))) {
            break label299;
          }
          ((Camera.Parameters)localObject1).setFocusMode("auto");
          break label299;
          if (i <= 0) {
            break label309;
          }
          localObject2 = new ArrayList(1);
          ((ArrayList)localObject2).add(new Camera.Area(paramRect1, 1000));
          if (localObject1 == null) {
            break label309;
          }
          ((Camera.Parameters)localObject1).setFocusAreas((List)localObject2);
          break label309;
          if (i > 0)
          {
            paramRect1 = new ArrayList(1);
            paramRect1.add(new Camera.Area(paramRect2, 1000));
            if (localObject1 != null) {
              ((Camera.Parameters)localObject1).setMeteringAreas((List)paramRect1);
            }
          }
          paramRect1 = this.lTN;
          if (paramRect1 != null) {
            paramRect1.c((Camera.Parameters)localObject1);
          }
          paramRect1 = this.lTN;
          if (paramRect1 != null) {
            paramRect1.a(this.nuM);
          }
          AppMethodBeat.o(237809);
          return true;
        }
        else
        {
          localObject1 = ((w)localObject1).aPy();
        }
      }
      catch (Exception paramRect1)
      {
        Log.w(this.TAG, "autofocus with area fail, exception %s", new Object[] { paramRect1.getMessage() });
        AppMethodBeat.o(237809);
        return false;
      }
      localObject2 = ((Camera.Parameters)localObject1).getSupportedFocusModes();
      continue;
      int i = ((Camera.Parameters)localObject1).getMaxNumFocusAreas();
      continue;
      i = ((Camera.Parameters)localObject1).getMaxNumMeteringAreas();
      continue;
      label291:
      if (localObject1 == null)
      {
        continue;
        label299:
        if (localObject1 == null)
        {
          i = 0;
          continue;
          label309:
          if (localObject1 == null) {
            i = 0;
          }
        }
      }
    }
  }
  
  public final int getFlashMode()
  {
    String str = null;
    AppMethodBeat.i(94056);
    Object localObject = this.lTN;
    if (localObject == null) {
      if (str != null) {
        switch (str.hashCode())
        {
        }
      }
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(94056);
          return 2;
          localObject = ((w)localObject).aPy();
          if (localObject == null) {
            break;
          }
          str = ((Camera.Parameters)localObject).getFlashMode();
          break;
        } while (!str.equals("auto"));
        AppMethodBeat.o(94056);
        return 3;
      } while (!str.equals("off"));
      AppMethodBeat.o(94056);
      return 2;
    } while (!str.equals("on"));
    AppMethodBeat.o(94056);
    return 1;
  }
  
  protected final int getOrientation()
  {
    AppMethodBeat.i(94040);
    if ((this.nGr != null) && (bsD()))
    {
      d.a.a locala = this.nGr;
      if (locala == null)
      {
        AppMethodBeat.o(94040);
        return 0;
      }
      int i = locala.hYK;
      AppMethodBeat.o(94040);
      return i;
    }
    AppMethodBeat.o(94040);
    return -1;
  }
  
  public int getPreviewHeight()
  {
    AppMethodBeat.i(94037);
    if (this.lTN == null)
    {
      AppMethodBeat.o(94037);
      return 0;
    }
    if (this.nGr != null) {
      try
      {
        if ((bsq()) && (bsw() != null))
        {
          Point localPoint = bsw();
          s.checkNotNull(localPoint);
          i = localPoint.y;
          AppMethodBeat.o(94037);
          return i;
        }
        int i = bss().zWI;
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
    if (this.lTN == null)
    {
      AppMethodBeat.o(94038);
      return 0;
    }
    if (this.nGr != null) {
      try
      {
        if ((bsq()) && (bsw() != null))
        {
          Point localPoint = bsw();
          s.checkNotNull(localPoint);
          i = localPoint.x;
          AppMethodBeat.o(94038);
          return i;
        }
        int i = bss().zWH;
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
    int m = 10;
    AppMethodBeat.i(94033);
    if ((this.nGz != null) || (this.lTN != null)) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = this.lTN;
        s.checkNotNull(localObject3);
        localObject3 = ((w)localObject3).aPy();
        s.checkNotNull(localObject3);
        boolean bool = ((Camera.Parameters)localObject3).isZoomSupported();
        if (!bool)
        {
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            break label218;
          }
          this.nGz = new com.tencent.tinker.a.c.b();
          localObject1 = this.nGz;
          s.checkNotNull(localObject1);
          localObject1 = new float[((com.tencent.tinker.a.c.b)localObject1).mSize];
          localObject3 = this.nGz;
          s.checkNotNull(localObject3);
          k = ((com.tencent.tinker.a.c.b)localObject3).mSize;
          if (k > 0)
          {
            i = 0;
            j = i + 1;
            localObject3 = this.nGz;
            s.checkNotNull(localObject3);
            localObject1[i] = (localObject3.Sk[i] * 1.0F / 10.0F);
            if (j < k) {
              break label477;
            }
          }
          AppMethodBeat.o(94033);
          return localObject1;
        }
        localObject1 = ((Camera.Parameters)localObject3).getZoomRatios();
        continue;
        localObject2 = null;
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "getZoom error: %s", new Object[] { localException.getMessage() });
      }
      Object localObject2;
      continue;
      label218:
      int n = ((Number)localObject2.get(localObject2.size() - 1)).intValue();
      int i = n;
      int j = 1;
      while (i / 10 >= 10)
      {
        j *= 10;
        i /= 10;
      }
      i = n / j;
      int k = i;
      if ((n + 4) / j > i) {
        k = i + 1;
      }
      this.nGz = new com.tencent.tinker.a.c.b(k);
      if (10 <= k)
      {
        i = m;
        label311:
        m = i;
        n = m + 1;
        if (localObject2.indexOf(Integer.valueOf(m * j)) < 0)
        {
          i = 1;
          label339:
          if (i <= 4)
          {
            if (localObject2.indexOf(Integer.valueOf(m * j - i)) <= 0) {
              break label399;
            }
            localObject3 = this.nGz;
            s.checkNotNull(localObject3);
            ((com.tencent.tinker.a.c.b)localObject3).pX(m, m * j - i);
          }
        }
        for (;;)
        {
          i = n;
          if (m != k) {
            break label311;
          }
          break;
          label399:
          if (localObject2.indexOf(Integer.valueOf(m * j + i)) > 0)
          {
            localObject3 = this.nGz;
            s.checkNotNull(localObject3);
            ((com.tencent.tinker.a.c.b)localObject3).pX(m, i + m * j);
          }
          else
          {
            i += 1;
            break label339;
            localObject3 = this.nGz;
            s.checkNotNull(localObject3);
            ((com.tencent.tinker.a.c.b)localObject3).pX(m, m * j);
          }
        }
        label477:
        i = j;
      }
    }
  }
  
  public Point gx(boolean paramBoolean)
  {
    AppMethodBeat.i(94039);
    if (!paramBoolean)
    {
      localPoint = new Point(bss().zWH, bss().zWI);
      AppMethodBeat.o(94039);
      return localPoint;
    }
    if (bsw() != null)
    {
      localPoint = bsw();
      s.checkNotNull(localPoint);
      AppMethodBeat.o(94039);
      return localPoint;
    }
    Point localPoint = new Point(bss().zWH, bss().zWI);
    AppMethodBeat.o(94039);
    return localPoint;
  }
  
  public final void gy(boolean paramBoolean)
  {
    AppMethodBeat.i(94055);
    try
    {
      Object localObject = this.lTN;
      if (localObject == null)
      {
        localObject = null;
        if (!paramBoolean) {
          break label61;
        }
        if (localObject != null) {
          ((Camera.Parameters)localObject).setFlashMode("torch");
        }
      }
      for (;;)
      {
        w localw = this.lTN;
        if (localw == null) {
          break label94;
        }
        localw.c((Camera.Parameters)localObject);
        AppMethodBeat.o(94055);
        return;
        localObject = ((w)localObject).aPy();
        break;
        label61:
        if (localObject != null) {
          ((Camera.Parameters)localObject).setFlashMode("off");
        }
      }
      label94:
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "set flash mode error", new Object[0]);
      AppMethodBeat.o(94055);
    }
  }
  
  public void h(boolean paramBoolean, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(94032);
    if ((this.lTN != null) && (bsD())) {}
    for (;;)
    {
      try
      {
        Log.d(this.TAG, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (bsy())
        {
          Log.d(this.TAG, "triggerSmallZoom, zooming, ignore");
          return;
        }
        Object localObject1 = this.lTN;
        int j;
        if (localObject1 == null)
        {
          localObject1 = null;
          if ((localObject1 == null) || (((Camera.Parameters)localObject1).isZoomSupported() != true)) {
            break label488;
          }
          if (i == 0) {
            continue;
          }
          gu(true);
          i = ((Camera.Parameters)localObject1).getZoom();
          j = this.nvd.indexOf(Integer.valueOf(i));
          int k = ((Camera.Parameters)localObject1).getMaxZoom();
          Log.d(this.TAG, "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(bsz()), Integer.valueOf(bsx()), Integer.valueOf(paramInt) });
          if (!paramBoolean) {
            continue;
          }
          if (i < k) {}
        }
        else
        {
          localObject1 = ((w)localObject1).aPy();
          continue;
        }
        if (j == this.nvd.size() - 1)
        {
          paramInt = ((Number)kotlin.a.p.oM((List)this.nvd)).intValue();
          Log.d(this.TAG, "triggerSmallZoom, nextZoom: %s, smoothZoomSupported: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(((Camera.Parameters)localObject1).isSmoothZoomSupported()) });
          ((Camera.Parameters)localObject1).setZoom(paramInt);
          localObject3 = this.lTN;
          if (localObject3 != null) {
            ((w)localObject3).c((Camera.Parameters)localObject1);
          }
          return;
        }
        Object localObject3 = this.nvd.get(j + 1);
        s.s(localObject3, "{\n                      …                        }");
        paramInt = ((Number)localObject3).intValue();
        continue;
        if (i == 0) {
          return;
        }
        if (j == 0)
        {
          paramInt = ((Number)kotlin.a.p.oK((List)this.nvd)).intValue();
          continue;
        }
        localObject3 = this.nvd.get(j - 1);
        s.s(localObject3, "{\n                      …                        }");
        paramInt = ((Number)localObject3).intValue();
        continue;
        AppMethodBeat.o(94032);
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        gu(false);
        AppMethodBeat.o(94032);
      }
      return;
      label488:
      i = 0;
    }
  }
  
  public final void release()
  {
    int j = 1;
    AppMethodBeat.i(94054);
    super.release();
    for (;;)
    {
      int i;
      try
      {
        Log.i(this.TAG, this.nGs.getValue());
        Log.i(this.TAG, this.nGt.getValue());
        Log.i(this.TAG, this.nGu.getValue());
        Log.i(this.TAG, this.nGv.getValue());
        Log.i(this.TAG, this.nGw.getValue());
        if (this.lTN != null)
        {
          long l = Util.currentTicks();
          Log.i(this.TAG, "release camera beg, %s", new Object[] { Looper.myLooper() });
          bso().removeCallbacksAndMessages(null);
          this.nGA = true;
          if (bsu() == null) {
            continue;
          }
          localObject1 = bsu();
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = bsu();
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
            i = j;
            if (localObject1 == null) {
              break label411;
            }
            if (!s.p(localObject1, Boolean.FALSE)) {
              break label418;
            }
            i = j;
            break label411;
            if (localObject1 != null)
            {
              ((Boolean)localObject1).booleanValue();
              localObject1 = this.lTN;
              if (localObject1 != null) {
                ((w)localObject1).a(null);
              }
            }
            localObject1 = this.lTN;
            if (localObject1 != null) {
              ((w)localObject1).auq();
            }
            localObject1 = this.lTN;
            if (localObject1 != null) {
              ((w)localObject1).release();
            }
            this.lTN = null;
            Log.i(this.TAG, "release camera end, use %dms, %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
          }
        }
        else
        {
          bso().nGO = true;
          d(null);
          this.nGy = null;
          gv(false);
          AppMethodBeat.o(94054);
          return;
        }
        Object localObject1 = ((b.a)localObject1).nKT;
        continue;
        localObject1 = ((b.a)localObject1).nKT;
        if (localObject1 == null)
        {
          localObject1 = null;
          continue;
        }
        b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
        localObject1 = Boolean.valueOf(((HashSet)localObject1).contains(b.b.buu()));
        continue;
        localObject1 = this.lTN;
        if (localObject1 == null) {
          continue;
        }
        ((w)localObject1).a(null);
        continue;
        if (i == 0) {
          break label423;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "cameraRelease error", new Object[0]);
        AppMethodBeat.o(94054);
        return;
      }
      for (;;)
      {
        label411:
        break;
        label418:
        i = 0;
      }
      label423:
      Object localObject2 = null;
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
      gy(false);
      AppMethodBeat.o(94057);
      return;
      gy(true);
    }
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(94034);
    if (bsy())
    {
      Log.d(this.TAG, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94034);
      return;
    }
    if (this.lTN != null) {
      try
      {
        Object localObject1 = this.lTN;
        s.checkNotNull(localObject1);
        localObject1 = ((w)localObject1).aPy();
        s.checkNotNull(localObject1);
        boolean bool = ((Camera.Parameters)localObject1).isZoomSupported();
        if (!bool) {
          return;
        }
        if (this.nGz == null)
        {
          Log.d(this.TAG, "setForceZoomTargetRatio before init zoom info, ignore");
          return;
        }
        Object localObject3 = ((Camera.Parameters)localObject1).getZoomRatios();
        com.tencent.tinker.a.c.b localb = this.nGz;
        s.checkNotNull(localb);
        int i = ((List)localObject3).indexOf(Integer.valueOf(localb.aIF(kotlin.h.a.eH(10.0F * paramFloat))));
        if (i >= 0)
        {
          int j = ((Camera.Parameters)localObject1).getMaxZoom();
          if (i <= j) {}
        }
        else
        {
          return;
        }
        gu(true);
        ((Camera.Parameters)localObject1).setZoom(i);
        localObject3 = this.lTN;
        s.checkNotNull(localObject3);
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
        gu(false);
        AppMethodBeat.o(94034);
      }
    }
    AppMethodBeat.o(94034);
  }
  
  public final boolean uh(int paramInt)
  {
    AppMethodBeat.i(237800);
    try
    {
      w localw = this.lTN;
      if (localw != null) {
        localw.aPy();
      }
      AppMethodBeat.o(237800);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "open scene " + paramInt + " open failed, error:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(237800);
    }
    return false;
  }
  
  public final void up(int paramInt)
  {
    AppMethodBeat.i(94031);
    if (bsx() > 0)
    {
      AppMethodBeat.o(94031);
      return;
    }
    Object localObject = aw.bf(MMApplicationContext.getContext());
    int i = ((Point)localObject).y;
    Log.i(this.TAG, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94031);
      return;
    }
    for (;;)
    {
      try
      {
        if (this.lTN == null) {
          continue;
        }
        localObject = this.lTN;
        if (localObject == null)
        {
          localObject = null;
          break label219;
          double d = i / (paramInt / 3.0D / 10.0D);
          if (d > 0.0D) {
            ug((int)d + 1);
          }
          Log.i(this.TAG, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(bsx()), Integer.valueOf(i) });
          AppMethodBeat.o(94031);
        }
        else
        {
          localObject = ((w)localObject).aPy();
        }
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(94031);
        return;
      }
      i = ((Camera.Parameters)localObject).getMaxZoom();
      continue;
      label219:
      if (localException == null) {
        i = 0;
      }
    }
  }
  
  public final void ur(int paramInt)
  {
    this.nGC = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.d
 * JD-Core Version:    0.7.0.1
 */