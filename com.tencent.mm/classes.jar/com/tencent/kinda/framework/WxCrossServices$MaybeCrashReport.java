package com.tencent.kinda.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public class WxCrossServices$MaybeCrashReport
{
  public void judgeReport()
  {
    AppMethodBeat.i(226307);
    long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVC, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVD, Integer.valueOf(0))).intValue();
      com.tencent.mm.plugin.report.service.h.OAn.b(20560, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    }
    reset();
    AppMethodBeat.o(226307);
  }
  
  public void markEnterPay(int paramInt)
  {
    AppMethodBeat.i(226304);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVC, Long.valueOf(System.currentTimeMillis()));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVD, Integer.valueOf(paramInt));
    AppMethodBeat.o(226304);
  }
  
  public void reset()
  {
    AppMethodBeat.i(226305);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVC, Long.valueOf(0L));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVD, Integer.valueOf(0));
    AppMethodBeat.o(226305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.MaybeCrashReport
 * JD-Core Version:    0.7.0.1
 */