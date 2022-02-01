package com.tencent.mm.plugin.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class j<R>
{
  long begin;
  private final Object lock = new Object();
  public volatile MMHandler mHandler;
  boolean manualFinish = false;
  public R result;
  public final Runnable task = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(162078);
      Log.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + j.this.manualFinish);
      if (j.this.manualFinish) {
        j.this.run();
      }
      for (;;)
      {
        j.this.wait = Util.ticksToNow(j.this.begin);
        AppMethodBeat.o(162078);
        return;
        j.this.setResultFinish(j.this.run());
      }
    }
  };
  private final long timeout;
  long wait;
  
  public j()
  {
    this(0L, null);
  }
  
  public j(long paramLong, R paramR)
  {
    this.timeout = paramLong;
    this.result = paramR;
  }
  
  /* Error */
  public final R exec(MMHandler paramMMHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 50	com/tencent/mm/plugin/appbrand/a/j:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   5: ldc 52
    //   7: ldc 54
    //   9: invokestatic 60	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: invokestatic 66	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15: invokevirtual 70	java/lang/Thread:getId	()J
    //   18: aload_1
    //   19: invokevirtual 76	com/tencent/mm/sdk/platformtools/MMHandler:getLooper	()Landroid/os/Looper;
    //   22: invokevirtual 81	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   25: invokevirtual 70	java/lang/Thread:getId	()J
    //   28: lcmp
    //   29: ifne +15 -> 44
    //   32: ldc 52
    //   34: ldc 83
    //   36: invokestatic 60	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: invokevirtual 87	com/tencent/mm/plugin/appbrand/a/j:run	()Ljava/lang/Object;
    //   43: areturn
    //   44: aload_0
    //   45: invokestatic 92	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   48: putfield 94	com/tencent/mm/plugin/appbrand/a/j:begin	J
    //   51: aload_0
    //   52: getfield 31	com/tencent/mm/plugin/appbrand/a/j:lock	Ljava/lang/Object;
    //   55: astore 4
    //   57: aload 4
    //   59: monitorenter
    //   60: ldc 52
    //   62: ldc 96
    //   64: invokestatic 60	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_1
    //   68: aload_0
    //   69: getfield 38	com/tencent/mm/plugin/appbrand/a/j:task	Ljava/lang/Runnable;
    //   72: invokevirtual 100	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 31	com/tencent/mm/plugin/appbrand/a/j:lock	Ljava/lang/Object;
    //   80: aload_0
    //   81: getfield 40	com/tencent/mm/plugin/appbrand/a/j:timeout	J
    //   84: invokevirtual 103	java/lang/Object:wait	(J)V
    //   87: aload 4
    //   89: monitorexit
    //   90: aload_0
    //   91: getfield 94	com/tencent/mm/plugin/appbrand/a/j:begin	J
    //   94: invokestatic 107	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   97: lstore_2
    //   98: ldc 52
    //   100: ldc 109
    //   102: iconst_4
    //   103: anewarray 5	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: new 111	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   115: aload_0
    //   116: getfield 42	com/tencent/mm/plugin/appbrand/a/j:result	Ljava/lang/Object;
    //   119: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: lload_2
    //   129: invokestatic 126	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   132: aastore
    //   133: dup
    //   134: iconst_2
    //   135: aload_0
    //   136: getfield 128	com/tencent/mm/plugin/appbrand/a/j:wait	J
    //   139: invokestatic 126	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   142: aastore
    //   143: dup
    //   144: iconst_3
    //   145: lload_2
    //   146: aload_0
    //   147: getfield 128	com/tencent/mm/plugin/appbrand/a/j:wait	J
    //   150: lsub
    //   151: invokestatic 126	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   154: aastore
    //   155: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: aload_0
    //   159: getfield 42	com/tencent/mm/plugin/appbrand/a/j:result	Ljava/lang/Object;
    //   162: areturn
    //   163: astore_1
    //   164: aload 4
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: ldc 52
    //   172: aload_1
    //   173: ldc 133
    //   175: iconst_0
    //   176: anewarray 5	java/lang/Object
    //   179: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -92 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	j
    //   0	185	1	paramMMHandler	MMHandler
    //   97	49	2	l	long
    // Exception table:
    //   from	to	target	type
    //   60	90	163	finally
    //   51	60	169	java/lang/InterruptedException
    //   164	169	169	java/lang/InterruptedException
  }
  
  protected abstract R run();
  
  public final void setResultFinish(R arg1)
  {
    Log.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
    this.result = ???;
    synchronized (this.lock)
    {
      Log.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
      this.lock.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.j
 * JD-Core Version:    0.7.0.1
 */