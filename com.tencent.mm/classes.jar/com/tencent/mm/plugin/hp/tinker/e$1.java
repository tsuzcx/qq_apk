package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.lib.f.a;

final class e$1
  implements a
{
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(194993);
    Log.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(194993);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(117480);
    Log.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(117480);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(117478);
    Log.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(117478);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(117481);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(117481);
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(194990);
    Log.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(194990);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(117479);
    Log.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(117479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.e.1
 * JD-Core Version:    0.7.0.1
 */