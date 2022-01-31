package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class HexUtil
{
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final byte[] emptybytes = new byte[0];
  
  public static String byte2HexStr(byte paramByte)
  {
    AppMethodBeat.i(117183);
    int i = digits[(paramByte & 0xF)];
    paramByte = (byte)(paramByte >>> 4);
    String str = new String(new char[] { digits[(paramByte & 0xF)], i });
    AppMethodBeat.o(117183);
    return str;
  }
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117184);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(117184);
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length)
      {
        paramArrayOfByte = new String(arrayOfChar);
        AppMethodBeat.o(117184);
        return paramArrayOfByte;
      }
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2 + 0)] = digits[(j & 0xF)];
      i += 1;
    }
  }
  
  public static byte char2Byte(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return (byte)(paramChar - '0');
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return (byte)(paramChar - 'a' + 10);
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return (byte)(paramChar - 'A' + 10);
    }
    return 0;
  }
  
  public static byte hexStr2Byte(String paramString)
  {
    AppMethodBeat.i(117185);
    if ((paramString != null) && (paramString.length() == 1))
    {
      byte b = char2Byte(paramString.charAt(0));
      AppMethodBeat.o(117185);
      return b;
    }
    AppMethodBeat.o(117185);
    return 0;
  }
  
  public static byte[] hexStr2Bytes(String paramString)
  {
    AppMethodBeat.i(117186);
    if ((paramString == null) || (paramString.equals("")))
    {
      paramString = emptybytes;
      AppMethodBeat.o(117186);
      return paramString;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfByte.length)
      {
        AppMethodBeat.o(117186);
        return arrayOfByte;
      }
      char c1 = paramString.charAt(i * 2);
      char c2 = paramString.charAt(i * 2 + 1);
      arrayOfByte[i] = ((byte)(char2Byte(c1) * 16 + char2Byte(c2)));
      i += 1;
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    AppMethodBeat.i(117187);
    try
    {
      paramArrayOfString = "Hello WebSocket World?".getBytes("gbk");
      System.out.println(bytes2HexStr(paramArrayOfString));
      AppMethodBeat.o(117187);
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfString)
    {
      AppMethodBeat.o(117187);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.qq.taf.jce.HexUtil
 * JD-Core Version:    0.7.0.1
 */