package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.os.ConditionVariable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.u;
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
  private final HashMap<String, f> djT;
  private final HashMap<String, ArrayList<a.a>> djU;
  private long djV;
  final u sBj;
  private final d sBk;
  private final HashMap<String, TreeSet<f>> sBl;
  
  public i(final u paramu, d paramd)
  {
    AppMethodBeat.i(328314);
    this.sBj = paramu;
    this.sBk = paramd;
    this.djT = new HashMap();
    this.sBl = new HashMap();
    this.djU = new HashMap();
    paramu = new ConditionVariable();
    new Thread()
    {
      public final void run()
      {
        AppMethodBeat.i(328286);
        for (;;)
        {
          int i;
          f localf;
          synchronized (i.this)
          {
            paramu.open();
            i locali2 = i.this;
            if (!locali2.sBj.jKS()) {
              locali2.sBj.jKY();
            }
            u[] arrayOfu = locali2.sBj.jKX();
            if (arrayOfu == null) {
              break label165;
            }
            i = 0;
            if (i >= arrayOfu.length) {
              break label165;
            }
            u localu = arrayOfu[i];
            if (localu.length() == 0L)
            {
              localu.diJ();
            }
            else
            {
              localf = f.A(localu);
              if (localf == null) {
                localu.diJ();
              }
            }
          }
          if (!localObject.f(localf))
          {
            h.log(3, "SimpleCache", "remove duplicated span " + localf.file);
            localObject.b(localf);
            break label173;
            label165:
            AppMethodBeat.o(328286);
            return;
          }
          label173:
          i += 1;
        }
      }
    }.start();
    paramu.block();
    AppMethodBeat.o(328314);
  }
  
  /* Error */
  private NavigableSet<f> cX(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 44	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:sBl	Ljava/util/HashMap;
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
  
  private void cvN()
  {
    AppMethodBeat.i(328345);
    Iterator localIterator1 = this.sBl.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((TreeSet)((Map.Entry)localIterator1.next()).getValue()).iterator();
      int i = 1;
      while (localIterator2.hasNext())
      {
        f localf = (f)localIterator2.next();
        if (!localf.file.jKS())
        {
          localIterator2.remove();
          if (localf.djy) {
            this.djV -= localf.length;
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
    AppMethodBeat.o(328345);
  }
  
  private f e(f paramf)
  {
    for (;;)
    {
      String str;
      f localf;
      try
      {
        AppMethodBeat.i(328332);
        str = paramf.key;
        long l = paramf.position;
        TreeSet localTreeSet = (TreeSet)this.sBl.get(str);
        if (localTreeSet == null)
        {
          localf = f.Y(str, paramf.position);
          if (!localf.djy) {
            break label188;
          }
          AppMethodBeat.o(328332);
          return localf;
        }
        localf = (f)localTreeSet.floor(paramf);
        if ((localf != null) && (localf.position <= l) && (l < localf.position + localf.length))
        {
          if (localf.file.jKS()) {
            continue;
          }
          cvN();
          continue;
        }
        localf = (f)localTreeSet.ceiling(paramf);
      }
      finally {}
      if (localf == null)
      {
        localf = f.Y(str, paramf.position);
      }
      else
      {
        localf = f.r(str, paramf.position, localf.position - paramf.position);
        continue;
        label188:
        if (!this.djT.containsKey(paramf.key))
        {
          this.djT.put(paramf.key, localf);
          AppMethodBeat.o(328332);
        }
        else
        {
          localf = null;
          AppMethodBeat.o(328332);
        }
      }
    }
  }
  
  private void g(f paramf)
  {
    AppMethodBeat.i(328354);
    ArrayList localArrayList = (ArrayList)this.djU.get(paramf.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.a)localArrayList.get(i)).c(paramf);
        i -= 1;
      }
    }
    this.sBk.c(paramf);
    AppMethodBeat.o(328354);
  }
  
  private void h(f paramf)
  {
    AppMethodBeat.i(328362);
    ArrayList localArrayList = (ArrayList)this.djU.get(paramf.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.a)localArrayList.get(i)).a(this, paramf);
        i -= 1;
      }
    }
    this.sBk.a(this, paramf);
    AppMethodBeat.o(328362);
  }
  
  public final long Uo()
  {
    try
    {
      long l = this.djV;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final f V(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 193
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: lload_2
    //   9: invokestatic 196	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:X	(Ljava/lang/String;J)Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/f;
    //   12: astore_1
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 198	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:e	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/f;)Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/f;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +13 -> 35
    //   25: ldc 193
    //   27: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 201	java/lang/Object:wait	()V
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
  
  public final f W(String paramString, long paramLong)
  {
    try
    {
      AppMethodBeat.i(328383);
      paramString = e(f.X(paramString, paramLong));
      AppMethodBeat.o(328383);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final u a(String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    try
    {
      AppMethodBeat.i(328392);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(this.djT.containsKey(paramString));
      if (!this.sBj.jKS())
      {
        cvN();
        this.sBj.jKY();
      }
      this.sBk.a(this, paramLong3);
      paramString = f.a(this.sBj, paramString, paramLong1, paramLong2, paramc, System.currentTimeMillis());
      AppMethodBeat.o(328392);
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
    //   2: ldc 226
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 42	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:djT	Ljava/util/HashMap;
    //   12: aload_1
    //   13: getfield 137	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:key	Ljava/lang/String;
    //   16: invokevirtual 228	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: if_acmpne +21 -> 40
    //   22: iconst_1
    //   23: istore_2
    //   24: iload_2
    //   25: invokestatic 211	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/a:checkState	(Z)V
    //   28: aload_0
    //   29: invokevirtual 231	java/lang/Object:notifyAll	()V
    //   32: ldc 226
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
  public final long abQ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 234
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 236	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:cX	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +40 -> 54
    //   17: aload_1
    //   18: invokeinterface 241 1 0
    //   23: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +26 -> 54
    //   31: aload_1
    //   32: getfield 244	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:qHg	J
    //   35: lconst_0
    //   36: lcmp
    //   37: iflt +17 -> 54
    //   40: aload_1
    //   41: getfield 244	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:qHg	J
    //   44: lstore_2
    //   45: ldc 234
    //   47: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: lload_2
    //   53: lreturn
    //   54: ldc2_w 245
    //   57: lstore_2
    //   58: ldc 234
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
  public final c abR(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 249
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 236	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:cX	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +40 -> 54
    //   17: aload_1
    //   18: invokeinterface 241 1 0
    //   23: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +26 -> 54
    //   31: aload_1
    //   32: getfield 244	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:qHg	J
    //   35: lconst_0
    //   36: lcmp
    //   37: iflt +17 -> 54
    //   40: aload_1
    //   41: getfield 253	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:sAV	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   44: astore_1
    //   45: ldc 249
    //   47: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: areturn
    //   54: getstatic 258	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:sBU	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   57: astore_1
    //   58: ldc 249
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
  
  public final boolean abS(String paramString)
  {
    long l1 = 0L;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(328482);
        paramString = cX(paramString);
        if (paramString != null)
        {
          f localf = (f)paramString.first();
          if ((localf != null) && (localf.qHg >= 0L))
          {
            long l2 = localf.qHg;
            paramString = paramString.iterator();
            if (paramString.hasNext())
            {
              localf = (f)paramString.next();
              if (!localf.djy)
              {
                AppMethodBeat.o(328482);
                bool = false;
                return bool;
              }
              l1 += localf.length;
              continue;
            }
            if (l1 >= l2)
            {
              bool = true;
              AppMethodBeat.o(328482);
              continue;
            }
          }
        }
        AppMethodBeat.o(328482);
      }
      finally {}
      boolean bool = false;
    }
  }
  
  /* Error */
  public final long abT(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 264
    //   7: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 236	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:cX	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   15: astore_1
    //   16: lload_2
    //   17: lstore 4
    //   19: aload_1
    //   20: ifnull +138 -> 158
    //   23: aload_1
    //   24: invokeinterface 241 1 0
    //   29: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   32: astore 6
    //   34: aload 6
    //   36: ifnull +43 -> 79
    //   39: aload 6
    //   41: getfield 121	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:djy	Z
    //   44: ifeq +35 -> 79
    //   47: aload 6
    //   49: getfield 244	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:qHg	J
    //   52: lconst_0
    //   53: lcmp
    //   54: iflt +25 -> 79
    //   57: aload 6
    //   59: getfield 140	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:position	J
    //   62: lconst_0
    //   63: lcmp
    //   64: ifeq +15 -> 79
    //   67: ldc_w 264
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
    //   92: getfield 244	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:qHg	J
    //   95: lconst_0
    //   96: lcmp
    //   97: iflt +61 -> 158
    //   100: aload_1
    //   101: invokeinterface 262 1 0
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
    //   132: getfield 121	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:djy	Z
    //   135: ifne +12 -> 147
    //   138: ldc_w 264
    //   141: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: goto -69 -> 75
    //   147: lload_2
    //   148: aload 6
    //   150: getfield 126	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:length	J
    //   153: ladd
    //   154: lstore_2
    //   155: goto -48 -> 107
    //   158: lload 4
    //   160: lstore_2
    //   161: ldc_w 264
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
      AppMethodBeat.i(328428);
      TreeSet localTreeSet = (TreeSet)this.sBl.get(paramf.key);
      this.djV -= paramf.length;
      paramf.file.diJ();
      if ((localTreeSet == null) || (localTreeSet.isEmpty())) {
        this.sBl.remove(paramf.key);
      }
      g(paramf);
      AppMethodBeat.o(328428);
      return;
    }
    finally {}
  }
  
  final boolean f(f paramf)
  {
    AppMethodBeat.i(328419);
    TreeSet localTreeSet2 = (TreeSet)this.sBl.get(paramf.key);
    TreeSet localTreeSet1 = localTreeSet2;
    if (localTreeSet2 == null)
    {
      localTreeSet1 = new TreeSet();
      this.sBl.put(paramf.key, localTreeSet1);
    }
    boolean bool = localTreeSet1.add(paramf);
    this.djV += paramf.length;
    h(paramf);
    AppMethodBeat.o(328419);
    return bool;
  }
  
  public final void z(u paramu)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(328398);
        f localf = f.A(paramu);
        boolean bool;
        if (localf != null)
        {
          bool = true;
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(bool);
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(this.djT.containsKey(localf.key));
          if (!paramu.jKS()) {
            AppMethodBeat.o(328398);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        if (paramu.length() == 0L)
        {
          paramu.diJ();
          AppMethodBeat.o(328398);
          continue;
        }
        f(localf);
      }
      finally {}
      notifyAll();
      AppMethodBeat.o(328398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.i
 * JD-Core Version:    0.7.0.1
 */