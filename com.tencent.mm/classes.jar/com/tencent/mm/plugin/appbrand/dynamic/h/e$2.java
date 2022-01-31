package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;

final class e$2
  implements Runnable
{
  e$2(Context paramContext) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 10961
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 8
    //   8: monitorenter
    //   9: invokestatic 31	com/tencent/mm/plugin/appbrand/dynamic/h/e:aAf	()Lcom/tencent/mm/z/c/e;
    //   12: ifnull +13 -> 25
    //   15: ldc 8
    //   17: monitorexit
    //   18: sipush 10961
    //   21: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: ldc 8
    //   27: monitorexit
    //   28: ldc 36
    //   30: ldc 38
    //   32: iconst_0
    //   33: anewarray 4	java/lang/Object
    //   36: invokestatic 43	com/tencent/mm/modelappbrand/u:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: invokestatic 47	com/tencent/mm/plugin/appbrand/dynamic/h/e:aAg	()Lcom/tencent/mm/plugin/appbrand/dynamic/debugger/DebuggerInfo;
    //   42: pop
    //   43: invokestatic 50	com/tencent/mm/plugin/appbrand/dynamic/h/e:aAh	()Lcom/tencent/mm/z/c/e;
    //   46: astore_1
    //   47: ldc 8
    //   49: monitorenter
    //   50: aload_1
    //   51: invokestatic 54	com/tencent/mm/plugin/appbrand/dynamic/h/e:b	(Lcom/tencent/mm/z/c/e;)Lcom/tencent/mm/z/c/e;
    //   54: pop
    //   55: ldc 8
    //   57: monitorexit
    //   58: sipush 10961
    //   61: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: return
    //   65: astore_1
    //   66: ldc 8
    //   68: monitorexit
    //   69: sipush 10961
    //   72: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: ldc 8
    //   80: monitorexit
    //   81: sipush 10961
    //   84: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	2
    //   46	5	1	locale	com.tencent.mm.z.c.e
    //   65	11	1	localObject1	Object
    //   77	11	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	65	finally
    //   25	28	65	finally
    //   66	69	65	finally
    //   50	58	77	finally
    //   78	81	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e.2
 * JD-Core Version:    0.7.0.1
 */