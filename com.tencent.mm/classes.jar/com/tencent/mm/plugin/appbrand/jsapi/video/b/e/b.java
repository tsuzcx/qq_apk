package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final char[] pxZ = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final byte[] pya = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  public static byte[] decode(String paramString)
  {
    AppMethodBeat.i(227743);
    byte[] arrayOfByte1 = new byte[paramString.length() / 2];
    int k = paramString.length() / 2;
    int i = 0;
    int j = 0;
    while (j < k * 2)
    {
      byte[] arrayOfByte2 = pya;
      int m = j + 1;
      int n = arrayOfByte2[paramString.charAt(j)];
      arrayOfByte2 = pya;
      j = m + 1;
      arrayOfByte1[i] = ((byte)(n << 4 | arrayOfByte2[paramString.charAt(m)]));
      i += 1;
    }
    AppMethodBeat.o(227743);
    return arrayOfByte1;
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(227739);
    int j = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder(j * 2);
    int i = 0;
    while (i < j + 0)
    {
      localStringBuilder.append(pxZ[((paramArrayOfByte[i] & 0xF0) >> 4)]);
      localStringBuilder.append(pxZ[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(227739);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.b
 * JD-Core Version:    0.7.0.1
 */