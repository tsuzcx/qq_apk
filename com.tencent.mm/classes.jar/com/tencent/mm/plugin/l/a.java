package com.tencent.mm.plugin.l;

import java.util.List;

public final class a
{
  private static List<a.a> oia;
  private static String oib;
  
  /* Error */
  public static List<a.a> So(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 14
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnull +27 -> 36
    //   12: aload_0
    //   13: getstatic 22	com/tencent/mm/plugin/l/a:oib	Ljava/lang/String;
    //   16: invokevirtual 28	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq +17 -> 36
    //   22: getstatic 30	com/tencent/mm/plugin/l/a:oia	Ljava/util/List;
    //   25: astore_0
    //   26: ldc 14
    //   28: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: aconst_null
    //   37: astore_0
    //   38: ldc 14
    //   40: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -12 -> 31
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	8	46	finally
    //   12	31	46	finally
    //   38	43	46	finally
  }
  
  public static void p(String paramString, List<a.a> paramList)
  {
    try
    {
      oib = paramString;
      oia = paramList;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.l.a
 * JD-Core Version:    0.7.0.1
 */