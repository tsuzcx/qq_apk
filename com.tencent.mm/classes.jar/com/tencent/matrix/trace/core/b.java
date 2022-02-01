package com.tencent.matrix.trace.core;

import android.view.Choreographer;
import com.tencent.matrix.e.f;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

public final class b
  implements Runnable
{
  private static final b feE = new b();
  public static boolean feF;
  public Choreographer choreographer;
  public long eLi = 16666666L;
  public com.tencent.matrix.trace.a.b fdU;
  private long[] feA = new long[4];
  private final HashSet<com.tencent.matrix.trace.e.c> feB = new HashSet();
  private volatile long feC = 0L;
  private boolean feD = false;
  public Object feG;
  public Object[] feH;
  public Method feI;
  public Method feJ;
  public Method feK;
  public Object feL;
  private int[] feM = new int[3];
  private boolean[] feN = new boolean[3];
  private long[] feO = new long[3];
  private long[] feP = null;
  private volatile boolean fez = false;
  public boolean isInit = false;
  
  public static b azL()
  {
    return feE;
  }
  
  private void b(int paramInt, Runnable paramRunnable)
  {
    Method localMethod = null;
    try
    {
      if (this.feN[paramInt] != 0) {
        com.tencent.matrix.e.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] this type %s callback has exist! isAddHeader:%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE });
      }
      for (;;)
      {
        return;
        if ((!this.fez) && (paramInt == 0)) {
          com.tencent.matrix.e.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] UIThreadMonitor is not alive!", new Object[0]);
        } else {
          try
          {
            localObject = this.feG;
            switch (paramInt)
            {
            default: 
              if (localMethod != null) {}
              try
              {
                localMethod.invoke(this.feH[paramInt], new Object[] { Long.valueOf(-1L), paramRunnable, null });
                this.feN[paramInt] = true;
              }
              finally {}
            }
          }
          catch (Exception paramRunnable)
          {
            com.tencent.matrix.e.c.e("Matrix.UIThreadMonitor", paramRunnable.toString(), new Object[0]);
          }
        }
      }
    }
    finally {}
    for (;;)
    {
      Object localObject;
      localMethod = this.feJ;
      continue;
      localMethod = this.feK;
      continue;
      localMethod = this.feI;
    }
  }
  
  private long dO(long paramLong)
  {
    try
    {
      long l = ((Long)f.c(this.feL, "mTimestampNanos", Long.valueOf(paramLong))).longValue();
      return l;
    }
    catch (Exception localException)
    {
      com.tencent.matrix.e.c.e("Matrix.UIThreadMonitor", localException.toString(), new Object[0]);
    }
    return paramLong;
  }
  
  private void nw(int paramInt)
  {
    this.feM[paramInt] = 1;
    this.feO[paramInt] = System.nanoTime();
  }
  
  private void nx(int paramInt)
  {
    this.feM[paramInt] = 2;
    this.feO[paramInt] = (System.nanoTime() - this.feO[paramInt]);
    try
    {
      this.feN[paramInt] = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(com.tencent.matrix.trace.e.c paramc)
  {
    if (!this.fez) {
      onStart();
    }
    synchronized (this.feB)
    {
      this.feB.add(paramc);
      return;
    }
  }
  
  public final void b(com.tencent.matrix.trace.e.c paramc)
  {
    synchronized (this.feB)
    {
      this.feB.remove(paramc);
      if (this.feB.isEmpty()) {
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
        com.tencent.matrix.e.c.e("Matrix.UIThreadMonitor", "[onStart] is never init.", new Object[0]);
      }
      while (this.fez) {
        return;
      }
      this.fez = true;
    }
    finally
    {
      try
      {
        for (;;)
        {
          com.tencent.matrix.e.c.i("Matrix.UIThreadMonitor", "[onStart] callbackExist:%s %s", new Object[] { Arrays.toString(this.feN), com.tencent.matrix.trace.f.c.getStack() });
          this.feN = new boolean[3];
          if (!feF)
          {
            this.feM = new int[3];
            this.feO = new long[3];
            b(0, this);
          }
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
    //   3: getfield 82	com/tencent/matrix/trace/core/b:isInit	Z
    //   6: ifne +18 -> 24
    //   9: ldc 99
    //   11: ldc_w 291
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 145	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 59	com/tencent/matrix/trace/core/b:fez	Z
    //   28: ifeq -7 -> 21
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 59	com/tencent/matrix/trace/core/b:fez	Z
    //   36: ldc 99
    //   38: ldc_w 307
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_0
    //   48: getfield 78	com/tencent/matrix/trace/core/b:feN	[Z
    //   51: invokestatic 298	java/util/Arrays:toString	([Z)Ljava/lang/String;
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: invokestatic 303	com/tencent/matrix/trace/f/c:getStack	()Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 305	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      long l2 = this.feC;
      this.feD = true;
      nw(0);
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
      if (this.fdU.fdK) {
        com.tencent.matrix.e.c.d("Matrix.UIThreadMonitor", "[UIThreadMonitor#run] inner cost:%sns", new Object[] { Long.valueOf(System.nanoTime() - l1) });
      }
    }
  }
  
  public final long x(int paramInt, long paramLong)
  {
    if (paramLong != this.feC) {
      return -1L;
    }
    if (this.feM[paramInt] == 2) {
      return this.feO[paramInt];
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.core.b
 * JD-Core Version:    0.7.0.1
 */