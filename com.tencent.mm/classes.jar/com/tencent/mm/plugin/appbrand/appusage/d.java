package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends au
{
  private static final d.a qOr;
  
  static
  {
    AppMethodBeat.i(50242);
    qOr = new d.a((byte)0);
    AppMethodBeat.o(50242);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer";
  }
  
  public final void vb(int paramInt)
  {
    AppMethodBeat.i(50240);
    try
    {
      n.ceZ().cfa().execSQL("AppBrandStarApp", "update AppBrandStarApp set orderSequence = updateTime");
      h.baE().ban().set(at.a.acNF, Boolean.TRUE);
      AppMethodBeat.o(50240);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", localThrowable, "transfer failed", new Object[0]);
      AppMethodBeat.o(50240);
    }
  }
  
  public final boolean vc(int paramInt)
  {
    AppMethodBeat.i(50241);
    boolean bool = h.baE().ban().getBoolean(at.a.acNF, false);
    Log.d("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", s.X("needTransfer doneIssue ", Boolean.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(50241);
      return true;
    }
    AppMethodBeat.o(50241);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.d
 * JD-Core Version:    0.7.0.1
 */