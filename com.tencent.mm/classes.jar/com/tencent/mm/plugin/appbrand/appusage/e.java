package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends as
{
  @Deprecated
  public static final a kUk;
  
  static
  {
    AppMethodBeat.i(50242);
    kUk = new a((byte)0);
    AppMethodBeat.o(50242);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer";
  }
  
  public final boolean rT(int paramInt)
  {
    AppMethodBeat.i(50241);
    com.tencent.mm.kernel.e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    boolean bool = locale.azQ().getBoolean(ar.a.NYk, false);
    Log.d("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", "needTransfer doneIssue ".concat(String.valueOf(bool)));
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
      n.buz().buA().execSQL("AppBrandStarApp", "update AppBrandStarApp set orderSequence = updateTime");
      com.tencent.mm.kernel.e locale = g.aAh();
      p.g(locale, "MMKernel.storage()");
      locale.azQ().set(ar.a.NYk, Boolean.TRUE);
      AppMethodBeat.o(50240);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", localThrowable, "transfer failed", new Object[0]);
      AppMethodBeat.o(50240);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.e
 * JD-Core Version:    0.7.0.1
 */