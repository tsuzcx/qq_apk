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
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.media.k.f;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.d;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.e;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera/VoipCommonCamera1;", "Lcom/tencent/mm/media/widget/camera/CommonCamera1;", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/content/Context;II)V", "TAG", "", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "supportPreviewSizes", "", "Landroid/hardware/Camera$Size;", "Landroid/hardware/Camera;", "screenResolution", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraResolution", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "w", "h", "getPreviewHeight", "getPreviewSize", "cropSizeIfCan", "", "getPreviewWidth", "postFocusOnTouch", "", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "removeFocusOnTouch", "safeSetFocusMode", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "safeSetPreviewFormat", "selectPreviewSize", "setPreviewCallbackImplInGPUCrop", "setSafeConfig", "startPreviewWithGPU", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/SurfaceHolder;", "resolutionLimit", "translateFocusMode", "focusMode", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "tryPreviewSize", "trySetPreviewFpsRangeParameters", "p", "Landroid/hardware/Camera$Parameters;", "mCameraFps", "plugin-mediaeditor_release"})
public final class g
  extends c
{
  private final String TAG;
  private int height;
  private int width;
  
  public g(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(258904);
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.VoipCommonCamera1";
    AppMethodBeat.o(258904);
  }
  
  private static String OG(String paramString)
  {
    AppMethodBeat.i(258900);
    kotlin.g.b.p.k(paramString, "focusMode");
    b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
    if (kotlin.g.b.p.h(paramString, b.b.aZu()))
    {
      AppMethodBeat.o(258900);
      return "auto";
    }
    localb = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
    if (kotlin.g.b.p.h(paramString, b.b.aZs()))
    {
      AppMethodBeat.o(258900);
      return "continuous-video";
    }
    localb = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
    if (kotlin.g.b.p.h(paramString, b.b.aZt()))
    {
      AppMethodBeat.o(258900);
      return "continuous-picture";
    }
    AppMethodBeat.o(258900);
    return "";
  }
  
  private final Point a(List<? extends Camera.Size> paramList, Point paramPoint)
  {
    AppMethodBeat.i(258874);
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
          AppMethodBeat.o(258874);
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
      AppMethodBeat.o(258874);
      return null;
      m = j;
      n = i;
      break label83;
    }
  }
  
  private boolean aYm()
  {
    AppMethodBeat.i(258881);
    for (;;)
    {
      try
      {
        i = this.width;
        int j = this.height;
        localObject1 = this.jqD;
        if (localObject1 != null)
        {
          localObject1 = ((w)localObject1).avd();
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
        AppMethodBeat.o(258881);
        return true;
      }
      try
      {
        Log.i(this.TAG, "getCameraResolution:" + Integer.valueOf(((ad)localObject1).width) + "," + Integer.valueOf(((ad)localObject1).height));
        localObject2 = this.laS;
        if (localObject2 == null) {
          break label523;
        }
        localObject2 = ((b.a)localObject2).lgf;
        if (localObject2 == null) {
          break label523;
        }
        localObject2 = (b.a.e)((HashMap)localObject2).get(Integer.valueOf(aYi()));
        if (localObject2 == null) {
          break label523;
        }
        if ((((b.a.e)localObject2).lgq == null) || (((b.a.e)localObject2).lgr == null)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        if (localObject2 == null) {
          break label523;
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
        Log.e(this.TAG, "1.try config size failed!,try support size: w" + ((ad)localObject1).width + ",h" + ((ad)localObject1).height);
        if (dD(((ad)localObject1).width, ((ad)localObject1).height)) {
          continue;
        }
        Log.e(this.TAG, "1.try support size fail: w" + ((ad)localObject1).width + ",h" + ((ad)localObject1).height);
        AppMethodBeat.o(258881);
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
        Log.i(this.TAG, "2.try support size alternatively! w" + ((ad)localObject1).width + ",h" + ((ad)localObject1).height);
        if (!dD(((ad)localObject1).width, ((ad)localObject1).height))
        {
          Log.e(this.TAG, "2.try support size fail: w" + ((ad)localObject1).width + ",h" + ((ad)localObject1).height);
          AppMethodBeat.o(258881);
          return false;
        }
        AppMethodBeat.o(258881);
        return true;
      }
      AppMethodBeat.o(258881);
      return false;
      label665:
      continue;
      label668:
      localObject1 = null;
    }
  }
  
  private final boolean dD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(258877);
    if ((this.jqD == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(258877);
      return false;
    }
    try
    {
      Object localObject = this.jqD;
      if (localObject != null) {}
      for (localObject = ((w)localObject).avd();; localObject = null)
      {
        if ((paramInt1 > 0) && (paramInt2 > 0) && (localObject != null)) {
          ((Camera.Parameters)localObject).setPreviewSize(paramInt1, paramInt2);
        }
        w localw = this.jqD;
        if (localw != null) {
          localw.c((Camera.Parameters)localObject);
        }
        this.laR.wAw = paramInt1;
        this.laR.wAx = paramInt2;
        this.laW = new Point(paramInt1, paramInt2);
        AppMethodBeat.o(258877);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "TryPreviewSize fail:".concat(String.valueOf(localException)));
      AppMethodBeat.o(258877);
    }
  }
  
  protected final void a(Camera.Parameters paramParameters, int paramInt)
  {
    AppMethodBeat.i(258897);
    kotlin.g.b.p.k(paramParameters, "p");
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(258897);
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
              localObject = this.laS;
              if (localObject == null) {
                break label568;
              }
              localObject = ((b.a)localObject).lgh;
              if (localObject == null) {
                break label568;
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
      n = i3 / 1000;
      i1 = i2 / 1000;
      Integer localInteger = ((b.a.c)localObject).lgl;
      if (localInteger != null)
      {
        m = localInteger.intValue();
        label384:
        if (n < m) {
          break label598;
        }
        localInteger = ((b.a.c)localObject).lgm;
        if (localInteger == null) {
          break label580;
        }
        m = localInteger.intValue();
        label410:
        if (n > m) {
          break label598;
        }
        localInteger = ((b.a.c)localObject).lgl;
        if (localInteger == null) {
          break label586;
        }
        m = localInteger.intValue();
        label436:
        if (i1 < m) {
          break label598;
        }
        localInteger = ((b.a.c)localObject).lgm;
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
        localInteger = ((b.a.c)localObject).lgn;
        if (localInteger == null) {
          break label604;
        }
        m = localInteger.intValue();
        label496:
        i1 = Math.abs(m - i1);
        localObject = ((b.a.c)localObject).lgn;
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
      Log.i(aXE(), "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(30) });
      if ((paramInt == 2147483647) || (i == 2147483647))
      {
        AppMethodBeat.o(258897);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(paramInt, i);
        Log.i(aXE(), "set fps range %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        AppMethodBeat.o(258897);
        return;
      }
      catch (Exception paramParameters)
      {
        Log.i(aXE(), "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(258897);
        return;
      }
    }
  }
  
  protected final boolean a(w paramw)
  {
    AppMethodBeat.i(258902);
    if (paramw == null)
    {
      AppMethodBeat.o(258902);
      return false;
    }
    for (;;)
    {
      Camera.Parameters localParameters;
      try
      {
        localParameters = paramw.avd();
        kotlin.g.b.p.j(localParameters, "p");
        List localList = localParameters.getSupportedFocusModes();
        localObject = this.laS;
        if (localObject != null)
        {
          localObject = ((b.a)localObject).lgg;
          if (localObject != null)
          {
            localObject = (b.a.b)((HashMap)localObject).get(Integer.valueOf(aYi()));
            if (localObject != null)
            {
              localObject = ((b.a.b)localObject).lgk;
              if (localObject != null)
              {
                Iterator localIterator = ((Iterable)localObject).iterator();
                if (localIterator.hasNext())
                {
                  String str = (String)localIterator.next();
                  if ((localList != null) && (localList.contains(OG(str))))
                  {
                    Log.i(this.TAG, "support ".concat(String.valueOf(str)));
                    localParameters.setFocusMode(OG(str));
                    this.laK.lbS = localParameters.getFocusMode();
                    paramw.c(localParameters);
                    AppMethodBeat.o(258902);
                    return true;
                  }
                  localObject = this.laS;
                  if (localObject == null) {
                    break label351;
                  }
                  localObject = ((b.a)localObject).lgg;
                  if (localObject == null) {
                    break label351;
                  }
                  localObject = (b.a.b)((HashMap)localObject).get(Integer.valueOf(aYi()));
                  if (localObject == null) {
                    break label351;
                  }
                  localObject = ((b.a.b)localObject).lgk;
                  if (localObject == null) {
                    break label351;
                  }
                  localObject = (String)kotlin.a.j.lq((List)localObject);
                  if (kotlin.g.b.p.h(localObject, str))
                  {
                    Log.e(this.TAG, "all of the focus-mode are not supported yet");
                    AppMethodBeat.o(258902);
                    return false;
                  }
                  Log.e(this.TAG, "not support ".concat(String.valueOf(str)));
                  continue;
                }
              }
            }
          }
        }
        this.laK.lbS = localParameters.getFocusMode();
      }
      catch (Exception paramw)
      {
        Log.i(this.TAG, "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
        AppMethodBeat.o(258902);
        return false;
      }
      paramw.c(localParameters);
      AppMethodBeat.o(258902);
      return true;
      label351:
      Object localObject = null;
    }
  }
  
  public final void aYd()
  {
    AppMethodBeat.i(258889);
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
          break label149;
        }
        localObject2 = ((b.a.c)localObject2).lgn;
        if (localObject2 == null) {
          break label149;
        }
        i = ((Integer)localObject2).intValue();
        ur(i);
        localObject2 = this.jqD;
        localObject1 = (b.a.c)((HashMap)localObject1).get(Integer.valueOf(aYi()));
        if (localObject1 == null) {
          break label155;
        }
        localObject1 = ((b.a.c)localObject1).lgo;
        if (localObject1 == null) {
          break label155;
        }
      }
    }
    label149:
    label155:
    for (boolean bool = ((Boolean)localObject1).booleanValue();; bool = false)
    {
      a((w)localObject2, bool);
      b(this.jqD);
      c(this.jqD);
      a(this.jqD);
      AppMethodBeat.o(258889);
      return;
      i = 15;
      break;
    }
  }
  
  public final void aYe() {}
  
  public final b aYf()
  {
    boolean bool = true;
    AppMethodBeat.i(258891);
    Log.printInfoStack(this.TAG, "generateCameraConfig", new Object[0]);
    if (this.jqD == null)
    {
      Log.i(this.TAG, "generateCameraConfig, camera is null!!");
      AppMethodBeat.o(258891);
      return null;
    }
    if (!aXQ())
    {
      Log.i(this.TAG, "generateCameraConfig, camera not previewing");
      AppMethodBeat.o(258891);
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
      AppMethodBeat.o(258891);
      return localObject;
      i = 0;
      break;
      i = 0;
      break;
      label257:
      bool = false;
    }
  }
  
  public final void aYh()
  {
    AppMethodBeat.i(258887);
    Object localObject1 = this.laS;
    Object localObject3;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((b.a)localObject1).lgj;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
        localObject1 = Boolean.valueOf(((HashSet)localObject1).contains(b.b.aZv()));
        if ((localObject1 != null) && (!kotlin.g.b.p.h(localObject1, Boolean.FALSE))) {
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
        if (this.jqD != null) {
          try
          {
            localObject1 = this.jqD;
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            localObject1 = ((w)localObject1).avd();
            Log.i(this.TAG, "setPreviewCallbackImpl");
            i = this.laR.wAw;
            int j = this.laR.wAx;
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject1).getPreviewFormat()) * (i * j) / 8;
            i = 0;
            while (i < 5)
            {
              localObject1 = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(j));
              localObject3 = this.jqD;
              if (localObject3 == null) {
                kotlin.g.b.p.iCn();
              }
              ((w)localObject3).aj((byte[])localObject1);
              i += 1;
            }
            aYb().reset();
            aYc().reset();
            this.lbo.reset();
            this.lbp.reset();
            this.lbq.reset();
            localObject1 = this.jqD;
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            ((w)localObject1).b((Camera.PreviewCallback)new a(this));
            AppMethodBeat.o(258887);
            return;
          }
          catch (Exception localException)
          {
            Log.e(this.TAG, "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
          }
        }
        AppMethodBeat.o(258887);
        return;
      }
      AppMethodBeat.o(258887);
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
    AppMethodBeat.i(258884);
    long l = Util.currentTicks();
    Log.i(this.TAG, "start startPreviewWithGPU,Looper.myLooper(): " + Looper.myLooper() + "  ,surfaceTexture:" + paramSurfaceTexture + ", surface:" + paramSurfaceHolder);
    if (aXQ())
    {
      Log.i(this.TAG, "startPreviewWithGPU, camera previewing");
      AppMethodBeat.o(258884);
      return;
    }
    try
    {
      aYm();
      aYd();
      aYh();
      if (a(paramSurfaceTexture, paramSurfaceHolder)) {
        a(a.a.lbb);
      }
      Log.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      AppMethodBeat.o(258884);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        Log.e(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramSurfaceTexture = f.laB;
        f.aVQ();
      }
    }
  }
  
  public final boolean b(w paramw)
  {
    AppMethodBeat.i(258903);
    if (paramw == null)
    {
      AppMethodBeat.o(258903);
      return false;
    }
    Object localObject = this.laS;
    if (localObject != null)
    {
      localObject = ((b.a)localObject).lgi;
      if (localObject != null)
      {
        localObject = (b.a.d)((HashMap)localObject).get(Integer.valueOf(aYi()));
        if (localObject != null)
        {
          localObject = ((b.a.d)localObject).lgp;
          if (localObject == null) {}
        }
      }
    }
    for (int i = ((Number)localObject).intValue();; i = 17) {
      try
      {
        Log.i(this.TAG, "safeSetPreviewFormat");
        localObject = paramw.avd();
        kotlin.g.b.p.j(localObject, "p");
        List localList = ((Camera.Parameters)localObject).getSupportedPreviewFormats();
        if ((localList == null) || (!localList.contains(Integer.valueOf(i)))) {
          Log.e(this.TAG, "not support ".concat(String.valueOf(i)));
        }
        ((Camera.Parameters)localObject).setPreviewFormat(i);
        paramw.c((Camera.Parameters)localObject);
        AppMethodBeat.o(258903);
        return true;
      }
      catch (Exception paramw)
      {
        Log.i(this.TAG, "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
        AppMethodBeat.o(258903);
      }
    }
    return false;
  }
  
  public final Point fJ(boolean paramBoolean)
  {
    AppMethodBeat.i(258895);
    Object localObject = this.jqD;
    if (localObject != null)
    {
      localObject = ((w)localObject).avd();
      if (localObject == null) {}
    }
    for (localObject = ((Camera.Parameters)localObject).getPreviewSize();; localObject = null)
    {
      if (localObject != null) {
        Log.i(this.TAG, "size is " + ((Camera.Size)localObject).width + " and " + ((Camera.Size)localObject).height + " and " + this.laR.wAw + " and " + this.laR.wAx + ' ');
      }
      localObject = new Point(this.laR.wAw, this.laR.wAx);
      AppMethodBeat.o(258895);
      return localObject;
    }
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(258892);
    Object localObject = this.laR;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.p)localObject).wAx);; localObject = null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(258892);
      return i;
    }
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(258893);
    Object localObject = this.laR;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((com.tencent.mm.plugin.mmsight.model.p)localObject).wAw);; localObject = null)
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(258893);
      return i;
    }
  }
  
  public final void k(boolean paramBoolean, int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "ca", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/VoipCommonCamera1$setPreviewCallbackImplInGPUCrop$2$1"})
  static final class a
    implements Camera.PreviewCallback
  {
    a(g paramg) {}
    
    public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      boolean bool = false;
      AppMethodBeat.i(258230);
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.length != 0) {
          break label41;
        }
      }
      label41:
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(g.a(this.lbK), "onPreviewFrame, frame data is null!!");
        AppMethodBeat.o(258230);
        return;
      }
      if ((!this.lbK.lbr) && (this.lbK.lbj.size() > 0))
      {
        paramCamera = this.lbK.laS;
        if (paramCamera != null)
        {
          paramCamera = paramCamera.lgj;
          if (paramCamera != null)
          {
            b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.lge;
            paramCamera = Boolean.valueOf(paramCamera.contains(b.b.aZw()));
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
          if (!this.lbK.laM)
          {
            i = this.lbK.laR.wAw;
            int j = this.lbK.laR.wAx;
            paramCamera = this.lbK.lbk;
            if (paramCamera == null) {
              kotlin.g.b.p.iCn();
            }
            if (paramCamera.fSM != 270)
            {
              paramCamera = this.lbK.lbk;
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
        }
        this.lbK.aq(paramArrayOfByte);
        this.lbK.lbt = paramArrayOfByte;
        paramCamera = this.lbK.jqD;
        if (paramCamera == null) {
          kotlin.g.b.p.iCn();
        }
        paramCamera.aj(paramArrayOfByte);
        AppMethodBeat.o(258230);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.g
 * JD-Core Version:    0.7.0.1
 */