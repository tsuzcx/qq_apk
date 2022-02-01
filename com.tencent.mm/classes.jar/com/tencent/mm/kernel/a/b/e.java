package com.tencent.mm.kernel.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.b;
import com.tencent.mm.kernel.a.a.a.a;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.Assert;

public final class e<T>
{
  private static e mES = null;
  private Queue<c> mEL;
  private int mEM;
  private volatile a mEN;
  private volatile boolean mEO;
  private final byte[] mEP;
  private volatile a<Void, f.a> mEQ;
  private volatile c<T> mER;
  
  private e()
  {
    AppMethodBeat.i(158364);
    this.mEL = new LinkedList();
    this.mEO = false;
    this.mEP = new byte[0];
    AppMethodBeat.o(158364);
  }
  
  private void a(final c paramc, final f.a<T> parama)
  {
    AppMethodBeat.i(158376);
    paramc.mEW.arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(158359);
        f.a locala = parama;
        a locala1 = e.a(e.this);
        if (!locala.mEH)
        {
          locala.mFi.mFj.jPW();
          if (!locala.mEH)
          {
            locala1.call(locala);
            Log.d("MMSkeleton.ParallelsDependencies", "consume call functional %s, node %s", new Object[] { locala1, locala });
            locala.mEH = true;
          }
          locala.mFi.mFj.done();
        }
        e.b(e.this).a(parama);
        locala = e.b(e.this).bbh();
        if (locala == null)
        {
          e.a(e.this, paramc);
          AppMethodBeat.o(158359);
          return;
        }
        e.a(e.this, paramc, locala);
        e.c(e.this);
        AppMethodBeat.o(158359);
      }
    });
    AppMethodBeat.o(158376);
  }
  
  /* Error */
  private boolean a(c paramc)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 93
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 55	com/tencent/mm/kernel/a/b/e:mEL	Ljava/util/Queue;
    //   13: aload_1
    //   14: invokeinterface 99 2 0
    //   19: pop
    //   20: ldc 101
    //   22: ldc 103
    //   24: iconst_2
    //   25: anewarray 5	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_0
    //   31: getfield 55	com/tencent/mm/kernel/a/b/e:mEL	Ljava/util/Queue;
    //   34: invokeinterface 107 1 0
    //   39: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: aload_0
    //   46: getfield 115	com/tencent/mm/kernel/a/b/e:mEM	I
    //   49: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: invokestatic 121	com/tencent/mm/kernel/l:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: getfield 55	com/tencent/mm/kernel/a/b/e:mEL	Ljava/util/Queue;
    //   60: invokeinterface 107 1 0
    //   65: aload_0
    //   66: getfield 115	com/tencent/mm/kernel/a/b/e:mEM	I
    //   69: if_icmpne +12 -> 81
    //   72: ldc 93
    //   74: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: monitorexit
    //   79: iload_2
    //   80: ireturn
    //   81: ldc 93
    //   83: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: iconst_0
    //   87: istore_2
    //   88: goto -11 -> 77
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	e
    //   0	96	1	paramc	c
    //   1	87	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	77	91	finally
    //   81	86	91	finally
  }
  
  private void active()
  {
    AppMethodBeat.i(158375);
    c localc;
    for (;;)
    {
      localc = bbm();
      if (localc == null) {
        break label48;
      }
      f.a locala = this.mER.bbh();
      if (locala == null) {
        break;
      }
      a(localc, locala);
    }
    b(localc);
    AppMethodBeat.o(158375);
    return;
    label48:
    AppMethodBeat.o(158375);
  }
  
  private void b(c arg1)
  {
    AppMethodBeat.i(158374);
    if (a(???)) {
      synchronized (this.mEP)
      {
        if (this.mEO) {
          l.i("MMSkeleton.Parallels", "Parallels notify done", new Object[0]);
        }
        this.mEO = false;
        this.mEN.bbn();
        AppMethodBeat.o(158374);
        return;
      }
    }
    AppMethodBeat.o(158374);
  }
  
  public static e bbi()
  {
    return mES;
  }
  
  public static e bbj()
  {
    AppMethodBeat.i(158363);
    if (mES == null) {
      mES = new e();
    }
    e locale = mES;
    AppMethodBeat.o(158363);
    return locale;
  }
  
  private c bbm()
  {
    try
    {
      AppMethodBeat.i(158372);
      c localc = (c)this.mEL.poll();
      AppMethodBeat.o(158372);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(a parama, a<Void, f.a> parama1, c<T> paramc, String paramString)
  {
    AppMethodBeat.i(158368);
    if (a(parama, parama1, paramc))
    {
      paramc.prepare();
      start(paramString);
      bbk();
    }
    AppMethodBeat.o(158368);
  }
  
  public final boolean a(a parama, a<Void, f.a> parama1, c<T> paramc)
  {
    AppMethodBeat.i(158367);
    synchronized (this.mEP)
    {
      if (this.mEO)
      {
        Log.w("MMSkeleton.Parallels", "Arrange parallels task failed. It's busy on working.");
        Assert.assertTrue(false);
        AppMethodBeat.o(158367);
        return false;
      }
      this.mEN = parama;
      this.mEQ = parama1;
      this.mER = paramc;
      AppMethodBeat.o(158367);
      return true;
    }
  }
  
  public final void bbk()
  {
    AppMethodBeat.i(158369);
    this.mEN.bbk();
    AppMethodBeat.o(158369);
  }
  
  public final List<c> bbl()
  {
    try
    {
      AppMethodBeat.i(158371);
      LinkedList localLinkedList = new LinkedList(this.mEL);
      AppMethodBeat.o(158371);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void prepare()
  {
    try
    {
      AppMethodBeat.i(158366);
      int i = 0;
      while (i < this.mEM)
      {
        c localc = (c)((LinkedList)this.mEL).get(i);
        Handler localHandler = new Handler(localc.hgw.getLooper());
        h localh = new h(localHandler, localc.hgw.getName());
        localc.handler = localHandler;
        localc.mEW = localh;
        i += 1;
      }
      AppMethodBeat.o(158366);
      return;
    }
    finally {}
  }
  
  public final void sE(int paramInt)
  {
    try
    {
      AppMethodBeat.i(158365);
      int i = 0;
      while (i < paramInt)
      {
        Queue localQueue = this.mEL;
        HandlerThread localHandlerThread = new HandlerThread("parallels-".concat(String.valueOf(i)), -8);
        localHandlerThread.start();
        c localc = new c();
        localc.hgw = localHandlerThread;
        localQueue.add(localc);
        i += 1;
      }
      this.mEM = paramInt;
      AppMethodBeat.o(158365);
      return;
    }
    finally {}
  }
  
  public final void start(String arg1)
  {
    AppMethodBeat.i(158370);
    l.i("MMSkeleton.Parallels", "Start working. For %s", new Object[] { ??? });
    synchronized (this.mEP)
    {
      this.mEO = true;
      active();
      AppMethodBeat.o(158370);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bbk();
    
    public abstract void bbn();
  }
  
  public static final class b
    implements e.a
  {
    private final byte[] mLock;
    
    public b()
    {
      AppMethodBeat.i(158360);
      this.mLock = new byte[] { 0 };
      AppMethodBeat.o(158360);
    }
    
    public final void bbk()
    {
      AppMethodBeat.i(158361);
      try
      {
        synchronized (this.mLock)
        {
          if (this.mLock[0] == 0)
          {
            l.i("MMSkeleton.Parallels", "Waiting for lock(%s)", new Object[] { this.mLock });
            this.mLock.wait();
            AppMethodBeat.o(158361);
            return;
          }
          l.i("MMSkeleton.Parallels", "Not need wait for lock(%s)", new Object[] { this.mLock });
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.printErrStackTrace("MMSkeleton.Parallels", localInterruptedException, "", new Object[0]);
        AppMethodBeat.o(158361);
      }
    }
    
    public final void bbn()
    {
      AppMethodBeat.i(158362);
      synchronized (this.mLock)
      {
        this.mLock[0] = 1;
        this.mLock.notify();
        l.i("MMSkeleton.Parallels", "Lock(%s) notified", new Object[] { this.mLock });
        AppMethodBeat.o(158362);
        return;
      }
    }
  }
  
  public static final class c
  {
    Handler handler;
    public HandlerThread hgw;
    h mEW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.e
 * JD-Core Version:    0.7.0.1
 */