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

public final class m
  implements a
{
  final File cacheDir;
  final j djP;
  final f djS;
  private final HashMap<String, g> djT;
  private final HashMap<String, ArrayList<a.b>> djU;
  private long djV;
  a.a djW;
  
  public m(File paramFile, f paramf)
  {
    this(paramFile, paramf, (byte)0);
  }
  
  private m(File paramFile, f paramf, byte paramByte)
  {
    this(paramFile, paramf, new j(paramFile));
    AppMethodBeat.i(93006);
    AppMethodBeat.o(93006);
  }
  
  public m(final File paramFile, f paramf, j paramj)
  {
    AppMethodBeat.i(93007);
    this.djV = 0L;
    this.cacheDir = paramFile;
    this.djS = paramf;
    this.djT = new HashMap();
    this.djP = paramj;
    this.djU = new HashMap();
    paramFile = new ConditionVariable();
    new Thread("SimpleCache.initialize()")
    {
      public final void run()
      {
        AppMethodBeat.i(93005);
        for (;;)
        {
          m localm2;
          int i;
          synchronized (m.this)
          {
            paramFile.open();
            try
            {
              localm2 = m.this;
              if (!localm2.cacheDir.exists())
              {
                localm2.cacheDir.mkdirs();
                AppMethodBeat.o(93005);
                return;
              }
              Object localObject1 = localm2.djP;
              if (((j)localObject1).djJ) {
                break label270;
              }
              bool = true;
              com.google.android.exoplayer2.i.a.checkState(bool);
              if (!((j)localObject1).Ux())
              {
                localObject4 = ((j)localObject1).djF;
                ((b)localObject4).dkc.delete();
                ((b)localObject4).dkd.delete();
                ((j)localObject1).djD.clear();
                ((j)localObject1).djE.clear();
              }
              Object localObject4 = localm2.cacheDir.listFiles();
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
                localObject1 = n.a(localFile, localm2.djP);
                if (localObject1 != null) {
                  localm2.a((n)localObject1);
                } else {
                  localFile.delete();
                }
              }
            }
            catch (a.a locala)
            {
              m.this.djW = locala;
              continue;
            }
          }
          localm2.djP.Uw();
          localm2.djP.Uv();
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
  
  private void Uy()
  {
    AppMethodBeat.i(93018);
    Object localObject = new LinkedList();
    Iterator localIterator1 = this.djP.djD.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((i)localIterator1.next()).djC.iterator();
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
    this.djP.Uw();
    this.djP.Uv();
    AppMethodBeat.o(93018);
  }
  
  private void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(93016);
    i locali = this.djP.cU(paramg.key);
    if (locali != null)
    {
      if (!locali.djC.remove(paramg)) {
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
    this.djV -= paramg.length;
    if (paramBoolean) {}
    try
    {
      if (locali.djC.isEmpty())
      {
        this.djP.cW(locali.key);
        this.djP.Uv();
      }
      return;
    }
    finally
    {
      d(paramg);
      AppMethodBeat.o(93016);
    }
  }
  
  private void a(n paramn, g paramg)
  {
    AppMethodBeat.i(93021);
    ArrayList localArrayList = (ArrayList)this.djU.get(paramn.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).a(this, paramn, paramg);
        i -= 1;
      }
    }
    this.djS.a(this, paramn, paramg);
    AppMethodBeat.o(93021);
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(93020);
    ArrayList localArrayList = (ArrayList)this.djU.get(paramn.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).a(this, paramn);
        i -= 1;
      }
    }
    this.djS.a(this, paramn);
    AppMethodBeat.o(93020);
  }
  
  /* Error */
  private NavigableSet<g> cX(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 208
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 64	com/google/android/exoplayer2/h/a/m:djP	Lcom/google/android/exoplayer2/h/a/j;
    //   11: aload_1
    //   12: invokevirtual 151	com/google/android/exoplayer2/h/a/j:cU	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/i;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +13 -> 30
    //   20: aload_1
    //   21: getfield 114	com/google/android/exoplayer2/h/a/i:djC	Ljava/util/TreeSet;
    //   24: invokevirtual 163	java/util/TreeSet:isEmpty	()Z
    //   27: ifeq +14 -> 41
    //   30: aconst_null
    //   31: astore_1
    //   32: ldc 208
    //   34: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: new 116	java/util/TreeSet
    //   44: dup
    //   45: aload_1
    //   46: getfield 114	com/google/android/exoplayer2/h/a/i:djC	Ljava/util/TreeSet;
    //   49: invokespecial 211	java/util/TreeSet:<init>	(Ljava/util/Collection;)V
    //   52: astore_1
    //   53: ldc 208
    //   55: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -21 -> 37
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	m
    //   0	66	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	16	61	finally
    //   20	30	61	finally
    //   32	37	61	finally
    //   41	58	61	finally
  }
  
  private void d(g paramg)
  {
    AppMethodBeat.i(93019);
    ArrayList localArrayList = (ArrayList)this.djU.get(paramg.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).b(this, paramg);
        i -= 1;
      }
    }
    this.djS.b(this, paramg);
    AppMethodBeat.o(93019);
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
  
  public final NavigableSet<g> a(String paramString, a.b paramb)
  {
    try
    {
      AppMethodBeat.i(93008);
      ArrayList localArrayList2 = (ArrayList)this.djU.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.djU.put(paramString, localArrayList1);
      }
      localArrayList1.add(paramb);
      paramString = cX(paramString);
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
    //   2: ldc 231
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 62	com/google/android/exoplayer2/h/a/m:djT	Ljava/util/HashMap;
    //   12: aload_1
    //   13: getfield 147	com/google/android/exoplayer2/h/a/g:key	Ljava/lang/String;
    //   16: invokevirtual 233	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: if_acmpne +21 -> 40
    //   22: iconst_1
    //   23: istore_2
    //   24: iload_2
    //   25: invokestatic 239	com/google/android/exoplayer2/i/a:checkState	(Z)V
    //   28: aload_0
    //   29: invokevirtual 242	java/lang/Object:notifyAll	()V
    //   32: ldc 231
    //   34: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	50	0	this	m
    //   0	50	1	paramg	g
    //   23	19	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	22	45	finally
    //   24	37	45	finally
  }
  
  final void a(n paramn)
  {
    AppMethodBeat.i(93015);
    this.djP.cT(paramn.key).a(paramn);
    this.djV += paramn.length;
    b(paramn);
    AppMethodBeat.o(93015);
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
  
  /* Error */
  public final long cS(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 255
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 64	com/google/android/exoplayer2/h/a/m:djP	Lcom/google/android/exoplayer2/h/a/j;
    //   11: aload_1
    //   12: invokevirtual 151	com/google/android/exoplayer2/h/a/j:cU	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/i;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +16 -> 33
    //   20: ldc2_w 256
    //   23: lstore_2
    //   24: ldc 255
    //   26: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: lload_2
    //   32: lreturn
    //   33: aload_1
    //   34: getfield 258	com/google/android/exoplayer2/h/a/i:length	J
    //   37: lstore_2
    //   38: ldc 255
    //   40: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -14 -> 29
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	m
    //   0	51	1	paramString	String
    //   23	15	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	16	46	finally
    //   24	29	46	finally
    //   33	43	46	finally
  }
  
  public final File e(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      AppMethodBeat.i(93012);
      com.google.android.exoplayer2.i.a.checkState(this.djT.containsKey(paramString));
      if (!this.cacheDir.exists())
      {
        Uy();
        this.cacheDir.mkdirs();
      }
      this.djS.a(this, paramLong2);
      paramString = n.a(this.cacheDir, this.djP.cV(paramString), paramLong1, System.currentTimeMillis());
      AppMethodBeat.o(93012);
      return paramString;
    }
    finally {}
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    label235:
    label238:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(93022);
        paramString = this.djP.cU(paramString);
        if (paramString != null)
        {
          n localn = paramString.cE(paramLong1);
          if (!localn.djy) {
            i = 1;
          }
          if (i != 0)
          {
            if (localn.Ut())
            {
              paramLong1 = 9223372036854775807L;
              paramLong1 = -Math.min(paramLong1, paramLong2);
              AppMethodBeat.o(93022);
              return paramLong1;
            }
            paramLong1 = localn.length;
            continue;
          }
          long l3 = paramLong1 + paramLong2;
          long l2 = localn.position + localn.length;
          long l1 = l2;
          if (l2 < l3)
          {
            paramString = paramString.djC.tailSet(localn, false).iterator();
            l1 = l2;
            if (!paramString.hasNext()) {
              break label238;
            }
            localn = (n)paramString.next();
            if (localn.position > l1) {
              break label238;
            }
            l2 = localn.position;
            l1 = Math.max(l1, localn.length + l2);
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
  
  /* Error */
  public final void g(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 331
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 64	com/google/android/exoplayer2/h/a/m:djP	Lcom/google/android/exoplayer2/h/a/j;
    //   12: astore 4
    //   14: aload 4
    //   16: aload_1
    //   17: invokevirtual 151	com/google/android/exoplayer2/h/a/j:cU	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/i;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +41 -> 65
    //   27: aload 5
    //   29: getfield 258	com/google/android/exoplayer2/h/a/i:length	J
    //   32: lload_2
    //   33: lcmp
    //   34: ifeq +15 -> 49
    //   37: aload 5
    //   39: lload_2
    //   40: putfield 258	com/google/android/exoplayer2/h/a/i:length	J
    //   43: aload 4
    //   45: iconst_1
    //   46: putfield 334	com/google/android/exoplayer2/h/a/j:djJ	Z
    //   49: aload_0
    //   50: getfield 64	com/google/android/exoplayer2/h/a/m:djP	Lcom/google/android/exoplayer2/h/a/j;
    //   53: invokevirtual 142	com/google/android/exoplayer2/h/a/j:Uv	()V
    //   56: ldc_w 331
    //   59: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: aload 4
    //   67: aload_1
    //   68: lload_2
    //   69: invokevirtual 338	com/google/android/exoplayer2/h/a/j:h	(Ljava/lang/String;J)Lcom/google/android/exoplayer2/h/a/i;
    //   72: pop
    //   73: goto -24 -> 49
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	m
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
  
  /* Error */
  public final n i(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 339
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: lload_2
    //   11: invokevirtual 328	com/google/android/exoplayer2/h/a/m:j	(Ljava/lang/String;J)Lcom/google/android/exoplayer2/h/a/n;
    //   14: astore 4
    //   16: aload 4
    //   18: ifnull +14 -> 32
    //   21: ldc_w 339
    //   24: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: aload 4
    //   31: areturn
    //   32: aload_0
    //   33: invokevirtual 342	java/lang/Object:wait	()V
    //   36: goto -28 -> 8
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	m
    //   0	44	1	paramString	String
    //   0	44	2	paramLong	long
    //   14	16	4	localn	n
    // Exception table:
    //   from	to	target	type
    //   2	8	39	finally
    //   8	16	39	finally
    //   21	27	39	finally
    //   32	36	39	finally
  }
  
  public final n j(String paramString, long paramLong)
  {
    try
    {
      AppMethodBeat.i(93011);
      if (this.djW != null)
      {
        paramString = this.djW;
        AppMethodBeat.o(93011);
        throw paramString;
      }
    }
    finally {}
    i locali = this.djP.cU(paramString);
    Object localObject1;
    Object localObject2;
    if (locali == null)
    {
      localObject1 = n.l(paramString, paramLong);
      if (!((n)localObject1).djy) {
        break label290;
      }
      localObject2 = this.djP.cU(paramString);
      com.google.android.exoplayer2.i.a.checkState(((i)localObject2).djC.remove(localObject1));
      int i = ((i)localObject2).id;
      com.google.android.exoplayer2.i.a.checkState(((n)localObject1).djy);
      paramLong = System.currentTimeMillis();
      paramString = n.a(((n)localObject1).file.getParentFile(), i, ((n)localObject1).position, paramLong);
      paramString = new n(((n)localObject1).key, ((n)localObject1).position, ((n)localObject1).length, paramLong, paramString);
      if (!((n)localObject1).file.renameTo(paramString.file))
      {
        paramString = new a.a("Renaming of " + ((n)localObject1).file + " to " + paramString.file + " failed.");
        AppMethodBeat.o(93011);
        throw paramString;
      }
    }
    else
    {
      for (;;)
      {
        localObject2 = locali.cE(paramLong);
        localObject1 = localObject2;
        if (!((n)localObject2).djy) {
          break;
        }
        localObject1 = localObject2;
        if (((n)localObject2).file.exists()) {
          break;
        }
        Uy();
      }
    }
    ((i)localObject2).djC.add(paramString);
    a((n)localObject1, paramString);
    AppMethodBeat.o(93011);
    for (;;)
    {
      return paramString;
      label290:
      if (!this.djT.containsKey(paramString))
      {
        this.djT.put(paramString, localObject1);
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
  
  public final void x(File paramFile)
  {
    boolean bool2 = true;
    n localn;
    try
    {
      AppMethodBeat.i(93013);
      localn = n.a(paramFile, this.djP);
      if (localn != null)
      {
        bool1 = true;
        com.google.android.exoplayer2.i.a.checkState(bool1);
        com.google.android.exoplayer2.i.a.checkState(this.djT.containsKey(localn.key));
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
      paramFile = Long.valueOf(cS(localn.key));
    }
    finally {}
    label95:
    if (paramFile.longValue() != -1L) {
      if (localn.position + localn.length > paramFile.longValue()) {
        break label170;
      }
    }
    label170:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool1);
      a(localn);
      this.djP.Uv();
      notifyAll();
      AppMethodBeat.o(93013);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.m
 * JD-Core Version:    0.7.0.1
 */