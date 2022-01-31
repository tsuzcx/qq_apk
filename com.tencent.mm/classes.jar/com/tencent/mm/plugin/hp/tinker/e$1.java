package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tinker.lib.f.a.a;

final class e$1
  implements a.a
{
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90644);
    ab.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(90644);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90642);
    ab.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(90642);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90645);
    ab.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(90645);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90643);
    ab.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(90643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.e.1
 * JD-Core Version:    0.7.0.1
 */