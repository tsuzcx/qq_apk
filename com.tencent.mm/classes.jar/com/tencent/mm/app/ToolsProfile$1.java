package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.c;

final class ToolsProfile$1
  implements at.c
{
  ToolsProfile$1(ToolsProfile paramToolsProfile) {}
  
  public final void a(at paramat, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(195920);
    KVCommCrossProcessReceiver.dyN();
    AppMethodBeat.o(195920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.1
 * JD-Core Version:    0.7.0.1
 */