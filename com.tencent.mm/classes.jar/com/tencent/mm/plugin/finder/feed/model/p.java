package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LruCache;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/LRUCacheHelper;", "Lcom/tencent/mm/plugin/finder/feed/model/ICacheHelper;", "maxCacheLimit", "", "(I)V", "caches", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "addCache", "", "cache", "clearCache", "clearExpiredCache", "contains", "", "id", "getCache", "", "ids", "removeCache", "Companion", "plugin-finder-base_release"})
public final class p
  implements m
{
  public static final a xJS;
  private final LruCache<Long, o> xJQ;
  private final int xJR;
  
  static
  {
    AppMethodBeat.i(259629);
    xJS = new a((byte)0);
    AppMethodBeat.o(259629);
  }
  
  public p()
  {
    AppMethodBeat.i(259628);
    this.xJR = 30;
    this.xJQ = new LruCache(this.xJR);
    AppMethodBeat.o(259628);
  }
  
  public final void KV(long paramLong)
  {
    try
    {
      AppMethodBeat.i(259622);
      this.xJQ.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(259622);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final o KZ(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 86
    //   4: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 70	com/tencent/mm/plugin/finder/feed/model/p:xJQ	Lcom/tencent/mm/sdk/platformtools/LruCache;
    //   11: lload_1
    //   12: invokestatic 79	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 89	com/tencent/mm/sdk/platformtools/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 91	com/tencent/mm/plugin/finder/feed/model/o
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +33 -> 56
    //   26: aload_3
    //   27: invokeinterface 95 1 0
    //   32: ifeq +12 -> 44
    //   35: ldc 86
    //   37: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: areturn
    //   44: aload_0
    //   45: getfield 70	com/tencent/mm/plugin/finder/feed/model/p:xJQ	Lcom/tencent/mm/sdk/platformtools/LruCache;
    //   48: lload_1
    //   49: invokestatic 79	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 83	com/tencent/mm/sdk/platformtools/LruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aconst_null
    //   57: astore_3
    //   58: ldc 86
    //   60: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: goto -23 -> 40
    //   66: astore_3
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_3
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	p
    //   0	71	1	paramLong	long
    //   21	37	3	localo	o
    //   66	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	66	finally
    //   26	40	66	finally
    //   44	56	66	finally
    //   58	63	66	finally
  }
  
  public final void a(o paramo)
  {
    try
    {
      AppMethodBeat.i(259620);
      kotlin.g.b.p.k(paramo, "cache");
      this.xJQ.put(Long.valueOf(paramo.dux()), paramo);
      AppMethodBeat.o(259620);
      return;
    }
    finally
    {
      paramo = finally;
      throw paramo;
    }
  }
  
  public final void clearCache()
  {
    try
    {
      AppMethodBeat.i(259626);
      h.ioq();
      this.xJQ.evictAll();
      AppMethodBeat.o(259626);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/LRUCacheHelper$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.p
 * JD-Core Version:    0.7.0.1
 */