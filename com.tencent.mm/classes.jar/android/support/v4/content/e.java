package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
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
  private static final BlockingQueue<Runnable> zp = new LinkedBlockingQueue(10);
  private static b zq;
  private static volatile Executor zr;
  final e.d<Params, Result> zt = new e.2(this);
  final FutureTask<Result> zu = new e.3(this, this.zt);
  volatile e.c zv = e.c.zC;
  final AtomicBoolean zw = new AtomicBoolean();
  private final AtomicBoolean zx = new AtomicBoolean();
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, zp, sThreadFactory);
    THREAD_POOL_EXECUTOR = localThreadPoolExecutor;
    zr = localThreadPoolExecutor;
  }
  
  protected static void ck() {}
  
  private static Handler getHandler()
  {
    try
    {
      if (zq == null) {
        zq = new b();
      }
      b localb = zq;
      return localb;
    }
    finally {}
  }
  
  protected abstract Result cj();
  
  final void l(Result paramResult)
  {
    if (!this.zx.get()) {
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
    if (this.zw.get()) {
      onCancelled(paramResult);
    }
    for (;;)
    {
      this.zv = e.c.zE;
      return;
      onPostExecute(paramResult);
    }
  }
  
  protected void onCancelled(Result paramResult) {}
  
  protected void onPostExecute(Result paramResult) {}
  
  private static final class b
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
      case 1: 
        locala.zA.n(locala.zB[0]);
        return;
      }
      e.ck();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.content.e
 * JD-Core Version:    0.7.0.1
 */