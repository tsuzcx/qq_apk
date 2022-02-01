package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class i
{
  public static final byte[] a = new byte[0];
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  private static byte a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return (byte)(paramChar - '0');
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return (byte)(paramChar - 'a' + 10);
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return (byte)(paramChar - 'A' + 10);
    }
    return 0;
  }
  
  private static String a(byte paramByte)
  {
    AppMethodBeat.i(224730);
    int i = b[(paramByte & 0xF)];
    paramByte = (byte)(paramByte >>> 4);
    String str = new String(new char[] { b[(paramByte & 0xF)], i });
    AppMethodBeat.o(224730);
    return str;
  }
  
  private static String a(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(224738);
    paramByteBuffer = paramByteBuffer.duplicate();
    paramByteBuffer.flip();
    byte[] arrayOfByte = new byte[paramByteBuffer.limit()];
    paramByteBuffer.get(arrayOfByte);
    paramByteBuffer = a(arrayOfByte);
    AppMethodBeat.o(224738);
    return paramByteBuffer;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224750);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(224750);
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = b[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2 + 0)] = b[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(224750);
    return paramArrayOfByte;
  }
  
  public static byte[] a(String paramString)
  {
    AppMethodBeat.i(224776);
    if ((paramString == null) || (paramString.equals("")))
    {
      paramString = a;
      AppMethodBeat.o(224776);
      return paramString;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      char c1 = paramString.charAt(i * 2);
      char c2 = paramString.charAt(i * 2 + 1);
      arrayOfByte[i] = ((byte)(a(c1) * 16 + a(c2)));
      i += 1;
    }
    AppMethodBeat.o(224776);
    return arrayOfByte;
  }
  
  private static byte b(String paramString)
  {
    AppMethodBeat.i(224759);
    if ((paramString != null) && (paramString.length() == 1))
    {
      byte b1 = a(paramString.charAt(0));
      AppMethodBeat.o(224759);
      return b1;
    }
    AppMethodBeat.o(224759);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.i
 * JD-Core Version:    0.7.0.1
 */