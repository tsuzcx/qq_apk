package androidx.camera.core.impl.a.a;

import android.os.Handler;
import androidx.c.a.b.a;
import androidx.c.a.b.c;
import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

final class c$a<V>
  implements RunnableScheduledFuture<V>
{
  final AtomicReference<b.a<V>> Pb;
  private final long Pc;
  private final Callable<V> Pd;
  private final f<V> Pe;
  
  c$a(final Handler paramHandler, long paramLong, final Callable<V> paramCallable)
  {
    AppMethodBeat.i(199076);
    this.Pb = new AtomicReference(null);
    this.Pc = paramLong;
    this.Pd = paramCallable;
    this.Pe = androidx.c.a.b.a(new b.c()
    {
      public final Object attachCompleter(b.a<V> paramAnonymousa)
      {
        AppMethodBeat.i(199082);
        paramAnonymousa.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199105);
            if (c.a.this.Pb.getAndSet(null) != null) {
              c.a.1.this.Pf.removeCallbacks(c.a.this);
            }
            AppMethodBeat.o(199105);
          }
        }, b.kP());
        c.a.this.Pb.set(paramAnonymousa);
        paramAnonymousa = "HandlerScheduledFuture-" + paramCallable.toString();
        AppMethodBeat.o(199082);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(199076);
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(199118);
    paramBoolean = this.Pe.cancel(paramBoolean);
    AppMethodBeat.o(199118);
    return paramBoolean;
  }
  
  public final V get()
  {
    AppMethodBeat.i(199141);
    Object localObject = this.Pe.get();
    AppMethodBeat.o(199141);
    return localObject;
  }
  
  public final V get(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(199147);
    paramTimeUnit = this.Pe.get(paramLong, paramTimeUnit);
    AppMethodBeat.o(199147);
    return paramTimeUnit;
  }
  
  public final long getDelay(TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(199096);
    long l = paramTimeUnit.convert(this.Pc - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    AppMethodBeat.o(199096);
    return l;
  }
  
  public final boolean isCancelled()
  {
    AppMethodBeat.i(199128);
    boolean bool = this.Pe.isCancelled();
    AppMethodBeat.o(199128);
    return bool;
  }
  
  public final boolean isDone()
  {
    AppMethodBeat.i(199132);
    boolean bool = this.Pe.isDone();
    AppMethodBeat.o(199132);
    return bool;
  }
  
  public final boolean isPeriodic()
  {
    return false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(199110);
    b.a locala = (b.a)this.Pb.getAndSet(null);
    if (locala != null) {
      try
      {
        locala.ap(this.Pd.call());
        AppMethodBeat.o(199110);
        return;
      }
      catch (Exception localException)
      {
        locala.h(localException);
      }
    }
    AppMethodBeat.o(199110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */