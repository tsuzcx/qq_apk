package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] iBh;
  public static final String[] iBi;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(6191);
    iBh = new String[] { MAutoStorage.getCreateSQLs(a.iBg, "BizAppMsgReportContext") };
    iBi = new String[0];
    AppMethodBeat.o(6191);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.iBg, "BizAppMsgReportContext", iBi);
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
  
  public final void cJ(List<a> paramList)
  {
    AppMethodBeat.i(6189);
    long l = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!delete((a)paramList.next(), new String[0])) {
        Log.v("MicroMsg.Preload.BizAppMsgReportContextStorage", "[remove] delete fail");
      }
    }
    g.aAh().hqK.endTransaction(l);
    AppMethodBeat.o(6189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b
 * JD-Core Version:    0.7.0.1
 */