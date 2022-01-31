package com.tencent.map.lib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class c<T, K>
{
  private HashMap<T, K> a;
  private int b = 0;
  private int c = 1024;
  
  /* Error */
  public final K a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 22
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 30	com/tencent/map/lib/util/c:a	Ljava/util/HashMap;
    //   11: ifnonnull +14 -> 25
    //   14: aconst_null
    //   15: astore_1
    //   16: ldc 22
    //   18: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aload_0
    //   26: getfield 30	com/tencent/map/lib/util/c:a	Ljava/util/HashMap;
    //   29: aload_1
    //   30: invokevirtual 38	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: astore_1
    //   34: ldc 22
    //   36: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: goto -18 -> 21
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	c
    //   0	47	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   2	14	42	finally
    //   16	21	42	finally
    //   25	39	42	finally
  }
  
  public final void a(T paramT, K paramK)
  {
    try
    {
      AppMethodBeat.i(98246);
      if (this.a == null) {
        this.a = new HashMap();
      }
      this.a.put(paramT, paramK);
      AppMethodBeat.o(98246);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.util.c
 * JD-Core Version:    0.7.0.1
 */