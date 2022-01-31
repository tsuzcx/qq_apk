package com.tencent.f.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  implements b.a
{
  public final boolean isLoggable(String paramString, int paramInt)
  {
    AppMethodBeat.i(63704);
    boolean bool = Log.isLoggable(paramString, paramInt);
    AppMethodBeat.o(63704);
    return bool;
  }
  
  public final void println(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(63703);
    Log.println(paramInt, paramString1, paramString2);
    AppMethodBeat.o(63703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.a.a
 * JD-Core Version:    0.7.0.1
 */