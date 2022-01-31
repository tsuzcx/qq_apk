package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Hex
{
  private static final char[] zzaaa = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] zzzz = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String bytesToColonDelimitedStringLowercase(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90206);
    if (paramArrayOfByte.length == 0)
    {
      paramArrayOfByte = new String();
      AppMethodBeat.o(90206);
      return paramArrayOfByte;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 3 - 1];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length - 1)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      int m = j + 1;
      arrayOfChar[j] = zzaaa[(k >>> 4)];
      j = m + 1;
      arrayOfChar[m] = zzaaa[(k & 0xF)];
      arrayOfChar[j] = ':';
      i += 1;
      j += 1;
    }
    i = paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF;
    arrayOfChar[j] = zzaaa[(i >>> 4)];
    arrayOfChar[(j + 1)] = zzaaa[(i & 0xF)];
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(90206);
    return paramArrayOfByte;
  }
  
  public static String bytesToColonDelimitedStringUppercase(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90205);
    if (paramArrayOfByte.length == 0)
    {
      paramArrayOfByte = new String();
      AppMethodBeat.o(90205);
      return paramArrayOfByte;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 3 - 1];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length - 1)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      int m = j + 1;
      arrayOfChar[j] = zzzz[(k >>> 4)];
      j = m + 1;
      arrayOfChar[m] = zzzz[(k & 0xF)];
      arrayOfChar[j] = ':';
      i += 1;
      j += 1;
    }
    i = paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF;
    arrayOfChar[j] = zzzz[(i >>> 4)];
    arrayOfChar[(j + 1)] = zzzz[(i & 0xF)];
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(90205);
    return paramArrayOfByte;
  }
  
  public static String bytesToStringLowercase(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90204);
    char[] arrayOfChar = new char[paramArrayOfByte.length << 1];
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfByte.length; j = k + 1)
    {
      int m = paramArrayOfByte[i] & 0xFF;
      k = j + 1;
      arrayOfChar[j] = zzaaa[(m >>> 4)];
      arrayOfChar[k] = zzaaa[(m & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(90204);
    return paramArrayOfByte;
  }
  
  public static String bytesToStringUppercase(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90202);
    paramArrayOfByte = bytesToStringUppercase(paramArrayOfByte, false);
    AppMethodBeat.o(90202);
    return paramArrayOfByte;
  }
  
  public static String bytesToStringUppercase(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(90203);
    int j = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder(j << 1);
    int i = 0;
    while ((i < j) && ((!paramBoolean) || (i != j - 1) || ((paramArrayOfByte[i] & 0xFF) != 0)))
    {
      localStringBuilder.append(zzzz[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(zzzz[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(90203);
    return paramArrayOfByte;
  }
  
  public static byte[] colonDelimitedStringToBytes(String paramString)
  {
    AppMethodBeat.i(90207);
    paramString = stringToBytes(paramString.replace(":", ""));
    AppMethodBeat.o(90207);
    return paramString;
  }
  
  public static byte[] stringToBytes(String paramString)
  {
    AppMethodBeat.i(90208);
    int j = paramString.length();
    if (j % 2 != 0)
    {
      paramString = new IllegalArgumentException("Hex string has odd number of characters");
      AppMethodBeat.o(90208);
      throw paramString;
    }
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(paramString.substring(i, i + 2), 16));
      i += 2;
    }
    AppMethodBeat.o(90208);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.Hex
 * JD-Core Version:    0.7.0.1
 */