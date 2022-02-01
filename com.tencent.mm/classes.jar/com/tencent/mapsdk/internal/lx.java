package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class lx
  implements ma
{
  private static byte a(InputStream paramInputStream)
  {
    AppMethodBeat.i(222771);
    byte b = (byte)paramInputStream.read();
    AppMethodBeat.o(222771);
    return b;
  }
  
  private static long a(int paramInt, InputStream paramInputStream)
  {
    AppMethodBeat.i(222844);
    long l = 0L;
    paramInt -= 1;
    while (paramInt >= 0)
    {
      l |= ((byte)paramInputStream.read() & 0xFF) << paramInt * 8;
      paramInt -= 1;
    }
    AppMethodBeat.o(222844);
    return l;
  }
  
  private static byte[] a(InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(222780);
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt) {
      i += paramInputStream.read(arrayOfByte, i, paramInt - i);
    }
    AppMethodBeat.o(222780);
    return arrayOfByte;
  }
  
  private static boolean b(InputStream paramInputStream)
  {
    AppMethodBeat.i(222789);
    if ((byte)paramInputStream.read() == 0)
    {
      AppMethodBeat.o(222789);
      return false;
    }
    AppMethodBeat.o(222789);
    return true;
  }
  
  private static int c(InputStream paramInputStream)
  {
    AppMethodBeat.i(222797);
    int i = (int)a(2, paramInputStream);
    AppMethodBeat.o(222797);
    return i;
  }
  
  private static char d(InputStream paramInputStream)
  {
    AppMethodBeat.i(222801);
    long l = 0L;
    int i = 0;
    while (i < 2)
    {
      l |= ((byte)paramInputStream.read() & 0xFF) << i * 8;
      i += 1;
    }
    char c = (char)(int)l;
    AppMethodBeat.o(222801);
    return c;
  }
  
  private static int e(InputStream paramInputStream)
  {
    AppMethodBeat.i(222814);
    int i = (int)a(4, paramInputStream);
    AppMethodBeat.o(222814);
    return i;
  }
  
  private static long f(InputStream paramInputStream)
  {
    AppMethodBeat.i(222823);
    long l = a(8, paramInputStream);
    AppMethodBeat.o(222823);
    return l;
  }
  
  private static String g(InputStream paramInputStream)
  {
    AppMethodBeat.i(222835);
    int j = (int)a(2, paramInputStream);
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j) {
      i += paramInputStream.read(arrayOfByte, i, j - i);
    }
    paramInputStream = new String(arrayOfByte);
    AppMethodBeat.o(222835);
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lx
 * JD-Core Version:    0.7.0.1
 */