package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Looper;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.media.k.e;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.d;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.e;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera/VoipCommonCamera1;", "Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/content/Context;II)V", "TAG", "", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "supportPreviewSizes", "", "Landroid/hardware/Camera$Size;", "Landroid/hardware/Camera;", "screenResolution", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraResolution", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "w", "h", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "", "getPreviewWidth", "postFocusOnTouch", "", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "removeFocusOnTouch", "safeSetFocusMode", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "safeSetPreviewFormat", "selectPreviewSize", "setPreviewCallbackImplInGPUCrop", "setSafeConfig", "startPreviewWithGPU", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "resolutionLimit", "translateFocusMode", "focusMode", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "tryPreviewSize", "trySetPreviewFpsRangeParameters", "p", "Landroid/hardware/Camera$Parameters;", "mCameraFps", "plugin-mediaeditor_release"})
public final class f
  extends c
{
  private final String TAG;
  private int height;
  private int width;
  
  public f(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(218839);
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.VoipCommonCamera1";
    AppMethodBeat.o(218839);
  }
  
  private static String Ht(String paramString)
  {
    AppMethodBeat.i(218836);
    p.h(paramString, "focusMode");
    b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
    if (p.j(paramString, b.b.aQC()))
    {
      AppMethodBeat.o(218836);
      return "auto";
    }
    localb = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
    if (p.j(paramString, b.b.aQA()))
    {
      AppMethodBeat.o(218836);
      return "continuous-video";
    }
    localb = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
    if (p.j(paramString, b.b.aQB()))
    {
      AppMethodBeat.o(218836);
      return "continuous-picture";
    }
    AppMethodBeat.o(218836);
    return "";
  }
  
  private final Point a(List<? extends Camera.Size> paramList, Point paramPoint)
  {
    AppMethodBeat.i(218825);
    int k = 2147483647;
    paramList = paramList.iterator();
    int j = 0;
    int i = 0;
    int n;
    int m;
    for (;;)
    {
      if (paramList.hasNext())
      {
        Camera.Size localSize = (Camera.Size)paramList.next();
        int i1;
        try
        {
          n = localSize.width;
          m = localSize.height;
          i1 = Math.abs(n - paramPoint.x) + Math.abs(m - paramPoint.y);
          if (i1 != 0) {
            break label134;
          }
          label83:
          if ((n <= 0) || (m <= 0)) {
            break;
          }
          paramList = new Point(n, m);
          AppMethodBeat.o(218825);
          return paramList;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Log.w(this.TAG, "Bad preview-size: ".concat(String.valueOf(localSize)));
        }
        continue;
        label134:
        if ((i1 >= k) || (n == m)) {
          break label179;
        }
        i = n;
        j = m;
        k = i1;
      }
    }
    label179:
    for (;;)
    {
      break;
      AppMethodBeat.o(218825);
      return null;
      m = j;
      n = i;
      break label83;
    }
  }
  
  private boolean aPy()
  {
    AppMethodBeat.i(218827);
    for (;;)
    {
      try
      {
        i = this.width;
        int j = this.height;
        localObject1 = this.gGr;
        if (localObject1 != null)
        {
          localObject1 = ((v)localObject1).getParameters();
          localObject2 = new Point(i, j);
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((Camera.Parameters)localObject1).getSupportedPreviewSizes();
          if (localObject1 == null) {
            break label668;
          }
          Log.i(this.TAG, "preview-size-values parameter: ".concat(String.valueOf(localObject1)));
          localObject1 = a((List)localObject1, (Point)localObject2);
          if (localObject1 != null) {
            break label665;
          }
          localObject1 = new Point(((Point)localObject2).x >> 3 << 3, ((Point)localObject2).y >> 3 << 3);
          localObject1 = new ac(((Point)localObject1).x, ((Point)localObject1).y);
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
        AppMethodBeat.o(218827);
        return true;
      }
      try
      {
        Log.i(this.TAG, "getCameraResolution:" + Integer.valueOf(((ac)localObject1).width) + "," + Integer.valueOf(((ac)localObject1).height));
        localObject2 = this.ilS;
        if (localObject2 == null) {
          break label523;
        }
        localObject2 = ((b.a)localObject2).ira;
        if (localObject2 == null) {
          break label523;
        }
        localObject2 = (b.a.e)((HashMap)localObject2).get(Integer.valueOf(aPu()));
        if (localObject2 == null) {
          break label523;
        }
        if ((((b.a.e)localObject2).irl == null) || (((b.a.e)localObject2).irm == null)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        if (localObject2 == null) {
          break label523;
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
        Log.e(this.TAG, "1.try config size failed!,try support size: w" + ((ac)localObject1).width + ",h" + ((ac)localObject1).height);
        if (dh(((ac)localObject1).width, ((ac)localObject1).height)) {
          continue;
        }
        Log.e(this.TAG, "1.try support size fail: w" + ((ac)localObject1).width + ",h" + ((ac)localObject1).height);
        AppMethodBeat.o(218827);
        return false;
      }
      catch (Exception localException2)
      {
        continue;
      }
      Object localObject1 = null;
      continue;
      localObject1 = null;
      continue;
      label523:
      Log.i(this.TAG, "2.no config size!");
      if (localObject1 != null)
      {
        Log.i(this.TAG, "2.try support size alternatively! w" + ((ac)localObject1).width + ",h" + ((ac)localObject1).height);
        if (!dh(((ac)localObject1).width, ((ac)localObject1).height))
        {
          Log.e(this.TAG, "2.try support size fail: w" + ((ac)localObject1).width + ",h" + ((ac)localObject1).height);
          AppMethodBeat.o(218827);
          return false;
        }
        AppMethodBeat.o(218827);
        return true;
      }
      AppMethodBeat.o(218827);
      return false;
      label665:
      continue;
      label668:
      localObject1 = null;
    }
  }
  
  private final boolean dh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218826);
    if ((this.gGr == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(218826);
      return false;
    }
    try
    {
      Object localObject = this.gGr;
      if (localObject != null) {}
      for (localObject = ((v)localObject).getParameters();; localObject = null)
      {
        if ((paramInt1 > 0) && (paramInt2 > 0) && (localObject != null)) {
          ((Camera.Parameters)localObject).setPreviewSize(paramInt1, paramInt2);
        }
        v localv = this.gGr;
        if (localv != null) {
          localv.setParameters((Camera.Parameters)localObject);
        }
        this.ilR.sUz = paramInt1;
        this.ilR.sUA = paramInt2;
        this.ilV = new Point(paramInt1, paramInt2);
        AppMethodBeat.o(218826);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "TryPreviewSize fail:".concat(String.valueOf(localException)));
      AppMethodBeat.o(218826);
    }
  }
  
  protected final void a(Camera.Parameters paramParameters, int paramInt)
  {
    AppMethodBeat.i(218835);
    p.h(paramParameters, "p");
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(218835);
      return;
    }
    paramInt = -2147483648;
    int i = -2147483648;
    int i4 = localList.size();
    int j = 2147483647;
    int k = 0;
    Object localObject;
    int m;
    int n;
    int i1;
    if (k < i4)
    {
      localObject = (int[])localList.get(k);
      m = j;
      n = i;
      i1 = paramInt;
      if (localObject != null)
      {
        if (localObject.length > 1) {
          break label137;
        }
        i1 = paramInt;
        n = i;
        m = j;
      }
      label137:
      int i2;
      int i3;
      label259:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  k += 1;
                  j = m;
                  i = n;
                  paramInt = i1;
                  break;
                  i2 = localObject[0];
                  i3 = localObject[1];
                  Log.i(this.TAG, "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i2), Integer.valueOf(i3) });
                  m = j;
                  n = i;
                  i1 = paramInt;
                } while (i2 < 0);
                m = j;
                n = i;
                i1 = paramInt;
              } while (i3 < i2);
              localObject = this.ilS;
              if (localObject == null) {
                break label568;
              }
              localObject = ((b.a)localObject).irc;
              if (localObject == null) {
                break label568;
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
      n = i3 / 1000;
      i1 = i2 / 1000;
      Integer localInteger = ((b.a.c)localObject).irg;
      if (localInteger != null)
      {
        m = localInteger.intValue();
        label384:
        if (n < m) {
          break label598;
        }
        localInteger = ((b.a.c)localObject).irh;
        if (localInteger == null) {
          break label580;
        }
        m = localInteger.intValue();
        label410:
        if (n > m) {
          break label598;
        }
        localInteger = ((b.a.c)localObject).irg;
        if (localInteger == null) {
          break label586;
        }
        m = localInteger.intValue();
        label436:
        if (i1 < m) {
          break label598;
        }
        localInteger = ((b.a.c)localObject).irh;
        if (localInteger == null) {
          break label592;
        }
        m = localInteger.intValue();
        label462:
        if (i1 > m) {
          break label598;
        }
        m = 1;
        label472:
        if (m == 0) {
          break label747;
        }
        localInteger = ((b.a.c)localObject).iri;
        if (localInteger == null) {
          break label604;
        }
        m = localInteger.intValue();
        label496:
        i1 = Math.abs(m - i1);
        localObject = ((b.a.c)localObject).iri;
        if (localObject == null) {
          break label610;
        }
        m = ((Integer)localObject).intValue();
        label525:
        m = Math.abs(n - m) + i1;
        if (m >= j) {
          break label747;
        }
        i = i3;
        paramInt = i2;
        j = m;
      }
    }
    label568:
    label580:
    label586:
    label592:
    label598:
    label604:
    label610:
    label747:
    for (;;)
    {
      m = j;
      n = i;
      i1 = paramInt;
      break;
      localObject = null;
      break label259;
      m = 0;
      break label384;
      m = 0;
      break label410;
      m = 0;
      break label436;
      m = 0;
      break label462;
      m = 0;
      break label472;
      m = 0;
      break label496;
      m = 0;
      break label525;
      Log.i(this.ilH, "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(30) });
      if ((paramInt == 2147483647) || (i == 2147483647))
      {
        AppMethodBeat.o(218835);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(paramInt, i);
        Log.i(this.ilH, "set fps range %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        AppMethodBeat.o(218835);
        return;
      }
      catch (Exception paramParameters)
      {
        Log.i(this.ilH, "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(218835);
        return;
      }
    }
  }
  
  protected final boolean a(v paramv)
  {
    AppMethodBeat.i(218837);
    if (paramv == null)
    {
      AppMethodBeat.o(218837);
      return false;
    }
    for (;;)
    {
      Camera.Parameters localParameters;
      try
      {
        localParameters = paramv.getParameters();
        p.g(localParameters, "p");
        List localList = localParameters.getSupportedFocusModes();
        localObject = this.ilS;
        if (localObject != null)
        {
          localObject = ((b.a)localObject).irb;
          if (localObject != null)
          {
            localObject = (b.a.b)((HashMap)localObject).get(Integer.valueOf(aPu()));
            if (localObject != null)
            {
              localObject = ((b.a.b)localObject).irf;
              if (localObject != null)
              {
                Iterator localIterator = ((Iterable)localObject).iterator();
                if (localIterator.hasNext())
                {
                  String str = (String)localIterator.next();
                  if ((localList != null) && (localList.contains(Ht(str))))
                  {
                    Log.i(this.TAG, "support ".concat(String.valueOf(str)));
                    localParameters.setFocusMode(Ht(str));
                    this.ilK.imR = localParameters.getFocusMode();
                    paramv.setParameters(localParameters);
                    AppMethodBeat.o(218837);
                    return true;
                  }
                  localObject = this.ilS;
                  if (localObject == null) {
                    break label351;
                  }
                  localObject = ((b.a)localObject).irb;
                  if (localObject == null) {
                    break label351;
                  }
                  localObject = (b.a.b)((HashMap)localObject).get(Integer.valueOf(aPu()));
                  if (localObject == null) {
                    break label351;
                  }
                  localObject = ((b.a.b)localObject).irf;
                  if (localObject == null) {
                    break label351;
                  }
                  localObject = (String)j.ku((List)localObject);
                  if (p.j(localObject, str))
                  {
                    Log.e(this.TAG, "all of the focus-mode are not supported yet");
                    AppMethodBeat.o(218837);
                    return false;
                  }
                  Log.e(this.TAG, "not support ".concat(String.valueOf(str)));
                  continue;
                }
              }
            }
          }
        }
        this.ilK.imR = localParameters.getFocusMode();
      }
      catch (Exception paramv)
      {
        Log.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(218837);
        return false;
      }
      paramv.setParameters(localParameters);
      AppMethodBeat.o(218837);
      return true;
      label351:
      Object localObject = null;
    }
  }
  
  public final void aPp()
  {
    AppMethodBeat.i(218830);
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
          break label149;
        }
        localObject2 = ((b.a.c)localObject2).iri;
        if (localObject2 == null) {
          break label149;
        }
        i = ((Integer)localObject2).intValue();
        this.imx = i;
        localObject2 = this.gGr;
        localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(aPu()));
        if (localObject1 == null) {
          break label155;
        }
        localObject1 = ((b.a.c)localObject1).irj;
        if (localObject1 == null) {
          break label155;
        }
      }
    }
    label149:
    label155:
    for (boolean bool = ((Boolean)localObject1).booleanValue();; bool = false)
    {
      a((v)localObject2, bool);
      b(this.gGr);
      c(this.gGr);
      a(this.gGr);
      AppMethodBeat.o(218830);
      return;
      i = 15;
      break;
    }
  }
  
  public final void aPq() {}
  
  public final b aPr()
  {
    boolean bool = true;
    AppMethodBeat.i(218831);
    Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.gGr == null)
    {
      Log.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(218831);
      return null;
    }
    if (!aPc())
    {
      Log.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(218831);
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
      AppMethodBeat.o(218831);
      return localObject;
      i = 0;
      break;
      i = 0;
      break;
      label202:
      bool = false;
    }
  }
  
  public final void aPt()
  {
    AppMethodBeat.i(218829);
    Object localObject1 = this.ilS;
    Object localObject3;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((b.a)localObject1).ire;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
        localObject1 = Boolean.valueOf(((HashSet)localObject1).contains(b.b.aQD()));
        if ((localObject1 != null) && (!p.j(localObject1, Boolean.FALSE))) {
          break label296;
        }
        i = 1;
        label56:
        if (i == 0) {
          break label301;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((Boolean)localObject1).booleanValue();
        if (this.gGr != null) {
          try
          {
            localObject1 = this.gGr;
            if (localObject1 == null) {
              p.hyc();
            }
            localObject1 = ((v)localObject1).getParameters();
            Log.i(this.TAG, "setPreviewCallbackImpl");
            i = this.ilR.sUz;
            int j = this.ilR.sUA;
            if (localObject1 == null) {
              p.hyc();
            }
            j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject1).getPreviewFormat()) * (i * j) / 8;
            i = 0;
            while (i < 5)
            {
              localObject1 = k.zwi.h(Integer.valueOf(j));
              localObject3 = this.gGr;
              if (localObject3 == null) {
                p.hyc();
              }
              ((v)localObject3).addCallbackBuffer((byte[])localObject1);
              i += 1;
            }
            this.imm.reset();
            this.imn.reset();
            this.imo.reset();
            this.imp.reset();
            this.imq.reset();
            localObject1 = this.gGr;
            if (localObject1 == null) {
              p.hyc();
            }
            ((v)localObject1).setPreviewCallbackWithBuffer((Camera.PreviewCallback)new a(this));
            AppMethodBeat.o(218829);
            return;
          }
          catch (Exception localException)
          {
            Log.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
          }
        }
        AppMethodBeat.o(218829);
        return;
      }
      AppMethodBeat.o(218829);
      return;
      Object localObject2 = null;
      break;
      label296:
      i = 0;
      break label56;
      label301:
      localObject2 = null;
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  protected final void b(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, int paramInt)
  {
    AppMethodBeat.i(218828);
    long l = Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (aPc())
    {
      Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(218828);
      return;
    }
    try
    {
      aPy();
      aPp();
      aPt();
      if (a(paramSurfaceTexture, paramSurfaceHolder)) {
        a(a.a.ima);
      }
      Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(218828);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = e.ilC;
        e.aNm();
      }
    }
  }
  
  public final boolean b(v paramv)
  {
    AppMethodBeat.i(218838);
    if (paramv == null)
    {
      AppMethodBeat.o(218838);
      return false;
    }
    Object localObject = this.ilS;
    if (localObject != null)
    {
      localObject = ((b.a)localObject).ird;
      if (localObject != null)
      {
        localObject = (b.a.d)((HashMap)localObject).get(Integer.valueOf(aPu()));
        if (localObject != null)
        {
          localObject = ((b.a.d)localObject).irk;
          if (localObject == null) {}
        }
      }
    }
    for (int i = ((Number)localObject).intValue();; i = 17) {
      try
      {
        Log.i(this.TAG, "safeSetPreviewFormat");
        localObject = paramv.getParameters();
        p.g(localObject, "p");
        List localList = ((Camera.Parameters)localObject).getSupportedPreviewFormats();
        if ((localList == null) || (!localList.contains(Integer.valueOf(i)))) {
          Log.e(this.TAG, "not support ".concat(String.valueOf(i)));
        }
        ((Camera.Parameters)localObject).setPreviewFormat(i);
        paramv.setParameters((Camera.Parameters)localObject);
        AppMethodBeat.o(218838);
        return true;
      }
      catch (Exception paramv)
      {
        Log.i(this.TAG, "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(218838);
      }
    }
    return false;
  }
  
  public final Point fa(boolean paramBoolean)
  {
    AppMethodBeat.i(218834);
    Object localObject = this.gGr;
    if (localObject != null)
    {
      localObject = ((v)localObject).getParameters();
      if (localObject == null) {}
    }
    for (localObject = ((Camera.Parameters)localObject).getPreviewSize();; localObject = null)
    {
      if (localObject != null) {
        Log.i(this.TAG, "size is " + ((Camera.Size)localObject).width + " and " + ((Camera.Size)localObject).height + " and " + this.ilR.sUz + " and " + this.ilR.sUA + ' ');
      }
      localObject = new Point(this.ilR.sUz, this.ilR.sUA);
      AppMethodBeat.o(218834);
      return localObject;
    }
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(218832);
    Object localObject = this.ilR;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((q)localObject).sUA);; localObject = null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(218832);
      return i;
    }
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(218833);
    Object localObject = this.ilR;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((q)localObject).sUz);; localObject = null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(218833);
      return i;
    }
  }
  
  public final void i(boolean paramBoolean, int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "ca", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/VoipCommonCamera1$setPreviewCallbackImplInGPUCrop$2$1"})
  static final class a
    implements Camera.PreviewCallback
  {
    a(f paramf) {}
    
    public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      boolean bool = false;
      AppMethodBeat.i(218824);
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.length != 0) {
          break label41;
        }
      }
      label41:
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(f.a(this.imJ), "onPreviewFrame, frame data is null!!");
        AppMethodBeat.o(218824);
        return;
      }
      if ((!this.imJ.imr) && (this.imJ.imj.size() > 0))
      {
        paramCamera = this.imJ.ilS;
        if (paramCamera != null)
        {
          paramCamera = paramCamera.ire;
          if (paramCamera != null)
          {
            b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.iqZ;
            paramCamera = Boolean.valueOf(paramCamera.contains(b.b.aQE()));
            if (paramCamera.booleanValue()) {
              break label267;
            }
            i = 1;
            if (i == 0) {
              break label272;
            }
          }
        }
      }
      for (;;)
      {
        if (paramCamera != null)
        {
          paramCamera.booleanValue();
          if (!this.imJ.ilM)
          {
            i = this.imJ.ilR.sUz;
            int j = this.imJ.ilR.sUA;
            paramCamera = this.imJ.imk;
            if (paramCamera == null) {
              p.hyc();
            }
            if (paramCamera.dYT != 270)
            {
              paramCamera = this.imJ.imk;
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
        }
        this.imJ.ah(paramArrayOfByte);
        this.imJ.ims = paramArrayOfByte;
        paramCamera = this.imJ.gGr;
        if (paramCamera == null) {
          p.hyc();
        }
        paramCamera.addCallbackBuffer(paramArrayOfByte);
        AppMethodBeat.o(218824);
        return;
        label267:
        i = 0;
        break;
        label272:
        paramCamera = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.f
 * JD-Core Version:    0.7.0.1
 */