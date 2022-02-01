package com.tencent.d.e.b.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class b
{
  public static byte[] YY(String paramString)
  {
    AppMethodBeat.i(138450);
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
    AppMethodBeat.o(138450);
    return arrayOfByte;
  }
  
  public static String cN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(138449);
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase(Locale.getDefault()));
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(138449);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */