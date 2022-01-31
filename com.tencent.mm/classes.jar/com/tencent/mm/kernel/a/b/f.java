package com.tencent.mm.kernel.a.b;

import com.tencent.mm.ck.b;
import com.tencent.mm.kernel.a.a.a.a;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.y;
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
  private c<T> dMs;
  d<T> dMy;
  public Class dMz;
  volatile boolean mTriggered = false;
  
  public f(Class paramClass, d<T> paramd, c paramc)
  {
    this.dMz = paramClass;
    this.dMy = paramd;
    paramClass = paramc;
    if (paramc == null) {
      paramClass = this;
    }
    this.dMs = paramClass;
  }
  
  public final a<T> Ei()
  {
    return this.dMy.Ei();
  }
  
  public final List<a.a> Ep()
  {
    ArrayList localArrayList = new ArrayList(1);
    Iterator localIterator = this.dMd.values().iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (!((a)locala).dMh)
      {
        int i = ((a)locala).dMA;
        a locala1 = ((a)locala).dMD;
        if (((a)locala).dMD != null) {}
        for (Object localObject = Boolean.valueOf(((a)locala).dMD.dMh);; localObject = "")
        {
          y.e("MMSkeleton.ParallelsDependencies", "ParallelsDependencies node(%s) not consumed!!!! %s, %s, %s", new Object[] { locala, Integer.valueOf(i), locala1, localObject });
          localArrayList.add(locala);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public final void a(a<T> parama)
  {
    parama = parama.Eb();
    if (parama != null)
    {
      parama = parama.iterator();
      while (parama.hasNext())
      {
        a locala = (a)parama.next();
        if (locala.Eu()) {
          this.dMy.b(locala);
        }
      }
    }
  }
  
  protected final a.a<T> ak(T paramT)
  {
    if (!this.dMd.containsKey(paramT)) {
      this.dMd.putIfAbsent(paramT, new a(paramT, this.dMz, this.dMs, (byte)0));
    }
    return (a.a)this.dMd.get(paramT);
  }
  
  public final a<T> ap(T paramT)
  {
    return (a)this.dMd.get(paramT);
  }
  
  public final void prepare()
  {
    y.i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies for type %s", new Object[] { this.dMz });
    Assert.assertNotNull(this.dMy);
    this.mTriggered = true;
    Iterator localIterator = this.dMd.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (a.a)localIterator.next();
      if (((a.a)localObject).Ee())
      {
        localObject = (a)localObject;
        y.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s", new Object[] { localObject });
        if (((a)localObject).Er()) {
          this.dMy.b((a)localObject);
        }
        y.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s done", new Object[] { localObject });
      }
    }
    y.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare %s done", new Object[] { this.dMz });
  }
  
  public static final class a<T>
    extends a.a<T>
  {
    volatile int dMA = 0;
    private boolean dMB = false;
    volatile boolean dMC = false;
    public volatile a dMD;
    public volatile a dME;
    public h dMF = new h();
    private c dMG;
    public f.b dMH = new f.b();
    
    private a(T paramT, Class paramClass, c paramc)
    {
      super();
      this.dMF.dMk = paramClass;
      this.dMG = paramc;
    }
    
    private boolean Eq()
    {
      return (this.dMA == 0) && ((this.dMD == null) || (this.dMD.dMh));
    }
    
    /* Error */
    private boolean Es()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 69	com/tencent/mm/kernel/a/a/a$a:dMg	Ljava/lang/Object;
      //   8: astore 5
      //   10: aload_0
      //   11: getfield 40	com/tencent/mm/kernel/a/b/f$a:dMF	Lcom/tencent/mm/kernel/a/b/h;
      //   14: getfield 49	com/tencent/mm/kernel/a/b/h:dMk	Ljava/lang/Class;
      //   17: astore 6
      //   19: aload_0
      //   20: getfield 33	com/tencent/mm/kernel/a/b/f$a:dMC	Z
      //   23: istore_3
      //   24: aload_0
      //   25: getfield 29	com/tencent/mm/kernel/a/b/f$a:dMA	I
      //   28: istore_1
      //   29: aload_0
      //   30: getfield 61	com/tencent/mm/kernel/a/b/f$a:dMD	Lcom/tencent/mm/kernel/a/b/f$a;
      //   33: astore 7
      //   35: aload_0
      //   36: getfield 61	com/tencent/mm/kernel/a/b/f$a:dMD	Lcom/tencent/mm/kernel/a/b/f$a;
      //   39: ifnull +85 -> 124
      //   42: aload_0
      //   43: getfield 61	com/tencent/mm/kernel/a/b/f$a:dMD	Lcom/tencent/mm/kernel/a/b/f$a;
      //   46: getfield 64	com/tencent/mm/kernel/a/a/a$a:dMh	Z
      //   49: invokestatic 75	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   52: astore 4
      //   54: ldc 77
      //   56: ldc 79
      //   58: bipush 7
      //   60: anewarray 81	java/lang/Object
      //   63: dup
      //   64: iconst_0
      //   65: aload 5
      //   67: aastore
      //   68: dup
      //   69: iconst_1
      //   70: aload 6
      //   72: aastore
      //   73: dup
      //   74: iconst_2
      //   75: iload_3
      //   76: invokestatic 75	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   79: aastore
      //   80: dup
      //   81: iconst_3
      //   82: iload_1
      //   83: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   86: aastore
      //   87: dup
      //   88: iconst_4
      //   89: aload 7
      //   91: aastore
      //   92: dup
      //   93: iconst_5
      //   94: aload 4
      //   96: aastore
      //   97: dup
      //   98: bipush 6
      //   100: aload_0
      //   101: getfield 40	com/tencent/mm/kernel/a/b/f$a:dMF	Lcom/tencent/mm/kernel/a/b/h;
      //   104: getfield 89	com/tencent/mm/kernel/a/b/h:dMR	Ljava/lang/Class;
      //   107: aastore
      //   108: invokestatic 95	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   111: aload_0
      //   112: getfield 33	com/tencent/mm/kernel/a/b/f$a:dMC	Z
      //   115: istore_3
      //   116: iload_3
      //   117: ifeq +14 -> 131
      //   120: aload_0
      //   121: monitorexit
      //   122: iload_2
      //   123: ireturn
      //   124: ldc 97
      //   126: astore 4
      //   128: goto -74 -> 54
      //   131: aload_0
      //   132: invokespecial 99	com/tencent/mm/kernel/a/b/f$a:Eq	()Z
      //   135: istore_2
      //   136: goto -16 -> 120
      //   139: astore 4
      //   141: aload_0
      //   142: monitorexit
      //   143: aload 4
      //   145: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	146	0	this	a
      //   28	55	1	i	int
      //   1	135	2	bool1	boolean
      //   23	94	3	bool2	boolean
      //   52	75	4	localObject1	Object
      //   139	5	4	localObject2	Object
      //   8	58	5	localObject3	Object
      //   17	54	6	localClass	Class
      //   33	57	7	locala	a
      // Exception table:
      //   from	to	target	type
      //   4	54	139	finally
      //   54	116	139	finally
      //   131	136	139	finally
    }
    
    private void Et()
    {
      try
      {
        if (this.dMC) {
          y.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s resolved!", new Object[] { this, Boolean.valueOf(this.dMh), this.dMF.dMk });
        }
        for (;;)
        {
          return;
          y.i("MMSkeleton.ParallelsDependencies", "waiting resolved");
          y.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s", new Object[] { this, Boolean.valueOf(this.dMh), this.dMF.dMk });
          wait();
          y.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s done", new Object[] { this, Boolean.valueOf(this.dMh), this.dMF.dMk });
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          y.printErrStackTrace("MMSkeleton.ParallelsDependencies", localInterruptedException, "", new Object[0]);
        }
      }
      finally {}
    }
    
    /* Error */
    public final boolean Er()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 69	com/tencent/mm/kernel/a/a/a$a:dMg	Ljava/lang/Object;
      //   8: astore 5
      //   10: aload_0
      //   11: getfield 40	com/tencent/mm/kernel/a/b/f$a:dMF	Lcom/tencent/mm/kernel/a/b/h;
      //   14: getfield 49	com/tencent/mm/kernel/a/b/h:dMk	Ljava/lang/Class;
      //   17: astore 6
      //   19: aload_0
      //   20: getfield 33	com/tencent/mm/kernel/a/b/f$a:dMC	Z
      //   23: istore_3
      //   24: aload_0
      //   25: getfield 29	com/tencent/mm/kernel/a/b/f$a:dMA	I
      //   28: istore_1
      //   29: aload_0
      //   30: getfield 61	com/tencent/mm/kernel/a/b/f$a:dMD	Lcom/tencent/mm/kernel/a/b/f$a;
      //   33: astore 7
      //   35: aload_0
      //   36: getfield 61	com/tencent/mm/kernel/a/b/f$a:dMD	Lcom/tencent/mm/kernel/a/b/f$a;
      //   39: ifnull +85 -> 124
      //   42: aload_0
      //   43: getfield 61	com/tencent/mm/kernel/a/b/f$a:dMD	Lcom/tencent/mm/kernel/a/b/f$a;
      //   46: getfield 64	com/tencent/mm/kernel/a/a/a$a:dMh	Z
      //   49: invokestatic 75	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   52: astore 4
      //   54: ldc 77
      //   56: ldc 126
      //   58: bipush 7
      //   60: anewarray 81	java/lang/Object
      //   63: dup
      //   64: iconst_0
      //   65: aload 5
      //   67: aastore
      //   68: dup
      //   69: iconst_1
      //   70: aload 6
      //   72: aastore
      //   73: dup
      //   74: iconst_2
      //   75: iload_3
      //   76: invokestatic 75	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   79: aastore
      //   80: dup
      //   81: iconst_3
      //   82: iload_1
      //   83: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   86: aastore
      //   87: dup
      //   88: iconst_4
      //   89: aload 7
      //   91: aastore
      //   92: dup
      //   93: iconst_5
      //   94: aload 4
      //   96: aastore
      //   97: dup
      //   98: bipush 6
      //   100: aload_0
      //   101: getfield 40	com/tencent/mm/kernel/a/b/f$a:dMF	Lcom/tencent/mm/kernel/a/b/h;
      //   104: getfield 89	com/tencent/mm/kernel/a/b/h:dMR	Ljava/lang/Class;
      //   107: aastore
      //   108: invokestatic 107	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   111: aload_0
      //   112: getfield 33	com/tencent/mm/kernel/a/b/f$a:dMC	Z
      //   115: istore_3
      //   116: iload_3
      //   117: ifeq +14 -> 131
      //   120: aload_0
      //   121: monitorexit
      //   122: iload_2
      //   123: ireturn
      //   124: ldc 97
      //   126: astore 4
      //   128: goto -74 -> 54
      //   131: aload_0
      //   132: invokespecial 99	com/tencent/mm/kernel/a/b/f$a:Eq	()Z
      //   135: ifeq -15 -> 120
      //   138: ldc 77
      //   140: ldc 128
      //   142: iconst_3
      //   143: anewarray 81	java/lang/Object
      //   146: dup
      //   147: iconst_0
      //   148: aload_0
      //   149: aastore
      //   150: dup
      //   151: iconst_1
      //   152: aload_0
      //   153: getfield 64	com/tencent/mm/kernel/a/a/a$a:dMh	Z
      //   156: invokestatic 75	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   159: aastore
      //   160: dup
      //   161: iconst_2
      //   162: aload_0
      //   163: getfield 40	com/tencent/mm/kernel/a/b/f$a:dMF	Lcom/tencent/mm/kernel/a/b/h;
      //   166: getfield 49	com/tencent/mm/kernel/a/b/h:dMk	Ljava/lang/Class;
      //   169: aastore
      //   170: invokestatic 95	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   173: aload_0
      //   174: iconst_1
      //   175: putfield 33	com/tencent/mm/kernel/a/b/f$a:dMC	Z
      //   178: aload_0
      //   179: invokevirtual 131	java/lang/Object:notify	()V
      //   182: iconst_1
      //   183: istore_2
      //   184: goto -64 -> 120
      //   187: astore 4
      //   189: aload_0
      //   190: monitorexit
      //   191: aload 4
      //   193: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	194	0	this	a
      //   28	55	1	i	int
      //   1	183	2	bool1	boolean
      //   23	94	3	bool2	boolean
      //   52	75	4	localObject1	Object
      //   187	5	4	localObject2	Object
      //   8	58	5	localObject3	Object
      //   17	54	6	localClass	Class
      //   33	57	7	locala	a
      // Exception table:
      //   from	to	target	type
      //   4	54	187	finally
      //   54	116	187	finally
      //   131	182	187	finally
    }
    
    public final boolean Eu()
    {
      try
      {
        this.dMA -= 1;
        boolean bool = Er();
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
      super.a(parama);
      try
      {
        this.dMA += 1;
        return;
      }
      finally {}
    }
    
    public final void a(com.tencent.mm.vending.c.a parama)
    {
      if (!this.dMh) {
        if (!Es())
        {
          Object localObject = Ec();
          Assert.assertNotNull(localObject);
          localObject = ((HashSet)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a.a locala = (a.a)((Iterator)localObject).next();
            if (!((a)locala).dMh) {
              y.i("MMSkeleton.ParallelsDependencies", "ParallelsNode(%s) found it's depending node(%s) not consumed.", new Object[] { this, locala });
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          Et();
        }
        this.dMH.dMI.cNA();
        if (!this.dMh)
        {
          k.i("MMSkeleton.ParallelsDependencies", "Consume node(%s) on phase(%s) may after waiting resolved.", new Object[] { this, this.dMF.dMk });
          parama.call(this);
          this.dMh = true;
        }
        this.dMH.dMI.done();
        return;
      }
    }
    
    public final String toString()
    {
      return super.toString() + " - with type " + this.dMF.dMk;
    }
  }
  
  public static final class b
  {
    public b dMI = new b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.f
 * JD-Core Version:    0.7.0.1
 */