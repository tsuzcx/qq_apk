package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.c;

final class AppBrandProfile$1
  implements at.c
{
  AppBrandProfile$1(AppBrandProfile paramAppBrandProfile) {}
  
  public final void a(at paramat, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(195917);
    h.wUl.idkeyStat(365L, 3L, 1L, false);
    KVCommCrossProcessReceiver.dyN();
    AppMethodBeat.o(195917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.AppBrandProfile.1
 * JD-Core Version:    0.7.0.1
 */