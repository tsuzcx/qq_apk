package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
{
  private static final Object jte;
  
  static
  {
    AppMethodBeat.i(155764);
    jte = new Object();
    AppMethodBeat.o(155764);
  }
  
  public static w b(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155761);
    if (d.qV(28)) {
      try
      {
        w localw = new w(c(paramInt, paramLooper));
        AppMethodBeat.o(155761);
        return localw;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MMCamera", localException, "opnImpl error, try camera directly, myLooper: %s", new Object[] { Looper.myLooper() });
        if (Looper.myLooper() == null)
        {
          paramLooper = new w(d(paramInt, paramLooper));
          AppMethodBeat.o(155761);
          return paramLooper;
        }
        paramLooper = new w(Camera.open(paramInt));
        AppMethodBeat.o(155761);
        return paramLooper;
      }
    }
    paramLooper = new w(c(paramInt, paramLooper));
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
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(155759);
        try
        {
          if (this.jtf >= 0) {
            arrayOfCamera[0] = Camera.open(this.jtf);
          }
        }
        catch (Exception localException1)
        {
          synchronized (x.jte)
          {
            try
            {
              for (;;)
              {
                x.jte.notifyAll();
                Log.i("MicroMsg.MMCamera", "openCamera notifyAll");
                AppMethodBeat.o(155759);
                return;
                arrayOfCamera[0] = Camera.open();
              }
              localException1 = localException1;
              Log.printErrStackTrace("MicroMsg.MMCamera", localException1, "syncCreateCamera error in new free thread", new Object[0]);
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.MMCamera", localException2, "MMCamera_openLooperNull notify error", new Object[0]);
              }
            }
          }
        }
      }
    });
    paramLooper = jte;
    if (arrayOfCamera[0] == null) {}
    try
    {
      jte.wait();
      Log.i("MicroMsg.MMCamera", "openCamera wait finish");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMCamera", localException, "MMCamera_openLooperNull wait error", new Object[0]);
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
  
  public static w f(Looper paramLooper)
  {
    AppMethodBeat.i(155760);
    if (paramLooper == null)
    {
      paramLooper = new w(Camera.open());
      AppMethodBeat.o(155760);
      return paramLooper;
    }
    paramLooper = new w(d(-1, paramLooper));
    AppMethodBeat.o(155760);
    return paramLooper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.x
 * JD-Core Version:    0.7.0.1
 */