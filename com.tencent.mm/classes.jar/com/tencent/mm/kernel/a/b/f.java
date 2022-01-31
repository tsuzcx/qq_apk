package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.b;
import com.tencent.mm.kernel.a.a.a.a;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ab;
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
  private c<T> eJT;
  private d<T> eJZ;
  public Class eKa;
  private volatile boolean eKb = false;
  
  public f(Class paramClass, d<T> paramd, c paramc)
  {
    this.eKa = paramClass;
    this.eJZ = paramd;
    this.eJT = paramc;
  }
  
  public final a<T> Sm()
  {
    AppMethodBeat.i(123340);
    a locala = this.eJZ.Sm();
    AppMethodBeat.o(123340);
    return locala;
  }
  
  public final List<a.a> St()
  {
    AppMethodBeat.i(123343);
    ArrayList localArrayList = new ArrayList(1);
    Iterator localIterator = this.eJE.values().iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (!((a)locala).eJI)
      {
        int i = ((a)locala).eKc;
        a locala1 = ((a)locala).eKf;
        if (((a)locala).eKf != null) {}
        for (Object localObject = Boolean.valueOf(((a)locala).eKf.eJI);; localObject = "")
        {
          ab.e("MMSkeleton.ParallelsDependencies", "ParallelsDependencies node(%s) not consumed!!!! %s, %s, %s", new Object[] { locala, Integer.valueOf(i), locala1, localObject });
          localArrayList.add(locala);
          break;
        }
      }
    }
    AppMethodBeat.o(123343);
    return localArrayList;
  }
  
  public final void a(a<T> parama)
  {
    AppMethodBeat.i(123341);
    parama = parama.Sf();
    if (parama != null)
    {
      parama = parama.iterator();
      while (parama.hasNext())
      {
        a locala = (a)parama.next();
        if (locala.Sy()) {
          this.eJZ.b(locala);
        }
      }
    }
    AppMethodBeat.o(123341);
  }
  
  public final a<T> aA(T paramT)
  {
    AppMethodBeat.i(123337);
    paramT = (a)this.eJE.get(paramT);
    AppMethodBeat.o(123337);
    return paramT;
  }
  
  public final void aB(Object paramObject)
  {
    AppMethodBeat.i(123342);
    a locala = (a)this.eJE.get(paramObject);
    if (locala.eJH != ((a)paramObject).eJH) {
      ab.e("MMSkeleton.ParallelsDependencies", "not same!!!! %s, %s, %s, %s", new Object[] { locala, locala.eJH, paramObject, this.eJE.get(paramObject) });
    }
    if ((this.eKb) && (locala.Sv())) {
      this.eJZ.b(locala);
    }
    AppMethodBeat.o(123342);
  }
  
  public final a.a<T> au(T paramT)
  {
    AppMethodBeat.i(123336);
    if (!this.eJE.containsKey(paramT)) {
      this.eJE.putIfAbsent(paramT, new a(paramT, this.eKa, this.eJT, (byte)0));
    }
    paramT = (a.a)this.eJE.get(paramT);
    AppMethodBeat.o(123336);
    return paramT;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(123339);
    ab.i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies for type %s", new Object[] { this.eKa });
    Assert.assertNotNull(this.eJZ);
    this.eKb = true;
    Iterator localIterator = this.eJE.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (a.a)localIterator.next();
      if (((a.a)localObject).Si())
      {
        localObject = (a)localObject;
        ab.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s", new Object[] { localObject });
        if (((a)localObject).Sv()) {
          this.eJZ.b((a)localObject);
        }
        ab.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s done", new Object[] { localObject });
      }
    }
    ab.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare %s done", new Object[] { this.eKa });
    AppMethodBeat.o(123339);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(123338);
    Iterator localIterator = this.eJE.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramBoolean) {
        locala.eJI = false;
      }
      try
      {
        locala.eKc = locala.Sh();
        locala.eKe = false;
      }
      finally
      {
        AppMethodBeat.o(123338);
      }
    }
    AppMethodBeat.o(123338);
  }
  
  public static final class a<T>
    extends a.a<T>
  {
    volatile int eKc;
    private boolean eKd;
    volatile boolean eKe;
    public volatile a eKf;
    public volatile a eKg;
    public h eKh;
    private c eKi;
    public f.b eKj;
    
    private a(T paramT, Class paramClass, c paramc)
    {
      super();
      AppMethodBeat.i(123327);
      this.eKc = 0;
      this.eKd = false;
      this.eKe = false;
      this.eKh = new h();
      this.eKj = new f.b();
      this.eKh.eJL = paramClass;
      this.eKi = paramc;
      AppMethodBeat.o(123327);
    }
    
    private boolean Su()
    {
      return (this.eKc == 0) && ((this.eKf == null) || (this.eKf.eJI));
    }
    
    /* Error */
    private boolean Sw()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 76
      //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 80	com/tencent/mm/kernel/a/a/a$a:eJH	Ljava/lang/Object;
      //   13: astore 5
      //   15: aload_0
      //   16: getfield 47	com/tencent/mm/kernel/a/b/f$a:eKh	Lcom/tencent/mm/kernel/a/b/h;
      //   19: getfield 56	com/tencent/mm/kernel/a/b/h:eJL	Ljava/lang/Class;
      //   22: astore 6
      //   24: aload_0
      //   25: getfield 40	com/tencent/mm/kernel/a/b/f$a:eKe	Z
      //   28: istore_3
      //   29: aload_0
      //   30: getfield 36	com/tencent/mm/kernel/a/b/f$a:eKc	I
      //   33: istore_1
      //   34: aload_0
      //   35: getfield 71	com/tencent/mm/kernel/a/b/f$a:eKf	Lcom/tencent/mm/kernel/a/b/f$a;
      //   38: astore 7
      //   40: aload_0
      //   41: getfield 71	com/tencent/mm/kernel/a/b/f$a:eKf	Lcom/tencent/mm/kernel/a/b/f$a;
      //   44: ifnull +88 -> 132
      //   47: aload_0
      //   48: getfield 71	com/tencent/mm/kernel/a/b/f$a:eKf	Lcom/tencent/mm/kernel/a/b/f$a;
      //   51: getfield 74	com/tencent/mm/kernel/a/a/a$a:eJI	Z
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
      //   106: getfield 47	com/tencent/mm/kernel/a/b/f$a:eKh	Lcom/tencent/mm/kernel/a/b/h;
      //   109: getfield 100	com/tencent/mm/kernel/a/b/h:eKt	Ljava/lang/Class;
      //   112: aastore
      //   113: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   116: aload_0
      //   117: getfield 40	com/tencent/mm/kernel/a/b/f$a:eKe	Z
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
      //   140: invokespecial 109	com/tencent/mm/kernel/a/b/f$a:Su	()Z
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
    
    private void Sx()
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(123332);
        }
        finally {}
        try
        {
          if (!this.eKe) {
            continue;
          }
          ab.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s resolved!", new Object[] { this, Boolean.valueOf(this.eJI), this.eKh.eJL });
          AppMethodBeat.o(123332);
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.printErrStackTrace("MMSkeleton.ParallelsDependencies", localInterruptedException, "", new Object[0]);
          AppMethodBeat.o(123332);
          continue;
        }
        return;
        ab.i("MMSkeleton.ParallelsDependencies", "waiting resolved");
        ab.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s", new Object[] { this, Boolean.valueOf(this.eJI), this.eKh.eJL });
        wait();
        ab.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s done", new Object[] { this, Boolean.valueOf(this.eJI), this.eKh.eJL });
        AppMethodBeat.o(123332);
      }
    }
    
    /* Error */
    public final boolean Sv()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 136
      //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 80	com/tencent/mm/kernel/a/a/a$a:eJH	Ljava/lang/Object;
      //   13: astore 5
      //   15: aload_0
      //   16: getfield 47	com/tencent/mm/kernel/a/b/f$a:eKh	Lcom/tencent/mm/kernel/a/b/h;
      //   19: getfield 56	com/tencent/mm/kernel/a/b/h:eJL	Ljava/lang/Class;
      //   22: astore 6
      //   24: aload_0
      //   25: getfield 40	com/tencent/mm/kernel/a/b/f$a:eKe	Z
      //   28: istore_3
      //   29: aload_0
      //   30: getfield 36	com/tencent/mm/kernel/a/b/f$a:eKc	I
      //   33: istore_1
      //   34: aload_0
      //   35: getfield 71	com/tencent/mm/kernel/a/b/f$a:eKf	Lcom/tencent/mm/kernel/a/b/f$a;
      //   38: astore 7
      //   40: aload_0
      //   41: getfield 71	com/tencent/mm/kernel/a/b/f$a:eKf	Lcom/tencent/mm/kernel/a/b/f$a;
      //   44: ifnull +88 -> 132
      //   47: aload_0
      //   48: getfield 71	com/tencent/mm/kernel/a/b/f$a:eKf	Lcom/tencent/mm/kernel/a/b/f$a;
      //   51: getfield 74	com/tencent/mm/kernel/a/a/a$a:eJI	Z
      //   54: invokestatic 86	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   57: astore 4
      //   59: ldc 88
      //   61: ldc 138
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
      //   106: getfield 47	com/tencent/mm/kernel/a/b/f$a:eKh	Lcom/tencent/mm/kernel/a/b/h;
      //   109: getfield 100	com/tencent/mm/kernel/a/b/h:eKt	Ljava/lang/Class;
      //   112: aastore
      //   113: invokestatic 118	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   116: aload_0
      //   117: getfield 40	com/tencent/mm/kernel/a/b/f$a:eKe	Z
      //   120: ifeq +19 -> 139
      //   123: ldc 136
      //   125: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   128: aload_0
      //   129: monitorexit
      //   130: iload_2
      //   131: ireturn
      //   132: ldc 107
      //   134: astore 4
      //   136: goto -77 -> 59
      //   139: aload_0
      //   140: invokespecial 109	com/tencent/mm/kernel/a/b/f$a:Su	()Z
      //   143: ifeq +57 -> 200
      //   146: ldc 88
      //   148: ldc 140
      //   150: iconst_3
      //   151: anewarray 92	java/lang/Object
      //   154: dup
      //   155: iconst_0
      //   156: aload_0
      //   157: aastore
      //   158: dup
      //   159: iconst_1
      //   160: aload_0
      //   161: getfield 74	com/tencent/mm/kernel/a/a/a$a:eJI	Z
      //   164: invokestatic 86	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   167: aastore
      //   168: dup
      //   169: iconst_2
      //   170: aload_0
      //   171: getfield 47	com/tencent/mm/kernel/a/b/f$a:eKh	Lcom/tencent/mm/kernel/a/b/h;
      //   174: getfield 56	com/tencent/mm/kernel/a/b/h:eJL	Ljava/lang/Class;
      //   177: aastore
      //   178: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   181: aload_0
      //   182: iconst_1
      //   183: putfield 40	com/tencent/mm/kernel/a/b/f$a:eKe	Z
      //   186: aload_0
      //   187: invokevirtual 143	java/lang/Object:notify	()V
      //   190: ldc 136
      //   192: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   195: iconst_1
      //   196: istore_2
      //   197: goto -69 -> 128
      //   200: ldc 136
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
    
    public final boolean Sy()
    {
      try
      {
        AppMethodBeat.i(123333);
        this.eKc -= 1;
        boolean bool = Sv();
        AppMethodBeat.o(123333);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void a(a.a parama)
    {
      AppMethodBeat.i(123328);
      super.a(parama);
      try
      {
        this.eKc += 1;
        return;
      }
      finally
      {
        AppMethodBeat.o(123328);
      }
    }
    
    public final void a(com.tencent.mm.vending.c.a parama)
    {
      AppMethodBeat.i(123329);
      if (!this.eJI) {
        if (!Sw())
        {
          Object localObject = Sg();
          Assert.assertNotNull(localObject);
          localObject = ((HashSet)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a.a locala = (a.a)((Iterator)localObject).next();
            if (!((a)locala).eJI) {
              ab.i("MMSkeleton.ParallelsDependencies", "ParallelsNode(%s) found it's depending node(%s) not consumed.", new Object[] { this, locala });
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          Sx();
        }
        this.eKj.eKk.dTf();
        if (!this.eJI)
        {
          j.i("MMSkeleton.ParallelsDependencies", "Consume node(%s) on phase(%s) may after waiting resolved.", new Object[] { this, this.eKh.eJL });
          parama.call(this);
          this.eJI = true;
        }
        this.eKj.eKk.done();
        AppMethodBeat.o(123329);
        return;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(123334);
      String str = super.toString() + " - with type " + this.eKh.eJL;
      AppMethodBeat.o(123334);
      return str;
    }
  }
  
  public static final class b
  {
    public b eKk;
    
    public b()
    {
      AppMethodBeat.i(123335);
      this.eKk = new b();
      AppMethodBeat.o(123335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.f
 * JD-Core Version:    0.7.0.1
 */