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
  private static final ThreadFactory Ja = new e.1();
  private static final BlockingQueue<Runnable> Jb = new LinkedBlockingQueue(10);
  private static b Jc;
  private static volatile Executor Jd;
  public static final Executor THREAD_POOL_EXECUTOR;
  final d<Params, Result> Je = new d()
  {
    public final Result call()
    {
      e.this.Ji.set(true);
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject2 = localObject4;
      Object localObject1 = localObject5;
      try
      {
        Process.setThreadPriority(10);
        localObject2 = localObject4;
        localObject1 = localObject5;
        localObject4 = e.this.es();
        localObject2 = localObject4;
        localObject1 = localObject4;
        Binder.flushPendingCommands();
        return localObject4;
      }
      catch (Throwable localThrowable)
      {
        localObject1 = localObject2;
        e.this.Jh.set(true);
        localObject1 = localObject2;
        throw localThrowable;
      }
      finally
      {
        e.this.o(localObject1);
      }
    }
  };
  final FutureTask<Result> Jf = new FutureTask(this.Je)
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
  volatile c Jg = c.Jo;
  final AtomicBoolean Jh = new AtomicBoolean();
  final AtomicBoolean Ji = new AtomicBoolean();
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, Jb, Ja);
    THREAD_POOL_EXECUTOR = localThreadPoolExecutor;
    Jd = localThreadPoolExecutor;
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (Jc == null) {
        Jc = new b();
      }
      b localb = Jc;
      return localb;
    }
    finally {}
  }
  
  protected abstract Result es();
  
  final void n(Result paramResult)
  {
    if (!this.Ji.get()) {
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
    if (this.Jh.get()) {
      onCancelled(paramResult);
    }
    for (;;)
    {
      this.Jg = c.Jq;
      return;
      onPostExecute(paramResult);
    }
  }
  
  static final class a<Data>
  {
    final e Jm;
    final Data[] Jn;
    
    a(e parame, Data... paramVarArgs)
    {
      this.Jm = parame;
      this.Jn = paramVarArgs;
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
      locala.Jm.p(locala.Jn[0]);
    }
  }
  
  public static enum c
  {
    private c() {}
  }
  
  static abstract class d<Params, Result>
    implements Callable<Result>
  {
    Params[] Js;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.content.e
 * JD-Core Version:    0.7.0.1
 */