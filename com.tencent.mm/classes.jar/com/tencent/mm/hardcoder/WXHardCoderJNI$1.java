package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class WXHardCoderJNI$1
  implements d.a
{
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155945);
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(155945);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155946);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(155946);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155944);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(155944);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(155947);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(155947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.WXHardCoderJNI.1
 * JD-Core Version:    0.7.0.1
 */