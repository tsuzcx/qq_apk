package com.github.henryye.nativeiv.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public final class d
{
  public static InputStream e(InputStream paramInputStream)
  {
    AppMethodBeat.i(115777);
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      if (!(paramInputStream instanceof FileInputStream)) {
        break label40;
      }
    }
    label40:
    for (localObject = new b((FileInputStream)paramInputStream);; localObject = new BufferedInputStream(paramInputStream))
    {
      AppMethodBeat.o(115777);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.d
 * JD-Core Version:    0.7.0.1
 */