package com.tencent.mm.plugin.appbrand.report.model;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Deque;
import java.util.LinkedList;

public final class c
  implements g, h
{
  private final String mxr;
  private final SparseArray<h.a> mxs;
  private final Deque<h.a> mxt;
  private boolean mxu;
  private String mxv;
  private h.a mxw;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222932);
    this.mxs = new SparseArray();
    this.mxt = new LinkedList();
    this.mxu = true;
    this.mxr = paramString1;
    try
    {
      this.mxv = paramString2;
      return;
    }
    finally
    {
      AppMethodBeat.o(222932);
    }
  }
  
  private void a(h.a parama)
  {
    try
    {
      AppMethodBeat.i(48102);
      this.mxt.offerFirst(parama);
      this.mxs.put(parama.dtl, parama);
      AppMethodBeat.o(48102);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private void b(ad paramad1, ad paramad2)
  {
    try
    {
      AppMethodBeat.i(48096);
      boolean bool = UY(paramad2.mcM);
      this.mxw = r(paramad2);
      this.mxw.mxD = new h.c(1, paramad1.mcM);
      int i = paramad1.hashCode();
      while ((!isEmpty()) && (byp().dtl != i)) {
        byo();
      }
      if (!bool) {
        break label98;
      }
    }
    finally {}
    a(new h.a(paramad1));
    label98:
    r(paramad1).mxE = new h.b(paramad2.mcM);
    r(paramad1).mxD = null;
    AppMethodBeat.o(48096);
  }
  
  private void byn()
  {
    try
    {
      this.mxw = null;
      this.mxv = null;
      this.mxu = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h.a byo()
  {
    try
    {
      AppMethodBeat.i(48103);
      h.a locala = (h.a)this.mxt.pollFirst();
      if (locala != null) {
        this.mxs.remove(locala.dtl);
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
      boolean bool = this.mxt.isEmpty();
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
  private void q(ad paramad)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 141
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: getfield 80	com/tencent/mm/plugin/appbrand/page/z:mcM	Ljava/lang/String;
    //   12: putfield 49	com/tencent/mm/plugin/appbrand/report/model/c:mxv	Ljava/lang/String;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 45	com/tencent/mm/plugin/appbrand/report/model/c:mxu	Z
    //   20: aload_0
    //   21: new 64	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 117	com/tencent/mm/plugin/appbrand/report/model/h$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/ad;)V
    //   29: invokespecial 119	com/tencent/mm/plugin/appbrand/report/model/c:a	(Lcom/tencent/mm/plugin/appbrand/report/model/h$a;)V
    //   32: aload_0
    //   33: invokevirtual 111	com/tencent/mm/plugin/appbrand/report/model/c:byp	()Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   36: astore_2
    //   37: aload_0
    //   38: getfield 47	com/tencent/mm/plugin/appbrand/report/model/c:mxr	Ljava/lang/String;
    //   41: invokestatic 146	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   44: ifeq +18 -> 62
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_2
    //   50: aload_1
    //   51: putfield 128	com/tencent/mm/plugin/appbrand/report/model/h$a:mxE	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
    //   54: ldc 141
    //   56: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: new 121	com/tencent/mm/plugin/appbrand/report/model/h$b
    //   65: dup
    //   66: aload_0
    //   67: getfield 47	com/tencent/mm/plugin/appbrand/report/model/c:mxr	Ljava/lang/String;
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
    //   0	82	1	paramad	ad
    //   36	14	2	locala	h.a
    // Exception table:
    //   from	to	target	type
    //   2	47	77	finally
    //   49	59	77	finally
    //   62	74	77	finally
  }
  
  private h.a r(ad paramad)
  {
    AppMethodBeat.i(48100);
    h.a locala = byp();
    if (locala == null)
    {
      paramad = new h.a(paramad);
      AppMethodBeat.o(48100);
      return paramad;
    }
    if (locala.dtl == paramad.hashCode())
    {
      AppMethodBeat.o(48100);
      return locala;
    }
    ae.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
    AppMethodBeat.o(48100);
    return locala;
  }
  
  /* Error */
  public final boolean UY(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 161
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 49	com/tencent/mm/plugin/appbrand/report/model/c:mxv	Ljava/lang/String;
    //   11: invokestatic 146	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   14: ifne +25 -> 39
    //   17: aload_0
    //   18: getfield 49	com/tencent/mm/plugin/appbrand/report/model/c:mxv	Ljava/lang/String;
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
  public final void a(ad paramad1, ad paramad2, com.tencent.mm.plugin.appbrand.page.br parambr)
  {
    // Byte code:
    //   0: ldc 168
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 45	com/tencent/mm/plugin/appbrand/report/model/c:mxu	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 170	com/tencent/mm/plugin/appbrand/report/model/c:q	(Lcom/tencent/mm/plugin/appbrand/page/ad;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: ldc 168
    //   23: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: aload_3
    //   28: getstatic 176	com/tencent/mm/plugin/appbrand/page/br:mki	Lcom/tencent/mm/plugin/appbrand/page/br;
    //   31: if_acmpne +17 -> 48
    //   34: aload_0
    //   35: aload_1
    //   36: aload_2
    //   37: invokespecial 178	com/tencent/mm/plugin/appbrand/report/model/c:b	(Lcom/tencent/mm/plugin/appbrand/page/ad;Lcom/tencent/mm/plugin/appbrand/page/ad;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: ldc 168
    //   44: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: aload_0
    //   49: getfield 90	com/tencent/mm/plugin/appbrand/report/model/c:mxw	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokespecial 180	com/tencent/mm/plugin/appbrand/report/model/c:byn	()V
    //   59: aload_2
    //   60: ifnull +29 -> 89
    //   63: aload_0
    //   64: aload_2
    //   65: invokespecial 88	com/tencent/mm/plugin/appbrand/report/model/c:r	(Lcom/tencent/mm/plugin/appbrand/page/ad;)Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   68: astore_3
    //   69: aload_3
    //   70: ifnull +19 -> 89
    //   73: aload_3
    //   74: new 92	com/tencent/mm/plugin/appbrand/report/model/h$c
    //   77: dup
    //   78: iconst_2
    //   79: aload_1
    //   80: getfield 80	com/tencent/mm/plugin/appbrand/page/z:mcM	Ljava/lang/String;
    //   83: invokespecial 95	com/tencent/mm/plugin/appbrand/report/model/h$c:<init>	(ILjava/lang/String;)V
    //   86: putfield 99	com/tencent/mm/plugin/appbrand/report/model/h$a:mxD	Lcom/tencent/mm/plugin/appbrand/report/model/h$c;
    //   89: new 64	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 117	com/tencent/mm/plugin/appbrand/report/model/h$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/ad;)V
    //   97: astore_3
    //   98: aload_2
    //   99: ifnonnull +23 -> 122
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_3
    //   105: aload_1
    //   106: putfield 128	com/tencent/mm/plugin/appbrand/report/model/h$a:mxE	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
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
    //   127: getfield 80	com/tencent/mm/plugin/appbrand/page/z:mcM	Ljava/lang/String;
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
    //   0	147	1	paramad1	ad
    //   0	147	2	paramad2	ad
    //   0	147	3	parambr	com.tencent.mm.plugin.appbrand.page.br
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
  
  public final h.a byp()
  {
    try
    {
      AppMethodBeat.i(48104);
      h.a locala = (h.a)this.mxt.peekFirst();
      AppMethodBeat.o(48104);
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void d(ad paramad)
  {
    AppMethodBeat.i(48099);
    try
    {
      h.a locala = r(paramad);
      if (locala == null) {
        return;
      }
      paramad = d.t(paramad);
      locala.mxD = new h.c(((Integer)paramad.first).intValue(), (String)paramad.second);
      return;
    }
    finally
    {
      AppMethodBeat.o(48099);
    }
  }
  
  /* Error */
  public final void e(ad paramad)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 208
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 45	com/tencent/mm/plugin/appbrand/report/model/c:mxu	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 170	com/tencent/mm/plugin/appbrand/report/model/c:q	(Lcom/tencent/mm/plugin/appbrand/page/ad;)V
    //   19: ldc 208
    //   21: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: invokespecial 180	com/tencent/mm/plugin/appbrand/report/model/c:byn	()V
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
    //   0	44	1	paramad	ad
    // Exception table:
    //   from	to	target	type
    //   2	24	39	finally
    //   27	36	39	finally
  }
  
  /* Error */
  public final h.a s(ad paramad)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 210
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 38	com/tencent/mm/plugin/appbrand/report/model/c:mxs	Landroid/util/SparseArray;
    //   11: aload_1
    //   12: invokevirtual 103	java/lang/Object:hashCode	()I
    //   15: invokevirtual 214	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   18: checkcast 64	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   21: astore_2
    //   22: aload_2
    //   23: ifnonnull +38 -> 61
    //   26: aload_0
    //   27: getfield 90	com/tencent/mm/plugin/appbrand/report/model/c:mxw	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   30: ifnull +31 -> 61
    //   33: aload_0
    //   34: getfield 90	com/tencent/mm/plugin/appbrand/report/model/c:mxw	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   37: getfield 68	com/tencent/mm/plugin/appbrand/report/model/h$a:dtl	I
    //   40: aload_1
    //   41: invokevirtual 103	java/lang/Object:hashCode	()I
    //   44: if_icmpne +17 -> 61
    //   47: aload_0
    //   48: getfield 90	com/tencent/mm/plugin/appbrand/report/model/c:mxw	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
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
    //   0	76	1	paramad	ad
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