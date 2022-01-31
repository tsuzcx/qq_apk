package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.List;

public final class e$c
  extends ak
{
  int eZY = 0;
  boolean eZZ = false;
  boolean faa = false;
  boolean fab = false;
  float fac;
  float fad;
  int fae;
  int faf;
  
  public e$c(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private static Rect b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76474);
    paramFloat3 = 80.0F * paramFloat3;
    paramFloat1 /= paramInt1;
    paramFloat2 /= paramInt2;
    paramFloat1 = paramFloat1 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    paramFloat2 = paramFloat2 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    Object localObject = new RectF();
    ((RectF)localObject).set(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat3 + paramFloat2);
    localObject = new Rect(zs(Math.round(((RectF)localObject).left)), zs(Math.round(((RectF)localObject).top)), zs(Math.round(((RectF)localObject).right)), zs(Math.round(((RectF)localObject).bottom)));
    AppMethodBeat.o(76474);
    return localObject;
  }
  
  private static int f(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(76476);
    if (paramParameters == null)
    {
      AppMethodBeat.o(76476);
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
        ab.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
        int i = 0;
      }
    }
    AppMethodBeat.o(76476);
    return i;
  }
  
  private static int zs(int paramInt)
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
  
  final void e(u paramu)
  {
    AppMethodBeat.i(76475);
    if (paramu == null)
    {
      ab.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
      AppMethodBeat.o(76475);
      return;
    }
    if (!e.oHn)
    {
      ab.w("MicroMsg.MMSightCamera", "auto focus not back");
      AppMethodBeat.o(76475);
      return;
    }
    e.oHn = false;
    try
    {
      ab.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
      paramu.cancelAutoFocus();
      paramu.autoFocus(this.oHp.fah);
      AppMethodBeat.o(76475);
      return;
    }
    catch (Exception paramu)
    {
      ab.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[] { paramu.getMessage() });
      e.oHn = true;
      AppMethodBeat.o(76475);
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int j = 1;
    AppMethodBeat.i(76477);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(76477);
      return;
      paramMessage = (u)paramMessage.obj;
      if ((this.fae == 0) || (this.faf == 0) || (d.fw(14)))
      {
        e(paramMessage);
        AppMethodBeat.o(76477);
        return;
      }
      float f1 = this.fac;
      float f2 = this.fad;
      int i = this.fae;
      j = this.faf;
      if (paramMessage == null)
      {
        ab.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
        AppMethodBeat.o(76477);
        return;
      }
      if (!e.oHn)
      {
        ab.w("MicroMsg.MMSightCamera", "auto focus not back");
        AppMethodBeat.o(76477);
        return;
      }
      e.oHn = false;
      try
      {
        paramMessage.cancelAutoFocus();
        ab.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
        Object localObject2 = b(f1, f2, 1.0F, i, j);
        localObject1 = b(f1, f2, 1.5F, i, j);
        ab.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
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
        paramMessage.autoFocus(this.oHp.fah);
        AppMethodBeat.o(76477);
        return;
      }
      catch (Exception paramMessage)
      {
        ab.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
        e.oHn = true;
        AppMethodBeat.o(76477);
        return;
      }
      if (this.fab)
      {
        AppMethodBeat.o(76477);
        return;
      }
      Object localObject1 = (Camera)paramMessage.obj;
      Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
      ab.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.eZZ), Integer.valueOf(this.eZY), Integer.valueOf(localParameters.getZoom()) });
      i = localParameters.getZoom() + this.eZY;
      if (this.eZZ)
      {
        int k = f(localParameters);
        if (i >= k)
        {
          i = k;
          label519:
          localParameters.setZoom(i);
        }
      }
      try
      {
        ((Camera)localObject1).setParameters(localParameters);
        label533:
        if (j == 0) {
          continue;
        }
        this.fae = 0;
        this.faf = 0;
        continue;
        paramMessage = obtainMessage(4353, paramMessage.obj);
        if (this.faa) {}
        for (long l = 10L;; l = 20L)
        {
          sendMessageDelayed(paramMessage, l);
          j = 0;
          break;
        }
        if (i <= 0)
        {
          i = 0;
          break label519;
        }
        paramMessage = obtainMessage(4353, paramMessage.obj);
        if (this.faa) {}
        for (l = 10L;; l = 20L)
        {
          sendMessageDelayed(paramMessage, l);
          j = 0;
          break;
        }
      }
      catch (Exception paramMessage)
      {
        break label533;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.e.c
 * JD-Core Version:    0.7.0.1
 */