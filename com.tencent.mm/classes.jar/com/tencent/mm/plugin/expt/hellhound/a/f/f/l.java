package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class l
{
  public static final a qZp;
  
  static
  {
    AppMethodBeat.i(210977);
    qZp = new a((byte)0);
    AppMethodBeat.o(210977);
  }
  
  public static final void vc(long paramLong)
  {
    AppMethodBeat.i(210979);
    a.vc(paramLong);
    AppMethodBeat.o(210979);
  }
  
  public static final void w(long paramLong, int paramInt)
  {
    AppMethodBeat.i(210978);
    gq localgq = new gq();
    localgq.iL((int)paramLong);
    localgq.iM(paramInt);
    localgq.aLk();
    ad.i("HABBYGE-MALI.QualityReport", "reportConfigId: configid=" + paramLong + ", result=" + paramInt);
    AppMethodBeat.o(210978);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/report/QualityReport$Companion;", "", "()V", "ERRORCODE_FAIL_PAGE_SWITCH", "", "ERRORCODE_FAIL_VIEW", "ERRORCODE_FAIL_VIEW_OP", "ERRORCODE_SUCCESS_PAGE_SWITCH", "ERRORCODE_SUCCESS_VIEW", "ERRORCODE_SUCCESS_VIEW_OP", "MAX_TIME", "TAG", "", "report", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "reportConfigId", "configId", "", "errorCode", "reportIdKey", "id", "reportKv", "plugin-expt_release"})
  public static final class a
  {
    public static void vc(long paramLong)
    {
      AppMethodBeat.i(210976);
      g.yhR.idkeyStat(932L, paramLong, 1L, false);
      ad.i("HABBYGE-MALI.QualityReport", "reportIdKey: id=".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(210976);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.l
 * JD-Core Version:    0.7.0.1
 */