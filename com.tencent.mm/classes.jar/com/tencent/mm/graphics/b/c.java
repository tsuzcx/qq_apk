package com.tencent.mm.graphics.b;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.TimeUnit;

public enum c
  implements Choreographer.FrameCallback
{
  private Choreographer choreographer;
  private long gxr;
  private int gxs;
  double gxt;
  private int gxu;
  public boolean gxv;
  private final Object lock;
  
  static
  {
    AppMethodBeat.i(136204);
    gxq = new c("INSTANCE");
    gxw = new c[] { gxq };
    AppMethodBeat.o(136204);
  }
  
  private c()
  {
    AppMethodBeat.i(136201);
    this.gxr = 0L;
    this.gxs = 0;
    this.gxt = 0.0D;
    this.gxu = 500;
    this.lock = new Object();
    this.gxv = false;
    AppMethodBeat.o(136201);
  }
  
  /* Error */
  public final Choreographer aht()
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
    //   86	88	85	finally
    //   55	62	95	java/lang/InterruptedException
    //   88	95	95	java/lang/InterruptedException
    //   14	55	109	finally
    //   55	62	109	finally
    //   71	73	109	finally
    //   88	95	109	finally
    //   99	106	109	finally
    //   110	112	109	finally
  }
  
  public final void doFrame(long paramLong)
  {
    AppMethodBeat.i(136203);
    paramLong = TimeUnit.NANOSECONDS.toMillis(paramLong);
    if (this.gxr > 0L)
    {
      long l = paramLong - this.gxr;
      this.gxs += 1;
      if (l > this.gxu)
      {
        this.gxt = (this.gxs * 1000 / l);
        this.gxr = paramLong;
        this.gxs = 0;
      }
    }
    for (;;)
    {
      aht().postFrameCallback(this);
      AppMethodBeat.o(136203);
      return;
      this.gxr = paramLong;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(136202);
    this.gxr = 0L;
    this.gxs = 0;
    this.gxv = false;
    ae.i("MicroMsg.Metronome", "[stop] stack:%s", new Object[] { bu.fpN() });
    aht().removeFrameCallback(this);
    AppMethodBeat.o(136202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.b.c
 * JD-Core Version:    0.7.0.1
 */