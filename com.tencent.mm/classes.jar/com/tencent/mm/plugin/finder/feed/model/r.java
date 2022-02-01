package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LruCache;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/LRUCacheHelper;", "Lcom/tencent/mm/plugin/finder/feed/model/ICacheHelper;", "maxCacheLimit", "", "(I)V", "caches", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "addCache", "", "cache", "clearCache", "clearExpiredCache", "contains", "", "id", "getCache", "", "ids", "removeCache", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  implements o
{
  public static final a BjD;
  private final int BjE;
  private final LruCache<Long, q> BjF;
  
  static
  {
    AppMethodBeat.i(366402);
    BjD = new a((byte)0);
    AppMethodBeat.o(366402);
  }
  
  public r()
  {
    AppMethodBeat.i(366397);
    this.BjE = 30;
    this.BjF = new LruCache(this.BjE);
    AppMethodBeat.o(366397);
  }
  
  public final void a(q paramq)
  {
    try
    {
      AppMethodBeat.i(366411);
      s.u(paramq, "cache");
      this.BjF.put(Long.valueOf(paramq.id()), paramq);
      AppMethodBeat.o(366411);
      return;
    }
    finally
    {
      paramq = finally;
      throw paramq;
    }
  }
  
  public final void clearCache()
  {
    try
    {
      AppMethodBeat.i(366438);
      h.jXD();
      this.BjF.evictAll();
      AppMethodBeat.o(366438);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean contains(long paramLong)
  {
    try
    {
      AppMethodBeat.i(366432);
      boolean bool = this.BjF.check(Long.valueOf(paramLong));
      AppMethodBeat.o(366432);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void nA(long paramLong)
  {
    try
    {
      AppMethodBeat.i(366417);
      this.BjF.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(366417);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final q nK(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 122
    //   4: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 73	com/tencent/mm/plugin/finder/feed/model/r:BjF	Lcom/tencent/mm/sdk/platformtools/LruCache;
    //   11: lload_1
    //   12: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 125	com/tencent/mm/sdk/platformtools/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 84	com/tencent/mm/plugin/finder/feed/model/q
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +33 -> 56
    //   26: aload_3
    //   27: invokeinterface 129 1 0
    //   32: ifeq +12 -> 44
    //   35: ldc 122
    //   37: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: areturn
    //   44: aload_0
    //   45: getfield 73	com/tencent/mm/plugin/finder/feed/model/r:BjF	Lcom/tencent/mm/sdk/platformtools/LruCache;
    //   48: lload_1
    //   49: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 119	com/tencent/mm/sdk/platformtools/LruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aconst_null
    //   57: astore_3
    //   58: ldc 122
    //   60: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: goto -23 -> 40
    //   66: astore_3
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_3
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	r
    //   0	71	1	paramLong	long
    //   21	37	3	localq	q
    //   66	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	66	finally
    //   26	40	66	finally
    //   44	56	66	finally
    //   58	63	66	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/LRUCacheHelper$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.r
 * JD-Core Version:    0.7.0.1
 */