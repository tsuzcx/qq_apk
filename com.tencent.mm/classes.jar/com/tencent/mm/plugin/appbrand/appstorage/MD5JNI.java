package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.StandardCharsets;

public class MD5JNI
{
  private static final byte[] HEX_ARRAY;
  
  static
  {
    AppMethodBeat.i(323212);
    HEX_ARRAY = "0123456789abcdef".getBytes(StandardCharsets.US_ASCII);
    AppMethodBeat.o(323212);
  }
  
  public static String bytesToHexStringFast(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(323206);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(323206);
      return "";
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfByte[(i * 2)] = HEX_ARRAY[(j >>> 4)];
      arrayOfByte[(i * 2 + 1)] = HEX_ARRAY[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfByte, StandardCharsets.UTF_8);
    AppMethodBeat.o(323206);
    return paramArrayOfByte;
  }
  
  public static native int getMD5String(String paramString, String[] paramArrayOfString);
  
  public static native int getMD5StringLegacy(String paramString, String[] paramArrayOfString);
  
  public static String getMD5Wrap(String paramString)
  {
    AppMethodBeat.i(102766);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(102766);
      return null;
    }
    String[] arrayOfString = new String[1];
    getMD5String(paramString, arrayOfString);
    paramString = arrayOfString[0];
    AppMethodBeat.o(102766);
    return paramString;
  }
  
  public static String getMD5WrapLegacy(String paramString)
  {
    AppMethodBeat.i(323209);
    String[] arrayOfString = new String[1];
    getMD5StringLegacy(paramString, arrayOfString);
    paramString = arrayOfString[0];
    AppMethodBeat.o(323209);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.MD5JNI
 * JD-Core Version:    0.7.0.1
 */