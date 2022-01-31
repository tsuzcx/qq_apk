package com.tencent.mm.plugin.brandservice.ui.timeline.a.b;

import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class c
  extends i<a>
{
  public static final String[] dUb = { i.a(a.dUa, "BizAppMsgReportContext") };
  public static final String[] dUc = new String[0];
  final com.tencent.mm.sdk.e.e dXw;
  
  public c(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.dUa, "BizAppMsgReportContext", dUc);
    this.dXw = parame;
  }
  
  public final boolean a(a parama)
  {
    parama.field_appMsgReportContextId = parama.field_reportTime;
    return super.b(parama);
  }
  
  public final void aJ(List<a> paramList)
  {
    long l = g.DP().dKu.eV(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!a((a)paramList.next(), new String[0])) {
        y.v("MicroMsg.Preload.BizAppMsgReportContextStorage", "[remove] delete fail");
      }
    }
    g.DP().dKu.hI(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b.c
 * JD-Core Version:    0.7.0.1
 */