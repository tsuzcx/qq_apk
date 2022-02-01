package com.tencent.mm.media.widget.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.media.ImageReader;
import android.os.Looper;
import android.util.Range;
import android.util.Size;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.a.a.a;
import com.tencent.mm.media.widget.a.a.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.e;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/VoipCommonCamera2;", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/content/Context;II)V", "TAG", "", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "supportPreviewSizes", "", "Landroid/util/Size;", "screenResolution", "([Landroid/util/Size;Landroid/graphics/Point;)Landroid/graphics/Point;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraResolution", "w", "h", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "", "getPreviewWidth", "postFocusOnTouch", "", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "removeFocusOnTouch", "safeSetFocusMode", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "selectPreviewSize", "setSafeConfig", "startPreviewWithGPU", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "resolutionLimit", "translateFocusMode", "focusMode", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "tryPreviewSize", "trySetPreviewFpsRangeParameters", "mCameraFps", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends d
{
  private final String TAG;
  private int height;
  private int width;
  
  public f(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(237535);
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.VoipCommonCamera2";
    AppMethodBeat.o(237535);
  }
  
  private static int GX(String paramString)
  {
    AppMethodBeat.i(237558);
    s.u(paramString, "focusMode");
    b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
    if (!s.p(paramString, b.b.but()))
    {
      localb = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
      if (s.p(paramString, b.b.bur()))
      {
        AppMethodBeat.o(237558);
        return 3;
      }
      localb = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
      if (s.p(paramString, b.b.bus()))
      {
        AppMethodBeat.o(237558);
        return 4;
      }
    }
    AppMethodBeat.o(237558);
    return 1;
  }
  
  private final Point a(Size[] paramArrayOfSize, Point paramPoint)
  {
    AppMethodBeat.i(237541);
    int i4 = paramArrayOfSize.length;
    int k = 0;
    int m = 2147483647;
    int i = 0;
    int j = 0;
    Size localSize;
    int i2;
    if (k < i4)
    {
      localSize = paramArrayOfSize[k];
      i2 = k + 1;
    }
    for (;;)
    {
      int i1;
      int i3;
      try
      {
        n = localSize.getWidth();
        i1 = localSize.getHeight();
        i3 = Math.abs(n - paramPoint.x) + Math.abs(i1 - paramPoint.y);
        if (i3 != 0) {
          break label135;
        }
        i = i1;
        if ((n <= 0) || (i <= 0)) {
          break label175;
        }
        paramArrayOfSize = new Point(n, i);
        AppMethodBeat.o(237541);
        return paramArrayOfSize;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.w(this.TAG, s.X("Bad preview-size: ", localSize));
        k = i2;
      }
      break;
      label135:
      k = i2;
      if (i3 >= m) {
        break;
      }
      k = i2;
      if (n == i1) {
        break;
      }
      m = i3;
      i = i1;
      j = n;
      k = i2;
      break;
      label175:
      AppMethodBeat.o(237541);
      return null;
      int n = j;
    }
  }
  
  private boolean bti()
  {
    AppMethodBeat.i(237555);
    for (;;)
    {
      try
      {
        Object localObject2 = new Point(this.width, this.height);
        localObject1 = c.nGZ;
        localObject1 = c.bts();
        if (localObject1 == null) {
          break label589;
        }
        Log.i(this.TAG, s.X("preview-size-values parameter: ", localObject1));
        localObject1 = a((Size[])localObject1, (Point)localObject2);
        if (localObject1 != null) {
          break label586;
        }
        localObject1 = new Point(((Point)localObject2).x >> 3 << 3, ((Point)localObject2).y >> 3 << 3);
        localObject1 = new Size(((Point)localObject1).x, ((Point)localObject1).y);
        int i;
        Integer localInteger;
        boolean bool;
        Object localObject3;
        Log.i(this.TAG, "2.no config size!");
      }
      catch (Exception localException1)
      {
        try
        {
          Log.i(this.TAG, "getCameraResolution:" + Integer.valueOf(((Size)localObject1).getWidth()) + ',' + Integer.valueOf(((Size)localObject1).getHeight()));
          localObject2 = bsu();
          if (localObject2 == null) {
            break label453;
          }
          localObject2 = ((b.a)localObject2).nKP;
          if (localObject2 == null) {
            break label453;
          }
          localObject2 = (b.a.e)((HashMap)localObject2).get(Integer.valueOf(btf()));
          if (localObject2 == null) {
            break label453;
          }
          if ((((b.a.e)localObject2).nLa == null) || (((b.a.e)localObject2).nLb == null)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          if (localObject2 == null) {
            break label453;
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
          Log.e(this.TAG, "1.try config size failed!,try support size: w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
          if (ex(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight())) {
            continue;
          }
          Log.e(this.TAG, "1.try support size fail: w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
          AppMethodBeat.o(237555);
          return false;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        localObject1 = null;
        Log.e(this.TAG, "getCameraResolution failed: %s", new Object[] { localException1.getMessage() });
        continue;
        i = 0;
        continue;
        localObject3 = null;
        continue;
        AppMethodBeat.o(237555);
        return true;
      }
      label453:
      if (localObject1 != null)
      {
        Log.i(this.TAG, "2.try support size alternatively! w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
        if (!ex(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight()))
        {
          Log.e(this.TAG, "2.try support size fail: w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
          AppMethodBeat.o(237555);
          return false;
        }
        AppMethodBeat.o(237555);
        return true;
      }
      AppMethodBeat.o(237555);
      return false;
      label586:
      continue;
      label589:
      Object localObject1 = null;
    }
  }
  
  private final boolean ex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237545);
    if ((getSurfaceTexture() == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(237545);
      return false;
    }
    try
    {
      Object localObject = getSurfaceTexture();
      if (localObject != null) {
        ((SurfaceTexture)localObject).setDefaultBufferSize(paramInt1, paramInt2);
      }
      bss().zWH = paramInt1;
      bss().zWI = paramInt2;
      localObject = new Size(paramInt1, paramInt2);
      paramInt1 = ((Size)localObject).getWidth();
      paramInt2 = ((Size)localObject).getHeight();
      localObject = c.nGZ;
      localObject = ImageReader.newInstance(paramInt1, paramInt2, c.bto(), 1);
      ((ImageReader)localObject).setOnImageAvailableListener(bso().nGQ, bso().nGI);
      ah localah = ah.aiuX;
      a((ImageReader)localObject);
      AppMethodBeat.o(237545);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, s.X("TryPreviewSize fail:", localException));
      AppMethodBeat.o(237545);
    }
    return false;
  }
  
  protected final void a(CameraCharacteristics paramCameraCharacteristics, int paramInt)
  {
    AppMethodBeat.i(237593);
    Range[] arrayOfRange;
    if (paramCameraCharacteristics == null)
    {
      arrayOfRange = null;
      if (arrayOfRange != null) {
        if (arrayOfRange.length != 0) {
          break label52;
        }
      }
    }
    label52:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label57;
      }
      AppMethodBeat.o(237593);
      return;
      arrayOfRange = (Range[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
      break;
    }
    label57:
    if (arrayOfRange.length == 0) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(237593);
      return;
    }
    int j = -2147483648;
    int i = -2147483648;
    int n = arrayOfRange.length;
    paramInt = j;
    int k;
    int m;
    Integer localInteger1;
    Integer localInteger2;
    if (n > 0)
    {
      k = 0;
      i = 2147483647;
      paramInt = -2147483648;
      m = k + 1;
      paramCameraCharacteristics = arrayOfRange[k];
      if (paramCameraCharacteristics == null) {
        break label734;
      }
      localInteger1 = (Integer)paramCameraCharacteristics.getLower();
      localInteger2 = (Integer)paramCameraCharacteristics.getUpper();
      Log.i(this.TAG, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(k), localInteger1, localInteger2 });
      s.s(localInteger1, "min");
      if (localInteger1.intValue() >= 0)
      {
        s.s(localInteger2, "max");
        if (localInteger2.intValue() >= localInteger1.intValue()) {
          break label283;
        }
      }
    }
    label283:
    label294:
    label434:
    label444:
    label463:
    label595:
    label601:
    label734:
    for (;;)
    {
      if (m >= n)
      {
        i = paramInt;
        paramInt = j;
        Log.i(bsm(), "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(30) });
        if ((paramInt == 2147483647) || (i == 2147483647))
        {
          AppMethodBeat.o(237593);
          return;
          paramCameraCharacteristics = bsu();
          int i1;
          int i2;
          Integer localInteger3;
          if (paramCameraCharacteristics == null)
          {
            paramCameraCharacteristics = null;
            if (paramCameraCharacteristics == null) {
              break label734;
            }
            paramCameraCharacteristics = bsu();
            if (paramCameraCharacteristics == null) {
              break label734;
            }
            paramCameraCharacteristics = paramCameraCharacteristics.nKR;
            if (paramCameraCharacteristics == null) {
              break label734;
            }
            paramCameraCharacteristics = (b.a.c)paramCameraCharacteristics.get(Integer.valueOf(btf()));
            if (paramCameraCharacteristics == null) {
              break label734;
            }
            i1 = localInteger2.intValue() / 1000;
            i2 = localInteger1.intValue() / 1000;
            localInteger3 = paramCameraCharacteristics.nKV;
            if (localInteger3 != null) {
              break label555;
            }
            k = 0;
            label371:
            if (i1 < k) {
              break label595;
            }
            localInteger3 = paramCameraCharacteristics.nKW;
            if (localInteger3 != null) {
              break label565;
            }
            k = 0;
            if (i1 > k) {
              break label595;
            }
            localInteger3 = paramCameraCharacteristics.nKV;
            if (localInteger3 != null) {
              break label575;
            }
            k = 0;
            if (i2 < k) {
              break label595;
            }
            localInteger3 = paramCameraCharacteristics.nKW;
            if (localInteger3 != null) {
              break label585;
            }
            k = 0;
            if (i2 > k) {
              break label595;
            }
            k = 1;
            if (k == 0) {
              break label734;
            }
            localInteger3 = paramCameraCharacteristics.nKX;
            if (localInteger3 != null) {
              break label601;
            }
            k = 0;
            i2 = Math.abs(k - i2);
            paramCameraCharacteristics = paramCameraCharacteristics.nKX;
            if (paramCameraCharacteristics != null) {
              break label611;
            }
          }
          label611:
          for (k = 0;; k = paramCameraCharacteristics.intValue())
          {
            k = Math.abs(i1 - k) + i2;
            if (k >= i) {
              break label734;
            }
            j = localInteger1.intValue();
            paramInt = localInteger2.intValue();
            i = k;
            break;
            paramCameraCharacteristics = paramCameraCharacteristics.nKR;
            if (paramCameraCharacteristics == null)
            {
              paramCameraCharacteristics = null;
              break label294;
            }
            paramCameraCharacteristics = (b.a.c)paramCameraCharacteristics.get(Integer.valueOf(btf()));
            break label294;
            k = localInteger3.intValue();
            break label371;
            k = localInteger3.intValue();
            break label392;
            k = localInteger3.intValue();
            break label413;
            k = localInteger3.intValue();
            break label434;
            k = 0;
            break label444;
            k = localInteger3.intValue();
            break label463;
          }
        }
        try
        {
          paramCameraCharacteristics = this.nHA;
          if (paramCameraCharacteristics != null) {
            paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range((Comparable)Integer.valueOf(paramInt), (Comparable)Integer.valueOf(i)));
          }
          Log.i(bsm(), "set fps range %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
          AppMethodBeat.o(237593);
          return;
        }
        catch (Exception paramCameraCharacteristics)
        {
          Log.i(bsm(), "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
          AppMethodBeat.o(237593);
          return;
        }
      }
      k = m;
      break;
    }
  }
  
  protected final boolean a(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(237596);
    if (paramCameraCharacteristics == null)
    {
      AppMethodBeat.o(237596);
      return false;
    }
    try
    {
      int[] arrayOfInt = (int[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
      paramCameraCharacteristics = bsu();
      if (paramCameraCharacteristics != null)
      {
        paramCameraCharacteristics = paramCameraCharacteristics.nKQ;
        if (paramCameraCharacteristics != null)
        {
          paramCameraCharacteristics = (b.a.b)paramCameraCharacteristics.get(Integer.valueOf(btf()));
          if (paramCameraCharacteristics != null)
          {
            paramCameraCharacteristics = paramCameraCharacteristics.nKU;
            if (paramCameraCharacteristics != null)
            {
              Iterator localIterator = ((Iterable)paramCameraCharacteristics).iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                if ((arrayOfInt != null) && (k.contains(arrayOfInt, GX(str))))
                {
                  Log.i(this.TAG, s.X("support ", str));
                  paramCameraCharacteristics = this.nHA;
                  if (paramCameraCharacteristics != null) {
                    paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(GX(str)));
                  }
                  AppMethodBeat.o(237596);
                  return true;
                }
                paramCameraCharacteristics = bsu();
                if (paramCameraCharacteristics == null) {
                  paramCameraCharacteristics = null;
                }
                while (s.p(paramCameraCharacteristics, str))
                {
                  Log.e(this.TAG, "all of the focus-mode are not supported yet");
                  AppMethodBeat.o(237596);
                  return false;
                  paramCameraCharacteristics = paramCameraCharacteristics.nKQ;
                  if (paramCameraCharacteristics == null)
                  {
                    paramCameraCharacteristics = null;
                  }
                  else
                  {
                    paramCameraCharacteristics = (b.a.b)paramCameraCharacteristics.get(Integer.valueOf(btf()));
                    if (paramCameraCharacteristics == null)
                    {
                      paramCameraCharacteristics = null;
                    }
                    else
                    {
                      paramCameraCharacteristics = paramCameraCharacteristics.nKU;
                      if (paramCameraCharacteristics == null) {
                        paramCameraCharacteristics = null;
                      } else {
                        paramCameraCharacteristics = (String)kotlin.a.p.oM((List)paramCameraCharacteristics);
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
      AppMethodBeat.o(237596);
    }
    catch (Exception paramCameraCharacteristics)
    {
      Log.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
      AppMethodBeat.o(237596);
      return false;
    }
    return true;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  protected final void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    CaptureRequest.Builder localBuilder = null;
    AppMethodBeat.i(237561);
    Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (bsD())
    {
      Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(237561);
      return;
    }
    try
    {
      CameraDevice localCameraDevice;
      if (btx())
      {
        localCameraDevice = this.AF;
        if (localCameraDevice != null) {}
      }
      for (;;)
      {
        this.nHA = localBuilder;
        bti();
        bta();
        if (!a(paramSurfaceTexture, paramSurfaceHolder)) {
          break;
        }
        a(a.a.nGg);
        this.state = 0;
        AppMethodBeat.o(237561);
        return;
        localBuilder = localCameraDevice.createCaptureRequest(3);
        continue;
        localCameraDevice = this.AF;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(1);
        }
      }
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
      paramSurfaceTexture = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bqx();
      AppMethodBeat.o(237561);
    }
  }
  
  protected final void bta()
  {
    AppMethodBeat.i(237564);
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
          break label118;
        }
        i = 15;
        ur(i);
        localObject2 = btw();
        localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(btf()));
        if (localObject1 != null) {
          break label145;
        }
        bool = false;
      }
    }
    for (;;)
    {
      a((CameraCharacteristics)localObject2, bool);
      b(btw());
      a(btw());
      btw();
      AppMethodBeat.o(237564);
      return;
      label118:
      localObject2 = ((b.a.c)localObject2).nKX;
      if (localObject2 == null)
      {
        i = 15;
        break;
      }
      i = ((Integer)localObject2).intValue();
      break;
      label145:
      localObject1 = ((b.a.c)localObject1).nKY;
      if (localObject1 == null) {
        bool = false;
      } else {
        bool = ((Boolean)localObject1).booleanValue();
      }
    }
  }
  
  public final void btb() {}
  
  public final com.tencent.mm.media.widget.a.b btc()
  {
    boolean bool = true;
    AppMethodBeat.i(237576);
    Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.AF == null)
    {
      Log.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(237576);
      return null;
    }
    if (!bsD())
    {
      Log.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(237576);
      return null;
    }
    com.tencent.mm.media.widget.a.b localb = com.tencent.mm.media.widget.a.b.nGj;
    com.tencent.mm.media.widget.a.b.uk(getPreviewWidth());
    localb = com.tencent.mm.media.widget.a.b.nGj;
    com.tencent.mm.media.widget.a.b.uj(getPreviewHeight());
    int i = boh();
    if ((i == 90) || (i == 270))
    {
      i = 1;
      localb = com.tencent.mm.media.widget.a.b.nGj;
      com.tencent.mm.media.widget.a.b.um(bss().zWH);
      localb = com.tencent.mm.media.widget.a.b.nGj;
      com.tencent.mm.media.widget.a.b.un(bss().zWI);
      if (i != 0)
      {
        localb = com.tencent.mm.media.widget.a.b.nGj;
        i = com.tencent.mm.media.widget.a.b.bsM();
        localb = com.tencent.mm.media.widget.a.b.nGj;
        localb = com.tencent.mm.media.widget.a.b.nGj;
        com.tencent.mm.media.widget.a.b.um(com.tencent.mm.media.widget.a.b.bsN());
        localb = com.tencent.mm.media.widget.a.b.nGj;
        com.tencent.mm.media.widget.a.b.un(i);
      }
      localb = com.tencent.mm.media.widget.a.b.nGj;
      com.tencent.mm.media.widget.a.b.ul(getOrientation());
      localb = com.tencent.mm.media.widget.a.b.nGj;
      if (bsp()) {
        break label231;
      }
    }
    for (;;)
    {
      com.tencent.mm.media.widget.a.b.setFrontCamera(bool);
      localb = com.tencent.mm.media.widget.a.b.nGj;
      com.tencent.mm.media.widget.a.b.gw(bsq());
      localb = bst();
      AppMethodBeat.o(237576);
      return localb;
      i = 0;
      break;
      label231:
      bool = false;
    }
  }
  
  protected final int getPreviewHeight()
  {
    AppMethodBeat.i(237578);
    Object localObject = bss();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.p)localObject).zWI))
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(237578);
      return i;
    }
  }
  
  protected final int getPreviewWidth()
  {
    AppMethodBeat.i(237581);
    Object localObject = bss();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.p)localObject).zWH))
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(237581);
      return i;
    }
  }
  
  public final Point gx(boolean paramBoolean)
  {
    AppMethodBeat.i(237584);
    Point localPoint = new Point(bss().zWH, bss().zWI);
    Log.i(this.TAG, "size is " + localPoint.x + " and " + localPoint.y + ' ');
    AppMethodBeat.o(237584);
    return localPoint;
  }
  
  public final void h(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.f
 * JD-Core Version:    0.7.0.1
 */