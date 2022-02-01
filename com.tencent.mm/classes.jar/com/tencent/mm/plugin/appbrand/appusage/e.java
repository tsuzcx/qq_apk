package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends al
{
  @Deprecated
  public static final a jup;
  
  static
  {
    AppMethodBeat.i(50242);
    jup = new a((byte)0);
    AppMethodBeat.o(50242);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer";
  }
  
  public final boolean nP(int paramInt)
  {
    AppMethodBeat.i(50241);
    com.tencent.mm.kernel.e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    boolean bool = locale.agA().getBoolean(ah.a.GJt, false);
    ac.d("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", "needTransfer doneIssue ".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(50241);
      return true;
    }
    AppMethodBeat.o(50241);
    return false;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(50240);
    try
    {
      j.aVr().aVs().execSQL("AppBrandStarApp", "update AppBrandStarApp set orderSequence = updateTime");
      com.tencent.mm.kernel.e locale = g.agR();
      k.g(locale, "MMKernel.storage()");
      locale.agA().set(ah.a.GJt, Boolean.TRUE);
      AppMethodBeat.o(50240);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", localThrowable, "transfer failed", new Object[0]);
      AppMethodBeat.o(50240);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.e
 * JD-Core Version:    0.7.0.1
 */