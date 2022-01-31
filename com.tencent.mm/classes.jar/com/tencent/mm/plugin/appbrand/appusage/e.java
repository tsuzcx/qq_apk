package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.model.ah;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class e
  extends ah
{
  @Deprecated
  public static final e.a fIb = new e.a((byte)0);
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer";
  }
  
  public final boolean hJ(int paramInt)
  {
    boolean bool1 = false;
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.DP();
    a.d.b.g.j(locale, "MMKernel.storage()");
    boolean bool2 = locale.Dz().getBoolean(ac.a.uti, false);
    y.d("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", "needTransfer doneIssue " + bool2);
    if (!bool2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final void transfer(int paramInt)
  {
    try
    {
      com.tencent.mm.plugin.appbrand.app.e.aaP().aaQ().gk("AppBrandStarApp", "update AppBrandStarApp set orderSequence = updateTime");
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.DP();
      a.d.b.g.j(locale, "MMKernel.storage()");
      locale.Dz().c(ac.a.uti, Boolean.valueOf(true));
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", localThrowable, "transfer failed", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.e
 * JD-Core Version:    0.7.0.1
 */