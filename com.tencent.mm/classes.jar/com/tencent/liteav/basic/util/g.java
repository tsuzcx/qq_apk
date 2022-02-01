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
    AppMethodBeat.i(222111);
    paramString = new HandlerThread(paramString);
    this.c = true;
    paramString.start();
    this.b = paramString.getLooper();
    this.a = new Handler(this.b);
    this.d = paramString;
    AppMethodBeat.o(222111);
  }
  
  public Handler a()
  {
    return this.a;
  }
  
  public void a(final Runnable paramRunnable)
  {
    AppMethodBeat.i(222113);
    final boolean[] arrayOfBoolean = new boolean[1];
    if (Thread.currentThread().equals(this.d))
    {
      paramRunnable.run();
      AppMethodBeat.o(222113);
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
          AppMethodBeat.i(222119);
          paramRunnable.run();
          arrayOfBoolean[0] = true;
          synchronized (g.a(g.this))
          {
            g.a(g.this).notifyAll();
            AppMethodBeat.o(222119);
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
      AppMethodBeat.o(222113);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(222115);
    this.a.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(222115);
  }
  
  public void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(222114);
    this.a.post(paramRunnable);
    AppMethodBeat.o(222114);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(222112);
    if (this.c) {
      this.a.getLooper().quit();
    }
    super.finalize();
    AppMethodBeat.o(222112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.util.g
 * JD-Core Version:    0.7.0.1
 */