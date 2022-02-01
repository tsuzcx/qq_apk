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
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera2/VoipCommonCamera2;", "Lcom/tencent/mm/media/widget/camera2/CommonCamera2;", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/content/Context;II)V", "TAG", "", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "supportPreviewSizes", "", "Landroid/util/Size;", "screenResolution", "([Landroid/util/Size;Landroid/graphics/Point;)Landroid/graphics/Point;", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraResolution", "w", "h", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "", "getPreviewWidth", "postFocusOnTouch", "", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "removeFocusOnTouch", "safeSetFocusMode", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "selectPreviewSize", "setSafeConfig", "startPreviewWithGPU", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "resolutionLimit", "translateFocusMode", "focusMode", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "tryPreviewSize", "trySetPreviewFpsRangeParameters", "mCameraFps", "plugin-mediaeditor_release"})
public final class e
  extends c
{
  private final String TAG;
  private int height;
  private int width;
  
  public e(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(218873);
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.VoipCommonCamera2";
    AppMethodBeat.o(218873);
  }
  
  private static int Hu(String paramString)
  {
    AppMethodBeat.i(218871);
    p.h(paramString, "focusMode");
    b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
    if (!p.j(paramString, b.b.aQC()))
    {
      localb = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
      if (p.j(paramString, b.b.aQA()))
      {
        AppMethodBeat.o(218871);
        return 3;
      }
      localb = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
      if (p.j(paramString, b.b.aQB()))
      {
        AppMethodBeat.o(218871);
        return 4;
      }
    }
    AppMethodBeat.o(218871);
    return 1;
  }
  
  private final Point a(Size[] paramArrayOfSize, Point paramPoint)
  {
    AppMethodBeat.i(218861);
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
        AppMethodBeat.o(218861);
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
        AppMethodBeat.o(218861);
        return null;
        i2 = j;
        i4 = i;
      }
    }
  }
  
  private boolean aPy()
  {
    AppMethodBeat.i(218863);
    for (;;)
    {
      try
      {
        Object localObject2 = new Point(this.width, this.height);
        localObject1 = b.inE;
        localObject1 = b.aPG();
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
          localObject2 = this.ilS;
          if (localObject2 == null) {
            break label466;
          }
          localObject2 = ((b.a)localObject2).ira;
          if (localObject2 == null) {
            break label466;
          }
          localObject2 = (b.a.e)((HashMap)localObject2).get(Integer.valueOf(aPu()));
          if (localObject2 == null) {
            break label466;
          }
          if ((((b.a.e)localObject2).irl == null) || (((b.a.e)localObject2).irm == null)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          if (localObject2 == null) {
            break label466;
          }
          localInteger = ((b.a.e)localObject2).irl;
          if (localInteger == null) {
            p.hyc();
          }
          i = localInteger.intValue();
          localInteger = ((b.a.e)localObject2).irm;
          if (localInteger == null) {
            p.hyc();
          }
          bool = dh(i, localInteger.intValue());
          Log.i(this.TAG, "1.try config size first! w" + ((b.a.e)localObject2).irl + ",h" + ((b.a.e)localObject2).irm);
          if ((bool) || (localObject1 == null)) {
            continue;
          }
          Log.e(this.TAG, "1.try config size failed!,try support size: w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
          if (dh(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight())) {
            continue;
          }
          Log.e(this.TAG, "1.try support size fail: w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
          AppMethodBeat.o(218863);
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
        AppMethodBeat.o(218863);
        return true;
      }
      label466:
      if (localObject1 != null)
      {
        Log.i(this.TAG, "2.try support size alternatively! w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
        if (!dh(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight()))
        {
          Log.e(this.TAG, "2.try support size fail: w" + ((Size)localObject1).getWidth() + ",h" + ((Size)localObject1).getHeight());
          AppMethodBeat.o(218863);
          return false;
        }
        AppMethodBeat.o(218863);
        return true;
      }
      AppMethodBeat.o(218863);
      return false;
      label601:
      continue;
      label604:
      Object localObject1 = null;
    }
  }
  
  private final boolean dh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218862);
    if ((this.surfaceTexture == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(218862);
      return false;
    }
    try
    {
      Object localObject = this.surfaceTexture;
      if (localObject != null) {
        ((SurfaceTexture)localObject).setDefaultBufferSize(paramInt1, paramInt2);
      }
      this.ilR.sUz = paramInt1;
      this.ilR.sUA = paramInt2;
      localObject = new Size(paramInt1, paramInt2);
      paramInt1 = ((Size)localObject).getWidth();
      paramInt2 = ((Size)localObject).getHeight();
      localObject = b.inE;
      localObject = ImageReader.newInstance(paramInt1, paramInt2, b.aPC(), 1);
      ((ImageReader)localObject).setOnImageAvailableListener(this.ilK.imS, this.ilK.imK);
      this.hiC = ((ImageReader)localObject);
      AppMethodBeat.o(218862);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "TryPreviewSize fail:".concat(String.valueOf(localException)));
      AppMethodBeat.o(218862);
    }
    return false;
  }
  
  protected final void a(CameraCharacteristics paramCameraCharacteristics, int paramInt)
  {
    AppMethodBeat.i(218870);
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
      AppMethodBeat.o(218870);
      return;
      paramCameraCharacteristics = null;
      break;
    }
    label53:
    if (paramCameraCharacteristics.length == 0) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(218870);
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
                } while (p.compare(localInteger1.intValue(), 0) < 0);
                i3 = localInteger2.intValue();
                p.g(localInteger1, "min");
                m = j;
                n = i;
                i1 = paramInt;
              } while (p.compare(i3, localInteger1.intValue()) < 0);
              localObject = this.ilS;
              if (localObject == null) {
                break label623;
              }
              localObject = ((b.a)localObject).irc;
              if (localObject == null) {
                break label623;
              }
              localObject = (b.a.c)((HashMap)localObject).get(Integer.valueOf(aPu()));
              m = j;
              n = i;
              i1 = paramInt;
            } while (localObject == null);
            localObject = this.ilS;
            m = j;
            n = i;
            i1 = paramInt;
          } while (localObject == null);
          localObject = ((b.a)localObject).irc;
          m = j;
          n = i;
          i1 = paramInt;
        } while (localObject == null);
        localObject = (b.a.c)((HashMap)localObject).get(Integer.valueOf(aPu()));
        m = j;
        n = i;
        i1 = paramInt;
      } while (localObject == null);
      n = localInteger2.intValue() / 1000;
      i1 = localInteger1.intValue() / 1000;
      Integer localInteger3 = ((b.a.c)localObject).irg;
      if (localInteger3 != null)
      {
        m = localInteger3.intValue();
        label425:
        if (n < m) {
          break label653;
        }
        localInteger3 = ((b.a.c)localObject).irh;
        if (localInteger3 == null) {
          break label635;
        }
        m = localInteger3.intValue();
        label451:
        if (n > m) {
          break label653;
        }
        localInteger3 = ((b.a.c)localObject).irg;
        if (localInteger3 == null) {
          break label641;
        }
        m = localInteger3.intValue();
        label477:
        if (i1 < m) {
          break label653;
        }
        localInteger3 = ((b.a.c)localObject).irh;
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
        localInteger3 = ((b.a.c)localObject).iri;
        if (localInteger3 == null) {
          break label659;
        }
        m = localInteger3.intValue();
        label537:
        i1 = Math.abs(m - i1);
        localObject = ((b.a.c)localObject).iri;
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
        p.g(localInteger2, "max");
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
      Log.i(this.ilH, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(30) });
      if ((paramInt == 2147483647) || (i == 2147483647))
      {
        AppMethodBeat.o(218870);
        return;
      }
      try
      {
        paramCameraCharacteristics = this.inI;
        if (paramCameraCharacteristics != null) {
          paramCameraCharacteristics.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range((Comparable)Integer.valueOf(paramInt), (Comparable)Integer.valueOf(i)));
        }
        Log.i(this.ilH, "set fps range %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        AppMethodBeat.o(218870);
        return;
      }
      catch (Exception paramCameraCharacteristics)
      {
        Log.i(this.ilH, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(218870);
        return;
      }
    }
  }
  
  protected final boolean a(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(218872);
    if (paramCameraCharacteristics == null)
    {
      AppMethodBeat.o(218872);
      return false;
    }
    for (;;)
    {
      try
      {
        int[] arrayOfInt = (int[])paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        paramCameraCharacteristics = this.ilS;
        if (paramCameraCharacteristics != null)
        {
          paramCameraCharacteristics = paramCameraCharacteristics.irb;
          if (paramCameraCharacteristics != null)
          {
            paramCameraCharacteristics = (b.a.b)paramCameraCharacteristics.get(Integer.valueOf(aPu()));
            if (paramCameraCharacteristics != null)
            {
              paramCameraCharacteristics = paramCameraCharacteristics.irf;
              if (paramCameraCharacteristics != null)
              {
                Iterator localIterator = ((Iterable)paramCameraCharacteristics).iterator();
                if (localIterator.hasNext())
                {
                  String str = (String)localIterator.next();
                  if ((arrayOfInt != null) && (kotlin.a.e.contains(arrayOfInt, Hu(str))))
                  {
                    Log.i(this.TAG, "support ".concat(String.valueOf(str)));
                    paramCameraCharacteristics = this.inI;
                    if (paramCameraCharacteristics != null) {
                      paramCameraCharacteristics.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(Hu(str)));
                    }
                    AppMethodBeat.o(218872);
                    return true;
                  }
                  paramCameraCharacteristics = this.ilS;
                  if (paramCameraCharacteristics == null) {
                    break label317;
                  }
                  paramCameraCharacteristics = paramCameraCharacteristics.irb;
                  if (paramCameraCharacteristics == null) {
                    break label317;
                  }
                  paramCameraCharacteristics = (b.a.b)paramCameraCharacteristics.get(Integer.valueOf(aPu()));
                  if (paramCameraCharacteristics == null) {
                    break label317;
                  }
                  paramCameraCharacteristics = paramCameraCharacteristics.irf;
                  if (paramCameraCharacteristics == null) {
                    break label317;
                  }
                  paramCameraCharacteristics = (String)j.ku((List)paramCameraCharacteristics);
                  if (p.j(paramCameraCharacteristics, str))
                  {
                    Log.e(this.TAG, "all of the focus-mode are not supported yet");
                    AppMethodBeat.o(218872);
                    return false;
                  }
                  Log.e(this.TAG, "not support ".concat(String.valueOf(str)));
                  continue;
                }
              }
            }
          }
        }
        AppMethodBeat.o(218872);
      }
      catch (Exception paramCameraCharacteristics)
      {
        Log.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCameraCharacteristics.getMessage() });
        AppMethodBeat.o(218872);
        return false;
      }
      return true;
      label317:
      paramCameraCharacteristics = null;
    }
  }
  
  protected final void aPp()
  {
    AppMethodBeat.i(218865);
    Object localObject1 = this.ilS;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((b.a)localObject1).irc;
      if (localObject1 != null)
      {
        localObject2 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(aPu()));
        if (localObject2 == null) {
          break label140;
        }
        localObject2 = ((b.a.c)localObject2).iri;
        if (localObject2 == null) {
          break label140;
        }
        i = ((Integer)localObject2).intValue();
        this.imx = i;
        localObject2 = this.inL;
        localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(aPu()));
        if (localObject1 == null) {
          break label146;
        }
        localObject1 = ((b.a.c)localObject1).irj;
        if (localObject1 == null) {
          break label146;
        }
      }
    }
    label140:
    label146:
    for (boolean bool = ((Boolean)localObject1).booleanValue();; bool = false)
    {
      a((CameraCharacteristics)localObject2, bool);
      b(this.inL);
      a(this.inL);
      AppMethodBeat.o(218865);
      return;
      i = 15;
      break;
    }
  }
  
  public final void aPq() {}
  
  public final com.tencent.mm.media.widget.a.b aPr()
  {
    boolean bool = true;
    AppMethodBeat.i(218866);
    Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.inH == null)
    {
      Log.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(218866);
      return null;
    }
    if (!aPc())
    {
      Log.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(218866);
      return null;
    }
    com.tencent.mm.media.widget.a.b localb = com.tencent.mm.media.widget.a.b.imh;
    com.tencent.mm.media.widget.a.b.rs(getPreviewWidth());
    localb = com.tencent.mm.media.widget.a.b.imh;
    com.tencent.mm.media.widget.a.b.rr(getPreviewHeight());
    int i = aPv();
    if ((i == 90) || (i == 270))
    {
      i = 1;
      localb = com.tencent.mm.media.widget.a.b.imh;
      com.tencent.mm.media.widget.a.b.ru(this.ilR.sUz);
      localb = com.tencent.mm.media.widget.a.b.imh;
      com.tencent.mm.media.widget.a.b.rv(this.ilR.sUA);
      if (i != 0)
      {
        localb = com.tencent.mm.media.widget.a.b.imh;
        i = com.tencent.mm.media.widget.a.b.aPl();
        localb = com.tencent.mm.media.widget.a.b.imh;
        localb = com.tencent.mm.media.widget.a.b.imh;
        com.tencent.mm.media.widget.a.b.ru(com.tencent.mm.media.widget.a.b.aPm());
        localb = com.tencent.mm.media.widget.a.b.imh;
        com.tencent.mm.media.widget.a.b.rv(i);
      }
      localb = com.tencent.mm.media.widget.a.b.imh;
      com.tencent.mm.media.widget.a.b.rt(getOrientation());
      localb = com.tencent.mm.media.widget.a.b.imh;
      if (this.ilM) {
        break label231;
      }
    }
    for (;;)
    {
      com.tencent.mm.media.widget.a.b.setFrontCamera(bool);
      localb = com.tencent.mm.media.widget.a.b.imh;
      com.tencent.mm.media.widget.a.b.eZ(this.ilO);
      localb = this.hAu;
      AppMethodBeat.o(218866);
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
    AppMethodBeat.i(218864);
    Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (aPc())
    {
      Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(218864);
      return;
    }
    try
    {
      CameraDevice localCameraDevice;
      if (this.inN)
      {
        localCameraDevice = this.inH;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(3);
        }
      }
      for (;;)
      {
        this.inI = localBuilder;
        aPy();
        aPp();
        if (!a(paramSurfaceTexture, paramSurfaceHolder)) {
          break;
        }
        a(a.a.ima);
        this.state = 0;
        AppMethodBeat.o(218864);
        return;
        localCameraDevice = this.inH;
        if (localCameraDevice != null) {
          localBuilder = localCameraDevice.createCaptureRequest(1);
        }
      }
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
      paramSurfaceTexture = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNm();
      AppMethodBeat.o(218864);
    }
  }
  
  public final Point fa(boolean paramBoolean)
  {
    AppMethodBeat.i(218869);
    Point localPoint = new Point(this.ilR.sUz, this.ilR.sUA);
    Log.i(this.TAG, "size is " + localPoint.x + " and " + localPoint.y + ' ');
    AppMethodBeat.o(218869);
    return localPoint;
  }
  
  protected final int getPreviewHeight()
  {
    AppMethodBeat.i(218867);
    Object localObject = this.ilR;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((q)localObject).sUA);; localObject = null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(218867);
      return i;
    }
  }
  
  protected final int getPreviewWidth()
  {
    AppMethodBeat.i(218868);
    Object localObject = this.ilR;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((q)localObject).sUz);; localObject = null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(218868);
      return i;
    }
  }
  
  public final void i(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e
 * JD-Core Version:    0.7.0.1
 */