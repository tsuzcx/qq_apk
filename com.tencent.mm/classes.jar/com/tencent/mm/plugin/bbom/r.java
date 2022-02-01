package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;

public final class r
{
  private static boolean nOK = false;
  
  /* Error */
  public static void en(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 22382
    //   6: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 12	com/tencent/mm/plugin/bbom/r:nOK	Z
    //   12: ifeq +13 -> 25
    //   15: sipush 22382
    //   18: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: iconst_1
    //   26: putstatic 12	com/tencent/mm/plugin/bbom/r:nOK	Z
    //   29: invokestatic 132	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   32: new 6	com/tencent/mm/plugin/bbom/r$1
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 134	com/tencent/mm/plugin/bbom/r$1:<init>	(Landroid/content/Context;)V
    //   40: invokevirtual 140	com/tencent/mm/kernel/b:a	(Lcom/tencent/mm/network/n;)V
    //   43: sipush 22382
    //   46: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -28 -> 21
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	21	52	finally
    //   25	49	52	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.r
 * JD-Core Version:    0.7.0.1
 */