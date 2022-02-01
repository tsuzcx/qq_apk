package androidx.camera.core.impl.a.b;

import androidx.camera.core.al;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

abstract class f<V>
  implements com.google.b.b.a.f<V>
{
  public static <V> com.google.b.b.a.f<V> kT()
  {
    return f.c.PO;
  }
  
  public final void a(Runnable paramRunnable, Executor paramExecutor)
  {
    androidx.core.f.f.checkNotNull(paramRunnable);
    androidx.core.f.f.checkNotNull(paramExecutor);
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      new StringBuilder("Experienced RuntimeException while attempting to notify ").append(paramRunnable).append(" on Executor ").append(paramExecutor);
      al.U("ImmediateFuture");
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public abstract V get();
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
  {
    androidx.core.f.f.checkNotNull(paramTimeUnit);
    return get();
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.b.f
 * JD-Core Version:    0.7.0.1
 */