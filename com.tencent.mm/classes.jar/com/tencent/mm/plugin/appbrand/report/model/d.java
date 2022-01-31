package com.tencent.mm.plugin.appbrand.report.model;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Deque;
import java.util.LinkedList;

final class d
  implements g, h
{
  private final String gYo;
  private final SparseArray<h.a> gYp = new SparseArray();
  private final Deque<h.a> gYq = new LinkedList();
  private boolean gYr = true;
  private String gYs;
  private h.a gYt;
  
  d(String paramString)
  {
    this.gYo = paramString;
  }
  
  private void a(h.a parama)
  {
    try
    {
      this.gYq.offerFirst(parama);
      this.gYp.put(parama.gYA, parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private void aoi()
  {
    try
    {
      this.gYt = null;
      this.gYs = null;
      this.gYr = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h.a aoj()
  {
    try
    {
      h.a locala = (h.a)this.gYq.pollFirst();
      if (locala != null) {
        this.gYp.remove(locala.gYA);
      }
      return locala;
    }
    finally {}
  }
  
  private void b(s params1, s params2)
  {
    try
    {
      boolean bool = wd(params2.ahc());
      this.gYt = f(params2);
      this.gYt.gYB = new h.c(1, params1.ahc());
      int i = params1.hashCode();
      while ((!isEmpty()) && (aok().gYA != i)) {
        aoj();
      }
      if (!bool) {
        break label93;
      }
    }
    finally {}
    a(new h.a(params1));
    label93:
    f(params1).gYC = new h.b(params2.ahc());
    f(params1).gYB = null;
  }
  
  /* Error */
  private void e(s params)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 82	com/tencent/mm/plugin/appbrand/page/s:ahc	()Ljava/lang/String;
    //   7: putfield 64	com/tencent/mm/plugin/appbrand/report/model/d:gYs	Ljava/lang/String;
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 38	com/tencent/mm/plugin/appbrand/report/model/d:gYr	Z
    //   15: aload_0
    //   16: new 51	com/tencent/mm/plugin/appbrand/report/model/h$a
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 115	com/tencent/mm/plugin/appbrand/report/model/h$a:<init>	(Lcom/tencent/mm/plugin/appbrand/page/s;)V
    //   24: invokespecial 117	com/tencent/mm/plugin/appbrand/report/model/d:a	(Lcom/tencent/mm/plugin/appbrand/report/model/h$a;)V
    //   27: aload_0
    //   28: invokevirtual 110	com/tencent/mm/plugin/appbrand/report/model/d:aok	()Lcom/tencent/mm/plugin/appbrand/report/model/h$a;
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 40	com/tencent/mm/plugin/appbrand/report/model/d:gYo	Ljava/lang/String;
    //   36: invokestatic 131	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   39: ifeq +13 -> 52
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_2
    //   45: aload_1
    //   46: putfield 125	com/tencent/mm/plugin/appbrand/report/model/h$a:gYC	Lcom/tencent/mm/plugin/appbrand/report/model/h$b;
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: new 119	com/tencent/mm/plugin/appbrand/report/model/h$b
    //   55: dup
    //   56: aload_0
    //   57: getfield 40	com/tencent/mm/plugin/appbrand/report/model/d:gYo	Ljava/lang/String;
    //   60: invokespecial 121	com/tencent/mm/plugin/appbrand/report/model/h$b:<init>	(Ljava/lang/String;)V
    //   63: astore_1
    //   64: goto -20 -> 44
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	d
    //   0	72	1	params	s
    //   31	14	2	locala	h.a
    // Exception table:
    //   from	to	target	type
    //   2	42	67	finally
    //   44	49	67	finally
    //   52	64	67	finally
  }
  
  private h.a f(s params)
  {
    h.a locala2 = aok();
    h.a locala1;
    if (locala2 == null) {
      locala1 = new h.a(params);
    }
    do
    {
      return locala1;
      locala1 = locala2;
    } while (locala2.gYA == params.hashCode());
    y.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
    return locala2;
  }
  
  private boolean isEmpty()
  {
    try
    {
      boolean bool = this.gYq.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(s params1, s params2, al paramal)
  {
    try
    {
      if (this.gYr)
      {
        e(params1);
        return;
      }
      if (paramal == al.gVN)
      {
        b(params1, params2);
        return;
      }
    }
    finally {}
    if (this.gYt != null) {
      aoi();
    }
    if (params2 != null)
    {
      paramal = f(params2);
      if (paramal != null) {
        paramal.gYB = new h.c(2, params1.ahc());
      }
    }
    paramal = new h.a(params1);
    if (params2 == null) {}
    for (params1 = null;; params1 = new h.b(params2.ahc()))
    {
      paramal.gYC = params1;
      a(paramal);
      return;
    }
  }
  
  public final h.a aok()
  {
    try
    {
      h.a locala = (h.a)this.gYq.peekFirst();
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void c(s params)
  {
    try
    {
      h.a locala = f(params);
      if (locala == null) {
        return;
      }
      params = e.h(params);
      locala.gYB = new h.c(((Integer)params.first).intValue(), (String)params.second);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void d(s params)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/mm/plugin/appbrand/report/model/d:gYr	Z
    //   6: ifeq +11 -> 17
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 148	com/tencent/mm/plugin/appbrand/report/model/d:e	(Lcom/tencent/mm/plugin/appbrand/page/s;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: invokespecial 158	com/tencent/mm/plugin/appbrand/report/model/d:aoi	()V
    //   21: goto -7 -> 14
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	d
    //   0	29	1	params	s
    // Exception table:
    //   from	to	target	type
    //   2	14	24	finally
    //   17	21	24	finally
  }
  
  public final h.a g(s params)
  {
    try
    {
      h.a locala2 = (h.a)this.gYp.get(params.hashCode());
      h.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = locala2;
        if (this.gYt != null)
        {
          locala1 = locala2;
          if (this.gYt.gYA == params.hashCode()) {
            locala1 = this.gYt;
          }
        }
      }
      return locala1;
    }
    finally {}
  }
  
  /* Error */
  public final boolean wd(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 64	com/tencent/mm/plugin/appbrand/report/model/d:gYs	Ljava/lang/String;
    //   6: invokestatic 131	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   9: ifne +22 -> 31
    //   12: aload_0
    //   13: getfield 64	com/tencent/mm/plugin/appbrand/report/model/d:gYs	Ljava/lang/String;
    //   16: aload_1
    //   17: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: istore_2
    //   21: iload_2
    //   22: ifeq +9 -> 31
    //   25: iconst_1
    //   26: istore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_2
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_2
    //   33: goto -6 -> 27
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	d
    //   0	41	1	paramString	String
    //   20	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	21	36	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.d
 * JD-Core Version:    0.7.0.1
 */