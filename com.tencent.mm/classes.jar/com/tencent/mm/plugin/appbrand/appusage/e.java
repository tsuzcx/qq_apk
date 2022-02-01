package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.at;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends at
{
  @Deprecated
  public static final e.a nOx;
  
  static
  {
    AppMethodBeat.i(50242);
    nOx = new e.a((byte)0);
    AppMethodBeat.o(50242);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer";
  }
  
  public final void uP(int paramInt)
  {
    AppMethodBeat.i(50240);
    try
    {
      m.bFC().bFD().execSQL("AppBrandStarApp", "update AppBrandStarApp set orderSequence = updateTime");
      f localf = h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().set(ar.a.Vmk, Boolean.TRUE);
      AppMethodBeat.o(50240);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", localThrowable, "transfer failed", new Object[0]);
      AppMethodBeat.o(50240);
    }
  }
  
  public final boolean uQ(int paramInt)
  {
    AppMethodBeat.i(50241);
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    boolean bool = localf.aHp().getBoolean(ar.a.Vmk, false);
    Log.d("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", "needTransfer doneIssue ".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(50241);
      return true;
    }
    AppMethodBeat.o(50241);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.e
 * JD-Core Version:    0.7.0.1
 */