package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends ao
{
  @Deprecated
  public static final a jRA;
  
  static
  {
    AppMethodBeat.i(50242);
    jRA = new a((byte)0);
    AppMethodBeat.o(50242);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer";
  }
  
  public final boolean os(int paramInt)
  {
    AppMethodBeat.i(50241);
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    boolean bool = locale.ajA().getBoolean(am.a.IQj, false);
    ae.d("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", "needTransfer doneIssue ".concat(String.valueOf(bool)));
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
      j.aZi().aZj().execSQL("AppBrandStarApp", "update AppBrandStarApp set orderSequence = updateTime");
      com.tencent.mm.kernel.e locale = g.ajR();
      p.g(locale, "MMKernel.storage()");
      locale.ajA().set(am.a.IQj, Boolean.TRUE);
      AppMethodBeat.o(50240);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", localThrowable, "transfer failed", new Object[0]);
      AppMethodBeat.o(50240);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.e
 * JD-Core Version:    0.7.0.1
 */