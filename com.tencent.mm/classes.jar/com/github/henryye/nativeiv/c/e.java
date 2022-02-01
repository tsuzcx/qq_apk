package com.github.henryye.nativeiv.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public final class e
{
  public static InputStream l(InputStream paramInputStream)
  {
    AppMethodBeat.i(127399);
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      if (!(paramInputStream instanceof FileInputStream)) {
        break label40;
      }
    }
    label40:
    for (localObject = new c((FileInputStream)paramInputStream);; localObject = new BufferedInputStream(paramInputStream))
    {
      AppMethodBeat.o(127399);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.c.e
 * JD-Core Version:    0.7.0.1
 */