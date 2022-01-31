package com.google.android.gms.common.util;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Base64Utils
{
  public static byte[] decode(String paramString)
  {
    AppMethodBeat.i(90035);
    if (paramString == null)
    {
      AppMethodBeat.o(90035);
      return null;
    }
    paramString = Base64.decode(paramString, 0);
    AppMethodBeat.o(90035);
    return paramString;
  }
  
  public static byte[] decodeUrlSafe(String paramString)
  {
    AppMethodBeat.i(90036);
    if (paramString == null)
    {
      AppMethodBeat.o(90036);
      return null;
    }
    paramString = Base64.decode(paramString, 10);
    AppMethodBeat.o(90036);
    return paramString;
  }
  
  public static byte[] decodeUrlSafeNoPadding(String paramString)
  {
    AppMethodBeat.i(90037);
    if (paramString == null)
    {
      AppMethodBeat.o(90037);
      return null;
    }
    paramString = Base64.decode(paramString, 11);
    AppMethodBeat.o(90037);
    return paramString;
  }
  
  public static byte[] decodeUrlSafeNoPadding(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90038);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(90038);
      return null;
    }
    paramArrayOfByte = Base64.decode(paramArrayOfByte, 11);
    AppMethodBeat.o(90038);
    return paramArrayOfByte;
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90039);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(90039);
      return null;
    }
    paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 0);
    AppMethodBeat.o(90039);
    return paramArrayOfByte;
  }
  
  public static String encodeUrlSafe(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90040);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(90040);
      return null;
    }
    paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 10);
    AppMethodBeat.o(90040);
    return paramArrayOfByte;
  }
  
  public static String encodeUrlSafeNoPadding(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90041);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(90041);
      return null;
    }
    paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 11);
    AppMethodBeat.o(90041);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.util.Base64Utils
 * JD-Core Version:    0.7.0.1
 */