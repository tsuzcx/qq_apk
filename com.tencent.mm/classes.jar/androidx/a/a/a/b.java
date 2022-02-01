package androidx.a.a.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends c
{
  private final Object mLock;
  private volatile Handler mMainHandler;
  private final ExecutorService ya;
  
  public b()
  {
    AppMethodBeat.i(212384);
    this.mLock = new Object();
    this.ya = Executors.newFixedThreadPool(2, new ThreadFactory()
    {
      private final AtomicInteger yb;
      
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(212378);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable);
        paramAnonymousRunnable.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(this.yb.getAndIncrement()) }));
        AppMethodBeat.o(212378);
        return paramAnonymousRunnable;
      }
    });
    AppMethodBeat.o(212384);
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(212386);
    this.ya.execute(paramRunnable);
    AppMethodBeat.o(212386);
  }
  
  public final boolean isMainThread()
  {
    AppMethodBeat.i(212390);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(212390);
      return true;
    }
    AppMethodBeat.o(212390);
    return false;
  }
  
  public final void postToMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(212388);
    if (this.mMainHandler == null) {}
    synchronized (this.mLock)
    {
      if (this.mMainHandler == null) {
        this.mMainHandler = new Handler(Looper.getMainLooper());
      }
      this.mMainHandler.post(paramRunnable);
      AppMethodBeat.o(212388);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */