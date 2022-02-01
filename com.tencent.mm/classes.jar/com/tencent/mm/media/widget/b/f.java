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
import kotlin.a.e;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera2/VoipCommonCamera2;", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/content/Context;II)V", "TAG", "", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "supportPreviewSizes", "", "Landroid/util/Size;", "screenResolution", "([Landroid/util/Size;Landroid/graphics/Point;)Landroid/graphics/Point;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraResolution", "w", "h", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "", "getPreviewWidth", "postFocusOnTouch", "", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "removeFocusOnTouch", "safeSetFocusMode", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "selectPreviewSize", "setSafeConfig", "startPreviewWithGPU", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "resolutionLimit", "translateFocusMode", "focusMode", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "tryPreviewSize", "trySetPreviewFpsRangeParameters", "mCameraFps", "plugin-mediaeditor_release"})
public final class f
  extends d
{
  private final String TAG;
  private int height;
  private int width;
  
  public f(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(259321);
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.VoipCommonCamera2";
    AppMethodBeat.o(259321);
  }
  
  private static int OH(String paramString)
  {
    AppMethodBeat.i(259318);
    kotlin.g.b.p.k(paramString, "focusMode");
    b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
    if (!kotlin.g.b.p.h(paramString, b.b.aZu()))
    {
      localb = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
      if (kotlin.g.b.p.h(paramString, b.b.aZs()))
      {
        AppMethodBeat.o(259318);
        return 3;
      }
      localb = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
      if (kotlin.g.b.p.h(paramString, b.b.aZt()))
      {
        AppMethodBeat.o(259318);
        return 4;
      }
    }
    AppMethodBeat.o(259318);
    return 1;
  }
  
  private final Point a(Size[] paramArrayOfSize, Point paramPoint)
  {
    AppMethodBeat.i(259293);
    int k = 2147483647;
    int i5 = paramArrayOfSize.length;
    int i3 = 0;
    int j = 0;
    int i = 0;
    Size localSize;
    if (i3 < i5) {
      localSize = paramArrayOfSize[i3];
    }
    for (;;)
    {
      int i4;
      int i2;
      int i1;
      int m;
      int n;
      try
      {
        i4 = localSize.getWidth();
        i2 = localSize.getHeight();
        i1 = Math.abs(i4 - paramPoint.x) + Math.abs(i2 - paramPoint.y);
        if (i1 != 0) {
          break label155;
        }
        if ((i4 <= 0) || (i2 <= 0)) {
          break label191;
        }
        paramArrayOfSize = new Point(i4, i2);
        AppMethodBeat.o(259293);
        return paramArrayOfSize;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.w(this.TAG, "Bad preview-size: ".concat(String.valueOf(localSize)));
        m = i;
        n = j;
        i1 = k;
        i3 += 1;
        k = i1;
        j = n;
        i = m;
      }
      break;
      label155:
      if (i1 < k)
      {
        n = i2;
        m = i4;
        if (i4 != i2) {}
      }
      else
      {
        i1 = k;
        n = j;
        m = i;
        continue;
        label191:
        AppMethodBeat.o(259293);
        return null;
        i2 = j;
        i4 = i;
      }
    }
  }
  
  private boolean aYm()
  {
    AppMethodBeat.i(259298);
    for (;;)
    {
      try
      {
        Object localObject2 = new Point(this.width, this.height);
        localObject1 = c.lcH;
        localObject1 = c.aYu();
        if (localObject1 == null) {
          break label604;
        }
        Log.i(this.TAG, "preview-size-values parameter: ".concat(String.valueOf(localObject1)));
        localObject1 = a((Size[])localObject1, (Point)localObject2);
        if (localObject1 != null) {
          break label601;
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
          Log.i(this.TAG, "getCameraResolution:" + Integer.valueOf(((Size)localObject1).getWidth()) + "," + Integer.valueOf(((Size)localObject1).getHeight()));
          localObject2 = this.laS;
          if (localObject2 == null) {
            break label466;
          }
          localObject2 = ((b.a)localObject2).lgf;
          if (localObject2 == null) {
            break label466;
          }
          localObject2 = (b.a.e)((HashMap)localObject2).get(Integer.valueOf(aYi()));
          if (localObject2 == null) {
            break label466;
          }
          if ((((b.a.e)localObject2).lgq == null) || (((b.a.e)localObject2).lgr == null)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          if (localObject2 == null) {
            break label466;
          }
          localInteger = ((b.a.e)localObject2).lgq;
          if (localInteger == null) {
            kotlin.g.b.p.iCn();
          }
          i = localInteger.intValue();
          localInteger = ((b.a.e)localObject2).lgr;
          if (localInteger == null) {
            kotlin.g.b.p.iCn();
          }
          bool = dD(i, localInteger.intValue());
          Log.i(this.TAG, "1.try config size first! w" + ((b.a.e)localObject2).lgq + ",h" + ((b.a.e)localObject2).lgr);
          if ((bool) || (localObject1 == null)) {
            continue;
          }
          Log.e(this.TAG, "1.try config size failed!,try support size: w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
          if (dD(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight())) {
            continue;
          }
          Log.e(this.TAG, "1.try support size fail: w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
          AppMethodBeat.o(259298);
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
        AppMethodBeat.o(259298);
        return true;
      }
      label466:
      if (localObject1 != null)
      {
        Log.i(this.TAG, "2.try support size alternatively! w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
        if (!dD(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight()))
        {
          Log.e(this.TAG, "2.try support size fail: w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
          AppMethodBeat.o(259298);
          return false;
        }
        AppMethodBeat.o(259298);
        return true;
      }
      AppMethodBeat.o(259298);
      return false;
      label601:
      continue;
      label604:
      Object localObject1 = null;
    }
  }
  
  private final boolean dD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259296);
    if ((getSurfaceTexture() == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(259296);
      return false;
    }
    try
    {
      Object localObject = getSurfaceTexture();
      if (localObject != null) {
        ((SurfaceTexture)localObject).setDefaultBufferSize(paramInt1, paramInt2);
      }
      this.laR.wAw = paramInt1;
      this.laR.wAx = paramInt2;
      localObject = new Size(paramInt1, paramInt2);
      paramInt1 = ((Size)localObject).getWidth();
      paramInt2 = ((Size)localObject).getHeight();
      localObject = c.lcH;
      localObject = ImageReader.newInstance(paramInt1, paramInt2, c.aYq(), 1);
      ((ImageReader)localObject).setOnImageAvailableListener(this.laK.lbT, this.laK.lbL);
      a((ImageReader)localObject);
      AppMethodBeat.o(259296);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "TryPreviewSize fail:".concat(String.valueOf(localException)));
      AppMethodBeat.o(259296);
    }
    return false;
  }
  
  protected final void a(CameraCharacteristics paramCameraCharacteristics, int paramInt)
  {
    AppMethodBeat.i(259317);
    if (paramCameraCharacteristics != null)
    {
      paramCameraCharacteristics = (Range[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
      if (paramCameraCharacteristics != null) {
        if (paramCameraCharacteristics.length != 0) {
          break label48;
        }
      }
    }
    label48:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label53;
      }
      AppMethodBeat.o(259317);
      return;
      paramCameraCharacteristics = null;
      break;
    }
    label53:
    if (paramCameraCharacteristics.length == 0) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(259317);
      return;
    }
    paramInt = -2147483648;
    int i = -2147483648;
    int i2 = paramCameraCharacteristics.length;
    int j = 2147483647;
    int k = 0;
    Object localObject;
    int i1;
    int n;
    int m;
    if (k < i2)
    {
      localObject = paramCameraCharacteristics[k];
      if (localObject == null)
      {
        i1 = paramInt;
        n = i;
        m = j;
      }
      Integer localInteger1;
      Integer localInteger2;
      label294:
      do
      {
        do
        {
          do
          {
            do
            {
              int i3;
              do
              {
                do
                {
                  k += 1;
                  j = m;
                  i = n;
                  paramInt = i1;
                  break;
                  localInteger1 = (Integer)((Range)localObject).getLower();
                  localInteger2 = (Integer)((Range)localObject).getUpper();
                  Log.i(this.TAG, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(k), localInteger1, localInteger2 });
                  m = j;
                  n = i;
                  i1 = paramInt;
                } while (kotlin.g.b.p.compare(localInteger1.intValue(), 0) < 0);
                i3 = localInteger2.intValue();
                kotlin.g.b.p.j(localInteger1, "min");
                m = j;
                n = i;
                i1 = paramInt;
              } while (kotlin.g.b.p.compare(i3, localInteger1.intValue()) < 0);
              localObject = this.laS;
              if (localObject == null) {
                break label623;
              }
              localObject = ((b.a)localObject).lgh;
              if (localObject == null) {
                break label623;
              }
              localObject = (b.a.c)((HashMap)localObject).get(Integer.valueOf(aYi()));
              m = j;
              n = i;
              i1 = paramInt;
            } while (localObject == null);
            localObject = this.laS;
            m = j;
            n = i;
            i1 = paramInt;
          } while (localObject == null);
          localObject = ((b.a)localObject).lgh;
          m = j;
          n = i;
          i1 = paramInt;
        } while (localObject == null);
        localObject = (b.a.c)((HashMap)localObject).get(Integer.valueOf(aYi()));
        m = j;
        n = i;
        i1 = paramInt;
      } while (localObject == null);
      n = localInteger2.intValue() / 1000;
      i1 = localInteger1.intValue() / 1000;
      Integer localInteger3 = ((b.a.c)localObject).lgl;
      if (localInteger3 != null)
      {
        m = localInteger3.intValue();
        label425:
        if (n < m) {
          break label653;
        }
        localInteger3 = ((b.a.c)localObject).lgm;
        if (localInteger3 == null) {
          break label635;
        }
        m = localInteger3.intValue();
        label451:
        if (n > m) {
          break label653;
        }
        localInteger3 = ((b.a.c)localObject).lgl;
        if (localInteger3 == null) {
          break label641;
        }
        m = localInteger3.intValue();
        label477:
        if (i1 < m) {
          break label653;
        }
        localInteger3 = ((b.a.c)localObject).lgm;
        if (localInteger3 == null) {
          break label647;
        }
        m = localInteger3.intValue();
        label503:
        if (i1 > m) {
          break label653;
        }
        m = 1;
        label513:
        if (m == 0) {
          break label833;
        }
        localInteger3 = ((b.a.c)localObject).lgn;
        if (localInteger3 == null) {
          break label659;
        }
        m = localInteger3.intValue();
        label537:
        i1 = Math.abs(m - i1);
        localObject = ((b.a.c)localObject).lgn;
        if (localObject == null) {
          break label665;
        }
        m = ((Integer)localObject).intValue();
        label566:
        m = Math.abs(n - m) + i1;
        if (m >= j) {
          break label833;
        }
        paramInt = localInteger1.intValue();
        kotlin.g.b.p.j(localInteger2, "max");
        i = localInteger2.intValue();
        j = m;
      }
    }
    label641:
    label647:
    label653:
    label659:
    label665:
    label833:
    for (;;)
    {
      m = j;
      n = i;
      i1 = paramInt;
      break;
      label623:
      localObject = null;
      break label294;
      m = 0;
      break label425;
      label635:
      m = 0;
      break label451;
      m = 0;
      break label477;
      m = 0;
      break label503;
      m = 0;
      break label513;
      m = 0;
      break label537;
      m = 0;
      break label566;
      Log.i(aXE(), "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(30) });
      if ((paramInt == 2147483647) || (i == 2147483647))
      {
        AppMethodBeat.o(259317);
        return;
      }
      try
      {
        paramCameraCharacteristics = this.lcL;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range((Comparable)Integer.valueOf(paramInt), (Comparable)Integer.valueOf(i)));
        }
        Log.i(aXE(), "set fps range %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        AppMethodBeat.o(259317);
        return;
      }
      catch (Exception paramCameraCharacteristics)
      {
        Log.i(aXE(), "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(259317);
        return;
      }
    }
  }
  
  protected final boolean a(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(259320);
    if (paramCameraCharacteristics == null)
    {
      AppMethodBeat.o(259320);
      return false;
    }
    for (;;)
    {
      try
      {
        int[] arrayOfInt = (int[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        paramCameraCharacteristics = this.laS;
        if (paramCameraCharacteristics != null)
        {
          paramCameraCharacteristics = paramCameraCharacteristics.lgg;
          if (paramCameraCharacteristics != null)
          {
            paramCameraCharacteristics = (b.a.b)paramCameraCharacteristics.get(Integer.valueOf(aYi()));
            if (paramCameraCharacteristics != null)
            {
              paramCameraCharacteristics = paramCameraCharacteristics.lgk;
              if (paramCameraCharacteristics != null)
              {
                Iterator localIterator = ((Iterable)paramCameraCharacteristics).iterator();
                if (localIterator.hasNext())
                {
                  String str = (String)localIterator.next();
                  if ((arrayOfInt != null) && (e.contains(arrayOfInt, OH(str))))
                  {
                    Log.i(this.TAG, "support ".concat(String.valueOf(str)));
                    paramCameraCharacteristics = this.lcL;
                    if (paramCameraCharacteristics != null) {
                      paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(OH(str)));
                    }
                    AppMethodBeat.o(259320);
                    return true;
                  }
                  paramCameraCharacteristics = this.laS;
                  if (paramCameraCharacteristics == null) {
                    break label317;
                  }
                  paramCameraCharacteristics = paramCameraCharacteristics.lgg;
                  if (paramCameraCharacteristics == null) {
                    break label317;
                  }
                  paramCameraCharacteristics = (b.a.b)paramCameraCharacteristics.get(Integer.valueOf(aYi()));
                  if (paramCameraCharacteristics == null) {
                    break label317;
                  }
                  paramCameraCharacteristics = paramCameraCharacteristics.lgk;
                  if (paramCameraCharacteristics == null) {
                    break label317;
                  }
                  paramCameraCharacteristics = (String)j.lq((List)paramCameraCharacteristics);
                  if (kotlin.g.b.p.h(paramCameraCharacteristics, str))
                  {
                    Log.e(this.TAG, "all of the focus-mode are not supported yet");
                    AppMethodBeat.o(259320);
                    return false;
                  }
                  Log.e(this.TAG, "not support ".concat(String.valueOf(str)));
                  continue;
                }
              }
            }
          }
        }
        AppMethodBeat.o(259320);
      }
      catch (Exception paramCameraCharacteristics)
      {
        Log.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(259320);
        return false;
      }
      return true;
      label317:
      paramCameraCharacteristics = null;
    }
  }
  
  protected final void aYd()
  {
    AppMethodBeat.i(259304);
    Object localObject1 = this.laS;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((b.a)localObject1).lgh;
      if (localObject1 != null)
      {
        localObject2 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(aYi()));
        if (localObject2 == null) {
          break label145;
        }
        localObject2 = ((b.a.c)localObject2).lgn;
        if (localObject2 == null) {
          break label145;
        }
        i = ((Integer)localObject2).intValue();
        ur(i);
        localObject2 = aYy();
        localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(aYi()));
        if (localObject1 == null) {
          break label151;
        }
        localObject1 = ((b.a.c)localObject1).lgo;
        if (localObject1 == null) {
          break label151;
        }
      }
    }
    label145:
    label151:
    for (boolean bool = ((Boolean)localObject1).booleanValue();; bool = false)
    {
      a((CameraCharacteristics)localObject2, bool);
      b(aYy());
      a(aYy());
      aYy();
      AppMethodBeat.o(259304);
      return;
      i = 15;
      break;
    }
  }
  
  public final void aYe() {}
  
  public final com.tencent.mm.media.widget.a.b aYf()
  {
    boolean bool = true;
    AppMethodBeat.i(259310);
    Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.lcK == null)
    {
      Log.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(259310);
      return null;
    }
    if (!aXQ())
    {
      Log.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(259310);
      return null;
    }
    com.tencent.mm.media.widget.a.b localb = com.tencent.mm.media.widget.a.b.lbh;
    com.tencent.mm.media.widget.a.b.ul(getPreviewWidth());
    localb = com.tencent.mm.media.widget.a.b.lbh;
    com.tencent.mm.media.widget.a.b.uk(getPreviewHeight());
    int i = aYj();
    if ((i == 90) || (i == 270))
    {
      i = 1;
      localb = com.tencent.mm.media.widget.a.b.lbh;
      com.tencent.mm.media.widget.a.b.un(this.laR.wAw);
      localb = com.tencent.mm.media.widget.a.b.lbh;
      com.tencent.mm.media.widget.a.b.uo(this.laR.wAx);
      if (i != 0)
      {
        localb = com.tencent.mm.media.widget.a.b.lbh;
        i = com.tencent.mm.media.widget.a.b.aXY();
        localb = com.tencent.mm.media.widget.a.b.lbh;
        localb = com.tencent.mm.media.widget.a.b.lbh;
        com.tencent.mm.media.widget.a.b.un(com.tencent.mm.media.widget.a.b.aXZ());
        localb = com.tencent.mm.media.widget.a.b.lbh;
        com.tencent.mm.media.widget.a.b.uo(i);
      }
      localb = com.tencent.mm.media.widget.a.b.lbh;
      com.tencent.mm.media.widget.a.b.um(getOrientation());
      localb = com.tencent.mm.media.widget.a.b.lbh;
      if (this.laM) {
        break label231;
      }
    }
    for (;;)
    {
      com.tencent.mm.media.widget.a.b.setFrontCamera(bool);
      localb = com.tencent.mm.media.widget.a.b.lbh;
      com.tencent.mm.media.widget.a.b.fI(aXG());
      localb = aXI();
      AppMethodBeat.o(259310);
      return localb;
      i = 0;
      break;
      label231:
      bool = false;
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  protected final void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    CaptureRequest.Builder localBuilder = null;
    AppMethodBeat.i(259301);
    Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (aXQ())
    {
      Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(259301);
      return;
    }
    try
    {
      CameraDevice localCameraDevice;
      if (aYz())
      {
        localCameraDevice = this.lcK;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(3);
        }
      }
      for (;;)
      {
        this.lcL = localBuilder;
        aYm();
        aYd();
        if (!a(paramSurfaceTexture, paramSurfaceHolder)) {
          break;
        }
        a(a.a.lbb);
        this.state = 0;
        AppMethodBeat.o(259301);
        return;
        localCameraDevice = this.lcK;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(1);
        }
      }
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
      paramSurfaceTexture = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aVQ();
      AppMethodBeat.o(259301);
    }
  }
  
  public final Point fJ(boolean paramBoolean)
  {
    AppMethodBeat.i(259315);
    Point localPoint = new Point(this.laR.wAw, this.laR.wAx);
    Log.i(this.TAG, "size is " + localPoint.x + " and " + localPoint.y + ' ');
    AppMethodBeat.o(259315);
    return localPoint;
  }
  
  protected final int getPreviewHeight()
  {
    AppMethodBeat.i(259312);
    Object localObject = this.laR;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.p)localObject).wAx);; localObject = null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(259312);
      return i;
    }
  }
  
  protected final int getPreviewWidth()
  {
    AppMethodBeat.i(259314);
    Object localObject = this.laR;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.p)localObject).wAw);; localObject = null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(259314);
      return i;
    }
  }
  
  public final void k(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.f
 * JD-Core Version:    0.7.0.1
 */