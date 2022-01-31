package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ao.c;

final class AppBrandProfile$1
  implements ao.c
{
  AppBrandProfile$1(AppBrandProfile paramAppBrandProfile) {}
  
  public final void b(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(15365);
    h.qsU.idkeyStat(365L, 3L, 1L, false);
    KVCommCrossProcessReceiver.chN();
    AppMethodBeat.o(15365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.AppBrandProfile.1
 * JD-Core Version:    0.7.0.1
 */