package com.tencent.mapsdk.rastercore.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;

public class IO
{
  public static final void safeClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(186695);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(186695);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(186695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tools.IO
 * JD-Core Version:    0.7.0.1
 */