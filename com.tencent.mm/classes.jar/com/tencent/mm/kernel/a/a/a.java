package com.tencent.mm.kernel.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class a<T>
{
  protected final ConcurrentHashMap<T, a<T>> eJE;
  
  public a()
  {
    AppMethodBeat.i(123292);
    this.eJE = new ConcurrentHashMap();
    AppMethodBeat.o(123292);
  }
  
  private static void ax(T paramT)
  {
    AppMethodBeat.i(123296);
    Assert.assertNotNull("Found a null object, maybe your component isn't installedor registered.", paramT);
    Assert.assertFalse("Found a dummy object, maybe your component isn't installed or registered.", f.an(paramT));
    AppMethodBeat.o(123296);
  }
  
  protected a<T> au(T paramT)
  {
    AppMethodBeat.i(123293);
    if (!this.eJE.containsKey(paramT)) {
      this.eJE.putIfAbsent(paramT, new a(paramT));
    }
    paramT = (a)this.eJE.get(paramT);
    AppMethodBeat.o(123293);
    return paramT;
  }
  
  public final a<T> av(T paramT)
  {
    AppMethodBeat.i(123294);
    paramT = (a)this.eJE.get(paramT);
    AppMethodBeat.o(123294);
    return paramT;
  }
  
  public final boolean aw(T paramT)
  {
    AppMethodBeat.i(123295);
    paramT = (a)this.eJE.get(paramT);
    if ((paramT != null) && ((paramT.Si()) || (paramT.Sk())))
    {
      AppMethodBeat.o(123295);
      return true;
    }
    AppMethodBeat.o(123295);
    return false;
  }
  
  public final void i(T paramT1, T paramT2)
  {
    AppMethodBeat.i(123297);
    ax(paramT1);
    ax(paramT2);
    if (paramT1 == paramT2)
    {
      au(paramT1).Sj();
      AppMethodBeat.o(123297);
      return;
    }
    au(paramT1).a(au(paramT2));
    AppMethodBeat.o(123297);
  }
  
  public void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(123298);
    Iterator localIterator = this.eJE.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).eJI = false;
    }
    AppMethodBeat.o(123298);
  }
  
  public static class a<T>
  {
    private HashSet<a> eJF;
    private HashSet<a> eJG;
    public T eJH;
    public volatile boolean eJI = false;
    private boolean eJJ = true;
    
    protected a(T paramT)
    {
      this.eJH = paramT;
    }
    
    private void b(a parama)
    {
      try
      {
        AppMethodBeat.i(123288);
        this.eJJ = false;
        if (this.eJF == null) {
          this.eJF = new HashSet(4);
        }
        this.eJF.add(parama);
        AppMethodBeat.o(123288);
        return;
      }
      finally {}
    }
    
    private void c(a parama)
    {
      try
      {
        AppMethodBeat.i(123289);
        if (this.eJG == null) {
          this.eJG = new HashSet(4);
        }
        this.eJG.add(parama);
        AppMethodBeat.o(123289);
        return;
      }
      finally {}
    }
    
    /* Error */
    public final HashSet<a> Sf()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 61
      //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 58	com/tencent/mm/kernel/a/a/a$a:eJG	Ljava/util/HashSet;
      //   11: ifnonnull +14 -> 25
      //   14: aconst_null
      //   15: astore_1
      //   16: ldc 61
      //   18: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: areturn
      //   25: new 45	java/util/HashSet
      //   28: dup
      //   29: aload_0
      //   30: getfield 58	com/tencent/mm/kernel/a/a/a$a:eJG	Ljava/util/HashSet;
      //   33: invokespecial 64	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   36: astore_1
      //   37: ldc 61
      //   39: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: goto -21 -> 21
      //   45: astore_1
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_1
      //   49: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	50	0	this	a
      //   15	22	1	localObject1	Object
      //   45	4	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	14	45	finally
      //   16	21	45	finally
      //   25	42	45	finally
    }
    
    /* Error */
    public final HashSet<a> Sg()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 67
      //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 43	com/tencent/mm/kernel/a/a/a$a:eJF	Ljava/util/HashSet;
      //   11: ifnonnull +14 -> 25
      //   14: aconst_null
      //   15: astore_1
      //   16: ldc 67
      //   18: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: areturn
      //   25: new 45	java/util/HashSet
      //   28: dup
      //   29: aload_0
      //   30: getfield 43	com/tencent/mm/kernel/a/a/a$a:eJF	Ljava/util/HashSet;
      //   33: invokespecial 64	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   36: astore_1
      //   37: ldc 67
      //   39: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: goto -21 -> 21
      //   45: astore_1
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_1
      //   49: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	50	0	this	a
      //   15	22	1	localObject1	Object
      //   45	4	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	14	45	finally
      //   16	21	45	finally
      //   25	42	45	finally
    }
    
    /* Error */
    public final int Sh()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 70
      //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 43	com/tencent/mm/kernel/a/a/a$a:eJF	Ljava/util/HashSet;
      //   11: ifnonnull +14 -> 25
      //   14: iconst_0
      //   15: istore_1
      //   16: ldc 70
      //   18: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   21: aload_0
      //   22: monitorexit
      //   23: iload_1
      //   24: ireturn
      //   25: aload_0
      //   26: getfield 43	com/tencent/mm/kernel/a/a/a$a:eJF	Ljava/util/HashSet;
      //   29: invokevirtual 73	java/util/HashSet:size	()I
      //   32: istore_1
      //   33: ldc 70
      //   35: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   38: goto -17 -> 21
      //   41: astore_2
      //   42: aload_0
      //   43: monitorexit
      //   44: aload_2
      //   45: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	46	0	this	a
      //   15	18	1	i	int
      //   41	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	14	41	finally
      //   16	21	41	finally
      //   25	38	41	finally
    }
    
    public final boolean Si()
    {
      try
      {
        boolean bool = this.eJJ;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void Sj()
    {
      try
      {
        AppMethodBeat.i(123284);
        if ((this.eJF == null) || (this.eJF.size() == 0)) {
          this.eJJ = true;
        }
        AppMethodBeat.o(123284);
        return;
      }
      finally {}
    }
    
    /* Error */
    public final boolean Sk()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 79
      //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 43	com/tencent/mm/kernel/a/a/a$a:eJF	Ljava/util/HashSet;
      //   11: ifnull +24 -> 35
      //   14: aload_0
      //   15: getfield 43	com/tencent/mm/kernel/a/a/a$a:eJF	Ljava/util/HashSet;
      //   18: invokevirtual 73	java/util/HashSet:size	()I
      //   21: ifle +14 -> 35
      //   24: iconst_1
      //   25: istore_1
      //   26: ldc 79
      //   28: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   31: aload_0
      //   32: monitorexit
      //   33: iload_1
      //   34: ireturn
      //   35: iconst_0
      //   36: istore_1
      //   37: ldc 79
      //   39: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: goto -11 -> 31
      //   45: astore_2
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_2
      //   49: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	50	0	this	a
      //   25	12	1	bool	boolean
      //   45	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	24	45	finally
      //   26	31	45	finally
      //   37	42	45	finally
    }
    
    public void a(a parama)
    {
      AppMethodBeat.i(123287);
      b(parama);
      parama.c(this);
      AppMethodBeat.o(123287);
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(123291);
      if ((paramObject instanceof a))
      {
        bool = this.eJH.equals(((a)paramObject).eJH);
        AppMethodBeat.o(123291);
        return bool;
      }
      boolean bool = this.eJH.equals(paramObject);
      AppMethodBeat.o(123291);
      return bool;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(123290);
      int i = this.eJH.hashCode();
      AppMethodBeat.o(123290);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(123286);
      String str = "Ref-" + this.eJH.toString();
      AppMethodBeat.o(123286);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.a.a
 * JD-Core Version:    0.7.0.1
 */