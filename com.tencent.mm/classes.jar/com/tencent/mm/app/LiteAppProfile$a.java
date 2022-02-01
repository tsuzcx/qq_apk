package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/app/LiteAppProfile$onCreate$1", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler$IOnUncaughtExceptionListener;", "uncaughtException", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "msg", "", "ex", "", "app_release"})
public final class LiteAppProfile$a
  implements MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
{
  public final void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(230591);
    p.h(paramMMUncaughtExceptionHandler, "ueh");
    p.h(paramString, "msg");
    p.h(paramThrowable, "ex");
    h.CyF.n(1293L, 3L, 1L);
    KVCommCrossProcessReceiver.eOD();
    AppMethodBeat.o(230591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.LiteAppProfile.a
 * JD-Core Version:    0.7.0.1
 */