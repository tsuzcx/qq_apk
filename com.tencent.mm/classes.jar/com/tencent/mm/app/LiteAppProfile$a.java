package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.c;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/app/LiteAppProfile$onCreate$1", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler$IOnUncaughtExceptionListener;", "uncaughtException", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "msg", "", "ex", "", "app_release"})
public final class LiteAppProfile$a
  implements av.c
{
  public final void a(av paramav, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(188236);
    p.h(paramav, "ueh");
    p.h(paramString, "msg");
    p.h(paramThrowable, "ex");
    g.yxI.n(1293L, 3L, 1L);
    KVCommCrossProcessReceiver.dND();
    AppMethodBeat.o(188236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.LiteAppProfile.a
 * JD-Core Version:    0.7.0.1
 */