package com.tencent.matrix.trace.core;

import android.view.Choreographer;
import com.tencent.matrix.trace.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

public final class b
  implements Runnable
{
  private static final b bRs = new b();
  public long bLF = 16666666L;
  private long[] bRA = new long[3];
  public boolean bRB = false;
  public a bRa;
  private volatile boolean bRn = false;
  private long[] bRo = new long[4];
  private HashSet<com.tencent.matrix.trace.e.c> bRp = new HashSet();
  private volatile long bRq = 0L;
  private boolean bRr = false;
  public Object bRt;
  public Object[] bRu;
  public Method bRv;
  public Method bRw;
  public Method bRx;
  private int[] bRy = new int[3];
  private boolean[] bRz = new boolean[3];
  public Choreographer choreographer;
  
  private void b(int paramInt, Runnable paramRunnable)
  {
    Method localMethod = null;
    try
    {
      if (this.bRz[paramInt] != 0) {
        com.tencent.matrix.g.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] this type %s callback has exist! isAddHeader:%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE });
      }
      for (;;)
      {
        return;
        if ((!this.bRn) && (paramInt == 0)) {
          com.tencent.matrix.g.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] UIThreadMonitor is not alive!", new Object[0]);
        } else {
          try
          {
            localObject = this.bRt;
            switch (paramInt)
            {
            default: 
              if (localMethod != null) {}
              try
              {
                localMethod.invoke(this.bRu[paramInt], new Object[] { Long.valueOf(-1L), paramRunnable, null });
                this.bRz[paramInt] = true;
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
      localMethod = this.bRw;
      continue;
      localMethod = this.bRx;
      continue;
      localMethod = this.bRv;
    }
  }
  
  public static Method d(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramObject = paramObject.getClass().getDeclaredMethod(paramString, paramVarArgs);
      paramObject.setAccessible(true);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", paramObject.toString(), new Object[0]);
    }
    return null;
  }
  
  public static <T> T e(Object paramObject, String paramString)
  {
    try
    {
      paramString = paramObject.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", paramObject.toString(), new Object[0]);
    }
    return null;
  }
  
  private void fQ(int paramInt)
  {
    this.bRy[paramInt] = 1;
    this.bRA[paramInt] = System.nanoTime();
  }
  
  private void fR(int paramInt)
  {
    this.bRy[paramInt] = 2;
    this.bRA[paramInt] = (System.nanoTime() - this.bRA[paramInt]);
    try
    {
      this.bRz[paramInt] = false;
      return;
    }
    finally {}
  }
  
  public static b zt()
  {
    return bRs;
  }
  
  public final void a(com.tencent.matrix.trace.e.c paramc)
  {
    if (!this.bRn) {
      onStart();
    }
    synchronized (this.bRp)
    {
      this.bRp.add(paramc);
      return;
    }
  }
  
  public final void b(com.tencent.matrix.trace.e.c paramc)
  {
    synchronized (this.bRp)
    {
      this.bRp.remove(paramc);
      if (this.bRp.isEmpty()) {
        onStop();
      }
      return;
    }
  }
  
  public final void onStart()
  {
    try
    {
      if (!this.bRB) {
        throw new RuntimeException("never init!");
      }
    }
    finally {}
    if (!this.bRn) {
      this.bRn = true;
    }
    try
    {
      com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[onStart] callbackExist:%s %s", new Object[] { Arrays.toString(this.bRz), com.tencent.matrix.trace.g.b.getStack() });
      this.bRz = new boolean[3];
      this.bRy = new int[3];
      this.bRA = new long[3];
      b(0, this);
      return;
    }
    finally {}
  }
  
  public final void onStop()
  {
    try
    {
      if (!this.bRB) {
        throw new RuntimeException("UIThreadMonitor is never init!");
      }
    }
    finally {}
    if (this.bRn)
    {
      this.bRn = false;
      com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[onStop] callbackExist:%s %s", new Object[] { Arrays.toString(this.bRz), com.tencent.matrix.trace.g.b.getStack() });
    }
  }
  
  public final long r(int paramInt, long paramLong)
  {
    if (paramLong != this.bRq) {
      return -1L;
    }
    if (this.bRy[paramInt] == 2) {
      return this.bRA[paramInt];
    }
    return 0L;
  }
  
  public final void run()
  {
    long l1 = System.nanoTime();
    try
    {
      long l2 = this.bRq;
      this.bRr = true;
      fQ(0);
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
      if (this.bRa.bQX) {
        com.tencent.matrix.g.c.d("Matrix.UIThreadMonitor", "[UIThreadMonitor#run] inner cost:%sns", new Object[] { Long.valueOf(System.nanoTime() - l1) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.core.b
 * JD-Core Version:    0.7.0.1
 */