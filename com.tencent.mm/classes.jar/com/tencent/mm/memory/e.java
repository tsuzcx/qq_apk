package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable>
{
  protected long hwA = 0L;
  protected NavigableMap<S, d<T, S>> hwy = new ConcurrentSkipListMap();
  private Vector<e<T, S>.a> hwz = new Vector();
  
  private void rF(long paramLong)
  {
    try
    {
      this.hwA += paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void OE()
  {
    if (this.hwz.size() > 0) {
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156416);
          e.a(e.this);
          AppMethodBeat.o(156416);
        }
      }, "BucketPool_preload");
    }
  }
  
  /* Error */
  public T a(S paramS)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mm/memory/e:hwy	Ljava/util/NavigableMap;
    //   6: aload_1
    //   7: invokeinterface 134 2 0
    //   12: checkcast 98	com/tencent/mm/memory/d
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +43 -> 60
    //   20: aload_2
    //   21: invokevirtual 113	com/tencent/mm/memory/d:size	()I
    //   24: ifle +36 -> 60
    //   27: aload_2
    //   28: invokevirtual 138	com/tencent/mm/memory/d:pop	()Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 27	com/tencent/mm/memory/e:hwy	Ljava/util/NavigableMap;
    //   36: aload_2
    //   37: invokevirtual 141	com/tencent/mm/memory/d:ayx	()Ljava/lang/Object;
    //   40: aload_2
    //   41: invokeinterface 120 3 0
    //   46: pop
    //   47: aload_0
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 106	com/tencent/mm/memory/e:bM	(Ljava/lang/Object;)J
    //   53: invokevirtual 144	com/tencent/mm/memory/e:rG	(J)V
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: areturn
    //   60: ldc 70
    //   62: ldc 146
    //   64: iconst_1
    //   65: anewarray 5	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    this.hwz.add(parame);
    ad.i("MicroMsg.BucketPool", "%s addPreload: %s", new Object[] { this, parame });
    OE();
  }
  
  protected abstract long ayu();
  
  protected abstract long ayv();
  
  public void ayw()
  {
    ad.i("MicroMsg.BucketPool", "freeAll: %s", new Object[] { getClass().getName() });
    this.hwy.clear();
    this.hwA = 0L;
  }
  
  protected abstract S b(S paramS);
  
  public void bL(T paramT)
  {
    if (paramT == null) {}
    for (;;)
    {
      return;
      Comparable localComparable;
      long l;
      try
      {
        localComparable = bN(paramT);
        l = bM(paramT);
        if (l > ayv())
        {
          ad.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", new Object[] { Long.valueOf(l) });
          continue;
        }
      }
      finally {}
      if (this.hwA + l > ayu())
      {
        ad.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", new Object[] { Long.valueOf(l), Long.valueOf(this.hwA) });
      }
      else
      {
        d locald2 = (d)this.hwy.get(localComparable);
        d locald1 = locald2;
        if (locald2 == null) {
          locald1 = c(localComparable);
        }
        locald1.put(paramT);
        this.hwy.put(localComparable, locald1);
        rF(l);
      }
    }
  }
  
  protected abstract long bM(T paramT);
  
  protected abstract S bN(T paramT);
  
  protected abstract d<T, S> c(S paramS);
  
  protected abstract T d(S paramS);
  
  protected final void rG(long paramLong)
  {
    try
    {
      this.hwA -= paramLong;
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
    
    public abstract int ayA();
    
    public abstract S ayy();
    
    public abstract long ayz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.e
 * JD-Core Version:    0.7.0.1
 */