package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class V8$1
  implements ILoadLibraryDelegate
{
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(61784);
    LibraryLoader.loadLibrary(paramString);
    AppMethodBeat.o(61784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.V8.1
 * JD-Core Version:    0.7.0.1
 */