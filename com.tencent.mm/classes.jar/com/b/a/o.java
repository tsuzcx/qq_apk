package com.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class o
{
  static String cg(String paramString)
  {
    AppMethodBeat.i(183613);
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      AppMethodBeat.o(183613);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new RuntimeException("Error encoding url", paramString);
      AppMethodBeat.o(183613);
      throw paramString;
    }
  }
  
  static String ch(String paramString)
  {
    AppMethodBeat.i(183614);
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      AppMethodBeat.o(183614);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new RuntimeException("Error decoding url", paramString);
      AppMethodBeat.o(183614);
      throw paramString;
    }
  }
  
  public static String ci(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(183616);
    try
    {
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      StringBuffer localStringBuffer = new StringBuffer();
      int j = paramString.length;
      while (i < j)
      {
        localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramString[i]) }));
        i += 1;
      }
      paramString = localStringBuffer.toString();
      AppMethodBeat.o(183616);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(183616);
      throw paramString;
    }
  }
  
  static void close(Closeable paramCloseable)
  {
    AppMethodBeat.i(183615);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(183615);
        return;
      }
      catch (IOException paramCloseable)
      {
        k.OX();
      }
    }
    AppMethodBeat.o(183615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.o
 * JD-Core Version:    0.7.0.1
 */