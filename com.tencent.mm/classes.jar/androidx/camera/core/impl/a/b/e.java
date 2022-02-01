package androidx.camera.core.impl.a.b;

import androidx.c.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

public final class e
{
  private static final androidx.a.a.c.a<?, ?> PI;
  
  static
  {
    AppMethodBeat.i(199157);
    PI = new androidx.a.a.c.a()
    {
      public final Object apply(Object paramAnonymousObject)
      {
        return paramAnonymousObject;
      }
    };
    AppMethodBeat.o(199157);
  }
  
  public static <I, O> com.google.b.b.a.f<O> a(com.google.b.b.a.f<I> paramf, androidx.a.a.c.a<? super I, ? extends O> parama, Executor paramExecutor)
  {
    AppMethodBeat.i(199060);
    androidx.core.f.f.checkNotNull(parama);
    paramf = a(paramf, new a()
    {
      public final com.google.b.b.a.f<O> apply(I paramAnonymousI)
      {
        AppMethodBeat.i(199055);
        paramAnonymousI = e.v(e.this.apply(paramAnonymousI));
        AppMethodBeat.o(199055);
        return paramAnonymousI;
      }
    }, paramExecutor);
    AppMethodBeat.o(199060);
    return paramf;
  }
  
  public static <I, O> com.google.b.b.a.f<O> a(com.google.b.b.a.f<I> paramf, a<? super I, ? extends O> parama, Executor paramExecutor)
  {
    AppMethodBeat.i(199047);
    parama = new b(parama, paramf);
    paramf.a(parama, paramExecutor);
    AppMethodBeat.o(199047);
    return parama;
  }
  
  public static <V> V a(Future<V> paramFuture)
  {
    AppMethodBeat.i(199135);
    androidx.core.f.f.b(paramFuture.isDone(), "Future was expected to be done, ".concat(String.valueOf(paramFuture)));
    paramFuture = b(paramFuture);
    AppMethodBeat.o(199135);
    return paramFuture;
  }
  
  public static <V> void a(com.google.b.b.a.f<V> paramf, b.a<V> parama)
  {
    AppMethodBeat.i(199069);
    a(true, paramf, PI, parama, androidx.camera.core.impl.a.a.b.kP());
    AppMethodBeat.o(199069);
  }
  
  public static <V> void a(com.google.b.b.a.f<V> paramf, c<? super V> paramc, Executor paramExecutor)
  {
    AppMethodBeat.i(199127);
    androidx.core.f.f.checkNotNull(paramc);
    paramf.a(new a(paramf, paramc), paramExecutor);
    AppMethodBeat.o(199127);
  }
  
