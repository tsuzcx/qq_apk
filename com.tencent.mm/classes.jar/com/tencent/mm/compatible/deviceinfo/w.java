package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;

public final class w
{
  private static final Object gdo;
  
  static
  {
    AppMethodBeat.i(155764);
    gdo = new Object();
    AppMethodBeat.o(155764);
  }
  
  public static v b(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155761);
    if (d.lA(28)) {
      try
      {
        v localv = new v(c(paramInt, paramLooper));
        AppMethodBeat.o(155761);
        return localv;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MMCamera", localException, "opnImpl error, try camera directly, myLooper: %s", new Object[] { Looper.myLooper() });
        if (Looper.myLooper() == null)
        {
          paramLooper = new v(d(paramInt, paramLooper));
          AppMethodBeat.o(155761);
          return paramLooper;
        }
        paramLooper = new v(Camera.open(paramInt));
        AppMethodBeat.o(155761);
        return paramLooper;
      }
    }
    paramLooper = new v(c(paramInt, paramLooper));
    AppMethodBeat.o(155761);
    return paramLooper;
  }
  
  private static Camera c(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155762);
    if (paramLooper == null)
    {
      paramLooper = Camera.open(paramInt);
      AppMethodBeat.o(155762);
      return paramLooper;
    }
    paramLooper = d(paramInt, paramLooper);
    AppMethodBeat.o(155762);
    return paramLooper;
  }
  
  private static Camera d(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155763);
    if ((paramLooper == Looper.getMainLooper()) && (Looper.getMainLooper() == Looper.myLooper()))
    {
      if (paramInt >= 0) {}
      for (paramLooper = Camera.open(paramInt);; paramLooper = Camera.open())
      {
        AppMethodBeat.o(155763);
        return paramLooper;
      }
    }
    final Camera[] arrayOfCamera = new Camera[1];
    arrayOfCamera[0] = null;
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(155759);
        try
        {
          if (this.gdp >= 0) {
            arrayOfCamera[0] = Camera.open(this.gdp);
          }
        }
        catch (Exception localException1)
        {
          synchronized (w.gdo)
          {
            try
            {
              for (;;)
              {
                w.gdo.notifyAll();
                ae.i("MicroMsg.MMCamera", "openCamera notifyAll");
                AppMethodBeat.o(155759);
                return;
                arrayOfCamera[0] = Camera.open();
              }
              localException1 = localException1;
              ae.printErrStackTrace("MicroMsg.MMCamera", localException1, "syncCreateCamera error in new free thread", new Object[0]);
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.MMCamera", localException2, "MMCamera_openLooperNull notify error", new Object[0]);
              }
            }
          }
        }
      }
    });
    paramLooper = gdo;
    if (arrayOfCamera[0] == null) {}
    try
    {
      gdo.wait();
      ae.i("MicroMsg.MMCamera", "openCamera wait finish");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.MMCamera", localException, "MMCamera_openLooperNull wait error", new Object[0]);
      }
    }
    finally
    {
      AppMethodBeat.o(155763);
    }
    paramLooper = arrayOfCamera[0];
    AppMethodBeat.o(155763);
    return paramLooper;
  }
  
  public static v e(Looper paramLooper)
  {
    AppMethodBeat.i(155760);
    if (paramLooper == null)
    {
      paramLooper = new v(Camera.open());
      AppMethodBeat.o(155760);
      return paramLooper;
    }
    paramLooper = new v(d(-1, paramLooper));
    AppMethodBeat.o(155760);
    return paramLooper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.w
 * JD-Core Version:    0.7.0.1
 */