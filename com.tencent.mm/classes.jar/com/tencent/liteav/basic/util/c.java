package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private Handler a;
  private Looper b;
  private boolean c;
  private Thread d;
  
  public c(String paramString)
  {
    AppMethodBeat.i(66041);
    paramString = new HandlerThread(paramString);
    this.c = true;
    paramString.start();
    this.b = paramString.getLooper();
    this.a = new Handler(this.b);
    this.d = paramString;
    AppMethodBeat.o(66041);
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(66043);
    boolean[] arrayOfBoolean = new boolean[1];
    if (Thread.currentThread().equals(this.d))
    {
      paramRunnable.run();
      AppMethodBeat.o(66043);
      return;
    }
    Handler localHandler = this.a;
    arrayOfBoolean[0] = false;
    try
    {
      this.a.post(new c.1(this, paramRunnable, arrayOfBoolean));
      for (;;)
      {
        int i = arrayOfBoolean[0];
        if (i != 0) {
          break;
        }
        try
        {
          this.a.wait();
        }
        catch (Exception paramRunnable) {}
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(66043);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(146633);
    this.a.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(146633);
  }
  
  public void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(66044);
    this.a.post(paramRunnable);
    AppMethodBeat.o(66044);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(66042);
    if (this.c) {
      this.a.getLooper().quit();
    }
    super.finalize();
    AppMethodBeat.o(66042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.basic.util.c
 * JD-Core Version:    0.7.0.1
 */