package com.tencent.mm.plugin.bbom;

public final class r
{
  private static boolean pfe = false;
  
  /* Error */
  public static void eJ(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 22382
    //   6: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 10	com/tencent/mm/plugin/bbom/r:pfe	Z
    //   12: ifeq +13 -> 25
    //   15: sipush 22382
    //   18: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: iconst_1
    //   26: putstatic 10	com/tencent/mm/plugin/bbom/r:pfe	Z
    //   29: invokestatic 130	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   32: new 132	com/tencent/mm/plugin/bbom/r$1
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 134	com/tencent/mm/plugin/bbom/r$1:<init>	(Landroid/content/Context;)V
    //   40: invokevirtual 140	com/tencent/mm/kernel/b:a	(Lcom/tencent/mm/network/p;)V
    //   43: sipush 22382
    //   46: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -28 -> 21
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   3	21	52	finally
    //   25	49	52	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.r
 * JD-Core Version:    0.7.0.1
 */