package com.tencent.mm.ipcinvoker.h;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements com.tencent.mm.ipcinvoker.h.a.a
{
  public final void printLog(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(158834);
    if (paramInt < 4)
    {
      AppMethodBeat.o(158834);
      return;
    }
    Log.println(paramInt, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(158834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h.a
 * JD-Core Version:    0.7.0.1
 */