package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ai;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends ai
{
  @Deprecated
  public static final e.a haT;
  
  static
  {
    AppMethodBeat.i(134508);
    haT = new e.a((byte)0);
    AppMethodBeat.o(134508);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer";
  }
  
  public final boolean kv(int paramInt)
  {
    AppMethodBeat.i(134507);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.RL();
    j.p(locale, "MMKernel.storage()");
    boolean bool = locale.Ru().getBoolean(ac.a.yDi, false);
    ab.d("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", "needTransfer doneIssue ".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(134507);
      return true;
    }
    AppMethodBeat.o(134507);
    return false;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(134506);
    try
    {
      com.tencent.mm.plugin.appbrand.app.g.auC().auD().execSQL("AppBrandStarApp", "update AppBrandStarApp set orderSequence = updateTime");
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.RL();
      j.p(locale, "MMKernel.storage()");
      locale.Ru().set(ac.a.yDi, Boolean.TRUE);
      AppMethodBeat.o(134506);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", localThrowable, "transfer failed", new Object[0]);
      AppMethodBeat.o(134506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.e
 * JD-Core Version:    0.7.0.1
 */