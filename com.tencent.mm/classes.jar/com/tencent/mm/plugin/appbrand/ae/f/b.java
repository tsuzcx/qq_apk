package com.tencent.mm.plugin.appbrand.ae.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public final class b
{
  public static CodingErrorAction ojD = CodingErrorAction.REPORT;
  
  public static String B(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156675);
    Object localObject = Charset.forName("UTF8").newDecoder();
    ((CharsetDecoder)localObject).onMalformedInput(ojD);
    ((CharsetDecoder)localObject).onUnmappableCharacter(ojD);
    try
    {
      paramByteBuffer.mark();
      localObject = ((CharsetDecoder)localObject).decode(paramByteBuffer).toString();
      paramByteBuffer.reset();
      AppMethodBeat.o(156675);
      return localObject;
    }
    catch (CharacterCodingException paramByteBuffer)
    {
      paramByteBuffer = new com.tencent.mm.plugin.appbrand.ae.c.b(1007, paramByteBuffer);
      AppMethodBeat.o(156675);
      throw paramByteBuffer;
    }
  }
  
  public static String K(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(156674);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, 0, paramInt, "ASCII");
      AppMethodBeat.o(156674);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      Log.e("MicroMsg.AppBrandNetWork.Charsetfunctions", paramArrayOfByte.toString());
      AppMethodBeat.o(156674);
    }
    return "";
  }
  
  public static byte[] afS(String paramString)
  {
    AppMethodBeat.i(156672);
    try
    {
      paramString = paramString.getBytes("UTF8");
      AppMethodBeat.o(156672);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Log.e("MicroMsg.AppBrandNetWork.Charsetfunctions", paramString.toString());
      AppMethodBeat.o(156672);
    }
    return new byte[0];
  }
  
  public static byte[] afT(String paramString)
  {
    AppMethodBeat.i(156673);
    try
    {
      paramString = paramString.getBytes("ASCII");
      AppMethodBeat.o(156673);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Log.e("MicroMsg.AppBrandNetWork.Charsetfunctions", paramString.toString());
      AppMethodBeat.o(156673);
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.f.b
 * JD-Core Version:    0.7.0.1
 */