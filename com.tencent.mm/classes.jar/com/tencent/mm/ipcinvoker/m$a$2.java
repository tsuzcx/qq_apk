package com.tencent.mm.ipcinvoker;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

final class m$a$2
  extends ScheduledThreadPoolExecutor
{
  m$a$2(m.a parama, int paramInt, ThreadFactory paramThreadFactory)
  {
    super(paramInt, paramThreadFactory);
  }
  
  public final void execute(final Runnable paramRunnable)
  {
    super.execute(new Runnable()
    {
      public final void run()
      {
        try
        {
          paramRunnable.run();
          return;
        }
        catch (Throwable localThrowable)
        {
          Thread.UncaughtExceptionHandler localUncaughtExceptionHandler2 = Thread.currentThread().getUncaughtExceptionHandler();
          Thread.UncaughtExceptionHandler localUncaughtExceptionHandler1 = localUncaughtExceptionHandler2;
          if (localUncaughtExceptionHandler2 == null) {
            localUncaughtExceptionHandler1 = Thread.getDefaultUncaughtExceptionHandler();
          }
          if (localUncaughtExceptionHandler1 != null) {
            localUncaughtExceptionHandler1.uncaughtException(Thread.currentThread(), localThrowable);
          }
          throw localThrowable;
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.m.a.2
 * JD-Core Version:    0.7.0.1
 */