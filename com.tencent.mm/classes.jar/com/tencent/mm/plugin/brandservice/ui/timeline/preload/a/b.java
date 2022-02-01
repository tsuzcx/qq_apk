package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;

public final class b
  extends j<a>
{
  public static final String[] hEf;
  public static final String[] hEg;
  final com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(6191);
    hEf = new String[] { j.getCreateSQLs(a.hEe, "BizAppMsgReportContext") };
    hEg = new String[0];
    AppMethodBeat.o(6191);
  }
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.hEe, "BizAppMsgReportContext", hEg);
    this.db = parame;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(6188);
    parama.field_appMsgReportContextId = parama.field_reportTime;
    boolean bool = super.insert(parama);
    AppMethodBeat.o(6188);
    return bool;
  }
  
  public final void ct(List<a> paramList)
  {
    AppMethodBeat.i(6189);
    long l = g.ajC().gBq.xO(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!delete((a)paramList.next(), new String[0])) {
        ad.v("MicroMsg.Preload.BizAppMsgReportContextStorage", "[remove] delete fail");
      }
    }
    g.ajC().gBq.sJ(l);
    AppMethodBeat.o(6189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b
 * JD-Core Version:    0.7.0.1
 */