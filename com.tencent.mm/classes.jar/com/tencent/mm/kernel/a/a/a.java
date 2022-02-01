package com.tencent.mm.kernel.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class a<T>
{
  protected final ConcurrentHashMap<T, a<T>> mED;
  
  public a()
  {
    AppMethodBeat.i(158345);
    this.mED = new ConcurrentHashMap();
    AppMethodBeat.o(158345);
  }
  
  private static void cZ(T paramT)
  {
    AppMethodBeat.i(158349);
    Assert.assertNotNull("Found a null object, maybe your component isn't installedor registered.", paramT);
    Assert.assertFalse("Found a dummy object, maybe your component isn't installed or registered.", g.cR(paramT));
    AppMethodBeat.o(158349);
  }
  
  public final void D(T paramT1, T paramT2)
  {
    AppMethodBeat.i(158350);
    cZ(paramT1);
    cZ(paramT2);
    if (paramT1 == paramT2)
    {
      cW(paramT1).bbe();
      AppMethodBeat.o(158350);
      return;
    }
    cW(paramT1).a(cW(paramT2));
    AppMethodBeat.o(158350);
  }
  
  protected a<T> cW(T paramT)
  {
    AppMethodBeat.i(158346);
    if (!this.mED.containsKey(paramT)) {
      this.mED.putIfAbsent(paramT, new a(paramT));
    }
    paramT = (a)this.mED.get(paramT);
    AppMethodBeat.o(158346);
    return paramT;
  }
  
  public final a<T> cX(T paramT)
  {
    AppMethodBeat.i(158347);
    paramT = (a)this.mED.get(paramT);
    AppMethodBeat.o(158347);
    return paramT;
  }
  
  public final boolean cY(T paramT)
  {
    AppMethodBeat.i(158348);
    paramT = (a)this.mED.get(paramT);
    if ((paramT != null) && ((paramT.bbd()) || (paramT.bbf())))
    {
      AppMethodBeat.o(158348);
      return true;
    }
    AppMethodBeat.o(158348);
    return false;
  }
  
  public void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(158351);
    Iterator localIterator = this.mED.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).mEH = false;
    }
    AppMethodBeat.o(158351);
  }
  
  public static class a<T>
  {
    private HashSet<a> mEE;
    private HashSet<a> mEF;
    public T mEG;
    public volatile boolean mEH;
    private boolean mEI;
    
    protected a(T paramT)
    {
      AppMethodBeat.i(176013);
      this.mEH = false;
      this.mEI = true;
      Assert.assertNotNull("Subject should not be null!", paramT);
      this.mEG = paramT;
      AppMethodBeat.o(176013);
    }
    
    private void b(a parama)
    {
      try
      {
        AppMethodBeat.i(158341);
        this.mEI = false;
        if (this.mEE == null) {
          this.mEE = new HashSet(4);
        }
        this.mEE.add(parama);
        AppMethodBeat.o(158341);
        return;
      }
      finally {}
    }
    
    private void c(a parama)
    {
      try
      {
        AppMethodBeat.i(158342);
        if (this.mEF == null) {
          this.mEF = new HashSet(4);
        }
        this.mEF.add(parama);
        AppMethodBeat.o(158342);
        return;
      }
      finally {}
    }
    
    public void a(a parama)
    {
      AppMethodBeat.i(158340);
      b(parama);
      parama.c(this);
      AppMethodBeat.o(158340);
    }
    
    /* Error */
    public final HashSet<a> bba()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 75
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 67	com/tencent/mm/kernel/a/a/a$a:mEF	Ljava/util/HashSet;
      //   11: ifnonnull +14 -> 25
      //   14: aconst_null
      //   15: astore_1
      //   16: ldc 75
      //   18: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: areturn
      //   25: new 57	java/util/HashSet
      //   28: dup
      //   29: aload_0
      //   30: getfield 67	com/tencent/mm/kernel/a/a/a$a:mEF	Ljava/util/HashSet;
      //   33: invokespecial 78	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   36: astore_1
      //   37: ldc 75
      //   39: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    public final HashSet<a> bbb()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 81
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 55	com/tencent/mm/kernel/a/a/a$a:mEE	Ljava/util/HashSet;
      //   11: ifnonnull +14 -> 25
      //   14: aconst_null
      //   15: astore_1
      //   16: ldc 81
      //   18: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: areturn
      //   25: new 57	java/util/HashSet
      //   28: dup
      //   29: aload_0
      //   30: getfield 55	com/tencent/mm/kernel/a/a/a$a:mEE	Ljava/util/HashSet;
      //   33: invokespecial 78	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   36: astore_1
      //   37: ldc 81
      //   39: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    public final int bbc()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 84
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 55	com/tencent/mm/kernel/a/a/a$a:mEE	Ljava/util/HashSet;
      //   11: ifnonnull +14 -> 25
      //   14: iconst_0
      //   15: istore_1
      //   16: ldc 84
      //   18: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   21: aload_0
      //   22: monitorexit
      //   23: iload_1
      //   24: ireturn
      //   25: aload_0
      //   26: getfield 55	com/tencent/mm/kernel/a/a/a$a:mEE	Ljava/util/HashSet;
      //   29: invokevirtual 87	java/util/HashSet:size	()I
      //   32: istore_1
      //   33: ldc 84
      //   35: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public final boolean bbd()
    {
      try
      {
        boolean bool = this.mEI;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void bbe()
    {
      try
      {
        AppMethodBeat.i(158337);
        if ((this.mEE == null) || (this.mEE.size() == 0)) {
          this.mEI = true;
        }
        AppMethodBeat.o(158337);
        return;
      }
      finally {}
    }
    
    /* Error */
    public final boolean bbf()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 93
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 55	com/tencent/mm/kernel/a/a/a$a:mEE	Ljava/util/HashSet;
      //   11: ifnull +24 -> 35
      //   14: aload_0
      //   15: getfield 55	com/tencent/mm/kernel/a/a/a$a:mEE	Ljava/util/HashSet;
      //   18: invokevirtual 87	java/util/HashSet:size	()I
      //   21: ifle +14 -> 35
      //   24: iconst_1
      //   25: istore_1
      //   26: ldc 93
      //   28: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   31: aload_0
      //   32: monitorexit
      //   33: iload_1
      //   34: ireturn
      //   35: iconst_0
      //   36: istore_1
      //   37: ldc 93
      //   39: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(158344);
      if ((paramObject instanceof a))
      {
        bool = this.mEG.equals(((a)paramObject).mEG);
        AppMethodBeat.o(158344);
        return bool;
      }
      boolean bool = this.mEG.equals(paramObject);
      AppMethodBeat.o(158344);
      return bool;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(158343);
      int i = this.mEG.hashCode();
      AppMethodBeat.o(158343);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(158339);
      String str = "Ref-" + this.mEG.toString();
      AppMethodBeat.o(158339);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.a.a.a
 * JD-Core Version:    0.7.0.1
 */