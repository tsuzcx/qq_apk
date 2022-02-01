package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransferABTest;", "", "()V", "ABTEST_NEED_TRANSFER", "", "ABTEST_PHASES", "ABTEST_SWITCH", "PHASES_FINISH", "", "PHASES_ROLLBACK", "PHASES_TEST", "TAG", "isNeedTransfer", "", "isPerformanceReportOn", "phases", "isFinishPhases", "isRollbackPhases", "isTestPhases", "load", "", "onABTestUpdate", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  private static volatile boolean qLL;
  private static volatile int qLM;
  public static final j qMg;
  private static volatile boolean qMh;
  
  static
  {
    AppMethodBeat.i(50219);
    qMg = new j();
    qLM = 1;
    qMg.Td();
    AppMethodBeat.o(50219);
  }
  
  public final void Td()
  {
    try
    {
      AppMethodBeat.i(50218);
      Log.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load]");
      qLL = true;
      qLM = 3;
      qMh = false;
      Log.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isNeedTransfer=" + qLL + "  phases=" + qLM);
      Log.i("MicroMsg.AppBrandKVStorageTransferABTest", s.X("[load] isPerformanceReportOn=", Boolean.valueOf(qMh)));
      AppMethodBeat.o(50218);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean chR()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 55	com/tencent/mm/plugin/appbrand/appstorage/j:qLM	I
    //   5: istore_1
    //   6: iload_1
    //   7: iconst_3
    //   8: if_icmpne +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	j
    //   5	4	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	22	finally
  }
  
  /* Error */
  public final boolean chS()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 55	com/tencent/mm/plugin/appbrand/appstorage/j:qLM	I
    //   5: istore_1
    //   6: iload_1
    //   7: iconst_2
    //   8: if_icmpne +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	j
    //   5	4	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	22	finally
  }
  
  public final boolean chT()
  {
    try
    {
      boolean bool = qLL;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean chZ()
  {
    try
    {
      boolean bool = qMh;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.j
 * JD-Core Version:    0.7.0.1
 */