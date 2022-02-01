package androidx.h.b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class c<Params, Progress, Result>
{
  private static final ThreadFactory bIM = new c.1();
  private static final BlockingQueue<Runnable> bIN = new LinkedBlockingQueue(10);
  public static final Executor bIO;
  private static b bIP;
  private static volatile Executor bIQ;
  final d<Params, Result> bIR = new d()
  {
    public final Result call()
    {
      AppMethodBeat.i(193170);
      c.this.bIV.set(true);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      try
      {
        Process.setThreadPriority(10);
        localObject1 = localObject2;
        localObject2 = c.this.Hu();
        localObject1 = localObject2;
        Binder.flushPendingCommands();
        c.this.aN(localObject2);
        AppMethodBeat.o(193170);
        return localObject2;
      }
      finally
      {
        try
        {
          c.this.bIU.set(true);
          AppMethodBeat.o(193170);
          throw localObject3;
        }
        finally
        {
          c.this.aN(localObject1);
          AppMethodBeat.o(193170);
        }
      }
    }
  };
  final FutureTask<Result> bIS = new FutureTask(this.bIR)
  {
    /* Error */
    protected final void done()
    {
      // Byte code:
      //   0: ldc 27
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokevirtual 37	androidx/h/b/c$3:get	()Ljava/lang/Object;
      //   9: astore_1
      //   10: aload_0
      //   11: getfield 15	androidx/h/b/c$3:bIX	Landroidx/h/b/c;
      //   14: aload_1
      //   15: invokevirtual 41	androidx/h/b/c:aM	(Ljava/lang/Object;)V
      //   18: ldc 27
      //   20: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   23: return
      //   24: astore_1
      //   25: ldc 27
      //   27: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   30: return
      //   31: astore_1
      //   32: new 46	java/lang/RuntimeException
      //   35: dup
      //   36: ldc 48
      //   38: aload_1
      //   39: invokevirtual 52	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
      //   42: invokespecial 55	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   45: astore_1
      //   46: ldc 27
      //   48: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   51: aload_1
      //   52: athrow
      //   53: astore_1
      //   54: aload_0
      //   55: getfield 15	androidx/h/b/c$3:bIX	Landroidx/h/b/c;
      //   58: aconst_null
      //   59: invokevirtual 41	androidx/h/b/c:aM	(Ljava/lang/Object;)V
      //   62: ldc 27
      //   64: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   67: return
      //   68: astore_1
      //   69: new 46	java/lang/RuntimeException
      //   72: dup
      //   73: ldc 48
      //   75: aload_1
      //   76: invokespecial 55	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   79: astore_1
      //   80: ldc 27
      //   82: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   85: aload_1
      //   86: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	87	0	this	3
      //   9	6	1	localObject	Object
      //   24	1	1	localInterruptedException	java.lang.InterruptedException
      //   31	8	1	localExecutionException	java.util.concurrent.ExecutionException
      //   45	7	1	localRuntimeException1	java.lang.RuntimeException
      //   53	1	1	localCancellationException	java.util.concurrent.CancellationException
      //   68	8	1	localThrowable	java.lang.Throwable
      //   79	7	1	localRuntimeException2	java.lang.RuntimeException
      // Exception table:
      //   from	to	target	type
      //   5	18	24	java/lang/InterruptedException
      //   5	18	31	java/util/concurrent/ExecutionException
      //   5	18	53	java/util/concurrent/CancellationException
      //   5	18	68	finally
    }
  };
  volatile c bIT = c.bJb;
  final AtomicBoolean bIU = new AtomicBoolean();
  final AtomicBoolean bIV = new AtomicBoolean();
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, bIN, bIM);
    bIO = localThreadPoolExecutor;
    bIQ = localThreadPoolExecutor;
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (bIP == null) {
        bIP = new b();
      }
      b localb = bIP;
      return localb;
    }
    finally {}
  }
  
  protected abstract Result Hu();
  
  final void aM(Result paramResult)
  {
    if (!this.bIV.get()) {
      aN(paramResult);
    }
  }
  
  final Result aN(Result paramResult)
  {
    getHandler().obtainMessage(1, new a(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  final void aO(Result paramResult)
  {
    if (this.bIU.get()) {
      onCancelled(paramResult);
    }
    for (;;)
    {
      this.bIT = c.bJd;
      return;
      onPostExecute(paramResult);
    }
  }
  
  protected void onCancelled(Result paramResult) {}
  
  protected void onPostExecute(Result paramResult) {}
  
  static final class a<Data>
  {
    final c bIZ;
    final Data[] bJa;
    
    a(c paramc, Data... paramVarArgs)
    {
      this.bIZ = paramc;
      this.bJa = paramVarArgs;
    }
  }
  
  static final class b
    extends Handler
  {
    b()
    {
      super();
      AppMethodBeat.i(193161);
      AppMethodBeat.o(193161);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(193172);
      c.a locala = (c.a)paramMessage.obj;
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(193172);
        return;
        locala.bIZ.aO(locala.bJa[0]);
      }
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(193171);
      bJb = new c("PENDING", 0);
      bJc = new c("RUNNING", 1);
      bJd = new c("FINISHED", 2);
      bJe = new c[] { bJb, bJc, bJd };
      AppMethodBeat.o(193171);
    }
    
    private c() {}
  }
  
  static abstract class d<Params, Result>
    implements Callable<Result>
  {
    Params[] bJf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.h.b.c
 * JD-Core Version:    0.7.0.1
 */