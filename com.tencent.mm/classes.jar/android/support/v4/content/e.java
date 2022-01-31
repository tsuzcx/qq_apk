package android.support.v4.content;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class e<Params, Progress, Result>
{
  public static final Executor THREAD_POOL_EXECUTOR;
  private static final ThreadFactory sThreadFactory = new e.1();
  private static final BlockingQueue<Runnable> zO = new LinkedBlockingQueue(10);
  private static e.b zP;
  private static volatile Executor zQ;
  final e.d<Params, Result> zR = new e.2(this);
  final FutureTask<Result> zS = new e.3(this, this.zR);
  volatile e.c zT = e.c.Aa;
  final AtomicBoolean zU = new AtomicBoolean();
  final AtomicBoolean zV = new AtomicBoolean();
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, zO, sThreadFactory);
    THREAD_POOL_EXECUTOR = localThreadPoolExecutor;
    zQ = localThreadPoolExecutor;
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (zP == null) {
        zP = new e.b();
      }
      e.b localb = zP;
      return localb;
    }
    finally {}
  }
  
  protected abstract Result cL();
  
  final void l(Result paramResult)
  {
    if (!this.zV.get()) {
      m(paramResult);
    }
  }
  
  final Result m(Result paramResult)
  {
    getHandler().obtainMessage(1, new e.a(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  final void n(Result paramResult)
  {
    if (this.zU.get()) {
      onCancelled(paramResult);
    }
    for (;;)
    {
      this.zT = e.c.Ac;
      return;
      onPostExecute(paramResult);
    }
  }
  
  protected void onCancelled(Result paramResult) {}
  
  protected void onPostExecute(Result paramResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.content.e
 * JD-Core Version:    0.7.0.1
 */