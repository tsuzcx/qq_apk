package com.tencent.magicbrush.d;

import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class b
  implements Runnable
{
  private final FutureTask<?> bEf;
  
  public b(Runnable paramRunnable)
  {
    AppMethodBeat.i(116009);
    this.bEf = new FutureTask(paramRunnable, Integer.valueOf(0));
    AppMethodBeat.o(116009);
  }
  
  public <T> b(Callable<T> paramCallable)
  {
    AppMethodBeat.i(116010);
    this.bEf = new FutureTask(paramCallable);
    AppMethodBeat.o(116010);
  }
  
  public final void await()
  {
    AppMethodBeat.i(155609);
    try
    {
      this.bEf.get();
      AppMethodBeat.o(155609);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      c.c.printStackTrace("MagicBrush.SyncTask", localInterruptedException, "await failed", new Object[0]);
      AppMethodBeat.o(155609);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      c.c.printStackTrace("MagicBrush.SyncTask", localExecutionException, "execute failed", new Object[0]);
      AppMethodBeat.o(155609);
    }
  }
  
  public final <T> T get()
  {
    AppMethodBeat.i(116011);
    try
    {
      Object localObject = this.bEf.get();
      AppMethodBeat.o(116011);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      c.c.printStackTrace("MagicBrush.SyncTask", localInterruptedException, "await failed", new Object[0]);
      AppMethodBeat.o(116011);
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
    AppMethodBeat.i(116012);
    this.bEf.run();
    AppMethodBeat.o(116012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.magicbrush.d.b
 * JD-Core Version:    0.7.0.1
 */