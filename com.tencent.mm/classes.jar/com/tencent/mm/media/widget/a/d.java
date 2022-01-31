package com.tencent.mm.media.widget.a;

import a.l;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Looper;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "context", "Landroid/content/Context;", "useBack", "", "(Landroid/content/Context;Z)V", "DEFAULT_UPPER_BOUND", "", "SMALL_ZOOM_STEP_NUM", "getSMALL_ZOOM_STEP_NUM", "()I", "SMALL_ZOOM_STEP_UPPER_BOUND", "getSMALL_ZOOM_STEP_UPPER_BOUND", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "cameraCallback", "Lcom/tencent/mm/plugin/mmsight/model/CounterUtil;", "cameraCropCallback", "cameraPreviewCallback", "cropSize", "Landroid/graphics/Point;", "getCropSize", "()Landroid/graphics/Point;", "setCropSize", "(Landroid/graphics/Point;)V", "currentFrameData", "", "finishCallbackTimeCallback", "frameDataCallbackList", "", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getFrameDataCallbackList", "()Ljava/util/List;", "setFrameDataCallbackList", "(Ljava/util/List;)V", "isCameraOpen", "isZooming", "()Z", "setZooming", "(Z)V", "lock", "Ljava/lang/Object;", "openCameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "getOpenCameraRes", "()Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "setOpenCameraRes", "(Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;)V", "prevcameraCallback", "scrollSmallZoomStep", "getScrollSmallZoomStep", "setScrollSmallZoomStep", "(I)V", "sightHandler", "Lcom/tencent/mm/media/widget/camera/CameraHandler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera/CameraHandler;", "smallZoomStep", "getSmallZoomStep", "setSmallZoomStep", "takePictureLock", "addFrameDataCallback", "", "callback", "calcScrollZoomStep", "recordButtonTopLocation", "stepInterval", "dispatchCameraFrame", "frame", "doStartPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getOrientation", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "getPreviewWidth", "initCamera", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "safeResetZoom", "safeSetFocusMode", "safeSetMetering", "safeSetPreviewFormat", "safeSetPreviewFrameRate", "useFixMode", "safeSetPreviewSize", "resolutionLimit", "safeSetStabilization", "selectNoCropPreviewSize", "setPreviewCallbackImpl", "setSafeConfig", "startPreview", "useCpuCrop", "startPreviewWithCPU", "startPreviewWithGPU", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "trySetPreviewFpsRangeParameters", "p", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "trySetPreviewFrameRateParameters", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  private boolean asm;
  u eoH;
  private final com.tencent.mm.plugin.mmsight.model.b faA;
  private final com.tencent.mm.plugin.mmsight.model.b faB;
  private final com.tencent.mm.plugin.mmsight.model.b faC;
  private volatile boolean faD;
  private volatile byte[] faE;
  private boolean faF;
  private final int faG;
  private final int fap;
  private final int faq;
  List<com.tencent.mm.plugin.mmsight.model.f> fas;
  private final c fat;
  private d.a.a fau;
  Point fav;
  private int faw;
  private int fax;
  private final com.tencent.mm.plugin.mmsight.model.b fay;
  private final com.tencent.mm.plugin.mmsight.model.b faz;
  private final Object lock;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(13222);
    this.fap = 20;
    this.faq = 5;
    this.fas = ((List)new ArrayList());
    paramContext = Looper.getMainLooper();
    a.f.b.j.p(paramContext, "Looper.getMainLooper()");
    this.fat = new c(paramContext);
    this.faw = -1;
    this.fax = -1;
    this.fay = new com.tencent.mm.plugin.mmsight.model.b("prevcameraCallback");
    this.faz = new com.tencent.mm.plugin.mmsight.model.b("cameraCallback");
    this.faA = new com.tencent.mm.plugin.mmsight.model.b("cameraPreviewCallback");
    this.faB = new com.tencent.mm.plugin.mmsight.model.b("cameraCropCallback");
    this.faC = new com.tencent.mm.plugin.mmsight.model.b("finishCallbackTimeCallback");
    this.faG = 2100;
    this.lock = new Object();
    AppMethodBeat.o(13222);
  }
  
  private final boolean M(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13220);
    bo.yB();
    synchronized (this.lock)
    {
      if (this.fas != null)
      {
        int i = this.fas.size();
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(13220);
        return false;
      }
      Iterator localIterator = this.fas.iterator();
      boolean bool1 = false;
      while (localIterator.hasNext())
      {
        boolean bool2 = ((com.tencent.mm.plugin.mmsight.model.f)localIterator.next()).N(paramArrayOfByte);
        bool1 |= bool2;
      }
      AppMethodBeat.o(13220);
      return bool1;
    }
  }
  
  private final void WV()
  {
    AppMethodBeat.i(13204);
    Integer localInteger = Integer.valueOf(0);
    Object localObject = com.tencent.mm.plugin.mmsight.model.a.k.bRq();
    a.f.b.j.p(localObject, "MMSightController.getInstance()");
    if (((com.tencent.mm.plugin.mmsight.model.a.k)localObject).bRr() != null)
    {
      localObject = com.tencent.mm.plugin.mmsight.model.a.k.bRq();
      a.f.b.j.p(localObject, "MMSightController.getInstance()");
      localInteger = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.a.k)localObject).bRr().oGa);
    }
    String str = this.TAG;
    boolean bool1;
    label92:
    boolean bool2;
    label104:
    boolean bool3;
    label116:
    boolean bool4;
    if (ac.eru.eom == 1)
    {
      localObject = "Range";
      if (ac.eru.eon != 1) {
        break label388;
      }
      bool1 = true;
      if (ac.eru.eoo != 1) {
        break label393;
      }
      bool2 = true;
      if (ac.eru.eop != 1) {
        break label398;
      }
      bool3 = true;
      if (ac.eru.eoq != 1) {
        break label403;
      }
      bool4 = true;
      label129:
      ab.i(str, "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if ((ac.eru.eom != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 1))) {
        break label409;
      }
      a(this.eoH, false);
    }
    for (;;)
    {
      if ((ac.eru.eon == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
        b(this.eoH);
      }
      if ((ac.erB.eqS != -1) && (ac.erB.eqS == 1) && (com.tencent.mm.compatible.util.d.iU(14))) {
        c(this.eoH);
      }
      if ((ac.eru.eop == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
        a(this.eoH);
      }
      if ((ac.eru.eoq == 1) && (localInteger.intValue() != 0)) {
        localInteger.intValue();
      }
      WZ();
      AppMethodBeat.o(13204);
      return;
      if (ac.eru.eol == 1)
      {
        localObject = "Fix";
        break;
      }
      localObject = "Error";
      break;
      label388:
      bool1 = false;
      break label92;
      label393:
      bool2 = false;
      break label104;
      label398:
      bool3 = false;
      break label116;
      label403:
      bool4 = false;
      break label129;
      label409:
      if ((ac.eru.eol == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 5))) {
        a(this.eoH, true);
      }
    }
  }
  
  private void WZ()
  {
    AppMethodBeat.i(13214);
    try
    {
      Object localObject = this.eoH;
      if (localObject != null) {}
      for (localObject = ((u)localObject).getParameters();; localObject = null)
      {
        if ((localObject != null) && (((Camera.Parameters)localObject).isZoomSupported() == true)) {
          ((Camera.Parameters)localObject).setZoom(0);
        }
        u localu = this.eoH;
        if (localu == null) {
          break;
        }
        localu.setParameters((Camera.Parameters)localObject);
        AppMethodBeat.o(13214);
        return;
      }
      AppMethodBeat.o(13214);
      return;
    }
    catch (Exception localException)
    {
      ab.e(this.TAG, "safeResetZoom error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(13214);
    }
  }
  
  private final void Xa()
  {
    AppMethodBeat.i(13217);
    if (this.eoH == null)
    {
      AppMethodBeat.o(13217);
      return;
    }
    try
    {
      if (this.eoH == null) {
        break label233;
      }
      Object localObject1 = this.eoH;
      if (localObject1 != null)
      {
        localObject1 = ((u)localObject1).getParameters();
        if (localObject1 != null) {}
      }
      else
      {
        AppMethodBeat.o(13217);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(13217);
      return;
    }
    int i = this.eZN.mnr;
    int j = this.eZN.mns;
    j = ImageFormat.getBitsPerPixel(localException.getPreviewFormat()) * (i * j) / 8;
    ab.i(this.TAG, "setPreviewCallbackImpl  size: ".concat(String.valueOf(j)));
    i = 0;
    for (;;)
    {
      Object localObject2;
      if (i < 5)
      {
        localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(j));
        u localu = this.eoH;
        if (localu != null) {
          localu.addCallbackBuffer((byte[])localObject2);
        }
      }
      else
      {
        this.fay.reset();
        this.faz.reset();
        this.faA.reset();
        this.faB.reset();
        this.faC.reset();
        localObject2 = this.eoH;
        if (localObject2 != null)
        {
          ((u)localObject2).setPreviewCallbackWithBuffer((Camera.PreviewCallback)new d.a(this));
          AppMethodBeat.o(13217);
          return;
        }
        label233:
        AppMethodBeat.o(13217);
        return;
      }
      i += 1;
    }
  }
  
  private final void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(13201);
    long l = bo.yB();
    ab.i(this.TAG, "start startPreviewWithCPU,Looper.myLooper(): " + Looper.myLooper() + ",surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (WO())
    {
      ab.i(this.TAG, "startPreviewWithCPU, camera previewing");
      AppMethodBeat.o(13201);
      return;
    }
    try
    {
      ki(paramInt);
      WV();
      Xa();
      if (a(paramSurfaceTexture, paramSurfaceHolder)) {
        a(a.a.eZS);
      }
      ab.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(bo.av(l)), Looper.myLooper() });
      AppMethodBeat.o(13201);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        ab.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Vs();
      }
    }
  }
  
  private final boolean a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(13203);
    u localu = this.eoH;
    if (localu != null)
    {
      if ((paramSurfaceTexture != null) || (paramSurfaceHolder != null))
      {
        if (paramSurfaceTexture != null) {
          localu.setPreviewTexture(paramSurfaceTexture);
        }
        for (;;)
        {
          localu.startPreview();
          ab.i(this.TAG, "doStartPreview finish");
          paramSurfaceTexture = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.Vr();
          AppMethodBeat.o(13203);
          return true;
          localu.setPreviewDisplay(paramSurfaceHolder);
        }
      }
      ab.i(this.TAG, "doStartPreview error, surfaceTexture and surface is null");
      paramSurfaceTexture = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.Vs();
      AppMethodBeat.o(13203);
      return false;
    }
    AppMethodBeat.o(13203);
    return false;
  }
  
  private boolean a(u paramu)
  {
    AppMethodBeat.i(13213);
    if (paramu == null)
    {
      AppMethodBeat.o(13213);
      return false;
    }
    for (;;)
    {
      Camera.Parameters localParameters;
      List localList;
      try
      {
        localParameters = paramu.getParameters();
        a.f.b.j.p(localParameters, "p");
        localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          ab.i(this.TAG, "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          paramu.setParameters(localParameters);
          AppMethodBeat.o(13213);
          return true;
        }
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          ab.i(this.TAG, "support continuous video");
          localParameters.setFocusMode("continuous-video");
          continue;
        }
        if (localList == null) {
          break label189;
        }
      }
      catch (Exception paramu)
      {
        ab.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramu.getMessage() });
        AppMethodBeat.o(13213);
        return false;
      }
      if (localList.contains("auto"))
      {
        ab.i(this.TAG, "support auto focus");
        localParameters.setFocusMode("auto");
      }
      else
      {
        label189:
        ab.i(this.TAG, "not support continuous video or auto focus");
      }
    }
  }
  
  private final boolean a(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(13212);
    if (paramu == null)
    {
      AppMethodBeat.o(13212);
      return false;
    }
    int i;
    label273:
    int i1;
    int i3;
    int i2;
    for (;;)
    {
      Camera.Parameters localParameters;
      try
      {
        localParameters = paramu.getParameters();
        if (!paramBoolean) {
          break label273;
        }
        Object localObject;
        if (ac.eru.eoh > 0)
        {
          ab.i(this.eZH, "set frame rate > 0, do not try set preview frame rate");
          a.f.b.j.p(localParameters, "p");
          localObject = localParameters.getSupportedPreviewFrameRates();
          ab.i(this.eZH, "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localObject });
          paramu.setParameters(localParameters);
          AppMethodBeat.o(13212);
          return true;
        }
        if (localParameters == null)
        {
          ab.e(this.TAG, "trySetPreviewFrameRateParameters error, p is null!");
          continue;
        }
        try
        {
          localObject = localParameters.getSupportedPreviewFrameRates();
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            continue;
          }
          localObject = Collections.max((Collection)localObject);
          a.f.b.j.p(localObject, "Collections.max(fr)");
          i = Math.min(30, ((Number)localObject).intValue());
          localParameters.setPreviewFrameRate(i);
          ab.i(this.eZH, "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
        }
        catch (Exception localException1)
        {
          ab.i(this.eZH, "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException1.getMessage() });
        }
      }
      catch (Exception paramu)
      {
        ab.i(this.eZH, "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramu.getMessage() });
        AppMethodBeat.o(13212);
        return false;
      }
      continue;
      a.f.b.j.p(localParameters, "p");
      if (ac.eru.eoh > 0)
      {
        ab.i(this.eZH, "set frame rate > 0, do not try set preview fps range");
      }
      else
      {
        List localList = localParameters.getSupportedPreviewFpsRange();
        if ((localList != null) && (localList.size() != 0))
        {
          j = -2147483648;
          k = -2147483648;
          i = 0;
          int i4 = localList.size();
          i1 = 0;
          if (i1 < i4)
          {
            int[] arrayOfInt = (int[])localList.get(i1);
            if ((arrayOfInt == null) || (arrayOfInt.length <= 1)) {
              break;
            }
            i3 = arrayOfInt[0];
            i2 = arrayOfInt[1];
            ab.i(this.TAG, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(i2) });
            if (i3 < 0) {
              break label599;
            }
            if (i2 >= i3) {
              break label602;
            }
            break label599;
          }
          ab.i(this.eZH, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(30) });
          if ((j != 2147483647) && (k != 2147483647)) {
            try
            {
              localParameters.setPreviewFpsRange(j, k);
              ab.i(this.eZH, "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            }
            catch (Exception localException2)
            {
              ab.i(this.eZH, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException2.getMessage() });
            }
          }
        }
      }
    }
    label579:
    int n;
    int k = n;
    int m;
    int j = m;
    for (;;)
    {
      i1 += 1;
      break;
      label599:
      continue;
      label602:
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
      if (i2 < 30000) {
        break label579;
      }
      i = 1;
      k = n;
      j = m;
    }
  }
  
  private final void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(13202);
    long l = bo.yB();
    ab.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (WO())
    {
      ab.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(13202);
      return;
    }
    try
    {
      kj(paramInt);
      WV();
      if (a(paramSurfaceTexture, paramSurfaceHolder)) {
        a(a.a.eZS);
      }
      ab.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(bo.av(l)), Looper.myLooper() });
      AppMethodBeat.o(13202);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        ab.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Vs();
      }
    }
  }
  
  private boolean b(u paramu)
  {
    AppMethodBeat.i(13215);
    if (paramu == null)
    {
      AppMethodBeat.o(13215);
      return false;
    }
    try
    {
      ab.i(this.TAG, "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramu.getParameters();
      a.f.b.j.p(localParameters, "p");
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        ab.e(this.TAG, "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramu.setParameters(localParameters);
      AppMethodBeat.o(13215);
      return true;
    }
    catch (Exception paramu)
    {
      ab.i(this.TAG, "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramu.getMessage() });
      AppMethodBeat.o(13215);
    }
    return false;
  }
  
  @TargetApi(14)
  private boolean c(u paramu)
  {
    AppMethodBeat.i(13216);
    if (paramu == null)
    {
      AppMethodBeat.o(13216);
      return false;
    }
    try
    {
      ab.i(this.TAG, "safeSetMetering");
      Camera.Parameters localParameters = paramu.getParameters();
      a.f.b.j.p(localParameters, "params");
      if (localParameters.getMaxNumMeteringAreas() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(new Rect(-1000, -1000, 1000, 1000), 600));
        localParameters.setMeteringAreas((List)localArrayList);
      }
      paramu.setParameters(localParameters);
      AppMethodBeat.o(13216);
      return true;
    }
    catch (Exception paramu)
    {
      ab.i(this.TAG, "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramu.getMessage() });
      AppMethodBeat.o(13216);
    }
    return false;
  }
  
  private final int getPreviewHeight()
  {
    AppMethodBeat.i(13210);
    if (this.eoH == null)
    {
      AppMethodBeat.o(13210);
      return 0;
    }
    if (this.fau != null) {
      try
      {
        if ((this.eZM) && (this.fav != null))
        {
          Point localPoint = this.fav;
          if (localPoint == null) {
            a.f.b.j.ebi();
          }
          i = localPoint.y;
          AppMethodBeat.o(13210);
          return i;
        }
        int i = this.eZN.mns;
        AppMethodBeat.o(13210);
        return i;
      }
      catch (Exception localException)
      {
        ab.e(this.TAG, "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(13210);
    return 0;
  }
  
  private final int getPreviewWidth()
  {
    AppMethodBeat.i(13211);
    if (this.eoH == null)
    {
      AppMethodBeat.o(13211);
      return 0;
    }
    if (this.fau != null) {
      try
      {
        if ((this.eZM) && (this.fav != null))
        {
          Point localPoint = this.fav;
          if (localPoint == null) {
            a.f.b.j.ebi();
          }
          i = localPoint.x;
          AppMethodBeat.o(13211);
          return i;
        }
        int i = this.eZN.mnr;
        AppMethodBeat.o(13211);
        return i;
      }
      catch (Exception localException)
      {
        ab.e(this.TAG, "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(13211);
    return 0;
  }
  
  private final boolean ki(int paramInt)
  {
    AppMethodBeat.i(13218);
    if ((this.eoH == null) || (this.fau == null))
    {
      ab.d(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(13218);
      return false;
    }
    Object localObject1 = this.fau;
    if ((localObject1 == null) || (((d.a.a)localObject1).rotate != 90))
    {
      localObject1 = this.fau;
      if ((localObject1 == null) || (((d.a.a)localObject1).rotate != 270)) {
        break label145;
      }
    }
    Camera.Parameters localParameters;
    label145:
    for (boolean bool = true;; bool = false) {
      try
      {
        localObject1 = this.eoH;
        if (localObject1 != null)
        {
          localParameters = ((u)localObject1).getParameters();
          if (localParameters != null) {
            break;
          }
        }
        AppMethodBeat.o(13218);
        return false;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)localException, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(13218);
        return false;
      }
    }
    Point localPoint = com.tencent.mm.plugin.mmsight.d.ex(this.context);
    Object localObject2 = g.b(localParameters, localPoint, paramInt, bool);
    if (((g.b)localObject2).oHu == null)
    {
      ab.e(this.TAG, "fuck, preview size still null!!");
      localObject2 = g.c(localParameters, new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y)), this.faG, bool);
    }
    for (;;)
    {
      if (((g.b)localObject2).oHu == null)
      {
        ab.i(this.TAG, "checkMore start %s", new Object[] { ((g.b)localObject2).toString() });
        ((g.b)localObject2).oHu = ((g.b)localObject2).oHx;
        ((g.b)localObject2).oHv = ((g.b)localObject2).oHy;
        ((g.b)localObject2).oHw = ((g.b)localObject2).oHz;
      }
      localPoint = ((g.b)localObject2).oHu;
      if (localPoint == null)
      {
        com.tencent.mm.plugin.mmsight.model.k.bRb();
        AppMethodBeat.o(13218);
        return false;
      }
      this.eZN.mnr = localPoint.x;
      this.eZN.mns = localPoint.y;
      this.fav = localPoint;
      if (((g.b)localObject2).oHv != null) {
        this.fav = ((g.b)localObject2).oHv;
      }
      ab.i(this.TAG, "final set camera preview size: " + localPoint + ", cropSize: " + this.fav);
      localParameters.setPreviewSize(localPoint.x, localPoint.y);
      localObject2 = this.eoH;
      if (localObject2 != null) {
        ((u)localObject2).setParameters(localParameters);
      }
      AppMethodBeat.o(13218);
      return true;
    }
  }
  
  private final boolean kj(int paramInt)
  {
    AppMethodBeat.i(13219);
    if ((this.eoH == null) || (this.fau == null))
    {
      ab.d(this.TAG, "maybe sth. is wrong ,camera is null");
      AppMethodBeat.o(13219);
      return false;
    }
    Object localObject1 = this.fau;
    boolean bool;
    if (localObject1 != null) {
      if ((((d.a.a)localObject1).rotate == 90) || (((d.a.a)localObject1).rotate == 270)) {
        bool = true;
      }
    }
    label287:
    label418:
    for (;;)
    {
      Point localPoint;
      try
      {
        localObject1 = this.eoH;
        if (localObject1 == null) {
          break label287;
        }
        localObject1 = ((u)localObject1).getParameters();
        localPoint = com.tencent.mm.plugin.mmsight.d.ex(this.context);
        localObject2 = g.d((Camera.Parameters)localObject1, localPoint, paramInt, bool);
        if (((g.b)localObject2).oHu != null) {
          break label418;
        }
        ab.e(this.TAG, "fuck, preview size still null!!");
        localObject2 = g.c((Camera.Parameters)localObject1, new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y)), this.faG, bool);
        if (((g.b)localObject2).oHu == null)
        {
          ab.i(this.TAG, "checkMore start %s", new Object[] { ((g.b)localObject2).toString() });
          ((g.b)localObject2).oHu = ((g.b)localObject2).oHx;
          ((g.b)localObject2).oHv = ((g.b)localObject2).oHy;
          ((g.b)localObject2).oHw = ((g.b)localObject2).oHz;
        }
        localPoint = ((g.b)localObject2).oHu;
        if (localPoint != null) {
          break label292;
        }
        com.tencent.mm.plugin.mmsight.model.k.bRb();
        AppMethodBeat.o(13219);
        return false;
      }
      catch (Exception localException)
      {
        ab.i(this.TAG, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
        AppMethodBeat.o(13219);
        return false;
      }
      bool = false;
      continue;
      Camera.Parameters localParameters = null;
      continue;
      label292:
      this.eZN.mnr = localPoint.x;
      this.eZN.mns = localPoint.y;
      if (((g.b)localObject2).oHw != null) {
        this.fav = ((g.b)localObject2).oHw;
      }
      ab.i(this.TAG, "final set camera preview size: " + localPoint + ", cropSize: " + this.fav);
      if (localParameters != null) {
        localParameters.setPreviewSize(this.eZN.mnr, this.eZN.mns);
      }
      Object localObject2 = this.eoH;
      if (localObject2 != null) {
        ((u)localObject2).setParameters(localParameters);
      }
      AppMethodBeat.o(13219);
      return true;
    }
  }
  
  public final void WW()
  {
    AppMethodBeat.i(13206);
    if (!WO())
    {
      AppMethodBeat.o(13206);
      return;
    }
    c localc = this.fat;
    c.a locala = c.fan;
    localc.removeMessages(c.WU());
    AppMethodBeat.o(13206);
  }
  
  public final b WX()
  {
    boolean bool = true;
    AppMethodBeat.i(13209);
    ab.b(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.eoH == null)
    {
      ab.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(13209);
      return null;
    }
    if (!WO())
    {
      ab.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(13209);
      return null;
    }
    b.kc(getPreviewWidth());
    b.kb(getPreviewHeight());
    Object localObject = this.fau;
    int i;
    if (localObject != null) {
      if ((((d.a.a)localObject).rotate == 90) || (((d.a.a)localObject).rotate == 270))
      {
        i = 1;
        b.ke(this.eZN.mnr);
        b.kf(this.eZN.mns);
        if (i != 0)
        {
          i = b.WQ();
          b.ke(b.WR());
          b.kf(i);
        }
        if ((this.fau == null) || (!WO())) {
          break label232;
        }
        localObject = this.fau;
        if (localObject == null) {
          break label227;
        }
        i = ((d.a.a)localObject).rotate;
        label182:
        b.kd(i);
        if (this.eZK) {
          break label237;
        }
      }
    }
    for (;;)
    {
      b.setFrontCamera(bool);
      b.cF(this.eZM);
      localObject = this.eZO;
      AppMethodBeat.o(13209);
      return localObject;
      i = 0;
      break;
      i = 0;
      break;
      label227:
      i = 0;
      break label182;
      label232:
      i = -1;
      break label182;
      label237:
      bool = false;
    }
  }
  
  public final Point WY()
  {
    AppMethodBeat.i(152122);
    if (this.fav != null)
    {
      localPoint = this.fav;
      if (localPoint == null) {
        a.f.b.j.ebi();
      }
      AppMethodBeat.o(152122);
      return localPoint;
    }
    Point localPoint = new Point(this.eZN.mnr, this.eZN.mns);
    AppMethodBeat.o(152122);
    return localPoint;
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(13199);
    super.a(paramSurfaceTexture, paramBoolean, paramInt);
    if (paramBoolean)
    {
      a(paramSurfaceTexture, null, paramInt);
      AppMethodBeat.o(13199);
      return;
    }
    b(paramSurfaceTexture, null, paramInt);
    AppMethodBeat.o(13199);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(13200);
    super.a(paramSurfaceHolder, paramBoolean, paramInt);
    if (paramBoolean)
    {
      a(null, paramSurfaceHolder, paramInt);
      AppMethodBeat.o(13200);
      return;
    }
    b(null, paramSurfaceHolder, paramInt);
    AppMethodBeat.o(13200);
  }
  
  public final void a(com.tencent.mm.plugin.mmsight.model.f paramf)
  {
    AppMethodBeat.i(13197);
    ab.b(this.TAG, "addFrameDataCallback ".concat(String.valueOf(paramf)), new Object[0]);
    if (paramf == null)
    {
      AppMethodBeat.o(13197);
      return;
    }
    synchronized (this.lock)
    {
      this.fas.add(paramf);
      AppMethodBeat.o(13197);
      return;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(13208);
    if ((this.eoH != null) && (WO())) {}
    for (;;)
    {
      int m;
      int k;
      int j;
      try
      {
        ab.d(this.TAG, "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (this.asm)
        {
          ab.d(this.TAG, "triggerSmallZoom, zooming, ignore");
          return;
        }
        Object localObject1 = this.eoH;
        if (localObject1 != null)
        {
          localObject1 = ((u)localObject1).getParameters();
          if ((localObject1 == null) || (((Camera.Parameters)localObject1).isZoomSupported() != true)) {
            continue;
          }
          this.asm = true;
          m = ((Camera.Parameters)localObject1).getZoom();
          k = ((Camera.Parameters)localObject1).getMaxZoom();
          if (!paramBoolean2)
          {
            if (this.fax <= 0)
            {
              this.fax = Math.round(k / this.fap);
              if (this.fax > this.faq) {
                this.fax = this.faq;
              }
            }
            i = this.fax;
            ab.d(this.TAG, "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(this.fax), Integer.valueOf(this.faw), Integer.valueOf(paramInt) });
            j = i;
            if (paramInt > 0) {
              j = i * paramInt;
            }
            if (!paramBoolean1) {
              continue;
            }
            if (m < k) {
              break label492;
            }
          }
        }
        else
        {
          localObject1 = null;
          continue;
        }
        if (this.faw <= 0)
        {
          ab.e(this.TAG, "scroll zoom error, scrollSmallZoomStep: %s", new Object[] { Integer.valueOf(this.faw) });
          return;
        }
        int i = this.faw;
        continue;
        ab.d(this.TAG, "triggerSmallZoom, nextZoom: %s, smoothZoomSupported: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(((Camera.Parameters)localObject1).isSmoothZoomSupported()) });
        ((Camera.Parameters)localObject1).setZoom(paramInt);
        u localu = this.eoH;
        if (localu != null) {
          localu.setParameters((Camera.Parameters)localObject1);
        }
        return;
        if (m == 0) {
          return;
        }
        i = m - j;
        paramInt = i;
        if (i > 0) {
          continue;
        }
        paramInt = 0;
        continue;
        AppMethodBeat.o(13208);
      }
      catch (Exception localException)
      {
        ab.e(this.TAG, "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.asm = false;
        AppMethodBeat.o(13208);
      }
      return;
      label492:
      do
      {
        break;
        paramInt = j + m;
      } while (paramInt < k);
      paramInt = k;
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13205);
    if (!WO())
    {
      AppMethodBeat.o(13205);
      return;
    }
    if (com.tencent.mm.compatible.util.d.fw(14))
    {
      AppMethodBeat.o(13205);
      return;
    }
    c localc = this.fat;
    Object localObject = c.fan;
    localc.removeMessages(c.WU());
    this.fat.fac = paramFloat1;
    this.fat.fad = paramFloat2;
    this.fat.fae = paramInt1;
    this.fat.faf = paramInt2;
    localc = this.fat;
    localObject = this.fat;
    c.a locala = c.fan;
    localc.sendMessageDelayed(((c)localObject).obtainMessage(c.WU(), this.eoH), 400L);
    AppMethodBeat.o(13205);
  }
  
  public final void b(com.tencent.mm.plugin.mmsight.model.f paramf)
  {
    AppMethodBeat.i(13198);
    ab.b(this.TAG, "removeFrameDataCallback ".concat(String.valueOf(paramf)), new Object[0]);
    if (paramf == null)
    {
      AppMethodBeat.o(13198);
      return;
    }
    synchronized (this.lock)
    {
      this.fas.remove(paramf);
      AppMethodBeat.o(13198);
      return;
    }
  }
  
  public final void kh(int paramInt)
  {
    AppMethodBeat.i(13207);
    if (this.faw > 0)
    {
      AppMethodBeat.o(13207);
      return;
    }
    Object localObject = af.hQ(ah.getContext());
    int i = ((Point)localObject).y;
    ab.i(this.TAG, "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localObject });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(13207);
      return;
    }
    try
    {
      if (this.eoH != null)
      {
        localObject = this.eoH;
        if (localObject != null)
        {
          localObject = ((u)localObject).getParameters();
          if (localObject == null) {
            break label187;
          }
        }
        label187:
        for (i = ((Camera.Parameters)localObject).getMaxZoom();; i = 0)
        {
          double d = i / (paramInt / 3.0D / 10.0D);
          if (d > 0.0D) {
            this.faw = ((int)d + 1);
          }
          ab.i(this.TAG, "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.faw), Integer.valueOf(i) });
          AppMethodBeat.o(13207);
          return;
          localObject = null;
          break;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e(this.TAG, "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(13207);
    }
  }
  
  public final boolean p(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(13196);
    a.f.b.j.q(paramContext, "context");
    for (;;)
    {
      try
      {
        if (this.faF)
        {
          ab.i(this.TAG, "initCamera, already open");
          AppMethodBeat.o(13196);
          return true;
        }
        Object localObject = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Vq();
        super.p(paramContext, paramBoolean);
        release();
        if (paramBoolean)
        {
          i = com.tencent.mm.compatible.e.d.Lj();
          ab.b(this.TAG, "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(i), Integer.valueOf(ac.eru.eos) });
          this.fau = new f().a(paramContext, i, Looper.getMainLooper());
          ab.i(this.TAG, "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.fau == null)
          {
            ab.i(this.TAG, "open camera FAILED, %s", new Object[] { Looper.myLooper() });
            WM();
            AppMethodBeat.o(13196);
            return false;
          }
        }
        else
        {
          i = com.tencent.mm.compatible.e.d.Lk();
          continue;
        }
        paramContext = this.fau;
        if (paramContext != null)
        {
          paramContext = paramContext.eoH;
          this.eoH = paramContext;
          this.fat.fab = false;
          paramContext = this.eZN;
          localObject = this.fau;
          if (localObject == null) {
            break label317;
          }
          i = ((d.a.a)localObject).rotate;
          paramContext.rotate = i;
          if (this.eoH == null)
          {
            ab.e(this.TAG, "start camera FAILED!");
            WM();
            AppMethodBeat.o(13196);
            return false;
          }
          this.faF = true;
          AppMethodBeat.o(13196);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)paramContext, "init camera failed!", new Object[0]);
        paramContext = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Vs();
        AppMethodBeat.o(13196);
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
    AppMethodBeat.i(13221);
    super.release();
    try
    {
      ab.i(this.TAG, this.fay.getValue());
      ab.i(this.TAG, this.faz.getValue());
      ab.i(this.TAG, this.faA.getValue());
      ab.i(this.TAG, this.faB.getValue());
      ab.i(this.TAG, this.faC.getValue());
      if (this.eoH != null)
      {
        long l = bo.yB();
        ab.i(this.TAG, "release camera beg, %s", new Object[] { Looper.myLooper() });
        this.fat.removeCallbacksAndMessages(null);
        this.fat.fab = true;
        u localu = this.eoH;
        if (localu != null) {
          localu.setPreviewCallback(null);
        }
        localu = this.eoH;
        if (localu != null) {
          localu.stopPreview();
        }
        localu = this.eoH;
        if (localu != null) {
          localu.release();
        }
        this.eoH = null;
        ab.i(this.TAG, "release camera end, use %dms, %s", new Object[] { Long.valueOf(bo.av(l)), Looper.myLooper() });
      }
      this.fat.eZZ = false;
      this.fat.fag = true;
      this.fav = null;
      this.faE = null;
      this.faF = false;
      AppMethodBeat.o(13221);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "cameraRelease error", new Object[0]);
      AppMethodBeat.o(13221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.d
 * JD-Core Version:    0.7.0.1
 */