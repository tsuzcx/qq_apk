package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ao.c;

final class ToolsProfile$1
  implements ao.c
{
  ToolsProfile$1(ToolsProfile paramToolsProfile) {}
  
  public final void b(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(15405);
    KVCommCrossProcessReceiver.chN();
    AppMethodBeat.o(15405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.1
 * JD-Core Version:    0.7.0.1
 */