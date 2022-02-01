package com.tencent.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class f
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(207778);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(207778);
      return;
    }
    catch (Throwable paramCloseable)
    {
      AppMethodBeat.o(207778);
    }
  }
  
  public static long d(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(207780);
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(207780);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.c.f
 * JD-Core Version:    0.7.0.1
 */