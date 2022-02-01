package com.github.henryye.nativeiv.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;

public final class b
{
  public static void b(Closeable paramCloseable)
  {
    AppMethodBeat.i(127394);
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(127394);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(127394);
      return;
    }
    catch (IllegalStateException paramCloseable)
    {
      label18:
      break label18;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.c.b
 * JD-Core Version:    0.7.0.1
 */