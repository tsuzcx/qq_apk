package com.tencent.matrix.trace.core;

import android.view.Choreographer;
import com.tencent.matrix.g.f;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

public final class b
  implements Runnable
{
  private static final b dbo = new b();
  public long cPm = 16666666L;
  public Choreographer choreographer;
  public com.tencent.matrix.trace.a.b daS;
  private volatile boolean dbi = false;
  private long[] dbj = new long[4];
  private final HashSet<com.tencent.matrix.trace.e.c> dbk = new HashSet();
  private volatile long dbl = 0L;
  private boolean dbn = false;
  public Object dbp;
  public Object[] dbq;
  public Method dbr;
  public Method dbs;
  public Method dbt;
  public Object dbu;
  private int[] dbv = new int[3];
  private boolean[] dbw = new boolean[3];
  private long[] dbx = new long[3];
  private long[] dby = null;
  public boolean isInit = false;
  
  public static b Tw()
  {
    return dbo;
  }
  
  private void b(int paramInt, Runnable paramRunnable)
  {
    Method localMethod = null;
    try
    {
      if (this.dbw[paramInt] != 0) {
        com.tencent.matrix.g.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] this type %s callback has exist! isAddHeader:%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE });
      }
      for (;;)
      {
        return;
        if ((!this.dbi) && (paramInt == 0)) {
          com.tencent.matrix.g.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] UIThreadMonitor is not alive!", new Object[0]);
        } else {
          try
          {
            localObject = this.dbp;
            switch (paramInt)
            {
            default: 
              if (localMethod != null) {}
              try
              {
                localMethod.invoke(this.dbq[paramInt], new Object[] { Long.valueOf(-1L), paramRunnable, null });
                this.dbw[paramInt] = true;
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
      localMethod = this.dbs;
      continue;
      localMethod = this.dbt;
      continue;
      localMethod = this.dbr;
    }
  }
  
  private long bh(long paramLong)
  {
    try
    {
      long l = ((Long)f.b(this.dbu, "mTimestampNanos", Long.valueOf(paramLong))).longValue();
      return l;
    }
    catch (Exception localException)
    {
      com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", localException.toString(), new Object[0]);
    }
    return paramLong;
  }
  
  private void iv(int paramInt)
  {
    this.dbv[paramInt] = 1;
    this.dbx[paramInt] = System.nanoTime();
  }
  
  private void iw(int paramInt)
  {
    this.dbv[paramInt] = 2;
    this.dbx[paramInt] = (System.nanoTime() - this.dbx[paramInt]);
    try
    {
      this.dbw[paramInt] = false;
      return;
    }
    finally {}
  }
  
  public final void a(com.tencent.matrix.trace.e.c paramc)
  {
    if (!this.dbi) {
      onStart();
    }
    synchronized (this.dbk)
    {
      this.dbk.add(paramc);
      return;
    }
  }
  
  public final void b(com.tencent.matrix.trace.e.c paramc)
  {
    synchronized (this.dbk)
    {
      this.dbk.remove(paramc);
      if (this.dbk.isEmpty()) {
        onStop();
      }
      return;
    }
  }
  
  public final void onStart()
  {
    try
    {
      if (!this.isInit) {
        com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", "[onStart] is never init.", new Object[0]);
      }
      while (this.dbi) {
        return;
      }
      this.dbi = true;
    }
    finally
    {
      try
      {
        for (;;)
        {
          com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[onStart] callbackExist:%s %s", new Object[] { Arrays.toString(this.dbw), com.tencent.matrix.trace.g.b.getStack() });
          this.dbw = new boolean[3];
          this.dbv = new int[3];
          this.dbx = new long[3];
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
    //   3: getfield 81	com/tencent/matrix/trace/core/b:isInit	Z
    //   6: ifne +18 -> 24
    //   9: ldc 98
    //   11: ldc_w 272
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 144	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 58	com/tencent/matrix/trace/core/b:dbi	Z
    //   28: ifeq -7 -> 21
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 58	com/tencent/matrix/trace/core/b:dbi	Z
    //   36: ldc 98
    //   38: ldc_w 288
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_0
    //   48: getfield 77	com/tencent/matrix/trace/core/b:dbw	[Z
    //   51: invokestatic 279	java/util/Arrays:toString	([Z)Ljava/lang/String;
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: invokestatic 284	com/tencent/matrix/trace/g/b:getStack	()Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 286	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      long l2 = this.dbl;
      this.dbn = true;
      iv(0);
      b(1, new Runnable()
      {
        public final void run()
        {
          b.a(b.this, 0);
          b.b(b.this, 1);
        }
      });
      b(2, new Runnable()
      {
        public final void run()
        {
          b.a(b.this, 1);
          b.b(b.this, 2);
        }
      });
      return;
    }
    finally
    {
      if (this.daS.daO) {
        com.tencent.matrix.g.c.d("Matrix.UIThreadMonitor", "[UIThreadMonitor#run] inner cost:%sns", new Object[] { Long.valueOf(System.nanoTime() - l1) });
      }
    }
  }
  
  public final long u(int paramInt, long paramLong)
  {
    if (paramLong != this.dbl) {
      return -1L;
    }
    if (this.dbv[paramInt] == 2) {
      return this.dbx[paramInt];
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.trace.core.b
 * JD-Core Version:    0.7.0.1
 */