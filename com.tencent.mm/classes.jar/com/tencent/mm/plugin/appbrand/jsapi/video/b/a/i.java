package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.os.ConditionVariable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.k;
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
  private final HashMap<String, f> bGo;
  private final HashMap<String, ArrayList<a.a>> bGq;
  private long bGr;
  final k lrd;
  private final d lre;
  private final HashMap<String, TreeSet<f>> lrf;
  
  public i(final k paramk, d paramd)
  {
    AppMethodBeat.i(211027);
    this.lrd = paramk;
    this.lre = paramd;
    this.bGo = new HashMap();
    this.lrf = new HashMap();
    this.bGq = new HashMap();
    paramk = new ConditionVariable();
    new Thread()
    {
      public final void run()
      {
        AppMethodBeat.i(211026);
        for (;;)
        {
          int i;
          f localf;
          synchronized (i.this)
          {
            paramk.open();
            i locali2 = i.this;
            if (!locali2.lrd.exists()) {
              locali2.lrd.mkdirs();
            }
            k[] arrayOfk = locali2.lrd.fTj();
            if (arrayOfk == null) {
              break label165;
            }
            i = 0;
            if (i >= arrayOfk.length) {
              break label165;
            }
            k localk = arrayOfk[i];
            if (localk.length() == 0L)
            {
              localk.delete();
            }
            else
            {
              localf = f.C(localk);
              if (localf == null) {
                localk.delete();
              }
            }
          }
          if (!localObject.f(localf))
          {
            h.log(3, "SimpleCache", "remove duplicated span " + localf.aXd);
            localObject.b(localf);
            break label173;
            label165:
            AppMethodBeat.o(211026);
            return;
          }
          label173:
          i += 1;
        }
      }
    }.start();
    paramk.block();
    AppMethodBeat.o(211027);
  }
  
  private void bon()
  {
    AppMethodBeat.i(211037);
    Iterator localIterator1 = this.lrf.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((TreeSet)((Map.Entry)localIterator1.next()).getValue()).iterator();
      int i = 1;
      while (localIterator2.hasNext())
      {
        f localf = (f)localIterator2.next();
        if (!localf.aXd.exists())
        {
          localIterator2.remove();
          if (localf.bFZ) {
            this.bGr -= localf.length;
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
    AppMethodBeat.o(211037);
  }
  
  /* Error */
  private NavigableSet<f> bu(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 121
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 44	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:lrf	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 91	java/util/TreeSet
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +14 -> 34
    //   23: aconst_null
    //   24: astore_1
    //   25: ldc 121
    //   27: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: new 91	java/util/TreeSet
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 128	java/util/TreeSet:<init>	(Ljava/util/SortedSet;)V
    //   42: astore_1
    //   43: ldc 121
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
  
  private f e(f paramf)
  {
    for (;;)
    {
      String str;
      f localf;
      try
      {
        AppMethodBeat.i(211031);
        str = paramf.key;
        long l = paramf.position;
        TreeSet localTreeSet = (TreeSet)this.lrf.get(str);
        if (localTreeSet == null)
        {
          localf = f.T(str, paramf.position);
          if (!localf.bFZ) {
            break label188;
          }
          AppMethodBeat.o(211031);
          return localf;
        }
        localf = (f)localTreeSet.floor(paramf);
        if ((localf != null) && (localf.position <= l) && (l < localf.position + localf.length))
        {
          if (localf.aXd.exists()) {
            continue;
          }
          bon();
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
        if (!this.bGo.containsKey(paramf.key))
        {
          this.bGo.put(paramf.key, localf);
          AppMethodBeat.o(211031);
        }
        else
        {
          localf = null;
          AppMethodBeat.o(211031);
        }
      }
    }
  }
  
  private void g(f paramf)
  {
    AppMethodBeat.i(211038);
    ArrayList localArrayList = (ArrayList)this.bGq.get(paramf.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.a)localArrayList.get(i)).c(paramf);
        i -= 1;
      }
    }
    this.lre.c(paramf);
    AppMethodBeat.o(211038);
  }
  
  private void h(f paramf)
  {
    AppMethodBeat.i(211039);
    ArrayList localArrayList = (ArrayList)this.bGq.get(paramf.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.a)localArrayList.get(i)).a(this, paramf);
        i -= 1;
      }
    }
    this.lre.a(this, paramf);
    AppMethodBeat.o(211039);
  }
  
  public final void B(k paramk)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(211033);
        f localf = f.C(paramk);
        boolean bool;
        if (localf != null)
        {
          bool = true;
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(bool);
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(this.bGo.containsKey(localf.key));
          if (!paramk.exists()) {
            AppMethodBeat.o(211033);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        if (paramk.length() == 0L)
        {
          paramk.delete();
          AppMethodBeat.o(211033);
          continue;
        }
        f(localf);
      }
      finally {}
      notifyAll();
      AppMethodBeat.o(211033);
    }
  }
  
  /* Error */
  public final f Q(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 217
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: lload_2
    //   9: invokestatic 220	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:S	(Ljava/lang/String;J)Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/f;
    //   12: astore_1
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 222	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:e	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/f;)Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/f;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +13 -> 35
    //   25: ldc 217
    //   27: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 225	java/lang/Object:wait	()V
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
      AppMethodBeat.i(211030);
      paramString = e(f.S(paramString, paramLong));
      AppMethodBeat.o(211030);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final long Rr(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 230
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 232	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:bu	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +40 -> 54
    //   17: aload_1
    //   18: invokeinterface 237 1 0
    //   23: checkcast 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +26 -> 54
    //   31: aload_1
    //   32: getfield 240	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:jLu	J
    //   35: lconst_0
    //   36: lcmp
    //   37: iflt +17 -> 54
    //   40: aload_1
    //   41: getfield 240	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:jLu	J
    //   44: lstore_2
    //   45: ldc 230
    //   47: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: lload_2
    //   53: lreturn
    //   54: ldc2_w 241
    //   57: lstore_2
    //   58: ldc 230
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
  public final c Rs(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 245
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 232	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:bu	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +40 -> 54
    //   17: aload_1
    //   18: invokeinterface 237 1 0
    //   23: checkcast 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +26 -> 54
    //   31: aload_1
    //   32: getfield 240	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:jLu	J
    //   35: lconst_0
    //   36: lcmp
    //   37: iflt +17 -> 54
    //   40: aload_1
    //   41: getfield 249	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:lqP	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   44: astore_1
    //   45: ldc 245
    //   47: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: areturn
    //   54: getstatic 254	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:lrO	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   57: astore_1
    //   58: ldc 245
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
  
  /* Error */
  public final long Rt(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 256
    //   7: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 232	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:bu	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   15: astore_1
    //   16: lload_2
    //   17: lstore 4
    //   19: aload_1
    //   20: ifnull +138 -> 158
    //   23: aload_1
    //   24: invokeinterface 237 1 0
    //   29: checkcast 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   32: astore 6
    //   34: aload 6
    //   36: ifnull +43 -> 79
    //   39: aload 6
    //   41: getfield 109	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:bFZ	Z
    //   44: ifeq +35 -> 79
    //   47: aload 6
    //   49: getfield 240	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:jLu	J
    //   52: lconst_0
    //   53: lcmp
    //   54: iflt +25 -> 79
    //   57: aload 6
    //   59: getfield 140	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:position	J
    //   62: lconst_0
    //   63: lcmp
    //   64: ifeq +15 -> 79
    //   67: ldc_w 256
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
    //   92: getfield 240	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:jLu	J
    //   95: lconst_0
    //   96: lcmp
    //   97: iflt +61 -> 158
    //   100: aload_1
    //   101: invokeinterface 257 1 0
    //   106: astore_1
    //   107: lload_2
    //   108: lstore 4
    //   110: aload_1
    //   111: invokeinterface 80 1 0
    //   116: ifeq +42 -> 158
    //   119: aload_1
    //   120: invokeinterface 84 1 0
    //   125: checkcast 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   128: astore 6
    //   130: aload 6
    //   132: getfield 109	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:bFZ	Z
    //   135: ifne +12 -> 147
    //   138: ldc_w 256
    //   141: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: goto -69 -> 75
    //   147: lload_2
    //   148: aload 6
    //   150: getfield 114	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:length	J
    //   153: ladd
    //   154: lstore_2
    //   155: goto -48 -> 107
    //   158: lload 4
    //   160: lstore_2
    //   161: ldc_w 256
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
  
  public final k a(String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    try
    {
      AppMethodBeat.i(211032);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(this.bGo.containsKey(paramString));
      if (!this.lrd.exists())
      {
        bon();
        this.lrd.mkdirs();
      }
      this.lre.a(this, paramLong3);
      paramString = f.a(this.lrd, paramString, paramLong1, paramLong2, paramc, System.currentTimeMillis());
      AppMethodBeat.o(211032);
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
    //   2: ldc_w 274
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 42	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:bGo	Ljava/util/HashMap;
    //   13: aload_1
    //   14: getfield 137	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:key	Ljava/lang/String;
    //   17: invokevirtual 276	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: if_acmpne +22 -> 42
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: invokestatic 202	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/a:checkState	(Z)V
    //   29: aload_0
    //   30: invokevirtual 215	java/lang/Object:notifyAll	()V
    //   33: ldc_w 274
    //   36: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -19 -> 25
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	i
    //   0	52	1	paramf	f
    //   24	20	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	47	finally
    //   25	39	47	finally
  }
  
  public final void b(f paramf)
  {
    try
    {
      AppMethodBeat.i(211036);
      TreeSet localTreeSet = (TreeSet)this.lrf.get(paramf.key);
      this.bGr -= paramf.length;
      paramf.aXd.delete();
      if ((localTreeSet == null) || (localTreeSet.isEmpty())) {
        this.lrf.remove(paramf.key);
      }
      g(paramf);
      AppMethodBeat.o(211036);
      return;
    }
    finally {}
  }
  
  final boolean f(f paramf)
  {
    AppMethodBeat.i(211035);
    TreeSet localTreeSet2 = (TreeSet)this.lrf.get(paramf.key);
    TreeSet localTreeSet1 = localTreeSet2;
    if (localTreeSet2 == null)
    {
      localTreeSet1 = new TreeSet();
      this.lrf.put(paramf.key, localTreeSet1);
    }
    boolean bool = localTreeSet1.add(paramf);
    this.bGr += paramf.length;
    h(paramf);
    AppMethodBeat.o(211035);
    return bool;
  }
  
  public final boolean isCached(String paramString)
  {
    long l1 = 0L;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(211042);
        paramString = bu(paramString);
        if (paramString != null)
        {
          f localf = (f)paramString.first();
          if ((localf != null) && (localf.jLu >= 0L))
          {
            long l2 = localf.jLu;
            paramString = paramString.iterator();
            if (paramString.hasNext())
            {
              localf = (f)paramString.next();
              if (!localf.bFZ)
              {
                AppMethodBeat.o(211042);
                bool = false;
                return bool;
              }
              l1 += localf.length;
              continue;
            }
            if (l1 >= l2)
            {
              bool = true;
              AppMethodBeat.o(211042);
              continue;
            }
          }
        }
        AppMethodBeat.o(211042);
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public final long wF()
  {
    try
    {
      long l = this.bGr;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.i
 * JD-Core Version:    0.7.0.1
 */