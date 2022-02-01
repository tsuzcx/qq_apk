package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  private Handler a;
  private Looper b;
  private boolean c;
  private Thread d;
  
  public e(String paramString)
  {
    AppMethodBeat.i(14699);
    paramString = new HandlerThread(paramString);
    this.c = true;
    paramString.start();
    this.b = paramString.getLooper();
    this.a = new Handler(this.b);
    this.d = paramString;
    AppMethodBeat.o(14699);
  }
  
  public Handler a()
  {
    return this.a;
  }
  
  public void a(final Runnable paramRunnable)
  {
    AppMethodBeat.i(14701);
    final boolean[] arrayOfBoolean = new boolean[1];
    if (Thread.currentThread().equals(this.d))
    {
      paramRunnable.run();
      AppMethodBeat.o(14701);
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
          AppMethodBeat.i(14720);
          paramRunnable.run();
          arrayOfBoolean[0] = true;
          synchronized (e.a(e.this))
          {
            e.a(e.this).notifyAll();
            AppMethodBeat.o(14720);
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
      AppMethodBeat.o(14701);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(14703);
    this.a.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(14703);
  }
  
  public void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(14702);
    this.a.post(paramRunnable);
    AppMethodBeat.o(14702);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(14700);
    if (this.c) {
      this.a.getLooper().quit();
    }
    super.finalize();
    AppMethodBeat.o(14700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.e
 * JD-Core Version:    0.7.0.1
 */