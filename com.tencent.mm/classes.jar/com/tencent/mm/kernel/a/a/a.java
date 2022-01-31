package com.tencent.mm.kernel.a.a;

import com.tencent.mm.kernel.f;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class a<T>
{
  public final ConcurrentHashMap<T, a<T>> dMd = new ConcurrentHashMap();
  
  private static void am(T paramT)
  {
    Assert.assertNotNull("Found a null object, maybe your component isn't installedor registered.", paramT);
    Assert.assertFalse("Found a dummy object, maybe your component isn't installed or registered.", f.af(paramT));
  }
  
  public a<T> ak(T paramT)
  {
    if (!this.dMd.containsKey(paramT)) {
      this.dMd.putIfAbsent(paramT, new a(paramT));
    }
    return (a)this.dMd.get(paramT);
  }
  
  public final a<T> al(T paramT)
  {
    return (a)this.dMd.get(paramT);
  }
  
  public final void i(T paramT1, T paramT2)
  {
    am(paramT1);
    am(paramT2);
    if (paramT1 == paramT2)
    {
      ak(paramT1).Ef();
      return;
    }
    ak(paramT1).a(ak(paramT2));
  }
  
  public static class a<T>
  {
    private HashSet<a> dMe;
    private HashSet<a> dMf;
    public T dMg;
    public volatile boolean dMh = false;
    private boolean dMi = true;
    
    public a(T paramT)
    {
      this.dMg = paramT;
    }
    
    private void b(a parama)
    {
      try
      {
        this.dMi = false;
        if (this.dMe == null) {
          this.dMe = new HashSet(4);
        }
        this.dMe.add(parama);
        return;
      }
      finally {}
    }
    
    private void c(a parama)
    {
      try
      {
        if (this.dMf == null) {
          this.dMf = new HashSet(4);
        }
        this.dMf.add(parama);
        return;
      }
      finally {}
    }
    
    /* Error */
    public final HashSet<a> Eb()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 48	com/tencent/mm/kernel/a/a/a$a:dMf	Ljava/util/HashSet;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull +9 -> 17
      //   11: aconst_null
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: areturn
      //   17: new 38	java/util/HashSet
      //   20: dup
      //   21: aload_0
      //   22: getfield 48	com/tencent/mm/kernel/a/a/a$a:dMf	Ljava/util/HashSet;
      //   25: invokespecial 53	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   28: astore_1
      //   29: goto -16 -> 13
      //   32: astore_1
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_1
      //   36: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	37	0	this	a
      //   6	23	1	localHashSet	HashSet
      //   32	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	32	finally
      //   17	29	32	finally
    }
    
    /* Error */
    public final HashSet<a> Ec()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 36	com/tencent/mm/kernel/a/a/a$a:dMe	Ljava/util/HashSet;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull +9 -> 17
      //   11: aconst_null
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: areturn
      //   17: new 38	java/util/HashSet
      //   20: dup
      //   21: aload_0
      //   22: getfield 36	com/tencent/mm/kernel/a/a/a$a:dMe	Ljava/util/HashSet;
      //   25: invokespecial 53	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   28: astore_1
      //   29: goto -16 -> 13
      //   32: astore_1
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_1
      //   36: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	37	0	this	a
      //   6	23	1	localHashSet	HashSet
      //   32	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	32	finally
      //   17	29	32	finally
    }
    
    /* Error */
    public final int Ed()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 36	com/tencent/mm/kernel/a/a/a$a:dMe	Ljava/util/HashSet;
      //   6: astore_2
      //   7: aload_2
      //   8: ifnonnull +9 -> 17
      //   11: iconst_0
      //   12: istore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_1
      //   16: ireturn
      //   17: aload_0
      //   18: getfield 36	com/tencent/mm/kernel/a/a/a$a:dMe	Ljava/util/HashSet;
      //   21: invokevirtual 60	java/util/HashSet:size	()I
      //   24: istore_1
      //   25: goto -12 -> 13
      //   28: astore_2
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_2
      //   32: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	33	0	this	a
      //   12	13	1	i	int
      //   6	2	2	localHashSet	HashSet
      //   28	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	28	finally
      //   17	25	28	finally
    }
    
    public final boolean Ee()
    {
      try
      {
        boolean bool = this.dMi;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void Ef()
    {
      try
      {
        if ((this.dMe == null) || (this.dMe.size() == 0)) {
          this.dMi = true;
        }
        return;
      }
      finally {}
    }
    
    /* Error */
    public final boolean Eg()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 36	com/tencent/mm/kernel/a/a/a$a:dMe	Ljava/util/HashSet;
      //   6: ifnull +21 -> 27
      //   9: aload_0
      //   10: getfield 36	com/tencent/mm/kernel/a/a/a$a:dMe	Ljava/util/HashSet;
      //   13: invokevirtual 60	java/util/HashSet:size	()I
      //   16: istore_1
      //   17: iload_1
      //   18: ifle +9 -> 27
      //   21: iconst_1
      //   22: istore_2
      //   23: aload_0
      //   24: monitorexit
      //   25: iload_2
      //   26: ireturn
      //   27: iconst_0
      //   28: istore_2
      //   29: goto -6 -> 23
      //   32: astore_3
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_3
      //   36: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	37	0	this	a
      //   16	2	1	i	int
      //   22	7	2	bool	boolean
      //   32	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	17	32	finally
    }
    
    public void a(a parama)
    {
      b(parama);
      parama.c(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof a)) {
        return this.dMg.equals(((a)paramObject).dMg);
      }
      return this.dMg.equals(paramObject);
    }
    
    public int hashCode()
    {
      return this.dMg.hashCode();
    }
    
    public String toString()
    {
      return "Ref-" + this.dMg.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.a.a
 * JD-Core Version:    0.7.0.1
 */