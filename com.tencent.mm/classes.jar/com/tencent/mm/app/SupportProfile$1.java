package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ao.c;

final class SupportProfile$1
  implements ao.c
{
  SupportProfile$1(SupportProfile paramSupportProfile) {}
  
  public final void b(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(15400);
    h.qsU.idkeyStat(637L, 0L, 1L, false);
    KVCommCrossProcessReceiver.chN();
    AppMethodBeat.o(15400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.SupportProfile.1
 * JD-Core Version:    0.7.0.1
 */