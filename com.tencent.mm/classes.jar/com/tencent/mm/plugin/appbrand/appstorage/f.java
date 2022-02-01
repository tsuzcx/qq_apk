package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.c;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransferABTest;", "", "()V", "ABTEST_NEED_TRANSFER", "", "ABTEST_PHASES", "ABTEST_SWITCH", "PHASES_FINISH", "", "PHASES_ROLLBACK", "PHASES_TEST", "TAG", "isNeedTransfer", "", "isPerformanceReportOn", "phases", "isFinishPhases", "isRollbackPhases", "isTestPhases", "load", "", "onABTestUpdate", "plugin-appbrand-integration_release"})
public final class f
{
  private static volatile boolean jPo;
  private static volatile int jPp;
  private static volatile boolean jPq;
  public static final f jPr;
  
  static
  {
    AppMethodBeat.i(50219);
    f localf = new f();
    jPr = localf;
    jPp = 1;
    localf.vw();
    AppMethodBeat.o(50219);
  }
  
  /* Error */
  public final boolean bbS()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 52	com/tencent/mm/plugin/appbrand/appstorage/f:jPp	I
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
    //   0	27	0	this	f
    //   5	4	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	22	finally
  }
  
  /* Error */
  public final boolean bbT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 52	com/tencent/mm/plugin/appbrand/appstorage/f:jPp	I
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
    //   0	27	0	this	f
    //   5	4	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	22	finally
  }
  
  public final boolean bbU()
  {
    try
    {
      boolean bool = jPq;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bbV()
  {
    try
    {
      boolean bool = jPo;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void vw()
  {
    try
    {
      AppMethodBeat.i(50218);
      ae.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load]");
      c localc1 = com.tencent.mm.model.c.d.aDI().xi("100478");
      c localc2 = com.tencent.mm.model.c.d.aDI().xi("100483");
      p.g(localc1, "transferTest");
      if (localc1.isValid())
      {
        jPo = bu.getBoolean((String)localc1.fsy().get("needTransfer"), false);
        jPp = bu.getInt((String)localc1.fsy().get("phases"), 1);
      }
      p.g(localc2, "performanceReportSwitchTest");
      if (localc2.isValid()) {
        jPq = bu.getBoolean((String)localc2.fsy().get("switch"), false);
      }
      ae.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isNeedTransfer=" + jPo + "  phases=" + jPp);
      ae.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isPerformanceReportOn=" + jPq);
      AppMethodBeat.o(50218);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.f
 * JD-Core Version:    0.7.0.1
 */