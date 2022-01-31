package com.tencent.mm.plugin.appbrand.appstorage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransferABTest;", "", "()V", "ABTEST_NEED_TRANSFER", "", "ABTEST_PHASES", "ABTEST_SWITCH", "PHASES_FINISH", "", "PHASES_ROLLBACK", "PHASES_TEST", "TAG", "isNeedTransfer", "", "isPerformanceReportOn", "phases", "isFinishPhases", "isRollbackPhases", "isTestPhases", "load", "", "onABTestUpdate", "plugin-appbrand-integration_release"})
public final class d
{
  private static volatile boolean gZi;
  private static volatile int gZj;
  private static volatile boolean gZk;
  public static final d gZl;
  
  static
  {
    AppMethodBeat.i(134488);
    d locald = new d();
    gZl = locald;
    gZj = 1;
    locald.ph();
    AppMethodBeat.o(134488);
  }
  
  /* Error */
  public final boolean awA()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 52	com/tencent/mm/plugin/appbrand/appstorage/d:gZj	I
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
    //   0	27	0	this	d
    //   5	4	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	22	finally
  }
  
  /* Error */
  public final boolean awB()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 52	com/tencent/mm/plugin/appbrand/appstorage/d:gZj	I
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
    //   0	27	0	this	d
    //   5	4	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	22	finally
  }
  
  public final boolean awC()
  {
    try
    {
      boolean bool = gZk;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean awD()
  {
    try
    {
      boolean bool = gZi;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ph()
  {
    try
    {
      AppMethodBeat.i(134487);
      ab.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load]");
      com.tencent.mm.storage.c localc1 = com.tencent.mm.model.c.c.abU().me("100478");
      com.tencent.mm.storage.c localc2 = com.tencent.mm.model.c.c.abU().me("100483");
      j.p(localc1, "transferTest");
      if (localc1.isValid())
      {
        gZi = bo.getBoolean((String)localc1.dvN().get("needTransfer"), false);
        gZj = bo.getInt((String)localc1.dvN().get("phases"), 1);
      }
      j.p(localc2, "performanceReportSwitchTest");
      if (localc2.isValid()) {
        gZk = bo.getBoolean((String)localc2.dvN().get("switch"), false);
      }
      ab.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isNeedTransfer=" + gZi + "  phases=" + gZj);
      ab.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isPerformanceReportOn=" + gZk);
      AppMethodBeat.o(134487);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.d
 * JD-Core Version:    0.7.0.1
 */