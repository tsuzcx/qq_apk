package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class f
  extends Handler
{
  public f(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public boolean a(Runnable paramRunnable)
  {
    AppMethodBeat.i(241260);
    boolean bool = a(paramRunnable, -1L);
    AppMethodBeat.o(241260);
    return bool;
  }
  
  public boolean a(final Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(241262);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    boolean bool = post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(239968);
        paramRunnable.run();
        localCountDownLatch.countDown();
        AppMethodBeat.o(239968);
      }
    });
    if ((!bool) || (paramLong > 0L)) {}
    try
    {
      localCountDownLatch.await(paramLong, TimeUnit.MILLISECONDS);
      for (;;)
      {
        AppMethodBeat.o(241262);
        return bool;
        localCountDownLatch.await();
      }
    }
    catch (InterruptedException paramRunnable)
    {
      for (;;)
      {
        Thread.currentThread().interrupt();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.f
 * JD-Core Version:    0.7.0.1
 */