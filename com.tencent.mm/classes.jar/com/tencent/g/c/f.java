package com.tencent.g.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public final class f
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(212032);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    finally
    {
      AppMethodBeat.o(212032);
    }
  }
  
  public static long f(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(212040);
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
    AppMethodBeat.o(212040);
    return l;
  }
  
  public static void z(Cursor paramCursor)
  {
    AppMethodBeat.i(212037);
    if (paramCursor != null) {}
    try
    {
      paramCursor.close();
      return;
    }
    finally
    {
      AppMethodBeat.o(212037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.g.c.f
 * JD-Core Version:    0.7.0.1
 */