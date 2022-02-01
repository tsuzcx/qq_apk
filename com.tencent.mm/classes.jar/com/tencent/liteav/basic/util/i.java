package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class i
{
  private Handler a;
  private Looper b;
  private boolean c;
  private Thread d;
  
  public i(String paramString)
  {
    AppMethodBeat.i(240888);
    paramString = new HandlerThread(paramString);
    this.c = true;
    paramString.start();
    this.b = paramString.getLooper();
    this.a = new Handler(this.b);
    this.d = paramString;
    AppMethodBeat.o(240888);
  }
  
  public Handler a()
  {
    return this.a;
  }
  
  public void a(final Runnable paramRunnable)
  {
    AppMethodBeat.i(240894);
    final boolean[] arrayOfBoolean = new boolean[1];
    if (Thread.currentThread().equals(this.d))
    {
      paramRunnable.run();
      AppMethodBeat.o(240894);
      return;
    }
    Handler localHandler = this.a;
    arrayOfBoolean[0] = false;
    try
    {
      this.a.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(241004);
          paramRunnable.run();
          arrayOfBoolean[0] = true;
          synchronized (i.a(i.this))
          {
            i.a(i.this).notifyAll();
            AppMethodBeat.o(241004);
            return;
          }
        }
      });
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
      AppMethodBeat.o(240894);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(240899);
    this.a.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(240899);
  }
  
  public void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(240896);
    this.a.post(paramRunnable);
    AppMethodBeat.o(240896);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(240891);
    if (this.c) {
      this.a.getLooper().quit();
    }
    super.finalize();
    AppMethodBeat.o(240891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.i
 * JD-Core Version:    0.7.0.1
 */