package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

final class e$c
  extends ah
{
  float lvi;
  boolean mgx = false;
  int mhk = 0;
  boolean mhl = false;
  boolean mhm = false;
  float mhn;
  int mho;
  int mhp;
  
  public e$c(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private static Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    paramFloat3 = 80.0F * paramFloat3;
    paramFloat1 /= paramInt1;
    paramFloat2 /= paramInt2;
    paramFloat1 = paramFloat1 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    paramFloat2 = paramFloat2 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    RectF localRectF = new RectF();
    localRectF.set(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat3 + paramFloat2);
    return new Rect(tZ(Math.round(localRectF.left)), tZ(Math.round(localRectF.top)), tZ(Math.round(localRectF.right)), tZ(Math.round(localRectF.bottom)));
  }
  
  private static int c(Camera.Parameters paramParameters)
  {
    if (paramParameters == null) {
      return 0;
    }
    try
    {
      int j = paramParameters.getMaxZoom() / 2;
      i = j;
      if (j <= 0) {
        i = paramParameters.getMaxZoom();
      }
    }
    catch (Exception paramParameters)
    {
      for (;;)
      {
        y.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
        int i = 0;
      }
    }
    return i;
  }
  
  private static int tZ(int paramInt)
  {
    int i;
    if (paramInt > 1000) {
      i = 1000;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt >= -1000);
    return -1000;
  }
  
  final void f(Camera paramCamera)
  {
    if (paramCamera == null)
    {
      y.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
      return;
    }
    if (!e.mhb)
    {
      y.w("MicroMsg.MMSightCamera", "auto focus not back");
      return;
    }
    e.mhb = false;
    try
    {
      y.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
      paramCamera.cancelAutoFocus();
      paramCamera.autoFocus(this.mhf.mhc);
      return;
    }
    catch (Exception paramCamera)
    {
      y.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[] { paramCamera.getMessage() });
      e.mhb = true;
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int j = 1;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      paramMessage = (Camera)paramMessage.obj;
      if ((this.mho == 0) || (this.mhp == 0) || (d.gG(14)))
      {
        f(paramMessage);
        return;
      }
      float f1 = this.mhn;
      float f2 = this.lvi;
      int i = this.mho;
      j = this.mhp;
      if (paramMessage == null)
      {
        y.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
        return;
      }
      if (!e.mhb)
      {
        y.w("MicroMsg.MMSightCamera", "auto focus not back");
        return;
      }
      e.mhb = false;
      try
      {
        paramMessage.cancelAutoFocus();
        y.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
        Object localObject2 = a(f1, f2, 1.0F, i, j);
        localObject1 = a(f1, f2, 1.5F, i, j);
        y.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
        localParameters = paramMessage.getParameters();
        Object localObject3 = localParameters.getSupportedFocusModes();
        if ((localObject3 != null) && (((List)localObject3).contains("auto"))) {
          localParameters.setFocusMode("auto");
        }
        if (localParameters.getMaxNumFocusAreas() > 0)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(new Camera.Area((Rect)localObject2, 1000));
          localParameters.setFocusAreas((List)localObject3);
        }
        if (localParameters.getMaxNumMeteringAreas() > 0)
        {
          localObject2 = new ArrayList(1);
          ((ArrayList)localObject2).add(new Camera.Area((Rect)localObject1, 1000));
          localParameters.setMeteringAreas((List)localObject2);
        }
        paramMessage.setParameters(localParameters);
        paramMessage.autoFocus(this.mhf.mhc);
        return;
      }
      catch (Exception paramMessage)
      {
        y.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
        e.mhb = true;
        return;
      }
      if (this.mhm) {
        continue;
      }
      Object localObject1 = (Camera)paramMessage.obj;
      Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
      y.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.mgx), Integer.valueOf(this.mhk), Integer.valueOf(localParameters.getZoom()) });
      i = localParameters.getZoom() + this.mhk;
      if (this.mgx)
      {
        int k = c(localParameters);
        if (i >= k)
        {
          i = k;
          label475:
          localParameters.setZoom(i);
        }
      }
      try
      {
        ((Camera)localObject1).setParameters(localParameters);
        label489:
        if (j == 0) {
          continue;
        }
        this.mho = 0;
        this.mhp = 0;
        return;
        paramMessage = obtainMessage(4353, paramMessage.obj);
        if (this.mhl) {}
        for (long l = 10L;; l = 20L)
        {
          sendMessageDelayed(paramMessage, l);
          j = 0;
          break;
        }
        if (i <= 0)
        {
          i = 0;
          break label475;
        }
        paramMessage = obtainMessage(4353, paramMessage.obj);
        if (this.mhl) {}
        for (l = 10L;; l = 20L)
        {
          sendMessageDelayed(paramMessage, l);
          j = 0;
          break;
        }
      }
      catch (Exception paramMessage)
      {
        break label489;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.e.c
 * JD-Core Version:    0.7.0.1
 */