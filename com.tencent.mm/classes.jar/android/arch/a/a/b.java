package android.arch.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
  extends c
{
  private ExecutorService bH = Executors.newFixedThreadPool(2);
  private final Object mLock = new Object();
  private volatile Handler mMainHandler;
  
  public final void c(Runnable paramRunnable)
  {
    this.bH.execute(paramRunnable);
  }
  
  public final void d(Runnable paramRunnable)
  {
    if (this.mMainHandler == null) {}
    synchronized (this.mLock)
    {
      if (this.mMainHandler == null) {
        this.mMainHandler = new Handler(Looper.getMainLooper());
      }
      this.mMainHandler.post(paramRunnable);
      return;
    }
  }
  
  public final boolean isMainThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.arch.a.a.b
 * JD-Core Version:    0.7.0.1
 */