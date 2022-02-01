package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;

public final class AppBrandOpReportLogic$a
{
  private static boolean kEu = false;
  
  /* Error */
  public static void e(h paramh)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 19
    //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 15	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a:kEu	Z
    //   11: ifeq +12 -> 23
    //   14: ldc 19
    //   16: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: invokeinterface 34 1 0
    //   29: new 9	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a$1
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 37	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a$1:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/h;)V
    //   37: invokestatic 42	com/tencent/mm/plugin/appbrand/ipc/MMToClientEvent:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/ipc/MMToClientEvent$c;)V
    //   40: iconst_1
    //   41: putstatic 15	com/tencent/mm/plugin/appbrand/jsapi/op_report/AppBrandOpReportLogic$a:kEu	Z
    //   44: ldc 19
    //   46: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -30 -> 19
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramh	h
    // Exception table:
    //   from	to	target	type
    //   3	19	52	finally
    //   23	49	52	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a
 * JD-Core Version:    0.7.0.1
 */