package androidx.g.b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class c<Params, Progress, Result>
{
  private static final ThreadFactory abe = new c.1();
  private static final BlockingQueue<Runnable> abf = new LinkedBlockingQueue(10);
  public static final Executor abg;
  private static b abh;
  private static volatile Executor abi;
  final d<Params, Result> abj = new d()
  {
    public final Result call()
    {
      AppMethodBeat.i(188392);
      c.this.abn.set(true);
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject2 = localObject4;
      Object localObject1 = localObject5;
      try
      {
        Process.setThreadPriority(10);
        localObject2 = localObject4;
        localObject1 = localObject5;
        localObject4 = c.this.jq();
        localObject2 = localObject4;
        localObject1 = localObject4;
        Binder.flushPendingCommands();
        return localObject4;
      }
      catch (Throwable localThrowable)
      {
        localObject1 = localObject2;
        c.this.abm.set(true);
        localObject1 = localObject2;
        AppMethodBeat.o(188392);
        localObject1 = localObject2;
        throw localThrowable;
      }
      finally
      {
        c.this.O(localObject1);
        AppMethodBeat.o(188392);
      }
    }
  };
  final FutureTask<Result> abk = new FutureTask(this.abj)
  {
    protected final void done()
    {
      AppMethodBeat.i(188402);
      try
      {
        Object localObject = get();
        c.this.N(localObject);
        AppMethodBeat.o(188402);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        AppMethodBeat.o(188402);
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        RuntimeException localRuntimeException1 = new RuntimeException("An error occurred while executing doInBackground()", localExecutionException.getCause());
        AppMethodBeat.o(188402);
        throw localRuntimeException1;
      }
      catch (CancellationException localCancellationException)
      {
        c.this.N(null);
        AppMethodBeat.o(188402);
        return;
      }
      catch (Throwable localThrowable)
      {
        RuntimeException localRuntimeException2 = new RuntimeException("An error occurred while executing doInBackground()", localThrowable);
        AppMethodBeat.o(188402);
        throw localRuntimeException2;
      }
    }
  };
  volatile c.c abl = c.c.abt;
  final AtomicBoolean abm = new AtomicBoolean();
  final AtomicBoolean abn = new AtomicBoolean();
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, abf, abe);
    abg = localThreadPoolExecutor;
    abi = localThreadPoolExecutor;
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (abh == null) {
        abh = new b();
      }
      b localb = abh;
      return localb;
    }
    finally {}
  }
  
  final void N(Result paramResult)
  {
    if (!this.abn.get()) {
      O(paramResult);
    }
  }
  
  final Result O(Result paramResult)
  {
    getHandler().obtainMessage(1, new a(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  final void P(Result paramResult)
  {
    if (this.abm.get()) {
      onCancelled(paramResult);
    }
    for (;;)
    {
      this.abl = c.c.abv;
      return;
      onPostExecute(paramResult);
    }
  }
  
  protected abstract Result jq();
  
  protected void onCancelled(Result paramResult) {}
  
  protected void onPostExecute(Result paramResult) {}
  
  static final class a<Data>
  {
    final c abr;
    final Data[] abs;
    
    a(c paramc, Data... paramVarArgs)
    {
      this.abr = paramc;
      this.abs = paramVarArgs;
    }
  }
  
  static final class b
    extends Handler
  {
    b()
    {
      super();
      AppMethodBeat.i(188407);
      AppMethodBeat.o(188407);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(188408);
      c.a locala = (c.a)paramMessage.obj;
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(188408);
        return;
        locala.abr.P(locala.abs[0]);
      }
    }
  }
  
  static abstract class d<Params, Result>
    implements Callable<Result>
  {
    Params[] abx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.g.b.c
 * JD-Core Version:    0.7.0.1
 */