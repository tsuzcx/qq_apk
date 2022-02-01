package com.tencent.magicbrush.utils;

import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class d<R>
{
  private final long cpQ;
  long cpR;
  long cpS;
  boolean cpT = false;
  private Runnable cpU = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(161137);
      c.c.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + d.this.cpT, new Object[0]);
      if (d.this.cpT) {
        d.this.run();
      }
      for (;;)
      {
        d.this.cpS = h.aO(d.this.cpR);
        AppMethodBeat.o(161137);
        return;
        d.this.aE(d.this.run());
      }
    }
  };
  private Object lock = new Object();
  private R result;
  
  public d(long paramLong)
  {
    this.cpQ = paramLong;
    this.result = null;
    this.cpT = true;
  }
  
  public final void aE(R arg1)
  {
    c.c.i("MicroMsg.SDK.SyncTask", "setResultFinish ", new Object[0]);
    this.result = ???;
    synchronized (this.lock)
    {
      c.c.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized", new Object[0]);
      this.lock.notify();
      return;
    }
  }
  
  /* Error */
  public final R b(com.tencent.magicbrush.handler.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +19 -> 20
    //   4: ldc 43
    //   6: ldc 63
    //   8: iconst_0
    //   9: anewarray 5	java/lang/Object
    //   12: invokestatic 66	com/tencent/magicbrush/a/c$c:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: invokevirtual 70	com/tencent/magicbrush/utils/d:run	()Ljava/lang/Object;
    //   19: areturn
    //   20: ldc 43
    //   22: ldc 72
    //   24: iconst_0
    //   25: anewarray 5	java/lang/Object
    //   28: invokestatic 51	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aload_0
    //   32: invokestatic 78	com/tencent/magicbrush/utils/h:Gn	()J
    //   35: putfield 80	com/tencent/magicbrush/utils/d:cpR	J
    //   38: aload_0
    //   39: getfield 26	com/tencent/magicbrush/utils/d:lock	Ljava/lang/Object;
    //   42: astore 4
    //   44: aload 4
    //   46: monitorenter
    //   47: ldc 43
    //   49: ldc 82
    //   51: iconst_0
    //   52: anewarray 5	java/lang/Object
    //   55: invokestatic 51	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 33	com/tencent/magicbrush/utils/d:cpU	Ljava/lang/Runnable;
    //   63: iconst_0
    //   64: invokeinterface 88 3 0
    //   69: aload_0
    //   70: getfield 26	com/tencent/magicbrush/utils/d:lock	Ljava/lang/Object;
    //   73: aload_0
    //   74: getfield 35	com/tencent/magicbrush/utils/d:cpQ	J
    //   77: invokevirtual 91	java/lang/Object:wait	(J)V
    //   80: aload 4
    //   82: monitorexit
    //   83: aload_0
    //   84: getfield 80	com/tencent/magicbrush/utils/d:cpR	J
    //   87: invokestatic 95	com/tencent/magicbrush/utils/h:aO	(J)J
    //   90: lstore_2
    //   91: ldc 43
    //   93: ldc 97
    //   95: iconst_4
    //   96: anewarray 5	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: new 99	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   108: aload_0
    //   109: getfield 37	com/tencent/magicbrush/utils/d:result	Ljava/lang/Object;
    //   112: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: lload_2
    //   122: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   125: aastore
    //   126: dup
    //   127: iconst_2
    //   128: aload_0
    //   129: getfield 116	com/tencent/magicbrush/utils/d:cpS	J
    //   132: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   135: aastore
    //   136: dup
    //   137: iconst_3
    //   138: lload_2
    //   139: aload_0
    //   140: getfield 116	com/tencent/magicbrush/utils/d:cpS	J
    //   143: lsub
    //   144: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   147: aastore
    //   148: invokestatic 51	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: getfield 37	com/tencent/magicbrush/utils/d:result	Ljava/lang/Object;
    //   155: areturn
    //   156: astore_1
    //   157: aload 4
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: ldc 43
    //   165: aload_1
    //   166: ldc 118
    //   168: iconst_0
    //   169: anewarray 5	java/lang/Object
    //   172: invokestatic 122	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: goto -92 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	d
    //   0	178	1	parama	com.tencent.magicbrush.handler.a
    //   90	49	2	l	long
    // Exception table:
    //   from	to	target	type
    //   47	83	156	finally
    //   157	160	156	finally
    //   38	47	162	java/lang/InterruptedException
    //   160	162	162	java/lang/InterruptedException
  }
  
  protected abstract R run();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.utils.d
 * JD-Core Version:    0.7.0.1
 */