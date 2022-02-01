package com.tencent.kinda.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public class WxCrossServices$MaybeCrashReport
{
  public void judgeReport()
  {
    AppMethodBeat.i(214412);
    long l = ((Long)g.aAh().azQ().get(ar.a.OfJ, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      int i = ((Integer)g.aAh().azQ().get(ar.a.OfK, Integer.valueOf(0))).intValue();
      h.CyF.a(20560, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    }
    reset();
    AppMethodBeat.o(214412);
  }
  
  public void markEnterPay(int paramInt)
  {
    AppMethodBeat.i(214410);
    g.aAh().azQ().set(ar.a.OfJ, Long.valueOf(System.currentTimeMillis()));
    g.aAh().azQ().set(ar.a.OfK, Integer.valueOf(paramInt));
    AppMethodBeat.o(214410);
  }
  
  public void reset()
  {
    AppMethodBeat.i(214411);
    g.aAh().azQ().set(ar.a.OfJ, Long.valueOf(0L));
    g.aAh().azQ().set(ar.a.OfK, Integer.valueOf(0));
    AppMethodBeat.o(214411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.MaybeCrashReport
 * JD-Core Version:    0.7.0.1
 */