package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable>
{
  protected NavigableMap<S, d<T, S>> itu = new ConcurrentSkipListMap();
  private Vector<e<T, S>.a> itv = new Vector();
  protected long itw = 0L;
  
  private void zY(long paramLong)
  {
    try
    {
      this.itw += paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void YU()
  {
    if (this.itv.size() > 0) {
      ThreadPool.post(new Runnable()
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
  
  public final void a(e<T, S>.a parame)
  {
    this.itv.add(parame);
    Log.i("MicroMsg.BucketPool", "%s addPreload: %s", new Object[] { this, parame });
    YU();
  }
  
  protected abstract long aRP();
  
  protected abstract long aRQ();
  
  public void aRR()
  {
    Log.i("MicroMsg.BucketPool", "freeAll: %s", new Object[] { getClass().getName() });
    this.itu.clear();
    this.itw = 0L;
  }
  
  /* Error */
  public T b(S paramS)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mm/memory/e:itu	Ljava/util/NavigableMap;
    //   6: aload_1
    //   7: invokeinterface 164 2 0
    //   12: checkcast 98	com/tencent/mm/memory/d
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +43 -> 60
    //   20: aload_2
    //   21: invokevirtual 113	com/tencent/mm/memory/d:size	()I
    //   24: ifle +36 -> 60
    //   27: aload_2
    //   28: invokevirtual 168	com/tencent/mm/memory/d:pop	()Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 27	com/tencent/mm/memory/e:itu	Ljava/util/NavigableMap;
    //   36: aload_2
    //   37: invokevirtual 171	com/tencent/mm/memory/d:aRS	()Ljava/lang/Object;
    //   40: aload_2
    //   41: invokeinterface 120 3 0
    //   46: pop
    //   47: aload_0
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 106	com/tencent/mm/memory/e:bV	(Ljava/lang/Object;)J
    //   53: invokevirtual 174	com/tencent/mm/memory/e:zZ	(J)V
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: areturn
    //   60: ldc 70
    //   62: ldc 176
    //   64: iconst_1
    //   65: anewarray 5	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public void bU(T paramT)
  {
    if (paramT == null) {}
    for (;;)
    {
      return;
      Comparable localComparable;
      long l;
      try
      {
        localComparable = bW(paramT);
        l = bV(paramT);
        if (l > aRQ())
        {
          Log.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", new Object[] { Long.valueOf(l) });
          continue;
        }
      }
      finally {}
      if (this.itw + l > aRP())
      {
        Log.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", new Object[] { Long.valueOf(l), Long.valueOf(this.itw) });
      }
      else
      {
        d locald2 = (d)this.itu.get(localComparable);
        d locald1 = locald2;
        if (locald2 == null) {
          locald1 = d(localComparable);
        }
        locald1.put(paramT);
        this.itu.put(localComparable, locald1);
        zY(l);
      }
    }
  }
  
  protected abstract long bV(T paramT);
  
  protected abstract S bW(T paramT);
  
  protected abstract S c(S paramS);
  
  protected abstract d<T, S> d(S paramS);
  
  protected abstract T e(S paramS);
  
  protected final void zZ(long paramLong)
  {
    try
    {
      this.itw -= paramLong;
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
    
    public abstract S aRT();
    
    public abstract long aRU();
    
    public abstract int aRV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.e
 * JD-Core Version:    0.7.0.1
 */