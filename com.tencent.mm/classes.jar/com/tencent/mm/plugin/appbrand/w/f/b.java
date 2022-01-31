package com.tencent.mm.plugin.appbrand.w.f;

import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public final class b
{
  public static CodingErrorAction hnC = CodingErrorAction.REPORT;
  
  public static String F(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, 0, paramInt, "ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      y.e("MicroMsg.AppBrandNetWork.Charsetfunctions", paramArrayOfByte.toString());
    }
    return "";
  }
  
  public static String w(ByteBuffer paramByteBuffer)
  {
    Object localObject = Charset.forName("UTF8").newDecoder();
    ((CharsetDecoder)localObject).onMalformedInput(hnC);
    ((CharsetDecoder)localObject).onUnmappableCharacter(hnC);
    try
    {
      paramByteBuffer.mark();
      localObject = ((CharsetDecoder)localObject).decode(paramByteBuffer).toString();
      paramByteBuffer.reset();
      return localObject;
    }
    catch (CharacterCodingException paramByteBuffer)
    {
      throw new com.tencent.mm.plugin.appbrand.w.c.b(1007, paramByteBuffer);
    }
  }
  
  public static byte[] wU(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      y.e("MicroMsg.AppBrandNetWork.Charsetfunctions", paramString.toString());
    }
    return new byte[0];
  }
  
  public static byte[] wV(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ASCII");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      y.e("MicroMsg.AppBrandNetWork.Charsetfunctions", paramString.toString());
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.f.b
 * JD-Core Version:    0.7.0.1
 */