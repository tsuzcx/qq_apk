package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class ku<T, K>
{
  private static final int a = 1024;
  private HashMap<T, K> b;
  private int c = 0;
  private int d = 1024;
  
  private void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  /* Error */
  private void b(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 25
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 32	com/tencent/mapsdk/internal/ku:b	Ljava/util/HashMap;
    //   11: ifnonnull +11 -> 22
    //   14: ldc 25
    //   16: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 32	com/tencent/mapsdk/internal/ku:b	Ljava/util/HashMap;
    //   26: aload_1
    //   27: invokevirtual 41	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: ldc 25
    //   33: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: goto -17 -> 19
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ku
    //   0	44	1	paramT	T
    // Exception table:
    //   from	to	target	type
    //   2	19	39	finally
    //   22	36	39	finally
  }
  
  /* Error */
  public final K a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 44
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 32	com/tencent/mapsdk/internal/ku:b	Ljava/util/HashMap;
    //   11: ifnonnull +14 -> 25
    //   14: aconst_null
    //   15: astore_1
    //   16: ldc 44
    //   18: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aload_0
    //   26: getfield 32	com/tencent/mapsdk/internal/ku:b	Ljava/util/HashMap;
    //   29: aload_1
    //   30: invokevirtual 47	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: astore_1
    //   34: ldc 44
    //   36: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: goto -18 -> 21
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	ku
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
      AppMethodBeat.i(222324);
      if (this.b == null) {
        this.b = new HashMap();
      }
      this.b.put(paramT, paramK);
      AppMethodBeat.o(222324);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ku
 * JD-Core Version:    0.7.0.1
 */