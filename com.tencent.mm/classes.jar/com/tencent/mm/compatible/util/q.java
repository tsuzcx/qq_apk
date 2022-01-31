package com.tencent.mm.compatible.util;

import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.BitSet;

public final class q
{
  static BitSet dAb;
  static String dAc = (String)AccessController.doPrivileged(new i("file.encoding"));
  
  static
  {
    dAb = new BitSet(256);
    int i = 97;
    while (i <= 122)
    {
      dAb.set(i);
      i += 1;
    }
    i = 65;
    while (i <= 90)
    {
      dAb.set(i);
      i += 1;
    }
    i = 48;
    while (i <= 57)
    {
      dAb.set(i);
      i += 1;
    }
    dAb.set(45);
    dAb.set(95);
    dAb.set(46);
    dAb.set(42);
  }
  
  @Deprecated
  public static String encode(String paramString)
  {
    try
    {
      paramString = encode(paramString, dAc);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public static String encode(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString1.length());
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    if (paramString2 == null) {
      throw new NullPointerException("charsetName");
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
        if (dAb.get(k))
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
        throw new UnsupportedEncodingException(paramString2);
      }
      catch (UnsupportedCharsetException paramString1)
      {
        throw new UnsupportedEncodingException(paramString2);
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
        paramString2 = dAb;
        m = paramString1.charAt(k);
        j = m;
        i = k;
      } while (!paramString2.get(m));
      localCharArrayWriter.flush();
      String str = new String(localCharArrayWriter.toCharArray());
      new p();
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
    if (j != 0) {
      paramString1 = localStringBuffer.toString();
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.util.q
 * JD-Core Version:    0.7.0.1
 */