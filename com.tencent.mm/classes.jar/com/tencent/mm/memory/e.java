package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable>
{
  private static b liF = null;
  protected NavigableMap<S, d<T, S>> liC = new ConcurrentSkipListMap();
  private Vector<e<T, S>.a> liD = new Vector();
  protected long liE = 0L;
  
  public e()
  {
    if (liF != null) {
      liF.dead();
    }
    b localb = new b(this);
    liF = localb;
    localb.alive();
  }
  
  private void Gf(long paramLong)
  {
    try
    {
      this.liE += paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void Gg(long paramLong)
  {
    try
    {
      this.liE -= paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(e<T, S>.a parame)
  {
    this.liD.add(parame);
    Log.i("MicroMsg.BucketPool", "%s addPreload: %s", new Object[] { this, parame });
    adD();
  }
  
  public final void adD()
  {
    if (this.liD.size() > 0) {
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
  
  /* Error */
  public T b(S paramS)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/mm/memory/e:liC	Ljava/util/NavigableMap;
    //   6: aload_1
    //   7: invokeinterface 165 2 0
    //   12: checkcast 117	com/tencent/mm/memory/d
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +43 -> 60
    //   20: aload_2
    //   21: invokevirtual 130	com/tencent/mm/memory/d:size	()I
    //   24: ifle +36 -> 60
    //   27: aload_2
    //   28: invokevirtual 169	com/tencent/mm/memory/d:pop	()Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 36	com/tencent/mm/memory/e:liC	Ljava/util/NavigableMap;
    //   36: aload_2
    //   37: invokevirtual 172	com/tencent/mm/memory/d:baM	()Ljava/lang/Object;
    //   40: aload_2
    //   41: invokeinterface 137 3 0
    //   46: pop
    //   47: aload_0
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 125	com/tencent/mm/memory/e:bV	(Ljava/lang/Object;)J
    //   53: invokevirtual 174	com/tencent/mm/memory/e:Gg	(J)V
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: areturn
    //   60: ldc 89
    //   62: ldc 176
    //   64: iconst_1
    //   65: anewarray 5	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        if (l > baK())
        {
          Log.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", new Object[] { Long.valueOf(l) });
          continue;
        }
      }
      finally {}
      if (this.liE + l > baJ())
      {
        Log.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", new Object[] { Long.valueOf(l), Long.valueOf(this.liE) });
      }
      else
      {
        d locald2 = (d)this.liC.get(localComparable);
        d locald1 = locald2;
        if (locald2 == null) {
          locald1 = d(localComparable);
        }
        locald1.put(paramT);
        this.liC.put(localComparable, locald1);
        Gf(l);
      }
    }
  }
  
  protected abstract long bV(T paramT);
  
  protected abstract S bW(T paramT);
  
  protected abstract long baJ();
  
  protected abstract long baK();
  
  public void baL()
  {
    Log.i("MicroMsg.BucketPool", "freeAll: %s", new Object[] { getClass().getName() });
    this.liC.clear();
    this.liE = 0L;
  }
  
  protected abstract S c(S paramS);
  
  protected abstract d<T, S> d(S paramS);
  
  protected abstract T e(S paramS);
  
  public abstract class a
  {
    public a() {}
    
    public abstract S baO();
    
    public abstract long baP();
    
    public abstract int baQ();
  }
  
  static final class b
    extends IListener<mv>
  {
    private final WeakReference<e> kNt;
    
    public b(e parame)
    {
      AppMethodBeat.i(220924);
      this.kNt = new WeakReference(parame);
      this.__eventId = mv.class.getName().hashCode();
      AppMethodBeat.o(220924);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.e
 * JD-Core Version:    0.7.0.1
 */