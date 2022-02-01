package com.tencent.mapsdk.rastercore.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;

public class IO
{
  public static final void safeClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(217191);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(217191);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(217191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tools.IO
 * JD-Core Version:    0.7.0.1
 */