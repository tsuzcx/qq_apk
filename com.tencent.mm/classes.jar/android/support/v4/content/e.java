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
  private static final ThreadFactory Hg = new e.1();
  private static final BlockingQueue<Runnable> Hh = new LinkedBlockingQueue(10);
  private static b Hi;
  private static volatile Executor Hj;
  public static final Executor THREAD_POOL_EXECUTOR;
  final d<Params, Result> Hk = new d()
  {
    public final Result call()
    {
      e.this.Ho.set(true);
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject2 = localObject4;
      Object localObject1 = localObject5;
      try
      {
        Process.setThreadPriority(10);
        localObject2 = localObject4;
        localObject1 = localObject5;
        localObject4 = e.this.dX();
        localObject2 = localObject4;
        localObject1 = localObject4;
        Binder.flushPendingCommands();
        return localObject4;
      }
      catch (Throwable localThrowable)
      {
        localObject1 = localObject2;
        e.this.Hn.set(true);
        localObject1 = localObject2;
        throw localThrowable;
      }
      finally
      {
        e.this.n(localObject1);
      }
    }
  };
  final FutureTask<Result> Hl = new FutureTask(this.Hk)
  {
    protected final void done()
    {
      try
      {
        Object localObject = get();
        e.this.m(localObject);
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        throw new RuntimeException("An error occurred while executing doInBackground()", localExecutionException.getCause());
      }
      catch (CancellationException localCancellationException)
      {
        e.this.m(null);
        return;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException("An error occurred while executing doInBackground()", localThrowable);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  };
  volatile c Hm = c.Hu;
  final AtomicBoolean Hn = new AtomicBoolean();
  final AtomicBoolean Ho = new AtomicBoolean();
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, Hh, Hg);
    THREAD_POOL_EXECUTOR = localThreadPoolExecutor;
    Hj = localThreadPoolExecutor;
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (Hi == null) {
        Hi = new b();
      }
      b localb = Hi;
      return localb;
    }
    finally {}
  }
  
  protected abstract Result dX();
  
  final void m(Result paramResult)
  {
    if (!this.Ho.get()) {
      n(paramResult);
    }
  }
  
  final Result n(Result paramResult)
  {
    getHandler().obtainMessage(1, new a(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  final void o(Result paramResult)
  {
    if (this.Hn.get()) {
      onCancelled(paramResult);
    }
    for (;;)
    {
      this.Hm = c.Hw;
      return;
      onPostExecute(paramResult);
    }
  }
  
  protected void onCancelled(Result paramResult) {}
  
  protected void onPostExecute(Result paramResult) {}
  
  static final class a<Data>
  {
    final e Hs;
    final Data[] Ht;
    
    a(e parame, Data... paramVarArgs)
    {
      this.Hs = parame;
      this.Ht = paramVarArgs;
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
      locala.Hs.o(locala.Ht[0]);
    }
  }
  
  public static enum c
  {
    private c() {}
  }
  
  static abstract class d<Params, Result>
    implements Callable<Result>
  {
    Params[] Hy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.content.e
 * JD-Core Version:    0.7.0.1
 */