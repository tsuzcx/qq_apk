package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.my;
import com.tencent.mm.plugin.report.service.h;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class l
{
  public static final a woO;
  
  static
  {
    AppMethodBeat.i(256520);
    woO = new a((byte)0);
    AppMethodBeat.o(256520);
  }
  
  public static final void HG(long paramLong)
  {
    AppMethodBeat.i(256523);
    a.HG(paramLong);
    AppMethodBeat.o(256523);
  }
  
  public static final void v(long paramLong, int paramInt)
  {
    AppMethodBeat.i(256522);
    my localmy = new my();
    localmy.nW((int)paramLong);
    localmy.nX(paramInt);
    localmy.bpa();
    AppMethodBeat.o(256522);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport$Companion;", "", "()V", "ERRORCODE_FAIL_PAGE_SWITCH", "", "ERRORCODE_FAIL_VIEW", "ERRORCODE_FAIL_VIEW_OP", "ERRORCODE_SUCCESS_PAGE_SWITCH", "ERRORCODE_SUCCESS_VIEW", "ERRORCODE_SUCCESS_VIEW_OP", "MAX_TIME", "TAG", "", "report", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "reportConfigId", "configId", "", "errorCode", "reportIdKey", "id", "reportKv", "plugin-expt_release"})
  public static final class a
  {
    public static void HG(long paramLong)
    {
      AppMethodBeat.i(256920);
      h.IzE.idkeyStat(932L, paramLong, 1L, false);
      AppMethodBeat.o(256920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.l
 * JD-Core Version:    0.7.0.1
 */