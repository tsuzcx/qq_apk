package androidx.camera.core.impl.a.a;

import android.os.Handler;
import android.os.SystemClock;
import androidx.camera.core.impl.a.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class c
  extends AbstractExecutorService
  implements ScheduledExecutorService
{
  private static ThreadLocal<ScheduledExecutorService> OZ;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(199104);
    OZ = new ThreadLocal() {};
    AppMethodBeat.o(199104);
  }
  
  c(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  private RejectedExecutionException kQ()
  {
    AppMethodBeat.i(199095);
    RejectedExecutionException localRejectedExecutionException = new RejectedExecutionException(this.mHandler + " is shutting down");
    AppMethodBeat.o(199095);
    return localRejectedExecutionException;
  }
  
  public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(199150);
    paramTimeUnit = new UnsupportedOperationException(c.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    AppMethodBeat.o(199150);
    throw paramTimeUnit;
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(199153);
    if (!this.mHandler.post(paramRunnable))
    {
      paramRunnable = kQ();
      AppMethodBeat.o(199153);
      throw paramRunnable;
    }
    AppMethodBeat.o(199153);
  }
  
  public final boolean isShutdown()
  {
    return false;
  }
  
  public final boolean isTerminated()
  {
    return false;
  }
  
  public final ScheduledFuture<?> schedule(final Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(199111);
    paramRunnable = schedule(new Callable() {}, paramLong, paramTimeUnit);
    AppMethodBeat.o(199111);
    return paramRunnable;
  }
  
  public final <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(199116);
    long l = SystemClock.uptimeMillis();
    paramLong = TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit) + l;
    paramCallable = new c.a(this.mHandler, paramLong, paramCallable);
    if (this.mHandler.postAtTime(paramCallable, paramLong))
    {
      AppMethodBeat.o(199116);
      return paramCallable;
    }
    paramCallable = e.j(kQ());
    AppMethodBeat.o(199116);
    return paramCallable;
  }
  
  public final ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(199125);
    paramRunnable = new UnsupportedOperationException(c.class.getSimpleName() + " does not yet support fixed-rate scheduling.");
    AppMethodBeat.o(199125);
    throw paramRunnable;
  }
  
  public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(199131);
    paramRunnable = new UnsupportedOperationException(c.class.getSimpleName() + " does not yet support fixed-delay scheduling.");
    AppMethodBeat.o(199131);
    throw paramRunnable;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(199133);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(c.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    AppMethodBeat.o(199133);
    throw localUnsupportedOperationException;
  }
  
  public final List<Runnable> shutdownNow()
  {
    AppMethodBeat.i(199138);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(c.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    AppMethodBeat.o(199138);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.a.c
 * JD-Core Version:    0.7.0.1
 */