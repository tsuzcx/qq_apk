package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kg;
import com.tencent.mm.plugin.report.service.h;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class l
{
  public static final a sIR;
  
  static
  {
    AppMethodBeat.i(221140);
    sIR = new a((byte)0);
    AppMethodBeat.o(221140);
  }
  
  public static final void Bt(long paramLong)
  {
    AppMethodBeat.i(221142);
    a.Bt(paramLong);
    AppMethodBeat.o(221142);
  }
  
  public static final void t(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221141);
    kg localkg = new kg();
    localkg.lN((int)paramLong);
    localkg.lO(paramInt);
    localkg.bfK();
    AppMethodBeat.o(221141);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport$Companion;", "", "()V", "ERRORCODE_FAIL_PAGE_SWITCH", "", "ERRORCODE_FAIL_VIEW", "ERRORCODE_FAIL_VIEW_OP", "ERRORCODE_SUCCESS_PAGE_SWITCH", "ERRORCODE_SUCCESS_VIEW", "ERRORCODE_SUCCESS_VIEW_OP", "MAX_TIME", "TAG", "", "report", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "reportConfigId", "configId", "", "errorCode", "reportIdKey", "id", "reportKv", "plugin-expt_release"})
  public static final class a
  {
    public static void Bt(long paramLong)
    {
      AppMethodBeat.i(221139);
      h.CyF.idkeyStat(932L, paramLong, 1L, false);
      AppMethodBeat.o(221139);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.l
 * JD-Core Version:    0.7.0.1
 */