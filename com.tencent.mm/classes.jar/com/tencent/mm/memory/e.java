package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.y;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable>
{
  protected NavigableMap<S, d<T, S>> dOX = new ConcurrentSkipListMap();
  private Vector<e<T, S>.a> dOY = new Vector();
  protected long dOZ = 0L;
  
  private void bz(long paramLong)
  {
    try
    {
      this.dOZ += paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract long ER();
  
  public abstract long ES();
  
  public void ET()
  {
    y.i("MicroMsg.BucketPool", "freeAll: %s", new Object[] { getClass().getName() });
    this.dOX.clear();
    this.dOZ = 0L;
  }
  
  public final void EV()
  {
    if (this.dOY.size() > 0) {
      com.tencent.mm.sdk.f.e.post(new e.1(this), "BucketPool_preload");
    }
  }
  
  /* Error */
  public T a(S paramS)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mm/memory/e:dOX	Ljava/util/NavigableMap;
    //   6: aload_1
    //   7: invokeinterface 152 2 0
    //   12: checkcast 96	com/tencent/mm/memory/d
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +43 -> 60
    //   20: aload_2
    //   21: invokevirtual 111	com/tencent/mm/memory/d:size	()I
    //   24: ifle +36 -> 60
    //   27: aload_2
    //   28: invokevirtual 156	com/tencent/mm/memory/d:pop	()Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 25	com/tencent/mm/memory/e:dOX	Ljava/util/NavigableMap;
    //   36: aload_2
    //   37: invokevirtual 159	com/tencent/mm/memory/d:EU	()Ljava/lang/Object;
    //   40: aload_2
    //   41: invokeinterface 118 3 0
    //   46: pop
    //   47: aload_0
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 104	com/tencent/mm/memory/e:as	(Ljava/lang/Object;)J
    //   53: invokevirtual 162	com/tencent/mm/memory/e:bA	(J)V
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: areturn
    //   60: ldc 68
    //   62: ldc 164
    //   64: iconst_1
    //   65: anewarray 5	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: invokestatic 113	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aconst_null
    //   76: astore_1
    //   77: goto -21 -> 56
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	e
    //   0	85	1	paramS	S
    //   15	26	2	locald	d
    // Exception table:
    //   from	to	target	type
    //   2	16	80	finally
    //   20	56	80	finally
    //   60	75	80	finally
  }
  
  public final void a(e<T, S>.a parame)
  {
    this.dOY.add(parame);
    y.i("MicroMsg.BucketPool", "%s addPreload: %s", new Object[] { this, parame });
    EV();
  }
  
  public void ar(T paramT)
  {
    if (paramT == null) {}
    for (;;)
    {
      return;
      Comparable localComparable;
      long l;
      try
      {
        localComparable = at(paramT);
        l = as(paramT);
        if (l > ES())
        {
          y.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", new Object[] { Long.valueOf(l) });
          continue;
        }
      }
      finally {}
      if (this.dOZ + l > ER())
      {
        y.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", new Object[] { Long.valueOf(l), Long.valueOf(this.dOZ) });
      }
      else
      {
        d locald2 = (d)this.dOX.get(localComparable);
        d locald1 = locald2;
        if (locald2 == null) {
          locald1 = c(localComparable);
        }
        locald1.put(paramT);
        this.dOX.put(localComparable, locald1);
        bz(l);
      }
    }
  }
  
  public abstract long as(T paramT);
  
  public abstract S at(T paramT);
  
  public abstract S b(S paramS);
  
  protected final void bA(long paramLong)
  {
    try
    {
      this.dOZ -= paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract d<T, S> c(S paramS);
  
  public abstract T d(S paramS);
  
  public abstract class a
  {
    public a() {}
    
    public abstract S EW();
    
    public abstract long EX();
    
    public abstract int EY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.memory.e
 * JD-Core Version:    0.7.0.1
 */