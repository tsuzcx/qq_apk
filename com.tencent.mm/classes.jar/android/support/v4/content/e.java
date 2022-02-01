package android.support.v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
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

abstract class e<Params, Progress, Result>
{
  private static final ThreadFactory Jj = new e.1();
  private static final BlockingQueue<Runnable> Jk = new LinkedBlockingQueue(10);
  private static b Jl;
  private static volatile Executor Jm;
  public static final Executor THREAD_POOL_EXECUTOR;
  final d<Params, Result> Jn = new d()
  {
    public final Result call()
    {
      e.this.Jr.set(true);
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject2 = localObject4;
      Object localObject1 = localObject5;
      try
      {
        Process.setThreadPriority(10);
        localObject2 = localObject4;
        localObject1 = localObject5;
        localObject4 = e.this.ew();
        localObject2 = localObject4;
        localObject1 = localObject4;
        Binder.flushPendingCommands();
        return localObject4;
      }
      catch (Throwable localThrowable)
      {
        localObject1 = localObject2;
        e.this.Jq.set(true);
        localObject1 = localObject2;
        throw localThrowable;
      }
      finally
      {
        e.this.o(localObject1);
      }
    }
  };
  final FutureTask<Result> Jo = new FutureTask(this.Jn)
  {
    protected final void done()
    {
      try
      {
        Object localObject = get();
        e.this.n(localObject);
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        throw new RuntimeException("An error occurred while executing doInBackground()", localExecutionException.getCause());
      }
      catch (CancellationException localCancellationException)
      {
        e.this.n(null);
        return;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException("An error occurred while executing doInBackground()", localThrowable);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  };
  volatile c Jp = c.Jx;
  final AtomicBoolean Jq = new AtomicBoolean();
  final AtomicBoolean Jr = new AtomicBoolean();
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, Jk, Jj);
    THREAD_POOL_EXECUTOR = localThreadPoolExecutor;
    Jm = localThreadPoolExecutor;
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (Jl == null) {
        Jl = new b();
      }
      b localb = Jl;
      return localb;
    }
    finally {}
  }
  
  protected abstract Result ew();
  
  final void n(Result paramResult)
  {
    if (!this.Jr.get()) {
      o(paramResult);
    }
  }
  
  final Result o(Result paramResult)
  {
    getHandler().obtainMessage(1, new a(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  protected void onCancelled(Result paramResult) {}
  
  protected void onPostExecute(Result paramResult) {}
  
  final void p(Result paramResult)
  {
    if (this.Jq.get()) {
      onCancelled(paramResult);
    }
    for (;;)
    {
      this.Jp = c.Jz;
      return;
      onPostExecute(paramResult);
    }
  }
  
  static final class a<Data>
  {
    final e Jv;
    final Data[] Jw;
    
    a(e parame, Data... paramVarArgs)
    {
      this.Jv = parame;
      this.Jw = paramVarArgs;
    }
  }
  
  static final class b
    extends Handler
  {
    b()
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      e.a locala = (e.a)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      locala.Jv.p(locala.Jw[0]);
    }
  }
  
  public static enum c
  {
    private c() {}
  }
  
  static abstract class d<Params, Result>
    implements Callable<Result>
  {
    Params[] JB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.content.e
 * JD-Core Version:    0.7.0.1
 */