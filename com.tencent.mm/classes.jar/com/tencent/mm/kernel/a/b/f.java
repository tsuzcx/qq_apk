package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.b;
import com.tencent.mm.kernel.a.a.a.a;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class f<T>
  extends com.tencent.mm.kernel.a.a.a<T>
  implements c<T>
{
  private c<T> gfc;
  private d<T> gfi;
  public Class gfj;
  private volatile boolean gfk = false;
  
  public f(Class paramClass, d<T> paramd, c paramc)
  {
    this.gfj = paramClass;
    this.gfi = paramd;
    this.gfc = paramc;
  }
  
  public final void a(a<T> parama)
  {
    AppMethodBeat.i(158394);
    parama = parama.afW();
    if (parama != null)
    {
      parama = parama.iterator();
      while (parama.hasNext())
      {
        a locala = (a)parama.next();
        if (locala.agp()) {
          this.gfi.b(locala);
        }
      }
    }
    AppMethodBeat.o(158394);
  }
  
  public final a<T> agd()
  {
    AppMethodBeat.i(158393);
    a locala = this.gfi.agd();
    AppMethodBeat.o(158393);
    return locala;
  }
  
  public final List<a.a> agk()
  {
    AppMethodBeat.i(158396);
    ArrayList localArrayList = new ArrayList(1);
    Iterator localIterator = this.geN.values().iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (!((a)locala).geR)
      {
        int i = ((a)locala).gfl;
        a locala1 = ((a)locala).gfo;
        if (((a)locala).gfo != null) {}
        for (Object localObject = Boolean.valueOf(((a)locala).gfo.geR);; localObject = "")
        {
          ad.e("MMSkeleton.ParallelsDependencies", "ParallelsDependencies node(%s) not consumed!!!! %s, %s, %s", new Object[] { locala, Integer.valueOf(i), locala1, localObject });
          localArrayList.add(locala);
          break;
        }
      }
    }
    AppMethodBeat.o(158396);
    return localArrayList;
  }
  
  public final a<T> bC(T paramT)
  {
    AppMethodBeat.i(158390);
    paramT = (a)this.geN.get(paramT);
    AppMethodBeat.o(158390);
    return paramT;
  }
  
  public final void bD(Object paramObject)
  {
    AppMethodBeat.i(158395);
    a locala = (a)this.geN.get(paramObject);
    if (locala.geQ != ((a)paramObject).geQ) {
      ad.e("MMSkeleton.ParallelsDependencies", "not same!!!! %s, %s, %s, %s", new Object[] { locala, locala.geQ, paramObject, this.geN.get(paramObject) });
    }
    if ((this.gfk) && (locala.agm())) {
      this.gfi.b(locala);
    }
    AppMethodBeat.o(158395);
  }
  
  public final a.a<T> bw(T paramT)
  {
    AppMethodBeat.i(158389);
    if (!this.geN.containsKey(paramT)) {
      this.geN.putIfAbsent(paramT, new a(paramT, this.gfj, this.gfc, (byte)0));
    }
    paramT = (a.a)this.geN.get(paramT);
    AppMethodBeat.o(158389);
    return paramT;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(158392);
    ad.i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies for type %s", new Object[] { this.gfj });
    Assert.assertNotNull(this.gfi);
    this.gfk = true;
    Iterator localIterator = this.geN.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (a.a)localIterator.next();
      if (((a.a)localObject).afZ())
      {
        localObject = (a)localObject;
        ad.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s", new Object[] { localObject });
        if (((a)localObject).agm()) {
          this.gfi.b((a)localObject);
        }
        ad.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s done", new Object[] { localObject });
      }
    }
    ad.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare %s done", new Object[] { this.gfj });
    AppMethodBeat.o(158392);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(158391);
    Iterator localIterator = this.geN.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramBoolean) {
        locala.geR = false;
      }
      try
      {
        locala.gfl = locala.afY();
        locala.gfn = false;
      }
      finally
      {
        AppMethodBeat.o(158391);
      }
    }
    AppMethodBeat.o(158391);
  }
  
  public static final class a<T>
    extends a.a<T>
  {
    volatile int gfl;
    private boolean gfm;
    volatile boolean gfn;
    public volatile a gfo;
    public volatile a gfp;
    public h gfq;
    private c gfr;
    public f.b gfs;
    
    private a(T paramT, Class paramClass, c paramc)
    {
      super();
      AppMethodBeat.i(158380);
      this.gfl = 0;
      this.gfm = false;
      this.gfn = false;
      this.gfq = new h();
      this.gfs = new f.b();
      this.gfq.geU = paramClass;
      this.gfr = paramc;
      AppMethodBeat.o(158380);
    }
    
    private boolean agl()
    {
      return (this.gfl == 0) && ((this.gfo == null) || (this.gfo.geR));
    }
    
    /* Error */
    private boolean agn()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 76
      //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 80	com/tencent/mm/kernel/a/a/a$a:geQ	Ljava/lang/Object;
      //   13: astore 5
      //   15: aload_0
      //   16: getfield 47	com/tencent/mm/kernel/a/b/f$a:gfq	Lcom/tencent/mm/kernel/a/b/h;
      //   19: getfield 56	com/tencent/mm/kernel/a/b/h:geU	Ljava/lang/Class;
      //   22: astore 6
      //   24: aload_0
      //   25: getfield 40	com/tencent/mm/kernel/a/b/f$a:gfn	Z
      //   28: istore_3
      //   29: aload_0
      //   30: getfield 36	com/tencent/mm/kernel/a/b/f$a:gfl	I
      //   33: istore_1
      //   34: aload_0
      //   35: getfield 71	com/tencent/mm/kernel/a/b/f$a:gfo	Lcom/tencent/mm/kernel/a/b/f$a;
      //   38: astore 7
      //   40: aload_0
      //   41: getfield 71	com/tencent/mm/kernel/a/b/f$a:gfo	Lcom/tencent/mm/kernel/a/b/f$a;
      //   44: ifnull +88 -> 132
      //   47: aload_0
      //   48: getfield 71	com/tencent/mm/kernel/a/b/f$a:gfo	Lcom/tencent/mm/kernel/a/b/f$a;
      //   51: getfield 74	com/tencent/mm/kernel/a/a/a$a:geR	Z
      //   54: invokestatic 86	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   57: astore 4
      //   59: ldc 88
      //   61: ldc 90
      //   63: bipush 7
      //   65: anewarray 92	java/lang/Object
      //   68: dup
      //   69: iconst_0
      //   70: aload 5
      //   72: aastore
      //   73: dup
      //   74: iconst_1
      //   75: aload 6
      //   77: aastore
      //   78: dup
      //   79: iconst_2
      //   80: iload_3
      //   81: invokestatic 86	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   84: aastore
      //   85: dup
      //   86: iconst_3
      //   87: iload_1
      //   88: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   91: aastore
      //   92: dup
      //   93: iconst_4
      //   94: aload 7
      //   96: aastore
      //   97: dup
      //   98: iconst_5
      //   99: aload 4
      //   101: aastore
      //   102: dup
      //   103: bipush 6
      //   105: aload_0
      //   106: getfield 47	com/tencent/mm/kernel/a/b/f$a:gfq	Lcom/tencent/mm/kernel/a/b/h;
      //   109: getfield 100	com/tencent/mm/kernel/a/b/h:gfB	Ljava/lang/Class;
      //   112: aastore
      //   113: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   116: aload_0
      //   117: getfield 40	com/tencent/mm/kernel/a/b/f$a:gfn	Z
      //   120: ifeq +19 -> 139
      //   123: ldc 76
      //   125: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   128: aload_0
      //   129: monitorexit
      //   130: iload_2
      //   131: ireturn
      //   132: ldc 107
      //   134: astore 4
      //   136: goto -77 -> 59
      //   139: aload_0
      //   140: invokespecial 109	com/tencent/mm/kernel/a/b/f$a:agl	()Z
      //   143: istore_2
      //   144: ldc 76
      //   146: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   149: goto -21 -> 128
      //   152: astore 4
      //   154: aload_0
      //   155: monitorexit
      //   156: aload 4
      //   158: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	159	0	this	a
      //   33	55	1	i	int
      //   1	143	2	bool1	boolean
      //   28	53	3	bool2	boolean
      //   57	78	4	localObject1	Object
      //   152	5	4	localObject2	Object
      //   13	58	5	localObject3	Object
      //   22	54	6	localClass	Class
      //   38	57	7	locala	a
      // Exception table:
      //   from	to	target	type
      //   4	59	152	finally
      //   59	128	152	finally
      //   139	149	152	finally
    }
    
    private void ago()
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(158385);
        }
        finally {}
        try
        {
          if (!this.gfn) {
            continue;
          }
          ad.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s resolved!", new Object[] { this, Boolean.valueOf(this.geR), this.gfq.geU });
          AppMethodBeat.o(158385);
        }
        catch (InterruptedException localInterruptedException)
        {
          ad.printErrStackTrace("MMSkeleton.ParallelsDependencies", localInterruptedException, "", new Object[0]);
          AppMethodBeat.o(158385);
          continue;
        }
        return;
        ad.i("MMSkeleton.ParallelsDependencies", "waiting resolved");
        ad.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s", new Object[] { this, Boolean.valueOf(this.geR), this.gfq.geU });
        wait();
        ad.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s done", new Object[] { this, Boolean.valueOf(this.geR), this.gfq.geU });
        AppMethodBeat.o(158385);
      }
    }
    
    public final void a(a.a parama)
    {
      AppMethodBeat.i(158381);
      super.a(parama);
      try
      {
        this.gfl += 1;
        return;
      }
      finally
      {
        AppMethodBeat.o(158381);
      }
    }
    
    public final void a(com.tencent.mm.vending.c.a parama)
    {
      AppMethodBeat.i(158382);
      if (!this.geR) {
        if (!agn())
        {
          Object localObject = afX();
          Assert.assertNotNull(localObject);
          localObject = ((HashSet)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a.a locala = (a.a)((Iterator)localObject).next();
            if (!((a)locala).geR) {
              ad.i("MMSkeleton.ParallelsDependencies", "ParallelsNode(%s) found it's depending node(%s) not consumed.", new Object[] { this, locala });
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ago();
        }
        this.gfs.gft.fkL();
        if (!this.geR)
        {
          j.i("MMSkeleton.ParallelsDependencies", "Consume node(%s) on phase(%s) may after waiting resolved.", new Object[] { this, this.gfq.geU });
          parama.call(this);
          this.geR = true;
        }
        this.gfs.gft.done();
        AppMethodBeat.o(158382);
        return;
      }
    }
    
    /* Error */
    public final boolean agm()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 195
      //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 80	com/tencent/mm/kernel/a/a/a$a:geQ	Ljava/lang/Object;
      //   13: astore 5
      //   15: aload_0
      //   16: getfield 47	com/tencent/mm/kernel/a/b/f$a:gfq	Lcom/tencent/mm/kernel/a/b/h;
      //   19: getfield 56	com/tencent/mm/kernel/a/b/h:geU	Ljava/lang/Class;
      //   22: astore 6
      //   24: aload_0
      //   25: getfield 40	com/tencent/mm/kernel/a/b/f$a:gfn	Z
      //   28: istore_3
      //   29: aload_0
      //   30: getfield 36	com/tencent/mm/kernel/a/b/f$a:gfl	I
      //   33: istore_1
      //   34: aload_0
      //   35: getfield 71	com/tencent/mm/kernel/a/b/f$a:gfo	Lcom/tencent/mm/kernel/a/b/f$a;
      //   38: astore 7
      //   40: aload_0
      //   41: getfield 71	com/tencent/mm/kernel/a/b/f$a:gfo	Lcom/tencent/mm/kernel/a/b/f$a;
      //   44: ifnull +88 -> 132
      //   47: aload_0
      //   48: getfield 71	com/tencent/mm/kernel/a/b/f$a:gfo	Lcom/tencent/mm/kernel/a/b/f$a;
      //   51: getfield 74	com/tencent/mm/kernel/a/a/a$a:geR	Z
      //   54: invokestatic 86	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   57: astore 4
      //   59: ldc 88
      //   61: ldc 197
      //   63: bipush 7
      //   65: anewarray 92	java/lang/Object
      //   68: dup
      //   69: iconst_0
      //   70: aload 5
      //   72: aastore
      //   73: dup
      //   74: iconst_1
      //   75: aload 6
      //   77: aastore
      //   78: dup
      //   79: iconst_2
      //   80: iload_3
      //   81: invokestatic 86	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   84: aastore
      //   85: dup
      //   86: iconst_3
      //   87: iload_1
      //   88: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   91: aastore
      //   92: dup
      //   93: iconst_4
      //   94: aload 7
      //   96: aastore
      //   97: dup
      //   98: iconst_5
      //   99: aload 4
      //   101: aastore
      //   102: dup
      //   103: bipush 6
      //   105: aload_0
      //   106: getfield 47	com/tencent/mm/kernel/a/b/f$a:gfq	Lcom/tencent/mm/kernel/a/b/h;
      //   109: getfield 100	com/tencent/mm/kernel/a/b/h:gfB	Ljava/lang/Class;
      //   112: aastore
      //   113: invokestatic 118	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   116: aload_0
      //   117: getfield 40	com/tencent/mm/kernel/a/b/f$a:gfn	Z
      //   120: ifeq +19 -> 139
      //   123: ldc 195
      //   125: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   128: aload_0
      //   129: monitorexit
      //   130: iload_2
      //   131: ireturn
      //   132: ldc 107
      //   134: astore 4
      //   136: goto -77 -> 59
      //   139: aload_0
      //   140: invokespecial 109	com/tencent/mm/kernel/a/b/f$a:agl	()Z
      //   143: ifeq +57 -> 200
      //   146: ldc 88
      //   148: ldc 199
      //   150: iconst_3
      //   151: anewarray 92	java/lang/Object
      //   154: dup
      //   155: iconst_0
      //   156: aload_0
      //   157: aastore
      //   158: dup
      //   159: iconst_1
      //   160: aload_0
      //   161: getfield 74	com/tencent/mm/kernel/a/a/a$a:geR	Z
      //   164: invokestatic 86	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   167: aastore
      //   168: dup
      //   169: iconst_2
      //   170: aload_0
      //   171: getfield 47	com/tencent/mm/kernel/a/b/f$a:gfq	Lcom/tencent/mm/kernel/a/b/h;
      //   174: getfield 56	com/tencent/mm/kernel/a/b/h:geU	Ljava/lang/Class;
      //   177: aastore
      //   178: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   181: aload_0
      //   182: iconst_1
      //   183: putfield 40	com/tencent/mm/kernel/a/b/f$a:gfn	Z
      //   186: aload_0
      //   187: invokevirtual 202	java/lang/Object:notify	()V
      //   190: ldc 195
      //   192: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   195: iconst_1
      //   196: istore_2
      //   197: goto -69 -> 128
      //   200: ldc 195
      //   202: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   205: goto -77 -> 128
      //   208: astore 4
      //   210: aload_0
      //   211: monitorexit
      //   212: aload 4
      //   214: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	215	0	this	a
      //   33	55	1	i	int
      //   1	196	2	bool1	boolean
      //   28	53	3	bool2	boolean
      //   57	78	4	localObject1	Object
      //   208	5	4	localObject2	Object
      //   13	58	5	localObject3	Object
      //   22	54	6	localClass	Class
      //   38	57	7	locala	a
      // Exception table:
      //   from	to	target	type
      //   4	59	208	finally
      //   59	128	208	finally
      //   139	195	208	finally
      //   200	205	208	finally
    }
    
    public final boolean agp()
    {
      try
      {
        AppMethodBeat.i(158386);
        this.gfl -= 1;
        boolean bool = agm();
        AppMethodBeat.o(158386);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(158387);
      String str = super.toString() + " - with type " + this.gfq.geU;
      AppMethodBeat.o(158387);
      return str;
    }
  }
  
  public static final class b
  {
    public b gft;
    
    public b()
    {
      AppMethodBeat.i(158388);
      this.gft = new b();
      AppMethodBeat.o(158388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.f
 * JD-Core Version:    0.7.0.1
 */