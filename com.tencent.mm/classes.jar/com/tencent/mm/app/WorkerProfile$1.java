package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.as.a;

final class WorkerProfile$1
  implements as.a
{
  WorkerProfile$1(WorkerProfile paramWorkerProfile) {}
  
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19539);
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(19539);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19542);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(19542);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19540);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(19540);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19538);
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(19538);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19541);
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(19541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.1
 * JD-Core Version:    0.7.0.1
 */