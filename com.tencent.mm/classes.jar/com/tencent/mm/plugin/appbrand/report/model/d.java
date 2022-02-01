package com.tencent.mm.plugin.appbrand.report.model;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Deque;
import java.util.LinkedList;

public final class d
  implements j
{
  private final String tPk;
  private final SparseArray<j.a> tPl;
  private final Deque<j.a> tPm;
  private boolean tPn;
  private String tPo;
  private j.a tPp;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(321471);
    this.tPl = new SparseArray();
    this.tPm = new LinkedList();
    this.tPn = true;
    this.tPk = paramString1;
    try
    {
      this.tPo = paramString2;
      return;
    }
    finally
    {
      AppMethodBeat.o(321471);
    }
  }
  
  private void a(j.a parama)
  {
    try
    {
      AppMethodBeat.i(48102);
      Log.d("MicroMsg.AppBrandPageVisitStack", "push node(%d:%s)", new Object[] { Integer.valueOf(parama.hIa), parama.path });
      if (this.tPm.peekFirst() != parama) {
        this.tPm.offerFirst(parama);
      }
      this.tPl.put(parama.hIa, parama);
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
      boolean bool = afT(paramah2.cEE());
      if (bool) {
        cIK();
      }
      this.tPp = r(paramah2);
      this.tPp.tPy = new j.c(1, paramah1.cEE());
      int i = paramah1.hashCode();
      while ((!isEmpty()) && (cIM().hIa != i)) {
        cIL();
      }
      if (!bool) {
        break label107;
      }
    }
    finally {}
    a(new j.a(paramah1));
    label107:
    r(paramah1).tPz = new j.b(paramah2.cEE());
    r(paramah1).tPy = null;
    AppMethodBeat.o(48096);
  }
  
  private void cIK()
  {
    try
    {
      this.tPp = null;
      this.tPo = null;
      this.tPn = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private j.a cIL()
  {
    try
    {
      AppMethodBeat.i(48103);
      j.a locala = (j.a)this.tPm.pollFirst();
      if (locala != null)
      {
        Log.d("MicroMsg.AppBrandPageVisitStack", "pop node(%d:%s)", new Object[] { Integer.valueOf(locala.hIa), locala.path });
        this.tPl.remove(locala.hIa);
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
      boolean bool = this.tPm.isEmpty();
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
  private void q(ah paramah)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 166
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 102	com/tencent/mm/plugin/appbrand/page/ah:cEE	()Ljava/lang/String;
    //   12: putfield 47	com/tencent/mm/plugin/appbrand/report/model/d:tPo	Ljava/lang/String;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 43	com/tencent/mm/plugin/appbrand/report/model/d:tPn	Z
    //   20: aload_0
    //   21: new 60	com/tencent/mm/plugin/appbrand/report/model/j$a
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 142	com/tencent/mm/plugin/appbrand/report/model/j$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/ah;)V
    //   29: invokespecial 144	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/report/model/j$a;)V
    //   32: aload_0
    //   33: invokevirtual 136	com/tencent/mm/plugin/appbrand/report/model/d:cIM	()Lcom/tencent/mm/plugin/appbrand/report/model/j$a;
    //   36: astore_2
    //   37: aload_0
    //   38: getfield 45	com/tencent/mm/plugin/appbrand/report/model/d:tPk	Ljava/lang/String;
    //   41: invokestatic 171	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   44: ifeq +18 -> 62
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_2
    //   50: aload_1
    //   51: putfield 153	com/tencent/mm/plugin/appbrand/report/model/j$a:tPz	Lcom/tencent/mm/plugin/appbrand/report/model/j$b;
    //   54: ldc 166
    //   56: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: new 146	com/tencent/mm/plugin/appbrand/report/model/j$b
    //   65: dup
    //   66: aload_0
    //   67: getfield 45	com/tencent/mm/plugin/appbrand/report/model/d:tPk	Ljava/lang/String;
    //   70: invokespecial 149	com/tencent/mm/plugin/appbrand/report/model/j$b:<init>	(Ljava/lang/String;)V
    //   73: astore_1
    //   74: goto -25 -> 49
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	d
    //   0	82	1	paramah	ah
    //   36	14	2	locala	j.a
    // Exception table:
    //   from	to	target	type
    //   2	47	77	finally
    //   49	59	77	finally
    //   62	74	77	finally
  }
  
  private j.a r(ah paramah)
  {
    AppMethodBeat.i(48100);
    j.a locala = cIM();
    if (locala == null)
    {
      paramah = new j.a(paramah);
      AppMethodBeat.o(48100);
      return paramah;
    }
    if (locala.hIa == paramah.hashCode())
    {
      AppMethodBeat.o(48100);
      return locala;
    }
    Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
    AppMethodBeat.o(48100);
    return locala;
  }
  
  /* Error */
  public final void a(ah paramah1, ah paramah2, com.tencent.mm.plugin.appbrand.page.cb paramcb)
  {
    // Byte code:
    //   0: ldc 183
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 43	com/tencent/mm/plugin/appbrand/report/model/d:tPn	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 185	com/tencent/mm/plugin/appbrand/report/model/d:q	(Lcom/tencent/mm/plugin/appbrand/page/ah;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: ldc 183
    //   23: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: aload_3
    //   28: getstatic 191	com/tencent/mm/plugin/appbrand/page/cb:tBo	Lcom/tencent/mm/plugin/appbrand/page/cb;
    //   31: if_acmpne +17 -> 48
    //   34: aload_0
    //   35: aload_1
    //   36: aload_2
    //   37: invokespecial 193	com/tencent/mm/plugin/appbrand/report/model/d:b	(Lcom/tencent/mm/plugin/appbrand/page/ah;Lcom/tencent/mm/plugin/appbrand/page/ah;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: ldc 183
    //   44: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: aload_0
    //   49: getfield 115	com/tencent/mm/plugin/appbrand/report/model/d:tPp	Lcom/tencent/mm/plugin/appbrand/report/model/j$a;
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokespecial 109	com/tencent/mm/plugin/appbrand/report/model/d:cIK	()V
    //   59: aload_2
    //   60: ifnull +29 -> 89
    //   63: aload_0
    //   64: aload_2
    //   65: invokespecial 113	com/tencent/mm/plugin/appbrand/report/model/d:r	(Lcom/tencent/mm/plugin/appbrand/page/ah;)Lcom/tencent/mm/plugin/appbrand/report/model/j$a;
    //   68: astore_3
    //   69: aload_3
    //   70: ifnull +19 -> 89
    //   73: aload_3
    //   74: new 117	com/tencent/mm/plugin/appbrand/report/model/j$c
    //   77: dup
    //   78: iconst_2
    //   79: aload_1
    //   80: invokevirtual 102	com/tencent/mm/plugin/appbrand/page/ah:cEE	()Ljava/lang/String;
    //   83: invokespecial 120	com/tencent/mm/plugin/appbrand/report/model/j$c:<init>	(ILjava/lang/String;)V
    //   86: putfield 124	com/tencent/mm/plugin/appbrand/report/model/j$a:tPy	Lcom/tencent/mm/plugin/appbrand/report/model/j$c;
    //   89: new 60	com/tencent/mm/plugin/appbrand/report/model/j$a
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 142	com/tencent/mm/plugin/appbrand/report/model/j$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/ah;)V
    //   97: astore_3
    //   98: aload_2
    //   99: ifnonnull +23 -> 122
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_3
    //   105: aload_1
    //   106: putfield 153	com/tencent/mm/plugin/appbrand/report/model/j$a:tPz	Lcom/tencent/mm/plugin/appbrand/report/model/j$b;
    //   109: aload_0
    //   110: aload_3
    //   111: invokespecial 144	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/report/model/j$a;)V
    //   114: aload_0
    //   115: monitorexit
    //   116: ldc 183
    //   118: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: new 146	com/tencent/mm/plugin/appbrand/report/model/j$b
    //   125: dup
    //   126: aload_2
    //   127: invokevirtual 102	com/tencent/mm/plugin/appbrand/page/ah:cEE	()Ljava/lang/String;
    //   130: invokespecial 149	com/tencent/mm/plugin/appbrand/report/model/j$b:<init>	(Ljava/lang/String;)V
    //   133: astore_1
    //   134: goto -30 -> 104
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: ldc 183
    //   142: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_1
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	d
    //   0	147	1	paramah1	ah
    //   0	147	2	paramah2	ah
    //   0	147	3	paramcb	com.tencent.mm.plugin.appbrand.page.cb
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
  public final boolean afT(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 194
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 47	com/tencent/mm/plugin/appbrand/report/model/d:tPo	Ljava/lang/String;
    //   11: invokestatic 171	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   14: ifne +25 -> 39
    //   17: aload_0
    //   18: getfield 47	com/tencent/mm/plugin/appbrand/report/model/d:tPo	Ljava/lang/String;
    //   21: aload_1
    //   22: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +14 -> 39
    //   28: iconst_1
    //   29: istore_2
    //   30: ldc 194
    //   32: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_2
    //   41: ldc 194
    //   43: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -11 -> 35
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	d
    //   0	54	1	paramString	String
    //   29	12	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	28	49	finally
    //   30	35	49	finally
    //   41	46	49	finally
  }
  
  public final j.a cIM()
  {
    try
    {
      AppMethodBeat.i(48104);
      j.a locala = (j.a)this.tPm.peekFirst();
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
      j.a locala = r(paramah);
      if (locala == null) {
        return;
      }
      paramah = e.t(paramah);
      locala.tPy = new j.c(((Integer)paramah.first).intValue(), (String)paramah.second);
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
      if (this.tPn) {
        q(paramah);
      }
      AppMethodBeat.o(48101);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final j.a s(ah paramah)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 224
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 36	com/tencent/mm/plugin/appbrand/report/model/d:tPl	Landroid/util/SparseArray;
    //   11: aload_1
    //   12: invokevirtual 128	java/lang/Object:hashCode	()I
    //   15: invokevirtual 228	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   18: checkcast 60	com/tencent/mm/plugin/appbrand/report/model/j$a
    //   21: astore_2
    //   22: aload_2
    //   23: ifnonnull +38 -> 61
    //   26: aload_0
    //   27: getfield 115	com/tencent/mm/plugin/appbrand/report/model/d:tPp	Lcom/tencent/mm/plugin/appbrand/report/model/j$a;
    //   30: ifnull +31 -> 61
    //   33: aload_0
    //   34: getfield 115	com/tencent/mm/plugin/appbrand/report/model/d:tPp	Lcom/tencent/mm/plugin/appbrand/report/model/j$a;
    //   37: getfield 64	com/tencent/mm/plugin/appbrand/report/model/j$a:hIa	I
    //   40: aload_1
    //   41: invokevirtual 128	java/lang/Object:hashCode	()I
    //   44: if_icmpne +17 -> 61
    //   47: aload_0
    //   48: getfield 115	com/tencent/mm/plugin/appbrand/report/model/d:tPp	Lcom/tencent/mm/plugin/appbrand/report/model/j$a;
    //   51: astore_1
    //   52: ldc 224
    //   54: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: ldc 224
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
    //   0	76	0	this	d
    //   0	76	1	paramah	ah
    //   21	46	2	locala	j.a
    // Exception table:
    //   from	to	target	type
    //   2	22	71	finally
    //   26	57	71	finally
    //   61	66	71	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.d
 * JD-Core Version:    0.7.0.1
 */