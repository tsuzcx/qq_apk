package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class g
{
  private Handler a;
  private Looper b;
  private boolean c;
  private Thread d;
  
  public g(String paramString)
  {
    AppMethodBeat.i(221373);
    paramString = new HandlerThread(paramString);
    this.c = true;
    paramString.start();
    this.b = paramString.getLooper();
    this.a = new Handler(this.b);
    this.d = paramString;
    AppMethodBeat.o(221373);
  }
  
  public Handler a()
  {
    return this.a;
  }
  
  public void a(final Runnable paramRunnable)
  {
    AppMethodBeat.i(221375);
    final boolean[] arrayOfBoolean = new boolean[1];
    if (Thread.currentThread().equals(this.d))
    {
      paramRunnable.run();
      AppMethodBeat.o(221375);
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
          AppMethodBeat.i(221381);
          paramRunnable.run();
          arrayOfBoolean[0] = true;
          synchronized (g.a(g.this))
          {
            g.a(g.this).notifyAll();
            AppMethodBeat.o(221381);
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
      AppMethodBeat.o(221375);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(221377);
    this.a.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(221377);
  }
  
  public void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(221376);
    this.a.post(paramRunnable);
    AppMethodBeat.o(221376);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(221374);
    if (this.c) {
      this.a.getLooper().quit();
    }
    super.finalize();
    AppMethodBeat.o(221374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.g
 * JD-Core Version:    0.7.0.1
 */