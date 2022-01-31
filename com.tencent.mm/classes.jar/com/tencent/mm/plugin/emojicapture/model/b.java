package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Looper;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends e
{
  private final String TAG = "MicroMsg.EmojiCaptureCamera";
  private final int jki = 540;
  private final int jkj = 960;
  private Point jkk = new Point();
  
  public b(VideoTransPara paramVideoTransPara)
  {
    super(null, 0);
    this.mgW = paramVideoTransPara;
    this.mgW.width = this.jki;
    this.mgW.height = this.jkj;
  }
  
  private final boolean a(Camera paramCamera)
  {
    if (paramCamera == null) {
      return false;
    }
    for (;;)
    {
      Camera.Parameters localParameters;
      boolean bool;
      try
      {
        localParameters = paramCamera.getParameters();
        localPoint = com.tencent.mm.plugin.mmsight.d.dL(this.mContext);
        if (this.jXx.rotate == 90) {
          break label211;
        }
        if (this.jXx.rotate != 270) {
          break label108;
        }
      }
      catch (Exception paramCamera)
      {
        y.i(this.TAG, "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), paramCamera.getMessage() });
        return false;
      }
      Point localPoint = com.tencent.mm.plugin.mmsight.model.g.a(localParameters, localPoint, 720, bool).jkk;
      if (localPoint == null)
      {
        y.i(this.TAG, "find preview size failed");
        return false;
        label108:
        bool = false;
      }
      else
      {
        this.mgw.jSV = localPoint.x;
        this.mgw.jSW = localPoint.y;
        this.mgG = localPoint;
        this.jkk = localPoint;
        this.mgH = null;
        y.i(this.TAG, "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[] { localPoint, this.mgG, this.mgH });
        localParameters.setPreviewSize(this.mgw.jSV, this.mgw.jSW);
        paramCamera.setParameters(localParameters);
        return true;
        label211:
        bool = true;
      }
    }
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture)
  {
    a.d.b.g.k(paramContext, "activity");
    a.d.b.g.k(paramSurfaceTexture, "surface");
    y.i(this.TAG, "switch camera without crop, current useBack: %s", new Object[] { Boolean.valueOf(this.mhe) });
    try
    {
      biN();
      if (!this.mhe) {}
      for (boolean bool = true;; bool = false)
      {
        r(paramContext, bool);
        g(paramSurfaceTexture);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      y.e(this.TAG, "switchCamera error: %s", new Object[] { paramContext });
    }
  }
  
  public final Point aKa()
  {
    if (this.mgH != null)
    {
      Point localPoint = this.mgH;
      a.d.b.g.j(localPoint, "cropSize");
      return localPoint;
    }
    return this.jkk;
  }
  
  public final int g(SurfaceTexture paramSurfaceTexture)
  {
    a.d.b.g.k(paramSurfaceTexture, "surface");
    long l = bk.UZ();
    this.mgO = false;
    y.i(this.TAG, "start preview, previewing %B, %s", new Object[] { Boolean.valueOf(this.mgy), Looper.myLooper() });
    if (this.mgy) {
      return 0;
    }
    for (;;)
    {
      try
      {
        a(this.dwJ);
        localObject = k.bjA();
        a.d.b.g.j(localObject, "MMSightController.getInstance()");
        if (((k)localObject).bjB() == null) {
          break label623;
        }
        localObject = k.bjA();
        a.d.b.g.j(localObject, "MMSightController.getInstance()");
        localInteger = Integer.valueOf(((k)localObject).bjB().mfA);
        String str = this.TAG;
        if (q.dyd.dws == 1)
        {
          localObject = "Range";
          if (q.dyd.dwt != 1) {
            break label640;
          }
          bool1 = true;
          if (q.dyd.dwu != 1) {
            break label646;
          }
          bool2 = true;
          if (q.dyd.dwv != 1) {
            break label652;
          }
          bool3 = true;
          if (q.dyd.dww != 1) {
            break label658;
          }
          bool4 = true;
          y.i(str, "startPreview surface:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if ((q.dyd.dws == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            b(this.dwJ, false);
            if ((q.dyd.dwt == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              c(this.dwJ);
            }
            if ((q.dyk.dyA != -1) && (q.dyk.dyA == 1) && (com.tencent.mm.compatible.util.d.gH(14))) {
              b(this.dwJ);
            }
            if ((q.dyd.dwv == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              d(this.dwJ);
            }
            if ((q.dyd.dww == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            e(this.dwJ);
            biK();
            this.dwJ.setPreviewTexture(paramSurfaceTexture);
            this.dwJ.startPreview();
            if (!j.mhB.mhN) {
              break label603;
            }
            if ((q.dyd.dwv == 0) && (this.aVT != null) && (this.mgB != null)) {
              this.aVT.registerListener((SensorEventListener)this, this.mgB, 2);
            }
            this.mgy = true;
            y.i(this.TAG, "start preview end, use %dms %s", new Object[] { Long.valueOf(bk.cp(l)), Looper.myLooper() });
            return 0;
          }
        }
        else
        {
          if (q.dyd.dwr != 1) {
            break label632;
          }
          localObject = "Fix";
          continue;
        }
        if ((q.dyd.dwr != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        b(this.dwJ, true);
        continue;
        this.aVT.registerListener((SensorEventListener)this, this.mgB, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        y.i(this.TAG, "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        return 0 - com.tencent.mm.compatible.util.g.getLine();
      }
      label603:
      continue;
      label623:
      Integer localInteger = Integer.valueOf(0);
      continue;
      label632:
      Object localObject = "Error";
      continue;
      label640:
      boolean bool1 = false;
      continue;
      label646:
      boolean bool2 = false;
      continue;
      label652:
      boolean bool3 = false;
      continue;
      label658:
      boolean bool4 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b
 * JD-Core Version:    0.7.0.1
 */