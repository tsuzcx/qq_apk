package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

public final class b
  extends j<a>
{
  public static final String[] fkl;
  public static final String[] fkm;
  final com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(14398);
    fkl = new String[] { j.getCreateSQLs(a.fkk, "BizAppMsgReportContext") };
    fkm = new String[0];
    AppMethodBeat.o(14398);
  }
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.fkk, "BizAppMsgReportContext", fkm);
    this.db = parame;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(14395);
    parama.field_appMsgReportContextId = parama.field_reportTime;
    boolean bool = super.insert(parama);
    AppMethodBeat.o(14395);
    return bool;
  }
  
  public final void aX(List<a> paramList)
  {
    AppMethodBeat.i(14396);
    long l = g.RL().eHS.kr(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!delete((a)paramList.next(), new String[0])) {
        ab.v("MicroMsg.Preload.BizAppMsgReportContextStorage", "[remove] delete fail");
      }
    }
    g.RL().eHS.nY(l);
    AppMethodBeat.o(14396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b
 * JD-Core Version:    0.7.0.1
 */