  private static <I, O> void a(boolean paramBoolean, com.google.b.b.a.f<I> paramf, final androidx.a.a.c.a<? super I, ? extends O> parama, b.a<O> parama1, Executor paramExecutor)
  {
    AppMethodBeat.i(199083);
    androidx.core.f.f.checkNotNull(paramf);
    androidx.core.f.f.checkNotNull(parama);
    androidx.core.f.f.checkNotNull(parama1);
    androidx.core.f.f.checkNotNull(paramExecutor);
    a(paramf, new c()
    {
      public final void onFailure(Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(199054);
        e.this.h(paramAnonymousThrowable);
        AppMethodBeat.o(199054);
      }
      
      public final void onSuccess(I paramAnonymousI)
      {
        AppMethodBeat.i(199048);
        try {}finally
        {
          e.this.h(paramAnonymousI);
          AppMethodBeat.o(199048);
        }
      }
    }, paramExecutor);
    if (paramBoolean) {
      parama1.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199035);
          e.this.cancel(true);
          AppMethodBeat.o(199035);
        }
      }, androidx.camera.core.impl.a.a.b.kP());
    }
    AppMethodBeat.o(199083);
  }
  
  /* Error */
  public static <V> V b(Future<V> paramFuture)
  {
    // Byte code:
    //   0: ldc 153
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: istore_1
    //   7: aload_0
    //   8: invokeinterface 157 1 0
    //   13: astore_2
    //   14: iload_1
    //   15: ifeq +9 -> 24
    //   18: invokestatic 163	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   21: invokevirtual 166	java/lang/Thread:interrupt	()V
    //   24: ldc 153
    //   26: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_2
    //   30: areturn
    //   31: astore_2
    //   32: iconst_1
    //   33: istore_1
    //   34: goto -27 -> 7
    //   37: astore_0
    //   38: iload_1
    //   39: ifeq +9 -> 48
    //   42: invokestatic 163	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   45: invokevirtual 166	java/lang/Thread:interrupt	()V
    //   48: ldc 153
    //   50: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramFuture	Future<V>
    //   6	33	1	i	int
    //   13	17	2	localObject	Object
    //   31	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   7	14	31	java/lang/InterruptedException
    //   7	14	37	finally
  }
  
  public static <V> com.google.b.b.a.f<V> d(com.google.b.b.a.f<V> paramf)
  {
    AppMethodBeat.i(199093);
    androidx.core.f.f.checkNotNull(paramf);
    if (paramf.isDone())
    {
      AppMethodBeat.o(199093);
      return paramf;
    }
    paramf = androidx.c.a.b.a(new e..ExternalSyntheticLambda0(paramf));
    AppMethodBeat.o(199093);
    return paramf;
  }
  
  public static <V> com.google.b.b.a.f<V> i(Throwable paramThrowable)
  {
    AppMethodBeat.i(199020);
    paramThrowable = new f.a(paramThrowable);
    AppMethodBeat.o(199020);
    return paramThrowable;
  }
  
  public static <V> com.google.b.b.a.f<List<V>> i(Collection<? extends com.google.b.b.a.f<? extends V>> paramCollection)
  {
    AppMethodBeat.i(199107);
    paramCollection = new g(new ArrayList(paramCollection), false, androidx.camera.core.impl.a.a.b.kP());
    AppMethodBeat.o(199107);
    return paramCollection;
  }
  
  public static <V> com.google.b.b.a.f<List<V>> j(Collection<? extends com.google.b.b.a.f<? extends V>> paramCollection)
  {
    AppMethodBeat.i(199114);
    paramCollection = new g(new ArrayList(paramCollection), true, androidx.camera.core.impl.a.a.b.kP());
    AppMethodBeat.o(199114);
    return paramCollection;
  }
  
  public static <V> ScheduledFuture<V> j(Throwable paramThrowable)
  {
    AppMethodBeat.i(199032);
    paramThrowable = new f.b(paramThrowable);
    AppMethodBeat.o(199032);
    return paramThrowable;
  }
  
  public static <V> com.google.b.b.a.f<V> v(V paramV)
  {
    AppMethodBeat.i(199009);
    if (paramV == null)
    {
      paramV = f.kT();
      AppMethodBeat.o(199009);
      return paramV;
    }
    paramV = new f.c(paramV);
    AppMethodBeat.o(199009);
    return paramV;
  }
  
  static final class a<V>
    implements Runnable
  {
    final Future<V> PL;
    final c<? super V> PM;
    
    a(Future<V> paramFuture, c<? super V> paramc)
    {
      this.PL = paramFuture;
      this.PM = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(199023);
      try
      {
        Object localObject = e.a(this.PL);
        this.PM.onSuccess(localObject);
        AppMethodBeat.o(199023);
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        this.PM.onFailure(localExecutionException.getCause());
        AppMethodBeat.o(199023);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.PM.onFailure(localRuntimeException);
        AppMethodBeat.o(199023);
        return;
      }
      catch (Error localError)
      {
        label50:
        break label50;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(199031);
      String str = getClass().getSimpleName() + "," + this.PM;
      AppMethodBeat.o(199031);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a.b.e
 * JD-Core Version:    0.7.0.1
 */