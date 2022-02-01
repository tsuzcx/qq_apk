package com.tencent.e.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class c
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(138359);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    finally
    {
      AppMethodBeat.o(138359);
    }
  }
  
  public static long f(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(138360);
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
    AppMethodBeat.o(138360);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.d.b.c
 * JD-Core Version:    0.7.0.1
 */