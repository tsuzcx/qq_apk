package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KReportService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.report.service.h;

public class ReportServiceImpl
  implements KReportService
{
  public void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(18677);
    h.CyF.idkeyStat(paramLong1, paramLong2, paramLong3, paramBoolean);
    AppMethodBeat.o(18677);
  }
  
  public void kvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(18678);
    h.CyF.kvStat(paramInt, paramString);
    AppMethodBeat.o(18678);
  }
  
  public long svrTimeMs()
  {
    AppMethodBeat.i(18679);
    long l = cl.aWy();
    AppMethodBeat.o(18679);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.ReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */