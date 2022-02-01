package com.tencent.mm.plugin.appbrand.widget.desktop.c;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public enum c
  implements Choreographer.FrameCallback
{
  private Choreographer choreographer;
  public long gba;
  public int gbb;
  double gbc;
  private int gbd;
  public boolean gbe;
  private final Object lock;
  
  static
  {
    AppMethodBeat.i(49855);
    mAg = new c("INSTANCE");
    mAh = new c[] { mAg };
    AppMethodBeat.o(49855);
  }
  
  private c()
  {
    AppMethodBeat.i(49853);
    this.gba = 0L;
    this.gbb = 0;
    this.gbc = 0.0D;
    this.gbd = 500;
    this.gbe = false;
    this.lock = new Object();
    AppMethodBeat.o(49853);
  }
  
  /* Error */
  public final Choreographer aes()
  {
    // Byte code:
    //   0: ldc 94
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/c/c:choreographer	Landroid/view/Choreographer;
    //   9: ifnonnull +64 -> 73
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/c/c:choreographer	Landroid/view/Choreographer;
    //   18: ifnonnull +53 -> 71
    //   21: invokestatic 100	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   24: invokestatic 106	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   27: invokevirtual 109	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   30: if_acmpeq +69 -> 99
    //   33: new 111	android/os/Handler
    //   36: dup
    //   37: invokestatic 106	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   40: invokespecial 114	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   43: new 9	com/tencent/mm/plugin/appbrand/widget/desktop/c/c$1
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 117	com/tencent/mm/plugin/appbrand/widget/desktop/c/c$1:<init>	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/c/c;)V
    //   51: invokevirtual 121	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   54: pop
    //   55: aload_0
    //   56: getfield 69	com/tencent/mm/plugin/appbrand/widget/desktop/c/c:lock	Ljava/lang/Object;
    //   59: astore_1
    //   60: aload_1
    //   61: monitorenter
    //   62: aload_0
    //   63: getfield 69	com/tencent/mm/plugin/appbrand/widget/desktop/c/c:lock	Ljava/lang/Object;
    //   66: invokevirtual 124	java/lang/Object:wait	()V
    //   69: aload_1
    //   70: monitorexit
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_0
    //   74: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/c/c:choreographer	Landroid/view/Choreographer;
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
    //   103: putfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/c/c:choreographer	Landroid/view/Choreographer;
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
    AppMethodBeat.i(49854);
    paramLong = TimeUnit.NANOSECONDS.toMillis(paramLong);
    if (this.gba > 0L)
    {
      long l = paramLong - this.gba;
      this.gbb += 1;
      if (l > this.gbd)
      {
        this.gbc = (this.gbb * 1000 / l);
        this.gba = paramLong;
        this.gbb = 0;
      }
    }
    for (;;)
    {
      aes().postFrameCallback(this);
      AppMethodBeat.o(49854);
      return;
      this.gba = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.c
 * JD-Core Version:    0.7.0.1
 */