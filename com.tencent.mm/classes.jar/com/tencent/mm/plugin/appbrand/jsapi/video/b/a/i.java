package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.os.ConditionVariable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public final class i
  implements a
{
  private final HashMap<String, f> bqp;
  private final HashMap<String, ArrayList<a.a>> bqq;
  private long bqr;
  final q pwd;
  private final d pwe;
  private final HashMap<String, TreeSet<f>> pwf;
  
  public i(final q paramq, d paramd)
  {
    AppMethodBeat.i(228008);
    this.pwd = paramq;
    this.pwe = paramd;
    this.bqp = new HashMap();
    this.pwf = new HashMap();
    this.bqq = new HashMap();
    paramq = new ConditionVariable();
    new Thread()
    {
      public final void run()
      {
        AppMethodBeat.i(228707);
        for (;;)
        {
          int i;
          f localf;
          synchronized (i.this)
          {
            paramq.open();
            i locali2 = i.this;
            if (!locali2.pwd.ifE()) {
              locali2.pwd.ifL();
            }
            q[] arrayOfq = locali2.pwd.ifJ();
            if (arrayOfq == null) {
              break label165;
            }
            i = 0;
            if (i >= arrayOfq.length) {
              break label165;
            }
            q localq = arrayOfq[i];
            if (localq.length() == 0L)
            {
              localq.cFq();
            }
            else
            {
              localf = f.A(localq);
              if (localf == null) {
                localq.cFq();
              }
            }
          }
          if (!localObject.f(localf))
          {
            h.log(3, "SimpleCache", "remove duplicated span " + localf.file);
            localObject.b(localf);
            break label173;
            label165:
            AppMethodBeat.o(228707);
            return;
          }
          label173:
          i += 1;
        }
      }
    }.start();
    paramq.block();
    AppMethodBeat.o(228008);
  }
  
  /* Error */
  private NavigableSet<f> bF(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 44	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:pwf	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 69	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 71	java/util/TreeSet
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +14 -> 34
    //   23: aconst_null
    //   24: astore_1
    //   25: ldc 65
    //   27: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: new 71	java/util/TreeSet
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 74	java/util/TreeSet:<init>	(Ljava/util/SortedSet;)V
    //   42: astore_1
    //   43: ldc 65
    //   45: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: goto -18 -> 30
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	i
    //   0	56	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	19	51	finally
    //   25	30	51	finally
    //   34	48	51	finally
  }
  
  private void bVz()
  {
    AppMethodBeat.i(228037);
    Iterator localIterator1 = this.pwf.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((TreeSet)((Map.Entry)localIterator1.next()).getValue()).iterator();
      int i = 1;
      while (localIterator2.hasNext())
      {
        f localf = (f)localIterator2.next();
        if (!localf.file.ifE())
        {
          localIterator2.remove();
          if (localf.bpU) {
            this.bqr -= localf.aFL;
          }
          g(localf);
        }
        else
        {
          i = 0;
        }
      }
      if (i != 0) {
        localIterator1.remove();
      }
    }
    AppMethodBeat.o(228037);
  }
  
  private f e(f paramf)
  {
    for (;;)
    {
      String str;
      f localf;
      try
      {
        AppMethodBeat.i(228021);
        str = paramf.key;
        long l = paramf.position;
        TreeSet localTreeSet = (TreeSet)this.pwf.get(str);
        if (localTreeSet == null)
        {
          localf = f.T(str, paramf.position);
          if (!localf.bpU) {
            break label188;
          }
          AppMethodBeat.o(228021);
          return localf;
        }
        localf = (f)localTreeSet.floor(paramf);
        if ((localf != null) && (localf.position <= l) && (l < localf.position + localf.aFL))
        {
          if (localf.file.ifE()) {
            continue;
          }
          bVz();
          continue;
        }
        localf = (f)localTreeSet.ceiling(paramf);
      }
      finally {}
      if (localf == null)
      {
        localf = f.T(str, paramf.position);
      }
      else
      {
        localf = f.p(str, paramf.position, localf.position - paramf.position);
        continue;
        label188:
        if (!this.bqp.containsKey(paramf.key))
        {
          this.bqp.put(paramf.key, localf);
          AppMethodBeat.o(228021);
        }
        else
        {
          localf = null;
          AppMethodBeat.o(228021);
        }
      }
    }
  }
  
  private void g(f paramf)
  {
    AppMethodBeat.i(228041);
    ArrayList localArrayList = (ArrayList)this.bqq.get(paramf.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.a)localArrayList.get(i)).c(paramf);
        i -= 1;
      }
    }
    this.pwe.c(paramf);
    AppMethodBeat.o(228041);
  }
  
  private void h(f paramf)
  {
    AppMethodBeat.i(228046);
    ArrayList localArrayList = (ArrayList)this.bqq.get(paramf.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.a)localArrayList.get(i)).a(this, paramf);
        i -= 1;
      }
    }
    this.pwe.a(this, paramf);
    AppMethodBeat.o(228046);
  }
  
  /* Error */
  public final f Q(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 191
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: lload_2
    //   9: invokestatic 194	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:S	(Ljava/lang/String;J)Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/f;
    //   12: astore_1
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 196	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:e	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/f;)Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/f;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +13 -> 35
    //   25: ldc 191
    //   27: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 199	java/lang/Object:wait	()V
    //   39: goto -26 -> 13
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	i
    //   0	47	1	paramString	String
    //   0	47	2	paramLong	long
    //   18	15	4	localf	f
    // Exception table:
    //   from	to	target	type
    //   2	13	42	finally
    //   13	20	42	finally
    //   25	30	42	finally
    //   35	39	42	finally
  }
  
  public final f R(String paramString, long paramLong)
  {
    try
    {
      AppMethodBeat.i(228016);
      paramString = e(f.S(paramString, paramLong));
      AppMethodBeat.o(228016);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final q a(String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    try
    {
      AppMethodBeat.i(228027);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(this.bqp.containsKey(paramString));
      if (!this.pwd.ifE())
      {
        bVz();
        this.pwd.ifL();
      }
      this.pwe.a(this, paramLong3);
      paramString = f.a(this.pwd, paramString, paramLong1, paramLong2, paramc, System.currentTimeMillis());
      AppMethodBeat.o(228027);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public final void a(f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 225
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 42	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:bqp	Ljava/util/HashMap;
    //   12: aload_1
    //   13: getfield 137	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:key	Ljava/lang/String;
    //   16: invokevirtual 227	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: if_acmpne +21 -> 40
    //   22: iconst_1
    //   23: istore_2
    //   24: iload_2
    //   25: invokestatic 209	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/a:checkState	(Z)V
    //   28: aload_0
    //   29: invokevirtual 230	java/lang/Object:notifyAll	()V
    //   32: ldc 225
    //   34: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -18 -> 24
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	i
    //   0	50	1	paramf	f
    //   23	19	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	22	45	finally
    //   24	37	45	finally
  }
  
  /* Error */
  public final long aiR(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 233
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 235	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:bF	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +40 -> 54
    //   17: aload_1
    //   18: invokeinterface 240 1 0
    //   23: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +26 -> 54
    //   31: aload_1
    //   32: getfield 243	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:nHt	J
    //   35: lconst_0
    //   36: lcmp
    //   37: iflt +17 -> 54
    //   40: aload_1
    //   41: getfield 243	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:nHt	J
    //   44: lstore_2
    //   45: ldc 233
    //   47: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: lload_2
    //   53: lreturn
    //   54: ldc2_w 244
    //   57: lstore_2
    //   58: ldc 233
    //   60: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: goto -13 -> 50
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	i
    //   0	71	1	paramString	String
    //   44	14	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	13	66	finally
    //   17	27	66	finally
    //   31	50	66	finally
    //   58	63	66	finally
  }
  
  /* Error */
  public final c aiS(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 248
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 235	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:bF	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +40 -> 54
    //   17: aload_1
    //   18: invokeinterface 240 1 0
    //   23: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +26 -> 54
    //   31: aload_1
    //   32: getfield 243	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:nHt	J
    //   35: lconst_0
    //   36: lcmp
    //   37: iflt +17 -> 54
    //   40: aload_1
    //   41: getfield 252	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:pvP	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   44: astore_1
    //   45: ldc 248
    //   47: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: areturn
    //   54: getstatic 257	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:pwO	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   57: astore_1
    //   58: ldc 248
    //   60: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: goto -13 -> 50
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	i
    //   0	71	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	13	66	finally
    //   17	27	66	finally
    //   31	50	66	finally
    //   54	63	66	finally
  }
  
  public final boolean aiT(String paramString)
  {
    long l1 = 0L;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(228055);
        paramString = bF(paramString);
        if (paramString != null)
        {
          f localf = (f)paramString.first();
          if ((localf != null) && (localf.nHt >= 0L))
          {
            long l2 = localf.nHt;
            paramString = paramString.iterator();
            if (paramString.hasNext())
            {
              localf = (f)paramString.next();
              if (!localf.bpU)
              {
                AppMethodBeat.o(228055);
                bool = false;
                return bool;
              }
              l1 += localf.aFL;
              continue;
            }
            if (l1 >= l2)
            {
              bool = true;
              AppMethodBeat.o(228055);
              continue;
            }
          }
        }
        AppMethodBeat.o(228055);
      }
      finally {}
      boolean bool = false;
    }
  }
  
  /* Error */
  public final long aiU(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 263
    //   7: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 235	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:bF	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   15: astore_1
    //   16: lload_2
    //   17: lstore 4
    //   19: aload_1
    //   20: ifnull +138 -> 158
    //   23: aload_1
    //   24: invokeinterface 240 1 0
    //   29: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   32: astore 6
    //   34: aload 6
    //   36: ifnull +43 -> 79
    //   39: aload 6
    //   41: getfield 121	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:bpU	Z
    //   44: ifeq +35 -> 79
    //   47: aload 6
    //   49: getfield 243	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:nHt	J
    //   52: lconst_0
    //   53: lcmp
    //   54: iflt +25 -> 79
    //   57: aload 6
    //   59: getfield 140	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:position	J
    //   62: lconst_0
    //   63: lcmp
    //   64: ifeq +15 -> 79
    //   67: ldc_w 263
    //   70: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: lconst_0
    //   74: lstore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: lload_2
    //   78: lreturn
    //   79: lload_2
    //   80: lstore 4
    //   82: aload 6
    //   84: ifnull +74 -> 158
    //   87: lload_2
    //   88: lstore 4
    //   90: aload 6
    //   92: getfield 243	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:nHt	J
    //   95: lconst_0
    //   96: lcmp
    //   97: iflt +61 -> 158
    //   100: aload_1
    //   101: invokeinterface 261 1 0
    //   106: astore_1
    //   107: lload_2
    //   108: lstore 4
    //   110: aload_1
    //   111: invokeinterface 94 1 0
    //   116: ifeq +42 -> 158
    //   119: aload_1
    //   120: invokeinterface 98 1 0
    //   125: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   128: astore 6
    //   130: aload 6
    //   132: getfield 121	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:bpU	Z
    //   135: ifne +12 -> 147
    //   138: ldc_w 263
    //   141: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: goto -69 -> 75
    //   147: lload_2
    //   148: aload 6
    //   150: getfield 126	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:aFL	J
    //   153: ladd
    //   154: lstore_2
    //   155: goto -48 -> 107
    //   158: lload 4
    //   160: lstore_2
    //   161: ldc_w 263
    //   164: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: goto -92 -> 75
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	i
    //   0	175	1	paramString	String
    //   1	160	2	l1	long
    //   17	142	4	l2	long
    //   32	117	6	localf	f
    // Exception table:
    //   from	to	target	type
    //   4	16	170	finally
    //   23	34	170	finally
    //   39	73	170	finally
    //   90	107	170	finally
    //   110	144	170	finally
    //   147	155	170	finally
    //   161	167	170	finally
  }
  
  public final void b(f paramf)
  {
    try
    {
      AppMethodBeat.i(228036);
      TreeSet localTreeSet = (TreeSet)this.pwf.get(paramf.key);
      this.bqr -= paramf.aFL;
      paramf.file.cFq();
      if ((localTreeSet == null) || (localTreeSet.isEmpty())) {
        this.pwf.remove(paramf.key);
      }
      g(paramf);
      AppMethodBeat.o(228036);
      return;
    }
    finally {}
  }
  
  final boolean f(f paramf)
  {
    AppMethodBeat.i(228034);
    TreeSet localTreeSet2 = (TreeSet)this.pwf.get(paramf.key);
    TreeSet localTreeSet1 = localTreeSet2;
    if (localTreeSet2 == null)
    {
      localTreeSet1 = new TreeSet();
      this.pwf.put(paramf.key, localTreeSet1);
    }
    boolean bool = localTreeSet1.add(paramf);
    this.bqr += paramf.aFL;
    h(paramf);
    AppMethodBeat.o(228034);
    return bool;
  }
  
  public final long uP()
  {
    try
    {
      long l = this.bqr;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void z(q paramq)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(228030);
        f localf = f.A(paramq);
        boolean bool;
        if (localf != null)
        {
          bool = true;
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(bool);
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(this.bqp.containsKey(localf.key));
          if (!paramq.ifE()) {
            AppMethodBeat.o(228030);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        if (paramq.length() == 0L)
        {
          paramq.cFq();
          AppMethodBeat.o(228030);
          continue;
        }
        f(localf);
      }
      finally {}
      notifyAll();
      AppMethodBeat.o(228030);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.i
 * JD-Core Version:    0.7.0.1
 */