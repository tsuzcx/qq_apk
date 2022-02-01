package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class BucketPool<T, S extends Comparable>
{
  private static MMTrimMemoryEventListener nNq = null;
  protected NavigableMap<S, d<T, S>> nNn = new ConcurrentSkipListMap();
  private Vector<BucketPool<T, S>.a> nNo = new Vector();
  protected long nNp = 0L;
  
  public BucketPool()
  {
    if (nNq != null) {
      nNq.dead();
    }
    MMTrimMemoryEventListener localMMTrimMemoryEventListener = new MMTrimMemoryEventListener(this);
    nNq = localMMTrimMemoryEventListener;
    localMMTrimMemoryEventListener.alive();
  }
  
  private void in(long paramLong)
  {
    try
    {
      this.nNp += paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(BucketPool<T, S>.a paramBucketPool)
  {
    this.nNo.add(paramBucketPool);
    Log.i("MicroMsg.BucketPool", "%s addPreload: %s", new Object[] { this, paramBucketPool });
    aFB();
  }
  
  public final void aFB()
  {
    if (this.nNo.size() > 0) {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156416);
          BucketPool.a(BucketPool.this);
          AppMethodBeat.o(156416);
        }
      }, "BucketPool_preload");
    }
  }
  
  /* Error */
  public T b(S paramS)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/mm/memory/BucketPool:nNn	Ljava/util/NavigableMap;
    //   6: aload_1
    //   7: invokeinterface 164 2 0
    //   12: checkcast 114	com/tencent/mm/memory/d
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +46 -> 63
    //   20: aload_2
    //   21: invokevirtual 129	com/tencent/mm/memory/d:size	()I
    //   24: ifle +39 -> 63
    //   27: aload_2
    //   28: invokevirtual 168	com/tencent/mm/memory/d:pop	()Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 36	com/tencent/mm/memory/BucketPool:nNn	Ljava/util/NavigableMap;
    //   36: aload_2
    //   37: invokevirtual 171	com/tencent/mm/memory/d:bvH	()Ljava/lang/Object;
    //   40: checkcast 173	java/lang/Comparable
    //   43: aload_2
    //   44: invokeinterface 136 3 0
    //   49: pop
    //   50: aload_0
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 122	com/tencent/mm/memory/BucketPool:do	(Ljava/lang/Object;)J
    //   56: invokevirtual 176	com/tencent/mm/memory/BucketPool:io	(J)V
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: ldc 86
    //   65: ldc 178
    //   67: iconst_1
    //   68: anewarray 5	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aconst_null
    //   79: astore_1
    //   80: goto -21 -> 59
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	BucketPool
    //   0	88	1	paramS	S
    //   15	29	2	locald	d
    // Exception table:
    //   from	to	target	type
    //   2	16	83	finally
    //   20	59	83	finally
    //   63	78	83	finally
  }
  
  protected abstract long bvE();
  
  protected abstract long bvF();
  
  public void bvG()
  {
    Log.i("MicroMsg.BucketPool", "freeAll: %s", new Object[] { getClass().getName() });
    this.nNn.clear();
    this.nNp = 0L;
  }
  
  protected abstract S c(S paramS);
  
  protected abstract d<T, S> d(S paramS);
  
  public void dn(T paramT)
  {
    if (paramT == null) {}
    for (;;)
    {
      return;
      Comparable localComparable;
      long l;
      try
      {
        localComparable = dp(paramT);
        l = jdMethod_do(paramT);
        if (l > bvF())
        {
          Log.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", new Object[] { Long.valueOf(l) });
          continue;
        }
      }
      finally {}
      if (this.nNp + l > bvE())
      {
        Log.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", new Object[] { Long.valueOf(l), Long.valueOf(this.nNp) });
      }
      else
      {
        d locald2 = (d)this.nNn.get(localComparable);
        d locald1 = locald2;
        if (locald2 == null) {
          locald1 = d(localComparable);
        }
        locald1.put(paramT);
        this.nNn.put(localComparable, locald1);
        in(l);
      }
    }
  }
  
  protected abstract long jdMethod_do(T paramT);
  
  protected abstract S dp(T paramT);
  
  protected abstract T e(S paramS);
  
  protected final void io(long paramLong)
  {
    try
    {
      this.nNp -= paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    private final WeakReference<BucketPool> nph;
    
    public MMTrimMemoryEventListener(BucketPool paramBucketPool)
    {
      super();
      AppMethodBeat.i(238942);
      this.nph = new WeakReference(paramBucketPool);
      this.__eventId = oc.class.getName().hashCode();
      AppMethodBeat.o(238942);
    }
  }
  
  public abstract class a
  {
    public a() {}
    
    public abstract S bvJ();
    
    public abstract long bvK();
    
    public abstract int bvL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.BucketPool
 * JD-Core Version:    0.7.0.1
 */