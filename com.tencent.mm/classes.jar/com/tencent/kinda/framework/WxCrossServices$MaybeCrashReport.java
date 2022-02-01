package com.tencent.kinda.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public class WxCrossServices$MaybeCrashReport
{
  public void judgeReport()
  {
    AppMethodBeat.i(199422);
    long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICQ, Long.valueOf(0L))).longValue();
    if (l > 0L)
    {
      int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICR, Integer.valueOf(0))).intValue();
      com.tencent.mm.plugin.report.service.g.yhR.f(20560, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    }
    reset();
    AppMethodBeat.o(199422);
  }
  
  public void markEnterPay(int paramInt)
  {
    AppMethodBeat.i(199420);
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICQ, Long.valueOf(System.currentTimeMillis()));
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICR, Integer.valueOf(paramInt));
    AppMethodBeat.o(199420);
  }
  
  public void reset()
  {
    AppMethodBeat.i(199421);
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICQ, Long.valueOf(0L));
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICR, Integer.valueOf(0));
    AppMethodBeat.o(199421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.MaybeCrashReport
 * JD-Core Version:    0.7.0.1
 */