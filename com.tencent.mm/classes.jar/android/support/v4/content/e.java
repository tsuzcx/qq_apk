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
  private static final ThreadFactory Gi = new e.1();
  private static final BlockingQueue<Runnable> Gj = new LinkedBlockingQueue(10);
  private static b Gk;
  private static volatile Executor Gl;
  public static final Executor THREAD_POOL_EXECUTOR;
  final d<Params, Result> Gm = new d()
  {
    public final Result call()
    {
      e.this.Gq.set(true);
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject2 = localObject4;
      Object localObject1 = localObject5;
      try
      {
        Process.setThreadPriority(10);
        localObject2 = localObject4;
        localObject1 = localObject5;
        localObject4 = e.this.dQ();
        localObject2 = localObject4;
        localObject1 = localObject4;
        Binder.flushPendingCommands();
        return localObject4;
      }
      catch (Throwable localThrowable)
      {
        localObject1 = localObject2;
        e.this.Gp.set(true);
        localObject1 = localObject2;
        throw localThrowable;
      }
      finally
      {
        e.this.l(localObject1);
      }
    }
  };
  final FutureTask<Result> Gn = new FutureTask(this.Gm)
  {
    protected final void done()
    {
      try
      {
        Object localObject = get();
        e.this.k(localObject);
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        throw new RuntimeException("An error occurred while executing doInBackground()", localExecutionException.getCause());
      }
      catch (CancellationException localCancellationException)
      {
        e.this.k(null);
        return;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException("An error occurred while executing doInBackground()", localThrowable);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  };
  volatile c Go = c.Gw;
  final AtomicBoolean Gp = new AtomicBoolean();
  final AtomicBoolean Gq = new AtomicBoolean();
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, Gj, Gi);
    THREAD_POOL_EXECUTOR = localThreadPoolExecutor;
    Gl = localThreadPoolExecutor;
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (Gk == null) {
        Gk = new b();
      }
      b localb = Gk;
      return localb;
    }
    finally {}
  }
  
  protected abstract Result dQ();
  
  final void k(Result paramResult)
  {
    if (!this.Gq.get()) {
      l(paramResult);
    }
  }
  
  final Result l(Result paramResult)
  {
    getHandler().obtainMessage(1, new a(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  final void m(Result paramResult)
  {
    if (this.Gp.get()) {
      onCancelled(paramResult);
    }
    for (;;)
    {
      this.Go = c.Gy;
      return;
      onPostExecute(paramResult);
    }
  }
  
  protected void onCancelled(Result paramResult) {}
  
  protected void onPostExecute(Result paramResult) {}
  
  static final class a<Data>
  {
    final e Gu;
    final Data[] Gv;
    
    a(e parame, Data... paramVarArgs)
    {
      this.Gu = parame;
      this.Gv = paramVarArgs;
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
      locala.Gu.m(locala.Gv[0]);
    }
  }
  
  public static enum c
  {
    private c() {}
  }
  
  static abstract class d<Params, Result>
    implements Callable<Result>
  {
    Params[] GA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.content.e
 * JD-Core Version:    0.7.0.1
 */