package com.tencent.mm.plugin.appbrand.report.model;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Deque;
import java.util.LinkedList;

public final class c
  implements g, h
{
  private final String msu;
  private final SparseArray<h.a> msv;
  private final Deque<h.a> msw;
  private boolean msx;
  private String msy;
  private h.a msz;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188715);
    this.msv = new SparseArray();
    this.msw = new LinkedList();
    this.msx = true;
    this.msu = paramString1;
    try
    {
      this.msy = paramString2;
      return;
    }
    finally
    {
      AppMethodBeat.o(188715);
    }
  }
  
  private void a(h.a parama)
  {
    try
    {
      AppMethodBeat.i(48102);
      this.msw.offerFirst(parama);
      this.msv.put(parama.dsf, parama);
      AppMethodBeat.o(48102);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private void b(ae paramae1, ae paramae2)
  {
    try
    {
      AppMethodBeat.i(48096);
      boolean bool = Un(paramae2.lYf);
      this.msz = q(paramae2);
      this.msz.msG = new h.c(1, paramae1.lYf);
      int i = paramae1.hashCode();
      while ((!isEmpty()) && (bxw().dsf != i)) {
        bxv();
      }
      if (!bool) {
        break label98;
      }
    }
    finally {}
    a(new h.a(paramae1));
    label98:
    q(paramae1).msH = new h.b(paramae2.lYf);
    q(paramae1).msG = null;
    AppMethodBeat.o(48096);
  }
  
  private void bxu()
  {
    try
    {
      this.msz = null;
      this.msy = null;
      this.msx = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h.a bxv()
  {
    try
    {
      AppMethodBeat.i(48103);
      h.a locala = (h.a)this.msw.pollFirst();
      if (locala != null) {
        this.msv.remove(locala.dsf);
      }
      AppMethodBeat.o(48103);
      return locala;
    }
    finally {}
  }
  
  private boolean isEmpty()
  {
    try
    {
      AppMethodBeat.i(48105);
      boolean bool = this.msw.isEmpty();
      AppMethodBeat.o(48105);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private void p(ae paramae)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 141
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: getfield 80	com/tencent/mm/plugin/appbrand/page/aa:lYf	Ljava/lang/String;
    //   12: putfield 49	com/tencent/mm/plugin/appbrand/report/model/c:msy	Ljava/lang/String;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 45	com/tencent/mm/plugin/appbrand/report/model/c:msx	Z
    //   20: aload_0
    //   21: new 64	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 117	com/tencent/mm/plugin/appbrand/report/model/h$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/ae;)V
    //   29: invokespecial 119	com/tencent/mm/plugin/appbrand/report/model/c:a	(Lcom/tencent/mm/plugin/appbrand/report/model/h$a;)V
    //   32: aload_0
    //   33: invokevirtual 111	com/tencent/mm/plugin/appbrand/report/model/c:bxw	()Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   36: astore_2
    //   37: aload_0
    //   38: getfield 47	com/tencent/mm/plugin/appbrand/report/model/c:msu	Ljava/lang/String;
    //   41: invokestatic 146	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   44: ifeq +18 -> 62
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_2
    //   50: aload_1
    //   51: putfield 128	com/tencent/mm/plugin/appbrand/report/model/h$a:msH	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
    //   54: ldc 141
    //   56: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: new 121	com/tencent/mm/plugin/appbrand/report/model/h$b
    //   65: dup
    //   66: aload_0
    //   67: getfield 47	com/tencent/mm/plugin/appbrand/report/model/c:msu	Ljava/lang/String;
    //   70: invokespecial 124	com/tencent/mm/plugin/appbrand/report/model/h$b:<init>	(Ljava/lang/String;)V
    //   73: astore_1
    //   74: goto -25 -> 49
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	c
    //   0	82	1	paramae	ae
    //   36	14	2	locala	h.a
    // Exception table:
    //   from	to	target	type
    //   2	47	77	finally
    //   49	59	77	finally
    //   62	74	77	finally
  }
  
  private h.a q(ae paramae)
  {
    AppMethodBeat.i(48100);
    h.a locala = bxw();
    if (locala == null)
    {
      paramae = new h.a(paramae);
      AppMethodBeat.o(48100);
      return paramae;
    }
    if (locala.dsf == paramae.hashCode())
    {
      AppMethodBeat.o(48100);
      return locala;
    }
    ad.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
    AppMethodBeat.o(48100);
    return locala;
  }
  
  /* Error */
  public final boolean Un(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 161
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 49	com/tencent/mm/plugin/appbrand/report/model/c:msy	Ljava/lang/String;
    //   11: invokestatic 146	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   14: ifne +25 -> 39
    //   17: aload_0
    //   18: getfield 49	com/tencent/mm/plugin/appbrand/report/model/c:msy	Ljava/lang/String;
    //   21: aload_1
    //   22: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +14 -> 39
    //   28: iconst_1
    //   29: istore_2
    //   30: ldc 161
    //   32: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_2
    //   41: ldc 161
    //   43: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -11 -> 35
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	c
    //   0	54	1	paramString	String
    //   29	12	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	28	49	finally
    //   30	35	49	finally
    //   41	46	49	finally
  }
  
  /* Error */
  public final void a(ae paramae1, ae paramae2, com.tencent.mm.plugin.appbrand.page.bs parambs)
  {
    // Byte code:
    //   0: ldc 168
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 45	com/tencent/mm/plugin/appbrand/report/model/c:msx	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 170	com/tencent/mm/plugin/appbrand/report/model/c:p	(Lcom/tencent/mm/plugin/appbrand/page/ae;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: ldc 168
    //   23: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: aload_3
    //   28: getstatic 176	com/tencent/mm/plugin/appbrand/page/bs:mfN	Lcom/tencent/mm/plugin/appbrand/page/bs;
    //   31: if_acmpne +17 -> 48
    //   34: aload_0
    //   35: aload_1
    //   36: aload_2
    //   37: invokespecial 178	com/tencent/mm/plugin/appbrand/report/model/c:b	(Lcom/tencent/mm/plugin/appbrand/page/ae;Lcom/tencent/mm/plugin/appbrand/page/ae;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: ldc 168
    //   44: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: aload_0
    //   49: getfield 90	com/tencent/mm/plugin/appbrand/report/model/c:msz	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokespecial 180	com/tencent/mm/plugin/appbrand/report/model/c:bxu	()V
    //   59: aload_2
    //   60: ifnull +29 -> 89
    //   63: aload_0
    //   64: aload_2
    //   65: invokespecial 88	com/tencent/mm/plugin/appbrand/report/model/c:q	(Lcom/tencent/mm/plugin/appbrand/page/ae;)Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   68: astore_3
    //   69: aload_3
    //   70: ifnull +19 -> 89
    //   73: aload_3
    //   74: new 92	com/tencent/mm/plugin/appbrand/report/model/h$c
    //   77: dup
    //   78: iconst_2
    //   79: aload_1
    //   80: getfield 80	com/tencent/mm/plugin/appbrand/page/aa:lYf	Ljava/lang/String;
    //   83: invokespecial 95	com/tencent/mm/plugin/appbrand/report/model/h$c:<init>	(ILjava/lang/String;)V
    //   86: putfield 99	com/tencent/mm/plugin/appbrand/report/model/h$a:msG	Lcom/tencent/mm/plugin/appbrand/report/model/h$c;
    //   89: new 64	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 117	com/tencent/mm/plugin/appbrand/report/model/h$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/ae;)V
    //   97: astore_3
    //   98: aload_2
    //   99: ifnonnull +23 -> 122
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_3
    //   105: aload_1
    //   106: putfield 128	com/tencent/mm/plugin/appbrand/report/model/h$a:msH	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
    //   109: aload_0
    //   110: aload_3
    //   111: invokespecial 119	com/tencent/mm/plugin/appbrand/report/model/c:a	(Lcom/tencent/mm/plugin/appbrand/report/model/h$a;)V
    //   114: aload_0
    //   115: monitorexit
    //   116: ldc 168
    //   118: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: new 121	com/tencent/mm/plugin/appbrand/report/model/h$b
    //   125: dup
    //   126: aload_2
    //   127: getfield 80	com/tencent/mm/plugin/appbrand/page/aa:lYf	Ljava/lang/String;
    //   130: invokespecial 124	com/tencent/mm/plugin/appbrand/report/model/h$b:<init>	(Ljava/lang/String;)V
    //   133: astore_1
    //   134: goto -30 -> 104
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: ldc 168
    //   142: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_1
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	c
    //   0	147	1	paramae1	ae
    //   0	147	2	paramae2	ae
    //   0	147	3	parambs	com.tencent.mm.plugin.appbrand.page.bs
    // Exception table:
    //   from	to	target	type
    //   7	21	137	finally
    //   27	42	137	finally
    //   48	59	137	finally
    //   63	69	137	finally
    //   73	89	137	finally
    //   89	98	137	finally
    //   104	116	137	finally
    //   122	134	137	finally
    //   138	140	137	finally
  }
  
  public final h.a bxw()
  {
    try
    {
      AppMethodBeat.i(48104);
      h.a locala = (h.a)this.msw.peekFirst();
      AppMethodBeat.o(48104);
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void d(ae paramae)
  {
    AppMethodBeat.i(48099);
    try
    {
      h.a locala = q(paramae);
      if (locala == null) {
        return;
      }
      paramae = d.s(paramae);
      locala.msG = new h.c(((Integer)paramae.first).intValue(), (String)paramae.second);
      return;
    }
    finally
    {
      AppMethodBeat.o(48099);
    }
  }
  
  /* Error */
  public final void e(ae paramae)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 208
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 45	com/tencent/mm/plugin/appbrand/report/model/c:msx	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 170	com/tencent/mm/plugin/appbrand/report/model/c:p	(Lcom/tencent/mm/plugin/appbrand/page/ae;)V
    //   19: ldc 208
    //   21: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: invokespecial 180	com/tencent/mm/plugin/appbrand/report/model/c:bxu	()V
    //   31: ldc 208
    //   33: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: goto -12 -> 24
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	c
    //   0	44	1	paramae	ae
    // Exception table:
    //   from	to	target	type
    //   2	24	39	finally
    //   27	36	39	finally
  }
  
  /* Error */
  public final h.a r(ae paramae)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 210
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 38	com/tencent/mm/plugin/appbrand/report/model/c:msv	Landroid/util/SparseArray;
    //   11: aload_1
    //   12: invokevirtual 103	java/lang/Object:hashCode	()I
    //   15: invokevirtual 214	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   18: checkcast 64	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   21: astore_2
    //   22: aload_2
    //   23: ifnonnull +38 -> 61
    //   26: aload_0
    //   27: getfield 90	com/tencent/mm/plugin/appbrand/report/model/c:msz	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   30: ifnull +31 -> 61
    //   33: aload_0
    //   34: getfield 90	com/tencent/mm/plugin/appbrand/report/model/c:msz	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   37: getfield 68	com/tencent/mm/plugin/appbrand/report/model/h$a:dsf	I
    //   40: aload_1
    //   41: invokevirtual 103	java/lang/Object:hashCode	()I
    //   44: if_icmpne +17 -> 61
    //   47: aload_0
    //   48: getfield 90	com/tencent/mm/plugin/appbrand/report/model/c:msz	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   51: astore_1
    //   52: ldc 210
    //   54: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: ldc 210
    //   63: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_2
    //   67: astore_1
    //   68: goto -11 -> 57
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	c
    //   0	76	1	paramae	ae
    //   21	46	2	locala	h.a
    // Exception table:
    //   from	to	target	type
    //   2	22	71	finally
    //   26	57	71	finally
    //   61	66	71	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.c
 * JD-Core Version:    0.7.0.1
 */