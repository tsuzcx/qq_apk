package androidx.camera.core.impl.a.b;

import androidx.c.a.b;
import androidx.c.a.b.a;
import androidx.c.a.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class d<V>
  implements com.google.b.b.a.f<V>
{
  b.a<V> BL;
  private final com.google.b.b.a.f<V> Pe;
  
  d()
  {
    AppMethodBeat.i(199026);
    this.Pe = b.a(new b.c()
    {
      public final Object attachCompleter(b.a<V> paramAnonymousa)
      {
        AppMethodBeat.i(199019);
        if (d.this.BL == null) {}
        for (boolean bool = true;; bool = false)
        {
          androidx.core.f.f.b(bool, "The result can only set once!");
          d.this.BL = paramAnonymousa;
          paramAnonymousa = "FutureChain[" + d.this + "]";
          AppMethodBeat.o(199019);
          return paramAnonymousa;
        }
      }
    });
    AppMethodBeat.o(199026);
  }
  
  private d(com.google.b.b.a.f<V> paramf)
  {
    AppMethodBeat.i(199015);
    this.Pe = ((com.google.b.b.a.f)androidx.core.f.f.checkNotNull(paramf));
    AppMethodBeat.o(199015);
  }
  
  public static <V> d<V> c(com.google.b.b.a.f<V> paramf)
  {
    AppMethodBeat.i(199002);
    if ((paramf instanceof d))
    {
      paramf = (d)paramf;
      AppMethodBeat.o(199002);
      return paramf;
    }
    paramf = new d(paramf);
    AppMethodBeat.o(199002);
    return paramf;
  }
  
  public final <T> d<T> a(androidx.a.a.c.a<? super V, T> parama, Executor paramExecutor)
  {
    AppMethodBeat.i(199052);
    parama = (d)e.a(this, parama, paramExecutor);
    AppMethodBeat.o(199052);
    return parama;
  }
  
  public final <T> d<T> a(a<? super V, T> parama, Executor paramExecutor)
  {
    AppMethodBeat.i(199042);
    parama = (d)e.a(this, parama, paramExecutor);
    AppMethodBeat.o(199042);
    return parama;
  }
  
  public final void a(Runnable paramRunnable, Executor paramExecutor)
  {
    AppMethodBeat.i(199062);
    this.Pe.a(paramRunnable, paramExecutor);
    AppMethodBeat.o(199062);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(199071);
    paramBoolean = this.Pe.cancel(paramBoolean);
    AppMethodBeat.o(199071);
    return paramBoolean;
  }
  
  public V get()
  {
    AppMethodBeat.i(199106);
    Object localObject = this.Pe.get();
    AppMethodBeat.o(199106);
    return localObject;
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(199113);
    paramTimeUnit = this.Pe.get(paramLong, paramTimeUnit);
    AppMethodBeat.o(199113);
    return paramTimeUnit;
  }
  
  final boolean h(Throwable paramThrowable)
  {
    AppMethodBeat.i(199122);
    if (this.BL != null)
    {
      boolean bool = this.BL.h(paramThrowable);
      AppMethodBeat.o(199122);
      return bool;
    }
    AppMethodBeat.o(199122);
    return false;
  }
  
  public boolean isCancelled()
  {
    AppMethodBeat.i(199080);
    boolean bool = this.Pe.isCancelled();
    AppMethodBeat.o(199080);
    return bool;
  }
  
  public boolean isDone()
  {
    AppMethodBeat.i(199091);
    boolean bool = this.Pe.isDone();
    AppMethodBeat.o(199091);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a.b.d
 * JD-Core Version:    0.7.0.1
 */