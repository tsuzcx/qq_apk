package com.tencent.mm.blink;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
{
  private static b dgT = new b();
  private final Queue<a> dgU = new LinkedList();
  private boolean dgV = false;
  private volatile boolean dgW = false;
  private boolean dgX = true;
  private volatile com.tencent.mm.vending.g.c dgY = f.cLb();
  private AtomicBoolean dgZ = new AtomicBoolean(false);
  private ai dha = new ai("pending-stage");
  
  public static b vG()
  {
    return dgT;
  }
  
  /* Error */
  private boolean vL()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/tencent/mm/blink/b:dgV	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: getfield 49	com/tencent/mm/blink/b:dgX	Z
    //   13: ifeq +18 -> 31
    //   16: aload_0
    //   17: getfield 47	com/tencent/mm/blink/b:dgW	Z
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
  
  private void vM()
  {
    a(b.dhf);
    vN();
  }
  
  /* Error */
  private void vN()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 93	com/tencent/mm/blink/b:vL	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 43	com/tencent/mm/blink/b:dgU	Ljava/util/Queue;
    //   18: invokeinterface 99 1 0
    //   23: checkcast 10	com/tencent/mm/blink/b$a
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull -17 -> 11
    //   31: ldc 101
    //   33: ldc 103
    //   35: iconst_2
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_2
    //   42: invokestatic 106	com/tencent/mm/blink/b$a:a	(Lcom/tencent/mm/blink/b$a;)Ljava/lang/Runnable;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_2
    //   49: invokestatic 109	com/tencent/mm/blink/b$a:b	(Lcom/tencent/mm/blink/b$a;)Lcom/tencent/mm/vending/h/d;
    //   52: invokevirtual 115	com/tencent/mm/vending/h/d:getType	()Ljava/lang/String;
    //   55: aastore
    //   56: invokestatic 121	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield 57	com/tencent/mm/blink/b:dgY	Lcom/tencent/mm/vending/g/c;
    //   63: aload_2
    //   64: invokeinterface 127 2 0
    //   69: pop
    //   70: goto -56 -> 14
    //   73: astore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	b
    //   6	2	1	bool	boolean
    //   26	38	2	locala	a
    //   73	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	73	finally
    //   14	27	73	finally
    //   31	70	73	finally
  }
  
  public final void a(final b paramb)
  {
    if (this.dgZ.compareAndSet(false, true))
    {
      if (paramb == b.dhd)
      {
        y.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", new Object[] { paramb });
        com.tencent.mm.kernel.a.c.DY().DZ();
        try
        {
          this.dgW = true;
          vN();
          return;
        }
        finally {}
      }
      h localh = new h(new com.tencent.mm.ck.d(this.dha.crf()), "pending-stage");
      try
      {
        this.dgY.a(localh).c(new a()
        {
          private Object vO()
          {
            y.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", new Object[] { paramb });
            com.tencent.mm.kernel.a.c.DY().DZ();
            try
            {
              b.a(b.this);
              b.b(b.this);
              return null;
            }
            finally {}
          }
        });
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  public final void k(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 170	com/tencent/mm/vending/h/d:cLe	()Lcom/tencent/mm/vending/h/d;
    //   5: astore_2
    //   6: aload_2
    //   7: instanceof 172
    //   10: ifne +11 -> 21
    //   13: aload_2
    //   14: invokevirtual 115	com/tencent/mm/vending/h/d:getType	()Ljava/lang/String;
    //   17: aload_2
    //   18: invokestatic 177	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   21: aload_0
    //   22: invokespecial 93	com/tencent/mm/blink/b:vL	()Z
    //   25: ifne +73 -> 98
    //   28: ldc 101
    //   30: ldc 179
    //   32: iconst_4
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 45	com/tencent/mm/blink/b:dgV	Z
    //   42: invokestatic 185	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_0
    //   49: getfield 49	com/tencent/mm/blink/b:dgX	Z
    //   52: invokestatic 185	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   55: aastore
    //   56: dup
    //   57: iconst_2
    //   58: aload_0
    //   59: getfield 47	com/tencent/mm/blink/b:dgW	Z
    //   62: invokestatic 185	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   65: aastore
    //   66: dup
    //   67: iconst_3
    //   68: aload_0
    //   69: getfield 43	com/tencent/mm/blink/b:dgU	Ljava/util/Queue;
    //   72: aastore
    //   73: invokestatic 121	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: aload_0
    //   77: getfield 43	com/tencent/mm/blink/b:dgU	Ljava/util/Queue;
    //   80: new 10	com/tencent/mm/blink/b$a
    //   83: dup
    //   84: aload_1
    //   85: aload_2
    //   86: invokespecial 188	com/tencent/mm/blink/b$a:<init>	(Ljava/lang/Runnable;Lcom/tencent/mm/vending/h/d;)V
    //   89: invokeinterface 192 2 0
    //   94: pop
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc 101
    //   100: ldc 194
    //   102: iconst_1
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_1
    //   109: aastore
    //   110: invokestatic 121	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aload_0
    //   114: getfield 57	com/tencent/mm/blink/b:dgY	Lcom/tencent/mm/vending/g/c;
    //   117: new 10	com/tencent/mm/blink/b$a
    //   120: dup
    //   121: aload_1
    //   122: aload_2
    //   123: invokespecial 188	com/tencent/mm/blink/b$a:<init>	(Ljava/lang/Runnable;Lcom/tencent/mm/vending/h/d;)V
    //   126: invokeinterface 127 2 0
    //   131: pop
    //   132: goto -37 -> 95
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	b
    //   0	140	1	paramRunnable	Runnable
    //   5	118	2	locald	com.tencent.mm.vending.h.d
    // Exception table:
    //   from	to	target	type
    //   2	21	135	finally
    //   21	95	135	finally
    //   98	132	135	finally
  }
  
  public final void vH()
  {
    try
    {
      this.dgV = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void vI()
  {
    try
    {
      this.dgX = true;
      if (this.dgV) {
        vM();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void vJ()
  {
    try
    {
      this.dgX = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void vK()
  {
    try
    {
      if (this.dgV)
      {
        this.dgV = false;
        vM();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static final class a
    implements e
  {
    private com.tencent.mm.vending.h.d bww;
    private Runnable mRunnable;
    
    public a(Runnable paramRunnable, com.tencent.mm.vending.h.d paramd)
    {
      this.mRunnable = paramRunnable;
      this.bww = paramd;
    }
    
    public final Object call(Object paramObject)
    {
      y.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", new Object[] { this.mRunnable, this.bww.getType() });
      this.mRunnable.run();
      return null;
    }
    
    public final String vP()
    {
      if ((this.bww instanceof com.tencent.mm.vending.h.c))
      {
        if ((com.tencent.mm.vending.h.d.cLe() instanceof com.tencent.mm.vending.h.c)) {
          return com.tencent.mm.vending.h.d.wtY.c;
        }
        return com.tencent.mm.vending.h.d.cLe().getType();
      }
      return this.bww.getType();
    }
  }
  
  private static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.blink.b
 * JD-Core Version:    0.7.0.1
 */