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
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import d.a.j;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "useBack", "", "(Landroid/content/Context;Z)V", "DEFAULT_UPPER_BOUND", "", "SMALL_ZOOM_STEP_NUM", "getSMALL_ZOOM_STEP_NUM", "()I", "SMALL_ZOOM_STEP_UPPER_BOUND", "getSMALL_ZOOM_STEP_UPPER_BOUND", "SMALL_ZOOM_STEP_VAL", "TAG", "", "availableZoomRatioIndexList", "Ljava/util/ArrayList;", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "cameraCallback", "Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "cameraCropCallback", "cameraPreviewCallback", "cropSize", "Landroid/graphics/Point;", "getCropSize", "()Landroid/graphics/Point;", "setCropSize", "(Landroid/graphics/Point;)V", "currentFrameData", "", "finishCallbackTimeCallback", "frameDataCallbackList", "", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getFrameDataCallbackList", "()Ljava/util/List;", "setFrameDataCallbackList", "(Ljava/util/List;)V", "isCameraOpen", "isZooming", "()Z", "setZooming", "(Z)V", "lock", "Ljava/lang/Object;", "mCameraFps", "getMCameraFps", "setMCameraFps", "(I)V", "mZoomTimesToRatio", "Lcom/tencent/tinker/android/utils/SparseIntArray;", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "openCameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "getOpenCameraRes", "()Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "setOpenCameraRes", "(Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;)V", "prevcameraCallback", "scrollSmallZoomStep", "getScrollSmallZoomStep", "setScrollSmallZoomStep", "sightHandler", "Lcom/tencent/mm/media/widget/camera/CameraHandler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera/CameraHandler;", "smallZoomStep", "getSmallZoomStep", "setSmallZoomStep", "takePictureLock", "addFrameDataCallback", "callback", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "configVendorTagValue", "tag", "value", "dispatchCameraFrame", "frame", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getAvailableZoomRatioIndexList", "parameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getCameraOrientation", "getCurrentCameraId", "getFlashMode", "getOrientation", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "getPreviewWidth", "getSupportZoomRatios", "", "initCamera", "initRawRatios", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "safeResetZoom", "safeSetFocusMode", "safeSetMetering", "safeSetPreviewFormat", "safeSetPreviewFrameRate", "useFixMode", "safeSetPreviewSize", "resolutionLimit", "safeSetPreviewSizeWithLimitAndRatio", "sizeLimit", "displayRatio", "safeSetStabilization", "selectNoCropPreviewSize", "setCameraPreviewFps", "fpsValue", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewCallbackImpl", "setPreviewCallbackImplInGPUCrop", "setPreviewDisplayRatio", "setSafeConfig", "startPreview", "useCpuCrop", "startPreviewWithCPU", "startPreviewWithGPU", "switchVendorTag", "isChecked", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "p", "trySetPreviewFrameRateParameters", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  private final String TAG;
  private boolean aYh;
  v fYS;
  private final int hpK;
  private final int hpL;
  private final int hpM;
  List<g> hpN;
  private final c hpO;
  d.a.a hpP;
  Point hpQ;
  private int hpR;
  private int hpS;
  private final com.tencent.mm.plugin.mmsight.model.c hpT;
  private final com.tencent.mm.plugin.mmsight.model.c hpU;
  private final com.tencent.mm.plugin.mmsight.model.c hpV;
  private final com.tencent.mm.plugin.mmsight.model.c hpW;
  private final com.tencent.mm.plugin.mmsight.model.c hpX;
  private volatile boolean hpY;
  private volatile byte[] hpZ;
  private boolean hqa;
  private final int hqb;
  private com.tencent.tinker.a.c.b hqc;
  private final ArrayList<Integer> hqd;
  private d.g.a.b<? super Boolean, z> hqe;
  private int hqf;
  private final Object lock;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94058);
    this.TAG = "MicroMsg.CommonCamera1";
    this.hpK = 40;
    this.hpL = 5;
    this.hpM = 10;
    this.hpN = ((List)new ArrayList());
    paramContext = Looper.getMainLooper();
    p.g(paramContext, "Looper.getMainLooper()");
    this.hpO = new c(paramContext);
    this.hpR = -1;
    this.hpS = -1;
    this.hpT = new com.tencent.mm.plugin.mmsight.model.c("prevcameraCallback");
    this.hpU = new com.tencent.mm.plugin.mmsight.model.c("cameraCallback");
    this.hpV = new com.tencent.mm.plugin.mmsight.model.c("cameraPreviewCallback");
    this.hpW = new com.tencent.mm.plugin.mmsight.model.c("cameraCropCallback");
    this.hpX = new com.tencent.mm.plugin.mmsight.model.c("finishCallbackTimeCallback");
    this.hqb = 2100;
    this.hqd = new ArrayList();
    this.lock = new Object();
    AppMethodBeat.o(94058);
  }
  
  private final boolean T(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94051);
    bt.HI();
    synchronized (this.lock)
    {
      if (this.hpN != null)
      {
        int i = this.hpN.size();
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(94051);
        return false;
      }
      Iterator localIterator = this.hpN.iterator();
      boolean bool1 = false;
      while (localIterator.hasNext())
      {
        boolean bool2 = ((g)localIterator.next()).U(paramArrayOfByte);
        bool1 |= bool2;
      }
      AppMethodBeat.o(94051);
      return bool1;
    }
  }
  
  private final void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(94024);
    long l = bt.HI();
    ad.i(this.TAG, "start startPreviewWithCPU,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (awa())
    {
      ad.i(this.TAG, "startPreviewWithCPU, camera previewing");
      AppMethodBeat.o(94024);
      return;
    }
    try
    {
      nX(paramInt);
      awj();
      awn();
      if (a(paramSurfaceTexture, paramSurfaceHolder)) {
        a(a.a.hpm);
      }
      ad.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(bt.aO(l)), Looper.myLooper() });
      AppMethodBeat.o(94024);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        ad.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.auk();
      }
    }
  }
  
  private final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94027);
    v localv = this.fYS;
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
          ad.i(this.TAG, "doStartPreview finish");
          paramSurfaceTexture = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.auj();
          AppMethodBeat.o(94027);
          return true;
          localv.setPreviewDisplay(paramSurfaceHolder);
        }
      }
      ad.i(this.TAG, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auk();
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
        p.g(localParameters, "p");
        localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          ad.i(this.TAG, "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          this.hpO.hpB = localParameters.getFocusMode();
          paramv.setParameters(localParameters);
          AppMethodBeat.o(94042);
          return true;
        }
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          ad.i(this.TAG, "support continuous video");
          localParameters.setFocusMode("continuous-video");
          continue;
        }
        if (localList == null) {
          break label200;
        }
      }
      catch (Exception paramv)
      {
        ad.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(94042);
        return false;
      }
      if (localList.contains("auto"))
      {
        ad.i(this.TAG, "support auto focus");
        localParameters.setFocusMode("auto");
      }
      else
      {
        label200:
        ad.i(this.TAG, "not support continuous video or auto focus");
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
        if (ae.gcE.fYs > 0)
        {
          ad.i(this.hoZ, "set frame rate > 0, do not try set preview frame rate");
          p.g(localParameters, "p");
          localObject1 = localParameters.getSupportedPreviewFrameRates();
          ad.i(this.hoZ, "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localObject1 });
          paramv.setParameters(localParameters);
          AppMethodBeat.o(94041);
          return true;
        }
        if (localParameters == null)
        {
          ad.e(this.TAG, "trySetPreviewFrameRateParameters error, p is null!");
          continue;
        }
        try
        {
          localObject1 = localParameters.getSupportedPreviewFrameRates();
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            continue;
          }
          if (this.hqf != 0)
          {
            i = this.hqf;
            localObject1 = Collections.max((Collection)localObject1);
            p.g(localObject1, "Collections.max(fr)");
            i = Math.min(i, ((Number)localObject1).intValue());
            localParameters.setPreviewFrameRate(i);
            ad.i(this.hoZ, "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
        }
        catch (Exception localException1)
        {
          ad.i(this.hoZ, "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException1.getMessage() });
        }
      }
      catch (Exception paramv)
      {
        ad.i(this.hoZ, "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(94041);
        return false;
      }
      Object localObject2;
      for (;;)
      {
        break;
        localObject2 = Collections.max((Collection)localException1);
        p.g(localObject2, "Collections.max(fr)");
        i = Math.min(30, ((Number)localObject2).intValue());
      }
      p.g(localParameters, "p");
      if (ae.gcE.fYs > 0)
      {
        ad.i(this.hoZ, "set frame rate > 0, do not try set preview fps range");
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
            ad.i(this.TAG, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(i2) });
            if (i3 < 0) {
              break label678;
            }
            if (i2 >= i3) {
              break label681;
            }
            break label678;
            if (this.hqf == 0) {
              break label719;
            }
            if (i2 < this.hqf * 1000) {
              break;
            }
            i = 1;
            k = m;
            j = n;
            break label669;
          }
          ad.i(this.hoZ, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(30) });
          if ((j != 2147483647) && (k != 2147483647)) {
            try
            {
              localParameters.setPreviewFpsRange(j, k);
              ad.i(this.hoZ, "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            }
            catch (Exception localException2)
            {
              ad.i(this.hoZ, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException2.getMessage() });
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
  
  private final void awj()
  {
    AppMethodBeat.i(94028);
    Integer localInteger = Integer.valueOf(0);
    Object localObject = com.tencent.mm.plugin.mmsight.model.a.l.dno();
    p.g(localObject, "MMSightController.getInstance()");
    if (((com.tencent.mm.plugin.mmsight.model.a.l)localObject).dnp() != null)
    {
      localObject = com.tencent.mm.plugin.mmsight.model.a.l.dno();
      p.g(localObject, "MMSightController.getInstance()");
      localInteger = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.a.l)localObject).dnp().vMM);
    }
    String str = this.TAG;
    if (ae.gcE.fYx == 1) {
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
      if (ae.gcE.fYy == 1)
      {
        bool1 = true;
        if (ae.gcE.fYz != 1) {
          break label417;
        }
        bool2 = true;
        if (ae.gcE.fYA != 1) {
          break label422;
        }
        bool3 = true;
        if (ae.gcE.fYB != 1) {
          break label427;
        }
        bool4 = true;
        label129:
        ad.i(str, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
        if ((ae.gcE.fYx != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 1))) {
          break label433;
        }
        a(this.fYS, false);
        label218:
        if ((ae.gcE.fYy == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
          b(this.fYS);
        }
        if ((ae.gcL.gbr != -1) && (ae.gcL.gbr == 1) && (com.tencent.mm.compatible.util.d.lA(14))) {
          c(this.fYS);
        }
        if ((ae.gcE.fYA == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
          a(this.fYS);
        }
        if ((ae.gcE.fYB == 1) && (localInteger.intValue() != 0)) {
          localInteger.intValue();
        }
        awm();
      }
      try
      {
        localObject = this.fYS;
        if (localObject != null) {}
        for (localObject = ((v)localObject).getParameters();; localObject = null)
        {
          b((Camera.Parameters)localObject);
          AppMethodBeat.o(94028);
          return;
          if (ae.gcE.fYw == 1)
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
          if ((ae.gcE.fYw != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
            break label218;
          }
          a(this.fYS, true);
          break label218;
        }
        return;
      }
      catch (Exception localException)
      {
        ad.i(this.TAG, "current get parameters is null");
        AppMethodBeat.o(94028);
      }
    }
  }
  
  private void awm()
  {
    AppMethodBeat.i(94043);
    try
    {
      Object localObject = this.fYS;
      if (localObject != null) {}
      for (localObject = ((v)localObject).getParameters();; localObject = null)
      {
        if ((localObject != null) && (((Camera.Parameters)localObject).isZoomSupported() == true)) {
          ((Camera.Parameters)localObject).setZoom(0);
        }
        v localv = this.fYS;
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
      ad.e(this.TAG, "safeResetZoom error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94043);
    }
  }
  
  private final void awn()
  {
    AppMethodBeat.i(94046);
    if (this.fYS == null)
    {
      AppMethodBeat.o(94046);
      return;
    }
    try
    {
      if (this.fYS == null) {
        break label240;
      }
      Object localObject1 = this.fYS;
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
      ad.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94046);
      return;
    }
    int i = this.hph.rmx;
    int j = this.hph.rmy;
    j = ImageFormat.getBitsPerPixel(localException.getPreviewFormat()) * (i * j) / 8;
    ad.i(this.TAG, "setPreviewCallbackImpl  size: ".concat(String.valueOf(j)));
    i = 0;
    for (;;)
    {
      Object localObject2;
      if (i < 5)
      {
        localObject2 = k.vQc.g(Integer.valueOf(j));
        v localv = this.fYS;
        if (localv != null) {
          localv.addCallbackBuffer((byte[])localObject2);
        }
      }
      else
      {
        this.hpT.reset();
        this.hpU.reset();
        this.hpV.reset();
        this.hpW.reset();
        this.hpX.reset();
        localObject2 = this.fYS;
        if (localObject2 != null)
        {
          ((v)localObject2).setPreviewCallbackWithBuffer((Camera.PreviewCallback)new a(this));
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
  
  private void awo()
  {
    AppMethodBeat.i(94047);
    if (this.fYS != null) {
      try
      {
        Object localObject = this.fYS;
        if (localObject == null) {
          p.gfZ();
        }
        localObject = ((v)localObject).getParameters();
        ad.i(this.TAG, "setPreviewCallbackImpl");
        int i = this.hph.rmx;
        int j = this.hph.rmy;
        if (localObject == null) {
          p.gfZ();
        }
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = k.vQc.g(Integer.valueOf(j));
          v localv = this.fYS;
          if (localv == null) {
            p.gfZ();
          }
          localv.addCallbackBuffer((byte[])localObject);
          i += 1;
        }
        this.hpT.reset();
        this.hpU.reset();
        this.hpV.reset();
        this.hpW.reset();
        this.hpX.reset();
        localObject = this.fYS;
        if (localObject == null) {
          p.gfZ();
        }
        ((v)localObject).setPreviewCallbackWithBuffer((Camera.PreviewCallback)new b(this));
        AppMethodBeat.o(94047);
        return;
      }
      catch (Exception localException)
      {
        ad.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94047);
  }
  
  private final void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(94025);
    long l = bt.HI();
    ad.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (awa())
    {
      ad.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(94025);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.hpg) {
          continue;
        }
        j(paramInt, this.hpf);
        awo();
        awj();
        if (a(paramSurfaceTexture, paramSurfaceHolder)) {
          a(a.a.hpm);
        }
      }
      catch (Exception paramSurfaceTexture)
      {
        ad.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.auk();
        continue;
      }
      ad.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(bt.aO(l)), Looper.myLooper() });
      AppMethodBeat.o(94025);
      return;
      nY(paramInt);
    }
  }
  
  private final void b(Camera.Parameters paramParameters)
  {
    int j = 0;
    AppMethodBeat.i(94035);
    int i;
    if (paramParameters != null)
    {
      Object localObject = paramParameters.getZoomRatios();
      if (localObject != null)
      {
        localObject = (Integer)j.jc((List)localObject);
        if (localObject != null)
        {
          i = ((Integer)localObject).intValue();
          this.hqd.clear();
          this.hqd.add(Integer.valueOf(0));
          int k = this.hpM;
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
            j.gfB();
          }
          if (p.compare(((Integer)localObject).intValue(), i) <= 0) {
            break label181;
          }
          i = this.hpM + i;
          this.hqd.add(Integer.valueOf(j));
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
      ad.i(this.TAG, "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramv.getParameters();
      p.g(localParameters, "p");
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        ad.e(this.TAG, "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramv.setParameters(localParameters);
      AppMethodBeat.o(94044);
      return true;
    }
    catch (Exception paramv)
    {
      ad.i(this.TAG, "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
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
      ad.i(this.TAG, "safeSetMetering");
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
      ad.i(this.TAG, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
      AppMethodBeat.o(94045);
    }
    return false;
  }
  
  private final int getOrientation()
  {
    AppMethodBeat.i(94040);
    if ((this.hpP != null) && (awa()))
    {
      d.a.a locala = this.hpP;
      if (locala != null)
      {
        int i = locala.dGc;
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
    if (this.fYS == null)
    {
      AppMethodBeat.o(94037);
      return 0;
    }
    if (this.hpP != null) {
      try
      {
        if ((this.hpe) && (this.hpQ != null))
        {
          Point localPoint = this.hpQ;
          if (localPoint == null) {
            p.gfZ();
          }
          i = localPoint.y;
          AppMethodBeat.o(94037);
          return i;
        }
        int i = this.hph.rmy;
        AppMethodBeat.o(94037);
        return i;
      }
      catch (Exception localException)
      {
        ad.e(this.TAG, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94037);
    return 0;
  }
  
  private final int getPreviewWidth()
  {
    AppMethodBeat.i(94038);
    if (this.fYS == null)
    {
      AppMethodBeat.o(94038);
      return 0;
    }
    if (this.hpP != null) {
      try
      {
        if ((this.hpe) && (this.hpQ != null))
        {
          Point localPoint = this.hpQ;
          if (localPoint == null) {
            p.gfZ();
          }
          i = localPoint.x;
          AppMethodBeat.o(94038);
          return i;
        }
        int i = this.hph.rmx;
        AppMethodBeat.o(94038);
        return i;
      }
      catch (Exception localException)
      {
        ad.e(this.TAG, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(94038);
    return 0;
  }
  
  private final boolean j(int paramInt, float paramFloat)
  {
    Object localObject4 = null;
    AppMethodBeat.i(94026);
    if ((this.fYS == null) || (paramInt <= 0))
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
      localObject1 = this.fYS;
      if (localObject1 == null) {
        p.gfZ();
      }
      localParameters = ((v)localObject1).getParameters();
      if (this.hpk != null) {
        break label538;
      }
      localObject1 = al.ci(aj.getContext());
      localPoint = new Point(Math.min(((Point)localObject1).x, ((Point)localObject1).y), Math.max(((Point)localObject1).x, ((Point)localObject1).y));
      ad.i(this.TAG, "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject1 });
      float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
      f2 = 1.0F / paramFloat;
      if (paramFloat >= 1.0F) {
        break label592;
      }
      i = paramInt;
      ad.i(this.TAG, "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
      localObject1 = this.hpP;
      if (localObject1 == null) {
        p.gfZ();
      }
      if (((d.a.a)localObject1).dGc == 90) {
        break label623;
      }
      localObject1 = this.hpP;
      if (localObject1 == null) {
        p.gfZ();
      }
      if (((d.a.a)localObject1).dGc != 270) {
        break label605;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      Camera.Parameters localParameters;
      Point localPoint;
      ad.e(this.TAG, "safeSetPreviewSizeWithLimit error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94026);
      return false;
    }
    localObject1 = h.a(localParameters, localPoint, i, bool);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((h.c)localObject1).vOe;
      label280:
      if (localObject3 == null)
      {
        ad.e(this.TAG, "fuck, preview size still null!!");
        if (localParameters == null) {
          p.gfZ();
        }
        localObject1 = this.hpP;
        if (localObject1 == null) {
          p.gfZ();
        }
        if (((d.a.a)localObject1).dGc == 90) {
          break label629;
        }
        localObject1 = this.hpP;
        if (localObject1 == null) {
          p.gfZ();
        }
        if (((d.a.a)localObject1).dGc != 270) {
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
        localObject3 = ((h.c)localObject1).vOe;
      }
      if (localObject3 != null)
      {
        localObject1 = ((h.c)localObject1).vOe;
        this.hph.rmx = ((Point)localObject1).x;
        this.hph.rmy = ((Point)localObject1).y;
        this.hpQ = null;
        ad.i(this.hoZ, "final set camera preview size: : %s, cropSize: %s", new Object[] { localObject1, this.hpQ });
        if (localParameters == null) {
          p.gfZ();
        }
        localParameters.setPreviewSize(this.hph.rmx, this.hph.rmy);
        localObject1 = this.fYS;
        if (localObject1 == null) {
          p.gfZ();
        }
        ((v)localObject1).setParameters(localParameters);
        AppMethodBeat.o(94026);
        return true;
      }
      label538:
      Object localObject2 = this.hpk;
      if (localObject2 == null) {
        p.gfZ();
      }
      i = ((Size)localObject2).getWidth();
      localObject2 = this.hpk;
      if (localObject2 == null) {
        p.gfZ();
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
  
  private final boolean nX(int paramInt)
  {
    AppMethodBeat.i(94048);
    if ((this.fYS == null) || (this.hpP == null))
    {
      ad.d(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(94048);
      return false;
    }
    Object localObject1 = this.hpP;
    if ((localObject1 == null) || (((d.a.a)localObject1).dGc != 90))
    {
      localObject1 = this.hpP;
      if ((localObject1 == null) || (((d.a.a)localObject1).dGc != 270)) {
        break label157;
      }
    }
    Camera.Parameters localParameters;
    label157:
    for (boolean bool = true;; bool = false) {
      try
      {
        localObject1 = this.fYS;
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
        ad.printErrStackTrace(this.TAG, (Throwable)localException, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(94048);
        return false;
      }
    }
    Object localObject3;
    if (this.hpk == null)
    {
      localObject2 = com.tencent.mm.plugin.mmsight.d.fM(this.context);
      localObject3 = h.c(localParameters, (Point)localObject2, paramInt, bool);
      if (((h.c)localObject3).vOe != null) {
        break label513;
      }
      ad.e(this.TAG, "fuck, preview size still null!!");
    }
    label513:
    for (Object localObject2 = h.d(localParameters, new Point(Math.min(((Point)localObject2).x, ((Point)localObject2).y), Math.max(((Point)localObject2).x, ((Point)localObject2).y)), this.hqb, bool);; localObject2 = localObject3)
    {
      if (((h.c)localObject2).vOe == null)
      {
        ad.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject2).toString() });
        ((h.c)localObject2).vOe = ((h.c)localObject2).vOh;
        ((h.c)localObject2).vOf = ((h.c)localObject2).vOi;
        ((h.c)localObject2).vOg = ((h.c)localObject2).vOj;
      }
      localObject3 = ((h.c)localObject2).vOe;
      if (localObject3 == null)
      {
        com.tencent.mm.plugin.mmsight.model.l.awB();
        AppMethodBeat.o(94048);
        return false;
        localObject2 = this.hpk;
        if (localObject2 == null) {
          p.gfZ();
        }
        int i = ((Size)localObject2).getWidth();
        localObject2 = this.hpk;
        if (localObject2 == null) {
          p.gfZ();
        }
        localObject2 = new Point(i, ((Size)localObject2).getHeight());
        break;
      }
      this.hph.rmx = ((Point)localObject3).x;
      this.hph.rmy = ((Point)localObject3).y;
      this.hpQ = ((Point)localObject3);
      if (((h.c)localObject2).vOf != null) {
        this.hpQ = ((h.c)localObject2).vOf;
      }
      ad.i(this.TAG, "final set camera preview size: " + localObject3 + ", cropSize: " + this.hpQ);
      localParameters.setPreviewSize(((Point)localObject3).x, ((Point)localObject3).y);
      localObject2 = this.fYS;
      if (localObject2 != null) {
        ((v)localObject2).setParameters(localParameters);
      }
      AppMethodBeat.o(94048);
      return true;
    }
  }
  
  private final boolean nY(int paramInt)
  {
    AppMethodBeat.i(94049);
    if ((this.fYS == null) || (this.hpP == null))
    {
      ad.d(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(94049);
      return false;
    }
    Object localObject1 = this.hpP;
    boolean bool;
    if (localObject1 != null) {
      if ((((d.a.a)localObject1).dGc == 90) || (((d.a.a)localObject1).dGc == 270)) {
        bool = true;
      }
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = this.fYS;
        if (localObject1 == null) {
          break label306;
        }
        localObject1 = ((v)localObject1).getParameters();
        if (this.hpk != null) {
          break label312;
        }
        localObject2 = com.tencent.mm.plugin.mmsight.d.fM(this.context);
        localObject3 = h.e((Camera.Parameters)localObject1, (Point)localObject2, paramInt, bool);
        if (((h.c)localObject3).vOe != null) {
          break label493;
        }
        ad.e(this.TAG, "fuck, preview size still null!!");
        localObject2 = h.d((Camera.Parameters)localObject1, new Point(Math.min(((Point)localObject2).x, ((Point)localObject2).y), Math.max(((Point)localObject2).x, ((Point)localObject2).y)), this.hqb, bool);
        if (((h.c)localObject2).vOe == null)
        {
          ad.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject2).toString() });
          ((h.c)localObject2).vOe = ((h.c)localObject2).vOh;
          ((h.c)localObject2).vOf = ((h.c)localObject2).vOi;
          ((h.c)localObject2).vOg = ((h.c)localObject2).vOj;
        }
        localObject3 = ((h.c)localObject2).vOe;
        if (localObject3 != null) {
          break label364;
        }
        com.tencent.mm.plugin.mmsight.model.l.awB();
        AppMethodBeat.o(94049);
        return false;
      }
      catch (Exception localException)
      {
        ad.i(this.TAG, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(94049);
        return false;
      }
      bool = false;
      continue;
      label306:
      Camera.Parameters localParameters = null;
      continue;
      label312:
      Object localObject2 = this.hpk;
      if (localObject2 == null) {
        p.gfZ();
      }
      int i = ((Size)localObject2).getWidth();
      localObject2 = this.hpk;
      if (localObject2 == null) {
        p.gfZ();
      }
      localObject2 = new Point(i, ((Size)localObject2).getHeight());
      continue;
      label364:
      this.hph.rmx = ((Point)localObject3).x;
      this.hph.rmy = ((Point)localObject3).y;
      if (((h.c)localObject2).vOg != null) {
        this.hpQ = ((h.c)localObject2).vOg;
      }
      ad.i(this.TAG, "final set camera preview size: " + localObject3 + ", cropSize: " + this.hpQ);
      if (localParameters != null) {
        localParameters.setPreviewSize(this.hph.rmx, this.hph.rmy);
      }
      localObject2 = this.fYS;
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
    p.h(paramString, "tag");
    AppMethodBeat.o(94052);
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
    ad.m(this.TAG, "addFrameDataCallback ".concat(String.valueOf(paramg)), new Object[0]);
    if (paramg == null)
    {
      AppMethodBeat.o(94020);
      return;
    }
    synchronized (this.lock)
    {
      this.hpN.add(paramg);
      AppMethodBeat.o(94020);
      return;
    }
  }
  
  public final void aa(String paramString, int paramInt)
  {
    AppMethodBeat.i(94053);
    p.h(paramString, "tag");
    AppMethodBeat.o(94053);
  }
  
  public final void awk()
  {
    AppMethodBeat.i(94030);
    if (!awa())
    {
      AppMethodBeat.o(94030);
      return;
    }
    c localc = this.hpO;
    c.a locala = c.hpI;
    localc.removeMessages(c.awi());
    AppMethodBeat.o(94030);
  }
  
  public final b awl()
  {
    boolean bool = true;
    AppMethodBeat.i(94036);
    ad.m(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.fYS == null)
    {
      ad.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(94036);
      return null;
    }
    if (!awa())
    {
      ad.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(94036);
      return null;
    }
    b.nR(getPreviewWidth());
    b.nQ(getPreviewHeight());
    Object localObject = this.hpP;
    int i;
    if (localObject != null) {
      if ((((d.a.a)localObject).dGc == 90) || (((d.a.a)localObject).dGc == 270))
      {
        i = 1;
        b.nT(this.hph.rmx);
        b.nU(this.hph.rmy);
        if (i != 0)
        {
          i = b.awe();
          b.nT(b.awf());
          b.nU(i);
        }
        b.nS(getOrientation());
        if (this.hpc) {
          break label202;
        }
      }
    }
    for (;;)
    {
      b.setFrontCamera(bool);
      b.eh(this.hpe);
      localObject = this.hpi;
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
  
  public final int awp()
  {
    if (this.hpc) {
      return 0;
    }
    return 1;
  }
  
  public final int awq()
  {
    AppMethodBeat.i(94050);
    int i = getOrientation();
    AppMethodBeat.o(94050);
    return i;
  }
  
  public final void awr()
  {
    this.hqf = 15;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94029);
    if (!awa())
    {
      AppMethodBeat.o(94029);
      return;
    }
    if (com.tencent.mm.compatible.util.d.lz(14))
    {
      AppMethodBeat.o(94029);
      return;
    }
    c localc = this.hpO;
    Object localObject = c.hpI;
    localc.removeMessages(c.awi());
    this.hpO.gmK = paramFloat1;
    this.hpO.gmL = paramFloat2;
    this.hpO.hpy = paramInt1;
    this.hpO.hpz = paramInt2;
    localc = this.hpO;
    localObject = this.hpO;
    c.a locala = c.hpI;
    localc.sendMessageDelayed(((c)localObject).obtainMessage(c.awi(), this.fYS), 400L);
    AppMethodBeat.o(94029);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(94021);
    ad.m(this.TAG, "removeFrameDataCallback ".concat(String.valueOf(paramg)), new Object[0]);
    if (paramg == null)
    {
      AppMethodBeat.o(94021);
      return;
    }
    synchronized (this.lock)
    {
      this.hpN.remove(paramg);
      AppMethodBeat.o(94021);
      return;
    }
  }
  
  public final Point ei(boolean paramBoolean)
  {
    AppMethodBeat.i(94039);
    Object localObject;
    if (!paramBoolean)
    {
      localObject = new Point(this.hph.rmx, this.hph.rmy);
      AppMethodBeat.o(94039);
      return localObject;
    }
    if (this.hpQ != null)
    {
      Point localPoint = this.hpQ;
      localObject = localPoint;
      if (localPoint == null)
      {
        p.gfZ();
        AppMethodBeat.o(94039);
        return localPoint;
      }
    }
    else
    {
      localObject = new Point(this.hph.rmx, this.hph.rmy);
    }
    AppMethodBeat.o(94039);
    return localObject;
  }
  
  public final void ej(boolean paramBoolean)
  {
    AppMethodBeat.i(94055);
    for (;;)
    {
      try
      {
        Object localObject1 = this.fYS;
        if (localObject1 == null) {
          break label103;
        }
        localObject1 = ((v)localObject1).getParameters();
        if (paramBoolean)
        {
          if (localObject1 != null) {
            ((Camera.Parameters)localObject1).setFlashMode("torch");
          }
          v localv = this.fYS;
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
        ad.printErrStackTrace(this.TAG, (Throwable)localException, "set flash mode error", new Object[0]);
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
    Object localObject = this.fYS;
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
    if ((this.hqc != null) || (this.fYS != null)) {}
    float[] arrayOfFloat;
    label218:
    label474:
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = this.fYS;
        if (localObject2 == null) {
          p.gfZ();
        }
        localObject2 = ((v)localObject2).getParameters();
        if (localObject2 == null) {
          p.gfZ();
        }
        boolean bool = ((Camera.Parameters)localObject2).isZoomSupported();
        if (!bool)
        {
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            break label218;
          }
          this.hqc = new com.tencent.tinker.a.c.b();
          localObject1 = this.hqc;
          if (localObject1 == null) {
            p.gfZ();
          }
          localObject1 = new float[((com.tencent.tinker.a.c.b)localObject1).size()];
          localObject2 = this.hqc;
          if (localObject2 == null) {
            p.gfZ();
          }
          j = ((com.tencent.tinker.a.c.b)localObject2).size();
          i = 0;
          if (i >= j) {
            break;
          }
          localObject2 = this.hqc;
          if (localObject2 == null) {
            p.gfZ();
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
        ad.e(this.TAG, "getZoom error: %s", new Object[] { localException.getMessage() });
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
      this.hqc = new com.tencent.tinker.a.c.b(j);
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
            localObject2 = this.hqc;
            if (localObject2 == null) {
              p.gfZ();
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
            localObject2 = this.hqc;
            if (localObject2 == null) {
              p.gfZ();
            }
            ((com.tencent.tinker.a.c.b)localObject2).append(k, m + k * i);
          }
          else
          {
            m += 1;
            break label330;
            localObject2 = this.hqc;
            if (localObject2 == null) {
              p.gfZ();
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
    if ((this.fYS != null) && (awa())) {
      try
      {
        ad.d(this.TAG, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (this.aYh)
        {
          ad.d(this.TAG, "triggerSmallZoom, zooming, ignore");
          return;
        }
        Object localObject1 = this.fYS;
        if (localObject1 != null) {
          localObject1 = ((v)localObject1).getParameters();
        }
        int i;
        int j;
        while ((localObject1 != null) && (((Camera.Parameters)localObject1).isZoomSupported() == true))
        {
          this.aYh = true;
          i = ((Camera.Parameters)localObject1).getZoom();
          j = this.hqd.indexOf(Integer.valueOf(i));
          int k = ((Camera.Parameters)localObject1).getMaxZoom();
          ad.d(this.TAG, "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(this.hpS), Integer.valueOf(this.hpR), Integer.valueOf(paramInt) });
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
            if (j != this.hqd.size() - 1) {
              break label316;
            }
            paramInt = ((Number)j.je((List)this.hqd)).intValue();
          }
        }
        for (;;)
        {
          ad.d(this.TAG, "triggerSmallZoom, nextZoom: %s, smoothZoomSupported: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(((Camera.Parameters)localObject1).isSmoothZoomSupported()) });
          ((Camera.Parameters)localObject1).setZoom(paramInt);
          Object localObject3 = this.fYS;
          if (localObject3 != null) {
            ((v)localObject3).setParameters((Camera.Parameters)localObject1);
          }
          return;
          label316:
          localObject3 = this.hqd.get(j + 1);
          p.g(localObject3, "availableZoomRatioIndexList[currentZoomIndex + 1]");
          paramInt = ((Number)localObject3).intValue();
          continue;
          label349:
          if (i == 0) {
            return;
          }
          if (j == 0)
          {
            paramInt = ((Number)j.jc((List)this.hqd)).intValue();
          }
          else
          {
            localObject3 = this.hqd.get(j - 1);
            p.g(localObject3, "availableZoomRatioIndexList[currentZoomIndex - 1]");
            paramInt = ((Number)localObject3).intValue();
          }
        }
        AppMethodBeat.o(94032);
      }
      catch (Exception localException)
      {
        ad.e(this.TAG, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYh = false;
        AppMethodBeat.o(94032);
      }
    }
  }
  
  public final void nW(int paramInt)
  {
    AppMethodBeat.i(94031);
    if (this.hpR > 0)
    {
      AppMethodBeat.o(94031);
      return;
    }
    Object localObject = al.ci(aj.getContext());
    int i = ((Point)localObject).y;
    ad.i(this.TAG, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(94031);
      return;
    }
    try
    {
      if (this.fYS != null)
      {
        localObject = this.fYS;
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
            this.hpR = ((int)d + 1);
          }
          ad.i(this.TAG, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.hpR), Integer.valueOf(i) });
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
      ad.e(this.TAG, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(94031);
    }
  }
  
  public final void o(d.g.a.b<? super Boolean, z> paramb)
  {
    this.hqe = paramb;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94054);
    super.release();
    try
    {
      ad.i(this.TAG, this.hpT.getValue());
      ad.i(this.TAG, this.hpU.getValue());
      ad.i(this.TAG, this.hpV.getValue());
      ad.i(this.TAG, this.hpW.getValue());
      ad.i(this.TAG, this.hpX.getValue());
      if (this.fYS != null)
      {
        long l = bt.HI();
        ad.i(this.TAG, "release camera beg, %s", new Object[] { Looper.myLooper() });
        this.hpO.removeCallbacksAndMessages(null);
        this.hpO.hpx = true;
        v localv = this.fYS;
        if (localv != null) {
          localv.setPreviewCallback(null);
        }
        localv = this.fYS;
        if (localv != null) {
          localv.stopPreview();
        }
        localv = this.fYS;
        if (localv != null) {
          localv.release();
        }
        this.fYS = null;
        ad.i(this.TAG, "release camera end, use %dms, %s", new Object[] { Long.valueOf(bt.aO(l)), Looper.myLooper() });
      }
      this.hpO.hpv = false;
      this.hpO.hpA = true;
      this.hpQ = null;
      this.hpZ = null;
      this.hqa = false;
      AppMethodBeat.o(94054);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "cameraRelease error", new Object[0]);
      AppMethodBeat.o(94054);
    }
  }
  
  public final boolean s(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(94019);
    p.h(paramContext, "context");
    for (;;)
    {
      try
      {
        if (this.hqa)
        {
          ad.i(this.TAG, "initCamera, already open");
          AppMethodBeat.o(94019);
          return true;
        }
        Object localObject = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.aui();
        super.s(paramContext, paramBoolean);
        release();
        if (paramBoolean)
        {
          i = com.tencent.mm.compatible.deviceinfo.d.ZY();
          ad.m(this.TAG, "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(i), Integer.valueOf(ae.gcE.fYD) });
          this.hpP = new f().a(paramContext, i, Looper.getMainLooper());
          ad.i(this.TAG, "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.hpP == null)
          {
            ad.i(this.TAG, "open camera FAILED, %s", new Object[] { Looper.myLooper() });
            avY();
            AppMethodBeat.o(94019);
            return false;
          }
        }
        else
        {
          i = com.tencent.mm.compatible.deviceinfo.d.ZZ();
          continue;
        }
        paramContext = this.hpP;
        if (paramContext != null)
        {
          paramContext = paramContext.fYS;
          this.fYS = paramContext;
          this.hpO.hpx = false;
          paramContext = this.hph;
          localObject = this.hpP;
          if (localObject == null) {
            break label317;
          }
          i = ((d.a.a)localObject).dGc;
          paramContext.dGc = i;
          if (this.fYS == null)
          {
            ad.e(this.TAG, "start camera FAILED!");
            avY();
            AppMethodBeat.o(94019);
            return false;
          }
          this.hqa = true;
          AppMethodBeat.o(94019);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)paramContext, "init camera failed!", new Object[0]);
        paramContext = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.auk();
        AppMethodBeat.o(94019);
        return false;
      }
      paramContext = null;
      continue;
      label317:
      int i = 0;
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
      ej(false);
      AppMethodBeat.o(94057);
      return;
      ej(true);
    }
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(94034);
    if (this.aYh)
    {
      ad.d(this.TAG, "setForceZoomTargetRatio, zooming, ignore");
      AppMethodBeat.o(94034);
      return;
    }
    if (this.fYS != null) {
      try
      {
        Object localObject1 = this.fYS;
        if (localObject1 == null) {
          p.gfZ();
        }
        localObject1 = ((v)localObject1).getParameters();
        if (localObject1 == null) {
          p.gfZ();
        }
        boolean bool = ((Camera.Parameters)localObject1).isZoomSupported();
        if (!bool) {
          return;
        }
        if (this.hqc == null)
        {
          ad.d(this.TAG, "setForceZoomTargetRatio before init zoom info, ignore");
          return;
        }
        Object localObject3 = ((Camera.Parameters)localObject1).getZoomRatios();
        com.tencent.tinker.a.c.b localb = this.hqc;
        if (localb == null) {
          p.gfZ();
        }
        int i = ((List)localObject3).indexOf(Integer.valueOf(localb.get(d.h.a.co(10.0F * paramFloat))));
        if (i >= 0)
        {
          int j = ((Camera.Parameters)localObject1).getMaxZoom();
          if (i <= j) {}
        }
        else
        {
          return;
        }
        this.aYh = true;
        ((Camera.Parameters)localObject1).setZoom(i);
        localObject3 = this.fYS;
        if (localObject3 == null) {
          p.gfZ();
        }
        ((v)localObject3).setParameters((Camera.Parameters)localObject1);
        return;
      }
      catch (Exception localException)
      {
        ad.e(this.TAG, "setForceZoomTargetRatio error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYh = false;
        AppMethodBeat.o(94034);
      }
    }
    AppMethodBeat.o(94034);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/CommonCamera1$setPreviewCallbackImpl$1$1"})
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
        ad.e(d.a(this.hqg), "onPreviewFrame, frame data is null!!");
        AppMethodBeat.o(94017);
        return;
      }
      if (this.hqg.hpN.size() <= 0)
      {
        paramCamera = this.hqg.fYS;
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
      if (!d.b(this.hqg))
      {
        paramCamera = paramArrayOfByte;
        if (this.hqg.hpN.size() > 0)
        {
          paramCamera = paramArrayOfByte;
          if (this.hqg.hpQ != null)
          {
            paramCamera = this.hqg.hpQ;
            if ((paramCamera != null) && (paramCamera.x == this.hqg.hph.rmx))
            {
              paramCamera = this.hqg.hpQ;
              if ((paramCamera != null) && (paramCamera.y == this.hqg.hph.rmy)) {
                break label573;
              }
            }
            paramCamera = k.vQc;
            i = this.hqg.hph.rmx;
            localObject = this.hqg.hpQ;
            if (localObject == null) {
              p.gfZ();
            }
            paramCamera = paramCamera.g(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
            d.c(this.hqg).yf(1L);
            l1 = bt.HI();
            i = this.hqg.hph.rmx;
            int j = this.hqg.hph.rmy;
            localObject = this.hqg.hpQ;
            if (localObject == null) {
              p.gfZ();
            }
            SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
            localObject = this.hqg.hpQ;
            if (localObject == null) {
              p.gfZ();
            }
            if (((Point)localObject).x >= this.hqg.hph.rmx) {
              break label640;
            }
            localObject = k.vQc;
            Point localPoint = this.hqg.hpQ;
            if (localPoint == null) {
              p.gfZ();
            }
            i = localPoint.x;
            localPoint = this.hqg.hpQ;
            if (localPoint == null) {
              p.gfZ();
            }
            localObject = ((k)localObject).g(Integer.valueOf(i * localPoint.y * 3 / 2));
            i = this.hqg.hph.rmx;
            localPoint = this.hqg.hpQ;
            if (localPoint == null) {
              p.gfZ();
            }
            j = localPoint.x;
            localPoint = this.hqg.hpQ;
            if (localPoint == null) {
              p.gfZ();
            }
            SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
            k.vQc.k(paramCamera);
            paramCamera = (Camera)localObject;
          }
        }
      }
      label640:
      for (;;)
      {
        long l2 = bt.aO(l1);
        d.d(this.hqg).yf(l2);
        localObject = this.hqg;
        p.g(paramCamera, "curFrameData");
        boolean bool = d.a((d)localObject, paramCamera);
        l1 = bt.aO(l1);
        paramCamera = paramArrayOfByte;
        if (bool)
        {
          d.e(this.hqg).yf(l1);
          paramCamera = paramArrayOfByte;
        }
        for (;;)
        {
          paramArrayOfByte = this.hqg.fYS;
          if (paramArrayOfByte == null) {
            break;
          }
          paramArrayOfByte.addCallbackBuffer(paramCamera);
          AppMethodBeat.o(94017);
          return;
          label573:
          l1 = bt.HI();
          bool = d.a(this.hqg, paramArrayOfByte);
          l1 = bt.aO(l1);
          if (bool) {
            d.e(this.hqg).yf(l1);
          }
          paramCamera = paramArrayOfByte;
          if (bool) {
            paramCamera = k.vQc.g(Integer.valueOf(paramArrayOfByte.length));
          }
        }
        AppMethodBeat.o(94017);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "ca", "Landroid/hardware/Camera;", "onPreviewFrame"})
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
        ad.e(d.a(this.hqg), "onPreviewFrame, frame data is null!!");
        AppMethodBeat.o(94018);
        return;
      }
      Object localObject;
      long l1;
      int j;
      if ((!d.b(this.hqg)) && (this.hqg.hpN != null) && (this.hqg.hpN.size() > 0)) {
        if (this.hqg.hpQ != null)
        {
          paramCamera = k.vQc;
          i = this.hqg.hph.rmx;
          localObject = this.hqg.hpQ;
          if (localObject == null) {
            p.gfZ();
          }
          paramCamera = paramCamera.g(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
          d.c(this.hqg).yf(1L);
          l1 = bt.HI();
          i = this.hqg.hph.rmx;
          j = this.hqg.hph.rmy;
          localObject = this.hqg.hpQ;
          if (localObject == null) {
            p.gfZ();
          }
          SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
          localObject = this.hqg.hpQ;
          if (localObject == null) {
            p.gfZ();
          }
          if (((Point)localObject).x >= this.hqg.hph.rmx) {
            break label728;
          }
          localObject = k.vQc;
          Point localPoint = this.hqg.hpQ;
          if (localPoint == null) {
            p.gfZ();
          }
          i = localPoint.x;
          localPoint = this.hqg.hpQ;
          if (localPoint == null) {
            p.gfZ();
          }
          localObject = ((k)localObject).g(Integer.valueOf(i * localPoint.y * 3 / 2));
          i = this.hqg.hph.rmx;
          localPoint = this.hqg.hpQ;
          if (localPoint == null) {
            p.gfZ();
          }
          j = localPoint.x;
          localPoint = this.hqg.hpQ;
          if (localPoint == null) {
            p.gfZ();
          }
          SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
          k.vQc.k(paramCamera);
          paramCamera = (Camera)localObject;
        }
      }
      label728:
      for (;;)
      {
        long l2 = bt.aO(l1);
        d.d(this.hqg).yf(l2);
        if (!this.hqg.hpc)
        {
          l1 = bt.HI();
          localObject = this.hqg.hpQ;
          if (localObject == null) {
            p.gfZ();
          }
          i = ((Point)localObject).x;
          localObject = this.hqg.hpQ;
          if (localObject == null) {
            p.gfZ();
          }
          j = ((Point)localObject).y;
          localObject = this.hqg.hpP;
          if (localObject == null) {
            p.gfZ();
          }
          if (((d.a.a)localObject).dGc != 270)
          {
            localObject = this.hqg.hpP;
            if (localObject == null) {
              p.gfZ();
            }
            if (((d.a.a)localObject).dGc != 90) {}
          }
          else
          {
            bool = true;
            SightVideoJNI.mirrorCameraData(paramCamera, i, j, bool);
          }
        }
        else
        {
          localObject = this.hqg;
          p.g(paramCamera, "curFrameData");
          bool = d.a((d)localObject, paramCamera);
          l1 = bt.aO(l1);
          if (bool) {
            d.e(this.hqg).yf(l1);
          }
        }
        for (;;)
        {
          d.b(this.hqg, paramCamera);
          paramCamera = this.hqg.fYS;
          if (paramCamera == null) {
            p.gfZ();
          }
          paramCamera.addCallbackBuffer(paramArrayOfByte);
          AppMethodBeat.o(94018);
          return;
          bool = false;
          break;
          if (!this.hqg.hpc)
          {
            i = this.hqg.hph.rmx;
            j = this.hqg.hph.rmy;
            paramCamera = this.hqg.hpP;
            if (paramCamera == null) {
              p.gfZ();
            }
            if (paramCamera.dGc != 270)
            {
              paramCamera = this.hqg.hpP;
              if (paramCamera == null) {
                p.gfZ();
              }
              if (paramCamera.dGc != 90) {}
            }
            else
            {
              bool = true;
            }
            SightVideoJNI.mirrorCameraData(paramArrayOfByte, i, j, bool);
          }
          d.a(this.hqg, paramArrayOfByte);
          paramCamera = paramArrayOfByte;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.d
 * JD-Core Version:    0.7.0.1
 */