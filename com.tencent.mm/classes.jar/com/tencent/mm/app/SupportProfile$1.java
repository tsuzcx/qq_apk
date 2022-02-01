package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.c;

final class SupportProfile$1
  implements at.c
{
  SupportProfile$1(SupportProfile paramSupportProfile) {}
  
  public final void a(at paramat, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(195919);
    h.wUl.idkeyStat(637L, 0L, 1L, false);
    KVCommCrossProcessReceiver.dyN();
    AppMethodBeat.o(195919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.SupportProfile.1
 * JD-Core Version:    0.7.0.1
 */