package com.tencent.magicbrush.handler;

import android.support.annotation.Keep;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

@Keep
public class MBCharsetHandler
{
  private static final String TAG = "MicroMsg.MBCharsetHandler";
  
  @Keep
  static String decode(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(115897);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(115897);
      return null;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramString);
      AppMethodBeat.o(115897);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;)
      {
        c.c.e("MicroMsg.MBCharsetHandler", "UnsupportedDecoding [%s] [%s]", new Object[] { paramString, paramArrayOfByte });
        paramArrayOfByte = null;
      }
    }
  }
  
  @Keep
  public static byte[] encode(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(115896);
    if (paramString1 == null)
    {
      AppMethodBeat.o(115896);
      return null;
    }
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      AppMethodBeat.o(115896);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        c.c.e("MicroMsg.MBCharsetHandler", "MBCharsetHandler encode failed. [%s]", new Object[] { paramString1 });
        paramString1 = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.MBCharsetHandler
 * JD-Core Version:    0.7.0.1
 */