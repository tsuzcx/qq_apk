package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bc.a;

final class WorkerProfile$1
  implements bc.a
{
  WorkerProfile$1(WorkerProfile paramWorkerProfile) {}
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(239112);
    Log.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(239112);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(239126);
    Log.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(239126);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(239117);
    Log.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(239117);
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(239106);
    Log.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(239106);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(239123);
    Log.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(239123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.1
 * JD-Core Version:    0.7.0.1
 */