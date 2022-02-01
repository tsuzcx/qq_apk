package com.tencent.mapsdk.rastercore.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;

public class IO
{
  public static final void safeClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(212532);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(212532);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(212532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tools.IO
 * JD-Core Version:    0.7.0.1
 */