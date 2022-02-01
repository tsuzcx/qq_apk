package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransferABTest;", "", "()V", "ABTEST_NEED_TRANSFER", "", "ABTEST_PHASES", "ABTEST_SWITCH", "PHASES_FINISH", "", "PHASES_ROLLBACK", "PHASES_TEST", "TAG", "isNeedTransfer", "", "isPerformanceReportOn", "phases", "isFinishPhases", "isRollbackPhases", "isTestPhases", "load", "", "onABTestUpdate", "plugin-appbrand-integration_release"})
public final class f
{
  private static volatile boolean kRW;
  private static volatile int kRX;
  private static volatile boolean kRY;
  public static final f kRZ;
  
  static
  {
    AppMethodBeat.i(50219);
    f localf = new f();
    kRZ = localf;
    kRX = 1;
    localf.vC();
    AppMethodBeat.o(50219);
  }
  
  /* Error */
  public final boolean bxi()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 52	com/tencent/mm/plugin/appbrand/appstorage/f:kRX	I
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
  public final boolean bxj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 52	com/tencent/mm/plugin/appbrand/appstorage/f:kRX	I
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
  
  public final boolean bxk()
  {
    try
    {
      boolean bool = kRY;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bxl()
  {
    try
    {
      boolean bool = kRW;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void vC()
  {
    try
    {
      AppMethodBeat.i(50218);
      Log.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load]");
      c localc1 = com.tencent.mm.model.c.d.aXu().Fu("100478");
      c localc2 = com.tencent.mm.model.c.d.aXu().Fu("100483");
      p.g(localc1, "transferTest");
      if (localc1.isValid())
      {
        kRW = Util.getBoolean((String)localc1.gzz().get("needTransfer"), false);
        kRX = Util.getInt((String)localc1.gzz().get("phases"), 1);
      }
      p.g(localc2, "performanceReportSwitchTest");
      if (localc2.isValid()) {
        kRY = Util.getBoolean((String)localc2.gzz().get("switch"), false);
      }
      Log.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isNeedTransfer=" + kRW + "  phases=" + kRX);
      Log.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isPerformanceReportOn=" + kRY);
      AppMethodBeat.o(50218);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.f
 * JD-Core Version:    0.7.0.1
 */