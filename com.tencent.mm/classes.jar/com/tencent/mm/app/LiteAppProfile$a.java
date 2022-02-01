package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.c;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/app/LiteAppProfile$onCreate$1", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler$IOnUncaughtExceptionListener;", "uncaughtException", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "msg", "", "ex", "", "app_release"})
public final class LiteAppProfile$a
  implements at.c
{
  public final void a(at paramat, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(196979);
    k.h(paramat, "ueh");
    k.h(paramString, "msg");
    k.h(paramThrowable, "ex");
    h.wUl.n(1293L, 3L, 1L);
    KVCommCrossProcessReceiver.dyN();
    AppMethodBeat.o(196979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.LiteAppProfile.a
 * JD-Core Version:    0.7.0.1
 */