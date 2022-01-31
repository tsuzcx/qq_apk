package com.tencent.e.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class b
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(114518);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(114518);
      return;
    }
    catch (Throwable paramCloseable)
    {
      AppMethodBeat.o(114518);
    }
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(114519);
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
    AppMethodBeat.o(114519);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.d.b.b
 * JD-Core Version:    0.7.0.1
 */