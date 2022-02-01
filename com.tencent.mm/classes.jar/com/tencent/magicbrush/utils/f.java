package com.tencent.magicbrush.utils;

import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class f
  implements Runnable
{
  public final FutureTask<?> eLr;
  
  public f(Runnable paramRunnable)
  {
    AppMethodBeat.i(140070);
    this.eLr = new FutureTask(paramRunnable, Integer.valueOf(0));
    AppMethodBeat.o(140070);
  }
  
  public <T> f(Callable<T> paramCallable)
  {
    AppMethodBeat.i(140071);
    this.eLr = new FutureTask(paramCallable);
    AppMethodBeat.o(140071);
  }
  
  public final boolean dA(long paramLong)
  {
    AppMethodBeat.i(140072);
    try
    {
      this.eLr.get(paramLong, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(140072);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      c.c.printStackTrace("MagicBrush.SyncTask", localInterruptedException, "await failed", new Object[0]);
      AppMethodBeat.o(140072);
      return false;
    }
    catch (ExecutionException localExecutionException)
    {
      c.c.printStackTrace("MagicBrush.SyncTask", localExecutionException, "execute failed", new Object[0]);
      AppMethodBeat.o(140072);
      return false;
    }
    catch (TimeoutException localTimeoutException)
    {
      c.c.printStackTrace("MagicBrush.SyncTask", localTimeoutException, "execute timeout", new Object[0]);
      AppMethodBeat.o(140072);
    }
    return false;
  }
  
  public final <T> T get()
  {
    AppMethodBeat.i(140073);
    try
    {
      Object localObject = this.eLr.get();
      AppMethodBeat.o(140073);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      c.c.printStackTrace("MagicBrush.SyncTask", localInterruptedException, "await failed", new Object[0]);
      AppMethodBeat.o(140073);
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        c.c.printStackTrace("MagicBrush.SyncTask", localExecutionException, "execute failed", new Object[0]);
      }
    }
  }
  
  public void run()
  {
    AppMethodBeat.i(140074);
    this.eLr.run();
    AppMethodBeat.o(140074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.utils.f
 * JD-Core Version:    0.7.0.1
 */