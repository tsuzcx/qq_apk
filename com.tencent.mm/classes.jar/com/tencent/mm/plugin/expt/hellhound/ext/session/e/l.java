package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qd;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final a zKT;
  
  static
  {
    AppMethodBeat.i(300222);
    zKT = new a((byte)0);
    AppMethodBeat.o(300222);
  }
  
  public static final void F(long paramLong, int paramInt)
  {
    AppMethodBeat.i(300216);
    qd localqd = new qd();
    localqd.jqj = ((int)paramLong);
    localqd.iLt = paramInt;
    localqd.bMH();
    AppMethodBeat.o(300216);
  }
  
  public static final void jX(long paramLong)
  {
    AppMethodBeat.i(300219);
    a.jX(paramLong);
    AppMethodBeat.o(300219);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport$Companion;", "", "()V", "ERRORCODE_FAIL_PAGE_SWITCH", "", "ERRORCODE_FAIL_VIEW", "ERRORCODE_FAIL_VIEW_OP", "ERRORCODE_SUCCESS_PAGE_SWITCH", "ERRORCODE_SUCCESS_VIEW", "ERRORCODE_SUCCESS_VIEW_OP", "MAX_TIME", "TAG", "", "report", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "reportConfigId", "configId", "", "errorCode", "reportIdKey", "id", "reportKv", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void jX(long paramLong)
    {
      AppMethodBeat.i(300221);
      h.OAn.idkeyStat(932L, paramLong, 1L, false);
      AppMethodBeat.o(300221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.l
 * JD-Core Version:    0.7.0.1
 */