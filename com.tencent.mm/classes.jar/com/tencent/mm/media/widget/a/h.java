package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Looper;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.media.util.f;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.d;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.e;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera/VoipCommonCamera1;", "Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/content/Context;II)V", "TAG", "", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "supportPreviewSizes", "", "Landroid/hardware/Camera$Size;", "Landroid/hardware/Camera;", "screenResolution", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraResolution", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "w", "h", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "", "getPreviewWidth", "postFocusOnTouch", "", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "removeFocusOnTouch", "safeSetFocusMode", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "safeSetPreviewFormat", "selectPreviewSize", "setPreviewCallbackImplInGPUCrop", "setSafeConfig", "startPreviewWithGPU", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "resolutionLimit", "translateFocusMode", "focusMode", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "tryPreviewSize", "trySetPreviewFpsRangeParameters", "p", "Landroid/hardware/Camera$Parameters;", "mCameraFps", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends d
{
  private final String TAG;
  private int height;
  private int width;
  
  public h(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(237601);
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.VoipCommonCamera1";
    AppMethodBeat.o(237601);
  }
  
  private static String GW(String paramString)
  {
    AppMethodBeat.i(237615);
    s.u(paramString, "focusMode");
    b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
    if (s.p(paramString, b.b.but()))
    {
      AppMethodBeat.o(237615);
      return "auto";
    }
    localb = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
    if (s.p(paramString, b.b.bur()))
    {
      AppMethodBeat.o(237615);
      return "continuous-video";
    }
    localb = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
    if (s.p(paramString, b.b.bus()))
    {
      AppMethodBeat.o(237615);
      return "continuous-picture";
    }
    AppMethodBeat.o(237615);
    return "";
  }
  
  private final Point a(List<? extends Camera.Size> paramList, Point paramPoint)
  {
    AppMethodBeat.i(237604);
    paramList = paramList.iterator();
    int k = 2147483647;
    int j = 0;
    int i = 0;
    Camera.Size localSize;
    if (paramList.hasNext()) {
      localSize = (Camera.Size)paramList.next();
    }
    for (;;)
    {
      int i1;
      try
      {
        m = localSize.width;
        n = localSize.height;
        i1 = Math.abs(m - paramPoint.x) + Math.abs(n - paramPoint.y);
        if (i1 != 0) {
          break label131;
        }
        if ((m <= 0) || (n <= 0)) {
          break label159;
        }
        paramList = new Point(m, n);
        AppMethodBeat.o(237604);
        return paramList;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.w(this.TAG, s.X("Bad preview-size: ", localSize));
      }
      break;
      label131:
      if ((i1 >= k) || (m == n)) {
        break;
      }
      k = i1;
      j = n;
      i = m;
      break;
      label159:
      AppMethodBeat.o(237604);
      return null;
      int n = j;
      int m = i;
    }
  }
  
  private static final void a(h paramh, byte[] paramArrayOfByte, Camera paramCamera)
  {
    boolean bool = false;
    AppMethodBeat.i(237617);
    s.u(paramh, "this$0");
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length != 0) {
        break label44;
      }
    }
    label44:
    for (int i = 1; i != 0; i = 0)
    {
      Log.e(paramh.TAG, "onPreviewFrame, frame data is null!!");
      AppMethodBeat.o(237617);
      return;
    }
    if ((!paramh.bsZ()) && (paramh.bsR().size() > 0))
    {
      paramCamera = paramh.bsu();
      if (paramCamera != null)
      {
        paramCamera = paramCamera.nKT;
        if (paramCamera != null)
        {
          b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
          paramCamera = Boolean.valueOf(paramCamera.contains(b.b.buv()));
          if (paramCamera.booleanValue()) {
            break label228;
          }
          i = 1;
          if (i == 0) {
            break label233;
          }
        }
      }
    }
    for (;;)
    {
      if (paramCamera != null)
      {
        paramCamera.booleanValue();
        if (!paramh.bsp())
        {
          i = paramh.bss().zWH;
          int j = paramh.bss().zWI;
          paramCamera = paramh.bsT();
          s.checkNotNull(paramCamera);
          if (paramCamera.hYK != 270)
          {
            paramCamera = paramh.bsT();
            s.checkNotNull(paramCamera);
            if (paramCamera.hYK != 90) {}
          }
          else
          {
            bool = true;
          }
          SightVideoJNI.mirrorCameraData(paramArrayOfByte, i, j, bool);
        }
      }
      paramh.ar(paramArrayOfByte);
      paramh.aq(paramArrayOfByte);
      paramh = paramh.bsS();
      s.checkNotNull(paramh);
      paramh.aj(paramArrayOfByte);
      AppMethodBeat.o(237617);
      return;
      label228:
      i = 0;
      break;
      label233:
      paramCamera = null;
    }
  }
  
  private boolean bti()
  {
    AppMethodBeat.i(237611);
    for (;;)
    {
      try
      {
        i = this.width;
        int j = this.height;
        localObject1 = bsS();
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject2 = new Point(i, j);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          if (localObject1 == null) {
            break label667;
          }
          Log.i(this.TAG, s.X("preview-size-values parameter: ", localObject1));
          localObject1 = a((List)localObject1, (Point)localObject2);
          if (localObject1 != null) {
            break label664;
          }
          localObject1 = new Point(((Point)localObject2).x >> 3 << 3, ((Point)localObject2).y >> 3 << 3);
          localObject1 = new ad(((Point)localObject1).x, ((Point)localObject1).y);
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        Integer localInteger;
        boolean bool;
        localObject1 = null;
        Log.e(this.TAG, "getCameraResolution failed: %s", new Object[] { localException1.getMessage() });
        continue;
        int i = 0;
        continue;
        Object localObject3 = null;
        continue;
        AppMethodBeat.o(237611);
        return true;
      }
      try
      {
        Log.i(this.TAG, "getCameraResolution:" + Integer.valueOf(((ad)localObject1).width) + ',' + Integer.valueOf(((ad)localObject1).height));
        localObject2 = bsu();
        if (localObject2 == null) {
          break label519;
        }
        localObject2 = ((b.a)localObject2).nKP;
        if (localObject2 == null) {
          break label519;
        }
        localObject2 = (b.a.e)((HashMap)localObject2).get(Integer.valueOf(btf()));
        if (localObject2 == null) {
          break label519;
        }
        if ((((b.a.e)localObject2).nLa == null) || (((b.a.e)localObject2).nLb == null)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        if (localObject2 == null) {
          break label519;
        }
        localInteger = ((b.a.e)localObject2).nLa;
        s.checkNotNull(localInteger);
        i = localInteger.intValue();
        localInteger = ((b.a.e)localObject2).nLb;
        s.checkNotNull(localInteger);
        bool = ex(i, localInteger.intValue());
        Log.i(this.TAG, "1.try config size first! w" + ((b.a.e)localObject2).nLa + ",h" + ((b.a.e)localObject2).nLb);
        if ((bool) || (localObject1 == null)) {
          continue;
        }
        Log.e(this.TAG, "1.try config size failed!,try support size: w" + ((ad)localObject1).width + ",h" + ((ad)localObject1).height);
        if (ex(((ad)localObject1).width, ((ad)localObject1).height)) {
          continue;
        }
        Log.e(this.TAG, "1.try support size fail: w" + ((ad)localObject1).width + ",h" + ((ad)localObject1).height);
        AppMethodBeat.o(237611);
        return false;
      }
      catch (Exception localException2)
      {
        continue;
      }
      Object localObject1 = ((w)localObject1).aPy();
      continue;
      localObject1 = ((Camera.Parameters)localObject1).getSupportedPreviewSizes();
      continue;
      label519:
      Log.i(this.TAG, "2.no config size!");
      if (localObject1 != null)
      {
        Log.i(this.TAG, "2.try support size alternatively! w" + ((ad)localObject1).width + ",h" + ((ad)localObject1).height);
        if (!ex(((ad)localObject1).width, ((ad)localObject1).height))
        {
          Log.e(this.TAG, "2.try support size fail: w" + ((ad)localObject1).width + ",h" + ((ad)localObject1).height);
          AppMethodBeat.o(237611);
          return false;
        }
        AppMethodBeat.o(237611);
        return true;
      }
      AppMethodBeat.o(237611);
      return false;
      label664:
      continue;
      label667:
      localObject1 = null;
    }
  }
  
  private final boolean ex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237606);
    if ((bsS() == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(237606);
      return false;
    }
    try
    {
      Object localObject = bsS();
      if (localObject == null) {}
      for (localObject = null;; localObject = ((w)localObject).aPy())
      {
        if ((paramInt1 > 0) && (paramInt2 > 0) && (localObject != null)) {
          ((Camera.Parameters)localObject).setPreviewSize(paramInt1, paramInt2);
        }
        w localw = bsS();
        if (localw != null) {
          localw.c((Camera.Parameters)localObject);
        }
        bss().zWH = paramInt1;
        bss().zWI = paramInt2;
        d(new Point(paramInt1, paramInt2));
        AppMethodBeat.o(237606);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, s.X("TryPreviewSize fail:", localException));
      AppMethodBeat.o(237606);
    }
  }
  
  protected final void a(Camera.Parameters paramParameters, int paramInt)
  {
    AppMethodBeat.i(237645);
    s.u(paramParameters, "p");
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(237645);
      return;
    }
    int j = -2147483648;
    int i = -2147483648;
    int i2 = localList.size();
    int k = i;
    paramInt = j;
    int m;
    Object localObject;
    if (i2 > 0)
    {
      k = 0;
      paramInt = 2147483647;
      m = k + 1;
      localObject = (int[])localList.get(k);
      if ((localObject != null) && (localObject.length > 1)) {
        break label178;
      }
    }
    label257:
    label404:
    label414:
    label549:
    label680:
    for (;;)
    {
      if (m >= i2)
      {
        paramInt = j;
        k = i;
        Log.i(bsm(), "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(30) });
        if ((paramInt == 2147483647) || (k == 2147483647))
        {
          AppMethodBeat.o(237645);
          return;
          label178:
          int n = localObject[0];
          int i1 = localObject[1];
          Log.i(this.TAG, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(i1) });
          if ((n >= 0) && (i1 < n)) {
            continue;
          }
          localObject = bsu();
          int i3;
          int i4;
          Integer localInteger;
          if (localObject == null)
          {
            localObject = null;
            if (localObject == null) {
              break label680;
            }
            localObject = bsu();
            if (localObject == null) {
              break label680;
            }
            localObject = ((b.a)localObject).nKR;
            if (localObject == null) {
              break label680;
            }
            localObject = (b.a.c)((HashMap)localObject).get(Integer.valueOf(btf()));
            if (localObject == null) {
              break label680;
            }
            i3 = i1 / 1000;
            i4 = n / 1000;
            localInteger = ((b.a.c)localObject).nKV;
            if (localInteger != null) {
              break label529;
            }
            k = 0;
            label338:
            if (i3 < k) {
              break label569;
            }
            localInteger = ((b.a.c)localObject).nKW;
            if (localInteger != null) {
              break label539;
            }
            k = 0;
            label360:
            if (i3 > k) {
              break label569;
            }
            localInteger = ((b.a.c)localObject).nKV;
            if (localInteger != null) {
              break label549;
            }
            k = 0;
            label382:
            if (i4 < k) {
              break label569;
            }
            localInteger = ((b.a.c)localObject).nKW;
            if (localInteger != null) {
              break label559;
            }
            k = 0;
            if (i4 > k) {
              break label569;
            }
            k = 1;
            if (k == 0) {
              break label680;
            }
            localInteger = ((b.a.c)localObject).nKX;
            if (localInteger != null) {
              break label575;
            }
            k = 0;
            label434:
            i4 = Math.abs(k - i4);
            localObject = ((b.a.c)localObject).nKX;
            if (localObject != null) {
              break label585;
            }
          }
          label559:
          label569:
          label575:
          label585:
          for (k = 0;; k = ((Integer)localObject).intValue())
          {
            k = Math.abs(i3 - k) + i4;
            if (k >= paramInt) {
              break label680;
            }
            i = i1;
            j = n;
            paramInt = k;
            break;
            localObject = ((b.a)localObject).nKR;
            if (localObject == null)
            {
              localObject = null;
              break label257;
            }
            localObject = (b.a.c)((HashMap)localObject).get(Integer.valueOf(btf()));
            break label257;
            k = localInteger.intValue();
            break label338;
            k = localInteger.intValue();
            break label360;
            k = localInteger.intValue();
            break label382;
            k = localInteger.intValue();
            break label404;
            k = 0;
            break label414;
            k = localInteger.intValue();
            break label434;
          }
        }
        try
        {
          paramParameters.setPreviewFpsRange(paramInt, k);
          Log.i(bsm(), "set fps range %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k) });
          AppMethodBeat.o(237645);
          return;
        }
        catch (Exception paramParameters)
        {
          Log.i(bsm(), "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
          AppMethodBeat.o(237645);
          return;
        }
      }
      k = m;
      break;
    }
  }
  
  protected final boolean a(w paramw)
  {
    AppMethodBeat.i(237650);
    if (paramw == null)
    {
      AppMethodBeat.o(237650);
      return false;
    }
    Camera.Parameters localParameters;
    try
    {
      localParameters = paramw.aPy();
      List localList = localParameters.getSupportedFocusModes();
      Object localObject = bsu();
      if (localObject != null)
      {
        localObject = ((b.a)localObject).nKQ;
        if (localObject != null)
        {
          localObject = (b.a.b)((HashMap)localObject).get(Integer.valueOf(btf()));
          if (localObject != null)
          {
            localObject = ((b.a.b)localObject).nKU;
            if (localObject != null)
            {
              Iterator localIterator = ((Iterable)localObject).iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                if ((localList != null) && (localList.contains(GW(str))))
                {
                  Log.i(this.TAG, s.X("support ", str));
                  localParameters.setFocusMode(GW(str));
                  bso().nGP = localParameters.getFocusMode();
                  paramw.c(localParameters);
                  AppMethodBeat.o(237650);
                  return true;
                }
                localObject = bsu();
                if (localObject == null) {
                  localObject = null;
                }
                while (s.p(localObject, str))
                {
                  Log.e(this.TAG, "all of the focus-mode are not supported yet");
                  AppMethodBeat.o(237650);
                  return false;
                  localObject = ((b.a)localObject).nKQ;
                  if (localObject == null)
                  {
                    localObject = null;
                  }
                  else
                  {
                    localObject = (b.a.b)((HashMap)localObject).get(Integer.valueOf(btf()));
                    if (localObject == null)
                    {
                      localObject = null;
                    }
                    else
                    {
                      localObject = ((b.a.b)localObject).nKU;
                      if (localObject == null) {
                        localObject = null;
                      } else {
                        localObject = (String)kotlin.a.p.oM((List)localObject);
                      }
                    }
                  }
                }
                Log.e(this.TAG, s.X("not support ", str));
              }
            }
          }
        }
      }
      bso().nGP = localParameters.getFocusMode();
    }
    catch (Exception paramw)
    {
      Log.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
      AppMethodBeat.o(237650);
      return false;
    }
    paramw.c(localParameters);
    AppMethodBeat.o(237650);
    return true;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  protected final void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(237623);
    long l = Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (bsD())
    {
      Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(237623);
      return;
    }
    try
    {
      bti();
      bta();
      bte();
      if (a(paramSurfaceTexture, paramSurfaceHolder)) {
        a(a.a.nGg);
      }
      Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(237623);
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
  
  public final boolean b(w paramw)
  {
    AppMethodBeat.i(237653);
    if (paramw == null)
    {
      AppMethodBeat.o(237653);
      return false;
    }
    Object localObject = bsu();
    if (localObject != null)
    {
      localObject = ((b.a)localObject).nKS;
      if (localObject != null)
      {
        localObject = (b.a.d)((HashMap)localObject).get(Integer.valueOf(btf()));
        if (localObject != null)
        {
          localObject = ((b.a.d)localObject).nKZ;
          if (localObject == null) {}
        }
      }
    }
    for (int i = ((Number)localObject).intValue();; i = 17) {
      try
      {
        Log.i(this.TAG, "safeSetPreviewFormat");
        localObject = paramw.aPy();
        List localList = ((Camera.Parameters)localObject).getSupportedPreviewFormats();
        if ((localList == null) || (!localList.contains(Integer.valueOf(i)))) {
          Log.e(this.TAG, s.X("not support ", Integer.valueOf(i)));
        }
        ((Camera.Parameters)localObject).setPreviewFormat(i);
        paramw.c((Camera.Parameters)localObject);
        AppMethodBeat.o(237653);
        return true;
      }
      catch (Exception paramw)
      {
        Log.i(this.TAG, "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
        AppMethodBeat.o(237653);
        return false;
      }
    }
  }
  
  public final void bta()
  {
    AppMethodBeat.i(237626);
    Object localObject1 = bsu();
    Object localObject2;
    int i;
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((b.a)localObject1).nKR;
      if (localObject1 != null)
      {
        localObject2 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(btf()));
        if (localObject2 != null) {
          break label127;
        }
        i = 15;
        ur(i);
        localObject2 = bsS();
        localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(btf()));
        if (localObject1 != null) {
          break label154;
        }
        bool = false;
      }
    }
    for (;;)
    {
      a((w)localObject2, bool);
      b(bsS());
      c(bsS());
      a(bsS());
      bsS();
      AppMethodBeat.o(237626);
      return;
      label127:
      localObject2 = ((b.a.c)localObject2).nKX;
      if (localObject2 == null)
      {
        i = 15;
        break;
      }
      i = ((Integer)localObject2).intValue();
      break;
      label154:
      localObject1 = ((b.a.c)localObject1).nKY;
      if (localObject1 == null) {
        bool = false;
      } else {
        bool = ((Boolean)localObject1).booleanValue();
      }
    }
  }
  
  public final void btb() {}
  
  public final b btc()
  {
    boolean bool = true;
    AppMethodBeat.i(237635);
    Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
    if (bsS() == null)
    {
      Log.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(237635);
      return null;
    }
    if (!bsD())
    {
      Log.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(237635);
      return null;
    }
    bst();
    b.uk(getPreviewWidth());
    bst();
    b.uj(getPreviewHeight());
    Object localObject = bsT();
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
      AppMethodBeat.o(237635);
      return localObject;
      i = 0;
      break;
      label252:
      bool = false;
    }
  }
  
  public final void bte()
  {
    AppMethodBeat.i(237625);
    Object localObject1 = bsu();
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 != null) && (!s.p(localObject1, Boolean.FALSE))) {
        break label273;
      }
      i = 1;
      label38:
      if (i == 0) {
        break label278;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        break label308;
      }
      ((Boolean)localObject1).booleanValue();
      if (bsS() == null) {
        break label308;
      }
      try
      {
        localObject1 = bsS();
        s.checkNotNull(localObject1);
        localObject1 = ((w)localObject1).aPy();
        Log.i(this.TAG, "setPreviewCallbackImpl");
        i = bss().zWH;
        int j = bss().zWI;
        s.checkNotNull(localObject1);
        int k = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject1).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        do
        {
          j = i + 1;
          localObject1 = j.KXq.m(Integer.valueOf(k));
          localObject2 = bsS();
          s.checkNotNull(localObject2);
          ((w)localObject2).aj((byte[])localObject1);
          i = j;
        } while (j < 5);
        bsU().reset();
        bsV().reset();
        bsW().reset();
        bsX().reset();
        bsY().reset();
        localObject1 = bsS();
        s.checkNotNull(localObject1);
        ((w)localObject1).b(new h..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(237625);
        return;
      }
      catch (Exception localException)
      {
        Object localObject2;
        Log.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      }
      localObject1 = ((b.a)localObject1).nKT;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject2 = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
      localObject1 = Boolean.valueOf(((HashSet)localObject1).contains(b.b.buu()));
      break;
      label273:
      i = 0;
      break label38;
      label278:
      localObject1 = null;
    }
    label308:
    AppMethodBeat.o(237625);
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(237637);
    Object localObject = bss();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.p)localObject).zWI))
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(237637);
      return i;
    }
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(237638);
    Object localObject = bss();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.p)localObject).zWH))
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(237638);
      return i;
    }
  }
  
  public final Point gx(boolean paramBoolean)
  {
    Object localObject1 = null;
    AppMethodBeat.i(237641);
    Object localObject2 = bsS();
    if (localObject2 == null) {}
    for (;;)
    {
      if (localObject1 != null) {
        Log.i(this.TAG, "size is " + ((Camera.Size)localObject1).width + " and " + ((Camera.Size)localObject1).height + " and " + bss().zWH + " and " + bss().zWI + ' ');
      }
      localObject1 = new Point(bss().zWH, bss().zWI);
      AppMethodBeat.o(237641);
      return localObject1;
      localObject2 = ((w)localObject2).aPy();
      if (localObject2 != null) {
        localObject1 = ((Camera.Parameters)localObject2).getPreviewSize();
      }
    }
  }
  
  public final void h(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.h
 * JD-Core Version:    0.7.0.1
 */