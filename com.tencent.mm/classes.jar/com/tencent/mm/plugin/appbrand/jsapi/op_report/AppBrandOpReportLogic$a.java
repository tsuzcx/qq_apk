package com.tencent.mm.plugin.appbrand.jsapi.op_report;

public final class AppBrandOpReportLogic$a
{
  private static boolean gyD = false;
  
  /* Error */
  public static void n(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 13	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a:gyD	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: invokeinterface 22 1 0
    //   21: new 24	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a$1
    //   24: dup
    //   25: invokespecial 27	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a$1:<init>	()V
    //   28: invokestatic 32	com/tencent/mm/plugin/appbrand/ipc/MMToClientEvent:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/ipc/MMToClientEvent$c;)V
    //   31: iconst_1
    //   32: putstatic 13	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a:gyD	Z
    //   35: goto -24 -> 11
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	paramc	com.tencent.mm.plugin.appbrand.jsapi.c
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	38	finally
    //   15	35	38	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a
 * JD-Core Version:    0.7.0.1
 */