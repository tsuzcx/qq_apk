package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.b;
import com.tencent.mm.kernel.a.a.a.a;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.Log;
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
  private c<T> hsN;
  private d<T> hsT;
  public Class hsU;
  private volatile boolean hsV = false;
  
  public f(Class paramClass, d<T> paramd, c paramc)
  {
    this.hsU = paramClass;
    this.hsT = paramd;
    this.hsN = paramc;
  }
  
  public final void a(a<T> parama)
  {
    AppMethodBeat.i(158394);
    parama = parama.aAC();
    if (parama != null)
    {
      parama = parama.iterator();
      while (parama.hasNext())
      {
        a locala = (a)parama.next();
        if (locala.aAV()) {
          this.hsT.b(locala);
        }
      }
    }
    AppMethodBeat.o(158394);
  }
  
  public final a<T> aAJ()
  {
    AppMethodBeat.i(158393);
    a locala = this.hsT.aAJ();
    AppMethodBeat.o(158393);
    return locala;
  }
  
  public final List<a.a> aAQ()
  {
    AppMethodBeat.i(158396);
    ArrayList localArrayList = new ArrayList(1);
    Iterator localIterator = this.hsy.values().iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (!((a)locala).hsC)
      {
        int i = ((a)locala).hsW;
        a locala1 = ((a)locala).hsZ;
        if (((a)locala).hsZ != null) {}
        for (Object localObject = Boolean.valueOf(((a)locala).hsZ.hsC);; localObject = "")
        {
          Log.e("MMSkeleton.ParallelsDependencies", "ParallelsDependencies node(%s) not consumed!!!! %s, %s, %s", new Object[] { locala, Integer.valueOf(i), locala1, localObject });
          localArrayList.add(locala);
          break;
        }
      }
    }
    AppMethodBeat.o(158396);
    return localArrayList;
  }
  
  public final a.a<T> bD(T paramT)
  {
    AppMethodBeat.i(158389);
    if (!this.hsy.containsKey(paramT)) {
      this.hsy.putIfAbsent(paramT, new a(paramT, this.hsU, this.hsN, (byte)0));
    }
    paramT = (a.a)this.hsy.get(paramT);
    AppMethodBeat.o(158389);
    return paramT;
  }
  
  public final a<T> bJ(T paramT)
  {
    AppMethodBeat.i(158390);
    paramT = (a)this.hsy.get(paramT);
    AppMethodBeat.o(158390);
    return paramT;
  }
  
  public final void bK(Object paramObject)
  {
    AppMethodBeat.i(158395);
    a locala = (a)this.hsy.get(paramObject);
    if (locala.hsB != ((a)paramObject).hsB) {
      Log.e("MMSkeleton.ParallelsDependencies", "not same!!!! %s, %s, %s, %s", new Object[] { locala, locala.hsB, paramObject, this.hsy.get(paramObject) });
    }
    if ((this.hsV) && (locala.aAS())) {
      this.hsT.b(locala);
    }
    AppMethodBeat.o(158395);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(158392);
    Log.i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies for type %s", new Object[] { this.hsU });
    Assert.assertNotNull(this.hsT);
    this.hsV = true;
    Iterator localIterator = this.hsy.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (a.a)localIterator.next();
      if (((a.a)localObject).aAF())
      {
        localObject = (a)localObject;
        Log.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s", new Object[] { localObject });
        if (((a)localObject).aAS()) {
          this.hsT.b((a)localObject);
        }
        Log.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s done", new Object[] { localObject });
      }
    }
    Log.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare %s done", new Object[] { this.hsU });
    AppMethodBeat.o(158392);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(158391);
    Iterator localIterator = this.hsy.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramBoolean) {
        locala.hsC = false;
      }
      try
      {
        locala.hsW = locala.aAE();
        locala.hsY = false;
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
    volatile int hsW;
    private boolean hsX;
    volatile boolean hsY;
    public volatile a hsZ;
    public volatile a hta;
    public h htb;
    private c htc;
    public f.b htd;
    
    private a(T paramT, Class paramClass, c paramc)
    {
      super();
      AppMethodBeat.i(158380);
      this.hsW = 0;
      this.hsX = false;
      this.hsY = false;
      this.htb = new h();
      this.htd = new f.b();
      this.htb.hsF = paramClass;
      this.htc = paramc;
      AppMethodBeat.o(158380);
    }
    
    private boolean aAR()
    {
      return (this.hsW == 0) && ((this.hsZ == null) || (this.hsZ.hsC));
    }
    
    /* Error */
    private boolean aAT()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 76
      //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 80	com/tencent/mm/kernel/a/a/a$a:hsB	Ljava/lang/Object;
      //   13: astore 5
      //   15: aload_0
      //   16: getfield 47	com/tencent/mm/kernel/a/b/f$a:htb	Lcom/tencent/mm/kernel/a/b/h;
      //   19: getfield 56	com/tencent/mm/kernel/a/b/h:hsF	Ljava/lang/Class;
      //   22: astore 6
      //   24: aload_0
      //   25: getfield 40	com/tencent/mm/kernel/a/b/f$a:hsY	Z
      //   28: istore_3
      //   29: aload_0
      //   30: getfield 36	com/tencent/mm/kernel/a/b/f$a:hsW	I
      //   33: istore_1
      //   34: aload_0
      //   35: getfield 71	com/tencent/mm/kernel/a/b/f$a:hsZ	Lcom/tencent/mm/kernel/a/b/f$a;
      //   38: astore 7
      //   40: aload_0
      //   41: getfield 71	com/tencent/mm/kernel/a/b/f$a:hsZ	Lcom/tencent/mm/kernel/a/b/f$a;
      //   44: ifnull +88 -> 132
      //   47: aload_0
      //   48: getfield 71	com/tencent/mm/kernel/a/b/f$a:hsZ	Lcom/tencent/mm/kernel/a/b/f$a;
      //   51: getfield 74	com/tencent/mm/kernel/a/a/a$a:hsC	Z
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
      //   106: getfield 47	com/tencent/mm/kernel/a/b/f$a:htb	Lcom/tencent/mm/kernel/a/b/h;
      //   109: getfield 100	com/tencent/mm/kernel/a/b/h:htm	Ljava/lang/Class;
      //   112: aastore
      //   113: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   116: aload_0
      //   117: getfield 40	com/tencent/mm/kernel/a/b/f$a:hsY	Z
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
      //   140: invokespecial 109	com/tencent/mm/kernel/a/b/f$a:aAR	()Z
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
    
    private void aAU()
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
          if (!this.hsY) {
            continue;
          }
          Log.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s resolved!", new Object[] { this, Boolean.valueOf(this.hsC), this.htb.hsF });
          AppMethodBeat.o(158385);
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.printErrStackTrace("MMSkeleton.ParallelsDependencies", localInterruptedException, "", new Object[0]);
          AppMethodBeat.o(158385);
          continue;
        }
        return;
        Log.i("MMSkeleton.ParallelsDependencies", "waiting resolved");
        Log.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s", new Object[] { this, Boolean.valueOf(this.hsC), this.htb.hsF });
        wait();
        Log.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s done", new Object[] { this, Boolean.valueOf(this.hsC), this.htb.hsF });
        AppMethodBeat.o(158385);
      }
    }
    
    public final void a(a.a parama)
    {
      AppMethodBeat.i(158381);
      super.a(parama);
      try
      {
        this.hsW += 1;
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
      if (!this.hsC) {
        if (!aAT())
        {
          Object localObject = aAD();
          Assert.assertNotNull(localObject);
          localObject = ((HashSet)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a.a locala = (a.a)((Iterator)localObject).next();
            if (!((a)locala).hsC) {
              Log.i("MMSkeleton.ParallelsDependencies", "ParallelsNode(%s) found it's depending node(%s) not consumed.", new Object[] { this, locala });
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          aAU();
        }
        this.htd.hte.hin();
        if (!this.hsC)
        {
          j.i("MMSkeleton.ParallelsDependencies", "Consume node(%s) on phase(%s) may after waiting resolved.", new Object[] { this, this.htb.hsF });
          parama.call(this);
          this.hsC = true;
        }
        this.htd.hte.done();
        AppMethodBeat.o(158382);
        return;
      }
    }
    
    /* Error */
    public final boolean aAS()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 195
      //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 80	com/tencent/mm/kernel/a/a/a$a:hsB	Ljava/lang/Object;
      //   13: astore 5
      //   15: aload_0
      //   16: getfield 47	com/tencent/mm/kernel/a/b/f$a:htb	Lcom/tencent/mm/kernel/a/b/h;
      //   19: getfield 56	com/tencent/mm/kernel/a/b/h:hsF	Ljava/lang/Class;
      //   22: astore 6
      //   24: aload_0
      //   25: getfield 40	com/tencent/mm/kernel/a/b/f$a:hsY	Z
      //   28: istore_3
      //   29: aload_0
      //   30: getfield 36	com/tencent/mm/kernel/a/b/f$a:hsW	I
      //   33: istore_1
      //   34: aload_0
      //   35: getfield 71	com/tencent/mm/kernel/a/b/f$a:hsZ	Lcom/tencent/mm/kernel/a/b/f$a;
      //   38: astore 7
      //   40: aload_0
      //   41: getfield 71	com/tencent/mm/kernel/a/b/f$a:hsZ	Lcom/tencent/mm/kernel/a/b/f$a;
      //   44: ifnull +88 -> 132
      //   47: aload_0
      //   48: getfield 71	com/tencent/mm/kernel/a/b/f$a:hsZ	Lcom/tencent/mm/kernel/a/b/f$a;
      //   51: getfield 74	com/tencent/mm/kernel/a/a/a$a:hsC	Z
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
      //   106: getfield 47	com/tencent/mm/kernel/a/b/f$a:htb	Lcom/tencent/mm/kernel/a/b/h;
      //   109: getfield 100	com/tencent/mm/kernel/a/b/h:htm	Ljava/lang/Class;
      //   112: aastore
      //   113: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   116: aload_0
      //   117: getfield 40	com/tencent/mm/kernel/a/b/f$a:hsY	Z
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
      //   140: invokespecial 109	com/tencent/mm/kernel/a/b/f$a:aAR	()Z
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
      //   161: getfield 74	com/tencent/mm/kernel/a/a/a$a:hsC	Z
      //   164: invokestatic 86	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   167: aastore
      //   168: dup
      //   169: iconst_2
      //   170: aload_0
      //   171: getfield 47	com/tencent/mm/kernel/a/b/f$a:htb	Lcom/tencent/mm/kernel/a/b/h;
      //   174: getfield 56	com/tencent/mm/kernel/a/b/h:hsF	Ljava/lang/Class;
      //   177: aastore
      //   178: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   181: aload_0
      //   182: iconst_1
      //   183: putfield 40	com/tencent/mm/kernel/a/b/f$a:hsY	Z
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
    
    public final boolean aAV()
    {
      try
      {
        AppMethodBeat.i(158386);
        this.hsW -= 1;
        boolean bool = aAS();
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
      String str = super.toString() + " - with type " + this.htb.hsF;
      AppMethodBeat.o(158387);
      return str;
    }
  }
  
  public static final class b
  {
    public b hte;
    
    public b()
    {
      AppMethodBeat.i(158388);
      this.hte = new b();
      AppMethodBeat.o(158388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.f
 * JD-Core Version:    0.7.0.1
 */