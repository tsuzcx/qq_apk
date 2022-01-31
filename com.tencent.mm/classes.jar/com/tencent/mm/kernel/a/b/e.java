package com.tencent.mm.kernel.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.ck.b;
import com.tencent.mm.kernel.a.a.a.a;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.Assert;

public final class e<T>
{
  private static e dMt = null;
  private Queue<c> dMm = new LinkedList();
  private int dMn;
  private volatile a dMo;
  private volatile boolean dMp = false;
  private final byte[] dMq = new byte[0];
  private volatile a<Void, f.a> dMr;
  private volatile c<T> dMs;
  
  public static e Ej()
  {
    return dMt;
  }
  
  public static e Ek()
  {
    if (dMt == null) {
      dMt = new e();
    }
    return dMt;
  }
  
  private c En()
  {
    try
    {
      c localc = (c)this.dMm.poll();
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(final c paramc, final f.a<T> parama)
  {
    paramc.dMx.k(new Runnable()
    {
      public final void run()
      {
        f.a locala = parama;
        a locala1 = e.a(e.this);
        if (!locala.dMh)
        {
          locala.dMH.dMI.cNA();
          if (!locala.dMh)
          {
            locala1.call(locala);
            y.d("MMSkeleton.ParallelsDependencies", "consume call functional %s, node %s", new Object[] { locala1, locala });
            locala.dMh = true;
          }
          locala.dMH.dMI.done();
        }
        e.b(e.this).a(parama);
        locala = e.b(e.this).Ei();
        if (locala == null)
        {
          e.a(e.this, paramc);
          return;
        }
        e.a(e.this, paramc, locala);
        e.c(e.this);
      }
    });
  }
  
  /* Error */
  private boolean a(c paramc)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 48	com/tencent/mm/kernel/a/b/e:dMm	Ljava/util/Queue;
    //   9: aload_1
    //   10: invokeinterface 95 2 0
    //   15: pop
    //   16: ldc 97
    //   18: ldc 99
    //   20: iconst_2
    //   21: anewarray 5	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 48	com/tencent/mm/kernel/a/b/e:dMm	Ljava/util/Queue;
    //   30: invokeinterface 103 1 0
    //   35: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_0
    //   42: getfield 111	com/tencent/mm/kernel/a/b/e:dMn	I
    //   45: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: invokestatic 117	com/tencent/mm/kernel/k:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload_0
    //   53: getfield 48	com/tencent/mm/kernel/a/b/e:dMm	Ljava/util/Queue;
    //   56: invokeinterface 103 1 0
    //   61: istore_2
    //   62: aload_0
    //   63: getfield 111	com/tencent/mm/kernel/a/b/e:dMn	I
    //   66: istore_3
    //   67: iload_2
    //   68: iload_3
    //   69: if_icmpne +8 -> 77
    //   72: aload_0
    //   73: monitorexit
    //   74: iload 4
    //   76: ireturn
    //   77: iconst_0
    //   78: istore 4
    //   80: goto -8 -> 72
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	e
    //   0	88	1	paramc	c
    //   61	9	2	i	int
    //   66	4	3	j	int
    //   1	78	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	67	83	finally
  }
  
  private void active()
  {
    c localc;
    for (;;)
    {
      localc = En();
      if (localc == null) {
        return;
      }
      f.a locala = this.dMs.Ei();
      if (locala == null) {
        break;
      }
      a(localc, locala);
    }
    b(localc);
  }
  
  private void b(c arg1)
  {
    if (a(???)) {
      synchronized (this.dMq)
      {
        if (this.dMp) {
          k.i("MMSkeleton.Parallels", "Parallels notify done", new Object[0]);
        }
        this.dMp = false;
        this.dMo.Eo();
        return;
      }
    }
  }
  
  public final void El()
  {
    this.dMo.El();
  }
  
  public final List<c> Em()
  {
    try
    {
      LinkedList localLinkedList = new LinkedList(this.dMm);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(a parama, a<Void, f.a> parama1, c<T> paramc, String paramString)
  {
    if (a(parama, parama1, paramc))
    {
      paramc.prepare();
      start(paramString);
      El();
    }
  }
  
  public final boolean a(a parama, a<Void, f.a> parama1, c<T> paramc)
  {
    synchronized (this.dMq)
    {
      if (this.dMp)
      {
        y.w("MMSkeleton.Parallels", "Arrange parallels task failed. It's busy on working.");
        Assert.assertTrue(false);
        return false;
      }
      this.dMo = parama;
      this.dMr = parama1;
      this.dMs = paramc;
      return true;
    }
  }
  
  public final void init(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramInt) {}
      try
      {
        Queue localQueue = this.dMm;
        HandlerThread localHandlerThread = new HandlerThread("parallels-" + i, -8);
        localHandlerThread.start();
        c localc = new c();
        localc.bwv = localHandlerThread;
        localQueue.add(localc);
        i += 1;
      }
      finally {}
    }
    this.dMn = paramInt;
  }
  
  public final void prepare()
  {
    int i = 0;
    try
    {
      while (i < this.dMn)
      {
        c localc = (c)((LinkedList)this.dMm).get(i);
        Handler localHandler = new Handler(localc.bwv.getLooper());
        h localh = new h(localHandler, localc.bwv.getName());
        localc.handler = localHandler;
        localc.dMx = localh;
        i += 1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void start(String arg1)
  {
    k.i("MMSkeleton.Parallels", "Start working. For %s", new Object[] { ??? });
    synchronized (this.dMq)
    {
      this.dMp = true;
      active();
      return;
    }
  }
  
  public final void stop() {}
  
  public static abstract interface a
  {
    public abstract void El();
    
    public abstract void Eo();
  }
  
  public static final class b
    implements e.a
  {
    private final byte[] dIn = { 0 };
    
    public final void El()
    {
      try
      {
        synchronized (this.dIn)
        {
          if (this.dIn[0] == 0)
          {
            k.i("MMSkeleton.Parallels", "Waiting for lock(%s)", new Object[] { this.dIn });
            this.dIn.wait();
            return;
          }
          k.i("MMSkeleton.Parallels", "Not need wait for lock(%s)", new Object[] { this.dIn });
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        y.printErrStackTrace("MMSkeleton.Parallels", localInterruptedException, "", new Object[0]);
      }
    }
    
    public final void Eo()
    {
      synchronized (this.dIn)
      {
        this.dIn[0] = 1;
        this.dIn.notify();
        k.i("MMSkeleton.Parallels", "Lock(%s) notified", new Object[] { this.dIn });
        return;
      }
    }
  }
  
  public static final class c
  {
    public HandlerThread bwv;
    h dMx;
    Handler handler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.e
 * JD-Core Version:    0.7.0.1
 */