package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.ab;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable>
{
  protected NavigableMap<S, d<T, S>> fdE = new ConcurrentSkipListMap();
  private Vector<e<T, S>.a> fdF = new Vector();
  protected long fdG = 0L;
  
  private void gs(long paramLong)
  {
    try
    {
      this.fdG += paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Do()
  {
    if (this.fdF.size() > 0) {
      com.tencent.mm.sdk.g.d.post(new e.1(this), "BucketPool_preload");
    }
  }
  
  protected abstract long XH();
  
  protected abstract long XI();
  
  public void XJ()
  {
    ab.i("MicroMsg.BucketPool", "freeAll: %s", new Object[] { getClass().getName() });
    this.fdE.clear();
    this.fdG = 0L;
  }
  
  public final void a(e<T, S>.a parame)
  {
    this.fdF.add(parame);
    ab.i("MicroMsg.BucketPool", "%s addPreload: %s", new Object[] { this, parame });
    Do();
  }
  
  public void aG(T paramT)
  {
    if (paramT == null) {}
    for (;;)
    {
      return;
      Comparable localComparable;
      long l;
      try
      {
        localComparable = aI(paramT);
        l = aH(paramT);
        if (l > XI())
        {
          ab.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", new Object[] { Long.valueOf(l) });
          continue;
        }
      }
      finally {}
      if (this.fdG + l > XH())
      {
        ab.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", new Object[] { Long.valueOf(l), Long.valueOf(this.fdG) });
      }
      else
      {
        d locald2 = (d)this.fdE.get(localComparable);
        d locald1 = locald2;
        if (locald2 == null) {
          locald1 = f(localComparable);
        }
        locald1.put(paramT);
        this.fdE.put(localComparable, locald1);
        gs(l);
      }
    }
  }
  
  protected abstract long aH(T paramT);
  
  protected abstract S aI(T paramT);
  
  /* Error */
  public T d(S paramS)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mm/memory/e:fdE	Ljava/util/NavigableMap;
    //   6: aload_1
    //   7: invokeinterface 177 2 0
    //   12: checkcast 96	com/tencent/mm/memory/d
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +43 -> 60
    //   20: aload_2
    //   21: invokevirtual 111	com/tencent/mm/memory/d:size	()I
    //   24: ifle +36 -> 60
    //   27: aload_2
    //   28: invokevirtual 182	com/tencent/mm/memory/d:pop	()Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 25	com/tencent/mm/memory/e:fdE	Ljava/util/NavigableMap;
    //   36: aload_2
    //   37: invokevirtual 185	com/tencent/mm/memory/d:XK	()Ljava/lang/Object;
    //   40: aload_2
    //   41: invokeinterface 119 3 0
    //   46: pop
    //   47: aload_0
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 104	com/tencent/mm/memory/e:aH	(Ljava/lang/Object;)J
    //   53: invokevirtual 188	com/tencent/mm/memory/e:gt	(J)V
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: areturn
    //   60: ldc 68
    //   62: ldc 190
    //   64: iconst_1
    //   65: anewarray 5	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  protected abstract S e(S paramS);
  
  protected abstract d<T, S> f(S paramS);
  
  protected abstract T g(S paramS);
  
  protected final void gt(long paramLong)
  {
    try
    {
      this.fdG -= paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract class a
  {
    public a() {}
    
    public abstract S XL();
    
    public abstract long XM();
    
    public abstract int XN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.memory.e
 * JD-Core Version:    0.7.0.1
 */