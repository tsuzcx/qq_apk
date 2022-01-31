package com.google.android.exoplayer2.h.a;

import android.os.ConditionVariable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

public final class j
  implements a
{
  final File bap;
  private final d baq;
  private final HashMap<String, e> bar;
  final h bas;
  private final HashMap<String, ArrayList<a.b>> bat;
  private long bau;
  a.a bav;
  
  public j(File paramFile, d paramd)
  {
    this(paramFile, paramd, (byte)0);
  }
  
  private j(File paramFile, d paramd, byte paramByte)
  {
    this(paramFile, paramd, new h(paramFile));
    AppMethodBeat.i(151986);
    AppMethodBeat.o(151986);
  }
  
  private j(File paramFile, d paramd, h paramh)
  {
    AppMethodBeat.i(151987);
    this.bau = 0L;
    this.bap = paramFile;
    this.baq = paramd;
    this.bar = new HashMap();
    this.bas = paramh;
    this.bat = new HashMap();
    paramFile = new ConditionVariable();
    new j.1(this, "SimpleCache.initialize()", paramFile).start();
    paramFile.block();
    AppMethodBeat.o(151987);
  }
  
  private void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(151996);
    g localg = this.bas.aA(parame.key);
    if (localg != null)
    {
      if (!localg.bae.remove(parame)) {
        break label55;
      }
      parame.file.delete();
    }
    label55:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(151996);
      return;
    }
    this.bau -= parame.aPF;
    if (paramBoolean) {}
    try
    {
      if (localg.bae.isEmpty())
      {
        this.bas.aC(localg.key);
        this.bas.qC();
      }
      return;
    }
    finally
    {
      e(parame);
      AppMethodBeat.o(151996);
    }
  }
  
  private void a(k paramk, e parame)
  {
    AppMethodBeat.i(152001);
    ArrayList localArrayList = (ArrayList)this.bat.get(paramk.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).a(this, paramk, parame);
        i -= 1;
      }
    }
    this.baq.a(this, paramk, parame);
    AppMethodBeat.o(152001);
  }
  
  /* Error */
  private NavigableSet<e> aD(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 161
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 62	com/google/android/exoplayer2/h/a/j:bas	Lcom/google/android/exoplayer2/h/a/h;
    //   11: aload_1
    //   12: invokevirtual 93	com/google/android/exoplayer2/h/a/h:aA	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/g;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +13 -> 30
    //   20: aload_1
    //   21: getfield 99	com/google/android/exoplayer2/h/a/g:bae	Ljava/util/TreeSet;
    //   24: invokevirtual 120	java/util/TreeSet:isEmpty	()Z
    //   27: ifeq +14 -> 41
    //   30: aconst_null
    //   31: astore_1
    //   32: ldc 161
    //   34: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: new 101	java/util/TreeSet
    //   44: dup
    //   45: aload_1
    //   46: getfield 99	com/google/android/exoplayer2/h/a/g:bae	Ljava/util/TreeSet;
    //   49: invokespecial 164	java/util/TreeSet:<init>	(Ljava/util/Collection;)V
    //   52: astore_1
    //   53: ldc 161
    //   55: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -21 -> 37
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	j
    //   0	66	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	16	61	finally
    //   20	30	61	finally
    //   32	37	61	finally
    //   41	58	61	finally
  }
  
  private void b(k paramk)
  {
    AppMethodBeat.i(152000);
    ArrayList localArrayList = (ArrayList)this.bat.get(paramk.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).a(this, paramk);
        i -= 1;
      }
    }
    this.baq.a(this, paramk);
    AppMethodBeat.o(152000);
  }
  
  private void e(e parame)
  {
    AppMethodBeat.i(151999);
    ArrayList localArrayList = (ArrayList)this.bat.get(parame.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).c(parame);
        i -= 1;
      }
    }
    this.baq.c(parame);
    AppMethodBeat.o(151999);
  }
  
  /* Error */
  private k h(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 181
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: lload_2
    //   10: invokespecial 183	com/google/android/exoplayer2/h/a/j:i	(Ljava/lang/String;J)Lcom/google/android/exoplayer2/h/a/k;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +13 -> 30
    //   20: ldc 181
    //   22: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	42	0	this	j
    //   0	42	1	paramString	String
    //   0	42	2	paramLong	long
    //   13	15	4	localk	k
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   7	15	37	finally
    //   20	25	37	finally
    //   30	34	37	finally
  }
  
  private k i(String paramString, long paramLong)
  {
    try
    {
      AppMethodBeat.i(151991);
      if (this.bav != null)
      {
        paramString = this.bav;
        AppMethodBeat.o(151991);
        throw paramString;
      }
    }
    finally {}
    g localg = this.bas.aA(paramString);
    Object localObject1;
    Object localObject2;
    if (localg == null)
    {
      localObject1 = k.k(paramString, paramLong);
      if (!((k)localObject1).aZZ) {
        break label283;
      }
      localObject2 = this.bas.aA(paramString);
      com.google.android.exoplayer2.i.a.checkState(((g)localObject2).bae.remove(localObject1));
      int i = ((g)localObject2).id;
      com.google.android.exoplayer2.i.a.checkState(((k)localObject1).aZZ);
      paramLong = System.currentTimeMillis();
      paramString = k.a(((k)localObject1).file.getParentFile(), i, ((k)localObject1).position, paramLong);
      paramString = new k(((k)localObject1).key, ((k)localObject1).position, ((k)localObject1).aPF, paramLong, paramString);
      if (!((k)localObject1).file.renameTo(paramString.file))
      {
        paramString = new a.a("Renaming of " + ((k)localObject1).file + " to " + paramString.file + " failed.");
        AppMethodBeat.o(151991);
        throw paramString;
      }
    }
    else
    {
      for (;;)
      {
        localObject2 = localg.af(paramLong);
        localObject1 = localObject2;
        if (!((k)localObject2).aZZ) {
          break;
        }
        localObject1 = localObject2;
        if (((k)localObject2).file.exists()) {
          break;
        }
        qF();
      }
    }
    ((g)localObject2).bae.add(paramString);
    a((k)localObject1, paramString);
    AppMethodBeat.o(151991);
    for (;;)
    {
      return paramString;
      label283:
      if (!this.bar.containsKey(paramString))
      {
        this.bar.put(paramString, localObject1);
        AppMethodBeat.o(151991);
        paramString = (String)localObject1;
      }
      else
      {
        paramString = null;
        AppMethodBeat.o(151991);
      }
    }
  }
  
  private void qF()
  {
    AppMethodBeat.i(151998);
    Object localObject = new LinkedList();
    Iterator localIterator1 = this.bas.baf.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((g)localIterator1.next()).bae.iterator();
      while (localIterator2.hasNext())
      {
        e locale = (e)localIterator2.next();
        if (!locale.file.exists()) {
          ((LinkedList)localObject).add(locale);
        }
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((e)((Iterator)localObject).next(), false);
    }
    this.bas.qD();
    this.bas.qC();
    AppMethodBeat.o(151998);
  }
  
  public final NavigableSet<e> a(String paramString, a.b paramb)
  {
    try
    {
      AppMethodBeat.i(151988);
      ArrayList localArrayList2 = (ArrayList)this.bat.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.bat.put(paramString, localArrayList1);
      }
      localArrayList1.add(paramb);
      paramString = aD(paramString);
      AppMethodBeat.o(151988);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public final void a(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 319
    //   5: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 60	com/google/android/exoplayer2/h/a/j:bar	Ljava/util/HashMap;
    //   13: aload_1
    //   14: getfield 89	com/google/android/exoplayer2/h/a/e:key	Ljava/lang/String;
    //   17: invokevirtual 321	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: if_acmpne +22 -> 42
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: invokestatic 202	com/google/android/exoplayer2/i/a:checkState	(Z)V
    //   29: aload_0
    //   30: invokevirtual 324	java/lang/Object:notifyAll	()V
    //   33: ldc_w 319
    //   36: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	52	0	this	j
    //   0	52	1	parame	e
    //   24	20	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	47	finally
    //   25	39	47	finally
  }
  
  final void a(k paramk)
  {
    AppMethodBeat.i(151995);
    this.bas.az(paramk.key).a(paramk);
    this.bau += paramk.aPF;
    b(paramk);
    AppMethodBeat.o(151995);
  }
  
  /* Error */
  public final long ay(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 335
    //   5: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 62	com/google/android/exoplayer2/h/a/j:bas	Lcom/google/android/exoplayer2/h/a/h;
    //   12: aload_1
    //   13: invokevirtual 93	com/google/android/exoplayer2/h/a/h:aA	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/g;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +17 -> 35
    //   21: ldc2_w 336
    //   24: lstore_2
    //   25: ldc_w 335
    //   28: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: lload_2
    //   34: lreturn
    //   35: aload_1
    //   36: getfield 338	com/google/android/exoplayer2/h/a/g:aPF	J
    //   39: lstore_2
    //   40: ldc_w 335
    //   43: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -15 -> 31
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	j
    //   0	54	1	paramString	String
    //   24	16	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	17	49	finally
    //   25	31	49	finally
    //   35	46	49	finally
  }
  
  public final void b(e parame)
  {
    try
    {
      AppMethodBeat.i(151997);
      a(parame, true);
      AppMethodBeat.o(151997);
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final File e(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      AppMethodBeat.i(151992);
      com.google.android.exoplayer2.i.a.checkState(this.bar.containsKey(paramString));
      if (!this.bap.exists())
      {
        qF();
        this.bap.mkdirs();
      }
      this.baq.a(this, paramLong2);
      paramString = k.a(this.bap, this.bas.aB(paramString), paramLong1, System.currentTimeMillis());
      AppMethodBeat.o(151992);
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
    //   5: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 62	com/google/android/exoplayer2/h/a/j:bas	Lcom/google/android/exoplayer2/h/a/h;
    //   12: astore 4
    //   14: aload 4
    //   16: aload_1
    //   17: invokevirtual 93	com/google/android/exoplayer2/h/a/h:aA	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/g;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +41 -> 65
    //   27: aload 5
    //   29: getfield 338	com/google/android/exoplayer2/h/a/g:aPF	J
    //   32: lload_2
    //   33: lcmp
    //   34: ifeq +15 -> 49
    //   37: aload 5
    //   39: lload_2
    //   40: putfield 338	com/google/android/exoplayer2/h/a/g:aPF	J
    //   43: aload 4
    //   45: iconst_1
    //   46: putfield 363	com/google/android/exoplayer2/h/a/h:bal	Z
    //   49: aload_0
    //   50: getfield 62	com/google/android/exoplayer2/h/a/j:bas	Lcom/google/android/exoplayer2/h/a/h;
    //   53: invokevirtual 128	com/google/android/exoplayer2/h/a/h:qC	()V
    //   56: ldc_w 360
    //   59: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: aload 4
    //   67: aload_1
    //   68: lload_2
    //   69: invokevirtual 367	com/google/android/exoplayer2/h/a/h:g	(Ljava/lang/String;J)Lcom/google/android/exoplayer2/h/a/g;
    //   72: pop
    //   73: goto -24 -> 49
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	j
    //   0	81	1	paramString	String
    //   0	81	2	paramLong	long
    //   12	54	4	localh	h
    //   20	18	5	localg	g
    // Exception table:
    //   from	to	target	type
    //   2	22	76	finally
    //   27	49	76	finally
    //   49	62	76	finally
    //   65	73	76	finally
  }
  
  /* Error */
  public final boolean f(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 369
    //   5: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 62	com/google/android/exoplayer2/h/a/j:bas	Lcom/google/android/exoplayer2/h/a/h;
    //   12: aload_1
    //   13: invokevirtual 93	com/google/android/exoplayer2/h/a/h:aA	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/g;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +30 -> 48
    //   21: aload_1
    //   22: lload_2
    //   23: lload 4
    //   25: invokevirtual 373	com/google/android/exoplayer2/h/a/g:m	(JJ)J
    //   28: lload 4
    //   30: lcmp
    //   31: iflt +17 -> 48
    //   34: iconst_1
    //   35: istore 6
    //   37: ldc_w 369
    //   40: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: iload 6
    //   47: ireturn
    //   48: iconst_0
    //   49: istore 6
    //   51: ldc_w 369
    //   54: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: goto -14 -> 43
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	j
    //   0	65	1	paramString	String
    //   0	65	2	paramLong1	long
    //   0	65	4	paramLong2	long
    //   35	15	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	60	finally
    //   21	34	60	finally
    //   37	43	60	finally
    //   51	57	60	finally
  }
  
  /* Error */
  public final long g(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 375
    //   5: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 62	com/google/android/exoplayer2/h/a/j:bas	Lcom/google/android/exoplayer2/h/a/h;
    //   12: aload_1
    //   13: invokevirtual 93	com/google/android/exoplayer2/h/a/h:aA	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/g;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +21 -> 39
    //   21: aload_1
    //   22: lload_2
    //   23: lload 4
    //   25: invokevirtual 373	com/google/android/exoplayer2/h/a/g:m	(JJ)J
    //   28: lstore_2
    //   29: ldc_w 375
    //   32: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: lload_2
    //   38: lreturn
    //   39: lload 4
    //   41: lneg
    //   42: lstore_2
    //   43: ldc_w 375
    //   46: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -14 -> 35
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	j
    //   0	57	1	paramString	String
    //   0	57	2	paramLong1	long
    //   0	57	4	paramLong2	long
    // Exception table:
    //   from	to	target	type
    //   2	17	52	finally
    //   21	35	52	finally
    //   43	49	52	finally
  }
  
  public final void k(File paramFile)
  {
    boolean bool2 = true;
    k localk;
    try
    {
      AppMethodBeat.i(151993);
      localk = k.a(paramFile, this.bas);
      if (localk != null)
      {
        bool1 = true;
        com.google.android.exoplayer2.i.a.checkState(bool1);
        com.google.android.exoplayer2.i.a.checkState(this.bar.containsKey(localk.key));
        if (paramFile.exists()) {
          break label67;
        }
        AppMethodBeat.o(151993);
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
        AppMethodBeat.o(151993);
      }
      paramFile = Long.valueOf(ay(localk.key));
    }
    finally {}
    label95:
    if (paramFile.longValue() != -1L) {
      if (localk.position + localk.aPF > paramFile.longValue()) {
        break label170;
      }
    }
    label170:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool1);
      a(localk);
      this.bas.qC();
      notifyAll();
      AppMethodBeat.o(151993);
      break;
    }
  }
  
  public final long qw()
  {
    try
    {
      long l = this.bau;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.j
 * JD-Core Version:    0.7.0.1
 */