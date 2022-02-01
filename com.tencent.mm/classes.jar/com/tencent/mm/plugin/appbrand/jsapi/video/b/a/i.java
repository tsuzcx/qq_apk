package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.os.ConditionVariable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.vfs.e;
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
  private final HashMap<String, f> bys;
  private final HashMap<String, ArrayList<a.a>> byu;
  private long byv;
  final e koK;
  private final d koL;
  private final HashMap<String, TreeSet<f>> koM;
  
  public i(final e parame, d paramd)
  {
    AppMethodBeat.i(193841);
    this.koK = parame;
    this.koL = paramd;
    this.bys = new HashMap();
    this.koM = new HashMap();
    this.byu = new HashMap();
    parame = new ConditionVariable();
    new Thread()
    {
      public final void run()
      {
        AppMethodBeat.i(193840);
        for (;;)
        {
          int i;
          f localf;
          synchronized (i.this)
          {
            parame.open();
            i locali2 = i.this;
            if (!locali2.koK.exists()) {
              locali2.koK.mkdirs();
            }
            e[] arrayOfe = locali2.koK.fhW();
            if (arrayOfe == null) {
              break label165;
            }
            i = 0;
            if (i >= arrayOfe.length) {
              break label165;
            }
            e locale = arrayOfe[i];
            if (locale.length() == 0L)
            {
              locale.delete();
            }
            else
            {
              localf = f.D(locale);
              if (localf == null) {
                locale.delete();
              }
            }
          }
          if (!localObject.f(localf))
          {
            h.log(3, "SimpleCache", "remove duplicated span " + localf.kot);
            localObject.b(localf);
            break label173;
            label165:
            AppMethodBeat.o(193840);
            return;
          }
          label173:
          i += 1;
        }
      }
    }.start();
    parame.block();
    AppMethodBeat.o(193841);
  }
  
  /* Error */
  private NavigableSet<f> aG(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 44	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:koM	Ljava/util/HashMap;
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
  
  private void bcX()
  {
    AppMethodBeat.i(193851);
    Iterator localIterator1 = this.koM.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((TreeSet)((Map.Entry)localIterator1.next()).getValue()).iterator();
      int i = 1;
      while (localIterator2.hasNext())
      {
        f localf = (f)localIterator2.next();
        if (!localf.kot.exists())
        {
          localIterator2.remove();
          if (localf.byc) {
            this.byv -= localf.length;
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
    AppMethodBeat.o(193851);
  }
  
  private f e(f paramf)
  {
    for (;;)
    {
      String str;
      f localf;
      try
      {
        AppMethodBeat.i(193845);
        str = paramf.key;
        long l = paramf.position;
        TreeSet localTreeSet = (TreeSet)this.koM.get(str);
        if (localTreeSet == null)
        {
          localf = f.L(str, paramf.position);
          if (!localf.byc) {
            break label188;
          }
          AppMethodBeat.o(193845);
          return localf;
        }
        localf = (f)localTreeSet.floor(paramf);
        if ((localf != null) && (localf.position <= l) && (l < localf.position + localf.length))
        {
          if (localf.kot.exists()) {
            continue;
          }
          bcX();
          continue;
        }
        localf = (f)localTreeSet.ceiling(paramf);
      }
      finally {}
      if (localf == null)
      {
        localf = f.L(str, paramf.position);
      }
      else
      {
        localf = f.s(str, paramf.position, localf.position - paramf.position);
        continue;
        label188:
        if (!this.bys.containsKey(paramf.key))
        {
          this.bys.put(paramf.key, localf);
          AppMethodBeat.o(193845);
        }
        else
        {
          localf = null;
          AppMethodBeat.o(193845);
        }
      }
    }
  }
  
  private void g(f paramf)
  {
    AppMethodBeat.i(193852);
    ArrayList localArrayList = (ArrayList)this.byu.get(paramf.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.a)localArrayList.get(i)).c(paramf);
        i -= 1;
      }
    }
    this.koL.c(paramf);
    AppMethodBeat.o(193852);
  }
  
  private void h(f paramf)
  {
    AppMethodBeat.i(193853);
    ArrayList localArrayList = (ArrayList)this.byu.get(paramf.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.a)localArrayList.get(i)).a(this, paramf);
        i -= 1;
      }
    }
    this.koL.a(this, paramf);
    AppMethodBeat.o(193853);
  }
  
  public final void C(e parame)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(193847);
        f localf = f.D(parame);
        boolean bool;
        if (localf != null)
        {
          bool = true;
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(bool);
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(this.bys.containsKey(localf.key));
          if (!parame.exists()) {
            AppMethodBeat.o(193847);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        if (parame.length() == 0L)
        {
          parame.delete();
          AppMethodBeat.o(193847);
          continue;
        }
        f(localf);
      }
      finally {}
      notifyAll();
      AppMethodBeat.o(193847);
    }
  }
  
  /* Error */
  public final f I(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 217
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: lload_2
    //   9: invokestatic 220	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:K	(Ljava/lang/String;J)Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/f;
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
  
  public final f J(String paramString, long paramLong)
  {
    try
    {
      AppMethodBeat.i(193844);
      paramString = e(f.K(paramString, paramLong));
      AppMethodBeat.o(193844);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final long Jh(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 229
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 231	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:aG	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +40 -> 54
    //   17: aload_1
    //   18: invokeinterface 236 1 0
    //   23: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +26 -> 54
    //   31: aload_1
    //   32: getfield 239	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:iOo	J
    //   35: lconst_0
    //   36: lcmp
    //   37: iflt +17 -> 54
    //   40: aload_1
    //   41: getfield 239	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:iOo	J
    //   44: lstore_2
    //   45: ldc 229
    //   47: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: lload_2
    //   53: lreturn
    //   54: ldc2_w 240
    //   57: lstore_2
    //   58: ldc 229
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
  public final c Ji(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 244
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 231	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:aG	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +40 -> 54
    //   17: aload_1
    //   18: invokeinterface 236 1 0
    //   23: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +26 -> 54
    //   31: aload_1
    //   32: getfield 239	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:iOo	J
    //   35: lconst_0
    //   36: lcmp
    //   37: iflt +17 -> 54
    //   40: aload_1
    //   41: getfield 248	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:kow	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   44: astore_1
    //   45: ldc 244
    //   47: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: areturn
    //   54: getstatic 253	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:kpv	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   57: astore_1
    //   58: ldc 244
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
  public final long Jj(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 255
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 231	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:aG	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   14: astore_1
    //   15: lload_2
    //   16: lstore 4
    //   18: aload_1
    //   19: ifnull +136 -> 155
    //   22: aload_1
    //   23: invokeinterface 236 1 0
    //   28: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   31: astore 6
    //   33: aload 6
    //   35: ifnull +42 -> 77
    //   38: aload 6
    //   40: getfield 121	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:byc	Z
    //   43: ifeq +34 -> 77
    //   46: aload 6
    //   48: getfield 239	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:iOo	J
    //   51: lconst_0
    //   52: lcmp
    //   53: iflt +24 -> 77
    //   56: aload 6
    //   58: getfield 140	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:position	J
    //   61: lconst_0
    //   62: lcmp
    //   63: ifeq +14 -> 77
    //   66: ldc 255
    //   68: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: lconst_0
    //   72: lstore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: lload_2
    //   76: lreturn
    //   77: lload_2
    //   78: lstore 4
    //   80: aload 6
    //   82: ifnull +73 -> 155
    //   85: lload_2
    //   86: lstore 4
    //   88: aload 6
    //   90: getfield 239	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:iOo	J
    //   93: lconst_0
    //   94: lcmp
    //   95: iflt +60 -> 155
    //   98: aload_1
    //   99: invokeinterface 256 1 0
    //   104: astore_1
    //   105: lload_2
    //   106: lstore 4
    //   108: aload_1
    //   109: invokeinterface 94 1 0
    //   114: ifeq +41 -> 155
    //   117: aload_1
    //   118: invokeinterface 98 1 0
    //   123: checkcast 106	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f
    //   126: astore 6
    //   128: aload 6
    //   130: getfield 121	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:byc	Z
    //   133: ifne +11 -> 144
    //   136: ldc 255
    //   138: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: goto -68 -> 73
    //   144: lload_2
    //   145: aload 6
    //   147: getfield 126	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:length	J
    //   150: ladd
    //   151: lstore_2
    //   152: goto -47 -> 105
    //   155: lload 4
    //   157: lstore_2
    //   158: ldc 255
    //   160: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: goto -90 -> 73
    //   166: astore_1
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	i
    //   0	171	1	paramString	String
    //   1	157	2	l1	long
    //   16	140	4	l2	long
    //   31	115	6	localf	f
    // Exception table:
    //   from	to	target	type
    //   4	15	166	finally
    //   22	33	166	finally
    //   38	71	166	finally
    //   88	105	166	finally
    //   108	141	166	finally
    //   144	152	166	finally
    //   158	163	166	finally
  }
  
  public final e a(String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    try
    {
      AppMethodBeat.i(193846);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a.checkState(this.bys.containsKey(paramString));
      if (!this.koK.exists())
      {
        bcX();
        this.koK.mkdirs();
      }
      this.koL.a(this, paramLong3);
      paramString = f.a(this.koK, paramString, paramLong1, paramLong2, paramc, System.currentTimeMillis());
      AppMethodBeat.o(193846);
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
    //   2: ldc_w 273
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 42	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/i:bys	Ljava/util/HashMap;
    //   13: aload_1
    //   14: getfield 137	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/f:key	Ljava/lang/String;
    //   17: invokevirtual 275	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: if_acmpne +22 -> 42
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: invokestatic 202	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/a:checkState	(Z)V
    //   29: aload_0
    //   30: invokevirtual 215	java/lang/Object:notifyAll	()V
    //   33: ldc_w 273
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
      AppMethodBeat.i(193850);
      TreeSet localTreeSet = (TreeSet)this.koM.get(paramf.key);
      this.byv -= paramf.length;
      paramf.kot.delete();
      if ((localTreeSet == null) || (localTreeSet.isEmpty())) {
        this.koM.remove(paramf.key);
      }
      g(paramf);
      AppMethodBeat.o(193850);
      return;
    }
    finally {}
  }
  
  final boolean f(f paramf)
  {
    AppMethodBeat.i(193849);
    TreeSet localTreeSet2 = (TreeSet)this.koM.get(paramf.key);
    TreeSet localTreeSet1 = localTreeSet2;
    if (localTreeSet2 == null)
    {
      localTreeSet1 = new TreeSet();
      this.koM.put(paramf.key, localTreeSet1);
    }
    boolean bool = localTreeSet1.add(paramf);
    this.byv += paramf.length;
    h(paramf);
    AppMethodBeat.o(193849);
    return bool;
  }
  
  public final boolean isCached(String paramString)
  {
    long l1 = 0L;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(193856);
        paramString = aG(paramString);
        if (paramString != null)
        {
          f localf = (f)paramString.first();
          if ((localf != null) && (localf.iOo >= 0L))
          {
            long l2 = localf.iOo;
            paramString = paramString.iterator();
            if (paramString.hasNext())
            {
              localf = (f)paramString.next();
              if (!localf.byc)
              {
                AppMethodBeat.o(193856);
                bool = false;
                return bool;
              }
              l1 += localf.length;
              continue;
            }
            if (l1 >= l2)
            {
              bool = true;
              AppMethodBeat.o(193856);
              continue;
            }
          }
        }
        AppMethodBeat.o(193856);
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public final long vr()
  {
    try
    {
      long l = this.byv;
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