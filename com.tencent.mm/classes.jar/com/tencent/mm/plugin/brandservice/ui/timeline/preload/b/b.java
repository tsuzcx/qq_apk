package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.List;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] nVW;
  public static final String[] nVX;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(6191);
    nVW = new String[] { MAutoStorage.getCreateSQLs(a.nVV, "BizAppMsgReportContext") };
    nVX = new String[0];
    AppMethodBeat.o(6191);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.nVV, "BizAppMsgReportContext", nVX);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(6188);
    parama.field_appMsgReportContextId = parama.field_reportTime;
    boolean bool = super.insert(parama);
    AppMethodBeat.o(6188);
    return bool;
  }
  
  public final void eB(List<a> paramList)
  {
    AppMethodBeat.i(6189);
    long l = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!delete((a)paramList.next(), new String[0])) {
        Log.v("MicroMsg.Preload.BizAppMsgReportContextStorage", "[remove] delete fail");
      }
    }
    com.tencent.mm.kernel.h.baE().mCN.endTransaction(l);
    AppMethodBeat.o(6189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b
 * JD-Core Version:    0.7.0.1
 */