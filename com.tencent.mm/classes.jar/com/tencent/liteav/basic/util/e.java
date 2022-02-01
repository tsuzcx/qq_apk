package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

public class e
  extends Handler
{
  public e(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public boolean a(final Runnable paramRunnable)
  {
    AppMethodBeat.i(187253);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    boolean bool = post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14720);
        paramRunnable.run();
        localCountDownLatch.countDown();
        AppMethodBeat.o(14720);
      }
    });
    if (bool) {}
    try
    {
      localCountDownLatch.await();
      AppMethodBeat.o(187253);
      return bool;
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
 * Qualified Name:     com.tencent.liteav.basic.util.e
 * JD-Core Version:    0.7.0.1
 */