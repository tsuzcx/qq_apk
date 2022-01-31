package com.tencent.mm.blink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
{
  private static b dYf;
  private final Queue<a> dYg;
  private boolean dYh;
  private volatile boolean dYi;
  private boolean dYj;
  private volatile com.tencent.mm.vending.g.c dYk;
  private AtomicBoolean dYl;
  private al dYm;
  
  static
  {
    AppMethodBeat.i(57719);
    dYf = new b();
    AppMethodBeat.o(57719);
  }
  
  public b()
  {
    AppMethodBeat.i(57710);
    this.dYg = new LinkedList();
    this.dYh = false;
    this.dYi = false;
    this.dYj = true;
    this.dYk = f.dQr();
    this.dYl = new AtomicBoolean(false);
    this.dYm = new al("pending-stage");
    AppMethodBeat.o(57710);
  }
  
  public static b HP()
  {
    return dYf;
  }
  
  /* Error */
  private boolean HU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/mm/blink/b:dYh	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: getfield 60	com/tencent/mm/blink/b:dYj	Z
    //   13: ifeq +18 -> 31
    //   16: aload_0
    //   17: getfield 58	com/tencent/mm/blink/b:dYi	Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +9 -> 31
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_1
    //   33: goto -6 -> 27
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	b
    //   20	13	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	36	finally
    //   16	21	36	finally
  }
  
  private void HV()
  {
    AppMethodBeat.i(57714);
    a(b.dYr);
    HW();
    AppMethodBeat.o(57714);
  }
  
  private void HW()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(57715);
        if (!HU())
        {
          AppMethodBeat.o(57715);
          return;
        }
        a locala = (a)this.dYg.poll();
        if (locala != null)
        {
          ab.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", new Object[] { a.a(locala), a.b(locala).getType() });
          this.dYk.c(locala);
        }
        else
        {
          AppMethodBeat.o(57715);
        }
      }
      finally {}
    }
  }
  
  public final void HQ()
  {
    try
    {
      this.dYh = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void HR()
  {
    try
    {
      AppMethodBeat.i(57711);
      this.dYj = true;
      if (this.dYh) {
        HV();
      }
      AppMethodBeat.o(57711);
      return;
    }
    finally {}
  }
  
  public final void HS()
  {
    try
    {
      this.dYj = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void HT()
  {
    try
    {
      AppMethodBeat.i(57712);
      if (this.dYh)
      {
        this.dYh = false;
        HV();
      }
      AppMethodBeat.o(57712);
      return;
    }
    finally {}
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(57716);
    if (this.dYl.compareAndSet(false, true))
    {
      if (paramb == b.dYp)
      {
        ab.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", new Object[] { paramb });
        com.tencent.mm.kernel.a.c.RX().Sa();
        try
        {
          this.dYi = true;
          HW();
          return;
        }
        finally
        {
          AppMethodBeat.o(57716);
        }
      }
      h localh = new h(new com.tencent.mm.cm.d(this.dYm.caB()), "pending-stage");
      try
      {
        this.dYk.b(localh).c(new a()
        {
          private Object HX()
          {
            AppMethodBeat.i(57702);
            ab.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", new Object[] { paramb });
            com.tencent.mm.kernel.a.c.RX().Sa();
            try
            {
              b.a(b.this);
              b.b(b.this);
              return null;
            }
            finally
            {
              AppMethodBeat.o(57702);
            }
          }
        });
        return;
      }
      finally
      {
        AppMethodBeat.o(57716);
      }
    }
    AppMethodBeat.o(57716);
  }
  
  /* Error */
  public final void o(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 189
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 193	com/tencent/mm/vending/h/d:dQu	()Lcom/tencent/mm/vending/h/d;
    //   10: astore_2
    //   11: aload_2
    //   12: instanceof 195
    //   15: ifne +11 -> 26
    //   18: aload_2
    //   19: invokevirtual 125	com/tencent/mm/vending/h/d:getType	()Ljava/lang/String;
    //   22: aload_2
    //   23: invokestatic 200	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   26: aload_0
    //   27: invokespecial 103	com/tencent/mm/blink/b:HU	()Z
    //   30: ifne +78 -> 108
    //   33: ldc 111
    //   35: ldc 202
    //   37: iconst_4
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: getfield 56	com/tencent/mm/blink/b:dYh	Z
    //   47: invokestatic 208	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_0
    //   54: getfield 60	com/tencent/mm/blink/b:dYj	Z
    //   57: invokestatic 208	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   60: aastore
    //   61: dup
    //   62: iconst_2
    //   63: aload_0
    //   64: getfield 58	com/tencent/mm/blink/b:dYi	Z
    //   67: invokestatic 208	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: aastore
    //   71: dup
    //   72: iconst_3
    //   73: aload_0
    //   74: getfield 54	com/tencent/mm/blink/b:dYg	Ljava/util/Queue;
    //   77: aastore
    //   78: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_0
    //   82: getfield 54	com/tencent/mm/blink/b:dYg	Ljava/util/Queue;
    //   85: new 10	com/tencent/mm/blink/b$a
    //   88: dup
    //   89: aload_1
    //   90: aload_2
    //   91: invokespecial 211	com/tencent/mm/blink/b$a:<init>	(Ljava/lang/Runnable;Lcom/tencent/mm/vending/h/d;)V
    //   94: invokeinterface 215 2 0
    //   99: pop
    //   100: ldc 189
    //   102: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: ldc 111
    //   110: ldc 217
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: aastore
    //   120: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_0
    //   124: getfield 68	com/tencent/mm/blink/b:dYk	Lcom/tencent/mm/vending/g/c;
    //   127: new 10	com/tencent/mm/blink/b$a
    //   130: dup
    //   131: aload_1
    //   132: aload_2
    //   133: invokespecial 211	com/tencent/mm/blink/b$a:<init>	(Ljava/lang/Runnable;Lcom/tencent/mm/vending/h/d;)V
    //   136: invokeinterface 136 2 0
    //   141: pop
    //   142: ldc 189
    //   144: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: goto -42 -> 105
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	b
    //   0	155	1	paramRunnable	Runnable
    //   10	123	2	locald	com.tencent.mm.vending.h.d
    // Exception table:
    //   from	to	target	type
    //   2	26	150	finally
    //   26	105	150	finally
    //   108	147	150	finally
  }
  
  static final class a
    implements e
  {
    private com.tencent.mm.vending.h.d bYe;
    private Runnable mRunnable;
    
    public a(Runnable paramRunnable, com.tencent.mm.vending.h.d paramd)
    {
      this.mRunnable = paramRunnable;
      this.bYe = paramd;
    }
    
    public final String HY()
    {
      AppMethodBeat.i(57706);
      if ((this.bYe instanceof com.tencent.mm.vending.h.c))
      {
        if ((com.tencent.mm.vending.h.d.dQu() instanceof com.tencent.mm.vending.h.c))
        {
          str = com.tencent.mm.vending.h.d.AOW.c;
          AppMethodBeat.o(57706);
          return str;
        }
        str = com.tencent.mm.vending.h.d.dQu().getType();
        AppMethodBeat.o(57706);
        return str;
      }
      String str = this.bYe.getType();
      AppMethodBeat.o(57706);
      return str;
    }
    
    public final Object call(Object paramObject)
    {
      AppMethodBeat.i(57705);
      ab.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", new Object[] { this.mRunnable, this.bYe.getType() });
      this.mRunnable.run();
      AppMethodBeat.o(57705);
      return null;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(57709);
      dYp = new b("Now", 0);
      dYq = new b("Timeout", 1);
      dYr = new b("FirstScreen", 2);
      dYs = new b[] { dYp, dYq, dYr };
      AppMethodBeat.o(57709);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.blink.b
 * JD-Core Version:    0.7.0.1
 */