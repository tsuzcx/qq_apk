package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.LogDelegate.ILog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$4
  implements LogDelegate.ILog
{
  b$4(b paramb) {}
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(143219);
    ab.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(143219);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(143222);
    ab.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(143222);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(143220);
    ab.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(143220);
  }
  
  public final void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(143223);
    ab.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(143223);
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(143218);
    ab.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(143218);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(143221);
    ab.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(143221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.4
 * JD-Core Version:    0.7.0.1
 */