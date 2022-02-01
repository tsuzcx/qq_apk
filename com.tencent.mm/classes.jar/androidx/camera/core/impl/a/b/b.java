package androidx.camera.core.impl.a.b;

import androidx.c.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class b<I, O>
  extends d<O>
  implements Runnable
{
  private a<? super I, ? extends O> PA;
  private final BlockingQueue<Boolean> PB;
  private final CountDownLatch PC;
  private com.google.b.b.a.f<? extends I> PD;
  volatile com.google.b.b.a.f<? extends O> PE;
  
  b(a<? super I, ? extends O> parama, com.google.b.b.a.f<? extends I> paramf)
  {
    AppMethodBeat.i(199005);
    this.PB = new LinkedBlockingQueue(1);
    this.PC = new CountDownLatch(1);
    this.PA = ((a)androidx.core.f.f.checkNotNull(parama));
    this.PD = ((com.google.b.b.a.f)androidx.core.f.f.checkNotNull(paramf));
    AppMethodBeat.o(199005);
  }
  
  /* Error */
  private static <E> E a(BlockingQueue<E> paramBlockingQueue)
  {
    // Byte code:
    //   0: ldc 70
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: istore_1
    //   7: aload_0
    //   8: invokeinterface 76 1 0
    //   13: astore_2
    //   14: iload_1
    //   15: ifeq +9 -> 24
    //   18: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   21: invokevirtual 85	java/lang/Thread:interrupt	()V
    //   24: ldc 70
    //   26: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_2
    //   30: areturn
    //   31: astore_2
    //   32: iconst_1
    //   33: istore_1
    //   34: goto -27 -> 7
    //   37: astore_0
    //   38: iload_1
    //   39: ifeq +9 -> 48
    //   42: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   45: invokevirtual 85	java/lang/Thread:interrupt	()V
    //   48: ldc 70
    //   50: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramBlockingQueue	BlockingQueue<E>
    //   6	33	1	i	int
    //   13	17	2	localObject	Object
    //   31	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   7	14	31	java/lang/InterruptedException
    //   7	14	37	finally
  }
  
  private static void a(Future<?> paramFuture, boolean paramBoolean)
  {
    AppMethodBeat.i(199016);
    if (paramFuture != null) {
      paramFuture.cancel(paramBoolean);
    }
    AppMethodBeat.o(199016);
  }
  
  /* Error */
  public final boolean cancel(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 96
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: iload_1
    //   9: invokespecial 97	androidx/camera/core/impl/a/b/d:cancel	(Z)Z
    //   12: ifeq +76 -> 88
    //   15: aload_0
    //   16: getfield 40	androidx/camera/core/impl/a/b/b:PB	Ljava/util/concurrent/BlockingQueue;
    //   19: astore_3
    //   20: aload_3
    //   21: iload_1
    //   22: invokestatic 103	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   25: invokeinterface 107 2 0
    //   30: iload_2
    //   31: ifeq +9 -> 40
    //   34: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   37: invokevirtual 85	java/lang/Thread:interrupt	()V
    //   40: aload_0
    //   41: getfield 59	androidx/camera/core/impl/a/b/b:PD	Lcom/google/b/b/a/f;
    //   44: iload_1
    //   45: invokestatic 109	androidx/camera/core/impl/a/b/b:a	(Ljava/util/concurrent/Future;Z)V
    //   48: aload_0
    //   49: getfield 111	androidx/camera/core/impl/a/b/b:PE	Lcom/google/b/b/a/f;
    //   52: iload_1
    //   53: invokestatic 109	androidx/camera/core/impl/a/b/b:a	(Ljava/util/concurrent/Future;Z)V
    //   56: ldc 96
    //   58: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_1
    //   62: ireturn
    //   63: astore 4
    //   65: iconst_1
    //   66: istore_2
    //   67: goto -47 -> 20
    //   70: astore_3
    //   71: iload_2
    //   72: ifeq +9 -> 81
    //   75: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   78: invokevirtual 85	java/lang/Thread:interrupt	()V
    //   81: ldc 96
    //   83: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload_3
    //   87: athrow
    //   88: ldc 96
    //   90: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iconst_0
    //   94: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	b
    //   0	95	1	paramBoolean	boolean
    //   1	71	2	i	int
    //   19	2	3	localBlockingQueue	BlockingQueue
    //   70	17	3	localObject	Object
    //   63	1	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   20	30	63	java/lang/InterruptedException
    //   20	30	70	finally
  }
  
  public final O get()
  {
    AppMethodBeat.i(199040);
    if (!isDone())
    {
      localObject = this.PD;
      if (localObject != null) {
        ((com.google.b.b.a.f)localObject).get();
      }
      this.PC.await();
      localObject = this.PE;
      if (localObject != null) {
        ((com.google.b.b.a.f)localObject).get();
      }
    }
    Object localObject = super.get();
    AppMethodBeat.o(199040);
    return localObject;
  }
  
  public final O get(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(199049);
    long l = paramLong;
    Object localObject = paramTimeUnit;
    if (!isDone())
    {
      l = paramLong;
      TimeUnit localTimeUnit = paramTimeUnit;
      if (paramTimeUnit != TimeUnit.NANOSECONDS)
      {
        l = TimeUnit.NANOSECONDS.convert(paramLong, paramTimeUnit);
        localTimeUnit = TimeUnit.NANOSECONDS;
      }
      paramTimeUnit = this.PD;
      paramLong = l;
      if (paramTimeUnit != null)
      {
        paramLong = System.nanoTime();
        paramTimeUnit.get(l, localTimeUnit);
        paramLong = l - Math.max(0L, System.nanoTime() - paramLong);
      }
      l = System.nanoTime();
      if (!this.PC.await(paramLong, localTimeUnit))
      {
        paramTimeUnit = new TimeoutException();
        AppMethodBeat.o(199049);
        throw paramTimeUnit;
      }
      paramLong -= Math.max(0L, System.nanoTime() - l);
      paramTimeUnit = this.PE;
      l = paramLong;
      localObject = localTimeUnit;
      if (paramTimeUnit != null)
      {
        paramTimeUnit.get(paramLong, localTimeUnit);
        localObject = localTimeUnit;
        l = paramLong;
      }
    }
    paramTimeUnit = super.get(l, (TimeUnit)localObject);
    AppMethodBeat.o(199049);
    return paramTimeUnit;
  }
  
  public final void run()
  {
    AppMethodBeat.i(199067);
    try
    {
      Object localObject1 = e.b(this.PD);
      localObject1 = this.PA.apply(localObject1);
      this.PE = ((com.google.b.b.a.f)localObject1);
      if (isCancelled())
      {
        ((com.google.b.b.a.f)localObject1).cancel(((Boolean)a(this.PB)).booleanValue());
        this.PE = null;
        return;
      }
    }
    catch (CancellationException localCancellationException)
    {
      cancel(false);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      h(localExecutionException.getCause());
      return;
      localExecutionException.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199036);
          try
          {
            b localb = b.this;
            Object localObject2 = e.b(localExecutionException);
            if (localb.BL != null) {
              localb.BL.ap(localObject2);
            }
            return;
          }
          catch (CancellationException localCancellationException)
          {
            b.this.cancel(false);
            return;
          }
          catch (ExecutionException localExecutionException)
          {
            b.this.h(localExecutionException.getCause());
            return;
          }
          finally
          {
            b.this.PE = null;
            AppMethodBeat.o(199036);
          }
        }
      }, androidx.camera.core.impl.a.a.b.kP());
      return;
    }
    catch (UndeclaredThrowableException localUndeclaredThrowableException)
    {
      h(localUndeclaredThrowableException.getCause());
      return;
    }
    catch (Exception localException)
    {
      h(localException);
      return;
    }
    catch (Error localError)
    {
      h(localError);
      return;
    }
    finally
    {
      this.PA = null;
      this.PD = null;
      this.PC.countDown();
      AppMethodBeat.o(199067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a.b.b
 * JD-Core Version:    0.7.0.1
 */