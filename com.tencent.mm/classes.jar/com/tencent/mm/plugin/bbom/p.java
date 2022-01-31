package com.tencent.mm.plugin.bbom;

public final class p
{
  private static boolean hSX = false;
  
  /* Error */
  public static void cs(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 10	com/tencent/mm/plugin/bbom/p:hSX	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 10	com/tencent/mm/plugin/bbom/p:hSX	Z
    //   19: invokestatic 121	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   22: new 123	com/tencent/mm/plugin/bbom/p$1
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 125	com/tencent/mm/plugin/bbom/p$1:<init>	(Landroid/content/Context;)V
    //   30: invokevirtual 131	com/tencent/mm/kernel/b:a	(Lcom/tencent/mm/network/n;)V
    //   33: goto -22 -> 11
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	paramContext	android.content.Context
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	36	finally
    //   15	33	36	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.p
 * JD-Core Version:    0.7.0.1
 */