package com.tencent.mm.plugin.appbrand.report.model;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Deque;
import java.util.LinkedList;

public final class c
  implements g, h
{
  private final String iGF;
  private final SparseArray<h.a> iGG;
  private final Deque<h.a> iGH;
  private boolean iGI;
  private String iGJ;
  private h.a iGK;
  
  public c(String paramString)
  {
    AppMethodBeat.i(132592);
    this.iGG = new SparseArray();
    this.iGH = new LinkedList();
    this.iGI = true;
    this.iGF = paramString;
    AppMethodBeat.o(132592);
  }
  
  private void a(h.a parama)
  {
    try
    {
      AppMethodBeat.i(132599);
      this.iGH.offerFirst(parama);
      this.iGG.put(parama.iGR, parama);
      AppMethodBeat.o(132599);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private void aLh()
  {
    try
    {
      this.iGK = null;
      this.iGJ = null;
      this.iGI = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h.a aLi()
  {
    try
    {
      AppMethodBeat.i(132600);
      h.a locala = (h.a)this.iGH.pollFirst();
      if (locala != null) {
        this.iGG.remove(locala.iGR);
      }
      AppMethodBeat.o(132600);
      return locala;
    }
    finally {}
  }
  
  private void b(z paramz1, z paramz2)
  {
    try
    {
      AppMethodBeat.i(132593);
      boolean bool = EH(paramz2.iuB);
      this.iGK = g(paramz2);
      this.iGK.iGS = new h.c(1, paramz1.iuB);
      int i = paramz1.hashCode();
      while ((!isEmpty()) && (aLj().iGR != i)) {
        aLi();
      }
      if (!bool) {
        break label98;
      }
    }
    finally {}
    a(new h.a(paramz1));
    label98:
    g(paramz1).iGT = new h.b(paramz2.iuB);
    g(paramz1).iGS = null;
    AppMethodBeat.o(132593);
  }
  
  /* Error */
  private void f(z paramz)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 138
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: getfield 93	com/tencent/mm/plugin/appbrand/page/v:iuB	Ljava/lang/String;
    //   12: putfield 75	com/tencent/mm/plugin/appbrand/report/model/c:iGJ	Ljava/lang/String;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 45	com/tencent/mm/plugin/appbrand/report/model/c:iGI	Z
    //   20: aload_0
    //   21: new 62	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 126	com/tencent/mm/plugin/appbrand/report/model/h$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/z;)V
    //   29: invokespecial 128	com/tencent/mm/plugin/appbrand/report/model/c:a	(Lcom/tencent/mm/plugin/appbrand/report/model/h$a;)V
    //   32: aload_0
    //   33: invokevirtual 121	com/tencent/mm/plugin/appbrand/report/model/c:aLj	()Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   36: astore_2
    //   37: aload_0
    //   38: getfield 47	com/tencent/mm/plugin/appbrand/report/model/c:iGF	Ljava/lang/String;
    //   41: invokestatic 143	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   44: ifeq +18 -> 62
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_2
    //   50: aload_1
    //   51: putfield 136	com/tencent/mm/plugin/appbrand/report/model/h$a:iGT	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
    //   54: ldc 138
    //   56: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: new 130	com/tencent/mm/plugin/appbrand/report/model/h$b
    //   65: dup
    //   66: aload_0
    //   67: getfield 47	com/tencent/mm/plugin/appbrand/report/model/c:iGF	Ljava/lang/String;
    //   70: invokespecial 132	com/tencent/mm/plugin/appbrand/report/model/h$b:<init>	(Ljava/lang/String;)V
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
    //   0	82	1	paramz	z
    //   36	14	2	locala	h.a
    // Exception table:
    //   from	to	target	type
    //   2	47	77	finally
    //   49	59	77	finally
    //   62	74	77	finally
  }
  
  private h.a g(z paramz)
  {
    AppMethodBeat.i(132597);
    h.a locala = aLj();
    if (locala == null)
    {
      paramz = new h.a(paramz);
      AppMethodBeat.o(132597);
      return paramz;
    }
    if (locala.iGR == paramz.hashCode())
    {
      AppMethodBeat.o(132597);
      return locala;
    }
    ab.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
    AppMethodBeat.o(132597);
    return locala;
  }
  
  private boolean isEmpty()
  {
    try
    {
      AppMethodBeat.i(132602);
      boolean bool = this.iGH.isEmpty();
      AppMethodBeat.o(132602);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean EH(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 160
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 75	com/tencent/mm/plugin/appbrand/report/model/c:iGJ	Ljava/lang/String;
    //   11: invokestatic 143	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   14: ifne +25 -> 39
    //   17: aload_0
    //   18: getfield 75	com/tencent/mm/plugin/appbrand/report/model/c:iGJ	Ljava/lang/String;
    //   21: aload_1
    //   22: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +14 -> 39
    //   28: iconst_1
    //   29: istore_2
    //   30: ldc 160
    //   32: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_2
    //   41: ldc 160
    //   43: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public final void a(z paramz1, z paramz2, com.tencent.mm.plugin.appbrand.page.bf parambf)
  {
    // Byte code:
    //   0: ldc 167
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 45	com/tencent/mm/plugin/appbrand/report/model/c:iGI	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 169	com/tencent/mm/plugin/appbrand/report/model/c:f	(Lcom/tencent/mm/plugin/appbrand/page/z;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: ldc 167
    //   23: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: aload_3
    //   28: getstatic 175	com/tencent/mm/plugin/appbrand/page/bf:izS	Lcom/tencent/mm/plugin/appbrand/page/bf;
    //   31: if_acmpne +17 -> 48
    //   34: aload_0
    //   35: aload_1
    //   36: aload_2
    //   37: invokespecial 177	com/tencent/mm/plugin/appbrand/report/model/c:b	(Lcom/tencent/mm/plugin/appbrand/page/z;Lcom/tencent/mm/plugin/appbrand/page/z;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: ldc 167
    //   44: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: aload_0
    //   49: getfield 73	com/tencent/mm/plugin/appbrand/report/model/c:iGK	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokespecial 179	com/tencent/mm/plugin/appbrand/report/model/c:aLh	()V
    //   59: aload_2
    //   60: ifnull +29 -> 89
    //   63: aload_0
    //   64: aload_2
    //   65: invokespecial 101	com/tencent/mm/plugin/appbrand/report/model/c:g	(Lcom/tencent/mm/plugin/appbrand/page/z;)Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   68: astore_3
    //   69: aload_3
    //   70: ifnull +19 -> 89
    //   73: aload_3
    //   74: new 103	com/tencent/mm/plugin/appbrand/report/model/h$c
    //   77: dup
    //   78: iconst_2
    //   79: aload_1
    //   80: getfield 93	com/tencent/mm/plugin/appbrand/page/v:iuB	Ljava/lang/String;
    //   83: invokespecial 106	com/tencent/mm/plugin/appbrand/report/model/h$c:<init>	(ILjava/lang/String;)V
    //   86: putfield 110	com/tencent/mm/plugin/appbrand/report/model/h$a:iGS	Lcom/tencent/mm/plugin/appbrand/report/model/h$c;
    //   89: new 62	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 126	com/tencent/mm/plugin/appbrand/report/model/h$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/z;)V
    //   97: astore_3
    //   98: aload_2
    //   99: ifnonnull +23 -> 122
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_3
    //   105: aload_1
    //   106: putfield 136	com/tencent/mm/plugin/appbrand/report/model/h$a:iGT	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
    //   109: aload_0
    //   110: aload_3
    //   111: invokespecial 128	com/tencent/mm/plugin/appbrand/report/model/c:a	(Lcom/tencent/mm/plugin/appbrand/report/model/h$a;)V
    //   114: aload_0
    //   115: monitorexit
    //   116: ldc 167
    //   118: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: new 130	com/tencent/mm/plugin/appbrand/report/model/h$b
    //   125: dup
    //   126: aload_2
    //   127: getfield 93	com/tencent/mm/plugin/appbrand/page/v:iuB	Ljava/lang/String;
    //   130: invokespecial 132	com/tencent/mm/plugin/appbrand/report/model/h$b:<init>	(Ljava/lang/String;)V
    //   133: astore_1
    //   134: goto -30 -> 104
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: ldc 167
    //   142: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_1
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	c
    //   0	147	1	paramz1	z
    //   0	147	2	paramz2	z
    //   0	147	3	parambf	com.tencent.mm.plugin.appbrand.page.bf
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
  
  public final h.a aLj()
  {
    try
    {
      AppMethodBeat.i(132601);
      h.a locala = (h.a)this.iGH.peekFirst();
      AppMethodBeat.o(132601);
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(z paramz)
  {
    AppMethodBeat.i(132596);
    try
    {
      h.a locala = g(paramz);
      if (locala == null) {
        return;
      }
      paramz = d.i(paramz);
      locala.iGS = new h.c(((Integer)paramz.first).intValue(), (String)paramz.second);
      return;
    }
    finally
    {
      AppMethodBeat.o(132596);
    }
  }
  
  /* Error */
  public final void c(z paramz)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 205
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 45	com/tencent/mm/plugin/appbrand/report/model/c:iGI	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 169	com/tencent/mm/plugin/appbrand/report/model/c:f	(Lcom/tencent/mm/plugin/appbrand/page/z;)V
    //   19: ldc 205
    //   21: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: invokespecial 179	com/tencent/mm/plugin/appbrand/report/model/c:aLh	()V
    //   31: ldc 205
    //   33: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: goto -12 -> 24
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	c
    //   0	44	1	paramz	z
    // Exception table:
    //   from	to	target	type
    //   2	24	39	finally
    //   27	36	39	finally
  }
  
  /* Error */
  public final h.a h(z paramz)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 207
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 38	com/tencent/mm/plugin/appbrand/report/model/c:iGG	Landroid/util/SparseArray;
    //   11: aload_1
    //   12: invokevirtual 114	java/lang/Object:hashCode	()I
    //   15: invokevirtual 211	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   18: checkcast 62	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   21: astore_2
    //   22: aload_2
    //   23: ifnonnull +38 -> 61
    //   26: aload_0
    //   27: getfield 73	com/tencent/mm/plugin/appbrand/report/model/c:iGK	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   30: ifnull +31 -> 61
    //   33: aload_0
    //   34: getfield 73	com/tencent/mm/plugin/appbrand/report/model/c:iGK	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   37: getfield 66	com/tencent/mm/plugin/appbrand/report/model/h$a:iGR	I
    //   40: aload_1
    //   41: invokevirtual 114	java/lang/Object:hashCode	()I
    //   44: if_icmpne +17 -> 61
    //   47: aload_0
    //   48: getfield 73	com/tencent/mm/plugin/appbrand/report/model/c:iGK	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   51: astore_1
    //   52: ldc 207
    //   54: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: ldc 207
    //   63: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	76	1	paramz	z
    //   21	46	2	locala	h.a
    // Exception table:
    //   from	to	target	type
    //   2	22	71	finally
    //   26	57	71	finally
    //   61	66	71	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.c
 * JD-Core Version:    0.7.0.1
 */