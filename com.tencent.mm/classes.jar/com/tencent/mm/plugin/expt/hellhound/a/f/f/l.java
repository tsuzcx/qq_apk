package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gs;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class l
{
  public static final a rhv;
  
  static
  {
    AppMethodBeat.i(196648);
    rhv = new a((byte)0);
    AppMethodBeat.o(196648);
  }
  
  public static final void tn(long paramLong)
  {
    AppMethodBeat.i(196650);
    a.tn(paramLong);
    AppMethodBeat.o(196650);
  }
  
  public static final void w(long paramLong, int paramInt)
  {
    AppMethodBeat.i(196649);
    gs localgs = new gs();
    localgs.iN((int)paramLong);
    localgs.iO(paramInt);
    localgs.aLH();
    ae.i("HABBYGE-MALI.QualityReport", "reportConfigId: configid=" + paramLong + ", result=" + paramInt);
    AppMethodBeat.o(196649);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport$Companion;", "", "()V", "ERRORCODE_FAIL_PAGE_SWITCH", "", "ERRORCODE_FAIL_VIEW", "ERRORCODE_FAIL_VIEW_OP", "ERRORCODE_SUCCESS_PAGE_SWITCH", "ERRORCODE_SUCCESS_VIEW", "ERRORCODE_SUCCESS_VIEW_OP", "MAX_TIME", "TAG", "", "report", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "reportConfigId", "configId", "", "errorCode", "reportIdKey", "id", "reportKv", "plugin-expt_release"})
  public static final class a
  {
    public static void tn(long paramLong)
    {
      AppMethodBeat.i(196647);
      g.yxI.idkeyStat(932L, paramLong, 1L, false);
      ae.i("HABBYGE-MALI.QualityReport", "reportIdKey: id=".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(196647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.l
 * JD-Core Version:    0.7.0.1
 */