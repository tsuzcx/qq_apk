package com.tencent.mm.blink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
{
  private static b gkG;
  private final Queue<a> gkH;
  private boolean gkI;
  private volatile boolean gkJ;
  private boolean gkK;
  private volatile com.tencent.mm.vending.g.c gkL;
  private AtomicBoolean gkM;
  private MMHandler gkN;
  
  static
  {
    AppMethodBeat.i(131832);
    gkG = new b();
    AppMethodBeat.o(131832);
  }
  
  public b()
  {
    AppMethodBeat.i(131823);
    this.gkH = new LinkedList();
    this.gkI = false;
    this.gkJ = false;
    this.gkK = true;
    this.gkL = g.hdG();
    this.gkM = new AtomicBoolean(false);
    this.gkN = new MMHandler("pending-stage");
    AppMethodBeat.o(131823);
  }
  
  public static b ake()
  {
    return gkG;
  }
  
  /* Error */
  private boolean akj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/mm/blink/b:gkI	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: getfield 60	com/tencent/mm/blink/b:gkK	Z
    //   13: ifeq +18 -> 31
    //   16: aload_0
    //   17: getfield 58	com/tencent/mm/blink/b:gkJ	Z
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
  
  private void akk()
  {
    AppMethodBeat.i(131827);
    a(b.gkS);
    akl();
    AppMethodBeat.o(131827);
  }
  
  private void akl()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(131828);
        if (!akj())
        {
          AppMethodBeat.o(131828);
          return;
        }
        a locala = (a)this.gkH.poll();
        if (locala != null)
        {
          Log.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", new Object[] { a.a(locala), a.b(locala).getType() });
          this.gkL.c(locala);
        }
        else
        {
          AppMethodBeat.o(131828);
        }
      }
      finally {}
    }
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(131829);
    if (this.gkM.compareAndSet(false, true))
    {
      if (paramb == b.gkQ)
      {
        Log.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", new Object[] { paramb });
        com.tencent.mm.kernel.a.c.aAu().aAx();
        try
        {
          this.gkJ = true;
          akl();
          return;
        }
        finally
        {
          AppMethodBeat.o(131829);
        }
      }
      h localh = new h(new com.tencent.mm.co.d(this.gkN), "pending-stage");
      try
      {
        this.gkL.b(localh).c(new a()
        {
          private Object akm()
          {
            AppMethodBeat.i(131815);
            Log.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", new Object[] { paramb });
            com.tencent.mm.kernel.a.c.aAu().aAx();
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
  
  public final void akf()
  {
    try
    {
      this.gkI = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void akg()
  {
    try
    {
      AppMethodBeat.i(131824);
      this.gkK = true;
      if (this.gkI) {
        akk();
      }
      AppMethodBeat.o(131824);
      return;
    }
    finally {}
  }
  
  public final void akh()
  {
    try
    {
      this.gkK = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void aki()
  {
    try
    {
      AppMethodBeat.i(131825);
      if (this.gkI)
      {
        this.gkI = false;
        akk();
      }
      AppMethodBeat.o(131825);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void arrange(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 186
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 190	com/tencent/mm/vending/h/d:current	()Lcom/tencent/mm/vending/h/d;
    //   10: astore_2
    //   11: aload_2
    //   12: instanceof 192
    //   15: ifne +11 -> 26
    //   18: aload_2
    //   19: invokevirtual 128	com/tencent/mm/vending/h/d:getType	()Ljava/lang/String;
    //   22: aload_2
    //   23: invokestatic 197	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   26: aload_0
    //   27: invokespecial 106	com/tencent/mm/blink/b:akj	()Z
    //   30: ifne +78 -> 108
    //   33: ldc 114
    //   35: ldc 199
    //   37: iconst_4
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: getfield 56	com/tencent/mm/blink/b:gkI	Z
    //   47: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_0
    //   54: getfield 60	com/tencent/mm/blink/b:gkK	Z
    //   57: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   60: aastore
    //   61: dup
    //   62: iconst_2
    //   63: aload_0
    //   64: getfield 58	com/tencent/mm/blink/b:gkJ	Z
    //   67: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: aastore
    //   71: dup
    //   72: iconst_3
    //   73: aload_0
    //   74: getfield 54	com/tencent/mm/blink/b:gkH	Ljava/util/Queue;
    //   77: aastore
    //   78: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_0
    //   82: getfield 54	com/tencent/mm/blink/b:gkH	Ljava/util/Queue;
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
    //   108: ldc 114
    //   110: ldc 214
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: aastore
    //   120: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_0
    //   124: getfield 68	com/tencent/mm/blink/b:gkL	Lcom/tencent/mm/vending/g/c;
    //   127: new 10	com/tencent/mm/blink/b$a
    //   130: dup
    //   131: aload_1
    //   132: aload_2
    //   133: invokespecial 208	com/tencent/mm/blink/b$a:<init>	(Ljava/lang/Runnable;Lcom/tencent/mm/vending/h/d;)V
    //   136: invokeinterface 139 2 0
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
    private Runnable mRunnable;
    private com.tencent.mm.vending.h.d mScheduler;
    
    public a(Runnable paramRunnable, com.tencent.mm.vending.h.d paramd)
    {
      this.mRunnable = paramRunnable;
      this.mScheduler = paramd;
    }
    
    public final String akn()
    {
      AppMethodBeat.i(131819);
      if ((this.mScheduler instanceof com.tencent.mm.vending.h.c))
      {
        if ((com.tencent.mm.vending.h.d.current() instanceof com.tencent.mm.vending.h.c))
        {
          str = com.tencent.mm.vending.h.d.UI.getType();
          AppMethodBeat.o(131819);
          return str;
        }
        str = com.tencent.mm.vending.h.d.current().getType();
        AppMethodBeat.o(131819);
        return str;
      }
      String str = this.mScheduler.getType();
      AppMethodBeat.o(131819);
      return str;
    }
    
    /* Error */
    public final Object call(Object paramObject)
    {
      // Byte code:
      //   0: ldc 59
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: ldc 61
      //   7: ldc 63
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
      //   23: getfield 22	com/tencent/mm/blink/b$a:mScheduler	Lcom/tencent/mm/vending/h/d;
      //   26: invokevirtual 56	com/tencent/mm/vending/h/d:getType	()Ljava/lang/String;
      //   29: aastore
      //   30: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   33: aload_0
      //   34: getfield 20	com/tencent/mm/blink/b$a:mRunnable	Ljava/lang/Runnable;
      //   37: ifnull +24 -> 61
      //   40: aload_0
      //   41: getfield 20	com/tencent/mm/blink/b$a:mRunnable	Ljava/lang/Runnable;
      //   44: invokeinterface 73 1 0
      //   49: aload_0
      //   50: aconst_null
      //   51: putfield 20	com/tencent/mm/blink/b$a:mRunnable	Ljava/lang/Runnable;
      //   54: ldc 59
      //   56: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   59: aconst_null
      //   60: areturn
      //   61: ldc 61
      //   63: ldc 75
      //   65: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   68: goto -19 -> 49
      //   71: astore_1
      //   72: aload_0
      //   73: aconst_null
      //   74: putfield 20	com/tencent/mm/blink/b$a:mRunnable	Ljava/lang/Runnable;
      //   77: ldc 59
      //   79: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      gkQ = new b("Now", 0);
      gkR = new b("Timeout", 1);
      gkS = new b("FirstScreen", 2);
      gkT = new b[] { gkQ, gkR, gkS };
      AppMethodBeat.o(131822);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.blink.b
 * JD-Core Version:    0.7.0.1
 */