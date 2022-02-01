package com.tencent.mm.plugin.appbrand.report.model;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Deque;
import java.util.LinkedList;

public final class c
  implements h
{
  private final String qKH;
  private final SparseArray<h.a> qKI;
  private final Deque<h.a> qKJ;
  private boolean qKK;
  private String qKL;
  private h.a qKM;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(279845);
    this.qKI = new SparseArray();
    this.qKJ = new LinkedList();
    this.qKK = true;
    this.qKH = paramString1;
    try
    {
      this.qKL = paramString2;
      return;
    }
    finally
    {
      AppMethodBeat.o(279845);
    }
  }
  
  private void a(h.a parama)
  {
    try
    {
      AppMethodBeat.i(48102);
      Log.d("MicroMsg.AppBrandPageVisitStack", "push node(%d:%s)", new Object[] { Integer.valueOf(parama.fDk), parama.path });
      if (this.qKJ.peekFirst() != parama) {
        this.qKJ.offerFirst(parama);
      }
      this.qKI.put(parama.fDk, parama);
      AppMethodBeat.o(48102);
      return;
    }
    finally {}
  }
  
  private void b(ah paramah1, ah paramah2)
  {
    try
    {
      AppMethodBeat.i(48096);
      boolean bool = amH(paramah2.qoI);
      if (bool) {
        chP();
      }
      this.qKM = p(paramah2);
      this.qKM.qKT = new h.c(1, paramah1.qoI);
      int i = paramah1.hashCode();
      while ((!isEmpty()) && (chR().fDk != i)) {
        chQ();
      }
      if (!bool) {
        break label107;
      }
    }
    finally {}
    a(new h.a(paramah1));
    label107:
    p(paramah1).qKU = new h.b(paramah2.qoI);
    p(paramah1).qKT = null;
    AppMethodBeat.o(48096);
  }
  
  private void chP()
  {
    try
    {
      this.qKM = null;
      this.qKL = null;
      this.qKK = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h.a chQ()
  {
    try
    {
      AppMethodBeat.i(48103);
      h.a locala = (h.a)this.qKJ.pollFirst();
      if (locala != null)
      {
        Log.d("MicroMsg.AppBrandPageVisitStack", "pop node(%d:%s)", new Object[] { Integer.valueOf(locala.fDk), locala.path });
        this.qKI.remove(locala.fDk);
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
      boolean bool = this.qKJ.isEmpty();
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
  private void o(ah paramah)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 164
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: getfield 101	com/tencent/mm/plugin/appbrand/page/ad:qoI	Ljava/lang/String;
    //   12: putfield 47	com/tencent/mm/plugin/appbrand/report/model/c:qKL	Ljava/lang/String;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 43	com/tencent/mm/plugin/appbrand/report/model/c:qKK	Z
    //   20: aload_0
    //   21: new 60	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 141	com/tencent/mm/plugin/appbrand/report/model/h$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/ah;)V
    //   29: invokespecial 143	com/tencent/mm/plugin/appbrand/report/model/c:a	(Lcom/tencent/mm/plugin/appbrand/report/model/h$a;)V
    //   32: aload_0
    //   33: invokevirtual 135	com/tencent/mm/plugin/appbrand/report/model/c:chR	()Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   36: astore_2
    //   37: aload_0
    //   38: getfield 45	com/tencent/mm/plugin/appbrand/report/model/c:qKH	Ljava/lang/String;
    //   41: invokestatic 169	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   44: ifeq +18 -> 62
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_2
    //   50: aload_1
    //   51: putfield 152	com/tencent/mm/plugin/appbrand/report/model/h$a:qKU	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
    //   54: ldc 164
    //   56: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: new 145	com/tencent/mm/plugin/appbrand/report/model/h$b
    //   65: dup
    //   66: aload_0
    //   67: getfield 45	com/tencent/mm/plugin/appbrand/report/model/c:qKH	Ljava/lang/String;
    //   70: invokespecial 148	com/tencent/mm/plugin/appbrand/report/model/h$b:<init>	(Ljava/lang/String;)V
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
    //   0	82	1	paramah	ah
    //   36	14	2	locala	h.a
    // Exception table:
    //   from	to	target	type
    //   2	47	77	finally
    //   49	59	77	finally
    //   62	74	77	finally
  }
  
  private h.a p(ah paramah)
  {
    AppMethodBeat.i(48100);
    h.a locala = chR();
    if (locala == null)
    {
      paramah = new h.a(paramah);
      AppMethodBeat.o(48100);
      return paramah;
    }
    if (locala.fDk == paramah.hashCode())
    {
      AppMethodBeat.o(48100);
      return locala;
    }
    Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
    AppMethodBeat.o(48100);
    return locala;
  }
  
  /* Error */
  public final void a(ah paramah1, ah paramah2, com.tencent.mm.plugin.appbrand.page.ca paramca)
  {
    // Byte code:
    //   0: ldc 181
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 43	com/tencent/mm/plugin/appbrand/report/model/c:qKK	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 183	com/tencent/mm/plugin/appbrand/report/model/c:o	(Lcom/tencent/mm/plugin/appbrand/page/ah;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: ldc 181
    //   23: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: aload_3
    //   28: getstatic 189	com/tencent/mm/plugin/appbrand/page/ca:qwz	Lcom/tencent/mm/plugin/appbrand/page/ca;
    //   31: if_acmpne +17 -> 48
    //   34: aload_0
    //   35: aload_1
    //   36: aload_2
    //   37: invokespecial 191	com/tencent/mm/plugin/appbrand/report/model/c:b	(Lcom/tencent/mm/plugin/appbrand/page/ah;Lcom/tencent/mm/plugin/appbrand/page/ah;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: ldc 181
    //   44: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: aload_0
    //   49: getfield 114	com/tencent/mm/plugin/appbrand/report/model/c:qKM	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokespecial 108	com/tencent/mm/plugin/appbrand/report/model/c:chP	()V
    //   59: aload_2
    //   60: ifnull +29 -> 89
    //   63: aload_0
    //   64: aload_2
    //   65: invokespecial 112	com/tencent/mm/plugin/appbrand/report/model/c:p	(Lcom/tencent/mm/plugin/appbrand/page/ah;)Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   68: astore_3
    //   69: aload_3
    //   70: ifnull +19 -> 89
    //   73: aload_3
    //   74: new 116	com/tencent/mm/plugin/appbrand/report/model/h$c
    //   77: dup
    //   78: iconst_2
    //   79: aload_1
    //   80: getfield 101	com/tencent/mm/plugin/appbrand/page/ad:qoI	Ljava/lang/String;
    //   83: invokespecial 119	com/tencent/mm/plugin/appbrand/report/model/h$c:<init>	(ILjava/lang/String;)V
    //   86: putfield 123	com/tencent/mm/plugin/appbrand/report/model/h$a:qKT	Lcom/tencent/mm/plugin/appbrand/report/model/h$c;
    //   89: new 60	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 141	com/tencent/mm/plugin/appbrand/report/model/h$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/ah;)V
    //   97: astore_3
    //   98: aload_2
    //   99: ifnonnull +23 -> 122
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_3
    //   105: aload_1
    //   106: putfield 152	com/tencent/mm/plugin/appbrand/report/model/h$a:qKU	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
    //   109: aload_0
    //   110: aload_3
    //   111: invokespecial 143	com/tencent/mm/plugin/appbrand/report/model/c:a	(Lcom/tencent/mm/plugin/appbrand/report/model/h$a;)V
    //   114: aload_0
    //   115: monitorexit
    //   116: ldc 181
    //   118: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: new 145	com/tencent/mm/plugin/appbrand/report/model/h$b
    //   125: dup
    //   126: aload_2
    //   127: getfield 101	com/tencent/mm/plugin/appbrand/page/ad:qoI	Ljava/lang/String;
    //   130: invokespecial 148	com/tencent/mm/plugin/appbrand/report/model/h$b:<init>	(Ljava/lang/String;)V
    //   133: astore_1
    //   134: goto -30 -> 104
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: ldc 181
    //   142: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_1
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	c
    //   0	147	1	paramah1	ah
    //   0	147	2	paramah2	ah
    //   0	147	3	paramca	com.tencent.mm.plugin.appbrand.page.ca
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
  }
  
  /* Error */
  public final boolean amH(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 192
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 47	com/tencent/mm/plugin/appbrand/report/model/c:qKL	Ljava/lang/String;
    //   11: invokestatic 169	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   14: ifne +25 -> 39
    //   17: aload_0
    //   18: getfield 47	com/tencent/mm/plugin/appbrand/report/model/c:qKL	Ljava/lang/String;
    //   21: aload_1
    //   22: invokevirtual 197	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +14 -> 39
    //   28: iconst_1
    //   29: istore_2
    //   30: ldc 192
    //   32: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_2
    //   41: ldc 192
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
  
  public final h.a chR()
  {
    try
    {
      AppMethodBeat.i(48104);
      h.a locala = (h.a)this.qKJ.peekFirst();
      AppMethodBeat.o(48104);
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void e(ah paramah)
  {
    AppMethodBeat.i(48099);
    try
    {
      h.a locala = p(paramah);
      if (locala == null) {
        return;
      }
      paramah = d.r(paramah);
      locala.qKT = new h.c(((Integer)paramah.first).intValue(), (String)paramah.second);
      return;
    }
    finally
    {
      AppMethodBeat.o(48099);
    }
  }
  
  public final void f(ah paramah)
  {
    try
    {
      AppMethodBeat.i(48101);
      if (this.qKK) {
        o(paramah);
      }
      AppMethodBeat.o(48101);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final h.a q(ah paramah)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 222
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 36	com/tencent/mm/plugin/appbrand/report/model/c:qKI	Landroid/util/SparseArray;
    //   11: aload_1
    //   12: invokevirtual 127	java/lang/Object:hashCode	()I
    //   15: invokevirtual 226	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   18: checkcast 60	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   21: astore_2
    //   22: aload_2
    //   23: ifnonnull +38 -> 61
    //   26: aload_0
    //   27: getfield 114	com/tencent/mm/plugin/appbrand/report/model/c:qKM	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   30: ifnull +31 -> 61
    //   33: aload_0
    //   34: getfield 114	com/tencent/mm/plugin/appbrand/report/model/c:qKM	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   37: getfield 64	com/tencent/mm/plugin/appbrand/report/model/h$a:fDk	I
    //   40: aload_1
    //   41: invokevirtual 127	java/lang/Object:hashCode	()I
    //   44: if_icmpne +17 -> 61
    //   47: aload_0
    //   48: getfield 114	com/tencent/mm/plugin/appbrand/report/model/c:qKM	Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   51: astore_1
    //   52: ldc 222
    //   54: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: ldc 222
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
    //   0	76	1	paramah	ah
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