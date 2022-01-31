package com.tencent.mm.kernel.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.b;
import com.tencent.mm.kernel.a.a.a.a;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.Assert;

public final class e<T>
{
  private static e eJU = null;
  private Queue<c> eJN;
  private int eJO;
  private volatile a eJP;
  private volatile boolean eJQ;
  private final byte[] eJR;
  private volatile a<Void, f.a> eJS;
  private volatile c<T> eJT;
  
  private e()
  {
    AppMethodBeat.i(123311);
    this.eJN = new LinkedList();
    this.eJQ = false;
    this.eJR = new byte[0];
    AppMethodBeat.o(123311);
  }
  
  public static e Sn()
  {
    return eJU;
  }
  
  public static e So()
  {
    AppMethodBeat.i(123310);
    if (eJU == null) {
      eJU = new e();
    }
    e locale = eJU;
    AppMethodBeat.o(123310);
    return locale;
  }
  
  private c Sr()
  {
    try
    {
      AppMethodBeat.i(123319);
      c localc = (c)this.eJN.poll();
      AppMethodBeat.o(123319);
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
    AppMethodBeat.i(123323);
    paramc.eJY.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123306);
        f.a locala = parama;
        a locala1 = e.a(e.this);
        if (!locala.eJI)
        {
          locala.eKj.eKk.dTf();
          if (!locala.eJI)
          {
            locala1.call(locala);
            ab.d("MMSkeleton.ParallelsDependencies", "consume call functional %s, node %s", new Object[] { locala1, locala });
            locala.eJI = true;
          }
          locala.eKj.eKk.done();
        }
        e.b(e.this).a(parama);
        locala = e.b(e.this).Sm();
        if (locala == null)
        {
          e.a(e.this, paramc);
          AppMethodBeat.o(123306);
          return;
        }
        e.a(e.this, paramc, locala);
        e.c(e.this);
        AppMethodBeat.o(123306);
      }
    });
    AppMethodBeat.o(123323);
  }
  
  /* Error */
  private boolean a(c paramc)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 106
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 55	com/tencent/mm/kernel/a/b/e:eJN	Ljava/util/Queue;
    //   13: aload_1
    //   14: invokeinterface 110 2 0
    //   19: pop
    //   20: ldc 112
    //   22: ldc 114
    //   24: iconst_2
    //   25: anewarray 5	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_0
    //   31: getfield 55	com/tencent/mm/kernel/a/b/e:eJN	Ljava/util/Queue;
    //   34: invokeinterface 118 1 0
    //   39: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: aload_0
    //   46: getfield 126	com/tencent/mm/kernel/a/b/e:eJO	I
    //   49: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: invokestatic 132	com/tencent/mm/kernel/j:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: getfield 55	com/tencent/mm/kernel/a/b/e:eJN	Ljava/util/Queue;
    //   60: invokeinterface 118 1 0
    //   65: aload_0
    //   66: getfield 126	com/tencent/mm/kernel/a/b/e:eJO	I
    //   69: if_icmpne +12 -> 81
    //   72: ldc 106
    //   74: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: monitorexit
    //   79: iload_2
    //   80: ireturn
    //   81: ldc 106
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
    AppMethodBeat.i(123322);
    c localc;
    for (;;)
    {
      localc = Sr();
      if (localc == null) {
        break label48;
      }
      f.a locala = this.eJT.Sm();
      if (locala == null) {
        break;
      }
      a(localc, locala);
    }
    b(localc);
    AppMethodBeat.o(123322);
    return;
    label48:
    AppMethodBeat.o(123322);
  }
  
  private void b(c arg1)
  {
    AppMethodBeat.i(123321);
    if (a(???)) {
      synchronized (this.eJR)
      {
        if (this.eJQ) {
          j.i("MMSkeleton.Parallels", "Parallels notify done", new Object[0]);
        }
        this.eJQ = false;
        this.eJP.Ss();
        AppMethodBeat.o(123321);
        return;
      }
    }
    AppMethodBeat.o(123321);
  }
  
  public final void Sp()
  {
    AppMethodBeat.i(123316);
    this.eJP.Sp();
    AppMethodBeat.o(123316);
  }
  
  public final List<c> Sq()
  {
    try
    {
      AppMethodBeat.i(123318);
      LinkedList localLinkedList = new LinkedList(this.eJN);
      AppMethodBeat.o(123318);
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
    AppMethodBeat.i(123315);
    if (a(parama, parama1, paramc))
    {
      paramc.prepare();
      start(paramString);
      Sp();
    }
    AppMethodBeat.o(123315);
  }
  
  public final boolean a(a parama, a<Void, f.a> parama1, c<T> paramc)
  {
    AppMethodBeat.i(123314);
    synchronized (this.eJR)
    {
      if (this.eJQ)
      {
        ab.w("MMSkeleton.Parallels", "Arrange parallels task failed. It's busy on working.");
        Assert.assertTrue(false);
        AppMethodBeat.o(123314);
        return false;
      }
      this.eJP = parama;
      this.eJS = parama1;
      this.eJT = paramc;
      AppMethodBeat.o(123314);
      return true;
    }
  }
  
  public final void init(int paramInt)
  {
    try
    {
      AppMethodBeat.i(123312);
      int i = 0;
      while (i < paramInt)
      {
        Queue localQueue = this.eJN;
        HandlerThread localHandlerThread = new HandlerThread("parallels-".concat(String.valueOf(i)), -8);
        localHandlerThread.start();
        c localc = new c();
        localc.bYd = localHandlerThread;
        localQueue.add(localc);
        i += 1;
      }
      this.eJO = paramInt;
      AppMethodBeat.o(123312);
      return;
    }
    finally {}
  }
  
  public final void prepare()
  {
    try
    {
      AppMethodBeat.i(123313);
      int i = 0;
      while (i < this.eJO)
      {
        c localc = (c)((LinkedList)this.eJN).get(i);
        Handler localHandler = new Handler(localc.bYd.getLooper());
        h localh = new h(localHandler, localc.bYd.getName());
        localc.handler = localHandler;
        localc.eJY = localh;
        i += 1;
      }
      AppMethodBeat.o(123313);
      return;
    }
    finally {}
  }
  
  public final void start(String arg1)
  {
    AppMethodBeat.i(123317);
    j.i("MMSkeleton.Parallels", "Start working. For %s", new Object[] { ??? });
    synchronized (this.eJR)
    {
      this.eJQ = true;
      active();
      AppMethodBeat.o(123317);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Sp();
    
    public abstract void Ss();
  }
  
  public static final class b
    implements e.a
  {
    private final byte[] eFQ;
    
    public b()
    {
      AppMethodBeat.i(123307);
      this.eFQ = new byte[] { 0 };
      AppMethodBeat.o(123307);
    }
    
    public final void Sp()
    {
      AppMethodBeat.i(123308);
      try
      {
        synchronized (this.eFQ)
        {
          if (this.eFQ[0] == 0)
          {
            j.i("MMSkeleton.Parallels", "Waiting for lock(%s)", new Object[] { this.eFQ });
            this.eFQ.wait();
            AppMethodBeat.o(123308);
            return;
          }
          j.i("MMSkeleton.Parallels", "Not need wait for lock(%s)", new Object[] { this.eFQ });
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        ab.printErrStackTrace("MMSkeleton.Parallels", localInterruptedException, "", new Object[0]);
        AppMethodBeat.o(123308);
      }
    }
    
    public final void Ss()
    {
      AppMethodBeat.i(123309);
      synchronized (this.eFQ)
      {
        this.eFQ[0] = 1;
        this.eFQ.notify();
        j.i("MMSkeleton.Parallels", "Lock(%s) notified", new Object[] { this.eFQ });
        AppMethodBeat.o(123309);
        return;
      }
    }
  }
  
  public static final class c
  {
    public HandlerThread bYd;
    h eJY;
    Handler handler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.e
 * JD-Core Version:    0.7.0.1
 */