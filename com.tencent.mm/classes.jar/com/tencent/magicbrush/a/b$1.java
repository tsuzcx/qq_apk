package com.tencent.magicbrush.a;

import com.tencent.magicbrush.utils.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements b.a
{
  public final String eA(String paramString)
  {
    AppMethodBeat.i(203619);
    paramString = i.findLibPath(paramString);
    AppMethodBeat.o(203619);
    return paramString;
  }
  
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(139955);
    i.eG(paramString);
    AppMethodBeat.o(139955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.a.b.1
 * JD-Core Version:    0.7.0.1
 */