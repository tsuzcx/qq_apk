package com.tencent.mm.blink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
{
  private static b fhQ;
  private final Queue<a> fhR;
  private boolean fhS;
  private volatile boolean fhT;
  private boolean fhU;
  private volatile com.tencent.mm.vending.g.c fhV;
  private AtomicBoolean fhW;
  private ap fhX;
  
  static
  {
    AppMethodBeat.i(131832);
    fhQ = new b();
    AppMethodBeat.o(131832);
  }
  
  public b()
  {
    AppMethodBeat.i(131823);
    this.fhR = new LinkedList();
    this.fhS = false;
    this.fhT = false;
    this.fhU = true;
    this.fhV = g.fhq();
    this.fhW = new AtomicBoolean(false);
    this.fhX = new ap("pending-stage");
    AppMethodBeat.o(131823);
  }
  
  public static b SX()
  {
    return fhQ;
  }
  
  /* Error */
  private boolean Tc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/mm/blink/b:fhS	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: getfield 60	com/tencent/mm/blink/b:fhU	Z
    //   13: ifeq +18 -> 31
    //   16: aload_0
    //   17: getfield 58	com/tencent/mm/blink/b:fhT	Z
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
  
  private void Td()
  {
    AppMethodBeat.i(131827);
    a(b.fic);
    Te();
    AppMethodBeat.o(131827);
  }
  
  private void Te()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(131828);
        if (!Tc())
        {
          AppMethodBeat.o(131828);
          return;
        }
        a locala = (a)this.fhR.poll();
        if (locala != null)
        {
          ad.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", new Object[] { a.a(locala), a.b(locala).getType() });
          this.fhV.c(locala);
        }
        else
        {
          AppMethodBeat.o(131828);
        }
      }
      finally {}
    }
  }
  
  public final void SY()
  {
    try
    {
      this.fhS = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void SZ()
  {
    try
    {
      AppMethodBeat.i(131824);
      this.fhU = true;
      if (this.fhS) {
        Td();
      }
      AppMethodBeat.o(131824);
      return;
    }
    finally {}
  }
  
  public final void Ta()
  {
    try
    {
      this.fhU = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Tb()
  {
    try
    {
      AppMethodBeat.i(131825);
      if (this.fhS)
      {
        this.fhS = false;
        Td();
      }
      AppMethodBeat.o(131825);
      return;
    }
    finally {}
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(131829);
    if (this.fhW.compareAndSet(false, true))
    {
      if (paramb == b.fia)
      {
        ad.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", new Object[] { paramb });
        com.tencent.mm.kernel.a.c.afO().afR();
        try
        {
          this.fhT = true;
          Te();
          return;
        }
        finally
        {
          AppMethodBeat.o(131829);
        }
      }
      h localh = new h(new com.tencent.mm.co.d(this.fhX), "pending-stage");
      try
      {
        this.fhV.b(localh).c(new a()
        {
          private Object Tf()
          {
            AppMethodBeat.i(131815);
            ad.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", new Object[] { paramb });
            com.tencent.mm.kernel.a.c.afO().afR();
            try
            {
              b.a(b.this);
              b.b(b.this);
              return null;
            }
            finally
            {
              AppMethodBeat.o(131815);
            }
          }
        });
        return;
      }
      finally
      {
        AppMethodBeat.o(131829);
      }
    }
    AppMethodBeat.o(131829);
  }
  
  /* Error */
  public final void v(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 186
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 190	com/tencent/mm/vending/h/d:fhs	()Lcom/tencent/mm/vending/h/d;
    //   10: astore_2
    //   11: aload_2
    //   12: instanceof 192
    //   15: ifne +11 -> 26
    //   18: aload_2
    //   19: invokevirtual 125	com/tencent/mm/vending/h/d:getType	()Ljava/lang/String;
    //   22: aload_2
    //   23: invokestatic 197	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   26: aload_0
    //   27: invokespecial 103	com/tencent/mm/blink/b:Tc	()Z
    //   30: ifne +78 -> 108
    //   33: ldc 111
    //   35: ldc 199
    //   37: iconst_4
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: getfield 56	com/tencent/mm/blink/b:fhS	Z
    //   47: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_0
    //   54: getfield 60	com/tencent/mm/blink/b:fhU	Z
    //   57: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   60: aastore
    //   61: dup
    //   62: iconst_2
    //   63: aload_0
    //   64: getfield 58	com/tencent/mm/blink/b:fhT	Z
    //   67: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: aastore
    //   71: dup
    //   72: iconst_3
    //   73: aload_0
    //   74: getfield 54	com/tencent/mm/blink/b:fhR	Ljava/util/Queue;
    //   77: aastore
    //   78: invokestatic 130	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_0
    //   82: getfield 54	com/tencent/mm/blink/b:fhR	Ljava/util/Queue;
    //   85: new 10	com/tencent/mm/blink/b$a
    //   88: dup
    //   89: aload_1
    //   90: aload_2
    //   91: invokespecial 208	com/tencent/mm/blink/b$a:<init>	(Ljava/lang/Runnable;Lcom/tencent/mm/vending/h/d;)V
    //   94: invokeinterface 212 2 0
    //   99: pop
    //   100: ldc 186
    //   102: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: ldc 111
    //   110: ldc 214
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: aastore
    //   120: invokestatic 130	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_0
    //   124: getfield 68	com/tencent/mm/blink/b:fhV	Lcom/tencent/mm/vending/g/c;
    //   127: new 10	com/tencent/mm/blink/b$a
    //   130: dup
    //   131: aload_1
    //   132: aload_2
    //   133: invokespecial 208	com/tencent/mm/blink/b$a:<init>	(Ljava/lang/Runnable;Lcom/tencent/mm/vending/h/d;)V
    //   136: invokeinterface 136 2 0
    //   141: pop
    //   142: ldc 186
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
    private com.tencent.mm.vending.h.d cLA;
    private Runnable mRunnable;
    
    public a(Runnable paramRunnable, com.tencent.mm.vending.h.d paramd)
    {
      this.mRunnable = paramRunnable;
      this.cLA = paramd;
    }
    
    public final String Tg()
    {
      AppMethodBeat.i(131819);
      if ((this.cLA instanceof com.tencent.mm.vending.h.c))
      {
        if ((com.tencent.mm.vending.h.d.fhs() instanceof com.tencent.mm.vending.h.c))
        {
          str = com.tencent.mm.vending.h.d.HQL.mType;
          AppMethodBeat.o(131819);
          return str;
        }
        str = com.tencent.mm.vending.h.d.fhs().getType();
        AppMethodBeat.o(131819);
        return str;
      }
      String str = this.cLA.getType();
      AppMethodBeat.o(131819);
      return str;
    }
    
    /* Error */
    public final Object call(Object paramObject)
    {
      // Byte code:
      //   0: ldc 62
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: ldc 64
      //   7: ldc 66
      //   9: iconst_2
      //   10: anewarray 4	java/lang/Object
      //   13: dup
      //   14: iconst_0
      //   15: aload_0
      //   16: getfield 20	com/tencent/mm/blink/b$a:mRunnable	Ljava/lang/Runnable;
      //   19: aastore
      //   20: dup
      //   21: iconst_1
      //   22: aload_0
      //   23: getfield 22	com/tencent/mm/blink/b$a:cLA	Lcom/tencent/mm/vending/h/d;
      //   26: invokevirtual 59	com/tencent/mm/vending/h/d:getType	()Ljava/lang/String;
      //   29: aastore
      //   30: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   33: aload_0
      //   34: getfield 20	com/tencent/mm/blink/b$a:mRunnable	Ljava/lang/Runnable;
      //   37: ifnull +24 -> 61
      //   40: aload_0
      //   41: getfield 20	com/tencent/mm/blink/b$a:mRunnable	Ljava/lang/Runnable;
      //   44: invokeinterface 76 1 0
      //   49: aload_0
      //   50: aconst_null
      //   51: putfield 20	com/tencent/mm/blink/b$a:mRunnable	Ljava/lang/Runnable;
      //   54: ldc 62
      //   56: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   59: aconst_null
      //   60: areturn
      //   61: ldc 64
      //   63: ldc 78
      //   65: invokestatic 82	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   68: goto -19 -> 49
      //   71: astore_1
      //   72: aload_0
      //   73: aconst_null
      //   74: putfield 20	com/tencent/mm/blink/b$a:mRunnable	Ljava/lang/Runnable;
      //   77: ldc 62
      //   79: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   82: aload_1
      //   83: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	84	0	this	a
      //   0	84	1	paramObject	Object
      // Exception table:
      //   from	to	target	type
      //   33	49	71	finally
      //   61	68	71	finally
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(131822);
      fia = new b("Now", 0);
      fib = new b("Timeout", 1);
      fic = new b("FirstScreen", 2);
      fid = new b[] { fia, fib, fic };
      AppMethodBeat.o(131822);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.blink.b
 * JD-Core Version:    0.7.0.1
 */