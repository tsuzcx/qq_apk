package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.BitSet;

public final class r
{
  static BitSet lZj;
  static String lZk;
  
  static
  {
    AppMethodBeat.i(155915);
    lZk = null;
    lZj = new BitSet(256);
    int i = 97;
    while (i <= 122)
    {
      lZj.set(i);
      i += 1;
    }
    i = 65;
    while (i <= 90)
    {
      lZj.set(i);
      i += 1;
    }
    i = 48;
    while (i <= 57)
    {
      lZj.set(i);
      i += 1;
    }
    lZj.set(45);
    lZj.set(95);
    lZj.set(46);
    lZj.set(42);
    lZk = (String)AccessController.doPrivileged(new i("file.encoding"));
    AppMethodBeat.o(155915);
  }
  
  public static String as(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155914);
    StringBuffer localStringBuffer = new StringBuffer(paramString1.length());
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    if (paramString2 == null)
    {
      paramString1 = new NullPointerException("charsetName");
      AppMethodBeat.o(155914);
      throw paramString1;
    }
    int j;
    for (;;)
    {
      Charset localCharset;
      int k;
      try
      {
        localCharset = Charset.forName(paramString2);
        j = 0;
        i = 0;
        if (i >= paramString1.length()) {
          break;
        }
        k = paramString1.charAt(i);
        if (lZj.get(k))
        {
          if (k == 32) {
            j = 1;
          }
          localStringBuffer.append((char)k);
          i += 1;
          continue;
        }
        j = k;
      }
      catch (IllegalCharsetNameException paramString1)
      {
        paramString1 = new UnsupportedEncodingException(paramString2);
        AppMethodBeat.o(155914);
        throw paramString1;
      }
      catch (UnsupportedCharsetException paramString1)
      {
        paramString1 = new UnsupportedEncodingException(paramString2);
        AppMethodBeat.o(155914);
        throw paramString1;
      }
      int m;
      do
      {
        localCharArrayWriter.write(j);
        k = i;
        if (j >= 55296)
        {
          k = i;
          if (j <= 56319)
          {
            k = i;
            if (i + 1 < paramString1.length())
            {
              j = paramString1.charAt(i + 1);
              k = i;
              if (j >= 56320)
              {
                k = i;
                if (j <= 57343)
                {
                  localCharArrayWriter.write(j);
                  k = i + 1;
                }
              }
            }
          }
        }
        k += 1;
        if (k >= paramString1.length()) {
          break;
        }
        paramString2 = lZj;
        m = paramString1.charAt(k);
        j = m;
        i = k;
      } while (!paramString2.get(m));
      localCharArrayWriter.flush();
      String str = new String(localCharArrayWriter.toCharArray());
      new q();
      byte[] arrayOfByte = str.getBytes(localCharset);
      paramString2 = arrayOfByte;
      if (arrayOfByte == null) {
        paramString2 = str.getBytes();
      }
      int i = 0;
      while (i < paramString2.length)
      {
        localStringBuffer.append('%');
        char c2 = Character.forDigit(paramString2[i] >> 4 & 0xF, 16);
        char c1 = c2;
        if (Character.isLetter(c2)) {
          c1 = (char)(c2 - ' ');
        }
        localStringBuffer.append(c1);
        c2 = Character.forDigit(paramString2[i] & 0xF, 16);
        c1 = c2;
        if (Character.isLetter(c2)) {
          c1 = (char)(c2 - ' ');
        }
        localStringBuffer.append(c1);
        i += 1;
      }
      localCharArrayWriter.reset();
      j = 1;
      i = k;
    }
    if (j != 0)
    {
      paramString1 = localStringBuffer.toString();
      AppMethodBeat.o(155914);
      return paramString1;
    }
    AppMethodBeat.o(155914);
    return paramString1;
  }
  
  @Deprecated
  public static String cg(String paramString)
  {
    AppMethodBeat.i(155913);
    Object localObject = null;
    try
    {
      paramString = as(paramString, lZk);
      AppMethodBeat.o(155913);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.util.r
 * JD-Core Version:    0.7.0.1
 */