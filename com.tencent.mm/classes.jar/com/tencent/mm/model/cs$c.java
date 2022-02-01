package com.tencent.mm.model;

public final class cs$c
{
  private static String lww;
  
  /* Error */
  public static String bfT()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 12
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 20	com/tencent/mm/model/cs$c:lww	Ljava/lang/String;
    //   11: ifnonnull +18 -> 29
    //   14: invokestatic 26	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   17: pop
    //   18: aconst_null
    //   19: putstatic 20	com/tencent/mm/model/cs$c:lww	Ljava/lang/String;
    //   22: ldc 28
    //   24: ldc 30
    //   26: invokestatic 36	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: getstatic 20	com/tencent/mm/model/cs$c:lww	Ljava/lang/String;
    //   32: ifnull +20 -> 52
    //   35: getstatic 20	com/tencent/mm/model/cs$c:lww	Ljava/lang/String;
    //   38: invokestatic 42	com/tencent/mm/sdk/platformtools/WeChatBrands$Wordings:translate	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_0
    //   42: ldc 12
    //   44: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: ldc 47
    //   54: astore_0
    //   55: ldc 12
    //   57: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -13 -> 47
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	14	0	str	String
    //   63	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	29	63	finally
    //   29	47	63	finally
    //   55	60	63	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.cs.c
 * JD-Core Version:    0.7.0.1
 */