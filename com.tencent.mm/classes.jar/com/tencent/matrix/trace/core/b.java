package com.tencent.matrix.trace.core;

import android.view.Choreographer;
import com.tencent.matrix.g.f;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

public final class b
  implements Runnable
{
  private static final b cCc = new b();
  public com.tencent.matrix.trace.a.b cBH;
  private volatile boolean cBX = false;
  private long[] cBY = new long[4];
  private final HashSet<com.tencent.matrix.trace.e.c> cBZ = new HashSet();
  private volatile long cCa = 0L;
  private boolean cCb = false;
  public Object cCd;
  public Object[] cCe;
  public Method cCf;
  public Method cCg;
  public Method cCh;
  public Object cCi;
  private int[] cCj = new int[3];
  private boolean[] cCk = new boolean[3];
  private long[] cCl = new long[3];
  private long[] cCm = null;
  public Choreographer choreographer;
  public long csA = 16666666L;
  public boolean csX = false;
  
  public static b HU()
  {
    return cCc;
  }
  
  private long aW(long paramLong)
  {
    try
    {
      long l = ((Long)f.b(this.cCi, "mTimestampNanos", Long.valueOf(paramLong))).longValue();
      return l;
    }
    catch (Exception localException)
    {
      com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", localException.toString(), new Object[0]);
    }
    return paramLong;
  }
  
  private void b(int paramInt, Runnable paramRunnable)
  {
    Method localMethod = null;
    try
    {
      if (this.cCk[paramInt] != 0) {
        com.tencent.matrix.g.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] this type %s callback has exist! isAddHeader:%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE });
      }
      for (;;)
      {
        return;
        if ((!this.cBX) && (paramInt == 0)) {
          com.tencent.matrix.g.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] UIThreadMonitor is not alive!", new Object[0]);
        } else {
          try
          {
            localObject = this.cCd;
            switch (paramInt)
            {
            default: 
              if (localMethod != null) {}
              try
              {
                localMethod.invoke(this.cCe[paramInt], new Object[] { Long.valueOf(-1L), paramRunnable, null });
                this.cCk[paramInt] = true;
              }
              finally {}
            }
          }
          catch (Exception paramRunnable)
          {
            com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", paramRunnable.toString(), new Object[0]);
          }
        }
      }
    }
    finally {}
    for (;;)
    {
      Object localObject;
      localMethod = this.cCg;
      continue;
      localMethod = this.cCh;
      continue;
      localMethod = this.cCf;
    }
  }
  
  private void hm(int paramInt)
  {
    this.cCj[paramInt] = 1;
    this.cCl[paramInt] = System.nanoTime();
  }
  
  private void hn(int paramInt)
  {
    this.cCj[paramInt] = 2;
    this.cCl[paramInt] = (System.nanoTime() - this.cCl[paramInt]);
    try
    {
      this.cCk[paramInt] = false;
      return;
    }
    finally {}
  }
  
  public final void a(com.tencent.matrix.trace.e.c paramc)
  {
    if (!this.cBX) {
      onStart();
    }
    synchronized (this.cBZ)
    {
      this.cBZ.add(paramc);
      return;
    }
  }
  
  public final void b(com.tencent.matrix.trace.e.c paramc)
  {
    synchronized (this.cBZ)
    {
      this.cBZ.remove(paramc);
      if (this.cBZ.isEmpty()) {
        onStop();
      }
      return;
    }
  }
  
  public final void onStart()
  {
    try
    {
      if (!this.csX) {
        com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", "[onStart] is never init.", new Object[0]);
      }
      while (this.cBX) {
        return;
      }
      this.cBX = true;
    }
    finally
    {
      try
      {
        for (;;)
        {
          com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[onStart] callbackExist:%s %s", new Object[] { Arrays.toString(this.cCk), com.tencent.matrix.trace.g.b.getStack() });
          this.cCk = new boolean[3];
          this.cCj = new int[3];
          this.cCl = new long[3];
          b(0, this);
        }
      }
      finally {}
      localObject1 = finally;
    }
  }
  
  /* Error */
  public final void onStop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/matrix/trace/core/b:csX	Z
    //   6: ifne +18 -> 24
    //   9: ldc 110
    //   11: ldc_w 264
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 120	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 50	com/tencent/matrix/trace/core/b:cBX	Z
    //   28: ifeq -7 -> 21
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 50	com/tencent/matrix/trace/core/b:cBX	Z
    //   36: ldc 110
    //   38: ldc_w 280
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_0
    //   48: getfield 69	com/tencent/matrix/trace/core/b:cCk	[Z
    //   51: invokestatic 271	java/util/Arrays:toString	([Z)Ljava/lang/String;
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: invokestatic 276	com/tencent/matrix/trace/g/b:getStack	()Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 278	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: goto -43 -> 21
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	b
    //   67	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	67	finally
    //   24	64	67	finally
  }
  
  public final void run()
  {
    long l1 = System.nanoTime();
    try
    {
      long l2 = this.cCa;
      this.cCb = true;
      hm(0);
      b(1, new b.3(this));
      b(2, new b.4(this));
      return;
    }
    finally
    {
      if (this.cBH.cBD) {
        com.tencent.matrix.g.c.d("Matrix.UIThreadMonitor", "[UIThreadMonitor#run] inner cost:%sns", new Object[] { Long.valueOf(System.nanoTime() - l1) });
      }
    }
  }
  
  public final long t(int paramInt, long paramLong)
  {
    if (paramLong != this.cCa) {
      return -1L;
    }
    if (this.cCj[paramInt] == 2) {
      return this.cCl[paramInt];
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.core.b
 * JD-Core Version:    0.7.0.1
 */