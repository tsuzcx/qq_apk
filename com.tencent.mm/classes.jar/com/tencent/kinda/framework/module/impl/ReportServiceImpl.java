package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KReportService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.report.service.h;

public class ReportServiceImpl
  implements KReportService
{
  public void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(144567);
    h.qsU.idkeyStat(paramLong1, paramLong2, paramLong3, paramBoolean);
    AppMethodBeat.o(144567);
  }
  
  public void kvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(144568);
    h.qsU.kvStat(paramInt, paramString);
    AppMethodBeat.o(144568);
  }
  
  public long svrTimeMs()
  {
    AppMethodBeat.i(144569);
    long l = cb.abp();
    AppMethodBeat.o(144569);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.ReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */