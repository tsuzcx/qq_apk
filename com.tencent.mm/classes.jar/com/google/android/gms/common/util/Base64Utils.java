package com.google.android.gms.common.util;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Base64Utils
{
  public static byte[] decode(String paramString)
  {
    AppMethodBeat.i(5057);
    if (paramString == null)
    {
      AppMethodBeat.o(5057);
      return null;
    }
    paramString = Base64.decode(paramString, 0);
    AppMethodBeat.o(5057);
    return paramString;
  }
  
  public static byte[] decodeUrlSafe(String paramString)
  {
    AppMethodBeat.i(5058);
    if (paramString == null)
    {
      AppMethodBeat.o(5058);
      return null;
    }
    paramString = Base64.decode(paramString, 10);
    AppMethodBeat.o(5058);
    return paramString;
  }
  
  public static byte[] decodeUrlSafeNoPadding(String paramString)
  {
    AppMethodBeat.i(5059);
    if (paramString == null)
    {
      AppMethodBeat.o(5059);
      return null;
    }
    paramString = Base64.decode(paramString, 11);
    AppMethodBeat.o(5059);
    return paramString;
  }
  
  public static byte[] decodeUrlSafeNoPadding(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5060);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(5060);
      return null;
    }
    paramArrayOfByte = Base64.decode(paramArrayOfByte, 11);
    AppMethodBeat.o(5060);
    return paramArrayOfByte;
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5061);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(5061);
      return null;
    }
    paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 0);
    AppMethodBeat.o(5061);
    return paramArrayOfByte;
  }
  
  public static String encodeUrlSafe(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5062);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(5062);
      return null;
    }
    paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 10);
    AppMethodBeat.o(5062);
    return paramArrayOfByte;
  }
  
  public static String encodeUrlSafeNoPadding(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5063);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(5063);
      return null;
    }
    paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 11);
    AppMethodBeat.o(5063);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.Base64Utils
 * JD-Core Version:    0.7.0.1
 */