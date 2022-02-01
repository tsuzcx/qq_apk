package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class h$3
  implements l.a
{
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(182899);
    Log.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(182899);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(182896);
    Log.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(182896);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(182898);
    Log.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(182898);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(182900);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(182900);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(182897);
    Log.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(182897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kernel.h.3
 * JD-Core Version:    0.7.0.1
 */