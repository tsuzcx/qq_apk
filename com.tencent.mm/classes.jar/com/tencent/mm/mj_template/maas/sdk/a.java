package com.tencent.mm.mj_template.maas.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  public static long a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(240079);
    int i;
    for (long l = 0L; l < 8L; l += i)
    {
      i = paramInputStream.read(paramArrayOfByte, (int)(0L + l), (int)(8L - l));
      if (i == -1)
      {
        paramInputStream = new IOException("Bzip2 EOF");
        AppMethodBeat.o(240079);
        throw paramInputStream;
      }
    }
    AppMethodBeat.o(240079);
    return 8L;
  }
  
  public static InputStream a(byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(240071);
    long l = paramLong2;
    if (paramLong2 == -1L) {
      l = paramArrayOfByte.length - paramLong1;
    }
    paramArrayOfByte = new org.apache.commons.a.a.a.a(new ByteArrayInputStream(paramArrayOfByte, (int)paramLong1, (int)l));
    AppMethodBeat.o(240071);
    return paramArrayOfByte;
  }
  
  public static final boolean a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240066);
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j < 0)
      {
        AppMethodBeat.o(240066);
        return false;
      }
      i += j;
    }
    AppMethodBeat.o(240066);
    return true;
  }
  
  public static long z(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt + 7;
    long l = paramArrayOfByte[j] & 0x7F;
    int i;
    label29:
    int k;
    if ((paramArrayOfByte[j] & 0x80) != 0)
    {
      paramInt = 1;
      i = 6;
      if (i < 0) {
        break label86;
      }
      k = j - 1;
      j = paramArrayOfByte[k];
      if (j < 0) {
        break label76;
      }
    }
    label76:
    for (j = (short)j;; j = (short)(j + 256))
    {
      l = l * 256L + j;
      i -= 1;
      j = k;
      break label29;
      paramInt = 0;
      break;
    }
    label86:
    if (paramInt != 0) {
      return -l;
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.sdk.a
 * JD-Core Version:    0.7.0.1
 */