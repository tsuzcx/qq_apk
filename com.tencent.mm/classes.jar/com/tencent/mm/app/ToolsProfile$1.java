package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.c;

final class ToolsProfile$1
  implements av.c
{
  ToolsProfile$1(ToolsProfile paramToolsProfile) {}
  
  public final void a(av paramav, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(186308);
    KVCommCrossProcessReceiver.dND();
    AppMethodBeat.o(186308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.1
 * JD-Core Version:    0.7.0.1
 */