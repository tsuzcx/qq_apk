package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.LogDelegate.ILog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class b$14
  implements LogDelegate.ILog
{
  b$14(b paramb) {}
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(45344);
    ae.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(45344);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(45347);
    ae.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(45347);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(45345);
    ae.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(45345);
  }
  
  public final void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(45348);
    ae.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(45348);
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(45343);
    ae.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(45343);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(45346);
    ae.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(45346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.14
 * JD-Core Version:    0.7.0.1
 */