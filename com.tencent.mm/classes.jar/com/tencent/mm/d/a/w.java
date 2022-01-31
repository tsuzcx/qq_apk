package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.ConcurrentLinkedQueue;

class w
  implements d
{
  private static final ThreadLocal<w> cbv;
  private final Thread ccA;
  private final ConcurrentLinkedQueue<Runnable> ccB;
  private boolean ccC;
  private d.a ccD;
  private boolean mPaused;
  
  static
  {
    AppMethodBeat.i(113918);
    cbv = new ThreadLocal();
    AppMethodBeat.o(113918);
  }
  
  w()
  {
    AppMethodBeat.i(113906);
    this.ccA = Thread.currentThread();
    this.ccB = new ConcurrentLinkedQueue();
    AppMethodBeat.o(113906);
  }
  
  public static w Cx()
  {
    AppMethodBeat.i(113905);
    if (cbv.get() != null)
    {
      localObject = new RuntimeException("Only one Looper may be created per thread");
      AppMethodBeat.o(113905);
      throw ((Throwable)localObject);
    }
    Object localObject = new w();
    cbv.set(localObject);
    AppMethodBeat.o(113905);
    return localObject;
  }
  
  private void n(Runnable paramRunnable)
  {
    AppMethodBeat.i(113917);
    try
    {
      paramRunnable.run();
      AppMethodBeat.o(113917);
      return;
    }
    catch (V8ScriptException paramRunnable)
    {
      if (this.ccD != null) {
        this.ccD.b(paramRunnable);
      }
      AppMethodBeat.o(113917);
      return;
    }
    catch (UndeclaredThrowableException paramRunnable)
    {
      ab.e("MicroMsg.V8JSRuntimeLooper", "runTask UndeclaredThrowableException: %s %s", new Object[] { paramRunnable, paramRunnable.getCause() });
      AppMethodBeat.o(113917);
    }
  }
  
  public final boolean Cl()
  {
    AppMethodBeat.i(113908);
    if (Thread.currentThread().getId() == this.ccA.getId())
    {
      AppMethodBeat.o(113908);
      return true;
    }
    AppMethodBeat.o(113908);
    return false;
  }
  
  protected boolean Cq()
  {
    AppMethodBeat.i(113914);
    boolean bool = this.ccB.isEmpty();
    AppMethodBeat.o(113914);
    return bool;
  }
  
  protected void Cr()
  {
    AppMethodBeat.i(113916);
    for (;;)
    {
      Runnable localRunnable = (Runnable)this.ccB.poll();
      if (localRunnable == null) {
        break;
      }
      n(localRunnable);
    }
    AppMethodBeat.o(113916);
  }
  
  protected void Cs()
  {
    AppMethodBeat.i(113915);
    ab.i("MicroMsg.V8JSRuntimeLooper", "loop end");
    AppMethodBeat.o(113915);
  }
  
  protected void Ct() {}
  
  public final void a(d.a parama)
  {
    this.ccD = parama;
  }
  
  /* Error */
  public final void g(Runnable arg1, long paramLong)
  {
    // Byte code:
    //   0: ldc 139
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +9 -> 15
    //   9: ldc 139
    //   11: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: return
    //   15: lload_2
    //   16: lconst_0
    //   17: lcmp
    //   18: ifeq +20 -> 38
    //   21: new 141	java/lang/IllegalStateException
    //   24: dup
    //   25: ldc 143
    //   27: invokespecial 144	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: ldc 139
    //   33: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_1
    //   37: athrow
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 146	com/tencent/mm/d/a/w:ccC	Z
    //   44: ifeq +18 -> 62
    //   47: ldc 95
    //   49: ldc 148
    //   51: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: ldc 139
    //   58: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_0
    //   65: getfield 54	com/tencent/mm/d/a/w:ccB	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   68: aload_1
    //   69: invokevirtual 152	java/util/concurrent/ConcurrentLinkedQueue:offer	(Ljava/lang/Object;)Z
    //   72: pop
    //   73: aload_0
    //   74: invokevirtual 155	com/tencent/mm/d/a/w:isPaused	()Z
    //   77: ifne +19 -> 96
    //   80: aload_0
    //   81: getfield 54	com/tencent/mm/d/a/w:ccB	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   84: astore_1
    //   85: aload_1
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 54	com/tencent/mm/d/a/w:ccB	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   91: invokevirtual 158	java/lang/Object:notify	()V
    //   94: aload_1
    //   95: monitorexit
    //   96: aload_0
    //   97: invokevirtual 160	com/tencent/mm/d/a/w:Ct	()V
    //   100: ldc 139
    //   102: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: return
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: ldc 139
    //   111: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_1
    //   115: athrow
    //   116: astore 4
    //   118: aload_1
    //   119: monitorexit
    //   120: ldc 139
    //   122: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload 4
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	w
    //   0	128	2	paramLong	long
    //   116	10	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	56	106	finally
    //   62	64	106	finally
    //   107	109	106	finally
    //   87	96	116	finally
    //   118	120	116	finally
  }
  
  protected final boolean isPaused()
  {
    try
    {
      boolean bool = this.mPaused;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void loop()
  {
    AppMethodBeat.i(113907);
    ab.i("MicroMsg.V8JSRuntimeLooper", "loop start");
    while (!this.ccA.isInterrupted()) {
      synchronized (this.ccB)
      {
        for (;;)
        {
          if (!isPaused())
          {
            boolean bool = Cq();
            if (!bool) {}
          }
          else
          {
            try
            {
              this.ccB.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              ab.i("MicroMsg.V8JSRuntimeLooper", "wait interrupted ; loop end");
              this.ccA.interrupt();
            }
          }
        }
        Cr();
      }
    }
    try
    {
      this.ccC = true;
      Cs();
      this.ccB.clear();
      AppMethodBeat.o(113907);
      return;
    }
    finally
    {
      AppMethodBeat.o(113907);
    }
  }
  
  public final void m(Runnable arg1)
  {
    AppMethodBeat.i(113909);
    if (??? == null)
    {
      AppMethodBeat.o(113909);
      return;
    }
    for (;;)
    {
      try
      {
        if (this.ccC)
        {
          ab.i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
          return;
        }
        if (Thread.currentThread().getId() == this.ccA.getId())
        {
          n(???);
          Ct();
          AppMethodBeat.o(113909);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(113909);
      }
      this.ccB.offer(???);
      if (isPaused()) {
        continue;
      }
      synchronized (this.ccB)
      {
        this.ccB.notify();
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(113911);
    ab.i("MicroMsg.V8JSRuntimeLooper", "pause");
    try
    {
      this.mPaused = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(113911);
    }
  }
  
  public final void quit()
  {
    AppMethodBeat.i(113913);
    ab.i("MicroMsg.V8JSRuntimeLooper", "quit");
    this.ccA.interrupt();
    AppMethodBeat.o(113913);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(113912);
    ab.i("MicroMsg.V8JSRuntimeLooper", "resume");
    this.mPaused = false;
    synchronized (this.ccB)
    {
      this.ccB.notify();
      AppMethodBeat.o(113912);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.a.w
 * JD-Core Version:    0.7.0.1
 */