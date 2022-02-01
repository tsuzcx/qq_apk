package com.tencent.mm.media.widget.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Looper;
import android.util.Size;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "useBack", "", "(Landroid/content/Context;Z)V", "DEFAULT_UPPER_BOUND", "", "SMALL_ZOOM_STEP_NUM", "getSMALL_ZOOM_STEP_NUM", "()I", "SMALL_ZOOM_STEP_UPPER_BOUND", "getSMALL_ZOOM_STEP_UPPER_BOUND", "SMALL_ZOOM_STEP_VAL", "TAG", "", "availableZoomRatioIndexList", "Ljava/util/ArrayList;", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "cameraCallback", "Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "cameraCropCallback", "cameraPreviewCallback", "cropSize", "Landroid/graphics/Point;", "getCropSize", "()Landroid/graphics/Point;", "setCropSize", "(Landroid/graphics/Point;)V", "currentFrameData", "", "finishCallbackTimeCallback", "frameDataCallbackList", "", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getFrameDataCallbackList", "()Ljava/util/List;", "setFrameDataCallbackList", "(Ljava/util/List;)V", "isCameraOpen", "isZooming", "()Z", "setZooming", "(Z)V", "lock", "Ljava/lang/Object;", "mCameraFps", "getMCameraFps", "setMCameraFps", "(I)V", "mZoomTimesToRatio", "Lcom/tencent/tinker/android/utils/SparseIntArray;", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "openCameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "getOpenCameraRes", "()Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "setOpenCameraRes", "(Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;)V", "prevcameraCallback", "scrollSmallZoomStep", "getScrollSmallZoomStep", "setScrollSmallZoomStep", "sightHandler", "Lcom/tencent/mm/media/widget/camera/CameraHandler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera/CameraHandler;", "smallZoomStep", "getSmallZoomStep", "setSmallZoomStep", "takePictureLock", "addFrameDataCallback", "callback", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "configVendorTagValue", "tag", "value", "dispatchCameraFrame", "frame", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getAvailableZoomRatioIndexList", "parameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getCameraOrientation", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "getPreviewWidth", "getSupportZoomRatios", "", "initCamera", "initRawRatios", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "safeResetZoom", "safeSetFocusMode", "safeSetMetering", "safeSetPreviewFormat", "safeSetPreviewFrameRate", "useFixMode", "safeSetPreviewSize", "resolutionLimit", "safeSetPreviewSizeWithLimitAndRatio", "sizeLimit", "displayRatio", "safeSetStabilization", "selectNoCropPreviewSize", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewCallbackImpl", "setPreviewCallbackImplInGPUCrop", "setPreviewDisplayRatio", "setSafeConfig", "startPreview", "useCpuCrop", "startPreviewWithCPU", "startPreviewWithGPU", "switchVendorTag", "isChecked", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "p", "trySetPreviewFrameRateParameters", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  private final String TAG;
  private boolean aNN;
  v fFt;
  private final int gXE;
  private final int gXF;
  private final int gXG;
  List<g> gXH;
  private final c gXI;
  d.a.a gXJ;
  Point gXK;
  private int gXL;
  private int gXM;
  private final com.tencent.mm.plugin.mmsight.model.c gXN;
  private final com.tencent.mm.plugin.mmsight.model.c gXO;
  private final com.tencent.mm.plugin.mmsight.model.c gXP;
  private final com.tencent.mm.plugin.mmsight.model.c gXQ;
  private final com.tencent.mm.plugin.mmsight.model.c gXR;
  private volatile boolean gXS;
  private volatile byte[] gXT;
  private boolean gXU;
  private final int gXV;
  private com.tencent.tinker.a.c.b gXW;
  private final ArrayList<Integer> gXX;
  private d.g.a.b<? super Boolean, y> gXY;
  private int gXZ;
  private final Object lock;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94058);
    this.TAG = "MicroMsg.CommonCamera1";
    this.gXE = 40;
    this.gXF = 5;
    this.gXG = 10;
    this.gXH = ((List)new ArrayList());
    paramContext = Looper.getMainLooper();
    d.g.b.k.g(paramContext, "Looper.getMainLooper()");
    this.gXI = new c(paramContext);
    this.gXL = -1;
    this.gXM = -1;
    this.gXN = new com.tencent.mm.plugin.mmsight.model.c("prevcameraCallback");
    this.gXO = new com.tencent.mm.plugin.mmsight.model.c("cameraCallback");
    this.gXP = new com.tencent.mm.plugin.mmsight.model.c("cameraPreviewCallback");
    this.gXQ = new com.tencent.mm.plugin.mmsight.model.c("cameraCropCallback");
    this.gXR = new com.tencent.mm.plugin.mmsight.model.c("finishCallbackTimeCallback");
    this.gXV = 2100;
    this.gXX = new ArrayList();
    this.lock = new Object();
    AppMethodBeat.o(94058);
  }
  
  private final boolean U(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94051);
    bs.Gn();
    synchronized (this.lock)
    {
      if (this.gXH != null)
      {
        int i = this.gXH.size();
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(94051);
        return false;
      }
      Iterator localIterator = this.gXH.iterator();
      boolean bool1 = false;
      while (localIterator.hasNext())
      {
        boolean bool2 = ((g)localIterator.next()).V(paramArrayOfByte);
        bool1 |= bool2;
      }
      AppMethodBeat.o(94051);
      return bool1;
    }
  }
  
  private final void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(94024);
    long l = bs.Gn();
    ac.i(this.TAG, "start startPreviewWithCPU,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (atn())
    {
      ac.i(this.TAG, "startPreviewWithCPU, camera previewing");
      AppMethodBeat.o(94024);
      return;
    }
    try
    {
      ny(paramInt);
      atw();
      atA();
      if (a(paramSurfaceTexture, paramSurfaceHolder)) {
        a(a.a.gXg);
      }
      ac.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(bs.aO(l)), Looper.myLooper() });
      AppMethodBeat.o(94024);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        ac.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arx();
      }
    }
  }
  
  private final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94027);
    v localv = this.fFt;
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
          ac.i(this.TAG, "doStartPreview finish");
          paramSurfaceTexture = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.arw();
          AppMethodBeat.o(94027);
          return true;
          localv.setPreviewDisplay(paramSurfaceHolder);
        }
      }
      ac.i(this.TAG, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.arx();
      AppMethodBeat.o(94027);
      return false;
    }
    AppMethodBeat.o(94027);
    return false;
  }
  
  private boolean a(v paramv)
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
        d.g.b.k.g(localParameters, "p");
        localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          ac.i(this.TAG, "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          this.gXI.gXv = localParameters.getFocusMode();
          paramv.setParameters(localParameters);
          AppMethodBeat.o(94042);
          return true;
        }
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          ac.i(this.TAG, "support continuous video");
          localParameters.setFocusMode("continuous-video");
          continue;
        }
        if (localList == null) {
          break label200;
        }
      }
      catch (Exception paramv)
      {
        ac.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(94042);
        return false;
      }
      if (localList.contains("auto"))
      {
        ac.i(this.TAG, "support auto focus");
        localParameters.setFocusMode("auto");
      }
      else
      {
        label200:
        ac.i(this.TAG, "not support continuous video or auto focus");
      }
    }
  }
  
  private final boolean a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(94041);
    if (paramv == null)
    {
      AppMethodBeat.o(94041);
      return false;
    }
    int i;
    label319:
    int i1;
    int i3;
    int i2;
    label496:
    int m;
    int n;
    for (;;)
    {
      Camera.Parameters localParameters;
      try
      {
        localParameters = paramv.getParameters();
        if (!paramBoolean) {
          break label319;
        }
        Object localObject1;
        if (ae.fJd.fET > 0)
        {
          ac.i(this.gWT, "set frame rate > 0, do not try set preview frame rate");
          d.g.b.k.g(localParameters, "p");
          localObject1 = localParameters.getSupportedPreviewFrameRates();
          ac.i(this.gWT, "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localObject1 });
          paramv.setParameters(localParameters);
          AppMethodBeat.o(94041);
          return true;
        }
        if (localParameters == null)
        {
          ac.e(this.TAG, "trySetPreviewFrameRateParameters error, p is null!");
          continue;
        }
        try
        {
          localObject1 = localParameters.getSupportedPreviewFrameRates();
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            continue;
          }
          if (this.gXZ != 0)
          {
            i = this.gXZ;
            localObject1 = Collections.max((Collection)localObject1);
            d.g.b.k.g(localObject1, "Collections.max(fr)");
            i = Math.min(i, ((Number)localObject1).intValue());
            localParameters.setPreviewFrameRate(i);
            ac.i(this.gWT, "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
        }
        catch (Exception localException1)
        {
          ac.i(this.gWT, "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException1.getMessage() });
        }
      }
      catch (Exception paramv)
      {
        ac.i(this.gWT, "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(94041);
        return false;
      }
      Object localObject2;
      for (;;)
      {
        break;
        localObject2 = Collections.max((Collection)localException1);
        d.g.b.k.g(localObject2, "Collections.max(fr)");
        i = Math.min(30, ((Number)localObject2).intValue());
      }
      d.g.b.k.g(localParameters, "p");
      if (ae.fJd.fET > 0)
      {
        ac.i(this.gWT, "set frame rate > 0, do not try set preview fps range");
      }
      else
      {
        localObject2 = localParameters.getSupportedPreviewFpsRange();
        if ((localObject2 != null) && (((List)localObject2).size() != 0))
        {
          j = -2147483648;
          k = -2147483648;
          i = 0;
          int i4 = ((List)localObject2).size();
          i1 = 0;
          if (i1 < i4)
          {
            int[] arrayOfInt = (int[])((List)localObject2).get(i1);
            if ((arrayOfInt == null) || (arrayOfInt.length <= 1)) {
              break label669;
            }
            i3 = arrayOfInt[0];
            i2 = arrayOfInt[1];
            ac.i(this.TAG, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(i2) });
            if (i3 < 0) {
              break label678;
            }
            if (i2 >= i3) {
              break label681;
            }
            break label678;
            if (this.gXZ == 0) {
              break label719;
            }
            if (i2 < this.gXZ * 1000) {
              break;
            }
            i = 1;
            k = m;
            j = n;
            break label669;
          }
          ac.i(this.gWT, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(30) });
          if ((j != 2147483647) && (k != 2147483647)) {
            try
            {
              localParameters.setPreviewFpsRange(j, k);
              ac.i(this.gWT, "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            }
            catch (Exception localException2)
            {
              ac.i(this.gWT, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException2.getMessage() });
            }
          }
        }
      }
    }
    label658:
    int k = m;
    int j = n;
    for (;;)
    {
      label669:
      i1 += 1;
      break;
      label678:
      continue;
      label681:
      m = k;
      n = j;
      if (i2 < k) {
        break label496;
      }
      m = k;
      n = j;
      if (i != 0) {
        break label496;
      }
      m = i2;
      n = i3;
      break label496;
      label719:
      if (i2 < 30000) {
        break label658;
      }
      i = 1;
      k = m;
      j = n;
    }
  }
  
  private final void atA()
  {
    AppMethodBeat.i(94046);
    if (this.fFt == null)
    {
      AppMethodBeat.o(94046);
      return;
    }
    try
    {
      if (this.fFt == null) {
        break label233;
      }
      Object localObject1 = this.fFt;
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
      ac.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94046);
      return;
    }
    int i = this.gXb.qCH;
    int j = this.gXb.qCI;
    j = ImageFormat.getBitsPerPixel(localException.getPreviewFormat()) * (i * j) / 8;
    ac.i(this.TAG, "setPreviewCallbackImpl  size: ".concat(String.valueOf(j)));
    i = 0;
    for (;;)
    {
      Object localObject2;
      if (i < 5)
      {
        localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.uMV.g(Integer.valueOf(j));
        v localv = this.fFt;
        if (localv != null) {
          localv.addCallbackBuffer((byte[])localObject2);
        }
      }
      else
      {
        this.gXN.reset();
        this.gXO.reset();
        this.gXP.reset();
        this.gXQ.reset();
        this.gXR.reset();
        localObject2 = this.fFt;
        if (localObject2 != null)
        {
          ((v)localObject2).setPreviewCallbackWithBuffer((Camera.PreviewCallback)new a(this));
          AppMethodBeat.o(94046);
          return;
        }
        label233:
        AppMethodBeat.o(94046);
        return;
      }
      i += 1;
    }
  }
  
  private void atB()
  {
    AppMethodBeat.i(94047);
    if (this.fFt != null) {
      try
      {
        Object localObject = this.fFt;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        localObject = ((v)localObject).getParameters();
        ac.i(this.TAG, "setPreviewCallbackImpl");
        int i = this.gXb.qCH;
        int j = this.gXb.qCI;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = com.tencent.mm.plugin.mmsight.model.a.j.uMV.g(Integer.valueOf(j));
          v localv = this.fFt;
          if (localv == null) {
            d.g.b.k.fOy();
          }
          localv.addCallbackBuffer((byte[])localObject);
          i += 1;
        }
        this.gXN.reset();
        this.gXO.reset();
        this.gXP.reset();
        this.gXQ.reset();
        this.gXR.reset();
        localObject = this.fFt;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        ((v)localObject).setPreviewCallbackWithBuffer((Camera.PreviewCallback)new b(this));
        AppMethodBeat.o(94047);
        return;
      }
      catch (Exception localException)
      {
        ac.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94047);
  }
  
  private final void atw()
  {
    AppMethodBeat.i(94028);
    Integer localInteger = Integer.valueOf(0);
    Object localObject = com.tencent.mm.plugin.mmsight.model.a.k.ddS();
    d.g.b.k.g(localObject, "MMSightController.getInstance()");
    if (((com.tencent.mm.plugin.mmsight.model.a.k)localObject).ddT() != null)
    {
      localObject = com.tencent.mm.plugin.mmsight.model.a.k.ddS();
      d.g.b.k.g(localObject, "MMSightController.getInstance()");
      localInteger = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.a.k)localObject).ddT().uJG);
    }
    String str = this.TAG;
    if (ae.fJd.fEY == 1) {
      localObject = "Range";
    }
    for (;;)
    {
      boolean bool1;
      label92:
      boolean bool2;
      label104:
      boolean bool3;
      label116:
      boolean bool4;
      if (ae.fJd.fEZ == 1)
      {
        bool1 = true;
        if (ae.fJd.fFa != 1) {
          break label417;
        }
        bool2 = true;
        if (ae.fJd.fFb != 1) {
          break label422;
        }
        bool3 = true;
        if (ae.fJd.fFc != 1) {
          break label427;
        }
        bool4 = true;
        label129:
        ac.i(str, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
        if ((ae.fJd.fEY != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 1))) {
          break label433;
        }
        a(this.fFt, false);
        label218:
        if ((ae.fJd.fEZ == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
          b(this.fFt);
        }
        if ((ae.fJk.fHR != -1) && (ae.fJk.fHR == 1) && (com.tencent.mm.compatible.util.d.lb(14))) {
          c(this.fFt);
        }
        if ((ae.fJd.fFb == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
          a(this.fFt);
        }
        if ((ae.fJd.fFc == 1) && (localInteger.intValue() != 0)) {
          localInteger.intValue();
        }
        atz();
      }
      try
      {
        localObject = this.fFt;
        if (localObject != null) {}
        for (localObject = ((v)localObject).getParameters();; localObject = null)
        {
          d((Camera.Parameters)localObject);
          AppMethodBeat.o(94028);
          return;
          if (ae.fJd.fEX == 1)
          {
            localObject = "Fix";
            break;
          }
          localObject = "Error";
          break;
          bool1 = false;
          break label92;
          label417:
          bool2 = false;
          break label104;
          label422:
          bool3 = false;
          break label116;
          label427:
          bool4 = false;
          break label129;
          label433:
          if ((ae.fJd.fEX != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
            break label218;
          }
          a(this.fFt, true);
          break label218;
        }
        return;
      }
      catch (Exception localException)
      {
        ac.i(this.TAG, "current get parameters is null");
        AppMethodBeat.o(94028);
      }
    }
  }
  
  private void atz()
  {
    AppMethodBeat.i(94043);
    try
    {
      Object localObject = this.fFt;
      if (localObject != null) {}
      for (localObject = ((v)localObject).getParameters();; localObject = null)
      {
        if ((localObject != null) && (((Camera.Parameters)localObject).isZoomSupported() == true)) {
          ((Camera.Parameters)localObject).setZoom(0);
        }
        v localv = this.fFt;
        if (localv == null) {
          break;
        }
        localv.setParameters((Camera.Parameters)localObject);
        AppMethodBeat.o(94043);
        return;
      }
      AppMethodBeat.o(94043);
      return;
    }
    catch (Exception localException)
    {
      ac.e(this.TAG, "safeResetZoom error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94043);
    }
  }
  
  private final void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(94025);
    long l = bs.Gn();
    ac.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (atn())
    {
      ac.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94025);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.gXa) {
          continue;
        }
        i(paramInt, this.gWZ);
        atB();
        atw();
        if (a(paramSurfaceTexture, paramSurfaceHolder)) {
          a(a.a.gXg);
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        ac.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arx();
        continue;
      }
      ac.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(bs.aO(l)), Looper.myLooper() });
      AppMethodBeat.o(94025);
      return;
      nz(paramInt);
    }
  }
  
  private boolean b(v paramv)
  {
    AppMethodBeat.i(94044);
    if (paramv == null)
    {
      AppMethodBeat.o(94044);
      return false;
    }
    try
    {
      ac.i(this.TAG, "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramv.getParameters();
      d.g.b.k.g(localParameters, "p");
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        ac.e(this.TAG, "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramv.setParameters(localParameters);
      AppMethodBeat.o(94044);
      return true;
    }
    catch (Exception paramv)
    {
      ac.i(this.TAG, "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
      AppMethodBeat.o(94044);
    }
    return false;
  }
  
  @TargetApi(14)
  private boolean c(v paramv)
  {
    AppMethodBeat.i(94045);
    if (paramv == null)
    {
      AppMethodBeat.o(94045);
      return false;
    }
    try
    {
      ac.i(this.TAG, "safeSetMetering");
      Camera.Parameters localParameters = paramv.getParameters();
      d.g.b.k.g(localParameters, "params");
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
      ac.i(this.TAG, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
      AppMethodBeat.o(94045);
    }
    return false;
  }
  
  private final void d(Camera.Parameters paramParameters)
  {
    int j = 0;
    AppMethodBeat.i(94035);
    int i;
    if (paramParameters != null)
    {
      Object localObject = paramParameters.getZoomRatios();
      if (localObject != null)
      {
        localObject = (Integer)d.a.j.iO((List)localObject);
        if (localObject != null)
        {
          i = ((Integer)localObject).intValue();
          this.gXX.clear();
          this.gXX.add(Integer.valueOf(0));
          int k = this.gXG;
          if (paramParameters == null) {
            break label174;
          }
          paramParameters = paramParameters.getZoomRatios();
          if (paramParameters == null) {
            break label174;
          }
          paramParameters = ((Iterable)paramParameters).iterator();
          i = k + i;
          label97:
          if (!paramParameters.hasNext()) {
            break label167;
          }
          localObject = paramParameters.next();
          if (j < 0) {
            d.a.j.fOc();
          }
          if (d.g.b.k.compare(((Integer)localObject).intValue(), i) <= 0) {
            break label181;
          }
          i = this.gXG + i;
          this.gXX.add(Integer.valueOf(j));
        }
      }
    }
    label167:
    label174:
    label181:
    for (;;)
    {
      j += 1;
      break label97;
      i = 0;
      break;
      AppMethodBeat.o(94035);
      return;
      AppMethodBeat.o(94035);
      return;
    }
  }
  
  private final int getOrientation()
  {
    AppMethodBeat.i(94040);
    if ((this.gXJ != null) && (atn()))
    {
      d.a.a locala = this.gXJ;
      if (locala != null)
      {
        int i = locala.duc;
        AppMethodBeat.o(94040);
        return i;
      }
      AppMethodBeat.o(94040);
      return 0;
    }
    AppMethodBeat.o(94040);
    return -1;
  }
  
  private final int getPreviewHeight()
  {
    AppMethodBeat.i(94037);
    if (this.fFt == null)
    {
      AppMethodBeat.o(94037);
      return 0;
    }
    if (this.gXJ != null) {
      try
      {
        if ((this.gWY) && (this.gXK != null))
        {
          Point localPoint = this.gXK;
          if (localPoint == null) {
            d.g.b.k.fOy();
          }
          i = localPoint.y;
          AppMethodBeat.o(94037);
          return i;
        }
        int i = this.gXb.qCI;
        AppMethodBeat.o(94037);
        return i;
      }
      catch (Exception localException)
      {
        ac.e(this.TAG, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94037);
    return 0;
  }
  
  private final int getPreviewWidth()
  {
    AppMethodBeat.i(94038);
    if (this.fFt == null)
    {
      AppMethodBeat.o(94038);
      return 0;
    }
    if (this.gXJ != null) {
      try
      {
        if ((this.gWY) && (this.gXK != null))
        {
          Point localPoint = this.gXK;
          if (localPoint == null) {
            d.g.b.k.fOy();
          }
          i = localPoint.x;
          AppMethodBeat.o(94038);
          return i;
        }
        int i = this.gXb.qCH;
        AppMethodBeat.o(94038);
        return i;
      }
      catch (Exception localException)
      {
        ac.e(this.TAG, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94038);
    return 0;
  }
  
  private final boolean i(int paramInt, float paramFloat)
  {
    Object localObject4 = null;
    AppMethodBeat.i(94026);
    if ((this.fFt == null) || (paramInt <= 0))
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
      localObject1 = this.fFt;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      localParameters = ((v)localObject1).getParameters();
      if (this.gXe != null) {
        break label538;
      }
      localObject1 = aj.cl(ai.getContext());
      localPoint = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
      ac.i(this.TAG, "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject1 });
      float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
      f2 = 1.0F / paramFloat;
      if (paramFloat >= 1.0F) {
        break label592;
      }
      i = paramInt;
      ac.i(this.TAG, "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
      localObject1 = this.gXJ;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      if (((d.a.a)localObject1).duc == 90) {
        break label623;
      }
      localObject1 = this.gXJ;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      if (((d.a.a)localObject1).duc != 270) {
        break label605;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      Camera.Parameters localParameters;
      Point localPoint;
      ac.e(this.TAG, "safeSetPreviewSizeWithLimit error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94026);
      return false;
    }
    localObject1 = h.a(localParameters, localPoint, i, bool);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((h.c)localObject1).uKY;
      label280:
      if (localObject3 == null)
      {
        ac.e(this.TAG, "fuck, preview size still null!!");
        if (localParameters == null) {
          d.g.b.k.fOy();
        }
        localObject1 = this.gXJ;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        if (((d.a.a)localObject1).duc == 90) {
          break label629;
        }
        localObject1 = this.gXJ;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        if (((d.a.a)localObject1).duc != 270) {
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
        localObject3 = ((h.c)localObject1).uKY;
      }
      if (localObject3 != null)
      {
        localObject1 = ((h.c)localObject1).uKY;
        this.gXb.qCH = ((Point)localObject1).x;
        this.gXb.qCI = ((Point)localObject1).y;
        this.gXK = null;
        ac.i(this.gWT, "final set camera preview size: : %s, cropSize: %s", new Object[] { localObject1, this.gXK });
        if (localParameters == null) {
          d.g.b.k.fOy();
        }
        localParameters.setPreviewSize(this.gXb.qCH, this.gXb.qCI);
        localObject1 = this.fFt;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        ((v)localObject1).setParameters(localParameters);
        AppMethodBeat.o(94026);
        return true;
      }
      label538:
      Object localObject2 = this.gXe;
      if (localObject2 == null) {
        d.g.b.k.fOy();
      }
      i = ((Size)localObject2).getWidth();
      localObject2 = this.gXe;
      if (localObject2 == null) {
        d.g.b.k.fOy();
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
  
  private final boolean ny(int paramInt)
  {
    AppMethodBeat.i(94048);
    if ((this.fFt == null) || (this.gXJ == null))
    {
      ac.d(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(94048);
      return false;
    }
    Object localObject1 = this.gXJ;
    if ((localObject1 == null) || (((d.a.a)localObject1).duc != 90))
    {
      localObject1 = this.gXJ;
      if ((localObject1 == null) || (((d.a.a)localObject1).duc != 270)) {
        break label157;
      }
    }
    Camera.Parameters localParameters;
    label157:
    for (boolean bool = true;; bool = false) {
      try
      {
        localObject1 = this.fFt;
        if (localObject1 != null)
        {
          localParameters = ((v)localObject1).getParameters();
          if (localParameters != null) {
            break;
          }
        }
        AppMethodBeat.o(94048);
        return false;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace(this.TAG, (Throwable)localException, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(94048);
        return false;
      }
    }
    Object localObject3;
    if (this.gXe == null)
    {
      localObject2 = com.tencent.mm.plugin.mmsight.d.fH(this.context);
      localObject3 = h.c(localParameters, (Point)localObject2, paramInt, bool);
      if (((h.c)localObject3).uKY != null) {
        break label513;
      }
      ac.e(this.TAG, "fuck, preview size still null!!");
    }
    label513:
    for (Object localObject2 = h.d(localParameters, new Point(Math.min(((Point)localObject2).x, ((Point)localObject2).y), Math.max(((Point)localObject2).x, ((Point)localObject2).y)), this.gXV, bool);; localObject2 = localObject3)
    {
      if (((h.c)localObject2).uKY == null)
      {
        ac.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject2).toString() });
        ((h.c)localObject2).uKY = ((h.c)localObject2).uLb;
        ((h.c)localObject2).uKZ = ((h.c)localObject2).uLc;
        ((h.c)localObject2).uLa = ((h.c)localObject2).uLd;
      }
      localObject3 = ((h.c)localObject2).uKY;
      if (localObject3 == null)
      {
        com.tencent.mm.plugin.mmsight.model.l.atO();
        AppMethodBeat.o(94048);
        return false;
        localObject2 = this.gXe;
        if (localObject2 == null) {
          d.g.b.k.fOy();
        }
        int i = ((Size)localObject2).getWidth();
        localObject2 = this.gXe;
        if (localObject2 == null) {
          d.g.b.k.fOy();
        }
        localObject2 = new Point(i, ((Size)localObject2).getHeight());
        break;
      }
      this.gXb.qCH = ((Point)localObject3).x;
      this.gXb.qCI = ((Point)localObject3).y;
      this.gXK = ((Point)localObject3);
      if (((h.c)localObject2).uKZ != null) {
        this.gXK = ((h.c)localObject2).uKZ;
      }
      ac.i(this.TAG, "final set camera preview size: " + localObject3 + ", cropSize: " + this.gXK);
      localParameters.setPreviewSize(((Point)localObject3).x, ((Point)localObject3).y);
      localObject2 = this.fFt;
      if (localObject2 != null) {
        ((v)localObject2).setParameters(localParameters);
      }
      AppMethodBeat.o(94048);
      return true;
    }
  }
  
  private final boolean nz(int paramInt)
  {
    AppMethodBeat.i(94049);
    if ((this.fFt == null) || (this.gXJ == null))
    {
      ac.d(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(94049);
      return false;
    }
    Object localObject1 = this.gXJ;
    boolean bool;
    if (localObject1 != null) {
      if ((((d.a.a)localObject1).duc == 90) || (((d.a.a)localObject1).duc == 270)) {
        bool = true;
      }
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = this.fFt;
        if (localObject1 == null) {
          break label306;
        }
        localObject1 = ((v)localObject1).getParameters();
        if (this.gXe != null) {
          break label312;
        }
        localObject2 = com.tencent.mm.plugin.mmsight.d.fH(this.context);
        localObject3 = h.e((Camera.Parameters)localObject1, (Point)localObject2, paramInt, bool);
        if (((h.c)localObject3).uKY != null) {
          break label493;
        }
        ac.e(this.TAG, "fuck, preview size still null!!");
        localObject2 = h.d((Camera.Parameters)localObject1, new Point(Math.min(((Point)localObject2).x, ((Point)localObject2).y), Math.max(((Point)localObject2).x, ((Point)localObject2).y)), this.gXV, bool);
        if (((h.c)localObject2).uKY == null)
        {
          ac.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject2).toString() });
          ((h.c)localObject2).uKY = ((h.c)localObject2).uLb;
          ((h.c)localObject2).uKZ = ((h.c)localObject2).uLc;
          ((h.c)localObject2).uLa = ((h.c)localObject2).uLd;
        }
        localObject3 = ((h.c)localObject2).uKY;
        if (localObject3 != null) {
          break label364;
        }
        com.tencent.mm.plugin.mmsight.model.l.atO();
        AppMethodBeat.o(94049);
        return false;
      }
      catch (Exception localException)
      {
        ac.i(this.TAG, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(94049);
        return false;
      }
      bool = false;
      continue;
      label306:
      Camera.Parameters localParameters = null;
      continue;
      label312:
      Object localObject2 = this.gXe;
      if (localObject2 == null) {
        d.g.b.k.fOy();
      }
      int i = ((Size)localObject2).getWidth();
      localObject2 = this.gXe;
      if (localObject2 == null) {
        d.g.b.k.fOy();
      }
      localObject2 = new Point(i, ((Size)localObject2).getHeight());
      continue;
      label364:
      this.gXb.qCH = ((Point)localObject3).x;
      this.gXb.qCI = ((Point)localObject3).y;
      if (((h.c)localObject2).uLa != null) {
        this.gXK = ((h.c)localObject2).uLa;
      }
      ac.i(this.TAG, "final set camera preview size: " + localObject3 + ", cropSize: " + this.gXK);
      if (localParameters != null) {
        localParameters.setPreviewSize(this.gXb.qCH, this.gXb.qCI);
      }
      localObject2 = this.fFt;
      if (localObject2 != null) {
        ((v)localObject2).setParameters(localParameters);
      }
      AppMethodBeat.o(94049);
      return true;
      label493:
      localObject2 = localObject3;
    }
  }
  
  public final void A(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(94052);
    d.g.b.k.h(paramString, "tag");
    AppMethodBeat.o(94052);
  }
  
  public final void W(String paramString, int paramInt)
  {
    AppMethodBeat.i(94053);
    d.g.b.k.h(paramString, "tag");
    AppMethodBeat.o(94053);
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
    ac.m(this.TAG, "addFrameDataCallback ".concat(String.valueOf(paramg)), new Object[0]);
    if (paramg == null)
    {
      AppMethodBeat.o(94020);
      return;
    }
    synchronized (this.lock)
    {
      this.gXH.add(paramg);
      AppMethodBeat.o(94020);
      return;
    }
  }
  
  public final int atC()
  {
    if (this.gWW) {
      return 0;
    }
    return 1;
  }
  
  public final int atD()
  {
    AppMethodBeat.i(94050);
    int i = getOrientation();
    AppMethodBeat.o(94050);
    return i;
  }
  
  public final void atE()
  {
    this.gXZ = 15;
  }
  
  public final void atx()
  {
    AppMethodBeat.i(94030);
    if (!atn())
    {
      AppMethodBeat.o(94030);
      return;
    }
    c localc = this.gXI;
    c.a locala = c.gXC;
    localc.removeMessages(c.atv());
    AppMethodBeat.o(94030);
  }
  
  public final b aty()
  {
    boolean bool = true;
    AppMethodBeat.i(94036);
    ac.m(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.fFt == null)
    {
      ac.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94036);
      return null;
    }
    if (!atn())
    {
      ac.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94036);
      return null;
    }
    b.ns(getPreviewWidth());
    b.nr(getPreviewHeight());
    Object localObject = this.gXJ;
    int i;
    if (localObject != null) {
      if ((((d.a.a)localObject).duc == 90) || (((d.a.a)localObject).duc == 270))
      {
        i = 1;
        b.nu(this.gXb.qCH);
        b.nv(this.gXb.qCI);
        if (i != 0)
        {
          i = b.atr();
          b.nu(b.ats());
          b.nv(i);
        }
        b.nt(getOrientation());
        if (this.gWW) {
          break label202;
        }
      }
    }
    for (;;)
    {
      b.setFrontCamera(bool);
      b.ef(this.gWY);
      localObject = this.gXc;
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
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94029);
    if (!atn())
    {
      AppMethodBeat.o(94029);
      return;
    }
    if (com.tencent.mm.compatible.util.d.la(14))
    {
      AppMethodBeat.o(94029);
      return;
    }
    c localc = this.gXI;
    Object localObject = c.gXC;
    localc.removeMessages(c.atv());
    this.gXI.fTg = paramFloat1;
    this.gXI.fTh = paramFloat2;
    this.gXI.gXs = paramInt1;
    this.gXI.gXt = paramInt2;
    localc = this.gXI;
    localObject = this.gXI;
    c.a locala = c.gXC;
    localc.sendMessageDelayed(((c)localObject).obtainMessage(c.atv(), this.fFt), 400L);
    AppMethodBeat.o(94029);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(94021);
    ac.m(this.TAG, "removeFrameDataCallback ".concat(String.valueOf(paramg)), new Object[0]);
    if (paramg == null)
    {
      AppMethodBeat.o(94021);
      return;
    }
    synchronized (this.lock)
    {
      this.gXH.remove(paramg);
      AppMethodBeat.o(94021);
      return;
    }
  }
  
  public final Point eg(boolean paramBoolean)
  {
    AppMethodBeat.i(94039);
    Object localObject;
    if (!paramBoolean)
    {
      localObject = new Point(this.gXb.qCH, this.gXb.qCI);
      AppMethodBeat.o(94039);
      return localObject;
    }
    if (this.gXK != null)
    {
      Point localPoint = this.gXK;
      localObject = localPoint;
      if (localPoint == null)
      {
        d.g.b.k.fOy();
        AppMethodBeat.o(94039);
        return localPoint;
      }
    }
    else
    {
      localObject = new Point(this.gXb.qCH, this.gXb.qCI);
    }
    AppMethodBeat.o(94039);
    return localObject;
  }
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(94055);
    for (;;)
    {
      try
      {
        Object localObject1 = this.fFt;
        if (localObject1 == null) {
          break label103;
        }
        localObject1 = ((v)localObject1).getParameters();
        if (paramBoolean)
        {
          if (localObject1 != null) {
            ((Camera.Parameters)localObject1).setFlashMode("torch");
          }
          v localv = this.fFt;
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
        ac.printErrStackTrace(this.TAG, (Throwable)localException, "set flash mode error", new Object[0]);
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
    Object localObject = this.fFt;
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
  
  public final float[] getSupportZoomRatios()
  {
    Object localObject1 = null;
    AppMethodBeat.i(94033);
    if ((this.gXW != null) || (this.fFt != null)) {}
    float[] arrayOfFloat;
    label218:
    label474:
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = this.fFt;
        if (localObject2 == null) {
          d.g.b.k.fOy();
        }
        localObject2 = ((v)localObject2).getParameters();
        if (localObject2 == null) {
          d.g.b.k.fOy();
        }
        boolean bool = ((Camera.Parameters)localObject2).isZoomSupported();
        if (!bool)
        {
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            break label218;
          }
          this.gXW = new com.tencent.tinker.a.c.b();
          localObject1 = this.gXW;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          localObject1 = new float[((com.tencent.tinker.a.c.b)localObject1).size()];
          localObject2 = this.gXW;
          if (localObject2 == null) {
            d.g.b.k.fOy();
          }
          j = ((com.tencent.tinker.a.c.b)localObject2).size();
          i = 0;
          if (i >= j) {
            break;
          }
          localObject2 = this.gXW;
          if (localObject2 == null) {
            d.g.b.k.fOy();
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
        ac.e(this.TAG, "getZoom error: %s", new Object[] { localException.getMessage() });
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
      this.gXW = new com.tencent.tinker.a.c.b(j);
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
            localObject2 = this.gXW;
            if (localObject2 == null) {
              d.g.b.k.fOy();
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
            localObject2 = this.gXW;
            if (localObject2 == null) {
              d.g.b.k.fOy();
            }
            ((com.tencent.tinker.a.c.b)localObject2).append(k, m + k * i);
          }
          else
          {
            m += 1;
            break label330;
            localObject2 = this.gXW;
            if (localObject2 == null) {
              d.g.b.k.fOy();
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
  
  public final void j(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94032);
    if ((this.fFt != null) && (atn())) {
      try
      {
        ac.d(this.TAG, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (this.aNN)
        {
          ac.d(this.TAG, "triggerSmallZoom, zooming, ignore");
          return;
        }
        Object localObject1 = this.fFt;
        if (localObject1 != null) {
          localObject1 = ((v)localObject1).getParameters();
        }
        int i;
        int j;
        while ((localObject1 != null) && (((Camera.Parameters)localObject1).isZoomSupported() == true))
        {
          this.aNN = true;
          i = ((Camera.Parameters)localObject1).getZoom();
          j = this.gXX.indexOf(Integer.valueOf(i));
          int k = ((Camera.Parameters)localObject1).getMaxZoom();
          ac.d(this.TAG, "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(this.gXM), Integer.valueOf(this.gXL), Integer.valueOf(paramInt) });
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
            if (j != this.gXX.size() - 1) {
              break label316;
            }
            paramInt = ((Number)d.a.j.iQ((List)this.gXX)).intValue();
          }
        }
        for (;;)
        {
          ac.d(this.TAG, "triggerSmallZoom, nextZoom: %s, smoothZoomSupported: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(((Camera.Parameters)localObject1).isSmoothZoomSupported()) });
          ((Camera.Parameters)localObject1).setZoom(paramInt);
          Object localObject3 = this.fFt;
          if (localObject3 != null) {
            ((v)localObject3).setParameters((Camera.Parameters)localObject1);
          }
          return;
          label316:
          localObject3 = this.gXX.get(j + 1);
          d.g.b.k.g(localObject3, "availableZoomRatioIndexList[currentZoomIndex + 1]");
          paramInt = ((Number)localObject3).intValue();
          continue;
          label349:
          if (i == 0) {
            return;
          }
          if (j == 0)
          {
            paramInt = ((Number)d.a.j.iO((List)this.gXX)).intValue();
          }
          else
          {
            localObject3 = this.gXX.get(j - 1);
            d.g.b.k.g(localObject3, "availableZoomRatioIndexList[currentZoomIndex - 1]");
            paramInt = ((Number)localObject3).intValue();
          }
        }
        AppMethodBeat.o(94032);
      }
      catch (Exception localException)
      {
        ac.e(this.TAG, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aNN = false;
        AppMethodBeat.o(94032);
      }
    }
  }
  
  public final void n(d.g.a.b<? super Boolean, y> paramb)
  {
    this.gXY = paramb;
  }
  
  public final void nx(int paramInt)
  {
    AppMethodBeat.i(94031);
    if (this.gXL > 0)
    {
      AppMethodBeat.o(94031);
      return;
    }
    Object localObject = aj.cl(ai.getContext());
    int i = ((Point)localObject).y;
    ac.i(this.TAG, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94031);
      return;
    }
    try
    {
      if (this.fFt != null)
      {
        localObject = this.fFt;
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
            this.gXL = ((int)d + 1);
          }
          ac.i(this.TAG, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.gXL), Integer.valueOf(i) });
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
      ac.e(this.TAG, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94031);
    }
  }
  
  public final boolean q(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94019);
    d.g.b.k.h(paramContext, "context");
    for (;;)
    {
      try
      {
        if (this.gXU)
        {
          ac.i(this.TAG, "initCamera, already open");
          AppMethodBeat.o(94019);
          return true;
        }
        Object localObject = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arv();
        super.q(paramContext, paramBoolean);
        release();
        if (paramBoolean)
        {
          i = com.tencent.mm.compatible.deviceinfo.d.Xx();
          ac.m(this.TAG, "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(i), Integer.valueOf(ae.fJd.fFe) });
          this.gXJ = new f().a(paramContext, i, Looper.getMainLooper());
          ac.i(this.TAG, "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.gXJ == null)
          {
            ac.i(this.TAG, "open camera FAILED, %s", new Object[] { Looper.myLooper() });
            atl();
            AppMethodBeat.o(94019);
            return false;
          }
        }
        else
        {
          i = com.tencent.mm.compatible.deviceinfo.d.Xy();
          continue;
        }
        paramContext = this.gXJ;
        if (paramContext != null)
        {
          paramContext = paramContext.fFt;
          this.fFt = paramContext;
          this.gXI.gXr = false;
          paramContext = this.gXb;
          localObject = this.gXJ;
          if (localObject == null) {
            break label317;
          }
          i = ((d.a.a)localObject).duc;
          paramContext.duc = i;
          if (this.fFt == null)
          {
            ac.e(this.TAG, "start camera FAILED!");
            atl();
            AppMethodBeat.o(94019);
            return false;
          }
          this.gXU = true;
          AppMethodBeat.o(94019);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        ac.printErrStackTrace(this.TAG, (Throwable)paramContext, "init camera failed!", new Object[0]);
        paramContext = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arx();
        AppMethodBeat.o(94019);
        return false;
      }
      paramContext = null;
      continue;
      label317:
      int i = 0;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(94054);
    super.release();
    try
    {
      ac.i(this.TAG, this.gXN.getValue());
      ac.i(this.TAG, this.gXO.getValue());
      ac.i(this.TAG, this.gXP.getValue());
      ac.i(this.TAG, this.gXQ.getValue());
      ac.i(this.TAG, this.gXR.getValue());
      if (this.fFt != null)
      {
        long l = bs.Gn();
        ac.i(this.TAG, "release camera beg, %s", new Object[] { Looper.myLooper() });
        this.gXI.removeCallbacksAndMessages(null);
        this.gXI.gXr = true;
        v localv = this.fFt;
        if (localv != null) {
          localv.setPreviewCallback(null);
        }
        localv = this.fFt;
        if (localv != null) {
          localv.stopPreview();
        }
        localv = this.fFt;
        if (localv != null) {
          localv.release();
        }
        this.fFt = null;
        ac.i(this.TAG, "release camera end, use %dms, %s", new Object[] { Long.valueOf(bs.aO(l)), Looper.myLooper() });
      }
      this.gXI.gXp = false;
      this.gXI.gXu = true;
      this.gXK = null;
      this.gXT = null;
      this.gXU = false;
      AppMethodBeat.o(94054);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "cameraRelease error", new Object[0]);
      AppMethodBeat.o(94054);
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
      eh(false);
      AppMethodBeat.o(94057);
      return;
      eh(true);
    }
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(94034);
    if (this.aNN)
    {
      ac.d(this.TAG, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94034);
      return;
    }
    if (this.fFt != null) {
      try
      {
        Object localObject1 = this.fFt;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = ((v)localObject1).getParameters();
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        boolean bool = ((Camera.Parameters)localObject1).isZoomSupported();
        if (!bool) {
          return;
        }
        if (this.gXW == null)
        {
          ac.d(this.TAG, "setForceZoomTargetRatio before init zoom info, ignore");
          return;
        }
        Object localObject3 = ((Camera.Parameters)localObject1).getZoomRatios();
        com.tencent.tinker.a.c.b localb = this.gXW;
        if (localb == null) {
          d.g.b.k.fOy();
        }
        int i = ((List)localObject3).indexOf(Integer.valueOf(localb.get(d.h.a.cj(10.0F * paramFloat))));
        if (i >= 0)
        {
          int j = ((Camera.Parameters)localObject1).getMaxZoom();
          if (i <= j) {}
        }
        else
        {
          return;
        }
        this.aNN = true;
        ((Camera.Parameters)localObject1).setZoom(i);
        localObject3 = this.fFt;
        if (localObject3 == null) {
          d.g.b.k.fOy();
        }
        ((v)localObject3).setParameters((Camera.Parameters)localObject1);
        return;
      }
      catch (Exception localException)
      {
        ac.e(this.TAG, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aNN = false;
        AppMethodBeat.o(94034);
      }
    }
    AppMethodBeat.o(94034);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/CommonCamera1$setPreviewCallbackImpl$1$1"})
  static final class a
    implements Camera.PreviewCallback
  {
    a(d paramd) {}
    
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
        ac.e(d.a(this.gYa), "onPreviewFrame, frame data is null!!");
        AppMethodBeat.o(94017);
        return;
      }
      if (this.gYa.gXH.size() <= 0)
      {
        paramCamera = this.gYa.fFt;
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
      if (!d.b(this.gYa))
      {
        paramCamera = paramArrayOfByte;
        if (this.gYa.gXH.size() > 0)
        {
          paramCamera = paramArrayOfByte;
          if (this.gYa.gXK != null)
          {
            paramCamera = this.gYa.gXK;
            if ((paramCamera != null) && (paramCamera.x == this.gYa.gXb.qCH))
            {
              paramCamera = this.gYa.gXK;
              if ((paramCamera != null) && (paramCamera.y == this.gYa.gXb.qCI)) {
                break label573;
              }
            }
            paramCamera = com.tencent.mm.plugin.mmsight.model.a.j.uMV;
            i = this.gYa.gXb.qCH;
            localObject = this.gYa.gXK;
            if (localObject == null) {
              d.g.b.k.fOy();
            }
            paramCamera = paramCamera.g(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
            d.c(this.gYa).vW(1L);
            l1 = bs.Gn();
            i = this.gYa.gXb.qCH;
            int j = this.gYa.gXb.qCI;
            localObject = this.gYa.gXK;
            if (localObject == null) {
              d.g.b.k.fOy();
            }
            SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
            localObject = this.gYa.gXK;
            if (localObject == null) {
              d.g.b.k.fOy();
            }
            if (((Point)localObject).x >= this.gYa.gXb.qCH) {
              break label640;
            }
            localObject = com.tencent.mm.plugin.mmsight.model.a.j.uMV;
            Point localPoint = this.gYa.gXK;
            if (localPoint == null) {
              d.g.b.k.fOy();
            }
            i = localPoint.x;
            localPoint = this.gYa.gXK;
            if (localPoint == null) {
              d.g.b.k.fOy();
            }
            localObject = ((com.tencent.mm.plugin.mmsight.model.a.j)localObject).g(Integer.valueOf(i * localPoint.y * 3 / 2));
            i = this.gYa.gXb.qCH;
            localPoint = this.gYa.gXK;
            if (localPoint == null) {
              d.g.b.k.fOy();
            }
            j = localPoint.x;
            localPoint = this.gYa.gXK;
            if (localPoint == null) {
              d.g.b.k.fOy();
            }
            SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
            com.tencent.mm.plugin.mmsight.model.a.j.uMV.k(paramCamera);
            paramCamera = (Camera)localObject;
          }
        }
      }
      label640:
      for (;;)
      {
        long l2 = bs.aO(l1);
        d.d(this.gYa).vW(l2);
        localObject = this.gYa;
        d.g.b.k.g(paramCamera, "curFrameData");
        boolean bool = d.a((d)localObject, paramCamera);
        l1 = bs.aO(l1);
        paramCamera = paramArrayOfByte;
        if (bool)
        {
          d.e(this.gYa).vW(l1);
          paramCamera = paramArrayOfByte;
        }
        for (;;)
        {
          paramArrayOfByte = this.gYa.fFt;
          if (paramArrayOfByte == null) {
            break;
          }
          paramArrayOfByte.addCallbackBuffer(paramCamera);
          AppMethodBeat.o(94017);
          return;
          label573:
          l1 = bs.Gn();
          bool = d.a(this.gYa, paramArrayOfByte);
          l1 = bs.aO(l1);
          if (bool) {
            d.e(this.gYa).vW(l1);
          }
          paramCamera = paramArrayOfByte;
          if (bool) {
            paramCamera = com.tencent.mm.plugin.mmsight.model.a.j.uMV.g(Integer.valueOf(paramArrayOfByte.length));
          }
        }
        AppMethodBeat.o(94017);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "ca", "Landroid/hardware/Camera;", "onPreviewFrame"})
  static final class b
    implements Camera.PreviewCallback
  {
    b(d paramd) {}
    
    public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      boolean bool = false;
      AppMethodBeat.i(94018);
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.length != 0) {
          break label41;
        }
      }
      label41:
      for (int i = 1; i != 0; i = 0)
      {
        ac.e(d.a(this.gYa), "onPreviewFrame, frame data is null!!");
        AppMethodBeat.o(94018);
        return;
      }
      Object localObject;
      long l1;
      int j;
      if ((!d.b(this.gYa)) && (this.gYa.gXH != null) && (this.gYa.gXH.size() > 0)) {
        if (this.gYa.gXK != null)
        {
          paramCamera = com.tencent.mm.plugin.mmsight.model.a.j.uMV;
          i = this.gYa.gXb.qCH;
          localObject = this.gYa.gXK;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          paramCamera = paramCamera.g(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
          d.c(this.gYa).vW(1L);
          l1 = bs.Gn();
          i = this.gYa.gXb.qCH;
          j = this.gYa.gXb.qCI;
          localObject = this.gYa.gXK;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
          localObject = this.gYa.gXK;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          if (((Point)localObject).x >= this.gYa.gXb.qCH) {
            break label728;
          }
          localObject = com.tencent.mm.plugin.mmsight.model.a.j.uMV;
          Point localPoint = this.gYa.gXK;
          if (localPoint == null) {
            d.g.b.k.fOy();
          }
          i = localPoint.x;
          localPoint = this.gYa.gXK;
          if (localPoint == null) {
            d.g.b.k.fOy();
          }
          localObject = ((com.tencent.mm.plugin.mmsight.model.a.j)localObject).g(Integer.valueOf(i * localPoint.y * 3 / 2));
          i = this.gYa.gXb.qCH;
          localPoint = this.gYa.gXK;
          if (localPoint == null) {
            d.g.b.k.fOy();
          }
          j = localPoint.x;
          localPoint = this.gYa.gXK;
          if (localPoint == null) {
            d.g.b.k.fOy();
          }
          SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
          com.tencent.mm.plugin.mmsight.model.a.j.uMV.k(paramCamera);
          paramCamera = (Camera)localObject;
        }
      }
      label728:
      for (;;)
      {
        long l2 = bs.aO(l1);
        d.d(this.gYa).vW(l2);
        if (!this.gYa.gWW)
        {
          l1 = bs.Gn();
          localObject = this.gYa.gXK;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          i = ((Point)localObject).x;
          localObject = this.gYa.gXK;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          j = ((Point)localObject).y;
          localObject = this.gYa.gXJ;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          if (((d.a.a)localObject).duc != 270)
          {
            localObject = this.gYa.gXJ;
            if (localObject == null) {
              d.g.b.k.fOy();
            }
            if (((d.a.a)localObject).duc != 90) {}
          }
          else
          {
            bool = true;
            SightVideoJNI.mirrorCameraData(paramCamera, i, j, bool);
          }
        }
        else
        {
          localObject = this.gYa;
          d.g.b.k.g(paramCamera, "curFrameData");
          bool = d.a((d)localObject, paramCamera);
          l1 = bs.aO(l1);
          if (bool) {
            d.e(this.gYa).vW(l1);
          }
        }
        for (;;)
        {
          d.b(this.gYa, paramCamera);
          paramCamera = this.gYa.fFt;
          if (paramCamera == null) {
            d.g.b.k.fOy();
          }
          paramCamera.addCallbackBuffer(paramArrayOfByte);
          AppMethodBeat.o(94018);
          return;
          bool = false;
          break;
          if (!this.gYa.gWW)
          {
            i = this.gYa.gXb.qCH;
            j = this.gYa.gXb.qCI;
            paramCamera = this.gYa.gXJ;
            if (paramCamera == null) {
              d.g.b.k.fOy();
            }
            if (paramCamera.duc != 270)
            {
              paramCamera = this.gYa.gXJ;
              if (paramCamera == null) {
                d.g.b.k.fOy();
              }
              if (paramCamera.duc != 90) {}
            }
            else
            {
              bool = true;
            }
            SightVideoJNI.mirrorCameraData(paramArrayOfByte, i, j, bool);
          }
          d.a(this.gYa, paramArrayOfByte);
          paramCamera = paramArrayOfByte;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.d
 * JD-Core Version:    0.7.0.1
 */