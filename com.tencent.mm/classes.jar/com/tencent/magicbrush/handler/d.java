package com.tencent.magicbrush.handler;

import com.tencent.magicbrush.a.d.f;
import java.io.UnsupportedEncodingException;

final class d
{
  static String decodeString(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramString);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      d.f.d("MicroMsg.MBStringCharsetHandler", "UnsupportedDecoding [" + paramString + "] " + paramArrayOfByte.getMessage(), new Object[0]);
    }
    return null;
  }
  
  static byte[] encodeString(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      d.f.d("MicroMsg.MBStringCharsetHandler", "UnsupportedEncoding [" + paramString2 + "] " + paramString1.getMessage(), new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.d
 * JD-Core Version:    0.7.0.1
 */