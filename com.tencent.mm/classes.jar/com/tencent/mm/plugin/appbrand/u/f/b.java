package com.tencent.mm.plugin.appbrand.u.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public final class b
{
  public static CodingErrorAction jaa = CodingErrorAction.REPORT;
  
  public static byte[] FA(String paramString)
  {
    AppMethodBeat.i(73274);
    try
    {
      paramString = paramString.getBytes("UTF8");
      AppMethodBeat.o(73274);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ab.e("MicroMsg.AppBrandNetWork.Charsetfunctions", paramString.toString());
      AppMethodBeat.o(73274);
    }
    return new byte[0];
  }
  
  public static byte[] FB(String paramString)
  {
    AppMethodBeat.i(73275);
    try
    {
      paramString = paramString.getBytes("ASCII");
      AppMethodBeat.o(73275);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ab.e("MicroMsg.AppBrandNetWork.Charsetfunctions", paramString.toString());
      AppMethodBeat.o(73275);
    }
    return new byte[0];
  }
  
  public static String G(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(73276);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, 0, paramInt, "ASCII");
      AppMethodBeat.o(73276);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      ab.e("MicroMsg.AppBrandNetWork.Charsetfunctions", paramArrayOfByte.toString());
      AppMethodBeat.o(73276);
    }
    return "";
  }
  
  public static String x(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(73277);
    Object localObject = Charset.forName("UTF8").newDecoder();
    ((CharsetDecoder)localObject).onMalformedInput(jaa);
    ((CharsetDecoder)localObject).onUnmappableCharacter(jaa);
    try
    {
      paramByteBuffer.mark();
      localObject = ((CharsetDecoder)localObject).decode(paramByteBuffer).toString();
      paramByteBuffer.reset();
      AppMethodBeat.o(73277);
      return localObject;
    }
    catch (CharacterCodingException paramByteBuffer)
    {
      paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.c.b(1007, paramByteBuffer);
      AppMethodBeat.o(73277);
      throw paramByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.f.b
 * JD-Core Version:    0.7.0.1
 */