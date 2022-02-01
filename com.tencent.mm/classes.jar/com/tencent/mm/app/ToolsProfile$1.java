package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;

final class ToolsProfile$1
  implements MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
{
  ToolsProfile$1(ToolsProfile paramToolsProfile) {}
  
  public final void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(231393);
    KVCommCrossProcessReceiver.eOD();
    AppMethodBeat.o(231393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.1
 * JD-Core Version:    0.7.0.1
 */