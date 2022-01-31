package com.tencent.mm.plugin.appbrand.widget.d;

final class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 27	com/tencent/mm/plugin/appbrand/widget/d/a:aqn	()Ljava/util/LinkedList;
    //   5: invokevirtual 33	java/util/LinkedList:pollFirst	()Ljava/lang/Object;
    //   8: checkcast 6	java/lang/Runnable
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +12 -> 25
    //   16: aload_1
    //   17: invokeinterface 35 1 0
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: ldc 37
    //   27: ldc 39
    //   29: invokestatic 45	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: invokestatic 49	com/tencent/mm/plugin/appbrand/widget/d/a:asL	()Z
    //   35: pop
    //   36: goto -14 -> 22
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	1
    //   11	6	1	localRunnable	Runnable
    //   39	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	39	finally
    //   16	22	39	finally
    //   22	24	39	finally
    //   25	36	39	finally
    //   40	42	39	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.a.1.1
 * JD-Core Version:    0.7.0.1
 */