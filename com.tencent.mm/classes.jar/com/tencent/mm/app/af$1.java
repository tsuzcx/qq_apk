package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.svg.b.c.a;

final class af$1
  implements c.a
{
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(19468);
    Log.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(19468);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(19467);
    Log.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(19467);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(19466);
    Log.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(19466);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(19469);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(19469);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(19465);
    Log.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(19465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.af.1
 * JD-Core Version:    0.7.0.1
 */