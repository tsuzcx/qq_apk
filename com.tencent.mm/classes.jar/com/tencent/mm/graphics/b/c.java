package com.tencent.mm.graphics.b;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;

public enum c
  implements Choreographer.FrameCallback
{
  private Choreographer choreographer;
  private int interval;
  private final Object lock;
  private long mvI;
  private int mvJ;
  double mvK;
  public boolean mvL;
  
  static
  {
    AppMethodBeat.i(136204);
    mvH = new c("INSTANCE");
    mvM = new c[] { mvH };
    AppMethodBeat.o(136204);
  }
  
  private c()
  {
    AppMethodBeat.i(136201);
    this.mvI = 0L;
    this.mvJ = 0;
    this.mvK = 0.0D;
    this.interval = 500;
    this.lock = new Object();
    this.mvL = false;
    AppMethodBeat.o(136201);
  }
  
  /* Error */
  public final Choreographer aXZ()
  {
    // Byte code:
    //   0: ldc 94
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 74	com/tencent/mm/graphics/b/c:choreographer	Landroid/view/Choreographer;
    //   9: ifnonnull +64 -> 73
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 74	com/tencent/mm/graphics/b/c:choreographer	Landroid/view/Choreographer;
    //   18: ifnonnull +53 -> 71
    //   21: invokestatic 100	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   24: invokestatic 106	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   27: invokevirtual 109	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   30: if_acmpeq +69 -> 99
    //   33: new 111	android/os/Handler
    //   36: dup
    //   37: invokestatic 106	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   40: invokespecial 114	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   43: new 9	com/tencent/mm/graphics/b/c$1
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 117	com/tencent/mm/graphics/b/c$1:<init>	(Lcom/tencent/mm/graphics/b/c;)V
    //   51: invokevirtual 121	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   54: pop
    //   55: aload_0
    //   56: getfield 67	com/tencent/mm/graphics/b/c:lock	Ljava/lang/Object;
    //   59: astore_1
    //   60: aload_1
    //   61: monitorenter
    //   62: aload_0
    //   63: getfield 67	com/tencent/mm/graphics/b/c:lock	Ljava/lang/Object;
    //   66: invokevirtual 124	java/lang/Object:wait	()V
    //   69: aload_1
    //   70: monitorexit
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_0
    //   74: getfield 74	com/tencent/mm/graphics/b/c:choreographer	Landroid/view/Choreographer;
    //   77: astore_1
    //   78: ldc 94
    //   80: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_1
    //   84: areturn
    //   85: astore_2
    //   86: aload_1
    //   87: monitorexit
    //   88: ldc 94
    //   90: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_1
    //   96: goto -25 -> 71
    //   99: aload_0
    //   100: invokestatic 129	android/view/Choreographer:getInstance	()Landroid/view/Choreographer;
    //   103: putfield 74	com/tencent/mm/graphics/b/c:choreographer	Landroid/view/Choreographer;
    //   106: goto -35 -> 71
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: ldc 94
    //   114: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	c
    //   95	1	1	localInterruptedException	java.lang.InterruptedException
    //   109	9	1	localObject2	Object
    //   85	9	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	71	85	finally
    //   55	62	95	java/lang/InterruptedException
    //   86	95	95	java/lang/InterruptedException
    //   14	55	109	finally
    //   55	62	109	finally
    //   71	73	109	finally
    //   86	95	109	finally
    //   99	106	109	finally
  }
  
  public final void doFrame(long paramLong)
  {
    AppMethodBeat.i(136203);
    paramLong = TimeUnit.NANOSECONDS.toMillis(paramLong);
    if (this.mvI > 0L)
    {
      long l = paramLong - this.mvI;
      this.mvJ += 1;
      if (l > this.interval)
      {
        this.mvK = (this.mvJ * 1000 / l);
        this.mvI = paramLong;
        this.mvJ = 0;
      }
    }
    for (;;)
    {
      aXZ().postFrameCallback(this);
      AppMethodBeat.o(136203);
      return;
      this.mvI = paramLong;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(136202);
    this.mvI = 0L;
    this.mvJ = 0;
    this.mvL = false;
    Log.i("MicroMsg.Metronome", "[stop] stack:%s", new Object[] { Util.getStack() });
    aXZ().removeFrameCallback(this);
    AppMethodBeat.o(136202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.graphics.b.c
 * JD-Core Version:    0.7.0.1
 */