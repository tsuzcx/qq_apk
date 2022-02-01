package com.google.android.exoplayer2.h.a;

import android.os.ConditionVariable;
import android.util.SparseArray;
import com.google.android.exoplayer2.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

public final class l
  implements a
{
  final File byq;
  private final f byr;
  private final HashMap<String, g> bys;
  final j byt;
  private final HashMap<String, ArrayList<a.b>> byu;
  private long byv;
  a.a byw;
  
  public l(File paramFile, f paramf)
  {
    this(paramFile, paramf, (byte)0);
  }
  
  private l(File paramFile, f paramf, byte paramByte)
  {
    this(paramFile, paramf, new j(paramFile));
    AppMethodBeat.i(93006);
    AppMethodBeat.o(93006);
  }
  
  private l(final File paramFile, f paramf, j paramj)
  {
    AppMethodBeat.i(93007);
    this.byv = 0L;
    this.byq = paramFile;
    this.byr = paramf;
    this.bys = new HashMap();
    this.byt = paramj;
    this.byu = new HashMap();
    paramFile = new ConditionVariable();
    new Thread("SimpleCache.initialize()")
    {
      public final void run()
      {
        AppMethodBeat.i(93005);
        for (;;)
        {
          l locall2;
          int i;
          synchronized (l.this)
          {
            paramFile.open();
            try
            {
              locall2 = l.this;
              if (!locall2.byq.exists())
              {
                locall2.byq.mkdirs();
                AppMethodBeat.o(93005);
                return;
              }
              Object localObject1 = locall2.byt;
              if (((j)localObject1).byn) {
                break label270;
              }
              bool = true;
              com.google.android.exoplayer2.i.a.checkState(bool);
              if (!((j)localObject1).vA())
              {
                localObject4 = ((j)localObject1).byj;
                ((b)localObject4).byC.delete();
                ((b)localObject4).byD.delete();
                ((j)localObject1).byh.clear();
                ((j)localObject1).byi.clear();
              }
              Object localObject4 = locall2.byq.listFiles();
              if (localObject4 == null) {
                continue;
              }
              int j = localObject4.length;
              i = 0;
              if (i < j)
              {
                File localFile = localObject4[i];
                if (localFile.getName().equals("cached_content_index.exi")) {
                  break label263;
                }
                if (localFile.length() <= 0L) {
                  break label275;
                }
                localObject1 = m.a(localFile, locall2.byt);
                if (localObject1 != null) {
                  locall2.a((m)localObject1);
                } else {
                  localFile.delete();
                }
              }
            }
            catch (a.a locala)
            {
              l.this.byw = locala;
              continue;
            }
          }
          locall2.byt.vz();
          locall2.byt.vy();
          continue;
          label263:
          i += 1;
          continue;
          label270:
          boolean bool = false;
          continue;
          label275:
          Object localObject3 = null;
        }
      }
    }.start();
    paramFile.block();
    AppMethodBeat.o(93007);
  }
  
  private void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(93016);
    i locali = this.byt.aD(paramg.key);
    if (locali != null)
    {
      if (!locali.byg.remove(paramg)) {
        break label55;
      }
      paramg.file.delete();
    }
    label55:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(93016);
      return;
    }
    this.byv -= paramg.length;
    if (paramBoolean) {}
    try
    {
      if (locali.byg.isEmpty())
      {
        this.byt.aF(locali.key);
        this.byt.vy();
      }
      return;
    }
    finally
    {
      e(paramg);
      AppMethodBeat.o(93016);
    }
  }
  
  private void a(m paramm, g paramg)
  {
    AppMethodBeat.i(93021);
    ArrayList localArrayList = (ArrayList)this.byu.get(paramm.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).a(this, paramm, paramg);
        i -= 1;
      }
    }
    this.byr.a(this, paramm, paramg);
    AppMethodBeat.o(93021);
  }
  
  /* Error */
  private NavigableSet<g> aG(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 161
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 64	com/google/android/exoplayer2/h/a/l:byt	Lcom/google/android/exoplayer2/h/a/j;
    //   11: aload_1
    //   12: invokevirtual 93	com/google/android/exoplayer2/h/a/j:aD	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/i;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +13 -> 30
    //   20: aload_1
    //   21: getfield 99	com/google/android/exoplayer2/h/a/i:byg	Ljava/util/TreeSet;
    //   24: invokevirtual 120	java/util/TreeSet:isEmpty	()Z
    //   27: ifeq +14 -> 41
    //   30: aconst_null
    //   31: astore_1
    //   32: ldc 161
    //   34: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: new 101	java/util/TreeSet
    //   44: dup
    //   45: aload_1
    //   46: getfield 99	com/google/android/exoplayer2/h/a/i:byg	Ljava/util/TreeSet;
    //   49: invokespecial 164	java/util/TreeSet:<init>	(Ljava/util/Collection;)V
    //   52: astore_1
    //   53: ldc 161
    //   55: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -21 -> 37
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	l
    //   0	66	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	16	61	finally
    //   20	30	61	finally
    //   32	37	61	finally
    //   41	58	61	finally
  }
  
  private void b(m paramm)
  {
    AppMethodBeat.i(93020);
    ArrayList localArrayList = (ArrayList)this.byu.get(paramm.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).a(this, paramm);
        i -= 1;
      }
    }
    this.byr.a(this, paramm);
    AppMethodBeat.o(93020);
  }
  
  private void e(g paramg)
  {
    AppMethodBeat.i(93019);
    ArrayList localArrayList = (ArrayList)this.byu.get(paramg.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).c(paramg);
        i -= 1;
      }
    }
    this.byr.c(paramg);
    AppMethodBeat.o(93019);
  }
  
  /* Error */
  private m h(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 181
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: lload_2
    //   10: invokespecial 183	com/google/android/exoplayer2/h/a/l:i	(Ljava/lang/String;J)Lcom/google/android/exoplayer2/h/a/m;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +13 -> 30
    //   20: ldc 181
    //   22: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: aload 4
    //   29: areturn
    //   30: aload_0
    //   31: invokevirtual 186	java/lang/Object:wait	()V
    //   34: goto -27 -> 7
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	l
    //   0	42	1	paramString	String
    //   0	42	2	paramLong	long
    //   13	15	4	localm	m
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   7	15	37	finally
    //   20	25	37	finally
    //   30	34	37	finally
  }
  
  private m i(String paramString, long paramLong)
  {
    try
    {
      AppMethodBeat.i(93011);
      if (this.byw != null)
      {
        paramString = this.byw;
        AppMethodBeat.o(93011);
        throw paramString;
      }
    }
    finally {}
    i locali = this.byt.aD(paramString);
    Object localObject1;
    Object localObject2;
    if (locali == null)
    {
      localObject1 = m.k(paramString, paramLong);
      if (!((m)localObject1).byc) {
        break label283;
      }
      localObject2 = this.byt.aD(paramString);
      com.google.android.exoplayer2.i.a.checkState(((i)localObject2).byg.remove(localObject1));
      int i = ((i)localObject2).id;
      com.google.android.exoplayer2.i.a.checkState(((m)localObject1).byc);
      paramLong = System.currentTimeMillis();
      paramString = m.a(((m)localObject1).file.getParentFile(), i, ((m)localObject1).position, paramLong);
      paramString = new m(((m)localObject1).key, ((m)localObject1).position, ((m)localObject1).length, paramLong, paramString);
      if (!((m)localObject1).file.renameTo(paramString.file))
      {
        paramString = new a.a("Renaming of " + ((m)localObject1).file + " to " + paramString.file + " failed.");
        AppMethodBeat.o(93011);
        throw paramString;
      }
    }
    else
    {
      for (;;)
      {
        localObject2 = locali.aq(paramLong);
        localObject1 = localObject2;
        if (!((m)localObject2).byc) {
          break;
        }
        localObject1 = localObject2;
        if (((m)localObject2).file.exists()) {
          break;
        }
        vB();
      }
    }
    ((i)localObject2).byg.add(paramString);
    a((m)localObject1, paramString);
    AppMethodBeat.o(93011);
    for (;;)
    {
      return paramString;
      label283:
      if (!this.bys.containsKey(paramString))
      {
        this.bys.put(paramString, localObject1);
        AppMethodBeat.o(93011);
        paramString = (String)localObject1;
      }
      else
      {
        paramString = null;
        AppMethodBeat.o(93011);
      }
    }
  }
  
  private void vB()
  {
    AppMethodBeat.i(93018);
    Object localObject = new LinkedList();
    Iterator localIterator1 = this.byt.byh.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((i)localIterator1.next()).byg.iterator();
      while (localIterator2.hasNext())
      {
        g localg = (g)localIterator2.next();
        if (!localg.file.exists()) {
          ((LinkedList)localObject).add(localg);
        }
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((g)((Iterator)localObject).next(), false);
    }
    this.byt.vz();
    this.byt.vy();
    AppMethodBeat.o(93018);
  }
  
  public final NavigableSet<g> a(String paramString, a.b paramb)
  {
    try
    {
      AppMethodBeat.i(93008);
      ArrayList localArrayList2 = (ArrayList)this.byu.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.byu.put(paramString, localArrayList1);
      }
      localArrayList1.add(paramb);
      paramString = aG(paramString);
      AppMethodBeat.o(93008);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public final void a(g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 319
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 62	com/google/android/exoplayer2/h/a/l:bys	Ljava/util/HashMap;
    //   13: aload_1
    //   14: getfield 89	com/google/android/exoplayer2/h/a/g:key	Ljava/lang/String;
    //   17: invokevirtual 321	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: if_acmpne +22 -> 42
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: invokestatic 202	com/google/android/exoplayer2/i/a:checkState	(Z)V
    //   29: aload_0
    //   30: invokevirtual 324	java/lang/Object:notifyAll	()V
    //   33: ldc_w 319
    //   36: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	52	0	this	l
    //   0	52	1	paramg	g
    //   24	20	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	47	finally
    //   25	39	47	finally
  }
  
  final void a(m paramm)
  {
    AppMethodBeat.i(93015);
    this.byt.aC(paramm.key).a(paramm);
    this.byv += paramm.length;
    b(paramm);
    AppMethodBeat.o(93015);
  }
  
  /* Error */
  public final long aB(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 335
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 64	com/google/android/exoplayer2/h/a/l:byt	Lcom/google/android/exoplayer2/h/a/j;
    //   12: aload_1
    //   13: invokevirtual 93	com/google/android/exoplayer2/h/a/j:aD	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/i;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +17 -> 35
    //   21: ldc2_w 336
    //   24: lstore_2
    //   25: ldc_w 335
    //   28: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: lload_2
    //   34: lreturn
    //   35: aload_1
    //   36: getfield 338	com/google/android/exoplayer2/h/a/i:length	J
    //   39: lstore_2
    //   40: ldc_w 335
    //   43: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -15 -> 31
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	l
    //   0	54	1	paramString	String
    //   24	16	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	17	49	finally
    //   25	31	49	finally
    //   35	46	49	finally
  }
  
  public final void b(g paramg)
  {
    try
    {
      AppMethodBeat.i(93017);
      a(paramg, true);
      AppMethodBeat.o(93017);
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  public final File f(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      AppMethodBeat.i(93012);
      com.google.android.exoplayer2.i.a.checkState(this.bys.containsKey(paramString));
      if (!this.byq.exists())
      {
        vB();
        this.byq.mkdirs();
      }
      this.byr.a(this, paramLong2);
      paramString = m.a(this.byq, this.byt.aE(paramString), paramLong1, System.currentTimeMillis());
      AppMethodBeat.o(93012);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public final void f(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 360
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 64	com/google/android/exoplayer2/h/a/l:byt	Lcom/google/android/exoplayer2/h/a/j;
    //   12: astore 4
    //   14: aload 4
    //   16: aload_1
    //   17: invokevirtual 93	com/google/android/exoplayer2/h/a/j:aD	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/i;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +41 -> 65
    //   27: aload 5
    //   29: getfield 338	com/google/android/exoplayer2/h/a/i:length	J
    //   32: lload_2
    //   33: lcmp
    //   34: ifeq +15 -> 49
    //   37: aload 5
    //   39: lload_2
    //   40: putfield 338	com/google/android/exoplayer2/h/a/i:length	J
    //   43: aload 4
    //   45: iconst_1
    //   46: putfield 363	com/google/android/exoplayer2/h/a/j:byn	Z
    //   49: aload_0
    //   50: getfield 64	com/google/android/exoplayer2/h/a/l:byt	Lcom/google/android/exoplayer2/h/a/j;
    //   53: invokevirtual 128	com/google/android/exoplayer2/h/a/j:vy	()V
    //   56: ldc_w 360
    //   59: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: aload 4
    //   67: aload_1
    //   68: lload_2
    //   69: invokevirtual 367	com/google/android/exoplayer2/h/a/j:g	(Ljava/lang/String;J)Lcom/google/android/exoplayer2/h/a/i;
    //   72: pop
    //   73: goto -24 -> 49
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	l
    //   0	81	1	paramString	String
    //   0	81	2	paramLong	long
    //   12	54	4	localj	j
    //   20	18	5	locali	i
    // Exception table:
    //   from	to	target	type
    //   2	22	76	finally
    //   27	49	76	finally
    //   49	62	76	finally
    //   65	73	76	finally
  }
  
  public final long g(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    label235:
    label238:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(93022);
        paramString = this.byt.aD(paramString);
        if (paramString != null)
        {
          m localm = paramString.aq(paramLong1);
          if (!localm.byc) {
            i = 1;
          }
          if (i != 0)
          {
            if (localm.vw())
            {
              paramLong1 = 9223372036854775807L;
              paramLong1 = -Math.min(paramLong1, paramLong2);
              AppMethodBeat.o(93022);
              return paramLong1;
            }
            paramLong1 = localm.length;
            continue;
          }
          long l3 = paramLong1 + paramLong2;
          long l2 = localm.position + localm.length;
          long l1 = l2;
          if (l2 < l3)
          {
            paramString = paramString.byg.tailSet(localm, false).iterator();
            l1 = l2;
            if (!paramString.hasNext()) {
              break label238;
            }
            localm = (m)paramString.next();
            if (localm.position > l1) {
              break label238;
            }
            l2 = localm.position;
            l1 = Math.max(l1, localm.length + l2);
            if (l1 < l3) {
              break label235;
            }
          }
          paramLong1 = Math.min(l1 - paramLong1, paramLong2);
          AppMethodBeat.o(93022);
          continue;
        }
        paramLong1 = -paramLong2;
      }
      finally {}
      AppMethodBeat.o(93022);
      continue;
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
  
  public final void w(File paramFile)
  {
    boolean bool2 = true;
    m localm;
    try
    {
      AppMethodBeat.i(93013);
      localm = m.a(paramFile, this.byt);
      if (localm != null)
      {
        bool1 = true;
        com.google.android.exoplayer2.i.a.checkState(bool1);
        com.google.android.exoplayer2.i.a.checkState(this.bys.containsKey(localm.key));
        if (paramFile.exists()) {
          break label67;
        }
        AppMethodBeat.o(93013);
      }
      for (;;)
      {
        return;
        bool1 = false;
        break;
        label67:
        if (paramFile.length() != 0L) {
          break label95;
        }
        paramFile.delete();
        AppMethodBeat.o(93013);
      }
      paramFile = Long.valueOf(aB(localm.key));
    }
    finally {}
    label95:
    if (paramFile.longValue() != -1L) {
      if (localm.position + localm.length > paramFile.longValue()) {
        break label170;
      }
    }
    label170:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool1);
      a(localm);
      this.byt.vy();
      notifyAll();
      AppMethodBeat.o(93013);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.l
 * JD-Core Version:    0.7.0.1
 */