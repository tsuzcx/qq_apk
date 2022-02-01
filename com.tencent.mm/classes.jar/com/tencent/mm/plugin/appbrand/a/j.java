package com.tencent.mm.plugin.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class j<R>
{
  private final long cAH;
  long cAI;
  long cAJ;
  boolean cAK = false;
  public final Runnable cAL = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(162078);
      ad.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + j.this.cAK);
      if (j.this.cAK) {
        j.this.run();
      }
      for (;;)
      {
        j.this.cAJ = bt.aO(j.this.cAI);
        AppMethodBeat.o(162078);
        return;
        j.this.aG(j.this.run());
      }
    }
  };
  private final Object lock = new Object();
  public volatile ap mHandler;
  public R result;
  
  public j()
  {
    this(0L, null);
  }
  
  public j(long paramLong, R paramR)
  {
    this.cAH = paramLong;
    this.result = paramR;
  }
  
  public final void aG(R arg1)
  {
    ad.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
    this.result = ???;
    synchronized (this.lock)
    {
      ad.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
      this.lock.notify();
      return;
    }
  }
  
  /* Error */
  public final R b(ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 68	com/tencent/mm/plugin/appbrand/a/j:mHandler	Lcom/tencent/mm/sdk/platformtools/ap;
    //   5: ldc 48
    //   7: ldc 70
    //   9: invokestatic 56	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: invokestatic 76	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15: invokevirtual 80	java/lang/Thread:getId	()J
    //   18: aload_1
    //   19: invokevirtual 86	com/tencent/mm/sdk/platformtools/ap:getLooper	()Landroid/os/Looper;
    //   22: invokevirtual 91	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   25: invokevirtual 80	java/lang/Thread:getId	()J
    //   28: lcmp
    //   29: ifne +15 -> 44
    //   32: ldc 48
    //   34: ldc 93
    //   36: invokestatic 56	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: invokevirtual 97	com/tencent/mm/plugin/appbrand/a/j:run	()Ljava/lang/Object;
    //   43: areturn
    //   44: aload_0
    //   45: invokestatic 102	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   48: putfield 104	com/tencent/mm/plugin/appbrand/a/j:cAI	J
    //   51: aload_0
    //   52: getfield 31	com/tencent/mm/plugin/appbrand/a/j:lock	Ljava/lang/Object;
    //   55: astore 4
    //   57: aload 4
    //   59: monitorenter
    //   60: ldc 48
    //   62: ldc 106
    //   64: invokestatic 56	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_1
    //   68: aload_0
    //   69: getfield 38	com/tencent/mm/plugin/appbrand/a/j:cAL	Ljava/lang/Runnable;
    //   72: invokevirtual 110	com/tencent/mm/sdk/platformtools/ap:post	(Ljava/lang/Runnable;)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 31	com/tencent/mm/plugin/appbrand/a/j:lock	Ljava/lang/Object;
    //   80: aload_0
    //   81: getfield 40	com/tencent/mm/plugin/appbrand/a/j:cAH	J
    //   84: invokevirtual 114	java/lang/Object:wait	(J)V
    //   87: aload 4
    //   89: monitorexit
    //   90: aload_0
    //   91: getfield 104	com/tencent/mm/plugin/appbrand/a/j:cAI	J
    //   94: invokestatic 118	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   97: lstore_2
    //   98: ldc 48
    //   100: ldc 120
    //   102: iconst_4
    //   103: anewarray 5	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: new 122	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   115: aload_0
    //   116: getfield 42	com/tencent/mm/plugin/appbrand/a/j:result	Ljava/lang/Object;
    //   119: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: lload_2
    //   129: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   132: aastore
    //   133: dup
    //   134: iconst_2
    //   135: aload_0
    //   136: getfield 139	com/tencent/mm/plugin/appbrand/a/j:cAJ	J
    //   139: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   142: aastore
    //   143: dup
    //   144: iconst_3
    //   145: lload_2
    //   146: aload_0
    //   147: getfield 139	com/tencent/mm/plugin/appbrand/a/j:cAJ	J
    //   150: lsub
    //   151: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   154: aastore
    //   155: invokestatic 142	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: aload_0
    //   159: getfield 42	com/tencent/mm/plugin/appbrand/a/j:result	Ljava/lang/Object;
    //   162: areturn
    //   163: astore_1
    //   164: aload 4
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: ldc 48
    //   172: aload_1
    //   173: ldc 144
    //   175: iconst_0
    //   176: anewarray 5	java/lang/Object
    //   179: invokestatic 148	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -92 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	j
    //   0	185	1	paramap	ap
    //   97	49	2	l	long
    // Exception table:
    //   from	to	target	type
    //   60	90	163	finally
    //   164	167	163	finally
    //   51	60	169	java/lang/InterruptedException
    //   167	169	169	java/lang/InterruptedException
  }
  
  protected abstract R run();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.j
 * JD-Core Version:    0.7.0.1
 */