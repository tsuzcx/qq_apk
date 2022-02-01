package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;

public final class w
{
  private static final Object fHG;
  
  static
  {
    AppMethodBeat.i(155764);
    fHG = new Object();
    AppMethodBeat.o(155764);
  }
  
  public static v b(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155761);
    if (d.kZ(28)) {
      try
      {
        v localv = new v(c(paramInt, paramLooper));
        AppMethodBeat.o(155761);
        return localv;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.MMCamera", localException, "opnImpl error, try camera directly, myLooper: %s", new Object[] { Looper.myLooper() });
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
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(155759);
        try
        {
          if (this.fHH >= 0) {
            arrayOfCamera[0] = Camera.open(this.fHH);
          }
        }
        catch (Exception localException1)
        {
          synchronized (w.fHG)
          {
            try
            {
              for (;;)
              {
                w.fHG.notifyAll();
                ac.i("MicroMsg.MMCamera", "openCamera notifyAll");
                AppMethodBeat.o(155759);
                return;
                arrayOfCamera[0] = Camera.open();
              }
              localException1 = localException1;
              ac.printErrStackTrace("MicroMsg.MMCamera", localException1, "syncCreateCamera error in new free thread", new Object[0]);
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.MMCamera", localException2, "MMCamera_openLooperNull notify error", new Object[0]);
              }
            }
          }
        }
      }
    });
    paramLooper = fHG;
    if (arrayOfCamera[0] == null) {}
    try
    {
      fHG.wait();
      ac.i("MicroMsg.MMCamera", "openCamera wait finish");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.MMCamera", localException, "MMCamera_openLooperNull wait error", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.w
 * JD-Core Version:    0.7.0.1
 */