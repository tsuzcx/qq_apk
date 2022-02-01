package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.sdk.platformtools.Log;

final class WorkerProfile$4
  implements ILog
{
  WorkerProfile$4(WorkerProfile paramWorkerProfile) {}
  
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(239129);
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(239129);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(239144);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(239144);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(239133);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(239133);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(239121);
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(239121);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(239139);
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(239139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.4
 * JD-Core Version:    0.7.0.1
 */